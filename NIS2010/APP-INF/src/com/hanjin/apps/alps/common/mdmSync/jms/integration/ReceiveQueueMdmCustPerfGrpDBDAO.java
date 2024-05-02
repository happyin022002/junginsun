/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_CUSTOMER_GROUPDBDAO.java
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCustPerfGrpVO;
import com.hanjin.syscommon.management.alps.role.event.ComSys007Event;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> - 
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCustPerfGrpDBDAO extends DBDAOSupport{
	
	
	/**
	 * role의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param models 여러 데이타 모델
	 * @see ComSys007Event
	 * @throws DAOException
	 */
	public void addMdmCustPerfGrp(Collection<MdmCustPerfGrpVO> models) throws DAOException {

		int[] insCnt = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size()>0){
				insCnt = sqlExe.executeBatch(new ReceiveQueueMdmCustPerfGrpDBDAOAddMdmCustPerfGrpCSQL(), models,null);
				for(int i=0;i<insCnt.length;i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			
		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * role의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param models 여러 데이타 모델
	 * @see ComSys007Event
	 * @throws DAOException
	 */
	public void modifyMdmCustPerfGrp(Collection<MdmCustPerfGrpVO> models) throws DAOException {
		
		int[] updCnt = null;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size()>0){
				updCnt = sqlExe.executeBatch(new ReceiveQueueMdmCustPerfGrpDBDAOModifyMdmCustPerfGrpUSQL(), models,null);
				for(int i=0;i<updCnt.length;i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
			
			
		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * role의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param models 여러 데이타 모델
	 * @see ComSys007Event
	 * @throws DAOException
	 */
	public void removeMdmCustPerfGrp(Collection<MdmCustPerfGrpVO> models) throws DAOException {
		
		int[] delCnt = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(models.size()>0){
				delCnt = sqlExe.executeBatch(new ReceiveQueueMdmCustPerfGrpDBDAORemoveMdmCustPerfGrpDSQL(), models,null);
				for(int i=0;i<delCnt.length;i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
			
			
		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchExptDetail01VO
	 *            searchExptDetail01VO
	 * @return List<SearchExptDetail01VO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean searchMdmCustomerGroupList(String custGrpId)
			throws DAOException {
		boolean isSuccessful = false; 
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cust_grp_id", custGrpId);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ReceiveQueueMdmCustPerfGrpDBDAOSearchMdmCustomerGroupListRSQL(),
					param, null);

			if(dbRowset.getRowCount() <= 0) isSuccessful = true;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessful;
	}
	
	
}

