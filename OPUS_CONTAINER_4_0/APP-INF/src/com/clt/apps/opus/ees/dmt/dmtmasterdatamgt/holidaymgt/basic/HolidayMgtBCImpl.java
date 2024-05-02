/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HolidayMgtBCImpl.java
*@FileTitle : Holiday by Country Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.integration.HolidayMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.HolidayMgtVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.holidaymgt.vo.Sb45RulingExceptionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * DMTMasterDataMgt Business Logic Basic Command implementation<br>
 *
 * @author
 * @see UI_DMT_1007EventResponse,HolidayMgtBC  DAO class reference
 * @since J2EE 1.4
 */

public class HolidayMgtBCImpl extends BasicCommandSupport implements HolidayMgtBC {

	// Database Access Object
	private transient HolidayMgtDBDAO dbDao = null;

	/**
	 * HolidayMgtBCImpl Create object<br>
	 * HolidayMgtDBDAO를 Creat<br>
	 */
	public HolidayMgtBCImpl() {
		dbDao = new HolidayMgtDBDAO();
	}
	
	/**
	 *  Search detail holidays  information by country. <br>
	 * 
	 * @param HolidayMgtVO holidayMgtVO
	 * @return List<HolidayMgtVO>
	 * @exception EventException
	 */
	public List<HolidayMgtVO> searchHolidayList(HolidayMgtVO holidayMgtVO) throws EventException {
		try {
			return dbDao.searchHolidayList(holidayMgtVO);
		} catch (DAOException ex) {
			// Search condition error meesage  ===================================================================
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
	 * Search holidays type by country.  <br>
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
	 * Search  holidays information by country. <br>
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
	 * manager  holidays information by country. <br> 
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
				
				//1) dateformat change for DB  insert.
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

	/**
	 * retrieve SB45 Ruling Exceptions <br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return List<Sb45RulingExceptionVO>
	 * @exception EventException
	 */
//	public List<Sb45RulingExceptionVO> searchSb45RulingExceptionList(Sb45RulingExceptionVO sb45RulingExceptionVO) throws EventException {
//		try {
//			return dbDao.searchSb45RulingExceptionList(sb45RulingExceptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("DMT00006").getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
// 			throw new EventException(ex.getMessage(),ex);
// 		}
//	}
	
	/**
	 * manage SB45 Ruling Exceptions <br> 
	 * 
	 * @param Sb45RulingExceptionVO[] sb45RulingExceptionVOs
	 * @param SignOnUserAccount account
	 * @return Sb45RulingExceptionVO
	 * @exception EventException
	 */
//	public Sb45RulingExceptionVO modifySb45RulingException(Sb45RulingExceptionVO[] sb45RulingExceptionVOs, SignOnUserAccount account) throws EventException {
//		Sb45RulingExceptionVO vo = null;
//		try {
//			List<Sb45RulingExceptionVO> 	insertVoList 	= new ArrayList<Sb45RulingExceptionVO>();
//			List<Sb45RulingExceptionVO> 	updateVoList 	= new ArrayList<Sb45RulingExceptionVO>();
//			List<Sb45RulingExceptionVO> 	deleteVoList 	= new ArrayList<Sb45RulingExceptionVO>();
//			
//			for (int i = 0 ; i < sb45RulingExceptionVOs .length ; i++) {
//				sb45RulingExceptionVOs[i].setCreUsrId(account.getUsr_id());
//				sb45RulingExceptionVOs[i].setUpdUsrId(account.getUsr_id());
//				if (sb45RulingExceptionVOs[i].getIbflag().equals("I")) {
//					insertVoList.add(sb45RulingExceptionVOs[i]);
//				} else if (sb45RulingExceptionVOs[i].getIbflag().equals("U")) {
//					updateVoList.add(sb45RulingExceptionVOs[i]);
//				} else if (sb45RulingExceptionVOs[i].getIbflag().equals("D")) {
//					deleteVoList.add(sb45RulingExceptionVOs[i]);
//				}
//			}
//
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeSb45RulingException(deleteVoList);
//			}
//
//			if ( updateVoList.size() > 0 ) {
//				vo = dbDao.updateSb45RulingException(updateVoList);
//				if(vo != null) // dup exists
//					return vo;
//			}
//			
//			if ( insertVoList.size() > 0 ) {
//				vo = dbDao.updateSb45RulingException(insertVoList);
//				if(vo != null) // dup exists
//					return vo;
//			}
//		} catch (DAOException de) {
//			throw new EventException(new ErrorHandler("DMT00003").getMessage());
//		} catch (Exception de) {
//			throw new EventException(new ErrorHandler("DMT00003").getMessage());		
//		}
//		return vo;
//	}

	/**
	 * retrieve SB45 Ruling Exceptions Dup Check <br> 
	 * 
	 * @param Sb45RulingExceptionVO sb45RulingExceptionVO
	 * @return Sb45RulingExceptionVO
	 * @exception EventException
	 */
//	public Sb45RulingExceptionVO searchSb45RulingExceptionDupCheck(Sb45RulingExceptionVO sb45RulingExceptionVO) throws EventException {
//		try {
//			return dbDao.searchSb45RulingExceptionDupCheck(sb45RulingExceptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("DMT00006").getMessage());
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
// 			throw new EventException(ex.getMessage(),ex);
// 		}
//	}
}
