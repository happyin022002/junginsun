/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchProposalCMSummaryListBackEndJob.java
*@FileTitle : CM Summary List
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
 * CM/OP Summary & Simulation의 Revenue값의 Detail 정보 를 조회 합니다.<br>
 * 
 * @author Min Seok, Song
 * @see CMSummaryDBDAO
 * @since J2EE 1.6
 */
public class SearchProposalRevenueDetailListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private CMSummaryDBDAO dbDao = new CMSummaryDBDAO();
	
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
	 * CM/OP Summary & Simulation , Contract Approval 리스트 를 조회 합니다. <br>
	 *  
	 * @return DBRowSet
	 * @exception Exception
	 */
	public DBRowSet doStart() throws Exception {
		DBRowSet rowSet = null;
		try {
			log.info("SearchProposalRevenueDetailListBackEndJob BEGINE");
			
			// Temp Table에 Key를 먼저 insert한다.
			//dbDao.addPriPrsCmSmrySimTmp( inPrsProposalCmSummaryVO);
			rowSet = dbDao.searchProposalRevenueDetailList(inPrsProposalCmSummaryVO);
			log.debug("SearchProposalRevenueDetailListBackEndJob END");
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rowSet;
	}
}
