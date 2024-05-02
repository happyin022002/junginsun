/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageBCImpl.java
*@FileTitle : EsdSce0103
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 신한성
*@LastVersion : 1.0
* 2009.07.28 신한성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.popup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.common.popup.integration.CommonPopUpManageDBDAO;
import com.hanjin.apps.alps.esd.sce.common.popup.integration.CommonPopUpManageEAIDAO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.COPSummaryVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementConditionVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SCNOManagementVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiInfoVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchContiManageVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmDataVO;
import com.hanjin.apps.alps.esd.sce.common.popup.vo.SearchSceClmInfoVO;
import com.hanjin.framework.component.javamail.SingleMailAttachedFile;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-common Business Logic Basic Command implementation<br>
 * - ALPS-common에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Shin Han Sung
 * @see EsdSce0103EventResponse,CommonPopUpManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CommonPopUpManageBCImpl extends BasicCommandSupport implements CommonPopUpManageBC {

	// Database Access Object
	private transient CommonPopUpManageDBDAO dbDao = null;
	private transient CommonPopUpManageEAIDAO eaiDao = null;

	/**
	 * CommonPopUpManageBCImpl 객체 생성<br>
	 * CommonPopUpManageDBDAO를 생성한다.<br>
	 */
	public CommonPopUpManageBCImpl() {
		dbDao = new CommonPopUpManageDBDAO();
		eaiDao = new CommonPopUpManageEAIDAO();
	}
	/**
	 * VVD 조회
	 * 
	 * @param ComVvdManagementConditionVO comVvdManagementConditionVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public List<ComVvdManagementVO> searchVVDManage(ComVvdManagementConditionVO comVvdManagementConditionVO) throws EventException {
		try {
			return dbDao.searchVVDManage(comVvdManagementConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * Service Office Code 조회
	 * 
	 * @param ComOfficeManagementVO comOfficeManagementVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchServiceOfficeCodeManage(ComOfficeManagementVO comOfficeManagementVO) throws EventException {
		try {
			return dbDao.searchServiceOfficeCodeManage(comOfficeManagementVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * COP summary 조회
	 * 
	 * @param COPSummaryVO copSummaryVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public List<COPSummaryVO> searchCOPSmryManage(COPSummaryVO copSummaryVO) throws EventException {
		try {
			return dbDao.searchCOPSmryManage(copSummaryVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * SC 조회
	 * 
	 * @param SCNOManagementVO sCNOManagementVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public EventResponse searchSCNOManage(SCNOManagementVO sCNOManagementVO) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
		try {
			cnt    = dbDao.searchSCNOManageCount(sCNOManagementVO);
            rowSet = dbDao.searchSCNOManage(sCNOManagementVO);
            rowSet.setMaxRows(cnt);
            GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EMAIL 수신인 조회
	 * 
	 * @param String param
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEMAILRecipients(String param) throws EventException {
		try {
			return dbDao.searchEMAILRecipients(param);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * EMAIL 내용 조회
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchEMAILTemplateContent(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchEMAILTemplateContent(account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * SCE CLM LIST 조회
	 * 
	 * @param SearchSceClmInfoVO clmInfo
	 * @return List<SearchSceClmDataVO>
	 * @exception EventException
	 */
	public List<SearchSceClmDataVO> searchSceClmList(SearchSceClmInfoVO clmInfo) throws EventException {
		log.debug("searchSceClmList Start!! ");
    	
    	try {
			return dbDao.searchSceClmList(clmInfo) ;
		} catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}
	
	/**
	 * COUNTRY 조회
	 *
	 * @param SearchContiInfoVO contiInfo
	 * @return List<SearchContiManageVO>
	 * @exception EventException
	 */
	public List<SearchContiManageVO> searchContiManage(SearchContiInfoVO contiInfo) throws EventException {
		log.debug("searchContiManage Start!! ");
		
		try {
			return dbDao.searchContiManage(contiInfo);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * @param szSubject
	 * @param usr_eml
	 * @param arFileList
	 * @param arrSendList
	 * @param szContents
	 * @return String
	 * @throws EventException
	 */
	public String sendEml(String szSubject, String usr_eml, List<SingleMailAttachedFile> arFileList, String[] arrSendList, String szContents) throws EventException {
		log.debug("sendEml Start!! ");
		
		try {
			return eaiDao.sendEml(szSubject, usr_eml, arFileList, arrSendList, szContents);
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}	
	}
}