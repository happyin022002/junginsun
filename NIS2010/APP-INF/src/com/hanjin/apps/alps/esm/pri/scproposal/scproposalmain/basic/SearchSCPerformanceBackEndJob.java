/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCPerformanceBackEndJob.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.05
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.11.05 공백진
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.integration.SCProposalMainDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPerformanceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;

/**
 * S/C Performance ,Att 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kong Back Jin
 * @see SCProposalMainDBDAO
 * @since J2EE 1.6
 */
public class SearchSCPerformanceBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -4990121540809163259L;

	private  SCProposalMainDBDAO dbDao = new SCProposalMainDBDAO();
	
//	private SignOnUserAccount account;
	private PriSpMnVO priSpMnVO; 

	/**
	 * S/C Performance  조회조건을 셋팅한다. <br>
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
		 * S/C Performance  를 조회한다. <br>
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
