/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AuthorizationAssignmentBC.java
*@FileTitle : Authority Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.05.28 문동규
* 1.0 Creation
* =========================================================
* History
* 2011.08.11 송민석 [CHM-201112844] PRI 유지 보수를 위한 User 정보 변경 프로그램 개발
* =========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.ChangeUserVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthAproVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthHisVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.RsltAuthorizationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComUserVO;

/**
 * NIS2010-Primasterdata Business Logic Command Interface<br>
 * - NIS2010-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Moon Dong Gyu
 * @see Esm_pri_0009EventResponse 참조
 * @since J2EE 1.6
 */


public interface AuthorizationAssignmentBC {
	/**
	 * S/C Authority 정보를 조회합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchScAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException;

    /**
     * RFA Authority 정보를 조회합니다.<br>
     * 
     * @param RsltAuthorizationVO rsltAuthorizationVO
     * @return List<RsltAuthorizationVO>
     * @exception EventException
     */
    public List<RsltAuthorizationVO> searchRfaAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException;

	/**
	 * Authority 정보를 저장합니다.<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAuthorizationAssignment(RsltAuthorizationVO[] rsltAuthorizationVO,SignOnUserAccount account) throws EventException;

	/**
	 * Authority Creation 화면에서 조직별 사용자 콤보 리스트를 조회합니다.<br>
	 * 
	 * @param ComUserVO comUserVO
	 * @return List<ComUserVO>
	 * @exception EventException
	 */
	public List<ComUserVO> searchComUserList (ComUserVO comUserVO) throws EventException;

    /**
     * RFA Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchRFAOfficeTreeList (OrganizationVO organizationVO) throws EventException;

    /**
     * S/C Authorization 의 조직도를 조회합니다.<br>
     * 
     * @param OrganizationVO organizationVO
     * @return List<OrganizationVO>
     * @exception EventException
     */
    public List<OrganizationVO> searchSCOfficeTreeList (OrganizationVO organizationVO) throws EventException;
    
    /**
     * 사용자 정보를 조회 한다.<br>
     * 
     * @param ChangeUserVO changeUserVO
     * @return ChangeUserVO
     * @exception EventException
     */
    public ChangeUserVO searchComUserForChangeInquiry (ChangeUserVO changeUserVO) throws EventException; 
    
    
	/**
	 * Trade Authority 정보를 저장합니다.<br>
	 * 
	 * @param RsltAuthorizationVO[] rsltAuthorizationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageTradeAuthorizationAssignment(RsltAuthorizationVO[] rsltAuthorizationVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Trade Authority 정보를 조회합니다.<br>
	 * 
	 * @param RsltAuthorizationVO rsltAuthorizationVO
	 * @return List<RsltAuthorizationVO>
	 * @exception EventException
	 */
	public List<RsltAuthorizationVO> searchTradeAuthorizationAssignmentList(RsltAuthorizationVO rsltAuthorizationVO) throws EventException;
	

	/**
	 * 2016.09.02 추가 <br>
	 * Hard coding 권한을 조회한다.
	 * 
	 * @param RsltAuthAproVO rsltAuthAproVO
	 * @return List<RsltAuthAproVO>
	 * @exception EventException
	 */
	public List<RsltAuthAproVO> searchAuthorizationApprovalList(RsltAuthAproVO rsltAuthAproVO) throws EventException ;
	
	/**
	 * 2016.09.02 추가 <br>
	 * Hard Coding User Authorization History 를 조회한다.<br>
	 * 
	 * @return RsltAuthAproVO RsltAuthAproVO
	 * @exception EventException
	 */
	public List<RsltAuthHisVO> searchAuthorizationApprovalHistoryList(RsltAuthHisVO rsltAuthHisVO) throws EventException ;
	
	/**
	 * 2016.09.02 추가 <br>
	 * Hard Coding 권한 및 History를 저장한다.
	 * 
	 * @param RsltAuthAproVO[] rsltAuthAproVOs,UsrAuthHisVO[] usrAuthHisVOs, SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int multiAuthorizationApprovalList(RsltAuthAproVO[] rsltAuthAproVOs,RsltAuthHisVO[] rsltAuthHisVOs, SignOnUserAccount account) throws EventException ;
	
}