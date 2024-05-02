/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveQueueMdmOrganizationDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-08
 *@LastModifier : Jun Byoung Suk
 *@LastVersion : 1.0
 *2009-09-08 Jun Byoung Suk
 * 1.0 최초 생성
 * 2009-12-09 전병석
 * 1.3 import 정리
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.common.mdmSync.jms.vo.SearchMdmOrganizationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

public class ReceiveQueueMdmOrganizationDBDAO extends DBDAOSupport{
	/** Adding some data into mdm_organization table
	  *  @parameter List<SearchMdmOrganizationVO
	  *  @throw
	  *
	  */
	public boolean addMdmOrganization(List<SearchMdmOrganizationVO> schMdmOrgzVOs) throws DAOException {
		   boolean resultFlag = false;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				log.error("\n !addMdmOrganization1");
				if (schMdmOrgzVOs.size() > 0) {
					
					log.error("\n !addMdmOrganization2");
					log.error("\n schMdmOrgzVOs.get(0).toString() : \n"+schMdmOrgzVOs.get(0).toString());
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmOrganizationDBDAOAddMdmOrganizationCSQL(), schMdmOrgzVOs, null);
					log.error("\n !AddMdmOrganizationCSQL addMdmOrganization3");
					log.equals("insCnt : "+insCnt);
					for (int i = 0; i < insCnt.length; i++) {
						log.error("\n !addMdmOrganization4");
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
						log.error("\n !addMdmOrganization5");
						
					}
				}
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into mdm_organization:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into mdm_organization:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;
	}
	 /** Updating mdm_organization table
	  *  @parameter List<SearchMdmOrganizationVO
	  *  @throw
	  */
    public boolean modifyMdmOrganization(List<SearchMdmOrganizationVO> schMdmOrgzVOs)throws DAOException{
		   boolean resultFlag = false;
			try {
				log.debug("\n schMdmOrgzVOs.size() : "+schMdmOrgzVOs.size());
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if (schMdmOrgzVOs.size() > 0) {
					insCnt = sqlExe.executeBatch((ISQLTemplate) new ReceiveQueueMdmOrganizationDBDAOModifyMdmOrganizationCSQL(), schMdmOrgzVOs, null);
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}//if
				resultFlag = true;
			} catch (SQLException se) {
				resultFlag = false;
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler("Inserting into mdm_organization:",new String[]{}).getMessage());
			} catch (Exception ex) {
				resultFlag = false;
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler("Inserting into mdm_organization:",new String[]{}).getMessage());
			}//try
		
		return resultFlag;   	
    }
    
    /**Removing MDM_Organization Table
     * However, actually just only updating one of flag,
     * the other system may work out the deleting process.
     * @parameter List<SearchMdmOrganizationVO
     * @throws
     */
	public boolean removeMdmOrganization(List<SearchMdmOrganizationVO> schMdmOrgzVOs)throws DAOException{
	log.debug("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  removeMdmOrganization Start" );
		boolean resultFlag = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(schMdmOrgzVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ReceiveQueueMdmOrganizationDBDAORemoveMdmOrganizationUSQL(), schMdmOrgzVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No"+ i + " SQL");
				}
			}//if
			resultFlag = true;
		} catch (SQLException se) {
			resultFlag = false;
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("Removing data from mdm_organization:",new String[]{}).getMessage());
		} catch(Exception ex){
			resultFlag = false;
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("Removing data from mdm_organization:",new String[]{}).getMessage());
		}//try
	log.debug("###   MDM_ORGANIZATION - ReceiveQueueMdmOrganizationDBDAO  ###  removeMdmOrganization End" );
	return resultFlag;	
	}
	
	/** Estimating Organization List and then, 
	 * if the amount of number of list is greater than 0, it would return false 
	 * otherwise, return true
     * @parameter List<SearchMdmOrganizationVO
     * @throws	 
     *
     */
	public boolean searchMdmOrganizationList(String ofc_cd)throws DAOException{
		boolean isSuccessful = true;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			//Putting one Parameter into HashMap
			if (ofc_cd != null) {
				Map<String, String> mapVO = new HashMap();
				mapVO.put("ofc_cd", ofc_cd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}//if   
			
		    dbRowset = new SQLExecuter("").executeQuery(
				(ISQLTemplate) new ReceiveQueueMdmOrganizationDAOSearchMdmOrganizationListRSQL(),
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
