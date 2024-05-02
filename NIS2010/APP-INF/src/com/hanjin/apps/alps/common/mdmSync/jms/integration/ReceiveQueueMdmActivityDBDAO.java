/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_ACTIVITYDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> - 
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmActivityDBDAO extends DBDAOSupport{
	
	/** Adding some data into mdm_activity table
	  *  @parameter List<SearchMdmActivityVO
	  *  @throw
	  *
	  */
	public boolean addMdmActivity(List<MdmActivityVO> list) throws DAOException {
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (list.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmActivityDBDAOAddMdmActivityCSQL(), list, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into mdm_activity:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into mdm_activity:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;
	}
	 /** Updating mdm_activity table
	  *  @parameter List<SearchMdmActivityVO
	  *  @throw
	  */
   public boolean modifyMdmActivity(List<MdmActivityVO> schMdmActVOs)throws DAOException{
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (schMdmActVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmActivityDBDAOModifyMdmActivityUSQL(), schMdmActVOs, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into mdm_activity:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into mdm_activity:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;   	
   }
   
   /**Removing mdm_activity Table
    * However, actually just only updating one of flag,
    * the other system may work out the deleting process.
    * @parameter List<SearchMdmActivityVO
    * @throws
    */
	public boolean removeMdmActivity(List<MdmActivityVO> schMdmActVOs)throws DAOException{
	log.debug("###   MDM_ACTIVITY - ReceiveQueueMdmActivityDBDAO  ###  removeMdmActivity Start" );
		boolean resultFlag = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(schMdmActVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmActivityDBDAORemoveMdmActivityUSQL(), schMdmActVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No"+ i + " SQL");
				}
			}//if
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("Removing data from mdm_activity:",new String[]{}).getMessage());
		} catch(Exception ex){
			resultFlag = false;
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("Removing data from mdm_activity:",new String[]{}).getMessage());
		}//try
	log.debug("###   MDM_ACTIVITY - ReceiveQueueMdmActivityDBDAO  ###  removeMdmActivity End" );
	return resultFlag;	
	}
	
	/** Estimating Organization List and then, 
	 * if the amount of number of list is greater than 0, it would return false 
	 * otherwise, return true
    * @parameter List<SearchMdmActivityVO
    * @throws	 
    *
    */
	public boolean searchMdmActivityList(String act_cd)throws DAOException{
		boolean isSuccessful = true;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Putting one Parameter into HashMap
			if (act_cd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("act_cd", act_cd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}//if   
			
		    dbRowset = new SQLExecuter("").executeQuery(
				(ISQLTemplate) new ReceiveQueueMdmActivityDBDAOSearchMdmActivityListRSQL(),
				param, velParam);
			    if(dbRowset.getRowCount()>0){
			    	isSuccessful = false;
			    }else{
			    	isSuccessful = true;
			    }//if
		} catch (SQLException se) {
			isSuccessful = true;
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			isSuccessful = true;
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}//try
		return isSuccessful;
	}
	

}
