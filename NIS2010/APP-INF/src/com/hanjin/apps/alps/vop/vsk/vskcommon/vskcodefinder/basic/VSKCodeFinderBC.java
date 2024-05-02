/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSKCodeFinderBC.java
*@FileTitle : LaneCodeHelp
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2009.04.29 서창열
* 1.0 Creation
* 
* History
* 2011.03.25 진마리아 CHM-201109579-01 Lane Code의 Direction 조회 칼럼 추가 요청
* 2011.10.04 김민아 [CHM-201112983-01] Actual SKD Creation 및 Inquiry 화면 및 로직 변경. 조회 조건 Port및 Terminal, Calling Seq, 입력칼럼을 Select Box로 변경 / ATA,ATB,ATD 별 Remark 칼럼 추가 / Delay Time을 Hrs로 로직 변경
* 2011.10.11 진마리아 CHM-201112822-01 Lane Code inquiry내 trade 및 Sub trade, SKD 로 lane Code 정보를 조회 가능하도록 로직 수정
* 2011.10.11 진마리아 CHM-201112898-01 Port Code Inquiry 조회 조건 추가 - Conti, Sconti, lat, long, period 등
* 2012.04.12 진마리아 CHM-201217105-01 MDM Vessel Delete 여부를 조회조건 및 결과에 추가 및 paging처리
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesselschedulemasterdata.vesselschedulemasterdata.vo.CarrierVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.CodeInfoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.DelayReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LaneDirVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.LocationVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.OfficeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PhaseInOutReasonVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.RqstSimNoVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.SearchDateVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VendorVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VesselVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VskComboVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VslSvcLaneforBudgetVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneDirVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * NIS2010-Vskcommon Business Logic Command Interface<br>
 * - NIS2010-Vskcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SEO CHANG YUL
 * @see Ui_vsk-0202EventResponse 참조
 * @since J2EE 1.4
 */

public interface VSKCodeFinderBC {
	/**
	 * Service Lane 리스트를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchSvcLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;

	/**
	 * Service Lane (for BUDGET)리스트를 조회합니다.
	 * 
	 * @param VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO
	 * @return List<VslSvcLaneforBudgetVO>
	 * @exception EventException
	 */
	public List<VslSvcLaneforBudgetVO> searchSvcLaneforBudgetList(VslSvcLaneforBudgetVO vslSvcLaneforBudgetVO) throws EventException;
	
	/**
	 * Service Lane Code를 검증합니다. 
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkSvcLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * 등록된 LANE CODE, DIRECTION이 있는지 확인합니다.
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return int
	 * @exception EventException
	 */
	public int checkSvcLaneDir(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException;
	
	/**
	 * Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchPortList(LocationVO locationVO) throws EventException;
	/**
	 * Country 정보를 조회합니다.
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryList(String cntCd) throws EventException;
	/**
	 * 지역본부(RHQ) 정보를 조회합니다.
	 * 
	 * @return List<OfficeVO>
	 * @exception EventException
	 */
	public List<OfficeVO> searchRhqList() throws EventException;
	/**
	 * RHQ산하에 있는 Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchControlOfficeList(String rhqCd) throws EventException;
	
	/**
	 * RHQ산하에 있는 Sls Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchSlsOfficeList(String rhqCd) throws EventException;
	
	/**
	 * Estimate VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchEstVvdList(String vslCd) throws EventException;
	/**
	 * 정시성 VVD 정보를 조회합니다.
	 * 
	 * @param String vslCd
	 * @return List<VvdPortLaneOtherVO>
	 * @exception EventException
	 */
	public List<VvdPortLaneOtherVO> searchRsltVvdList(String vslCd) throws EventException;
	
	/**
	 * Carrier 정보를 조회합니다.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> searchCarrierList(CarrierVO carrierVO) throws EventException; 
	
	/**
	 * Carrier 정보를 검증합니다.
	 * 
	 * @param CarrierVO carrierVO
	 * @return List<CarrierVO>
	 * @exception EventException
	 */
	public List<CarrierVO> checkCarrier(CarrierVO carrierVO) throws EventException;
	
	/**
	 * Vessel 리스트 정보를 조회합니다.
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVslList(VesselVO vesselVO) throws EventException;
	
	/**
	 * Proforma Type 정보를 조회합니다.
	 * 
	 * @param PfLaneTypeVO pfLaneTypeVO
	 * @return List<PfLaneTypeVO>
	 * @exception EventException
	 */
	public List<PfLaneTypeVO> searchPfLaneTypeList(PfLaneTypeVO pfLaneTypeVO) throws EventException;
	
	/**
	 * Port에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByPort(YardVO yardVO) throws EventException;
	
	/**
	 * 국가에 대한 Yard 정보를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardListByCountry(YardVO yardVO) throws EventException;
	
	/**
	 * Location 정보를 조회합니다.
	 * 
	 * @param locationVO LocationVO
	 * @return List<LocationVO>
	 * @throws EventException
	 */
	public List<LocationVO> searchLocationList(LocationVO locationVO) throws EventException;
	
	/**
	 * Phase In/Out 사유 정보를 조회합니다.
	 * 
	 * @return List<PhaseInOutReasonVO>
	 * @exception EventException
	 */
	public List<PhaseInOutReasonVO> searchPhsInOutRsnList() throws EventException;
	
	/**
	 * VVD를 검증합니다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VvdVO>
	 * @exception EventException
	 */
	public List<VvdVO> checkVvd(VvdVO vvdVO) throws EventException;
	/**
	 * Port Code 가 존재하는지 여부를 조회합니다.
	 * 
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 */
	public String checkPort(String locCd) throws EventException;
	
	/**
	 * Simulation No 정보를 조회합니다.
	 * 
	 * @param RqstSimNoVO rqstSimNoVO
	 * @return List<RqstSimNoVO>
	 * @exception EventException
	 */
	public List<RqstSimNoVO> searchSimNoList(RqstSimNoVO rqstSimNoVO) throws EventException;

	/**
	 * 코드 타입, 코드명에 따른 코드 정보 리스트를 조회합니다.
	 * 
	 * @param  CodeInfoVO codeInfoVO
	 * @return List<CodeInfoVO>
	 * @exception EventException
	 */
	public List<CodeInfoVO> searchCodeInfoList(CodeInfoVO codeInfoVO) throws EventException;
	
	/**
	 * Service Lane Direction 정보를 조회합니다.
	 * 
	 * @param MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO
	 * @return List<MdmVslSvcLaneDirVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneDirVO> searchSvcLaneDirList(MdmVslSvcLaneDirVO mdmVslSvcLaneDirVO) throws EventException;
	
	/**
	 * 입력한 Service Provider에 대한 정보를 조회합니다.
	 * 
	 * @param VendorVO vendorVO
	 * @return List<VendorVO>
	 * @exception EventException
	 */
	public List<VendorVO> searchVendorList(VendorVO vendorVO) throws EventException;
	
	/**
	 * Yard Code가 입력되였을 경우로써 Yard Code, Description를 조회합니다.
	 * 
	 * @param YardVO yardVO
	 * @return List<YardVO>
	 * @exception EventException
	 */
	public List<YardVO> searchYardList(YardVO YardVO) throws EventException;

	/**
	 * VOSI의 공통코드를 검색한다.
	 * 
	 * @param  String comCode
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchCombo(String comCode) throws EventException;
		
	/**
	 * MDM Lane 정보를 조회합니다.
     * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * MDM Lane 정보를 검증합니다.
     * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLane(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws EventException;
	
	/**
	 * Delay Reason 을 조회합니다.
	 * 
	 * @return List<DelayReasonVO>
	 * @exception EventException
	 */
	public List<DelayReasonVO> searchDlayRsnList() throws EventException;
	
	/**
	 * Vsl Class를 조회한다.
	 * 
	 * @return List<MdmVslCntrVO>
	 * @exception EventException
	 */
	public List<MdmVslCntrVO> searchVslClsList() throws EventException;
	
	/**
	 * Vsl Class와 VSL_DZND_CAPA를 조회한다.
	 * 
	 * @return CodeInfoGRPVO
	 * @exception EventException
	 */
	public CodeInfoGRPVO searchVslClsDznCapaList() throws EventException;
	
	/**
	 * Service Lane Direction 리스트를 조회합니다.
	 * 
	 * @param LaneDirVO laneDirVO
	 * @return List<LaneDirVO>
	 * @exception EventException
	 */
	public List<LaneDirVO> searchLaneDirList(LaneDirVO laneDirVO) throws EventException;
	
	/**
	 * VVD가 지나는 Port 리스트를 조회합니다.
	 * 
	 * @param VvdVO vvdVO
	 * @return List<VskComboVO>
	 * @exception EventException
	 */
	public List<VskComboVO> searchPort(VvdVO vvdVO) throws EventException;
	
	/**
	 * Lane Code Inquiry 화면의 기본정보인 Trade, Sub Trade, Service Type 정보를 조회한다.
	 * 
	 * @return List<String[]>
	 * @exception EventException
	 */
	public List<String[]> searchLaneBasic() throws EventException;
	
	/**
	 * Port Code Inquiry 화면의 기본정보인 Conti Cd, Sconti Cd 정보를 조회한다.
	 * 
	 * @return List<String[]>
	 * @exception EventException
	 */
	public List<String[]> searchPortBasic() throws EventException;
	
	/**
	 * Port Code Inquiry 에서의 Port 정보를 조회합니다.
	 * 
	 * @param LocationVO locationVO
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchPortInfoList(LocationVO locationVO) throws EventException;
	
	/**
	 * Conti Cd에 해당하는 Sconti Cd 정보를 조회한다.
	 * 
	 * @param String contiCd
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchScontiList(String contiCd) throws EventException;
	
	/**
	 * Vessel 리스트 정보를 조회합니다.(0044 vessel code inquiry)
	 * 
	 * @param VesselVO vesselVO
	 * @return List<VesselVO>
	 * @exception EventException
	 */
	public List<VesselVO> searchVesselListByCode(VesselVO vesselVO) throws EventException;

	/**
	 * 날짜 정보를 조회합니다.
	 * 
	 * @param SearchDateVO dateVO
	 * @return List<SearchDateVO>
	 * @exception EventException
	 */
	public List<SearchDateVO> searchDate(SearchDateVO dateVO) throws EventException;

	/**
	 * RHQ산하에 있는 Yard Control Office Code 정보를 조회합니다.
	 * 
	 * @param String rhqCd
	 * @return List<LocationVO>
	 * @exception EventException
	 */
	public List<LocationVO> searchYardCtrlOfficeList(String rhqCd) throws EventException;
	
	/**
	 * 특정 Location Local Time을 변경대상 Location Local time으로 변환된 값을 추출한다.
	 * 
	 * @param String sFmLocCd
	 * @param String sToLocCd
	 * @param String sDateFormat
	 * @return String
	 * @exception EventException
	 */
	public String getTimeConvFmLocToLoc(String sFmLocCd, String sToLocCd, String sDateFormat) throws EventException;
	
	/**
	 * 특정 Vessel Service Lane의 Proforma 데이터중 direction+port 조합으로 데이터 추출한다.
	 * 
	 * @param String sVslSlanCd
	 * @return List<VskVslPortSkdVO>
	 * @exception EventException
	 */
	public List<VskVslPortSkdVO> searchSkdDirPortCdforProformaList(String sVslSlanCd) throws EventException;	
	
}