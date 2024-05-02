/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtBC.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Dmtmasterdatamgt Business Logic Command Interface<br>
 * - NIS2010-Dmtmasterdatamgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee
 * @see Ui_dmt_1007EventResponse 참조
 * @since J2EE 1.4
 */

public interface HolidayMgtBC {
	
	/**
	 * 등록된 국가들의 상세 휴일정보를 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayList(HolidayMgtVO holidayMgtVO) throws EventException;

	/**
	 * 국가별로 휴일타입을 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return String
	 * @exception EventException
	 */
	public String searchWeekendTypeByCountry(HolidayMgtVO holidayMgtVO) throws EventException;

	/**
	 * 등록된 국가들의 휴일정보를 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayCountList(HolidayMgtVO holidayMgtVO) throws EventException;		

	/**
	 * 국가들의 휴일정보를 생성, 수정, 삭제 합니다. <br> 
	 * 
	 * @param HolidayMgtVO[] holidayMgtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHoliday(HolidayMgtVO[] holidayMgtVOs, SignOnUserAccount account) throws EventException;
}