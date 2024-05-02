/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtBC.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.Sb45RulingExceptionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Dmtmasterdatamgt Business Logic Command Interface<br>
 * 
 * @author
 * @see Ui_dmt_1007EventResponse reference
 * @since J2EE 1.4
 */

public interface HolidayMgtBC {
	
	/**
	 * Search detail holidays information by country.  <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayList(HolidayMgtVO holidayMgtVO) throws EventException;

	/**
	 * Search holidays type by country.  <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return String
	 * @exception EventException
	 */
	public String searchWeekendTypeByCountry(HolidayMgtVO holidayMgtVO) throws EventException;

	/**
	 * Search  holidays information by country.  <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayCountList(HolidayMgtVO holidayMgtVO) throws EventException;		

	/**
	 * manager  holidays information by country. <br> 
	 * 
	 * @param HolidayMgtVO[] holidayMgtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHoliday(HolidayMgtVO[] holidayMgtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve SB45 Ruling Exceptions <br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return List<Sb45RulingExceptionVO>
	 * @exception EventException
	 */
//	public List<Sb45RulingExceptionVO> searchSb45RulingExceptionList(Sb45RulingExceptionVO sb45RulingExceptionVO) throws EventException;
	
	/**
	 * manage SB45 Ruling Exceptions <br> 
	 * 
	 * @param Sb45RulingExceptionVO[] sb45RulingExceptionVOs
	 * @param SignOnUserAccount account
	 * @return Sb45RulingExceptionVO
	 * @exception EventException
	 */
//	public Sb45RulingExceptionVO modifySb45RulingException(Sb45RulingExceptionVO[] sb45RulingExceptionVOs, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve SB45 Ruling Exceptions Dup Check <br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return Sb45RulingExceptionVO
	 * @exception EventException
	 */
//	public Sb45RulingExceptionVO searchSb45RulingExceptionDupCheck(Sb45RulingExceptionVO sb45RulingExceptionVO) throws EventException;
}
