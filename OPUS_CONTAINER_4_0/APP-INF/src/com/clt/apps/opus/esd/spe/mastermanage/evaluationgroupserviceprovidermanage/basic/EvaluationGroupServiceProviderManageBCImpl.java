/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EvaluationGroupServiceProviderManageBCImpl.java
*@FileTitle : EG VS S/P
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupmanage.vo.SearchEgidConditionVO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.integration.EvaluationGroupServiceProviderManageDBDAO;
import com.clt.apps.opus.esd.spe.mastermanage.evaluationgroupserviceprovidermanage.vo.SearchEGSPManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpeEvGrpSvcProvMtchVO;

/**
 * ALPS-MasterManage Business Logic Basic Command implementation<br>
 * - Handling the business logic of ALPS-MasterManage<br>
 *
 * @author
 * @see ESD_SPE_0014EventResponse,EvaluationGroupServiceProviderManageBC
 * @since J2EE 1.6
 */
public class EvaluationGroupServiceProviderManageBCImpl extends BasicCommandSupport implements EvaluationGroupServiceProviderManageBC {

	// Database Access Object
	private transient EvaluationGroupServiceProviderManageDBDAO dbDao = null;

	/**
	 * The constructor of this class<br>
	 * Creating EvaluationGroupServiceProviderManageDBDAO class<br>
	 */
	public EvaluationGroupServiceProviderManageBCImpl() {
		dbDao = new EvaluationGroupServiceProviderManageDBDAO();
	}
	
	/**
	 * Retrieving the managing EGSP<br>
	 * 
	 * @param SearchEgidConditionVO searchEgidConditionVO
	 * @return List<SearchEGSPManageVO>
	 * @exception EventException
	 */
	public List<SearchEGSPManageVO> searchEGSPManage(SearchEgidConditionVO searchEgidConditionVO) throws EventException {
		String egId ="";	
		String egRhqCd="";
		String egCtyCd="";
		String svcCateCd="";
	
		
		String egIdDao ="";
		try {
			
			egId = searchEgidConditionVO.getEgId();
			if(!StringUtils.hasText(egId)){
				egRhqCd =searchEgidConditionVO.getEgRhqCd();
				egCtyCd=searchEgidConditionVO.getEgCtyCd();
				svcCateCd=searchEgidConditionVO.getSvcCateCd();
				
				egIdDao=dbDao.getEgId(egRhqCd, egCtyCd, svcCateCd);
				if(StringUtils.hasText(egIdDao)){
				searchEgidConditionVO.setEgId(egIdDao);				
				}
			}
			
			return 	dbDao.searchEGSPManage(searchEgidConditionVO);	
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Getting the EG choicer<br>
	 * 
	 * @param String egId
	 * @return SearchEGSPManageVO
	 * @exception EventException
	 */
	public SearchEGSPManageVO getEgChoicer(String egId) throws EventException {
		
		List<SearchEGSPManageVO> list = null;
		SearchEGSPManageVO rsVo = new SearchEGSPManageVO();
		
		try {
									
			list= dbDao.getEgChoicer(egId);	
			
			String egRhqCd = "";
			String egCtyCd = "";
			String svcCateCd = "";
			for ( int i=0; i<list.size(); i++) {
				if ( i == list.size()-1) {
					egRhqCd = egRhqCd + list.get(i).getEgRhqCd();
					egCtyCd = egCtyCd + list.get(i).getEgCtyCd();
					svcCateCd = svcCateCd + list.get(i).getSvcCateCd();
				} else {					
					egRhqCd = egRhqCd + list.get(i).getEgRhqCd()+"|";
					egCtyCd = egCtyCd + list.get(i).getEgCtyCd()+"|";
					svcCateCd = svcCateCd + list.get(i).getSvcCateCd()+"|";
				}
			}
			rsVo.setEgRhqCd(egRhqCd);
			rsVo.setEgCtyCd(egCtyCd);
			rsVo.setSvcCateCd(svcCateCd);
			return rsVo;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Saving EGSP.
	 * 
	 * @param SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String multiEGSPManage(SpeEvGrpSvcProvMtchVO[] speEvGrpSvcProvMtchVO, SignOnUserAccount account) throws EventException{
		try {
			List<SpeEvGrpSvcProvMtchVO> insertVoList = new ArrayList<SpeEvGrpSvcProvMtchVO>();
			List<SpeEvGrpSvcProvMtchVO> updateVoList = new ArrayList<SpeEvGrpSvcProvMtchVO>();
			List<SpeEvGrpSvcProvMtchVO> deleteVoList = new ArrayList<SpeEvGrpSvcProvMtchVO>();
			
			boolean checkUnique = false;
			boolean checkData = false;
			String egId="";
			String egIdSeq ="";
			String result="OK";
			String vndrSeq ="";
			
			StringBuffer insert = new StringBuffer("");
			
			for ( int i=0; i<speEvGrpSvcProvMtchVO .length; i++ ) {
				
				egId 	  = speEvGrpSvcProvMtchVO[i].getEgId();
				egIdSeq = speEvGrpSvcProvMtchVO[i].getEgIdSeq();
				vndrSeq  = speEvGrpSvcProvMtchVO[i].getVndrSeq();
				
				checkUnique =dbDao.confirmUnique(egId,egIdSeq,vndrSeq);				
				
				if ( speEvGrpSvcProvMtchVO[i].getIbflag().equals("I") && checkUnique){
										
					checkData = dbDao.confrimData(egId,egIdSeq,vndrSeq);
					
					if (checkData){
						speEvGrpSvcProvMtchVO[i].setCreUsrId(account.getUsr_id());
						speEvGrpSvcProvMtchVO[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(speEvGrpSvcProvMtchVO[i]);
					}else{
						insert.append(vndrSeq+",");						
					}
				} else if ( speEvGrpSvcProvMtchVO[i].getIbflag().equals("U") && !checkUnique){
					speEvGrpSvcProvMtchVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(speEvGrpSvcProvMtchVO[i]);
				} else if ( speEvGrpSvcProvMtchVO[i].getIbflag().equals("D") && !checkUnique){
					deleteVoList.add(speEvGrpSvcProvMtchVO[i]);
				}
			} 

			if(StringUtils.hasText(insert.toString())){
				String message = "Service Category of do not match.:s/p id=" +insert.toString();				
				result = new ErrorHandler("SPE00001",new String[]{message}).getUserMessage();
			}
						
			if ( insertVoList.size() > 0 ) {
				dbDao.addSpeEvGrpSvcProvMtch(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifySpeEvGrpSvcProvMtch(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeSpeEvGrpSvcProvMtch(deleteVoList);
			}
		
			return result;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}