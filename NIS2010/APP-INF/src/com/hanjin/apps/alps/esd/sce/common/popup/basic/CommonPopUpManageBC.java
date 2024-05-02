/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonPopUpManageBC.java
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
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Shin Han Sung
 * @see EsdSce0103EventResponse 참조
 * @since J2EE 1.6
 */

public interface CommonPopUpManageBC {

	/**
	 * VVD 대상 조회
	 * 
	 * @param ComVvdManagementConditionVO comVvdManagementConditionVO
	 * @return List<ComVvdManagementVO>
	 * @exception EventException
	 */
	public List<ComVvdManagementVO> searchVVDManage(ComVvdManagementConditionVO comVvdManagementConditionVO) throws EventException;
	
	/**
	 * Service Office Code 조회
	 * 
	 * @param ComOfficeManagementVO	comOfficeManagementVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<ComOfficeManagementVO> searchServiceOfficeCodeManage(ComOfficeManagementVO comOfficeManagementVO) throws EventException;
	
	/**
	 * COP summary 조회
	 * 
	 * @param COPSummaryVO copSummaryVO
	 * @return List<ComOfficeManagementVO>
	 * @exception EventException
	 */
	public List<COPSummaryVO> searchCOPSmryManage(COPSummaryVO copSummaryVO) throws EventException;
	
	/**
	 * SC 조회
	 * 
	 * @param SCNOManagementVO sCNOManagementVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSCNOManage(SCNOManagementVO sCNOManagementVO) throws EventException;
	
	/**
	 * EMAIL 수신인 조회
	 * 
	 * @param String param
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEMAILRecipients(String param) throws EventException;
	
	/**
	 * EMAIL 내용 조회
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchEMAILTemplateContent(SignOnUserAccount account) throws EventException;
	
	/**
	 * SCE CLM LIST 조회
	 * 
	 * @param SearchSceClmInfoVO clmInfo
	 * @return List<SearchSceClmDataVO>
	 * @exception EventException
	 */
	public List<SearchSceClmDataVO> searchSceClmList(SearchSceClmInfoVO clmInfo) throws EventException;
	
	/**
	 * COUNTRY 조회
	 *
	 * @param SearchContiInfoVO contiInfo
	 * @return List<SearchContiManageVO>
	 * @exception EventException
	 */
	public List<SearchContiManageVO> searchContiManage(SearchContiInfoVO contiInfo) throws EventException;
	
	
	/**
	 * @param szSubject
	 * @param usr_eml
	 * @param arFileList
	 * @param arrSendList
	 * @param szContents
	 * @return String
	 * @exception EventException
	 */
	public String sendEml(String szSubject, String usr_eml, List<SingleMailAttachedFile> arFileList, String[] arrSendList, String szContents) throws EventException;
}