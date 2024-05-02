/**
 * Copyright(c) 2012 CyberLogitec.
 * @FileName : ACMSetupBCImpl.java
 * @FileTitle : Charge Deduction User Setting
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.03.14
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2012.03.14 김상수 1.0 Creation.
 * 2016.08.05 김상현 [CHM-201642499] ALPS > ACM VIP Agreement Creation 상 SC/RFA No. 추가 요청 
 */
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.integration.ACMSetupDBDAO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.CntrTpSzGrpVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FeederageInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FinanceOfficeInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.CntrTpSelectVO;
import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.RevenueStrcSetVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ACMSetup Business Logic Command Interface<br>
 * - ALPS-ACMSetup에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @see Esm_Acm_0003Event,ACMSetupBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ACMSetupBCImpl extends BasicCommandSupport implements ACMSetupBC {

	// Database Access Object
	private transient ACMSetupDBDAO dbDao = null;

	/**
	 * ACMSetupBCImpl 객체 생성<br>
	 * ACMSetupDBDAO를 생성한다.<br>
	 */
	public ACMSetupBCImpl() {
		dbDao = new ACMSetupDBDAO();
	}

	/**
	 * [ESM_ACM_0003]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchChargeDdtSet() throws EventException {
		try {
			return dbDao.searchChargeDdtSet();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0003]
	 * Rep.Charge 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchRepCharge() throws EventException {
		try {
			return dbDao.searchRepCharge();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception EventException
	 */
	public List<ChargeDdtSetVO> searchChargeCode() throws EventException {
		try {
			return dbDao.searchChargeCode();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0003]
	 * Charge Deduction Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param ChargeDdtSetVO chargeDdtSetVO
	 * @exception EventException
	 */
	public void getChargeDdtNmInfo(ChargeDdtSetVO chargeDdtSetVO) throws EventException {
		try {
			if (dbDao.getChargeDdtNmInfo(chargeDdtSetVO).size() > 0) {
				// [ACM00004] - $s is duplicated. Please check $s again!
				throw new EventException(new ErrorHandler("ACM00004", new String[]{"Group Name [" + chargeDdtSetVO.getChgDdctGrpNm() + "]", "Group Name"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 저장<br>
	 *
	 * @param ChargeDdtSetVO[] chargeDdtSetVOs
	 * @param ChargeDdtSetVO[] chargeDdtSetRepChgVOs
	 * @param ChargeDdtSetVO[] chargeDdtSetChargeVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageChargeDdtSet(ChargeDdtSetVO[] chargeDdtSetVOs, ChargeDdtSetVO[] chargeDdtSetRepChgVOs, ChargeDdtSetVO[] chargeDdtSetChargeVOs, SignOnUserAccount account) throws EventException {
		try {
			List<ChargeDdtSetVO> deleteVoList = new ArrayList<ChargeDdtSetVO>();
			List<ChargeDdtSetVO> insertVoList = new ArrayList<ChargeDdtSetVO>();
			if (chargeDdtSetVOs != null && chargeDdtSetVOs.length > 0) {
				for (int i=0; i<chargeDdtSetVOs.length; i++) {
					//** 수정/신규 모두 delete후 insert이므로 deleteVoList에 setting
					deleteVoList.add(chargeDdtSetVOs[i]);
					// User Set List의 RowStatus가 D가 아니면(1건) VoList에 Rep.Charge와 Charge Code를 setting
					if (!"D".equals(chargeDdtSetVOs[i].getIbflag())) {
						if (chargeDdtSetRepChgVOs != null && chargeDdtSetRepChgVOs.length > 0) {
							for (int k=0; k<chargeDdtSetRepChgVOs.length; k++) {
								chargeDdtSetRepChgVOs[k].setChgDdctGrpNm(chargeDdtSetVOs[i].getChgDdctGrpNm());
								chargeDdtSetRepChgVOs[k].setUsrId(account.getUsr_id());
								insertVoList.add(chargeDdtSetRepChgVOs[k]);
							}
						}
						if (chargeDdtSetChargeVOs != null && chargeDdtSetChargeVOs.length > 0) {
							for (int j=0; j<chargeDdtSetChargeVOs.length; j++) {
								chargeDdtSetChargeVOs[j].setChgDdctGrpNm(chargeDdtSetVOs[i].getChgDdctGrpNm());
								chargeDdtSetChargeVOs[j].setUsrId(account.getUsr_id());
								insertVoList.add(chargeDdtSetChargeVOs[j]);
							}
						}
					}
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeChargeDdtSet(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addChargeDdtSet(insertVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0002]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception EventException
	 */
	public List<CntrTpSzGrpVO> searchCntrTpSzGrp() throws EventException {
		try {
			return dbDao.searchCntrTpSzGrp();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception EventException
	 */
	public List<CntrTpSzGrpVO> searchCntrTpSzList() throws EventException {
		try {
			return dbDao.searchCntrTpSzList();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param CntrTpSzGrpVO cntrTpSzGrpVO
	 * @exception EventException
	 */
	public void getCntrTpSzGrpNmInfo(CntrTpSzGrpVO cntrTpSzGrpVO) throws EventException {
		try {
			if (dbDao.getCntrTpSzGrpNmInfo(cntrTpSzGrpVO).size() > 0) {
				// [ACM00004] - $s is duplicated. Please check $s again!
				throw new EventException(new ErrorHandler("ACM00004", new String[]{"Group Name [" + cntrTpSzGrpVO.getCntrTpszGrpNm() + "]", "Group Name"}).getMessage());
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 저장<br>
	 *
	 * @param CntrTpSzGrpVO[] cntrTpSzGrpVOs
	 * @param CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCntrTpSzGrp(CntrTpSzGrpVO[] cntrTpSzGrpVOs, CntrTpSzGrpVO[] cntrTpSzGrpCodeSlctVOs, SignOnUserAccount account) throws EventException {
		try {
			List<CntrTpSzGrpVO> deleteVoList = new ArrayList<CntrTpSzGrpVO>();
			List<CntrTpSzGrpVO> insertVoList = new ArrayList<CntrTpSzGrpVO>();
			if (cntrTpSzGrpVOs != null && cntrTpSzGrpVOs.length > 0) {
				for (int i=0; i<cntrTpSzGrpVOs.length; i++) {
					//** 수정/신규 모두 delete후 insert이므로 deleteVoList에 setting
					deleteVoList.add(cntrTpSzGrpVOs[i]);
					// User Set List의 RowStatus가 D가 아니면(1건) VoList에 Rep.Charge와 Charge Code를 setting
					if (!"D".equals(cntrTpSzGrpVOs[i].getIbflag())) {
						if (cntrTpSzGrpCodeSlctVOs != null && cntrTpSzGrpCodeSlctVOs.length > 0) {
							for (int k=0; k<cntrTpSzGrpCodeSlctVOs.length; k++) {
								cntrTpSzGrpCodeSlctVOs[k].setCntrTpszGrpNm(cntrTpSzGrpVOs[i].getCntrTpszGrpNm());
								cntrTpSzGrpCodeSlctVOs[k].setUsrId(account.getUsr_id());
								insertVoList.add(cntrTpSzGrpCodeSlctVOs[k]);
							}
						}
					}
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeCntrTpSzGrp(deleteVoList);
			}

			if (insertVoList.size() > 0) {
				dbDao.addCntrTpSzGrp(insertVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 조회<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	public List<FinanceOfficeInfoVO> searchFinanceOfficeInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws EventException {
		try {
			return dbDao.searchFinanceOfficeInfo(financeOfficeInfoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 저장<br>
	 *
	 * @param FinanceOfficeInfoVO[] financeOfficeInfoVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageFinanceOfficeInfo(FinanceOfficeInfoVO[] financeOfficeInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<FinanceOfficeInfoVO> insertVoList = new ArrayList<FinanceOfficeInfoVO>();
			List<FinanceOfficeInfoVO> updateVoList = new ArrayList<FinanceOfficeInfoVO>();
			List<FinanceOfficeInfoVO> tempVoList = new ArrayList<FinanceOfficeInfoVO>();
			String ofcTmpNo = dbDao.getAcmOfcInfoTmpSeq(); // ACM_OFC_INFO_TMP테이블의 OFC_TMP_NO

			for (int i=0; i<financeOfficeInfoVOs.length; i++) {
				financeOfficeInfoVOs[i].setOfcTmpNo(ofcTmpNo);
				financeOfficeInfoVOs[i].setUsrId(account.getUsr_id());
				tempVoList.add(financeOfficeInfoVOs[i]);

				if (financeOfficeInfoVOs[i].getIbflag().equals("I")) {
					// Office Charecter가 (CN)일때 BKG_CHN_AGN에서 Sub-Office의 존재유무 확인
					if (financeOfficeInfoVOs[i].getOfcChrCd().equals("3") || financeOfficeInfoVOs[i].getOfcChrCd().equals("4")) {
						if (dbDao.getBkgChnAgnInfo(financeOfficeInfoVOs[i]).size() < 1) {
							throw new EventException(new ErrorHandler("ACM00002", new String[]{"Sub-Office Code [" + financeOfficeInfoVOs[i].getAgnCd() + "]", "Sub-Office Code"}).getMessage());
						}
					}
					// Office Charecter가 그외면 MDM_ORGANIZATION에서 Sub-Office의 존재유무 확인
					else {
						if (dbDao.getMdmOrganizationInfo(financeOfficeInfoVOs[i]).size() < 1) {
							throw new EventException(new ErrorHandler("ACM00002", new String[]{"Sub-Office Code [" + financeOfficeInfoVOs[i].getAgnCd() + "]", "Sub-Office Code"}).getMessage());
						}
					}
					insertVoList.add(financeOfficeInfoVOs[i]);
				} else if (financeOfficeInfoVOs[i].getIbflag().equals("U")) {
					updateVoList.add(financeOfficeInfoVOs[i]);
				}
			}

			dbDao.addFinanceOfficeInfoTemp(tempVoList); // ACM_OFC_INFO_TMP 테이블에 생성
			// ACM_OFC_INFO_TMP 테이블에서 AGN_FM_DT_CD, AGN_TO_DT_CD, AGN_FM_DT, AGN_TO_DT로 중복 체크
			String errOfcInfo =  dbDao.getDupDataFromAcmOfcInfo(ofcTmpNo);
			if (!"".equals(errOfcInfo)) {
				String errDivCd = errOfcInfo.substring(0, 1);
				String errOfcGrpId = errOfcInfo.substring(1);
				if ("A".equals(errDivCd)) {
					// [ACM00003] - $s is invalid. Please check the $s again!
					throw new EventException(new ErrorHandler("ACM00003", new String[]{"The Office Group of  [" + errOfcGrpId + "]", "Office Group code"}).getMessage());
				} else if ("B".equals(errDivCd)) {
					// [ACM00003] - $s is invalid. Please check the $s again!
					throw new EventException(new ErrorHandler("ACM00003", new String[]{"The criteria of from and to of  [" + errOfcGrpId + "]", "effective date"}).getMessage());
				} else {
					// [ACM00004] - $s is duplicated. Please check $s again!
					throw new EventException(new ErrorHandler("ACM00004", new String[]{"Effective date of  [" + errOfcGrpId + "]", "effective date or office information"}).getMessage());
				}
			}
			dbDao.removeFinanceOfficeInfoTemp(ofcTmpNo); // ACM_OFC_INFO_TMP 테이블의 데이터 삭제(by ofcTmpNo)

			for (int j=0; j<insertVoList.size(); j++) {
				FinanceOfficeInfoVO insertVO = insertVoList.get(j);
				insertVO.setAgnInfoSeq(dbDao.getAgnInfoSeq());

				dbDao.addFinanceOfficeInfo(insertVO);
				// ACM_OFC_INFO_HIS 테이블에 INSERT
				dbDao.addFinanceOfficeInfoHistory(insertVO);
			}

			for (int j=0; j<updateVoList.size(); j++) {
				FinanceOfficeInfoVO updateVO = updateVoList.get(j);

				dbDao.modifyFinanceOfficeInfo(updateVO);
				// ACM_OFC_INFO_HIS 테이블에 INSERT
				dbDao.addFinanceOfficeInfoHistory(updateVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_ACM_0038]
	 *  목록을 조회<br>
	 *
	 * @param FeederageInfoVO feederageInfoVO
	 * @return List<FeederageInfoVO>
	 * @exception EventException
	 */
	public List<FeederageInfoVO> searchFeederageInfo(FeederageInfoVO feederageInfoVO) throws EventException {
		try {
			return dbDao.searchFeederageInfo(feederageInfoVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0038] 목록을 저장
	 *
	 * @param FeederageInfoVO[] feederageInfoVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageFeederageInfo(FeederageInfoVO[] feederageInfoVOs, SignOnUserAccount account) throws EventException {
		try {
			List<FeederageInfoVO> insertVoList = new ArrayList<FeederageInfoVO>();

			for (int i=0; i<feederageInfoVOs.length; i++) {
				feederageInfoVOs[i].setUsrId(account.getUsr_id());
				insertVoList.add(feederageInfoVOs[i]);
			}

			if (insertVoList.size() > 0) {
				dbDao.modifyFeederageInfo(insertVoList);
				dbDao.addFeederageInfo(insertVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0026]
	 * Revenue Structure Setting 목록을 조회<br>
	 *
	 * @param RevenueStrcSetVO revenueStrcSetVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	public List<RevenueStrcSetVO> searchRevenueStrcSet(RevenueStrcSetVO revenueStrcSetVO) throws EventException {
		try {
			return dbDao.searchRevenueStrcSet(revenueStrcSetVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0026]
	 * Revenue Structure Setting 목록을 저장<br>
	 *
	 * @param RevenueStrcSetVO[] revenueStrcSetVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRevenueStrcSet(RevenueStrcSetVO[] revenueStrcSetVOs, SignOnUserAccount account) throws EventException {
		try {
			List<RevenueStrcSetVO> insertVoList = new ArrayList<RevenueStrcSetVO>();
			List<RevenueStrcSetVO> updateVoList = new ArrayList<RevenueStrcSetVO>();
			List<RevenueStrcSetVO> deleteVoList = new ArrayList<RevenueStrcSetVO>();

			for (int i=0; i<revenueStrcSetVOs.length; i++) {
				if ( revenueStrcSetVOs[i].getIbflag().equals("D")){
					deleteVoList.add(revenueStrcSetVOs[i]);

				} else {
					// 중복체크
					if (dbDao.searchRevenueStrcSetChk(revenueStrcSetVOs[i]).size() > 0){
						//"Effective date of [value] is duplicated. Please check effective date or  charge code."
						throw new EventException(new ErrorHandler("ACM00008", new String[]{"[" + revenueStrcSetVOs[i].getChgCd() + "]", ""}).getMessage());
					}

					revenueStrcSetVOs[i].setUsrId(account.getUsr_id());
					if (revenueStrcSetVOs[i].getIbflag().equals("I")) {
						insertVoList.add(revenueStrcSetVOs[i]);
					} else if ( revenueStrcSetVOs[i].getIbflag().equals("U")){
						updateVoList.add(revenueStrcSetVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addRevenueStrcSet(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRevenueStrcSet(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeRevenueStrcSet(deleteVoList);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0104]
	 * Container Type Selection 목록을 조회<br>
	 *
	 * @param CntrTpSelectVO mdmCntrTpVO
	 * @return List<CntrTpSelectVO>
	 * @exception EventException
	 */
	public List<CntrTpSelectVO> searchCntrTpSelect(CntrTpSelectVO mdmCntrTpVO) throws EventException {
		//List[] voList = new ArrayList[3];
		try {
			return	dbDao.searchCntrTpSelect(mdmCntrTpVO);

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}