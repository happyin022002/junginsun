/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementMasterDataMgtBCImpl.java
*@FileTitle : Restuffing Reason
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.04.30 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.integration.ContainerMovementMasterDataMgtDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.RCtmMvmtStsVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmasterdatamgt.vo.UsAmsLocationListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CtmMvmtXchRsnVO;


/**
 * ALPS-EquipmentMovementMgt Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentMovementMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 우경민
 * @see UI_CTM_0412EventResponse,ContainerMovementFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.5
 */
public class ContainerMovementMasterDataMgtBCImpl extends BasicCommandSupport implements ContainerMovementMasterDataMgtBC {

	// Database Access Object
	private transient ContainerMovementMasterDataMgtDBDAO dbDao = null;

	/**
	 * ContainerMovementMasterDataMgtBCImpl 객체 생성<br>
	 * ContainerMovementMasterDataMgtDBDAO를 생성한다.<br>
	 */
	public ContainerMovementMasterDataMgtBCImpl() {
		dbDao = new ContainerMovementMasterDataMgtDBDAO();
	}

	/**
	 *  Movement Status List 조회<br>
	 *
	 * @param RCtmMvmtStsVO rCtmMvmtStsVO
	 * @return List<RCtmMvmtStsVO>
	 * @exception EventException
	 */
	public List<RCtmMvmtStsVO> searchMVMTStatusList(RCtmMvmtStsVO rCtmMvmtStsVO) throws EventException {
		try {
			log.debug("SEARCH searchMVMTStatusList");
			List<RCtmMvmtStsVO> list = dbDao.searchMVMTStatusList(rCtmMvmtStsVO);
			if (list.size() < 1) {
				throw new DAOException(new ErrorHandler("CTM10024").getMessage());
			}
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
	 *  Restuffing Reason 리스트 조회<br>
	 *
	 * @param CtmMvmtXchRsnVO ctmMvmtXchRsnVO
	 * @return List<CtmMvmtXchRsnVO>
	 * @exception EventException
	 */
	public List<CtmMvmtXchRsnVO> searchReasonList(CtmMvmtXchRsnVO ctmMvmtXchRsnVO) throws EventException {
		try {
			List<CtmMvmtXchRsnVO> list =  dbDao.searchReasonList(ctmMvmtXchRsnVO);
			if (list.size() < 1) {
				throw new EventException(new ErrorHandler("CTM10024").getMessage());
			}
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
	 * US AMS Location의 List를 조회<br>
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
 * US AMS Location List를 Update한다.<br>
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
}