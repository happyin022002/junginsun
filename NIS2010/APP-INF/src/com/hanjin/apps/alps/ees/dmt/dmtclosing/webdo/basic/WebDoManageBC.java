/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageBC.java
*@FileTitle : DMT_CHG_CALC Table을 업데이트한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011-10-20
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2011-10-07 Kwon Min
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Replanmanage Business Logic Command Interface<br>
 * - ALPS-Replanmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author	Kwon Min
 * @see		IfSchemaVO 
 * @since	J2EE 1.6
 */
public interface WebDoManageBC {

	/**
	 * DMT_CHG_CALC Table Update
	 * @param ifSchemaVO
	 * @return int
	 * @throws EventException
	 */
	public int multiUsDo (IfSchemaVO ifSchemaVO) throws EventException;
	
	/**
	 * DMT_CHG_PRE_CALC Table Select
	 * @param ifSchemaVO
	 * @return ifSchemaVO
	 * @throws EventException
	 */
	public List<IfSchemaVO> searchPrecalOverday (IfSchemaVO ifSchemaVO) throws EventException;
}