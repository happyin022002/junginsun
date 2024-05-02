/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOthCommDBDAO.java
*@FileTitle : Commission Unit Cost Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.13
*@LastModifier : 추경원
*@LastVersion : 1.0
* 2009.08.13 추경원
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.agt.agtagreement.agtothcomm.basic.AGTOthCommBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.AgtOtrUtCostVO;


/**
 * ALPS AGTOthCommDBDAO <br>
 * - ALPS-AGTAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kyung-won Chu
 * @see AGTOthCommBCImpl 참조
 * @since J2EE 1.6
 */
public class AGTOthCommDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param AgtOtrUtCostVO agtOtrUtCostVO
	 * @return List<AgtOtrUtCostVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtOtrUtCostVO> searchOtherUnitCostInfoList(AgtOtrUtCostVO agtOtrUtCostVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtOtrUtCostVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtOtrUtCostVO != null){
				Map<String, String> mapVO = agtOtrUtCostVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOthCommDBDAOAgtOtrUtCostVO1RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtOtrUtCostVO .class);
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
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param AgtOtrUtCostVO agtOtrUtCostVO
		 * @return List<AgtOtrUtCostVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<AgtOtrUtCostVO> searchUpdateDate(AgtOtrUtCostVO agtOtrUtCostVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<AgtOtrUtCostVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(agtOtrUtCostVO != null){
					Map<String, String> mapVO = agtOtrUtCostVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOthCommDBDAOAgtOtrUtCostVO2RSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtOtrUtCostVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
}