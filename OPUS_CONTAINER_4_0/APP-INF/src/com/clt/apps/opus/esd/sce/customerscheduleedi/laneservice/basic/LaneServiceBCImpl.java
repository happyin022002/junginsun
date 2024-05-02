/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : LaneServiceBCImpl.java
 *@FileTitle : LaneServiceBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.integration.LaneServiceDBDAO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchLaneServiceVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * CustomerScheduleEdi Business Logic Command implementation<br>
 * - To handle the business logic for CustomerScheduleEdi.<br>
 * 
 * @author 
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
	 * Look up the name of shippers ID.
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
	 * Lane to be provided to shippers Lane Type is a lookup.
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
	 * Lane to be provided to shippers Lane Type is Update/Delete.
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
