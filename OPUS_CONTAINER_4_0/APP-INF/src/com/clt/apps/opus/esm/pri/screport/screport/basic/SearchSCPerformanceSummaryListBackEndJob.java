/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCPerformanceSummaryListBackEndJob.java
*@FileTitle : S/C Performance Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerfromanceVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * handling a biz transaction about S/C Performance Summary 
 * 
 * @author 
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCPerformanceSummaryListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 6952105465428416158L;

	private  SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO; 

	/**
	 * Setting retrieving condition for S/C Performance Summary list. <br>
	 *  
	 * @param RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO
	 */	
	public void setRsltSearchSCPerfromanceVO(RsltSearchSCPerfromanceVO rsltSearchSCPerfromanceVO) {
		this.rsltSearchSCPerfromanceVO = rsltSearchSCPerfromanceVO;
	}

	/**
	 * Retrieving S/C Performance Summary - View B/L list<br>
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")		
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchSCPerformanceSummaryList(this.rsltSearchSCPerfromanceVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
