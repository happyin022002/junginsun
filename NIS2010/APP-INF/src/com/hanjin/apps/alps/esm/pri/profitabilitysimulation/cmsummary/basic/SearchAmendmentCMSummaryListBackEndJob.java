/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchAmendmentCMSummaryListBackEndJob.java
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

import java.util.List;

import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.integration.CMSummaryDBDAO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.InPrsAmendmentCmSummaryVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.cmsummary.vo.RsltPrsAmendmentCmSummarySimulationDateParamVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * CM Summary List 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Min Seok, Song
 * @see CMSummaryDBDAO
 * @since J2EE 1.6
 */
public class SearchAmendmentCMSummaryListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private  CMSummaryDBDAO dbDao = new CMSummaryDBDAO();
	
	private InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO; 


	/**
	 * 조회를 위한 parameter를 셋팅한다. <br>
	 *  
	 * @param SignOnUserAccount account
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 * @return 
	 * @exception
	 */
	public void setSearchParameterVOs(InPrsAmendmentCmSummaryVO inPrsAmendmentCmSummaryVO ) {

		this.inPrsAmendmentCmSummaryVO = inPrsAmendmentCmSummaryVO;
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
			List<RsltPrsAmendmentCmSummarySimulationDateParamVO> dateParam = dbDao.searchSimulationParamDate(inPrsAmendmentCmSummaryVO);
			rowSet = dbDao.searchAmendmentCmSummaryList(inPrsAmendmentCmSummaryVO,dateParam.get(0));
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return rowSet;
	}
}
