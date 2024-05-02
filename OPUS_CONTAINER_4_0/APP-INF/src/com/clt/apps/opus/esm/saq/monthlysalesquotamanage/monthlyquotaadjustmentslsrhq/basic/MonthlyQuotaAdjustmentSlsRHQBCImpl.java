/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaAdjustmentSlsRHQBCImpl.java
 *@FileTitle : Load Target - Regional Group
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0156Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.event.EsmSaq0158Event;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.integration.MonthlyQuotaAdjustmentSlsRHQDBDAO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo.SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmenttraderhq.integration.MonthlyQuotaAdjustmentTradeRHQDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SaqMonQtaLodTgtVO;

/**
 * MonthlySalesQuotaManage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0156EventResponse, MonthlyQuotaAdjustmentSlsRHQBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaAdjustmentSlsRHQBCImpl extends BasicCommandSupport implements MonthlyQuotaAdjustmentSlsRHQBC {

	private transient MonthlyQuotaAdjustmentSlsRHQDBDAO dbDao = null;
	private transient MonthlyQuotaAdjustmentTradeRHQDBDAO rhqDao = null;

	public MonthlyQuotaAdjustmentSlsRHQBCImpl() {
		dbDao = new MonthlyQuotaAdjustmentSlsRHQDBDAO();
		rhqDao = new MonthlyQuotaAdjustmentTradeRHQDBDAO();
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRhq0156List01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		String mqtaMdlVerNo = "";
		String slsFcastPubNo = "";
		String inclPortFlag = "";
		String n1stRlaneCd = "";

		try {

			DBRowSet rowSet = dbDao.getPreviousCheckKey0156(conditionVO);
			if (rowSet.next()) {
				mqtaMdlVerNo = rowSet.getString("mqta_mdl_ver_no");
				slsFcastPubNo = rowSet.getString("sls_fcast_pub_no");
				inclPortFlag = rowSet.getString("incl_port_flg");

				conditionVO.setInclPortFlag(inclPortFlag);
				conditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				conditionVO.setQtaMstVerNo(rowSet.getString("qta_mst_ver_no"));
				conditionVO.setTradeGroupCd(rowSet.getString("saq_tgt_grp_cd"));

			}

			if (conditionVO.equals("MODIFY02")) {
				n1stRlaneCd = dbDao.getN1stRlaneCd0156(conditionVO);
				conditionVO.setRlaneCd(n1stRlaneCd);
			}

			conditionVO.setMqtaMdlVerNo(mqtaMdlVerNo);
			conditionVO.setSlsFcastPubNo(slsFcastPubNo);
			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyQuotaAdjustmentSlsRhq0156List01(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyAdjustmentSlsRHQTabTargetGroup0156Tab01(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyAdjustmentSlsRHQTabTrade0156Tab02(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	public ReturnVO searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyAdjustmentSlsRHQTabTrade0156Tab03(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO> searchMonthlyQuotaAdjustmentSlsRhqListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqListVOs = dbDao.searchMonthlyQuotaAdjustmentSlsRHQRMK0156List01(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqListVOs);

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
	 * @param EsmSaq0156Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void updateMonthlyAdjustmentSlsRhq0156(EsmSaq0156Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaLodTgtVO[] saqConVOs = event.getSaqMonQtaLodTgtVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaLodTgtVO> insertVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> updateVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> deleteVoList = new ArrayList<SaqMonQtaLodTgtVO>();

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
				dbDao.updateMonthlyAdjustmentSlsRhq0156(updateVoList, conditionVO);
			}

			DBRowSet rowSet = dbDao.getPreviousCheckKey0156(conditionVO);
			if (rowSet.next()) {
				conditionVO.setSaq_sts_cd(rowSet.getString("saq_sts_cd"));
				conditionVO.setQtaMstVerNo(rowSet.getString("qta_mst_ver_no"));
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
	 * @param EsmSaq0156Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createMonthlyAdjustmentSlsRhqInfo0156(EsmSaq0156Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaLodTgtVO[] saqConVOs = event.getSaqMonQtaLodTgtVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaLodTgtVO> insertVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> updateVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> deleteVoList = new ArrayList<SaqMonQtaLodTgtVO>();

			conditionVO.setUserId(account.getUsr_id());
			String newVersionNo = "";
			String inclPortFlg_db = "";

			newVersionNo = dbDao.getNewMonthlyQuotaStepVersionNumber0156(conditionVO);
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

			DBRowSet rowSet = dbDao.getPreviousCheckKey0156(conditionVO);
			if (rowSet.next()) {
				inclPortFlg_db = rowSet.getString("incl_port_flg");
			}

			conditionVO.setNewVersion(newVersionNo);
			conditionVO.setUserId(account.getUsr_id());

			dbDao.createMonthlyAdjustmentSlsRhqInfoA0156(conditionVO);
			if (conditionVO.getInclPortFlag().equals(inclPortFlg_db)) {
				dbDao.createMonthlyAdjustmentSlsRhqInfoB0156(conditionVO);
			} else if (inclPortFlg_db.equals("N") && conditionVO.getInclPortFlag().equals("Y")) {
				dbDao.createMonthlyAdjustmentSlsRhqInfoC0156(conditionVO);
			} else if (inclPortFlg_db.equals("Y") && conditionVO.getInclPortFlag().equals("N")) {
				dbDao.createMonthlyAdjustmentSlsRhqInfoD0156(conditionVO);
			}

			if (conditionVO.getInclPortFlag().equals(inclPortFlg_db)) {
				if (updateVoList.size() > 0) {
					dbDao.updateMonthlyAdjustmentSlsRhq0156(updateVoList, conditionVO);
				}
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
	 * Cancel Current Version 이벤트 처리<br>
	 * MonthlyQuotaAdjustmentSlsRhq화면에 대한 이벤트 처리<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqCancelCurrentVersion0156(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			int cnt = 0;
			String stsCd = "XX";

			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			cnt = dbDao.checkCancelAllCurrentVersion0156(conditionVO);
			if (cnt < 2) {
				throw new EventException((new ErrorHandler("SAQ00036")).getMessage());
			}

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("");
			dbDao.modifySaqMonQtaStepVerStatus0156(conditionVO);

			// Summary careate
			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			rhqDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Confirm 이벤트 처리<br>
	 * MonthlyQuotaAdjustmentSlsRhq화면에 대한 이벤트 처리<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String procAdjustmentSlsRhqConfirmDraft0156(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		String rtn = "";
		try {

			String stsCd = "FC"; // 00 => FC
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());
			conditionVO.setStatusCd(stsCd);

			int statusDC = dbDao.getSaqStsCdCount0156(conditionVO);
			if (statusDC > 0) {
				return (new ErrorHandler("SAQ00017")).getUserMessage();
			}

			String months = dbDao.getLoadRoundOffNeedMonth0156(conditionVO);
			if (months.length() > 0) {
				return (new ErrorHandler("SAQ00020", new String[] { months.toString() })).getUserMessage();
			}

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("00");
			dbDao.modifySaqMonQtaStepVerStatus0156(conditionVO);

			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			rhqDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * MonthlyQuotaAdjustmentSlsRhq화면에 대한 이벤트 처리<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void procAdjustmentSlsRhqCancelConfirmation0156(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "00"; // FC => 00
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus0156(conditionVO);

			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			rhqDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	public void procAdjustmentSlsRhqNotifyDraft0156(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			boolean isTrue = false;

			String stsCd = "FN"; // FC => FN
			conditionVO.setUserId(account.getUsr_id());
			conditionVO.setOfc_Cd(account.getOfc_cd());

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FC");
			dbDao.modifySaqMonQtaStepVerStatus0156(conditionVO);

			dbDao.modifySaqMonQtaLodTgtRmkStatus0156(conditionVO);

			isTrue = dbDao.isGuidlineAllMqtaVerNoFNFC0156(conditionVO);
			if (isTrue) {
				stsCd = "QN"; // FC/FN => QN
				dbDao.modifyAllStepStatusQN0156(conditionVO);
				dbDao.modifySaqMonQtaGlineVerStatus0156(conditionVO);
			}
			conditionVO.setStatusCd(stsCd);

			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			rhqDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	public void procAdjustmentSlsRhqCancelNotification0156(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {

			String stsCd = "FC"; // FN => FC
			conditionVO.setUserId(account.getUsr_id());

			DBRowSet dbRset = dbDao.getMonthlyQuotaSlsRgnStepStatus0156(conditionVO);
			if (dbRset.next()) {
				if (dbRset.getInt("stsOthers") > 0) {
					throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
				}
				if (dbRset.getInt("sts00") > 0) {
					conditionVO.setStatusCd("XX");
					conditionVO.setSaq_sts_cd("00");
					dbDao.modifySlsRgnSaqMonQtaStePVerStatus0156(conditionVO);

				}
			}

			conditionVO.setStatusCd(stsCd);
			conditionVO.setSaq_sts_cd("FN");
			dbDao.modifySaqMonQtaStepVerStatus0156(conditionVO);

			conditionVO.setBse_quarter(conditionVO.getBse_qtr_cd());
			rhqDao.createMonthlyAdjustmentSummaryInfo(conditionVO);

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
	public String searchAdjustmentSlsRhqLoadZero0156List(QuotaConditionVO conditionVO) throws EventException {

		String retMsg = "";

		try {
			retMsg = dbDao.searchAdjustmentSlsRhqLoadZero0156List(conditionVO);

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
	public ReturnVO searchMonthlyQuotaAdjustmentSlsRhqModify0158List(QuotaConditionVO conditionVO) throws EventException {

		ReturnVO listVO = new ReturnVO();
		List<SearchMonthlyQuotaAdjustmentSlsRhqModifyListVO> searchMonthlyQuotaAdjustmentSlsRhqModifyListVOs = null;

		try {

			searchMonthlyQuotaAdjustmentSlsRhqModifyListVOs = dbDao.searchMonthlyQuotaAdjustmentSlsRhqModify0158List(conditionVO);
			listVO.addList(searchMonthlyQuotaAdjustmentSlsRhqModifyListVOs);
			listVO.addList(conditionVO);

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
	 * @param EsmSaq0158Event event
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiMonthlyQuotaAdjustmentSlsRhqModify0158(EsmSaq0158Event event, SignOnUserAccount account) throws EventException {
		try {

			SaqMonQtaLodTgtVO[] saqConVOs = event.getSaqMonQtaLodTgtVOs();
			QuotaConditionVO conditionVO = event.getQuotaConditionVO();

			List<SaqMonQtaLodTgtVO> insertVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> updateVoList = new ArrayList<SaqMonQtaLodTgtVO>();
			List<SaqMonQtaLodTgtVO> deleteVoList = new ArrayList<SaqMonQtaLodTgtVO>();

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
				dbDao.multiMonthlyQuotaAdjustmentSlsRhqModify0158(updateVoList, conditionVO);
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