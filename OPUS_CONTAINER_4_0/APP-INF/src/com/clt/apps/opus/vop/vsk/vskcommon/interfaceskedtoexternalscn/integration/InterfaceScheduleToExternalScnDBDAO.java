/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderDAO.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.14
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCheckExistKntForSpecificVoyageRSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOSearchNewVipsIfSeqNoRSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration.InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternalscn.vo.TxScnInterfaceVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010 VSKCodeFinderDAO <br>
 * - NIS2010-VSKCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class InterfaceScheduleToExternalScnDBDAO extends DBDAOSupport {

	/**
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkExistForSpecificVVD(VskVslSkdVO vskVslSkdVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		boolean		isRtnValue	= false;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVslSkdVO == null)	return false;
			
			Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCheckExistKntForSpecificVVDRSQL(), param, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					if(Integer.parseInt(dbRowset.getString("KNT")) > 0){
						isRtnValue	= true;
					}
				}
			} 	
							
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isRtnValue;
	}

	
	/**
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<TxScnInterfaceVO>
	 * @throws DAOException
	 */
	public List<TxScnInterfaceVO> checkTxTypeforDeleteScnInterfaceList(VskVslSkdVO vskVslSkdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<TxScnInterfaceVO> 	list		= new ArrayList<TxScnInterfaceVO>();
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVslSkdVO == null)	return null;
			
			Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCheckTxTypeforDeleteScnInterfaceRSQL(), param, null);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, TxScnInterfaceVO.class);
							
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
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<TxScnInterfaceVO>
	 * @throws DAOException
	 */
	public List<TxScnInterfaceVO> checkTxTypeforUpdateScnInterfaceList(VskVslSkdVO vskVslSkdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<TxScnInterfaceVO> 	list		= new ArrayList<TxScnInterfaceVO>();
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVslSkdVO == null)	return null;
			
			Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCheckTxTypeforUpdateScnInterfaceRSQL(), param, null);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, TxScnInterfaceVO.class);
							
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
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @throws DAOException
	*/
	public void createAllPortScnInterface(VskVslSkdVO vskVslSkdVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(vskVslSkdVO == null)	return;
			
			Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCreateAllPortScnInterfaceCSQL(), param, null);
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
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVslSkdVO vskVslSkdVO
	 * @return List<TxScnInterfaceVO>
	 * @throws DAOException
	 */
	public List<VskVslPortSkdVO> searchAllPortListforVVD(VskVslSkdVO vskVslSkdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<VskVslPortSkdVO> 	list		= new ArrayList<VskVslPortSkdVO>();
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVslSkdVO == null)	return null;
			
			Map<String, String> mapVO = vskVslSkdVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOSearchAllPortListforVVDRSQL(), param, null);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
							
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
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return List<TxScnInterfaceVO>
	 * @throws DAOException
	 */
	public List<TxScnInterfaceVO> checkTxPortTypeforUpdateScnInterfaceList(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<TxScnInterfaceVO> 	list		= new ArrayList<TxScnInterfaceVO>();
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVslPortSkdVO == null)	return null;
			
			Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCheckTxPortTypeforUpdateScnInterfaceRSQL(), param, null);
			list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, TxScnInterfaceVO.class);
							
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
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @throws DAOException
	*/
	public void createSpecificPortScnInterface(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(vskVslPortSkdVO == null)	return;
			
			Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOCreateSpecificPortScnInterfaceCSQL(), param, null);
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
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param TxScnInterfaceVO txScnInterfaceVO
	 * @throws DAOException
	*/
	public void insertPortScnInterface(TxScnInterfaceVO txScnInterfaceVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(txScnInterfaceVO == null)	return;
			
			Map<String, String> mapVO = txScnInterfaceVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOInsertPortScnInterfaceCSQL(), param, null);
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
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param TxScnInterfaceVO txScnInterfaceVO
	 * @throws DAOException
	*/
	public void updatePortScnInterface(TxScnInterfaceVO txScnInterfaceVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(txScnInterfaceVO == null)	return;
			
			Map<String, String> mapVO = txScnInterfaceVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAOUpdatePortScnInterfaceUSQL(), param, null);
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
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param TxScnInterfaceVO txScnInterfaceVO
	 * @throws DAOException
	*/
	public void deletePortScnInterface(TxScnInterfaceVO txScnInterfaceVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(txScnInterfaceVO == null)	return;
			
			Map<String, String> mapVO = txScnInterfaceVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalScnDBDAODeletePortScnInterfaceDSQL(), param, null);
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
	
	 
	
}