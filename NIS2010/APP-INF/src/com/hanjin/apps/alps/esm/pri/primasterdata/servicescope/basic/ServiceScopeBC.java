/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ServiceScopeBC.java
*@FileTitle : Service Scope Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.07 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.CstSvcScpVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLaneVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.servicescope.vo.RsltMdmSvcScpLmtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4017EventResponse 참조
 * @since J2EE 1.6
 */

public interface ServiceScopeBC {

	/**
	 * Service Spope List를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<MdmSvcScpVO>
	 * @exception EventException
	 */
	public List<MdmSvcScpVO> searchServiceScopeList(CstSvcScpVO cstSvcScpVO) throws EventException;

	/**
	 * Service Spope Lane List를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLaneVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLaneVO> searchServiceScopeLaneList(CstSvcScpVO cstSvcScpVO) throws EventException;
	
	/**
	 * Service Spope Origin Destination List를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return List<RsltMdmSvcScpLmtVO>
	 * @exception EventException
	 */
	public List<RsltMdmSvcScpLmtVO> searchServiceScopeOriginDestinationList(CstSvcScpVO cstSvcScpVO) throws EventException;
	
	/**
	 * Service Spope Code List를 조회합니다.<br>
	 * 
	 * @param CstSvcScpVO cstSvcScpVO
	 * @return String
	 * @exception EventException
	 */
	public String checkCodeValue(CstSvcScpVO cstSvcScpVO) throws EventException;
}