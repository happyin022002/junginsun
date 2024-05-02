/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UpdatePriRpScpTrspAddChgGLBackEndJobImpl.java
*@FileTitle : UpdatePriRpScpTrspAddChgGLBackEndJobImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.07
*@LastModifier : Jeeye Jeon
* 2015.12.07 Jeeye Jeon
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.integration.RFATransportationAdditionalChargeProposalDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * RFA Arbitrary G/L Amount Update 에 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeeye Jeon
 * @see RFATransportationAdditionalChargeProposalDBDAO
 * @since J2EE 1.6
 */
public class UpdatePriRpScpTrspAddChgGLBackEndJobImpl extends BackEndCommandSupport {

	private static final long serialVersionUID = 6097486557477880250L;
	
	RFATransportationAdditionalChargeProposalDBDAO dbDao = new RFATransportationAdditionalChargeProposalDBDAO();
	
	private PriRpComVO priRpComVO;
	private SignOnUserAccount account;
	
	/**
	 * @return the priRpComVO
	 */
	public PriRpComVO getPriRpComVO() {
		return priRpComVO;
	}
	
	/**
	 * @param priRpComVO the priRpComVO to set
	 */
	public void setPriRpComVO(PriRpComVO priRpComVO) {
		this.priRpComVO = priRpComVO;
	}
	
	/**
	 * @return the account
	 */
	public SignOnUserAccount getAccount() {
		return account;
	}
	
	/**
	 * @param account the account to set
	 */
	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * RFA Arbitrary G/L Amount Update Transaction 을 처리한다.<br>
	 * 
	 * @return List
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		
		try {
			 dbDao.modifyPriRpScpTrspAddChgCopy(priRpComVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}

}
