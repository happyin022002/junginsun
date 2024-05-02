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
* 2010.09.06 유병희 [] [EES-DMT] CSR 요청에 의해 Billable 금액이 (-)면 0으로 설정하거나, 아니면 원래 그대로 trim하기 적용 
* 2010.10.26 황효근 [CHM-201006671-01] [EES-DMT] T/S Demurrage Free Time 변경
* 2010.11.01 황효근 [CHM-201006866-01] [EES-DMT] T/S Demurrage Free Time 재조정
* 2010.11.12 김태균 [CHM-201006793-01] 소스 결함 관련 수정
* 2010.12.06 김태균 [CHM-201006976-01] [EES-DMT] EES_DMT_2010 Time Clock Stop Creation 시 YARD 추가
* 2011.03.31 김태균 [CHM-201109458-01] [DMT] T/S BKG의 T/S 미실행(육상운송) CNTR의 Port DEM 생성 Logice 보완
* 2011.07.25 김경섭 [] [DMT] if(zBrhScNo.length() != 0) >> if(zBrhScNo.length() != 0  && zBrhRfaNo.length() == 0)로 수정
* 2012.02.15 김현화 [CHM-201216125] Time Clock Stop 기능 보완 
* 2012.03.19 김현화 [CHM-201216014-01]Time Clock Stop 기능 보완:freeTimeStart/freeTimeEnd/overday 관련 Term cd 변경(BKG_CONTAINER정보)
* 2012.06.04 김현화 [CHM-201217905-01]유럽지역 TS DMIF 생성 중단 요청 :  DMDT_CHG_LOC_DIV_CD = 'TSP'이면  fixedpod, fixedpol를 호출, 그외는 호출하지 않음
* 2012.07.16 김현화 [CHM-201218768-01]Exempted Error Charge 생성 중지.( searchBasicTariffByGeneration )
* 2013.01.31 임창빈 [CHM-201222196]
*            [DMT] Basic Tariff 및 Commodity Exception Tariff의 Effective Date 적용 기준 변경
*            Basic Tariff 및 Commodity Exception Tariff 적용 시 Inbound Charge(DMIF, DTIC, CTIC)의 경우에는 Effective Date 적용 기준을 아래와 같이 변경 
*            [AS-IS] POD_ETA 
*            [TO-BE] POD가 ‘US’ or ‘CA’이면 OC date, 그 외에는 POD_ETA 
*            - 사유 : FMC 규정에 의거 미국 및 캐나다 수출입 화물의 경우에는 Charge 부과 기준일이 OC date 임 (하지만 현재 시스템 로직은 POD_ETA를 기준으로 하고 있음) 
*            - 기타 : Outbound Charge의 경우 DTOC 및 CTOC는 OP date, DMOF는 OC date를 기준으로 Charge 계산하고 있음 
* 2013.02.28 임창빈 [CHM-201322954] 
*            [DMT] 신규 장비에 대한 DMT charge 청구를 위한 Table Mapping 요청
* TP/SZ  Description                          CGP TYPE   CNTR Size 
*--------------------------------------------------------------------
*  C2    20FT COIL RACK CONTAINER            Open Top   20FT 
*  C4    40FT COIL RACK CONTAINER            Open Top   40FT 
*  R8    LIVE FISH CONTAINER                 Reefer     R9 
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.interfacefreetime.vo.IfFtVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.integration.DMTCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BKGRequestInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffKeyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.BasicTariffParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ContainerCargoTypeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FixDELLocationVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeEndParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeStartParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.FreeTimeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.OfficeInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * General calculation 함수 <br>
 *
 * @author Choi Sung Hwan
 * @see DMTCalculationDBDAO 클래스 참조
 * @since J2EE 1.6
 */
public class DMTFreeTimeChargeCalculationUtil {
	
	// Database Access Object
	public transient DMTCalculationDBDAO dbDao = null; 
	protected transient Logger log = null;
	
	DMTCalculationUtil dmtCalculationUtil = new DMTCalculationUtil();
	/**
	 * DMTCalculationUtil 객체 생성<br>
	 * DMTCalculationDBDAO 생성한다.<br>
	 */
	public DMTFreeTimeChargeCalculationUtil() {
		dbDao = new DMTCalculationDBDAO();
		log = Logger.getLogger(getClass().getName());
	}
	
	
	/**
	 *  Free Time Charge Calculation 대한 해당 데이터를 조회한다.
	 * 
	 * @param ChargeCalculationParmVO chargeCalculationParmVO
	 * @return IfFtVO
	 * @exception EventException
	 * @throws DAOException 
	 */
	public IfFtVO searchFtOfIbDm(IfFtCondVO condVO) throws EventException, DAOException {

		// Result VO
		IfFtVO ifFtVO = new IfFtVO();
		
		//parameter values
		ContainerCargoTypeParmVO 	containerCargoTypeParmVO 	= new ContainerCargoTypeParmVO();
		FixDELLocationParmVO 		fixDELLocationParmVO 		= new FixDELLocationParmVO();
		BasicTariffParmVO 			basicTariffParmVO 			= new BasicTariffParmVO();
	
		log.debug("*******************************************************");
		log.debug("[ searchFtOfIbDm ]>> condVO :"   + condVO.toString());
		log.debug("*******************************************************");
		
		// 전달 매개변수의 지역변수 부분 
		String zBkgNo       = condVO.getBkgNo();
		String zCntrNo      = condVO.getCntrNo();
		String zDcFmYdCd  	= condVO.getFmMvmtYdCd();
		String zDcFmDate    = condVO.getFmMvmtDt();
		String zDcFmCnms   	= condVO.getFmMvmtStsCd();
		
		// 출력에 대한 기본 설정
		ifFtVO.setBkgNo(zBkgNo);
		ifFtVO.setCntrNo(zCntrNo);
		// Inland or Port 여부
		ifFtVO.setDmdtChgLocDivCd(condVO.getDmdtChgLocDivCd());
		// Movement 정보
		ifFtVO.setFmMvmtStsCd(zDcFmCnms);
		ifFtVO.setFmMvmtDt(zDcFmDate);
		ifFtVO.setFmMvmtYdCd(zDcFmYdCd);
		
		log.debug("*******************************************************");
		log.debug("[ searchFtOfIbDm ]>> zBkgNo :"   + zBkgNo);
		log.debug("[ searchFtOfIbDm ]>> zCntrNo :"  + zCntrNo);
		log.debug("[ searchFtOfIbDm ]>> zDcFmYdCd :"+ zDcFmYdCd);
		log.debug("[ searchFtOfIbDm ]>> zDcFmDate :"+ zDcFmDate);
		log.debug("[ searchFtOfIbDm ]>> zDcFmCnms :"+ zDcFmCnms);
		log.debug("*******************************************************");
		
		//////////////////////START    변수 정의    /////////////////
		String zDttCode     = "";
		String zCntrtsCd    = "";
		String zDbcIoBnd   	= "";
		
		String zPorContiCd 	= ""; 
		String zPorCntCd 	= ""; 
		String zPorRgnCd 	= ""; 
		String zPorStateCd 	= ""; 
		
		String zPolContiCd	= "";                                                      
		String zPolCntCd	= "";                                                      
		String zPolRgnCd	= "";                                                      
		String zPolStateCd	= "";                                                      
		
		String zDelContiCd	= "";                                                      
		String zDelCntCd	= "";                                                      
		String zDelRgnCd	= "";                                                      
		String zDelStateCd	= "";                                                      
		
		String zYrdContiCd	= "";                                                      
		String zYrdLoc		= "";                                                      
		String zYrdCntCd	= "";                                                      
		String zYrdRgnCd	= "";                                                      
		String zYrdStateCd	= "";                                                      
		
		String fixPodLoc	= "";                                                                                      
		
		String fixDelContiCd= "";                                                                      
		String fixDelCntCd	= "";                                                                     
		String fixDelRgnCd	= "";                                                                      
		String fixDelStateCd= "";                                                                       
		String fixDelLoc	= "";    
		
		String zPorLoc		= "";                                                      
		String zPodLoc		= "";                                                      
		String zPolLoc		= "";                                                      
		String zDelLoc		= "";                                                      
		
		String zPostRly		= "";                                                      
		String zBcntrSpeDg	= "";                                                      
		String zBcntrSpeRf	= "";                                                      
		String zBcntrSpeAk	= "";                                                      
		String zBcntrSpeRd	= "";                                                      
		String zBcntrSpeBb	= "";                                                      
		String zBcntrSocInd	= "";                                                      
		
		String zBcntrDlvTerm= "";                                              
		String bkgCntCd		= "";                                                      
		String bkgRgnCd		= "";                                                      
		String bkgStateCd	= "";                                                      
		String bkgLocCd		= "";                                                      
		String zVslCd		= "";                                              
		String zSkdVoyageNo	= "";                                                      
		String zSkdDirCd	= "";                                                      
		String zVpsEtaDt	= "";
		String zClptIndSeq  = "";
		String dtgEfftDt	= "";                                                      
		String zDcsCntrTp	= "";                                                      
		String zDcsCgoTp	= "";                                                      
		long   zDbcBkgQty	= 0;    
		
		long   zDtnSeq		= 0;
		String zDmdtDeTermCd= "";
		long   zDtgGrpId	= 0;                                             
		String dtgCmncTp	= "";                                                      
		String dtgCmncHr	= "";                                                      
		String dtgExclSat	= "";                                                      
		String dtgExclSun	= "";                                                      
		String dtgExclHoli	= "";                                                      
                                              
		long   zDcFtDays	= 0;                                           
		
		String fixPolLoc	= "";
		String zPreRly		= "";
		
		/* -------------------------------------------  */
		String awkInOut		= "";   /* In/Out-Gauge		*/ 
		String zSvrId 		= "";

		String zOrgContiCd	= "";
		String zOrgCntCd	= "";
		String zOrgRgnCd	= "";
		String zOrgStateCd	= "";
		String zOrgLocCd	= "";


		//////////////////////END    변수 정의    /////////////////    
		
		
		BKGRequestInfoVO bkgRequestInfoVO = null;
		
		//*****************************************************************************
		// 1. Booking 정보 조회
		//*****************************************************************************		
		try {
			bkgRequestInfoVO = dbDao.searchBKGRequestInfo(zBkgNo, zCntrNo, zDcFmYdCd);
		}
		catch(Exception e) {
			String ftRmk = "Invalid BKG No (BKG No. : "+zBkgNo +", CNTR No. : "+ zCntrNo +", From Movement Yard : "+ zDcFmYdCd + ")! : " + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;
		}
		
		zBcntrSpeDg 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDcgoFlg());
		zBcntrSpeRf 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRcFlg());
		
		zBcntrSpeAk 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getAwkCgoFlg());
		zBcntrSpeRd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getRdCgoFlg());
		zBcntrSpeBb 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBbCgoFlg());
		zBcntrSocInd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getSocFlg());
		
		zPorLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCd());
		zPolLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCd());
		zPodLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPodCd());
		zDelLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCd());
		zYrdLoc 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCd());
		
		/********************************************************************/
		zPorContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorContiCd());
		zPorCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorCntCd());
		zPorRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorRgnCd());
		zPorStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPorSteCd());
		
		zPolContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolContiCd());
		zPolCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolCntCd());
		zPolRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolRgnCd());
		zPolStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPolSteCd());
		
		zDelContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelContiCd());
		zDelCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelCntCd());
		zDelRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelRgnCd());
		zDelStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDelSteCd());
		
		zYrdContiCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdContiCd());
		zYrdCntCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdCntCd());
		zYrdRgnCd 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdRgnCd());
		zYrdStateCd 	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getYrdSteCd());

		zPostRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPstRlyPortCd(), 5);
		zBcntrDlvTerm	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDeTermCd());
		zPreRly 		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getPreRlyPortCd(), 5);

		zBkgNo	    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getBkgNo());
		zCntrNo   		= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrNo());
		zCntrtsCd     	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getCntrTpszCd(), 1);
		zDbcIoBnd    	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getIoBndCd(), 1);
		zDttCode      	= DMTCalculationUtil.nullToString(bkgRequestInfoVO.getDmdtTrfCd());		
		
		
		//*****************************************************************************
		// 2. Container Type 설정
		//*****************************************************************************
		zDcsCntrTp = dmtCalculationUtil.settingDemDetContainerTypeCode(zCntrtsCd);
	
		
		//*****************************************************************************
		// 3. Container & Cargo Type 설정
		//*****************************************************************************
		containerCargoTypeParmVO.setDcgoFlg(zBcntrSpeDg);
		containerCargoTypeParmVO.setRcFlg(zBcntrSpeRf);
		containerCargoTypeParmVO.setAwkCgoFlg(zBcntrSpeAk);
		containerCargoTypeParmVO.setRdCgoFlg(zBcntrSpeRd);
		containerCargoTypeParmVO.setSocFlg(zBcntrSocInd);
		containerCargoTypeParmVO.setBbCgoFlg(zBcntrSpeBb);
		ContainerCargoTypeVO containerCargoTypeVO = dmtCalculationUtil.settingContainerCargoType(containerCargoTypeParmVO);
		zDcsCgoTp = containerCargoTypeVO.getCgoTp();
		

		//*****************************************************************************
		// 4. Collection Office 설정
		//*****************************************************************************
		String zOfcCd	= "";                                              
		
		OfficeInfoVO officeInfoVO = null;
		
		try {
			officeInfoVO = dbDao.searchOfficeInfoByFmYardCd(zDbcIoBnd, zDcFmYdCd);
		}
		catch(Exception e) {
			String ftRmk = "(From Yard)[Exception]>> DEM/DET Office Select Error ! : " + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;			
		}
		
		if (StringUtils.isEmpty(officeInfoVO.getCollectYn())) {
			String ftRmk = "(From Yard)DEM/DET Office Skip ! : ("+zDcFmYdCd+ " )";
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;	
		} 
		else {
			if ("N".equals(officeInfoVO.getCollectYn()) && "DM".equals(zDttCode.substring(0, 2))) {
				String ftRmk = "(From Yard) DEM/DET Collection Mark is No for yard " + officeInfoVO.getOfcCd() + " " + zDcFmYdCd;
				ifFtVO.setFtRmk(ftRmk);
				return ifFtVO;	
			} 
			else {
				//위 조건에 해당하지 않으면 Charge Calculation 시의 Office 와 RHQ 를 Setting 한다.
				zOfcCd = officeInfoVO.getOfcCd();
			}
		}		
		//*****************************************************************************
		// 5. Booking 에 Attached 된 Container 갯수 조회
		//*****************************************************************************	
		try {
			zDbcBkgQty = dmtCalculationUtil.searchBookingContainerQuantity(zBkgNo);
		}
		catch(Exception e) {
			String ftRmk = "Bkg Qty Select Error : " + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;				
		}
		
		
		//*****************************************************************************
		// 6. I/O 에 따른 Location 결정
		//*****************************************************************************			
		bkgCntCd   = zDelCntCd;
		bkgRgnCd   = zDelRgnCd;
		bkgStateCd = zDelStateCd;
		bkgLocCd   = zDelLoc;
	
		//*****************************************************************************
		// 7. POD Location 결정
		//*****************************************************************************	
		fixPodLoc = zPodLoc;

		//*****************************************************************************
		// 8. POL Location 결정
		//*****************************************************************************	
		fixPolLoc = zPolLoc ;
	
		//*****************************************************************************
		// 9. Booking의 VVD, ETA 조회
		//*****************************************************************************			
		VVDNEtaVO vvEtaVO = new VVDNEtaVO();
		try {
			vvEtaVO = dmtCalculationUtil.searchVVDNEta(zBkgNo, fixPolLoc, fixPodLoc, zDbcIoBnd);	
			zVslCd			= DMTCalculationUtil.nullToString(vvEtaVO.getVslCd());
			zSkdVoyageNo	= DMTCalculationUtil.nullToString(vvEtaVO.getSkdVoyNo());
			zSkdDirCd		= DMTCalculationUtil.nullToString(vvEtaVO.getSkdDirCd());
			zVpsEtaDt		= DMTCalculationUtil.nullToString(vvEtaVO.getVpsEtaDt(), 8);
			zClptIndSeq		= DMTCalculationUtil.nullToString(vvEtaVO.getClptIndSeq());
		}
		catch(Exception e) {
			String ftRmk = "Eta Date Select Error - :" + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;	
		}		
		
		//*****************************************************************************
		// 10. Effective Date 조회
		//*****************************************************************************	
		BasicTariffParmVO effDateParmVO = new BasicTariffParmVO();
		effDateParmVO.setIoBndCd(zDbcIoBnd.substring(0, 1));
		effDateParmVO.setPolLocCd(fixPolLoc);
		effDateParmVO.setPodLocCd(fixPodLoc);
		effDateParmVO.setVpsEtaDt(zVpsEtaDt.substring(0, 8));
		effDateParmVO.setCntrNo(zCntrNo);
		effDateParmVO.setCnmvCycNo(bkgRequestInfoVO.getCnmvCycNo());
		effDateParmVO.setFmDate("");			// In Bound 임으로 필요없음.
		dtgEfftDt = dmtCalculationUtil.getEfftDt(effDateParmVO); // 2013.01.08 변경.

	
		//*****************************************************************************
		// 11. DEL Location 조회
		//*****************************************************************************		
		fixDELLocationParmVO.setDmdtTrfCd(zDttCode);
		fixDELLocationParmVO.setPodCd(zPodLoc);
		fixDELLocationParmVO.setDelCd(zDelLoc);
		fixDELLocationParmVO.setDeTermCd(zBcntrDlvTerm);
		fixDELLocationParmVO.setFmMvmtStsCd("");
		fixDELLocationParmVO.setToMvmtStsCd("");
		fixDELLocationParmVO.setIoBnd(zDbcIoBnd);
		fixDELLocationParmVO.setTspFlag("");
		fixDELLocationParmVO.setPostRly(zPostRly);
		fixDELLocationParmVO.setPreRly(zPreRly);
		FixDELLocationVO fixDELLocationVO;
		
		try {
			fixDELLocationVO = dmtCalculationUtil.fixDELLocation(fixDELLocationParmVO);
		}
		catch(Exception e) {
			String ftRmk = "Fixed DEL Loc Select Error! " + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;	
		}
		
		if ("1".equals(fixDELLocationVO.getMsgCd())) {
			fixDelContiCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelContiCd());
			fixDelCntCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCntCd());
			fixDelRgnCd		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelRgnCd());
			fixDelStateCd	= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelSteCd());
			fixDelLoc		= DMTCalculationUtil.nullToString(fixDELLocationVO.getDelCd()); 
		} 
		else {
			/* Not Changed */
			fixDelContiCd 	= zDelContiCd;
			fixDelCntCd 	= zDelCntCd;
			fixDelRgnCd 	= zDelRgnCd;
			fixDelStateCd 	= zDelStateCd;
			fixDelLoc 		= zDelLoc;
		}
		
		//*****************************************************************************
		// 12. ORG Location 조회
		//*****************************************************************************			
		zOrgContiCd 	= zPolContiCd;
		zOrgCntCd 		= zPolCntCd;
		zOrgRgnCd 		= zPolRgnCd;
		zOrgStateCd 	= zPolStateCd;
		zOrgLocCd 		= zPolLoc;		
		
		//*****************************************************************************
		// 13. 컨테이너에 담기지 않는 불특정 무게나 부피를 갖는 화물에 대한 정보 조회
		//     O : 컨테이너에 담기지 않는 불특정 무게나 부피를 갖는 화물
		//     I : 컨테이너에 담기는 화물
		//*****************************************************************************			
		try {
			awkInOut = dmtCalculationUtil.searchInOutGauge(zCntrNo, zBkgNo);
		}
		catch(Exception e) {
			String ftRmk = "Get the Awkward Cargo in/out-gauge Error!" + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;				
		}
		
		//*****************************************************************************	
		// 14. Basic Tariff 조회
		//*****************************************************************************	
		basicTariffParmVO.setCvrgYdCd(zDcFmYdCd); //[2009.10.19  YARDCD추가: param:zDcFmYdCd]
		zDmdtDeTermCd	= zBcntrDlvTerm;
		
		basicTariffParmVO.setDmdtDeTermCd(zDmdtDeTermCd);
		basicTariffParmVO.setPorContiCd(zPorContiCd);
		basicTariffParmVO.setPorCntCd(zPorCntCd);
		basicTariffParmVO.setPorRgnCd(zPorRgnCd);
		basicTariffParmVO.setPorSteCd(zPorStateCd);
		basicTariffParmVO.setPorLocCd(zPorLoc);
		
		basicTariffParmVO.setYrdContiCd(zYrdContiCd);
		basicTariffParmVO.setYrdCntCd(zYrdCntCd);
		basicTariffParmVO.setYrdRgnCd(zYrdRgnCd);
		basicTariffParmVO.setYrdSteCd(zYrdStateCd);
		basicTariffParmVO.setYrdLocCd(zYrdLoc);
		
		basicTariffParmVO.setPolContiCd(zOrgContiCd);
		basicTariffParmVO.setPolCntCd(zOrgCntCd);
		basicTariffParmVO.setPolRgnCd(zOrgRgnCd);
		basicTariffParmVO.setPolSteCd(zOrgStateCd);
		basicTariffParmVO.setPolLocCd(zOrgLocCd);
		
		basicTariffParmVO.setDelContiCd(fixDelContiCd);
		basicTariffParmVO.setDelCntCd(fixDelCntCd);
		basicTariffParmVO.setDelRgnCd(fixDelRgnCd);
		basicTariffParmVO.setDelSteCd(fixDelStateCd);
		basicTariffParmVO.setDelLocCd(fixDelLoc);
		
		basicTariffParmVO.setDmdtTrfCd(zDttCode);
		basicTariffParmVO.setEffDt(dtgEfftDt.trim()); //2010.04.05.
		basicTariffParmVO.setDmdtCntrTpCd(zDcsCntrTp);
		basicTariffParmVO.setDmdtCgoTpCd(zDcsCgoTp);
		basicTariffParmVO.setIoBndCd(zDbcIoBnd);
		basicTariffParmVO.setAwkInOut(awkInOut);
		
		BasicTariffKeyVO basicTariffKeyVO = null;
		try {
			basicTariffKeyVO = dmtCalculationUtil.searchBasicTariffByGeneration(basicTariffParmVO);
		}
		catch(Exception e) {
			String ftRmk = "searchBasicTariffByGeneration Functon Error!" + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;					
		}
		
		if (StringUtils.isEmpty(basicTariffKeyVO.getSvrId())) {
			String ftRmk = "Tariff Not Found ! "+ zDttCode + ", "+ zPorCntCd+ ", "+ zYrdCntCd + ", "+ zPolCntCd+ ", "+ fixDelCntCd+ ", "+ zDcsCntrTp+ ", "+ zDcsCgoTp+ ", "+ dtgEfftDt;
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;				
		} 
		else {
			zSvrId			= DMTCalculationUtil.nullToString(basicTariffKeyVO.getSvrId());		
			zDttCode		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtTrfCd());
			zDtnSeq 		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfSeq());
			// Door('D'), Yard('Y') 와 Default('N') 우선 순위에 따라 DMDT_DE_TERM_CD를 변경 될 수 있다.
			zDmdtDeTermCd	= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtDeTermCd());
			zDtgGrpId		= DMTCalculationUtil.stringToLong(basicTariffKeyVO.getTrfGrpSeq());
			
			dtgCmncTp		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getDmdtChgCmncTpCd());
			dtgCmncHr		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getCmncHr());
			dtgExclSat		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSatFlg());
			dtgExclSun		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldSunFlg());
			dtgExclHoli		= DMTCalculationUtil.nullToString(basicTariffKeyVO.getXcldHolFlg());
		}
		
		//*****************************************************************************	
		// 15. Basic Tariff - Free Time 조회
		//*****************************************************************************		
		try {
			zDcFtDays = dmtCalculationUtil.basicFreeTime(zSvrId, zDttCode, zDtnSeq, zDmdtDeTermCd, zDtgGrpId, zDbcBkgQty);
		}
		catch(Exception e) {
			String ftRmk = "FreeTime Function Error ! "+ e.getMessage() + ", "+ zDttCode+ ", "+ zDtnSeq+ ", "+ zDmdtDeTermCd + ", "+ zDtgGrpId+ ", "+ zDbcBkgQty;
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;					
		}		
	
		//*****************************************************************************	
		// 14. Fixed Free Time 조회
		//*****************************************************************************			
		String zFixedCmnc = "";
		if ("VD".equals(zDcFmCnms)) {
			try {
				zFixedCmnc = DMTCalculationUtil.nullToString(dbDao.getFixedCmnc(zVslCd, zSkdVoyageNo, zSkdDirCd, zDcFmYdCd, zDttCode, "fm", zClptIndSeq));
			}
			catch(Exception e) {
				String ftRmk = "Fixed CMNC Date Select Error - " + new ErrorHandler(e).getMessage();
				ifFtVO.setFtRmk(ftRmk);
				return ifFtVO;		
			}
		}
		
		//*****************************************************************************	
		// 15. Free Time Commence Date 조회 ( Basic Tariff )
		//*****************************************************************************
		List<String> cstopNoList = new ArrayList<String>();
		long idxCstop = 0;
		
		String zDcFtCmnc = "";
		if (!StringUtils.isEmpty(zFixedCmnc)) {
			zDcFtCmnc = zFixedCmnc;
		} 
		else {
			FreeTimeStartParmVO freeTimeStartParmVO = new FreeTimeStartParmVO();	
			freeTimeStartParmVO.setFromDt(zDcFmDate);
			
			freeTimeStartParmVO.setBkgCntCd(bkgCntCd);
			freeTimeStartParmVO.setBkgRgnCd(bkgRgnCd);
			freeTimeStartParmVO.setBkgStateCd(bkgStateCd);
			freeTimeStartParmVO.setBkgLocCd(bkgLocCd);
			
			freeTimeStartParmVO.setYrdCntCd(zYrdCntCd);
			freeTimeStartParmVO.setYrdRgnCd(zYrdRgnCd);
			freeTimeStartParmVO.setYrdStateCd(zYrdStateCd);
			freeTimeStartParmVO.setYrdLocCd(zYrdLoc);
			
			freeTimeStartParmVO.setDttCode(zDttCode);
			freeTimeStartParmVO.setOfcCd(zOfcCd);
			freeTimeStartParmVO.setExclSat(dtgExclSat);
			freeTimeStartParmVO.setExclSun(dtgExclSun);
			freeTimeStartParmVO.setExclHoli(dtgExclHoli);
			freeTimeStartParmVO.setCmncTp(dtgCmncTp);
			freeTimeStartParmVO.setCmncHr(dtgCmncHr);
			freeTimeStartParmVO.setSvrId(zSvrId);
			freeTimeStartParmVO.setCstopIdx(String.valueOf(idxCstop));
			freeTimeStartParmVO.setCStopNoList(cstopNoList);
			freeTimeStartParmVO.setYardCd(zDcFmYdCd);
			freeTimeStartParmVO.setIoBndCd(zDbcIoBnd);
			freeTimeStartParmVO.setBkgDeTermCd(zBcntrDlvTerm);
			freeTimeStartParmVO.setBkgRcvTermCd("");
			
			FreeTimeVO freeTimeStartVO = new FreeTimeVO();
			try {
				freeTimeStartVO = dmtCalculationUtil.searchFreeTimeStart(freeTimeStartParmVO);
				zDcFtCmnc 		= DMTCalculationUtil.nullToString(freeTimeStartVO.getFtimeCmnc());					
				idxCstop 		= DMTCalculationUtil.stringToLong(freeTimeStartVO.getCstopIdx());
				cstopNoList 	= freeTimeStartVO.getCStopNoList();
			}
			catch(Exception e) {
				String ftRmk = "BSC searchFreeTimeStart Function Error :  " + new ErrorHandler(e).getMessage();
				ifFtVO.setFtRmk(ftRmk);
				return ifFtVO;					
			}
		}
		
		//*****************************************************************************	
		// 16. Free Time End Date 조회 ( Basic Tariff )
		//*****************************************************************************
		FreeTimeEndParmVO freeTimeEndParmVO	= new FreeTimeEndParmVO();
		freeTimeEndParmVO.setFromDt(zDcFtCmnc);  
		
		freeTimeEndParmVO.setBkgCntCd(bkgCntCd);
		freeTimeEndParmVO.setBkgRgnCd(bkgRgnCd);
		freeTimeEndParmVO.setBkgStateCd(bkgStateCd);
		freeTimeEndParmVO.setBkgLocCd(bkgLocCd);
		
		freeTimeEndParmVO.setYrdCntCd(zYrdCntCd);
		freeTimeEndParmVO.setYrdRgnCd(zYrdRgnCd);
		freeTimeEndParmVO.setYrdStateCd(zYrdStateCd);
		freeTimeEndParmVO.setYrdLocCd(zYrdLoc);
		
		freeTimeEndParmVO.setDttCode(zDttCode);
		freeTimeEndParmVO.setOfcCd(zOfcCd);
		freeTimeEndParmVO.setExclSat(dtgExclSat);
		freeTimeEndParmVO.setExclSun(dtgExclSun);
		freeTimeEndParmVO.setExclHoli(dtgExclHoli);
		
		freeTimeEndParmVO.setFreeTime(String.valueOf(zDcFtDays));
		freeTimeEndParmVO.setSvrId(zSvrId);
		freeTimeEndParmVO.setCstopIdx(String.valueOf(idxCstop));
		freeTimeEndParmVO.setCStopNoList(cstopNoList);
		freeTimeEndParmVO.setYardCd(zDcFmYdCd);
		freeTimeEndParmVO.setIoBndCd(zDbcIoBnd);
		freeTimeEndParmVO.setBkgDeTermCd(zBcntrDlvTerm);
		freeTimeEndParmVO.setBkgRcvTermCd("");

		FreeTimeVO freeTimeEndVO = new FreeTimeVO();
		String zDcFtEnd	= "";
		try {
			freeTimeEndVO = dmtCalculationUtil.searchFreeTimeEnd(freeTimeEndParmVO);
			zDcFtEnd  	  = DMTCalculationUtil.nullToString(freeTimeEndVO.getFtimeEnd());
			idxCstop 	  = DMTCalculationUtil.stringToLong(freeTimeEndVO.getCstopIdx());
			cstopNoList   = freeTimeEndVO.getCStopNoList();
		}
		catch(Exception e) {
			String ftRmk = "BSC searchFreeTimeEnd Function Error :  " + new ErrorHandler(e).getMessage();
			ifFtVO.setFtRmk(ftRmk);
			return ifFtVO;				
		}

		
		// 출력결과
		// Basic Tariff 정보
		ifFtVO.setSysAreaGrpId(zSvrId);
		ifFtVO.setDmdtTrfCd(zDttCode);
		ifFtVO.setTrfSeq(String.valueOf(zDtnSeq));
		ifFtVO.setDmdtDeTermCd(zDmdtDeTermCd);
		ifFtVO.setTrfGrpSeq(String.valueOf(zDtgGrpId));
		// FreeTime 정보
		ifFtVO.setFtCmncDt(zDcFtCmnc);
		ifFtVO.setFtEndDt(zDcFtEnd);
		ifFtVO.setFtDys(String.valueOf(zDcFtDays));
		ifFtVO.setFtFxCmncDt(zFixedCmnc);
		
		return ifFtVO;
	}
	
}