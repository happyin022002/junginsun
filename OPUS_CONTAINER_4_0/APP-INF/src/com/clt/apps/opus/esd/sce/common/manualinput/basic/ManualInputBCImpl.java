/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : CustomsCommonMgtBCImpl.java
*@FileTitle : Customs Error Code
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.common.manualinput.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.common.manualinput.event.EsdSce3306Event;
import com.clt.apps.opus.esd.sce.common.manualinput.integration.ManualInputDBDAO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActivityGroupVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.ActualActivityMappingVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCntrStsMsgMvmtMapgVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceCopCntrRepoRuleVO;
import com.clt.apps.opus.esd.sce.common.manualinput.vo.SceRailSplcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmRegionVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS_CNTR-SetupManagement Business Logic Basic Command implementation<br>
 * - Handling the business logic of OPUS_CNTR-SetupManagement<br>
 *
 * @author YoungHeon Lee
 * @see ManualInputBC,ManualInputBCImpl, each DAO classes
 * @since J2EE 1.6
 */
public class ManualInputBCImpl extends BasicCommandSupport implements ManualInputBC {

	// Database Access Object
	private transient ManualInputDBDAO dbDao = null;

	/**
	 * ManualInputBCImpl object creation <br>
	 * ManualInputDBDAO creation.<br>
	 */
	public ManualInputBCImpl() {
		dbDao = new ManualInputDBDAO();
	}

	
	/**
	 * searchActualActivityMappingList.<br>
	 * @param ActualActivityMappingVO actualActivityMappingVO
	 * @return List<ActualActivityMappingVO>
	 * @throws EventException
	 */
	public List<ActualActivityMappingVO> searchActualActivityMappingList(ActualActivityMappingVO actualActivityMappingVO) throws EventException {
		try {
			return dbDao.searchActualActivityMappingList(actualActivityMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * manageActualActivityMapping.<br>
	 * @param actualActivityMappingVOs ActualActivityMappingVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActualActivityMapping(ActualActivityMappingVO[] actualActivityMappingVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ActualActivityMappingVO> insertVoList = new ArrayList<ActualActivityMappingVO>();
			List<ActualActivityMappingVO> updateVoList = new ArrayList<ActualActivityMappingVO>();
			List<ActualActivityMappingVO> deleteVoList = new ArrayList<ActualActivityMappingVO>();
			
			for(int i=0; i<actualActivityMappingVOs.length; i++){
				if(actualActivityMappingVOs[i].getIbflag().equals("I")){
					actualActivityMappingVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(actualActivityMappingVOs[i]);
				}else if(actualActivityMappingVOs[i].getIbflag().equals("U")){
					actualActivityMappingVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(actualActivityMappingVOs[i]);
				}else if(actualActivityMappingVOs[i].getIbflag().equals("D")){
					actualActivityMappingVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(actualActivityMappingVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addActualActivityMapping(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyActualActivityMapping(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeActualActivityMapping(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checkActualCode.<br>
	 * @param String actCd
	 * @return String
	 * @throws EventException
	 */
	public String checkActualCode(String actCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkActualCode(actCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * checkActualActivityMappingCode.<br>
	 * @param actCd String
	 * @param actStsMapgCd String
	 * @param actRcvTpCd String
	 * @return String
	 * @throws EventException
	 */
	public String checkActualActivityMappingCode(String actCd, String actStsMapgCd, String actRcvTpCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkActualActivityMappingCode(actCd, actStsMapgCd, actRcvTpCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	
	/**
	 * searchActivityGroupList.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return List<ActivityMappingVO>
	 * @throws EventException
	 */
	public List<ActivityGroupVO> searchActivityGroupList(ActivityGroupVO activityGroupVO) throws EventException {
		try {
			return dbDao.searchActivityGroupList(activityGroupVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checkActivityGroupCode.<br>
	 * @param ActivityGroupVO activityGroupVO
	 * @return String
	 * @throws EventException
	 */
	public String checkActivityGroupCode(ActivityGroupVO activityGroupVO) throws EventException {
		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkActivityGroupCode(activityGroupVO);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	}
	
	/**
	 * manageActivityGroup.<br>
	 * @param activityGroupVOs ActivityGroupVO[] 
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActivityGroup(ActivityGroupVO[] activityGroupVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ActivityGroupVO> insertVoList = new ArrayList<ActivityGroupVO>();
			List<ActivityGroupVO> updateVoList = new ArrayList<ActivityGroupVO>();
			List<ActivityGroupVO> deleteVoList = new ArrayList<ActivityGroupVO>();
			
			for(int i=0; i<activityGroupVOs.length; i++){
				if(activityGroupVOs[i].getIbflag().equals("I")){
					activityGroupVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(activityGroupVOs[i]);
				}else if(activityGroupVOs[i].getIbflag().equals("U")){
					activityGroupVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(activityGroupVOs[i]);
				}else if(activityGroupVOs[i].getIbflag().equals("D")){
					activityGroupVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(activityGroupVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addActivityGroup(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyActivityGroup(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeActivityGroup(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * searchActivityGroupMappingList.<br>
	 * @param ActivityGroupMappingVO activityGroupMappingVO
	 * @return List<ActivityGroupMappingVO>
	 * @throws EventException
	 */
	public List<ActivityGroupMappingVO> searchActivityGroupMappingList(ActivityGroupMappingVO activityGroupMappingVO) throws EventException {
		try {
			return dbDao.searchActivityGroupMappingList(activityGroupMappingVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * checkCOPDetailGroupCode.<br>
	 * @param String copDtlGrpCd
	 * @return String
	 * @throws EventException
	 */
	public String checkCOPDetailGroupCode(String copDtlGrpCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkCOPDetailGroupCode(copDtlGrpCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}	

	/**
	 * checkActivityGroupMappingCode.<br>
	 * @param actCd String
	 * @param copDtlGrpCd String
	 * @return String
	 * @throws EventException
	 */
	public String checkActivityGroupMappingCode(String actCd, String copDtlGrpCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.checkActivityGroupMappingCode(actCd, copDtlGrpCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}	

	/**
	 * manageActivityGroupMapping.<br>
	 * @param activityGroupMappingVOs ActivityGroupMappingVO[]
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
	public void manageActivityGroupMapping(ActivityGroupMappingVO[] activityGroupMappingVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ActivityGroupMappingVO> insertVoList = new ArrayList<ActivityGroupMappingVO>();
			List<ActivityGroupMappingVO> updateVoList = new ArrayList<ActivityGroupMappingVO>();
			List<ActivityGroupMappingVO> deleteVoList = new ArrayList<ActivityGroupMappingVO>();
			
			for(int i=0; i<activityGroupMappingVOs.length; i++){
				if(activityGroupMappingVOs[i].getIbflag().equals("I")){
					activityGroupMappingVOs[i].setUserId(account.getUsr_id());
					insertVoList.add(activityGroupMappingVOs[i]);
				}else if(activityGroupMappingVOs[i].getIbflag().equals("U")){
					activityGroupMappingVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(activityGroupMappingVOs[i]);
				}else if(activityGroupMappingVOs[i].getIbflag().equals("D")){
					activityGroupMappingVOs[i].setUserId(account.getUsr_id());
					deleteVoList.add(activityGroupMappingVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addActivityGroupMapping(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifyActivityGroupMapping(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeActivityGroupMapping(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
		/**
	 * searchSceCntrStsMsgMvmtMappingList.<br>
	 * @param SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO
	 * @return List<SceCntrStsMsgMvmtMapgVO>
	 * @throws EventException
	 */
    public List<SceCntrStsMsgMvmtMapgVO> searchSceCntrStsMsgMvmtMappingList(SceCntrStsMsgMvmtMapgVO sceCntrStsMsgMvmtMapgVO) throws EventException {
		try {
			return dbDao.searchSceCntrStsMsgMvmtMappingList(sceCntrStsMsgMvmtMapgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * manageSceCntrStsMsgMvmt.<br>
	 * @param sceCntrStsMsgMvmtMapgVO SceCntrStsMsgMvmtMapgVO[] 
	 * @param account SignOnUserAccount
	 * @throws EventException
	 */
    public void manageSceCntrStsMsgMvmt(SceCntrStsMsgMvmtMapgVO[] sceCntrStsMsgMvmtMapgVO,SignOnUserAccount account) throws EventException {
		if (sceCntrStsMsgMvmtMapgVO == null)
			return;

		try {
			List<SceCntrStsMsgMvmtMapgVO> insertVoList = new ArrayList<SceCntrStsMsgMvmtMapgVO>();
			List<SceCntrStsMsgMvmtMapgVO> updateVoList = new ArrayList<SceCntrStsMsgMvmtMapgVO>();
			List<SceCntrStsMsgMvmtMapgVO> deleteVoList = new ArrayList<SceCntrStsMsgMvmtMapgVO>();

			for (int i = 0; i < sceCntrStsMsgMvmtMapgVO.length; i++) {
				if (sceCntrStsMsgMvmtMapgVO[i].getIbflag().equals("I")) {
					sceCntrStsMsgMvmtMapgVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(sceCntrStsMsgMvmtMapgVO[i]);
				} else if (sceCntrStsMsgMvmtMapgVO[i].getIbflag().equals("U")) {
					sceCntrStsMsgMvmtMapgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(sceCntrStsMsgMvmtMapgVO[i]);
				} else if (sceCntrStsMsgMvmtMapgVO[i].getIbflag().equals("D")) {
					deleteVoList.add(sceCntrStsMsgMvmtMapgVO[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addmultiSceCntrStsMsgMvmtS(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifymultiSceCntrStsMsgMvmtS(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removemultiSceCntrStsMsgMvmtS(deleteVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * searchSceCopCntrRepoRuleList
	 * @param sceCopCntrRepoRuleVO
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<SceCopCntrRepoRuleVO> searchSceCopCntrRepoRuleList( SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO) throws EventException {
		try {
			return dbDao.searchSceCopCntrRepoRuleList(sceCopCntrRepoRuleVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * manageSceCopCntrRepoRule
	 * @param sceCopCntrRepoRuleVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageSceCopCntrRepoRule(SceCopCntrRepoRuleVO[] sceCopCntrRepoRuleVOs, SignOnUserAccount account) throws EventException {
		if(sceCopCntrRepoRuleVOs == null) return;
		
		try {
			List<SceCopCntrRepoRuleVO> insertVoList = new ArrayList<SceCopCntrRepoRuleVO>();
			List<SceCopCntrRepoRuleVO> updateVoList = new ArrayList<SceCopCntrRepoRuleVO>();
			List<SceCopCntrRepoRuleVO> deleteVoList = new ArrayList<SceCopCntrRepoRuleVO>();
			
			for(int i=0; i<sceCopCntrRepoRuleVOs.length; i++){
				if(sceCopCntrRepoRuleVOs[i].getIbflag().equals("I")){
					sceCopCntrRepoRuleVOs[i].setUpdUsrId(account.getUsr_id());
					
					// validation
					if(!checkValidation4CopCntrRepoRule(sceCopCntrRepoRuleVOs[i])) {
						throw new DAOException(new ErrorHandler("COM130402").getMessage());
					}
					
					insertVoList.add(sceCopCntrRepoRuleVOs[i]);
				}else if(sceCopCntrRepoRuleVOs[i].getIbflag().equals("U")){
					sceCopCntrRepoRuleVOs[i].setUpdUsrId(account.getUsr_id());
					
					// validation
					if(!checkValidation4CopCntrRepoRule(sceCopCntrRepoRuleVOs[i])) {
						throw new DAOException(new ErrorHandler("COM130402").getMessage());
					}
					
					updateVoList.add(sceCopCntrRepoRuleVOs[i]);
				}else if(sceCopCntrRepoRuleVOs[i].getIbflag().equals("D")){
					sceCopCntrRepoRuleVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(sceCopCntrRepoRuleVOs[i]);
				}
			}
			if(insertVoList.size() > 0){
				dbDao.addSceCopCntrRepoRule(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifySceCopCntrRepoRule(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeSceCopCntrRepoRule(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * searchSceRailSplcList
	 * @param event
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<SceRailSplcVO> searchSceRailSplcList(EsdSce3306Event event) throws EventException {
		try {
			return dbDao.searchSceRailSplcList(event);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * manageSceRailSplc
	 * @param sceRailSplcVOs
	 * @param account
	 * @throws EventException
	 */
	@Override
	public void manageSceRailSplc(SceRailSplcVO[] sceRailSplcVOs, SignOnUserAccount account) throws EventException {
		if(sceRailSplcVOs == null) return;
		
		try {
			List<SceRailSplcVO> insertVoList = new ArrayList<SceRailSplcVO>();
			List<SceRailSplcVO> updateVoList = new ArrayList<SceRailSplcVO>();
			List<SceRailSplcVO> deleteVoList = new ArrayList<SceRailSplcVO>();
			
			for(int i=0; i<sceRailSplcVOs.length; i++){
				if(sceRailSplcVOs[i].getIbflag().equals("I")){
					sceRailSplcVOs[i].setUpdUsrId(account.getUsr_id());
					
					// validation
					if(!checkValidation4RailSplc(sceRailSplcVOs[i])) {
						throw new DAOException(new ErrorHandler("COM130402").getMessage());
					}
					
					insertVoList.add(sceRailSplcVOs[i]);
				}else if(sceRailSplcVOs[i].getIbflag().equals("U")){
					sceRailSplcVOs[i].setUpdUsrId(account.getUsr_id());
					
					// validation
					if(!checkValidation4RailSplc(sceRailSplcVOs[i])) {
						//String aa = new ErrorHandler("COM130402").getMessage();
						throw new DAOException(new ErrorHandler("COM130402").getMessage());
					}
					
					updateVoList.add(sceRailSplcVOs[i]);
				}else if(sceRailSplcVOs[i].getIbflag().equals("D")){
					sceRailSplcVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(sceRailSplcVOs[i]);
				}
			}
			
			if(insertVoList.size() > 0){
				dbDao.addSceRailSplc(insertVoList);
			}
			if(updateVoList.size() > 0){
				dbDao.modifySceRailSplc(updateVoList);
			}
			if(deleteVoList.size() > 0){
				dbDao.removeSceRailSplc(deleteVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * searchMdmCntrTpszCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmCntrTpSzVO> searchMdmCntrTpszCd(HashMap<String, String> map) throws EventException {
		try {
			return dbDao.searchMdmCntrTpszCd(map);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * searchMdmCountryCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmCountryVO> searchMdmCountryCd(HashMap<String, String> map) throws EventException {
		try {
			return dbDao.searchMdmCountryCd(map);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * searchMdmLocationCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmLocationVO> searchMdmLocationCd(HashMap<String, String> map) throws EventException {
		try {
			return dbDao.searchMdmLocationCd(map);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * searchMdmRegionCd
	 * @param map
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmRegionVO> searchMdmRegionCd(HashMap<String, String> map) throws EventException {
		try {
			return dbDao.searchMdmRegionCd(map);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * searchMdmYard
	 * @param map
	 * @return
	 * @throws EventException
	 */
	@Override
	public List<MdmYardVO> searchMdmYard(HashMap<String, String> map) throws EventException {
		try {
			return dbDao.searchMdmYard(map);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	private boolean checkValidation4CopCntrRepoRule(SceCopCntrRepoRuleVO sceCopCntrRepoRuleVO) throws EventException, DAOException {
		HashMap<String, String> map = new HashMap<String, String>();
		if(sceCopCntrRepoRuleVO.getCntrTpszCd() != null && !"".equals(sceCopCntrRepoRuleVO.getCntrTpszCd())) {
			map.put("frm_cntr_tpsz_cd", sceCopCntrRepoRuleVO.getCntrTpszCd());
			List<MdmCntrTpSzVO> resultList = searchMdmCntrTpszCd(map);
			
			if(resultList == null || resultList.size() == 0) return false;
		}
		
		if(sceCopCntrRepoRuleVO.getProvCntrTpszCd() != null && !"".equals(sceCopCntrRepoRuleVO.getProvCntrTpszCd())) {
			map.put("frm_cntr_tpsz_cd", sceCopCntrRepoRuleVO.getProvCntrTpszCd());
			List<MdmCntrTpSzVO> resultList = searchMdmCntrTpszCd(map);
			
			if(resultList == null || resultList.size() == 0) return false;
		}
		
		if(sceCopCntrRepoRuleVO.getCntCd() != null && !"".equals(sceCopCntrRepoRuleVO.getCntCd())) {
			map.put("frm_cnt_cd", sceCopCntrRepoRuleVO.getCntCd());
			List<MdmCountryVO> resultList = searchMdmCountryCd(map);
			
			if(resultList == null || resultList.size() == 0) {
				throw new DAOException(new ErrorHandler("COM130402").getMessage());
			}
		}
		
		if(sceCopCntrRepoRuleVO.getLocCd() != null && !"".equals(sceCopCntrRepoRuleVO.getLocCd())) {
			map.put("frm_loc_cd", sceCopCntrRepoRuleVO.getLocCd());
			List<MdmLocationVO> resultList = searchMdmLocationCd(map);
			
			if(resultList == null || resultList.size() == 0) return false;
		}
		
		if(sceCopCntrRepoRuleVO.getRgnCd() != null && !"".equals(sceCopCntrRepoRuleVO.getRgnCd())) {
			map.put("frm_rgn_cd", sceCopCntrRepoRuleVO.getRgnCd());
			List<MdmRegionVO> resultList = searchMdmRegionCd(map);
			
			if(resultList == null || resultList.size() == 0) return false;
		}
		
		return true;
	}
	
	private boolean checkValidation4RailSplc(SceRailSplcVO sceRailSplcVO) throws EventException {
		HashMap<String, String> map = new HashMap<String, String>();
		if(sceRailSplcVO.getYdCd() != null && !"".equals(sceRailSplcVO.getYdCd())) {
			map.put("frm_yd_cd", sceRailSplcVO.getYdCd());
			List<MdmYardVO> resultList = searchMdmYard(map);
			
			if(resultList == null || resultList.size() == 0) {
				return false;
			}
		}
		
		if(sceRailSplcVO.getLocCd() != null && !"".equals(sceRailSplcVO.getLocCd())) {
			map.put("frm_loc_cd", sceRailSplcVO.getLocCd());
			List<MdmLocationVO> resultList = searchMdmLocationCd(map);
			
			if(resultList == null || resultList.size() == 0) {
				return false;
			}
		}
		
		return true;
	}
}