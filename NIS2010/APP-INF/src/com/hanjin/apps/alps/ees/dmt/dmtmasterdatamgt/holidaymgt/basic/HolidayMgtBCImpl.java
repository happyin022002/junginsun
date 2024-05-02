/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtBCImpl.java
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

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.integration.HolidayMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTMasterDataMgt Business Logic Basic Command implementation<br>
 * - NIS2010-DMTMasterDataMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SungHoon, Lee
 * @see UI_DMT_1007EventResponse,HolidayMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class HolidayMgtBCImpl extends BasicCommandSupport implements HolidayMgtBC {

	// Database Access Object
	private transient HolidayMgtDBDAO dbDao = null;

	/**
	 * HolidayMgtBCImpl 객체 생성<br>
	 * HolidayMgtDBDAO를 생성한다.<br>
	 */
	public HolidayMgtBCImpl() {
		dbDao = new HolidayMgtDBDAO();
	}
	
	/**
	 * 등록된 국가들의 상세 휴일정보를 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayList(HolidayMgtVO holidayMgtVO) throws EventException {
		try {
			return dbDao.searchHolidayList(holidayMgtVO);
		} catch (DAOException ex) {
			//에러메시지창에 보여줄 입력조회조건 값 ===================================================================
			StringBuffer sbErrMsg = new StringBuffer();
			sbErrMsg.append("[Country: ").append(holidayMgtVO.getCntCd()).append("] ");
			if ("CA".equals(holidayMgtVO.getCntCd()) || "US".equals(holidayMgtVO.getCntCd())) {
				sbErrMsg.append("[State: ").append(holidayMgtVO.getSteCd()).append("] ");
			}
			else {
				sbErrMsg.append("[Region: ").append(holidayMgtVO.getRgnCd()).append("] ");
			}
			sbErrMsg.append("[Location: ").append(holidayMgtVO.getLocCd()).append("] ");
			sbErrMsg.append("[Year: ").append(holidayMgtVO.getHolYr()).append("]");
			//====================================================================================================
			throw new EventException(new ErrorHandler("DMT00006", new String[]{sbErrMsg.toString()}).getMessage());
		}
	}
	
	/**
	 * 국가별로 휴일타입을 조회 합니다. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return String
	 * @exception EventException
	 */
	public String searchWeekendTypeByCountry(HolidayMgtVO holidayMgtVO) throws EventException {
		try {
			return dbDao.searchWeekendTypeByCountry(holidayMgtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	
	/**
	 * 등록된 국가들의 휴일정보를 조회 합니다. <br>
	 * 
	 * @param holidaymgtvo   HolidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */	
	public List<HolidayMgtVO> searchHolidayCountList(HolidayMgtVO holidayMgtVO) throws EventException {
		try {
			return dbDao.searchHolidayCountList(holidayMgtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("DMT00006").getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
 			throw new EventException(ex.getMessage(),ex);
 		}
	}
	
	/**
	 * 국가들의 휴일정보를 생성, 수정, 삭제 합니다. <br> 
	 * 
	 * @param HolidayMgtVO[] holidayMgtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageHoliday(HolidayMgtVO[] holidayMgtVOs, SignOnUserAccount account) throws EventException{
		
		try {
			List<HolidayMgtVO> 	insertVoList 	= new ArrayList<HolidayMgtVO>();
			List<HolidayMgtVO> 	deleteVoList 	= new ArrayList<HolidayMgtVO>();
			StringBuffer 		holiday 		= null;
			String 				date 			= null;
			String 				month 			= null;
			String[] 			monthOfYears 	= { "JAN", "FEB", "MAR", "APR",	"MAY", "JUN", "JUL", "AUG",	"SEP", "OCT", "NOV", "DEC" };
			
			for (int i = 0 ; i < holidayMgtVOs .length ; i++) {
				
				//1) DB 입력시 입력받은 날짜형식을 DB 형식으로 변경해준다.
				holiday = new StringBuffer();
				date 	= holidayMgtVOs[i].getHolDtIn().substring(0, 2);
				month 	= holidayMgtVOs[i].getHolDtIn().substring(2);
				
				holiday.append(holidayMgtVOs[i].getHolYr());
				for (int j = 0 ; j < monthOfYears.length ; j++) {
					if (monthOfYears[j].equals(month)) {
						if (j < 9) {
							holiday.append("0");
						}
						holiday.append(j+1);
						break;
					}
				}
				holiday.append(date);
				holidayMgtVOs[i].setHolDtIn(holiday.toString());
				holidayMgtVOs[i].setCreUsrId(account.getUsr_id());
				holidayMgtVOs[i].setCreOfcCd(account.getOfc_cd());
				
				if (holidayMgtVOs[i].getIbflag().equals("I")){
					
					insertVoList.add(holidayMgtVOs[i]);
				} 
				else if (holidayMgtVOs[i].getIbflag().equals("D")){
				
					deleteVoList.add(holidayMgtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addHoliday(insertVoList);
			}

			if ( deleteVoList.size() > 0 ) {
				dbDao.removeHoliday(deleteVoList);
			}
		} 
		catch (DAOException de) {
			throw new EventException(new ErrorHandler("DMT00003").getMessage());
		} 
		catch (Exception de) {
			throw new EventException(new ErrorHandler("DMT00003").getMessage());		
		}
	}
}