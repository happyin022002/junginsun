/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InterfaceScheduleToIBISDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPfSkdDtlIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskPortNworkIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslPortSkdIbisIfVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfacetoexternalibis.vo.VskVslSkdIbisIfVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see InterfaceScheduleToIBISBCImpl
 * @since J2EE 1.4
 */
public class InterfaceScheduleToIBISDBDAO extends DBDAOSupport {

	/**
	 * insert VSK_PF_SKD
	 * 
	 * @param VskPfSkdIbisIfVO vskPfSkdIbisIfVO
	 * @throws DAOException
	*/
	public void insertVskPfSkd(VskPfSkdIbisIfVO vskPfSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskPfSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPfSkdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * update VSK_PF_SKD
	 * 
	 * @param VskPfSkdIbisIfVO vskPfSkdIbisIfVO
	 * @throws DAOException
	*/
	public void updateVskPfSkd(VskPfSkdIbisIfVO vskPfSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskPfSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPfSkdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	
	/**
	 * insert VSK_PF_SKD_DTL
	 * 
	 * @param VskPfSkdDtlIbisIfVO vskPfSkdDtlIbisIfVO
	 * @throws DAOException
	*/
	public void insertVskPfSkdDtl(VskPfSkdDtlIbisIfVO vskPfSkdDtlIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskPfSkdDtlIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPfSkdDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * insert VSK_PORT_NWORK
	 * 
	 * @param VskPortNworkIbisIfVO vskPortNworkIbisIfVO
	 * @throws DAOException
	*/
	public void insertVskPortNwork(VskPortNworkIbisIfVO vskPortNworkIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskPortNworkIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPortNworkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * update VSK_PORT_NWORK
	 * 
	 * @param VskPortNworkIbisIfVO vskPortNworkIbisIfVO
	 * @throws DAOException
	*/
	public void updateVskPortNwork(VskPortNworkIbisIfVO vskPortNworkIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskPortNworkIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPortNworkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * update VSK_VSL_SKD
	 * 
	 * @param VskVslSkdIbisIfVO vskVslSkdIbisIfVO
	 * @throws DAOException
	*/
	public void updateVskVslSkd(VskVslSkdIbisIfVO vskVslSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslSkdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * update VSK_VSL_PORT_SKD
	 * 
	 * @param VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO
	 * @throws DAOException
	*/
	public void updateVskVslPortSkd(VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslPortSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslPortSkdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * insert VSK_VSL_PORT_SKD
	 * 
	 * @param VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO
	 * @throws DAOException
	*/
	public void insertVskVslPortSkd(VskVslPortSkdIbisIfVO vskVslPortSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslPortSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslPortSkdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * insert VSK_VSL_SKD
	 * 
	 * @param VskVslSkdIbisIfVO vskVslSkdIbisIfVO
	 * @throws DAOException
	*/
	public void insertVskVslSkd(VskVslSkdIbisIfVO vskVslSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vskVslSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslSkdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Select IBIS VSK_PORT_NWORK IF_MNPL_CD
	 * 
	 * @param VskPortNworkIbisIfVO vskPortNworkIbisIfVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskPortNworkIfMnplCd(VskPortNworkIbisIfVO vskPortNworkIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String IfMnplCd = "";
		try{
			Map<String, String> mapVO = vskPortNworkIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPortNworkRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfMnplCd = dbRowset.getString("IF_MNPL_CD");
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return IfMnplCd;
	}
	
	
	/**
	 * Select IBIS VSK_VSL_PF_SKD IF_MNPL_CD
	 * 
	 * @param VskPfSkdIbisIfVO vskPfSkdIbisIfVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskPfSkdIfMnplCd(VskPfSkdIbisIfVO vskPfSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String IfSeq = "";
		try{
			Map<String, String> mapVO = vskPfSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPfSkdRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfSeq = dbRowset.getString("IF_MNPL_CD");
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return IfSeq;
	}

	/**
	 * Select IBIS VSK_VSL_PF_SKD SEQ
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskPfSkdSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String IfSeq = "";
		try{
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskPfSkdSeqRSQL(), null, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfSeq = dbRowset.getString("IBIS_IF_SEQ");
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return IfSeq;
	}

	/**
	 * Select IBIS VSK_VSL_SKD IF_MNPL_CD
	 * 
	 * @param VskVslSkdIbisIfVO vskVslSkdIbisIfVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskVslSkdIfMnplCd(VskVslSkdIbisIfVO vskVslSkdIbisIfVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String IfSeq = "";
		try{
			Map<String, String> mapVO = vskVslSkdIbisIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslSkdRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfSeq = dbRowset.getString("IF_MNPL_CD");
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return IfSeq;
	}
	
	/**
	 * Select IBIS VSK_VSL_SKD SEQ
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskVslSkdSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String IfSeq = "";
		try{
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToIBISDBDAOVskVslSkdSeqRSQL(), null, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfSeq = dbRowset.getString("IBIS_IF_SEQ");
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return IfSeq;
	}
	
}
