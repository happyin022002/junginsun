/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAReportBCImpl.java
*@FileTitle : RFA Proposal Creation – Draft
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.04
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.09.15 변영주
* 1.0 Creation
* 2010.10.04 송호진 CHM-201006291-01 - [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
* 2011.12.05 이석준 [CHM-201114806-01] Login Office가 XXXBA일경우 RFA No or Proposal No가 해당 BA것 일경우만 S/C Viewing이 가능하거나
조회 가능토록 수정 - searchRFARateSearchListDoStart,searchRFAList SignOnUserAccount parameter 추가
2011.12.26 이석준 [CHM-201115205] RFA or Proposal 조회시 HAMRU 산하의 BA만
                                                                    자신의 office만 조회 가능할 수 있도록 validation및 logic 수정
* 2014.11.25 [CHM-201432700] 최성환 Retroactive RFA Minimization관련 시스템 개발요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.integration.RFAReportDBDAO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriCopiedRFAVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriMasterRFAOnlyVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRpRetroInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltRFARetRDInfoVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFAListVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltSearchRFARateSearchListVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;

/**
 * ALPS-RFAReport Business Logic Command Interface<br>
 * - ALPS-RFAReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Byeon Young Joo
 * @see UI_PRI_2039EventResponse,UI_PRI_2062EventResponse,RFAReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFAReportBCImpl extends BasicCommandSupport implements RFAReportBC {

	// Database Access Object
	private transient RFAReportDBDAO dbDao = null;

	/**
	 * RFAReportBCImpl 객체 생성<br>
	 * RFAReportDBDAO를 생성한다.<br>
	 */
	public RFAReportBCImpl() {
		dbDao = new RFAReportDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * RFAReport의 Report 관련 정보 조회 이벤트 처리<br>
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
	 * RFA Search - RFA Retrieval 리스트를 조회한다. <br>
	 * 
	 * @param RsltSearchRFAListVO rsltSearchRFAListVO
	 * @param SignOnUserAccount account
	 * @return List<RsltSearchRFAListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchRFAListVO> searchRFAList(RsltSearchRFAListVO rsltSearchRFAListVO,SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchRFAList(rsltSearchRFAListVO,account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * RFA Search - Rate Retrieval 리스트를 조회 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO
	 * @return List<RsltSearchRFARateSearchListVO>
	 * @exception EventException
	 */	
	public String searchRFARateSearchListDoStart(SignOnUserAccount account, RsltSearchRFARateSearchListVO rsltSearchRFARateSearchListVO) throws EventException {
		SearchRFARateSearchListBackEndJob searchRFARateSearchListBackEndJob = new SearchRFARateSearchListBackEndJob();
		searchRFARateSearchListBackEndJob.setRsltSearchRFARateSearchListVO(rsltSearchRFARateSearchListVO);
		searchRFARateSearchListBackEndJob.setlogInOfcCd(account.getOfc_cd());
		searchRFARateSearchListBackEndJob.setlogInRhqCd(account.getRhq_ofc_cd());
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(searchRFARateSearchListBackEndJob, account.getUsr_id(), "ESM_PRI_2042 - Search");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
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
	
	/**
	 *  Retroactive RFA Search -Retroactive RFA Retrieval 리스트를 조회한다.<br>
	 * 
	 * @param RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriRpRetroInfoVO>
	 * @exception EventException
	 */	
	public List<RsltPriRpRetroInfoVO> searchRetroactiveRFAList(RsltPriRpRetroInfoVO rsltPriRpRetroInfoVO,SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchRetroactiveRFAList(rsltPriRpRetroInfoVO,account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_PRI_2219_01 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriMasterRFAOnlyVO>
	 * @exception EventException
	 */
	public List<RsltPriMasterRFAOnlyVO> searchMasterRFAOnlyList(MasterRFAConditionVO masterRFAConditionVO) throws EventException {
		try {
			return dbDao.searchMasterRFAOnlyList(masterRFAConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_PRI_2219_02 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriCopiedRFAVO>
	 * @exception EventException
	 */
	public List<RsltPriCopiedRFAVO> searchCopiedRFAList(MasterRFAConditionVO masterRFAConditionVO) throws EventException {
		try {
			return dbDao.searchCopiedRFAList(masterRFAConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESM_PRI_2211 - Retrieve
	 * 
	 * @param MasterRFAConditionVO masterRFAConditionVO
	 * @return List<RsltPriRFABlVO>
	 * @exception EventException
	 */
	public List<RsltPriRFABlVO> searchRFABlList(MasterRFAConditionVO masterRFAConditionVO) throws EventException {
		try {
			return dbDao.searchRFABlList(masterRFAConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}