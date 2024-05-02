/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingBC.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingSDaysOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Longstayingunclaimeqmgt Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_cim_0021EventResponse reference
 * @since J2EE 1.6
 */

public interface LongstayingUnclaimEQFlaggingBC {
	
	/**
	 * retrieving long staying Full/ MTY container information by region,EQ TP&SZ
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;
	

	/**
	 * retrieving long staying Full/ MTY container information by region, MVMT Status, EQ TP&SZ
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving staying container's movement history, retrieving staying days by region, EQ TP&SZ, MVMT Status
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListTotalDays(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving Total S/Days by EQ by counting EQ staying days for movement status
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving Total S/Days for EQ including first-in date, yard, current movement and yard information
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving long staying EQ and unclaim condition EQ information
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * registering solution plan for long staying EQ and unclaim EQ flag
	 *  
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFlagging(LongStayUclmDetailVO[] longStayUclmDetailVOs,SignOnUserAccount account) throws EventException;

	/**
	 * retrieving L/S and U/C flag EQ in L/S & U/C Creation menu
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<FlaggingListSmryVO>
	 * @exception EventException
	 */
	public List<FlaggingListSmryVO> searchFlaggingStatusListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * retrieving staying container no and related booking information for search date, region
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<CntrFdayListVO> searchCntrFdayList(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO 	oPInventoryForPseudoBookingOptionVO
	 * @return List<OPInventoryForPseudoBookingSummayVO>
	 * @exception EventException
	 */
	public List<OPInventoryForPseudoBookingSummayVO> searchOPInventoryForPseudoBookingList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException;

	/**
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param OPInventoryForPseudoBookingOptionVO 	oPInventoryForPseudoBookingOptionVO
	 * @return List<OPInventoryForPseudoBookingDetailVO>
	 * @exception EventException
	 */
	public List<OPInventoryForPseudoBookingDetailVO> searchOPInventoryForPseudoBookingDetailList(OPInventoryForPseudoBookingOptionVO  oPInventoryForPseudoBookingOptionVO ) throws EventException;
	
	/**
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return int
	 * @exception EventException 
	 */
	public int searchSDaysTotalCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException;
	
	/**
	 * retrieving long staying Full/ MTY container's booking/movement information by container number
	 * 
	 * @param FlaggingSDaysOptionVO  flaggingSDaysOptionVO  
	 * @return int
	 * @exception EventException 
	 */
	public int searchSDaysListTotalDaysCnt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO) throws EventException;

}