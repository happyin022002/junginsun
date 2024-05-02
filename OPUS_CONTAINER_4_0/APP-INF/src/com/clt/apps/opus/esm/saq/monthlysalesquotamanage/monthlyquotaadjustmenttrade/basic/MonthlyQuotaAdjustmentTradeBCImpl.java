/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentTradeBCImpl.java
 *@FileTitle : Monthly Sales Quota Adjustment Trade Group
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0048Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0147Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.event.EsmSaq0176Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.integration.MonthlyQuotaAdjustmentTradeDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyAdjustmentTabTargetGroupListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttrade.vo.SearchMonthlyQuotaAdjustmentTradeModifyListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonQtaTrdVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * MonthlySalesQuotaManage Business Logic Basic Command implementation<br>
 * handling business transaction<br>
 * 
 * @author
 * @see ESM_SAQ_0048EventResponse,MonthlyQuotaAdjustmentTradeBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentTradeBCImpl extends BasicCommandSupport implements MonthlyQuotaAdjustmentTradeBC {

	// Database Access Object
	private transient MonthlyQuotaAdjustmentTradeDBDAO dbDao = null;

	/**
	 * related objects creation<br>
	 */
	public MonthlyQuotaAdjustmentTradeBCImpl() {
		dbDao = new MonthlyQuotaAdjustmentTradeDBDAO();
	}

	/**
	 * handling for retrieve<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTrade0048List01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentTradeListVO> searchMonthlyQuotaAdjustmentTradeListVOs = null;

		String mqtaMdlVerNo = "";
		String slsFcastPubNo = "";
		String saq_sts_cd = "";
		String curr_step_cd = "01";
		try {

			DBRowSet rowSet = dbDao.getPreviousCheckKey0048(conditionVO);
			if (rowSet.next()) {
				mqtaMdlVerNo = rowSet.getString("mqta_mdl_ver_no");
				slsFcastPubNo = rowSet.getString("sls_fcast_pub_no");
				saq_sts_cd = rowSet.getString("saq_sts_cd");
			}
			conditionVO.setMqtaMdlVerNo(mqtaMdlVerNo);
			conditionVO.setSlsFcastPubNo(slsFcastPubNo);
			conditionVO.setSaq_sts_cd(saq_sts_cd);

			searchMonthlyQuotaAdjustmentTradeListVOs = dbDao.searchMonthlyQuotaAdjustmentTrade0048List01(conditionVO);
			if (!"00".equals(saq_sts_cd) && !"DC".equals(saq_sts_cd) && !"DN".equals(saq_sts_cd) && !"XX".equals(saq_sts_cd)) {
				curr_step_cd = "03";

			}
			conditionVO.setMQtaStepCd(curr_step_cd);

			// checking whether data exists or not
			DBRowSet stepRS = dbDao.searchLoadValueSaqMonQtaOfc0048(conditionVO);
			conditionVO.setIsZeroLoad("FALSE");
			if (stepRS.next()) {
				conditionVO.setIsZeroLoad("TRUE");
			}

			listVO.addList(searchMonthlyQuotaAdjustmentTradeListVOs);

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
	 * MonthlyQuotaAdjustmentTab Target Group - event process
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTargetGroup0048Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTargetGroupListVOs = null;
		try {
			searchMonthlyAdjustmentTabTargetGroupListVOs = dbDao.searchMonthlyAdjustmentTabTargetGroup0048Tab01(conditionVO);
			listVO.addList(searchMonthlyAdjustmentTabTargetGroupListVOs);

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
	 * MonthlyQuotaAdjustmentTab Trade - event process for top TAB.
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyQuotaAdjustmentTradeListVOs = null;
		try {
			searchMonthlyQuotaAdjustmentTradeListVOs = dbDao.searchMonthlyAdjustmentTabTrade0048Tab01(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentTradeListVOs);
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
	 * MonthlyQuotaAdjustmentTab Sub-Trade - event process for top tab.
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTargetGroupListVOs = null;

		try {
			searchMonthlyAdjustmentTabTargetGroupListVOs = dbDao.searchMonthlyAdjustmentTabTrade0048Tab02(conditionVO);
			listVO.addList(searchMonthlyAdjustmentTabTargetGroupListVOs);

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
	 * MonthlyQuotaAdjustmentTab RHQ/Lane - event process for top tab
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyAdjustmentTabTrade0048Tab03(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTargetGroupListVOs = null;

		try {

			searchMonthlyAdjustmentTabTargetGroupListVOs = dbDao.searchMonthlyAdjustmentTabTrade0048Tab03(conditionVO);
			listVO.addList(searchMonthlyAdjustmentTabTargetGroupListVOs);

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
	 * @param QuotaConditionVO conditionVO
	 * @return List<MonthlyQuotaAdustmentTrateVO>
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeRMK0048List01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyAdjustmentTabTargetGroupListVO> searchMonthlyAdjustmentTabTargetGroupListVOs = null;

		try {
			searchMonthlyAdjustmentTabTargetGroupListVOs = dbDao.searchMonthlyQuotaAdjustmentTradeRMK0048List01(conditionVO);
			listVO.addList(searchMonthlyAdjustmentTabTargetGroupListVOs);

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
	 * save event process<br>
	 * MonthlyQuotaAdjustmentTrade - Save event process<br>
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentTrade0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException {
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

			// SAQ_MON_QTA_TRD update.
			if ( updateVoList.size() > 0 ) {
				dbDao.updateMonthlyAdjustmentTrade0048(updateVoList, conditionVO);
			}

			// checking whether data exists or not.
			DBRowSet stepRS = dbDao.searchLoadValueSaqMonQtaOfc0048(conditionVO);
			String isZeroLoad = "FALSE";
			if (stepRS.next()) {
				isZeroLoad = "TRUE";
			}
			conditionVO.setIsZeroLoad(isZeroLoad);

			// retrieving key value.
			DBRowSet rowSet = dbDao.getPreviousCheckKey0048(conditionVO);
			if (rowSet.next()) {
				// retrieving field.[mqta_mdl_ver_no, sls_fcast_pub_no]
				conditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				conditionVO.setMqtaMdlVerNo(rowSet.getString("mqta_mdl_ver_no"));
				conditionVO.setSlsFcastPubNo(rowSet.getString("sls_fcast_pub_no"));

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
	 * handling for save
	 * MonthlyQuotaAdjustmentTrade - Save As New Version event process<br>
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentTradeInfo0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaTrdVO[] saqConVOs = event.getSaqMonQtaTrdVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();
			conditionVO.setUserId(account.getUsr_id());

			List<SaqMonQtaTrdVO> insertVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> updateVoList = new ArrayList<SaqMonQtaTrdVO>();
			List<SaqMonQtaTrdVO> deleteVoList = new ArrayList<SaqMonQtaTrdVO>();

			String newVersionNo = "";
			// new Version create
			newVersionNo = dbDao.getNewMonthlyQuotaStepVersionNumber0048(conditionVO);
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

			// SAQ_MON_QTA_STEP_VER, SAQ_MON_QTA_TRD create object
			conditionVO.setNewVersion(newVersionNo);
			conditionVO.setUserId(account.getUsr_id());
			dbDao.createMonthlyAdjustmentTradeInfoA0048(conditionVO);
			dbDao.createMonthlyAdjustmentTradeInfoB0048(conditionVO);

			// SAQ_MON_QTA_TRD update.
			if (updateVoList.size() > 0) {
				dbDao.updateMonthlyAdjustmentTrade0048(updateVoList, conditionVO);
			}

			// Mix copy
			conditionVO.setNewStepCd(conditionVO.getMQtaStepCd());
			conditionVO.setCtrtOfcCd(null);
			dbDao.createSaqMonQtaOfcModMix0048(conditionVO);

			// checking whether data exists or not.
			conditionVO.setMQtaVerNo(newVersionNo);
			DBRowSet stepRS = dbDao.searchLoadValueSaqMonQtaOfc0048(conditionVO);

			String isZeroLoad = "FALSE";
			if (stepRS.next()) {
				isZeroLoad = "TRUE";
			}
			conditionVO.setIsZeroLoad(isZeroLoad);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Final - handling for save<br>
	 * 
	 * @param EsmSaq0048Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentFinal0048(EsmSaq0048Event event, SignOnUserAccount account) throws EventException {
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
					conditionVO.setUpdUsrId(account.getUsr_id());
					updateVoList.add(saqConVOs[i]);
				} else if (saqConVOs[i].getIbflag().equals("D")) {
					deleteVoList.add(saqConVOs[i]);
				}
			}
			
			// SAQ_MON_QTA_TRD update.
			if ( updateVoList.size() > 0 ) {
				if(dbDao.checkMonthlyAdjustmentTrade0048(conditionVO)==0) {
					dbDao.updateMonthlyAdjustmentTradeAll0048(conditionVO);
				}
				dbDao.updateMonthlyAdjustmentTrade0048(updateVoList, conditionVO);
				
			}

			// checking whether data exists or not.
			DBRowSet stepRS = dbDao.searchLoadValueSaqMonQtaOfc0048(conditionVO);

			String isZeroLoad = "FALSE";
			if (stepRS.next()) {
				isZeroLoad = "TRUE";
			}
			conditionVO.setIsZeroLoad(isZeroLoad);

			// retrieving key value. (MQTA_STEP_CD = '01')
			conditionVO.setMQtaStepCd("01");
			DBRowSet rowSet = dbDao.getPreviousCheckKey0048(conditionVO);

			if (rowSet.next()) {
				// retrieving field. [mqta_mdl_ver_no, sls_fcast_pub_no].
				conditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				conditionVO.setMqtaMdlVerNo(rowSet.getString("mqta_mdl_ver_no"));
				conditionVO.setSlsFcastPubNo(rowSet.getString("sls_fcast_pub_no"));
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
	 * Cancel Current Version event process<br>
	 * MonthlyQuotaAdjustmentTrade- event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelCurrentVersion0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			int cnt = 0;
			String stsCd = "XX";

			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			cnt = dbDao.checkCancelAllCurrentVersion(conditionVO);
			if (cnt < 2) {
				throw new EventException((new ErrorHandler("SAQ00036")).getMessage());
			}
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Cancel Current Version Final event process<br>
	 * MonthlyQuotaAdjustmentTrade- Final event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelCurrentVersion0048(QuotaConditionVO conditionVO) throws EventException {
		try {

			String tempMqtaVerNo = conditionVO.getMQtaVerNo();
			String stsCd = "XX";

			// STEP 03 XX
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("03");
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 02 XX
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("02");
			conditionVO.setMQtaVerNo("");
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 01 XX
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("01");
			conditionVO.setMQtaVerNo(tempMqtaVerNo);
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			/*
			 * // Summary create
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Confirm event process<br>
	 * MonthlyQuotaAdjustmentTrade - event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeConfirmDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "DC"; // 00 => DC
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());
			conditionVO.setStatusCd(stsCd);

			int statusDC = dbDao.getSaqStsCdCount(conditionVO);
			if (statusDC > 0) {
				throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
			}

			// Load - Check whether an integer
			String months = dbDao.getLoadRoundOffNeedMonth(conditionVO);
			if (months.length() > 0) {
				// SAQ00020 : There exist decimal in Load. Please Round Off before confirm.
				throw new EventException((new ErrorHandler("SAQ00020", new String[] { months })).getMessage());
			}

			// status change
			conditionVO.setSaq_sts_cd("00");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());

		}
	}

	/**
	 * Cancel Confirmation event process<br>
	 * MonthlyQuotaAdjustmentTrade - event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelConfirmation0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "00"; // DC => 00 NEW
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			// status change
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("DC");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Confirm Final event process<br>
	 * MonthlyQuotaAdjustmentTrade- Final event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalConfirmDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "FC";
			String tempMqtaStepCd = conditionVO.getMQtaStepCd();
			conditionVO.setUserId(account.getUsr_id());

			// Load - Check whether an integer
			conditionVO.setMQtaStepCd("03");
			String months = dbDao.getLoadRoundOffNeedMonth(conditionVO);
			if (months.length() > 0) {
				// SAQ00020 : There exist decimal in Load. Please Round Off before confirm.
				throw new EventException((new ErrorHandler("SAQ00020", new String[] { months })).getMessage());
			}

			// STEP 01 status (DR => FC)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMqtaStepCd);
			conditionVO.setSaq_sts_cd("DR");

			// log.debug("MQtaStepCd    >>>>>>>>>>>>>>>>>>>>>>>>"+conditionVO.getMQtaStepCd());
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 03 status (00 => FC)
			conditionVO.setMQtaStepCd("03");
			conditionVO.setSaq_sts_cd("00");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry("03",
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Cancel Confirmation Final event process<br>
	 * MonthlyQuotaAdjustmentTrade- Final event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelConfirmation0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "DR";
			conditionVO.setUserId(account.getUsr_id());

			// STEP 01 status (FC => DR)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 03 status (FC => 00)
			conditionVO.setStatusCd("00");
			conditionVO.setMQtaStepCd("03");
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry("03",
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Notify event process<br>
	 * MonthlyQuotaAdjustmentTrade - save event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeNotifyDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String tempMqtaStepCd = conditionVO.getMQtaStepCd();
			String stsCd = "DN"; // DC => DN
			conditionVO.setUserId(account.getUsr_id());

			DBRowSet rowSet = dbDao.getPreviousCheckKey0048(conditionVO);

			// saq_mon_qta_trd STEP 02
			dbDao.createMonthlyAdjustmentRhqInfo1(conditionVO);
			dbDao.createMonthlyAdjustmentRhqInfo2(conditionVO);

			// status change
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("DC");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Remark status 00 => DN
			conditionVO.setStatusCd(stsCd);
			dbDao.modifySaqMonQtaTrdRmkStatus(conditionVO);

			conditionVO.setMQtaStepCd("02");
			rowSet = dbDao.searchVersionList(conditionVO);

			conditionVO.setMQtaStepCd(tempMqtaStepCd);
			while (rowSet.next()) {//
				String newVersion = rowSet.getString("mqta_ver_no");
				String ctrtOfcCd = rowSet.getString("cre_ofc_cd");

				// create mode MIX
				conditionVO.setNewStepCd("02");
				conditionVO.setNewVersion(newVersion);
				conditionVO.setCtrt_rhq_cd(ctrtOfcCd);
				dbDao.createSaqMonQtaOfcModMix0048(conditionVO);
			}

			// Summary create
			/*
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Cancel Notification event process<br>
	 * MonthlyQuotaAdjustmentTrade - event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentTradeCancelNotification0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String tempVerNo = conditionVO.getMQtaVerNo();
			String tempSetpCd = conditionVO.getMQtaStepCd();
			conditionVO.setUserId(account.getUsr_id());

			// Check if can be changed to DC.
			DBRowSet dbRset = dbDao.getMonthlyQuotaRhqSetpStatus(conditionVO);
			if (dbRset.next()) {
				if (dbRset.getInt("stsOthers") > 0) {
					throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
				}
				if (dbRset.getInt("sts00") > 0) {
					// if exists '00' ==> 'XX'
					conditionVO.setStatusCd("XX");
					conditionVO.setMQtaStepCd("02");
					conditionVO.setMQtaVerNo("");
					conditionVO.setSaq_sts_cd("00");
					dbDao.modifySaqMonQtaStepVerStatus(conditionVO);
				}
			}

			// SAQ_MON_QTA_STEP_VER status change
			String stsCd = "DC"; // DN => DC
			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("DN");
			conditionVO.setMQtaStepCd(tempSetpCd);
			conditionVO.setMQtaVerNo(tempVerNo);
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry(conditionVO.getMQtaStepCd(),
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Notify Final event process<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalNotifyDraft0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String tempMqtaSetpCd = conditionVO.getMQtaStepCd();
			String tempMqtaVerNo = conditionVO.getMQtaVerNo();
			String stsCd = "FN"; // FC => FN (Notify Draft)

			// copy from mix contents of step03 to step02
			conditionVO.setSaq_sts_cd("DN");
			conditionVO.setMQtaStepCd("02");
			conditionVO.setCurrMqtaStepCd("03");
			conditionVO.setUserId(account.getUsr_id());
			dbDao.modifySaqMonQtaOfcModMix(conditionVO);

			// STEP 01 status, incl_port_flg change
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMqtaSetpCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVERinclPortFlg(conditionVO);

			// STEP 03 status, incl_port_flg (FC => FN)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("03");
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVERinclPortFlg(conditionVO);

			// STEP 02 status, incl_port_flg (DN => FR)
			conditionVO.setStatusCd("FR");
			conditionVO.setMQtaStepCd("02");
			conditionVO.setMQtaVerNo("");
			conditionVO.setSaq_sts_cd("DN");
			dbDao.modifySaqMonQtaStepVERinclPortFlg(conditionVO);

			// Remark status DN => FN
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMqtaSetpCd);
			conditionVO.setMQtaVerNo(tempMqtaVerNo);
			dbDao.modifySaqMonQtaTrdRmkStatus(conditionVO);

			// Summary create
			/*
			 * this.createQtaAdjSmry("03",
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Cancel Notification Final<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentFinalCancelNotification0048(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String tempMQtaSetpCd = conditionVO.getMQtaStepCd();
			String tempMQtaVerNo = conditionVO.getMQtaVerNo();
			String stsCd = "FC"; // FN => FC
			// "FC" to determine whether changes should be.
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("02");
			int statusFC = dbDao.getSaqStsCdCount(conditionVO);

			if (statusFC > 0) {
				// SAQ00017 : Is already in progress. You can not modify.
				throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
			}

			// STEP 01 status (FN => FC)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd(tempMQtaSetpCd);
			conditionVO.setSaq_sts_cd("FN");
			conditionVO.setUserId(account.getUsr_id());
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 03 status (FN => FC)
			conditionVO.setStatusCd(stsCd);
			conditionVO.setMQtaStepCd("03");
			conditionVO.setSaq_sts_cd("FN");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// STEP 02 status (FR => DN)
			conditionVO.setStatusCd("DN");
			conditionVO.setMQtaStepCd("02");
			conditionVO.setMQtaVerNo("");
			conditionVO.setSaq_sts_cd("FR");
			dbDao.modifySaqMonQtaStepVerStatus(conditionVO);

			// Summary create
			conditionVO.setMQtaVerNo(tempMQtaVerNo);
			/*
			 * this.createQtaAdjSmry("03",
			 * conditionVO.getYear(), conditionVO.getBse_quarter(), conditionVO.getTrade(),
			 * conditionVO.getBound(), conditionVO.getMQtaVerNo(), conditionVO.getUserId());
			 */

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Check the event handling prior to processing
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeLoadZero0048List(QuotaConditionVO conditionVO) throws EventException {

		String retMsg = "";

		try {
			// PDTO(Data Transfer Object including Parameters)
			retMsg = dbDao.getListByLoadZero(conditionVO);

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
	 * Check the event handling prior to processing<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAdjustmentTradeMonthLoadZero0048List(QuotaConditionVO conditionVO) throws EventException {

		String retMsg = "";

		try {
			// PDTO(Data Transfer Object including Parameters)
			retMsg = dbDao.getListByMonthLoadZero(conditionVO);

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
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeModify0147List(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentTradeModifyListVO> searchMonthlyQuotaAdjustmentTradeModifyListVOs = null;

		try {

			// PDTO(Data Transfer Object including Parameters)
			searchMonthlyQuotaAdjustmentTradeModifyListVOs = dbDao.searchMonthlyQuotaAdjustmentTradeModify0147List(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentTradeModifyListVOs);

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
	 * @param EsmSaq0147Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaAdjustmentTradeModify0147(EsmSaq0147Event event, SignOnUserAccount account) throws EventException {
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
				dbDao.updateModifySaqMonQtaTrd0147(updateVoList, conditionVO);
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
	 * calling SAQ_MON_QTA_ADJ_CRE_PRC() <br>
	 * 
	 * @param String mqtaStepCd
	 * @param String bseYr
	 * @param String bse_qtr_cd
	 * @param String trdCd
	 * @param String dirCd
	 * @param String mqtaVerNo
	 * @param String usrId
	 * @exception EventException
	 */
	public void createQtaAdjSmry(String mqtaStepCd, String bseYr, String bse_qtr_cd, String trdCd, String dirCd, String mqtaVerNo, String usrId) throws EventException {
		try {

			ScheduleUtil su = new ScheduleUtil();
			String msg = mqtaStepCd + "#" + bseYr + "#" + bse_qtr_cd + "#" + trdCd + "#" + dirCd + "#" + mqtaVerNo + "#" + usrId;

			// program no, server code, parameter
			String jobID = su.directExecuteJob("ESM_SAQ_B005", msg);
			log.debug(" jobID==> " + jobID);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * searchMonthlyQuotaAdjustmentTradeForExcel0176List <br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentTradeForExcel0176List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();

		try {

			// PDTO(Data Transfer Object including Parameters)
			listVO = dbDao.searchMonthlyQuotaAdjustmentTradeForExcel0176List(conditionVO);

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
	 * updateMonthlyQuotaAdjustmentTradeForExcel0176 <br>
	 * 
	 * @param EsmSaq0176Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyQuotaAdjustmentTradeForExcel0176(EsmSaq0176Event event, SignOnUserAccount account) throws EventException {
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
				dbDao.updateSaqMonQtaTrd0176(updateVoList, conditionVO);
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