/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : demandnotesendBCImpl.java
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.basic;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

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
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.integration.DemandNoteSendDBDAO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.BookingCustomerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * DMTInvoiceMgt Business Logic Command Interface<br>
 *
 * @author
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */
public class DemandNoteSendBCImpl extends BasicCommandSupport implements DemandNoteSendBC {

	// Database Access Object
	private transient DemandNoteSendDBDAO dbDao = null;
	private DMTCalculationUtil dmtCalculationUtil = null;
	/**
	 * demandnotesendBCImpl Create object<br>
	 * Create demandnotesendDBDAO<br>
	 */
	public DemandNoteSendBCImpl() {
		dbDao = new DemandNoteSendDBDAO();
		dmtCalculationUtil = new DMTCalculationUtil();
	}
	/**
	 * Search Demand Note for Issue.<br>
	 * 
	 * @param DemandNoteListParmVO demandNoteListParmVO
	 * @param SignOnUserAccount account
	 * @return List<DemandNoteListVO>
	 * @exception EventException
	 */
	public List<DemandNoteListVO> searchDemandChargeList(DemandNoteListParmVO demandNoteListParmVO, SignOnUserAccount account) throws EventException {
		List<DemandNoteListVO> demandNoteList = null;
		dmtCalculationUtil 		= new DMTCalculationUtil();
		try {
			demandNoteListParmVO.setFmDt(demandNoteListParmVO.getFmDt().replaceAll("-", ""));
			demandNoteListParmVO.setToDt(demandNoteListParmVO.getToDt().replaceAll("-", ""));
			demandNoteListParmVO.setCreOfcCd(account.getOfc_cd());

			demandNoteList = dbDao.searchDemandChargeList(demandNoteListParmVO);
			
			for(int i= 0; i < demandNoteList.size() ; i++) {
				DemandNoteListVO demandNoteListVO = (DemandNoteListVO)demandNoteList.get(i);
				
				demandNoteListVO.setInvChgAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteListVO.getInvCurrCd(), NumberUtils.toDouble(demandNoteListVO.getInvChgAmt()))));

				double exchangeRate = 1;
            	double invChgTotAmt = 0;
log.debug("\n------orgCurrCd:---->"+demandNoteListVO.getOrgCurrCd());            	
log.debug("\n------invCurrCd:---->"+demandNoteListVO.getInvCurrCd());            	
            	if(!demandNoteListVO.getOrgCurrCd().equals(demandNoteListVO.getInvCurrCd())) {
log.debug("\n------not equals---->");                		
            		//xch_rate Search
	           		ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
	           		exchangeRateParmVO.setVslCd(demandNoteListVO.getVslCd());
	           		exchangeRateParmVO.setSkdVoyageNo(demandNoteListVO.getSkdVoyNo());
	           		exchangeRateParmVO.setSkdDirCd(demandNoteListVO.getSkdDirCd());
	           		exchangeRateParmVO.setIoBnd(demandNoteListVO.getDmdtTrfCd().substring(2,3));
	           		exchangeRateParmVO.setPodLoc(demandNoteListVO.getPodCd());
	           		exchangeRateParmVO.setPolLoc(demandNoteListVO.getPolCd());
	           		exchangeRateParmVO.setFmCurCd(demandNoteListVO.getOrgCurrCd());
	           		exchangeRateParmVO.setToCurCd(demandNoteListVO.getInvCurrCd());
	            		
	           		exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            	}
            	//INV_AMT 
            	invChgTotAmt = exchangeRate * NumberUtils.toDouble(demandNoteListVO.getBilAmt());
            	invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(demandNoteListVO.getInvCurrCd(), invChgTotAmt);
            		
            	demandNoteListVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
            	demandNoteListVO.setInvChgAmt(JSPUtil.toDecimalFormat(invChgTotAmt, "#.##"));
log.debug("\n------getInvXchRt:---->"+demandNoteListVO.getInvXchRt());            	
log.debug("\n------getInvChgAmt:---->"+demandNoteListVO.getInvChgAmt());  				
            	demandNoteList.set(i, demandNoteListVO);
			}	
			
			return demandNoteList;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Search Demand Note Issue by Booking.<br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @param SignOnUserAccount account
	 * @return DemandNoteByBookingVO
	 * @exception EventException
	 */
	public DemandNoteByBookingVO searchDemandNoteByBooking(DemandNoteParmVO demandNoteParmVO, SignOnUserAccount account) throws EventException {
		DemandNoteByBookingVO 	demandNoteByBookingVO   = new DemandNoteByBookingVO();
		dmtCalculationUtil 		= new DMTCalculationUtil();
        IssuedInvoiceParamVO 	issuedInvoiceParamVO 	= new IssuedInvoiceParamVO();
        List<InvoiceIssueVO> 	invoiceIssueList   				= null;
        List<ChargeBookingInvoiceVO> chargeBookingInvoiceList 	= null;
        
        String curr_ofc_date = "";
        
		try {
			
			// reset demandNoteParmVO parameter from screen to VO(IssuedInvoiceParamVO).
			issuedInvoiceParamVO.setSBkgNo(demandNoteParmVO.getSBkgNo());
	        issuedInvoiceParamVO.setSGroupBy(demandNoteParmVO.getSGroupBy());
	        issuedInvoiceParamVO.setSChgType(demandNoteParmVO.getSChgType());
	        issuedInvoiceParamVO.setSOfcCd(demandNoteParmVO.getSOfcCd());
	        issuedInvoiceParamVO.setOfcCd(demandNoteParmVO.getOfcCd());
	        issuedInvoiceParamVO.setSDmdtTrfCd(demandNoteParmVO.getSDmdtTrfCd());
	        issuedInvoiceParamVO.setSCntrNo(demandNoteParmVO.getSCntrNo());
	        issuedInvoiceParamVO.setSScNo(demandNoteParmVO.getSScNo());
	        issuedInvoiceParamVO.setSRfaNo(demandNoteParmVO.getSRfaNo());
	        issuedInvoiceParamVO.setDmdtChgStsCds(demandNoteParmVO.getDmdtChgStsCds());
	        issuedInvoiceParamVO.setSInvoiceNo(demandNoteParmVO.getSInvoiceNo());
	        
	        log.debug("======================================================================");
        	log.debug("getSBkgNo:"+issuedInvoiceParamVO.getSBkgNo());
        	log.debug("getSGroupBy:"+issuedInvoiceParamVO.getSGroupBy());
        	log.debug("getSChgType:"+issuedInvoiceParamVO.getSChgType());
        	log.debug("getSOfcCd:"+issuedInvoiceParamVO.getSOfcCd());
        	log.debug("getOfcCd:"+issuedInvoiceParamVO.getOfcCd());
        	log.debug("getSDmdtTrfCd:"+issuedInvoiceParamVO.getSDmdtTrfCd());
        	log.debug("getSCntrNo:"+issuedInvoiceParamVO.getSCntrNo());
        	log.debug("getSScNo:"+issuedInvoiceParamVO.getSScNo());
        	log.debug("getSRfaNo:"+issuedInvoiceParamVO.getSRfaNo());
        	log.debug("getDmdtChgStsCds:"+issuedInvoiceParamVO.getDmdtChgStsCds());
        	log.debug("getSInvoiceNo:"+issuedInvoiceParamVO.getSInvoiceNo());
        	log.debug("======================================================================");
	        
	        // searchChargeBookingInvoice
	        // Search information of Demand Note - single row return.  
	        //[if inv_no is not exist] -> InvoiceIssueCollectionMgtBCImpl::searchChargeInvoice reference
	        // start logic  dbDaoInvoice	
        	curr_ofc_date = dbDao.searchCurrentDateByOffice(account.getOfc_cd());
        	
        	// searchChargeBookingInvoice
            chargeBookingInvoiceList = dbDao.searchChargeBookingInvoice(issuedInvoiceParamVO);
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
            
            for( int i = 0 ; i < chargeBookingInvoiceList.size() ; i++) {
                chargeBookingInvoiceVO = (ChargeBookingInvoiceVO)chargeBookingInvoiceList.get(i);
            }

            PayerNameParamVO payerNameParamVO = new PayerNameParamVO();
            PayerNameVO rePayerNameVO = new PayerNameVO();
            
log.debug("\n--------------------------------1-1--------------------------");         
            
            //no Payer
            if(chargeBookingInvoiceVO.getPayerCd() == null 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("00000000") 
            		|| chargeBookingInvoiceVO.getPayerCd().equals("000000")) {
log.debug("\n--------------------------------1-2--------------------------");         
                chargeBookingInvoiceVO.setPayerCd("");
                chargeBookingInvoiceVO.setPayerNm("");
            }else{
log.debug("\n--------------------------------1-3--------------------------");         
            
                payerNameParamVO.setSCustCd(chargeBookingInvoiceVO.getPayerCd());
                
                if(chargeBookingInvoiceVO.getPayerCd().substring(0,2).equals("00")) {
                	payerNameParamVO.setSCustGubun("1");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                }else{
                	payerNameParamVO.setSCustGubun("2");
                	rePayerNameVO = dbDao.searchPayerInfoName(payerNameParamVO);
                }                
//                //VENDOR
//                if(chargeBookingInvoiceVO.getPayerCd().substring(0,2).equals("00")) {
//                	payerNameParamVO.setSCustGubun("1");
//                	rePayerNameVO = dbDao.searchPayerName(payerNameParamVO);
//                //CUSTOMER
//                }else{
//                	payerNameParamVO.setSCustGubun("2");
//                	rePayerNameVO = dbDao.searchPayerName(payerNameParamVO);
//                }
                
                chargeBookingInvoiceVO.setPayerCd(rePayerNameVO.getCustCd());
                chargeBookingInvoiceVO.setPayerNm(rePayerNameVO.getCustName());
                
            }
            
                
            // set Invoice Cur
            if(chargeBookingInvoiceVO.getOfcCd().equals("XMNBS") && account.getUsr_id().equals("XMN0030") && account.getOfc_cd().equals("XMNBB")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            if(chargeBookingInvoiceVO.getOfcCd().equals("SZPBB") && account.getUsr_id().equals("MODC01") && account.getOfc_cd().equals("MACBA")) {
                chargeBookingInvoiceVO.setInvCurrCd("HKD");
            }
            
            List<BookingCustomerVO> bookingCustomerList = null;
            
            // searchBookingCustomer 
            BookingCustomerVO inBookingCustomerVO = new BookingCustomerVO();
            BookingCustomerVO bookingCustomerVO = new BookingCustomerVO();
            
            inBookingCustomerVO.setBkgNo(issuedInvoiceParamVO.getSBkgNo());
            
            // searchBookingCustomer Search
            bookingCustomerList = dbDao.searchBookingCustomer(inBookingCustomerVO);
            
log.debug("\n--------------------------------1-4--------------------------");         
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
                        
                        if(bookingCustomerVO.getCustCdC() == null || bookingCustomerVO.getCustCdC().equals("000000")) {
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
log.debug("\n--------------------------------1-5--------------------------");         
            // if it's not exist, then set Due Date = currenct date, Credit Term = 0.
            if(listSheetOption == null || listSheetOption.size() == 0) {
                chargeBookingInvoiceVO.setIssDtPrnFlg("");
                chargeBookingInvoiceVO.setCrTermDys("0");
                chargeBookingInvoiceVO.setTaxRto("0");
                chargeBookingInvoiceVO.setDueDate(curr_ofc_date);//currenct date
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
                    
                    //sheet Option Credit Term = 0 
                    if(chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	//if Due Date is "Issue Date", then set Due Date=currenct date,Credit Term=0
                    	if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("Y")){
                    		chargeBookingInvoiceVO.setDueDate(curr_ofc_date);
                    		chargeBookingInvoiceVO.setCrTermDys("0");
                       	//if Due Date is "*******", set  Due Date: ********, Credit Term: ' '
                    	}else if(chargeBookingInvoiceVO.getIssDtPrnFlg().equals("N")){
                    		chargeBookingInvoiceVO.setDueDate("********");
                    		chargeBookingInvoiceVO.setCrTermDys("");
                    	}
                    //sheet Option Credit Term > 0 
                    }else if(!chargeBookingInvoiceVO.getCrTermDys().equals("0")){
                    	String due_date = DateTime.addDays(curr_ofc_date, Integer.parseInt(chargeBookingInvoiceVO.getCrTermDys()));
                    	chargeBookingInvoiceVO.setDueDate(due_date);
                    }
                }
            }
            // searchARActualPayer(bookingNo, dmdtTrfCd)
            List<ARActualPayerVO> listARActualPayer = dbDao.searchARActualPayer(issuedInvoiceParamVO.getSBkgNo(), issuedInvoiceParamVO.getSDmdtTrfCd());
log.debug("\n--------------------------------1-6--------------------------");         
            
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
log.debug("\n--------------------------------1-7--------------------------");         

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
            chargeBookingInvoiceVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));//Double format
            
log.debug("\n--------------------------------1---ex_rate-----------------------"+exchangeRate);         
            //Total Amt
            double totAmt = 0;			//tot_amt
            double totBillAmt = 0;		//tot_bill_amt
            double inv_bill_amt = 0;
            double inv_chg_tot = 0;


            // searchChargeBookingInvoiceDetail
            invoiceIssueList = dbDao.searchChargeBookingInvoiceDetail(issuedInvoiceParamVO);
            
            for(int i= 0; i < invoiceIssueList.size() ; i++) {
            	InvoiceIssueVO tempInvoiceIssueVO = (InvoiceIssueVO)invoiceIssueList.get(i);
            	
            	
            	
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
	            	
	            	
//		            	totAmt += inv_chg_tot;
	            }
	            
	            //charge total amt
	            
	            
	            
	            
	            
            	//invoice total amt
	            inv_chg_tot = exchangeRate * inv_chg_tot;
	            inv_chg_tot = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),inv_chg_tot);
            	tempInvoiceIssueVO.setInvChgTot(JSPUtil.toDecimalFormat(inv_chg_tot, "#.##"));
            	
                log.debug("---exchangeRate-->"+exchangeRate);
                log.debug("---inv_chg_tot-->"+inv_chg_tot);

                totAmt += inv_chg_tot;
            	
            	//inv_chg_tot, inv_bill_amt  save
            	invoiceIssueList.set(i, tempInvoiceIssueVO);

            }
            
            
            
            totAmt = dmtCalculationUtil.trimCurrencyAmount(chargeBookingInvoiceVO.getInvCurrCd(),totAmt);
			chargeBookingInvoiceVO.setTotAmt(JSPUtil.toDecimalFormat(totAmt, "#.##"));
log.debug("\n--------------------------------2------Total Amt--------------------"+totAmt);         

			//Billing Amt
//				double invChgAmt = 0;
//				invChgAmt = exchangeRate * Double.parseDouble(chargeBookingInvoiceVO.getMnBilAmt());
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
            
log.debug("\n--------------------------------8--------------------------");         

            //Invoice Data claer
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
            chargeBookingInvoiceVO.setInvRefNo("");
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
			demandNoteByBookingVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
			demandNoteByBookingVO.setInvoiceIssueList(invoiceIssueList);
	        
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return demandNoteByBookingVO;
	}
	
	
	/**
	 * Search Demand Note Issue by Group <br>
	 * 
	 * @param DemandNoteParmVO demandNoteParmVO
	 * @return List<DemandNoteGroupListVO>
	 * @exception EventException
	 */
	public List<DemandNoteGroupListVO> searchDemandNoteByGroup(DemandNoteParmVO demandNoteParmVO) throws EventException {
		List<DemandNoteGroupListVO> demandNoteGroupList = null;
		dmtCalculationUtil 		= new DMTCalculationUtil();
		try {
			demandNoteParmVO.setDmdtChgStsCds(demandNoteParmVO.getDmdtChgStsCds().replace("R", "L"));
			demandNoteGroupList = dbDao.searchDemandNoteByGroup(demandNoteParmVO);
			
			for(int i= 0; i < demandNoteGroupList.size() ; i++) {
				DemandNoteGroupListVO demandNoteGroupListVO = (DemandNoteGroupListVO)demandNoteGroupList.get(i);
				
				demandNoteGroupListVO.setInvChgAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getInvCurrCd(), NumberUtils.toDouble(demandNoteGroupListVO.getInvChgAmt()))));
				demandNoteGroupListVO.setOrgChgAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getOrgCurrCd(), NumberUtils.toDouble(demandNoteGroupListVO.getOrgChgAmt()))));
				demandNoteGroupListVO.setExptAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getOrgCurrCd(), NumberUtils.toDouble(demandNoteGroupListVO.getExptAmt()))));
				demandNoteGroupListVO.setDcAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getOrgCurrCd(), NumberUtils.toDouble(demandNoteGroupListVO.getDcAmt()))));
				demandNoteGroupListVO.setBilAmt(String.valueOf(dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getOrgCurrCd(), NumberUtils.toDouble(demandNoteGroupListVO.getBilAmt()))));
				
				
				double exchangeRate = 1;
            	double invChgTotAmt = 0;
log.debug("\n------orgCurrCd:---->"+demandNoteGroupListVO.getOrgCurrCd());            	
log.debug("\n------invCurrCd:---->"+demandNoteGroupListVO.getInvCurrCd());
            	if(!demandNoteGroupListVO.getOrgCurrCd().equals(demandNoteGroupListVO.getInvCurrCd())) {
log.debug("\n------not equals---->");            		
            		//xch_rate Search
	           		ExchangeRateParmVO exchangeRateParmVO = new ExchangeRateParmVO();
	           		exchangeRateParmVO.setVslCd(demandNoteGroupListVO.getVslCd());
	           		exchangeRateParmVO.setSkdVoyageNo(demandNoteGroupListVO.getSkdVoyNo());
	           		exchangeRateParmVO.setSkdDirCd(demandNoteGroupListVO.getSkdDirCd());
	           		exchangeRateParmVO.setIoBnd(demandNoteGroupListVO.getDmdtTrfCd().substring(2,3));
	           		exchangeRateParmVO.setPodLoc(demandNoteGroupListVO.getPodCd());
	           		exchangeRateParmVO.setPolLoc(demandNoteGroupListVO.getPolCd());
	           		exchangeRateParmVO.setFmCurCd(demandNoteGroupListVO.getOrgCurrCd());
	           		exchangeRateParmVO.setToCurCd(demandNoteGroupListVO.getInvCurrCd());
	            		
	           		exchangeRate = dmtCalculationUtil.searchExchangeRate(exchangeRateParmVO);
            	}
            	
            	//INV_AMT 
            	invChgTotAmt = exchangeRate * NumberUtils.toDouble(demandNoteGroupListVO.getBilAmt());
            	invChgTotAmt = dmtCalculationUtil.trimCurrencyAmount(demandNoteGroupListVO.getInvCurrCd(), invChgTotAmt);
            		
            	demandNoteGroupListVO.setInvXchRt(JSPUtil.toDecimalFormat(exchangeRate, "#.######"));
            	demandNoteGroupListVO.setInvChgAmt(JSPUtil.toDecimalFormat(invChgTotAmt, "#.##"));
log.debug("\n------getInvXchRt:---->"+demandNoteGroupListVO.getInvXchRt());            	
log.debug("\n------getInvChgAmt:---->"+demandNoteGroupListVO.getInvChgAmt());            		
            	demandNoteGroupList.set(i, demandNoteGroupListVO);
			}
			
			return demandNoteGroupList; 
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * Search Master data Demand Note Issue Preview <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewMstVO
	 * @exception EventException
	 */
	public DemandNotePreviewMstVO searchDemandNoteIssueMstPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException {
		DemandNotePreviewMstVO 	demandNotePreviewMstVO   = null;
		try {
			
			 demandNotePreviewMstVO = dbDao.searchDemandNoteIssueMstPreview(demandNotePreviewParmVO);
           
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return demandNotePreviewMstVO;
	}
	
	/**
	 * Search Etc data Demand Note Issue Preview  <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return DemandNotePreviewEtcVO
	 * @exception EventException
	 */
	public DemandNotePreviewEtcVO searchDemandNoteIssueEtcPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException {
		DemandNotePreviewEtcVO 	demandNotePreviewEtcVO   = null;
		try {
			
			demandNotePreviewEtcVO = dbDao.searchDemandNoteIssueEtcPreview(demandNotePreviewParmVO);
           
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return demandNotePreviewEtcVO;
	}
	
	/**
	 * Search Detail List Demand Note Issue Preview  <br>
	 * 
	 * @param DemandNotePreviewParmVO demandNotePreviewParmVO
	 * @return List<DemandNotePreviewListVO>
	 * @exception EventException
	 */
	public List<DemandNotePreviewListVO> searchDemandNoteIssueDtlPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws EventException {
		try {
			return dbDao.searchDemandNoteIssueDtlPreview(demandNotePreviewParmVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/**
	 * Search RD REPORT Demand Note Issue Preview <br>
	 *
	 * @param DemandNoteRDParmVO[] demandNoteRDParmVOs
	 * @return String
	 * @exception EventException
	 */
	public String searchDemandNoteRD(DemandNoteRDParmVO[] demandNoteRDParmVOs) throws EventException{
		StringBuffer textForRD = new StringBuffer();
		String dl = "|&&|";

		try {
			
			if(demandNoteRDParmVOs.length > 0 || demandNoteRDParmVOs != null){
				
				log.debug("[0000.size:]"+demandNoteRDParmVOs.length);
				
				for (int i = 0; i < demandNoteRDParmVOs.length; i++) {
					demandNoteRDParmVOs[i].getSvrId();
					demandNoteRDParmVOs[i].getCntrNo();
					demandNoteRDParmVOs[i].getCntrCycNo();
					demandNoteRDParmVOs[i].getDmdtTrfCd();
					demandNoteRDParmVOs[i].getDmdtChgLocDivCd();
					demandNoteRDParmVOs[i].getChgSeq();
					
					log.debug("[1.SVR_ID]"+demandNoteRDParmVOs[i].getSvrId());
					log.debug("[2.CNTR_NO]"+demandNoteRDParmVOs[i].getCntrNo());
					log.debug("[3.CNTR_CYC_NO]"+demandNoteRDParmVOs[i].getCntrCycNo());
					log.debug("[4.DMDT_TRF_CD]"+demandNoteRDParmVOs[i].getDmdtTrfCd());
					log.debug("[5.DMDT_CHG_LOC_DIV_CD]"+demandNoteRDParmVOs[i].getDmdtChgLocDivCd());
					log.debug("[6.CHG_SEQ]"+demandNoteRDParmVOs[i].getChgSeq());
					
					
					//1.  Search information list about charge and rate amt .
					//to do : dbSearch. DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL.Query
					DemandNoteRDListVO  demandNoteRDListVO = new DemandNoteRDListVO();
					
					demandNoteRDListVO =  dbDao.searchDemandNoteRD(demandNoteRDParmVOs[i]);
					
					//2. get RATE.
					OverdayNDivParmVO overdayNDivParmVO = new OverdayNDivParmVO();
					overdayNDivParmVO.setSvrId(demandNoteRDParmVOs[i].getSvrId());
					overdayNDivParmVO.setCntrNo(demandNoteRDParmVOs[i].getCntrNo());
					overdayNDivParmVO.setCnmvCycNo(demandNoteRDParmVOs[i].getCntrCycNo());
					overdayNDivParmVO.setDttCode(demandNoteRDParmVOs[i].getDmdtTrfCd());
					overdayNDivParmVO.setLocDiv(demandNoteRDParmVOs[i].getDmdtChgLocDivCd());
					overdayNDivParmVO.setDccSeq(demandNoteRDParmVOs[i].getChgSeq());
					
					//------------- DivOverDay Search -----------
					OverdayNDivVO overdayNDivVO = dmtCalculationUtil.overdayNDiv(overdayNDivParmVO);
					//-----------------------------------------
					
					CalculationParmVO calculationParmVO = new CalculationParmVO();
					
					String trfAplyTpCd = demandNoteRDListVO.getDmdtTrfAplyTpCd();
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
						// basicCalculation - Baisc Tariff
					
						calculationParmVO.setSvrId(demandNoteRDListVO.getSvrId());
						calculationParmVO.setDmdtTrfCd(demandNoteRDListVO.getDmdtTrfCd());
						calculationParmVO.setTrfSeq(demandNoteRDListVO.getBzcTrfSeq());
						calculationParmVO.setTrfGrpSeq(demandNoteRDListVO.getBzcTrfGrpSeq());
						calculationParmVO.setCntrts(demandNoteRDListVO.getCntrTpszCd());
						calculationParmVO.setOverDay(demandNoteRDListVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
						calculationParmVO.setCurCd(demandNoteRDListVO.getBzcTrfCurrCd());
					
					} else if(trfAplyTpCd.equals("B")) {
						// beforeCalculation - Before BKG Exception
						calculationParmVO.setDarNo(demandNoteRDListVO.getRfaExptDarNo());
						calculationParmVO.setMapgSeq(demandNoteRDListVO.getRfaExptMapgSeq());
						calculationParmVO.setVerSeq(demandNoteRDListVO.getRfaExptVerSeq());
						calculationParmVO.setDtlSeq(demandNoteRDListVO.getRfaRqstDtlSeq());
						calculationParmVO.setCmbSeq("1");
						calculationParmVO.setCntrts(demandNoteRDListVO.getCntrTpszCd());
						calculationParmVO.setOverDay(demandNoteRDListVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
						
					} else if(trfAplyTpCd.equals("S")) {
						// scCalculation - SC Exception
						calculationParmVO.setPropNo(demandNoteRDListVO.getScNo());
						calculationParmVO.setVerSeq(demandNoteRDListVO.getScExptVerSeq());
						calculationParmVO.setGrpSeq(demandNoteRDListVO.getScExptGrpSeq());
						calculationParmVO.setCntrts(demandNoteRDListVO.getCntrTpszCd());
						calculationParmVO.setOverDay(demandNoteRDListVO.getFxFtOvrDys());
						calculationParmVO.setDivOverDay(overdayNDivVO.getDivOverDay());
					}
						
					CalculationAMTVO calculationAMTVO = dmtCalculationUtil.bbsChargeCalculation(calculationParmVO);
					
					List<ChrgDtlVO> list = calculationAMTVO.getChrgDtlVOS();
					String rateCurCd = calculationAMTVO.getRateCurCd();
					
					//[search TOTAL amount and CURR_CD of RD]
					//1. search RtChrgAmt total amount
					//2. search rateCurCd 
//					double rtChrgTot = 0;
//					
//					if(list != null && list.size() > 0) {
//						for(int ii=0; ii < list.size(); ii++) {
//							ChrgDtlVO chrgDtlVO = list.get(ii);
//							rtChrgTot += NumberUtils.toDouble(chrgDtlVO.getRtChrg());
//						}
//					} //if(list != null && list.size() > 0)
//					textForRD.append(rtChrgTot + dl); 			//chrgDtlVO.getRtChrg() total sum
//					textForRD.append(rateCurCd + dl + "\n"); 	//rateCurCd .
					
					
					
					//[search list data from RD]
					if(list != null && list.size() > 0) {
						for(int ii=0; ii < list.size(); ii++) {
							ChrgDtlVO chrgDtlVO = list.get(ii);
							
							//RD LIST
							demandNoteRDListVO.setFtOver(chrgDtlVO.getRtOver());
							demandNoteRDListVO.setFtUnder(chrgDtlVO.getRtUnder());
							demandNoteRDListVO.setRtAmt(chrgDtlVO.getRtRate());
							demandNoteRDListVO.setRtDay(chrgDtlVO.getRtDay());
							demandNoteRDListVO.setRtChrgAmt(chrgDtlVO.getRtChrg());
							demandNoteRDListVO.setRtCurrCd(rateCurCd);
							
							// demandNoteRDListVO .  binding array String. 
							//1.request screen.
							textForRD.append(demandNoteRDListVO.getCntrNo() + dl); 			//CNTR
							textForRD.append(demandNoteRDListVO.getCntrTpszCd() + dl);		//TS
							textForRD.append(demandNoteRDListVO.getFmMvmtDt() + dl);		//FROM
							textForRD.append(demandNoteRDListVO.getToMvmtDt() + dl);		//TO
							textForRD.append(demandNoteRDListVO.getFtCmncDt() + dl);		//CMNC
							textForRD.append(demandNoteRDListVO.getFtEndDt() + dl);			//CMPLT
							textForRD.append(demandNoteRDListVO.getFtDys() + dl);			//FREE DAY
							//2. result list .
//								textForRD.append(demandNoteRDListVO.getFtOver() + dl);		
//								textForRD.append(demandNoteRDListVO.getFtUnder() + dl);
							textForRD.append(demandNoteRDListVO.getFtOver() + "-" + demandNoteRDListVO.getFtUnder() + dl); //DAYS
							textForRD.append(demandNoteRDListVO.getRtAmt() + dl);			//RATE
							textForRD.append(demandNoteRDListVO.getRtDay() + dl);			//OVER DAY
							textForRD.append(demandNoteRDListVO.getRtChrgAmt() + dl);		//AMOUNT 
							textForRD.append(demandNoteRDListVO.getRtCurrCd() + dl + "\n"); //CURR_CD
							
						}
					} //if(list != null && list.size() > 0)
					else {
						// if no rate, relpace default value list.
						//1. default value
						textForRD.append(demandNoteRDListVO.getCntrNo() + dl); 			//CNTR
						textForRD.append(demandNoteRDListVO.getCntrTpszCd() + dl);		//TS
						textForRD.append(demandNoteRDListVO.getFmMvmtDt() + dl);		//FROM
						textForRD.append(demandNoteRDListVO.getToMvmtDt() + dl);		//TO
						textForRD.append(demandNoteRDListVO.getFtCmncDt() + dl);		//CMNC
						textForRD.append(demandNoteRDListVO.getFtEndDt() + dl);			//CMPLT
						textForRD.append(demandNoteRDListVO.getFtDys() + dl);	//FREE DAY
						//2. rate data
						textForRD.append("" + dl); 			//DAYS
						textForRD.append("0" + dl);			//RATE
						textForRD.append(demandNoteRDListVO.getFxFtOvrDys() + dl);			//OVER DAY  //demandNoteRDListVO.getFxFtOvrDys()
						textForRD.append("0" + dl);			//AMOUNT 
						textForRD.append(rateCurCd + dl + "\n"); 	//CURR_CD
					}
				} //demandNoteRDParmVOs.length
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("DMT0006", new String[]{""}).getMessage(), ex);
		}

		log.debug("\n======================================" +
				  "\n[textForRD]" +
				  "\n======================================" +
				  "\n" + textForRD +
				  "\n======================================\n");
		return textForRD.toString();
	}	
}
