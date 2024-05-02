/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBasicStandardNoteGuidelineDAO.java
*@FileTitle : Standard Note Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.04.17 이승준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.basic.SCBasicStandardNoteGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteCtntVO;
import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSgStndNoteHdrVO;
import com.clt.syscommon.common.table.PriSgStndNoteVO;


/**
 * SCBasicStandardNoteGuidelineDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Seung Jun Lee
 * @see SCBasicStandardNoteGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class SCBasicStandardNoteGuidelineDBDAO extends DBDAOSupport {

	
	/**
	 * 노트 헤더 시퀀스 최대값 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNoteHdrMaxSeq(PriSgStndNoteHdrVO priSgStndNoteVO) throws DAOException {
		int note_hdr_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				note_hdr_seq = dbRowset.getInt("note_hdr_seq");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return note_hdr_seq;
	}
	
	
	
	/**
	 * 헤더의 seq Max 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNoteMaxSeq(PriSgStndNoteHdrVO priSgStndNoteVO) throws DAOException {
		int note_seq = -1;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteMaxSeqRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				note_seq = dbRowset.getInt("note_seq");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return note_seq;
	}
	
	
	
	/**
	 * 기간이 겹치지 않는지 체크한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNoteHdrCheckDate(PriSgStndNoteHdrVO priSgStndNoteVO) throws DAOException {
		int chk = 0;
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrChckDateRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				chk = dbRowset.getInt("chk");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return chk;
	}
	
	
	
	
	/**
	 * PRI_SG_STND_NOTE_CTNT 테이블을 조회한다.<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @return List<PriSgStndNoteCtntVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSgStndNoteCtntVO> searchNoteContentList(PriSgStndNoteVO priSgStndNoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgStndNoteCtntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgStndNoteCtntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 /**
		 * pri_sg_stnd_note 테이블을 조회한다.<br>
		 * 
		 * @param PriSgStndNoteVO priSgStndNoteVO
		 * @return List<PriSgStndNoteVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PriSgStndNoteVO> searchNoteList(PriSgStndNoteVO priSgStndNoteVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PriSgStndNoteVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSgStndNoteVO != null){
					Map<String, String> mapVO = priSgStndNoteVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgStndNoteVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		} 
		 
	
		 
		 
	/**
	 * pri_sg_stnd_note_hdr 테이블을 조회한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteVO
	 * @return List<PriSgStndNoteHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSgStndNoteHdrVO> searchNoteHeader(PriSgStndNoteHdrVO priSgStndNoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgStndNoteHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgStndNoteHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	 
		 
		 
		 
	 
	/**
	 * pri_sg_stnd_note_hdr 테이블을 조회한다.<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @return List<PriSgStndNoteHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriSgStndNoteHdrVO> searchNoteHeader(PriSgStndNoteVO priSgStndNoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriSgStndNoteHdrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(priSgStndNoteVO != null){
				Map<String, String> mapVO = priSgStndNoteVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgStndNoteHdrVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	 
	 
	 /**
		 * pri_sg_stnd_note_hdr 테이블을 조회한다.<br>
		 * 
		 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
		 * @return List<PriSgStndNoteHdrVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<PriSgStndNoteHdrVO> searchNoteHeaderDuration(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<PriSgStndNoteHdrVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(priSgStndNoteHdrVO != null){
					Map<String, String> mapVO = priSgStndNoteHdrVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVODurationRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriSgStndNoteHdrVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return list;
		}
	 
	/**
	 * Standard Note 데이터를 갱신한다.(컨폼)<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNoteConfirm(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteConfirmUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	 
	 
	/**
	 * Standard Note 데이터를 생성한다.(노트 본문)<br>
	 * 
	 * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
	 * @exception DAOException
	 */
	public void addNoteContent(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgStndNoteCtntVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 헤더별로 복사하여 생성한다.(노트 본문)<br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @exception DAOException
	 */
	public void addCopyNoteContent(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSgStndNoteHdrCopyVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 갱신한다.(노트본문)<br>
	 * 
	 * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNoteContent(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteCtntVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 헤더별 Standard Note 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteContent(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 헤더별 본문별 Standard Note 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteContent(PriSgStndNoteVO priSgStndNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 단건의 Standard Note 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteContent(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteCtntVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Standard Note 데이터를 일괄적으로 생성한다(pri_sg_stnd_note_ctnt).<br>
	 * 
	 * @param List<PriSgStndNoteCtntVO> insModels
	 * @exception DAOException
	 */
	public void addNoteContents(List<PriSgStndNoteCtntVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Standard Note 데이터를 일괄적으로 갱신한다.(pri_sg_stnd_note_ctnt)<br>
	 * 
	 * @param List<PriSgStndNoteCtntVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteContents(List<PriSgStndNoteCtntVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 일괄적으로 삭제한다.(pri_sg_stnd_note_ctnt)<br>
	 * 
	 * @param List<PriSgStndNoteCtntVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteContents(List<PriSgStndNoteCtntVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteCtntVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 생성한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @exception DAOException
	 */
	public void addNote(PriSgStndNoteVO priSgStndNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 헤더별로 복사하여 생성한다.(PRI_SG_STND_NOTE)<br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @exception DAOException
	 */
	public void addCopyNote(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSgStndNoteHdrCopyVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 갱신한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNote(PriSgStndNoteVO priSgStndNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * 헤더별 Standard Note 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNote(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOAllDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	
	/**
	 * Standard Note 데이터를 삭제한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param PriSgStndNoteVO priSgStndNoteVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNote(PriSgStndNoteVO priSgStndNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Standard Note 데이터를 일괄적으로 생성한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param List<PriSgStndNoteVO> insModels
	 * @exception DAOException
	 */
	public void addNotes(List<PriSgStndNoteVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Standard Note 데이터를 일괄적으로 갱신한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param List<PriSgStndNoteVO> updModels
	 * @exception DAOException
	 */
	public void modifyNotes(List<PriSgStndNoteVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 일괄적으로 삭제한다.(pri_sg_stnd_note)<br>
	 * 
	 * @param List<PriSgStndNoteVO> delModels
	 * @exception DAOException
	 */
	public void removeNotes(List<PriSgStndNoteVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Standard Note 데이터를 생성한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @exception DAOException
	 */
	public void addNoteHeader(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Standard Note 데이터를 헤더별로 복사하여 생성한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
	 * @exception DAOException
	 */
	public void addCopyNoteHeader(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = rsltPriSgStndNoteHdrCopyVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCopyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 단건의 Standard Note 데이터를 갱신한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyNoteHeader(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * 단건의 Standard Note 데이터를 삭제한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param PriSgStndNoteHdrVO priSgStndNoteHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeNoteHeader(PriSgStndNoteHdrVO priSgStndNoteHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgStndNoteHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Standard Note 데이터를 일괄적으로 생성한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param List<PriSgStndNoteHdrVO> insModels
	 * @exception DAOException
	 */
	public void addNoteHeaders(List<PriSgStndNoteHdrVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * Standard Note 데이터를 일괄적으로 갱신한다.(pri_sg_stnd_note_hdr)<br>
	 * 
	 * @param List<PriSgStndNoteHdrVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteHeaders(List<PriSgStndNoteHdrVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteHdrVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * pri_sg_stnd_note 테이블을 조회한다.<br>
	 * 
	 * @param RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO
	 * @return List<RsltPriSgStndNoteCtntVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgStndNoteCtntVO> searchBasicStandardNoteGuidelineExcelList(RsltPriSgStndNoteCtntVO rsltPriSgStndNoteCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgStndNoteCtntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltPriSgStndNoteCtntVO != null){
				Map<String, String> mapVO = rsltPriSgStndNoteCtntVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCBasicStandardNoteGuidelineDAOPriSgStndNoteExcelListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgStndNoteCtntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	} 
}
