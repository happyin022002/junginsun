/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PaymentInvoiceDBDAO.java
*@FileTitle : 지불전표 DAO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.22
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.02.22 진윤오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.basic.PaymentInvoiceBCImpl;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.ArRevenueVVDVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListCondVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.VendorInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;



/**
 * NIS2010 PaymentInvoiceDBDAO <br>
 * - 지불전표 Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jyo
 * @see PaymentInvoiceBCImpl 참조
 * @since J2EE 1.4
 */
public class PaymentInvoiceDBDAO extends DBDAOSupport {
	
	
	// 진윤오  ===========================================================================	
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0048] CSR Manager
	// ---------------------------------------------------------------------------
	
	/**
	 * CSR Manager 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0048
	 * @category searchCsrManagerList 
	 * @param CsrManagerListCondVO condVo
     * @return List<CsrManagerListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CsrManagerListVO> searchCsrManagerList(CsrManagerListCondVO condVo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CsrManagerListVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            param = condVo.getColumnValues();          
            // CNI 
            param.put("src_ctnt",  "SO_CCC");            
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchCsrManagerListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsrManagerListVO.class);
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0045] Invoice Creation
	// ---------------------------------------------------------------------------
	
	/**
	 * Payment Invoice 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceList 
	 * @param String cgoClmNo
	 * @param String hdlrUsrId
     * @return List<PaymentInvoiceVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentInvoiceVO> searchPaymentInvoiceList(String cgoClmNo , String hdlrUsrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PaymentInvoiceVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	param.put("cgo_clm_no", cgoClmNo);
        	param.put("hdlr_usr_id", hdlrUsrId);
        	param.put("cgo_clm_pay_no", null);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchPaymentInvoiceListRSQL(), param, velParam);
            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentInvoiceVO.class);
            return list;
            
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }
  
	/**
	 * Payment Invoice 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceInfo
	 * @param String cgoClmPayNo
     * @return PaymentInvoiceVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public PaymentInvoiceInfoVO searchPaymentInvoiceInfo(String cgoClmPayNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PaymentInvoiceInfoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	param.put("cgo_clm_pay_no", cgoClmPayNo);        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchPaymentInvoiceInfoRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentInvoiceInfoVO.class);
                        
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
                 
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }   
    
	/**
	 * 비용처리오피스 취득
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchCostOfcCd
	 * @param String ofcCd
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchCostOfcCd(String ofcCd) throws DAOException {
        DBRowSet dbRowset = null;
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	param.put("ofc_cd", ofcCd);        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchCostOfcCdRSQL(), param, velParam);            
            
            if(dbRowset.next()) {
            	return dbRowset.getString(1);
            }
                 
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }      
    
	/**
	 * Vendor 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchVendorInfo
	 * @param String vndrSeq
     * @return VendorInfoVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public VendorInfoVO searchVendorInfo(String vndrSeq) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<VendorInfoVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	param.put("vndr_seq", vndrSeq);        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchVendorInfoRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, VendorInfoVO.class);
                        
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
                 
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }       
    
	/**
	 * Revenue  재무항차 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchArRevenueVVD
	 * @param ArRevenueVVDVO vo
     * @return ArRevenueVVDVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ArRevenueVVDVO searchArRevenueVVD(ArRevenueVVDVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ArRevenueVVDVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();            
            param = vo.getColumnValues();        	
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchArRevenueVVDRSQL(), param, velParam);            
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArRevenueVVDVO.class);
                        
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
                 
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }     
    
	/**
	 * 공통항차 ONLINE 상태의 재무항차(YYMM) 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchApPeriodOnlineVoyNo
	 * @param String invIssDt
	 * @param String costOfcCd 
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchApPeriodOnlineVoyNo(String invIssDt , String costOfcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();            
            param.put("inv_iss_dt", invIssDt);     
            param.put("cost_ofc_cd", costOfcCd);
            
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchApPeriodOnlineVoyNoRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            } 
            
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }        
    
	/**
	 * 공통항차 Close된경우 재무항차(YYMM) 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchApPeriodCloseVoyNo
	 * @param String invIssDt
	 * @param String costOfcCd 
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchApPeriodCloseVoyNo(String invIssDt , String costOfcCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        try{    
        	// query parameter
            Map<String, String> param = new HashMap<String, String>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();            
            param.put("inv_iss_dt", invIssDt);     
            param.put("cost_ofc_cd", costOfcCd);
            
        	// velocity parameter 설정 
            velParam.putAll(param);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PaymentInvoiceDBDAOSearchApPeriodCloseVoyNoRSQL(), param, velParam);            
            
            if (dbRowset.next()) {
            	return dbRowset.getString(1);
            } 
            
            return null;
          
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
        
    }            
    
}
