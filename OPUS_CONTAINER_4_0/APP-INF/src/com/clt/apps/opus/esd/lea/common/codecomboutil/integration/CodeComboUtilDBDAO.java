/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LogisticsExpenseAccrualSC.java
*@FileTitle : Rev.VVD Inquiry (Pop-up)
*Open Issues :
*Change history : 2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.07.31
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.07.31 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.common.codecomboutil.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/** 
 * Cost Code Combo LIST <br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.4
 */
public class CodeComboUtilDBDAO extends DBDAOSupport {

	/**
	 * Cost Code Combo List를 조회한다.<br>
	 * @param String sCostKind 
	 * @param String sMainCostTypeCode
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCostCodeComboList(String sCostKind, String sMainCostTypeCode)	throws DAOException {
		DBRowSet 			dRs 		= null; 							// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param 		= new HashMap<String, Object>();	//parameter
		Map<String, Object> velParam	= new HashMap<String, Object>();	//velocity parameter
		try {
			
			param.put	("costkind"			, sCostKind			);	
			param.put	("maincosttypecode"	, sMainCostTypeCode	);
			
			velParam.put("costkind"			, sCostKind			);
			velParam.put("maincosttypecode"	, sMainCostTypeCode	);
			
			dRs = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new CodeComboUtilDBDAOSearchComboListRSQL(), param, velParam);
			
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dRs;
	}
	
}
