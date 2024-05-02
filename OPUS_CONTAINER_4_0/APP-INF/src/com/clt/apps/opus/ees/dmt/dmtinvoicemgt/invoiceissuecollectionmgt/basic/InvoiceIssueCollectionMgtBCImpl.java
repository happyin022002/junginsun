/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBCImpl.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.BookingCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCrTermOptVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvNoVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ExchangeNTaxRateVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailAmountVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailTaxVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceMainAmountVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByBookingVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByChargeVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListDwVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
//import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InterfaceChargeCalculationVO;

/**
 * InvoiceMgt Business Logic Basic Command implementation<br>

 * @author
 * @see reference DAO of EES_DMT_4001EventResponse,InvoiceIssueCollectionMgtBC 
 * @since J2EE 1.6
 */
public class InvoiceIssueCollectionMgtBCImpl extends BasicCommandSupport implements InvoiceIssueCollectionMgtBC {

    // Database Access Object
    private transient InvoiceIssueCollectionMgtDBDAO dbDao = null;
    
    DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
    
    /**
     * InvoiceIssueCollectionMgtBCImpl Create object<br>
     * Create InvoiceIssueCollectionMgtDBDAO<br>
     */
    public InvoiceIssueCollectionMgtBCImpl() {
        dbDao = new InvoiceIssueCollectionMgtDBDAO();
    }
    /**
     * Search Invoice Create & Issue.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return List<ConfirmChargeListVO>
     * @exception EventException
     */
    public List<ConfirmChargeListVO> searchChargeInvoiceList(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        String fm_cfm_dt = "";
        String to_cfm_dt = "";
        List<ConfirmChargeListVO> confirmChargeListVOs = null;
        try {
        	fm_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getFmCfmDt(), "-", "");
        	to_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getToCfmDt(), "-", "");
        	
        	issuedInvoiceParamVO.setFmCfmDt(fm_cfm_dt);
        	issuedInvoiceParamVO.setToCfmDt(to_cfm_dt);
        	issuedInvoiceParamVO.setOfcCd(account.getOfc_cd());	
        	
            if(issuedInvoiceParamVO.getSGroupBy().equals("1")){
            	confirmChargeListVOs = dbDao.searchConfirmChargeByBooking(issuedInvoiceParamVO);        //B/L No.
            }else {
            	confirmChargeListVOs = dbDao.searchConfirmChargeByContainer(issuedInvoiceParamVO);      //CNTR No.
            }
            for(int i = 0 ; i < confirmChargeListVOs.size() ; i++) {
            	ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)confirmChargeListVOs.get(i);
            		
            	double exchangeRate = 1;
            	double invChgTotAmt = 0;
            		
            	if(!confirmChargeListVO.getBzcTrfCurrCd().equals(confirmChargeListVO.getArCurrCd())) {
	           		//xch_rate Search
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
            	//INV_AMT 
            	invChgTotAmt = exchangeRate * NumberUtils.toDouble(confirmChargeListVO.getBilAmt());
            	invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVO.getArCurrCd(), invChgTotAmt);
            		
            	confirmChargeListVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
            	confirmChargeListVO.setInvAmt(JSPUtil.toDecimalFormat(invChgTotAmt, "#.##"));
            	// 2015.03.19 append india case
            	String iss_dt ="";
            	SearchIndiaGstRateVO indiaGstRateVO = dbDao.searchIndiaGstRate(iss_dt);
            	confirmChargeListVO.setIdaExpnTaxRt(indiaGstRateVO.getIdaExpnTaxRt());
            	confirmChargeListVO.setIdaEduTaxRt(indiaGstRateVO.getIdaEduTaxRt());
            	confirmChargeListVO.setIdaHighEduTaxRt(indiaGstRateVO.getIdaHighEduTaxRt());
            	// append india case
            	
            	confirmChargeListVOs.set(i, confirmChargeListVO);
            }
        } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}    		
        return confirmChargeListVOs;
    }

    
    
    /**
     * Modify Invoice information by PartialPayment.<br>
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
                    
                    // is not Invoice Patial, Skip
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

                    
                    // ********* [SVR_ID == "EUR"] process ***********   << START >>
                    //if(chgCalcCntrVO.getSvrId().equals("EUR")) {
                        
                        if(chgCalcCntrVO.getInvDtlSeq().equals("1")) {
                            dbDao.deleteInvoiceRate(chgCalcCntrVO.getDmdtInvNo());
                        }
                        
                        // calculate over days from Free Time (get_overday_div)
                        OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                        overdayNDivParmVO.setSvrId(chgCalcCntrVO.getSvrId());
                        overdayNDivParmVO.setCntrNo(chgCalcCntrVO.getCntrNo());
                        overdayNDivParmVO.setCnmvCycNo(chgCalcCntrVO.getCntrCycNo());
                        overdayNDivParmVO.setDttCode(chgCalcCntrVO.getDmdtTrfCd());
                        overdayNDivParmVO.setLocDiv(chgCalcCntrVO.getDmdtChgLocDivCd());
                        overdayNDivParmVO.setDccSeq(chgCalcCntrVO.getChgSeq());
                        overdayNDivParmVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                        
                        //------------- DivOverDay Search -----------
                        OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
                        
                        String cntrTpszCd = dbDao.searchContainerTypeSizeByPartialPayment(overdayNDivParmVO);
                        chgCalcCntrVO.setCntrTpszCd(cntrTpszCd);
                        
                        CalculationParmVO calculationParmVO = new CalculationParmVO();
                        // if(trfAplyTpCd.equals("G")) {    // basicCalculation - Baisc Tariff
                        calculationParmVO.setSvrId(chgCalcCntrVO.getSvrId());
                        calculationParmVO.setDmdtTrfCd(chgCalcCntrVO.getDmdtTrfCd());
                        calculationParmVO.setTrfSeq(chgCalcCntrVO.getBzcTrfSeq());
                        calculationParmVO.setTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
                        calculationParmVO.setCntrts(chgCalcCntrVO.getCntrTpszCd());
                        calculationParmVO.setOverDay(chgCalcCntrVO.getFxFtOvrDys());
                        calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
                        calculationParmVO.setCurCd(chgCalcCntrVO.getBzcTrfCurrCd());
                        
                        CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
                        List<ChrgDtlVO> list = calculationAMTVO.getChrgDtlVOS();
                        
                        if(list != null && list.size() > 0) {
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
                                dmtInvRtVO.setBzcTrfGrpSeq(chgCalcCntrVO.getBzcTrfGrpSeq());
                                dmtInvRtVO.setBzcTrfRtSeq("");
                                dmtInvRtVO.setFtOvrDys(chgCalcCntrVO.getFxFtOvrDys());
                                dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder()); 
                                dmtInvRtVO.setInvRtAmt(chgCalcCntrVO.getInvChgAmt()); 
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
                        
                        if(i+1 < chargeCalculationContainerVOs.length) {
                            nextInvDtlSeq = chargeCalculationContainerVOs[i+1].getInvDtlSeq();
                        }
                        
                        //  change Container No,  case in exist Discount Amount,  Insert
                        if(!chgCalcCntrVO.getInvDtlSeq().equals(nextInvDtlSeq)) {
                            
                            double aftExptDcAmt = 0.0d;
                            double scRfaExptAmt = 0.0d;
                            
                            aftExptDcAmt = NumberUtils.toDouble(chgCalcCntrVO.getAftExptDcAmt(), 0.0d);
                            scRfaExptAmt = NumberUtils.toDouble(chgCalcCntrVO.getScRfaExptAmt(), 0.0d);
                            
                            
                            if(aftExptDcAmt + scRfaExptAmt != 0) {
                                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
                                
                                aftExptDcAmt = 0 - (aftExptDcAmt + scRfaExptAmt);   /*  (-) Charge  */
                                dmtInvRtVO.setSvrId(chgCalcCntrVO.getSvrId());
                                dmtInvRtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
                                dmtInvRtVO.setInvDtlSeq(chgCalcCntrVO.getInvDtlSeq());
                                dmtInvRtVO.setInvRtSeq("");
                                dmtInvRtVO.setBzcDmdtTrfCd("");
                                dmtInvRtVO.setBzcTrfSeq("");
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
                        
                        // ******** InvoiceDetailListVO Loop  - START *********
                        for(int m=0; m < invDtlListVOs.size(); m++) {
                            InvoiceDetailListVO invDtlVO = invDtlListVOs.get(m);
                            
                            orgChgAmt = NumberUtils.toDouble(invDtlVO.getOrgChgAmt(), 0.0d);
                            scRfaExptAmt = NumberUtils.toDouble(invDtlVO.getScRfaExptAmt(), 0.0d);
                            aftExptDcAmt = NumberUtils.toDouble(invDtlVO.getAftExptDcAmt(), 0.0d);
                            bilAmt = NumberUtils.toDouble(invDtlVO.getBilAmt(), 0.0d);
                            
                            // Search Summary amount
                            sumOrgChgAmt += orgChgAmt;
                            sumScRfaExptAmt += scRfaExptAmt;
                            sumAftExptDcAmt += aftExptDcAmt;
                            sumBilAmt += bilAmt;
                            
                            // Invoice amount
                            cntrInvAmt = bilAmt * invXchRt;
                            
                            // Trim Amount :   decimal place of Amount by Currency
                            invCurrCd = invDtlVO.getInvCurrCd();
                            cntrInvAmt = dmtCalculationUtil.trimCurrencyAmount(invCurrCd, cntrInvAmt);
                            
                            // Invoice Summary amount
                            invChgAmt += cntrInvAmt;
                            
                            InvoiceDetailAmountVO invDtlAmtVO = new InvoiceDetailAmountVO();
                            invDtlAmtVO.setCntrInvAmt(String.valueOf(cntrInvAmt));
                            invDtlAmtVO.setDmdtInvNo(chgCalcCntrVO.getDmdtInvNo());
                            invDtlAmtVO.setInvDtlSeq(invDtlVO.getInvDtlSeq());
                            
                            dbDao.modifyInvoiceDetailAmountByPartialPayment(invDtlAmtVO);
                        }
                        // ******** InvoiceDetailListVO Loop  - END *********
                        
                        double taxAmt = 0.0d;
                        double taxRto = NumberUtils.toDouble(exchgNTaxRateVO.getTaxRto(), 0.0d);
                        
                        taxAmt = invChgAmt * taxRto;
                        taxAmt = dmtCalculationUtil.trimCurrencyAmount(invCurrCd, taxAmt);
                        
                        // [Invoice amount + Tax amount]
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
                    //}
                    // ********* [SVR_ID == "EUR"] ***********   << END >>
                    
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
     * Search Invoice Create & Issue.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param SignOnUserAccount account
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchChargeInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO, SignOnUserAccount account) throws EventException {
        InvoiceIssueMgtVO invoiceIssueMgtVO     = new InvoiceIssueMgtVO();
        List<InvoiceIssueVO> invoiceIssueList   = null;
        
//        List<VVDCheckDataVO> vVDCheckDataList   = null;
//        VVDNEtaVO vVDNEtaVO                     = new VVDNEtaVO();
        
        List<ChargeBookingInvoiceVO> chargeBookingInvoiceList = null;
        
        String curr_ofc_date = "";
        
        try {
        	//curr_ofc_date = dbDaoCommon.searchCurrentDateByOffice(account.getOfc_cd());
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
            
            //no Payer
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
            
            
            List<BookingCustomerVO> bookingCustomerList = null;
            
            // searchBookingCustomer 
            BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
            BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
            
            inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
            
            // searchBookingCustomer Search
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

				chargeBookingInvoiceVO.setCustCdS(bookingCustomerList.get(0).getCustCdS());
				chargeBookingInvoiceVO.setCustNmS(bookingCustomerList.get(0).getCustNmS());
				chargeBookingInvoiceVO.setCustCdN(bookingCustomerList.get(0).getCustCdN());
				chargeBookingInvoiceVO.setCustNmN(bookingCustomerList.get(0).getCustNmN());
				chargeBookingInvoiceVO.setCustCdC(bookingCustomerList.get(0).getCustCdC());
				chargeBookingInvoiceVO.setCustNmC(bookingCustomerList.get(0).getCustNmC());
				chargeBookingInvoiceVO.setCustCdA(bookingCustomerList.get(0).getCustCdA());
				chargeBookingInvoiceVO.setCustNmA(bookingCustomerList.get(0).getCustNmA());
				chargeBookingInvoiceVO.setCustCdF(bookingCustomerList.get(0).getCustCdF());
				chargeBookingInvoiceVO.setCustNmF(bookingCustomerList.get(0).getCustNmF());
            }
            // searchSheetOption
            SheetOptionVO iSheetOptionVO = new SheetOptionVO();
            iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
            iSheetOptionVO.setOfcCd(issuedInvoiceParamVO.getOfcCd());			//session office
            
            List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);
//log.debug("\n--------------------------------1-5--------------------------");         
            // if is not exist, then set Due Date = current date, Credit Term = 0 .
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(curr_ofc_date);//current date
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT  L/R
            }else{
                for(int i = 0; i < listSheetOption.size() ; i++) {
                    chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT  L/R
                    
                    if(listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")) {
                    	chargeBookingInvoiceVO.setTaxRto("0");
                    }else{
                    	chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                    
                    //if sheet Option Credit Term = 0 
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//if Due Date is "Issue Date", then set  Due Date=current date,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(curr_ofc_date);
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//if Due Date is "*******", then set Due Date: ********, Credit Term: ''
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //if sheet Option Credit Term > 0 
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
    
                chargeBookingInvoiceVO.setPayerCd("");
                chargeBookingInvoiceVO.setPayerNm("");
            }else{
                for(int i = 0; i < listARActualPayer.size() ; i++) {
                    chargeBookingInvoiceVO.setActCustCd(listARActualPayer.get(i).getActCustCd());
                    chargeBookingInvoiceVO.setActCustNm(listARActualPayer.get(i).getActCustNm());
                    
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
            chargeBookingInvoiceVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));//Double format (decimal place 6 )
            
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
                
                // DivOverDay Search
                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
            	
                String trfAplyTpCd = tempInvoiceIssueVO.getDmdtTrfAplyTpCd();
				
				CalculationParmVO calculationParmVO = new CalculationParmVO();
				calculationParmVO.setDcApplRate(trfAplyTpCd);
				
			/*
				  according to Tariff Calculate Charge amount.
			    A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
			    B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
			    C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
			    D) if applied Currency different  A), B), C) 's Currency
			         1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
			         2) 1)amount round by Currency
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
	            		
	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	            	}else{
	            		firstSvrID = tempInvoiceIssueVO.getSvrId();
	            	}
					
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(tempInvoiceIssueVO.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(tempInvoiceIssueVO.getBzcTrfSeq());
					calculationParmVO.setTrfGrpSeq(tempInvoiceIssueVO.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setCurCd(tempInvoiceIssueVO.getBzcTrfCurrCd());
				
				} else if(trfAplyTpCd.equals("B")) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(tempInvoiceIssueVO.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(tempInvoiceIssueVO.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(tempInvoiceIssueVO.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(tempInvoiceIssueVO.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					
				} else if(trfAplyTpCd.equals("S")) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(tempInvoiceIssueVO.getScNo());
					calculationParmVO.setVerSeq(tempInvoiceIssueVO.getScExptVerSeq());
					calculationParmVO.setGrpSeq(tempInvoiceIssueVO.getScExptGrpSeq());
					calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
					calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
				}
				
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
	            
	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	            String rateCurrCd = calculationAMTVO.getRateCurCd();
	            double rtExchangeRate 	= 0;
	            inv_chg_tot 			= 0;
	            
	            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
	            	
	            	//Total Amt
	            	inv_chg_tot = NumberUtils.toDouble(calculationAMTVO.getTotal());
	            	
	            	//if rate CurrCd is differnet charge CurrCd, then  get charge amt multiply rateCrrCd
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
	            	
	            	
//	            	totAmt += inv_chg_tot;
	            }
	            
	            //charge total amt
	            
	            
	            
	            
	            
            	//invoice total amt
	            inv_chg_tot = exchangeRate * inv_chg_tot;
	            inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_chg_tot);
            	tempInvoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_chg_tot, "#.##"));
            	
                log.debug("---exchangeRate-->"+exchangeRate);
                log.debug("---inv_chg_tot-->"+inv_chg_tot);

                totAmt += inv_chg_tot;
            	
            	//inv_chg_tot, inv_bill_amt save
            	invoiceIssueList.set(i, tempInvoiceIssueVO);

            }
            
            //Cust. Ref information Search(2010.11.04)
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

			//Billing Amt
//			double invChgAmt = 0;
//			invChgAmt = exchangeRate * Double.parseDouble(chargeBookingInvoiceVO.getMnBilAmt());
			//invChgAmt = totAmt - dcAmt;
			
			totBillAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totBillAmt);
			//chargeBookingInvoiceVO.setInvChgAmt(String.valueOf(invChgAmt));
			chargeBookingInvoiceVO.setInvChgAmt(JSPUtil.toDecimalFormat(totBillAmt, "#.##"));


log.debug("\n--------------------------------3----------Billing amt----------------"+totBillAmt);         
            

			//D/C by Amt
			double dcAmt = 0;
			
			dcAmt = totAmt - totBillAmt;
			//dcAmt = exchangeRate * Double.parseDouble(chargeBookingInvoiceVO.getChgDcAmt());
			
			dcAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),dcAmt);
			//chargeBookingInvoiceVO.setDcAmt(String.valueOf(dcAmt));
			chargeBookingInvoiceVO.setDcAmt(JSPUtil.toDecimalFormat(dcAmt, "#.##"));
log.debug("\n--------------------4----------D/C by Amt----------------"+dcAmt);         

            //Tax Amt
            double taxAmt = 0;
            double taxRto = Double.parseDouble(chargeBookingInvoiceVO.getTaxRto());
log.debug("\n--------------------------------5----------tax_rto----------------"+taxRto);         
            
            //Vietnam
//            if(account.getCnt_cd().equals("VN")) {
//                taxAmt = (totBillAmt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
//            }else{
                taxAmt = (totBillAmt * (taxRto * 0.01)) ;
//            }
            taxAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),taxAmt);
            
log.debug("\n--------------------------------6----------tax_amt----------------"+taxAmt);         
            
            //chargeBookingInvoiceVO.setTaxAmt(String.valueOf(taxAmt));
			chargeBookingInvoiceVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));
            
            //Payable Amt
            double invAmt = 0;
            invAmt = totBillAmt + taxAmt;
            
            invAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invAmt);
            //chargeBookingInvoiceVO.setInvAmt(String.valueOf(invAmt));
            chargeBookingInvoiceVO.setInvAmt(JSPUtil.toDecimalFormat(invAmt, "#.##"));

log.debug("\n--------------------------------7-----------Payable Amt---------------"+invAmt);         
            
//log.debug("\n--------------------------------8--------------------------");         

            //Invoice Data clear
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
            

            // Mgt Setting
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
            invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);

        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006", new String[]{"IssuedInvoice"}).getUserMessage());
        } catch(Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006", new String[]{"IssuedInvoice"}).getUserMessage());
        }
        return invoiceIssueMgtVO;
        
    }

    
    /**
    * SEARCH Outstanding Inquiry by Customer N Issue .<br>
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
            throw new EventException(new ErrorHandler("DMT00006", new String[]{"SEARCH Outstanding Inquiry by Customer N Issue"}).getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
    
   /**
    * [TAB1:Search A/R Interface Status Inquiry By DMT].<br>
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
    * [TAB2:Search A/R Interface Status Inquiry By BKG]<br>
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
    * Search Invoice Interface to A/R.<br>
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
	* Search Invoice Interface to A/R. - Detail.<br>
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
     * ISSUE Invoice.<br>
     * 
     * @param InvoiceIssueMgtVO invoiceIssueMgtVO
     * @param SignOnUserAccount account
     * @return DmtInvMnVO
     * @exception EventException
     */
    public DmtInvMnVO issueInvoice(InvoiceIssueMgtVO invoiceIssueMgtVO, SignOnUserAccount account) throws EventException {
        ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
        List<InvoiceIssueVO> invoiceIssueList = null;
        DmtInvNoVO dmtInvNoVO 	= new DmtInvNoVO();
        String invoice_no 		= "";
        DmtInvMnVO dmtInvMnVO 	= new DmtInvMnVO();
        String curr_ofc_date 	= "";
        
        try{
        	//curr_ofc_date = dbDaoCommon.searchCurrentDateByOffice(account.getOfc_cd());
        	curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
        	
        	//MASTER DATA Search
            chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
        	log.debug("\n BC InvCurrCd >>>>"+chargeBookingInvoiceVO.getInvCurrCd()+"<<<<");
            
            // check madatory item :invoice_currency
            if(chargeBookingInvoiceVO.getInvCurrCd().equals("")){
            	dmtInvMnVO.setErrCode("DMT02002");
            	log.error("\n BC session office cd >>>>"+account.getOfc_cd()+"<<<<");
            	log.error("\n BC InvCurrCd >>>>"+chargeBookingInvoiceVO.getInvCurrCd()+"<<<<");
            	log.error("\n BC DMT02002 ERROR [Inv Cur. is missing !]");
            	//dmtInvMnVO.setErrMsg("Inv Cur. is missing !");
            	return dmtInvMnVO;
            }

            // makeInvoiceNo
            String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());
            log.debug("inv_pfx_cd : " + inv_pfx_cd);
            if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
            	dmtInvMnVO.setErrCode("DMT03063");
            	log.error("\n BC session office cd >>>>"+account.getOfc_cd()+"<<<<");
            	log.error("\n BC DMT03063 ERROR [Invoice Prefix code missing for your login office]");
            	//dmtInvMnVO.setErrMsg("Invoice Prefix code missing for your login office");
            	
            	return dmtInvMnVO;
            }


            //if there is no BL NO, then repace  BL NO of BKG system.
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
            
            String inv_sub_cd = "";
            String inv_max	 = "";
            if(chargeBookingInvoiceVO.getDmdtTrfCd().equals("DMIF") || chargeBookingInvoiceVO.getDmdtTrfCd().equals("DMOF")){
                inv_sub_cd = "R";
            }else if(chargeBookingInvoiceVO.getDmdtTrfCd().equals("DTIC") || chargeBookingInvoiceVO.getDmdtTrfCd().equals("CTIC")||
                    chargeBookingInvoiceVO.getDmdtTrfCd().equals("DTOC") || chargeBookingInvoiceVO.getDmdtTrfCd().equals("CTOC")){
                inv_sub_cd = "T";
            }
            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);

            inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
            
            invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");
            dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
            dmtInvNoVO.setCreUsrId(account.getUsr_id());
            dmtInvNoVO.setDmdtInvNo(invoice_no);
            dmtInvNoVO.setDmdtInvSeq(inv_max);
            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
            dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvNoVO.setUpdUsrId(account.getUsr_id());
            
            if(inv_max.equals("1")){	
         	   dbDao.createInvoiceNo(dmtInvNoVO);
            }else{
                dbDao.modifyInvoiceNo(dmtInvNoVO);
            }

            // addInvoiceMain
            dmtInvMnVO.setDmdtInvNo(invoice_no);
            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
            dmtInvMnVO.setDmdtTrfCd(chargeBookingInvoiceVO.getDmdtTrfCd());
            dmtInvMnVO.setIoBndCd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2, 3));//dmif
            dmtInvMnVO.setDmdtChgTpCd(chargeBookingInvoiceVO.getChgType());
            dmtInvMnVO.setMnlInpFlg("N");
            dmtInvMnVO.setMnlInvSndFlg("N");
            dmtInvMnVO.setMnlInvRmk("");
            dmtInvMnVO.setDmdtMnlInvRsnCd("");
            dmtInvMnVO.setBkgNo(chargeBookingInvoiceVO.getBkgNo());
            dmtInvMnVO.setBlNo(chargeBookingInvoiceVO.getBlNo());
            //if VslCd = HJXX, HJYY, HJZZ, change common VVD(CFDR+YYMM+E) 
            if(chargeBookingInvoiceVO.getVvdCd().substring(0,4).equals("HJXX") 
            		|| chargeBookingInvoiceVO.getVvdCd().substring(0,4).equals("HJYY")
            		|| chargeBookingInvoiceVO.getVvdCd().substring(0,4).equals("HJZZ")) 
            {
                dmtInvMnVO.setVslCd("CFDR");
                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
                dmtInvMnVO.setSkdDirCd("E");
            }else{
            	if(chargeBookingInvoiceVO.getVvdCd().equals(""))
            	{
	                dmtInvMnVO.setVslCd("");
	                dmtInvMnVO.setSkdVoyNo("");
	                dmtInvMnVO.setSkdDirCd("");
            	}else{
	                dmtInvMnVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
	                dmtInvMnVO.setSkdVoyNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
	                dmtInvMnVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
            	}
            }

            dmtInvMnVO.setDmdtPayrTpCd("");
        	//VENDOR
        	if(chargeBookingInvoiceVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd());
           	//CUSTOMER
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
            dmtInvMnVO.setOrgChgAmt(chargeBookingInvoiceVO.getMnOrgChgAmt());
            dmtInvMnVO.setDmdtExptAmt(chargeBookingInvoiceVO.getDmdtExptAmt());
            //dmtInvMnVO.setDcAmt(chargeBookingInvoiceVO.getDcAmt());
            dmtInvMnVO.setDcAmt(chargeBookingInvoiceVO.getChgDcAmt());	
            dmtInvMnVO.setBilAmt(chargeBookingInvoiceVO.getMnBilAmt());
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
            //dmtInvMnVO.setInvRmk(chargeBookingInvoiceVO.getInvRmk());
            dmtInvMnVO.setInvRmk1(chargeBookingInvoiceVO.getInvRmk1());
            dmtInvMnVO.setInvRmk2(chargeBookingInvoiceVO.getInvRmk2());
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
            
            log.debug(">>>>>>>>>>>>>[rd]"+chargeBookingInvoiceVO.getRd());
            
            if(!chargeBookingInvoiceVO.getRd().equals("/")) {
	            dmtInvMnVO.setRcvTermCd(chargeBookingInvoiceVO.getRd().substring(0, 1)); // Y/Y
	            dmtInvMnVO.setDeTermCd(chargeBookingInvoiceVO.getRd().substring(2));
            }
            dmtInvMnVO.setIdaExpnTaxRt(chargeBookingInvoiceVO.getIdaExpnTaxRt());
            dmtInvMnVO.setIdaExpnTax(chargeBookingInvoiceVO.getIdaExpnTax());
            dmtInvMnVO.setIdaEduTaxRt(chargeBookingInvoiceVO.getIdaEduTaxRt());
            dmtInvMnVO.setIdaEduTax(chargeBookingInvoiceVO.getIdaEduTax());
            dmtInvMnVO.setIdaHighEduTaxRt(chargeBookingInvoiceVO.getIdaHighEduTaxRt());
            dmtInvMnVO.setIdaHighEduTax(chargeBookingInvoiceVO.getIdaHighEduTax());

            dbDao.addInvoiceMain(dmtInvMnVO);
            
            //addInvoiceDetail
            invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
                InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
                
                //not checked , skip
                if(!invoiceIssueParam.getIbflag().equals("U")){
                	continue;
                }
                
                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();

                dmtInvDtlVO.setSvrId(invoiceIssueParam.getSvrId());
                dmtInvDtlVO.setCntrNo(invoiceIssueParam.getCntrNo());
                dmtInvDtlVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
                dmtInvDtlVO.setChgSeq(invoiceIssueParam.getChgSeq());
                
                //INVOICE check duplication in saving time 
                String chg_sts_cd = dbDao.searchChargeStatusCd(dmtInvDtlVO);
                
                if(chg_sts_cd.equals("I")) {	// if status is INVOICE , then  ROLLBACK and return error
                	dmtInvMnVO.setErrCode("DMT01068");//It's already invoiced. You can't [Value] it !
                	return dmtInvMnVO;
                }
                
                int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
                
                //CNTR_INV_AMT 
                double cntr_inv_amt = 0;
                cntr_inv_amt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt()) * Double.parseDouble(invoiceIssueParam.getBilAmt());
                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), cntr_inv_amt);
                //TAX_AMT 
                double tax_amt = 0;
                double tax_rto = Double.parseDouble(chargeBookingInvoiceVO.getTaxRto());
                
                //Vietnam 
//                if(account.getCnt_cd().equals("VN")) {
//                	tax_amt = (cntr_inv_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//                }else{
                    tax_amt = cntr_inv_amt * tax_rto * 0.01;
//                }
                tax_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tax_amt);
                
                
                dmtInvDtlVO.setDmdtInvNo(invoice_no);
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
                //dmtInvDtlVO.setCntrInvAmt(String.valueOf(cntr_inv_amt));
                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntr_inv_amt, "#.##"));
                dmtInvDtlVO.setTaxRto(chargeBookingInvoiceVO.getTaxRto());
                //dmtInvDtlVO.setTaxAmt(String.valueOf(tax_amt));
                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
                dmtInvDtlVO.setInvPrtFlg("");
                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
                
                dbDao.addInvoiceDetail(dmtInvDtlVO);

 
                
                

//                String ar_ofc_cd = dbDao.searchAROfficeCd(account.getOfc_cd());
//                
//    			if(!ar_ofc_cd.equals("LEHBB")) {
//    				DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//                    
//                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
//                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//                    dmtInvRtVO.setBzcTrfRtSeq("");
//                    
//                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());		//over_day
//                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());		//under_day
//                    
//                    dmtInvRtVO.setRtOvrDys(dmtInvDtlVO.getFxFtOvrDys());		//rt_day
//
//                    double inv_rt_amt = 0;
//                    double rt_ovr_chg_amt = 0;
//
//                    inv_rt_amt = Double.parseDouble(dmtInvDtlVO.getBilAmt() / dmtInvDtlVO.getFxFtOvrDys());
//                    inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), inv_rt_amt);
//                    rt_ovr_chg_amt = Double.parseDouble(dmtInvDtlVO.getBilAmt());
//                    rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), rt_ovr_chg_amt);
//                    
//                    dmtInvRtVO.setBzcCurrCd(invoiceIssueParam.getBzcTrfCurrCd());
//                    
//                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
//                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//                    
//                    dbDao.addInvoiceRate(dmtInvRtVO);
//    			}else{
                
	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	                overdayNDivParmVO.setSvrId(invoiceIssueParam.getSvrId());
	                overdayNDivParmVO.setCntrNo(invoiceIssueParam.getCntrNo());
	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueParam.getCntrCycNo());
	                overdayNDivParmVO.setDttCode(invoiceIssueParam.getDmdtTrfCd());
	                overdayNDivParmVO.setLocDiv(invoiceIssueParam.getDmdtChgLocDivCd());
	                overdayNDivParmVO.setDccSeq(invoiceIssueParam.getChgSeq());
	                
	                // ********** DivOverDay Search
	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
	                
	//-----------------------------------------
					
					CalculationParmVO calculationParmVO = new CalculationParmVO();
					
					String trfAplyTpCd = invoiceIssueParam.getDmdtTrfAplyTpCd();
					calculationParmVO.setDcApplRate(trfAplyTpCd);
					
					//only G case,	if Discount Amount + Exception Amount > 0 , Create one more data minus amount
					/*
						according to Tariff Calculate Charge amount.
					    A)if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
					*/
//					// basicCalculation - Baisc Tariff
//					calculationParmVO.setSvrId(invoiceIssueParam.getSvrId());
//					calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
//					calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
//					calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//					calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//					calculationParmVO.setOverDay(invoiceIssueParam.getOrgFtOvrDys());
//					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//					calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());
//	//bbsChargeCalulation Input
//	log.debug("\n basicCalculation.......................");				
//	log.debug("\n svr_id 		= "+invoiceIssueParam.getSvrId());				
//	log.debug("\n dmdt_trf_cd 	= "+invoiceIssueParam.getDmdtTrfCd());				
//	log.debug("\n bzc_trf_seq 	= "+invoiceIssueParam.getBzcTrfSeq());				
//	log.debug("\n bzc_trf_grp_seq = "+invoiceIssueParam.getBzcTrfGrpSeq());				
//	log.debug("\n cntr_tpsz_cd 	= "+invoiceIssueParam.getCntrTpszCd());				
//	log.debug("\n org_ft_ovr_dys = "+invoiceIssueParam.getOrgFtOvrDys());				
//	log.debug("\n div_over_day 	= "+overdayNDivVO.getDivOverDay());				
//	log.debug("\n bzc_trf_curr_cd = "+invoiceIssueParam.getBzcTrfCurrCd());				
//					
//					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);                
	                
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(invoiceIssueParam.getSvrId());
					calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
					calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//					calculationParmVO.setDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueParam.getOrgFtOvrDys());
					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());

					//bbsChargeCalulation Input
					log.debug("\n basicCalculation.......................");				
					log.debug("\n svr_id 		= "+invoiceIssueParam.getSvrId());				
					log.debug("\n dmdt_trf_cd 	= "+invoiceIssueParam.getDmdtTrfCd());				
					log.debug("\n bzc_trf_seq 	= "+invoiceIssueParam.getBzcTrfSeq());				
					log.debug("\n bzc_trf_grp_seq = "+invoiceIssueParam.getBzcTrfGrpSeq());				
					log.debug("\n cntr_tpsz_cd 	= "+invoiceIssueParam.getCntrTpszCd());				
					log.debug("\n org_ft_ovr_dys = "+invoiceIssueParam.getOrgFtOvrDys());				
					log.debug("\n div_over_day 	= "+overdayNDivVO.getDivOverDay());				
					log.debug("\n bzc_trf_curr_cd = "+invoiceIssueParam.getBzcTrfCurrCd());				
					if(trfAplyTpCd.equals("G")) {
						String firstSvrID = null;
						
						//office transfer check
				    	if(invoiceIssueParam.getOfcTrnsFlg().equals("Y")){
				    		
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
				    	}else{
				    		firstSvrID = invoiceIssueParam.getSvrId();
				    	}
						
						// basicCalculation - Baisc Tariff
						calculationParmVO.setSvrId(firstSvrID);
						calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
						calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
				//		calculationParmVO.setDmdtDeTermCd(invoiceIssueParam.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
						calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
						calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
						calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
						calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());
				//		calculationParmVO.setTrfAplyDt(invoiceIssueParam.getBzcTrfAplyDt());			// 2014.03.12
				//		if (!"".equals(invoiceIssueParam.getScRfaExptAplyDt())) {		// 2014.03.12
				//			calculationParmVO.setDmdtTrfAplyTpCd("B");									
				//			calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
				//		} else {
				//			calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
				//		}
					} else if(trfAplyTpCd.equals("B")) {
						// beforeCalculation - Before BKG Exception
						calculationParmVO.setDarNo(invoiceIssueParam.getRfaExptDarNo());
						calculationParmVO.setMapgSeq(invoiceIssueParam.getRfaExptMapgSeq());
						calculationParmVO.setVerSeq(invoiceIssueParam.getRfaExptVerSeq());
						calculationParmVO.setDtlSeq(invoiceIssueParam.getRfaRqstDtlSeq());
						calculationParmVO.setCmbSeq("1");
						calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
						calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
				//		calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt());// 2014.03.12
					} else if(trfAplyTpCd.equals("S")) {
						// scCalculation - SC Exception
						calculationParmVO.setPropNo(invoiceIssueParam.getScNo());
						calculationParmVO.setVerSeq(invoiceIssueParam.getScExptVerSeq());
						calculationParmVO.setGrpSeq(invoiceIssueParam.getScExptGrpSeq());
						calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
						calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());					
				//		calculationParmVO.setTrfAplyDt(invoiceIssueParam.getScRfaExptAplyDt());// 2014.03.12
					}
					               
				
					//bbsChargeCalulation Input
					log.debug("\n basicCalculation.......................");				
					log.debug("\n svr_id 			= "+invoiceIssueParam.getSvrId());				
					log.debug("\n dmdt_trf_cd 		= "+invoiceIssueParam.getDmdtTrfCd());				
					log.debug("\n bzc_trf_seq 		= "+invoiceIssueParam.getBzcTrfSeq());
				//	log.debug("\n dmdt_de_term_cd 	= "+invoiceIssueParam.getBzcDmdtDeTermCd());
					log.debug("\n bzc_trf_grp_seq 	= "+invoiceIssueParam.getBzcTrfGrpSeq());				
					log.debug("\n cntr_tpsz_cd 		= "+invoiceIssueParam.getCntrTpszCd());				
					log.debug("\n org_ft_ovr_dys 	= "+invoiceIssueParam.getOrgFtOvrDys());				
					log.debug("\n div_over_day 		= "+overdayNDivVO.getDivOverDay());				
					log.debug("\n bzc_trf_curr_cd 	= "+invoiceIssueParam.getBzcTrfCurrCd());
				//	log.debug("\n getFtDys 			= "+ftDys);									// 2014.03.12
				//	log.debug("\n getFmMvmtYdCd 	= "+fmMvmtYdCd);							// 2014.03.12
				//	log.debug("\n getBzcTrfAplyDt	= "+bzcTrfAplyDt);							// 2014.03.12
				//	log.debug("\n setDmdtTrfAplyTpCd= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
					
				
				//	CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);     
					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);      
					
	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	                
	                if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
	                	
	                	//addInvoiceRate
	                	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
		                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
		                    
		                    //if over_day > 0 , then save
		                    if(Double.parseDouble(chrgDtlVO.getRtDay()) == 0 ) {
		                    	continue;
		                    }
		                    
		                    DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
		                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
		                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
		                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
		                    
		                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
		                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
		                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
		                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
		                    dmtInvRtVO.setBzcTrfRtSeq("");
		                    
		                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
		                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
		                    
		                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
	
//		                    double inv_rt_amt = 0;
//		                    double rt_ovr_chg_amt = 0;
//	
//		                    inv_rt_amt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtRate());
//		                    inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), inv_rt_amt);
//		                    rt_ovr_chg_amt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtChrg());
//		                    rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), rt_ovr_chg_amt);
		                    
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
//	                double dScRfaExptAmt = Double.parseDouble(invoiceIssueParam.getExptAmt());
//	                double dAftExptDcAmt = Double.parseDouble(invoiceIssueParam.getAftExptDcAmt());
//	                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueParam.getCmdtExptAmt());
	                
//	                if( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt  > 0) {
//	                	double rt_ovr_chg_amt = 0;
//	                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
//	                
//		                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//		                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//		                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//		                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//		                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//		                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//		                dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
//		                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//		                dmtInvRtVO.setBzcTrfRtSeq("");
//		                dmtInvRtVO.setFtOvrDys("0");
//		                dmtInvRtVO.setFtUndDys("0");
//		                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) amount
//		                dmtInvRtVO.setRtOvrDys("1");
//		                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) amount
//		                dmtInvRtVO.setBzcCurrCd(invoiceIssueParam.getBzcTrfCurrCd());
//		                dmtInvRtVO.setCreUsrId(account.getUsr_id());
//		                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//		                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//		                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//		                
//		                dbDao.addInvoiceRate(dmtInvRtVO);
//	                }
                
    			}
                //}
//            }
            dmtInvMnVO.setErrCode("DMT03064");//success
            
            
            //return invoice_no;
            return dmtInvMnVO;
        } catch (DAOException ex) {
        	log.error("BC DAOException ERROR " + ex.toString());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } catch (Exception de) {
            log.error("BC Exception ERROR " + de.toString());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    }       
       
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) .<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO>
    * @exception EventException
    */
    public List<OtsInquiryByDetialVO> searchOTSInquiryByDetailList ( OtsInquiryParmVO otsInquiryParmVO ) throws EventException {
        try {
            return dbDao.searchOTSInquiryByDetailList ( otsInquiryParmVO );
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00006").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
 			throw new EventException(ex.getMessage(),ex);
 		}
    }
    
    /**
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) .<br>
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
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) REMARK .<br>
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
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) REMARK .<br>
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
    * Search Outstanding Inquiry by Customer N Issue - Detail(s) REMARK .<br>
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
     * Search Invoice Create & Issue(after Invoice Issue).<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
		InvoiceIssueMgtVO invoiceIssueMgtVO		= new InvoiceIssueMgtVO();
		List<InvoiceIssueVO> invoiceIssueList	= null;
		
		List<ChargeBookingInvoiceVO> chargeBookingInvoiceList = null;
		
		try {
			// searchChargeBookingInvoice
			chargeBookingInvoiceList = dbDao.searchBookingInvoice(issuedInvoiceParamVO);
			ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
			
			for( int i = 0 ; i < chargeBookingInvoiceList.size() ; i++) {
				chargeBookingInvoiceVO = (ChargeBookingInvoiceVO)chargeBookingInvoiceList.get(i);
				//chargeBookingInvoiceVO.setCustCntcPntSeq(StringUtil.defaultString(chargeBookingInvoiceVO.getCustCntcPntSeq()));
				chargeBookingInvoiceVO.setCustCntcPntSeq(StringUtils.defaultString(chargeBookingInvoiceVO.getCustCntcPntSeq(), "0"));
			}
			
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
			
			chargeBookingInvoiceVO.setPayerCd(StringUtils.defaultString(rePayerNameVO.getCustCd()));
			chargeBookingInvoiceVO.setPayerNm(StringUtils.defaultString(rePayerNameVO.getCustName()));
				
			List<BookingCustomerVO> bookingCustomerList = null;
			
			// searchBookingCustomer 
			BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
			BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
			
			inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
			
			// searchBookingCustomer Search
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
				
				chargeBookingInvoiceVO.setCustCdS(bookingCustomerList.get(0).getCustCdS());
				chargeBookingInvoiceVO.setCustNmS(bookingCustomerList.get(0).getCustNmS());
				chargeBookingInvoiceVO.setCustCdN(bookingCustomerList.get(0).getCustCdN());
				chargeBookingInvoiceVO.setCustNmN(bookingCustomerList.get(0).getCustNmN());
				chargeBookingInvoiceVO.setCustCdC(bookingCustomerList.get(0).getCustCdC());
				chargeBookingInvoiceVO.setCustNmC(bookingCustomerList.get(0).getCustNmC());
				chargeBookingInvoiceVO.setCustCdA(bookingCustomerList.get(0).getCustCdA());
				chargeBookingInvoiceVO.setCustNmA(bookingCustomerList.get(0).getCustNmA());
				chargeBookingInvoiceVO.setCustCdF(bookingCustomerList.get(0).getCustCdF());
				chargeBookingInvoiceVO.setCustNmF(bookingCustomerList.get(0).getCustNmF());
			}
			// searchSheetOption
			SheetOptionVO iSheetOptionVO = new SheetOptionVO();
			iSheetOptionVO.setDmdtTrfCd(issuedInvoiceParamVO.getSDmdtTrfCd());
			iSheetOptionVO.setOfcCd(chargeBookingInvoiceVO.getCreOfcCd());		//after invoice  cre_ofc_cd
			
			List<SheetOptionVO> listSheetOption = dbDao.searchSheetOption(iSheetOptionVO);

            // if is not exists, then set  Due Date = current date, Credit Term = 0 .
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());//Issue date
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT  L/R
            }else{
                for(int i = 0; i < listSheetOption.size() ; i++) {
                    chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT  L/R
                    
                    if(listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")){
                    	chargeBookingInvoiceVO.setTaxRto("0");
                    }else{
                    	chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                    
                    //if sheet Option Credit Term = 0 
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//if Due Date is "Issue Date", then set Due Date=current date,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//if Due Date is "*******", then set Due Date: ********, Credit Term: ''
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //if sheet Option Credit Term > 0 
                    }else if(!chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	String due_date = DateTime.addDays(chargeBookingInvoiceVO.getIssueDay(), Integer.parseInt(chargeBookingInvoiceVO.getCrTermDys()));
                    	chargeBookingInvoiceVO.setDueDate(due_date);
                    }
                }
            }
			
//			if(listSheetOption == null || listSheetOption.size() == 0) {
//				chargeBookingInvoiceVO.setIssDtPrnFlg("");
//				chargeBookingInvoiceVO.setCrTermDys("");
//				chargeBookingInvoiceVO.setTaxRto("0");
//				chargeBookingInvoiceVO.setBilToLocDivCd("");
//			}else{
//				for(int i = 0; i < listSheetOption.size() ; i++) {
//					chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
//					chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
//					chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
//					chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());
//				}
//			}
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
			}else{
				// searchServiceProviderName
				VendorNameVO vendorNameVO = dbDao.searchServiceProviderName(chargeBookingInvoiceVO.getTruckerCd());
				
				chargeBookingInvoiceVO.setTruckerNm(vendorNameVO.getVndrNm());
			}
			
			//INV OVER DAY CALC
			int inv_over_day = 0;
			String issue_day 	= chargeBookingInvoiceVO.getIssueDay();	//invoice Create date
			String today 		= DateTime.getShortDateString();		//current date
			String ar_if_day	= JSPUtil.replace(chargeBookingInvoiceVO.getArIfDt(), "-","");
//			log.debug("\n[issue_day]"+issue_day);
//			log.debug("\n[today]"+today);
//			log.debug("\n[ar_if_day]"+ar_if_day);
//			log.debug("\n[today - issue_day]"+DateTime.daysBetween(issue_day, today));
			
			if(ar_if_day == null || ar_if_day.equals("")) {
				inv_over_day = DateTime.daysBetween(issue_day, today);
			}else{
				if(DateTime.daysBetween(issue_day, ar_if_day) > 0) {
					inv_over_day = DateTime.daysBetween(issue_day, today);
				}else{
					inv_over_day = DateTime.daysBetween(issue_day, ar_if_day);
				}
			}
//			log.debug("\n[inv_over_day]"+inv_over_day);
			chargeBookingInvoiceVO.setOverDay(String.valueOf(inv_over_day));

            //Total Amt
            double totAmt = 0;			//tot_amt
            //double totBillAmt = 0;		//tot_bill_amt
            double inv_bill_amt = 0;
            double inv_chg_tot = 0;
            //chg_dc_amt	-- 2010.04.30
            double chg_dc_amt = 0;
			
			//case in Cancel, Credit Note, Search invoice data because of no charge data .
			if(chargeBookingInvoiceVO.getDmdtInvStsCd().equals("X") || chargeBookingInvoiceVO.getDmdtInvStsCd().equals("C")){
				invoiceIssueList = dbDao.searchInvoiceCancelDetail(chargeBookingInvoiceVO);
				
				for(int i= 0; i < invoiceIssueList.size() ; i++) {
					InvoiceIssueVO tempInvoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
	            	//invoice charge amt
	            	inv_bill_amt = NumberUtils.toDouble(chargeBookingInvoiceVO.getInvXchRt()) * NumberUtils.toDouble(tempInvoiceIssueVO.getBilAmt());
	            	inv_bill_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_bill_amt);
	            	tempInvoiceIssueVO.setInvBillAmt(JSPUtil.toDecimalFormat(inv_bill_amt, "#.##"));
	            	
	            	tempInvoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_bill_amt, "#.##"));

	                totAmt += inv_bill_amt;
	                
	                //chg_dc_amt sum
	                chg_dc_amt += NumberUtils.toDouble(tempInvoiceIssueVO.getAftExptDcAmt());
	            	
	            	//inv_chg_tot, inv_bill_amt save
	            	invoiceIssueList.set(i, tempInvoiceIssueVO);	            
				}
				
			}else{
			
				// searchInvoiceDetail
				invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
				
//				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
	            
	            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
	            
	            for(int i= 0; i < invoiceIssueList.size() ; i++) {
	            	InvoiceIssueVO tempInvoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
	            	
	            	//invoice charge amt
	            	inv_bill_amt = NumberUtils.toDouble(chargeBookingInvoiceVO.getInvXchRt()) * NumberUtils.toDouble(tempInvoiceIssueVO.getBilAmt());
	            	inv_bill_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_bill_amt);
	            	tempInvoiceIssueVO.setInvBillAmt(JSPUtil.toDecimalFormat(inv_bill_amt, "#.##"));
	            	
	            	//totBillAmt += inv_bill_amt;
	            	
	            	OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	                overdayNDivParmVO.setSvrId(tempInvoiceIssueVO.getSvrId());
	                overdayNDivParmVO.setCntrNo(tempInvoiceIssueVO.getCntrNo());
	                overdayNDivParmVO.setCnmvCycNo(tempInvoiceIssueVO.getCntrCycNo());
	                overdayNDivParmVO.setDttCode(tempInvoiceIssueVO.getDmdtTrfCd());
	                overdayNDivParmVO.setLocDiv(tempInvoiceIssueVO.getDmdtChgLocDivCd());
	                overdayNDivParmVO.setDccSeq(tempInvoiceIssueVO.getChgSeq());
	                
	                // DivOverDay Search
	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);  
	                
	                String trfAplyTpCd = tempInvoiceIssueVO.getDmdtTrfAplyTpCd();
					
					CalculationParmVO calculationParmVO = new CalculationParmVO();
					calculationParmVO.setDcApplRate(trfAplyTpCd);
					
					/*
        				  according to Tariff Calculate Charge amount.
        			    A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
        			    B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
        			    C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
        			    D) if applied Currency different  A), B), C) 's Currency
        			         1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
        			         2) 1)amount round by Currency
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
		            		
		            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
		            	}else{
		            		firstSvrID = tempInvoiceIssueVO.getSvrId();
		            	}
						
						// basicCalculation - Baisc Tariff
						calculationParmVO.setSvrId(firstSvrID);
						calculationParmVO.setDmdtTrfCd(tempInvoiceIssueVO.getDmdtTrfCd());
						calculationParmVO.setTrfSeq(tempInvoiceIssueVO.getBzcTrfSeq());
						calculationParmVO.setTrfGrpSeq(tempInvoiceIssueVO.getBzcTrfGrpSeq());
						calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
						calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
						calculationParmVO.setCurCd(tempInvoiceIssueVO.getBzcTrfCurrCd());
					
					} else if(trfAplyTpCd.equals("B")) {
						// beforeCalculation - Before BKG Exception
						calculationParmVO.setDarNo(tempInvoiceIssueVO.getRfaExptDarNo());
						calculationParmVO.setMapgSeq(tempInvoiceIssueVO.getRfaExptMapgSeq());
						calculationParmVO.setVerSeq(tempInvoiceIssueVO.getRfaExptVerSeq());
						calculationParmVO.setDtlSeq(tempInvoiceIssueVO.getRfaRqstDtlSeq());
						calculationParmVO.setCmbSeq("1");
						calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
						calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
						
					} else if(trfAplyTpCd.equals("S")) {
						// scCalculation - SC Exception
						calculationParmVO.setPropNo(tempInvoiceIssueVO.getScNo());
						calculationParmVO.setVerSeq(tempInvoiceIssueVO.getScExptVerSeq());
						calculationParmVO.setGrpSeq(tempInvoiceIssueVO.getScExptGrpSeq());
						calculationParmVO.setCntrts(tempInvoiceIssueVO.getCntrTpszCd());
						calculationParmVO.setOverDay(tempInvoiceIssueVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					}
					
					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
//					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
					
		            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
		            String rateCurrCd = calculationAMTVO.getRateCurCd();
		            double rtExchangeRate 	= 0;
		            inv_chg_tot 			= 0;
		            
		            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
		            	
		            	//Total Amt
		            	inv_chg_tot = NumberUtils.toDouble(calculationAMTVO.getTotal());
		            	//if rate CurrCd is differnet charge CurrCd, then  get charge amt multiply rateCrrCd
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
		                    exchangeRateParmVO.setOfcCd(tempInvoiceIssueVO.getChgOfcCd());			//charge office
		                    log.debug("---VSLCD -->"+chargeBookingInvoiceVO.getVvdCd().substring(0,4));
		                    log.debug("---SKDVOYAGENO -->"+chargeBookingInvoiceVO.getVvdCd().substring(4,8));
		                    log.debug("---SKDDIRCD -->"+chargeBookingInvoiceVO.getVvdCd().substring(8));
		                    log.debug("---IOBND -->"+chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
		                    log.debug("---POLLOC -->"+chargeBookingInvoiceVO.getPolCd());
		                    log.debug("---PODLOC -->"+chargeBookingInvoiceVO.getPolCd());
		                    log.debug("---FMCURCD -->"+rateCurrCd);
		                    log.debug("---TOCURCD -->"+chargeBookingInvoiceVO.getChgCurrCd());
		                    log.debug("---OFCCD -->"+tempInvoiceIssueVO.getChgOfcCd());
		                    
		                    rtExchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
		            		
		                    inv_chg_tot = rtExchangeRate * inv_chg_tot;
		                    inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd,inv_chg_tot);
		                    
		                    log.debug("---rate Currency -->"+rateCurrCd);
		                    log.debug("---rate Exchange Rate-->"+rtExchangeRate);
		                    log.debug("---org_chg_tot-->"+inv_chg_tot);
		            	}
		            	
		            	
	//	            	totAmt += inv_chg_tot;
		            }
		            
	            	//invoice total amt
		            inv_chg_tot = NumberUtils.toDouble(chargeBookingInvoiceVO.getInvXchRt())  * inv_chg_tot;
		            inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_chg_tot);
	            	tempInvoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_chg_tot, "#.##"));
	            	
	                log.debug("---exchangeRate-->"+NumberUtils.toDouble(chargeBookingInvoiceVO.getInvXchRt()) );
	                log.debug("---inv_chg_tot-->"+inv_chg_tot);
	
	                totAmt += inv_chg_tot;
	                
	                //chg_dc_amt sum
	                chg_dc_amt += NumberUtils.toDouble(tempInvoiceIssueVO.getAftExptDcAmt());
	            	
	            	//inv_chg_tot, inv_bill_amt save
	            	invoiceIssueList.set(i, tempInvoiceIssueVO);	            
	            }
	            
			}
            totAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totAmt);
			chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(totAmt, "#.##"));		//tot_amt calc
log.debug("\n--------------------------------2------Total Amt--------------------"+totAmt);         

			//Billing Amt
//			double invChgAmt = 0;
//			invChgAmt = exchangeRate * Double.parseDouble(chargeBookingInvoiceVO.getMnBilAmt());
			//invChgAmt = totAmt - dcAmt;
			
			//totBillAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totBillAmt);
			//chargeBookingInvoiceVO.setInvChgAmt(String.valueOf(invChgAmt));
			//chargeBookingInvoiceVO.setInvChgAmt(JSPUtil.toDecimalFormat(totBillAmt, "#.##"));


log.debug("\n--------------------------------3----------Billing amt----------------"+NumberUtils.toDouble(chargeBookingInvoiceVO.getInvChgAmt()));         
            

			//D/C by Amt
			double dcAmt = 0;
			
			dcAmt = totAmt - NumberUtils.toDouble(chargeBookingInvoiceVO.getInvChgAmt());
			
			dcAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),dcAmt);
			
			chargeBookingInvoiceVO.setDcAmt(JSPUtil.toDecimalFormat(dcAmt, "#.##"));		//dc_amt calc
			
			//CHG_DC_AMT
			chg_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),chg_dc_amt);

			chargeBookingInvoiceVO.setChgDcAmt(JSPUtil.toDecimalFormat(chg_dc_amt, "#.##"));		//chg_dc_amt calc
			
//			double tot_amt = 0;
//			//tot_amt
//			double inv_dc_amt = 0;
//			
//			log.debug("--------------1------------");
//			
//			double inv_xch_rt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt());
//			
//			log.debug("--------------2------------");
//			inv_dc_amt = inv_xch_rt * Double.parseDouble(chargeBookingInvoiceVO.getDcAmt());
//			log.debug("--------------3------------");
//			inv_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), inv_dc_amt);
//			
//			chargeBookingInvoiceVO.setDcAmt(JSPUtil.toDecimalFormat(inv_dc_amt, "#.##"));
//			
//			log.debug("--------------4------------");
//			tot_amt = inv_dc_amt + Double.parseDouble(chargeBookingInvoiceVO.getInvChgAmt());
//			log.debug("--------------5------------");
//			tot_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tot_amt);
//			
//			//chargeBookingInvoiceVO.setTotAmt(String.valueOf(tot_amt));
//			chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(tot_amt, "#.##"));
			
			// Mgt Setting
			invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
			invoiceIssueMgtVO.setInvoiceIssueList(invoiceIssueList);

		} catch(DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Invoice Creation & Issue - Booking"}).getMessage()); 
		} catch(Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00006", new String[]{"Invoice Creation & Issue - Booking"}).getMessage()); 
		}
		return invoiceIssueMgtVO;    	   
    }

    
    /**
     *  Modify Invoice Create & Issue.<br>
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
        
        try{
            chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            dmtInvMnVO.setDmdtInvNo(chargeBookingInvoiceVO.getDmdtInvNo());
            dmtInvMnVO.setCreOfcCd(chargeBookingInvoiceVO.getCreOfcCd());

        	//VENDOR 
        	if(chargeBookingInvoiceVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd());
        	//CUSTOMER 
        	}else{
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
            
            dmtInvMnVO.setErrCode("0");	//sucess
            dbDao.modifyInvoice(dmtInvMnVO);
            
            //Search detail information
            
            
            //update detail information.(taxinformation)//TaxRto
            //List<InvoiceIssueVO> searchInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO)
            IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
            issuedInvoiceParamVO.setSInvoiceNo(chargeBookingInvoiceVO.getDmdtInvNo());
            issuedInvoiceParamVO.setOfcCd(chargeBookingInvoiceVO.getCreOfcCd());
            
            list = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
            
            if(list != null && list.size() > 0) {
            	for(int i = 0 ; i < list.size() ; i++) {
            		InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)list.get(i);
            		
            		//calculate
            		InvoiceDetailTaxVO invoiceDetailTaxVO = new InvoiceDetailTaxVO();
            		invoiceDetailTaxVO.setInvoiceNo(chargeBookingInvoiceVO.getDmdtInvNo());
            		invoiceDetailTaxVO.setCreOfcCd(chargeBookingInvoiceVO.getCreOfcCd());
            		invoiceDetailTaxVO.setInvDtlSeq(invoiceIssueVO.getRtDtlGrp());
            		invoiceDetailTaxVO.setDtlTaxRto(chargeBookingInvoiceVO.getTaxRto());
            		
            		double tax_amt = dbDao.searchInvoiceDetailTaxAmt(invoiceDetailTaxVO);	//tax_amt 
            		tax_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tax_amt);
            		
            		invoiceDetailTaxVO.setDtlTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
            		
            		dbDao.modifyInvoiceDetailByInvoiceMain(invoiceDetailTaxVO, account);	//Invoice Detail (tax_rto, tax_amt) Modify
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
     * Search Exchange Rate .<br>
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
    * Search Remark(s).<br>
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
    * Search OTS Remark(s). <br>
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
    * update Remark(s).<br>
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
    * update OTS Remark(s).<br>
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
     * Search Tax Ratio information by Office <br>
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
    * Search Sheet Option.<br>
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
    * Sheet Option. [DELETE/INSERT] .<br>
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
    * Search Sheet Setting Screen target.<br>
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
    * [Sheet Setting Screen] [DELETE/INSERT] .<br>
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
    * [Sheet Setting Screen] [DELETE] .<br>
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
     * Create Group Invoice
     * @param InvoiceGroupParamVO invoiceGroupParamVO
     * @param ConfirmChargeListVO[] confirmChargeListVOs
     * @param SignOnUserAccount account
     * @return InvoiceGroupMgtVO
     * @throws EventException
     */
    public InvoiceGroupMgtVO issueInvoiceByGroup(InvoiceGroupParamVO invoiceGroupParamVO,ConfirmChargeListVO[] confirmChargeListVOs, SignOnUserAccount account) throws EventException {
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
    	DmtInvNoVO dmtInvNoVO = new DmtInvNoVO();
    	
    	String curr_ofc_date 	= "";
    	
    	try {
    		//curr_ofc_date = dbDaoCommon.searchCurrentDateByOffice(account.getOfc_cd());//current date
    		curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());//current date
    		
    		log.debug("s_group_by==>"+invoiceGroupParamVO.getSGroupBy());
    		
    		if(invoiceGroupParamVO.getSGroupBy().equals("1")){//Group by (B/L No(BKG No))
    		
	    		for(int i = 0; i < confirmChargeListVOs.length; i++) {
	        		log.debug("confirmChargeListVOs check_box["+i+"]==>"+confirmChargeListVOs[i].getCheckBox());
	    			//if there is no checked CheckBox , do not save.
	        		

		    	    //if there is no BL NO, repace  BL NO of BKG system.
		    
		    		if(confirmChargeListVOs[i].getBlNo().equals("")){
		    		    String bl_no = dbDao.searchBKGBlNo(confirmChargeListVOs[i].getBkgNo());
		    		       if(bl_no == null || bl_no.equals("")) {
		    		          reInvoiceGroupParamVO.setErrCode("DMT01152");
		    		          log.error("\n BC bkg_no >>>>"+confirmChargeListVOs[i].getBkgNo()+"<<<<");
		               		  log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
		    		       }else{
		    		        	 confirmChargeListVOs[i].setBlNo(bl_no);
		    		       }
		    		  }	
		    		   
		    	  if(!confirmChargeListVOs[i].getBlNo().equals("")){  
		    		   
	    			if(confirmChargeListVOs[i].getCheckBox().equals("0")) {
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
	    				//reConfirmChargeListVO.setChgCustCntCd(confirmChargeListVOs[i].getChgCustCntCd());
	    				//reConfirmChargeListVO.setChgCustSeq(confirmChargeListVOs[i].getChgCustSeq());
	    				
	    				reConfirmChargeListVOs.add(reConfirmChargeListVO);	// data add to list for screen.
	    				
	    				continue;
	    			}else{
	    				//Search only  CONFIRM data.
	    				//check Issued Invoice, if it's exists, then return error.
//	    				int containerCnt = dbDao.searchContainerNo(confirmChargeListVOs[i].getBkgNo(), confirmChargeListVOs[i].getDmdtTrfCd());
//	    				
//	    				//if is Invoice Create  then return error.
//	    				if(containerCnt > 0) {
//	    					//reConfirmChargeListVO.setErrCode("DMT03047");
//	    					//reConfirmChargeListVO.setErrMsg("Invoice No already Created! Pls go to detail screen to update data");
//	    					//reConfirmChargeListVOs.add(reConfirmChargeListVO);
//	    					reInvoiceGroupParamVO = new InvoiceGroupParamVO();
//	    					
//	    					reInvoiceGroupParamVO.setErrCode("DMT03047");
//	    					reInvoiceGroupParamVO.setErrMsg("Invoice No already Created! Pls go to detail screen to update data");
//
//	    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
//	    					return reInvoiceGroupMgtVO;
//	    				}
	    				
    					// makeInvoiceNo
	    				dmtInvNoVO = new DmtInvNoVO();
	    				
	    				String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());
	    				
	    				//  if there if no invoice pfx_cd, then return error
	    				if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
	    					reInvoiceGroupParamVO.setErrCode("DMT03063");
	    					reInvoiceGroupParamVO.setErrMsg("Invoice Prefix code missing for your login office");
	    					
	    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
	    					return reInvoiceGroupMgtVO;
	    	            }
	    				
	    				
	    				String inv_sub_cd = "";
	    				String inv_max	 = "";
	    				if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DMIF") || confirmChargeListVOs[i].getDmdtTrfCd().equals("DMOF")){
	    					inv_sub_cd = "R";
	    				}else if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DTIC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTIC")||
	    						confirmChargeListVOs[i].getDmdtTrfCd().equals("DTOC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTOC")){
	    					inv_sub_cd = "T";
	    				}
	    				dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	    				dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	    				inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
   
	    				invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");
   
	    				dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
	    				dmtInvNoVO.setCreUsrId(account.getUsr_id());
	    				dmtInvNoVO.setDmdtInvNo(invoice_no);
	    				dmtInvNoVO.setDmdtInvSeq(inv_max);
	    				dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	    				dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	    				dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
	    				dmtInvNoVO.setUpdUsrId(account.getUsr_id());
   
	    				if(inv_max.equals("1")){	
	    					dbDao.createInvoiceNo(dmtInvNoVO);
	    				}else{
	    					dbDao.modifyInvoiceNo(dmtInvNoVO);
	    				}	    		            
	    				
	    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
	    				//$$$$$$$$$$$  process start $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
	    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
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
	    	            
	    	            //VENDOR 
	    	            if(confirmChargeListVOs[i].getCustCd().length() <= 6) {
	    	            	//ActPayr
	    	                dmtInvMnVO.setActPayrCntCd("00");
	    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
	    	                
	    	                //Cust
	    	                dmtInvMnVO.setCustCntCd("00");
	    	                dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
	    	            //CUSTOMER 
	    	            }else{
	    	            	//ActPayr
		    	           	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
		    	            dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
		    	            
		    	            //Cust
	    	                dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
	    	                dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
	    	            }

	    	            // common vvd
	    	            if(confirmChargeListVOs[i].getVslCd().equals("HJXX") 
	    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
	    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) 
	    	            {
	    	                dmtInvMnVO.setVslCd("CFDR");
	    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
	    	                dmtInvMnVO.setSkdDirCd("E");
	    	            }else{
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
	    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
	    	            
	    	            dmtInvMnVO.setOrgChgAmt(confirmChargeListVOs[i].getOrgChgAmt());
	    	            dmtInvMnVO.setDmdtExptAmt(confirmChargeListVOs[i].getScRfaExptAmt());
	    	            dmtInvMnVO.setDcAmt(confirmChargeListVOs[i].getAftExptDcAmt());
	    	            dmtInvMnVO.setBilAmt(confirmChargeListVOs[i].getBilAmt());
	    	            dmtInvMnVO.setBkgCntrQty(confirmChargeListVOs[i].getCntrCnt());

	    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
	    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
	    	            
	    	          
	    	            dmtInvMnVO.setInvChgAmt(confirmChargeListVOs[i].getInvAmt());
	    	            dmtInvMnVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
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
	    	            // 2015.03.19 append india tax 
	    	            dmtInvMnVO.setIdaExpnTaxRt(confirmChargeListVOs[i].getIdaExpnTaxRt());
	    	            dmtInvMnVO.setIdaExpnTax(confirmChargeListVOs[i].getIdaExpnTax());
	    	            dmtInvMnVO.setIdaEduTaxRt(confirmChargeListVOs[i].getIdaEduTaxRt());
	    	            dmtInvMnVO.setIdaEduTax(confirmChargeListVOs[i].getIdaEduTax());
	    	            dmtInvMnVO.setIdaHighEduTaxRt(confirmChargeListVOs[i].getIdaHighEduTaxRt());
	    	            dmtInvMnVO.setIdaHighEduTax(confirmChargeListVOs[i].getIdaHighEduTax());
	    	            // append india tax
	    	          
	    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
	    	            
	    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
	    	            	dmtInvMnVO.setRcvTermCd("");
	    	            	dmtInvMnVO.setDeTermCd("");
	    	            }else{
	    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
	    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
	    	            }
	    	            
	    	            dbDao.addInvoiceMain(dmtInvMnVO);
	    	            inv_qty++;
	    	            issue_date = dmtInvMnVO.getCreDt();
	    	            
	    	            //// List Setting
	    	            reConfirmChargeListVO = new ConfirmChargeListVO();
	    	            
	    	            reConfirmChargeListVO.setCheckBox(confirmChargeListVOs[i].getCheckBox());
	    	            reConfirmChargeListVO.setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());			//invoice no
	    				reConfirmChargeListVO.setDmdtInvStsCd(dmtInvMnVO.getDmdtInvStsCd());
	    				reConfirmChargeListVO.setDmdtArIfCd(dmtInvMnVO.getDmdtArIfCd());
	    				
	    				reConfirmChargeListVO.setBkgNo(confirmChargeListVOs[i].getBkgNo());
	    				reConfirmChargeListVO.setBlNo(confirmChargeListVOs[i].getBlNo());
	    				//reConfirmChargeListVO.setCntrCnt(confirmChargeListVOs[i].getCntrCnt());		
	    				reConfirmChargeListVO.setCntrNo(confirmChargeListVOs[i].getCntrNo());
	    				reConfirmChargeListVO.setGb(confirmChargeListVOs[i].getGb());
	    				reConfirmChargeListVO.setOfcCd(confirmChargeListVOs[i].getOfcCd());
	    				reConfirmChargeListVO.setDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	    				reConfirmChargeListVO.setCustCd(confirmChargeListVOs[i].getCustCd());
	    				reConfirmChargeListVO.setScNo(confirmChargeListVOs[i].getScNo());
	    				reConfirmChargeListVO.setRfaNo(confirmChargeListVOs[i].getRfaNo());
	    				
	    				reConfirmChargeListVO.setArCurrCd(dmtInvMnVO.getInvCurrCd());	
	    				reConfirmChargeListVO.setInvAmt(dmtInvMnVO.getInvChgAmt());
	    				reConfirmChargeListVO.setInvTaxRto(dmtInvMnVO.getTaxRto());
	    				reConfirmChargeListVO.setInvTaxAmt(dmtInvMnVO.getTaxAmt());
	    				reConfirmChargeListVO.setInvPayableAmt(dmtInvMnVO.getInvAmt());
	    				
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
	    				
	    				
	    	            
	    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
	    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());		//charge office code
	    	            
	    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    	            
	    	            /// check dup .INVOICE 
	    	            if(invoiceIssueList == null || invoiceIssueList.size() == 0) {
	    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
	    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
    	            		message = JSPUtil.replace(message, "[Value]", "Save");
	    					reInvoiceGroupParamVO.setErrMsg(message);
	    					
	    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
	    					return reInvoiceGroupMgtVO;
	    	            }
	    	            
	    	            reConfirmChargeListVO.setCntrCnt(""+invoiceIssueList.size());		//modify real CNTR CNT 
	    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
	    	            
	    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
	    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
	    	            	
	    	            	DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();

	    	                dmtInvDtlVO.setSvrId(invoiceIssueDetail.getSvrId());
	    	                dmtInvDtlVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
	    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
	    	                dmtInvDtlVO.setChgSeq(invoiceIssueDetail.getChgSeq());

	    	            	// check dup. INVOICE 
	    	            	String chg_sts_cd = dbDao.searchChargeStatusCd(dmtInvDtlVO);

	    	            	if(chg_sts_cd.equals("I")) {	//if status is INVOICE , then  ROLLBACK and return error
		    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
		    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
	    	            		message = JSPUtil.replace(message, "[Value]", "Save");
		    					reInvoiceGroupParamVO.setErrMsg(message);
		    					
		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
		    					return reInvoiceGroupMgtVO;	    	            		
	    	            	}
	    	            	
	    	            	int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
	    	            	
	    	                //CNTR_INV_AMT
	    	                double cntr_inv_amt = 0;
	    	                cntr_inv_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
	    	                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntr_inv_amt);
	    	                
	    	                //TAX_AMT 
	    	                double tax_amt = 0;
//	    	                double tax_rto = Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto());
	    	                double tax_rto = 0;
	    	                if(account.getCnt_cd().equals("IN")) {
	    	                	tax_rto = 0;
	    	                }else{
	    	                	tax_rto = Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto());
	    	                }
	    	                
	    	                //Vietnam 
//	    	                if(account.getCnt_cd().equals("VN")) {
//	    	                	tax_amt = (cntr_inv_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
//	    	                }else{
	    	                    tax_amt = cntr_inv_amt * tax_rto * 0.01;
//	    	                }
	    	                tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), tax_amt);
	    	                
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
	    	                //dmtInvDtlVO.setCntrInvAmt(String.valueOf(cntr_inv_amt));
	    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntr_inv_amt, "#.##"));
	    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
	    	                //dmtInvDtlVO.setTaxAmt(String.valueOf(tax_amt));
	    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
	    	                dmtInvDtlVO.setInvPrtFlg("");
	    	                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
	    	                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
	    	                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
	    	                
	    	                dbDao.addInvoiceDetail(dmtInvDtlVO);
	    	                

	    	                
	    	                // ********** DivOverDay Search
	    	                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	    	                overdayNDivParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	    	                overdayNDivParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	    	                overdayNDivParmVO.setCnmvCycNo(invoiceIssueDetail.getCntrCycNo());
	    	                overdayNDivParmVO.setDttCode(invoiceIssueDetail.getDmdtTrfCd());
	    	                overdayNDivParmVO.setLocDiv(invoiceIssueDetail.getDmdtChgLocDivCd());
	    	                overdayNDivParmVO.setDccSeq(invoiceIssueDetail.getChgSeq());
	    	                
	    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
	    	                
//-----------------------------------------
	    	                CalculationParmVO calculationParmVO = new CalculationParmVO();
	    	                
	    	                String trfAplyTpCd = invoiceIssueDetail.getDmdtTrfAplyTpCd();
	    	                calculationParmVO.setDcApplRate(trfAplyTpCd);
	    	                
	    					// only G case,	if Discount Amount + Exception Amount > 0 , create another minus amount data 
	    					/*
	    						according to Tariff Calculate Charge amount.
	    					   A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
	    					*/
//    						// basicCalculation - Baisc Tariff
//    						calculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
//    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
//    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//    	//bbsChargeCalulation Input
//    	log.debug("\n basicCalculation.......................");				
//    	log.debug("\n svr_id 		= "+invoiceIssueDetail.getSvrId());				
//    	log.debug("\n dmdt_trf_cd 	= "+invoiceIssueDetail.getDmdtTrfCd());				
//    	log.debug("\n bzc_trf_seq 	= "+invoiceIssueDetail.getBzcTrfSeq());				
//    	log.debug("\n bzc_trf_grp_seq = "+invoiceIssueDetail.getBzcTrfGrpSeq());				
//    	log.debug("\n cntr_tpsz_cd 	= "+invoiceIssueDetail.getCntrTpszCd());				
//    	log.debug("\n org_ft_ovr_dys = "+invoiceIssueDetail.getOrgFtOvrDys());				
//    	log.debug("\n div_over_day 	= "+overdayNDivVO.getDivOverDay());				
//    	log.debug("\n bzc_trf_curr_cd = "+invoiceIssueDetail.getBzcTrfCurrCd());				
//    					
//							//CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
//    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);
	    	                
	    	             // basicCalculation - Baisc Tariff
//    						calculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
//    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
//    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());

    						// basicCalculation - Baisc Tariff
    						calculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//    						calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//    						calculationParmVO.setFtDys(invoiceIssueDetail.getFtDys());						// 2014.03.12
//    						calculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd());			// 2014.03.12
//    						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
//    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
    						
//    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());

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
    			            	if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")){
    			            		
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
    			            	}else{
    			            		firstSvrID = invoiceIssueDetail.getSvrId();
    			            	}
    							
    							// basicCalculation - Baisc Tariff
    							calculationParmVO.setSvrId(firstSvrID);
    							calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
    							calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//    							calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
    							calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
    							calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
//    							if (!"".equals(invoiceIssueDetail.getScRfaExptAplyDt())) {		// 2014.03.12
//    								calculationParmVO.setDmdtTrfAplyTpCd("B");									
//    								calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
//    							} else {
//    								calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
//    							}
    						} else if(trfAplyTpCd.equals("B")) {
    							// beforeCalculation - Before BKG Exception
    							calculationParmVO.setDarNo(invoiceIssueDetail.getRfaExptDarNo());
    							calculationParmVO.setMapgSeq(invoiceIssueDetail.getRfaExptMapgSeq());
    							calculationParmVO.setVerSeq(invoiceIssueDetail.getRfaExptVerSeq());
    							calculationParmVO.setDtlSeq(invoiceIssueDetail.getRfaRqstDtlSeq());
    							calculationParmVO.setCmbSeq("1");
    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
//    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
    						} else if(trfAplyTpCd.equals("S")) {
    							// scCalculation - SC Exception
    							calculationParmVO.setPropNo(invoiceIssueDetail.getScNo());
    							calculationParmVO.setVerSeq(invoiceIssueDetail.getScExptVerSeq());
    							calculationParmVO.setGrpSeq(invoiceIssueDetail.getScExptGrpSeq());
    							calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
    							calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());					
//    							calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
    						}
    						                   					    
					    	//bbsChargeCalulation Input
					    	log.debug("\n basicCalculation.......................");				
					    	log.debug("\n svr_id 		      	= "+invoiceIssueDetail.getSvrId());				
					    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueDetail.getDmdtTrfCd());				
					    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueDetail.getBzcTrfSeq());
//					    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueDetail.getBzcDmdtDeTermCd());
					    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueDetail.getBzcTrfGrpSeq());				
					    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueDetail.getCntrTpszCd());				
					    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueDetail.getOrgFtOvrDys());				
					    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
					    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueDetail.getBzcTrfCurrCd());				
					    	log.debug("\n getFtDys 				= "+invoiceIssueDetail.getFtDys());			// 2014.03.12
//							log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
//							log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
//							log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
    						

//    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);     
    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
    	
					        List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
					        
					        if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
					        	
					        	//addInvoiceRate
					        	for ( int k = 0; k < chrgDtlVOS.size() ; k++) {
					                ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
					                
					                //if over_day > 0 , then save.
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
    		                    	
    		                    	
					                
//					                double inv_rt_amt = 0;
//					                inv_rt_amt = Double.parseDouble(chrgDtlVO.getRtRate());
//					                dmtInvRtVO.setInvRtAmt(NumberUtil.format(inv_rt_amt, "#.##"));
//					                
//					                dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
//					                
//					                double rt_ovr_chg_amt = 0;
//					                rt_ovr_chg_amt = Double.parseDouble(chrgDtlVO.getRtChrg());
//					                dmtInvRtVO.setRtOvrChgAmt(NumberUtil.format(rt_ovr_chg_amt, "#.##"));
					                
					                dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
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
//					        double dScRfaExptAmt = Double.parseDouble(invoiceIssueDetail.getExptAmt());
//					        double dAftExptDcAmt = Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
//					        double dCmdtExptAmt  = Double.parseDouble(invoiceIssueDetail.getCmdtExptAmt());
//					        if( dScRfaExptAmt + dAftExptDcAmt  > 0) {
//					        	double rt_ovr_chg_amt = 0;
//					            rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
//					        
//					            DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//					            dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//					            dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//					            dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//					            dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//					            dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//					            dmtInvRtVO.setBzcTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//					            dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//					            dmtInvRtVO.setBzcTrfRtSeq("");
//					            dmtInvRtVO.setFtOvrDys("0");
//					            dmtInvRtVO.setFtUndDys("0");
//					            dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) amount
//					            dmtInvRtVO.setRtOvrDys("1");
//					            dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) amount
//					            dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
//					            dmtInvRtVO.setCreUsrId(account.getUsr_id());
//					            dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//					            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//					            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//					            
//					            dbDao.addInvoiceRate(dmtInvRtVO);
//					        }
	    	            }
	    			}
	    		}
    		}	
	    		
	    		
				//reInvoiceGroupParamVO Setting
				reInvoiceGroupParamVO = new InvoiceGroupParamVO();
	    		
				reInvoiceGroupParamVO.setInvQty(String.valueOf(inv_qty));
				reInvoiceGroupParamVO.setIssueDate(issue_date);
				reInvoiceGroupParamVO.setErrCode("");
				reInvoiceGroupParamVO.setErrMsg("");

	    		
	    		
	    	//Search by Cntr No
    		}else{
	    		
	            //variables
	            double tot_org_chg_amt 		= 0;	//Charge Incurrend AMT
	            double tot_sc_rfa_expt_amt 	= 0;	//Charge Exception AMT
	            double tot_aft_expt_dc_amt 	= 0;	//Charge D/C AMT
	            double tot_bil_amt 			= 0;	//Charge Billable AMT
	            double tot_inv_amt 			= 0;	//Invoice Billing AMT
	            double tot_inv_tax_rto 		= 0;	//Invoice Tax(%)
	            double tot_inv_tax_amt 		= 0;	//Invoice Tax AMT
	            double tot_inv_payable_amt 	= 0;	//Invoice Payable AMT
	            int cntr_cnt 	= 0;
	            
	            int sel_cntr	= 0;	// count of selcted cntr
	            
    			for(int i = 0; i < confirmChargeListVOs.length; i++) {
    				
		    		//if there is no BL NO, then repace  BL NO of BKG system.
    				
		    		if(confirmChargeListVOs[i].getBlNo().equals("")){
		    		   String bl_no = dbDao.searchBKGBlNo(confirmChargeListVOs[i].getBkgNo());
		    		    if(bl_no == null || bl_no.equals("")) {
		    		        reInvoiceGroupParamVO.setErrCode("DMT01152");
		    		        log.error("\n BC bkg_no >>>>"+confirmChargeListVOs[i].getBkgNo()+"<<<<");
		              	    log.error("\n BC DMT01152 ERROR [There is no B/L No.]");
		    		       }else{
		    		        	 confirmChargeListVOs[i].setBlNo(bl_no);
		    		    }
		    	    }	    				
    				
		    	  if(!confirmChargeListVOs[i].getBlNo().equals("")){  
	    			//if there is no checked CheckBox , do not save.
	    			if(confirmChargeListVOs[i].getCheckBox().equals("0")) {
	    				
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
	    				//reConfirmChargeListVO.setChgCustCntCd(confirmChargeListVOs[i].getChgCustCntCd());
	    				//reConfirmChargeListVO.setChgCustSeq(confirmChargeListVOs[i].getChgCustSeq());
	    				
	    				reConfirmChargeListVOs.add(reConfirmChargeListVO);
	    				
	    				//continue;
	    				
	    				
	    			}else{
	    				//[ case in checked row is first row ] 
    					if(sel_cntr == 0) {
    	    				//save invoice information(except amount)
    						dmtInvNoVO = new DmtInvNoVO();

	    					String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());

		    				// if there is no invoice pfx_cd, then return error
		    				if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
		    					reInvoiceGroupParamVO.setErrCode("DMT03063");
		    					reInvoiceGroupParamVO.setErrMsg("Invoice Prefix code missing for your login office");
		    					
		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
		    					return reInvoiceGroupMgtVO;
		    				}
				
	    					
	    					String inv_sub_cd = "";
	    					String inv_max	 = "";
	    					if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DMIF") || confirmChargeListVOs[i].getDmdtTrfCd().equals("DMOF")){
	    						inv_sub_cd = "R";
	    					}else if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DTIC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTIC")||
	    							confirmChargeListVOs[i].getDmdtTrfCd().equals("DTOC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTOC")){
	    						inv_sub_cd = "T";
	    					}
	    					dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	    					dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	    					inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);

	    					invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");

	    					dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
	    					dmtInvNoVO.setCreUsrId(account.getUsr_id());
	    					dmtInvNoVO.setDmdtInvNo(invoice_no);
	    					dmtInvNoVO.setDmdtInvSeq(inv_max);
	    					dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	    					dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	    					dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
	    					dmtInvNoVO.setUpdUsrId(account.getUsr_id());

	    					if(inv_max.equals("1")){	
	    						dbDao.createInvoiceNo(dmtInvNoVO);
	    					}else{
	    						dbDao.modifyInvoiceNo(dmtInvNoVO);
	    					}
	    					
	    					//DMT_INV_MN Create
	    					//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
		    				//$$$$$$$$$$$  process start    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
		    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
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
		    	            
		    	            //VENDOR 
	    	            	if(confirmChargeListVOs[i].getCustCd().length() <= 6) {
	    	    	            //ActPayr
	    	            	    dmtInvMnVO.setActPayrCntCd("00");
	    	            	    dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
	    	            	    //cust
	    	            	    dmtInvMnVO.setCustCntCd("00");
	    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
	    	            	//CUSTOMER 
	    	            	}else{
		    	            	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
		    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
	    	            	    //cust
	    	            	    dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
	    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
	    	            	}
		    	            	
		    	            //common vvd
		    	            if(confirmChargeListVOs[i].getVslCd().equals("HJXX") 
		    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
		    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) 
		    	            {
		    	                dmtInvMnVO.setVslCd("CFDR");
		    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
		    	                dmtInvMnVO.setSkdDirCd("E");
		    	            }else{
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
		    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
		    	            
		    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
		    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
    						
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
		    	            // 2015.03.19 append india tax 
		    	            dmtInvMnVO.setIdaExpnTaxRt(confirmChargeListVOs[i].getIdaExpnTaxRt());
		    	            dmtInvMnVO.setIdaExpnTax(confirmChargeListVOs[i].getIdaExpnTax());
		    	            dmtInvMnVO.setIdaEduTaxRt(confirmChargeListVOs[i].getIdaEduTaxRt());
		    	            dmtInvMnVO.setIdaEduTax(confirmChargeListVOs[i].getIdaEduTax());
		    	            dmtInvMnVO.setIdaHighEduTaxRt(confirmChargeListVOs[i].getIdaHighEduTaxRt());
		    	            dmtInvMnVO.setIdaHighEduTax(confirmChargeListVOs[i].getIdaHighEduTax());
		    	            // append india tax
		    	            
		    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
		    	            
		    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
		    	            	dmtInvMnVO.setRcvTermCd("");
		    	            	dmtInvMnVO.setDeTermCd("");
		    	            }else{
		    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
		    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
		    	            }
		    	            
		    	            dbDao.addInvoiceMain(dmtInvMnVO);	// save invoice information except amount.
		    	            inv_qty++;
		    	            
		    	            inv_sts_cd	= dmtInvMnVO.getDmdtInvStsCd();
		    	            ar_if_cd	= dmtInvMnVO.getDmdtArIfCd();
		    	            
		    	       //// List Setting
		    	            
		    	            //if dup. INVOICE , delete Createed CNTR.
		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
		    	            
		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            
		    	            if(invoiceIssueList != null) {
			    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
			    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
		    	            	
			    	            	//Search cntr_no.
			    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
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
			    	            		
			    	            		break;
			    	            	}
			    	            }
		    	            }
		    				
		    	            //##############################################################
		    				//Summary by BKG No 
		    	            //##############################################################
		    	            //##############################################################
		    				
		    	            // variable clser
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
		    	            
		    	            //check dup.INVOICE 
		    	            if(invoiceIssueList == null || invoiceIssueList.size() == 0) {
		    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
		    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
	    	            		message = JSPUtil.replace(message, "[Value]", "Save");
		    					reInvoiceGroupParamVO.setErrMsg(message);
		    					
		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
		    					return reInvoiceGroupMgtVO;
		    	            }
		    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
		    	            	
		    	            	//Search cntr_no and adding
		    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
		    	            		DmtInvDtlVO checkVo = new DmtInvDtlVO();

		    	            		checkVo.setSvrId(invoiceIssueDetail.getSvrId());
		    	            		checkVo.setCntrNo(invoiceIssueDetail.getCntrNo());
		    	            		checkVo.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
		    	            		checkVo.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
		    	            		checkVo.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
		    	            		checkVo.setChgSeq(invoiceIssueDetail.getChgSeq());
		    	                    
		    	                    //check dup.INVOICE 
		    	                    String chg_sts_cd = dbDao.searchChargeStatusCd(checkVo);
		    	                    
		    	                    if(chg_sts_cd.equals("I")) {	//if status is INVOICE , then  ROLLBACK and return error
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
			    	            	
			    	            	//Invoice AMT
			    	            	
			    	                //INV_CHG_AMT
			    	                double temp_inv_chg_amt = 0;
			    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
			    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
			    	                tot_inv_amt			+= temp_inv_chg_amt;
			    	                
			    	                //TAX(%) Search
			    	                tot_inv_tax_rto		= Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto());

			    	                //TAX_AMT
			    	                double temp_tax_amt = 0;
			    	                
			    	                //Vietnam
//			    	                if(account.getCnt_cd().equals("VN")) {
//			    	                    temp_tax_amt = (temp_inv_chg_amt / (1 - tot_inv_tax_rto * 0.01)) * (tot_inv_tax_rto * 0.01);
//			    	                }else{
			    	                	temp_tax_amt = (temp_inv_chg_amt * (tot_inv_tax_rto * 0.01)) ;
//			    	                }
			    	                temp_tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),temp_tax_amt);
			    	                tot_inv_tax_amt		+= temp_tax_amt;
			    	                
			    	                //INV_AMT
			    	                double temp_inv_amt	= 0;
			    	                temp_inv_amt 		= temp_inv_chg_amt + temp_tax_amt;
			    	                
			    	                tot_inv_payable_amt += temp_inv_amt;
			    	                tot_inv_payable_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),tot_inv_payable_amt);
			    	                
			    	                //Cntr count
			    	                cntr_cnt++;
			    	                
			    	                break;
		    	            	}
		    	            }
		    	            
		    	            
	    					
		    	            //save dtl information.
	    					
		    				//save DMT_INV_DTL, DMT_INV_RT.
		    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
		    				issuedInvoiceParamVO = new IssuedInvoiceParamVO();
		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
		    	            
		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            
		    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
		    	            	
		    	            	// save dtl only CHECKED CNTR.
		    	            	String check_value = confirmChargeListVOs[i].getCntrNo();
		    	            	
		    	            	if(!check_value.equals(invoiceIssueDetail.getCntrNo()))
		    	            		continue;
		    	            	
		    	            	int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
		    	            	
		    	                //CNTR_INV_AMT
		    	                double cntr_inv_amt = 0;
		    	                cntr_inv_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
		    	                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntr_inv_amt);
		    	                //TAX_AMT
		    	                double tax_amt = 0;
		    	                tax_amt = Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto()) * 0.01 * cntr_inv_amt;
		    	                tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), tax_amt);
		    	                
		    	                
		    	                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
		    	                
		    	                dmtInvDtlVO.setDmdtInvNo(invoice_no);
		    	                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
		    	                dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
		    	                dmtInvDtlVO.setSvrId(invoiceIssueDetail.getSvrId());
		    	                dmtInvDtlVO.setCntrNo(invoiceIssueDetail.getCntrNo());
		    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
		    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
		    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
		    	                dmtInvDtlVO.setChgSeq(invoiceIssueDetail.getChgSeq());
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
		    	                //dmtInvDtlVO.setCntrInvAmt(String.valueOf(cntr_inv_amt));
		    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntr_inv_amt, "#.##"));
		    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
		    	                //dmtInvDtlVO.setTaxAmt(String.valueOf(tax_amt));
		    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
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
		    	                
		    	                // ********** DivOverDay Search
		    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
		    	                
		    	//-----------------------------------------

		    					CalculationParmVO calculationParmVO = new CalculationParmVO();
		    					
		    					String trfAplyTpCd = invoiceIssueDetail.getDmdtTrfAplyTpCd();
		    					calculationParmVO.setDcApplRate(trfAplyTpCd);
		    					
		    					/*
		    					  according to Tariff Calculate Charge amount.
                    			  A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
                    			  B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
                    			  C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
                    			  D) if applied Currency different  A), B), C) 's Currency
                    			       1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
                    			       2) 1)amount round by Currency

		    					*/

//	    						// basicCalculation - Baisc Tariff
//	    						String firstSvrID = null;
//	    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
//	    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//	    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
//	    						chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
//	    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
//	    						chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
//	    						chargeCalculationParmVO.setBkgNo(invoiceIssueDetail.getBkgNo());
//
//	    						// set svr_id previous in office transfer
//	    						if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")) {
//	    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
//	    						} else {
//	    							firstSvrID = invoiceIssueDetail.getSvrId();
//	    						}
//
//	    						calculationParmVO.setSvrId(firstSvrID);		
//	    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//	    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//	    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//	    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//	    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());		//org_ft_ovr_dys
//	    						//calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
//	    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//	    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//		    	//bbsChargeCalulation Input
//		    	log.debug("## basicCalculation.......................");				
//		    	log.debug("## svr_id 		= "+firstSvrID);				
//		    	log.debug("## dmdt_trf_cd 	= "+invoiceIssueDetail.getDmdtTrfCd());				
//		    	log.debug("## bzc_trf_seq 	= "+invoiceIssueDetail.getBzcTrfSeq());				
//		    	log.debug("## bzc_trf_grp_seq = "+invoiceIssueDetail.getBzcTrfGrpSeq());				
//		    	log.debug("## cntr_tpsz_cd 	= "+invoiceIssueDetail.getCntrTpszCd());				
//		    	log.debug("## org_ft_ovr_dys = "+invoiceIssueDetail.getOrgFtOvrDys());				
//		    	log.debug("## div_over_day 	= "+overdayNDivVO.getDivOverDay());				
//		    	log.debug("## bzc_trf_curr_cd = "+invoiceIssueDetail.getBzcTrfCurrCd());				
//		    					
//		    					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);                
		    	                
		    					// basicCalculation - Baisc Tariff
	    						String firstSvrID = null;
	    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
	    						chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
	    						chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	    						chargeCalculationParmVO.setBkgNo(invoiceIssueDetail.getBkgNo());
	    						chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd()); //2011.10.28

	    						// set svr_id previous in office transfer
	    						if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")) {
	    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	    						} else {
	    							firstSvrID = invoiceIssueDetail.getSvrId();
	    						}

	    						calculationParmVO.setSvrId(firstSvrID);		
	    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//	    						calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
	    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
	    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
	    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());		//org_ft_ovr_dys
	    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//	    						calculationParmVO.setFtDys(invoiceIssueDetail.getFtDys());
//	    						calculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
//	    						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
//	    						calculationParmVO.setDmdtTrfAplyTpCd("G");								// 2014.03.12
	    						
//	    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
	    							

//	    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
	    						
//	    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
		    	//bbsChargeCalulation Input
		    	log.debug("## basicCalculation.......................");				
		    	log.debug("## svr_id 		= "+firstSvrID);				
		    	log.debug("## dmdt_trf_cd 	= "+invoiceIssueDetail.getDmdtTrfCd());				
		    	log.debug("## bzc_trf_seq 	= "+invoiceIssueDetail.getBzcTrfSeq());				
		    	log.debug("## bzc_trf_grp_seq = "+invoiceIssueDetail.getBzcTrfGrpSeq());				
		    	log.debug("## cntr_tpsz_cd 	= "+invoiceIssueDetail.getCntrTpszCd());				
		    	log.debug("## org_ft_ovr_dys = "+invoiceIssueDetail.getOrgFtOvrDys());				
		    	log.debug("## div_over_day 	= "+overdayNDivVO.getDivOverDay());				
		    	log.debug("## bzc_trf_curr_cd = "+invoiceIssueDetail.getBzcTrfCurrCd());				
		    					
				if(trfAplyTpCd.equals("G")) {
//					String firstSvrID = null;
					
					//office transfer check
	            	if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")){
	            		
//	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
	            		chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
	            		chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	            		chargeCalculationParmVO.setBkgNo(invoiceIssueDetail.getBkgNo());
	            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd()); //2011.10.28
	            		
	    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	            	}else{
	            		firstSvrID = invoiceIssueDetail.getSvrId();
	            	}
					
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//					calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
					calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
//					if (!"".equals(invoiceIssueDetail.getScRfaExptAplyDt())) {		// 2014.03.12
//						calculationParmVO.setDmdtTrfAplyTpCd("B");									
//						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
//					} else {
//						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
//					}
				} else if(trfAplyTpCd.equals("B")) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(invoiceIssueDetail.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(invoiceIssueDetail.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(invoiceIssueDetail.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(invoiceIssueDetail.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
				} else if(trfAplyTpCd.equals("S")) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(invoiceIssueDetail.getScNo());
					calculationParmVO.setVerSeq(invoiceIssueDetail.getScExptVerSeq());
					calculationParmVO.setGrpSeq(invoiceIssueDetail.getScExptGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());					
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
				}
				                   					    
		    	//bbsChargeCalulation Input
		    	log.debug("\n basicCalculation.......................");				
		    	log.debug("\n svr_id 		      	= "+invoiceIssueDetail.getSvrId());				
		    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueDetail.getDmdtTrfCd());				
		    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueDetail.getBzcTrfSeq());
//		    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueDetail.getBzcDmdtDeTermCd());
		    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueDetail.getBzcTrfGrpSeq());				
		    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueDetail.getCntrTpszCd());				
		    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueDetail.getOrgFtOvrDys());				
		    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
		    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueDetail.getBzcTrfCurrCd());				
		    	log.debug("\n getFtDys 				= "+invoiceIssueDetail.getFtDys());			// 2014.03.12
//				log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
//				log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
//				log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
				

//				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);     
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
		    					
		    	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
		    	                if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
		    	                	
		    	                	//addInvoiceRate
		    	                	for ( int k = 0; k < chrgDtlVOS.size() ; k++) {
		    		                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
		    		                    
		    		                    //if over_day > 0 , then save.
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
		    		                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
		    		                    //dmtInvRtVO.setBzcTrfRtSeq("");
		    		                    
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
		    		                    dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
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
//		    	                double dScRfaExptAmt = Double.parseDouble(invoiceIssueDetail.getExptAmt());
//		    	                double dAftExptDcAmt = Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
//		    	                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueDetail.getCmdtExptAmt());
		    	                
//		    	                if( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt  > 0) {
//		    	                	double rt_ovr_chg_amt = 0;
//		    	                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
//		    	                
//		    		                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//		    		                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//		    		                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//		    		                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//		    		                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//		    		                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//		    		                dmtInvRtVO.setBzcTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//		    		                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//		    		                dmtInvRtVO.setBzcTrfRtSeq("");
//		    		                dmtInvRtVO.setFtOvrDys("0");
//		    		                dmtInvRtVO.setFtUndDys("0");
//		    		                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) amount
//		    		                dmtInvRtVO.setRtOvrDys("1");
//		    		                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) amount
//		    		                dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());				//Basic Currency
//		    		                dmtInvRtVO.setCreUsrId(account.getUsr_id());
//		    		                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//		    		                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//		    		                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//		    		                
//		    		                dbDao.addInvoiceRate(dmtInvRtVO);
//		    	                }
		    	            }//save INV_DTL, INV_RT.
		    	            
		    	        //[if checked row is beyond second ]
    					}else{
		    				// previous CNTR NO info. is not same BKG NO ....
							if(!sBkgNo.equals(confirmChargeListVOs[i].getBkgNo())) {
								//UPDATE INV_MN (calculate amount)
								DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
								dmtInvMnVO.setDmdtInvNo(invoice_no);
			    	            dmtInvMnVO.setOrgChgAmt(JSPUtil.toDecimalFormat(tot_org_chg_amt, "#.##"));
			    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(tot_sc_rfa_expt_amt, "#.##"));
			    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(tot_aft_expt_dc_amt, "#.##"));
			    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(tot_bil_amt, "#.##"));
			    	            dmtInvMnVO.setBkgCntrQty(String.valueOf(cntr_cnt));

			    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(tot_inv_amt, "#.##"));
			    	            dmtInvMnVO.setTaxRto(String.valueOf(tot_inv_tax_rto));
			    	            dmtInvMnVO.setTaxAmt(JSPUtil.toDecimalFormat(tot_inv_tax_amt, "#.##"));
			    	            dmtInvMnVO.setInvAmt(JSPUtil.toDecimalFormat(tot_inv_payable_amt, "#.##"));								
								
			    	            dbDao.modifyInvoiceMainByGroupContainer(dmtInvMnVO);	// save cumulation summary amount을.(save detail summary amount.)
								
								//get new INVOICE NO
								dmtInvNoVO = new DmtInvNoVO();
								String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());
	
			    				//if there if no invoice pfx_cd, then return error
			    				if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
			    					reInvoiceGroupParamVO.setErrCode("DMT03063");
			    					reInvoiceGroupParamVO.setErrMsg("Invoice Prefix code missing for your login office");
			    					
			    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
			    					return reInvoiceGroupMgtVO;
			    				}
		    					
		    					String inv_sub_cd = "";
		    					String inv_max	 = "";
		    					if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DMIF") || confirmChargeListVOs[i].getDmdtTrfCd().equals("DMOF")){
		    						inv_sub_cd = "R";
		    					}else if(confirmChargeListVOs[i].getDmdtTrfCd().equals("DTIC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTIC")||
		    							confirmChargeListVOs[i].getDmdtTrfCd().equals("DTOC") || confirmChargeListVOs[i].getDmdtTrfCd().equals("CTOC")){
		    						inv_sub_cd = "T";
		    					}
		    					dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
		    					dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
		    					inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
	
		    					invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");
	
		    					dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
		    					dmtInvNoVO.setCreUsrId(account.getUsr_id());
		    					dmtInvNoVO.setDmdtInvNo(invoice_no);
		    					dmtInvNoVO.setDmdtInvSeq(inv_max);
		    					dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
		    					dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
		    					dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
		    					dmtInvNoVO.setUpdUsrId(account.getUsr_id());
	
		    					if(inv_max.equals("1")){	
		    						dbDao.createInvoiceNo(dmtInvNoVO);
		    					}else{
		    						dbDao.modifyInvoiceNo(dmtInvNoVO);
		    					}
		    					
		    					//DMT_INV_MN Create
		    					//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
			    				//$$$$$$$$$$$  process start    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
			    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
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
			    	            
			    	            //VENDOR 
		    	            	if(confirmChargeListVOs[i].getCustCd().length() <= 6) {
		    	    	            //ActPayr
		    	            	    dmtInvMnVO.setActPayrCntCd("00");
		    	            	    dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd());
		    	            	    //cust
		    	            	    dmtInvMnVO.setCustCntCd("00");
		    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd());
		    	            	//CUSTOMER 
		    	            	}else{
			    	            	dmtInvMnVO.setActPayrCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
			    	                dmtInvMnVO.setActPayrSeq(confirmChargeListVOs[i].getCustCd().substring(2));
		    	            	    //cust
		    	            	    dmtInvMnVO.setCustCntCd(confirmChargeListVOs[i].getCustCd().substring(0, 2));
		    	            	    dmtInvMnVO.setCustSeq(confirmChargeListVOs[i].getCustCd().substring(2));
		    	            	}
			    	            	
			    	            //common vvd
			    	            if(confirmChargeListVOs[i].getVslCd().equals("HJXX") 
			    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJYY")
			    	            		|| confirmChargeListVOs[i].getVslCd().equals("HJZZ")) 
			    	            {
			    	                dmtInvMnVO.setVslCd("CFDR");
			    	                dmtInvMnVO.setSkdVoyNo(curr_ofc_date.substring(2,6));
			    	                dmtInvMnVO.setSkdDirCd("E");
			    	            }else{
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
			    	            dmtInvMnVO.setChgCurrCd(confirmChargeListVOs[i].getBzcTrfCurrCd());
			    	            
			    	            dmtInvMnVO.setInvCurrCd(confirmChargeListVOs[i].getArCurrCd());
			    	            dmtInvMnVO.setInvXchRt(confirmChargeListVOs[i].getInvXchRt());
	    						
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
			    	            // 2015.03.19 append india tax
			    	            dmtInvMnVO.setIdaExpnTaxRt(confirmChargeListVOs[i].getIdaExpnTaxRt());
			    	            dmtInvMnVO.setIdaExpnTax(confirmChargeListVOs[i].getIdaExpnTax());
			    	            dmtInvMnVO.setIdaEduTaxRt(confirmChargeListVOs[i].getIdaEduTaxRt());
			    	            dmtInvMnVO.setIdaEduTax(confirmChargeListVOs[i].getIdaEduTax());
			    	            dmtInvMnVO.setIdaHighEduTaxRt(confirmChargeListVOs[i].getIdaHighEduTaxRt());
			    	            dmtInvMnVO.setIdaHighEduTax(confirmChargeListVOs[i].getIdaHighEduTax());
			    	            // append india tax
			    	            
			    	            
			    	            manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(confirmChargeListVOs[i].getBkgNo());
			    	            
			    	            if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
			    	            	dmtInvMnVO.setRcvTermCd("");
			    	            	dmtInvMnVO.setDeTermCd("");
			    	            }else{
			    	            	dmtInvMnVO.setRcvTermCd(manualKeyByBookingVOS.get(0).getRcvTermCd());
			    	            	dmtInvMnVO.setDeTermCd(manualKeyByBookingVOS.get(0).getDeTermCd());
			    	            }
			    	            
			    	            
			    	            dbDao.addInvoiceMain(dmtInvMnVO);
			    	            inv_qty++;
			    	            
			    	            inv_sts_cd	= dmtInvMnVO.getDmdtInvStsCd();
			    	            ar_if_cd	= dmtInvMnVO.getDmdtArIfCd();	    					
			    	            
		    		    	    //// List Setting
			    	            // delete dup. CNTR and return.
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
			    	            
			    	            if(invoiceIssueList != null) {
				    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
				    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
			    	            	
				    	            	//Search cntr_no
				    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
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
    		    				
    		    	            //##############################################################
    		    				//Summary bt BKG No  --  cumulation 
    		    	            //##############################################################
    		    	            //##############################################################
    		    				
			    	            //clear variables
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
    		    	            
    		    	            //check dup.INVOICE 
    		    	            if(invoiceIssueList == null || invoiceIssueList.size() == 0) {
    		    	            	reInvoiceGroupParamVO.setErrCode("DMT01068");
    		    	            	String message = new ErrorHandler("DMT01068").getUserMessage();	//It's already invoiced. You can't [Value] it !
    	    	            		message = JSPUtil.replace(message, "[Value]", "Save");
    		    					reInvoiceGroupParamVO.setErrMsg(message);
    		    					
    		    					reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
    		    					return reInvoiceGroupMgtVO;
    		    	            }    		    	            
    		    	            
    		    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
    		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
    		    	            	
    		    	            	//Search cntr_no
    		    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
    		    	            		//Charge AMT
    			    	            	tot_org_chg_amt 	+= Double.parseDouble(invoiceIssueDetail.getOrgChgAmt());
    			    	            	tot_sc_rfa_expt_amt += Double.parseDouble(invoiceIssueDetail.getExptAmt());
    			    	            	tot_aft_expt_dc_amt	+= Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
    			    	            	tot_bil_amt			+= Double.parseDouble(invoiceIssueDetail.getBilAmt());
    			    	            	
    			    	            	//Invoice AMT
    			    	            	
    			    	                //INV_CHG_AMT
    			    	                double temp_inv_chg_amt = 0;
    			    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
    			    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
    			    	                tot_inv_amt			+= temp_inv_chg_amt;
    			    	                
    			    	                //TAX(%) Search
    			    	                tot_inv_tax_rto		= Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto());

    			    	                //TAX_AMT
    			    	                double temp_tax_amt = 0;
    			    	                
    			    	                //Vietnam
//    			    	                if(account.getCnt_cd().equals("VN")) {
//    			    	                    temp_tax_amt = (temp_inv_chg_amt / (1 - tot_inv_tax_rto * 0.01)) * (tot_inv_tax_rto * 0.01);
//    			    	                }else{
    			    	                	temp_tax_amt = (temp_inv_chg_amt * (tot_inv_tax_rto * 0.01)) ;
//    			    	                }
    			    	                temp_tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),temp_tax_amt);
    			    	                tot_inv_tax_amt		+= temp_tax_amt;
    			    	                
    			    	                //INV_AMT
    			    	                double temp_inv_amt	= 0;
    			    	                temp_inv_amt 		= temp_inv_chg_amt + temp_tax_amt;
    			    	                
    			    	                tot_inv_payable_amt += temp_inv_amt;
    			    	                tot_inv_payable_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),tot_inv_payable_amt);
    			    	                
    			    	                //Cntr count
    			    	                cntr_cnt++;
    			    	                
    			    	                break;
    		    	            	}
    		    	            }
    						}else{
    							// previous CNTR NO info. is not same BKG NO ... ....
    							
    							//// List Setting
			    	            // delete dup. CNTR and return
			    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
			    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
			    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
			    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
			    	            
			    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
			    	            
			    	            if(invoiceIssueList != null) {
				    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
				    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
			    	            	
				    	            	//Search cntr_no
				    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
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
    							
    							//##############################################################
    		    				//Summary bt BKG No
    		    	            //##############################################################
    		    	            //##############################################################
    		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
    		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
    		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
    		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
    		    	            
    		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
    		    	            
    		    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
    		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
    		    	            	
    		    	            	//Search cntr_no
    		    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
    		    	            		//Charge AMT
    			    	            	tot_org_chg_amt 	+= Double.parseDouble(invoiceIssueDetail.getOrgChgAmt());
    			    	            	tot_sc_rfa_expt_amt += Double.parseDouble(invoiceIssueDetail.getExptAmt());
    			    	            	tot_aft_expt_dc_amt	+= Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
    			    	            	tot_bil_amt			+= Double.parseDouble(invoiceIssueDetail.getBilAmt());
    			    	            	
    			    	            	//Invoice AMT
    			    	            	
    			    	                //INV_CHG_AMT
    			    	                double temp_inv_chg_amt = 0;
    			    	                temp_inv_chg_amt 	= Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
    			    	                temp_inv_chg_amt 	= dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), temp_inv_chg_amt);
    			    	                tot_inv_amt			+= temp_inv_chg_amt;
    			    	                
    			    	                //TAX(%) Search
    			    	                tot_inv_tax_rto		= Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto());

    			    	                //TAX_AMT
    			    	                double temp_tax_amt = 0;
    			    	                
    			    	                //Vietnam
//    			    	                if(account.getCnt_cd().equals("VN")) {
//    			    	                    temp_tax_amt = (temp_inv_chg_amt / (1 - tot_inv_tax_rto * 0.01)) * (tot_inv_tax_rto * 0.01);
//    			    	                }else{
    			    	                	temp_tax_amt = (temp_inv_chg_amt * (tot_inv_tax_rto * 0.01)) ;
//    			    	                }
    			    	                temp_tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),temp_tax_amt);
    			    	                tot_inv_tax_amt		+= temp_tax_amt;
    			    	                
    			    	                //INV_AMT
    			    	                double temp_inv_amt	= 0;
    			    	                temp_inv_amt 		= temp_inv_chg_amt + temp_tax_amt;
    			    	                
    			    	                tot_inv_payable_amt += temp_inv_amt;
    			    	                tot_inv_payable_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(),tot_inv_payable_amt);
    			    	                
    			    	                //Cntr count
    			    	                cntr_cnt++;
    			    	                
    			    	                break;
    		    	            	}
    		    	            }
    						}
							
							
							
							//save dtl information.
	    					
		    				//save DMT_INV_DTL, DMT_INV_RT.
		    				//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$//
		    				issuedInvoiceParamVO = new IssuedInvoiceParamVO();
		    	            issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
		    	            issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
		    	            issuedInvoiceParamVO.setDmdtChgStsCds("C");
		    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
		    	            
		    	            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
		    	            
		    	            for(int j = 0 ; j < invoiceIssueList.size() ; j++) {
		    	            	InvoiceIssueVO invoiceIssueDetail = (InvoiceIssueVO)invoiceIssueList.get(j);
		    	            	
		    	            	//in summary , include checked CNTR.
		    	            	//String check_value = confirmChargeListVOs[i].getCntrNo();
		    	            	
		    	            	//if(!check_value.equals(invoiceIssueDetail.getCntrNo()))
		    	            	//	continue;
log.debug("[search_cntr_no]"+invoiceIssueDetail.getCntrNo());
log.debug("[list_cntr_no]"+confirmChargeListVOs[i].getCntrNo());
		    	            	if(invoiceIssueDetail.getCntrNo().equals(confirmChargeListVOs[i].getCntrNo())) {
		    	            	
			    	            	int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
			    	            	
			    	                //CNTR_INV_AMT
			    	                double cntr_inv_amt = 0;
			    	                cntr_inv_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(invoiceIssueDetail.getBilAmt());
			    	                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), cntr_inv_amt);
			    	                //TAX_AMT
			    	                double tax_amt = 0;
			    	                tax_amt = Double.parseDouble(confirmChargeListVOs[i].getInvTaxRto()) * 0.01 * cntr_inv_amt;
			    	                tax_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), tax_amt);
			    	                
			    	                
			    	                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
			    	                
			    	                dmtInvDtlVO.setDmdtInvNo(invoice_no);
			    	                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
			    	                dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
			    	                dmtInvDtlVO.setSvrId(invoiceIssueDetail.getSvrId());
			    	                dmtInvDtlVO.setCntrNo(invoiceIssueDetail.getCntrNo());
			    	                dmtInvDtlVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
			    	                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
			    	                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
			    	                dmtInvDtlVO.setChgSeq(invoiceIssueDetail.getChgSeq());
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
			    	                //dmtInvDtlVO.setCntrInvAmt(String.valueOf(cntr_inv_amt));
			    	                dmtInvDtlVO.setCntrInvAmt(JSPUtil.toDecimalFormat(cntr_inv_amt, "#.##"));
			    	                dmtInvDtlVO.setTaxRto(confirmChargeListVOs[i].getInvTaxRto());
			    	                //dmtInvDtlVO.setTaxAmt(String.valueOf(tax_amt));
			    	                dmtInvDtlVO.setTaxAmt(JSPUtil.toDecimalFormat(tax_amt, "#.##"));
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
			    	                
			    	                // ********** DivOverDay Search
			    	                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
			    	                
			    	//-----------------------------------------
	
			    					CalculationParmVO calculationParmVO = new CalculationParmVO();
			    					
			    					String trfAplyTpCd = invoiceIssueDetail.getDmdtTrfAplyTpCd();
			    					calculationParmVO.setDcApplRate(trfAplyTpCd);
			    					
		    					/*
		    					  according to Tariff Calculate Charge amount.
                    			  A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
                    			  B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
                    			  C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
                    			  D) if applied Currency different  A), B), C) 's Currency
                    			       1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
                    			       2) 1)amount round by Currency

		    					*/
//		    						// basicCalculation - Baisc Tariff
//		    						String firstSvrID = null;
//		    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
//		    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//		    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
//		    						chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
//		    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
//		    						chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
//
//		    						// set svr_id previous in office transfer
//		    						if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")) {
//		    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
//		    						} else {
//		    							firstSvrID = invoiceIssueDetail.getSvrId();
//		    						}
//
//		    						calculationParmVO.setSvrId(firstSvrID);		
//		    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
//		    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//		    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//		    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//		    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
//		    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//		    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//		    	//bbsChargeCalulation Input
//		    	log.debug("## basicCalculation.......................");				
//		    	log.debug("## svr_id 		= "+invoiceIssueDetail.getSvrId());				
//		    	log.debug("## dmdt_trf_cd 	= "+invoiceIssueDetail.getDmdtTrfCd());				
//		    	log.debug("## bzc_trf_seq 	= "+invoiceIssueDetail.getBzcTrfSeq());				
//		    	log.debug("## bzc_trf_grp_seq = "+invoiceIssueDetail.getBzcTrfGrpSeq());				
//		    	log.debug("## cntr_tpsz_cd 	= "+invoiceIssueDetail.getCntrTpszCd());				
//		    	log.debug("## org_ft_ovr_dys = "+invoiceIssueDetail.getOrgFtOvrDys());				
//		    	log.debug("## div_over_day 	= "+overdayNDivVO.getDivOverDay());				
//		    	log.debug("## bzc_trf_curr_cd = "+invoiceIssueDetail.getBzcTrfCurrCd());				
//		    					
//		    						CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);   
		    						
			    					// basicCalculation - Baisc Tariff
		    						String firstSvrID = null;
		    						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
		    						chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
		    						chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
		    						chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
		    						chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
		    						chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
		    						chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd()); //2011.10.28

		    						// set svr_id previous in office transfer
		    						if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")) {
		    							firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
		    						} else {
		    							firstSvrID = invoiceIssueDetail.getSvrId();
		    						}

		    						calculationParmVO.setSvrId(firstSvrID);		
		    						calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
		    						calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//		    						calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());
		    						calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
		    						calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
		    						calculationParmVO.setOverDay(invoiceIssueDetail.getOrgFtOvrDys());
		    						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
		    						calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//		    						calculationParmVO.setFtDys(invoiceIssueDetail.getFtDys());
//		    						calculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
//		    						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
//		    						calculationParmVO.setDmdtTrfAplyTpCd(trfAplyTpCd);										// 2014.03.12
		    						
//		    						calculationParmVO.setDivOrgOverDay(overdayNDivVO.getOrgFtOvrDys());
		    	//bbsChargeCalulation Input
		    	log.debug("## basicCalculation.......................");				
		    	log.debug("## svr_id 		= "+invoiceIssueDetail.getSvrId());				
		    	log.debug("## dmdt_trf_cd 	= "+invoiceIssueDetail.getDmdtTrfCd());				
		    	log.debug("## bzc_trf_seq 	= "+invoiceIssueDetail.getBzcTrfSeq());				
		    	log.debug("## bzc_trf_grp_seq = "+invoiceIssueDetail.getBzcTrfGrpSeq());				
		    	log.debug("## cntr_tpsz_cd 	= "+invoiceIssueDetail.getCntrTpszCd());				
		    	log.debug("## org_ft_ovr_dys = "+invoiceIssueDetail.getOrgFtOvrDys());				
		    	log.debug("## div_over_day 	= "+overdayNDivVO.getDivOverDay());				
		    	log.debug("## bzc_trf_curr_cd = "+invoiceIssueDetail.getBzcTrfCurrCd());				
		    					
				if(trfAplyTpCd.equals("G")) {
//					String firstSvrID = null;
					
					//office transfer check
	            	if(invoiceIssueDetail.getOfcTrnsFlg().equals("Y")){
	            		
//	            		ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();
	            		chargeCalculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
	            		chargeCalculationParmVO.setDmdtChgLocDivCd(invoiceIssueDetail.getDmdtChgLocDivCd());
	            		chargeCalculationParmVO.setCntrNo(invoiceIssueDetail.getCntrNo());
	            		chargeCalculationParmVO.setCntrCycNo(invoiceIssueDetail.getCntrCycNo());
	            		chargeCalculationParmVO.setSvrId(invoiceIssueDetail.getSvrId());
	            		chargeCalculationParmVO.setBkgNo(invoiceIssueDetail.getBkgNo());
	            		chargeCalculationParmVO.setFmMvmtYdCd(invoiceIssueDetail.getFmMvmtYdCd()); //2011.10.28
	            		
	    				log.debug(" iss searchChargeInvoice  FmMvmtYdCd ==========="+chargeCalculationParmVO.getFmMvmtYdCd());	            		
	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	            	}else{
	            		firstSvrID = invoiceIssueDetail.getSvrId();
	            	}
					
					// basicCalculation - Baisc Tariff
					calculationParmVO.setSvrId(firstSvrID);
					calculationParmVO.setDmdtTrfCd(invoiceIssueDetail.getDmdtTrfCd());
					calculationParmVO.setTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//					calculationParmVO.setDmdtDeTermCd(invoiceIssueDetail.getBzcDmdtDeTermCd());		// dmdt_de_term_cd
					calculationParmVO.setTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
					calculationParmVO.setCurCd(invoiceIssueDetail.getBzcTrfCurrCd());
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getBzcTrfAplyDt());			// 2014.03.12
//					if (!"".equals(invoiceIssueDetail.getScRfaExptAplyDt())) {		// 2014.03.12
//						calculationParmVO.setDmdtTrfAplyTpCd("B");									
//						calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt()); // 방글라데시 로직 때문에 추가. ("B" 또는 "S"로 넣기면 됨)
//					} else {
//						calculationParmVO.setDmdtTrfAplyTpCd("G");									// 2014.03.12
//					}
				} else if(trfAplyTpCd.equals("B")) {
					// beforeCalculation - Before BKG Exception
					calculationParmVO.setDarNo(invoiceIssueDetail.getRfaExptDarNo());
					calculationParmVO.setMapgSeq(invoiceIssueDetail.getRfaExptMapgSeq());
					calculationParmVO.setVerSeq(invoiceIssueDetail.getRfaExptVerSeq());
					calculationParmVO.setDtlSeq(invoiceIssueDetail.getRfaRqstDtlSeq());
					calculationParmVO.setCmbSeq("1");
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
				} else if(trfAplyTpCd.equals("S")) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(invoiceIssueDetail.getScNo());
					calculationParmVO.setVerSeq(invoiceIssueDetail.getScExptVerSeq());
					calculationParmVO.setGrpSeq(invoiceIssueDetail.getScExptGrpSeq());
					calculationParmVO.setCntrts(invoiceIssueDetail.getCntrTpszCd());
					calculationParmVO.setOverDay(invoiceIssueDetail.getFxFtOvrDys());					
//					calculationParmVO.setTrfAplyDt(invoiceIssueDetail.getScRfaExptAplyDt());// 2014.03.12
				}
				                   					    
		    	//bbsChargeCalulation Input
		    	log.debug("\n basicCalculation.......................");				
		    	log.debug("\n svr_id 		      	= "+invoiceIssueDetail.getSvrId());				
		    	log.debug("\n dmdt_trf_cd 		  	= "+invoiceIssueDetail.getDmdtTrfCd());				
		    	log.debug("\n bzc_trf_seq 		  	= "+invoiceIssueDetail.getBzcTrfSeq());
//		    	log.debug("\n bzc_dmdt_de_term_cd 	= "+invoiceIssueDetail.getBzcDmdtDeTermCd());
		    	log.debug("\n bzc_trf_grp_seq     	= "+invoiceIssueDetail.getBzcTrfGrpSeq());				
		    	log.debug("\n cntr_tpsz_cd 	      	= "+invoiceIssueDetail.getCntrTpszCd());				
		    	log.debug("\n org_ft_ovr_dys      	= "+invoiceIssueDetail.getOrgFtOvrDys());				
		    	log.debug("\n div_over_day 	      	= "+overdayNDivVO.getDivOverDay());				
		    	log.debug("\n bzc_trf_curr_cd     	= "+invoiceIssueDetail.getBzcTrfCurrCd());				
		    	log.debug("\n getFtDys 				= "+invoiceIssueDetail.getFtDys());			// 2014.03.12
//				log.debug("\n getFmMvmtYdCd 		= "+invoiceIssueDetail.getFmMvmtYdCd());	// 2014.03.12
//				log.debug("\n getBzcTrfAplyDt		= "+invoiceIssueDetail.getBzcTrfAplyDt());	// 2014.03.12
//				log.debug("\n setDmdtTrfAplyTpCd	= "+calculationParmVO.getDmdtTrfAplyTpCd());// 2014.03.12
				

//				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.basicCalculation(calculationParmVO);     
				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);  
			    					
			    	                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
			    	                double inv_rt_amt = 0;
			    	                double rt_ovr_chg_amt = 0;
	
			    	                
			    	                if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
			    	                	
			    	                	//addInvoiceRate
			    	                	for ( int k = 0; k < chrgDtlVOS.size() ; k++) {
			    		                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(k);
			    		                    
			    		                    //if over_day > 0 , then save.
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
			    		                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
			    		                    //dmtInvRtVO.setBzcTrfRtSeq("");
			    		                    
			    		                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
			    		                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
			    		                    
	    		                    		inv_rt_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtRate());
	    		                    		inv_rt_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), inv_rt_amt);
	    		                    		rt_ovr_chg_amt = Double.parseDouble(confirmChargeListVOs[i].getInvXchRt()) * Double.parseDouble(chrgDtlVO.getRtChrg());
	    		                    		rt_ovr_chg_amt = dmtCalculationUtil.trimCurrencyAmount(confirmChargeListVOs[i].getArCurrCd(), rt_ovr_chg_amt);
			    		                    
			    		                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(inv_rt_amt, "#.##"));
			    		                    dmtInvRtVO.setRtOvrChgAmt(String.valueOf(rt_ovr_chg_amt));
			    		                    
			    		                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
			    		                    dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());	//Basic Curr
			    		                    
			    		                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
			    		                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
			    		                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
			    		                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
			    		                    
			    		                    dbDao.addInvoiceRate(dmtInvRtVO);
			    	                	}
			    	                }
			    	              //======================================================
			    	                //Discount Amount + Exception Amount > 0
//			    	                double dScRfaExptAmt = Double.parseDouble(invoiceIssueDetail.getExptAmt());
//			    	                double dAftExptDcAmt = Double.parseDouble(invoiceIssueDetail.getAftExptDcAmt());
//			    	                double dCmdtExptAmt  = Double.parseDouble(invoiceIssueDetail.getCmdtExptAmt());
			    	                
//			    	                if( dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt  > 0) {
//			    	                	rt_ovr_chg_amt = 0;
//			    	                    rt_ovr_chg_amt = 0 - (dScRfaExptAmt + dAftExptDcAmt + dCmdtExptAmt);		//	(-) Charge
//			    	                
//			    		                DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//			    		                dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//			    		                dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//			    		                dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//			    		                dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//			    		                dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//			    		                dmtInvRtVO.setBzcTrfSeq(invoiceIssueDetail.getBzcTrfSeq());
//			    		                dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueDetail.getBzcTrfGrpSeq());
//			    		                dmtInvRtVO.setBzcTrfRtSeq("");
//			    		                dmtInvRtVO.setFtOvrDys("0");
//			    		                dmtInvRtVO.setFtUndDys("0");
//			    		                dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt * (-1), "#.##"));	//(+) amount
//			    		                dmtInvRtVO.setRtOvrDys("1");
//			    		                dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rt_ovr_chg_amt, "#.##"));		//(-) amount
//			    		                dmtInvRtVO.setBzcCurrCd(invoiceIssueDetail.getBzcTrfCurrCd());
//			    		                dmtInvRtVO.setCreUsrId(account.getUsr_id());
//			    		                dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//			    		                dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//			    		                dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//			    		                
//			    		                dbDao.addInvoiceRate(dmtInvRtVO);
//			    	                }			    	                
			    	            }// save INV_DTL, INV_RT.
		    	            }
    					}//if not sel_cntr=0
    					sBkgNo = confirmChargeListVOs[i].getBkgNo();
    					
    					// cumulate selected cntr count.
    					sel_cntr++;
    					
    					
    					
    					log.debug("[BKGNO.........]"+sBkgNo+"[INVOICE_NO]"+invoice_no+"[sel_cntr]"+sel_cntr);
    					
	    			}//only selected cntr.
	    			
log.debug("[i:"+i+"][confirmChargeListVOs.length-1:"+(confirmChargeListVOs.length - 1)+"]");	    			
	    			
	    			
	    			//if it is the last data
	    			if(i == (confirmChargeListVOs.length - 1)){
	    				//UPDATE INV_MN (calculated amount)
						DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
						dmtInvMnVO.setDmdtInvNo(invoice_no);
	    	            dmtInvMnVO.setOrgChgAmt(String.valueOf(tot_org_chg_amt));
	    	            dmtInvMnVO.setDmdtExptAmt(JSPUtil.toDecimalFormat(tot_sc_rfa_expt_amt, "#.##"));
	    	            dmtInvMnVO.setDcAmt(JSPUtil.toDecimalFormat(tot_aft_expt_dc_amt, "#.##"));
	    	            dmtInvMnVO.setBilAmt(JSPUtil.toDecimalFormat(tot_bil_amt, "#.##"));
	    	            dmtInvMnVO.setBkgCntrQty(String.valueOf(cntr_cnt));

	    	            dmtInvMnVO.setInvChgAmt(JSPUtil.toDecimalFormat(tot_inv_amt, "#.##"));
	    	            dmtInvMnVO.setTaxRto(String.valueOf(tot_inv_tax_rto));
	    	            dmtInvMnVO.setTaxAmt(JSPUtil.toDecimalFormat(tot_inv_tax_amt, "#.##"));
	    	            dmtInvMnVO.setInvAmt(JSPUtil.toDecimalFormat(tot_inv_payable_amt, "#.##"));								
						
	    	            dbDao.modifyInvoiceMainByGroupContainer(dmtInvMnVO);	//save detail summary amount.
	    			}
    			  }//BL check
    			}//all for 
				//reInvoiceGroupParamVO Setting
				reInvoiceGroupParamVO = new InvoiceGroupParamVO();
	    		
				reInvoiceGroupParamVO.setInvQty(String.valueOf(inv_qty));
				reInvoiceGroupParamVO.setIssueDate(issue_date);
				reInvoiceGroupParamVO.setErrCode("");
				reInvoiceGroupParamVO.setErrMsg("");


	    	}// save by cntr
    		reInvoiceGroupParamVO.setTotBilAmt(invoiceGroupParamVO.getTotBilAmt());
    		reInvoiceGroupParamVO.setTotTaxAmt(invoiceGroupParamVO.getTotTaxAmt());
    		reInvoiceGroupParamVO.setTotPayableAmt(invoiceGroupParamVO.getTotPayableAmt());
    		reInvoiceGroupParamVO.setSGroupBy(invoiceGroupParamVO.getSGroupBy());
    		reInvoiceGroupParamVO.setSChargeType(invoiceGroupParamVO.getSChargeType());
    		
    		reInvoiceGroupMgtVO.setInvoiceGroupParamVO(reInvoiceGroupParamVO);
    		reInvoiceGroupMgtVO.setConfirmChargeList(reConfirmChargeListVOs);
    		
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        } catch (Exception de) {
        	log.error("[Exception]"+de.getMessage());
        	throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
        }
        
        return reInvoiceGroupMgtVO;
    	
    }
    
    
    /**
    * SEARCH Manual Invoice Report by Office .<br>
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
    * SEARCH Manual Invoice Report by Office - Detail(s).<br>
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
    * SEARCH Outstanding Inquiry by Customer N Issue - Detail(s) .<br>
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
    * SEARCH Manual Invoice Report by Office.<br>
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
     * Search Issued Invoice Inquiry.<br>
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
     * Search Invoice Create & Issue .<br>
     * 
     * @param String invoiceNo
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
     public InvoiceIssueMgtVO searchManualInvoiceByBooking(String invoiceNo) throws EventException {
    	 InvoiceIssueMgtVO invoiceIssueMgtVO = new InvoiceIssueMgtVO();
    	 
    	 DmtInvMnVO dmtInvMnVO = null;
    	 
         try {
        	 //1.Search Manual Invoice.
        	 List<DmtInvMnVO> dmtInvMnVOS = dbDao.searchManualInvoiceMain(invoiceNo);
        	 if (dmtInvMnVOS != null && dmtInvMnVOS.size() > 0) {
        		 dmtInvMnVO = dmtInvMnVOS.get(0);

        		 //==================================================================================================
        		 //Search BKG Cust. information
        		 //==================================================================================================
        		 List<BookingCustomerVO> bkgCustomerVOS = dbDao.searchBookingCustomerByManual(dmtInvMnVO.getBkgNo(), dmtInvMnVO.getDmdtTrfCd());	
        		 if (bkgCustomerVOS != null && bkgCustomerVOS.size() > 0) {
        			 dmtInvMnVO.setBkgCustCd(bkgCustomerVOS.get(0).getCustCd());
        			 dmtInvMnVO.setBkgCustNm(bkgCustomerVOS.get(0).getCustNm());
        		 }
        		 
        		 //==================================================================================================
            	 // Search A/R Cust. information.
        		 //==================================================================================================
            	 List<ARActualPayerVO> arActualPayerVOS = dbDao.searchARActualPayer(dmtInvMnVO.getBkgNo(), dmtInvMnVO.getDmdtTrfCd());
            	 if (arActualPayerVOS != null && arActualPayerVOS.size() > 0) {
            		 dmtInvMnVO.setActCustCd(arActualPayerVOS.get(0).getActCustCd());
            		 dmtInvMnVO.setActCustNm(arActualPayerVOS.get(0).getActCustNm());
            	 }

        		 //==================================================================================================
        		 // Search Due Date, Credit Term, Tax Rate information.
        		 //==================================================================================================
        		 List<DmtCrTermOptVO> dmtCrTermOptVOS = dbDao.searchInvoiceTermOption(dmtInvMnVO.getIssueOfcCd(), dmtInvMnVO.getIssueDt(), dmtInvMnVO.getDmdtTrfCd());
        		 if (dmtCrTermOptVOS != null && dmtCrTermOptVOS.size() > 0) {
        			 dmtInvMnVO.setDueDt(dmtCrTermOptVOS.get(0).getDueDt());
        			 dmtInvMnVO.setCrTermDys(dmtCrTermOptVOS.get(0).getCrTermDys());
        			 dmtInvMnVO.setIssDtPrnFlg(dmtCrTermOptVOS.get(0).getIssDtPrnFlg());
        			 dmtInvMnVO.setDfltTaxRto(dmtCrTermOptVOS.get(0).getDfltTaxRto());
        		 } 
	        	
        		 //==================================================================================================
        		 // Search Manual Invoice Detail(Charge).
        		 //==================================================================================================
	        	 List<DmtInvDtlVO> dmtInvDtlVOS = dbDao.searchManualInvoiceDetail(invoiceNo);
	        	 
        		 //==================================================================================================
        		 // Search Manual Invoice Rate Detail .
        		 //==================================================================================================	        	 
	        	 List<DmtInvRtVO> dmtInvRtVOS = dbDao.searchManualInvoiceRate(invoiceNo);
	        	 
	        	 //set result of searching to group VO for return to SC.
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
      *  Search Invoice Create & Issue.<br>
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
        	 // Search Booking No. information in Charge Booking Container table (Payer, Trucker )
    		 //==================================================================================================    		 
    		 manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingData(bookingNo, tariffType);
    		 
    		 //==================================================================================================
        	 // there is no data searching, Search Booking No. information in Booking table
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
    			 manualKeyByBookingVOS = dbDao.searchManualInvoiceBookingDataInBKG(bookingNo);
    		 }
    		 
    		 //==================================================================================================
        	 //if Container Detail is 'Y'  and Booking information is exists, then  Search Charge information
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS != null && manualKeyByBookingVOS.size() > 0 && "Y".equals(cntrDtlFlg)) {
    			 // Search Manual Invoice Detail(Charge) that  status is 'Deleted', 'Error' .
    			 manualKeyByChargeVOS = dbDao.searchManualInvoiceChargeData(bookingNo, officeCode, tariffType);
    		 }
    		 
    		 //==================================================================================================
        	 // if there is not BKG information, Create  BKG Cust., A/R Cust., Due Date, Credit Term, Tax Rate information
    		 //==================================================================================================    		 
    		 if (manualKeyByBookingVOS == null || manualKeyByBookingVOS.size() == 0) {
    			 manualKeyByBookingVOS = new ArrayList<ManualKeyByBookingVO>();
    			 manualKeyByBookingVOS.add(new ManualKeyByBookingVO());
    		 }

    		 //==================================================================================================
        	 // Search BKG Cust. information.
    		 //==================================================================================================
        	 List<BookingCustomerVO> bkgCustomerVOS = dbDao.searchBookingCustomerByManual(bookingNo, tariffType);
        	 if (bkgCustomerVOS != null && bkgCustomerVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setBkgCustCd(bkgCustomerVOS.get(0).getCustCd());
        		 manualKeyByBookingVOS.get(0).setBkgCustNm(bkgCustomerVOS.get(0).getCustNm());
        	 }

    		 //==================================================================================================
        	 // Search A/R Cust. information.
    		 //==================================================================================================
        	 List<ARActualPayerVO> arActualPayerVOS = dbDao.searchARActualPayer(bookingNo, tariffType);
        	 if (arActualPayerVOS != null && arActualPayerVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setActCustCd(arActualPayerVOS.get(0).getActCustCd());
        		 manualKeyByBookingVOS.get(0).setActCustNm(arActualPayerVOS.get(0).getActCustNm());
        	 }

    		 //==================================================================================================
        	 // Search Due Date, Credit Term, Tax Rate information.
    		 //==================================================================================================
        	 List<DmtCrTermOptVO> dmtCrTermOptVOS = dbDao.searchInvoiceTermOption(officeCode, "", tariffType);
        	 if (dmtCrTermOptVOS != null && dmtCrTermOptVOS.size() > 0) {
        		 manualKeyByBookingVOS.get(0).setDueDt(dmtCrTermOptVOS.get(0).getDueDt());
        		 manualKeyByBookingVOS.get(0).setCrTermDys(dmtCrTermOptVOS.get(0).getCrTermDys());
        		 manualKeyByBookingVOS.get(0).setIssDtPrnFlg(dmtCrTermOptVOS.get(0).getIssDtPrnFlg());
        		 manualKeyByBookingVOS.get(0).setDfltTaxRto(dmtCrTermOptVOS.get(0).getDfltTaxRto());
        	 }    		 

    		 //==================================================================================================
        	 // click button Data Display,  set result iof Searching to Group VO.
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
      * check validation CNTR No.<br>
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
      * Search VVD CD. Calling Port .<br>
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
      * check existing VVD CD .<br>
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
      * Save Manual Invoice Creation & Issue [after Invoice Issue] .<br>
      * 
      * @param manualInvoiceIssueVO ManualInvoiceIssueVO
      * @param SignOnUserAccount account
      * @exception EventException
      */
     public void modifyInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException {
     	 
     	 try {
 			//1. for procssing  sended information from Client in Group VO , separate information . 
     		//get  Booking information in Group VO for Update.
     		 DmtInvMnVO invMnVO = manualInvoiceIssueVO.getDmtInvMnVO();
  			
  			// get Charge, Rate information in Group VO  for Insert, Update, Delete.
  			List<DmtInvDtlVO> invDtlVOS = manualInvoiceIssueVO.getDmtInvDtlVOS();
  			List<DmtInvRtVO> invRtVOS = manualInvoiceIssueVO.getDmtInvRtVOS();
 			//############################################################################################################
 			
  			//1. add Booking information from session.
   			if (invMnVO != null) {
   				invMnVO.setUpdUsrId(account.getUsr_id());
   				invMnVO.setUpdOfcCd(account.getOfc_cd());
   			} 			
 			
 			//2.separate Charge information for  Insert, Update, Delete .
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
 			
 			//3. separate Rate information for  Insert, Update, Delete.
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
 			
 			//1.[Delete Action] * Delete Action is first previous job Delete Action  *
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
      * Save Manual Invoice Creation & Issue [before Invoice Issue].<br>
      * 
      * @param ManualInvoiceIssueVO manualInvoiceIssueVO
      * @param SignOnUserAccount account
      * @return String
      * @exception EventException
      */
     public String issueInvoiceByManual(ManualInvoiceIssueVO manualInvoiceIssueVO, SignOnUserAccount account) throws EventException {
     	 String invoiceNo = null;
     	 
     	 try {
 			//1. for procssing  sended information from Client in Group VO , separate information . 
     		//   get  Booking information in Group VO for Update.
      		 DmtInvMnVO 		invMnVO 	= manualInvoiceIssueVO.getDmtInvMnVO();
   			
   			//for Insert, Update, Delete,  get Charge, Rate information in Group VO .
   			List<DmtInvDtlVO> 	invDtlVOS 	= manualInvoiceIssueVO.getDmtInvDtlVOS();
   			List<DmtInvRtVO> 	invRtVOS 	= manualInvoiceIssueVO.getDmtInvRtVOS();
  			//############################################################################################################
   			
   			//1.add field to Booking information.
    		if (invMnVO != null) {
    				
    			//Invoice No. 를 설정해준다.
    			invoiceNo = makeInvoiceNo(invMnVO.getDmdtTrfCd(), account);
    			invMnVO.setDmdtInvNo(invoiceNo);
    			
    			//if VVD is HJXX, HJYY, HJZZ, change to Common VVD .
    			//Common VVD CFDR + YYMM + E (ex: CFDR0904E)
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
    			
    			invMnVO.setIoBndCd(invMnVO.getDmdtTrfCd().substring(2, 3));
    			invMnVO.setDmdtChgTpCd("G"); //G:GENERAL, B:BALANCE
    			invMnVO.setMnlInpFlg("Y");
                invMnVO.setDmdtArIfCd("N");
                invMnVO.setDmdtInvStsCd("I");
    			invMnVO.setCreUsrId(account.getUsr_id());
    			invMnVO.setCreOfcCd(account.getOfc_cd());
    			invMnVO.setUpdUsrId(account.getUsr_id());
    			invMnVO.setUpdOfcCd(account.getOfc_cd());    			
    		} 			

    		//2. add field Charge information.
  			if (invDtlVOS != null) {
  				for (int i = 0 ; i < invDtlVOS.size(); i++) {
  					//set Invoice No.
  					if(invMnVO != null) {
  						invDtlVOS.get(i).setDmdtInvNo(invMnVO.getDmdtInvNo());
  					}else{
  						invDtlVOS.get(i).setDmdtInvNo("");
  					}
  					invDtlVOS.get(i).setCreUsrId(account.getUsr_id());
  					invDtlVOS.get(i).setCreOfcCd(account.getOfc_cd());
  					invDtlVOS.get(i).setUpdUsrId(account.getUsr_id());
  					invDtlVOS.get(i).setUpdOfcCd(account.getOfc_cd());  					
  				}
  			} 			
  			
  			//3.add field  Rate information.
  			if (invRtVOS != null) {
  				for (int i = 0 ; i < invRtVOS.size(); i++) {
  					//set Invoice No.
  					if(invMnVO != null) {
  						invRtVOS.get(i).setDmdtInvNo(invMnVO.getDmdtInvNo());
  					}else{
  						invRtVOS.get(i).setDmdtInvNo("");
  					}
  					invRtVOS.get(i).setCreUsrId(account.getUsr_id());
  					invRtVOS.get(i).setCreOfcCd(account.getOfc_cd());
  					invRtVOS.get(i).setUpdUsrId(account.getUsr_id());
  					invRtVOS.get(i).setUpdOfcCd(account.getOfc_cd());  					
  				}
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

     	 } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
     		 log.error("[DAOException]"+ex.getMessage());
     		 throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
     	 } catch(EventException ex) {
     		 log.error("[EventException]"+ex.getMessage());
     		 throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
 	     } catch (Exception ex) {
 	    	 log.error("[Exception]"+ex.getMessage());
 	         throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
 	     }
 	     return invoiceNo;
     }           
     /**
      * Search Invoice Cancel reason 
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
    * [Hold Reason Entry][SEARCH] .<br>
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
     * [Hold Reason Entry][SEARCH] .<br>
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
    * [Hold Reason Entry] [UPDATE] .<br>
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
     * [Invoice] [Cancel] .<br>
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
		DmtInvNoVO dmtInvNoVO 	= new DmtInvNoVO();
		DmtInvMnVO dmtInvMnVO 	= new DmtInvMnVO();
		DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
		DmtInvRtVO dmtInvRtVO 	= new DmtInvRtVO();
		
		DmtInvMnVO arIFCheckInvMn = new DmtInvMnVO();
//		List<ConfirmChargeListVO> reConfirmChargeListVOs = new ArrayList<ConfirmChargeListVO>();
		List<ChargeArgumentVO> chargeArgumentVOList = new ArrayList<ChargeArgumentVO>();
		ChargeArgumentVO chargeArgumentVO = new ChargeArgumentVO();
		String message = "";
 
		try {
//log.debug("--------------------0------------------");
//log.debug("--------------------dmdt_inv_no------------------"+cancelInvoiceParamVO.getDmdtInvNo());
//log.debug("--------------------cre_ofc_cd------------------"+cancelInvoiceParamVO.getCreOfcCd());
			//check exsiting INVOICE for cancel
			oldInvoiceNo 	= cancelInvoiceParamVO.getDmdtInvNo();
			creOfcCd 		= cancelInvoiceParamVO.getCreOfcCd();
//log.debug("--------------------1------------------");
			if(dbDao.checkCreditInvoice(oldInvoiceNo, creOfcCd) == null || dbDao.checkCreditInvoice(oldInvoiceNo, creOfcCd).equals("")) {
				chargeArgumentVO.setErrCode("DMT03024");
				//Message = "Only Issue Office("+cancelInvoiceParamVO.getCreOfcCd()+") can cancel the invoice. Please recheck your login Office code.");
				message = new ErrorHandler("DMT03024").getUserMessage();
				message = JSPUtil.replace(message, "XXXXX", cancelInvoiceParamVO.getCreOfcCd());
				chargeArgumentVO.setErrMsg(message);
				chargeArgumentVOList.add(chargeArgumentVO);
				return chargeArgumentVOList;
			}
//log.debug("--------------------2------------------");
	 
			//checkARIF
			arIFCheckInvMn = dbDao.checkARIF(oldInvoiceNo, creOfcCd);
//log.debug("--------------------3------------------");
	 
			//N or Hold  
			if(arIFCheckInvMn.getDmdtArIfCd().equals("N") || arIFCheckInvMn.getDmdtArIfCd().equals("H")) {
				dmtInvMnVO.setCrInvNo("");
				dmtInvMnVO.setDmdtInvStsCd("X");	
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cancelInvoiceParamVO.getIntgCdValDpDesc()+":"+cancelInvoiceParamVO.getCxlRmk());//사유명+:+Remark
				dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());
				dmtInvMnVO.setCreOfcCd(cancelInvoiceParamVO.getCreOfcCd());
   		 
				dbDao.modifyInvoiceMain(dmtInvMnVO);
				
//log.debug("--------------------cxl_rsn_cd------------------"+cancelInvoiceParamVO.getIntgCdValCtnt());
//log.debug("--------------------cxl_rmk------------------"+cancelInvoiceParamVO.getIntgCdValDpDesc());
//log.debug("--------------------invoice_no------------------"+cancelInvoiceParamVO.getDmdtInvNo());
//log.debug("--------------------cre_ofc_cd------------------"+cancelInvoiceParamVO.getCreOfcCd());
//log.debug("--------------------4------------------");
				// searchInvoiceCharge
				chargeArgumentVOList = dbDao.searchInvoiceCharge(cancelInvoiceParamVO.getDmdtInvNo(), cancelInvoiceParamVO.getCreOfcCd());
				
				// manual invoice is passible no dtl.
				//[2015.05.28]소스품질 Modify
				//if(chargeArgumentVOList == null || chargeArgumentVOList.size() == 0) {
				if(chargeArgumentVOList.size() == 0) {
					ChargeArgumentVO tempVO = new ChargeArgumentVO();
					tempVO.setErrCode("");
					tempVO.setErrMsg("");
					tempVO.setCrInvNo("");
					chargeArgumentVOList.add(tempVO);
				}else{
				
					//add
					ChargeArgumentVO tempVO = chargeArgumentVOList.get(0);
					tempVO.setErrCode("");
					tempVO.setErrMsg("");
					tempVO.setCrInvNo("");
					chargeArgumentVOList.set(0, tempVO);
				}
				
			}else if(arIFCheckInvMn.getDmdtArIfCd().equals("Y")){
				
	            // makeInvoiceNo
	            String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());

	            //if there if no invoice pfx_cd, then return error
	            if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
	            	chargeArgumentVO.setErrCode("DMT03063");
	            	chargeArgumentVO.setErrMsg("Invoice Prefix code missing for your login office");
	            	chargeArgumentVOList.add(chargeArgumentVO);
	            	return chargeArgumentVOList;
	            }	            
	            
	            String inv_sub_cd = "";
	            String inv_max	 = "";
	            //same values of Canceled invoice no .
	            inv_sub_cd = cancelInvoiceParamVO.getDmdtInvNo().substring(2, 3);
	            
	            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	            inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
	            
//log.debug("--------------------5------------------");
	            invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");
	            
	            dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
	            dmtInvNoVO.setCreUsrId(account.getUsr_id());
	            dmtInvNoVO.setDmdtInvNo(invoice_no);
	            dmtInvNoVO.setDmdtInvSeq(inv_max);
	            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
	            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
	            dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
	            dmtInvNoVO.setUpdUsrId(account.getUsr_id());
	            
	            if(inv_max.equals("1")){	//first time
	            	dbDao.createInvoiceNo(dmtInvNoVO);
	            }else{
	                dbDao.modifyInvoiceNo(dmtInvNoVO);
	            }                 
	            
				//Cancelled.
				dmtInvMnVO.setCrInvNo(invoice_no);
				dmtInvMnVO.setDmdtInvStsCd("X");	
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cancelInvoiceParamVO.getIntgCdValDpDesc()+":"+cancelInvoiceParamVO.getCxlRmk());//reason title +:+Remark
				dmtInvMnVO.setUpdUsrId(account.getUsr_id());
				dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
				dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());
				dmtInvMnVO.setCreOfcCd(cancelInvoiceParamVO.getCreOfcCd());
   		 
				dbDao.modifyInvoiceMain(dmtInvMnVO);
	            
//log.debug("--------------------6------------------");
	            //  addCreditInvoiceMain <-- cancelled invoice no is minus amount , Create Create note.
	            dmtInvMnVO = new DmtInvMnVO();
	            dmtInvMnVO.setCrInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no( cr_inv_no )
				dmtInvMnVO.setDmdtCxlRsnCd(cancelInvoiceParamVO.getIntgCdValCtnt());
				dmtInvMnVO.setCxlRmk(cancelInvoiceParamVO.getIntgCdValDpDesc()+":"+cancelInvoiceParamVO.getCxlRmk());//reason title+:+Remark
	            dmtInvMnVO.setCreUsrId(account.getUsr_id());
	            dmtInvMnVO.setCreOfcCd(account.getOfc_cd());
	            dmtInvMnVO.setUpdUsrId(account.getUsr_id());
	            dmtInvMnVO.setUpdOfcCd(account.getOfc_cd());
	            dmtInvMnVO.setDmdtInvNo(invoice_no);								//new invoice no(Create note)
	            dmtInvMnVO.setOldDmdtInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no(cancelled invoice)
 
	            dbDao.addCreditInvoiceMain(dmtInvMnVO);
//log.debug("--------------------8------------------");
 
	            // addCreditInvoiceDetail
	            dmtInvDtlVO = new DmtInvDtlVO();
	            dmtInvDtlVO.setDmdtInvNo(invoice_no);								//new invoice no(Create note)		
	            dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
	            dmtInvDtlVO.setCreUsrId(account.getUsr_id());
	            dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
	            dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
	            dmtInvDtlVO.setOldDmtInvNo(cancelInvoiceParamVO.getDmdtInvNo());	//old invoice no(cancelled invoice)
	            
	            log.debug("\n New Invoice no=="+invoice_no);
	            log.debug("\n OLD Invoice no=="+cancelInvoiceParamVO.getDmdtInvNo());
 
	            dbDao.addCreditInvoiceDetail(dmtInvDtlVO);
//log.debug("--------------------9------------------");
 
	            // addCreditInvoiceRate
	            dmtInvRtVO = new DmtInvRtVO();
	            dmtInvRtVO.setDmdtInvNo(invoice_no);								//new invoice no(Create note)
	            dmtInvRtVO.setOldDmtInvNo(cancelInvoiceParamVO.getDmdtInvNo());		//old invoice no(cancelled invoice)
	            dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
	            dmtInvRtVO.setCreUsrId(account.getUsr_id());
	            dmtInvRtVO.setUpdUsrId(account.getUsr_id());
	            dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
	            
	            dbDao.addCreditInvoiceRate(dmtInvRtVO);
	            
//log.debug("--------------------10------------------");
	            // searchInvoiceCharge ==> Search retuen values to changeChargeStatusForInvoiceByCancel.
	            chargeArgumentVOList = dbDao.searchInvoiceCharge(cancelInvoiceParamVO.getDmdtInvNo(), cancelInvoiceParamVO.getCreOfcCd());
//log.debug("--------------------11------------------");
				// Issue Office and A/R I/F Office are same, show user message 
				String err_cd = "";
				//ChargeArgumentVO messageArgumentVO = new ChargeArgumentVO();
				if(arIFCheckInvMn.getArIfOfcCd().equals(cancelInvoiceParamVO.getCreOfcCd())) {
					//messageArgumentVO.setErrCode("DMT03062");	//AR-IF(Create note)
					err_cd = "DMT03062";
					message = new ErrorHandler("DMT03062").getUserMessage();
					message = JSPUtil.replace(message, "XXX123456", invoice_no);//Credit Note
					//messageArgumentVO.setErrMsg(message);
					//messageArgumentVO.setCrInvNo(invoice_no);	//AR-IF(Create note)
				// Issue Office and A/R I/F Office are different, show user message
				}else{
					//messageArgumentVO.setErrCode("DMT03061");
					err_cd = "DMT03061";
					message = new ErrorHandler("DMT03061").getUserMessage();
					message = JSPUtil.replace(message, "XXXXX", arIFCheckInvMn.getArIfOfcCd());//A/R I/F Office Code
					message = JSPUtil.replace(message, "XXX123456", invoice_no);//Credit Note
					//messageArgumentVO.setErrMsg(message);
					
				}
				
				//case in manual , no dtl.
				//[2015.05.28]소스품질 Modify
				//if(chargeArgumentVOList == null || chargeArgumentVOList.size() == 0) {
				if(chargeArgumentVOList.size() == 0) {
					ChargeArgumentVO tempVO = new ChargeArgumentVO();
					tempVO.setErrCode(err_cd);
					tempVO.setErrMsg(message);
					tempVO.setCrInvNo(invoice_no);//AR-IF(Create note)
					chargeArgumentVOList.add(tempVO);
				}else{
				
					ChargeArgumentVO tempVO = chargeArgumentVOList.get(0);
					tempVO.setErrCode(err_cd);
					tempVO.setErrMsg(message);
					tempVO.setCrInvNo(invoice_no);//AR-IF(Create note)
					chargeArgumentVOList.set(0, tempVO);
				}
					

//log.debug("--------------------12------------------");
	            
	            
			}
		} catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
		} 
		return chargeArgumentVOList;
    }
    
    
    
    /**
    * [ Fax/E-mail Sending History ] [SEARCH] .<br>
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
     * Search Payerinformation.
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
    	
    	try {
    		
    		s_ofc_cd 	= payerInfoParamVO.getSOfcCd();
    		s_cust_cd 	= payerInfoParamVO.getSCustCd();
    		s_cust_gubun= payerInfoParamVO.getSCustGubun();
    		if(s_cust_gubun.equals("1")) {
    			s_vndr_flg = "Y";
    		} else if(s_cust_gubun.equals("2")) {
    			s_vndr_flg = "N";
    		}
    		
    		//Search PayerInfo information count Search.
    		s_payr_yn	= dbDao.checkPayerInfo(s_ofc_cd, s_cust_cd, s_vndr_flg);
    		
log.debug("\n #### s_ofc_cd ==> "+s_ofc_cd);    		
log.debug("\n #### s_cust_cd ==> "+s_cust_cd);    		
log.debug("\n #### s_payr_yn ==> "+s_payr_yn);    		
log.debug("\n #### s_cust_gubun ==> "+s_cust_gubun);    		
    		
    		reDmtPayrInfoVO = dbDao.searchPayerInformation(s_ofc_cd, s_cust_cd, s_payr_yn, s_cust_gubun);
    		list 			= dbDao.searchPayerContactPoint(s_ofc_cd, s_cust_cd, s_cust_gubun);
    		
    		//Search MDM CUSTOMER  information
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
    
    private String makeInvoiceNo(String tariffType, SignOnUserAccount account) throws EventException {
 	   StringBuffer invNo = new StringBuffer();
 	   DmtInvNoVO dmtInvNoVO = new DmtInvNoVO();
 	   
 	   try {
            String invMax = null;
            String invSubCd = null;
            String invPrxCd = dbDao.searchInvPfxCd(account.getOfc_cd());

            if(invPrxCd == null || "".equals(invPrxCd)) {
            	throw new EventException(new ErrorHandler("DMT03063").getUserMessage());
            }
            
            //in Manual Invoice third factor is  'M'.            
            invSubCd = "M";

            dmtInvNoVO.setInvOfcPfxCd(invPrxCd);
            dmtInvNoVO.setDmdtInvTpCd(invSubCd);
            invMax = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
            
            invNo.append(invPrxCd);
            invNo.append(invSubCd);
            invNo.append(JSPUtil.getLPAD(invMax, 6, "0"));
           
            dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
            dmtInvNoVO.setCreUsrId(account.getUsr_id());
            dmtInvNoVO.setDmdtInvNo(invNo.toString());
            dmtInvNoVO.setDmdtInvSeq(invMax);
            dmtInvNoVO.setDmdtInvTpCd(invSubCd);
            dmtInvNoVO.setInvOfcPfxCd(invPrxCd);
            dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvNoVO.setUpdUsrId(account.getUsr_id());
            
            if(invMax.equals("1")) {	//first time
         	   dbDao.createInvoiceNo(dmtInvNoVO);
            } else {
                dbDao.modifyInvoiceNo(dmtInvNoVO);
            }
 		
 	   } catch(DAOException ex) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																
 		   log.error("[DAOException]"+ex.getMessage());
 		   throw new EventException(new ErrorHandler("DMT00003").getUserMessage());
 	   } catch(EventException ex) {
 		   log.error("\n\n[makeInvoiceNo][EventException] " + ex.getMessage() + "\n\n");
 		   throw ex;
 	   } catch (Exception ex) {
 		  log.error("[Exception]"+ex.getMessage());
 		   throw new EventException(new ErrorHandler("DMT00003").getUserMessage());		   
 	   }
 	   
 	   return invNo.toString();
    }    
    
	/**
	 * Search Payer Name information.<br>
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
	 *  Search Payer Address information.<br>
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
	 * Search Payer Contact Point information.<br>
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
	 * Search Payer Phone No information. <br>
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
	 * Search Payer Fax No information.<br>
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
	 * Search Payer Email information.<br>
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
	 *  save Payer Info information.<br>
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
			
			//vendor
			if(dmtPayrInfoVO.getCustCd().length() == 6){
				dmtPayrInfoVO.setCustCntCd("00");
				dmtPayrInfoVO.setCustSeq(dmtPayrInfoVO.getCustCd());
				dmtPayrInfoVO.setDmdtPayrVndrFlg("Y");
			}else{
				dmtPayrInfoVO.setCustCntCd(dmtPayrInfoVO.getCustCd().substring(0, 2));
				dmtPayrInfoVO.setCustSeq(dmtPayrInfoVO.getCustCd().substring(2));
				dmtPayrInfoVO.setDmdtPayrVndrFlg("N");
			}
			
			log.error("\ndbDao.checkPayerInfo");
			log.error("\ndmtPayrInfoVO.getOfcCd()=["+dmtPayrInfoVO.getOfcCd()+"<<");
			log.error("\ndmtPayrInfoVO.getCustCd()=["+dmtPayrInfoVO.getCustCd()+"<<");
			log.error("\ndmtPayrInfoVO.getDmdtPayrVndrFlg()=["+dmtPayrInfoVO.getDmdtPayrVndrFlg()+"<<");
			//Payer Info save
			s_payr_yn	= dbDao.checkPayerInfo(dmtPayrInfoVO.getOfcCd(), dmtPayrInfoVO.getCustCd(), dmtPayrInfoVO.getDmdtPayrVndrFlg());
			log.error("\ns_payr_yn=["+s_payr_yn+"<<");
			
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
			
				//Payer contact point save
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
					//if status is Delete ,  Delete .
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
     *  Search calculated Charge information by Finished Booking,  Tariff Type,, "SZPBB".(before Invoice Issue)
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
            	//manualChargeContainerVO.setResultMsg("ChargeBookingInvoice information Search error");
            	//return manualChargeContainerVO;
            	//throw new EventException("ChargeBookingInvoice information Search error");
            	throw new EventException(new ErrorHandler("DMT00006", new String[]{"Manual Billing"}).getMessage());
            }

            PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
            PayerNameVO rePayerNameVO = new PayerNameVO();
            
            //no Payer
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
            
                
            
            List<BookingCustomerVO> bookingCustomerList = null;
            
            // searchBookingCustomer 
            BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
            BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
            
            inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
            
            // searchBookingCustomer Search
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
                chargeBookingInvoiceVO.setDueDate(curr_ofc_date);//current date
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT  L/R
            } else {
                for(int i = 0; i < listSheetOption.size() ; i++) {
                	chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT  L/R
                    
                    if(listSheetOption.get(i).getDfltTaxRto() == null || listSheetOption.get(i).getDfltTaxRto().equals("")) {
                    	chargeBookingInvoiceVO.setTaxRto("0");
                    }else{
                    	chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    }
                
                    //if sheet Option Credit Term = 0 
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//if Due Date is "Issue Date", then set  Due Date=current date,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(curr_ofc_date);
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//if Due Date is "*******", then set Due Date: ********, Credit Term: ''
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //if sheet Option Credit Term > 0 
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
            
            // Double format (decimal place 6 )
            chargeBookingInvoiceVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
           
            
            double totAmt = 0;
            
            // Search Charge Grid
            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
            
            //******************* Rate Detail  START *******************
            OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
            List<ChrgDtlVO> chrgDtlVOList = new ArrayList<ChrgDtlVO>();
            
            for(int i = 0 ; i< invoiceIssueList.size() ; i++) {
				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
				
				// Rate Detail Grid  data division
				invoiceIssueVO.setRtDtlGrp(String.valueOf(i+1));
	            
	            overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
	            overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	            overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
	            overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
	            overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
	            overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
	
	            //------------- DivOverDay Search -----------
	            OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
	
	            String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
	            
	            CalculationParmVO calculationParmVO = new CalculationParmVO();
	            calculationParmVO.setDcApplRate(trfAplyTpCd);
	
	            if(trfAplyTpCd.equals("G")) {
	            	// basicCalculation - Baisc Tariff
	                calculationParmVO.setSvrId(invoiceIssueVO.getSvrId());
	                calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
	                calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
	                calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
	                calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	                calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	                calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
	
	            } else if(trfAplyTpCd.equals("B")) {
	            	// beforeCalculation - Before BKG Exception
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptMapgSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptVerSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getRfaRqstDtlSeq());
	                calculationParmVO.setDarNo(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setDarNo(invoiceIssueVO.getFxFtOvrDys());
	                calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	                
	            } else if(trfAplyTpCd.equals("S")) {
	            	// scCalculation - SC Exception
	                calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
	                calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
	                calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
	                calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	                calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	                calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	            }
	            
	            double invChgTotAmt = 0;
	            CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
	            
	            // Rate Detail information
	            List<ChrgDtlVO> chrgDtlVOs = calculationAMTVO.getChrgDtlVOS();
				
	            // if there is Rate Detail information -- START
				if(chrgDtlVOs != null && chrgDtlVOs.size() > 0) {
					for(int k=0; k < chrgDtlVOs.size(); k++) {
						ChrgDtlVO vo = chrgDtlVOs.get(k);
						vo.setRtCurCd(String.valueOf(i+1));	//set Group No. for  Grid data division
					}
					
					chrgDtlVOList.addAll(chrgDtlVOs);
					
					//Total Amt
	            	invChgTotAmt = NumberUtils.toDouble(calculationAMTVO.getTotal());
//					String rateCurrCd = calculationAMTVO.getRateCurCd();
//					
//					if(!rateCurrCd.equals(chargeBookingInvoiceVO.getChgCurrCd())){
//	            		/*
//						exchangeRateParmVO = new ExchangeRateParmVO();
//	                    exchangeRateParmVO.setVslCd(chargeBookingInvoiceVO.getVvdCd().substring(0,4));
//	                    exchangeRateParmVO.setSkdVoyageNo(chargeBookingInvoiceVO.getVvdCd().substring(4,8));
//	                    exchangeRateParmVO.setSkdDirCd(chargeBookingInvoiceVO.getVvdCd().substring(8));
//	                    exchangeRateParmVO.setIoBnd(chargeBookingInvoiceVO.getDmdtTrfCd().substring(2,3));
//	                    exchangeRateParmVO.setPolLoc(chargeBookingInvoiceVO.getPolCd());
//	                    exchangeRateParmVO.setPodLoc(chargeBookingInvoiceVO.getPodCd());
//	                    */
//	                    exchangeRateParmVO.setFmCurCd(rateCurrCd);								//rate currency
//	                    //exchangeRateParmVO.setToCurCd(chargeBookingInvoiceVO.getChgCurrCd());	//chg currency
//	                    //exchangeRateParmVO.setOfcCd(issuedInvoiceParamVO.getSOfcCd());		//charge office
//	                    
//	                    double xchRt = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
//	                    invChgTotAmt = xchRt * invChgTotAmt;
//	                    invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd, invChgTotAmt);
//					}
					
				}
				// exists Rate Detail information -- END
				
				
				//invoice total amt
//				invChgTotAmt = exchangeRate * invChgTotAmt;
//	            invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invChgTotAmt);
//	            invoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(invChgTotAmt, "#.##"));

                totAmt += invChgTotAmt;
            	
            	//inv_chg_tot, inv_bill_amt save
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

            //Vietnam
//            if(account.getCnt_cd().equals("VN")) {
//                taxAmt = (invChgAmt / (1 - taxRto * 0.01)) * (taxRto * 0.01);
//            }else{
                taxAmt = (invChgAmt * (taxRto * 0.01)) ;
//            }
            
            taxAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),taxAmt);
            chargeBookingInvoiceVO.setTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#.##"));

            //Payable Amt
            double invAmt = 0;
            invAmt = invChgAmt + taxAmt;

            invAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),invAmt);
            chargeBookingInvoiceVO.setInvAmt(JSPUtil.toDecimalFormat(invAmt, "#.##"));
            
            //******************* Rate Detail  END *******************
            
            
            //Invoice Data clear
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
     * [Invoice Create & Issue][Search][after Invoice Issue]<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return InvoiceIssueMgtVO
     * @exception EventException
     */
    public InvoiceIssueMgtVO searchIssuedInvoiceBySZPBB(IssuedInvoiceParamVO issuedInvoiceParamVO) throws EventException {
		InvoiceIssueMgtVO invoiceIssueMgtVO		= new InvoiceIssueMgtVO();
		List<InvoiceIssueVO> invoiceIssueList	= null;
		
		List<ChargeBookingInvoiceVO> chargeBookingInvoiceList = null;
		
		try {
			// searchChargeBookingInvoice
			chargeBookingInvoiceList = dbDao.searchBookingInvoice(issuedInvoiceParamVO);
			ChargeBookingInvoiceVO chargeBookingInvoiceVO = chargeBookingInvoiceList.get(0);
			
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
			
			// searchBookingCustomer Search
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

            // if is not exists Due Date = current date, Credit Term = 0.
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());//Issue date
                chargeBookingInvoiceVO.setBilToLocDivCd("");//PRINT  L/R
            }else{
                for(int i = 0; i < listSheetOption.size() ; i++) {
                    chargeBookingInvoiceVO.setIssDtPrnFlg(listSheetOption.get(i).getIssDtPrnFlg());
                    chargeBookingInvoiceVO.setCrTermDys(listSheetOption.get(i).getCrTermDys());
                    chargeBookingInvoiceVO.setTaxRto(listSheetOption.get(i).getDfltTaxRto());
                    chargeBookingInvoiceVO.setBilToLocDivCd(listSheetOption.get(i).getBilToLocDivCd());//PRINT  L/R
                    
                    //if sheet Option Credit Term = 0 
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//if Due Date is "Issue Date", then set  Due Date=current date,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(chargeBookingInvoiceVO.getIssueDay());
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//if Due Date is "*******", then set Due Date: ********, Credit Term: ''
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //if sheet Option Credit Term > 0 
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
			String issue_day 	= chargeBookingInvoiceVO.getIssueDay();	//invoice Create date
			String today 		= DateTime.getShortDateString();		//current date
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
			
			//chg_dc_amt Search
			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
				chg_dc_amt += Double.parseDouble(invoiceIssueList.get(i).getAftExptDcAmt());
			}
			chg_dc_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), chg_dc_amt);
			chargeBookingInvoiceVO.setChgDcAmt(JSPUtil.toDecimalFormat(chg_dc_amt, "#.##"));
			
			
			// Search Invoice Rate Detail
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
     * [Invoice] [ISSUE] .<br>
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
            
            // makeInvoiceNo
            String inv_pfx_cd = dbDao.searchInvPfxCd(account.getOfc_cd());
            if(inv_pfx_cd == null || inv_pfx_cd.equals("")) {
            	dmtInvMnVO.setErrCode("DMT03063");
            	//dmtInvMnVO.setErrMsg("Invoice Prefix code missing for your login office");
            	return dmtInvMnVO;
            }
            
		   //if there is no BL NO, then repace  BL NO of BKG system.
            
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
           
            
            
            
            String inv_sub_cd = "M";
            String inv_max	 = "";
            
            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
            
            inv_max = dbDao.searchMaxInvoiceSeq(dmtInvNoVO);
            invoice_no = inv_pfx_cd + inv_sub_cd + JSPUtil.getLPAD(inv_max, 6, "0");
            
            dmtInvNoVO.setCreOfcCd(account.getOfc_cd());
            dmtInvNoVO.setCreUsrId(account.getUsr_id());
            dmtInvNoVO.setDmdtInvNo(invoice_no);
            dmtInvNoVO.setDmdtInvSeq(inv_max);
            dmtInvNoVO.setDmdtInvTpCd(inv_sub_cd);
            dmtInvNoVO.setInvOfcPfxCd(inv_pfx_cd);
            dmtInvNoVO.setUpdOfcCd(account.getOfc_cd());
            dmtInvNoVO.setUpdUsrId(account.getUsr_id());

            if(inv_max.equals("1")){	//first time
            	dbDao.createInvoiceNo(dmtInvNoVO);
            }else{
                dbDao.modifyInvoiceNo(dmtInvNoVO);
            }

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
            
            //if VslCd = HJXX, HJYY, HJZZ, change common VVD(CFDR+YYMM+E) 
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
            
            //VENDOR 
        	if(chargeBookingInvoiceVO.getPayerCd().length() <= 6) {
                dmtInvMnVO.setActPayrCntCd("00");
                dmtInvMnVO.setActPayrSeq(chargeBookingInvoiceVO.getPayerCd());
                
                //cust
                dmtInvMnVO.setCustCntCd("00");
                dmtInvMnVO.setCustSeq(chargeBookingInvoiceVO.getPayerCd());
           	//CUSTOMER 
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
            dmtInvMnVO.setBilAmt(chargeBookingInvoiceVO.getTotAmt());	// same logic with Manual Invoice
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
//	            log.debug("[svr_id]"+dmtInvDtlVO.getSvrId());
//	            log.debug("[cntr_no]"+dmtInvDtlVO.getCntrNo());
//	            log.debug("[cntr_cyc_no]"+dmtInvDtlVO.getCntrCycNo());
//	            log.debug("[dmdt_trf_cd]"+dmtInvDtlVO.getDmdtTrfCd());
//	            log.debug("[dmdt_chg_loc_div_cd]"+dmtInvDtlVO.getDmdtChgLocDivCd());
//	            log.debug("[chg_seq]"+dmtInvDtlVO.getChgSeq());
//	            log.debug("[cntr_typsz_cd]"+dmtInvDtlVO.getCntrTpszCd());
//	            log.debug("[fm_mvmt_dt]"+dmtInvDtlVO.getFmMvmtDt());
//	            log.debug("[to_mvmt_dt]"+dmtInvDtlVO.getToMvmtDt());
//	            log.debug("[ft_dys]"+dmtInvDtlVO.getFtDys());
//	            log.debug("[ft_cmnc_dt]"+dmtInvDtlVO.getFtCmncDt());
//	            log.debug("[ft_end_dt]"+dmtInvDtlVO.getFtEndDt());
//	            log.debug("[fx_ft_ovr_dys]"+dmtInvDtlVO.getFxFtOvrDys());
//	            log.debug("[org_chg_amt]"+dmtInvDtlVO.getOrgChgAmt());
//	            log.debug("[scRfaExptAmt]"+dmtInvDtlVO.getScRfaExptAmt());
//	            log.debug("[aft_expt_dc_amt]"+dmtInvDtlVO.getAftExptDcAmt());
//	            log.debug("[bil_amt]"+dmtInvDtlVO.getBilAmt());
//	            log.debug("[cntr_inv_amt]"+dmtInvDtlVO.getCntrInvAmt());
//	            log.debug("[tax_rto]"+dmtInvDtlVO.getTaxRto());
//	            log.debug("[tax_amt]"+dmtInvDtlVO.getTaxAmt());
//	            log.debug("[inv_prt_flg]"+dmtInvDtlVO.getInvPrtFlg());
	            //log.debug("============dmdt_inv_dtl=================================");
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
//	                    log.debug("[svr_id]"+dmtInvRtVO.getSvrId());
//	                    log.debug("[bzc_dmdt_trf_cd]"+dmtInvRtVO.getBzcDmdtTrfCd());
//	                    log.debug("[bzc_trf_seq]"+dmtInvRtVO.getBzcTrfSeq());
//	                    log.debug("[bzc_trf_grp_seq]"+dmtInvRtVO.getBzcTrfGrpSeq());
//	                    log.debug("[ft_ovr_dys]"+dmtInvRtVO.getFtOvrDys());
//	                    log.debug("[ft_und_dys]"+dmtInvRtVO.getFtUndDys());
//	                    log.debug("[inv_rt_amt]"+dmtInvRtVO.getInvRtAmt());
//	                    log.debug("[rt_ovr_dys]"+dmtInvRtVO.getRtOvrDys());
//	                    log.debug("[rt_ovr_chg_amt]"+dmtInvRtVO.getRtOvrChgAmt());
//	                    log.debug("[bzc_curr_cd]"+dmtInvRtVO.getBzcCurrCd());
			            log.debug("============dmdt_inv_rt=================================");
	                    dbDao.addInvoiceRate(dmtInvRtVO);		            	
		            }else{
		            	continue;
		            }
	            }
            
            }
            
            
//            //addInvoiceDetail
//            invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
//            
//            for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
//                InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
//                
//                int inv_dtl_seq = dbDao.makeInvoiceDtlSeq(invoice_no, account.getOfc_cd());
//                
////                //CNTR_INV_AMT
////                double cntr_inv_amt = 0;
////                cntr_inv_amt = Double.parseDouble(chargeBookingInvoiceVO.getInvXchRt()) * Double.parseDouble(invoiceIssueParam.getBilAmt());
////                cntr_inv_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), cntr_inv_amt);
////                
////                //TAX_AMT
////                double tax_amt = 0;
////                double tax_rto = Double.parseDouble(chargeBookingInvoiceVO.getTaxRto());
////                
////                //Vietnam 
////                if(account.getCnt_cd().equals("VN")) {
////                	tax_amt = (cntr_inv_amt / (1 - tax_rto * 0.01)) * (tax_rto * 0.01);
////                }else{
////                    tax_amt = cntr_inv_amt * tax_rto * 0.01;
////                }
////                tax_amt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), tax_amt);
//                
//                DmtInvDtlVO dmtInvDtlVO = new DmtInvDtlVO();
//                
//                dmtInvDtlVO.setDmdtInvNo(invoice_no);
//                dmtInvDtlVO.setCreOfcCd(account.getOfc_cd());
//                dmtInvDtlVO.setInvDtlSeq(String.valueOf(inv_dtl_seq));
//                dmtInvDtlVO.setSvrId(invoiceIssueParam.getSvrId());
//                dmtInvDtlVO.setCntrNo(invoiceIssueParam.getCntrNo());
//                dmtInvDtlVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
//                dmtInvDtlVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
//                dmtInvDtlVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
//                dmtInvDtlVO.setChgSeq(invoiceIssueParam.getChgSeq());
//                dmtInvDtlVO.setCntrTpszCd(invoiceIssueParam.getCntrTpszCd());
//                dmtInvDtlVO.setFmMvmtDt(invoiceIssueParam.getFmMvmtDt());
//                dmtInvDtlVO.setToMvmtDt(invoiceIssueParam.getToMvmtDt());
//                dmtInvDtlVO.setFtDys(invoiceIssueParam.getFtDys());
//                dmtInvDtlVO.setFtCmncDt(invoiceIssueParam.getFtCmncDt());
//                dmtInvDtlVO.setFtEndDt(invoiceIssueParam.getFtEndDt());
//                dmtInvDtlVO.setFxFtOvrDys(invoiceIssueParam.getFxFtOvrDys());
//                //dmtInvDtlVO.setOrgChgAmt(invoiceIssueParam.getOrgChgAmt());
//                dmtInvDtlVO.setOrgChgAmt("0");
//                dmtInvDtlVO.setScRfaExptAmt(invoiceIssueParam.getExptAmt());
//                dmtInvDtlVO.setAftExptDcAmt(invoiceIssueParam.getAftExptDcAmt());
//                dmtInvDtlVO.setBilAmt("0");
//                dmtInvDtlVO.setCntrInvAmt("0");
//                dmtInvDtlVO.setTaxRto("0");
//                dmtInvDtlVO.setTaxAmt("0");
//                dmtInvDtlVO.setInvPrtFlg("");
//                dmtInvDtlVO.setCreUsrId(account.getUsr_id());
//                dmtInvDtlVO.setUpdUsrId(account.getUsr_id());
//                dmtInvDtlVO.setUpdOfcCd(account.getOfc_cd());
//                
//                dbDao.addInvoiceDetail(dmtInvDtlVO);
//                
//  
//                /*
//				//Chg_Calc invoice_no update
//                ChargeArgumentVO closingChargeArgumentVO = new ChargeArgumentVO();
//                closingChargeArgumentVO.setSvrId(invoiceIssueParam.getSvrId());
//                closingChargeArgumentVO.setCntrNo(invoiceIssueParam.getCntrNo());
//                closingChargeArgumentVO.setCntrCycNo(invoiceIssueParam.getCntrCycNo());
//                closingChargeArgumentVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
//                closingChargeArgumentVO.setDmdtChgLocDivCd(invoiceIssueParam.getDmdtChgLocDivCd());
//                closingChargeArgumentVO.setChgSeq(invoiceIssueParam.getChgSeq());
//                closingChargeArgumentVO.setDmdtInvNo(invoice_no);
// 				
//                dbDaoCharge.modifyInvoiceNoByInvoice(closingChargeArgumentVO, account.getUsr_id(), account.getOfc_cd());               
//                */
//                
//                   
//                
//                OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
//                overdayNDivParmVO.setSvrId(invoiceIssueParam.getSvrId());
//                overdayNDivParmVO.setCntrNo(invoiceIssueParam.getCntrNo());
//                overdayNDivParmVO.setCnmvCycNo(invoiceIssueParam.getCntrCycNo());
//                overdayNDivParmVO.setDttCode(invoiceIssueParam.getDmdtTrfCd());
//                overdayNDivParmVO.setLocDiv(invoiceIssueParam.getDmdtChgLocDivCd());
//                overdayNDivParmVO.setDccSeq(invoiceIssueParam.getChgSeq());
//                
//                // DivOverDay Search
//                OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
//				
//				
//				CalculationParmVO calculationParmVO = new CalculationParmVO();
//				String trfAplyTpCd = invoiceIssueParam.getDmdtTrfAplyTpCd();
//				calculationParmVO.setDcApplRate(trfAplyTpCd);
//				
//				if(trfAplyTpCd.equals("G")) {
//					// basicCalculation - Baisc Tariff
//					calculationParmVO.setSvrId(invoiceIssueParam.getSvrId());
//					calculationParmVO.setDmdtTrfCd(invoiceIssueParam.getDmdtTrfCd());
//					calculationParmVO.setTrfSeq(invoiceIssueParam.getBzcTrfSeq());
//					calculationParmVO.setTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//					calculationParmVO.setCntrts(dmtInvDtlVO.getCntrTpszCd());
//					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
//					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//					calculationParmVO.setCurCd(invoiceIssueParam.getBzcTrfCurrCd());
//				
//				} else if(trfAplyTpCd.equals("B")) {
//					// beforeCalculation - Before BKG Exception
//					calculationParmVO.setDarNo(invoiceIssueParam.getRfaExptDarNo());
//					calculationParmVO.setMapgSeq(invoiceIssueParam.getRfaExptMapgSeq());
//					calculationParmVO.setVerSeq(invoiceIssueParam.getRfaExptVerSeq());
//					calculationParmVO.setDtlSeq(invoiceIssueParam.getRfaRqstDtlSeq());
//					calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
//					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
//					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//					
//				} else if(trfAplyTpCd.equals("S")) {
//					// scCalculation - SC Exception
//					calculationParmVO.setPropNo(invoiceIssueParam.getScNo());
//					calculationParmVO.setVerSeq(invoiceIssueParam.getScExptVerSeq());
//					calculationParmVO.setGrpSeq(invoiceIssueParam.getScExptGrpSeq());
//					calculationParmVO.setCntrts(invoiceIssueParam.getCntrTpszCd());
//					calculationParmVO.setOverDay(invoiceIssueParam.getFxFtOvrDys());
//					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
//				}
//				
//				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
//                List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
//                
//                if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
//                	
//                	DmtInvRtVO dmtInvRtVO = new DmtInvRtVO();
//                	double rtChrg = 0.0d;
//                	double rtOvrChgAmt = 0.0d;
//                	double invXchRt =  NumberUtils.toDouble(chargeBookingInvoiceVO.getInvXchRt());
//                	
//                	//addInvoiceRate
//                	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
//	                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
//	
//	                    dmtInvRtVO.setDmdtInvNo(dmtInvDtlVO.getDmdtInvNo());
//	                    dmtInvRtVO.setInvDtlSeq(dmtInvDtlVO.getInvDtlSeq());
//	                    dmtInvRtVO.setCreOfcCd(dmtInvDtlVO.getCreOfcCd());
//	                    
//	                    dmtInvRtVO.setSvrId(dmtInvDtlVO.getSvrId());
//	                    dmtInvRtVO.setBzcDmdtTrfCd(dmtInvDtlVO.getDmdtTrfCd());
//	                    dmtInvRtVO.setBzcTrfSeq(invoiceIssueParam.getBzcTrfSeq());
//	                    dmtInvRtVO.setBzcTrfGrpSeq(invoiceIssueParam.getBzcTrfGrpSeq());
//	                    
//	                    dmtInvRtVO.setFtOvrDys(chrgDtlVO.getRtOver());
//	                    dmtInvRtVO.setFtUndDys(chrgDtlVO.getRtUnder());
//	                    
//	                    double invRtAmt = NumberUtils.toDouble(chrgDtlVO.getRtRate()) * invXchRt;
//	                    dmtInvRtVO.setInvRtAmt(JSPUtil.toDecimalFormat(invRtAmt, "#.##"));
//	                    
//	                    dmtInvRtVO.setRtOvrDys(chrgDtlVO.getRtDay());
//	                    
//	                    // Rate Detail Billable AMT 데이터 계산
//	                    rtChrg = NumberUtils.toDouble(chrgDtlVO.getRtChrg());
//	                    rtOvrChgAmt = rtChrg * invXchRt;
//	                    rtOvrChgAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(), rtOvrChgAmt);
//	                    
//	                    dmtInvRtVO.setRtOvrChgAmt(JSPUtil.toDecimalFormat(rtOvrChgAmt, "#.##"));
//	                    dmtInvRtVO.setBzcCurrCd(chargeBookingInvoiceVO.getInvCurrCd());
//	                    
//	                    dmtInvRtVO.setCreUsrId(account.getUsr_id());
//	                    dmtInvRtVO.setCreOfcCd(account.getOfc_cd());
//	                    dmtInvRtVO.setUpdUsrId(account.getUsr_id());
//	                    dmtInvRtVO.setUpdOfcCd(account.getOfc_cd());
//	                    
//	                    dbDao.addInvoiceRate(dmtInvRtVO);
//                	}
//                }
//            }
            
            dmtInvMnVO.setErrCode("DMT03064");//success message
            
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
     * Save sentting information of AR Interface.
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
     * Search sending information of AR Interface.
     * @param SignOnUserAccount account
     * @param String invoiceNo
     * @param String creditNoteYn
     * @param String creOfcCd
     * @return ARInterfaceCreationVO
     * @throws EventException
     */
    public ARInterfaceCreationVO searchARInterfaceInvoice(SignOnUserAccount account, String invoiceNo, String creditNoteYn, String creOfcCd) throws EventException {
        //List<ARInterfaceCreationVO> genIfVOs = new ArrayList<ARInterfaceCreationVO>();
    	ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
    	//List<InvArIfMnVO> invArIfMnVOs = null;
    	InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
    	List<InvArIfChgVO> invArIfChgVOs = new ArrayList<InvArIfChgVO>() ;
    	List<InvArIfCntrVO> invArIfCntrVOs = new ArrayList<InvArIfCntrVO>() ;
    	
//    	List<InterfaceChargeCalculationVO> list = null;
    	
    	String chg_seq 		= "";
    	String invoice_type ="";
//    	String ar_ofc_cd 	= "";
    	
    	try{
    		invArIfMnVO 	= dbDao.searchInterfaceInvoice(account.getOfc_cd(), invoiceNo, creOfcCd);		
    		invArIfCntrVOs	= dbDao.searchInterfaceContainer(invoiceNo, creOfcCd);
    		
    
        	IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
    		issuedInvoiceParamVO.setSInvoiceNo(invoiceNo);
    		issuedInvoiceParamVO.setOfcCd(creOfcCd);

        	String ofc_trns_flg = "N";	
        	List<InvoiceIssueVO> invoiceIssueList	= null;
    		
    		invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
    		
    		if(invoiceIssueList != null && invoiceIssueList.size() > 0) {
    			ofc_trns_flg = invoiceIssueList.get(0).getOfcTrnsFlg();
    		}
    		invArIfMnVO.setOfcTrnsFlg(ofc_trns_flg);
    		//-------------------------------------
    		
    		invoice_type = invoiceNo.substring(2, 3);
    		
    		//1. case in Manual Invoice 
    		if(invoice_type.equals("M")){
    			//1-1 if there is no DTL
    			String tempValue = dbDao.checkDmtInvDtl(invoiceNo, creOfcCd);
    			if(!tempValue.equals("Y")){
    				InvArIfChgVO invArIfChgAddVO = dbDao.searchInterfaceManualCharge(invoiceNo, creOfcCd);
    				invArIfChgVOs.add(invArIfChgAddVO);
    				//double dis_amt = dbDao.
    				invArIfCntrVOs	= dbDao.searchInterfaceManualContainer(invoiceNo, creOfcCd);
    			}else{
    				invArIfChgVOs 	= dbDao.searchInterfaceCharge(invoiceNo, creOfcCd);
    			}
    			
        		//-- case in  Manual Invoice,  if amount is Discount, then create more one data and do AR interface .(BIL_AMT - INV_CHG_AMT = 0)
    			String[] r_data = dbDao.checkManualARIFAmt(invoiceNo, creOfcCd);
    			double d_amt = Double.parseDouble(r_data[0]);
    			if( d_amt != 0) {
    				InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
    				
    				invArIfChgVO.setSrcIfDt("");
    				invArIfChgVO.setSrcIfSeq("");
    				invArIfChgVO.setChgSeq(String.valueOf(invArIfChgVOs.size() + 1));
    				invArIfChgVO.setCurrCd(r_data[1]);
    				invArIfChgVO.setChgCd(invArIfChgVOs.get(0).getChgCd());
    				invArIfChgVO.setPerTpCd(invArIfChgVOs.get(0).getPerTpCd());
    				
    				d_amt 		= dmtCalculationUtil.trimCurrencyAmount(r_data[1], d_amt);	//trf_rt_amt amount (curr_cd)
					invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(d_amt, "#.##"));
					invArIfChgVO.setRatAsCntrQty("1");
					invArIfChgVO.setChgAmt(JSPUtil.toDecimalFormat(d_amt * -1, "#.##"));
					invArIfChgVO.setTrfNo(invArIfChgVOs.get(0).getTrfNo());
					invArIfChgVO.setTvaFlg(invArIfChgVOs.get(0).getTvaFlg());
					invArIfChgVO.setCreUsrId(invArIfChgVOs.get(0).getCreUsrId());
					invArIfChgVO.setCreDt(invArIfChgVOs.get(0).getCreDt());
					invArIfChgVO.setUpdUsrId(invArIfChgVOs.get(0).getUpdUsrId());
					invArIfChgVO.setUpdDt(invArIfChgVOs.get(0).getUpdDt());
		       
					invArIfChgVOs.add(invArIfChgVO);
    			}
    			//
        		
    			
    		//2. 
    		}else{

    				
    				// if INVOICE_STATUS = I  and  OVER DAY = 0 , do not AR-IF
    				// if  INVOICE_STATUS = C , then do not AR-IF except OVER DAY = 0 .
    				if(creditNoteYn.equals("Y"))
    				{
    					
        				invArIfChgVOs 	= dbDao.searchInterfaceChargeCreateNoteByInvoiceDetail(invoiceNo, creOfcCd);
    				}else{
    					String cntrNo = dbDao.searchInvoiceDetailZeroOverDay(invoiceNo, creOfcCd);
    					if(cntrNo == null || cntrNo.equals("") ) 
    					{
    						invArIfChgVOs = dbDao.searchInterfaceChargeByInvoiceDetail(invoiceNo, creOfcCd);
    						
    					}else{
    						
    						String message = new ErrorHandler("DMT03071").getUserMessage();
    						message = JSPUtil.replace(message, "$1", cntrNo);
    						
    						invArIfChgVOs = null;
    						invArIfMnVO = new InvArIfMnVO();
    						invArIfMnVO.setArIfNo(message);	//server error message
    						arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
    						return arInterfaceCreationVO;
    						
    					}
    				}
    				
    				if(invArIfChgVOs != null && invArIfChgVOs.size() > 0) 
    				{
    					InvArIfChgVO invArIfChgVO 	= new InvArIfChgVO();
    					double trf_rt_amt 			= 0;
    					String curr_cd 				= "";
    					
    					for(int i = 0 ; i < invArIfChgVOs.size() ; i++) {
    						invArIfChgVO 	= (InvArIfChgVO)invArIfChgVOs.get(i);
    						trf_rt_amt 		= Double.parseDouble(invArIfChgVO.getTrfRtAmt());
    						curr_cd 		= invArIfChgVO.getCurrCd();
    						
    						trf_rt_amt 		= dmtCalculationUtil.trimCurrencyAmount(curr_cd, trf_rt_amt);	//trf_rt_amt amount (curr_cd)
    						invArIfChgVO.setTrfRtAmt(JSPUtil.toDecimalFormat(trf_rt_amt, "#.##"));
    						invArIfChgVOs.set(i, invArIfChgVO);
    					}
    				}
    				
    		}
    		
    		//======================================================
    		boolean isTva = false;
    		
    		//if TVA_FLAG = 'Y', then create one more Row.
    		if(invArIfChgVOs != null)  {
	    		for(int i = 0 ; i < invArIfChgVOs.size() ; i++) {
	    			if(invArIfChgVOs.get(i).getTvaFlg().equals("Y")){
	    				isTva = true;
	    				break;
	    			}
	    		}
    		}
    		
    		if(isTva) {
    			chg_seq = String.valueOf(invArIfChgVOs.size() + 1);
    			InvArIfChgVO invArIfChgAddVO = dbDao.searchInterfaceTaxAmt(account.getOfc_cd(),invoiceNo, chg_seq, creOfcCd);
    			invArIfChgVOs.add(invArIfChgAddVO);
    		}
    		
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
    		//invArIfMnVO.setDestTrnsSvcModCd(""); 
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
    		
    		log.debug("\n####[AP_APR_OFFST_NO		]"+invArIfMnVO.getApArOffstNo());
    		log.debug("\n####[AP_AR_IF_NO			]"+invArIfMnVO.getArIfNo());
    		log.debug("\n####[BKG_CORR_DT			]"+invArIfMnVO.getBkgCorrDt());
    		log.debug("\n####[BKG_CORR_NO			]"+invArIfMnVO.getBkgCorrNo());
    		log.debug("\n####[BKG_FEU_QTY			]"+invArIfMnVO.getBkgFeuQty());
    		log.debug("\n####[BKG_NO				]"+invArIfMnVO.getBkgNo());
    		log.debug("\n####[BKG_REF_NO			]"+invArIfMnVO.getBkgRefNo());
    		log.debug("\n####[BKG_TEU_QTY			]"+invArIfMnVO.getBkgTeuQty());
    		log.debug("\n####[BL_INV_IF_DT			]"+invArIfMnVO.getBlInvIfDt());
    		log.debug("\n####[BL_INV_IFFLG			]"+invArIfMnVO.getBlInvIfFlg());
    		log.debug("\n####[BL_NO					]"+invArIfMnVO.getBlNo());
    		log.debug("\n####[BL_SRC_NO				]"+invArIfMnVO.getBlSrcNo());
    		log.debug("\n####[BL_TP_CD				]"+invArIfMnVO.getBlTpCd());
    		log.debug("\n####[CGO_MEAS_QTY			]"+invArIfMnVO.getCgoMeasQty());
    		log.debug("\n####[CGO_WGT				]"+invArIfMnVO.getCgoWgt());
    		log.debug("\n####[CRE_DT				]"+invArIfMnVO.getCreDt());
    		log.debug("\n####[CRE_USR_ID			]"+invArIfMnVO.getCreUsrId());
    		log.debug("\n####[CUST_CNT_CD			]"+invArIfMnVO.getCustCntCd());
    		log.debug("\n####[CUST_SEQ				]"+invArIfMnVO.getCustSeq());
    		log.debug("\n####[DEL_CD				]"+invArIfMnVO.getDelCd());
    		log.debug("\n####[DEST_TRNS_SVC_MOD_CD	]"+invArIfMnVO.getDestTrnsSvcModCd());
    		log.debug("\n####[DUE_DT				]"+invArIfMnVO.getDueDt());
    		log.debug("\n####[FRT_FWRD_CNT_CD		]"+invArIfMnVO.getFrtFwrdCntCd());
    		log.debug("\n####[FRT_FWRD_CUST_SEQ		]"+invArIfMnVO.getFrtFwrdCustSeq());
    		log.debug("\n####[GL_EFF_DT				]"+invArIfMnVO.getGlEffDt());
    		log.debug("\n####[IF_SRC_CD				]"+invArIfMnVO.getIfSrcCd());
    		log.debug("\n####[INV_REF_NO			]"+invArIfMnVO.getInvRefNo());
    		log.debug("\n####[INV_RMK				]"+invArIfMnVO.getInvRmk());
    		log.debug("\n####[INV_SRC_NO			]"+invArIfMnVO.getInvSrcNo());
    		log.debug("\n####[IO_BND_CD				]"+invArIfMnVO.getIoBndCd());
    		log.debug("\n####[MST_BL_NO				]"+invArIfMnVO.getMstBlNo());
    		log.debug("\n####[OFC_CD				]"+invArIfMnVO.getOfcCd());
    		log.debug("\n####[POD_CD				]"+invArIfMnVO.getPodCd());
    		log.debug("\n####[POL_CD				]"+invArIfMnVO.getPolCd());
    		log.debug("\n####[POR_CD				]"+invArIfMnVO.getPorCd());
    		log.debug("\n####[RFA_NO				]"+invArIfMnVO.getRfaNo());
    		log.debug("\n####[SAIL_ART_DT			]"+invArIfMnVO.getSailArrDt());
    		log.debug("\n####[SAIL_DT				]"+invArIfMnVO.getSailDt());
    		log.debug("\n####[SC_NO					]"+invArIfMnVO.getScNo());
    		log.debug("\n####[SI_REF_NO				]"+invArIfMnVO.getSiRefNo());
    		log.debug("\n####[SKD_DIR_CD			]"+invArIfMnVO.getSkdDirCd());
    		log.debug("\n####[SKD_VOY_NO			]"+invArIfMnVO.getSkdVoyNo());
    		log.debug("\n####[SLAN_CD				]"+invArIfMnVO.getSlanCd());
    		log.debug("\n####[SLS_OFC_CD			]"+invArIfMnVO.getSlsOfcCd());
    		log.debug("\n####[SRC_IF_DT				]"+invArIfMnVO.getSrcIfDt());
    		log.debug("\n####[SRC_IF_SEQ			]"+invArIfMnVO.getSrcIfSeq());
    		log.debug("\n####[SREP_CD				]"+invArIfMnVO.getSrepCd());
    		log.debug("\n####[SVC_SCP_CD			]"+invArIfMnVO.getSvcScpCd());
    		log.debug("\n####[TRNK_SKD_DIR_CD		]"+invArIfMnVO.getTrnkSkdDirCd());
    		log.debug("\n####[TRNK_SKD_VOY_NO		]"+invArIfMnVO.getTrnkSkdVoyNo());
    		log.debug("\n####[TRNK_VSL_CD			]"+invArIfMnVO.getTrnkVslCd());
    		log.debug("\n####[TRSP_RQST_ORD_FLG		]"+invArIfMnVO.getTrspRqstOrdFlg());
    		log.debug("\n####[UPD_DT				]"+invArIfMnVO.getUpdDt());
    		log.debug("\n####[UPD_USR_ID			]"+invArIfMnVO.getUpdUsrId());
    		log.debug("\n####[VSL_CD				]"+invArIfMnVO.getVslCd());
    		log.debug("\n####[VVD_TRNS_FLG			]"+invArIfMnVO.getVvdTrnsFlg());
    		log.debug("\n####[WHF_DECL_CFM_DT		]"+invArIfMnVO.getWhfDeclCfmDt());
    		log.debug("\n####[WHF_DECL_DIR_CD		]"+invArIfMnVO.getWhfDeclDirCd());
    		log.debug("\n####[WHF_DECL_NO			]"+invArIfMnVO.getWhfDeclNo());
    		log.debug("\n####[WHF_DECL_OFC_CD		]"+invArIfMnVO.getWhfDeclOfcCd());
    		log.debug("\n####[WHF_DECL_VOY_NO		]"+invArIfMnVO.getWhfDeclVoyNo());
    		log.debug("\n####[WHF_DECL_VSL_CD		]"+invArIfMnVO.getWhfDeclVslCd());
    		log.debug("\n####[WHF_MRN_NO			]"+invArIfMnVO.getWhfMrnNo());
    		log.debug("\n####[OFC_TRNS_FLG			]"+invArIfMnVO.getOfcTrnsFlg());
    		
    		log.debug("\n##################### IN INTERFACE CHARGE ###############################");
    		if(invArIfChgVOs != null)  {
	    		for(int i = 0 ; i < invArIfChgVOs.size() ; i++) {
	    			log.debug("\n####[-- row ----"+i+"------]");
	    			invArIfChgVOs.get(i).setChgFullNm("");
	    			invArIfChgVOs.get(i).setChgRmk("");
	    			invArIfChgVOs.get(i).setInvXchRt("");
	    			invArIfChgVOs.get(i).setRepChgCd("");
	    			
	    			log.debug("\n####[CHG_AMT			]"+invArIfChgVOs.get(i).getChgAmt());
	    			log.debug("\n####[CHG_CD			]"+invArIfChgVOs.get(i).getChgCd());
	    			log.debug("\n####[CHG_FULL_NM		]"+invArIfChgVOs.get(i).getChgFullNm());
	    			log.debug("\n####[CHG_RMK			]"+invArIfChgVOs.get(i).getChgRmk());
	    			log.debug("\n####[CHG_SEQ			]"+invArIfChgVOs.get(i).getChgSeq());
	    			log.debug("\n####[CRE_DT			]"+invArIfChgVOs.get(i).getCreDt());
	    			log.debug("\n####[CRE_USR_ID		]"+invArIfChgVOs.get(i).getCreUsrId());
	    			log.debug("\n####[CURR_CD			]"+invArIfChgVOs.get(i).getCurrCd());
	    			log.debug("\n####[INV_XCH_RT		]"+invArIfChgVOs.get(i).getInvXchRt());
	    			log.debug("\n####[PER_TP_CD			]"+invArIfChgVOs.get(i).getPerTpCd());
	    			log.debug("\n####[RAT_AS_CNTR_QTY	]"+invArIfChgVOs.get(i).getRatAsCntrQty());
	    			log.debug("\n####[REP_CHG_CD		]"+invArIfChgVOs.get(i).getRepChgCd());
	    			log.debug("\n####[SRC_IF_DT			]"+invArIfChgVOs.get(i).getSrcIfDt());
	    			log.debug("\n####[SRC_IF_SEQ		]"+invArIfChgVOs.get(i).getSrcIfSeq());
	    			log.debug("\n####[TRF_NO			]"+invArIfChgVOs.get(i).getTrfNo());
	    			log.debug("\n####[TRF_RT_AMT		]"+invArIfChgVOs.get(i).getTrfRtAmt());
	    			log.debug("\n####[TVA_FLG			]"+invArIfChgVOs.get(i).getTvaFlg());
	    			log.debug("\n####[UPD_DT			]"+invArIfChgVOs.get(i).getUpdDt());
	    			log.debug("\n####[UPD_USR_ID		]"+invArIfChgVOs.get(i).getUpdUsrId());
	    		}
    		}
    		log.debug("\n##################### IN INTERFACE CONTAINER ###############################");
    		for(int i = 0 ; i < invArIfCntrVOs.size() ; i++) {
    			log.debug("\n####[---row--"+i+"------]");
    			log.debug("\n####[CNTR_NO			]"+invArIfCntrVOs.get(i).getCntrNo());
    			log.debug("\n####[CNTR_SEQ			]"+invArIfCntrVOs.get(i).getCntrSeq());
    			log.debug("\n####[CNTR_TPSZ_CD		]"+invArIfCntrVOs.get(i).getCntrTpszCd());
    			log.debug("\n####[CRE_DT			]"+invArIfCntrVOs.get(i).getCreDt());
    			log.debug("\n####[CRE_USR_ID		]"+invArIfCntrVOs.get(i).getCreUsrId());
    			log.debug("\n####[SRC_IF_DT			]"+invArIfCntrVOs.get(i).getSrcIfDt());
    			log.debug("\n####[SRC_IF_SEQ		]"+invArIfCntrVOs.get(i).getSrcIfSeq());
    			log.debug("\n####[UPD_DT			]"+invArIfCntrVOs.get(i).getUpdDt());
    			log.debug("\n####[UPD_USR_ID		]"+invArIfCntrVOs.get(i).getUpdUsrId());
    		}
    		//
    		arInterfaceCreationVO.setInvArIfMnVO(invArIfMnVO);
    		if(invArIfChgVOs != null) arInterfaceCreationVO.setInvArIfChgVOs(invArIfChgVOs);
    		arInterfaceCreationVO.setInvArIfCntrVOs(invArIfCntrVOs);
    		
        } catch(DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler("DMT00003").getUserMessage());	
        }
    	return arInterfaceCreationVO;
    }       
    
    
    /**
     * After Create group invoice, save charge information
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
	    			//if there is no checked CheckBox , do not save.
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
    		}else{//Group by (Cntr No) - only selected CONTAINER.
   			log.debug("-----------------5------------------");
   				
    			for(int i = 0; i < list.size(); i++) {
    				ConfirmChargeListVO confirmChargeListVO = (ConfirmChargeListVO)list.get(i);
    	   			log.debug("-----------------5---check_box---------------"+confirmChargeListVO.getCheckBox());
    	   			log.debug("-----------------5---inv_no---------------"+confirmChargeListVO.getDmdtInvNo());
    	   			log.debug("-----------------5---bkg_no---------------"+confirmChargeListVO.getBkgNo());
    	   			log.debug("-----------------5---dmdt_trf_cd---------------"+confirmChargeListVO.getDmdtTrfCd());
    	   			log.debug("-----------------5---cntr_no---------------"+confirmChargeListVO.getCntrNo());

    	   			//if there is no checked CheckBox , do not save.
	    			if(confirmChargeListVO.getCheckBox().equals("1")) {
	    				String invoice_no = confirmChargeListVO.getDmdtInvNo();
	    				
	    				issuedInvoiceParamVO.setSBkgNo(confirmChargeListVO.getBkgNo());
	    				issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVO.getDmdtTrfCd());
	    				issuedInvoiceParamVO.setDmdtChgStsCds("C");
	    	            issuedInvoiceParamVO.setSOfcCd(confirmChargeListVO.getOfcCd());		//charge office code
	    				
	    				tempList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	    	            
	    	            for(int j=0 ; j < tempList.size() ; j++) {
	    	            	InvoiceIssueVO tempVO = (InvoiceIssueVO)tempList.get(j);
	    	            	//case in container no exists, send  charge data.
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
     * Search cntr count by Bkg <br>
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
     * Search VVD data.
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
     * Search fax and email information by Payer
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
    		//1. email Search
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
    		
    		
    		//2. fax Search
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
     *  Search manual invoice MASTER  data of INVOICE RD <br>
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
    		//recalculate Sub Total with RT
    		//=========================================
    		//2017.01.12 #23259 India Invoice
    		//2015.10.27 #7995 comment start
    		// 2015.03.19 append india case
    		
    		String iss_dt = reInvoiceIssueMasterPreviewVO.getRdIssueDay();
    		String cre_cnt_cd = reInvoiceIssueMasterPreviewVO.getRdCreCntCd();
    		
    		if (("IN").equals(cre_cnt_cd)){
	    		SearchIndiaGstRateVO indiaGstRateVO = dbDao.searchIndiaGstRate(iss_dt);
	    		reInvoiceIssueMasterPreviewVO.setRdTaxRgstNo(indiaGstRateVO.getTaxRgstNo());
	    		reInvoiceIssueMasterPreviewVO.setRdSvcCateRmk(indiaGstRateVO.getSvcCateRmk());
	    		reInvoiceIssueMasterPreviewVO.setRdPmntAcctNo(indiaGstRateVO.getPmntAcctNo());
	    		log.debug("indiaGstRateVO.getTaxRgstNo()============"+indiaGstRateVO.getTaxRgstNo());
	    		log.debug("reInvoiceIssueMasterPreviewVO.setRdTaxRgstNo============"+reInvoiceIssueMasterPreviewVO.getRdTaxRgstNo());
    		}
    		// append india case
    		//2015.10.27 #7995 comment e n d
    		//=========================================
    		
    		if(invoiceIssueRDParamVO.getJspno().equals("4002"))	{
    			issuedInvoiceParamVO.setSInvoiceNo(invoiceIssueRDParamVO.getInvoiceNo());
    			issuedInvoiceParamVO.setOfcCd(invoiceIssueRDParamVO.getCreOfcCd());
    			double tot_sub_amt = 0;
                //Discount Amount + Exception Amount > 0
                double dScRfaExptAmt = 0;
                double dAftExptDcAmt = 0;
                double dCmdtExptAmt  = 0;
                
                double tot_amt = 0;
                double discount_amt = 0;

    			
    			//detail Search
    			invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
    			
    			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
    				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
    				
    				//OVER DAYSearch
    				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
                    overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
                    overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
                    overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
                    overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
                    overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
                    overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
                    
                    //DivOverDay Search
                    OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
                	
                    String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
    				
    				CalculationParmVO calculationParmVO = new CalculationParmVO();
    				calculationParmVO.setDcApplRate(trfAplyTpCd);
    				
					/*
					  according to Tariff Calculate Charge amount.
            			  A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
            			  B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
            			  C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
            			  D) if applied Currency different  A), B), C) 's Currency
            			       1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
            			       2) 1)amount round by Currency

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
    	            		
    	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
    	            	}else{
    	            		firstSvrID = invoiceIssueVO.getSvrId();
    	            	}
    					
    					// basicCalculation - Baisc Tariff
    					calculationParmVO.setSvrId(firstSvrID);
    					calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
    					calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
    					calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					//calculationParmVO.setOverDay(invoiceIssueVO.getOrgFtOvrDys());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    					calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
    				
    				} else if(trfAplyTpCd.equals("B")) {
    					// beforeCalculation - Before BKG Exception
    					calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
    					calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
    					calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
    					calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
    					calculationParmVO.setCmbSeq("1");
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    					
    				} else if(trfAplyTpCd.equals("S")) {
    					// scCalculation - SC Exception
    					calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
    					calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
    					calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
    				} 
    				
    				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
    	            
    	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
    	            String rateCurrCd = calculationAMTVO.getRateCurCd();
    	            ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
    	            double rtExchangeRate 	= 0;
    	            double amount			= 0;
    	            
    	            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
    	            	//addInvoiceRate
                    	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
    	                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
    	                    
    	                    //if over_day > 0 , then save.
    	                    if(Double.parseDouble(chrgDtlVO.getRtDay()) == 0 ) {
    	                    	continue;
    	                    }
    	                    
    	                    //if rate CurrCd is differnet charge CurrCd, then  get charge amt multiply rateCrrCd
    	                    if(!rateCurrCd.equals(invoiceIssueVO.getBzcTrfCurrCd())) {
    	                    	exchangeRateParmVO = new ExchangeRateParmVO();
    		                    
    		                    exchangeRateParmVO.setVslCd(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(0,4));
    		                    exchangeRateParmVO.setSkdVoyageNo(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(4,8));
    		                    exchangeRateParmVO.setSkdDirCd(reInvoiceIssueMasterPreviewVO.getRdVvdCd().substring(8));
    		                    exchangeRateParmVO.setIoBnd(reInvoiceIssueMasterPreviewVO.getRdDmdtTrfCd().substring(2,3));
    		                    exchangeRateParmVO.setPolLoc(reInvoiceIssueMasterPreviewVO.getPolCd());
    		                    exchangeRateParmVO.setPodLoc(reInvoiceIssueMasterPreviewVO.getPodCd()); 
    		                    exchangeRateParmVO.setFmCurCd(rateCurrCd);								//rate currency
    		                    exchangeRateParmVO.setToCurCd(reInvoiceIssueMasterPreviewVO.getRdOrgCurrCd());	//chg currency
    		                    exchangeRateParmVO.setOfcCd(invoiceIssueVO.getChgOfcCd());		//charge office
    		                    
    		                    rtExchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
        	    				amount = Double.parseDouble(chrgDtlVO.getRtChrg());
    		            		
        	    				amount = rtExchangeRate * amount;
        	    				//amount = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd,amount);
    		                    
    		                    log.debug("---rate Currency -->"+rateCurrCd);
    		                    log.debug("---rate Exchange Rate-->"+rtExchangeRate);
    		                    log.debug("---amount-->"+amount);
    	                    }else{
    	                    	amount = Double.parseDouble(chrgDtlVO.getRtChrg());
    	                    	//amount = dmtCalculationUtil.trimCurrencyAmount(rateCurrCd,amount);
    	                    }
    	                    
    	    				tot_sub_amt += amount;
                    	}
    	            }
    	            dScRfaExptAmt += Double.parseDouble(invoiceIssueVO.getExptAmt());
                    dAftExptDcAmt += Double.parseDouble(invoiceIssueVO.getAftExptDcAmt());
                    dCmdtExptAmt  += Double.parseDouble(invoiceIssueVO.getCmdtExptAmt());
    			}    			
    			tot_sub_amt = dmtCalculationUtil.trimCurrencyAmount(reInvoiceIssueMasterPreviewVO.getRdOrgCurrCd(), tot_sub_amt);    			
    			log.debug("--tot_sub_amt--> "+tot_sub_amt);
//    			if(reInvoiceIssueMasterPreviewVO.getRdDmdtInvStsCd().equals("C")){	//Credit Note
//    				tot_sub_amt = tot_sub_amt * (-1);
//    			}
    			reInvoiceIssueMasterPreviewVO.setRdOrgChgAmt(JSPUtil.toDecimalFormat(tot_sub_amt,"#,##0.00"));
    			
    			log.debug("--exRate-->"+reInvoiceIssueMasterPreviewVO.getRdInvXchRt());
    			//추가 TOT_AMT Modify
    			tot_amt = tot_sub_amt * Double.parseDouble(reInvoiceIssueMasterPreviewVO.getRdInvXchRt());
    			log.debug("--tot_amt--> "+tot_amt);
    			tot_amt = dmtCalculationUtil.trimCurrencyAmount(reInvoiceIssueMasterPreviewVO.getRdInvCurrCd(), tot_amt);
    			reInvoiceIssueMasterPreviewVO.setRdTotAmt(JSPUtil.toDecimalFormat(tot_amt,"#,##0.00"));
    			
    			log.debug("--inv_chg_amt-->"+reInvoiceIssueMasterPreviewVO.getRdInvChgAmt());
    			//DISCOUNT AMT Modify
    			discount_amt = tot_amt - Double.parseDouble(JSPUtil.replace(reInvoiceIssueMasterPreviewVO.getRdInvChgAmt(), ",", ""));// number type error
    			log.debug("--discount_amt--> "+discount_amt);
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
     * INVOICE RD의 incCntlDtail 값이 No 인 manual invoice MASTER 데이터를 조회한다.<br>
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws EventException
     */
    
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreviewNo(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws EventException {
    	InvoiceIssueMasterPreviewVO reInvoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
    	SearchIndiaGstRateVO indiaGstRateVO = new SearchIndiaGstRateVO();
    	try {
    		reInvoiceIssueMasterPreviewVO = dbDao.searchInvoiceIssueMasterPreviewNo(invoiceIssueRDParamVO);
    		
    		String iss_dt = reInvoiceIssueMasterPreviewVO.getRdIssueDay();
    		indiaGstRateVO = dbDao.searchIndiaGstRate(iss_dt);
    		reInvoiceIssueMasterPreviewVO.setRdTaxRgstNo(indiaGstRateVO.getTaxRgstNo());
    		reInvoiceIssueMasterPreviewVO.setRdSvcCateRmk(indiaGstRateVO.getSvcCateRmk());
    		reInvoiceIssueMasterPreviewVO.setRdPmntAcctNo(indiaGstRateVO.getPmntAcctNo());
    		
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
     * Search invoice DETAIL data of INVOICE RD.<br>
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
    			//check invoice status
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
        				int dToMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getToMvmtDt());
        				int dFtCmncDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFtCmncDt());
        				int dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());

        				textForRD.append(dFmMvmtDt + dl); 			//FROM
        				textForRD.append(dToMvmtDt + dl); 			//TO
        				
        				//Cancel 
        				if(dFtEndDt < dFmMvmtDt) {
        					log.debug("<1>"+dFtEndDt+":"+dFtCmncDt+"<<");
        					textForRD.append("" + dl); 			//CMNC
        					textForRD.append("" + dl); 			//CMPLT
        				}else{
        					log.debug("<2>"+dFtEndDt+":"+dFtCmncDt+"<<");
        					textForRD.append(dFtCmncDt + dl); 			//CMNC
        					textForRD.append(dFtEndDt + dl); 			//CMPLT
        				}

        				//cancel
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
    			
	        		cancel_yn = dbDao.checkInvoiceCancel(invoiceIssueRDParamVO.getInvoiceNo(), invoiceIssueRDParamVO.getCreOfcCd());	// check Invoice Cancel
	
	        		IssuedInvoiceParamVO issuedInvoiceParamVO = new IssuedInvoiceParamVO();
	    			issuedInvoiceParamVO.setSInvoiceNo(invoiceIssueRDParamVO.getInvoiceNo());
	    			issuedInvoiceParamVO.setOfcCd(invoiceIssueRDParamVO.getCreOfcCd());
	    			
	    			//detail Search
	    			invoiceIssueList = dbDao.searchInvoiceDetail(issuedInvoiceParamVO);
	    			
	    			for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
	    				InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
	    				
	    				//OVER DAYSearch
	    				OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
	                    overdayNDivParmVO.setSvrId(invoiceIssueVO.getSvrId());
	                    overdayNDivParmVO.setCntrNo(invoiceIssueVO.getCntrNo());
	                    overdayNDivParmVO.setCnmvCycNo(invoiceIssueVO.getCntrCycNo());
	                    overdayNDivParmVO.setDttCode(invoiceIssueVO.getDmdtTrfCd());
	                    overdayNDivParmVO.setLocDiv(invoiceIssueVO.getDmdtChgLocDivCd());
	                    overdayNDivParmVO.setDccSeq(invoiceIssueVO.getChgSeq());
	                    
	                    // DivOverDay Search
	                    OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);            	
	                	
	                    String trfAplyTpCd = invoiceIssueVO.getDmdtTrfAplyTpCd();
	    				
	    				CalculationParmVO calculationParmVO = new CalculationParmVO();
	    				calculationParmVO.setDcApplRate(trfAplyTpCd);
	                    
    				/*
    				  according to Tariff Calculate Charge amount.
    			    A) if "G"(Basic Tariff), Search calculate charge by date Rate of Basic Tariff
    			    B) if "B"(Before Exception), Search calculate charge by date Rate of Before Exception Tariff and  Search Currency of Before Exception
    			    C) if "S"(S/C Exception),  Search calculate charge by date Rate of S/C Exception Tariff and  Search Currency of S/C Exception
    			    D) if applied Currency different  A), B), C) 's Currency
    			         1) Search applied CurrencyExchange Rate and Calculate Charge amount multiply Exchange Rate
    			         2) 1)amount round by Currency
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
	    	            		
	    	            		firstSvrID = dmtCalculationUtil.searchFirstSvrID(chargeCalculationParmVO);
	    	            	}else{
	    	            		firstSvrID = invoiceIssueVO.getSvrId();
	    	            	}
	    					
	    					// basicCalculation - Baisc Tariff
	    					calculationParmVO.setSvrId(firstSvrID);
	    					calculationParmVO.setDmdtTrfCd(invoiceIssueVO.getDmdtTrfCd());
	    					calculationParmVO.setTrfSeq(invoiceIssueVO.getBzcTrfSeq());
	    					calculationParmVO.setTrfGrpSeq(invoiceIssueVO.getBzcTrfGrpSeq());
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					//calculationParmVO.setOverDay(invoiceIssueVO.getOrgFtOvrDys());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	    					calculationParmVO.setCurCd(invoiceIssueVO.getBzcTrfCurrCd());
	    				
	    				} else if(trfAplyTpCd.equals("B")) {
	    					// beforeCalculation - Before BKG Exception
	    					calculationParmVO.setDarNo(invoiceIssueVO.getRfaExptDarNo());
	    					calculationParmVO.setMapgSeq(invoiceIssueVO.getRfaExptMapgSeq());
	    					calculationParmVO.setVerSeq(invoiceIssueVO.getRfaExptVerSeq());
	    					calculationParmVO.setDtlSeq(invoiceIssueVO.getRfaRqstDtlSeq());
	    					calculationParmVO.setCmbSeq("1");
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	    					
	    				} else if(trfAplyTpCd.equals("S")) {
	    					// scCalculation - SC Exception
	    					calculationParmVO.setPropNo(invoiceIssueVO.getScNo());
	    					calculationParmVO.setVerSeq(invoiceIssueVO.getScExptVerSeq());
	    					calculationParmVO.setGrpSeq(invoiceIssueVO.getScExptGrpSeq());
	    					calculationParmVO.setCntrts(invoiceIssueVO.getCntrTpszCd());
	    					calculationParmVO.setOverDay(invoiceIssueVO.getFxFtOvrDys());
	    					calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
	    				}                    
	                    
	    				CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);                
	    	            
	    	            List<ChrgDtlVO> chrgDtlVOS = calculationAMTVO.getChrgDtlVOS();
	    	            String rateCurrCd = calculationAMTVO.getRateCurCd();
	                    
	    	            if(chrgDtlVOS != null && chrgDtlVOS.size() > 0) {
	    	            	//addInvoiceRate
	                    	for ( int j = 0; j < chrgDtlVOS.size() ; j++) {
	    	                    ChrgDtlVO chrgDtlVO = (ChrgDtlVO)chrgDtlVOS.get(j);
	    	                    
	    	                    //if over_day > 0 , then save.
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
	    	    				//cancel
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
    				int dToMvmtDt = Integer.parseInt(invoiceIssueRDPreviewVO.getToMvmtDt());
    				int dFtCmncDt = Integer.parseInt(invoiceIssueRDPreviewVO.getFtCmncDt());
    				int dFtEndDt  = Integer.parseInt(invoiceIssueRDPreviewVO.getFtEndDt());

    				textForRD.append(dFmMvmtDt + dl); 			//FROM
    				textForRD.append(dToMvmtDt + dl); 			//TO
    				
    				//Cancel
    				if(dFtEndDt < dFmMvmtDt) {
    					log.debug("<1>"+dFtEndDt+":"+dFtCmncDt+"<<");
    					textForRD.append("" + dl); 			//CMNC
    					textForRD.append("" + dl); 			//CMPLT
    				}else{
    					log.debug("<2>"+dFtEndDt+":"+dFtCmncDt+"<<");
    					textForRD.append(dFtCmncDt + dl); 			//CMNC
    					textForRD.append(dFtEndDt + dl); 			//CMPLT
    				}

    				//cancel
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
     * Search data for sending EDI, After AR-IF.<br>
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
 	 * check SZPBB INVOICE Creation
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
 	 * run Back End Job .
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
			
			//set parameter of information for BackEndJob
			backEndJob.setJobCommand(backendjobId);
			backEndJob.setInvoiceGroupParamVO(invoiceGroupParamVO);
			backEndJob.setConfirmChargeListVOs(confirmChargeListVOs);
			backEndJob.setSignOnUserAccount(account);
			
			String jobMessage = "DMT " + backendjobId + " Back End";
			
			// call BackEndJob
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), jobMessage);
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler("DMT00008", new String[]{"execute group invoice save backend job"}).getMessage());
		}
    }
    
	/**
	 * Return status of Back End Job.
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
 	 * before do AR-IF, Check done AR-IF 
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
	 * Search Detail information of Group Invoice.
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
			
				//Search Bkg of Grid data.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//no checked check box skip
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                
	                //Search charge detailinformation	s_dmdt_trf_cd, s_bkg_no, s_ofc_cd, s_chg_type, dmdt_chg_sts_cd
	                issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	                issuedInvoiceParamVO.setSChgType("");
	                issuedInvoiceParamVO.setDmdtChgStsCds("C");
	                
	                invoiceIssueVOList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	                
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	                
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                //if DMDT_CHG_LOC_DIV_CD is not  'TSP' snd 'SZP' , then set VVD CD with search VVDNEta
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                for(int j = 0 ; j < invoiceIssueVOList.size() ;  j++) {
	                	InvoiceIssueVO invoiceIssueVO = (InvoiceIssueVO)invoiceIssueVOList.get(j);
	                	if(invoiceIssueVO.getDmdtChgLocDivCd().equals("TSP") || invoiceIssueVO.getDmdtChgLocDivCd().equals("SZP")) {
	                		chg_loc_div_cd_flag = true;
	                		break;
	                	}
	                }
	                if(!chg_loc_div_cd_flag) {
	                	// vvd_check_data 
                		vVDCheckDataVO = dbDao.searchVVDCheckData(issuedInvoiceParamVO, "2");
                		if(!vVDCheckDataVO.getBkgNo().equals("")){
                			vVDCheckDataList.add(vVDCheckDataVO);
                		}
	                }
				}
			}else{
				// Search Cntr of Grid data 
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//no checked check box skip
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	            	
	            	issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	            	
	            	///////////////////////////////////////////////////////////////////////////////////////////////
	                //if DMDT_CHG_LOC_DIV_CD is not  'TSP' snd 'SZP' , then set VVD CD with search VVDNEta
	                ///////////////////////////////////////////////////////////////////////////////////////////////
                	if(confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("TSP") || confirmChargeListVOs[i].getDmdtChgLocDivCd().equals("SZP")) {
                		continue;
                	}else{
                		// vvd_check_data
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
	 * search VVDNEta information on using CalculationUtil.
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
	 *  search new VVDNEta information on using CalculationUtil.
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
				
				// Search Bkg data of grid
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//no checked check box skip
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                issuedInvoiceParamVO = new IssuedInvoiceParamVO();
	                
	                //Search charge detailinformation.	s_dmdt_trf_cd, s_bkg_no, s_ofc_cd, s_chg_type, dmdt_chg_sts_cd
	                issuedInvoiceParamVO.setSBkgNo(confirmChargeListVOs[i].getBkgNo());
	                issuedInvoiceParamVO.setSDmdtTrfCd(confirmChargeListVOs[i].getDmdtTrfCd());
	                issuedInvoiceParamVO.setSOfcCd(confirmChargeListVOs[i].getOfcCd());
	                issuedInvoiceParamVO.setSChgType("");
	                issuedInvoiceParamVO.setDmdtChgStsCds("C");
	                
	                invoiceIssueVOList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
	                
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	                
	                ///////////////////////////////////////////////////////////////////////////////////////////////
	                //if DMDT_CHG_LOC_DIV_CD is not  'TSP' snd 'SZP' , then set VVD CD with search VVDNEta
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
			}else{
				// Search Cntr data of grid.
				for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
					//no checked check box skip
	                if(!confirmChargeListVOs[i].getIbflag().equals("U")){
	                	continue;
	                }
	                chg_loc_div_cd_flag = false;
	            	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
	            	
	            	///////////////////////////////////////////////////////////////////////////////////////////////
	                //if DMDT_CHG_LOC_DIV_CD is not  'TSP' snd 'SZP' , then set VVD CD with search VVDNEta
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
	 * Search Office Code of Invoice Creation user .
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
	 * Search Rate Currency by BKG No., Tariff  <br>
	 *
	 * @param String bkgNo
	 * @param String trfCd
	 * @return String
	 * @exception EventException
	 */
    public String searchRateCurrency(String bkgNo, String trfCd) throws EventException {
    	String rateCurCd = null;
    	
	    try {
			//case in status is 'Deleted' or 'Error' , Search  Manual Invoice Detail(Charge) .
			List<ManualKeyByChargeVO> manualKeyByChargeVOS = dbDao.searchManualInvoiceChargeData(bkgNo, null, trfCd);
			 
			 //Charge data exists,  Search Charge Currency.
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
	   		 
				calculationParmVO.setDcApplRate(		manualKeyByChargeVO.getDmdtTrfAplyTpCd()	);
	   		 
				//case in data existing,  do run.
				overdayNDivParmVO.setSvrId(				manualKeyByChargeVO.getSysAreaGrpId()		);
	   		 	overdayNDivParmVO.setCntrNo(			manualKeyByChargeVO.getCntrNo()				);
	   		 	overdayNDivParmVO.setCnmvCycNo(			manualKeyByChargeVO.getCntrCycNo()			);
	   		 	overdayNDivParmVO.setDttCode(			manualKeyByChargeVO.getDmdtTrfCd()			);
	   		 	overdayNDivParmVO.setLocDiv(			manualKeyByChargeVO.getDmdtChgLocDivCd()	);
	   		 	overdayNDivParmVO.setDccSeq(			manualKeyByChargeVO.getChgSeq()				);
	   		 
				//------------- DivOverDay Search ----------------------------------------------------
	   		 	OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
				//---------------------------------------------------------------------------------
	   		 
	   			//Charge information exists, search Charge Currency.
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
					calculationParmVO.setTrfGrpSeq(		manualKeyByChargeVO.getBzcTrfGrpSeq()		);
					calculationParmVO.setCntrts(		manualKeyByChargeVO.getCntrTpszCd()			);
					calculationParmVO.setOverDay(		manualKeyByChargeVO.getFxFtOvrDys()			);
					calculationParmVO.setDivOverDay(	overdayNDivVO.getDivOverDay()				);
					calculationParmVO.setCurCd(			manualKeyByChargeVO.getBzcTrfCurrCd()		);
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
					calculationParmVO.setDivOverDay(	overdayNDivVO.getDivOverDay()				);
				} 
	    		else if ("S".equals(manualKeyByChargeVO.getDmdtTrfAplyTpCd())) {
					// scCalculation - SC Exception
					calculationParmVO.setPropNo(		manualKeyByChargeVO.getScNo()				);
					calculationParmVO.setVerSeq(		manualKeyByChargeVO.getScExptVerSeq()		);
					calculationParmVO.setGrpSeq(		manualKeyByChargeVO.getScExptGrpSeq()		);
					calculationParmVO.setCntrts(		manualKeyByChargeVO.getCntrTpszCd()			);
					calculationParmVO.setOverDay(		manualKeyByChargeVO.getFxFtOvrDys()			);
					calculationParmVO.setDivOverDay(	overdayNDivVO.getDivOverDay()				);
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
     * Search VVD list.
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
    		//1. Search Bkg list .
        	fm_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getFmCfmDt(), "-", "");
        	to_cfm_dt = JSPUtil.replace(issuedInvoiceParamVO.getToCfmDt(), "-", "");
        	
        	issuedInvoiceParamVO.setFmCfmDt(fm_cfm_dt);
        	issuedInvoiceParamVO.setToCfmDt(to_cfm_dt);
        	issuedInvoiceParamVO.setOfcCd(account.getOfc_cd());	
        	
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
     * Update Invoice information.  after calculating  on After Booking <br>
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
 	 * Search DMDT_INV_STS_CD of DMT_INV_MN
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
     * Search After Invoice Adjustment Amt of Invoice.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param SignOnUserAccount account
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, SignOnUserAccount account) throws EventException {
	    try {
	    	 return dbDao.checkAftInvAdjAmtByInvoiceNo(invoiceNo, creOfcCd, account);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
	         throw new EventException(new ErrorHandler("DMT00006").getUserMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	    	
    }
    
    /**
     * Search Issued Invoice total amount by Payer and Currency.
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
        	
            //return dbDao.searchIssuedInvoiceSumByPayer(issuedInvoiceParamVO);
        	
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
     *  인도 GST 관련 Tax rate를 조회합니다.<br>
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
	
}
