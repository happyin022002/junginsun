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
package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration.BudgetPortChargeMgtDBDAO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpDtlVO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.ErpSumVO;
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
public class BudgetPortChargeMgtBCErpExcelBackEndJob extends BackEndCommandSupport {
	
	private BudgetPortChargeMgtDBDAO dbDao;
	private ErpSumVO erpSumVO = null;
	private SignOnUserAccount signOnUserAccount = null;
	private String jobFlg = null;	

	/**
	 * serialVersionUID 
	 */
	private static final long serialVersionUID = -4432166936180768897L;

	/**
	 * Main Start
	 * @return List<InvSumByMonVO>
	 * @throws Exception
	 */
	public List<ErpDtlVO> doStart() throws Exception {
		List<ErpDtlVO> list = null;
        try{
	        dbDao = new BudgetPortChargeMgtDBDAO();
	
	        if("ERP_DETAIL_EXCEL".equals(jobFlg)){
	        	log.debug("\n doStart jobFlg ["+jobFlg+"] usr_id ["+signOnUserAccount.getUsr_id()+"]");
	        	list = this.searchErpDtlExcelDataBackEndJob();
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel Back End Job", ""}).getMessage(), e);
        }
        
        return list;
	}

	/**
	 * JOB FLAG setting
	 * @param String jobFlg
	 */
	public void setJobFlg(String jobFlg){
		this.jobFlg = jobFlg;
	}
	

	/**
	 * Detail Down Excel BackEndJob
	 * @return List<ErpDtlVO>
	 * @throws Exception
	 */
	private List<ErpDtlVO> searchErpDtlExcelDataBackEndJob() throws Exception {
		log.debug("\nsearchErpDtlExcelDataBackEndJob START===========================.");
		List<ErpDtlVO> list = null;
        try {
        	list =  dbDao.searchErpDtlExcelData(erpSumVO);
        } catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel BackEndJob", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Monthly Estimation Creation Detail Down Excel BackEndJob", "Retrieve"}).getMessage(), ex);
        }
		
        log.debug("\nsearchErpDtlExcelDataBackEndJob E N D===========================.");
		return list;
	}

	/**
	 * ErpSumVO setting
	 * @param ErpSumVO invSumByMonVO
	 */
	public void setErpSumVO(ErpSumVO erpSumVO) {
		this.erpSumVO = erpSumVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
	
}
