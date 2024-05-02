/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageBCImpl.java
*@FileTitle : EsdSce0103
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.sce.common.popup.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.common.popup.integration.CommonPopUpManageDBDAO;
import com.clt.apps.opus.esd.sce.common.popup.integration.CommonPopUpManageEAIDAO;
import com.clt.apps.opus.esd.sce.common.popup.vo.COPSummaryVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComOfficeManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComVvdManagementConditionVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.ComVvdManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SCNOManagementVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchContiInfoVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchContiManageVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchSceClmDataVO;
import com.clt.apps.opus.esd.sce.common.popup.vo.SearchSceClmInfoVO;
import com.clt.framework.component.javamail.SingleMailAttachedFile;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * common Business Logic Basic Command implementation<br>
 *
 * @author
 * @see EsdSce0103EventResponse,CommonPopUpManageBC 
 * @since J2EE 1.6
 */
public class CommonPopUpManageBCImpl extends BasicCommandSupport implements CommonPopUpManageBC {

	// Database Access Object
	private transient CommonPopUpManageDBDAO dbDao = null;
	private transient CommonPopUpManageEAIDAO eaiDao = null;

	/**
	 * CommonPopUpManageBCImpl Create Object<br>
	 * Generate CommonPopUpManageDBDAO.<br>
	 */
	public CommonPopUpManageBCImpl() {
		dbDao = new CommonPopUpManageDBDAO();
		eaiDao = new CommonPopUpManageEAIDAO();
	}
	/**
	 * VVD Query
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
	 * Service Office Code Query
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
	 * COP summary Query
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
	 * SC Query
	 * 
	 * @param SCNOManagementVO sCNOManagementVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public EventResponse searchSCNOManage(SCNOManagementVO sCNOManagementVO) throws EventException {
		DBRowSet rowSet=null;
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
	 * EMAIL recipient Query
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
	 * EMAIL Query information
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
	 * Query SCE CIM LIST
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
	 * COUNTRY Query
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