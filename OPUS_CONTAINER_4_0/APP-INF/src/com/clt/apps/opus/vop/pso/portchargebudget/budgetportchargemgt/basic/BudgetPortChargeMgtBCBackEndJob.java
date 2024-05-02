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
import java.util.StringTokenizer;

import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.integration.BudgetPortChargeMgtDBDAO;
import com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo.InvSumByMonVO;
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
public class BudgetPortChargeMgtBCBackEndJob extends BackEndCommandSupport {
	
	private BudgetPortChargeMgtDBDAO dbDao;
	private InvSumByMonVO invSumByMonVO = null;
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
	public List<InvSumByMonVO> doStart() throws Exception {
		List<InvSumByMonVO> list = null;
        try{
	        dbDao = new BudgetPortChargeMgtDBDAO();
	
	        if ("RETRIEVE".equals(jobFlg)){
	        	list = this.searchSumRptByPeriodInvBackEndJob();
	        }
        }catch(Exception e){
        	super.log.error(e.getMessage());
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Port Charge Invoice Summary Back End Job", ""}).getMessage(), e);
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
	 * Retrieve Invoice Summary
	 * @return List<InvSumByMonVO>
	 * @throws Exception
	 */
	private List<InvSumByMonVO> searchSumRptByPeriodInvBackEndJob() throws Exception {
		log.debug("\nsearchSumRptByPeriodInvBackEndJob START===========================.");
		List<InvSumByMonVO> list = null;
        try {
        	StringTokenizer token = new StringTokenizer(invSumByMonVO.getTermCode());
			int tcount = 0;
			int count = 0;

			while( token.hasMoreElements()){
				token.nextToken(",");
				tcount++;
			}
			
			token = new StringTokenizer(invSumByMonVO.getTermCode());
			StringBuffer buf = new StringBuffer();
			
			if( tcount == 1) {
				buf.append( invSumByMonVO.getPortCd()).append( invSumByMonVO.getTermCode());
			} else {
				count = 1;
				while( token.hasMoreElements()){
					if( count == 1 )
						buf.append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					else if( count == tcount )
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(","));
					else
						buf.append("\'").append( invSumByMonVO.getPortCd()).append(token.nextToken(",")).append("\'").append(",");
					count++;
				}
			}
			String tmpTermCode = buf.toString();
			log.debug("\nsearchSumRptByPeriodInvBackEndJob TermCode["+tmpTermCode+"].");
			
			invSumByMonVO.setTermCode(tmpTermCode);
			invSumByMonVO.setCreUsrId(signOnUserAccount.getUsr_id());
			invSumByMonVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			
			list =  dbDao.searchSumRptByPeriodInv(invSumByMonVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Port Charge Invoice Summary BackEndJob", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PSO90010", new String[]{"Port Charge Invoice Summary BackEndJob", "Retrieve"}).getMessage(), ex);
        }
		
        log.debug("\nsearchSumRptByPeriodInvBackEndJob E N D===========================.");
		return list;
	}

	/**
	 * InvSumByMonVO setting
	 * @param InvSumByMonVO invSumByMonVO
	 */
	public void setInvSumByMonVO(InvSumByMonVO invSumByMonVO) {
		this.invSumByMonVO = invSumByMonVO;
	}

	/**
	 * SignOnUserAccount setting
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setSignOnUserAccount(SignOnUserAccount signOnUserAccount) {
		this.signOnUserAccount = signOnUserAccount;
	}
}
