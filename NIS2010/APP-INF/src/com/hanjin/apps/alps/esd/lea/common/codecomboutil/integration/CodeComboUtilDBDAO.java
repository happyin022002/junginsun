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
* @History
* 2011-05-02 이정수 : Office COMBO가 정상적으로 생성되도록 수정
* 2015-06-19 [CHM-201536354]CSR Inquiry 화면 신규 생성- Control Office 추가 
=========================================================*/
package com.hanjin.apps.alps.esd.lea.common.codecomboutil.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.lea.common.codecomboutil.event.CodeInfo;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchCostCodeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


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
	
	
    /**
	 * 공통코드에서 목록을 조회한다..<br>
	 * COM_INTG_CD_DTL
	 * 
	 * @param  code
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsOfficeCodeList(String code) throws DAOException {
		log.debug("\n LEA Common searchLogisticsOfficeCodeList \n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			param.put("code", code );
			velParam.put("code", code );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeComboUtilDBDAOSearchLogisticsOfficeCodeListRSQL(), param, velParam);

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

		return dbRowset;
	}
	
	
	/**
	 * 해당 Logistics Office 에 대한 Sub Office List 정보를 조회한다.
	 * 
	 * @param String code
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchLogisticsSubOfficeCodeList(String code) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("code", code );
//			velParam.put("code", code );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeComboUtilDBDAOSearchLogisticsSubOfficeCodeListRSQL(), param, null);

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

		return dbRowset;
	}

	/**
	 * 해당 RHQ 에 대한 Control Office List 정보를 조회한다.
	 * 
	 * @param String rhqCd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCtrlOfficeCodeList(String rhqCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("rhq_cd", rhqCd );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CodeComboUtilDBDAOSearchCtrlOfficeCodeListRSQL(), param, null);

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
		return dbRowset;
	}
	
}
