/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupKpiTargetManageBCImpl.java
*@FileTitle : KPI Target
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.integration.EvaluationGroupKpiTargetManageDBDAO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetConditionVO;
import com.clt.apps.opus.esd.spe.evaluationgrouptargetmanage.evaluationgroupkpitargetmanage.vo.SearchEGKpiTargetManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpKpiTgtRtoVO;

/**
 * ALPS-EvaluationGroupTargetManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-EvaluationGroupTargetManage<br>
 *
 * @author 
 * @see ESD_SPE_0008EventResponse,EvaluationGroupKpiTargetManageBC
 * @since J2EE 1.6
 */
public class EvaluationGroupKpiTargetManageBCImpl extends BasicCommandSupport implements EvaluationGroupKpiTargetManageBC {

	// Database Access Object
	private transient EvaluationGroupKpiTargetManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating EvaluationGroupKpiTargetManageDBDAO<br>
	 */
	public EvaluationGroupKpiTargetManageBCImpl() {
		dbDao = new EvaluationGroupKpiTargetManageDBDAO();
	}
	/**
	 * Retrieving EGKpi target.
	 * 
	 * @param SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO
	 * @return List<SearchEGKpiTargetManageVO>
	 * @exception EventException
	 */
	public List<SearchEGKpiTargetManageVO> searchEGKpiTargetManage(SearchEGKpiTargetConditionVO searchEGKpiTargetConditionVO) throws EventException {
		String egId ="";	
		String egRhqCd="";
		String egCtyCd="";
		String svcCateCd="";
	
		
		String egIdDao ="";
		try {
			
			egId = searchEGKpiTargetConditionVO.getEgId();
			if(!StringUtils.hasText(egId)){
				egRhqCd =searchEGKpiTargetConditionVO.getEgRhqCd();
				egCtyCd=searchEGKpiTargetConditionVO.getEgCtyCd();
				svcCateCd=searchEGKpiTargetConditionVO.getSvcCateCd();
				
				egIdDao=dbDao.getEgId(egRhqCd, egCtyCd, svcCateCd);
				if(StringUtils.hasText(egIdDao)){
					searchEGKpiTargetConditionVO.setEgId(egIdDao);				
				}
			}
			return dbDao.searchEGKpiTargetManage(searchEGKpiTargetConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Saving the data of EGKpiTarget
	 * 
	 * @param SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiEGKpiTargetManage(SpeEvGrpKpiTgtRtoVO[] speEvGrpKpiTgtRtoVO, SignOnUserAccount account) throws EventException{
		
		boolean result = false;
		
		try {
			List<SpeEvGrpKpiTgtRtoVO> insertVoList = new ArrayList<SpeEvGrpKpiTgtRtoVO>();
			List<SpeEvGrpKpiTgtRtoVO> updateVoList = new ArrayList<SpeEvGrpKpiTgtRtoVO>();
			List<SpeEvGrpKpiTgtRtoVO> deleteVoList = new ArrayList<SpeEvGrpKpiTgtRtoVO>();
			for ( int i=0; i<speEvGrpKpiTgtRtoVO .length; i++ ) {
				
				result = dbDao.confirmUnique(speEvGrpKpiTgtRtoVO[i].getEgId(),speEvGrpKpiTgtRtoVO[i].getSpKpiCd(),speEvGrpKpiTgtRtoVO[i].getEvYr());
				if ( speEvGrpKpiTgtRtoVO[i].getIbflag().equals("I")){
					speEvGrpKpiTgtRtoVO[i].setCreUsrId(account.getUsr_id());
					speEvGrpKpiTgtRtoVO[i].setUpdUsrId(account.getUsr_id());
					
					if (result){
						insertVoList.add(speEvGrpKpiTgtRtoVO[i]);
					}else{
						updateVoList.add(speEvGrpKpiTgtRtoVO[i]);
					}	
				} else if ( speEvGrpKpiTgtRtoVO[i].getIbflag().equals("U")){
					speEvGrpKpiTgtRtoVO[i].setCreUsrId(account.getUsr_id());
					speEvGrpKpiTgtRtoVO[i].setUpdUsrId(account.getUsr_id());
					
					if (result){
						insertVoList.add(speEvGrpKpiTgtRtoVO[i]);
					}else{
						updateVoList.add(speEvGrpKpiTgtRtoVO[i]);
					}		
				} else if ( speEvGrpKpiTgtRtoVO[i].getIbflag().equals("D")){
					deleteVoList.add(speEvGrpKpiTgtRtoVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmultiEGKpiTargetManageS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiEGKpiTargetManageS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemultiEGKpiTargetManageS(deleteVoList);
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