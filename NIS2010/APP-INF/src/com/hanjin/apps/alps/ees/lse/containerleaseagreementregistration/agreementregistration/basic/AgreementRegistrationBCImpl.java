/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBCImpl.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementFileUploadVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementGeneralRateVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRatesVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InInterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration.AgreementRegistrationDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.LseAgmtRtVO;
import com.hanjin.syscommon.common.table.LseDrpOffDescVO;

/**
 * NIS2010-ContainerLeaseAgreementRegistration Business Logic Basic Command implementation<br>
 * - NIS2010-ContainerLeaseAgreementRegistration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0001EventResponse,AgreementRegistrationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AgreementRegistrationBCImpl extends BasicCommandSupport implements AgreementRegistrationBC {

	// Database Access Object
	private transient AgreementRegistrationDBDAO dbDao = null;

	/**
	 * AgreementBCImpl 객체 생성<br>
	 * AgreementDBDAO를 생성한다.<br>
	 */
	public AgreementRegistrationBCImpl() {
		dbDao = new AgreementRegistrationDBDAO();
	}

	/**
	 * Lease Agreement List 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(AgreementVO searchAgreementVO) throws EventException {
		int cnt = 0;                       // 조회 데이터 총카운트
		List<AgreementVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			cnt       = dbDao.searchAgreementListBrieflyCountData(searchAgreementVO);
			resultVOs = dbDao.searchAgreementListBrieflyData(searchAgreementVO);
			
			if ( resultVOs.size() > 0 ) {
				resultVOs.get(0).setMaxRows(cnt);
			} else {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Briefly Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Briefly Search"}).getMessage(),ex);
		}
		
		return resultVOs;
	}

	/**
	 * Lease Agreement Master Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementData(agreementRegistrationVO);

			if ( resultVO.getAgreementVOs().size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01007").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement General Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementGeneralBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement General Data Search
			resultVO = dbDao.searchAgreementGeneralData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement General Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement General Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement Per-diem Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPerDiemBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementPerDiemData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Per-Diem Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Per-Diem Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement Lifting Charge Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementLiftChargeBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementLiftChargeData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Lift Charge Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Lift Charge Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement DOL/DOC Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDolDocBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementDolDocData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DOL/DOC Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DOL/DOC Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement Drop Office Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDropOfficeDescBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementDropOfficeDescData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Drop Office Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Drop Office Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement Penalty Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPenaltyBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementPenaltyData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Penalty Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Penalty Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}

	/**
	 * Lease Agreement DPP Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDppBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementDppData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DPP Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DPP Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}
	
	/**
	 * Lease Agreement Master 및 Tab Data 신규 저장<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException {
		String strNewAgmtSeq = "";

		try {
			/* 사용자ID Setting */
			agreementRegistrationVO.getAgreementVO().setCreUsrId(account.getUsr_id());
			agreementRegistrationVO.getAgreementVO().setUpdUsrId(account.getUsr_id());

			/* 신규 입력이므로 Agreement Version 은 '1' Setting */
			agreementRegistrationVO.getAgreementVO().setAgmtVerSeq("1");

			/* 신규 입력이므로 Agreement Sequence 채번 */
			strNewAgmtSeq = dbDao.searchAgreementNewSequenceData(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
			agreementRegistrationVO.getAgreementVO().setAgmtSeq(strNewAgmtSeq);

			/* Lease Agreement Rate 처리를 위한 객체 */
			List<LseAgmtRtVO> insertAgmtRtVos = new ArrayList<LseAgmtRtVO>();

			/* Lease Agreement Drop Office Description 처리를 위한 객체 */
			List<LseDrpOffDescVO> insertAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();

			/* General Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementGeneralVOs() != null && agreementRegistrationVO.getAgreementGeneralVOs().length > 0 ) {
				makeAgreementGeneralVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Per-diem Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementPerDiemVOs() != null && agreementRegistrationVO.getAgreementPerDiemVOs().length > 0 ) {
				makeAgreementPerDiemVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Lifting Charges Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementLiftChargeVOs() != null && agreementRegistrationVO.getAgreementLiftChargeVOs().length > 0 ) {
				makeAgreementLiftChargeVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}
			
			/* DOL/DOC Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDolDocVOs() != null && agreementRegistrationVO.getAgreementDolDocVOs().length > 0 ) {
				makeAgreementDolDocVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Penalty Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementPenaltyVOs() != null && agreementRegistrationVO.getAgreementPenaltyVOs().length > 0 ) {
				makeAgreementPenaltyVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}
			
			/* DPP/Lumb Sum Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDppVOs() != null && agreementRegistrationVO.getAgreementDppVOs().length > 0 ) {
				makeAgreementDppVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* File Upload 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementFileUploadVO() != null && agreementRegistrationVO.getAgreementFileUploadVO().length > 0 ) {
				makeAgreementFileUpLseAgmtRt(agreementRegistrationVO, account);
			}

			/* DOL/DOC 내 Description Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDropOfficeVOs() != null && agreementRegistrationVO.getAgreementDropOfficeVOs().length > 0 ) {
				LseDrpOffDescVO[] lseDrpOffDescVO = agreementRegistrationVO.getAgreementDropOfficeVOs();
				for ( int i = 0 ; i < lseDrpOffDescVO.length ; i++ ) {
					if ( lseDrpOffDescVO[i].getIbflag().equals("I")){
						lseDrpOffDescVO[i].setAgmtCtyCd(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
						lseDrpOffDescVO[i].setAgmtSeq(strNewAgmtSeq);
						lseDrpOffDescVO[i].setCreUsrId(account.getUsr_id());
						lseDrpOffDescVO[i].setUpdUsrId(account.getUsr_id());
						insertAgmtDrpOffDescVos.add(lseDrpOffDescVO[i]);
					}
				}
			}
			
			/* Lease Agreement Master Data 처리 */
			dbDao.addLeaseAgreementData(agreementRegistrationVO);

			/* Lease Agreement Version Data 처리 */
			dbDao.addLeaseAgreementVersionData(agreementRegistrationVO);

			/* Lease Agreement Rate Data 처리 */
			if ( insertAgmtRtVos != null && insertAgmtRtVos.size() > 0 ) {
				dbDao.addLeaseAgreementRatesData(insertAgmtRtVos);
			}

			/* Lease Agreement Drop Office Description Data 처리 */
			if ( insertAgmtDrpOffDescVos != null && insertAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.addAgmtDrpOffDescData(insertAgmtDrpOffDescVos);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Create"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Create"}).getMessage(),ex);
		}
		
		return strNewAgmtSeq;
	}

	/**
	 * Lease Agreement Master 및 Tab Data 수정 저장<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException {
		try {
			/* 사용자ID Setting */
			agreementRegistrationVO.getAgreementVO().setUpdUsrId(account.getUsr_id());

			/* Lease Agreement Rate 처리를 위한 객체 */
			List<LseAgmtRtVO> insertAgmtRtVos = new ArrayList<LseAgmtRtVO>();
			List<LseAgmtRtVO> removeAgmtRtVos = new ArrayList<LseAgmtRtVO>();
			
			/* Lease Agreement Drop Office Description 처리를 위한 객체 */
			List<LseDrpOffDescVO> insertAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();
			List<LseDrpOffDescVO> modifyAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();
			List<LseDrpOffDescVO> removeAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();

			/* General Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementGeneralVOs() != null && agreementRegistrationVO.getAgreementGeneralVOs().length > 0 ) {
				makeAgreementGeneralVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Per-diem Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementPerDiemVOs() != null && agreementRegistrationVO.getAgreementPerDiemVOs().length > 0 ) {
				makeAgreementPerDiemVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Lifting Charges Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementLiftChargeVOs() != null && agreementRegistrationVO.getAgreementLiftChargeVOs().length > 0 ) {
				makeAgreementLiftChargeVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* DOL/DOC Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDolDocVOs() != null && agreementRegistrationVO.getAgreementDolDocVOs().length > 0 ) {
				makeAgreementDolDocVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Penalty Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementPenaltyVOs() != null && agreementRegistrationVO.getAgreementPenaltyVOs().length > 0 ) {
				makeAgreementPenaltyVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* DPP/Lumb Sum Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDppVOs() != null && agreementRegistrationVO.getAgreementDppVOs().length > 0 ) {
				makeAgreementDppVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* File Upload 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementFileUploadVO() != null && agreementRegistrationVO.getAgreementFileUploadVO().length > 0 ) {
				makeAgreementFileUpLseAgmtRt(agreementRegistrationVO, account);
			}

			/* DOL/DOC 내 Description Data 처리객체 Setting */
			if ( agreementRegistrationVO.getAgreementDropOfficeVOs() != null && agreementRegistrationVO.getAgreementDropOfficeVOs().length > 0 ) {
				LseDrpOffDescVO[] lseDrpOffDescVO = agreementRegistrationVO.getAgreementDropOfficeVOs();
				for ( int i = 0 ; i < lseDrpOffDescVO.length ; i++ ) {
					if ( lseDrpOffDescVO[i].getIbflag().equals("I")){
						lseDrpOffDescVO[i].setAgmtCtyCd(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
						lseDrpOffDescVO[i].setAgmtSeq(agreementRegistrationVO.getAgreementVO().getAgmtSeq());
						lseDrpOffDescVO[i].setCreUsrId(account.getUsr_id());
						lseDrpOffDescVO[i].setUpdUsrId(account.getUsr_id());
						insertAgmtDrpOffDescVos.add(lseDrpOffDescVO[i]);
					} else if ( lseDrpOffDescVO[i].getIbflag().equals("U")){
						lseDrpOffDescVO[i].setAgmtCtyCd(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
						lseDrpOffDescVO[i].setAgmtSeq(agreementRegistrationVO.getAgreementVO().getAgmtSeq());
						lseDrpOffDescVO[i].setUpdUsrId(account.getUsr_id());
						modifyAgmtDrpOffDescVos.add(lseDrpOffDescVO[i]);
					} else if ( lseDrpOffDescVO[i].getIbflag().equals("D")){
						lseDrpOffDescVO[i].setAgmtCtyCd(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
						lseDrpOffDescVO[i].setAgmtSeq(agreementRegistrationVO.getAgreementVO().getAgmtSeq());
						removeAgmtDrpOffDescVos.add(lseDrpOffDescVO[i]);
					}
				}
			}

			/* Lease Agreement Master Data 처리 */
			dbDao.modifyLeaseAgreementData(agreementRegistrationVO);
			
			/* Lease Agreement Version Data 처리 */
			dbDao.modifyLeaseAgreementVersionData(agreementRegistrationVO);

			/* Lease Agreement Rate Data 처리 */
			if ( removeAgmtRtVos != null && removeAgmtRtVos.size() > 0 ) {
				dbDao.removeLeaseAgreementRatesData(removeAgmtRtVos);
			}

			if ( insertAgmtRtVos != null && insertAgmtRtVos.size() > 0 ) {
				dbDao.addLeaseAgreementRatesData(insertAgmtRtVos);
			}

			/* Lease Agreement Drop Office Description Data 처리 */
			if ( removeAgmtDrpOffDescVos != null && removeAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.removeAgmtDrpOffDescData(removeAgmtDrpOffDescVos);
			}

			if ( insertAgmtDrpOffDescVos != null && insertAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.addAgmtDrpOffDescData(insertAgmtDrpOffDescVos);
			}
			
			if ( modifyAgmtDrpOffDescVos != null && modifyAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.modifyAgmtDrpOffDescData(modifyAgmtDrpOffDescVos);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Modify"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Modify"}).getMessage(),ex);
		}
	}

	/**
	 * Lease Agreement General Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	private void makeAgreementGeneralVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();

		try {
			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementGeneralVOs().length ; i++ ) {
				AgreementGeneralRateVO agmtGeneralRateVO = agreementRegistrationVO.getAgreementGeneralVOs()[i];
	
				if ( agmtGeneralRateVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "GENV","GATV" Data 신규입력 
					// "GENV" Data 생성
					LseAgmtRtVO addAgmtRtVO = new LseAgmtRtVO();
	
					addAgmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					addAgmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					addAgmtRtVO.setLocCd(agmtGeneralRateVO.getLocCd());
					addAgmtRtVO.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					addAgmtRtVO.setCntrSpecNo(agmtGeneralRateVO.getCntrSpecNo());
					addAgmtRtVO.setCntrRntlChgTpCd("GENV");
					addAgmtRtVO.setAgmtChgVal(agmtGeneralRateVO.getQty());
					addAgmtRtVO.setN1stChgAmt(agmtGeneralRateVO.getReplValue());
					addAgmtRtVO.setN2ndChgAmt(agmtGeneralRateVO.getPurPrice());
					addAgmtRtVO.setAgmtChgDys(agmtGeneralRateVO.getPurPeriod());
					addAgmtRtVO.setGenRmk(agmtGeneralRateVO.getGenRmk());
					addAgmtRtVO.setCreUsrId(account.getUsr_id());
					addAgmtRtVO.setUpdUsrId(account.getUsr_id());
	
					insertAgmtRtVos.add(addAgmtRtVO);
					
					// "GENV" Data 생성
					if ( ( !JSPUtil.getNull(agmtGeneralRateVO.getGateIn()).equals("") && Double.parseDouble(agmtGeneralRateVO.getGateIn()) != 0.0 )
					  || ( !JSPUtil.getNull(agmtGeneralRateVO.getGateOut()).equals("") && Double.parseDouble(agmtGeneralRateVO.getGateOut()) != 0.0 ) ) {
	
						LseAgmtRtVO addAgmtRtVO2 = new LseAgmtRtVO();
	
						addAgmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
						addAgmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
						addAgmtRtVO2.setLocCd(agmtGeneralRateVO.getLocCd());
						addAgmtRtVO2.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
						addAgmtRtVO2.setCntrSpecNo(agmtGeneralRateVO.getCntrSpecNo());
						addAgmtRtVO2.setCntrRntlChgTpCd("GATV");
						addAgmtRtVO2.setAgmtChgVal("1");
						addAgmtRtVO2.setN1stChgAmt(agmtGeneralRateVO.getGateIn());
						addAgmtRtVO2.setN2ndChgAmt(agmtGeneralRateVO.getGateOut());
						addAgmtRtVO2.setCreUsrId(account.getUsr_id());
						addAgmtRtVO2.setUpdUsrId(account.getUsr_id());
						
						insertAgmtRtVos.add(addAgmtRtVO2);
					}
				} else if ( agmtGeneralRateVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "GENV","GATV" Data 삭제 후 신규입력
					LseAgmtRtVO removeAgmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO removeAgmtRtVO2 = new LseAgmtRtVO();
					
					removeAgmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					removeAgmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					removeAgmtRtVO1.setLocCd(agmtGeneralRateVO.getLocCd());
					removeAgmtRtVO1.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					removeAgmtRtVO1.setCntrRntlChgTpCd("GENV");
					
					removeAgmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					removeAgmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					removeAgmtRtVO2.setLocCd(agmtGeneralRateVO.getLocCd());
					removeAgmtRtVO2.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					removeAgmtRtVO2.setCntrRntlChgTpCd("GATV");
					
					removeAgmtRtVos.add(removeAgmtRtVO1);
					removeAgmtRtVos.add(removeAgmtRtVO2);
					
					// "GENV" Data 생성
					LseAgmtRtVO addAgmtRtVO1 = new LseAgmtRtVO();
	
					addAgmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					addAgmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					addAgmtRtVO1.setLocCd(agmtGeneralRateVO.getLocCd());
					addAgmtRtVO1.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					addAgmtRtVO1.setCntrSpecNo(agmtGeneralRateVO.getCntrSpecNo());
					addAgmtRtVO1.setCntrRntlChgTpCd("GENV");
					addAgmtRtVO1.setAgmtChgVal(agmtGeneralRateVO.getQty());
					addAgmtRtVO1.setN1stChgAmt(agmtGeneralRateVO.getReplValue());
					addAgmtRtVO1.setN2ndChgAmt(agmtGeneralRateVO.getPurPrice());
					addAgmtRtVO1.setAgmtChgDys(agmtGeneralRateVO.getPurPeriod());
					addAgmtRtVO1.setGenRmk(agmtGeneralRateVO.getGenRmk());
					addAgmtRtVO1.setCreUsrId(account.getUsr_id());
					addAgmtRtVO1.setUpdUsrId(account.getUsr_id());
						
					insertAgmtRtVos.add(addAgmtRtVO1);
					
					// "GENV" Data 생성
					if ( ( !JSPUtil.getNull(agmtGeneralRateVO.getGateIn()).equals("") && Double.parseDouble(agmtGeneralRateVO.getGateIn()) != 0.0 )
					  || ( !JSPUtil.getNull(agmtGeneralRateVO.getGateOut()).equals("") && Double.parseDouble(agmtGeneralRateVO.getGateOut()) != 0.0 ) ) {
	
						LseAgmtRtVO addAgmtRtVO2 = new LseAgmtRtVO();
	
						addAgmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
						addAgmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
						addAgmtRtVO2.setLocCd(agmtGeneralRateVO.getLocCd());
						addAgmtRtVO2.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
						addAgmtRtVO2.setCntrSpecNo(agmtGeneralRateVO.getCntrSpecNo());
						addAgmtRtVO2.setCntrRntlChgTpCd("GATV");
						addAgmtRtVO2.setAgmtChgVal("1");
						addAgmtRtVO2.setN1stChgAmt(agmtGeneralRateVO.getGateIn());
						addAgmtRtVO2.setN2ndChgAmt(agmtGeneralRateVO.getGateOut());
						addAgmtRtVO2.setCreUsrId(account.getUsr_id());
						addAgmtRtVO2.setUpdUsrId(account.getUsr_id());
						
						insertAgmtRtVos.add(addAgmtRtVO2);
					}
				} else if ( agmtGeneralRateVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "GENV","GATV" Data 삭제 
					LseAgmtRtVO removeAgmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO removeAgmtRtVO2 = new LseAgmtRtVO();
					
					removeAgmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					removeAgmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					removeAgmtRtVO1.setLocCd(agmtGeneralRateVO.getLocCd());
					removeAgmtRtVO1.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					removeAgmtRtVO1.setCntrRntlChgTpCd("GENV");
					
					removeAgmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					removeAgmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					removeAgmtRtVO2.setLocCd(agmtGeneralRateVO.getLocCd());
					removeAgmtRtVO2.setCntrTpszCd(agmtGeneralRateVO.getCntrTpszCd());
					removeAgmtRtVO2.setCntrRntlChgTpCd("GATV");
					
					removeAgmtRtVos.add(removeAgmtRtVO1);
					removeAgmtRtVos.add(removeAgmtRtVO2);
				}
			}
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement General Data VO Creat"}).getMessage(),ex);
		}
	}

	/**
	 * Lease Agreement Per-diem Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void makeAgreementPerDiemVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		try {
			// Lease Agreement Master VO
			AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
			// Original Container Type/Size String Array
			List<String> orgCntrTpSzCds = (List<String>)JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());

			String cntrTpSzCd   = "";
			String cntrN1Amt  = "";

			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementPerDiemVOs().length ; i++ ) {
				AgreementRatesVO agmtPerDiemVO = agreementRegistrationVO.getAgreementPerDiemVOs()[i];
	
				Method[] methods = agmtPerDiemVO.getClass().getMethods();
				
				if ( agmtPerDiemVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "PDGV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPerDiemVO);
							}
						}
								
						if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("PDGV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
			
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtPerDiemVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "PDGV" Data 삭제 후 신규입력
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtPerDiemVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("PDGV");
					agmtRtVO1.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO1);
	
					// "PDGV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);
	
						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPerDiemVO);
							}
						}

						if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("PDGV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());

							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtPerDiemVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "PDGV" Data 삭제 
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
					agmtRtVO.setCntrRntlChgTpCd("PDGV");
					agmtRtVO.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO);
				}
			}
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Per-Diem Data VO Creat"}).getMessage(),ex);
		}
	}

	/**
	 * Lease Agreement Lifting Charge Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void makeAgreementLiftChargeVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		try {
			// Lease Agreement Master VO
			AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();

			// Original Container Type/Size String Array
			List<String> orgCntrTpSzCds = (List<String>)JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
	
			String cntrTpSzCd   = "";
			String cntrN1Amt    = "";
			String cntrN2Amt    = "";

			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementLiftChargeVOs().length ; i++ ) {
				AgreementRatesVO agmtLiftChargeVO = agreementRegistrationVO.getAgreementLiftChargeVOs()[i];
	
				Method[] methods = agmtLiftChargeVO.getClass().getMethods();

				if ( agmtLiftChargeVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "LIFV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N2Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							}
						}

						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0)
						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {

							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("LIFV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtLiftChargeVO.getAgmtChgVal());
							if ( JSPUtil.getNull(cntrN1Amt).equals("") ) {
								cntrN1Amt = "0";
							}
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							if ( JSPUtil.getNull(cntrN2Amt).equals("") ) {
								cntrN2Amt = "0";
							}
							agmtRtVO.setN2ndChgAmt(cntrN2Amt);
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
		
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtLiftChargeVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "LIFV" Data 삭제 후 신규입력
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtLiftChargeVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("LIFV");
					agmtRtVO1.setAgmtChgVal(agmtLiftChargeVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO1);
					
					// "LIFV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N2Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							}
						}

						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0)
						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("LIFV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtLiftChargeVO.getAgmtChgVal());
							if ( JSPUtil.getNull(cntrN1Amt).equals("") ) {
								cntrN1Amt = "0";
							}
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							if ( JSPUtil.getNull(cntrN2Amt).equals("") ) {
								cntrN2Amt = "0";
							}
							agmtRtVO.setN2ndChgAmt(cntrN2Amt);
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
		
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtLiftChargeVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "LIFV" Data 삭제 
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
					agmtRtVO.setCntrRntlChgTpCd("LIFV");
					agmtRtVO.setAgmtChgVal(agmtLiftChargeVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO);
				}
			}
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement LiftCharge Data VO Creat"}).getMessage(),e);
		}
	}

	/**
	 * Lease Agreement DOL/DOC Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void makeAgreementDolDocVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		try {
			// Lease Agreement Master VO
			AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();

			// Original Container Type/Size String Array
			List<String> orgCntrTpSzCds = (List<String>)JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
	
			String cntrTpSzCd   = "";
			String cntrN1Amt    = "";
			String cntrN2Amt    = "";

			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementDolDocVOs().length ; i++ ) {
				AgreementRatesVO agmtDolDocVO = agreementRegistrationVO.getAgreementDolDocVOs()[i];
	
				Method[] methods = agmtDolDocVO.getClass().getMethods();

				if ( agmtDolDocVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "DOCV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"ChgVal") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtDolDocVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtDolDocVO);
							}
						}

						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Integer.parseInt(cntrN1Amt) != 0)
						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {

							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("DOCV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							if ( JSPUtil.getNull(cntrN1Amt).equals("") ) {
								cntrN1Amt = "0";
							}
							agmtRtVO.setAgmtChgVal(cntrN1Amt);
							if ( JSPUtil.getNull(cntrN2Amt).equals("") ) {
								cntrN2Amt = "0";
							}
							agmtRtVO.setN1stChgAmt(cntrN2Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
		
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtDolDocVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "DOCV" Data 삭제 후 신규입력
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDolDocVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("DOCV");

					removeAgmtRtVos.add(agmtRtVO1);
					
					// "DOCV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"ChgVal") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtDolDocVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtDolDocVO);
							}
						}

						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Integer.parseInt(cntrN1Amt) != 0)
						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("DOCV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							if ( JSPUtil.getNull(cntrN1Amt).equals("") ) {
								cntrN1Amt = "0";
							}
							agmtRtVO.setAgmtChgVal(cntrN1Amt);
							if ( JSPUtil.getNull(cntrN2Amt).equals("") ) {
								cntrN2Amt = "0";
							}
							agmtRtVO.setN1stChgAmt(cntrN2Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
		
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtDolDocVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "DOCV" Data 삭제 
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
					agmtRtVO.setCntrRntlChgTpCd("DOCV");
					
					removeAgmtRtVos.add(agmtRtVO);
				}
			}
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DOL/DOC Data VO Creat"}).getMessage(),e);
		}
	}

	/**
	 * Lease Agreement Penalty Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private void makeAgreementPenaltyVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		try {
			// Lease Agreement Master VO
			AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
			// Original Container Type/Size String Array
			List<String> orgCntrTpSzCds = (List<String>)JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());

			String cntrTpSzCd   = "";
			String cntrN1Amt  = "";

			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementPenaltyVOs().length ; i++ ) {
				AgreementRatesVO agmtPenaltyVO = agreementRegistrationVO.getAgreementPenaltyVOs()[i];
	
				Method[] methods = agmtPenaltyVO.getClass().getMethods();
				
				if ( agmtPenaltyVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "PNTV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPenaltyVO);
							}
						}
								
						if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtPenaltyVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("PNTV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtPenaltyVO.getAgmtChgVal());
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());
			
							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtPenaltyVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "PNTV" Data 삭제 후 신규입력
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtPenaltyVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("PNTV");
					
					removeAgmtRtVos.add(agmtRtVO1);
	
					// "PNTV" Data 신규입력
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);
	
						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPenaltyVO);
							}
						}

						if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtPenaltyVO.getLocCd());
							agmtRtVO.setCntrRntlChgTpCd("PNTV");
							agmtRtVO.setCntrTpszCd(cntrTpSzCd);
							agmtRtVO.setAgmtChgVal(agmtPenaltyVO.getAgmtChgVal());
							agmtRtVO.setN1stChgAmt(cntrN1Amt);
							agmtRtVO.setN2ndChgAmt("0");
							agmtRtVO.setCreUsrId(account.getUsr_id());
							agmtRtVO.setUpdUsrId(account.getUsr_id());

							insertAgmtRtVos.add(agmtRtVO);
						}
					}
				} else if ( agmtPenaltyVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "PNTV" Data 삭제 
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtPenaltyVO.getLocCd());
					agmtRtVO.setCntrRntlChgTpCd("PDGV");
					
					removeAgmtRtVos.add(agmtRtVO);
				}
			}
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DOL/DOC Data VO Creat"}).getMessage(),e);
		}
	}

	/**
	 * Lease Agreement DPP Tab의 데이터를 LSE_AGMT_RT Table VO에 mapping 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @param List<LseAgmtRtVO> insertAgmtRtVos
	 * @param List<LseAgmtRtVO> removeAgmtRtVos
	 * @exception EventException
	 */
	private void makeAgreementDppVOs2LseAgmtRtVOs(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account, List<LseAgmtRtVO> insertAgmtRtVos, List<LseAgmtRtVO> removeAgmtRtVos) throws EventException {
		try {
			// Lease Agreement Master VO
			AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();

			for ( int i = 0 ; i < agreementRegistrationVO.getAgreementDppVOs().length ; i++ ) {
				LseAgmtRtVO agmtDppVO = agreementRegistrationVO.getAgreementDppVOs()[i];
	
				if ( agmtDppVO.getIbflag().equals("I") ) {
					// ibflag가 입력("I")일 경우 "DPPV","LDPV" Data 신규입력
					agmtDppVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtDppVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtDppVO.setCreUsrId(account.getUsr_id());
					agmtDppVO.setUpdUsrId(account.getUsr_id());
			
					insertAgmtRtVos.add(agmtDppVO);
				} else if ( agmtDppVO.getIbflag().equals("U") ) {
					// ibflag가 수정("U")일 경우 "DPPV","LDPV" Data 삭제 후 신규입력
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO agmtRtVO2 = new LseAgmtRtVO();

					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("DPPV");
					agmtRtVO1.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					agmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO2.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO2.setCntrRntlChgTpCd("LDPV");
					agmtRtVO2.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					removeAgmtRtVos.add(agmtRtVO1);
					removeAgmtRtVos.add(agmtRtVO2);
	
					// "DPPV","LDPV" Data 신규입력
					agmtDppVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtDppVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtDppVO.setCreUsrId(account.getUsr_id());
					agmtDppVO.setUpdUsrId(account.getUsr_id());
			
					insertAgmtRtVos.add(agmtDppVO);
				} else if ( agmtDppVO.getIbflag().equals("D") ) {
					// ibflag가 삭제("D")일 경우 "DPPV","LDPV" Data 삭제 
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO agmtRtVO2 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("DPPV");
					agmtRtVO1.setCntrTpszCd(agmtDppVO.getCntrTpszCd());
					
					agmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO2.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO2.setCntrRntlChgTpCd("LDPV");
					agmtRtVO2.setCntrTpszCd(agmtDppVO.getCntrTpszCd());
					
					removeAgmtRtVos.add(agmtRtVO1);
					removeAgmtRtVos.add(agmtRtVO2);
				}
			}
		} catch(Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement DPP Data VO Creat"}).getMessage(),e);
		}
	}

	/**
	 * Lease Agreement Version Up 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementNewVersionBasic(AgreementRegistrationVO agreementRegistrationVO,SignOnUserAccount account) throws EventException {
		String strAgmtCtyCd     = "";
		String strAgmtSeq       = "";
		String strNewAgmtVerSeq = "";

		try {
			agreementRegistrationVO.getAgreementVO().setCreUsrId(account.getUsr_id());
			agreementRegistrationVO.getAgreementVO().setUpdUsrId(account.getUsr_id());
			
			strAgmtCtyCd = agreementRegistrationVO.getAgreementVO().getAgmtCtyCd();
			strAgmtSeq   = agreementRegistrationVO.getAgreementVO().getAgmtSeq();

			// Agreement Version Sequence 채번
			strNewAgmtVerSeq = dbDao.searchAgreementNewVersionSequenceData(strAgmtCtyCd, strAgmtSeq);

			// 위에서 채번한 Agreement Version Sequence Setting
			agreementRegistrationVO.getAgreementVO().setAgmtVerSeq(strNewAgmtVerSeq);
			
			/* Lease Agreement Rata History Data 생성 */
			dbDao.addLeaseAgreementRateHistoryData(strAgmtCtyCd, strAgmtSeq, Integer.parseInt(strNewAgmtVerSeq)-1, account.getUsr_id());
			/* Lease Agreement Data 수정 */
			dbDao.modifyLeaseAgreementData(agreementRegistrationVO);
			/* Lease Agreement Version Data 생성 */
			dbDao.addLeaseAgreementVersionData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin Up"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin Up"}).getMessage(),ex);
		}
		
		return strNewAgmtVerSeq;
	}

	/**
	 * Lease Agreement Version List 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementVersionListBasic(AgreementVO searchAgreementVO) throws EventException {
		int cnt = 0;                       // 조회 데이터 총카운트
		List<AgreementVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			cnt       = dbDao.searchAgreementVersionListCountData(searchAgreementVO);
			resultVOs = dbDao.searchAgreementVersionListData(searchAgreementVO);
			
			if ( resultVOs != null && resultVOs.size() > 0 ) {
				resultVOs.get(0).setMaxRows(cnt);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin List Search"}).getMessage(),ex);
		}
		
		return resultVOs;
	}

	/**
	 * Lease Agreement Term & Condition Lists 조회<br>
	 * 
	 * @param String expFromDt
	 * @param String expToDt
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @param String orgCntrTpszCd
	 * @param String ofcCd
	 * @return List<AgreementListVO>
	 * @exception EventException
	 */
	public List<AgreementListVO> searchAgreementListBasic(String expFromDt, String expToDt, String vndrSeq, String lstmCd, String orgCntrTpszCd, String ofcCd) throws EventException {
		List<AgreementListVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchAgreementListData(expFromDt, expToDt, vndrSeq, lstmCd, orgCntrTpszCd, ofcCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement List Search"}).getMessage(),ex);
		}
		
		return resultVOs;
	}
	
	/**
	 * EES_LSE_0102 : caculation Click <br>
	 * Interest calculation 조회 <br>
	 * @param     InInterrstServiceVO inInterrstServiceVO
	 * @return    List<InterrstServiceVO>
	 * @exception EventException
	 */
	public List<InterrstServiceVO> calculationInterrstBasic(InInterrstServiceVO inInterrstServiceVO) throws EventException {
		List<InterrstServiceVO> interrstServiceVOS  = null;
			
		try {			
			// Interest calculation Data Search
			interrstServiceVOS = dbDao.calculationInterrstData(inInterrstServiceVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Interest calculation"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Interest calculation"}).getMessage(),ex);
		}	

		return interrstServiceVOS;
	}

	/**
	 * Lease Agreement Pic Data 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPicBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; // 데이터 전송을 위해 VO 객체

		try {
			// Lease Agreement Master Data Search
			resultVO = dbDao.searchAgreementPicData(agreementRegistrationVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Per-Diem Data Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Per-Diem Data Search"}).getMessage(),ex);
		}

		return resultVO;
	}
	
	/**
	 * Lease Agreement File Upload 처리<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public void makeAgreementFileUpLseAgmtRt(AgreementRegistrationVO agreementRegistrationVO,SignOnUserAccount account) throws EventException {

		try {
			List<AgreementFileUploadVO> insertVoList = new ArrayList<AgreementFileUploadVO>();
			List<AgreementFileUploadVO> deleteVoList = new ArrayList<AgreementFileUploadVO>();

			AgreementFileUploadVO[] agreementFileUploadVO = agreementRegistrationVO.getAgreementFileUploadVO();

			for (int inx=0; inx<agreementFileUploadVO.length; inx++){
				//if ("I".equals(agreementFileUploadVO[inx].getIbflag()) 
					agreementFileUploadVO[inx].setAgmtSeq(agreementRegistrationVO.getAgreementVO().getAgmtSeq());
					agreementFileUploadVO[inx].setAgmtCtyCd(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
				
					agreementFileUploadVO[inx].setCreusrid(account.getUsr_id());
					agreementFileUploadVO[inx].setUpdusrid(account.getUsr_id());
					
					if ("D".equals(agreementFileUploadVO[inx].getIbflag())) {} 
					else insertVoList.add(agreementFileUploadVO[inx]);
					deleteVoList.add(agreementFileUploadVO[inx]);

			}
			
			//if ( deleteVoList.size() > 0 ) {
				dbDao.removeLeaseAgreementFileUpData(deleteVoList);
			//}
			if ( insertVoList.size() > 0 ) {
				dbDao.addLeaseAgreementFileUpData(insertVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin Up"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Versin Up"}).getMessage(),ex);
		}
		
	}
}