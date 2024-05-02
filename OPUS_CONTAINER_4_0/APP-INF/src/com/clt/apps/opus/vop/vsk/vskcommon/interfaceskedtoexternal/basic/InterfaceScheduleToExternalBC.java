/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.basic;

import java.util.List;

import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.CSSMVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfDtlVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfHdrVO;
import com.clt.apps.opus.vop.vsk.vskcommon.interfaceskedtoexternal.vo.VskVipsIfMstVO;
import com.clt.framework.core.layer.event.EventException;

 
/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see Ui_vsk-0202EventResponse
 * @since J2EE 1.4
 */

public interface InterfaceScheduleToExternalBC {

	/**
	 * VIPS I/F 
	 * 
	 * @param List<VskVipsIfMstVO> vskVipsIfMstVOs
	 * @param List<VskVipsIfDtlVO> vskVipsIfDtlVOs
	 * @param String sEventTypeCode
	 * @exception EventException
	 */
	public void  createVskVipsIf(List<VskVipsIfMstVO> vskVipsIfMstVOs, List<VskVipsIfDtlVO> vskVipsIfDtlVOs, String sEventTypeCode) throws EventException;
	
	}