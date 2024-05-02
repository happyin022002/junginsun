/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FQAResultMgtDBDAO.java
*@FileTitle : FQA Result Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.20
*@LastModifier : 성덕경
*@LastVersion : 1.0
* 2009.05.20 성덕경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.basic.FQAResultMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.integration.FQAResultMgtDBDAOcheckFQAResultListDataRSQL;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.FQAResultMgtINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.fqaresultmgt.vo.MnrFieldQualityAuditResultVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * alps FQAResultMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SEONG DUK KYUNG
 * @see FQAResultMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class FQAResultMgtDBDAO extends DBDAOSupport {

	/**
	 * [EES_MNR_0223]FQA Result Detail Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtINVO fQAResultMgtINVO
	 * @return List<MnrFieldQualityAuditResultVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MnrFieldQualityAuditResultVO> searchFQAResultListData(FQAResultMgtINVO fQAResultMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrFieldQualityAuditResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fQAResultMgtINVO != null){
				Map<String, String> mapVO = fQAResultMgtINVO .getColumnValues();
			
				param.putAll(mapVO);
       
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FQAResultMgtDBDAOsearchFQAResultListAllDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrFieldQualityAuditResultVO .class);
			
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
	  * [EES_MNR_0029]FQA Result Creation의 정보를 체크 합니다. <br>
	  *
	  * @param String vndrSeq
	  * @param String ydCd
	  * @param String fldAudDt
	  * @return int
	  * @exception DAOException
	  */
	 public int checkFQAResultListData(String vndrSeq, String ydCd, String fldAudDt) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{

			param.put("vndr_seq", vndrSeq);
			param.put("yd_cd", ydCd);
			param.put("fld_aud_dt", fldAudDt);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FQAResultMgtDBDAOcheckFQAResultListDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 cnt = dbRowset.getInt(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }
	 
	 /**
	  * [EES_MNR_0029]FQA Result Creation의 정보를 추가 합니다. <br>
	  *
	  * @param List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs
	  * @exception DAOException
	  */
	public void addFQAResultDetailData(List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mnrFieldQualityAuditResultVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new FQAResultMgtDBDAOaddFQAResultDetailDataCSQL(), mnrFieldQualityAuditResultVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 수정 합니다. <br>
	 *
	 * @param List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs
	 * @exception DAOException
	 */
	public void modifyFQAResultDetailData(List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mnrFieldQualityAuditResultVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new FQAResultMgtDBDAOmodifyFQAResultDetailDataUSQL(), mnrFieldQualityAuditResultVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs
	 * @exception DAOException
	 */
	public void removeFQAResultDetailData(List<MnrFieldQualityAuditResultVO> mnrFieldQualityAuditResultVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(mnrFieldQualityAuditResultVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new FQAResultMgtDBDAOremoveFQAResultDetailDataDSQL(), mnrFieldQualityAuditResultVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param String vndrSeq
	 * @param String ydCd
	 * @param String fldAudDt
	 * @exception DAOException
	 */
	public void removeFQAResultData(String vndrSeq, String ydCd, String fldAudDt) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("vndr_seq", vndrSeq);
			param.put("yd_cd", ydCd);
			param.put("fld_aud_dt", fldAudDt);
			
			sqlExe.executeUpdate(new FQAResultMgtDBDAOremoveFQAResultDetailDataDSQL(), param, null); 
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0222]FQA Result Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param FQAResultMgtINVO fQAResultMgtINVO
	 * @return List<MnrFieldQualityAuditResultVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MnrFieldQualityAuditResultVO> searchFQAListData(FQAResultMgtINVO fQAResultMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrFieldQualityAuditResultVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fQAResultMgtINVO != null){
				Map<String, String> mapVO = fQAResultMgtINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
       
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FQAResultMgtDBDAOsearchFQAListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrFieldQualityAuditResultVO .class);
			
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
	  * [EES_MNR_0029]FQA Result Creation의 정보를 조회 합니다. <br>
	  *
	  * @param MnrFieldQualityAuditResultVO mnrFieldQualityAuditResultVO
	  * @return int
	  * @exception DAOException
	  */
	 public int checkFQAResultDetailData(MnrFieldQualityAuditResultVO mnrFieldQualityAuditResultVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 int cnt = 0;

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{

			if(mnrFieldQualityAuditResultVO != null){
				Map<String, String> mapVO = mnrFieldQualityAuditResultVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FQAResultMgtDBDAOcheckFQAResultDetailDataRSQL(), param, velParam);
			 
			if(dbRowset.next()){
				cnt = dbRowset.getInt(1); 
			}
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }
}
