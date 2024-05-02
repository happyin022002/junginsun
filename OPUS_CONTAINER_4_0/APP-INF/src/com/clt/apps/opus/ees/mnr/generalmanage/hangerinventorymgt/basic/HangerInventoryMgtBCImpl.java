/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryMgtBCImpl.java
*@FileTitle : Hanger Bar Inventory List
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.integration.HangerInventoryMgtDBDAO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.CustomHangerInventoryListVO;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration.EQFlagMgtDBDAO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-GeneralManage Business Logic Basic Command implementation<br>
 * - COM-GeneralManage disposing business logic<br>
 *
 * @author 
 * @see 	UI_MNR_0110EventResponse, HangerInventoryMgtBC, DAO Class
 * @since 	J2EE 1.4
 */
public class HangerInventoryMgtBCImpl extends BasicCommandSupport implements HangerInventoryMgtBC {

	// Database Access Object
	private transient HangerInventoryMgtDBDAO dbDao = null;
	private transient EQFlagMgtDBDAO dbDao2 = null;

	/**
	 * Constructor - Creating DAO object
	 */
	public HangerInventoryMgtBCImpl() {
		dbDao = new HangerInventoryMgtDBDAO();
		dbDao2 = new EQFlagMgtDBDAO();
	}

	/**
	 * [EES_MNR_0110]Retrieving "Hanger Bar Inventory List" data<br>
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
	 * [EES_MNR_0110]Adding, modifying, deleting "Hanger Bar Inventory List" data<br>
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
	 * [EES_MNR_0224]Retrieving "Hanger Bar Inventory History Pop Up" data<br>
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
	 * [EES_MNR_0058]Adding, modifying, deleting "Hanger Bar Inventory" data<br>
	 *
	 * @param HangerInventoryListGRPVO hangerInventoryListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHangerInventoryEqStsBasic(HangerInventoryListGRPVO hangerInventoryListGRPVO, SignOnUserAccount account) throws EventException{
		try {     
			CustomMnrEqStsVO[] customMnrEqStsVOS = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();
			
			for ( int i=0; i< customMnrEqStsVOS.length; i++ ) { 
				//Calculating HANGER BAR PURCHASING Inventory 
				if(customMnrEqStsVOS[i].getCostDtlCd().equals("M1") || customMnrEqStsVOS[i].getCostDtlCd().equals("MD")){
					String offerInfoStr = customMnrEqStsVOS[i].getMnrHngrDtlOffrDesc();
					
					//Splitting data "OFFER OFFICE"
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
							
							//Quantity of possess
							int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
							
							//Quantity of buy (default '0')
							int purQty = Integer.parseInt("0");
							int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
							int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
							int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
							int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
							int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							//Deleting "WO" 
							if(customMnrEqStsVOS[i].getMnrStsRmk().indexOf("DELETE") != -1){
								purQty = purQty - Integer.parseInt(offerInfo[1]);
								remarkStr = customMnrEqStsVOS[i].getMnrStsRmk();
							//Adding "WO"
							} else {
								purQty = purQty + Integer.parseInt(offerInfo[1]);
							}
							
							preCustomHangerInventoryListVO.setInvtRmk(remarkStr);
							
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	 						
							
							//preCustomHangerInventoryListVO.setPurQty(String.valueOf(purQty));
							preCustomHangerInventoryListVO.setPurQty(String.valueOf("0"));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));

							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
						}	
					//In case of "OFFER OFFICE" single data 
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
						
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						int purQty = Integer.parseInt("0");
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
						int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
						if(customMnrEqStsVOS[i].getMnrStsRmk().indexOf("DELETE") != -1){
							purQty = purQty - Integer.parseInt(offerInfo[1]);
							remarkStr = customMnrEqStsVOS[i].getMnrStsRmk();
						} else {		
							purQty = purQty + Integer.parseInt(offerInfo[1]);
						}
						
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	 						
						
						preCustomHangerInventoryListVO.setPurQty(String.valueOf("0"));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));

						dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
						dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
					}
					
				//Calculation in case of "WO" deleted
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
					
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());

					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){	
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
					} else {
						soundQty   = soundQty - Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty - Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
						
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
						preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));
						preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));
						preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));
					}
					dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
					dbDao.addHangerInventoryData(preCustomHangerInventoryListVO); 
				
				//Calculating Hanger Bar installed, removed 	
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
					
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
					//Installing
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){		
						csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						
						preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
						
					//Removing
					} else {
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
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
	 * [EES_MNR_0019]Adding, modifying, deleting "Hanger Rack & Bar Installation/Removal" data<br>
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
				
				if(customMnrEqStsVOS[i].getMnrHngrFlg().equalsIgnoreCase(customMnrEqStsVOS[i].getMnrStsFlg())){

					CustomMnrEqStsVO customMnrEqStsVO = dbDao2.searchHangerEQFlagListData(eQFlagListINVO);
					
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){
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
						
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
						int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
						
						csmQty = csmQty - Integer.parseInt(customMnrEqStsVO.getHngrBarAtchKnt());				
						
						if(customMnrEqStsVO.getMnrHngrBarTpCd().equals(customMnrEqStsVOS[i].getMnrHngrBarTpCd())){
							csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAmdQty());	

							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;	
							
							preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							preCustomHangerInventoryListVO.setInvtRmk("Manual Installation Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + customMnrEqStsVO.getHngrBarAtchKnt() + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() + " : " +
									customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
						} else {
							preCustomHangerInventoryListVO.setInvtRmk("Manual Installation Modify " + customMnrEqStsVO.getMnrHngrBarTpCd() +
									" : " + customMnrEqStsVO.getHngrBarAtchKnt() + " => " + customMnrEqStsVOS[i].getMnrHngrBarTpCd() + " : " +
									customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
							
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
							
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
							
							rcvrQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getRcvrQty());
							purQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getPurQty());
							csmQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getCsmQty());
							soundQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getActInvtQty());
							dmgQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrHngrDmgQty());
							lostQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrLostHngrQty());
							dispQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAmdQty());		
							
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
									
						int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
						int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
						int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
						int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
						int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
						int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
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
						
						soundQty = soundQty - Integer.parseInt(customMnrEqStsVO.getActInvtQty());
						dmgQty = dmgQty - Integer.parseInt(customMnrEqStsVO.getMnrHngrDmgQty());
						lostQty = lostQty - Integer.parseInt(customMnrEqStsVO.getMnrLostHngrQty());
						dispQty = dispQty - Integer.parseInt(customMnrEqStsVO.getMnrDispHngrQty());
						
						if(customMnrEqStsVO.getMnrHngrBarTpCd().equals(customMnrEqStsVOS[i].getMnrHngrBarTpCd())){
							soundQty = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
							dmgQty = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							lostQty = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
							dispQty = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
							
							preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
							preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));	
							preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));	
							preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
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
							
							int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
								
							preCustomHangerInventoryListVO.setActInvtQty(String.valueOf(soundQty));
							preCustomHangerInventoryListVO.setMnrHngrDmgQty(String.valueOf(dmgQty));	
							preCustomHangerInventoryListVO.setMnrLostHngrQty(String.valueOf(lostQty));	
							preCustomHangerInventoryListVO.setMnrDispHngrQty(String.valueOf(dispQty));	
							preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
							
							dbDao.modifyHangerInventoryData(preCustomHangerInventoryListVO); 
							dbDao.addHangerInventoryData(preCustomHangerInventoryListVO);
							
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
							
							rcvrQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getRcvrQty());
							purQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getPurQty());
							csmQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getCsmQty());
							soundQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getActInvtQty());
							dmgQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrHngrDmgQty());
							lostQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrLostHngrQty());
							dispQty = Integer.parseInt(modifyCustomHangerInventoryListVO.getMnrDispHngrQty());
							
							soundQty = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
							dmgQty = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							lostQty = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
							dispQty = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
								
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
				} else {
					//Calculating HANGER BAR PURCHASING inventory 	
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
					
					int rcvrQty = Integer.parseInt(preCustomHangerInventoryListVO.getRcvrQty());
					int purQty = Integer.parseInt(preCustomHangerInventoryListVO.getPurQty());
					int csmQty = Integer.parseInt(preCustomHangerInventoryListVO.getCsmQty());
					int soundQty = Integer.parseInt(preCustomHangerInventoryListVO.getActInvtQty());
					int dmgQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrHngrDmgQty());
					int lostQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrLostHngrQty());
					int dispQty = Integer.parseInt(preCustomHangerInventoryListVO.getMnrDispHngrQty());
					
					//Installing 	
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){		
						csmQty = csmQty + Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						
						int invtQty = purQty - csmQty + (soundQty + dmgQty) - (lostQty + dispQty) + rcvrQty;
						
						preCustomHangerInventoryListVO.setCsmQty(String.valueOf(csmQty));
						preCustomHangerInventoryListVO.setInvtQty(String.valueOf(invtQty));	
						preCustomHangerInventoryListVO.setInvtRmk("Manual Installation " + customMnrEqStsVOS[i].getHngrBarAtchKnt() + " Qty [" + customMnrEqStsVOS[i].getCreOfcCd() + "] [" + account.getUsr_id() + "]");
						
					//Removing
					} else {	
						soundQty   = soundQty + Integer.parseInt(customMnrEqStsVOS[i].getActInvtQty());
						dmgQty     = dmgQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrHngrDmgQty());
						lostQty    = lostQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrLostHngrQty());
						dispQty    = dispQty + Integer.parseInt(customMnrEqStsVOS[i].getMnrDispHngrQty());
							
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

}