/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivitiManageBCImpl.java
*@FileTitle : RecoveryActivitiManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.integration.RecoveryActivityManageDBDAO;
import com.clt.apps.opus.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -RecoveryActivityManage Business Logic Basic Command implementation<br>
 * - -RecoveryActivityManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse,RecoveryActivitiManageBC DAO class reference
 * @since J2EE 1.6
 */
public class RecoveryActivityManageBCImpl extends BasicCommandSupport implements RecoveryActivityManageBC {

	// Database Access Object
	private transient RecoveryActivityManageDBDAO dbDao = null;

	/**
	 * RecoveryActivitiManageBCImpl object creation<br>
	 * RecoveryActivitiManageDBDAO creation<br>
	 */
	public RecoveryActivityManageBCImpl() {
		dbDao = new RecoveryActivityManageDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchRecoveryActivityListVO searchRecoveryActivityListVO
	 * @return List<SearchRecoveryActivityManageListVO>
	 * @exception EventException
	 */
	public List<SearchRecoveryActivityListVO> searchRecoveryActivity(SearchRecoveryActivityListVO searchRecoveryActivityListVO) throws EventException {
//		log.debug("abc:bcimpl:getUserOfcCd"+searchRecoveryActivityListVO.getUserOfcCd());
//		log.debug("abc:bcimpl:getN3ptyNo"+searchRecoveryActivityListVO.getN3ptyNo());
		try {   
//			log.debug("abc:bcimpl:getUserOfcCd: "+searchRecoveryActivityListVO.getUserOfcCd());
//			log.debug("abc:bcimpl:getN3ptyNo: "+searchRecoveryActivityListVO.getN3ptyNo());
//			log.debug("abc:bcimpl:getSortNo: "+searchRecoveryActivityListVO.getSortNo());
			return dbDao.searchRecoveryActivityListValue(searchRecoveryActivityListVO);	//2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
		} catch (DAOException ex) {
//			log.debug("abc:exception1");
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
//			log.debug("abc:exception2");
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * <br>
	 * 
	 * @param SearchRecoveryActivityListVO[] searchRecoveryActivityListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiRecoveryActivity(SearchRecoveryActivityListVO[] searchRecoveryActivityListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchRecoveryActivityListVO> insertVoList = new ArrayList<SearchRecoveryActivityListVO>();
			List<SearchRecoveryActivityListVO> updateVoList = new ArrayList<SearchRecoveryActivityListVO>();
			List<SearchRecoveryActivityListVO> deleteVoList = new ArrayList<SearchRecoveryActivityListVO>();
			for ( int i=0; i<searchRecoveryActivityListVO .length; i++ ) {
				if ( searchRecoveryActivityListVO[i].getIbflag().equals("I")){
					searchRecoveryActivityListVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(searchRecoveryActivityListVO[i]);
				} else if ( searchRecoveryActivityListVO[i].getIbflag().equals("U")){
					searchRecoveryActivityListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchRecoveryActivityListVO[i]);
				} else if ( searchRecoveryActivityListVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchRecoveryActivityListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiRecoveryActivityManageListVOS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiRecoveryActivityManageListVOS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiRecoveryActivityManageListVOS(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
}