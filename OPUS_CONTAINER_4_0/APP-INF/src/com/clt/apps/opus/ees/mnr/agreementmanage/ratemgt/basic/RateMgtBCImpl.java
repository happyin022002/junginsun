/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtBCImpl.java
*@FileTitle : Rate  
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration.RateMgtDBDAO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementInfoListDataVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementMenuDataVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAplyOfcPartnerVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtAplyOfcVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**  
 * Rate Business Logic Command implementation<br>
 *
 * @author 	 
 * @see 	RateMgtBC
 * @since 	J2EE 1.4   
 */     
	    
public class RateMgtBCImpl extends BasicCommandSupport implements RateMgtBC {
	
	// Database Access Object
	private transient RateMgtDBDAO dbDao = null;
	 
	/**
	 * RateMgtBCImpl creating object<br>
	 * RateMgtDBDAO creating object<br>
	 */
	public RateMgtBCImpl() {  
		dbDao = new RateMgtDBDAO();  
	} 
	
	/**
	 * [EES_MNR_0218]Retrieving "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementMenuBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		try {    	
			List<CustomAgreementMenuDataVO> customAgreementMenuDataVOS = new ArrayList<CustomAgreementMenuDataVO>(); 
				
			customAgreementMenuDataVOS = dbDao.searchAgreementMenuData();
			
			agreementGRPVO.setCustomAgreementMenuDataVOS(customAgreementMenuDataVOS); 
			
			return agreementGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] searchAgreementMenuBasic"}).getMessage(),ex);
		}
	}
	 
	/**
	 * [EES_MNR_0015]Deleting "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @exception EventException
	 */ 
	public void removeAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		try {        	
			dbDao.removeAGMTHDRGRPData(agreementGRPVO.getAgreementINVO());
			dbDao.removeAGMTRateGRPData(agreementGRPVO.getAgreementINVO());
			dbDao.removeAGMTCTLOFCGRPData(agreementGRPVO.getAgreementINVO());
			dbDao.removeAGMTCostDTLGRPData(agreementGRPVO.getAgreementINVO());
			dbDao.modifyAGMTLastVersionUnFlagData(agreementGRPVO.getAgreementINVO(),agreementGRPVO.getAccount());
			dbDao.modifyAGMTLastVersionFlagData(agreementGRPVO.getAgreementINVO(),agreementGRPVO.getAccount());
		} catch (DAOException ex) {     	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] removeAgreementBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0218]Adding, modifying, deleting "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO manageAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		try {        
			//Setting header data  
			agreementGRPVO.getCustomMnrAgmtHdrVO().setUpdUsrId(agreementGRPVO.getAccount().getUsr_id());
			agreementGRPVO.getCustomMnrAgmtHdrVO().setCreUsrId(agreementGRPVO.getAccount().getUsr_id());
			
			//Inserting new data 
			if(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtNo().equalsIgnoreCase("NEW")){
				//Getting sequence 
				//Inserting new header data
				String agmtOfcCtyCd = agreementGRPVO.getAccount().getOfc_cd();
				if(agmtOfcCtyCd.length() >= 3){
					agmtOfcCtyCd = agmtOfcCtyCd.substring(0, 3);   
				}
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtOfcCtyCd(agmtOfcCtyCd);
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtSeq(dbDao.addMnrAgmtSeqData());   
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtVerNo("1");    
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtLstVerFlg("Y");       
				dbDao.addAGMTHDRData(agreementGRPVO.getCustomMnrAgmtHdrVO());
			} 
			//Inserting new version   
			else if(agreementGRPVO.getCustomMnrAgmtHdrVO().getIsversionup().equalsIgnoreCase("Y")){
				//Inserting header data
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtLstVerFlg("Y");  
				dbDao.addAGMTHDRData(agreementGRPVO.getCustomMnrAgmtHdrVO());       
				AgreementINVO agreementINVO = new AgreementINVO();
				agreementINVO.setAgmtSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtSeq());     
				agreementINVO.setAgmtOfcCtyCd(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtOfcCtyCd());
				agreementINVO.setAgmtVerNo(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtVerNo());   
				 
				dbDao.modifyAGMTLastVersionUnFlagData(agreementINVO,agreementGRPVO.getAccount());
				dbDao.modifyAGMTLastVersionFlagData(agreementINVO,agreementGRPVO.getAccount());
				//Modifying existing data
			} else {
				//Inserting header data 
				dbDao.modifyAGMTHDRData(agreementGRPVO.getCustomMnrAgmtHdrVO());
			}
					 
			//Converting data
			List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = new ArrayList<CustomMnrAgmtRtVO>();
			customMnrAgmtRtVOS = agreementGRPVO.getCustomMnrAgmtRtVOS();  
				
			for ( int i = 0; i < customMnrAgmtRtVOS.size(); i++ ) { 
				customMnrAgmtRtVOS.get(i).setCreUsrId(agreementGRPVO.getAccount().getUsr_id());
				customMnrAgmtRtVOS.get(i).setUpdUsrId(agreementGRPVO.getAccount().getUsr_id());
				customMnrAgmtRtVOS.get(i).setAgmtSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtSeq());
				customMnrAgmtRtVOS.get(i).setAgmtOfcCtyCd(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtOfcCtyCd());
				customMnrAgmtRtVOS.get(i).setAgmtVerNo(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtVerNo());
			}      
			
			//TEMP VO
			AgreementINVO agreementINVO = new AgreementINVO();
			agreementINVO.setAgmtSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtSeq());     
			agreementINVO.setAgmtOfcCtyCd(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtOfcCtyCd());
			agreementINVO.setAgmtVerNo(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtVerNo());       
			agreementINVO.setAgmtEqType(agreementGRPVO.getCustomMnrAgmtHdrVO().getEqKndCd());   
			agreementINVO.setUpdUsrId(agreementGRPVO.getAccount().getUsr_id());   
			  
			//Deleting        
			dbDao.removeAGMTRateGRPData(agreementINVO);
			dbDao.removeAGMTCostDTLGRPData(agreementINVO);    
			//Re-Inserting       
			dbDao.addAGMTRateData(customMnrAgmtRtVOS);     
			  
			//Cost CTRL Office DELETE
			dbDao.removeAGMTCTLOFCGRPData(agreementINVO);    
			//Cost CTRL Office Insert  
			List<CustomMnrAgmtAplyOfcVO> insertVoList = new ArrayList<CustomMnrAgmtAplyOfcVO>();
			       
			if(agreementGRPVO.getCustomMnrAgmtAplyOfcVOS() != null){
				CustomMnrAgmtAplyOfcVO[] customMnrAgmtAplyOfcVOS = agreementGRPVO.getCustomMnrAgmtAplyOfcVOS();
				for ( int i = 0; i< customMnrAgmtAplyOfcVOS.length; i++ ) {      
					customMnrAgmtAplyOfcVOS[i].setCreUsrId(agreementGRPVO.getAccount().getUsr_id());
					customMnrAgmtAplyOfcVOS[i].setUpdUsrId(agreementGRPVO.getAccount().getUsr_id());
					customMnrAgmtAplyOfcVOS[i].setAgmtSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtSeq());
					customMnrAgmtAplyOfcVOS[i].setAgmtOfcCtyCd(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtOfcCtyCd());
					customMnrAgmtAplyOfcVOS[i].setAgmtVerNo(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtVerNo());
					              
					insertVoList.add(customMnrAgmtAplyOfcVOS[i]);  
				}                  
				
				if ( insertVoList.size() > 0 ) {    
					dbDao.addAGMTCTLOFCData(insertVoList);
				}    	    
			}
			
			//Inserting detail table after data sum of result of RT table 
			dbDao.addAGMTCostDTLData(agreementINVO);   
			//Returning data for Re-retrieve
			agreementINVO.setAgmtTypeTpsz(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtTypeTpsz());
			agreementGRPVO.setAgreementINVO(agreementINVO);  
			
			return agreementGRPVO;
		} catch (DAOException ex) {     	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] manageAgreementBasic"}).getMessage(),ex);
		} catch (Exception e) {     	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] manageAgreementBasic"}).getMessage(),e);
		}  	
	}
	
	/**
	 * [EES_MNR_0218]Retrieving "M&R Agreement" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */	
	public AgreementGRPVO searchAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();  
		List<CustomAgreementMenuDataVO> customAgreementMenuDataVOS = new ArrayList<CustomAgreementMenuDataVO>(); 
		CustomMnrAgmtHdrVO customMnrAgmtHdrVO = null;  
		
		try {  
			//Retrieving display data
			customAgreementMenuDataVOS = dbDao.searchAgreementMenuData();
			
			//Retrieving header data
			customMnrAgmtHdrVO = dbDao.searchAGMTHDRData(agreementGRPVO.getAgreementINVO()); 
			agreementGRPVO.setCustomMnrAgmtHdrVO(customMnrAgmtHdrVO);  
			   
			//Returning if there is no data           
			if(customMnrAgmtHdrVO == null){   
				agreementGRPVO.setGeneralEventResponse(eventResponse);
				return agreementGRPVO;           
			} else {      
				eventResponse.setETCData(customMnrAgmtHdrVO.getColumnValues());  
			}        
			 
			//Retrieving "AplyOfc + Partner" data		 
			List<CustomAplyOfcPartnerVO> customAplyOfcPartnerVOS = null;
			customAplyOfcPartnerVOS = dbDao.searchAplyOfcPartnerData(agreementGRPVO.getAgreementINVO());
			eventResponse.setRsVoList(customAplyOfcPartnerVOS);       
			 
			String eqType = customMnrAgmtHdrVO.getEqKndCd(); 
			
			for(int i = 0;i < customAgreementMenuDataVOS.size();i++){
				if(customAgreementMenuDataVOS.get(i).getEqType().equals(eqType)){
					agreementGRPVO.getAgreementINVO().setAgmtEqType(eqType); 
					agreementGRPVO.getAgreementINVO().setAgmtDisType(customAgreementMenuDataVOS.get(i).getTabType());
					
					List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = null;    
					customMnrAgmtRtVOS = dbDao.searchAGMTRateData(agreementGRPVO.getAgreementINVO());
					eventResponse.setRsVoList(customMnrAgmtRtVOS);                
				}              	
			}       	
			 
			agreementGRPVO.setGeneralEventResponse(eventResponse);
			return agreementGRPVO;
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement] searchAgreementBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0226]Retrieving "W/O Creation" data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO 
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementComboListBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS = new ArrayList<CustomMnrAgmtHdrVO>(); 
			
		try {  	
			//Retrieving header data 
			customMnrAgmtHdrVOS = dbDao.searchAgreementComboListData(agreementGRPVO.getAgreementComboListINVO());
			agreementGRPVO.setCustomMnrAgmtHdrVOS(customMnrAgmtHdrVOS);
				 
			return agreementGRPVO;   
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchAgreementComboListBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0018]Retrieving "M&R Agreement List" data<br>
	 *
	 * @param AgreementInfoListGRPVO agreementInfoListGRPVO
	 * @return AgreementInfoListGRPVO
	 * @exception EventException
	 */
	public AgreementInfoListGRPVO searchAgreementInfoListBasic(AgreementInfoListGRPVO agreementInfoListGRPVO) throws EventException {
		try {    	
			List<CustomAgreementInfoListDataVO> customAgreementInfoListDataVOs = new ArrayList<CustomAgreementInfoListDataVO>(); 
				
			customAgreementInfoListDataVOs = dbDao.searchAgreementInfoListData(agreementInfoListGRPVO.getAgreementInfoListINVO());
			
			agreementInfoListGRPVO.setCustomAgreementInfoListDataVOs(customAgreementInfoListDataVOs); 
			
			return agreementInfoListGRPVO;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement List] searchAgreementInfoListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0015]Checking Duplicate Agreement Data<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return String 
	 * @exception EventException
	 */
	public String searchAgmtDupInfoBasic(AgreementGRPVO agreementGRPVO) throws EventException{
		CustomMnrAgmtHdrVO customMnrAgmtHdrVO = new CustomMnrAgmtHdrVO();
		String returnVal = "";
		try {
			customMnrAgmtHdrVO = agreementGRPVO.getCustomMnrAgmtHdrVO();
			returnVal = dbDao.searchAgmtDupInfoData(customMnrAgmtHdrVO);
		 
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement Creation] searchAgmtDupInfoBasic"}).getMessage(),ex);
		}
		return returnVal; 
	}
}