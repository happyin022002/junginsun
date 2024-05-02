/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableEDIReceiveDBDAO.java
 *@FileTitle : Glovis EDI Submission
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.25
 *@LastModifier : 이석준
 *@LastVersion : 1.0
 * 2009.05.04 이석준
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.02.14 최도순 [CHM-201006644] NIKE, Invoice EDI 신규 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic.AccountReceivableEDISendBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.InvEdiGlovisHdrVO;
import com.hanjin.syscommon.common.table.InvEdiAckVO;

/**
 * ALPS AccountReceivableEDIReceiveDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *  
 * @author saeil kim
 * @see AccountReceivableEDISendBCImpl 참조
 * @since J2EE 1.4
 */
public class AccountReceivableEDIReceiveDBDAO extends DBDAOSupport {
	
	/**
	 * INV_EDI_GLOVIS_HDR 테이블 데이터를 갱신한다.<br>
	 * 
	 * @param InvEdiGlovisHdrVO invEdiGlovisHdrVO
	 * @return int 
	 * @exception DAOException
	 */                  
    public int modifyInvEdiGlovisHdr(InvEdiGlovisHdrVO invEdiGlovisHdrVO ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			
			if (invEdiGlovisHdrVO !=null){
				Map<String, String> mapVO = invEdiGlovisHdrVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
	
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableEDIReceiveDBDAOGlovisEDIUSQL(), param, velParam);
				log.error(">Glovis EDI Message NO>>>>>>>>>>>>>>>>>>"+result);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return result;
    }
    
    /**
	 * INV_EDI_GLOVIS_HDR 테이블 데이터를 갱신한다.<br>
	 * 
	 * @param InvEdiAckVO invEdiAckVO
	 * @return int 
	 * @exception DAOException
	 */                  
    public int insertInvEdiAck(InvEdiAckVO invEdiAckVO ) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			
			if (invEdiAckVO !=null){
				Map<String, String> mapVO = invEdiAckVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
	
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AccountReceivableEDIReceiveDBDAOInvEdiAckCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return result;
    }
}
