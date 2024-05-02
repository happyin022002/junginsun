/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchRFARateSearchListBackEndJob.java
*@FileTitle : RFA Search - Rate Retrieval
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.21 김대호
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfareport.rfareport.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.rfareport.rfareport.integration.RFAReportDBDAO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;

/**
 * RFA Search - Rate Retrieval 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Day-Hoh, Kim
 * @see RFAReportDBDAO
 * @since J2EE 1.6
 */
public class SearchRFARateSearchListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5479624864120463390L;

	private  RFAReportDBDAO dbDao = new RFAReportDBDAO();
	
	private RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO; 

	/**
	 * RFA Search - Rate Retrieval 리스트 조회조건을 셋팅한다. <br>
	 *  
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 */	
	public void setRsltSearchRFARateSearchListVO(RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) {
		this.rsltSearchRFARateSearchListVO = rsltSearchRFARateSearchListVO;
	}

	/**
	 * RFA Search - Rate Retrieval 리스트 조회한다. <br>
	 *  
	 * @return List
	 * @exception Exception
	 */
	 @SuppressWarnings("unchecked")	
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchRFARateSearchList(this.rsltSearchRFARateSearchListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
