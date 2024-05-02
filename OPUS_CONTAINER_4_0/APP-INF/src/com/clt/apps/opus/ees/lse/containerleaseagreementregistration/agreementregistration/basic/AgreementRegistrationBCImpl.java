/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBCImpl.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.basic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.integration.AgreementRegistrationDBDAO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementGeneralRateVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRatesVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LseAgmtRtVO;
import com.clt.syscommon.common.table.LseDrpOffDescVO;

/**
 * ContainerLeaseAgreementRegistration Business Logic Basic Command implementation<br>
 * Handling Business Logic of ContainerLeaseAgreementRegistration<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0001EventResponse,AgreementRegistrationBC Reference to each DAO Class
 * @since J2EE 1.6
 */
public class AgreementRegistrationBCImpl extends BasicCommandSupport implements AgreementRegistrationBC {

	// Database Access Object
	private transient AgreementRegistrationDBDAO dbDao = null;

	/**
	 * Generating AgreementBCImpl Object<br>
	 * Generating AgreementDBDAO<br>
	 */
	public AgreementRegistrationBCImpl() {
		dbDao = new AgreementRegistrationDBDAO();
	}

	/**
	 * Retrieving Lease Agreement List<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(AgreementVO searchAgreementVO) throws EventException {
		int cnt = 0;                      
		List<AgreementVO> resultVOs = null; 

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
	 * Retrieving Lease Agreement Master Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 
		
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
	 * Retrieving Lease Agreement General Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementGeneralBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retreiving Lease Agreement Per-diem Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPerDiemBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retrieving Lease Agreement Lifting Charge Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementLiftChargeBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retrieving Lease Agreement DOL/DOC Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDolDocBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retrieving Lease Agreement Drop Office Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDropOfficeDescBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retrieving Lease Agreement Penalty Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementPenaltyBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * Retrieving Lease Agreement DPP Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @exception EventException
	 */
	public AgreementRegistrationVO searchAgreementDppBasic(AgreementRegistrationVO agreementRegistrationVO) throws EventException {
		AgreementRegistrationVO resultVO  = null; 

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
	 * New Saving Lease Agreement Master and Tab Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException {
		String strNewAgmtSeq = "";

		try {
			/* User ID Setting */
			agreementRegistrationVO.getAgreementVO().setCreUsrId(account.getUsr_id());
			agreementRegistrationVO.getAgreementVO().setUpdUsrId(account.getUsr_id());

			/* As new Input, Agreement Version = '1' */
			agreementRegistrationVO.getAgreementVO().setAgmtVerSeq("1");

			/* As new Input, Agreement Sequence */
			strNewAgmtSeq = dbDao.searchAgreementNewSequenceData(agreementRegistrationVO.getAgreementVO().getAgmtCtyCd());
			agreementRegistrationVO.getAgreementVO().setAgmtSeq(strNewAgmtSeq);

			/* Object to handle Lease Agreement Rate */
			List<LseAgmtRtVO> insertAgmtRtVos = new ArrayList<LseAgmtRtVO>();

			/* Object to handle Lease Agreement Drop Office Description */
			List<LseDrpOffDescVO> insertAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();

			/* General Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementGeneralVOs() != null && agreementRegistrationVO.getAgreementGeneralVOs().length > 0 ) {
				makeAgreementGeneralVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Per-diem Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementPerDiemVOs() != null && agreementRegistrationVO.getAgreementPerDiemVOs().length > 0 ) {
				makeAgreementPerDiemVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Lifting Charges Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementLiftChargeVOs() != null && agreementRegistrationVO.getAgreementLiftChargeVOs().length > 0 ) {
				makeAgreementLiftChargeVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}
			
			/* DOL/DOC Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementDolDocVOs() != null && agreementRegistrationVO.getAgreementDolDocVOs().length > 0 ) {
				makeAgreementDolDocVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* Penalty Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementPenaltyVOs() != null && agreementRegistrationVO.getAgreementPenaltyVOs().length > 0 ) {
				makeAgreementPenaltyVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}
			
			/* DPP/Lumb Sum Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementDppVOs() != null && agreementRegistrationVO.getAgreementDppVOs().length > 0 ) {
				makeAgreementDppVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, null);
			}

			/* DOL/DOC 내 Description Data Handling Object Setting */
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
			
			/* Handling Lease Agreement Master Data */
			dbDao.addLeaseAgreementData(agreementRegistrationVO);

			/* Handling Lease Agreement Version Data */
			dbDao.addLeaseAgreementVersionData(agreementRegistrationVO);

			/* Handling Lease Agreement Rate Data */
			if ( insertAgmtRtVos != null && insertAgmtRtVos.size() > 0 ) {
				dbDao.addLeaseAgreementRatesData(insertAgmtRtVos);
			}

			/* Handling Lease Agreement Drop Office Description Data */
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
	 * Modifying and Saving Lease Agreement Master and Tab Data <br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAgreementBasic(AgreementRegistrationVO agreementRegistrationVO, SignOnUserAccount account) throws EventException {
		try {
			/* User ID Setting */
			agreementRegistrationVO.getAgreementVO().setUpdUsrId(account.getUsr_id());

			/* Object to handle Lease Agreement Rate  */
			List<LseAgmtRtVO> insertAgmtRtVos = new ArrayList<LseAgmtRtVO>();
			List<LseAgmtRtVO> removeAgmtRtVos = new ArrayList<LseAgmtRtVO>();
			
			/* Object to handle Lease Agreement Drop Office Description */
			List<LseDrpOffDescVO> insertAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();
			List<LseDrpOffDescVO> modifyAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();
			List<LseDrpOffDescVO> removeAgmtDrpOffDescVos = new ArrayList<LseDrpOffDescVO>();

			/* General Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementGeneralVOs() != null && agreementRegistrationVO.getAgreementGeneralVOs().length > 0 ) {
				makeAgreementGeneralVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Per-diem Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementPerDiemVOs() != null && agreementRegistrationVO.getAgreementPerDiemVOs().length > 0 ) {
				makeAgreementPerDiemVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Lifting Charges Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementLiftChargeVOs() != null && agreementRegistrationVO.getAgreementLiftChargeVOs().length > 0 ) {
				makeAgreementLiftChargeVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* DOL/DOC Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementDolDocVOs() != null && agreementRegistrationVO.getAgreementDolDocVOs().length > 0 ) {
				makeAgreementDolDocVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* Penalty Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementPenaltyVOs() != null && agreementRegistrationVO.getAgreementPenaltyVOs().length > 0 ) {
				makeAgreementPenaltyVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* DPP/Lumb Sum Data Handling Object Setting */
			if ( agreementRegistrationVO.getAgreementDppVOs() != null && agreementRegistrationVO.getAgreementDppVOs().length > 0 ) {
				makeAgreementDppVOs2LseAgmtRtVOs(agreementRegistrationVO, account, insertAgmtRtVos, removeAgmtRtVos);
			}

			/* DOL/DOC 내 Description Data Handling Object Setting */
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

			/* Handling Lease Agreement Master Data */
			dbDao.modifyLeaseAgreementData(agreementRegistrationVO);
			
			/* Handling Lease Agreement Version Data  */
			dbDao.modifyLeaseAgreementVersionData(agreementRegistrationVO);

			/* Handling Lease Agreement Rate Data  */
			if ( removeAgmtRtVos != null && removeAgmtRtVos.size() > 0 ) {
				dbDao.removeLeaseAgreementRatesData(removeAgmtRtVos);
			}

			if ( insertAgmtRtVos != null && insertAgmtRtVos.size() > 0 ) {
				dbDao.addLeaseAgreementRatesData(insertAgmtRtVos);
			}

			/* Handling Lease Agreement Drop Office Description Data */
			if ( removeAgmtDrpOffDescVos != null && removeAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.removeAgmtDrpOffDescData(removeAgmtDrpOffDescVos);
			}

			if ( insertAgmtDrpOffDescVos != null && insertAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.addAgmtDrpOffDescData(insertAgmtDrpOffDescVos);
			}
			
			if ( modifyAgmtDrpOffDescVos != null && modifyAgmtDrpOffDescVos.size() > 0 ) {
				dbDao.modifyAgmtDrpOffDescData(modifyAgmtDrpOffDescVos);
			}
			
			/* Handling Lease Agreement Rate with Container Type Size  */
			dbDao.removeLeaseAgreementRateWithTPSZData(agreementRegistrationVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Modify"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement Modify"}).getMessage(),ex);
		}
	}

	/**
	 * Mapping Data of Lease Agreement General Tab to LSE_AGMT_RT Table VO <br>
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
	 * Mapping Data of Lease Agreement Per-diem Tab to LSE_AGMT_RT Table VO<br>
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
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPerDiemVO);
							}
						}
														
					    if (JSPUtil.getNull(cntrN1Amt).equals("") ) {
					    	cntrN1Amt = "0";
					    }
					
						LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
		
						agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
						agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
						agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
						agmtRtVO.setEqLocTpCd(agmtPerDiemVO.getEqLocTpCd());
						agmtRtVO.setCntrRntlChgTpCd("PDGV");
						agmtRtVO.setCntrTpszCd(cntrTpSzCd);
						agmtRtVO.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
						agmtRtVO.setN1stChgAmt(cntrN1Amt);
						agmtRtVO.setN2ndChgAmt("0");
						agmtRtVO.setCreUsrId(account.getUsr_id());
						agmtRtVO.setUpdUsrId(account.getUsr_id());
						
							
						insertAgmtRtVos.add(agmtRtVO);
					}
				} else if ( agmtPerDiemVO.getIbflag().equals("U") ) {
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtPerDiemVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtPerDiemVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("PDGV");
					agmtRtVO1.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO1);
	
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);
	
						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPerDiemVO);
							}
						}

						LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();

					    if (JSPUtil.getNull(cntrN1Amt).equals("") ) {
					    	cntrN1Amt = "0";
					    }
					    
						agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
						agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
						agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
						agmtRtVO.setEqLocTpCd(agmtPerDiemVO.getEqLocTpCd());
						agmtRtVO.setCntrRntlChgTpCd("PDGV");
						agmtRtVO.setCntrTpszCd(cntrTpSzCd);
						agmtRtVO.setAgmtChgVal(agmtPerDiemVO.getAgmtChgVal());
						agmtRtVO.setN1stChgAmt(cntrN1Amt);
						agmtRtVO.setN2ndChgAmt("0");
						agmtRtVO.setCreUsrId(account.getUsr_id());
						agmtRtVO.setUpdUsrId(account.getUsr_id());

						insertAgmtRtVos.add(agmtRtVO);
					}
				} else if ( agmtPerDiemVO.getIbflag().equals("D") ) {
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtPerDiemVO.getLocCd());
					agmtRtVO.setEqLocTpCd(agmtPerDiemVO.getEqLocTpCd());
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
	 * Mapping Data of Lease Agreement Lifting Charge Tab to LSE_AGMT_RT Table VO<br>
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
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N2Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							}
						}

//						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0)
//						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {

							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
							agmtRtVO.setEqLocTpCd(agmtLiftChargeVO.getEqLocTpCd());
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
//						}
					}
				} else if ( agmtLiftChargeVO.getIbflag().equals("U") ) {
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtLiftChargeVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtLiftChargeVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("LIFV");
					agmtRtVO1.setAgmtChgVal(agmtLiftChargeVO.getAgmtChgVal());
					
					removeAgmtRtVos.add(agmtRtVO1);
					
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N2Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtLiftChargeVO);
							}
						}

//						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0)
//						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
							agmtRtVO.setEqLocTpCd(agmtLiftChargeVO.getEqLocTpCd());
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
//						}
					}
				} else if ( agmtLiftChargeVO.getIbflag().equals("D") ) {
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtLiftChargeVO.getLocCd());
					agmtRtVO.setEqLocTpCd(agmtLiftChargeVO.getEqLocTpCd());
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
	 * Mapping Data of Lease Agreement DOL/DOC Tab to LSE_AGMT_RT Table VO <br>
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
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"ChgVal") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtDolDocVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtDolDocVO);
							}
						}

//						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Integer.parseInt(cntrN1Amt) != 0)
//						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {

							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
							agmtRtVO.setEqLocTpCd(agmtDolDocVO.getEqLocTpCd());
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
//						}
					}
				} else if ( agmtDolDocVO.getIbflag().equals("U") ) {
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDolDocVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtDolDocVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("DOCV");

					removeAgmtRtVos.add(agmtRtVO1);
					
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"ChgVal") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtDolDocVO);
							} else if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN2Amt = (String)methods[k].invoke(agmtDolDocVO);
							}
						}

//						if ( (!JSPUtil.getNull(cntrN1Amt).equals("") && Integer.parseInt(cntrN1Amt) != 0)
//						  || (!JSPUtil.getNull(cntrN2Amt).equals("") && Double.parseDouble(cntrN2Amt) != 0.0) ) {
							LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
			
							agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
							agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
							agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
							agmtRtVO.setEqLocTpCd(agmtDolDocVO.getEqLocTpCd());
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
//						}
					}
				} else if ( agmtDolDocVO.getIbflag().equals("D") ) {
					LseAgmtRtVO agmtRtVO = new LseAgmtRtVO();
					
					agmtRtVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO.setLocCd(agmtDolDocVO.getLocCd());
					agmtRtVO.setEqLocTpCd(agmtDolDocVO.getEqLocTpCd());
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
	 * Mapping Data of Lease Agreement Penalty Tab to LSE_AGMT_RT Table VO<br>
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
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);

						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPenaltyVO);
							}
						}
								
						//if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
						if ( !JSPUtil.getNull(cntrN1Amt).equals("")) {
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
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtPenaltyVO.getLocCd());
					agmtRtVO1.setCntrRntlChgTpCd("PNTV");
					
					removeAgmtRtVos.add(agmtRtVO1);
	
					for ( int j = 0 ; j < orgCntrTpSzCds.size() ; j++ ) {
						cntrTpSzCd  = (String)orgCntrTpSzCds.get(j);
	
						for ( int k = 0 ; k < methods.length ; k++ ) {
							if ( methods[k].getName().equals("getCntr"+(j+1)+"N1Amt") ) {
								cntrN1Amt = (String)methods[k].invoke(agmtPenaltyVO);
							}
						}

						//if ( !JSPUtil.getNull(cntrN1Amt).equals("") && Double.parseDouble(cntrN1Amt) != 0.0 ) {
						if ( !JSPUtil.getNull(cntrN1Amt).equals("")) { 
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
	 * Mapping Data of Lease Agreement DPP Tab to LSE_AGMT_RT Table VO<br>
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
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO agmtRtVO2 = new LseAgmtRtVO();

					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("DPPV");
					agmtRtVO1.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					agmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO2.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO2.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtRtVO2.setCntrRntlChgTpCd("LDPV");
					agmtRtVO2.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					removeAgmtRtVos.add(agmtRtVO1);
					removeAgmtRtVos.add(agmtRtVO2);
					
					agmtDppVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtDppVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtDppVO.setCreUsrId(account.getUsr_id());
					agmtDppVO.setUpdUsrId(account.getUsr_id());
					
					agmtDppVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtDppVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtDppVO.setLocCd(agmtDppVO.getLocCd());
					agmtDppVO.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtDppVO.setCntrRntlChgTpCd("DPPV");
					agmtDppVO.setCntrTpszCd(agmtDppVO.getCntrTpszCd());
					
					insertAgmtRtVos.add(agmtDppVO);
					
				} else if ( agmtDppVO.getIbflag().equals("U") ) {
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO agmtRtVO2 = new LseAgmtRtVO();

					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("DPPV");
					agmtRtVO1.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					agmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO2.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO2.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtRtVO2.setCntrRntlChgTpCd("LDPV");
					agmtRtVO2.setCntrTpszCd(agmtDppVO.getCntrTpszCd());

					removeAgmtRtVos.add(agmtRtVO1);
					removeAgmtRtVos.add(agmtRtVO2);
	
					agmtDppVO.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtDppVO.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtDppVO.setCreUsrId(account.getUsr_id());
					agmtDppVO.setUpdUsrId(account.getUsr_id());
			
					insertAgmtRtVos.add(agmtDppVO);
				} else if ( agmtDppVO.getIbflag().equals("D") ) {
					LseAgmtRtVO agmtRtVO1 = new LseAgmtRtVO();
					LseAgmtRtVO agmtRtVO2 = new LseAgmtRtVO();
					
					agmtRtVO1.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO1.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO1.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO1.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
					agmtRtVO1.setCntrRntlChgTpCd("DPPV");
					agmtRtVO1.setCntrTpszCd(agmtDppVO.getCntrTpszCd());
					
					agmtRtVO2.setAgmtCtyCd(agreementVO.getAgmtCtyCd());
					agmtRtVO2.setAgmtSeq(agreementVO.getAgmtSeq());
					agmtRtVO2.setLocCd(agmtDppVO.getLocCd());
					agmtRtVO2.setEqLocTpCd(agmtDppVO.getEqLocTpCd());
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
	 * Handling Lease Agreement Version Up <br>
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

			strNewAgmtVerSeq = dbDao.searchAgreementNewVersionSequenceData(strAgmtCtyCd, strAgmtSeq);

			agreementRegistrationVO.getAgreementVO().setAgmtVerSeq(strNewAgmtVerSeq);
			
			/* Generating Lease Agreement Rata History Data */
			dbDao.addLeaseAgreementRateHistoryData(strAgmtCtyCd, strAgmtSeq, Integer.parseInt(strNewAgmtVerSeq)-1, account.getUsr_id());
			/* Modifying Lease Agreement Data  */
			dbDao.modifyLeaseAgreementData(agreementRegistrationVO);
			/* Generating Lease Agreement Version Data */
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
	 * Retrieving Lease Agreement Version List <br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementVersionListBasic(AgreementVO searchAgreementVO) throws EventException {
		int cnt = 0;                      
		List<AgreementVO> resultVOs = null; 

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
	 * Retrieving Lease Agreement Term & Condition Lists <br>
	 * 
	 * @param String expFromDt
	 * @param String expToDt
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @param String orgCntrTpszCd
	 * @param String ofcCd
	 * @param String allLstmCd	 * 
	 * @param String lsePayTpCd
	 * @return List<AgreementListVO>
	 * @exception EventException
	 */
	public List<AgreementListVO> searchAgreementListBasic(String expFromDt, String expToDt, String vndrSeq, String lstmCd, String orgCntrTpszCd, String ofcCd, String allLstmCd, String lsePayTpCd) throws EventException {
		List<AgreementListVO> resultVOs = null; 

		try {
			resultVOs = dbDao.searchAgreementListData(expFromDt, expToDt, vndrSeq, lstmCd, orgCntrTpszCd, ofcCd, allLstmCd,lsePayTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement List Search"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"Lease Agreement List Search"}).getMessage(),ex);
		}
		
		return resultVOs;
	}
}