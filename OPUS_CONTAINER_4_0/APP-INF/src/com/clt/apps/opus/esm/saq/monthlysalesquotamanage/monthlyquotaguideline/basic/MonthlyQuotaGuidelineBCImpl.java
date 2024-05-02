/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaGuidelineBCImpl.java
 *@FileTitle : Master Version Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaguideline.integration.MonthlyQuotaGuidelineDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * MonthlySalesQuotaManage Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see ESM_SAQ_0076EventResponse,MonthlyQuotaGuidelineBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaGuidelineBCImpl extends BasicCommandSupport implements MonthlyQuotaGuidelineBC {

	// Database Access Object
	private transient MonthlyQuotaGuidelineDBDAO dbDao = null;

	/**
	 * MonthlyQuotaGuidelineBCImpl 객체 생성<br>
	 * MonthlyQuotaGuidelineDBDAO를 생성한다.<br>
	 */
	public MonthlyQuotaGuidelineBCImpl() {
		dbDao = new MonthlyQuotaGuidelineDBDAO();
	}

	/**
	 * [Tab 1 (Trade Tab)]을 [조회] 합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyGuidelineTargetGroup0076Tab01(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO returnVO = new ReturnVO();
		List<QuotaConditionVO> etcVOList = null;
		List<QuotaConditionVO> etcVOList2 = null;
		QuotaConditionVO etcVO = null;
		String mqtaMdlVerNo = "";
		String slsFcastPubNo = "";

		try {
			// 1. key 조회
			etcVOList = (List<QuotaConditionVO>) dbDao.getPreviousCheckKey0076(conditionVO).getList(0);
			if (etcVOList.size() != 0) {
				etcVO = etcVOList.get(0);
				mqtaMdlVerNo = etcVO.getMqtaMdlVerNo();
				slsFcastPubNo = etcVO.getSlsFcastPubNo();
			}

			// 2. Tab 1(Trade Tab) 조회
			ReturnVO resultVOList = dbDao.searchMonthlyGuidelineTargetGroup0076Tab01(conditionVO, mqtaMdlVerNo, slsFcastPubNo);

			// 3. Notify시 Popup데이터 선조회
			etcVOList2 = (List<QuotaConditionVO>) dbDao.searchTradeBoundList0076(conditionVO).getList(0);

			// 4. ReturnVO 셋팅
			returnVO.addList(resultVOList.getList(0));
			returnVO.setConditionVO(etcVOList.get(0));
			returnVO.addList(etcVOList2);

			return returnVO;
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
	@SuppressWarnings("unchecked")
	public ReturnVO searchMonthlyGuidelineSubTrade0076Tab02(QuotaConditionVO conditionVO) throws EventException {
		ReturnVO returnVO = new ReturnVO();
		List<QuotaConditionVO> etcVOList = null;
		List<QuotaConditionVO> etcVOList2 = null;
		QuotaConditionVO etcVO = null;

		String mqtaMdlVerNo = "";
		String slsFcastPubNo = "";

		try {
			etcVOList = (List<QuotaConditionVO>) dbDao.getPreviousCheckKey0076(conditionVO).getList(0);
			if (etcVOList.size() != 0) {
				etcVO = etcVOList.get(0);
				mqtaMdlVerNo = etcVO.getMqtaMdlVerNo();
				slsFcastPubNo = etcVO.getSlsFcastPubNo();
			}

			ReturnVO resultVO = dbDao.searchMonthlyGuidelineSubTrade0076Tab02(conditionVO, mqtaMdlVerNo, slsFcastPubNo);

			etcVOList2 = (List<QuotaConditionVO>) dbDao.searchTradeBoundList0076(conditionVO).getList(0);

			returnVO.addList(resultVO.getList(0));
			returnVO.setConditionVO(etcVOList.get(0));
			returnVO.addList(etcVOList2);

			return returnVO;
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
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelCurrentVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());
			DBRowSet chkRs = dbDao.getMonthlyQuotaSetpVersionStatus0076(conditionVO).getDbRowset();
			if (chkRs.next()) {
				if (chkRs.getInt("stsOthers") > 0 || chkRs.getInt("sts00") > 0) {
					throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
				}
			}

			String stsCd = "XX";
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			conditionVO.setSaqStsCd(stsCd);
			return conditionVO;
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
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineConfirmDraft0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			String stsCd = "FC"; // 00 => FC
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			conditionVO.setSaqStsCd(stsCd);
			return conditionVO;
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
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelConfirmation0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			String stsCd = "00"; // FC => 00
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			conditionVO.setSaqStsCd(stsCd);
			return conditionVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [Notify]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineNotifyDraft0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			dbDao.insertMonthlyGuidelineVVDInfo0076(conditionVO);

			dbDao.insertMonthlyQuotaPortSeqInfo0076(conditionVO);

			dbDao.createMonthlyQuotaStepVersionInfo0076(conditionVO);
			dbDao.createMonthlyQuotaTradeInfo0076(conditionVO);

			DBRowSet chkRs = dbDao.getMonthlyQuotaStepVersionNumber0076(conditionVO).getDbRowset();
			while (chkRs.next()) {
				String mqtaVerNo = chkRs.getString("mqta_ver_no");
				conditionVO.setTrade(chkRs.getString("trd_cd"));
				conditionVO.setDirCd(chkRs.getString("dir_cd"));
				dbDao.procAdjustmentLoadRoundOff0076(conditionVO, mqtaVerNo);
			}

			String stsCd = "FN"; // FC => FN (Notify Draft)
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			dbDao.createSaqMonQtaOfcModMix0076(conditionVO);

			conditionVO.setSaqStsCd(stsCd);

			return conditionVO;
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
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelNotification0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			DBRowSet chkRs = dbDao.getMonthlyQuotaSetpVersionStatus0076(conditionVO).getDbRowset();
			if (chkRs.next()) {
				if (chkRs.getInt("stsOthers") > 0) {
					throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
				}
				if (chkRs.getInt("sts00") > 0) {
					dbDao.modifySaqMonQtaStepVerStatus0076(conditionVO, "XX", "01", "00");
				}
			}

			dbDao.removeMonthlyGuidelineVVDInfo0076(conditionVO);

			dbDao.removeMonthlQuotaPortSeqInfo0076(conditionVO);

			String stsCd = "FC"; // FN => FC
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			conditionVO.setSaqStsCd(stsCd);

			return conditionVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [Confirm As Final Version]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineConfirmAsFinalVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			DBRowSet chkRs = dbDao.getMonthlyQuotaGuidelineVersionQF0076(conditionVO).getDbRowset();

			if (chkRs.next()) {
				if (chkRs.getInt("qfCnt") > 0) {
					throw new EventException((new ErrorHandler("SAQ00017")).getMessage());
				}
			}

			String stsCd = "QF"; // QN => QF
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			dbDao.modifySaqMonQtaStepVerStatus0076(conditionVO, "QF", "", "QN");

			conditionVO.setSaqStsCd(stsCd);

			return conditionVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [비즈니스대상]을 [Cancel Final Version]합니다.<br>
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return QuotaConditionVO
	 * @exception EventException
	 */
	public QuotaConditionVO procGlineCancelFinalVersion0076(QuotaConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			conditionVO.setUserId(account.getUsr_id());

			String stsCd = "QN"; // QF => QN
			dbDao.modifySaqMonQtaGlineVerStatus0076(conditionVO, stsCd);

			dbDao.modifySaqMonQtaStepVerStatus0076(conditionVO, "QN", "", "QF");

			conditionVO.setSaqStsCd(stsCd);

			return conditionVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}