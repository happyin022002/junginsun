/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceCreationDetailDBDAO.java
*@FileTitle : SPP TRS Invoice Creation Detail DBDAO 
*Open Issues :
*Change history :
* 2007-01-02 sunghwan cho : 신규 작성
* 2007-02-05 sunghwan cho : trs_trsp_expn_conv_amt 테이블 처리
* 2007-03-05 sunghwan cho : work order amount 계산로직 변경 (WO Amount = WO Basic + WO Nego)
* 2007-03-07 sunghwan cho : work order overweight금액을 addtional금액에 합산계산 (WO addtional = WO addtional + WO overweight)
* 2007-03-23 sunghwan cho : trs_trsp_scg_dtl 테이블 구조 변경으로 인한 쿼리변경
* 2007-04-04 sunghwan cho : Submit 기능을 PI eNIS모듈 호출방식으로 변경하여, 관련 루틴 삭제
* 2007-04-04 sunghwan cho : getParentVendorCode, getReceiveDate 추가
* 2007-04-09 sunghwan cho : Creation Detail Inquiry SQL에서 SO 순서 변경
* 2007-04-10 sunghwan cho : parentVendorCode 추가 체크
* 2007-04-23 sunghwan cho : Invoice Office 취득 SQL 변경
*@LastModifyDate : 2007-04-23
*@LastModifier : sunghwan cho
*@LastVersion : 1.9
=========================================================
History
2011.11.29 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : checkMultiCtmMvmt 메소드 파라미터 주석 결함 사항 수정 적용.(1건)
 							  -사용하지 않는 지역 변수를 점검한다 : checkWoAmtCngflag 사용하지 않는 지역변수를 삭제 적용.(6건)   
2012.01.12 윤권영 [CHM-201215602][SPP] Multi invoice creation function 상에 W/O No. 유효성 여부 체크 로직 추가 요청
2012.02.15 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가(1건)
2012.02.20 윤권영 [CHM-201216122][SPP] Cancelled W/O 에 대한 Invoice 처리 불가 메세지 추가건 추가수정(1건)
2012.02.22 윤권영 [] 품질 결함 수정-사용하지 않는 지역 변수를 점검한다 : checkExistWorkOrderNo 사용하지 않는 지역변수를 삭제 적용.(1건)
2012.03.02 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : @return 에 대한 return; 를 추가적용(3건)
2012.03.13 윤권영 [] 품질 결함 수정-메소드 주석을 기술한다 : 메소드 주석 @return 삭제(3건)
2012.04.12 윤권영 [] 오류원인 파악을 위한 로그 강화
2012.06.26 윤권영 [CHM-201218604][SPP] 조회하는 W/O 와 login S/P 의 code 불일치시 Alert 기능 추가(1건)
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.Iterator;

import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creation.event.InvoiceCreationInquiry;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.MultiInvoiceCreationDetailList;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsI02Event;
import com.hanjin.apps.alps.esd.trs.servicesio.invoice.creationdetail.event.SppTrsU02Event;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * DB Data Access Object<br>
 * - SPP TRS Invoice Creation Detail DBDAO<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class InvoiceCreationDetailDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
    /**
     * searchInvoiceCreationDetailList<br>
     * - Invoice 신청을 위한 Equipment 상세 정보를 출력한다.<br>
     * 
     * @param et Event
     * @return invoiceCreationData InvoiceCreationInquiry[]
     * @exception DAOException
     */
    public InvoiceCreationInquiry[] searchInvoiceCreationDetailList(Event et) throws DAOException {
    	DBRowSet rs = null;
        InvoiceCreationInquiry[] invoiceCreationData = null;
        try {

        	SppTrsI02Event event = (SppTrsI02Event)et;

        	/**
        	 * Invoice Creation 화면에서 Fill In Equipment Number 를 한 후의 List를 <br>
        	 * INPUT으로 받아서 세부 정보를 조회한다. Equipment No가 없이는 Invoice Creation Detail로 진행될 수 없다.<br>
        	 * Equipment List 건수 만큼 루프<br>
        	 */
            //2007-10-31 : master ID 추가 관련        	
        	String vndr_seq_tmp[] = event.getVendorCode().split("-");
        	InvoiceCreationInquiry[] invoiceCreationInquiry = event.getInvoiceCreationData();
        	ArrayList soNo = new ArrayList(); 
        	if(invoiceCreationInquiry != null) {
        		for(int i=0;i<invoiceCreationInquiry.length;i++) {
        			soNo.add(invoiceCreationInquiry[i].getServiceOrderNo());
        		}
        	}
        	
        	log.debug("[debug]event.getVendorCode() >> "+event.getVendorCode());
        	log.debug("[debug]vndr_seq_tmp[0] >> "+vndr_seq_tmp[0]);
        	if(vndr_seq_tmp.length == 2)
        		log.debug("[debug]vndr_seq_tmp[1] >> "+vndr_seq_tmp[1]);
			
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		String tmpVndrSeq = "";
    		String tmpVndrDvsn = "S";
    	    if (vndr_seq_tmp != null && vndr_seq_tmp.length == 2) {
    	    	tmpVndrSeq = vndr_seq_tmp[1];
    	    	tmpVndrDvsn = vndr_seq_tmp[0];
    	    }else {
    	    	tmpVndrSeq = vndr_seq_tmp[0];
    	    }
    	    param.put("vndr_seq", tmpVndrSeq);
    		
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("trsp_so_ofc_cty_cd", soNo);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL template = new InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL();	        

            rs = sqlExe.executeQuery(template,param,velParam);
            
            ArrayList noticeArray = new ArrayList();
            String tempWONo = "";

            int subSEQ = 0;
            while(rs.next()) {
            	InvoiceCreationInquiry invoiceCreation = new InvoiceCreationInquiry();
            	if ( rs.getString("wo_no").equals(tempWONo) ) {
            		subSEQ++;
            	} else {
            		tempWONo = rs.getString("wo_no");
            		subSEQ = 1;
            	}
            	
            	//Invoice Creation 과 Invoice Creation Detail 에서 공통으로 필요한 항목
            	invoiceCreation.setSeq(rs.getInt("rownum"));
            	invoiceCreation.setWorkOrderNo(rs.getString("wo_no"));
            	invoiceCreation.setSubSeq(subSEQ);
            	invoiceCreation.setEquipmentNo(rs.getString("eq_no"));
            	invoiceCreation.setTypeSize(rs.getString("eq_tpsz_nm"));
            	invoiceCreation.setBookingNo(rs.getString("bkg_no"));
            	invoiceCreation.setFromNode(rs.getString("fm_yard_nm"));
            	invoiceCreation.setViaNode(rs.getString("via_yard_nm"));
            	invoiceCreation.setToNode(rs.getString("to_yard_nm"));
            	invoiceCreation.setDoorNode(rs.getString("dor_yard_nm"));
            	invoiceCreation.setWorkOrderType(rs.getString("trsp_cost_dtl_mod_cd"));
            	invoiceCreation.setEquipmentNoType(rs.getString("eq_knd_cd"));
            	invoiceCreation.setEquipmentNoType_nm(rs.getString("eq_tp_nm"));
            	invoiceCreation.setTpsz_cd(rs.getString("eq_tpsz_cd"));
            	invoiceCreation.setTpsz_iso_cd(rs.getString("cntr_tpsz_iso_cd"));
            	invoiceCreation.setBl_no(rs.getString("bl_no"));
            	invoiceCreation.setFromNode_cd(rs.getString("fm_nod_cd"));
            	invoiceCreation.setViaNode_cd(rs.getString("via_nod_cd"));
            	invoiceCreation.setToNode_cd(rs.getString("to_nod_cd"));
            	invoiceCreation.setDoorNode_cd(rs.getString("dor_nod_cd"));
            	invoiceCreation.setVndr_seq(rs.getString("vndr_seq"));
            	invoiceCreation.setVendorCode(rs.getString("vndr_seq"));
            	invoiceCreation.setParentVendorCode(rs.getString("prnt_vndr_seq"));
            	invoiceCreation.setOfficeCode(rs.getString("cre_ofc_cd"));
            	invoiceCreation.setServiceOrderNo(rs.getString("so_no"));
            	//Invoice Creation Detail 에서만 필요한 항목
            	invoiceCreation.setWorkOrderCurrency(rs.getString("curr_cd"));
            	//Work Order Amount = Basic Amount + Nego Amount 
            	invoiceCreation.setWorkOrderBasicAmount(String.valueOf(rs.getFloat("bzc_amt") + rs.getFloat("nego_amt")));
            	invoiceCreation.setWorkOrderSurchargeFuel(rs.getString("fuel_scg_amt"));
            	invoiceCreation.setWorkOrderSurchargeVat(rs.getString("scg_vat_amt"));
            	invoiceCreation.setWorkOrderSurchargeOverweight(rs.getString("ovr_wgt_scg_amt"));
            	invoiceCreation.setWorkOrderSurchargeNegoAmt(rs.getString("nego_amt"));
            	invoiceCreation.setWorkOrderSurchargeTollFeeAmt(rs.getString("toll_fee_amt"));
            	invoiceCreation.setWorkOrderSurchargeBzcAmt(rs.getString("bzc_amt"));
            	invoiceCreation.setWorkOrderSurchargeEtcAddAmt(rs.getString("etc_add_amt"));
            	
            	invoiceCreation.setWorkOrderSurchargeAdditional(String.valueOf(rs.getFloat("etc_add_amt") + rs.getFloat("ovr_wgt_scg_amt")));
            	//Work Order Total Amount = Work Order Amount + WO Surcharge
            	float wo_ttl_amt = rs.getFloat("bzc_amt") + rs.getFloat("nego_amt") + rs.getFloat("toll_fee_amt") + rs.getFloat("fuel_scg_amt") + rs.getFloat("scg_vat_amt") + rs.getFloat("ovr_wgt_scg_amt") + rs.getFloat("etc_add_amt");
            	invoiceCreation.setWorkOrderTTLAmount(String.valueOf(wo_ttl_amt));
            	invoiceCreation.setInvoiceBasicAmount(rs.getString("inv_bzc_amt"));
            	invoiceCreation.setSurcharge(String.valueOf(rs.getFloat("inv_surcharge")));
            	//Invoice Total Amount 계산
            	float inv_ttl_amt = rs.getFloat("inv_bzc_amt") + rs.getFloat("inv_surcharge");
            	invoiceCreation.setInvoiceTTLAmount(String.valueOf(inv_ttl_amt));
            	invoiceCreation.setRemark(rs.getString("sp_inv_rmk"));
            	invoiceCreation.setServiceOrderNo(rs.getString("so_no"));
            	invoiceCreation.setCgo_tp_cd(rs.getString("cgo_tp_cd"));
            	
            	invoiceCreation.setExchangeCalculationLogicType(rs.getString("trsp_inv_calc_lgc_tp_cd"));
            	invoiceCreation.setExchangeRate(rs.getString("inv_xch_rt"));
            	invoiceCreation.setInv_vat_amt(rs.getString("inv_vat_amt"));
            	
            	noticeArray.add(invoiceCreation);
            } // end of while

            invoiceCreationData = (InvoiceCreationInquiry[])noticeArray.toArray(new InvoiceCreationInquiry[0]);  
            
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
     * getParentVendorCode<BR>
     * 
     * @param vendorCode int
     * @return iResult int
     * @throws DAOException
     */
    public int getParentVendorCode(int vendorCode) throws DAOException {
    	DBRowSet rs = null;
    	int iResult = 0;
        
        try {
        	
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("vndr_seq", vendorCode);
    		
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL template = new InvoiceCreationDetailDBDAOsearchInvoiceCreationDetailListRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
            
            if ( rs.next() ) {
            	iResult = rs.getInt("prnt_vndr_seq");
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
        return iResult;
    }
    
    /**
     * getCreateOfficeCode<BR>
     * 
     * @param officeCode String
     * @return sResult String
     * @throws DAOException
     */
    public String getCreateOfficeCode(String officeCode) throws DAOException {
    	DBRowSet rs = null;
        String sResult = "";
        
        try {
        	
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("ofc_cd", officeCode);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOgetCreateOfficeCodeRSQL template = new InvoiceCreationDetailDBDAOgetCreateOfficeCodeRSQL();	        

            rs = sqlExe.executeQuery(template,param,velParam);
            
            if ( rs.next() ) {
            	sResult = rs.getString("inv_ofc_cd");
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
        return sResult;
    }
    
    /**
     * getReceiveDate<BR>
     * 
     * @param officeCode String
     * @return sResult String
     * @throws DAOException
     */
    public String getReceiveDate(String officeCode) throws DAOException {
    	DBRowSet rs = null;
        String sResult = "";
        
        try {
        	
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("ofc_cd", officeCode);
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOgetReceiveDateRSQL template = new InvoiceCreationDetailDBDAOgetReceiveDateRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);
    
            if ( rs.next() ) {
            	sResult = rs.getString("rcv_dt");
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
        return sResult;
    }
    
    /**
     * checkMultiInvoiceNo<BR>
     * 
     * @param et Event
     * @return sResult String[]
     * @throws DAOException
     */
    public String[] checkMultiInvoiceNo(Event et) throws DAOException {
    	DBRowSet rs = null;
        String sResult[] = null;
        
        try {

        	SppTrsU02Event event = (SppTrsU02Event)et;
        	
        	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = event.getMultiInvoiceCreationDetailList();
        	
        	ArrayList invNo = new ArrayList();
        	if(multiInvoiceCreationDetailList != null) {
        		for(int i=0;i<multiInvoiceCreationDetailList.length;i++) {
        			invNo.add(multiInvoiceCreationDetailList[i].getInv_no());
        		}
        	}
        	
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("inv_vndr_seq", event.getParentVendorCode());
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		velParam.put("inv_no", invNo);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL template = new InvoiceCreationDetailDBDAOcheckMultiInvoiceNoRSQL();	        

            rs = sqlExe.executeQuery(template,param,velParam);

            ArrayList tmpList = new ArrayList();
            while ( rs.next() ) {
            	tmpList.add(rs.getString("inv_no")+" : Invoice No. Duplicate");
            }
            if(!tmpList.isEmpty()) {
            	sResult = (String[])tmpList.toArray(new String[0]);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            //throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            //throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            //throw new DAOException(e.getMessage());
        }
        return sResult;
    }
    
    /**
     * checkMultiWorkOrderNo<BR>
     * 
     * @param wo_no
     * @param vndr_seq
     * @param invCode
     * @return strResult String
     * @throws DAOException
     */
    public String checkMultiWorkOrderNo(String wo_no,String vndr_seq,String invCode[]) throws DAOException {
    	DBRowSet rs = null;
        String strResult = null;
        try {
      	  
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("wo_vndr_seq", vndr_seq);
    		param.put("trsp_wo_ofc_cty_cd", wo_no.substring(0,3));
    		param.put("trsp_wo_seq", wo_no.substring(3));
    		
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		ArrayList invCodeList = new ArrayList();
        	if(invCode != null) {
        		for(int i=0;i<invCode.length;i++) {
        			invCodeList.add(invCode[i]);
        		}
        	}

    		velParam.put("inv_code", invCodeList);
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL template = new InvoiceCreationDetailDBDAOcheckMultiWorkOrderNoRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,velParam);

            if ( rs.next() ) {
            	strResult = rs.getString("err_msg");
            } 
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            strResult = "Please check work order number.";
            //throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            strResult = "Please check work order number.";
            //throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            strResult = "Please check work order number.";
            //throw new DAOException(e.getMessage());
        }
        return strResult;
    }
    
    /**
     * checkExistMultiWorkOrderNo<BR>
     * 
     * @param wo_no
     * @param vndr_seq
     * @return strResult String
     * @throws DAOException
     */
    public String checkExistMultiWorkOrderNo(String wo_no,String vndr_seq) throws DAOException {
    	DBRowSet rs = null;
        String strResult = null;
        try {
      	  
        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		param.put("WoVndrSeq", vndr_seq);
    		param.put("TrspWoOfcCtyCd", wo_no.substring(0,3));
    		param.put("TrspWoSeq", wo_no.substring(3));
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL template = new InvoiceCreationDetailDBDAOcheckExistMultiWorkOrderNoRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,null);

            if ( rs.next() ) {
            	strResult = rs.getString("err_msg");
            } 
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            strResult = "Please check work order number.";
           // throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            strResult = "Please check work order number.";
          //  throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            strResult = "Please check work order number.";
         //   throw new DAOException(e.getMessage());
        }
        return strResult;
    }
    
    /**
     * checkMultiCtmMvmt<BR>
     * 
     * @param wo_no
     * @param vndr_seq
     * @return strResult String
     * @throws DAOException
     */
    public String checkMultiCtmMvmt(String wo_no,String vndr_seq) throws DAOException {
    	DBRowSet rs = null;
        String strResult = "";
        try {

        	// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		    		
    		param.put("WoVndrSeq", vndr_seq);
    		param.put("TrspWoOfcCtyCd", wo_no.substring(0,3));
    		param.put("TrspWoSeq", wo_no.substring(3));
    		
    		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
    		InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL template = new InvoiceCreationDetailDBDAOgetCntrNoFromSvcOrdRSQL();	        
    	    
            rs = sqlExe.executeQuery(template,param,null);
            while ( rs.next() ) {
	            if(rs.getString("CostDtlModCd").equals("DR")){
	            	
	            	DBRowSet rs2 = null;
	            	String cnmvStsFlg = "N";
	            	
	            	param.put("EqNo",  rs.getString("EqNo"));
	            	param.put("BkgNo", rs.getString("BkgNo"));
	            	param.put("BndCd", rs.getString("BndCd"));
	            	
	            	InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL template2 = new InvoiceCreationDetailDBDAOcheckMultiCtmMvmtRSQL();	        
	            	rs2=sqlExe.executeQuery(template2, param,null);
	            	while ( rs2.next() ) {            		
		            	cnmvStsFlg = rs2.getString("CnmvStsFlg");
		                if(cnmvStsFlg.equals("Y")){
		                	strResult="Cntr Mvmt status is invalid";
		                }else if(cnmvStsFlg.equals("")){
		                	strResult="Contact System admin";
		                }
	                }
	            }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            strResult = "Please check container movement status.";
            //throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            strResult = "Please check container movement status.";
            //throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            strResult = "Please check container movement status.";
            //throw new DAOException(e.getMessage());
        }
        return strResult;
    }
    
    
    /**
     * saveMultiWorkOrderNo<BR>
     * 
     * @param et Event
     * @return iResult int 
     * @throws DAOException
     */
    public int saveMultiWorkOrderNo(Event et) throws DAOException {
        int iResult = 0;
        try {

        	SppTrsU02Event event = (SppTrsU02Event)et;
        	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = event.getMultiInvoiceCreationDetailList();
        	
        	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        	String tmpWorkOrderNo[] = null;
        	InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL template = new InvoiceCreationDetailDBDAOsaveMultiWorkOrderNoUSQL();
        	int[] updCnt = null;
        	if(multiInvoiceCreationDetailList != null) {
        		ArrayList multiInvoiceDate = new ArrayList();
        		for(int i=0;i<multiInvoiceCreationDetailList.length;i++) {
                	tmpWorkOrderNo = multiInvoiceCreationDetailList[i].getWorkOrderNo();
                	for (int j=0;j<tmpWorkOrderNo.length;j++){
            			Map<String, Object> param = new HashMap<String, Object>();
    		    		param.put("inv_no", multiInvoiceCreationDetailList[i].getInv_no());
    		    		param.put("inv_vndr_seq", event.getParentVendorCode());
    		    		param.put("inv_curr_cd", multiInvoiceCreationDetailList[i].getInv_curr_cd());
    		    		param.put("trsp_inv_calc_lgc_tp_cd", multiInvoiceCreationDetailList[i].getExchangeCalculationLogicType());
    		    		param.put("inv_xch_rt", multiInvoiceCreationDetailList[i].getExchangeRate());
    		    		param.put("trsp_inv_act_sts_cd", multiInvoiceCreationDetailList[i].getTrsp_inv_act_sts_cd());
    		    		
    		    		param.put("trsp_wo_ofc_cty_cd", tmpWorkOrderNo[j].substring(0,3));
    		    		param.put("trsp_wo_seq", tmpWorkOrderNo[j].substring(3));
    		    		param.put("wo_vndr_seq", event.getVendorCode());
    		    		
    		    		multiInvoiceDate.add(param);
    		    	}
        		}

	            updCnt = sqlExe.executeBatch(template, multiInvoiceDate, null);

        	}		      
            if(updCnt != null) {
	            for (int i=0;i<updCnt.length;i++) {
	            	iResult += updCnt[i];
	            }
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
        return iResult;
    }
    
    /**
     * saveMultiWorkOrderOpnFlgUpd<BR>
     * 
     * @param et Event
     * @return iResult int
     * @throws DAOException
     */
    public int saveMultiWorkOrderOpnFlgUpd(Event et) throws DAOException {
        int iResult = 0;
        try {
        	
        	SppTrsU02Event event = (SppTrsU02Event)et;
        	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = event.getMultiInvoiceCreationDetailList();
        	
        	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        	String tmpWorkOrderNo[] = null;
        	InvoiceCreationDetailDBDAOsaveMultiWorkOrderOpnFlgUpdUSQL template = new InvoiceCreationDetailDBDAOsaveMultiWorkOrderOpnFlgUpdUSQL();
        	int[] updCnt = null;
        	if(multiInvoiceCreationDetailList != null) {
        		ArrayList multiInvoiceDate = new ArrayList();
        		for(int i=0;i<multiInvoiceCreationDetailList.length;i++) {
                	tmpWorkOrderNo = multiInvoiceCreationDetailList[i].getWorkOrderNo();
            		for (int j=0;j<tmpWorkOrderNo.length;j++){
            			Map<String, Object> param = new HashMap<String, Object>();
    		    		
            			param.put("trsp_wo_ofc_cty_cd", tmpWorkOrderNo[j].substring(0,3));
    		    		param.put("trsp_wo_seq", tmpWorkOrderNo[j].substring(3));
    		    		param.put("wo_vndr_seq", event.getVendorCode());
    		    		
    		    		multiInvoiceDate.add(param);
    		    	}
        		}

	            updCnt = sqlExe.executeBatch(template, multiInvoiceDate, null);

        	}		      
            if(updCnt != null) {
	            for (int i=0;i<updCnt.length;i++) {
	            	iResult += updCnt[i];
	            }
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
        return iResult;
    }
    
    /**
     * saveMultiInvoiceNo<BR>
     * 
     * @param et Event
     * @return iResult int
     * @throws DAOException
     */
    public int saveMultiInvoiceNo(Event et) throws DAOException {
    	DBRowSet rs = null;
        int iResult = 0;
        
        try {
        	
        	SppTrsU02Event event = (SppTrsU02Event)et;

        	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = event.getMultiInvoiceCreationDetailList();
        	ArrayList woNo = new ArrayList(); 
        	String tmpWorkOrderNo[] = null;
        	int[] uCnt = null,iCnt=null;
        	if(multiInvoiceCreationDetailList != null) {
        		ArrayList iMultiInvoiceDate = new ArrayList();
        		ArrayList uMultiInvoiceDate = new ArrayList();
        		
        		SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        		InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL uTemplate = new InvoiceCreationDetailDBDAOsaveMultiInvoiceNoUSQL();	        
        		InvoiceCreationDetailDBDAOsaveMultiInvoiceNoCSQL iTemplate = new InvoiceCreationDetailDBDAOsaveMultiInvoiceNoCSQL();
        		Map<String, Object> uParam = new HashMap<String, Object>();
        		Map<String, Object> iParam = new HashMap<String, Object>();
        		for(int i=0;i<multiInvoiceCreationDetailList.length;i++) {
        			tmpWorkOrderNo = multiInvoiceCreationDetailList[i].getWorkOrderNo();
        			woNo = new ArrayList(); 
        			for(int j=0;j<tmpWorkOrderNo.length;j++) {
        				woNo.add(tmpWorkOrderNo[j]);
        			}
        			
            		// query parameter
            		Map<String, Object> param = new HashMap<String, Object>();
            		param.put("inv_xch_rt", (new Double(multiInvoiceCreationDetailList[i].getExchangeRate()).doubleValue()));
            		param.put("inv_curr_cd", multiInvoiceCreationDetailList[i].getExchangeCalculationLogicType());
            		param.put("wo_vndr_seq", event.getVendorCode());
            		param.put("inv_vndr_seq", event.getParentVendorCode());
            		param.put("inv_no", multiInvoiceCreationDetailList[i].getInv_no());
            		
            		Map<String, Object> velParam = new HashMap<String, Object>();
            		velParam.put("wo_no", woNo);
            		
            		InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL template = new InvoiceCreationDetailDBDAOsaveMultiInvoiceNoRSQL();

                    rs = sqlExe.executeQuery(template,param,velParam);

                    if ( rs.next() ) {
                    	String invBzcAmt = rs.getString("inv_bzc_amt");
                    	String tmpCreOfcCd = rs.getString("cre_ofc_cd");
                    	if(rs.getString("dvsn").equals("N")) {
                    		iParam = new HashMap<String, Object>();
                    		iParam.put("inv_no"              ,multiInvoiceCreationDetailList[i].getInv_no());
                    		iParam.put("inv_vndr_seq"        ,event.getParentVendorCode());
                    		iParam.put("trsp_inv_aud_sts_cd" ,multiInvoiceCreationDetailList[i].getTrsp_inv_aud_sts_cd());
                    		iParam.put("wo_vndr_seq"         ,event.getVendorCode());
                    		iParam.put("inv_curr_cd"         ,multiInvoiceCreationDetailList[i].getInv_curr_cd());
                    		iParam.put("inv_bzc_amt"         ,invBzcAmt);
                    		iParam.put("inv_vat_amt"         ,multiInvoiceCreationDetailList[i].getInv_vat_amt());
                    		iParam.put("inv_ttl_amt"         ,invBzcAmt);
                    		iParam.put("if_sys_knd_cd"       ,multiInvoiceCreationDetailList[i].getIf_sys_knd_cd());
                    		iParam.put("delt_flg"            ,"N");
                    		iParam.put("cre_usr_id"          ,multiInvoiceCreationDetailList[i].getIf_usr_id());
                    		iParam.put("upd_usr_id"          ,multiInvoiceCreationDetailList[i].getIf_usr_id());
                    		iParam.put("prov_usr_id"         ,event.getUserID());
                    		iParam.put("prov_phn_no"         ,event.getVendorPhoneNo());
                    		iParam.put("cre_ofc_cd"          ,tmpCreOfcCd);
                    		iMultiInvoiceDate.add(iParam);
                    	} else {
                    		uParam = new HashMap<String, Object>();
                    		uParam.put("trsp_inv_aud_sts_cd", multiInvoiceCreationDetailList[i].getTrsp_inv_aud_sts_cd());
                    		uParam.put("inv_curr_cd", multiInvoiceCreationDetailList[i].getInv_curr_cd());
                    		uParam.put("inv_bzc_amt", invBzcAmt);
                    		uParam.put("inv_vat_amt", multiInvoiceCreationDetailList[i].getInv_vat_amt());
                    		uParam.put("inv_ttl_amt", invBzcAmt);
                    		uParam.put("vndr_seq", event.getVendorCode());
                    		uParam.put("if_sys_knd_cd", multiInvoiceCreationDetailList[i].getIf_sys_knd_cd());
                    		uParam.put("upd_usr_id", multiInvoiceCreationDetailList[i].getIf_usr_id());
                    		uParam.put("prov_usr_id", event.getUserID());
                    		uParam.put("prov_phn_no", event.getVendorPhoneNo());
                    		uParam.put("inv_no", multiInvoiceCreationDetailList[i].getInv_no());
                    		uParam.put("inv_vndr_seq", event.getParentVendorCode());
                    		uMultiInvoiceDate.add(uParam);
                    	}
                    }
        		}
        		uCnt = sqlExe.executeBatch(uTemplate, uMultiInvoiceDate, null);
        		iCnt = sqlExe.executeBatch(iTemplate, iMultiInvoiceDate, null);
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
        return iResult;
    }
    
    /**
     * saveMultiInvoiceLog<BR>
     * 
     * @param et Event
     * @return sResult
     * @throws DAOException
     */
    public int saveMultiInvoiceLog(Event et) throws DAOException {
        int iResult = 0;
        try {

        	SppTrsU02Event event = (SppTrsU02Event)et;
        	MultiInvoiceCreationDetailList multiInvoiceCreationDetailList[] = event.getMultiInvoiceCreationDetailList();
        	
        	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        	InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL template = new InvoiceCreationDetailDBDAOsaveMultiInvoiceLogCSQL();
        	int[] updCnt = null;
        	if(multiInvoiceCreationDetailList != null) {
        		ArrayList multiInvoiceDate = new ArrayList();
        		for(int i=0;i<multiInvoiceCreationDetailList.length;i++) {
        			Map<String, Object> param = new HashMap<String, Object>();
        			param.put("inv_no", multiInvoiceCreationDetailList[i].getInv_no());
		    		param.put("inv_vndr_seq", event.getParentVendorCode());
		    		multiInvoiceDate.add(param);
        		}

	            updCnt = sqlExe.executeBatch(template, multiInvoiceDate, null);

        	}		      
            if(updCnt != null) {
	            for (int i=0;i<updCnt.length;i++) {
	            	iResult += updCnt[i];
	            }
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
        return iResult;
    }
    
   /**
     * checkWOAmountChange<BR>
     * 
     * @param et Event
     * @throws DAOException
     */
    public void checkWOAmountChange(Event et) throws DAOException {
        	
    		DBRowSet rs = null;
        	SppTrsU02Event event = (SppTrsU02Event)et;
        	
        	String vndr_seq = event.getVendorCode();
        	InvoiceCreationInquiry[] invCreDt = event.getInvoiceCreationData();
        	
        	String currChgFlg = "N";
			String bzcChgFlg  = "N";
			String etcChgFlg  = "N";
			String fuelChgFlg = "N";
			String vatChgFlg  = "N";
			String negoChgFlg = "N";
			String tollChgFlg = "N";
			String eqNo		  = "";
        	
        try {
        	ArrayList tmpList = new ArrayList();
        	
        	Map<String, Object> param = new HashMap<String, Object>();
        	for(int i=0 ; i<invCreDt.length ; i++ ){
         		
        		param.put("CURR_CD", invCreDt[i].getWorkOrderCurrency());
            	param.put("BZC_AMT", invCreDt[i].getWorkOrderSurchargeBzcAmt());
            	param.put("ETC_ADD_AMT", invCreDt[i].getWorkOrderSurchargeEtcAddAmt());
            	param.put("FUEL_SCG_AMT", invCreDt[i].getWorkOrderSurchargeFuel());
            	param.put("SCG_VAT_AMT", invCreDt[i].getWorkOrderSurchargeVat());
            	param.put("NEGO_AMT", invCreDt[i].getWorkOrderSurchargeNegoAmt());
            	param.put("TOLL_FEE_AMT", invCreDt[i].getWorkOrderSurchargeTollFeeAmt());
            	param.put("SO_NO_OFC_CTY", invCreDt[i].getServiceOrderNo().substring(0,3));
            	param.put("SO_NO_SEQ", invCreDt[i].getServiceOrderNo().substring(3));
             	param.put("VNDR_SEQ", vndr_seq);
             	
             	log.error("CURR_CD : " + invCreDt[i].getWorkOrderCurrency());
             	log.error("BZC_AMT : " + invCreDt[i].getWorkOrderSurchargeBzcAmt());
             	log.error("ETC_ADD_AMT : " + invCreDt[i].getWorkOrderSurchargeEtcAddAmt());
             	log.error("FUEL_SCG_AMT : " + invCreDt[i].getWorkOrderSurchargeFuel());
             	log.error("SCG_VAT_AMT : " + invCreDt[i].getWorkOrderSurchargeVat());
             	log.error("NEGO_AMT : " + invCreDt[i].getWorkOrderSurchargeNegoAmt());
             	log.error("TOLL_FEE_AMT : " + invCreDt[i].getWorkOrderSurchargeTollFeeAmt());
             	log.error("SO_NO_OFC_CTY : " + invCreDt[i].getServiceOrderNo().substring(0,3));
             	log.error("SO_NO_SEQ : " + invCreDt[i].getServiceOrderNo().substring(3));
             	log.error("VNDR_SEQ : " + vndr_seq);
             	
             	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        		InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL template = new InvoiceCreationDetailDBDAOcheckChangeWOAmountRSQL();
        		rs = sqlExe.executeQuery(template,param,null);
        		
        		if(rs != null && rs.next()){
        			currChgFlg = rs.getString("CurrChgFlg");
        			bzcChgFlg  = rs.getString("BzcChgFlg");
        			etcChgFlg  = rs.getString("EtcChgFlg");
        			fuelChgFlg = rs.getString("FuelChgFlg");
        			vatChgFlg  = rs.getString("VatChgFlg");
        			negoChgFlg = rs.getString("NegoChgFlg");
        			tollChgFlg = rs.getString("TollChgFlg");
        			eqNo 	   = rs.getString("EqNo");
        			
        			if(currChgFlg.equals("Y") || bzcChgFlg.equals("Y") || etcChgFlg.equals("Y") || fuelChgFlg.equals("Y") || 
        					vatChgFlg.equals("Y") || negoChgFlg.equals("Y") || tollChgFlg.equals("Y")){
        				tmpList.add(eqNo);
        			}
        		}
        	}
        	
        	String errEqNo = "";
        	if(tmpList.toArray().length > 0){
        		if(tmpList.toArray().length == 1 ){
	        		errEqNo = (String) tmpList.get(0);
	        	}else{
	        		for(int i=0 ; i<tmpList.toArray().length ; i++ ){
	        			if(i == 0)
	        				errEqNo = (String) tmpList.get(i);
	        			if(i > 0)
	        				errEqNo = errEqNo+":"+(String) tmpList.get(i);
	        		}
	        	}
	        	throw new EventException("The amount of W/O was changed by ALPS system. Verify and Recreate after canceling the invoice you already created.\\n"+errEqNo);
        	}
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return;
    }
    
    /**
     * checkContainerMovementStatus<BR>
     * 
     * @param et Event
     * @throws DAOException
     */
    public void checkContainerMovementStatus(Event et) throws DAOException {
        	
    		DBRowSet rs = null;
        	SppTrsU02Event event = (SppTrsU02Event)et;
        	
        	String vndr_seq = event.getVendorCode();
        	InvoiceCreationInquiry[] invCreDt = event.getInvoiceCreationData();
        	
			String eqNo		  = "";
			String cnmvStsFlg = "N";
        	
        try {
        	ArrayList tmpList = new ArrayList();
        	
        	Map<String, Object> param = new HashMap<String, Object>();
        	for(int i=0 ; i<invCreDt.length ; i++ ){

            	param.put("SO_NO_OFC_CTY", invCreDt[i].getServiceOrderNo().substring(0,3));
            	param.put("SO_NO_SEQ", invCreDt[i].getServiceOrderNo().substring(3));
             	param.put("VNDR_SEQ", vndr_seq);
             	
             	SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
        		InvoiceCreationDetailDBDAOcheckCtmMvmtStatusRSQL template = new InvoiceCreationDetailDBDAOcheckCtmMvmtStatusRSQL();
        		rs = sqlExe.executeQuery(template,param,null);
        		
        		if(rs != null && rs.next()){
        			eqNo 	   = rs.getString("EqNo");
        			cnmvStsFlg = rs.getString("CnmvStsFlg");
        			        			
        			if(cnmvStsFlg.equals("Y")){
        				tmpList.add(eqNo);
        			}
        		}
        	}
        	
        	String errEqNo = "";   	
        	if(tmpList.toArray().length > 0){
        		if(tmpList.toArray().length == 1 ){
	        		errEqNo = (String) tmpList.get(0);
	        	}else{
	        		for(int i=0 ; i<tmpList.toArray().length ; i++ ){
	        			if(i == 0)
	        				errEqNo = (String) tmpList.get(i);
	        			if(i > 0)
	        				errEqNo = errEqNo+":"+(String) tmpList.get(i);
	        		}
	        	}
        		throw new EventException("According to current movement status, subject CNTR(s) is(are) not transported yet. Only transported CNTR(s) can be invoiced.\\n"+errEqNo);
        	}
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return;
    }   
    
    /**
     * checkExistWorkOrderNo<BR>
     * 
     * @param et Event
     * @throws DAOException
     */
    public void checkExistWorkOrderNo(Event et) throws DAOException {
    	
		DBRowSet rs = null;
    	InvoiceCreationInquiry[] invCreDt = null;
    	ArrayList tmpArrList = null;
    	ArrayList tmpList = null;
    	ArrayList tmpList1 = null;
    	ArrayList tmpList2 = null;
    	TreeSet t = new TreeSet();
    	
		String notExtFlg = "N";
		
	    try {
	    	
	    	SppTrsU02Event event = (SppTrsU02Event)et;
	    	invCreDt = event.getInvoiceCreationData();
	    	String vndr_seq = event.getVendorCode();
	    	
	    	for(int i=0 ; i<invCreDt.length ; i++ ){
	    		t.add(invCreDt[i].getWorkOrderNo());    		
	    	}
	    	
	    	tmpList = new ArrayList();
	    	tmpList1 = new ArrayList();
	    	tmpList2 = new ArrayList();
	    	tmpArrList = new ArrayList();
	    	Iterator it = t.iterator();
	    	
	    	while(it.hasNext()){
	    		tmpArrList.add((String) it.next());	//중복값을 제거하기 위해
	    	}
	    	
	    	Map<String, Object> param = new HashMap<String, Object>();
	    	for(int i = 0 ; i < tmpArrList.toArray().length; i++){
	    		param.put("WO_NO", tmpArrList.get(i));
	    		param.put("VNDR_SEQ", vndr_seq);
	
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL template = new InvoiceCreationDetailDBDAOcheckExistWorkOrderNoRSQL();
				rs = sqlExe.executeQuery(template,param,null);
		    	
				if(rs != null && rs.next()){
					notExtFlg = rs.getString("notExtFlg");
					if("1".equals(notExtFlg)){
						tmpList1.add(tmpArrList.get(i));
					}else if("2".equals(notExtFlg)){
						tmpList2.add(tmpArrList.get(i));
					}
				}else{
					tmpList.add(tmpArrList.get(i));
				}
	    	}
	    	
	    	String errWoNo = "";
	    	
	    	if(tmpList.toArray().length > 0){
	    		if(tmpList.toArray().length == 1 ){
	    			errWoNo = (String) tmpList.get(0);
	        	}else{
	        		for(int i=0 ; i<tmpList.toArray().length ; i++ ){
	        			if(i == 0)
	        				errWoNo = (String) tmpList.get(i);
	        			if(i > 0)
	        				errWoNo = errWoNo+","+(String) tmpList.get(i);
	        		}
	        	}
	    		throw new EventException("There is no existing W/O number. Verify W/O number again.\\n(W/O No. : "+errWoNo+")");
	    	}
	    	
	    	if(tmpList1.toArray().length > 0){
	    		if(tmpList1.toArray().length == 1 ){
	    			errWoNo = (String) tmpList1.get(0);
	        	}else{
	        		for(int i=0 ; i<tmpList1.toArray().length ; i++ ){
	        			if(i == 0)
	        				errWoNo = (String) tmpList1.get(i);
	        			if(i > 0)
	        				errWoNo = errWoNo+","+(String) tmpList1.get(i);
	        		}
	        	}
	    		throw new EventException("S/P code over the W/O No. is not compatible with it under your account.\\n(W/O No. : "+errWoNo+")");
	    	}
	    	
	    	if(tmpList2.toArray().length > 0){
	    		if(tmpList2.toArray().length == 1 ){
	    			errWoNo = (String) tmpList2.get(0);
	        	}else{
	        		for(int i=0 ; i<tmpList2.toArray().length ; i++ ){
	        			if(i == 0)
	        				errWoNo = (String) tmpList2.get(i);
	        			if(i > 0)
	        				errWoNo = errWoNo+","+(String) tmpList2.get(i);
	        		}
	        	}
	    		throw new EventException("W/O under the invoice is cancelled status on HJS’s internal system. Please contact HJS traffic office first to verify the problem.\\n(Cancelled W/O No. : "+errWoNo+")");
	    	}
	    } catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return;
    }

}
