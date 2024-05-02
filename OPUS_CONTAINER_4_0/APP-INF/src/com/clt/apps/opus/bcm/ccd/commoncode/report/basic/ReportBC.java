/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : seviceBC.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.basic;

import java.util.List;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.ChargeReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.LocationReportConditionVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.LocationReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.OfficeReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.SearchOfficHierarchyVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VendorReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.VesselReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.YardReportVO;
import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.ZoneReportVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Commoncode Business Logic Command Interface<br>
 * - OPUS-Commoncode에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface ReportBC {
	
	/**
	 * Zone code report  Count 조회합니다.<br> 
	 * 
	 * @param String znCd
	 * @param String znNm
	 * @param String locCd
	 * @param String repYdCd
	 * @param String status
	 * @return String
	 * @exception EventException
	 */
	public String searchZoneReportCount(String znCd,String znNm,String locCd,String repYdCd,String status) throws EventException;
	

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
	public List<ZoneReportVO> searchZoneReportCode(String znCd,String znNm,String locCd,String repYdCd,String status) throws EventException;
	

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
	public List<YardReportVO> searchYardReportCode(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws EventException;

	/**
	 * Yard code report Count 정보 조회합니다.<br>
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
	public String searchYardReportCount(String ydCd,String ydNm,String locCd,String ofcCd,String dmdtOfcCd,String status) throws EventException;
	
	/**
	 * Location Report을 Count 조회 합니다.<br>
	 * 
	 * @param LocationReportConditionVO	locationReportConditionVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocationReportCount(LocationReportConditionVO locationReportConditionVO) throws EventException;
	
	/**
	 * Location Report을 조회 합니다.<br>
	 * 
	 * @param LocationReportConditionVO	locationReportConditionVO
	 * @return List<LocationReportVO>
	 * @exception EventException
	 */
	public List<LocationReportVO> searchLocationReportList(LocationReportConditionVO locationReportConditionVO) throws EventException;

	/**
	 * Customer Report을 Count 조회 합니다.<br>
	 * 
	 * @param CustomerReportVO customerReportVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCustomerReportCnt(CustomerReportVO customerReportVO) throws EventException;
	
	/**
	 * Customer Report을 조회 합니다.<br>
	 * 
	 * @param CustomerReportVO customerReportVO
	 * @return List<CustomerReportVO>
	 * @exception EventException
	 */
	public List<CustomerReportVO> searchCustomerReportList(CustomerReportVO customerReportVO) throws EventException;

	/**
	 * Vendor Report을 Count 조회 합니다.<br>
	 * 
	 * @param VendorReportVO vendorReportVO
	 * @return String
	 * @exception EventException
	 */
	public String searchVendorReportCnt(VendorReportVO vendorReportVO) throws EventException;
	
	/**
	 * Vendor Report을 조회 합니다.<br>
	 * 
	 * @param VendorReportVO vendorReportVO
	 * @return List<VendorReportVO>
	 * @exception EventException
	 */
	public List<VendorReportVO> searchVendorReportList(VendorReportVO vendorReportVO) throws EventException;
	
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
	public String searchOfficeReportCount(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status)  throws EventException;
	
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
	public List<OfficeReportVO> searchOfficeReportList(String ofcCd, String ofcEngNm, String locCd, String ofcKndCd, String status) throws EventException;

	/**
	 * Office Hieracy 정보를 조회합니다.<br>
	 * 
	 * @param SearchOfficHierarchyVO searchOfficHierarchyVO
	 * @return List<SearchOfficHierarchyVO>
	 * @exception EventException
	 */
	public List<SearchOfficHierarchyVO> searchOfficeHierarchyList(SearchOfficHierarchyVO searchOfficHierarchyVO) throws EventException;
	
	/**
	 * Vessel 정보를 조회합니다.<br>
	 * @param String vslCd
	 * @param String vslEngNm
	 * @param String crrCd
	 * @param String fdrDivCd
	 * @param String status
	 * @return List<VesselReportVO>
	 * @exception EventException
	 */
	public List<VesselReportVO>searchVesselReportList(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws EventException;	
	
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
	public String searchVesselReportCount(String vslCd, String vslEngNm, String crrCd, String fdrDivCd, String status) throws EventException;
	
	/**
	 * Charge정보를 조회합니다.<br>
	 * @param String chgCd
	 * @param String chgNm
	 * @param String repChgCd
	 * @param String status
	 * @return List<ChargeReportVO>
	 * @exception EventException
	 */
	public List<ChargeReportVO>searchChargeReportList(String chgCd, String chgNm, String repChgCd, String status) throws EventException;	
	
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
	public String searchChargeReportCount(String chgCd, String chgNm, String repChgCd, String status) throws EventException;
	

	
}