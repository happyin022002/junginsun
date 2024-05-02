/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtBCImpl.java
*@FileTitle : Stevedore Damage Part Code (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 우지석
*@LastVersion : 1.0
* 2009.05.12 우지석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration.OperationNPerformMasterDataMgtDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.OpfRstwgRsnCdVO;
import com.hanjin.syscommon.common.table.OpfStvDmgCdVO;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;

/**
 * NIS2010-OperationNPerformMasterDataMgt Business Logic Basic Command implementation<br>
 * - NIS2010-OperationNPerformMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Ji Seok Woo
 * @see vop_opf_0048EventResponse,OperationNPerformMasterDataMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class OperationNPerformMasterDataMgtBCImpl extends BasicCommandSupport implements OperationNPerformMasterDataMgtBC {

	// Database Access Object
	private transient OperationNPerformMasterDataMgtDBDAO dbDao = null;

	/**
	 * OperationNPerformMasterDataMgtBCImpl 객체 생성<br>
	 * OperationNPerformMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public OperationNPerformMasterDataMgtBCImpl() {
		dbDao = new OperationNPerformMasterDataMgtDBDAO();
	}

	/**
	 * [VOP_OPF_0048 StevedoreDamagePartCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO	opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception DAOException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamagePartCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException {
		try {
			return dbDao.searchStevedoreDamagePartCodeList(opfStvDmgCdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"StevedoreDamagePartCodeList"}).getMessage(), ex);
		} catch (Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12203", new String[]{"StevedoreDamagePartCodeList"}).getMessage(), de);
		}
	}

	/**
	 * [VOP_OPF_0049 StevedoreDamageReasonCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO	opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @exception DAOException
	 */	
	public List<OpfStvDmgCdVO> searchStevedoreDamageReasonCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws EventException {
		try {
			return dbDao.searchStevedoreDamageReasonCodeList(opfStvDmgCdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"StevedoreDamageReasonCodeList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"StevedoreDamageReasonCodeList"}).getMessage(), de);
        }
	}

	/**
	 * [VOP_OPF_0087 ExcludeTPRReasonCodeList]을 [조회] 합니다.<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @exception DAOException
	 */	
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTPRReasonCodeList(OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO) throws EventException {
		try {
			return dbDao.searchExcludeTPRReasonCodeList(opfTmlProdRptRsnCdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ExcludeTPRReasonCodeList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"ExcludeTPRReasonCodeList"}).getMessage(), de);
        }
	}
	
	/**
	 * [VOP_OPF_0048 StevedoreDamagePartCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */	
	public void manageStevedoreDamagePartCode(OpfStvDmgCdVO[] opfStvDmgCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgCdVO> insertVoList = new ArrayList<OpfStvDmgCdVO>();
			List<OpfStvDmgCdVO> updateVoList = new ArrayList<OpfStvDmgCdVO>();
			List<OpfStvDmgCdVO> deleteVoList = new ArrayList<OpfStvDmgCdVO>();
			for ( int i=0; i<opfStvDmgCdVOs .length; i++ ) {
				if ( opfStvDmgCdVOs[i].getIbflag().equals("I")){
					opfStvDmgCdVOs[i].setCreUsrId(account.getUsr_id());
					opfStvDmgCdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(opfStvDmgCdVOs[i]);
				} else if ( opfStvDmgCdVOs[i].getIbflag().equals("U")){
					opfStvDmgCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfStvDmgCdVOs[i]);
				} else if ( opfStvDmgCdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(opfStvDmgCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageStevedoreDamagePartCodeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageStevedoreDamagePartCodeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageStevedoreDamagePartCodeS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"StevedoreDamagePartCode"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"StevedoreDamagePartCode"}).getMessage(), de);
		}
	}

	/**
	 * [VOP_OPF_0049 StevedoreDamageReasonCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfStvDmgCdVO[] opfStvDmgCdVOs
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */	
	public void manageStevedoreDamageReasonCode(OpfStvDmgCdVO[] opfStvDmgCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OpfStvDmgCdVO> insertVoList = new ArrayList<OpfStvDmgCdVO>();
			List<OpfStvDmgCdVO> updateVoList = new ArrayList<OpfStvDmgCdVO>();
			List<OpfStvDmgCdVO> deleteVoList = new ArrayList<OpfStvDmgCdVO>();
			for ( int i=0; i<opfStvDmgCdVOs .length; i++ ) {
				if ( opfStvDmgCdVOs[i].getIbflag().equals("I")){
					opfStvDmgCdVOs[i].setCreUsrId(account.getUsr_id());
					opfStvDmgCdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(opfStvDmgCdVOs[i]);
				} else if ( opfStvDmgCdVOs[i].getIbflag().equals("U")){
					opfStvDmgCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfStvDmgCdVOs[i]);
				} else if ( opfStvDmgCdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(opfStvDmgCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageStevedoreDamageReasonCodeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageStevedoreDamageReasonCodeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageStevedoreDamageReasonCodeS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"StevedoreDamageReasonCode"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"StevedoreDamageReasonCode"}).getMessage(), de);
		}
	}

	/**
	 * [VOP_OPF_0087 ExcludeTPRReasonCode]을 [CRUD] 합니다.<br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */	
	public void manageExcludeTPRReasonCode(OpfTmlProdRptRsnCdVO[] opfTmlProdRptRsnCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OpfTmlProdRptRsnCdVO> insertVoList = new ArrayList<OpfTmlProdRptRsnCdVO>();
			List<OpfTmlProdRptRsnCdVO> updateVoList = new ArrayList<OpfTmlProdRptRsnCdVO>();
			List<OpfTmlProdRptRsnCdVO> deleteVoList = new ArrayList<OpfTmlProdRptRsnCdVO>();
			for ( int i=0; i<opfTmlProdRptRsnCdVOs .length; i++ ) {
				if ( opfTmlProdRptRsnCdVOs[i].getIbflag().equals("I")){
					opfTmlProdRptRsnCdVOs[i].setCreUsrId(account.getUsr_id());
					opfTmlProdRptRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(opfTmlProdRptRsnCdVOs[i]);
				} else if ( opfTmlProdRptRsnCdVOs[i].getIbflag().equals("U")){
					opfTmlProdRptRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(opfTmlProdRptRsnCdVOs[i]);
				} else if ( opfTmlProdRptRsnCdVOs[i].getIbflag().equals("D")){
					opfTmlProdRptRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(opfTmlProdRptRsnCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageExcludeTPRReasonCodeS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageExcludeTPRReasonCodeS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageExcludeTPRReasonCodeS(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"ExcludeTPRReasonCode"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"ExcludeTPRReasonCode"}).getMessage(), de);
		}
	}
	
	
	// VOP_OPF_0075 Start ========================================================================//
	/**
	 * Restow Reason Code을 조회 합니다. <br>
	 * 
	 * @param opfRstwgRsnCdVO   OpfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @exception DAOException
	 */
	public List<OpfRstwgRsnCdVO> searchRestowReasonCodeList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws EventException {
		try {
			return dbDao.searchRestowReasonCodeList(opfRstwgRsnCdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RestowReasonCodeList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"RestowReasonCodeList"}).getMessage(), de);
        }
	}
	/**
	 * Restow Reason Code을 저장 합니다. <br>
	 * 
	 * @param opfRstwgRsnCdVOs OpfRstwgRsnCdVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void mamageRestowReasonCode(OpfRstwgRsnCdVO[] opfRstwgRsnCdVOs, SignOnUserAccount account) throws EventException{
		try {
			//** Grid Data 하나당 DB Record 2개씩 생성
			//*** 1Row=>RSTWG_CD_TP_CD="B", 2Row=>RSTWG_CD_TP_CD="Q"
			//--::jsk::2012.09.19::--for(int j=0; j<2; j++){
				
				List<OpfRstwgRsnCdVO> insertVoList = new ArrayList<OpfRstwgRsnCdVO>();
				List<OpfRstwgRsnCdVO> updateVoList = new ArrayList<OpfRstwgRsnCdVO>();
				List<OpfRstwgRsnCdVO> deleteVoList = new ArrayList<OpfRstwgRsnCdVO>();
				
				for ( int i=0; i<opfRstwgRsnCdVOs .length; i++ ) {
					
/*					if(j==0){
						opfRstwgRsnCdVOs[i].setRstwgCdTpCd("B");
					}else{
						opfRstwgRsnCdVOs[i].setRstwgCdTpCd("Q");
					}*/
					
					opfRstwgRsnCdVOs[i].setRstwgCdTpCd("R");
					
					if ( opfRstwgRsnCdVOs[i].getIbflag().equals("I")){
						if(dbDao.searchRestowReasonCode(opfRstwgRsnCdVOs[i]).size() > 0){
							opfRstwgRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
							updateVoList.add(opfRstwgRsnCdVOs[i]);
						}
						else{
							opfRstwgRsnCdVOs[i].setCreUsrId(account.getUsr_id());
							opfRstwgRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
							insertVoList.add(opfRstwgRsnCdVOs[i]);
						}
					} else if ( opfRstwgRsnCdVOs[i].getIbflag().equals("U")){
						opfRstwgRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(opfRstwgRsnCdVOs[i]);
					} else if ( opfRstwgRsnCdVOs[i].getIbflag().equals("D")){
						opfRstwgRsnCdVOs[i].setUpdUsrId(account.getUsr_id());
						deleteVoList.add(opfRstwgRsnCdVOs[i]);
					}
				}
				
				if ( insertVoList.size() > 0 ) {
					dbDao.addRestowReasonCode(insertVoList);
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyRestowReasonCode(updateVoList);
				}
				if ( deleteVoList.size() > 0 ) {
					dbDao.removeRestowReasonCode(deleteVoList);
				}
				
				//--::jsk::2012.09.19::--}
		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RestowReasonCode"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"RestowReasonCode"}).getMessage(), de);
		}
	}
	// VOP_OPF_0075 End ==========================================================================//
	
	// VOP_OPF_0034 Start ========================================================================//
	/**
	 * COD Reject Reason Code을 조회 합니다. <br>
	 * 
	 * @param opfCodRjctCdVO   OpfCodRjctCdVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception DAOException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectReasonCodeList(OpfCodRjctCdVO opfCodRjctCdVO) throws EventException {
		try {
			return dbDao.searchCODRejectReasonCodeList(opfCodRjctCdVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CODRejectReasonCodeList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"CODRejectReasonCodeList"}).getMessage(), de);
        }
	}
	/**
	 * COD Reject Reason Code을 저장 합니다. <br>
	 * 
	 * @param opfCodRjctCdVOs OpfCodRjctCdVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 */
	public void manageCODRejectReasonCode(OpfCodRjctCdVO[] opfCodRjctCdVOs, SignOnUserAccount account) throws EventException{
		try {
			List<OpfCodRjctCdVO> insertVoList = new ArrayList<OpfCodRjctCdVO>();
			List<OpfCodRjctCdVO> updateVoList = new ArrayList<OpfCodRjctCdVO>();
			List<OpfCodRjctCdVO> deleteVoList = new ArrayList<OpfCodRjctCdVO>();
			
			for ( int i=0; i<opfCodRjctCdVOs.length; i++ ) {

				opfCodRjctCdVOs[i].setUpdUsrId(account.getUsr_id());
				
				if ( opfCodRjctCdVOs[i].getIbflag().equals("I")){
					if(dbDao.searchCODRejectReasonCode(opfCodRjctCdVOs[i]).size() > 0){
						updateVoList.add(opfCodRjctCdVOs[i]);
					}
					else{
						opfCodRjctCdVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(opfCodRjctCdVOs[i]);
					}
				} 
				else if ( opfCodRjctCdVOs[i].getIbflag().equals("U")){
					updateVoList.add(opfCodRjctCdVOs[i]);
				} 
				else if ( opfCodRjctCdVOs[i].getIbflag().equals("D")){
					deleteVoList.add(opfCodRjctCdVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addCODRejectReasonCode(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCODRejectReasonCode(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCODRejectReasonCode(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"CODRejectReasonCode"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"CODRejectReasonCode"}).getMessage(), de);
		}
	}
	// VOP_OPF_0034 End ==========================================================================//

	// VOP_OPF_0068 Start ========================================================================//
	/**
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchAllPortList(MdmLocationVO mdmLocationVO) throws EventException {
		try {
			return dbDao.searchAllPortList(mdmLocationVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AllPortList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"AllPortList"}).getMessage(), de);
        }
	}	

	/**
	 * TPR Target Port Creation 를 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchTPRTargetPortList(MdmLocationVO mdmLocationVO) throws EventException {
		try {
			return dbDao.searchTPRTargetPortList(mdmLocationVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TPRTargetPortList"}).getMessage(), ex);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"TPRTargetPortList"}).getMessage(), de);
        }
	}
	
	/**
	 * TTPR Target Port Creation 을 저장 합니다.<br>
	 * 
	 * @param MdmLocationVO[] mdmLocationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetPort(MdmLocationVO[] mdmLocationVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MdmLocationVO> insertVoList = new ArrayList<MdmLocationVO>();
			List<MdmLocationVO> updateVoList = new ArrayList<MdmLocationVO>();
			List<MdmLocationVO> deleteVoList = new ArrayList<MdmLocationVO>();
			for ( int i = 0; i < mdmLocationVOs.length; i++ ) {
				if ( mdmLocationVOs[i].getIbflag().equals("I")){
					mdmLocationVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mdmLocationVOs[i]);
				} else if ( mdmLocationVOs[i].getIbflag().equals("U")){
					mdmLocationVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mdmLocationVOs[i]);
				} else if ( mdmLocationVOs[i].getIbflag().equals("D")){
					deleteVoList.add(mdmLocationVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyTPRTargetPort(insertVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPRTargetPort"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPRTargetPort"}).getMessage(), de);
		}
	}	
	// VOP_OPF_0068 End ==========================================================================//
	
	// VOP_OPF_0067 Start ========================================================================//	
	/**
	 * TPR Target Lane Creation 를 조회 합니다. <br>
	 * 
	 * @param MdmVslSvcLaneVO   mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchTPRTargetLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException {
		try {
			return dbDao.searchTPRTargetLaneList(mdmVslSvcLaneVO);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPR Target Lane"}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPR Target Lane"}).getMessage(), de);
        }
	}	
	
	/**
	 * TPR Target Lane Creation 을 저장 합니다.<br>
	 * 
	 * @param MdmVslSvcLaneVO[] mdmVslSvcLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTPRTargetLaneList(MdmVslSvcLaneVO[] mdmVslSvcLaneVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MdmVslSvcLaneVO> updateVoList = new ArrayList<MdmVslSvcLaneVO>();

			for ( int i=0; i<mdmVslSvcLaneVOs .length; i++ ) {				
				if ( mdmVslSvcLaneVOs[i].getIbflag().equals("I")){
					mdmVslSvcLaneVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mdmVslSvcLaneVOs[i]);
				} else if ( mdmVslSvcLaneVOs[i].getIbflag().equals("U")){
					mdmVslSvcLaneVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mdmVslSvcLaneVOs[i]);
				} else{
					updateVoList.add(mdmVslSvcLaneVOs[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageTPRTargetLaneListS(updateVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPRTargetLaneList"}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12192", new String[]{"TPRTargetLaneList"}).getMessage(), de);
		}
	}
	// VOP_OPF_0067 End ==========================================================================//
	
}