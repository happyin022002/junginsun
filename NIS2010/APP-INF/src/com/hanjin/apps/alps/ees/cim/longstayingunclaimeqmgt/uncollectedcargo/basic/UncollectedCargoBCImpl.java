/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : UncollectedCargoBCImpl.java
*@FileTitle : Uncollected Cargo
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.23
*@LastModifier : 이영두
*@LastVersion : 1.0
* 2015.04.21 이영두
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0064Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0065Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0067Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0071Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration.UncollectedCargoDBDAO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CodeVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.MstCntrVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedCargoFileVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedGlMonXchRtListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedVolDtlListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchApVatSlipListVO;

/**
 * ALPS-LongstayingUnclaimEQMgt Business Logic Basic Command implementation<br>
 * - ALPS-LongstayingUnclaimEQMgt????븳 鍮꾩??덉뒪 濡쒖쭅??泥섎━?쒕떎.<br>
 *
 * @author kim jong jun 
 * @see EES_CIM_0021EventResponse,UncollectedCargoBC 媛?DAO ?대옒??李몄“
 * @since J2EE 1.6
 */
public class UncollectedCargoBCImpl extends BasicCommandSupport implements UncollectedCargoBC {

	// Database Access Object
	private transient UncollectedCargoDBDAO dbDao = null;

	/**
	 * UncollectedCargoBCImpl 媛앹껜 ?앹꽦<br>
	 * LongstayingUnclaimEQFlaggingDBDAO瑜??앹꽦?쒕떎.<br>
	 */
	public UncollectedCargoBCImpl() {
		dbDao = new UncollectedCargoDBDAO();
	}

//	/**
//	 * Full/ MTY 而⑦뀒?대꼫???κ린泥대쪟 ?꾪솴??吏?뿭蹂?EQ TP&SZ蹂꾨줈 泥대쪟 湲곌컙??援щ텇?섏뿬 議고쉶?⑸땲??<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysListSmryVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysListSmryVO> searchSDaysListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			StringBuffer sccDateStrBuf = new StringBuffer();
//			for ( int i=0; i<sDaysListSmryVOS.size(); i++ ) {
//				sccDateStrBuf.append(sDaysListSmryVOS.get(i).getDateStr());
//			}
//			flaggingSDaysOptionVO.setQueryStr(sccDateStrBuf.toString());
//			return dbDao.searchSDaysListSmry(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Summary) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Summary) Retrieve"}).getMessage(),ex);
//		}
//	}
//
//	/**
//	 * Full/ MTY 而⑦뀒?대꼫???κ린泥대쪟 ?꾪솴??吏?뿭蹂?MVMT Status 蹂? EQ TP&SZ蹂꾨줈 泥대쪟 湲곌컙??援щ텇?섏뿬 議고쉶?⑸땲??<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysListSmryVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysListSmryVO> searchSDaysListByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			StringBuffer sccDateStrBuf = new StringBuffer();
//			for ( int i=0; i<sDaysListSmryVOS.size(); i++ ) {
//				sccDateStrBuf.append(sDaysListSmryVOS.get(i).getDateStr());
//			}
//			
//			flaggingSDaysOptionVO.setQueryStr(sccDateStrBuf.toString());
//			return dbDao.searchSDaysListByMvmt(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (by MVMT) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (by MVMT) Retrieve"}).getMessage(),ex);
//			//throw new EventException(ex.getMessage(),ex);
//		}
//	}
//
//	/**
//	 * 議고쉶?쒖젏??泥대쪟?섍퀬 ?덈뒗 而⑦뀒?대꼫??怨쇨굅 MVMT History瑜?議고쉶?섏뿬, 吏?뿭蹂? EQ TP&SZ濡? MVMT Status 瑜?遺꾨쪟?섏뿬 泥대쪟   ?쇱닔瑜?議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysListSmryVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysListSmryVO> searchSDaysListTotalDays(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
//			return dbDao.searchSDaysListTotalDays(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days(by Total S/Days) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			//throw new EventException(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days(by Total S/Days) Retrieve"}).getMessage(),ex);
//
//		}
//	}
//
//	/**
//	 *  Full/ MTY ?κ린泥댄솕 ?λ퉬??BKG 諛?Movement ?뺣낫?깆쓣 而⑦뀒?대꼫 踰덊샇蹂꾨줈 ?쇨큵?곸쑝濡?議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysLisDetailVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysLisDetailVO> searchSDaysListDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			String loc_type_code = flaggingSDaysOptionVO.getLocTypeCode();
//			String loc_cd = flaggingSDaysOptionVO.getLocCd();
//			if ( flaggingSDaysOptionVO.getLocTypeCode().equals("") ) {	//Location by 媛믪씠 ?놁쓣??議곌굔??RCC_CD 議곌굔?쇰줈 RCC_DATE媛믪쓣 李얜뒗??
//				flaggingSDaysOptionVO.setLocTypeCode("1");
//				flaggingSDaysOptionVO.setLocCd(flaggingSDaysOptionVO.getSubLocCd());
//			}
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			flaggingSDaysOptionVO.setLocTypeCode(loc_type_code);
//			flaggingSDaysOptionVO.setLocCd(loc_cd);
//			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
//			
//			return dbDao.searchSDaysListDetail(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			//throw new EventException(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Staying Days (Detail) Retrieve"}).getMessage(),ex);
//		}
//	}
//
//	/**
//	 *  而⑦뀒?대꼫 踰덊샇蹂꾨줈 Total S/Days??泥대쪟?쇱닔瑜?CNTR MVMT Status蹂?泥대쪟?쇱닔瑜?吏묎퀎?섏뿬 議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysLisDetailVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysLisDetailVO> searchSDaysListTotalDaysByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
//			return dbDao.searchSDaysListTotalDaysByMvmt(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (by MVMT Status) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			//throw new EventException(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (by MVMT Status) Retrieve"}).getMessage(),ex);
//		}
//	}
//
//	/**
//	 *  ?쏷otal S/Days???꾪솴??而⑦뀒?대꼫蹂??쒖턀珥덈컲?낆씪???쇰뱶??諛??쒗쁽 MVMT 諛?Yard ?뺣낫?앸벑???ы븿?섏뿬 泥대쪟?쇱닔瑜?議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<SDaysLisDetailVO> 
//	 * @exception EventException 
//	 */
//	public List<SDaysLisDetailVO> searchSDaysListTotalDaysDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
//			return dbDao.searchSDaysListTotalDaysDetail(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (Detail) Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			//throw new EventException(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total S/Days (Detail) Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * ?κ린泥댄솕?λ퉬(L/Staying) 諛?Unclaim ?붽굔 ?λ퉬????븳 COR Draft瑜?議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
//	 * @return List<LongStayUclmDetailVO>
//	 * @exception EventException
//	 */
//	public List<LongStayUclmDetailVO> searchCorDraft(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			flaggingSDaysOptionVO.setTabFlag("3");	 //Total S/Days
//			return dbDao.searchCorDraft(flaggingSDaysOptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"COR Draft Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"COR Draft Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * ?κ린泥댄솕?λ퉬(L/Staying) 諛?Unclaim ?붽굔 ?λ퉬????븳 ?쒕컲 ?뺣낫瑜?議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
//	 * @return List<LongStayUclmDetailVO> 
//	 * @exception EventException 
//	 */
//	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException {
//		try {
//			String  locTypeCode = flaggingSDaysOptionVO.getLocTypeCode();
//			
//			if ( flaggingSDaysOptionVO.getLocTypeCode().equals("1") ) {	   //lcc
//				flaggingSDaysOptionVO.setLocTypeCode("2");
//			} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("2") ) {	   //ecc
//				flaggingSDaysOptionVO.setLocTypeCode("4");
//			} else if ( flaggingSDaysOptionVO.getLocTypeCode().equals("3") ) {	   //scc
//				flaggingSDaysOptionVO.setLocTypeCode("5");
//			}
//			List<SDaysListSmryVO> sDaysListSmryVOS = dbDao.searchRccDateList(flaggingSDaysOptionVO);
//			flaggingSDaysOptionVO.setRccDate(sDaysListSmryVOS.get(0).getRccDate());
//			
//			flaggingSDaysOptionVO.setLocTypeCode(locTypeCode);
//			return dbDao.searchFlaggingTargetList(flaggingSDaysOptionVO );
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			//throw new EventException(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * ?κ린泥댄솕?λ퉬(L/Staying) 諛?Unclaim ?λ퉬 Flag ???댁냼 諛⑹븞???깅줉?쒕떎.<br>
//	 * 
//	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageFlagging(LongStayUclmDetailVO[] longStayUclmDetailVOs, SignOnUserAccount account) throws EventException
//	{
//		try {
//			List<LongStayUclmDetailVO> longStayUclmDetailVOS = new ArrayList<LongStayUclmDetailVO>();
//
//			if(longStayUclmDetailVOs != null) {
//				for ( int i=0; i<longStayUclmDetailVOs.length; i++ ) {
//					String uclmLsDivCd = "";
//					String dispFlg = "N";
//					String dmgFlg = "N";
//					if (longStayUclmDetailVOs[i].getLsFlg().equals("1")) {
//						uclmLsDivCd = "L";
//					}
//					if (longStayUclmDetailVOs[i].getUcFlg().equals("1")) {
//						uclmLsDivCd = "U";
//					}
//
//					if (longStayUclmDetailVOs[i].getDispFlg().equals("1")) {
//						dispFlg = "Y";
//					} 
//
//					if (longStayUclmDetailVOs[i].getDmgFlg().equals("1")) {
//						dmgFlg = "Y";
//					} 
//					if ( uclmLsDivCd.equals("") ) {
//						longStayUclmDetailVOs[i].setUclmRsn("");
//					}
//
//					longStayUclmDetailVOs[i].setUclmLsDivCd(uclmLsDivCd);
//					longStayUclmDetailVOs[i].setDispFlg(dispFlg);
//					longStayUclmDetailVOs[i].setDmgFlg(dmgFlg);
//					longStayUclmDetailVOs[i].setCreUsrId(account.getUsr_id());
//					longStayUclmDetailVOs[i].setUpdUsrId(account.getUsr_id());
//					longStayUclmDetailVOS.add(longStayUclmDetailVOs[i]);
//				}
//			}
//			
//			if ( longStayUclmDetailVOS.size() > 0 ) {
//				dbDao.addFlagging(longStayUclmDetailVOS);
//			}
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (EventException de) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S & U/C Creation Create"}).getMessage(),de);
//
//		}
//	}
//
//	/**
//	 * L/S & U/C Creation?붾㈃?먯꽌 Flag??L/S 諛?U/C ?λ퉬???꾪솴??議고쉶?쒕떎.<br>
//	 * 
//	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO 
//	 * @return List<FlaggingListSmryVO>
//	 * @exception EventException
//	 */
//	public List<FlaggingListSmryVO> searchFlaggingStatusListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException {
//		try {
//			return  dbDao.searchFlaggingStatusListSmry(flaggingSDaysOptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S Flag Status Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"L/S Flag Status Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * 議고쉶?쒖젏 湲곗?, 吏?뿭蹂꾨줈 ?뚯옱?섍퀬 ?덈뒗 而⑦뀒?대꼫 ?섎쾭 諛?愿?젴 Booking 諛??λ퉬愿?━ ?뺣낫瑜?議고쉶<br>
//	 * 
//	 * @param InvtOptionVO invtOptionVO
//	 * @return List<InvtCntrListVO>
//	 * @exception EventException
//	 */
//	public List<CntrFdayListVO> searchCntrFdayList(InvtOptionVO invtOptionVO) throws EventException {
//		try { 
//			List<InvtCntrListVO> invtCntrListVOS = dbDao.searchRccDateList(invtOptionVO);
//			invtOptionVO.setRccDate(invtCntrListVOS.get(0).getRccDate());
//			invtOptionVO.setRccCd(invtCntrListVOS.get(0).getRccCd());
//			
//			return dbDao.searchCntrFdayList(invtOptionVO);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
//		}
//	}		
//	
//	/**
//	 * OP Inventory for Pseudo Booking.<br>
//	 * 
//	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO  
//	 * @return List<OPInventoryForPseudoBookingSummayVO> 
//	 * @exception EventException 
//	 */
//	public List<OPInventoryForPseudoBookingSummayVO> searchOPInventoryForPseudoBookingList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException {
//		try {
//			return dbDao.searchOPInventoryForPseudoBookingList(oPInventoryForPseudoBookingOptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * OP Inventory for Pseudo Booking.<br>
//	 * 
//	 * @param OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO  
//	 * @return List<OPInventoryForPseudoBookingSummayVO> 
//	 * @exception EventException 
//	 */
//	public List<OPInventoryForPseudoBookingDetailVO> searchOPInventoryForPseudoBookingDetailList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException {
//		try {
//			return dbDao.searchOPInventoryForPseudoBookingDetailList(oPInventoryForPseudoBookingOptionVO);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM00011", new String[]{"OP Inventory for Pseudo Booking Retrieve"}).getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060 : Retrieve<br>
//	 * EQ Balance Report Input.<br>
//	 * 
//	 * @param String rhqCd
//	 * @param String periodWeek
//	 * @param String scontiCd
//	 * @param String lccCd
//	 * @param String eccCd
//	 * @return List<EQBalanceReportInputListVO>
//	 * @exception EventException
//	 */
//	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInputList(String rhqCd, String periodWeek, String scontiCd, String lccCd, String eccCd) throws EventException {
//		try {
//			return dbDao.mainSearchEQBalanceReportInputList(rhqCd, periodWeek, scontiCd, lccCd, eccCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0061 : Retrieve<br>
//	 * EQ Balance Report Inquiry.<br>
//	 * 
//	 * @param String rhqCd
//	 * @param String fmWeek
//	 * @param String toWeek
//	 * @param String scontiCd
//	 * @param String lccCd
//	 * @param String eccCd
//	 * @return List<EQBalanceReportInputListVO>
//	 * @exception EventException
//	 */
//	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInquiryList(String rhqCd, String fmWeek, String toWeek, String scontiCd, String lccCd, String eccCd) throws EventException {
//		try {
//			return dbDao.mainSearchEQBalanceReportInquiryList(rhqCd, fmWeek, toWeek, scontiCd, lccCd, eccCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
//	 * EQ Balance Report.<br>
//	 * 
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchLclHqOfcCd() throws EventException{
//		try {
//			return dbDao.searchLclHqOfcCd();
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
//	 * EQ Balance Report.<br>
//	 * 
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchGlblhqOfcCd() throws EventException{
//		try {
//			return dbDao.searchGlblhqOfcCd();
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
//	 * EQ Balance Report.<br>
//	 * 
//	 * @param String ofcCd
//	 * @param String pageType
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchHdQtrByOfcCd(String ofcCd, String pageType) throws EventException{
//		try {
//			return dbDao.searchHdQtrByOfcCd(ofcCd, pageType);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
//	 * EQ Balance Report.<br>
//	 * 
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchNowWeek() throws EventException{
//		try {
//			return dbDao.searchNowWeek();
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
//	 * EQ Balance Report.<br>
//	 * 
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchLastWeek() throws EventException{
//		try {
//			return dbDao.searchLastWeek();
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Sub-Conti Code Retrieve<br>
//	 * For Setting Sub-Conti Code<br>
//	 * 
//	 * @param String rhqCd
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchSubContiCd(String rhqCd) throws EventException{
//		try {
//			return dbDao.searchSubContiCd(rhqCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : LCC Code Retrieve<br>
//	 * For Setting LCC Code<br>
//	 * 
//	 * @param String scontiCd
//	 * @param String rhqCd
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchLccCd(String scontiCd, String rhqCd) throws EventException {
//		try {
//			return dbDao.searchLccCd(scontiCd, rhqCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : ECC Code Retrieve<br>
//	 * For Setting ECC Code<br>
//	 * 
//	 * @param String scontiCd
//	 * @param String lccCd
//	 * @param String rhqCd
//	 * @return String
//	 * @exception EventException
//	 */
//	public String searchEccCd(String scontiCd, String lccCd, String rhqCd) throws EventException {
//		try {
//			return dbDao.searchEccCd(scontiCd, lccCd, rhqCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
//	
//	/**
//	 * EES_CIM_0060 : Save<br>
//	 * 
//	 * @param CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageEQBalanceReportInput(CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs, SignOnUserAccount account) throws EventException {
//		try {
//			
//			List<CimEqSplsDfctStsVO> selcimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
//			List<CimEqSplsDfctStsVO> insCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
//			List<CimEqSplsDfctStsVO> updCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
//			List<CimEqSplsDfctStsVO> delCimEqSplsDfctStsVOs = new ArrayList<CimEqSplsDfctStsVO>();
//
//			if(cimEqSplsDfctStsVOs != null) {
//				for ( int i=0; i<cimEqSplsDfctStsVOs.length; i++ ) {
//					
//					selcimEqSplsDfctStsVOs = dbDao.searchEqSplsDfctSts(cimEqSplsDfctStsVOs[i]);
//					
//					/* 議고쉶???곗씠?곌? 議댁옱, 議고쉶媛믨낵 ?붾㈃?꾨떖媛믪씠 ?쒕줈 媛숇떎 -> skip
//					 * 議고쉶???곗씠?곌? 議댁옱, 議고쉶媛믨낵 ?붾㈃?꾨떖媛믪씠 ?쒕줈 SPLS_DFCT_STS_CTNT ?먮뒗 STS_RMK媛???━??-> update
//					 * 議고쉶???곗씠?곌? 議댁옱, ?붾㈃?꾨떖媛믪쓽 SPLS_DFCT_STS_CTNT媛??녿떎 -> delete
//					 * 議고쉶???곗씠?곌? ?녿떎, ?붾㈃?꾨떖媛믪쓽 SPLS_DFCT_STS_CTNT媛??덈떎 -> insert
//					 */
//					
//					// 議고쉶???곗씠?곌? ?녿떎, ?붾㈃?꾨떖媛믪쓽 SPLS_DFCT_STS_CTNT媛??덈떎 -> insert
//					if (selcimEqSplsDfctStsVOs.size() == 0 && !cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt().isEmpty()) {
//						
//						cimEqSplsDfctStsVOs[i].setCreUsrId(account.getUsr_id());
//						cimEqSplsDfctStsVOs[i].setUpdUsrId(account.getUsr_id());
//						// add insert VO
//						insCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
//					} 
//					// 議고쉶???곗씠?곌? 議댁옱
//					else if(selcimEqSplsDfctStsVOs.size() > 0) {
//						
//						// ?붾㈃?꾨떖媛믪쓽 SPLS_DFCT_STS_CTNT媛??녿떎 -> delete
//						if(cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt().isEmpty()) {
//							// add delete VO
//							delCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
//						} else {
//							// 議고쉶媛믨낵 ?붾㈃?꾨떖媛믪씠 ?쒕줈 SPLS_DFCT_STS_CTNT ?먮뒗 STS_RMK媛???━??-> update
//							if( (selcimEqSplsDfctStsVOs.get(0).getSplsDfctStsCtnt().equals(cimEqSplsDfctStsVOs[i].getSplsDfctStsCtnt())) 
//								|| (selcimEqSplsDfctStsVOs.get(0).getStsRmk().equals(cimEqSplsDfctStsVOs[i].getStsRmk())) ) {
//								
//								cimEqSplsDfctStsVOs[i].setUpdUsrId(account.getUsr_id());
//								// add update VO
//								updCimEqSplsDfctStsVOs.add(cimEqSplsDfctStsVOs[i]);
//							}
//							
//						}
//					}
//				}
//			}
//			
//			if ( insCimEqSplsDfctStsVOs.size() > 0 ) {
//				dbDao.addEqSplsDfctSts(insCimEqSplsDfctStsVOs);
//			}
//			
//			if ( updCimEqSplsDfctStsVOs.size() > 0 ) {
//				dbDao.mdfyEqSplsDfctSts(updCimEqSplsDfctStsVOs);
//			}
//			
//			if ( delCimEqSplsDfctStsVOs.size() > 0 ) {
//				dbDao.delEqSplsDfctSts(delCimEqSplsDfctStsVOs);
//			}
//			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
//		} catch(Exception ex){
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
//	    }
//	}
//	
//	/**
//	 * EES_CIM_0062 PreSearch before Retrieve<br>
//	 * Mailing Service Setting.<br>
//	 * 
//	 * @param String usrId
//	 * @return int cntByUsrId
//	 * @exception EventException
//	 */
//	public int cntOfCimEqSplsDfctEmlByUsrId(String usrId) throws EventException {
//		int cntByUsrId = 0;
//		
//		try {
//			// PreSearch before Retrieve
//			cntByUsrId = dbDao.cntOfCimEqSplsDfctEmlByUsrId(usrId);
//			
//			return cntByUsrId;
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}
//	}
	
	/**
	 * EES_CIM_0063 Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return List<UncollectedCargoVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoVO> searchUncollectedCargoCreation(UncollectedCargoVO uncollectedCargoVO) throws EventException {
		
		try {
			return dbDao.searchUncollectedCargoCreation(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	
	/**
	 * UC Creation B/L info 議고쉶 [EES_CIM_0063]<br>
	 * 
	 * @param String strBLNo
	 * @return UncollectedCargoVO
	 * @exception EventException
	 */
	public UncollectedCargoVO searchUncollectedCargoCreationBlInfo(String strBLNo) throws EventException {

		UncollectedCargoVO uncollectedCargoVO = new UncollectedCargoVO();
		try {
			uncollectedCargoVO = dbDao.searchUncollectedCargoCreationBlInfo(strBLNo);
			return uncollectedCargoVO;
		} catch (DAOException ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);		
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * searchComboCodeList.<br>
	 * 
	 * @param String intgCdId
	 * @return List<CodeVO> 
	 * @exception EventException
	 */
	public List<CodeVO> searchComboCodeList(String intgCdId) throws EventException {
		
		try {
			return dbDao.searchComboCodeList(intgCdId);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
//	/**
//	 * EES_CIM_0062 : Save<br>
//	 * 
//	 * @param MailingServiceSettingListVO[] mailingServiceSettingListVOs
//	 * @param SignOnUserAccount account
//	 * @exception EventException
//	 */
//	public void manageMailingServiceSetting(MailingServiceSettingListVO[] mailingServiceSettingListVOs, SignOnUserAccount account) throws EventException {
//		
//		try {
//			
//			List<CimEqSplsDfctEmlVO> insertVoList = new ArrayList<CimEqSplsDfctEmlVO>();
//			CimEqSplsDfctEmlVO list = null;
//			
//			dbDao.delMailingServiceSetting(account.getUsr_id());
//			
//			if (mailingServiceSettingListVOs != null) {
//				
//				if(mailingServiceSettingListVOs.length > 0) {
//					for ( int i=0; i<mailingServiceSettingListVOs.length; i++ ) {
//						list = new CimEqSplsDfctEmlVO();
//						
//						list.setUsrId(account.getUsr_id());
//						list.setCreUsrId(account.getUsr_id());
//						list.setUpdUsrId(account.getUsr_id());
//						list.setCntCd(mailingServiceSettingListVOs[i].getCntCd());
//						
//							insertVoList.add(list);
//					}
//				}
//				
//			}
//			
//			if ( insertVoList.size() > 0 ) {
//				dbDao.addMailingServiceSetting(insertVoList);				
//			}
//			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
//		} catch(Exception ex){
//			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getUserMessage());
//	    }
//	}
	
	/**
	 * EES_CIM_0063 <br>
	 * Create New Uncollected Cargo Case Number <br>
	 * 
	 * @param String ucCDHd
	 * @return String
	 * @exception EventException
	 */	
	public String checkNewUCCaseNo(String ucCDHd) throws EventException {
		
		try {
			return dbDao.checkNewUCCaseNo(ucCDHd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * BL 중복조회 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo3(UncollectedCargoVO uncollectedCargoVO) throws EventException {
		
		try {
			return dbDao.checkBLNo3(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check BL No  <br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo(String strBLNo) throws EventException {
		
		try {
			return dbDao.checkBLNo(strBLNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * CIM_UC_CGO_DTL ???대떦 B/L NO 議댁옱 ?щ? 議고쉶 <br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkBLNo2(String strBLNo) throws EventException {
		
		try {
			return dbDao.checkBLNo2(strBLNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check Branch/Agent <br>
	 * 
	 * @param String strAgnt
	 * @return String
	 * @exception EventException
	 */	
	public String checkAgent(String strAgnt) throws EventException {
		
		try {
			return dbDao.checkAgent(strAgnt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check RHQ <br>
	 * 
	 * @param String strRhq
	 * @return String
	 * @exception EventException
	 */	
	public String checkRHQ(String strRhq) throws EventException {
		
		try {
			return dbDao.checkRHQ(strRhq);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check HANDLER <br>
	 * 
	 * @param String strHndlr
	 * @return String
	 * @exception EventException
	 */	
	public String checkHandler(String strHndlr) throws EventException {
		
		try {
			return dbDao.checkHandlerOfcCd(strHndlr,"HNDLR");
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check Office Code <br>
	 * 
	 * @param String strOfcCd
	 * @return String
	 * @exception EventException
	 */	
	public String checkOfcCd(String strOfcCd) throws EventException {
		
		try {
			return dbDao.checkHandlerOfcCd(strOfcCd,"OFC");
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Check Office & Handler <br>
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String strOpt
	 * @return String 
	 * @exception EventException
	 */	
	public String checkOfcHandlerMatch(UncollectedCargoVO uncollectedCargoVO, String strOpt) throws EventException {
		
		try {
			return dbDao.checkOfcHandlerMatch(uncollectedCargoVO, strOpt);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	/**
	 * EES_CIM_0063 <br>
	 * Check Office & Authority <br>
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String usrid
	 * @return String
	 * @exception EventException
	 */	
	public String checkOfAuthority(UncollectedCargoVO uncollectedCargoVO, String usrid) throws EventException {
		
		try {
			return dbDao.checkOfAuthority(uncollectedCargoVO, usrid);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException {
		
		try {
			// Login User ID
			String strLgnUsr = account.getUsr_id();

			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
			uncollectedCargoVO.setCreUsrId(strLgnUsr);
			uncollectedCargoVO.setUpdUsrId(strLgnUsr);
			uncollectedCargoVO.setHndlUpdId(strLgnUsr);
			uncollectedCargoVO.setHndlUpdDt("SYSDATE");
			uncollectedCargoVO.setKntrUpdId("");				// OFC Transfer ?댄썑 Update
			uncollectedCargoVO.setKntrUpdDt("");				// OFC Transfer ?댄썑 Update
			
			uncollectedCargoVO.setUcSeq("1");	//理쒖큹 ?앹꽦

			dbDao.manageUncollectedCargoCreationAddMaster(uncollectedCargoVO);

			// 1. CIM_UC_CGO_CNTR 泥섎━
			manageUncollectedCargoBLCntr(uncollectedCargoVO, strLgnUsr);
			
			// UC CS NO, B/L NO 蹂? Container ?뺣낫瑜?Master Container Table ??諛섏쁺
			manageMstCntrWthUncollectedCargoCntr(uncollectedCargoVO, strLgnUsr);

			
//			// 1. CIM_UC_CGO_CNTR 泥섎━
//			//		1) CIM_UC_CGO_CNTR ?뚯씠釉??곗씠??? ??젣?쒕떎. (uc_cs_no, bl_no, cntr_no 媛?
//			// 		2) CIM_UC_CGO_CNTR ???좉퇋 Container瑜??앹꽦?쒕떎.
//			SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//			List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlListVOs = new ArrayList<SearchUncollectedVolDtlListVO>();
//			String strTmp = uncollectedCargoVO.getCntrList();
//			
//			// strTmp媛?議댁옱?섏? ?딆쑝硫?=> B/L Cntr ?섏젙?덊븿.
//			if ( strTmp != null && !"".equals(strTmp)){
//				String[] cntrList = strTmp.split(",");
//				String strUcCsNo = uncollectedCargoVO.getUcCsNo();
//				String strBlNo= uncollectedCargoVO.getBlNo();
//					
//				for ( int i= 0 ; i < cntrList.length ; i++ ) {		
//					
//					searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//					
//					searchUncollectedVolDtlListVO.setUcCsNo(strUcCsNo);							// UC cargo No
//					searchUncollectedVolDtlListVO.setBlNo(strBlNo);								// B/L No
//					searchUncollectedVolDtlListVO.setCntrNo(cntrList[i].trim());				// Container
//					searchUncollectedVolDtlListVO.setBkgNo(strLgnUsr);				// 湲곗〈 VO ?ъ슜: bkgNo ??User ID ?낅젰
//						
//					searchUncollectedVolDtlListVOs.add(searchUncollectedVolDtlListVO);	
//				}
//				if ( searchUncollectedVolDtlListVOs.size() > 0 ) {
//					dbDao.manageUncollectedCargoCreationDeleteContainer(strUcCsNo,strBlNo);				// 湲곗〈 Container ?뺣낫 ??젣
//					dbDao.manageUncollectedCargoCreationAddContainer(searchUncollectedVolDtlListVOs);	// ?좉퇋 Container ?뺣낫 ?앹꽦
//				}
//			}
			
				
			 //2.2 Data ??'-' ?쒓굅
			uncollectedCargoVO.setHndlUpdDt(uncollectedCargoVO.getHndlUpdDt().replace("-", ""));
			uncollectedCargoVO.setKntrUpdDt(uncollectedCargoVO.getKntrUpdDt().replace("-", ""));
			uncollectedCargoVO.setCneeUcDt(uncollectedCargoVO.getCneeUcDt().replace("-", ""));
			uncollectedCargoVO.setUcClzDt(uncollectedCargoVO.getUcClzDt().replace("-", ""));
			uncollectedCargoVO.setPolEtd(uncollectedCargoVO.getPolEtd().replace("-", ""));
			uncollectedCargoVO.setPodEta(uncollectedCargoVO.getPodEta().replace("-", ""));
			uncollectedCargoVO.setAbanLtrShprDt(uncollectedCargoVO.getAbanLtrShprDt().replace("-", ""));
			uncollectedCargoVO.setAbanLtrCneeDt(uncollectedCargoVO.getAbanLtrCneeDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN1stNtcDt(uncollectedCargoVO.getUcCgoN1stNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN2ndNtcDt(uncollectedCargoVO.getUcCgoN2ndNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN3rdNtcDt(uncollectedCargoVO.getUcCgoN3rdNtcDt() .replace("-", ""));
			uncollectedCargoVO.setUcCgoFnlNtcDt(uncollectedCargoVO.getUcCgoFnlNtcDt().replace("-", ""));
			uncollectedCargoVO.setOtsDmdtDt(uncollectedCargoVO.getOtsDmdtDt().replace("-", ""));
			uncollectedCargoVO.setOtsStoDt(uncollectedCargoVO.getOtsStoDt().replace("-", ""));
			uncollectedCargoVO.setOtsOtrCostDt(uncollectedCargoVO.getOtsOtrCostDt().replace("-", ""));

			//2.3 ?レ옄 援щ텇???쒓굅
			//1) Invoice/Current Value
			uncollectedCargoVO.setUcInvAmt(uncollectedCargoVO.getUcInvAmt().replace(",", ""));
			uncollectedCargoVO.setUcInvXchRt(uncollectedCargoVO.getUcInvXchRt().replace(",", ""));
			uncollectedCargoVO.setUcInvUsdAmt(uncollectedCargoVO.getUcInvUsdAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntAmt(uncollectedCargoVO.getUcCrntAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntXchRt(uncollectedCargoVO.getUcCrntXchRt().replace(",", ""));
			uncollectedCargoVO.setUcCrntUsdAmt(uncollectedCargoVO.getUcCrntUsdAmt().replace(",", ""));
			//2) Outstanding Charge & Cost
			uncollectedCargoVO.setOtsOftAmt(uncollectedCargoVO.getOtsOftAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrAmt(uncollectedCargoVO.getOtsOtrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsDmdtAmt(uncollectedCargoVO.getOtsDmdtAmt().replace(",", ""));
			uncollectedCargoVO.setOtsStoAmt(uncollectedCargoVO.getOtsStoAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrCostAmt(uncollectedCargoVO.getOtsOtrCostAmt().replace(",", ""));
			uncollectedCargoVO.setOtsRcvrAmt(uncollectedCargoVO.getOtsRcvrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsInsurCvrAmt(uncollectedCargoVO.getOtsInsurCvrAmt().replace(",", ""));
			
			dbDao.manageUncollectedCargoCreationAddDetail(uncollectedCargoVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * manage Uncollected Cargo Container List <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String lngUsr
	 * @exception EventException
	 */	
	private void manageUncollectedCargoBLCntr(UncollectedCargoVO uncollectedCargoVO, String lngUsr) throws EventException {
		
		try {
			// Login User ID
			String strLgnUsr = lngUsr;
			
			// 1. CIM_UC_CGO_CNTR 泥섎━
			//		1) CIM_UC_CGO_CNTR ?뚯씠釉??곗씠??? ??젣?쒕떎. (uc_cs_no, bl_no, cntr_no 媛?
			// 		2) CIM_UC_CGO_CNTR ???좉퇋 Container瑜??앹꽦?쒕떎.
			SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
			List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlListVOs = new ArrayList<SearchUncollectedVolDtlListVO>();
			String strTmp = uncollectedCargoVO.getCntrList();
			
			// strTmp媛?議댁옱?섏? ?딆쑝硫?=> B/L Cntr ?섏젙?덊븿.
			if ( strTmp != null && !"".equals(strTmp)){
				String[] cntrList = strTmp.split(",");
				String strUcCsNo = uncollectedCargoVO.getUcCsNo();
				String strBlNo= uncollectedCargoVO.getBlNo();
					
				for ( int i= 0 ; i < cntrList.length ; i++ ) {		
					
					searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
					
					searchUncollectedVolDtlListVO.setUcCsNo(strUcCsNo);							// UC cargo No
					searchUncollectedVolDtlListVO.setBlNo(strBlNo);								// B/L No
					searchUncollectedVolDtlListVO.setCntrNo(cntrList[i].trim());				// Container
					searchUncollectedVolDtlListVO.setBkgNo(strLgnUsr);							// 湲곗〈 VO ?ъ슜: bkgNo ??User ID ?낅젰
						
					searchUncollectedVolDtlListVOs.add(searchUncollectedVolDtlListVO);	
				}
				if ( searchUncollectedVolDtlListVOs.size() > 0 ) {
					dbDao.manageUncollectedCargoCreationDeleteContainer(strUcCsNo,strBlNo);				// 湲곗〈 Container ?뺣낫 ??젣
					dbDao.manageUncollectedCargoCreationAddContainer(searchUncollectedVolDtlListVOs);	// ?좉퇋 Container ?뺣낫 ?앹꽦
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}		
	}
	

	/**
	 * EES_CIM_0063 <br>
	 * manage Master Container concerned with Uncollected Cargo Container List <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String lngUsr
	 * @exception EventException
	 */	
	private void manageMstCntrWthUncollectedCargoCntr(UncollectedCargoVO uncollectedCargoVO, String strLgnUsr) throws EventException {
		
		try {
			
			// 湲곗〈 Cntr List => (蹂?꼍??Data) + UC no, bl/no,  subQuery ?댁슜 ?⑥씪 Query 濡?1???ㅽ뻾.
			// ?좉퇋 Cntr List => (蹂?꼍??Data) + ?좉퇋 Container List 議고빀, ?⑥씪 Query 諛섎났 ?ㅽ뻾.
			// VO??怨좊젮?댁꽌 ?좉퇋?앹꽦 ( 蹂?꼍??Data + UC no, bl/no, cntr_no, 
			// Query 臾몄? ?⑥씪 Query 怨좊젮??蹂?寃?
			
			MstCntrVO oldMstCntrVO = new MstCntrVO();
			List<MstCntrVO> newMstCntrVOs = new ArrayList<MstCntrVO>();
			
			String strTmp = uncollectedCargoVO.getCntrList();
			String[] cntrList = strTmp.split(",");
			
			String strUcCsNo = uncollectedCargoVO.getUcCsNo();
			String strBlNo = uncollectedCargoVO.getBlNo();
			String strStsCd = uncollectedCargoVO.getUcStsCd();			// "CL","CA" -> Close ?곹깭肄붾뱶
			String strReOpn = uncollectedCargoVO.getUcRopnFlg();		// "Y" or "N"
			String strLsDivCd = "";
			String strDt = "";
			String strRsnCd = "";
			String strEndDt = "";
			String strRsnDesc = "";
			
			// Close, Reopen, ?쇰컲 寃쎌슦???곕씪 Master Container ????옣???좉퇋 Cntr List 媛??ㅼ젙
			int iMode = 0;
			
			if (strStsCd.equals("CL")) {
				iMode = 1;	// Closed
			} else if (strStsCd.equals("CA")) {
				return;		// CA ?대㈃ Master Container Update ?섏? ?딅룄濡??섏젙
			} else if (strStsCd.equals("CN")) {
				iMode = 2;	// Cancelled
			} else if (strReOpn.equals("Y")) {
				iMode = 3;	// Reopen Case
			} else {
				iMode = 4;  // Normal Case
			}
			
			switch (iMode) {
				case 1:
					strLsDivCd = "";
					strDt = "";
					strRsnCd = "";
					strRsnDesc = "";
					strEndDt = uncollectedCargoVO.getUcClzDt();
				break;
				case 2:
					strLsDivCd = "";
					strDt = "";
					strRsnCd = "";
					strRsnDesc = "";
					strEndDt = "";
				break;
				case 3:
					strLsDivCd = "U";
					strDt = uncollectedCargoVO.getCneeUcDt();
					// Reopen ??寃쎌슦 
					// 1. cim_uc_cgo_dtl ???덈뒗 Reason Code ?뺣낫瑜??쎌뼱 ?⑤떎.
					// 2. 利? 而⑦뀒?대꼫 蹂?b/l info??留욌뒗 ?뺣낫瑜??쎌뼱??update.
					strRsnCd = "REOPEN"; 		// uncollectedCargoVO.getUcRsnCd(); 		// Query 援щ텇???⑸룄濡?"REOPEN" ?ㅼ젙
					strRsnDesc = "";			// uncollectedCargoVO.getUcRsnDesc();
					strEndDt = "";
				break;
				case 4:
					strLsDivCd = "U";
					strDt = uncollectedCargoVO.getCneeUcDt();
					strRsnCd = uncollectedCargoVO.getUcRsnCd();
					strRsnDesc = uncollectedCargoVO.getUcRsnDesc();
					strEndDt = "";
				break;
			}
			
			// iMode : 1,2,3 -> Closed, Closed Application, Cancelled, Reopen ??寃쎌슦 => 湲곗〈??UC 愿?젴 ?꾩껜 cntr 蹂?꼍
			// iMode :4  -> Normal 耳?씠??( UC, BL蹂?master Cntr ?뺣낫 蹂?꼍. ??UC Date???좉퇋 UC 愿?젴 ?꾩껜 cntr 蹂?꼍)
			
		    // Cancel 시
			if ( iMode == 2) {
				List<SearchUncollectedVolDtlListVO> list1 = dbDao.searchUncollectedCargoContainerList(strUcCsNo, strBlNo, "Y");
				
				for ( int i= 0 ; i < list1.size() ; i++ ) {
				     ChargeCalculationBC command = new ChargeCalculationBCImpl();
				     command.modifyChargeUcFlag(list1.get(i).getBlNo(), list1.get(i).getCntrNo(), "N", list1.get(i).getHndlBrncCd(), list1.get(i).getHndlHdlrUsrId());
				     //command.modifyChargeUcFlagBlNo(strUcCsNo, list1.get(i).getBlNo());	
				}

				//ChargeCalculationBC command = new ChargeCalculationBCImpl();	
				//command.modifyChargeUcFlagBlNo(strUcCsNo, strBlNo);		
			}
			
		    if ( iMode == 4) {
//		    	
//		    	if ( strTmp != null && !"".equals(strTmp)) {
//					List<SearchUncollectedVolDtlListVO> list2 = dbDao.searchUncollectedCargoContainerList(strUcCsNo, strBlNo, "N");
//					String strChkFlg = "";
//					
//					// CNTR NO 삭제 시
//					for ( int i= 0 ; i < list2.size() ; i++ ) {
//						for ( int j= 0 ; j < cntrList.length ; j++ ) {
//							 if ( list2.get(i).getCntrNo().equals(cntrList[j].trim()) ) {
//								 strChkFlg = "Y";
//								 break;
//							 }
//							 else {
//								 strChkFlg = "N";
//							 }    
//						}    
//						if ( strChkFlg.equals("N")) { 
//							 ChargeCalculationBC command = new ChargeCalculationBCImpl();	
//						     command.modifyChargeUcFlag(strBlNo, list2.get(i).getCntrNo(), "N");
//						}
//					}
//	
//					// CNTR NO 추가 시	
//					strChkFlg = "";
//					for ( int i= 0 ; i < cntrList.length ; i++ ) {
//						for ( int j= 0 ; j < list2.size() ; j++ ) {
//							 if ( cntrList[i].trim().equals(list2.get(j).getCntrNo()) ) {
//								 strChkFlg = "Y";
//								 break;
//							 }
//							 else {
//								 strChkFlg = "N";
//							 }    
//						}    
//						if ( strChkFlg.equals("N")) {
//							 ChargeCalculationBC command = new ChargeCalculationBCImpl();	
//						     command.modifyChargeUcFlag(strBlNo, cntrList[i].trim(), "Y");
//						}
//					}
//					
//					// CNTR NO 처음 생성 시
//				    if ( list2.size() == 0 ) {
//				    	for ( int i= 0 ; i < cntrList.length ; i++ ) {
//							 ChargeCalculationBC command = new ChargeCalculationBCImpl();	
//						     command.modifyChargeUcFlag(strBlNo, cntrList[i].trim(), "Y");
//						}
//				    }
//		    	}
		    	

				ChargeCalculationBC command = new ChargeCalculationBCImpl();	
				command.modifyChargeUcFlagBlNo(strUcCsNo, strBlNo);		
		    	
				// 湲곗〈 Master Contianer 瑜?Release ?섍린 ?꾪븳 ?곗씠???ㅼ젙
				oldMstCntrVO.setUcCsNo(strUcCsNo);
				oldMstCntrVO.setBlNo(strBlNo);
				oldMstCntrVO.setCntrNo("");
				oldMstCntrVO.setUclmLsDivCd("");
				oldMstCntrVO.setUclmDt("");
				oldMstCntrVO.setUclmRsn("");
				oldMstCntrVO.setUcRsnCd("");
				oldMstCntrVO.setUclmEndDt("");
				oldMstCntrVO.setTemp1(strLgnUsr);
				
				// ?좉퇋 Master Contianer Data 媛??ㅼ젙
				if ( strTmp != null && !"".equals(strTmp)){

					for ( int i= 0 ; i < cntrList.length ; i++ ) {		
						
						MstCntrVO newMstCntrVO = new MstCntrVO();
						
						newMstCntrVO.setUcCsNo(strUcCsNo);
						newMstCntrVO.setBlNo(strBlNo);
						newMstCntrVO.setCntrNo(cntrList[i].trim());					//  Containe No.
						newMstCntrVO.setUclmLsDivCd(strLsDivCd);					//  UCLM_LS_DIV_CD ( U:UC Container)
						newMstCntrVO.setUclmDt(strDt);								// 	UCLM_DT (UC Date)
						newMstCntrVO.setUcRsnCd(strRsnCd);							//  UCLM_RSN (UC Reasons)
						newMstCntrVO.setUclmRsn(strRsnDesc);						//  UCLM_RSN (UC Reasons)
						newMstCntrVO.setUclmEndDt(strEndDt);						//  UCLM_END_DT (Close Date)
						newMstCntrVO.setTemp1(strLgnUsr);							//  Update User
						
						newMstCntrVOs.add(newMstCntrVO);
					}
				} 

				// << ?좉퇋 Cntr List ?덉쓬 >> => 湲곗〈, ?좉퇋 Cntr List 2媛?議댁옱
				if ( strTmp != null && !"".equals(strTmp)) {
					
					// 湲곗〈 Cntr List Relase (UC Container媛??꾨땶 ?곹깭濡?蹂?꼍 => subQuery ?ъ슜)
					dbDao.manageOldMstCntrWthUncollectedCargoBLCntr(oldMstCntrVO);

					// ?좉퇋 Cntr List ( UC Container???곹깭濡?蹂?꼍 => Update Query 諛곗튂)
					dbDao.manageNewMstCntrWthUncollectedCargoBLCntr(newMstCntrVOs);
		
				} else {
					// << ?좉퇋 Cntr List ?놁쓬 >> => 湲곗〈 Cntr List 留?議댁옱(湲곗〈 而⑦뀒?대꼫瑜?UC Container ?곹깭濡?蹂?꼍 => subQuery ?ъ슜 )
					oldMstCntrVO.setUcCsNo(strUcCsNo);
					oldMstCntrVO.setBlNo(strBlNo);
					oldMstCntrVO.setCntrNo("");
					oldMstCntrVO.setUclmLsDivCd(strLsDivCd);
					oldMstCntrVO.setUclmDt(strDt);
					oldMstCntrVO.setUcRsnCd(strRsnCd);
					oldMstCntrVO.setUclmRsn(strRsnDesc);
					oldMstCntrVO.setUclmEndDt(strEndDt);
					oldMstCntrVO.setTemp1(strLgnUsr);
					
					dbDao.manageOldMstCntrWthUncollectedCargoBLCntr(oldMstCntrVO);
			    }	
				// ?대떦 UC???대떦?섎뒗 紐⑤뱺 而⑦뀒?대꼫??UC_DATE UPDATE;
//				manageMstCntrWthUncollectedCargoUcCntrUcDtOnly(uncollectedCargoVO, strLgnUsr);
				
		    }else if ( iMode == 1) {
				ChargeCalculationBC command2 = new ChargeCalculationBCImpl();	
				command2.modifyChargeUcFlagBlNo(strUcCsNo, strBlNo);	
		    	
				oldMstCntrVO.setUcCsNo(strUcCsNo);
				oldMstCntrVO.setBlNo(strBlNo);
				oldMstCntrVO.setCntrNo("");
				oldMstCntrVO.setUclmLsDivCd(strLsDivCd);
				oldMstCntrVO.setUclmDt(strDt);
				oldMstCntrVO.setUcRsnCd(strRsnCd);
				oldMstCntrVO.setUclmRsn(strRsnDesc);
				oldMstCntrVO.setUclmEndDt(strEndDt);
				oldMstCntrVO.setTemp1(strLgnUsr);
				
				dbDao.manageMstCntrWthUncollectedCargoUcCntr(oldMstCntrVO);				
			} else {				
				oldMstCntrVO.setUcCsNo(strUcCsNo);
				oldMstCntrVO.setBlNo(strBlNo);
				oldMstCntrVO.setCntrNo("");
				oldMstCntrVO.setUclmLsDivCd(strLsDivCd);
				oldMstCntrVO.setUclmDt(strDt);
				oldMstCntrVO.setUcRsnCd(strRsnCd);
				oldMstCntrVO.setUclmRsn(strRsnDesc);
				oldMstCntrVO.setUclmEndDt(strEndDt);
				oldMstCntrVO.setTemp1(strLgnUsr);
				
				dbDao.manageMstCntrWthUncollectedCargoUcCntr(oldMstCntrVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}		
	}
	
//	/**
//	 * EES_CIM_0063 <br>
//	 * manage Master Container concerned with Uncollected Cargo Container List <br>
//	 * 
//	 * @param UncollectedCargoVO uncollectedCargoVO
//	 * @exception EventException
//	 */	
//	private void manageMstCntrWthUncollectedCargoUcCntrUcDtOnly(UncollectedCargoVO uncollectedCargoVO, String strLgnUsr) throws EventException {
//		
//		try {
//			
//			// Master Container ?먯꽌 UC Date 媛믪쓣 Update
//			
//			MstCntrVO mstCntrVO = new MstCntrVO();
//			
//			String strUcCsNo = uncollectedCargoVO.getUcCsNo();
//			String strDt = uncollectedCargoVO.getCneeUcDt();
//	
//			mstCntrVO.setUcCsNo(strUcCsNo);
//			mstCntrVO.setUclmDt(strDt);
//			
//			dbDao.manageMstCntrWthUncollectedCargoUcCntrUcDtOnly(mstCntrVO, strLgnUsr);
//			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
//		}		
//	}	
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data 01 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation01(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException {
		
		try {
			// 湲곗〈 uc case no ?곗씠??蹂?꼍  => Master : update, Detail : update
			
			// Login User ID
			String strLgnUsr = account.getUsr_id();
			
			// 1. CIM_UC_CGO_CNTR 泥섎━
			manageUncollectedCargoBLCntr(uncollectedCargoVO, strLgnUsr);
			
			// UC CS NO, B/L NO 蹂? Container ?뺣낫瑜?Master Container Table ??諛섏쁺
			manageMstCntrWthUncollectedCargoCntr(uncollectedCargoVO,strLgnUsr);
			
			
//			// 1. CIM_UC_CGO_CNTR 泥섎━
//			//		1) CIM_UC_CGO_CNTR ?뚯씠釉??곗씠??? ??젣?쒕떎. (uc_cs_no, bl_no, cntr_no 媛?
//			// 		2) CIM_UC_CGO_CNTR ???좉퇋 Container瑜??앹꽦?쒕떎.
//			SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//			List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlListVOs = new ArrayList<SearchUncollectedVolDtlListVO>();
//			String strTmp = uncollectedCargoVO.getCntrList();
//			
//			// strTmp媛?議댁옱?섏? ?딆쑝硫?=> B/L Cntr ?섏젙?덊븿.
//			if ( strTmp != null && !"".equals(strTmp)){
//				String[] cntrList = strTmp.split(",");
//				String strUcCsNo = uncollectedCargoVO.getUcCsNo();
//				String strBlNo= uncollectedCargoVO.getBlNo();
//					
//				for ( int i= 0 ; i < cntrList.length ; i++ ) {		
//					
//					searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//					
//					searchUncollectedVolDtlListVO.setUcCsNo(strUcCsNo);									// UC cargo No
//					searchUncollectedVolDtlListVO.setBlNo(strBlNo);										// B/L No
//					searchUncollectedVolDtlListVO.setCntrNo(cntrList[i].trim());						// Container
//					searchUncollectedVolDtlListVO.setBkgNo(strLgnUsr);						// 湲곗〈 VO ?ъ슜: bkgNo ??User ID ?낅젰
//						
//					searchUncollectedVolDtlListVOs.add(searchUncollectedVolDtlListVO);	
//				}
//				if ( searchUncollectedVolDtlListVOs.size() > 0 ) {
//					dbDao.manageUncollectedCargoCreationDeleteContainer(strUcCsNo,strBlNo);				// 湲곗〈 Container ?뺣낫 ??젣
//					dbDao.manageUncollectedCargoCreationAddContainer(searchUncollectedVolDtlListVOs);	// ?좉퇋 Container ?뺣낫 ?앹꽦
//				}
//			}
			
			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
			uncollectedCargoVO.setCreUsrId(strLgnUsr);
			uncollectedCargoVO.setUpdUsrId(strLgnUsr);
			if ( uncollectedCargoVO.getUcOfcTrnsFlg().equals("Y")){
				uncollectedCargoVO.setHndlUpdId("");
				uncollectedCargoVO.setHndlUpdDt("");
				uncollectedCargoVO.setKntrUpdId(strLgnUsr);				// OFC Transfer ?댄썑 Update
				uncollectedCargoVO.setKntrUpdDt("SYSDATE");				// OFC Transfer ?댄썑 Update
			} else {
				uncollectedCargoVO.setHndlUpdId(strLgnUsr);
				uncollectedCargoVO.setHndlUpdDt("SYSDATE");
				uncollectedCargoVO.setKntrUpdId("");					// OFC Transfer ?댄썑 Update
				uncollectedCargoVO.setKntrUpdDt("");					// OFC Transfer ?댄썑 Update
			}

			// 2.2 Data ??'-' ?쒓굅
			uncollectedCargoVO.setHndlUpdDt(uncollectedCargoVO.getHndlUpdDt().replace("-", ""));
			uncollectedCargoVO.setKntrUpdDt(uncollectedCargoVO.getKntrUpdDt().replace("-", ""));
			uncollectedCargoVO.setCneeUcDt(uncollectedCargoVO.getCneeUcDt().replace("-", ""));
			uncollectedCargoVO.setUcClzDt(uncollectedCargoVO.getUcClzDt().replace("-", ""));
			uncollectedCargoVO.setPolEtd(uncollectedCargoVO.getPolEtd().replace("-", ""));
			uncollectedCargoVO.setPodEta(uncollectedCargoVO.getPodEta().replace("-", ""));
			uncollectedCargoVO.setAbanLtrShprDt(uncollectedCargoVO.getAbanLtrShprDt().replace("-", ""));
			uncollectedCargoVO.setAbanLtrCneeDt(uncollectedCargoVO.getAbanLtrCneeDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN1stNtcDt(uncollectedCargoVO.getUcCgoN1stNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN2ndNtcDt(uncollectedCargoVO.getUcCgoN2ndNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN3rdNtcDt(uncollectedCargoVO.getUcCgoN3rdNtcDt() .replace("-", ""));
			uncollectedCargoVO.setUcCgoFnlNtcDt(uncollectedCargoVO.getUcCgoFnlNtcDt().replace("-", ""));
			uncollectedCargoVO.setOtsDmdtDt(uncollectedCargoVO.getOtsDmdtDt().replace("-", ""));
			uncollectedCargoVO.setOtsStoDt(uncollectedCargoVO.getOtsStoDt().replace("-", ""));
			uncollectedCargoVO.setOtsOtrCostDt(uncollectedCargoVO.getOtsOtrCostDt().replace("-", ""));
			
			// 2.3 ?レ옄 援щ텇???쒓굅
			//1) Invoice/Current Value
			uncollectedCargoVO.setUcInvAmt(uncollectedCargoVO.getUcInvAmt().replace(",", ""));
			uncollectedCargoVO.setUcInvXchRt(uncollectedCargoVO.getUcInvXchRt().replace(",", ""));
			uncollectedCargoVO.setUcInvUsdAmt(uncollectedCargoVO.getUcInvUsdAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntAmt(uncollectedCargoVO.getUcCrntAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntXchRt(uncollectedCargoVO.getUcCrntXchRt().replace(",", ""));
			uncollectedCargoVO.setUcCrntUsdAmt(uncollectedCargoVO.getUcCrntUsdAmt().replace(",", ""));
			//2) Outstanding Charge & Cost
			uncollectedCargoVO.setOtsOftAmt(uncollectedCargoVO.getOtsOftAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrAmt(uncollectedCargoVO.getOtsOtrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsDmdtAmt(uncollectedCargoVO.getOtsDmdtAmt().replace(",", ""));
			uncollectedCargoVO.setOtsStoAmt(uncollectedCargoVO.getOtsStoAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrCostAmt(uncollectedCargoVO.getOtsOtrCostAmt().replace(",", ""));
			uncollectedCargoVO.setOtsRcvrAmt(uncollectedCargoVO.getOtsRcvrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsInsurCvrAmt(uncollectedCargoVO.getOtsInsurCvrAmt().replace(",", ""));
			
			dbDao.manageUncollectedCargoCreationModifyMaster(uncollectedCargoVO);
			dbDao.manageUncollectedCargoCreationModifyDetail(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data 02 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation02(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException {
		
		try {
			// add sequence 寃쎌슦  => Master : update, Detail : add
			
			// Login User ID
			String strLgnUsr = account.getUsr_id();
			
			// 1. CIM_UC_CGO_CNTR 泥섎━
			manageUncollectedCargoBLCntr(uncollectedCargoVO, strLgnUsr);
			
			// UC CS NO, B/L NO 蹂? Container ?뺣낫瑜?Master Container Table ??諛섏쁺
			manageMstCntrWthUncollectedCargoCntr(uncollectedCargoVO, strLgnUsr);
			
//			// 1. CIM_UC_CGO_CNTR 泥섎━
//			//		1) CIM_UC_CGO_CNTR ?뚯씠釉??곗씠??? ??젣?쒕떎. (uc_cs_no, bl_no, cntr_no 媛?
//			// 		2) CIM_UC_CGO_CNTR ???좉퇋 Container瑜??앹꽦?쒕떎.
//			SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//			List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlListVOs = new ArrayList<SearchUncollectedVolDtlListVO>();
//			String strTmp = uncollectedCargoVO.getCntrList();
//			
//			// strTmp媛?議댁옱?섏? ?딆쑝硫?=> B/L Cntr ?섏젙?덊븿.
//			if ( strTmp != null && !"".equals(strTmp)){
//				String[] cntrList = strTmp.split(",");
//				String strUcCsNo = uncollectedCargoVO.getUcCsNo();
//				String strBlNo= uncollectedCargoVO.getBlNo();
//					
//				for ( int i= 0 ; i < cntrList.length ; i++ ) {		
//					
//					searchUncollectedVolDtlListVO = new SearchUncollectedVolDtlListVO();
//					
//					searchUncollectedVolDtlListVO.setUcCsNo(strUcCsNo);							// UC cargo No
//					searchUncollectedVolDtlListVO.setBlNo(strBlNo);								// B/L No
//					searchUncollectedVolDtlListVO.setCntrNo(cntrList[i].trim());				// Container
//					searchUncollectedVolDtlListVO.setBkgNo(strLgnUsr);				// 湲곗〈 VO ?ъ슜: bkgNo ??User ID ?낅젰
//						
//					searchUncollectedVolDtlListVOs.add(searchUncollectedVolDtlListVO);	
//				}
//				if ( searchUncollectedVolDtlListVOs.size() > 0 ) {
//					dbDao.manageUncollectedCargoCreationDeleteContainer(strUcCsNo,strBlNo);				// 湲곗〈 Container ?뺣낫 ??젣
//					dbDao.manageUncollectedCargoCreationAddContainer(searchUncollectedVolDtlListVOs);	// ?좉퇋 Container ?뺣낫 ?앹꽦
//				}
//			}

			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
			uncollectedCargoVO.setCreUsrId(strLgnUsr);
			uncollectedCargoVO.setUpdUsrId(strLgnUsr);
			if ( uncollectedCargoVO.getUcOfcTrnsFlg().replace("on", "Y") ==  "Y"){
				uncollectedCargoVO.setHndlUpdId("");
				uncollectedCargoVO.setHndlUpdDt("");
				uncollectedCargoVO.setKntrUpdId(strLgnUsr);				// OFC Transfer ?댄썑 Update
				uncollectedCargoVO.setKntrUpdDt("SYSDATE");				// OFC Transfer ?댄썑 Update
			} else {
				uncollectedCargoVO.setHndlUpdId(strLgnUsr);
				uncollectedCargoVO.setHndlUpdDt("SYSDATE");
				uncollectedCargoVO.setKntrUpdId("");					// OFC Transfer ?댄썑 Update
				uncollectedCargoVO.setKntrUpdDt("");					// OFC Transfer ?댄썑 Update
			}
			
			// 2.2 Data ??'-' ?쒓굅
			uncollectedCargoVO.setHndlUpdDt(uncollectedCargoVO.getHndlUpdDt().replace("-", ""));
			uncollectedCargoVO.setKntrUpdDt(uncollectedCargoVO.getKntrUpdDt().replace("-", ""));
			uncollectedCargoVO.setCneeUcDt(uncollectedCargoVO.getCneeUcDt().replace("-", ""));
			uncollectedCargoVO.setUcClzDt(uncollectedCargoVO.getUcClzDt().replace("-", ""));
			uncollectedCargoVO.setPolEtd(uncollectedCargoVO.getPolEtd().replace("-", ""));
			uncollectedCargoVO.setPodEta(uncollectedCargoVO.getPodEta().replace("-", ""));
			uncollectedCargoVO.setAbanLtrShprDt(uncollectedCargoVO.getAbanLtrShprDt().replace("-", ""));
			uncollectedCargoVO.setAbanLtrCneeDt(uncollectedCargoVO.getAbanLtrCneeDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN1stNtcDt(uncollectedCargoVO.getUcCgoN1stNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN2ndNtcDt(uncollectedCargoVO.getUcCgoN2ndNtcDt().replace("-", ""));
			uncollectedCargoVO.setUcCgoN3rdNtcDt(uncollectedCargoVO.getUcCgoN3rdNtcDt() .replace("-", ""));
			uncollectedCargoVO.setUcCgoFnlNtcDt(uncollectedCargoVO.getUcCgoFnlNtcDt().replace("-", ""));
			uncollectedCargoVO.setOtsDmdtDt(uncollectedCargoVO.getOtsDmdtDt().replace("-", ""));
			uncollectedCargoVO.setOtsStoDt(uncollectedCargoVO.getOtsStoDt().replace("-", ""));
			uncollectedCargoVO.setOtsOtrCostDt(uncollectedCargoVO.getOtsOtrCostDt().replace("-", ""));
			
			// 2.3 ?レ옄 援щ텇???쒓굅
			//1) Invoice/Current Value
			uncollectedCargoVO.setUcInvAmt(uncollectedCargoVO.getUcInvAmt().replace(",", ""));
			uncollectedCargoVO.setUcInvXchRt(uncollectedCargoVO.getUcInvXchRt().replace(",", ""));
			uncollectedCargoVO.setUcInvUsdAmt(uncollectedCargoVO.getUcInvUsdAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntAmt(uncollectedCargoVO.getUcCrntAmt().replace(",", ""));
			uncollectedCargoVO.setUcCrntXchRt(uncollectedCargoVO.getUcCrntXchRt().replace(",", ""));
			uncollectedCargoVO.setUcCrntUsdAmt(uncollectedCargoVO.getUcCrntUsdAmt().replace(",", ""));
			//2) Outstanding Charge & Cost
			uncollectedCargoVO.setOtsOftAmt(uncollectedCargoVO.getOtsOftAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrAmt(uncollectedCargoVO.getOtsOtrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsDmdtAmt(uncollectedCargoVO.getOtsDmdtAmt().replace(",", ""));
			uncollectedCargoVO.setOtsStoAmt(uncollectedCargoVO.getOtsStoAmt().replace(",", ""));
			uncollectedCargoVO.setOtsOtrCostAmt(uncollectedCargoVO.getOtsOtrCostAmt().replace(",", ""));
			uncollectedCargoVO.setOtsRcvrAmt(uncollectedCargoVO.getOtsRcvrAmt().replace(",", ""));
			uncollectedCargoVO.setOtsInsurCvrAmt(uncollectedCargoVO.getOtsInsurCvrAmt().replace(",", ""));
			
			dbDao.manageUncollectedCargoCreationModifyMaster(uncollectedCargoVO);
			dbDao.manageUncollectedCargoCreationAddDetail(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data 03 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation03(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException {
		
		try {
			// Counter Office ??Branch/Agent ??寃쎌슦 蹂?꼍?????덈뒗 ?댁슜???쒗븳 ?섏뼱 ?덉쓬. => Master update, Detail update
			
			// Login User ID
			String strLgnUsr = account.getUsr_id();
			
			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
			uncollectedCargoVO.setCreUsrId("");
			uncollectedCargoVO.setUpdUsrId(strLgnUsr);
			uncollectedCargoVO.setHndlUpdId("");
			uncollectedCargoVO.setHndlUpdDt("");
			uncollectedCargoVO.setKntrUpdId(strLgnUsr);				// Counter Office??Branch/Agent, Handler, Counter Office Opinion 3媛??留???옣?섎뒗 寃쎌슦
			uncollectedCargoVO.setKntrUpdDt("SYSDATE");				// Counter Office??Branch/Agent, Handler, Counter Office Opinion 3媛??留???옣?섎뒗 寃쎌슦
			
			dbDao.manageUncollectedCargoCreationModifyMaster2(uncollectedCargoVO);
			dbDao.manageUncollectedCargoCreationModifyDetail2(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}

	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data 04 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation04(UncollectedCargoVO uncollectedCargoVO, SignOnUserAccount account) throws EventException {
		
		try {
			// Reopen 寃쎌슦
			String strLgnUsr = account.getUsr_id();
			// UC CS NO, B/L NO 蹂? Container ?뺣낫瑜?Master Container Table ??諛섏쁺
			manageMstCntrWthUncollectedCargoCntr(uncollectedCargoVO, strLgnUsr);
			
			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
			uncollectedCargoVO.setCreUsrId("");
			uncollectedCargoVO.setUpdUsrId(strLgnUsr);
//			uncollectedCargoVO.setHndlUpdId(strLgnUsr);
//			uncollectedCargoVO.setHndlUpdDt("SYSDATE");
//			uncollectedCargoVO.setKntrUpdId("");				
//			uncollectedCargoVO.setKntrUpdDt("");	
			
			dbDao.manageUncollectedCargoCreationModifyMaster3(uncollectedCargoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * EES_CIM_0063 <br>
	 * Create UC Creation Data 05 <br>
	 * 
	 * @param String managerMemo
	 * @param String isAuthority
	 * @param String ucCsNo
	 * @param String blNo
	 * @param String usr_id
	 * @exception EventException
	 */	
	public void manageUncollectedCargoCreation05(String managerMemo,String isAuthority,String ucCsNo,String blNo, String usr_id) throws EventException{
		
		try {
			// Reopen 寃쎌슦
			// UC CS NO, B/L NO 蹂? Container ?뺣낫瑜?Master Container Table ??諛섏쁺
			
			// 2. CIM_UC_CGO, CIM_UC_CGO_DTL 泥섎━
			// 2.1 Login/ Handling/ Counter User ?ㅼ젙
//			uncollectedCargoVO.setHndlUpdId(strLgnUsr);
//			uncollectedCargoVO.setHndlUpdDt("SYSDATE");
//			uncollectedCargoVO.setKntrUpdId("");				
//			uncollectedCargoVO.setKntrUpdDt("");	
			
			dbDao.manageUncollectedCargoCreationModifyMaster5(managerMemo,isAuthority,ucCsNo,blNo,usr_id);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	/**
	 * UC Inquiry 由ъ뒪??議고쉶 [EES_CIM_0064]<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUncollectedInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		DBRowSet rowSet=null; // ?곗씠???꾩넚???꾪빐 DB ResultSet??援ы쁽??媛앹껜
		EesCim0064Event event=(EesCim0064Event)e;
		try {
			rowSet=dbDao.searchUncollectedInquiryList(event);
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());		
		}
	}
	
	/**
	 * UC Activity 議고쉶 泥섎━ [EES_CIM_0066]<br>
	 * 
	 * @param searchUncollectedCargoFileVO SearchUncollectedCargoFileVO 
	 * @return List<SearchRecoveryActivityManageListVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedCargoFileVO> searchUncollectedCargoFileList(SearchUncollectedCargoFileVO searchUncollectedCargoFileVO) throws EventException {
		try {   
			return dbDao.searchUncollectedCargoFileListValue(searchUncollectedCargoFileVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * UC Activity ??옣/?섏젙/??젣 泥섎━ [EES_CIM_0066]<br>
	 * 
	 * @param searchUncollectedCargoFileVO SearchUncollectedCargoFileVO[] 
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageUncollectedCargoFile(SearchUncollectedCargoFileVO[] searchUncollectedCargoFileVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchUncollectedCargoFileVO> insertVoList = new ArrayList<SearchUncollectedCargoFileVO>();
			List<SearchUncollectedCargoFileVO> updateVoList = new ArrayList<SearchUncollectedCargoFileVO>();
			List<SearchUncollectedCargoFileVO> deleteVoList = new ArrayList<SearchUncollectedCargoFileVO>();
			for ( int i=0; i<searchUncollectedCargoFileVO .length; i++ ) {
				if ( searchUncollectedCargoFileVO[i].getIbflag().equals("I")){
					searchUncollectedCargoFileVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(searchUncollectedCargoFileVO[i]);
				} else if ( searchUncollectedCargoFileVO[i].getIbflag().equals("U")){
					searchUncollectedCargoFileVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchUncollectedCargoFileVO[i]);
				} else if ( searchUncollectedCargoFileVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchUncollectedCargoFileVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addManageUncollectedCargoFileVOS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManageUncollectedCargoFileVOS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManageUncollectedCargoFileVOS(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * UC-VOL_DTL 議고쉶 泥섎━ [EES_CIM_0070]<br>
	 * 
	 * @param searchUncollectedVolDtlListVO SearchUncollectedVolDtlListVO 
	 * @return List<SearchRecoveryActivityManageListVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlList(SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO) throws EventException {
		try {   
			return dbDao.searchUncollectedVolDtlList(searchUncollectedVolDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Help Exchange 由ъ뒪??議고쉶 - ?꾩썡/?듯솕肄붾뱶蹂??섏쑉議고쉶 [EES_CIM_0071]<br>
	 * 
	 * @param searchUncollectedGlMonXchRtListVO SearchUncollectedGlMonXchRtListVO 
	 * @return List<SearchRecoveryActivityManageListVO>
	 * @exception EventException
	 */
	public List<SearchUncollectedGlMonXchRtListVO> searchUncollectedGlMonXchRtList(SearchUncollectedGlMonXchRtListVO searchUncollectedGlMonXchRtListVO) throws EventException {
		try {   
			return dbDao.searchUncollectedGlMonXchRtList(searchUncollectedGlMonXchRtListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * Help Exchange - ?듯솕肄붾뱶Combo由ъ뒪??[EES_CIM_0071]<br>
	 * 
	 * @param e EES_CIM_0071Event
	 * @return EventResponse EES_CIM_0071EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrCdCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		EesCim0071Event event=(EesCim0071Event)e;
		DBRowSet rowSet=null; // ?곗씠???꾩넚???꾪빐 DB ResultSet??援ы쁽??媛앹껜
		String comboText = "";
		StringBuffer sb = new StringBuffer();
		try {
			rowSet = dbDao.searchCurrCdCombo(event);

			while(rowSet.next()){
				sb.append( rowSet.getString("CURR_CD") + rowSet.getString("CURR_CD") + "|" );
			}
			comboText = sb.toString();
			
			if(comboText.length()>0) comboText = comboText.substring(0, comboText.length()-1);
			eventResponse.setETCData("MUTI_STATUS", comboText);
			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}	
	
	/**
	 * UC File Attach ?낅줈?쒕맂 ?뚯씪?뺣낫(紐⑸줉) 議고쉶 ?대깽??泥섎━ [EES_CIM_0065]<br>
	 * @param e EesCim0065Event
	 * @return response EesCim0065Event
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event=(EesCim0065Event)e;
		DBRowSet rowSet=null; // ?곗씠???꾩넚???꾪빐 DB ResultSet??援ы쁽??媛앹껜
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd()); /// Add in 2007-04-05

			rowSet=dbDao.searchUploadFileInfo(event);
			return new EesCim0067Event(rowSet,"SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UC File Attach FileUpload?뺣낫 ??옣(?앹꽦) ?대깽??泥섎━ [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse createUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event=(EesCim0065Event)e;
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_id", sa.getUsr_id());
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd());
			
			String[] fileNoVal = dbDao.createUploadFileInfo(event.getCIM_TTL_FILE_MGMTS(), event);
			return new EesCim0067Event(fileNoVal);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UC File Attach FileUpload?뺣낫-怨듯넻?뚯씠釉???옣(?앹꽦) ?대깽??泥섎━ [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse createUploadFileInfoCOM(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event=(EesCim0065Event)e;
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_id", sa.getUsr_id());
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd());
			
			String[] fileNoVal = dbDao.createUploadFileInfoCOM(event.getCIM_TTL_FILE_MGMTS(), event);
			return new EesCim0067Event(fileNoVal);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UC File Attach FileUpload?뺣낫 ??젣 ?대깽??泥섎━ [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse removeUploadFiles(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event=(EesCim0065Event)e;
		HashMap params = event.getEventParams(); 
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			params.put("user_id", sa.getUsr_id());
			params.put("user_ofc_cd", sa.getOfc_cd());
			
			boolean isSuccessFlag = dbDao.removeUploadFiles(event);

			String strSuccessFlag = "false";
			if ( isSuccessFlag ) {
				strSuccessFlag = "true";
			}

			return new EesCim0067Event(strSuccessFlag);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * UC File Attach FileUpload?뺣낫-怨듯넻 ??젣 ?대깽??泥섎━ [EES_CIM_0067]<br>
	 * @param e EesCim0065Event
	 * @return EventResponse EesCim0067Event
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse removeUploadFilesCOM(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCim0065Event event=(EesCim0065Event)e;
		HashMap params = event.getEventParams(); 
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			params.put("user_id", sa.getUsr_id());
			params.put("user_ofc_cd", sa.getOfc_cd());
			
			boolean isSuccessFlag = dbDao.removeUploadFilesCOM(event);

			String strSuccessFlag = "false";
			if ( isSuccessFlag ) {
				strSuccessFlag = "true";
			}

			return new EesCim0067Event(strSuccessFlag);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * EES_CIM_0072 Retrieve<br>
	 * UC Authorizer Setting.<br>
	 * 
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoAuthorizerVO> searchUncollectedCargoAuthorizer(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws EventException {
		
		try {
			return dbDao.searchUncollectedCargoAuthorizer(uncollectedCargoAuthorizerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	
	/**
	 * EES_CIM_0072 Check<br>
	 * UC Authorizer Setting.<br>
	 * 
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception EventException
	 */
	public List<UncollectedCargoAuthorizerVO> checkAuthorizerInputId(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws EventException {
		
		try {
			return dbDao.checkAuthorizerInputId(uncollectedCargoAuthorizerVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
	
	
	/**
	 * SUC Authorizer <br>
	 * 
	 * @param UncollectedCargoAuthorizerVO[] uncollectedCargoAuthorizerVOs
	 * @param String usrid 
	 * @exception EventException
	 */
	public void manageUncollectedCargoAuthorizer(UncollectedCargoAuthorizerVO[] uncollectedCargoAuthorizerVOs, String usrid) throws EventException {
		
		try {
			List<UncollectedCargoAuthorizerVO> addList = new ArrayList<UncollectedCargoAuthorizerVO>();
			dbDao.manageUncollectedCargoAuthorizerDel(usrid);
			
			for ( int i=0; i<uncollectedCargoAuthorizerVOs .length; i++ ) {
					uncollectedCargoAuthorizerVOs[i].setCreUsrId(usrid);
					uncollectedCargoAuthorizerVOs[i].setUpdUsrId(usrid);
					if(uncollectedCargoAuthorizerVOs[i].getIbflag().equals("I")){
						addList.add(uncollectedCargoAuthorizerVOs[i]);
					}
			}
			
			if ( addList.size() > 0 ) {
				dbDao.manageUncollectedCargoAuthorizer(addList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CIM21002").getMessage(),ex);
		}
	}
		
}
