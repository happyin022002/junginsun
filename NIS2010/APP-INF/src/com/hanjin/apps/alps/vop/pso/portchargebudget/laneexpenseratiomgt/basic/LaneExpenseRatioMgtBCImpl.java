/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneExpenseRatioMgtBCImpl.java
 *@FileTitle : Lane/Port Expense Ratio Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.27
 *@LastModifier : 박명종
 *@LastVersion : 1.0
 * 2009.05.27 박명종
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.integration.LaneExpenseRatioMgtDBDAO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.hanjin.apps.alps.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PortChargeBudget Business Logic Basic Command implementation<br>
 * - ALPS-PortChargeBudget에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author myoungjong park
 * @see VSO_PSO_0006EventResponse,LaneExpenseRatioMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LaneExpenseRatioMgtBCImpl extends BasicCommandSupport implements LaneExpenseRatioMgtBC {

	// Database Access Object
	private transient LaneExpenseRatioMgtDBDAO dbDao = null;

	/**
	 * LaneExpenseRatioMgtBCImpl 객체 생성<br>
	 * LaneExpenseRatioMgtDBDAO를 생성한다.<br>
	 */
	public LaneExpenseRatioMgtBCImpl() {
		dbDao = new LaneExpenseRatioMgtDBDAO();
	}

	/**
	 * PSO_PORT_EXPN_DIV 테이블 기준으로 등록된 Service Lane List를 표시한다.<br>
	 * 
	 * @return List<SvcLaneVO> List 조회결과를 저장하는 ServiceLaneListVO타입의 데이터
	 * @throws DAOException
	 */
	public List<SvcLaneVO> searchLaneExpenseRatioKeyValue() throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchLaneExpenseRatioKeyValue( );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}


	/**
	 * 입력받은 Service Lane Code에 Standard P/F Type Code와 펜드럼 서비스 구분자를 조회한다.<br>
	 * 
	 * @param String vslSlanCd vsl_slan_cd를 조회 조건으로 한다.
	 * @return List<SvcLaneVO> List 조회결과를 저장하는 SvcLaneVO타입의 데이터
	 * @throws DAOException
	 */

	public List<SvcLaneVO> searchPfLaneTypeList(String vslSlanCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchPfLaneTypeList( vslSlanCd );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 입력 받은 Lane Code로 생성된 Standard P/F SKD Detail 정보를 조회한다.<br>
	 * 
	 * @param String vslSlanCd
	 * @return List<ServiceLaneListVO>
	 * @throws EventException
	 */
	public List<ServiceLaneListVO> searchPfSkdDetail(String vslSlanCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<ServiceLaneListVO> list = dbDao.searchPfSkdDetail(vslSlanCd);
			ServiceLaneListVO[] lvo = new ServiceLaneListVO[list.size()];
			List<ServiceLaneListVO> searchServiceLaneVoList = new ArrayList<ServiceLaneListVO>();
			String direct = "";
			int seq = 0;
			if (list != null && list.size() > 0) {
				for ( int i=0; i<list.size(); i++ ) {
					lvo[i] = new ServiceLaneListVO();
					lvo[i] = (ServiceLaneListVO)list.get(i);
					lvo[i].setSlanCd(vslSlanCd);

					if( lvo[i].getSkdDirCd().equals(direct) ){
						seq++;
						lvo[i].setPortSeq(""+seq);
					} else {
						seq = 1;
						lvo[i].setPortSeq(""+seq);
					}

					direct = lvo[i].getSkdDirCd();
					searchServiceLaneVoList.add(lvo[i]);
				}
			}	
			return searchServiceLaneVoList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * PSO PORT EXPENSE DIVISION 테이블 Select<br>
	 * 
	 * @param String vslSlanCd
	 * @return List<ServiceLaneListVO>
	 * @throws EventException
	 */
	public List<ServiceLaneListVO> searchPsoPortExpenseDivision(String vslSlanCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchPsoPortExpenseDivision(vslSlanCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Lane/Port Expense Ratio Creation 저장
	 * @param SvcLaneVO[] svcLaneVO
	 * @param ServiceLaneListVO[] serviceLaneListVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneExpnRto(SvcLaneVO[] svcLaneVO, ServiceLaneListVO[] serviceLaneListVO, SignOnUserAccount account ) throws EventException{
		try {
			List<ServiceLaneListVO> insertServiceLaneVoList = new ArrayList<ServiceLaneListVO>();
			List<ServiceLaneListVO> updateServiceLaneVoList = new ArrayList<ServiceLaneListVO>();
			List<ServiceLaneListVO> deleteServiceLaneVoList = new ArrayList<ServiceLaneListVO>();

			List<SvcLaneVO> updateSvcLaneVOList = new ArrayList<SvcLaneVO>();
			List<SvcLaneVO> deleteSvcLaneVOList = new ArrayList<SvcLaneVO>();

			if (serviceLaneListVO != null && serviceLaneListVO.length > 0) {
				for ( int i=0; i<serviceLaneListVO.length; i++ ) {
					if ( serviceLaneListVO[i].getIbflag().equals("I")){
						serviceLaneListVO[i].setCreUsrId(account.getUsr_id());
						insertServiceLaneVoList.add(serviceLaneListVO[i]);
					} else if ( serviceLaneListVO[i].getIbflag().equals("U")){
						serviceLaneListVO[i].setCreUsrId(account.getUsr_id());
						updateServiceLaneVoList.add(serviceLaneListVO[i]);
					} else if ( serviceLaneListVO[i].getIbflag().equals("D")){
						deleteServiceLaneVoList.add(serviceLaneListVO[i]);
					}
				}
			}				


			if (svcLaneVO != null && svcLaneVO.length > 0) {
				for ( int i=0; i<svcLaneVO.length; i++ ) {
					if ( svcLaneVO[i].getIbflag().equals("U")){
						updateSvcLaneVOList.add(svcLaneVO[i]);
					} else	if ( svcLaneVO[i].getIbflag().equals("D")){
						deleteSvcLaneVOList.add(svcLaneVO[i]);
					}
				}
			}				

			if ( deleteSvcLaneVOList.size() > 0 ) {
				dbDao.removeMdmVslSvcLane(deleteSvcLaneVOList);
			}

			if ( deleteServiceLaneVoList.size() > 0 ) {
				dbDao.removePsoPortExpenseDivision(deleteServiceLaneVoList);
			}

			if ( updateServiceLaneVoList.size() > 0 ) {
				dbDao.modifyPsoPrortExpenseDivision(updateServiceLaneVoList);
			}

			if ( insertServiceLaneVoList.size() > 0 ) {
				dbDao.addPsoPortExpenseDivision(insertServiceLaneVoList);
			}

			if ( updateSvcLaneVOList.size() > 0 ) {
				dbDao.modifyMdmVslSvcLane(updateSvcLaneVOList);
			}			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage(),ex);
		}
	}


}