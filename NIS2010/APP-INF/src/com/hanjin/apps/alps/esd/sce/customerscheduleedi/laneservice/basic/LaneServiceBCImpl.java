/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceBCImpl.java
 *@FileTitle : LaneServiceBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.integration.LaneServiceDBDAO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command implementation<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public class LaneServiceBCImpl  extends BasicCommandSupport implements LaneServiceBC {
	// Database Access Object
	private transient LaneServiceDBDAO dbDao=null;
	// EAI Interface Object
	//private transient LaneServiceSendEAIDAO eaiDao = null;
	/**
	 * LaneServiceBCImpl 객체 생성<br>
	 * LaneServiceDBDAO 생성한다.<br>
	 */
	public LaneServiceBCImpl(){
		dbDao = new LaneServiceDBDAO();
		//eaiDao = new LaneServiceSendEAIDAO();
	}

	/** 
	 * 화주 ID에 해당하는 이름을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchGetPartnerVO>
	 * @exception EventException
	 */
	public List<SearchGetPartnerVO>  searchCustomerInfo(String partnerId) throws EventException {
		try {
			return dbDao.searchCustomerInfo(partnerId);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Lane Type 화주에게 제공할 Lane을 조회한다.
	 * 
	 * @param String partnerId
	 * @return List<SearchLaneServiceVO>
	 * @exception EventException
	 */
	public List<SearchLaneServiceVO> searchLaneServiceList(String partnerId) throws EventException {
		try {
			return dbDao.searchLaneServiceList(partnerId);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Lane Type인 화주에게 제공할 Lane을 등록/삭제 한다.
	 * 
	 * @param SearchLaneServiceVO[] laneServiceVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLaneService(SearchLaneServiceVO[] laneServiceVOs, SignOnUserAccount account) throws EventException{
		try {
			//List<SearchLaneServiceVO> insertVoList = new ArrayList<SearchLaneServiceVO>();
			List<SearchLaneServiceVO> updateVoList = new ArrayList<SearchLaneServiceVO>();
			List<SearchLaneServiceVO> deleteVoList = new ArrayList<SearchLaneServiceVO>();
			for ( int i=0; i<laneServiceVOs .length; i++ ) {
				if ( laneServiceVOs[i].getIbflag().equals("I")){
					laneServiceVOs[i].setCreUsrId(account.getUsr_id());
					laneServiceVOs[i].setUpdUsrId(account.getUsr_id());
					//insertVoList.add(laneServiceVOs[i]);
					
					dbDao.addLaneService(laneServiceVOs[i]);
				} else if ( laneServiceVOs[i].getIbflag().equals("U")){
					laneServiceVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(laneServiceVOs[i]);
				} else if ( laneServiceVOs[i].getIbflag().equals("D")){
					laneServiceVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(laneServiceVOs[i]);
				}
			}
			/*
			if ( insertVoList.size() > 0 ) {
				dbDao.addLaneService(insertVoList);
			}
			*/
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyLaneService(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeLaneService(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
 
}
