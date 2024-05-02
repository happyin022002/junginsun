/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtBCImpl.java
*@FileTitle : Damage Flagging/Unflagging Pop Up,Damage Flagging/Unflagging
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.CustomWarrantyAlertListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration.EQFlagMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
  
/**
 * COM-OperationManage Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see EES_MNR_0139EventResponse,EES_MNR_0122HTMLAction,EQFlagMgtBC DAO class reference
 * @since J2EE 1.4
 */
public class EQFlagMgtBCImpl extends BasicCommandSupport implements EQFlagMgtBC {
	
	// Database Access Object
	private transient EQFlagMgtDBDAO dbDao = null; 	
	// Flag From 
	private String flgDmgCd 	= "DMG";
	private String flgHangerCd 	= "HGR";	
	private String flgScrCd  	= "SCR";
	private String flgDonCd  	= "DON";
	private String flgTllCd  	= "TLL";
	private String flgDspCd  	= "DSP";
	
	// Flag Input Type Code List
	private String disposal        = "D";	
	private String scrapping       = "C";	
	private String donation        = "N";	
	private String totalLoss       = "T";	
	private String manual          = "M";	
//	private String movement        = "V"; 	
	//private String repair          = "R";	
	//private String workOrder       = "W";	
	//private String invoice         = "I";	
	//private String resultCreation  = "S";
		
	/**
	 * creating EQFlagMgtBCImpl object<br>
	 * creating EQFlagMgtDBDAO <br>
	 */
	public EQFlagMgtBCImpl() {
		dbDao = new EQFlagMgtDBDAO();
	}
	  
	/**
	 * [EES_MNR_0122] retrieving Hanger Bar Attatch/Detach Qty by CNTR. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException {
		try {   
				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>(); 
				if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals(flgHangerCd)){
					customMnrEqStsVOS = dbDao.searchHangerFlagStatusListData(eQFlagListGRPVO.getEQFlagListINVO());
				}else{
					customMnrEqStsVOS = dbDao.searchEQFlagStatusListData(eQFlagListGRPVO.getEQFlagListINVO());
				}
				eQFlagListGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVOS);
				        
				return eQFlagListGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Attatch/Detach Qty by CNTR] searchEQFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Attatch/Detach Qty by CNTR] searchEQFlagListBasic"}).getMessage(),ex);
		} 
	} 
	   
	/**
	 * [EES_MNR_0122] adding/modification/deletion W/O Creation. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			List<CustomMnrFlgHisVO> addCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
			List<CustomMnrEqStsVO> addCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
			List<CustomMnrEqStsVO> modifyCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
					
			CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
			CustomMnrFlgHisVO[] customMnrFlgHisVOS = eQFlagListGRPVO.getArrCustomMnrFlgHisVOS();
			 
			String mnrFlgTpCd = eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd();
			  
			for ( int i = 0; i< customMnrEqStsVOS.length; i++ ) {      
					if(mnrFlgTpCd.equals(flgHangerCd)){
						customMnrEqStsVOS[i].setHngrBarAtchKnt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
					}
					customMnrEqStsVOS[i].setCreUsrId(account.getUsr_id()); 
					customMnrEqStsVOS[i].setUpdDt(account.getUpd_dt());   
					customMnrEqStsVOS[i].setCreDt(account.getUpd_dt());     
					customMnrEqStsVOS[i].setCostDtlCd(mnrFlgTpCd);
					                  
					// setting history table
					customMnrFlgHisVOS[i].setMnrStsFlg(customMnrEqStsVOS[i].getMnrDmgFlg());
					customMnrFlgHisVOS[i].setMnrFlgRmk(customMnrEqStsVOS[i].getMnrStsRmk());	
									
					//hanger 
					if(mnrFlgTpCd.equals(flgHangerCd)){
						customMnrFlgHisVOS[i].setMnrStsFlg(customMnrEqStsVOS[i].getMnrHngrFlg());
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgHangerCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());  
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrHngrFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(manual);
						}
					//DMG
					} else if(mnrFlgTpCd.equals(flgDmgCd)){  
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDmgCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());   
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						customMnrEqStsVOS[i].setMnrDmgFlgDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(manual);
						}
					//scrap 
					} else if(mnrFlgTpCd.equals(flgScrCd)){ 
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgScrCd);
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());   
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(scrapping);
						}
					//donation  
					} else if(mnrFlgTpCd.equals(flgDonCd)){ 
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDonCd);   
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());   
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(donation);
						}
					//totalloss 
					} else if(mnrFlgTpCd.equals(flgTllCd)){  
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgTllCd);   
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());   
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(totalLoss);
						}
					//Disposal	  
					} else if(mnrFlgTpCd.equals(flgDspCd)){  
						customMnrFlgHisVOS[i].setMnrFlgTpCd(flgDspCd);    
						customMnrFlgHisVOS[i].setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());   
						customMnrFlgHisVOS[i].setMnrFlgInpDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
						if(customMnrFlgHisVOS[i].getMnrFlgInpTpCd().equals("") || customMnrFlgHisVOS[i].getMnrFlgInpTpCd() == null){
							customMnrFlgHisVOS[i].setMnrFlgInpTpCd(disposal); 
						}  	    
					}	
					customMnrFlgHisVOS[i].setCreOfcCd(account.getOfc_cd());  
					customMnrFlgHisVOS[i].setCreUsrId(account.getUsr_id()); 
					customMnrFlgHisVOS[i].setCreDt(account.getUpd_dt());    
					 	 
					addCustomMnrFlgHisVOS.add(customMnrFlgHisVOS[i]);      
					
					int cnt = dbDao.checkHangerFlagStatusData(customMnrEqStsVOS[i].getEqNo());
					if(cnt > 0){
						modifyCustomMnrEqStsVOS.add(customMnrEqStsVOS[i]); 						
					} else {
						addCustomMnrEqStsVOS.add(customMnrEqStsVOS[i]);  
					}  					
			}                        
			      
			if(mnrFlgTpCd.equals(flgHangerCd)){
				if(modifyCustomMnrEqStsVOS.size() > 0 ){
					dbDao.modifyHangerFlagStatusData(modifyCustomMnrEqStsVOS);
				}
				if(addCustomMnrEqStsVOS.size() > 0 ){
					dbDao.addHangerFlagStatusData(addCustomMnrEqStsVOS);
				}
			} else{
				if(modifyCustomMnrEqStsVOS.size() > 0 ){
					dbDao.modifyEQFlagStatusData(modifyCustomMnrEqStsVOS);
				}
				if(addCustomMnrEqStsVOS.size() > 0 ){
					dbDao.addEQFlagStatusData(addCustomMnrEqStsVOS);
				} 	  
			}  
				
			if ( addCustomMnrFlgHisVOS.size() > 0 ) {    
				if(mnrFlgTpCd.equals(flgHangerCd)){	
					dbDao.addHangerFlagHistoryListData(addCustomMnrFlgHisVOS);
				}else{
					dbDao.addEQFlagHistoryListData(addCustomMnrFlgHisVOS,account.getOfc_cd()); 
				}				
			} 
		} catch (DAOException de) { 
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging] manageEQFlagListBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging] manageEQFlagListBasic"}).getMessage(),de);
		} 
	}   
	
	/**
	 * [Damage Flagging/Unflagging Interface] calling Flagging , CTM  <br> 
	 *  modifying on MNR, MST, CGM . 
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageIFFlagForOtherBasic(CustomMnrEqStsVO customMnrEqStsVO, SignOnUserAccount account) throws EventException{
		try {	
			
			/*  mandatory
			 *  customMnrEqStsVO.setEqNo(*** );			 AMFU5001997	
			 *	customMnrEqStsVO.setEqKndCd(***);		 U
			 *	customMnrEqStsVO.setEqTpszCd(***);	     D2
			 *	customMnrEqStsVO.setMnrDmgFlgYdCd(***);	 KRPUSHN
			 *  customMnrEqStsVO.setMnrDmgFlg(***)    	 0=>N , 1=>Y
			 *  matching table MNR_EQ_STS  
			 */
					
			// damage flagging
			List<CustomMnrFlgHisVO> addCustomMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
			List<CustomMnrEqStsVO> addCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
			List<CustomMnrEqStsVO> modifyCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				
			// setting STS table
			customMnrEqStsVO.setCreUsrId(account.getUsr_id()); 
//			customMnrEqStsVO.setMnrStsRmk(account.getUsr_id());  
			customMnrEqStsVO.setUpdDt(account.getUpd_dt());   
			customMnrEqStsVO.setCreDt(account.getUpd_dt());     
			customMnrEqStsVO.setCostDtlCd(flgDmgCd);   
//			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
//			String today = formatter.format(new java.util.Date());
			customMnrEqStsVO.setMnrDmgFlgDt(customMnrEqStsVO.getMnrFlgInpDt());  
			customMnrEqStsVO.setMnrStsRmk(customMnrEqStsVO.getMnrFlgRmk()); 
				
			int cnt = dbDao.checkHangerFlagStatusData(customMnrEqStsVO.getEqNo());
			if(cnt > 0){	
				modifyCustomMnrEqStsVOS.add(customMnrEqStsVO);	 							
			} else {
				addCustomMnrEqStsVOS.add(customMnrEqStsVO);	  
			}  
			
			CustomMnrFlgHisVO customMnrFlgHisVO =  new CustomMnrFlgHisVO();
			// setting history table   	
			customMnrFlgHisVO.setEqNo(customMnrEqStsVO.getEqNo());
			customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVO.getEqTpszCd()); 
			customMnrFlgHisVO.setEqKndCd(customMnrEqStsVO.getEqKndCd()); 
			customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());  
			customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrDmgFlg()); 		
			customMnrFlgHisVO.setMnrFlgRmk(customMnrEqStsVO.getMnrStsRmk());	 	
			customMnrFlgHisVO.setMnrFlgTpCd(flgDmgCd); 
			customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());   
			customMnrFlgHisVO.setMnrFlgInpDt(customMnrEqStsVO.getMnrDmgFlgDt());
			customMnrFlgHisVO.setMnrFlgInpTpCd(customMnrEqStsVO.getMnrFlgInpTpCd());	
			customMnrFlgHisVO.setCreUsrId(account.getUsr_id());
			customMnrFlgHisVO.setCreDt(account.getUpd_dt());	
			
			addCustomMnrFlgHisVOS.add(customMnrFlgHisVO);	
			
			// insert history table
			dbDao.addEQFlagHistoryListData(addCustomMnrFlgHisVOS,account.getOfc_cd());
				
		    // handling STS table
			if(modifyCustomMnrEqStsVOS.size() > 0 ){			
				dbDao.modifyEQFlagStatusData(modifyCustomMnrEqStsVOS);
			}
			if(addCustomMnrEqStsVOS.size() > 0 ){			
				dbDao.addEQFlagStatusData(addCustomMnrEqStsVOS);
			} 	
			
			/***************** calling MST interface **********************/
			IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
			if(customMnrEqStsVO.getMnrDmgFlg().equals("1")){
				iFMnrFlagVO.setStsFlag("Y");	
			} else {
				iFMnrFlagVO.setStsFlag("N"); 
			}
			iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
			iFMnrFlagVO.setFlagUserId(account.getUsr_id());
			iFMnrFlagVO.setFlagType(flgDmgCd); 	
			iFMnrFlagVO.setRetireFlag("N");  
			iFMnrFlagVO.setEqKindCd(customMnrEqStsVO.getEqKndCd());
			iFMnrFlagVO.setEqNo(customMnrEqStsVO.getEqNo());
			iFMnrFlagVO.setFlagDt(customMnrEqStsVO.getMnrDmgFlgDt());
			iFMnrFlagVO.setFlagYdCd(customMnrEqStsVO.getMnrDmgFlgYdCd());	
			 
			List<IFMnrFlagVO> cntrIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			List<IFMnrFlagVO> otherIFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			
			ContainerOnOffhireBC command1 =  new ContainerOnOffhireBCImpl();
			ChassisMgsetOnOffhireBC command2 =  new ChassisMgsetOnOffhireBCImpl();
			
			if(iFMnrFlagVO.getEqKindCd().equalsIgnoreCase("U")){
				cntrIFMnrFlagVOS.add(iFMnrFlagVO);
			} else {
				otherIFMnrFlagVOS.add(iFMnrFlagVO);
			}	
				
			if ( cntrIFMnrFlagVOS.size() > 0 ) {
				IFMnrFlagVO[] arrIFMnrFlagVOS = new IFMnrFlagVO[cntrIFMnrFlagVOS.size()];
				for ( int i = 0; i < cntrIFMnrFlagVOS.size(); i++ ) {
					arrIFMnrFlagVOS[i] = cntrIFMnrFlagVOS.get(i);
				}
				command1.createMNRStatusBasic(arrIFMnrFlagVOS,account);
			}

			if ( otherIFMnrFlagVOS.size() > 0 ) {
				command2.createMNRStatusBasic(otherIFMnrFlagVOS);
			}
	
				
		} catch (DAOException de) {	 
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Interface] manageIFFlagForOtherBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Damage Flagging/Unflagging Interface] manageIFFlagForOtherBasic"}).getMessage(),de);
		} 
	}   

	/**
	 * [EES_MNR_0125] retrieving Hanger Bar CNTR History. <br>
	 *
	 * @param EQFlagListGRPVO 	eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagHistoryListBasic(EQFlagListGRPVO eQFlagListGRPVO,SignOnUserAccount account) throws EventException {
		try {   
			List<CustomMnrFlgHisVO> customMnrFlgHisVO = new ArrayList<CustomMnrFlgHisVO>(); 
			customMnrFlgHisVO = dbDao.searchEQFlagHistoryListData(eQFlagListGRPVO.getEQFlagListINVO(),account.getOfc_cd());
			eQFlagListGRPVO.setCustomMnrFlgHisVOS(customMnrFlgHisVO);

			return eQFlagListGRPVO;      
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar CNTR History] searchEQFlagHistoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar CNTR History] searchEQFlagHistoryListBasic"}).getMessage(),ex);
		}  
	} 

	/**
	 * [EES_MNR_0151] retrieving Disposal Candidate Selection. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidateFlagListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException {
		try {   
				List<CustomMnrEqStsVO> customMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>(); 
				List<CustomMnrEqRngStsVO> customMnrEqRngStsVO = new ArrayList<CustomMnrEqRngStsVO>(); 

				if(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd().equals("R")){
					customMnrEqRngStsVO = dbDao.searchDisposalCandidateFlagByRangeData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO(),account);
					disposalCandidateFlagGRPVO.setCustomMnrEqRngStsVOS(customMnrEqRngStsVO);
				}else if(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd().equals("N")) {
					customMnrEqStsVO = dbDao.searchDisposalCandidateFlagByEQData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO(),account);
					disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVO);

				}
				disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVO);
				        
				return disposalCandidateFlagGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex); 
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchDisposalCandidateFlagListBasic"}).getMessage(),ex); 
		} 
	} 	
	
	/**
	 * [EES_MNR_0158] retrieving Disposal Candidate Inquiry_Pop Up. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidatePopupListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException {
		try {   
				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>(); 
				customMnrEqStsVOS = dbDao.searchDisposalCandidatePopupListData(disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO());
				disposalCandidateFlagGRPVO.setCustomMnrEqStsVOS(customMnrEqStsVOS);
			        
				return disposalCandidateFlagGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Inquiry_Pop Up] searchDisposalCandidatePopupListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Inquiry_Pop Up] searchDisposalCandidatePopupListBasic"}).getMessage(),ex);
		} 
	} 		
	
	/**
	 * [EES_MNR_0151] adding/modification/deletion Disposal Candidate Selection. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */   
	public void manageDisposalCandidateFlagBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			CustomMnrEqRngStsVO[] customMnrEqRngStsVOS = disposalCandidateFlagGRPVO.getarrCustomMnrEqRngStsVOS();
			CustomMnrEqStsVO[] customMnrEqStsVOS = disposalCandidateFlagGRPVO.getArrCustomMnrEqStsVOS();
			List<CustomMnrEqStsVO> customMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>(); 
			String selectCd = disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd();
			//Selection Type = EQ Range 
			if(selectCd.equalsIgnoreCase("R"))
			{
				List<CustomMnrEqRngStsVO> mergeRngVoList = new ArrayList<CustomMnrEqRngStsVO>();

				int cnt=0;
				for ( int i=0; i< customMnrEqRngStsVOS.length; i++ ) {  
					customMnrEqRngStsVOS[i].setCreUsrId(account.getUsr_id()); 
					customMnrEqRngStsVOS[i].setUpdUsrId(account.getUsr_id()); 
					mergeRngVoList.add(customMnrEqRngStsVOS[i]);
					customMnrEqStsVO=dbDao.checkDisposalCandidateFlagByRangeAfterData(mergeRngVoList); 
					if(customMnrEqStsVO.size() >0)
					{
						dbDao.modifyDisposalCandidateFlagByRangeAfterData(mergeRngVoList); 
						if(Integer.parseInt(customMnrEqRngStsVOS[i].getEqQty()) != customMnrEqStsVO.size())
						{
							dbDao.addDisposalCandidateFlagByRangeAfterData(mergeRngVoList); 
						}
					}
					else
					{
						dbDao.addDisposalCandidateFlagByRangeAfterData(mergeRngVoList); 
					}
					customMnrEqStsVO.clear();
					
					cnt++;
					if(cnt==10 || i==customMnrEqRngStsVOS.length-1)
					{
						if ( mergeRngVoList.size() > 0 ) {   
							dbDao.mergeDisposalCandidateFlagByRangeData(mergeRngVoList); 
						}
						mergeRngVoList.clear();
						cnt=0;
					}
				}
			}
			//Selection Type = EQ No
			else if(selectCd.equalsIgnoreCase("N"))
			{
				List<CustomMnrEqStsVO> mergeNoVoList = new ArrayList<CustomMnrEqStsVO>();
				for ( int i=0; i< customMnrEqStsVOS.length; i++ ) {  
					if(!customMnrEqStsVOS[i].getIbflag().equalsIgnoreCase("R"))
					{
						customMnrEqStsVOS[i].setCreUsrId(account.getUsr_id()); 
						customMnrEqStsVOS[i].setUpdUsrId(account.getUsr_id()); 
						mergeNoVoList.add(customMnrEqStsVOS[i]);
					}
				}
				if ( mergeNoVoList.size() > 0 ) {   
						dbDao.mergeDisposalCandidateFlagByEQData(mergeNoVoList); 
				}
			}
					
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] manageDisposalCandidateFlagBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] manageDisposalCandidateFlagBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0156] adding/modification mkr_nm,mdl_nm,rpr_cost_amt of MNR_EQ_STS. <br>
	 * 
	 * @param DisposalGRPVO disposalGRPVO 
	 * @param SignOnUserAccount account     
	 * @exception EventException   
	 */ 
	public void manageEqStsMkrNmMdlNmBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			CustomMnrDispDtlVO[] arrCustomMnrDispDtlVOS = disposalGRPVO.getArrCustomMnrDispDtlVOS(); 
			    
			//DISPOSAL EQ_NO
			for(int i = 0;i < arrCustomMnrDispDtlVOS.length;i++){
				if(arrCustomMnrDispDtlVOS[i].getDispUtTpCd().equals("E")){
					arrCustomMnrDispDtlVOS[i].setUpdUsrId(account.getUsr_id());
					dbDao.modifyEqStsMkrNmMdlNmData(arrCustomMnrDispDtlVOS[i]);
				}  
			} 
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal request/approval] manageEqStsMkrNmMdlNmBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal request/approval] manageEqStsMkrNmMdlNmBasic"}).getMessage(),de);
		} 
	}   
	
	/**
	 * [EES_MNR_0170] adding/modification/deletion Reefer Unit Warranty Period. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWarrantyAlertBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			List<CustomWarrantyAlertListVO> addCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>();
			List<CustomWarrantyAlertListVO> modifyCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>();
			List<CustomWarrantyAlertListVO> removeCustomWarrantyAlertListVOS = new ArrayList<CustomWarrantyAlertListVO>(); 
			   
			CustomWarrantyAlertListVO[] customWarrantyAlertListVOS = warrantyAlertListGRPVO.getArrCustomWarrantyAlertListVOS();
			for ( int i=0; i< customWarrantyAlertListVOS.length; i++ ) {      
				if (customWarrantyAlertListVOS[i].getIbflag().equals("I") || customWarrantyAlertListVOS[i].getIbflag().equals("U")){
					customWarrantyAlertListVOS[i].setCreUsrId(account.getUsr_id());
					customWarrantyAlertListVOS[i].setUpdUsrId(account.getUsr_id());
					customWarrantyAlertListVOS[i].setCreDt(account.getUpd_dt());     
					customWarrantyAlertListVOS[i].setUpdDt(account.getUpd_dt()); 
					String checkResult = dbDao.checkWarrantyAlertData(customWarrantyAlertListVOS[i]);
					 
					if(checkResult.equals("U")){ 
						modifyCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]);
					} else { 
						addCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]); 
					}    
				} else if ( customWarrantyAlertListVOS[i].getIbflag().equals("D")){
					removeCustomWarrantyAlertListVOS.add(customWarrantyAlertListVOS[i]);               
				}                       
			}                    
			
			if ( addCustomWarrantyAlertListVOS.size() > 0 ) {     
				dbDao.addWarrantyAlertData(addCustomWarrantyAlertListVOS);
			} 
			 
			if ( modifyCustomWarrantyAlertListVOS.size() > 0 ) {   
				dbDao.modifyWarrantyAlertData(modifyCustomWarrantyAlertListVOS);
			}     
			 
			if ( removeCustomWarrantyAlertListVOS.size() > 0 ) {  
				dbDao.removeWarrantyAlertData(removeCustomWarrantyAlertListVOS); 
			}  
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] manageWarrantyAlertBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0170] manageWarrantyAlertBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0151] retrieving  EQ NO list<br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchRangeToEQNoBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException {
		try {     
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();   
				iFMnrFlagVOS = dbDao.searchRangeToEQNoData(disposalCandidateFlagGRPVO);
				disposalCandidateFlagGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS); 
				return disposalCandidateFlagGRPVO;   
		} catch (DAOException ex) {     
			log.error("err " + ex.toString(), ex); 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Disposal Candidate Selection] searchRangeToEQNoBasic"}).getMessage(),ex); 
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Dispposal Candidate Selection] searchRangeToEQNoBasic"}).getMessage(),de);
		} 
	} 	
	
	/**
	 * [EES_MNR_0019] retrieving EQ NO <br> 
	 * @param String  eqNo  
	 * @return String    
	 * @exception EventException 
	 */
	public  CustomMnrEqStsVVO searchEqInfoBasic(String  eqNo) throws EventException {
		try {       
			CustomMnrEqStsVVO customMnrEqStsVVO = null;   
			customMnrEqStsVVO = dbDao.searchEqInfoData(eqNo);
			return customMnrEqStsVVO;     
		} catch (DAOException ex) {     
			log.error("err " + ex.toString(), ex); 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Creation/Approval] searchEqInfoBasic"}).getMessage(),ex); 
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Estimate Creation/Approval] searchEqInfoBasic"}).getMessage(),de);
		} 
	}	
	
	/**
	 * [EES_MNR_0058]retrieving Hanger Bar Attatch/Detach Qty by CNTR. <br>
	 * reference EQ_STS Table before deleting WO 
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchHangerEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException {
		try {   
				
			CustomMnrEqStsVO customMnrEqStsVO = dbDao.searchHangerEQFlagListData(eQFlagListGRPVO.getEQFlagListINVO());
			eQFlagListGRPVO.setCustomMnrEqStsVO(customMnrEqStsVO);
				
			return eQFlagListGRPVO; 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Extra W/O Delete] searchHangerEQFlagListBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Extra W/O Delete] searchHangerEQFlagListBasic"}).getMessage(),ex);
		} 
	} 
	
	/**
	 * [EES_MNR_0109] Check EQ Status Remark <br>
	 * @param CustomMnrFlgHisVO customMnrFlgHisVO
	 * @return String
	 * @exception EventException
	 */
	public String searchEQStsRmkBasic(CustomMnrFlgHisVO customMnrFlgHisVO) throws EventException{
		try {  
			return dbDao.searchEqStsRmkData(customMnrFlgHisVO); 
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchEQStsRmkBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchEQStsRmkBasic"}).getMessage(),ex);
		} 
	}
	
	/**
	 * [EES_MNR_0109] Check EQ Status Flagging <br>
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @return String
	 * @exception EventException
	 */
	public String checkHngrFlaggingBasic(CustomMnrEqStsVO customMnrEqStsVO) throws EventException{
		try {  
			return dbDao.checkHngrFlaggingData(customMnrEqStsVO);
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"checkHngrFlaggingBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"checkHngrFlaggingBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0109] Check EQ Status Count <br>
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return String
	 * @exception EventException
	 */
	public String searchHangerFlagStatusCountBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException{
		try {  
			return dbDao.searchHangerFlagStatusCountData(eQFlagListGRPVO.getEQFlagListINVO());
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchHangerFlagStatusCountBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchHangerFlagStatusCountBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_01222] Check Container OP status <br>
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCntrOpStatusBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException{
		try {  
			CustomMnrEqStsVO[] vos = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
			String rtnEqs = "";
			for(int i = 0; i < vos.length; i++){
				if("1".equals(vos[i].getMnrDmgFlg())){
					String status = dbDao.checkOpStatusData(vos[i].getEqNo(), vos[i].getMnrDmgFlgDt());
					if("OP".equals(status)){
						if("".equals(rtnEqs)){
							rtnEqs = vos[i].getEqNo();
						}else{
							rtnEqs = rtnEqs + "," + vos[i].getEqNo();
						}
					}
				}
			}
			return rtnEqs;
		} catch (DAOException ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchCntrOpStatusBasic"}).getMessage(),ex);
		} catch (Exception ex) {            
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"searchCntrOpStatusBasic"}).getMessage(),ex);
		}
		
	}
}