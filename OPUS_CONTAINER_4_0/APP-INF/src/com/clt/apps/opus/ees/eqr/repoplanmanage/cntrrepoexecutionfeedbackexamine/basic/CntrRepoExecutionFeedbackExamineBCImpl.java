/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineBCImpl.java
*@FileTitle : Execute Plan
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.integration.CntrRepoExecutionFeedbackExamineDBDAO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * -RepoExecutionFeedbackExamine Business Logic Command Interface<br>
 *
 * @author 
 * @see EventException
 * @since J2EE 1.6
 */
public class CntrRepoExecutionFeedbackExamineBCImpl extends BasicCommandSupport implements CntrRepoExecutionFeedbackExamineBC {

	// Database Access Object
	private transient CntrRepoExecutionFeedbackExamineDBDAO dbDao = null;

	/**
	 * creating CntrRepoExecutionFeedbackExamineBCImpl<br>
	 * creating CntrRepoExecutionFeedbackExamineDBDAO<br>
	 */
	public CntrRepoExecutionFeedbackExamineBCImpl() {
		dbDao = new CntrRepoExecutionFeedbackExamineDBDAO();
	}
	
	/**
	 * retrieving for repo execution and Feedback(sheet1)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedback(EesEqr0063ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionFeedback(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retrieving for repo execution and Feedback (Sheet2)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrRepoExecutionFeedbcakExamine(EesEqr0063ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchCntrRepoExecutionFeedbcakExamine(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}