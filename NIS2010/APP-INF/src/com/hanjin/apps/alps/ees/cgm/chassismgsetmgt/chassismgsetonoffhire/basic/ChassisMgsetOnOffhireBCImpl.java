/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetOnOffhireBCImpl.java
*@FileTitle : Chassis Specification Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 조재성
*@LastVersion : 1.0
* 2009.04.28 박의수
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.13 김상수 [CHM-201215565-01] ALPS MNR-Disposal-SLD Management-> SLD Cancellation 보완 요청
*                                      - Disposal Sold Cancelation 화면에서 M.G.Set과 Chassis도 SLD Cancel 가능하도록 CGM연계로직 추가
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration.ChassisMgsetOnOffhireDBDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration.ChassisMgsetOnOffhireEAIDAO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.FaErpListVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSAtdtHistoryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.OnOffHireSummarybyMonthVO;
import com.hanjin.apps.alps.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ReportSearchConditionVO;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBC;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.basic.ChassisMovementHistoryBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrMasterUpdateIFVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ChassisMgsetMgt Business Logic Basic Command implementation<br>
 * - ALPS-ChassisMgsetMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Eui-su Park
 * @see EES_CGM_1002EventResponse,ChassisMgsetOnOffhireBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ChassisMgsetOnOffhireBCImpl extends BasicCommandSupport implements ChassisMgsetOnOffhireBC {

	// Database Access Object
	private transient ChassisMgsetOnOffhireDBDAO dbDao = null;
	private transient ChassisMgsetOnOffhireEAIDAO eaiDao = null;
	/**
	 * ChassisMgsetOnOffhireBCImpl 객체 생성<br>
	 * ChassisMgsetOnOffhireDBDAO를 생성한다.<br>
	 */
	public ChassisMgsetOnOffhireBCImpl() {
		dbDao = new ChassisMgsetOnOffhireDBDAO();
		eaiDao = new ChassisMgsetOnOffhireEAIDAO();
	}

	/**
	 * chassis 장비의 Type Size List 를 조회한다. Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeListBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException {
		try {
			return dbDao.searchCHSEqTypeSizeListData(cHSEqTpSzINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis 장비의 Type Size 를 수정한다. Manage [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVOs CHSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSEqTypeSizeBasic(CHSEqTpSzINVO[] cHSEqTpSzINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CHSEqTpSzINVO> insertVoList = new ArrayList<CHSEqTpSzINVO>();
			List<CHSEqTpSzINVO> updateVoList = new ArrayList<CHSEqTpSzINVO>();
			List<CHSEqTpSzINVO> deleteVoList = new ArrayList<CHSEqTpSzINVO>();

			for ( int i=0; i<cHSEqTpSzINVOs.length; i++ ) {

				log.debug("CHSEqTpSzINVO : " + cHSEqTpSzINVOs);
				if ( cHSEqTpSzINVOs[i].getIbflag().equals("I")){
					cHSEqTpSzINVOs[i].setCreUsrId(account.getUsr_id());
					cHSEqTpSzINVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cHSEqTpSzINVOs[i]);
				} else if ( cHSEqTpSzINVOs[i].getIbflag().equals("U")){
					cHSEqTpSzINVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cHSEqTpSzINVOs[i]);
				} else if ( cHSEqTpSzINVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cHSEqTpSzINVOs[i]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addCHSEqTypeSizeData(insertVoList);
			}

			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCHSEqTypeSizeData(updateVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCHSEqTypeSizeData(deleteVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Type Size List 를 조회한다. Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeListBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException {
		try {
			return dbDao.searchMGSEqTypeSizeListData(mGSEqTpSzINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. Retrieve [EES_CGM_1001]<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeInEqChkBasic(CHSEqTpSzINVO cHSEqTpSzINVO) throws EventException
	{
		try {
			return dbDao.searchCHSEqTypeSizeInEqChkData(cHSEqTpSzINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. Retrieve [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeInEqChkBasic(MGSEqTpSzINVO mGSEqTpSzINVO) throws EventException
	{
		try {
			return dbDao.searchMGSEqTypeSizeInEqChkData(mGSEqTpSzINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Type Size를 수정한다. Manage [EES_CGM_2083]<br>
	 *
	 * @param mGSEqTpSzINVOs MGSEqTpSzINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSEqTypeSizeBasic(MGSEqTpSzINVO[] mGSEqTpSzINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSEqTpSzINVO> insertVoList = new ArrayList<MGSEqTpSzINVO>();
			List<MGSEqTpSzINVO> updateVoList = new ArrayList<MGSEqTpSzINVO>();
			List<MGSEqTpSzINVO> deleteVoList = new ArrayList<MGSEqTpSzINVO>();

			for ( int i=0; i<mGSEqTpSzINVOs.length; i++ ) {
				log.debug("CHSEqTpSzINVO : " + mGSEqTpSzINVOs);
				if ( mGSEqTpSzINVOs[i].getIbflag().equals("I")){
					mGSEqTpSzINVOs[i].setCreUsrId(account.getUsr_id());
					mGSEqTpSzINVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mGSEqTpSzINVOs[i]);
				} else if ( mGSEqTpSzINVOs[i].getIbflag().equals("U")){
					mGSEqTpSzINVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mGSEqTpSzINVOs[i]);
				} else if ( mGSEqTpSzINVOs[i].getIbflag().equals("D")){
					deleteVoList.add(mGSEqTpSzINVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addMGSEqTypeSizeData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMGSEqTypeSizeData(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMGSEqTypeSizeData(deleteVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException {
		try {
			return dbDao.searchCHSEqSpecData(cHSEqSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis의 Eq spec 에 해당하는 장비들이 있는지 조회한다. Retrieve [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqSpecMGTVO> searchCHSEqInEqSpecBasic(CHSEqSpecINVO cHSEqSpecINVO) throws EventException
	{
		try {
			return dbDao.searchCHSEqInEqSpecData(cHSEqSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVO CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSpecINVO, SignOnUserAccount account) throws EventException{
		try {
			List<CHSEqSpecINVO> insertVoList = new ArrayList<CHSEqSpecINVO>();
			List<CHSEqSpecINVO> updateVoList = new ArrayList<CHSEqSpecINVO>();

			for ( int i=0; i<cHSEqSpecINVO.length; i++ ) {

				log.debug("CHSEqSpecINVO : " + cHSEqSpecINVO);
				if ( cHSEqSpecINVO[i].getIbflag().equals("I")){
					cHSEqSpecINVO[i].setCreUsrId(account.getUsr_id());
					cHSEqSpecINVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(cHSEqSpecINVO[i]);
					log.debug("Check !!! ");
				} else if ( cHSEqSpecINVO[i].getIbflag().equals("U")){
					cHSEqSpecINVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(cHSEqSpecINVO[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addCHSEqSpecData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCHSEqSpecData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis의 Eq spec 정보를 삭제한다. Remove [EES_CGM_1002]<br>
	 *
	 * @param cHSEqSPECINVOs CHSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeCHSEqSpecBasic(CHSEqSpecINVO[] cHSEqSpecINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CHSEqSpecINVO> deleteVoList = new ArrayList<CHSEqSpecINVO>();

			for ( int i=0; i<cHSEqSpecINVOs.length; i++ ) {

				log.debug("CHSEqTpSzINVO : " + cHSEqSpecINVOs);
				if ( cHSEqSpecINVOs[i].getIbflag().equals("D")){
					deleteVoList.add(cHSEqSpecINVOs[i]);
				}
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCHSEqSpecData(deleteVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Master 기본 정보를 조회한다. Retrieve. [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireINVO CHSOffHireINVO
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> searchCHSOffhireInfoBasic(CHSOffHireINVO cHSOffHireINVO) throws EventException {
		try {
			return dbDao.searchCHSOffhireInfoData(cHSOffHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Off-hire 수행에 필요한 Verify [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @return List<CHSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOffHireMGTVO> verifyCHSOffhireBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs) throws EventException {
		try {
		    List<CHSOffHireMGTVO> tmpVo = new  ArrayList<CHSOffHireMGTVO>();
		    CHSOffHireMGTVO tmp  = new CHSOffHireMGTVO();
		    CHSOffHireMGTVO tmp2 = new CHSOffHireMGTVO();

			for ( int i=0; i<cHSOffHireMGTVOs.length; i++ ) {
				tmp = new CHSOffHireMGTVO();
				tmp = cHSOffHireMGTVOs[i];
				log.debug(".getIbflag()==============================="+tmp.getIbflag());
				if(tmp.getIbflag().equals("U")){
					tmp2 = dbDao.checkCHSVerifyOffhireStatusData(tmp);
					if(tmp2 == null)
					{
						tmp.setVerify("Failed");
					}
					else
					{
						tmp.setVerify(tmp2.getVerify());
					}
				}else{
					tmp.setVerify("");
				}


				tmpVo.add(tmp);
			}
			return tmpVo;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 반납(Eq Offhire) 수행한다. Off-Hire Confim [EES_CGM_1009]<br>
	 *
	 * @param cHSOffHireMGTVOs CHSOffHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSOffhireEquipmentBasic(CHSOffHireMGTVO[] cHSOffHireMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CHSOffHireMGTVO> updateVoList = new ArrayList<CHSOffHireMGTVO>();
			for ( int i=0; i<cHSOffHireMGTVOs .length; i++ ) {
				if ( cHSOffHireMGTVOs[i].getIbflag().equals("U")){
					log.debug("equipmentMGTVOs[i].getEqNo()==============================="+cHSOffHireMGTVOs[i].getEqNo());
					log.debug("equipmentMGTVOs[i].getIbflag()==============================="+cHSOffHireMGTVOs[i].getIbflag());
					cHSOffHireMGTVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(cHSOffHireMGTVOs[i]);
				}
			}
			log.debug("updateVoList.size()==============================="+updateVoList.size());
			log.debug("equipmentMGTVOs.size()==============================="+cHSOffHireMGTVOs.length);
			if ( updateVoList.size() > 0 ) {
				// EQ_STS_SEQ 추가로 로직 수정
//
				// CGM_EQ_STS_HIS 입력
				dbDao.addCHSOffhireEquipmentHistoryData(updateVoList);
				// CGM_EQUIPMENT 업데이트
				dbDao.modifyCHSOffhireEquipmentData (updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Master 기본 정보를 조회한다. Retrieve. [EES_CGM_2011]<br>
	 *
	 * @param mGSOffHireINVO MGSOffHireINVO
	 * @return List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> searchMGSOffhireInfoBasic(MGSOffHireINVO mGSOffHireINVO) throws EventException {
		try {
			return dbDao.searchMGSOffhireInfoData(mGSOffHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Off-hire 수행에 필요한 Verify [EES_CGM_2011]<br>
	 *
	 * @param mgsOffHireINVOs MGSOffHireMGTVO[]
	 * @return  List<MGSOffHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOffHireMGTVO> verifyMGSOffhireBasic(MGSOffHireMGTVO[] mGSOffHireINVOs) throws EventException {
		try {
		    List<MGSOffHireMGTVO> tmpVo = new  ArrayList<MGSOffHireMGTVO>();
		    MGSOffHireINVO  mp   = new MGSOffHireINVO();
		    MGSOffHireMGTVO tmp   = new MGSOffHireMGTVO();
		    MGSOffHireMGTVO tmp2  = new MGSOffHireMGTVO();

			for ( int i=0; i<mGSOffHireINVOs.length; i++ ) {
				tmp = new MGSOffHireMGTVO();
				tmp = mGSOffHireINVOs[i];

				log.debug(".getIbflag()==============================="+tmp.getIbflag());
				log.debug(" mp.getEqNo : " + mp.getEqNo());
				log.debug(".getStsEvntDt()==============================="+tmp.getStsEvntDt());
				if(tmp.getIbflag().equals("U")){
					tmp2 = dbDao.checkMGSVerifyOffhireStatusData(tmp);
					if(tmp2 == null)
					{
						tmp.setVerify("Failed");
					}
					else
					{
						tmp.setVerify(tmp2.getVerify());
					}
				}
				else
				{
					tmp.setVerify("");
				}


				tmpVo.add(tmp);
			}
			return tmpVo;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 반납(Eq Offhire) 수행한다. Off-Hire Confim [EES_CGM_2011]<br>
	 *
	 * @param mGSOffHireMGTVOs MGSOffHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSOffhireEquipmentBasic(MGSOffHireMGTVO[] mGSOffHireMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSOffHireMGTVO> updateVoList = new ArrayList<MGSOffHireMGTVO>();
			for ( int i=0; i<mGSOffHireMGTVOs .length; i++ ) {
				if ( mGSOffHireMGTVOs[i].getIbflag().equals("U")){
					mGSOffHireMGTVOs[i].setUserId(account.getUsr_id());
					updateVoList.add(mGSOffHireMGTVOs[i]);
				}
			}
			log.debug("updateVoList.size()==============================="+updateVoList.size());
			log.debug("equipmentMGTVOs.size()==============================="+mGSOffHireMGTVOs.length);
			if ( updateVoList.size() > 0 ) {
				// EQ_STS_SEQ 추가로 로직 수정
//
				// CGM_EQ_STS_HIS 입력
				dbDao.addMGSOffhireEquipmentHistoryData(updateVoList);
				// CGM_EQUIPMENT 업데이트
				dbDao.modifyMGSOffhireEquipmentData (updateVoList);
			}

		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException {
		try {
			return dbDao.searchMGSEqSpecData(mGSEqSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보가 중복되는지 조회한다. Retrieve [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEqSpecMGTVO> searchMGSEqSpecDupBasic(MGSEqSpecINVO mGSEqSpecINVO) throws EventException {
		try {
			return dbDao.searchMGSEqSpecDupData(mGSEqSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVOs MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSpecINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSEqSpecINVO> insertVoList = new ArrayList<MGSEqSpecINVO>();
			List<MGSEqSpecINVO> updateVoList = new ArrayList<MGSEqSpecINVO>();
			for ( int i=0; i<mGSEqSpecINVOs.length; i++ ) {

				//log.debug("☆★☆ GSEqSpecINVO : " + mGSEqSpecINVO);
				if ( mGSEqSpecINVOs[i].getIbflag().equals("I")){
					mGSEqSpecINVOs[i].setCreUsrId(account.getUsr_id());
					mGSEqSpecINVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mGSEqSpecINVOs[i]);
				} else if ( mGSEqSpecINVOs[i].getIbflag().equals("U")){
					mGSEqSpecINVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mGSEqSpecINVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addMGSEqSpecData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMGSEqSpecData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보를 삭제한다. Remove [EES_CGM_2001]<br>
	 *
	 * @param mGSEqSPECINVO MGSEqSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSEqSpecBasic(MGSEqSpecINVO[] mGSEqSpecINVO, SignOnUserAccount account) throws EventException{
		try {
			List<MGSEqSpecINVO> deleteVoList = new ArrayList<MGSEqSpecINVO>();

			for ( int i=0; i<mGSEqSpecINVO.length; i++ ) {

				log.debug("CHSEqTpSzINVO : " + mGSEqSpecINVO);
				if ( mGSEqSpecINVO[i].getIbflag().equals("D")){
					deleteVoList.add(mGSEqSpecINVO[i]);
				}
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMGSEqSpecData(deleteVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq On-hire, Off-hire 내역을 조회한다 Retrieve. [EES_CGM_1010]<br>
	 *
	 * @param cHSOnOffhireSummaryINVO CHSOnOffhireSummaryINVO
	 * @return List<CHSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnOffhireSummaryMGTVO> searchCHSOnOffhireBasic(CHSOnOffhireSummaryINVO cHSOnOffhireSummaryINVO) throws EventException {
		try {
			log.debug("searchCHSEqOnOffhireBasic================|"+cHSOnOffhireSummaryINVO.getStrGubun()+"|");

			String sTmp = cHSOnOffhireSummaryINVO.getVndrSeq();

			if(sTmp != null && !sTmp.equals("") && cHSOnOffhireSummaryINVO.getKind().equals("A") )
			{
				String[] vndrSeq	= null;
				String  tmp = "";
				vndrSeq = sTmp.split(",");
				log.debug("searchCHSOnOffhireBasic ==========VndrSeq=="+vndrSeq.length);
				for (int j=0; j<vndrSeq.length; j++) {
					 tmp = vndrSeq[j].trim();
					if(j==0)
					{
						sTmp = "('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
					}
					else
					{
						sTmp = sTmp+ ",('"+ tmp.substring(0,3)+"',"+Integer.parseInt( tmp.substring(3, tmp.length()))+")";
					}
				}
				log.debug("searchCHSOnOffhireBasic ==========sTmp=="+sTmp);
				cHSOnOffhireSummaryINVO.setVndrSeq(sTmp);
			}

			log.debug("sTmp================|"+sTmp+"|");

			// chungpa 20100405 combo 변경 single => multi start
			//String crntLocCd = chsInventoryGeneralINVO.getCrntLocCd();
			String agmtLstmCd = cHSOnOffhireSummaryINVO.getAgmtLstmCd();
			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				cHSOnOffhireSummaryINVO.setAgmtLstmCd(agmtLstmCd);
			}
			//chungpa 20100405 combo 변경 single => multi end

			if(cHSOnOffhireSummaryINVO.getStrGubun().equals("S"))
			{
				log.debug("searchCHSOnOffhireBasic================|"+cHSOnOffhireSummaryINVO.getStrGubun()+"|");
				return dbDao.searchCHSOnOffhireData(cHSOnOffhireSummaryINVO);
			}
			else
			{
				log.debug("searchCHSOnOffhireBasic================|rrrrrrrrrrrrrrrrrrrr"+cHSOnOffhireSummaryINVO.getStrGubun()+"|");
				return dbDao.searchCHSOnOffhireDetailData (cHSOnOffhireSummaryINVO);
			}

		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Chassis 의 Registration 정보를 조회한다. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSEqRegistrationBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException {
		try {
			return dbDao.searchCHSEquipmentData(cHSEquipmentINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 서버에 중복된 Alias No 존재 여부 조회. Retrieve [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEquipmentMGTVO> searchCHSAliasNoBasic(CHSEquipmentINVO cHSEquipmentINVO) throws EventException {
		try {
			return dbDao.searchCHSAliasNoData(cHSEquipmentINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Chassis 의 Registration 정보를 생성 및 수정한다. Manage [EES_CGM_1006]<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqRegistrationBasic(CHSEquipmentINVO[] cHSEquipmentINVO, SignOnUserAccount account) throws EventException{
		try {
			List<CHSEquipmentINVO> updateVoList = new ArrayList<CHSEquipmentINVO>();

			log.debug("updateVoList : " + updateVoList);
			log.debug("modifyCHSEqRegistrationBasic BCIMPL ****************");
			for ( int i=0; i<cHSEquipmentINVO.length; i++ ) {

				if ( cHSEquipmentINVO[i].getIbflag().equals("U")){
					cHSEquipmentINVO[i].setUpdUsrId(account.getUsr_id());
					//chungpa 20090826 on-hire ofc 적용.
					cHSEquipmentINVO[i].setChssRgstUpdOfcCd(account.getOfc_cd());
					updateVoList.add(cHSEquipmentINVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCHSEquipmentData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq On-hire, Off-hire 내역을 조회한다. Retrieve. [EES_CGM_2012]<br>
	 *
	 * @param mGSOnOffhireSummaryINVO MGSOnOffhireSummaryINVO
	 * @return List<MGSOnOffhireSummaryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnOffhireSummaryMGTVO> searchMGSOnOffhireBasic(MGSOnOffhireSummaryINVO mGSOnOffhireSummaryINVO) throws EventException {
		try {
//			log.debug("searchCHSEqOnOffhireBasic================|"+mgsOnOffhireSummaryINVO.getStrGubun()+"|");
			String sTmp = mGSOnOffhireSummaryINVO.getVndrSeq();

			if(sTmp != null && !sTmp.equals("") && mGSOnOffhireSummaryINVO.getKind().equals("A") )
			{
				String[] vndrSeq	= null;
				String  tmp = "";
				vndrSeq = sTmp.split(",");
				log.debug("searchMGSOnOffhireBasic ==========VndrSeq=="+vndrSeq.length);
				for (int j=0; j<vndrSeq.length; j++) {
					tmp = vndrSeq[j].trim();
					if(j==0)
					{
						sTmp = "('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
					}
					else
					{
						sTmp = sTmp+ ",('"+tmp.substring(0,3)+"',"+Integer.parseInt(tmp.substring(3,tmp.length()))+")";
					}
				}
				log.debug("searchMGSOnOffhireBasic ==========sTmp=="+sTmp);
				mGSOnOffhireSummaryINVO.setVndrSeq(sTmp);
			}

			// chungpa 20100405 combo 변경 single => multi start
			//String crntLocCd = chsInventoryGeneralINVO.getCrntLocCd();
			String agmtLstmCd = mGSOnOffhireSummaryINVO.getAgmtLstmCd();
			if(agmtLstmCd != null && !agmtLstmCd.equals("")){
				agmtLstmCd = "'" + agmtLstmCd.replaceAll(",", "','") + "'";
				mGSOnOffhireSummaryINVO.setAgmtLstmCd(agmtLstmCd);
			}
			//chungpa 20100405 combo 변경 single => multi end

			if(mGSOnOffhireSummaryINVO.getStrGubun().equals("S"))
			{
				log.debug("searchMGSEqOnOffhireData================|"+mGSOnOffhireSummaryINVO.getStrGubun()+"|");
				return dbDao.searchMGSOnOffhireData(mGSOnOffhireSummaryINVO);
//				return null;
			}
			else
			{
				log.debug("searchMGSEqOnOffhireDetailData================|rrrrrrrrrrrrrrrrrrrr"+mGSOnOffhireSummaryINVO.getStrGubun()+"|");
				return dbDao.searchMGSOnOffhireDetailData (mGSOnOffhireSummaryINVO);
//				return dbDao.searchCHSEqOnOffhireData(chsEqOnOffhireSummaryINVO);
//				return null;
			}

		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

//	/**
//	 * 타업무에서 호출
//	 * 멀티 이벤트 처리<br>
//	 * In화면에 대한 멀티 이벤트 처리 <br>
//	 *
//	 * @param IFMnrFlagVO List<IFMnrFlagVO>
//	 * @exception EventException
//	 */
//	public void createMNRStatusBasic(List<IFMnrFlagVO> IFMnrFlagVOs) throws  EventException{
//		try {
//			List<IFMnrFlagVO> updateVoList = new ArrayList<IFMnrFlagVO>();

//			for ( int i=0; i<cHSEquipmentINVO.length; i++ ) {
//
//				if ( cHSEquipmentINVO[i].getIbflag().equals("U")){
//					cHSEquipmentINVO[i].setUpdUsrId(account.getUsr_id());
//					updateVoList.add(cHSEquipmentINVO[i]);
//				}
//			}
//			if ( updateVoList.size() > 0 ) {
//				dbDao.modifyCHSEquipmentData(updateVoList);
//			}
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}

	/**
	 * chassis Pool 을 조회한다. Retrieve [EES_CGM_1007]<br>
	 *
	 * @param cHSEqPoolInfoINVO CHSEqPoolInfoINVO
	 * @return List<CHSEqPoolInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSEqPoolInfoMGTVO> searchCHSEqiPoolListBasic(CHSEqPoolInfoINVO cHSEqPoolInfoINVO) throws EventException {
		try {
			// LOCATION 값 다건이 넘어오는 경우 쿼리에 IN 조건으로 넣기 위한 처리
			String lTmp = cHSEqPoolInfoINVO.getSccCd();
			if(lTmp.length() > 0){
				String sccCd = null;
				sccCd = "'"+lTmp.replaceAll(",", "','")+"'";
				//log.debug("******************** SCCCD : " + sccCd);
				cHSEqPoolInfoINVO.setSccCd(sccCd);
			} else {
				//2011.06.14 sccCd를 ""로 수정
				//객체에 null 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
				//String sccCd = null;
				//log.debug("******************** SCCCD : " + sccCd);
				cHSEqPoolInfoINVO.setSccCd("");
			}
			// YARD 값 다건이 넘어오는 경우 쿼리에 IN 조건으로 넣기 위한 처리
			String yTmp = cHSEqPoolInfoINVO.getCrntYdCd();
			if(yTmp.length() > 0){
				String crntYdCd = null;
				crntYdCd = "'"+yTmp.replaceAll(",", "','")+"'";
				//log.debug("******************** CRNTYDCD : " + crntYdCd);
				cHSEqPoolInfoINVO.setCrntYdCd(crntYdCd);
			} else {
				//2011.06.14 sccCd를 ""로 수정
				//객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
				//String crntYdCd = null;
				//log.debug("******************** CRNTYDCD : " + crntYdCd);
				cHSEqPoolInfoINVO.setCrntYdCd("");
			}

			return dbDao.searchCHSEqiPoolListData(cHSEqPoolInfoINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis Pool 을 Manage 한다. Manage [EES_CGM_1007]<br>
	 *
	 * @param cHSEquPoolInfoINVO CHSEqPoolInfoINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSEqPoolListBasic(CHSEqPoolInfoINVO[] cHSEquPoolInfoINVO, SignOnUserAccount account) throws EventException{

		try {
			List<CHSEqPoolInfoINVO> updateVoList = new ArrayList<CHSEqPoolInfoINVO>();

			for ( int i=0; i<cHSEquPoolInfoINVO.length; i++ ) {

				if (cHSEquPoolInfoINVO[i].getIbflag().equals("U")){
					cHSEquPoolInfoINVO[i].setChssRgstUpdId(account.getUsr_id());
					cHSEquPoolInfoINVO[i].setUpdUsrId(account.getUsr_id()); // chungpa 20090720 session id apply
					cHSEquPoolInfoINVO[i].setChssRgstUpdOfcCd(account.getOfc_cd()); // chungpa 20090720 session id apply
					updateVoList.add(cHSEquPoolInfoINVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCHSEqPoolInfoData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Master 기본 정보를 조회한다 Retrieve. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostINVO CHSFoundLostINVO
	 * @return List<CHSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundLostMGTVO> searchCHSInfoBasic(CHSFoundLostINVO cHSFoundLostINVO) throws EventException {
		try {
			return dbDao.searchCHSinfoData (cHSFoundLostINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비분실시 Lost  처리 한다.. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostMGTVO CHSFoundLostMGTVO
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSLostBasic(CHSFoundLostMGTVO cHSFoundLostMGTVO, SignOnUserAccount account) throws EventException{
		try {
			List<CHSFoundLostMGTVO> updateVoList = new ArrayList<CHSFoundLostMGTVO>();

			cHSFoundLostMGTVO.setUserId(account.getUsr_id());
			cHSFoundLostMGTVO.setLEvntDt(cHSFoundLostMGTVO.getLEvntDt()+cHSFoundLostMGTVO.getLEvntDtHm());
			updateVoList.add(cHSFoundLostMGTVO);
			if ( updateVoList.size() > 0 ) {

				// EQ_STS_SEQ 추가로 로직 수정
				// CGM_EQ_STS_HIS 입력
				dbDao.addCHSLostHistoryData(updateVoList);

                // CGM_EQUIPMENT 업데이트
				dbDao.modifyCHSLostData (updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Lost 장비 를 Found 처리 한다. SAVE. [EES_CGM_1017]<br>
	 *
	 * @param cHSFoundLostMGTVO CHSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundBasic(CHSFoundLostMGTVO cHSFoundLostMGTVO, SignOnUserAccount account) throws EventException{
		try {
			List<CHSFoundLostMGTVO> updateVoList = new ArrayList<CHSFoundLostMGTVO>();

			cHSFoundLostMGTVO.setUserId(account.getUsr_id());
			cHSFoundLostMGTVO.setFEvntDt(cHSFoundLostMGTVO.getFEvntDt()+cHSFoundLostMGTVO.getFEvntDtHm());
			updateVoList.add(cHSFoundLostMGTVO);
			if ( updateVoList.size() > 0 ) {
				// EQ_STS_SEQ 추가로 로직 수정
				// CGM_EQ_STS_HIS 입력
				dbDao.addCHSFoundHistoryData(updateVoList);
				// CGM_EQUIPMENT 업데이트
				dbDao.modifyCHSFoundData (updateVoList);


			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Master 기본 정보를 조회한다 Retrieve. [EES_CGM_2019]<br>
	 *
	 * @param mGSFoundLostINVO MGSFoundLostINVO
	 * @return List<MGSFoundLostMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSFoundLostMGTVO> searchMGSInfoBasic(MGSFoundLostINVO mGSFoundLostINVO) throws EventException {
		try {
			return dbDao.searchMGSinfoData (mGSFoundLostINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비분실시 Lost  처리 한다.. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mgsEqFoundLostMGTVO MGSFoundLostMGTVO
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSLostBasic(MGSFoundLostMGTVO mgsEqFoundLostMGTVO, SignOnUserAccount account) throws EventException{
		try {
			List<MGSFoundLostMGTVO> updateVoList = new ArrayList<MGSFoundLostMGTVO>();

			mgsEqFoundLostMGTVO.setUserId(account.getUsr_id());
			updateVoList.add(mgsEqFoundLostMGTVO);
			if ( updateVoList.size() > 0 ) {
				// EQ_STS_SEQ 추가로 로직 수정
				// CGM_EQ_STS_HIS 입력
				dbDao.addMGSLostHistoryData(updateVoList);
				// CGM_EQUIPMENT 업데이트
				dbDao.modifyMGSLostData (updateVoList);


			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Lost 장비 를 Found 처리 한다. SAVE. [EES_CGM_2019]<br>
	 *
	 * @param mGSEqFoundLostMGTVO MGSFoundLostMGTVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSFoundBasic(MGSFoundLostMGTVO mGSEqFoundLostMGTVO, SignOnUserAccount account) throws EventException{
		try {
			List<MGSFoundLostMGTVO> updateVoList = new ArrayList<MGSFoundLostMGTVO>();

			mGSEqFoundLostMGTVO.setUserId(account.getUsr_id());
			updateVoList.add(mGSEqFoundLostMGTVO);
			if ( updateVoList.size() > 0 ) {
				// EQ_STS_SEQ 추가로 로직 수정
				// CGM_EQ_STS_HIS 입력
				dbDao.addMGSFoundHistoryData(updateVoList);
				// CGM_EQUIPMENT 업데이트
				dbDao.modifyMGSFoundData (updateVoList);


			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Chassis Eq Master 기본 정보를 조회한다. Retrieve [EES_CGM_1003]<br>
	 *
	 * @param cHSMasterInfoINVO CHSMasterInfoINVO
	 * @return List<CHSMasterInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSMasterInfoMGTVO> searchCHSMasterInfoBasic(CHSMasterInfoINVO cHSMasterInfoINVO) throws EventException {
		try {
			return dbDao.searchCHSMasterInfoData(cHSMasterInfoINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 Lost 내역 summary 를 조회한다. Retrieve. [EES_CGM_1019]<br>
	 *
	 * @param cHSLostResultINVO CHSLostResultINVO
	 * @return List<CHSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSLostResultMGTVO> searchCHSLostResultBasic(CHSLostResultINVO cHSLostResultINVO) throws EventException {
		try {
			return dbDao.searchCHSLostResultData(cHSLostResultINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set Eq Master 기본 정보를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException {
		try {
			return dbDao.searchMGSEquipmentData(mGSEquipmentINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set Eq Master At/Dt 정보를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtHistoryBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException {
		try {
			return dbDao.searchMGSAtdtHistoryData(mGSEquipmentINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * ChassisMgsetOnOffhire의 MGSET에 ATTACH된 샤시를 조회한다. Retrieve [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSEquipmentMGTVO> searchMGSEquipmentAtChssBasic(MGSEquipmentINVO mGSEquipmentINVO) throws EventException
	{
		try {
			return dbDao.searchMGSEquipmentAtChssData(mGSEquipmentINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set Eq Master 기본 정보를 수정한다. Manage [EES_CGM_2006]<br>
	 *
	 * @param mGSEquipmentINVOs MGSEquipmentINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSEquipmentBasic(MGSEquipmentINVO[] mGSEquipmentINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSEquipmentINVO> insertVoList = new ArrayList<MGSEquipmentINVO>();
			List<MGSEquipmentINVO> updateVoList = new ArrayList<MGSEquipmentINVO>();

			for ( int i=0; i<mGSEquipmentINVOs.length; i++ ) {

				log.debug("MGSEquipmentINVO : " + mGSEquipmentINVOs);
				if ( mGSEquipmentINVOs[i].getIbflag().equals("I")){
					mGSEquipmentINVOs[i].setCreUsrId(account.getUsr_id());
					mGSEquipmentINVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(mGSEquipmentINVOs[i]);
				} else if ( mGSEquipmentINVOs[i].getIbflag().equals("U")){
					mGSEquipmentINVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(mGSEquipmentINVOs[i]);
				}
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addMGSEquipmentData(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMGSEquipmentData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 Lost 내역 summary 를 조회한다. Retrieve. [EES_CGM_2020]<br>
	 *
	 * @param mGSLostResultINVO MGSLostResultINVO
	 * @return List<MGSLostResultMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSLostResultMGTVO> searchMGSLostResultBasic(MGSLostResultINVO mGSLostResultINVO) throws EventException {
		try {
			return dbDao.searchMGSLostResultData(mGSLostResultINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 * Spec정보에 대한 Valiation Check를 수행한다. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkBasic(CHSSpecINVO cHSSpecINVO) throws EventException {
		try {
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchEqSpecChkData(cHSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * chassis 및 M.G.Set 장비의 SerialNo FM-TO 중복 체크. Retrieve [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchEqSpecChkFmToBasic(CHSSpecINVO cHSSpecINVO) throws EventException {
		try {
			log.debug("*******chungpa  getEqPfxCd : " + cHSSpecINVO.getEqPfxCd());
			log.debug("*******chungpa  getFmSerNo : " + cHSSpecINVO.getFmSerNo());
			log.debug("*******chungpa  getToSerNo : " + cHSSpecINVO.getToSerNo());

			return dbDao.searchEqSpecChkFmToData(cHSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq spec 정보를 조회한다. [EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSSpecBasic(CHSSpecINVO cHSSpecINVO) throws EventException {
		try {
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchCHSSpecData(cHSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Eq Own Master(LOT) 리스트를 조회한다.[EES_CGM_1005]<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSSpecMGTVO> searchCHSOwnMasterListBasic(CHSSpecINVO cHSSpecINVO) throws EventException {
		try {
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ CHSSpecINVO : " + cHSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchCHSOwnMasterListData(cHSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Own Master(Lot 정보) 생성시 해당 LOT 정보를 생성 및 Update 를 수행한다. [UI_CGM_1005, UI_CGM_2004]<br>
	 *
	 * @param cHSSpecINVOs CHSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSOwnMasterBasic(CHSSpecINVO[] cHSSpecINVOs, SignOnUserAccount account) throws EventException{
		Map<String, Object> responseData = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unused")
			boolean chkPoolMatch = true;
			// Response 객체를 담기위한 Map 객체

			Map<String, String> etcData = new HashMap<String, String>();
			List<CHSSpecINVO> iNVoList = new ArrayList<CHSSpecINVO>();
			log.debug("************ CHSSpecINVO.length : " + cHSSpecINVOs.length);
			for ( int i=0; i<cHSSpecINVOs.length; i++ ) {

				log.debug("CHSSpecINVO : " + cHSSpecINVOs);
				if ( cHSSpecINVOs[i].getIbflag().equals("I")){
					cHSSpecINVOs[i].setCreUsrId(account.getUsr_id());
				}
				cHSSpecINVOs[i].setUpdUsrId(account.getUsr_id());
				iNVoList.add(cHSSpecINVOs[i]);

				if ( iNVoList.size() > 0 ) {
					// 1. 마스트 입력/수정 단건
					if ( cHSSpecINVOs[i].getIbflag().equals("I")){

//						if(){
//							throw new EventException(new ErrorHandler("CGM20014",new String[]{}).getUserMessage());
//						}

						chkPoolMatch = dbDao.addCHSOwnMasterLotData(iNVoList);
					} else if ( cHSSpecINVOs[i].getIbflag().equals("U")){
						chkPoolMatch = dbDao.modifyCHSOwnMasterData(iNVoList);
						chkPoolMatch = dbDao.modifyCHSOwnMasterLotData(iNVoList);
					}

					CHSSpecINVO tmp = new CHSSpecINVO();
					int iUnit = 0;
					int itmp  = 0;
					tmp = iNVoList.get(0);
					iUnit = Integer.parseInt(tmp.getUnits());

					// 2. 디테일 입력/수정 다건
					for(int k=0; k<iUnit; k++){

						if(k==0){
							itmp = Integer.parseInt(tmp.getFmSerNo());
						} else {
							itmp = itmp + 1;
						}
						tmp.setFmSerNo(Integer.toString(itmp));

						iNVoList = new ArrayList<CHSSpecINVO>();
						iNVoList.add(tmp);

						if ( tmp.getIbflag().equals("I")){
							log.debug("************ INVoList : (vndr_seq patch by chungpa)" + iNVoList.size());
							chkPoolMatch = dbDao.addCHSOwnMasterData(iNVoList);
//						} else if ( tmp.getIbflag().equals("U")){
//							dbDao.modifyCHSOwnMasterLotData(INVoList);
						}
					}
				}
			}
			responseData.put(WebKeys.ER_ETCDATA, etcData);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
//		return responseData;
	}

	/**
	 *  장비 현황(status) History 를 조회한다. Retrieve. [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoINVO CHSStatusInfoINVO
	 * @return List<CHSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSStatusInfoMGTVO> searchCHSStatusBasic(CHSStatusInfoINVO cHSStatusInfoINVO) throws EventException {
		try {
			return dbDao.searchCHSStatusData(cHSStatusInfoINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Found Creation. [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
//		Map<String, Object> responseData = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
//			Map<String, String> etcData = new HashMap<String, String>();
			List<CHSStatusInfoMGTVO> updateVoList = new ArrayList<CHSStatusInfoMGTVO>();

			for ( int i=0; i<cHSStatusInfoMGTVOs.length; i++ ) {
				log.debug("account.getUsr_id()========"+account.getUsr_id());
				cHSStatusInfoMGTVOs[i].setCreUsrId(account.getUsr_id());
				cHSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(cHSStatusInfoMGTVOs[i].getAgreeement().substring(0,3));
				cHSStatusInfoMGTVOs[i].setAgmtSeq(cHSStatusInfoMGTVOs[i].getAgreeement().substring(3,cHSStatusInfoMGTVOs[i].getAgreeement().length()));
				log.debug("getAgmtSeq========"+cHSStatusInfoMGTVOs[i].getAgmtSeq());
				updateVoList.add(cHSStatusInfoMGTVOs[i]);
			}
			log.debug("modifyCHSStatusBasic===="+cHSStatusInfoMGTVOs.length);
			if ( updateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.modifyCHSStatusData(updateVoList);

				chkPoolMatch = dbDao.modifyCHSStatusHistoryData(updateVoList);
			}
			//etcData = chsStatusInfoMGTVOs.getColumnValues();

			// Response Data 설정
//			responseData.put(WebKeys.ER_ETCDATA, etcData);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
//		return responseData;
	}

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Delete [EES_CGM_1016]<br>
	 *
	 * @param cHSStatusInfoMGTVOs CHSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @return CHSStatusInfoMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public CHSStatusInfoMGTVO removeCHSStatusBasic(CHSStatusInfoMGTVO[] cHSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
//		Map<String, Object> responseData = new HashMap<String, Object>();
		CHSStatusInfoMGTVO chsStatus = new CHSStatusInfoMGTVO();
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
//			Map<String, String> etcData = new HashMap<String, String>();
			List<CHSStatusInfoMGTVO> updateVoList = new ArrayList<CHSStatusInfoMGTVO>();

			CHSStatusInfoMGTVO  chsStatusinfoMGTVO = new CHSStatusInfoMGTVO();
			CHSStatusInfoMGTVO  chsStatusinfo      = new CHSStatusInfoMGTVO();
			CHSStatusInfoMGTVO  chsStatusinfo2     = new CHSStatusInfoMGTVO();
//			CHSMasterMGTVO      cHSMasterMGTVO     = new CHSMasterMGTVO();
			String eqAsetStsCd = "";

			for ( int i=0; i<cHSStatusInfoMGTVOs.length; i++ ) {
				log.debug("account.getUsr_id()========"+account.getUsr_id());
				cHSStatusInfoMGTVOs[i].setCreUsrId(account.getUsr_id());
				cHSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(cHSStatusInfoMGTVOs[i].getAgreeement().substring(0,3));
				cHSStatusInfoMGTVOs[i].setAgmtSeq(cHSStatusInfoMGTVOs[i].getAgreeement().substring(3,cHSStatusInfoMGTVOs[i].getAgreeement().length()));
				log.debug("getNo========"+cHSStatusInfoMGTVOs[i].getNo());
				cHSStatusInfoMGTVOs[i].setTermCngSeq("1");
				updateVoList.add(cHSStatusInfoMGTVOs[i]);

				// CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기
				chsStatusinfoMGTVO = dbDao.searchCHSStatusHistoryData(cHSStatusInfoMGTVOs[i]);

				// CGM_CHSS_MVMT_HIS 테이블에 Movement 정보 삭제를 위한 sts_evnt_dt 정보 넣기
//				responseData.put(WebKeys.ERROR_PAGE,chsStatusinfoMGTVO.getStsEvntDt());
				chsStatus.setStsEvntDt(chsStatusinfoMGTVO.getStsEvntDt());

				// A. 최초 LSI 된 건일 경우
				if(cHSStatusInfoMGTVOs[i].getNo().equals("1"))	{
					//  1. CGM_EQ_STS_HIS 테이블에서 History 정보 삭제
					chkPoolMatch = dbDao.removeCHSStatusHistoryData(updateVoList);

					//  2. CGM_EQUIPMENT 테이블 항목 Update 처리
					chkPoolMatch = dbDao.removeCHSStatusMasterData(updateVoList);


				} else {
					if(chsStatusinfoMGTVO.getTermCngSeq() == null || chsStatusinfoMGTVO.getTermCngSeq().equals("")){
					//  1. CGM_EQ_STS_HIS 테이블에서 History 정보 삭제
						chkPoolMatch = dbDao.removeCHSStatusHistoryData(updateVoList);
					} else {
					//  1. 단 Term Change인 경우 - 삭제대상이 CGM_EQ_STS_HIS 테이블의 TERM_CNG_SEQ 가 있는경우
					//  LSI, LSO 2개를 삭제처리한다.
					// 로직 만들기
						cHSStatusInfoMGTVOs[i].setTermCngSeq(chsStatusinfoMGTVO.getTermCngSeq());
						updateVoList = new ArrayList<CHSStatusInfoMGTVO>();
						updateVoList.add(cHSStatusInfoMGTVOs[i]);
						chkPoolMatch = dbDao.removeCHSStatusTermChangeHistoryData(updateVoList);
					}

					    log.debug("getAciacDivCd========="+cHSStatusInfoMGTVOs[i].getAciacDivCd());
					    log.debug("getEqAsetStsCd========="+cHSStatusInfoMGTVOs[i].getEqAsetStsCd());

					    eqAsetStsCd = cHSStatusInfoMGTVOs[i].getEqAsetStsCd();
					    cHSStatusInfoMGTVOs[i].setEqAsetStsCd("");

//						 2. CGM_EQUIPMENT 테이블 항목 Update 처리
//
//						  1) 삭제대상 이전 Status 에 따라서  ACIAC_DIV_CD 컬럼 Update
//						   - LSI, SBR, FND  -> 'A'
//						   - LSO, SBO, LST, TLL -> 'I'
//						   - 이외의 상태는 Update 하지 않음.
//					    2) 다른 컬럼 Update
//						   - CGM_EQ_STS_HIS 테이블에서 삭제이전 값을 가져와서 CRNT_YD_CD, CRNT_LOC_CD Update처리.
//						     -> 삭제대상이 'LSI'인 경우 이전의 LSI가 있으면 이전 LSI의 정보를 가져와서 ONH_OFC_CD, ONH_DT, ONH_YD_CD Update 처리.
//						   - CHSS_MVMT_DEST_YD_CD, CHSS_MVMT_STS_CD, CHSS_MVMT_DT,  GATE_IO_CD 값은 CGM_CHSS_MVMT_HIS 테이블에서 삭제 이전 정보를 가져와서 Update 처리.
//
//						  3) CGM_EQ_STS_HIS 테이블의 삭제대상 이전(Term Change인 경우 LSI,LSO 2개를 지운 이전) 상태 Agreement 정보를 가져와서 AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO 를 Updae 처리.
					    log.debug("getEqNo======================================"+cHSStatusInfoMGTVOs[i].getEqNo());
					chsStatusinfo = dbDao.searchCHSStatusHistoryLsiData(cHSStatusInfoMGTVOs[i]);
					eqAsetStsCd = chsStatusinfo.getEqAsetStsCd();
					if(eqAsetStsCd.equals("LSI")){
						cHSStatusInfoMGTVOs[i].setAciacDivCd("A");
						//
						// CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기
						// 삭제대상이 'LSI'인 경우 이전의 LSI가 있으면 이전 LSI의 정보를 가져와서 ONH_OFC_CD, ONH_DT, ONH_YD_CD Update 처리.
						log.debug("chsStatusInfoMGTVOs.getEqNo======================================"+cHSStatusInfoMGTVOs[i].getEqNo());
						chsStatusinfo2 = dbDao.searchCHSStatusHistoryLsiData(cHSStatusInfoMGTVOs[i]);

						cHSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(chsStatusinfo.getAgmtOfcCtyCd());
						cHSStatusInfoMGTVOs[i].setAgmtSeq(chsStatusinfo.getAgmtSeq());
						cHSStatusInfoMGTVOs[i].setAgmtVerNo(chsStatusinfo.getAgmtVerNo());
						cHSStatusInfoMGTVOs[i].setStsEvntYdCd(chsStatusinfo.getStsEvntYdCd());
						cHSStatusInfoMGTVOs[i].setCrntLocCd(chsStatusinfo.getCrntLocCd());
						cHSStatusInfoMGTVOs[i].setOnhOfcCd(chsStatusinfo2.getStsEvntOfcCd());
						cHSStatusInfoMGTVOs[i].setOnhDt(chsStatusinfo2.getStsEvntDt());
						cHSStatusInfoMGTVOs[i].setOnhYdCd(chsStatusinfo2.getStsEvntYdCd());
						cHSStatusInfoMGTVOs[i].setEqAsetStsCd(eqAsetStsCd);
						updateVoList = new ArrayList<CHSStatusInfoMGTVO>();
						updateVoList.add(cHSStatusInfoMGTVOs[i]);
						chkPoolMatch = dbDao.removeCHSStatusMasterLsiData(updateVoList);
//						cHSMasterMGTVO     = new CHSMasterMGTVO();
//						cHSMasterMGTVO.setEqNo(chsStatusinfo.getEqNo());
//						dbDao.modifyCHSCgmEquipmentData(cHSMasterMGTVO);
					} else {
						if(eqAsetStsCd.equals("SBR")||eqAsetStsCd.equals("FND")){
							cHSStatusInfoMGTVOs[i].setAciacDivCd("A");
						} else if(eqAsetStsCd.equals("LSO")||eqAsetStsCd.equals("SBO")
								||eqAsetStsCd.equals("LST")||eqAsetStsCd.equals("TLL")
								){
							cHSStatusInfoMGTVOs[i].setAciacDivCd("I");
						}
						log.debug("getAgmtVerNo========="+chsStatusinfo.getAgmtVerNo());
						cHSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(chsStatusinfo.getAgmtOfcCtyCd());
						cHSStatusInfoMGTVOs[i].setAgmtSeq(chsStatusinfo.getAgmtSeq());
						cHSStatusInfoMGTVOs[i].setAgmtVerNo(chsStatusinfo.getAgmtVerNo());
						cHSStatusInfoMGTVOs[i].setStsEvntYdCd(chsStatusinfo.getStsEvntYdCd());
						cHSStatusInfoMGTVOs[i].setCrntLocCd(chsStatusinfo.getCrntLocCd());
						cHSStatusInfoMGTVOs[i].setEqAsetStsCd(eqAsetStsCd);
						updateVoList = new ArrayList<CHSStatusInfoMGTVO>();
						updateVoList.add(cHSStatusInfoMGTVOs[i]);
						//  2. CGM_EQUIPMENT 테이블 항목 Update 처리
						chkPoolMatch = dbDao.removeCHSStatusMasterNotLsiData(updateVoList);
//						cHSMasterMGTVO     = new CHSMasterMGTVO();
//						cHSMasterMGTVO.setEqNo(chsStatusinfo.getEqNo());
//						dbDao.modifyCHSCgmEquipmentData(cHSMasterMGTVO);
					}


				}

			}

			log.debug("modifyCHSStatusBasic===="+chsStatusinfoMGTVO.getStsEvntDt());

			// Response Data 설정
//			responseData.put(WebKeys.ER_ETCDATA, etcData);

		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return chsStatus;
	}

	/**
	 *  장비 현황(status) History 를 조회한다. Retrieve. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoINVO MGSStatusInfoINVO
	 * @return List<MGSStatusInfoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSStatusInfoMGTVO> searchMGSStatusBasic(MGSStatusInfoINVO mGSStatusInfoINVO) throws EventException {
		try {
			return dbDao.searchMGSStatusData(mGSStatusInfoINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Found Creation. [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
     * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
//		Map<String, Object> responseData = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
//			Map<String, String> etcData = new HashMap<String, String>();
			List<MGSStatusInfoMGTVO> updateVoList = new ArrayList<MGSStatusInfoMGTVO>();

			for ( int i=0; i<mGSStatusInfoMGTVOs.length; i++ ) {
				mGSStatusInfoMGTVOs[i].setCreUsrId(account.getUsr_id());
				mGSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(mGSStatusInfoMGTVOs[i].getAgreeement().substring(0,3));
				mGSStatusInfoMGTVOs[i].setAgmtSeq(mGSStatusInfoMGTVOs[i].getAgreeement().substring(3,mGSStatusInfoMGTVOs[i].getAgreeement().length()));
				log.debug("getAgmtSeq========"+mGSStatusInfoMGTVOs[i].getAgmtSeq());
				updateVoList.add(mGSStatusInfoMGTVOs[i]);
			}

			log.debug("modifyCHSStatusBasic===="+mGSStatusInfoMGTVOs.length);
			if ( updateVoList.size() > 0 ) {
				chkPoolMatch = dbDao.modifyMGSStatusData(updateVoList);


				chkPoolMatch = dbDao.modifyMGSStatusHistoryData(updateVoList);
			}
//			etcData = chsStatusInfoMGTVOs.getColumnValues();

			// Response Data 설정
//			responseData.put(WebKeys.ER_ETCDATA, etcData);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
//		return responseData;
	}

	/**
	 *  장비 현황 Status 를 변경 및 삭제 처리한다. Delete [EES_CGM_2018]<br>
	 *
	 * @param mGSStatusInfoMGTVOs MGSStatusInfoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeMGSStatusBasic(MGSStatusInfoMGTVO[] mGSStatusInfoMGTVOs, SignOnUserAccount account) throws EventException{
		// Response 객체를 담기위한 Map 객체
//		Map<String, Object> responseData = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		boolean chkPoolMatch = true;
		try {
			// ETC Data 를  담기위한 Map 객체
//			Map<String, String> etcData = new HashMap<String, String>();
			List<MGSStatusInfoMGTVO> updateVoList = new ArrayList<MGSStatusInfoMGTVO>();

			MGSStatusInfoMGTVO  mgsStatusinfoMGTVO = new MGSStatusInfoMGTVO();
			MGSStatusInfoMGTVO  mgsStatusinfo      = new MGSStatusInfoMGTVO();
			MGSStatusInfoMGTVO  mgsStatusinfo2     = new MGSStatusInfoMGTVO();
			String eqAsetStsCd = "";

			for ( int i=0; i<mGSStatusInfoMGTVOs.length; i++ ) {
				log.debug("account.getUsr_id()========"+account.getUsr_id());
				mGSStatusInfoMGTVOs[i].setCreUsrId(account.getUsr_id());
				mGSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(mGSStatusInfoMGTVOs[i].getAgreeement().substring(0,3));
				mGSStatusInfoMGTVOs[i].setAgmtSeq(mGSStatusInfoMGTVOs[i].getAgreeement().substring(3,mGSStatusInfoMGTVOs[i].getAgreeement().length()));
				log.debug("getNo========"+mGSStatusInfoMGTVOs[i].getNo());
				mGSStatusInfoMGTVOs[i].setTermCngSeq("1");
				updateVoList.add(mGSStatusInfoMGTVOs[i]);

				// CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기
				mgsStatusinfoMGTVO = dbDao.searchMGSStatusHistoryData(mGSStatusInfoMGTVOs[i]);

//				// A. 최초 LSI 된 건일 경우
				if(mGSStatusInfoMGTVOs[i].getNo().equals("1"))	{
					//  1. CGM_EQ_STS_HIS 테이블에서 History 정보 삭제
					chkPoolMatch = dbDao.removeMGSStatusHistoryData(updateVoList);

					//  2. CGM_EQUIPMENT 테이블 항목 Update 처리
					chkPoolMatch = dbDao.removeMGSStatusMasterData(updateVoList);

				} else {
					if(mgsStatusinfoMGTVO.getTermCngSeq() == null || mgsStatusinfoMGTVO.getTermCngSeq().equals("")){
					//  1. CGM_EQ_STS_HIS 테이블에서 History 정보 삭제
						chkPoolMatch = dbDao.removeMGSStatusHistoryData(updateVoList);
					} else {
					//  1. 단 Term Change인 경우 - 삭제대상이 CGM_EQ_STS_HIS 테이블의 TERM_CNG_SEQ 가 있는경우
					//  LSI, LSO 2개를 삭제처리한다.
					// 로직 만들기
						mGSStatusInfoMGTVOs[i].setTermCngSeq(mgsStatusinfoMGTVO.getTermCngSeq());
						updateVoList = new ArrayList<MGSStatusInfoMGTVO>();
						updateVoList.add(mGSStatusInfoMGTVOs[i]);
						chkPoolMatch = dbDao.removeMGSStatusTermChangeHistoryData(updateVoList);
					}

					    log.debug("getAciacDivCd========="+mGSStatusInfoMGTVOs[i].getAciacDivCd());
					    log.debug("getEqAsetStsCd========="+mGSStatusInfoMGTVOs[i].getEqAsetStsCd());
					    eqAsetStsCd = mGSStatusInfoMGTVOs[i].getEqAsetStsCd();
					    mGSStatusInfoMGTVOs[i].setEqAsetStsCd("");

//						 2. CGM_EQUIPMENT 테이블 항목 Update 처리
//
//						  1) 삭제대상 이전 Status 에 따라서  ACIAC_DIV_CD 컬럼 Update
//						   - LSI, SBR, FND  -> 'A'
//						   - LSO, SBO, LST, TLL -> 'I'
//						   - 이외의 상태는 Update 하지 않음.
//					    2) 다른 컬럼 Update
//						   - CGM_EQ_STS_HIS 테이블에서 삭제이전 값을 가져와서 CRNT_YD_CD, CRNT_LOC_CD Update처리.
//						     -> 삭제대상이 'LSI'인 경우 이전의 LSI가 있으면 이전 LSI의 정보를 가져와서 ONH_OFC_CD, ONH_DT, ONH_YD_CD Update 처리.
//						   - CHSS_MVMT_DEST_YD_CD, CHSS_MVMT_STS_CD, CHSS_MVMT_DT, GATE_IO_CD 값은 CGM_CHSS_MVMT_HIS 테이블에서 삭제 이전 정보를 가져와서 Update 처리.
//
//						  3) CGM_EQ_STS_HIS 테이블의 삭제대상 이전(Term Change인 경우 LSI,LSO 2개를 지운 이전) 상태 Agreement 정보를 가져와서 AGMT_OFC_CTY_CD, AGMT_SEQ, AGMT_VER_NO 를 Updae 처리.
					    log.debug("getEqNo======================================"+mGSStatusInfoMGTVOs[i].getEqNo());
					mgsStatusinfo = dbDao.searchMGSStatusHistoryLsiData(mGSStatusInfoMGTVOs[i]);
					eqAsetStsCd = mgsStatusinfo.getEqAsetStsCd();
					if(eqAsetStsCd.equals("LSI")){
						mGSStatusInfoMGTVOs[i].setAciacDivCd("A");
						//
						// CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기
						// 삭제대상이 'LSI'인 경우 이전의 LSI가 있으면 이전 LSI의 정보를 가져와서 ONH_OFC_CD, ONH_DT, ONH_YD_CD Update 처리.
						log.debug("mgsStatusInfoMGTVOs.getEqNo======================================"+mGSStatusInfoMGTVOs[i].getEqNo());
						mgsStatusinfo2 = dbDao.searchMGSStatusHistoryLsiData(mGSStatusInfoMGTVOs[i]);

						mGSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(mgsStatusinfo.getAgmtOfcCtyCd());
						mGSStatusInfoMGTVOs[i].setAgmtSeq(mgsStatusinfo.getAgmtSeq());
						mGSStatusInfoMGTVOs[i].setAgmtVerNo(mgsStatusinfo.getAgmtVerNo());
						mGSStatusInfoMGTVOs[i].setStsEvntYdCd(mgsStatusinfo.getStsEvntYdCd());
						mGSStatusInfoMGTVOs[i].setCrntLocCd(mgsStatusinfo.getCrntLocCd());
						mGSStatusInfoMGTVOs[i].setOnhOfcCd(mgsStatusinfo2.getAgmtOfcCtyCd());
						mGSStatusInfoMGTVOs[i].setOnhDt(mgsStatusinfo2.getStsEvntDt());
						mGSStatusInfoMGTVOs[i].setOnhYdCd(mgsStatusinfo2.getStsEvntYdCd());
						mGSStatusInfoMGTVOs[i].setEqAsetStsCd(eqAsetStsCd);
						updateVoList = new ArrayList<MGSStatusInfoMGTVO>();
						updateVoList.add(mGSStatusInfoMGTVOs[i]);
						chkPoolMatch = dbDao.removeMGSStatusMasterLsiData(updateVoList);
					} else {
						if(eqAsetStsCd.equals("SBR")||eqAsetStsCd.equals("FND")){
							mGSStatusInfoMGTVOs[i].setAciacDivCd("A");
						} else if(eqAsetStsCd.equals("LSO")||eqAsetStsCd.equals("SBO")
								||eqAsetStsCd.equals("LST")||eqAsetStsCd.equals("TLL")
								){
							mGSStatusInfoMGTVOs[i].setAciacDivCd("I");
						}
						log.debug("getAgmtVerNo========="+mgsStatusinfo.getAgmtVerNo());
						mGSStatusInfoMGTVOs[i].setAgmtOfcCtyCd(mgsStatusinfo.getAgmtOfcCtyCd());
						mGSStatusInfoMGTVOs[i].setAgmtSeq(mgsStatusinfo.getAgmtSeq());
						mGSStatusInfoMGTVOs[i].setAgmtVerNo(mgsStatusinfo.getAgmtVerNo());
						mGSStatusInfoMGTVOs[i].setStsEvntYdCd(mgsStatusinfo.getStsEvntYdCd());
						mGSStatusInfoMGTVOs[i].setCrntLocCd(mgsStatusinfo.getCrntLocCd());
						mGSStatusInfoMGTVOs[i].setEqAsetStsCd(eqAsetStsCd);
						updateVoList = new ArrayList<MGSStatusInfoMGTVO>();
						updateVoList.add(mGSStatusInfoMGTVOs[i]);
						//  2. CGM_EQUIPMENT 테이블 항목 Update 처리
						chkPoolMatch = dbDao.removeMGSStatusMasterNotLsiData(updateVoList);
					}
				}
			}
			// Response Data 설정
//			responseData.put(WebKeys.ER_ETCDATA, etcData);

		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
//		return responseData;
	}

	/**
	 * M.G.Set 장비의 Eq spec 중복 여부를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecChkBasic(MGSSpecINVO mGSSpecINVO) throws EventException {
		try {
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchMGSSpecChkData(mGSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq Own Master(LOT) 리스트를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSOwnMasterListBasic(MGSSpecINVO mGSSpecINVO) throws EventException {
		try {
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchMGSOwnMasterListData(mGSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보를 조회한다. Retrieve [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSSpecMGTVO> searchMGSSpecBasic(MGSSpecINVO mGSSpecINVO) throws EventException {
		try {
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtOfcCtyCd());
			log.debug("************ MGSSpecINVO : " + mGSSpecINVO.getAgmtIssOfcCd());
			return dbDao.searchMGSSpecData(mGSSpecINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * M.G.Set 장비의 Eq spec 정보를 생성 및 수정한다. Manage [EES_CGM_2004]<br>
	 *
	 * @param mGSSpecINVOs MGSSpecINVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSOwnMasterBasic(MGSSpecINVO[] mGSSpecINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSSpecINVO> iNVoList = new ArrayList<MGSSpecINVO>();
			log.debug("************ MGSSpecINVO.length : " + mGSSpecINVOs.length);
			for ( int i=0; i<mGSSpecINVOs.length; i++ ) {

				log.debug("MGSSpecINVO : " + mGSSpecINVOs);
				if ( mGSSpecINVOs[i].getIbflag().equals("I")){
					mGSSpecINVOs[i].setCreUsrId(account.getUsr_id());
				}
				mGSSpecINVOs[i].setUpdUsrId(account.getUsr_id());
				iNVoList.add(mGSSpecINVOs[i]);

				if ( iNVoList.size() > 0 ) {
					// 1. 마스트 입력/수정 단건
					if ( mGSSpecINVOs[i].getIbflag().equals("I")){
						dbDao.addMGSSpecOwnMasterLotData(iNVoList);

					} else if ( mGSSpecINVOs[i].getIbflag().equals("U")){
						//업데이트시에는 1회로 전체 수정
						dbDao.modifyMGSSpecOwnMasterData(iNVoList);
						dbDao.modifyMGSSpecOwnMasterLotData(iNVoList);
					}

					MGSSpecINVO tmp = new MGSSpecINVO();
					int iUnit = 0;
					int itmp  = 0;
					tmp = iNVoList.get(0);
					iUnit = Integer.parseInt(tmp.getUnits());

					log.debug("**************** " + iUnit);

					// 2. 디테일 입력/수정 다건
					for(int k=0; k<iUnit; k++){

						if(k==0){
							itmp = Integer.parseInt(tmp.getFmSerNo());
						} else {
							itmp = itmp + 1;
						}
						tmp.setFmSerNo(Integer.toString(itmp));
						log.debug("***********getFmSerNo*** " + tmp.getFmSerNo());
						iNVoList = new ArrayList<MGSSpecINVO>();
						iNVoList.add(tmp);

						if ( tmp.getIbflag().equals("I")){
							log.debug("************ INVoList : " + iNVoList.size());
							dbDao.addMGSSpecOwnMasterData(iNVoList);
//						} else if ( tmp.getIbflag().equals("U")){
//							dbDao.modifyMGSSpecOwnMasterLotData(iNVoList);
						}
					}
				}
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  On-Hire 시킬 Chassis No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다.. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireStatusChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException {
		try {
			return dbDao.searchCHSOnHireStatusChkData(cHSOnHireINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  On-Hire 시 기존에 등록되어 있는 Chassis 의 chss_veh_id_no, chss_tit_no, chss_als_no 가 있는지 체크한다. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOnHireDupChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException {
		try {
			log.debug("####### searchCHSOnHireDupChkBasic #######");
			return dbDao.searchCHSOnHireDupChkData(cHSOnHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  O(자가, 임대 장비 확인용 메소드. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVO CHSOnHireINVO
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> searchCHSOwnLeaseChkBasic(CHSOnHireINVO cHSOnHireINVO) throws EventException {
		try {
			log.debug("####### searchCHSOwnLeaseChkBasic #######");
			return dbDao.searchCHSOwnLeaseChkData(cHSOnHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 임차(Eq Onhire) 수행한다. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @return List<CHSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSOnHireMGTVO> verifyCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs) throws EventException {
		try {
			List<CHSOnHireMGTVO> tmpVo = new ArrayList<CHSOnHireMGTVO>();

			CHSOnHireINVO mp    = new CHSOnHireINVO();
			CHSOnHireMGTVO tmp  = new CHSOnHireMGTVO();
			CHSOnHireMGTVO tmp2 = new CHSOnHireMGTVO();

			for ( int i=0; i<cHSOnHireINVOs.length; i++ ) {
				tmp = new CHSOnHireMGTVO();
				mp = new CHSOnHireINVO();
				tmp = cHSOnHireINVOs[i];



				if((tmp.getIbflag().equals("U") ||tmp.getIbflag().equals("I") )&& tmp.getDelChk().equals("1")){
					mp.setEqNo(tmp.getEqNo());
					mp.setEqKndCd(tmp.getEqKndCd());
					mp.setChssTitNo(tmp.getChssTitNo());
					mp.setChssVehIdNo(tmp.getChssVehIdNo());
					mp.setOwnLse(tmp.getOwnLse());
					mp.setEqTpszCd(tmp.getEqTpszCd());
					mp.setOnhDt(tmp.getOnhDt());
					mp.setAgreementNo(tmp.getAgreementNo());
					mp.setAgmtOfcCtyCd(tmp.getAgreementNo().substring(0,3));
					mp.setAgmtSeq(String.valueOf(Integer.parseInt(tmp.getAgreementNo().substring(3,tmp.getAgreementNo().length()))));
					log.debug("####### getIbflag  ####### " + tmp.getIbflag());
					log.debug("####### getIbflag  ####### " + tmp.getOwnLse());
					log.debug("####### getEqNo    ####### " + mp.getEqNo());
					log.debug("####### getEqKndCd ####### " + mp.getEqKndCd());
					log.debug("####### getOwnLse  ####### " + mp.getOwnLse());
					log.debug("####### getDelChk  ####### " + mp.getDelChk());
					log.debug("####### getOnhDt  ####### " + mp.getOnhDt());
					log.debug("####### getEqTpszCd  ####### " + mp.getEqTpszCd());
					log.debug("####### getAgreementNo  ####### " + tmp.getAgreementNo());
					log.debug("####### getAgmtOfcCtyCd  ####### " + mp.getAgmtOfcCtyCd());
					log.debug("####### getAgmtSeq  ####### " + mp.getAgmtSeq());
					tmp2 = dbDao.checkVerifyOnhireCountData(mp);
					if(tmp2 == null) {
						// own 일때는 에러
						if(tmp.getOwnLse().equals("O")){
							tmp.setVerify("Failed(Invalid Equipment No.)");
						} else {
							// 리즈 장비는 없어서 OK
							if(mp.getEqTpszCd() == null ||mp.getEqTpszCd().equals("")){
								tmp.setVerify("Failed(Type/Size unmatched)");
							} else {
								tmp.setVerify("OK");
							}

						}

					} else {
						tmp.setVerify(tmp2.getVerify());
					}
				} else {
//					tmp.setVerify("");
				}
				tmpVo.add(tmp);
			}
			return tmpVo;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq On-hire 수행에 필요한 Verify 처리. [EES_CGM_1008]<br>
	 *
	 * @param cHSOnHireINVOs CHSOnHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSOnhireBasic(CHSOnHireMGTVO[] cHSOnHireINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CHSOnHireMGTVO> updateVoList = new ArrayList<CHSOnHireMGTVO>();

			CHSOnHireINVO  mp   = new CHSOnHireINVO();
			CHSOnHireMGTVO tmp  = new CHSOnHireMGTVO();
			List<CHSOnHireMGTVO> tmp2 = new ArrayList<CHSOnHireMGTVO>();

			for ( int i=0; i<cHSOnHireINVOs.length; i++ ) {
				tmp = new CHSOnHireMGTVO();
				mp  = new CHSOnHireINVO();
				tmp = cHSOnHireINVOs[i];
				mp.setEqNo(tmp.getEqNo());
				mp.setEqKndCd(tmp.getEqKndCd());
				mp.setAgmtLstmCd(tmp.getAgmtLstmCd());

				updateVoList = new ArrayList<CHSOnHireMGTVO>();

				cHSOnHireINVOs[i].setCreUsrId(account.getUsr_id());
				cHSOnHireINVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(cHSOnHireINVOs[i]);
				// 히스토리 테이블 인서트
				log.debug("####### 히스토리 테이블 인서트 ####### : addCHSOnhireHistoryData" +cHSOnHireINVOs[i].getAgmtVerNo() );


				if(cHSOnHireINVOs[i].getOwnLse().equals("O")){
					// OWN 일때는 장비 마스터만 수정
					// 장비 마스터 테이블 업데이트
					dbDao.modifyCHSOnhireEquipmentData(updateVoList);
				} else {
					//  Leased 장비일 경우 장비존재 여부 체크
					tmp2 = dbDao.searchCHSOwnLeaseChkData(mp);

					log.debug("####### tmp2 ####### : " + tmp2);
					if(tmp2 == null || tmp2.size()==0){
						// 장비 마스터 테이블 인서트
						dbDao.addCHSOnhireEquipmentOwnData(updateVoList);
					} else {
						// 장비 마스터 테이블 업데이트
						dbDao.modifyCHSOnhireEquipmentData(updateVoList);
					}
				}

				dbDao.addCHSOnhireHistoryData(updateVoList);

				dbDao.modifyCGMEquipmentStatusData(updateVoList);


			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  On-Hire 시킬 M.GSET No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다... [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireStatusChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException {
		try {
			return dbDao.searchMGSOnHireStatusChkData(mGSOnHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  On-Hire 시킬  On-Hire 를 시킬 Model No. 를 바꾸면 해당하는 voltage, fuel capacity  조회한다. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVO MGSOnHireINVO
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> searchMGSOnHireEqSpecNoChkBasic(MGSOnHireINVO mGSOnHireINVO) throws EventException {
		try {
			return dbDao.searchMGSOnHireEqSpecNoChkData(mGSOnHireINVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Eq On-hire 수행에 필요한 Verify 처리. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireMGTVOs MGSOnHireMGTVO[]
	 * @return List<MGSOnHireMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<MGSOnHireMGTVO> verifyMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireMGTVOs) throws EventException {
		try {
		    List<MGSOnHireMGTVO> tmpVo = new  ArrayList<MGSOnHireMGTVO>();
		    MGSOnHireINVO  mp    = new MGSOnHireINVO();
		    MGSOnHireMGTVO tmp   = new MGSOnHireMGTVO();
		    MGSOnHireMGTVO tmp2  = new MGSOnHireMGTVO();

			for ( int i=0; i<mGSOnHireMGTVOs.length; i++ ) {
				tmp = new MGSOnHireMGTVO();
				mp  = new MGSOnHireINVO();
				tmp = mGSOnHireMGTVOs[i];
				log.debug(" ####### tmp.getAgreementNo() #######" + tmp.getAgreementNo());
				mp.setEqNo(tmp.getEqNo());
				mp.setEqKndCd(tmp.getEqKndCd());
				mp.setOwnLse(tmp.getOwnLse());
				mp.setOnhDt(tmp.getOnhDt());
				mp.setEqTpszCd(tmp.getEqTpszCd());
				mp.setAgreementNo(tmp.getAgreementNo());
				mp.setAgmtOfcCtyCd(tmp.getAgreementNo().substring(0,3));
				mp.setEqSpecNo(tmp.getEqSpecNo());
				mp.setAgmtSeq(String.valueOf(Integer.parseInt(tmp.getAgreementNo().substring(3,tmp.getAgreementNo().length()))));
				log.debug(" ####### getIbflag() #######" + tmp.getIbflag());
				log.debug(" ####### mp.getEqNo  #######" + mp.getEqNo());

				log.debug(" ####### mp.getOwnLse  #######" + mp.getOwnLse());
				log.debug(" ####### mp.getOnhDt  #######" + mp.getOnhDt());
				if(tmp.getDelChk().equals("1")){
					tmp2 = dbDao.checkMGSVerifyOnhireStatusData (mp);
					if(tmp2 == null) {
						if(tmp.getOwnLse().equals("O")){
							tmp.setVerify("Failed");
						} else {
							// 리즈 장비는 없어서 OK
							if(mp.getEqTpszCd() == null || mp.getEqTpszCd().equals("")){
								tmp.setVerify("Failed(Type/Size unmatched)");
							} else {
								tmp.setVerify("OK");
							}

						}
					} else {
						tmp.setVerify(tmp2.getVerify());
					}
				} else {
					tmp.setVerify("");
				}
				tmpVo.add(tmp);
			}
			return tmpVo;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * 장비 임차(Eq Onhire) 수행한다. 처리. [EES_CGM_2007]<br>
	 *
	 * @param mGSOnHireINVOs MGSOnHireMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSOnhireBasic(MGSOnHireMGTVO[] mGSOnHireINVOs, SignOnUserAccount account) throws EventException{
		try {
			List<MGSOnHireMGTVO> updateVoList = new ArrayList<MGSOnHireMGTVO>();
			MGSOnHireINVO  mp   = new MGSOnHireINVO();
			MGSOnHireMGTVO tmp  = new MGSOnHireMGTVO();
			List<MGSOnHireMGTVO> tmp2 = new ArrayList<MGSOnHireMGTVO>();

			for ( int i=0; i<mGSOnHireINVOs.length; i++ ) {
				tmp = new MGSOnHireMGTVO();
				mp  = new MGSOnHireINVO();
				tmp = mGSOnHireINVOs[i];
				mp.setEqNo(tmp.getEqNo());
				mp.setEqKndCd(tmp.getEqKndCd());
				mp.setAgmtLstmCd(tmp.getAgmtLstmCd());

				updateVoList = new ArrayList<MGSOnHireMGTVO>();

				mGSOnHireINVOs[i].setCreUsrId(account.getUsr_id());
				mGSOnHireINVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(mGSOnHireINVOs[i]);
				// 히스토리 테이블 인서트
				log.debug("####### 히스토리 테이블 인서트 ####### : getOwnLse===" +mGSOnHireINVOs[i].getOwnLse() );



				if(mGSOnHireINVOs[i].getOwnLse().equals("O")){
					// OWN 일때는 장비 마스터만 수정
					// 장비 마스터 테이블 업데이트
					dbDao.modifyMGSOnhireEquipmentData(updateVoList);
				} else {
					//  Leased 장비일 경우 장비존재 여부 체크
					tmp2 = dbDao.searchMGSOwnLeaseChkData(mp);

					log.debug("####### tmp2 ####### : " + tmp2);
					if(tmp2 == null || tmp2.size()==0){
						// 장비 마스터 테이블 인서트
						dbDao.addMGSOnhireEquipmentOwnData(updateVoList);
					} else {
						// 장비 마스터 테이블 업데이트
						dbDao.modifyMGSOnhireEquipmentData(updateVoList);
					}
				}
				dbDao.addMGSOnhireHistoryData(updateVoList);
				dbDao.modifyMGSEquipmentStatusData(updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  ERP FA I/F  의 event에 대한 특정 리스트. Retrieve [EES_CGM_1146]<br>
	 *
	 * @param erpFaInterfaceMGTVO ErpFaInterfaceMGTVO
	 * @return List<ErpFaInterfaceMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<ErpFaInterfaceMGTVO> searchErpFACandidateListBasic(ErpFaInterfaceMGTVO erpFaInterfaceMGTVO)  throws EventException {
		try {
			return dbDao.searchErpFaCandidateListData(erpFaInterfaceMGTVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 * ERP FA I/F  의 event에 대한 특정 리스트. FNS026-0001 send. [IF_CGM_002]<br>
	 * @param erpFaInterfaceINVOs ErpFaInterfaceINVO[]
	 * @param account		SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void sendToFABasic(ErpFaInterfaceINVO[] erpFaInterfaceINVOs, SignOnUserAccount account) throws EventException {
		List<ErpFaInterfaceINVO> updateVoList = new ArrayList<ErpFaInterfaceINVO>();
		List<ErpFaInterfaceINVO> tmpFaTargetListVOs = new ArrayList<ErpFaInterfaceINVO>();
		List<FaErpListVO> sendVoList = new ArrayList<FaErpListVO>();
		int updateCount = 0;
		try {
			if(erpFaInterfaceINVOs != null)
			{
				String fastscd = "OW";

				for (int i=0; i<erpFaInterfaceINVOs.length; i++){
					erpFaInterfaceINVOs[i].setLastUpdatedBy(account.getUsr_id());

				}
				for ( int i=0; i<erpFaInterfaceINVOs.length; i++ )
				{
					if (erpFaInterfaceINVOs[i].getDelChk().equals("1")){
						updateCount++;
					}
				}

				//chungpa 20091013 EAI 개선  IF_SEQ, FA_IF_GRP_SEQ_NO, EAI_IF_NO 의 단일처리.
				Integer ifSeq		= new Integer(0); //IF_SEQ
				String faIfGrpSeqNo	= ""; //FA_IF_GRP_SEQ_NO
				String eaiIfNo		= ""; //EAI_IF_NO

				ErpFaInterfaceINVO erpFaInterfaceINVO = new ErpFaInterfaceINVO();

				erpFaInterfaceINVO.setAttribute4(fastscd);	//고유번호/ CGM_EQUIPMENT:FA_IF_SEQ
				ErpFaInterfaceMGTVO erpFaInterfaceMGTVO = dbDao.searchErpFaCandidatePreData(erpFaInterfaceINVO);
				faIfGrpSeqNo = erpFaInterfaceMGTVO.getFaIfGrpSeqNo();
				eaiIfNo = erpFaInterfaceMGTVO.getEaiIfNo();

				for ( int i=0; i<erpFaInterfaceINVOs.length; i++ )
				{
					if (erpFaInterfaceINVOs[i].getDelChk().equals("1")){
						ifSeq++;
						/*update 대상
						 * CURR_CD 			(OK)
						 * AQZ_AMT 			(OK)
						 * INVST_NO 		(OK)
						 * FA_IF_TP_CD		('1')
						 * FA_IF_STS_CD 	('S')
						 * FA_IF_DT 		(SYSDATE)
						 * UPD_USR_ID 		(account.getUsr_id())
						 * UPD_DT 			(SYSDATE)
						 * IF_SEQ			(ROWNUM)
						 * FA_IF_GRP_SEQ_NO (Attribute4계산식)
						 * EAI_IF_NO 		('FNS026_0001_CGM_'||TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISSSSS'))
						 * IF_TTL_ROW_KNT  	(updateCount)
						 * EQ_NO			(OK)
						 */
						//update시 필요한 데이터
						erpFaInterfaceINVOs[i].setAttribute1(erpFaInterfaceINVOs[i].getCurrCd());		//취득시 Currency/ CGM_EQUIPMENT:CURR_CD
						erpFaInterfaceINVOs[i].setAttribute2(erpFaInterfaceINVOs[i].getActAmt());		//취득금액/ CGM_EQUIPMENT:AQZ_AMT
						erpFaInterfaceINVOs[i].setAttribute3(erpFaInterfaceINVOs[i].getInvestCd());		//Invest Code/ CGM_EQUIPMENT:INVST_NO
						erpFaInterfaceINVOs[i].setFaIfTpCd("1");
						erpFaInterfaceINVOs[i].setFaIfStsCd("S");
						erpFaInterfaceINVOs[i].setUpdUsrId(account.getUsr_id());
						erpFaInterfaceINVOs[i].setIfTtlRowKnt(Integer.valueOf(updateCount).toString());

						//chungpa 20091013 EAI 개선  IF_SEQ, FA_IF_GRP_SEQ_NO, EAI_IF_NO 의 단일처리 start.
						// 기존 erpFaInterfaceINVOs[i].setAttribute4(fastscd+lPad(Integer.toString(i+1), 4));	//고유번호/ CGM_EQUIPMENT:FA_IF_SEQ
						erpFaInterfaceINVOs[i].setIfSeq(ifSeq.toString());
						erpFaInterfaceINVOs[i].setFaIfGrpSeqNo(faIfGrpSeqNo);
						erpFaInterfaceINVOs[i].setEaiIfNo(eaiIfNo);

						//chungpa 20091013 EAI 개선  IF_SEQ, FA_IF_GRP_SEQ_NO, EAI_IF_NO 의 단일처리 end.

						//그외 send시 필요한 데이터
						if(erpFaInterfaceINVOs[i].getEqKndCd().equals("Z"))
						{
							erpFaInterfaceINVOs[i].setCreatedBy("CHS");									// Z->CHS
							erpFaInterfaceINVOs[i].setLastUpdatedBy("CHS");
						}else if(erpFaInterfaceINVOs[i].getEqKndCd().equals("G"))
						{
							erpFaInterfaceINVOs[i].setCreatedBy("MGS");									// G->MGS
							erpFaInterfaceINVOs[i].setLastUpdatedBy("MGS");
						}
						erpFaInterfaceINVOs[i].setAcqMth(erpFaInterfaceINVOs[i].getDeYrmon());			//Acquisition Month/ CGM_EQ_LOT:DE_YRMON
						erpFaInterfaceINVOs[i].setCost(erpFaInterfaceINVOs[i].getActAmt());				//취득가액/ CGM_EQUIPMENT:AQZ_AMT

						updateVoList.add(erpFaInterfaceINVOs[i]);
					}
				}
				//tmpFaTargetListVOs = dbDao.modifyErpFaCandidateListData(updateVoList);
				tmpFaTargetListVOs = dbDao.modifyErpFaCandidateListBatchData(updateVoList); //성능개선으로 Batch Update 적용

				for (int i=0; i<tmpFaTargetListVOs.size(); i++){
					sendVoList.addAll(dbDao.searchErpToFaData(tmpFaTargetListVOs.get(i)));
				}
				eaiDao.sendErpToFAData("FNS026-0001",sendVoList);// ==> EAI 연계
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
    }

	/**
	 * ERP FA I/F  의 event에 대한 특정 리스트. FNS026-R001 Receive. [IF_CGM_003]<br>
	 * @param cntrMasterUpdateIFVOs		CntrMasterUpdateIFVO[]
	 * @param account	SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
    public void receiveFABasic(CntrMasterUpdateIFVO[] cntrMasterUpdateIFVOs, SignOnUserAccount account) throws EventException {
		List<FaErpListVO> faErpListVOs = new ArrayList<FaErpListVO>();
		try {
			if(cntrMasterUpdateIFVOs != null)
			{
				for (int i=0; i<cntrMasterUpdateIFVOs.length; i++ )
				{
					FaErpListVO faErpListVO = new FaErpListVO();

					if(cntrMasterUpdateIFVOs[i].getFaIfStsCd().equals("Y"))
						faErpListVO.setFaIfStsCd("C"); //Complete
					else if(cntrMasterUpdateIFVOs[i].getFaIfStsCd().equals("N"))
						faErpListVO.setFaIfStsCd("E"); // Error
					else
						faErpListVO.setFaIfStsCd(cntrMasterUpdateIFVOs[i].getFaIfStsCd()); // Unknown Pass Value
					faErpListVO.setFaIfErrMsg(cntrMasterUpdateIFVOs[i].getFaIfErrMsg());
					faErpListVO.setFaEqNo(cntrMasterUpdateIFVOs[i].getFaEqNo());
					faErpListVO.setEqNo(cntrMasterUpdateIFVOs[i].getEqNo());

					faErpListVOs.add(i, faErpListVO);
				}

				if (faErpListVOs.size() > 0){
					dbDao.modifyErpReceiveFAData(faErpListVOs);
				}
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
    }

	/**
	 *  Lost되었던 Chassis가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하기 위해 조회. Retrieve [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVO CHSFoundAutoMGTVO
	 * @return List<CHSFoundAutoMGTVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<CHSFoundAutoMGTVO> searchCHSFoundAutoBasic(CHSFoundAutoMGTVO cHSFoundAutoMGTVO) throws EventException {
		try {
			return dbDao.searchCHSFoundAutoData(cHSFoundAutoMGTVO);
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  Lost되었던 Chassis가 시스템상에 Movement가 EDI로 들어올 경우 Found 처리하기 위해 조회. Delete [EES_CGM_1018]<br>
	 *
	 * @param cHSFoundAutoMGTVOs CHSFoundAutoMGTVO[]
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSFoundAutoBasic(CHSFoundAutoMGTVO[] cHSFoundAutoMGTVOs, SignOnUserAccount account) throws EventException{
		try {
			List<CHSFoundAutoMGTVO> updateVoList = new ArrayList<CHSFoundAutoMGTVO>();
			CHSFoundAutoMGTVO tmp  = new CHSFoundAutoMGTVO();

			for ( int i=0; i<cHSFoundAutoMGTVOs.length; i++ ) {
				tmp = new CHSFoundAutoMGTVO();
				tmp = cHSFoundAutoMGTVOs[i];
				tmp.setStsEvntOfcCd(account.getOfc_cd());
				tmp.setCreUsrId(account.getUsr_id());
				tmp.setUpdUsrId(account.getUsr_id());
				updateVoList.add(tmp);
			}

			if ( updateVoList.size() > 0 ) {
				// 히스토리 테이블 인서트
				dbDao.addCHSFoundAutoStatusHistoryData(updateVoList);

				// 마스터 테이블 업데이트
				dbDao.modifyCHSFoundAutoMasterData (updateVoList);
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 * Lease Term Change (Chassis) - 정보 저장 Manage [EES_CGM_1026]<br>
	 *
	 * @param cHSTermStatusINVOs CHSTermStatusINVO[]
	 * @param cHSTermStatusINVO CHSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageCHSTermChangeBasic(CHSTermStatusINVO[] cHSTermStatusINVOs,
					CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException {
		try{

			List<CHSTermStatusINVO> eqList = new ArrayList<CHSTermStatusINVO>();
            CHSTermStatusINVO chsTerm = new CHSTermStatusINVO();
            chsTerm = dbDao.checkCHSTermChangeEffDateData(cHSTermStatusINVO);
			if(chsTerm==null || !chsTerm.getVerify().equals("OK")){
				throw new EventException(new ErrorHandler("CGM10072",new String[]{chsTerm.getAgmtEffDt(),chsTerm.getAgmtExpDt()}).getMessage());
			}

			int cnt = dbDao.checkCHSTermChangeChgCreationData(cHSTermStatusINVO);
			if(cnt>0){
				throw new EventException(new ErrorHandler("CGM10075",new String[]{}).getMessage());
			}
			/*---------------------------------------------
				 CGM_EQ_STS_HIS, CGM_EQUIPMENT 등록 및 수정
			 ----------------------------------------------*/
			for(int i=0; i < cHSTermStatusINVOs.length; i++){
				CHSTermStatusINVO historyINVO = new CHSTermStatusINVO();

				String eqStsSeq1 = "";	// 첫번째  Insert 시 생성된 Sequence
				String eqStsSeq2 = "";	// 두번째  Insert 시 생성된 Sequence

				/*----------------------------------------
					 CGM_EQ_STS_HIS 등록
				 -----------------------------------------*/
				// 첫번째는 LSO 입력, 두번째는 LSI 입력
				for(int k=1; k <= 2; k++){
					// Sequnece 생성
					String eqStsSeq = dbDao.searchCHSEqHistorySeqData();

					// VO 설정
					if(k == 1){
						eqStsSeq1 = eqStsSeq;
						historyINVO.setAgmtOfcCtyCd(cHSTermStatusINVOs[i].getAgmtOfcCtyCd());
						historyINVO.setAgmtSeq(cHSTermStatusINVOs[i].getAgmtSeq());
						historyINVO.setAgmtVerNo(cHSTermStatusINVOs[i].getAgmtVerNo());
						historyINVO.setEqAsetStsCd("LSO");
					} else if(k == 2){
						eqStsSeq2 = eqStsSeq;
						historyINVO.setAgmtOfcCtyCd(cHSTermStatusINVO.getNewAgmtOfcCtyCd());
						historyINVO.setAgmtSeq(cHSTermStatusINVO.getNewAgmtSeq());
						historyINVO.setAgmtVerNo(cHSTermStatusINVO.getNewAgmtVerNo());
						historyINVO.setEqAsetStsCd("LSI");
					}

					historyINVO.setEqNo(cHSTermStatusINVOs[i].getEqNo());
					historyINVO.setEqStsSeq(eqStsSeq);
					historyINVO.setEqKndCd(cHSTermStatusINVO.getEqKndCd());
					historyINVO.setStsEvntYdCd(cHSTermStatusINVOs[i].getStsEvntYdCd());
					historyINVO.setStsEvntLocCd(cHSTermStatusINVOs[i].getStsEvntLocCd());
					historyINVO.setStsEvntOfcCd(cHSTermStatusINVO.getStsEvntOfcCd());
					historyINVO.setStsEvntDt(cHSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
					historyINVO.setTermCngSeq(eqStsSeq);
					historyINVO.setCreUsrId(account.getUsr_id());
					historyINVO.setUpdUsrId(account.getUsr_id());

					// CGM_EQ_STS_HIS 에 데이터 저장
					dbDao.addCHSTermChangeEqHistoryData(historyINVO);
				}


				// CGM_EQ_STS_HIS 수정 ==> LSO, LSI Term Change Sequence 를 맞추기 위해
				historyINVO.setTermCngSeq(eqStsSeq2);
				historyINVO.setEqStsSeq(eqStsSeq1);

				dbDao.modifyCHSTermChangeEqHistoryData(historyINVO);

				/*----------------------------------------
			 		CGM_EQUIPMENT 수정
			 	----------------------------------------*/
				CHSTermStatusINVO eqINVO = new CHSTermStatusINVO();

				eqINVO.setEqNo(cHSTermStatusINVOs[i].getEqNo());
				eqINVO.setAgmtOfcCtyCd(cHSTermStatusINVO.getNewAgmtOfcCtyCd());
				eqINVO.setAgmtSeq(cHSTermStatusINVO.getNewAgmtSeq());
				eqINVO.setAgmtVerNo(cHSTermStatusINVO.getNewAgmtVerNo());
				eqINVO.setVndrSeq(cHSTermStatusINVO.getNewVndrSeq());
				eqINVO.setAgmtLstmCd(cHSTermStatusINVO.getNewAgmtLstmCd());
				eqINVO.setOnhOfcCd(cHSTermStatusINVO.getStsEvntOfcCd());
				eqINVO.setOnhDt(cHSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
				eqINVO.setUpdUsrId(account.getUsr_id());
				eqINVO.setEqTpszCd(cHSTermStatusINVOs[i].getEqTpszCd());
				eqINVO.setEqStsSeq(eqStsSeq2);

				eqList.add(eqINVO);

				int cnt2 = dbDao.checkCHSTermChangeTypeSizeData(eqINVO);
				if((cnt2==0)
				 &&
				 !cHSTermStatusINVO.getNewAgmtLstmCd().equals("OW")
				){

					String agmtNo = eqINVO.getAgmtOfcCtyCd() + JSPUtil.getLPAD(eqINVO.getAgmtSeq(), 6, "0") ;
					throw new EventException(new ErrorHandler("CGM10073",new String[]{agmtNo,eqINVO.getEqTpszCd()}).getMessage());
				}
			}

			// CGM_EQUIPMENT 수정
			dbDao.modifyCHSTermChangeEqMasterData(eqList);

		} catch (EventException ex){
			throw ex;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Lease Term Change (Mgset) 화면에 대한 정보 저장 Manage [EES_CGM_2026]<br>
	 *
	 * @param mGSTermStatusINVOs MGSTermStatusINVO[]
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @param account SignOnUserAccount
	 * @exception DAOException
	 * @exception Exception
	 */
	public void manageMGSTermChangeBasic(MGSTermStatusINVO[] mGSTermStatusINVOs,
					MGSTermStatusINVO mGSTermStatusINVO, SignOnUserAccount account) throws EventException {
		try{

			List<MGSTermStatusINVO> eqList = new ArrayList<MGSTermStatusINVO>();


			MGSTermStatusINVO mgsTerm = null;
			mgsTerm = dbDao.checkMGSTermChangeEffDateData(mGSTermStatusINVO);
			if(mgsTerm==null || !mgsTerm.getVerify().equals("OK")){
				throw new EventException(new ErrorHandler("CGM10072",new String[]{mgsTerm.getAgmtEffDt(),mgsTerm.getAgmtExpDt()}).getMessage());
			}

			int cnt = dbDao.checkMGSTermChangeChgCreationData(mGSTermStatusINVO);
			if(cnt>0){
				throw new EventException(new ErrorHandler("CGM10075",new String[]{}).getMessage());
			}
			/*---------------------------------------------
				 CGM_EQ_STS_HIS, CGM_EQUIPMENT 등록 및 수정
			 ----------------------------------------------*/
			for(int i=0; i < mGSTermStatusINVOs.length; i++){
				MGSTermStatusINVO historyINVO = new MGSTermStatusINVO();

				String eqStsSeq1 = "";	// 첫번째  Insert 시 생성된 Sequence
				String eqStsSeq2 = "";	// 두번째  Insert 시 생성된 Sequence

				/*----------------------------------------
					 CGM_EQ_STS_HIS 등록
				 -----------------------------------------*/
				// 첫번째는 LSO 입력, 두번째는 LSI 입력
				for(int k=1; k <= 2; k++){
					// Sequnece 생성
					String eqStsSeq = dbDao.searchMGSEqHistorySeqData();

					// VO 설정
					if(k == 1){
						eqStsSeq1 = eqStsSeq;
						historyINVO.setAgmtOfcCtyCd(mGSTermStatusINVOs[i].getAgmtOfcCtyCd());
						historyINVO.setAgmtSeq(mGSTermStatusINVOs[i].getAgmtSeq());
						historyINVO.setAgmtVerNo(mGSTermStatusINVOs[i].getAgmtVerNo());
						historyINVO.setEqAsetStsCd("LSO");
					} else if(k == 2){
						eqStsSeq2 = eqStsSeq;
						historyINVO.setAgmtOfcCtyCd(mGSTermStatusINVO.getNewAgmtOfcCtyCd());
						historyINVO.setAgmtSeq(mGSTermStatusINVO.getNewAgmtSeq());
						historyINVO.setAgmtVerNo(mGSTermStatusINVO.getNewAgmtVerNo());
						historyINVO.setEqAsetStsCd("LSI");
					}

					historyINVO.setEqNo(mGSTermStatusINVOs[i].getEqNo());
					historyINVO.setEqStsSeq(eqStsSeq);
					historyINVO.setEqKndCd(mGSTermStatusINVO.getEqKndCd());
					historyINVO.setStsEvntYdCd(mGSTermStatusINVOs[i].getStsEvntYdCd());
					historyINVO.setStsEvntLocCd(mGSTermStatusINVOs[i].getStsEvntLocCd());
					historyINVO.setStsEvntOfcCd(mGSTermStatusINVO.getStsEvntOfcCd());
					historyINVO.setStsEvntDt(mGSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
					historyINVO.setTermCngSeq(eqStsSeq);
					historyINVO.setCreUsrId(account.getUsr_id());
					historyINVO.setUpdUsrId(account.getUsr_id());

					// CGM_EQ_STS_HIS 에 데이터 저장
					dbDao.addMGSTermChangeEqHistoryData(historyINVO);
				}


				// CGM_EQ_STS_HIS 수정 ==> LSO, LSI Term Change Sequence 를 맞추기 위해
				historyINVO.setTermCngSeq(eqStsSeq2);
				historyINVO.setEqStsSeq(eqStsSeq1);

				dbDao.modifyMGSTermChangeEqHistoryData(historyINVO);

				/*----------------------------------------
			 		CGM_EQUIPMENT 수정
			 	----------------------------------------*/
				MGSTermStatusINVO eqINVO = new MGSTermStatusINVO();

				eqINVO.setEqNo(mGSTermStatusINVOs[i].getEqNo());
				eqINVO.setAgmtOfcCtyCd(mGSTermStatusINVO.getNewAgmtOfcCtyCd());
				eqINVO.setAgmtSeq(mGSTermStatusINVO.getNewAgmtSeq());
				eqINVO.setAgmtVerNo(mGSTermStatusINVO.getNewAgmtVerNo());
				eqINVO.setVndrSeq(mGSTermStatusINVO.getNewVndrSeq());
				eqINVO.setAgmtLstmCd(mGSTermStatusINVO.getNewAgmtLstmCd());
				eqINVO.setOnhOfcCd(mGSTermStatusINVO.getStsEvntOfcCd());
				eqINVO.setOnhDt(mGSTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
				eqINVO.setUpdUsrId(account.getUsr_id());
				eqINVO.setEqTpszCd(mGSTermStatusINVOs[i].getEqTpszCd());
				eqINVO.setEqStsSeq(eqStsSeq2);

				eqList.add(eqINVO);

				int cnt2 = dbDao.checkMGSTermChangeTypeSizeData(eqINVO);
				if((cnt2==0)
						 &&
						 !mGSTermStatusINVO.getNewAgmtLstmCd().equals("OW")
						){
					String agmtNo = eqINVO.getAgmtOfcCtyCd() + JSPUtil.getLPAD(eqINVO.getAgmtSeq(), 6, "0") ;
					throw new EventException(new ErrorHandler("CGM10073",new String[]{agmtNo,eqINVO.getEqTpszCd()}).getMessage());
				}
			}

			// CGM_EQUIPMENT 수정
			dbDao.modifyMGSTermChangeEqMasterData(eqList);

		} catch (EventException ex){
			throw ex;
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}


	/**
	 *  Movement 에 의해 Eq Master 정보를 수정한다.개별 Chassis의 Master Data Update<br>
	 *
	 * @param cHSMasterMGTVO CHSMasterMGTVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyCHSCgmEquipmentBasic(CHSMasterMGTVO cHSMasterMGTVO) throws EventException{
		try {
				dbDao.modifyCHSCgmEquipmentData(cHSMasterMGTVO);	//Chassis
				dbDao.modifyCHSCgmEquipMgSetData(cHSMasterMGTVO);	//M.G Set
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 *  MNR 으로부터 호출받아 장비의 Damage, disposal 등의  Flagging 관리.. SAVE  [MNR 호출]<br>
	 *  MNR 으로부터 호출받아 장비의 Retirement 관련 처리. SAVE  [MNR 호출]<br>
	 *
	 * @param iFMnrFlagVOs List<IFMnrFlagVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public void createMNRStatusBasic(List<IFMnrFlagVO> iFMnrFlagVOs) throws EventException{
		try {
			ChassisMovementHistoryBC bc     = new ChassisMovementHistoryBCImpl();
			if ( iFMnrFlagVOs.size() > 0 ) {
				IFMnrFlagVO          iFMnrVo = new IFMnrFlagVO();
				CHSMasterMGTVO       chsMaster = new CHSMasterMGTVO();
				List<IFMnrFlagVO>    iFMnrFlags = new ArrayList<IFMnrFlagVO>();

				for(int i=0;i<iFMnrFlagVOs.size();i++){
					iFMnrFlags    = new ArrayList<IFMnrFlagVO>();
					iFMnrVo       = iFMnrFlagVOs.get(i);
					chsMaster     = new CHSMasterMGTVO();
					// LMNR 으로부터 호출받아 장비의 Damage, disposal 등의  Flagging 관리
					if(iFMnrVo.getFlagType().equals("DMG") || iFMnrVo.getFlagType().equals("DSP") ){
						iFMnrFlags = new ArrayList<IFMnrFlagVO>();
						iFMnrFlags.add(iFMnrVo);
						log.debug("iFMnrFlags"+iFMnrFlags.size());
						log.debug("iFMnrFlags"+iFMnrVo.getEqNo());
						dbDao.modifyMnrFlagData(iFMnrFlags);
					} else {
						// MNR 으로부터 호출받아 장비의 Retirement 관련 처리
						chsMaster.setEqNo(iFMnrVo.getEqNo());
						chsMaster.setCreUsrId(iFMnrVo.getFlagUserId());
						chsMaster.setUpdUsrId(iFMnrVo.getFlagUserId());
						chsMaster.setOnhDt(iFMnrVo.getFlagDt());
						chsMaster.setCrntYdCd(iFMnrVo.getFlagYdCd());
						chsMaster.setOnhOfcCd(iFMnrVo.getFlagOfcCd());
						chsMaster.setAgmtLstmCd(iFMnrVo.getFlagType());
						log.debug("getStsFlag================"+iFMnrVo.getStsFlag());
						if(iFMnrVo.getStsFlag().equals("Y")){
							chsMaster.setAciacDivCd("I");
							chsMaster.setChssMvmtStsCd("XX");
						} else {
							//agmt_lstm_cd
							chsMaster.setAgmtLstmCd("LSI");
							chsMaster.setAciacDivCd("A");
							chsMaster.setChssMvmtStsCd("BI");
						}

						dbDao.addMnrRetirementData(chsMaster);

						dbDao.modifyMnrRetirementData(chsMaster);

						iFMnrFlags.add(iFMnrVo);

						bc.createMNRStatusBasic(iFMnrFlagVOs);
					}
				}
			}
		}catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		}catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
	}

	/**
	 * Lease Term Change (Chassis) - 정보 저장(BackEndJob) Manage [EES_CGM_1026]<br>
	 *
	 * @param  CHSTermStatusINVO[] cHSTermStatusINVOs
	 * @param  CHSTermStatusINVO cHSTermStatusINVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String backEndCHSTermChangeListBasic(CHSTermStatusINVO[] cHSTermStatusINVOs, CHSTermStatusINVO cHSTermStatusINVO, SignOnUserAccount account) throws EventException {
		ChassisMgsetOnOffhireBackEndJob backEndJob = new ChassisMgsetOnOffhireBackEndJob();
		backEndJob.setJobType("manageCHSTermChangeList");
		backEndJob.setCHSTermStatusINVOs(cHSTermStatusINVOs);
		backEndJob.setCHSTermStatusINVO(cHSTermStatusINVO);
		backEndJob.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "manageCHSTermChangeList BackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("CGM20032", new String[]{"manageCHSTermChangeList BackEndJob"}).getMessage(),ex);
		}
	}

	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;

		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch (SQLException e) {
			throw new EventException(e.getMessage());
		} catch (InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e){
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * 월별로 반납한 실적을 조회.<br>
	 *
	 * @param ReportSearchConditionVO reportSearchConditionVO
	 * @return OnOffHireSummarybyMonthVO
	 * @exception EventException
	 */
	public OnOffHireSummarybyMonthVO searchCHSOffHireReportbyMonthSummaryBasic (ReportSearchConditionVO reportSearchConditionVO)throws EventException{
		OnOffHireSummarybyMonthVO resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchCHSOffHireReportbyMonthSummaryData(reportSearchConditionVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return resultVOs;
	}
	
	/**
	 * 월별로 임차한 실적을 조회.<br>
	 *
	 * @param ReportSearchConditionVO reportSearchConditionVO
	 * @return OnOffHireSummarybyMonthVO
	 * @exception EventException
	 */
	public OnOffHireSummarybyMonthVO searchCHSOnHireReportbyMonthSummaryBasic (ReportSearchConditionVO reportSearchConditionVO)throws EventException{
		OnOffHireSummarybyMonthVO resultVOs = null; // 데이터 전송을 위해 VO 객체
		try {
			resultVOs = dbDao.searchCHSOnHireReportbyMonthSummaryData(reportSearchConditionVO);
			
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(),ex);
		}
		return resultVOs;
	}

 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status History (M.G.Set) 삭제 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void removeMGSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException {
		try {
			dbDao.removeMGSByMNRSoldCancelData(iFMnrFlagVOList);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
 	}

 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status (M.G.Set) 수정 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void modifyMGSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException {
		try {
			dbDao.modifyMGSByMNRSoldCancelData(iFMnrFlagVOList);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
 	}
	
 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status History (Chassis) 삭제 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void removeCHSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException {
		try {
			dbDao.removeCHSByMNRSoldCancelData(iFMnrFlagVOList);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
 	}

 	/**
 	 * MNR >> Disposal >> Sold Cancellation 에서 SLD 장비 Status (Chassis) 수정 처리 [MNR 호출]<br>
 	 *
  	 * @param List<IFMnrFlagVO> iFMnrFlagVOList
 	 * @exception EventException
  	 */
 	public void modifyCHSByMNRSoldCancelBasic(List<IFMnrFlagVO> iFMnrFlagVOList) throws EventException {
		try { 
			dbDao.modifyCHSByMNRSoldCancelData(iFMnrFlagVOList);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
 	} 	
 	
}
