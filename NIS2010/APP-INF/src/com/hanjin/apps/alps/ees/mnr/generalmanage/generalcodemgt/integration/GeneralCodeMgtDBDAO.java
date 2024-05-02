/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeMgtDBDAO.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
   
/** 
 * alps GeneralCodeMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms
 * @see GeneralCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralCodeMgtDBDAO extends DBDAOSupport {

	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeMgtINVO generalCodeMgtINVO
	 * @return List<CustomMnrGenCdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrGenCdVO> searchGeneralCodeListData(GeneralCodeMgtINVO generalCodeMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGenCdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(generalCodeMgtINVO != null){
				if (generalCodeMgtINVO.getMnrCdGrpNo() != null && generalCodeMgtINVO.getMnrCdGrpNo().trim().length() > 0) {
				     param.put("mnr_cd_grp_no", generalCodeMgtINVO.getMnrCdGrpNo());    
				     velParam.put("mnr_cd_grp_no", generalCodeMgtINVO.getMnrCdGrpNo());
				     param.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());    
				     velParam.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());
				} 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGenCdVO .class);
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
  * [EES_MNR_0009]M&R Other Code의 정보를 추가 합니다. <br>
  *
  * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
  * @exception DAOException
  */
	public void addGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL(), customMnrGenCdVOs,null);
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
	 * [EES_MNR_0009]M&R Other Code의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void modifyGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOmodifyGeneralCodeDataUSQL(), customMnrGenCdVOs,null);
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
	 * [EES_MNR_0009]M&R Other Code의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void removeGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){
				velParam.put("mnr_cd_grp_no", customMnrGenCdVOs.get(0).getMnrCdGrpNo());
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOremoveGeneralCodeDataDSQL(), customMnrGenCdVOs,velParam);
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
}
