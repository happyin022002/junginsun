/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCrationBCImpl.java
*@FileTitle : 공동운항추정 산출
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.06.04 함대성
* 1.0 Creation
* -------------------------------------------------------
* 2012.01.10 조병연[CHM-201215460-01]
* Title : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 :
* 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)

* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*   분석의 다각화 가능
* 2012.02.13 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration.JointOperationAccrualCreationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.JooEstmClzVO;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;


/**
 * ALPS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - ALPS-JointOperationAgreementSettlement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HAM DAE SUNG
 * @see UI_JOO_0030EventResponse,JointOperationAccrualCrationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class JointOperationAccrualCreationBCImpl extends BasicCommandSupport implements JointOperationAccrualCreationBC {

	// Database Access Object
	private transient JointOperationAccrualCreationDBDAO dbDao = null;

	/**
	 * JointOperationAccrualCrationBCImpl 객체 생성<br>
	 * JointOperationAccrualCrationDBDAO를 생성한다.<br>
	 */
	public JointOperationAccrualCreationBCImpl() {
		dbDao = new JointOperationAccrualCreationDBDAO();
	}
	/**
	 * AccrualClosing 여부를 조회한다. <br>
	 * @param JooEstmClzVO jooEstmClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooEstmClzVO>
	 * @exception EventException
	 */
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			/*
			 * 1 해당 년도의 월별 데이타건수 조회
			 * 2-1 데이타가 0건인경우 12개월치 데이타를 생성
			 * 2-2 데이타가 한건 이상인 경우(로직상 실제로 12건임) 
			 */
			//1
			String estmClzYr = (String)jooEstmClzVO.getEstmClzYr();
			int clzCnt = Integer.valueOf( dbDao.searchExistAccrualClosing(estmClzYr) );
			//2-1
			if(clzCnt == 0){
				for (int inx=1; inx<=12; inx++){
					jooEstmClzVO.setCreUsrId(signOnUserAccount.getUsr_id());
					jooEstmClzVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					//월 데이타 세팅  
					if(inx < 10){
						jooEstmClzVO.setEstmClzMon("0"+String.valueOf(inx));
					}else{
						jooEstmClzVO.setEstmClzMon(String.valueOf(inx));
					}
					
					dbDao.addAccrualClosing(jooEstmClzVO);
				} 
			}

			//2-2
			return dbDao.searchAccrualClosing(jooEstmClzVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}

	/**
	 * Accrual Closing 여부를 일괄 수정한다. <br>
	 * @param JooEstmClzVO[] jooEstmClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void modifyAccrualClosing(JooEstmClzVO[] jooEstmClzVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<JooEstmClzVO> updateVoList = new ArrayList<JooEstmClzVO>();
			for ( int i=0; i<jooEstmClzVO .length; i++ ) {
				if ( jooEstmClzVO[i].getIbflag().equals("U")){
					jooEstmClzVO[i].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(jooEstmClzVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAccrualClosing(updateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}
	
    /**
     * Estimate Report - Account을 조회합니다.<br>
     *
     * @param  ActRsltRVO actRsltRVO
     * @throws EventException
     * @return List<ActRsltRVO>
     * @author jang kang cheol
     */
	public List<ActRsltRVO> searchAccrualListByAccount(ActRsltRVO actRsltRVO) throws EventException {
		try {
 
			actRsltRVO.setExeYrmon(actRsltRVO.getExeYrmon().replace("-", ""));
			
			return dbDao.searchAccrualListByAccount(actRsltRVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}	

	/**
	 *  추정_MAS 용 ESTD Report - MAS 화면에 대한 조회 이벤트 처리<br>
	 * @param ActRsltRVO actRsltRVO
	 * @return List<ActRsltRVO>
	 * @exception EventException
	 */
	public List<ActRsltRVO> searchAccrualListByMAS (ActRsltRVO actRsltRVO) throws EventException {
		try {
			//String exeYrmon = (String)jooEstmActRsltVO.getExeYrmon();
			//String iflag = (String)jooEstmActRsltVO.getIbflag();
			actRsltRVO.setExeYrmon(actRsltRVO.getExeYrmon().replace("-", ""));
			
			return dbDao.searchAccrualListByMAS(actRsltRVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		}
	}
    /**
     *   Estimate Performance Creation된 정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstmActRsltVO> searchJointOperationAccrualList(
            SettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualList(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
    /**
     *   Estimate Performance(ERP) 정보를 조회한다. 
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstmActRsltVO> searchJointOperationAccrualERP(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualERP(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }      
    
    /**
     * 
     * [Estimate Performance Creation]을 [Save]합니다.
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String manageJointOperationAccrual( EstmActRsltVO[] estmActRsltVOs, 
    		SettlementConditionVO settlementConditionVO,  
    		SignOnUserAccount signOnUserAccount) throws EventException{
    	try {
			JointOperationAccrualCreationBackEndJob backEndResult = new JointOperationAccrualCreationBackEndJob();

			BackEndJobManager backEndJobManager = new BackEndJobManager();

			backEndResult.setEstmActRsltVOs(estmActRsltVOs);
			backEndResult.setSettlementConditionVO(settlementConditionVO);
			backEndResult.setSignOnUserAccount(signOnUserAccount);
			backEndResult.setJobFlg("SAVE");
			return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "JOO Estimation Save!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[] {"JOO Estimation", "SAVE" }).getMessage(), ex);
		}    	
    }

    /**
     * 
     * [Estimate Performance Creation]을 [ERP로 전송]합니다.
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String sendJointOperationAccrualERP( EstmActRsltVO[] estmActRsltVOs, SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException{
    	try{
			JointOperationAccrualCreationBackEndJob backEndResult = new JointOperationAccrualCreationBackEndJob();
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
	
			//backEndResult.setEstmActRsltVOs(estmActRsltVOs);
    		backEndResult.setSettlementConditionVO(settlementConditionVO);
			backEndResult.setSignOnUserAccount(signOnUserAccount);
			backEndResult.setJobFlg("SEND");
			
			return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(),"JOO Estimation Send to ERP!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Estimation", "Send to ERP"}).getMessage(), ex);
        }		
    }
    /**
     * [Estimate Code Check - Carrier]을 [조회Retrieve]합니다.<br>
     *
     * @param  String yearMm
     * @return List<EstdCarVO>
     * @throws EventException
     * @author jang kang cheol
     */ 
    public List<EstdCarVO> searchEstdCarCheckList(String yearMm)
            throws EventException { 
        try{
            return dbDao.searchEstdCarCheckList(yearMm);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }        
    }
    /**
     *   
     * [Estimate Code Check - VVD]을 [조회Retrieve]합니다.<br>
     *
     * @param  EstdVvdVO estdVvdVO
     * @return List<EstdVvdVO>
     * @throws EventException
     * @author jang kang cheol
     */
    public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO)
            throws EventException {
        try{
            return dbDao.searchEstdVvdCheckList(estdVvdVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }  
 
    }

    /**
     * Estimation Create
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String createJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
    		JointOperationAccrualCreationBackEndJob backEndResult = new JointOperationAccrualCreationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("CREATE");
    		backEndResult.setSettlementConditionVO(settlementConditionVO);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "JOO Estimation Create!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Estimation", "Create"}).getMessage(), ex);
        }
    }   

    /**
     * Estimation Create 대상 조회
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String calJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
    		JointOperationAccrualCreationBackEndJob backEndResult = new JointOperationAccrualCreationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("CREATE_RETRIEVE");
    		backEndResult.setSettlementConditionVO(settlementConditionVO);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "JOO Estimation Create!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Estimation", "Create"}).getMessage(), ex);
        }
    }       
    
    /**
     * Estimation Create 대상 조회
     * @param SettlementConditionVO settlementConditionVO
     * @return List<EstmActRsltVO>
     * @throws EventException
     */
    public List<EstmActRsltVO> searchJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.calJointOperationAccrual(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }        
    
       
    /**
     * Estimate Performance Retrieve
     * @param EstmConditionVO estmConditionVO
     * @return List<EstmActRsltVO>
     * @throws EventException
     */
    public List<EstmActRsltVO> searchEstmPerformanceList(EstmConditionVO estmConditionVO) throws EventException {
        try {
            return dbDao.searchEstmPerformanceList(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
    /**
     * BackEndJob의 수행결과를 조회한다.
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Estimation Creation", "Search BackendJob Status"}).getMessage(), ex);
		}
	}    

	/**
	 * Estimation Result의 Total금액 조회
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualTotal(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
	/**
	 * Estimation Result(ERP)의 Total금액 조회
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualERPTotal(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
            return dbDao.searchJointOperationAccrualERPTotal(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }    
    
    /**
     * Estimate Performance Change Status Retrieve
     * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
     * @return List<EstmPerformanceChangeStatusRsltVO>
     * @throws EventException
     */
    public List<EstmPerformanceChangeStatusRsltVO> searchEstmPerformanceChangeStatusList(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws EventException {
        try {
            return dbDao.searchEstmPerformanceChangeStatusList(estmPerformanceChangeStatusVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
    /**
     * 
     * Estimate Performance Change Status을 [Save]합니다.
     *
     * @param EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs
     * @param SignOnUserAccount signOnUserAccount
     * @throws EventException
     */
    public void manageEstmPerformanceChangeStatus( EstmPerformanceChangeStatusRsltVO[] estmPerformanceChangeStatusRsltVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {

			List<EstmPerformanceChangeStatusRsltVO> insertVoList = new ArrayList<EstmPerformanceChangeStatusRsltVO>();
			List<EstmPerformanceChangeStatusRsltVO> updateVoList = new ArrayList<EstmPerformanceChangeStatusRsltVO>();
			List<EstmPerformanceChangeStatusRsltVO> list = new ArrayList<EstmPerformanceChangeStatusRsltVO>();
			
			if(estmPerformanceChangeStatusRsltVOs != null && estmPerformanceChangeStatusRsltVOs.length > 0){
				for ( int i=0; i<estmPerformanceChangeStatusRsltVOs.length; i++ ) {

					if ( estmPerformanceChangeStatusRsltVOs[i].getIbflag().equals("U")){
						list = dbDao.chkEstmPerformanceChangeStatus(estmPerformanceChangeStatusRsltVOs[i]);
						
						estmPerformanceChangeStatusRsltVOs[i].setUpUsrId(signOnUserAccount.getUsr_id());
						estmPerformanceChangeStatusRsltVOs[i].setCreUsrId(signOnUserAccount.getUsr_id());
						
						if(list.isEmpty()){
							insertVoList.add(estmPerformanceChangeStatusRsltVOs[i]);
						}else{
							updateVoList.add(estmPerformanceChangeStatusRsltVOs[i]);
						}
					}
				}
			}

			if (insertVoList.size() > 0){
				dbDao.addEstmPerformanceChangeStatus(insertVoList);
			}
			if (updateVoList.size() > 0){
				dbDao.modifyEstmPerformanceChangeStatus(updateVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Process", "Update Flag of Target VVD"}).getMessage(), ex);
		}
    }

    
    /**
     * Estimate Performance Change Status II Retrieve
     * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
     * @return List<EstmPerformanceChangeStatusIIRsltVO>
     * @throws EventException
     */
    public List<EstmPerformanceChangeStatusIIRsltVO> searchEstmPerformanceChangeStatusIIList(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws EventException {
        try {
            return dbDao.searchEstmPerformanceChangeStatusIIList(estmPerformanceChangeStatusIIVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
}