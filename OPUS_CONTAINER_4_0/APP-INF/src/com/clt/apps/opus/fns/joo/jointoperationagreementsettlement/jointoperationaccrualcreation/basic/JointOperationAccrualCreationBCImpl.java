/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCrationBCImpl.java
*@FileTitle : Joint Operation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration.JointOperationAccrualCreationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooEstmClzVO;
	
/**
 * OPUS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - OPUS-JointOperationAgreementSettlement: handling business logic<br>
 *
 * @author
 * @see UI_JOO_0030EventResponse,JointOperationAccrualCrationBC DAO class
 * @since J2EE 1.6
 */
public class JointOperationAccrualCreationBCImpl extends BasicCommandSupport implements JointOperationAccrualCreationBC {

	// Database Access Object
	private transient JointOperationAccrualCreationDBDAO dbDao = null;

	/**
	 * JointOperationAccrualCrationBCImpl object creation<br>
	 * JointOperationAccrualCrationDBDAO creation<br>
	 */
	public JointOperationAccrualCreationBCImpl() {
		dbDao = new JointOperationAccrualCreationDBDAO();
	}
	/**
	 * retrieving AccrualClosing status <br>
	 * @param JooEstmClzVO jooEstmClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooEstmClzVO>
	 * @exception EventException
	 */
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO, SignOnUserAccount signOnUserAccount) throws EventException {
		try {
			/*
			 * 1 retrieving year data by month
			 * 2-1 creating 12 months data in case of data not exists
			 * 2-2 in case of data exists
			 */
			//1
			String estmClzYr = (String)jooEstmClzVO.getEstmClzYr();
			int clzCnt = Integer.valueOf( dbDao.searchExistAccrualClosing(estmClzYr) );
			//2-1
			if(clzCnt == 0){
				for (int inx=1; inx<=12; inx++){
					jooEstmClzVO.setCreUsrId(signOnUserAccount.getUsr_id());
					jooEstmClzVO.setUpdUsrId(signOnUserAccount.getUsr_id());
					
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
	 * updating Accrual Closing status <br>
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
     * retrieving Estimate Report - Account<br>
     *
     * @param  ActRsltRVO actRsltRVO
     * @throws EventException
     * @return List<ActRsltRVO>
     * @author 
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
	 *  retrieving  ESTD Report - MAS screen<br>
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
     *   retrieving Estimate Performance Creation
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author 
     */
    public List<EstmActRsltVO> searchJointOperationAccrualList(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
        	//By VVD, By Month 조회 조건 분기
        	if(JooConstants.KEY_VOY_DAYS_CD_VVD.equals(settlementConditionVO.getVoyDaysCd())){
        		return dbDao.searchJointOperationAccrualByVvdList(settlementConditionVO);
        	}else{
        		return dbDao.searchJointOperationAccrualByMonthList(settlementConditionVO);
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
     * 
     * saving [Estimate Performance Creation]
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String manageJointOperationAccrual( EstmActRsltVO[] estmActRsltVOs, SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException{
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
     * transmitting [Estimate Performance Creation] to ERP
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
     * retrieving [Estimate Code Check - Carrier]<br>
     *
     * @param  String yearMm
     * @return List<EstdCarVO>
     * @throws EventException
     * @author 
     */ 
    public List<EstdCarVO> searchEstdCarCheckList(String yearMm) throws EventException { 
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
     * retrieving [Estimate Code Check - VVD]<br>
     *
     * @param  EstdVvdVO estdVvdVO
     * @return List<EstdVvdVO>
     * @throws EventException
     * @author 
     */
    public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO) throws EventException {
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
    public String calJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException {
        try {
    		JointOperationAccrualCreationBackEndJob backEndResult = new JointOperationAccrualCreationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setJobFlg("CREATE");
    		backEndResult.setSettlementConditionVO(settlementConditionVO);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "JOO Estimation Create!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Estimation", "Create"}).getMessage(), ex);
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
        	//By VVD, By Month 조회 조건 분기
        	if(JooConstants.KEY_VOY_DAYS_CD_VVD.equals(estmConditionVO.getVoyDaysCd())){
        		return dbDao.searchEstmPerformanceByVvdList(estmConditionVO);
        	}else{
        		return dbDao.searchEstmPerformanceByMonthList(estmConditionVO);
        	}
        	//return dbDao.searchEstmPerformanceList(estmConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    }
    
    /**
     * retrieving result of BackEndJob
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
	 * retrieving total amount of Estimation Result
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws EventException {
        try {
        	//By VVD, By Month 조회 조건 분기
        	if(JooConstants.KEY_VOY_DAYS_CD_VVD.equals(settlementConditionVO.getVoyDaysCd())){
        		return dbDao.searchJointOperationAccrualTotalByVvd(settlementConditionVO);
        	}else{
        		return dbDao.searchJointOperationAccrualTotalByMonth(settlementConditionVO);
        	}
            //return dbDao.searchJointOperationAccrualTotal(settlementConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"", ""}).getMessage(), ex);
        }
    } 
}