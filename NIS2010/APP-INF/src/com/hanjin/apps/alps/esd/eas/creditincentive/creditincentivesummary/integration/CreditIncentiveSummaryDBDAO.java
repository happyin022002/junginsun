/*============================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : CreditIncentiveSummaryDBDAO.java
 *@FileTitle : 
 *@LastModifyDate : 2016.04.26.
 *@LastModifier : 
 *@LastVersion : 
 * 2016.04.26. SHIN DONG IL
 *============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.integration;


import java.sql.SQLException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.event.EsdEas0502Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrIssueVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrRhqVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivesummary.vo.CreditSmmrSrcVO;

/**
 * Credit & Incentive Summary 에 대한 DB 처리를 담당<br>
 * 
 * @author SHIN DONG IL
 * @see CreditIncentiveSummaryBCImpl 참조
 * @since J2EE 1.6
 */
public class CreditIncentiveSummaryDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = -1132976440312128013L;

	/**
	 * Credti & Invcentive Summary by RHQ를 조회한다. <br>
	 * 
	 * @param event
	 * @return List<CreditSmmrRhqVO>
	 * @exception EventException
	 */
	public List<CreditSmmrRhqVO> searchCreditByRhqList(EsdEas0502Event event)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<CreditSmmrRhqVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bse_yr", event.getBseYr());
			param.put("rhq_ofc_cd", event.getRhqCd());
			param.put("cr_src_cd", event.getCrSrcCd());
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveSummaryDBDAOSearchCreditByRhqListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CreditSmmrRhqVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Credti & Invcentive Summary by Source를 조회한다. <br>
	 * 
	 * @param event
	 * @return List<CreditSmmrSrcVO>
	 * @exception EventException
	 */
	public List<CreditSmmrSrcVO> searchCreditBySourceList(EsdEas0502Event event)
			throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		List<CreditSmmrSrcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bse_yr", event.getBseYr());
			param.put("rhq_ofc_cd", event.getRhqCd());
			param.put("cr_src_cd", event.getCrSrcCd());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveSummaryDBDAOSearchCreditBySourceListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CreditSmmrSrcVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Credti & Invcentive Summary Issue를 조회한다. <br>
	 * 
	 * @param event
	 * @return List<CreditSmmrIssueVO>
	 * @exception EventException
	 */
	public List<CreditSmmrIssueVO> searchCreditIssuetList(EsdEas0502Event event) throws DAOException {
		DBRowSet dbRowset = new DBRowSet();
		List<CreditSmmrIssueVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("iss_fm_dt",event.getFmDt());
			param.put("iss_to_dt",event.getToDt());
			param.put("cr_src_cd", event.getCrSrcCd());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveSummaryDBDAOSearchCreditIssueListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CreditSmmrIssueVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}