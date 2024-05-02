/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : BasicDataBCImpl.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 

=========================================================*/
package com.clt.apps.opus.esm.spc.dailyforecast.basicdata.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration.BasicDataDBDAO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * DailyForecast Business Logic Basic Command implementation<br>
 * - handling business transaction for DailyForecast<br>
 *
 * @author 
 * @see ESM_SPC_0100EventResponse,BasicDataBC  (Reference DAO Class of each)
 * @since J2EE 1.6 
 */
public class BasicDataBCImpl extends BasicCommandSupport implements BasicDataBC {

	// Database Access Object
	private transient BasicDataDBDAO dbDao = null;

	/**
	 * BasicDataBCImpl Object Creation<br>
	 * BasicDataDBDAO Object Creation<br>
	 */
	public BasicDataBCImpl() {
		dbDao = new BasicDataDBDAO();
	}

	/**
	 * EsmSpc0100Event retrieve event process<br>
	 * forecast manabe by vvd retrieve<br>
	 *
	 * @param SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO
	 * @return List<SearchDailyForcastManageByVvdListVO>
	 * @exception EventException
	 */		
	public List<SearchDailyForcastManageByVvdListVO> searchDailyForcastManageByVvdList(SearchDailyForcastManageByVvdListConditionVO searchDailyForcastManageByVvdListConditionVO) throws EventException {
		try {
			return dbDao.searchDailyForcastManageByVvdList(searchDailyForcastManageByVvdListConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmSpc0100Event retrieve event process<br>
	 * forecast manage by week retrieve<br>
	 *
	 * @param SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO
	 * @return List<SearchDailyForcastManageByWeekListVO>
	 * @exception EventException
	 */		
	public List<SearchDailyForcastManageByWeekListVO> searchDailyForcastManageByWeekList(SpcFcastOfcPolMapgConditionVO spcFcastOfcPolMapgConditionVO) throws EventException {
		try {
			return dbDao.searchDailyForcastManageByWeekList(spcFcastOfcPolMapgConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * EsmSpc0100Event save event process<br>
	 * daily forecast vvd manage save<br>
	 *
	 * @param SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void multiDailyForcastVvdManage(SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcIrrFcastOfcPolMapgVO> insertVoList = new ArrayList<SpcIrrFcastOfcPolMapgVO>();
			
			List<SpcIrrFcastOfcPolMapgVO> deleteVoList = new ArrayList<SpcIrrFcastOfcPolMapgVO>();
			for ( int i=0; i<spcIrrFcastOfcPolMapgVO .length; i++ ) {
				if ( spcIrrFcastOfcPolMapgVO[i].getIbflag().equals("I")){
					spcIrrFcastOfcPolMapgVO[i].setCreUsrId(account.getUsr_id());
					spcIrrFcastOfcPolMapgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcIrrFcastOfcPolMapgVO[i]);
				} else if ( spcIrrFcastOfcPolMapgVO[i].getIbflag().equals("U")){
					spcIrrFcastOfcPolMapgVO[i].setCreUsrId(account.getUsr_id());
					spcIrrFcastOfcPolMapgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcIrrFcastOfcPolMapgVO[i]);
					deleteVoList.add(spcIrrFcastOfcPolMapgVO[i]);
				} else if ( spcIrrFcastOfcPolMapgVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcIrrFcastOfcPolMapgVO[i]);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiDailyForcastVvdManageS(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiDailyForcastVvdManageS(insertVoList);
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
	 * EsmSpc0100Event save event process
	 * daily forecast manage save
	 * 
	 * @param SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */		
	public void multiDailyForcastManage(SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpcFcastOfcPolMapgVO> insertVoList = new ArrayList<SpcFcastOfcPolMapgVO>();
			List<SpcFcastOfcPolMapgVO> deleteVoList = new ArrayList<SpcFcastOfcPolMapgVO>();
			
			for ( int i=0; i<spcFcastOfcPolMapgVO .length; i++ ) {
				if ( spcFcastOfcPolMapgVO[i].getIbflag().equals("I")){
					spcFcastOfcPolMapgVO[i].setCreUsrId(account.getUsr_id());
					spcFcastOfcPolMapgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(spcFcastOfcPolMapgVO[i]);
					
				} else if ( spcFcastOfcPolMapgVO[i].getIbflag().equals("U")){
					
					deleteVoList.add(spcFcastOfcPolMapgVO[i]);

					spcFcastOfcPolMapgVO[i].setCreUsrId(account.getUsr_id());
					spcFcastOfcPolMapgVO[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(spcFcastOfcPolMapgVO[i]);
					

				} else if ( spcFcastOfcPolMapgVO[i].getIbflag().equals("D")){
					deleteVoList.add(spcFcastOfcPolMapgVO[i]);
					
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiDailyForcastManageS(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiDailyForcastManageS(insertVoList);
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
	 * Checking port with Lane, Bound<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkLanePortValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws EventException {
		try {
			return dbDao.checkLanePortValid(spcFcastOfcPolMapgVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Checking that inputted office is a regional office<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkOfficeValid(SpcFcastOfcPolMapgVO spcFcastOfcPolMapgVO) throws EventException {
		try {
			return dbDao.checkOfficeValid(spcFcastOfcPolMapgVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * validating vvd<br>
	 * 
	 * @param SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO
	 * @return String
	 * @exception EventException
	 */
	public String checkVvdValid(SpcIrrFcastOfcPolMapgVO spcIrrFcastOfcPolMapgVO) throws EventException {
		try {
			return dbDao.checkVvdValid(spcIrrFcastOfcPolMapgVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	
}