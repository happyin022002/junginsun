/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationBC.java
*@FileTitle : Joint Operation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic;

import java.util.List;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.JooEstmClzVO;

/**
 * OPUS-Jointoperationagreementsettlement Business Logic Command Interface<br>
 * - OPUS-Jointoperationagreementsettlement: Business Logic Interface<br>
 *
 * @author
 * @see Ui_joo_0030EventResponse
 * @since J2EE 1.6
 */

public interface JointOperationAccrualCreationBC {
	/**
	 * handling retrieve event 0030<br>
	 * @param JooEstmClzVO jooEstmClzVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooEstmClzVO>
	 * @exception EventException
	 */
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO, SignOnUserAccount signOnUserAccount) throws EventException;
	/**
     * updating Accrual Closing status <br>
	 * @param JooEstmClzVO[] jooEstmClzVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @exception EventException
	 */
	public void modifyAccrualClosing(JooEstmClzVO[] jooEstmClzVOs, SignOnUserAccount signOnUserAccount) throws EventException;
	
	/**
	 * 
     * retrieving Estimate Report - Account<br>
	 *
	 * @param  ActRsltRVO actRsltRVO
	 * @throws EventException
	 * @return List<ActRsltRVO>
	 * @author 
	 */
	public List<ActRsltRVO> searchAccrualListByAccount(ActRsltRVO actRsltRVO) throws EventException;	

	/**
	 * retrieving  ESTD Report - MAS screen<br>
	 * @param ActRsltRVO actRsltRVO
	 * @return List<ActRsltRVO>
	 * @exception EventException
	 */
	public List<ActRsltRVO> searchAccrualListByMAS(ActRsltRVO actRsltRVO) throws EventException;
 
    /**
     *  retrieving [Estimate Performance Creation]<br>
     *      UID : FNS_JOO_0029<br>
     * 
     * @param SettlementConditionVO settlementConditionVO
     * @returnType List<EstmActRsltVO>
     * @throws EventException
     * @author 
     */
    public List<EstmActRsltVO> searchJointOperationAccrualList(SettlementConditionVO settlementConditionVO) throws EventException;
    
    /**
     * 
     *  saving [Estimate Performance Creation]<br>
     *      UID : FNS_JOO_0029<br>
     *
     * @param EstmActRsltVO[] estmActRsltVOs
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String 
     * @throws EventException
     */
    public String manageJointOperationAccrual( EstmActRsltVO[] estmActRsltVOs, SettlementConditionVO settlementConditionVO
                                            , SignOnUserAccount signOnUserAccount) throws EventException;    
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
    public String sendJointOperationAccrualERP( EstmActRsltVO[] estmActRsltVOs,  SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;    
    
    /**
     * retrieving [Estimate Code Check - Carrier]<br>
     *
     * @param  String yearMm 
     * @return List<EstdCarVO>
     * @throws EventException
     * @author 
     */
    public List<EstdCarVO> searchEstdCarCheckList(String yearMm ) throws EventException;
    
    /**
     * retrieving [Estimate Code Check - VVD]<br>
     *
     * @param  EstdVvdVO estdVvdVO
     * @return List<EstdVvdVO>
     * @throws EventException
     * @author 
     */
    public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO ) throws EventException;    
 
    /**
     * Estimation Create
     * @param SettlementConditionVO settlementConditionVO
     * @param SignOnUserAccount signOnUserAccount
     * @return String
     * @throws EventException
     */
    public String calJointOperationAccrual(SettlementConditionVO settlementConditionVO, SignOnUserAccount signOnUserAccount) throws EventException;

    /**
     * Estimate Performance Retrieve
     * @param EstmConditionVO estmConditionVO
     * @return List<EstmActRsltVO>
     * @throws EventException
     */
    public List<EstmActRsltVO> searchEstmPerformanceList(EstmConditionVO estmConditionVO) throws EventException;

    /**
     * retrieving result of BackEndJob
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException;

	/**
	 * retrieving total amount of Estimation Result
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws EventException
	 */
    public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws EventException;
}