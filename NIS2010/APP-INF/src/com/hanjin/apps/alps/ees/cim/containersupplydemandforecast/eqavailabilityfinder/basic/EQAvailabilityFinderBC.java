/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQAvailabilityFinderBC.java
*@FileTitle : EQ Availability
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailDetailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.eqavailabilityfinder.vo.AvailRepoListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Containersupplydemandforecast Business Logic Command Interface<br>
 * - ALPS-Containersupplydemandforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_0034EventResponse 참조
 * @since J2EE 1.4
 */

public interface EQAvailabilityFinderBC {
	

	/**
	 * 조회일로부터 2Week 기간의 가용 MTY 수량을 Yard, Daily별로 조회 <br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return List<AvailListVO>
	 * @exception EventException
	 */
	public List<AvailListVO> searchAvailList(AvailOptionVO availOptionVO) throws EventException;

	
	/**
	 * EQR의 MTY BKG정보 및 Inland 구간의 MTY 이송계획을 조회한다. <br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailRepoListVO[]
	 * @exception EventException
	 */
	public AvailRepoListVO[] searchAvailRepoList(AvailOptionVO availOptionVO) throws EventException;
	
	/**
	 * 예정 MTY Pick-up 일자가 지난 BR(Booking 정보)를 조회한다. <br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPastBRList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * BR(Booking Reserved)의 Detail한 BKG 정보를 조회한다.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailBRList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * 금일 Pick-up된(PUP, Picked Up) 컨테이너 수량을 조회한다.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailPickUpList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * IG(I/B MTY Generation) 예측수량을 Detail하게 조회.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailIGList(AvailOptionVO availOptionVO) throws EventException;	

	/**
	 * 금일 MTY Returned 컨테이너 수량을 확인하는 화면.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailRTNList(AvailOptionVO availOptionVO) throws EventException;	
	
	/**
	 * Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailOFFList(AvailOptionVO availOptionVO) throws EventException;	
	
	/**
	 * Off-hire 계획 및 실적(조회당일)의 Detail 정보를 확인.<br>
	 * 
	 * @param AvailOptionVO availOptionVO
	 * @return AvailDetailListVO[]
	 * @exception EventException
	 */
	public AvailDetailListVO[] searchAvailONList(AvailOptionVO availOptionVO) throws EventException;	

}