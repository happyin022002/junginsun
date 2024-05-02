/*=========================================================
*Copyright(c) 2007 CyberLogitec
*@FileName : Edi214ReceiveDBDAO.java
*@FileTitle : Service Scope
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-01
*@LastModifier : Y
*@LastVersion : 1.0
* 2008-08-01 Y
* 1.0 최초 생성
=========================================================*/


package com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.basic.Edi214ReceiveBCImpl;
import com.clt.apps.opus.esd.sce.visibilitymanage.edi214Receive.vo.SearchActualDateInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yjlee
 * @see Edi214ReceiveBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi214ReceiveDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * EDI HDR 임시 저장하기
	 * @param SearchActualDateInfoVO msgVO
	 * @throws DAOException
	 */
	public void createEDI214TmpData(SearchActualDateInfoVO msgVO) throws DAOException {
		log.debug("createEDI214TmpData를 실행합니다.");
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{        	
        	if (msgVO != null) {
				Map<String, String> mapVO = msgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			sqlExe.executeUpdate(new Edi214ReceiveDBDAOCreateEDI214TmpDataCSQL(), param, null);
			return ;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * EDI로 접수된 data의 유효성을 체크한다.
	 * @param SearchActualDateInfoVO msgVo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet validateEDI214(SearchActualDateInfoVO msgVo) throws DAOException {
		log.debug("validateEDI214를 실행합니다.");
    	DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String cop_no = "";

		try {
			if (msgVo != null) {
				Map<String, String> mapVO = msgVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("param"+ param);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi214ReceiveDBDAOSearchValidateEdi214RSQL(),
					param, velParam);

			log.debug("dbRowset.getRowCount == " + dbRowset.getRowCount());
			if(dbRowset.next()) {
				cop_no = dbRowset.getString("COP_NO");
            	log.debug("cop_seq(if-in) == " + cop_no);
            }
			log.debug("cop_seq(if-out) == " + cop_no);
            
			return dbRowset;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * SearchActualDateInfoVO msgVo
	 * 
	 * @param SearchActualDateInfoVO msgVo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet callSceEstDue(SearchActualDateInfoVO msgVo) throws DAOException {
        log.debug("DAO - callSceEstDue 시작");
        DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
        try{        	
        	if (msgVo != null) {
				Map<String, String> mapVO = msgVo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			    log.debug("VO-param:"+ param);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new Edi214ReceiveDBDAOSearchCallSceEstDueRSQL(),
					param, velParam);
        } catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/** 
	 * COP에 Actual Date를 Update 한다. 
	 * @param SearchActualDateInfoVO msgVo
	 * @param String cop_seq
	 * @return int
	 * @throws DAOException
	 */
	public int modifyEDI214ActualDate(SearchActualDateInfoVO msgVo, String cop_seq)  throws DAOException {
		log.debug("DAO - modifyEDI214ActualDate 를 시작");
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
        try{        	
        	if (msgVo != null) {
        		msgVo.setCopSeq(cop_seq);
				Map<String, String> mapVO = msgVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	SQLExecuter sqlExe = new SQLExecuter("");
			log.debug("param==" + param);
			log.debug("velParam==" + velParam);
			
			result = sqlExe.executeUpdate(new Edi214ReceiveDBDAOModifyEDI214ActualDateUSQL(),
					param, null);
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}