/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManage.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface BlockStowageManageBC{

	/**
	 * BlockStowageManage 화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param groupCreationVO
	 * @return 
	 * @exception EventException
	 */
	public List<GroupCreationVO> searchGroupCreationList(GroupCreationVO groupCreationVO) throws EventException;

	/**
	 * BlockStowageManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param groupCreationVO
	 * @return
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<GroupCreationVO> searchLaneCode(GroupCreationVO groupCreationVO) throws EventException;

	/**
	 * BlockStowageManage 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param groupCreationVOs
	 * @param signOnUserAccount
	 * @exception EventException
	 */
	public void multiGroupCreation(GroupCreationVO[] groupCreationVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * BlockStowageManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param codeInquiryVO
	 * @return
	 * @throws EventException
	 */
	public List<CodeInquiryVO> searchCodeInquiryList(CodeInquiryVO codeInquiryVO) throws EventException;
}
