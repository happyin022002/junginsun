/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneExpenseRatioMgtBCImpl.java
*@FileTitle : Bank Information 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.04.30 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.integration.LaneExpenseRatioMgtDBDAO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.ServiceLaneListVO;
import com.clt.apps.opus.vop.pso.portchargebudget.laneexpenseratiomgt.vo.SvcLaneVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PortChargeBudget Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see Reference each DAO class of VSO_PSO_0006EventResponse,LaneExpenseRatioMgtBC
 * @since J2EE 1.6
 */
public class LaneExpenseRatioMgtBCImpl extends BasicCommandSupport implements LaneExpenseRatioMgtBC {

	// Database Access Object
	private transient LaneExpenseRatioMgtDBDAO dbDao = null;

	/**
	 * Creating object LaneExpenseRatioMgtBCImpl <br>
	 * Creating LaneExpenseRatioMgtDBDAO.<br>
	 */
	public LaneExpenseRatioMgtBCImpl() {
		dbDao = new LaneExpenseRatioMgtDBDAO();
	}

	/**
	 * Show Service Lane List registered by PSO_PORT_EXPN_DIV table standard <br>
	 * 
	 * @return List<SvcLaneVO> 
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
	 * Retrieve Standard P/F Type Code and service separator on Service Lane Code input <br>
	 * 
	 * @param String vslSlanCd vsl_slan_cd
	 * @return List<SvcLaneVO> List 
	 * @throws DAOException
	 */

	public List<SvcLaneVO> searchPfLaneTypeList(String vslSlanCd) throws EventException {
		// TODO Auto-generated method stub
		try {
			return dbDao.searchPfLaneTypeList( vslSlanCd );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Lane/Port Expense Ratio Creation"}).getUserMessage());
		} catch (Exception ex) {
			log.error(">>Exception BC : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90005",new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Retrieve Standard P/F SKD Detail info created by lane code input <br>
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
	 * PSO PORT EXPENSE DIVISION table Select<br>
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
	 * save Lane/Port Expense Ratio Creation 
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
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Lane/Port Expense Ratio Creation"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[]{"Lane/Port Expense Ratio Creation"}).getMessage(),ex);
		}
	}

	/**
	 * Rev.Lane & Rev.direction, Direction 존채 하는지 조회.
	 * 
	 * @param ServiceLaneListVO serviceLaneListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRevenueDirection(ServiceLaneListVO serviceLaneListVO) throws EventException {
		try {
			return dbDao.searchRevenueDirection(serviceLaneListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Lane/Port Expense Ratio Revenue direction Checked." }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Lane/Port Expense Ratio Revenue direction Checked." }).getMessage(), ex);
		}
	}

	/**
	 * Rev.direction by Rev.Lane , Direction 조회.
	 * 
	 * @param ServiceLaneListVO serviceLaneListVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRevenueDirectionByRevLane(ServiceLaneListVO serviceLaneListVO) throws EventException {
		try {
			return dbDao.searchRevenueDirectionByRevLane(serviceLaneListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Lane/Port Expense Ratio Revenue direction Search." }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PSO90011", new String[] { "Lane/Port Expense Ratio Revenue direction Search." }).getMessage(), ex);
		}
	}


}