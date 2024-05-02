/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleBCImpl.java
*@FileTitle : Ship Yard Select – Pop up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.integration.TCharIODeliveryScheduleDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutFleetManagement<br>
 *
 * @author 
 * @see ESM_FMS_0082EventResponse,TCharIODeliveryScheduleBC Reference to each DAO Class
 * @since J2EE 1.4
 */

public class TCharIODeliveryScheduleBCImpl extends BasicCommandSupport implements TCharIODeliveryScheduleBC {

	// Database Access Object
	private transient TCharIODeliveryScheduleDBDAO dbDao = null;

	/**
	 * Generating TCharIODeliveryScheduleBCImpl Object<br>
	 * Generating TCharIODeliveryScheduleDBDAO<br>
	 */
	public TCharIODeliveryScheduleBCImpl() {
		dbDao = new TCharIODeliveryScheduleDBDAO();
	}
	
	/**
	 * Retrieving Ship Yard Name<br>
	 * 
	 * @return List<SearchShipYardNameListVO>
	 * @exception EventException
	 */
	public List<SearchShipYardNameListVO> searchShipYardNameList() throws EventException {
		try {
			return dbDao.searchShipYardNameList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01252",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01252",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Creating, Modifying, Deleting Ship Yard Name<br>
	 * 
	 * @param customShpYdVOs CustomShpYdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageShipYardName(CustomShpYdVO[] customShpYdVOs, String usrid) throws EventException{
		try {
			List<CustomShpYdVO> addVoList = new ArrayList<CustomShpYdVO>();
			List<CustomShpYdVO> modifyVoList = new ArrayList<CustomShpYdVO>();
			List<CustomShpYdVO> removeVoList = new ArrayList<CustomShpYdVO>();
			//List<SearchDeliveryScheduleListVO> searchDeliveryScheduleListVO = null;
			
			for ( int i=0; i<customShpYdVOs .length; i++ ) {
				if ( customShpYdVOs[i].getIbflag().equals("I")){
					customShpYdVOs[i].setCreUsrId(usrid);
					customShpYdVOs[i].setUpdUsrId(usrid);
					addVoList.add(customShpYdVOs[i]);
				} else if ( customShpYdVOs[i].getIbflag().equals("U")){
					customShpYdVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customShpYdVOs[i]);
				} else if ( customShpYdVOs[i].getIbflag().equals("D")){
					removeVoList.add(customShpYdVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addShpYds(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyShpYds(modifyVoList);
			}

			if ( removeVoList.size() > 0 ) {
				// Checking Ship Yard Sequence in FMS_NEW_BLD_SKD
				//searchDeliveryScheduleListVO = dbDao.searchCheckShpYdUse(removeVoList);
				
				//if (searchDeliveryScheduleListVO != null && searchDeliveryScheduleListVO.size() > 0) {
					//throw new EventException(new ErrorHandler("FMS01254",new String[]{}).getUserMessage());
				//}

				dbDao.removeShpYds(removeVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("FMS01253",new String[]{}).getUserMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01253",new String[]{}).getUserMessage());
		}
	}
	
	/**
	 * Retrieving Vessel planning to be delivered<br>
	 * 
	 * @param condDeliveryScheduleVO CondDeliveryScheduleVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDeliveryScheduleListVO> searchDeliveryScheduleList(CondDeliveryScheduleVO condDeliveryScheduleVO) throws EventException {
		try {
			condDeliveryScheduleVO.setVslCdSize1(condDeliveryScheduleVO.getVslCdSize1().replace(",", ""));
			condDeliveryScheduleVO.setVslCdSize2(condDeliveryScheduleVO.getVslCdSize2().replace(",", ""));
			return dbDao.searchDeliveryScheduleList(condDeliveryScheduleVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01250",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01250",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Creating, Modifying, Deleting data of Vessel planning to be delivered<br>
	 * 
	 * @param customNewBldSkdVOs CustomNewBldSkdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageDeliverySchedule(CustomNewBldSkdVO[] customNewBldSkdVOs, String usrid) throws EventException{
		try {
			List<CustomNewBldSkdVO> addVoList = new ArrayList<CustomNewBldSkdVO>();
			List<CustomNewBldSkdVO> modifyVoList = new ArrayList<CustomNewBldSkdVO>();
			List<CustomNewBldSkdVO> remofeVoList = new ArrayList<CustomNewBldSkdVO>();
			for ( int i=0; i<customNewBldSkdVOs .length; i++ ) {
				if ( customNewBldSkdVOs[i].getIbflag().equals("I")){
					customNewBldSkdVOs[i].setCreUsrId(usrid);
					customNewBldSkdVOs[i].setUpdUsrId(usrid);
					addVoList.add(customNewBldSkdVOs[i]);
				} else if ( customNewBldSkdVOs[i].getIbflag().equals("U")){
					customNewBldSkdVOs[i].setUpdUsrId(usrid);
					modifyVoList.add(customNewBldSkdVOs[i]);
				} else if ( customNewBldSkdVOs[i].getIbflag().equals("D")){
					remofeVoList.add(customNewBldSkdVOs[i]);
				}
			}
			
			if ( addVoList.size() > 0 ) {
				dbDao.addNewBldSkds(addVoList);
			}

			if ( modifyVoList.size() > 0 ) {
				dbDao.modifyNewBldSkds(modifyVoList);
			}

			if ( remofeVoList.size() > 0 ) {
				dbDao.removeNewBldSkds(remofeVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01251",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01251",new String[]{}).getMessage(), ex);
		}
	}
}