/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtDBDAO.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 繹먲옙源�뉩占�
*@LastVersion : 1.0
* 2009.08.05 繹먲옙源�뉩占�
* 1.0 Creation
* 2010.11.05 繹먲옙源�뉩占�CHM-201006838-01] [EES-DMT] [DMDT] DMDT Invoice占쏙옙Cust Ref 占쎈베��占쎈굝��---  BKG占쏙옙P/O number
* 2010.11.26 繹먲옙源�뉩占�] [EES-DMT] A/R I/F占쏙옙INVOICE CURRECY 占쎈냱��野껋럩��占쎈Ŧ��筌ｌ꼶�곻옙占�
* 2011.03.07 繹먲옙源�뉩占�CHM-201109126-01] [EES-DMT] [DET] DR 占쏙옙�ｆ에占쏙옙紐낅립 Invoice 占쏙옙�ｏ옙占쏙옙怨뺚뀲 Credit Note 占쎌빘苑�占쎈챷��疫꿸퀡��筌욑옙��
* 2011.05.20 繹먲옙源�뉩占폚HM-201110830-01] [DMT] Issued Invoice Inquiry 占쎈뗀��癰귣똻��占쎈뗄猿�
* 2011.08.04 繹먲옙瑗랃옙占폚HM-201112470-01][DMT]Invoice Hold占쏙옙Hold占쏙옙User占쏙옙ID, Office Code, Hold占쏙옙占쎌쥙彛①몴占쏙옙占쎌삢占쎌꼶��嚥≪뮇彛��곕떽占�
* 2011.11.14 亦낉옙  沃섓옙CHM-201114143] [DMT] Manual Invoice with no detail 鈺곌퀗援뷂옙占폩rint Preview 揶쏆뮆而�
* 2012.05.18 繹먲옙�쏙옙占�CHM-201217803] 占쎈챶猷꾬옙占폛MT Invoice format �닌딄쉐 - GST 占쎄낯��
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
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
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailAmountVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceDetailTaxVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceMainAmountVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueParmVO;
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
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListDwVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionTermTitleListUpVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetSetSearchOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS InvoiceIssueCollectionMgtDBDAO <br>
 * - ALPS-InvoiceMgt system Business Logic占쏙옙筌ｌ꼶�곻옙�띾┛ 占쎄쑵釉�JDBC 占쎈쵐毓쏙옙�묐뻬.<br>
 * 
 * @author Kim Tae Kyun
 * @param <ManualInvoiceSummaryVO>
 * @see InvoiceIssueCollectionMgtBCImpl 筌〓챷��
 * @since J2EE 1.6 
 */
public class InvoiceIssueCollectionMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -7176888071346461428L;
	
	private static final String EML_REG_EX = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9._%-]+\\.[a-zA-Z]{2,4}";

	/**
     * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByBookingRSQL(), param, velParam);
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
     * Confirm占쏙옙CNTR 占쎈베�ョ몴占폚NTR No嚥∽옙鈺곌퀬��占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmChargeByContainerRSQL(), param, velParam);
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
     
     
     // -------------- 占썩뫚�싨뉩占�START ----------------
    /**
     * Invoice No.嚥∽옙A/R I/F 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearcARIFFlagRSQL(), param, null);
            
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
     * Invoice Detail 占쎈베�ョ몴占쏙옙�륁젟占쎌뮆��
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * 占쎈���Invoice Rate 占쎈베�ョ몴占쏙옙占쎌젫占쎌뮆��<br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Container Type Size 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchContainerTypeSizeByPartialPaymentRSQL(), param, null);
            
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
     * Invoice Rate 占쎈베�ョ몴占쏙옙�밴쉐占쎌뮆��
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Invoice占쏙옙占쎈���옙�롫뮉 Exchange Rate占쏙옙Tax Rate�쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchExchangeNTaxRateRSQL(), param, null);
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
    // -------------- 占썩뫚�싨뉩占�END ----------------
    
    
    /**
     * Invoice占쏙옙占쎈���옙�롫뮉 Exchange Rate占쏙옙Tax Rate�쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOInvoiceDetailListVORSQL(), param, null);
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
     * Proforma Schedule 占쎈베�ョ몴占쏙옙�밴쉐占썩뫖�뀐옙占�<br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Proforma Schedule 占쎈베�ョ몴占쏙옙�밴쉐占썩뫖�뀐옙占�<br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Invoice Creation & Issue 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchVVDCheckDataRSQL(), param, velParam);
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
     * Invoice Creation & Issue 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceRSQL(), param, velParam);
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
     * Booking Customer 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingCustomerRSQL(), param, velParam);
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
     * Sheet Option 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionRSQL(), param, velParam);
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
     * ARActual Payer 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
     * Invoice 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeBookingInvoiceDetailRSQL(), param, velParam);
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
    * [Outstanding Inquiry by Customer N Issue 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
                StringTokenizer st = null;
                String tempARIFList = (String)otsInquiryParmVO.getArif();
                st = new StringTokenizer(tempARIFList, ",");
                while (st.hasMoreTokens()) {
                	String ar_if_cd = st.nextToken();
                   	log.debug("[ar_if_cd]"+ar_if_cd);
                   	if(ar_if_cd.equals("A")) {
                   		velParam.put("uncollected", "N");
                   		velParam.put("collected", "Y");
                   		velParam.put("hold", "H");
                   		velParam.put("hold_Litigation", "L");
                   		break;
                   	}else{
	                	if(ar_if_cd.equals("L")) {
	                   		velParam.put("hold_Litigation", "L");
	                	}else if(ar_if_cd.equals("H")) {
	                		velParam.put("hold", "H");
	                	}else if(ar_if_cd.equals("N")) {
	                		velParam.put("uncollected", "N");
	                	}else if(ar_if_cd.equals("Y")) {
	                		velParam.put("collected", "Y");
	                	}
                   	}
                }      
                
                velParam.put("tempCUTPList", tempCUTPList);
                velParam.put("tempISOFList", tempISOFList);
                velParam.put("tempTFTPList", tempTFTPList);
                velParam.put("tempARIFList", tempARIFList);
                
            }
            //E-mail 정규식 검사용 파라미터 추가
            param.put("reg_ex", EML_REG_EX);

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryListRSQL(), param, velParam);
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
     * [Outstanding Inquiry by Customer N Issue for Sales Rep]을 조회합니다.<br>
     * 
     * @param OtsInquiryParm2VO otsInquiryParm2VO
     * @return List<OtsInquiryBySummaryVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<OtsInquiryBySummaryVO> searchOTSInquiryBySummaryList2 ( OtsInquiryParm2VO otsInquiryParm2VO ) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<OtsInquiryBySummaryVO> list = null;
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();
    	
    	try{
    		if(otsInquiryParm2VO != null){
    			Map<String, String> mapVO = otsInquiryParm2VO.getColumnValues();
    			
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			
    			log.debug("################### 4009 Cuno [" + otsInquiryParm2VO.getCuno2() + "]");
    			log.debug("################### 4009 Cutp [" + otsInquiryParm2VO.getCutp() + "]");
    			log.debug("################### 4009 Frdt [" + otsInquiryParm2VO.getFrdt2() + "]");
    			log.debug("################### 4009 Ctof [" + otsInquiryParm2VO.getCtof() + "]");
    			log.debug("################### 4009 Isof [" + otsInquiryParm2VO.getIsof() + "]");
    			log.debug("################### 4009 Rfan [" + otsInquiryParm2VO.getRfan2() + "]");
    			log.debug("################### 4009 Scno [" + otsInquiryParm2VO.getScno2() + "]");
    			log.debug("################### 4009 Tano [" + otsInquiryParm2VO.getTaano() + "]");
    			log.debug("################### 4009 Tftp [" + otsInquiryParm2VO.getTftp() + "]");
    			log.debug("################### 4009 Todt [" + otsInquiryParm2VO.getTodt2() + "]");
    			log.debug("################### 4009 Arif [" + otsInquiryParm2VO.getArif() + "]");
    			log.debug("################### 4009 Cude [" + otsInquiryParm2VO.getCude2() + "]");
    			log.debug("################### 4009 Payc [" + otsInquiryParm2VO.getPayc2() + "]");
    			log.debug("################### 4009 Payn [" + otsInquiryParm2VO.getPayn2() + "]");      
    			log.debug("################### 4009 gropCust [" + otsInquiryParm2VO.getGropCust() + "]");      
    			log.debug("################### 4009 ctrtCust [" + otsInquiryParm2VO.getCtrtCust() + "]");          
    			
    			String tempCUTP = (String)otsInquiryParm2VO.getCutp();
    			List<String> tempCUTPList = new ArrayList<String>();
    			
    			StringTokenizer st1 = new StringTokenizer(tempCUTP, ",");
    			while (st1.hasMoreTokens()) {
    				tempCUTPList.add(st1.nextToken());
    			}
    			
    			/*----------------------------------------------------------------------------------------*/                
    			
    			String tempCTOF = (String)otsInquiryParm2VO.getCtof();
    			List<String> tempCTOFList = new ArrayList<String>();
    			
    			StringTokenizer st2 = new StringTokenizer(tempCTOF, ",");
    			while (st2.hasMoreTokens()) {
    				tempCTOFList.add(st2.nextToken());
    			}
    			
    			/*----------------------------------------------------------------------------------------*/                
    			
    			String tempISOF = (String)otsInquiryParm2VO.getIsof();
    			List<String> tempISOFList = new ArrayList<String>();
    			
    			StringTokenizer st4 = new StringTokenizer(tempISOF, ",");
    			while (st4.hasMoreTokens()) {
    				tempISOFList.add(st4.nextToken());
    			}
    			
    			/*----------------------------------------------------------------------------------------*/
    			
    			String tempTFTP = (String)otsInquiryParm2VO.getTftp();
    			List<String> tempTFTPList = new ArrayList<String>();
    			
    			StringTokenizer st3 = new StringTokenizer(tempTFTP, ",");
    			while (st3.hasMoreTokens()) {
    				tempTFTPList.add(st3.nextToken());
    			}
    			
    			/*----------------------------------------------------------------------------------------*/
    			StringTokenizer st = null;
    			String tempARIFList = (String)otsInquiryParm2VO.getArif();
    			st = new StringTokenizer(tempARIFList, ",");
    			while (st.hasMoreTokens()) {
    				String ar_if_cd = st.nextToken();
    				log.debug("[ar_if_cd]"+ar_if_cd);
    				if(ar_if_cd.equals("A")) {
    					velParam.put("uncollected", "N");
    					velParam.put("collected", "Y");
    					velParam.put("hold", "H");
    					velParam.put("hold_Litigation", "L");
    					break;
    				}else{
    					if(ar_if_cd.equals("L")) {
    						velParam.put("hold_Litigation", "L");
    					}else if(ar_if_cd.equals("H")) {
    						velParam.put("hold", "H");
    					}else if(ar_if_cd.equals("N")) {
    						velParam.put("uncollected", "N");
    					}else if(ar_if_cd.equals("Y")) {
    						velParam.put("collected", "Y");
    					}
    				}
    			}
    			
    			if(!otsInquiryParm2VO.getScno2().equals("")) {
    				String scNo = otsInquiryParm2VO.getScno2();
        			List<String> scNoList = new ArrayList<String>();
        			st = new StringTokenizer(scNo, ",");
        			while (st.hasMoreTokens()) {
        				scNoList.add(st.nextToken());
        			}
        			velParam.put("scNoList", scNoList);
    			}    			
    			if(!otsInquiryParm2VO.getRfan2().equals("")) {
    				String rfaNo = otsInquiryParm2VO.getRfan2();
    				List<String> rfaNoList = new ArrayList<String>();
    				st = new StringTokenizer(rfaNo, ",");
    				while (st.hasMoreTokens()) {
    					rfaNoList.add(st.nextToken());
    				}
    				velParam.put("rfaNoList", rfaNoList);
    			}
    			if(!otsInquiryParm2VO.getTaano().equals("")) {
    				String taaNo = otsInquiryParm2VO.getTaano();
    				List<String> taaNoList = new ArrayList<String>();
    				st = new StringTokenizer(taaNo, ",");
    				while (st.hasMoreTokens()) {
    					taaNoList.add(st.nextToken());
    				}
    				velParam.put("taaNoList", taaNoList);
    			}    			
    			velParam.put("tempCUTPList", tempCUTPList);
    			velParam.put("tempCTOFList", tempCTOFList);
    			velParam.put("tempISOFList", tempISOFList);
    			velParam.put("tempTFTPList", tempTFTPList);
    			velParam.put("tempARIFList", tempARIFList);
    			
    		}
    		//E-mail 정규식 검사용 파라미터 추가
    		param.put("reg_ex", EML_REG_EX);
    		
    		dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryBySummaryList2RSQL(), param, velParam);
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
     * [InvoiceMain] 占쎈베�ョ몴占�占쏙옙�� 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * [InvoiceDetail] 占쎈베�ョ몴占�占쏙옙�� 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * [InvoiceRate] 占쎈베�ョ몴占�占쏙옙�� 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * [TAB1:A/R Interface Status Inquiry By DMT]占쏙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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

 				 //PAYER CODE占쏙옙6占쎈Ŧ��8占쎈Ŧ�곭몴占썸뤃��뉛옙�곴퐣 筌ｌ꼶��
 				 int custLen = arInterfaceParmVO.getCustCd().length();				
 				 velParam.put("cust_len", custLen);
 				 StringTokenizer st = null;
 				 
                 String ofcCd = arInterfaceParmVO.getOfcCd();
                 List<String> ofcCdList = new ArrayList<String>();
                 st = new StringTokenizer(ofcCd, ",");
                 while (st.hasMoreTokens()) {
                     ofcCdList.add(st.nextToken());
                 }
                 velParam.put("ofc_cd_list", ofcCdList);
                 
                 String trfCd = arInterfaceParmVO.getDmdtTrfCdT1();
                 List<String> trfCdList = new ArrayList<String>();
                 st = new StringTokenizer(trfCd, ",");
                 while (st.hasMoreTokens()) {
                     trfCdList.add(st.nextToken());
                 }
                 velParam.put("trf_cd_list", trfCdList);
                 
                 // 2015-06-04 s_inv_no 조건 추가
                 String sInvNo = arInterfaceParmVO.getSInvoiceNo();
                 List<String> sInvNoList = new ArrayList<String>();
                 st = new StringTokenizer(sInvNo, ",");
                 while (st.hasMoreTokens()) {
                	 sInvNoList.add(st.nextToken());
                 }
                 velParam.put("s_invoice_no_list", sInvNoList);
                 
                 // 2015-06-04 s_bkg_no 조건 추가
                 String sBkgNo = arInterfaceParmVO.getSBkgNo();
                 List<String> sBkgNoList = new ArrayList<String>();
                 st = new StringTokenizer(sBkgNo, ",");
                 while (st.hasMoreTokens()) {
                	 sBkgNoList.add(st.nextToken());
                 }
                 velParam.put("s_bkg_no_list", sBkgNoList);
                 
             }
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByDMTRSQL(), param, velParam);
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
      * [TAB2:A/R Interface Status Inquiry By BKG]占쏙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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
              
  				  //ACT_CUST CODE占쏙옙6占쎈Ŧ��8占쎈Ŧ�곭몴占썸뤃��뉛옙�곴퐣 筌ｌ꼶��
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
    * [Invoice Interface to A/R]占쏙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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

				//PAYER CODE占쏙옙6占쎈Ŧ��8占쎈Ŧ�곭몴占썸뤃��뉛옙�곴퐣 筌ｌ꼶��
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARBySummaryRSQL(), param, velParam);
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
     * [Invoice Interface to A/R - Detail]占쏙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceInterfaceARByDetailRSQL(), param, velParam);
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
                log.debug("####### 4011 Ctof [" + otsInquiryParmVO.getCtof() + "]");
                log.debug("####### 4011 Rfan [" + otsInquiryParmVO.getRfan() + "]");
                log.debug("####### 4011 Scno [" + otsInquiryParmVO.getScno() + "]");
                log.debug("####### 4011 Taano [" + otsInquiryParmVO.getTaano() + "]");
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
                
                String tempCTOF = (String)otsInquiryParmVO.getCtof();
                List<String> tempCTOFList = new ArrayList<String>();
                
                StringTokenizer st4 = new StringTokenizer(tempCTOF, ",");
                while (st4.hasMoreTokens()) {
                	tempCTOFList.add(st4.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                
                String tempTFTP = (String)otsInquiryParmVO.getTftp();
                List<String> tempTFTPList = new ArrayList<String>();
                
                StringTokenizer st3 = new StringTokenizer(tempTFTP, ",");
                while (st3.hasMoreTokens()) {
                    tempTFTPList.add(st3.nextToken());
                }
                
/*----------------------------------------------------------------------------------------*/
                StringTokenizer st = null;
                String tempARIFList = (String)otsInquiryParmVO.getArif();
                st = new StringTokenizer(tempARIFList, ",");
                while (st.hasMoreTokens()) {
                	String ar_if_cd = st.nextToken();
                   	log.debug("[ar_if_cd]"+ar_if_cd);
                   	if(ar_if_cd.equals("All")) {
                   		velParam.put("uncollected", "N");
                   		velParam.put("collected", "Y");
                   		velParam.put("hold", "H");
                   		velParam.put("hold_Litigation", "L");
                   		break;
                   	} else if(ar_if_cd.equals("A")) {
                       		velParam.put("uncollected", "N");
                       		velParam.put("collected", "Y");
                       		break;
                   	}else{
	                	if(ar_if_cd.equals("L")) {
	                   		velParam.put("hold_Litigation", "L");
	                	}else if(ar_if_cd.equals("H")) {
	                		velParam.put("hold", "H");
	                	}else if(ar_if_cd.equals("N")) {
	                		velParam.put("uncollected", "N");
	                	}else if(ar_if_cd.equals("Y")) {
	                		velParam.put("collected", "Y");
	                	}
                   	}
                }    
                
/*----------------------------------------------------------------------------------------*/

    			if(!otsInquiryParmVO.getScno().equals("")) {
    				String scNo = otsInquiryParmVO.getScno();
        			List<String> scNoList = new ArrayList<String>();
        			st = new StringTokenizer(scNo, ",");
        			while (st.hasMoreTokens()) {
        				scNoList.add(st.nextToken());
        			}
        			velParam.put("scNoList", scNoList);
    			}    			
    			if(!otsInquiryParmVO.getRfan().equals("")) {
    				String rfaNo = otsInquiryParmVO.getRfan();
    				List<String> rfaNoList = new ArrayList<String>();
    				st = new StringTokenizer(rfaNo, ",");
    				while (st.hasMoreTokens()) {
    					rfaNoList.add(st.nextToken());
    				}
    				velParam.put("rfaNoList", rfaNoList);
    			}
    			if(!otsInquiryParmVO.getTaano().equals("")) {
    				String taaNo = otsInquiryParmVO.getTaano();
    				List<String> taaNoList = new ArrayList<String>();
    				st = new StringTokenizer(taaNo, ",");
    				while (st.hasMoreTokens()) {
    					taaNoList.add(st.nextToken());
    				}
    				velParam.put("taaNoList", taaNoList);
    			}    			
                
/*----------------------------------------------------------------------------------------*/

                velParam.put("tempCUTPList", tempCUTPList);
                velParam.put("tempISOFList", tempISOFList);
                velParam.put("tempCTOFList", tempCTOFList);
                velParam.put("tempTFTPList", tempTFTPList);
                velParam.put("tempARIFList", tempARIFList);        

/*----------------------------------------------------------------------------------------*/

                            
	            if(otsInquiryParmVO != null && otsInquiryParmVO.getCtrtFlg() != null && otsInquiryParmVO.getCtrtFlg().equals("Y")) { 
	            	// for Srep
	            	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListForSrepRSQL(), param, velParam);
	            } else { 
	            	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRSQL(), param, velParam);
	            }
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, OtsInquiryByDetialVO .class);
        	}
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList2RSQL(), param, velParam);
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            if(otsInquiryParmVO != null && otsInquiryParmVO.getPayc() != null && !"".equals(otsInquiryParmVO.getPayc())){
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

            
	            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemarkRSQL(), param, velParam);
	            while(dbRowset.next()){
	                rtnRemark = dbRowset.getString(1);
	            }
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListRemark2RSQL(), param, velParam);
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK] 占쎈베�ョ몴占�UPDATE] 占썩뫖�뀐옙占�br>
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
             
             SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
      * Virtual Invoice Creation & Issue 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�Invoice Cancel 占쏙옙Virtual Invoice 占쎌빘苑�占쏙옙<br>
      * 
      * @param IssuedInvoiceParamVO issuedInvoiceParamVO
      * @return ChargeBookingInvoiceVO
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public ChargeBookingInvoiceVO searchBookingVtInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<ChargeBookingInvoiceVO> list = new ArrayList<ChargeBookingInvoiceVO>();
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
     
         try {
             if (issuedInvoiceParamVO != null){
                 Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingVtInvoiceRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingInvoiceVO.class);
         } 
         catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } 
         catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list != null && list.size() > 0 ? list.get(0) : null;
     } 
     
    /**
     * Invoice Creation & Issue 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�Invoice Issue 占쏙옙<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ChargeBookingInvoiceVO searchBookingInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ChargeBookingInvoiceVO> list = new ArrayList<ChargeBookingInvoiceVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try {
            if (issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingInvoiceRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingInvoiceVO.class);
        } 
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list != null && list.size() > 0 ? list.get(0) : null;
    }    

    /**
     * Invoice 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailRSQL(), param, velParam);
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
     * max InvoiceNo�쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOMakeInvoiceNoRSQL(), param, velParam);
            
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
     * ar_ofc_cd �쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchAROfficeCdRSQL(), param, velParam);
            
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
     * max Invoie Detail 占쏙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOMakeInvoiceDtlSeqRSQL(), param, velParam);
            
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
     * INVOICE 占쎈베�ョ몴占쏙옙�륁젟占쎌뮆��<br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Remark(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceRemarkRSQL(), param, velParam);
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
    * [Remark(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSRemarkRSQL(), param, velParam);
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
    * [Remark(s)] 占쎈베�ョ몴占�UPDATE] 占썩뫖�뀐옙占�br>
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
             SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Remark(s)] 占쎈베�ョ몴占�UPDATE] 占썩뫖�뀐옙占�br>
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
             SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
      * Office癰귨옙Tax Ratio 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEnvironmentByOfficeRSQL(), param, velParam);
             
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
      * After Booking 占쎈��ㅿ옙占썸�袁⑷텦占쏙옙占쎌꼹六억옙占쏙옙占폠nvoice 占쎈베�ョ몴占썲첎源녿뻿占쎌뮆��<br>
      * 
      * @param String darNo
      * @throws DAOException
      */
	public void modifyInvoiceAdjustAmount(String darNo) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();

         try{
                param.put("aft_expt_dar_no", darNo);
                
                new SQLExecuter("DMT_HJSBAT").executeUpdate((ISQLTemplate)
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
    * [Sheet Option] 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionUpRSQL(), param, velParam);
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
    * [Sheet Option] 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionDwRSQL(), param, velParam);
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
    * [Sheet Option] 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetOptionInfoRSQL(), param, velParam);
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
     * [Sheep Option] 占쎈베�ョ몴占�DELETE] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Option] 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Setting Screen] 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchSheetSetRSQL(), param, velParam);
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
    * [Sheet Setting Screen] 占쎈베�ョ몴占�DELETE/INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
    * [Sheet Setting Screen] 占쎈베�ョ몴占�DELETE/INSERT] 占썩뫖�뀐옙占�br>
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * ISSUED 占쎄낱源�옙占폚ontainter 鈺곌퀬��
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchContainerNoRSQL(), param, null);
            
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
    * [Manual Invoice Report by Office 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceBySummaryListRSQL(), param, velParam);
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
    * [Manual Invoice Report by Office 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchManualInvoiceByDetailListRSQL(), param, velParam);
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
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
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

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailList3RSQL(), param, velParam);
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
     * ofc_cd 占쎄퀣�좑옙占쏙쭗�ㅻ쑞占쏙옙占쎈���옙�롫뮉 inv_pfx_cd 揶쏅����븍뜄��옙�ㅻ뼄.<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvPfxCdRSQL(), param, velParam);
            
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
     * Issued Invoice �쒙옙鈺곌퀬��占쎌뮆��
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<IssuedInvoiceListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<IssuedInvoiceListVO> searchIssuedInvoiceList(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<IssuedInvoiceListVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        StringTokenizer st = null;
        
        try{
            if (issuedInvoiceParamVO != null) {
                //Over Days
                if (issuedInvoiceParamVO.getSInvOverFm().equals("0") && issuedInvoiceParamVO.getSInvOverTo().equals("0")){
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

                st = new StringTokenizer(dmdtArIfCd, ",");
                while (st.hasMoreTokens()) {
                	String ar_if_cd = st.nextToken();
                   	log.debug("[ar_if_cd]"+ar_if_cd);
                   	if (ar_if_cd.equals("All")) {
                   		velParam.put("uncollected", "N");
                   		velParam.put("collected", "Y");
                   		velParam.put("hold", "H");
                   		velParam.put("hold_Litigation", "L");
                   		break;
                   	} 
                   	else if (ar_if_cd.equals("A")) {
                       		velParam.put("uncollected", "N");
                       		velParam.put("collected", "Y");
                       		break;
                   	}
                   	else {
	                	if (ar_if_cd.equals("L")) {
	                   		velParam.put("hold_Litigation", "L");
	                	}
	                	else if (ar_if_cd.equals("H")) {
	                		velParam.put("hold", "H");
	                	}
	                	else if (ar_if_cd.equals("N")) {
	                		velParam.put("uncollected", "N");
	                	}
	                	else if (ar_if_cd.equals("Y")) {
	                		velParam.put("collected", "Y");
	                	}
                   	}
                }
               	
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
                if (s_inv_check.equals("Y")) {
                    //Invoice No.
                    String invoiceNo = (String)issuedInvoiceParamVO.getSInvoiceNo();
                    if (!invoiceNo.equals("")) {
                        List<String> invoiceNoList = new ArrayList<String>();
                        st = new StringTokenizer(invoiceNo, ",");
                        while (st.hasMoreTokens()) {
                        	invoiceNoList.add(st.nextToken());
                        }
                        velParam.put("invoice_no_list", invoiceNoList);
                    }
                    
                    //BKG No.
                    String bkgNo = (String)issuedInvoiceParamVO.getSBkgNo();
                    if (!StringUtils.isEmpty(bkgNo)) {
                        List<String> bkgNoList = new ArrayList<String>();
                        st = new StringTokenizer(bkgNo, ",");
                        while (st.hasMoreTokens()) {
                        	bkgNoList.add(st.nextToken());
                        }
                        velParam.put("bkg_no_list", bkgNoList);
                    }
                    
                    //B/L NO.
                    String blNo = (String)issuedInvoiceParamVO.getSBlNo();
                    if (!StringUtils.isEmpty(blNo)) {
                        List<String> blNoList = new ArrayList<String>();
                        st = new StringTokenizer(blNo, ",");
                        while (st.hasMoreTokens()) {
                            blNoList.add(st.nextToken());
                        }
                        velParam.put("bl_no_list", blNoList);
                    }
                }
            }
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, IssuedInvoiceListVO .class);
        } 
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }     
    
    
    /**
    * [Manual Invoice Report by Office] 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
    * 
    * @return String
    * @throws DAOException
    */
    @SuppressWarnings("null")
	public String searchManualInvoiceReasonList() throws DAOException {
        DBRowSet dbRowset = null;
        StringBuffer reasoncd = new StringBuffer();

        try{
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchManualInvoiceReasonListRSQL(),null,null);
            while(dbRowset.next()){
                reasoncd.append(dbRowset.getString(1)).append("^");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }

        return reasoncd.toString();
    }
    
    /**
     * 筌�쑬苡뀐옙��뵠�됰뗄肉�invoice no�쒙옙占쏙옙�ｏ옙�뺣뼄.(占쎌쥒��
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * 筌�쑬苡뀐옙��뵠�됰뗄肉�invoice no�쒙옙揶쏄퉮�딉옙�뺣뼄.(�곕떽占�
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
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * 筌�쑬苡뀐옙��뵠�됰뗄��max揶쏅���鈺곌퀬�띰옙�뺣뼄.
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchMaxInvoiceSeqRSQL(), param, velParam);

			if(dbRowset.next()){
				dmt_inv_seq = dbRowset.getString("dmdt_inv_seq");
			} else {
				dmt_inv_seq = "1";
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
     * [Invoice Create & Issue]占쏙옙[Invoice Mn Retrieve] 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Create & Issue]占쏙옙[Invoice Detail Retrieve] 占썩뫖�뀐옙占�br>
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
 				
 				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Create & Issue]占쏙옙[Invoice Rate Retrieve] 占썩뫖�뀐옙占�br>
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
 				
 				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Create & Issue]占쏙옙[Invoice Booking Customer Retrieve] 占썩뫖�뀐옙占�br>
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
 				
 				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Create & Issue]占쏙옙[Invoice Booking Customer Retrieve] 占썩뫖�뀐옙占�br>
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
 				
 				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
     * [Invoice Create & Issue]占쏙옙[Booking Retrieve] 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
     * [Invoice Create & Issue]占쏙옙[Booking Retrieve] 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
     * [Invoice Create & Issue]占쏙옙[Charge Retrieve] 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Cancel Reason]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [VVD CD. Calling Port]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
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
             
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [VVD CD. 揶쏉옙鈺곕똻�깍옙�롫뮉筌욑옙�쒙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
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
             
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
      * [Invoice Cancel Reason]占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
      * 
      * @return List<DmtCommonReturnDataVO>
      * @throws DAOException
      */
	 @SuppressWarnings("unchecked") 
	 public List<DmtCommonReturnDataVO> searchCancelReason() throws DAOException {
         DBRowSet dbRowset = null;
         List<DmtCommonReturnDataVO> list = null;
         try {
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCancelReasonRSQL(),null,null);
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
    * [Hold Reason Entry]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
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
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchHoldReasonRSQL(), param, null);
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
    * [Hold Reason Entry]占쏙옙[SEARCH] 占썩뫖�뀐옙占�br>
    * 
    * @return List<DmtCommonReturnDataVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")    
    public List<DmtCommonReturnDataVO> searchHoldReasonCdList() throws DAOException {
        DBRowSet dbRowset = null;
        List<DmtCommonReturnDataVO> list = null;
        try {
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchHoldReasonCdListRSQL(),null,null);
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
    * [Hold Reason Entry] 占쎈베�ョ몴占�UPDATE] 占썩뫖�뀐옙占�br>
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
            
            param.put( "inv_hld_usr_id" , account.getUsr_id() );
            param.put( "inv_hld_ofc_cd" , account.getOfc_cd() );                
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	  * [Minus Invoice Creation ]�쒙옙[占쏙옙��占썩뫖�뀐옙占�br>
	  * minus charge invoice creation(to new invoice no)
	  * @param DmtInvMnVO dmtInvMnVO
	  * @throws DAOException
	  */
	 public void addCreditInvoiceMain(DmtInvMnVO dmtInvMnVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
		    Map<String, String> mapVO = dmtInvMnVO.getColumnValues();
		    param.putAll(mapVO);
		    velParam.putAll(mapVO);
		    
		    SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
		    int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddCreditInvoiceMainCSQL(), param, velParam);
		    if(result == Statement.EXECUTE_FAILED)
		        throw new DAOException("Fail to addCreditInvoiceMain SQL");
		} 
		catch (SQLException se) {
		    log.error(se.getMessage(),se);
		    throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
		    log.error(ex.getMessage(),ex);
		    throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 
	}
	
	
	/**
	 * [Minus Invoice Creation ]�쒙옙[占쏙옙��占썩뫖�뀐옙占�br>
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
		    
		    SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * [Minus Invoice Creation ]�쒙옙[占쏙옙��占썩뫖�뀐옙占�br>
	 * Charge 筌랃옙(-)嚥∽옙占쎈똻占쏙옙占�
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
		    
		    SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	  * [Invoice ARIF Check]�쒙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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
			 dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckARIFRSQL(),param,null);
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
	  * [Invoice Create Check]�쒙옙[鈺곌퀬��占썩뫖�뀐옙占�br>
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
 			 dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckCreditInvoiceRSQL(),param,null);
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
	  * [Invoice Cancel 占쎄낱源��쒙옙[占쎌꼷��占썩뫖�뀐옙占�br>
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
	            
	            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
      * [Invoice 占쎈베�ワ옙占쏙옙占쎈립 charge 占쎈베��占쏙옙[鈺곌퀬�� 占썩뫖�뀐옙占�br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceChargeRSQL(),param,null);
				
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
    * [ Fax/E-mail Sending History ] 占쎈베�ョ몴占�SEARCH] 占썩뫖�뀐옙占�br>
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

	            // >>. 鈺곌퀬�띈�怨뚭탷 Date �쒙옙占쎌쥚源�옙占썲칰�뚯뒭
	            if ("0".equals(dmtFaxEmlSndHisParmVO.getSeloptt())) {
	           		dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByDateRSQL(), param, velParam);
	             }
	            // >>. 鈺곌퀬�띈�怨뚭탷 Invoice �쒙옙占쎌쥚源�옙占썲칰�뚯뒭            
	            else if ("1".equals(dmtFaxEmlSndHisParmVO.getSeloptt())) {
	            	// >>. 占쎌빘毓쏙옙占썲칰�뚯뒭占쎈Ŧ彛�揶쏉옙nv. 占쎄퀗占�占쎄쑴�싷옙袁れ넺占쏙옙鈺곌퀬�띰옙�뺣뼄.
	            	if ("Y".equals(dmtFaxEmlSndHisParmVO.getPopupYn())) {
	            		dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceRSQL(), param, velParam);
	            	}
	            	else {
	            		dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByInvoiceMainRSQL(), param, velParam);
	            	}
	            }
	            // >>. 鈺곌퀬�띈�怨뚭탷 Demand / OTS �쒙옙占쎌쥚源�옙占썲칰�뚯뒭         
	            else if ("2".equals(dmtFaxEmlSndHisParmVO.getSeloptt())) {
	            	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFaxEmailHistoryByPayerRSQL(), param, velParam);	
	            }
	            
	            list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtFaxEmlSndHisVO .class);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
	/**
	 * 占썬끆援뷂옙占폚harge 占쎈베�ョ몴占�Remove] 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void removeInvoiceDetail(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * 占썬끆援뷂옙占폫ate 占쎈베�ョ몴占�Remove] 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvRtVO> dmtInvRtVOs
	 * @throws DAOException
	 */
	public void removeInvoiceRate(List<DmtInvRtVO> dmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * 占썬끆援뷂옙占폚harge 占쎈베�ョ몴占�占쏙옙�� 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void addInvoiceDetailByManual(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * 占썬끆援뷂옙占폫ate 占쎈베�ョ몴占�占쏙옙�� 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvRtVO> dmtInvRtVOs
	 * @throws DAOException
	 */
	public void addInvoiceRateByManual(List<DmtInvRtVO> dmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * 占썬끆援뷂옙占폚harge 占쎈베�ョ몴占�占쎌꼷�� 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvDtlVO> dmtInvDtlVOs
	 * @throws DAOException
	 */
	public void modifyInvoiceDetail(List<DmtInvDtlVO> dmtInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * 占썬끆援뷂옙占폫ate 占쎈베�ョ몴占�占쎌꼷�� 占썩뫖�뀐옙占�br>
	 * 
	 * @param List<DmtInvRtVO> dDmtInvRtVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyInvoiceRate(List<DmtInvRtVO> dDmtInvRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * VVD 占쏙옙�⑤벏�삼옙占쎄컧 占쎈벡�뉛옙�곗쨮 占싼딆뒠占쏙옙占쎌쥙彛�YYMM) 占쏙옙�닌뗫�占쎈뜄��<br>
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
				
				dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)
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
	 * Payer Contact Point 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param String ofcCd
	 * @param String custCd
	 * @param String custGubun
	 * @param String svrId
	 * @return List<DmtPayrCntcPntVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<DmtPayrCntcPntVO> searchPayerContactPoint(String ofcCd, String custCd, String custGubun, String svrId) throws DAOException, Exception {
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
			param.put("svr_id", svrId);
			
			velParam.put("s_ofc_cd", ofcCd);
			velParam.put("s_cust_cd", custCd);
			velParam.put("s_cust_gubun", custGubun);
			velParam.put("svr_id", svrId);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointRSQL(),param,velParam);
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
	 * Payer Contact Point 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointMdmRSQL(),param,velParam);
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
	 * Payer 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String payrYn
	 * @param String sCustGubun
	 * @param String svrId
	 * @return DmtPayrInfoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public DmtPayrInfoVO searchPayerInformation(String sOfcCd, String sCustCd, String payrYn, String sCustGubun, String svrId) throws DAOException,Exception {
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
			param.put("svr_id"			, svrId);
			
			velParam.put("s_ofc_cd"		, sOfcCd);
			velParam.put("s_cust_cd"	, sCustCd);
			velParam.put("payr_yn"		, payrYn);
			velParam.put("s_cust_gubun"	, sCustGubun);
			velParam.put("svr_id"		, svrId);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerInformationRSQL(),param,velParam);
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
				dmtPayInfoVO.setSndCycCd(dbRowset.getString("snd_cyc_cd"));
				dmtPayInfoVO.setOtsShGrpCd(dbRowset.getString("ots_sh_grp_cd"));
				dmtPayInfoVO.setSndCntrListFlg(dbRowset.getString("snd_cntr_list_flg"));
				dmtPayInfoVO.setSndInvFlg(dbRowset.getString("snd_inv_flg"));
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
	 * Payer Name 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerNameRSQL(),param,velParam);
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
	 * Payer Address 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerAddressRSQL(),param,velParam);
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
	 * Payer Contact Point 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerContactPointNameRSQL(),param,velParam);
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
	 * Payer Phone No 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerPhoneNoRSQL(),param,velParam);
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
	 * Payer Fax No 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerFaxNoRSQL(),param,velParam);
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
	 * Payer Email 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerEmailRSQL(),param,velParam);
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
	 * Payer Info 鈺곕똻�깍옙�占썹몴占썼�怨좎돳占쎌뮆��<br>
	 * 
	 * @param String sOfcCd
	 * @param String sCustCd
	 * @param String vndrFlg
	 * @param String svrId
	 * @return String
	 * @throws DAOException
	 */
	public String checkPayerInfo(String sOfcCd, String  sCustCd, String vndrFlg, String svrId) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        String payr_yn = "";
		try {
			param.put("s_ofc_cd"	, sOfcCd);
			param.put("s_cust_cd"	, sCustCd);
			param.put("svr_id"		, svrId);
			velParam.put("s_ofc_cd"	, sOfcCd);
			velParam.put("s_cust_cd", sCustCd);
			velParam.put("s_vndr_flg", vndrFlg);
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckPayerInfoRSQL(),param,velParam);
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
	 * PAYER INFO 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * PAYER INFO 占쎈베�ョ몴占�MODIFY] 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * Payer Contact Point 鈺곕똻�깍옙�占썹몴占썼�怨좎돳占쎌뮆��<br>
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
		
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckPayerContactPointRSQL(),param,velParam);
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
	 * PAYER CONTACT POINT 占쎈베�ョ몴占�INSERT] 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * PAYER CONTACT POINT 占쎈베�ョ몴占�MODIFY] 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
	 * PAYER CONTACT POINT 占쎈베�ョ몴占�DELETE] 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
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
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceInvoiceRSQL(),param,null);
            
            if(dbRowset.next()) {
            	//invArIfMnVO.setBlNo(dbRowset.getString("bl_no"));
            	//invArIfMnVO.setBlSrcNo(dbRowset.getString("bl_src_no"));	//占쎈슣�わ옙占쏙옙占썼퉪占쎄펾占쎈뗄猿뚳옙�곸뒠(INV_AR_IF_MN占쏙옙BL_NO�쒙옙BL_SRC_NO占쏙옙占쏙퐡��BL_NO占쏙옙null嚥∽옙占쏙옙) 
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
            	// 2010-08-11 �곕떽占�
            	invArIfMnVO.setDestTrnsSvcModCd(dbRowset.getString("dest_trns_svc_mod_cd"));
            	// 2015-06-01
            	invArIfMnVO.setCrInvNo(dbRowset.getString("cr_inv_no"));
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
      * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
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
 			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeRSQL(),param,null);
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
       * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
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
  			
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceContainerRSQL(),param,null);
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
     * ARIF�쒙옙UPDATE占쎌뮆��
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * CHARGE CALCULATE占쏙옙占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.
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
  			
  			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeCalculationRSQL(),param,null);
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
     * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
     * @param String arOfcCd
     * @param String invoiceNo
     * @param String chgSeq
     * @param String creOfcCd
     * @param String chgFlg
     * @return InvArIfChgVO
     * @throws DAOException
     */
	public InvArIfChgVO searchInterfaceTaxAmt(String arOfcCd, String invoiceNo, String chgSeq, String creOfcCd, String chgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		InvArIfChgVO invArIfChgVO = new InvArIfChgVO();
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("ar_ofc_cd", arOfcCd);
			param.put("invoice_no", invoiceNo);
			param.put("chg_seq", chgSeq);
			param.put("cre_ofc_cd", creOfcCd);
			param.put("chg_flg", chgFlg);
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceTaxAmtRSQL(),param,null);
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
				invArIfChgVO.setSbcFlg(StringUtils.defaultString(dbRowset.getString("sbc_flg")));
				invArIfChgVO.setKkcFlg(StringUtils.defaultString(dbRowset.getString("kkc_flg")));
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
	 * INVOICE DETAIL占쏙옙占쎄퀣�좑옙怨뚳옙 鈺곕똻�깍옙�롫뮉筌욑옙鈺곌퀬�띰옙�뺣뼄.
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
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckDmtInvDtlRSQL(),param,null);
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
	 * MANUAL INVOICE�쒙옙占쎌꼷�숋옙�뺣뼄.
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * Manual Detail占쏙옙鈺곕똻�깍옙�륅옙 占쎈봿�ｏ옙占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualChargeRSQL(),param,null);
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
        	   invArIfChgVO.setSbcFlg(StringUtils.defaultString(dbRowset.getString("sbc_flg")));
			   invArIfChgVO.setKkcFlg(StringUtils.defaultString(dbRowset.getString("kkc_flg")));
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
     * Manual Detail占쏙옙鈺곕똻�깍옙�륅옙 占쎈봿�ｏ옙占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceManualContainerRSQL(),param,null);
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
     * Bkg癰귨옙cntr 揶쏉옙�붺몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingContainerCountRSQL(), param, velParam);
		
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
     * Payer癰귨옙fax甕곕뜇�뉒몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchFAXByPayerRSQL(),param,velParam);
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
     * Payer癰귨옙email雅뚯눘�쇘몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEmailByPayerRSQL(),param,velParam);
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
     * Group Invoice, Invoice No占쏙옙占쏙옙釉�Detail占썩뫕�롦묾�됰만占쏙옙UPDATE 占썩뫖�뀐옙占�br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
     * INVOICE RD占쏙옙MASTER 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.
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

        	   // 인도 TAX RATIO 변경 전 >==========================================================================================
        	   double ida_expn_tax= 0;
        	   double ida_edu_tax= 0;
        	   double ida_high_edu_tax= 0;
        	   double ida_locl_tax= 0;
        	   double ida_n2nd_locl_tax= 0;
        	   
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_expn_tax"))) {
        		   ida_expn_tax = Double.parseDouble(dbRowset.getString("ida_expn_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_edu_tax"))) {
        		   ida_edu_tax = Double.parseDouble(dbRowset.getString("ida_edu_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_high_edu_tax"))) {
        		   ida_high_edu_tax = Double.parseDouble(dbRowset.getString("ida_high_edu_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_locl_tax"))) {
        		   ida_locl_tax = Double.parseDouble(dbRowset.getString("ida_locl_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_n2nd_locl_tax"))) {
        		   ida_n2nd_locl_tax = Double.parseDouble(dbRowset.getString("ida_n2nd_locl_tax"));
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTaxRt(dbRowset.getString("ida_expn_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTax(JSPUtil.toDecimalFormat(ida_expn_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTaxRt(dbRowset.getString("ida_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTax(JSPUtil.toDecimalFormat(ida_edu_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTaxRt(dbRowset.getString("ida_high_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTax(JSPUtil.toDecimalFormat(ida_high_edu_tax, "#,##0.00"));
        	   // SBC ( Swacha Bharat Cess )
        	   invoiceIssueMasterPreviewVO.setRdIdaLoclTaxRt(dbRowset.getString("ida_locl_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaLoclTax(JSPUtil.toDecimalFormat(ida_locl_tax, "#,##0.00"));
        	   // KCC ( Krishi Kalyan Cess )
        	   invoiceIssueMasterPreviewVO.setRdIdaN2ndLoclTaxRt(dbRowset.getString("ida_n2nd_locl_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaN2ndLoclTax(JSPUtil.toDecimalFormat(ida_n2nd_locl_tax, "#,##0.00"));

        	   // 인도 TAX RATIO 변경 후 >==========================================================================================  
        	   double ida_cgst_amt= 0;
        	   double ida_sgst_amt= 0;
        	   double ida_igst_amt= 0;
        	   double ida_ugst_amt= 0;    
        	   
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_cgst_amt"))) {
        		   ida_cgst_amt = Double.parseDouble(dbRowset.getString("ida_cgst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_sgst_amt"))) {
        		   ida_sgst_amt = Double.parseDouble(dbRowset.getString("ida_sgst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_igst_amt"))) {
        		   ida_igst_amt = Double.parseDouble(dbRowset.getString("ida_igst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_ugst_amt"))) {
        		   ida_ugst_amt = Double.parseDouble(dbRowset.getString("ida_ugst_amt"));
        	   } 
        	   invoiceIssueMasterPreviewVO.setRdIdaCgstRto(dbRowset.getString("ida_cgst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaCgstAmt(JSPUtil.toDecimalFormat(ida_cgst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaSgstRto(dbRowset.getString("ida_sgst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaSgstAmt(JSPUtil.toDecimalFormat(ida_sgst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaIgstRto(dbRowset.getString("ida_igst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaIgstAmt(JSPUtil.toDecimalFormat(ida_igst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaUgstRto(dbRowset.getString("ida_ugst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaUgstAmt(JSPUtil.toDecimalFormat(ida_ugst_amt, "#,##0.00"));        	   
           }
           
        } 
		catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
		catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return invoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD占쏙옙incCntlDtail 揶쏅���No 占쏙옙MASTER 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.
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
        	   
        	   // 인도 TAX RATIO 변경 전 >==========================================================================================
        	   double ida_expn_tax= 0;
        	   double ida_edu_tax= 0;
        	   double ida_high_edu_tax= 0;
        	   double ida_locl_tax= 0;
        	   double ida_n2nd_locl_tax= 0;
        	   
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_expn_tax"))) {
        		   ida_expn_tax = Double.parseDouble(dbRowset.getString("ida_expn_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_edu_tax"))) {
        		   ida_edu_tax = Double.parseDouble(dbRowset.getString("ida_edu_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_high_edu_tax"))) {
        		   ida_high_edu_tax = Double.parseDouble(dbRowset.getString("ida_high_edu_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_locl_tax"))) {
        		   ida_locl_tax = Double.parseDouble(dbRowset.getString("ida_locl_tax"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_n2nd_locl_tax"))) {
        		   ida_n2nd_locl_tax = Double.parseDouble(dbRowset.getString("ida_n2nd_locl_tax"));
        	   }
        	   
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTaxRt(dbRowset.getString("ida_expn_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaExpnTax(JSPUtil.toDecimalFormat(ida_expn_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTaxRt(dbRowset.getString("ida_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaEduTax(JSPUtil.toDecimalFormat(ida_edu_tax, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTaxRt(dbRowset.getString("ida_high_edu_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaHighEduTax(JSPUtil.toDecimalFormat(ida_high_edu_tax, "#,##0.00"));
        	   // SBC ( Swacha Bharat Cess )
        	   invoiceIssueMasterPreviewVO.setRdIdaLoclTaxRt(dbRowset.getString("ida_locl_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaLoclTax(JSPUtil.toDecimalFormat(ida_locl_tax, "#,##0.00"));
        	   // KCC ( Krishi Kalyan Cess )
        	   invoiceIssueMasterPreviewVO.setRdIdaN2ndLoclTaxRt(dbRowset.getString("ida_n2nd_locl_tax_rt"));
        	   invoiceIssueMasterPreviewVO.setRdIdaN2ndLoclTax(JSPUtil.toDecimalFormat(ida_n2nd_locl_tax, "#,##0.00"));

        	   // 인도 TAX RATIO 변경 후 >==========================================================================================  
        	   double ida_cgst_amt= 0;
        	   double ida_sgst_amt= 0;
        	   double ida_igst_amt= 0;
        	   double ida_ugst_amt= 0;    
        	   
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_cgst_amt"))) {
        		   ida_cgst_amt = Double.parseDouble(dbRowset.getString("ida_cgst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_sgst_amt"))) {
        		   ida_sgst_amt = Double.parseDouble(dbRowset.getString("ida_sgst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_igst_amt"))) {
        		   ida_igst_amt = Double.parseDouble(dbRowset.getString("ida_igst_amt"));
        	   }
        	   if (!StringUtils.isEmpty(dbRowset.getString("ida_ugst_amt"))) {
        		   ida_ugst_amt = Double.parseDouble(dbRowset.getString("ida_ugst_amt"));
        	   } 
        	   invoiceIssueMasterPreviewVO.setRdIdaCgstRto(dbRowset.getString("ida_cgst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaCgstAmt(JSPUtil.toDecimalFormat(ida_cgst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaSgstRto(dbRowset.getString("ida_sgst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaSgstAmt(JSPUtil.toDecimalFormat(ida_sgst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaIgstRto(dbRowset.getString("ida_igst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaIgstAmt(JSPUtil.toDecimalFormat(ida_igst_amt, "#,##0.00"));
        	   invoiceIssueMasterPreviewVO.setRdIdaUgstRto(dbRowset.getString("ida_ugst_rto"));
        	   invoiceIssueMasterPreviewVO.setRdIdaUgstAmt(JSPUtil.toDecimalFormat(ida_ugst_amt, "#,##0.00"));  
           }
           dbRowsetNo = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueMasterPreviewNoRSQL(),param,velParam);
           
           if (dbRowsetNo.next()) {
        	   double invChgAmt = 0;
        	   if (!StringUtils.isEmpty(dbRowset.getString("inv_chg_amt"))) {
        		   invChgAmt = Double.parseDouble(dbRowset.getString("inv_chg_amt"));
        	   }        	   
        	   invoiceIssueMasterPreviewVO.setRdInvChgAmt(JSPUtil.toDecimalFormat(invChgAmt, "#,#00.00"));
        	   
        	   double taxAmt = 0;
        	   if (!StringUtils.isEmpty(dbRowset.getString("tax_amt"))) {
        		   taxAmt = Double.parseDouble(dbRowset.getString("tax_amt"));
        	   }        	   
        	   invoiceIssueMasterPreviewVO.setRdTaxAmt(JSPUtil.toDecimalFormat(taxAmt, "#,#00.00"));

        	   double invAmt = 0;
        	   if (!StringUtils.isEmpty(dbRowset.getString("inv_amt"))) {
        		   invAmt = Double.parseDouble(dbRowset.getString("inv_amt"));
        	   }
        	   invoiceIssueMasterPreviewVO.setRdInvAmt(JSPUtil.toDecimalFormat(invAmt,"#,##0.00"));
           }
           
        } 
		catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
		catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
		
        return invoiceIssueMasterPreviewVO;
    }
    
    /**
     * INVOICE RD占쏙옙manual invoice MASTER 占쎄퀣�좑옙怨뺧옙 鈺곌퀬�띰옙�뺣뼄.<br>
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
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceIssueManualRDRSQL(),param,velParam);
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
     * AR-IF 占쏙옙EDI嚥∽옙占쎄쑴�싷옙占쏙옙怨쀬뵠占쎄퀡占�鈺곌퀬�띰옙�뺣뼄.<br>
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
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchEDIContainerInfoByInvoiceRSQL(),param,null);
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
     * InvoiceDetail占쎈베�ユ에占퐄nterfaceCharge嚥∽옙鈺곌퀬��占썩뫖�뀐옙占�br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param String idaTaxApplTm
     * @return List<InvArIfChgVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInterfaceChargeByInvoiceDetail(String invoiceNo, String creOfcCd, String idaTaxApplTm) throws DAOException {
		DBRowSet dbRowset = null;
        List<InvArIfChgVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
           param.put("ida_tax_appl_tm", idaTaxApplTm);
           velParam.put("credit_note", "N");
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL(),param,velParam);
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
 	 * OFC_CD癰귨옙占쎄쑴�깍옙�깆쁽�쒙옙鈺곌퀬�띰옙�뺣뼄.
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
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
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
	 * 占쎈���Payer占쏙옙占쏙옙釉�PayerName 占쎈베�ョ몴占썼�怨좎돳占쎌뮆��<br>
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
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchPayerInfoNameRSQL(), param, velParam);
			
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
	 * 占쎈���Service Provider占쏙옙占쏙옙釉�Vendor�쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchServiceProviderNameRSQL(), param, null);
			
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
	 * tax_rto占쏙옙占쏙옙釉�invoice_detail占쏙옙tax_amt揶쏅����④쑴沅쏉옙�뺣뼄.<br>
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
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailTaxAmtRSQL(), param, null);
			
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
	 * Invoice Detail占쏙옙tax_rto, tax_amt�쒙옙占쎌꼷�숋옙�뺣뼄.<br>
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
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
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
 	 * SZPBB�쒙옙占쎈벏鍮�INVOICE 占쎌빘苑�占싼됵옙 占쎈벡��
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
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckSZPBBInvoiceRSQL(), param, null);
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
 	 * Invoice Cancel 占쎄낱源�옙�占�鈺곌퀬��
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
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckInvoiceCancelRSQL(), param, null);
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
 	 * Manual Invoice (BIL_AMT - INV_CHG_AMT) 揶쏉옙 INV_CURR_CD
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
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckManualARIFAmtRSQL(), param, null);
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
 	 * AR-IF 筌욊낯��INVOICE占쏙옙占쏙옙釉�AR-IF 占썬끋六�占싼됵옙 筌ｋ똾寃�
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
 			
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARIFCountRSQL(), param, velParam);

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
 	 * Invoice 占쎌빘苑�옙癒�벥 Office Code �쒙옙鈺곌퀬��占썩뫖�뀐옙占�
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
    
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceCreteOfficeCodeRSQL(), param, null);

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
 	 * DMT_CHG_CALC占쏙옙DMDT_CHG_STS_CD�쒙옙鈺곌퀬�띰옙�뺣뼄.
 	 * @param DmtInvDtlVO dmtInvDtlVO
 	 * @return String
 	 * @throws DAOException
 	 */
 	public ChargeCalculationContainerVO searchChargeStatusCd(DmtInvDtlVO dmtInvDtlVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		Map<String, Object> velParam 	= new HashMap<String, Object>();
 		ChargeCalculationContainerVO chgDtlVO = null;
 		
 		try{
 			Map<String, String> mapVO = dmtInvDtlVO.getColumnValues();
 			param.putAll(mapVO);
 			velParam.putAll(mapVO);
 			
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchChargeStatusCdRSQL(), param, velParam);

 			List<ChargeCalculationContainerVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeCalculationContainerVO.class);
 			
 			if(list != null && list.size() > 0) {
				chgDtlVO = (ChargeCalculationContainerVO)list.get(0);
			} 
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		
 		return chgDtlVO;
 	}
 	
 	/**
 	 * DMT_INV_MN占쏙옙DMDT_INV_STS_CD�쒙옙鈺곌퀬�띰옙�뺣뼄.
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
 			
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceStatusRSQL(), param, velParam);

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
     * InvoiceRate占쎈베�ユ에占퐄nterfaceCharge嚥∽옙鈺곌퀬��占썩뫖�뀐옙占�br>
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
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInterfaceChargeByInvoiceRateRSQL(),param,null);
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
     * Invoice占쏙옙占쏙옙釉�After Invoice Adjustment Amt�쒙옙鈺곌퀬��占썩뫖�뀐옙占�br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param String lgnOfcCd
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    public ChargeBookingInvoiceVO checkAftInvAdjAmtByInvoiceNo(String invoiceNo, String creOfcCd, String lgnOfcCd) throws DAOException {
    	DBRowSet dbRowset = null;
 		ChargeBookingInvoiceVO reVO = new ChargeBookingInvoiceVO();
 		//query parameter
 		Map<String, Object> param 		= new HashMap<String, Object>();
 		
 		try{
 			param.put("dmdt_inv_no", invoiceNo);
 			param.put("cre_ofc_cd", creOfcCd);
 			param.put("ofc_cd", lgnOfcCd);
 			
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOCheckAftInvAdjAmtByInvoiceNoRSQL(), param, null);

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
     * Invoice Detail占쏙옙FX_FT_OVR_DYS = 0 占쏙옙揶쏆뮇��鈺곌퀬��
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
 			
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceDetailZeroOverDayRSQL(), param, null);

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
     * InvoiceDetail占쎈베�ユ에占퐄nterfaceCharge嚥∽옙鈺곌퀬��占썩뫖�뀐옙占�br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @param String idaTaxApplTm
     * @return List<InvArIfChgVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
	public List<InvArIfChgVO> searchInterfaceChargeCreateNoteByInvoiceDetail(String invoiceNo, String creOfcCd, String idaTaxApplTm) throws DAOException {
		DBRowSet dbRowset = null;
        List<InvArIfChgVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
           param.put("invoice_no", invoiceNo);
           param.put("cre_ofc_cd", creOfcCd);
           param.put("ida_tax_appl_tm", idaTaxApplTm);
           velParam.put("credit_note","Y");
			
           dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOsearchInterfaceChargeByInvoiceDetailRSQL(),param,velParam);
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
      * BKG_CONTAINER占쏙옙P/O number�쒙옙鈺곌퀬�띰옙�뺣뼄.<br>
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

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBookingContainerPONumberRSQL(), param, velParam);
             
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
      * Cancel, Credit Note 占쎄낱源�옙占폠nvoice 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
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
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelDetailRSQL(), param, velParam);
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
      * Issued Invoice(Payer癰귨옙Currency占쏙옙占쏙옙釉�占썩뫕�롦묾�됰만) �쒙옙鈺곌퀬��占쎌뮆��
      * @param IssuedInvoiceParamVO issuedInvoiceParamVO
      * @return List<IssuedInvoiceSumByPayerVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<IssuedInvoiceSumByPayerVO> searchIssuedInvoiceSumByPayer(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
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
                    	if ("All".equals(ar_if_cd)) {
                    		dmdtArIfCdList.add("Y");
                    		dmdtArIfCdList.add("N");
                    	}
                    	else {
	 	                	if ("L".equals(ar_if_cd)) {
	 	                		velParam.put("s_ar_if_l_yn", "Y");
	 	                	}
	 	                	else if (ar_if_cd.equals("A")) {
	                    		dmdtArIfCdList.add("Y");
	                    		dmdtArIfCdList.add("N");	
	 	                	}
	 	                	else {
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
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIssuedInvoiceSumByPayerRSQL(), param, velParam);
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
      * BKG BOOKING占쎈Ŋ苑�BL_NO 揶쏅����븍뜄��옙�ㅻ뼄.<br>
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
             
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchBKGBlNoRSQL(), param, velParam);
             
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
      * 占쎈챶猷�GST �울옙��Tax rate 鈺곌퀬��<br>
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
  				indiaGstRateVO.setIdaLoclTaxRt(dbRowset.getString("ida_locl_tax_rt"));
  				indiaGstRateVO.setIdaN2ndLoclTaxRt(dbRowset.getString("ida_n2nd_locl_tax_rt"));
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
     
     

     /**
     * [Outstanding Inquiry by Customer N Issue 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
     * 
     * @param OtsInquiryParmVO otsInquiryParmVO
     * @return List<OTSCleanListVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<OTSCleanListVO> searchOTSCleanList ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
         DBRowSet dbRowset = null;
         List<OTSCleanListVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(otsInquiryParmVO != null){
                 Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);         
             
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

                 String tempSALTM = (String)otsInquiryParmVO.getSalTm();
                 List<String> tempSALTMList = new ArrayList<String>();
                 
                 StringTokenizer st5 = new StringTokenizer(tempSALTM, ",");
                 while (st5.hasMoreTokens()) {
                	 tempSALTMList.add(st5.nextToken());
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
                 velParam.put("tempSALTMList", tempSALTMList);
                 
             }

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSCleanListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSCleanListVO .class);
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
     * [Outstanding Inquiry by Customer N Issue 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
     * 
     * @param OtsInquiryParmVO otsInquiryParmVO
     * @return List<OTSCleanOfficeListVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<OTSCleanOfficeListVO> searchOTSCleanOfficeList ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
         DBRowSet dbRowset = null;
         List<OTSCleanOfficeListVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(otsInquiryParmVO != null){
                 Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);                           
             
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

                 String tempSALTM = (String)otsInquiryParmVO.getSalTm();
                 List<String> tempSALTMList = new ArrayList<String>();
                 
                 StringTokenizer st5 = new StringTokenizer(tempSALTM, ",");
                 while (st5.hasMoreTokens()) {
                	 tempSALTMList.add(st5.nextToken());
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
                 velParam.put("tempSALTMList", tempSALTMList);
                 
             }

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSCleanOfficeListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSCleanOfficeListVO .class);
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
    * EES_DMT_4017 : [Detailed down Excel 甕곌쑵��<br>
    * OTS Clean Detail Excel 占썬끉�ユ에�뺣굡<br>
     * 
     * @param OtsInquiryParmVO otsInquiryParmVO
     * @return List<OTSCleanDetailExcelListVO>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<OTSCleanDetailExcelListVO> searchOTSCleanDetailExcelList ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
         DBRowSet dbRowset = null;
         List<OTSCleanDetailExcelListVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
             if(otsInquiryParmVO != null){
                 Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
             
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);

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
                 
                 String tempSALTM = (String)otsInquiryParmVO.getSalTm();
                 List<String> tempSALTMList = new ArrayList<String>();
                 
                 StringTokenizer st5 = new StringTokenizer(tempSALTM, ",");
                 while (st5.hasMoreTokens()) {
                	 tempSALTMList.add(st5.nextToken());
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
                 velParam.put("tempSALTMList", tempSALTMList);
                 
             }

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSCleanDetailExcelListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSCleanDetailExcelListVO .class);
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
      * Sales Team, Sales Rep. 占쏙옙��<br>
      * 
      * @param OTSCleanDetailExcelListVO oTSCleanDetailExcelListVO
      * @param SignOnUserAccount account
      * @throws EventException
      */
     public void updateOTSCleanDetailListSales(OTSCleanDetailExcelListVO oTSCleanDetailExcelListVO, SignOnUserAccount account) throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         //Map<String, Object> velParam = new HashMap<String, Object>();
         
         try {
             Map<String, String> mapVO = oTSCleanDetailExcelListVO.getColumnValues();
             param.putAll(mapVO);
             param.put( "usid" , account.getUsr_id() );
             
             SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
             int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOUpdateOTSCleanDetailListSalesUSQL(), param, null);
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
     * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
     * 
     * @param OtsInquiryParmVO otsInquiryParmVO
     * @return List<OtsInquiryByDetialVO2>
     * @throws DAOException
     */
     @SuppressWarnings("unchecked")
     public List<OTSCleanDetailExcelListVO> searchOTSCleanByDetailList2 ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
         DBRowSet dbRowset = null;
         List<OTSCleanDetailExcelListVO> list = null;
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

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSCleanByDetailList2RSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, OTSCleanDetailExcelListVO .class);
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
      * [Invoice Cancel Remark] Invoice Cancel Remark 를 조회합니다.
      * 
      * @param CancelInvoiceParamVO cxlInvVO
      * @return String
      * @throws DAOException
      */
	 public String searchInvoiceCancelRmk(CancelInvoiceParamVO cxlInvVO) throws DAOException {
         DBRowSet dbRowset = null;
         String result = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
       
         try {
        	 if (cxlInvVO != null) {
        		 Map<String, String> mapVO = cxlInvVO.getColumnValues();
        		 param.putAll(mapVO);
        	 
        		 dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceCancelRmkRSQL(), param, null);

				if (dbRowset.next()) {
					result = dbRowset.getString(1);
				}
        	 }
         } 
         catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } 
         catch(Exception ex){
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return result;
	 } 
	 
     /**
      * Cancel 占쎄낱源�옙占폲irtual Invoice 占쎈베�ョ몴占썼�怨좎돳 占썩뫖�뀐옙占�br>
      * 
      * @param ChargeBookingInvoiceVO chargeBookingInvoiceVO
      * @return List<InvoiceIssueVO>
      * @throws DAOException
      */
     @SuppressWarnings("unchecked")
     public List<InvoiceIssueVO> searchVtInvoiceCancelDetail(ChargeBookingInvoiceVO chargeBookingInvoiceVO) throws DAOException {
         DBRowSet dbRowset = null;
         List<InvoiceIssueVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try {
             if(chargeBookingInvoiceVO != null){
                 Map<String, String> mapVO = chargeBookingInvoiceVO .getColumnValues();
                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
             }
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchVtInvoiceCancelDetailRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueVO .class);
         } 
         catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } 
         catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return list;
     }	
     
     /**
  	 * 揶쏉옙湲�Invoice 占쏙옙占쎄낱源�몴占쏙옙�륁젟占쎌뮆��
  	 * 
  	 * @param String dmdtInvNo
  	 * @param String dmdtVtInvStsCd
  	 * @param String creOfcCd
     * @throws DAOException
  	 */
     public void modifyVirtualInvoiceStatus(String dmdtInvNo, String dmdtVtInvStsCd, String creOfcCd)  throws DAOException {
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
          
         try {
        	 param.put("dmdt_inv_no", dmdtInvNo);
        	 param.put("dmdt_vt_inv_sts_cd", dmdtVtInvStsCd);
        	 param.put("cre_ofc_cd", creOfcCd);
             
             SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
             int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyVirtualInvoiceStatusUSQL(), param, null);
             if(result == Statement.EXECUTE_FAILED)
                     throw new DAOException("Fail to modifyVirtualInvoiceStatus SQL");
         } 
         catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         }
         catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
     }     
     
    /**
 	 * BKG No., Tariff Type 占쏙옙占쎈���옙�롫뮉 Virtual Invoice 揶쏉옙鈺곕똻�깍옙�롫뮉筌욑옙鈺곌퀬�띰옙�뺣뼄.
  	 * 
  	 * @param String bkgNo
  	 * @param String dmdtTrfCd
  	 * @return String
  	 * @throws DAOException
  	 */
     public String searchExistsVirtualInvoice(String bkgNo, String dmdtTrfCd) throws DAOException {
         DBRowSet dbRowset = null;
         String result = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();

         try {
             param.put("bkg_no", bkgNo);
             param.put("dmdt_trf_cd", dmdtTrfCd);

             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchExistsVirtualInvoiceRSQL(), param, null);
             
             if (dbRowset.next()) {
            	 result = dbRowset.getString(1);
             }
         } 
         catch(SQLException se) {
             log.error(se.getMessage(),se);
             throw new DAOException(new ErrorHandler(se).getMessage());
         } 
         catch(Exception ex) {
             log.error(ex.getMessage(),ex);
             throw new DAOException(new ErrorHandler(ex).getMessage());
         }
         return result;
     }   
     
    /**
 	 * BKG No., Tariff Type 占쏙옙占쎈���옙�롫뮉 Virtual Invoice �쒙옙Cancel 占쎌뮆��
 	 * 
 	 * @param String bkgNo
 	 * @param String dmdtTrfCd
     * @throws DAOException
   	 */
      public void cancelVirtualInvoice(String bkgNo, String dmdtTrfCd)  throws DAOException {
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
           
          try {
              param.put("bkg_no", bkgNo);
              param.put("dmdt_trf_cd", dmdtTrfCd);
              
              SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
              int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyVirtualInvoiceStatusToCancelUSQL(), param, null);
              if(result == Statement.EXECUTE_FAILED)
                      throw new DAOException("Fail to cancelVirtualInvoice SQL");
          } 
          catch(SQLException se) {
              log.error(se.getMessage(),se);
              throw new DAOException(new ErrorHandler(se).getMessage());
          }
          catch(Exception ex) {
              log.error(ex.getMessage(),ex);
              throw new DAOException(new ErrorHandler(ex).getMessage());
          }
      }       
      
   /**
    * DAR No. 占쏙옙占싼뗫맙占쏙옙筌뤴뫀諭�Invoice 筌뤴뫖以됵옙占썼�怨좎돳占쎌뮆��
    * 
    * @param AfterProgressVO afterProgressVO
    * @return List<CancelInvoiceParamVO>
    * @throws DAOException
    */
    @SuppressWarnings("unchecked")      
    public List<CancelInvoiceParamVO> searchCancelInvoiceList(AfterProgressVO afterProgressVO) throws DAOException {
      	DBRowSet dbRowset = null;
      	List<CancelInvoiceParamVO> list = null;
      	//query parameter
      	Map<String, Object> param = new HashMap<String, Object>();

      	try {
      		if (afterProgressVO != null) {
      		 Map<String, String> mapVO = afterProgressVO.getColumnValues();
      		 param.putAll(mapVO);

      		 dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCancelInvoiceListRSQL(), param, null);
      		 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CancelInvoiceParamVO.class);
      		}
      	} 
      	catch(SQLException se) {
	      	log.error(se.getMessage(),se);
	      	throw new DAOException(new ErrorHandler(se).getMessage());
      	} 
      	catch(Exception ex) {
	      	log.error(ex.getMessage(),ex);
	      	throw new DAOException(new ErrorHandler(ex).getMessage());
      	}
      	
      	return list;
    }        

  	/**
       * Confirm占쏙옙CNTR 占쎈베�ョ몴占썸뉩紐껓폎癰귢쑬以�鈺곌퀬��占썩뫖�뀐옙占�br>
       * 
       * @param IssuedInvoiceParamVO issuedInvoiceParamVO
       * @return List<DmtInvMnVO>
       * @throws DAOException
       */
       @SuppressWarnings("unchecked")
      public List<DmtInvMnVO> searchConfirmGrpBkgNo(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
          DBRowSet dbRowset = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          List<DmtInvMnVO> list = null;
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
              dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtInvMnVO .class);
              
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
        * Confirm占쏙옙CNTR 占쎈베�ョ몴占폚NTR No嚥∽옙鈺곌퀬��占썩뫖�뀐옙占�br>
        * 
        * @param IssuedInvoiceParamVO issuedInvoiceParamVO
        * @return List<DmtInvMnVO>
        * @throws DAOException
        */
        @SuppressWarnings("unchecked")
       public List<DmtInvMnVO> searchConfirmGrpBkgNoContainer(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
           DBRowSet dbRowset = null;
           //query parameter
           Map<String, Object> param = new HashMap<String, Object>();
           //velocity parameter
           Map<String, Object> velParam = new HashMap<String, Object>();

           List<DmtInvMnVO> list = null;
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
               dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchConfirmGrpBkgNoContainerRSQL(), param, velParam);
               list = (List)RowSetUtil.rowSetToVOs(dbRowset, DmtInvMnVO .class);
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
     * [INV. 瑜��앹꽦��Office 媛��먮룞 A/R I/F ��긽�몄� �щ�]瑜�[議고쉶] �⑸땲��<br>
     * 
     * @param String dmtOfcCd
     * @return String
     * @throws DAOException
     */
     public String searchAutoARInfYnByOffice(String dmtOfcCd) throws DAOException {
       	DBRowSet dbRowset = null;
       	String result = null;
       	//query parameter
       	Map<String, Object> param = new HashMap<String, Object>();

       	try {
       		if (dmtOfcCd != null) {
       			param.put("dmt_ofc_cd", dmtOfcCd);

       		 	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchAutoARInfYnByOfficeRSQL(), param, null);
       		 	if (dbRowset.next()) {
       		 		result = dbRowset.getString(1);
       		 	}
       		}
       	} 
       	catch(SQLException se) {
 	      	log.error(se.getMessage(),se);
 	      	throw new DAOException(new ErrorHandler(se).getMessage());
       	} 
       	catch(Exception ex) {
 	      	log.error(ex.getMessage(),ex);
 	      	throw new DAOException(new ErrorHandler(ex).getMessage());
       	}
       	return result;
     }  
     
     /**
  	 * [ERP �쇰줈遺�꽣 �섏떊��OTS 誘몄닔湲��섏떊�뺣낫]瑜�[��옣] �⑸땲��<br>
  	 * 
  	 * @param OtsPayRcvVO otsPayRcvVO
     * @throws DAOException
	 */
   public void addOtsInfo(OtsPayRcvVO otsPayRcvVO) throws DAOException {
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
        
       try {
    	   if (otsPayRcvVO != null) {
               Map<String, String> mapVO = otsPayRcvVO.getColumnValues();
               param.putAll(mapVO);
	           
	           SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
	           int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOAddOtsInfoCSQL(), param, null);
	           if(result == Statement.EXECUTE_FAILED)
	                   throw new DAOException("Fail to add OTS Info SQL");
    	   }
       } 
       catch(SQLException se) {
           log.error(se.getMessage(),se);
           throw new DAOException(new ErrorHandler(se).getMessage());
       }
       catch(Exception ex) {
           log.error(ex.getMessage(),ex);
           throw new DAOException(new ErrorHandler(ex).getMessage());
       }
   }    

   
    /**
     * [ERP �쇰줈遺�꽣 �섏떊��OTS 誘몄닔湲��⑸���湲덉븸��泥�뎄��湲덉븸怨��숈씪�쒖� �щ�]瑜�[議고쉶] �⑸땲��<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @return String
     * @throws DAOException
     */
    public String searchOtsCollectedYn(OtsPayRcvVO otsPayRcvVO) throws DAOException {
      	DBRowSet dbRowset = null;
      	String result = null;
      	//query parameter
      	Map<String, Object> param = new HashMap<String, Object>();

        try {
     	    if (otsPayRcvVO != null) {
                Map<String, String> mapVO = otsPayRcvVO.getColumnValues();
                param.putAll(mapVO);

      		 	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOtsCollectedYnRSQL(), param, null);
      		 	if (dbRowset.next()) {
      		 		result = dbRowset.getString(1);
      		 	}
      		}
      	} 
      	catch(SQLException se) {
	        log.error(se.getMessage(),se);
	      	throw new DAOException(new ErrorHandler(se).getMessage());
      	} 
      	catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
      	}
        return result;
    }   
    
    /**
     * [ERP �쇰줈遺�꽣 �섏떊��OTS 誘몄닔湲덉씠 �꾨궔��寃쎌슦 誘몄닔湲��꾨궔 FLAG]瑜�[�섏젙] �⑸땲��<br>
     * 
     * @param OtsPayRcvVO otsPayRcvVO
     * @exception DAOException
     */
    public void modifyOtsCollected(OtsPayRcvVO otsPayRcvVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
       
        try {
    	    if (otsPayRcvVO != null) {
    		    Map<String, String> mapVO = otsPayRcvVO.getColumnValues();
    		    param.putAll(mapVO);
           
    		    SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
    		    int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyOtsCollectedUSQL(), param, null);
    		    if (result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to add OTS Info SQL");
    	    }
        } 
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
	/**
     * [TAB3:A/R Interface Status Inquiry By ERP]��[議고쉶]�⑸땲��<br>
     * 
     * @param ARInterfaceParmVO arInterfaceParmVO
     * @return List<ARInterfaceStatusVO>
     * @throws DAOException
     */
	@SuppressWarnings("unchecked")
	public List<ARInterfaceStatusVO> searchARInterfaceStatusByERP(ARInterfaceParmVO arInterfaceParmVO) throws DAOException {
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
                 StringTokenizer st = null;

                 String ofcCd = arInterfaceParmVO.getOfcCd();
                 List<String> ofcCdList = new ArrayList<String>();
                 st = new StringTokenizer(ofcCd, ",");
                 while (st.hasMoreTokens()) {
                     ofcCdList.add(st.nextToken());
                 }
                 velParam.put("ofc_cd_list", ofcCdList);
                 
                 String invoiceNo = arInterfaceParmVO.getInvoiceNo();
                 List<String> invoiceNoList = new ArrayList<String>();
                 st = new StringTokenizer(invoiceNo, ",");
                 while (st.hasMoreTokens()) {
                	 invoiceNoList.add(st.nextToken());
                 }
                 velParam.put("invoice_no_list", invoiceNoList);
	             
                 String bkgNo = arInterfaceParmVO.getBkgNo();
                 List<String> bkgNoList = new ArrayList<String>();
                 st = new StringTokenizer(bkgNo, ",");
                 while (st.hasMoreTokens()) {
                	 bkgNoList.add(st.nextToken());
                 }
                 velParam.put("bkg_no_list", bkgNoList);
                 
                 // 2015-06-04 Tariff Type 조건 추가
                 String dmdtTrfCd = arInterfaceParmVO.getDmdtTrfCdT3();
                 List<String> dmdtTrfCdList = new ArrayList<String>();
                 st = new StringTokenizer(dmdtTrfCd, ",");
                 while (st.hasMoreTokens()) {
                	 dmdtTrfCdList.add(st.nextToken());
                 }
                 velParam.put("dmdt_trf_cd_list", dmdtTrfCdList);
                
             }
             dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchARInterfaceStatusByERPRSQL(), param, velParam);
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
     * BKG BOOKING占쎈Ŋ苑�BL_NO 揶쏅����븍뜄��옙�ㅻ뼄.<br>
     * 
     * @param String invNo
     * @return String 
     * @throws DAOException
     */
    public String searchPurgedBkgFlg(String invNo) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        String purged_bkg_flg = "";

        try{
            param.put("inv_no", invNo);
            
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPurgedBkgFlagRSQL(), param, velParam);
            
            if(dbRowset.next()){
            	purged_bkg_flg = dbRowset.getString("purged_bkg_flg");
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return purged_bkg_flg;       
    }     
    
    /**
     * Payer Info 목록을 조회한다.
     * 
     * @param payerInfoListVO
     * @return List<PayerInfoListVO>
     * @throws DAOException
     */
    public List<PayerInfoListVO> searchPayerInfoList(PayerInfoListVO payerInfoListVO) throws DAOException {
    	
    	DBRowSet dbRowset = null;
    	
    	List<PayerInfoListVO> list = null;
    	
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
        	if(payerInfoListVO != null) {
        		Map<String, String> mapVO = payerInfoListVO.getColumnValues();
            	param.putAll(mapVO);
            	velParam.putAll(mapVO);
            	
            	String sendCycCd = payerInfoListVO.getSndCycCd();
            	if(sendCycCd != null && !sendCycCd.equals("")) {
            		List<String> sendCycCdList = new ArrayList<String>();
            		StringTokenizer st = new StringTokenizer(sendCycCd, ",");
            		while(st.hasMoreTokens()) {
            			sendCycCdList.add(st.nextToken());
            		}
            		velParam.put("send_cyc_cd_list", sendCycCdList);
            	}
            	//e-mail check 위한 정규 표현식
        	}    	
        	param.put("reg_ex", EML_REG_EX);
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchPayerInfoListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PayerInfoListVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }

    /**
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 占쏙옙湲� 占쎈베�ョ몴占�Search] 占썩뫖�뀐옙占�br>
    * 
    * @param OtsInquiryParmVO otsInquiryParmVO
    * @return String
    * @throws DAOException
    */
    public String searchOTSInquiryByDetailListInternalRemark ( OtsInquiryParmVO otsInquiryParmVO ) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnRemark = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(otsInquiryParmVO != null && otsInquiryParmVO.getPayc() != null && !"".equals(otsInquiryParmVO.getPayc())){
                Map<String, String> mapVO = otsInquiryParmVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);         
            
	            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchOTSInquiryByDetailListInternalRemarkRSQL(), param, velParam);
	            while(dbRowset.next()){
	                rtnRemark = dbRowset.getString(1);
	            }
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
    * [변경된 인도 Tax 적용시점 ( A : After, B : Before )]을 [SEARCH] 합니다.<br>
    * 
    * @param String invNo
    * @return String
    * @throws DAOException
    */
    public String searchIdaTaxApplTm(String invNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.put("dmdt_inv_no", invNo);
        	
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplTmRSQL(), param, null);
            if (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return result;
    } 
    
    /**
    * [India Tax Division Code (N, S, U, I)]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return String
    * @exception DAOException
    */     
    public String searchIdaTaxDivCd(IdaGstRtoCondVO condVO) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
    		Map<String, String> mapVO = condVO.getColumnValues();
        	param.putAll(mapVO);
        	velParam.putAll(mapVO);
        	
        	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIdaTaxDivCdRSQL(), param, velParam);
            while (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return result;
    }
    
    /**
    * [India Tax Division Code (N, S, U, I)]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception DAOException
    */     
    public IdaGstRtoVO searchIdaTaxRto(IdaGstRtoCondVO condVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<IdaGstRtoVO> list = new ArrayList<IdaGstRtoVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
    		Map<String, String> mapVO = condVO.getColumnValues();
        	param.putAll(mapVO);
        	velParam.putAll(mapVO);
        	
        	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIdaTaxRtoRSQL(), param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IdaGstRtoVO.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list != null && list.size() > 0 ? list.get(0) : null;
    }
    
    /**
    * [인도OFC 에서 발행된 INVOICE 의 은행계좌정보]를 [SEARCH] 합니다.<br>
    * 
    * @return IdaGstRtoVO
    * @exception DAOException
    */     
    public IdaGstRtoVO searchIdaBankInfo() throws DAOException {
        DBRowSet dbRowset = null;
        List<IdaGstRtoVO> list = new ArrayList<IdaGstRtoVO>();
       
        try {
        	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIdaBankInfoRSQL(), null, null);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IdaGstRtoVO.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list != null && list.size() > 0 ? list.get(0) : null;
    }
    
    /**
    * [Customer 의 GST 정보]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception DAOException
    */     
    public IdaGstRtoVO searchGstInfo(IdaGstRtoCondVO condVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<IdaGstRtoVO> list = new ArrayList<IdaGstRtoVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
    		Map<String, String> mapVO = condVO.getColumnValues();
        	param.putAll(mapVO);
        	velParam.putAll(mapVO);
        	
        	ISQLTemplate sqlTemplate;
        	if ("V".equals(condVO.getCustVndrDivCd())) {
        		sqlTemplate = (ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchGstVndrInfoRSQL();
        	}
        	else {
        		sqlTemplate = (ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchGstCustInfoRSQL();
        	}
        	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery(sqlTemplate, param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IdaGstRtoVO.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list != null && list.size() > 0 ? list.get(0) : null;
    }   
    
    /**
    * [인도Office 의 GST 정보]을 [SEARCH] 합니다.<br>
    * 
    * @param IdaGstRtoCondVO condVO
    * @return IdaGstRtoVO
    * @exception DAOException
    */     
    public IdaGstRtoVO searchGstInfoByOffice(IdaGstRtoCondVO condVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<IdaGstRtoVO> list = new ArrayList<IdaGstRtoVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
    		Map<String, String> mapVO = condVO.getColumnValues();
        	param.putAll(mapVO);
        	velParam.putAll(mapVO);
        	
        	dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchGstInfoByOfficeRSQL(), param, velParam);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IdaGstRtoVO.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list != null && list.size() > 0 ? list.get(0) : null;
    } 
    
    /**
    * [인도 Invoice No. 채번을 위한 회계년도 및 현재 YYMM 정보 ]을 [SEARCH] 합니다.<br>
    * 
    * @param String ofcCd
    * @return IndiaFiscalYearVO
    * @exception DAOException
    */      
    public IndiaFiscalYearVO searchIndiaFiscalYear(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;    	
        List<IndiaFiscalYearVO> list = new ArrayList<IndiaFiscalYearVO>();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.put("ofc_cd", ofcCd);
        	
        	SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
        	dbRowset = sqlExe.executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIndiaFiscalYearRSQL(), param, null);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IndiaFiscalYearVO.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list != null && list.size() > 0 ? list.get(0) : null;
    }  
    
    
    /**
    * [인도 Invoice No. ]을 [SEARCH] 합니다.<br>
    * 
    * @param IndiaInvoiceNo condVO
    * @return IndiaInvoiceNo
    * @exception DAOException
    */      
    public IndiaInvoiceNo searchIndiaInvoiceNo(IndiaInvoiceNo condVO) throws DAOException {
        DBRowSet dbRowset = null;
        Map<String, Object> param = new HashMap<String, Object>();
        List<IndiaInvoiceNo> list = new ArrayList<IndiaInvoiceNo>();

        try {
        	if (condVO != null) {
                Map<String, String> mapVO = condVO .getColumnValues();
                param.putAll(mapVO);
        	}
            
        	SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
        	dbRowset = sqlExe.executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIndiaInvoiceNoRSQL(), param, null);
        	list = (List)RowSetUtil.rowSetToVOs(dbRowset, IndiaInvoiceNo.class);
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(String.valueOf(se.getErrorCode())).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return list != null && list.size() > 0 ? list.get(0) : null;
    }    
    
    /**
     * 인도지역에서 발행되는 invoice 번호를 등록합니다.
     * @param IndiaInvoiceNo indiaInvoiceNo
     * @throws DAOException
     */
    public void createIndiaInvoiceNo(IndiaInvoiceNo indiaInvoiceNo) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try {
            if (indiaInvoiceNo != null){
                Map<String, String> mapVO = indiaInvoiceNo.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOInsertIndiaInvoiceNoCSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO INSERT INDIA INVOICE NO");
            }
        } 
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    } 
    
    /**
     * 인도지역에서 발행되는 invoice 번호에 사용되는 seq. 를 갱신합니다.
     * @param IndiaInvoiceNo indiaInvoiceNo
     * @throws DAOException
     */
    public void modifyIndiaInvoiceNo(IndiaInvoiceNo indiaInvoiceNo) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try {
            if (indiaInvoiceNo != null){
                Map<String, String> mapVO = indiaInvoiceNo.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOUpdateIndiaInvoiceNoUSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("FAIL TO UPDATE INDIA INVOICE NO");
            }
        } 
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
    
    /**
    * [ Invoice 의 종류 ]를 [ 판별 ] 합니다.<br>
    * 
    * @param String invoiceNo
    * @return String
    * @throws DAOException
    */
    public String searchInvoiceType(String invoiceNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.put("dmdt_inv_no", invoiceNo);
        	
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchInvoiceTypeRSQL(), param, null);
            if (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return result;
    }  
    
    /**
     * [ 변경된 인도세법의 시스템 적용일 ]을 [ 조회 ] 합니다.<br>
    * 
    * @return String
    * @throws DAOException
    */
    public String searchIdaTaxApplDt() throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchIdaTaxApplDtRSQL(), param, null);
            if (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return result;
    }  
    
    /**
     * Credit Invoice 여부를 조회합니다. <br>
    * 
    * @param String invoiceNo 
    * @param String creOfcCd
    * @return String
    * @throws DAOException
    */
    public String searchCreditNoteYn(String invoiceNo, String creOfcCd) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.put("dmdt_inv_no", invoiceNo);
        	param.put("cre_ofc_cd", creOfcCd);
        	
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCreditNoteYnRSQL(), param, null);
            if (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return result;
    }
    
    /**
     * EDI 로 전송할 정보를 조회합니다.<br>
     * 
     * @param String invoiceNo
     * @param String creOfcCd
     * @return List<EDIVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<EDIVO> searchToEdiList(String invoiceNo, String creOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EDIVO> list = null;
		 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("invoice_no", invoiceNo);
			param.put("cre_ofc_cd", creOfcCd);
			
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchToEdiListRSQL(),param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EDIVO .class);
        } 
		catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
		catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
		
        return list;    
    } 

    /**
     *[  Invoice 를 AR 로 전송 후 반환된 IF No. ]를 [ 수정 ] 합니다.
     * @param String arIfNo
     * @param String invNo
     * @throws DAOException
     */
    public void modifyARInterfaceByManual(String arIfNo, String invoiceNo) throws DAOException {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        try {
        	param.put("ar_if_no", arIfNo);
        	param.put("invoice_no", invoiceNo);
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            int result = 0;
            result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOModifyARInterfaceByManualUSQL(), param, null);
            
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to update SQL");
            
        } 
        catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    } 
    
    /**
     *[  AR 로 전송하기 위해서 필요한 Dummy Invoice No. ]를 [ 조회 ] 합니다.
     * @param String invNo
     * @return String
     * @throws EventException
     */
    public String searchDummyInvSrcNo(String invNo) throws DAOException {
        DBRowSet dbRowset = null;
        String result = "";    
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.put("invoice_no", invNo);
        	
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchDummyInvSrcNoRSQL(), param, null);
            if (dbRowset.next()) {
            	result = dbRowset.getString(1);
            }
        }
        catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        
        return result;
    } 
    
	/**
	 *  [ AFT BKG 승인으로 인해 발행되었던 관련 Invoice 건 ]을 [ 조회 ] 합니다. <br>
	 * 
	 * @param String aftExptDarNo
	 * @return List<CancelInvoiceParamVO>
	 * @exception EventException
	 */		
	public List<CancelInvoiceParamVO> searchCxlInvList(String aftExptDarNo) throws DAOException,Exception {
		
		DBRowSet dbRowSet = null;
		
		List<CancelInvoiceParamVO> list = new ArrayList<CancelInvoiceParamVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("aft_expt_dar_no", aftExptDarNo);
			
			dbRowSet = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOSearchCxlInvListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CancelInvoiceParamVO.class);
		}
		catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}
		catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;		
	}
	
	/**
	 *  [ Cancel 된 Invoice 를 Virtual 상태 ]로 [ 수정 ] 합니다. <br>
	 * 
	 * @param CancelInvoiceParamVO cxlInvVO
	 * @exception EventException
	 */		
	public void updateInvStsToVtByAftBkg(CancelInvoiceParamVO cxlInvVO) throws DAOException,Exception {

		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try {
        	param.putAll(cxlInvVO.getColumnValues());
            
            SQLExecuter sqlExe = new SQLExecuter("DMT_HJSBAT");
            int result = sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueCollectionMgtDBDAOUpdateInvStsToVtUSQL(), param, null);
            if (result == Statement.EXECUTE_FAILED)
            	throw new DAOException("Fail to UpdateInvStsToVt SQL");
        } 
        catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } 
        catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
	}	
	
}
