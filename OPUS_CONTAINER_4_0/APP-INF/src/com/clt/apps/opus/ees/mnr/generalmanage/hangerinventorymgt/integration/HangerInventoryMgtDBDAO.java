/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtDBDAO.java
*@FileTitle : Hanger Bar Inventory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.15 함형석
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomHangerInventoryListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * COM HangerInventoryMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HyungSeok Ham
 * @see HangerInventoryMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class HangerInventoryMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListINVO hangerInventoryListINVO
	 * @return List<CustomHangerInventoryListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomHangerInventoryListVO> searchHangerInventoryListData(HangerInventoryListINVO hangerInventoryListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomHangerInventoryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hangerInventoryListINVO != null){
				Map<String, String> mapVO = hangerInventoryListINVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HangerInventoryMgtDBDAOsearchHangerInventoryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomHangerInventoryListVO .class);
			
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
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 추가 합니다. <br>
	 *
	 * @param CustomHangerInventoryListVO customHangerInventoryListVOs
	 * @exception DAOException
	 */
	public void addHangerInventoryData(CustomHangerInventoryListVO customHangerInventoryListVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customHangerInventoryListVOs.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to HangerInventoryMgtDBDAOaddHangerInventoryDataCSQL insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 수정 합니다. <br>
	 *
	 * @param CustomHangerInventoryListVO customHangerInventoryListVOs
	 * @exception DAOException
	 */
	public void modifyHangerInventoryData(CustomHangerInventoryListVO customHangerInventoryListVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customHangerInventoryListVOs.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to HangerInventoryMgtDBDAOmodifyHangerInventoryDataUSQL UPDATE SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomHangerInventoryListVO customHangerInventoryListVOs
	 * @exception DAOException
	 */
	public void removeHangerInventoryData(CustomHangerInventoryListVO customHangerInventoryListVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customHangerInventoryListVOs.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to HangerInventoryMgtDBDAOremoveHangerInventoryDataDSQL DELETE SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0224]Hanger Bar Inventory History Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListINVO hangerInventoryListINVO
	 * @return List<CustomHangerInventoryListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomHangerInventoryListVO> searchHangerInventoryDetailListData(HangerInventoryListINVO hangerInventoryListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomHangerInventoryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hangerInventoryListINVO != null){
				Map<String, String> mapVO = hangerInventoryListINVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HangerInventoryMgtDBDAOsearchHangerInventoryDetailListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomHangerInventoryListVO .class);
			
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
		 * [EES_MNR_0109]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
		 *
		 * @param CustomHangerInventoryListVO customHangerInventoryListVOs
		 * @return CustomHangerInventoryListVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 public CustomHangerInventoryListVO searchHangerInventoryData(CustomHangerInventoryListVO customHangerInventoryListVOs) throws DAOException {
			 DBRowSet dbRowset = null; 
			 List<CustomHangerInventoryListVO> customHangerInventoryListVOS = null;
			 CustomHangerInventoryListVO customHangerInventoryListVO = null;
			 //query parameter 
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter 
			 Map<String, Object> velParam = new HashMap<String, Object>();
    
			try{ 

				Map<String, String> mapVO = customHangerInventoryListVOs.getColumnValues();
		     	    
				param.putAll(mapVO);     
				velParam.putAll(mapVO);  
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HangerInventoryMgtDBDAOsearchHangerInventoryDataRSQL(), param, velParam);
				customHangerInventoryListVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomHangerInventoryListVO .class);
				    
				if(customHangerInventoryListVOS.size() > 0){      
					customHangerInventoryListVO = customHangerInventoryListVOS.get(0);	 
				}        
			}catch(SQLException se){    
				log.error(se.getMessage(),se);    
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){   
				log.error(ex.getMessage(),ex);   	
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}    
			 return customHangerInventoryListVO;    
		 }  
		 
}
