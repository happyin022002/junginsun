/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioManageBCImpl.java
*@FileTitle : Inquire Scenario ID List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.22
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.22 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.integration.ScenarioManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0002ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.EesEqr0111ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchScenarioIDListVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.scenariomanage.vo.SearchVesselScheduleInfoVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrMstVO;
import com.hanjin.syscommon.common.table.EqrScnrVslSkdVO;

/**
 * ALPS-ScenarioManage Business Logic Basic Command implementation<br>
 * - ALPS-ScenarioManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0002EventResponse,ScenarioManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ScenarioManageBCImpl extends BasicCommandSupport implements ScenarioManageBC {

	// Database Access Object
	private transient ScenarioManageDBDAO dbDao = null;
	
	/**
	 * ScenarioManageBCImpl 객체 생성<br>
	 * ScenarioManageDBDAO를 생성한다.<br>
	 */
	public ScenarioManageBCImpl() {
		dbDao	= new ScenarioManageDBDAO();
	}
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update 조회]<br>
	 * 
	 * @param eesEqr0002ConditionVO EesEqr0002ConditionVO 
	 * @return List<EqrScnrMstVO>
	 * @exception EventException
	 */
	public List<SearchScenarioIDListVO> searchScenarioIDList(EesEqr0002ConditionVO eesEqr0002ConditionVO) throws EventException {
		try {
			return dbDao.searchScenarioIDList(eesEqr0002ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0002 : Scenario - Create/Update - 시나리오 Copy, EAI 호출 ]<br>
	 * 
	 * @param eesEqr0002ConditionVO EesEqr0002ConditionVO
	 * @param account SignOnUserAccount 
	 * @exception EventException
	 */
	public void createNewScenarioID(EesEqr0002ConditionVO eesEqr0002ConditionVO, SignOnUserAccount account) throws EventException{        
		try {
			eesEqr0002ConditionVO.setCreUsrId(account.getUsr_id());
	        ScenarioManageBackEndJob scenarioManageBJ = new ScenarioManageBackEndJob();
			
			/*
			 * 전달하는 파라메터로 String을 만든다. 
			 */
			//------------------------------------------------
			String sendStr = "";
			sendStr = sendStr + "Scrnid" + ":" + eesEqr0002ConditionVO.getScnrid() + "|";
			sendStr = sendStr + "userId" + ":" + eesEqr0002ConditionVO.getCreUsrId();
			//------------------------------------------------
			scenarioManageBJ.setParamString(sendStr);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String key = backEndJobManager.execute(scenarioManageBJ, account.getUsr_id(),"Create New Scenario ID ! ");
			log.debug("====호출번호:" + key);
			//boolean result = eaiDao.send0002ReRunSteve(eesEqr0002ConditionVO);
			//eaiDao.send0002ReRunSteve(eesEqr0002ConditionVO);
		}catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	

	/**
	 * [EES_EQR_0002 : Scenario 삭제]<br>
	 * 
	 * @param eqrScnrMstVO EqrScnrMstVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeScenarioID(EqrScnrMstVO[] eqrScnrMstVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrScnrMstVO> deleteVoList = new ArrayList<EqrScnrMstVO>();
			for ( int i=0; i<eqrScnrMstVO .length; i++ ) {
				if ( eqrScnrMstVO[i].getIbflag().equals("D")){
					eqrScnrMstVO[i].setCreUsrId(account.getUsr_id());
					deleteVoList.add(eqrScnrMstVO[i]);
				}
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeScenarioID(deleteVoList);
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
     * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0111ConditionVO
     * @return List<SearchVesselScheduleInfoVO>
     * @exception EventException
     */
    public List<SearchVesselScheduleInfoVO> searchVesselScheduleInfo(EesEqr0111ConditionVO conditionVO) throws EventException {
        
        List<SearchVesselScheduleInfoVO> list = null;
        try {
        	list =dbDao.searchVesselScheduleInfo(conditionVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }  
    
    
    /**
     * 조회 이벤트 처리<br>
     * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0111ConditionVO
     * @return List<EqrScnrVslSkdVO>
     * @exception EventException
     */
    public List<EqrScnrVslSkdVO> searchVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO) throws EventException {
        // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        List<EqrScnrVslSkdVO> list= null;
        try {
        	list=dbDao.searchVesselSchedulePortInfo(conditionVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    } 
    
 // CSRNO : N200811110008로 추가 시작   
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0111ConditionVO
     * @param vos EqrScnrVslSkdVO[]
     * @param account SignOnUserAccount
     * @return List<EqrScnrVslSkdVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<EqrScnrVslSkdVO> modifyVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos ,SignOnUserAccount account) throws EventException {
        // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	List<EqrScnrVslSkdVO> list = null;
        try {
        	List insModels 	= new ArrayList();
        	String user_id = account.getUsr_id();
        	if(vos != null && vos.length > 0){
				EqrScnrVslSkdVO delVO = vos[0];
				dbDao.deleteVesselSchedulePortInfo(delVO);
				for(int i = 0 ; i < vos.length ; i++){
					EqrScnrVslSkdVO vo = vos[i];
					if(!vo.getIbflag().equals("D")){
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.putAll(vo.getColumnValues());
						param.put("vsl_call_seq", vo.getVslCallSeq());
						param.put("User_id", user_id);
						insModels.add(param);
					}
				}
				dbDao.modifyVesselSchedulePortInfo(insModels);
        	}
            list=dbDao.searchVesselSchedulePortInfo(conditionVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }     
    
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0111ConditionVO
     * @param vos EqrScnrVslSkdVO[]
     * @param account SignOnUserAccount
     * @return List<EqrScnrVslSkdVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<EqrScnrVslSkdVO> modifyNisCurrentVesselSchedulePortInfo(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos , SignOnUserAccount account) throws EventException {
        // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	List<EqrScnrVslSkdVO> list = null;
    	boolean isUpdate  = false;
        try {
        	String userId = account.getUsr_id();
        	List updModels 	= new ArrayList();
			if(vos != null && vos.length > 0){
				for(int i = 0 ; i < vos.length ; i++){
					EqrScnrVslSkdVO vo = vos[i];
					if(vo.getIbflag().equals("U")){
						isUpdate  = true;
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.putAll(vo.getColumnValues());
						param.put("User_id", userId);
						param.put("v_fm_wk", conditionVO.getEtbsyr()+conditionVO.getEtbswk());
						param.put("v_to_wk", conditionVO.getEtbeyr()+conditionVO.getEtbewk());
						updModels.add(param);
					}
				}
				if(isUpdate){
					dbDao.modifyNisCurrentVesselSchedulePortInfo(updModels);
				}
			}
            list=dbDao.searchVesselSchedulePortInfo(conditionVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    } 
    
    // CSRNO : N200811110008로 추가   
    
    /**
     * 멀티 이벤트 처리<br>
     * EES_EQR_111 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0111ConditionVO
     * @param vos EqrScnrVslSkdVO[]
     * @param account SignOnUserAccount
     * @return List<EqrScnrVslSkdVO>
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public List<EqrScnrVslSkdVO> modifyVesselSchedulePortInfoAdd(EesEqr0111ConditionVO conditionVO ,EqrScnrVslSkdVO[] vos , SignOnUserAccount account) throws EventException {
        // 데이터 전송을 위해 DB ResultSet을 구현한 객체
    	List<EqrScnrVslSkdVO> list = null;
		boolean isInsert  = false;
//		// Period
		String etbSYrWk = conditionVO.getEtbsyr() + conditionVO.getEtbswk();
		String etbEYrWk = conditionVO.getEtbeyr() + conditionVO.getEtbewk();
        try {
        	List insModels 	= new ArrayList();
			if(vos != null && vos.length > 0){
				for(int i = 0 ; i < vos.length ; i++){
					EqrScnrVslSkdVO vo = vos[i];
					if(vo.getIbflag().equals("I")){
						isInsert  = true;
						HashMap<String, Object> param = new HashMap<String, Object>();
						param.putAll(vo.getColumnValues());
						param.put("etbSYrWk", etbSYrWk);
						param.put("etbEYrWk", etbEYrWk);
						insModels.add(param);
					}
				}
				if(isInsert){
					dbDao.modifyVesselSchedulePortInfoAdd(insModels); 
				}
			}
            list=dbDao.searchVesselSchedulePortInfo(conditionVO);
            return list;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    } 
	
}