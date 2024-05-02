/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportBCImpl.java
*@FileTitle : RFA Proposal Creation ? Draft
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfareport.rfareport.basic;

import java.sql.SQLException;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfareport.rfareport.integration.RFAReportDBDAO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.clt.apps.opus.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * RFAReport Business Logic Command Interface<br>
 * - Handling a biz logic about RFAReport<br>
 *
 * @author 
 * @see UI_PRI_2039EventResponse,UI_PRI_2062EventResponse,RFAReportBC refer to each DAO class
 * @since J2EE 1.6
 */
public class RFAReportBCImpl extends BasicCommandSupport implements RFAReportBC {

	// Database Access Object
	private transient RFAReportDBDAO dbDao = null;

	/**
	 * Creating RFAReportBCImpl Object <br>
	 * Creating RFAReportDBDAO.<br>
	 */
	public RFAReportBCImpl() {
		dbDao = new RFAReportDBDAO();
	}
	/**
	 * Retrieving information for RFAReport<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRFARetRDInfoVO>
	 * @exception EventException
	 */
	public List<RsltRFARetRDInfoVO> searchRFARetrievalRDInfo(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchRFARetrievalRDInfo(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Retrieving RFA Search - RFA Retrieval List <br>
	 * 
	 * @param RsltSearchRFAListVO rsltSearchRFAListVO
	 * @return List<RsltSearchRFAListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchRFAListVO> searchRFAList(RsltSearchRFAListVO rsltSearchRFAListVO) throws EventException {
		try {
			return dbDao.searchRFAList(rsltSearchRFAListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 *  running backEndJob to Retrieve RFA Search - Rate Retrieval List<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 * @return List<RsltSearchRFARateSearchListVO>
	 * @exception EventException
	 */	
	public String searchRFARateSearchListDoStart(SignOnUserAccount account, RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) throws EventException {
		SearchRFARateSearchListBackEndJob searchRFARateSearchListBackEndJob = new SearchRFARateSearchListBackEndJob();
		searchRFARateSearchListBackEndJob.setRsltSearchRFARateSearchListVO(rsltSearchRFARateSearchListVO);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchRFARateSearchListBackEndJob, account.getUsr_id(), "ESM_PRI_2042 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
}