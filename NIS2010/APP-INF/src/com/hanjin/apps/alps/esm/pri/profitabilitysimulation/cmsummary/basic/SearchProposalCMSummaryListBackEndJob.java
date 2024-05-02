/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchProposalSummarySimulationListBackEndJob.java
*@FileTitle : S/C Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.20
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2009.09.21 송민석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.basic;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration.CMSummaryDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsProposalCmSummaryVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * S/C Rate Search 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author  Min Seok, Song
 * @see CMSummaryDBDAO
 * @since J2EE 1.6
 */
public class SearchProposalCMSummaryListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private  CMSummaryDBDAO dbDao = new CMSummaryDBDAO();
	

	private InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO; 


	/**
	 * 조회를 위한 parameter를 셋팅한다. <br>
	 *  
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return 
	 * @exception
	 */
	public void setSearchParameterVOs(InPrsProposalCmSummaryVO inPrsProposalCmSummaryVO ) {

		this.inPrsProposalCmSummaryVO = inPrsProposalCmSummaryVO;

	}

	/**
	 * SC Summary Simulation을 위해  temp table에 데이터를 생성하고 simulation update후 결과를 조회한다. <br>
	 *  
	 * @return DBRowSet
	 * @exception Exception
	 */
	public DBRowSet doStart() throws Exception {
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchProposalCmSummaryList(inPrsProposalCmSummaryVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rowSet;
	}
}
