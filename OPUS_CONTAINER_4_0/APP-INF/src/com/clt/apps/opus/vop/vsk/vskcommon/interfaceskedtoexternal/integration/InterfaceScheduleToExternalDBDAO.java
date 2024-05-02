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
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 VSKCodeFinderDAO <br>
 * - NIS2010-VSKCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEO CHANG YUL
 * @see VSKCodeFinderBCImpl 참조
 * @since J2EE 1.4
 */
public class InterfaceScheduleToExternalDBDAO extends DBDAOSupport {
	
	/**
	 * Select VIPS Master SEQ
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkExistForSpecificVoyage(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		boolean		isRtnValue	= false;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVipsIfMstVO == null)	return false;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCheckExistKntForSpecificVoyageRSQL(), param, null);
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
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkExistForSpecificVVD(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
		
		DBRowSet 	dbRowset 	= null;
		boolean		isRtnValue	= false;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
		
			if(vskVipsIfMstVO == null)	return false;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCheckExistKntForSpecificVVDRSQL(), param, null);
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
	 * Check VIPS Interfaced Data
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @return VskVipsIfHdrVO 
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
    public VskVipsIfMstVO checkInterfaceStatusforSpecificVoyage(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
		
		DBRowSet 				dbRowset	= null;
		List<VskVipsIfMstVO> 	list  		= null;
		VskVipsIfMstVO 			rtnVO		= null;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		
		try{
			
			if(vskVipsIfMstVO == null)	return null;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
		
			param.putAll	(mapVO);
			
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCheckInterfaceStatusforSpecificVoyageRSQL(), param, null);
				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVipsIfMstVO.class);
			
			if( list != null && list.size()>0){
				rtnVO	= list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}
	
	/**
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
	public void modifyVipsIfHdrInterfaceStatusforExclOldVoyage(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforExclOldVoyageUSQL(), param, null);
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
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
//	public void modifyVipsIfHdrInterfaceStatusforInclOldVoyage(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try {
//			
//			if(vskVipsIfMstVO == null)	return;
//			
//			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
//			param.putAll	(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVoyageUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	/**
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
//	public void removeVipsIfMstOldPortList(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try {
//			
//			if(vskVipsIfMstVO == null)	return;
//			
//			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
//			param.putAll	(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAORemoveVipsIfMstOldPortListDSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
//	public void removeVipsIfDtlOldPortList(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try {
//			
//			if(vskVipsIfMstVO == null)	return;
//			
//			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
//			param.putAll	(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAORemoveVipsIfDtlOldPortListDSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * I/F 대상제외 데이터에 대한 INDICATOR 업데이트
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
//	public void createVipsIfDtlfromOldPortList(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try {
//			
//			if(vskVipsIfMstVO == null)	return;
//			
//			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
//			param.putAll	(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVipsIfDtlfromOldPortListCSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}
	
	/**
	 * Generating VIPS Master
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	 */
	public void addVskVipsIfHdr(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfHdrCSQL(), param, null);
		
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Generating VIPS Master
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	 */
	public void addVskVipsIfMst(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstCSQL(), param, null);
		
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * Generating VIPS Master
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	 */
	public void addVskVipsIfMstUsingVipsIfHis(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfMstUsingVipsIfHisCSQL(), param, null);
		
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Generating VIPS Master
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	 */
	public void addVskVipsIfDtlUsingVipsIfHis(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlUsingVipsIfHisCSQL(), param, null);
		
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Generating VIPS Detail
	 * 
	 * @param VskVipsIfDtlVO vskVipsIfDtlVO
	 * @throws DAOException
	 */
	public void addVskVipsIfDtl(VskVipsIfDtlVO vskVipsIfDtlVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfDtlVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfDtlVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlCSQL(), param, null);
		
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Generating VIPS Detail
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	 */
	public void addVskVipsIfDtlfromPortSkdList(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException{

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(vskVipsIfMstVO == null)	return;
			
			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			param.putAll	(mapVO);
			
			sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOCreateVskVipsIfDtlFromPortSkdListCSQL(), param, null);
		
		}catch (SQLException se) {
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
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @throws DAOException
	*/
//	public void modifyVipsIfMstInterfaceStatusforInclOldVvd(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try {
//			
//			if(vskVipsIfMstVO == null)	return;
//			
//			Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
//			param.putAll	(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new InterfaceScheduleToExternalDBDAOModifyInterfaceStatusforInclOldVvdUSQL(), param, null);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to insert SQL");
//			
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//	}

	/**
	 * Select VIPS Master SEQ
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String searchVskVipsIfSeqNo() throws DAOException {
		DBRowSet dbRowset = null;
		String IfSeq = "";
			try{
			dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOSearchNewVipsIfSeqNoRSQL(), null, null);
			if(dbRowset != null){
				if(dbRowset.next()){
					IfSeq = dbRowset.getString("VIPS_IF_SEQ");
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
	 * Actual SKD 삭제에 따른 Vessel Port Schedule 정보를 변경한다..<br>
	 * 
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVOs
	 * @return List<VskVipsIfMstVO>
	 * @exception DAOException
	 */
	public List<VskVipsIfMstVO> searchPairVVDforVipsIfMst(List<VskVipsIfMstVO> vskVipsIfMstVOs) throws DAOException {

		DBRowSet 				dbRowset 	= null;
		List<VskVipsIfMstVO> 	list 		= null;
		
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try {
			
			if(vskVipsIfMstVOs != null && vskVipsIfMstVOs.size()>0){
				
				param.putAll(vskVipsIfMstVOs.get(0).getColumnValues());
				
				velParam.put("targetVoyage", vskVipsIfMstVOs);
				dbRowset 	= new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOSearchPairVVDforVipsIfMstRSQL(), param, velParam);
				list 		= (List)RowSetUtil.rowSetToVOs(dbRowset, VskVipsIfMstVO.class);
			}else{
				list = new ArrayList<VskVipsIfMstVO>();
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
		
	/**
	 * Lane 별 Vessel Schedule 정보를 조회합니다.<br>
	 * 
	 * @param VskVipsIfMstVO vskVipsIfMstVO
	 * @return List<VskVipsIfDtlVO> vskVipsIfDtlVOs
	 * @exception DAOException
	 */
	public List<VskVipsIfDtlVO> searchPairPortScheduleList(VskVipsIfMstVO vskVipsIfMstVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<VskVipsIfDtlVO> 	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();

		try{
			if(vskVipsIfMstVO != null){
				
				Map<String, String> mapVO = vskVipsIfMstVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InterfaceScheduleToExternalDBDAOSearchPairPortScheduleListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVipsIfDtlVO .class);
			
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