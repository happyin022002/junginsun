/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtBCImpl.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchAllVVDByBKGVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchDeletedMVMTListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration.ContainerMovementMasterDataMgtDBDAO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.CntrMvmtSeqVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CtmMvmtStsDcsnVO;
import com.clt.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * OPUS-EquipmentMovementMgt Business Logic Basic Command implementation<br>
 * handling business logic about OPUS-EquipmentMovementMgt
 *
 * @author 
 * @see UI_CTM_0412EventResponse,ContainerMovementFinderBC DAO class reference
 * @since J2EE 1.5
 */
public class ContainerMovementMasterDataMgtBCImpl extends BasicCommandSupport implements ContainerMovementMasterDataMgtBC {

	// Database Access Object
	private transient ContainerMovementMasterDataMgtDBDAO dbDao = null;

	/**
	 * creating ContainerMovementMasterDataMgtBCImpl Object
	 * creating ContainerMovementMasterDataMgtDBDAO
	 */
	public ContainerMovementMasterDataMgtBCImpl() {
		dbDao = new ContainerMovementMasterDataMgtDBDAO();
	}

	/**
	 *  retrieving Movement Status List 
	 *
	 * @param RCtmMvmtStsVO rCtmMvmtStsVO
	 * @return List<RCtmMvmtStsVO>
	 * @exception EventException
	 */
	public List<RCtmMvmtStsVO> searchMVMTStatusList(RCtmMvmtStsVO rCtmMvmtStsVO) throws EventException {
		try {
			log.debug("SEARCH searchMVMTStatusList");
			List<RCtmMvmtStsVO> list = dbDao.searchMVMTStatusList(rCtmMvmtStsVO);
//			if (list.size() < 1) {
//				throw new DAOException(new ErrorHandler("CTM10024").getMessage());
//			}
			return list;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchMVMTStatusList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchMVMTStatusList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 *  retrieving Restuffing Reason List
	 *
	 * @param CtmMvmtXchRsnVO ctmMvmtXchRsnVO
	 * @return List<CtmMvmtXchRsnVO>
	 * @exception EventException
	 */
	public List<CtmMvmtXchRsnVO> searchReasonList(CtmMvmtXchRsnVO ctmMvmtXchRsnVO) throws EventException {
		try {
			List<CtmMvmtXchRsnVO> list =  dbDao.searchReasonList(ctmMvmtXchRsnVO);
//			if (list.size() < 1) {
//				throw new EventException(new ErrorHandler("CTM10024").getMessage());
//			}
			return list;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchReasonList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchReasonList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * retrieving US AMS Location List
	 *
	 * @param UsAmsLocationListVO usLmsLocationListVO
	 * @return List<UsAmsLocationListVO>
	 * @exception EventException
	 */
	public List<UsAmsLocationListVO> searchAmsLocation(UsAmsLocationListVO usLmsLocationListVO) throws EventException {
		try {
			return dbDao.searchAmsLocation(usLmsLocationListVO);
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchAmsLocation] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchAmsLocation] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * updating US AMS Location List
	 *
	 * @param UsAmsLocationListVO[] usLmsLocationListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageAmsLocation(UsAmsLocationListVO[] usLmsLocationListVOs,SignOnUserAccount account) throws EventException {
			try {
				List<UsAmsLocationListVO> insertVoList = new ArrayList<UsAmsLocationListVO>();
				List<UsAmsLocationListVO> updateVoList = new ArrayList<UsAmsLocationListVO>();
				List<UsAmsLocationListVO> deleteVoList = new ArrayList<UsAmsLocationListVO>();
				for ( int i=0; i<usLmsLocationListVOs .length; i++ ) {
					usLmsLocationListVOs[i].setUpdUsrId(account.getUsr_id());
					if ( usLmsLocationListVOs[i].getIbflag().equals("I")){
						usLmsLocationListVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(usLmsLocationListVOs[i]);
					} else if ( usLmsLocationListVOs[i].getIbflag().equals("U")){
						usLmsLocationListVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(usLmsLocationListVOs[i]);
					} else if ( usLmsLocationListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(usLmsLocationListVOs[i]);
					}
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addmanageAmsLocationS(insertVoList);
				}
	
				if ( updateVoList.size() > 0 ) {
					dbDao.modifymanageAmsLocationS(updateVoList);
				}
	
				if ( deleteVoList.size() > 0 ) {
					dbDao.removemanageAmsLocationS(deleteVoList);
				}
	
			} catch (DAOException ex) {
				log.error("\n\n[BCImpl - manageAmsLocation] DAOException :\n" + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch(Exception ex) {
				log.error("\n\n[BCImpl - manageAmsLocation] Exception :\n" + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}
		}
	
	/**
	 * updating Restuffing Reason List
	 *
	 * @param CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageReasonList(CtmMvmtXchRsnVO[] ctmMvmtXchRsnVOs,SignOnUserAccount account) throws EventException {
			try {
				List<CtmMvmtXchRsnVO> insertVoList = new ArrayList<CtmMvmtXchRsnVO>();
				List<CtmMvmtXchRsnVO> updateVoList = new ArrayList<CtmMvmtXchRsnVO>();
				List<CtmMvmtXchRsnVO> deleteVoList = new ArrayList<CtmMvmtXchRsnVO>();
				for ( int i=0; i<ctmMvmtXchRsnVOs .length; i++ ) {
					ctmMvmtXchRsnVOs[i].setUpdUsrId(account.getUsr_id());
					if ( ctmMvmtXchRsnVOs[i].getIbflag().equals("I")){
						ctmMvmtXchRsnVOs[i].setCreUsrId(account.getUsr_id());
						insertVoList.add(ctmMvmtXchRsnVOs[i]);
					} else if ( ctmMvmtXchRsnVOs[i].getIbflag().equals("U")){
						ctmMvmtXchRsnVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(ctmMvmtXchRsnVOs[i]);
					} else if ( ctmMvmtXchRsnVOs[i].getIbflag().equals("D")){
						deleteVoList.add(ctmMvmtXchRsnVOs[i]);
					}
				}
				if ( insertVoList.size() > 0 ) {
					dbDao.addmanageReasonS(insertVoList);
				}
	
				if ( updateVoList.size() > 0 ) {
					dbDao.modifymanageReasonS(updateVoList);
				}
	
				if ( deleteVoList.size() > 0 ) {
					dbDao.removemanageReasonS(deleteVoList);
				}
	
			} catch (DAOException ex) {
				log.error("\n\n[BCImpl - manageReason] DAOException :\n" + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			} catch(Exception ex) {
				log.error("\n\n[BCImpl - manageReason] Exception :\n" + ex.getMessage(), ex);
				throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
			}
		}
	
	/**
	 * updating OSCAR Booking Container List
	 *
	 * @param SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageOSCARCtmCycNoList(SearchDeletedMVMTListVO[] searchDeletedMVMTListVOs, String usrId) throws EventException {
		try {
			List<SearchDeletedMVMTListVO> updateVoList = new ArrayList<SearchDeletedMVMTListVO>();
			List<SearchDeletedMVMTListVO> insertVoList = new ArrayList<SearchDeletedMVMTListVO>();
			List<SearchDeletedMVMTListVO> deleteVoList = new ArrayList<SearchDeletedMVMTListVO>();
			for ( int i=0; searchDeletedMVMTListVOs!=null && i<searchDeletedMVMTListVOs .length; i++ ) {
				searchDeletedMVMTListVOs[i].setDeltUsrId(usrId);//실제적으로는 update id이다.
				
				if ( searchDeletedMVMTListVOs[i].getIbflag().equals("I")){
					insertVoList.add(searchDeletedMVMTListVOs[i]);
				} else if ( searchDeletedMVMTListVOs[i].getIbflag().equals("U")){
					updateVoList.add(searchDeletedMVMTListVOs[i]);
				} else if ( searchDeletedMVMTListVOs[i].getIbflag().equals("D")){
					deleteVoList.add(searchDeletedMVMTListVOs[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.manageOSCARCtmCycNoList(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageOSCARCtmCycNoList(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageOSCARCtmCycNoList(deleteVoList);
			}


		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageOSCARCtmCycNoList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageOSCARCtmCycNoList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}	
	
	/**
	 * updating OSCAR Booking VVD List
	 *
	 * @param SearchAllVVDByBKGVO[] searchAllVVDByBKGVOs
	 * @param String usrId
	 * @exception EventException
	 */
	public void manageVVDList(SearchAllVVDByBKGVO[] searchAllVVDByBKGVOs, String usrId) throws EventException {
		try {
			List<SearchAllVVDByBKGVO> updateVoList = new ArrayList<SearchAllVVDByBKGVO>();
			List<SearchAllVVDByBKGVO> insertVoList = new ArrayList<SearchAllVVDByBKGVO>();
			List<SearchAllVVDByBKGVO> deleteVoList = new ArrayList<SearchAllVVDByBKGVO>();
			List<SearchAllVVDByBKGVO> updateBKGVoList = new ArrayList<SearchAllVVDByBKGVO>();
			for ( int i=0; searchAllVVDByBKGVOs!=null && i<searchAllVVDByBKGVOs.length; i++ ) {
				
				if ( searchAllVVDByBKGVOs[i].getIbflag().equals("I")){
					searchAllVVDByBKGVOs[i].setCreUsrId(usrId);
					searchAllVVDByBKGVOs[i].setUpdUsrId(usrId);
					searchAllVVDByBKGVOs[i].setBkgNo(searchAllVVDByBKGVOs[0].getBkgNo());
					insertVoList.add(searchAllVVDByBKGVOs[i]);
					updateBKGVoList.add(searchAllVVDByBKGVOs[i]);
				} else if ( searchAllVVDByBKGVOs[i].getIbflag().equals("U")){
					searchAllVVDByBKGVOs[i].setUpdUsrId(usrId);
					searchAllVVDByBKGVOs[i].setBkgNo(searchAllVVDByBKGVOs[0].getBkgNo());
					updateVoList.add(searchAllVVDByBKGVOs[i]);
					if (searchAllVVDByBKGVOs[i].getFlg().equals("Y")) {
						updateBKGVoList.add(searchAllVVDByBKGVOs[i]);
					}
				} else if ( searchAllVVDByBKGVOs[i].getIbflag().equals("D")){
					searchAllVVDByBKGVOs[i].setUpdUsrId(usrId);
					searchAllVVDByBKGVOs[i].setBkgNo(searchAllVVDByBKGVOs[0].getBkgNo());
					deleteVoList.add(searchAllVVDByBKGVOs[i]);
					updateBKGVoList.add(searchAllVVDByBKGVOs[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageVVDList(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageVVDList(insertVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageVVDList(deleteVoList);
			}

			if ( updateBKGVoList.size() > 0 ) {
				dbDao.modifymanageBKGList(updateBKGVoList);
			}

		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageOSCARCtmCycNoList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageOSCARCtmCycNoList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * updating Cntr MVMT Sequence List
	 *
	 * @param CntrMvmtSeqVO[] cntrMvmtSeqVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	
	public void manageCntrMvmtSeqList(CntrMvmtSeqVO[] cntrMvmtSeqVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CntrMvmtSeqVO> insertVoList = new ArrayList<CntrMvmtSeqVO>();
			List<CntrMvmtSeqVO> updateVoList = new ArrayList<CntrMvmtSeqVO>();
			List<CntrMvmtSeqVO> deleteVoList = new ArrayList<CntrMvmtSeqVO>();
			for ( int i=0; i<cntrMvmtSeqVOs .length; i++ ) {
				cntrMvmtSeqVOs[i].setUpdUsrId(account.getUsr_id());
				if ( cntrMvmtSeqVOs[i].getIbflag().equals("I")){
					cntrMvmtSeqVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(cntrMvmtSeqVOs[i]);
				} else if ( cntrMvmtSeqVOs[i].getIbflag().equals("U")){
					cntrMvmtSeqVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cntrMvmtSeqVOs[i]);
				} else if ( cntrMvmtSeqVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cntrMvmtSeqVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageCntrMvmtSeqs(insertVoList);
			}
	
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageCntrMvmtSeq(updateVoList);
			}
	
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageCntrMvmtSeq(deleteVoList);
			}
	
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageCntrMvmtSeqList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageCntrMvmtSeqList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 *  retrieving Cntr Mvmt Sequence List
	 *
	 * @param CntrMvmtSeqVO cntrMvmtSeqVO
	 * @return List<CntrMvmtSeqVO>
	 * @exception EventException
	 */
	
	public List<CntrMvmtSeqVO> searchCntrMvmtSeqList(CntrMvmtSeqVO cntrMvmtSeqVO)
			throws EventException {
		try {
			List<CntrMvmtSeqVO> list =  dbDao.searchCntrMvmtSeqList(cntrMvmtSeqVO);
	//		if (list.size() < 1) {
	//			throw new EventException(new ErrorHandler("CTM10024").getMessage());
	//		}
			return list;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCntrMvmtSeqList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCntrMvmtSeqList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * updating Cntr MVMT Status Decision List
	 *
	 * @param CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	
	public void manageCtmMvmtStsDcsnList(CtmMvmtStsDcsnVO[] ctmMvmtStsDcsnVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CtmMvmtStsDcsnVO> insertVoList = new ArrayList<CtmMvmtStsDcsnVO>();
			List<CtmMvmtStsDcsnVO> updateVoList = new ArrayList<CtmMvmtStsDcsnVO>();
			List<CtmMvmtStsDcsnVO> deleteVoList = new ArrayList<CtmMvmtStsDcsnVO>();
			for ( int i=0; i<ctmMvmtStsDcsnVOs .length; i++ ) {
				ctmMvmtStsDcsnVOs[i].setUpdUsrId(account.getUsr_id());
				if ( ctmMvmtStsDcsnVOs[i].getIbflag().equals("I")){
					ctmMvmtStsDcsnVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(ctmMvmtStsDcsnVOs[i]);
				} else if ( ctmMvmtStsDcsnVOs[i].getIbflag().equals("U")){
					ctmMvmtStsDcsnVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(ctmMvmtStsDcsnVOs[i]);
				} else if ( ctmMvmtStsDcsnVOs[i].getIbflag().equals("D")){
					deleteVoList.add(ctmMvmtStsDcsnVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageCtmMvmtStsDcsnS(insertVoList);
			}
	
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageCtmMvmtStsDcsnS(updateVoList);
			}
	
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageCtmMvmtStsDcsnS(deleteVoList);
			}
	
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - manageCntrMvmtSeqList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - manageCntrMvmtSeqList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 *  retrieving Cntr MVMT Status Decision List
	 *
	 * @param CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO
	 * @return List<CtmMvmtStsDcsnVO>
	 * @exception EventException
	 */
	
	public List<CtmMvmtStsDcsnVO> searchCtmMvmtStsDcsnList(CtmMvmtStsDcsnVO ctmMvmtStsDcsnVO) throws EventException {
		try {
			List<CtmMvmtStsDcsnVO> list =  dbDao.searchCtmMvmtStsDcsnList(ctmMvmtStsDcsnVO);
	//		if (list.size() < 1) {
	//			throw new EventException(new ErrorHandler("CTM10024").getMessage());
	//		}
			return list;
		} catch (DAOException ex) {
			log.error("\n\n[BCImpl - searchCntrMvmtSeqList] DAOException :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - searchCntrMvmtSeqList] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

}