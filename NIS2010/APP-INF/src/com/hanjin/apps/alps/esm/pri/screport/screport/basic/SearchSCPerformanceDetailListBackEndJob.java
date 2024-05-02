/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSCPerformanceDetailListBackEndJob.java
*@FileTitle : S/C Performance Summary - Detail
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
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RsltSearchSCPerformanceDetailListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * S/C Performance Summary -Detail 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Day-Hoh, Kim
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchSCPerformanceDetailListBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 29447540369892337L;

	private SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO; 

	/**
	 * S/C Performance Summary - Detail 리스트 조회조건을 셋팅한다. <br>
	 *  
	 * @param RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO
	 */
	public void setRsltSCPerformanceDetailListVO(RsltSearchSCPerformanceDetailListVO rsltSearchSCPerformanceDetailListVO) {
		this.rsltSearchSCPerformanceDetailListVO = rsltSearchSCPerformanceDetailListVO;
	}

	/**
	 * S/C Performance Summary - Detail 리스트 조회한다. <br>
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
