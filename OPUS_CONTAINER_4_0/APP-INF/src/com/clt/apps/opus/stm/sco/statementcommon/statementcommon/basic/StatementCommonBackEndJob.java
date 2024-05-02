/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationBackEndJob.java
*@FileTitle : Joint Operation Agreement Creation BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic;

import java.util.List;

import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.integration.StatementCommonDBDAO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.AccrualVerificationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-JointOperationAccrualCreation Long Transaction Business Logic <br>
 *
 * @author
 * @see fns_joo_0029EventResponse
 * @since J2EE 1.6
 */
public class StatementCommonBackEndJob extends BackEndCommandSupport {
	
	private StatementCommonDBDAO dbDao;
	private AccrualVerificationVO accrualVerificationVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;	

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768897L;

	/**
	 * Main Start
	 * @return List<EstmActRsltVO>
	 * @throws Exception
	 */
	public Object doStart() throws Exception {
		Object obj = null;
        try{
	        dbDao = new StatementCommonDBDAO();
	
	        if ("TES".equals(jobFlg)){
	        	obj = this.searchMonthlyTesAccrualVerificationList();
	        }else if ("TRS".equals(jobFlg)){
	        	obj = this.searchMonthlyTrsAccrualVerificationList();
	        }else if ("COST".equals(jobFlg)){
	        	obj = this.searchMonthlyCostAccrualVerificationList();
	        }else if ("TES_SUM".equals(jobFlg)){
	        	obj = this.searchMonthlyTesAccrualVerificationSummaryList();
	        }else if ("TRS_SUM".equals(jobFlg)){
	        	obj = this.searchMonthlyTrsAccrualVerificationSummaryList();
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
        	throw new EventException(new ErrorHandler(e).getMessage(), e);
        }
        
        return obj;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}

	/**
	 * Monthly TES Accrual Verification 조회.
	 * 2016.12.21 Add.
	 * 
	 * @param AccrualVerificationVO accrualVerificationVO
	 * @return List<AccrualVerificationVO>
	 * @throws Exception
	 */
	private List<AccrualVerificationVO> searchMonthlyTesAccrualVerificationList() throws Exception {

        List<AccrualVerificationVO> list = null;
        try {
        	
        	list = dbDao.searchMonthlyTesAccrualVerificationList(accrualVerificationVO);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
		
		return list;
	}

	/**
	 * Monthly TRS Accrual Verification 조회.
	 * 2016.12.21 Add.
	 * 
	 * @param AccrualVerificationVO accrualVerificationVO
	 * @return List<AccrualVerificationVO>
	 * @throws Exception
	 */
	private List<AccrualVerificationVO> searchMonthlyTrsAccrualVerificationList() throws Exception {

        List<AccrualVerificationVO> list = null;
        try {
        	
        	list = dbDao.searchMonthlyTrsAccrualVerificationList(accrualVerificationVO);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
		
		return list;
	}

	/**
	 * Monthly Cost Accrual Verification 조회.
	 * 2016.12.21 Add.
	 * 
	 * @param AccrualVerificationVO accrualVerificationVO
	 * @return List<AccrualVerificationVO>
	 * @throws Exception
	 */
	private List<AccrualVerificationVO> searchMonthlyCostAccrualVerificationList() throws Exception {

        List<AccrualVerificationVO> list = null;
        try {
        	
        	list = dbDao.searchMonthlyCostAccrualVerificationList(accrualVerificationVO);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
		
		return list;
	}

	/**
	 * Monthly TES Accrual Verification Summary 조회.
	 * 2016.12.21 Add.
	 * 
	 * @param AccrualVerificationVO accrualVerificationVO
	 * @return List<AccrualVerificationVO>
	 * @throws Exception
	 */
	private List<AccrualVerificationVO> searchMonthlyTesAccrualVerificationSummaryList() throws Exception {

        List<AccrualVerificationVO> list = null;
        try {
        	
        	list = dbDao.searchMonthlyTesAccrualVerificationSummaryList(accrualVerificationVO);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
		
		return list;
	}

	/**
	 * Monthly TRS Accrual Verification Summary 조회.
	 * 2016.12.21 Add.
	 * 
	 * @param AccrualVerificationVO accrualVerificationVO
	 * @return List<AccrualVerificationVO>
	 * @throws Exception
	 */
	private List<AccrualVerificationVO> searchMonthlyTrsAccrualVerificationSummaryList() throws Exception {

        List<AccrualVerificationVO> list = null;
        try {
        	
        	list = dbDao.searchMonthlyTrsAccrualVerificationSummaryList(accrualVerificationVO);
        	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
		
		return list;
	}
	

	/**
	 * @return the accrualVerificationVO
	 */
	public AccrualVerificationVO getAccrualVerificationVO() {
		return accrualVerificationVO;
	}

	/**
	 * @param accrualVerificationVO the accrualVerificationVO to set
	 */
	public void setAccrualVerificationVO(AccrualVerificationVO accrualVerificationVO) {
		this.accrualVerificationVO = accrualVerificationVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
}
