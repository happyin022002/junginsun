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
 * ------------------------------------------------------
 * HISTORY
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - Web Booking Manual Upload Setup Table 추가  
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAOMandatoryItemSetupList2VODSQL;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration.BookingMasterMgtDBDAOMandatoryItemSetupListVODSQL;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemTpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.DraftBlImageVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.TroRmkStupVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgUsrTmpltVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.WebBkgManualUploadSetupVO;

/**
 * NIS2010 UserSetupMgtDAO <br>
 * - NIS2010-BookingMaterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
		 * @param String module
		 * @return List<BkgUsrDfltSetVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO, String module) throws DAOException {
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
				if("BIS".equals(module)){
					param.put("module", module);
					velParam.put("module", module);
					dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetup3RSQL(),param, velParam);
				} else {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchUserPrintSetup3RSQL(),param, velParam);
				}
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
         * searchTroRmkStup
         * 
         * @author WonjooCho
         * @param String bkgTroOfcCd
         * @return List<TroRmkStupVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
        public List<TroRmkStupVO> searchTroRmkStup(String bkgTroOfcCd) throws DAOException {
            DBRowSet dbRowset = null;
            List<TroRmkStupVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("bkg_tro_ofc_cd", bkgTroOfcCd);              

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOTroRmkStupRSQL template = new UserSetupMgtDBDAOTroRmkStupRSQL();
                dbRowset = sqlExe.executeQuery(template, param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, TroRmkStupVO.class);
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
         * @param   TroRmkStupVO troRmkStupVO
         * @exception   DAOException
         */
        public void addTroRmkStup(TroRmkStupVO troRmkStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = troRmkStupVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOTroRmkStupCSQL template = new UserSetupMgtDBDAOTroRmkStupCSQL();
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
         * @param   TroRmkStupVO troRmkStupVO
         * @exception   DAOException
         */
        public void modifyTroRmkStup(TroRmkStupVO troRmkStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = troRmkStupVO.getColumnValues();
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOTroRmkStupUSQL template = new UserSetupMgtDBDAOTroRmkStupUSQL();
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
         * 데이터를 지운다.<br>
         * 
         * @param   TroRmkStupVO troRmkStupVO
         * @exception   DAOException
         */
        public void removeTroRmkStup(TroRmkStupVO troRmkStupVO) throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = troRmkStupVO.getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOTroRmkStupDSQL template = new UserSetupMgtDBDAOTroRmkStupDSQL();
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
         * manageTroRmkStup 중복 체크.<br>
         * 
         * @author wonjoocho
         * @param String bkgTroOfcCd
         * @param String ioBndCd
         * @return String
         * @exception   DAOException
         */
        public String searchTroRmkStupDup(String bkgTroOfcCd, String ioBndCd) throws DAOException {
            DBRowSet dbRowset = null;
            String dup = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("bkg_tro_ofc_cd", bkgTroOfcCd);
                mapVO.put("io_bnd_cd", ioBndCd);

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOTroRmkStupDupRSQL template = new UserSetupMgtDBDAOTroRmkStupDupRSQL();
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
         * Booking Allocation Master Table 화면 정보를 조회한다.<br>
         * 
         * @param BkgAlocMgmtVO bkgAlocMgmtVO
         * @return List<BkgAlocMgmtVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<BkgAlocMgmtVO> searchBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgAlocMgmtVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOBkgAlocMgmtVORSQL template = new UserSetupMgtDBDAOBkgAlocMgmtVORSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAlocMgmtVO.class);

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
         * Booking Allocation Master Table 화면 정보를 저장하는 메소드.
         *
         * @author ChoiMoonHwan
         * @param bkgAlocMgmtVO
         * @exception DAOException
         * @exception Exception
         */
        public void addBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgAlocMgmtVO != null){
    				Map<String, String> mapVO = bkgAlocMgmtVO .getColumnValues();
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			UserSetupMgtDBDAOaddBkgAlocMgmtCSQL template = new UserSetupMgtDBDAOaddBkgAlocMgmtCSQL();
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
         * Booking Allocation Master Detail Table 화면 정보를 저장하는 메소드.
         *
         * @author ChoiMoonHwan
         * @param List<BkgAlocMgmtDetailVO> bkgAlocMgmtDetailVO
         * @exception DAOException
         * @exception Exception
         */
        public void addBkgAlocMgmtDetail(List<BkgAlocMgmtDetailVO> bkgAlocMgmtDetailVO) throws DAOException, Exception {
    		int insCnt[] = null;
    		try {
    			SQLExecuter sqlExe = new SQLExecuter("");
    			if(bkgAlocMgmtDetailVO.size() > 0){
    				insCnt = sqlExe.executeBatch((ISQLTemplate)new UserSetupMgtDBDAOaddBkgAlocMgmtDetailCSQL(), bkgAlocMgmtDetailVO,null);
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
         * Booking Allocation Master Table 화면 정보를 저장하는 메소드.
         *
         * @author ChoiMoonHwan
         * @param bkgAlocMgmtVO
         * @exception DAOException
         * @exception Exception
         */
        public void modifyBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO)  throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOmodifyBkgAlocMgmtUSQL template = new UserSetupMgtDBDAOmodifyBkgAlocMgmtUSQL();
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
         * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
         * 
    	 * @author 		ChoiMoonHwan
         * @param 		BkgAlocMgmtVO bkgAlocMgmtVO
    	 * @exception 	DAOException
    	 */
    	public void removeBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		try{
    			Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOremoveBkgAlocMgmtDSQL(), param,velParam);
    			if(delCnt == Statement.EXECUTE_FAILED)
    				throw new DAOException("Fail to delete SQL");

    		}catch(SQLException se){
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage(), se);
    		}catch(Exception ex){
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    		}
    	}
    	
        /**
         * Booking Allocation Master Detail Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
         * 
    	 * @author 		ChoiMoonHwan
         * @param 		BkgAlocMgmtVO bkgAlocMgmtVO
    	 * @exception 	DAOException
    	 */
    	public void removeBkgAlocDetailMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		try{
    			Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int delCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOremoveBkgAlocMgmtDetailDSQL(), param,velParam);
    			if(delCnt == Statement.EXECUTE_FAILED)
    				throw new DAOException("Fail to delete SQL");

    		}catch(SQLException se){
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage(), se);
    		}catch(Exception ex){
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    		}
    	}
    	
    	/**
    	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
         * 
    	 * @param String valType
    	 * @param String valValue
    	 * @return List<BkgAlocMgmtVO>
    	 * @throws DAOException
    	 */
    	@SuppressWarnings("unchecked")
		public List<BkgAlocMgmtVO> searchBkgAlocValidationData(String valType, String valValue) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<BkgAlocMgmtVO> list = null;
    		
    		Map<String, Object> param = new HashMap<String, Object>();
    		
    		try {
    			param.put("val_type", valType);
    			param.put("val_value", valValue);
    			
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOsearchBkgAlocValidationDataRSQL(), param, null);
    			
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgAlocMgmtVO.class);
    			
    			return list;
    		} catch (SQLException se) {
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		}catch(Exception ex){
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    	}
    	
    	/**
         * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.<br>
         * 
         * @param BkgAlocMgmtVO bkgAlocMgmtVO
         * @return List<BkgAlocMgmtVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<BkgAlocMgmtVO> searchCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgAlocMgmtVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOsearchCmdtNmRSQL template = new UserSetupMgtDBDAOsearchCmdtNmRSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAlocMgmtVO.class);
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
         * Booking Allocation Master Table 화면 정보를 조회한다.<br>
         * 
         * @param BkgAlocMgmtVO bkgAlocMgmtVO
         * @return List<BkgAlocMgmtVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<BkgAlocMgmtVO> searchBkgAlocDupCheckData(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgAlocMgmtVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                       
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL template = new UserSetupMgtDBDAOsearchBkgAlocDupCheckDataRSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAlocMgmtVO.class);

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
         * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.<br>
         * 
         * @param BkgAlocMgmtVO bkgAlocMgmtVO
         * @return List<BkgAlocMgmtVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<BkgAlocMgmtVO> searchGrpCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgAlocMgmtVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = bkgAlocMgmtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOsearchGrpCmdtNmRSQL template = new UserSetupMgtDBDAOsearchGrpCmdtNmRSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgAlocMgmtVO.class);
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
    	 * Booking Allocation Master Table 화면에 Seq 조회.<br>
    	 * 
    	 * @return String
    	 * @exception DAOException
    	 */
    	public String  searchBkgAlocMgmtSeq() throws DAOException {
    		String returnVal = "";
    		DBRowSet dbRowset = null;
    		Map<String, Object> param = new HashMap<String, Object>();
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try{ 

    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOsearchCrsBkgSeqRSQL(), param, velParam);
    			if(dbRowset.next()){ 											
    	 			returnVal = dbRowset.getString("BKG_ALOC_MGMT_SEQ");
    	 		} 
    		} catch(SQLException se) {
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch(Exception ex) {
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    		return returnVal;
    	} 
    	

        /**
         * Draft B/L image 목록을 조회한다.<br>
         * 
         * @param DraftBlImageVO draftBlImageVO
         * @return List<DraftBlImageVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<DraftBlImageVO> searchDraftBlImageList(DraftBlImageVO draftBlImageVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<DraftBlImageVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
            	if(draftBlImageVO != null){
	            	Map<String, String> mapVO = draftBlImageVO.getColumnValues();
	
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);                
            	}
            	
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchDraftBlImageListRSQL(), param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DraftBlImageVO .class);
    			
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
         * draft b/l image 정보를 저장하는 메소드.
         *
         * @author ChaSangyoung
         * @param List<DraftBlImageVO> draftBlImageVO
         * @exception DAOException
         * @exception Exception
         */
        public void addDraftBlImage(List<DraftBlImageVO> draftBlImageVO) throws DAOException, Exception {
    		int insCnt[] = null;
    		try {    			
    			if(draftBlImageVO.size() > 0){
    				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new UserSetupMgtDBDAOAddDraftBlImageCSQL(), draftBlImageVO,null);
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
         * draft b/l image 정보를 수정하는 메소드.
         *
         * @author ChaSangyoug
         * @param List<DraftBlImageVO> draftBlImageVO
         * @exception DAOException
         * @exception Exception
         */
        public void modifyDraftBlImage(List<DraftBlImageVO> draftBlImageVO)  throws DAOException {
    		int updCnt[] = null;
    		try {    			
    			if(draftBlImageVO.size() > 0){
    				updCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new UserSetupMgtDBDAOModifyDraftBlImageUSQL(), draftBlImageVO,null);
    				for(int i = 0; i < updCnt.length; i++){
    					if(updCnt[i]== Statement.EXECUTE_FAILED)
    						throw new DAOException("Fail to update No"+ i + " SQL");
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
         * draft b/l image 정보를  삭제하는 메소드.
         *
         * @author ChaSangyoug
         * @param List<DraftBlImageVO> draftBlImageVO
         * @exception DAOException
         * @exception Exception
         */
        public void removeDraftBlImage(List<DraftBlImageVO> draftBlImageVO)  throws DAOException {
    		int delCnt[] = null;
    		try {    			
    			if(draftBlImageVO.size() > 0){
    				delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new UserSetupMgtDBDAORemoveDraftBlImageDSQL(), draftBlImageVO,null);
    				for(int i = 0; i < delCnt.length; i++){
    					if(delCnt[i]== Statement.EXECUTE_FAILED)
    						throw new DAOException("Fail to delete No"+ i + " SQL");
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
    	 * draft b/l image customer code 존재여부 조회<br>
    	 * @param DraftBlImageVO draftBlImageVO
    	 * @return String
    	 * @exception DAOException
    	 */
    	public String  searchDraftBlImageCustCodeYN(DraftBlImageVO draftBlImageVO) throws DAOException {
    		String custCodeYn = "";
    		DBRowSet dbRowset = null;
    		Map<String, Object> param = new HashMap<String, Object>();
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try{ 
            	if(draftBlImageVO != null){
	            	Map<String, String> mapVO = draftBlImageVO.getColumnValues();
	
	                param.putAll(mapVO);
	                velParam.putAll(mapVO);                
            	}
            	
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchDraftBlImageCustCodeYNRSQL(), param, velParam);
    			if(dbRowset.next()){ 											
    				custCodeYn = dbRowset.getString("CUST_CODE_YN");
    	 		} 
    		} catch(SQLException se) {
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage());
    		} catch(Exception ex) {
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage());
    		}
    		
    		return custCodeYn;
    	}         
        
    	/**
         * Web Booking Manual Upload Setup Table 화면 정보를 조회한다.<br>
         * 
         * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
         * @return List<WebBkgManualUploadSetupVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public List<WebBkgManualUploadSetupVO> searchWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<WebBkgManualUploadSetupVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = webBkgManualUploadSetupVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupVORSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, WebBkgManualUploadSetupVO.class);

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
         * Web Booking Manual Upload Setup Table 화면 정보를 저장하는 메소드.
         *
         * @param webBkgManualUploadSetupVO
         * @exception DAOException
         * @exception Exception
         */
        public void addWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(webBkgManualUploadSetupVO != null){
    				Map<String, String> mapVO = webBkgManualUploadSetupVO .getColumnValues();
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupVOCSQL();
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
         * Web Booking Manual Upload Setup Table 화면 정보를 수정하는 메소드.
         *
         * @param webBkgManualUploadSetupVO
         * @exception DAOException
         * @exception Exception
         */
        public void modifyWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO)  throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = webBkgManualUploadSetupVO.getColumnValues();
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOWebBkgManualUploadSetupVOUSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupVOUSQL();
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
         * Web Booking Manual Upload Setup Table 화면 정보를 삭제하는 메소드.
         *
         * @param webBkgManualUploadSetupVO
         * @exception DAOException
         * @exception Exception
         */
        public void removeWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO)  throws DAOException {
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();                       
            try {
                Map<String, String> mapVO = webBkgManualUploadSetupVO.getColumnValues();
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                       
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOWebBkgManualUploadSetupVODSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupVODSQL();
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
         * Web Booking Manual Upload Setup Table 등록 항목이 중복되는지 체크.<br>
         * 
         * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
         * @return String
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
		public String searchWebBkgManualUploadSetupDupChk(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) throws DAOException {
            DBRowSet dbRowset = null;
            List<WebBkgManualUploadSetupVO> list = null;
            String chkFlg = "0";
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                
            	Map<String, String> mapVO = webBkgManualUploadSetupVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);                
                
                SQLExecuter executer = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOWebBkgManualUploadSetupDueChkRSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupDueChkRSQL();
                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, WebBkgManualUploadSetupVO.class);
                
                chkFlg = Integer.toString(list.size());
                
            } catch(SQLException se) {
                log.error(se.getMessage(), se);
                throw new DAOException(new ErrorHandler(se).getMessage(),se);
            } catch(Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new DAOException(new ErrorHandler(ex).getMessage(),ex);

            }
            return chkFlg;
        }    
        
    	/**
    	 * Web Booking Manual Upload Setup Table 등록 시 VVD와 Country 체크.<br>
    	 * 
    	 * @param String vslCd 
    	 * @param String voyNo 
    	 * @param String dirCd 
    	 * @param String cntCd 
    	 * @return String
    	 * @throws DAOException
    	 */
    	public String searchWebBkgManualUploadSetupvalidateVvdCnt(String vslCd, String voyNo, String dirCd, String cntCd) throws DAOException {
    		String chkFlg = "0";
    		// query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		// velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try {

    			param.put("vsl_cd", vslCd);
    			param.put("skd_voy_no", voyNo);
    			param.put("skd_dir_cd", dirCd);
    			param.put("cnt_cd", cntCd);

    			velParam.put("vsl_cd", vslCd);
    			velParam.put("skd_voy_no", voyNo);
    			velParam.put("skd_dir_cd", dirCd);
    			velParam.put("cnt_cd", cntCd);

    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			UserSetupMgtDBDAOWebBkgManualUploadSetupValidateVvdCntRSQL template = new UserSetupMgtDBDAOWebBkgManualUploadSetupValidateVvdCntRSQL();
    			DBRowSet dbRowset = sqlExe.executeQuery(template, param, velParam);

    			chkFlg = Integer.toString(dbRowset.getRowCount());
    		} catch (SQLException se) {
    			log.error(se.getMessage(), se);
    			throw new DAOException(new ErrorHandler(se).getMessage(), se);
    		} catch (Exception ex) {
    			log.error(ex.getMessage(), ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    		}

    		return chkFlg;
    	}
        
    	
        
    	
        /**
         * 유저id 별로 조회조건정보를 조회한다.
         * @param String usrId
         * @return List<BkgSrchSetVO>
         * @throws DAOException
         */
        @SuppressWarnings("unchecked")
        public List<BkgSrchSetVO> searchUserSearchSet(String usrId) throws DAOException {
            DBRowSet dbRowset = null;
            List<BkgSrchSetVO> list = null;
            //query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            //velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try{
                
                Map<String, String> mapVO = new HashMap<String, String>();
                mapVO.put("usr_id", usrId);              

                param.putAll(mapVO);
                velParam.putAll(mapVO);
                
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOsearchUserSearchSetRSQL template = new UserSetupMgtDBDAOsearchUserSearchSetRSQL();
                dbRowset = sqlExe.executeQuery(template, param, velParam);
                list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgSrchSetVO.class);
            } catch(SQLException se) {
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch(Exception ex) {
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return list;
        } 
        
        
        /**
         * 유저id 별로 조회조건정보를 저장한다.
         * @param List<BkgSrchSetVO> bkgSrchSetVOs
         * @throws DAOException
         * @throws Exception
         */
        public void addUserSearchSet(List<BkgSrchSetVO> bkgSrchSetVOs) throws DAOException, Exception {
    		int insCnt[] = null;
    		try {    			
    			if(bkgSrchSetVOs.size() > 0){
    				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new UserSetupMgtDBDAOAddUserSearchSetCSQL(), bkgSrchSetVOs,null);
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
         * 유저id 별로 조회조건정보를 업데이트한다.
         * @param List<BkgSrchSetVO> updModels
         * @throws DAOException
         * @throws Exception
         */
        public void modifyUserSearchSet(List<BkgSrchSetVO> updModels) throws DAOException, Exception {
            try {
                SQLExecuter sqlExe = new SQLExecuter("");
                int updCnt[] = null;
                if(updModels.size() > 0) {
                    updCnt = sqlExe.executeBatch((ISQLTemplate) new UserSetupMgtDBDAOModifyUserSearchSetUSQL(), updModels, null);
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
         * 유저id 별로 조회조건정보를 삭제한다.
         * @param List<BkgSrchSetVO> delModels
         * @throws DAOException
         * @throws Exception
         */
        public void removeUserSearchSet(List<BkgSrchSetVO> delModels) throws DAOException, Exception {
            try {
                SQLExecuter sqlExe = new SQLExecuter("");
                int delCnt[] = null;
                if(delModels.size() > 0) {
                    delCnt = sqlExe.executeBatch((ISQLTemplate) new UserSetupMgtDBDAORemoveUserSearchSetDSQL(), delModels, null);
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
         * Customer 의 체크 포인트를 조회한다.<br>
         * 
         * @param BkgCustChkPntVO bkgCustChkPntVO
         * @return List<BkgCustChkPntVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
        public List<BkgCustChkPntVO> searchCustChkPnt(BkgCustChkPntVO bkgCustChkPntVO) throws DAOException {
      	  DBRowSet dbRowset = null;
            List<BkgCustChkPntVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try {
            	Map<String, String> mapVO = bkgCustChkPntVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);                

                SQLExecuter executer = new SQLExecuter("DEFAULT");              
                UserSetupMgtDBDAOSearchCustChkPntRSQL template = new UserSetupMgtDBDAOSearchCustChkPntRSQL();

                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCustChkPntVO.class);              
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
         * Customer 체크 포인트 생성<br>
         * 
         * @param 	BkgCustChkPntVO bkgCustChkPntVO
         * @exception 	DAOException
         */
        public void addBkgCustChkPnt(BkgCustChkPntVO bkgCustChkPntVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgCustChkPntVO != null){
    				Map<String, String> mapVO = bkgCustChkPntVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOaddBkgCustChkPntCSQL(), param,velParam);
    			
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
         * Customer 체크 포인트 수정<br>
         * 
         * @param BkgCustChkPntVO bkgCustChkPntVO
         * @exception DAOException
         */
        public void modifyBkgCustChkPnt(BkgCustChkPntVO bkgCustChkPntVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgCustChkPntVO != null){
    				Map<String, String> mapVO = bkgCustChkPntVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOModifyBkgCustChkPntUSQL(), param,velParam);
    			
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
         * 체크 포인트 Item을 조회한다.<br>
         * 
         * @param BkgChkPntItemVO bkgChkPntItemVO
         * @return List<BkgChkPntItemVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
        public List<BkgChkPntItemVO> searchChkPntItem(BkgChkPntItemVO bkgChkPntItemVO) throws DAOException {
      	  DBRowSet dbRowset = null;
            List<BkgChkPntItemVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try {
            	Map<String, String> mapVO = bkgChkPntItemVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);                

                SQLExecuter executer = new SQLExecuter("DEFAULT");              
                UserSetupMgtDBDAOSearchChkPntItemRSQL template = new UserSetupMgtDBDAOSearchChkPntItemRSQL();

                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCustChkPntVO.class);              
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
         * Check Point Item 생성<br>
         * 
         * @param 	BkgChkPntItemVO bkgChkPntItemVO
         * @exception 	DAOException
         */
        public void addBkgChkPntItem(BkgChkPntItemVO bkgChkPntItemVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgChkPntItemVO != null){
    				Map<String, String> mapVO = bkgChkPntItemVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOaddBkgChkPntItemCSQL(), param,velParam);
    			
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
         * Check Point Item 수정<br>
         * 
         * @param BkgChkPntItemVO bkgChkPntItemVO
         * @exception DAOException
         */
        public void modifyBkgChkPntItem(BkgChkPntItemVO bkgChkPntItemVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgChkPntItemVO != null){
    				Map<String, String> mapVO = bkgChkPntItemVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOModifyBkgChkPntItemUSQL(), param,velParam);
    			
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
         * 체크 포인트 Item Type을 조회한다.<br>
         * 
         * @param BkgChkPntItemTpVO bkgChkPntItemTpVO
         * @return List<BkgChkPntItemTpVO>
         * @exception DAOException
         */
        @SuppressWarnings("unchecked")
        public List<BkgChkPntItemTpVO> searchChkPntItemTp(BkgChkPntItemTpVO bkgChkPntItemTpVO) throws DAOException {
      	  DBRowSet dbRowset = null;
            List<BkgChkPntItemTpVO> list = null;
            // query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
            try {
            	Map<String, String> mapVO = bkgChkPntItemTpVO.getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);                

                SQLExecuter executer = new SQLExecuter("DEFAULT");             
                UserSetupMgtDBDAOSearchChkPntItemTpRSQL template = new UserSetupMgtDBDAOSearchChkPntItemTpRSQL();

                dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCustChkPntVO.class);              
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
         * Check Point Item Type 생성<br>
         * 
         * @param 	BkgChkPntItemTpVO bkgChkPntItemTpVO
         * @exception 	DAOException
         */
        public void addBkgChkPntItemTp(BkgChkPntItemTpVO bkgChkPntItemTpVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgChkPntItemTpVO != null){
    				Map<String, String> mapVO = bkgChkPntItemTpVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOaddBkgChkPntItemTpCSQL(), param,velParam);
    			
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
         *  Check Point Item Type 수정<br>
         * @param BkgChkPntItemTpVO bkgChkPntItemTpVO
         * @throws DAOException
         * @throws Exception
         */
        public void modifyBkgChkPntItemTp(BkgChkPntItemTpVO bkgChkPntItemTpVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(bkgChkPntItemTpVO != null){
    				Map<String, String> mapVO = bkgChkPntItemTpVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int updCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOModifyBkgChkPntItemTpUSQL(), param,velParam);
    			
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
    	 *  Attachment File 목록 조회<br>
    	 * 
    	 * @param CustChkPntAttachVO vo
    	 * @return List<CustChkPntAttachVO>
    	 * @throws DAOException
    	 */
    	 @SuppressWarnings("unchecked")
    	public List<CustChkPntAttachVO> searchCustChkPntAttach(CustChkPntAttachVO vo) throws DAOException {
    		 	 
    		DBRowSet dbRowset = null;
    		List<CustChkPntAttachVO> list = null;
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		try{
    			if(vo != null){
    				Map<String, String> mapVO = vo .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}
    					
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOSearchCustChkPntAttachRSQL template = new UserSetupMgtDBDAOSearchCustChkPntAttachRSQL();
    			dbRowset = sqlExe.executeQuery(template, param, velParam);
    			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustChkPntAttachVO .class);
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
    	 * Attach File Link ID 조회<br>
    	 * 
    	 * @param  CustChkPntAttachVO vo
    	 * @return String
    	 * @throws DAOException
    	 */
    	public String searchCustChkPntAttachFileLinkId(CustChkPntAttachVO vo) throws DAOException {
    		String atchFileLnkId = "";
    		DBRowSet dbRowset = null;
    		
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    		try{
    			if(vo != null){
    				Map<String, String> mapVO = vo.getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}
    			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UserSetupMgtDBDAOSearchCustChkPntAttachFileLinkIdRSQL(), param, velParam);
    			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
    				atchFileLnkId = dbRowset.getString("ATCH_FILE_LNK_ID");
    			}
    			
    		} catch (SQLException se) {
    			log.error(se.getMessage(),se);
    			throw new DAOException(new ErrorHandler(se).getMessage(), se);
    		}catch(Exception ex){
    			log.error(ex.getMessage(),ex);
    			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
    		}
    		return atchFileLnkId;
    	}
    	
    	/**
    	 * Attachment를 삭제한다.<br>
    	 * 
    	 * @param List<CustChkPntAttachVO> vos
    	 * @throws DAOException
    	 */
    	public void removeCustChkPntAttach(List<CustChkPntAttachVO> vos) throws DAOException,Exception {
    		try {
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAORemoveCustChkPntAttachDSQL template = new UserSetupMgtDBDAORemoveCustChkPntAttachDSQL();
    			int delCnt[] = null;
    			if(vos.size() > 0){
    				delCnt = sqlExe.executeBatch(template, vos, null);
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
    	 * Attachment 정보를 일괄 등록한다.<br>
    	 * 
    	 * @param List<CustChkPntAttachVO> vos
    	 * @throws DAOException
    	 */
    	public void addCustChkPntAttach(List<CustChkPntAttachVO> vos) throws DAOException,Exception {
    		try {
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int insCnt = 0;
    			if(vos.size() > 0){

    	    		//query parameter
    	    		Map<String, Object> param = new HashMap<String, Object>();
    	    		//velocity parameter
    	    		Map<String, Object> velParam = new HashMap<String, Object>();
    	        	Iterator<CustChkPntAttachVO> list = vos.iterator();
    	        	
    	        	while(list.hasNext()){
    	        		CustChkPntAttachVO vo = (CustChkPntAttachVO)list.next();
    	        		Map<String, String> mapVO = vo.getColumnValues();
    					param.putAll(mapVO);
    					velParam.putAll(mapVO);
    					insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOAddCustChkPntAttachCSQL(), param,velParam);
    					if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
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
    	 * Cust Chk Point에 File Link ID 업데이트<br>
    	 * 
    	 * @param CustChkPntAttachVO vo
    	 * @throws DAOException
    	 */
    	public void modifyCustChkPntAttachFileLinkId(CustChkPntAttachVO vo) throws DAOException,Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    		
    		int result = 0;
    		try {
    			Map<String, String> mapVO = vo.getColumnValues();
    			
    			param.putAll(mapVO);
    			velParam.putAll(mapVO);
    			
                SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
                UserSetupMgtDBDAOModifyCustChkPntAttachFileLinkIdUSQL template = new UserSetupMgtDBDAOModifyCustChkPntAttachFileLinkIdUSQL();
    			result = sqlExe.executeUpdate(template, param, velParam);
    			if(result == Statement.EXECUTE_FAILED) {
    				throw new DAOException("Fail to insert SQL");
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
    	 * Block Keyword List 조회<br>
    	 * 
    	 * @param  String blckKwTpCd
    	 * @return List<BlckKwListVO>
    	 * @throws DAOException
    	 */
    	public List<BlckKwListVO> searchBkgBlckKwList(String blckKwTpCd) throws DAOException {
    		DBRowSet dbRowset = null;
    		List<BlckKwListVO> list = null;
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();
    	
    		try{
    			
				param.put("blck_kw_tp_cd", blckKwTpCd);
				velParam.put("blck_kw_tp_cd", blckKwTpCd);
				UserSetupMgtDBDAOSearchBlckKwListRSQL template = new UserSetupMgtDBDAOSearchBlckKwListRSQL();
				SQLExecuter executer = new SQLExecuter("DEFAULT");
				dbRowset = executer.executeQuery(template, param, velParam);
                list = (List) RowSetUtil.rowSetToVOs(dbRowset, BlckKwListVO.class);
    			
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
         * Bkg Blck Kw List 테이블에 데이터 insert<br>
         * 
         * @param 	BlckKwListVO blckKwListVO
         * @exception 	DAOException
         */
        public void addBkgBlckKwList(BlckKwListVO blckKwListVO) throws DAOException, Exception {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();						
    		try {
    			if(blckKwListVO != null){
    				Map<String, String> mapVO = blckKwListVO .getColumnValues();
    			
    				param.putAll(mapVO);
    				velParam.putAll(mapVO);
    			}							
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new UserSetupMgtDBDAOaddBkgBlckKwListCSQL(), param,velParam);
    			
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
    	 * Bkg Blck Kw List 테이블에 데이터 remove<br>
    	 * 
    	 * @param BlckKwListVO vo
    	 * @throws DAOException
    	 */
    	public void removeBkgBlckKwList(BlckKwListVO vo) throws DAOException {

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
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new UserSetupMgtDBDAORemoveBkgBlckKwListDSQL(), param, velParam);
    			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

    		} catch (SQLException se) {
    			throw new DAOException(new ErrorHandler(se).getMessage(),se);
    		} catch (Exception ex) {
    			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    		}
    	}
    	
    	/**
    	 * Bkg Blck Kw List 테이블에 데이터 update<br>
    	 * 
    	 * @param BlckKwListVO vo
    	 * @throws DAOException
    	 */
    	public void modifyBkgBlckKwList(BlckKwListVO vo) throws DAOException {

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
    			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
    			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new UserSetupMgtDBDAOModifyBkgBlckKwListUSQL(), param, velParam);
    			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

    		} catch (SQLException se) {
    			throw new DAOException(new ErrorHandler(se).getMessage(),se);
    		} catch (Exception ex) {
    			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
    		}
    	}
    	
}
