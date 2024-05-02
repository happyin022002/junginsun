/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TerminalInformationMgtBC.java
*@FileTitle : Terminal Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.TerminalInfoConditionVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortBrthWdoVO;
import com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.vo.VskPortGntrCrnVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.VskPortFltgCrnVO;
import com.clt.syscommon.common.table.VskPortGngStrcVO;

/**
 * Vesseloperationsupportmgt Business Logic Command Interface<br>
 * - Interface of Business Logic about Vesseloperationsupportmgt<br>
 *
 * @author 
 * @see Vop_vsk_0507EventResponse 
 * @since J2EE 1.4
 */

public interface TerminalInformationMgtBC {
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Port Combo
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException ; 

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Port Combo
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPortInfoList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;	
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Terminal Combo
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchTermialComboList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Port Max Sequence
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchMaxFCraneSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Gang Structure  Max Sequence
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchMaxGngSeqList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving G/Crane
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGntrCrnVO>
	 * @exception EventException
	 */
	public List<VskPortGntrCrnVO> searchGCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving Gang Structure
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortGngStrcVO>
	 * @exception EventException
	 */
	public List<VskPortGngStrcVO> searchGangStructureList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;
	
	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving F/Crane<br>
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortFltgCrnVO>
	 * @exception EventException
	 */
	public List<VskPortFltgCrnVO> searchFCraneList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;	

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving BerthWindow
	 * 
	 * @param TerminalInfoConditionVO terminalInfoConditionVO
	 * @return List<VskPortBrthWdoVO>
	 * @exception EventException
	 */
	public List<VskPortBrthWdoVO> searchBerthWindowList(TerminalInfoConditionVO terminalInfoConditionVO) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving VSK PORT GANTRY CRANE
	 * 
	 * @param VskPortGntrCrnVO[] vskPortGntrCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGcrane(VskPortGntrCrnVO[] vskPortGntrCrnVOs,SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving VSK PORT FLOATING CRANE
	 * 
	 * @param VskPortFltgCrnVO[] vskPortFltgCrnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoFcrane(VskPortFltgCrnVO[] vskPortFltgCrnVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving VSK PORT GANG STRUCTURE
	 * 
	 * @param VskPortGngStrcVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoGang(VskPortGngStrcVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_VSK_0507 : Retrieve <br>
	 * Retrieving VSK PORT BERTH WINDOW
	 * 
	 * @param VskPortBrthWdoVO[] vskPortGngStrcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTerminalInfoBerth(VskPortBrthWdoVO[] vskPortGngStrcVOs, SignOnUserAccount account) throws EventException;
}