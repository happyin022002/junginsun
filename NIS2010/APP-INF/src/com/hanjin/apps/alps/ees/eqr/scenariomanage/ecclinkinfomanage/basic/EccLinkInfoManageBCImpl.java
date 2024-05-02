/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EccLinkInfoManageBCImpl.java
*@FileTitle : SCNR Link 정보 조회/수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	yongchan shin		2006-10-17		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.24		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.24
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.integration.EccLinkInfoManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.EesEqr0009ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.ecclinkinfomanage.vo.SearchEccLinkInfoVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccLnkVO;

/**
 * ALPS-EccLinkInfoManage Business Logic Basic Command implementation<br>
 * - ALPS-EccLinkInfoManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_009EventResponse,EccLinkInfoManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EccLinkInfoManageBCImpl extends BasicCommandSupport implements EccLinkInfoManageBC {

	// Database Access Object
	private transient EccLinkInfoManageDBDAO dbDao = null;

	/**
	 * EccLinkInfoManageBCImpl 객체 생성<br>
	 * EccLinkInfoManageDBDAO를 생성한다.<br>
	 */
	public EccLinkInfoManageBCImpl() {
		dbDao = new EccLinkInfoManageDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 *  EccLinkInfoManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0009ConditionVO
	 * @return List<SearchEccLinkInfoVO>
	 * @exception EventException
	 */
	public List<SearchEccLinkInfoVO> searchECCLinkInfo(EesEqr0009ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchECCLinkInfo(conditionVO);
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
	 * @param eqrScnrEccLnkVOs EqrScnrEccLnkVO[]
	 * @param scnrId String
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyECCLinkInfo(EqrScnrEccLnkVO[] eqrScnrEccLnkVOs, String scnrId, SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrEccLnkVO> updateVoList = new ArrayList<EqrScnrEccLnkVO>();
			List<EqrScnrEccLnkVO> deleteVoList = new ArrayList<EqrScnrEccLnkVO>();
			
			for ( int i=0; i<eqrScnrEccLnkVOs .length; i++ ) {
				if ( eqrScnrEccLnkVOs[i].getIbflag().equals("U") || eqrScnrEccLnkVOs[i].getIbflag().equals("I")){
					eqrScnrEccLnkVOs[i].setScnrId(scnrId);
					eqrScnrEccLnkVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrEccLnkVOs[i]);
				} else if (eqrScnrEccLnkVOs[i].getIbflag().equals("D")) {
					eqrScnrEccLnkVOs[i].setScnrId(scnrId);
					deleteVoList.add(eqrScnrEccLnkVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyECCLinkInfo(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteECCLinkInfo(deleteVoList);
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