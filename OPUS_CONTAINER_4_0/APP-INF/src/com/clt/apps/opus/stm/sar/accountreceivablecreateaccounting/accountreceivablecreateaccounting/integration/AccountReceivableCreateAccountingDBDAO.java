/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableCreateAccountingDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.vo.CreateOtsLedgerListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountReceivableCreateAccountingDBDAO <br>
 * - AccountReceivableCreateAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see AccountReceivableCreateAccountingBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableCreateAccountingDBDAO extends DBDAOSupport {
	/**
     * Ledger OTS Creation<br><br>
     * 
     * @author YJLEE
     * @category STM_SAR_4003
     * @category searchCreateOtsLedgerList
     * @param CreateOtsLedgerListVO createOtsLedgerListVO       
     * @return List<CreateOtsLedgerListVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CreateOtsLedgerListVO> searchCreateOtsLedgerList(CreateOtsLedgerListVO createOtsLedgerListVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CreateOtsLedgerListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
       try {	
    	   
    	   if(createOtsLedgerListVO != null){
				Map<String, String> mapVO = createOtsLedgerListVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//System.out.println("log test" + CreateOtsLedgerListVO.getVvd());
			}
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableCreateAccountingDBDAOsearchCreateOtsLedgerListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, CreateOtsLedgerListVO.class);             
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
	 * Ledger OTS Creation function currency<br>
	 * 
     * @author YJLEE
     * @category STM_SAR_4003
     * @category searchPaymentRequestLetterSeq
     * @return String
     * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchLedgerFunctionCurrency() throws DAOException {
		DBRowSet dbRowset = null;
		String sFunc = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountReceivableCreateAccountingDBDAOsearchLedgerFunctionCurrencyRSQL(), param, velParam);											
			if(dbRowset.next()){
				sFunc = dbRowset.getString("func_curr");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sFunc;
	}	
}