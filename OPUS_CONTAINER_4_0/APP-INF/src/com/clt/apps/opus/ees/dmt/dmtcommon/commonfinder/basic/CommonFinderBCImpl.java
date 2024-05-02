/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CommonFinderBCImpl.java
*@FileTitle : CommonFinder
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.integration.CommonFinderDBDAO;
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
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-DMTCommon Business Logic Basic Command implementation<br>
 * @author
 * @see reference DAO of DMTCommonFinderEventResponse,DMTCommonFinderBC 
 * @since J2EE 1.4
 */

public class CommonFinderBCImpl extends BasicCommandSupport implements CommonFinderBC {

	// Database Access Object
	private transient CommonFinderDBDAO dbDao = null;
	
	/**
	 * DMTCommonFinderBCImpl create object<br>
	 * create DMTCommonFinderDBDAO <br>
	 */
	public CommonFinderBCImpl() {
		dbDao = new CommonFinderDBDAO();
	}
	
	/**
	 * search Region info.
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
	 * search Country info .
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
	 * search Country info. about Region Head Quarter.
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
	 * search Country info. about Continent
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
	 * search Region info  about Country
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
	 * search State info. about Country.
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
	 * search higher level RHQ, Country, Region or State  include Location code.
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
	 * search higher level RHQ, Country, Region or State, Location  include Location code.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByYard(CoverageVO coverageVO) throws EventException {
		List<CoverageVO> list = null;
		try {
			if ("DUAL".equals(coverageVO.getTp())) {
				list = dbDao.searchDualRHQHierarchyByLocation(coverageVO.getYdCd());
			} 
			else {
				list = dbDao.searchRHQHierarchyByYard(coverageVO.getYdCd());
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
	 * search higher level Continent, Country, Region or State include Location code
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
	 *  search  Tariff Type List.
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
	 *search Tariff Type List info and user defined Tariff Type info
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
	 * search user defined Tariff Type info
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
	 * search  DemDet Office.
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
	 * search  DemDet Office by RHQ Office Code.
	 * 
	 * @param String rhqOfcCd
	 * @return List<OfficeNameVO>
	 * @exception EventException
	 */	
	public List<OfficeNameVO> searchOfficeListByRhq(String rhqOfcCd) throws EventException {
		try {
			return dbDao.searchOfficeListByRhq(rhqOfcCd);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * search  DemDet sub Office .
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
	 * check validation of Booking No.
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
	 * check validation of Location Code. 
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
     *  check validation of  Location Code. 
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
	 *  check validation of Country Code.
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
	 * search  Continent, Country, Region or State of  Yard.
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
	 * search Currency List.
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
	 * search RHQ Office List.
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
	
	/** searchAreaByOffice
	 * 
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchAreaByOffice() throws EventException {
		try {
			return dbDao.searchAreaByOffice();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** searchOfficByCountry
	 * 
	 * @param CoverageVO coverageVO
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficByCountry(CoverageVO coverageVO) throws EventException {
		try {
			return dbDao.searchOfficByCountry(coverageVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * search  Continent, Country, State of  Region.
	 * 
	 * @param CoverageVO coverageVO
	 * @return List<CoverageVO>
	 * @exception EventException
	 */	
	public List<CoverageVO> searchRHQHierarchyByRegion(CoverageVO coverageVO) throws EventException {
		
		List<CoverageVO> 	coverageVOs 	= null;
		
		try {
			//check this filed is  Region or State 
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
	 * search Continet code.<br>
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
	 * search DEM/DET Container / Cargo info.
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
	 * search Continent of Country
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
	 * search Continent, Country of Region.
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
	 * search Continent, Country of State.
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
	 * search Yard of Location.
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
	 * search code of Common Code ID.
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
	
	/**
	 * search higher level RHQ of Country.
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
	 * search  Region, State('CA','US') .
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
	 *  search Customer Name .
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
	 * search DEM/DET Office of  RHQ Office Code.
	 * 
	 * @param OfficeNameVO officeNameVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchDemDetOfficeListByRHQ(OfficeNameVO officeNameVO) throws EventException {
		OfficeNameVO inOfficeNameVO = officeNameVO; 
		String svr_id = "";
		try {
			svr_id = dbDao.searchUserSysAreaGrpId(officeNameVO.getOfcCd());
			inOfficeNameVO.setOfcCd(svr_id);
			
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
	 * search  RHQ Office Name of office.
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
	 * search Payer Name.
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
	 * search Attention.<br>
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
	 * search Service Provider Name.<br>
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
	 * search ARCurrency list.
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
	 * search current date of OFC_CD.
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
	 * checkTPBCustomerByVendor <br>
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @exception EventException
	 */
	public PayerNameVO checkTPBCustomerByVendor(PayerNameParamVO payerNameParamVO) throws EventException {
		try {
			return dbDao.checkTPBCustomerByVendor(payerNameParamVO);
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  search AR Office of Office Code<br>
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
	 * search authority of user .
	 * 
	 * @param UserRoleVO userRoleVO
	 * @return UserRoleVO
	 * @exception EventException
	 */
	public UserRoleVO hasRoleAuth(UserRoleVO userRoleVO) throws EventException {
		UserRoleVO 	returnVO 		= new UserRoleVO();
		boolean 	isAuthorized 	= false;
		try {
//			String 	pgmNo	= userRoleVO.getPgmNo();
			
			//check authority.
			returnVO.setUsrRoleCd(dbDao.hasRoleAuth(userRoleVO));
			
//			if ("EES_DMT_2009".equals(pgmNo) && "DMT03".equals(returnVO.getUsrRoleCd())) {
//				// Compare RHQ OFFICE of USER and REQUESTed APPROVAL OFFICE , case in equal, run 
//				String 	usrRhqOfcCd 	= 	userRoleVO.getEtc1();
//				String 	apvlOfcCd 		= 	userRoleVO.getEtc2();
//				String	loginOfcCd		=	userRoleVO.getEtc3();
//				String	afterBKGOfcCd	=	null;
//				String	prntOfcCd		=	null;
//				
//				if (usrRhqOfcCd.equals(apvlOfcCd)) {
//					String 	darNo	= userRoleVO.getEtc4();	//AFT_EXPT_DAR_NO
//					String 	bkgNo	= userRoleVO.getEtc5();	//BKG_NO
//					String 	tariff	= userRoleVO.getEtc6();	//DMDT_TRF_CD 
//					
//					//search Office Cd of requested Booking datas
//					List<OfficeNameVO> officeList = dbDao.searchAfterBKGOfficeCd(darNo, bkgNo, tariff);
//					if (officeList != null && officeList.size() > 0) {
//						for (int i = 0 ; i < officeList.size() ; i++) {
//							afterBKGOfcCd 	= officeList.get(i).getOfcCd();
//							prntOfcCd 		= dbDao.searchPRNTOfficeCd(afterBKGOfcCd);
//							
//							if (loginOfcCd.equals(afterBKGOfcCd) || loginOfcCd.equals(prntOfcCd)) {
//								isAuthorized = true;
//							}
//							else {
//								isAuthorized = false;
//								break;
//							}
//						}
//					}
//				}
//			}
//			else {
				if (returnVO.getUsrRoleCd() != null && returnVO.getUsrRoleCd().length() > 0) {
					isAuthorized = true;
				}
//			}
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
	 * search SHEET SET.
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
	 * search  sheet Option  by office.<br>
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
     * search commodity .
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
	 * search Country of Office<br>
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
	 * search Duration of From Date and To Date. <br>
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
	 * search RHQ_OFC_CD of OFC_CD <br>
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
	 * search SYS_AREA_GRP_ID of OFC_CD <br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
    public String searchUserSysAreaGrpId(String ofcCd) throws EventException {
		try {
			return dbDao.searchUserSysAreaGrpId(ofcCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
	 * creating yard list used in combo
	 *
	 * @param CoverageVO coverageVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchYardSubCodeForCombo(CoverageVO coverageVO) throws EventException {
//		try {
//			String returnValue =  dbDao.searchYardSubCodeForCombo(coverageVO);
//			if (returnValue == null || returnValue.trim().equals("")) {
//				throw new EventException(new ErrorHandler("COM130402", new String[]{"yard code"}).getMessage());
//			}
//			return returnValue;
//		} catch (EventException ex) {
//			log.error(ex.getMessage(),ex);
//			throw ex;
//		} catch (DAOException ex) {
//			log.error(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("DMT01125", new String[]{""}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new EventException(new ErrorHandler("DMT01125", new String[]{""}).getMessage(), ex);
//		}
		return "";
	}

	/**
	 * search Rep Cust Seq of Office<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchRepCustSeq(String ofcCd) throws EventException {
		try {
			return dbDao.searchRepCustSeq(ofcCd);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}