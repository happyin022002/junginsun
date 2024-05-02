/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : BlockStowageManage.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.CodeInquiryVO;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 
 * @since J2EE 1.4
 */
public interface BlockStowageManageBC{

	/**
	 * BlockStowageManage - retrieve<br>
	 *
	 * @param groupCreationVO
	 * @return 
	 * @exception EventException
	 */
	public List<GroupCreationVO> searchGroupCreationList(GroupCreationVO groupCreationVO) throws EventException;

	/**
	 * BlockStowageManage - retrieve<br>
	 * 
	 * @param groupCreationVO
	 * @return
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<GroupCreationVO> searchLaneCode(GroupCreationVO groupCreationVO) throws EventException;

	/**
	 * BlockStowageManage - multi event<br>
	 *
	 * @param groupCreationVOs
	 * @param signOnUserAccount
	 * @exception EventException
	 */
	public void multiGroupCreation(GroupCreationVO[] groupCreationVOs, SignOnUserAccount signOnUserAccount) throws EventException;

	/**
	 * BlockStowageManage - retrieve<br>
	 * 
	 * @param codeInquiryVO
	 * @return
	 * @throws EventException
	 */
	public List<CodeInquiryVO> searchCodeInquiryList(CodeInquiryVO codeInquiryVO) throws EventException;
}
