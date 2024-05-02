/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CMAGTCalcBC.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-11
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2007-01-11 SangJun Kwon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.cmagtcalc.basic;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SangJun Kwon
 * @see ESM_AGT_035EventResponse 참조
 * @since J2EE 1.4
 */
public interface CMAGTCalcBC  {
		
	/**
	 * Agent Commission CM Calculation 처리<br>
	 * ESM_AGT_007 배치 처리<br>
	 * 
	 * @param String receive_cd
	 * @return int(0 : 정상처리, -1 : 에러)
	 * @exception EventException
	 */
	public int createCMComm(String receive_cd) throws EventException;

}