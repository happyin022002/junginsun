/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : AgreementNoticeDBDAO.java
*@FileTitle : AgreementNoticeDBDAO.java
*Open Issues :
*Change history :
*@LastModifyDate : 2014-01-24
*@LastModifier : 
*@LastVersion : 1.0
* 2014-01-24
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.agreementnotice.basic.AgreementNoticeBCImpl;
import com.hanjin.bizcommon.agreementnotice.util.AgreementNoticeUtil;
import com.hanjin.bizcommon.agreementnotice.vo.CodeNameVO;
import com.hanjin.bizcommon.agreementnotice.vo.ComCtrtUsrListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchAgreementListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchContractCreationUserVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchMailingListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - ENIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yj jeon
 * @see AgreementNoticeBCImpl 참조
 * @since J2EE 1.4
 */
public class AgreementNoticeDBDAO extends DBDAOSupport {
	
	/**
	 * USR MAX KNT 조회용
	 * @return String
	 * @throws DAOException
	 */
    public String searchUsrMaxKnt() throws DAOException {        
        DBRowSet dbRowset = null;
        String usrMaxKnt = null;
        try{
            Map<String, String> param = new HashMap<String, String>();
            Map<String, String> velParam = new HashMap<String, String>();     
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementNoticeDBDAOsearchUsrMaxKntRSQL(), param, velParam);
            if (dbRowset.next()) {
            	usrMaxKnt = dbRowset.getString(1);            	 
            }
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return usrMaxKnt;
    }	
    
	/**
	 * Pop-up Notice User 조회<br>
	 * 
	 * @param String user_id
	 * @param String pgm_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchNoticeUser(String user_id, String pgm_no) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("user_id", user_id);
			param.put("pgm_no", pgm_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementNoticeDBDAOSearchNoticeUserRSQL(), param, velParam);
			dbRowset.next();
			rtnVal = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVal;
	}
   
	/**
	 * COM_NTC_0001 : System Name Combo (HARD)
	 * 
	 * @return List<CodeNameVO>
	 * @exception DAOException
	 */
	public List<CodeNameVO> searchSystemName() throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchSystemNameRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CodeNameVO.class);
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
	 * COM_NTC_0001 : Office Level Combo (HARD)
	 * 
	 * @param CodeNameVO codeNameVO
	 * @return List<CodeNameVO>
	 * @exception DAOException
	 */
	public List<CodeNameVO> searchOfficeLevel(CodeNameVO codeNameVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeNameVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (codeNameVO != null) {
				Map<String, String> mapVO = codeNameVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchOfficeLevelRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CodeNameVO.class);
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
	 * COM_NTC_0001 : Search User Name
	 * 
	 * @param CodeNameVO codeNameVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchUserName(CodeNameVO codeNameVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (codeNameVO != null) {
				Map<String, String> mapVO = codeNameVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchUserNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}
	
	/**
     * COM_NTC_0001 : Search Office valid
	 * 
	 * @param String cd
	 * @param String nm
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfficeValid(String cd, String nm) throws DAOException {
		DBRowSet dbRowset = null;
		String rslt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cd", cd);
			velParam.put("cd", cd);
			param.put("nm", nm);
			velParam.put("nm", nm);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchOfficeValidRSQL(), param, velParam);
			if (dbRowset.next()) {
				rslt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rslt;
	}
	
	/**
     * COM_NTC_0001 : Retrieve
	 * 
	 * @param SearchMailingListVO searchMailingListVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMailingList(SearchMailingListVO searchMailingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchMailingListVO != null) {
				Map<String, String> mapVO = searchMailingListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				java.util.ArrayList<String> arr_usr_id_list = new java.util.ArrayList<String>();
				java.util.ArrayList<String> arr_usr_nm_list = new java.util.ArrayList<String>();
				java.util.ArrayList<String> arr_usr_jc_list = new java.util.ArrayList<String>();
//				log.error("\n >>>>>>>> DAO searchMailingListVO.getUsrMaxKnt : "+searchMailingListVO.getUsrMaxKnt()+" <<<<<<<\n");
				int usr_max_knt = Integer.parseInt(searchMailingListVO.getUsrMaxKnt()); //10; //여기서 DB FUNCTION으로 user max knt값을 받아온다.
				for (int i=1; i<=usr_max_knt; i++){
					arr_usr_id_list.add(", MAX(CASE WHEN X.NTC_USR_SEQ = "+Integer.toString(i)+" THEN X.NTC_USR_ID END) NTC_USR_ID"+Integer.toString(i));
					arr_usr_nm_list.add(", (SELECT U.USR_NM FROM COM_USER U WHERE U.USR_ID = XX.NTC_USR_ID"+Integer.toString(i)+") AS NTC_USR_ID"+Integer.toString(i)+"_NM");
					arr_usr_jc_list.add(", MAX(CASE WHEN X.NTC_USR_SEQ = "+Integer.toString(i)+" THEN X.NTC_USR_ID_JB_CD END) NTC_N"+AgreementNoticeUtil.conv_job_cd_seq(Integer.toString(i))+"_USR_ID_JB_CD_FLG");
				}
				velParam.put("arr_usr_id_list", arr_usr_id_list);
				velParam.put("arr_usr_nm_list", arr_usr_nm_list);
				velParam.put("arr_usr_jc_list", arr_usr_jc_list);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchMailingListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;
	}
	
	/**
	 * COM_NTC_0001 : Save <br>
	 * add mailing list
	 * 
	 * @param List<SearchMailingListVO> insertSheetVoList
	 * @exception DAOException
	 */
	public void addMailingList(List<SearchMailingListVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAOAddMailingListCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COM_NTC_0001 : Save <br>
	 * modify mailing list
	 * 
	 * @param List<SearchMailingListVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyMailingList(List<SearchMailingListVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAOModifyMailingListUSQL(), updateSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COM_NTC_0001 : Save <br>
	 * delete mailing list
	 * 
	 * @param List<SearchMailingListVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeMailingList(List<SearchMailingListVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAORemoveMailingListDSQL(), deleteSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COM_NTC_0001 : USR List 삭제처리
	 * 
	 * @param List<SearchMailingListVO> deleteSheetVoList
	 * @throws DAOException
	 */
	public void removeMailingComCtrtUsrList(List<SearchMailingListVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAORemoveMailingComCtrtUsrListDSQL(), deleteSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COM_NTC_0001 : USR List를 update - merge문으로 insert하거나 update 처리
	 *
	 * @param List<ComCtrtUsrListVO> ctrtUsrList
	 * @throws DAOException
	 */
	public void manageMailingComCtrtUsrList(List<ComCtrtUsrListVO> comCtrtUsrList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (comCtrtUsrList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAOManageMailingComCtrtUsrListUSQL(), comCtrtUsrList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * COM_NTC_0001 : USR List를 update - merge문으로 insert하거나 update 처리
	 * 
	 * @param List<ComCtrtUsrListVO> comCtrtUsrList
	 * @throws DAOException
	 */
	public void deleteOverUsrMaxKntComCtrtUsrList(List<ComCtrtUsrListVO> comCtrtUsrList) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (comCtrtUsrList!=null && comCtrtUsrList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new AgreementNoticeDBDAOdeleteOverUsrMaxKntComCtrtUsrListDSQL(), comCtrtUsrList, velParam, param);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * COM_NTC_0004 : Notice Agreement List 조회
	 * 
	 * @param String user_id
	 * @param String pgm_no 
	 * @return List<SearchAgreementListVO>
	 * @exception DAOException
	 */
	public List<SearchAgreementListVO> searchAgreementList(String user_id, String pgm_no) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgreementListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("user_id", user_id);
			param.put("pgm_no", pgm_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchAgreementListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchAgreementListVO.class);
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
     * COM_NTC_0002 : Retrieve
	 * 
	 * @param SearchContractCreationUserVO searchContractCreationUserVO
	 * @return List<SearchContractCreationUserVO>
	 * @exception DAOException
	 */
	public List<SearchContractCreationUserVO> searchContractCreationUser(SearchContractCreationUserVO searchContractCreationUserVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchContractCreationUserVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchContractCreationUserVO != null) {
				Map<String, String> mapVO = searchContractCreationUserVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AgreementNoticeDBDAOSearchContractCreationUserRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchContractCreationUserVO.class);
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