/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCPerformanceDetailListBackEndJob.java
*@FileTitle : S/C Performance Summary - Detail
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Handling a biz trasaction about S/C Performance Summary -Detail 
 * 
 * @author 
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCPerformanceDetailListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 29447540369892337L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO; 

	/**
	 * Setting retrieving condition for S/C Performance Summary - Detail list <br>
	 *  
	 * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
	 */
	public void setRsltSCPerformanceDetailListVO(RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) {
		this.rsltSearchSCPerformanceDetailListVO = rsltSearchSCPerformanceDetailListVO;
	}

	/**
	 * Retrieving S/C Performance Summary - Detail list <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchSCPerformanceDetailList(this.rsltSearchSCPerformanceDetailListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
