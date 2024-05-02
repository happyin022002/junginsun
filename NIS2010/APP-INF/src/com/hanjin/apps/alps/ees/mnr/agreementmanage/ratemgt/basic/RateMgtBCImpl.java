/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtBCImpl.java
*@FileTitle : Rate 관련  
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration.RateMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgmtAtchDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListGRPVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementInfoListDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementMenuDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAplyOfcPartnerVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtAplyOfcVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**  
 * Rate Business Logic Command implementation<br>
 *
 * @author 	park myoung sin 
 * @see 	RateMgtBCImpl 참조
 * @since 	J2EE 1.4   
 */     
	    
public class RateMgtBCImpl extends BasicCommandSupport implements RateMgtBC {
	
	// Database Access Object
	private transient RateMgtDBDAO dbDao = null;
	 
	/**
	 * RateMgtBCImpl 객체 생성<br>
	 * RateMgtDBDAO 생성한다.<br>
	 */
	public RateMgtBCImpl() {  
		dbDao = new RateMgtDBDAO();  
	} 
	
	/**
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */ 
	public AgreementGRPVO manageAgreementBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		try {        
			//헤더에 데이타 세팅  
			agreementGRPVO.getCustomMnrAgmtHdrVO().setUpdUsrId(agreementGRPVO.getAccount().getUsr_id());
			agreementGRPVO.getCustomMnrAgmtHdrVO().setCreUsrId(agreementGRPVO.getAccount().getUsr_id());
			
			//신규 INSERT 
			if(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtNo().equalsIgnoreCase("NEW")){
				//seq를 새로 딴다 신규건 이므로 
				//헤더 데이타 입력 
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
			//버젼업 INSERT   
			else if(agreementGRPVO.getCustomMnrAgmtHdrVO().getIsversionup().equalsIgnoreCase("Y")){
				//헤더 데이타 입력         
				agreementGRPVO.getCustomMnrAgmtHdrVO().setAgmtLstVerFlg("Y");  
				dbDao.addAGMTHDRData(agreementGRPVO.getCustomMnrAgmtHdrVO());       
				AgreementINVO agreementINVO = new AgreementINVO();
				agreementINVO.setAgmtSeq(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtSeq());     
				agreementINVO.setAgmtOfcCtyCd(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtOfcCtyCd());
				agreementINVO.setAgmtVerNo(agreementGRPVO.getCustomMnrAgmtHdrVO().getAgmtVerNo());   
				 
				dbDao.modifyAGMTLastVersionUnFlagData(agreementINVO,agreementGRPVO.getAccount());
				dbDao.modifyAGMTLastVersionFlagData(agreementINVO,agreementGRPVO.getAccount());
				//기존건 수정    
			} else {
				//헤더 데이타 입력 
				dbDao.modifyAGMTHDRData(agreementGRPVO.getCustomMnrAgmtHdrVO());
			}
					 
			//변환  
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
			  
			//모두 지우고        
			dbDao.removeAGMTRateGRPData(agreementINVO);
			dbDao.removeAGMTCostDTLGRPData(agreementINVO);    
			//다시입력한다.       
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
			
			//RT테이블의 결과를 서머리하여 DTL 테이블에 인서트 
			dbDao.addAGMTCostDTLData(agreementINVO);   
			//재조회를 해야 되므로 리턴                    
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
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
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
			//디스플레이할 정보를 가져온다. 
			customAgreementMenuDataVOS = dbDao.searchAgreementMenuData();
			
			//헤더정보 조회 
			customMnrAgmtHdrVO = dbDao.searchAGMTHDRData(agreementGRPVO.getAgreementINVO()); 
			agreementGRPVO.setCustomMnrAgmtHdrVO(customMnrAgmtHdrVO);  
			   
			//조회 결과가 없다면 그냥 리턴           
			if(customMnrAgmtHdrVO == null){   
				agreementGRPVO.setGeneralEventResponse(eventResponse);
				return agreementGRPVO;           
			} else {      
				eventResponse.setETCData(customMnrAgmtHdrVO.getColumnValues());  
			}        
			 
			//AplyOfc + Partner 조회		 
			List<CustomAplyOfcPartnerVO> customAplyOfcPartnerVOS = null;
			customAplyOfcPartnerVOS = dbDao.searchAplyOfcPartnerData(agreementGRPVO.getAgreementINVO());
			eventResponse.setRsVoList(customAplyOfcPartnerVOS);       
			 
			//RATE 정보 조회 eq타입에 따라 디스플레이 순서및 데이타가  틀려진다.  
			String eqType = customMnrAgmtHdrVO.getEqKndCd(); 
			
			for(int i = 0;i < customAgreementMenuDataVOS.size();i++){
				//조회 로직      
				if(customAgreementMenuDataVOS.get(i).getEqType().equals(eqType)){
					//eventResponse 세팅                 
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */
	public AgreementGRPVO searchAgreementComboListBasic(AgreementGRPVO agreementGRPVO) throws EventException {
		List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS = new ArrayList<CustomMnrAgmtHdrVO>(); 
			
		try {  	
			//헤더정보 조회 
			customMnrAgmtHdrVOS = dbDao.searchAgreementComboListData(agreementGRPVO.getAgreementComboListINVO());
			agreementGRPVO.setCustomMnrAgmtHdrVOS(customMnrAgmtHdrVOS);
				 
			return agreementGRPVO;   
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[W/O Creation] searchAgreementComboListBasic"}).getMessage(),ex);
		}
	} 
	
	/**
	 * [EES_MNR_0018]M&R Agreement List의 정보를 조회 합니다. <br>
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
	 * [EES_MNR_0017]M&R Agreement Attach의 정보를 조회 합니다. <br>
	 *
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @return List<AgmtAtchDataVO> 
	 * @exception EventException
	 */
	public List<AgmtAtchDataVO> searchAgreementAttachInfoListBasic(AgmtAtchDataVO agmtAtchDataVO) throws EventException {
		try {
			List<AgmtAtchDataVO> list = new ArrayList<AgmtAtchDataVO>(); 
				
			list = dbDao.searchAgreementAttachInfoListData(agmtAtchDataVO);
			
			return list;  
		} catch (DAOException ex) {   	 
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement Attach List] searchAgreementAttachInfoListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0017] M&R Agreement Attach List의 정보를 저장 합니다. <br>
	 * 
	 * @param AgmtAtchDataVO[] agmtAtchDataVOs
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @param SignOnUserAccount account
	 * @return int insCnt
	 * @exception EventException
	 */
	public int manageAgreementAttachInfoBasic(AgmtAtchDataVO[] agmtAtchDataVOs, AgmtAtchDataVO agmtAtchDataVO, SignOnUserAccount account) throws EventException {
		int insCnt = 0;
		try {
			
			
			List<AgmtAtchDataVO> list = new ArrayList<AgmtAtchDataVO>();
			
			if(agmtAtchDataVO != null) {
				dbDao.removeAgreementAttachInfoListData(agmtAtchDataVO);
			}
			
			if(agmtAtchDataVOs != null){
				
				for(int i=0; i<agmtAtchDataVOs.length; i++){
					agmtAtchDataVOs[i].setAgmtOfcCtyCd(agmtAtchDataVO.getAgmtOfcCtyCd());
					agmtAtchDataVOs[i].setAgmtSeq(agmtAtchDataVO.getAgmtSeq());
					agmtAtchDataVOs[i].setAgmtVerNo(agmtAtchDataVO.getAgmtVerNo());
					agmtAtchDataVOs[i].setCreUsrId(account.getUsr_id());
					agmtAtchDataVOs[i].setUpdUsrId(account.getUsr_id());
					
					list.add(agmtAtchDataVOs[i]);
				}
//				log.debug("\n111111-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="+list.toString());
				if(list.size() > 0)
					insCnt = dbDao.addAgreementAttachInfoListData(list);
				
			} 
			
			if(insCnt > 0) { // insert 건수가 있으면 MNR_AGMT_HDR.FILE_ATCH_FLG를 Y로
				dbDao.modifyAgreementHdrInfoListData(agmtAtchDataVO, "Y");
			} else {	// insert 건수가 없으면 MNR_AGMT_HDR.FILE_ATCH_FLG를 N으로
				dbDao.modifyAgreementHdrInfoListData(agmtAtchDataVO, "N");
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[M&R Agreement Attach Save] manageAgreementAttachInfoBasic"}).getMessage(),ex);
		}
		return insCnt;
	}
}