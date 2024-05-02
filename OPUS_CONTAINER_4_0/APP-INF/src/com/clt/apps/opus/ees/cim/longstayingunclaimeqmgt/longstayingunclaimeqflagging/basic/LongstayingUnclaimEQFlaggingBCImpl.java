/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingBCImpl.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration.LongstayingUnclaimEQFlaggingDBDAO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * LongstayingUnclaimEQMgt Business Logic Basic Command implementation
 * handling LongstayingUnclaimEQMgt business logic
 *
 * @author
 * @see EES_CIM_0021EventResponse,LongstayingUnclaimEQFlaggingBC DAO class reference
 * @since J2EE 1.6
 */
public class LongstayingUnclaimEQFlaggingBCImpl extends BasicCommandSupport implements LongstayingUnclaimEQFlaggingBC {

	// Database Access Object
	private transient LongstayingUnclaimEQFlaggingDBDAO dbDao = null;

	/**
	 * creating LongstayingUnclaimEQFlaggingBCImpl Object
	 * creating LongstayingUnclaimEQFlaggingDBDAO
	 */
	public LongstayingUnclaimEQFlaggingBCImpl() {
		dbDao = new LongstayingUnclaimEQFlaggingDBDAO();
	}

	/**
	 * retrieving long staying Full/ MTY container information by region,EQ TP&SZ
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
				sccDateStrBuf.append("SELECT '"+sDaysListSmryVOS.get(i).getRccCd()+"' RCC_CD, TO_DATE('"+sDaysListSmryVOS.get(i).getRccDate()+"','yyyy-MM-dd HH24:mi:SS') RCC_DATE FROM DUAL");
				if ( sDaysListSmryVOS.size() != i+1 ) {
					sccDateStrBuf.append(" UNION ALL   ");
				}
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
	 * retrieving long staying Full/ MTY container information by region, MVMT Status, EQ TP&SZ
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
				sccDateStrBuf.append("SELECT '"+sDaysListSmryVOS.get(i).getRccCd()+"' RCC_CD, TO_DATE('"+sDaysListSmryVOS.get(i).getRccDate()+"','yyyy-MM-dd HH24:mi:SS') RCC_DATE FROM DUAL");
				if ( sDaysListSmryVOS.size() != i+1 ) {
					sccDateStrBuf.append(" UNION ALL   ");
				}
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
	 * retrieving staying container's movement history, retrieving staying days by region, EQ TP&SZ, MVMT Status
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
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return int
	 * @exception EventException 
	 */
	public int searchSDaysTotalCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException {
		int totalCnt = 0; 
		try { 			
			String loc_type_code = flaggingSDaysOptionVO.getLocTypeCode();
			String loc_cd = flaggingSDaysOptionVO.getLocCd();
			if ( flaggingSDaysOptionVO.getLocTypeCode().equals("") ) {	//Location by 값이 없을시 조건은 RCC_CD 조건으로 RCC_DATE값을 찾는다.
				flaggingSDaysOptionVO.setLocTypeCode("1");
				flaggingSDaysOptionVO.setLocCd(flaggingSDaysOptionVO.getSubLocCd());
			}
			
			if(!"".equals(flaggingSDaysOptionVO.getSubLocCd()) && flaggingSDaysOptionVO.getSubLocCd() != null) {
				List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
				flaggingSDaysOptionVO.setLocTypeCode(loc_type_code);
				flaggingSDaysOptionVO.setLocCd(loc_cd);
				flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			}
			
			totalCnt = dbDao.searchSDaysTotalCnt(flaggingSDaysOptionVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
		
		return totalCnt;
	}
	
	

	/**
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
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
			
			if(!"".equals(flaggingSDaysOptionVO.getSubLocCd()) && flaggingSDaysOptionVO.getSubLocCd() != null) {
				List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
				flaggingSDaysOptionVO.setLocTypeCode(loc_type_code);
				flaggingSDaysOptionVO.setLocCd(loc_cd);
				flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			}
			
			return dbDao.searchSDaysListDetail(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving Total S/Days by EQ by counting EQ staying days for movement status
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
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return int
	 * @exception EventException 
	 */
	public int searchSDaysListTotalDaysCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException {
		int totalCnt = 0; 
		try { 			
			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			totalCnt = dbDao.searchSDaysListTotalDaysCnt(flaggingSDaysOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
		
		return totalCnt;
	}

	/** 
	 * retrieving Total S/Days for EQ including first-in date, yard, current movement and yard information
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
	 * retrieving long staying EQ and unclaim condition EQ information
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return List<LongStayUclmDetailVO> 
	 * @exception EventException 
	 */
	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
		try {
			String  locTypeCode = flaggingSDaysOptionVO.getLocTypeCode();
			
			if ( flaggingSDaysOptionVO.getLocTypeCode().equals("1") ) {	   //lcc
				flaggingSDaysOptionVO.setLocTypeCode("2");
			} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("2") ) {	   //ecc
				flaggingSDaysOptionVO.setLocTypeCode("4");
			} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("3") ) {	   //scc
				flaggingSDaysOptionVO.setLocTypeCode("5");
			}
			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
			
			flaggingSDaysOptionVO.setLocTypeCode(locTypeCode);
			return dbDao.searchFlaggingTargetList(flaggingSDaysOptionVO );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * registering solution plan for long staying EQ and unclaim EQ flag
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
	 * retrieving L/S and U/C flag EQ in L/S & U/C Creation menu
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
	 * retrieving staying container no and related booking information for search date, region
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
}