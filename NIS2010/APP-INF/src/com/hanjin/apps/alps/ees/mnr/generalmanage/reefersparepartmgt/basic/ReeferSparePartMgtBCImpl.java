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
package com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.event.EesMnr0267Event;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.integration.ReeferSparePartMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrReeferSparePartCodeVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.MnrVslSprPrtInvtVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartCodeMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFSparePartInventoryMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.reefersparepartmgt.vo.RFVessleSparePartCodeVO;
import com.hanjin.apps.alps.esd.tes.codemanage.codemanage.event.EsdTes0028Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.mysql.jdbc.StringUtils;
        
/**
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 권영법
 * @see Ees_mnr_0009EventResponse,CEDEXCodeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4   
 */         
    
public  class ReeferSparePartMgtBCImpl extends BasicCommandSupport implements ReeferSparePartMgtBC {

	// Database Access Object
	private transient ReeferSparePartMgtDBDAO dbDao = null; 

	private Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.generalmanage");
	
	/** 
	 * GeneralCodeMgtBCImpl 객체 생성<br>
	 * GeneralCodeMgtDBDAO를 생성한다.<br>
	 */    
	public ReeferSparePartMgtBCImpl() {  
		dbDao = new ReeferSparePartMgtDBDAO();
	}

	/**
	 * [EES_MNR_0214]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @return RFSparePartCodeMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartCodeMgtGRPVO searchRFsparePartCodeListBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO) throws EventException {
		try { 

			
			List<MnrReeferSparePartCodeVO> mnrReeferSparePartCodeVOS = null; 
			
			mnrReeferSparePartCodeVOS = dbDao.searchRFsparePartCodeListData(rfSparePartCodeMgtGRPVO.getRFSparePartCodeMgtINVO());
				
			rfSparePartCodeMgtGRPVO.setMnrReeferSparePartCodeVOs(mnrReeferSparePartCodeVOS);   
		
			
			return rfSparePartCodeMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0214] searchRFsparePartCodeListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0214] searchRFsparePartCodeListBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0137]Standard Reefer Spare Parts List of the vsl의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFsparePartCodeBasic(RFSparePartCodeMgtGRPVO rfSparePartCodeMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			
			MnrReeferSparePartCodeVO[] mnrReeferSparePartCodeVOS = rfSparePartCodeMgtGRPVO.getArrayMnrReeferSparePartCodeVOs(); 
		
			if(mnrReeferSparePartCodeVOS != null){
				List<MnrReeferSparePartCodeVO> insertVoList = new ArrayList<MnrReeferSparePartCodeVO>();
				List<MnrReeferSparePartCodeVO> updateVoList = new ArrayList<MnrReeferSparePartCodeVO>();
				List<MnrReeferSparePartCodeVO> deleteVoList = new ArrayList<MnrReeferSparePartCodeVO>(); 
					
				for ( int i=0; i<mnrReeferSparePartCodeVOS.length; i++ ) {
			
					if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("I")){
						mnrReeferSparePartCodeVOS[i].setCreUsrId(account.getUsr_id());
						mnrReeferSparePartCodeVOS[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(mnrReeferSparePartCodeVOS[i]);
					} else if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("U")){
						mnrReeferSparePartCodeVOS[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(mnrReeferSparePartCodeVOS[i]);
					} else if ( mnrReeferSparePartCodeVOS[i].getIbflag().equals("D")){
						deleteVoList.add(mnrReeferSparePartCodeVOS[i]);
					} 
				}  
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addRFsparePartCodeData(insertVoList);

				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyRFsparePartCodeData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeRFsparePartCodeData(deleteVoList);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0137] manageRFsparePartCodeBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0137] manageRFsparePartCodeBasic"}).getMessage(),ex);
		}
	}


	/**
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @return RFSparePartInventoryMgtGRPVO
	 * @exception EventException
	 */
	public RFSparePartInventoryMgtGRPVO searchRFSparePartInventoryListBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO) throws EventException {
		try { 

			
			List<RFSparePartInventoryListVO> rfSparePartInventoryListVOS = null; 
			rfSparePartInventoryListVOS = dbDao.searchRFSparePartInventoryListData(rfSparePartInventoryMgtGRPVO.getRFSparePartInventoryMgtINVO());

			rfSparePartInventoryMgtGRPVO.setRFSparePartInventoryListVOs(rfSparePartInventoryListVOS);   
		
			
			return rfSparePartInventoryMgtGRPVO;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] searchRFSparePartInventoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] searchRFSparePartInventoryListBasic"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0056]VSL Reefer Spare part Inventory의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRFSparePartInventoryBasic(RFSparePartInventoryMgtGRPVO rfSparePartInventoryMgtGRPVO, SignOnUserAccount account) throws EventException{
		try {
			
			RFSparePartInventoryListVO[] rfSparePartInventoryListVOS = rfSparePartInventoryMgtGRPVO.getArrayRFSparePartInventoryListVOs(); 
		
			if(rfSparePartInventoryListVOS != null){
				List<RFSparePartInventoryListVO> checkVoList = new ArrayList<RFSparePartInventoryListVO>();				
				List<RFSparePartInventoryListVO> insertVoList = new ArrayList<RFSparePartInventoryListVO>();
				List<RFSparePartInventoryListVO> updateVoList = new ArrayList<RFSparePartInventoryListVO>();
				List<RFSparePartInventoryListVO> deleteVoList = new ArrayList<RFSparePartInventoryListVO>(); 
	
				for ( int i=0; i<rfSparePartInventoryListVOS.length; i++ ) {
			
					if ( rfSparePartInventoryListVOS[i].getIbflag().equals("I")){
						rfSparePartInventoryListVOS[i].setCreUsrId(account.getUsr_id());
						rfSparePartInventoryListVOS[i].setUpdUsrId(account.getUsr_id());
						checkVoList.add(rfSparePartInventoryListVOS[i]);
						List<RFSparePartInventoryListVO> checkVos = dbDao.checkRFSparePartInventoryData(checkVoList);
						if(checkVos.size()<=0)
						{
							insertVoList.add(rfSparePartInventoryListVOS[i]);
						}

					} else if ( rfSparePartInventoryListVOS[i].getIbflag().equals("U")){
						rfSparePartInventoryListVOS[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(rfSparePartInventoryListVOS[i]);
					} else if ( rfSparePartInventoryListVOS[i].getIbflag().equals("D")){
						deleteVoList.add(rfSparePartInventoryListVOS[i]);
					} 
				}  
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addRFSparePartInventoryData(insertVoList);

				}
				
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyRFSparePartInventoryData(updateVoList);
				}
				
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeRFSparePartInventoryData(deleteVoList);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0056] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0266]VSL Reefer Spare part Vessel Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
	 * @exception EventException
	 * @return List<RFVessleSparePartCodeVO>
	 */
	public List<RFVessleSparePartCodeVO> searchVesselSparePartCodeList(RFVessleSparePartCodeVO rfSparePartVessleInventoryMgtVO) throws EventException{
		try { 

			return dbDao.searchVessleSparePartCodeListData(rfSparePartVessleInventoryMgtVO);
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] searchSparePartVessleCodeList"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] searchSparePartVessleCodeList"}).getMessage(),ex);
		}
		
	}
	
	/**
	 * [EES_MNR_0266]VSL Reefer Spare part Vessel Inventory의 정보를 추가/수정/삭제 합니다. <br>
	 * @param RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs
	 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageVslSprPrtCd(RFVessleSparePartCodeVO[] rfVessleSparePartCodeVOs, RFVessleSparePartCodeVO rfVessleSparePartCodeVO, SignOnUserAccount account) throws EventException{
		try {
			
			if(rfVessleSparePartCodeVOs != null) {							
				List<RFVessleSparePartCodeVO> insertVoList = new ArrayList<RFVessleSparePartCodeVO>();
				List<RFVessleSparePartCodeVO> updateVoList = new ArrayList<RFVessleSparePartCodeVO>();
				List<RFVessleSparePartCodeVO> deleteVoList = new ArrayList<RFVessleSparePartCodeVO>(); 				
				
				String newYn = "";
				String verSeq = "";
				
				if(!StringUtils.isNullOrEmpty(rfVessleSparePartCodeVO.getNewYn())) {
					newYn = rfVessleSparePartCodeVO.getNewYn();
				}
				
				verSeq = dbDao.searchNewVesselSparePartVer(); // 현재 ver seq 채번
				
				if(newYn.equals("Y") || verSeq.equals("0")) { // new 버튼 클릭시나 처음 등록시
					for( int i=0; i<rfVessleSparePartCodeVOs.length; i++ ) {
						RFVessleSparePartCodeVO vo = rfVessleSparePartCodeVOs[i];
						vo.setSprPrtVerSeq(Integer.toString(Integer.parseInt(verSeq) + 1)); 
						vo.setCreUsrId(account.getUsr_id());
						
						insertVoList.add(vo);	
												
					}
					
					if ( insertVoList.size() > 0 ) {
						dbDao.addVesselSparePartCdData(insertVoList);
					}
				}
				else {
					for( int i=0; i<rfVessleSparePartCodeVOs.length; i++ ) {
						RFVessleSparePartCodeVO vo = rfVessleSparePartCodeVOs[i];
						vo.setCreUsrId(account.getUsr_id());
											
						if ( vo.getIbflag().equals("I")){		
							vo.setSprPrtVerSeq(verSeq);
							insertVoList.add(vo);						
						} else if ( vo.getIbflag().equals("U")){	
							vo.setSprPrtDeltFlg("N");
							updateVoList.add(vo);						
						} else if ( vo.getIbflag().equals("D")){
							vo.setSprPrtDeltFlg("Y");
							deleteVoList.add(vo);
						} 
					}  
										
					if ( insertVoList.size() > 0 ) {
						dbDao.addVesselSparePartCdData(insertVoList);						
					}
					
					if ( updateVoList.size() > 0 ) {						
						dbDao.modifyVesselSparePartCdData(updateVoList);
					}
					
					if ( deleteVoList.size() > 0 ) {
						dbDao.modifyVesselSparePartCdData(deleteVoList);
					}					
				}
				
				
			}else{
				log.debug("rfSparePartVessleInventoryMgtVOs is null");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0067]VSL Reffer Spare part Vessel Inventory Header 목록 조회 <br>
	 * @param RFVessleSparePartCodeVO rfVessleSparePartCodeVO
	 * @param	SignOnUserAccount account
	 * @exception EventException
	 * @return List<RFVessleSparePartCodeVO>
	 */
	public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryHeaderList(
			MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO,
			SignOnUserAccount account) throws EventException{
		try {			
			List<MnrVslSprPrtInvtVO> vessleSparePartCodeVOs = null; 
			vessleSparePartCodeVOs = dbDao.searchVesselSparePartInventoryHeaderListData(mnrVslSprPrtInvtVO);

			return vessleSparePartCodeVOs;
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0067] searchVesselSparePartInventoryHeaderList"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0067] searchVesselSparePartInventoryHeaderList"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0268]Spare Part VSL Inventory Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO
	 * @exception EventException
	 * @return List<MnrVslSprPrtInvtVO>
	 */
	public List<MnrVslSprPrtInvtVO> searchVesselSparePartInventoryList(MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO) throws EventException{
		try { 
			return dbDao.searchVesselSparePartInventoryList(mnrVslSprPrtInvtVO);
			
		} catch (DAOException ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0268] searchVesselSparePartInventoryList"}).getMessage(),ex);
		} catch (Exception ex) {  
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0268] searchVesselSparePartInventoryList"}).getMessage(),ex);
		}		
	}
	
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory의 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @exception EventException
	 * @return EventResponse
	 */
	public EventResponse searchVesselInventoryList(Event e) throws EventException{
		EesMnr0267Event event = (EesMnr0267Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<MnrVslSprPrtInvtVO> rsVoList = new ArrayList<MnrVslSprPrtInvtVO>();
        try {
        	rsVoList = dbDao.searchVessleInventoryListDataByVOs(event.getMnrVslSprPrtInvtVO());
			
        	eventResponse.setRsVoList(rsVoList);
        	
        	if(rsVoList != null && rsVoList.size() > 0){
        		MnrVslSprPrtInvtVO vo = rsVoList.get(0);
        		eventResponse.setETCData("CRE_DT", vo.getCreDt());
    			eventResponse.setETCData("CRE_USR_ID", vo.getCreUsrId());
    			eventResponse.setETCData("INVENTORY_NO", vo.getSprPrtInvtNo());
    			eventResponse.setETCData("CD_VER_SEQ", vo.getSprPrtVerSeq());
        	}
        	return eventResponse;
            
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception ex) {
        	log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0067] searchVesselInventoryList"}).getMessage(),ex);
		}
	}
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory 의 정보를 추가/수정 합니다. <br>
	 * 삭제는 별도 처리
	 * 저장시 Inventory NO를 증가시킨다.
	 * @param MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs
	 * @param MnrVslSprPrtInvtVO
	 * @param account
	 * @exception EventException
	 * @return String
	 */
	public String manageVslInventoryCreation(
			MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs, MnrVslSprPrtInvtVO mnrVslSprPrtInvtVO, SignOnUserAccount account) throws EventException{
		String invtNo = "";
		try {
			log.debug("manage vsl");
			
			if(mnrVslSprPrtInvtVOs != null){			
				List<MnrVslSprPrtInvtVO> insertVoList = new ArrayList<MnrVslSprPrtInvtVO>();
				List<MnrVslSprPrtInvtVO> deleteVoList = new ArrayList<MnrVslSprPrtInvtVO>(); 
	
				// InvtNo가 있으면 해당 InvtNo의 version seq를 올려서 저장
				// INVTNO가 없으면 신규 INVTNO생성
				if( mnrVslSprPrtInvtVO != null){
					log.debug(mnrVslSprPrtInvtVO.toString());
				}
				
				String crntSprPrtInvtNo = "";//mnrVslSprPrtInvtVO.getSprPrtInvtNo();
				String newSprPrtInvtNo = "";
				String crntSprPrtInvtVerSeq = "";//mnrVslSprPrtInvtVO.getSprPrtInvtVerSeq();
				String crntSprPrtVerSeq = "";// Code의 Version seq
				// 새로운 Inventory No 생성
				MnrVslSprPrtInvtVO invtVO = new MnrVslSprPrtInvtVO();
				invtVO.setOfcCd(account.getOfc_cd());
				newSprPrtInvtNo = dbDao.checkVesselSparePartInventoryNo(invtVO);
				
							
				if( mnrVslSprPrtInvtVOs != null && mnrVslSprPrtInvtVOs.length > 0){
//					log.debug("vo length " + mnrVslSprPrtInvtVOs.length);
					// 현재 Invt No, Seq 가져욤
					for ( int i=0; i<mnrVslSprPrtInvtVOs.length; i++ ) {
						
						MnrVslSprPrtInvtVO tempVo = mnrVslSprPrtInvtVOs[i];
						
						if( tempVo.getSprPrtInvtNo() != null && !"".equals(tempVo.getSprPrtInvtNo()) ){
							crntSprPrtInvtNo = tempVo.getSprPrtInvtNo();
						}
						
						if( tempVo.getSprPrtInvtVerSeq() != null && !"".equals(tempVo.getSprPrtInvtVerSeq()) ){
							crntSprPrtInvtVerSeq = tempVo.getSprPrtInvtVerSeq();
						}
						
						if( tempVo.getSprPrtVerSeq() != null && !"".equals(tempVo.getSprPrtVerSeq()) ){
							crntSprPrtVerSeq = tempVo.getSprPrtVerSeq();
						}
						
						// 찹았으면 그만~
						if( crntSprPrtInvtNo != null && !"".equals(crntSprPrtInvtNo)
								&& crntSprPrtInvtVerSeq != null && !"".equals(crntSprPrtInvtVerSeq) ){
							break;
						}						
					}
					
					// insert 목록 설정
					for ( int i=0; i<mnrVslSprPrtInvtVOs.length; i++ ) {
						
						MnrVslSprPrtInvtVO vo = mnrVslSprPrtInvtVOs[i];
						if( "D".equals(vo.getIbflag())){
							vo.setSprPrtInvtNo(crntSprPrtInvtNo);						
							vo.setSprPrtInvtSeq(crntSprPrtInvtVerSeq);
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());
							deleteVoList.add(vo);
						}else{
							vo.setCreUsrId(account.getUsr_id());
							vo.setUpdUsrId(account.getUsr_id());
							if( "".equals(crntSprPrtInvtNo) && "".equals(crntSprPrtInvtVerSeq)){
								vo.setSprPrtInvtNo(newSprPrtInvtNo);						
								vo.setSprPrtInvtSeq(i+1 + "");
								vo.setSprPrtVerSeq(crntSprPrtVerSeq);
								invtNo = newSprPrtInvtNo;
							}else{
								vo.setSprPrtInvtNo(crntSprPrtInvtNo);
								vo.setSprPrtInvtVerSeq(crntSprPrtInvtVerSeq);
								vo.setSprPrtInvtSeq(i+1 + "");
								vo.setSprPrtVerSeq(crntSprPrtVerSeq);
								invtNo = crntSprPrtInvtNo;
							}
							insertVoList.add(vo);	
						}						
					}
					
					// 가져온 List가 모두 Delete면 해당 버전 삭제처리
					if( mnrVslSprPrtInvtVOs.length == deleteVoList.size()){
						dbDao.removeVesselSparePartInventoryData(deleteVoList);
					}
					// 새로운 data로 add
					if( insertVoList.size() > 0){						
						dbDao.addVesselSparePartInventoryData(insertVoList);
					}
				}
				
			}else{
				log.debug("rfSparePartVessleInventoryMgtVOs is null");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0067] manageVslInventoryCreation"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0067] manageVslInventoryCreation"}).getMessage(),ex);
		}
		return invtNo;
	}
	
	/**
	 * [EES_MNR_0067]VSL Reefer Spare part Vessel Inventory 의 정보를 삭제 합니다. <br>
	 * SPR_PRT_INVT_NO는 그대로 두고  SPR_PRT_INVT_VER_SEQ를 +1해서 저장
	 * @param MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs
	 * @param account
	 * @exception EventException
	 */
	public void removeVslInventoryCreation(
			MnrVslSprPrtInvtVO[] mnrVslSprPrtInvtVOs, SignOnUserAccount account) throws EventException{
		try {
			log.debug("manage vsl");
			if(mnrVslSprPrtInvtVOs != null){
				
				List<MnrVslSprPrtInvtVO> deleteVoList = new ArrayList<MnrVslSprPrtInvtVO>(); 
					
				if( mnrVslSprPrtInvtVOs != null && mnrVslSprPrtInvtVOs.length > 0){
						
					String crntSprPrtInvtNo = "";
					String crntInvtVerSeq = "";

					if(mnrVslSprPrtInvtVOs.length > 0){
						crntSprPrtInvtNo = mnrVslSprPrtInvtVOs[0].getSprPrtInvtNo();
						crntInvtVerSeq = mnrVslSprPrtInvtVOs[0].getSprPrtInvtVerSeq();
					}
					
					// 현재 seq를 update : del_flag = 'Y'로
					if( !"".equals(crntSprPrtInvtNo)){
						MnrVslSprPrtInvtVO deleteVo = new MnrVslSprPrtInvtVO();
						deleteVo.setSprPrtInvtNo(crntSprPrtInvtNo);						
						deleteVo.setSprPrtInvtVerSeq(crntInvtVerSeq);
						deleteVo.setUpdUsrId(account.getUsr_id());
						log.debug(deleteVo.toString());
						deleteVoList.add(deleteVo);
						dbDao.removeVesselSparePartInventoryData(deleteVoList);
					}
				}
			}else{
				log.debug("rfSparePartVessleInventoryMgtVOs is null");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0066] manageRFSparePartInventoryBasic"}).getMessage(),ex);
		}
	}
}