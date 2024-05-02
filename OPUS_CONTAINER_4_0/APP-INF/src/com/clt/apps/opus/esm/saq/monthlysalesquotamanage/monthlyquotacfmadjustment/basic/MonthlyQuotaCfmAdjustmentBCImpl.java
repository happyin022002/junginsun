/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaCfmAdjustmentBCImpl.java
 *@FileTitle : Sales. Rep
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0164Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0165Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.event.EsmSaq0167Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacfmadjustment.integration.MonthlyQuotaCfmAdjustmentDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonCfmQtaOfcAddVO;
import com.clt.syscommon.common.table.SaqMonCfmQtaVO;
import com.clt.syscommon.common.table.SaqMonCfmTgtVvdVO;

/**
 * MonthlySalesQuotaManage Business Logic Command Interface<br>
 * 
 * @author
 * @see ESM_SAQ_0164EventResponse,MonthlyQuotaCfmAdjustmentBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaCfmAdjustmentBCImpl extends BasicCommandSupport implements MonthlyQuotaCfmAdjustmentBC {

	// Database Access Object
	private transient MonthlyQuotaCfmAdjustmentDBDAO dbDao = null;

	public MonthlyQuotaCfmAdjustmentBCImpl() {
		dbDao = new MonthlyQuotaCfmAdjustmentDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyTargetVVDMapping0164List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			listVO.addList(dbDao.searchMonthlyTargetVVDMapping0164List(conditionVO));

			listVO.addList(dbDao.searchMonthlyTargetVVDMappingOrg0164List(conditionVO));

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * @param EsmSaq0164Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyTargetVVD0164(EsmSaq0164Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonCfmTgtVvdVO[] saqConVOs = event.getSaqMonCfmTgtVvdVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonCfmTgtVvdVO> updateVoList = new ArrayList<SaqMonCfmTgtVvdVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				saqConVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(saqConVOs[i]);

			}

			if (updateVoList.size() > 0) {
				dbDao.updateSaqMonCfmTgtVvd0164(updateVoList, conditionVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQtaEdit0165List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			listVO.addList(dbDao.searchMonthlyQtaEdit0165List(conditionVO));

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * updateMonthlyQtaEditList <br>
	 * 
	 * @param EsmSaq0165Event event
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updateMonthlyQtaEdit0165(EsmSaq0165Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonCfmQtaVO[] saqConVOs = event.getSaqMonCfmQtaVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonCfmQtaVO> updateVoListA = new ArrayList<SaqMonCfmQtaVO>();
			List<SaqMonCfmQtaVO> updateVoListB = new ArrayList<SaqMonCfmQtaVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("U")) {

					saqConVOs[i].setUpdUsrId(account.getUsr_id());

					if (!"O".equals(saqConVOs[i].getAddTpCd()) && !"L".equals(saqConVOs[i].getAddTpCd())) {
						updateVoListA.add(saqConVOs[i]);
					} else {
						updateVoListB.add(saqConVOs[i]);
					}
				}
			}

			// saq_mon_cfm_qta update
			if (updateVoListA.size() > 0) {
				dbDao.updateSaqMonCfmQta0165A(updateVoListA, conditionVO);
			}
			if (updateVoListB.size() > 0) {
				dbDao.updateSaqMonCfmQta0165B(updateVoListB, conditionVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyVVD0166List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			listVO.addList(dbDao.searchMonthlyVVD0166List(conditionVO));

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaEditOfficeAdd0167List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			listVO.addList(dbDao.searchMonthlyQuotaEditOfficeAdd0167List(conditionVO));

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaEditOfficeAddNew0167List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			if (conditionVO.getAdd_tp_cd().equals("O")) {
				listVO.addList(dbDao.searchMonthlyQuotaEditOfficeAddNew0167List(conditionVO));
			} else {

				listVO.addList(dbDao.searchMonthlyQuotaEditLaneOfficeAddNew0167List(conditionVO));
			}

			return listVO;

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param EsmSaq0167Event event
	 * @param account SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaEditOfficeAdd0167(EsmSaq0167Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonCfmQtaOfcAddVO[] saqConVOs = event.getSaqMonCfmQtaOfcAddVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonCfmQtaOfcAddVO> insertVoListA1 = new ArrayList<SaqMonCfmQtaOfcAddVO>();
			List<SaqMonCfmQtaOfcAddVO> insertVoListB1 = new ArrayList<SaqMonCfmQtaOfcAddVO>();
			List<SaqMonCfmQtaOfcAddVO> insertVoListC1 = new ArrayList<SaqMonCfmQtaOfcAddVO>();
			List<SaqMonCfmQtaOfcAddVO> updateVoListA1 = new ArrayList<SaqMonCfmQtaOfcAddVO>();
			List<SaqMonCfmQtaOfcAddVO> deleteVoListA1 = new ArrayList<SaqMonCfmQtaOfcAddVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if ("I".equals(saqConVOs[i].getIbflag())) {

					saqConVOs[i].setCreUsrId(account.getUsr_id());
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					saqConVOs[i].setTempQtaTgtCd(saqConVOs[i].getQtaTgtCd());

					if ("Office".equals(conditionVO.getAdd_tp_cd())) {
						saqConVOs[i].setTempRlaneCd(saqConVOs[i].getRlaneCd());
					} else {
						saqConVOs[i].setTempRlaneCd(saqConVOs[i].getNewRlaneCd());
					}

					insertVoListA1.add(saqConVOs[i]);
				}
				if ("U".equals(saqConVOs[i].getIbflag())) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());

					if ("Office".equals(conditionVO.getAdd_tp_cd())) {
						saqConVOs[i].setTempRlaneCd(conditionVO.getRlane_cd());
					} else {
						saqConVOs[i].setTempRlaneCd(conditionVO.getNewRlaneCd());
					}

					updateVoListA1.add(saqConVOs[i]);
				}

				if ("I".equals(saqConVOs[i].getIbflag()) && "L".equals(saqConVOs[i].getAddTpCd())) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					saqConVOs[i].setUpdUsrId(account.getUsr_id());

					insertVoListB1.add(saqConVOs[i]);
				}

				if (("I".equals(saqConVOs[i].getIbflag()) || "U".equals(saqConVOs[i].getIbflag())) && "0".equals(saqConVOs[i].getDeltFlg())) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					saqConVOs[i].setUpdUsrId(account.getUsr_id());

					if ("Office".equals(conditionVO.getAdd_tp_cd())) {
						saqConVOs[i].setTempRlaneCd(conditionVO.getRlane_cd());
					} else {
						saqConVOs[i].setTempRlaneCd(conditionVO.getNewRlaneCd());
					}
					// saqConVOs[i].setAddTpCd(conditionVO.getAdd_tp_cd());

					insertVoListC1.add(saqConVOs[i]);
				}

				if ("U".equals(saqConVOs[i].getIbflag()) && "1".equals(saqConVOs[i].getDeltFlg())) {

					if ("Office".equals(conditionVO.getAdd_tp_cd())) {
						saqConVOs[i].setTempRlaneCd(conditionVO.getRlane_cd());
					} else {
						saqConVOs[i].setTempRlaneCd(conditionVO.getNewRlaneCd());
					}

					deleteVoListA1.add(saqConVOs[i]);
				}

			}
			
			String unitCostFlag = dbDao.checkAvgCostOfcCnt(conditionVO);

			// SAQ_MON_CFM_QTA_OFC_ADD INSERT
			if (insertVoListA1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddA0167(insertVoListA1, conditionVO);
			}
			// SAQ_MON_CFM_QTA_OFC_ADD UPDATE
			if (updateVoListA1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddB0167(updateVoListA1, conditionVO);
			}
			// SAQ_MON_CFM_TGT_VVD INSERT
			if (insertVoListB1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddC0167(insertVoListB1, conditionVO);
			}
			// SAQ_MON_CFM_QTA INSERT
			if (insertVoListC1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddD0167(insertVoListC1, conditionVO, unitCostFlag);
			}
			// SAQ_MON_CFM_QTA_OFC_ADD DELETE
			if (deleteVoListA1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddF0167(deleteVoListA1, conditionVO);
			}
			
			// SAQ_MON_CFM_QTA DELETE
			if (deleteVoListA1.size() > 0) {
				dbDao.multiMonthlyQuotaEditOfficeAddE0167(deleteVoListA1, conditionVO);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}