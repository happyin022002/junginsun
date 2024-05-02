/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfacedCancelBC.java
*@FileTitle : InterfacedCancel
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.basic;

import java.util.List;

import com.clt.apps.opus.esd.tpb.candidatemanage.interfacedcancel.vo.SearchInterfacedCancelListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -InterfacedCancelmanage Business Logic Command Interface<br>
 * - -InterfacedCancelmanage Business Logic Interface<br>
 *
 * @author 
 * @see Esd_tpb_0133EventResponse reference
 * @since J2EE 1.6
 */

public interface InterfacedCancelBC {
	/**
	 * <br>
	 * 
	 * @param SearchInterfacedCancelListVO	searchInterfacedCancelListVO
	 * @return List<SearchInterfacedCancelListVO>
	 * @exception EventException
	 */
	public List<SearchInterfacedCancelListVO> searchCanceledTPB(SearchInterfacedCancelListVO searchInterfacedCancelListVO) throws EventException;
	/**
	 * <br>
	 * 
	 * @param SearchInterfacedCancelListVO[] searchInterfacedCancelListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void interfacedTPBCancel(SearchInterfacedCancelListVO[] searchInterfacedCancelListVO,SignOnUserAccount account) throws EventException;
}