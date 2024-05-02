/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccInfoManageBCImpl.java
*@FileTitle : SCNR ECC 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-09-28		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.20		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.20
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.20 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.integration.EccInfoManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.EesEqr0007ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccInfoVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.eccinfomanage.vo.SearchEccTSTMLInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccVO;
import com.hanjin.syscommon.common.table.EqrScnrTsTmlVO;

/**
 * ALPS-EccInfoManage Business Logic Basic Command implementation<br>
 * - ALPS-EccInfoManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_007EventResponse,EccInfoManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EccInfoManageBCImpl extends BasicCommandSupport implements EccInfoManageBC {

	// Database Access Object
	private transient EccInfoManageDBDAO dbDao = null;

	/**
	 * EccInfoManageBCImpl 객체 생성<br>
	 * EccInfoManageDBDAO를 생성한다.<br>
	 */
	public EccInfoManageBCImpl() {
		dbDao = new EccInfoManageDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  EccInfoManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO   EesEqr0007ConditionVO
	 * @return List<SearchEccInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccInfoVO> searchECCInfo(EesEqr0007ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchECCInfo(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  EccInfoManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO   EesEqr0007ConditionVO
	 * @return List<SearchEccTSTMLInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccTSTMLInfoVO> searchTSTMLInfo(EesEqr0007ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchTSTMLInfo(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Update 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrEccVOs EqrScnrEccVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyECCInfo(EqrScnrEccVO[] eqrScnrEccVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrEccVO> updateVoList = new ArrayList<EqrScnrEccVO>();
			for ( int i=0; i<eqrScnrEccVOs .length; i++ ) {
				if ( eqrScnrEccVOs[i].getIbflag().equals("U")){
					eqrScnrEccVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrEccVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyECCInfo(updateVoList);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Update 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrTsTmlVOs EqrScnrTsTmlVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyTSTMLInfo(EqrScnrTsTmlVO[] eqrScnrTsTmlVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrTsTmlVO> updateVoList = new ArrayList<EqrScnrTsTmlVO>();
			for ( int i=0; i<eqrScnrTsTmlVOs .length; i++ ) {
				if ( eqrScnrTsTmlVOs[i].getIbflag().equals("U")){
					eqrScnrTsTmlVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrTsTmlVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyTSTMLInfo(updateVoList);
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