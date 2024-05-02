/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonFinderBCImpl.java
*@FileTitle : CommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
* 2013.04.18 임창빈 [CHM-201324214] [DMT] 미주 MT Notification data display 요청
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.integration.CommonFinderDBDAO;
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
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTCommon Business Logic Basic Command implementation<br>
 * - NIS2010-DMTCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SungHoon, Lee
 * @see DMTCommonFinderEventResponse,DMTCommonFinderBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CommonFinderBCImpl extends BasicCommandSupport implements CommonFinderBC {

	// Database Access Object
	private transient CommonFinderDBDAO dbDao = null;
	
	/**
	 * DMTCommonFinderBCImpl 객체 생성<br>
	 * DMTCommonFinderDBDAO를 생성한다.<br>
	 */
	public CommonFinderBCImpl() {
		dbDao = new CommonFinderDBDAO();
	}
	
	/**
	 * 모든 Region 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionList(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			list = dbDao.searchRegionList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryList(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			if ("DUAL".equals(coverageVO.getTp())) {
				list = dbDao.searchDualCountryList();
			}
			else {
				list = dbDao.searchCountryList();
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Region Head Quarter 에 포함된 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByRHQ(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			list = dbDao.searchCountryListByRHQ(coverageVO.getSvrId());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Continent 에 포함된 모든 Country 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchCountryListByContinent(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			list = dbDao.searchCountryListByContinent(coverageVO.getContiCd());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Country 에 포함된 모든 Region 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRegionListByCountry(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			if ("DUAL".equals(coverageVO.getTp())) {
				list = dbDao.searchDualRegionListByCountry(coverageVO.getCntCd());
			} 
			else {
				list = dbDao.searchRegionListByCountry(coverageVO.getCntCd());
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Country 에 포함된 모든 State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchStateListByCountry(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			if ("DUAL".equals(coverageVO.getTp())) {
				list = dbDao.searchDualStateListByCountry(coverageVO.getCntCd());
			} 
			else {
				list = dbDao.searchStateListByCountry(coverageVO.getCntCd());
			}			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Location 를 포함하고 있는 상위 RHQ, Country, Region or State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByLocation(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			if ("DUAL".equals(coverageVO.getTp())) {
				list = dbDao.searchDualRHQHierarchyByLocation(coverageVO.getLocCd());
			} 
			else {
				list = dbDao.searchRHQHierarchyByLocation(coverageVO.getLocCd());
			}	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Location 를 포함하고 있는 상위 Continent, Country, Region or State 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchContinentHierarchyByLocation(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			list = dbDao.searchContinentHierarchyByLocation(coverageVO.getLocCd());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * Tariff Type List 정보를 조회한다.
	 * 
	 * @return List<TariffNameVO>
	 * @exception EventException
	 */	
	public List<TariffNameVO> searchTariffTypeList() throws EventException {
		try {
			return dbDao.searchTariffTypeList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Tariff Type List 정보와 User별 설정 Tariff Type 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return List<TariffNameVO>
	 * @exception EventException
	 */	
	public DMTCommonVO searchTariffTypeList(String ofcCd, String usrId) throws EventException {
		try {
			List<TariffNameVO> list = dbDao.searchTariffTypeList();
			String userTariffType = dbDao.searchUserTariffType(ofcCd, usrId);
			
			DMTCommonVO dmtCommonVO = new DMTCommonVO();
			dmtCommonVO.setTariffNameVOs(list);
			
			if(userTariffType.equals("All"))
				userTariffType = "DMIF,DTIC,DMOF,DTOC,CTIC,CTOC,All";
			
			dmtCommonVO.setUserTariffType(userTariffType);
			return dmtCommonVO;
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * User별 설정된 Tariff Type 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */	
	public String searchUserTariffType(String ofcCd, String usrId) throws EventException {
		try {
			return dbDao.searchUserTariffType(ofcCd, usrId);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DemDet Office 정보를 조회한다.
	 * 
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */	
	public List<OfficeNameVO> searchDemDetOfficeList() throws EventException {
		try {
			return dbDao.searchDemDetOfficeList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RHQ Office Code 값을 이용해서 DemDet Office 정보를 조회한다.
	 * 
	 * @param String rhqOfcCd
	 * @param String otsFlg
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */	
	public List<OfficeNameVO> searchOfficeListByRhq(String rhqOfcCd, String otsFlg) throws EventException {
		try {
			return dbDao.searchOfficeListByRhq(rhqOfcCd, otsFlg);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DemDet Sub Office 정보를 조회한다.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchDemDetSubOfficeList(OfficeNameVO officeNameVO) throws EventException {
		try {
			return dbDao.searchDemDetSubOfficeList(officeNameVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Booking No.의 유효성을 체크한다.
	 * 
	 * @param BookingNoVO bookingNoVO
	 * @return BookingNoVO
	 * @exception EventException
	 */	
	public BookingNoVO checkBookingNo(BookingNoVO bookingNoVO) throws EventException {
		try {
			return dbDao.checkBookingNo(bookingNoVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Location Code의 유효성을 체크한다. 
	 * 
	 * @param LocationCdVO locationCdVO
	 * @return LocationCdVO
	 * @exception EventException
	 */
	public LocationCdVO checkLocationCd(LocationCdVO locationCdVO) throws EventException {
		try {
			return dbDao.checkLocationCd(locationCdVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * 해당 Location Code의 유효성을 체크한다. 
     * 
     * @param LocationCdVO locationCdVO
     * @return LocationCdVO
     * @exception EventException
     */
    public LocationCdVO checkLocationCd2(LocationCdVO locationCdVO) throws EventException {
        try {
            return dbDao.checkLocationCd2(locationCdVO);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }
	
	/**
	 * 해당 Country Code의 유효성을 체크한다.
	 * 
	 * @param CountryCdVO countryCdVO
	 * @return CountryCdVO
	 * @exception EventException
	 */
	public CountryCdVO checkCountryCd(CountryCdVO countryCdVO) throws EventException {
		try {
			return dbDao.checkCountryCd(countryCdVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Yard의 정보를 바탕으로 해당하는 대륙,국가,지역등의 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchHierarchyByYard(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchHierarchyByYard(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Currency List 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CurrencyVO>
	 * @exception EventException
	 */	
	public List<CurrencyVO> searchCurrencyList(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchCurrencyList(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RHQ Office List 정보를 조회한다.
	 * 
	 * @return List<String>
	 * @exception EventException
	 */	
	public List<String> searchRHQOfficeList() throws EventException {
		try {
			return dbDao.searchRHQOfficeList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByRegion(CoverageVO coverageVO) throws EventException {
		
		List<CoverageVO> 	coverageVOs 	= null;
		
		try {
			//주어진 Region 필드에 있는 정보가 Region 인지, State 인지 조회한다.
			if (dbDao.isStateCode(coverageVO.getRgnCd())) {
				coverageVOs = dbDao.searchRHQHierarchyByState(coverageVO.getRgnCd());
			}
			else {
				coverageVOs = dbDao.searchRHQHierarchyByRegion(coverageVO.getRgnCd());
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return coverageVOs;
	}
	
	/**
	 * 대륙 정보를 조회한다.<br>
	 * 
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchContinetList() throws EventException {
		try {
			return dbDao.searchContinetList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DEM/DET Container / Cargo 정보를 조회한다.
	 * 
	 * @param ContainerCargoVO containerCargoVO
	 * @return List<ContainerCargoVO>
	 * @exception EventException
	 */	
	public List<ContainerCargoVO> searchContainterCargoList(ContainerCargoVO containerCargoVO) throws EventException {
		try {
			return dbDao.searchContainterCargoList(containerCargoVO.getCode1(), containerCargoVO.getCode2());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Country 정보로 Continent 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchContinentByCountry(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchContinentByCountry(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Region의 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchHierarchyByRegion(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchHierarchyByRegion(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * State 정보를 바탕으로 해당하는 대륙,국가 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchHierarchyByState(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchHierarchyByState(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * Location 정보를 바탕으로 해당하는 Yard 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchYardListByLocation(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchYardListByLocation(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Common Code ID 로 Code 목록정보를 조회한다.
	 * 
	 * @param CommonCodeVO commonCodeVO
	 * @return List<CommonCodeVO>
	 * @exception EventException
	 */	
	public List<CommonCodeVO> searchCommonCode(CommonCodeVO commonCodeVO) throws EventException {
		try {
			return dbDao.searchCommonCode(commonCodeVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
//	/**
//	 * Common Code ID 로 Code 목록정보를 조회한다.
//	 * 
//	 * @param CommonCodeVO commonCodeVO
//	 * @return List<CommonCodeVO>
//	 * @exception EventException
//	 */	
//	public List<CommonCodeVO> searchCommonCodeForContainerCargo(CommonCodeVO commonCodeVO) throws EventException {
//		
//		List<CommonCodeVO> listCommCode = null;
//		
//		try {
//			String[] arrCommCode = commonCodeVO.getIntgCdId().split(":");
//			List<ContainerCargoVO> listContainerCargo = dbDao.searchContainterCargoList(arrCommCode[0], arrCommCode[1]);
//			
//			if (listContainerCargo != null && listContainerCargo.size() > 0) {
//				listCommCode = new ArrayList<CommonCodeVO>();
//				CommonCodeVO commonCode = null;
//				for (ContainerCargoVO containerCargo : listContainerCargo) {
//					commonCode = new CommonCodeVO();
//					commonCode.setIntgCdValCtnt(containerCargo.getIntgCdValCtnt());
//					commonCode.setIntgCdValDpDesc(containerCargo.getIntgCdValDpDesc());
//					listCommCode.add(commonCode);
//				}
//			}
//
//			return listCommCode;
//		} 
//		catch (DAOException ex) {
//			log.error("[DAOException]"+ex.getMessage());
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} 
//		catch (Exception ex) {
//			log.error("[Exception]"+ex.getMessage());
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}
//	}
	
	/**
	 * Country 정보를 바탕으로 해당하는 상위 RHQ 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByCountry(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchRHQHierarchyByCountry(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 모든 Region, State('CA','US') 정보를 조회한다.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */
	public List<CoverageVO> searchRegionStateList(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			list = dbDao.searchRegionState();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * Customer Name 정보를 조회한다.
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerName(CustomerVO customerVO) throws EventException {
		String custNm = null;
		try {
			custNm = dbDao.searchCustomerName(customerVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return custNm;
	}
	
	/**
	 * RHQ Office Code에 따른 DEM/DET Office 정보를 조회한다.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchDemDetOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException {
		try {
			return dbDao.searchDemDetOfficeListByRHQ(officeNameVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Office의 RHQ Office Name 정보를 조회한다.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return String
	 * @exception EventException
	 */
	public String searchRHQByOffice(OfficeNameVO officeNameVO) throws EventException {
		try {
			return dbDao.searchRHQByOffice(officeNameVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Payer Name 정보를 조회한다.
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @exception EventException
	 */
	public PayerNameVO searchPayerName(PayerNameParamVO payerNameParamVO) throws EventException {
		try {
			return dbDao.searchPayerName(payerNameParamVO);
		} catch(DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Atttention 정보를 조회한다.<br>
	 * 
	 * @param AttentionVO attentionVO
	 * @return List<AttentionVO>
	 * @exception EventException
	 */
	public List<AttentionVO> searchAttention(AttentionVO attentionVO) throws EventException {
		List<AttentionVO> attentionVOS = null;
		try {
			attentionVOS = dbDao.searchAttention(attentionVO);
			if (attentionVOS == null || attentionVOS.size() == 0) {
				attentionVOS = dbDao.searchAttentionOfCustomer(attentionVO);
			}
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return attentionVOS;
	}
	
	/**
	 * Service Provider Name 정보를 조회한다.<br>
	 * 
	 * @param VendorNameVO vendorNameVO
	 * @return VendorNameVO
	 * @exception EventException
	 */
	public VendorNameVO searchServiceProviderName(VendorNameVO vendorNameVO) throws EventException {
		try {
			return dbDao.searchServiceProviderName(vendorNameVO.getVndrCd());
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ARCurrency 리스트 정보를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String jspNo
	 * @return List<ARCurrencyVO>
	 * @exception EventException
	 */
	public List<ARCurrencyVO> searchARCurrencyList(String ofcCd, String jspNo) throws EventException {
		try {
			return dbDao.searchARCurrencyList(ofcCd,jspNo);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * OFC_CD별 현재일자를 조회한다.
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCurrentDateByOffice(String ofcCd) throws EventException {
		try {
			return dbDao.searchCurrentDateByOffice(ofcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  Office Code에 대한 AR Office 정보를 조회한다.<br>
	 * 
	 * @param String OfcCd
	 * @param String rhqOfc
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */	
	public List<OfficeNameVO> searchAROfficeList(String OfcCd, String rhqOfc) throws EventException {
		try {
			return dbDao.searchAROfficeList(OfcCd, rhqOfc);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 사용자에게 부여된 권한정보를 조회한다.
	 * 
	 * @param UserRoleVO userRoleVO
	 * @return UserRoleVO
	 * @exception EventException
	 */
	public UserRoleVO hasRoleAuth(UserRoleVO userRoleVO) throws EventException {
		UserRoleVO 	returnVO 		= new UserRoleVO();
		boolean 	isAuthorized 	= false;
		try {
			String 	pgmNo	= userRoleVO.getPgmNo();
			
			//사용자의 첫번째 Role Code 를 반환 한다.
			//ex) 사용자에게 DMT01,DMT02,DMT03 3개 Role Code가 등록되어 있을 경우, DMT01를 반환한다.
			returnVO.setUsrRoleCd(dbDao.hasRoleAuth(userRoleVO));
			log.debug("\n[hasRoleAuth] USER ROLE : " + returnVO.getUsrRoleCd());
			
			if ("EES_DMT_2009".equals(pgmNo) && "DMT03".equals(returnVO.getUsrRoleCd())) {
				//DAR 정보를 조회한 이후 DMT03 일 경우 다시 권한 확인을 하게 된다. (Charge 단위까지 확인 작업을 수행한다.) 
				//USER의 RHQ OFFICE와 REQUEST시 지정한 APPROVAL OFFICE 비교하여 같은 경우만 로직 수행
				String 	usrRhqOfcCd 	= 	userRoleVO.getEtc1(); // 사용자의 Current Office Code (COM_USER.OFC_CD) 에 해당하는 AR Header Office(MDM_ORGANIZATION.AR_HD_QTR_OFC_CD)
				String 	apvlOfcCd 		= 	userRoleVO.getEtc2(); // DAR 내 Approval Office Code
				String	loginOfcCd		=	userRoleVO.getEtc3(); // Change Office Code
				String	afterBKGOfcCd	=	null;
				String	prntOfcCd		=	null;
				
				log.debug("\n usrRhqOfcCd["+usrRhqOfcCd+ "] = apvlOfcCd["+ apvlOfcCd + "]");
				
				if (usrRhqOfcCd.equals(apvlOfcCd)) {
					// DAR Approval Office와 AR Header Office가 일치할 경우
					// Charge Container 정보가 등록되지 않은 경우 ()
					String 	darNo	= userRoleVO.getEtc4();	//AFT_EXPT_DAR_NO
					String 	bkgNo	= userRoleVO.getEtc5();	//BKG_NO
					String 	tariff	= userRoleVO.getEtc6();	//DMDT_TRF_CD 
					
					// 요청 받은 Booking, Tariff Code, (DAR No.) 건 수 만큼의 DMT Charge Office(DMT_CHG_CALC.OFC_CD) 를 조회한다.
					List<OfficeNameVO> officeList = dbDao.searchAfterBKGOfficeCd(darNo, bkgNo, tariff);
					if (officeList != null && officeList.size() > 0) {
						for (int i = 0 ; i < officeList.size() ; i++) {
							afterBKGOfcCd 	= officeList.get(i).getOfcCd();
							//  DMT Charge Office(afterBKGOfcCd) 의 DMT Charge Parent Office( MDM_ORGANIZATION.PRNT_OFC_CD -> DECODE(PRNT_OFC_CD, 'TPEBA', 'TPEBB', PRNT_OFC_CD))를 조회 한다.
							prntOfcCd 		= dbDao.searchPRNTOfficeCd(afterBKGOfcCd);
							
							log.debug("\n i = [" + i+ "] ->  loginOfcCd=(Change Office) [" + loginOfcCd +"] = ( afterBKGOfcCd["+ afterBKGOfcCd + "] or prntOfcCd ["+ prntOfcCd+ "] )");
							if (loginOfcCd.equals(afterBKGOfcCd) || loginOfcCd.equals(prntOfcCd)) {
								// 1. Log In(Change) Office 와 Charge Office 가 같을 경우 True. (loginOfcCd.equals(afterBKGOfcCd))
								//    -> 요청 및 승인을 같이 한다는 의미. 
								// 2. Log In(Change) Office 와 Charge Office 의 AR HD Office 가 같을 경우 True. (loginOfcCd.equals(prntOfcCd))
								//    -> User Office 가 Approval Office 라는 의미 이다.
								isAuthorized = true;
							}
							else {
								isAuthorized = false;
								break;
							}
						}
					}
				}
			}
			else {
				if (returnVO.getUsrRoleCd() != null && returnVO.getUsrRoleCd().length() > 0) {
					// DMT01,DMT02 있을 경우에 바로 승인 권한을 준다.
					isAuthorized = true;
				}
			}
			returnVO.setIsAuthorized(isAuthorized ? "Y" : "N");
			
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * SHEET SET 정보 존재여부를 조회한다.
	 * 
	 * @param SheetSetVO sheetSetVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean hasSheetSet(SheetSetVO sheetSetVO) throws EventException {
		try {
			return dbDao.hasSheetSet(sheetSetVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * office별 sheet Option 내용을 조회한다.<br>
	 * 
	 * @param SheetOptionByOfficeVO sheetOptionByOfficeVO
	 * @return SheetOptionByOfficeVO
	 * @throws EventException
	 */
	public SheetOptionByOfficeVO searchSheetOptionByOffice(SheetOptionByOfficeVO sheetOptionByOfficeVO) throws EventException{
		try {
			return dbDao.searchSheetOptionByOffice(sheetOptionByOfficeVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
    /**
     * commodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @exception EventException
     */ 
    public String searchCommodityName(String cmdtCd) throws EventException {
        try {
            return dbDao.searchCommodityName(cmdtCd);
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws EventException {
		try {
			return dbDao.searchUserCntCode(ofcCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * From Date, To Date 사이의 차이 일수를 조회 합니다. <br>
	 *
	 * @param DayVO dayVO
	 * @return String
	 * @throws EventException
	 */
	public String searchDaysBetween(DayVO dayVO) throws EventException {
		try {
			return dbDao.searchDaysBetween(dayVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * OFC_CD로 RHQ_OFC_CD를 조회 합니다.<br>
	 *
	 * @param RhqOfcCodeVO rhqOfcCodeVO
	 * @return String
	 * @throws EventException
	 */
	public String searchRhqOfcCdByOfcCd(RhqOfcCodeVO rhqOfcCodeVO) throws EventException {
		try {
			return dbDao.searchRhqOfcCdByOfcCd(rhqOfcCodeVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Yard Code의 유효성을 체크한다. 
	 * 
	 * @param String yd_cd
	 * @return String
	 * @exception EventException
	 */
	public String checkYardCd(String yd_cd) throws EventException {
		try {
			return dbDao.checkYardCd(yd_cd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 해당 Yard Code MDM 정보를 조회한다. 
	 * 
	 * @param String yd_cd
	 * @return String
	 * @exception EventException
	 */
	public String searchYardInfo(String yd_cd) throws EventException {
		
		try {
			return dbDao.searchYardInfo(yd_cd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * User ID 소속 Office Code를 조회<br>
	 *
	 * @param String usrId
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserOfcCd(String usrId) throws EventException {
		try {
			return dbDao.searchUserOfcCd(usrId);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	
	/**
	 * Office의 Local Time 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchOfcLocalTime(String ofcCd) throws EventException {
		try {
			return dbDao.searchOfcLocalTime(ofcCd); 
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Log-in User 정보를 조회<br>
	 *
	 * @param SignOnUserAccount account
	 * @return UserInfoVO
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public UserInfoVO searchUserInfo(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchUserInfo(account);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * DMT User Role 정보를 확인<br>
	 *
	 * @param UserRoleVO userRoleVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	
	public String searchUserRoleCode(UserRoleVO userRoleVO) throws EventException {
		try {
			return dbDao.searchUserRoleCode(userRoleVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
//	/**
//	 * TRADE 코드 조회<br>
//	 *
//	 * @return List<CommonCodeVO>
//	 * @throws EventException
//	 */	
//	public List<CommonCodeVO> searchTradeCode() throws EventException {
//		
//		try {
//			return dbDao.searchTradeCode();
//		} 
//		catch (DAOException ex) {
//			log.error(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		} 
//		catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler(ex).getMessage());
//		}		
//	}
	
	/**
	 * 사용자의 Log-in Office Level 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 */
	public String searchUserOfcLvl(String ofcCd) throws EventException {
		
		try {
			return dbDao.searchUserOfcLvl(ofcCd);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * RHQ 산하 DMT OFC 를 조회합니다.<br>
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	public List<OfficeNameVO> searchSubOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException {
		
		try {
			return dbDao.searchSubOfficeListByRHQ(officeNameVO);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 사용자 로그인 Office 산하 DMT Office 를 조회한다.<br>
	 * 
	 * @param String loginOfcCd
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */
	public List<OfficeNameVO> searchSubOfficeListByUserLoginOffice(String loginOfcCd) throws EventException {
		
		try {
			return dbDao.searchSubOfficeListByUserLoginOffice(loginOfcCd);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * OFC에 해당하는 SYS_AREA_GRP_ID(SVR_ID) 를 구한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchSysAreaGrpId(String ofcCd) throws EventException {
				
		try {
			return dbDao.searchSysAreaGrpId(ofcCd);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	

	/**
	 * Payer 정보가 DMT_PAYR_INFO 테이블에 존재하는지 확인한다.(Y/N) 
	 * 
	 * @param String svrId
	 * @param String payrCd
	 * @return String
	 * @exception EventException
	 */
	public String checkDmtPayerInfo(String svrId, String payrCd) throws EventException {
		try {
			return dbDao.checkDmtPayerInfo(svrId, payrCd);
		} 
		catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}
