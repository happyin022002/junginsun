/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCBlListBackEndJob.java
*@FileTitle : S/C Performance Summary - View B/L
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.screport.screport.basic;
import java.util.List;

import com.clt.apps.opus.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.clt.apps.opus.esm.pri.screport.screport.vo.RsltSearchSCBlListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * Handling a biz transaction aboutS/C Performance Summary - View B/L 
 * 
 * @author 
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCBlListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 1658687229317513392L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCBlListVO rsltSearchSCBlListVO; 

	/**
	 * Setting retrieving condition for S/C Performance Summary - View B/L list. <br>
	 *  
	 * @param RsltSearchSCBlListVO rsltSearchSCBlListVO
	 */
	public void setRsltSearchSCBlListVO(RsltSearchSCBlListVO rsltSearchSCBlListVO) {
		this.rsltSearchSCBlListVO = rsltSearchSCBlListVO;
	}

	/**
	 * Retrieving S/C Performance Summary - View B/L list. <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchSCBlList(this.rsltSearchSCBlListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
