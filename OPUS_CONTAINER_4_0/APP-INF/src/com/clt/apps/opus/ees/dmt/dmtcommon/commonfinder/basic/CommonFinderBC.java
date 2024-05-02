/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonFinderBC.java
*@FileTitle : CommonFinder
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CustomerVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.DMTCommonVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.DayVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.RhqOfcCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.SheetSetVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Dmtcommon Business Logic Command Interface<br>
 * @author
 * @see reference DmtcommonfinderEventResponse
 * @since J2EE 1.4
 */

public interface CommonFinderBC {
	
	/**
	 * search Region info.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Country info.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Country info. about Region Head Quarter.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByRHQ(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Country info. about Continent.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByContinent(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Region info  about Country
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionListByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search State info. about Country.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchStateListByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search higher level RHQ, Country, Region or State  include Location code.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRHQHierarchyByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search higher level RHQ, Country, Region or State, Location  include Location code.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRHQHierarchyByYard(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search higher level RHQ, Country, Region or State  include Location code
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchContinentHierarchyByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search  Tariff Type List.
	 * 
	 * @return List<TariffNameVO>
	 * @exception EventException
	 */
	public List<TariffNameVO> searchTariffTypeList() throws EventException;
	
	/**
	 * search Tariff Type List info and user defined Tariff Type info.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return DMTCommonVO	
	 * @exception EventException
	 */
	public DMTCommonVO searchTariffTypeList(String ofcCd, String usrId) throws EventException;
	
	/**
	 * search user defined Tariff Type info.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String searchUserTariffType(String ofcCd, String usrId) throws EventException;
	
	/**
	 * search  DemDet Office.
	 * 
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	 public List<OfficeNameVO> searchDemDetOfficeList() throws EventException;
	 
	 /**
	  *  search  DemDet Office by RHQ Office Code.
	  * 
	  * @param String rhqOfcCd
	  * @return List<OfficeNameVO>
	  * @exception EventException
	  */
	 public List<OfficeNameVO> searchOfficeListByRhq(String rhqOfcCd) throws EventException;
	 
	 /**
	  * search  DemDet sub Office
	  * 
	  * @param OfficeNameVO officeNameVO
	  * @return List<String>
	  * @exception EventException
	  */
	public List<String> searchDemDetSubOfficeList(OfficeNameVO officeNameVO) throws EventException;
	
	/**
	 * check validation of Booking No.
	 * 
	 * @param BookingNoVO bookingNoVO
	 * @return BookingNoVO
	 * @exception EventException
	 */
	public BookingNoVO checkBookingNo(BookingNoVO bookingNoVO) throws EventException;
	
	/**
	 * search  Continent, Country, Region or State of  Yard.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByYard(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Currency List.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CurrencyVO>
	 * @exception EventException
	 */
	public List<CurrencyVO> searchCurrencyList(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search RHQ Office List.
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchRHQOfficeList() throws EventException;
	
	/** searchAreaByOffice
	 * 
	 * @return List<String> 
	 * @throws EventException
	 */
	public List<String> searchAreaByOffice() throws EventException;
	
	/** searchOfficByCountry
	 * 
	 * @param CoverageVO coverageVO
	 * @return String
	 * @throws EventException
	 */
	public String searchOfficByCountry(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search  Continent, Country, State of  Region.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRHQHierarchyByRegion(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search  Continent.
	 * 
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchContinetList() throws EventException;
	
	/**
	 * search DEM/DET Container / Cargo.
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
	 * search Continent, Country of Region.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByRegion(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Continent, Country of State..
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchHierarchyByState(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search Yard of Location.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchYardListByLocation(CoverageVO coverageVO) throws EventException;
	
	/**
	 * search code of Common Code ID.
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */
	public List<CommonCodeVO> searchCommonCode(CommonCodeVO commonCodeVO) throws EventException;
	
	/**
	 * search higher level RHQ of Country<br>
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByCountry(CoverageVO coverageVO) throws EventException;	
	
	/**
	 * search  Region, State('CA','US').
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionStateList(CoverageVO coverageVO) throws EventException;

	/**
	 * check validation of Location Code.
	 * 
	 * @param LocationCdVO locationCdVO
	 * @return LocationCdVO
	 * @exception EventException
	 */
	public LocationCdVO checkLocationCd(LocationCdVO locationCdVO) throws EventException;
	
    /**
     * check validation of Location Code.
     * 
     * @param LocationCdVO locationCdVO
     * @return LocationCdVO
     * @exception EventException
     */
    public LocationCdVO checkLocationCd2(LocationCdVO locationCdVO) throws EventException;
	
	/**
	 * check validation of Country Code.
	 * 
	 * @param CountryCdVO countryCdVO
	 * @return CountryCdVO
	 * @exception EventException
	 */
	public CountryCdVO checkCountryCd(CountryCdVO countryCdVO) throws EventException;
	
	/**
	 * search Customer Name.
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(CustomerVO customerVO) throws EventException;	
	
	/**
	 * search DEM/DET Office of  RHQ Office Code.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchDemDetOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException;	
	
	/**
	 * search  RHQ Office Name of office.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRHQByOffice(OfficeNameVO officeNameVO) throws EventException;	

	/**
	 * search Payer Name.
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @exception EventException
	 */
	public PayerNameVO searchPayerName(PayerNameParamVO payerNameParamVO) throws EventException;	
	
	/**
	 * search Attention
	 * 
	 * @param AttentionVO attentionVO
	 * @return List<AttentionVO>
	 * @exception EventException
	 */
	public List<AttentionVO> searchAttention(AttentionVO attentionVO) throws EventException;
	
	/**
	 * search Service Provider Name
	 * 
	 * @param VendorNameVO vendorNameVO
	 * @return VendorNameVO
	 * @exception EventException
	 */
	public VendorNameVO searchServiceProviderName(VendorNameVO vendorNameVO) throws EventException;	
	
	/**
	 * search ARCurrency list.
	 * 
	 * @param String ofcCd
	 * @param String jspNo
	 * @return List<ARCurrencyVO>
	 * @exception EventException
	 */
	public List<ARCurrencyVO> searchARCurrencyList(String ofcCd, String jspNo) throws EventException;	
	
	/**
	 * search current date of OFC_CD.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCurrentDateByOffice(String ofcCd) throws EventException;
	
	/**
	 * checkTPBCustomerByVendor
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @exception EventException
	 */
	public PayerNameVO checkTPBCustomerByVendor(PayerNameParamVO payerNameParamVO) throws EventException;
	
	/**
	  * search AR Office of Office Code.
	  * 
	  * @param String ofcCd
	  * @param String rhqOfc
	  * @return List<OfficeNameVO>
	  * @exception EventException
	  */
	public List<OfficeNameVO> searchAROfficeList(String ofcCd, String rhqOfc) throws EventException;
	
	
	/**
	 * search authority of user.
	 * 
	 * @param UserRoleVO userRoleVO
	 * @return UserRoleVO
	 * @exception EventException
	 */
	public UserRoleVO hasRoleAuth(UserRoleVO userRoleVO) throws EventException;	
	
	/**
	 * search SHEET SET
	 * 
	 * @param SheetSetVO sheetSetVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasSheetSet(SheetSetVO sheetSetVO) throws EventException;		
	
	
	/**
	 * search  sheet Option  by office.<br>
	 * 
	 * @param SheetOptionByOfficeVO sheetOptionByOfficeVO
	 * @return SheetOptionByOfficeVO
	 * @throws EventException
	 */
	public SheetOptionByOfficeVO searchSheetOptionByOffice(SheetOptionByOfficeVO sheetOptionByOfficeVO) throws EventException;
	
    /**
     * search commodity.
     * 
     * @param String cmdtCd
     * @return String
     * @exception EventException
     */
    public String searchCommodityName(String cmdtCd) throws EventException;
    
	/**
	 * search Country of Office<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchUserCntCode(String ofcCd) throws EventException;
    
	/**
	 * search Duration of From Date and To Date. <br>
	 *
	 * @param DayVO dayVO
	 * @return String
	 * @throws EventException
	 */
    public String searchDaysBetween(DayVO dayVO) throws EventException;   
    
	/**
	 *  search RHQ_OFC_CD of OFC_CD <br>
	 *
	 * @param RhqOfcCodeVO rhqOfcCodeVO
	 * @return String
	 * @throws EventException
	 */
    public String searchRhqOfcCdByOfcCd(RhqOfcCodeVO rhqOfcCodeVO) throws EventException;  
    
	/**
	 * search SYS_AREA_GRP_ID of OFC_CD<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchUserSysAreaGrpId(String ofcCd) throws EventException;
    
	/**
	 * creating yard list used in combo
	 *
	 * @param CoverageVO coverageVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchYardSubCodeForCombo(CoverageVO coverageVO) throws EventException;

	/**
	 * search Rep Cust Seq of Office<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchRepCustSeq(String ofcCd) throws EventException;
    
}