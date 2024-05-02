/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupManageBCImpl.java
*@FileTitle : Evaluation Group
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.basic;


import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.integration.EvaluationGroupManageDBDAO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdAllListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEGIdListVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpVO;

/**
 * ALPS-MasterManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-MasterManage<br>
 *
 * @author 
 * @see ESD_SPE_0001EventResponse,EvaluationGroupManageBC
 * @since J2EE 1.6
 */
public class EvaluationGroupManageBCImpl extends BasicCommandSupport implements EvaluationGroupManageBC {

	// Database Access Object
	private transient EvaluationGroupManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating EvaluationGroupManageDBDAO class<br>
	 */
	public EvaluationGroupManageBCImpl() {
		dbDao = new EvaluationGroupManageDBDAO();
	}
	/**
	 * Retrieving the list of EGId<br>
	 * 
	 * @param SearchEgidConditionVO searchEgidConditionVO
	 * @return List<SearchEGIdListVO>
	 * @exception EventException
	 */
	public List<SearchEGIdListVO> searchEGIdList(SearchEgidConditionVO searchEgidConditionVO) throws EventException {
		try {
			return dbDao.searchEGIdList(searchEgidConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Retrieving the list of all EGId<br>
	 * 
	 * @return List<SearchEGIdAllListVO>
	 * @exception EventException
	 */
	public List<SearchEGIdAllListVO> searchEGIdAllList() throws EventException {
		try {
			return dbDao.searchEGIdAllList();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Saving the EG data<br>
	 * 
	 * @param SpeEvGrpVO[] speEvGrpVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiEGManage(SpeEvGrpVO[] speEvGrpVOs, SignOnUserAccount account) throws EventException{
		try {
			List<SpeEvGrpVO> insertVoList = new ArrayList<SpeEvGrpVO>();
			List<SpeEvGrpVO> updateVoList = new ArrayList<SpeEvGrpVO>();
			List<SpeEvGrpVO> deleteVoList = new ArrayList<SpeEvGrpVO>();
							
			for ( int i=0; i<speEvGrpVOs .length; i++ ) {
				String[] temp = null;
				String egIdSeq=null;
				boolean checkUnique = false;
				boolean checkLevels = false;
				
				checkLevels = dbDao.confirmLevels(speEvGrpVOs[i].getEgRhqCd(),speEvGrpVOs[i].getEgCtyCd(), speEvGrpVOs[i].getSvcCateCd());
				checkUnique = dbDao.confirmUnique(speEvGrpVOs[i].getEgId(),speEvGrpVOs[i].getEgIdSeq());
				
				if(StringUtils.hasText(speEvGrpVOs[i].getEgPicUsrId()))
					temp = (speEvGrpVOs[i].getEgPicUsrId()).split("/");
				
				if ( speEvGrpVOs[i].getIbflag().equals("I")&& checkUnique && checkLevels){
					egIdSeq = dbDao.getEgIdSeq(speEvGrpVOs[i].getEgId());
					
					speEvGrpVOs[i].setEgIdSeq(egIdSeq);
					speEvGrpVOs[i].setCreUsrId(account.getUsr_id());
					speEvGrpVOs[i].setUpdUsrId(account.getUsr_id());
					
					if(temp != null && temp.length > 0){
						speEvGrpVOs[i].setEgPicUsrId(temp[1]);
					}else{
						speEvGrpVOs[i].setEgPicUsrId("");
					}
					
					insertVoList.add(speEvGrpVOs[i]);
				} else if ( speEvGrpVOs[i].getIbflag().equals("U") && !checkUnique){
					speEvGrpVOs[i].setUpdUsrId(account.getUsr_id());
					if(temp != null && temp.length > 0){
						speEvGrpVOs[i].setEgPicUsrId(temp[1]);
					}else{
						speEvGrpVOs[i].setEgPicUsrId("");
					}
					updateVoList.add(speEvGrpVOs[i]);
				} else if ( speEvGrpVOs[i].getIbflag().equals("D")&& !checkUnique){
					deleteVoList.add(speEvGrpVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpeEvGrp(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpeEvGrp(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpeEvGrp(deleteVoList);
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