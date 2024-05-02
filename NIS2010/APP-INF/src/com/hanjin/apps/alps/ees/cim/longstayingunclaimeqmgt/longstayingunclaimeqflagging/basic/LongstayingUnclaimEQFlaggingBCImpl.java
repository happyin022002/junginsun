/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingBCImpl.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치.
*                   List<VO >공백제거 
* 2012.09.19 신자영 [CHM-201220003-01] L/S U/C CREATION - COR DRAFT 기능 개발
* 
* 2014.04.07 김창영 [HJSBIZ_CR_45] 장비 과부족현황 Mailing 기능개발
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration.LongstayingUnclaimEQFlaggingDBDAO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.EQBalanceReportInputListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.MailingServiceSettingListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CimEqSplsDfctEmlVO;
import com.hanjin.syscommon.common.table.CimEqSplsDfctStsVO;

/**
 * ALPS-LongstayingUnclaimEQMgt Business Logic Basic Command implementation<br>
 * - ALPS-LongstayingUnclaimEQMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kim jong jun 
 * @see EES_CIM_0021EventResponse,LongstayingUnclaimEQFlaggingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class LongstayingUnclaimEQFlaggingBCImpl extends BasicCommandSupport implements LongstayingUnclaimEQFlaggingBC {

	// Database Access Object
	private transient LongstayingUnclaimEQFlaggingDBDAO dbDao = null;

	/**
	 * LongstayingUnclaimEQFlaggingBCImpl 객체 생성<br>
	 * LongstayingUnclaimEQFlaggingDBDAO를 생성한다.<br>
	 */
	public LongstayingUnclaimEQFlaggingBCImpl() {
		dbDao = new LongstayingUnclaimEQFlaggingDBDAO();
	}

	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysListSmryVO> 
	 * @exception EventException 
	 */
	public List<SDaysListSmryVO> searchSDaysListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			StringBuffer sccDateStrBuf = new StringBuffer();
			for ( int i=0; i<sDaysListSmryVOS.size(); i++ ) {
				sccDateStrBuf.append(sDaysListSmryVOS.get(i).getDateStr());
			}
			flaggingSDaysOptionVO.setQueryStr(sccDateStrBuf.toString());
			return dbDao.searchSDaysListSmry(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Summary) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Summary) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,MVMT Status 별, EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysListSmryVO> 
	 * @exception EventException 
	 */
	public List<SDaysListSmryVO> searchSDaysListByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			StringBuffer sccDateStrBuf = new StringBuffer();
			for ( int i=0; i<sDaysListSmryVOS.size(); i++ ) {
				sccDateStrBuf.append(sDaysListSmryVOS.get(i).getDateStr());
			}
			
			flaggingSDaysOptionVO.setQueryStr(sccDateStrBuf.toString());
			return dbDao.searchSDaysListByMvmt(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (by MVMT) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (by MVMT) Retrieve"}).getMessage(),ex);
			//throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysListSmryVO> 
	 * @exception EventException 
	 */
	public List<SDaysListSmryVO> searchSDaysListTotalDays(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			return dbDao.searchSDaysListTotalDays(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days(by Total S/Days) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days(by Total S/Days) Retrieve"}).getMessage(),ex);

		}
	}

	/**
	 *  Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysLisDetailVO> 
	 * @exception EventException 
	 */
	public List<SDaysLisDetailVO> searchSDaysListDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			String loc_type_code = flaggingSDaysOptionVO.getLocTypeCode();
			String loc_cd = flaggingSDaysOptionVO.getLocCd();
			if ( flaggingSDaysOptionVO.getLocTypeCode().equals("") ) {	//Location by 값이 없을시 조건은 RCC_CD 조건으로 RCC_DATE값을 찾는다.
				flaggingSDaysOptionVO.setLocTypeCode("1");
				flaggingSDaysOptionVO.setLocCd(flaggingSDaysOptionVO.getSubLocCd());
			}
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setLocTypeCode(loc_type_code);
			flaggingSDaysOptionVO.setLocCd(loc_cd);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			
			return dbDao.searchSDaysListDetail(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 *  컨테이너 번호별로 Total S/Days의 체류일수를 CNTR MVMT Status별 체류일수를 집계하여 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysLisDetailVO> 
	 * @exception EventException 
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			return dbDao.searchSDaysListTotalDaysByMvmt(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (by MVMT Status) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (by MVMT Status) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 *  “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<SDaysLisDetailVO> 
	 * @exception EventException 
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			return dbDao.searchSDaysListTotalDaysDetail(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (Detail) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (Detail) Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 COR Draft를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchCorDraft(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
			return dbDao.searchCorDraft(flaggingSDaysOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"COR Draft Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"COR Draft Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * RCV/DEL list를 조회한다.<br>
	 * 
	 * @param String pCode 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchRcvDelCodeBasic(String pCode) throws EventException {
		try {
			return dbDao.searchRcvDelCodeData(pCode);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"RCV/DEL list"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"RCV/DEL list"}).getMessage(),ex);
		}
	}
	
	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<LongStayUclmDetailVO> 
	 * @exception EventException 
	 */
	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			String  locTypeCode = flaggingSDaysOptionVO.getLocTypeCode();
			
			if(!flaggingSDaysOptionVO.getLocCd().equals("")){
				if ( flaggingSDaysOptionVO.getLocTypeCode().equals("1") ) {	   //lcc
					flaggingSDaysOptionVO.setLocTypeCode("2");
				} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("2") ) {	   //ecc
					flaggingSDaysOptionVO.setLocTypeCode("4");
				} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("3") ) {	   //scc
					flaggingSDaysOptionVO.setLocTypeCode("5");
				}else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("4") ) {	   //scc
					flaggingSDaysOptionVO.setLocTypeCode("1");
				}
				List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
				flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
				
				flaggingSDaysOptionVO.setLocTypeCode(locTypeCode);				
			}

			return dbDao.searchFlaggingTargetList(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 * 
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFlagging(LongStayUclmDetailVO[] longStayUclmDetailVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<LongStayUclmDetailVO> longStayUclmDetailVOS = new ArrayList<LongStayUclmDetailVO>();

			if(longStayUclmDetailVOs != null) {
				for ( int i=0; i<longStayUclmDetailVOs.length; i++ ) {
					String uclmLsDivCd = "";
					String dispFlg = "N";
					String dmgFlg = "N";
					if (longStayUclmDetailVOs[i].getLsFlg().equals("1")) {
						uclmLsDivCd = "L";
					}
					if (longStayUclmDetailVOs[i].getUcFlg().equals("1")) {
						uclmLsDivCd = "U";
					}

					if (longStayUclmDetailVOs[i].getDispFlg().equals("1")) {
						dispFlg = "Y";
					} 

					if (longStayUclmDetailVOs[i].getDmgFlg().equals("1")) {
						dmgFlg = "Y";
					} 
					if ( uclmLsDivCd.equals("") ) {
						longStayUclmDetailVOs[i].setUclmRsn("");
					}

					longStayUclmDetailVOs[i].setUclmLsDivCd(uclmLsDivCd);
					longStayUclmDetailVOs[i].setDispFlg(dispFlg);
					longStayUclmDetailVOs[i].setDmgFlg(dmgFlg);
					longStayUclmDetailVOs[i].setCreUsrId(account.getUsr_id());
					longStayUclmDetailVOs[i].setUpdUsrId(account.getUsr_id());
					longStayUclmDetailVOS.add(longStayUclmDetailVOs[i]);
				}
			}
			
			if ( longStayUclmDetailVOS.size() > 0 ) {
				dbDao.addFlagging(longStayUclmDetailVOS);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (EventException de) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);

		}
	}

	/**
	 * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
	 * @return List<FlaggingListSmryVO>
	 * @exception EventException
	 */
	public List<FlaggingListSmryVO> searchFlaggingStatusListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException {
		try {
			return  dbDao.searchFlaggingStatusListSmry(flaggingSDaysOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S Flag Status Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S Flag Status Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<CntrFdayListVO> searchCntrFdayList(InvtOptionVO invtOptionVO) throws EventException {
		try { 
			List<InvtCntrListVO> invtCntrListVOS = dbDao.searchRccDateList(invtOptionVO);
			invtOptionVO.setRccDate(invtCntrListVOS.get(0).getRccDate());
			invtOptionVO.setRccCd(invtCntrListVOS.get(0).getRccCd());
			
			return dbDao.searchCntrFdayList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
	}		
	
	/**
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO  
	 * @return List<OPInventoryForPseudoBookingSummayVO> 
	 * @exception EventException 
	 */
	public List<OPInventoryForPseudoBookingSummayVO> searchOPInventoryForPseudoBookingList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException {
		try {
			return dbDao.searchOPInventoryForPseudoBookingList(oPInventoryForPseudoBookingOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO  
	 * @return List<OPInventoryForPseudoBookingSummayVO> 
	 * @exception EventException 
	 */
	public List<OPInventoryForPseudoBookingDetailVO> searchOPInventoryForPseudoBookingDetailList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException {
		try {
			return dbDao.searchOPInventoryForPseudoBookingDetailList(oPInventoryForPseudoBookingOptionVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060 : Retrieve<br>
	 * EQ Balance Report Input.<br>
	 * 
	 * @param String rhqCd
	 * @param String periodWeek
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String eccCd
	 * @return List<EQBalanceReportInputListVO>
	 * @exception EventException
	 */
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInputList(String rhqCd, String periodWeek, String scontiCd, String lccCd, String eccCd) throws EventException {
		try {
			return dbDao.mainSearchEQBalanceReportInputList(rhqCd, periodWeek, scontiCd, lccCd, eccCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0061 : Retrieve<br>
	 * EQ Balance Report Inquiry.<br>
	 * 
	 * @param String rhqCd
	 * @param String fmWeek
	 * @param String toWeek
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String eccCd
	 * @return List<EQBalanceReportInputListVO>
	 * @exception EventException
	 */
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInquiryList(String rhqCd, String fmWeek, String toWeek, String scontiCd, String lccCd, String eccCd) throws EventException {
		try {
			return dbDao.mainSearchEQBalanceReportInquiryList(rhqCd, fmWeek, toWeek, scontiCd, lccCd, eccCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchLclHqOfcCd() throws EventException{
		try {
			return dbDao.searchLclHqOfcCd();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchGlblhqOfcCd() throws EventException{
		try {
			return dbDao.searchGlblhqOfcCd();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @param String ofcCd
	 * @param String pageType
	 * @return String
	 * @exception EventException
	 */
	public String searchHdQtrByOfcCd(String ofcCd, String pageType) throws EventException{
		try {
			return dbDao.searchHdQtrByOfcCd(ofcCd, pageType);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchNowWeek() throws EventException{
		try {
			return dbDao.searchNowWeek();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchLastWeek() throws EventException{
		try {
			return dbDao.searchLastWeek();
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Sub-Conti Code Retrieve<br>
	 * For Setting Sub-Conti Code<br>
	 * 
	 * @param String rhqCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSubContiCd(String rhqCd) throws EventException{
		try {
			return dbDao.searchSubContiCd(rhqCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : LCC Code Retrieve<br>
	 * For Setting LCC Code<br>
	 * 
	 * @param String scontiCd
	 * @param String rhqCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLccCd(String scontiCd, String rhqCd) throws EventException {
		try {
			return dbDao.searchLccCd(scontiCd, rhqCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : ECC Code Retrieve<br>
	 * For Setting ECC Code<br>
	 * 
	 * @param String scontiCd
	 * @param String lccCd
	 * @param String rhqCd
	 * @return String
	 * @exception EventException
	 */
	public String searchEccCd(String scontiCd, String lccCd, String rhqCd) throws EventException {
		try {
			return dbDao.searchEccCd(scontiCd, lccCd, rhqCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0060 : Save<br>
	 * 
	 * @param CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEQBalanceReportInput(CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs, SignOnUserAccount account) throws EventException {
		try {
			
			List<CimEqSplsDfctStsVO> selcimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
			List<CimEqSplsDfctStsVO> insCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
			List<CimEqSplsDfctStsVO> updCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
			List<CimEqSplsDfctStsVO> delCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();

			if(cimEqSplsDfctStsVOs != null) {
				for ( int i=0; i<cimEqSplsDfctStsVOs.length; i++ ) {
					
					selcimEqSplsDfctStsVOs = dbDao.searchEqSplsDfctSts(cimEqSplsDfctStsVOs[i]);
					
					/* 조회된 데이터가 존재, 조회값과 화면전달값이 서로 같다 -> skip
					 * 조회된 데이터가 존재, 조회값과 화면전달값이 서로 SPLS_DFCT_STS_CTNT 또는 STS_RMK가 틀리다 -> update
					 * 조회된 데이터가 존재, 화면전달값의 SPLS_DFCT_STS_CTNT가 없다 -> delete
					 * 조회된 데이터가 없다, 화면전달값의 SPLS_DFCT_STS_CTNT가 있다 -> insert
					 */
					
					// 조회된 데이터가 없다, 화면전달값의 SPLS_DFCT_STS_CTNT가 있다 -> insert
					if (selcimEqSplsDfctStsVOs.size() == 0 && !cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt().isEmpty()) {
						
						cimEqSplsDfctStsVOs[i].setCreUsrId(account.getUsr_id());
						cimEqSplsDfctStsVOs[i].setUpdUsrId(account.getUsr_id());
						// add insert VO
						insCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
					} 
					// 조회된 데이터가 존재
					else if(selcimEqSplsDfctStsVOs.size() > 0) {
						
						// 화면전달값의 SPLS_DFCT_STS_CTNT가 없다 -> delete
						if(cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt().isEmpty()) {
							// add delete VO
							delCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
						} else {
							// 조회값과 화면전달값이 서로 SPLS_DFCT_STS_CTNT 또는 STS_RMK가 틀리다 -> update
							if( (selcimEqSplsDfctStsVOs.get(0).getSplsDfctStsCtnt().equals(cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt())) 
								|| (selcimEqSplsDfctStsVOs.get(0).getStsRmk().equals(cimEqSplsDfctStsVOs[i].getStsRmk())) ) {
								
								cimEqSplsDfctStsVOs[i].setUpdUsrId(account.getUsr_id());
								// add update VO
								updCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
							}
							
						}
					}
				}
			}
			
			if ( insCimEqSplsDfctStsVOs.size() > 0 ) {
				dbDao.addEqSplsDfctSts(insCimEqSplsDfctStsVOs);
			}
			
			if ( updCimEqSplsDfctStsVOs.size() > 0 ) {
				dbDao.mdfyEqSplsDfctSts(updCimEqSplsDfctStsVOs);
			}
			
			if ( delCimEqSplsDfctStsVOs.size() > 0 ) {
				dbDao.delEqSplsDfctSts(delCimEqSplsDfctStsVOs);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
	/**
	 * EES_CIM_0062 PreSearch before Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @return int cntByUsrId
	 * @exception EventException
	 */
	public int cntOfCimEqSplsDfctEmlByUsrId(String usrId) throws EventException {
		int cntByUsrId = 0;
		
		try {
			// PreSearch before Retrieve
			cntByUsrId = dbDao.cntOfCimEqSplsDfctEmlByUsrId(usrId);
			
			return cntByUsrId;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0062 Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @param int cnt
	 * @return List<MailingServiceSettingListVO>
	 * @exception EventException
	 */
	public List<MailingServiceSettingListVO> mainSearchMailingServiceSettingList(String usrId, int cnt) throws EventException {
		
		List<MailingServiceSettingListVO> list = new ArrayList<MailingServiceSettingListVO>();
		
		try {
			
			if(cnt == 0) {
				list = dbDao.mainSearchMailingServiceSettingListFromMdm();
			}else {
				list = dbDao.mainSearchMailingServiceSettingListByUnion(usrId);
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0062 : Save<br>
	 * 
	 * @param MailingServiceSettingListVO[] mailingServiceSettingListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMailingServiceSetting(MailingServiceSettingListVO[] mailingServiceSettingListVOs, SignOnUserAccount account) throws EventException {
		
		try {
			
			List<CimEqSplsDfctEmlVO> insertVoList = new ArrayList<CimEqSplsDfctEmlVO>();
			CimEqSplsDfctEmlVO list = null;
			
			dbDao.delMailingServiceSetting(account.getUsr_id());
			
			if (mailingServiceSettingListVOs != null) {
				
				if(mailingServiceSettingListVOs.length > 0) {
					for ( int i=0; i<mailingServiceSettingListVOs.length; i++ ) {
						list = new CimEqSplsDfctEmlVO();
						
						list.setUsrId(account.getUsr_id());
						list.setCreUsrId(account.getUsr_id());
						list.setUpdUsrId(account.getUsr_id());
						list.setCntCd(mailingServiceSettingListVOs[i].getCntCd());
						
							insertVoList.add(list);
					}
				}
				
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMailingServiceSetting(insertVoList);				
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
	    }
	}
	
}