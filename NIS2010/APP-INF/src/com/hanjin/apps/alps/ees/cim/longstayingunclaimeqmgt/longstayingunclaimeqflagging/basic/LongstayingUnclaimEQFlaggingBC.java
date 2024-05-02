/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQFlaggingBC.java
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

import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
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
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CimEqSplsDfctEmlVO;
import com.hanjin.syscommon.common.table.CimEqSplsDfctStsVO;

/**
 * ALPS-Longstayingunclaimeqmgt Business Logic Command Interface<br>
 * - ALPS-Longstayingunclaimeqmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_0021EventResponse 참조
 * @since J2EE 1.6
 */

public interface LongstayingUnclaimEQFlaggingBC {
	
	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;
	

	/**
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,MVMT Status 별, EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysListSmryVO>
	 * @exception EventException
	 */
	public List<SDaysListSmryVO> searchSDaysListTotalDays(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * 컨테이너 번호별로 Total S/Days의 체류일수를 CNTR MVMT Status별 체류일수를 집계하여 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysByMvmt(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<SDaysLisDetailVO>
	 * @exception EventException
	 */
	public List<SDaysLisDetailVO> searchSDaysListTotalDaysDetail(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 COR Draft를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchCorDraft(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;
	
	/**
	 * RCV/DEL list를 조회한다.<br>
	 * 
	 * @param String pCode
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchRcvDelCodeBasic(String pCode) throws EventException;

	/**
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<LongStayUclmDetailVO>
	 * @exception EventException
	 */
	public List<LongStayUclmDetailVO> searchFlaggingTargetList(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 *  장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 * 
	 * @param LongStayUclmDetailVO[] longStayUclmDetailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageFlagging(LongStayUclmDetailVO[] longStayUclmDetailVOs,SignOnUserAccount account) throws EventException;

	/**
	 * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.<br>
	 * 
	 * @param FlaggingSDaysOptionVO 	flaggingSDaysOptionVO 
	 * @return List<FlaggingListSmryVO>
	 * @exception EventException
	 */
	public List<FlaggingListSmryVO> searchFlaggingStatusListSmry(FlaggingSDaysOptionVO  flaggingSDaysOptionVO ) throws EventException;

	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
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
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInputList(String rhqCd, String periodWeek, String scontiCd, String lccCd, String eccCd) throws EventException;
	
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
	public List<EQBalanceReportInputListVO> mainSearchEQBalanceReportInquiryList(String rhqCd, String fmWeek, String toWeek, String scontiCd, String lccCd, String eccCd) throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchLclHqOfcCd() throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchGlblhqOfcCd() throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @param String ofcCd
	 * @param String pageType
	 * @return String
	 * @exception EventException
	 */
	public String searchHdQtrByOfcCd(String ofcCd, String pageType) throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchNowWeek() throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Preceding Retrieve<br>
	 * EQ Balance Report.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchLastWeek() throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : Sub-Conti Code Retrieve<br>
	 * For Setting Sub-Conti Code<br>
	 * 
	 * @param String rhqCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSubContiCd(String rhqCd) throws EventException;
	
	/**
	 * EES_CIM_0060, EES_CIM_0061, EES_CIM_0062 : LCC Code Retrieve<br>
	 * For Setting LCC Code<br>
	 * 
	 * @param String scontiCd
	 * @param String rhqCd
	 * @return String
	 * @exception EventException
	 */
	public String searchLccCd(String scontiCd, String rhqCd) throws EventException;
	
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
	public String searchEccCd(String scontiCd, String lccCd, String rhqCd) throws EventException;
	
	/**
	 * EES_CIM_0060 : Save<br>
	 * 
	 * @param CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEQBalanceReportInput(CimEqSplsDfctStsVO[] cimEqSplsDfctStsVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * EES_CIM_0062 PreSearch before Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @return int cntByUsrId
	 * @exception EventException
	 */
	public int cntOfCimEqSplsDfctEmlByUsrId(String usrId) throws EventException;
	
	/**
	 * EES_CIM_0062 Retrieve<br>
	 * Mailing Service Setting.<br>
	 * 
	 * @param String usrId
	 * @param int cnt
	 * @return List<MailingServiceSettingListVO>
	 * @exception EventException
	 */
	public List<MailingServiceSettingListVO> mainSearchMailingServiceSettingList(String usrId, int cnt) throws EventException;
	
	/**
	 * EES_CIM_0062 : Save<br>
	 * 
	 * @param MailingServiceSettingListVO[] mailingServiceSettingListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMailingServiceSetting(MailingServiceSettingListVO[] mailingServiceSettingListVOs, SignOnUserAccount account) throws EventException;
	
}