/*========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DVFactorCNTRSealInquiryListBackEndJob.java
*@FileTitle : DVFactorCNTRSealInquiryListBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.07
*@LastModifier : 조경완 
*@LastVersion : 1.0
* 2012.09.07  조경완	
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.integration.DVFactorMgtDBDAO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealInquiryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
				
				
/**
 * ALPS-Performancereport Business Logic Command Interface<br>
 * - ALPS-Performancereport에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Park Myoung Sin
 * @see Ees_mnr_0115EventResponse 참조
 * @since J2EE 1.6	
 */
public class DVFactorCNTRSealInquiryCountBackEndJob extends BackEndCommandSupport {
	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;		
				
	private DVFactorMgtDBDAO dbDao = new DVFactorMgtDBDAO();
	
	private String jobType = null;

	private ContainerSealInquiryVO containerSealInquiryVO = null;
	
	private SignOnUserAccount account = null; 

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list	
	 * @exception Exception	
	 */
	public String doStart() throws Exception {
		String count = null;
				
		try {			
			count = dbDao.searchContainerSealInquiryCount(containerSealInquiryVO);
		} catch (DAOException ex) {	
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}	

		return count;
	}	

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public ContainerSealInquiryVO getContainerSealInquiryVO() {
		return containerSealInquiryVO;
	}

	public void setContainerSealInquiryVO(
			ContainerSealInquiryVO containerSealInquiryVO) {
		this.containerSealInquiryVO = containerSealInquiryVO;
	}

	public SignOnUserAccount getAccount() {
		return account;
	}

	public void setAccount(SignOnUserAccount account) {
		this.account = account;
	}
}
