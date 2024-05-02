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
=========================================================
2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchRFARateSearchListDoStart,searchRFAList SignOnUserAccount parameter 추가
2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
                                                                    자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration.RFAReportDBDAO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

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

	private String logInOfcCd ;
	private String logInRhqCd ; 
	/**
	 * RFA Search - Rate Retrieval 리스트 조회조건을 셋팅한다. <br>
	 *  
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 */	
	public void setRsltSearchRFARateSearchListVO(RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) {
		this.rsltSearchRFARateSearchListVO = rsltSearchRFARateSearchListVO;
	}

	/**
	 * Login Office를 Setting한다.<br>
	 * @param String logInOfcCd
	 */
	public void setlogInOfcCd(String logInOfcCd){
		this.logInOfcCd = logInOfcCd;
	}
	
	/**
	 * Login RHQ Office를 Setting한다.<br>
	 * @param String logInRhqCd
	 */
	public void setlogInRhqCd(String logInRhqCd){
		this.logInRhqCd = logInRhqCd;
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
			list = dbDao.searchRFARateSearchList(this.rsltSearchRFARateSearchListVO,this.logInOfcCd,this.logInRhqCd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
