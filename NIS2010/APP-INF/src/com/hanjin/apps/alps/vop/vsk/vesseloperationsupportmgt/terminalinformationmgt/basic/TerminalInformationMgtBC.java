/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtBC.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.25 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalHandlingInfoAttachFileVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.VskPortFltgCrnVO;
import com.hanjin.syscommon.common.table.VskPortGngStrcVO;

/**
 * NIS2010-Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - NIS2010-Vesseloperationsupportmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jang Suk Hyun
 * @see Vop_vsk_0507EventResponse 참조
 * @since J2EE 1.4
 */

public interface TerminalInformationMgtBC {
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException ; 

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortInfoList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;	
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Terminal Combo]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchTermialComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Port Max Sequence]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchMaxFCraneSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [G/Crane]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGntrCrnVO>
	 * @exception EventException
	 */
	public List<VskPortGntrCrnVO> searchGCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [Gang Structure]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGngStrcVO>
	 * @exception EventException
	 */
	public List<VskPortGngStrcVO> searchGangStructureList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [F/Crane]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortFltgCrnVO>
	 * @exception EventException
	 */
	public List<VskPortFltgCrnVO> searchFCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;	

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [BerthWindow]을 [조회] 합니다.<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortBrthWdoVO>
	 * @exception EventException
	 */
	public List<VskPortBrthWdoVO> searchBerthWindowList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [VSK PORT GANTRY CRANE]을 [조회] 합니다.<br>
	 * 
	 * @param VskPortGntrCrnVO[] vskPortGntrCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGcrane(VskPortGntrCrnVO[] vskPortGntrCrnVOs,SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [VSK PORT FLOATING CRANE]을 [조회] 합니다.<br>
	 * 
	 * @param VskPortFltgCrnVO[] vskPortFltgCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoFcrane(VskPortFltgCrnVO[] vskPortFltgCrnVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [VSK PORT GANG STRUCTURE]을 [조회] 합니다.<br>
	 * 
	 * @param VskPortGngStrcVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGang(VskPortGngStrcVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * [VSK PORT BIRTH WINDOw]을 [조회] 합니다.<br>
	 * 
	 * @param VskPortBrthWdoVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoBerth(VskPortBrthWdoVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_VSK_2507 : Retrieve <br>
	 * Terminal Handling Information Attach File List를 조회 합니다.<br>
	 * 
	 * @param TerminalHandlingInfoAttachFileVO terminalHandlingInfoAttachFileVO
	 * @return List<TerminalHandlingInfoAttachFileVO>
	 * @exception EventException
	 */
	public List<TerminalHandlingInfoAttachFileVO> searchTerminalHandlingInfoAttachFileList(TerminalHandlingInfoAttachFileVO terminalHandlingInfoAttachFileVO) throws EventException;	

	/**
	 * VOP_VSK_2507 : Save <br>
	 * Terminal Handling Information Attach File List를 저장 합니다.<br>
	 * 
	 * @param TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 * @exception DAOException
	 */
	public void manageTerminalHandlingInfoAttachFileList(TerminalHandlingInfoAttachFileVO[] terminalHandlingInfoAttachFileVO, SignOnUserAccount account) throws EventException, DAOException;

}