/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : NoteConversionDBDAO.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 전윤주
*@LastVersion : 1.0
* 2009.04.28 전윤주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocDtlVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.noteconversion.vo.RsltPriNoteConvGrpLocVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriNoteConvGrpLocVO;


/**
 * NIS2010 NoteConversionDBDAO <br>
 * - NIS2010-PRIMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see LocationBCImpl 참조
 * @since J2EE 1.4
 */
public class NoteConversionDBDAO extends DBDAOSupport {
	
	/**
	 * Note Conversion Group Location Detail 정보를 조회한다.<br>
	 * 
	 * @param PriNoteConvGrpLocDtlVO priNoteConvGrpLocDtlVO
	 * @return List<RsltPriNoteConvGrpLocDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriNoteConvGrpLocDtlVO> searchGroupLocationDetailList(PriNoteConvGrpLocDtlVO priNoteConvGrpLocDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriNoteConvGrpLocDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priNoteConvGrpLocDtlVO != null){
				Map<String, String> mapVO = priNoteConvGrpLocDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}															  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriNoteConvGrpLocDtlVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Note Conversion Group Location 정보를 조회한다.<br>
	 * 
	 * @param PriNoteConvGrpLocVO priNoteConvGrpLocVO
	 * @return List<RsltPriNoteConvGrpLocVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriNoteConvGrpLocVO> searchGroupLocationList(PriNoteConvGrpLocVO priNoteConvGrpLocVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriNoteConvGrpLocVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priNoteConvGrpLocVO != null){
				Map<String, String> mapVO = priNoteConvGrpLocVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriNoteConvGrpLocVO .class);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Note Conversion Group Location 본문별 데이터를 삭제한다.(PRI_NOTE_CONV_GRP_LOC_DTL)<br>
	 * 
	 * @param PriNoteConvGrpLocVO priNoteConvGrpLocVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeGroupLocationDetail(PriNoteConvGrpLocVO priNoteConvGrpLocVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priNoteConvGrpLocVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");       
			result = sqlExe.executeUpdate((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocDtlAllVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Note Conversion Group Location Detail 데이터를 생성(PRI_NOTE_CONV_GRP_LOC_DTL)<br>
	 * 
	 * @param List<PriNoteConvGrpLocDtlVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocationDetail(List<PriNoteConvGrpLocDtlVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			log.debug("***************insModels.size()**************************************");
			log.debug(insModels.size());
			log.debug("***************insModels.size()**************************************");
			if(insModels.size() > 0){			
					
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocDtlVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Note Conversion Group Location 데이터를 일괄적으로 삭제한다.(pri_scg_grp_loc_dtl)<br>
	 * 
	 * @param List<PriNoteConvGrpLocDtlVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocationDetail(List<PriNoteConvGrpLocDtlVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocDtlVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Group Location 데이터를 생성.(PRI_NOTE_CONV_GRP_LOC)<br>
	 * 
	 * @param List<PriNoteConvGrpLocVO> insModels
	 * @exception DAOException
	 */
	public void addGroupLocation(List<PriNoteConvGrpLocVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Group Location 수정(PRI_NOTE_CONV_GRP_LOC)<br>
	 * 
	 * @param List<PriNoteConvGrpLocVO> updModels
	 * @exception DAOException
	 */
	public void modifyGroupLocation(List<PriNoteConvGrpLocVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 *  Group Location 데이터를 일괄적으로 삭제한다.(PRI_NOTE_CONV_GRP_LOC)<br>
	 * 
	 * @param List<PriNoteConvGrpLocVO> delModels
	 * @exception DAOException
	 */
	public void removeGroupLocation(List<PriNoteConvGrpLocVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new NoteConversionDBDAOPriNoteConvGrpLocVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
}
