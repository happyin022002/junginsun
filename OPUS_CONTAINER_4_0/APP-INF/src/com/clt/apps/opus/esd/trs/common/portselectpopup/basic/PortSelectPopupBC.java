/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSelectPopupBC.java
*@FileTitle : PortSelectPopupBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.portselectpopup.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.portselectpopup.vo.PortVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmCountryVO;

/**
 * Common Business Logic Command Interface<br>
 * - business logic interface about Common<br>
 *
 * @author 
 * @see EsdTrs0981Event 참조
 * @since J2EE 1.4
 */
public interface PortSelectPopupBC {
	
	/**
	 * Retrieving Port
	 * 
	 * @param PortVO portVO
	 * @return List<PortVO>
	 * @exception EventException
	 */
	public List<PortVO> searchPortList(PortVO portVO) throws EventException;
	/**
	 * Retrieving Country
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryList(String cntCd) throws EventException;
}