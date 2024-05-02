/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODockScheduleBCImpl.java
*@FileTitle : D/dock Schedule Input
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.integration.TCharIODockScheduleDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CondDryDockScheduleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.CustomDckSkdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleGraphListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodockschedule.vo.SearchDryDockScheduleListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-TimeCharterInOutFleetManagement Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutFleetManagement<br>
 *
 * @author
 * @see ESM_FMS_0054-1EventResponse,TCharIODockScheduleBC Reference to each DAO Class
 * @since J2EE 1.4
 */

public class TCharIODockScheduleBCImpl extends BasicCommandSupport implements TCharIODockScheduleBC {

	// Database Access Object
	private transient TCharIODockScheduleDBDAO dbDao = null;

	/**
	 * Generating TCharIODockScheduleBCImpl Object<br>
	 * Generating TCharIODockScheduleDBDAO<br>
	 */
	public TCharIODockScheduleBCImpl() {
		dbDao = new TCharIODockScheduleDBDAO();
	}
	
	/**
	 * Retrieving D/Dock Estimated Schedules data<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockEstimatedScheduleList(String vslCd ,String dckSelCd) throws EventException {
		try {
			return dbDao.searchDockEstimatedScheduleList(vslCd, dckSelCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01700",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01700",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving D/Dock Estimated Schedules data<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockEstimatedSchedule(CustomDckSkdVO[] customDckSkdVOs, String usrId) throws EventException{
		try {
			List<CustomDckSkdVO> insertVoList = new ArrayList<CustomDckSkdVO>();
			List<CustomDckSkdVO> updateVoList = new ArrayList<CustomDckSkdVO>();
			List<CustomDckSkdVO> deleteVoList = new ArrayList<CustomDckSkdVO>();
			for ( int i=0; i<customDckSkdVOs .length; i++ ) {
				if ( customDckSkdVOs[i].getIbflag().equals("I")){
					customDckSkdVOs[i].setCreUsrId(usrId);
					insertVoList.add(customDckSkdVOs[i]);
				} else if ( customDckSkdVOs[i].getIbflag().equals("U")){
					customDckSkdVOs[i].setUpdUsrId(usrId);
					updateVoList.add(customDckSkdVOs[i]);
				} else if ( customDckSkdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customDckSkdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDockEstimatedSchedules(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDockEstimatedSchedules(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDockEstimatedSchedules(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01701",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01701",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Saving D/Dock Recommend Schedules data<br>
	 * 
	 * @param customDckSkdVOs CustomDckSkdVO[]
	 * @param usrId String
	 * @exception EventException
	 */
	public void manageDockRecommendSchedule(CustomDckSkdVO[] customDckSkdVOs, String usrId) throws EventException{
		try {
			List<CustomDckSkdVO> insertVoList = new ArrayList<CustomDckSkdVO>();
			List<CustomDckSkdVO> updateVoList = new ArrayList<CustomDckSkdVO>();
			List<CustomDckSkdVO> deleteVoList = new ArrayList<CustomDckSkdVO>();
			for ( int i=0; i<customDckSkdVOs .length; i++ ) {
				if ( customDckSkdVOs[i].getIbflag().equals("I")){
					customDckSkdVOs[i].setCreUsrId(usrId);
					insertVoList.add(customDckSkdVOs[i]);
				} else if ( customDckSkdVOs[i].getIbflag().equals("U")){
					customDckSkdVOs[i].setUpdUsrId(usrId);
					updateVoList.add(customDckSkdVOs[i]);
				} else if ( customDckSkdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(customDckSkdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDockRecommendSchedules(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDockRecommendSchedules(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDockRecommendSchedules(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01703",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01703",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving D/Dock Recommend Schedules data<br>
	 * 
	 * @param vslCd String
	 * @param dckSelCd String
	 * @return List<CustomDckSkdVO>
	 * @exception EventException
	 */
	public List<CustomDckSkdVO> searchDockRecommendScheduleList(String vslCd ,String dckSelCd) throws EventException {
		try {
			return dbDao.searchDockRecommendScheduleList(vslCd, dckSelCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01702",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01702",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving Dry Dock Schedule Graph List <br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleGraphListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleGraphListVO> searchDryDockScheduleGraphList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException {
		try {
			return dbDao.searchDryDockScheduleGraphList(condDryDockScheduleVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01705",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01705",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving  Dry Dock Schedule List<br>
	 * 
	 * @param condDryDockScheduleVO CondDryDockScheduleVO
	 * @return List<SearchDryDockScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDryDockScheduleListVO> searchDryDockScheduleList(CondDryDockScheduleVO condDryDockScheduleVO) throws EventException {
		try {
			return dbDao.searchDryDockScheduleList(condDryDockScheduleVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01704",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01704",new String[]{}).getMessage(), ex);
		}
	}
}