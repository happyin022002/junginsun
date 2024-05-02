/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficeGeneralInfoMgtDBDAO.java
*@FileTitle : M&R Colleague Tree
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.21 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.ColleagueTreeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcCntcPsonVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.CustomMnrOfcGenInfoVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.officegeneralinfomgt.vo.OfficeGeneralInfoMgtINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS OfficeGeneralInfoMgtDBDAO <br>
 * - ALPS-OfficeGeneralInfoMgtDBDAO system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author chung young hun
 * @see OfficeGeneralInfoMgtImpl 참조
 * @since J2EE 1.6
 */
public class OfficeGeneralInfoMgtDBDAO extends DBDAOSupport {
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO
	 * @return int
	 * @exception DAOException
	 */
    public int removeColleagueTreeData(CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO) throws DAOException {
		//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				Map<String, String> mapVO = customMnrOfcCntcPsonVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOremoveColleagueTreeDataDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		
	}
	 
    /**
     * [EES_MNR_0217]M&R Colleague Tree의 정보를 추가 합니다. <br>
     *
     * @param CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO
     * @return int
     * @exception DAOException
     */
	public int  addColleagueTreeData(CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO) throws DAOException {
		    int result = 0;
		    //query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = customMnrOfcCntcPsonVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOaddColleagueTreeDataCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return result;
	}
	
	/**
	 * [EES_MNR_0217]M&R Colleague Tree의 정보를 조회 합니다. <br>
	 *
	 * @param ColleagueTreeGRPVO colleagueTreeGRPVO
	 * @return ColleagueTreeGRPVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public ColleagueTreeGRPVO searchColleagueTreeListData(ColleagueTreeGRPVO colleagueTreeGRPVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<CustomMnrOfcCntcPsonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		OfficeGeneralInfoMgtINVO invo = colleagueTreeGRPVO.getOfficeGeneralInfoMgtINVO();
		
		try{
			if(invo != null){
				Map<String, String> mapVO = invo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOsearchColleagueTreeListDataRSQL() , param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrOfcCntcPsonVO.class);
			colleagueTreeGRPVO.setCustomMnrOfcCntcPsonVOS(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		 return colleagueTreeGRPVO;
	 }
	

	 /**
	  * [EES_MNR_0010]Repair Approval Authority의 정보를 조회 합니다. <br>
	  *
	  * @param List<CustomMnrOfcGenInfoVO> customMnrOfcGenInfoVOs
	  * @return int
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrOfcGenInfoVO>  searchOfficeGeneralInfoListData(List<CustomMnrOfcGenInfoVO> customMnrOfcGenInfoVOs)throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrOfcGenInfoVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO = (CustomMnrOfcGenInfoVO)customMnrOfcGenInfoVOs.get(0);
		try{
			if(customMnrOfcGenInfoVO != null){
				Map<String, String> mapVO = customMnrOfcGenInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOsearchOfficeGeneralInfoListDataRSQL() , param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrOfcGenInfoVO.class);
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
	  * [EES_MNR_0010]Repair Approval Authority의 정보를 삭제 합니다. <br>
	  *
	  * @param CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO
	  * @return int
	  * @exception DAOException
	  */
	public int removeOfficeGeneralInfoData(CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO) throws DAOException {
		    //query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				if(customMnrOfcGenInfoVO.getCostCd().length() >= 3){
					String tmpcd = customMnrOfcGenInfoVO.getCostCd();
					String eqKndCd = "";
					if(tmpcd.charAt(2) == 'Z'){
						eqKndCd = "Z";
					}else if(tmpcd.charAt(2) == 'G'){
						eqKndCd = "G";
					}else{
						eqKndCd = "U";
					}
					customMnrOfcGenInfoVO.setEqKndCd(eqKndCd);
				}
				Map<String, String> mapVO = customMnrOfcGenInfoVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOremoveOfficeGeneralInfoDataDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		
	}
			 
	/**
	 * [EES_MNR_0010]Repair Approval Authority의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO
	 * @return int
	 * @exception DAOException
	 */
	public int  addOfficeGeneralInfoData(CustomMnrOfcGenInfoVO customMnrOfcGenInfoVO) throws DAOException {
		    int result = 0;
		    //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			if(customMnrOfcGenInfoVO.getCostCd().length() >= 3){
				String tmpcd = customMnrOfcGenInfoVO.getCostCd();
				String eqKndCd = "";
				if(tmpcd.charAt(2) == 'Z'){
					eqKndCd = "Z";
				}else if(tmpcd.charAt(2) == 'G'){
					eqKndCd = "G";
				}else{
					eqKndCd = "U";
				}
				customMnrOfcGenInfoVO.setEqKndCd(eqKndCd);
			}
			Map<String, String> mapVO = customMnrOfcGenInfoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new OfficeGeneralInfoMgtDBDAOaddOfficeGeneralInfoDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		 return result;
	}
}
