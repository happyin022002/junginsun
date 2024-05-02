/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationUtil.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 최성환
*@LastVersion : 1.0 
* 2009.05.25 최성환
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.09.10 유병희 [] [EES-DMT] CSR 요청에 의해 SvrId 설정 변경으로 조회용 method추가
* 2010.09.14 유병희 [CHM-201006006] [EES-DMT] Charge Calculation시 CNTR-Cargo조합의 적용Rate 선택 변경
* 2010.11.12 김태균 [CHM-201006793-01] 소스 결함 관련 수정
* 2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2010.12.07 김태균 [CHM-201007392-01] [EES-DMT] [DMDT] S/C Exception Logic 보완
* 2011.03.31 김태균 [CHM-201109458-01] [DMT] T/S BKG의 T/S 미실행(육상운송) CNTR의 Port DEM 생성 Logice 보완
* 2011.07.01 김경섭 [CHM-201111828]R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 
* 2012.02.10 권  민 [CHM-201216013] [DMT] A4-B/B 조합의 Charge 생성 불가에 대한 보완
* 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
* 2012.04.13 김현화 [CHM-201217180-01]Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산시 제외 로직 제거.
* 2012.04.23 김현화 []Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산로직 다시 복구.(HJS 장병용부장님요청)
* 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청 :  DMDT_CHG_LOC_DIV_CD = 'TSP'이면  fixedpod, fixedpol를 호출, 그외는 호출하지 않음.
* 2012.06.26 김현화 [CHM-201217874]미국 CA DET 계산 Logic 변경- SC calendar day 적용시 Free time 계산 관련  
*                  :  S/C exception 인 경우는 Sat/Sun/Holi "Y" 인 경우 계산 제외시킴.
*                  미국 CA DET 계산 관련  지역추가  'USLGB', 'USLAX', 'USGAC'(2012.07.03)
* 2012.10.23 김현화 [CHM-201220676-01][DMT] OP-MT Detention 계산 방법 보완 (AA - Chang-Bin LIM)                
* 2013.01.31 임창빈 [CHM-201222196]
*            [DMT] Basic Tariff 및 Commodity Exception Tariff의 Effective Date 적용 기준 변경
*            Basic Tariff 및 Commodity Exception Tariff 적용 시 Inbound Charge(DMIF, DTIC, CTIC)의 경우에는 Effective Date 적용 기준을 아래와 같이 변경 
*            [AS-IS] POD_ETA 
*            [TO-BE] POD가 ‘US’ or ‘CA’이면 OC date, 그 외에는 POD_ETA 
*            - 사유 : FMC 규정에 의거 미국 및 캐나다 수출입 화물의 경우에는 Charge 부과 기준일이 OC date 임 (하지만 현재 시스템 로직은 POD_ETA를 기준으로 하고 있음) 
*            - 기타 : Outbound Charge의 경우 DTOC 및 CTOC는 OP date, DMOF는 OC date를 기준으로 Charge 계산하고 있음 
* 2013.02.28 임창빈 [CHM-201323278]
*            [DMT] 미국 Rail Ramp 중 4곳의 DMIF 계산 방법 보완
*            DMIF의 경우 VD와 ID 사이에 EN/TN이 있는 경우에는 VD-EN/TN과 IC-ID로 2개의 DMIF를 생성함.
*            이 때 두번째 DMIF의 IC가 USCHIT1, USCHIY1, USDALR4, USHOUR2처럼 DEM 생성 Yard이면서 Basic Tariff에는 Exempted이면,
*            첫번째 DMIF 완성 후, 두번째 DMIF의 IC로는 DMIF가 안만들어지고 ID로는 DMIF가 만들어지게 되는데, 
*            동 ID가 첫번째 DMIF의 TO 정보로 들어가서 잘못된 DMIF가 만들어 진다.
* [Sample Movement Data]
* VD	USLGBPT	2012/12/11 15:42:00
* IC	USLGBPT	2012/12/11 15:42:00
* EN	USLGBPT	2012/12/15 02:51:00
* IC	USCHIT1	2012/12/19 08:11:00  Basic Tariff가 Exempted로 설정된 경우.
* ID	USCHIT1	2012/12/20 10:09:00
* MT	USCHIT3	2012/12/21 09:22:00

* [As-Is]
* (From Data)                      (To Data)                          (Tariff CD)
* VD	USLGBPT	2012/12/11 15:42:00   ID	USCHIT1	2012/12/20 10:09:00   DMIF -> To Data에 원래 EN 임, IC는 Exempted 임으로 Charge 정보 변경하지 않다가, ID가 입력되면, EN를 ID로 변경하게 됨.
* ID	USCHIT1	2012/12/20 10:09:00   MT	USCHIT3	2012/12/21 09:22:00   DTIC

* [To-Be]
* (From Data)                      (To Data)                          (Tariff CD)
* VD	USLGBPT	2012/12/11 15:42:00   EN	USLGBPT	2012/12/15 02:51:00   DMIF
* ID	USCHIT1	2012/12/20 10:09:00   MT	USCHIT3	2012/12/21 09:22:00   DTIC
* 2013.02.28 임창빈 [CHM-201322954]
*            [DMT] 신규 장비에 대한 DMT charge 청구를 위한 Table Mapping 요청
* TP/SZ  Description                          CGP TYPE   CNTR Size 
*--------------------------------------------------------------------
*  C2    20FT COIL RACK CONTAINER            Open Top   20FT 
*  C4    40FT COIL RACK CONTAINER            Open Top   40FT 
*  R8    LIVE FISH CONTAINER                 Reefer     R9 
* 2013.03.15 임창빈 : 소스 품질 결함 보완
*          [원인]
*          - Line No. 253 Name -> containerCargoTypeVO
*          - 전역 변수과 지역 변수의 동일한 이름을 점검한다.
*          [As-Is] 
*          ContainerCargoTypeVO containerCargoTypeVO = settingContainerCargoType(containerCargoTypeParmVO);
*          [To-Be] Local 변수명을 변경해서 선언함.
*          ContainerCargoTypeVO containerCargoTypeVO_local = settingContainerCargoType(containerCargoTypeParmVO);
* 2013.03.28 임창빈 [CHM-201323278]
*            T/S Port에서 POD까지 Barge로 운송으로 DMT 에러 보완 요청
* In-Bound 중에 Booking/POD에 해당하는 VVD가 존재하지 않는 경우가 존재함. BKG No. : TEM300099700 CNTR No. : BMOU2922316
* Ex) VD-TS-EN/TN
*     EN/TN 위치에 Booking/POD에 해당하는 VD가 발생해야 하지만, 아래와 같은 사유로 VD가 발생하지 않고 있음
*     BKG_VVD 테이블에  Post VVD가 존재하지만 실제 Post(Feeder) VVD를 할당 하지 않아 Vessel Schedule를 찾지 못하는 문제에 대해 보완한다.
* 사유 : Port EQ 및 세관 Clearance등의 이유로 T/S port (BEANR, NLRTM, DEHAM, DEBRV)에서
*       VD후 POD까지 Barge로 운송함에 따라 BKG의 F/VVD Update 불가함에 따라
*       현재 발생하는 DMIF/DTIC 에러 (Basic Tariff error)에 대하여 보완
* 보완 : ETB Date를 찾지 못할 경우 From Movement Date를 사용하도록 한다.
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.AFTExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ActCustInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BFRExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BkgContainerInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationAMTVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChangePODTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CheckWeekEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.CommodityExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DMIFnDTICFreeTimeEndDateVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtAFTGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtBFRGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtCmdtGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DmtSCGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DtocFreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.DualTypeExceptionCustInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExchangeRateParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixORGLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPODLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixPOLLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.LocationByBoundVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.MovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNDivVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OverdayNStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.StopDaysVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * 배치시 사용되는 공통 함수<br>
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTCalculationUtil {
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	ContainerCargoTypeVO 		containerCargoTypeVO 	 = new ContainerCargoTypeVO();
	ContainerCargoTypeParmVO 	containerCargoTypeParmVO = new ContainerCargoTypeParmVO();
	ChargeArgumentVO 			chargeArgumentVO 		 = new ChargeArgumentVO();
	

	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	/**
	 * searchBscSvrId 대한 해당 데이터를 조회한다. (2010-09-10 생성) 
	 * @param zDcFmYdCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchBscSvrId(String zDcFmYdCd) throws DAOException {
		return dbDao.searchBscSvrId(zDcFmYdCd);
	}
	
	/**
	 * searchInOutGauge  대한 해당 데이터를 조회한다.
	 * @param String zCntrNo  
	 * @param String zBkgNo  
	 * @return String 
	 * @throws DAOException
	 */
	public String searchInOutGauge(String zCntrNo  , String zBkgNo  ) throws DAOException {
		return dbDao.searchAwkInOut(zBkgNo  , zCntrNo  );
	}

	/**
	 * settingContainerCargoType  대한 해당 데이터를 조회한다.
	 * @param ContainerCargoTypeParmVO containerCargoTypeParmVO
	 * @return ContainerCargoTypeVO
	 * @exception EventException
	 * 2010-09-14: Charge Calculation시 CNTR-Cargo조합의 적용Rate 선택 변경 - "DGR"과 "AWK"의 순서를 변경 즉 "AWK"를 "DGR" 위로 올림
	 */
	public ContainerCargoTypeVO settingContainerCargoType(ContainerCargoTypeParmVO containerCargoTypeParmVO) {
		
		if(containerCargoTypeParmVO.getRcFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("RFR");
		} else if(containerCargoTypeParmVO.getAwkCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("AWK");
		} else if(containerCargoTypeParmVO.getDcgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("DGR");
		} else if(containerCargoTypeParmVO.getRdCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("DRY");
		} else if(containerCargoTypeParmVO.getSocFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("SOC");
		} else if(containerCargoTypeParmVO.getBbCgoFlg().equals("Y")){
			containerCargoTypeVO.setCgoTp("B/B");
		} else {
			containerCargoTypeVO.setCgoTp("DRY");
		} 
		return containerCargoTypeVO;
		
	}
	
	/**
	 * MST_CONTAINER에서 정의된 CONTAINER TYPE CODE를 DMT에서 정의한 CONTAINER TYPE CODE을 치환한다.
	 * MST_CONTAINER.CNTR_TPSZ_CD (2자리) -> DMT_CHG_BKG_CNTR.DMDT_CNTR_TP_CD (1 자리)로 변환 한다.
	 * DEM/DET CONTAINER TYPE CODE (CD02053) : DMT에서 정의한 CONTAINER TYPE CODE
	 * @param String cntrTpSzCd
	 * @return String
	 * @exception EventException
	 */
	
	public String settingDemDetContainerTypeCode(String cntrTpSzCd) {
		String 	prmCntrTp		= nullToString(cntrTpSzCd, 1).substring(0, 1);
		String	rtnDmdtCntrTpCd = "";
		
		if(prmCntrTp.equals("P")){
			rtnDmdtCntrTpCd = "F";
		} else if(prmCntrTp.equals("C")){
			// [CHM-201322954] CSR 참조
			rtnDmdtCntrTpCd = "O";
		} else if(prmCntrTp.equals("A")){
			rtnDmdtCntrTpCd = "F";
		} else if( prmCntrTp.equals("S") ){
			rtnDmdtCntrTpCd = "O";
		} else {
			rtnDmdtCntrTpCd = prmCntrTp;
		}

		log.debug("*******************************************************");
		log.debug("[Return DMDT_CNTR_TP_CD] rtnDmdtCntrTpCd :"+ rtnDmdtCntrTpCd);
		log.debug("*******************************************************");
		
		return rtnDmdtCntrTpCd;
	}
	
	/**
	 * 특정 Yard( USCHIT1, USCHIY1, USDALR4, USHOUR2)에 대한 Cargo Type를 확인해서 Main 배치 프로그램 내에서 IC & ID Event에 대한 Exception 처리 한다. 
	 * @param ContainerCargoTypeParmVO containerCargoTypeParmVO  
	 * @param String ydCd 
	 * @return String 
	 * @throws DAOException
	 */
	public String chcekUSAYardNCargoType(ContainerCargoTypeParmVO containerCargoTypeParmVO, String ydCd) {
		String checkYardFlag = "X";
		
		if( 
				DMTCalculationUtil.nullToString(ydCd, 7).substring(0,7).equals("USCHIT1")  ||
				DMTCalculationUtil.nullToString(ydCd, 7).substring(0,7).equals("USCHIY1")  ||
				DMTCalculationUtil.nullToString(ydCd, 7).substring(0,7).equals("USDALR4")  ||
				DMTCalculationUtil.nullToString(ydCd, 7).substring(0,7).equals("USHOUR2") 
			) 
		{
			
			ContainerCargoTypeVO containerCargoTypeVO_local = settingContainerCargoType(containerCargoTypeParmVO);
			
			if (DMTCalculationUtil.nullToString(containerCargoTypeVO_local.getCgoTp(), 3).equals("RFR")){
				checkYardFlag = "N";
			} else {
				checkYardFlag = "Y";
			}
		}
		
		return checkYardFlag;
	}
	
	/**
	 * Booking Cancel ( OP -> MT ) 일 경우 Container Type/Size에 따라 Cargo Type을 결정한다.
	 * @param String zCntrtsCd
	 * @return String
	 * @exception EventException
	 */
	
	public String settingContainerCargoTypeByBkgCancel(String zCntrtsCd) {
		String prmCntrTp		= nullToString(zCntrtsCd);

		String	zDcsCgoTp = "";
		if        ( prmCntrTp.equals("R") ) {
			zDcsCgoTp = "RFR";
		} else if ( prmCntrTp.equals("T") ) {
			zDcsCgoTp = "DGR";
		} else if ( prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P") ||
				    prmCntrTp.equals("A") || prmCntrTp.equals("S") ) {
			zDcsCgoTp = "AWK";
		} else {
			zDcsCgoTp = "DRY";
		}

		return zDcsCgoTp;
	}
	
	/**
	 * searchBookingContainerQuantity 대한 해당 데이터를 조회한다.
	 * @param String zBkgNo  
	 * @return int
	 * @exception EventException
	 * @throws DAOException 
	 */
	public int searchBookingContainerQuantity(String zBkgNo  ) throws EventException, DAOException {
		return dbDao.searchBookingContainerQuantity(zBkgNo  );
	}


	/**
	 * setLocationByBound 대한 해당 데이터를 조회한다.
	 * @param LocationByBoundParmVO locationByBoundParmVO
	 * @return LocationByBoundVO
	 * @exception EventException
	 */
	public LocationByBoundVO setLocationByBound(LocationByBoundParmVO locationByBoundParmVO) {
		LocationByBoundVO locationByBoundVO = new LocationByBoundVO();
		
		if(locationByBoundParmVO.getIoBnd().equals("I")){
			locationByBoundVO.setBkgLocCd(locationByBoundParmVO.getDelLocCd());
			locationByBoundVO.setBkgCntCd(locationByBoundParmVO.getDelCntCd());
			locationByBoundVO.setBkgRgnCd(locationByBoundParmVO.getDelRgnCd());
			locationByBoundVO.setBkgStateCd(locationByBoundParmVO.getDelStateCd());
		} else {
			locationByBoundVO.setBkgLocCd(locationByBoundParmVO.getPorLocCd());
			locationByBoundVO.setBkgCntCd(locationByBoundParmVO.getPorCntCd());
			locationByBoundVO.setBkgRgnCd(locationByBoundParmVO.getPorRgnCd());
			locationByBoundVO.setBkgStateCd(locationByBoundParmVO.getPorStateCd());
		}
		return locationByBoundVO;
	}

	/**
	 * fixPODLocation 대한 해당 데이터를 조회한다.
	 * @param FixPODLocationParmVO fixPODLocationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String fixPODLocation(FixPODLocationParmVO fixPODLocationParmVO) throws EventException {
		String	iPodLoc		= nullToString(fixPODLocationParmVO.getPodCd());
		String	iDelLoc		= nullToString(fixPODLocationParmVO.getDelCd());
		String	iPostRly	= nullToString(fixPODLocationParmVO.getPostRly());
		String	oPodLoc		= "";
		
		//2010.03.26 searchInVVDNEta 추가
		VVDNEtaVO vvdEtaVO = null;
		try {
			vvdEtaVO = dbDao.searchInVVDNEta(fixPODLocationParmVO.getBkgNo(), iPodLoc);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchInVVDNEta Select Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchInVVDNEta Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		if( (iPodLoc.equals("DEBRV") && iDelLoc.equals("DEBRV")	&& iPostRly.equals("DEHAM"))
			||(iPodLoc.equals("DEHAM") && iDelLoc.equals("DEHAM") && iPostRly.equals("DEBRV"))
			||(iPodLoc.equals("BEANR") && nullToString(vvdEtaVO.getVslCd()).equals("") && iPostRly.equals("NLRTM"))
			//||(iPodLoc.equals("BEANR") && iDelLoc.equals("BEANR") && iPostRly.equals("NLRTM"))
			||(iPodLoc.equals("ITGOA") && iDelLoc.equals("ITGOA") && iPostRly.equals("ITSPE"))){
			oPodLoc = iPostRly;
		} else {
			oPodLoc = iPodLoc;
		}
		return oPodLoc;
	}

	/**
	 * fixPOLLocation 대한 해당 데이터를 조회한다.
	 * @param FixPOLLocationParmVO fixPOLLocationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String fixPOLLocation(FixPOLLocationParmVO fixPOLLocationParmVO) throws EventException {
		String	iPorLoc	= nullToString(fixPOLLocationParmVO.getPorCd());
		String	iPolLoc	= nullToString(fixPOLLocationParmVO.getPolCd());
		String	iPreRly	= nullToString(fixPOLLocationParmVO.getPreRly());
		String	oPolLoc	= "";
		
		//2010.03.26 searchOutVVDNEta 추가
		VVDNEtaVO vvdEtaVO = null;
		try {
			vvdEtaVO = dbDao.searchOutVVDNEta(fixPOLLocationParmVO.getBkgNo(), iPolLoc);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchOutVVDNEta Select Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchOutVVDNEta Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		//if( (iPorLoc.equals("BEANR") && iPolLoc.equals("BEANR")	&& iPreRly.equals("NLRTM"))){
		if( (iPorLoc.equals("BEANR") && nullToString(vvdEtaVO.getVslCd()).equals("") && iPreRly.equals("NLRTM"))){
			oPolLoc = iPreRly;
		} else {
			oPolLoc = iPolLoc;
		}
		
		return oPolLoc;
	}

	/**
	 * searchVVDNEta 대한 해당 데이터를 조회한다.
	 * @param String bookingNo
	 * @param String polCode
	 * @param String podCode
	 * @param String ioBound
	 * @return VVDNEtaVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public VVDNEtaVO searchVVDNEta(String bookingNo, String polCode, 
			String podCode, String ioBound) throws EventException, DAOException {
			VVDNEtaVO vvdEtaVO = null;
			
			if(ioBound.equals("I")){
				vvdEtaVO = dbDao.searchInVVDNEta(bookingNo, podCode);
			} else {
				vvdEtaVO = dbDao.searchOutVVDNEta(bookingNo, polCode);
			}
			
			return vvdEtaVO;
		}


	/**
	 *  fixDELLocation 대한 해당 데이터를 조회한다.
	 * 
	 * @param FixDELLocationParmVO fixDELLocationParmVO
	 * @return FixDELLocationVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FixDELLocationVO fixDELLocation(FixDELLocationParmVO fixDELLocationParmVO) throws EventException, DAOException {
		FixDELLocationVO fixDELLocationVO = new FixDELLocationVO();
			
		String	prmDttCode		= nullToString(fixDELLocationParmVO.getDmdtTrfCd(), 4);
		String	prmPodLocCd		= nullToString(fixDELLocationParmVO.getPodCd(), 5);
		String	prmDelLocCd		= nullToString(fixDELLocationParmVO.getDelCd(), 5);
		String	prmBcntrDlvTerm	= nullToString(fixDELLocationParmVO.getDeTermCd(), 1);
//		String	prmDcFmCnms		= nullToString(fixDELLocationParmVO.getFmMvmtStsCd());
//		String	prmDcToCnms		= nullToString(fixDELLocationParmVO.getToMvmtStsCd());
		String	prmDcIoBnd		= nullToString(fixDELLocationParmVO.getIoBnd());
		String	prmTspFlag		= nullToString(fixDELLocationParmVO.getTspFlag(), 1);
		String	prmPostRly		= nullToString(fixDELLocationParmVO.getPostRly());
		String	prmPreRly		= nullToString(fixDELLocationParmVO.getPreRly());

		/* --------------------------------------- */	
		ChangePODTariffVO changePODTariffVO = null;
		
		if( prmTspFlag.substring(0,1).equals("Y") ){
				changePODTariffVO = dbDao.changePODTariff(prmPodLocCd, prmDcIoBnd, prmPostRly, prmPreRly, 
						prmTspFlag, "DEL");
			
			log.debug("******************************************************************");
			log.debug("*[ Apply RLY Tariff ] rtnDelLocCd :"+changePODTariffVO.getLocCd());
			log.debug("******************************************************************");

			fixDELLocationVO.setDelContiCd(changePODTariffVO.getContiCd());
			fixDELLocationVO.setDelCntCd(changePODTariffVO.getCntCd());
			fixDELLocationVO.setDelRgnCd(changePODTariffVO.getRgnCd());	//2010.02.17 추가
			fixDELLocationVO.setDelSteCd(changePODTariffVO.getSteCd());
			fixDELLocationVO.setDelCd(changePODTariffVO.getLocCd());;
			fixDELLocationVO.setMsgCd("1");
			return fixDELLocationVO;
		} else if(prmDttCode.equals("DMIF") || prmDttCode.equals("DTIC") || prmDttCode.equals("CTIC")){	 //____ InBound
			if( 
				( 	
					prmPodLocCd.substring(0,2).equals("US") && ( prmDelLocCd.substring(0,2).equals("CA") || prmDelLocCd.substring(0,2).equals("MX") )
					&&(prmBcntrDlvTerm.substring(0,1).equals("D"))
				) 
				||
				(
					prmPodLocCd.substring(0,5).equals("CNHKG") && !prmDelLocCd.substring(0,5).equals("CNHKG")
				)
				||
				(
					prmDttCode.equals("DMIF") && prmPodLocCd.substring(0,5).equals("USNYC") && prmDelLocCd.substring(0,2).equals("US")
					&&
					(
						!prmDelLocCd.substring(0,5).equals("USBOS") &&
						!prmDelLocCd.substring(0,5).equals("USGLO") &&
						!prmDelLocCd.substring(0,5).equals("USFRK") &&
						!prmDelLocCd.substring(0,5).equals("USEVT") 
					)
				)
				||
				(	 
					prmDttCode.equals("DMIF")
					&&
					(
						prmPodLocCd.substring(0,5).equals("USLGB") || prmPodLocCd.substring(0,5).equals("USOAK") ||	
						prmPodLocCd.substring(0,5).equals("USSEA") ||
						prmPodLocCd.substring(0,5).equals("USPDX") || prmPodLocCd.substring(0,5).equals("USSAV") ||	
						prmPodLocCd.substring(0,5).equals("USLAX") ||
						prmPodLocCd.substring(0,5).equals("USCHS") || prmPodLocCd.substring(0,5).equals("USORF")
					)
					&&
					(
						prmDelLocCd.substring(0,2).equals("US") || prmDelLocCd.substring(0,2).equals("MX")
					)
				)   
				||
				(	 
					prmDttCode.equals("DMIF") && prmPodLocCd.substring(0,2).equals("NL")
					&&
					(
						prmDelLocCd.substring(0,2).equals("DE") || prmDelLocCd.substring(0,2).equals("BE") || 
						prmDelLocCd.substring(0,2).equals("PL") ||		
						prmDelLocCd.substring(0,2).equals("FR") || prmDelLocCd.substring(0,2).equals("DK") || 
						prmDelLocCd.substring(0,2).equals("CH")
					)
				)   
				||
				(	 
					(
						prmDttCode.equals("DMIF") || prmDttCode.equals("DTIC")
					)
					&&
					(
						prmPodLocCd.substring(0,5).equals("FRLEH") || prmPodLocCd.substring(0,5).equals("FRFOS")
					)
					&&
					prmDelLocCd.substring(0,2).equals("FR")
				)  
				||
				(	 
					(
						prmDttCode.equals("DMIF") || prmDttCode.equals("DTIC")
					)
					&&
					prmPodLocCd.substring(0,5).equals("ESBIO")
					&&
					prmDelLocCd.substring(0,2).equals("ES")
				)   
				||
				( 
					prmDttCode.equals("DMIF")
					&&
					prmPodLocCd.substring(0,5).equals("BEANR")
					&&
					(
						prmDelLocCd.substring(0,2).equals("DE") || prmDelLocCd.substring(0,2).equals("PL") ||
						prmDelLocCd.substring(0,2).equals("FR") || prmDelLocCd.substring(0,2).equals("CH")
					)
				)   
				||
				(	 
					prmDttCode.equals("DMIF")
					&&
					(
						prmPodLocCd.substring(0,5).equals("DEHAM") || prmPodLocCd.substring(0,5).equals("DEBRV")
					)
					&&
					(
						prmDelLocCd.substring(0,2).equals("AT") || prmDelLocCd.substring(0,2).equals("NL") || 
						prmDelLocCd.substring(0,2).equals("CH")
					)
				)  
				||
				(	 
					prmDttCode.equals("DMIF")
					&&
					prmPodLocCd.substring(0,5).equals("USTIW")
					&&
					prmDelLocCd.substring(0,2).equals("US")
				)   
			){
				/*___ Change POD Tariff */
				
				try {
					changePODTariffVO = dbDao.changePODTariff(prmPodLocCd, "", "", "", "", "DEL");
				} catch (Exception e) {
					log.error("*******************************************************");
					log.error("changePODTariff Select Error !  "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("changePODTariff Select Error ! " + new ErrorHandler(e).getMessage());
				}
				fixDELLocationVO.setDelContiCd(changePODTariffVO.getContiCd());
				fixDELLocationVO.setDelCntCd(changePODTariffVO.getCntCd());
				fixDELLocationVO.setDelRgnCd(changePODTariffVO.getRgnCd());	//2010.02.17 추가
				fixDELLocationVO.setDelSteCd(changePODTariffVO.getSteCd());
				fixDELLocationVO.setDelCd(changePODTariffVO.getLocCd());;
				fixDELLocationVO.setMsgCd("1");
				return fixDELLocationVO;
			}
		}
		fixDELLocationVO.setMsgCd("0");
		return fixDELLocationVO;
	}

	
	
	/**
	 *  fixORGLocation 대한 해당 데이터를 조회한다.
	 * 
	 * @param FixORGLocationParmVO fixORGLocationParmVO
	 * @return FixORGLocationVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FixORGLocationVO fixORGLocation(FixORGLocationParmVO fixORGLocationParmVO) throws EventException, DAOException {
		FixORGLocationVO fixORGLocationVO = new FixORGLocationVO();
			
		String	prmDcIoBnd		= nullToString(fixORGLocationParmVO.getIoBnd(), 1);
		String	prmTspFlag		= nullToString(fixORGLocationParmVO.getTspFlag(), 1);
		String	prmDelLocCd		= nullToString(fixORGLocationParmVO.getDelLocCd());

		/* --------------------------------------- */	
		ChangePODTariffVO changePODTariffVO = null;
		
		if( prmTspFlag.substring(0, 1).equals("Y") && prmDcIoBnd.substring(0, 1).equals("O") ){
			changePODTariffVO = dbDao.changePODTariff(prmDelLocCd, "", "", "", "", "ORG");
			
			log.debug("*******************************************************************");
			log.debug("* [ Apply ORG Tariff ] rtnDelLocCd "+changePODTariffVO.getLocCd());
			log.debug("*******************************************************************");

			fixORGLocationVO.setOrgContiCd(changePODTariffVO.getContiCd());
			fixORGLocationVO.setOrgCntCd(changePODTariffVO.getCntCd());
			fixORGLocationVO.setOrgRgnCd(changePODTariffVO.getRgnCd()); //2010.02.17 추가	
			fixORGLocationVO.setOrgSteCd(changePODTariffVO.getSteCd());
			fixORGLocationVO.setOrgCd(changePODTariffVO.getLocCd());;
			fixORGLocationVO.setMsgCd("1");
			return fixORGLocationVO;
		}
		fixORGLocationVO.setMsgCd("0");
		return fixORGLocationVO;
	
}

	/**
	 * searchBasicTariffByGeneration 대한 해당 데이터를 조회한다.
	 * 
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return BasicTariffKeyVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public BasicTariffKeyVO searchBasicTariffByGeneration(BasicTariffParmVO basicTariffParmVO) throws EventException, DAOException {
		BasicTariffKeyVO basicTariffKeyVO = new BasicTariffKeyVO();
		
		String prmDttCode		= nullToString(basicTariffParmVO.getDmdtTrfCd());
		String prmDmdtDeTermCd	= nullToString(basicTariffParmVO.getDmdtDeTermCd());

		String prmPorContiCd	= nullToString(basicTariffParmVO.getPorContiCd());
		String prmPorCntCd		= nullToString(basicTariffParmVO.getPorCntCd());
		String prmPorRgnCd		= nullToString(basicTariffParmVO.getPorRgnCd());
		String prmPorStateCd	= nullToString(basicTariffParmVO.getPorSteCd());
		String prmPorLoc		= nullToString(basicTariffParmVO.getPorLocCd());
		
		String prmYrdContiCd	= nullToString(basicTariffParmVO.getYrdContiCd());
		String prmYrdCntCd		= nullToString(basicTariffParmVO.getYrdCntCd());
		String prmYrdRgnCd		= nullToString(basicTariffParmVO.getYrdRgnCd());
		String prmYrdStateCd	= nullToString(basicTariffParmVO.getYrdSteCd());
		String prmYrdLoc		= nullToString(basicTariffParmVO.getYrdLocCd());
		
		String prmPolContiCd	= nullToString(basicTariffParmVO.getPolContiCd());
		String prmPolCntCd		= nullToString(basicTariffParmVO.getPolCntCd());
		String prmPolRgnCd		= nullToString(basicTariffParmVO.getPolRgnCd());
		String prmPolStateCd	= nullToString(basicTariffParmVO.getPolSteCd());
		String prmPolLoc		= nullToString(basicTariffParmVO.getPolLocCd());

		String prmDelContiCd	= nullToString(basicTariffParmVO.getDelContiCd());
		String prmDelCntCd		= nullToString(basicTariffParmVO.getDelCntCd());
		String prmDelRgnCd		= nullToString(basicTariffParmVO.getDelRgnCd());
		String prmDelStateCd	= nullToString(basicTariffParmVO.getDelSteCd());
		String prmDelLoc		= nullToString(basicTariffParmVO.getDelLocCd());
		
		String prmEfftDt		= nullToString(basicTariffParmVO.getEffDt());
		String prmCntrTp		= nullToString(basicTariffParmVO.getDmdtCntrTpCd());
		String prmCgoTp			= nullToString(basicTariffParmVO.getDmdtCgoTpCd());
		String prmIoBnd			= nullToString(basicTariffParmVO.getIoBndCd());
		String prmAwkInOut		= nullToString(basicTariffParmVO.getAwkInOut());
		
		log.debug("*******************************************************");
		log.debug("[searchBasicTariffByGeneration ] prmDmdtDeTermCd :"+prmDmdtDeTermCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorContiCd 	:"+prmPorContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorCntCd 	:"+prmPorCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorRgnCd 	:"+prmPorRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorStateCd 	:"+prmPorStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmPorLoc 		:"+prmPorLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmYrdContiCd 	:"+prmYrdContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdCntCd 	:"+prmYrdCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdRgnCd 	:"+prmYrdRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdStateCd 	:"+prmYrdStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmYrdLoc 		:"+prmYrdLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmPolContiCd 	:"+prmPolContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolCntCd 	:"+prmPolCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolRgnCd 	:"+prmPolRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolStateCd 	:"+prmPolStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmPolLoc 		:"+prmPolLoc);

		
		log.debug("[searchBasicTariffByGeneration ] prmDelContiCd 	:"+prmDelContiCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelCntCd 	:"+prmDelCntCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelRgnCd 	:"+prmDelRgnCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelStateCd 	:"+prmDelStateCd);
		log.debug("[searchBasicTariffByGeneration ] prmDelLoc 		:"+prmDelLoc);
		
		log.debug("[searchBasicTariffByGeneration ] prmDttCode 		:"+prmDttCode);
		log.debug("[searchBasicTariffByGeneration ] prmEfftDt 		:"+prmEfftDt);
		log.debug("[searchBasicTariffByGeneration ] prmCntrTp 		:"+prmCntrTp);
		log.debug("[searchBasicTariffByGeneration ] prmCgoTp 		:"+prmCgoTp);
		log.debug("[searchBasicTariffByGeneration ] prmIoBnd 		:"+prmIoBnd);
		log.debug("[searchBasicTariffByGeneration ] prmAwkInOut 	:"+prmAwkInOut);
		log.debug("*******************************************************");
		
		/* ----------------- CNTR & CGO Type Adjust */

		if(prmCntrTp.equals("D")){
			if(prmCgoTp.equals("AWK") || prmCgoTp.equals("B/B") || prmCgoTp.equals("SOC")){
					prmCgoTp = "DRY";
			  }
		}

		if( prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC") || prmCgoTp.equals("AWK")){
				prmCgoTp = "DRY";
			}
		}

		if( prmCntrTp.equals("R")){
			if(prmCgoTp.equals("AWK")|| prmCgoTp.equals("DGR")){
					prmCgoTp = "DRY";
			}
		}

		if(	(!prmCntrTp.equals("D") && !prmCntrTp.equals("R")) && prmCgoTp.equals("AWK")){
			if( prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			} else if( prmAwkInOut.equals("O")){
				prmCgoTp = "AWK";
			}
		}

		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P")){
			if(prmCgoTp.equals("DGR")){
//				prmCntrTp = "D";
				prmCgoTp = "DRY"; // 2010-09-14 : Charge Calculation시 CNTR-Cargo조합의 적용Rate 선택 변경
			}
		}

		if(prmCntrTp.equals("F")){
			if(prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			} else if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}

		if(prmCntrTp.equals("O") || prmCntrTp.equals("C") ){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}

		if(prmCntrTp.equals("S")){
			if(prmCgoTp.equals("DGR")){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}

		// 2012.02.22 권 민 [CHM-201216013] [DMT] A4-B/B 조합의 Charge 생성 불가에 대한 보완	
		if(prmCntrTp.equals("A")){
			if(prmCgoTp.equals("DGR" )){
				prmCntrTp = "D";
			} else	if(prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
				prmCntrTp = "F";
			} else {
			  prmCntrTp = "F";
			}
		}
	
		/* --------------------------------------------------------------------------------- */

		//위의 Logic에서 변경된 값을 VO에 재 입력.
		basicTariffParmVO.setDmdtCgoTpCd(prmCgoTp);
		basicTariffParmVO.setDmdtCntrTpCd(prmCntrTp);

		log.debug(" [searchBasicTariffByGeneration] getDmdtCgoTpCd  :"+ basicTariffParmVO.getDmdtCgoTpCd());
		log.debug(" [searchBasicTariffByGeneration] getDmdtCntrTpCd :"+ basicTariffParmVO.getDmdtCntrTpCd());
		
		basicTariffKeyVO = dbDao.searchBasicTariffByGeneration(basicTariffParmVO);
		
		
		//DMTTRFGRP.DMDTTRFGRPTPCD: B-Billable, N-Charge (Exempted)를 받지 않는 것
		log.debug(" [basicTariffKeyVO(return)] getDmdtTrfGrpTpCd :"+ basicTariffKeyVO.getDmdtTrfGrpTpCd());
		
		if(basicTariffKeyVO.getDmdtTrfGrpTpCd() != null && basicTariffKeyVO.getDmdtTrfGrpTpCd().equals("N")){
			log.debug("\n[basicTariffKeyVO(return)] getDmdtTrfGrpTpCd : Exempted");
			
			basicTariffKeyVO.setMsgCd("-99");
			return	basicTariffKeyVO;
		}

		return basicTariffKeyVO;
	
	}

	/**
	 * BKG Cancel로 인하여 OP-MT가 발생한 경우에 대한 Basic Tariff 정보를 조회한다.
	 * 
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return BasicTariffKeyVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */

public BasicTariffKeyVO searchBasicTariffByBkgCancel(BasicTariffParmVO basicTariffParmVO) throws EventException, DAOException {
		BasicTariffKeyVO basicTariffKeyVO = new BasicTariffKeyVO();
		
		String prmDmdtDeTermCd	= nullToString(basicTariffParmVO.getDmdtDeTermCd());
		String prmPorContiCd	= nullToString(basicTariffParmVO.getPorContiCd());
		String prmPorCntCd		= nullToString(basicTariffParmVO.getPorCntCd());
		String prmPorRgnCd		= nullToString(basicTariffParmVO.getPorRgnCd());
		String prmPorStateCd	= nullToString(basicTariffParmVO.getPorSteCd());
		String prmPorLoc		= nullToString(basicTariffParmVO.getPorLocCd());
		
		String prmYrdContiCd	= nullToString(basicTariffParmVO.getYrdContiCd());
		String prmYrdCntCd		= nullToString(basicTariffParmVO.getYrdCntCd());
		String prmYrdRgnCd		= nullToString(basicTariffParmVO.getYrdRgnCd());
		String prmYrdStateCd	= nullToString(basicTariffParmVO.getYrdSteCd());
		String prmYrdLoc		= nullToString(basicTariffParmVO.getYrdLocCd());
		
		String prmPolContiCd	= nullToString(basicTariffParmVO.getPolContiCd());
		String prmPolCntCd		= nullToString(basicTariffParmVO.getPolCntCd());
		String prmPolRgnCd		= nullToString(basicTariffParmVO.getPolRgnCd());
		String prmPolStateCd	= nullToString(basicTariffParmVO.getPolSteCd());
		String prmPolLoc		= nullToString(basicTariffParmVO.getPolLocCd());

		String prmDelContiCd	= nullToString(basicTariffParmVO.getDelContiCd());
		String prmDelCntCd		= nullToString(basicTariffParmVO.getDelCntCd());
		String prmDelRgnCd		= nullToString(basicTariffParmVO.getDelRgnCd());
		String prmDelStateCd	= nullToString(basicTariffParmVO.getDelSteCd());
		String prmDelLoc		= nullToString(basicTariffParmVO.getDelLocCd());
		
		String prmDttCode		= nullToString(basicTariffParmVO.getDmdtTrfCd());
		String prmEfftDt		= nullToString(basicTariffParmVO.getEffDt());
		String prmCntrTp		= nullToString(basicTariffParmVO.getDmdtCntrTpCd());
		String prmCgoTp			= nullToString(basicTariffParmVO.getDmdtCgoTpCd());
		String prmIoBnd			= nullToString(basicTariffParmVO.getIoBndCd());
		
		String prmAwkInOut		= nullToString(basicTariffParmVO.getAwkInOut());
		
		log.debug("*******************************************************");
		log.debug("[searchBasicTariffByBkgCancel ] prmDmdtDeTermCd 	:"+prmDmdtDeTermCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPorContiCd 	:"+prmPorContiCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPorCntCd 	    :"+prmPorCntCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPorRgnCd 	    :"+prmPorRgnCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPorStateCd 	:"+prmPorStateCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPorLoc 		:"+prmPorLoc);
		
		log.debug("[searchBasicTariffByBkgCancel ] prmYrdContiCd 	:"+prmYrdContiCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmYrdCntCd 	    :"+prmYrdCntCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmYrdRgnCd 	    :"+prmYrdRgnCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmYrdStateCd 	:"+prmYrdStateCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmYrdLoc 		:"+prmYrdLoc);
		
		log.debug("[searchBasicTariffByBkgCancel ] prmPolContiCd 	:"+prmPolContiCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPolCntCd 	    :"+prmPolCntCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPolRgnCd 	    :"+prmPolRgnCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPolStateCd 	:"+prmPolStateCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmPolLoc 		:"+prmPolLoc);
		
		log.debug("[searchBasicTariffByBkgCancel ] prmDelContiCd 	:"+prmDelContiCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmDelCntCd 	    :"+prmDelCntCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmDelRgnCd 		:"+prmDelRgnCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmDelStateCd 	:"+prmDelStateCd);
		log.debug("[searchBasicTariffByBkgCancel ] prmDelLoc 		:"+prmDelLoc);
		
		log.debug("[searchBasicTariffByBkgCancel ] prmDttCode 		:"+prmDttCode);
		log.debug("[searchBasicTariffByBkgCancel ] prmEfftDt 		:"+prmEfftDt);
		log.debug("[searchBasicTariffByBkgCancel ] prmCntrTp 		:"+prmCntrTp);
		log.debug("[searchBasicTariffByBkgCancel ] prmCgoTp 		:"+prmCgoTp);
		log.debug("[searchBasicTariffByBkgCancel ] prmIoBnd 		:"+prmIoBnd);
		
		log.debug("[searchBasicTariffByBkgCancel ] prmAwkInOut 		:"+prmAwkInOut);
		log.debug("*******************************************************");

		basicTariffKeyVO = dbDao.searchBasicTariffByGeneration(basicTariffParmVO);
		
		//DMTTRFGRP.DMDTTRFGRPTPCD: B-Billable, N-Charge를 받지 않는 것
		log.debug(" [basicTariffKeyVO(return)] getDmdtTrfGrpTpCd 	:"+ basicTariffKeyVO.getDmdtTrfGrpTpCd());
		
		if(basicTariffKeyVO.getDmdtTrfGrpTpCd() != null && basicTariffKeyVO.getDmdtTrfGrpTpCd().equals("N")){
			basicTariffKeyVO.setMsgCd("-99");
			return	basicTariffKeyVO;
		}

		return basicTariffKeyVO;
	
	}

	/**
	 * basicFreeTime 대한 해당 데이터를 조회한다.
	 * 
	 * @param String zSvrId  
	 * @param String zDttCode
	 * @param long zDtnSeq
	 * @param String zDmdtDeTermCd	
	 * @param long zDtgGrpId
	 * @param long zDbcBkgQty
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long basicFreeTime(String zSvrId, String zDttCode, long zDtnSeq, String zDmdtDeTermCd, long zDtgGrpId, long zDbcBkgQty) throws EventException, DAOException{
		return dbDao.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);				
	}



	/**
	 * getDTOCFtime 대한 해당 데이터를 조회한다.
	 * 
	 * @param DtocFreeTimeParmVO dtocFreeTimeParmVO
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long getDTOCFtime(DtocFreeTimeParmVO dtocFreeTimeParmVO) throws EventException, DAOException {
		
		String	prmCntrNo	 	= nullToString(dtocFreeTimeParmVO.getCntrNo());
		long	prmCnmvCycNo	= stringToLong(dtocFreeTimeParmVO.getCnmvCycNo());
		String	prmEfftDt	 	= nullToString(dtocFreeTimeParmVO.getEfftDt());
		String	prmFmYdCd		= nullToString(dtocFreeTimeParmVO.getFmYdCd());
		
		log.debug("****************************************************");
		log.debug("[getDTOCFtime(param)] prmCntrNo 	  :"+ prmCntrNo);
		log.debug("[getDTOCFtime(param)] prmCnmvCycNo :"+ prmCnmvCycNo);
		log.debug("[getDTOCFtime(param)] prmEfftDt 	  :"+ prmEfftDt);
		log.debug("[getDTOCFtime(param)] prmFmYdCd 	  :"+ prmFmYdCd);
		log.debug("****************************************************");
		
		String 	zSvrId   	 = "";
		String 	zDttCode 	 = "";
		long	zDtnSeq	 	 = 0;
		String	zDmdtDeTermCd= "";
		long	zDtgGrpId	 = 0;

		String	zCntrtsCd	 = "";
		String	zBkgNo  	 = "";
		String	zBcntrSpeDg	 = "";
		String	zBcntrSpeRf	 = "";
		String	zBcntrSpeAk	 = "";
		String	zBcntrSpeRd	 = "";
		String	zBcntrSpeBb	 = "";
		String	zBcntrSocInd = "";
		String	zBcntrPartial= "";
		String	zBcntrExcept = "";
		String	zDcsCntrTp	 = "";
		String	zDcsCgoTp	 = "";
		
		String	zPorLoc	 	 = "";
		String	zPorContiCd	 = "";
		String	zPorCntCd	 = "";
		String	zPorRgnCd	 = "";
		String	zPorStateCd	 = "";
		
		String	zYrdLoc	 	 = "";
		String	zYrdContiCd	 = "";
		String	zYrdCntCd	 = "";
		String	zYrdRgnCd	 = "";
		String	zYrdStateCd	 = "";

		String	zPolLoc	 	 = "";
		String	zPolContiCd	 = "";
		String	zPolCntCd	 = "";
		String	zPolRgnCd	 = "";
		String	zPolStateCd	 = "";
		
		String	zDelLoc	 	 = "";
		String	zDelContiCd	 = "";
		String	zDelCntCd	 = "";
		String	zDelRgnCd	 = "";
		String	zDelStateCd	 = "";
		
		long	zDbcBkgQty	 = 0;
		String	dtgCmncTp	 = "";
		String	dtgCmncHr	 = "";
		String	dtgExclSat	 = "";
		String	dtgExclSun	 = "";
		String	dtgExclHoli	 = "";
		String	zCurCd	 	 = "";
		long	zDcFtDays	 = 0;
		String	awkInOut	 = "";
		
		String  zCmdtCd		 = "";
		String  zScNo		 = "";
		String  zRfaNo		 = "";
		String  zBrhScNo	 = "";                                                      
		String  zBrhRfaNo	 = "";

		String  actCustCntCd = "";	
		long    actCustSeq   = 0;   

		String zRepCmdtCd	 = "";    
		
		String zBbRcvTermCd		= "";
		String zBbDeTermCd 		= "";
        
		String dsdFtAddMk		= "";  
		String dsdFtimeMk		= "";                                                      
		long   dsdFtAddDay		= 0;   		

		String dbdFtimeMk		= "";                                                      
		long   dbdAddDay		= 0;                                                
		long   dbdTtlDay		= 0; 

		DtocFreeTimeVO dtocFreeTimeVO = null;

		DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
		
		try {
			//Booking Container 정보를 조회한다.
			dtocFreeTimeVO = dbDao.getDTOCFtime(dtocFreeTimeParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("getDTOCFtime Select Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("getDTOCFtime Select Error ! : " + new ErrorHandler(e).getMessage());
		}
   
		zCntrtsCd		= nullToString(dtocFreeTimeVO.getCntrTpszCd(), 1);
		zBkgNo  		= nullToString(dtocFreeTimeVO.getBkgNo());		
		                                                                                                                     
		zBcntrSpeDg		= nullToString(dtocFreeTimeVO.getDcgoFlg());		                                                     
		zBcntrSpeRf		= nullToString(dtocFreeTimeVO.getRcFlg());                                                                
		zBcntrSpeAk		= nullToString(dtocFreeTimeVO.getAwkCgoFlg());       		                                     
		zBcntrSpeRd		= nullToString(dtocFreeTimeVO.getRdCgoFlg());                                                             
		                                                                                                                     
		zBcntrSpeBb		= nullToString(dtocFreeTimeVO.getBbCgoFlg());		                                             
		zBcntrSocInd	= nullToString(dtocFreeTimeVO.getSocFlg());                                                                       
		zBcntrPartial	= nullToString(dtocFreeTimeVO.getCntrPrtFlg());		                                                     
		zBcntrExcept	= nullToString(dtocFreeTimeVO.getAdvShtgCd()); 
		zPorLoc			= nullToString(dtocFreeTimeVO.getPorCd());                                                                
		zPorContiCd		= nullToString(dtocFreeTimeVO.getPorContiCd());		                                     
		zPorCntCd		= nullToString(dtocFreeTimeVO.getPorCntCd());                                                            
		zPorRgnCd		= nullToString(dtocFreeTimeVO.getPorRgnCd());       		                                     
		zPorStateCd		= nullToString(dtocFreeTimeVO.getPorSteCd()); 
				                                                                                                                     
		zPolLoc			= nullToString(dtocFreeTimeVO.getPolCd());                                                                
		zPolContiCd		= nullToString(dtocFreeTimeVO.getPolContiCd());		                                     
		zPolCntCd		= nullToString(dtocFreeTimeVO.getPolCntCd());                                                            
		zPolRgnCd		= nullToString(dtocFreeTimeVO.getPolRgnCd());       		                                     
		zPolStateCd		= nullToString(dtocFreeTimeVO.getPolSteCd());                                                            
		
		zYrdLoc			= nullToString(dtocFreeTimeVO.getYrdCd());                                                                
		zYrdContiCd		= nullToString(dtocFreeTimeVO.getYrdContiCd());		                                     
		zYrdCntCd		= nullToString(dtocFreeTimeVO.getYrdCntCd());                                                            
		zYrdRgnCd		= nullToString(dtocFreeTimeVO.getYrdRgnCd());       		                                     
		zYrdStateCd		= nullToString(dtocFreeTimeVO.getYrdSteCd());
		
		zDelLoc			= nullToString(dtocFreeTimeVO.getDelCd());                                                               
		zDelContiCd		= nullToString(dtocFreeTimeVO.getDelContiCd());		                                        
		zDelCntCd		= nullToString(dtocFreeTimeVO.getDelCntCd());                                                               
		zDelRgnCd		= nullToString(dtocFreeTimeVO.getDelRgnCd());       		                                        
		zDelStateCd		= nullToString(dtocFreeTimeVO.getDelSteCd());   
         
		zCmdtCd			= nullToString(dtocFreeTimeVO.getCmdtCd());       
		zRepCmdtCd      = nullToString(dtocFreeTimeVO.getRepCmdtCd());      
		
		zScNo			= nullToString(dtocFreeTimeVO.getScNo());        		                                        
		zRfaNo			= nullToString(dtocFreeTimeVO.getRfaNo());   
        
		zBbRcvTermCd	= nullToString(dtocFreeTimeVO.getRcvTermCd());
		zBbDeTermCd 	= nullToString(dtocFreeTimeVO.getDeTermCd());

		log.debug("*******************************************************");
		log.debug("[getDTOCFtime()] zBcntrPartial + zBcntrExcept ["+zBcntrPartial+"] ["+ zBcntrExcept+ "]");
		log.debug("[getDTOCFtime()] prmCnmvCycNo    : "+prmCnmvCycNo);
		log.debug("[getDTOCFtime()] zBkgNo          : "+zBkgNo  );
		log.debug("*******************************************************");		
		
		/*
		[logic] Set DMDT_CNTR_TP_CD 
		*/
		
		zDcsCntrTp = settingDemDetContainerTypeCode( zCntrtsCd );
		
		log.debug("****************************************************");
		log.debug("[Set DMDT_CNTR_TP_CD] zDcsCntrTp : "+ zDcsCntrTp);
		log.debug("****************************************************");
		
		/*
		[logic] Cargo 타입 결정 : Set Cntr & Cgo Type
		*/
		containerCargoTypeParmVO.setDcgoFlg(zBcntrSpeDg);
		containerCargoTypeParmVO.setRcFlg(zBcntrSpeRf);
		containerCargoTypeParmVO.setAwkCgoFlg(zBcntrSpeAk);
		containerCargoTypeParmVO.setRdCgoFlg(zBcntrSpeRd);
		containerCargoTypeParmVO.setSocFlg(zBcntrSocInd);
		containerCargoTypeParmVO.setBbCgoFlg(zBcntrSpeBb);
		
		ContainerCargoTypeVO containerCargoTypeVO_local = settingContainerCargoType(containerCargoTypeParmVO);
		zDcsCgoTp = containerCargoTypeVO_local.getCgoTp();
		
		log.debug("****************************************************");
		log.debug("[DTOC - Type] zDcsCgoTp :"+ zDcsCgoTp);
		log.debug("****************************************************");
		
		/*
		[logic] Booking의 Container 물량 가져오기 : Get BKG Qty 
		*/
		try {
			zDbcBkgQty = searchBookingContainerQuantity(zBkgNo  );
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchBookingContainerQuantity Funtion Error! "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBookingContainerQuantity Funtion  Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("****************************************************");
		log.debug("[searchBookingContainerQuantity] zDbcBkgQty :"+ zDbcBkgQty);
		log.debug("****************************************************");
		
		try {
			awkInOut = searchInOutGauge(prmCntrNo, zBkgNo  );
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchBookingContainerQuantity Funtion Error !  "+e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchBookingContainerQuantity Funtion Error !  " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("****************************************************");
		log.debug("[searchInOutGauge] awkInOut : "+ awkInOut);
		log.debug("****************************************************");
		
		/*
		[logic] Basic Tariff정보 가져오기 : Get Basic Tariff No
		*/
		
		BasicTariffParmVO basicTariffParmVO = new BasicTariffParmVO();
		
		basicTariffParmVO.setCvrgYdCd(prmFmYdCd); //[2009.10.19  YARDCD추가: param:zDcFmYdCd]
		basicTariffParmVO.setPorContiCd(zPorContiCd);
		basicTariffParmVO.setPorCntCd(zPorCntCd);
		basicTariffParmVO.setPorRgnCd(zPorRgnCd);
		basicTariffParmVO.setPorSteCd(zPorStateCd);
		basicTariffParmVO.setPorLocCd(zPorLoc);
			
		basicTariffParmVO.setPolContiCd(zPolContiCd);
		basicTariffParmVO.setPolCntCd(zPolCntCd);
		basicTariffParmVO.setPolRgnCd(zPolRgnCd);
		basicTariffParmVO.setPolSteCd(zPolStateCd);
		basicTariffParmVO.setPolLocCd(zPolLoc);
		
		basicTariffParmVO.setYrdContiCd(zYrdContiCd);
		basicTariffParmVO.setYrdCntCd(zYrdCntCd);
		basicTariffParmVO.setYrdRgnCd(zYrdRgnCd);
		basicTariffParmVO.setYrdSteCd(zYrdStateCd);
		basicTariffParmVO.setYrdLocCd(zYrdLoc);
		
		basicTariffParmVO.setDelContiCd(zDelContiCd);
		basicTariffParmVO.setDelCntCd(zDelCntCd);
		basicTariffParmVO.setDelRgnCd(zDelRgnCd);
		basicTariffParmVO.setDelSteCd(zDelStateCd);
		basicTariffParmVO.setDelLocCd(zDelLoc);
		zDttCode	= "DTOC";
		basicTariffParmVO.setDmdtTrfCd(zDttCode);
		basicTariffParmVO.setEffDt(prmEfftDt);
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd("O");
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		if( DMTCalculationUtil.nullToString(zDttCode, 4).substring(2,3).equals("I")){
			zDmdtDeTermCd	= dtocFreeTimeVO.getDeTermCd();
		} else {
			zDmdtDeTermCd	= dtocFreeTimeVO.getRcvTermCd();
		}
		
		basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
		
		BasicTariffKeyVO basicTariffKeyVO = searchBasicTariffByGeneration(basicTariffParmVO);
		
		zSvrId  		= nullToString(basicTariffKeyVO.getSvrId());		
		zDttCode		= nullToString(basicTariffKeyVO.getDmdtTrfCd());
		zDtnSeq 		= stringToLong(basicTariffKeyVO.getTrfSeq());
		zDmdtDeTermCd	= nullToString(basicTariffKeyVO.getDmdtDeTermCd());
		zDtgGrpId		= stringToLong(basicTariffKeyVO.getTrfGrpSeq());
		
		dtgCmncTp		= nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
		dtgCmncHr		= nullToString(basicTariffKeyVO.getCmncHr());
		dtgExclSat		= nullToString(basicTariffKeyVO.getXcldSatFlg());
		dtgExclSun		= nullToString(basicTariffKeyVO.getXcldSunFlg());
		dtgExclHoli		= nullToString(basicTariffKeyVO.getXcldHolFlg());
		zCurCd			= nullToString(basicTariffKeyVO.getCurrCd());

		log.debug("****************************************************");
		log.debug("[searchBasicTariffByGeneration]");
		log.debug("[BasicTariffKeyVO] zDtnSeq 		:"+ zDtnSeq);
		log.debug("[BasicTariffKeyVO] zDmdtDeTermCd	:"+ zDmdtDeTermCd);
		log.debug("[BasicTariffKeyVO] zDtgGrpId 	:"+ zDtgGrpId);
		log.debug("dtgCmncTp dtgCmncHr dtgExclSat dtgExclSun dtgExclHoli"+dtgCmncTp+dtgCmncHr+dtgExclSat+dtgExclSun+dtgExclHoli+"*"+zCurCd+"*"+zDttCode);
		log.debug("****************************************************");		
	
		/*
		[logic] DTOC - F/Time
		*/
		zDcFtDays = 0;
		zDcFtDays = basicFreeTime(zSvrId, "DTOC", zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);
		log.debug("*******************************************************");
		log.debug("* [DTOC - F/Time] zDcFtDays :"+zDcFtDays);
		log.debug("*******************************************************");
		
//		return zDcFtDays;

		log.debug("*******************************************************");
		log.debug("* Exception 시작 ");
		log.debug("*******************************************************");
		/***********************************************************************
		 * Commodity Exception
		 ***********************************************************************/
		if( zCmdtCd.length() != 0 ) {

			CommodityExceptionParmVO 	commodityExceptionParmVO 	= new CommodityExceptionParmVO();
			            
			long   dcrAddDay		= 0;                                                
			long   dcrTtlDay		= 0; 
			
			commodityExceptionParmVO.setSvrId(zSvrId);
			commodityExceptionParmVO.setDttCode(zDttCode);
			commodityExceptionParmVO.setDtnSeq(String.valueOf(zDtnSeq));
			commodityExceptionParmVO.setCmdtCd(zCmdtCd);
			commodityExceptionParmVO.setEfftDt(prmEfftDt);
			DmtCmdtGrpVO dmtCmdtGrpVO = null;
			try {
				dmtCmdtGrpVO = dmtCalculationUtil.searchCommodityExceptionByGeneration(commodityExceptionParmVO);
				log.debug("* [dmtCmdtGrpVO]"+dmtCmdtGrpVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* CMDT searchCommodityExceptionByGeneration Functon Error -"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* CMDT searchCommodityExceptionByGeneration Functon Error - " + new ErrorHandler(e).getMessage());
			}
			if( DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getDcrSeq()) != 0 ){
				/* Commodity Key */
				dcrAddDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getAddDay());
				dcrTtlDay 	= DMTCalculationUtil.stringToLong(dmtCmdtGrpVO.getTtlDay());

				log.debug("*******************************************************");
				log.debug("* [searchCommodityExceptionByGeneration]");
				log.debug("* [DmtCmdtGrpVO(return)] dcrAddDay 	:"+dcrAddDay);
				log.debug("* [DmtCmdtGrpVO(return)] dcrTtlDay 	:"+dcrTtlDay);
				log.debug("*******************************************************");
				
				if( dcrAddDay != 0 ) {
					zDcFtDays += dcrAddDay;
				} 
				else {		// end of the if clause :dcrAddDay != 0
					zDcFtDays = dcrTtlDay;
				}
			}
		} // Commodity Exception End 
		
		/***********************************************************************
		 * SC Exception
		 ***********************************************************************/

		/*
		[logic] Get USC Exception Values
				1.SC 만 존재 할경우 SC로직만 처리
				2.RFA 만 존재 할경우 RFA로직만 처리
				3.SC/RFA 둘다 존재 할경우 순차적으로 SC를 처리 후 RFA로 처리. 
				  RFA 값이 없을 경우 SC / RFA 값이 존재 할 경우는 RFA 로직이 최종으로 반영됨. 
		*/
		zBrhScNo = zScNo;
		zBrhRfaNo = zRfaNo;
		if(zBrhScNo.length() != 0  && zBrhRfaNo.length() == 0) { 
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get USC Exception Values 					 ");
			log.debug("*******************************************************");
			
			List<ActCustInfoVO> custList = null;

			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList 		= dbDao.getCustInfo(zBkgNo);
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* SC getCustInfo Functon Error ( DMTCalculationUtil ) -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* SC getCustInfo Functon Error ( DMTCalculationUtil ) - " + new ErrorHandler(e).getMessage());
			}
			
			
			log.debug("*******************************************************");
			log.debug("* [logic]  Get SC Exception No ( DMTCalculationUtil )  ");
			log.debug("*******************************************************");

			SCExceptionParmVO 			scExceptionParmVO 			= new SCExceptionParmVO();
			
			scExceptionParmVO.setPorContiCd(zPorContiCd);
			scExceptionParmVO.setPorCntCd(zPorCntCd);
			scExceptionParmVO.setPorRgnCd(zPorRgnCd);
			scExceptionParmVO.setPorSteCd(zPorStateCd);
			scExceptionParmVO.setPorLocCd(zPorLoc);
			
			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setYrdContiCd(zYrdContiCd);
			scExceptionParmVO.setYrdCntCd(zYrdCntCd);
			scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			scExceptionParmVO.setYrdSteCd(zYrdStateCd);
			scExceptionParmVO.setYrdLocCd(zYrdLoc);

			scExceptionParmVO.setDelContiCd(zDelContiCd);
			scExceptionParmVO.setDelCntCd(zDelCntCd);
			scExceptionParmVO.setDelRgnCd(zDelRgnCd);
			scExceptionParmVO.setDelSteCd(zDelStateCd);
			scExceptionParmVO.setDelLocCd(zDelLoc);
			
			scExceptionParmVO.setScNo(zBrhScNo);
			scExceptionParmVO.setDttCode(zDttCode);
			scExceptionParmVO.setIoBndCd("O");
			scExceptionParmVO.setCntrTp(zDcsCntrTp);
			scExceptionParmVO.setCgoTp(zDcsCgoTp);
			scExceptionParmVO.setEfftDt(prmEfftDt.trim());

			scExceptionParmVO.setCmdtCd(zCmdtCd);
			scExceptionParmVO.setRepCmdtCd(zRepCmdtCd);
			scExceptionParmVO.setActCustCntCd(actCustCntCd); 				//추가 2009.12.28
			scExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));	//추가 2009.12.28
			
			scExceptionParmVO.setBbRcvTermCd(zBbRcvTermCd);
			scExceptionParmVO.setBbDeTermCd(zBbDeTermCd);

			scExceptionParmVO.setBkgNo(zBkgNo);
			
			DmtSCGrpVO dmtSCGrpVO = null;
			try {
				dmtSCGrpVO = dmtCalculationUtil.searchSCExceptionByGeneration(scExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* searchSCExceptionByGeneration Functon Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchSCExceptionByGeneration Functon Error :" + new ErrorHandler(e).getMessage());
			}
			
			if(!DMTCalculationUtil.nullToString(dmtSCGrpVO.getPropNo()).equals("")){	
				
				dsdFtimeMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtimeMk());
				dsdFtAddDay		=	DMTCalculationUtil.stringToLong(dmtSCGrpVO.getFtAddDay()); 
				dsdFtAddMk		=	DMTCalculationUtil.nullToString(dmtSCGrpVO.getFtAddMk()); 

				log.debug("*******************************************************");
				log.debug("[searchSCExceptionByGeneration]");
				log.debug("[ USC No (DmtSCGrpVO)] zBrhScNo 		:"+zBrhScNo);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtimeMk 	:"+dsdFtimeMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtAddMk 	:"+dsdFtAddMk);
				log.debug("[ USC EXP  (DmtSCGrpVO)] dsdFtAddDay :"+dsdFtAddDay);
				log.debug("*******************************************************");
				
				/* SCE Key */
				zScNo = zBrhScNo;
				
				if( dsdFtimeMk.equals("Y")){
					if( dsdFtAddDay != 0 && dsdFtAddMk.equals("Y")){
						zDcFtDays += dsdFtAddDay;

						log.debug("[logic] zDcFtDays += dsdFtAddDay;"+zDcFtDays);
					} 
					else if( dsdFtAddDay != 0  && dsdFtAddMk.equals("N")){
						zDcFtDays = 0;
						zDcFtDays = dsdFtAddDay;
						log.debug("[logic] zDcFtDays = dsdFtAddDay;"+zDcFtDays);

					} 
				} 
			}
		 }  /*_________ SC Exception End	*/
		
		/***********************************************************************
		 * RFA Exception
		 ***********************************************************************/
		if(  zBrhRfaNo.length() != 0){  
			log.debug("*******************************************************");
			log.debug("* [logic]  Get BFR Exception Values ");
			log.debug("*******************************************************");

			BFRExceptionParmVO 			bfrExceptionParmVO 			= new BFRExceptionParmVO();
			List<ActCustInfoVO> custList = null;

			actCustCntCd  	= "";	
			actCustSeq     	= 0;   
			try {
				custList 		= dbDao.getCustInfo(zBkgNo);
				if (custList!=null && custList.size()>0){
					ActCustInfoVO tmp = custList.get(0);
					if (tmp!=null){
						actCustCntCd 	= DMTCalculationUtil.nullToString(tmp.getActCustCntCd());
						actCustSeq 		= DMTCalculationUtil.stringToLong(tmp.getActCustSeq());
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* BFR getCustInfo Functon Error -"+ e.getMessage());
				log.error("*******************************************************");
				throw new EventException("BFR getCustInfo Functon Error - " + new ErrorHandler(e).getMessage());
			}
			
			bfrExceptionParmVO.setPorContiCd(zPorContiCd);
			bfrExceptionParmVO.setPorCntCd(zPorCntCd);
			bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
			bfrExceptionParmVO.setPorSteCd(zPorStateCd);
			bfrExceptionParmVO.setPorLocCd(zPorLoc);
			
			bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
			bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
			bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);  
			bfrExceptionParmVO.setPolSteCd(zPolStateCd);
			bfrExceptionParmVO.setPolLocCd(zPolLoc);      

			bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
			bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
			bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
			bfrExceptionParmVO.setYrdLocCd(zYrdLoc);

			bfrExceptionParmVO.setDelContiCd(zDelContiCd);                    
			bfrExceptionParmVO.setDelCntCd(zDelCntCd);                
			bfrExceptionParmVO.setDelRgnCd(zDelRgnCd); 
			bfrExceptionParmVO.setDelSteCd(zDelStateCd);
			bfrExceptionParmVO.setDelLocCd(zDelLoc);                   
			
			bfrExceptionParmVO.setDmdtTrfCd(zDttCode);                         
			bfrExceptionParmVO.setScNo(zBrhScNo);                   
			bfrExceptionParmVO.setRfaNo(zBrhRfaNo);                 
			bfrExceptionParmVO.setCntrTp(zDcsCntrTp);               
			bfrExceptionParmVO.setCgoTp(zDcsCgoTp);                 
			bfrExceptionParmVO.setIoBndCd("O");                 
			bfrExceptionParmVO.setEfftDt(prmEfftDt.trim()); //2010.04.05.         
			bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
			bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			bfrExceptionParmVO.setAwkInOut(awkInOut);
			
			DmtBFRGrpVO dmtBFRGrpVO = null;
			try {
				dmtBFRGrpVO = dmtCalculationUtil.searchBFRExceptionByGeneration(bfrExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("BFR searchBFRExceptionByGeneration Function Error :  ");
				log.error("*******************************************************");
				throw new EventException("BFR searchBFRExceptionByGeneration Function Error : " + new ErrorHandler(e).getMessage());
			}
			if(!DMTCalculationUtil.nullToString(dmtBFRGrpVO.getApprNo()).equals("")){
				
				dbdFtimeMk		= DMTCalculationUtil.nullToString(dmtBFRGrpVO.getFtimeMk());
				dbdAddDay   	= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getAddDay());
				dbdTtlDay		= DMTCalculationUtil.stringToLong(dmtBFRGrpVO.getTtlDay());
				
				log.debug("*******************************************************");
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdFtimeMk 	:"+dbdFtimeMk);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdAddDay 	:"+dbdAddDay);
				log.debug("* BFR EXP (DmtBFRGrpVO)] dbdTtlDay 	:"+dbdTtlDay);
				log.debug("*******************************************************");
				
				if( dbdFtimeMk.equals("Y") ){
					if( dbdAddDay != 0 ){
						zDcFtDays += dbdAddDay;
						
						log.debug("[logic] zDcFtDays += dbdAddDay;"+zDcFtDays);
						
					} 
					else { 		
						zDcFtDays = dbdTtlDay;
						log.debug("[logic] zDcFtDays = dbdTtlDay"+zDcFtDays);
					}
				}
			} 
		}  /*_________ RFA(BFR) Exception End	*/

		log.debug("*******************************************************");
		log.debug("* Exception END ");
		log.debug("*******************************************************");
		return zDcFtDays;		
	}




	/**
	 *  searchFreeTimeStart 대한 해당 데이터를 조회한다.
	 * 
	 * @param FreeTimeStartParmVO freeTimeStartParmVO
	 * @return FreeTimeVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FreeTimeVO searchFreeTimeStart(FreeTimeStartParmVO freeTimeStartParmVO) throws EventException, DAOException {
		FreeTimeVO freeTimeVO = new FreeTimeVO();
		
		String	prmFromDt		= nullToString(freeTimeStartParmVO.getFromDt());
		
		String	prmBkgCntCd		= nullToString(freeTimeStartParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(freeTimeStartParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(freeTimeStartParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(freeTimeStartParmVO.getBkgLocCd());
		
		String	prmYrdCntCd		= nullToString(freeTimeStartParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(freeTimeStartParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(freeTimeStartParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(freeTimeStartParmVO.getYrdLocCd());
		
		String	prmDttCode		= nullToString(freeTimeStartParmVO.getDttCode(), 4);
		String	prmOfcCd		= nullToString(freeTimeStartParmVO.getOfcCd());
		String	prmExclSat		= nullToString(freeTimeStartParmVO.getExclSat());
		String	prmExclSun		= nullToString(freeTimeStartParmVO.getExclSun());
		String	prmExclHoli		= nullToString(freeTimeStartParmVO.getExclHoli());
		String 	prmCmncTp		= nullToString(freeTimeStartParmVO.getCmncTp());
		String 	prmCmncHr	 	= nullToString(freeTimeStartParmVO.getCmncHr());
		
		String  prmSvrId 		= nullToString(freeTimeStartParmVO.getSvrId());
		long	ioIdxCstop		= stringToLong(freeTimeStartParmVO.getCstopIdx());
		
		String 	prmYardCd	 	= nullToString(freeTimeStartParmVO.getYardCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
		// 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		String 	prmIoBndCd	 	= nullToString(freeTimeStartParmVO.getIoBndCd());
		String  prmBkgDeTermCd  = nullToString(freeTimeStartParmVO.getBkgDeTermCd());
		String  prmBkgRcvTermCd = nullToString(freeTimeStartParmVO.getBkgRcvTermCd());
		//2012.06.26  S/C exception 인 경우는 Sat/Sun/Holi "Y" 인 경우 계산 제외시킴.
		String	prmExpType = nullToString(freeTimeStartParmVO.getExpType());
		
		List<String> cstopNoList= freeTimeStartParmVO.getCStopNoList();

		log.debug("*******************************************************");
		log.debug("* [searchFreeTimeStart(param)] prmYardCd    :"+prmYardCd);
		log.debug("* [searchFreeTimeStart(param)] prmFromDt    :"+prmFromDt);
		log.debug("* [searchFreeTimeStart(param)] prmCmncTp    :"+prmCmncTp);
		log.debug("* [searchFreeTimeStart(param)] cstopNoList  :"+cstopNoList);
		log.debug("*******************************************************");
		log.debug("* [searchFreeTimeStart(param)] prmIoBndCd  :"+prmIoBndCd);
		log.debug("* [searchFreeTimeStart(param)] prmBkgDeTermCd  :"+prmBkgDeTermCd);
		log.debug("* [searchFreeTimeStart(param)] prmBkgRcvTermCd  :"+prmBkgRcvTermCd);
		log.debug("* [searchFreeTimeStart(param)] prmExpType 	:"+prmExpType);
		log.debug("* [searchFreeTimeStart(param)] prmExclSat 	:"+prmExclSat);
		log.debug("* [searchFreeTimeStart(param)] prmExclSun 	:"+prmExclSun);
		log.debug("* [searchFreeTimeStart(param)] prmExclHoli :"+prmExclHoli);
		log.debug("*******************************************************");
		
		String rtnFtimeCmnc	= "";
		String tmpCstopNo	= "";
		String ddhDate		= "";
		String weekOfDay	= "";
		String cntCd 		= "";
		String rgnCd 		= "";
		String stateCd 		= "";
		String locCd 		= "";
		String existYN		= "";
		
		String termCd       = "";
		
        if (prmIoBndCd.equals("O")){
		      termCd = prmBkgRcvTermCd;
		}else{
		   	  termCd = prmBkgDeTermCd;
		}
		
		
		if(prmCmncTp.equals("1")){
			/* Movement Date --- */
					;
		} else if(prmCmncTp.equals("2")){
			/* Next Day -------- */
			try {
				prmFromDt = nullToString(dbDao.getNextDay(prmFromDt));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getNextDay Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getNextDay Select Error ! : " + new ErrorHandler(e).getMessage());
			}
		} else if(prmCmncTp.equals("3")){
			/* Interchage HR --- */
			try {
				prmFromDt = nullToString(dbDao.getInterchangeHR(prmFromDt, prmCmncHr));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getInterchangeHR Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getInterchangeHR Select Error ! : " + new ErrorHandler(e).getMessage());
			}
		} else {
			freeTimeVO.setMsgCd("-1");
			return freeTimeVO;
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeStart] prmFromDt :"+ prmFromDt);
		log.debug("****************************************************");
		
		/* ----------------------------Holiday Loc Setting */
		if( prmDttCode.substring(0, 2).equals("DM") ||
			( prmSvrId.equals("USA") && prmDttCode.substring(0, 4).equals("DTIC"))){
			cntCd 		= 	prmYrdCntCd;
			rgnCd 		= 	prmYrdRgnCd;
			stateCd 	= 	prmYrdStateCd;
			locCd 		= 	prmYrdLocCd;
		} else {	
			cntCd 		= 	prmBkgCntCd;
			rgnCd 		= 	prmBkgRgnCd;
			stateCd 	= 	prmBkgStateCd;
			locCd 		= 	prmBkgLocCd;
		}

		
		/* ----------------------------- Initial Date Setting */

		List<FreeTimeVO> mapPrev = null;
		/* Previous Day -------- */
		try {
			mapPrev 		= dbDao.getPrevDay(prmFromDt);
			if (mapPrev != null && mapPrev.size() > 0) {
				log.debug("\n\n @@@@@ dbDao.getPrevDay size>0 - "+(mapPrev!=null?mapPrev.size():0)+" @@@@@@@@@@@@@ \n\n");
				/** 사실상 1개의 VO만 나온다. - LIST말고 VO만 return하거나, FOR문으로 LOOP를 돌지 않는다. **/
				FreeTimeVO tmp = mapPrev.get(0);
				log.debug("\n\n @@@@@ dbDao.getPrevDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
				if (tmp!=null){
					log.debug("\n\n @@@@@ dbDao.getPrevDay : WeekOfDaY:"+tmp.getWeekOfDay()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
					weekOfDay 		= nullToString(tmp.getWeekOfDay());
					rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());
				}
			}
			else {log.debug("\n\n @@@@@ dbDao.getPrevDay size=0 @@@@@@@@@@@@@ \n\n");}			
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("getPrevDay Select Error !  ");
			log.error("*******************************************************");
			throw new EventException("getPrevDay Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeStart :getPrevDay] weekOfDay 		: ["+ weekOfDay +"]");
		log.debug("[searchFreeTimeStart :getPrevDay] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
		log.debug("****************************************************");

		for(  ;  ; 	)
		{
			List<FreeTimeVO> mapPlus = null;
//			Map<String, String> mapPlus = new HashMap<String, String>();
			/* Plus Day -------- */
			try {
				mapPlus 		= dbDao.getPlusDay(rtnFtimeCmnc);
//				weekOfDay 		= nullToString(mapPlus.get("week_of_day"));
//				rtnFtimeCmnc 	= nullToString(mapPlus.get("rtn_ftime_cmnc"));
				if (mapPlus != null && mapPlus.size() > 0) {
					/** 사실상 1개의 VO만 나온다. - LIST말고 VO만 return하거나, FOR문으로 LOOP를 돌지 않는다. **/
					FreeTimeVO tmp = mapPlus.get(0);
					log.debug("\n\n @@@@@ dbDao.getPlusDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						log.debug("\n\n @@@@@ dbDao.getPlusDay : WeekOfDaY:"+tmp.getWeekOfDay()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
						weekOfDay 		= nullToString(tmp.getWeekOfDay());
						rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());				
					}
				}
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("[Exception]>> DEM/DET Office Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			log.debug("****************************************************");
			log.debug("[getPlusDay ] weekOfDay 		: ["+ weekOfDay +"]");
			log.debug("[getPlusDay ] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
			log.debug("****************************************************");

			tmpCstopNo = "";
//			Map<String, String> mapTCStop = new HashMap<String, String>();
			List<FreeTimeVO> mapTCStop = null;
			/* getTimeClockStopToDt -------- */
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt(param) ]  prmDttCode 	: ["+ prmDttCode +"]");
			log.debug("[getTimeClockStopToDt(param) ]  prmOfcCd 	: ["+ prmOfcCd +"]");
			log.debug("[getTimeClockStopToDt(param) ]  rtnFtimeCmnc : ["+ rtnFtimeCmnc +"]");
			log.debug("[getTimeClockStopToDt(param) ]  prmYardCd    : ["+ prmYardCd +"]");
			log.debug("****************************************************");
			try {
				mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, rtnFtimeCmnc, prmYardCd, termCd );

//				if(!nullToString(mapTCStop.get("tmp_cstop_no")).equals("")){
//					tmpCstopNo 		= mapTCStop.get("tmp_cstop_no");
//					rtnFtimeCmnc 	= mapTCStop.get("rtn_ftime_cmnc");
//				}
				if (mapTCStop != null && mapTCStop.size() > 0) {
					FreeTimeVO tmp = mapTCStop.get(0);
					log.debug("\n\n @@@@@ dbDao.getTimeClockStopToDt : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						log.debug("\n\n @@@@@ dbDao.getTimeClockStopToDt : CstopNo:"+tmp.getCstopNo()+" / RtnFtimeCmnc:"+tmp.getRtnFtimeCmnc()+" @@@@@@@@@@@@@ \n\n");
						if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
							tmpCstopNo 		= nullToString(tmp.getCstopNo());
							rtnFtimeCmnc 	= nullToString(tmp.getRtnFtimeCmnc());
						}
					}
				}				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getTimeClockStopToDt Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("getTimeClockStopToDt Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			log.debug("****************************************************");
			log.debug("[getTimeClockStopToDt ]  tmpCstopNo 		: ["+ tmpCstopNo +"]");
			log.debug("[getTimeClockStopToDt ]  rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
			log.debug("****************************************************");
			

			if( !tmpCstopNo.equals("") ){
				ioIdxCstop = ioIdxCstop + 1;
				cstopNoList.add(tmpCstopNo);
				
				log.debug("****************************************************");
				log.debug("[ioIdxCstop ] ioIdxCstop :["+ ioIdxCstop +"]");
				log.debug("[tmpCstopNo ] tmpCstopNo :["+ tmpCstopNo +"]");
				if(cstopNoList.size() > 0){	
					for(int i = 0; i < cstopNoList.size(); i++){
						log.debug("[cstopNoList.get("+i+")]"+cstopNoList.get(i));
					}
				}
				log.debug("****************************************************");
				
				continue;
			}
			
		    //2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
			//  From Movement YardCode가 "USOAK" 또는 "USSFO"이고, YardTerm 이면서, 
			//  DetentionCharge인 경우 제외 처리할수 있도록 하기 위해 추가함.
			
					CheckWeekEndParmVO  checkWeekEndParmVO = new CheckWeekEndParmVO();
				
					checkWeekEndParmVO.setCntCd(cntCd);
					checkWeekEndParmVO.setWeekOfDay(weekOfDay);
					checkWeekEndParmVO.setExclSat(prmExclSat);
					checkWeekEndParmVO.setExclSun(prmExclSun);
					checkWeekEndParmVO.setLocCd(prmYrdLocCd);
					checkWeekEndParmVO.setTermCd(termCd);
					checkWeekEndParmVO.setTrfCd(prmDttCode);
					checkWeekEndParmVO.setExpType(prmExpType);
					//checkWeekEndParmVO.setLocCd("X");
			     //2012.04.13 김현화 [CHM-201217180-01]Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산시 제외 로직 제거.LocCd 'X'일때 적용 되지 않도록 SQL 처리.
				 //2012.04.23 김현화 []Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산로직 다시 복구.(HJS 장병용부장님 요청)
			existYN = nullToString(dbDao.checkWeekEnd(checkWeekEndParmVO));	
					
			log.debug("****************************************************");
			log.debug("[checkWeekEnd ] existYN : ["+ existYN +"]");
			log.debug("****************************************************");
			if(existYN.equals("Y")){
				continue;
			}
			
			/* getHolidayToDt -------- */
			try {
				ddhDate = nullToString(dbDao.getHolidayToDt(rtnFtimeCmnc, cntCd, rgnCd, stateCd, locCd));
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getHolidayToDt Select Error !  ");
				log.error("*******************************************************");
				throw new EventException("getHolidayToDt Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			log.debug("****************************************************");
			log.debug("[getHolidayToDt ] ddhDate 		: ["+ ddhDate +"]");
			log.debug("[getHolidayToDt ] prmExclHoli 	: ["+ prmExclHoli +"]");
			log.debug("****************************************************");
//2012.04.23김현화 []Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산로직 다시 복구.				
//			if( !ddhDate.equals("") && prmExclHoli.equals("Y")){
//				continue;
//			}
//2012.04.13 김현화 [CHM-201217180-01]Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산시 제외 로직 제거.		
//			//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완 
// 2012.06.26	S/C exception 인 경우는 Sat/Sun/Holi "Y" 인 경우 계산 제외시킴.	
// 2012.07.03  'USLGB', 'USLAX', 'USGAC' 추가.			
			if( !ddhDate.equals("") && prmExclHoli.equals("Y") ){
				    continue;
			} else if( !ddhDate.equals("") 
					      && (prmYrdLocCd.equals("USSFO") || prmYrdLocCd.equals("USOAK")|| prmYrdLocCd.equals("USLGB")|| prmYrdLocCd.equals("USLAX")|| prmYrdLocCd.equals("USGAC")) 
				          && termCd.equals("Y") && prmDttCode.substring(1, 2).equals("T")) {
				
		         if( "SC".equals(prmExpType)){ 
		        	 if (prmExclHoli.equals("Y")){
					      continue;  }
		         }else{
	              continue;
		         }
			}
			 	
			
			break ;

		}/* end of the for loop*/
		
		log.debug("****************************************************");
		log.debug("[return:searchFreeTimeStart ] rtnFtimeCmnc 	: ["+ rtnFtimeCmnc +"]");
		log.debug("[return:searchFreeTimeStart ] ioIdxCstop 	: ["+ ioIdxCstop +"]");
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[[return:searchFreeTimeStart ]>>cstopNoList.get("+i+")]"+cstopNoList.get(i));
			}
		}
		log.debug("****************************************************");
		
		freeTimeVO.setFtimeCmnc(rtnFtimeCmnc);
		freeTimeVO.setCstopIdx(String.valueOf(ioIdxCstop));
		freeTimeVO.setCStopNoList(cstopNoList);
		return freeTimeVO;
	}


	/**
	 * searchFreeTimeEnd 대한 해당 데이터를 조회한다.
	 * 
	 * @param FreeTimeEndParmVO freeTimeEndParmVO
	 * @return FreeTimeVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public FreeTimeVO searchFreeTimeEnd(FreeTimeEndParmVO freeTimeEndParmVO) throws EventException, DAOException {
		FreeTimeVO freeTimeVO = new FreeTimeVO();
				
		String	prmFromDt		= nullToString(freeTimeEndParmVO.getFromDt());
		
		String	prmBkgCntCd		= nullToString(freeTimeEndParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(freeTimeEndParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(freeTimeEndParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(freeTimeEndParmVO.getBkgLocCd());
		
		String	prmYrdCntCd		= nullToString(freeTimeEndParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(freeTimeEndParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(freeTimeEndParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(freeTimeEndParmVO.getYrdLocCd());
		
		String	prmDttCode		= nullToString(freeTimeEndParmVO.getDttCode(), 4);
		String	prmOfcCd		= nullToString(freeTimeEndParmVO.getOfcCd());
		String	prmExclSat		= nullToString(freeTimeEndParmVO.getExclSat());
		String	prmExclSun		= nullToString(freeTimeEndParmVO.getExclSun());
		String	prmExclHoli		= nullToString(freeTimeEndParmVO.getExclHoli());
		long	prmFreeTime		= stringToLong(freeTimeEndParmVO.getFreeTime());
		
		String	prmSvrId		= nullToString(freeTimeEndParmVO.getSvrId());
		

		long	ioIdxCstop		= stringToLong(freeTimeEndParmVO.getCstopIdx());
		List<String> cstopNoList = freeTimeEndParmVO.getCStopNoList();
		
		String prmYardCd		= nullToString(freeTimeEndParmVO.getYardCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
		// 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		String 	prmIoBndCd	 	= nullToString(freeTimeEndParmVO.getIoBndCd());
		String  prmBkgDeTermCd  = nullToString(freeTimeEndParmVO.getBkgDeTermCd());
		String  prmBkgRcvTermCd = nullToString(freeTimeEndParmVO.getBkgRcvTermCd());
		//2012.06.26  S/C exception 인 경우는 Sat/Sun/Holi "Y" 인 경우 계산 제외시킴.
		String	prmExpType = nullToString(freeTimeEndParmVO.getExpType());


		log.debug("*******************************************************");
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmFromDt      :"+prmFromDt);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] cstopNoList    :"+cstopNoList);
		log.debug("*******************************************************");
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmIoBndCd      :"+prmIoBndCd);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmBkgDeTermCd  :"+prmBkgDeTermCd);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmBkgRcvTermCd :"+prmBkgRcvTermCd);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmExpType      :"+prmExpType);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmExclSat      :"+prmExclSat);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmExclSun      :"+prmExclSun);
		log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd(param)] prmExclHoli     :"+prmExclHoli);
		log.debug("*******************************************************");
		
		String	rtnFtimeEnd		= "";
		String	tmpCstopNo		= "";
		
		String	ddhDate			= "";
		String	weekOfDay		= "";
		long	ii				= 0;
		String	cntCd			= "";
		String	rgnCd			= "";
		String	stateCd			= "";
		String	locCd			= "";
		String existYN 			= "";
		
	    String termCd       = "";
       if (prmIoBndCd.equals("O")){
		      termCd = prmBkgRcvTermCd;
		}else{
		   	  termCd = prmBkgDeTermCd;
		}
		
		/* ---------------------------------------------------- */
		if(	prmDttCode.substring(0, 2).equals("DM") || ( prmSvrId.equals("USA") 
			&&  prmDttCode.substring(0, 4).equals("DTIC") )){
			cntCd 		= 	prmYrdCntCd;
			rgnCd 		= 	prmYrdRgnCd;
			stateCd 	= 	prmYrdStateCd;
			locCd 		= 	prmYrdLocCd;
		} else {
			cntCd 		= 	prmBkgCntCd;
			rgnCd 		= 	prmBkgRgnCd;
			stateCd 	= 	prmBkgStateCd;
			locCd 		= 	prmBkgLocCd;
		}
		
		/* -------------------------------------------------------- */
		rtnFtimeEnd = prmFromDt;
		List<FreeTimeVO> mapPrev = null;
		
		/* Previous Day -------- */
		mapPrev = dbDao.getPrevDay(rtnFtimeEnd);

		if (mapPrev != null && mapPrev.size() > 0) {
			/** 사실상 1개의 VO만 나온다. - LIST말고 VO만 return하거나, FOR문으로 LOOP를 돌지 않는다. **/
			FreeTimeVO tmp = mapPrev.get(0);
			if (tmp!=null){
				rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
			}
		}
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeEnd][searchFreeTimeEnd :getPrevDay] rtnFtimeEnd  : ["+ rtnFtimeEnd +"]");
		log.debug("****************************************************");
		log.debug("[searchFreeTimeEnd][searchFreeTimeEnd :prmFreeTime] prmFreeTime : ["+ prmFreeTime +"]");
		log.debug("****************************************************");
		
		for( ii = 1; ii <= prmFreeTime ; ii++ )
		{
			List<FreeTimeVO> mapPlus = null;
			/* Plus Day -------- */
			mapPlus 		= dbDao.getPlusDay(rtnFtimeEnd);
			if (mapPlus != null && mapPlus.size() > 0) {
				/** 사실상 1개의 VO만 나온다. - LIST말고 VO만 return하거나, FOR문으로 LOOP를 돌지 않는다. **/
				FreeTimeVO tmp = mapPlus.get(0);
				if (tmp!=null){
					weekOfDay 		= nullToString(tmp.getWeekOfDay());
					rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
				}
			}
			
			log.debug("*******************************************************");
			log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd:getPlusDay] weekOfDay  ["+ii+"]  :"+weekOfDay);
			log.debug("*[searchFreeTimeEnd] [searchFreeTimeEnd:getPlusDay] rtnFtimeEnd["+ii+"] :"+rtnFtimeEnd);
			log.debug("*******************************************************");
			
			tmpCstopNo = "";
			List<FreeTimeVO> mapTCStop = null;
			/* getTimeClockStopToDt -------- */
			log.debug("****************************************************");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt (param)]  prmDttCode    : ["+ prmDttCode +"]");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt (param)]  prmOfcCd      : ["+ prmOfcCd +"]");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt (param)]  rtnFtimeEnd   : ["+ rtnFtimeEnd +"]");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt (param)]  prmYardCd     : ["+ prmYardCd +"]");
			log.debug("****************************************************");
			mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, rtnFtimeEnd, prmYardCd, termCd);
			
			if (mapTCStop != null && mapTCStop.size() > 0) {
				FreeTimeVO tmp = mapTCStop.get(0);
				if (tmp!=null){
					if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
						tmpCstopNo 		= nullToString(tmp.getCstopNo());
						rtnFtimeEnd 	= nullToString(tmp.getRtnFtimeCmnc());
					}
				}
			}
			log.debug("****************************************************");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt ] tmpCstopNo  : ["+ tmpCstopNo +"]");
			log.debug("[searchFreeTimeEnd][getTimeClockStopToDt ] rtnFtimeEnd : ["+ rtnFtimeEnd +"]");
			log.debug("****************************************************");
			
			if( !tmpCstopNo.equals("") ){
				ioIdxCstop = ioIdxCstop + 1;
				cstopNoList.add(tmpCstopNo);
				
				log.debug("****************************************************");
				log.debug("[searchFreeTimeEnd][ioIdxCstop ] ioIdxCstop : ["+ ioIdxCstop +"]");
				log.debug("[searchFreeTimeEnd][tmpCstopNo ] tmpCstopNo : ["+ tmpCstopNo +"]");
				if(cstopNoList.size() > 0){
					for(int i = 0; i < cstopNoList.size(); i++){
						log.debug("[searchFreeTimeEnd][cstopNoList.get("+i+")]"+cstopNoList.get(i));
					}
				}
				log.debug("****************************************************");
				
				ii = ii - 1;
				continue;
			}
			
		    // 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
			//   From Movement YardCode가 "USOAK" 또는 "USSFO"이고, YardTerm 이면서, 
			//   DetentionCharge인 경우 제외 처리할수 있도록 하기 위해 추가함.    
			CheckWeekEndParmVO  checkWeekEndParmVO = new CheckWeekEndParmVO();
		
			checkWeekEndParmVO.setCntCd(cntCd);
			checkWeekEndParmVO.setWeekOfDay(weekOfDay);
			checkWeekEndParmVO.setExclSat(prmExclSat);
			checkWeekEndParmVO.setExclSun(prmExclSun);
			checkWeekEndParmVO.setLocCd(prmYrdLocCd);
			checkWeekEndParmVO.setTermCd(termCd);
			checkWeekEndParmVO.setTrfCd(prmDttCode);
			checkWeekEndParmVO.setExpType(prmExpType);
			//2012.04.13 김현화 [CHM-201217180-01]Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산시 제외 로직 제거.LocCd 'X'일때 적용 되지 않도록 SQL 처리.
			//2012.04.23 김현화 []Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산로직 다시 복구.(HJS 장병용부장님 요청)			
			existYN = nullToString(dbDao.checkWeekEnd(checkWeekEndParmVO));

			log.debug("****************************************************");
			log.debug("[searchFreeTimeEnd][checkWeekEnd ] existYN : ["+ existYN +"]");
			log.debug("****************************************************");
			
			if(existYN.equals("Y")){
				ii = ii - 1;
				continue;
			}
			
			/* getHolidayToDt -------- */
			ddhDate = nullToString(dbDao.getHolidayToDt(rtnFtimeEnd, cntCd, rgnCd, stateCd, locCd));
			log.debug("****************************************************");
			log.debug("[searchFreeTimeEnd][getHolidayToDt ] ddhDate     : ["+ ddhDate +"]");
			log.debug("[searchFreeTimeEnd][getHolidayToDt ] prmExclHoli : ["+ prmExclHoli +"]");
			log.debug("****************************************************");

		//2012.04.23김현화 []Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산로직 다시 복구.				
		//2012.04.13 김현화 [CHM-201217180-01]Time Clock Stop 관련 보완 - USOAK/USSFO F/T 계산시 제외 로직 제거.	
//		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완			
//			if( !ddhDate.equals("") && prmExclHoli.equals("Y") ){
//				ii = ii - 1;
//				continue;
//			}
			 // 2012.06.26	S/C exception 인 경우는 Sat/Sun/Holi 구분 값을 우선적용하여  계산.	
			 // 2012.07.03  'USLGB', 'USLAX', 'USGAC' 추가.	
		    if( !ddhDate.equals("") && prmExclHoli.equals("Y") ){
				 ii = ii - 1;
			     continue;
			}else if( !ddhDate.equals("") 
					  && (prmYrdLocCd.equals("USSFO") || prmYrdLocCd.equals("USOAK") || prmYrdLocCd.equals("USLGB") || prmYrdLocCd.equals("USLAX") || prmYrdLocCd.equals("USGAC")) 
			          && termCd.equals("Y") && prmDttCode.substring(1, 2).equals("T")) {
				         if( "SC".equals(prmExpType)){ 
				        	 if (prmExclHoli.equals("Y")){
				        	     ii = ii - 1;
							      continue;  }
				         }else{
			              ii = ii - 1;
			              continue;
				         }
			}
		}/* end of the for loop*/
		
		log.debug("****************************************************");
		log.debug("[searchFreeTimeEnd][return:searchFreeTimeEnd ] rtnFtimeEnd : ["+ rtnFtimeEnd +"]");
		log.debug("[searchFreeTimeEnd][return:searchFreeTimeEnd ] ioIdxCstop  : ["+ ioIdxCstop +"]");
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[searchFreeTimeEnd][[return:searchFreeTimeEnd ]cstopNoList.get("+i+")]:"+cstopNoList.get(i));
			}
		}
		
		log.debug("****************************************************");
		
		freeTimeVO.setFtimeEnd(rtnFtimeEnd);
		freeTimeVO.setCstopIdx(String.valueOf(ioIdxCstop));
		freeTimeVO.setCStopNoList(cstopNoList);
		
		return freeTimeVO;
	}

	

	/**
	 * getMTNotify 대한 해당 데이터를 조회한다.
	 * 
	 * @param String zSvrId  
	 * @param String zCntrNo  
	 * @param long zCnmvCycNo   
	 * @param String zDttCode
	 * @param String zDcFmCnms
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String getMTNotify(String zSvrId  , String zCntrNo  , long zCnmvCycNo   , String zDttCode, String zDcFmCnms) throws EventException, DAOException {
		return dbDao.getMTDate(zSvrId  , zCntrNo  , zCnmvCycNo   , zDttCode, zDcFmCnms);
	}



	/**
	 *  overdayNStatus 대한 해당 데이터를 조회한다.
	 * 
	 * @param OverdayNStatusParmVO overdayNStatusParmVO
	 * @return OverdayNStatusVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public OverdayNStatusVO overdayNStatus(OverdayNStatusParmVO overdayNStatusParmVO) throws EventException, DAOException {
		OverdayNStatusVO overdayNStatusVO = new OverdayNStatusVO();
		
		String		prmToDate		= nullToString(overdayNStatusParmVO.getToDate());
		String		prmFtimeEnd		= nullToString(overdayNStatusParmVO.getFtimeEnd());
		String		prmDttCode		= nullToString(overdayNStatusParmVO.getDttCode());
		String		prmOfcCd		= nullToString(overdayNStatusParmVO.getOfcCd());
		String		prmMtDate		= nullToString(overdayNStatusParmVO.getMtDate());
		long		ioIdxCstop		= stringToLong(overdayNStatusParmVO.getCstopIdx());
		List<String> cstopNoList  	= overdayNStatusParmVO.getCStopNoList();
		String      prmYardCd		= nullToString(overdayNStatusParmVO.getYardCd());	//2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가

		//2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		String 	prmIoBndCd	 	= nullToString(overdayNStatusParmVO.getIoBndCd());
		String  prmBkgDeTermCd  = nullToString(overdayNStatusParmVO.getBkgDeTermCd());
		String  prmBkgRcvTermCd = nullToString(overdayNStatusParmVO.getBkgRcvTermCd());
		String	prmBkgCntCd		= nullToString(overdayNStatusParmVO.getBkgCntCd());
		String	prmBkgRgnCd		= nullToString(overdayNStatusParmVO.getBkgRgnCd());
		String	prmBkgStateCd	= nullToString(overdayNStatusParmVO.getBkgStateCd());
		String	prmBkgLocCd		= nullToString(overdayNStatusParmVO.getBkgLocCd());
		String	prmYrdCntCd		= nullToString(overdayNStatusParmVO.getYrdCntCd());
		String	prmYrdRgnCd		= nullToString(overdayNStatusParmVO.getYrdRgnCd());
		String	prmYrdStateCd	= nullToString(overdayNStatusParmVO.getYrdStateCd());
		String	prmYrdLocCd		= nullToString(overdayNStatusParmVO.getYrdLocCd());	
		String	prmSvrId        = nullToString(overdayNStatusParmVO.getSvrId());	
		
		String	prmExptCostFlg = nullToString(overdayNStatusParmVO.getExptCostFlg());
		
		String  prmEndHr        = nullToString(overdayNStatusParmVO.getEndHr());
		// 2015-09-17. 김기태 [CHM-201537972] [DMT] US DTC USLGB, USLAX, USOAK로직 수정 prmToYrdCd 항목 추가
		String  prmToYrdCd  		= nullToString(overdayNStatusParmVO.getToYrdCd()); 
		
		if (!"Y".equals(prmExptCostFlg)){
			prmExptCostFlg = "N";
		}
		
		String	ddhDate		 = "";
		String	weekOfDay	 = "";
		String  overday_st_dt  = "";
		String  existYN 	 = "";
		String	cntCd		 = "";
		String	rgnCd		 = "";
		String	stateCd		 = "";
		String	locCd		 = "";
		
		String termCd = "";
	    if (prmIoBndCd.equals("O")){
		      termCd = prmBkgRcvTermCd;
		}else{
		   	  termCd = prmBkgDeTermCd;
		}
		
		long		rtnOverDay		= 0;
		String		rtnStatus		= "";
		String		tmpCstopNo		= "";
		long		tmpCstopDay		= 0;
		long		tmpCstopTotal	= 0;

		int			unfinishFlag	= 0;
		long		checkNum		= 0;
		long		checkGrace		= 0;
		
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmToDate      :["+prmToDate+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmFtimeEnd    :["+prmFtimeEnd+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmDttCode     :["+prmDttCode+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmOfcCd       :["+prmOfcCd+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmMtDate      :["+prmMtDate+"]; ["+ prmMtDate.length()+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] ioIdxCstop     :["+ioIdxCstop+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] cstopNoList    :["+cstopNoList+"]");
		log.debug("*[overdayNStatus][overdayNStatusParmVO] prmYardCd      :["+prmYardCd+"]");
		
		/* ----------------------------------- Date Fixing */
		if( prmToDate.length() == 0 ){

			List<OverdayNStatusVO> rtnList = null;
			
			//2010.04.13. 지역 시스템 날짜를 조회하기 위해 prmOfcCd 추가
			rtnList = dbDao.getOverdayStatus("", prmFtimeEnd, 0, "1", prmOfcCd);
			
			if (rtnList != null && rtnList.size() > 0) {
				log.debug("[overdayNStatus] dbDao.getOverdayStatus size > 0 : "+(rtnList!=null?rtnList.size():0)+" Rows. @@@@@@@@@@@@@ \n");
				OverdayNStatusVO tmp = rtnList.get(0);
				log.debug("[overdayNStatus] dbDao.getOverdayStatus : OverdayNStatusVO tmp (S) \n "+tmp+"\n (E) @@@@@@@@@@@@@ \n");
				if (tmp!=null){
					prmToDate 		= nullToString(tmp.getPrmToDate());
					prmFtimeEnd 	= nullToString(tmp.getPrmFtimeEnd());
					log.debug("[overdayNStatus] dbDao.getOverdayStatus : PrmToDate ["+tmp.getPrmToDate()+"] / PrmFtimeEnd ["+tmp.getPrmFtimeEnd()+"] @@@@@@@@@@@@@ \n");
				}
			}
			else {log.debug("[overdayNStatus] dbDao.getOverdayStatus size = 0 @@@@@@@@@@@@@ \n");}
			
			unfinishFlag	=	1;

		} else {
			
			if( prmEndHr.length() != 0 ){
				List<OverdayNStatusVO> rtnList1 = null;			
				rtnList1 = dbDao.getOverdayStatus(prmToDate, prmEndHr, 0, "6", "");
				if (rtnList1 != null && rtnList1.size() > 0) {
					OverdayNStatusVO tmp = rtnList1.get(0);
					if (tmp!=null){
						prmToDate 		= nullToString(tmp.getPrmToDate());
					}
				}
			}
			
			List<OverdayNStatusVO> rtnList = null;
			rtnList = dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, 0, "2", "");
			
			if (rtnList != null && rtnList.size() > 0) {
				log.debug("[overdayNStatus] dbDao.getOverdayStatus size > 0 : "+(rtnList!=null?rtnList.size():0)+" Rows. @@@@@@@@@@@@@ \n");
				OverdayNStatusVO tmp = rtnList.get(0);
				log.debug("[overdayNStatus] dbDao.getOverdayStatus : OverdayNStatusVO tmp (S) \n "+tmp+"\n (E) @@@@@@@@@@@@@ \n");
				if (tmp!=null){
					prmToDate 		= nullToString(tmp.getPrmToDate());
					prmFtimeEnd 	= nullToString(tmp.getPrmFtimeEnd());
					log.debug("[overdayNStatus] dbDao.getOverdayStatus : PrmToDate ["+tmp.getPrmToDate()+"] / PrmFtimeEnd ["+tmp.getPrmFtimeEnd()+"] @@@@@@@@@@@@@ \n");
				}
			}
			else {log.debug("[overdayNStatus] dbDao.getOverdayStatus size = 0 @@@@@@@@@@@@@ \n");}
			
			unfinishFlag	=	0;
		}

		//**********************************************************************************************
		//	    2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완
		//	    USOAK 또는 USSFO인 Yard에서는 IB와 OB의 Detention(CTIC/CTOC포함)의 Day 계산에서 SAT/SUN/HOL을 모두 제외
		//      2012.07.03  'USLGB', 'USLAX', 'USGAC' 추가.	
		//      Exception cost 계산시에는 반영 되지 않도록 하기 위해 추가 함. prmExptCostFlg  = "Y" 인 경우는 처리되지 않도록 함.
		// 		2015-09-16. 김기태 [CHM-201537972] DTOC 중, OC가 USLGB, USLAX, USOAK일 경우, SB45 적용을 받을 수 있도록 
		//**********************************************************************************************
		
		log.debug("[overdayNStatus] prmYrdLocCd    : " + prmYrdLocCd);
		log.debug("[overdayNStatus] unfinishFlag   : " + ( unfinishFlag == 1?"(U)Unfinsh":"(F)Finish" ));
		log.debug("[overdayNStatus] termCd         : " + termCd);
		log.debug("[overdayNStatus] prmExptCostFlg : " + prmExptCostFlg);
		log.debug("[overdayNStatus] prmToYrdCd	   : " + prmToYrdCd);
		
		if((
				(prmYrdLocCd.equals("USSFO") || prmYrdLocCd.equals("USOAK")|| prmYrdLocCd.equals("USLGB")|| prmYrdLocCd.equals("USLAX")|| prmYrdLocCd.equals("USGAC") ||
	    		 prmToYrdCd.equals("USSFO")  || prmToYrdCd.equals("USOAK") || prmToYrdCd.equals("USLGB") || prmToYrdCd.equals("USLAX") || prmToYrdCd.equals("USGAC"))
			)  
			&& termCd.equals("Y") && prmDttCode.substring(1, 2).equals("T") 
			&& prmExptCostFlg.equals("N")) {
			
			long ret = 0;
			overday_st_dt =   prmFtimeEnd ;
			long overDay = 0;
			String  prmExclSat = "Y";
			String  prmExclSun = "Y";
			String  prmExclHoli = "Y";
	      
			List<OverdayNStatusVO> checkNumList = null;
			checkNumList = dbDao.getOverdayStatus(prmToDate, overday_st_dt, 0, "3", "");
			
			if (checkNumList != null && checkNumList.size() > 0) {
				OverdayNStatusVO tmp = checkNumList.get(0);
				if (tmp!=null){
					ret = stringToLong(tmp.getCheckNum());
				}
			}	  
		  
			log.debug("[overdayNStatus] overday_st_dt : PrmToDate ["+prmToDate+"] / PrmFtimeEnd ["+prmFtimeEnd+"] @@@@@@@@@@@@@ \n");
			
			if (ret > 0) {
			   for (int k = 0; k < ret; k++) {	   
				   List<FreeTimeVO> mapPlus = null;
				   
				   /* Plus Day -------- */
				   try {
				      mapPlus  = dbDao.getPlusDay(overday_st_dt);
				      if (mapPlus != null && mapPlus.size() > 0) {
				         FreeTimeVO tmp = mapPlus.get(0);
				         log.debug("[overdayNStatus] dbDao.getPlusDay : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n");
				        if (tmp!=null) {
				             log.debug("[overdayNStatus] dbDao.getPlusDay : WeekOfDaY ["+tmp.getWeekOfDay()+"] / overday_st_dt ["+tmp.getRtnFtimeCmnc()+"] @@@@@@@@@@@@@ \n");
				             weekOfDay   = nullToString(tmp.getWeekOfDay());
				             overday_st_dt  = nullToString(tmp.getRtnFtimeCmnc());    
				         }
				     }
				   }
				   catch(Exception e) {
				    log.error("[Exception]>> DEM/DET Office Select Error !  ");
				    throw new EventException("DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage());
				   }
				   
				   log.debug("[overdayNStatus] [getPlusDay] weekOfDay      : ["+ weekOfDay +"]");
				   log.debug("[overdayNStatus] [getPlusDay] overday_st_dt  : ["+ overday_st_dt +"]");
				   
				   // 반복문에서 사용되는 overday_st_dt 날짜가 TO_MVMT_DT 보다 크다면 Over Day 계산일을 종료합니다. 2015.03.19
				   if (!this.isValidateDate(overday_st_dt, prmToDate)) break;
				   
				   tmpCstopNo = "";
				   List<FreeTimeVO> mapTCStop = null;
				   
				   /* getTimeClockStopToDt -------- */
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmDttCode    : ["+ prmDttCode +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmOfcCd      : ["+ prmOfcCd +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  overday_st_dt : ["+ overday_st_dt +"]");
				   log.debug("[overdayNStatus] [getTimeClockStopToDt(param)]  prmYardCd     : ["+ prmYardCd +"]");

				   try {
				       mapTCStop = dbDao.getTimeClockStopToDt(prmDttCode, prmOfcCd, overday_st_dt, prmYardCd, termCd);
				       if (mapTCStop != null && mapTCStop.size() > 0) {
				           FreeTimeVO tmp = mapTCStop.get(0);
				           
				           log.debug("[overdayNStatus] dbDao.getTimeClockStopToDt : FreeTimeVO tmp "+tmp+"  @@@@@@@@@@@@@ \n");
				           
				           if (tmp!=null){
				               log.debug("[overdayNStatus] dbDao.getTimeClockStopToDt : CstopNo ["+tmp.getCstopNo()+"] / overday_st_dt ["+tmp.getRtnFtimeCmnc()+"] @@@@@@@@@@@@@ \n");
				               if (tmp.getCstopNo()!=null && !tmp.getCstopNo().trim().equals("")){
				                   tmpCstopNo    = nullToString(tmp.getCstopNo());
				                   overday_st_dt = nullToString(tmp.getRtnFtimeCmnc());
				                }
				            }
				       }     
				   	}catch(Exception e) {
						log.error("getTimeClockStopToDt Select Error !  ");
						throw new EventException("getTimeClockStopToDt Select Error ! : " + new ErrorHandler(e).getMessage());
				   	}
				   
				   	log.debug("[overdayNStatus] [getTimeClockStopToDt ] tmpCstopNo     : ["+ tmpCstopNo +"]");
				   	log.debug("[overdayNStatus] [getTimeClockStopToDt ] overday_st_dt  : ["+ overday_st_dt +"]");
				   
				   	if( !tmpCstopNo.equals("") ){
				   		ioIdxCstop = ioIdxCstop + 1;
				   		cstopNoList.add(tmpCstopNo);
				   		tmpCstopTotal += tmpCstopDay;
				    
				   		log.debug("[overdayNStatus] [ioIdxCstop ] ioIdxCstop : ["+ ioIdxCstop +"]");
				   		log.debug("[overdayNStatus] [tmpCstopNo ] tmpCstopNo : ["+ tmpCstopNo +"]");
				       
				   		if(cstopNoList != null && cstopNoList.size() > 0){ 
				   			for(int i = 0; i < cstopNoList.size(); i++){
				   				log.debug("[overdayNStatus] [cstopNoList.get("+i+")]"+cstopNoList.get(i));
				   			}
				   		}
				   		continue;
				   	}
				   
				    CheckWeekEndParmVO  checkWeekEndParmVO = new CheckWeekEndParmVO();
				    
					checkWeekEndParmVO.setCntCd(prmYrdLocCd.substring(0, 2));
					checkWeekEndParmVO.setWeekOfDay(weekOfDay);
					checkWeekEndParmVO.setExclSat(prmExclSat);
					checkWeekEndParmVO.setExclSun(prmExclSun);
					checkWeekEndParmVO.setLocCd(prmYrdLocCd);
					checkWeekEndParmVO.setTermCd(termCd);
					checkWeekEndParmVO.setTrfCd(prmDttCode);
					 
					existYN = nullToString(dbDao.checkWeekEnd(checkWeekEndParmVO)); 

					log.debug("[overdayNStatus] [checkWeekEnd] existYN : ["+ existYN +"]");
				   
					if(existYN.equals("Y")){
						continue;
					}
				   
				    /* getHolidayToDt -------- */
					/* ---Holiday Loc Setting ------ */
					if( prmDttCode.substring(0, 2).equals("DM") ||
						( prmSvrId.equals("USA") && prmDttCode.substring(0, 4).equals("DTIC"))){
						cntCd 		= 	prmYrdCntCd;
						rgnCd 		= 	prmYrdRgnCd;
						stateCd 	= 	prmYrdStateCd;
						locCd 		= 	prmYrdLocCd;
					} else {	
						cntCd 		= 	prmBkgCntCd;
						rgnCd 		= 	prmBkgRgnCd;
						stateCd 	= 	prmBkgStateCd;
						locCd 		= 	prmBkgLocCd;
					}
				   
					try {
						ddhDate = nullToString(dbDao.getHolidayToDt(overday_st_dt, cntCd, rgnCd, stateCd, locCd));
					}catch(Exception e) {
						log.error("[overdayNStatus] getHolidayToDt Select Error !  ");
						throw new EventException("getHolidayToDt Select Error ! : " + new ErrorHandler(e).getMessage());
					}
				   
					log.debug("[overdayNStatus] [getHolidayToDt ] ddhDate      : ["+ ddhDate +"]");
					log.debug("[overdayNStatus] [getHolidayToDt ] prmExclHoli  : ["+ prmExclHoli +"]");
				   
					if( !ddhDate.equals("") && prmExclHoli.equals("Y")){
						continue;
					}
				   
					overDay++; 
			   }/* end of for */
			}
			
			rtnOverDay = overDay;
		} else {			   
			/* -------------------------------Clock-Stop Day Check  */
			tmpCstopTotal	=	0;
			checkNum		=	0;
	
			List<OverdayNStatusVO> rtnCheckNumList = null;
			rtnCheckNumList = dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, 0, "3", "");	// prmToDate(A)- prmFtimeEnd(B)
			
			if (rtnCheckNumList != null && rtnCheckNumList.size() > 0) {
				// Over Day 발생.
				OverdayNStatusVO tmp = rtnCheckNumList.get(0);
				if (tmp!=null){
					// Over Days.
					checkNum = stringToLong(tmp.getCheckNum());
				}
			}
			
			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] prmToDate      :["+prmToDate+"]");
			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] prmFtimeEnd    :["+prmFtimeEnd+"]");
			log.debug("*[overdayNStatus] [Clock-Stop Day Check ] type 3");
			log.debug("*[overdayNStatus] [overdayNStatusParmVO ] checkNum       :["+checkNum+"]");
			
			if( checkNum > 0 ) {			/* When To Date is latter than Free Time End Date */
				List<StopDaysVO> list = null;
				list = dbDao.getStopDays(prmToDate, prmDttCode, prmOfcCd, prmFtimeEnd, prmYardCd, termCd);
	
				if (list != null && list.size() > 0) {
					for (int i = 0 ; i < list.size() ; i++) {
						StopDaysVO tmp = list.get(i);
						if (tmp!=null){
							tmpCstopNo 	= nullToString(tmp.getTmpCstopNo());
							tmpCstopDay = stringToLong(tmp.getTmpCstopDay());
						}
						
						ioIdxCstop = ioIdxCstop + 1;
						cstopNoList.add(tmpCstopNo);
						tmpCstopTotal += tmpCstopDay;
						
						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopNo      :["+tmpCstopNo+"]");
						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopDay     :["+tmpCstopDay+"]");
						log.debug("*[overdayNStatus] [GetStopDays ] ioIdxCstop      :["+ioIdxCstop+"]");
						log.debug("*[overdayNStatus] [GetStopDays ] cstopNoList     :["+cstopNoList+"]");
						log.debug("*[overdayNStatus] [GetStopDays ] tmpCstopTotal   :["+tmpCstopTotal+"]");
						
						if(cstopNoList != null && cstopNoList.size() > 0){
							for(int ii = 0; ii < cstopNoList.size(); ii++){
								log.debug("[overdayNStatus] [cstopNoList.get("+ii+")]:["+cstopNoList.get(ii)+"]");
							}
						}
					}
				}			
			} else {
				tmpCstopTotal = 0;
			}
			
			List<OverdayNStatusVO> rtnOverDayList = null;
			rtnOverDayList 	= dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, tmpCstopTotal, "4", "");
			
			if (rtnOverDayList != null && rtnOverDayList.size() > 0) {
				OverdayNStatusVO tmp = rtnOverDayList.get(0);
				if (tmp!=null){
					rtnOverDay = stringToLong(tmp.getOverDay());
				}
			}
		}
		
		/**
		 *  unfinishFlag = 1 이면 Unfinished 의미.
		 *  unfinishFlag = 0 이면 Finshed 의미.
		 */
		
		log.debug("*[overdayNStatus] prmMtDate  : ["+prmMtDate+"]");
		log.debug("*[overdayNStatus] rtnOverDay : ["+rtnOverDay+"]");
		
		checkGrace	=	0;
		if( prmMtDate.length() == 0 ){		
		
			if( rtnOverDay > 0 ){
				if( unfinishFlag == 1 ){
					 rtnStatus = "L";	
				} else {
					rtnStatus = "F";	
				}
			} else {
				if( unfinishFlag == 1 ){
					rtnStatus = "U";	
				} else {
					rtnStatus = "N";	
				}
			}
		} else {		
			/* _____________ Get the Grace Period Overday	*/

			/* MT DATE 에서 FEELTIME 으로 기준 변경 2016-03-21 */
			List<OverdayNStatusVO> checkGraceList = null;
//			checkGraceList = dbDao.getOverdayStatus(prmToDate, prmMtDate, 0, "5", prmOfcCd);
			checkGraceList = dbDao.getOverdayStatus(prmToDate, prmFtimeEnd, 0, "5", prmOfcCd);
			

			if (checkGraceList != null && checkGraceList.size() > 0) {
				OverdayNStatusVO tmp = checkGraceList.get(0);
				if (tmp!=null){
					checkGrace = stringToLong(tmp.getCheckGrace());
				}
			}
			
			if( rtnOverDay > 0 ){		
				if( checkGrace > 7 ){	
					if( unfinishFlag == 1 ){
						rtnStatus = "L"; 			
					} else {
						rtnStatus = "F"; 			
					}
				} else {						/*_____	Not Passed the Grace Period	*/
					rtnOverDay = 0;		

					if( unfinishFlag == 1 ){
						rtnStatus = "U";
					} else {
						rtnStatus = "N";
					}
				}
			} else {							/*_____	Not Passed the Free Time End Date	*/
				if( unfinishFlag == 1 ){
					rtnStatus = "U"; 			
				} else {
					rtnStatus = "N";
				}
			}
		}
		
		log.debug("[overdayNStatus] [return] rtnOverDay : ["+ rtnOverDay +"]");
		log.debug("[overdayNStatus] [return] rtnStatus  : ["+ rtnStatus +"]");
		log.debug("[overdayNStatus] [return] ioIdxCstop : ["+ ioIdxCstop +"]");
		
		if(cstopNoList != null && cstopNoList.size() > 0){
			for(int i = 0; i < cstopNoList.size(); i++){
				log.debug("[overdayNStatus] [return] cstopNoList.get("+i+")]:["+cstopNoList.get(i)+"]");
			}
		}
		
		overdayNStatusVO.setOverDay(String.valueOf(rtnOverDay));
		overdayNStatusVO.setStatus(rtnStatus);
		overdayNStatusVO.setCstopIdx(String.valueOf(ioIdxCstop));
		overdayNStatusVO.setCStopNoList(cstopNoList);
		
		return overdayNStatusVO;
	}

	/**
	 * basicCalculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public CalculationAMTVO basicCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		String 		prmSvrId			= nullToString(calculationParmVO.getSvrId());
		String		prmDttCode			= nullToString(calculationParmVO.getDmdtTrfCd());
		long		prmDtnSeq			= stringToLong(calculationParmVO.getTrfSeq());
		String		prmDmdtDeTermCd		= nullToString(calculationParmVO.getDmdtDeTermCd());
		long		prmGrpId			= stringToLong(calculationParmVO.getTrfGrpSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		prmFtDys			= stringToLong(calculationParmVO.getFtDys());
		String		prmFmMvmtYdCd		= nullToString(calculationParmVO.getFmMvmtYdCd());
		String		prmTrfAplyDt		= nullToString(calculationParmVO.getTrfAplyDt());
		String		prmDmdtTrfAplyTpCd	= nullToString(calculationParmVO.getDmdtTrfAplyTpCd());
		long		prmOrgFtOvrDys		= stringToLong(calculationParmVO.getOrgFtOvrDys());
		double		rtnTotal			= 0.0;
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;
		long		underOverTerm		= 0;
		String		inCntCd				= "";
		long		orgPrmOverDay		= prmOverDay;	// 변경 전 OverDays를 받아 놓는다.
		String 		bd_flg				= "N";
		
		long		tmpPrmOrgDivOverDay = 0;
		
		log.debug("\n*******************************************************");
		log.debug("\n* [basicCalculation] prmSvrId 			:"+prmSvrId);
		log.debug("\n* [basicCalculation] prmDttCode 		:"+prmDttCode);
		log.debug("\n* [basicCalculation] prmDtnSeq 		:"+prmDtnSeq);
		log.debug("\n* [basicCalculation] prmDmdtDeTermCd 	:"+prmDmdtDeTermCd);
		log.debug("\n* [basicCalculation] prmGrpId 			:"+prmGrpId);
		
		log.debug("\n* [basicCalculation] prmCntrts 		:"+prmCntrts);
		log.debug("\n* [basicCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("\n* [basicCalculation] prmDivOverDay		:"+prmDivOverDay);
		log.debug("\n* [basicCalculation] prmOrgDivOverDay	:"+prmOrgDivOverDay);
		
		log.debug("\n* [basicCalculation] prmFtDys			:"+prmFtDys);
		log.debug("\n* [basicCalculation] prmFmMvmtYdCd		:"+prmFmMvmtYdCd);
		log.debug("\n* [basicCalculation] prmTrfAplyDt		:"+prmTrfAplyDt);
		log.debug("\n* [basicCalculation] prmDmdtTrfAplyTpCd:"+prmDmdtTrfAplyTpCd);
		log.debug("\n* [basicCalculation] prmOrgFtOvrDys	:"+prmOrgFtOvrDys);
		log.debug("\n*******************************************************");
		
		if("".equals(prmFmMvmtYdCd) || prmFmMvmtYdCd.length() < 2){
			inCntCd = "";
		}else{
			inCntCd = prmFmMvmtYdCd.substring(0, 2);
		}
		
		if("".equals(prmTrfAplyDt) || prmTrfAplyDt.length() < 8){
			prmTrfAplyDt = "";
		}else{
			prmTrfAplyDt = prmTrfAplyDt.replace("-", "").substring(0, 8);
		}
		 
//		/////////////////// Test.........
//		inCntCd = "BD"; // BANGLADESH
//		prmFtDys = 5;
//		/////////////////// Test.........
		
		/////////////////////////////////////////////////////////////////////////////////////
		// 방글라데시 계산 로직 변경
		// FREE DAY = 9
		// OVER DAY = 6 일 경우
		// rate 가 1 - 7 
		//        8 - 14 일 경우
		// 방글라데시 이외 지역 RATE 가 1 -  7 일 경우 Over day 가 6 이고
		// 방글라데시 지역      RATE 가 1 -  7 일 경우 Over day 가 2 , 
		//                         8 - 14 일 경우 Over day 가  4 로 된다.
		// 즉 첫번째 rate의 Over day가 FREE TIME 만큼 빠지고 전체 Over day 가 다음 rate에 대상으로 된다.
		//////////////////////////////////////////////////////////////////////////////////

		bd_flg = dbDao.searchBangladeshFlg(inCntCd, prmTrfAplyDt);
		
//		if(inCntCd.equals("BD") && DMTCalculationUtil.stringToInt ("20140501") <= DMTCalculationUtil.stringToInt (prmTrfAplyDt) &&
		if( "Y".equals(bd_flg) 
//				&&
//				( prmDmdtTrfAplyTpCd.equals("B") || prmDmdtTrfAplyTpCd.equals("S") )
				){
			// prmDmdtTrfAplyTpCd.equals("B") || prmDmdtTrfAplyTpCd.equals("S") >> SC,RFA Rate 정보를 Basic Rate를 참조할 경우. (RT_ADJ_FLG = 'N' 인 경우)
			
			// Basic Free Days 구하기
			long	tmpOrgFtOvrDys = 0;
			long	tmpScFtOvrDys = 0;
			
			if (prmOrgFtOvrDys > 0) {
				tmpOrgFtOvrDys	= prmOrgFtOvrDys;				// Basic Free Over Days
			}
			
			if (prmOrgFtOvrDys > 0) {
				tmpScFtOvrDys	= prmOverDay;
			}
			
			prmFtDys   = tmpOrgFtOvrDys - tmpScFtOvrDys ;		// SC/RFA Exception Free Over Days (= DMT_EXPT_CHG_CALC.EXPT_DYS)

			log.debug("\n* [basicCalculation] prmFtDys(방글라데시)	:"+prmFtDys);
			
			if(stringToLong(calculationParmVO.getDivOrgOverDay())>0){
				tmpPrmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOrgOverDay());
				prmDivOverDay = tmpPrmOrgDivOverDay;
			} else {			
				prmDivOverDay		= prmDivOverDay + prmFtDys;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.
			}
			
//			long tmpPrmDivOverDay = prmDivOverDay + prmFtDys + tmpPrmOrgDivOverDay;
//			prmDivOverDay		= tmpPrmDivOverDay;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.
			long overDay 		= prmOverDay + prmFtDys;
			calculationParmVO.setOverDay(String.valueOf(overDay));		// OVER DAY + FREE DAY 만큼 RATE를 가져온다.
			prmOverDay			= overDay;								// OVER DAY + FREE DAY 만큼 전체 OVER 만큼 계산한다.
			
			calculationParmVO.setDivOverDay(String.valueOf(tmpPrmOrgDivOverDay));
			prmOrgDivOverDay = tmpPrmOrgDivOverDay;
		}
		
		// Rate 정보를 조회한다.
		List<ChargeListVO> list = dbDao.searchDivChrgList(calculationParmVO);
		
		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if(list != null && list.size() > 0 && orgPrmOverDay > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 	= 0.0;
			
				chrgDtlVO = new ChrgDtlVO();
				
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());		// From Days
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());		// To Days
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
			
				log.debug("[1.dtrFtOver ] :"+dtrFtOver);
				log.debug("[2.dtrFtUnder] :"+dtrFtUnder);
				log.debug("[3.dtrRate   ] :"+dtrRate);
				
				/* free time over day = 0 & free time under day =0 인 경우, for문 밖으로 빠져나옴. */
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the BSCChrg]");
					log.debug("*******************************************************");		
					
					break;
				}

				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));

				log.debug("[prmOverDay		]"+prmOverDay);
				log.debug("[prmOrgDivOverDay]"+prmOrgDivOverDay);
				log.debug("[dtrFtOver		]"+dtrFtOver);
				log.debug("[prmFtDys		]"+prmFtDys);
				
				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){
					/* ________________ last rate level */
					if (prmDivOverDay == 0){
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						if (tmpPrmOrgDivOverDay>0){
//							prmOrgDivOverDay = prmOrgDivOverDay + prmDivOverDay;
							underOverTerm = prmOverDay;
						} else {
							underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
						}
					}
				} else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ;

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						
						underOverTerm = 0;	/* 지나간 Balance rate 금액 */
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}

				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [bscChrgRate] "+ list.size() +"["+i+"]");
				log.debug("* [bscChrgRate] dtrFtOver	["+i+"]	:"+dtrFtOver);
				log.debug("* [bscChrgRate] dtrFtUnder	["+i+"]	:"+dtrFtUnder);
				log.debug("* [bscChrgRate] dtrRate		["+i+"]	:"+dtrRate);
				log.debug("* [bscChrgRate] underOverTerm["+i+"]	:"+underOverTerm);
				log.debug("* [bscChrgRate] prmDivOverDay["+i+"]	:"+prmDivOverDay);
				log.debug("* [bscChrgRate] rtnTotal		["+i+"]	:"+rtnTotal);
				log.debug("*******************************************************");
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		} /* End of the if clause */
		else {
			calculationAMTVO.setDtlCnt("0");
		}
		
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		log.debug("* [bscChrgRate] rtnTotal	:"+rtnTotal);
		
		return calculationAMTVO;
	}

	/**
	 * basicCalculationByBKG 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double basicCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String 		prmSvrId			= nullToString(calculationParmVO.getSvrId());
		String		prmDttCode			= nullToString(calculationParmVO.getDmdtTrfCd());
		long		prmDtnSeq			= stringToLong(calculationParmVO.getTrfSeq());
		long		prmGrpId			= stringToLong(calculationParmVO.getGrpSeq());
		
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		log.debug("*******************************************************");
		log.debug("* [basicCalculation] prmSvrId 		:"+prmSvrId);
		log.debug("* [basicCalculation] prmDttCode 		:"+prmDttCode);
		log.debug("* [basicCalculation] prmDtnSeq 		:"+prmDtnSeq);
		log.debug("* [basicCalculation] prmGrpId 		:"+prmGrpId);
		
		log.debug("* [basicCalculation] prmCntrts 		:"+prmCntrts);
		log.debug("* [basicCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [basicCalculation] prmDivOverDay	:"+prmDivOverDay);
		log.debug("* [basicCalculation] prmOrgDivOverDay:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list = dbDao.searchDivChrgList(calculationParmVO);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 	= 0.0;

			dtrFtOver 	= stringToLong(list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong(list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble(list.get(0).getRtAmt());
			
			log.debug("*******************************************************");
			log.debug("* [bscChrgRate] [0]");
			log.debug("* [bscChrgRate] dtrFtOver[0] :"+dtrFtOver);
			log.debug("* [bscChrgRate] dtrFtUnder[0]:"+dtrFtUnder);
			log.debug("* [bscChrgRate] dtrRate[0]    :"+dtrRate);
			log.debug("*******************************************************");
				
		} /* End of the if clause */
		
		return dtrRate;
	}
	
	/**
	 *  searchCommodityExceptionByGeneration 대한 해당 데이터를 조회한다.
	 * 
	 * @param CommodityExceptionParmVO commodityExceptionParmVO
	 * @return DmtCmdtGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtCmdtGrpVO searchCommodityExceptionByGeneration(CommodityExceptionParmVO commodityExceptionParmVO) throws EventException, DAOException {
		return dbDao.searchCommodityExceptionByGeneration(commodityExceptionParmVO);
	}

	/**
	 * findMvmtStsCd 해당하는 Container Movement Event Date를 조회한다.
	 * 
	 * @param String cntrNo
	 * @param long cnmvCycNo
	 * @param String findMvmtStsCd
	 * @param String startMvmtStsCd
	 * @return String 
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String getMinOCVLDate(String cntrNo ,long cnmvCycNo, String findMvmtStsCd, String startMvmtStsCd) throws EventException, DAOException {
		return dbDao.getMinOCVLDate(cntrNo, cnmvCycNo, findMvmtStsCd, startMvmtStsCd);
	}


	/**
	 *  searchSCExceptionByGeneration 대한 해당 데이터를 조회한다.
	 * 
	 * @param SCExceptionParmVO scExceptionParmVO
	 * @return DmtSCGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtSCGrpVO searchSCExceptionByGeneration(SCExceptionParmVO scExceptionParmVO) throws EventException, DAOException {
		DmtSCGrpVO dmtSCGrpVO = new DmtSCGrpVO();

		String	prmCntrTp			= nullToString(scExceptionParmVO.getCntrTp());
		String	prmCgoTp			= nullToString(scExceptionParmVO.getCgoTp());
		String	prmCntrCgoTp		= "";
	                                                
		/*------------------------------- CNTR & CGO Type Setting 
		D-Dry ("D" - "Dry")                    					1
		F-Reefer Dry ("R" - "Dry")         						2
		R-Reefer ("R" - "Reefer")          						3
		S-Spectial ("D" - "Danger", "F", "T", "O", "P", "A")  	4
		*/
		
		if( prmCntrTp.equals("D")){
			if( prmCgoTp.equals("DRY") || prmCgoTp.equals("AWK") ){
				prmCntrCgoTp = "D";     
			} else if( prmCgoTp.equals("DGR") ){
				prmCntrCgoTp = "S";		
			} else {
				dmtSCGrpVO.setMsgCd("-2");
				return	dmtSCGrpVO;
			}
		} else if( prmCntrTp.equals("R"))	{
			if( prmCgoTp.equals("DRY")){
				prmCntrCgoTp = "F"; 		
			} else if( prmCgoTp.equals("RFR")){
				prmCntrCgoTp = "R";		
			} else {
				dmtSCGrpVO.setMsgCd("-2");
				return	dmtSCGrpVO;
			}
		} else if( prmCntrTp.equals("F") || prmCntrTp.equals("T") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P") || prmCntrTp.equals("A")){//2010.12.07. [CHM-201007392-01] 'A' 추가
			prmCntrCgoTp = "S";		
		} else {
			dmtSCGrpVO.setMsgCd("-2");
			return	dmtSCGrpVO;
		}
		
		scExceptionParmVO.setCntrCgoTp(prmCntrCgoTp);
		
		dmtSCGrpVO = dbDao.searchSCExceptionByGeneration(scExceptionParmVO);
		dmtSCGrpVO.setMsgCd("0");
		return 	dmtSCGrpVO;
	}


	/**
	 * getSCEFreeTime 대한 해당 데이터를 조회한다.
	 * 
	 * @param String prmScNo
	 * @param long prmVerSeq
	 * @param long prmGrpSeq
	 * @param long prmQty
	 * @return long
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public long getSCEFreeTime(String prmScNo, long prmVerSeq, long prmGrpSeq, long prmQty) throws EventException, DAOException {
		return dbDao.getSCEFreeTime(prmScNo, prmVerSeq, prmGrpSeq, prmQty);
	}


	/**
	 * scCalculationByBKG 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double scCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String		prmScNo				= nullToString(calculationParmVO.getPropNo());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmGrpSeq			= stringToLong(calculationParmVO.getGrpSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		
		log.debug("*******************************************************");
		log.debug("* [scCalculation] prmScNo 			:"+ prmScNo);
		log.debug("* [scCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [scCalculation] prmGrpSeq 			:"+prmGrpSeq);
		log.debug("* [scCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [scCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [scCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [scCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list  = dbDao.searchDivSChrgList(prmScNo, prmVerSeq, prmGrpSeq, prmCntrts, prmOverDay, prmDivOverDay);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 		= 0.0;
		
			dtrFtOver 	= stringToLong(list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong(list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble(list.get(0).getRtAmt());
		
			log.debug("*******************************************************");
			log.debug("* [scChrgRate] [0]");
			log.debug("* [sceChrgRate ] dtrFtOver[0]	:"+dtrFtOver);
			log.debug("* [sceChrgRate ] dtrFtUnder[0]	:"+dtrFtUnder);
			log.debug("* [sceChrgRate ] dtrRate[0]		:"+dtrRate);
			log.debug("*******************************************************");
				
				
		} /* End of the if clause */
		

		return dtrRate;
	}
	
	/**
	 *  scCalculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO 
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public CalculationAMTVO scCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		
		String		prmScNo				= nullToString(calculationParmVO.getPropNo());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmGrpSeq			= stringToLong(calculationParmVO.getGrpSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		prmFtDys			= stringToLong(calculationParmVO.getFtDys());
		long		prmOrgFtOvrDys		= stringToLong(calculationParmVO.getOrgFtOvrDys());
		String		prmFmMvmtYdCd		= nullToString(calculationParmVO.getFmMvmtYdCd());
		String		prmTrfAplyDt		= nullToString(calculationParmVO.getTrfAplyDt());
		double		rtnTotal			= 0.0;
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;
		long		underOverTerm		= 0;
		String		inCntCd				= "";
		long		orgPrmOverDay		= prmOverDay;	// 변경 전 OverDays를 받아 놓는다.
		String		bd_flg				= "N";
		
		long		tmpPrmOrgDivOverDay = 0;
		
		log.debug("*******************************************************");
		log.debug("* [scCalculation] prmScNo 			 		:"+ prmScNo);
		log.debug("* [scCalculation] prmVerSeq 			 		:"+prmVerSeq);
		log.debug("* [scCalculation] prmGrpSeq 			 		:"+prmGrpSeq);
		log.debug("* [scCalculation] prmCntrts 			 		:"+prmCntrts);
		log.debug("* [scCalculation] prmOverDay(Over Days)		:"+prmOverDay);			// 자신의 Charge Over Days 
		log.debug("* [scCalculation] prmDivOverDay				:"+prmDivOverDay);		// 자신을 제외한 Charge Over Days 합
		log.debug("* [scCalculation] prmOrgDivOverDay 	 		:"+prmOrgDivOverDay);	// 자신을 제외한 Charge Over Days 합
		log.debug("* [scCalculation] prmFtDys		     		:"+prmFtDys);			// 자신의 Free Time
		log.debug("* [scCalculation] prmFmMvmtYdCd		 		:"+prmFmMvmtYdCd);
		log.debug("* [scCalculation] prmTrfAplyDt		 		:"+prmTrfAplyDt);
		log.debug("* [scCalculation] prmOrgFtOvrDys		 		:"+prmOrgFtOvrDys);
		log.debug("*******************************************************");
		
		if("".equals(prmFmMvmtYdCd) || prmFmMvmtYdCd.length() < 2){
			inCntCd = "";
		}else{
			inCntCd = prmFmMvmtYdCd.substring(0, 2);
		}
		
		if("".equals(prmTrfAplyDt) || prmTrfAplyDt.length() < 8){
			prmTrfAplyDt = "";
		}else{
			prmTrfAplyDt = prmTrfAplyDt.replace("-", "").substring(0, 8);
		}
		
//		/////////////////// Test.........
//		inCntCd = "BD"; // BANGLADESH
//		prmFtDys = 5;
//		/////////////////// Test.........

		/////////////////////////////////////////////////////////////////////////////////////
		// 방글라데시 계산 로직 변경
		// FREE DAY = 5
		// OVER DAY = 6 일 경우
		// rate 가 1 - 7 
		//        8 - 14 일 경우
		// 방글라데시 이외 지역 RATE 가 1 -  7 일 경우 Over day 가 6 이고
		// 방글라데시 지역      RATE 가 1 -  7 일 경우 Over day 가 2 , 
		//                         8 - 14 일 경우 Over day 가  4 로 된다.
		// 즉 첫번째 rate의 Over day가 FREE TIME 만큼 빠지고 전체 Over day 가 다음 rate에 대상으로 된다.
		//////////////////////////////////////////////////////////////////////////////////


		bd_flg = dbDao.searchBangladeshFlg(inCntCd, prmTrfAplyDt);
		
//		if(inCntCd.equals("BD") && DMTCalculationUtil.stringToInt ("20140501") <= DMTCalculationUtil.stringToInt (prmTrfAplyDt)){
		if( "Y".equals(bd_flg) ){
			long	tmpOrgFtOvrDys = 0;
			long	tmpScFtOvrDys = 0;
			
			if (prmOrgFtOvrDys > 0) {
				tmpOrgFtOvrDys	= prmOrgFtOvrDys;				// Basic Free Over Days
			}
			
			if (prmOrgFtOvrDys > 0) {
				tmpScFtOvrDys	= prmOverDay;
			}
			
			prmFtDys   = tmpOrgFtOvrDys - tmpScFtOvrDys ;		// SC/RFA Exception Free Over Days (= DMT_EXPT_CHG_CALC.EXPT_DYS : Additional Free Days)
			log.debug("\n* [scCalculation] prmFtDys(방글라데시)	:"+prmFtDys);

			if(stringToLong(calculationParmVO.getDivOrgOverDay())>0){
				tmpPrmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOrgOverDay());
			}
			
			long overDay 	= prmOverDay + prmFtDys;
			prmOverDay		= overDay;								// OVER DAY + FREE DAY 만큼 전체 OVER 만큼 계산한다.		

			calculationParmVO.setDivOverDay(String.valueOf(tmpPrmOrgDivOverDay));
			prmOrgDivOverDay = tmpPrmOrgDivOverDay;
			
			
		}
				
		List<ChargeListVO> list = dbDao.searchDivSChrgList(prmScNo, prmVerSeq, prmGrpSeq, prmCntrts, prmOverDay, prmDivOverDay);

//		if(inCntCd.equals("BD") && DMTCalculationUtil.stringToInt ("20140501") <= DMTCalculationUtil.stringToInt (prmTrfAplyDt)){
		if( "Y".equals(bd_flg) ){
//			long tmpPrmDivOverDay = prmDivOverDay + prmFtDys + tmpPrmOrgDivOverDay;
//			prmDivOverDay		= tmpPrmDivOverDay;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.			
			if(stringToLong(calculationParmVO.getDivOrgOverDay())>0){
				tmpPrmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOrgOverDay());
				prmDivOverDay = tmpPrmOrgDivOverDay;
			} else {			
				prmDivOverDay		= prmDivOverDay + prmFtDys;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.
			}
		}	
		
		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if (list != null && list.size() > 0 && orgPrmOverDay > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 	= 0.0;

				chrgDtlVO = new ChrgDtlVO();
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
				
				log.debug("[1.dtrFtOver]	:"+dtrFtOver);
				log.debug("[2.dtrFtOver]	:"+dtrFtUnder);
				log.debug("[3.dtrRate   ]	:"+dtrRate);
				
				/* free time over day = 0 & free time under day =0 인 경우, for문 밖으로 빠져나옴. */
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the sceChrgRate ]");
					log.debug("*******************************************************");		
					
					break;
				}

				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));
				
				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){	// prmOverDay (자신의 Charge Over Days) + prmOrgDivOverDay (자신을 제외한 Charge Over Days 합)
					/* ________________ last rate level */
					if (prmDivOverDay == 0){				// 자신을 제외한 Charge Over Days 합
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						if (tmpPrmOrgDivOverDay>0){
//							prmOrgDivOverDay = prmOrgDivOverDay + prmDivOverDay;
							underOverTerm = prmOverDay;
						} else {
							underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
						}
					}
				} else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ; // dtrFtUnder (To Days) - dtrFtOver (From Days) + 1 - prmOverDay (자신의 Charge Over Days)

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						underOverTerm = 0;	/* 지나간 Balance rate 금액 */
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}
				
				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [sceChrgRate ] "+ list.size() +"["+i+"]");
				log.debug("* [sceChrgRate ] dtrFtOver["+i+"]	:"+dtrFtOver);
				log.debug("* [sceChrgRate ] dtrFtUnder["+i+"]	:"+dtrFtUnder);
				log.debug("* [sceChrgRate ] dtrRate["+i+"]		:"+dtrRate);
				log.debug("* [sceChrgRate ] underOverTerm["+i+"]:"+underOverTerm);
				log.debug("* [sceChrgRate ] rtnTotal["+i+"]		:"+rtnTotal);
				log.debug("*******************************************************");		
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		} /* End of the if clause */
		else {
			calculationAMTVO.setDtlCnt("0");
		}
		
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		return calculationAMTVO;
	}

	/**
	 *  searchExchangeRate 대한 해당 데이터를 조회한다.
	 * 
	 * @param ExchangeRateParmVO exchangeRateParmVO
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public double searchExchangeRate(ExchangeRateParmVO exchangeRateParmVO) throws EventException, DAOException {
		double exRate = 0;
		
		String		prmFmCurCd			= nullToString(exchangeRateParmVO.getFmCurCd());
		String		prmToCurCd			= nullToString(exchangeRateParmVO.getToCurCd());
		double		tmpUsdLcl			= 0	;
		double		tmpMonthlyRate		= 0	;
		double		acctRateFrom		= 0	;
		double		acctRateTo			= 0	;
		
		
		tmpUsdLcl = dbDao.getLCLExRate(exchangeRateParmVO, "1");
		if(tmpUsdLcl != 0)
		{
			exRate = tmpUsdLcl;
		}
		else
		{
			tmpUsdLcl = dbDao.getLCLExRate(exchangeRateParmVO, "2");
			if(tmpUsdLcl != 0)
			{
				exRate = tmpUsdLcl;
			}
			else
			{
				//처리3순위
				/* If Not Found Then Monthly Rate */
				acctRateFrom = dbDao.getMonthlyRate(prmFmCurCd);
				acctRateTo = dbDao.getMonthlyRate(prmToCurCd);
				if(acctRateFrom > 0 && acctRateTo > 0 ){
					tmpMonthlyRate = dbDao.getRoundRate(acctRateTo, acctRateFrom);
				} else {
					return -1;
				}
				
				exRate = tmpMonthlyRate;
				log.debug("==================");
				log.debug("[ORDER 3:]"+exRate);
				log.debug("==================");
			}
		}

		log.debug("==================");
		log.debug("[final rate:]"+exRate);
		log.debug("==================");
		return exRate;
	}

	/**
	 *  searchBFRExceptionByGeneration 대한 해당 데이터를 조회한다.
	 * 
	 * @param BFRExceptionParmVO bfrExceptionParmVO
	 * @return DmtBFRGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtBFRGrpVO searchBFRExceptionByGeneration(BFRExceptionParmVO bfrExceptionParmVO) throws EventException, DAOException {
		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		
		String		prmScNo			= nullToString(bfrExceptionParmVO.getScNo());
		String		prmRfaNo		= nullToString(bfrExceptionParmVO.getRfaNo());
		String		prmCntrTp		= nullToString(bfrExceptionParmVO.getCntrTp());
		String		prmCgoTp		= nullToString(bfrExceptionParmVO.getCgoTp());
		String		actCustCntCd	= nullToString(bfrExceptionParmVO.getActCustCntCd());
		long   		actCustSeq    	= stringToLong(bfrExceptionParmVO.getActCustSeq()); 
		String		prmAwkInOut		= nullToString(bfrExceptionParmVO.getAwkInOut());
		
		/*------------------------------- CNTR & CGO Type Adjust */
		if(prmCntrTp.equals("D")){
			if(	prmCgoTp.equals("AWK") ||	prmCgoTp.equals("B/B") ||	prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("R")){
			if(	prmCgoTp.equals("AWK") || prmCgoTp.equals("DGR") ){
				prmCgoTp = "DRY";
			}
		}
		if(	!prmCntrTp.equals("D") && !prmCntrTp.equals("R") &&	prmCgoTp.equals("AWK")){
			if(prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			}
			else if(prmAwkInOut.equals("O")){
				prmCgoTp = "AWK";
			}
		}
		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P")){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			}
		}
		if( prmCntrTp.equals("F") ){
			if( prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			}else if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("O") || prmCntrTp.equals("C") ){
			if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("S") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}
		if( prmCntrTp.equals("A") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "F";
			}
		}
		log.debug("*******************************************************");
		log.debug("* [cntrTp]"+prmCntrTp);
		log.debug("* [prmCgoTp]"+prmCgoTp);
		log.debug("*******************************************************");

		/* -------------------------------------- Set Searching Key */

		if( prmScNo.length() == 0 && prmRfaNo.length() == 0 ){
			dmtBFRGrpVO.setMsgCd("0");
			return	dmtBFRGrpVO;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() != 0 ) {
			actCustCntCd = "" ;
			actCustSeq	= 0;
			log.debug("actCustCntCd actCustSeq== "+actCustCntCd+" "+actCustSeq);
		} else if( prmScNo.length() != 0 && prmRfaNo.length() == 0  ) {
			;
		} else if( prmScNo.length() == 0 && prmRfaNo.length() != 0 ) {
			;
		}
			
		bfrExceptionParmVO.setCntrTp(prmCntrTp);
		bfrExceptionParmVO.setCgoTp(prmCgoTp);
		
		dmtBFRGrpVO = dbDao.searchBFRExceptionByGeneration(bfrExceptionParmVO);

		return 	dmtBFRGrpVO;
	}

	/**
	 * beforeCalculationByBKG 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return double
	 * @throws EventException 
	 * @throws DAOException 
	 */
	public double beforeCalculationByBKG(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		
		String		prmDarNo			= nullToString(calculationParmVO.getDarNo());
		long		prmMapgNo			= stringToLong(calculationParmVO.getMapgSeq());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmDtlSeq			= stringToLong(calculationParmVO.getDtlSeq());
		long		prmCmbSeq			= stringToLong(calculationParmVO.getCmbSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;

		
		log.debug("*******************************************************");
		log.debug("* [beforeCalculation] prmDarNo 			:"+prmDarNo);
		log.debug("* [beforeCalculation] prmMapgNo 			:"+prmMapgNo);
		log.debug("* [beforeCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("* [beforeCalculation] prmDtlSeq 			:"+prmDtlSeq);
		log.debug("* [beforeCalculation] prmCmbSeq 			:"+prmCmbSeq);
		
		log.debug("* [beforeCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("* [beforeCalculation] prmOverDay 		:"+prmOverDay);
		log.debug("* [beforeCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("* [beforeCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("*******************************************************");
		
		List<ChargeListVO> list = dbDao.searchDivBChrgList(prmDarNo, prmMapgNo, prmVerSeq, prmDtlSeq, prmCmbSeq, prmCntrts, prmOverDay, prmDivOverDay);
		
		if (list != null && list.size() > 0) {
			dtrFtOver 	= 0;
			dtrFtUnder 	= 0;
			dtrRate 	= 0.0;
		
			dtrFtOver 	= stringToLong((String) list.get(0).getFtOvrDys());
			dtrFtUnder 	= stringToLong((String) list.get(0).getFtUndDys());
			dtrRate 	= stringToDouble((String) list.get(0).getRtAmt());

			log.debug("*******************************************************");
			log.debug("* [scChrgRate] [0]");
			log.debug("* [sceChrgRate ] dtrFtOver[0]	:"+dtrFtOver);
			log.debug("* [sceChrgRate ] dtrFtUnder[0]	:"+dtrFtUnder);
			log.debug("* [sceChrgRate] dtrRate[0]		:"+dtrRate);
			log.debug("*******************************************************");
		} /* End of the if clause */

		return dtrRate;
	}
	
	/**
	 * beforeCalculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @throws EventException 
	 * @throws DAOException 
	 */
	public CalculationAMTVO beforeCalculation(CalculationParmVO calculationParmVO) throws EventException, DAOException {
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		String		prmDarNo			= nullToString(calculationParmVO.getDarNo());
		long		prmMapgNo			= stringToLong(calculationParmVO.getMapgSeq());
		long		prmVerSeq			= stringToLong(calculationParmVO.getVerSeq());
		long		prmDtlSeq			= stringToLong(calculationParmVO.getDtlSeq());
		long		prmCmbSeq			= stringToLong(calculationParmVO.getCmbSeq());
		String		prmCntrts			= nullToString(calculationParmVO.getCntrts());
		long		prmOverDay			= stringToLong(calculationParmVO.getOverDay());
		long		prmDivOverDay		= stringToLong(calculationParmVO.getDivOverDay());
		long		prmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		long		prmFtDys			= stringToLong(calculationParmVO.getFtDys());
		long		prmOrgFtOvrDys		= stringToLong(calculationParmVO.getOrgFtOvrDys());
		String		prmFmMvmtYdCd		= nullToString(calculationParmVO.getFmMvmtYdCd());
		String		prmTrfAplyDt		= nullToString(calculationParmVO.getTrfAplyDt());
		double		rtnTotal			= 0.0;
		long		dtrFtOver			= 0;
		long		dtrFtUnder			= 0;
		double		dtrRate				= 0.0;
		long		underOverTerm			= 0;
		String		inCntCd				= "";
		long		orgPrmOverDay		= prmOverDay;	// 변경 전 OverDays를 받아 놓는다.
														// 방글라데시 로직에서 Over Days + Free Days를  계산되지 때문에 원래 Over Days가 있을 때문만 로직 수행토록 추가함.
		String		bd_flg				= "N";
		
		long		tmpPrmOrgDivOverDay = 0;
		
		log.debug("\n*******************************************************");
		log.debug("\n* [beforeCalculation] prmDarNo 			:"+prmDarNo);
		log.debug("\n* [beforeCalculation] prmMapgNo 			:"+prmMapgNo);
		log.debug("\n* [beforeCalculation] prmVerSeq 			:"+prmVerSeq);
		log.debug("\n* [beforeCalculation] prmDtlSeq 			:"+prmDtlSeq);
		log.debug("\n* [beforeCalculation] prmCmbSeq 			:"+prmCmbSeq);
		log.debug("\n* [beforeCalculation] prmCntrts 			:"+prmCntrts);
		log.debug("\n* [beforeCalculation] prmOverDay 			:"+prmOverDay);
		log.debug("\n* [beforeCalculation] prmDivOverDay 		:"+prmDivOverDay);
		log.debug("\n* [beforeCalculation] prmOrgDivOverDay 	:"+prmOrgDivOverDay);
		log.debug("\n* [beforeCalculation] prmFtDys		    	:"+prmFtDys);			// 자신의 Free Time
		log.debug("\n* [beforeCalculation] prmFmMvmtYdCd		:"+prmFmMvmtYdCd);
		log.debug("\n* [beforeCalculation] prmTrfAplyDt			:"+prmTrfAplyDt);	
		log.debug("\n* [beforeCalculation] prmOrgFtOvrDys		:"+prmOrgFtOvrDys);
		log.debug("*******************************************************");
		
		if("".equals(prmFmMvmtYdCd) || prmFmMvmtYdCd.length() < 2){
			inCntCd = "";
		}else{
			inCntCd = prmFmMvmtYdCd.substring(0, 2);
		}
	
		if("".equals(prmTrfAplyDt) || prmTrfAplyDt.length() < 8){
			prmTrfAplyDt = "";
		}else{
			prmTrfAplyDt = prmTrfAplyDt.replace("-", "").substring(0, 8);
		}
	
		//	/////////////////// Test.........
		//	inCntCd = "BD"; // BANGLADESH
		//	prmFtDys = 9;
		//	/////////////////// Test.........

		/////////////////////////////////////////////////////////////////////////////////////
		// 방글라데시 계산 로직 변경
		// FREE DAY = 5
		// OVER DAY = 6 일 경우
		// rate 가 1 - 7 
		//        8 - 14 일 경우
		// 방글라데시 이외 지역 RATE 가 1 -  7 일 경우 Over day 가 6 이고
		// 방글라데시 지역      RATE 가 1 -  7 일 경우 Over day 가 2 , 
		//                         8 - 14 일 경우 Over day 가  4 로 된다.
		// 즉 첫번째 rate의 Over day가 FREE TIME 만큼 빠지고 전체 Over day 가 다음 rate에 대상으로 된다.
		//////////////////////////////////////////////////////////////////////////////////		

		bd_flg = dbDao.searchBangladeshFlg(inCntCd, prmTrfAplyDt);

//		if(inCntCd.equals("BD") && DMTCalculationUtil.stringToInt ("20140501") <= DMTCalculationUtil.stringToInt (prmTrfAplyDt)){
		if( "Y".equals(bd_flg)) {
			long	tmpOrgFtOvrDys = 0;
			long	tmpScFtOvrDys = 0;
			
			if (prmOrgFtOvrDys > 0) {
				tmpOrgFtOvrDys	= prmOrgFtOvrDys;				// Basic Free Over Days
			}
			
			if (prmOrgFtOvrDys > 0) {
				tmpScFtOvrDys	= prmOverDay;
			}
			
			prmFtDys   = tmpOrgFtOvrDys - tmpScFtOvrDys ;		// SC/RFA Exception Free Over Days (= DMT_EXPT_CHG_CALC.EXPT_DYS)
			log.debug("\n* [scCalculation] prmFtDys(방글라데시)	:"+prmFtDys);

			if(stringToLong(calculationParmVO.getDivOrgOverDay())>0){
				tmpPrmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOrgOverDay());
			}
			
			long overDay 	= prmOverDay + prmFtDys;
			prmOverDay		= overDay;								// OVER DAY + FREE DAY 만큼 전체 OVER 만큼 계산한다.
			
			calculationParmVO.setDivOverDay(String.valueOf(tmpPrmOrgDivOverDay));
			prmOrgDivOverDay = tmpPrmOrgDivOverDay;
			
		}

		List<ChargeListVO> list = dbDao.searchDivBChrgList(prmDarNo, prmMapgNo, prmVerSeq, prmDtlSeq, prmCmbSeq, prmCntrts, prmOverDay, prmDivOverDay);
			
//		if(inCntCd.equals("BD") && DMTCalculationUtil.stringToInt ("20140501") <= DMTCalculationUtil.stringToInt (prmTrfAplyDt)){
		if( "Y".equals(bd_flg) ){
//			long tmpPrmDivOverDay = prmDivOverDay + prmFtDys + tmpPrmOrgDivOverDay;
//			prmDivOverDay		= tmpPrmDivOverDay;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.	
			if(stringToLong(calculationParmVO.getDivOrgOverDay())>0){
				tmpPrmOrgDivOverDay	= stringToLong(calculationParmVO.getDivOrgOverDay());
				prmDivOverDay = tmpPrmOrgDivOverDay;
			} else {			
				prmDivOverDay		= prmDivOverDay + prmFtDys;						// 처음 계산 로직에서 FREE DAY 만큼 빼주고 계산한다.
			}
		}	

		List<ChrgDtlVO> chrgDtlList = new ArrayList<ChrgDtlVO>();
		ChrgDtlVO chrgDtlVO = null;
		
		if (list != null && list.size() > 0 && orgPrmOverDay > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				ChargeListVO chargeListVO = list.get(i);
				dtrFtOver 	= 0;
				dtrFtUnder 	= 0;
				dtrRate 		= 0.0;
				
				chrgDtlVO = new ChrgDtlVO();
				dtrFtOver 	= stringToLong(chargeListVO.getFtOvrDys());
				dtrFtUnder 	= stringToLong(chargeListVO.getFtUndDys());
				dtrRate 	= stringToDouble(chargeListVO.getRtAmt());
						
				log.debug("[1.dtrFtOver] :"+dtrFtOver);
				log.debug("[2.dtrFtOver] :"+dtrFtUnder);
				log.debug("[3.dtrRate   ]:"+dtrRate);
				
				/* free time over day = 0 & free time under day =0 인 경우, for문 밖으로 빠져나옴. */
				if(dtrFtOver == 0 && dtrFtUnder == 0){
					log.debug("*******************************************************");
					log.debug("* [end of the BFRChrgRate ]");
					log.debug("*******************************************************");		
					
					break;
				}
				
				chrgDtlVO.setRtOver(String.valueOf(dtrFtOver));
				chrgDtlVO.setRtUnder(String.valueOf(dtrFtUnder));
				chrgDtlVO.setRtRate(String.valueOf(dtrRate));
				
				if( ( dtrFtUnder == 0 ) || ( dtrFtUnder >= prmOverDay + prmOrgDivOverDay) ){
					/* ________________ last rate level */
					if (prmDivOverDay == 0){
						underOverTerm = (prmOverDay + prmOrgDivOverDay)- dtrFtOver + 1 ;
					} else {
						if (tmpPrmOrgDivOverDay>0){
//							prmOrgDivOverDay = prmOrgDivOverDay + prmDivOverDay;
							underOverTerm = prmOverDay;
						} else {
							underOverTerm = (prmOverDay + prmOrgDivOverDay - prmDivOverDay)- dtrFtOver + 1 ;
						}
					}
				} 
				else {
					underOverTerm = (dtrFtUnder - dtrFtOver + 1) - prmDivOverDay ;

					if (underOverTerm <= 0){
						prmDivOverDay = Math.abs(underOverTerm);
						underOverTerm = 0;	/* 지나간 Balance rate 금액 */
					} else {
						prmDivOverDay = prmDivOverDay - ( dtrFtUnder - dtrFtOver + 1);

						if (prmDivOverDay < 0) prmDivOverDay = 0;
					}
				}

				chrgDtlVO.setRtDay(String.valueOf(underOverTerm));
				chrgDtlVO.setRtChrg(String.valueOf(dtrRate * underOverTerm));

				rtnTotal += dtrRate * underOverTerm;
				
				log.debug("*******************************************************");
				log.debug("* [BFRChrgRate ] "+ list.size() +"["+i+"]");
				log.debug("* [BFRChrgRate ] dtrFtOver["+i+"]	:"+dtrFtOver);
				log.debug("* [BFRChrgRate ] dtrFtUnder["+i+"]	:"+dtrFtUnder);
				log.debug("* [BFRChrgRate ] dtrRate["+i+"]		:"+dtrRate);
				log.debug("* [BFRChrgRate ] underOverTerm["+i+"]:"+underOverTerm);
				log.debug("* [BFRChrgRate ] rtnTotal["+i+"]		:"+rtnTotal);
				log.debug("*******************************************************");
				
				chrgDtlList.add(chrgDtlVO);
				
			}  /* End of the for loop */
			calculationAMTVO.setDtlCnt(String.valueOf(list.size()));
		} /* End of the if clause */
		else {
			calculationAMTVO.setDtlCnt("0");
		}
		
		calculationAMTVO.setChrgDtlVOS(chrgDtlList);
		calculationAMTVO.setTotal(String.valueOf(rtnTotal));
		
		return calculationAMTVO;
	}

	/**
	 * searchAFTExceptionByGeneration 대한 해당 데이터를 조회한다.
	 * 
	 * @param AFTExceptionParmVO aftExceptionParmVO
	 * @return DmtAFTGrpVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DmtAFTGrpVO searchAFTExceptionByGeneration(AFTExceptionParmVO aftExceptionParmVO) throws EventException, DAOException {
		return dbDao.searchAFTExceptionByGeneration(aftExceptionParmVO);
	}

	/**
	 *  trimCurrencyAmount 대한 해당 데이터를 조회한다.
	 * 
	 * @param String currencyCode
	 * @param double oriAmount
	 * @return double
	 * @throws EventException 
	 * @exception EventException
	 */
	public double trimCurrencyAmount(String currencyCode, double oriAmount ) throws EventException{
		String	prmCur		= "";
		double	prmAmt		= 0.0;
		double  tmpAmt		= 0.0;

		prmCur = currencyCode;
		prmAmt = oriAmount;
		
		if	(	prmCur.equals("KRW") || prmCur.equals("JPY") ||
				prmCur.equals("BEF") || prmCur.equals("DJF") ||
				prmCur.equals("ESP") || prmCur.equals("GRD") ||
				prmCur.equals("ITL") || prmCur.equals("LAK") ||
				prmCur.equals("MGF") || prmCur.equals("MRO") ||
				prmCur.equals("MXP") || prmCur.equals("PTE") ||
				prmCur.equals("SDD") || prmCur.equals("MXN") ){	
			
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "1");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("1 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("1 trimCurrencyAmount Select Error ! " + new ErrorHandler(e).getMessage());
			}
		} 
		else if( prmCur.equals("TWD") || prmCur.equals("IDR") ) {
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "2");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("2 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("2 trimCurrencyAmount Select Error !" + new ErrorHandler(e).getMessage());
			}
		} 
		else {
			try {
				tmpAmt = dbDao.trimCurrencyAmount(prmAmt, "3");
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("3 trimCurrencyAmount Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("3 trimCurrencyAmount Select Error !" + new ErrorHandler(e).getMessage());
			}
		}

		return tmpAmt ;
	}
	
	
	/**
	 *  overdayNDiv 대한 해당 데이터를 조회한다.
	 * 
	 * @param OverdayNDivParmVO overdayNDivParmVO
	 * @return OverdayNDivVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public OverdayNDivVO overdayNDiv(OverdayNDivParmVO overdayNDivParmVO) throws EventException, DAOException{
		OverdayNDivVO overdayNDivVO = new OverdayNDivVO();
		
		/* ____ Exist Checking */
		overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO,"EXIST_CHECK");
		log.debug("*******************************************************");
		log.debug("* EXIST Checking :"+overdayNDivVO.getDivOverDay());
		log.debug("*******************************************************");
		
		if( overdayNDivVO.getDivOverDay() == null){
			overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO, "NOT_EXIST");
		} else {
			overdayNDivVO = dbDao.overdayNDiv(overdayNDivParmVO, "EXIST");			
		}
		
		return overdayNDivVO;
		
	}

	/**
	 *  searchCalculationType 대한 해당 데이터를 조회한다. <br>
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchCalculationType(CalculationTypeParmVO calculationTypeParmVO) throws EventException, DAOException{
		
		String prmCntCd = nullToString(calculationTypeParmVO.getCntCd());
		String prmLocCd = nullToString(calculationTypeParmVO.getLocCd());
		String prmIoBnd = nullToString(calculationTypeParmVO.getIoBnd());
		String prmBcntrDlvTerm = nullToString(calculationTypeParmVO.getBcntrDlvTerm(), 1);
		String prmPodLoc = nullToString(calculationTypeParmVO.getPodLoc(), 5);
		String dcCalcTp = "";
		
		//추가
		String prmPorLoc = nullToString(calculationTypeParmVO.getPorLoc(), 5);
		String prmPolLoc = nullToString(calculationTypeParmVO.getPolLoc(), 5);
		String prmDelLoc = nullToString(calculationTypeParmVO.getDelLoc(), 5);
		
		log.debug("*****************************************************************");
		log.debug("[searchCalculationType(param)]getCntCd() 	: "+ calculationTypeParmVO.getCntCd());
		log.debug("[searchCalculationType(param)]getRgnCd() 	: "+ calculationTypeParmVO.getRgnCd());
		log.debug("[searchCalculationType(param)]getStateCd() 	: "+ calculationTypeParmVO.getStateCd());
		log.debug("[searchCalculationType(param)]getLocCd() 	: "+ calculationTypeParmVO.getLocCd());
		log.debug("[searchCalculationType(param)]getIoBnd() 	: "+ calculationTypeParmVO.getIoBnd());
		log.debug("[searchCalculationType(param)]getEffDt() 	: "+ calculationTypeParmVO.getEffDt());
		log.debug("[searchCalculationType(param)]getBcntrDlvTerm() : "+ calculationTypeParmVO.getBcntrDlvTerm());
		log.debug("[searchCalculationType(param)]getPodLoc() 	: "+ calculationTypeParmVO.getPodLoc());
		log.debug("[searchCalculationType(param)]getPorLoc() 	: "+ calculationTypeParmVO.getPorLoc());
		log.debug("[searchCalculationType(param)]getPolLoc() 	: "+ calculationTypeParmVO.getPolLoc());
		log.debug("[searchCalculationType(param)]getDelLoc() 	: "+ calculationTypeParmVO.getDelLoc());
		log.debug("[searchCalculationType(param)]getPodEtaFlg() : "+ calculationTypeParmVO.getPodEtaFlg());
		log.debug("*****************************************************************");
		
		dcCalcTp = dbDao.searchCalculationType(calculationTypeParmVO);
		log.debug("[ReturnValue:searchCalculationType] : "+ dcCalcTp);
		
		// Calculation Type Exceptions  
		//case 1
		if( prmPodLoc.substring(0, 2).equals("US") &&	prmCntCd.equals("MX") && prmIoBnd.equals("I") && prmBcntrDlvTerm.substring(0, 1).equals("D")){
			dcCalcTp = "D";
		}
		//case 2 - 2010.02.02 추가
		if( prmPolLoc.substring(0, 2).equals("US") &&	prmPorLoc.substring(0, 2).equals("MX") && prmIoBnd.equals("O") ){
			dcCalcTp = "D";
		}
		//case 3 - 2010.02.02 추가
		if( prmPodLoc.substring(0, 2).equals("MX") &&	prmDelLoc.substring(0, 2).equals("MX") && prmIoBnd.equals("I")){
			dcCalcTp = "C";
		}
		//case 4 - 2010.02.02 추가
		if( prmPolLoc.substring(0, 2).equals("MX") &&	prmPorLoc.substring(0, 2).equals("MX") && prmIoBnd.equals("O")){
			dcCalcTp = "C";
		}
		
		if( prmPodLoc.equals("CNHKG") && !prmLocCd.equals("CNHKG") && prmIoBnd.equals("I") ){
			dcCalcTp = "D";
		}
		
		return dcCalcTp;
	}

	/**
	 *  checkChargeCorrection 대한 해당 데이터를 조회한다. <br>
	 * Charge의 Correction History가 존재하는지 여부를 조회하여 존재시 1을, 미존재시 0을 Return한다<br>
	 * 
	 * @param ChargeArgumentVO chargeArgumentVO
	 * @return int
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public int checkChargeCorrection(ChargeArgumentVO chargeArgumentVO) throws EventException, DAOException{
	
		int corrHisSeq = 0;
		int retValue = 0;
		
		retValue = dbDao.checkChargeCorrection(chargeArgumentVO);
	
		// Charge의 Correction History가 존재하는지 여부를 조회하여 존재시 1을, 미존재시 0을 Return한다
		if(retValue > 0){
			corrHisSeq = retValue;
		} else {
			corrHisSeq = 0;
		}
			
		log.debug("[ReturnValue:checkChargeCorrection]>> : "+ corrHisSeq);
		return corrHisSeq;
	}
	
	/**
	 *  bbsChargeCalculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param CalculationParmVO calculationParmVO
	 * @return CalculationAMTVO
	 * @exception EventException
	 */
	public CalculationAMTVO bbsChargeCalculation(CalculationParmVO calculationParmVO) throws EventException{
		CalculationAMTVO calculationAMTVO = new CalculationAMTVO();
		
		String		zDcApplRate	= nullToString(calculationParmVO.getDcApplRate(), 1);
		/*_________ basicCalculation */
		String 		zSvrId   	= nullToString(calculationParmVO.getSvrId());
		String		zDttCode	= nullToString(calculationParmVO.getDmdtTrfCd());
		String		zDmdtDeTermCd	= nullToString(calculationParmVO.getDmdtDeTermCd());
		long		zDtnSeq		= stringToLong(calculationParmVO.getTrfSeq());
		long		zDtgGrpId	= stringToLong(calculationParmVO.getTrfGrpSeq());
		String		zCntrtsCd	= nullToString(calculationParmVO.getCntrts());
		/*_________ beforeCalculation */
		String		zRfaDarNo	= nullToString(calculationParmVO.getDarNo());
		long		zRfaMapgSeq	= stringToLong(calculationParmVO.getMapgSeq());
		long		zRfaVerSeq	= stringToLong(calculationParmVO.getVerSeq());
		long		zRfaDtlSeq	= stringToLong(calculationParmVO.getDtlSeq());
		/*_________ scCalculation */
		String		zScNo		= nullToString(calculationParmVO.getPropNo());
		long		zScVerSeq	= stringToLong(calculationParmVO.getVerSeq());
		long		zScGrpSeq	= stringToLong(calculationParmVO.getGrpSeq());
		long		zOverDay	= stringToLong(calculationParmVO.getOverDay());
		long		zDivOverDay	= stringToLong(calculationParmVO.getDivOverDay());
		String		zCurCd		= nullToString(calculationParmVO.getCurCd());

		String		rtnRateCurCd		= 		"";

		if(zDcApplRate.substring(0, 1).equals("G") ){		/* Baisc Tariff			*/
			calculationParmVO.setSvrId(zSvrId  );
			calculationParmVO.setDmdtTrfCd(zDttCode);
			calculationParmVO.setTrfSeq(String.valueOf(zDtnSeq));
			calculationParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
			calculationParmVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));
			
			try {
				calculationAMTVO = basicCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*[bbsChargeCalculation]  basicCalculation Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("[bbsChargeCalculation]  basicCalculation Function Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			// No Charge 인 경우 curCd, invCurCd 동일값으로 return 
			rtnRateCurCd = zCurCd;	
		} 
		else if(zDcApplRate.substring(0, 1).equals("B") ){   			/* Before BKG Exception	*/
		
			calculationParmVO.setDarNo(zRfaDarNo);
			calculationParmVO.setMapgSeq(String.valueOf(zRfaMapgSeq));
			calculationParmVO.setVerSeq(String.valueOf(zRfaVerSeq));
			calculationParmVO.setDtlSeq(String.valueOf(zRfaDtlSeq));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));	
			
			try {
				calculationAMTVO = beforeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("*[bbsChargeCalculation]  beforeCalculation Function Error :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("[bbsChargeCalculation]  beforeCalculation Function Error :" + new ErrorHandler(e).getMessage());
			}
			
			try {
				rtnRateCurCd = dbDao.bbsChargeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Rate Cur Select Error ! :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Rate Cur Select Error ! :" + new ErrorHandler(e).getMessage());
			}
		} 
		else if (zDcApplRate.substring(0, 1).equals("S")){   			/* SC Exception			*/
			calculationParmVO.setPropNo(zScNo);
			calculationParmVO.setVerSeq(String.valueOf(zScVerSeq));
			calculationParmVO.setGrpSeq(String.valueOf(zScGrpSeq));
			calculationParmVO.setCntrts(zCntrtsCd);
			calculationParmVO.setOverDay(String.valueOf(zOverDay));
			calculationParmVO.setDivOverDay(String.valueOf(zDivOverDay));

			try {
				calculationAMTVO = scCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("scCalculation Function Error !  ");
				log.error("*******************************************************");
				throw new EventException("scCalculation Function Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			try {
				rtnRateCurCd = dbDao.bbsChargeCalculation(calculationParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("* Rate Cur Select Error! :"+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("* Rate Cur Select Error! :" + new ErrorHandler(e).getMessage());
			}
		}		// END OF THE zDccApplRate

		calculationAMTVO.setRateCurCd(rtnRateCurCd);
		
		return calculationAMTVO;
	}
	
	/**
	 *  searchDualTypeException 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDualTypeException(ChargeCalculationParmVO chargeCalculationParmVO) 
	throws EventException{

		ContainerCargoTypeParmVO 	containerCargoTypeParmVO_local 	= new ContainerCargoTypeParmVO();
		FixPOLLocationParmVO 		fixPOLLocationParmVO 		= new FixPOLLocationParmVO();
		FixPODLocationParmVO 		fixPODLocationParmVO 		= new FixPODLocationParmVO();
		LocationByBoundParmVO 		locationByBoundParmVO 		= new LocationByBoundParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		SCExceptionParmVO 			scExceptionParmVO 			= new SCExceptionParmVO();
		BFRExceptionParmVO 			bfrExceptionParmVO 			= new BFRExceptionParmVO();
		
		//param 지역변수 
		String zSvrId       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getSvrId());
		String zCntrNo      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrNo());
		long   zCnmvCycNo   = DMTCalculationUtil.stringToLong(chargeCalculationParmVO.getCntrCycNo());
		String zBkgNo       = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getBkgNo());
		String zDcFmDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtDt());
		String zDcFmYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtYdCd());
		String zDcFmCnms    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getFmMvmtStsCd());
		String zDcToDate   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtDt());
		String zDcToYdCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtYdCd());
		String zDcToCnms   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getToMvmtStsCd());
		String zDttCode     = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtTrfCd());
		String zCntrtsCd    = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCntrTpszCd());
		String zDbcIoBnd   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getIoBndCd());
		String zCustCntCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustCntCd());
		String zCustCd      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getCustSeq());
		String zAczCnzCd   	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCntCd());
		String zAczCuszCd  	= DMTCalculationUtil.nullToString(chargeCalculationParmVO.getActCustSeq());
		String zLocDiv      = DMTCalculationUtil.nullToString(chargeCalculationParmVO.getDmdtChgLocDivCd());
		
		log.debug("***********************************************************");
		log.debug("[ChargeCalculationParmVO]>> zSvrId   	:"+ zSvrId  );
		log.debug("[ChargeCalculationParmVO]>> zCntrNo   	:"+ zCntrNo  );
		log.debug("[ChargeCalculationParmVO]>> zCnmvCycNo   :"+ zCnmvCycNo   );
		log.debug("[ChargeCalculationParmVO]>> zDcFmDate 	:"+ zDcFmDate);
		log.debug("[ChargeCalculationParmVO]>> zDcFmYdCd 	:"+ zDcFmYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcFmCnms 	:"+ zDcFmCnms);
		log.debug("[ChargeCalculationParmVO]>> zDcToDate 	:"+ zDcToDate);
		log.debug("[ChargeCalculationParmVO]>> zDcToYdCd 	:"+ zDcToYdCd);
		log.debug("[ChargeCalculationParmVO]>> zDcToCnms 	:"+ zDcToCnms);
		log.debug("[ChargeCalculationParmVO]>> zDttCode 	:"+ zDttCode);
		log.debug("[ChargeCalculationParmVO]>> zCntrtsCd 	:"+ zCntrtsCd);
		log.debug("[ChargeCalculationParmVO]>> zDbcIoBnd 	:"+ zDbcIoBnd);
		log.debug("[ChargeCalculationParmVO]>> zCustCntCd 	:"+ zCustCntCd);
		log.debug("[ChargeCalculationParmVO]>> zCustCd 		:"+ zCustCd);
		log.debug("[ChargeCalculationParmVO]>> zAczCnzCd 	:"+ zAczCnzCd);
		log.debug("[ChargeCalculationParmVO]>> zAczCuszCd 	:"+ zAczCuszCd);
		log.debug("*************************************************************");

//////////////////////  START    변수 정의    /////////////////
		
		String zBlNo			= "";  
		
		String zPorContiCd 		= ""; 
		String zPorCntCd 		= ""; 
		String zPorRgnCd 		= ""; 
		String zPorStateCd 		= ""; 
		
		String zPolContiCd		= "";                                                      
		String zPolCntCd		= "";                                                      
		String zPolRgnCd		= "";                                                      
		String zPolStateCd		= "";                                                      
		
		String zDelContiCd		= "";                                                      
		String zDelCntCd		= "";                                                      
		String zDelRgnCd		= "";                                                      
		String zDelStateCd		= ""; 
		
		String zYrdContiCd		= "";                                                      
		String zYrdLoc			= "";                                                      
		String zYrdCntCd		= "";                                                      
		String zYrdRgnCd		= "";                                                      
		String zYrdStateCd		= "";                                                      
		String fixPodLoc		= "";
		String fixDelContiCd	= "";                                                                      
		String fixDelCntCd		= "";                                                                     
		String fixDelRgnCd		= "";                                                                      
		String fixDelStateCd	= "";                                                                       
		String fixDelLoc		= ""; 
		String zPorLoc			= "";                                                      
		String zPodLoc			= "";                                                      
		String zPolLoc			= "";                                                      
		String zDelLoc			= "";
		String zPostRly			= "";                                                      
		String zBcntrSpeDg		= "";                                                      
		String zBcntrSpeRf		= "";                                                      
		String zBcntrSpeAk		= "";                                                      
		String zBcntrSpeRd		= "";                                                      
		String zBcntrSpeBb		= "";                                                      
		String zBcntrSocInd		= "";                                                      
		String zBcntrPartial	= "";                                                      
		String zBcntrExcept		= "";		
		String zSalOfc			= "";                                                      
		String zSalRhq			= "";                                                      
		String zBcntrDlvTerm	= "";                                              
		String bkgCntCd			= "";                                                      
		String bkgRgnCd			= "";                                                      
		String bkgStateCd		= "";                                                      
		String bkgLocCd			= "";                                                      
		String zVslCd			= "";                                              
		String zSkdVoyageNo		= "";                                                      
		String zSkdDirCd		= "";                                                      
		String zVpsEtaDt		= "";                                                      
		String dtgEfftDt		= "";                                                      
		String fixDtgEfftDt		= "";   /*___ InBound VL Date */                                            
		String zDcsCntrTp		= "";                                                      
		String zDcsCgoTp		= "";                                                      
		
		//S/C
		String zBrhScNo			= "";                                                      
		String zBrhRfaNo		= "";                                                      
		
		//COMMODITY
		String zCmdtCd			= "";     
		String zRepCmdtCd		= "";                                                      
		
		String fixPolLoc		= "";
		String zPreRly			= "";
		
		String actCustCntCd  	= "";	
		long   actCustSeq     	= 0;        	                                     
		String awkInOut			= "";    
		
		String tmpTsp			= "";	
		String dualFlag 		= "N";
		
		//////////////////////END    변수 정의    /////////////////   

		/*
		[0.logic] Dual Type Exception 인지 확인하다. 
		*/
		
		/*
		[1.logic] Set DMDT_CNTR_TP_CD 
		*/
		
		zDcsCntrTp = settingDemDetContainerTypeCode( zCntrtsCd );
	
		/*		
		[2.logic] Booking Container 정보가져오기280
		*/
		BkgContainerInfoVO bkgContainerInfoVO = null;
		
		try {
			bkgContainerInfoVO = dbDao.searchBkgContainerInfo(zBkgNo  , zCntrNo  , zDcFmYdCd , "", zSvrId, zDttCode, zCnmvCycNo);
			log.debug("** searchBkgContainerInfo end ***");
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("Invalid BKG No ! : "+zBkgNo   +", "+ zCntrNo   +", "+ zDcFmYdCd);
			log.error("*******************************************************");
			throw new EventException("searchBkgContainerInfo Select Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		zBlNo 			= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBlNo());
		zBrhScNo 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getScNo());
		zBrhRfaNo 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRfaNo());
	
		zCmdtCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCmdtCd());
		zRepCmdtCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRepCmdtCd());
		zBcntrSpeDg 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDcgoFlg());
		zBcntrSpeRf 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRcFlg());
		log.debug("** zCmdtCd*zRepCmdtCd**"+zCmdtCd+zRepCmdtCd);
		zBcntrSpeAk 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAwkCgoFlg());
		zBcntrSpeRd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getRdCgoFlg());
		zBcntrSpeBb 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getBbCgoFlg());
		zBcntrSocInd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSocFlg());
		zBcntrPartial 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getCntrPrtFlg());
		zBcntrExcept 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getAdvShtgCd());

		zPorLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCd());
		
		zSalOfc 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getObSlsOfcCd());
		zSalRhq 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getSalRhq());
		
		log.debug("zBcntrPartial zBcntrExcept"+zBcntrPartial+zBcntrExcept+zSalOfc+zSalRhq);
		log.debug("zBlNo"+zBlNo);			
		/********************************************************************/
		zPorContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorContiCd());
		zPorCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorCntCd());
		zPorRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorRgnCd());
		zPorStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPorSteCd());
		
		zPolContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolContiCd());
		zPolCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolCntCd());
		zPolRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolRgnCd());
		zPolStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPolSteCd());
		
		zDelContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelContiCd());
		zDelCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelCntCd());
		zDelRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelRgnCd());
		zDelStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDelSteCd());
		
		
		zYrdContiCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdContiCd());
		zYrdCntCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdCntCd());
		zYrdRgnCd 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdRgnCd());
		zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getYrdSteCd());

		zPostRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPstRlyPortCd(), 5);
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getDeTermCd());
		zPreRly 		= DMTCalculationUtil.nullToString(bkgContainerInfoVO.getPreRlyPortCd(), 5);

			
		/*
		[3.logic] Cargo 타입 결정 : Set Cntr & Cgo Type
		*/
		containerCargoTypeParmVO_local.setDcgoFlg(zBcntrSpeDg);
		containerCargoTypeParmVO_local.setRcFlg(zBcntrSpeRf);
		containerCargoTypeParmVO_local.setAwkCgoFlg(zBcntrSpeAk);
		containerCargoTypeParmVO_local.setRdCgoFlg(zBcntrSpeRd);
		containerCargoTypeParmVO_local.setSocFlg(zBcntrSocInd);
		containerCargoTypeParmVO_local.setBbCgoFlg(zBcntrSpeBb);
		
		ContainerCargoTypeVO containerCargoTypeVO_local = settingContainerCargoType(containerCargoTypeParmVO_local);
		zDcsCgoTp = containerCargoTypeVO_local.getCgoTp();
		
		
		/*
		[4.logic] Booking I/O Bound Location 결정 :  Set In/Out Bound
		*/
		locationByBoundParmVO.setIoBnd(zDbcIoBnd);
		locationByBoundParmVO.setPorCntCd(zPorCntCd);
		locationByBoundParmVO.setPorRgnCd(zPorRgnCd);
		locationByBoundParmVO.setPorStateCd(zPorStateCd);
		locationByBoundParmVO.setPorLocCd(zPorLoc);
		
		locationByBoundParmVO.setDelCntCd(zDelCntCd);
		locationByBoundParmVO.setDelRgnCd(zDelRgnCd);
		locationByBoundParmVO.setDelStateCd(zDelStateCd);
		locationByBoundParmVO.setDelLocCd(zDelLoc);
		
		LocationByBoundVO locationByBoundVO = setLocationByBound(locationByBoundParmVO);
		bkgCntCd 		=	locationByBoundVO.getBkgCntCd();
		bkgRgnCd  		=	locationByBoundVO.getBkgRgnCd();
		bkgStateCd		=	locationByBoundVO.getBkgStateCd();
		bkgLocCd  		=	locationByBoundVO.getBkgLocCd();
		
		log.debug("bkgCntCd bkgRgnCd bkgStateCd bkgLocCd== "+bkgCntCd+" "+bkgRgnCd+" "+bkgStateCd+" "+bkgLocCd);
		/*
		[5.logic] POD Loc Fix
		*/
		fixPODLocationParmVO.setPodCd(zPodLoc);
		fixPODLocationParmVO.setDelCd(zDelLoc);
		fixPODLocationParmVO.setPostRly(zPostRly);
		fixPODLocationParmVO.setBkgNo(zBkgNo); //2010.03.26 
//    2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청			
		if ("TSP".equals(zLocDiv)){
			fixPodLoc = DMTCalculationUtil.nullToString(fixPODLocation(fixPODLocationParmVO), 5);
		}else{
			fixPodLoc = zPodLoc ;
		}
		
		if( !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPodLoc,5).substring(0,5)) && 
				 DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5)) &&  
			   ( DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("DEBRE") ||
			     DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPostRly,5).substring(0,5).equals("BEANR"))
			   && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD")	){
				
			return dualFlag;
		}

		/*
		[6.logic] POL Loc Fix
		*/
		fixPOLLocationParmVO.setPorCd(zPorLoc);
		fixPOLLocationParmVO.setPolCd(zPolLoc);
		fixPOLLocationParmVO.setPreRly(zPreRly);
		fixPOLLocationParmVO.setBkgNo(zBkgNo); //2010.03.26
			
//		    2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청	
		if ("TSP".equals(zLocDiv)){
			fixPolLoc = fixPOLLocation(fixPOLLocationParmVO);
		}else{
			fixPolLoc = zPolLoc ;
		}
		
		if( !DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(fixPolLoc,5).substring(0,5)) && 
				 DMTCalculationUtil.nullToString(zDcFmYdCd,5).substring(0,5).equals(DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5)) &&  
			   ( DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEHAM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("DEBRE") ||
			     DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("NLRTM") || DMTCalculationUtil.nullToString(zPreRly,5).substring(0,5).equals("BEANR"))
			    && DMTCalculationUtil.nullToString(zDcFmCnms,2).substring(0,2).equals("VD")	){				
					
			return dualFlag;
		}
		
		/*
		[7.logic] Booking의 VVD, ETA 가져오기 : Get VVD & ETA Date
		*/
		VVDNEtaVO vvEtaVO = null;
		try {
			vvEtaVO = searchVVDNEta(zBkgNo  , fixPolLoc, fixPodLoc, zDbcIoBnd);
			log.debug("** searchVVDNEta end ***");

			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo	= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
			zSkdDirCd		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
			zVpsEtaDt		= DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt());
			log.debug("**zVslCd ***"+zVslCd+zSkdVoyageNo+zSkdDirCd);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchVVDNEta Function Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchVVDNEta Function Error ! : " + new ErrorHandler(e).getMessage());
		}
			
		/*
		[8.logic] Tariff Effective Date 결정 : Set Tariff Effective Date
		*/
		if(zDbcIoBnd.substring(0, 1).equals("I") && zVpsEtaDt.length() != 0){
			dtgEfftDt = DMTCalculationUtil.nullToString(zVpsEtaDt,8).substring(0, 8);
		} else {
			dtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
		}
		
		log.debug("dtgEfftDt="+dtgEfftDt);
		
		/*
		[9.logic] Booking의 DEL Location 결정 :  BKG DEL Loc Fix
				특정 지역패턴(POD->DEL)에 따라, 기본적으로 DEL Tariff 를 POD Tariff 로 적용 시킬지 결정
				구주지역 T/S 대상인 경우, DEL Tariff를 POST/PRE RLY 로 적용
		*/
		
		fixDELLocationParmVO.setDmdtTrfCd(zDttCode);
		fixDELLocationParmVO.setPodCd(zPodLoc);
		fixDELLocationParmVO.setDelCd(zDelLoc);
		fixDELLocationParmVO.setDeTermCd(zBcntrDlvTerm);
		fixDELLocationParmVO.setFmMvmtStsCd(zDcFmCnms);
		fixDELLocationParmVO.setToMvmtStsCd(zDcToCnms);
		fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
		fixDELLocationParmVO.setTspFlag(tmpTsp);
		fixDELLocationParmVO.setPostRly(zPostRly);
		fixDELLocationParmVO.setPreRly(zPreRly);
		FixDELLocationVO fixDELLocationVO;
		
		try {
			fixDELLocationVO = fixDELLocation(fixDELLocationParmVO);
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("fixDELLocation Function Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("fixDELLocation Function Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		if(fixDELLocationVO.getMsgCd().equals("1")){
			fixDelContiCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelContiCd());
			fixDelCntCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCntCd());
			fixDelRgnCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelRgnCd());
			fixDelStateCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelSteCd());
			fixDelLoc		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCd()); 
		} 
		else if(fixDELLocationVO.getMsgCd().equals("0")){
			/* Not Changed */
			fixDelContiCd 	= zDelContiCd;
			fixDelCntCd 	= zDelCntCd;
			fixDelRgnCd 	= zDelRgnCd;
			fixDelStateCd 	= zDelStateCd;
			fixDelLoc 		= zDelLoc;
		}
		
		log.debug("***"+fixDelContiCd+"***"+fixDelCntCd+"***"+fixDelRgnCd+"***"+fixDelStateCd+"***"+fixDelLoc);
		
		/*
		[10.logic] Awkward In/Out-Gauge
		*/
		
		try {
			awkInOut = searchInOutGauge(zCntrNo  , zBkgNo  );
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchInOutGauge Function Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchInOutGauge Function Error ! : " + new ErrorHandler(e).getMessage());
		}

		/*
		[11.logic] OutBound first 'OCVL' Data Checking
		 */
		/*
		[logic] OutBound first 'OCVL' Data Checking
		*  SC  :: OutBound 1순위: OC DATE , 2순위:From Mvmt Date 
		*  SC  :: InBound  1순위: OC DATE , 2순위:POL ETA 
		*  RFA :: OutBound 1순위: POL ETA , 2순위:From Mvmt Date 
		*  RFA :: InBound  1순위: VL DATE , 2순위:POL ETA 
		*/
		log.debug("*******************************************************");
		log.debug("* [logic] OutBound first 'OCVL' Data Checking ");
		log.debug("*******************************************************");
		
		VVDNEtaVO polEta = new VVDNEtaVO();
		try {
			polEta 			= searchVVDNEta(zBkgNo, fixPolLoc, "", "I/O");	
		}catch(Exception e) {
			log.error("*******************************************************");
			log.error("searchVVDNEta Function Error !  " + e.getMessage());
			log.error("*******************************************************");
			throw new EventException("searchVVDNEta Function Error ! : " + new ErrorHandler(e).getMessage());
		}
		
		log.debug("*******************************************************");
		log.debug(" POL ETA DATE:: "+ DMTCalculationUtil.nullToString(polEta.getVpsEtaDt()));
		log.debug("*******************************************************");
		
		if( zDbcIoBnd.equals("I") ){ 	  
			if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {
				//[InBound SC CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound SC getMinOCVLDate Function Error !  "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("InBound SC getMinOCVLDate Function Error ! : " + new ErrorHandler(e).getMessage());
				}
				//OC Date가 없으면 POL ETA로 :: 2010.03.04
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				} 
				log.debug("*******************************************************");
				log.debug(" [InBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[InBound RFA CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "VL", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound RFA getMinOCVLDate Function  Error ! "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("InBound RFA getMinOCVLDate Function  Error ! " + new ErrorHandler(e).getMessage());
				}
				//VL Date가 없으면 POL ETA로 :: 2010.03.04
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				} 
				log.debug("*******************************************************");
				log.debug(" [InBound RFA CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			}
		} else { 		
			// OutBound  :: COPY: dtgEfftDt ===> fixDtgEfftDt 
			if(zBrhScNo.length() != 0 && zBrhRfaNo.length() == 0) {	
				//[OutBound SC CASE]
				try {
					fixDtgEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(zCntrNo, zCnmvCycNo, "OC", "VD"));
				}catch(Exception e) {
					log.error("*******************************************************");
					log.error("OutBound SC getMinOCVLDate Function Error !  "+e.getMessage());
					log.error("*******************************************************");
					throw new EventException("OutBound SC getMinOCVLDate Function Error ! : " + new ErrorHandler(e).getMessage());
				}
				//OC Date가 없으면 From Mvmt Date로 :: 2010.03.04
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound SC CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			} else if( zBrhRfaNo.length() != 0 ){
				//[OutBound RFA CASE]
				fixDtgEfftDt = DMTCalculationUtil.nullToString(polEta.getVpsEtaDt());
				//POL ETA가 없으면 From Mvmt Date로
				if(fixDtgEfftDt.length() == 0){
					fixDtgEfftDt = DMTCalculationUtil.nullToString(zDcFmDate,8).substring(0, 8);
				} 
				log.debug("*******************************************************");
				log.debug(" [OutBound RFA CASE]:: "+ fixDtgEfftDt);
				log.debug("*******************************************************");
			}
		}
		
		/*
		[12.logic] Get USC Exception Values
				1.RFA - 먼저 로직 수행
				2.SC  - RFA가 수행 후 N일 경우만 수행
		*/
		
		if(  zBrhRfaNo.length() != 0 ){
			List<DualTypeExceptionCustInfoVO> custList = null;
			try {
				custList = dbDao.getDualTypeExceptionCustInfoByRFA(zBrhRfaNo);
				if (custList!=null && custList.size()>0){
					log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA size>0 - "+(custList!=null?custList.size():0)+" @@@@@@@@@@@@@ \n\n");
					DualTypeExceptionCustInfoVO tmp = custList.get(0);
					log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA : DualTypeExceptionCustInfoVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						actCustCntCd 	= nullToString(tmp.getCustCntCd());
						actCustSeq 		= stringToLong(tmp.getCustSeq());
						log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA : actCustCntCd:"+tmp.getCustCntCd()+" / actCustSeq:"+tmp.getCustSeq()+" @@@@@@@@@@@@@ \n\n");
					}
				}
				else {log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoByRFA size=0 @@@@@@@@@@@@@ \n\n");}				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getDualTypeExceptionCustInfoByRFA Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDualTypeExceptionCustInfoByRFA Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			bfrExceptionParmVO.setDmdtTrfCd(zDttCode);                         
			bfrExceptionParmVO.setScNo(zBrhScNo);                   
			bfrExceptionParmVO.setRfaNo(zBrhRfaNo);                 
			bfrExceptionParmVO.setCntrTp(zDcsCntrTp);               
			bfrExceptionParmVO.setCgoTp(zDcsCgoTp);                 
			bfrExceptionParmVO.setIoBndCd(zDbcIoBnd);                 
			bfrExceptionParmVO.setEfftDt(fixDtgEfftDt);             
			bfrExceptionParmVO.setActCustCntCd(actCustCntCd); 
			bfrExceptionParmVO.setActCustSeq(String.valueOf(actCustSeq));
			bfrExceptionParmVO.setAwkInOut(awkInOut);
			
			bfrExceptionParmVO.setPorContiCd(zPorContiCd);
			bfrExceptionParmVO.setPorCntCd(zPorCntCd);
			bfrExceptionParmVO.setPorRgnCd(zPorRgnCd);
			bfrExceptionParmVO.setPorSteCd(zPorStateCd);
			bfrExceptionParmVO.setPorLocCd(zPorLoc);
			
			bfrExceptionParmVO.setYrdContiCd(zYrdContiCd);
			bfrExceptionParmVO.setYrdCntCd(zYrdCntCd);
			bfrExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			bfrExceptionParmVO.setYrdSteCd(zYrdStateCd);
			bfrExceptionParmVO.setYrdLocCd(zYrdLoc);

			bfrExceptionParmVO.setPolContiCd(zPolContiCd);                    
			bfrExceptionParmVO.setPolCntCd(zPolCntCd);                
			bfrExceptionParmVO.setPolRgnCd(zPolRgnCd);        
			bfrExceptionParmVO.setPolSteCd(zPolStateCd);
			bfrExceptionParmVO.setPolLocCd(zPolLoc);      
			
			bfrExceptionParmVO.setDelContiCd(zDelContiCd);                    
			bfrExceptionParmVO.setDelCntCd(zDelCntCd);                
			bfrExceptionParmVO.setDelRgnCd(zDelRgnCd);  
			bfrExceptionParmVO.setDelSteCd(zDelStateCd);
			bfrExceptionParmVO.setDelLocCd(zDelLoc);                   
			
			try {
				dualFlag = searchDualTypeExceptionByRFA(bfrExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("searchDualTypeExceptionByRFA Function Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchDualTypeExceptionByRFA Function Error ! : " + new ErrorHandler(e).getMessage());
			}
		}
			
		if(dualFlag.equals("") || dualFlag == null)	dualFlag = "N";
		
		if(zBrhScNo.length() != 0 && dualFlag.equals("N")) {
			List<DualTypeExceptionCustInfoVO> custList = null;
			try {
				custList = dbDao.getDualTypeExceptionCustInfoBySC(zBrhScNo);
				if (custList!=null && custList.size()>0){
					log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC size>0 - "+(custList!=null?custList.size():0)+" @@@@@@@@@@@@@ \n\n");
					DualTypeExceptionCustInfoVO tmp = custList.get(0);
					log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC : DualTypeExceptionCustInfoVO tmp "+tmp+"  @@@@@@@@@@@@@ \n\n");
					if (tmp!=null){
						log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC : actCustCntCd:"+tmp.getCustCntCd()+" / actCustSeq:"+tmp.getCustSeq()+" @@@@@@@@@@@@@ \n\n");
						actCustCntCd 	= nullToString(tmp.getCustCntCd());
						actCustSeq 		= stringToLong(tmp.getCustSeq());
					}
				}
				else {log.debug("\n\n @@@@@ dbDao.getDualTypeExceptionCustInfoBySC size=0 @@@@@@@@@@@@@ \n\n");}				
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("getDualTypeExceptionCustInfoBySC Select Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("getDualTypeExceptionCustInfoBySC Select Error ! : " + new ErrorHandler(e).getMessage());
			}
			
			
			scExceptionParmVO.setCustCntCd(actCustCntCd);
			scExceptionParmVO.setCustCd(String.valueOf(actCustSeq));
			
			scExceptionParmVO.setEfftDt(fixDtgEfftDt);
			scExceptionParmVO.setIoBndCd(zDbcIoBnd);
			scExceptionParmVO.setCntrTp(zDcsCntrTp);
			scExceptionParmVO.setCgoTp(zDcsCgoTp);
			
			scExceptionParmVO.setScNo(zBrhScNo);
			scExceptionParmVO.setDttCode(zDttCode);
			
			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setDelContiCd(zDelContiCd);
			scExceptionParmVO.setDelCntCd(zDelCntCd);
			scExceptionParmVO.setDelRgnCd(zDelRgnCd);
			scExceptionParmVO.setDelSteCd(zDelStateCd);
			scExceptionParmVO.setDelLocCd(zDelLoc);

			scExceptionParmVO.setPorContiCd(zPorContiCd);
			scExceptionParmVO.setPorCntCd(zPorCntCd);
			scExceptionParmVO.setPorRgnCd(zPorRgnCd);
			scExceptionParmVO.setPorSteCd(zPorStateCd);
			scExceptionParmVO.setPorLocCd(zPorLoc);
			
			scExceptionParmVO.setYrdContiCd(zYrdContiCd);
			scExceptionParmVO.setYrdCntCd(zYrdCntCd);
			scExceptionParmVO.setYrdRgnCd(zYrdRgnCd);
			scExceptionParmVO.setYrdSteCd(zYrdStateCd);
			scExceptionParmVO.setYrdLocCd(zYrdLoc);

			scExceptionParmVO.setPolContiCd(zPolContiCd);
			scExceptionParmVO.setPolCntCd(zPolCntCd);
			scExceptionParmVO.setPolRgnCd(zPolRgnCd);
			scExceptionParmVO.setPolSteCd(zPolStateCd);
			scExceptionParmVO.setPolLocCd(zPolLoc);
			
			scExceptionParmVO.setDelContiCd(zDelContiCd);
			scExceptionParmVO.setDelCntCd(zDelCntCd);
			scExceptionParmVO.setDelRgnCd(zDelRgnCd);
			scExceptionParmVO.setDelSteCd(zDelStateCd);
			scExceptionParmVO.setDelLocCd(zDelLoc);
			
			try {
				dualFlag = searchDualTypeExceptionBySC(scExceptionParmVO);
			}catch(Exception e) {
				log.error("*******************************************************");
				log.error("searchDualTypeExceptionBySC Function Error !  "+e.getMessage());
				log.error("*******************************************************");
				throw new EventException("searchDualTypeExceptionBySC Function Error ! : " + new ErrorHandler(e).getMessage());
			}
		} 
		
		if(dualFlag.equals("") || dualFlag == null)	dualFlag = "N";
		
		return dualFlag;
	} 
	
	
	/**
	 *  searchDualTypeExceptionBySC 대한 해당 데이터를 조회한다.
	 * 
	 * @param SCExceptionParmVO scExceptionParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchDualTypeExceptionBySC(SCExceptionParmVO scExceptionParmVO) throws EventException, DAOException {
		String  dualflag = "";

//		String	prmIoBnd		= nullToString(scExceptionParmVO.getIoBndCd());
		String	prmCntrTp		= nullToString(scExceptionParmVO.getCntrTp());
		String	prmCgoTp		= nullToString(scExceptionParmVO.getCgoTp());
		
//		String	prmPolContiCd	= nullToString(scExceptionParmVO.getPolContiCd());
//		String	prmPolCntCd		= nullToString(scExceptionParmVO.getPolCntCd());
//		String	prmPolRgnCd		= nullToString(scExceptionParmVO.getPolRgnCd());
//		String	prmPolStateCd	= nullToString(scExceptionParmVO.getPolStateCd());
//		String	prmPolLoc		= nullToString(scExceptionParmVO.getPolLocCd());
		
//		String	prmDelContiCd	= nullToString(scExceptionParmVO.getDelContiCd());
//		String	prmDelCntCd		= nullToString(scExceptionParmVO.getDelCntCd());
//		String	prmDelRgnCd		= nullToString(scExceptionParmVO.getDelRgnCd());
//		String	prmDelStateCd	= nullToString(scExceptionParmVO.getDelStateCd());
//		String	prmDelLoc		= nullToString(scExceptionParmVO.getDelLocCd());
		
		
		String		prmCntrCgoTp	= "";
//		String		parContiCd		= "";
//		String		parCntCd		= "";
//		String		parRgnCd		= "";
//		String		parStateCd		= "";
//		String		parLoc			= "";
	                                                
			
		/*------------------------------- CNTR & CGO Type Setting */

		if( prmCntrTp.equals("D")){
			if( prmCgoTp.equals("DRY") || prmCgoTp.equals("AWK") ){
//				prmCntrCgoTp = "1";     
				prmCntrCgoTp = "D";	// 20100107 수정 
			} else if( prmCgoTp.equals("DGR") ){
//				prmCntrCgoTp = "4";		
				prmCntrCgoTp = "S";	// 20100107 수정
			} else {
				return	dualflag;
			}
		} else if( prmCntrTp.equals("R"))	{
			if( prmCgoTp.equals("DRY")){
//				prmCntrCgoTp = "2";
				prmCntrCgoTp = "F";	// 20100107 수정	
			} else if( prmCgoTp.equals("RFR")){
//				prmCntrCgoTp = "3";
				prmCntrCgoTp = "R";	// 20100107 수정	
			} else {
				return	dualflag;
			}
		} else if( prmCntrTp.equals("F") || prmCntrTp.equals("T") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P") ){
//			prmCntrCgoTp = "4";
			prmCntrCgoTp = "S";	// 20100107 수정	
		} else {
			return	dualflag;
		}
		
		scExceptionParmVO.setCntrCgoTp(prmCntrCgoTp);
		dualflag = dbDao.searchDualTypeExceptionBySC(scExceptionParmVO);
		
		return 	dualflag;
	}
	
	/**
	 *  searchDualTypeExceptionByRFA 대한 해당 데이터를 조회한다.
	 * 
	 * @param BFRExceptionParmVO bfrExceptionParmVO
	 * @return String
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public String searchDualTypeExceptionByRFA(BFRExceptionParmVO bfrExceptionParmVO) throws EventException, DAOException {
		String  dualflag = "";

//		DmtBFRGrpVO dmtBFRGrpVO = new DmtBFRGrpVO();
		
		String		prmScNo			= nullToString(bfrExceptionParmVO.getScNo());
		String		prmRfaNo		= nullToString(bfrExceptionParmVO.getRfaNo());
		String		prmCntrTp		= nullToString(bfrExceptionParmVO.getCntrTp());
		String		prmCgoTp		= nullToString(bfrExceptionParmVO.getCgoTp());
		String		actCustCntCd	= nullToString(bfrExceptionParmVO.getActCustCntCd());
		long   		actCustSeq    	= stringToLong(bfrExceptionParmVO.getActCustSeq()); 
		String		prmAwkInOut		= nullToString(bfrExceptionParmVO.getAwkInOut());
		
		
		/*------------------------------- CNTR & CGO Type Adjust */
		if(prmCntrTp.equals("D")){
			if(	prmCgoTp.equals("AWK") ||	prmCgoTp.equals("B/B") ||	prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("T")){
			if(prmCgoTp.equals("SOC")){
				prmCgoTp = "DRY";
			}
		}
		if(prmCntrTp.equals("R")){
			if(	prmCgoTp.equals("AWK") || prmCgoTp.equals("DGR") ){
				prmCgoTp = "DRY";
			}
		}
		if(	!prmCntrTp.equals("D") && !prmCntrTp.equals("R") &&	prmCgoTp.equals("AWK")){
			if(prmAwkInOut.equals("I")){
				prmCgoTp = "DRY";
			}
			else if(prmAwkInOut.equals("O")){
				prmCgoTp = "AWK";
			}
		}
		if(	prmCntrTp.equals("F") || prmCntrTp.equals("O") || prmCntrTp.equals("C") || prmCntrTp.equals("P")){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			}
		}
		if( prmCntrTp.equals("F") ){
			if( prmCgoTp.equals("B/B")){
				prmCgoTp = "AWK";
			}else if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("O") || prmCntrTp.equals("C") ){
			if( prmCgoTp.equals("SOC") ){
				prmCgoTp = "DRY";
			}
		}
		if( prmCntrTp.equals("S") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "O";
			}
		}
		if( prmCntrTp.equals("A") ){
			if( prmCgoTp.equals("DGR") ){
				prmCntrTp = "D";
			} else {
				prmCntrTp = "F";
			}
		}

		/* -------------------------------------- Set Searching Key */

		if( prmScNo.length() == 0 && prmRfaNo.length() == 0 ){
			return	dualflag;
		} else if( prmScNo.length() != 0 && prmRfaNo.length() != 0 ) {
			actCustCntCd = "" ;
			actCustSeq	= 0;
			log.debug("actCustCntCd actCustSeq== "+actCustCntCd+" "+actCustSeq);
		} else if( prmScNo.length() != 0 && prmRfaNo.length() == 0  ) {
			;
		} else if( prmScNo.length() == 0 && prmRfaNo.length() != 0 ) {
			;
		}
			
		bfrExceptionParmVO.setCntrTp(prmCntrTp);
		bfrExceptionParmVO.setCgoTp(prmCgoTp);
		
		dualflag = dbDao.searchDualTypeExceptionByRFA(bfrExceptionParmVO);
		
		return 	dualflag;
	}
	
	
	/**
	 *  getMinMovement 대한 해당 데이터를 조회한다.
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getMinMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getMinMovement(movementParmVO);
	}
	
	
	/**
	 *  getMaxMovement 대한 해당 데이터를 조회한다.
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getMaxMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getMaxMovement(movementParmVO);
	}
	
	
	/**
	 *  getPreMovement 대한 해당 데이터를 조회한다.
	 * 
	 * @param MovementParmVO movementParmVO
	 * @return MovementVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public MovementVO getPreMovement(MovementParmVO movementParmVO) throws EventException, DAOException {
		return dbDao.getPreMovement(movementParmVO);
	}
	
	
		
	/**
	 *   'F', 'L' charge 가 발생한 container에 대해서 collection office 를 변경 했는지 checking 하는 함수<BR>	 
	 *    
	 * @param String svrId
	 * @param String zCntrNo  
	 * @param long zCnmvCycNo   
	 * @param String zDttCode
	 * @param String zLocDiv
	 * @param long zDccSeq
	 * @return List<OfficeInfoVO>
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public List<OfficeInfoVO> isCntrOfcTrans(String svrId, String zCntrNo  , long zCnmvCycNo   ,
			String zDttCode, String zLocDiv, long zDccSeq) throws EventException, DAOException {
		 return dbDao.isCntrOfcTrans(svrId, zCntrNo  , zCnmvCycNo   ,	zDttCode, zLocDiv, zDccSeq);
	}
	
	/**
	 *  searchDMIFFreeTimeEndDate 대한 해당 데이터를 조회한다.
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDMIFFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo,
			String dmdtTrfCd, String dmdtChgLocDivCd, long chgSeq) throws EventException, DAOException {
		return dbDao.searchDMIFFreeTimeEndDate(svrId, cntrNo, cntrCycNo, dmdtTrfCd, dmdtChgLocDivCd, chgSeq);
	}
	
	/**
	 *  searchDTICFreeTimeEndDate 대한 해당 데이터를 조회한다.
	 * 
	 * @param String svrId
	 * @param String cntrNo
	 * @param long cntrCycNo
	 * @param String dmdtTrfCd
	 * @param String dmdtChgLocDivCd
	 * @param long chgSeq
	 * @return DMIFnDTICFreeTimeEndDateVO
	 * @throws EventException 
	 * @exception EventException
	 * @throws DAOException 
	 */
	public DMIFnDTICFreeTimeEndDateVO searchDTICFreeTimeEndDate(String svrId, String cntrNo, long cntrCycNo,
			String dmdtTrfCd, String dmdtChgLocDivCd, long chgSeq) throws EventException, DAOException {
		return dbDao.searchDTICFreeTimeEndDate(svrId, cntrNo, cntrCycNo, dmdtTrfCd, dmdtChgLocDivCd, chgSeq);
	}
	
	
	/**
	 * Charge가 Office Transfer 되기 전 최초의 SYS_AREA_GRP_ID 정보를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return String
	 * @exception DAOException
	 */	
	public String searchFirstSvrID(ChargeCalculationParmVO chargeCalculationParmVO) throws DAOException {
		return dbDao.searchFirstSvrID(chargeCalculationParmVO);
	}

	
	/**
	 *  paramter가 Null일 경우 문자열 ""(공백문자)를 리턴
	 * 
	 * @param String str
	 * @return String
	 */
	public static String nullToString (String str) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return "";
		else
			return  str;
	}

	/**
	 *  paramter가 Null일 경우 문자열 ""(공백문자)를 리턴
	 * 
	 * @param String str
	 * @return String
	 */
	public static String nullToInt (String str) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return "0";
		else
			return  str;
	}

	
	/**
	 *  String을 int 변환
	 * 
	 * @param String str
	 * @return int
	 */
	public static int stringToInt (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return (int) 0;
		else
			return  Integer.parseInt(str.trim());
	}

	/**
	 *  String을 long로 변환
	 * 
	 * @param String str
	 * @return long
	 */
	public static long stringToLong (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Long.parseLong(str.trim());
	}

	
	/**
	 *  String을 float로 변환
	 * 
	 * @param String str
	 * @return float
	 */
	public static float stringToFloat (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Float.parseFloat(str.trim());
	}


	/**
	 *  String을 double로 변환
	 * 
	 * @param String str
	 * @return double
	 */
	public static double stringToDouble (String str) 
	{
		if (str == null || str.trim().length() < 1)
			return 0;
		else
			return  Double.parseDouble(str.trim());
	}
	
	 /**
     * 널 값 또는 전달 받은 값에 <br> 
     * space를 넣어서 지정한 길이를 만든다
     *
     * @param String str
     * @param int size
     * @return String
     */
	public static String nullToString (String str, int size) 
	{
		if (str == null||(str.equals(""))||(str.equals("null")) )
			return fillSpace("", size);
		else
			return  fillSpace(str, size);
	}
	
	 /**
     * 전달받은 문자열에 space를 넣어서 지정한 길이를 만든다
     *
     * @param String des
     * @param int size
     * @return String
     */
    public static String fillSpace( String des, int size )
    {
        StringBuffer str = new StringBuffer();

        if ( des == null ) {
            for ( int i = 0; i < size; i++ )
                str.append( " " );
            return str.toString();
        }

        if ( des.trim().length() > size )
            return des.substring( 0, size );
        else
            des = des.trim();

        byte[] bDes = des.getBytes();
        int diffsize = size - bDes.length;
        str.append( des );

        for ( int i = 0; i < diffsize; i++ ) {
            str = str.append( " " );
        }

        return str.toString();
    }
    
    /**
     * 특정문자형 날짜형식의 특별한 타입의 일정량을 증가하거나 감소한 문자열을 반환( yyyymmdd )
     *
     * @param String date
     * @param int type
     * @param int amt
     * @return String
     */
    public static String getAddDate( String date, int type, int amt )
    {

        // 캘린더 객체 생성
        Calendar cal = Calendar.getInstance();

        // 문자열 날짜로 변환하여 시간 세팅
        cal.setTime( getDate( date ) );
        // 더함
        cal.add( type, amt );

        return getDate( cal.getTime() );

    }

    /**
     * 설정된 날자정보의 yyyymmdd형의데이타를 반환
     * @param   Date date
     * @return String
     */
    public static String getDate( Date date )
    {
        return new SimpleDateFormat( "yyyyMMdd" ).format( date );
    }
    
    /**
     * yyyymmdd형식에 맞는 스트링 형식의 날짜를
     * Date 객체로 생성하여 반환함
     *
     * @param   String date
     * @return Date
     */
    public static Date getDate( String date )
    {

        // 연월일 분리
        int year = Integer.parseInt( date.substring( 0, 4 ) );
        int month = Integer.parseInt( date.substring( 4, 6 ) ) - 1;
        int day = Integer.parseInt( date.substring( 6, 8 ) );

        // 캘린더 객체 생성 및 세팅
        Calendar cal = Calendar.getInstance();
        cal.set( year, month, day, 0, 0, 0 );

        return cal.getTime();

    }

    /**
     * 첫번째 인자의 날짜를 기준으로 두 번째 인자의 일 수를 더한 yyyymmdd 형태의 날짜를 반환
     *
     * @param String ymd
     * @param int day
     * @return String
     */
    public static String getAddDateByDay( String ymd, int day )
    {
        return getAddDate( ymd, Calendar.DATE, day );
    }
    
    /**
	 * Basic Tariff Effective Date를 찾는다.
	 * @param BasicTariffParmVO basicTariffParmVO
	 * @return String
	 * @exception EventException
	 */
    public String getEfftDt( BasicTariffParmVO basicTariffParmVO ) throws EventException
    {
    	String	rtnEfftDt = "";
    	String	prmPolCntCd = "";
    	String	prmPodCntCd = "";
    	
    	String  prmIoBndCd = nullToString(basicTariffParmVO.getIoBndCd());
    	
    	if (basicTariffParmVO.getPolLocCd().length() >= 2) {
	    	prmPolCntCd = nullToString(basicTariffParmVO.getPolLocCd()).substring(0, 2);
	    	prmPodCntCd = nullToString(basicTariffParmVO.getPodLocCd()).substring(0, 2);
	    }
    	
    	String	prmVpsEtaDt = nullToString(basicTariffParmVO.getVpsEtaDt());
    	String	prmCntrNo = nullToString(basicTariffParmVO.getCntrNo());
    	long  prmCnmvCycNo = stringToLong(basicTariffParmVO.getCnmvCycNo());
    	String  prmFmDate = nullToString(basicTariffParmVO.getFmDate());
    	
    	log.debug("*************************************");
		log.debug("* [logic] Basic Effective Date      *");
		log.debug("*************************************");
		log.debug("[getEfftDt(param)] prmIoBndCd 	: " + prmIoBndCd);
		log.debug("[getEfftDt(param)] prmPolCntCd 	: " + prmPolCntCd);
		log.debug("[getEfftDt(param)] prmPodCntCd 	: " + prmPodCntCd);
		log.debug("[getEfftDt(param)] prmVpsEtaDt 	: " + prmVpsEtaDt);
		log.debug("[getEfftDt(param)] prmCntrNo 	: " + prmCntrNo);
		log.debug("[getEfftDt(param)] prmCnmvCycNo 	: " + prmCnmvCycNo);
		log.debug("[getEfftDt(param)] prmFmDate 	: " + prmFmDate);
		
		if(prmIoBndCd.equals("I") && prmVpsEtaDt.length() != 0){
			if (prmPolCntCd.equals("US") || prmPolCntCd.equals("CA") || prmPodCntCd.equals("US") || prmPodCntCd.equals("CA")){
				/* CHM-201222196 : [DMT] Basic Tariff 및 Commodity Exception Tariff의 Effective Date 적용 기준 변경
				 * FMC 규정에 의하면 미국 및 캐나다 수출입 화물의 경우에 Charge 부과 기준일은 OC date 이지만, 현재 DEM/DET System Logic은 Inbound Charge 계산 시 POD_ETA를 기준으로 함.
				 * 따라서 Booking의 POL 또는 POD가 미국 혹은 캐나다인 경우에는 OC date를 기준으로 Charge가 부과 되도록 변경함.
				*/
				try {
					rtnEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(prmCntrNo, prmCnmvCycNo, "OC", "VD"));
					log.debug("[getEfftDt(Org-OC)] EfftDt : " + rtnEfftDt);
				} catch(Exception e) {
					log.error("*******************************************************");
					log.error("InBound getMinOCVLDate Error! [001]");
					log.error("*******************************************************");
					throw new EventException("InBound getMinOCVLDate Error!   " + new ErrorHandler(e).getMessage());
				}
				
				if(rtnEfftDt.length() == 0){
					/* CHM-201222196 : 추가적으로 Advance Booking일 경우 이전 ( Cycle No - 1 ) Cycle 의 OC의 Event Date 사용.
					 * Advance Booking 이란? 80% 정도가  대부분 한국 지역에 발생하며 Temp성 Booking을 생성하여 Movement 발생시킨 이후
					 *                      OP 이후에 실제 Booking No.가 맵핑이 되는 경우를 말한다.
					 * 따라서, 입력된 Cycle No가 없을 경우에 이전 Cycle No.의 OC를 참조하게 한다.
					 * 참고 : Cycle No.변경은 Booking No. 및 Truck VVD 변경시에 Cycle No가 증가한다.
					 */
					
					try {
						rtnEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(prmCntrNo, prmCnmvCycNo - 1, "OC", "VD"));
						log.debug("[getEfftDt(Pre-OC)] EfftDt : " + rtnEfftDt);
					} catch(Exception e) {
						log.error("*******************************************************");
						log.error("InBound getMinOCVLDate Error!  ");
						log.error("*******************************************************");
						throw new EventException("InBound getMinOCVLDate Error! [002]" + new ErrorHandler(e).getMessage());
					}
					
					if(rtnEfftDt.length() == 0){
						/* CHM-201222196 : 추가적으로 이전 Cycle No.에서까지 OC를 찾지 못할 경우에 입력된 Cycle No.에 VL의 Event Date 사용.
						 * 
						 */
						try {
							rtnEfftDt = DMTCalculationUtil.nullToString(getMinOCVLDate(prmCntrNo, prmCnmvCycNo, "VL", "VD"));
							log.debug("[getEfftDt(VL)] EfftDt : " + rtnEfftDt);
						} catch(Exception e) {
							log.error("*******************************************************");
							log.error("InBound getMinOCVLDate Error!  ");
							log.error("*******************************************************");
							throw new EventException("InBound getMinOCVLDate Error! [003]" + new ErrorHandler(e).getMessage());
						}
					}
				}
			}
			else {
				rtnEfftDt = DMTCalculationUtil.nullToString(prmVpsEtaDt,8).substring(0, 8);
			}
			
			if(rtnEfftDt.trim().length() == 0){
				/**********************************************************************************************************************************
				 * In-Bound 중에 Booking/POD에 해당하는 VVD가 존재하지 않는 경우가 존재함. BKG No. : TEM300099700 CNTR No. : BMOU2922316
				 * Ex) VD-TS-EN/TN
				 *     EN/TN 위치에 Booking/POD에 해당하는 VD가 발생해야 하지만, 아래와 같은 사유로 VD가 발생하지 않고 있음
				 *     BKG_VVD 테이블에  Post VVD가 존재하지만 실제 Post(Feeder) VVD를 할당 하지 않아 Vessel Schedule를 찾지 못하는 문제에 대해 보완한다.
				 * 사유 : Port EQ 및 세관 Clearance등의 이유로 T/S port (BEANR, NLRTM, DEHAM, DEBRV)에서
				 *       VD후 POD까지 Barge로 운송함에 따라 BKG의 F/VVD Update 불가함에 따라
				 *       현재 발생하는 DMIF/DTIC 에러 (Basic Tariff error)에 대하여 보완
				 * 보완 : ETB Date를 찾지 못할 경우 From Movement Date를 사용하도록 한다.
				/**********************************************************************************************************************************/
				rtnEfftDt = DMTCalculationUtil.nullToString(prmFmDate,8).substring(0, 8);
				log.debug("[getEfftDt(From Mvmt)] EfftDt : " + rtnEfftDt);
			} 
			
		} else {
			rtnEfftDt = DMTCalculationUtil.nullToString(prmFmDate,8).substring(0, 8);
		}
		
		log.debug("[getEfftDt(return)] rtnEfftDt : " + rtnEfftDt);
		
		return rtnEfftDt;
    }
    
    
    
    /**
	 * 두 날짜를 비교해서 유효여부를 체크한다.
	 * 현재일이 종료일보다 크다면 false, 그렇지 않다면 true 를 반환한다.
	 * @param String curDt (현재일)
	 * @param String endDt (종료일)
	 * @return boolean
	 */    
    private boolean isValidateDate(String curDt, String endDt) {
    	
    	boolean isValid = false;
    	
    	if (!StringUtils.isEmpty(curDt) && curDt.length() >= 8 && !StringUtils.isEmpty(endDt) && endDt.length() >= 8) {

	    	int iCurYear  = Integer.valueOf(curDt.substring(0, 4));
	    	int iCurMonth = Integer.valueOf(curDt.substring(4, 6))-1;
	    	int iCurDay   = Integer.valueOf(curDt.substring(6, 8));
	    	
	    	int iEndYear  = Integer.valueOf(endDt.substring(0, 4));
	    	int iEndMonth = Integer.valueOf(endDt.substring(4, 6))-1;
	    	int iEndDay   = Integer.valueOf(endDt.substring(6, 8));
	
	    	Calendar curCal = Calendar.getInstance();
	    	curCal.set(iCurYear, iCurMonth, iCurDay);
	
	    	Calendar endCal = Calendar.getInstance();
	    	endCal.set(iEndYear, iEndMonth, iEndDay);

	    	isValid = !curCal.after(endCal);
    	}

    	return isValid;
    }
    
}