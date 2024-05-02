/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : scenariodefaultmanageBCImpl.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
* No.	Ver.		Modifier           	modifier date    explanation
* 1     1.0      	jungran yang		2006-09-05		 1.0 최초 생성
* 2     1.0      	Lee Byoung Hun		2009.06.30		 New Framework 적용 Renewal
*
*@LastModifyDate : 2009.06.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.06.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration.ScenarioDefaultManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0043ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0123ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0137ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEqrHolidayEffectVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanMonthlyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanWeeklyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleasePlanVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.hanjin.syscommon.common.table.EqrDmstPlnVO;
import com.hanjin.syscommon.common.table.EqrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrEccMstVO;
import com.hanjin.syscommon.common.table.EqrEccSftStkVO;
import com.hanjin.syscommon.common.table.EqrEccTurnTmVO;
import com.hanjin.syscommon.common.table.EqrHolEffRtoVO;
import com.hanjin.syscommon.common.table.EqrHolidayVO;
import com.hanjin.syscommon.common.table.EqrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrNewVanLongTermVO;
import com.hanjin.syscommon.common.table.EqrPortDchgCnstVO;
import com.hanjin.syscommon.common.table.EqrRepoCnstVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOnhCondVO;
import com.hanjin.syscommon.common.table.EqrSubleaseVO;
import com.hanjin.syscommon.common.table.EqrTsTmlVO;
/**
 * NIS2010-DefaultManage Business Logic Basic Command implementation<br>
 * - NIS2010-DefaultManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0034EventResponse,scenariodefaultmanageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ScenarioDefaultManageBCImpl extends BasicCommandSupport implements ScenarioDefaultManageBC {

	
	// Database Access Object
	private transient ScenarioDefaultManageDBDAO dbDao = null;

	/**
	 * ScenariodefaultmanageBCImpl 객체 생성<br>
	 * ScenarioDefaultManageDBDAO를 생성한다.<br>
	 */
	public ScenarioDefaultManageBCImpl() {
		dbDao = new ScenarioDefaultManageDBDAO();
	}
	
	/**
	 * ECC 정보 조회/수정의 조회 이벤트 처리<br>
	 * 
	 * @param status	String
	 * @param location	String
	 * @return List<SearchEccMasterVO>
	 * @exception EventException
	 */
	public List<SearchEccMasterVO> searchDefaultECCInfo(String status, String location) throws EventException {
		try {
			return dbDao.searchDefaultECCInfo(status, location);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ECC 정보 조회/수정의 TS 정보 조회<br>
	 * 
	 * @param eccCd	String
	 * @return List<SearchEccTsTmlVO>
	 * @exception EventException
	 */
	public List<SearchEccTsTmlVO> searchDefaultTSTMLInfo(String eccCd) throws EventException {
		try {
			return dbDao.searchDefaultTSTMLInfo(eccCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * 
	 * @param eqrEccMstVOs	EqrEccMstVO[]
	 * @param account		SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultECCInfo(EqrEccMstVO[] eqrEccMstVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrEccMstVO> updateVoList = new ArrayList<EqrEccMstVO>();
			for ( int i=0; i<eqrEccMstVOs .length; i++ ) {
				if ( eqrEccMstVOs[i].getIbflag().equals("U")){
					eqrEccMstVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrEccMstVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultECCInfo(updateVoList);
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
	 * ECC 정보 조회/수정의 멀티 이벤트 처리<br>
	 * 
	 * @param eqrTsTmlVOs	EqrTsTmlVO[]
	 * @param account		SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultTSTMLInfo(EqrTsTmlVO[] eqrTsTmlVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrTsTmlVO> updateVoList = new ArrayList<EqrTsTmlVO>();
			for ( int i=0; i<eqrTsTmlVOs .length; i++ ) {
				if ( eqrTsTmlVOs[i].getIbflag().equals("U")){
					eqrTsTmlVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrTsTmlVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultTSTMLInfo(updateVoList);
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
	 * S/T On Hire 조회 이벤트 처리<br>
	 * 
	 * @param eccWhereCondition	String
	 * @param tpsztype			String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultSTOnHireInfo(String eccWhereCondition, String tpsztype) throws EventException {
		try {
			return dbDao.searchDefaultSTOnHireInfo(eccWhereCondition, tpsztype);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * S/T On Hire 멀티 이벤트 처리<br>
	 * 
	 * @param eqrShrtTermOnhCondVOs	EqrShrtTermOnhCondVO[]
	 * @param account		SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultSTOnHireInfo(EqrShrtTermOnhCondVO[] eqrShrtTermOnhCondVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrShrtTermOnhCondVO> updateVoList = new ArrayList<EqrShrtTermOnhCondVO>();
			List<EqrShrtTermOnhCondVO> deleteVoList = new ArrayList<EqrShrtTermOnhCondVO>();
			
			for ( int i=0; i<eqrShrtTermOnhCondVOs .length; i++ ) {
				if ( eqrShrtTermOnhCondVOs[i].getIbflag().equals("U") || eqrShrtTermOnhCondVOs[i].getIbflag().equals("I")){
					eqrShrtTermOnhCondVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrShrtTermOnhCondVOs[i]);
				} else if (eqrShrtTermOnhCondVOs[i].getIbflag().equals("D")) {
					eqrShrtTermOnhCondVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(eqrShrtTermOnhCondVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultSTOnHireInfo(updateVoList);
			} else if (deleteVoList.size() > 0) {
				dbDao.deleteDefaultSTOnHireInfo(deleteVoList);
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
	 * L/T Off-Hire 조회 이벤트 처리<br>
	 * 
	 * @param eccWhereCondition	String
	 * @param tpsztype			String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultLTOffHireInfo(String eccWhereCondition, String tpsztype) throws EventException {
		try {
			return dbDao.searchDefaultLTOffHireInfo(eccWhereCondition, tpsztype);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * L/T Off-Hire 멀티 이벤트 처리<br>
	 * 
	 * @param eqrLongTermOffhCondVOs	EqrLongTermOffhCondVO[]
	 * @param account		SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultLTOffHireInfo(EqrLongTermOffhCondVO[] eqrLongTermOffhCondVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrLongTermOffhCondVO> updateVoList = new ArrayList<EqrLongTermOffhCondVO>();
			List<EqrLongTermOffhCondVO> deleteVoList = new ArrayList<EqrLongTermOffhCondVO>();
			
			for ( int i=0; i<eqrLongTermOffhCondVOs .length; i++ ) {
				if ( eqrLongTermOffhCondVOs[i].getIbflag().equals("U") || eqrLongTermOffhCondVOs[i].getIbflag().equals("I")){
					eqrLongTermOffhCondVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrLongTermOffhCondVOs[i]);
				} else if (eqrLongTermOffhCondVOs[i].getIbflag().equals("D")) {
					eqrLongTermOffhCondVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(eqrLongTermOffhCondVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultLTOffHireInfo(updateVoList);
			} else if (deleteVoList.size() > 0) {
				dbDao.deleteDefaultLTOffHireInfo(deleteVoList);
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
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0123ConditionVO
	 * @return List<SearchYearSubleasePlanVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleasePlanVO> searchDefaultYearSubleasePlan(EesEqr0123ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDefaultYearSubleasePlan(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0123ConditionVO
	 * @return List<SearchYearSubleaseDetailPlanMonthlyVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleaseDetailPlanMonthlyVO> searchDefaultYearSubleaseDetailPlanMonthly(EesEqr0123ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDefaultYearSubleaseDetailPlanMonthly(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Sublease Out 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO	EesEqr0123ConditionVO
	 * @return List<SearchYearSubleaseDetailPlanWeeklyVO>
	 * @exception EventException
	 */
	public List<SearchYearSubleaseDetailPlanWeeklyVO> searchDefaultYearSubleaseDetailPlanWeekly(EesEqr0123ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchDefaultYearSubleaseDetailPlanWeekly(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param EesEqr0123ConditionVO conditionVO
	 * @param List<String> countWeek
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createDefaultYearSubleasePlan(EesEqr0123ConditionVO conditionVO,List<String> countWeek,SignOnUserAccount account) throws EventException {
		try {
			List<EqrSubleaseVO> voList = new ArrayList<EqrSubleaseVO>();
			EqrSubleaseVO vo = null;
			List<String> month = conditionVO.getMonth();
			
			String ibflag = conditionVO.getS1Ibflag();
			String year    = conditionVO.getFmPlnYr();
			String yrWk    = null;
			
        	// 52,53주까지 카운트될 변수
        	int iWeek = 1;
        	
        	/* rsWeek 를 셋팅한다. */
        	for( int i = 0 ; i < month.size() ; i++ ) {
    			int monthQty  = Integer.parseInt((String)month.get(i));		// 월당 총수량
				int monthWeek = Integer.parseInt((String)countWeek.get(i)); // 월당 주개수
	
				// 월당 총수량 / 월당 주개수
				int countPerWeek = monthQty / monthWeek;    	
				// 마지막 주 개수 : 총 개수에서 총 주개수-1 의 총수량을 뺀 수량.
				int countLastWeek = monthQty - countPerWeek * (monthWeek-1);
				
        		// E를 제외한 해당주를 담는다.
        		if(!((String)month.get(i)).equals("E")) {	
        			for( int j = 0; j < monthWeek; j++ ) {
        				vo = new EqrSubleaseVO();
        				yrWk = year + Utils.fill(String.valueOf(iWeek), 2, "0", "left");
        				
        				vo.setYrWk(yrWk);
        				vo.setUpdUsrId(account.getUsr_id());
        				vo.setRccCd(conditionVO.getS1RccCd());
        				if (j < (monthWeek - 1)) {
        					vo.setRsCount(String.valueOf(countPerWeek));
        				} else {
        					vo.setRsCount(String.valueOf(countLastWeek));
        				}
        				voList.add(vo);
        				
        				iWeek++;
        			}
        		}
        		else {
        			for( int j = 0; j < monthWeek; j++ ) {
        				iWeek++;
        			}
        		}
        	}
			
			if ("U".equals(ibflag)) {
				dbDao.deleteYearSubleasePlanRCC(conditionVO);
				dbDao.insertYearSubleasePlan(voList);
				dbDao.updateYearSubleasePlan(voList);
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
	 * Sublease Out 멀티 이벤트 처리<br>
	 * 
	 * @param eqrSubleaseVOs	EqrSubleaseVO[]
	 * @param account		SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultYearSubleasePlan(EqrSubleaseVO[] eqrSubleaseVOs,SignOnUserAccount account) throws EventException {
		try {
			List<EqrSubleaseVO> updateVoList = new ArrayList<EqrSubleaseVO>();
			List<EqrSubleaseVO> deleteVoList = new ArrayList<EqrSubleaseVO>();
			
			for ( int i=0; i<eqrSubleaseVOs .length; i++ ) {
				if ( eqrSubleaseVOs[i].getIbflag().equals("U") || eqrSubleaseVOs[i].getIbflag().equals("I")){
					eqrSubleaseVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrSubleaseVOs[i]);
				} else if (eqrSubleaseVOs[i].getIbflag().equals("D")) {
					eqrSubleaseVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(eqrSubleaseVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultYearSubleasePlan(updateVoList);
			} else if (deleteVoList.size() > 0) {
				dbDao.deleteDefaultYearSubleasePlan(deleteVoList);
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
	 * ECC Link 정보 조회 <br>
	 * ScenarioDefaultManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param EesEqr0116ConditionVO condiVo
	 * @param ArrayList<String> fromEccAL
	 * @param ArrayList<String> toEccAL
	 * @return List<EqrEccLnkVO>
	 * @exception EventException
	 */
	public List<EqrEccLnkVO> searchDefaultECCLinkInfo(EesEqr0116ConditionVO condiVo, ArrayList<String> fromEccAL, ArrayList<String> toEccAL) throws EventException {
		List<EqrEccLnkVO> list = null;
		try {		
			
			list 			= dbDao.searchDefaultECCLinkInfo(condiVo, fromEccAL , toEccAL);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return list;
	}	

    /**
     * Link 정보 수정<br>
     * EES_EQR_116 에 대한 추가 이벤트 처리<br>
     * 
     * @param vos EqrEccLnkVO[]
     * @param account SignOnUserAccount
     * @exception EventException
   */
    @SuppressWarnings("unchecked")
	public void modifyDefaultECCLinkInfo(EqrEccLnkVO[] vos , SignOnUserAccount account) throws EventException {
    	boolean isInsert = false;      
		boolean isDelete = false;
        try {
        	String user_id =  account.getUsr_id();
        	List insModels = new ArrayList();
        	List delModels = new ArrayList();
        	for(int i = 0 ; i < vos.length ; i++){
				EqrEccLnkVO vo = vos[i];
				//query parameter
				HashMap<String, String> param = vo.getColumnValues();
				param.put("user_id", user_id); 
				if(vo.getIbflag() == null){
					vo.setIbflag("");
				}
				
				if(vo.getIbflag().equals("I") || vo.getIbflag().equals("U")) {            	    			    	
                	isInsert = true ;
                	insModels.add(param);
				}else if(vo.getIbflag().equals("D")) { 
					isDelete = true;
					delModels.add(param);
				}
			}
        	if(isInsert){
        		dbDao.manageDefaultECCLinkInfo(insModels);
        	}
        	if(isDelete){
        		dbDao.deleteDefaultECCLinkInfo(delModels);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }    
	
	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_042 화면에 대한 조회 이벤트 처리<br>
	 * Grid 1
	 * @param condiVo EesEqr042ConditionVO
	 * @return List<SearchEqrHolidayEffectVO>
	 * @exception EventException
	 */
	public List<SearchEqrHolidayEffectVO> searchDefaultHolidayEffectInfo(EesEqr0042ConditionVO condiVo) throws EventException {
		List<SearchEqrHolidayEffectVO> list = null;		
		try {		
			
			list = dbDao.searchDefaultHolidayEffectInfo(condiVo);			
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return list;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_042 화면에 대한 Deatail(O/B) 조회 이벤트 처리<br>
	 * Grid 2
	 * @param condiVo EesEqr042ConditionVO
	 * @return retVO ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfo2(EesEqr0042ConditionVO condiVo) throws EventException {
		
		ScenarioDefaultManageRsVO retVO = null;
		try {
			if(dbDao.searchDefaultHolidayEffectDetailIsExist(condiVo,"O")){
				retVO  = dbDao.searchDefaultHolidayEffectDetailInfoRTO( condiVo,"O");
			}else{
				retVO  = dbDao.searchDefaultHolidayEffectDetailInfo(condiVo,"O");
			}
			return retVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EES_EQR_042 화면에 대한 Deatail(I/B)조회 이벤트 처리<br>
	 * Grid 2
	 * @param condiVo EesEqr042ConditionVO
	 * @return retVO ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfo3(EesEqr0042ConditionVO condiVo) throws EventException {
		ScenarioDefaultManageRsVO retVO = null;
		try {
			
			if(dbDao.searchDefaultHolidayEffectDetailIsExist(condiVo,"I")){
				retVO = dbDao.searchDefaultHolidayEffectDetailInfoRTO(condiVo,"I");
			}else{
				retVO = dbDao.searchDefaultHolidayEffectDetailInfo(condiVo,"I");
			}
			
			return retVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * 수정 이벤트 처리<br>
	 * EesEqr042 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param vos EqrHolidayVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyDefaultHolidayEffectInfo( EqrHolidayVO[] vos , SignOnUserAccount account ) throws EventException {
		try {
			boolean isInsert = false ; 
			String user_id = account.getUsr_id();
			List insModels = new ArrayList();
			for(int i = 0 ; i < vos.length ; i++){
				EqrHolidayVO vo = vos[i];
				HashMap<String, String> param = vo.getColumnValues();
				param.put("user_id", user_id); 
				if(vo.getIbflag() == null){
					vo.setIbflag("");
				}
				
				if(vo.getIbflag().equals("U")) { 
					isInsert = true ;
                	insModels.add(param);
				}
			}
			if(isInsert){
				dbDao.multiDefaultHolidayEffectInfo(insModels);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_042 에 대한 추가 이벤트 처리<br>
	 * Grid 2
	 * @param vos EqrHolEffRtoVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyDefaultHolidayEffectDetailInfo(EqrHolEffRtoVO[] vos , SignOnUserAccount account ) throws EventException {
		boolean isInsert = false ;
		try {
			List insModels = new ArrayList();
			String user_id = account.getUsr_id();
			for(int i = 0 ; i < vos.length ; i++){
				EqrHolEffRtoVO vo = vos[i];
				HashMap<String, String> param = vo.getColumnValues();
				param.put("user_id", user_id); 
				if(vo.getIbflag() == null){
					vo.setIbflag("");
				}
				
				if(vo.getIbflag().equals("U")) { 
					isInsert = true ;
                	insModels.add(param);
				}
			}
			if(isInsert){
				dbDao.multiDefaultHolidayEffectDetailInfo(insModels);
			}
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		
//		return eventResponse;
	}	
	
	/**
	 * 연간 신조 계획 조회/수정 <br>
	 * ScenarioDefaultManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr121ConditionVO
	 * @return retVo ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultYearNewvanPlan(EesEqr0121ConditionVO condiVO) throws EventException {
        ScenarioDefaultManageRsVO retVo = new ScenarioDefaultManageRsVO();
		try {		
			
			retVo = dbDao.searchDefaultYearNewvanPlan(condiVO);            
			return retVo;

		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 연간 Week 신조 계획 조회/수정 <br>
	 * ScenarioDefaultManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param condiVO EesEqr121ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultWeekNewvanPlan(EesEqr0121ConditionVO condiVO) throws EventException {
        ScenarioDefaultManageRsVO retVo = new ScenarioDefaultManageRsVO();
		try {
			retVo = dbDao.searchDefaultWeekNewvanPlan(condiVO);  
			return retVo;

		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}			
	
   /**
     * 수정 이벤트 처리<br>
     * EES_EQR_121 에 대한 추가 이벤트 처리<br>
     * 
     * @param condiVO EesEqr121ConditionVO
     * @param vos EqrNewVanLongTermVO[]
	 * @param account SignOnUserAccount
	 * @param monthWeek String[][]
     * @exception EventException
   */
    @SuppressWarnings("unchecked")
	public void modifyDefaultYearNewvanPlan(EesEqr0121ConditionVO condiVO, EqrNewVanLongTermVO[] vos , SignOnUserAccount account , String[][] monthWeek) throws EventException {
        try {
        	boolean isInsert = false;
            boolean isDelete = false;
			// INSERT, UPDATE, DELETE 수행
        	//dbDao.modifyDefaultYearNewvanPlan(condiVO, vos , account.getUsr_id(), monthWeek);
        	String user_id = account.getUsr_id();
        	List insModels = new ArrayList();
        	List delModels = new ArrayList();
			List monthQty 	 = null;
			String[] tempQty = null;
        	int mQty = 0; // 월당 수량
        	int wQty = 0; // 주차당 수량
        	
        	List monthFlag 	  = null;
        	String[] tempFlag = null;
        	String flag = "";
        	//String[] monthSaveInfo  = condiVO.getMonthArr();
			for(int i = 0 ; i < vos.length ; i++){
				EqrNewVanLongTermVO vo = vos[i];
				
				if(vo.getIbflag() == null){
					vo.setIbflag("");
				}

				if(vo.getIbflag().equals("I") || vo.getIbflag().equals("U")) { 
					List<String[]> monthSaveInfo = condiVO.getMmonthSaveInfo();
					List<String[]> flagmonthSaveInfo = condiVO.getFlagmonthSaveInfo();
					// row별 month 입력수량을 List에 담는다.
            	    mQty = 0; // 월당 수량
            	    wQty = 0; // 주차당 수량
            	    tempQty = null;
            	    monthQty = new ArrayList();
            	    
            	    tempFlag = null;
            	    monthFlag = new ArrayList(); 
            	    flag = "";
					for(int m=0; m< monthSaveInfo.size(); m++) { // MmonthSaveInfo.size() 와 monthSaveInfo.length 동일함
						// 월별 qty 정보
				    	tempQty = (String[])monthSaveInfo.get(m);
				       	monthQty.add(tempQty[i]);  // 현재 row에 해당하는 것만 List에 담기
				       	mQty  = Integer.parseInt((String)monthQty.get(m));	// 월당 수량
	        	    	
				       	// flag 정보 (T, F)
				    	tempFlag = (String[])flagmonthSaveInfo.get(m);
				       	monthFlag.add(tempFlag[i]);         // 현재 row에 해당하는 것만 List에 담기
				       	flag  = (String)monthFlag.get(m);	// 월당 flag
			       	
			       		for(int w=0; w<monthWeek[m].length; w++) { // 월에 해당된 주차만큼 회전	
			       		// 월에 입력된 정보를 주차로 쪼개기(중요)
            	    		if(vo.getIbflag().equals("I") || (vo.getIbflag().equals("U") && flag.equals("T"))) {            	    			
            	    			if(w != (monthWeek[m].length-1)) {     // 월의 마지막 주가 아닌경우            	    				
            	    				wQty = mQty / monthWeek[m].length; // 월당 총수량 / 월당 주개수
            	    				
            	    				// month 수량이 주차갯수보다 적으면 첫째주에 모두 넣어준다.
            	    				if(w==0 && mQty < monthWeek[m].length) {
            	    					wQty = mQty;
            	    					mQty = 0;  // 나눌 수량이 없으므로  month qty = 0 으로 한다.
            	    				}
            	    				
            	    			}else {                                // 월의 마지막 주(나누기의 나머지 값)
            	    				wQty = mQty / monthWeek[m].length; // 월당 총수량 / 월당 주개수
            	    				wQty = mQty - (wQty * (monthWeek[m].length-1));
            	    			}	 
            	    		}

                            if(vo.getIbflag().equals("I")) {
                            	if(dbDao.newVanLongTermInsertCheck(monthWeek[m][w], vo.getCoCd() , vo.getEccCd(), vo.getCntrLstmCd(), vo.getCntrTpszCd(), vo.getVndrCntCd(), vo.getVndrSeq(), "A")) {
                            		isInsert = true;
                            		HashMap<String, String> iparam = new HashMap<String, String>();
                        			//param = vo.getColumnValues(); // vo 객체의 HashMap 저장소 공유 문제로 해시맵에으로 바로 저장하지 않고 각각의 value 를 가져온다.
                            		iparam.put("co_cd", vo.getCoCd());
                            		iparam.put("ecc_cd", vo.getEccCd());
                            		iparam.put("cntr_lstm_cd", vo.getCntrLstmCd());
                            		iparam.put("cntr_tpsz_cd", vo.getCntrTpszCd());
                            		iparam.put("vndr_cnt_cd", vo.getVndrCntCd());
                            		iparam.put("vndr_seq", vo.getVndrSeq());
                            		iparam.put("vndr_abbr_nm", vo.getVndrAbbrNm());
                        			
                            		iparam.put("user_id", user_id); 
                            		iparam.put("pln_yrmon",monthWeek[m][w]);
                            		iparam.put("cntr_de_sts_cd", "A");
                            		iparam.put("cntr_vol_qty", wQty+"");
                    				insModels.add(iparam);
                            	}else {
                        			String line = Integer.toString(i+1);
                        			String[] errMessage ={line, ""};
                        			throw new DAOException(new ErrorHandler("EQR10025", errMessage).getMessage());
                        		}  
                            }else if(vo.getIbflag().equals("U") && flag.equals("T")) {
                            	
                            	isInsert = true;
                    			HashMap<String, String> iparam = new HashMap<String, String>();
                    			//iparam = vo.getColumnValues();  // vo 객체의 HashMap 저장소 공유 문제로 해시맵에으로 바로 저장하지 않고 각각의 value 를 가져온다.
                    			iparam.put("co_cd", vo.getCoCd());
                    			iparam.put("ecc_cd", vo.getEccCd());
                    			iparam.put("cntr_lstm_cd", vo.getCntrLstmCd());
                    			iparam.put("cntr_tpsz_cd", vo.getCntrTpszCd());
                    			iparam.put("vndr_cnt_cd", vo.getVndrCntCd());
                    			iparam.put("vndr_seq", vo.getVndrSeq());
                    			iparam.put("vndr_abbr_nm", vo.getVndrAbbrNm());
                    			
                    			iparam.put("user_id", user_id); 
                    			iparam.put("pln_yrmon",monthWeek[m][w]);
                    			iparam.put("cntr_de_sts_cd", "A");
                    			iparam.put("cntr_vol_qty", wQty+"");
                				insModels.add(iparam);          
                            }
			       		}
					}
				} else if(vo.getIbflag().equals("D")) {  // 삭제로직(PK에서 WEEK는 제외합니다.)
                    isDelete = true ;
                    HashMap<String, String> dparam = new HashMap<String, String>(); // vo.getColumnValues(); // vo 객체의 HashMap 저장소 공유 문제로 해시맵에으로 바로 저장하지 않고 각각의 value 를 가져온다.
                    dparam.put("co_cd", vo.getCoCd());
                    dparam.put("ecc_cd", vo.getEccCd());
                    dparam.put("cntr_lstm_cd", vo.getCntrLstmCd());
                    dparam.put("cntr_tpsz_cd", vo.getCntrTpszCd());
                    dparam.put("vndr_cnt_cd", vo.getVndrCntCd());
                    dparam.put("vndr_seq", vo.getVndrSeq());
                    dparam.put("vndr_abbr_nm", vo.getVndrAbbrNm());
                    dparam.put("cntr_de_sts_cd", "A");
    				delModels.add(dparam);  
				}
			}
			if(vos.length > 0){
				if(isInsert){
					dbDao.mergeYearNewVanPlan(insModels);
				}
				if(isDelete){
					dbDao.deleteYearNewVanPlan(delModels);
				}
			}
        	
            //return new EES_EQR_121EventResponse(rowSet,"SUCCESS");
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	
    
   /**
     * 수정 이벤트 처리<br>
     * EES_EQR_121 에 대한 추가 이벤트 처리<br>
     * 
     * @param condiVO EesEqr121ConditionVO
     * @param vos EqrNewVanLongTermVO[]
     * @param account SignOnUserAccount
     * @exception EventException
   */
    @SuppressWarnings("unchecked")
	public void modifyDefaultWeekNewvanPlan(EesEqr0121ConditionVO condiVO,EqrNewVanLongTermVO[] vos, SignOnUserAccount account) throws EventException {
    	boolean isUpdate = false;        
        try {
        	List updtModels = new ArrayList();
        	String user_id = account.getUsr_id();
        	
        	String[] weekArr  = condiVO.getWeekArr(); // 전체주차
			List<String[]> weekQtyList = condiVO.getMweekSaveInfo(); // 주차당 수량
			List<String[]> weekSaveInfoList = condiVO.getFlagweekSaveInfo(); // 주차별 수정여부
			
			String[] qtyList = null;
			String[] saveInfoList = null;
			
			String week = null;
			String qty = null;
			String saveInfo = null;
        	
			for(int i = 0 ; i < weekArr.length ; i++){
				week = weekArr[i];
				qtyList = weekQtyList.get(i);
				saveInfoList = weekSaveInfoList.get(i);
				
				for (int j = 0; j < vos.length; j++) {
					EqrNewVanLongTermVO vo = vos[j];
					qty = qtyList[j];
					saveInfo = saveInfoList[j];
					
					if ("T".equals(saveInfo)) {
                    	isUpdate = true ;
                    	HashMap<String, String> param = new HashMap(vo.getColumnValues());
        				param.put("user_id", user_id);
        				param.put("pln_yrmon", week);
        				param.put("cntr_de_sts_cd", "L");
        				param.put("cntr_vol_qty", qty);
        				updtModels.add(param);
					}
				}
			}
			
			if(isUpdate){
				// UPDATE 수행
	        	dbDao.modifyDefaultWeekNewvanPlan(updtModels);
			}
        	
            //return new EES_EQR_121EventResponse(rowSet,"SUCCESS");
        } catch (Exception de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }	    
    
	/**
	 * [EES_EQR_0043 : Turn Time 조회]<br>
	 * 
	 * @param EesEqr0043ConditionVO eesEqr0043ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */	
	public CommonRsVO searchDefaultCntrTurnTimeInfo(EesEqr0043ConditionVO eesEqr0043ConditionVO) throws EventException {
		try {
			return dbDao.searchDefaultCntrTurnTimeInfo(eesEqr0043ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * 멀티 이벤트 처리<br>
	 * [EES_EQR_0043 : Turn Time 수정, 삭제]<br>
	 * 
	 * @param EqrEccTurnTmVO[] eqrEccTurnTmVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultCntrTurnTimeInfo(EqrEccTurnTmVO[] eqrEccTurnTmVOs, SignOnUserAccount account) throws EventException{
		try {
			List<EqrEccTurnTmVO> updateVoList = new ArrayList<EqrEccTurnTmVO>();
			List<EqrEccTurnTmVO> deleteVoList = new ArrayList<EqrEccTurnTmVO>();
			for ( int i=0; i<eqrEccTurnTmVOs .length; i++ ) {
				if ( eqrEccTurnTmVOs[i].getIbflag().equals("U")){
					eqrEccTurnTmVOs[i].setCreUsrId(account.getUsr_id());
					eqrEccTurnTmVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrEccTurnTmVOs[i]);
				} else if ( eqrEccTurnTmVOs[i].getIbflag().equals("D")){
					deleteVoList.add(eqrEccTurnTmVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultCntrTurnTimeInfo(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteDefaultCntrTurnTimeInfo(deleteVoList);
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
	 * [EES_EQR_0119 : S/T Off Hire 조회]<br>
	 * 
	 * @param String status
	 * @param String location
	 * @param String tpsztype
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultSTOffHireInfo(String status, String location, String tpsztype) throws EventException {
		try {
			return dbDao.searchDefaultSTOffHireInfo(status, location, tpsztype);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 수정, 삭제]<br>
	 * 
	 * @param eqrShrtTermOffhCondVOs	EqrShrtTermOffhCondVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultSTOffHireInfo(EqrShrtTermOffhCondVO[] eqrShrtTermOffhCondVOs, SignOnUserAccount account) throws EventException{
		try {
			List<EqrShrtTermOffhCondVO> mergeVoList = new ArrayList<EqrShrtTermOffhCondVO>();
			List<EqrShrtTermOffhCondVO> deleteVoList = new ArrayList<EqrShrtTermOffhCondVO>();
			for ( int i=0; i<eqrShrtTermOffhCondVOs .length; i++ ) {
				if ( eqrShrtTermOffhCondVOs[i].getIbflag().equals("U")
					|| eqrShrtTermOffhCondVOs[i].getIbflag().equals("I")){
					eqrShrtTermOffhCondVOs[i].setCreUsrId(account.getUsr_id());
					eqrShrtTermOffhCondVOs[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(eqrShrtTermOffhCondVOs[i]);
				} else if ( eqrShrtTermOffhCondVOs[i].getIbflag().equals("D")){
					deleteVoList.add(eqrShrtTermOffhCondVOs[i]);
				}
			}
			
			if ( mergeVoList.size() > 0 ) {
				dbDao.modifyDefaultSTOffHireInfo(mergeVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteDefaultSTOffHireInfo(deleteVoList);
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
	 * [EES_EQR_0124 : Cabotage & HJS Rule 조회]<br>
	 * 
	 * @param String cnsttype
	 * @param String tpsztype
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultEmptyRepoConstraintInfo(String cnsttype, String tpsztype) throws EventException {
		try {
			return dbDao.searchDefaultEmptyRepoConstraintInfo(cnsttype, tpsztype);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 수정,삭제]<br><br>
	 * 
	 * @param eqrRepoCnstVOs	EqrRepoCnstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyDefaultEmptyRepoConstraintInfo(EqrRepoCnstVO[] eqrRepoCnstVOs,SignOnUserAccount account) throws EventException{
		try {
			List<EqrRepoCnstVO> insertVoList = new ArrayList<EqrRepoCnstVO>();
			List<EqrRepoCnstVO> updateVoList = new ArrayList<EqrRepoCnstVO>();
			List<EqrRepoCnstVO> deleteVoList = new ArrayList<EqrRepoCnstVO>();
			List<EqrRepoCnstVO> deleteVoList2 = new ArrayList<EqrRepoCnstVO>(); // update에서 사용할 deleteVOList
			
			int ruleSeq 	= 0;
		    int cnstSeq		= 0;
		    String ruleCode = "";
		    String ruleCodeTemp = "";
		    String nationCode = "";
		    //String eccType = "";
		    String eccCode = "";
		    ArrayList tpsztype = new ArrayList();
	    
			for ( int i=0; i<eqrRepoCnstVOs .length; i++ ) {
				
				eqrRepoCnstVOs[i].setCreUsrId(account.getUsr_id());
				eqrRepoCnstVOs[i].setUpdUsrId(account.getUsr_id());
				
				tpsztype = (ArrayList) Utils.replaceStrToList(eqrRepoCnstVOs[i].getTpsztype());
				if( "".equals(eqrRepoCnstVOs[i].getFmLocGrpCd()) ){
					eqrRepoCnstVOs[i].setFmLocGrpCd("N");
				}
				if( "".equals(eqrRepoCnstVOs[i].getFmLocCd()) ){
					eqrRepoCnstVOs[i].setFmLocCd("N/A");
				}
				if( "".equals(eqrRepoCnstVOs[i].getToLocGrpCd()) ){
					eqrRepoCnstVOs[i].setToLocGrpCd("N");
				}
				if( "".equals(eqrRepoCnstVOs[i].getToLocCd()) ){
					eqrRepoCnstVOs[i].setToLocCd("N/A");
				}
				if( "1".equals(eqrRepoCnstVOs[i].getRuleExptFlg()) ){
					eqrRepoCnstVOs[i].setRuleExptFlg("Y");
				}
				if( "0".equals(eqrRepoCnstVOs[i].getRuleExptFlg()) ){
					eqrRepoCnstVOs[i].setRuleExptFlg("N");
				}
				
				if ( "I".equals(eqrRepoCnstVOs[i].getIbflag()) ){
					if( eqrRepoCnstVOs[i].getCnstRuleId().equals("")){
						if(eqrRepoCnstVOs[i].getRepoCnstTpCd().equals("H")){
							if(eqrRepoCnstVOs[i].getFmLocGrpCd().equals("A")){
	                			eccCode = eqrRepoCnstVOs[i].getToLocCd();
	                			//eccType = eqrRepoCnstVOs[i].getToLocGrpCd();
							} else if(eqrRepoCnstVOs[i].getToLocGrpCd().equals("A")){
	                			eccCode = eqrRepoCnstVOs[i].getFmLocCd();
	                			//eccType = eqrRepoCnstVOs[i].getFmLocGrpCd();
							} else {
	                			eccCode = eqrRepoCnstVOs[i].getFmLocCd();
	                			//eccType = eqrRepoCnstVOs[i].getFmLocGrpCd();							
							}								
						} else if(eqrRepoCnstVOs[i].getRepoCnstTpCd().equals("C")){
	                		eccCode = eqrRepoCnstVOs[i].getFmLocCd();
	                		//eccType = "C";
						}
						
						// 국가 코드 생성
	                	nationCode = eccCode.substring(0,2);
	                	
	                	if(0==ruleSeq){
	                		ruleSeq = dbDao.createCnstRuleId(nationCode, eqrRepoCnstVOs[i].getRepoCnstTpCd());                    		
	                	}else {
	                		ruleSeq++;
	                	}
	                	ruleCodeTemp = "000" + ruleSeq;
	                	ruleCode = nationCode + ruleCodeTemp.substring(ruleCodeTemp.length()-4,ruleCodeTemp.length()) + eqrRepoCnstVOs[i].getRepoCnstTpCd();
	                	eqrRepoCnstVOs[i].setCnstRuleId(ruleCode);
	                	
	                	// seq 생성
	                	if(0==cnstSeq){
	                		cnstSeq = dbDao.createCnstSeq();
	                	}else{
	                		cnstSeq++;
	                	}
	                	eqrRepoCnstVOs[i].setRepoCnstSeq(cnstSeq+"");
					} else {
						ruleCode	= eqrRepoCnstVOs[i].getCnstRuleId();
						eqrRepoCnstVOs[i].setCnstRuleId(ruleCode);
					}
					
					// 체크된 Cntr Tpsz별로 리스트에  담기위해   
					for( int k=0; k < tpsztype.size(); k++){
						EqrRepoCnstVO insertVO = new EqrRepoCnstVO();
						
						insertVO.setCnstRuleId	(eqrRepoCnstVOs[i].getCnstRuleId());
						insertVO.setCreDt		(eqrRepoCnstVOs[i].getCreDt());
						insertVO.setCreUsrId	(eqrRepoCnstVOs[i].getCreUsrId());
						insertVO.setEqTrspModCd	(eqrRepoCnstVOs[i].getEqTrspModCd());
						insertVO.setFmLocCd		(eqrRepoCnstVOs[i].getFmLocCd());
						insertVO.setFmLocGrpCd	(eqrRepoCnstVOs[i].getFmLocGrpCd());
						insertVO.setRepoCnstSeq	(eqrRepoCnstVOs[i].getRepoCnstSeq());
						insertVO.setCnstCntrTpszCd((String) tpsztype.get(k));
						insertVO.setRepoCnstTpCd(eqrRepoCnstVOs[i].getRepoCnstTpCd());
						insertVO.setRuleExptFlg	(eqrRepoCnstVOs[i].getRuleExptFlg());
						insertVO.setToLocCd		(eqrRepoCnstVOs[i].getToLocCd());
						insertVO.setToLocGrpCd	(eqrRepoCnstVOs[i].getToLocGrpCd());
						insertVO.setUpdUsrId	(eqrRepoCnstVOs[i].getUpdUsrId());
						
						if ( "H".equals(eqrRepoCnstVOs[i].getRepoCnstTpCd()) ) {
							insertVO.setRepoCnstDirCd("AL");
						} else {
							insertVO.setRepoCnstDirCd(eqrRepoCnstVOs[i].getRepoCnstDirCd());
						}
						
						insertVoList.add(insertVO);
					}
				}else if ( "U".equals(eqrRepoCnstVOs[i].getIbflag()) ){

					// 삭제 후 수정하기 위해 
					deleteVoList2.add(eqrRepoCnstVOs[i]);
					
					// 체크된 Cntr Tpsz별로 리스트에  담기위해   
					for( int k=0; k < tpsztype.size(); k++){
						EqrRepoCnstVO updateVO = new EqrRepoCnstVO();
						
						updateVO.setCnstRuleId	(eqrRepoCnstVOs[i].getCnstRuleId());
						updateVO.setCreDt		(eqrRepoCnstVOs[i].getCreDt());
						updateVO.setCreUsrId	(eqrRepoCnstVOs[i].getCreUsrId());
						updateVO.setEqTrspModCd	(eqrRepoCnstVOs[i].getEqTrspModCd());
						updateVO.setFmLocCd		(eqrRepoCnstVOs[i].getFmLocCd());
						updateVO.setFmLocGrpCd	(eqrRepoCnstVOs[i].getFmLocGrpCd());
						updateVO.setRepoCnstSeq	(eqrRepoCnstVOs[i].getRepoCnstSeq());
						updateVO.setCnstCntrTpszCd((String) tpsztype.get(k));
						updateVO.setRepoCnstTpCd(eqrRepoCnstVOs[i].getRepoCnstTpCd());
						updateVO.setRuleExptFlg	(eqrRepoCnstVOs[i].getRuleExptFlg());
						updateVO.setToLocCd		(eqrRepoCnstVOs[i].getToLocCd());
						updateVO.setToLocGrpCd	(eqrRepoCnstVOs[i].getToLocGrpCd());
						updateVO.setUpdUsrId	(eqrRepoCnstVOs[i].getUpdUsrId());
						
						if ( "".equals(eqrRepoCnstVOs[i].getRepoCnstTpCd()) ) {
							updateVO.setRepoCnstDirCd("AL");
						} else {
							updateVO.setRepoCnstDirCd(eqrRepoCnstVOs[i].getRepoCnstTpCd());
						}
						updateVoList.add(updateVO);
					}
				} else if ( "D".equals(eqrRepoCnstVOs[i].getIbflag()) ){
					deleteVoList.add(eqrRepoCnstVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.modifyDefaultEmptyRepoConstraintInfo(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.deleteDefaultEmptyRepoConstraintInfo(deleteVoList2);
				dbDao.modifyDefaultEmptyRepoConstraintInfo(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteDefaultEmptyRepoConstraintInfo(deleteVoList);
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
	 * [EES_EQR_0137 : Constraint by Lane/POD 조회]<br>
	 * 
	 * @param EesEqr0137ConditionVO eesEqr0137ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultConstraintLandPod(EesEqr0137ConditionVO eesEqr0137ConditionVO) throws EventException {
		try {
			return dbDao.searchDefaultConstraintLandPod(eesEqr0137ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 수정,삭제]<br>
	 * 
	 * @param EqrPortDchgCnstVO[] eqrPortDchgCnstVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultConstraintLandPod(EqrPortDchgCnstVO[] eqrPortDchgCnstVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrPortDchgCnstVO> insertVoList = new ArrayList<EqrPortDchgCnstVO>();
			List<EqrPortDchgCnstVO> updateVoList = new ArrayList<EqrPortDchgCnstVO>();
			List<EqrPortDchgCnstVO> deleteVoList = new ArrayList<EqrPortDchgCnstVO>();
			for ( int i=0; i<eqrPortDchgCnstVO .length; i++ ) {
				if ( eqrPortDchgCnstVO[i].getIbflag().equals("I")){
					eqrPortDchgCnstVO[i].setCreUsrId(account.getUsr_id());
					eqrPortDchgCnstVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(eqrPortDchgCnstVO[i]);
				} else if ( eqrPortDchgCnstVO[i].getIbflag().equals("U")){
					eqrPortDchgCnstVO[i].setCreUsrId(account.getUsr_id());
					eqrPortDchgCnstVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrPortDchgCnstVO[i]);
				} else if ( eqrPortDchgCnstVO[i].getIbflag().equals("D")){
					deleteVoList.add(eqrPortDchgCnstVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyDefaultConstraintLandPod(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDefaultConstraintLandPod(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteDefaultConstraintLandPod(deleteVoList);
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
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchAutoRunParameter   searchAutoRunParameter
	 * @return List<SearchAutoRunParameterVO>
	 * @exception EventException
	 */
	public List<SearchAutoRunParameterVO> searchAutoRunParameter(SearchAutoRunParameterVO searchAutoRunParameter) throws EventException {
		try {
			return dbDao.searchAutoRunParameter(searchAutoRunParameter);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Multi 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  
	 * @param EqrAutoRunFcastParaVO[] eqrAutoRunFcastParaVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiAutoRunParameter(EqrAutoRunFcastParaVO[] eqrAutoRunFcastParaVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrAutoRunFcastParaVO> insertVoList = new ArrayList<EqrAutoRunFcastParaVO>();
			List<EqrAutoRunFcastParaVO> updateVoList = new ArrayList<EqrAutoRunFcastParaVO>();
			List<EqrAutoRunFcastParaVO> updateVoList1 = new ArrayList<EqrAutoRunFcastParaVO>();
			
			boolean insFlag = false;
			
			String effCurYrwk = selectEffStYrwk();
			String effNextYrwk = (Integer.parseInt(effCurYrwk) + 1) + "";
			
			log.debug("effCureYrwk" + effCurYrwk );
			log.debug("effNextYrwk" + effNextYrwk );

			log.debug("effCureYrwk" + eqrAutoRunFcastParaVO.length );
		
			for ( int i=0; i<eqrAutoRunFcastParaVO.length; i++ ) {
				if (eqrAutoRunFcastParaVO[i].getIbflag().equals("U")) {
					log.debug("ibflg" + eqrAutoRunFcastParaVO[i].getIbflag() );
					if (Integer.parseInt(eqrAutoRunFcastParaVO[i].getEffStYrwk()) >= Integer.parseInt(effCurYrwk)){
						insFlag = false;//현주차보다 eff_st 가 미래면 update 만함.
						log.debug("false");
					}else {
						insFlag = true;
						log.debug("true");
					}
	
					if(insFlag){
						eqrAutoRunFcastParaVO[i].setCreUsrId(account.getUsr_id());
						eqrAutoRunFcastParaVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(eqrAutoRunFcastParaVO[i]);
						updateVoList.add(eqrAutoRunFcastParaVO[i]);
					}else {
						eqrAutoRunFcastParaVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList1.add(eqrAutoRunFcastParaVO[i]);
					}
				}  
			}
			if (updateVoList.size() > 0 ){
				dbDao.multiAutoRunParameterUpdate(updateVoList, effCurYrwk, effNextYrwk ,insFlag);
			}

			if (insertVoList.size() >0 ){
				dbDao.multiAutoRunParameterInsert(insertVoList , effCurYrwk, effNextYrwk);
			}

			if (updateVoList1.size() >0 ){
				dbDao.multiAutoRunParameterUpdate(updateVoList1, effCurYrwk, effNextYrwk ,insFlag);
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
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String selectEffStYrwk() throws EventException {		
		String pln_yrwk = "";
		
		try {
			pln_yrwk = dbDao.selectEffStYrwk();
			return pln_yrwk;
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchSafetyStockVo searchSafetyStockVO
	 * @param String loc
	 * @param String loctype
	 * @param String tpsz
	 * @param String tpsztype
	 * @param String tpsztypes
	 * @param String lvlcd
	 * @return List<SearchSafetyStockVO>
	 * @exception EventException
	 */
	public CommonRsVO searchDefaultCntrSafetyStock(SearchSafetyStockVO searchSafetyStockVO ,String loc, String loctype, String tpsz, String tpsztype, String tpsztypes, String lvlcd) throws EventException {
		try {
			return dbDao.searchDefaultCntrSafetyStock(searchSafetyStockVO, loc, loctype, tpsz, tpsztype, tpsztypes, lvlcd );
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0117화면의 값을 가져오기  <br>
	 * 
	 * @param eesEqr0117ConditionVO   EesEqr0117ConditionVO
	 * @return List<EesEqr0117ConditionVO>
	 * @exception EventException
	 */
	public List<EesEqr0117ConditionVO> searchDefaultCntrSafetyStockQty(EesEqr0117ConditionVO eesEqr0117ConditionVO ) throws EventException {
		try {
			return dbDao.searchDefaultCntrSafetyStockQty(eesEqr0117ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 *  0117화면 멀티 이벤트 처리 <br>
	 *  
	 * @param EqrEccSftStkVO[] eqrEccSftStkVO
	 * @param SignOnUserAccount account
	 * @param String lvl_cd
	 * @exception EventException
	 */
	public void multiDefaultCntrSafetyStock(EqrEccSftStkVO[] eqrEccSftStkVO, SignOnUserAccount account ,String lvl_cd) throws EventException{
		try {
			List<EqrEccSftStkVO> insertVoList = new ArrayList<EqrEccSftStkVO>();
			List<EqrEccSftStkVO> updateVoList = new ArrayList<EqrEccSftStkVO>();
			List<EqrEccSftStkVO> deleteVoList = new ArrayList<EqrEccSftStkVO>();
			
			for ( int i=0; i<eqrEccSftStkVO.length; i++ ) {
				if (eqrEccSftStkVO[i].getIbflag().equals("I")) {
					log.debug("ibflg" + eqrEccSftStkVO[i].getIbflag() );
					eqrEccSftStkVO[i].setCreUsrId(account.getUsr_id());
					eqrEccSftStkVO[i].setUpdUsrId(account.getUsr_id());
					
					insertVoList.add(eqrEccSftStkVO[i]);
				}else if(eqrEccSftStkVO[i].getIbflag().equals("U")){
					if (!searchCntrSafetyStockIsExist(eqrEccSftStkVO[i].getEccCd(), eqrEccSftStkVO[i].getCntrTpszCd()) &&
						!eqrEccSftStkVO[i].getSfstkLvlCd().equals("") &&
						!eqrEccSftStkVO[i].getSfstkVolQty().equals("") )
					{
						eqrEccSftStkVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(eqrEccSftStkVO[i]);
					}else {
						eqrEccSftStkVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(eqrEccSftStkVO[i]);
					}
				}else if (eqrEccSftStkVO[i].getIbflag().equals("D")){  
					deleteVoList.add(eqrEccSftStkVO[i]);
				}
			}
			if (insertVoList.size() > 0 ){
				dbDao.multiDefaultCntrSafetyStockInsert(insertVoList , lvl_cd);
			}
			if (updateVoList.size() > 0 ){
				dbDao.multiDefaultCntrSafetyStockUpdate(updateVoList , lvl_cd);
			}
			if (deleteVoList.size() > 0 ){
				dbDao.multiDefaultCntrSafetyStockDelete(deleteVoList, lvl_cd);
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
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ecc_cd
	 * @param String cntr_tpsz_cd
	 * @return boolean
	 * @exception EventException
	 */
	public boolean searchCntrSafetyStockIsExist(String ecc_cd , String cntr_tpsz_cd) throws EventException {		
		try {
			return  dbDao.searchCntrSafetyStockIsExist(ecc_cd , cntr_tpsz_cd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0122화면 첫번째 시트 조회 <br>
	 * 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultYearDomesticPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws EventException {
		try {
			return dbDao.searchDefaultYearDomesticPlan(eesEqr0122ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 *  0122화면 두번째 시트 조회 <br>
	 * 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception EventException
	 */
	public ScenarioDefaultManageRsVO searchDefaultYearDomesticDetailPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws EventException {
		try {
			return dbDao.searchDefaultYearDomesticDetailPlan(eesEqr0122ConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  0122화면 멀티 이벤트 처리 
	 * @param EqrDmstPlnVO[] eqrDmstPlnVO
	 * @param EesEqr0122ConditionVO eesEqr0122ConditionVO
	 * @param List rsCount
	 * @param List rsWeek
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void createDefaultYearDomesticPlan(EqrDmstPlnVO[] eqrDmstPlnVo ,EesEqr0122ConditionVO eesEqr0122ConditionVO, List rsCount, List rsWeek, SignOnUserAccount account) throws EventException{
		String year    = eesEqr0122ConditionVO.getFmPlnYr();
		String yrWk = "";
		
		try {			
			dbDao.createDefaultYearDomesticPlanDelete(year);
			//Insert logic
	        for( int j = 0 ; j < rsWeek.size() ; j++ ) {
	        	yrWk = year + Utils.fill(String.valueOf(rsWeek.get(j)), 2, "0", "left");   
	        	String user_id = account.getUsr_id();
	    		dbDao.createDefaultYearDomesticPlanInsert(yrWk , rsCount.get(j) ,user_id);
	    	//	dbDao.createDefaultYearDomesticPlanInsert(insertVoList);
	        }
	        
			//update Logic
	       
	        for( int k = 0 ; k < rsWeek.size() ; k++ ) {
	        	yrWk = year + Utils.fill(String.valueOf(rsWeek.get(k)), 2, "0", "left");   
	        	
	    		String user_id = account.getUsr_id();
	        	dbDao.createDefaultYearDomesticPlanUpdate(yrWk , rsCount.get(k) ,user_id);
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
	 * 멀티 이벤트 처리<br>
	 *  Scenariodefaultmanage화면에 대한 조회 이벤트 처리<br>
	 *  0122화면 멀티 이벤트 처리 
	 * @param eqrDmstPlnVO EqrDmstPlnVO[]
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultYearDomesticPlan(EqrDmstPlnVO[] eqrDmstPlnVO, EesEqr0122ConditionVO eesEqr0122ConditionVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrDmstPlnVO> mergeVoList = new ArrayList<EqrDmstPlnVO>();
			List<EqrDmstPlnVO> deleteVoList = new ArrayList<EqrDmstPlnVO>();
			
			for ( int i=0; i<eqrDmstPlnVO.length; i++ ) {
				if (eqrDmstPlnVO[i].getIbflag().equals("D")){ 
					eqrDmstPlnVO[i].setPlnYrwk( eesEqr0122ConditionVO.getFmPlnYr()+ eqrDmstPlnVO[i].getPlnYrwk());
					deleteVoList.add(eqrDmstPlnVO[i]);
				}else {
					eqrDmstPlnVO[i].setPlnYrwk( eesEqr0122ConditionVO.getFmPlnYr()+ eqrDmstPlnVO[i].getPlnYrwk());
					eqrDmstPlnVO[i].setCreUsrId(account.getUsr_id());
					eqrDmstPlnVO[i].setUpdUsrId(account.getUsr_id());
					mergeVoList.add(eqrDmstPlnVO[i]);
				}
			}  
			
			if ( mergeVoList.size() > 0 ){
				dbDao.modifyDefaultYearDomesticPlanUpdate(mergeVoList);
			}
        
        	if ( deleteVoList.size() > 0 ){
        		dbDao.modifyDefaultYearDomesticPlanDelete(deleteVoList);
        	}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
