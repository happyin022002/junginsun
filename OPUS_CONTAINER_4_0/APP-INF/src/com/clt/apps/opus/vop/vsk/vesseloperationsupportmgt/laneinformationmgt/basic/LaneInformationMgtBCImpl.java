/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LaneInformationMgtBCImpl.java
*@FileTitle : Lane Information Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.integration.LaneInformationMgtDBDAO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.LaneInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusDeployedVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusVesselVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.StatusServiceVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.laneinformationmgt.vo.VskPortBnkRfuelRtoSheetVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.VskLanePicVO;
import com.clt.syscommon.common.table.VskPortBnkRfuelRtoVO;
/**
 * VesselOperationSupportMgt Business Logic Basic Command implementation<br>
 * - Handling business logic of VesselOperationSupportMgt<br>
 *
 * @author
 * @see VOP_OPF_0010EventResponse,LaneInformationMgtBC, DAO
 * @since J2EE 1.6
 */
public class LaneInformationMgtBCImpl extends BasicCommandSupport implements LaneInformationMgtBC {

	// Database Access Object
	private transient LaneInformationMgtDBDAO dbDao = null;

	/**
	 * LaneInformationMgtBCImpl object creation<br>
	 * Creating LaneInformationMgtDBDAO<br>
	 */
	public LaneInformationMgtBCImpl() {
		dbDao = new LaneInformationMgtDBDAO();
	}

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Group
	 * 
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLaneGroupList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchLaneGroupList(mdmVslSvcLaneVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Group"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying MDM VSL SVC LANE
	 * 
	 * Lane Group Setting
	 * @param mdmVslSvcLaneVO MdmVslSvcLaneVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyLaneGroupS(MdmVslSvcLaneVO[] mdmVslSvcLaneVO, SignOnUserAccount account) throws EventException{
		try {
			List<MdmVslSvcLaneVO> insertVoList = new ArrayList<MdmVslSvcLaneVO>();
			
			for ( int i=0; i< mdmVslSvcLaneVO.length; i++ ) {
				if ( mdmVslSvcLaneVO[i].getIbflag().equals("I")){
					mdmVslSvcLaneVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mdmVslSvcLaneVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyLaneGroupS(insertVoList);
			}
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Group"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Lane Group"}).getMessage(), ex);
		}
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Group
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> searchPicList(VskLanePicVO vskLanePicVO) throws EventException {
		try {
			return dbDao.searchPicList(vskLanePicVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"PicList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"PicList Search"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port Header
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchBunkeringPortHeader() throws EventException {
		try {
			return dbDao.searchBunkeringPortHeader();
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"BunkeringPortHeader Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"BunkeringPortHeader Search"}).getUserMessage(),ex);
		}
	}
	
	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port
	 * 
	 * @param VskLanePicVO vskLanePicVO
	 * @return List<VskPortBnkRfuelRtoSheetVO>
	 * @exception EventException
	 */
	public List<VskPortBnkRfuelRtoSheetVO> searchBunkeringPortList(VskLanePicVO vskLanePicVO) throws EventException {
		try {
			return dbDao.searchBunkeringPortList(vskLanePicVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"BunkeringPortList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"BunkeringPortList Search"}).getUserMessage(),ex);
		}
	}

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Bunkering Port
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusServiceVO>
	 * @exception EventException
	 */
	public List<StatusServiceVO> searchLaneStatusSearviceList(LaneInfoConditionVO vskLanePicVO) throws EventException {
		try {
			return dbDao.searchLaneStatusSearviceList(vskLanePicVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"StatusSearviceList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"StatusSearviceList Search"}).getUserMessage(),ex);
		}
	}	

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Status Deployed Vessel
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusDeployedVesselVO>
	 * @exception EventException
	 */
	public List<StatusDeployedVesselVO> searchLaneStatusDeployedVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException {
		try {
			return dbDao.searchLaneStatusDeployedVesselList(vskLanePicVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusDeployedVesselList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusDeployedVesselList Search"}).getUserMessage(),ex);
		}
	}	

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving Lane Status Owner Vessel
	 * 
	 * @param vskLanePicVO   VskLanePicVO
	 * @return List<StatusVesselVO>
	 * @exception EventException
	 */
	public List<StatusVesselVO> searchLaneStatusVesselList(LaneInfoConditionVO vskLanePicVO) throws EventException {
		try {
			return dbDao.searchLaneStatusVesselList(vskLanePicVO);
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusVesselList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusVesselList Search"}).getUserMessage(),ex);
		}
	}		

	/**
	 * VOP_VSK_0510 : Retrieve <br>
	 * Retrieving PIC RSO Code
	 * 
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPicRsoList() throws EventException {
		try {
			return dbDao.searchPicRsoList();
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusVesselList Search"}).getUserMessage(),ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneStatusVesselList Search"}).getUserMessage(),ex);
		}
	}		
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying VSK LANE PIC
	 * 
	 * @param vskLanePicVOS VskLanePicVO[]
	 * @param account SignOnUserAccount
	 * @return List<VskLanePicVO>
	 * @exception EventException
	 */
	public List<VskLanePicVO> manageLaneInfoPic(VskLanePicVO[] vskLanePicVOS, SignOnUserAccount account) throws EventException{
		try {
			if(vskLanePicVOS == null)
				return null;
			
			List<VskLanePicVO> insertVoList = new ArrayList<VskLanePicVO>();
			List<VskLanePicVO> updateVoList = new ArrayList<VskLanePicVO>();
			List<VskLanePicVO> deleteVoList = new ArrayList<VskLanePicVO>();
			
			int seqNo = 0;
			
			for ( int i=0; i< vskLanePicVOS.length; i++ ) {
				if ( vskLanePicVOS[i].getIbflag().equals("I")){
					if(dbDao.checkPicList(vskLanePicVOS[i]).size() > 0){
						throw new EventException(new ErrorHandler("VSK00002", new String[]{"RSO:"+ vskLanePicVOS[i].getRgnShpOprCd() +", Lane Code:"+ vskLanePicVOS[i].getSlanCd()}).getMessage());
					}
					vskLanePicVOS[i].setCreUsrId(account.getUsr_id());
					vskLanePicVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vskLanePicVOS[i]);
				}
				else if( vskLanePicVOS[i].getIbflag().equals("U")){
					if(dbDao.checkPicList(vskLanePicVOS[i]).size() > 0){
						throw new EventException(new ErrorHandler("VSK00002", new String[]{"RSO:"+ vskLanePicVOS[i].getRgnShpOprCd() +", Lane Code:"+ vskLanePicVOS[i].getSlanCd()}).getMessage());
					}
					vskLanePicVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vskLanePicVOS[i]);
				}
				else if( vskLanePicVOS[i].getIbflag().equals("D")){
					deleteVoList.add(vskLanePicVOS[i]);
				}
			}
			
			
			if ( insertVoList.size() > 0 ) {
				for(int cnt = 0; cnt < insertVoList.size(); cnt++){
					seqNo = dbDao.searchMaxPicNo(vskLanePicVOS[cnt]);
					insertVoList.get(cnt).setLanePicSeq(Integer.toString(seqNo)); 
					
					dbDao.addLanePic(insertVoList.get(cnt));
				}
			}
			
			if(updateVoList.size() > 0){
				dbDao.modifyLanePicS(updateVoList);
			}
			
			if(deleteVoList.size() > 0){
				dbDao.removeLanePicS(deleteVoList);
			}
			
			
			return insertVoList;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneInfoPic Manage"}).getUserMessage(),de);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw de;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneInfoPic Manage"}).getUserMessage(),de);
		}
		
	}
	
	/**
	 * VOP_VSK_0510 : Save <br>
	 * Modifying VSK PORT BUNKER REFUELING RATIO
	 * 
	 * @param vskPortBnkRfuelRtoSheetVOS VskPortBnkRfuelRtoSheetVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageLaneInfoBunkeringPort(VskPortBnkRfuelRtoSheetVO[] vskPortBnkRfuelRtoSheetVOS, SignOnUserAccount account) throws EventException{
		try {
			if(vskPortBnkRfuelRtoSheetVOS == null)
				return;
			
			List<VskPortBnkRfuelRtoVO> insertVoList = new ArrayList<VskPortBnkRfuelRtoVO>();
			List<VskPortBnkRfuelRtoVO> updateVoList = new ArrayList<VskPortBnkRfuelRtoVO>();
			List<VskPortBnkRfuelRtoVO> deleteVoList = new ArrayList<VskPortBnkRfuelRtoVO>();
			List<VskPortBnkRfuelRtoSheetVO> deleteAllVoList = new ArrayList<VskPortBnkRfuelRtoSheetVO>();
			
			//to know Port
			List<VskComboVO> bunkering = dbDao.searchBunkeringPortHeader();
			
			for ( int i=0; i< vskPortBnkRfuelRtoSheetVOS.length; i++ ) {
				if ( vskPortBnkRfuelRtoSheetVOS[i].getIbflag().equals("I")){
					convertSheetManagerVoIns(insertVoList, vskPortBnkRfuelRtoSheetVOS[i], account, bunkering);
				}else if( vskPortBnkRfuelRtoSheetVOS[i].getIbflag().equals("U")){
					List<List<VskPortBnkRfuelRtoVO>> voModel = new ArrayList<List<VskPortBnkRfuelRtoVO>>();
					
					voModel.add(insertVoList);
					voModel.add(updateVoList);
					voModel.add(deleteVoList);
					
					convertSheetManagerVoUpd(voModel, vskPortBnkRfuelRtoSheetVOS[i], account, bunkering);
				}else if( vskPortBnkRfuelRtoSheetVOS[i].getIbflag().equals("D")){
					deleteAllVoList.add(vskPortBnkRfuelRtoSheetVOS[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addBunkeringPortS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBunkeringPortS(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBunkeringPortS(deleteVoList);
			}
			
			if ( deleteAllVoList.size() > 0){
				dbDao.removeBunkeringPortLaneS(deleteAllVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneInfoBunkeringPort Manage"}).getUserMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12192", new String[]{"LaneInfoBunkeringPort Manage"}).getUserMessage(),de);
		}
		
	}
	
	/**
	 * Converting Sheet VO to VO for CUD
	 *  
	 * @param 	List<VskPortBnkRfuelRtoVO> voList,  
	 * @param 	VskPortBnkRfuelRtoSheetVO vskPortBnkRfuelRtoSheetVO, 
	 * @param 	SignOnUserAccount account,
	 * @param 	List<VskComboVO> bunkering 
	 * @exception EventException
	 */
	private void convertSheetManagerVoIns(List<VskPortBnkRfuelRtoVO> voList, 
											VskPortBnkRfuelRtoSheetVO vskPortBnkRfuelRtoSheetVO, 
											SignOnUserAccount account, 
											List<VskComboVO> bunkering){
		
		for(int cnt = 0; cnt < bunkering.size(); cnt++){
			VskPortBnkRfuelRtoVO convertVo = new VskPortBnkRfuelRtoVO();
			convertVo.setVslSlanCd(vskPortBnkRfuelRtoSheetVO.getVslSlanCd());
			convertVo.setCreUsrId(account.getUsr_id());
			convertVo.setUpdUsrId(account.getUsr_id());
			convertVo.setLocCd(bunkering.get(cnt).getVal());
			switch(cnt) {
				case	0:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto01().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto01());
						voList.add(convertVo);
					}
					break;
					
				case    1 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto02().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto02());
						voList.add(convertVo);
					}
					break;
					
				case    2 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto03().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto03());
						voList.add(convertVo);
					}
					break;
					
				case    3 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto04().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto04());
						voList.add(convertVo);
					}
					break;
					
				case    4 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto05().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto05());
						voList.add(convertVo);
					}
					break;
					
				case    5 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto06().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto06());
						voList.add(convertVo);
					}
					break;
					
				case    6 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto07().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto07());
						voList.add(convertVo);
					}
					break;
					
				case    7 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto08().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto08());
						voList.add(convertVo);
					}
					break;
					
				case    8 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto09().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto09());
						voList.add(convertVo);
					}
					break;
					
				case    9 :
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto10().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto10());
						voList.add(convertVo);
					}
					break;
					
				case    10:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto11().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto11());
						voList.add(convertVo);
					}
					break;
					
				case    11:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto12().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto12());
						voList.add(convertVo);
					}
					break;
					
				case    12:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto13().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto13());
						voList.add(convertVo);
					}
					break;
					
				case    13:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto14().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto14());
						voList.add(convertVo);
					}
					break;
					
				case    14:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto15().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto15());
						voList.add(convertVo);
					}
					break;
					
				case    15:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto16().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto16());
						voList.add(convertVo);
					}
					break;
					
				case    16:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto17().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto17());
						voList.add(convertVo);
					}
					break;
					
				case    17:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto18().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto18());
						voList.add(convertVo);
					}
					break;
					
				case    18:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto19().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto19());
						voList.add(convertVo);
					}
					break;
					
				case    19:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto20().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto20());
						voList.add(convertVo);
					}
					break;
					
				case    20:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto21().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto21());
						voList.add(convertVo);
					}
					break;
					
				case    21:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto22().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto22());
						voList.add(convertVo);
					}
					break;
					
				case    22:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto23().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto23());
						voList.add(convertVo);
					}
					break;
					
				case    23:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto24().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto24());
						voList.add(convertVo);
					}
					break;
					
				case    24:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto25().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto25());
						voList.add(convertVo);
					}
					break;
					
				case    25:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto26().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto26());
						voList.add(convertVo);
					}
					break;
					
				case    26:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto27().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto27());
						voList.add(convertVo);
					}
					break;
					
				case    27:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto28().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto28());
						voList.add(convertVo);
					}
					break;
					
				case    28:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto29().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto29());
						voList.add(convertVo);
					}
					break;
					
				case    29:
					if(!vskPortBnkRfuelRtoSheetVO.getRfuelRto30().equals("")){
						convertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto30());
						voList.add(convertVo);
					}
					break;
			}	//End of Switch	
		}	// End of For
	}	// End of	manageLaneInfoBunkeringPort
	
	/**
	 * Converting Sheet VO to VO for CUD
	 * 
	 * @param 	List<List<VskPortBnkRfuelRtoVO>> lisModel,  
	 * @param 	VskPortBnkRfuelRtoSheetVO vskPortBnkRfuelRtoSheetVO, 
	 * @param 	SignOnUserAccount account,
	 * @param 	List<VskComboVO> bunkering 
	 * @throws EventException 
	 * @exception EventException
	 */
	private void convertSheetManagerVoUpd(List<List<VskPortBnkRfuelRtoVO>> lisModel,
										    VskPortBnkRfuelRtoSheetVO vskPortBnkRfuelRtoSheetVO, 
											SignOnUserAccount account, 
											List<VskComboVO> bunkering) throws EventException{
		try {
			List<VskPortBnkRfuelRtoVO> insVoList = lisModel.get(0);
			List<VskPortBnkRfuelRtoVO> updVoList = lisModel.get(1); 
			List<VskPortBnkRfuelRtoVO> delVoList = lisModel.get(2);
			
			for(int cnt = 0; cnt < bunkering.size(); cnt++){
				VskPortBnkRfuelRtoVO insConvertVo = new VskPortBnkRfuelRtoVO();
				VskPortBnkRfuelRtoVO updConvertVo = new VskPortBnkRfuelRtoVO();
				VskPortBnkRfuelRtoVO delConvertVo = new VskPortBnkRfuelRtoVO();
				
				//no exist, Insert
				insConvertVo.setVslSlanCd(vskPortBnkRfuelRtoSheetVO.getVslSlanCd());
				insConvertVo.setCreUsrId(account.getUsr_id());
				insConvertVo.setUpdUsrId(account.getUsr_id());
				insConvertVo.setLocCd(bunkering.get(cnt).getVal());
		
				//exist and change number, Update
				updConvertVo.setVslSlanCd(vskPortBnkRfuelRtoSheetVO.getVslSlanCd());
				updConvertVo.setCreUsrId(account.getUsr_id());
				updConvertVo.setUpdUsrId(account.getUsr_id());
				updConvertVo.setLocCd(bunkering.get(cnt).getVal());
				
				//delete
				delConvertVo.setVslSlanCd(vskPortBnkRfuelRtoSheetVO.getVslSlanCd());
				delConvertVo.setLocCd(bunkering.get(cnt).getVal());
				String exsitsFlag = "";
				
				switch(cnt){
					case      0:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto01());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto01());
						break;
					
					case      1:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto02());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto02());
						break;
					
					case      2:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto03());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto03());
						break;
					
					case      3:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto04());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto04());
						break;
					
					case      4:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto05());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto05());
						break;
					
					case      5:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto06());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto06());
						break;
					
					case      6:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto07());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto07());
						break;
					
					case      7:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto08());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto08());
						break;
					
					case      8:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto09());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto09());
						break;
					
					case      9:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto10());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto10());
						break;
					
					case     10:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto11());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto11());
						break;
					
					case     11:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto12());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto12());
						break;
					
					case     12:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto13());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto13());
						break;
					
					case     13:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto14());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto14());
						break;
					
					case     14:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto15());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto15());
						break;
					
					case     15:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto16());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto16());
						break;
					
					case     16:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto17());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto17());
						break;
					
					case     17:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto18());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto18());
						break;
					
					case     18:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto19());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto19());
						break;
					
					case     19:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto20());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto20());
						break;
					
					case     20:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto21());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto21());
						break;
					
					case     21:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto22());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto22());
						break;
					
					case     22:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto23());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto23());
						break;
						
					case     23:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto24());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto24());
						break;
					
					case     24:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto25());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto25());
						break;
					
					case     25:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto26());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto26());
						break;
						
					case     26:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto27());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto27());
						break;
					
					case     27:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto28());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto28());
						break;
					
					case     28:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto29());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto29());
						break;
					case     29:
						insConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto30());
						updConvertVo.setBnkRfuelRto(vskPortBnkRfuelRtoSheetVO.getRfuelRto30());
						break;
				}
				
				exsitsFlag =  dbDao.searchExistsBnkRFuel(insConvertVo);
				
				if(exsitsFlag.equals("I")){
					insVoList.add(insConvertVo);
				}else if(exsitsFlag.equals("U")){
					updVoList.add(updConvertVo);
				}else  if(exsitsFlag.equals("D")){
					delVoList.add(delConvertVo);
				}
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("COM12192", new String[]{"SheetManagerVoUpd Convert"}).getUserMessage(),de);
		} catch (Exception ex){
			log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage());
			throw new EventException(new ErrorHandler("COM12192", new String[]{"SheetManagerVoUpd Convert"}).getUserMessage(),ex);
		}
	}

}