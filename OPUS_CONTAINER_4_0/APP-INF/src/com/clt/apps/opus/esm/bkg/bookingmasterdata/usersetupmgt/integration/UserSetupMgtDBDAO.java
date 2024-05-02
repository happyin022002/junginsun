/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UserSetupMgtDAO.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.27 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAOCheckBDRVVDPOLRSQL;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlCluzStupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlESignatureVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;
import com.clt.syscommon.common.table.BkgXterSrchSetVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.vo.PlaceOfIssueAssociationVO;		//SJH.20141121.ADD

/**
 *  UserSetupMgtDAO <br>
 * - BookingMaterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Youngchul
 * @see UserSetupMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class UserSetupMgtDBDAO extends DBDAOSupport {

    /**
     * User Template List 조회 메소드.<br>
     *
     * @author KimYoungchul
     * @param bkgUsrTmpltVo
     * @return List<BkgUsrTmpltVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgUsrTmpltVO> searchUserTemplate(BkgUsrTmpltVO bkgUsrTmpltVo) throws DAOException {
        DBRowSet dbRowset = null;
        List<BkgUsrTmpltVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if(bkgUsrTmpltVo == null || bkgUsrTmpltVo.getUsrId() == null) {
                throw new RuntimeException("로그인 사용자가 아닙니다.");
            }
            log.debug(">>> USER_ID : " + bkgUsrTmpltVo.getUsrId());
            log.debug(">>> TYPE_CD : " + bkgUsrTmpltVo.getTmpltTpCd());
            
            param.put("usr_id", bkgUsrTmpltVo.getUsrId());
            param.put("tmplt_tp_cd", bkgUsrTmpltVo.getTmpltTpCd());
            //velParam.put("usr_id", bkgUsrTmpltVo.getUsrId());
            velParam.put("tmplt_tp_cd", bkgUsrTmpltVo.getTmpltTpCd());

            SQLExecuter executer = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOBkgUsrTmpltVORSQL template = new UserSetupMgtDBDAOBkgUsrTmpltVORSQL();
            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsrTmpltVO.class);

        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

        }
        return list;
    }

    /**
     * User Template List 추가 메소드.
     *
     * @author KimYoungchul
     * @param bkgUsrTmpltVO
     * @exception DAOException
     * @exception Exception
     */
    public void addUserTemplate(BkgUsrTmpltVO bkgUsrTmpltVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUsrTmpltVO != null){
				Map<String, String> mapVO = bkgUsrTmpltVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			UserSetupMgtDBDAOBkgUsrTmpltVOCSQL template = new UserSetupMgtDBDAOBkgUsrTmpltVOCSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * User Template List 수정 메소드.
     *
     * @author KimYoungchul
     * @param bkgUsrTmpltVO
     * @exception DAOException
     * @exception Exception
     */
    public void modifyUserTemplate(BkgUsrTmpltVO bkgUsrTmpltVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUsrTmpltVO != null){
				Map<String, String> mapVO = bkgUsrTmpltVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			UserSetupMgtDBDAOBkgUsrTmpltVOUSQL template = new UserSetupMgtDBDAOBkgUsrTmpltVOUSQL();
            int updCnt = sqlExe.executeUpdate(template, param,velParam);
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);

		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    

    /**
     * User Template List 삭제 메소드.
     *
     * @author KimYoungchul
     * @param bkgUsrTmpltVO
     * @exception DAOException
     * @exception Exception
     */
    public void removeUserTemplate(BkgUsrTmpltVO bkgUsrTmpltVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgUsrTmpltVO != null){
				Map<String, String> mapVO = bkgUsrTmpltVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			UserSetupMgtDBDAOBkgUsrTmpltVODSQL template = new UserSetupMgtDBDAOBkgUsrTmpltVODSQL();
			int delCnt = sqlExe.executeUpdate(template, param,velParam);
			if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
    /**
     * 단건의 데이터를 삭제한다.<br>
     * 
     * @param BkgUsrTmpltVO bkgUsrTmpltVO
     * @return List<BkgUsrTmpltVO>
     * @exception DAOException
     */
    
    @SuppressWarnings("unchecked")
    public List<BkgUsrTmpltVO> searchRmkTemplate(BkgUsrTmpltVO bkgUsrTmpltVo) throws DAOException {
    	  DBRowSet dbRowset = null;
          List<BkgUsrTmpltVO> list = null;
          // query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          // velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();
          
          try {
              if(bkgUsrTmpltVo == null || bkgUsrTmpltVo.getUsrId() == null) {
                  throw new RuntimeException("로그인 사용자가 아닙니다.");
              }
              log.debug(">>> USER_ID : " + bkgUsrTmpltVo.getUsrId());
              log.debug(">>> TYPE_CD : " + bkgUsrTmpltVo.getTmpltTpCd());
              
              
              param.put("usr_id", bkgUsrTmpltVo.getUsrId());
              param.put("tmplt_tp_cd", bkgUsrTmpltVo.getTmpltTpCd());
              velParam.put("usr_id", bkgUsrTmpltVo.getUsrId());
              velParam.put("tmplt_tp_cd", bkgUsrTmpltVo.getTmpltTpCd());

              SQLExecuter executer = new SQLExecuter("DEFAULT");              
              UserSetupMgtDBDAOsearchRmkTemplateRSQL template = new UserSetupMgtDBDAOsearchRmkTemplateRSQL();

              dbRowset = executer.executeQuery(template, param, velParam);
              list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsrTmpltVO.class);              
          } catch(SQLException se) {
              log.error(se.getMessage(), se);
              throw new DAOException(new ErrorHandler(se).getMessage(),se);
          } catch(Exception ex) {
              log.error(ex.getMessage(), ex);
              throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
          }
          return list;
    }
    
    /**
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 조회한다.<br>
     * 
     * @param String userid
     * @return BkgUsrDfltSetVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public BkgUsrDfltSetVO searchUserDefaultSetting(String userid) throws DAOException {
        DBRowSet dbRowset = null;
        BkgUsrDfltSetVO rsVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            
            param.put("usr_id", userid);
            velParam.put("usr_id", userid);

            SQLExecuter executer = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOBkgUsrDfltSetVORSQL template = new UserSetupMgtDBDAOBkgUsrDfltSetVORSQL();

            dbRowset = executer.executeQuery(template, param, velParam);
            List<BkgUsrDfltSetVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgUsrDfltSetVO.class);
            if(list.size() > 0){
                rsVO = list.get(0);
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return rsVO;
    }
    
    /**
     * 단건의 데이터를 생성한다.<br>
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다<br>
     * 
     * @param BkgUsrDfltSetVO vo
     * @return int
     * @exception DAOException
     */
    public int addUserDefaultSetting(BkgUsrDfltSetVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new UserSetupMgtDBDAOBkgUsrDfltSetVOCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }

    /**
     * 단건의 데이터를 갱신한다.<br>
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다<br>
     * 
     * @param BkgUsrDfltSetVO vo
     * @return int
     * @exception DAOException
     */
    public int modifyUserDefaultsetting (BkgUsrDfltSetVO vo) throws DAOException, Exception {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new UserSetupMgtDBDAOBkgUsrDfltSetVOUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return result;
    }

    /**
     * 0232 화면의 조회조건 Set을 조회한다.<br>
     * 
     * @param String usrId
     * @return List<BkgXterSrchSetVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BkgXterSrchSetVO> searchUserXterSearchSet(String usrId) throws DAOException {
  	  DBRowSet dbRowset = null;
        List<BkgXterSrchSetVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            param.put("usr_id", usrId);
            velParam.put("usr_id", usrId);

            SQLExecuter executer = new SQLExecuter("DEFAULT");              
            UserSetupMgtDBDAOBkgXterSrchSetVORSQL template = new UserSetupMgtDBDAOBkgXterSrchSetVORSQL();

            dbRowset = executer.executeQuery(template, param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgXterSrchSetVO.class);              
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
  }
    
    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     * 
     * @param List<BkgXterSrchSetVO> insModels
     * @exception DAOException
     */
    public void addBkgXterSrchSet(List<BkgXterSrchSetVO> insModels) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new UserSetupMgtDBDAOBkgXterSrchSetVOCSQL(), insModels, null);
                for(int i = 0; i < insCnt.length; i++) {
                    if(insCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     * 
     * @param 	BkgXterSrchSetVO bkgXterSrchSetVO
     * @exception 	DAOException
     */
    public void addBkgXterSrchSet(BkgXterSrchSetVO bkgXterSrchSetVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgXterSrchSetVO != null){
				Map<String, String> mapVO = bkgXterSrchSetVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOBkgXterSrchSetVOCSQL(), param,velParam);
			
			if(insCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * 다건의 데이터를 일괄적으로 갱신한다.<br>
     * 
     * @param List<BkgXterSrchSetVO> updModels
     * @exception DAOException
     */
    public void modifyBkgXterSrchSet(List<BkgXterSrchSetVO> updModels) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new UserSetupMgtDBDAOBkgXterSrchSetVOUSQL(), updModels, null);
                for(int i = 0; i < updCnt.length; i++) {
                    if(updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     * 다건의 데이터를 일괄적으로 갱신한다.<br>
     * 
     * @param BkgXterSrchSetVO bkgXterSrchSetVO
     * @exception DAOException
     */
    public void modifyBkgXterSrchSet(BkgXterSrchSetVO bkgXterSrchSetVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgXterSrchSetVO != null){
				Map<String, String> mapVO = bkgXterSrchSetVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOBkgXterSrchSetVOUSQL(), param,velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }

    /**
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     * 
     * @param List<BkgXterSrchSetVO> delModels
     * @exception DAOException
     */
    public void removeBkgXterSrchSet(List<BkgXterSrchSetVO> delModels) throws DAOException, Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if(delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new UserSetupMgtDBDAOBkgXterSrchSetVODSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++) {
                    if(delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch(SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     * 다건의 데이터를 일괄적으로 삭제한다.<br>
     * 
     * @param BkgXterSrchSetVO bkgXterSrchSetVO
     * @exception DAOException
     */
    public void removeBkgXterSrchSet(BkgXterSrchSetVO bkgXterSrchSetVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();						
		try {
			if(bkgXterSrchSetVO != null){
				Map<String, String> mapVO = bkgXterSrchSetVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}							
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOBkgXterSrchSetVODSQL(), param,velParam);
			
			if(delCnt == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
	 

			
		 /**
		 * 0743,0064 B/L Print 옵션을 조회합니다.<br>
		 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
		 * @return List<BkgUsrDfltSetVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgUsrDfltSetVO> searchUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgUsrDfltSetVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = bkgUsrDfltSetVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetupRSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsrDfltSetVO.class);
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
		  * 0743 C/A No 옵션을 조회합니다.<br>
		  * @param bkgNo String
		  * @return List<BkgCorrectionVO>
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<BkgCorrectionVO> searchUserPrintSetup2(String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<BkgCorrectionVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 param.put("bkg_no", bkgNo);
		         velParam.put("bkg_no", bkgNo);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetup2RSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCorrectionVO.class);
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
		 * 0743_01 그룹 프린트를 위해 초기 조건들을 조회한다.<br>
		 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
		 * @return List<BkgUsrDfltSetVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgUsrDfltSetVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = bkgUsrDfltSetVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetup3RSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsrDfltSetVO.class);
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
		 * 0743_01 프린트 설정을 조회한다.<br>
		 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
		 * @return List<BkgUsrDfltSetVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgUsrDfltSetVO> searchUserPrintSetup4(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<BkgUsrDfltSetVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
			try{
				Map<String, String> mapVO = bkgUsrDfltSetVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetup4RSQL(),param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgUsrDfltSetVO.class);
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
		 *  0743,0064 B/L Print 옵션을 저장합니다.<br>
		 * 
		 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
		 * @exception DAOException
		 */
		public void manageUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();	
				
				
				if(bkgUsrDfltSetVO != null ){
					Map<String, String> mapVO = bkgUsrDfltSetVO .getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
					
					if(!JSPUtil.getNull(bkgUsrDfltSetVO.getBlPrnSetup()).equals("")){
					    int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOManageUserPrintSetup2USQL(),param,velParam);
						
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException(new ErrorHandler("COM12240").getMessage());
						
					}
					
					
				}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}		

		
		 /**
		  * 0922 Office 상세정보를 조회합니다.<br>
		  * @param ofcCd String
		  * @return List<MdmOrganizationVO>
		  * @exception DAOException
		  */
		 @SuppressWarnings("unchecked")
		 public List<MdmOrganizationVO> searchOfficeDetail(String ofcCd) throws DAOException {
			 DBRowSet dbRowset = null;
			 List<MdmOrganizationVO> list = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 try{
				 param.put("ofc_cd", ofcCd);
				 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchOfficeDetailRSQL(),param, velParam);
				 list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
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
         * searchRptItmStup
         * 
         * @author KimYoungchul
         * @param ofcCd
         * @param custCd
         * @return List<RptItmStupVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
        public List<RptItmStupVO> searchRptItmStup(String ofcCd, String custCd) throws DAOException {
            DBRowSet dbRowset = null;
            List<RptItmStupVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("bkg_ofc_cd", ofcCd);
                mapVO.put("cust_cd", custCd);
//                if(custCd.length() == 2){
//                    mapVO.put("cust_cnt_cd", custCd);
//                }else{
//                    mapVO.put("cust_cnt_cd", custCd.substring(0, 2));
//                    mapVO.put("cust_seq", custCd.substring(2));
//                }                

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORptItmStupRSQL template = new UserSetupMgtDBDAORptItmStupRSQL();
                dbRowset = sqlExe.executeQuery(template, param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, RptItmStupVO.class);
            } catch(SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch(Exception ex) {
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return list;
        } 		

        /**
         * 데이터를 생성한다.<br>
         * 
         * @param   RptItmStupVO rptItmStupVO
         * @exception   DAOException
         */
        public void addRptItmStup(RptItmStupVO rptItmStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = rptItmStupVO.getColumnValues();
                String custCd = rptItmStupVO.getCustCd();
                log.debug("&&&&&&&&&&& custCd : " + custCd);
                if(custCd !=null && custCd.length() > 2){
                    mapVO.put("cust_cnt_cd", custCd.substring(0, 2));
                    mapVO.put("cust_seq", custCd.substring(2));
                }
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORptItmStupCSQL template = new UserSetupMgtDBDAORptItmStupCSQL();
                int insCnt = sqlExe.executeUpdate(template, param,velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                            throw new DAOException(new ErrorHandler("COM12240").getMessage());
            } catch (SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(),se);
            }catch(Exception ex){
                throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
            }
        }

        /**
         * 데이터를 생성한다.<br>
         * 
         * @param   RptItmStupVO rptItmStupVO
         * @exception   DAOException
         */
        public void modifyRptItmStup(RptItmStupVO rptItmStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = rptItmStupVO.getColumnValues();
                String custCd = rptItmStupVO.getCustCd();
                log.debug("&&&&&&&&&&& custCd : " + custCd);
                if(custCd !=null && custCd.length() > 2){
                    mapVO.put("cust_cnt_cd", custCd.substring(0, 2));
                    mapVO.put("cust_seq", custCd.substring(2));
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORptItmStupUSQL template = new UserSetupMgtDBDAORptItmStupUSQL();
                int insCnt = sqlExe.executeUpdate(template, param,velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                            throw new DAOException(new ErrorHandler("COM12240").getMessage());
            } catch (SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(),se);
            }catch(Exception ex){
                throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
            }
        }

        /**
         * 데이터를 생성한다.<br>
         * 
         * @param   RptItmStupVO rptItmStupVO
         * @exception   DAOException
         */
        public void removeRptItmStup(RptItmStupVO rptItmStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = rptItmStupVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORptItmStupDSQL template = new UserSetupMgtDBDAORptItmStupDSQL();
                int insCnt = sqlExe.executeUpdate(template, param,velParam);
                if(insCnt == Statement.EXECUTE_FAILED)
                            throw new DAOException(new ErrorHandler("COM12240").getMessage());
            } catch (SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(),se);
            }catch(Exception ex){
                throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
            }
        }

        /**
         * searchOfcCd
         * 
         * @author KimYoungchul
         * @return List<BkgComboVO>
         * @exception   DAOException
         */
        @SuppressWarnings("unchecked")
        public List<BkgComboVO> searchOfcCd() throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgComboVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
//                Map<String, String> mapVO = new HashMap<String, String>();
//                mapVO.put("org_cnt_cd", orgCnt);
//                mapVO.put("cust_cnt_cd", custCd);
//                mapVO.put("cust_seq", custCd);
//                               
//                param.putAll(mapVO);
//                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOOfcCdRSQL template = new UserSetupMgtDBDAOOfcCdRSQL();
                dbRowset = sqlExe.executeQuery(template, param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
            } catch(SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch(Exception ex) {
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return list;
        }

        /**
         * manageRptItmStup 중복 체크.<br>
         * 
         * @author KimYoungchul
         * @param String ofcCd
         * @param String custCd
         * @return String
         * @exception   DAOException
         */
        public String searchRptItmStupDup(String ofcCd, String custCd) throws DAOException {
            DBRowSet dbRowset = null;
            String dup = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("bkg_ofc_cd", ofcCd);
                mapVO.put("cust_cd", custCd);

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORptItmStupDupRSQL template = new UserSetupMgtDBDAORptItmStupDupRSQL();
                dbRowset = sqlExe.executeQuery(template, param, velParam);
                if(dbRowset.next()){
                    dup = "Y";
                }else{
                    dup = "N";
                }
            } catch(SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch(Exception ex) {
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return dup;
        }

        /**
    	 * Internet O/BL 승인권한에 등록된 유저를 조회한다.
    	 * @param BkgInternetAuthorityVO bkgInternetAuthorityVO
    	 * @return List<SearchInternetUserAuthVO>
    	 * @exception DAOException
    	 */
    	 @SuppressWarnings("unchecked")
    	public List<BkgInternetAuthorityVO> searchUserInternetAuth(BkgInternetAuthorityVO bkgInternetAuthorityVO) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<BkgInternetAuthorityVO> list = null;
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try{
    			Map<String, String> mapVO = bkgInternetAuthorityVO .getColumnValues();
    			
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserInternetAuthRSQL(), param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgInternetAuthorityVO .class);
    		
    		}catch(SQLException se){
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage(),se);
    		}catch(Exception ex){
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    		}
    		return list;
    	}    
    	 
    	
    	 
    		/**
    		 * 다건의 데이터를 일괄적으로 갱신한다.<br>
    		 * 
    		 * @param bkgInternetAuthorityVO 데이터객체 배열
    		 * @exception DAOException
    		 */
    		public void modifyInternetAuth(List<BkgInternetAuthorityVO> bkgInternetAuthorityVO) throws DAOException,Exception {
    			try {
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int updCnt[] = null;
    				if(bkgInternetAuthorityVO.size() > 0){
    					updCnt = sqlExe.executeBatch((ISQLTemplate)new UserSetupMgtDBDAOModifyInternetAuthUSQL(), bkgInternetAuthorityVO,null);
    					for(int i = 0; i < updCnt.length; i++){
    						if(updCnt[i]== Statement.EXECUTE_FAILED)
    							throw new DAOException("Fail to insert No"+ i + " SQL");
    					}
    				}
    				
    			} catch (SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage(),se);
    			}catch(Exception ex){
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    			}
    		}
    		
    		/**
    		 * 다건의 데이터를 일괄적으로 삭제한다.<br>
    		 * 
    		 * @param bkgInternetAuthorityVO 데이터객체 배열
    		 * @exception DAOException
    		 */
    		public void removeInternetAuth(List<BkgInternetAuthorityVO> bkgInternetAuthorityVO) throws DAOException,Exception {
    			try {
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int delCnt[] = null;
    				if(bkgInternetAuthorityVO.size() > 0){
    					delCnt = sqlExe.executeBatch((ISQLTemplate)new UserSetupMgtDBDAORemoveInternetAuthDSQL(), bkgInternetAuthorityVO,null);
    					for(int i = 0; i < delCnt.length; i++){
    						if(delCnt[i]== Statement.EXECUTE_FAILED)
    							throw new DAOException("Fail to insert No"+ i + " SQL");
    					}
    				}
    			} catch (SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage(),se);
    			}catch(Exception ex){
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    			}
    		}
    		
    		/**
    		 * 다건의 데이터를 일괄적으로 생성한다.<br>
    		 * 
    		 * @param BkgInternetAuthorityVO 데이터객체 배열
    		 * @exception DAOException
    		 */
    		public void addInternetAuth(List<BkgInternetAuthorityVO> bkgInternetAuthorityVO) throws DAOException,Exception {
    			try {
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int insCnt[] = null;
    				if(bkgInternetAuthorityVO.size() > 0){
    					insCnt = sqlExe.executeBatch((ISQLTemplate)new UserSetupMgtDBDAOaddInternetAuthCSQL(), bkgInternetAuthorityVO,null);
    					for(int i = 0; i < insCnt.length; i++){
    						if(insCnt[i]== Statement.EXECUTE_FAILED)
    							throw new DAOException("Fail to insert No"+ i + " SQL");
    					}
    				}
    			} catch (SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage(),se);
    			}catch(Exception ex){
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    			}
    		}
    		
    		/**
    		 * select B/L Signature List
    		 * @param String countryCode
    		 * @param String eSignatureLastNm
    		 * @return List<BlESignatureVO>
    		 * @throws DAOException
    		 */
    		public List<BlESignatureVO> searchBlESignatureList(String countryCode, String eSignatureLastNm) throws DAOException {
    			DBRowSet dbRowset = null;
    			List<BlESignatureVO> list = null;
    			//query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			//velocity parameter
    			Map<String, Object> velParam = new HashMap<String, Object>();

    			try{
    				param.put("country_code", countryCode);
    				param.put("esignature_last_name", eSignatureLastNm);
    				
    				velParam.putAll(param);
    				
    				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchBlESignatureListRSQL(), param, velParam);
    				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlESignatureVO .class);
    			} catch(SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage());
    			} catch(Exception ex) {
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage());
    			}
    			return list;
    		}
    		
    		/**
    		 * select B/L Signature List
    		 * @param String blEsigSeq
    		 * @return List<BlESignatureVO>
    		 * @throws DAOException
    		 */
    		public List<BlESignatureVO> searchBlESignature(String blEsigSeq) throws DAOException {
    			DBRowSet dbRowset = null;
    			List<BlESignatureVO> list = null;
    			//query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			//velocity parameter
    			Map<String, Object> velParam = new HashMap<String, Object>();

    			try{
    				param.put("bl_esig_seq", blEsigSeq);
    				
    				velParam.putAll(param);
    				
    				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchBlESignatureListRSQL(), param, velParam);
    				list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlESignatureVO .class);
    			} catch(SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage());
    			} catch(Exception ex) {
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage());
    			}
    			return list;
    		}
    		
    		/**
    		 * add B/L Signature
    		 * @param BlESignatureVO blESignatureVO
    		 * @param SignOnUserAccount account
    		 * @throws DAOException
    		 */
    		public void addBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws DAOException {
    			Map<String, String> mapVO = null;
    			//query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			//velocity parameter
    			Map<String, Object> velParam = new HashMap<String, Object>();

    			try{
    				if(blESignatureVO != null){
    					mapVO = blESignatureVO .getColumnValues();
    					param.putAll(mapVO);
    					velParam.putAll(mapVO);
    					param.put("cre_usr_id", account.getUsr_id());
    					param.put("upd_usr_id", account.getUsr_id());
    				}
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOAddBlESignatureCSQL(), param, velParam);
    				if(result == Statement.EXECUTE_FAILED){
    					throw new DAOException("Fail to insert No"+ " SQL");
    				}
    						
    			} catch(SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage());
    			} catch(Exception ex) {
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage());
    			}
    		}
    		
    		/**
    		 * add B/L Signature
    		 * @param BlESignatureVO blESignatureVO
    		 * @param SignOnUserAccount account
    		 * @throws DAOException
    		 */
    		public void modifyBlESignature(BlESignatureVO blESignatureVO, SignOnUserAccount account) throws DAOException {
    			Map<String, String> mapVO = null;
    			//query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			//velocity parameter
    			Map<String, Object> velParam = new HashMap<String, Object>();

    			try{
    				if(blESignatureVO != null){
    					mapVO = blESignatureVO .getColumnValues();
    					param.putAll(mapVO);
    					velParam.putAll(mapVO);
    					param.put("upd_usr_id", account.getUsr_id());
    				}
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOModifyBlESignatureUSQL(), param, velParam);
    				if(result == Statement.EXECUTE_FAILED){
    					throw new DAOException("Fail to insert No"+ " SQL");
    				}
    						
    			} catch(SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage());
    			} catch(Exception ex) {
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage());
    			}
    		}
    		
    		/**
    		 * remove B/L Signature
    		 * @param String blEsigSeq
    		 * @throws DAOException
    		 */
    		public void removeBlESignature(String blEsigSeq) throws DAOException {
//    			Map<String, String> mapVO = null;
    			//query parameter
    			Map<String, Object> param = new HashMap<String, Object>();
    			//velocity parameter
    			Map<String, Object> velParam = new HashMap<String, Object>();

    			try{
    				if(blEsigSeq != null && blEsigSeq.length() > 0){
    					param.put("bl_esig_seq", blEsigSeq);
    					velParam.put("bl_esig_seq", blEsigSeq);
    				}
    				SQLExecuter sqlExe = new SQLExecuter("");
    				int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAORemoveBlESignatureDSQL(), param, velParam);
    				if(result == Statement.EXECUTE_FAILED){
    					throw new DAOException("Fail to insert No"+ " SQL");
    				}
    						
    			} catch(SQLException se) {
    				log.error(se.getMessage(),se);
    				throw new DAOException(new ErrorHandler(se).getMessage());
    			} catch(Exception ex) {
    				log.error(ex.getMessage(),ex);
    				throw new DAOException(new ErrorHandler(ex).getMessage());
    			}
    		}
    		
	//------------------------------------------------------------------------ SJH.20141121.ADD : Place of issue association (list, popup)
	
	/**
	 * select Place of issue association List
	 * @param String countryCode
	 * @param String blIssOfcNm
	 * @return List<PlaceOfIssueAssociationVO>
	 * @throws DAOException
	 * @author 9014750
	 */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociationList(String countryCode, String blIssOfcNm) throws DAOException {
		DBRowSet dbRowset = null;
		List<PlaceOfIssueAssociationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("cnt_cd", countryCode);
			param.put("bl_iss_ofc_nm", blIssOfcNm);
			
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlaceOfIssueAssociationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}    
	
	/**
	 * remove Place of issue association
	 * @param String blEsigAsgnSeq
	 * @throws DAOException
	 */
	public void removePlaceOfIssueAssociation(String blEsigAsgnSeq) throws DAOException {
//		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blEsigAsgnSeq != null && blEsigAsgnSeq.length() > 0){
				param.put("bl_esig_asgn_seq", blEsigAsgnSeq);
				velParam.put("bl_esig_asgn_seq", blEsigAsgnSeq);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAORemovePlaceOfIssueAssociationDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * select Place of issue association popup
	 * @param String blEsigAsgnSeq
	 * @return List<PlaceOfIssueAssociationVO>
	 * @throws DAOException
	 */
	public List<PlaceOfIssueAssociationVO> searchPlaceOfIssueAssociation(String blEsigAsgnSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<PlaceOfIssueAssociationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("bl_esig_asgn_seq", blEsigAsgnSeq);
			
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchPlaceOfIssueAssociationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlaceOfIssueAssociationVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * add Place of issue association
	 * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(placeOfIssueAssociationVO != null){
				mapVO = placeOfIssueAssociationVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOAddPlaceOfIssueAssociationCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * add Place of issue association
	 * @param PlaceOfIssueAssociationVO placeOfIssueAssociationVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyPlaceOfIssueAssociation(PlaceOfIssueAssociationVO placeOfIssueAssociationVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(placeOfIssueAssociationVO != null){
				mapVO = placeOfIssueAssociationVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOModifyPlaceOfIssueAssociationUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}    		
	
	
	/**
	 * searchEmployeeList
	 * @param String countryCode
	 * @return List<PlaceOfIssueAssociationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PlaceOfIssueAssociationVO> searchEmployeeList(String countryCode) throws DAOException {
		DBRowSet dbRowset = null;
		List<PlaceOfIssueAssociationVO> list = null;
//		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//SJH.20141125.MOD : PARAM
			param.put("cnt_cd", countryCode);	
			velParam.putAll(param);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOEmployeeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PlaceOfIssueAssociationVO .class);
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
	 * checkUserInfo
	 * @param BkgInternetAuthorityVO vo
	 * @return boolean
	 * @throws DAOException
	 */	
	public boolean checkUserInfo(BkgInternetAuthorityVO vo) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UserSetupMgtDBDAOSearchUserInfoRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnChk;
	}	
	
    /**
     * searchCntCd
     * 
     * @author KimYoungchul
     * @param String orgCntCd
     * @return List<BlCluzStupVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BlCluzStupVO> searchBlCluzStup(String orgCntCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<BlCluzStupVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try{
            
            Map<String, String> mapVO = new HashMap<String, String>();
            mapVO.put("org_cnt_cd", orgCntCd);
             
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOSearchBlCluzStupRSQL template = new UserSetupMgtDBDAOSearchBlCluzStupRSQL();
            dbRowset = sqlExe.executeQuery(template, param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BlCluzStupVO.class);
        } catch(SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    } 		

    /**
     * Add record into BKG_BL_CLUZ_STUP.<br>
     * 
     * @param   BlCluzStupVO blCluzStupVO
     * @exception   DAOException
     */
    public void addBlCluzStup(BlCluzStupVO blCluzStupVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
            Map<String, String> mapVO = blCluzStupVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOAddBlCluzStupCSQL template = new UserSetupMgtDBDAOAddBlCluzStupCSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                        throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     *Update BKG_BL_CLUZ_STUP.<br>
     * 
     * @param   BlCluzStupVO blCluzStupVO
     * @exception   DAOException
     */
    public void modifyBlCluzStup(BlCluzStupVO blCluzStupVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
            Map<String, String> mapVO = blCluzStupVO.getColumnValues();
 
            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAOModifyBlCluzStupUSQL template = new UserSetupMgtDBDAOModifyBlCluzStupUSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                        throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }

    /**
     * Delete from BKG_BL_CLUZ_STUP.<br>
     * 
     * @param   BlCluzStupVO blCluzStupVO
     * @exception   DAOException
     */
    public void removeBlCluzStup(BlCluzStupVO blCluzStupVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();                       
        try {
            Map<String, String> mapVO = blCluzStupVO.getColumnValues();
        
            param.putAll(mapVO);
            velParam.putAll(mapVO);
                   
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            UserSetupMgtDBDAORemoveBlCluzStupDSQL template = new UserSetupMgtDBDAORemoveBlCluzStupDSQL();
            int insCnt = sqlExe.executeUpdate(template, param,velParam);
            if(insCnt == Statement.EXECUTE_FAILED)
                        throw new DAOException(new ErrorHandler("COM12240").getMessage());
        } catch (SQLException se) {
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        }catch(Exception ex){
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }
}
