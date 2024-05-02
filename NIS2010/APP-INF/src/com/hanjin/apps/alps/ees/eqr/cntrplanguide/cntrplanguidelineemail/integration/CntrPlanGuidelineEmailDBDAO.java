/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CntrPlanGuidelineEmailDBDAO.java
*@FileTitle : Guideline Email
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.06
*@LastModifier : YONGCHAN SHIN
*@LastVersion : 1.0
* 2014.01.03 YONGCHAN SHIN
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List; 
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.basic.CntrPlanGuidelineEmailBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1030MultiVO;
import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelineemail.vo.EesEqr1031ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CntrPlanGuidelineEmailDBDAO <br>
 * - ALPS-Guide Email system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 	YONGCHAN SHIN
 * @see 	CntrPlanGuidelineEmailBCImpl.java 참조
 * @since 	J2EE 1.6
 */
public class CntrPlanGuidelineEmailDBDAO extends DBDAOSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	 
	/**
     * Search Guideline Email 수신자 리스트 <br>
     * 
     * @param EesEqr1030ConditionVO condVO
     * @return CommonRsVO
     * @exception DAOException
    */
	public CommonRsVO searchGuidelineEmailList(EesEqr1030ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = condVO.getColumnValues();		
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailListRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-Up ]<br>
	 * 입력될 이메일 수신자 ID 의 검증 및 name/office/email 정보 조회
	 * @param String usr_id
	 * @return EesEqr1030MultiVO
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EesEqr1030MultiVO searchGuidelineEmailUserInfo(String usr_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr1030MultiVO> list = null;
		EesEqr1030MultiVO eesEqr1030MultiVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{			
			param.put("usr_id", usr_id);	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOSearchGuidelineEmailUserInfoRSQL(), param, null);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr1030MultiVO.class);

			if (list != null && list.size() > 0) {
				eesEqr1030MultiVO = list.get(0);
			}			

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return eesEqr1030MultiVO;
	}			
	
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 입력 처리
	 * 
	 * @param List insertVoList
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addGuidelineEmailList(List insertVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL(), insertVoList, velParam);	
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}			
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 입력 처리
	 * 
	 * @param List updateVoList
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void modifyGuidelineEmailList(List updateVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(updateVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOModifyGuidelineEmailListUSQL(), updateVoList, velParam);	
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}			
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
	/**
	 * [ EES_EQR_1030 : Guideline Email Set-up ]<br>
	 * 이메일 수신자 정보를 삭제
	 * 
	 * @param List deleteVoList
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void removeGuidelineEmailList(List deleteVoList) throws DAOException,Exception {
		Map<String, Object> velParam = new HashMap<String, Object>();
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(deleteVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CntrPlanGuidelineEmailDBDAORemoveGuidelineEmailListDSQL(), deleteVoList, velParam);	
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}			
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}		
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * Guideline email 수신자조회
     * @param EesEqr1031ConditionVO condVO
     * @return String
     * @exception DAOException
    */
	public String searchGuidelineEmailContentsRecipient(EesEqr1031ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = condVO.getColumnValues();		
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		//String recipient = "";
		StringBuffer recipient = new StringBuffer();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOSearchContentsRecipientRSQL(), param, velParam);
			
			while (dbRowset.next()){
				//recipient += dbRowset.getString(1) + ";";		
				recipient.append(dbRowset.getString(1) + ";");
			}
			
			log.debug("----------- searchGuidelineEmailContentsRecipient recipient : " + recipient);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return recipient.toString();
	}	
	
	/**
	 * [ EES_EQR_1031 : Guideline Emailing ]<br>
	 * 최근 저장된 GUIDELINE LANE 조회
     * @param EesEqr1031ConditionVO condVO
     * @return String
     * @exception DAOException
    */
	public String searchGuidelineEmailContentsVslLaneCd(EesEqr1031ConditionVO condVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = condVO.getColumnValues();		
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		String vsl_lane_cd = "";
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrPlanGuidelineEmailDBDAOSearchContentsVslLaneCdRSQL(), param, velParam);
			
			//log.debug(dbRowset.isLast());
			
			while (dbRowset.next()){
				if(dbRowset.isLast()) vsl_lane_cd += dbRowset.getString(1); // 마지막은 "," 붙이지 않음	
				else                  vsl_lane_cd += dbRowset.getString(1) + ", ";	 
			}
			
			log.debug("----------- searchGuidelineEmailContentsVslLaneCd vsl_lane_cd : " + vsl_lane_cd);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vsl_lane_cd;
	}	
	
}