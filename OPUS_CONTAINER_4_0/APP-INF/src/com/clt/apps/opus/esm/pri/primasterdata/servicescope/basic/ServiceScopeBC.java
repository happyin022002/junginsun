/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeBC.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.servicescope.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.clt.apps.opus.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmSvcScpVO;

/**
 * Primasterdata Business Logic Command Interface<br>
 * - Handling a biz logic about Primasterdata<br>
 *
 * @author 
 * @see Esm_pri_4017EventResponse
 * @since J2EE 1.6
 */

public interface ServiceScopeBC {

	/**
	 * Retrieving Service Spope List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<MdmSvcScpVO>
	 * @exception EventException
	 */
	public List<MdmSvcScpVO> searchServiceScopeList(CstSvcScpVO cstSvcScpVO) throws EventException;

	/**
	 * Retrieving Service Spope Lane List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLaneVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLaneVO> searchServiceScopeLaneList(CstSvcScpVO cstSvcScpVO) throws EventException;
	
	/**
	 * Retrieving Service Spope Origin Destination List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLmtVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLmtVO> searchServiceScopeOriginDestinationList(CstSvcScpVO cstSvcScpVO) throws EventException;
	
	/**
	 * Retrieving Service Spope Code List<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCodeValue(CstSvcScpVO cstSvcScpVO) throws EventException;
}