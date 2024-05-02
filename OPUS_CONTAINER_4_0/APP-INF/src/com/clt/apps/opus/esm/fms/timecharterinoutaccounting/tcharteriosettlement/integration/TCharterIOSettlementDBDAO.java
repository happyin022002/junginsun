/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementDBDAO.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS TCharterIOSettlementDBDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon, Seyeong
 * @see TCharterIOSettlementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class TCharterIOSettlementDBDAO extends DBDAOSupport {

	/**
	 * 미 정리된 선급금 전표를 조회한다.<br>
	 * 
	 * @param condSearchPrepaymentSettleVO CondSearchPrepaymentSettleVO
	 * @param account SignOnUserAccount
	 * @return List<SearchPrepaymentSettleListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 public List<SearchPrepaymentSettleListVO> searchPrepaymentSettleList(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO, SignOnUserAccount account) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchPrepaymentSettleListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				if(condSearchPrepaymentSettleVO != null){
					Map<String, String> mapVO = condSearchPrepaymentSettleVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					param.put("ofc_cd",account.getOfc_cd());
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleListVO .class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
	 
	/**
	 * 미 정리된 선급금 전표를 항차별로 분리한다.<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdList(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPrepaymentSettleVvdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(condSearchPrepaymentSettleVvdVO != null){
				Map<String, String> mapVO = condSearchPrepaymentSettleVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOSettlementDBDAOSearchPrepaymentSettleVvdListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrepaymentSettleVvdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
}