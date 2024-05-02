/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageBCImpl.java
*@FileTitle      : StatusManageBCImpl
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.integration.StatusManageDBDAO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqQtaStepVerVO;

/**
 * ALPS-StatusManage Business Logic Command Interface<br>
 * - ALPS-StatusManage 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
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
	 * ESM_CSQ_0036 : [이벤트]<br>
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
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param CsqQtaStepVerVO[] csqQtaStepVerVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void cancelConfirmQtaStepVer(CsqQtaStepVerVO[] csqQtaStepVerVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<CsqQtaStepVerVO> updateVoList = new ArrayList<CsqQtaStepVerVO>();
			
			for ( int i=0; i<csqQtaStepVerVOS .length; i++ ) {    
				csqQtaStepVerVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				csqQtaStepVerVOS[i].setBseYr(conditionVO.getFBseYr());
				csqQtaStepVerVOS[i].setBseQtrCd(conditionVO.getFBseQtrCd());
				csqQtaStepVerVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( csqQtaStepVerVOS[i].getIbflag().equals("U")){
					updateVoList.add(csqQtaStepVerVOS[i]);
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
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
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
				dbDao.createQtaStepVer(conditionVO, account.getUsr_id(), "01");
				dbDao.createQtaLodRev(conditionVO, account.getUsr_id(), "01");
			} else if ( step.equals("HO") ) {
				dbDao.createQtaStepVer(conditionVO, account.getUsr_id(), "02");
				dbDao.createQtaPotnMgmtHo(conditionVO, account.getUsr_id(), "02");
			} else if ( step.equals("RHQ") ) {
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
	 * ESM_CSQ_0036 : SEARCH 이벤트 처리<br>
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
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