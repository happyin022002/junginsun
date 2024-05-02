/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RecoveryActivitiManageBCImpl.java
*@FileTitle : RecoveryActivitiManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-14
*@LastModifier : Jong-Geon Byeon
*@LastVersion : 1.1
* 2008-09-16 Kim Jin-seung		1.0	 최초 생성
* 2009-09-14 Jong-Geon Byeon	1.1 ALPS Migration
* -------------------------------------------------------
* History
* 2010.09.09 변종건 [CHM-201005592-01]	 [TPB] Rose모델-소스 불일치 관련 메서드명 일괄 변경
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.integration.RecoveryActivityManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.processmanage.recoveryactivitymanage.vo.SearchRecoveryActivityListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-RecoveryActivityManage Business Logic Basic Command implementation<br>
 * - ALPS-RecoveryActivityManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author GUN-HA HWANG
 * @see ESD_TPB_0105EventResponse,RecoveryActivitiManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RecoveryActivityManageBCImpl extends BasicCommandSupport implements RecoveryActivityManageBC {

	// Database Access Object
	private transient RecoveryActivityManageDBDAO dbDao = null;

	/**
	 * RecoveryActivitiManageBCImpl 객체 생성<br>
	 * RecoveryActivitiManageDBDAO를 생성한다.<br>
	 */
	public RecoveryActivityManageBCImpl() {
		dbDao = new RecoveryActivityManageDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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