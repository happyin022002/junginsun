/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ManageUserDBDAO.java
*@FileTitle : ActivityData Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-29
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 2009-10-06  : hyun-kyoung oh NIS2010 construction 
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchActivityListVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.vo.SearchSKDLogicListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;
import com.hanjin.syscommon.common.table.SceCopSkdLgcVO;

/**
 * ENIS-SCEM Commission에 대한 DB 처리를 담당<br>
 * - ENIS-SCEM Commission Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Se-Hoon PARK
 * @see ActivityDataBCImpl 참조
 * @since J2EE 1.4
 */
public class ActivityDataDBDAO extends DBDAOSupport {

    /**
     * Activity Attribute 의 모든 목록을 가져온다.<br>
     * 
     * @return DBRowSet DB 처리 결과
     * @throws DAOException
     */
	public List<SearchActivityListVO> searchActivityList() throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchActivityListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActivityDataDBDAOSearchActivityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchActivityListVO .class);				

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return list;
	}
	
	/**
     * Activity Attribute Management 을 수정<br>
     * 
     * @param List<MdmActivityVO> updList
     * @return boolean
     * @throws DAOException
     */
    public boolean modifyActivityAttribute(List<MdmActivityVO> updList) throws DAOException {
    	boolean isSuccessful = false;
	     try{
	 		int[] cnt =  new SQLExecuter("").executeBatch((ISQLTemplate)new ActivityDataDBDAOModifyActivityAttributeUSQL(), updList, null);
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}	
			isSuccessful = true;
				
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
		 return isSuccessful;
    }	
		
	/**
     * COP Scheduling Logic 의 모든 목록을 가져온다.<br>
     * 
     * @param String cop_skd_lgc_no
     * @param String srchAll
     * @return List<SearchSKDLogicListVO>
     * @throws DAOException
     */
	public List<SearchSKDLogicListVO> searchSKDLogicList(String cop_skd_lgc_no, String srchAll) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchSKDLogicListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cop_skd_lgc_no", cop_skd_lgc_no);
			param.put("srch_all", srchAll);			
			velParam.put("srch_all", srchAll);			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActivityDataDBDAOSearchSKDLogicListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSKDLogicListVO .class);				

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

        return list;
	}

 
	/**
     * COP Scheduling Logic Registration 의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 
     * @param List<SceCopSkdLgcVO> paramList
     * @return boolean
     * @throws DAOException
     */
    public boolean multiSKDLogic(List<SceCopSkdLgcVO> paramList) throws DAOException {
    	boolean isSuccessful = false;

	     try{

	 		int[] cnt =  new SQLExecuter("").executeBatch((ISQLTemplate)new ActivityDataDBDAOMultiSKDLogicUSQL(), paramList, null);
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No" + i + " SQL");
			}	
			isSuccessful = true;
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
		 return isSuccessful;
    }	

}

