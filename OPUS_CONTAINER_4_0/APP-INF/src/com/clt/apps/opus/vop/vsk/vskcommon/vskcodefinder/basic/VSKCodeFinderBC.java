/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DateTimeConvVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.EffectiveVvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * Vskcommon Business Logic Command Interface<br>
 * - business logic interface about Vskcommon<br>
 *
 * @author 
 * @see Ui_vsk-0202EventResponse
 * @since J2EE 1.4
 */

public interface VSKCodeFinderBC {
	/**
	 * Retrieving Service Lane
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchSvcLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Checking Service Lane Code 
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkSvcLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Checking applied LANE CODE, DIRECTION are exist
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return int
	 * @exception EventException
	 */
	public int checkSvcLaneDir(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException;
	
	/**
	 * Retrieving Port
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException;
	/**
	 * Retrieving Country
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryList(String cntCd) throws EventException;
	/**
	 * Retrieving RHQ
	 * 
	 * @return List<OfficeVO>
	 * @exception EventException
	 */
	public List<OfficeVO> searchRhqList() throws EventException;
	/**
	 * Retrieving Control Office Code of RHQ
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchControlOfficeList(String rhqCd) throws EventException;
	/**
	 * Retrieving Estimate VVD
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws EventException;
	/**
	 * Retrieving on time VVD
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchRsltVvdList(String vslCd) throws EventException;
	
	/**
	 * Retrieving Carrier
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierList(CarrierVO carrierVO) throws EventException; 
	
	/**
	 * Checking Carrier
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> checkCarrier(CarrierVO carrierVO) throws EventException;
	
	/**
	 * Retrieving Vessel
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVslList(VesselVO vesselVO) throws EventException;
	
	/**
	 * Retrieving Proforma Type
	 * 
	 * @param PfLaneTypeVO pfLaneTypeVO
	 * @return List<PfLaneTypeVO>
	 * @exception EventException
	 */
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws EventException;
	
	/**
	 * Retrieving Yard of Port
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByPort(YardVO yardVO) throws EventException;
	
	/**
	 * Retrieving Yard of Country
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByCountry(YardVO yardVO) throws EventException;
	
	/**
	 * Retrieving Location
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchLocation(LocationVO locationVO) throws EventException;
	
	
	/**
	 * Retrieving Location
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchLocationList(LocationVO locationVO) throws EventException;
	
	/**
	 * Retrieving Phase In/Out Reason
	 * 
	 * @return List<PhaseInOutReasonVO>
	 * @exception EventException
	 */
	public List<PhaseInOutReasonVO> searchPhsInOutRsnList() throws EventException;
	
	/**
	 * Checking VVD
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception EventException
	 */
	public List<VvdVO> checkVvd(VvdVO vvdVO) throws EventException;
	/**
	 * Retrieving Port Code is exist
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String locCd) throws EventException;
	
	/**
	 * Retrieving Simulation No
	 * 
	 * @param RqstSimNoVO rqstSimNoVO
	 * @return List<RqstSimNoVO>
	 * @exception EventException
	 */
	public List<RqstSimNoVO> searchSimNoList(RqstSimNoVO rqstSimNoVO) throws EventException;

	/**
	 * Retrieving Code Information List by Code Type or Code Name
	 * 
	 * @param  CodeInfoVO codeInfoVO
	 * @return List<CodeInfoVO>
	 * @exception EventException
	 */
	public List<CodeInfoVO> searchCodeInfoList(CodeInfoVO codeInfoVO) throws EventException;
	
	/**
	 * Retrieving Service Lane Direction
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return List<MdmVslSvcLaneDirVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneDirVO> searchSvcLaneDirList(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException;
	
	/**
	 * Retrieving information about inputed Service Provider
	 * 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchVendorList(VendorVO vendorVO) throws EventException;
	
	/**
	 * Retrieving Yard Code, Description in case Yard Code input
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardList(YardVO YardVO) throws EventException;

	/**
	 * Retrieving Common Code of VOSI
	 * 
	 * @param  String comCode
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchCombo(String comCode) throws EventException;
		
	/**
	 * Retrieving MDM Lane
     * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Checking MDM Lane
     * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Retrieving Delay Reason
	 * 
	 * @return List<DelayReasonVO>
	 * @exception EventException
	 */
	public List<DelayReasonVO> searchDlayRsnList() throws EventException;
	
	/**
	 * Retrieving Vsl Class
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVslClsList() throws EventException;
	
	/**
	 * Retrieving Vsl Class and VSL_DZND_CAPA
	 * 
	 * @return CodeInfoGRPVO
	 * @exception EventException
	 */
	public CodeInfoGRPVO searchVslClsDznCapaList() throws EventException;
	
	/**
	 * VVD媛 吏?섎뒗 Port 由ъ뒪?몃? 議고쉶?⑸땲??
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPort(VvdVO vvdVO) throws EventException;
	
	/**
	 * ACTUAL SKD ?낅젰??GMT 湲곗??쇰줈 ?댁쟾?ы듃??ETD? ?낅젰?ы듃 ATA??쟾愿怨?泥댄겕 <br>
	 * 
	 * @param DateTimeConvVO dateTimeConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchActPreDateEqual(DateTimeConvVO  dateTimeConvVO) throws EventException;
	
	/**
	 * VVD媛 吏?섎뒗 Port 由ъ뒪?몃? 議고쉶?⑸땲??
	 * 
	 * @param VesselVO vslVo
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVslCd(VesselVO vslVo) throws EventException;

	/**
	 * Send RevenueVVD I/F 
	 * 
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void  sendRevenueVVD(List<VvdVO> vvdVOs) throws EventException;

	/**
	 * Send RevenueVVD I/F 
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchPortList(Map<String, String> mapVO) throws EventException;
	
	/**
	 * Select proper VVD in candidate
	 * 
	 * @param EffectiveVvdVO effectiveVvdVO
	 * @param String sPurposeCode
	 * @return EffectiveVvdVO
	 * @exception EventException
	 */
	public EffectiveVvdVO searchProperVVDinCandidate(EffectiveVvdVO effectiveVvdVO, String sPurposeCode) throws EventException;
}