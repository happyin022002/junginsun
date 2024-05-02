/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : scenariodefaultmanageBCImpl.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration.ScenarioDefaultManageDBDAO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.clt.syscommon.common.table.EqrDmstPlnVO;
import com.clt.syscommon.common.table.EqrEccLnkVO;
import com.clt.syscommon.common.table.EqrEccMstVO;
import com.clt.syscommon.common.table.EqrEccSftStkVO;
import com.clt.syscommon.common.table.EqrEccTurnTmVO;
import com.clt.syscommon.common.table.EqrHolEffRtoVO;
import com.clt.syscommon.common.table.EqrHolidayVO;
import com.clt.syscommon.common.table.EqrLongTermOffhCondVO;
import com.clt.syscommon.common.table.EqrNewVanLongTermVO;
import com.clt.syscommon.common.table.EqrPortDchgCnstVO;
import com.clt.syscommon.common.table.EqrRepoCnstVO;
import com.clt.syscommon.common.table.EqrShrtTermOffhCondVO;
import com.clt.syscommon.common.table.EqrShrtTermOnhCondVO;
import com.clt.syscommon.common.table.EqrSubleaseVO;
import com.clt.syscommon.common.table.EqrTsTmlVO;
/**
 * -DefaultManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_EQR_0034EventResponse,scenariodefaultmanageBC,scenariodefaultmanageDBDAO
 * @since J2EE 1.6
 */
public class ScenarioDefaultManageBCImpl extends BasicCommandSupport implements ScenarioDefaultManageBC {

	
	// Database Access Object
	private transient ScenarioDefaultManageDBDAO dbDao = null;

	/**
	 * creating ScenariodefaultmanageBCImpl<br>
	 * creating ScenarioDefaultManageDBDAO<br>
	 */
	public ScenarioDefaultManageBCImpl() {
		dbDao = new ScenarioDefaultManageDBDAO();
	}
	
	/**
	 * retrieving for ECC <br>
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
	 * retrieving for TS <br>
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
	 * saving ECC<br>
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
	 * saving ECC <br>
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
	 * retrieving for L/T Off-Hire<br>
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
	 * saving L/T Off-Hire<br>
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
	 * retrieving for ECC Link <br>
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
     * saving Link<br>
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
	 * saving holiday effect detail info.<br>
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
	 * [EES_EQR_0119 : ]<br>
	 * saving S/T Off Hire
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
	 * [EES_EQR_0124 : ]<br>
	 * retrieving Cabotage &  Rule
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
	 * [EES_EQR_0124 : ]<br><br>
	 * saving Cabotage &  Rule
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
			List<EqrRepoCnstVO> deleteVoList2 = new ArrayList<EqrRepoCnstVO>(); // deleteVOList in using to update
			
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
						
						// creating country code
	                	nationCode = eccCode.substring(0,2);
	                	
	                	if(0==ruleSeq){
	                		ruleSeq = dbDao.createCnstRuleId(nationCode, eqrRepoCnstVOs[i].getRepoCnstTpCd());                    		
	                	}else {
	                		ruleSeq++;
	                	}
	                	ruleCodeTemp = "000" + ruleSeq;
	                	ruleCode = nationCode + ruleCodeTemp.substring(ruleCodeTemp.length()-4,ruleCodeTemp.length()) + eqrRepoCnstVOs[i].getRepoCnstTpCd();
	                	eqrRepoCnstVOs[i].setCnstRuleId(ruleCode);
	                	
	                	// creating seq
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
					
					// contain checked Cntr Tpsz to list
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

					// to modify after removing
					deleteVoList2.add(eqrRepoCnstVOs[i]);
					
					// contain checked Cntr Tpsz to list
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
	 * [EES_EQR_0137 : ]<br>
	 * saving Constraint by Lane/POD 
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
	 * saving auto run parameter
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
						insFlag = false;// don't update when eff_st is later than current
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
	 * retrieving for effictive start week in plan year<br>
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
	 * retrieving for default CNTR safety stock<br>
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
	 * saving default CNTR safty stock <br>
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
	 * retrieving for CNTR safey stock exis<br>
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
}
