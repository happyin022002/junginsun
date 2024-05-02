/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastManageBCImpl.java
*@FileTitle : Holiday Effect
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.05 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.integration.CntrForecastManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0079ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0114ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.EesEqr0126ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrforecastmanage.vo.SearchEqrHolidayListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrIbBkgFcastVO;
import com.hanjin.syscommon.common.table.EqrObFcastVO;
import com.hanjin.syscommon.common.table.EqrScnrEccTurnTmVO;

/**
 * ALPS-CntrForecastManage Business Logic Basic Command implementation<br>
 * - ALPS-CntrForecastManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0114EventResponse,CntrForecastManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrForecastManageBCImpl extends BasicCommandSupport implements CntrForecastManageBC {

	// Database Access Object
	private transient CntrForecastManageDBDAO dbDao = null;

	/**
	 * CntrForecastManageBCImpl 객체 생성<br>
	 * CntrForecastManageDBDAO를 생성한다.<br>
	 */
	public CntrForecastManageBCImpl() {
		dbDao = new CntrForecastManageDBDAO();
	}
	/**
	 * [ EES_EQR_0114 : Holiday Effect - Detail PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO EesEqr0114ConditionVO
	 * @param io_bnd_cd String 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchHolidayEffectDetailInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO, String io_bnd_cd) throws EventException {
		try {
			return dbDao.searchHolidayEffectDetailInfo(eesEqr0114ConditionVO, io_bnd_cd);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [ EES_EQR_0114 : Holiday Effect PopUp ]<br>
	 * 
	 * @param eesEqr0114ConditionVO EesEqr0114ConditionVO
	 * @return List<SearchEqrHolidayListVO>
	 * @exception EventException
	 */
	public List<SearchEqrHolidayListVO> searchHolidayEffectInfo(EesEqr0114ConditionVO eesEqr0114ConditionVO) throws EventException {
		try {
			return dbDao.searchHolidayEffectInfo(eesEqr0114ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * 컨테이너 수요 예측(O/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0025ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrForecastInfo(EesEqr0025ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrForecastInfo(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 컨테이너 수요 예측(O/B) 멀티 이벤트 처리<br>
	 * 
	 * @param eqrObFcastVOS EqrObFcastVO[]
	 * @param  scnr_id String
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrForecastInfo(EqrObFcastVO[] eqrObFcastVOS, String scnr_id, SignOnUserAccount account) throws EventException {
		try {
			List<EqrObFcastVO> insertVoList = new ArrayList<EqrObFcastVO>();
			List<EqrObFcastVO> updateVoList = new ArrayList<EqrObFcastVO>();
			List<EqrObFcastVO> deleteVoList = new ArrayList<EqrObFcastVO>();
			
			for ( int i=0; i<eqrObFcastVOS .length; i++ ) {
				if (eqrObFcastVOS[i].getIbflag().equals("I")){
					String fcastDt2 = dbDao.searchDayDate(eqrObFcastVOS[i].getFcastYrwk()).getResultString();
					String fcastDelDt = dbDao.searchDayDate(dbDao.searchWeek(eqrObFcastVOS[i].getFcastYrwk()).getResultString()).getResultString();
					String fcastDelYrwk = dbDao.searchWeek( eqrObFcastVOS[i].getFcastYrwk()).getResultString();
					
					eqrObFcastVOS[i].setScnrId(scnr_id);
					eqrObFcastVOS[i].setFcastDt2(fcastDt2);
					eqrObFcastVOS[i].setFcastDelDt(fcastDelDt);
					eqrObFcastVOS[i].setFcastDelYrwk(fcastDelYrwk);
					eqrObFcastVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(eqrObFcastVOS[i]);
				} else if (eqrObFcastVOS[i].getIbflag().equals("U") ) {
					String fcastDt = dbDao.searchDayDate(eqrObFcastVOS[i].getFcastYrwk()).getResultString();
					
					eqrObFcastVOS[i].setScnrId(scnr_id);
					eqrObFcastVOS[i].setFcastDt(fcastDt);
					eqrObFcastVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrObFcastVOS[i]);
				} else if (eqrObFcastVOS[i].getIbflag().equals("D")) {
					eqrObFcastVOS[i].setScnrId(scnr_id);
					deleteVoList.add(eqrObFcastVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyCntrForecastInfo(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateCntrForecastInfo(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteCntrForecastInfo(deleteVoList);
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
	 * 컨테이너 수요 예측(I/B) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0079ConditionVO
	 * @return  CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrGeneration(EesEqr0079ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrGeneration(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 컨테이너 수요 예측(I/B) 멀티 이벤트 처리<br>
	 * 
	 * @param eqrIbBkgFcastVOS EqrIbBkgFcastVO[]
	 * @param  account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyCntrGeneration(EqrIbBkgFcastVO[] eqrIbBkgFcastVOS, SignOnUserAccount account) throws EventException {
		try {
			List<EqrIbBkgFcastVO> insertVoList = new ArrayList<EqrIbBkgFcastVO>();
			List<EqrIbBkgFcastVO> updateVoList = new ArrayList<EqrIbBkgFcastVO>();
			List<EqrIbBkgFcastVO> deleteVoList = new ArrayList<EqrIbBkgFcastVO>();
			
			for ( int i=0; i<eqrIbBkgFcastVOS .length; i++ ) {
				if (eqrIbBkgFcastVOS[i].getIbflag().equals("I")){
					String fcastDt = dbDao.searchDayDate(eqrIbBkgFcastVOS[i].getFcastYrwk()).getResultString();
					
					eqrIbBkgFcastVOS[i].setFcastDt(fcastDt);
					eqrIbBkgFcastVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(eqrIbBkgFcastVOS[i]);
					
				} else if (eqrIbBkgFcastVOS[i].getIbflag().equals("U") ) {
					String fcastDt = dbDao.searchDayDate(eqrIbBkgFcastVOS[i].getFcastYrwk()).getResultString();
					
					eqrIbBkgFcastVOS[i].setFcastDt(fcastDt);
					eqrIbBkgFcastVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrIbBkgFcastVOS[i]);
					
				} else if (eqrIbBkgFcastVOS[i].getIbflag().equals("D")) {
					String fcastDt = dbDao.searchDayDate(eqrIbBkgFcastVOS[i].getFcastYrwk()).getResultString();
					
					eqrIbBkgFcastVOS[i].setFcastDt(fcastDt);
					deleteVoList.add(eqrIbBkgFcastVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyCntrGeneration(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateCntrGeneration(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteCntrGeneration(deleteVoList);
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
	 * 조회 이벤트 처리<br>
	 * EES_EQR_126 화면에 대한 회면 조회<br>
	 * 
	 * @param conditionVO EesEqr0126ConditionVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchCntrTurnTimeInfo(EesEqr0126ConditionVO conditionVO) throws EventException{

		CommonVO commonVO = null;
		 
		try {
			commonVO = dbDao.searchCntrTurnTimeInfo(conditionVO);
			
			return commonVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	} 

	/**
	 * 멀티  이벤트 처리<br>
	 * EES_EQR_126 화면에 대한 회면 조회<br>
	 * 
	 * @param vos EqrScnrEccTurnTmVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyCntrTurnTimeInfo(EqrScnrEccTurnTmVO[] vos, SignOnUserAccount account) throws EventException{

	    boolean isInsert = false ;      
	    boolean isDelete = false;   
		try {
			List insModels 	= new ArrayList();
			List delModels 	= new ArrayList();
			String user_id  = account.getUsr_id();
			int rowCount = (vos ==null) ? 0 : vos.length ;
			if(rowCount > 0){			 
				 for(int i =0 ; i < rowCount ; i++){
					 EqrScnrEccTurnTmVO vo = vos[i];
					 if(!"D".equals(vo.getIbflag())){
						 isInsert =true;
						 HashMap<String, Object> param = new HashMap<String, Object>();
						 param.putAll(vo.getColumnValues());
						 param.put("user_id",user_id);
						 insModels.add(param);
					 }else{
						 HashMap<String, Object> param = new HashMap<String, Object>();
						 param.putAll(vo.getColumnValues());
						 delModels.add(param);
					 }
				 }
			}
			if( isDelete ) {
				dbDao.deleteCntrTurnTimeInfo(delModels);
			}
			if( isInsert ){
				dbDao.insertCntrTurnTimeInfo(insModels);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	} 	
	
}