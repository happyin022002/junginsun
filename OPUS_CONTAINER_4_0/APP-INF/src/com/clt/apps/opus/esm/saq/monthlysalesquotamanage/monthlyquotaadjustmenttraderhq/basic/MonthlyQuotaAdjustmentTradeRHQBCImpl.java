/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentTradeRHQBCImpl.java
 *@FileTitle : Monthly Sales Quota Adjustment Trade - RHQ
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0085Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.event.EsmSaq0148Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration.MonthlyQuotaAdjustmentTradeRHQDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyAdjustmentTradeRhqTabLaneListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyQuotaAdjustmentTradeRhqListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.vo.SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;

/**
 * MonthlySalesQuotaManage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0085EventResponse, MonthlyQuotaAdjustmentTradeRHQBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentTradeRHQBCImpl extends BasicCommandSupport implements MonthlyQuotaAdjustmentTradeRHQBC {

	private transient MonthlyQuotaAdjustmentTradeRHQDBDAO dbDao = null;

	public MonthlyQuotaAdjustmentTradeRHQBCImpl() {
		dbDao = new MonthlyQuotaAdjustmentTradeRHQDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRhq0085List01(QuotaConditionVO quotaConditionVO) throws EventException {
		try {

			ReturnVO listVO = new ReturnVO();
			DBRowSet rowSet = null;
			List<SearchMonthlyQuotaAdjustmentTradeRhqListVO> searchMonthlyQuotaAdjustmentTradeRhqListVOs = null;

			String rlaneCd = "";
			String mqtaMdlVerNo = "";
			String slsFcastPubNo = "";
			String inclPortFlag = "";

			rowSet = dbDao.getPreviousCheckKey0085(quotaConditionVO);

			if (rowSet.next()) {
				mqtaMdlVerNo = rowSet.getString("mqta_mdl_ver_no");
				slsFcastPubNo = rowSet.getString("sls_fcast_pub_no");
				inclPortFlag = rowSet.getString("incl_port_flg");

				quotaConditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				quotaConditionVO.setMqtaMdlVerNo(mqtaMdlVerNo);
				quotaConditionVO.setSlsFcastPubNo(slsFcastPubNo);
				quotaConditionVO.setInclPortFlag(inclPortFlag);
			}
			rlaneCd = quotaConditionVO.getSearch_rlane_cd();

			if ("Y".equals(inclPortFlag) && (rlaneCd == null || rlaneCd.length() == 0)) {
				rlaneCd = dbDao.searchSaqMonQtaStepTrdLane0085List(quotaConditionVO);

			}

			searchMonthlyQuotaAdjustmentTradeRhqListVOs = dbDao.searchMonthlyQuotaAdjustmentTradeRhq0085List01(quotaConditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentTradeRhqListVOs);

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
	 * @param QuotaConditionVO quotaConditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTradeRhq0085Tab03(QuotaConditionVO quotaConditionVO) throws EventException {
		try {

			ReturnVO listVO = new ReturnVO();
			List<SearchMonthlyAdjustmentTradeRhqTabLaneListVO> searchMonthlyAdjustmentTradeRhqTabLaneListVOs = null;

			searchMonthlyAdjustmentTradeRhqTabLaneListVOs = dbDao.searchMonthlyAdjustmentTradeRhq0085Tab03(quotaConditionVO);
			listVO.addList(searchMonthlyAdjustmentTradeRhqTabLaneListVOs);

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
	 * @param EsmSaq0085Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentTradeRhq0085(EsmSaq0085Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaTrdVO[] saqConVOs = event.getSaqMonQtaTrdVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaTrdVO> insertVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> updateVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> deleteVoList = new ArrayList<SaqMonQtaTrdVO>();
			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.updateMonthlyAdjustmentTradeRhq0085(updateVoList, conditionVO);
			}

			DBRowSet rowSet = dbDao.getPreviousCheckKey0085(conditionVO);

			if (rowSet.next()) {
				conditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				conditionVO.setMqtaMdlVerNo(rowSet.getString("mqta_mdl_ver_no"));
				conditionVO.setSlsFcastPubNo(rowSet.getString("sls_fcast_pub_no"));
				conditionVO.setInclPortFlag(rowSet.getString("incl_port_flg"));
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
	 * @param EsmSaq0085Event event
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentTradeRhqInfo0085(EsmSaq0085Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaTrdVO[] saqConVOs = event.getSaqMonQtaTrdVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaTrdVO> insertVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> updateVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> deleteVoList = new ArrayList<SaqMonQtaTrdVO>();

			String newVersionNo = "";
			newVersionNo = dbDao.getNewMonthlyQuotaStepVersionNumber0085(conditionVO);
			log.debug("newVersionNo  >>[" + newVersionNo + "]");

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					saqConVOs[i].setMqtaVerNo(newVersionNo);
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			conditionVO.setNewVersion(newVersionNo);
			conditionVO.setUserId(account.getUsr_id());
			dbDao.createMonthlyAdjustmentTradeRhqInfoA0085(conditionVO);
			dbDao.createMonthlyAdjustmentTradeRhqInfoB0085(conditionVO);

			if (updateVoList.size() > 0) {
				dbDao.updateMonthlyAdjustmentTradeRhq0085(updateVoList, conditionVO);
			}

			conditionVO.setNewStepCd(conditionVO.getMQtaStepCd());
			conditionVO.setCtrtOfcCd(null);
			dbDao.createSaqMonQtaOfcModMix0085(conditionVO);

			conditionVO.setMQtaVerNo(newVersionNo);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelCurrentVersion0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			int cnt = 0;
			String stsCd = "XX";

			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			cnt = dbDao.checkCancelAllCurrentVersion0085(conditionVO);

			if (cnt < 2) {
				throw new EventException((new ErrorHandler("SAQ00036")).getMessage());
			}

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqConfirmDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "DC"; // 00 => DC
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());
			conditionVO.setStatusCd(stsCd);

			int statusDC = dbDao.getSaqStsCdIngCount0085(conditionVO);
			if (statusDC > 0) {
				throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
			}

			String months = dbDao.getLoadRoundOffNeedMonth0085(conditionVO);
			if (months.length() > 0) {
				throw new EventException((new ErrorHandler("SAQ00020", new String[] { months })).getMessage());
			}

			conditionVO.setSaq_sts_cd("00");
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelConfirmation0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "00"; // DC => 00

			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("DC");
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqFinalConfirmDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "FC"; // FR => FC
			String tempMqtaStepCd = conditionVO.getMQtaStepCd();
			String tempMqtaVerNo = conditionVO.getMQtaVerNo();

			conditionVO.setUserId(account.getUsr_id());
			dbDao.createSaqMonFxMdlSmry0085(conditionVO);

			dbDao.createMonthlyAdjustmentRhqRgnInfoA0085(conditionVO);
			int updateCnt = dbDao.createMonthlyAdjustmentRhqRgnInfoB0085(conditionVO);

			conditionVO.setMQtaStepCd("04");
			String version = dbDao.getMonthlyQuotaStepVersionNumber0085(conditionVO);

			if (updateCnt == 0) {
				log.debug("version 삭제 ***********************");
				conditionVO.setMQtaStepCd("04");
				conditionVO.setMQtaVerNo(version);
				dbDao.deleteSaqMonQtaStepVer0085(conditionVO);

			} else {
				log.debug("version insert ***********************");
				conditionVO.setMQtaStepCd("07");
				conditionVO.setCondStepCd("04");
				conditionVO.setMQtaVerNo(version);
				dbDao.createSaqMonQtaStepVer0085(conditionVO);

				dbDao.createSaqMonQtaRhq0085(conditionVO);

				conditionVO.setMQtaStepCd("04");
				dbDao.procAdjustmentLoadRoundOff(conditionVO);
			}
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMqtaStepCd);
			conditionVO.setMQtaVerNo(tempMqtaVerNo);
			conditionVO.setSaq_sts_cd("FR");
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			dbDao.modifySaqMonQtaTrdRmkStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqNotifyDraft0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "DN"; // DC => DN
			String tempMqtaStepCd = conditionVO.getMQtaStepCd();
			String tempMqtaVerNo = conditionVO.getMQtaVerNo();

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("DC");
			conditionVO.setUserId(account.getUsr_id());
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			boolean checkFlag = dbDao.isAllNotifyRhq0085(conditionVO);

			log.debug("procAdjustmentTradeRhqNotifyDraft0085  1");
			if (checkFlag) {
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-1");
				conditionVO.setMQtaStepCd("01");
				String newVersion = dbDao.searchSaqMonQtaStepVer020085(conditionVO);
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-2");
				dbDao.createMonthlyAdjustmentTradeFinalInfoA0085(conditionVO);
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-3");
				dbDao.createMonthlyAdjustmentTradeFinalInfoB0085(conditionVO);

				conditionVO.setStatusCd("DR");
				conditionVO.setMQtaStepCd("01");
				conditionVO.setMQtaVerNo("");
				conditionVO.setSaq_sts_cd("DN");
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-4");
				dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

				// Mix copy
				conditionVO.setNewStepCd("03");
				conditionVO.setNewVersion(newVersion);
				conditionVO.setCtrt_rhq_cd(null);
				conditionVO.setMQtaStepCd("01");
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-5");
				dbDao.createSaqMonQtaOfcModMix0085(conditionVO);
				log.debug("procAdjustmentTradeRhqNotifyDraft0085  1-6");
			}
			log.debug("procAdjustmentTradeRhqNotifyDraft0085  2");
			conditionVO.setMQtaStepCd(tempMqtaStepCd);
			conditionVO.setMQtaVerNo(tempMqtaVerNo);
			dbDao.modifySaqMonQtaTrdRmkStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeRhqCancelNotification0085(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "DC"; // DN => DC
			String tempMqtaStepCd = conditionVO.getMQtaStepCd();

			conditionVO.setMQtaStepCd("01");
			conditionVO.setSaq_sts_cd("DN");
			conditionVO.setOfcCd("");
			int statusDN = dbDao.getSaqStsCdCount0085(conditionVO);
			if (statusDN != 1) {
				throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
			}

			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMqtaStepCd);
			dbDao.modifySaqMonQtaStepVerStatus0085(conditionVO);

			dbDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeRhqLoadZero0085List(QuotaConditionVO conditionVO) throws EventException {

		String retMsg = "";

		try {
			retMsg = dbDao.getListByLoadZero0085(conditionVO);

			return retMsg;

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
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRhqModify0148List(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentTradeRhqModifyListVO> searchMonthlyQuotaAdjustmentTradeRhqModifyListVOs = null;

		try {
			searchMonthlyQuotaAdjustmentTradeRhqModifyListVOs = dbDao.searchMonthlyQuotaAdjustmentTradeRhqModify0148List(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentTradeRhqModifyListVOs);

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
	 * @param EsmSaq0148Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentTradeRhqModify0148(EsmSaq0148Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaTrdVO[] saqConVOs = event.getSaqMonQtaTrdVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaTrdVO> insertVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> updateVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> deleteVoList = new ArrayList<SaqMonQtaTrdVO>();

			for (int i = 0; i < saqConVOs.length; i++) {
				if (saqConVOs[i].getIbflag().equals("I")) {
					saqConVOs[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("U")) {
					saqConVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.multiMonthlyQuotaAdjustmentTradeRhqModify0148(updateVoList, conditionVO);
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