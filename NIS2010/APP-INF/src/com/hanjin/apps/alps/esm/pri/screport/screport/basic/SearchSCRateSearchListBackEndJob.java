/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCRateSearchListBackEndJob.java
*@FileTitle : S/C Rate Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.21 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCRateSearchListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * S/C Rate Search 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Day-Hoh, Kim
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCRateSearchListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = -5625009436232931425L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO; 

	/**
	 * S/C Rate Search 리스트 조회조건을 셋팅한다. <br>
	 *  
	 * @param RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO
	 */
	public void setRsltSearchSCRateSearchListVO(RsltSearchSCRateSearchListVO rsltSearchSCRateSearchListVO) {
		this.rsltSearchSCRateSearchListVO = rsltSearchSCRateSearchListVO;
	}

	/**
	 * S/C Rate Search 리스트 조회한다. <br>
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
