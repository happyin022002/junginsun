/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleMgtBCImpl.java
*@FileTitle : Actual SKD Input Ratio Inquiry (R/Lane)
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.21
*@LastModifier : 정상기
*@LastVersion : 1.0
* 2009.07.06 정진우
* 1.0 Creation
*
* History
* 2010.11.02 CHM-201006736-01 유혁 터미널에서 전송되는 Actual SKD 수신시 ERP 전송 누락되는 문제 수정
* 2010.12.22 CHM-201007901-01 진마리아 SPP에서 전송된 Actual Port SKD에 대한 처리 로직 수정
* 2010.12.27 CHM-201007578-01 진마리아 Coastal SKD Auto Update 로직 수정 및 보완 요청건
* 2011.01.25 CHM-201007580-01 진마리아 Sked EDI 수신후 Actual sked의 Voyage/Direction을 찿는 Logic 추가
* 2011.09.09 CHM-201113239-01 김민아 Sked EDI 수신후 Actual sked의 Voyage/Direction을 찿는 Logic 추가(2)
* 2011.10.14 CHM-201113948-01 진마리아 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가)
* 2011.10.17 진마리아 CHM-201113948 Vessel sked EDI의 VVD mapping을 위해 F/F 수정 (Segment추가) (UAX)
* 2012.11.30 CHM-201221263-01 황태진 [VSK] Actual sked 삭제시 Estimated sked의 원복 로직 적용 요청  modifyPortSkdEstmDtRestore DAO 호출  
* 2013.01.05 CHM-201322758    정상기  Actual Input Date ATA/ATB/ATD SCE와 일치
* 2013.02.28 CHM-201323017    정상기  IFTSAI  EDI setup 변경 (MYPKGTM)
* 2013.05.07 CHM-201324269    정상기  VSK EDI를 통해 actual sked 입력시 calling seq. 체크로직추가
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.sce.copdetailreceive.vo.SceActRcvIfVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.CanonEmlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAO;
//import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.integration.ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActEDISetupInfoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdChangeVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActPortSkdHisVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdDtlVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdEdiMntrVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdMgtVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdRtoVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.ActSkdSumVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.EdiLogDataGRPVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.vo.VvdListByPortVO;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ontimeresultanalysis.vo.DrwSkdSearchVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdChgStsGRPVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommonutil.vskgeneralutil.VSKGeneralUtil;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBC;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.basic.VSKCodeFinderBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.framework.component.util.JSPUtil;

import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.VskActPortSkdEdiLogVO;
import com.hanjin.syscommon.common.table.VskActPortSkdHisVO;
import com.hanjin.syscommon.common.table.VskActPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
import com.hanjin.syscommon.common.table.VskVslSkdVO;

/**
 * NIS2010-ActualScheduleManagement Business Logic Basic Command implementation<br>
 * - NIS2010-ActualScheduleManagement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung Jinwoo
 * @see vop_vsk_0027EventResponse,ActualScheduleMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ActualScheduleMgtBCImpl extends BasicCommandSupport implements ActualScheduleMgtBC {

	// Database Access Object
	private transient ActualScheduleMgtDBDAO dbDao = null;

	/**
	 * ActualScheduleMgtBCImpl 객체 생성<br>
	 * ActualScheduleMgtDBDAO를 생성한다.<br>
	 */
	public ActualScheduleMgtBCImpl() {
		dbDao = new ActualScheduleMgtDBDAO();
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * Vessel Port Schedule, Actual Port Schedule 정보를 조회한다. <br>
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return ActSkdMgtVO
	 * @exception EventException
	 */
	public ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException{
		ActSkdMgtVO returnVO = null;
		
		try {
			ActSkdMgtVO chkTurnPortVO = dbDao.checkTurnPort(actSkdMgtVO);
			
			// 데이타가 없을 경우
			if(chkTurnPortVO == null){
				/*
				 * MSG - No Data Found - [$s]
				 */
				String[] errMsgs = new String[]{actSkdMgtVO.getVslCd()+"/"+actSkdMgtVO.getSkdVoyNo()+"/"+actSkdMgtVO.getSkdDirCd()+"/"+actSkdMgtVO.getVpsPortCd()+"/"+actSkdMgtVO.getClptIndSeq()};
				throw new EventException(new ErrorHandler("VSK10018", errMsgs).getMessage());
			}
			
			// TURN PORT인 경우
			if("T".equals(chkTurnPortVO.getFlag())){
				/*
				 * MSG - This Port is Virtual Port. Please input Turning Port Information!
				 */
				throw new EventException(new ErrorHandler("VSK10012").getMessage());
			}
			
			ActSkdMgtVO chkSkipVO = dbDao.checkSkipPort(actSkdMgtVO);
			
			// Skip Port 인 경우
			if("X".equals(chkSkipVO.getFlag())){
				/*
				 * MSG - 해당 PORT는 SKIP된 상태 입니다.
				 */
				throw new EventException(new ErrorHandler("VSK10031").getMessage()); 
			}
				
			returnVO = dbDao.searchActPortSkd(actSkdMgtVO);
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}

		return returnVO;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Actualschedulemgt 화면에 대한 멀티 이벤트 처리<br>
	 * 해당 Port에서 VVD별로 입력한 Actual Schedule 정보를 생성 및 변경하고, 각 모쥴별 필요한 정보를 인터페이스 한다.<br>
	 *
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @return VslSkdChgStsGRPVO
	 * @exception EventException
	 */
	public VslSkdChgStsGRPVO manageActPortSkd(ActSkdMgtVO actSkdMgtVO) throws EventException{
		VslSkdChgStsGRPVO 	vslSkdChgStsGRPVO 	= new VslSkdChgStsGRPVO			();
		
		VSKCodeFinderBC		command				= new VSKCodeFinderBCImpl		();
		ActSkdMgtVO			tmpActSkdMgtVO		= null;

		//Drewry Ontime Report : ATD입력시 Drewry port 리스트중 존재하면 POD정보를  저장한다.
		
		List<DrwSkdSearchVO>	drwSkdSearchVOs	= null;
		
		
		/********************************************************************
		 * None-Attached BKG에 대해서 SCE(COP) 인터페이스로 변경
		 * 2013-04-11
		 * Actual SKD 생성이후 BKG 생성되는경우 Actual Time COP에 미반영건 해결
		 * ------------------------------------------------------------------
		 * ATA "21" :: ATB "22" :: ATD "23"
		 * ******************************************************************
		 */
		
		try {
			
			ActPortSkdChangeVO 	actPortSkdChangeVO 	= null;
			boolean 			isHistoryFlg 		= false;
			
			List<SceActRcvIfVO> sceActRcvIfList 	= new ArrayList<SceActRcvIfVO>	();		//TO SCE(COP) Actual Time Interface
			List<CanonEmlVO> 	canonEmlList 		= new ArrayList<CanonEmlVO>		();		//TO BKG FOR "CANON" ONLY
			
			if(actSkdMgtVO != null){
				
				//LST_ETA_DT 는 최초 한번만 VPS_ETA_DT로 저장.
				ActSkdMgtVO statusVO = dbDao.searchLastCstSkdStatus(actSkdMgtVO);
				
				// Last Estimate Time, Turning 정보를 DB에서 조회한다.  
				if(statusVO != null){
					// Coastal Data 에도 사용하기 위하여.
					if(VSKGeneralUtil.isNotNull(statusVO.getPortSkdStsCd())) 	vslSkdChgStsGRPVO.setPortSkdStsCd(statusVO.getPortSkdStsCd	());
					if(VSKGeneralUtil.isNotNull(statusVO.getPortSkdStsCd())) 	actSkdMgtVO.setPortSkdStsCd(statusVO.getPortSkdStsCd		());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtaDt())) 		actSkdMgtVO.setLstEtaDt(statusVO.getLstEtaDt				());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtbDt())) 		actSkdMgtVO.setLstEtbDt(statusVO.getLstEtbDt				());
					if(VSKGeneralUtil.isNotNull(statusVO.getLstEtdDt())) 		actSkdMgtVO.setLstEtdDt(statusVO.getLstEtdDt				());
					
					//TURN PORT 을 경우에 Virtual 정보를 셋팅한다.
					//UI를 통하지 않는 Channel (SPP, EDI등) 에서 입력되는 Virtual 정보를 믿을 수 없으므로 무시하고, 현재 DB의 SKD의 Virtual 정보를 셋팅한다. (2010.05.28 임창빈).
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnPortFlg())) 	actSkdMgtVO.setTurnPortFlg(statusVO.getTurnPortFlg			());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnPortIndCd())) 	actSkdMgtVO.setTurnPortIndCd(statusVO.getTurnPortIndCd		());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnSkdVoyNo())) 	actSkdMgtVO.setTurnSkdVoyNo(statusVO.getTurnSkdVoyNo		());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnSkdDirCd())) 	actSkdMgtVO.setTurnSkdDirCd(statusVO.getTurnSkdDirCd		());
					if(VSKGeneralUtil.isNotNull(statusVO.getTurnClptIndSeq())) 	actSkdMgtVO.setTurnClptIndSeq(statusVO.getTurnClptIndSeq	());
					
					// CHM-201007901-01
					// SPP에서 입력된 Actual Port SKD 정보에 Lane 정보가 없으므로
					// VSK의 Lane 정보를 사용하도록 변경한다.
					if(VSKGeneralUtil.isNull(actSkdMgtVO.getSlanCd())){
						vslSkdChgStsGRPVO.setSlanCd(statusVO.getSlanCd());
					}
				}
				
				// 날짜 Format 재정의. "2008-12-21 07:12" => "200812210712"
				actSkdMgtVO.setLstEtaDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtaDt					()));
				actSkdMgtVO.setLstEtbDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtbDt					()));
				actSkdMgtVO.setLstEtdDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getLstEtdDt					()));
				actSkdMgtVO.setActArrDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActArrDt					()));
				actSkdMgtVO.setActBrthDt		(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActBrthDt				()));
				actSkdMgtVO.setActDepDt			(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getActDepDt					()));
				actSkdMgtVO.setPltLstUnldDt		(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getPltLstUnldDt				()));
				actSkdMgtVO.setBfrBrthAnkDrpDt	(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getBfrBrthAnkDrpDt			()));
				actSkdMgtVO.setBfrBrthAnkOffDt	(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getBfrBrthAnkOffDt			()));
				actSkdMgtVO.setAftUnbrthAnkDrpDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getAftUnbrthAnkDrpDt		()));
				actSkdMgtVO.setAftUnbrthAnkOffDt(VSKGeneralUtil.replaceDateTypeToString(actSkdMgtVO.getAftUnbrthAnkOffDt		()));
				
				// Number Format 재정의. "999,999,999.99" => "999999999.99"
				actSkdMgtVO.setArrFoilWgt		(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFoilWgt           	()));                      
				actSkdMgtVO.setArrLowSulpFoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrLowSulpFoilWgt    	()));                       
				actSkdMgtVO.setArrDoilWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrDoilWgt           	()));                       
				actSkdMgtVO.setArrLowSulpDoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrLowSulpDoilWgt    	()));                       
				actSkdMgtVO.setArrFrshWtrWgt    (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFrshWtrWgt        	()));                                              
				actSkdMgtVO.setArrBlstWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrBlstWgt           	()));                                              
				actSkdMgtVO.setArrFwddrHgt      (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrFwddrHgt          	()));                                              
				actSkdMgtVO.setArrAftdrHgt      (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrAftdrHgt          	()));                                              
				actSkdMgtVO.setArrGmHgt         (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrGmHgt             	()));                                              
				actSkdMgtVO.setArrTugBotKnt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getArrTugBotKnt         	()));                                              
				actSkdMgtVO.setSplFoilWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplFoilWgt           	()));                                              
				actSkdMgtVO.setSplLowSulpFoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplLowSulpFoilWgt    	()));                                              
				actSkdMgtVO.setSplDoilWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplDoilWgt           	()));                                              
				actSkdMgtVO.setSplLowSulpDoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplLowSulpDoilWgt    	()));                                              
				actSkdMgtVO.setSplFrshWtrWgt    (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getSplFrshWtrWgt        	()));                                              
				actSkdMgtVO.setDepLowSulpFoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepLowSulpFoilWgt    	()));                                              
				actSkdMgtVO.setDepFoilWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFoilWgt           	()));                                              
				actSkdMgtVO.setDepLowSulpDoilWgt(VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepLowSulpDoilWgt    	()));                                              
				actSkdMgtVO.setDepDoilWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepDoilWgt           	()));                                              
				actSkdMgtVO.setDepFrshWtrWgt    (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFrshWtrWgt        	()));                                              
				actSkdMgtVO.setDepBlstWgt       (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepBlstWgt           	()));                                              
				actSkdMgtVO.setDepFwddrHgt      (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepFwddrHgt          	()));                                              
				actSkdMgtVO.setDepAftdrHgt      (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepAftdrHgt          	()));                                              
				actSkdMgtVO.setDepGmHgt         (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepGmHgt             	()));                                              
				actSkdMgtVO.setDepTugBotKnt     (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getDepTugBotKnt         	()));                                              
				actSkdMgtVO.setTtlSlgWgt        (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getTtlSlgWgt            	()));                                              
				actSkdMgtVO.setTtlGbgQty        (VSKGeneralUtil.replaceNumberTypeToString(actSkdMgtVO.getTtlGbgQty            	()));        

				// Actual Schedule 정합성
				checkActSkdValid(actSkdMgtVO);
				
				// Insert, Update 구분하기 위해 Actual Data 가 있는지 확인.
				ActSkdMgtVO chkActPortVO 	= dbDao.checkVskActPortSkd		(actSkdMgtVO);
				actPortSkdChangeVO 			= dbDao.checkVskActPortSkdChange(actSkdMgtVO);

				
				/*********************************************************************************************************************
				 * e-Service(SPP) + EDI(IFTSAI) 요청데이터 ACT_ATA/ATB/ATD_INP_DT 세팅
				 * -------------------------------------------------------------------------------------------------------------------
				 * EDI Actual Schedule 반영시  Actual Schedule History 참조하여 ACT_ATA/B/D_INP_DT 반영토록 로직수정
				 * 최초입력시 SYSDATE로 입력처리 :: VSKCodeFinderBCImpl.getTimeConvFmLocToLoc(sFmLoc, sToLoc, sDateFormat)
				 * -------------------------------------------------------------------------------------------------------------------
				 * DBDAO.ActSkdMgtVO searchActPortSkd(ActSkdMgtVO actSkdMgtVO) >> ActualScheduleMgtDBDAOActSkdMgtRSQL.Query
				 *********************************************************************************************************************/		
				
				if( "ESVCUSER".equals(actSkdMgtVO.getUpdUsrId()) || "IF_EDI_SVC".equals(actSkdMgtVO.getUpdUsrId()) )
				{
						
						log.debug("\n\n ::ActualScheduleMgtBCImpl.manageActPortSkd:: ESVCUSER + IF_EDI_SVC - ACT INPUT INDICATOR ["+actSkdMgtVO.getUpdUsrId()+"]");
						tmpActSkdMgtVO	= new ActSkdMgtVO();
						tmpActSkdMgtVO	= dbDao.searchActPortSkd(actSkdMgtVO);
						
						actSkdMgtVO.setActAtaInpDt(tmpActSkdMgtVO.getActAtaInpDt());
						actSkdMgtVO.setActAtbInpDt(tmpActSkdMgtVO.getActAtbInpDt());
						actSkdMgtVO.setActAtdInpDt(tmpActSkdMgtVO.getActAtdInpDt());

				}
				
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::bfr - actSkdMgtVO.getActArrDt ["+ actSkdMgtVO.getActArrDt() +"], actSkdMgtVO.getActAtaInpDt["+ actSkdMgtVO.getActAtaInpDt() +"]");
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::bfr - actSkdMgtVO.getActBrthDt["+ actSkdMgtVO.getActBrthDt()+"], actSkdMgtVO.getActAtbInpDt["+ actSkdMgtVO.getActAtbInpDt() +"]");
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::bfr - actSkdMgtVO.getActDepDt ["+ actSkdMgtVO.getActDepDt() +"], actSkdMgtVO.getActAtdInpDt["+ actSkdMgtVO.getActAtdInpDt() +"]");
				
				String	sCurrentDate	= null;
					
				if	(		((actSkdMgtVO.getActArrDt () != null && !"".equals(actSkdMgtVO.getActArrDt ())) && (actSkdMgtVO.getActAtaInpDt() == null || "".equals(actSkdMgtVO.getActAtaInpDt())))
						||	((actSkdMgtVO.getActBrthDt() != null && !"".equals(actSkdMgtVO.getActBrthDt())) && (actSkdMgtVO.getActAtbInpDt() == null || "".equals(actSkdMgtVO.getActAtbInpDt())))
						||	((actSkdMgtVO.getActDepDt () != null && !"".equals(actSkdMgtVO.getActDepDt ())) && (actSkdMgtVO.getActAtdInpDt() == null || "".equals(actSkdMgtVO.getActAtdInpDt())))
					)
				{
					//::2013.02.20:://sCurrentDate	= command.getTimeConvFmLocToLoc("KRSEL", "KRSEL", "YYYYMMDDHH24MISS");
					
					//sTmpPortCd		= actSkdMgtVO.getVpsPortCd() == null || "".equals(actSkdMgtVO.getVpsPortCd()) ? "KRSEL" : actSkdMgtVO.getVpsPortCd();
					sCurrentDate	= command.getTimeConvFmLocToLoc("KRSEL", "KRSEL", "YYYYMMDDHH24MISS");
					
					if((actSkdMgtVO.getActArrDt () != null && !"".equals(actSkdMgtVO.getActArrDt ())) && (actSkdMgtVO.getActAtaInpDt() == null || "".equals(actSkdMgtVO.getActAtaInpDt()))){
						actSkdMgtVO.setActAtaInpDt(sCurrentDate);
					}
					if((actSkdMgtVO.getActBrthDt() != null && !"".equals(actSkdMgtVO.getActBrthDt())) && (actSkdMgtVO.getActAtbInpDt() == null || "".equals(actSkdMgtVO.getActAtbInpDt()))){
						actSkdMgtVO.setActAtbInpDt(sCurrentDate);
					}
					if((actSkdMgtVO.getActDepDt () != null && !"".equals(actSkdMgtVO.getActDepDt ())) && (actSkdMgtVO.getActAtdInpDt() == null || "".equals(actSkdMgtVO.getActAtdInpDt()))){
						actSkdMgtVO.setActAtdInpDt(sCurrentDate);
					}								
				}
				
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::aft - actSkdMgtVO.getActArrDt ["+ actSkdMgtVO.getActArrDt() +"], actSkdMgtVO.getActAtaInpDt["+ actSkdMgtVO.getActAtaInpDt() +"]");
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::aft - actSkdMgtVO.getActBrthDt["+ actSkdMgtVO.getActBrthDt()+"], actSkdMgtVO.getActAtbInpDt["+ actSkdMgtVO.getActAtbInpDt() +"]");
				log.debug("\n   ::ActualScheduleMgtBCImpl.manageActPortSkd::aft - actSkdMgtVO.getActDepDt ["+ actSkdMgtVO.getActDepDt() +"], actSkdMgtVO.getActAtdInpDt["+ actSkdMgtVO.getActAtdInpDt() +"]");
							
				/*********************************************************************************************************************
				 * e-Service(SPP) + EDI(IFTSAI) 요청데이터 ACT_ATA/ATB/ATD_INP_DT 세팅 THE END.
				 *********************************************************************************************************************/	
				
				if(chkActPortVO != null){
					// History Check
					if(actPortSkdChangeVO != null){
						int chgVal = VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAllChk());
						if(chgVal > 0){
							isHistoryFlg = true;
						}
					}
					
					// Update
					dbDao.modifyVskActPortSkd	(actSkdMgtVO);
				}else{
					// Insert(데이타가 없을 경우)
					isHistoryFlg = true;
					
					/**********************************************
					 * 시간차에 의한 중복입력발생방지를 위한 체크로직 추가
					 * 2013-04-24 WED
					 * --------------------------------------------
					 * VSK_ACT_PORT_SKD 테이블에서 데이터 존재여부 체크
					 * boolean << isNewRecordforActualSchedule
					 * > true 	: new record
					 * > false 	: exist record
					 */
					
					if(dbDao.isNewRecordforActualSchedule(actSkdMgtVO)){
						//isHistoryFlg = true;
						dbDao.addVskActPortSkd		(actSkdMgtVO);
					}else{
						//isHistoryFlg = false;
						dbDao.modifyVskActPortSkd	(actSkdMgtVO);
					}
					
					
				}
			}
			
			/*
			 * History
			 */
			if(isHistoryFlg){
				
				// ACT_ATA_INP_DT, ACT_ATB_INP_DT, ACT_ATD_INP_DT 최신 데이터 
				VskActPortSkdVO vskActPortSkdVO = new VskActPortSkdVO();
				vskActPortSkdVO.setVslCd		(actSkdMgtVO.getVslCd		());
				vskActPortSkdVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo	());
				vskActPortSkdVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd	());
				vskActPortSkdVO.setVpsPortCd	(actSkdMgtVO.getVpsPortCd	());
				vskActPortSkdVO.setClptIndSeq	(actSkdMgtVO.getClptIndSeq	());
				vskActPortSkdVO = dbDao.searchVskActPortSkd(vskActPortSkdVO);
				
				
				VskActPortSkdHisVO vskActPortSkdHisVO = new VskActPortSkdHisVO();
				vskActPortSkdHisVO.setVslCd		(actSkdMgtVO.getVslCd		());
				vskActPortSkdHisVO.setSkdVoyNo	(actSkdMgtVO.getSkdVoyNo	());
				vskActPortSkdHisVO.setSkdDirCd	(actSkdMgtVO.getSkdDirCd	());
				vskActPortSkdHisVO.setVpsPortCd	(actSkdMgtVO.getVpsPortCd	());
				vskActPortSkdHisVO.setClptIndSeq(actSkdMgtVO.getClptIndSeq	());
				vskActPortSkdHisVO.setActArrDt	(actSkdMgtVO.getActArrDt	());
				vskActPortSkdHisVO.setActBrthDt	(actSkdMgtVO.getActBrthDt	());
				vskActPortSkdHisVO.setActDepDt	(actSkdMgtVO.getActDepDt	());
				vskActPortSkdHisVO.setCreUsrId	(actSkdMgtVO.getCreUsrId	());
				vskActPortSkdHisVO.setUpdUsrId	(actSkdMgtVO.getUpdUsrId	());
				
				/*
				 * CHM-201007578-01
				 */
				vskActPortSkdHisVO.setActAtaInpDt	(vskActPortSkdVO.getActAtaInpDt		());
				vskActPortSkdHisVO.setActAtbInpDt	(vskActPortSkdVO.getActAtbInpDt		());
				vskActPortSkdHisVO.setActAtdInpDt	(vskActPortSkdVO.getActAtdInpDt		());
				vskActPortSkdHisVO.setActAtaInpUsrId(vskActPortSkdVO.getActAtaInpUsrId	());
				vskActPortSkdHisVO.setActAtbInpUsrId(vskActPortSkdVO.getActAtbInpUsrId	());
				vskActPortSkdHisVO.setActAtdInpUsrId(vskActPortSkdVO.getActAtdInpUsrId	());
				
				/*
				 * COP & Booking
				 * 
				 * IF( UPDATING ) THEN 일때 Act Rcv Dt
				 * 1. ATA가 변경된 경우 "21"
				 * 2. ATB가 변경된 경우 "22"
				 * 3. ATD가 변경된 경우 "23"
				 * 4. ETA가 변경된 경우 "24"
				 * 5. ETB가 변경된 경우 "25"
				 * 6. ETD가 변경된 경우 "26"
				 * 7. YD가 변경된 경우   "27"
				 * 
				 * Actual 이 Turning 일 경우 해당 Virtual Port 는 Coastal 에서 보내지 않고 Actual 에서 생성하여 Cop 에 전송.
				 */
				// booking 이 있을 경우에만 cop 전송.
				if(actPortSkdChangeVO != null){
					//:://List<SceActRcvIfVO> sceActRcvIfList = new ArrayList<SceActRcvIfVO>	();
					//:://List<CanonEmlVO> 	canonEmlList 	= new ArrayList<CanonEmlVO>		();

					// Booking 에 있는지 확인.
					if("Y".equals(actPortSkdChangeVO.getBkgChk())){
						
						//ATA 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtaLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("21");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActArrDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtaInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslArrDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslArrDlayRsnNm		());
		//					sceActRcvIfVO.setVpsLocCd(actSkdMgtVO.getVslDlayRsnLocCd());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATB 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtbLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("22");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActBrthDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtbInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslBrthDlayRsnCd	());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslBrthDlayRsnNm	());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATD 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtdLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("23");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActDepDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtdInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslDepDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslDepDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
							
							//Booking Data(ATD 만 넘기기로 함. - 2009.11.16)
							CanonEmlVO canonEmlVO 			= new CanonEmlVO();
							canonEmlVO.setCoNm				("CANON");
							canonEmlVO.setVslCd				(actSkdMgtVO.getVslCd				());
							canonEmlVO.setSkdVoyNo			(actSkdMgtVO.getSkdVoyNo			());
							canonEmlVO.setSkdDirCd			(actSkdMgtVO.getSkdDirCd			());
							canonEmlVO.setPolCd				(actSkdMgtVO.getVpsPortCd			());
							canonEmlVO.setAtdDt				(actSkdMgtVO.getActDepDt			());
							
							canonEmlList.add				(canonEmlVO);
						}
						
					}else{
					//::TURNING+NORMAL PORT::jskjskjsk::2013-04-11:://
					/********************************************************************
					 * None-Attached BKG에 대해서 SCE(COP) 인터페이스로 변경
					 * 2013-04-11
					 * Actual SKD 생성이후 BKG 생성되는경우 Actual Time COP에 미반영건 해결
					 * ------------------------------------------------------------------
					 * ATA "21" :: ATB "22" :: ATD "23"
					 * 
					 * ... COP & Booking ................................................
					 * IF( UPDATING ) THEN 일때 Act Rcv Dt
					 * 1. ATA가 변경된 경우 "21"
					 * 2. ATB가 변경된 경우 "22"
					 * 3. ATD가 변경된 경우 "23"
					 * ******************************************************************
					 */		
						
						//ATA 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("21");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActArrDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtaInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslArrDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslArrDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATB 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("22");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActBrthDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtbInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslBrthDlayRsnCd	());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslBrthDlayRsnNm	());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATD 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("23");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActDepDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtdInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getSkdVoyNo			());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getSkdDirCd			());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getClptIndSeq			());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslDepDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslDepDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}						
					}
					
					// Booking(Virtual) 에 있는지 확인.
					if("Y".equals(actPortSkdChangeVO.getBkgVrtChk())){
						
						//ATA 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtaLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("21");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActArrDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtaInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslArrDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslArrDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATB 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtbLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("22");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActBrthDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtbInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslBrthDlayRsnCd	());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslBrthDlayRsnNm	());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATD 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							//::2013-01-22:://sceActRcvIfVO.setActDatRcvDt	(actPortSkdChangeVO.getAtdLocTime	());
							sceActRcvIfVO.setActRcvTpCd		("23");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActDepDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtdInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslDepDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslDepDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						
					}else{
					//::VIRTUAL PORT::jskjskjsk::2013-04-11:://	
					/********************************************************************
					 * None-Attached BKG에 대해서 SCE(COP) 인터페이스로 변경
					 * 2013-04-11
					 * Actual SKD 생성이후 BKG 생성되는경우 Actual Time COP에 미반영건 해결
					 * ------------------------------------------------------------------
					 * ATA "21" :: ATB "22" :: ATD "23"
					 * 
					 * ... COP & Booking ................................................
					 * IF( UPDATING ) THEN 일때 Act Rcv Dt
					 * 1. ATA가 변경된 경우 "21"
					 * 2. ATB가 변경된 경우 "22"
					 * 3. ATD가 변경된 경우 "23"
					 * ******************************************************************
					 */		
						
						//ATA 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtaChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("21");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActArrDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtaInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslArrDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslArrDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATB 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtbChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("22");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActBrthDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtbInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslBrthDlayRsnCd	());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslBrthDlayRsnNm	());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}
						//ATD 가 변경된 경우..
						if(VSKGeneralUtil.convertNumberByString(actPortSkdChangeVO.getAtdChk()) > 0){
							//COP Data
							SceActRcvIfVO sceActRcvIfVO 	= new SceActRcvIfVO();
							sceActRcvIfVO.setActRcvTpCd		("23");
							sceActRcvIfVO.setActDt			(actSkdMgtVO.getActDepDt			());
							sceActRcvIfVO.setActDatRcvDt	(actSkdMgtVO.getActAtdInpDt			());	//::2013-01-22: for SCE.Visibility//
							sceActRcvIfVO.setNodCd			(actSkdMgtVO.getYdCd				());
							sceActRcvIfVO.setVslCd			(actSkdMgtVO.getVslCd				());
							sceActRcvIfVO.setSkdVoyNo		(actSkdMgtVO.getTurnSkdVoyNo		());
							sceActRcvIfVO.setSkdDirCd		(actSkdMgtVO.getTurnSkdDirCd		());
							sceActRcvIfVO.setVpsPortCd		(actSkdMgtVO.getVpsPortCd			());
							sceActRcvIfVO.setClptIndSeq		(actSkdMgtVO.getTurnClptIndSeq		());
							sceActRcvIfVO.setVslDlayRsnCd	(actSkdMgtVO.getVslDepDlayRsnCd		());
							sceActRcvIfVO.setVslDlayRsnDesc	(actSkdMgtVO.getVslDepDlayRsnNm		());
							sceActRcvIfVO.setCreUsrId		(actSkdMgtVO.getCreUsrId			());
							
							sceActRcvIfList.add				(sceActRcvIfVO);
						}						
						
					}
					
					vslSkdChgStsGRPVO.setSceActRcvIfVOs		(sceActRcvIfList);		//COP Data
					vslSkdChgStsGRPVO.setCanonEmlVOs		(canonEmlList	);		//Booking Data
					
				}
				// COP END
				
				dbDao.addVskActPortSkdHis(vskActPortSkdHisVO);
				
				/*
				 * 2015-04 Actual 스케줄의 Departue정보가 들어올 경우 Drewry 노선으로 등록된 SKD이 있는지 확인 후 
				 * Drewry 테이블로 Edtimate 값능 전송한다.
				 * 
				 */
				if( actSkdMgtVO.getActDepDt() != null){
					drwSkdSearchVOs = dbDao.searchDrwSkdInfo(actSkdMgtVO);
					if(drwSkdSearchVOs.size() > 0 ){
					
						for( int i = 0 ; i < drwSkdSearchVOs.size(); i++ ){
							DrwSkdSearchVO insVo = new DrwSkdSearchVO();
							//drwSkdSearchVO.get(i).
	//						insVo.setVslCd(drwSkdSearchVO.get(i).getVslCd());
	//						insVo.setSkdVoyNo(drwSkdSearchVO.get(i).getSkdVoyNo());
	//						insVo.setSkdDirCd(drwSkdSearchVO.get(i).getSkdDirCd());
	//						insVo.setPolCd(drwSkdSearchVO.get(i).getPolCd());
	//						
							
							insVo = drwSkdSearchVOs.get(i);
							
							insVo.setPolActDepDt(actSkdMgtVO.getActDepDt());
							insVo.setPolActAtdInpDt(actSkdMgtVO.getActAtdInpDt());
							
							dbDao.addDrwSkdInfo(insVo);
						}
					}
					
				}
			}
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			if(ex.getMessage().indexOf("ORA-00001")>-1){
				// 시간차에 의한 중복건 입력 오류 상황에 대해서는 이미 처리되었음을 뜻하는 메시지를 전송한다.				
				throw new EventException(new ErrorHandler("VSK10059").getMessage(), ex);
			}else{
				throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);	
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		return vslSkdChgStsGRPVO;
	}
	
	/**
	 * Actual 정보 저장 시 정합성 점검.
	 * 
	 * @param ActSkdMgtVO actSkdMgtVO
	 * @throws EventException
	 */
	private void checkActSkdValid(ActSkdMgtVO actSkdMgtVO) throws EventException{
		try {
			ActSkdMgtVO chkTurnPortVO = dbDao.checkTurnPort(actSkdMgtVO);
			ActSkdMgtVO chkStatusVO = dbDao.checkVslSkdStatus(actSkdMgtVO);
			
			// 데이타가 없을 경우
			if(chkTurnPortVO == null || chkStatusVO == null){
				/*
				 * MSG - No Data Found - [$s]
				 */
				String[] errMsgs = new String[]{actSkdMgtVO.getVslCd()+"/"+actSkdMgtVO.getSkdVoyNo()+"/"+actSkdMgtVO.getSkdDirCd()+"/"+actSkdMgtVO.getVpsPortCd()+"/"+actSkdMgtVO.getClptIndSeq()};
				throw new EventException(new ErrorHandler("VSK10018", errMsgs).getMessage());
			}
			
			// TURN PORT인 경우
			if("T".equals(chkTurnPortVO.getFlag())){
				/*
				 * MSG - This Port is Virtual Port. Please input Turning Port Information!
				 */
				throw new EventException(new ErrorHandler("VSK10012").getMessage());
			}
			
			// CLOSE일 경우
			if("CLO".equals(chkStatusVO.getFlag())){
				/*
				 * MSG - Vessel Schedule Already Closed!
				 */
				throw new EventException(new ErrorHandler("VSK10011").getMessage()); 
			}
			
			// Skip Port 인 경우
			ActSkdMgtVO chkSkipVO = dbDao.checkSkipPort(actSkdMgtVO);
			if("X".equals(chkSkipVO.getFlag())){
				/*
				 * MSG - 해당 PORT는 SKIP된 상태 입니다.
				 */
				throw new EventException(new ErrorHandler("VSK10031").getMessage()); 
			}
			
			// Booking 이 존재할 경우에만 입력가능.
			
		} catch (EventException ex) {
			throw new EventException(ex.getMessage());
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * 등록된 Actual Port Schedule 정보를 삭제하고 Estimated sked의 원복 함. <br>
	 * 
	 * @param VskActPortSkdVO vskActPortSkdVO
	 * @exception EventException
	 */
	public void removeVskActPortSkd(VskActPortSkdVO vskActPortSkdVO) throws EventException{
		try {
			
			//2012.11.30 [CHM-201221263-01] Estimated sked의 원복 추가      
			dbDao.modifyPortSkdEstmDtRestore(vskActPortSkdVO);
			dbDao.removeVskActPortSkd(vskActPortSkdVO);

			VskActPortSkdHisVO vskActPortSkdHisVO = new VskActPortSkdHisVO();
			
			vskActPortSkdHisVO.setVslCd(vskActPortSkdVO.getVslCd());
			vskActPortSkdHisVO.setSkdVoyNo(vskActPortSkdVO.getSkdVoyNo());
			vskActPortSkdHisVO.setSkdDirCd(vskActPortSkdVO.getSkdDirCd());
			vskActPortSkdHisVO.setVpsPortCd(vskActPortSkdVO.getVpsPortCd());
			vskActPortSkdHisVO.setClptIndSeq(vskActPortSkdVO.getClptIndSeq());
			vskActPortSkdHisVO.setCreUsrId(vskActPortSkdVO.getUpdUsrId());
			vskActPortSkdHisVO.setUpdUsrId(vskActPortSkdVO.getUpdUsrId());
			
			dbDao.addVskActPortSkdHis(vskActPortSkdHisVO);
            

		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * 등록된 관린 대상 Lane List를 조회한다. <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<MdmVslSvcLaneVO>
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> searchActualTargetLaneList(ActSkdRtoVO actSkdRtoVO) throws EventException{
		try {
			return dbDao.searchActualTargetLaneList(actSkdRtoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * 사용자가 입력한 조건에 맞는 Port들에 Actual Report 입력 현황을 조회한다. <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdSumVO>
	 * @exception EventException
	 */
	public List<ActSkdSumVO> searchActPortSkdInputSum(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdInputSum(actSkdRtoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * 사용자가 입력한 조건에 맞는 Port들의 Actual Report 현황을 상세 조회한다. <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdInputDtl(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdInputDtl(actSkdRtoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * Actual Schedule이 작성되지 않는 Report를 조회한다. <br>
	 * 
	 * @param ActSkdRtoVO actSkdRtoVO
	 * @return List<ActSkdDtlVO>
	 * @exception EventException
	 */
	public List<ActSkdDtlVO> searchActPortSkdUnCmplDtl(ActSkdRtoVO actSkdRtoVO) throws EventException {
		try {
			return dbDao.searchActPortSkdUnCmplDtl(actSkdRtoVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * EDI로 수신된 Actual SKD 접수 정보를 조회한다.<br>
	 * 
	 * @param ActSkdEdiMntrVO actSkdEdiMntrVO
	 * @return List<ActSkdEdiMntrVO>
	 * @exception EventException
	 */
	public List<ActSkdEdiMntrVO> searchActPortSkdEdiMntr(ActSkdEdiMntrVO actSkdEdiMntrVO) throws EventException {
		try {
//			String tmlCd = actSkdEdiMntrVO.getTmlCd();
//			if(VSKGeneralUtil.isNotNull(tmlCd)){
//				actSkdEdiMntrVO.setYdCd(actSkdEdiMntrVO.getVpsPortCd()+tmlCd);
//			}
			actSkdEdiMntrVO.setYdCd(actSkdEdiMntrVO.getTmlCd());
			return dbDao.searchActPortSkdEdiMntr(actSkdEdiMntrVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
	}
	
	/**
	 * 전문을 \n으로 나누어 new line으로 떨어 뜨린다.
	 * 
	 * @param String sFlatFile
	 * @return ArrayList<String>
	 * @throws EventException
	 */
	private ArrayList<String> flatFileConvertList(String sFlatFile) throws EventException {
		ArrayList<String> rtnArr = new ArrayList<String>();
		try{
			StringTokenizer token = new StringTokenizer(sFlatFile, "\n");
			while (token.hasMoreTokens()) {
				rtnArr.add(token.nextToken());
			}
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		return rtnArr;
	}
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param String ediFlatFile
	 * @return VskActPortSkdEdiLogVO
	 * @exception EventException
	 */
	public List<VskActPortSkdEdiLogVO> createVskActPortSkdEdiLog(String ediFlatFile) throws EventException{
		
		List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs = new ArrayList<VskActPortSkdEdiLogVO>();
		
		/*
		 * 헤더 양식
		    $$$MSGSTART:HIT                 SML_ALPS            IFTSAI    UBIZ1:447766663
			{MAIN
			BRAC:9
			VSL_CD:P985
			VOY_NO:9820
			DIR_CD:6
			CALL_SIGN:
			IMO_CD:
			REF_CD:
			MATCH_MODE:(BKG_UVI or BKG_CRN or 공백)
			LOC_CD:CNHKG
			YD_CD:CNHKGHT
			ATA:200911042300
			ATB:200911050527
			ATD:200911050609
			}MAIN
			{MAIN
			BRAC:9
			VSL_CD:HNAX
			VOY_NO:0003
			DIR_CD:E
			CALL_SIGN:3EPH4
			IMO_CD:
			REF_CD:
			LOC_CD:CNHKG
			YD_CD:CNHKGCH
			ATA:200911050700
			ATB:200911050724
			ATD:
			}MAIN
		 */
		try {
			
			//전문을 \n으로 나누어 new line으로 떨어 뜨린다.
			ArrayList<String> flatFileList = flatFileConvertList(ediFlatFile);

			StringBuffer startIdxSb = new StringBuffer();
			StringBuffer endIdxSb 	= new StringBuffer();
			
			//전문에서 {MAIN 과 }MAIN을 시작 과 끝으로 잡는다
			//Multi건 이므로 {MAIN의 의 각각의 위치는  startSb 담는다
			//Multi건 이므로 }MAIN의 의 각각의 위치는  endSb 담는다
			for(int i=1; i<flatFileList.size(); i++){
				if(flatFileList.get(i).indexOf("{MAIN") > -1){	
					startIdxSb.append(Integer.toString(i) + ":");
				}else if(flatFileList.get(i).indexOf("}MAIN") > -1){	
					endIdxSb.append(Integer.toString(i) + ":");
				}
			}
			
			String[] 	startData 		= startIdxSb.toString().split(":");
			String[] 	endData 		= endIdxSb.toString().split(":");
			int[] 		delStartData 	= new int[startData.length];
			int[] 		delEndData 		= new int[endData.length];
			
			//startSb에 담아 있는 각각의  {MAIN의 위치를  delStartData
			for(int i=0; i<startData.length; i++){
				if(VSKGeneralUtil.isNotNull(startData[i])){
					delStartData[i] = Integer.parseInt(startData[i]);
				}
			}
			
			//startSb에 담아 있는 각각의  }MAIN의 위치를  delEndData
			for(int i=0; i<endData.length; i++){
				if(VSKGeneralUtil.isNotNull(endData[i])){
					delEndData[i] = Integer.parseInt(endData[i]);
				}
			}
			
			log.info("\n ========== <<createVskActPortSkdEdiLog>>============\n");
			
			for(int i=0; i<startData.length; i++ ){
				VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO = new VskActPortSkdEdiLogVO();
				
				for(int k=(delStartData[i]+ 2); k<(delEndData[i]); k++){
					
					String[] 	jumMomIdArr = flatFileList.get(k).toString().trim().split(":",2);
					String 		jumMomId 	= jumMomIdArr[0];
					
					log.info("\n jumMomId   ==== ["+jumMomId+"], value ["+flatFileList.get(k).toString().trim()+"] \n");
					
					if("VSL_CD".equals(jumMomId)){
						String[] vslCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiVslNm(VSKGeneralUtil.getCheckNullToString(vslCdArr[1]));			//VSL_CD
					}else if("VOY_NO".equals(jumMomId)){
						String[] skdVoyNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiSkdVoyNo(VSKGeneralUtil.getCheckNullToString(skdVoyNoArr[1]));		//SKD_VOY_NO
					}else if("DIR_CD".equals(jumMomId)){
						String[] skdDirCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiSkdDirNm(VSKGeneralUtil.getCheckNullToString(skdDirCdArr[1]));		//SKD_DIR_CD
					}else if("CALL_SIGN".equals(jumMomId)){
						String[] callSgnNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setCallSgnNo(VSKGeneralUtil.getCheckNullToString(callSgnNoArr[1]));		//CALL_SGN_NO
					}else if("IMO_CD".equals(jumMomId)){
						String[] lloydNoArr = flatFileList.get(k).toString().trim().split(":", 2);
						vskActPortSkdEdiLogVO.setLloydNo(VSKGeneralUtil.getCheckNullToString(lloydNoArr[1]));			//LLOYD_NO
					}else if("REF_CD".equals(jumMomId)){
						// MATCH_MODE 항목의 값이 존재할 경우 REF_CD의 값이 의미가 있음
						// MATCH_MODE : BKG_UVI ==> REF_CD : BKG_VSL_DCHG_YD 테이블의 UQ_VSL_ID_NO 컬럼
						// MATCH_MODE : BKG_CRN ==> REF_CD : BKG_VSL_DCHG_YD 테이블의 CVY_REF_NO 컬럼
						String[] shpCallNoArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setShpCallNo(VSKGeneralUtil.getCheckNullToString(shpCallNoArr[1]));		//SHP_CALL_NO
					}else if("LOC_CD".equals(jumMomId)){
						String[] vpsPortCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setVpsPortCd(VSKGeneralUtil.getCheckNullToString(vpsPortCdArr[1]));		//VPS_PORT_CD
					}else if("YD_CD".equals(jumMomId)){
						String[] ydCdArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setYdCd(VSKGeneralUtil.getCheckNullToString(ydCdArr[1]));					//YD_CD
					}else if("ATA".equals(jumMomId)){
						String[] actArrDtArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiActArrDt(VSKGeneralUtil.getCheckNullToString(actArrDtArr[1]));		//ACT_ARR_DT
					}else if("ATB".equals(jumMomId)){
						String[] actBrthDtArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiActBrthDt(VSKGeneralUtil.getCheckNullToString(actBrthDtArr[1]));	//ACT_BRTH_DT
					}else if("ATD".equals(jumMomId)){
						String[] actDepDtArr = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setEdiActDepDt(VSKGeneralUtil.getCheckNullToString(actDepDtArr[1]));		//ACT_DEP_DT
					}else if("MATCH_MODE".equals(jumMomId)){
						String[] mtchModCd = flatFileList.get(k).toString().trim().split(":",2);
						vskActPortSkdEdiLogVO.setMtchModCd(VSKGeneralUtil.getCheckNullToString(mtchModCd[1]));			//MATCH_MODE
					}
					vskActPortSkdEdiLogVO.setScsFlg("N");	// Insert 시 default 는 'N'
				}
				vskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
			}
			
			/*************************************************************
			 * EDI FLAT FILE ELEMENT 유효성 체크로직 적용 ::2013-04-05
			 * -----------------------------------------------------------
			 * VSL_CD		V( 4)
			 * SKD_VOY_NO	V( 4)
			 * SKD_DIR_CD	V( 1)
			 * CALL_SGN_NO	V(15)
			 * LLOYD_NO		V(20)
			 * SHP_CALL_NO	V(15)
			 * VPS_PORT_CD	V( 5)
			 * YD_CD		V( 7)
			 * MATCH_MODE	V(10)
			 * MATCH_MODE	V10
			 * -----------------------------------------------------------
			 * ACT_ARR_DT	DATE	ex.200911050700
			 * ACT_BRTH_DT	DATE
			 * ACT_DEP_DT	DATE
			 *************************************************************/
			//::jskjskjsk::2013-04-05:://
			for(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO:vskActPortSkdEdiLogVOs){
				if(vskActPortSkdEdiLogVO != null){
					//::VSK10079---"EDI Flatfile Validation Check Result : [{?msg1}] is invalid.":://
					
					String sTemporaryVslCd			= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getVslCd		());
					String sTemporarySkdVoyNo		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getSkdVoyNo		());
					String sTemporarySkdDirCd		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getSkdDirCd		());
					String sTemporaryVpsPortCd		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getVpsPortCd	());
					String sTemporaryYdCd			= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getYdCd			());

					//String sTemporaryCallSgnNo		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getCallSgnNo	());
					//String sTemporaryLloydNo		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getLloydNo		());
					//String sTemporaryShpCallNo		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getShpCallNo	());
					//String sTemporaryMtchModCd		= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getMtchModCd	());

					String sTemporaryEdiActArrDt	= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getEdiActArrDt	());
					String sTemporaryEdiActBrthDt	= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getEdiActBrthDt	());
					String sTemporaryEdiActDepDt	= VSKGeneralUtil.convertNulltoEmptyString(vskActPortSkdEdiLogVO.getEdiActDepDt	());

					log.debug("\n\n ::jskjskjskjsk::VVD+PORT+YD ["+sTemporaryVslCd+sTemporarySkdVoyNo+sTemporarySkdDirCd+sTemporaryVpsPortCd+sTemporaryYdCd+"]\n");
					
					//if(sTemporaryVslCd.length() 		> 4)	throw new EventException(new ErrorHandler("VSK10079", "VSL_CD"		).getMessage());	//::VSL_CD		V( 4):://
					//if(sTemporarySkdVoyNo.length() 		> 4)	throw new EventException(new ErrorHandler("VSK10079", "SKD_VOY_NO"	).getMessage());	//::SKD_VOY_NO	V( 4):://
					//if(sTemporarySkdDirCd.length() 		> 1)	throw new EventException(new ErrorHandler("VSK10079", "SKD_DIR_CD"	).getMessage());	//::SKD_DIR_CD	V( 1):://
					//if(sTemporaryVpsPortCd.length() 	> 5)	throw new EventException(new ErrorHandler("VSK10079", "VPS_PORT_CD"	).getMessage());	//::VPS_PORT_CD	V( 5):://
					//if(sTemporaryCallSgnNo.length() 	> 15)	throw new EventException(new ErrorHandler("VSK10079", "CALL_SGN_NO"	).getMessage());	//::CALL_SGN_NO	V(15):://
					//if(sTemporaryLloydNo.length() 		> 20)	throw new EventException(new ErrorHandler("VSK10079", "LLOYD_NO"	).getMessage());	//::LLOYD_NO	V(20):://
					//if(sTemporaryShpCallNo.length() 	> 15)	throw new EventException(new ErrorHandler("VSK10079", "SHP_CALL_NO"	).getMessage());	//::SHP_CALL_NO	V(15):://
					//if(sTemporaryYdCd.length() 			> 7)	throw new EventException(new ErrorHandler("VSK10079", "YD_CD"		).getMessage());	//::YD_CD		V( 7):://
					//if(sTemporaryMtchModCd.length() 	> 10)	throw new EventException(new ErrorHandler("VSK10079", "MATCH_MODE"	).getMessage());	//::MATCH_MODE	V(10):://
					//if(sTemporaryEdiActArrDt.length() 	> 12)	throw new EventException(new ErrorHandler("VSK10079", "ACT_ARR_DT"	).getMessage());	//::MATCH_MODE	V(10):://
					//if(sTemporaryEdiActBrthDt.length()	> 12)	throw new EventException(new ErrorHandler("VSK10079", "ACT_BRTH_DT"	).getMessage());	//::MATCH_MODE	V(10):://
					//if(sTemporaryEdiActDepDt.length() 	> 12)	throw new EventException(new ErrorHandler("VSK10079", "ACT_DEP_DT"	).getMessage());	//::MATCH_MODE	V(10):://
					
					log.debug("\n\n ::jskjskjskjsk::sTemporaryEdiActArrDt ["+sTemporaryEdiActArrDt+"] sTemporaryEdiActBrthDt ["+sTemporaryEdiActBrthDt+"] sTemporaryEdiActDepDt+["+sTemporaryEdiActDepDt+"]\n");
					
					if(!"".equals(sTemporaryEdiActArrDt) 	&& !VSKGeneralUtil.isEffectiveDate(sTemporaryEdiActArrDt)	){
						log.error("\n\n ::jskjskjskjsk::sTemporaryEdiActArrDt >> invalid data ["+sTemporaryEdiActArrDt+"]");
						throw new EventException(new ErrorHandler("VSK10079", "None Effective ACT_ARR_DT").getMessage());
					}
					if(!"".equals(sTemporaryEdiActBrthDt) 	&& !VSKGeneralUtil.isEffectiveDate(sTemporaryEdiActBrthDt)	){
						log.error("\n\n ::jskjskjskjsk::sTemporaryEdiActBrthDt >> invalid data ["+sTemporaryEdiActBrthDt+"]");
						throw new EventException(new ErrorHandler("VSK10079", "None Effective ACT_BRTH_DT").getMessage());	
					}
					if(!"".equals(sTemporaryEdiActDepDt) 	&& !VSKGeneralUtil.isEffectiveDate(sTemporaryEdiActDepDt)	){
						log.error("\n\n ::jskjskjskjsk::sTemporaryEdiActDepDt >> invalid data ["+sTemporaryEdiActDepDt+"]");
						throw new EventException(new ErrorHandler("VSK10079", "None Effective ACT_DEP_DT").getMessage());
					}

				}
			}
			
			
			// 전문헤더 양식 $$$MSGSTART:HJNPC010            SML                 IFTSAI    UBIZ1:419567213
			String header 			= flatFileList.get(0).toString();  
			String sndrTrdPrnrId 	= header.substring(12, 31).trim();		// SNDR_TRD_PRNR_ID
			String rcvrTrdPrnrId 	= header.substring(32, 51).trim();		// RCVR_TRD_PRNR_ID
			String ediMsgTpId 		= header.substring(52, 61).trim();		// EDI_MSG_TP_ID
			String ediMsgProcId 	= header.substring(62).trim();			// EDI_MSG_PROC_ID
//			String junMomHeader = ediFlatFile.substring(62, 77).trim();
			
			
			// EDI LOG KEY 생성 및 헤더정보 저장.
			if(vskActPortSkdEdiLogVOs != null){
				// MQ에서 전문으로 받을시 user_id가 null 이므로 인터페이스 id 를 입력한다
				String ediId = "IF_EDI_SVC";
				
				for(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO : vskActPortSkdEdiLogVOs){	
					
					VskActPortSkdEdiLogVO rtnVO = dbDao.searchVskActPortSkdEdiLogKeyValue();
					
					vskActPortSkdEdiLogVO.setRcvDt			(rtnVO.getRcvDt	()	);
					vskActPortSkdEdiLogVO.setRcvSeq			(rtnVO.getRcvSeq()	);
					vskActPortSkdEdiLogVO.setSndrTrdPrnrId	(sndrTrdPrnrId		);
					vskActPortSkdEdiLogVO.setRcvrTrdPrnrId	(rcvrTrdPrnrId		);
					vskActPortSkdEdiLogVO.setEdiMsgTpId		(ediMsgTpId			);
					vskActPortSkdEdiLogVO.setEdiMsgProcId	(ediMsgProcId		);
					vskActPortSkdEdiLogVO.setCreUsrId		(ediId				);
					vskActPortSkdEdiLogVO.setUpdUsrId		(ediId				);
					String errMsg = "[Error] An unknown error has occurred while processing. Please contact system administrator.";
					vskActPortSkdEdiLogVO.setRsltMsg(errMsg);	// error 는 아니지만 이 메세지가 보이면 알 수 없는 에러이므로.
						
    				// 터미널에서 EDI를 통해서 입력하는 Actual Schedule Departure 정보를 저장한다.
					dbDao.addVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);						
				}
			}
			
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}

		return vskActPortSkdEdiLogVOs;
	}
	
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs
	 * @param SignOnUserAccount account
	 * @return EdiLogDataGRPVO
	 * @exception EventException
	 */
	public EdiLogDataGRPVO auditReceivedEdiData(List<VskActPortSkdEdiLogVO> vskActPortSkdEdiLogVOs, SignOnUserAccount account) throws EventException{
		
		//auditReceivedEdiData 메소드에서 정상적인 체크를 마치면
		//modifyVskActPortSkdEdiLog을 
		EdiLogDataGRPVO rtnEdiLogDataGRPVO 	= new EdiLogDataGRPVO();
		int 			successCnt	 		= 0;		// 성공한 건수
		int 			failCnt 			= 0;		// 실패한 건수
		
		final 			String usrId		= "IF_EDI_SVC";
		
		try {
			//----------private final String usrId = "IF_EDI_SVC";
//			if(account == null){
				//------------------usrId = "IF_EDI_SVC";	// user id 는 무조건 EDI 데이타는로 처리(2010.03.24  이정은 K).
//			}else{
//				usrId = account.getUsr_id();
//			}
			
			if(vskActPortSkdEdiLogVOs != null && vskActPortSkdEdiLogVOs.size() > 0){
				List<VskActPortSkdEdiLogVO> rtnVskActPortSkdEdiLogVOs 	= new ArrayList<VskActPortSkdEdiLogVO>	();
				List<VskVslPortSkdVO> 		vskVslPortSkdVOs 			= new ArrayList<VskVslPortSkdVO>		();
				List<VskActPortSkdVO> 		vskActPortSkdVOs 			= new ArrayList<VskActPortSkdVO>		();
				
				for(VskActPortSkdEdiLogVO 	vskActPortSkdEdiLogVO : vskActPortSkdEdiLogVOs){				
					
//					#########################################################################
//					# EDI Set-up Info 조회.
//					#########################################################################
					ActEDISetupInfoVO 			paramVO 			= new ActEDISetupInfoVO	();
					
					log.info("\n ::::======== YD_CD ["+vskActPortSkdEdiLogVO.getYdCd()+"], sndr_trd_prnr_id ["+vskActPortSkdEdiLogVO.getSndrTrdPrnrId()+"] \n");
					
					paramVO.setPrnrSubLnkCd		(vskActPortSkdEdiLogVO.getYdCd				());
					paramVO.setSndrTrdPrnrId	(vskActPortSkdEdiLogVO.getSndrTrdPrnrId		());
					ActEDISetupInfoVO 			actEDISetupInfoVO 	= dbDao.searchActEDISetUpInfo(paramVO);
					
					if(actEDISetupInfoVO == null || "X".equals(actEDISetupInfoVO.getVslCdFlg())){
						failCnt++;
						// VSK10065 :: [Error] No exists a EDI Setting Information.
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10065").getUserMessage());
						
						dbDao.modifyVskActPortSkdEdiLog	(vskActPortSkdEdiLogVO);
						continue;
					}
					
//					#########################################################################
//					# TERMINAL VOYAGE TYPE MAPPING PROCESS 
//					#########################################################################					
//					* F/F REF_NO(terminal using voyage+dir) + YD_CD 존재하는 경우에만 가능 * 
//					STEP 1-1. F/F “VSL_CD” 				존재  => 해당하는 vvd 추출 
//					STEP 1-2. F/F “CALL_SIGN” 			존재  => 해당하는 vvd 추출 
//					STEP 1-3. F/F “IMO_CD” (lloyd_no) 	존재  => 해당하는 vvd 추출 
//
//					* STEP 1-1,2,3 vvd 추출 실패의 경우 *
//					STEP 2-1. step 1-1,2,3에서 데이터 추출시 terminal 일치조건을 => port 일치조건으로 변경하여 해당하는 vvd 추출 
//
//					2012-07-19 추가::정상기::					
//					STEP 2-2. F/F "REF_NO"가 존재하는 경우 해당값을  Terminal Using Code(Terminal Vessel Code + Terminal Voyage/Direction Code)와 매핑하여 VVD 추출
//
//					* STEP 2-1 vvd 추출 실패의 경우 *
//					STEP 3-1. trunk vessel 여부확인 
//
//					* STEP 3-1 trunk vessel인 경우 *
//					STEP 4-1. 추출된 데이터 VSL_CD 및 F/F “ATB”이용하여 “VSL_CD”, “SKD_VOY_NO”, “SKD_DIR_CD” 추출 
//
//					STEP 5-1. F/F “YD_CD” maneuvering time 관리되는 terminal 인경우 F/F ”ATB”이를 이용하여 actual arrival date 추출
//
//					STEP 5-2. 추출된 데이터를 이용하여 Service Lane 및 CALLING INDICATOR SEQ 추출 
//
//					FINISH
//					#########################################################################						
					
					
//					#########################################################################
//					# vsl_cd, skd_voy_no, skd_dir_cd 를 찾는다.
//					# VVD 찾는 순서는 
//					#     1. Vessel Code.
//					#     2. Call Sign No.		:: MDM_VSL_CNTR 테이블에서 UNIQUE하지 않음
//					#     3. IMO(Llody No) No.	:: MDM_VSL_CNTR 테이블에서 UNIQUE하지 않음				
//					#########################################################################
					
					List<VskActPortSkdEdiLogVO> rtnVvdVOs 			= null;	
					List<VskActPortSkdEdiLogVO> rtnPortVOs 			= null;
					String						ediVslCd 			= vskActPortSkdEdiLogVO.getEdiVslNm();
					String						callSignNo 			= vskActPortSkdEdiLogVO.getCallSgnNo();
					String						llodyNo 			= vskActPortSkdEdiLogVO.getLloydNo();
					String						sYdCd				= vskActPortSkdEdiLogVO.getYdCd();
					String						sRefNo				= vskActPortSkdEdiLogVO.getShpCallNo();
					String						errNo 				= "";
					//String[] 					sbErrMsgs.append(	= new String[]{""};
					String 						vslCdFlg 			= actEDISetupInfoVO.getVslCdFlg();
					StringBuilder				sbErrMsgs			= new StringBuilder();
					StringBuilder				sbDupShpCallNoMsgs	= new StringBuilder("");
					
					/* F.F "REF_NO"	*/
					String						shpCallNo	= vskActPortSkdEdiLogVO.getShpCallNo();

					log.info("\n ============================== VSK Actual Schedule EDI Debugging =========================================\n");
					log.info("\n\n" +
					   "===================================================================================================================\n"+
					   "["+ actEDISetupInfoVO.getVslCdFlg() +"] ["+ actEDISetupInfoVO.getMnvrInHrsFlg()+"] ["+ actEDISetupInfoVO.getActDateFlg() +"]\n"+
					   "vsl Cd  : ["+ ediVslCd +"] call Sign : ["+ callSignNo +"] lloyd : ["+ llodyNo +"] ship call no : ["+ vskActPortSkdEdiLogVO.getShpCallNo() +"]\n"+
					   "Voy No. : ["+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"]\n"+
					   "Dir Cd. : ["+ vskActPortSkdEdiLogVO.getEdiSkdDirNm() +"]\n"+
					   "Port Cd : ["+ vskActPortSkdEdiLogVO.getVpsPortCd() +"]\n"+
					   "==================================================================================================================\n");
					
					log.info("\n  vslCdFlg === ["+vslCdFlg+"]\n" );
					
					// ediVslCd, callSignNo, llodyNo가 모두 값이 없을 경우, 해당 Vessel Code를 찾을 수 없다.
					// VSK10027 : Vessel Code doesn't exist.
					if(	(	!"MYPKGTM".equals(sYdCd) && VSKGeneralUtil.isNull(ediVslCd) && VSKGeneralUtil.isNull(callSignNo) && VSKGeneralUtil.isNull(llodyNo))
							||
						(	"MYPKGTM".equals(sYdCd) && VSKGeneralUtil.isNull(sRefNo))
						)
					{
						if(!"02".equals(vslCdFlg) || "".equals(shpCallNo)){
							failCnt++;
							/* VSK10027 :: Vessel Code doesn't exist. */
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10027").getUserMessage());
							
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;	
						}
					}
					
//					###################################################################################
//					# 셋업 정보 (vslCdFlg = "01") 로써  SML Voyage Number 로  SML VVD를 찾는다.
//					###################################################################################
					if("01".equals(vslCdFlg)){
						//[Error] No exists a Vvd as a SML (voyage & direction).($s)
						errNo = "VSK10072";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchHjsVvdByReceviedHjsVoyDirHjsVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSignNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedHjsVoyDirCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedHjsVoyDirImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							}
						}
						
						if (rtnVvdVOs == null || rtnVvdVOs.size() == 0) {
							if (!"".equals(ediVslCd)) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							} else if (!"".equals(callSignNo)) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							} else if ("2".equals(llodyNo)) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdVoyNo() +"/"+ vskActPortSkdEdiLogVO.getEdiSkdDirNm());
							}
							
							rtnPortVOs = dbDao.searchHjsVvdByReceviedHjsVoyDirAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// EDI 전문에 의해서 Yard Code로 조회되지 않지만, Port Code로 조회될 경우 메세지 처리.
								sbErrMsgs.append(", Selection by Port : " + getPortVvdMsg(rtnPortVOs));
							}
						}
						
//					###################################################################################
//					# 셋업 정보 (vslCdFlg = "02") 로써,  Terminal Voyage 로 SML VVD를 찾는다.
//					# PROCESS 추가 : STEP 2-2. F/F "REF_NO"가 존재하는 경우 해당값을  Terminal Using Code(Terminal Vessel Code + Terminal Voyage/Direction Code)와 매핑하여 VVD 추출
//					###################################################################################				
					} else if("02".equals(vslCdFlg)){
						//[Error] No exists a Vvd as a terminal voyage.($s)
						errNo = "VSK10062";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchHjsVvdByReceviedTmnlVoyNoHjsVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSignNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedTmnlVoyNoCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedTmnlVoyNoImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}									
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
							if (!"".equals(ediVslCd)) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(callSignNo)) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(llodyNo)) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}
							
							rtnPortVOs = dbDao.searchHjsVvdByReceviedTmnlVoyNoAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								
								// EDI 전문에 의해서 Yard Code로 조회되지 않지만, Port Code로 조회될 경우 메세지 처리.
								//sbErrMsgs.append([0] += ", Selection by Port : " + getPortVvdMsg(rtnPortVOs);
								
								sbErrMsgs.append(", Selection by Port : " + getPortVvdMsg(rtnPortVOs));
							}
						}
						
						/* STEP(adding::2012-07-19) 2-2 */
						if((rtnVvdVOs == null || rtnVvdVOs.size() == 0)){
							
							if(!"".equals(shpCallNo)){
								
								sbErrMsgs.append("SHIP CALLING NO(REF_CD). : " + vskActPortSkdEdiLogVO.getShpCallNo() + "/" + vskActPortSkdEdiLogVO.getShpCallNo());
								rtnVvdVOs	= dbDao.searchHjsVvdByReceviedTmnlUsingCd(vskActPortSkdEdiLogVO);
							}
						}
						
//					###################################################################################
//					# 셋업 정보 (vslCdFlg = "03" & "04") 로써, BKG Ship Call Number 로  SML VVD를 찾는다.
//					# >> 2013.02.21 "03" "04" 분리	
//					#    SENDER "KMT" >> "03" EDI Setup "CRN" - Ship Calling Number "MYPKGTM" 로직추가						
//					###################################################################################
					} else if("03".equals(vslCdFlg)){

						//[Error] No exists a Vvd as a ship call number.($s)
						errNo = "VSK10063";
						
						String refCd 		= vskActPortSkdEdiLogVO.getShpCallNo();
						String mtchModCd 	= vskActPortSkdEdiLogVO.getMtchModCd();
						
						refCd 				= refCd		==null?"":refCd.trim	();
						mtchModCd 			= mtchModCd	==null?"":mtchModCd.trim();
						
						
						//String	sEDIPortCD	= vskActPortSkdEdiLogVO.getVpsPortCd();
						String	sEdiYdCd	= vskActPortSkdEdiLogVO.getYdCd();
						/***********************************************************************
						 * Terminal "MYPKGTM" (Sender[TP ID] "KMT") Actual EDI Mapping Logic
						 * ---------------------------------------------------------------------
						 * <EDI Set-Up>
						 * VVD			: "CRN"
						 * 
						 * <F/F>
						 * CALL_SIGN	: NULL
						 * REF_CD		: CRN Code Value
						 * MATCH_CODE	: "BKG_CRN"
						 * ---주석처리---VOY_NO		: skd_voy_no <== "RFF+VON"-EDI FILE (MYPKGTM에 대해서만 해당컬럼에 매핑)
						 ***********************************************************************/
						if("MYPKGTM".equals(sEdiYdCd)){
							
							log.info("\n ==== ::MYPKGTM:: ======= getMtchModCd 		["+vskActPortSkdEdiLogVO.getMtchModCd()+"] \n");
							log.info("\n ==== ::MYPKGTM:: ======= getShpCallNo 		["+vskActPortSkdEdiLogVO.getShpCallNo()+"] \n");
							
							if(!"BKG_CRN".equals(vskActPortSkdEdiLogVO.getMtchModCd()) || vskActPortSkdEdiLogVO.getMtchModCd() == null ){
								sbErrMsgs.append("(MYPKGTM)MATCH MODE : "+ vskActPortSkdEdiLogVO.getMtchModCd());
							}
							
							if(vskActPortSkdEdiLogVO.getShpCallNo() == null ){
								sbErrMsgs.append("(MYPKGTM-CRN)REF CD : "+ vskActPortSkdEdiLogVO.getShpCallNo());
							}	
							
							
							vskActPortSkdEdiLogVO.setVpsPortCd	("MYPKG");
							vskActPortSkdEdiLogVO.setYdCd		("MYPKGTM");
							
							//ActualScheduleMgtDBDAOSearchTerminalUsingCdCrnNoforHjsVvdRSQL
							rtnVvdVOs	= dbDao.searchTerminalUsingCdforHjsVvd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 0) {
								sbErrMsgs.append("(MYPKGTM-CRN)REF CD : "+ vskActPortSkdEdiLogVO.getShpCallNo() +"/(MYPKGTM)MATCH MODE : "+ vskActPortSkdEdiLogVO.getMtchModCd());
								
								vskActPortSkdEdiLogVO.setVslCd		(rtnVvdVOs.get(0).getVslCd		());
								vskActPortSkdEdiLogVO.setSkdVoyNo	(rtnVvdVOs.get(0).getSkdVoyNo	());
								vskActPortSkdEdiLogVO.setSkdDirCd	(rtnVvdVOs.get(0).getSkdDirCd	());
								
							}		
							
							log.info("\n ==== :::: ======= getVslCd 		["+vskActPortSkdEdiLogVO.getVslCd()+"] \n");
							log.info("\n ==== :::: ======= getSkdVoyNo 	["+vskActPortSkdEdiLogVO.getSkdVoyNo()+"] \n");
							log.info("\n ==== :::: ======= getSkdDirCd 	["+vskActPortSkdEdiLogVO.getSkdDirCd()+"] \n");							
							
						//END OF "MYPKGTM"//
							
						}else{
							
							if(!"".equals(refCd) && !"".equals(mtchModCd)){
								
								rtnVvdVOs = dbDao.searchHjsVvdByReceviedShipCallNoHjsVslCd(vskActPortSkdEdiLogVO);
								
								if (rtnVvdVOs.size() > 1) {
									sbErrMsgs.append("REF CD : "+ vskActPortSkdEdiLogVO.getShpCallNo() +"/MATCH_MODE : "+ vskActPortSkdEdiLogVO.getMtchModCd());
								}
							}
							
//							if (!"".equals(ediVslCd)) {
//								rtnVvdVOs = dbDao.searchHjsVvdByReceviedShipCallNoHjsVslCd(vskActPortSkdEdiLogVO);
//								
//								if (rtnVvdVOs.size() > 1) {
//									sbErrMsgs.append(new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//								} 
//							}
							
							if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSignNo)) {
								rtnVvdVOs  = dbDao.searchHjsVvdByReceviedShipCallNoCallSignNo(vskActPortSkdEdiLogVO);

								if (rtnVvdVOs.size() > 1) {
									sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
								} 
							}
							
							if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
								rtnVvdVOs  = dbDao.searchHjsVvdByReceviedShipCallNoImoNo(vskActPortSkdEdiLogVO);
								
								if (rtnVvdVOs.size() > 1) {
									sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
								}									
							}
						
							if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
								if (!"".equals(ediVslCd)) {
									sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
								} else if (!"".equals(callSignNo)) {
									sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
								} else if (!"".equals(llodyNo)) {
									sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
								}
								
								rtnPortVOs = dbDao.searchHjsVvdByReceviedShipCallNoAll(vskActPortSkdEdiLogVO);
								if (rtnPortVOs.size() != 0) {
									// EDI 전문에 의해서 Yard Code로 조회되지 않지만, Port Code로 조회될 경우 메세지 처리.
									sbErrMsgs.append(", Selection by Port : " + getPortVvdMsg(rtnPortVOs));
								}
							}							
						}
						
//					###################################################################################
//					# 셋업 정보 (vslCdFlg = "03" & "04") 로써, BKG Ship Call Number 로  SML VVD를 찾는다.
//					# >> 2013.02.21 "03" "04" 분리
//					###################################################################################
					} else if("04".equals(vslCdFlg)){

						//[Error] No exists a Vvd as a ship call number.($s)
						errNo = "VSK10063";
						
						String refCd 		= vskActPortSkdEdiLogVO.getShpCallNo();
						String mtchModCd 	= vskActPortSkdEdiLogVO.getMtchModCd();
						
						refCd 				= refCd		==null?"":refCd.trim	();
						mtchModCd 			= mtchModCd	==null?"":mtchModCd.trim();
						
						if(!"".equals(refCd) && !"".equals(mtchModCd)){
							
							rtnVvdVOs = dbDao.searchHjsVvdByReceviedShipCallNoHjsVslCd(vskActPortSkdEdiLogVO);
							
							//::2014-01-11:://if (rtnVvdVOs.size() > 1) {
							//::2014-01-11:://	sbErrMsgs.append("REF CD : "+ vskActPortSkdEdiLogVO.getShpCallNo() +"/MATCH_MODE : "+ vskActPortSkdEdiLogVO.getMtchModCd());
							//::2014-01-11:://}
							
							//::2014-01-11::[Ship Call No 중복시 Error Message 처리변경  - "The same ship call no [] is duplicated."]//
							if(rtnVvdVOs.size() > 1){
								sbDupShpCallNoMsgs.append("The same ship call no [");
								sbDupShpCallNoMsgs.append(vskActPortSkdEdiLogVO.getShpCallNo());
								sbDupShpCallNoMsgs.append("] is duplicated [");
								sbDupShpCallNoMsgs.append(rtnVvdVOs.size());
								
								if(rtnVvdVOs.size() == 2){
									sbDupShpCallNoMsgs.append("] twice.");
								}else{
									sbDupShpCallNoMsgs.append("] times.");	
								}
							}
							///////////////////////////////////////////////////////////////////////////////////////////////////////
						}
						
//							if (!"".equals(ediVslCd)) {
//								rtnVvdVOs = dbDao.searchHjsVvdByReceviedShipCallNoHjsVslCd(vskActPortSkdEdiLogVO);
//								
//								if (rtnVvdVOs.size() > 1) {
//									sbErrMsgs.append(new String[]{"VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo()};
//								} 
//							}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSignNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedShipCallNoCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedShipCallNoImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}									
						}
					
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
							if (!"".equals(ediVslCd)) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(callSignNo)) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(llodyNo)) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}
							
							rtnPortVOs = dbDao.searchHjsVvdByReceviedShipCallNoAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// EDI 전문에 의해서 Yard Code로 조회되지 않지만, Port Code로 조회될 경우 메세지 처리.
								sbErrMsgs.append(", Selection by Port : " + getPortVvdMsg(rtnPortVOs));
							}
						}						
						
//					#########################################################################
//					# 셋업 정보 (vslCdFlg = "05") 으로  SML VVD를 찾는다.
//					#########################################################################
					}else if("05".equals(vslCdFlg)){
						//[Error] No exists a VVD as a PAS code.($s)
						errNo = "VSK10070";
						
						if (!"".equals(ediVslCd)) {
							rtnVvdVOs = dbDao.searchHjsVvdByReceviedPsaVoyNoHjsVslCd(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(callSignNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedPsaVoyNoCallSignNo(vskActPortSkdEdiLogVO);

							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} 
						}
						
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0) && !"".equals(llodyNo)) {
							rtnVvdVOs  = dbDao.searchHjsVvdByReceviedPsaVoyNoImoNo(vskActPortSkdEdiLogVO);
							
							if (rtnVvdVOs.size() > 1) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}									
						}
					
						if ((rtnVvdVOs == null || rtnVvdVOs.size() == 0)) {
							if (!"".equals(ediVslCd)) {
								sbErrMsgs.append("VSL CD : "+ vskActPortSkdEdiLogVO.getEdiVslNm() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(callSignNo)) {
								sbErrMsgs.append("Call Sign No. : "+ vskActPortSkdEdiLogVO.getCallSgnNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							} else if (!"".equals(llodyNo)) {
								sbErrMsgs.append("IMO No. : "+ vskActPortSkdEdiLogVO.getLloydNo() +"/"+ vskActPortSkdEdiLogVO.getShpCallNo());
							}
							
							rtnPortVOs = dbDao.searchHjsVvdByReceviedPsaVoyNoAll(vskActPortSkdEdiLogVO);
							if (rtnPortVOs.size() != 0) {
								// EDI 전문에 의해서 Yard Code로 조회되지 않지만, Port Code로 조회될 경우 메세지 처리.
								sbErrMsgs.append(", Selection by Port : " + getPortVvdMsg(rtnPortVOs));
							}
						}
					}
					
					// CHM-201007580-01
					//
					// EDI 정보와 정확하게 일치하는 VVD를 못 찾은 경우
					// Trunk VVD에 한하여
					// Vessel Code & Port Code로 24시간 전후 VVD를 찾는다.
					// Trunk VVD이므로 조회된 결과가 한건이라면
					// SKD_VOY_NO, SKD_DIR_CD 등은 유저가 잘못입력한 것으로 본다.
					if (rtnVvdVOs == null || rtnVvdVOs.size()==0) {
						if(dbDao.searchVesselIsTrunk(vskActPortSkdEdiLogVO)){
							rtnVvdVOs = dbDao.searchOneDayVvdByYard(vskActPortSkdEdiLogVO);
						}
					}
					
					if (rtnVvdVOs == null || rtnVvdVOs.size() != 1) {
						failCnt++;
						
						if (rtnVvdVOs != null && rtnVvdVOs.size() > 1 ) {  //::jskjsk::2012.07.25//
							// EDI 전문에 의해서 SML VVD를 2건 이상 조회될 경우.
							sbErrMsgs.append(", Duplicated VVD : " + getDuplicateVvdMsg(rtnVvdVOs));
						}
						
						//::2014-01-11::Duplicated Ship Call # Error Message Setting:://
						if(!"".equals(sbDupShpCallNoMsgs.toString())){
							vskActPortSkdEdiLogVO.setRsltMsg(sbDupShpCallNoMsgs.toString());
							
						//::General Case:://
						}else{
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler(errNo, sbErrMsgs.toString()).getUserMessage());
						}
						
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}

					log.info("\n======================= mnvr in hrs 를 이용하여  ATA, ATB, ATD 등을 Setting =============\n");
					
//					#########################################################################
//					# mnvr in hrs 를 이용하여  ATA, ATB, ATD 등을 Setting.
//					#########################################################################
					
					String ediActArrDt 	= vskActPortSkdEdiLogVO.getEdiActArrDt	();
					String ediActBrthDt = vskActPortSkdEdiLogVO.getEdiActBrthDt	();
					String ediActDepDt 	= vskActPortSkdEdiLogVO.getEdiActDepDt	();
					
					if(VSKGeneralUtil.isNull(ediActArrDt) && VSKGeneralUtil.isNull(ediActBrthDt) && VSKGeneralUtil.isNotNull(ediActDepDt)){
						// ATA, ATB 는 이미 입력되어 있다는 가정하에 Pass(하단 로직에서 Actual Data 조회하여 정합성 판단.)
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
					}else{
						String actDateFlg 	= actEDISetupInfoVO.getActDateFlg();
						String mnvrInHrsFlg = actEDISetupInfoVO.getMnvrInHrsFlg();
						
						log.info("\n  actDateFlg 	=== ["+actDateFlg+"]\n" );
						log.info("\n  mnvrInHrsFlg 	=== ["+mnvrInHrsFlg+"]\n" );
						
						if("01".equals(actDateFlg)){
							// actDateFlg == 01 : ATA, ATD만 들어옴.
							
							if("Y".equals(mnvrInHrsFlg)){
								if(VSKGeneralUtil.isNotNull(ediActArrDt)){
									vskActPortSkdEdiLogVO.setActArrDt(ediActArrDt);
									String actBrthDt = dbDao.searchActBrthDtByMnvrInHrs(vskActPortSkdEdiLogVO);
									if(VSKGeneralUtil.isNull(actBrthDt)){
										failCnt++;
										// [Error] No exists Maneunvering In Hour.
										vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
										
										dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
										continue;
									}
									vskActPortSkdEdiLogVO.setActBrthDt(actBrthDt);
								}else{
									failCnt++;
									// [Error] No exists ATA, ATB.
									vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
									
									dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
									continue;
								}
							}else{
								failCnt++;
								// [Error] No exists ATA, ATB.
								vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
								
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}
							
						}else if("02".equals(actDateFlg)){
							// actDateFlg == 02 : ATB, ATD만 들어옴.
							if("Y".equals(mnvrInHrsFlg)){
								if(VSKGeneralUtil.isNotNull(ediActBrthDt)){
									vskActPortSkdEdiLogVO.setActBrthDt(ediActBrthDt);
									String actArrDt = dbDao.searchActArrDtByMnvrInHrs(vskActPortSkdEdiLogVO);
									if(VSKGeneralUtil.isNull(actArrDt)){
										failCnt++;
										// [Error] No exists Maneunvering In Hour.
										vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10073").getUserMessage());
										
										dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
										continue;
									}
									vskActPortSkdEdiLogVO.setActArrDt(actArrDt);
								}else{
									failCnt++;
									// [Error] No exists ATA, ATB.
									vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
									
									dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
									continue;
								}
							}else{
								failCnt++;
								// [Error] No exists ATA, ATB.
								vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
								
								dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
								continue;
							}
						}else if("03".equals(actDateFlg)){
							vskActPortSkdEdiLogVO.setActArrDt	(ediActArrDt);
							vskActPortSkdEdiLogVO.setActBrthDt	(ediActBrthDt);
						}else{
							failCnt++;
							// [Error] No exists ATA, ATB, ATD.
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
							
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}
						vskActPortSkdEdiLogVO.setActDepDt(ediActDepDt);
					}
					
					vskActPortSkdEdiLogVO.setVslCd		(rtnVvdVOs.get(0).getVslCd		());					
					vskActPortSkdEdiLogVO.setSkdVoyNo	(rtnVvdVOs.get(0).getSkdVoyNo	());
					vskActPortSkdEdiLogVO.setSkdDirCd	(rtnVvdVOs.get(0).getSkdDirCd	());
					
//					#########################################################################
//					# clpt_ind_seq 및 turnning 정보, virtual 정보 등을 찾아 Setting.
//					#########################################################################
					
					VskVslSkdVO vskVslSkdVO = new VskVslSkdVO();
					vskVslSkdVO.setVslCd	(vskActPortSkdEdiLogVO.getVslCd());
					vskVslSkdVO.setSkdVoyNo	(vskActPortSkdEdiLogVO.getSkdVoyNo());
					vskVslSkdVO.setSkdDirCd	(vskActPortSkdEdiLogVO.getSkdDirCd());
					
					vskVslSkdVO 		= dbDao.searchVskVslSkd(vskVslSkdVO);
					vskActPortSkdEdiLogVO.setVslSlanCd(vskVslSkdVO.getVslSlanCd());
					
					String clptIndSeq 	= dbDao.searchCallingIndicator(vskActPortSkdEdiLogVO);
					vskActPortSkdEdiLogVO.setClptIndSeq(clptIndSeq);
					VskVslPortSkdVO vskVslPortSkdVO = dbDao.searchOriginalVoyDir(vskActPortSkdEdiLogVO);
					
					if(vskVslPortSkdVO == null){
						failCnt++;
						String vslCd 		= vskActPortSkdEdiLogVO.getVslCd	();
						String skdVoyNo 	= vskActPortSkdEdiLogVO.getSkdVoyNo	();
						String skdDirCd 	= vskActPortSkdEdiLogVO.getSkdDirCd	();
						String vpsPortCd 	= vskActPortSkdEdiLogVO.getVpsPortCd();
						sbErrMsgs.append(vslCd +"/"+ skdVoyNo + "/" + skdDirCd + "/" + vpsPortCd + "/" + clptIndSeq);
						
						//[Error] No exists a vesssl port schedule.($s)
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10060", sbErrMsgs.toString()).getUserMessage());
						
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
						
					}else{
						if(VSKGeneralUtil.isVirtualPort(vskVslPortSkdVO.getTurnPortIndCd())){
							// Virtual 이면 해당 Turnning 찾아 Setting.
							String tmpSkdVoyNo 		= vskActPortSkdEdiLogVO.getSkdVoyNo();
							String tmpSkdDirCd 		= vskActPortSkdEdiLogVO.getSkdDirCd();
							String tmpClptIndSeq 	= clptIndSeq;
							
							vskActPortSkdEdiLogVO.setSkdVoyNo(vskVslPortSkdVO.getTurnSkdVoyNo());
							vskActPortSkdEdiLogVO.setSkdDirCd(vskVslPortSkdVO.getTurnSkdDirCd());
							clptIndSeq = vskVslPortSkdVO.getTurnClptIndSeq();
							
							vskVslPortSkdVO.setTurnPortFlg("Y");
							if("F".equals(vskVslPortSkdVO.getTurnPortIndCd())){
								vskVslPortSkdVO.setTurnPortIndCd("N");
							}else{
								vskVslPortSkdVO.setTurnPortIndCd("Y");
							}
							vskVslPortSkdVO.setTurnSkdVoyNo		(tmpSkdVoyNo	);
							vskVslPortSkdVO.setTurnSkdDirCd		(tmpSkdDirCd	);
							vskVslPortSkdVO.setTurnClptIndSeq	(tmpClptIndSeq	);
						}
					}
					
//					#########################################################################
//					# 기존에 입력되어 있는 Actual 정보를 찾아 기존 정보가 변경되지 않도록 Setting.
//					#########################################################################
					VskActPortSkdVO vvdPortVO = new VskActPortSkdVO();
					vvdPortVO.setVslCd		(vskActPortSkdEdiLogVO.getVslCd		());
					vvdPortVO.setSkdVoyNo	(vskActPortSkdEdiLogVO.getSkdVoyNo	());
					vvdPortVO.setSkdDirCd	(vskActPortSkdEdiLogVO.getSkdDirCd	());
					vvdPortVO.setVpsPortCd	(vskActPortSkdEdiLogVO.getVpsPortCd	());
					vvdPortVO.setClptIndSeq	(clptIndSeq);
					
					log.info("===== ####### ACT SKD DUP UPDATE CHECKING Started ===========" );
					
					VskActPortSkdVO returnActPortVO = dbDao.searchVskActPortSkd(vvdPortVO);
					
					if(returnActPortVO != null){
						
						/* VSK_ACT_PORT_SKD.ACT_DEPT_DT가 기존재하는경우 Fail Count 증가+VSK10059 */
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActDepDt())){
							failCnt++;
							/* VSK10059 :: [Failed] Already updated. */
							vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10059").getUserMessage());
							
							dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
							continue;
						}

						// (기존의 ATB 가 존재할 경우 User 입력 막음.)기존의 ATB 가 존재할 경우 User 가 입력한 ATB는 무시하고 기존의 ATB 로 Update 한다.
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActBrthDt())){
							vskActPortSkdEdiLogVO.setActBrthDt(returnActPortVO.getActBrthDt());
						}

						// (기존의 ATA 가 존재할 경우 User 입력 막음.)기존의 ATA 가 존재할 경우 User 가 입력한 ATA는 무시하고 기존의 ATA 로 Update 한다.
						if(VSKGeneralUtil.isNotNull(returnActPortVO.getActArrDt())){
							vskActPortSkdEdiLogVO.setActArrDt(returnActPortVO.getActArrDt());
						}
					}
					
					/* #########################################################################
					# ATA, ATB, ATD 가  비었을 경우 - 아래 조건에 따라 Error 처리.
					# ==========================================================================
					# 		ATA			ATB			ATD			Result
					#		 O			 O			 O			  Y			ABD
					#		 O			 O			 X			  Y			AB
					#		 O			 X			 X			  Y			A
					#		 O			 X			 O			  X
					#		 X			 O			 O			  X
					#		 X			 O			 X			  X
					#		 X			 X			 O			  X
					#		 X			 X			 X			  X
					############################################################################
					*/
					String sAta = "";
					String sAtb = "";
					String sAtd = "";
					
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActArrDt())){
						sAta = "A";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActBrthDt())){
						sAtb = "B";
					}
					if(VSKGeneralUtil.isNotNull(vskActPortSkdEdiLogVO.getActDepDt())){
						sAtd = "D";
					}
					
					String sAllStatus = sAta + sAtb + sAtd;
					if(!("ABD".equals(sAllStatus) || "AB".equals(sAllStatus) || "A".equals(sAllStatus))){
						failCnt++;
						// [Error] No exists ATA, ATB.
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10066").getUserMessage());
						
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
//					#########################################################################
//					# 이전 Port의 ETD 와 현재의 ATA 비교
//					#########################################################################
					
					// chkFlg 가 Y면 이상무, N이면 이전 포트와 시간 순서 역전된 것
					String chkFlg = dbDao.checkPreCallingPortInfo(vskActPortSkdEdiLogVO);
					
					if("N".equals(chkFlg)){
						
						// 이전 포트 ATD 비교 이후 오류 발생시
						// VVD의 Voyage No.와 Direction Code가 잘못 입력한 경우를 고려하여
						// Vessel Code + Actual SKD만으로 VVD를 조회하고
						// 조회된 VVD로 다시 이전 Port Check를 수행한다.
						
						if(dbDao.searchVesselIsTrunk(vskActPortSkdEdiLogVO)){
							
							// Vessel Code + Actual SKD만으로 VVD를 조회
							List<VskActPortSkdEdiLogVO> tmpVOs = dbDao.searchVvdByEdiActual(vskActPortSkdEdiLogVO);
							
							if(tmpVOs !=null && tmpVOs.size()==1){

								// 조회된 다른 VVD
								if(!(		vskActPortSkdEdiLogVO.getVslCd		().equals(tmpVOs.get(0).getVslCd	()) 
										&&	vskActPortSkdEdiLogVO.getSkdVoyNo	().equals(tmpVOs.get(0).getSkdVoyNo	()) 
										&&	vskActPortSkdEdiLogVO.getSkdDirCd	().equals(tmpVOs.get(0).getSkdDirCd	())
									))
								{
									
									vskActPortSkdEdiLogVO.setVslCd		(tmpVOs.get(0).getVslCd		());
									vskActPortSkdEdiLogVO.setSkdVoyNo	(tmpVOs.get(0).getSkdVoyNo	());
									vskActPortSkdEdiLogVO.setSkdDirCd	(tmpVOs.get(0).getSkdDirCd	());
									
									//::jskjskjsk:2013-04-26:://tmpVOs.get(0).getClptIndSeq();
									vskActPortSkdEdiLogVO.setClptIndSeq	(tmpVOs.get(0).getClptIndSeq());
									
									// 조회된 다른 VVD로 이전 포트 체크 다시 수행
									chkFlg = dbDao.checkPreCallingPortInfo(vskActPortSkdEdiLogVO);
								}
							}
						}
					}
					
					if("N".equals(chkFlg)){
						failCnt++;
						sbErrMsgs.append(vskActPortSkdEdiLogVO.getActArrDt());
						// [Error] Current ATA($s) is faster than  ETD of previous VVD.
						vskActPortSkdEdiLogVO.setRsltMsg(new ErrorHandler("VSK10067", sbErrMsgs.toString()).getUserMessage());
						
						dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
						continue;
					}
					
					//User 정보 Setting.
					vskActPortSkdEdiLogVO.setCreUsrId(usrId);
					vskActPortSkdEdiLogVO.setUpdUsrId(usrId);
					
					successCnt++;
					
					vskVslPortSkdVO.setClptIndSeq(clptIndSeq);
					vskVslPortSkdVOs.add(vskVslPortSkdVO);
					
					if (returnActPortVO != null) {
						vskActPortSkdVOs.add(returnActPortVO);
					}
				
					rtnVskActPortSkdEdiLogVOs.add(vskActPortSkdEdiLogVO);
				} // end for
				
				rtnEdiLogDataGRPVO.setVskActPortSkdEdiLogVOs	(rtnVskActPortSkdEdiLogVOs	);
				rtnEdiLogDataGRPVO.setVskVslPortSkdVOs			(vskVslPortSkdVOs			);
				
				if (vskActPortSkdVOs != null && vskActPortSkdVOs.size() > 0) {
					rtnEdiLogDataGRPVO.setVskActPortSkdVOs		(vskActPortSkdVOs			);
				}
				
				rtnEdiLogDataGRPVO.setValue1					(successCnt					);
				rtnEdiLogDataGRPVO.setValue2					(failCnt					);
			}
			
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage(), ex);
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage(), ex);
		}
		
		log.info("################### auditReceivedEdiData() FINISH>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		return rtnEdiLogDataGRPVO;
	}
	
	/**
	 * EDI 수신 정보를 이용해 SML VVD를 조회했을 경우 2건 이상 조회된 VVD를 Error Remark를 표시한다.
	 * 
	 * List<VskActPortSkdEdiLogVO> vvdVOs
	 * @return String
	 */
	 
	private String getDuplicateVvdMsg(List<VskActPortSkdEdiLogVO> vvdVOs){
		
		StringBuffer vvdMsg = new StringBuffer();
		
		for(int i=0; i<vvdVOs.size(); i++){
			vvdMsg.append("(").append(vvdVOs.get(i).getVslCd()).append("/").append(vvdVOs.get(i).getSkdVoyNo()).append("/").append(vvdVOs.get(i).getSkdDirCd()).append(")");
		}
		
		return vvdMsg.toString();
		
	}
	
	/**
	 * EDI 수신 정보를 이용해 Yard Code로 찾지 못했지만, Port Code 로 SML VVD를 조회 했을 경우 Error Remark를 표시한다.
	 * 
	 * List<VskActPortSkdEdiLogVO> portVOs
	 * @return String
	 */
	 
	private String getPortVvdMsg(List<VskActPortSkdEdiLogVO> portVOs){
		StringBuffer portMsg = new StringBuffer();
		
		for(int i=0; i<portVOs.size(); i++){
			portMsg.append("(").append(portVOs.get(i).getVslCd()).append("/").append(portVOs.get(i).getSkdVoyNo()).append("/").append(portVOs.get(i).getSkdDirCd()).append("/").append(portVOs.get(i).getYdCd()).append(")");
		}
		
		return portMsg.toString();
	}
	
	/**
	 * MQ 메세지 전문 저장 및 체크.<br>
	 * 터미널에 입력해 준 EDI 데이터 원본을 DB[VSK_ACT_PORT_SKD_EDI_LOG]에 저장한다.<br>
	 * 
	 * @param VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyVskActPortSkdEdiLog(VskActPortSkdEdiLogVO vskActPortSkdEdiLogVO, SignOnUserAccount account) throws EventException{
		try{
			dbDao.modifyVskActPortSkdEdiLog(vskActPortSkdEdiLogVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 입력중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10036").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * SPP에서 받은 조건으로 Calling하는 Vvd를 조회.<br>
	 * 입력받은 Port Code를 ETA 기준 -7일 ~ +7일에 Calling하는 Vvd를 조회한다.<br>
	 * 
	 * @param String vpsPortCd
	 * @param String vslSvcTpCd
	 * @return List<VvdListByPortVO>
	 * @exception EventException
	 */
	public List<VvdListByPortVO> searchSppVvdListByPort(String vpsPortCd, String vslSvcTpCd) throws EventException {
		try {
			return dbDao.searchSppVvdListByPort(vpsPortCd,vslSvcTpCd);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Actualschedulemgt화면에 대한 조회 이벤트 처리<br>
	 * Actual Schedule History를 조회 한다.<br>
	 * 
	 * @param VvdPortLaneOtherVO vvdPortLaneOtherVO
	 * @return List<ActPortSkdHisVO>
	 * @exception EventException
	 */
	public List<ActPortSkdHisVO> searchActPortSkdHis(VvdPortLaneOtherVO vvdPortLaneOtherVO) throws EventException{
		try {
			return dbDao.searchActPortSkdHis(vvdPortLaneOtherVO);
		} catch (DAOException ex) {
			/*
			 * MSG - 조회중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10035").getMessage());
		} catch (Exception ex) {
			/*
			 * MSG - 서비스 실행중 오류가 발생하였습니다.
			 */
			throw new EventException(new ErrorHandler("VSK10039").getMessage());
		}
	}
	
	/**
	 * Actual Port Schedule 정보를 삭제합니다.
	 *  
	 * @param List<VvdVO> vvdVOs
	 * @exception EventException
	 */
	public void removeVskActPortSkd(List<VvdVO> vvdVOs) throws EventException {
		try{
			for(int i=0; i<vvdVOs.size(); i++){
				dbDao.removeVskActPortSkd(vvdVOs.get(i));
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("VSK10037").getMessage(), ex);
		}
	}
	
}