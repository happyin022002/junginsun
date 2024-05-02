/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtBCImpl.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.integration.CEDEXCodeMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByDmgVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByLocVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByRprVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCedexOtrCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqCmpoCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqLocCdVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.CustomTariffCodeFindDataVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
         
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author park myoung sin 
 * @see UI_MNR_0003EventResponse,CEDEXCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4   
 */        
    
public class CEDEXCodeMgtBCImpl extends BasicCommandSupport implements CEDEXCodeMgtBC {

	// Database Access Object
	private transient CEDEXCodeMgtDBDAO dbDao = null; 

	/** 
	 * CEDEXCodeMgtBCImpl 객체 생성<br>
	 * CEDEXCodeMgtDBDAO를 생성한다.<br>
	 */    
	public CEDEXCodeMgtBCImpl() {  
		dbDao = new CEDEXCodeMgtDBDAO();
	}
	
	/**
	 * [EES_MNR_0225]Division Code Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @return DivisionCodeGRPVO
	 * @exception EventException
	 */
	public DivisionCodeGRPVO searchDivisionCodeListBasic(DivisionCodeGRPVO divisionCodeGRPVO,SignOnUserAccount account)throws EventException {
		try {
			List<CustomMnrCdRltVO> list = null; 
			
			list = dbDao.searchDivisionCodeListData(divisionCodeGRPVO);
			divisionCodeGRPVO.setListCustomMnrCdRltVOS(list);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0225] searchDivisionCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0225] searchDivisionCodeListBasic"}).getMessage(),ex);
		}
		return divisionCodeGRPVO;
	}
		 
	/**
	 * [EES_MNR_0225]Division Code Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */  
	public void manageDivisionCodeBasic(DivisionCodeGRPVO divisionCodeGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			List<CustomMnrCdRltVO> insertVoList = new ArrayList<CustomMnrCdRltVO>();
			List<CustomMnrCdRltVO> deleteVoList = new ArrayList<CustomMnrCdRltVO>();
			   	
			CustomMnrCdRltVO[] customMnrCdRltVOS = divisionCodeGRPVO.getArrCustomMnrCdRltVOS();
			for ( int i=0; i< customMnrCdRltVOS.length; i++ ) {      
				if ( customMnrCdRltVOS[i].getIbflag().equals("I") || customMnrCdRltVOS[i].getIbflag().equals("U")){  
					customMnrCdRltVOS[i].setCreUsrId(account.getUsr_id());
					customMnrCdRltVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(customMnrCdRltVOS[i]);  
				} else if ( customMnrCdRltVOS[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrCdRltVOS[i]);                 
				}         	               
			}             
		       		
			if ( insertVoList.size() > 0 ) {  
				for(int i = 0;i < insertVoList.size();i++){
					CustomMnrCdRltVO customMnrCdRltVO = (CustomMnrCdRltVO)insertVoList.get(i);
					dbDao.removeDivisionCodeData(customMnrCdRltVO);
					dbDao.addDivisionCodeData(customMnrCdRltVO); 
				}      
			}     
			  
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAllDivisionCodeData(deleteVoList);
			}     
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0225] manageDivisionCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0225] manageDivisionCodeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0142]Pop Up_Tariff Code Finding의 정보를 조회 합니다. <br>
	 *
	 * @param RepairCodeFindListGRPVO repairCodeFindListGRPVO
	 * @return RepairCodeFindListGRPVO
	 * @exception EventException
	 */
	public RepairCodeFindListGRPVO searchRepairCodeFindListBasic(RepairCodeFindListGRPVO repairCodeFindListGRPVO)throws EventException {
		try {
			
			List<CustomTariffCodeFindDataVO> list = null;
			
			list = dbDao.searchTariffCodeFindListData(repairCodeFindListGRPVO);
			repairCodeFindListGRPVO.setCustomMnrEqCmpoCdVOS(list);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0142] searchRepairCodeFindListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0142] searchRepairCodeFindListBasic"}).getMessage(),ex);
		}
		return repairCodeFindListGRPVO;
	}
	
	/**
	 * [EES_MNR_0193]Location Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @return DamageLocationCodeListGRPVO
	 * @exception EventException
	 */
	public DamageLocationCodeListGRPVO searchDamageLocationCodeListBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO) throws EventException {
		try { 
				List<List<CustomMnrEqLocCdVO>> listCustomMnrEqLocCdVOS = new ArrayList<List<CustomMnrEqLocCdVO>>(); 
				damageLocationCodeListGRPVO.getDamageLocationCodeListINVO().setEqLocCdLvl("1");
				List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS0 = dbDao.searchDamageLocationCodeListListData(damageLocationCodeListGRPVO.getDamageLocationCodeListINVO());
				damageLocationCodeListGRPVO.getDamageLocationCodeListINVO().setEqLocCdLvl("2");   
				List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS1 = dbDao.searchDamageLocationCodeListListData(damageLocationCodeListGRPVO.getDamageLocationCodeListINVO());
				damageLocationCodeListGRPVO.getDamageLocationCodeListINVO().setEqLocCdLvl("3");
				List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS2 = dbDao.searchDamageLocationCodeListListData(damageLocationCodeListGRPVO.getDamageLocationCodeListINVO());
				damageLocationCodeListGRPVO.getDamageLocationCodeListINVO().setEqLocCdLvl("4");    
				List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS3 = dbDao.searchDamageLocationCodeListListData(damageLocationCodeListGRPVO.getDamageLocationCodeListINVO());
			                                      
				listCustomMnrEqLocCdVOS.add(customMnrEqLocCdVOS0);      
				listCustomMnrEqLocCdVOS.add(customMnrEqLocCdVOS1);  
				listCustomMnrEqLocCdVOS.add(customMnrEqLocCdVOS2);   
				listCustomMnrEqLocCdVOS.add(customMnrEqLocCdVOS3);           
				                                  
				damageLocationCodeListGRPVO.setListCustomMnrEqLocCdVOS(listCustomMnrEqLocCdVOS);   
			return damageLocationCodeListGRPVO;       
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0193] searchDamageLocationCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0193] searchDamageLocationCodeListBasic"}).getMessage(),ex);
		} 		
	} 
	
	/**
	 * [EES_MNR_0003]Damage Location의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DamageLocationCodeListGRPVO damageLocationCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */   
	public void manageDamageLocationCodeBasic(DamageLocationCodeListGRPVO damageLocationCodeListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			List<CustomMnrEqLocCdVO> insertVoList = new ArrayList<CustomMnrEqLocCdVO>();
			List<CustomMnrEqLocCdVO> updateVoList = new ArrayList<CustomMnrEqLocCdVO>();
			List<CustomMnrEqLocCdVO> deleteVoList = new ArrayList<CustomMnrEqLocCdVO>();
			 	
			CustomMnrEqLocCdVO[] customMnrEqLocCdVO = damageLocationCodeListGRPVO.getArrCustomMnrEqLocCdVOS();
			for ( int i=0; i< customMnrEqLocCdVO.length; i++ ) {      
				if ( customMnrEqLocCdVO[i].getIbflag().equals("I")){  
					customMnrEqLocCdVO[i].setCreUsrId(account.getUsr_id());
					customMnrEqLocCdVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(customMnrEqLocCdVO[i]);  
				} else if ( customMnrEqLocCdVO[i].getIbflag().equals("U")){
					customMnrEqLocCdVO[i].setCreUsrId(account.getUsr_id());
					customMnrEqLocCdVO[i].setUpdUsrId(account.getUsr_id());
					customMnrEqLocCdVO[i].setUpdDt(account.getUpd_dt());     
					updateVoList.add(customMnrEqLocCdVO[i]);  
				} else if ( customMnrEqLocCdVO[i].getIbflag().equals("D")){
					deleteVoList.add(customMnrEqLocCdVO[i]);               
				}	              
			}             
			    
			if ( insertVoList.size() > 0 ) {
				dbDao.addDamageLocationCodeData(insertVoList);
			} 
			
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyDamageLocationCodeData(updateVoList);
			}   
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDamageLocationCodeData(deleteVoList);
			}  
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0003] manageDamageLocationCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0003] manageDamageLocationCodeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0002]EQ Component의 정보를 조회 합니다. <br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @return ComponentCodeListGRPVO
	 * @exception EventException
	 */
	public ComponentCodeListGRPVO searchComponentCodeListBasic(ComponentCodeListGRPVO componentCodeListGRPVO) throws EventException {
		try { 
			//조건부  콤보조회
			if (componentCodeListGRPVO.getComponentCodeListINVO().getFType().equals("combo")) {
				componentCodeListGRPVO.getComponentCodeListINVO().setEqCmpoGrpTpCd("1");
				componentCodeListGRPVO.getComponentCodeListINVO().setKeyValue("All");
				List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS = dbDao.searchComponentCodeListData(componentCodeListGRPVO.getComponentCodeListINVO());
				componentCodeListGRPVO.setCustomMnrEqCmpoCdVOS(customMnrEqCmpoCdVOS);
				
			//조회부 그리드조회
			} else {
				//다건조회
				List<List<CustomMnrEqCmpoCdVO>> listCustomMnrEqLocCdVOS = new ArrayList<List<CustomMnrEqCmpoCdVO>>();
				
				componentCodeListGRPVO.getComponentCodeListINVO().setEqCmpoGrpTpCd("1");
				List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS0 = dbDao.searchComponentCodeListData(componentCodeListGRPVO.getComponentCodeListINVO());
				componentCodeListGRPVO.getComponentCodeListINVO().setEqCmpoGrpTpCd("2");
				List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS1 = dbDao.searchComponentCodeListData(componentCodeListGRPVO.getComponentCodeListINVO());
				componentCodeListGRPVO.getComponentCodeListINVO().setEqCmpoGrpTpCd("3");
				List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS2 = dbDao.searchComponentCodeListData(componentCodeListGRPVO.getComponentCodeListINVO());
			                                        
				listCustomMnrEqLocCdVOS.add(customMnrEqCmpoCdVOS0);      
				listCustomMnrEqLocCdVOS.add(customMnrEqCmpoCdVOS1); 
				listCustomMnrEqLocCdVOS.add(customMnrEqCmpoCdVOS2);    
				                      
				componentCodeListGRPVO.setListCustomMnrEqCmpoCdVOS(listCustomMnrEqLocCdVOS);   
			}
			return componentCodeListGRPVO;
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0002] searchComponentCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0002] searchComponentCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0002]EQ Component의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param ComponentCodeListGRPVO componentCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageComponentCodeBasic(ComponentCodeListGRPVO componentCodeListGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrEqCmpoCdVO> insertVoList = new ArrayList<CustomMnrEqCmpoCdVO>();
			List<CustomMnrEqCmpoCdVO> updateVoList = new ArrayList<CustomMnrEqCmpoCdVO>();
			List<CustomMnrEqCmpoCdVO> deleteVoList = new ArrayList<CustomMnrEqCmpoCdVO>();

			for ( int i=0; i<componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs() .length; i++ ) {
				if ( componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].getIbflag().equals("I")){
					componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].setCreUsrId(account.getUsr_id());
					componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i]);
				} else if ( componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].getIbflag().equals("U")){
					componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i]);
				} else if ( componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i].getIbflag().equals("D")){
					deleteVoList.add(componentCodeListGRPVO.getCustomMnrEqCmpoCdVOs()[i]);
				} 
			}  
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addComponentCodeData(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyComponentCodeData(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeComponentCodeData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0002] manageComponentCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0002] manageComponentCodeBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @return CedexOtherCodeListGRPVO
	 * @exception EventException
	 */
	public CedexOtherCodeListGRPVO searchCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO) throws EventException {
		try { 
			//cedexOtherCodeListGRPVO.getCedexOtherCodeListINVO().setKeyValue("All");
			List<CustomMnrCedexOtrCdVO> customMnrEqCmpoCdVOS = dbDao.searchCedexOtherCodeListData(cedexOtherCodeListGRPVO.getCedexOtherCodeListINVO());
			cedexOtherCodeListGRPVO.setCustomMnrCedexOtrCdVOS(customMnrEqCmpoCdVOS);
			
			return cedexOtherCodeListGRPVO;    
		} catch (DAOException ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0004] searchCedexOtherCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {   
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0004] searchCedexOtherCodeListBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCedexOtherCodeListBasic(CedexOtherCodeListGRPVO cedexOtherCodeListGRPVO, SignOnUserAccount account) throws EventException{
		try { 
			List<CustomMnrCedexOtrCdVO> insertVoList = new ArrayList<CustomMnrCedexOtrCdVO>();
			List<CustomMnrCedexOtrCdVO> updateVoList = new ArrayList<CustomMnrCedexOtrCdVO>();
			List<CustomMnrCedexOtrCdVO> deleteVoList = new ArrayList<CustomMnrCedexOtrCdVO>();
			 
			for ( int i=0; i<cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS().length; i++ ) {
				if ( cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].getIbflag().equals("I")){
					cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].setCreUsrId(account.getUsr_id());
					cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i]);
				} else if ( cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].getIbflag().equals("U")){
					cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].setUpdUsrId(account.getUsr_id());
					cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i]);
				} else if ( cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i].getIbflag().equals("D")){
					deleteVoList.add(cedexOtherCodeListGRPVO.getArrCustomMnrCedexOtrCdVOS()[i]);
				}  
			}  
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCedexOtherCodeListData(insertVoList);
			}  
			      
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCedexOtherCodeListData(updateVoList);
			} 
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCedexOtherCodeListData(deleteVoList);
			}   
		} catch (DAOException ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0004] manageCedexOtherCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0004] manageCedexOtherCodeListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @return CodeRelationGRPVO
	 * @exception EventException
	 */
	public CodeRelationGRPVO searchCodeRelationListBasic(CodeRelationGRPVO codeRelationGRPVO) throws EventException {
		try { 
			//다건조회
			List<CustomMnrCdRltByLocVO> listCustomMnrCdRltByLocVO = dbDao.searchCodeRelationByLocationData(codeRelationGRPVO.getCodeRelationINVO());
			List<CustomMnrCdRltByDmgVO> listCustomMnrCdRltByDmgVO = dbDao.searchCodeRelationByDamageData(codeRelationGRPVO.getCodeRelationINVO());
			List<CustomMnrCdRltByRprVO> listCustomMnrCdRltByRprVO = dbDao.searchCodeRelationByRepairData(codeRelationGRPVO.getCodeRelationINVO());
			
			codeRelationGRPVO.setListCustomMnrCdRltByLocVO(listCustomMnrCdRltByLocVO);		
			codeRelationGRPVO.setListCustomMnrCdRltByDmgVO(listCustomMnrCdRltByDmgVO);		
			codeRelationGRPVO.setListCustomMnrCdRltByRprVO(listCustomMnrCdRltByRprVO);	
				
			return codeRelationGRPVO;		
				
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0145] searchCodeRelationListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0145] searchCodeRelationListBasic"}).getMessage(),ex);
		}	
	}

	/**
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param CodeRelationGRPVO codeRelationGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodeRelationBasic(CodeRelationGRPVO codeRelationGRPVO, SignOnUserAccount account) throws EventException{
		try {
			List<CustomMnrCdRltByLocVO> insertVoList = new ArrayList<CustomMnrCdRltByLocVO>();
			List<CustomMnrCdRltByLocVO> deleteVoList = new ArrayList<CustomMnrCdRltByLocVO>();

			for ( int i=0; i<codeRelationGRPVO.getCustomMnrCdRltByLocVOS().length; i++ ) {
				//체크박스가 수정된 행
				if ( codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i].getIbflag().equals("U")){
					//체크인
					if(codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i].getG().equals("1")){
						codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i].setCreUsrId(account.getUsr_id());
						codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i]);
					} 
					//체크아웃
					else if(codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i].getG().equals("0")){
						deleteVoList.add(codeRelationGRPVO.getCustomMnrCdRltByLocVOS()[i]);
					}
				}
			}  

			if ( insertVoList.size() > 0 ) {
				dbDao.addCodeRelationData(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCodeRelationData(deleteVoList);
			}   
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0145] manageCodeRelationBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0145] manageCodeRelationBasic"}).getMessage(),ex);
		}
	}
}