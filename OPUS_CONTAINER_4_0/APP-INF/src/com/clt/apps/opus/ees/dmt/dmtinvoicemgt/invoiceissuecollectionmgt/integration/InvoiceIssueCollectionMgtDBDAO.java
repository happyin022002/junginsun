/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAO.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.11.05 김태균 [CHM-201006838-01] [EES-DMT] [DMDT] DMDT Invoice의 Cust Ref 정보 입력 ---  BKG의 P/O number
* 2010.11.26 김태균 [] [EES-DMT] A/R I/F시 INVOICE CURRECY 없을 경우 에러 처리함
* 2011.03.07 김태균 [CHM-201109126-01] [EES-DMT] [DET] DR 삭제로 인한 Invoice 삭제에 따른 Credit Note 생성/인쇄 기능 지원
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.BookingCustomerVO;
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
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InterfaceChargeCalculationVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailAmountVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailTaxVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceMainAmountVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
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
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListDwVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * InvoiceIssueCollectionMgtDBDAO <br>
 * - InvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Tae Kyun
 * @param <ManualInvoiceSummaryVO>
 * @see InvoiceIssueCollectionMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class InvoiceIssueCollectionMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -7176888071346461428L;

	/**
     * Confirm된 CNTR 정보를 그룹별로 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<ConfirmChargeListVO> searchConfirmChargeByBooking(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ConfirmChargeListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                //Tariff Type
                String dmdtTrfCd = (String)issuedInvoiceParamVO.getSDmdtTrfCd();
                List<String> dmdtTrfCdList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(dmdtTrfCd, ",");
                while (st1.hasMoreTokens()) {
                    dmdtTrfCdList.add(st1.nextToken());
                }
            
                velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                
                //cont_type check
                String fmCfmDt = (String)issuedInvoiceParamVO.getFmCfmDt();
                
                if(fmCfmDt.equals("")) {
                    velParam.put("s_cont_type", "cntr");
                    //BKG NO.
                    String bkgNo = (String)issuedInvoiceParamVO.getSBkgNo();
                    
                    if(!bkgNo.equals("")) {
                        List<String> bkgNoList = new ArrayList<String>();
                        StringTokenizer st2 = new StringTokenizer(bkgNo, ",");
                        while (st2.hasMoreTokens()) {
                            bkgNoList.add(st2.nextToken());
                        }
                    
                        velParam.put("bkg_no_list", bkgNoList);
                    }
                    
                    //B/L NO.
                    String blNo = (String)issuedInvoiceParamVO.getSBlNo();
                    
                    if(!blNo.equals("")) {
                        List<String> blNoList = new ArrayList<String>();
                        StringTokenizer st3 = new StringTokenizer(blNo, ",");
                        while (st3.hasMoreTokens()) {
                            blNoList.add(st3.nextToken());
                        }
                    
                        velParam.put("bl_no_list", blNoList);
                    }
                    
                    //CNTR NO.
                    String cntrNo = (String)issuedInvoiceParamVO.getSCntrNo();
                    
                    if(!cntrNo.equals("")) {
                        List<String> cntrNoList = new ArrayList<String>();
                        StringTokenizer st4 = new StringTokenizer(cntrNo, ",");
                        while (st4.hasMoreTokens()) {
                            cntrNoList.add(st4.nextToken());
                        }
                    
                        velParam.put("cntr_no_list", cntrNoList);
                    }
                    
                    
                    log.debug(bkgNo+":"+blNo+":"+cntrNo);
                    
                } else {
                    velParam.put("s_cont_type", "date");
                }
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConfirmChargeListVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
     
    /**
     * Confirm된 CNTR 정보를 CNTR No로 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<ConfirmChargeListVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
    public List<ConfirmChargeListVO> searchConfirmChargeByContainer(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ConfirmChargeListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                //Tariff Type
                String dmdtTrfCd = (String)issuedInvoiceParamVO.getSDmdtTrfCd();
                List<String> dmdtTrfCdList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(dmdtTrfCd, ",");
                while (st1.hasMoreTokens()) {
                    dmdtTrfCdList.add(st1.nextToken());
                }
            
                velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                
                //cont_type check
                String fmCfmDt = (String)issuedInvoiceParamVO.getFmCfmDt();
                
                if(fmCfmDt.equals("")) {
                    velParam.put("s_cont_type", "cntr");
                    //BKG NO.
                    String bkgNo = (String)issuedInvoiceParamVO.getSBkgNo();
                    
                    if(!bkgNo.equals("")) {
                        List<String> bkgNoList = new ArrayList<String>();
                        StringTokenizer st2 = new StringTokenizer(bkgNo, ",");
                        while (st2.hasMoreTokens()) {
                            bkgNoList.add(st2.nextToken());
                        }
                    
                        velParam.put("bkg_no_list", bkgNoList);
                    }
                    
                    //B/L NO.
                    String blNo = (String)issuedInvoiceParamVO.getSBlNo();
                    
                    if(!blNo.equals("")) {
                        List<String> blNoList = new ArrayList<String>();
                        StringTokenizer st3 = new StringTokenizer(blNo, ",");
                        while (st3.hasMoreTokens()) {
                            blNoList.add(st3.nextToken());
                        }
                    
                        velParam.put("bl_no_list", blNoList);
                    }
                    
                    //CNTR NO.
                    String cntrNo = (String)issuedInvoiceParamVO.getSCntrNo();
                    
                    if(!cntrNo.equals("")) {
                        List<String> cntrNoList = new ArrayList<String>();
                        StringTokenizer st4 = new StringTokenizer(cntrNo, ",");
                        while (st4.hasMoreTokens()) {
                            cntrNoList.add(st4.nextToken());
                        }
                    
                        velParam.put("cntr_no_list", cntrNoList);
                    }
                    
                    
                    log.debug(bkgNo+":"+blNo+":"+cntrNo);
                    
                } else {
                    velParam.put("s_cont_type", "date");
                }
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ConfirmChargeListVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;

    }    
     
     
     // -------------- 황효근  START ----------------
    /**
     * Invoice No.로 A/R I/F 정보를 조회한다.
     * 
     * @param String invoiceNo
     * @return String
     * @throws DAOException
     */
    public String searcARIFFlag(String invoiceNo) throws DAOException {
        
        //List<ChargeCalculationContainerVO> list = null;
        //CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            //Map<String, String> mapVO = chargeArgumentVO.getColumnValues();
            param.put("dmdt_inv_no", invoiceNo);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearcARIFFlagRSQL(), param, null);
            
            String result = "";
            if(dbRowset.next())
                result = dbRowset.getString(1);
            
            return result;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * Invoice Detail 정보를 수정한다.
     * 
     * @param DmtInvDtlVO dmtInvDtlVO
     * @throws DAOException
     */
    public void modifyInvoiceDetailByPartialPayment(DmtInvDtlVO dmtInvDtlVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = dmtInvDtlVO.getColumnValues();
            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceDetailByPartialPaymentUSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modifyInvoiceDetailByPartialPayment SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * 해당 Invoice Rate 정보를 삭제한다.<br>
     * 
     * @param String invoiceNo
     * @throws DAOException
     */
    public void deleteInvoiceRate(String invoiceNo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            param.put("dmdt_inv_no", invoiceNo);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAODeleteInvoiceRateDSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to deleteInvoiceRate SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * Container Type Size 정보를 조회한다.
     * 
     * @param OverdayNDivParmVO overdayNDivParmVO
     * @return String
     * @throws DAOException
     */
    public String searchContainerTypeSizeByPartialPayment(OverdayNDivParmVO overdayNDivParmVO) throws DAOException {
        
        //List<ChargeCalculationContainerVO> list = null;
        //CalculationTypeParmVO calculationTypeParmVO = new CalculationTypeParmVO();
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
        	Map<String, String> mapVO = overdayNDivParmVO.getColumnValues();
            param.putAll(mapVO);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchContainerTypeSizeByPartialPaymentRSQL(), param, null);
            
            String result = "";
            if(dbRowset.next())
                result = dbRowset.getString(1);
            
            return result;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * Invoice Rate 정보를 생성한다.
     * 
     * @param DmtInvRtVO dmtInvRtVO
     * @throws DAOException
     */
    public void createInvoiceRateByPartialPayment(DmtInvRtVO dmtInvRtVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvRtVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCreateInvoiceRateByPartialPaymentCSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    
    /**
     * Invoice에 해당하는 Exchange Rate와 Tax Rate를 조회한다.<br>
     * 
     * @param String invoiceNo
     * @return ExchangeNTaxRateVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ExchangeNTaxRateVO searchExchangeNTaxRate(String invoiceNo) throws DAOException {
        List<ExchangeNTaxRateVO> list = null;
        ExchangeNTaxRateVO exchangeNTaxRateVO = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("dmdt_inv_no", invoiceNo);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchExchangeNTaxRateRSQL(), param, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExchangeNTaxRateVO.class);
            
            if(list != null && list.size() > 0) {
                exchangeNTaxRateVO = list.get(0);
            }
            
            return exchangeNTaxRateVO;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    // -------------- 황효근  END ----------------
    
    
    /**
     * Invoice에 해당하는 Exchange Rate와 Tax Rate를 조회한다.<br>
     * 
     * @param String invoiceNo
     * @return List<InvoiceDetailListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InvoiceDetailListVO> searchInvoiceDetailListByPartialPayment(String invoiceNo) throws DAOException {
        List<InvoiceDetailListVO> list = null;
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            param.put("dmdt_inv_no", invoiceNo);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL(), param, null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListVO.class);
            return list;
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    /**
     * Proforma Schedule 정보를 생성합니다. <br>
     * 
     * @param InvoiceDetailAmountVO invoiceDetailAmountVO
     * @exception DAOException
     */
    public void modifyInvoiceDetailAmountByPartialPayment(InvoiceDetailAmountVO invoiceDetailAmountVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = invoiceDetailAmountVO.getColumnValues();
            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceDetailAmountByPartialPaymentUSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modifyInvoiceDetailAmountByPartialPayment SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

    
    
    /**
     * Proforma Schedule 정보를 생성합니다. <br>
     * 
     * @param InvoiceMainAmountVO invoiceMainAmountVO
     * @exception DAOException
     */
    public void modifyInvoiceMainByPartialPayment(InvoiceMainAmountVO invoiceMainAmountVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = invoiceMainAmountVO.getColumnValues();
            param.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceMainByPartialPaymentUSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to modifyInvoiceDetailAmountByPartialPayment SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    } 
    
    
    /**
     * Invoice Creation & Issue 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @param String checkFlag
     * @return VVDCheckDataVO
     * @throws DAOException
     */
    public VVDCheckDataVO searchVVDCheckData(IssuedInvoiceParamVO issuedInvoiceParamVO, String checkFlag) throws DAOException {
    	VVDCheckDataVO vVDCheckDataVO = new VVDCheckDataVO();
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("check_flag", checkFlag);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL(), param, velParam);
            if(dbRowset.next()){
            	vVDCheckDataVO.setBkgNo(JSPUtil.getNull(dbRowset.getString("bkg_no")));
            	vVDCheckDataVO.setPolCd(JSPUtil.getNull(dbRowset.getString("pol_cd")));
            	vVDCheckDataVO.setPodCd(JSPUtil.getNull(dbRowset.getString("pod_cd")));
            	vVDCheckDataVO.setIoBnd(JSPUtil.getNull(dbRowset.getString("io_bnd")));
            } else{
            	vVDCheckDataVO.setBkgNo("");
            	vVDCheckDataVO.setPolCd("");
            	vVDCheckDataVO.setPodCd("");
            	vVDCheckDataVO.setIoBnd("");
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return vVDCheckDataVO;
    }
    

    /**
     * Invoice Creation & Issue 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ChargeBookingInvoiceVO> searchChargeBookingInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ChargeBookingInvoiceVO> list = null;
//      ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                
                //DMDT_CHG_STS_CDS
                String dmdtChgStsCds = (String)issuedInvoiceParamVO.getDmdtChgStsCds();
                
                List<String> aryDmdtChgStsCdList = new ArrayList(); 
                StringTokenizer st = new StringTokenizer(dmdtChgStsCds, ",");
                String tempS = "";
                
                while (st.hasMoreTokens()) {
                    tempS = st.nextToken(); 
                    aryDmdtChgStsCdList.add(tempS);
                    
                    if(tempS.equals("All")) {
                        continue;
                    }
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("dmdt_chg_sts_cd_list", aryDmdtChgStsCdList);

            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingInvoiceVO.class);
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
         
    }
    
    /**
     * Booking Customer 정보를 조회 합니다.<br>
     * 
     * @param BookingCustomerVO bookingCustomerVO
     * @return List<BookingCustomerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BookingCustomerVO> searchBookingCustomer(BookingCustomerVO bookingCustomerVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BookingCustomerVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try{
            if(bookingCustomerVO != null){
                Map<String, String> mapVO = bookingCustomerVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingCustomerVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
        
    }
    
    /**
     * Sheet Option 정보를 조회 합니다.<br>
     * 
     * @param SheetOptionVO sheetOptionVO
     * @return List<SheetOptionVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SheetOptionVO> searchSheetOption(SheetOptionVO sheetOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SheetOptionVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(sheetOptionVO != null){
                Map<String, String> mapVO = sheetOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SheetOptionVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
        
    }
    /**
     * ARActual Payer 정보를 조회 합니다.<br>
     * 
     * @param String bookingNo
     * @param String dmdtTrfCd
     * @return List<ARActualPayerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ARActualPayerVO> searchARActualPayer(
    		String bookingNo, String dmdtTrfCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<ARActualPayerVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(bookingNo != null){
//              Map<String, String> mapVO = sheetOptionVO .getColumnValues();
//              param.putAll(mapVO);
//              velParam.putAll(mapVO);
                param.put("bkg_no", bookingNo);
                param.put("dmdt_trf_cd", dmdtTrfCd);
                
                velParam.put("bkg_no", bookingNo);
                velParam.put("dmdt_trf_cd", dmdtTrfCd);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		new InvoiceIssueCollectionMgtDBDAOSearchARActualPayerRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARActualPayerVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
        
    }
    
    /**
     * Invoice 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<InvoiceIssueVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InvoiceIssueVO> searchChargeBookingInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<InvoiceIssueVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                
                //DMDT_CHG_STS_CDS
                String dmdtChgStsCds = (String)issuedInvoiceParamVO.getDmdtChgStsCds();
                
                List<String> aryDmdtChgStsCdList = new ArrayList(); 
                StringTokenizer st = new StringTokenizer(dmdtChgStsCds, ",");
                String tempS = "";
                
                while (st.hasMoreTokens()) {
                    tempS = st.nextToken(); 
                    aryDmdtChgStsCdList.add(tempS);
                    
                    if(tempS.equals("All")) {
                        continue;
                    }
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("dmdt_chg_sts_cd_list", aryDmdtChgStsCdList);

            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceDetailRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryBySummaryVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OtsInquiryBySummaryVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
log.debug("################### 4009 Cuno [" + otsInquiryParmVO.getCuno() + "]");
log.debug("################### 4009 Cutp [" + otsInquiryParmVO.getCutp() + "]");
log.debug("################### 4009 Frdt [" + otsInquiryParmVO.getFrdt() + "]");
log.debug("################### 4009 Isof [" + otsInquiryParmVO.getIsof() + "]");
log.debug("################### 4009 Rfan [" + otsInquiryParmVO.getRfan() + "]");
log.debug("################### 4009 Scno [" + otsInquiryParmVO.getScno() + "]");
log.debug("################### 4009 Tftp [" + otsInquiryParmVO.getTftp() + "]");
log.debug("################### 4009 Todt [" + otsInquiryParmVO.getTodt() + "]");
log.debug("################### 4009 Arif [" + otsInquiryParmVO.getArif() + "]");
log.debug("################### 4009 Cude [" + otsInquiryParmVO.getCude() + "]");
log.debug("################### 4009 Payc [" + otsInquiryParmVO.getPayc() + "]");
log.debug("################### 4009 Payn [" + otsInquiryParmVO.getPayn() + "]");           
            
                String tempCUTP = (String)otsInquiryParmVO.getCutp();
                List<String> tempCUTPList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(tempCUTP, ",");
                while (st1.hasMoreTokens()) {
                    tempCUTPList.add(st1.nextToken());
                }

/*----------------------------------------------------------------------------------------*/                
                
                String tempISOF = (String)otsInquiryParmVO.getIsof();
                List<String> tempISOFList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempISOF, ",");
                while (st2.hasMoreTokens()) {
                    tempISOFList.add(st2.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempTFTP = (String)otsInquiryParmVO.getTftp();
                List<String> tempTFTPList = new ArrayList<String>();
                
                StringTokenizer st3 = new StringTokenizer(tempTFTP, ",");
                while (st3.hasMoreTokens()) {
                    tempTFTPList.add(st3.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempARIF = (String)otsInquiryParmVO.getArif();
                List<String> tempARIFList = new ArrayList<String>();
                
                StringTokenizer st4 = new StringTokenizer(tempARIF, ",");
                while (st4.hasMoreTokens()) {
                    String ar_if_cd = st4.nextToken();
                    if(ar_if_cd.equals("L")) {
                        velParam.put("s_ar_if_l_yn", "Y");
                    }else{
                        tempARIFList.add(ar_if_cd);
                    }                    
                }                
                velParam.put("ar_if_cnt", tempARIFList.size());                
                
                velParam.put("tempCUTPList", tempCUTPList);
                velParam.put("tempISOFList", tempISOFList);
                velParam.put("tempTFTPList", tempTFTPList);
                velParam.put("tempARIFList", tempARIFList);
                
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsInquiryBySummaryVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
     * [InvoiceMain] 정보를 [저장] 합니다.<br>
     * 
     * @param DmtInvMnVO dmtInvMnVO
     * @throws DAOException
     */
    public void addInvoiceMain(DmtInvMnVO dmtInvMnVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddInvoiceMainCSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * [InvoiceDetail] 정보를 [저장] 합니다.<br>
     * 
     * @param DmtInvDtlVO dmtInvDtlVO
     * @throws DAOException
     */
    public void addInvoiceDetail(DmtInvDtlVO dmtInvDtlVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvDtlVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddInvoiceDetailCSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
    }

    /**
     * [InvoiceRate] 정보를 [저장] 합니다.<br>
     * 
     * @param DmtInvRtVO dmtInvRtVO
     * @throws DAOException
     */
    public void addInvoiceRate(DmtInvRtVO dmtInvRtVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        //Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvRtVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddInvoiceRateCSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
    }
    
	/**
     * [TAB1:A/R Interface Status Inquiry By DMT]을 [조회]합니다.<br>
     * 
     * @param ARInterfaceParmVO arInterfaceParmVO
     * @return List<ARInterfaceStatusVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<ARInterfaceStatusVO> searchARInterfaceStatusByDMT ( ARInterfaceParmVO arInterfaceParmVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInterfaceStatusVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
             if(arInterfaceParmVO != null){
                 Map<String, String> mapVO = arInterfaceParmVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);

 				 //PAYER CODE의 6자리 8자리를 구분해서 처리.
 				 int custLen = arInterfaceParmVO.getCustCd().length();				
 				 velParam.put("cust_len", custLen);
 				
                 String ofcCd = arInterfaceParmVO.getOfcCd();
                 List<String> ofcCdList = new ArrayList<String>();
                 StringTokenizer st = new StringTokenizer(ofcCd, ",");
                 while (st.hasMoreTokens()) {
                     ofcCdList.add(st.nextToken());
                 }
                 velParam.put("ofc_cd_list", ofcCdList);
                 
                 String trfCd = arInterfaceParmVO.getDmdtTrfCd();
                 List<String> trfCdList = new ArrayList<String>();
                 StringTokenizer st2 = new StringTokenizer(trfCd, ",");
                 while (st2.hasMoreTokens()) {
                     trfCdList.add(st2.nextToken());
                 }
                 velParam.put("trf_cd_list", trfCdList);
                 
             }
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInterfaceStatusVO .class);
        }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
     
     /**
      * [TAB2:A/R Interface Status Inquiry By BKG]을 [조회]합니다.<br>
      * 
      * @param ARInterfaceParmVO arInterfaceParmVO
      * @return List<ARInterfaceStatusVO>
      * @throws DAOException
      */
	@SuppressWarnings("unchecked")
	public List<ARInterfaceStatusVO> searchARInterfaceStatusByBKG ( ARInterfaceParmVO arInterfaceParmVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInterfaceStatusVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
              if(arInterfaceParmVO != null){
                  Map<String, String> mapVO = arInterfaceParmVO.getColumnValues();
              
                  param.putAll(mapVO);
                  velParam.putAll(mapVO);
              
  				  //ACT_CUST CODE의 6자리 8자리를 구분해서 처리.
  				  int custLen = arInterfaceParmVO.getActCustCd().length();	
  				  velParam.put("cust_len", custLen);
  				
                  //office list
                  String ofcCd = arInterfaceParmVO.getOfcCd();
                  List<String> ofcCdList = new ArrayList<String>();
                  StringTokenizer st = new StringTokenizer(ofcCd, ",");
                  while (st.hasMoreTokens()) {
                     ofcCdList.add(st.nextToken());
                  }
                  velParam.put("ofc_cd_list", ofcCdList);
              }

              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByBKGRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInterfaceStatusVO .class);
        }catch(SQLException se){
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
      
   /**
    * [Invoice Interface to A/R]을 [조회]합니다.<br>
    * 
    * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
    * @return List<InvoiceInterfaceARBySummaryVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<InvoiceInterfaceARBySummaryVO> searchInvoiceInterfaceARBySummary ( InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<InvoiceInterfaceARBySummaryVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(invoiceInterfaceARParmVO != null){
                Map<String, String> mapVO = invoiceInterfaceARParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);

				//PAYER CODE의 6자리 8자리를 구분해서 처리.
				int custLen = invoiceInterfaceARParmVO.getCustCd().length();				
				velParam.put("cust_len", custLen);
                
                //dmdt_trf_cd
                String trfCd = invoiceInterfaceARParmVO.getDmdtTrfCd();
                List<String> trfCdList = new ArrayList<String>();
                StringTokenizer st2 = new StringTokenizer(trfCd, ",");
                while (st2.hasMoreTokens()) {
                    trfCdList.add(st2.nextToken());
                }
                velParam.put("trf_cd_list", trfCdList);
                
                //cond_type - inv
                if(invoiceInterfaceARParmVO.getCondType().equals("inv")) {
                	//inv_no
					if(!invoiceInterfaceARParmVO.getInvNo().equals("")) {
						String invNo = invoiceInterfaceARParmVO.getInvNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(invNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("inv_no_list", cntrNoList);
					}
					//bkg_no
					if(!invoiceInterfaceARParmVO.getBkgNo().equals("")) {
						String bkgNo = invoiceInterfaceARParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					//bl_no
					if(!invoiceInterfaceARParmVO.getBlNo().equals("")) {
						String blNo =invoiceInterfaceARParmVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
				}
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceInterfaceARBySummaryVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }    
     
    /**
     * [Invoice Interface to A/R - Detail]을 [조회]합니다.<br>
     * 
     * @param InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO
     * @param SignOnUserAccount account
     * @return List<InvoiceInterfaceARByDetailVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<InvoiceInterfaceARByDetailVO> searchInvoiceInterfaceARByDetail ( InvoiceInterfaceARParmVO  invoiceInterfaceARParmVO, SignOnUserAccount account ) throws DAOException {
         DBRowSet dbRowset = null;
         List<InvoiceInterfaceARByDetailVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(invoiceInterfaceARParmVO != null){
                 Map<String, String> mapVO = invoiceInterfaceARParmVO.getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
                 param.put( "session_ofc_cd" , account.getOfc_cd() );
                 
                 //dmdt_trf_cd
                 String trfCd = invoiceInterfaceARParmVO.getDmdtTrfCd();
                 List<String> trfCdList = new ArrayList<String>();
                 StringTokenizer st2 = new StringTokenizer(trfCd, ",");
                 while (st2.hasMoreTokens()) {
                     trfCdList.add(st2.nextToken());
                 }
                 velParam.put("trf_cd_list", trfCdList);
                 
                 //cond_type - inv
                 if(invoiceInterfaceARParmVO.getCondType().equals("inv")) {
                 	//inv_no
 					if(!invoiceInterfaceARParmVO.getInvNo().equals("")) {
 						String invNo = invoiceInterfaceARParmVO.getInvNo();
 						List<String> cntrNoList = new ArrayList<String>();
 						StringTokenizer st5 = new StringTokenizer(invNo, ",");
 					    while (st5.hasMoreTokens()) {
 					    	cntrNoList.add(st5.nextToken());
 					    }
 						velParam.put("inv_no_list", cntrNoList);
 					}
 					//bkg_no
 					if(!invoiceInterfaceARParmVO.getBkgNo().equals("")) {
 						String bkgNo = invoiceInterfaceARParmVO.getBkgNo();
 						List<String> bkgNoList = new ArrayList<String>();
 						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
 					    while (st3.hasMoreTokens()) {
 					    	bkgNoList.add(st3.nextToken());
 					    }
 						velParam.put("bkg_no_list", bkgNoList);
 					}
 					//bl_no
 					if(!invoiceInterfaceARParmVO.getBlNo().equals("")) {
 						String blNo =invoiceInterfaceARParmVO.getBlNo();
 						List<String> blNoList = new ArrayList<String>();
 						StringTokenizer st4 = new StringTokenizer(blNo, ",");
 					    while (st4.hasMoreTokens()) {
 					    	blNoList.add(st4.nextToken());
 					    }
 						velParam.put("bl_no_list", blNoList);
 					}
 				}
             }
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceInterfaceARByDetailVO .class);
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }  
     
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OtsInquiryByDetialVO> searchOTSInquiryByDetailList ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OtsInquiryByDetialVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                log.debug("####### 4011 Cuno [" + otsInquiryParmVO.getCuno() + "]");
                log.debug("####### 4011 Cutp [" + otsInquiryParmVO.getCutp() + "]");
                log.debug("####### 4011 Frdt [" + otsInquiryParmVO.getFrdt() + "]");
                log.debug("####### 4011 Isof [" + otsInquiryParmVO.getIsof() + "]");
                log.debug("####### 4011 Rfan [" + otsInquiryParmVO.getRfan() + "]");
                log.debug("####### 4011 Scno [" + otsInquiryParmVO.getScno() + "]");
                log.debug("####### 4011 Tftp [" + otsInquiryParmVO.getTftp() + "]");
                log.debug("####### 4011 Todt [" + otsInquiryParmVO.getTodt() + "]");
                log.debug("####### 4011 Arif [" + otsInquiryParmVO.getArif() + "]");
                log.debug("####### 4011 Cude [" + otsInquiryParmVO.getCude() + "]");
                log.debug("####### 4011 Payc [" + otsInquiryParmVO.getPayc() + "]");
                log.debug("####### 4011 Payn [" + otsInquiryParmVO.getPayn() + "]");           
            
                String tempCUTP = (String)otsInquiryParmVO.getCutp();
                List<String> tempCUTPList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(tempCUTP, ",");
                while (st1.hasMoreTokens()) {
                    tempCUTPList.add(st1.nextToken());
                }

/*----------------------------------------------------------------------------------------*/                
                
                String tempISOF = (String)otsInquiryParmVO.getIsof();
                List<String> tempISOFList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempISOF, ",");
                while (st2.hasMoreTokens()) {
                    tempISOFList.add(st2.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempTFTP = (String)otsInquiryParmVO.getTftp();
                List<String> tempTFTPList = new ArrayList<String>();
                
                StringTokenizer st3 = new StringTokenizer(tempTFTP, ",");
                while (st3.hasMoreTokens()) {
                    tempTFTPList.add(st3.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempARIF = (String)otsInquiryParmVO.getArif();
                List<String> tempARIFList = new ArrayList<String>();
                
                StringTokenizer st4 = new StringTokenizer(tempARIF, ",");
                while (st4.hasMoreTokens()) {
                    String ar_if_cd = st4.nextToken();
                    if(ar_if_cd.equals("L")) {
                        velParam.put("s_ar_if_l_yn", "Y");
                    }else{
                        tempARIFList.add(ar_if_cd);
                    }                    
                }                
                velParam.put("ar_if_cnt", tempARIFList.size());  
                
                velParam.put("tempCUTPList", tempCUTPList);
                velParam.put("tempISOFList", tempISOFList);
                velParam.put("tempTFTPList", tempTFTPList);
                velParam.put("tempARIFList", tempARIFList);
                
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsInquiryByDetialVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO2>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OtsInquiryByDetial2VO> searchOTSInquiryByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OtsInquiryByDetial2VO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                String tempINVNO = (String)otsInquiryParmVO.getInvno();
                List<String> tempINVNOList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(tempINVNO, ",");
                while (st1.hasMoreTokens()) {
                    tempINVNOList.add(st1.nextToken());
                }

                velParam.put("tempINVNOList", tempINVNOList);
                
                String tempCREOF = (String)otsInquiryParmVO.getCreof();
                List<String> tempCREOFList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempCREOF, ",");
                while (st2.hasMoreTokens()) {
                	tempCREOFList.add(st2.nextToken());
                }

                velParam.put("tempCREOFList", tempCREOFList);                
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsInquiryByDetial2VO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @throws DAOException
    */
    public String searchOTSInquiryByDetailListRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                log.debug("####### 4011 R Cuno [" + otsInquiryParmVO.getCuno() + "]");
                log.debug("####### 4011 R Cutp [" + otsInquiryParmVO.getCutp() + "]");
                log.debug("####### 4011 R Frdt [" + otsInquiryParmVO.getFrdt() + "]");
                log.debug("####### 4011 R Isof [" + otsInquiryParmVO.getIsof() + "]");
                log.debug("####### 4011 R Rfan [" + otsInquiryParmVO.getRfan() + "]");
                log.debug("####### 4011 R Scno [" + otsInquiryParmVO.getScno() + "]");
                log.debug("####### 4011 R Tftp [" + otsInquiryParmVO.getTftp() + "]");
                log.debug("####### 4011 R Todt [" + otsInquiryParmVO.getTodt() + "]");
                log.debug("####### 4011 R Arif [" + otsInquiryParmVO.getArif() + "]");
                log.debug("####### 4011 R Cude [" + otsInquiryParmVO.getCude() + "]");
                log.debug("####### 4011 R Payc [" + otsInquiryParmVO.getPayc() + "]");
                log.debug("####### 4011 R Payn [" + otsInquiryParmVO.getPayn() + "]");           

            }
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @throws DAOException
    */
    public String searchOTSInquiryByDetailListRemark2 ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                log.debug("####### 4011 R Cuno  [" + otsInquiryParmVO.getCuno () + "]");
                log.debug("####### 4011 R Cutp  [" + otsInquiryParmVO.getCutp () + "]");
                log.debug("####### 4011 R Frdt  [" + otsInquiryParmVO.getFrdt () + "]");
                log.debug("####### 4011 R Isof  [" + otsInquiryParmVO.getIsof () + "]");
                log.debug("####### 4011 R Rfan  [" + otsInquiryParmVO.getRfan () + "]");
                log.debug("####### 4011 R Scno  [" + otsInquiryParmVO.getScno () + "]");
                log.debug("####### 4011 R Tftp  [" + otsInquiryParmVO.getTftp () + "]");
                log.debug("####### 4011 R Todt  [" + otsInquiryParmVO.getTodt () + "]");
                log.debug("####### 4011 R Arif  [" + otsInquiryParmVO.getArif () + "]");
                log.debug("####### 4011 R Cude  [" + otsInquiryParmVO.getCude () + "]");
                log.debug("####### 4011 R Payc  [" + otsInquiryParmVO.getPayc () + "]");
                log.debug("####### 4011 R Payn  [" + otsInquiryParmVO.getPayn () + "]");
                log.debug("####### 4011 R Tftp2 [" + otsInquiryParmVO.getTftp2() + "]");

            }
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK] 정보를 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
     public String updateOTSInquiryByDetailListRemark(OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                param.put( "usid" , account.getUsr_id() );
                param.put( "usof" , account.getOfc_cd() );
                
                log.debug("####### 4011 U Cuno [" + otsInquiryParmVO.getCuno() + "]");
                log.debug("####### 4011 U Cutp [" + otsInquiryParmVO.getCutp() + "]");
                log.debug("####### 4011 U Frdt [" + otsInquiryParmVO.getFrdt() + "]");
                log.debug("####### 4011 U Isof [" + otsInquiryParmVO.getIsof() + "]");
                log.debug("####### 4011 U Rfan [" + otsInquiryParmVO.getRfan() + "]");
                log.debug("####### 4011 U Scno [" + otsInquiryParmVO.getScno() + "]");
                log.debug("####### 4011 U Tftp [" + otsInquiryParmVO.getTftp() + "]");
                log.debug("####### 4011 U Todt [" + otsInquiryParmVO.getTodt() + "]");
                log.debug("####### 4011 U Arif [" + otsInquiryParmVO.getArif() + "]");
                log.debug("####### 4011 U Cude [" + otsInquiryParmVO.getCude() + "]");
                log.debug("####### 4011 U Payc [" + otsInquiryParmVO.getPayc() + "]");
                log.debug("####### 4011 U Payn [" + otsInquiryParmVO.getPayn() + "]");           
                log.debug("####### 4011 U Rmrk [" + otsInquiryParmVO.getRmrk() + "]");

            }
             
             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOUpdateOTSInquiryByDetailListRemarkUSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED) {
                 throw new DAOException("Fail to UPDATE REMARK SQL EES_DMT_4011");
             }
         } catch (SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return "";
     }

    
    /**
     * Invoice Creation & Issue 정보를 조회 합니다.[Invoice Issue 후]<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ChargeBookingInvoiceVO> searchBookingInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ChargeBookingInvoiceVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingInvoiceVO.class);
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
         
    }    

    /**
     * Invoice 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<InvoiceIssueVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InvoiceIssueVO> searchInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<InvoiceIssueVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    /**
     * max InvoiceNo를 조회한다.<br>
     * 
     * @param String invPfxCd
     * @param String invSubCd
     * @return String
     * @throws DAOException
     */
    public String makeInvoiceNo(String invPfxCd, String invSubCd) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        String max_seq = "";

        try{
            param.put("inv_pfx_cd", invPfxCd);
            param.put("inv_sub_cd", invSubCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOMakeInvoiceNoRSQL(), param, velParam);
            
            if(dbRowset.next()){
                //max_seq = dbRowSet
                max_seq = dbRowset.getString("max_seq");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return max_seq;
    }
    
    /**
     * ar_ofc_cd 를 조회한다.<br>
     * 
     * @param String ofcCd
     * @return String
     * @throws DAOException
     */
    public String searchAROfficeCd(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        String ar_off_cd = "";

        try{
            param.put("ofc_cd", ofcCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchAROfficeCdRSQL(), param, velParam);
            
            if(dbRowset.next()){
                //ar_off_cd = dbRowSet
                ar_off_cd = dbRowset.getString("ar_ofc_cd");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return ar_off_cd;       
    }
    
    /**
     * max Invoie Detail 을 조회한다.<br>
     * 
     * @param String dmdtInvNo
     * @param String creOfcCd
     * @return int
     * @throws DAOException
     */
    public int makeInvoiceDtlSeq(String dmdtInvNo, String creOfcCd) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int max_seq = 0;

        try{
            param.put("dmdt_inv_no", dmdtInvNo);
            param.put("cre_ofc_cd", creOfcCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL(), param, velParam);
            
            if(dbRowset.next()){
                //max_seq = dbRowSet
                max_seq = dbRowset.getInt("max_seq");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return max_seq;
    }
    
    /**
     * INVOICE 정보를 수정한다.<br>
     * 
     * @param DmtInvMnVO dmtInvMnVO
     * @throws DAOException
     * @throws DAOException
     * @throws Exception
     */
    public void modifyInvoice(DmtInvMnVO dmtInvMnVO) throws  DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            velParam.put("caller", dmtInvMnVO.getCaller());
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modifyInvoice SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
    }

    
    
    /**
    * [Remark(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @throws DAOException
    */
    public String searchInvoiceRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceRemarkRSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }
    
    /**
    * [Remark(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @throws DAOException
    */
    public String searchOTSRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }
    
    /**
    * [Remark(s)] 정보를 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
     public String modifyInvoiceRemark(OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             if(otsInquiryParmVO != null){
                 Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
                 param.put( "usid" , account.getUsr_id() );
                 param.put( "usof" , account.getOfc_cd() );
             }
             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceRemarkUSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED) {
                 throw new DAOException("Fail to UPDATE REMARK SQL EES_DMT_4105");
             }
         } catch (SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return "";
     }
     
    /**
    * [Remark(s)] 정보를 [UPDATE] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
     public String modifyOTSRemark(OtsInquiryParmVO otsInquiryParmVO , SignOnUserAccount account ) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             if(otsInquiryParmVO != null){
                 Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
                 param.put( "usid" , account.getUsr_id() );
                 param.put( "usof" , account.getOfc_cd() );
             }
             SQLExecuter sqlExe = new SQLExecuter("");
             int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyOTSRemarkUSQL(), param, velParam);
             if(result == Statement.EXECUTE_FAILED) {
                 throw new DAOException("Fail to UPDATE REMARK SQL EES_DMT_4105");
             }
         } catch (SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return "";
     }
     
     /**
      * Office별 Tax Ratio 정보를 조회 합니다.<br>
      * 
      * @param SheetOptionVO sheetOptionVO
      * @return String
      * @throws DAOException
      */
     public String searchEnvironmentByOffice(SheetOptionVO sheetOptionVO) throws DAOException {
         DBRowSet dbRowset = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         String result = "0";
         try{
             if(sheetOptionVO != null){
                 Map<String, String> mapVO = sheetOptionVO .getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEnvironmentByOfficeRSQL(), param, velParam);
             
             if(dbRowset.next())
                 result = dbRowset.getString(1);
             
             //reSheetOptionVO = (SheetOptionVO)RowSetUtil.rowSetToVOs(dbRowset, SheetOptionVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return result;
         
     }
    
     
	/**
      * After Booking 승인시 계산을 수행한 후 Invoice 정보를 갱신한다.<br>
      * 
      * @param String darNo
      * @throws DAOException
      */
	public void modifyInvoiceAdjustAmount(String darNo) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();

         try{
                param.put("aft_expt_dar_no", darNo);
                
                new SQLExecuter("").executeUpdate((ISQLTemplate)
                     new InvoiceIssueCollectionMgtDBDAOModifyInvoiceAdjustAmountUSQL(), param, null);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
	}     
     
     
    /**
    * [Sheet Option] 정보를 [Search] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @return SheetOptionTermTitleListUpVO
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<SheetOptionTermTitleListUpVO> searchSheetOptionUp ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<SheetOptionTermTitleListUpVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionUpRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SheetOptionTermTitleListUpVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Sheet Option] 정보를 [Search] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @return SheetOptionTermTitleListDwVO
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<SheetOptionTermTitleListDwVO> searchSheetOptionDw ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<SheetOptionTermTitleListDwVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SheetOptionTermTitleListDwVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Sheet Option] 정보를 [Search] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @return String
    * @throws DAOException
    */
    public String searchSheetOptionInfo ( SheetOptionSearchOptionVO sheetOptionSearchOptionVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }
    
    /**
     * [Sheep Option] 정보를 [DELETE] 합니다.<br>
     * 
     * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
     * @throws DAOException
     * @throws Exception
     */
    public void removeSheetOptionByOffice (SheetOptionSearchOptionVO sheetOptionSearchOptionVO) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            int result = 0;
            SQLExecuter sqlExe = new SQLExecuter("");
            
//            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptDSQL   (), param, velParam);
//            if ( result == Statement.EXECUTE_FAILED ) { throw new DAOException("FAIL TO DELETE DMT_OFC_SH_OPT"       ); }

            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheepOptionCrTermTrfDSQL  (), param, velParam);
            if ( result == Statement.EXECUTE_FAILED ) { throw new DAOException("FAIL TO DELETE DMT_CR_TERM_TRF_OPT"  ); }
            
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCrTermDSQL     (), param, velParam);
            if ( result == Statement.EXECUTE_FAILED ) { throw new DAOException("FAIL TO DELETE DMT_CR_TERM_OPT"      ); }

            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCstmzTitTrfDSQL(), param, velParam);
            if ( result == Statement.EXECUTE_FAILED ) { throw new DAOException("FAIL TO DELETE DMT_CSTMZ_TIT_TRF_OPT"); }
            
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCstmzTitDSQL   (), param, velParam);
            if ( result == Statement.EXECUTE_FAILED ) { throw new DAOException("FAIL TO DELETE DMT_CSTMZ_TIT_OPT"    ); }
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    
    
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String insertDmtOfcShOptData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "usid" , account.getUsr_id() );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT DMT_OFC_SH_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String insertDmtCrTermData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionTermTitleListUpVO != null){
                Map<String, String> mapVO = sheetOptionTermTitleListUpVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "isof" , sheetOptionSearchOptionVO.getIsof() );
            param.put( "usid" , account.getUsr_id()                 );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCrTermCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT DMT_CR_TERM_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String updateDmtOfcShOptData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "usid" , account.getUsr_id() );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheepOptionOfcShOptUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO UPDATE DMT_OFC_SH_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param String trfCd
    * @param String seq
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String insertDmtCrTermTrfData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , String trfCd , String seq , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "trff" , trfCd               );
            param.put( "seqq" , seq                 );
            param.put( "usid" , account.getUsr_id() );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheepOptionCrTermTrfCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT DMT_CR_TERM_TRF_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String insertDmtCstmzTitData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , SheetOptionTermTitleListUpVO sheetOptionTermTitleListUpVO , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionTermTitleListUpVO != null){
                Map<String, String> mapVO = sheetOptionTermTitleListUpVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "isof" , sheetOptionSearchOptionVO.getIsof() );
            param.put( "usid" , account.getUsr_id()                 );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCstmzTitCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT DMT_CSTMZ_TIT_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }
    
    /**
    * [Sheet Option] 정보를 [INSERT] 합니다.<br>
    * 
    * @param SheetOptionSearchOptionVO sheetOptionSearchOptionVO
    * @param String trfcd
    * @param String seq
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String insertDmtCstmzTitTrfData( SheetOptionSearchOptionVO sheetOptionSearchOptionVO , String trfcd , String seq , SignOnUserAccount account ) throws DAOException {

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;

        try{
            if(sheetOptionSearchOptionVO != null){
                Map<String, String> mapVO = sheetOptionSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            param.put( "trff" , trfcd               );
            param.put( "seqq" , seq                 );
            param.put( "usid" , account.getUsr_id() );
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSheetOptionCstmzTitTrfCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT DMT_CSTMZ_TIT_TRF_OPT");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result+"";
    }

    /**
    * [Sheet Setting Screen] 정보를 [Search] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO 
    * @return String
    * @throws DAOException
    */
    public String searchSheetSet ( SheetSetSearchOptionVO sheetSetSearchOptionVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try{
            if(sheetSetSearchOptionVO != null){
                Map<String, String> mapVO = sheetSetSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL(), param, velParam);
            while(dbRowset.next()){
                rtnRemark = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rtnRemark;
    }

    /**
    * [Sheet Setting Screen] 정보를 [DELETE/INSERT] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String saveSheetSet( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if(sheetSetSearchOptionVO != null){
                Map<String, String> mapVO = sheetSetSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                param.put( "usid" , account.getUsr_id() );
                param.put( "usof" , account.getOfc_cd() );
            }
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSaveSheetSetCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to UPDATE Sheet Setting Screen SQL EES_DMT_4101");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return "";
    }
    
    /**
    * [Sheet Setting Screen] 정보를 [DELETE/INSERT] 합니다.<br>
    * 
    * @param SheetSetSearchOptionVO sheetSetSearchOptionVO
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String removeSheetSet( SheetSetSearchOptionVO sheetSetSearchOptionVO , SignOnUserAccount account ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            if(sheetSetSearchOptionVO != null){
                Map<String, String> mapVO = sheetSetSearchOptionVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAORemoveSheetSetDSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to DELETE Sheet Setting Screen SQL EES_DMT_4101");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return "";
    }
    
    /**
     * ISSUED 상태의 Containter 조회
     * @param bkgNo
     * @param dmdtTrfCd
     * @return
     * @throws DAOException
     */
    public int searchContainerNo(String bkgNo, String dmdtTrfCd) throws DAOException {
        DBRowSet dbRowset = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();

        int result = 0;
        try{
            param.put("bkg_no", bkgNo);
            param.put("dmdt_trf_cd", dmdtTrfCd);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchContainerNoRSQL(), param, null);
            
            if(dbRowset.next())
                result = dbRowset.getInt("cntr_no_cnt");
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;      
    }

    
    
    /**
    * [Manual Invoice Report by Office 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceSummaryVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<ManualInvoiceSummaryVO> searchManualInvoiceBySummaryList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<ManualInvoiceSummaryVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(manualInvoiceIssueParmVO != null){
                Map<String, String> mapVO = manualInvoiceIssueParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                String tempISOF = (String)manualInvoiceIssueParmVO.getOffice();
                List<String> tempISOFList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempISOF, ",");
                while (st2.hasMoreTokens()) {
                    tempISOFList.add(st2.nextToken());
                }

                velParam.put("tempISOFList", tempISOFList);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualInvoiceSummaryVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Manual Invoice Report by Office 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param ManualInvoiceIssueParmVO manualInvoiceIssueParmVO
    * @return List<ManualInvoiceIssuedListVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<ManualInvoiceIssuedListVO> searchManualInvoiceByDetailList ( ManualInvoiceIssueParmVO manualInvoiceIssueParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<ManualInvoiceIssuedListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(manualInvoiceIssueParmVO != null){
                Map<String, String> mapVO = manualInvoiceIssueParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                String tempISOF = (String)manualInvoiceIssueParmVO.getOffice();
                String tempRSNC = (String)manualInvoiceIssueParmVO.getReasoncd();
                String tempCURC = (String)manualInvoiceIssueParmVO.getSelcur();
                List<String> tempISOFList = new ArrayList<String>();
                List<String> tempRSNCList = new ArrayList<String>();
                List<String> tempCURCList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempISOF, ",");
                while (st2.hasMoreTokens()) {
                    tempISOFList.add(st2.nextToken());
                }
                StringTokenizer st3 = new StringTokenizer(tempRSNC, ",");
                while (st3.hasMoreTokens()) {
                    tempRSNCList.add(st3.nextToken());
                }
                StringTokenizer st4 = new StringTokenizer(tempCURC, ",");
                while (st4.hasMoreTokens()) {
                    tempCURCList.add(st4.nextToken());
                }

                velParam.put("tempISOFList", tempISOFList);
                velParam.put("tempRSNCList", tempRSNCList);
                velParam.put("tempCURCList", tempCURCList);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualInvoiceIssuedListVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상] 정보를 [Search] 합니다.<br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return List<OtsInquiryByDetialVO3>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<OtsInquiryByDetial3VO> searchOTSInquiryByDetailList3 ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<OtsInquiryByDetial3VO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                String tempINVNO = (String)otsInquiryParmVO.getInvno();
                List<String> tempINVNOList = new ArrayList<String>();
                
                StringTokenizer st1 = new StringTokenizer(tempINVNO, ",");
                while (st1.hasMoreTokens()) {
                    tempINVNOList.add(st1.nextToken());
                }

                velParam.put("tempINVNOList", tempINVNOList);
            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsInquiryByDetial3VO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
     * ofc_cd 데이타 모델에 해당되는 inv_pfx_cd 값을 불러온다.<br>
     * 
     * @param String ofcCd
     * @return String 
     * @throws DAOException
     */
    public String searchInvPfxCd(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        String inv_pfx_cd = "";

        try{
            param.put("ofc_cd", ofcCd);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvPfxCdRSQL(), param, velParam);
            
            if(dbRowset.next()){
                //inv_pfx_cd = dbRowSet
            	inv_pfx_cd = dbRowset.getString("inv_pfx_cd");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return inv_pfx_cd;       
    }
    
    /**
     * Issued Invoice 를 조회 한다.
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<IssuedInvoiceListVO> searchIssuedInvoiceList ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<IssuedInvoiceListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        StringTokenizer st = null;
        
        try{
            if(issuedInvoiceParamVO != null){
                //Over Days
                if(issuedInvoiceParamVO.getSInvOverFm().equals("0") && issuedInvoiceParamVO.getSInvOverTo().equals("0")){
                	issuedInvoiceParamVO.setSInvOverFm("");
                	issuedInvoiceParamVO.setSInvOverTo("");
                }

                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                //2011.03.02. 하드코딩 제거작업
                param.put("head_office", ConstantMgr.getHeadOfficeCode());
                velParam.put("head_office", ConstantMgr.getHeadOfficeCode());
                
                //Tariff Type
                String dmdtTrfCd = (String)issuedInvoiceParamVO.getSDmdtTrfCd();
                List<String> dmdtTrfCdList = new ArrayList<String>();
                st = new StringTokenizer(dmdtTrfCd, ",");
                while (st.hasMoreTokens()) {
                    dmdtTrfCdList.add(st.nextToken());
                }
                velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                
                //A/R I/F
                String dmdtArIfCd = (String)issuedInvoiceParamVO.getSDmdtArIfCd();

                List<String> dmdtArIfCdList = new ArrayList<String>();
                st = new StringTokenizer(dmdtArIfCd, ",");
                while (st.hasMoreTokens()) {
                	String ar_if_cd = st.nextToken();
                   	log.debug("[ar_if_cd]"+ar_if_cd);
                   	if(ar_if_cd.equals("All")) {
                   		dmdtArIfCdList.add("Y");
                   		dmdtArIfCdList.add("N");
                   	}else{
                	
	                	if(ar_if_cd.equals("L")) {
	                		velParam.put("s_ar_if_l_yn", "Y");
	                	}else{
	                    	dmdtArIfCdList.add(ar_if_cd);
	                	}
                   	}
                }
                velParam.put("dmdt_ar_if_list", dmdtArIfCdList);
               	velParam.put("ar_if_cnt", dmdtArIfCdList.size());	
               	
               	
               	log.debug("[s_ar_if_l_yn]"+velParam.get("s_ar_if_l_yn"));
               	log.debug("[ar_if_cnt]"+velParam.get("ar_if_cnt"));
               	
               	//s_ofc_cd
               	String ofcCd = issuedInvoiceParamVO.getSIssueOfc();//s_issue_ofc
				List<String> ofcCdList = new ArrayList<String>();
				st = new StringTokenizer(ofcCd, ",");
			    while (st.hasMoreTokens()) {
			    	String s_ofc_cd = st.nextToken();
                   	log.debug("[s_ofc_cd]"+s_ofc_cd);
			    	ofcCdList.add(s_ofc_cd);
			    }
				velParam.put("ofc_cd_list", ofcCdList);
                
                //Invoice Status
                String dmdtInvStsCd = (String)issuedInvoiceParamVO.getSDmdtInvStsCd();
                List<String> dmdtInvStsCdList = new ArrayList<String>();
                st = new StringTokenizer(dmdtInvStsCd, ",");
                while (st.hasMoreTokens()) {
                	dmdtInvStsCdList.add(st.nextToken());
                }
                velParam.put("dmdt_inv_sts_list", dmdtInvStsCdList);
                
                String s_inv_check = (String)issuedInvoiceParamVO.getSInvCheck();
                
                log.debug("\n [dao]s_inv_check==>"+s_inv_check);
                
                //INV check box
                if(s_inv_check.equals("Y")) {
                    //Invoice No.
                    String invoiceNo = (String)issuedInvoiceParamVO.getSInvoiceNo();
                    if(!invoiceNo.equals("")) {
                        List<String> invoiceNoList = new ArrayList<String>();
                        st = new StringTokenizer(invoiceNo, ",");
                        while (st.hasMoreTokens()) {
                        	invoiceNoList.add(st.nextToken());
                        }
                        velParam.put("invoice_no_list", invoiceNoList);
                    }
                    
                    //BKG No.
                    String bkgNo = (String)issuedInvoiceParamVO.getSBkgNo();
                    if(!bkgNo.equals("")) {
                        List<String> bkgNoList = new ArrayList<String>();
                        st = new StringTokenizer(bkgNo, ",");
                        while (st.hasMoreTokens()) {
                        	bkgNoList.add(st.nextToken());
                        }
                        velParam.put("bkg_no_list", bkgNoList);
                    }
                    
                    //B/L NO.
                    String blNo = (String)issuedInvoiceParamVO.getSBlNo();
                    if(!blNo.equals("")) {
                        List<String> blNoList = new ArrayList<String>();
                        st = new StringTokenizer(blNo, ",");
                        while (st.hasMoreTokens()) {
                            blNoList.add(st.nextToken());
                        }
                        velParam.put("bl_no_list", blNoList);
                    }
                }
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssuedInvoiceListVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }     
    
    
    /**
    * [Manual Invoice Report by Office] 정보를 [Search] 합니다.<br>
    * 
    * @return String
    * @throws DAOException
    */
    public String searchManualInvoiceReasonList() throws DAOException {
        DBRowSet dbRowset = null;
        String reasoncd = "";
        StringBuffer sb = new StringBuffer();
        try{
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL(),null,null);
            
            while(dbRowset.next()){
            	//[2015.05.28]소스품질 Modify
            	sb.append(dbRowset.getString(1)).append("^");
                //reasoncd = dbRowset.getString(1) + "^" + reasoncd;
            }
            reasoncd = sb.toString();
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return reasoncd;
    }
    
    /**
     * 채번테이블에 invoice no를 저장한다.(신규)
     * @param dmtInvNoVO
     * @throws DAOException
     */
    public void createInvoiceNo(DmtInvNoVO dmtInvNoVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            if(dmtInvNoVO != null){
                Map<String, String> mapVO = dmtInvNoVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCreateInvoiceNoCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT CreateInvoiceNo");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    	
    }
    
    /**
     * 채번테이블에 invoice no를 갱신한다.(추가)
     * @param dmtInvNoVO
     * @throws DAOException
     */
    public void modifyInvoiceNo(DmtInvNoVO dmtInvNoVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try{
            if(dmtInvNoVO != null){
                Map<String, String> mapVO = dmtInvNoVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceNoUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO UPDATE ModifyInvoiceNo");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    	
    }
    
    /**
     * 채번테이블의 max값을 조회한다.
     * @param dmtinvNoVO
     * @return String
     * @throws DAOException
     */
    public String searchMaxInvoiceSeq(DmtInvNoVO dmtinvNoVO) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String dmt_inv_seq = "";

        try{
        	if(dmtinvNoVO != null){
                Map<String, String> mapVO = dmtinvNoVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
        	}
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchMaxInvoiceSeqRSQL(), param, velParam);
            if(dbRowset.next()){
            	dmt_inv_seq = dbRowset.getString("dmdt_inv_seq");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return dmt_inv_seq;       
    }
    
    /**
     * [Invoice Create & Issue]을 [Invoice Mn Retrieve] 합니다.<br>
     * 
     * @param String invoiceNo
     * @return List<DmtInvMnVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")    
     public List<DmtInvMnVO> searchManualInvoiceMain(String invoiceNo) throws DAOException {
         DBRowSet dbRowset = null;
         List<DmtInvMnVO> list = null;
 		 //query parameter
 		 Map<String, Object> param = new HashMap<String, Object>();
         try {
				param.put("dmdt_inv_no", invoiceNo);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceMainListRSQL(),param,null);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtInvMnVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }
     
     /**
      * [Invoice Create & Issue]을 [Invoice Detail Retrieve] 합니다.<br>
      * 
      * @param invoiceNo String
      * @return List<DmtInvDtlVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked")     
      public List<DmtInvDtlVO> searchManualInvoiceDetail(String invoiceNo) throws DAOException {
          DBRowSet dbRowset = null;
          List<DmtInvDtlVO> list = null;
  		 //query parameter
  		 Map<String, Object> param = new HashMap<String, Object>();
          try {
 				param.put("dmdt_inv_no", invoiceNo);
 				
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
             		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceDetailListRSQL(),param,null);
 				
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtInvDtlVO .class);
          } catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
      } 
	 
     /**
      * [Invoice Create & Issue]을 [Invoice Rate Retrieve] 합니다.<br>
      * 
      * @param invoiceNo String
      * @return List<DmtInvRtVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked")     
      public List<DmtInvRtVO> searchManualInvoiceRate(String invoiceNo) throws DAOException {
          DBRowSet dbRowset = null;
          List<DmtInvRtVO> list = null;
  		 //query parameter
  		 Map<String, Object> param = new HashMap<String, Object>();
          try {
 				param.put("dmdt_inv_no", invoiceNo);
 				
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
             		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceRateListRSQL(),param,null);
 				
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtInvRtVO .class);
          } catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
      }
	 
     /**
      * [Invoice Create & Issue]을 [Invoice Booking Customer Retrieve] 합니다.<br>
      * 
      * @param bookingNo String
      * @param tariffType String
      * @return List<BookingCustomerVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked")     
      public List<BookingCustomerVO> searchBookingCustomerByManual(String bookingNo, String tariffType) throws DAOException {
          DBRowSet dbRowset = null;
          List<BookingCustomerVO> list = null;
  		 //query parameter
  		 Map<String, Object> param = new HashMap<String, Object>();
          try {
 				param.put("bkg_no", bookingNo);
 				param.put("dmdt_trf_cd", tariffType);
 				
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
             		 new InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerListRSQL(),param,null);
 				
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingCustomerVO .class);
          } catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
      }
	 
     /**
      * [Invoice Create & Issue]을 [Invoice Booking Customer Retrieve] 합니다.<br>
      * 
      * @param issueOfcCd String 
      * @param issueDt String
      * @param dmdtTrfCd String
      * @return List<DmtCrTermOptVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked")     
      public List<DmtCrTermOptVO> searchInvoiceTermOption(String issueOfcCd, String issueDt, String dmdtTrfCd) throws DAOException {
          DBRowSet dbRowset = null;
          List<DmtCrTermOptVO> list = null;
  		 //query parameter
  		 Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();		 
          try {
 				param.put("ofc_cd", issueOfcCd);
 				param.put("issue_dt", issueDt);
 				param.put("dmdt_trf_cd", dmdtTrfCd);
 				
 				velParam.put("ofc_cd", issueOfcCd);
 				velParam.put("issue_dt", issueDt);
 				velParam.put("dmdt_trf_cd", dmdtTrfCd);
 				
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
             		 new InvoiceIssueCollectionMgtDBDAOSearchInvoiceTermOptionListRSQL(),param,velParam);
 				
 				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtCrTermOptVO .class);
          } catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
      }	
    /**
     * [Invoice Create & Issue]을 [Booking Retrieve] 합니다.<br>
     * 
     * @param bookingNo String
     * @param tariffType String
     * @return List<ManualKeyByBookingVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")    
     public List<ManualKeyByBookingVO> searchManualInvoiceBookingData(String bookingNo, String tariffType) throws DAOException {
         DBRowSet 						dbRowset 	= null;
         List<ManualKeyByBookingVO> 	list 		= null;
 		 //query parameter
 		 Map<String, Object> 			param 		= new HashMap<String, Object>();
         try {
				param.put("bkg_no", 		bookingNo);
				param.put("dmdt_trf_cd", 	tariffType);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataRSQL(),param,null);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualKeyByBookingVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }
    /**
     * [Invoice Create & Issue]을 [Booking Retrieve] 합니다.<br>
     * 
     * @param bookingNo String
     * @return List<ManualKeyByBookingVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")    
     public List<ManualKeyByBookingVO> searchManualInvoiceBookingDataInBKG(String bookingNo) throws DAOException {
         DBRowSet 						dbRowset 	= null;
         List<ManualKeyByBookingVO> 	list 		= null;
 		 //query parameter
 		 Map<String, Object> 			param 		= new HashMap<String, Object>();
         try {
				param.put("bkg_no", 	bookingNo);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBookingDataInBKGRSQL(),param,null);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualKeyByBookingVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }
    /**
     * [Invoice Create & Issue]을 [Charge Retrieve] 합니다.<br>
     * 
     * @param bookingNo String 
     * @param officeCode String
     * @param tariffType String
     * @return List<ManualKeyByChargeVO>
     * @throws DAOException
     */
	 @SuppressWarnings("unchecked")    
     public List<ManualKeyByChargeVO> searchManualInvoiceChargeData(
    		 String bookingNo, String officeCode, String tariffType) throws DAOException {
         DBRowSet dbRowset = null;
         List<ManualKeyByChargeVO> list = null;
 		 //query parameter
 		 Map<String, Object> param = new HashMap<String, Object>();
         try {
				param.put("bkg_no", bookingNo);
				param.put("ofc_cd", officeCode);
				param.put("dmdt_trf_cd", tariffType);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		 new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceChargeDataRSQL(),param,null);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ManualKeyByChargeVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }
     /**
      * [Invoice Cancel Reason]을 [조회] 합니다.<br>
      * 
       * @param cntrNo String
       * @return String
       * @exception DAOException
      */
	 public String checkContainerNo(String cntrNo) throws DAOException {	 
         DBRowSet dbRowset = null;
         String result = null;
 		 //query parameter
 		 Map<String, Object> param = new HashMap<String, Object>();         
         try {
				param.put("cntr_no", cntrNo);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
            		 new InvoiceIssueCollectionMgtDBDAOCheckContainerNoRSQL(),param,null);
				
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
				
	      } catch(SQLException se) {
	          log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage());
	      }catch(Exception ex){
	          log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage());
	      }
	      return result;         
	 }
     /**
      * [VVD CD. Calling Port]을 [조회] 합니다.<br>
      * 
       * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
       * @return boolean
       * @exception DAOException
      */
	 public boolean checkCallingPort(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws DAOException {
         DBRowSet dbRowset = null;
         boolean result = false;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();

         try {
             if (chargeBookingInvoiceVO != null) {
                 Map<String, String> mapVO = chargeBookingInvoiceVO .getColumnValues();
                 param.putAll(mapVO);
             }
             
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
        		 new InvoiceIssueCollectionMgtDBDAOCheckCallingPortRSQL(),param,null);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
				
	     } catch(SQLException se) {
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     } catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     return result;         
	 }
     /**
      * [VVD CD. 가 존재하는지]를 [조회] 합니다.<br>
      * 
      * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
      * @return boolean
      * @exception DAOException
      */
	 public boolean checkVVD(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws DAOException {
         DBRowSet dbRowset = null;
         boolean result = false;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();

         try {
             if(chargeBookingInvoiceVO != null) {
                 Map<String, String> mapVO = chargeBookingInvoiceVO .getColumnValues();
                 param.putAll(mapVO);
             }
             
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
        		 new InvoiceIssueCollectionMgtDBDAOCheckVVDRSQL(),param,null);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
				
	     } catch(SQLException se) {
	         log.error(se.getMessage(),se);
	         throw new DAOException(new ErrorHandler(se).getMessage());
	     } catch(Exception ex){
	         log.error(ex.getMessage(),ex);
	         throw new DAOException(new ErrorHandler(ex).getMessage());
	     }
	     return result;         
	 }
     /**
      * [Invoice Cancel Reason]을 [조회] 합니다.<br>
      * 
      * @return List<DmtCommonReturnDataVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked") 
	 public List<DmtCommonReturnDataVO> searchCancelReason() throws DAOException {
         DBRowSet dbRowset = null;
         List<DmtCommonReturnDataVO> list = null;
         try {
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCancelReasonRSQL(),null,null);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtCommonReturnDataVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
	 }

	 
	 
	 
    /**
    * [Hold Reason Entry]을 [SEARCH] 합니다.<br>
    * 
    * @param String invoiceNo
    * @return String
    * @throws DAOException
    */
    public String searchHoldReason( String invoiceNo ) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        String holdReason = "";
        try {
            param.put("invno", invoiceNo);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL(), param, null);
            if(dbRowset.next()){
                holdReason = dbRowset.getString(1);
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return holdReason;       
    }
    
    /**
    * [Hold Reason Entry]을 [SEARCH] 합니다.<br>
    * 
    * @return List<DmtCommonReturnDataVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")    
    public List<DmtCommonReturnDataVO> searchHoldReasonCdList() throws DAOException {
        DBRowSet dbRowset = null;
        List<DmtCommonReturnDataVO> list = null;
        try {
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchHoldReasonCdListRSQL(),null,null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtCommonReturnDataVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }
    
    
    
    /**
    * [Hold Reason Entry] 정보를 [UPDATE] 합니다.<br>
    * 
    * @param String invoiceNo
    * @param String holdReasn
    * @param String holdRemrk
    * @param SignOnUserAccount account
    * @return String
    * @throws DAOException
    */
    public String modifyInvoiceByHold ( String invoiceNo , String holdReasn , String holdRemrk , SignOnUserAccount account ) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            param.put( "invoiceNo" , invoiceNo           );
            param.put( "holdReasn" , holdReasn           );
            param.put( "holdRemrk" , holdRemrk           );
            param.put( "usid"      , account.getUsr_id() );
            param.put( "usof"      , account.getOfc_cd() );                
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceByHoldUSQL(), param, null);
            if(result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to UPDATE Hold Reason Entry SQL EES_DMT_5101");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return "";
    }
    
	 /**
	  * [Minus Invoice Creation ]를 [저장]합니다.<br>
	  * minus charge invoice creation(to new invoice no)
	  * @param DmtInvMnVO dmtInvMnVO
	  * @throws DAOException
	  */
	 public void addCreditInvoiceMain(DmtInvMnVO dmtInvMnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
		    Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
		    param.putAll(mapVO);
		    
		    SQLExecuter sqlExe = new SQLExecuter("");
		    int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL(), param, null);
		    if(result == Statement.EXECUTE_FAILED)
		        throw new DAOException("Fail to addCreditInvoiceMain SQL");
		} catch (SQLException se) {
		    log.error(se.getMessage(),se);
		    throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
		    log.error(ex.getMessage(),ex);
		    throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 
	}
	
	
	/**
	 * [Minus Invoice Creation ]를 [저장]합니다.<br>
	 * minus charge invoice creation(to new invoice no)
	 * @param DmtInvDtlVO dmtInvDtlVO
	 * @throws DAOException
	 */
	public void addCreditInvoiceDetail(DmtInvDtlVO dmtInvDtlVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
		    Map<String, String> mapVO = dmtInvDtlVO.getColumnValues();
		    param.putAll(mapVO);
		    
		    SQLExecuter sqlExe = new SQLExecuter("");
		    int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceDetailCSQL(), param, null);
		    if(result == Statement.EXECUTE_FAILED)
		            throw new DAOException("Fail to addCreditInvoiceDetail SQL");
		} catch (SQLException se) {
		    log.error(se.getMessage(),se);
		    throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
		    log.error(ex.getMessage(),ex);
		    throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 
	 }
	 

	/**
	 * [Minus Invoice Creation ]를 [저장]합니다.<br>
	 * Charge 만 (-)로 해준다.
	 * @param DmtInvRtVO dmtInvRtVO
	 * @throws DAOException
	 */
	public void addCreditInvoiceRate(DmtInvRtVO dmtInvRtVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
		    Map<String, String> mapVO = dmtInvRtVO.getColumnValues();
		    param.putAll(mapVO);
		    
		    SQLExecuter sqlExe = new SQLExecuter("");
		    int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceRateCSQL(), param, null);
		    if(result == Statement.EXECUTE_FAILED)
		            throw new DAOException("Fail to AddCreditInvoiceRate SQL");
		} catch (SQLException se) {
		    log.error(se.getMessage(),se);
		    throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
		    log.error(ex.getMessage(),ex);
		    throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 
	 }	 
	 
	 /**
	  * [Invoice ARIF Check]를 [조회]합니다.<br>
	  * @param String dmdtInvNo
	  * @param String creOfcCd
	  * @return DmtInvMnVO
	  * @throws DAOException
	  */
	 public DmtInvMnVO checkARIF(String dmdtInvNo, String creOfcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 DmtInvMnVO reDmtInvMnVO = new DmtInvMnVO();
		 
		 String dmdtArIfCd 	= ""; 
		 String arIfOfcCd	= "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
      	 
		 try {
			 param.put("dmdt_inv_no", dmdtInvNo);
			 param.put("cre_ofc_cd", creOfcCd);
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckARIFRSQL(),param,null);
			 if(dbRowset.next()){
				dmdtArIfCd 	= dbRowset.getString("dmdt_ar_if_cd");
				arIfOfcCd 	= dbRowset.getString("ar_if_ofc_cd");
           }  			 
			reDmtInvMnVO.setDmdtArIfCd(dmdtArIfCd);
			reDmtInvMnVO.setArIfOfcCd(arIfOfcCd);
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return reDmtInvMnVO;
	 }
	 
	 /**
	  * [Invoice Create Check]를 [조회]합니다.<br>
	  * @param String dmdtInvNo
	  * @param String creOfcCd
	  * @return String
	  * @throws DAOException
	  */
	 public String checkCreditInvoice(String dmdtInvNo, String creOfcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 String reDmdtInvNo = ""; 
		 //query parameter
 		 Map<String, Object> param = new HashMap<String, Object>();
       	 
 		 try {
 			 param.put("dmdt_inv_no", dmdtInvNo);
 			 param.put("cre_ofc_cd", creOfcCd);
 			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckCreditInvoiceRSQL(),param,null);
 			 if(dbRowset.next()){
 				reDmdtInvNo = dbRowset.getString("dmdt_inv_no");
            }  			 
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return reDmdtInvNo;
	 }
	 
	 
	 /**
	  * [Invoice Cancel 상태]를 [수정]합니다.<br>
	  * @param DmtInvMnVO dmtInvMnVO
	  * @throws DAOException
	  */
	 public void modifyInvoiceMain(DmtInvMnVO dmtInvMnVO) throws DAOException {
	        //query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
	        //velocity parameter
	        //Map<String, Object> velParam = new HashMap<String, Object>();
	        
	        try {
	            Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
	            param.putAll(mapVO);
	            
	            SQLExecuter sqlExe = new SQLExecuter("");
	            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceMainUSQL(), param, null);
	            if(result == Statement.EXECUTE_FAILED)
	                    throw new DAOException("Fail to modifyInvoiceMain SQL");
	        } catch (SQLException se) {
	            log.error(se.getMessage(),se);
	            throw new DAOException(new ErrorHandler(se).getMessage());
	        }catch(Exception ex){
	            log.error(ex.getMessage(),ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage());
	        }
		 
	 }	 	 	 		     
     /**
      * [Invoice 정보에 대한 charge 정보]을 [조회] 합니다.<br>
      * 
      * @param String invoiceNo
      * @param String ofcCd
      * @return List<ChargeArgumentVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked") 
	 public List<ChargeArgumentVO> searchInvoiceCharge(String invoiceNo, String ofcCd) throws DAOException {
         DBRowSet dbRowset = null;
         List<ChargeArgumentVO> list = null;
 		 //query parameter
 		 Map<String, Object> param = new HashMap<String, Object>();
         try {
				param.put("dmdt_inv_no", invoiceNo);
				param.put("cre_ofc_cd", ofcCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeRSQL(),param,null);
				
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeArgumentVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
		 
	 }
	 
	 
	 
    /**
    * [ Fax/E-mail Sending History ] 정보를 [SEARCH] 합니다.<br>
    * 
    * @param DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO
    * @return List<DmtFaxEmlSndHisVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")
    public List<DmtFaxEmlSndHisVO> searchFaxEmailHistory ( DmtFaxEmlSndHisParmVO dmtFaxEmlSndHisParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        List<DmtFaxEmlSndHisVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(dmtFaxEmlSndHisParmVO != null){
                Map<String, String> mapVO = dmtFaxEmlSndHisParmVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);

/*----------------------------------------------------------------------------------------*/                
                
                String tempINVOICE = (String)dmtFaxEmlSndHisParmVO.getInvoice(); 
                List<String> tempINVOICEList = new ArrayList<String>();
                
                StringTokenizer st = new StringTokenizer(tempINVOICE, ",");
                while (st.hasMoreTokens()) {
                    tempINVOICEList.add(st.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempSNDOFFC = (String)dmtFaxEmlSndHisParmVO.getSndoffc(); 
                List<String> tempSNDOFFCList = new ArrayList<String>();
                
                StringTokenizer st2 = new StringTokenizer(tempSNDOFFC, ",");
                while (st2.hasMoreTokens()) {
                    tempSNDOFFCList.add(st2.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempSNDOFFCList", tempSNDOFFCList);
                velParam.put("tempINVOICEList", tempINVOICEList);

            }

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtFaxEmlSndHisVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	/**
	 * 다건의 Charge 정보를 [Remove] 합니다.<br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void removeInvoiceDetail(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dmtInvDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAORemoveInvoiceDetailDSQL(), dmtInvDtlVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * 다건의 Rate 정보를 [Remove] 합니다.<br>
	 * 
	 * @param List<DmtInvRtVO> dmtInvRtVOs
	 * @throws DAOException
	 */
	public void removeInvoiceRate(List<DmtInvRtVO> dmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dmtInvRtVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAORemoveInvoiceRateDSQL(), dmtInvRtVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * 다건의 Charge 정보를 [저장] 합니다.<br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void addInvoiceDetailByManual(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dmtInvDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAOAddInvoiceDetailCSQL(), dmtInvDtlVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * 다건의 Rate 정보를 [저장] 합니다.<br>
	 * 
	 * @param List<DmtInvRtVO> dmtInvRtVOs
	 * @throws DAOException
	 */
	public void addInvoiceRateByManual(List<DmtInvRtVO> dmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int addCnt[] = null;
			if(dmtInvRtVOs.size() > 0){
				addCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAOAddInvoiceRateBatchCSQL(), dmtInvRtVOs, null);
				for(int i = 0; i < addCnt.length; i++){
					if(addCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 다건의 Charge 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void modifyInvoiceDetail(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dmtInvDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAOModifyInvoiceDetailUSQL(), dmtInvDtlVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	/**
	 * 다건의 Rate 정보를 [수정] 합니다.<br>
	 * 
	 * @param List<DmtInvRtVO> dDmtInvRtVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyInvoiceRate(List<DmtInvRtVO> dDmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(dDmtInvRtVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)
						new InvoiceIssueCollectionMgtDBDAOModifyInvoiceRateUSQL(), dDmtInvRtVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * VVD 의 공통항차 형식으로 사용될 날짜(YYMM) 을 구합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchDateFormatYYMM(String ofcCd) throws DAOException,Exception {
        DBRowSet dbRowset = null;
        String result = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
        try {
				param.put("ofc_cd", ofcCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)
           		 new InvoiceIssueCollectionMgtDBDAOSearchDateFormatYYMMRSQL(),param,null);
				
				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
				
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
	}	
	
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String custCd
	 * @param String custGubun
	 * @return List<DmtPayrCntcPntVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrCntcPntVO> searchPayerContactPoint(String ofcCd, String custCd, String custGubun) throws DAOException, Exception {
        DBRowSet dbRowset = null;
        List<DmtPayrCntcPntVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	    
        try {
			param.put("s_ofc_cd", ofcCd);
			param.put("s_cust_cd", custCd);
			param.put("s_cust_gubun", custGubun);
			
			velParam.put("s_ofc_cd", ofcCd);
			velParam.put("s_cust_cd", custCd);
			velParam.put("s_cust_gubun", custGubun);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrCntcPntVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
		
	}
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String custCd
	 * @param String custGubun
	 * @return List<DmtPayrCntcPntVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrCntcPntVO> searchPayerContactPointMdm(String ofcCd, String custCd, String custGubun) throws DAOException, Exception {
        DBRowSet dbRowset = null;
        List<DmtPayrCntcPntVO> list = null;
        //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
        try {
			param.put("s_ofc_cd", ofcCd);
			param.put("s_cust_cd", custCd);
			param.put("s_cust_gubun", custGubun);
			
			velParam.put("s_ofc_cd", ofcCd);
			velParam.put("s_cust_cd", custCd);
			velParam.put("s_cust_gubun", custGubun);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrCntcPntVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
		
	}	
		
	/**
	 * Payer 정보를 조회한다.
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String payrYn
	 * @param String sCustGubun
	 * @return DmtPayrInfoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public DmtPayrInfoVO searchPayerInformation(String sOfcCd, String sCustCd, String payrYn, String sCustGubun) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		DmtPayrInfoVO dmtPayInfoVO = new DmtPayrInfoVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
      	 
		try {
			param.put("s_ofc_cd"		, sOfcCd);
			param.put("s_cust_cd"		, sCustCd);
			param.put("payr_yn"			, payrYn);
			param.put("s_cust_gubun"	, sCustGubun);
			
			velParam.put("s_ofc_cd"		, sOfcCd);
			velParam.put("s_cust_cd"	, sCustCd);
			velParam.put("payr_yn"		, payrYn);
			velParam.put("s_cust_gubun"	, sCustGubun);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL(),param,velParam);
			if(dbRowset.next()){
				 
				dmtPayInfoVO.setSvrId(dbRowset.getString("svr_id"));
				dmtPayInfoVO.setCustCd(dbRowset.getString("cust_cd"));
				dmtPayInfoVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
				dmtPayInfoVO.setCustSeq(dbRowset.getString("cust_seq"));
				dmtPayInfoVO.setCustRgstNo(dbRowset.getString("cust_rgst_no"));
				dmtPayInfoVO.setIssDivNm(dbRowset.getString("iss_div_nm"));
				dmtPayInfoVO.setDmdtPayrNm(dbRowset.getString("dmdt_payr_nm"));
				dmtPayInfoVO.setDmdtPayrAddr(dbRowset.getString("dmdt_payr_addr"));
				dmtPayInfoVO.setDmdtPayrCntcPntNm(dbRowset.getString("dmdt_payr_cntc_pnt_nm"));
				dmtPayInfoVO.setDmdtPayrPhnNo(dbRowset.getString("dmdt_payr_phn_no"));
				dmtPayInfoVO.setDmdtPayrFaxNo(dbRowset.getString("dmdt_payr_fax_no"));
				dmtPayInfoVO.setDmdtPayrN1stEml(dbRowset.getString("dmdt_payr_n1st_eml"));
           }  			 
       } catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }catch(Exception ex){
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
       return dmtPayInfoVO;		
	}	
	
	
	/**
	 * Payer Name 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerName(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerNameRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
			
	}
	/**
	 * Payer Address 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerAddress(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerContactPointName(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * Payer Phone No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerPhoneNo(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerPhoneNoRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * Payer Fax No 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerFaxNo(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerFaxNoRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	/**
	 * Payer Email 정보를 조회한다.<br>
	 * 
	 * @param PayerInfoParamVO payerInfoParamVO
	 * @return List<DmtPayrInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrInfoVO> searchPayerEmail(PayerInfoParamVO payerInfoParamVO) throws DAOException {
		DBRowSet dbRowset = null;
        List<DmtPayrInfoVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
            Map<String, String> mapVO = payerInfoParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtPayrInfoVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
	
	/**
	 * Payer Info 존재여부를 조회한다.<br>
	 * 
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String vndrFlg
	 * @return String
	 * @throws DAOException
	 */
	public String checkPayerInfo(String sOfcCd, String  sCustCd, String vndrFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String payr_yn = "";
		try {
			param.put("s_ofc_cd"	, sOfcCd);
			param.put("s_cust_cd"	, sCustCd);
			velParam.put("s_ofc_cd"	, sOfcCd);
			velParam.put("s_cust_cd", sCustCd);
			velParam.put("s_vndr_flg", vndrFlg);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckPayerInfoRSQL(),param,velParam);
            if(dbRowset.next()){
            	payr_yn = dbRowset.getString("payr_yn");
            	
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return payr_yn;
	}
	
	/**
	 * PAYER INFO 정보를 [INSERT] 합니다.<br>
	 * 
	 * @param dmtPayrInfoVO DmtPayrInfoVO
	 * @throws DAOException
	 */
	public void addPayerInfomation(DmtPayrInfoVO dmtPayrInfoVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtPayrInfoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddPayerInfomationCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	/**
	 * PAYER INFO 정보를 [MODIFY] 합니다.<br>
	 * 
	 * @param dmtPayrInfoVO DmtPayrInfoVO
	 * @throws DAOException
	 */
	public void modifyPayerInfomation(DmtPayrInfoVO dmtPayrInfoVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtPayrInfoVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyPayerInfomationUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	/**
	 * Payer Contact Point 존재여부를 조회한다.<br>
	 * 
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String sCustCntcPntSeq
	 * @param String sVndrFlg
	 * @return String
	 * @throws DAOException
	 */
	public String checkPayerContactPoint(String sOfcCd, String  sCustCd, String sCustCntcPntSeq, String sVndrFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String payr_cont_yn = "";
		try {
			param.put("s_ofc_cd"			, sOfcCd);
			param.put("s_cust_cd"			, sCustCd);
			param.put("s_cust_cntc_pnt_seq"	, sCustCntcPntSeq);
			velParam.put("s_ofc_cd"				, sOfcCd);
			velParam.put("s_cust_cd"			, sCustCd);
			velParam.put("s_cust_cntc_pnt_seq"	, sCustCntcPntSeq);
			velParam.put("s_vndr_flg"	, sVndrFlg);
		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL(),param,velParam);
            if(dbRowset.next()){
            	payr_cont_yn = dbRowset.getString("payr_cont_yn");
            	
            }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return payr_cont_yn;
	}
	/**
	 * PAYER CONTACT POINT 정보를 [INSERT] 합니다.<br>
	 * 
	 * @param DmtPayrCntcPntVO dmtPayrCntcPntVO
	 * @throws DAOException
	 */
	public void addPayerContactPoint(DmtPayrCntcPntVO dmtPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddPayerContactPointCSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	/**
	 * PAYER CONTACT POINT 정보를 [MODIFY] 합니다.<br>
	 * 
	 * @param DmtPayrCntcPntVO dmtPayrCntcPntVO
	 * @throws DAOException
	 */
	public void modifyPayerContactPoint(DmtPayrCntcPntVO dmtPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyPayerContactPointUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	
	/**
	 * PAYER CONTACT POINT 정보를 [DELETE] 합니다.<br>
	 * 
	 * @param DmtPayrCntcPntVO dmtPayrCntcPntVO
	 * @throws DAOException
	 */
	public void removePayerContactPoint(DmtPayrCntcPntVO dmtPayrCntcPntVO) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtPayrCntcPntVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAORemovePayerContactPointDSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to remove SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}
	/**
     * Confirm된 CNTR 정보를 그룹별로 조회 합니다.<br>
     * 
     * @param String arOfcCd
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InvArIfMnVO>
     * @throws DAOException
     */
     public InvArIfMnVO searchInterfaceInvoice(String arOfcCd, String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		InvArIfMnVO invArIfMnVO = new InvArIfMnVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("ar_ofc_cd", arOfcCd);
            param.put("invoice_no", invoiceNo);
            param.put("cre_ofc_cd", creOfcCd);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL(),param,null);
            
            if(dbRowset.next()) {
            	//invArIfMnVO.setBlNo(dbRowset.getString("bl_no"));
            	//invArIfMnVO.setBlSrcNo(dbRowset.getString("bl_src_no"));	//테스트 후 변경요청내용(INV_AR_IF_MN의 BL_NO를 BL_SRC_NO에 넣고 BL_NO는 null로 함.) 
            	invArIfMnVO.setBlSrcNo(dbRowset.getString("bl_no"));
            	invArIfMnVO.setInvSrcNo(dbRowset.getString("inv_src_no"));
            	invArIfMnVO.setBkgNo(dbRowset.getString("bkg_no"));
            	invArIfMnVO.setCustCntCd(dbRowset.getString("cust_cnt_cd"));
            	invArIfMnVO.setCustSeq(dbRowset.getString("cust_seq"));
            	invArIfMnVO.setOfcCd(dbRowset.getString("ofc_cd"));
            	invArIfMnVO.setIfSrcCd(dbRowset.getString("if_src_cd"));
            	invArIfMnVO.setVslCd(dbRowset.getString("vsl_cd"));
            	invArIfMnVO.setSkdVoyNo(dbRowset.getString("skd_voy_no"));
            	invArIfMnVO.setSkdDirCd(dbRowset.getString("skd_dir_cd"));
            	invArIfMnVO.setPolCd(dbRowset.getString("pol_cd"));
            	invArIfMnVO.setPodCd(dbRowset.getString("pod_cd"));
            	invArIfMnVO.setTrnkVslCd(dbRowset.getString("trnk_vsl_cd"));
            	invArIfMnVO.setTrnkSkdVoyNo(dbRowset.getString("trnk_skd_voy_no"));
            	invArIfMnVO.setTrnkSkdDirCd(dbRowset.getString("trnk_skd_dir_cd"));
            	invArIfMnVO.setPorCd(dbRowset.getString("por_cd"));
            	invArIfMnVO.setDelCd(dbRowset.getString("del_cd"));
            	invArIfMnVO.setBkgTeuQty(dbRowset.getString("bkg_teu_qty"));
            	invArIfMnVO.setBkgFeuQty(dbRowset.getString("bkg_feu_qty"));
            	invArIfMnVO.setIoBndCd(dbRowset.getString("io_bnd_cd"));
            	invArIfMnVO.setSlsOfcCd(dbRowset.getString("sls_ofc_cd"));
            	invArIfMnVO.setCreUsrId(dbRowset.getString("cre_usr_id"));
            	invArIfMnVO.setCreDt(dbRowset.getString("cre_dt"));
            	invArIfMnVO.setUpdUsrId(dbRowset.getString("upd_usr_id"));
            	invArIfMnVO.setUpdDt(dbRowset.getString("upd_dt"));
            	
            	invArIfMnVO.setInvRefNo(dbRowset.getString("inv_ref_no"));
            	invArIfMnVO.setInvRmk(dbRowset.getString("inv_rmk"));
            	// 2010-08-11 추가
            	invArIfMnVO.setDestTrnsSvcModCd(dbRowset.getString("dest_trns_svc_mod_cd"));
            }
            
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invArIfMnVO;
	}

     /**
      * Confirm된 CNTR 정보를 그룹별로 조회 합니다.<br>
      * 
      * @param String invoiceNo
      * @param String creOfcCd
      * @return List<InvArIfChgVO>
      * @throws DAOException
      */
      @SuppressWarnings("unchecked")
 	public List<InvArIfChgVO> searchInterfaceCharge(String invoiceNo, String creOfcCd) throws DAOException {
 		DBRowSet dbRowset = null;
         List<InvArIfChgVO> list = null;
 		 
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		try {
            param.put("invoice_no", invoiceNo);
            param.put("cre_ofc_cd", creOfcCd);
 			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL(),param,null);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
 	}
      /**
       * Confirm된 CNTR 정보를 그룹별로 조회 합니다.<br>
       * 
       * @param String invoiceNo
       * @param String creOfcCd
       * @return List<InvArIfCntrVO>
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")
  	public List<InvArIfCntrVO> searchInterfaceContainer(String invoiceNo,String creOfcCd) throws DAOException {
  		DBRowSet dbRowset = null;
        List<InvArIfCntrVO> list = null;
  		 
  		//query parameter
  		Map<String, Object> param = new HashMap<String, Object>();
  		try {
             param.put("invoice_no", invoiceNo);
             param.put("cre_ofc_cd", creOfcCd);
  			
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceContainerRSQL(),param,null);
  			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
          } catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }catch(Exception ex){
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return list;
  	}
	
    /**
     * ARIF를 UPDATE한다.
     * @param String arIfNo
     * @param String arOfcCd
     * @param String arUsrId
     * @param String invoiceNo
     * @param String creOfcCd
     * @throws DAOException
     */
    public void modifyARInterface(String arIfNo, String arOfcCd, String arUsrId, String invoiceNo, String creOfcCd) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try {
        	param.put("ar_if_no", arIfNo);
        	param.put("ar_ofc_cd", arOfcCd);
        	param.put("ar_usr_id", arUsrId);
        	param.put("invoice_no", invoiceNo);
        	param.put("cre_ofc_cd", creOfcCd);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyARInterfaceUSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
    
    /**
     * CHARGE CALCULATE할 데이터를 조회한다.
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InterfaceChargeCalculationVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InterfaceChargeCalculationVO> searchInterfaceChargeCalculation(String invoiceNo, String creOfcCd) throws DAOException {
  		DBRowSet dbRowset = null;
        List<InterfaceChargeCalculationVO> list = null;
  		 
  		//query parameter
  		Map<String, Object> param = new HashMap<String, Object>();
  		try {
  			param.put("invoice_no", invoiceNo);
  			param.put("cre_ofc_cd", creOfcCd);
  			
  			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL(),param,null);
  			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InterfaceChargeCalculationVO .class);
  		} catch(SQLException se) {
  			log.error(se.getMessage(),se);
  			throw new DAOException(new ErrorHandler(se).getMessage());
  		}catch(Exception ex){
  			log.error(ex.getMessage(),ex);
  			throw new DAOException(new ErrorHandler(ex).getMessage());
  		}
  		return list;
    }
    
    /**
     * Confirm된 CNTR 정보를 그룹별로 조회 합니다.<br>
     * @param String arOfcCd
     * @param String invoiceNo
     * @param String chgSeq
     * @param String creOfcCd
     * @return InvArIfChgVO
     * @throws DAOException
     */
	public InvArIfChgVO searchInterfaceTaxAmt(String arOfcCd, String invoiceNo, String chgSeq, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("ar_ofc_cd", arOfcCd);
			param.put("invoice_no", invoiceNo);
			param.put("chg_seq", chgSeq);
			param.put("cre_ofc_cd", creOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL(),param,null);
			if(dbRowset.next()){
				invArIfChgVO.setChgAmt(StringUtils.defaultString(dbRowset.getString("chg_amt")));
				invArIfChgVO.setChgCd(StringUtils.defaultString(dbRowset.getString("chg_cd")));
				invArIfChgVO.setChgFullNm("");
				invArIfChgVO.setChgRmk("");
				invArIfChgVO.setChgSeq(StringUtils.defaultString(dbRowset.getString("chg_seq")));
				invArIfChgVO.setCreDt(StringUtils.defaultString(dbRowset.getString("cre_dt")));
				invArIfChgVO.setCreUsrId(StringUtils.defaultString(dbRowset.getString("cre_usr_id")));
				invArIfChgVO.setCurrCd(StringUtils.defaultString(dbRowset.getString("curr_cd")));
				invArIfChgVO.setInvXchRt("");
				invArIfChgVO.setPerTpCd(StringUtils.defaultString(dbRowset.getString("per_tp_cd")));
				invArIfChgVO.setRatAsCntrQty(StringUtils.defaultString(dbRowset.getString("rat_as_cntr_qty")));
				invArIfChgVO.setRepChgCd("");
				invArIfChgVO.setSrcIfDt(StringUtils.defaultString(dbRowset.getString("src_if_dt")));
				invArIfChgVO.setSrcIfSeq(StringUtils.defaultString(dbRowset.getString("src_if_seq")));
				invArIfChgVO.setTrfNo(StringUtils.defaultString(dbRowset.getString("trf_no")));
				invArIfChgVO.setTrfRtAmt(StringUtils.defaultString(dbRowset.getString("trf_rt_amt")));
				invArIfChgVO.setTvaFlg(StringUtils.defaultString(dbRowset.getString("tva_flg")));
				invArIfChgVO.setUpdDt(StringUtils.defaultString(dbRowset.getString("upd_dt")));
				invArIfChgVO.setUpdUsrId(StringUtils.defaultString(dbRowset.getString("upd_usr_id")));
			}
           
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invArIfChgVO;
	}    
	
	/**
	 * INVOICE DETAIL에 데이터가 존재하는지 조회한다.
	 * @param invoiceNo
	 * @param creOfcCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkDmtInvDtl (String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String rString = "";
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckDmtInvDtlRSQL(),param,null);
           if(dbRowset.next()){
        	   rString = dbRowset.getString("invoice_yn");
           }
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return rString;

        
	}
	
	/**
	 * MANUAL INVOICE를 수정한다.
	 * @param DmtInvMnVO dmtInvMnVO
	 * @throws DAOException
	 * @throws Exception
	 */
    public void modifyInvoiceManual(DmtInvMnVO dmtInvMnVO) throws  DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
            param.putAll(mapVO);
            //velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceManualUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modifyInvoice SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
    }	
    
    /**
     * Manual Detail이 존재하지 않을때 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return InvArIfChgVO
     * @throws DAOException
     */
	public InvArIfChgVO searchInterfaceManualCharge(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL(),param,null);
           if(dbRowset.next()){
        	   invArIfChgVO.setChgAmt(StringUtils.defaultString(dbRowset.getString("chg_amt")));
        	   invArIfChgVO.setChgCd(StringUtils.defaultString(dbRowset.getString("chg_cd")));
        	   invArIfChgVO.setChgFullNm("");
        	   invArIfChgVO.setChgRmk("");
        	   invArIfChgVO.setChgSeq(StringUtils.defaultString(dbRowset.getString("chg_seq")));
        	   invArIfChgVO.setCreDt(StringUtils.defaultString(dbRowset.getString("cre_dt")));
        	   invArIfChgVO.setCreUsrId(StringUtils.defaultString(dbRowset.getString("cre_usr_id")));
        	   invArIfChgVO.setCurrCd(StringUtils.defaultString(dbRowset.getString("curr_cd")));
        	   invArIfChgVO.setInvXchRt("");
        	   invArIfChgVO.setPerTpCd(StringUtils.defaultString(dbRowset.getString("per_tp_cd")));	
        	   invArIfChgVO.setRatAsCntrQty(StringUtils.defaultString(dbRowset.getString("rat_as_cntr_qty")));
        	   invArIfChgVO.setRepChgCd("");
        	   invArIfChgVO.setSrcIfDt(StringUtils.defaultString(dbRowset.getString("src_if_dt")));
        	   invArIfChgVO.setSrcIfSeq(StringUtils.defaultString(dbRowset.getString("src_if_seq")));
        	   invArIfChgVO.setTrfNo(StringUtils.defaultString(dbRowset.getString("trf_no")));
        	   invArIfChgVO.setTrfRtAmt(StringUtils.defaultString(dbRowset.getString("trf_rt_amt")));
        	   invArIfChgVO.setTvaFlg(StringUtils.defaultString(dbRowset.getString("tva_flg")));
        	   invArIfChgVO.setUpdDt(StringUtils.defaultString(dbRowset.getString("upd_dt")));
        	   invArIfChgVO.setUpdUsrId(StringUtils.defaultString(dbRowset.getString("upd_usr_id")));
           }
           
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invArIfChgVO;
	}      
	
    /**
     * Manual Detail이 존재하지 않을때 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InvArIfCntrVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfCntrVO> searchInterfaceManualContainer(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArIfCntrVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualContainerRSQL(),param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfCntrVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}	
     
    /**
     * Bkg별 cntr 갯수를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return int
     * @throws DAOException
     */
    public int searchBookingContainerCount(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cntr_cnt = 0;
     
		try{
			Map<String, String> mapVO = issuedInvoiceParamVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL(), param, velParam);
		
			if(dbRowset.next()){
				cntr_cnt = dbRowset.getInt("cntr_cnt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntr_cnt;
          
    }     
    
    /**
     * Payer별 fax번호를 조회 합니다.<br>
     * 
     * @param FAXEmailByPayerVO fAXEmailByPayerVO
     * @return List<FAXEmailByPayerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<FAXEmailByPayerVO> searchFAXByPayer(FAXEmailByPayerVO fAXEmailByPayerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FAXEmailByPayerVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = fAXEmailByPayerVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FAXEmailByPayerVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;    	
    }
    /**
     * Payer별 email주소를 조회 합니다.<br>
     * 
     * @param FAXEmailByPayerVO fAXEmailByPayerVO
     * @return List<FAXEmailByPayerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<FAXEmailByPayerVO> searchEmailByPayer(FAXEmailByPayerVO fAXEmailByPayerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FAXEmailByPayerVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = fAXEmailByPayerVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEmailByPayerRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FAXEmailByPayerVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;    	
    }
    
    /**
     * Group Invoice, Invoice No에 대한 Detail합계금액을 UPDATE 합니다.<br>
     * 
     * @param DmtInvMnVO dmtInvMnVO
     * @throws DAOException
     */
    public void modifyInvoiceMainByGroupContainer(DmtInvMnVO dmtInvMnVO) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceMainByGroupContainerUSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modifyInvoice SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
     * INVOICE RD의 MASTER 데이터를 조회한다.
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws DAOException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreview(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	InvoiceIssueMasterPreviewVO invoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceIssueRDParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueMasterPreviewRSQL(),param,velParam);
           if(dbRowset.next()){
        	   invoiceIssueMasterPreviewVO.setRdShAddr1(StringUtils.defaultString(dbRowset.getString("sh_addr1")));
        	   invoiceIssueMasterPreviewVO.setRdShAddr2(StringUtils.defaultString(dbRowset.getString("sh_addr2")));
        	   invoiceIssueMasterPreviewVO.setRdShAddr3(StringUtils.defaultString(dbRowset.getString("sh_addr3")));
        	   invoiceIssueMasterPreviewVO.setRdInvoiceTitle(StringUtils.defaultString(dbRowset.getString("invoice_title")));
        	   invoiceIssueMasterPreviewVO.setRdCancelNote(StringUtils.defaultString(dbRowset.getString("cancel_note")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtInvStsCd(StringUtils.defaultString(dbRowset.getString("dmdt_inv_sts_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCustNm(StringUtils.defaultString(dbRowset.getString("cust_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPayrAddr(StringUtils.defaultString(dbRowset.getString("payr_addr")));
        	   invoiceIssueMasterPreviewVO.setRdAttnNm(StringUtils.defaultString(dbRowset.getString("attn_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPhnNo(StringUtils.defaultString(dbRowset.getString("phn_no")));
        	   invoiceIssueMasterPreviewVO.setRdFaxNo(StringUtils.defaultString(dbRowset.getString("fax_no")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN1stMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n1st_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN2ndMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n2nd_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN3rdMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n3rd_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN4thMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n4th_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN5thMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n5th_msg")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtInvNo(StringUtils.defaultString(dbRowset.getString("dmdt_inv_no")));
        	   invoiceIssueMasterPreviewVO.setRdIssueDay(StringUtils.defaultString(dbRowset.getString("issue_day")));
        	   invoiceIssueMasterPreviewVO.setRdDueDate(StringUtils.defaultString(dbRowset.getString("due_date")));
        	   invoiceIssueMasterPreviewVO.setRdDueDay(StringUtils.defaultString(dbRowset.getString("due_day")));
        	   invoiceIssueMasterPreviewVO.setRdNtcKntCd(StringUtils.defaultString(dbRowset.getString("ntc_knt_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCreUsrNm(StringUtils.defaultString(dbRowset.getString("cre_usr_nm")));
        	   invoiceIssueMasterPreviewVO.setRdCreCntCd(StringUtils.defaultString(dbRowset.getString("cre_cnt_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCustCd(StringUtils.defaultString(dbRowset.getString("cust_cd")));
        	   invoiceIssueMasterPreviewVO.setRdInvRefNo(StringUtils.defaultString(dbRowset.getString("inv_ref_no")));
        	   invoiceIssueMasterPreviewVO.setRdCustVatNo(StringUtils.defaultString(dbRowset.getString("cust_vat_no")));
        	   invoiceIssueMasterPreviewVO.setRdVvdCd(StringUtils.defaultString(dbRowset.getString("vvd_cd")));
        	   invoiceIssueMasterPreviewVO.setRdVslEngNm(StringUtils.defaultString(dbRowset.getString("vsl_eng_nm")));
        	   invoiceIssueMasterPreviewVO.setRdArr(StringUtils.defaultString(dbRowset.getString("arr")));
        	   invoiceIssueMasterPreviewVO.setRdDep(StringUtils.defaultString(dbRowset.getString("dep")));
        	   invoiceIssueMasterPreviewVO.setRdBlNo(StringUtils.defaultString(dbRowset.getString("bl_no")));
        	   invoiceIssueMasterPreviewVO.setRdBkgNo(StringUtils.defaultString(dbRowset.getString("bkg_no")));
        	   invoiceIssueMasterPreviewVO.setRdCmdtNm(StringUtils.defaultString(dbRowset.getString("cmdt_nm")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtTrfCd(StringUtils.defaultString(dbRowset.getString("dmdt_trf_cd")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtTrfNm(StringUtils.defaultString(dbRowset.getString("dmdt_trf_nm")));
        	   invoiceIssueMasterPreviewVO.setRdBkgRcvTermNm(StringUtils.defaultString(dbRowset.getString("bkg_rcv_term_nm")));
        	   invoiceIssueMasterPreviewVO.setRdBkgDelTermNm(StringUtils.defaultString(dbRowset.getString("bkg_del_term_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPod(StringUtils.defaultString(dbRowset.getString("pod")));
        	   invoiceIssueMasterPreviewVO.setRdPodNm(StringUtils.defaultString(dbRowset.getString("pod_nm")));
        	   invoiceIssueMasterPreviewVO.setRdDel(StringUtils.defaultString(dbRowset.getString("del")));
        	   invoiceIssueMasterPreviewVO.setRdDelNm(StringUtils.defaultString(dbRowset.getString("del_nm")));
        	   invoiceIssueMasterPreviewVO.setPodCd(StringUtils.defaultString(dbRowset.getString("pod_cd")));
        	   invoiceIssueMasterPreviewVO.setPorCd(StringUtils.defaultString(dbRowset.getString("por_cd")));
        	   invoiceIssueMasterPreviewVO.setDelCd(StringUtils.defaultString(dbRowset.getString("del_cd")));
        	   invoiceIssueMasterPreviewVO.setPolCd(StringUtils.defaultString(dbRowset.getString("pol_cd")));
        	   invoiceIssueMasterPreviewVO.setRdTruckerNm(StringUtils.defaultString(dbRowset.getString("trucker_nm")));
        	   invoiceIssueMasterPreviewVO.setRdInvRmk1(StringUtils.defaultString(dbRowset.getString("inv_rmk1")));
        	   invoiceIssueMasterPreviewVO.setRdInvRmk2(StringUtils.defaultString(dbRowset.getString("inv_rmk2")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk1(StringUtils.defaultString(dbRowset.getString("sh_rmk1")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk2(StringUtils.defaultString(dbRowset.getString("sh_rmk2")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk3(StringUtils.defaultString(dbRowset.getString("sh_rmk3")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk4(StringUtils.defaultString(dbRowset.getString("sh_rmk4")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk5(StringUtils.defaultString(dbRowset.getString("sh_rmk5")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk6(StringUtils.defaultString(dbRowset.getString("sh_rmk6")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk7(StringUtils.defaultString(dbRowset.getString("sh_rmk7")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk8(StringUtils.defaultString(dbRowset.getString("sh_rmk8")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk9(StringUtils.defaultString(dbRowset.getString("sh_rmk9")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk10(StringUtils.defaultString(dbRowset.getString("sh_rmk10")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk11(StringUtils.defaultString(dbRowset.getString("sh_rmk11")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk12(StringUtils.defaultString(dbRowset.getString("sh_rmk12")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk13(StringUtils.defaultString(dbRowset.getString("sh_rmk13")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk14(StringUtils.defaultString(dbRowset.getString("sh_rmk14")));
        	   invoiceIssueMasterPreviewVO.setRdOrgCurrCd(StringUtils.defaultString(dbRowset.getString("org_curr_cd")));
        	   invoiceIssueMasterPreviewVO.setRdInvCurrCd(StringUtils.defaultString(dbRowset.getString("inv_curr_cd")));
        	   invoiceIssueMasterPreviewVO.setRdTaxAmtPrnFlg(StringUtils.defaultString(dbRowset.getString("tax_amt_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdDcAmtFlg(StringUtils.defaultString(dbRowset.getString("dc_amt_flg")));
        	   invoiceIssueMasterPreviewVO.setRdCustRefPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_ref_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdCustVatPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_vat_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdPhnFaxPrnFlg(StringUtils.defaultString(dbRowset.getString("phn_fax_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdDaysDisp(StringUtils.defaultString(dbRowset.getString("days_disp")));

        	   String org_chg_amt_str	= dbRowset.getString("org_chg_amt");
        	   double org_chg_amt 		= 0;
        	   if(org_chg_amt_str != null && !org_chg_amt_str.equals("")){
        		   org_chg_amt	= Double.parseDouble(org_chg_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdOrgChgAmt(JSPUtil.toDecimalFormat(org_chg_amt, "#,##0.00"));
        	   
        	   String inv_xch_rt_str	= dbRowset.getString("inv_xch_rt");
        	   double inv_xch_rt 		= 0;
        	   if(inv_xch_rt_str != null && !inv_xch_rt_str.equals("")){
        		   inv_xch_rt	= Double.parseDouble(inv_xch_rt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvXchRt(JSPUtil.toDecimalFormat(inv_xch_rt, "0.000000"));
        	   
        	   String tot_amt_str	= dbRowset.getString("tot_amt");
        	   double tot_amt 		= 0;
        	   if(tot_amt_str != null && !tot_amt_str.equals("")){
        		   tot_amt	= Double.parseDouble(tot_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdTotAmt(JSPUtil.toDecimalFormat(tot_amt, "#,##0.00"));
        	   
        	   String dc_amt_str	= dbRowset.getString("dc_amt");
        	   double dc_amt 		= 0;
        	   if(dc_amt_str != null && !dc_amt_str.equals("")){
        		   dc_amt	= Double.parseDouble(dc_amt_str);
        	   }

        	   invoiceIssueMasterPreviewVO.setRdDcAmt(JSPUtil.toDecimalFormat(dc_amt, "#,##0.00"));
        	   
        	   String inv_chg_amt_str	= dbRowset.getString("inv_chg_amt");
        	   double inv_chg_amt 		= 0;
        	   if(inv_chg_amt_str != null && !inv_chg_amt_str.equals("")){
        		   inv_chg_amt	= Double.parseDouble(inv_chg_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(inv_chg_amt, "#,#00.00"));
        	   
        	   invoiceIssueMasterPreviewVO.setRdTaxRto(StringUtils.defaultString(dbRowset.getString("tax_rto")));
        	   
        	   String tax_amt_str	= dbRowset.getString("tax_amt");
        	   double tax_amt 		= 0;
        	   if(tax_amt_str != null && !tax_amt_str.equals("")){
        		   tax_amt	= Double.parseDouble(tax_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(tax_amt,"#,##0.00"));
        	   
        	   String inv_amt_str	= dbRowset.getString("inv_amt");
        	   double inv_amt 		= 0;
        	   if(inv_amt_str != null && !inv_amt_str.equals("")){
        		   inv_amt	= Double.parseDouble(inv_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(inv_amt,"#,##0.00"));
               // 2012.05.23 INDIA GST Tax 관련 항목추가        	   
        	   String ida_expn_tax_str = dbRowset.getString("ida_expn_tax");
        	   String ida_edu_tax_str = dbRowset.getString("ida_edu_tax");
        	   String ida_high_edu_tax_str = dbRowset.getString("ida_high_edu_tax");
        	   

        	   double ida_expn_tax= 0;
        	   double ida_edu_tax= 0;
        	   double ida_high_edu_tax= 0;
        	   

        	   if(ida_expn_tax_str != null && !ida_expn_tax_str.equals("")){
        		   ida_expn_tax	= Double.parseDouble(ida_expn_tax_str);
        	   }

        	   if(ida_edu_tax_str != null && !ida_edu_tax_str.equals("")){
        		   ida_edu_tax	= Double.parseDouble(ida_edu_tax_str);
        	   }

        	   if(ida_high_edu_tax_str != null && !ida_high_edu_tax_str.equals("")){
        		   ida_high_edu_tax	= Double.parseDouble(ida_high_edu_tax_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTaxRt(dbRowset.getString("ida_expn_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTax(JSPUtil.toDecimalFormat(ida_expn_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTaxRt(dbRowset.getString("ida_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTax(JSPUtil.toDecimalFormat(ida_edu_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTaxRt(dbRowset.getString("ida_high_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTax(JSPUtil.toDecimalFormat(ida_high_edu_tax, "#,##0.00"));
        	   
        	   /*
        	   double org_chg_amt 	= Double.parseDouble(dbRowset.getString("org_chg_amt"));
        	   invoiceIssueMasterPreviewVO.setRdOrgChgAmt(JSPUtil.toDecimalFormat(org_chg_amt, "#,##0.00"));
        	   double inv_xch_rt 	= Double.parseDouble(dbRowset.getString("inv_xch_rt"));
        	   invoiceIssueMasterPreviewVO.setRdInvXchRt(JSPUtil.toDecimalFormat(inv_xch_rt, "0.000000"));
        	   double tot_amt		= Double.parseDouble(dbRowset.getString("tot_amt"));
        	   invoiceIssueMasterPreviewVO.setRdTotAmt(JSPUtil.toDecimalFormat(tot_amt, "#,##0.00"));
        	   double dc_amt		= Double.parseDouble(dbRowset.getString("dc_amt"));
        	   invoiceIssueMasterPreviewVO.setRdDcAmt(JSPUtil.toDecimalFormat(dc_amt, "#,##0.00"));
        	   double inv_chg_amt	= Double.parseDouble(dbRowset.getString("inv_chg_amt"));
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(inv_chg_amt, "#,#00.00"));
        	   invoiceIssueMasterPreviewVO.setRdTaxRto(StringUtils.defaultString(dbRowset.getString("tax_rto")));
        	   double tax_amt		= Double.parseDouble(dbRowset.getString("tax_amt"));
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(tax_amt,"#,##0.00"));
        	   double inv_amt		= Double.parseDouble(dbRowset.getString("inv_amt"));
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(inv_amt,"#,##0.00"));
			   */
//        	   log.debug("org_chg_amt1]"+org_chg_amt);
//        	   log.debug("inv_xch_rt1]"+inv_xch_rt);
//        	   log.debug("org_chg_amt2]"+invoiceIssueMasterPreviewVO.getRdOrgChgAmt());
//        	   log.debug("inv_xch_rt2]"+invoiceIssueMasterPreviewVO.getRdInvXchRt());

           }
           
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD의 incCntlDtail 값이 No 인 MASTER 데이터를 조회한다.
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return InvoiceIssueMasterPreviewVO
     * @throws DAOException
     */
    public InvoiceIssueMasterPreviewVO searchInvoiceIssueMasterPreviewNo(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	DBRowSet dbRowsetNo = null;
    	InvoiceIssueMasterPreviewVO invoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invoiceIssueRDParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueMasterPreviewRSQL(),param,velParam);
           if(dbRowset.next()){
        	   invoiceIssueMasterPreviewVO.setRdShAddr1(StringUtils.defaultString(dbRowset.getString("sh_addr1")));
        	   invoiceIssueMasterPreviewVO.setRdShAddr2(StringUtils.defaultString(dbRowset.getString("sh_addr2")));
        	   invoiceIssueMasterPreviewVO.setRdShAddr3(StringUtils.defaultString(dbRowset.getString("sh_addr3")));
        	   invoiceIssueMasterPreviewVO.setRdInvoiceTitle(StringUtils.defaultString(dbRowset.getString("invoice_title")));
        	   invoiceIssueMasterPreviewVO.setRdCancelNote(StringUtils.defaultString(dbRowset.getString("cancel_note")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtInvStsCd(StringUtils.defaultString(dbRowset.getString("dmdt_inv_sts_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCustNm(StringUtils.defaultString(dbRowset.getString("cust_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPayrAddr(StringUtils.defaultString(dbRowset.getString("payr_addr")));
        	   invoiceIssueMasterPreviewVO.setRdAttnNm(StringUtils.defaultString(dbRowset.getString("attn_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPhnNo(StringUtils.defaultString(dbRowset.getString("phn_no")));
        	   invoiceIssueMasterPreviewVO.setRdFaxNo(StringUtils.defaultString(dbRowset.getString("fax_no")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN1stMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n1st_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN2ndMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n2nd_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN3rdMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n3rd_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN4thMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n4th_msg")));
        	   invoiceIssueMasterPreviewVO.setRdShHdN5thMsg(StringUtils.defaultString(dbRowset.getString("sh_hd_n5th_msg")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtInvNo(StringUtils.defaultString(dbRowset.getString("dmdt_inv_no")));
        	   invoiceIssueMasterPreviewVO.setRdIssueDay(StringUtils.defaultString(dbRowset.getString("issue_day")));
        	   invoiceIssueMasterPreviewVO.setRdDueDate(StringUtils.defaultString(dbRowset.getString("due_date")));
        	   invoiceIssueMasterPreviewVO.setRdDueDay(StringUtils.defaultString(dbRowset.getString("due_day")));
        	   invoiceIssueMasterPreviewVO.setRdNtcKntCd(StringUtils.defaultString(dbRowset.getString("ntc_knt_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCreUsrNm(StringUtils.defaultString(dbRowset.getString("cre_usr_nm")));
        	   invoiceIssueMasterPreviewVO.setRdCreCntCd(StringUtils.defaultString(dbRowset.getString("cre_cnt_cd")));
        	   invoiceIssueMasterPreviewVO.setRdCustCd(StringUtils.defaultString(dbRowset.getString("cust_cd")));
        	   invoiceIssueMasterPreviewVO.setRdInvRefNo(StringUtils.defaultString(dbRowset.getString("inv_ref_no")));
        	   invoiceIssueMasterPreviewVO.setRdCustVatNo(StringUtils.defaultString(dbRowset.getString("cust_vat_no")));
        	   invoiceIssueMasterPreviewVO.setRdVvdCd(StringUtils.defaultString(dbRowset.getString("vvd_cd")));
        	   invoiceIssueMasterPreviewVO.setRdVslEngNm(StringUtils.defaultString(dbRowset.getString("vsl_eng_nm")));
        	   invoiceIssueMasterPreviewVO.setRdArr(StringUtils.defaultString(dbRowset.getString("arr")));
        	   invoiceIssueMasterPreviewVO.setRdDep(StringUtils.defaultString(dbRowset.getString("dep")));
        	   invoiceIssueMasterPreviewVO.setRdBlNo(StringUtils.defaultString(dbRowset.getString("bl_no")));
        	   invoiceIssueMasterPreviewVO.setRdBkgNo(StringUtils.defaultString(dbRowset.getString("bkg_no")));
        	   invoiceIssueMasterPreviewVO.setRdCmdtNm(StringUtils.defaultString(dbRowset.getString("cmdt_nm")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtTrfCd(StringUtils.defaultString(dbRowset.getString("dmdt_trf_cd")));
        	   invoiceIssueMasterPreviewVO.setRdDmdtTrfNm(StringUtils.defaultString(dbRowset.getString("dmdt_trf_nm")));
        	   invoiceIssueMasterPreviewVO.setRdBkgRcvTermNm(StringUtils.defaultString(dbRowset.getString("bkg_rcv_term_nm")));
        	   invoiceIssueMasterPreviewVO.setRdBkgDelTermNm(StringUtils.defaultString(dbRowset.getString("bkg_del_term_nm")));
        	   invoiceIssueMasterPreviewVO.setRdPod(StringUtils.defaultString(dbRowset.getString("pod")));
        	   invoiceIssueMasterPreviewVO.setRdPodNm(StringUtils.defaultString(dbRowset.getString("pod_nm")));
        	   invoiceIssueMasterPreviewVO.setRdDel(StringUtils.defaultString(dbRowset.getString("del")));
        	   invoiceIssueMasterPreviewVO.setRdDelNm(StringUtils.defaultString(dbRowset.getString("del_nm")));
        	   invoiceIssueMasterPreviewVO.setPodCd(StringUtils.defaultString(dbRowset.getString("pod_cd")));
        	   invoiceIssueMasterPreviewVO.setPorCd(StringUtils.defaultString(dbRowset.getString("por_cd")));
        	   invoiceIssueMasterPreviewVO.setDelCd(StringUtils.defaultString(dbRowset.getString("del_cd")));
        	   invoiceIssueMasterPreviewVO.setPolCd(StringUtils.defaultString(dbRowset.getString("pol_cd")));
        	   invoiceIssueMasterPreviewVO.setRdTruckerNm(StringUtils.defaultString(dbRowset.getString("trucker_nm")));
        	   invoiceIssueMasterPreviewVO.setRdInvRmk1(StringUtils.defaultString(dbRowset.getString("inv_rmk1")));
        	   invoiceIssueMasterPreviewVO.setRdInvRmk2(StringUtils.defaultString(dbRowset.getString("inv_rmk2")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk1(StringUtils.defaultString(dbRowset.getString("sh_rmk1")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk2(StringUtils.defaultString(dbRowset.getString("sh_rmk2")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk3(StringUtils.defaultString(dbRowset.getString("sh_rmk3")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk4(StringUtils.defaultString(dbRowset.getString("sh_rmk4")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk5(StringUtils.defaultString(dbRowset.getString("sh_rmk5")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk6(StringUtils.defaultString(dbRowset.getString("sh_rmk6")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk7(StringUtils.defaultString(dbRowset.getString("sh_rmk7")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk8(StringUtils.defaultString(dbRowset.getString("sh_rmk8")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk9(StringUtils.defaultString(dbRowset.getString("sh_rmk9")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk10(StringUtils.defaultString(dbRowset.getString("sh_rmk10")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk11(StringUtils.defaultString(dbRowset.getString("sh_rmk11")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk12(StringUtils.defaultString(dbRowset.getString("sh_rmk12")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk13(StringUtils.defaultString(dbRowset.getString("sh_rmk13")));
        	   invoiceIssueMasterPreviewVO.setRdShRmk14(StringUtils.defaultString(dbRowset.getString("sh_rmk14")));
        	   invoiceIssueMasterPreviewVO.setRdOrgCurrCd(StringUtils.defaultString(dbRowset.getString("org_curr_cd")));
        	   invoiceIssueMasterPreviewVO.setRdInvCurrCd(StringUtils.defaultString(dbRowset.getString("inv_curr_cd")));
        	   invoiceIssueMasterPreviewVO.setRdTaxAmtPrnFlg(StringUtils.defaultString(dbRowset.getString("tax_amt_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdDcAmtFlg(StringUtils.defaultString(dbRowset.getString("dc_amt_flg")));
        	   invoiceIssueMasterPreviewVO.setRdCustRefPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_ref_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdCustVatPrnFlg(StringUtils.defaultString(dbRowset.getString("cust_vat_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdPhnFaxPrnFlg(StringUtils.defaultString(dbRowset.getString("phn_fax_prn_flg")));
        	   invoiceIssueMasterPreviewVO.setRdDaysDisp(StringUtils.defaultString(dbRowset.getString("days_disp")));

        	   String org_chg_amt_str	= dbRowset.getString("org_chg_amt");
        	   double org_chg_amt 		= 0;
        	   if(org_chg_amt_str != null && !org_chg_amt_str.equals("")){
        		   org_chg_amt	= Double.parseDouble(org_chg_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdOrgChgAmt(JSPUtil.toDecimalFormat(org_chg_amt, "#,##0.00"));
        	   
        	   String inv_xch_rt_str	= dbRowset.getString("inv_xch_rt");
        	   double inv_xch_rt 		= 0;
        	   if(inv_xch_rt_str != null && !inv_xch_rt_str.equals("")){
        		   inv_xch_rt	= Double.parseDouble(inv_xch_rt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvXchRt(JSPUtil.toDecimalFormat(inv_xch_rt, "0.000000"));
        	   
        	   String tot_amt_str	= dbRowset.getString("tot_amt");
        	   double tot_amt 		= 0;
        	   if(tot_amt_str != null && !tot_amt_str.equals("")){
        		   tot_amt	= Double.parseDouble(tot_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdTotAmt(JSPUtil.toDecimalFormat(tot_amt, "#,##0.00"));
        	   
        	   String dc_amt_str	= dbRowset.getString("dc_amt");
        	   double dc_amt 		= 0;
        	   if(dc_amt_str != null && !dc_amt_str.equals("")){
        		   dc_amt	= Double.parseDouble(dc_amt_str);
        	   }

        	   invoiceIssueMasterPreviewVO.setRdDcAmt(JSPUtil.toDecimalFormat(dc_amt, "#,##0.00"));
        	   
        	   String inv_chg_amt_str	= dbRowset.getString("inv_chg_amt");
        	   double inv_chg_amt 		= 0;
        	   if(inv_chg_amt_str != null && !inv_chg_amt_str.equals("")){
        		   inv_chg_amt	= Double.parseDouble(inv_chg_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(inv_chg_amt, "#,#00.00"));
        	   
        	   String tax_amt_str	= dbRowset.getString("tax_amt");
        	   double tax_amt 		= 0;
        	   if(tax_amt_str != null && !tax_amt_str.equals("")){
        		   tax_amt	= Double.parseDouble(tax_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(tax_amt,"#,##0.00"));
        	   
        	   String inv_amt_str	= dbRowset.getString("inv_amt");
        	   double inv_amt 		= 0;
        	   if(inv_amt_str != null && !inv_amt_str.equals("")){
        		   inv_amt	= Double.parseDouble(inv_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(inv_amt,"#,##0.00"));
        	   
               // 2012.05.23 INDIA GST Tax 관련 항목추가        	   
        	   String ida_expn_tax_rt_str = dbRowset.getString("ida_expn_tax_rt");
        	   String ida_expn_tax_str = dbRowset.getString("ida_expn_tax");
        	   String ida_edu_tax_rt_str = dbRowset.getString("ida_edu_tax_rt");
        	   String ida_edu_tax_str = dbRowset.getString("ida_edu_tax");
        	   String ida_high_edu_tax_rt_str = dbRowset.getString("ida_high_edu_tax_rt");
        	   String ida_high_edu_tax_str = dbRowset.getString("ida_high_edu_tax");
        	   
        	   double ida_expn_tax_rt= 0;
        	   double ida_expn_tax= 0;
        	   double ida_edu_tax_rt= 0;
        	   double ida_edu_tax= 0;
        	   double ida_high_edu_tax_rt= 0;
        	   double ida_high_edu_tax= 0;
        	   
        	   if(ida_expn_tax_rt_str != null && !ida_expn_tax_rt_str.equals("")){
        		   ida_expn_tax_rt	= Double.parseDouble(ida_expn_tax_rt_str);
        	   }
        	   if(ida_expn_tax_str != null && !ida_expn_tax_str.equals("")){
        		   ida_expn_tax	= Double.parseDouble(ida_expn_tax_str);
        	   }
        	   if(ida_edu_tax_rt_str != null && !ida_edu_tax_rt_str.equals("")){
        		   ida_edu_tax_rt	= Double.parseDouble(ida_edu_tax_rt_str);
        	   }
        	   if(ida_edu_tax_str != null && !ida_edu_tax_str.equals("")){
        		   ida_edu_tax	= Double.parseDouble(ida_edu_tax_str);
        	   }
        	   if(ida_high_edu_tax_rt_str != null && !ida_high_edu_tax_rt_str.equals("")){
        		   ida_high_edu_tax_rt	= Double.parseDouble(ida_high_edu_tax_rt_str);
        	   }
        	   if(ida_high_edu_tax_str != null && !ida_high_edu_tax_str.equals("")){
        		   ida_high_edu_tax	= Double.parseDouble(ida_high_edu_tax_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTaxRt(JSPUtil.toDecimalFormat(ida_expn_tax_rt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTax(JSPUtil.toDecimalFormat(ida_expn_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTaxRt(JSPUtil.toDecimalFormat(ida_edu_tax_rt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTax(JSPUtil.toDecimalFormat(ida_edu_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTaxRt(JSPUtil.toDecimalFormat(ida_high_edu_tax_rt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTax(JSPUtil.toDecimalFormat(ida_high_edu_tax, "#,##0.00"));

         	   
        	   /*
        	    * 이 부분은 새로 쿼리를 돌려 받아온다.
        	   double inv_chg_amt	= Double.parseDouble(dbRowset.getString("inv_chg_amt"));
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(inv_chg_amt, "#,#00.00"));
        	   invoiceIssueMasterPreviewVO.setRdTaxRto(StringUtils.defaultString(dbRowset.getString("tax_rto")));
        	   double tax_amt		= Double.parseDouble(dbRowset.getString("tax_amt"));
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(tax_amt,"#,##0.00"));
        	   double inv_amt		= Double.parseDouble(dbRowset.getString("inv_amt"));
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(inv_amt,"#,##0.00"));
        	    */
//        	   log.debug("org_chg_amt1]"+org_chg_amt);
//        	   log.debug("inv_xch_rt1]"+inv_xch_rt);
//        	   log.debug("org_chg_amt2]"+invoiceIssueMasterPreviewVO.getRdOrgChgAmt());
//        	   log.debug("inv_xch_rt2]"+invoiceIssueMasterPreviewVO.getRdInvXchRt());
           }
           dbRowsetNo = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueMasterPreviewNoRSQL(),param,velParam);
           
           if(dbRowsetNo.next()){
        	   String inv_chg_amt_str	= dbRowset.getString("inv_chg_amt");
        	   double inv_chg_amt 		= 0;
        	   if(inv_chg_amt_str != null && !inv_chg_amt_str.equals("")){
        		   inv_chg_amt	= Double.parseDouble(inv_chg_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(inv_chg_amt, "#,#00.00"));
        	   
        	   String tax_amt_str	= dbRowset.getString("tax_amt");
        	   double tax_amt 		= 0;
        	   if(tax_amt_str != null && !tax_amt_str.equals("")){
        		   tax_amt	= Double.parseDouble(tax_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(tax_amt,"#,##0.00"));
        	   
        	   String inv_amt_str	= dbRowset.getString("inv_amt");
        	   double inv_amt 		= 0;
        	   if(inv_amt_str != null && !inv_amt_str.equals("")){
        		   inv_amt	= Double.parseDouble(inv_amt_str);
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(inv_amt,"#,##0.00"));
           }
           
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD의 manual invoice MASTER 데이터를 조회한다.<br>
     * 
     * @param InvoiceIssueRDParamVO invoiceIssueRDParamVO
     * @return List<InvoiceIssueRDPreviewVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InvoiceIssueRDPreviewVO> searchInvoiceIssueManualRD(InvoiceIssueRDParamVO invoiceIssueRDParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceIssueRDPreviewVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = invoiceIssueRDParamVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueRDPreviewVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;    	
    }
    
    /**
     * AR-IF 후 EDI로 전송할 데이터를 조회한다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<EDIContainerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<EDIContainerVO> searchEDIContainerInfoByInvoice(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EDIContainerVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("invoice_no", invoiceNo);
			param.put("cre_ofc_cd", creOfcCd);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL(),param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EDIContainerVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;    
    }
    /**
     * InvoiceDetail정보로 interfaceCharge로 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InvArIfChgVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInterfaceChargeByInvoiceDetail(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
        List<InvArIfChgVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
           velParam.put("credit_note", "N");
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}
     
     /**
 	 * OFC_CD별 현재일자를 조회한다.
 	 * 
 	 * @param String ofcCd
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchCurrentDateByOffice(String ofcCd) throws DAOException {
 		DBRowSet dbRowset = null;
 		String curr_day = "";
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		
 		try{
 			param.put("ofc_cd", ofcCd);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
 			if(dbRowset.next()){
 				curr_day = dbRowset.getString("curr_day");
 			}
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return curr_day;
 	}
 	
	/**
	 * 해당 Payer에 대한 PayerName 정보를 조회한다.<br>
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @throws DAOException
	 */
	public PayerNameVO searchPayerInfoName(PayerNameParamVO payerNameParamVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		PayerNameVO rePayerNameVO = new PayerNameVO();
	
		try {
			if(payerNameParamVO != null){
				Map<String, String> mapVO = payerNameParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchPayerInfoNameRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				rePayerNameVO.setDeltFlg(dbRowset.getString(1));
				rePayerNameVO.setCustCd(dbRowset.getString(2));
				rePayerNameVO.setCustName(dbRowset.getString(3));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rePayerNameVO;
	} 	
	
	/**
	 * 해당 Service Provider에 대한 Vendor를 조회한다.<br>
	 * 
	 * @param String serviceProviderCode
	 * @return VendorNameVO
	 * @throws DAOException
	 */
	public VendorNameVO searchServiceProviderName(String serviceProviderCode) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		VendorNameVO reVendorNameVO = new VendorNameVO();
		String code = "";
		String name = "";
	
		try {
			if(serviceProviderCode != null){
				param.put("vndr_cd", serviceProviderCode);
				velParam.put("vndr_cd", serviceProviderCode);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchServiceProviderNameRSQL(), param, null);
			
			if(dbRowset.next()) {
				code = StringUtils.defaultString(dbRowset.getString(1));
				name = StringUtils.defaultString(dbRowset.getString(2));
			}
			reVendorNameVO.setVndrCd(code);
			reVendorNameVO.setVndrNm(name);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return reVendorNameVO;
	}		
	
	/**
	 * tax_rto에 대한 invoice_detail의 tax_amt값을 계산한다.<br>
	 * 
	 * @param InvoiceDetailTaxVO invoiceDetailTaxVO
	 * @return double
	 * @throws DAOException
	 */
	public double searchInvoiceDetailTaxAmt(InvoiceDetailTaxVO invoiceDetailTaxVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		double tax_amt = 0;
		
		try {
			if(invoiceDetailTaxVO != null){
				Map<String, String> mapVO = invoiceDetailTaxVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL(), param, null);
			
			if(dbRowset.next()) {
				tax_amt = dbRowset.getDouble("calc_tax_amt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tax_amt;		
	}
	
	
	/**
	 * Invoice Detail의 tax_rto, tax_amt를 수정한다.<br>
	 * 
	 * @param InvoiceDetailTaxVO invoiceDetailTaxVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyInvoiceDetailByInvoiceMain(InvoiceDetailTaxVO invoiceDetailTaxVO, SignOnUserAccount account) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = invoiceDetailTaxVO.getColumnValues();
            param.putAll(mapVO);
            param.put( "upd_usr_id" , account.getUsr_id() );
            param.put( "upd_ofc_cd" , account.getOfc_cd() );
            
            SQLExecuter sqlExe = new SQLExecuter("");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyInvoiceDetailByInvoiceMainUSQL(), param, null);
            
            if(result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to modifyInvoiceDetailByInvoiceMain SQL");
            
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }		
	}
	
    /**
 	 * SZPBB를 통해 INVOICE 생성 여부 확인
 	 * 
 	 * @param String invoiceNo
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String checkSZPBBInvoice(String invoiceNo) throws DAOException {
 		DBRowSet dbRowset = null;
 		String suth_chn_iss_flg = "N";
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		
 		try{
 			param.put("invoice_no", invoiceNo);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL(), param, null);
 			if(dbRowset.next()){
 				suth_chn_iss_flg = dbRowset.getString("suth_chn_iss_flg");
 			}
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return suth_chn_iss_flg;
 	}	
 	
 	/**
 	 * Invoice Cancel 상태여부 조회
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String checkInvoiceCancel(String invoiceNo, String creOfcCd) throws DAOException {
 		DBRowSet dbRowset = null;
 		String cancel_yn = "N";
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		
 		try{
 			param.put("s_invoice_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL(), param, null);
 			if(dbRowset.next()){
 				cancel_yn = dbRowset.getString("cancel_yn");
 			}
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return cancel_yn;
  		
 	}
 	
 	/**
 	 * Manual Invoice (BIL_AMT - INV_CHG_AMT) 값, INV_CURR_CD
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String[]
 	 * @throws DAOException
 	 */
 	public String[] checkManualARIFAmt(String invoiceNo, String creOfcCd) throws DAOException {
 		DBRowSet dbRowset = null;
 		String[] r_value = new String[2];
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		
 		try{
 			param.put("invoice_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL(), param, null);
 			if(dbRowset.next()){
 				r_value[0] = dbRowset.getString("m_amt");
 				r_value[1] = dbRowset.getString("inv_curr_cd");
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return r_value;
 	}
 	
 	/**
 	 * AR-IF 직전 INVOICE에 대한 AR-IF 실행 여부 체크
 	 * @param String[] invoiceNos
 	 * @param String creOfcCd
 	 * @param String flg
 	 * @return List<String>
 	 * @throws DAOException
 	 */
 	public List<String> searchARIFCount(String[] invoiceNos, String creOfcCd, String flg) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<String> invoiceNoList = new ArrayList<String>();
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		Map<String, Object> velParam 	= new HashMap<String, Object>();
 		log.debug("dao searchARIFCount cre_ofc_cd==>"+creOfcCd);
 		
 		try{
 			List<String> invoceNoList = new ArrayList<String>();
 			for(int i = 0; i < invoiceNos.length ; i++) {
 				invoceNoList.add(invoiceNos[i]);
 			}
 			velParam.put("dmdt_inv_no_list", invoceNoList);
 			velParam.put("check_flg", flg);
 			param.put("cre_ofc_cd", creOfcCd);
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL(), param, velParam);

 			while(dbRowset.next()){
 				invoiceNoList.add(JSPUtil.getNull(dbRowset.getString(1)));
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return invoiceNoList;
 	}
 	
 	
 	/**
 	 * Invoice 생성자의 Office Code 를 조회 합니다.
 	 * 
	 * @param String invoiceNo
	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchInvoiceCreteOfficeCode(String invoiceNo) throws DAOException {
 		DBRowSet 	dbRowset 	= null;
 		String		result		= null;

 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		
 		try {
 			param.put("dmdt_inv_no", invoiceNo);
    
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceCreteOfficeCodeRSQL(), param, null);

 			if (dbRowset.next()) {
 				result = dbRowset.getString("cre_ofc_cd");
 			}
 			
 		} catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return result;
 	} 	
 	
 	/**
 	 * DMT_CHG_CALC의 DMDT_CHG_STS_CD를 조회한다.
 	 * @param DmtInvDtlVO dmtInvDtlVO
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchChargeStatusCd(DmtInvDtlVO dmtInvDtlVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		String r_value = "";
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		Map<String, Object> velParam 	= new HashMap<String, Object>();
 		
 		try{
 			Map<String, String> mapVO = dmtInvDtlVO.getColumnValues();
 			param.putAll(mapVO);
 			velParam.putAll(mapVO);
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL(), param, velParam);

 			while(dbRowset.next()){
 				r_value = JSPUtil.getNull(dbRowset.getString("dmdt_chg_sts_cd"));
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return r_value;
 	}
 	
 	/**
 	 * DMT_INV_MN의 DMDT_INV_STS_CD를 조회한다.
 	 * @param String invoiceNo
 	 * @param String creOfcCd
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchInvoiceStatus(String invoiceNo, String creOfcCd) throws DAOException {
 		DBRowSet dbRowset = null;
 		String r_value = "";
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		Map<String, Object> velParam 	= new HashMap<String, Object>();
 		
 		try{
 			param.put("dmdt_inv_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			velParam.put("dmdt_inv_no", invoiceNo);
 			velParam.put("cre_ofc_cd", creOfcCd);
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceStatusRSQL(), param, velParam);

 			while(dbRowset.next()){
 				r_value = JSPUtil.getNull(dbRowset.getString("dmdt_inv_sts_cd"));
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return r_value;
 	}
 	
    /**
     * InvoiceRate정보로 interfaceCharge로 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InvArIfChgVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInterfaceChargeByInvoiceRate(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
        List<InvArIfChgVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL(),param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	} 	
    
    /**
     * Invoice에 대한 After Invoice Adjustment Amt를 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param SignOnUserAccount account
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, SignOnUserAccount account) throws DAOException {
    	DBRowSet dbRowset = null;
 		ChargeBookingInvoiceVO reVO = new ChargeBookingInvoiceVO();
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		
 		try{
 			param.put("dmdt_inv_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			param.put("ofc_cd", account.getOfc_cd());
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckAftInvAdjAmtByInvoiceNoRSQL(), param, null);

 			if(dbRowset.next()){
 				reVO.setAftInvAdjAmt(dbRowset.getString("aft_inv_adj_amt"));
 				reVO.setArIfOfcCd(dbRowset.getString("ar_if_ofc_cd"));
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return reVO;
    }
    
    /**
     * Invoice Detail의 FX_FT_OVR_DYS = 0 이 개수 조회
     * 
     * @param invoiceNo
     * @param creOfcCd
     * @return int
     * @throws DAOException
     */
    public String searchInvoiceDetailZeroOverDay(String invoiceNo, String creOfcCd) throws DAOException {
    	DBRowSet dbRowset = null;
    	//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		String cntrNo = "";
 		
 		try{
 			param.put("dmdt_inv_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL(), param, null);

 			if(dbRowset.next()){
 				cntrNo = dbRowset.getString("cntr_no");
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return cntrNo;
    }
    /**
     * InvoiceDetail정보로 interfaceCharge로 조회 합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<InvArIfChgVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInterfaceChargeCreateNoteByInvoiceDetail(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
        List<InvArIfChgVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
           velParam.put("credit_note","Y");
			
           dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL(),param,velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfChgVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
	}    
     
     /**
      * BKG_CONTAINER의 P/O number를 조회한다.<br>
      * 
      * @param String bkgNo
      * @param String cntrNos
      * @return List<String>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<String> searchBookingContainerPONumber(String bkgNo, String cntrNos) throws DAOException {
         DBRowSet dbRowset = null;
         List<String> list = new ArrayList();
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
        	 param.put("s_bkg_no", bkgNo);
             velParam.put("s_bkg_no", bkgNo);
             
             List<String> aryCntrNoList = new ArrayList(); 
             StringTokenizer st = new StringTokenizer(cntrNos, ",");
             String tempS = "";
             
             while (st.hasMoreTokens()) {
                 tempS = st.nextToken(); 
                 aryCntrNoList.add(tempS);
             }
             
        	 param.put("s_cntr_no_list", aryCntrNoList);
             velParam.put("s_cntr_no_list", aryCntrNoList);

             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL(), param, velParam);
             
             while(dbRowset.next()){
            	 list.add(dbRowset.getString("cust_ref_no_ctnt"));
            	 log.debug("-------------cust_ref_no_ctnt---------->"+dbRowset.getString("cust_ref_no_ctnt"));
             }
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }     
     
     /**
      * Cancel, Credit Note 상태인 Invoice 정보를 조회 합니다.<br>
      * 
      * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
      * @return List<InvoiceIssueVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<InvoiceIssueVO> searchInvoiceCancelDetail(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<InvoiceIssueVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(chargeBookingInvoiceVO != null){
                 Map<String, String> mapVO = chargeBookingInvoiceVO .getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }     
     
     /**
      * Issued Invoice(Payer별 Currency에 대한 합계금액) 를 조회 한다.
      * @param IssuedInvoiceParamVO issuedInvoiceParamVO
      * @return List<IssuedInvoiceSumByPayerVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<IssuedInvoiceSumByPayerVO> searchIssuedInvoiceSumByPayer ( IssuedInvoiceParamVO issuedInvoiceParamVO ) throws DAOException {
         DBRowSet dbRowset = null;
         List<IssuedInvoiceSumByPayerVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         StringTokenizer st = null;
         
         try{
             if(issuedInvoiceParamVO != null){
                 //Over Days
                 if(issuedInvoiceParamVO.getSInvOverFm().equals("0") && issuedInvoiceParamVO.getSInvOverTo().equals("0")){
                 	issuedInvoiceParamVO.setSInvOverFm("");
                 	issuedInvoiceParamVO.setSInvOverTo("");
                 }

                 Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
                 
                 //Tariff Type
                 String dmdtTrfCd = (String)issuedInvoiceParamVO.getSDmdtTrfCd();
                 List<String> dmdtTrfCdList = new ArrayList<String>();
                 st = new StringTokenizer(dmdtTrfCd, ",");
                 while (st.hasMoreTokens()) {
                     dmdtTrfCdList.add(st.nextToken());
                 }
                 velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                 
                 //A/R I/F
                 String dmdtArIfCd = (String)issuedInvoiceParamVO.getSDmdtArIfCd();

                 List<String> dmdtArIfCdList = new ArrayList<String>();
                 st = new StringTokenizer(dmdtArIfCd, ",");
                 while (st.hasMoreTokens()) {
                 	String ar_if_cd = st.nextToken();
                    	log.debug("[ar_if_cd]"+ar_if_cd);
                    	if(ar_if_cd.equals("All")) {
                    		dmdtArIfCdList.add("Y");
                    		dmdtArIfCdList.add("N");
                    	}else{
                 	
 	                	if(ar_if_cd.equals("L")) {
 	                		velParam.put("s_ar_if_l_yn", "Y");
 	                	}else{
 	                    	dmdtArIfCdList.add(ar_if_cd);
 	                	}
                    	}
                 }
                 velParam.put("dmdt_ar_if_list", dmdtArIfCdList);
                	velParam.put("ar_if_cnt", dmdtArIfCdList.size());	
                	
                	
                	log.debug("[s_ar_if_l_yn]"+velParam.get("s_ar_if_l_yn"));
                	log.debug("[ar_if_cnt]"+velParam.get("ar_if_cnt"));
                	
                	//s_ofc_cd
                	String ofcCd = issuedInvoiceParamVO.getSIssueOfc();//s_issue_ofc
 				List<String> ofcCdList = new ArrayList<String>();
 				st = new StringTokenizer(ofcCd, ",");
 			    while (st.hasMoreTokens()) {
 			    	String s_ofc_cd = st.nextToken();
                    	log.debug("[s_ofc_cd]"+s_ofc_cd);
 			    	ofcCdList.add(s_ofc_cd);
 			    }
 				velParam.put("ofc_cd_list", ofcCdList);
                 
                 //Invoice Status
                 String dmdtInvStsCd = (String)issuedInvoiceParamVO.getSDmdtInvStsCd();
                 List<String> dmdtInvStsCdList = new ArrayList<String>();
                 st = new StringTokenizer(dmdtInvStsCd, ",");
                 while (st.hasMoreTokens()) {
                 	dmdtInvStsCdList.add(st.nextToken());
                 }
                 velParam.put("dmdt_inv_sts_list", dmdtInvStsCdList);
                 
                 String s_inv_check = (String)issuedInvoiceParamVO.getSInvCheck();
                 
                 log.debug("\n [dao]s_inv_check==>"+s_inv_check);
                 
                 //INV check box
                 if(s_inv_check.equals("Y")) {
                     //Invoice No.
                     String invoiceNo = (String)issuedInvoiceParamVO.getSInvoiceNo();
                     if(!invoiceNo.equals("")) {
                         List<String> invoiceNoList = new ArrayList<String>();
                         st = new StringTokenizer(invoiceNo, ",");
                         while (st.hasMoreTokens()) {
                         	invoiceNoList.add(st.nextToken());
                         }
                         velParam.put("invoice_no_list", invoiceNoList);
                     }
                     
                     //BKG No.
                     String bkgNo = (String)issuedInvoiceParamVO.getSBkgNo();
                     if(!bkgNo.equals("")) {
                         List<String> bkgNoList = new ArrayList<String>();
                         st = new StringTokenizer(bkgNo, ",");
                         while (st.hasMoreTokens()) {
                         	bkgNoList.add(st.nextToken());
                         }
                         velParam.put("bkg_no_list", bkgNoList);
                     }
                     
                     //B/L NO.
                     String blNo = (String)issuedInvoiceParamVO.getSBlNo();
                     if(!blNo.equals("")) {
                         List<String> blNoList = new ArrayList<String>();
                         st = new StringTokenizer(blNo, ",");
                         while (st.hasMoreTokens()) {
                             blNoList.add(st.nextToken());
                         }
                         velParam.put("bl_no_list", blNoList);
                     }
                 }
             }
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssuedInvoiceSumByPayerVO .class);
         } catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     } 
     
     /**
      * BKG BOOKING에서 BL_NO 값을 불러온다.<br>
      * 
      * @param String bkgNo
      * @return String 
      * @throws DAOException
      */
     public String searchBKGBlNo(String bkgNo) throws DAOException {
         DBRowSet dbRowset = null;
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         String bl_no = "";

         try{
             param.put("bkg_no", bkgNo);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBKGBlNoRSQL(), param, velParam);
             
             if(dbRowset.next()){
              	 bl_no = dbRowset.getString("bl_no");
             }
         }catch(SQLException se){
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
         }catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return bl_no;       
     }
     
     /**
      * 인도 GST 관련 Tax rate 조회.<br>
      * @param  String iss_dt 
      * @return SearchIndiaGstRateVO
      * @throws DAOException
      */
     public SearchIndiaGstRateVO searchIndiaGstRate(String iss_dt) throws DAOException {
         DBRowSet dbRowset = null;
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         
         SearchIndiaGstRateVO indiaGstRateVO = new SearchIndiaGstRateVO();

        try{
        	 param.put("iss_dt", iss_dt);
  			 velParam.put("iss_dt", iss_dt);
             dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIndiaGstRateRSQL(), param, velParam);
             
  			if(dbRowset.next()){
  				indiaGstRateVO.setIdaExpnTaxRt(dbRowset.getString("ida_expn_tax_rt"));
  				indiaGstRateVO.setIdaEduTaxRt(dbRowset.getString("ida_edu_tax_rt"));
  				indiaGstRateVO.setIdaHighEduTaxRt(dbRowset.getString("ida_high_edu_tax_rt"));
  				indiaGstRateVO.setTaxRgstNo(dbRowset.getString("tax_rgst_no"));
  				indiaGstRateVO.setSvcCateRmk(dbRowset.getString("svc_cate_rmk"));
  				indiaGstRateVO.setPmntAcctNo(dbRowset.getString("pmnt_acct_no"));
 			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return indiaGstRateVO;
     
     }
     
}