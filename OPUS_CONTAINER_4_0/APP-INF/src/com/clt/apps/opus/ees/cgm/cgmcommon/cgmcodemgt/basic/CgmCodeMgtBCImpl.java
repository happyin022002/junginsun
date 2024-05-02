/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtBCImpl.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration.CgmCodeMgtDBDAO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CgmCommon Business Logic Basic Command implementation<br>
 * - OPUS-CgmCommon biz logic handling.<br>
 * 
 * @author KIM CHANG SIK
 * @see CgmCodeMgtEventResponse,CgmCodeMgtBC each DAO class reference
 * @since J2EE 1.4
 */

public class CgmCodeMgtBCImpl extends BasicCommandSupport implements CgmCodeMgtBC {

	// Database Access Object
	private transient CgmCodeMgtDBDAO dbDao = null;

	/**
	 * CgmCodeMgtBCImpl objects creation<br>
	 * CgmCodeMgtDBDAO creation.<br>
	 */
	public CgmCodeMgtBCImpl() {
		dbDao = new CgmCodeMgtDBDAO();
	}

	/**
	 * Chassis Pool Agreement information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchAgreementByPoolBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchAgreementByPoolData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Chassis Pool list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchPoolListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchPoolListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM_EQ_SPEC table Spec No list retrieve. [NO_ID]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchSpecListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchSpecListData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Retrieve Chassis or M.G.Set Type Size list. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchEqTpszListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchEqTpszListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * MDM table Manufacture list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchManuListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchManuListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Neutral Pool Agreement list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMgsetNoFindBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchMgsetNoFindData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM common code list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCommonCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCommonCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * MDM_VENDOR table Vendor Code and Name retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchVendorCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchVendorCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * MDM_STATE table State information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchStateCodeListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchStateCodeListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM_EQ_LOT Cert No list retrieve. [EES_CGM_1005]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCertChassisListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCertChassisListData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM_EQ_LOT Cert No list retrieve. Retrieve. <br>
	 * 
	 * @param mdmOrganizationINVO
	 *            MdmOrganizationINVO
	 * @return MdmOrganizationMGTVO
	 * @exception EventException
	 */
	public MdmOrganizationMGTVO searchOrganizationBasic(MdmOrganizationINVO mdmOrganizationINVO) throws EventException {
		// Map object for Response object
		MdmOrganizationMGTVO mdmOrganizationMGTVO = new MdmOrganizationMGTVO();

		try {
			// ETCDATA setting
			List<MdmOrganizationMGTVO> orglist = dbDao.searchOrganizationData(mdmOrganizationINVO);

			if (orglist != null) {
				if (orglist.size() > 0) {
					for (int i = 0; i < orglist.size(); i++) {
						mdmOrganizationMGTVO = (MdmOrganizationMGTVO) orglist.get(0);
					}
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return mdmOrganizationMGTVO;
	}

	/**
	 * MDM table Financing Company list retrieve. [NO_ID]<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchFinancingCoBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchFinancingCoData(comboINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Agreement No check and retrieve. [NO_ID] <br>
	 * 
	 * @param agreementINVO
	 *            AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception EventException
	 */
	public List<AgreementMGTVO> searchAgreementMainBasic(AgreementINVO agreementINVO) throws EventException {
		try {
			return dbDao.searchAgreementMainData(agreementINVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		// return agreementList;
	}

	/**
	 * mdm_mvmt_sts table information retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchMovementStatusListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchMovementStatusListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Neutral Pool Agreement list retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchNuPoolListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchNuPoolListData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * WEEK, FROM DATE, TO DATE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateBasic(ComboINVO comboINVO) throws EventException {
		try {

			String tmp_inq_dys = comboINVO.getEqSpecNo();

			tmp_inq_dys = tmp_inq_dys.replaceAll("-", "");
			comboINVO.setEqSpecNo(tmp_inq_dys);

			return dbDao.searchWeekFmToDateData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * YEAR-WEEK로 WEEK, FROM DATE, TO DATE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchWeekFmToDateByWeekBasic(ComboINVO comboINVO) throws EventException {
		try {

			String tmp_inq_dys = comboINVO.getEqSpecNo();

			tmp_inq_dys = tmp_inq_dys.replaceAll("-", "");

			comboINVO.setEqSpecNo(tmp_inq_dys.substring(0, 4));
			comboINVO.setEqKndCd(tmp_inq_dys.substring(4, 6));

			return dbDao.searchWeekFmToDateByWeekData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * RCC,LCC,SCC retrieve and Validation check. Retrieve. <br>
	 * 
	 * @param eqOrzChtINVO
	 *            EqOrzChtINVO
	 * @return List<EqOrzChtMGTVO>
	 * @exception EventException
	 */
	public List<EqOrzChtMGTVO> searchEqOrzChtBasic(EqOrzChtINVO eqOrzChtINVO) throws EventException {
		try {
			if ("LCCSCC".equals(eqOrzChtINVO.getEqOrzChtChktype())) {
				String crntLccCd = eqOrzChtINVO.getEqOrzChtLccCd();
				if (crntLccCd != null && !crntLccCd.equals("")) {
					crntLccCd = "'" + crntLccCd.replaceAll(",", "', '") + "'";
					eqOrzChtINVO.setEqOrzChtLccCd(crntLccCd);
				}
			}
			return dbDao.searchEqOrzChtData(eqOrzChtINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * COST COFFICE CODE  retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchCostOfficeBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchCostOfficeData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Invoice Service Provier retrieve. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchInvSerProviderBasic(ComboINVO comboINVO) throws EventException {
		try {
			comboINVO.setCostYrmon(comboINVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchInvSerProviderData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Retrieve Local Time by Office Code. Retrieve. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception EventException
	 */
	public List<ComboMGTVO> searchLocalTimeByOfficeBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchLocalTimeByOfficeData(comboINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param ComboINVO comboINVO
	 * @return List<ComboMGTVO>
	 * @throws EventException
	 */
	@Override
	public List<ComboMGTVO> searchChssPoolCoListBasic(ComboINVO comboINVO) throws EventException {
		try {
			return dbDao.searchChssPoolCoListData(comboINVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * 
	 * @param ComboMGTVO[] comboMGTVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	@Override
	public void manageChssPoolCoListBasic(ComboMGTVO[] comboMGTVOS, SignOnUserAccount account) throws EventException {
		try {
			List<ComboMGTVO> insertVoList = new ArrayList<ComboMGTVO>();
			List<ComboMGTVO> updateVoList = new ArrayList<ComboMGTVO>();
			List<ComboMGTVO> deleteVoList = new ArrayList<ComboMGTVO>();

			for (int i = 0; i < comboMGTVOS.length; i++) {
				if (comboMGTVOS[i].getIbflag().equals("I")) {
					comboMGTVOS[i].setCreUsrId(account.getUsr_id());
					comboMGTVOS[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(comboMGTVOS[i]);
				} else if (comboMGTVOS[i].getIbflag().equals("U")) {
					comboMGTVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(comboMGTVOS[i]);
				} else if (comboMGTVOS[i].getIbflag().equals("D")) {
					deleteVoList.add(comboMGTVOS[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addChssPoolCoListData(insertVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyChssPoolCoListData(updateVoList);
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeChssPoolCoListData(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	
	/**
	 * Local Time Retrieve. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalTimeBasic(String ofcCd) throws EventException {
		try {
			return dbDao.searchLocalTimeData(ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
}
