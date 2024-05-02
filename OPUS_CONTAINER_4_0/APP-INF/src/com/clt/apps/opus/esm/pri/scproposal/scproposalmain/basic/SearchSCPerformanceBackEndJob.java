/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCPerformanceBackEndJob.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.integration.SCProposalMainDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * handling a biz logic about S/C Performance ,Att 
 * 
 * @author 
 * @see SCProposalMainDBDAO
 * @since J2EE 1.6
 */
public class SearchSCPerformanceBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -4990121540809163259L;

	private  SCProposalMainDBDAO dbDao = new SCProposalMainDBDAO();
	
//	private SignOnUserAccount account;
	private PriSpMnVO priSpMnVO; 

	/**
	 * Setting S/C Performance's retrieving condition. <br>
	 *  
	 * @param SignOnUserAccount account
	 * @param PriSpMnVO priSpMnVO
	 * @return 
	 * @exception
	 */	
	public void setPerfromanceVO(SignOnUserAccount account, PriSpMnVO priSpMnVO) {
//		this.account = account;
		this.priSpMnVO = priSpMnVO;
	}

		/**
		 * Retrieving S/C Performance <br>
		 *  
		 * @return DBRowSet
		 * @exception Exception
		 */
	public List<RsltPerformanceVO> doStart() throws Exception {
		try {			
			return dbDao.searchProposalMainPerformance(this.priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
