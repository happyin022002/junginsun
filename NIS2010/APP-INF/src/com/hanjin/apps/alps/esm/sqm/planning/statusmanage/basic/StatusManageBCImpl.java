/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageBCImpl.java
*@FileTitle      : StatusManageBCImpl
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2015.05.15 이혜민 [CHM-201535608] Freezing전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration.StatusManageDBDAO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmQtaStepVerVO;

/**
 * ALPS-StatusManage Business Logic Command Interface<br>
 * - ALPS-StatusManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see StatusManageDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class StatusManageBCImpl extends BasicCommandSupport implements StatusManageBC {
	
	// Database Access Object
	private transient StatusManageDBDAO dbDao = null;
	
	/**
	 * StatusManageBCImpl 객체 생성<br>
	 * StatusManageDBDAO를 생성한다.<br>
	 */
	public StatusManageBCImpl() {
		dbDao = new StatusManageDBDAO();
	}
	
	/**
	 * ESM_SQM_0028 : [이벤트]<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEstablishingStatusListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEstablishingStatusListVO> searchQtaEstablishingStatusList(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaEstablishingStatusList(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param SqmQtaStepVerVO[] sqmQtaStepVerVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelConfirmQtaStepVer(SqmQtaStepVerVO[] sqmQtaStepVerVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<SqmQtaStepVerVO> updateVoList = new ArrayList<SqmQtaStepVerVO>();
			
			for ( int i=0; i<sqmQtaStepVerVOS .length; i++ ) {    
				sqmQtaStepVerVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmQtaStepVerVOS[i].setBseYr(conditionVO.getFBseYr());
				sqmQtaStepVerVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				sqmQtaStepVerVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmQtaStepVerVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmQtaStepVerVOS[i]);
				}				
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.updateQtaStepVer(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @param String step
	 * @throws EventException
	 */
	public void createQtaStepVer(ConditionVO conditionVO, SignOnUserAccount account, String step) throws EventException{
		try {
			if ( step.equals("GRPB") ) {
			    dbDao.removeQtaStepVer(conditionVO, account.getUsr_id(), "01");
			    dbDao.removeQtaLodRev(conditionVO, account.getUsr_id(), "01");
			    dbDao.removeQtaPotnMgmt(conditionVO, account.getUsr_id(), "01");
			    
				dbDao.createQtaStepVer(conditionVO, account.getUsr_id(), "01");
				dbDao.createQtaLodRev(conditionVO, account.getUsr_id(), "01");
			} else if ( step.equals("HO") ) {
			    dbDao.removeQtaStepVer(conditionVO, account.getUsr_id(), "02");
                dbDao.removeQtaPotnMgmt(conditionVO, account.getUsr_id(), "02");
                
				dbDao.createQtaStepVer(conditionVO, account.getUsr_id(), "02");
				dbDao.createQtaPotnMgmtHo(conditionVO, account.getUsr_id(), "02");
			} else if ( step.equals("RHQ") ) {
			    dbDao.removeQtaStepVer(conditionVO, account.getUsr_id(), "03");
                dbDao.removeQtaPotnMgmt(conditionVO, account.getUsr_id(), "03");
                
				dbDao.createQtaStepVer(conditionVO, account.getUsr_id(), "03");
				dbDao.createQtaPotnMgmtRhq(conditionVO, account.getUsr_id(), "03");
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0028 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Step 별 Count 를 확인] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchQtaStepCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchQtaStepCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfcZeroPortion(ConditionVO conditionVO) throws EventException {
		try {
			List<String> OfcZeroPortion = dbDao.searchOfcZeroPortion(conditionVO);
			return OfcZeroPortion;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createQtaFreezing(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		StatusManageBackEndJob backEndJob = new StatusManageBackEndJob();
		conditionVO.setFUsrId(account.getUsr_id());
		conditionVO.setFGubun("Freezing");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "Qta Freezing");
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String createQtaTransfer(ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		StatusManageBackEndJob backEndJob = new StatusManageBackEndJob();
		conditionVO.setFUsrId(account.getUsr_id());
		conditionVO.setFGubun("Transfer");
		backEndJob.setConditionVO(conditionVO);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "1Q Transfer");
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchBackEndJobVO(String key) throws EventException {
		DBRowSet rowSet;
		String[] rtnArr = new String[2];
		
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			rtnArr[0] = (String) rowSet.getObject("jb_sts_flg");
			rtnArr[1] = (String) rowSet.getObject("jb_usr_err_msg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
		return rtnArr;
	}
}