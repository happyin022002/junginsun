/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupStrategicImportanceManageBCImpl.java
*@FileTitle : SI Analysis Result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.integration.EvaluationGroupStrategicImportanceManageDBDAO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchEvaluationGroupStrategicImportanceManageListVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupstrategicimportancemanage.vo.SearchInputListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpStrgImptRsltVO;
 

/**
 * ALPS-EvaluationGroupTargetManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-EvaluationGroupTargetManage<br>
 *
 * @author 
 * @see ESD_SPE_0003EventResponse,EvaluationGroupStrategicImportanceManageBC 
 * @since J2EE 1.6
 */
public class EvaluationGroupStrategicImportanceManageBCImpl extends BasicCommandSupport implements EvaluationGroupStrategicImportanceManageBC {

	// Database Access Object
	private transient EvaluationGroupStrategicImportanceManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating EvaluationGroupStrategicImportanceManageDBDAO class.<br>
	 */
	public EvaluationGroupStrategicImportanceManageBCImpl() {
		dbDao = new EvaluationGroupStrategicImportanceManageDBDAO();
	}
	
	/**
	 * Retrieving the list of the managing evaluation group strategic importance.
	 * 
	 * @param SearchInputListVO searchInputListVO
	 * @return List<SearchEvaluationGroupStrategicImportanceManageListVO>
	 * @exception EventException
	 */
	public List<SearchEvaluationGroupStrategicImportanceManageListVO> searchEvaluationGroupStrategicImportanceManageList(SearchInputListVO searchInputListVO) throws EventException {
		try {
			return dbDao.searchEvaluationGroupStrategicImportanceManageList(searchInputListVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Saving the data of SpeEvGrpStrgImptRslt<br>
	 * 
	 * @param SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpeEvGrpStrgImptRslt(SpeEvGrpStrgImptRsltVO[] speEvGrpStrgImptRsltVO, SignOnUserAccount account) throws EventException{
				
		try {
			List<SpeEvGrpStrgImptRsltVO> insertVoList = new ArrayList<SpeEvGrpStrgImptRsltVO>();
			List<SpeEvGrpStrgImptRsltVO> updateVoList = new ArrayList<SpeEvGrpStrgImptRsltVO>();
			List<SpeEvGrpStrgImptRsltVO> deleteVoList = new ArrayList<SpeEvGrpStrgImptRsltVO>();		

			for ( int i=0; i<speEvGrpStrgImptRsltVO .length; i++ ) {
				if ( speEvGrpStrgImptRsltVO[i].getIbflag().equals("I")){					
					speEvGrpStrgImptRsltVO[i].setCreUsrId(account.getUsr_id());
					speEvGrpStrgImptRsltVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(speEvGrpStrgImptRsltVO[i]);
				} else if ( speEvGrpStrgImptRsltVO[i].getIbflag().equals("U")){
					speEvGrpStrgImptRsltVO[i].setCreUsrId(account.getUsr_id());
					speEvGrpStrgImptRsltVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(speEvGrpStrgImptRsltVO[i]);
				} else if ( speEvGrpStrgImptRsltVO[i].getIbflag().equals("D")){
					speEvGrpStrgImptRsltVO[i].setCreUsrId(account.getUsr_id());
					speEvGrpStrgImptRsltVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(speEvGrpStrgImptRsltVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMultiSpeEvGrpStrgImptRslt(insertVoList);
				dbDao.modifySpeRltSegmRslt(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiSpeEvGrpStrgImptRslt(updateVoList);
				dbDao.modifySpeRltSegmRslt(updateVoList);
			}		
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMultiSpeEvGrpStrgImptRslt(deleteVoList);
				dbDao.modifySpeRltSegmRslt(deleteVoList);
			}
			
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}