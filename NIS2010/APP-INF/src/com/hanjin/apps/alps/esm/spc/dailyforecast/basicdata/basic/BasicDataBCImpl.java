/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BasicDataBCImpl.java
*@FileTitle : DailyForecast
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.07.23 한상훈
* 1.0 Creation
* 
* History
* 2013.05.20 진마리아 [CHM-201324741-01] Lane Office POL 화면 로직 보완 - validation 및 error handling
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.integration.BasicDataDBDAO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListConditionVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByVvdListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SearchDailyForcastManageByWeekListVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.SpcFcastOfcPolMapgVO;
//import com.hanjin.syscommon.common.table.SpcIrrFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcFcastOfcPolMapgVO;
import com.hanjin.apps.alps.esm.spc.dailyforecast.basicdata.vo.SpcIrrFcastOfcPolMapgVO;

/**
 * ALPS-DailyForecast Business Logic Basic Command implementation<br>
 * - ALPS-DailyForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0100EventResponse,BasicDataBC 각 DAO 클래스 참조 
 * @since J2EE 1.6
 */
public class BasicDataBCImpl extends BasicCommandSupport implements BasicDataBC {

	// Database Access Object
	private transient BasicDataDBDAO dbDao = null;

	/**
	 * BasicDataBCImpl 객체 생성<br>
	 * BasicDataDBDAO를 생성한다.<br>
	 */
	public BasicDataBCImpl() {
		dbDao = new BasicDataDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcIrrFcastOfcPolMapgVO[] spcIrrFcastOfcPolMapgVO
	 * @param account SignOnUserAccount
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
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addmultiDailyForcastVvdManageS(insertVoList);
//			}
			for(SpcIrrFcastOfcPolMapgVO vo : insertVoList){
				dbDao.addmultiDailyForcastVvdManage(vo);
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastOfcPolMapgVO[] spcFcastOfcPolMapgVO
	 * @param account SignOnUserAccount
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
			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addmultiDailyForcastManageS(insertVoList);
//			}
			
			for(SpcFcastOfcPolMapgVO vo : insertVoList){
				dbDao.addmultiDailyForcastManage(vo);
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
	 * Lane, Bound 에 등록 가능한 Port인지 체크합니다.<br>
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
	 * 입력한 Office가 Region Office 체크합니다.<br>
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
	 * 입력한 vvd가 valid한지 체크합니다.<br>
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