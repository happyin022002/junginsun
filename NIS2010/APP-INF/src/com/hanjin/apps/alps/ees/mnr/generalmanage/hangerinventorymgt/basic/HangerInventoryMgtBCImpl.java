/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtBCImpl.java
*@FileTitle : Hanger Bar Inventory List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.15 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.basic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.integration.HangerInventoryMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomHangerInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomNewHangerInventoryListVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.integration.EQFlagMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**   
 * alps-GeneralManage Business Logic Basic Command implementation<br>
 * - alps-GeneralManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author HyungSeok Ham
 * @see UI_MNR_0110EventResponse,HangerInventoryMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class HangerInventoryMgtBCImpl extends BasicCommandSupport implements HangerInventoryMgtBC {

	// Database Access Object
	private transient HangerInventoryMgtDBDAO dbDao = null;
	private transient EQFlagMgtDBDAO dbDao2 = null; 	

	/**
	 * HangerInventoryMgtBCImpl 객체 생성<br>
	 * HangerInventoryMgtDBDAO 생성한다.<br>
	 */
	public HangerInventoryMgtBCImpl() {	
		dbDao = new HangerInventoryMgtDBDAO();
		dbDao2 = new EQFlagMgtDBDAO();
	}
	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException {
		try {
			hangerInventoryListGRPVO.getHangerInventoryListINVO().setUserOfcCd(account.getOfc_cd());
			List<CustomHangerInventoryListVO> customHangerInventoryListVOs = dbDao.searchHangerInventoryListData(hangerInventoryListGRPVO.getHangerInventoryListINVO());
			hangerInventoryListGRPVO.setCustomHangerInventoryListVOs(customHangerInventoryListVOs);
			
			return hangerInventoryListGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0110] searchHangerInventoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0110] searchHangerInventoryListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0110]Hanger Bar Inventory List의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHangerInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException {
		try {
			CustomHangerInventoryListVO[] customHangerInventoryListVOS = hangerInventoryListGRPVO.getArrCustomHangerInventoryListVOs();
			if(customHangerInventoryListVOS == null) return;
			
			for ( int i=0; i< customHangerInventoryListVOS.length; i++ ) { 
				if(customHangerInventoryListVOS[i] == null) break;
				
				customHangerInventoryListVOS[i].setCreUsrId(account.getUsr_id());
				customHangerInventoryListVOS[i].setUpdUsrId(account.getUsr_id());		

				if ( customHangerInventoryListVOS[i].getIbflag().equals("D")){
					dbDao.removeHangerInventoryData(customHangerInventoryListVOS[i]);
				} else {
					
					CustomHangerInventoryListVO customMnrHngrInvtVO = dbDao.searchHangerInventoryData(customHangerInventoryListVOS[i]);
					
					if(customMnrHngrInvtVO == null) {
						customHangerInventoryListVOS[i].setHngrInvtVerNo("1");
						customHangerInventoryListVOS[i].setInvtQty("0");
						customHangerInventoryListVOS[i].setActInvtQty("0");
						customHangerInventoryListVOS[i].setCsmQty("0");
						customHangerInventoryListVOS[i].setMnrHngrDmgQty("0");
						customHangerInventoryListVOS[i].setPurQty("0");
						customHangerInventoryListVOS[i].setRcvrQty("0");
					} else {
						if(customHangerInventoryListVOS[i].getInvtRmk().equals("") || customHangerInventoryListVOS[i].getInvtRmk() == null || customMnrHngrInvtVO.getInvtRmk().equals(customHangerInventoryListVOS[i].getInvtRmk())){
							customHangerInventoryListVOS[i].setInvtRmk("By Hanger Bar Inventory  ID:" + account.getUsr_id());
						}
						customHangerInventoryListVOS[i].setHngrInvtVerNo(String.valueOf(Integer.parseInt(customMnrHngrInvtVO.getHngrInvtVerNo())+1));
					}	
					dbDao.modifyHangerInventoryData(customHangerInventoryListVOS[i]);
					dbDao.addHangerInventoryData(customHangerInventoryListVOS[i]);		
				}
			}   
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0110] manageHangerInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0110] manageHangerInventoryBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0113]Hanger Bar Inventory List의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchNewHangerInventoryListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException {
		try {
			hangerInventoryListGRPVO.getHangerInventoryListINVO().setUserOfcCd(account.getOfc_cd());
			List<CustomNewHangerInventoryListVO> customNewHangerInventoryListVOs = dbDao.searchNewHangerInventoryListData(hangerInventoryListGRPVO.getHangerInventoryListINVO());
			hangerInventoryListGRPVO.setCustomNewHangerInventoryListVOs(customNewHangerInventoryListVOs);
			
			return hangerInventoryListGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0113] searchNewHangerInventoryListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0113] searchNewHangerInventoryListBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0113]Hanger Bar Inventory List의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNewHangerInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException {
		try {
			CustomNewHangerInventoryListVO[] customNewHangerInventoryListVOS = hangerInventoryListGRPVO.getArrCustomNewHangerInventoryListVOs();
			if(customNewHangerInventoryListVOS == null) return;
			
			// 이전달 정보를 가져옮 yyyyMM 형태
			String toMonth = DateTime.getFormatDate(DateTime.getDateString(), "yyyy.MM.dd", "yyyyMM");

			for ( int i=0; i< customNewHangerInventoryListVOS.length; i++ ) { 
				if(customNewHangerInventoryListVOS[i] == null) break;
				
				customNewHangerInventoryListVOS[i].setUpdUsrId(account.getUsr_id());
				
				
				String[] monthArray = getHangerMonths(customNewHangerInventoryListVOS[i].getInvtYrmon(), toMonth);
				
				for(int j=0; j<monthArray.length; j++){
					customNewHangerInventoryListVOS[i].setInvtYrmon(monthArray[j]);
					
					if(j==0){	// 첫달은 현재 추가된 각 항목만 UPDATE
						dbDao.modifyNewHangerInventoryData(customNewHangerInventoryListVOS[i]);
					} else {	// 다음달 부터 이전달 데이터에 현재 데이터 계산
						dbDao.modifyNewHangerInventoryDataForNextMonth(customNewHangerInventoryListVOS[i]);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0113] manageNewHangerInventoryBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0113] manageNewHangerInventoryBasic"}).getMessage(),ex);
		}
	}

	/**
	 * [EES_MNR_0224]Hanger Bar Inventory History Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @return HangerInventoryListGRPVO
	 * @exception EventException
	 */
	public HangerInventoryListGRPVO searchHangerInventoryDetailListBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException {
		try {
			hangerInventoryListGRPVO.getHangerInventoryListINVO().setUserOfcCd(account.getOfc_cd());
			List<CustomHangerInventoryListVO> customHangerInventoryListVOs = dbDao.searchHangerInventoryDetailListData(hangerInventoryListGRPVO.getHangerInventoryListINVO());
			hangerInventoryListGRPVO.setCustomHangerInventoryListVOs(customHangerInventoryListVOs);
			
			return hangerInventoryListGRPVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0224] searchHangerInventoryDetailListBasic"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[EES_MNR_0224] searchHangerInventoryDetailListBasic"}).getMessage(),ex);
		}
	}
	
	/**
	 * [EES_MNR_0058] Hanger Bar Inventory 의 정보를 추가/수정 합니다. <br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */ 
	public void manageHangerInventoryEqStsBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			CustomMnrEqStsVO[] customMnrEqStsVOS = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();
			
			for ( int i=0; i< customMnrEqStsVOS.length; i++ ) { 
				//HANGER BAR PURCHING 인벤토리 계산 
				if(customMnrEqStsVOS[i].getCostDtlCd().equals("M1") || customMnrEqStsVOS[i].getCostDtlCd().equals("MD")){
					String offerInfoStr = customMnrEqStsVOS[i].getMnrHngrDtlOffrDesc();
					
					//OFFER OFFICE가 여러건
					if(offerInfoStr.indexOf("|") != -1){
						String[] offerInfoArr  = offerInfoStr.split("\\|");
						
						for (int x = 0; x < offerInfoArr.length; x++) {	
							String[] offerInfo = offerInfoArr[x].trim().split("=");
							
							CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
							customHangerInventoryListVO.setOfcCd(offerInfo[0]);   										//OFC_CD
							customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
							
							CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
							if(preCustomHangerInventoryListVO == null) {
								preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
								preCustomHangerInventoryListVO.setOfcCd(offerInfo[0]); 
								preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
								preCustomHangerInventoryListVO.setRcvrQty("0");
								preCustomHangerInventoryListVO.setActInvtQty("0");
								preCustomHangerInventoryListVO.setPurQty("0");
								preCustomHangerInventoryListVO.setCsmQty("0");
								preCustomHangerInventoryListVO.setInvtQty("0");
								preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
								preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
								preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
							}
							preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
							preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
							String remarkStr = "";
							if(customMnrEqStsVOS[i].getCostDtlCd().equals("M1")){
								remarkStr = "Hanger Bar(Square) Purchasing ," + offerInfo[1];
							} else {
								remarkStr = "Hanger Bar(Round) Purchasing(511511) ," + offerInfo[1];
							}
							
							//이전 보유량 
							int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
							//구매 
							//2011-03-09  PurQty "0"으로 강제 셋팅   -> 정필성 차장님 요청
							//int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
							int purQty = Integer.parseInt("0");
							//소비 
							int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
							//사운드 
							int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
							//데미지 
							int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
							//분실 
							int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
							//매각대상
							int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							//WO 삭제 
							if(customMnrEqStsVOS[i].getMnrStsRmk().indexOf("DELETE") != -1){
								purQty = purQty - Integer.parseInt(offerInfo[1]);
								remarkStr = customMnrEqStsVOS[i].getMnrStsRmk();
							//WO 생성 
							} else {
								purQty = purQty + Integer.parseInt(offerInfo[1]);
							}
							
							preCustomHangerInventoryListVO.setInvtRmk(remarkStr);
							
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	 						
							
							//preCustomHangerInventoryListVO.setPurQty(String.valueOf(purQty));
							preCustomHangerInventoryListVO.setPurQty(String.valueOf("0"));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));

							//2011-03-09 -> 정필성 차장님 요청 [MNR_HNGR_INVT] 인터페이스 안하게...
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
						}	
					//OFFER OFFICE가 단건 
					} else {
						String[] offerInfo = offerInfoStr.split("=");
						CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
						customHangerInventoryListVO.setOfcCd(offerInfo[0]);   										//OFC_CD
						customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
						
						CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
						if(preCustomHangerInventoryListVO == null) {
							preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
							preCustomHangerInventoryListVO.setOfcCd(offerInfo[0]);   										//OFC_CD
							preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
							preCustomHangerInventoryListVO.setRcvrQty("0");
							preCustomHangerInventoryListVO.setActInvtQty("0");
							preCustomHangerInventoryListVO.setPurQty("0");
							preCustomHangerInventoryListVO.setCsmQty("0");
							preCustomHangerInventoryListVO.setInvtQty("0");
							preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
							preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
							preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
						}
						preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
						preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
						String remarkStr = "";
						if(customMnrEqStsVOS[i].getCostDtlCd().equals("M1")){
							remarkStr = "Hanger Bar(Square) Purchasing ," + offerInfo[1];
						} else {
							remarkStr = "Hanger Bar(Round) Purchasing(511511) ," + offerInfo[1];
						}
						preCustomHangerInventoryListVO.setInvtRmk(remarkStr);
						
						//이전 보유량 
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						//구매 
						//2011-03-09  PurQty "0"으로 강제 셋팅   -> 정필성 차장님 요청
						//int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
						int purQty = Integer.parseInt("0");
						//소비 
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						//사운드 
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						//데미지 
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						//분실 
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
						//매각대상
						int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
						//WO 삭제 	
						if(customMnrEqStsVOS[i].getMnrStsRmk().indexOf("DELETE") != -1){
							purQty = purQty - Integer.parseInt(offerInfo[1]);
							remarkStr = customMnrEqStsVOS[i].getMnrStsRmk();
						//WO 생성 
						} else {		
							purQty = purQty + Integer.parseInt(offerInfo[1]);
						}
						
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	 						
						
						//preCustomHangerInventoryListVO.setPurQty(String.valueOf(purQty));
						preCustomHangerInventoryListVO.setPurQty(String.valueOf("0"));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));

						//2011-03-09 -> 정필성 차장님 요청 [MNR_HNGR_INVT] 인터페이스 안하게...
						dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
						dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
					}
					
				//WO 설치 제거 삭제시 인벤토리 계산 	
				} else if(customMnrEqStsVOS[i].getCostDtlCd().equals("RMH")){
					CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
					customHangerInventoryListVO.setOfcCd(account.getOfc_cd());
					customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
					CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
					if(preCustomHangerInventoryListVO == null) {
						preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
						preCustomHangerInventoryListVO.setOfcCd(account.getOfc_cd());   							   //OFC_CD
						preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
						preCustomHangerInventoryListVO.setRcvrQty("0");	
						preCustomHangerInventoryListVO.setActInvtQty("0");
						preCustomHangerInventoryListVO.setPurQty("0");
						preCustomHangerInventoryListVO.setCsmQty("0");
						preCustomHangerInventoryListVO.setInvtQty("0");
						preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
						preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
						preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
					}	
					preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
					preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
					preCustomHangerInventoryListVO.setInvtRmk(customMnrEqStsVOS[i].getMnrStsRmk());
					preCustomHangerInventoryListVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
					
					//이전 보유량 
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					//구매 
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					//소비 
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					//사운드 
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					//데미지 
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					//분실 
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					//매각대상
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
					//설치 WO 삭제시 
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){	
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
							
					//제거 WO 삭제시 	
					} else {
						soundQty   = soundQty - Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));
						preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));
						preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
					}
					dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
					dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
				
				//Hanger Bar 설치,제거 인벤토리 계산 	
				} else {	
					CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
					customHangerInventoryListVO.setOfcCd(account.getOfc_cd());
					customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
					
					CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
					if(preCustomHangerInventoryListVO == null) {
						preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
						preCustomHangerInventoryListVO.setOfcCd(account.getOfc_cd());	 	  								   //OFC_CD
						preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
						preCustomHangerInventoryListVO.setRcvrQty("0");	
						preCustomHangerInventoryListVO.setActInvtQty("0");
						preCustomHangerInventoryListVO.setPurQty("0");
						preCustomHangerInventoryListVO.setCsmQty("0");
						preCustomHangerInventoryListVO.setInvtQty("0");
						preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
						preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
						preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
					}	
					preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
					preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
					preCustomHangerInventoryListVO.setInvtRmk(customMnrEqStsVOS[i].getMnrStsRmk());
					preCustomHangerInventoryListVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
					
					//이전 보유량 
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					//구매 
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					//소비 
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					//사운드 
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					//데미지 
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					//분실 
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					//매각대상
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
					//설치 	
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){		
						csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						
						preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
						
					//제거	
					} else {
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));
						preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));
						preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
					}			
					dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
					dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
				}			
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Inventory] manageHangerInventoryBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Inventory] manageHangerInventoryBasic"}).getMessage(),de);
		} 
	}
	
	/**
	 * [EES_MNR_0109] Hanger Bar Inventory 의 정보를 추가/수정 합니다. <br>
	 * manageHangerRackBarManualInventoryBasic		
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account		
	 * @exception EventException
	 */ 
	public void manageHangerRackBarManualInventoryBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			CustomMnrEqStsVO[] customMnrEqStsVOS = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();
				
			for ( int i=0; i< customMnrEqStsVOS.length; i++ ) {
				
				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setEqList(customMnrEqStsVOS[i].getEqNo());
				
				//Modify 의 Inventory 처리
				if(customMnrEqStsVOS[i].getMnrHngrFlg().equalsIgnoreCase(customMnrEqStsVOS[i].getMnrStsFlg())){
					//최신 데이타로 조회
					CustomMnrEqStsVO customMnrEqStsVO = dbDao2.searchHangerEQFlagListData(eQFlagListINVO);
					
					//설치 Modify
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){
						//Install 원본  customMnrEqStsVO ( -처리한다.)
						CustomHangerInventoryListVO inCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
						inCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());
						inCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());    //HngrBarTpCd
						CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(inCustomHangerInventoryListVO);
						if(preCustomHangerInventoryListVO == null) {
							preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
							preCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());	 	  								   //OFC_CD
							preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());    //HngrBarTpCd
							preCustomHangerInventoryListVO.setRcvrQty("0");	
							preCustomHangerInventoryListVO.setActInvtQty("0");
							preCustomHangerInventoryListVO.setPurQty("0");
							preCustomHangerInventoryListVO.setCsmQty("0");
							preCustomHangerInventoryListVO.setInvtQty("0");
							preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
							preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
							preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
						}	
						preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
						preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
						preCustomHangerInventoryListVO.setEqNo(customMnrEqStsVO.getEqNo());
						
						//이전 보유량 
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						//구매 
						int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
						//소비 
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						//사운드 
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						//데미지 
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						//분실 
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
						//매각대상
						int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
						csmQty = csmQty - Integer.parseInt(customMnrEqStsVO.getHngrBarAtchKnt());				
						
						//HngrBarTpCd 이 변하지 않은 경우 
						if(customMnrEqStsVO.getMnrHngrBarTpCd().equals(customMnrEqStsVOS[i].getMnrHngrBarTpCd())){
							csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAmdQty());	
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	
							
							preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							preCustomHangerInventoryListVO.setInvtRmk("Manual Installation Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + customMnrEqStsVO.getHngrBarAtchKnt() + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() + " : " +
									customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
						//HngrBarTpCd 이 변한 경우	
						} else {
							preCustomHangerInventoryListVO.setInvtRmk("Manual Installation Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + customMnrEqStsVO.getHngrBarAtchKnt() + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() + " : " +
									customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
							
							//HngrBarTpCd 틀림 에 따른 로직 다시 시작	
							//Install 변경  customMnrEqStsVOS[i] ( +처리한다.)
							CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
							customHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());
							customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
							CustomHangerInventoryListVO modifyCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
							if(modifyCustomHangerInventoryListVO == null) {
								modifyCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
								modifyCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());	 	  								   //OFC_CD
								modifyCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
								modifyCustomHangerInventoryListVO.setRcvrQty("0");					
								modifyCustomHangerInventoryListVO.setActInvtQty("0");			
								modifyCustomHangerInventoryListVO.setPurQty("0");
								modifyCustomHangerInventoryListVO.setCsmQty("0");
								modifyCustomHangerInventoryListVO.setInvtQty("0");
								modifyCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
								modifyCustomHangerInventoryListVO.setMnrLostHngrQty("0");
								modifyCustomHangerInventoryListVO.setMnrDispHngrQty("0");
							}	
							modifyCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
							modifyCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
							modifyCustomHangerInventoryListVO.setEqNo(customMnrEqStsVO.getEqNo());
							
							//이전 보유량 
							rcvrQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getRcvrQty());
							//구매 
							purQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getPurQty());
							//소비 
							csmQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getCsmQty());
							//사운드 
							soundQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getActInvtQty());
							//데미지 
							dmgQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrHngrDmgQty());
							//분실 
							lostQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrLostHngrQty());
							//매각대상
							dispQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAmdQty());		
							
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							
							modifyCustomHangerInventoryListVO.setInvtRmk("Manual Installation Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + customMnrEqStsVO.getHngrBarAtchKnt() + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() + " : " +
									customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							modifyCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
							modifyCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
							
							dbDao.modifyHangerInventoryData(modifyCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(modifyCustomHangerInventoryListVO); 
						}
					//Removal Modify	
					} else {
						//Removal 원본  customMnrEqStsVO ( -처리한다.)	
						CustomHangerInventoryListVO inCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
						inCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());
						inCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());    //HngrBarTpCd
						CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(inCustomHangerInventoryListVO);
						if(preCustomHangerInventoryListVO == null) {
							preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
							preCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());	 	  								   //OFC_CD
							preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());    //HngrBarTpCd
							preCustomHangerInventoryListVO.setRcvrQty("0");	
							preCustomHangerInventoryListVO.setActInvtQty("0");
							preCustomHangerInventoryListVO.setPurQty("0");
							preCustomHangerInventoryListVO.setCsmQty("0");
							preCustomHangerInventoryListVO.setInvtQty("0");
							preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
							preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
							preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
						}	
						preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
						preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());	  
						preCustomHangerInventoryListVO.setEqNo(customMnrEqStsVO.getEqNo());
									
						//이전 보유량 
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						//구매 
						int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
						//소비 
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						//사운드 
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						//데미지 
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						//분실 
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
						//매각대상
						int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
						preCustomHangerInventoryListVO.setInvtRmk("Manual Removal Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
								" : " + Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + "," +
										Integer.parseInt(customMnrEqStsVO.getMnrHngrDmgQty()) + "," +
										Integer.parseInt(customMnrEqStsVO.getMnrLostHngrQty()) + "," +
										Integer.parseInt(customMnrEqStsVO.getMnrDispHngrQty()) + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() +
								" : " + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) + "," +		
										Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty()) + "," +
										Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty()) + "," +
										Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty()) +
								" [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
						
						//제거 갯수 다시 원복
						soundQty = soundQty - Integer.parseInt(customMnrEqStsVO.getActInvtQty());
						dmgQty = dmgQty - Integer.parseInt(customMnrEqStsVO.getMnrHngrDmgQty());
						lostQty = lostQty - Integer.parseInt(customMnrEqStsVO.getMnrLostHngrQty());
						dispQty = dispQty - Integer.parseInt(customMnrEqStsVO.getMnrDispHngrQty());
						
						//HngrBarTpCd 이 변하지 않은 경우 
						if(customMnrEqStsVO.getMnrHngrBarTpCd().equals(customMnrEqStsVOS[i].getMnrHngrBarTpCd())){
							soundQty = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
							dmgQty = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							lostQty = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
							dispQty = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							
							preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
							preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));	
							preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));	
							preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
						//HngrBarTpCd 이 변한 경우	
						} else {
							preCustomHangerInventoryListVO.setInvtRmk("Manual Removal Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() +
									" : " + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) + "," +		
											Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) +
									" [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
								
							preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
							preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));	
							preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));	
							preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
							
							//Removal 변경  customMnrEqStsVOS[i] ( +처리한다.)
							CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
							customHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());
							customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
							CustomHangerInventoryListVO modifyCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
							if(modifyCustomHangerInventoryListVO == null) {
								modifyCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
								modifyCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());	 	  								   //OFC_CD
								modifyCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
								modifyCustomHangerInventoryListVO.setRcvrQty("0");													
								modifyCustomHangerInventoryListVO.setActInvtQty("0");				
								modifyCustomHangerInventoryListVO.setPurQty("0");	
								modifyCustomHangerInventoryListVO.setCsmQty("0");
								modifyCustomHangerInventoryListVO.setInvtQty("0");	
								modifyCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
								modifyCustomHangerInventoryListVO.setMnrLostHngrQty("0");
								modifyCustomHangerInventoryListVO.setMnrDispHngrQty("0");
							}	
							modifyCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
							modifyCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
							modifyCustomHangerInventoryListVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
							modifyCustomHangerInventoryListVO.setInvtRmk("Manual Removal Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() + 
									" : " + Integer.parseInt(customMnrEqStsVO.getActInvtQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getMnrHngrDmgQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getMnrLostHngrQty()) + "," +
											Integer.parseInt(customMnrEqStsVO.getMnrDispHngrQty()) + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() +
									" : " + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty()) + "," +		
											Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty()) + "," +
											Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty()) + "," +
											Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty()) +
									" [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							//이전 보유량 
							rcvrQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getRcvrQty());
							//구매 
							purQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getPurQty());
							//소비 
							csmQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getCsmQty());
							//사운드 
							soundQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getActInvtQty());
							//데미지 
							dmgQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrHngrDmgQty());
							//분실 
							lostQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrLostHngrQty());
							//매각대상
							dispQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							//제거 갯수 다시 제거						
							soundQty = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
							dmgQty = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							lostQty = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
							dispQty = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
								
							//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
							invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							
							modifyCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
							modifyCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));	
							modifyCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));	
							modifyCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
							modifyCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
								
							dbDao.modifyHangerInventoryData(modifyCustomHangerInventoryListVO);		
							dbDao.addHangerInventoryData(modifyCustomHangerInventoryListVO);	 
						}
					}
				//일반 설치 제거의 Inventory 계산 
				} else {
					//HANGER BAR PURCHING 인벤토리 계산 	
					CustomHangerInventoryListVO customHangerInventoryListVO = new CustomHangerInventoryListVO();
					customHangerInventoryListVO.setOfcCd(account.getOfc_cd());
					customHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
					CustomHangerInventoryListVO preCustomHangerInventoryListVO = dbDao.searchHangerInventoryData(customHangerInventoryListVO);
					if(preCustomHangerInventoryListVO == null) {	
						preCustomHangerInventoryListVO = new CustomHangerInventoryListVO();
						preCustomHangerInventoryListVO.setOfcCd(customMnrEqStsVOS[i].getCreOfcCd());			 	  								   //OFC_CD
						preCustomHangerInventoryListVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());    //HngrBarTpCd
						preCustomHangerInventoryListVO.setRcvrQty("0");		
						preCustomHangerInventoryListVO.setActInvtQty("0");	
						preCustomHangerInventoryListVO.setPurQty("0");
						preCustomHangerInventoryListVO.setCsmQty("0");
						preCustomHangerInventoryListVO.setInvtQty("0");
						preCustomHangerInventoryListVO.setMnrHngrDmgQty("0");
						preCustomHangerInventoryListVO.setMnrLostHngrQty("0");
						preCustomHangerInventoryListVO.setMnrDispHngrQty("0");
					}	
					preCustomHangerInventoryListVO.setCreUsrId(account.getUsr_id()); 
					preCustomHangerInventoryListVO.setUpdUsrId(account.getUsr_id());  
					preCustomHangerInventoryListVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
					
					//이전 보유량 
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					//구매 
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					//소비 
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					//사운드 
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					//데미지 
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					//분실 
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					//매각대상
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
					
					//설치 	
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){		
						csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						
						preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
						preCustomHangerInventoryListVO.setInvtRmk("Manual Installation " + customMnrEqStsVOS[i].getHngrBarAtchKnt() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
						
					//제거	
					} else {	
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
						//토탈 계산식 Purchase Qty -Supply(소비)+Collection Qty(Sound+Damage)-Missing Qty(Missing + Disposal) + 이전 Inventory
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
								
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));
						preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));
						preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));		
						preCustomHangerInventoryListVO.setInvtRmk("Manual Remove Sound :" + customMnrEqStsVOS[i].getActInvtQty() +
																			   " Demage :" + customMnrEqStsVOS[i].getMnrHngrDmgQty() +
																			   " Lost :" + customMnrEqStsVOS[i].getMnrLostHngrQty() +
																			   " Disposal :" + customMnrEqStsVOS[i].getMnrDispHngrQty() +
								" Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
					}			
					dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
					dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Inventory] manageHangerInventoryBasic"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("MNR00001", new String[]{"[Hanger Bar Inventory] manageHangerInventoryBasic"}).getMessage(),de);
		} 
	}

	/**
	 * Hanger Bar Inventory에서 사용할 Month 계산 로직
	 * param으로 넘어온 month ~ 이번달 까지 월정보를 Array로 리턴한다.
	 * @param month
	 * @param tomonth
	 * @return
	 * @throws Exception 
	 */
	private String[] getHangerMonths(String month, String toMonth) throws Exception{
		List<String> retArray = new ArrayList<String>();
		
		String startMonth = month+"01";
		String endMonth = toMonth+"01";
		
		int diff = DateTime.monthsBetween(startMonth, endMonth);
		
		System.out.println("DATE DIFF1 : " + diff);
		System.out.println("DATE DIFF2 : " + DateTime.monthsBetween(startMonth, endMonth));

		for(int i=0; i<=diff; i++){
			retArray.add(DateTime.addMonths(month, i, "yyyyMM"));
		}

		return (String[])retArray.toArray(new String[0]);
	}
}