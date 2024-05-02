/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCRateSearchListBackEndJob.java
*@FileTitle : S/C Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * handling a biz transaction about S/C Rate Search
 * 
 * @author 
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCRateSearchListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO; 

	/**
	 * Setting retrieving condition for S/C Rate Search list<br>
	 *  
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 */
	public void setRsltSearchSCRateSearchListVO(RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) {
		this.rsltSearchSCRateSearchListVO = rsltSearchSCRateSearchListVO;
	}

	/**
	 * Retrieving S/C Rate Search list <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchSCRateSearchList(this.rsltSearchSCRateSearchListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
	
}
