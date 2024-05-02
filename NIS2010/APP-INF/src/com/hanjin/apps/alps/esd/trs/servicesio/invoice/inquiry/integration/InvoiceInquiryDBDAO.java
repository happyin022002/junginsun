/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryDBDAO.java
*@FileTitle : SPP TRS Invoice Inquiry DBDAO 
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-03-06 sunghwan cho : Status code conversion 추가
* 2007-04-09 sunghwan cho : Status Code 변환명 수정
* 2007-04-12 sunghwan cho : Reject Status 추가
* 2007-05-15 sunghwan cho : searchInvoiceInquiryExcelExtract 메서드 추가
* 2007-08-03 Jung-Jae Kim : 프레임워크 표준에 따른 패키지 수정
*@LastModifyDate : 2007-08-03
*@LastModifier : Jung-Jae Kim
*@LastVersion : 1.5
=========================================================
History
2012.02.15 윤권영 [CHM-201215882]210EDI 수신 값에 따른 data 처리과정 변경
2012.09.05 윤권영 [CHM-201219971]Master user의 조회 권한 추가
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.InvoiceInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.inquiry.event.SppTrsI05Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DB Data Access Object<br>
 * - SPP TRS Invoice Inquiry DBDAO<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * searchInvoiceInquiryList<br>
     * - 다양한 조건으로 Invoice List를 출력한다.<br>
     * 
     * @param et Event
     * @return invoiceInquiryData InvoiceInquiry[]
     * @exception DAOException
     */
    public InvoiceInquiry[] searchInvoiceInquiryList(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceInquiry[] invoiceInquiryData = null;
        
        try {
        	SppTrsI05Event event = (SppTrsI05Event)et;
        	String vendor_cd = (event.getVendorCode() != null ) ? event.getVendorCode() : "";
        	
        	Map<String, Object> param = new HashMap<String, Object>();
        	
    		param.put("vndr_seq", vendor_cd);
    		param.put("dt_fr", event.getPeriodStartDate());
    		param.put("dt_to", event.getPeriodEndDate());
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		velParam.put("vndr_dvsn", event.getMasterSPP());
    		velParam.put("period_type", event.getPeriodType());
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(convertPortalInvoiceStatus(event.getStatus()).replaceAll("'",""), ","); 
			velParam.put("trsp_inv_aud_sts_cd", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(event.getInvoiceNo(), ","); 
			velParam.put("inv_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(event.getWorkOrderNo(), ","); 
			velParam.put("wo_no", tmpArrList);
			
			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(event.getEquipmentNo(), ","); 
			velParam.put("eq_no", tmpArrList);

			tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(vendor_cd, ",");

			velParam.put("sp_cd", tmpArrList);
			
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    		InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL template = new InvoiceInquiryDBDAOsearchInvoiceInquiryListRSQL();	        
            rs = sqlExe.executeQuery(template,param,velParam);

            ArrayList inquiryArray = new ArrayList();
            while(rs.next()) {
            	InvoiceInquiry invoiceInquiry = new InvoiceInquiry();
            	invoiceInquiry.setSeq(rs.getInt("rownum"));
            	invoiceInquiry.setInvoiceNo(rs.getString("inv_no"));
            	invoiceInquiry.setInvoiceCurrency(rs.getString("inv_curr_cd"));
            	invoiceInquiry.setInvoiceTotalAMT(rs.getString("inv_ttl_amt"));
            	invoiceInquiry.setIssueDate(rs.getString("inv_iss_dt"));
            	invoiceInquiry.setSubmitDate(rs.getString("inv_rcv_dt"));
            	
            	if ( rs.getString("inv_rjct_flg").equalsIgnoreCase("Y") && !rs.getString("inv_edi_rslt_cd").equalsIgnoreCase("D")  ) {
            		invoiceInquiry.setStatus(convertInvoiceStatus("RJ"));
            	}else if ( rs.getString("inv_rjct_flg").equalsIgnoreCase("Y") && rs.getString("inv_edi_rslt_cd").equalsIgnoreCase("D")  ) {
            		invoiceInquiry.setStatus(convertInvoiceStatus("EF"));
            	}else {
            		invoiceInquiry.setStatus(convertInvoiceStatus(rs.getString("status")));
            	}
            	invoiceInquiry.setStatus_cd(rs.getString("status"));
            	invoiceInquiry.setPaidDate(rs.getString("paidDate"));
            	invoiceInquiry.setPaymentMethod(rs.getString("paymentMethod"));
            	invoiceInquiry.setCheckTTNumber(rs.getString("checkTTNumber"));
            	invoiceInquiry.setInvoiceVendorCode(rs.getString("inv_vndr_seq"));
            	invoiceInquiry.setIfSysKndName(rs.getString("if_sys_knd_name"));
            	invoiceInquiry.setInvRmk(rs.getString("sp_inv_rmk"));
            	inquiryArray.add(invoiceInquiry);
            }
            invoiceInquiryData = (InvoiceInquiry[])inquiryArray.toArray(new InvoiceInquiry[0]);
                        
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return invoiceInquiryData;
    }
    
    /**
     *  searchInvoiceInquiryExcelHeader Inquiry 의 데이타 모델에 해당되는 값을 불러온다.<br>
     *  
     * @param et 이벤트객체
     * @return InvoiceInquiry
     * @throws DAOException
     */
    public InvoiceInquiry searchInvoiceInquiryExcelHeader(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceInquiry invoiceInquiryData = null;        
       
        
        try {

        	SppTrsI05Event event = (SppTrsI05Event)et;
	
			Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", event.getVendorCode());
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL template = new InvoiceInquiryDBDAOsearchInvoiceInquiryExcelHeaderRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            invoiceInquiryData = new InvoiceInquiry();
            if(rs.next()) { 
            	invoiceInquiryData.setVendorName	(JSPUtil.getNull(rs.getString("full_name")));
            	invoiceInquiryData.setVendorAddress	(JSPUtil.getNull(rs.getString("eng_addr")));
            	invoiceInquiryData.setVendorTelNo	(JSPUtil.getNull(rs.getString("phn_no")));
            	invoiceInquiryData.setVendorFaxNo	(JSPUtil.getNull(rs.getString("fax_no")));
            } 
         } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
         }
        return invoiceInquiryData;
    }

     
    /**
     * searchInvoiceInquiryExcelExtract<br>
     * - Excel Extract를위해 Invoice List를 출력한다.<br>
     * 
     * @param et Event
     * @return invoiceInquiryData InvoiceInquiry[]
     * @exception DAOException
     */
    public InvoiceInquiry[] searchInvoiceInquiryExcelExtract(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceInquiry[] invoiceInquiryData = null;
        
        try {
        	SppTrsI05Event event = (SppTrsI05Event)et;
        	
        	Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", event.getVendorCode());
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		String vndr_dvsn = "S";
    		if (event.getMasterSPP() != null && event.getMasterSPP().equals("M"))
    			vndr_dvsn = event.getMasterSPP();
    		velParam.put("vndr_dvsn", vndr_dvsn);
    		
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(event.getExtInvoiceNo(), ","); 
			velParam.put("inv_no", tmpArrList);
			
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL template = new InvoiceInquiryDBDAOsearchInvoiceInquiryExcelExtractRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            ArrayList inquiryArray = new ArrayList();
            while(rs.next()) {
            	InvoiceInquiry invoiceInquiry = new InvoiceInquiry();
            	invoiceInquiry.setSeq(rs.getInt("rownum"));
            	invoiceInquiry.setInvoiceNo(rs.getString("inv_no"));
            	invoiceInquiry.setWorkOrderNo(rs.getString("wo_no"));
            	invoiceInquiry.setServiceOrderNo(rs.getString("so_no"));
            	invoiceInquiry.setEquipmentNo(rs.getString("eq_no"));
            	invoiceInquiry.setVendorName(rs.getString("vndr_nm"));
            	invoiceInquiry.setInvoiceCurrency(rs.getString("inv_curr_cd"));
            	invoiceInquiry.setInvoiceTotalAMT(rs.getString("inv_ttl_amt"));
            	invoiceInquiry.setIssueDate(rs.getString("inv_iss_dt"));
            	invoiceInquiry.setSubmitDate(rs.getString("inv_rcv_dt"));
            	//2007-04-12 조성환 : 다른 모든 Status에 우선하여 Reject Status 확인
            	if ( rs.getString("inv_rjct_flg").equalsIgnoreCase("Y") && !rs.getString("inv_edi_rslt_cd").equalsIgnoreCase("D")) {
            		invoiceInquiry.setStatus(convertInvoiceStatus("RJ"));
            	}else if ( rs.getString("inv_rjct_flg").equalsIgnoreCase("Y") && rs.getString("inv_edi_rslt_cd").equalsIgnoreCase("D")  ) {
            		invoiceInquiry.setStatus(convertInvoiceStatus("EF"));
            	}else {
            		invoiceInquiry.setStatus(convertInvoiceStatus(rs.getString("status")));
            	}
            	invoiceInquiry.setStatus_cd(rs.getString("status"));
            	invoiceInquiry.setPaidDate(rs.getString("paidDate"));
            	invoiceInquiry.setPaymentMethod(rs.getString("paymentMethod"));
            	invoiceInquiry.setCheckTTNumber(rs.getString("checkTTNumber"));
            	invoiceInquiry.setIfSysKndName(rs.getString("if_sys_knd_name"));
            	invoiceInquiry.setInvRmk(rs.getString("sp_inv_rmk"));
            	
            	invoiceInquiry.setTrspKindNm(rs.getString("trsp_kind_nm"));
            	invoiceInquiry.setTrspModeNm(rs.getString("trsp_mode_nm"));
            	invoiceInquiry.setTrspTypeNm(rs.getString("trsp_type_nm"));
            	invoiceInquiry.setFmNodCd(rs.getString("fm_nod_cd"));
            	invoiceInquiry.setToNodCd(rs.getString("to_nod_cd"));
            	invoiceInquiry.setEqTpszCd(rs.getString("eq_tpsz_cd"));
            	
            	inquiryArray.add(invoiceInquiry);
            }
            invoiceInquiryData = (InvoiceInquiry[])inquiryArray.toArray(new InvoiceInquiry[0]);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return invoiceInquiryData;
        
    }
    
    /**
     * searchInvoiceEquipmentList<br>
     * - Invoice번호로 해당 Invoice에 할당된 Equipment List를 InvoiceCreationInquiry VO로 출력한다.<br>
     * 
     * @param vendorCode String
     * @param invoiceNo String
     * @return invoiceCreationData InvoiceCreationInquiry[]
     * @exception DAOException
     */
    public InvoiceCreationInquiry[] searchInvoiceEquipmentList(String vendorCode, String invoiceNo) throws DAOException {
    	DBRowSet rs = null;
        InvoiceCreationInquiry[] invoiceCreationData = null;
        
        try {

        	String vndr_tmp[] = vendorCode.split("-");
        	        	
	    	if (vndr_tmp != null && vndr_tmp.length == 2) {
	    		//vndr_dvsn = vndr_tmp[0];
	    		vendorCode = vndr_tmp[1];
    	    }else {
    	    	vendorCode = vndr_tmp[0];
    	    }
        	
        	
        	Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq"	, vendorCode);
    		param.put("inv_no"	, invoiceNo);
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    			        
    		InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL template = new InvoiceInquiryDBDAOsearchInvoiceEquipmentListRSQL();	        
    		ArrayList tmpArrList = new ArrayList();
    		tmpArrList  = this.seperationParameter(vendorCode, ",");

			velParam.put("sp_cd", tmpArrList);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            rs = sqlExe.executeQuery(template,param,velParam);
            
            ArrayList inquiryArray = new ArrayList();
            while(rs.next()) {
            	InvoiceCreationInquiry invoiceCreationInquiry = new InvoiceCreationInquiry();
            	
            	//2007-11-22 by KJJ: status가 RC,RJ인 경우에만 수정가능 하도록.
            	if ( !rs.getString("status").equals("RC") && !rs.getString("status").equals("RJ")) {
            		throw new DAOException("System error : this invoice can not modify!");
            	}
            	
            	invoiceCreationInquiry.setSeq(rs.getInt("rownum"));
            	invoiceCreationInquiry.setWorkOrderNo(rs.getString("wo_no"));
            	invoiceCreationInquiry.setWorkOrderType(rs.getString("trsp_cost_dtl_mod_cd"));
            	invoiceCreationInquiry.setEquipmentNoType(rs.getString("eq_knd_cd"));
            	invoiceCreationInquiry.setEquipmentNo(rs.getString("eq_no"));
            	invoiceCreationInquiry.setTypeSize(rs.getString("eq_tpsz_cd"));
            	invoiceCreationInquiry.setBookingNo(rs.getString("bkg_no"));
            	invoiceCreationInquiry.setBl_no(rs.getString("bl_no"));
            	invoiceCreationInquiry.setApnt_dt(rs.getString("apnt_dt"));
            	invoiceCreationInquiry.setDe_dt(rs.getString("de_dt"));
            	invoiceCreationInquiry.setServiceOrderNo(rs.getString("so_no"));
            	
            	inquiryArray.add(invoiceCreationInquiry);
            }
            invoiceCreationData = (InvoiceCreationInquiry[])inquiryArray.toArray(new InvoiceCreationInquiry[0]);

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return invoiceCreationData;
    }

    
    /**
     * convertInvoiceStatus<br>
     * - eNIS의 Invoice Status를 SPP Portal의 Invoice Status 명으로 변환한다.
     * 
     * @param status String
     * @return sResult String
     * @exception DAOException
     */
    private String convertInvoiceStatus(String status) throws DAOException {
    	String sResult = "";
    	
    	if ( status.equals("RC") ) {
    		sResult = "Submitted";	//Received
    	} else if ( status.equals("RJ") ) {
    		sResult = "Rejected";	//Rejected
    	} else if ( status.equals("SV") ) {
    		sResult = "Auditing";	//Saved
    	} else if ( status.equals("DA") ) {
    		sResult = "Auditing";	//Disapproved
    	} else if ( status.equals("CF") ) {
    		sResult = "Auditing";	//Confirmed
    	} else if ( status.equals("RA") ) {
    		sResult = "Processing";	//Request Approval
    	} else if ( status.equals("AR") ) {
    		sResult = "Processing";	//Approval Request
    	} else if ( status.equals("IF") ) {
    		sResult = "Processing";	//Interfaced
    	} else if ( status.equals("PD") ) {
    		sResult = "Paid";	//Paid
    	} else if ( status.equals("EF") ) {
    		sResult = "EDI Transmission Failed";	//Paid
    	} else {
    		sResult = "Undefined";
    	}
    	
    	return sResult;
    }
    
    /**
     * convertPortalInvoiceStatus<br>
     * - SPP Portal의 Invoice Status를 eNIS의 Invoice Status 명으로 변환한다.
     * 
     * @param status String
     * @return sResult String
     * @exception DAOException
     */
    private String convertPortalInvoiceStatus(String status) throws DAOException {
    	String sResult = "";
    	
    	if ( status.equals("Submitted") ) {
    		sResult = "'RC'";	//Received
    	} else if ( status.equals("Rejected") ) {
    		sResult = "'RJ'";	//Rejected
    	} else if ( status.equals("Auditing") ) {
    		sResult = "'SV','DA','CF'";	//Saved, Disapproved, Confirmed
    	} else if ( status.equals("Processing") ) {
    		sResult = "'AR','IF'";	//Approval Request, Interfaced
    	} else if ( status.equals("Paid") ) {
    		sResult = "'PD'";	//Paid
    	} else if ( status.equals("Edi210Fail") ) {
    		sResult = "'EF'";	//Paid
    	} else {
    		sResult = "''";
    	}
        
    	return sResult;
    }
    
    /**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter
	 * @param sSeperate
	 * @return ArrayList
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
    
}
