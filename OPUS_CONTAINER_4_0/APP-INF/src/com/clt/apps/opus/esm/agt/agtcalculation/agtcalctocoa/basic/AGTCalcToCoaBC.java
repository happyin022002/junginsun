/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTCalcToCoaBC.java
 *@FileTitle : Agent Monthly Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 추경원
 *@LastVersion : 1.0
 * 2009.09.16 추경원
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.agtcalctocoa.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-AGTCalculation Business Logic Basic Command<br>
 * - OPUS-AGTCalculation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyung-won Chu
 * @see 
 * @since J2EE 1.6
 */
public interface AGTCalcToCoaBC {

	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param bkg_no String
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createAgentComm(String bkg_no) throws EventException;

	/**
	 * Agent Commission CM Calculation 처리<br>
	 * createAgentComm()에서 계산된 커미션금액에 대한 평균단가를 COA_COM_COST_PARA 테이블에 update 한다.
	 * @param receive_cd String
	 * @return int(0 : 정상처리, -1 : 에러)
	 * @exception EventException
	 */
	public int createCMComm(String receive_cd) throws EventException;

}