/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaReleaseBCImpl.java
 *@FileTitle : Confirmation and Distribution
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotarelease.integration.MonthlyQuotaReleaseDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.SaqMonQtaRlseTrdVO;
import com.clt.syscommon.common.table.SaqMonQtaRlseVO;
import com.clt.syscommon.common.util.ScheduleUtil;

/**
 * MonthlySalesQuotaManage Business Logic Command Interface<br>
 * 
 * @author
 * @see Esm_saq_0052EventResponse, MonthlyQuotaRBCCreationBC
 * @since J2EE 1.6
 */
public class MonthlyQuotaReleaseBCImpl extends BasicCommandSupport implements MonthlyQuotaReleaseBC {

	// Database Access Object
	private transient MonthlyQuotaReleaseDBDAO dbDao = null;

	public MonthlyQuotaReleaseBCImpl() {
		dbDao = new MonthlyQuotaReleaseDBDAO();
	}
   
	/**
	 * doEnd
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param String ofcCd
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaRelease0052List01(QuotaConditionVO conditionVO, String ofcCd) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaRelease0052List01(conditionVO, ofcCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @param String is_new_version
	 * @param String mqta_rlse_ver_no
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaRelease0052ListSub01(QuotaConditionVO conditionVO, String is_new_version, String mqta_rlse_ver_no) throws EventException {
		try {
			return dbDao.searchMonthlyQuotaRelease0052ListSub01(conditionVO, is_new_version, mqta_rlse_ver_no);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param QuotaConditionVO conditionVO
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO appendMonthlyQuotaRelease0052(QuotaConditionVO conditionVO) throws EventException {
		try {
			return dbDao.getNewVersionNo0052(conditionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param String mqta_rlse_ver_no
	 * @param String year
	 * @param String quarter
	 * @param String is_new_version
	 * @param SaqMonQtaRlseVO saqMonQtaRlseVO
	 * @param SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs
	 * @param String user_id
	 * @exception EventException
	 */
	public void distributeMonthlyQuota0052(String mqta_rlse_ver_no, String year, String quarter, String is_new_version, SaqMonQtaRlseVO saqMonQtaRlseVO,
			SaqMonQtaRlseTrdVO[] saqMonQtaRlseTrdVOs, String user_id) throws EventException {
		try {
			// addSAQ_MON_QTA_RLSE
			dbDao.updateSaqMonQtaRlse0052(year, quarter);

			saqMonQtaRlseVO.setBseYr(year);
			saqMonQtaRlseVO.setBseQtrCd(quarter);
			saqMonQtaRlseVO.setCreUsrId(user_id);
			saqMonQtaRlseVO.setUpdUsrId(user_id);

			dbDao.addSaqMonQtaRlse0052(saqMonQtaRlseVO);

			// multiSAQ_MON_QTA_RLSE_TRD
			List<SaqMonQtaRlseTrdVO> insertSaqMonQtaRlseTrdVOList = new ArrayList<SaqMonQtaRlseTrdVO>();

			for (int i = 0; i < saqMonQtaRlseTrdVOs.length; i++) {
				if (saqMonQtaRlseTrdVOs[i].getIbflag().equals("I")) {
					saqMonQtaRlseTrdVOs[i].setCreUsrId(user_id);
					saqMonQtaRlseTrdVOs[i].setUpdUsrId(user_id);
					insertSaqMonQtaRlseTrdVOList.add(saqMonQtaRlseTrdVOs[i]);
				}
			}

			if (insertSaqMonQtaRlseTrdVOList.size() > 0) {
				dbDao.addSaqMonQtaRlseTrd0052S(insertSaqMonQtaRlseTrdVOList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

	}

	/**
	 * 
	 * @param String year
	 * @param String quarter
	 * @param String mqta_rlse_ver_no
	 * @param String user_id
	 * @exception EventException
	 */
	public void transferSaqMonQtaCrePrc(String year, String quarter, String mqta_rlse_ver_no, String user_id) throws EventException {
		try {
			// String msg = "year:"+year+"|quarter:"+quarter+"|mqta_rlse_ver_no:"+mqta_rlse_ver_no+"|user_id:"+user_id;
			// eaiDao.transferMonthlyDistribute(msg); 

			ScheduleUtil su = new ScheduleUtil();
			String msg = year + "#" + quarter + "#" + mqta_rlse_ver_no + "#" + user_id;
			
			log.debug(":::::::::transferSaqMonQtaCrePrc msg::::::::"+msg);

			String jobID = su.directExecuteJob("ESM_SAQ_B002", msg);
			log.debug(" jobID==> " + jobID);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

}