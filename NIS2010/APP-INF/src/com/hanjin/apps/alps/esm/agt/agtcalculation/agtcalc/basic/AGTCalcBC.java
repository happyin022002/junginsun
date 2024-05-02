/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCalcBC.java
*@FileTitle : Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-18
*@LastModifier : SangJun Kwon
*@LastVersion : 1.0
* 2007-01-18 SangJun Kwon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalc.basic;

import java.util.HashMap;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SangJun Kwon
 * @see 
 * @since J2EE 1.4
 */
public interface AGTCalcBC  {

	/**
	 * 배치 처리<br>
	 * Agent Commission 비 계산 <br>
	 * 
	 * @param bkg_no Booking Number
	 * @return String
	 * @exception EventException
	 */
	public String createAGTComm(String bkg_no) throws EventException;
	
	/**
	 * 배치 처리<br>
	 * Agent Commission 계산 <br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap createAcutalAGTComm(HashMap bkgMap) throws EventException;
	
	/**
	 * 배치 처리<br>
	 * 계산 후 COA에 UPDATE <br>
	 * 
	 * @param String bkg_no
	 * @return int (cost 테이블 update 갯수)
	 * @exception EventException
	 */
	public int createAGTActualCommToCOA(String bkg_no) throws EventException;
	
}