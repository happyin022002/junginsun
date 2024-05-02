/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : partnerBCImpl.java
*@FileTitle : carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.report.basic;
 
import java.util.List;

import com.hanjin.apps.alps.bcm.ccd.commoncode.report.integration.ReportDBDAO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.ChargeReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.LocationReportConditionVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.LocationReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.OfficeReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.VesselReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.YardReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.ZoneReportVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.report.vo.SearchOfficHierarchyVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-commoncode Business Logic Command Interface<br>
 * - OPUS-commoncode에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */
public class ReportBCImpl extends BasicCommandSupport implements ReportBC {

	// Database Access Object
	private transient ReportDBDAO dbDao = null;

	/**
	 * ReportBCImpl 객체 생성<br>
	 * ReportDBDAO를 생성한다.<br>
	 */
	public ReportBCImpl() {
		dbDao = new ReportDBDAO();
	}
	
	/**
	 * Zone code report을 Count 조회 합니다.<br>
	 * 
	 * @param String znCd
	 * @param String znNm
	 * @param String locCd
	 * @param String repYdCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String  searchZoneReportCount(String znCd,String znNm,String locCd,String repYdCd,String status)  throws EventException {
		try {
			return dbDao.searchZoneReportCount(znCd,znNm,locCd,repYdCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Zone code report 상세 정보 조회합니다.<br>
	 * 
	 * @param String znCd
	 * @param String znNm
	 * @param String locCd
	 * @param String repYdCd
	 * @param String status
	 * @return List<ZoneReportVO>
	 * @exception EventException
	 */
	public List<ZoneReportVO> searchZoneReportCode(String znCd,String znNm,String locCd,String repYdCd,String status) throws EventException {
		try {
			return dbDao.searchZoneReportCode(znCd,znNm,locCd,repYdCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Yard code report 상세 정보 조회합니다.<br>
	 * 
	 * @param String ydCd
	 * @param String ydNm
	 * @param String locCd
	 * @param String ofcCd
	 * @param String dmdtOfcCd
	 * @param String status
	 * @return List<YardReportVO>
	 * @exception EventException
	 */
	public List<YardReportVO> searchYardReportCode(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws EventException {
		try {
			return dbDao.searchYardReportCode(ydCd,ydNm,locCd,ofcCd,dmdtOfcCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Yard code report 상세 정보 조회합니다.<br>
	 * 
	 * @param String ydCd
	 * @param String ydNm
	 * @param String locCd
	 * @param String ofcCd
	 * @param String dmdtOfcCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String searchYardReportCount(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws EventException {
		try {
			return dbDao.searchYardReportCount(ydCd,ydNm,locCd,ofcCd,dmdtOfcCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Location Report을 Count 조회 합니다.<br>
	 * 
	 * @param LocationReportConditionVO locationReportConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationReportCount(LocationReportConditionVO locationReportConditionVO) throws EventException {
		try {
			return dbDao.searchLocationReportCount(locationReportConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Location Report을 조회 합니다.<br>
	 * 
	 * @param LocationReportConditionVO locationReportConditionVO
	 * @return List<LocationReportVO>
	 * @exception EventException
	 */
	public List<LocationReportVO> searchLocationReportList(LocationReportConditionVO locationReportConditionVO) throws EventException {
		try {
			return dbDao.searchLocationReportList(locationReportConditionVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Customer Report을 Count 조회 합니다.<br>
	 * 
	 * @param CustomerReportVO customerReportVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerReportCnt(CustomerReportVO customerReportVO) throws EventException {
		try {
			return dbDao.searchCustomerReportCnt(customerReportVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Customer Report을 조회 합니다.<br>
	 * 
	 * @param CustomerReportVO customerReportVO
	 * @return List<CustomerReportVO>
	 * @exception EventException
	 */
	public List<CustomerReportVO> searchCustomerReportList(CustomerReportVO customerReportVO) throws EventException {
		try {
			return dbDao.searchCustomerReportList(customerReportVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Vendor Report을 Count 조회 합니다.<br>
	 * 
	 * @param VendorReportVO vendorReportVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorReportCnt(VendorReportVO vendorReportVO) throws EventException {
		try {
			return dbDao.searchVendorReportCnt(vendorReportVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Vendor Report을 조회 합니다.<br>
	 * 
	 * @param VendorReportVO vendorReportVO
	 * @return List<LocationReportVO>
	 * @exception EventException
	 */
	public List<VendorReportVO> searchVendorReportList(VendorReportVO vendorReportVO) throws EventException {
		try {
			return dbDao.searchVendorReportList(vendorReportVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Office report을 Count 조회 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String ofcEngNm
	 * @param String locCd
	 * @param String ofcKndCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeReportCount(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status)  throws EventException {
		try {
			return dbDao.searchOfficeReportCount(ofcCd, ofcEngNm, locCd, ofcKndCd, status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Office report 정보를 조회합니다.<br>
	 * 
	 * @param String ofcCd
	 * @param String ofcEngNm
	 * @param String locCd
	 * @param String ofcKndCd
	 * @param String status
	 * @return List<ZoneReportVO>
	 * @exception EventException
	 */
	public List<OfficeReportVO> searchOfficeReportList(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status)  throws EventException {
		try {
			return dbDao.searchOfficeReportList(ofcCd, ofcEngNm, locCd, ofcKndCd, status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Office Hieracy을 조회 합니다.<br>
	 * 
	 * @param SearchOfficHierarchyVO searchOfficHierarchyVO
	 * @return List<SearchOfficHierarchyVO>
	 * @exception EventException
	 */
	public List<SearchOfficHierarchyVO> searchOfficeHierarchyList(SearchOfficHierarchyVO searchOfficHierarchyVO) throws EventException {
		try {
			return dbDao.searchOfficeHierarchyList(searchOfficHierarchyVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Vessel Report 정보를 조회합니다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslEngNm
	 * @param String crrCd
	 * @param String fdrDivCd
	 * @param String status
	 * @return List<VesselReportVO>
	 * @exception EventException
	 */
	public List<VesselReportVO>searchVesselReportList(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws EventException {
		try {
			return dbDao.searchVesselReportList(vslCd, vslEngNm, crrCd, fdrDivCd, status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Vessel 정보 Count 조회합니다.<br> 
	 * 
	 * @param String vslCd
	 * @param String vslEngNm
	 * @param String crrCd
	 * @param String fdrDivCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselReportCount(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws EventException {
		try {
			return dbDao.searchVesselReportCount(vslCd,vslEngNm,crrCd,fdrDivCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * Charge정보를 조회합니다.<br>
	 * @param String chgCd
	 * @param String chgNm
	 * @param String repChgCd
	 * @param String status
	 * @return List<ChargeReportVO>
	 * @exception EventException
	 */
	public List<ChargeReportVO>searchChargeReportList(String chgCd, String chgNm, String repChgCd, String status) throws EventException {
		try {
			return dbDao.searchChargeReportList(chgCd,chgNm,repChgCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Charge 정보 Count 조회합니다.<br> 
	 * 
	 * @param String chgCd
	 * @param String chgNm
	 * @param String repChgCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String searchChargeReportCount(String chgCd, String chgNm, String repChgCd, String status) throws EventException {
		try {
			return dbDao.searchChargeReportCount(chgCd,chgNm,repChgCd,status);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	
}