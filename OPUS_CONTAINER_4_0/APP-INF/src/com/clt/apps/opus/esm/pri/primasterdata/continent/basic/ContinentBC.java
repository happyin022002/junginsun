/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentBC.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.continent.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmContinentVO;
import com.clt.syscommon.common.table.MdmSubcontinentVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - interface about Primasterdata biz logic<br>
 *
 * @author 
 * @see Esm_pri_4021EventResponse 
 * @since J2EE 1.6
 */

public interface ContinentBC {

	/**
	 * Retrieving Continent List<br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmContinentVO>
	 * @exception EventException
	 */
	public List<MdmContinentVO> searchContinentList(ContinentVO continentVO) throws EventException;

	/**
	 * Retrieving Sub Continent List<br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmSubcontinentVO>
	 * @exception EventException
	 */
	public List<MdmSubcontinentVO> searchSubcontinentList(ContinentVO continentVO) throws EventException;
}