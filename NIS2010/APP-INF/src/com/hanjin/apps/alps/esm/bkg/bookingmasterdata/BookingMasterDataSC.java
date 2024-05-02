/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingMaterDataSC.java
 *@FileTitle : Mark & Description Template
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.27 김영출
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2010.09.02 김영철 [CHM-201004943-01] Manual BDR시 History 에 로그 남기도록 함.
 * 2011.10.21 조원주 [CHM-201113594-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 Doc Center Office Hour 개발
 * 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
 * 2012.02.23 박성호[CHM-201115347] BKG 한국지역 사전 적하목록 제출 시간 변경에 따른 Cut-off time 변경 요청
 * 2012.02.24 변종건 [CHM-201216228-01] ALPS COMMON USER INFORMATION 상 E-mail column을 BKG/DOC Client default 화면으로 이동
 * 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
 * 2012.09.10 조정민 [] Hard Coding setup화면 추가
 * 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
 * 2012.10.29 윤태승 [CHM-201220903] [Office Setup] 추가시 로직보완
 * 2014.04.01 신규정 [CHM-201429292 ]  Manual BDR 권한 설정 메뉴 신규 개발
 * 2014.06.10 문동선 [CHM-201430335] 미주 bkg handling office 지정을 위한 set up 메뉴 추가
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - Web Booking Manual Upload Setup Table 추가
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ContinentCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchPortCdByVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchSvcLaneBoundVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingProcessMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.CustomsMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.CustomsMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Cms0070001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0050001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0060001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.Edi0070001Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0019Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0040Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0073Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0082Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0153Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0192Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0253Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0354Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0374Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0441Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0554Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0589Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0592Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0594Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg059601Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0596Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0597Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0607Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0653Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0696Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0741Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0949Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0975Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1030Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1060Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1114Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1130Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1131Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1150Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1180Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg1185Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2004Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2005Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg9456Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BdrAccessAuthorityInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsAdvScacVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsChnAgnCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDocPerfOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDpcsOfcTmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMapgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkganDestOfcStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgcustomscanadagrouplocationVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CgoClzTmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtDupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0064Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0154Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0232Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0237Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0238Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0239Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0320Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0325Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0365Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0384Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0743Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0922Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0976Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1075Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1173Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1215Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1509Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg1410Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg9461Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.integration.UserSetupMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemTpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.DraftBlImageVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.TroRmkStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.WebBkgManualUploadSetupVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnAgnStupVO;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImpImgStoVO;
import com.hanjin.syscommon.common.table.BkgMTPickupCYVO;
import com.hanjin.syscommon.common.table.BkgRateVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgUsrTmpltVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.management.alps.user.basic.UserBC;
import com.hanjin.syscommon.management.alps.user.basic.UserBCImpl;

/**
 * NIS2010-BookingMaterData Business Logic ServiceCommand -
 * NIS2010-BookingMaterData 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Youngchul
 * @see UserSetupMgtDBDAO
 * @since J2EE 1.4
 */

public class BookingMasterDataSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * BookingMaterData system 업무 시나리오 선행작업<br>
     * 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * BookingMaterData system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("BookingMaterDataSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * NIS2010-BookingMaterData system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
    	log.debug("[START:: BookingMasterDataSC perform== e.getEventName() ]=========="+e.getEventName());
        /* UiBkg0365Event */
        if (e.getEventName().equalsIgnoreCase("EsmBkg0365Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchUserTmpltList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0384Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchUserTmpltList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }else{
            	eventResponse = searchUserTmpltList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0082Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchMTPickUpCY(e);
        	}	
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0154Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchUserDefaultSettingByBooking(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = createUserDefaultSettingByBooking(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchComCode0154(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0232Event")) {
         	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
          		eventResponse = searchUserXterSearchSet(e);
          	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserXterSearchSet(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0976Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchRmkTemplate(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageUserTmpltList(e);
            }
        }
        
        else  /* EsmBkg0019Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0019Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchEtbEtdEta(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchSvcLaneByLoc(e);
                }    
    	}
        else 
            if (e.getEventName().equalsIgnoreCase("EsmBkg0607Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchHTSCode(e);
            }else if(e.getFormCommand().isCommand(FormCommand.INIT)) {
            	eventResponse = searchComCode0607(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = manageHtsCode(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	eventResponse = searchHTSCode(e);
            }
        }
           
        else  /* EsmBkg0696Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0696Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchPackageCode (e);
            	}  
    	}
        else  /* EsmBkg0653Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0653Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchCmdtCdRepCmdtCd (e);
            	}  
    	}
        else  /* EsmBkg0554Event */
            if(e.getEventName().equalsIgnoreCase("EsmBkg0554Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchWareHouse (e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                    eventResponse = manageWareHouse(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                    eventResponse = searchLocation(e);
                }
            	
    	}
        else  /* EsmBkg0040Event */
        	if(e.getEventName().equalsIgnoreCase("EsmBkg0040Event")) {
        		
        		if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        			eventResponse = searchScacNumber (e);
                } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                    eventResponse = manageScacNumber (e);
                }
                	
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0596Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchBDRTime (e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                    eventResponse = modifyBDRLog(e);
            	} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {
                    eventResponse = modifyBDRLog(e);
                } else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                	eventResponse = searchComCode0596_vvd_port(e);
                }
            	
    	}
        else if(e.getEventName().equalsIgnoreCase("EsmBkg059601Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBDRTimeRHQ (e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyBDRLogRHQ(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
                eventResponse = modifyBDRLogRHQ(e);
        	}
        	
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0320Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchUserInternetAuth(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchUserInternetAuth(e); 
	        }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = manageUserInternetAuth(e);
	    	}
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0743Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchUserPrintSetup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchHouseBlRirderBl(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchUserPrintSetup3(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = manageUserPrintSetup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = modifyOBLRlseFlg(e);
	    	} 	    	
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0922Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfficeDetail(e);
			} 	    	
		} 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserPrintSetup0064(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageUserPrintSetup(e);
			} 	    	
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0073Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchBDRPol(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchBDRTimeTable(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageVVDBDRTime(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = manageBKGBDRLOG(e);    
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchComCode0073(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchComCode0073_port(e);  
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchComCode0073_port(e);        
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchComCode0073_vvd_port(e);    
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0253Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchEqualizetionPortCD(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageEqualizationPort(e);
        	} 
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0192Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInBoundCustList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInBoundCustTmpltList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageInBoundCustList(e);
            } 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0592Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchDPSCUserGroup(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageDPSCUserGroup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchComCode0592(e);
            }	
           		
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0153Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchChinaAgentCodeList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageChinaAgentCode (e);
           	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = searchCheckCode0153(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = searchCheckCode0153(e);
            }
           		
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0741Event")) {
           	
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchOfficePfmc(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageOfficePfmc(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkOfficePfmc(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkBkgOfcPorPfmc(e);
            }
        }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0354Event")) {
			if( e.getFormCommand().isCommand(FormCommand.SEARCH) ){
        		eventResponse = searchCanadaGroupLocationCD(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH01) ){
				eventResponse = searchCanadaGroupLocationCD2(e);
			} else if( e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
				eventResponse = searchYardDesc(e);
        	} else if( e.getFormCommand().isCommand(FormCommand.SEARCH03) ){
				eventResponse = searchLocDesc(e);
        	} else if( e.getFormCommand().isCommand(FormCommand.MULTI) ){
                eventResponse = manageCanadaGroupLocationCD(e);
            } 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0374Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchANDestOfcList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchANDestOfcList2(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageANDestOfcList(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("Cms0070001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCustSlsRep(e);
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0949Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		
				eventResponse = searchDocCutOffTimeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				
				eventResponse = searchServiceLane();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				
				eventResponse = searchLocationCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {

				eventResponse = searchDayTypeCode();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				
				eventResponse = searchVvdCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                
				eventResponse = manageDocCutOffTimeList(e);
            } 
		}
        /* EsmBkg0975Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0975Event")) {
            	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                    eventResponse = searchChargeCode(e);
            	}  
    	}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1030Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		
				eventResponse = searchMandatoryItemSetupList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                
				eventResponse = manageMandatoryItemSetupList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                
				eventResponse = checkCustCd(e);
            }  
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1060Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChnMnlBkgNoGenList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createChnMnlBkgNoGenList(e);
			}
        } 
        else if ("Edi0050001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiTrdPrnrSubLnk(e);
			} 
        } 
        else if ("Edi0060001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiSubLnkMsg(e);
			} 
        } 
        else if ("Edi0070001Event".equalsIgnoreCase(e.getEventName())) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = receiveBkgEdiPrnrPortLane(e);
			} 
		}
        /* EsmBkg1075Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1075Event")){
            if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
                eventResponse = searchCombo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRptItmStup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRptItmStup(e);
            }
        }
        /* EsmBkg1114Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1114Event")) {
        	 if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchMdmCnt(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchZipCode(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
          		eventResponse = manageZipCode(e);
            }	
           		
        }
        /* EsmBkg9456Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9456Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchCstmsChnAgnStup(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCstmsChnAgnStup(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = searchCstmsChnAgnCdList(e);

             }
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0441Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchDpcsOfcTm(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageDpcsOfcTm(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchComCode0592(e);
            }	
		}
        /* EsmBkg1130Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1130Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchRestrictCmdtList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
               		eventResponse = searchRestrictCmdtDupList(e); // restrict duplication check
           	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
           		eventResponse = searchValidateLocByOrz(e); // RHQ country code check
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRetrictCmdtList(e);
           	}
		}
        
        /* EsmBkg1131Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1131Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchRestrictCmdtFile(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRetrictCmdtFile(e);
           	}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0589Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchSmsRcvList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSmsRcvList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchComCode0589(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
           		eventResponse = chkOfcCnt(e);
            }
       		
        } 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0594Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchCgoClzTmStupList(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCgoClzTmList(e); 
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = chkSetUpCnt(e);
            }
       		
        } 
        /* EsmBkg1150Event */
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1150Event")) { 
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchMapgVvd(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageMapgVvd(e);
           	}
		}
        /* EsmBkg2004Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg2004Event")) {

			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHrdCdgDesc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkHrdCdgId(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkChildCnt(e);
			}
			
       }
        /* EsmBkg2005Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg2005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHrdCdgCtnt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHrdCdgCtnt(e);
			}
       }
        
        /* EsmBkg1173Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1173Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTroRmkStup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageTroRmkStup(e);
            }
        }
        
        /* EsmBkg1215Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1215Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeBkgAlocMgmt(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchComCode1215(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchBkgAlocValidationData(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchCmdtNm(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchScgGrpCmdtCdList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchGrpCmdtNm(e);
            }
        }
        
        /* EsmBkg0597Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0597Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchBdrAccessAuthority(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBdrAccessAuthority(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchComUserBdrAccessAuthority(e);
			}
            
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1180Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchHandlingOffice(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageHandlingOffice(e);
            }
        }
        
        /* EsmBkg1509Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1509Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchDraftBlImageList(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageDraftBlImage(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchDraftBlImageCustCodeYN(e);
            }
        }
        
        /* EsmBkg1410Event */
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1410Event")){
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchWebBkgManualUploadSetup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI) || e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = manageWebBkgManualUploadSetup(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	eventResponse = searchWebBkgManualUploadSetupDupChk(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
            	eventResponse = searchWebBkgManualUploadSetupSvcLaneByVvd(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
            	eventResponse = searchWebBkgManualUploadSetupValidateVvdLoc(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
            	eventResponse = searchWebBkgManualUploadSetupvalidateVvdCnt(e);
            }
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmBkg9461Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchUserSearchSet(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {  
                eventResponse = manageUserSearchSet(e);
            }
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0237Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchCustChkPnt(e);
           	}if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
           		eventResponse = searchBkgChkPntItem(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
           		eventResponse = searchBkgChkPntItemTp(e);
           	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {  
                eventResponse = manageBkgCustChkPnt(e);
            }
        }
        
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0238Event")) {
			 if(e.getFormCommand().isCommand(FormCommand.MULTI)) {  
                eventResponse = manageBkgChkPntItem(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {  
                eventResponse = manageBkgChkPntItemTp(e);
            }
        }
        
        if(e.getEventName().equalsIgnoreCase("EsmBkg0239Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustChkPntAttach(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustChkPntAttach(e);
			}
		}
        
        //0324는 0325이벤트 객체 사용
        if(e.getEventName().equalsIgnoreCase("EsmBkg0325Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgBlckKwList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageBkgBlckKwList(e);
			}
		}
        /* EsmBkg1185Event */
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1185Event")) {
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		
				eventResponse = searchVgmCutOffTimeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				
				eventResponse = searchServiceLaneForVgm();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				
				eventResponse = searchLocationCodeForVgm(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {

				eventResponse = searchDayTypeCodeForVgm();
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				
				eventResponse = searchVvdCodeForVgm(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                
				eventResponse = manageVgmCutOffTimeList(e);
            } 
		}
        return eventResponse;
    }
    /**
     * BKG_ESM_0589 : SEARCH02<br>
     * User sms ofc check 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse chkOfcCnt(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0589Event event = (EsmBkg0589Event)e;
    	BookingProcessMgtBC command = null;
//    	String usrId = null;
//    	String dpcsWrkGrpCd = null;
//		List<BkgUserSmsListVO> list = null;
    	String cnkOfcCnt = "";
    	
		try {
	    	command = new BookingProcessMgtBCImpl();
//	    	usrId = event.getUsrId();
//	    	dpcsWrkGrpCd = event.getDpcsWrkGrpCd();
	    	cnkOfcCnt = command.chkOfcCnt(account, event.getBkgUserSmsInputVO().getChkSlanCd(), event.getBkgUserSmsInputVO().getChkDirCd());
//			eventResponse.setRsVoList(list);
	    	eventResponse.setETCData("ofc_cnt", cnkOfcCnt);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * BKG_ESM_0589 : MULTI<br>
     * User sms 정보 저장
     * @param Event e
     * @return EventResponse eventResponse
     * @throws EventException
     */
    private EventResponse manageSmsRcvList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0589Event event = (EsmBkg0589Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
//		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgUserSmsListVO[] bkgUserSmsListVOs = event.getBkgUserSmsListVOs();
//			for ( int i=0; i<bkgDpcsUsrGrpVOs.length; i++ ) {
//				if ( bkgDpcsUsrGrpVOs[i].getIbflag().equals("I") ||  bkgDpcsUsrGrpVOs[i].getIbflag().equals("U")){
//					
//					if (command2.searchUserName(bkgDpcsUsrGrpVOs[i].getUsrId()).equals("")){
//						
//						eventResponse.setUserMessage((String) new ErrorHandler("BKG00512",new String[]{}).getUserMessage());
//						return eventResponse;
//					}
//				}
//			}
			
			begin();
			command.manageSmsRcvList(bkgUserSmsListVOs, account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
     * BKG_ESM_0589 : SEARCH<br>
     * User sms 정보를 관리화면네 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSmsRcvList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0589Event event = (EsmBkg0589Event)e;
    	BookingProcessMgtBC command = null;
//    	String usrId = null;
//    	String dpcsWrkGrpCd = null;
		List<BkgUserSmsListVO> list = null;
		try {
	    	command = new BookingProcessMgtBCImpl();
//	    	usrId = event.getUsrId();
//	    	dpcsWrkGrpCd = event.getDpcsWrkGrpCd();
			list = command.searchSmsRcvList(event.getBkgUserSmsInputVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    
	/**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0589화면에 대한 콤보리스트 조회.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0589(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
//        List<BkgComboVO> list3 = null;
        try {
            //Direction
        	command = new BookingUtil();
            list = command.searchCombo("CD00593");
            eventResponse.setRsVoList(list);
            //L/T
            list2 = command.searchCombo("CD01073");
            eventResponse.setRsVoList(list2);
//            list3 = command.searchCombo("CD02569");
//            eventResponse.setRsVoList(list3);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    

    /**
     * BKG_ESM_0594 : SEARCH<br>
     * Cargo Closing Time Setup 정보를 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCgoClzTmStupList (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0594Event event = (EsmBkg0594Event)e;
    	BookingProcessMgtBC command = null;
		List<CgoClzTmStupVO> list = null;
		try {
	    	command = new BookingProcessMgtBCImpl();
			list = command.searchCgoClzTmStupList(event.getCgoClzTmStupVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * BKG_ESM_0594 : MULTI<br>
     * cargo closing time setup 정보 저장
     * @param Event e
     * @return EventResponse eventResponse
     * @throws EventException
     */
    private EventResponse manageCgoClzTmList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0594Event event = (EsmBkg0594Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
		
		try {
			CgoClzTmStupVO[] cgoClzTmStupVOs = event.getCgoClzTmStupVOs();
			
			begin();
			command.manageCgoClzTmList(cgoClzTmStupVOs, account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
     * BKG_ESM_0594 : SEARCH01<br>
     * Cargo Closing Time Setup check 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse chkSetUpCnt(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0594Event event = (EsmBkg0594Event)e;
    	BookingProcessMgtBC command = null;
    	List<CgoClzTmStupVO> list = null;
    	
		try {
	    	command = new BookingProcessMgtBCImpl();
	    	list = command.chkSetUpCnt(account, event.getCgoClzTmStupVO().getChkPolCd(), event.getCgoClzTmStupVO().getChkLaneCd(),  event.getCgoClzTmStupVO().getChkDirCd());
	    	    	
	    	eventResponse.setETCData("setup_cnt",list.get(0).getSetupCnt());
	    	eventResponse.setETCData("pol_cnt",list.get(0).getPolCnt());
	    	eventResponse.setETCData("lane_cnt",list.get(0).getLaneCnt());
	    	eventResponse.setETCData("dir_cnt",list.get(0).getDirCnt());
	    	
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
     * 조회 이벤트 처리<br>
     * ChargeCode의 event에 대한 조회 이벤트 처리<br>
     * searchChargeCode<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0975Event event = (EsmBkg0975Event) e;
        BookingProcessMgtBC command = null;
        List<CodeDescVO> list = null;
        try {
        	command = new BookingProcessMgtBCImpl();
	        list = command.searchChargeCode(event.getCodeDescVO());
	        eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * SCAC (Standard Carrier Alpha Code) 조회<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchScacNumber(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0040Event event = (EsmBkg0040Event) e;
        BookingProcessMgtBC command = null;
        List<BkgCstmsAdvScacVO> list = null;
        try {
	        //BDR LOG TEST 
	        /*BookingMasterMgtBC command2 = new BookingMasterMgtBCImpl();
	        command2.manageBkgVVDBdrLog("CYAK", "0002", "E");
	        */
        	command = new BookingProcessMgtBCImpl();
            list = command.searchScacNumber(event.getBkgCstmsAdvScacVO());
	        eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 입력수정삭제 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 입력,수정 이벤트 처리<br>
     * SCAC (Standard Carrier Alpha Code) 입력,수정,삭제<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageScacNumber(Event e) throws EventException {
    	 GeneralEventResponse eventResponse = new GeneralEventResponse();
    	 EsmBkg0040Event event = (EsmBkg0040Event) e;
    	 BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
         try {
             begin();
             command.manageScacNumber(event.getBkgCstmsAdvScacVOS());
             eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
             commit();
         } catch(EventException ex) {
             rollback();
             throw ex;
         } catch (Exception ex) {
             rollback();
             throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
         }
         return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * UserSetupMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchUserTmpltList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil bookingUtil = null;
        UserSetupMgtBC command = null;
        BkgUsrTmpltVO bkgUsrTmplt = null;
        BkgBlNoVO bkgBlNo = null;
        PpdCctCustInVO ppdCctCustInVO = null;
        BkgRateVO bkgRate = null;
        List<BkgUsrTmpltVO> list = null;
        try{
        	String tmpltTpCd = "";
        	if (e.getEventName().equalsIgnoreCase("EsmBkg0384Event")) {
        		//EsmBkg0384Event event = (EsmBkg0384Event) e;
        		tmpltTpCd = "R";//event.getBkgUsrTmpltVO().getTmpltTpCd();
        	} else if (e.getEventName().equalsIgnoreCase("EsmBkg0365Event")) {
        		EsmBkg0365Event event = (EsmBkg0365Event) e;
    			bookingUtil = new BookingUtil();
    			bkgBlNo = new BkgBlNoVO();
    			if(null != event.getBkgNo() && !"".equals(event.getBkgNo())){
        			bkgBlNo.setBkgNo(event.getBkgNo());
        			bkgBlNo.setCaUsrId(account.getUsr_id());
        			bkgBlNo = bookingUtil.searchBkgBlNoVO(bkgBlNo);
    	            ppdCctCustInVO = new PpdCctCustInVO();
    	            ppdCctCustInVO.setBkgNo(bkgBlNo.getBkgNo());
    	            ppdCctCustInVO.setCallType("CCT");
    	            ppdCctCustInVO.setCaFlg(bkgBlNo.getCaFlg());
    	            bkgRate = bookingUtil.searchBkgRate(bkgBlNo.getBlNo());
    	            if (null!=bkgRate) {
    	            	eventResponse.setETCData("ofc_cd", bkgRate.getCltOfcCd());
    	            }
    			}
        	}
            bkgUsrTmplt = new BkgUsrTmpltVO();
            bkgUsrTmplt.setUsrId(account.getUsr_id());
            bkgUsrTmplt.setTmpltTpCd(tmpltTpCd);
            command = new UserSetupMgtBCImpl();
            list = command.searchUserTmpltList(bkgUsrTmplt);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * 멀티 이벤트 처리<br>
     * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageUserTmpltList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        try {
            begin();
            if (e.getEventName().indexOf("0365") > 0) {
                EsmBkg0365Event event = (EsmBkg0365Event) e;
                command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);
            }else if (e.getEventName().indexOf("0384") > 0) {
                    EsmBkg0384Event event = (EsmBkg0384Event) e;
                    command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);    
            } else {
            	EsmBkg0976Event event = (EsmBkg0976Event) e;
                command.manageUserTmpltList(event.getBkgUsrTmpltVOS(), account);
            }
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * 지정한 Yard의 Available MT status per day(estimated) 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchMTPickUpCY(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmBkg0082Event event = (EsmBkg0082Event) e;
        MdmYardVO vo = event.getMdmYardVO();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
        BookingUtil command2 = new BookingUtil();

      
        /*String yardCode = JSPUtil.getNull(vo.getLocCd());
        if (yardCode.equals("")){
        	 yardCode = JSPUtil.getNull(vo.getLocCd());
        }*/
        String toDaty = JSPUtil.getKSTDate();
        
        List<MdmYardVO> mList = null;
        List<BkgMTPickupCYVO> dList = null;
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
	    try {  
	        if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	        	mList = command2.searchYardCode(vo);
	        	eventResponse.setRsVoList(mList);
	        }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	        	String yardCode = JSPUtil.getNull(event.getSelectSheetYdCd());
	        	dList = command.searchMTPickUpCY(yardCode,toDaty);
	        	eventResponse.setRsVoList(dList);
	        }
    	} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
        return eventResponse;
    }
    /**
     * ESM_BKG_0607_C : 화면 수정/저장/삭제 이벤트 발생시 처리 <br>
     * 미주 신고를 위한 화물의 Code(Commodity code와 유사).<br>
     * 
     * @param e EsmBkg0607Event
     * @return response EventResponse
     * @exception EventException
     */

   private EventResponse manageHtsCode(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();      
    	EsmBkg0607Event event = (EsmBkg0607Event) e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	 String hamoTpCd = event.getHamoTpCd();                                 
       try {
            begin();
            BkgHamoTrfVO[] bkgHamoTrfVOS = event.getBkgHamoTrfVOS();
            for(int i = 0; i < bkgHamoTrfVOS.length; i++){
            	bkgHamoTrfVOS[i].setHamoTpCd(hamoTpCd);
            }
            command.manageHtsCode(bkgHamoTrfVOS,account.getUsr_id());                                            
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
   
 

	
    /**
     * ESM_BKG_0607 : 화면 조회 이벤트 발생시 처리 <br>
     * 미주 신고를 위한 화물의 Code(Commodity code와 유사).<br>
     * 
     * @param e EsmBkg0607Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchHTSCode(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0607Event event = (EsmBkg0607Event) e;
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
        List<BkgHamoTrfVO> list = null;
        try {
        	list = command.searchHTSCode(event.getBkgHamoTrfVO(),event.getIPage());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0607 : 화면 로딩시 Combo Search <br>
     * 
     * @param e EsmBkg0607vent
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0607(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        List<BkgComboVO> list = null;
        try {
        	//HTS CODE Type
        	command = new BookingUtil();
	        list = command.searchCombo("CD02190");
	        eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
	        throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
        return eventResponse;
    }
    
    

    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 멀티 이벤트 처리<br>
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 조회한다.<br>
     * @param e EsmBkg0607Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchUserDefaultSettingByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0154Event event = (EsmBkg0154Event) e;
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
         
        
        if (JSPUtil.getNull(event.getBkgUsrDfltSetVO().getUsrId()).equals("")){
        	event.getBkgUsrDfltSetVO().setUsrId(account.getUsr_id());
        }
        try {
            BkgUsrDfltSetVO usrDfltSetVO = command.searchUserDefaultSetting(event.getBkgUsrDfltSetVO().getUsrId());
        	if(usrDfltSetVO!=null){
        	    eventResponse.setETCData(usrDfltSetVO.getColumnValues());
        	}
        	eventResponse.setETCData("cnt_cd",account.getCnt_cd());
            //eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 멀티 이벤트 처리<br>
     * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse createUserDefaultSettingByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0154Event event = (EsmBkg0154Event) e;
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        BookingUtil command2 = new BookingUtil();
        UserBC command3 = new UserBCImpl();
        
        if (JSPUtil.getNull(event.getBkgUsrDfltSetVO().getUsrId()).equals("")){
        	event.getBkgUsrDfltSetVO().setUsrId(account.getUsr_id());
        }
        event.getBkgUsrDfltSetVO().setCreUsrId(account.getUsr_id());
        event.getBkgUsrDfltSetVO().setUpdUsrId(account.getUsr_id());
        String toDaty = JSPUtil.getKSTDate();
        event.getBkgUsrDfltSetVO().setCreDt(toDaty);
        event.getBkgUsrDfltSetVO().setUpdDt(toDaty);
        
        try {
        	
        	/*******************************************************************
        	Empty P/UP CY MDM YARD CODE  등록  CHECK.
        	*******************************************************************/
        	MdmYardVO yardVo =  new MdmYardVO();;
        	yardVo.setYdCd(event.getBkgUsrDfltSetVO().getMtyPkupYdCd());
        	
        	List<MdmYardVO> yardList= command2.searchYardCode(yardVo);

        	if (yardList == null || yardList.size() < 1) {
        		String message = "Empty P/UP CY [" + event.getBkgUsrDfltSetVO().getMtyPkupYdCd() +"] is not registered in DB(MDM_YARD)";
        		eventResponse.setUserMessage(message);
				return eventResponse;
			}
        	/*******************************************************************/
            begin();
            command.createUserDefaultSettingByBooking(event.getBkgUsrDfltSetVO());
            command3.modifyDfltEml(account.getUsr_id(), event.getBkgUsrDfltSetVO().getDfltEml());
            //eventResponse.setUserMessage(new ErrorHandler("BKG00110").getUserMessage());
            //eventResponse.setUserMessage((String) new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
			
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    /**
     * 조회 이벤트 처리<br>
     * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEtbEtdEta (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0019Event event = (EsmBkg0019Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try {
			List<VskVslPortSkdConditionVO> list = command.searchEtbEtdEta(event.getVskVslPortSkdConditionVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchSvcLaneByLoc (Event e) throws EventException {
    	//EsmBkg0019Event event = (EsmBkg0019Event)e;
    	BookingUtil command = new BookingUtil();
    	
		try {
			List<MdmVslSvcLaneVO> list = command.searchSvcLaneCd();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }

    /**
     * 조회 이벤트 처리<br>
     * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * Package Code 및 Description을 검색 및 조회 </br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchPackageCode (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0696Event event = (EsmBkg0696Event)e;
    	BookingMasterMgtBC command = null;
    	List<MdmPckTpVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchPackageCode(event.getMdmPckTpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * BookingUtil의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * Commodity Code를 입력하기 위해 Code를 검색 </br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCmdtCdRepCmdtCd (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0653Event event = (EsmBkg0653Event)e;
    	BookingMasterMgtBC command = null;
    	List<SearchCmdtCdRepCmdtCdVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchCmdtCdRepCmdtCd(event.getSearchCmdtCdRepCmdtCdVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * EsmBkg0554Event event에 대한 특정 리스트 조회 이벤트 처리<br>
     * Warehouse (Bonded Area) Creation를 검색 </br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchWareHouse (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0554Event event = (EsmBkg0554Event)e;
    	BookingMasterMgtBC command = null;
    	String cuntryCd = null;
    	String wareHouse = null;
    	List<SearchWareHouseVO> list = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
	    	cuntryCd = JSPUtil.getNull(event.getSearchWareHouseVO().getCntCd());
	    	wareHouse = JSPUtil.getNull(event.getSearchWareHouseVO().getWhCd());
			list = command.searchWareHouse(cuntryCd,wareHouse);
			if (list.size() > 0){
        		eventResponse.setETCData(((SearchWareHouseVO)list.get(0)).getColumnValues());
        	}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    /**
     * SAVE 이벤트 처리<br>
     * EsmBkg0554Event event에 대한 SAVE 이벤트 처리<br>
     * Warehouse (Bonded Area) Creation
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageWareHouse(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0554Event event = (EsmBkg0554Event) e;
        BookingMasterMgtBC command = null;
        try {
            command = new BookingMasterMgtBCImpl();
            event.getSearchWareHouseVO().setCreUsrId(account.getUsr_id());
            event.getSearchWareHouseVO().setUpdUsrId(account.getUsr_id());
            begin();
            command.manageWareHouse(event.getSearchWareHouseVO());
            //eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * 특정 Location Code 를 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchLocation (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0554Event event = (EsmBkg0554Event)e;
    	BookingUtil command = null;
    	String locCd = null;
		SearchLocationCodeVO vo = null;
		try {
	    	command = new BookingUtil();
	    	locCd = JSPUtil.getNull(event.getSearchWareHouseVO().getLocCd());
			vo = command.searchLocationCode(locCd);
			if (vo != null){
				eventResponse.setETCData(vo.getColumnValues());
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0154화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg0154Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0154(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD00765");
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD00764");
            eventResponse.setRsVoList(list2);
        } catch(EventException ex) {
            rollback();
            throw ex;
	    } catch (Exception ex) {
            rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Manual로 BDR을 처리하는 화면을 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBDRTime (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0596Event event = (EsmBkg0596Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRTimeVO> list = null;
		String vvdBdrLog = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			list = command.searchBDRTime(event.getSearchBDRTimeVO());
			eventResponse.setRsVoList(list);
			if (0==list.size()) {
				event.getSearchBDRTimeVO().setBdrFlg("");
				list = command.searchBDRTime(event.getSearchBDRTimeVO());
			}
			vvdBdrLog = command.checkVvdBdrLog(event.getSearchBDRTimeVO().getVvdCd(),event.getSearchBDRTimeVO().getPolCd(),event.getSearchBDRTimeVO().getPodCd(),event.getSearchBDRTimeVO().getRdoTrunkFeeder());
			vvdBdrLog = vvdBdrLog.equals("Y")?"Yes":"No";
			if (0 < list.size()) {
				eventResponse.setETCData("vvd_bdr", vvdBdrLog);
	    		eventResponse.setETCData("total_booking_cnt", list.get(0).getTotBookingCnt());
	    		eventResponse.setETCData("btr_booking_cnt", list.get(0).getBtrBookingCnt());
			} else {
				eventResponse.setETCData("total_booking_cnt", "0");
	    		eventResponse.setETCData("btr_booking_cnt", "0");
	    		eventResponse.setETCData("vvd_bdr", vvdBdrLog);
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Manual로 BDR을 처리하는 화면을 조회한다. BDR_RSN까지 조회<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBDRTimeRHQ (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg059601Event event = (EsmBkg059601Event)e;
    	BookingMasterMgtBC command = null;
    	BookingUtil utilCmd = new BookingUtil();
		List<SearchBDRTimeVO> list = null;
		String vvdBdrLog = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			list = command.searchBDRTime(event.getSearchBDRTimeVO());
			eventResponse.setRsVoList(list);
			if (0==list.size()) {
				event.getSearchBDRTimeVO().setBdrFlg("");
				list = command.searchBDRTime(event.getSearchBDRTimeVO());
			}
			vvdBdrLog = command.checkVvdBdrLog(event.getSearchBDRTimeVO().getVvdCd(),event.getSearchBDRTimeVO().getPolCd(),event.getSearchBDRTimeVO().getPodCd(),event.getSearchBDRTimeVO().getRdoTrunkFeeder());
			vvdBdrLog = vvdBdrLog.equals("Y")?"Yes":"No";
			if (0 < list.size()) {
				eventResponse.setETCData("vvd_bdr", vvdBdrLog);
	    		eventResponse.setETCData("total_booking_cnt", list.get(0).getTotBookingCnt());
	    		eventResponse.setETCData("btr_booking_cnt", list.get(0).getBtrBookingCnt());
			} else {
				eventResponse.setETCData("total_booking_cnt", "0");
	    		eventResponse.setETCData("btr_booking_cnt", "0");
	    		eventResponse.setETCData("vvd_bdr", vvdBdrLog);
			}
			
			List<BkgComboVO> rsn_cd = utilCmd.searchCombo("CD03530");
			eventResponse.setRsVoList(rsn_cd);
			
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
	 *  BKG_ESM_0596 : Manual BDR을 처리<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBDRLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0596Event event = (EsmBkg0596Event)e;
		BookingMasterMgtBC mstBc = new BookingMasterMgtBCImpl();
		BLDocumentationBLBC blDocBc = new BLDocumentationBLBCImpl();
		//CargoReleaseOrderBC inboundBc = new  CargoReleaseOrderBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		String flag="";
		
		OblRdemVO[] oblRdems = null;
		HistoryTableVO historyTableVO = new HistoryTableVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		
		try {
			SearchBDRTimeVO vo = event.getSearchBDRTimeVO();
			SearchBDRTimeVO[] vos = event.getSearchBDRTimeVOS();
		 	
			if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				flag = "BKG_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
	    		flag = "VVD_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
	    		flag = "BKG_C_BDR";
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {	
	    		flag = "VVD_C_BDR";
	    	}
			begin();
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("BKG_C_BDR")){
				oblRdems = new OblRdemVO[vos.length];
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					if ( vos[i].getIbflag().equals("U")){
						// searchOldBkgForHistory 수행
						bkgBlNoVO.setBkgNo(vos[i].getBkgNo());
						historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0596", bkgBlNoVO);
						if (flag.equalsIgnoreCase("BKG_C_BDR")){
							vos[i].setIbflag("D");
						}
						blDocBc.modifyCntrCFM(vos[i].getBkgNo(),vos[i].getIbflag(),vos[i].getUpdUsrId());
						blDocBc.modifyBKGBDR(vos[i].getBkgNo(),vos[i].getIbflag(), "N", vos[i].getUpdUsrId());
						if (flag.equalsIgnoreCase("BKG_BDR")){ 
							oblRdems[i] = setupFocByObl(vos[i]);
						}
						
						historyBC.manageBookingHistory("ESM_BKG_0596", historyTableVO, account);
					}
				}
			}else if (flag.equalsIgnoreCase("VVD_BDR") || flag.equalsIgnoreCase("VVD_C_BDR")){
				
				if (vo.getVslCd().equals("")){
					vo.setVslCd(vo.getVvdCd().substring(0,4));
					vo.setSkdVoyNo(vo.getVvdCd().substring(4,8));
					vo.setSkdDirCd(vo.getVvdCd().substring(8,9));
					vo.setVpsPortCd(vo.getPolCd());
				}	
				boolean rtnChk = mstBc.checkBDRVVDPOL(vo);
				if (rtnChk == false){
					throw new EventException((String) new ErrorHandler("BKG00058", new String []{vo.getVvdCd()}).getMessage());
				}
				if (flag.equalsIgnoreCase("VVD_C_BDR")){
					vo.setIbflag("D");
					vo.setBdrFlg("Y");
					
				}else{
					vo.setIbflag("U");
					vo.setBdrFlg("N");
				}
				List<SearchBDRTimeVO> bdrVvdList = mstBc.searchBDRTime(vo);
				
				//BKG_VVD_BDR_LOG -TRNK_AUTO_BDR_FLG,TRNK_MNL_BDR_FLG,FDR_AUTO_BDR_FLG,FDR_MNL_BDR_FLG,FDR_BDR_FLG,TRNK_BDR_FLG,TRNK_MNL_BDR_DT
				mstBc.modifyBDRLog(vo);	
				oblRdems = new OblRdemVO[bdrVvdList.size()];
				
				if (null!=bdrVvdList && 0<bdrVvdList.size()) {
					for (int i = 0; i < bdrVvdList.size(); i++) {
						// searchOldBkgForHistory 수행
						bkgBlNoVO.setBkgNo(bdrVvdList.get(i).getBkgNo());
						historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0596", bkgBlNoVO);
						if (flag.equalsIgnoreCase("VVD_C_BDR")){
							bdrVvdList.get(i).setIbflag("D");
						}
						bdrVvdList.get(i).setCreUsrId(account.getUsr_id());
						bdrVvdList.get(i).setUpdUsrId(account.getUsr_id());
						//BKG_BL_DOC -BDR_FLG
						blDocBc.modifyBKGBDR(bdrVvdList.get(i).getBkgNo(),bdrVvdList.get(i).getIbflag(), "N", bdrVvdList.get(i).getUpdUsrId());
						//BKG_CONTAINER -CNTR_CFM_FLG
						blDocBc.modifyCntrCFM(bdrVvdList.get(i).getBkgNo(),bdrVvdList.get(i).getIbflag(),bdrVvdList.get(i).getUpdUsrId());	 
						
						if (flag.equalsIgnoreCase("VVD_BDR")){
							oblRdems[i] = setupFocByObl(bdrVvdList.get(i));
						}
						
						historyBC.manageBookingHistory("ESM_BKG_0596", historyTableVO, account);
					}
				}	
			}
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			
			/*
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("VVD_BDR")){
				inboundBc.setupFocByOblAutoBdr(oblRdems);
			}*/
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 *  BKG_ESM_0596_01 : Manual BDR을 처리 (RHQ)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBDRLogRHQ(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg059601Event event = (EsmBkg059601Event)e;
//		BookingMasterMgtBC mstBc = new BookingMasterMgtBCImpl();
		BLDocumentationBLBC blDocBc = new BLDocumentationBLBCImpl();
		//CargoReleaseOrderBC inboundBc = new  CargoReleaseOrderBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		String flag="";
		
		OblRdemVO[] oblRdems = null;
		HistoryTableVO historyTableVO = new HistoryTableVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		
		try {
			SearchBDRTimeVO vo = event.getSearchBDRTimeVO();
			SearchBDRTimeVO[] vos = event.getSearchBDRTimeVOS();
		 	
			if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				flag = "BKG_BDR";
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
	    		flag = "BKG_C_BDR";
	    	} 
			begin();
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("BKG_C_BDR")){
				oblRdems = new OblRdemVO[vos.length];
				for ( int i=0; i<vos.length; i++ ) {
					vos[i].setCreUsrId(account.getUsr_id());
					vos[i].setUpdUsrId(account.getUsr_id());
					if ( vos[i].getIbflag().equals("U")){
						// searchOldBkgForHistory 수행
						bkgBlNoVO.setBkgNo(vos[i].getBkgNo());
						historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0596", bkgBlNoVO);
						if (flag.equalsIgnoreCase("BKG_C_BDR")){
							vos[i].setIbflag("D");
						}
						blDocBc.modifyCntrCFM(vos[i].getBkgNo(),vos[i].getIbflag(),vos[i].getUpdUsrId());
						
						if("BKG_BDR".equalsIgnoreCase(flag)){
							blDocBc.modifyBKGBDR(vos[i].getBkgNo(),vos[i].getIbflag(), "N", vos[i].getUpdUsrId());
						}else{
							blDocBc.modifyBKGBDRRHQ(vos[i].getBkgNo(),vos[i].getIbflag(), "N", vos[i].getUpdUsrId(),vos[i].getBdrRsnCd(),vos[i].getBdrRsnRmk());
						}
						
						if (flag.equalsIgnoreCase("BKG_BDR")){ 
							oblRdems[i] = setupFocByObl(vos[i]);
						}
						
						historyBC.manageBookingHistory("ESM_BKG_0596", historyTableVO, account);
					}
				}
			}
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			
			/*
			if (flag.equalsIgnoreCase("BKG_BDR") || flag.equalsIgnoreCase("VVD_BDR")){
				inboundBc.setupFocByOblAutoBdr(oblRdems);
			}*/
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 *
	 * IB로 BDR건 전송처리.<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @exception EventException
	 */	
	private OblRdemVO setupFocByObl(SearchBDRTimeVO vo) throws EventException {
		OblRdemVO oblRdem = null;
		try {
			oblRdem = new OblRdemVO();
			oblRdem.setBlNo(vo.getBlNo());
			oblRdem.setCgorTeamCd("B");
			oblRdem.setCgoEvntNm("B/L BDR");
			oblRdem.setEvntDt(JSPUtil.getKST("yyyyMMddHHmmss")); //YYYYMMDDHH24MISS
			oblRdem.setEvntOfcCd("SYS");
			oblRdem.setEvntUsrId("BDRBookingSetting");
			oblRdem.setOblChk("N");
			oblRdem.setOblRdemFlg(vo.getOblIssFlag());
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return oblRdem;
	}

    /**
     * 조회 이벤트 처리<br>
     * UserSetupMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRmkTemplate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BkgUsrTmpltVO vo = null;
        UserSetupMgtBC command = null;
        List<BkgUsrTmpltVO> list = null;
        try {
	        vo = new BkgUsrTmpltVO();
	        vo.setUsrId(account.getUsr_id());
	        log.debug(">>> USER_ID : " + vo.getUsrId());
	        command = new UserSetupMgtBCImpl();
	        list = command.searchRmkTemplate(vo);
	        eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * 0232 화면의 조회조건 Set을 조회한다<br> 
     * UserSetupMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchUserXterSearchSet(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        UserSetupMgtBC command = new UserSetupMgtBCImpl();
	        BookingUtil comboUtil = new BookingUtil();
	        
	        EBookingReceiptBC comboMdmUtil = new EBookingReceiptBCImpl();
	
			// Doc Type - doc_tp_inq_cd - CD02348
	        List<BkgComboVO> doc_tp_cd = comboUtil.searchCombo("CD02822");
			eventResponse.setRsVoList(doc_tp_cd);
	
			// Upload Status - bkg_upld_sts_cd - CD01630
			List<BkgComboVO> bkg_upld_sts_cd  = comboUtil.searchCombo("CD01630");
			eventResponse.setRsVoList(bkg_upld_sts_cd);
	
			// Via - xter_rqst_via_cd - CD01622
			List<BkgComboVO> xter_rqst_via_cd  = comboUtil.searchCombo("CD01622");
			eventResponse.setRsVoList(xter_rqst_via_cd);
	
			// DOCType - bkg_cust_tp_cd - CD02140
			List<BkgComboVO> bkg_cust_tp_cd  = comboUtil.searchCombo("CD02140");
			eventResponse.setRsVoList(bkg_cust_tp_cd);
	
			// Delivery - conti_cd - CD00191
			List<BkgComboVO> conti_cd  = comboMdmUtil.searchComboMdmConti();
			eventResponse.setRsVoList(conti_cd);
	
			eventResponse.setRsVoList(command.searchUserXterSearchSet(account.getUsr_id()));
        } catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

    /**
     * 멀티 이벤트 처리<br>
     * 0232화면의 조회조건 Set을 멀티로 저장한다<br>
     * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageUserXterSearchSet(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0232Event event = (EsmBkg0232Event) e;
        try {
            begin();
            command.manageUserXterSearchSet(event.getBkgXterSrchSetVOS(), account);
            commit();
        } catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    /*
   
	 * User name, office 조회
	 * @param e
	 * @return
	 * @throws EventException
	
    private EventResponse searchUiSetUpInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ManifestListDownloadBCImpl command = null;
		
		// 이벤트별 Impl생성
		if (e.getEventName().equalsIgnoreCase("EsmBkg1008Event")) {
			EsmBkg1008Event event = (EsmBkg1008Event)e;
			command = new UsaManifestListDownloadBCImpl();
			
			UserAuthListCondVO cond = (UserAuthListCondVO)event.getAuthSetupListCondVO();
			String userId = cond.getChUsrId();
			List<UserInfoVO> list2 = command.searchUserAuthority(userId );
			int listSize = list2.size();
			if(listSize > 0){
				UserInfoVO vo = (UserInfoVO)list2.get(0);
				eventResponse.setETCData("search_usr_nm", vo.getUsrNm());
				eventResponse.setETCData("search_ofc_cd", vo.getOfcCd());
			}
		}
		return eventResponse;
    }  */  
    /**
	 * 조회 이벤트 처리<br>
	 * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
	 * 0154화면에 대한 콤보리스트 조회.<br>
	 * @param e EsmBkg0154Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserInternetAuth(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0320Event event = (EsmBkg0320Event)e;
		UserSetupMgtBC command = null;
		List<BkgInternetAuthorityVO> list = null;
		try {
			command = new UserSetupMgtBCImpl();
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				event.getInfoVO().setIbflag("R"); 
				list = command.searchUserInternetAuth(event.getInfoVO());
				eventResponse.setRsVoList(list);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		event.getInfoVO().setIbflag("R2");
	    		list = command.searchUserInternetAuth(event.getInfoVO());
	    		if(list.size() > 0){
	    			BkgInternetAuthorityVO vo =  list.get(0);
	        		eventResponse.setETCData("search_usr_nm", vo.getUsrNm());
	        		eventResponse.setETCData("search_ofc_cd", vo.getOfcCd());
	        	}else{
	        		eventResponse.setETCData("check_usr_id", "N");
	        	}
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * BkgInternetAuthorityVO event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserInternetAuth(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0320Event event = (EsmBkg0320Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		try {
			begin();
			command.manageUserInternetAuth(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
  
    /**
     * BKG_ESM_0592 : SEARCH<br>
     * MDPCS - S/R 업무처리 담당자 Group 정보를 관리화면을 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDPSCUserGroup (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0592Event event = (EsmBkg0592Event)e;
    	BookingMasterMgtBC command = null;
    	String usrId = null;
    	String dpcsWrkGrpCd = null;
		List<BkgDpcsUsrGrpVO> list = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
	    	usrId = event.getUsrId();
	    	dpcsWrkGrpCd = event.getDpcsWrkGrpCd();
			list = command.searchDPCSUserGroup(usrId,dpcsWrkGrpCd,event.getBkgDpcsUsrGrpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
	 * BKG_ESM_0592 : SAVE<br>
	 * DPCS - S/R 업무처리 담당자 Group 정보를 관리한다.<br>
	 * DPSC의 해당 User그룹을 담당자별 작업내역을 할단하주고 그것을 그룹핑해 놓은  Table임<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDPSCUserGroup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0592Event event = (EsmBkg0592Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgDpcsUsrGrpVO[] bkgDpcsUsrGrpVOs = event.getBkgDpcsUsrGrpVOS();
			for ( int i=0; i<bkgDpcsUsrGrpVOs.length; i++ ) {
				if ( bkgDpcsUsrGrpVOs[i].getIbflag().equals("I") ||  bkgDpcsUsrGrpVOs[i].getIbflag().equals("U")){
					
					if (command2.searchUserName(bkgDpcsUsrGrpVOs[i].getUsrId()).equals("")){
						
						eventResponse.setUserMessage((String) new ErrorHandler("BKG00512",new String[]{}).getUserMessage());
						return eventResponse;
					}
				}
			}
			
			begin();
			command.manageDPSCUserGroup(bkgDpcsUsrGrpVOs, account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0592화면에 대한 콤보리스트 조회.<br>
     * 
     * @param e EsmBkg0154Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0592(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
        List<BkgComboVO> list3 = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD01602");
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD01603");
            eventResponse.setRsVoList(list2);
            list3 = command.searchCombo("CD02569");
            eventResponse.setRsVoList(list3);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BDR TIME TABLE 화면 LANE항목 Sheet을 조회한다.<br>
     * @param e Event EsmBkg0073Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBDRPol (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0073Event event = (EsmBkg0073Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRPolVO> list = null;
		List<SearchBDRTimeTableVO> list2 = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			if (event.getSearchBDRPolVO().getOptSelBdr().equals("Lane")){
				list = command.searchBDRPol(event.getSearchBDRPolVO());
				eventResponse.setRsVoList(list);
			} else {
				list2 = command.searchBDRTimeTable(event.getSearchBDRTimeTableVO());
				eventResponse.setRsVoList(list2);
			}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BDR TIME TABLE 화면 항목2 BDR TIME TABLE Sheet을 조회한다.<br>
     * @param e Event EsmBkg0073Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBDRTimeTable (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0073Event event = (EsmBkg0073Event)e;
    	BookingMasterMgtBC command = null;
		List<SearchBDRTimeTableVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchBDRTimeTable(event.getSearchBDRTimeTableVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0073화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg0073Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0073(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
    	List<MdmVslSvcLaneVO> list = null;
        List<BkgComboVO> list2 = null;
        try {
            command = new BookingUtil();
        	list = command.searchSvcLaneCd();
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD00714");
            eventResponse.setRsVoList(list2);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0073화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg0073Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0073_port(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0073Event event = (EsmBkg0073Event)e;
        BookingUtil command = null;
        String vsl_slan_cd = "";
        String skd_dir_cd  = "";
        String port_cd  = "";
    	List<SearchSvcLaneBoundVO> list = null;
    	List<SearchSvcLaneBoundVO> list2 = null;
        try {
            command = new BookingUtil();
        	vsl_slan_cd = event.getSearchBDRPolVO().getCbSlanCd();
        	skd_dir_cd = event.getSearchBDRPolVO().getCbSkdDirCd();
        	port_cd = event.getSearchBDRPolVO().getCbPolCd();
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
        		port_cd = "";
        	}
        	list = command.searchPortCdListByLane(vsl_slan_cd,skd_dir_cd,port_cd);
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	        	if (null!=list && 0<list.size()) {
	        		list2 = new ArrayList<SearchSvcLaneBoundVO>();
					for (SearchSvcLaneBoundVO vo : list) {
						if (!vo.getPortCd().equals(port_cd)) {
							list2.add(vo);
						}
					}
	        	}	
	        	eventResponse.setRsVoList(list2);
        	} else {
        		eventResponse.setRsVoList(list);
        	}	
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0073화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg0073Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0073_vvd_port(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0073Event event = (EsmBkg0073Event)e;
        BookingUtil command = null;
        String vvd_cd  = "";
    	List<SearchPortCdByVvdVO> list = null;
        try {
            command = new BookingUtil();
        	vvd_cd = event.getSearchBDRTimeTableVO().getVvd();
        	list = command.searchPortCdListByVvd(vvd_cd);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
     * 0596화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg0596Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0596_vvd_port(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0596Event event = (EsmBkg0596Event)e;
        BookingUtil command = null;
        String vvd_cd  = "";
    	List<SearchPortCdByVvdVO> list = null;
        try {
            command = new BookingUtil();
        	vvd_cd = event.getSearchBDRTimeVO().getVvdCd();
        	list = command.searchPortCdListByVvd(vvd_cd);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * BDR TIME TABLE 관리한다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVVDBDRTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0073Event event = (EsmBkg0073Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			SearchBDRPolVO[] searchBDRPolVOs = event.getSearchBDRPolVOS();
			SearchBDRTimeTableVO[] searchBDRTimeTableVOs = event.getSearchBDRTimeTableVOS();
			
			if (searchBDRPolVOs !=null && searchBDRPolVOs.length > 0){
				for ( int i=0; i<searchBDRPolVOs.length; i++ ) {
					if ( searchBDRPolVOs[i].getIbflag().equals("I") ||  searchBDRPolVOs[i].getIbflag().equals("U")){
						if (command2.validateLoc(searchBDRPolVOs[i].getPodCd())==false){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00165",new String[]{}).getUserMessage());
							return eventResponse;
						}
					}
				}
			}
			
			begin();
			command.manageVVDBDRTime(searchBDRPolVOs,searchBDRTimeTableVOs, account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			  
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
	 * ESM_BKG_0073 : BDR LOG생성<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBKGBDRLOG(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0073Event event = (EsmBkg0073Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
		try {
			BkgVvdBdrLogVO bkgVvdBdrLogVO = new BkgVvdBdrLogVO() ;
			
			String vvdCd = event.getSearchBDRTimeTableVO().getVvd();
			bkgVvdBdrLogVO.setVslCd(vvdCd.substring(0,4));
			bkgVvdBdrLogVO.setSkdVoyNo(vvdCd.substring(4,8));
			bkgVvdBdrLogVO.setSkdDirCd(vvdCd.substring(8,9));
			begin();
			bkgVvdBdrLogVO = command.manageBKGBDRLOG(bkgVvdBdrLogVO, account);
			 
			if (bkgVvdBdrLogVO.getOResult().equals("F")){
				rollback();
				throw new EventException (new ErrorHandler(bkgVvdBdrLogVO.getOErrMsg()).getMessage());
			} 
			eventResponse.setUserMessage(bkgVvdBdrLogVO.getOErrMsg());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
     * 조회 이벤트 처리<br>
     * BEqualization Port 등록 화면 조회한다.<br>
     * @param e Event EsmBkg0253Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEqualizetionPortCD (Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0253Event event = (EsmBkg0253Event)e;
    	BookingMasterMgtBC command = null;
		List<BkgEqlzPortVO> list = null;
		try {
	    	command = new BookingMasterMgtBCImpl();
			list = command.searchEqualizetionPortCD(event.getBkgEqlzPortVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
    /**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * BEqualization Port 등록 관리한다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEqualizationPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0253Event event = (EsmBkg0253Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgEqlzPortVO[] bkgEqlzPortVOs= event.getBkgEqlzPortVOS();
			
			if (bkgEqlzPortVOs !=null && bkgEqlzPortVOs.length > 0){
				for ( int i=0; i<bkgEqlzPortVOs.length; i++ ) {
					if ( bkgEqlzPortVOs[i].getIbflag().equals("I") ||  bkgEqlzPortVOs[i].getIbflag().equals("U")){
						if (command2.validateLoc(bkgEqlzPortVOs[i].getLocCd()) ==false){
							throw new EventException((String) new ErrorHandler("BKG00138", new String []{}).getMessage());
						}
						if (command2.validateLoc(bkgEqlzPortVOs[i].getEqlzPortCd())==false){
							throw new EventException((String) new ErrorHandler("BKG00138", new String []{}).getMessage());
						}
					}
					if ( bkgEqlzPortVOs[i].getIbflag().equals("I")){
						List<BkgEqlzPortVO> list = command.searchEqualizetionPortCD(bkgEqlzPortVOs[i]);
						if (list != null && list.size() > 0){
							throw new EventException((String) new ErrorHandler("BKG06018", new String []{}).getMessage());
						}
					}
				}
			}
			begin();
			command.manageEqualizationPort(bkgEqlzPortVOs, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}

    /**
	 * 조회 이벤트 처리<br>
	 * BookingMasterMgt의 event에 대한 콤보 이벤트 처리<br>
	 * 0192화면 Customer Information in CRM 정보조회.<br>
	 * @param e EsmBkg0192Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInBoundCustList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = null;
		List<SearchInBoundCustListVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchInBoundCustList(event.getInfoVO());
			if (null!=list && 0 < list.size()) {
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0192화면 Customer Information Template 정보조회.<br>
	 * @param e EsmBkg0192Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInBoundCustTmpltList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = null;
		List<BkgCustTmpltVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchInBoundCustTmpltList(event.getInfoVO2());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 0192화면 Customer Information Template <br>
	 * BkgCustTmpltVO event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e EsmBkg0192Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInBoundCustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0192Event event = (EsmBkg0192Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try{
			begin();
			
			command.manageInBoundCustList(event.getInfoVO2s(),account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
     * ESM_BKG_0153 : 조회 이벤트 처리<br>
     * AGENT한테 COMMISION을 준다. <br>
     * 북중국은 Outbound의 경우 Booking접수부터 Outbound Documentation, paymanet업무를 <br>
     * Inbound의 경우에는 수입통관신고 및 Inbound Documentation,Payment업무를 대행 해주는 Agent업체가 있고,
     * 해당 Agent업체에 대해서 일정 Commission를 지불하는 형태로 Booking업무가 진행된다.<br>
     * 
     * @param e Event EsmBkg0153Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchChinaAgentCodeList (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0153Event event = (EsmBkg0153Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgChinaAgentVO> list = command.searchChinaAgentCodeList(event.getSearchChinaAgentCodeVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * 중국 Booking Agent 정보 등록 화면 관리한다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChinaAgentCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0153Event event = (EsmBkg0153Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try {
			BkgChinaAgentVO[] bkgChinaAgentVOs= event.getSearchChinaAgentCodeVOS();
			
			if (bkgChinaAgentVOs !=null && bkgChinaAgentVOs.length > 0){
				for ( int i=0; i<bkgChinaAgentVOs.length; i++ ) {
					if ( bkgChinaAgentVOs[i].getIbflag().equals("I") ||  bkgChinaAgentVOs[i].getIbflag().equals("U")){
						
						
						/*customer check*/
						if (bkgChinaAgentVOs[i].getCustCntCd().equals("") || bkgChinaAgentVOs[i].getCustSeq().equals("")){
							//The Customer code($s,$s) is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{bkgChinaAgentVOs[i].getCustCntCd(),bkgChinaAgentVOs[i].getCustSeq()}).getUserMessage());
							return eventResponse;
						}
						
						MdmCustVO mdmCustVO = command2.searchMdmCust(bkgChinaAgentVOs[i].getCustCntCd(), bkgChinaAgentVOs[i].getCustSeq(),"Y");
						if (mdmCustVO.getName().equals("")){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{bkgChinaAgentVOs[i].getCustCntCd(),bkgChinaAgentVOs[i].getCustSeq()}).getUserMessage());
							return eventResponse;
						}
						
						/*office code check*/
						if (bkgChinaAgentVOs[i].getFincOfcCd().equals("")){
							//The Control Office code($s)  is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00830",new String[]{bkgChinaAgentVOs[i].getFincOfcCd()}).getUserMessage());
							return eventResponse;
						}
						MdmOrganizationVO  mdmOrzVO = command2.searchMdmOrzByOfcCd(bkgChinaAgentVOs[i].getFincOfcCd());
						if (mdmOrzVO.getArOfcCd().equals("")){
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00830",new String[]{bkgChinaAgentVOs[i].getFincOfcCd()}).getUserMessage());
							return eventResponse;
						}
						
						/*vendor code check*/
						if (bkgChinaAgentVOs[i].getVndrCntCd().equals("") || bkgChinaAgentVOs[i].getVndrSeq().equals("")){
							//The Vendor code($s,$s)  is not registered
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00832",new String[]{bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq()}).getUserMessage());
							return eventResponse;
						}
						if (command2.checkVenodrCode(bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq())==false){
							log.debug("==>"+(String) new ErrorHandler("BKG00832",new String[]{}).getUserMessage());
							
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00832",new String[]{bkgChinaAgentVOs[i].getVndrCntCd(),bkgChinaAgentVOs[i].getVndrSeq()}).getUserMessage());
							return eventResponse;
						}
						
					}
				}
			}
			begin();
			command.manageChinaAgentCode(bkgChinaAgentVOs, account);
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	/**
     * ESM_BKG_0153 : 조회 이벤트 처리<br>
     * 0153화면 그리드 코드 있력시 Finance Office,Customer code  조회.
     * @param e EsmBkg0153Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCheckCode0153(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmBkg0153Event event = (EsmBkg0153Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        try {
        	
        	if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		MdmOrganizationVO  mdmOrzVO = command.searchMdmOrzByOfcCd(event.getSearchChinaAgentCodeVO().getOfcCd());
    			if (mdmOrzVO == null || mdmOrzVO.getArOfcCd().equals("")){
    				throw new EventException((String)new ErrorHandler("BKG00830",new String[]{event.getSearchChinaAgentCodeVO().getOfcCd()}).getUserMessage());
    			}
    			eventResponse.setETCData(mdmOrzVO.getColumnValues());
           	} 
        	if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
           		MdmCustVO mdmCustVO  = command.searchMdmCust(event.getSearchChinaAgentCodeVO().getCustCntCd(),event.getSearchChinaAgentCodeVO().getCustSeq(),"Y");
           		if (mdmCustVO == null || mdmCustVO.getName().equals("")){
					eventResponse.setUserMessage((String) new ErrorHandler("BKG00831",new String[]{event.getSearchChinaAgentCodeVO().getCustCntCd(),event.getSearchChinaAgentCodeVO().getCustSeq()}).getUserMessage());
					return eventResponse;
				}
           		eventResponse.setETCData(mdmCustVO.getColumnValues());
            }
        } catch(EventException ex) {
        	throw ex;
			//throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }

    /**
	 * 0354: EsmBkg0354Event<br>
	 * Location of Goods을 조회합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanadaGroupLocationCD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		List<BkgcustomscanadagrouplocationVO> list = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			list = command.searchCanadaGroupLocationCD(event.getInfoVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * 0354: EsmBkg0354Event<br>
	 * Canada ACI: Location of Goods Setup - Loc Code 생성/수정을 위한 기존 데이타를 조회합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanadaGroupLocationCD2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		List<BkgcustomscanadagrouplocationVO> list = null;
		StringBuilder sbReturnVal = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			list = command.searchCanadaGroupLocationCD2(event.getInfoVO());
			sbReturnVal = new StringBuilder();  //중복데이타가 존재하면 POD,DEL코드를 알려준다.
			if (null!=list && 0<list.size()) {
				for (BkgcustomscanadagrouplocationVO vo : list) {
					sbReturnVal.append(vo.getPodCd()).append("\n");
				}
	    		eventResponse.setETCData("EXIST_MSG",sbReturnVal.toString());
	    	} else {
	    		eventResponse.setETCData("EXIST_MSG","");
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchYardDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		String ydNm = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			ydNm = command.searchYardDesc(event.getInfoVO());
			if( ydNm != null ){
	    		eventResponse.setETCData("YD_DESC",ydNm);
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchLocDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = null;
		String locNm = null;
		try {
			command = new CustomsMasterMgtBCImpl();
			locNm = command.searchLocDesc(event.getInfoVO());
			if( locNm != null ){
	    		eventResponse.setETCData("LOC_DESC",locNm);
	    	}
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	

    /**
     * 조회 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * @param e Event EsmBkg0741Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchOfficePfmc (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0741Event event = (EsmBkg0741Event)e;
    	
    	String option = event.getBkgDocPerfOfcVO().getChkOp();
    	
    	String temp[] = option.split(":");
    	
    	BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgDocPerfOfcVO> list = command.searchOfficePfmc(event.getBkgDocPerfOfcVO());
			
			//Doc Performance    
			if (temp[0].equals("A")){
				
				eventResponse.setRsVoList(list);
			}else{//e-Service Handling Office
				
				String ctrnOfcCd = null;
	    		
	    		String[] tempCtrl = null;
	    		
	    		int maxCtrl = 0;
	        	
	    		BkgDocPerfOfcVO vo = new BkgDocPerfOfcVO();
	    		
	        	for(int i = 0 ; i < list.size() ; i++){
	        		
	        		vo = list.get(i);
	        		
	        		ctrnOfcCd = vo.getCtrlOfcCd();
	        		
	        		if (ctrnOfcCd != null){        		
		        		
	        			tempCtrl = ctrnOfcCd.split(",");
	        			
	        			if (tempCtrl.length > maxCtrl){
	        				
	        				maxCtrl = tempCtrl.length;
	        			}	        			
	        		}
	        		
	        	}	
	        	
	        	eventResponse.setETCData("maxCtrl", Integer.toString(maxCtrl));
				eventResponse.setRsVoList(list);
			}
							
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    

    /**
     * 입력수정삭제 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 입력,수정 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse manageOfficePfmc(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0741Event event = (EsmBkg0741Event) e;
    	BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
        try {
            begin();
            command.manageOfficePfmc(event.getBkgEsvcHndlOfcVOS(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }

    /**
     * 0741: EsmBkg0741Event<br>
     * 등록된 Office code 인지 여부를 체크합니다.<br>
     * Controlled Office 에 등록된 Office 가 H/OFC에 등록 되지 않도록 Office code 를 체크합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse checkOfficePfmc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0741Event event = (EsmBkg0741Event) e;
        BookingProcessMgtBC command = null;
        List<BkgDocPerfOfcVO> list = null;
        String check   = null;
        String chkHOFC = null;
        String[] temp  = null;
        try {
        	command = new BookingProcessMgtBCImpl();
	        list = command.checkOfficePfmc(event.getBkgDocPerfOfcVO());
	        temp  = event.getBkgDocPerfOfcVO().getChkOp().split(":");
        	check = 0 < list.size() ? "Y" : "N";
	        log.debug("ofc_ty >>> " + event.getBkgDocPerfOfcVO().getOfcTy());
	        log.debug("chk_op >>> " + temp[0]);
	        
	        
	        event.getBkgDocPerfOfcVO().setChkOp(temp[0]);
	        //e-Service Handling Office 에서 
	        //Controlled Office 에 등록된 Office 가  H/OFC 에 등록되지 않도록 체크함
//	        if ("B".equals(temp[0]) && "3".equals(event.getBkgDocPerfOfcVO().getOfcTy())) {
	        if ("3".equals(event.getBkgDocPerfOfcVO().getOfcTy())) {
	        	list = command.checkCtrlOffice(event.getBkgDocPerfOfcVO());
        		chkHOFC = 0 < list.size() ? "N" : "Y";
	        }
	        eventResponse.setETCData("check",check);
	        eventResponse.setETCData("chkOFC",chkHOFC);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * 0354: EsmBkg0354Event<br>
	 * Location of Goods을 트랜잭션 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCanadaGroupLocationCD(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0354Event event = (EsmBkg0354Event)e;
		CustomsMasterMgtBC command = new CustomsMasterMgtBCImpl();
		try{
			begin();
			BkgcustomscanadagrouplocationVO[] vos= event.getInfoVOs();
			StringBuilder sbReturnVal = new StringBuilder();  //중복데이타가 존재하면 POD,DEL코드를 알려준다.
			
			if (vos !=null && vos.length > 0){
				for ( int idx=0; idx<vos.length; idx++ ) {
					if ( vos[idx].getIbflag().equals("I") || vos[idx].getIbflag().equals("U") ){
						BkgcustomscanadagrouplocationVO svo = new BkgcustomscanadagrouplocationVO();
						svo.setPodCd(vos[idx].getPodCd());
						svo.setDelCd(vos[idx].getDelCd());
						svo.setPodYdNo(vos[idx].getPodYdNo());
						svo.setGdsLocSeq(vos[idx].getGdsLocSeq());
						
						List<BkgcustomscanadagrouplocationVO> list = command.searchCanadaGroupLocationCD2(svo);
						if (null!=list && 0<list.size()){
							sbReturnVal.append("[");
							for (BkgcustomscanadagrouplocationVO vo : list) {
								sbReturnVal.append(vo.getPodCd()).append("");
							}
							sbReturnVal.append("]");
							eventResponse.setUserMessage((String) new ErrorHandler("BKG00764",new String[]{sbReturnVal.toString()}).getUserMessage());
							return eventResponse;
						}
					}
				}
			}
			
			command.manageCanadaGroupLocationCD(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	

	  /**
	 * 0374: EsmBkg0374Event<br>
	 * Arrival Notice의 Office Default  US Destination Office Setup 을 조회합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchANDestOfcList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = null;
		List<BkganDestOfcStupVO> list = null;
		try {
			command = new BookingProcessMgtBCImpl();
			list = command.searchANDestOfcList(event.getInfoVO().getPEqCtrlOfcCd(),event.getInfoVO().getPHndlOfcCd());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 0374  저장을 위한 조회. EQ OFC가 HQ OFC에 이미 등록되어 있으면 저장을 하지 못한다.<br>
	 * 단. EQ OFC와 HQ OFC가 같은 경우는 예외이다<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchANDestOfcList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = null;
		List<BkganDestOfcStupVO> list = null;
		try {
			command = new BookingProcessMgtBCImpl();
			list = command.searchANDestOfcList2(event.getInfoVO().getPEqCtrlOfcCd(),event.getInfoVO().getPHndlOfcCd());
			if (0 < list.size()) {
				eventResponse.setETCData("HQ_OFC_SELECT_FLAG", "Y");
				eventResponse.setETCData("EQ_OFC_CD", list.get(0).getEqCtrlOfcCd());
				eventResponse.setETCData("HQ_OFC_CD", list.get(0).getHndlOfcCd());
			} else {
				eventResponse.setETCData("HQ_OFC_SELECT_FLAG", "N");
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 0374: EsmBkg0073Event<br>
	 * Arrival Notice의 Office Default  US Destination Office Setup 을 트랜잭션 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageANDestOfcList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0374Event event = (EsmBkg0374Event)e;
		BookingProcessMgtBC command = new BookingProcessMgtBCImpl();
		try{
			begin();
			command.manageANDestOfcList(event.getInfoVOs(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Cms0070001Event<br>
	 * Customer Sales Rep 연동을 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageBkgCustSlsRep(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Cms0070001Event event = (Cms0070001Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		try{
			begin();
			command.manageBkgCustSlsRep(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	 /**
	 * 0949: EsmBkg0949Event<br>
	 * SERVICE LANE CODE SEARCH.
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceLane() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
		BookingMasterMgtBC command2 = null;
		List<MdmVslSvcLaneVO> list = null;
		List<MdmCountryVO> list2 = null;
		List<ContinentCodeVO> listConti = null;
		StringBuffer slanCd = null;
		StringBuffer slanVa = null;
		StringBuffer cntCd = null;
		StringBuffer cntNm = null;
		StringBuffer contiCd = null;
		StringBuffer contiNm = null;
		try {
			command = new BookingUtil();
			command2 = new BookingMasterMgtBCImpl();
			
			list = command.searchSvcLaneCd();
			list2 = command2.searchCntCdNm();
			listConti = command.searchSvcContiCd();
			
			slanCd = new StringBuffer();
			slanVa = new StringBuffer();
			cntCd = new StringBuffer();
			cntNm = new StringBuffer();
			contiCd = new StringBuffer();
			contiNm = new StringBuffer();
			
			slanCd.append("ALL");
			slanVa.append("*");
			cntCd.append("*");
			cntNm.append("ALL");
			contiCd.append("*");
			contiNm.append("ALL");
			
			if (0 < list.size()) {
	        	for (MdmVslSvcLaneVO mdmVslSvcLaneVO : list) {
	        		slanCd.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
	        		slanVa.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
	        	}
			}
			if (0 < list2.size()) {
				for (MdmCountryVO mdmCountryVO : list2) {
					cntCd.append("|" + mdmCountryVO.getCntCd());
					cntNm.append("|" + mdmCountryVO.getCntNm());
				}
			}
			if (0 < listConti.size()) {
				for (ContinentCodeVO continentCodeVO : listConti) {
					contiCd.append("|" + continentCodeVO.getContiCd());
					contiNm.append("|" + continentCodeVO.getContiNm());
				}
			}
			
	        eventResponse.setETCData("slanCd",slanCd.toString());
	        eventResponse.setETCData("slanVa",slanVa.toString());
	        eventResponse.setETCData("cntCd",cntCd.toString());
	        eventResponse.setETCData("cntNm",cntNm.toString());
	        eventResponse.setETCData("contiCd",contiCd.toString());
	        eventResponse.setETCData("contiNm",contiNm.toString());
	        
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_0949 : Retrieve<br>
	 * Documentation Cut-off Time 을 Retrieve 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocCutOffTimeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingMasterMgtBC command = null;
		String vslSlanCd = null;
		String ydCd = null;
		List<BkgdocClzSetListVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			vslSlanCd = event.getBkgdocClzSetListVO().getVslSlanCd();
			ydCd = event.getBkgdocClzSetListVO().getYdCd();
			list = command.searchDocCutOffTimeList(ydCd, vslSlanCd);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_0949 : SAVE<br>
	 * Documentation Cut-off Time 을 SAVE 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageDocCutOffTimeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingMasterMgtBC command = null;
		try{
			begin();
			command = new BookingMasterMgtBCImpl();
			command.manageDocCutOffTimeList(event.getBkgdocClzSetVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_0949 : ADD ROW(CHECK)<br>
	 * Documentation Cut-off Time 추가시 POL을 체크합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchLocationCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0949Event event = (EsmBkg0949Event)e;
		BookingUtil command = null;
		String pol = null;
		SearchLocationCodeVO vo = null;
		try {
			command = new BookingUtil();
			pol = event.getBkgdocClzSetListVO().getPol();
			vo = command.searchLocationCode(pol);
			if (null != vo && "Y".equals(vo.getCallPortFlg())) {
				eventResponse.setETCData("check","Y");
			} else {
				eventResponse.setETCData("check","N");
			}
			
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_0949 : Init<br>
	 * Day Type Code 정보를 조회합니다.
	 * @param 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchDayTypeCode() throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = null;
        List<BkgComboVO> list = null;

		try {
			command = new BookingUtil();
		
			list = command.searchCombo("CD02769");
	        eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_1030 : SAVE<br>
	 * Mandatory Item(s) Setup for Customized Service 을 SAVE 처리합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageMandatoryItemSetupList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		try{
			begin();
			command.manageMandatoryItemSetupList(event.getMandatoryItemSetupListVOS(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_1030 : Retrieve<br>
	 * Mandatory Item(s) Setup for Customized Service 을 Retrieve 처리합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	  
	private EventResponse searchMandatoryItemSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingMasterMgtBC command = null;
		List<BkgMdtItmVO> list = null;
		try {
			command = new BookingMasterMgtBCImpl();
			list = command.searchMandatoryItemSetupList(event.getBkgMdtItmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BKG_ESM_1030 : Customer Code check<br>
	 * Mandatory Item(s) Setup for Customized Service 에 등록될 Customer Code 를처리합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkCustCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1030Event event = (EsmBkg1030Event)e;
		BookingUtil command = null;
		String custCd = null;
		String custSeq = null;
		MdmCustVO vo = null;
		try {
			command = new BookingUtil();
			custCd = event.getCustCd();
			custSeq = event.getCustSeq();
			if (!"".equals(custCd) && !"".equals(custSeq)) {
				vo 	= command.searchMdmCust(custCd, custSeq, "N");
			}
			eventResponse.setETCData("check",null!=vo ? "N":"Y");
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  0743 B/L Print 옵션을 조회합니다.<br>	
	 * 
	 * @param e EsmBkg0743Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserPrintSetup(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0743Event event = (EsmBkg0743Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	BLIssuanceBC command2 = new BLIssuanceBCImpl();
    	
    	String strBkgNo = "";
    	String strCorrNo = "";
    	String strRate = "";
    	String strCntr = "";
    	String strHData = "";
    	String[] hbl = new String[2];
    	
        BookingUtil command3 = new BookingUtil();
    	
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup(event.getInfoVO(),account);
			if(list.size() > 0){
				eventResponse.setETCData("bl_face_prn_dvc_nm", list.get(0).getBlFacePrnDvcNm());
				eventResponse.setETCData("bl_ridr_prn_dvc_nm", list.get(0).getBlRidrPrnDvcNm());
				eventResponse.setETCData("bl_prn_dvc_nm", list.get(0).getBlPrnDvcNm());
				eventResponse.setETCData("obl_iss_knt", list.get(0).getOblIssKnt());
				eventResponse.setETCData("bl_prn_setup", list.get(0).getBlPrnSetup());
				eventResponse.setETCData("bl_tp_cd", list.get(0).getBlTpCd());
				eventResponse.setETCData("obl_iss_flg", list.get(0).getOblIssFlg());
				eventResponse.setETCData("obl_prn_flg", list.get(0).getOblPrnFlg());
				eventResponse.setETCData("bb_cgo_flg",  list.get(0).getBbCgoFlg());
				eventResponse.setETCData("bl_cpy_knt",  list.get(0).getBlCpyKnt());
				eventResponse.setETCData("conti_cd",  list.get(0).getContiCd());
				eventResponse.setETCData("org_ppd_rcv_cd",  list.get(0).getOrgPpdRcvCd());
				eventResponse.setETCData("org_n3pty_ppd_cd",  list.get(0).getOrgN3ptyPpdCd());
				eventResponse.setETCData("print_release_yn",  list.get(0).getPrintReleaseYn());
				eventResponse.setETCData("pod_cd",  list.get(0).getPodCd());
				eventResponse.setETCData("date_flg",  list.get(0).getDateFlg());
			}
			
			strBkgNo = event.getBkgNo();
			strCorrNo = event.getCorrNo() == null ? "" : event.getCorrNo();
			strHData = event.getHiddenData().equals("") || event.getHiddenData() == null ? "N" : event.getHiddenData();
			strRate = event.getChargeTp().equals("") || event.getChargeTp() == null ? "1" : event.getChargeTp();
			strCntr = event.getContainerTp().equals("") || event.getContainerTp() == null ? "1" : event.getContainerTp();
			
			hbl = command2.searchHouseBlYn(event.getBkgNo());
			eventResponse.setETCData("rider_only_yn", command2.searchRiderYn(strBkgNo, strHData, strRate, strCntr, strCorrNo));
			eventResponse.setETCData("nvocc_only_yn", hbl[0]);
			eventResponse.setETCData("hbl_tp", hbl[1]);
			eventResponse.setETCData("obl_rlse_flg", command2.searchOblRlseFlg(event.getBkgNo(), strCorrNo));
			
			//C/A NO
			List<BkgCorrectionVO> list2 = command.searchUserPrintSetup2(event.getBkgNo(),account);
			eventResponse.setRsVoList(list2);
			
			//B/L Type
	        List<BkgComboVO> list3 = command3.searchCombo("CD02381");
	        eventResponse.setRsVoList(list3);
	        //Charge Type
	        list3 = command3.searchCombo("CD02385");
	        eventResponse.setRsVoList(list3);
	        //Container Type
	        list3 = command3.searchCombo("CD02384");
	        eventResponse.setRsVoList(list3);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 *  0743_01 그룹 프린트를 위해 초기 조건들을 조회한다.<br>	
	 * 
	 * @param e EsmBkg0743Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserPrintSetup3(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0743Event event = (EsmBkg0743Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
        BookingUtil command3 = new BookingUtil();
    	
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup4(event.getInfoVO());
			if(list.size() > 0){
				eventResponse.setETCData("bl_prn_setup", list.get(0).getBlPrnSetup());
			}
			
			//B/L 프린트 옵션 조회
			List<BkgUsrDfltSetVO> list2 = command.searchUserPrintSetup3(event.getInfoVO(), event.getModule());
			if(list2.size() > 0){
				eventResponse.setETCData("conti_cd",  list2.get(0).getContiCd());
			}
			eventResponse.setRsVoList(list2);
			
			//B/L Type
	        List<BkgComboVO> list3 = command3.searchCombo("CD02381");
	        eventResponse.setRsVoList(list3);
	        //Charge Type
	        list3 = command3.searchCombo("CD02385");
	        eventResponse.setRsVoList(list3);
	        //Container Type
	        list3 = command3.searchCombo("CD02384");
	        eventResponse.setRsVoList(list3);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 *  0743 Rider,H/BL을 조회합니다.<br>	
	 * 
	 * @param e EsmBkg0743Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHouseBlRirderBl(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command2 = new BLIssuanceBCImpl();
		
		String strBkgNo = "";
		String strCorrNo = "";
		String strRate = "";
		String strCntr = "";
		String strHData = "";
		String[] hbl = new String[2];
		
		try {
			strBkgNo = event.getBkgNo();
			strCorrNo = event.getCorrNo() == null ? "" : event.getCorrNo();
			strHData = event.getHiddenData().equals("") || event.getHiddenData() == null ? "N" : event.getHiddenData();
			strRate = event.getChargeTp().equals("") || event.getChargeTp() == null ? "1" : event.getChargeTp();
			strCntr = event.getContainerTp().equals("") || event.getContainerTp() == null ? "1" : event.getContainerTp();
			hbl = command2.searchHouseBlYn(event.getBkgNo());
			
			eventResponse.setETCData("rider_only_yn", command2.searchRiderYn(strBkgNo, strHData, strRate, strCntr, strCorrNo));
			eventResponse.setETCData("nvocc_only_yn", hbl[0]);
			eventResponse.setETCData("hbl_flg", hbl[1]);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
	 * 조회 이벤트 처리<br>
	 * 0064 프린트 옵션을 조회합니다.
	 * 
	 * @param e EsmBkg0064Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserPrintSetup0064(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0064Event event = (EsmBkg0064Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		try {
			List<BkgUsrDfltSetVO> list = command.searchUserPrintSetup(event.getInfoVO(),account);
			if(list.size() > 0){
				eventResponse.setETCData("bl_face_prn_dvc_nm", list.get(0).getBlFacePrnDvcNm());
				eventResponse.setETCData("bl_ridr_prn_dvc_nm", list.get(0).getBlRidrPrnDvcNm());
				eventResponse.setETCData("bl_prn_dvc_nm", list.get(0).getBlPrnDvcNm());
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	    
	
	
	/**
	 * 0743,0064 B/L Print 옵션을 저장합니다.<br>	
	 * 
	 * @param e EsmBkg0743Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUserPrintSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		try{
			BkgUsrDfltSetVO bkgUsrDfltSetVO = event.getInfoVO();
			begin();
			command.manageUserPrintSetup(bkgUsrDfltSetVO,account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		
		} catch(EventException ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * BKG_BL_ISS테이블 OBL_RLSE_FLG 관련 정보를 관리한다<br>	
	 * 
	 * @param e EsmBkg0743Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOBLRlseFlg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0743Event event = (EsmBkg0743Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0743";
		if(event.getUid() !=null && !"".equals(event.getUid())){
			uiId = event.getUid();
		}
		
		try{
			
			BlIssInfoVO blIssInfoVO = event.getInfoVO2();
			begin();
						
			/* search old history */
			bkgBlNoVO.setBkgNo(blIssInfoVO.getBkgNo());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO.setOblIssFlg(blIssInfoVO.getOblIssFlg());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			command.modifyOBLRlseFlg(blIssInfoVO);
			
			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		} catch(EventException ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1060 : 조회 이벤트 처리<br>
	 *  Manual Booking Number Creation <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchChnMnlBkgNoGenList (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1060Event event = (EsmBkg1060Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
		
		try {
			List<BkgChnBkgNoGenVO> list = command.searchChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler(ex).getUserMessage(),ex);
		}
		
	}

    /**
	 * 조회 이벤트 처리<br>
	 *  0922 B/L Print 옵션을 조회합니다.<br>	
	 * 
	 * @param e EsmBkg0922Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeDetail(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0922Event event = (EsmBkg0922Event)e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
		try {
			List<MdmOrganizationVO> list = command.searchOfficeDetail(event.getOfcCd(),account);
			if(list.size() > 0){
				eventResponse.setETCData("eng_nm", list.get(0).getOfcEngNm());
				eventResponse.setETCData("address", list.get(0).getOfcAddr());
				eventResponse.setETCData("country", list.get(0).getLocCd());
				eventResponse.setETCData("phone_no", list.get(0).getOfcPhnNo());
				eventResponse.setETCData("fax_no", list.get(0).getOfcFaxNo());
			}else{
				eventResponse.setETCData("eng_nm", "");
				eventResponse.setETCData("address", "");
				eventResponse.setETCData("country", "");
				eventResponse.setETCData("phone_no", "");
				eventResponse.setETCData("fax_no", "");
			}
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	     

	/**
	 * Edi005_0001Event<br>
	 * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiTrdPrnrSubLnk(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0050001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0050001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiTrdPrnrSubLnk(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Edi006_0001Event<br>
	 * BKG_EDI_SUB_LNK_MSG 연동을 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiSubLnkMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0060001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0060001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiSubLnkMsg(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Edi007_0001Event<br>
	 * BKG_EDI_PRNR_PORT_LANE 연동을 처리합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveBkgEdiPrnrPortLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		Edi0070001Event event = null;
		BookingMasterMgtBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (Edi0070001Event)e;
			command = new BookingMasterMgtBCImpl();
			begin();
			command.receiveBkgEdiPrnrPortLane(event.getMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1060 Event<br>
	 * 북중국 BKG No 선 생성
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse createChnMnlBkgNoGenList(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg1060Event event = null;
		BookingMasterMgtBC command = null;
		ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg1060Event)e;
			chnMnlBkgNoGenCondVO = event.getChnMnlBkgNoGenCondVO();
			command = new BookingMasterMgtBCImpl();
			begin();
			List<BkgChnBkgNoGenVO> list = command.createChnMnlBkgNoGenList(chnMnlBkgNoGenCondVO, getSignOnUserAccount());
			eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * 조회 이벤트 처리<br>
     *  0922 B/L Print 옵션을 조회합니다.<br>   
     * 
     * @param e EsmBkg1075Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCombo(Event e) throws EventException {
        //
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        UserSetupMgtBC command = new UserSetupMgtBCImpl();
//        
//        try {
//            // measure unit, CD01116
//            List<BkgComboVO> ofc_cds = command.searchOfcCd();
//            //
//            eventResponse.setCustomData("ofc_cds", ofc_cds);
//        } catch (EventException ex) {
//            throw ex;
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getUserMessage(), ex);
//        }
        return eventResponse;
    }        

    /**
     * 조회 이벤트 처리<br>
     *  1075 B/L Print 옵션을 조회합니다.<br>   
     * 
     * @param e EsmBkg0922Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRptItmStup(Event e) throws EventException {
        //
        EsmBkg1075Event event = (EsmBkg1075Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        String ofcCd = event.getOfcCd();
        String custCd = event.getCustCd();
        
        try {
            // search
            List<RptItmStupVO> list = command.searchRptItmStup(ofcCd, custCd);
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }        

    /**
     * EsmBkg1075Event<br>
     * BKG_EDI_TRD_PRNR_SUB_LNK 연동을 처리합니다.
     * @param e EsmBkg1075Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageRptItmStup(Event e) throws EventException {
        //
        EsmBkg1075Event event = (EsmBkg1075Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        RptItmStupVO[] rptItmStupVOs = event.getRptItmStupVOs();

        try {
            begin();
            command.manageRptItmStup(rptItmStupVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * EsmBkg1114Event<br>
     * Country name을 조회합니다.<br> 
     * @param e EsmBkg1114Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchMdmCnt(Event e) throws EventException {
    	
      	BookingUtil command = new BookingUtil();
      	
		try {
			List<MdmCountryVO> list = command.searchMdmCnt();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
       
    }    
    /**
     * 조회 이벤트 처리<br>
     * Zip Code를 조회합니다.<br>   
     * 
     * @param e EsmBkg1114Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchZipCode(Event e) throws EventException {
        EsmBkg1114Event event = (EsmBkg1114Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<ZipCdListVO> list = command.searchZipCode(event.getZipCdSchVO(),event.getIPage());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }       
    /**
     * 입력수정삭제 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 입력,수정 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse manageZipCode(Event e) throws EventException {
    	EsmBkg1114Event event = (EsmBkg1114Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageZipCode(event.getZipCdListVOS(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
    /**
     * 조회 이벤트 처리<br>
     *  China 24hr Manifest관련 China EDI Agent Combo list조회.<br>   
     * 
     * @param e EsmBkg9456Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCstmsChnAgnCdList(Event e) throws EventException {
        EsmBkg9456Event event = (EsmBkg9456Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgCstmsChnAgnCdVO> list = command.searchCstmsChnAgnCdList(event.getBkgCstmsChnAgnCdVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }       
    
    /**
     * 조회 이벤트 처리<br>
     *  China 24hr Manifest관련 China EDI Agent를 조회합니다.<br>   
     * 
     * @param e EsmBkg9456Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCstmsChnAgnStup(Event e) throws EventException {
        EsmBkg9456Event event = (EsmBkg9456Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgCstmsChnAgnStupVO> list = command.searchCstmsChnAgnStup(event.getBkgCstmsChnAgnCdVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }       
    
    /**
     * 입력수정삭제 이벤트 처리<br>
     * BookingMasterMgt의 event에 대한 특정 리스트 입력,수정 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse manageCstmsChnAgnStup(Event e) throws EventException {
    	EsmBkg9456Event event = (EsmBkg9456Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageCstmsChnAgnStup(event.getBkgCstmsChnAgnStupVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }      
   
    
    /**
     * ESM_BKG_0441 : SEARCH<br>
     * Doc Center Office 시간을 조회한다.<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDpcsOfcTm(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0441Event event = (EsmBkg0441Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
//    	String bkgOfcCd = null;
		try {
//	    	bkgOfcCd = event.getBkgOfcCd();
	    	List<BkgDpcsOfcTmVO> list = command.searchDpcsOfcTm(event.getBkgDpcsOfcTmVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }   
    /**
	 * BKG_ESM_0441 : SAVE<br>
	 * DPCS Doc Center Office 의 시간을 저장한다. <br>
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDpcsOfcTm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0441Event event = (EsmBkg0441Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		
		try {
			BkgDpcsOfcTmVO[] bkgDpcsOfcTmVOs = event.getBkgDpcsOfcTmVOS();
			command.manageDpcsOfcTm(bkgDpcsOfcTmVOs, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}    
	
    /**
     * 조회 이벤트 처리<br>
     *  ImportRestricted Commodities Set-up<br>   
     * 
     * @param e EsmBkg1130Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRestrictCmdtList(Event e) throws EventException {
        EsmBkg1130Event event = (EsmBkg1130Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
    	   List<RestrictCmdtListVO> list = command.searchRestrictCmdtList(event.getRestrictCmdtListVO());
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * Restricted, Prohibited 를 중복체크 한다.<br>
     *  ImportRestricted Commodities Set-up<br>   
     * 
     * @param e EsmBkg1130Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRestrictCmdtDupList(Event e) throws EventException {
        EsmBkg1130Event event = (EsmBkg1130Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {

    		List<RestrictCmdtDupListVO> list = command.searchRestrictCmdtDupList(event.getRestrictCmdtListVO());
    	   
    		if(list.size() > 0){
				eventResponse.setETCData("dup_flg", list.get(0).getDupFlg());
				eventResponse.setETCData("chk_loc_cd", list.get(0).getChkLocCd());
				eventResponse.setETCData("chk_cnt_cd", list.get(0).getChkCntCd());
				eventResponse.setETCData("chk_cnt_knt", list.get(0).getChkCntKnt());
			}else{
				eventResponse.setETCData("dup_flg", "");
				eventResponse.setETCData("chk_loc_cd", "");
				eventResponse.setETCData("chk_cnt_cd", "");
				eventResponse.setETCData("chk_cnt_knt", "");
			}

        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    
    /**
     * Restricted, Prohibited 를 중복체크 한다.<br>
     *  ImportRestricted Commodities Set-up<br>   
     * 
     * @param e EsmBkg1130Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchValidateLocByOrz(Event e) throws EventException {
        EsmBkg1130Event event = (EsmBkg1130Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil util = new BookingUtil();
    
       try {
    	   String rhqCd = event.getRestrictCmdtListVO().getRgnOfcCd();
    	   String cntCd = event.getRestrictCmdtListVO().getCntCd();
    	   String validateFlg = "N";
    	   
    	   if(util.validateLocByOrz(rhqCd, cntCd)){
    		   validateFlg = "Y";
    	   }
            
    	   eventResponse.setETCData("exist_loc_flg", validateFlg);

        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 입력수정삭제 이벤트 처리<br>
     * ImportRestricted Commodities Set-up<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse manageRetrictCmdtList(Event e) throws EventException {
    	EsmBkg1130Event event = (EsmBkg1130Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageRetrictCmdtList(event.getRestrictCmdtListVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
        	rollback();
        	// 등록 되는 항목이 중복 되는 경우 Error Message를 표시한다.
          if(ex.getMessage().indexOf("BKG08207") > -1){
        	  eventResponse.setUserMessage((String) new ErrorHandler("BKG08207").getUserMessage());
          } else {
	 			throw ex;
          }
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_1131 조회 이벤트 처리<br>
     *  ImportRestricted Commodities File Upload<br>   
     * 
     * @param e EsmBkg1131Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRestrictCmdtFile(Event e) throws EventException {
        EsmBkg1131Event event = (EsmBkg1131Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
    	   List<BkgImpImgStoVO> list = command.searchRestrictCmdtFile(event.getRestrictCmdtFileVO());
           
    	   eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * ESM_BKG_1131 저장 이벤트 처리<br>
     *  ImportRestricted Commodities File Upload<br>
	 * @author Lee InYoung
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRetrictCmdtFile(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == manageSpclRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg1131Event event = (EsmBkg1131Event)e;
		RestrictCmdtFileVO restrictCmdtFileVO = event.getRestrictCmdtFileVO();
		restrictCmdtFileVO.setAccount(account);

		try{
			
			// File Size 가 5M 이상이면, SC를 호출하여 Error Message 를 표시한다.
			if("Y".equals(event.getFileSizeChkFlg())){
				eventResponse.setUserMessage(new ErrorHandler("BKG00370").getUserMessage());  //BKG00370 : File size can't not exceeds 5MB.
				
			} else {
			
				//2.로직 처리 실행
				begin();
				command.manageRestrictCmdtFile(restrictCmdtFileVO);
				commit();
	
				//3.로직 처리후 결과처리
				eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공
			}

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

    /**
     * ESM_BKG_1150 조회 이벤트 처리<br>
     * Edit VVD <br>
     * @param e EsmBkg1150Event
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchMapgVvd(Event e) throws EventException {
    	EsmBkg1150Event event = (EsmBkg1150Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
        BookingUtil util = new BookingUtil();
        String vessel_nm = "";

       try {
            // search
    	   List<BkgMapgVvdVO> list = command.searchMapgVvd(event.getBkgMapgVvdVO());
    	   vessel_nm = util.searchVslNm(event.getBkgMapgVvdVO().getVslCd());
    	   eventResponse.setETCData("vessel_nm", vessel_nm);
           
    	   eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
        return eventResponse;
    }
    


	/**
	 * ESM_BKG_1150 저장 이벤트 처리<br>
	 * Edit VVD <br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMapgVvd(Event e) throws EventException {

    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	EsmBkg1150Event event = (EsmBkg1150Event) e;
		try {
			begin();
			BkgMapgVvdVO[] bkgMapgVvdVOs = event.getBkgMapgVvdVOs();
			
			for (int i = 0; i < bkgMapgVvdVOs.length; i++)
				bkgMapgVvdVOs[i].setUsrId(account.getUsr_id());
				command.manageMapgVvd(bkgMapgVvdVOs);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

		return eventResponse;
	}
	
    /**EsmBkg2004Event management event process<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchHrdCdgDesc(Event e) throws EventException {
        EsmBkg2004Event event = (EsmBkg2004Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgHrdCdgDescVO> list = command.searchHrdCdgDesc(event.getBkgHrdCdgDescVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
	/**
	 * EsmBkg2004Event management event process<br>
	 * HrdCdgDesc List management<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse manageHrdCdgDesc(Event e) throws EventException {
    	EsmBkg2004Event event = (EsmBkg2004Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageHrdCdgDesc(event.getBkgHrdCdgDescVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }   
    
    
	/**
	 * EsmBkg2005Event retrieve event process<br>
	 * HrdCdgCtnt List retrieve<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
 	 */
    private EventResponse searchHrdCdgCtnt(Event e) throws EventException {
        EsmBkg2005Event event = (EsmBkg2005Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    
       try {
            // search
            List<BkgHrdCdgCtntVO> list = command.searchHrdCdgCtnt(event.getBkgHrdCdgCtntVO());
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }  
    
	/**
	 * EsmBkg2005Event management event process<br>
	 * HrdCdgCtnt List management<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageHrdCdgCtnt(Event e) throws EventException {
    	EsmBkg2005Event event = (EsmBkg2005Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
            command.manageHrdCdgCtnt(event.getBkgHrdCdgCtntVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
	/**
	 * EsmBkg2004Event management event process<br>
	 * HrdCdgId List management<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkHrdCdgId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2004Event event = (EsmBkg2004Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		String frmHrdCdgId = null;
		String hrd_id_cnt = null;
		
		try{

			frmHrdCdgId = event.getBkgHrdCdgDescVO().getFrmHrdCdgId();
			hrd_id_cnt = command.checkHrdCdgId(frmHrdCdgId);
			eventResponse.setETCData("hrd_id_cnt", hrd_id_cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**check if there is data on Hard coding contents
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkChildCnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2004Event event = (EsmBkg2004Event)e;
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
		String hrdCdgId = null;
		String child_cnt = null;
		
		try{

			hrdCdgId = event.getBkgHrdCdgDescVO().getFrmHrdCdgId();
			child_cnt = command.checkChildCnt(hrdCdgId);
			eventResponse.setETCData("child_cnt", child_cnt);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
    /**
     * 0741: EsmBkg0741Event<br>
     * 등록된 POR 인지 여부를 체크합니다.<br>
     * POR이 키값이므로 중복 등록 되지 않도록 POR 을 체크하고, valid한 POR인지 check 합니다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    
    private EventResponse checkBkgOfcPorPfmc(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0741Event event = (EsmBkg0741Event) e;
        BookingProcessMgtBC command = null;
        List<BkgDocPerfOfcVO> list = null;
        //String check   = null;
        String checkBofcPOR = null;
        String[] temp  = null;
        try {
        	command = new BookingProcessMgtBCImpl();
	        list = command.checkBkgOfcPorPfmc(event.getBkgDocPerfOfcVO());
	        temp  = event.getBkgDocPerfOfcVO().getChkOp().split(":");
	        checkBofcPOR = 0 < list.size() ? "N" : "Y";
	        log.debug("ofc_ty >>> " + event.getBkgDocPerfOfcVO().getOfcTy());
	        log.debug("chk_op >>> " + temp[0]);
	        
	        
	        event.getBkgDocPerfOfcVO().setChkOp(temp[0]);
	        //e-Service Handling Office 에서 
	        //Controlled Office 에 등록된 Office 가  H/OFC 에 등록되지 않도록 체크함

//	        if ("3".equals(event.getBkgDocPerfOfcVO().getOfcTy())) {
//	        	list = command.checkCtrlOffice(event.getBkgDocPerfOfcVO());
//        		chkHOFC = 0 < list.size() ? "N" : "Y";
//	        }
	        eventResponse.setETCData("checkBofcPOR",checkBofcPOR);
	       // eventResponse.setETCData("chkOFC",chkHOFC);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     *  1173 TRO Rmk SETUP 을 조회합니다.<br>   
     * 
     * @param e EsmBkg1173Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTroRmkStup(Event e) throws EventException {
        EsmBkg1173Event event = (EsmBkg1173Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        String bkgTroOfcCd = event.getBkgTroOfcCd();
        
        try {
            // search
            List<TroRmkStupVO> list = command.searchTroRmkStup(bkgTroOfcCd);
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }        

    /**
     * EsmBkg1173Event<br>
     * TRO Rmk SETUP 저장 처리합니다.
     * @param e EsmBkg1075Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageTroRmkStup(Event e) throws EventException {
    	EsmBkg1173Event event = (EsmBkg1173Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        TroRmkStupVO[] troRmkStupVOs = event.getTroRmkStupVOs();

        try {
            begin();
            command.manageTroRmkStup(troRmkStupVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Booking Allocation Master Table의 event에 대한 콤보 이벤트 처리<br>
     * 1215화면에 대한 콤보리스트 조회.<br>
     * @param e EsmBkg1215Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode1215(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        List<BkgComboVO> list = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD03267");
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            rollback();
            throw ex;
	    } catch (Exception ex) {
            rollback();
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 조회.<br>   
     * 
     * @param e EsmBkg1215Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchBkgAlocMgmt(Event e) throws EventException {
        EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
                
        try {
            // search
            List<BkgAlocMgmtVO> list = command.searchBkgAlocMgmt(event.getBkgAlocMgmtVO());
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 저장 및 수정 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 저장 및 수정.<br>
     *  
     * @param e EsmBkg1215Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageBkgAlocMgmt(Event e) throws EventException {
    	EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        BkgAlocMgmtVO[] bkgAlocMgmtVOs = event.getBkgAlocMgmtVOs();

        try {
            begin();
            command.manageBkgAlocMgmt(bkgAlocMgmtVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 삭제 이벤트 처리<br>
     *  Booking Allocation Master Table 화면 삭제.<br>
     *  
     * @param e EsmBkg1215Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeBkgAlocMgmt(Event e) throws EventException {
    	EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        BkgAlocMgmtVO bkgAlocMgmtVO = event.getBkgAlocMgmtVO();

        try {
            begin();
            command.removeBkgAlocMgmt(bkgAlocMgmtVO);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Booking Allocation Master Table의 event에 대한 이벤트 처리<br>
     * 1215화면에 대한 시트내용 검증용 Data 조회.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBkgAlocValidationData(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg1215Event event = (EsmBkg1215Event)e;
    	UserSetupMgtBC command = null;
    	List<BkgAlocMgmtVO> list = null;
    	
		try {
			command = new UserSetupMgtBCImpl();
	    	list = command.searchBkgAlocValidationData(event.getBkgAlocMgmtVO().getValType(), event.getBkgAlocMgmtVO().getValValue());
	    	    	
	    	eventResponse.setETCData("val_cnt",list.get(0).getValCnt());
	    	
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Commodity Name을 조회<br>   
     * 
     * @param e EsmBkg1215Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchCmdtNm(Event e) throws EventException {
        EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
                
        try {
            List<BkgAlocMgmtVO> list = command.searchCmdtNm(event.getBkgAlocMgmtVO());
            eventResponse.setETCData("cmdt_nm",list.get(0).getCmdtNm());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }   
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Commodity Name을 조회<br>   
     * 
     * @param e EsmBkg1215Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchGrpCmdtNm(Event e) throws EventException {
        EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
                
        try {
            List<BkgAlocMgmtVO> list = command.searchGrpCmdtNm(event.getBkgAlocMgmtVO());
            eventResponse.setETCData("scg_grp_cmdt_desc",list.get(0).getCmdtNm());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }   
    
    /**
     * 조회 이벤트 처리<br>
     *  Booking Allocation Master Table 화면에 Group Commodity Combo을 조회<br>   
     * 
     * @param e EsmBkg1215Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchScgGrpCmdtCdList(Event e) throws EventException {
        //EsmBkg1215Event event = (EsmBkg1215Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        RsltCdListVO rsltCdListVO = null; 
                
        try {
        	rsltCdListVO = new RsltCdListVO();
        	rsltCdListVO.setEtc1("TPW");
        	List<RsltCdListVO> list = command.searchScgGrpCmdtCdList(rsltCdListVO);
			eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     *  BDR Access Setting 화면에 BDR권한을 조회<br>   
     * 
     * @param e EsmBkg0597Event
     * @return response EventResponse
     * @exception EventException
     */ 
	@SuppressWarnings("unchecked")
    private EventResponse searchBdrAccessAuthority(Event e) throws EventException {
        BookingMasterMgtBC command =null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
                        
        try {
        	if(e.getEventName().equalsIgnoreCase("EsmBkg0597Event")) {
               	EsmBkg0597Event event = (EsmBkg0597Event) e;
        		command = new BookingMasterMgtBCImpl(); 
        		List<BdrAccessAuthorityInfoVO> bdrAccessAuthorityInfoVOs  
        		= (List<BdrAccessAuthorityInfoVO>) (Object) (command.searchBdrAccessAuthority((BdrAccessAuthorityInfoVO) event.getBdrAccessAuthorityInfoVO()));
        		
   
        		eventResponse.setRsVoList(bdrAccessAuthorityInfoVOs);
        	
         }

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
			ex);
		}
		return eventResponse;
        }
	
	
    /**
     * 아이디 입력시 해당 name 과 office 조회<br>
     * 
     * @param e EsmBkg0597Event
     * @return response EventResponse
     * @exception EventException
     */ 
	@SuppressWarnings("unchecked")
    private EventResponse searchComUserBdrAccessAuthority(Event e) throws EventException {
        BookingMasterMgtBC command =null;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComUserVO comUserVO = null;
    	BookingUtil util = new BookingUtil();
    	
        try {
        	if(e.getEventName().equalsIgnoreCase("EsmBkg0597Event")) {
               	EsmBkg0597Event event = (EsmBkg0597Event) e;
        		command = new BookingMasterMgtBCImpl(); 

            	
        		//
        	
        		List<BdrAccessAuthorityInfoVO> bdrAccessAuthorityInfoVOs  
        		= (List<BdrAccessAuthorityInfoVO>) (Object) (command.searchBdrAccessAuthority((BdrAccessAuthorityInfoVO) event.getBdrAccessAuthorityInfoVO()));
        
       		
        		if(bdrAccessAuthorityInfoVOs != null && bdrAccessAuthorityInfoVOs.size() >0){
        			eventResponse.setETCData("USR_CHK", "Y"  );
					eventResponse.setUserMessage((String) new ErrorHandler("BKG00764",new String[]{event.getBdrAccessAuthorityInfoVO().getSheetUsrId()}).getUserMessage());


        		} else {
        		
        		
	    			comUserVO = util.searchComUserInfo(event.getBdrAccessAuthorityInfoVO().getSheetUsrId());
	    			eventResponse.setETCData("USR_CHK", "N"  );
	         		if(comUserVO != null ){
	 	        		eventResponse.setETCData("Name", (comUserVO.getUsrNm() == null) ? "" : comUserVO.getUsrNm() );
	 	        		eventResponse.setETCData("Office", (comUserVO.getOfcCd() == null) ? "" : comUserVO.getOfcCd());
	         		
	         		}else{
	         			eventResponse.setETCData("USR_CHK", "X"  );
	         			eventResponse.setETCData("Name", "");
	 	        		eventResponse.setETCData("Office", "");
	         		}

        		}

        }

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
			ex);
		}
		return eventResponse;
        }
	
    
	/**
	 * EsmBkg0597Event management event process<br>
	 *  BdrAccessAuthority List management<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
 	 */
    private EventResponse manageBdrAccessAuthority(Event e) throws EventException {
    	EsmBkg0597Event event = (EsmBkg0597Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	
        try {
            begin();
                        
            command.manageBdrAccessAuthority(event.getBdrAccessAuthorityInfoVOs(), account);
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
    
    /**
     * 1180 조회 이벤트 처리<br>
     * Handling Office 를 조회한다 <br>
     * @param e Event EsmBkg1180Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchHandlingOffice (Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg1180Event event = (EsmBkg1180Event)e;
    	
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgHandlingOfficeSetupVO> list = command.searchHandlingOffice(event.getBkgHandlingOfficeSetupVO());
				
			eventResponse.setRsVoList(list);
							
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
	/**
     * 1180 저장 이벤트 처리<br>
     * Handling Office 를 조회한다 <br>
     * @param e Event EsmBkg1180Event
     * @return response EventResponse
     * @exception EventException
	 */
	private EventResponse manageHandlingOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingMasterMgtBC command = new BookingMasterMgtBCImpl();

		EsmBkg1180Event event = (EsmBkg1180Event)e;
		BkgHandlingOfficeSetupVO[] bkgHandlingOfficeSetupVOs = event.getBkgHandlingOfficeSetupVOS();

		try{
			begin();
			command.manageHandlingOffice(bkgHandlingOfficeSetupVOs, account);
			commit();

			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
    /**
     * VVD validation
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchVvdCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0949Event event = (EsmBkg0949Event)e;
        BookingUtil command = new BookingUtil();
    	List<SearchPortCdByVvdVO> list = null;
        try {
        	list = command.searchPortCdListByVvd(event.getBkgdocClzSetListVO().getVvdCd());
        	if(list!=null && list.size()>0)
        		eventResponse.setETCData("vvd_flg", "Y");
        	else
        		eventResponse.setETCData("vvd_flg", "N");
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    		    
    /**
     * BKG_ESM_1509 조회 이벤트 처리<br>
     * Draft B/L image 목록을 조회한다.<br>
     * @param e Event EsmBkg1509Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDraftBlImageList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
    	try{    
    		EsmBkg1509Event event = (EsmBkg1509Event)e;
    		
	    	List<DraftBlImageVO> list = command.searchDraftBlImageList(event.getDraftBlImageVO());
	    	eventResponse.setRsVoList(list);	    	
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    

    /**
     * BKG_ESM_1509 : MULTI<br>
     * Draft B/L image 정보를 저장한다
     * @param Event e
     * @return EventResponse eventResponse
     * @throws EventException
     */
    private EventResponse manageDraftBlImage(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg1509Event event = (EsmBkg1509Event)e;
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		try {
			DraftBlImageVO[] draftBlImageVOs = event.getDraftBlImageVOs();
			
			begin();
			command.manageDraftBlImage(draftBlImageVOs, account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
     * draft b/l image customer code 존재여부 조회<br>
     * @param e Event EsmBkg1509Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDraftBlImageCustCodeYN(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
    	try{    
    		EsmBkg1509Event event = (EsmBkg1509Event)e;
    		
	    	String custCodeYn = command.searchDraftBlImageCustCodeYN(event.getDraftBlImageVO());
	    	eventResponse.setETCData("cust_code_yn", custCodeYn);
	    	
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     *  Web Booking Manual Upload Setup Table 화면 조회.<br>   
     * 
     * @param e EsmBkg1410Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchWebBkgManualUploadSetup(Event e) throws EventException {
        EsmBkg1410Event event = (EsmBkg1410Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
                
        try {
            // search
            List<WebBkgManualUploadSetupVO> list = command.searchWebBkgManualUploadSetup(event.getWebBkgManualUploadSetupVO());
            // set VOs
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * 저장 및 수정 이벤트 처리<br>
     *  Web Booking Manual Upload Setup Table 화면 저장 및 수정/삭제.<br>
     *  
     * @param e EsmBkg1410Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageWebBkgManualUploadSetup(Event e) throws EventException {
    	EsmBkg1410Event event = (EsmBkg1410Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        
        WebBkgManualUploadSetupVO[] bkgAlocMgmtVOs = event.getWebBkgManualUploadSetupVOs();

        try {
            begin();
            command.manageWebBkgManualUploadSetup(bkgAlocMgmtVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     *  Web Booking Manual Upload Setup Table 등록 항목이 중복되는지 체크.<br>   
     * 
     * @param e EsmBkg1410Event
     * @return response EventResponse
     * @exception EventException
     */ 
    private EventResponse searchWebBkgManualUploadSetupDupChk(Event e) throws EventException {
        EsmBkg1410Event event = (EsmBkg1410Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        WebBkgManualUploadSetupVO[] bkgAlocMgmtVOs = event.getWebBkgManualUploadSetupVOs();
        String chkFlg = "0";
        
        try {
        	chkFlg = command.searchWebBkgManualUploadSetupDupChk(bkgAlocMgmtVOs);
			eventResponse.setETCData("chk_flg", chkFlg);
            
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
//            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
            throw new EventException(new ErrorHandler("BKG95069").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * Web Booking Manual Upload Setup Table 등록 시 Lane과 VVD 체크.<br>
     * 
     * @param e EsmBkg1410Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchWebBkgManualUploadSetupSvcLaneByVvd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        String strvslSlanCd = null;
        EsmBkg1410Event event = (EsmBkg1410Event)e;

        try {
        	command = new BookingUtil();
        	strvslSlanCd = command.searchSvcLaneByVvd(event.getWebBkgManualUploadSetupVO().getValValue());
        	eventResponse.setETCData("vsl_slan_cd", strvslSlanCd);
        	
	    } catch(EventException ex) {
	        throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
        return eventResponse;
    }
    
    /**
     * Web Booking Manual Upload Setup Table 등록 시 VVD와 Location 체크.<br>
     * 
     * @param e EsmBkg1410Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchWebBkgManualUploadSetupValidateVvdLoc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = null;
        EsmBkg1410Event event = (EsmBkg1410Event)e;
        String strVvd = "";
        String strLocCd = "";
        String strVslCd = "";
        String strSkdVoyNo = "";
        String strDirCd = "";
        String chkFlg = "0";
        boolean chkVvdLoc = false;
        
        try {
        	strVvd = event.getWebBkgManualUploadSetupVO().getVvd();
        	
            if(!"".equals(strVvd) && strVvd != null){
                strVslCd = strVvd.substring(0,4);
                strSkdVoyNo = strVvd.substring(4,8);
                strDirCd = strVvd.substring(8,9);
            }

            if(null != event.getWebBkgManualUploadSetupVO().getPolCd() && !"".equals(event.getWebBkgManualUploadSetupVO().getPolCd())){
            	strLocCd = event.getWebBkgManualUploadSetupVO().getPolCd();
            }else if(null != event.getWebBkgManualUploadSetupVO().getPodCd() && !"".equals(event.getWebBkgManualUploadSetupVO().getPodCd())){
            	strLocCd = event.getWebBkgManualUploadSetupVO().getPodCd();
            }
            
        	command = new BookingUtil();
        	chkVvdLoc = command.validateVvdLoc(strVslCd, strSkdVoyNo, strDirCd, strLocCd);
        	
        	if(chkVvdLoc) chkFlg = "1";
        	eventResponse.setETCData("chk_flg", chkFlg);
        	
	    } catch(EventException ex) {
	        throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
        return eventResponse;
    }
    
	/**
	 * Web Booking Manual Upload Setup Table 등록 시 VVD와 Country 체크.<br>
	 * 
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String cntCd 
	 * @return String
     * @exception EventException
     */
    private EventResponse searchWebBkgManualUploadSetupvalidateVvdCnt(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg1410Event event = (EsmBkg1410Event)e;
        String chkFlg = "0";
        String strVvd = "";
        String strCntCd = "";
        String strVslCd = "";
        String strSkdVoyNo = "";
        String strDirCd = "";
        
        try {
        	strVvd = event.getWebBkgManualUploadSetupVO().getVvd();
        	
            if(!"".equals(strVvd) && strVvd != null){
                strVslCd = strVvd.substring(0,4);
                strSkdVoyNo = strVvd.substring(4,8);
                strDirCd = strVvd.substring(8,9);
            }

            if(null != event.getWebBkgManualUploadSetupVO().getPolCntCd() && !"".equals(event.getWebBkgManualUploadSetupVO().getPolCntCd())){
            	strCntCd = event.getWebBkgManualUploadSetupVO().getPolCntCd();
            }else if(null != event.getWebBkgManualUploadSetupVO().getPodCntCd() && !"".equals(event.getWebBkgManualUploadSetupVO().getPodCntCd())){
            	strCntCd = event.getWebBkgManualUploadSetupVO().getPodCntCd();
            }
            
            chkFlg = command.searchWebBkgManualUploadSetupvalidateVvdCnt(strVslCd, strSkdVoyNo, strDirCd, strCntCd);
        	eventResponse.setETCData("chk_flg", chkFlg);
        	
	    } catch(EventException ex) {
	        throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    }
        return eventResponse;
    }
    
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchUserSearchSet(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
    
       try {
    	   
            // search
            List<BkgSrchSetVO> list = command.searchUserSearchSet(account.getUsr_id()); 
            // set VOs
            
          eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageUserSearchSet(Event e) throws EventException {
        EsmBkg9461Event event = (EsmBkg9461Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
        try {
            begin();
            command.manageUserSearchSet(event.getBkgSrchSetVOS(), account);
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchCustChkPnt(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0237Event event = (EsmBkg0237Event) e;
        
       try {
    	   event.getBkgCustChkPntVO().setChkPntTpCd("CU"); //Customer Tab
    	   List<BkgCustChkPntVO> cuList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(cuList);
            
    	   event.getBkgCustChkPntVO().setChkPntTpCd("CN"); //Container Tab
    	   List<BkgCustChkPntVO> cnList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(cnList);
    	   
    	   event.getBkgCustChkPntVO().setChkPntTpCd("MD"); //M&D Tab
    	   List<BkgCustChkPntVO> mdList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(mdList);
    	   
    	   event.getBkgCustChkPntVO().setChkPntTpCd("CM"); //C/M Tab
    	   List<BkgCustChkPntVO> cmList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(cmList);
    	   
    	   event.getBkgCustChkPntVO().setChkPntTpCd("EM"); //E-Mail Tab
    	   List<BkgCustChkPntVO> emList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(emList);
    	   
    	   event.getBkgCustChkPntVO().setChkPntTpCd("RA"); //Rating Tab
    	   List<BkgCustChkPntVO> raList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(raList);
    	   
    	   event.getBkgCustChkPntVO().setChkPntTpCd("CO"); //Common Tab
    	   List<BkgCustChkPntVO> coList = command.searchCustChkPnt(event.getBkgCustChkPntVO()); 
    	   eventResponse.setRsVoList(coList);
    	   
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBkgChkPntItem(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0237Event event = (EsmBkg0237Event) e;
        
       try {
    	   event.getBkgChkPntItemVO().setChkPntTpCd("CU"); //Customer Tab
    	   List<BkgChkPntItemVO> cuList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(cuList);
            
    	   event.getBkgChkPntItemVO().setChkPntTpCd("CN"); //Container Tab
    	   List<BkgChkPntItemVO> cnList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(cnList);
    	   
    	   event.getBkgChkPntItemVO().setChkPntTpCd("MD"); //M&D Tab
    	   List<BkgChkPntItemVO> mdList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(mdList);
    	   
    	   event.getBkgChkPntItemVO().setChkPntTpCd("CM"); //C/M Tab
    	   List<BkgChkPntItemVO> cmList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(cmList);
    	   
    	   event.getBkgChkPntItemVO().setChkPntTpCd("EM"); //E-Mail Tab
    	   List<BkgChkPntItemVO> emList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(emList);
    	   
    	   event.getBkgChkPntItemVO().setChkPntTpCd("RA"); //Rating Tab
    	   List<BkgChkPntItemVO> raList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(raList);
    	   
    	   event.getBkgChkPntItemVO().setChkPntTpCd("CO"); //Common Tab
    	   List<BkgChkPntItemVO> coList = command.searchChkPntItem(event.getBkgChkPntItemVO()); 
    	   eventResponse.setRsVoList(coList);
    	   
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBkgChkPntItemTp(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0237Event event = (EsmBkg0237Event) e;
        
       try {
    	   
    	   BkgChkPntItemTpVO bkgChkPntItemTpVO = new BkgChkPntItemTpVO();
    	   bkgChkPntItemTpVO.setChkPntTpCd(event.getChkPntTpCd());
    	   bkgChkPntItemTpVO.setChkPntItmSeq(event.getChkPntItmSeq());
    	   
    	   List<BkgChkPntItemTpVO> List = command.searchChkPntItemTp(bkgChkPntItemTpVO); 
    	   eventResponse.setRsVoList(List);
    	   
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    } 
    
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageBkgCustChkPnt(Event e) throws EventException {
        EsmBkg0237Event event = (EsmBkg0237Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
        try {
            begin();
            command.manageBkgCustChkPnt(event.getBkgCustChkPntVOs(), account);
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageBkgChkPntItem(Event e) throws EventException {
        EsmBkg0238Event event = (EsmBkg0238Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
        try {
            begin();
            command.manageBkgChkPntItem(event.getBkgChkPntItemVOs(), account);
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 
    
    /**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse manageBkgChkPntItemTp(Event e) throws EventException {
        EsmBkg0238Event event = (EsmBkg0238Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
    	
        try {
            begin();
            command.manageBkgChkPntItemTp(event.getBkgChkPntItemTpVOs(), account);
            commit();
             
        } catch(EventException ex) {
 			rollback();
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    } 


    /**
	 * ESM_BKG_0239 : Open <br>
	 * Customer Check Point 의 첨부파일 목록을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustChkPntAttach(Event e) throws EventException {
		EsmBkg0239Event event = (EsmBkg0239Event) e;	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		
		//Attachment List 
		List<CustChkPntAttachVO> custChkPntAttachVO = new ArrayList<CustChkPntAttachVO>();	

		try{

			custChkPntAttachVO = command.searchCustChkPntAttach(event.getCustChkPntAttachVO());
			eventResponse.setRsVoList(custChkPntAttachVO);

		} catch (EventException ex) {
			throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("BKG00627",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
		
	}


	/**
	 * ESM_BKG_0239 저장 이벤트 처리<br>
	 * Customer Check Point의 Attachment 정보 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustChkPntAttach(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg0239Event event = (EsmBkg0239Event)e;
		
		try{
			//2.로직 처리 실행
			begin();
			command.manageCustChkPntAttach(event.getCustChkPntAttachVOS(), event.getKeys(), account);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0325 검색 이벤트 처리<br>
	 * Block Keyword List 조회<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgBlckKwList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		EsmBkg0325Event event = (EsmBkg0325Event) e;	
		List<BlckKwListVO> blckKwListVO = new ArrayList<BlckKwListVO>();	
		try{
			blckKwListVO = command.searchBkgBlckKwList(event.getBlckKwTpCd());
			eventResponse.setRsVoList(blckKwListVO);

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * Bkg blck kw list insert/modify/delete 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgBlckKwList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UserSetupMgtBC command = new UserSetupMgtBCImpl();
		EsmBkg0325Event event = (EsmBkg0325Event) e;	
		try{
			begin();
			command.manageBkgBlckKwList(event.getBlckKwListVOs(),account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	 /**
		 * 1185: EsmBkg1185Event<br>
		 * SERVICE LANE CODE SEARCH.
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchServiceLaneForVgm() throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil command = null;
			BookingMasterMgtBC command2 = null;
			List<MdmVslSvcLaneVO> list = null;
			List<MdmCountryVO> list2 = null;
			List<ContinentCodeVO> listConti = null;
			StringBuffer slanCd = null;
			StringBuffer slanVa = null;
			StringBuffer cntCd = null;
			StringBuffer cntNm = null;
			StringBuffer contiCd = null;
			StringBuffer contiNm = null;
			try {
				command = new BookingUtil();
				command2 = new BookingMasterMgtBCImpl();
				
				list = command.searchSvcLaneCd();
				list2 = command2.searchCntCdNm();
				listConti = command.searchSvcContiCd();
				
				slanCd = new StringBuffer();
				slanVa = new StringBuffer();
				cntCd = new StringBuffer();
				cntNm = new StringBuffer();
				contiCd = new StringBuffer();
				contiNm = new StringBuffer();
				
				slanCd.append("ALL");
				slanVa.append("*");
				cntCd.append("*");
				cntNm.append("ALL");
				contiCd.append("*");
				contiNm.append("ALL");
				
				if (0 < list.size()) {
		        	for (MdmVslSvcLaneVO mdmVslSvcLaneVO : list) {
		        		slanCd.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
		        		slanVa.append("|" + mdmVslSvcLaneVO.getVslSlanCd());
		        	}
				}
				if (0 < list2.size()) {
					for (MdmCountryVO mdmCountryVO : list2) {
						cntCd.append("|" + mdmCountryVO.getCntCd());
						cntNm.append("|" + mdmCountryVO.getCntNm());
					}
				}
				if (0 < listConti.size()) {
					for (ContinentCodeVO continentCodeVO : listConti) {
						contiCd.append("|" + continentCodeVO.getContiCd());
						contiNm.append("|" + continentCodeVO.getContiNm());
					}
				}
				
		        eventResponse.setETCData("slanCd",slanCd.toString());
		        eventResponse.setETCData("slanVa",slanVa.toString());
		        eventResponse.setETCData("cntCd",cntCd.toString());
		        eventResponse.setETCData("cntNm",cntNm.toString());
		        eventResponse.setETCData("contiCd",contiCd.toString());
		        eventResponse.setETCData("contiNm",contiNm.toString());
		        
			} catch(EventException ex) {
				throw new EventException(ex.getMessage(), ex);
		    } catch (Exception ex) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * BKG_ESM_1185 : Retrieve<br>
		 * VGM Cut-off Time 을 Retrieve 처리합니다.
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchVgmCutOffTimeList(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg1185Event event = (EsmBkg1185Event)e;
			
			BookingMasterMgtBC command = null;
			String vslSlanCd = null;
			//String ydCd = null;
			String locCd = null;
			List<BkgVgmClzSetListVO> list = null;
			
			try {
				command = new BookingMasterMgtBCImpl();
				vslSlanCd = event.getBkgVgmClzSetListVO().getVslSlanCd();
				locCd = event.getBkgVgmClzSetListVO().getLocCd();
				list = command.searchVgmCutOffTimeList(locCd, vslSlanCd);
				eventResponse.setRsVoList(list);
			} catch(EventException ex) {
				throw new EventException(ex.getMessage(), ex);
		    } catch (Exception ex) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * BKG_ESM_1185 : SAVE<br>
		 * Documentation Cut-off Time 을 SAVE 처리합니다.
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		
		private EventResponse manageVgmCutOffTimeList(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg1185Event event = (EsmBkg1185Event)e;
			BookingMasterMgtBC command = null;
			try{
				begin();
				command = new BookingMasterMgtBCImpl();
				command.manageVgmCutOffTimeList(event.getBkgVgmClzSetVOS(), account);
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
				commit();
			} catch(EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch(Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * BKG_ESM_1185 : ADD ROW(CHECK)<br>
		 * Documentation Cut-off Time 추가시 POL을 체크합니다.
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		
		private EventResponse searchLocationCodeForVgm(Event e) throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg1185Event event = (EsmBkg1185Event)e;
			BookingUtil command = null;
			String pol = null;
			SearchLocationCodeVO vo = null;
			try {
				command = new BookingUtil();
				pol = event.getBkgVgmClzSetListVO().getPol();
				vo = command.searchLocationCode(pol);
				if (null != vo && "Y".equals(vo.getCallPortFlg())) {
					eventResponse.setETCData("check","Y");
				} else {
					eventResponse.setETCData("check","N");
				}
				
			} catch(EventException ex) {
				throw new EventException(ex.getMessage(), ex);
		    } catch (Exception ex) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
			return eventResponse;
		}
		
		/**
		 * BKG_ESM_1185 : Init<br>
		 * Day Type Code 정보를 조회합니다.
		 * @param 
		 * @return EventResponse
		 * @exception EventException
		 */
		
		private EventResponse searchDayTypeCodeForVgm() throws EventException {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil command = null;
	        List<BkgComboVO> list = null;

			try {
				command = new BookingUtil();
			
				list = command.searchCombo("CD02769");
		        eventResponse.setRsVoList(list);
			} catch(EventException ex) {
				throw new EventException(ex.getMessage(), ex);
		    } catch (Exception ex) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
			return eventResponse;

		}
	    /**
	     * VVD validation
	     * @param Event e
	     * @return EventResponse  
	     * @throws EventException
	     */
	    private EventResponse searchVvdCodeForVgm(Event e) throws EventException {
	        GeneralEventResponse eventResponse = new GeneralEventResponse();
	        EsmBkg1185Event event = (EsmBkg1185Event)e;
	        BookingUtil command = new BookingUtil();
	    	List<SearchPortCdByVvdVO> list = null;
	        try {
	        	list = command.searchPortCdListByVvd(event.getBkgVgmClzSetListVO().getVvdCd());
	        	if(list!=null && list.size()>0)
	        		eventResponse.setETCData("vvd_flg", "Y");
	        	else
	        		eventResponse.setETCData("vvd_flg", "N");
	        } catch(EventException ex) {
	            throw ex;
		    } catch (Exception ex) {
		        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	        }
	        return eventResponse;
	    }
}
