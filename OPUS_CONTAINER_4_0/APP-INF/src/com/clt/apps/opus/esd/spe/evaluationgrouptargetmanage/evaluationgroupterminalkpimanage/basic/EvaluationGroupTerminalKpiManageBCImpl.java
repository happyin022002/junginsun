/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupTerminalKpiManageBCImpl.java
*@FileTitle : EvaluationGroupTargetManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.integration.EvaluationGroupTerminalKpiManageDBDAO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchEGTerminalKpiManageVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupterminalkpimanage.vo.SearchVndrSeqVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpTmlKpiTgtRtoVO;

/**
 * ALPS-EvaluationGroupTargetManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-EvaluationGroupTargetManage<br>
 *
 * @author 
 * @see ESD_SPE_0009EventResponse,EvaluationGroupTerminalKpiManageBC 
 * @since J2EE 1.6
 */
public class EvaluationGroupTerminalKpiManageBCImpl extends BasicCommandSupport implements EvaluationGroupTerminalKpiManageBC {

	// Database Access Object
	private transient EvaluationGroupTerminalKpiManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating EvaluationGroupTerminalKpiManageDBDAO class<br>
	 */
	public EvaluationGroupTerminalKpiManageBCImpl() {
		dbDao = new EvaluationGroupTerminalKpiManageDBDAO();
	}
	/**
	 * Retrieving EG Terminal Kpi<br>
	 * 
	 * @param SearchEGTerminalKpiManageVO speEvGrpTmlKpiTgtRto
	 * @return List<SearchEGTerminalKpiManageVO>
	 * @exception EventException
	 */
	public List<SearchEGTerminalKpiManageVO> searchEGTerminalKpiManage(SearchEGTerminalKpiManageVO speEvGrpTmlKpiTgtRto) throws EventException {
		try {		 
			return dbDao.searchEGTerminalKpiManage(speEvGrpTmlKpiTgtRto);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
		
	/**
	 * Saving the data of SpeEvGrpTmlKpiTgtRto<br>
	 * 
	 * @param SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpeEvGrpTmlKpiTgtRto(SpeEvGrpTmlKpiTgtRtoVO[] speEvGrpTmlKpiTgtRtoVos, SignOnUserAccount account) throws EventException{
		try {
			List<SpeEvGrpTmlKpiTgtRtoVO> insertVoList = new ArrayList<SpeEvGrpTmlKpiTgtRtoVO>();
			List<SpeEvGrpTmlKpiTgtRtoVO> updateVoList = new ArrayList<SpeEvGrpTmlKpiTgtRtoVO>();
			List<SpeEvGrpTmlKpiTgtRtoVO> deleteVoList = new ArrayList<SpeEvGrpTmlKpiTgtRtoVO>();
			boolean check_Unique = false;
//			boolean check_Data = false;
			String egId="";
			String egIdSeq ="";
			String vndrSeq =""; 
			String evYr ="";
			String ydCd ="";
						
			for ( int i=0; i<speEvGrpTmlKpiTgtRtoVos .length; i++ ) {
				
				egId 	  = speEvGrpTmlKpiTgtRtoVos[i].getEgId();
				egIdSeq = speEvGrpTmlKpiTgtRtoVos[i].getEgIdSeq();
				vndrSeq  = speEvGrpTmlKpiTgtRtoVos[i].getVndrSeq();	
				evYr     = speEvGrpTmlKpiTgtRtoVos[i].getEvYr();
				ydCd     = speEvGrpTmlKpiTgtRtoVos[i].getYdCd();
				check_Unique =dbDao.confirmUnique(egId,egIdSeq,vndrSeq,evYr,ydCd);	
				
				if ( speEvGrpTmlKpiTgtRtoVos[i].getIbflag().equals("I")){
					speEvGrpTmlKpiTgtRtoVos[i].setCreUsrId(account.getUsr_id());
					speEvGrpTmlKpiTgtRtoVos[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(speEvGrpTmlKpiTgtRtoVos[i]);
				} else if ( speEvGrpTmlKpiTgtRtoVos[i].getIbflag().equals("U")){
					if (check_Unique) {
						speEvGrpTmlKpiTgtRtoVos[i].setCreUsrId(account.getUsr_id());
						speEvGrpTmlKpiTgtRtoVos[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(speEvGrpTmlKpiTgtRtoVos[i]);
					}else {					 
						speEvGrpTmlKpiTgtRtoVos[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(speEvGrpTmlKpiTgtRtoVos[i]);
					}
				} else if ( speEvGrpTmlKpiTgtRtoVos[i].getIbflag().equals("D")){
					deleteVoList.add(speEvGrpTmlKpiTgtRtoVos[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiSpeEvGrpTmlKpiTgtRtoS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiSpeEvGrpTmlKpiTgtRtoS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiSpeEvGrpTmlKpiTgtRtoS(deleteVoList);
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
	 * Retrieving the vendor sequence<br>
	 * 
	 * @param SearchVndrSeqVO searchVndrSeqVO
	 * @return List<SearchVndrSeqVO>
	 * @exception EventException
	 */
	public List<SearchVndrSeqVO> searchVndrSeq(SearchVndrSeqVO searchVndrSeqVO) throws EventException {
		try {
			return dbDao.searchVndrSeq(searchVndrSeqVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
}