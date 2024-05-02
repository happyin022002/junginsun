/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonFinderBC.java
*@FileTitle : CommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.DMTCommonVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.DayVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.RhqOfcCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.SheetSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Dmtcommon Business Logic Command Interface<br>
 * - NIS2010-Dmtcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee 
 * @see DmtcommonfinderEventResponse 참조
 * @since J2EE 1.4
 */

public interface CommonFinderBC {
	
	/**
	 * 모든 Region 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Region Head Quarter 에 포함된 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByRHQ(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Continent 에 포함된 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByContinent(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Country 에 포함된 모든 Region 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionListByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Country 에 포함된 모든 State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchStateListByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Location 를 포함하고 있는 상위 RHQ, Country, Region or State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRHQHierarchyByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Location 를 포함하고 있는 상위 Continent, Country, Region or State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchContinentHierarchyByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Tariff Type List 정보를 조회한다.
	 * 
	 * @return List<TariffNameVO>
	 * @exception EventException
	 */
	public List<TariffNameVO> searchTariffTypeList() throws EventException;
	
	/**
	 * Tariff Type List 정보와 User별 설정 Tariff Type 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return DMTCommonVO	
	 * @exception EventException
	 */
	public DMTCommonVO searchTariffTypeList(String ofcCd, String usrId) throws EventException;
	
	/**
	 * User별 설정된 Tariff Type 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchUserTariffType(String ofcCd, String usrId) throws EventException;
	
	/**
	 * DemDet Office 정보를 조회한다.
	 * 
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	 public List<OfficeNameVO> searchDemDetOfficeList() throws EventException;
	 
	 /**
	  * RHQ Office Code 값을 이용해서 DemDet Office 정보를 조회한다.
	  * 
	  * @param String rhqOfcCd
	  * @param String otsFlg
	  * @return List<OfficeNameVO>
	  * @exception EventException
	  */
	 public List<OfficeNameVO> searchOfficeListByRhq(String rhqOfcCd, String otsFlg) throws EventException;
	 
	 /**
	  * DemDet Sub Office 정보를 조회한다.
	  * 
	  * @param OfficeNameVO officeNameVO
	  * @return List<String>
	  * @exception EventException
	  */
	public List<String> searchDemDetSubOfficeList(OfficeNameVO officeNameVO) throws EventException;
	
	/**
	 * 해당 Booking No.의 유효성을 체크한다.
	 * 
	 * @param BookingNoVO bookingNoVO
	 * @return BookingNoVO
	 * @exception EventException
	 */
	public BookingNoVO checkBookingNo(BookingNoVO bookingNoVO) throws EventException;
	
	/**
	 * Yard의 정보를 바탕으로 해당하는 대륙,국가,지역등의 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByYard(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Currency List 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CurrencyVO>
	 * @exception EventException
	 */
	public List<CurrencyVO> searchCurrencyList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * RHQ Office List 정보를 조회한다.
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchRHQOfficeList() throws EventException;
	
	/**
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRHQHierarchyByRegion(CoverageVO coverageVO) throws EventException;
	
	/**
	 * 대륙 정보를 조회한다.
	 * 
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchContinetList() throws EventException;
	
	/**
	 * DEM/DET Container / Cargo 정보를 조회한다.
	 * 
	 * @param ContainerCargoVO containerCargoVO
	 * @return List<ContainerCargoVO>
	 * @exception EventException
	 */
	public List<ContainerCargoVO> searchContainterCargoList(ContainerCargoVO containerCargoVO) throws EventException;
	
	/**
	 * Country 정보로 Continent 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchContinentByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByRegion(CoverageVO coverageVO) throws EventException;
	
	/**
	 * State 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByState(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Location 정보를 바탕으로 해당하는 Yard 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchYardListByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * Common Code ID 로 Code 목록정보를 조회한다.
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
	public List<CommonCodeVO> searchCommonCode(CommonCodeVO commonCodeVO) throws EventException;
	
//	/**
// 	 * DEM/DET Container / Cargo 정보를 조회한다.
//	 * 
//	 * @param CommonCodeVO commonCodeVO
//	 * @return List<CommonCodeVO>
//	 * @exception EventException
//	 */
//	public List<CommonCodeVO> searchCommonCodeForContainerCargo(CommonCodeVO commonCodeVO) throws EventException;	
	
	/**
	 * Country 정보를 바탕으로 해당하는 상위 RHQ 정보 조회<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByCountry(CoverageVO coverageVO) throws EventException;	
	
	/**
	 * 모든 Region, State('CA','US') 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionStateList(CoverageVO coverageVO) throws EventException;

	/**
	 * 해당 Location Code의 유효성을 체크한다.
	 * 
	 * @param LocationCdVO locationCdVO
	 * @return LocationCdVO
	 * @exception EventException
	 */
	public LocationCdVO checkLocationCd(LocationCdVO locationCdVO) throws EventException;
	
    /**
     * 해당 Location Code의 유효성을 체크한다.
     * 
     * @param LocationCdVO locationCdVO
     * @return LocationCdVO
     * @exception EventException
     */
    public LocationCdVO checkLocationCd2(LocationCdVO locationCdVO) throws EventException;
	
	/**
	 * 해당 Country Code의 유효성을 체크한다.
	 * 
	 * @param CountryCdVO countryCdVO
	 * @return CountryCdVO
	 * @exception EventException
	 */
	public CountryCdVO checkCountryCd(CountryCdVO countryCdVO) throws EventException;
	
	/**
	 * Customer Name 정보를 조회한다.
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(CustomerVO customerVO) throws EventException;	
	
	/**
	 * RHQ Office Code에 따른 DEM/DET Office 정보를 조회한다.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchDemDetOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException;	
	
	/**
	 * 해당 Office의 RHQ Office Name 정보를 조회한다.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRHQByOffice(OfficeNameVO officeNameVO) throws EventException;	

	/**
	 * Payer Name 정보를 조회한다.
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @exception EventException
	 */
	public PayerNameVO searchPayerName(PayerNameParamVO payerNameParamVO) throws EventException;	
	
	/**
	 * Atttention 정보를 조회한다.
	 * 
	 * @param AttentionVO attentionVO
	 * @return List<AttentionVO>
	 * @exception EventException
	 */
	public List<AttentionVO> searchAttention(AttentionVO attentionVO) throws EventException;
	
	/**
	 * Service Provider Name 정보를 조회한다.
	 * 
	 * @param VendorNameVO vendorNameVO
	 * @return VendorNameVO
	 * @exception EventException
	 */
	public VendorNameVO searchServiceProviderName(VendorNameVO vendorNameVO) throws EventException;	
	
	/**
	 * ARCurrency 리스트 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String jspNo
	 * @return List<ARCurrencyVO>
	 * @exception EventException
	 */
	public List<ARCurrencyVO> searchARCurrencyList(String ofcCd, String jspNo) throws EventException;	
	
	/**
	 * OFC_CD별 현재일자를 조회한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCurrentDateByOffice(String ofcCd) throws EventException;
	
	/**
	  * Office Code에 대한 AR Office 정보를 조회한다.
	  * 
	  * @param String ofcCd
	  * @param String rhqOfc
	  * @return List<OfficeNameVO>
	  * @exception EventException
	  */
	public List<OfficeNameVO> searchAROfficeList(String ofcCd, String rhqOfc) throws EventException;
	
	
	/**
	 * 사용자에게 부여된 권한정보를 조회한다.
	 * 
	 * @param UserRoleVO userRoleVO
	 * @return UserRoleVO
	 * @exception EventException
	 */
	public UserRoleVO hasRoleAuth(UserRoleVO userRoleVO) throws EventException;	
	
	/**
	 * SHEET SET 정보 존재여부를 조회한다.
	 * 
	 * @param SheetSetVO sheetSetVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasSheetSet(SheetSetVO sheetSetVO) throws EventException;		
	
	
	/**
	 * office별 sheet Option 내용을 조회한다.<br>
	 * 
	 * @param SheetOptionByOfficeVO sheetOptionByOfficeVO
	 * @return SheetOptionByOfficeVO
	 * @throws EventException
	 */
	public SheetOptionByOfficeVO searchSheetOptionByOffice(SheetOptionByOfficeVO sheetOptionByOfficeVO) throws EventException;
	
    /**
     * commodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @exception EventException
     */
    public String searchCommodityName(String cmdtCd) throws EventException;
    
	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchUserCntCode(String ofcCd) throws EventException;
    
	/**
	 * From Date, To Date 사이의 차이 일수를 조회 합니다. <br>
	 *
	 * @param DayVO dayVO
	 * @return String
	 * @throws EventException
	 */
    public String searchDaysBetween(DayVO dayVO) throws EventException;   
    
	/**
	 * OFC_CD로 RHQ_OFC_CD를 조회 합니다. <br>
	 *
	 * @param RhqOfcCodeVO rhqOfcCodeVO
	 * @return String
	 * @throws EventException
	 */
    public String searchRhqOfcCdByOfcCd(RhqOfcCodeVO rhqOfcCodeVO) throws EventException;
    
	/**
	 * Yard Code의 유효성을 체크.
	 * 
	 * @param String yd_Cd
	 * @return String
	 * @throws EventException
	 */
	public String checkYardCd(String yd_Cd) throws EventException;
	
	/**
	 * 해당 Yard Code MDM 정보를 조회한다. 
	 * 
	 * @param String yd_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchYardInfo(String yd_cd) throws EventException;
	
	/**
	 * User ID 소속 Office Code를 조회<br>
	 *
	 * @param String usrId
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchUserOfcCd(String usrId) throws EventException;
    
	/**
	 * User ID 소속 Office의 Local Time 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchOfcLocalTime(String ofcCd) throws EventException;
    
    /**
	 * User ID 소속 Office의 Local Time 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return UserInfoVO
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public UserInfoVO searchUserInfo(SignOnUserAccount account) throws EventException;
    
	/**
	 * DMT User Role 정보를 확인<br>
	 *
	 * @param UserRoleVO userRoleVO
	 * @return String
	 * @throws EventException
	 * @Exception SQLException, Exception
	 */
	public String searchUserRoleCode(UserRoleVO userRoleVO) throws EventException;
	
//	/**
//	 * TRADE 코드 조회<br>
//	 *
//	 * @return List<CommonCodeVO>
//	 * @throws EventException
//	 */	
//	public List<CommonCodeVO> searchTradeCode() throws EventException;
	
	/**
	 * 사용자의 Log-in Office Level 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUserOfcLvl(String ofcCd) throws EventException;	
	
	/**
	 * RHQ 산하 DMT OFC 를 조회합니다.<br>
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	public List<OfficeNameVO> searchSubOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException;	
	
	/**
	 * 사용자 로그인 Office 산하 DMT Office 를 조회한다.<br>
	 * 
	 * @param String loginOfcCd
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	public List<OfficeNameVO> searchSubOfficeListByUserLoginOffice(String loginOfcCd) throws EventException;
	
	/**
	 * OFC에 해당하는 SYS_AREA_GRP_ID(SVR_ID)를 구한다<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSysAreaGrpId(String ofcCd) throws EventException;
	
	/**
	 * Payer 정보가 DMT_PAYR_INFO 테이블에 존재하는지 확인한다.(Y/N) 
	 * 
	 * @param String svrId
	 * @param String payrCd
	 * @return String
	 * @exception EventException
	 */
	public String checkDmtPayerInfo(String svrId, String payrCd) throws EventException;
	
}