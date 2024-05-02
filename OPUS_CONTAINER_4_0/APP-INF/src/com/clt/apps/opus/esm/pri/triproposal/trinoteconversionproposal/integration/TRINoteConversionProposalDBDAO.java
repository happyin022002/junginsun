/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalDBDAO.java
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.17
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.11.17 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.basic.TRINoteConversionProposalBCImpl;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriTriNoteConvVO;
import com.clt.syscommon.common.table.PriTriNoteVO;
import com.clt.syscommon.common.table.PriTriRtVO;


/**
 *  TRINoteConversionProposalDBDAO <br>
 * - TRIProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI SUNG MIN
 * @see TRINoteConversionProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class TRINoteConversionProposalDBDAO extends DBDAOSupport {

	/**
	 * Tariff Fomula Rule 화면에서 Duration 리스트를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return List<PriTriNoteVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriTriNoteVO> searchTRIFomulaRuleInfo(PriTriNoteVO priTriNoteVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriTriNoteVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteVO != null) {
				Map<String, String> mapVO = priTriNoteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriTriNoteVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * TRI Note List를 조회합니다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriNoteConvVO priTriNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTriNoteConvVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteConvVO != null) {
				Map<String, String> mapVO = priTriNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteConvVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriTriNoteConvVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 복사된 TRI NOTE CONVERSION 데이터를 조회합니다.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriTriNoteConvVO> searchNoteConversionCopyList(PriTriNoteConvVO priTriNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriTriNoteConvVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteConvVO != null) {
				Map<String, String> mapVO = priTriNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteConvCpyVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriTriNoteConvVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * TRI Note Conversion 데이터를 생성한다.<br>
	 * 
	 * @param List<PriTriNoteConvListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteConversion(List<PriTriNoteConvListVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteConvVOCSQL(), insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note Conversion 데이터를 갱신한다.<br>
	 * 
	 * @param List<PriTriNoteConvListVO> updModels
	 * @exception DAOException
	 */
	public void modifyNoteConversion(List<PriTriNoteConvListVO> updModels) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteConvVOUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Tariff Fomula Rule Info 데이터와  Conversion 데이터를 삭제한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception DAOException
	 */
	public void removeNoteConversion(PriTriNoteVO priTriNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTriNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_ALLS_DELETE", "Y");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteConvVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note Conversion 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriTriNoteConvListVO> delModels
	 * @exception DAOException
	 */
	public void removeNoteConversion(List<PriTriNoteConvListVO> delModels) throws DAOException, Exception {
	
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			
			velParam.put("IS_ALLS_DELETE", "N");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteConvVODSQL(), delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * COPY된 TRI Note Conversion 데이터를 아이디별로 삭제한다.<br>
	 * 
	 * @param PriTriNoteConvListVO priTriNoteConvListVO
	 * @exception DAOException
	 */
	public void removeNoteConversionCopy(PriTriNoteConvListVO priTriNoteConvListVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTriNoteConvListVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteConvCpyVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * TRI Note Conversion 데이터를 일괄적으로 복사한다.<br>
	 * 
	 * @param List<PriTriNoteConvListVO> insModels
	 * @exception DAOException
	 */
	public void addNoteConversionCopy(List<PriTriNoteConvListVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteConvCpyVOCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * SERVICE SCOPE CODE를 조회한다. <br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchServiceScopeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteConvVO != null) {
				Map<String, String> mapVO = priTriNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOMdmSvbcScpCdVORSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Tariff Fomula Rule 데이터를 생성한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception DAOException
	 */	
	public void addTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTriNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteVOCSQL(), param, velParam);
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
	 * Tariff Fomula Rule 데이터를 갱신한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param String isConfirm
	 * @exception DAOException
	 */	
	public void modifyTRIFomulaRule(PriTriNoteVO priTriNoteVO, String isConfirm) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTriNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("IS_CONFIRM", isConfirm);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteVOUSQL(), param, velParam);
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
	 * Tariff Fomula Rule 데이터를 삭제한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception DAOException
	 */	
	public void removeTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = priTriNoteVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TRINoteConversionProposalDBDAOPriTriNoteVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Tariff Fomula Rule Effective Date가 중복인지 조회합니다. <br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchTRIFomulaRuleEffDate(PriTriNoteVO priTriNoteVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteVO != null) {
				Map<String, String> mapVO = priTriNoteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if (priTriNoteVO.getNoteSeq() == null || "".equals(priTriNoteVO.getNoteSeq()) || "X".equals(priTriNoteVO.getNoteSeq())) {
					velParam.put("HAS_NOTE_SEQ", "N");
				} else {
					velParam.put("HAS_NOTE_SEQ", "Y");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOPriTriNoteEffDtVORSQL(), param,
					velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = false;
			} else {
				rtnChk = true;
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnChk;
	}
	
    /**
     *  Rate 수정시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param List<PriTriRtVO> updModels
     * @exception DAOException
     */
	public void modifyNoteConversionDurationCascadeRt(List<PriTriRtVO> updModels) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new TRINoteConversionProposalDBDAOAdjNoteConvDurCasRtUSQL(), updModels,
						velParam);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * Amend시 Note Conversion을 같이 카피한다.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @exception DAOException
	 */
	public void addCopyNoteConversionOnAmend(PriTriRtVO priTriRtVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new TRINoteConversionProposalDBDAOCpPrevNoteConvOnAmendCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     *  TRI Cancel시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @exception DAOException
     */
	public void removeNoteConversionOnCancel(PriTriRtVO priTriRtVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new TRINoteConversionProposalDBDAODelNoteConvOnCancelDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     *  TRI Cancel시 Conversion의 EffDt/ExpDt를 조정한다.<br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @exception DAOException
     */
	public void modifyNoteConversionDurationOnPublish(PriTriRtVO priTriRtVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priTriRtVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new TRINoteConversionProposalDBDAOAdjNoteConvDurOnPublishUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
	 * GRI Apply시 Note Conversion을 같이 카피한다.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @exception DAOException
	 */
	public void addCopyNoteConversionOnGRIApply(TriPropGRIVO triPropGRIVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new TRINoteConversionProposalDBDAOCpPrevNoteConvOnGRIApplyCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    /**
     *  TRI GRI Cancel시 Conversion 데이터를 삭제한다.<br>
     * 
     * @param TriPropGRIVO triPropGRIVO
     * @exception DAOException
     */
	public void removeNoteConversionOnGRICancel(TriPropGRIVO triPropGRIVO) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = triPropGRIVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate(
					(ISQLTemplate) new TRINoteConversionProposalDBDAODelNoteConvOnGRICancelDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * SCOPE 별 사용자 승인권한 유무를 조회한다.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return String
	 * @exception DAOException
	 */
    public String searchAuthScopeCount(PriTriNoteVO priTriNoteVO) throws DAOException {
        DBRowSet dbRowset = null;
        String authCount = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
        	if (priTriNoteVO != null) {
				Map<String, String> mapVO = priTriNoteVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
        	
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAOMdmSvcScpAuthRSQL(), param, velParam);
            if (dbRowset.next()) {
            	authCount = dbRowset.getString(1);
            } else {
            	authCount = "0";
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return authCount;
    }
    
	/**
	 * RULE CODE, CHARGE CODE를 조회한다. <br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchRuleChargeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (priTriNoteConvVO != null) {
				Map<String, String> mapVO = priTriNoteConvVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TRINoteConversionProposalDBDAORuleChargeCodeListRSQL(),
					param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}