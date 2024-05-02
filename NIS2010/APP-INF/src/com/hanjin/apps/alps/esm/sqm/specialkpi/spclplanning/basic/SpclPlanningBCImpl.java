/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : SpclPlanningBCImpl.java
*@FileTitle      : SpclPlanning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.08
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.08 이혜민
* 1.0 Creation
* 2015.11.27 김용습 [CHM-201538495] [CSR 전환건] Basic CMCB 화면 보완 (Row Add 기능 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.basic.SpclPlanningBC;
import com.hanjin.apps.alps.esm.sqm.specialkpi.spclplanning.integration.SpclPlanningDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmSpclLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmSpclLodRevVO;

/**
 * ALPS-Planning Business Logic Command Interface<br>
 * - ALPS-SpclPlanning 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 이혜민
 * @see SpclPlanningDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpclPlanningBCImpl extends BasicCommandSupport implements SpclPlanningBC {
	
	// Database Access Object
	private transient SpclPlanningDBDAO dbDao = null;
	
	/**
	 * PlanningBCImpl 객체 생성<br>
	 * PlanningDBDAO를 생성한다.<br>
	 */
	public SpclPlanningBCImpl() {
		dbDao = new SpclPlanningDBDAO();
	}
	/**
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLodRevVO>
	 * @exception EventException
	 */
	public List<SqmSpclLodRevVO> searchKpiInputbyHeadOffice(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiInputbyHeadOffice(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0501 : [SEARCH]<br>
	 * [KPI Input by Head Office]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchKpiInputbyHeadOfficeCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchKpiInputbyHeadOfficeCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI]<br>
	 * [KPI Input by Head Office]를 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclLodRevVO[] sqmSpclLodRevVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageKpiInputbyHeadOffice(ConditionVO conditionVO, SqmSpclLodRevVO[] sqmSpclLodRevVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSpclLodRevVO> updateVoList = new ArrayList<SqmSpclLodRevVO>();
			List<SqmSpclLodRevVO> insertVoList = new ArrayList<SqmSpclLodRevVO>();
			
			for ( int i=0; i<sqmSpclLodRevVOS .length; i++ ) {    
				sqmSpclLodRevVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSpclLodRevVOS[i].setSpclTgtCd(conditionVO.getFSpclTgtCd());
				sqmSpclLodRevVOS[i].setCreUsrId(account.getUsr_id());
				sqmSpclLodRevVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmSpclLodRevVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmSpclLodRevVOS[i]);
				}
				if ( sqmSpclLodRevVOS[i].getIbflag().equals("I")){
					insertVoList.add(sqmSpclLodRevVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.insertKpiInputbyHeadOffice(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateKpiInputbyHeadOffice(updateVoList);
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0501 : [MULTI01]<br>
	 * [KPI Input by Head Office]의 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createKpiInputbyHeadOffice(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		try {
			istCnt = dbDao.createKpiInputbyHeadOffice(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());   
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclLaneOfcCostVO>
	 * @exception EventException
	 */
	public List<SqmSpclLaneOfcCostVO> searchBasicCmcb(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcb(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0502 : [SEARCH]<br>
	 * [Basic CMCB]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBasicCmcbCnt(ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchBasicCmcbCnt(conditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * ESM_SQM_0502 : [MULTI]<br>
	 * [Basic CMCB]을 [저장] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageBasicCmcb(ConditionVO conditionVO, SqmSpclLaneOfcCostVO[] sqmSpclLaneOfcCostVOS, SignOnUserAccount account) throws EventException{
		try {
			List<SqmSpclLaneOfcCostVO> updateVoList = new ArrayList<SqmSpclLaneOfcCostVO>();
			List<SqmSpclLaneOfcCostVO> insertVoList = new ArrayList<SqmSpclLaneOfcCostVO>();
			
			for ( int i=0; i<sqmSpclLaneOfcCostVOS .length; i++ ) {    
				sqmSpclLaneOfcCostVOS[i].setBseTpCd(conditionVO.getFBseTpCd());
				sqmSpclLaneOfcCostVOS[i].setSpclTgtCd(conditionVO.getFSpclTgtCd());
				sqmSpclLaneOfcCostVOS[i].setCreUsrId(account.getUsr_id());
				sqmSpclLaneOfcCostVOS[i].setUpdUsrId(account.getUsr_id()); 
				
				if ( sqmSpclLaneOfcCostVOS[i].getIbflag().equals("U")){
					updateVoList.add(sqmSpclLaneOfcCostVOS[i]);
				}
				if ( sqmSpclLaneOfcCostVOS[i].getIbflag().equals("I")){
					insertVoList.add(sqmSpclLaneOfcCostVOS[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.updateBasicCmcb(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.insertBasicCmcb(insertVoList);
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());   
		}
	}
	
	/**
	 * ESM_SQM_0502 : [MULTI01]<br>
	 * [Basic CMCB]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcb(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		try {
			istCnt = dbDao.createBasicCmcb(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());   
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0503 : [MULTI]<br>
	 * [Basic CMCB New Lane]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String createBasicCmcbNewLane(ConditionVO conditionVO, String usrId) throws EventException{
		String istCnt = null;
		try {
			istCnt = dbDao.createBasicCmcbNewLane(conditionVO, usrId);
			if(istCnt.equals("0")){
				throw new EventException(new ErrorHandler("SQM00003").getMessage());   
			}
		} catch(DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")!= -1)
				throw new EventException(new ErrorHandler("SQM00001").getMessage(), ex);   
			else
				throw new EventException(new ErrorHandler(ex).getMessage()); 
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return istCnt;
	}
	
}