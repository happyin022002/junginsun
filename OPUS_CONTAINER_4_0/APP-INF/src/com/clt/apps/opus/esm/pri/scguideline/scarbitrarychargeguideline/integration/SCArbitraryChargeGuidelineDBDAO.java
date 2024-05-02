/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCArbitraryChargeGuidelineDBDAO.java
*@FileTitle : Origin/Destination Arbitrary Charge Guideline Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.04.17 공백진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.basic.SCArbitraryChargeGuidelineBCImpl;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbTypeVO;
import com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo.RsltPriSgArbVO;
import com.clt.apps.opus.esm.pri.scguideline.scguidelinemain.vo.GlineMnCpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriSgArbVO;
import com.clt.syscommon.common.table.PriSgMnVO;


/**
 * SCArbitraryChargeGuidelineDBDAO <br>
 * - SCGuideline system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kong Back Jin
 * @see SCArbitraryChargeGuidelineBCImpl 참조
 * @since J2EE 1.4
 */
public class SCArbitraryChargeGuidelineDBDAO extends DBDAOSupport {

	/**
	 * SCArbitraryChargeGuideline의 Type Count를 조회한다.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbTypeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgArbTypeVO> searchArbitraryChargeTypeCountList(PriSgArbVO priSgArbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgArbTypeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try{
			if(priSgArbVO != null){
				Map<String, String> mapVO = priSgArbVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAORsltPriSgArbTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgArbTypeVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	
	/**
	 * SCArbitraryChargeGuideline을 조회한다.<br>
	 * 
	 * @param PriSgArbVO priSgArbVO
	 * @return List<RsltPriSgArbVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltPriSgArbVO> searchArbitraryChargeGuidelineList(PriSgArbVO priSgArbVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriSgArbVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(priSgArbVO != null){
				Map<String, String> mapVO = priSgArbVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriSgArbVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	

	/**
	 * SCArbitraryChargeGuideline을 입력한다.<br>
	 * 
	 * @param List<PriSgArbVO> insModels
	 * @throws DAOException
	 */
	public void addArbitraryChargeGuidelineS(List<PriSgArbVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbVOCSQL(), insModels,null);
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
	 * ArbitraryCharge Guideline을 수정한다.<br>
	 * 
	 * @param List<PriSgArbVO> updModels
	 * @throws DAOException
	 */
	public void modifyArbitraryChargeGuidelineS(List<PriSgArbVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbVOUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * SCArbitraryChargeGuideline을 삭제한다.<br>
	 * 
	 * @param List<PriSgArbVO> delModels
	 * @throws DAOException
	 */
	public void removeArbitraryChargeGuidelineS(List<PriSgArbVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbVODSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * Arbitrary Charge의 전체 데이터를 삭제한다.<br>
	 * 
	 * @param PriSgMnVO priSgMnVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeGuidelineMainArbitraryCharge(PriSgMnVO priSgMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = priSgMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgMnDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
	/**
	 * Excel 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<PriSgArbVO> insModels
	 * @throws DAOException
	 */
	public void addArbitraryExcel(List<PriSgArbVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbExcelVOCSQL(), insModels,null);
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
	 * Arbitray Guileline Copy를 처리한다. <br>
	 *
	 * @param GlineMnCpVO glineMnCpVO
	 * @throws DAOException
	 */
	public void addGuidelineMainArbitraryChargeCopy(GlineMnCpVO glineMnCpVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = glineMnCpVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAOPriSgArbGlineMainCopyCSQL(), param, velParam);
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
	 * LOCATION CODE와 GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @param String CodeTp
	 * @return List<RsltCdListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RsltCdListVO> searchExcelCodeList(RsltCdListVO rsltCdListVO, String codeTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.put("code_tp", codeTp);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SCArbitraryChargeGuidelineDBDAORsltCdListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
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
