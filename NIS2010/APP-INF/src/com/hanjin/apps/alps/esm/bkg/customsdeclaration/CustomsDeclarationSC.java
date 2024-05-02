/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : CustomsDeclarationSC.java
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.06.01
 *@LastModifier : 민정호
 *@LastVersion : 1.1
 * 2009.04.21 김승민
 * 1.0 Creation
 *-------------------------------------------------------
 * History
 * 2010.10.13 김경섭 [CHM-201005134-01] [ESM-BKG] Europe Advanced Manifest-ENS Download  & Transmit : Retrieve,EDI File Download , EDI Transmit 반영
 * 2010.11.30 김영철 [] R4J - 빈 Block문자들를 점검함.
 * 2011.02.23 이일민 [CHM-201108294] 구주 EU24 관련 SITPRO 수정 요청 (ENS Download 버튼 추가)
 * 2011.03.29 김영철 [CHM-201109637-01] KOR MANIFEST GENERATE 기능 보완  ( 조건 추가 )
 * 2011.04.05 이재위 [CHM-201109537-01] Manifest : ENS Monotiring Function화면 개발
 * 2011.04.06 김영철 [CHM-201109426-01] Sea-NACCS MFR 송신에러 ( WGT 정수자리수가 7자리 이상인지 체크함. )
 * 2011.06.01 민정호 [CHM-201111028-01] AMS - Customs Data Download (D/L) 화면 validation추가
 * 2011.06.20 김봉균 [CHM-201111612-01] US AMS : BAPLIE Monitoring Report
 * 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
 * 2011.07.13 김봉균 [CHM-201111867-01] CANADA ACI Monitoring 신규 개발
 * 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
 * 2011.09.27 이수영 [CHM-201113324-01] Inbound 배정 EAI-Webservice 개발
 * 2011.09.29 민정호 [CHM-201113378] AMS Report에 조회 옵션 추가
 * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2011.10.19 김보배 [CHM-201113922] [BKG] [ROCS] ADD Lane - 하드코딩 제거, lane 추가 테이블 관리
 * 2011.11.21 김보배 [CHM-201114279] [BKG] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
 * 2011.12.16 민정호 [CLT-111209300] [BKG] Empty Repo BOOKING EDI - 비정상 COPRAR FF 생성 
 * 2011.12.28 이경원 [SRM-201122521] [BKG] Australia Customs Manifest 기능 보완 요청
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
 * 2012.03.05 김보배 [CHM-201216338] [BKG] [EXS- ES, PT] BL inquiry Prev. Doc 컬럼 추가
 * 2012.03.26 김현화 [CHM-201216918] [BKG]SNP/Broker Nomination 신규화면 개발
 * 2012.04.17 김종옥 [CHM-201216534] BKR/BKC Transmit by VVD 및 by BKG 수정
 * 2012.04.26 김보배 [CHM-201217062] [BKG] Ghana Customs Manifest 전송 기능 개발 요청
 * 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
 * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
 * 2012.06.20 김보배 [CHM-201218454] [BKG] [ROCS] 타 VVD에 기존재하는 CRN 생성 방지 Validation
 * 2012.07.27 김보배 [CHM-201219045] [BKG] 파키스탄 Manifest 화면 생성 요청
 * 2012.08.22 김보배 [CHM-201219738] [BKG] EXS Monitor 화면 (UI_BKG_1148) 개발 요청 (UI_BKG_1148 기존재로 인해 UI_BKG_1152 로 생성)
 * 2012.08.31 김보배 [CHM-201219908] [BKG] Pakistan Manifest 기능 보완 요청
 * 2012.09.04 김보배 [CHM-201220027] [BKG] [EXS 신고화면 및 레포트화면] Released 추가 (조회조건 Status/ Summary 합계)
 * 2012.09.04 변종건 [CHM-201219976-01] Split 01-Canada A/N 수정 요청
 * 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
 * 2013.07.03 김보배 [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory 설정요청
 * 2013.08.06 김보배 [CHM-201325298] Russia Manifest 기능 개발 요청
 * 2013.08.16 김보배 [CHM-201325971] 이스라엘 FROB 신고 화면
 * 2013.11.01 김상수 [CHM-201327170] China Inbound Manifest DOWN EXCEL  화면 생성 관련
 * 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
 * 2013.11.18 김보배 [CHM-201327127] [RFS Lane] Double calling logic 적용 요청 (2) SItpro & Firm BKG
 * 2013.11.29 김보배 [CHM-201327231] [EU Manifest] EU customs EDI 화면상 export (outbound) 전송 버튼 추가 요청
 * 2014.03.24 김보배 [CHM-201428580] [ENS] ENS ETA 지난뒤 ENS 전송불가 로직 기간 변경 요청 (3일-> 30일)
 * 2014.04.21 김보배 [CHM-201429518] ENS - Arrival Notice 화면 관련 시스템 보완요청
 * 2015.06.29 이한나[CHM-201535756] 한국 WHF 면제/조정 기능 간소화
 * 2015.07.15 이한나[CHM-201536700] Menu : KOR MANIFEST => Warehouse Assign by B/L 화면
=======================================================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0154Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2001Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2002Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.event.EsmBkg2003Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsErrCdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsPckTpConvVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.basic.BangladeshCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.event.EsmBkg1038Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.bangladesh.vo.LicenseInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.basic.CustomsReportBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.basic.CndCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0025Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg0401Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.event.EsmBkg1125Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.ACIMonitorListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.canada.vo.CndCstmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.basic.ChinaCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg0152Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1047Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1048Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1053Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestSendDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.basic.EurCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.eur.event.EsmBkg1032Event;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.basic.IndiaCustomsReportBCImpl;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.event.EsmBkg1221Event;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.event.EsmBkg1222Event;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.event.EsmBkg1223Event;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndDecCondVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpAdvanceListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndExpVesselPlanListVO;
//import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.india.vo.IndReexportListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.basic.JapanCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0471Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0472Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0477Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.event.EsmBkg0478Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListRcvLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListReceiveHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListSndLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanManifestListTransmitHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.basic.KorCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0215Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0334Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0335Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0340Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0341Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0345Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0346Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0347Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0358Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0502Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0917Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0989Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0994Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCYVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischPrintListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorEntryTpVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorImpPrintListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorMrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorRcvHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorReportHistContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorTransmitHistDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorWareHouseVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.basic.UsaCustomsReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0041Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0359Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0428Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0429Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0507Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0508Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0518Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0574Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg0819Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1037Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1122Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportIsf5ListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsRailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.CheckListDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReportHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.SendLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.DischCoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.basic.AncsCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0183Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0184Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkgUbizhjsAlpsbkgAnrackEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.basic.AustrailiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.austrailia.vo.DgEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.basic.BangladeshCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.basic.BrcsCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0002Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0006Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0028Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0142Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0431Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0434Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0500Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.EsmBkg0501Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizhjsAlpsBkgCancusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.StiDetailCndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.basic.ChinaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.AlpsBkgTCncusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0217Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0219Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1046Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1070Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.basic.DubaiCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.basic.EurCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.AlpsbkgSpainCRNReceiveEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.AlpsbkgUbizhjsEurcusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0257Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.EsmBkg0484Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifesDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProCargoManifestCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.SitProENSDownExcelVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.basic.AlpsbkgUbizhjsEur24cusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.basic.Eur24CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ghana.basic.GhanaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.hongkong.basic.HongKongCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.basic.IndiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0298Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0302Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0303Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.basic.IndonesiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.event.EsmBkg0310Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IndonesiaFFVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.israel.basic.IsraelCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.basic.JapanCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.event.UbizhjsAlpsBkgNaccsReplyEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic.JapanTerminalTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0479Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0480Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.JapanAlpsBkgNaccsReplyEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.basic.KorCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0030Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0031Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0212Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0344Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0371Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkg0503Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevhjsAlpsbkgEntryEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevhjsAlpsbkgKrcusEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.UbizhjsAlpsbkgKrcusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdFormVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmdManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorAmendManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCancelManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorCntrNoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorDischManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorEmpAmdManiTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorIftsaiSndCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestCancelTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGMTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestDGNTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestMFTTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorMrnCreateInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorRcvAckMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCancellCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo.KorTransCrossChkDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.basic.MalaysiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.basic.MexCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.event.EsmBkg0370Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.myanmar.basic.MyanmarCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.panama.basic.PanamaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.basic.RocsCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.rocs.vo.RocsManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.russia.basic.RussiaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.srilanka.basic.SrilankaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.taiwan.basic.TaiwanCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0233Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0514Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg0543Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1023Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.EsmBkg1098Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.Ubiz2hjsAlpsbkgAmsAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.basic.VietnamCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestListResultForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.DgmManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.basic.InbondTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.basic.UsaInbondTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0408Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0533Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0540Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.InBondNumberVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaMibTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.basic.AncsManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0044Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0045Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0063Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0186Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0494Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0551Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0728Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg1095Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsBkgCstmsAnrCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsAnrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsMfListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsVesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.basic.AusDgManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event.EsmBkg0053Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event.EsmBkg1512Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.basic.BangladeshManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event.EsmBkg1033Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBackEndBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic.BrcsManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0127Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event.EsmBkg0745Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM0740001Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0013Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0015Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0016Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0029Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg0249Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.EsmBkg1178Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlMainVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVslCrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.HusBlInpChkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg0216Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.basic.DominicanManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dominican.event.EsmBkg1162Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.basic.DubaiManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1085Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1086Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event.EsmBkg1087Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiBlManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiVesselManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.basic.Eur24ManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1104Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1105Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1106Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1107Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1108Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1109Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1112Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1113Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1115Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1120Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1121Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1124Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1126Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1127Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1128Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1146Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1152Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1171Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event.EsmBkg1172Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.CustomsSetupVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24EDIHistoryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EU24RcvErrorCodeTableVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EXSListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ExsListOBVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestOBListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.basic.GhanaManifestLIstDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.event.EsmBkg1142Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo.GhanaSearchVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.basic.HongKongManifestLIstDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.event.EsmBkg0282Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo.HongKongSearchVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.basic.IndiaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0296Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0300Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0304Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.event.EsmBkg0305Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.InPrintFormCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.india.vo.IndiaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.basic.IndonesiaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event.EsmBkg0311Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaSearchManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.indonesiaBkgDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.basic.IsraelManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1168Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1169Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo.IsraelSearchRcvHisVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.basic.JapanManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0455Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0456Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0457Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0458Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0462Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0466Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0470Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0730Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0990Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0991Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkgUbizhjsAlpsbkgNaccsEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetail2VO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListBkgDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCmfDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListDorListInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListEtcVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfsDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListVslPortSkdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic.KorManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.basic.KorManifestListDownloadBackEndBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EmsBkgWeb0010001Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0329Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0332Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0333Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0337Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0338Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.event.EsmBkg0505Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrMfSeqNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgCstmsKrVvdSmryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBkgHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoKorVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBlInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBondLocalInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorBondTsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCmdtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCntrTpSzVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCodeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorCorrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDgCgoManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDiscCYBondInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorDlContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorElnoInqInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorEmpAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorExpCorrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorIbDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMSNCreateContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManiSumCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestAmdManiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestEditModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorManifestSmryCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnCreateCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnBondInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorMsnCreateVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorObDgCgoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorPckInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorRateHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorTmpBlBkgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.KorVslInfoNManifestVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo.ObMsnInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.basic.MalaysiaManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1141Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.basic.MyanmarManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.event.EsmBkg1155Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.basic.PakistanManifestLIstDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.event.EsmBkg1148Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanCNTRInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.vo.PakistanVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.basic.PanamaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0017Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.event.EsmBkg0018Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.panama.vo.PanamaVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.basic.ManilaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.event.EsmBkg0234Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchBolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPodVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckPolVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCheckVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchCtnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchGenVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgDescTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchPkgMarkTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.philippine.vo.ManilaSearchVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.basic.RocsManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0061Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0351Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0440Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0442Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0443Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0444Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0448Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg0450Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1017Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1027Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1094Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkg1135Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkgAlpsbkgUdevhjsEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsBlModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerSaveVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlCountVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCRNVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchCntrListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchInboundBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchPortListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocsSearchVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo.RocscrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.basic.RussiaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1163Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.event.EsmBkg1164Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.FdrBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.basic.SriLankaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0490Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkg0493Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkgSlkcusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchBlListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchCntrListTempVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchEtdDtVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchManifestVpsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchRegistNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchResponseVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaSearchVsselNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo.SriLankaVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.taiwan.event.EsmBkg0497Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.basic.ThailandManifestLIstDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event.EsmBkg1147Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0034Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0036Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0037Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0210Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0393Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0613Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0615Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0926Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg0947Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1008Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1144Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event.EsmBkg1179Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.OrgPartyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBkgCmVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlCustVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlDetailContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaBlRemarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaContainerManifestDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaDownloadSummaryVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaHblCheckDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDownloadCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaVesselVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserAuthListModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UserInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.basic.VietnamManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListSecondBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.event.EsmBkg1149Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AuthSetupListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.AvcNoteSetUpInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlSeqVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BondDetailListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CodeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CrnVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsNtfyAddrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.DispoCdListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.HouseBlDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManiDGMTransVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestConfirmationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCntrModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrMndModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.RecieveHistLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.TransmitHistVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DubaiCstmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0381Event; //CHM-201641466
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.event.EsmBkg1511Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusBkgAndLocalDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusDgListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.AusVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgCntrInfoListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.DgInqModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.austrailia.vo.FeederNameVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlDocVO;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsKrDlHisVO;
import com.hanjin.syscommon.common.table.BkgHisDtlVO;
import com.hanjin.syscommon.common.table.BkgHisMstVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgRateVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmPortVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.syscommon.management.alps.user.basic.UserBC;
import com.hanjin.syscommon.management.alps.user.basic.UserBCImpl;
 
/**
 * NIS2010-CustomsDeclaration Business Logic ServiceCommand -
 * NIS2010-CustomsDeclaration 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclaration system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0017업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclaration system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0017 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-CustomsDeclaration system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		String eventName = e.getEventName();
		FormCommand formCommand = e.getFormCommand();

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0063Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsMfDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = createCstmsVvdRefNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// TRANSIT CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD03003"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitTerminalEdi(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitTerminalEdi(e);
			}
			
		}//신규정 작업 중 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1179Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsCustomsStatusNoticeInfo(e);
			} 
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageUsCustomsStatusNoticeInfo(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0448Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTransmitHistList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = confirmManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyBlPolCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0442Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForRocsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0351Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyBlSeq(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0282Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerManifest(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0497Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0234Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0002Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0006Event")		
				|| e.getEventName().equalsIgnoreCase("EsmBkg0298Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0302Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0303Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = downloadManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e); // NCM Code 조회
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchUvi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				//GeneralEventResponse response = new GeneralEventResponse();
				// Receiver ID 콤보
				//response.setRsVoList(searchComCodeCombo("CD02299"));
				//eventResponse = response;
					
				eventResponse = searchEurCustReceiver("CD02299", ""); 					// Receiver ID 콤보 데이터 설정 2014.10.10 csy
				eventResponse.setETCData("cnt_cd", searchEurCustCntCode("CD02299"));	//country 콥보박스 데이터 설정 2014.10.10 csy		
				
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				// POD, POL Validation Check
				eventResponse = searchLocation(e);
				// }else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
				// // eur-cta : 대상 존재여부 조회
				// eventResponse = searchExistBkgNoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchEurManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchEurCustReceiver("CD02299", ((EsmBkg0257Event) e).getKey()); // Receiver ID 콤보 데이터 설정 2014.10.10 csy
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVessel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0926Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifySetupList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUserAuthority(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = reactivateBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = correctBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				// DUMMY BL NO
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)
					|| e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
				eventResponse = transmitManifestIsf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchUiSetUpInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContainerList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = transmitVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitActualVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0249Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdDtlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0745Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyContainerManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHSCode(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0304Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0462Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForDl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForDl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0431Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvHisList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
			// log.info("=== EsmBkg0210Event Start ===");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// log.info("=== EsmBkg0210Event SEARCH ===");
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0215Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDownLoadHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAuthSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUiSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAuthSetupList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForMfs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForMfs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { //new_transmit
				eventResponse = transmitManifestListRenewal2017(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsManifestAmendment(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transDeleteAmendManifest(e);				
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0574Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScacReportByVvdPod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCodeConversion(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0434Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0500Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndHisList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0501Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTransmitHistList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTransmitHistList2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02235"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0819Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0429Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsReportList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(searchCodeCombo("CD02292"));
				// 미국 현재 날짜 조회
				response.setETCData("date", searchLocalSysdate(e));
				
		        //RHQ 추가
				BookingUtil utilCommand = new BookingUtil();
		        List<BkgComboVO> list = utilCommand.searchRgnOfficeCd();
		        BkgComboVO combovo = new BkgComboVO();
		        combovo.setVal(" ");
				combovo.setDesc("");
				list.add(0,combovo);
				response.setRsVoList(list);
				
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchHardCoding(Constants.HrdCdgId.CND_RESULT_CODE));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsTrsmRsltList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsDoNotLoadAndRemoveList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsHoldAndRemoveList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUiSetUpInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)
					|| e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)
					|| e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)
					|| e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchHubInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				// DEL_CD 입력후 HUB, Location of Goods조회
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0440Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0443Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH03)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchVesselArrivalListInRocs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrivalListInRocs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1135Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRocsLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRocsLane(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0990Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = manageBkgReferenceNumberGeneration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0456Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0615Event")				
				|| e.getEventName().equalsIgnoreCase("EsmBkg0543Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0514Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthYn(e); // 초기 오픈시 유저 권한 체크.
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e); // MI/HI/TI 전송.
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitOfm(e); // Ofm Generation.
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchVessel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0455Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrCntr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0183Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsSndHisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsVvdInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0458Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMfrMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMfrMnd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0184Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsLogDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0300Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsNtfyAddr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOrganization(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsNtfyAddr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0457Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForCmf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifestForCmf(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = reactivateBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI11)) {
				eventResponse = transmitManifestListRenewal2017(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0329(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = downloadCstmsBlList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageMsnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageCrossCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {                                                                                                 
				// BL List의 수출신고 번호 누락건의 Email 전송 CHM-201641466                                                                                                    
				eventResponse = sendSimpleElNoEmail(e);                                                                                                                         
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {                                                                                                 
				// BL List의 consol건데 대하여 HouseBL EDI 요청 Email 전송                                                                                                      
				eventResponse = sendConsoleEmail(e);                                                                                                                      
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				// 수정
				eventResponse = modifyManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				// 삭제
				eventResponse = manageManifestSummaryInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Trans Amdendment to PA
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				// Trans Discharge 하선신고
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				// Trans Manifest
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				// Trans Empty Amend
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				// Cancel Per B/L
				eventResponse = transAmendManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0345Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWareHouseInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0346Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchTransCancellInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitCancellKR(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0347Event")) {			
			// TODO : 0347
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDischCoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDischCoList(e);
			}
			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0502Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0989Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHistDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0994Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRcvHistDtl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0470Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0401Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOfcSetInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageOfcSetInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOfcSetInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchHardCoding(Constants.HrdCdgId.CND_AN_TP_CD));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = manageAvcNoteSetUpInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchCstmsAvcNotesPrnTpList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0466Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestListForDor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestForDor(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = assignInBondNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)
					|| e.getFormCommand().isCommand(FormCommand.MULTI02)
					|| e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchUserAuthInfoForHub(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0477Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifestForResend(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0471Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0472Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0478Event")
				|| e.getEventName().equalsIgnoreCase("EsmBkg1032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSendLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase(
				"EsmBkgUbizhjsAlpsbkgNaccsEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveUbizhjsAlpsbkgNaccs(e);
			}
		} else if (e.getEventName().equalsIgnoreCase(
				"JapanAlpsBkgNaccsReplyEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveJapanTerminalAlpsbkgNaccs(e);
			}
		} else if (e.getEventName().equalsIgnoreCase(
				"EsmBkgAlpsbkgUdevhjsEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveAlpsbkgUdevhjs(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = transAmendManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0212Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				// 조회
				eventResponse = searchDgCgoManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				// 수정
				eventResponse = manageDgCgoManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				// Transmit DGM
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// Transmit DGL
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0333Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiscCYBondInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDiscCYBondInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = interfaceWhfToArInv(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = deleteWhfChgRt(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg0332Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWhfChgRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageWhfChgRt(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0334Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDiscCYCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDiscCYCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0335Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmEntryTpList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmEntryTpList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMsnBondedInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMsnBondedInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0305Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBondList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0340Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDischCYList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDischCYList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0341Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDischCYList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDischCYList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0371Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMrnInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMrnCreateInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = manageMrnCreateInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchMrnDuplicated(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0358Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMRNNoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchTempBlNoNBkgNoAssign(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchContainer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOrgPartyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				GeneralEventResponse response = new GeneralEventResponse();
				response.setRsVoList(searchCodeCombo("CD03013"));
				eventResponse = response;

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOrgPartyInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase(
				"EsmBkgUbizhjsAlpsbkgAnrackEvent")
				|| e.getEventName().equalsIgnoreCase(
						"UbizhjsAlpsBkgCancusAckEvent")
				|| e.getEventName().equalsIgnoreCase(
						"UbizhjsAlpsbkgNaccsReplyEvent")
				|| e.getEventName().equalsIgnoreCase("EsmBkgSlkcusAckEvent")
				|| e.getEventName().equalsIgnoreCase(
						"AlpsbkgUbizhjsEurcusAckEvent")
				|| e.getEventName().equalsIgnoreCase("AlpsBkgTCncusAckEvent")
				|| e.getEventName().equalsIgnoreCase(
						"Ubiz2hjsAlpsbkgAmsAckEvent")
				|| e.getEventName().equalsIgnoreCase(
						"AlpsbkgUbizhjsEur24cusAckEvent")
				|| e.getEventName().equalsIgnoreCase(
						"AlpsbkgSpainCRNReceiveEvent")
				|| e.getEventName().equalsIgnoreCase(
						"UbizhjsAlpsbkgKrcusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0947Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				BookingUtil command2 = new BookingUtil();
				// ALL 옵션을 위한 기본 콤보 객체 선언.
				// BkgComboVO combovo = new BkgComboVO();
				// combovo.setDesc(" ");
				// combovo.setName(" ");
				List<BkgComboVO> list = command2.searchCombo("CD02571");
				// list.add(0, combovo);

				GeneralEventResponse response = new GeneralEventResponse();
				// Message Type Code 콤보 조회
				response.setRsVoList(list);
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDispositionCdList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDispositionCdList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0518Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlListByCntr(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("ESM0740001Event")) {
			eventResponse = loadVslCertiExpDt(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0359Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmissionCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchVesselArrival(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0393Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = checkHouseBlDataList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitStowageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = downloadManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Container No. 정보 조회
				eventResponse = searchContainer(e);
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Trans Mod Id 콤보
				response.setRsVoList(searchCodeCombo("CD02260"));
				// Seal Kind Cd 콤보
				response.setRsVoList(searchCodeCombo("CD02184"));
				// Sealer 콤보
				response.setRsVoList(searchCodeCombo("CD02183"));
				// Weight 단위 콤보
				response.setRsVoList(searchCodeCombo("CD00775"));
				// Measure 단위 콤보
				response.setRsVoList(searchCodeCombo("CD01116"));
				// TRANSMIT MESSAGE TYPE ID
				response.setRsVoList(searchHardCoding(e, "TRSM_MSG_TP_ID"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = downloadManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = transmitManifestCN(e);
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// TRANSMIT MESSAGE TYPE ID
				response.setRsVoList(searchHardCoding(e, "TRSM_MSG_TP_ID"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAmsRailHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDelMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDelMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// TRANSIT CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02260"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// POD, DEL Validation Check
				eventResponse = searchLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}// else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				// eventResponse = transmitManifestForRe(e);
				// }
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}// else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				// eventResponse = transmitManifestForRe(e);
				// }
		} else if (e.getEventName().equalsIgnoreCase(
				"EsmBkgUdevhjsAlpsbkgEntryEvent")
				|| e.getEventName().equalsIgnoreCase(
						"EsmBkgUdevhjsAlpsbkgKrcusEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchManifestPodList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchExistVvdPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchENSDownExcel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// customer. 정보 조회
				eventResponse = searchCustomerInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLicenseInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0917Event")) {
			// 세관 수신내역 조회
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiveHist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// PERISHABLE CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02352"));
				// CONTAINER CARGO TYPE CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02236"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
				// }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01))
				// {
				// // POD, DEL Validation Check
				// eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
				// }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01))
				// {
				// // POD, DEL Validation Check
				// eventResponse = searchLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// DUBAI TRADE CODE
				response.setRsVoList(searchCodeCombo("CD02558"));
				// DUBAI CARGO CODE
				response.setRsVoList(searchCodeCombo("CD02559"));
				// DUBAI CONTAINER SERVICE TYPE CODE
				// response.setRsVoList(searchCodeCombo("CD02560"));
				// DUBAI PACKAGE TYPE CODE
				// response.setRsVoList(searchCodeCombo("CD02561"));
				// DUBAI TRANSSHIPMENT MODE CODE
				// response.setRsVoList(searchCodeCombo("CD02564"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)
					|| e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPkgUnitList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkgUnitList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePkgUnit(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = inquiryBlData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsBl(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1095Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAncsLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAncsLane(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCrnNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBaplieAlarmSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBaplieAlarmSetup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				String retVal = command
						.searchMdmLocPortName(((EsmBkg1098Event) e)
								.getStrLocCd());
				eventResponse.setETCData("port_cd", (retVal == null || retVal
						.equals("")) ? "INVALID" : retVal);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				String retVal = command
						.searchMdmVslSvcLane(((EsmBkg1098Event) e)
								.getStrSlanCd());
				eventResponse.setETCData("slan_cd", retVal);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = new GeneralEventResponse();
				BookingUtil command = new BookingUtil();
				ComUserVO comUserVO = command
						.searchComUserInfo(((EsmBkg1098Event) e).getStrUsrId());
				if (comUserVO != null) {
					eventResponse.setETCData("rcvr_eml", comUserVO.getUsrEml());
					eventResponse.setETCData("usr_nm", comUserVO.getUsrNm());
					eventResponse.setETCData("ofc_cd", comUserVO.getOfcCd());
				} else {
					eventResponse.setETCData("rcvr_eml", "");
					eventResponse.setETCData("usr_nm", "");
					eventResponse.setETCData("ofc_cd", "");
				}
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEu1stPortByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifestENS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = search1stEUvvdByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEU24CountryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchPreEUportByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchPreEUvvdByBL(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchENSReport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLaneByVvd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1113Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1115Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24RcvErrorCodeTable(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1120Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchENSMonitoring(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1120(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomsSetupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmLocationPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMdmYardTmlcode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEU24CustomsSetup(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = deleteAllMrn(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEu1stPortByVvd(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCstmsENSPofeList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCstmsOfficeIdByPort(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1107Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH01)
					|| formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = manageMrnNo(e);
			} else if (formCommand.isCommand(FormCommand.MULTI03)) {
				eventResponse = reactivateMrnNo(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMdmCust(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1112Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvMsg(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsCdConvDescList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageCstmsCdConvDesc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageCstmsCdConvCtnt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCstmsCdConvCtntList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkCstmsCdConvDesc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsPckTpConvList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsPckTpConv(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCstmsPckTpConv(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkPckTpCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsAdvErrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCstmsAdvErr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCstmsAdvErr(e);
			}

		} else if (eventName.equalsIgnoreCase("EsmBkg0503Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransCrossChk(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEu1stPortByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = transmitManifestEXS(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEuOBVvdByBL(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEU24CountryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1122Event")) { // 2011.06.20
																			// 김봉균
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBaplieMonitor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUsLastForeignPort(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1124Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e); // 1124
			} else if (formCommand.isCommand(FormCommand.SEARCH01)
					|| formCommand.isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchContainerList(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVesselArrival(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMdmCust(e); // 1124
			} else if (formCommand.isCommand(FormCommand.MULTI02)) {
				eventResponse = managePrevDocNo(e); // append Prev. Doc No
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1125Event")) { // 2011.07.13
																			// 추가
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchACIMonitor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode1125(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1126Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEXSReportOB(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEXSSvcLaneByVvdOB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistoryOB(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1128Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsRcvMsgOB(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1141Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Status 콤보
				response.setRsVoList(searchComCodeCombo("CD02996"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = addSendLog(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1146Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrevDocNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)
					|| e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = managePrevDocNo(e); // append Prev. Doc No
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1148Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEXSMonitoring(e);
			}
		}
		// ---------------------------------------------------------------------------
		// WebService EAI [WEB_001_0001] 2011.09.27 추가
		// ---------------------------------------------------------------------------
		else if (e.getEventName().equalsIgnoreCase("EmsBkgWeb0010001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyWeb0010001ControlMgmt(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1147Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCstmsVvdInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchManifestExcelList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Status 콤보
				response.setRsVoList(searchComCodeCombo("CD02996"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1155Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// Status 콤보
				response.setRsVoList(searchComCodeCombo("CD02996"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = downloadManifestList(e); // xml로 다운로드
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRussiaCntrInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = downloadManifestList(e);// Text로 다운로드
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1164Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForFdrBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustInfoBkgCstmsRuCust(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVesselSchedule(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = backEndJobResult(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1169Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRcvHis(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0219Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInboundTSManifest(e);
			}
		} else if (eventName.equalsIgnoreCase("EsmBkg1171Event")) {
			if (formCommand.isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI)) {
				eventResponse = manageFIVesselArrival(e);
			} else if (formCommand.isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitFiBlArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlArrival(e);
			} else if (formCommand.isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEu1stPortByVvd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1172Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEU24EDIHistory(e);
			}
		} 
		
//		else if (e.getEventName().equalsIgnoreCase("EsmBkg1223Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchExpVesselList(e);
//			}
//			
//		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1221Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchReexportList(e);
//			}
//			
//		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1222Event")) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//				eventResponse = searchExpAdvanceList(e);
//			}
//			
//		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCstmsCndVslCrnNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = removeBkgCstmsCndVslCrnNo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCCAMList(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1511Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAusDgInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDgManifestList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { 
				// 위험물 EDI 전송
				eventResponse = sendDgManifestList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1512Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrInfoListByBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCgoSeqListByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDgCargoInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchForwarderName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchUnnoName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchDgFeederNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageDgManifestList(e);
			}
		}		

		
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * WEB_001_0001 : MULTI01<br>
	 * WebService EAI(WEB_001_0001)<br>
	 * 
	 * @author Su-Young, Lee
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyWeb0010001ControlMgmt(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = null;
		EmsBkgWeb0010001Event event = null;
		ManifestListDownloadBC command = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EmsBkgWeb0010001Event) e;
			command = new KorManifestListDownloadBCImpl();
			begin();
			BkgWebServiceVO webVO = event.getBkgWebServiceVO();

			command.modifyWeb0010001Control(webVO);

			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsOfficeIdByPort(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) { // EUR24
																		// -
																		// Original
																		// port에
																		// 따른
																		// Yard/Office조회
				Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				voList = command3.searchCstmsOfficeIdByPort((String) event
						.getRvis_n1st_clpt_cd());
				eventResponse.setRsVoList(voList);
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
	 * ESM_BKG_0063 : SEARCH <br>
	 * ESM_BKG_0186 : SEARCH01 <br>
	 * ESM_BKG_0613 : SEARCH <br>
	 * ESM_BKG_0615 : SEARCH <br> 
	 * ESM_BKG_0013 : SEARCH<BR>
	 * 세관 신고용 VVD 정보 조회<br>
	 * 
	 * @param Event
	 *            event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")) {
				EsmBkg0013Event event = (EsmBkg0013Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event
						.getCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event
						.getAncsCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command
						.searchMiManifestList(event.getManifestListCondVO());
				UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list
						.get(0);
				String search_mtd = ((UsaManifestSearchCondVO) event
						.getManifestListCondVO()).getSearchMtd();
				if ("Summary".equals(search_mtd)
						&& containerVO.getUsaManifestSummaryVO() != null) {
					eventResponse.setRsVoList(containerVO
							.getUsaManifestSummaryVO());
				}
				if (!"Summary".equals(search_mtd)
						&& containerVO.getUsaManifestSearchDetailVO() != null) {
					eventResponse.setRsVoList(containerVO
							.getUsaManifestSearchDetailVO());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
				EsmBkg0615Event event = (EsmBkg0615Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command.searchMiManifestList(event.getManifestListCondVO());
				UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list.get(0);
				String search_mtd = ((UsaManifestSearchCondVO) event.getManifestListCondVO()).getSearchMtd();
				
				if ("Summary".equals(search_mtd) && containerVO.getUsaManifestSummaryVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSummaryVO());
				}
				if (!"Summary".equals(search_mtd) && containerVO.getUsaManifestSearchDetailVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSearchDetailVO());
				}				
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")) {
				EsmBkg0186Event event = (EsmBkg0186Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event
						.getAncsCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0044Event")) {
				EsmBkg0044Event event = (EsmBkg0044Event) e;
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdInfoVO> list = command.searchCstmsVvdInfo(event
						.getAncsCstmsVvdInfoCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1147Event")) {
				EsmBkg1147Event event = (EsmBkg1147Event) e;
				command = new ThailandManifestLIstDownloadBCImpl();
				List<ThailandVvdInfoVO> list = (List<ThailandVvdInfoVO>) (Object) (command
						.searchCstmsVvdInfo((CstmsVvdInfoCondVO) event
								.getThailandVvdInfoCondVO()));

				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0013 : MULTI<BR>
	 * 세관 관련 VVD 정보 생성, 수정, 삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsVvdInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0013Event event = (EsmBkg0013Event) e;
			command = new CndManifestListDownloadBCImpl();
			begin();
			command.manageCstmsVvdInfo(event.getCstmsVvdInfoVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0013 : SEARCH11<BR>
	 * 세관 신고용 VVD별 Reference No 생성<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCstmsVvdRefNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0013Event event = (EsmBkg0013Event) e;
			command = new CndManifestListDownloadBCImpl();
			eventResponse.setETCData("max_cvy_ref_no", command
					.createCstmsVvdRefNo(event.getCstmsVvdRefNoCondVO())
					.getNewCrn());
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_0296 : SEARCH <br>
	 * ESM_BKG_0017 : SEARCH <br>
	 * ESM_BKG_0127 : SEARCH <br>
	 * ESM_BKG_0234 : SEARCH <br>
	 * ESM_BKG_0061 : SEARCH <br>
	 * ESM_BKG_0444 : SEARCH01 <br>
	 * ESM_BKG_0351 : SEARCH <br>
	 * ESM_BKG_0282 : SEARCH <br>
	 * ESM_BKG_0490 : SEARCH <br>
	 * ESM_BKG_0310 : SEARCH <br>
	 * ESM_BKG_0311 : SEARCH <br>
	 * ESM_BKG_0302 : SEARCH <br>
	 * ESM_BKG_0303 : SEARCH <br>
	 * ESM_BKG_0533 : SEARCH <br>
	 * ESM_BKG_0002 : SEARCH <br>
	 * ESM_BKG_0210 : SEARCH <br>
	 * ESM_BKG_0329 : SEARCH <br>
	 * ESM_BKG_0337 : SEARCH <br>
	 * ESM_BKG_0505 : SEARCH, COMMAND09 <br>
	 * ESM_BKG_0030 : SEARCH, SEARCH03<br>
	 * ESM_BKG_0540 : SEARCH, SEARCH04 <br>
	 * ESM_BKG_1033 : SEARCH01, SEARCH02, SEARCH03, SEARCH04 <br>
	 * ESM_BKG_0613 : SEARCH01 <br>
	 * ESM_BKG_0615 : SEARCH01 <br> 
	 * ESM_BKG_0543 : SEARCH01 <br>
	 * ESM_BKG_0514 : SEARCH01 <br>
	 * ESM_BKG_0233 : SEARCH01 <br>
	 * ESM_BKG_0370 : SEARCH <br>
	 * ESM_BKG_0408 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_0533 : SEARCH <br>
	 * ESM_BKG_1106 : SEARCH <br>
	 * ESM_BKG_1141 : SEARCH <br>
	 * ESM_BKG_1142 : SEARCH <br>
	 * ESM_BKG_1148 : SEARCH <br>
	 * ESM_BKG_1149 : SEARCH <br>
	 * ESM_BKG_1155 : SEARCH <br>
	 * ESM_BKG_1162 : SEARCH <br>
	 * ESM_BKG_1163 : SEARCH <br>
	 * ESM_BKG_1168 : SEARCH <br>
	 * 화물에 대한 Manifest List를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		log.info("=== EsmBkg0210Event searchManifestList ===");
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
				EsmBkg0017Event event = (EsmBkg0017Event) e;
				List<PanamaContainerVO> panamaContainerVOs = null;
				PanamaContainerVO panamaContainerVO = null;
				command = new PanamaManifestListDownloadBCImpl();
				panamaContainerVOs = (List<PanamaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getPanamaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				if (panamaContainerVOs.size() > 0) {
					panamaContainerVO = panamaContainerVOs.get(0);
					PanamaVesselVO panamaVesselVO = panamaContainerVO
							.getPanamaVesselVO();
					eventResponse.setETCData("slan_cd",
							panamaVesselVO.getSlanCd());
					eventResponse.setETCData("pod_cd",
							panamaVesselVO.getPodCd());
					eventResponse.setETCData("pol_cd",
							panamaVesselVO.getPolCd());
					eventResponse.setETCData("vps_eta_dt",
							panamaVesselVO.getVpsEtaDt());
					eventResponse.setETCData("shp_id_no",
							panamaVesselVO.getShpIdNo());
					eventResponse.setETCData("vst_no",
							panamaVesselVO.getVstNo());
					eventResponse.setETCData("mvmt_seq",
							panamaVesselVO.getMvmtSeq());
					eventResponse.setETCData("pnm_org_cd",
							panamaVesselVO.getPnmOrgCd());
					eventResponse.setETCData("pnm_vsl_opr_cd",
							panamaVesselVO.getPnmVslOprCd());
					eventResponse.setETCData("pnm_dest_cd",
							panamaVesselVO.getPnmDestCd());
					eventResponse.setETCData("edi_snd_dt",
							panamaVesselVO.getEdiSndDt());
					eventResponse.setETCData("edi_snd_seq",
							panamaVesselVO.getEdiSndSeq());
					List<PanamaManifestListGeneralCargoDetailVO> panamaManifestListGeneralCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListGeneralCargoDetailVOs();
					eventResponse
							.setRsVoList(panamaManifestListGeneralCargoDetailVOs);
					List<PanamaManifestListEmptyCargoDetailVO> panamaManifestListEmptyCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListEmptyCargoDetailVOs();
					eventResponse
							.setRsVoList(panamaManifestListEmptyCargoDetailVOs);
					List<PanamaManifestListHazardousCargoDetailVO> panamaManifestListHazardousCargoDetailVOs = panamaContainerVO
							.getPanamaManifestListHazardCargoDetailVOs();
					eventResponse
							.setRsVoList(panamaManifestListHazardousCargoDetailVOs);
				} else {
					eventResponse.setETCData("slan_cd", "");
					eventResponse.setETCData("pod_cd", "");
					eventResponse.setETCData("pol_cd", "");
					eventResponse.setETCData("vps_eta_dt", "");
					eventResponse.setETCData("shp_id_no", "");
					eventResponse.setETCData("vst_no", "");
					eventResponse.setETCData("mvmt_seq", "");
					eventResponse.setETCData("pnm_org_cd", "");
					eventResponse.setETCData("pnm_vsl_opr_cd", "");
					eventResponse.setETCData("pnm_dest_cd", "");
					eventResponse.setETCData("edi_snd_dt", "");
					eventResponse.setETCData("edi_snd_seq", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
				command = new BrcsManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				list = command.searchManifestList(event
						.getBrManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
				EsmBkg0490Event event = (EsmBkg0490Event) e;
				List<SriLankaContainerVO> sriLankaContainerVOs = null;
				SriLankaContainerVO sriLankaContainerVO = null;
				command = new SriLankaManifestListDownloadBCImpl();
				sriLankaContainerVOs = (List<SriLankaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getSriLankaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("sr_sts_cd", "");
				eventResponse.setETCData("rgst_dt", "");
				eventResponse.setETCData("rjct_dt", "");
				eventResponse.setETCData("vsl_auth_no", "");
				eventResponse.setETCData("sr_sts_desc", "");
				eventResponse.setETCData("sr_cmt_desc", "");
				eventResponse.setETCData("decl_bl_qty", "");
				eventResponse.setETCData("total_bl", "");
				eventResponse.setETCData("total_cntr", "");
				if (sriLankaContainerVOs.size() > 0) {
					sriLankaContainerVO = sriLankaContainerVOs.get(0);
					SriLankaSearchManifestVpsVO sriLankaSearchManifestVpsVO = sriLankaContainerVO
							.getSriLankaSearchManifestVpsVO();
					if (sriLankaSearchManifestVpsVO != null)
						eventResponse.setETCData("eta_dt",
								sriLankaSearchManifestVpsVO.getVpsEtsDt());
					else
						eventResponse.setETCData("eta_dt", "");
					SriLankaSearchEtdDtVO sriLankaSearchEtdDtVO = sriLankaContainerVO
							.getSriLankaSearchEtdDtVO();
					if (sriLankaSearchEtdDtVO != null)
						eventResponse.setETCData("etd_dt",
								sriLankaSearchEtdDtVO.getVpsEtdDt());
					else
						eventResponse.setETCData("etd_dt", "");
					SriLankaSearchVsselNameVO sriLankaSearchVsselNameVO = sriLankaContainerVO
							.getSriLankaSearchVsselNameVO();
					
					if (sriLankaSearchVsselNameVO != null){
						eventResponse.setETCData("vsl_nm", sriLankaSearchVsselNameVO.getVslEngNm());
						eventResponse.setETCData("crr_nm", sriLankaSearchVsselNameVO.getCrrNm());
						eventResponse.setETCData("lloyd_cd", sriLankaSearchVsselNameVO.getLloydNo());
					}else
						eventResponse.setETCData("vsl_nm", "");
					SriLankaSearchRegistNoVO sriLankaSearchRegistNoVO = sriLankaContainerVO
							.getSriLankaSearchRegistNoVO();
					if (sriLankaSearchRegistNoVO != null) {
						eventResponse.setETCData("auth_no",
								sriLankaSearchRegistNoVO.getVslAuthNo());
						// eventResponse.setETCData("reg_no",sriLankaSearchRegistNoVO.getVslRgstNo());
					} else {
						eventResponse.setETCData("auth_no", "");
						// eventResponse.setETCData("reg_no","");
					}
					SriLankaSearchResponseVO sriLankaSearchResponseVO = sriLankaContainerVO
							.getSriLankaSearchResponseVO();
					if (sriLankaSearchResponseVO != null) {
						eventResponse.setETCData("sr_sts_cd",
								sriLankaSearchResponseVO.getSrStsCd());
						eventResponse.setETCData("rgst_dt",
								sriLankaSearchResponseVO.getRgstDt());
						eventResponse.setETCData("rjct_dt",
								sriLankaSearchResponseVO.getRjctDt());
						eventResponse.setETCData("vsl_auth_no",
								sriLankaSearchResponseVO.getVslAuthNo());
						eventResponse.setETCData("sr_sts_desc",
								sriLankaSearchResponseVO.getSrStsDesc());
						eventResponse.setETCData("sr_cmt_desc",
								sriLankaSearchResponseVO.getSrCmtDesc());
						eventResponse.setETCData("decl_bl_qty",
								sriLankaSearchResponseVO.getDeclBlQty());
					} else {
						eventResponse.setETCData("sr_sts_cd", "");
						eventResponse.setETCData("rgst_dt", "");
						eventResponse.setETCData("rjct_dt", "");
						eventResponse.setETCData("vsl_auth_no", "");
						eventResponse.setETCData("sr_sts_desc", "");
						eventResponse.setETCData("sr_cmt_desc", "");
						eventResponse.setETCData("decl_bl_qty", "");
					}
					List<SriLankaSearchBlListVO> sriLankaSearchBlListVOs = sriLankaContainerVO
							.getSriLankaSearchBlListVOs();
					List<SriLankaSearchCntrListTempVO> sriLankaSearchCntrListVOs = sriLankaContainerVO
							.getSriLankaSearchCntrListTempVOs();
					if (sriLankaSearchBlListVOs.size() > 0) {
						SriLankaSearchBlListVO sriLankaSearchBlListVO = (SriLankaSearchBlListVO) sriLankaSearchBlListVOs
								.get(0);
						eventResponse.setETCData("total_bl",
								sriLankaSearchBlListVO.getBlTotal());
					}
					if (sriLankaSearchCntrListVOs.size() > 0) {
						SriLankaSearchCntrListTempVO sriLankaSearchCntrListTempVO = (SriLankaSearchCntrListTempVO) sriLankaSearchCntrListVOs
								.get(0);
						eventResponse.setETCData("total_cntr",
								sriLankaSearchCntrListTempVO.getBlTotal());
					}
					eventResponse.setRsVoList(sriLankaSearchBlListVOs);
					eventResponse.setRsVoList(sriLankaSearchCntrListVOs);
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("total_cntr", "");
					eventResponse.setETCData("total_bl", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setETCData("vsl_nm", "");
					eventResponse.setETCData("auth_no", "");
					eventResponse.setETCData("reg_no", "");
					eventResponse.setETCData("total_bl", "");
					eventResponse.setETCData("sr_sts_cd", "");
					eventResponse.setETCData("rgst_dt", "");
					eventResponse.setETCData("rjct_dt", "");
					eventResponse.setETCData("vsl_auth_no", "");
					eventResponse.setETCData("sr_sts_desc", "");
					eventResponse.setETCData("sr_cmt_desc", "");
					eventResponse.setETCData("decl_bl_qty", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0351Event")) {
				EsmBkg0351Event event = (EsmBkg0351Event) e;
				List<RocsContainerVO> rocsContainerVOs = null;
				RocsContainerVO rocsContainerVO = null;
				command = new RocsManifestListDownloadBCImpl();
				rocsContainerVOs = (List<RocsContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getRocsManifestListCondVO()));
				if (rocsContainerVOs.size() > 0) {
					rocsContainerVO = rocsContainerVOs.get(0);
					List<RocsSearchInboundBlListVO> rocsSearchInboundBlListVOs = rocsContainerVO
							.getRocsSearchInboundBlListVOs();
					eventResponse.setRsVoList(rocsSearchInboundBlListVOs);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0282Event")) {
				EsmBkg0282Event event = (EsmBkg0282Event) e;
				List<HongKongContainerVO> hongKongContainerVOs = null;
				HongKongContainerVO hongKongContainerVO = null;
				command = new HongKongManifestLIstDownloadBCImpl();
				hongKongContainerVOs = (List<HongKongContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getHongKongManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("eta_dt", "");
				eventResponse.setETCData("total_bl", "");
				eventResponse.setETCData("etd_dt", "");
				eventResponse.setETCData("vsl_eng_nm", "");
				eventResponse.setETCData("call_sign_no", "");
				if (hongKongContainerVOs.size() > 0) {
					hongKongContainerVO = hongKongContainerVOs.get(0);
					List<HongKongSearchVesselVO> hongKongSearchVesselVOs = hongKongContainerVO
							.getHongKongSearchVesselVOs();
					HongKongSearchVesselVO hongKongSearchVesselVO = null;
					if (hongKongSearchVesselVOs.size() > 0) {
						hongKongSearchVesselVO = hongKongSearchVesselVOs.get(0);
						if (!event.getPolCd().equalsIgnoreCase(""))
							eventResponse.setETCData("etd_dt",
									hongKongSearchVesselVO.getEtaDt());
						else
							eventResponse.setETCData("eta_dt",
									hongKongSearchVesselVO.getEtaDt());
						eventResponse.setETCData("vsl_eng_nm",
								hongKongSearchVesselVO.getVslEngNm());
						eventResponse.setETCData("call_sign_no",
								hongKongSearchVesselVO.getCallSgnNo());
						// eventResponse.setUserMessage(new
						// ErrorHandler("BKG00216").getUserMessage());
					} else {
						eventResponse.setETCData("eta_dt", "");
						eventResponse.setETCData("vsl_eng_nm", "");
						eventResponse.setETCData("call_sign_no", "");
						eventResponse.setETCData("etd_dt", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					List<HongKongSearchManifestListVO> hongKongSearchManifestListVOs = hongKongContainerVO
							.getHongKongSearchManifestListVOs();
					if (hongKongSearchManifestListVOs.size() > 0) {
						HongKongSearchManifestListVO hongKongSearchManifestListVO = null;
						hongKongSearchManifestListVO = hongKongSearchManifestListVOs
								.get(0);
						eventResponse.setETCData("total_bl",
								hongKongSearchManifestListVO.getTotalBl());
						// eventResponse.setUserMessage(new
						// ErrorHandler("BKG00216").getUserMessage());
					} else {
						eventResponse.setETCData("total_bl", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(hongKongSearchManifestListVOs);
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
				EsmBkg0310Event event = (EsmBkg0310Event) e;
				List<IndonesiaContainerVO> indonesiaContainerVOs = null;
				IndonesiaContainerVO indonesiaContainerVO = null;
				command = new IndonesiaManifestListDownloadBCImpl();
				indonesiaContainerVOs = (List<IndonesiaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getIndonesiaManifestListCondVO()));
				if (indonesiaContainerVOs.size() > 0) {
					indonesiaContainerVO = indonesiaContainerVOs.get(0);
					List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs = indonesiaContainerVO
							.getIndonesiaSearchManifestListVOs();
					if (indonesiaSearchManifestListVOs.size() <= 0) {
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(indonesiaSearchManifestListVOs);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				List<IndonesiaContainerVO> indonesiaContainerVOs = null;
				IndonesiaContainerVO indonesiaContainerVO = null;
				command = new IndonesiaManifestListDownloadBCImpl();
				indonesiaContainerVOs = (List<IndonesiaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getIndonesiaManifestListCondVO()));
				if (indonesiaContainerVOs.size() > 0) {
					indonesiaContainerVO = indonesiaContainerVOs.get(0);
					List<IndonesiaSearchManifestListVO> indonesiaSearchManifestListVOs = indonesiaContainerVO
							.getIndonesiaSearchManifestListVOs();
					if (indonesiaSearchManifestListVOs.size() <= 0) {
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(indonesiaSearchManifestListVOs);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				List<RocsContainerVO> rocsContainerVOs = null;
				RocsContainerVO rocsContainerVO = null;
				command = new RocsManifestListDownloadBCImpl();
				rocsContainerVOs = (List<RocsContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getRocsManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("eta_dt", "");
				eventResponse.setETCData("etd_dt", "");
				eventResponse.setETCData("eng_nm", "");
				eventResponse.setETCData("vsl_cd", "");
				eventResponse.setETCData("skd_voy_no", "");
				eventResponse.setETCData("skd_dir_cd", "");
				if (rocsContainerVOs.size() > 0) {
					rocsContainerVO = rocsContainerVOs.get(0);
					RocsSearchVslInfoVO rocsSearchVslInfoVO = rocsContainerVO
							.getRocsSearchVslInfoVO();
					eventResponse.setETCData("eta_dt",
							rocsSearchVslInfoVO.getVpsEtaDt());
					eventResponse.setETCData("etd_dt",
							rocsSearchVslInfoVO.getVpsEtdDt());
					eventResponse.setETCData("eng_nm",
							rocsSearchVslInfoVO.getVslEngNm());
					eventResponse.setETCData("vsl_cd",
							rocsSearchVslInfoVO.getVslCd());
					eventResponse.setETCData("skd_voy_no",
							rocsSearchVslInfoVO.getSkdVoyNo());
					eventResponse.setETCData("skd_dir_cd",
							rocsSearchVslInfoVO.getSkdDirCd());
					eventResponse.setETCData("frm_crn_number",
							rocsSearchVslInfoVO.getVslCallRefNo());
					// Add. 2015.04.20
					eventResponse.setETCData("frm_vvd_number",
							rocsSearchVslInfoVO.getVvdNumber());
					eventResponse.setETCData("pod_clpt_ind_seq",
							rocsSearchVslInfoVO.getPodClptIndSeq());
					
					List<RocsSearchPortListVO> rocsSearchPortListVOs = rocsContainerVO
							.getRocsSearchPortListVOs();
					eventResponse.setRsVoList(rocsSearchPortListVOs);
					List<RocsSearchBlCountVO> rocsSearchBlCountVOs = rocsContainerVO
							.getRocsSearchBlCountVOs();
					eventResponse.setRsVoList(rocsSearchBlCountVOs);
					List<RocsManifestConfirmationVO> rocsManifestConfirmationVOs = rocsContainerVO
							.getRocsManifestConfirmationVOs();
					eventResponse.setRsVoList(rocsManifestConfirmationVOs);
				} else {
					eventResponse.setETCData("eta_dt", "");
					eventResponse.setETCData("etd_dt", "");
					eventResponse.setETCData("eng_nm", "");
					eventResponse.setETCData("vsl_cd", "");
					eventResponse.setETCData("skd_voy_no", "");
					eventResponse.setETCData("skd_dir_cd", "");
					//eventResponse.setETCData("frm_crn_number", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0234Event")) {
				EsmBkg0234Event event = (EsmBkg0234Event) e;
				List<ManilaContainerVO> manilaContainerVOs = null;
				ManilaContainerVO manilaContainerVO = null;
				command = new ManilaManifestListDownloadBCImpl();
				manilaContainerVOs = (List<ManilaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getManilaManifestListCondVO()));
				Map<String, String> etcData = new HashMap<String, String>();
				if (manilaContainerVOs.size() > 0) {
					manilaContainerVO = manilaContainerVOs.get(0);
					List<ManilaSearchCheckPodVO> manilaSearchCheckPodVOs = manilaContainerVO
							.getManilaSearchCheckPodVOs();
					List<ManilaSearchCheckPolVO> manilaSearchCheckPolVOs = manilaContainerVO
							.getManilaSearchCheckPolVOs();
					List<ManilaSearchCheckVvdVO> manilaSearchCheckVvdVOs = manilaContainerVO
							.getManilaSearchCheckVvdVOs();
					if (manilaSearchCheckVvdVOs.size() == 0) {
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00163").getUserMessage());
						return eventResponse;
					} else {
						if (manilaSearchCheckPodVOs != null
								&& manilaSearchCheckPodVOs.size() == 0) {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00165").getUserMessage());
							return eventResponse;
						}
						if (manilaSearchCheckPolVOs != null
								&& manilaSearchCheckPolVOs.size() == 0) {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00164").getUserMessage());
							return eventResponse;
						}
					}
					if (manilaContainerVO.getManilasearchVvdDtlVOs() != null) {
						List<ManilaSearchVvdDtlVO> manilasearchVvdDtlVOs = manilaContainerVO
								.getManilasearchVvdDtlVOs();
						eventResponse.setRsVoList(manilasearchVvdDtlVOs);
					}
					if (manilaContainerVO.getManilaSearchBlInfoVOs() != null) {
						List<ManilaSearchBlInfoVO> manilaSearchBlInfoVOs = manilaContainerVO
								.getManilaSearchBlInfoVOs();
						eventResponse.setRsVoList(manilaSearchBlInfoVOs);
					}
					if (manilaContainerVO.getManilaSearchCntrInfoVOs() != null) {
						List<ManilaSearchCntrInfoVO> manilaSearchCntrInfoVOs = manilaContainerVO
								.getManilaSearchCntrInfoVOs();
						eventResponse.setRsVoList(manilaSearchCntrInfoVOs);
					}
					if (manilaContainerVO.getManilaSearchPkgDescTempVOs() != null) {
						List<ManilaSearchPkgDescTempVO> manilaSearchPkgDescTempVOs = manilaContainerVO
								.getManilaSearchPkgDescTempVOs();
						eventResponse.setRsVoList(manilaSearchPkgDescTempVOs);
					}
					if (manilaContainerVO.getManilaSearchPkgMarkTempVOs() != null) {
						List<ManilaSearchPkgMarkTempVO> manilaSearchPkgMarkTempVOs = manilaContainerVO
								.getManilaSearchPkgMarkTempVOs();
						eventResponse.setRsVoList(manilaSearchPkgMarkTempVOs);
					}
					if (manilaContainerVO.getManilaSearchBolVOS() != null) {
						List<ManilaSearchBolVO> manilaSearchBolVOS = manilaContainerVO.getManilaSearchBolVOS();
						eventResponse.setRsVoList(manilaSearchBolVOS);
					}
					if (manilaContainerVO.getManilaSearchGenVOS() != null) {
						List<ManilaSearchGenVO> manilaSearchGenVOS = manilaContainerVO.getManilaSearchGenVOS();
						eventResponse.setRsVoList(manilaSearchGenVOS);
					}
					if (manilaContainerVO.getManilaSearchCtnVOS() != null) {
						List<ManilaSearchCtnVO> manilaSearchCtnVOS = manilaContainerVO.getManilaSearchCtnVOS();
						eventResponse.setRsVoList(manilaSearchCtnVOS);
					}
				} else {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
				log.info("=== EsmBkg0210Event Start ===");
				EsmBkg0210Event event = (EsmBkg0210Event) e;
				// Canada와 US 동일한 화면 사용
				if (event.getCustoms().endsWith("CA")) {
					log.info("=== EsmBkg0210Event CA Start ===");
					command = new CndManifestListDownloadBCImpl();
					eventResponse.setRsVoList(command.searchManifestList(event
							.getManifestListCondVO()));
					log.info("=== EsmBkg0210Event CA End ===");
				} else {
					command = new UsaManifestListDownloadBCImpl();
					List<ManifestListDetailVO> list = command
							.searchManifestList(event.getManifestListCondVO());
					UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list
							.get(0);
					if (containerVO.getUsaManifestListDownloadVO() != null) {
						List<UsaDownloadSummaryVO> usaManifestListDownloadVOs = containerVO
								.getUsaManifestListDownloadVO();

						if (usaManifestListDownloadVOs.size() > 0) {
							eventResponse
									.setRsVoList(usaManifestListDownloadVOs);
						} else {
							// 결과값이 없을 경우 메세지 리턴
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00889").getUserMessage());
						}
					}
					if (containerVO.getUsaManifestListDownloadDetailVO() != null) {
						List<UsaManifestListDetailVO> usaManifestListDownloadDetailVOs = containerVO
								.getUsaManifestListDownloadDetailVO();
						eventResponse
								.setRsVoList(usaManifestListDownloadDetailVOs);
					}
					if (containerVO.getUsaManifestListDownloadCntrVO() != null) {
						List<UsaManifestListDownloadCntrVO> usaManifestListDownloadCntrVOs = containerVO
								.getUsaManifestListDownloadCntrVO();
						eventResponse
								.setRsVoList(usaManifestListDownloadCntrVOs);
					}
					if (containerVO.getUsaBkgCmVO() != null) {
						List<UsaBkgCmVO> usaBkgCmVOs = containerVO
								.getUsaBkgCmVO();
						eventResponse.setRsVoList(usaBkgCmVOs);
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				CustomsTransmissionBC command2 = new CndCustomsTransmissionBCImpl();
				eventResponse.setRsVoList(command2.searchManifestList(event.getCstmsManifestCondVO()));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0006Event")) {
				EsmBkg0006Event event = (EsmBkg0006Event) e;
				CustomsTransmissionBC command2 = new CndCustomsTransmissionBCImpl();
				eventResponse.setRsVoList(command2.searchExportManifestList(event.getCstmsManifestCondVO()));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsMfListCondVO ancsCondVO = (AncsCstmsMfListCondVO) event
						.getAncsCstmsMfListCondVO();
				List<ManifestListDetailVO> manifestListDetailVO = command
						.searchManifestList(ancsCondVO);
				eventResponse.setRsVoList(manifestListDetailVO);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) {
				EsmBkg0296Event event = (EsmBkg0296Event) e;
				command = new IndiaManifestListDownloadBCImpl();
				IndiaManifestListDetailVO indiaManifestListDetailVO = null;
				List<IndiaManifestListDetailVO> indiaManifestVslInfoVOList = null;
				List<IndiaManifestListDetailVO> indiaManifestListDetailVOList = null;
				List<IndiaManifestListDetailVO> indiaCntrMfDetailVOList = null;
				IndiaManifestListCondVO indiaManifestListCondVO = (IndiaManifestListCondVO) event
						.getIndiaManifestListCondVO();
				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList(indiaManifestListCondVO);
				IndiaContainerVO containerVO = null;
				if (manifestListDetailVOs != null
						&& manifestListDetailVOs.size() > 0) {
					containerVO = (IndiaContainerVO) manifestListDetailVOs
							.get(0);
					// 기본 배정보
					indiaManifestVslInfoVOList = containerVO
							.getIndiaManifestListVslInfoVOList();
					// B/L 정보
					indiaManifestListDetailVOList = containerVO
							.getIndiaManifestListDetailVOList();
					// Container 정보
					indiaCntrMfDetailVOList = containerVO
							.getIndiaCntrMfDetailVOList();
					if (indiaManifestVslInfoVOList != null
							&& indiaManifestVslInfoVOList.size() > 0) {
						indiaManifestListDetailVO = indiaManifestVslInfoVOList
								.get(0);
						eventResponse.setETCData("masterResult", "success");
						eventResponse.setETCData("igmNo",
								indiaManifestListDetailVO.getIgmNo());
						eventResponse.setETCData("igmDate",
								indiaManifestListDetailVO.getIgmDate());
						eventResponse.setETCData("vslNm",
								indiaManifestListDetailVO.getVslNm());
						eventResponse.setETCData("etaDt",
								indiaManifestListDetailVO.getEtaDt());
					} else {
						eventResponse.setETCData("masterResult", "fail");
					}
				}
				eventResponse.setRsVoList(indiaManifestListDetailVOList);
				eventResponse.setRsVoList(indiaCntrMfDetailVOList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command
						.searchMiManifestList(event.getManifestListCondVO());
				UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list
						.get(0);
				String searchMtd = ((UsaManifestSearchCondVO) event
						.getManifestListCondVO()).getSearchMtd();
				// 요약조회일 경우,
				if ("Summary".equals(searchMtd)
						&& containerVO.getUsaManifestSummaryVO() != null) {
					eventResponse.setRsVoList(containerVO
							.getUsaManifestSummaryVO());
				}
				// 상세조회일 경우,
				if (!"Summary".equals(searchMtd)
						&& containerVO.getUsaManifestSearchDetailVO() != null) {
					eventResponse.setRsVoList(containerVO
							.getUsaManifestSearchDetailVO());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
				EsmBkg0615Event event = (EsmBkg0615Event) e;
				command = new UsaManifestListDownloadBCImpl();
				
				List<ManifestListDetailVO> list = command.searchMiManifestListOB(event.getManifestListCondVO());
				UsaManifestListContainerVO containerVO = (UsaManifestListContainerVO) list.get(0);
				String searchMtd = ((UsaManifestSearchCondVO) event.getManifestListCondVO()).getSearchMtd();
				// 요약조회일 경우,
				if ("Summary".equals(searchMtd)	&& containerVO.getUsaManifestSummaryVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSummaryVO());
				}
				// 상세조회일 경우,
				if (!"Summary".equals(searchMtd) && containerVO.getUsaManifestSearchDetailVO() != null) {
					eventResponse.setRsVoList(containerVO.getUsaManifestSearchDetailVO());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0543Event")) {
				EsmBkg0543Event event = (EsmBkg0543Event) e;
				CustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2
						.searchManifestListForEdi((ManifestListCondForEdiVO) event
								.getUsaManifestListCondForEdiVO());
				UsaManifestListCondForEdiVO retVO = containerVo
						.getUsaManifestListCondForEdiVO();
				List<UsaManifestListCondForEdiVO> list = new ArrayList<UsaManifestListCondForEdiVO>();
				list.add(retVO);
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0514Event")) {
				EsmBkg0514Event event = (EsmBkg0514Event) e;
				CustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2
						.searchManifestListForEdi((ManifestListCondForEdiVO) event
								.getUsaManifestListCondForEdiVO());
				UsaManifestListCondForEdiVO retVO = containerVo
						.getUsaManifestListCondForEdiVO();
				List<UsaManifestListCondForEdiVO> list = new ArrayList<UsaManifestListCondForEdiVO>();
				list.add(retVO);
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
				EsmBkg0233Event event = (EsmBkg0233Event) e;
				CustomsTransmissionBC command2 = new UsaCustomsTransmissionBCImpl();
				ManifestListForEdiVO containerVo = command2
						.searchManifestListForEdi((ManifestListCondForEdiVO) event
								.getUsaManifestListCondForEdiVO());
				List<UsaEDADetailVO> list = containerVo.getUsaEDADetailVOs();
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
				EsmBkg0444Event event = (EsmBkg0444Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<ManifestListVO> list = command.searchManifestList(event
						.getRocsVesselArrivalCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
				EsmBkg0329Event event = (EsmBkg0329Event) e;
				command = new KorManifestListDownloadBCImpl();

				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					Map<String, String> etcData = new HashMap<String, String>();
					KorMrnNoVO fromClient = event.getMrnNoVO();
					KorContainerVO container = null;
					container = (KorContainerVO) command
							.searchManifestInfo((ManifestListCondVO) fromClient);
					if (container != null) {
						eventResponse.setRsVoList(container
								.getKorManifestInfoVOs());
						eventResponse.setRsVoList(container
								.getKorBkgCntrQtyInfoVOs());
						eventResponse.setETCData("mrn_nbr",
								fromClient.getMrnNo());
						log.debug("*&&&&&&&&&&&&&&&&&&&&&&&"
								+ fromClient.getMrnNo());
						eventResponse.setETCData("mrn_chk_no",
								fromClient.getMrnChkNo());
						eventResponse.setETCData("in_bound",
								fromClient.getInBound());
						eventResponse.setETCData("in_pol",
								fromClient.getInPol());
						eventResponse.setETCData("in_vvd",
								fromClient.getInVvd());
						eventResponse.setETCData("in_pod",
								fromClient.getInPod());
						eventResponse.setETCData("in_hn", fromClient.getInHn());
						eventResponse.setETCData("sel_type",
								fromClient.getSelType());
						eventResponse.setETCData("bl_dl", fromClient.getBlDl());
						eventResponse.setETCData("all_err",
								fromClient.getAllErr());
						eventResponse.setETCData("in_blno",
								fromClient.getBlNo());
						eventResponse.setETCData("bl_type",
								fromClient.getBlType());
						eventResponse.setETCData("el_type",
								fromClient.getElType());
						eventResponse.setETCData("correction",
								fromClient.getCorrection());
						eventResponse.setETCData("cntr_local",
								fromClient.getCntrLocal());
						eventResponse.setETCData("cntr_ts",
								fromClient.getCntrTs());
						eventResponse.setETCData("cntr_empty",
								fromClient.getCntrEmpty());
						eventResponse.setETCData("cntr_total",
								fromClient.getCntrTotal());
						eventResponse.setETCData("bl_local",
								fromClient.getBlLocal());
						eventResponse.setETCData("bl_ts", fromClient.getBlTs());
						eventResponse.setETCData("bl_empty",
								fromClient.getBlEmpty());
						eventResponse.setETCData("bl_total",
								fromClient.getBlTotal());
						eventResponse.setETCData("eta_etd",
								fromClient.getEtaEtd());
						eventResponse.setETCData("etb_dt",
								fromClient.getEtbDt());

					} else {
						eventResponse.setETCData("mrn_nbr", " ");
						eventResponse.setETCData("mrn_chk_no", " ");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00689").getUserMessage());
					}
					eventResponse.setETCData(etcData);
				}

				if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					List<KorManifestCrsChkInfoVO> container = null;
					KorMrnNoVO fromClient = null;

					container = command.searchManifestCrsChkInfoKorList(event
							.getMrnNoVO());

					eventResponse.setRsVoList(container);

					fromClient = command
							.searchManifestCrsChkInfoSumKorList(event
									.getMrnNoVO());

					if (fromClient != null) {
						// eventResponse.setETCData("cntr_local",
						// fromClient.getCntrLocal() );
						// eventResponse.setETCData("cntr_ts",
						// fromClient.getCntrTs() );
						// eventResponse.setETCData("cntr_ts_empty",
						// fromClient.getCntrTsEmpty() );
						// eventResponse.setETCData("cntr_empty",
						// fromClient.getCntrEmpty() );
						// eventResponse.setETCData("cntr_total",
						// fromClient.getCntrTotal() );
						// eventResponse.setETCData("bl_local",
						// fromClient.getBlLocal() );
						// eventResponse.setETCData("bl_ts",
						// fromClient.getBlTs() );
						// eventResponse.setETCData("bl_ts_empty",
						// fromClient.getBlTsEmpty() );
						// eventResponse.setETCData("bl_empty",
						// fromClient.getBlEmpty() );
						// eventResponse.setETCData("bl_total",
						// fromClient.getBlTotal() );

						eventResponse.setETCData("mrn_nbr",
								fromClient.getMrnNo());
						eventResponse.setETCData("mrn_chk_no",
								fromClient.getMrnChkNo());

						eventResponse.setETCData("eta_etd",
								fromClient.getEtaEtd());
						eventResponse.setETCData("etb_dt",
								fromClient.getEtbDt());

					}
				}

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				List<UsaContainerVO> usaContainerVOs = null;
				UsaContainerVO usaContainerVO = null;
				InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				// Container별/BL별 조회를 수행.
				usaContainerVOs = (List<UsaContainerVO>) (Object) (command2
						.searchInbondManifestList((InbondListCondVO) event
								.getUsaInbondManifestListCondVO()));
				// 결과값이 있을 경우 eventResponse 셋업.
				if (usaContainerVOs.size() > 0) {
					usaContainerVO = usaContainerVOs.get(0);
					List<UsaInbondManifestListVO> usaInbondManifestDetailVOs = usaContainerVO
							.getUsaInbondManifestListVOs();
					// 리턴값을 셋팅.
					eventResponse.setRsVoList(usaInbondManifestDetailVOs);
				} else {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00123")
							.getUserMessage());
				}
				// eventResponse.setETCData(etcData);
				// 0408 화면 조회.
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				List<UsaContainerVO> usaContainerVOs = null;
				UsaContainerVO usaContainerVO = null;
				InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				// 요약조회, Inbond B/L, Local B/L 조회 수행.
				usaContainerVOs = (List<UsaContainerVO>) (Object) (command2
						.searchInbondManifestList((InbondListCondVO) event
								.getUsaInbondManifestListCondVO()));
				// 결과값이 있을 경우 eventResponse 셋업.
				if (usaContainerVOs.size() > 0) {
					usaContainerVO = usaContainerVOs.get(0);
					// 리턴값을 셋팅.
					// getUsaInbondManifestListVOs() 값이 존재하는 경우 : 0533 혹은 0408
					// 상단 시트
					// 조회 결과.
					if (usaContainerVO.getUsaInbondManifestListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO
								.getUsaInbondManifestListVOs());
					}
					// getInbondBlDetailListVOs() 값이 존재하는 경우 : 0408화면의 Inbond Bl
					// list.
					if (usaContainerVO.getInbondBlDetailListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO
								.getInbondBlDetailListVOs());
					}
					// getLocalBlDetailListVOs() 값이 존재하는 경우: 0408화면의 Local Bl
					// list.
					if (usaContainerVO.getLocalBlDetailListVOs() != null) {
						eventResponse.setRsVoList(usaContainerVO
								.getLocalBlDetailListVOs());
					}
				} else {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00123")
							.getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
				// EVENT 0337 처리
				EsmBkg0337Event event = (EsmBkg0337Event) e;
				KorMsnCreateVO korMsnCreateVO = event.getKorMrnInfoVO();
				korMsnCreateVO.setUserid(account.getUsr_id());
				command = new KorManifestListDownloadBCImpl();
				List<ManifestListDetailVO> manifestListDetailVOs = null;
				KorMSNCreateContainerVO container = null;
				Map<String, String> etcData = new HashMap<String, String>();
				// BC에 작업 요청
				manifestListDetailVOs = command
						.searchManifestList(korMsnCreateVO);
				// 결과 처리
				if (manifestListDetailVOs == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00689")
							.getUserMessage());
				} else {
					// 정상 처리 결과 저장
					container = (KorMSNCreateContainerVO) manifestListDetailVOs
							.get(0);
					// MRN 정보 ETC에 저장
					KorMrnInfoVO korMrnInfoVO = container.getKorMrnInfoVO();
					if (korMrnInfoVO == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00689").getUserMessage());
					} else {
						etcData.put("mrn_no", korMrnInfoVO.getMrnNo()
								+ korMrnInfoVO.getMrnChkNo());
						etcData.put("vvd", korMrnInfoVO.getVvd());
						etcData.put("port", korMrnInfoVO.getPortCd());
						etcData.put("snd_dt", korMrnInfoVO.getSndDt());
						etcData.put("rslt_dt", korMrnInfoVO.getRsltDt());
						etcData.put("rslt", korMrnInfoVO.getRslt());
						etcData.put("err_msg", korMrnInfoVO.getErrMsg());
						// LOCAL SHEET 용 데이터 존재하면 넘겨주기
						if (container.getLocalMsnInfoVOs() != null)
							eventResponse.setRsVoList(container
									.getLocalMsnInfoVOs());
						// TS SHEET 용 데이터 존재하면 넘겨주기
						if (container.getTsMsnInfoVOs() != null)
							eventResponse.setRsVoList(container
									.getTsMsnInfoVOs());
						// LOCAL B/L TYPE COUNT
						etcData.put("local_bl_tp_simple", container
								.getLocalBlTpCnt().getBlTpSimple());
						etcData.put("local_bl_tp_console", container
								.getLocalBlTpCnt().getBlTpConsole());
						etcData.put("local_bl_tp_empty", container
								.getLocalBlTpCnt().getBlTpEmpty());
						// TS B/L TYPE COUNT
						etcData.put("ts_bl_tp_simple", container.getTsBlTpCnt()
								.getBlTpSimple());
						etcData.put("ts_bl_tp_console", container
								.getTsBlTpCnt().getBlTpConsole());
						etcData.put("ts_bl_tp_empty", container.getTsBlTpCnt()
								.getBlTpEmpty());
						// EDI_SND_DI
						etcData.put("edi_snd_ind", korMrnInfoVO.getSendInd());
					}
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				// EVENT 0505 처리
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				// BC 생성
				command = new KorManifestListDownloadBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// 데이터 조회 처리
					KorBlInqInfoVO korBlInqInfoVO = event.getKorBlInqInfoVO();
					korBlInqInfoVO.setUserId(account.getUsr_id());
					// 조회용 파라메터 객체
					KorManifestEditListCondVO manifestEditListCondVO = new KorManifestEditListCondVO();
					// 결과 값
					KorManifestEditListVO korManifestEditListVO = null;
					// 파라메터 매핑
					manifestEditListCondVO.setTransTp(korBlInqInfoVO
							.getTransTp());
					manifestEditListCondVO.setBlNo(korBlInqInfoVO.getBlNo());
					manifestEditListCondVO.setCstmsDeclTpCd(korBlInqInfoVO
							.getCstmsDeclTpCd());
					manifestEditListCondVO
							.setPortCd(korBlInqInfoVO.getPortCd());
					manifestEditListCondVO
							.setUserId(korBlInqInfoVO.getUserId());
					Map<String, String> etcData = new HashMap<String, String>();
					// BC에 처리 의뢰
					korManifestEditListVO = (KorManifestEditListVO) command
							.searchManifestEditList(manifestEditListCondVO);
					// 결과 처리
					if (korManifestEditListVO == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						// 정상 처리 결과 저장
						// Container 리스트
						if (korManifestEditListVO.getKorCntrInqInfoVOs() != null)
							eventResponse
									.setRsVoList((List<KorCntrInqInfoVO>) Arrays
											.asList(korManifestEditListVO
													.getKorCntrInqInfoVOs()));
						// Export Licence 리스트
						if (korManifestEditListVO.getKorElnoInqInfoVOs() != null)
							eventResponse
									.setRsVoList((List<KorElnoInqInfoVO>) Arrays
											.asList(korManifestEditListVO
													.getKorElnoInqInfoVOs()));
						// BL / CUSTOMER INFO 정보는 ETC DATA에 담음
						if (korManifestEditListVO.getKorCustInqInfoVO() != null)
							etcData.putAll(korManifestEditListVO
									.getKorCustInqInfoVO().getColumnValues());
						if (korManifestEditListVO.getKorBlInqInfoVO() != null)
							etcData.putAll(korManifestEditListVO
									.getKorBlInqInfoVO().getColumnValues());
						if (manifestEditListCondVO != null)
							etcData.putAll(manifestEditListCondVO
									.getColumnValues());
						// Cargo Spec
						etcData.put("cargo_spec",
								korManifestEditListVO.getCargoSpec());
					}
					eventResponse.setETCData(etcData);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
					// 코드 조회 처리
					// BC에 작업 요청
					CodeVO[] codeVOs = command.searchCodeInfo(null);
					KorCodeVO codeVO = null;
					// 결과 처리
					if (codeVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						codeVO = (KorCodeVO) codeVOs[0];
						eventResponse.setRsVoList((List<KorPckInfoVO>) Arrays
								.asList(codeVO.getKorPckInfoVOs()));
						eventResponse.setRsVoList((List<KorCmdtVO>) Arrays
								.asList(codeVO.getKorCmdtVOs()));
						eventResponse.setRsVoList((List<KorCntrTpSzVO>) Arrays
								.asList(codeVO.getKorCntrTpSzVOs()));
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0030Event")) {
				// EVENT 0030 처리
				EsmBkg0030Event event = (EsmBkg0030Event) e;
				// BC 생성
				CustomsTransmissionBC command2 = new KorCustomsTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					// 조회용 파라메터 객체
					KorManifestListCondVO condVO = event
							.getKorManifestListCondVO();
					// BC에 처리 의뢰
					KorManifestListVO manifestListVO = (KorManifestListVO) command2
							.searchManifestListForTransmit(condVO);
					// 결과 처리
					eventResponse.setRsVoList((List<KorAmdBlInfoVO>) Arrays
							.asList(manifestListVO.getKorAmdBlInfoVOs()));
					eventResponse.setRsVoList((List<KorCntrNoKorVO>) Arrays
							.asList(manifestListVO.getKorCntrNoKorVOs()));
					eventResponse.setETCData("mrn_no",
							manifestListVO.getMrnNo());
					eventResponse.setETCData("mrn_chk_no",
							manifestListVO.getMrnChkNo());
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					// 조회용 파라메터 객체
					KorAmdFormVO[] condVOs = event.getKorAmdFormVOs();
					Map<String, String> etcData = new HashMap<String, String>();
					// 조회결과
					KorAmdFormVO[] amdFormVOs = null;
					// BC에 처리 의뢰
					amdFormVOs = (KorAmdFormVO[]) command2
							.searchAmdFormPrev(condVOs);
					// 결과 처리
					eventResponse.setRsVoList((List<KorAmdFormVO>) Arrays
							.asList(amdFormVOs));
					if (amdFormVOs != null && amdFormVOs.length > 0) {
						eventResponse.setETCData("mrn_no",
								amdFormVOs[0].getMrnNo());
						eventResponse.setETCData("bl_tp_cd",
								amdFormVOs[0].getBlTpCd());
						eventResponse.setETCData("ship_nm",
								amdFormVOs[0].getShipNm());
						eventResponse.setETCData("eta_dt",
								amdFormVOs[0].getEtaDt());
						eventResponse.setETCData("port_cd",
								amdFormVOs[0].getPortCd());
					}
					eventResponse.setETCData(etcData);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// BC에 작업 요청
				List<InbondManifestDetailVO> inbondManifestDetailVOs = command2
						.searchInbondClearanceList(event
								.getInbondManifestListCondVO());
				// 결과 처리
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					if (inbondManifestDetailVOs == null) {
						// 결과값이 없을 경우 메세지 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList(inbondManifestDetailVOs);
					}
				} else {
					if (inbondManifestDetailVOs == null) {
						eventResponse.setETCData("result", "nodata");
					} else {
						ClearanceTypeDetailVO detailVO = (ClearanceTypeDetailVO) inbondManifestDetailVOs
								.get(0);
						eventResponse.setETCData("result",
								detailVO.getCreOfcCd());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
				EsmBkg0216Event event = (EsmBkg0216Event) e;
				command = new ChinaManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command
						.searchManifestList(event.getManifestListCondVO());
				ChinaManifestListDetailVO detailVO = (ChinaManifestListDetailVO) list
						.get(0);
				list.remove(0);
				eventResponse.setRsVoList(list);
				eventResponse.setETCData(detailVO.getColumnValues());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
				EsmBkg0370Event event = (EsmBkg0370Event) e;
				CustomsTransmissionBC command2 = new MexCustomsTransmissionBCImpl();
				// BC에 작업 요청
				CargoManifestListResultForEdiVO vo = command2
						.searchCargoManifestForEdi(event.getCondVO());
				// 결과 처리
				if (vo == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					eventResponse.setRsVoList(vo
							.getMxManifestListByVvdDetailVOs());
					if (vo.getMxVslResultVO() != null) {
						eventResponse.setETCData("vsl_eng_nm", vo
								.getMxVslResultVO().getVslEngNm());
						eventResponse.setETCData("call_sign", vo
								.getMxVslResultVO().getCallSgnNo());
						eventResponse.setETCData("eta", vo.getMxVslResultVO()
								.getEtaDt());
						eventResponse.setETCData("etd", vo.getMxVslResultVO()
								.getEtdDt());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
				EsmBkg0484Event event = (EsmBkg0484Event) e;
				CustomsTransmissionBC command2 = new EurCustomsTransmissionBCImpl();
				// BC에 작업 요청
				List<SitProCargoManifesDetailVO> list = command2
						.searchSitProList(event
								.getSitProCargoManifestCondForEdiVO());

				// [CHM-201327127] [RFS Lane] Double calling logic 적용 요청 (2)
				// SItpro & Firm BKG
				SitProCargoManifestCondForEdiVO sitProCargoManifestCondForEdiVO = new SitProCargoManifestCondForEdiVO();
				sitProCargoManifestCondForEdiVO = event
						.getSitProCargoManifestCondForEdiVO();

				if (list.size() > 0) {
					SitProCargoManifesDetailVO ovo = (SitProCargoManifesDetailVO) list
							.get(0);

					if ("RFS".equals(ovo.getSlanCd())) {
						if ("".equals(sitProCargoManifestCondForEdiVO
								.getPolYdCd())
								|| "".equals(sitProCargoManifestCondForEdiVO
										.getPodYdCd())) {
							throw new EventException(
									(String) new ErrorHandler("BKG06148",
											new String[] { "for RFS" })
											.getMessage());
						}
					}
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1033Event")) {
				EsmBkg1033Event event = (EsmBkg1033Event) e;
				command = new BangladeshManifestListDownloadBCImpl();
				List<ManifestListDetailVO> list = command
						.searchManifestList(event.getManifestListCondVO());
				List<ManifestListDetailVO> tempList = new ArrayList<ManifestListDetailVO>();
				BangladeshManifestListCondVO manifestListCondVO = (BangladeshManifestListCondVO) event
						.getManifestListCondVO();
				if (manifestListCondVO.getIoFlag().equals("I")) {
					if (list.size() > 0) {
						BangladeshManifestListInboundVO inboundVO = (BangladeshManifestListInboundVO) list
								.get(0);
						eventResponse.setETCData(inboundVO.getColumnValues());
					}
					int idx = list.size() / 2;
					for (int i = 0; i < idx; i++) {
						tempList.add(list.get(i));
					}
					eventResponse.setRsVoList(tempList);
					tempList.clear();
					for (int i = idx; i < list.size(); i++) {
						tempList.add(list.get(i));
					}
					eventResponse.setRsVoList(tempList);
				} else if (manifestListCondVO.getIoFlag().equals("O")) {
					if (list.size() > 0) {
						BangladeshManifestListOutboundVO outboundVO = (BangladeshManifestListOutboundVO) list
								.get(0);
						eventResponse.setETCData(outboundVO.getColumnValues());
					}
					eventResponse.setRsVoList(list);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList(event.getManifestListCondVO());
				if (manifestListDetailVOs.size() > 0) {
					DubaiManifestListVO dubaiManifestListVO = (DubaiManifestListVO) manifestListDetailVOs
							.get(0);
					eventResponse.setRsVoList(dubaiManifestListVO
							.getDubaiBlManifestListVOs());
					eventResponse.setRsVoList(dubaiManifestListVO
							.getDubaiCntrManifestListVOs());
					// eventResponse.setRsVoList(dubaiManifestListVO.getDubaiVesselManifestListVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				list = command
						.searchManifestList(event.getManifestListCondVO());
				if (list.size() > 0) {
					Eu24ManifestListVO ovo = (Eu24ManifestListVO) list.get(0);
					eventResponse.setETCData("ttl_bl", ovo.getTtlBl());
					eventResponse.setETCData("ttl_err_bl", ovo.getTtlErrBl());
					eventResponse.setETCData("ttl_cntr", ovo.getTtlCntr());
					eventResponse.setETCData("div_pol", ovo.getPol());
					eventResponse.setETCData("div_pod", ovo.getPod());
					eventResponse.setETCData("vps_etd_dt", ovo.getVpsEtdDt());
					eventResponse.setETCData("eu_1st_port", ovo.getEu1stPort());
					eventResponse.setETCData("vps_eta_dt", ovo.getVpsEtaDt());
					eventResponse.setETCData("port_ofc_cd", ovo.getPortOfcCd());

					eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
					eventResponse.setETCData("unsent_bl_cnt",
							ovo.getUnsentBlCnt());
					eventResponse.setETCData("a_cnt", ovo.getACnt());
					eventResponse.setETCData("r_cnt", ovo.getRCnt());
					eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
					eventResponse.setETCData("nr_cnt", ovo.getNrCnt());
					eventResponse.setETCData("ata_yn", ovo.getAtaYn());
					eventResponse.setETCData("arn_yn", ovo.getArnYn());
					eventResponse.setETCData("dr_yn", ovo.getDrYn());
					eventResponse.setETCData("trsm_val", ovo.getTrsmVal());

					eventResponse.setETCData("ens_edi_svc_flg",
							ovo.getEnsEdiSvcFlg());

					eventResponse.setETCData("down_yn_first_of_multi_pofe",
							ovo.getDownYnFirstOfMultiPofe());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				List<ManifestListDetailVO> list = null;
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				list = command.searchManifestOBList(event
						.getManifestListCondVO());
				if (list.size() > 0) {
					Eu24ManifestOBListVO ovo = (Eu24ManifestOBListVO) list
							.get(0);
					eventResponse.setETCData("ttl_bl", ovo.getTtlBl());
					eventResponse.setETCData("ttl_err_bl", ovo.getTtlErrBl());
					eventResponse.setETCData("ttl_cntr", ovo.getTtlCntr());
					eventResponse.setETCData("div_pol", ovo.getPol());
					eventResponse.setETCData("vps_etd_dt", ovo.getVpsEtdDt());
					eventResponse.setETCData("eu_1st_port", ovo.getEu1stPort());
					eventResponse.setETCData("vps_eta_dt", ovo.getVpsEtaDt());
					eventResponse.setETCData("port_ofc_cd", ovo.getPortOfcCd());

					eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
					eventResponse.setETCData("unsent_bl_cnt",
							ovo.getUnsentBlCnt());
					eventResponse.setETCData("a_cnt", ovo.getACnt());
					eventResponse.setETCData("r_cnt", ovo.getRCnt());
					eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
					eventResponse.setETCData("h_cnt", ovo.getHCnt());
					eventResponse.setETCData("l_cnt", ovo.getLCnt());
					eventResponse.setETCData("nr_cnt", ovo.getNrCnt());
					eventResponse.setETCData("ata_yn", ovo.getAtaYn());
					eventResponse.setETCData("arn_yn", ovo.getArnYn());
					eventResponse.setETCData("dr_yn", ovo.getDrYn());

					// eventResponse.setETCData("ens_edi_svc_flg",ovo.getEnsEdiSvcFlg());
					eventResponse.setETCData("exs_edi_svc_flg",
							ovo.getExsEdiSvcFlg());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1141Event")) {
				EsmBkg1141Event event = (EsmBkg1141Event) e;
				command = new MalaysiaManifestDownloadBCImpl();

				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList(event.getManifestListCondVO());
				if (manifestListDetailVOs.size() > 0) {
					MalaysiaManifestListVO malaysiaManifestListVO = (MalaysiaManifestListVO) manifestListDetailVOs
							.get(0);
					eventResponse.setRsVoList(malaysiaManifestListVO
							.getMalaysiaManifestListBlInfoVOs());
					eventResponse.setRsVoList(malaysiaManifestListVO
							.getMalaysiaManifestListCntrInfoVOs());
					//@ VSL 필수 항목 체크 
					if(malaysiaManifestListVO.getMalaysiaManifestVslInfoVO() != null){
						eventResponse.setETCData("vsl_call_no",malaysiaManifestListVO.getMalaysiaManifestVslInfoVO().getVslCallNo());
						eventResponse.setETCData("vsl_id",malaysiaManifestListVO.getMalaysiaManifestVslInfoVO().getVslId());
					}else{
						eventResponse.setETCData("vsl_call_no","");
						eventResponse.setETCData("vsl_id","");
					}					
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1142Event")) {

				EsmBkg1142Event event = (EsmBkg1142Event) e;
				List<GhanaContainerVO> ghanaContainerVOs = null;
				GhanaContainerVO ghanaContainerVO = null;
				command = new GhanaManifestLIstDownloadBCImpl();
				ghanaContainerVOs = (List<GhanaContainerVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getGhanaSearchManifestListVO()));

				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("total_bl", "");
				eventResponse.setETCData("eta_dt", "");
				eventResponse.setETCData("etd_dt", "");
				eventResponse.setETCData("vsl_eng_nm", "");

				if (ghanaContainerVOs.size() > 0) {
					ghanaContainerVO = ghanaContainerVOs.get(0);
					List<GhanaSearchVesselVO> ghanaSearchVesselVOs = ghanaContainerVO
							.getGhanaSearchVesselVOs();
					GhanaSearchVesselVO ghanaSearchVesselVO = null;
					if (ghanaSearchVesselVOs.size() > 0) {
						ghanaSearchVesselVO = ghanaSearchVesselVOs.get(0);
						eventResponse.setETCData("etd_dt",
								(ghanaSearchVesselVO.getEtdDt() == null) ? ""
										: ghanaSearchVesselVO.getEtdDt());
						eventResponse.setETCData("eta_dt",
								(ghanaSearchVesselVO.getEtaDt() == null) ? ""
										: ghanaSearchVesselVO.getEtaDt());
						eventResponse.setETCData("vsl_eng_nm",
								ghanaSearchVesselVO.getVslEngNm());
					} else {
						eventResponse.setETCData("eta_dt", "");
						eventResponse.setETCData("vsl_eng_nm", "");
						eventResponse.setETCData("etd_dt", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}

					List<GhanaSearchManifestListVO> ghanaSearchManifestListVOs = ghanaContainerVO
							.getGhanaSearchManifestListVOs();
					if (ghanaSearchManifestListVOs.size() > 0) {
						GhanaSearchManifestListVO ghanaSearchManifestListVO = null;
						ghanaSearchManifestListVO = ghanaSearchManifestListVOs
								.get(0);
						eventResponse.setETCData("total_bl",
								ghanaSearchManifestListVO.getTotalBl());
					} else {
						eventResponse.setETCData("total_bl", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					eventResponse.setRsVoList(ghanaSearchManifestListVOs);
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1147Event")) {
				EsmBkg1147Event event = (EsmBkg1147Event) e;
				command = new ThailandManifestLIstDownloadBCImpl();

				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList((ManifestListCondVO) event
								.getThailandManifestListCondVO());

				if (manifestListDetailVOs.size() > 0) {
					ThailandManifestListVO thailandManifestListVO = (ThailandManifestListVO) manifestListDetailVOs
							.get(0);
					eventResponse.setRsVoList(thailandManifestListVO
							.getThailandManifestListBlInfoVOs());
					eventResponse.setRsVoList(thailandManifestListVO
							.getThailandManifestListCntrInfoVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1148Event")) {

				EsmBkg1148Event event = (EsmBkg1148Event) e;
				command = new PakistanManifestLIstDownloadBCImpl();

				List<PakistanManifestListVO> pakistanManifestListVOs = null;
				PakistanManifestListVO pakistanManifestListVO = null;
				pakistanManifestListVOs = (List<PakistanManifestListVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getPakistanManifestListCondVO()));

				Map<String, String> etcData = new HashMap<String, String>();
				eventResponse.setETCData("total_bl", "");
				eventResponse.setETCData("eta_dt", "");
				eventResponse.setETCData("etd_dt", "");
				eventResponse.setETCData("vsl_eng_nm", "");
				eventResponse.setETCData("call_sgn_no", "");

				if (pakistanManifestListVOs.size() > 0) {
					pakistanManifestListVO = pakistanManifestListVOs.get(0);

					List<PakistanVesselVO> pakistanVesselVOs = pakistanManifestListVO
							.getPakistanVesselVOs();
					PakistanVesselVO pakistanVesselVO = null;
					if (pakistanVesselVOs.size() > 0) {
						pakistanVesselVO = pakistanVesselVOs.get(0);
						eventResponse.setETCData("etd_dt",
								(pakistanVesselVO.getEtdDt() == null) ? ""
										: pakistanVesselVO.getEtdDt());
						eventResponse.setETCData("eta_dt",
								(pakistanVesselVO.getEtaDt() == null) ? ""
										: pakistanVesselVO.getEtaDt());
						eventResponse.setETCData("vsl_eng_nm",
								pakistanVesselVO.getVslEngNm());
						eventResponse.setETCData("call_sgn_no",
								pakistanVesselVO.getCallSgnNo());
					} else {
						eventResponse.setETCData("eta_dt", "");
						eventResponse.setETCData("vsl_eng_nm", "");
						eventResponse.setETCData("etd_dt", "");
						eventResponse.setETCData("call_sgn_no", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}

					List<PakistanBlInfoVO> pakistanBlInfoVOs = pakistanManifestListVO
							.getPakistanBlInfoVOs();
					if (pakistanBlInfoVOs.size() > 0) {
						PakistanBlInfoVO pakistanBlInfoVO = null;
						pakistanBlInfoVO = pakistanBlInfoVOs.get(0);
						eventResponse.setETCData("total_bl",
								pakistanBlInfoVO.getTotalBl());
					} else {
						eventResponse.setETCData("total_bl", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}

					List<PakistanCNTRInfoVO> pakistanCNTRInfoVOs = pakistanManifestListVO
							.getPakistanCNTRInfoVOs();
					List<PakistanBlInfoVO> pakistanChargeInfoVOs = pakistanManifestListVO
							.getPakistanChargeInfoVOs();

					eventResponse.setRsVoList(pakistanBlInfoVOs);
					eventResponse.setRsVoList(pakistanCNTRInfoVOs);
					eventResponse.setRsVoList(pakistanChargeInfoVOs);
				}
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
				EsmBkg1149Event event = (EsmBkg1149Event) e;
				command = new VietnamManifestDownloadBCImpl();

				// List<ManifestListDetailVO> manifestListDetailVOs =
				// command.searchManifestList(event.getManifestListCondVO());

				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList((ManifestListCondVO) event
								.getVietnamManifestListCondVO());

				if (manifestListDetailVOs.size() > 0) {

					VietnamManifestListVO vietnamManifestListVO = (VietnamManifestListVO) manifestListDetailVOs
							.get(0);
					eventResponse.setRsVoList(vietnamManifestListVO
							.getVietnamManifestListBlInfoVOs());
					// eventResponse.setRsVoList(malaysiaManifestListVO.getMalaysiaManifestListCntrInfoVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1155Event")) {
				EsmBkg1155Event event = (EsmBkg1155Event) e;
				command = new MyanmarManifestDownloadBCImpl();

				// List<ManifestListDetailVO> manifestListDetailVOs =
				// command.searchManifestList(event.getManifestListCondVO());

				List<ManifestListDetailVO> manifestListDetailVOs = command
						.searchManifestList((ManifestListCondVO) event
								.getMyanmarManifestListCondVO());

				if (manifestListDetailVOs.size() > 0) {

					MyanmarManifestListVO myanmarManifestListVO = (MyanmarManifestListVO) manifestListDetailVOs
							.get(0);
					eventResponse.setRsVoList(myanmarManifestListVO
							.getMyanmarManifestListBlInfoVOs());
					// eventResponse.setRsVoList(malaysiaManifestListVO.getMalaysiaManifestListCntrInfoVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {

				EsmBkg1162Event event = (EsmBkg1162Event) e;
				command = new DominicanManifestDownloadBCImpl();

				String key = command.startBackEndJob(account.getUsr_id(),
						event.getManifestListCondVO(), "ESM_BKG_1162");
				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {

				EsmBkg1163Event event = (EsmBkg1163Event) e;
				command = new RussiaManifestListDownloadBCImpl();

				List<ManifestListDetailVO> list = command
						.searchManifestList((ManifestListCondVO) event
								.getRussiaManifestListCondVO());

				if (list.size() > 0) {
					RussiaManifestListDetailVO russiaManifestListDetailVO = (RussiaManifestListDetailVO) list
							.get(0);

					eventResponse.setETCData("hd_vvd_cd",
							russiaManifestListDetailVO.getHdVvdCd());
					eventResponse.setETCData("hd_pol_pod",
							russiaManifestListDetailVO.getHdPolPod());
					eventResponse.setETCData("hd_pol_pod_cd",
							russiaManifestListDetailVO.getHdPolPodCd());
					eventResponse.setETCData("hd_eta_etd",
							russiaManifestListDetailVO.getHdEtaEtd());
					eventResponse.setETCData("hd_eta_etd_cd",
							russiaManifestListDetailVO.getHdEtaEtdCd());
					eventResponse.setETCData("hd_mode_type",
							russiaManifestListDetailVO.getHdModeType());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {

				EsmBkg1168Event event = (EsmBkg1168Event) e;
				command = new IsraelManifestDownloadBCImpl();
				List<IsraelManifestListVO> list = null;
				list = (List<IsraelManifestListVO>) (Object) (command
						.searchManifestList((ManifestListCondVO) event
								.getManifestListCondVO()));

				Map<String, String> etcData = new HashMap<String, String>();

				if (list.size() > 0) {
					IsraelManifestListVO ovo = (IsraelManifestListVO) list
							.get(0);
					List<IsraelManifestListBlInfoVO> israelManifestListBlInfoVOs = ovo
							.getIsraelManifestListBlInfoVOs();

					if (israelManifestListBlInfoVOs.size() > 0) {
						IsraelManifestListBlInfoVO israelManifestListBlInfoVO = null;
						israelManifestListBlInfoVO = israelManifestListBlInfoVOs
								.get(0);

						eventResponse.setETCData("vvd_nm",
								israelManifestListBlInfoVO.getVslFullname());
						eventResponse.setETCData("vvd_ld",
								israelManifestListBlInfoVO.getVslLloydcode());
						eventResponse.setETCData("vvd_call",
								israelManifestListBlInfoVO.getVslCallsign());
						eventResponse.setETCData("eta",
								israelManifestListBlInfoVO.getEta());
						eventResponse.setETCData("etd",
								israelManifestListBlInfoVO.getEtd());
						
						//Add. 2015.03.09 [CHM-201534282] ISRAEL CUSTOMS MANIFEST에 L/T조건 삽입
						// TS Type 별 BL count를 조회하기 위한 로직
						List<IsraelManifestListVO> blKntListVOs = null;
						blKntListVOs = (List<IsraelManifestListVO>) (Object) command
													.searchBlKnt((ManifestListCondVO) event
													.getManifestListCondVO());
						
						IsraelManifestListVO blKntVO = (IsraelManifestListVO)blKntListVOs.get(0);
						List<IsraelManifestListBlInfoVO> israelMaifestBlKntVOs = blKntVO.getIsraelManifestListBlInfoVOs();
						
						if (israelMaifestBlKntVOs.size() > 0) {
							IsraelManifestListBlInfoVO blKntListVO = null;
							
							blKntListVO = israelMaifestBlKntVOs.get(0);
							
							eventResponse.setETCData("ttl_bl",	blKntListVO.getTtlBl());
							eventResponse.setETCData("locl_bl",	blKntListVO.getLoclBl());
							eventResponse.setETCData("ts_bl",	blKntListVO.getTsBl());
						} else {
							eventResponse.setETCData("ttl_bl", "");
							eventResponse.setETCData("locl_bl", "");
							eventResponse.setETCData("ts_bl", "");
						}
						// End.
						
					} else {
						eventResponse.setETCData("vvd_nm", "");
						eventResponse.setETCData("vvd_ld", "");
						eventResponse.setETCData("vvd_call", "");
						eventResponse.setETCData("eta", "");
						eventResponse.setETCData("etd", "");
						eventResponse.setETCData("ttl_bl", "");
						eventResponse.setETCData("locl_bl", "");
						eventResponse.setETCData("ts_bl", "");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
					
					
					
					eventResponse.setRsVoList(israelManifestListBlInfoVOs);
				}
				eventResponse.setETCData(etcData);
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
	 * ESM_BKG_0462 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(Download 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked" })
	private EventResponse searchManifestListForDl(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0462Event event = (EsmBkg0462Event) e;
			List<JapanContainerVO> japanContainerVOs = null;
			JapanContainerVO japanContainerVO = null;
			command = new JapanManifestListDownloadBCImpl();
			japanContainerVOs = (List<JapanContainerVO>) (Object) (command
					.searchManifestListForDl((ManifestListCondVO) event
							.getJapanManifestListCondVO()));
			Map<String, String> etcData = new HashMap<String, String>();
			List<JapanManifestListVslPortSkdVO> japanManifestListVslPortSkdVOs = null;
			List<JapanManifestListBkgDetailVO> japanManifestListBkgDetailVOs = null;
			List<JapanManifestListCntrDetailVO> japanManifestListCntrDetailVOs = null;
			if (japanContainerVOs.size() > 0) {
				japanContainerVO = japanContainerVOs.get(0);
				japanManifestListVslPortSkdVOs = japanContainerVO
						.getJapanManifestListVslPortSkdVOs();
				eventResponse.setRsVoList(japanManifestListVslPortSkdVOs);
				japanManifestListBkgDetailVOs = japanContainerVO
						.getJapanManifestListBkgDetailVOs();
				eventResponse.setRsVoList(japanManifestListBkgDetailVOs);
				japanManifestListCntrDetailVOs = japanContainerVO
						.getJapanManifestListCntrDetailVOs();
				eventResponse.setRsVoList(japanManifestListCntrDetailVOs);
				List<JapanManifestListBkgDetail2VO> japanManifestListBkgDetail2VOs = japanContainerVO
						.getJapanManifestListBkgDetail2VOs();
				eventResponse.setRsVoList(japanManifestListBkgDetail2VOs);
				int totalSize = 0;
				for (int i = 0; i < japanManifestListBkgDetailVOs.size(); i++) {
					if (japanManifestListBkgDetailVOs.get(i).getSeq() != null) {
						totalSize++;
					}
				}
				eventResponse.setETCData("total_count", totalSize + "");
				// 2011.04.13 삭제
				// String wgtErrBkgNo =
				// command.searchWgtErrBkgNo((ManifestListCondVO)
				// event.getJapanManifestListCondVO());
				// eventResponse.setETCData("wgt_err_bkg_no", wgtErrBkgNo);

				if (japanManifestListVslPortSkdVOs.size() == 0
						&& japanManifestListBkgDetailVOs.size() == 0
						&& japanManifestListCntrDetailVOs.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestListForMfs(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0730Event event = (EsmBkg0730Event) e;
			List<JapanContainerVO> japanContainerVOs = null;
			JapanContainerVO japanContainerVO = null;
			command = new JapanManifestListDownloadBCImpl();
			japanContainerVOs = (List<JapanContainerVO>) (Object) (command
					.searchManifestListForMfs((ManifestListCondVO) event
							.getJapanManifestListCondVO()));
			Map<String, String> etcData = new HashMap<String, String>();
			japanContainerVO = japanContainerVOs.get(0);
			JapanManifestListEtcVO japanManifestListEtcVO = japanContainerVO
					.getJapanManifestListEtcVO();
			if (japanManifestListEtcVO.getCallSgnNo() != null
					&& !japanManifestListEtcVO.getCallSgnNo().equals("")) {
				eventResponse.setETCData("in_call_sgn_no",
						japanManifestListEtcVO.getCallSgnNo());
				eventResponse.setETCData("in_vps_eta_dt",
						japanManifestListEtcVO.getVpsEtaDt());
				eventResponse.setETCData("in_cy_opr_cd",
						japanManifestListEtcVO.getCyOprCd());
				eventResponse.setETCData("in_pod_split_cd",
						japanManifestListEtcVO.getPodSplitCd());
				eventResponse.setETCData("in_voyage_no",
						japanManifestListEtcVO.getJpTmlVslNo());

				List<JapanManifestListMfsDetailVO> japanManifestListMfsDetailVOs = japanContainerVO
						.getJapanManifestListMfsDetailVOs();
				if (japanManifestListMfsDetailVOs.size() != 0) {
					eventResponse.setRsVoList(japanManifestListMfsDetailVOs);
				} else {
					eventResponse.setETCData("in_call_sgn_no", "");
					eventResponse.setETCData("in_vps_eta_dt", "");
					eventResponse.setETCData("in_cy_opr_cd", "");
					eventResponse.setETCData("in_pod_split_cd", "");
					eventResponse.setETCData("in_voyage_no", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
			} else {
				eventResponse.setETCData("in_call_sgn_no", "");
				eventResponse.setETCData("in_vps_eta_dt", "");
				eventResponse.setETCData("in_cy_opr_cd", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1095 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(MFS 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAncsLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EsmBkg1095Event event =(EsmBkg1095Event) e;
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
			command = new AncsManifestListDownloadBCImpl();
			bkgHrdCdgCtntVOs = command.searchAncsLane();

			if (bkgHrdCdgCtntVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}

			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_0017 : MULTI <br>
	 * ESM_BKG_0045 : MULTI02 <br>
	 * ESM_BKG_0063 : MULTI03 <br>
	 * ESM_BKG_0127 : MULTI <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * ESM_BKG_0061 : MULTI01 <br>
	 * ESM_BKG_0282 : MULTI <br>
	 * ESM_BKG_0497 : MULTI <br>
	 * ESM_BKG_0490 : MULTI <br>
	 * ESM_BKG_0053 : MULTI <br>
	 * ESM_BKG_0310 : MULTI <br>
	 * ESM_BKG_0311 : MULTI02 <br>
	 * ESM_BKG_0298 : MODIFY <br>
	 * ESM_BKG_0300 : MODIFY <br>
	 * ESM_BKG_0302 : MULTI <br>
	 * ESM_BKG_0302 : MULTI <br>
	 * ESM_BKG_0303 : MULTI <br>
	 * ESM_BKG_0257 : MULTI <br>
	 * ESM_BKG_0543 : MULTI01 <br>
	 * ESM_BKG_0533 : MULTI01, MULTI02 <br>
	 * ESM_BKG_0408 : MULTI02 <br>
	 * ESM_BKG_0002 : MULTI <br>
	 * ESM_BKG_0029 : MODIFY02 <br>
	 * ESM_BKG_0337 : COMMAND02 <br>
	 * ESM_BKG_0212 : MULTI01 <br>
	 * ESM_BKG_0212 : MULTI02 <br>
	 * ESM_BKG_0034 : COMMAND01 <br>
	 * ESM_BKG_0217 : COMMAND01 <br>
	 * ESM_BKG_1046 : MULTI02 <br>
	 * ESM_BKG_1070 : COMMAND01 <br>
	 * ESM_BKG_0613 : MULTI01 <br>
	 * ESM_BKG_0615 : MULTI01 <br> 
	 * ESM_BKG_0543 : MULTI01 <br>
	 * ESM_BKG_0514 : MULTI01 <br>
	 * ESM_BKG_0233 : MULTI01 <br>
	 * ESM_BKG_0370 : MULTI <br>
	 * ESM_BKG_1106 : MULTI01 <br>
	 * ESM_BKG_1121 : MULTI01 <br>
	 * ESM_BKG_1141 : MULTI <br>
	 * ESM_BKG_1155 : MULTI <br>
	 * ESM_BKG_1168 : MULTI <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
				EsmBkg0017Event event = (EsmBkg0017Event) e;
				command = new PanamaCustomsTransmissionBCImpl();

				String key = command.startBackEndJob(account,
						event.getManifestTransmitVO(), "ESM_BKG_0017");
				eventResponse.setETCData("KEY", key);

				// maniCommand = new PanamaManifestListDownloadBCImpl();
				// flatFile =
				// command.transmitManifest(event.getManifestTransmitVO(),
				// account);

				// maniCommand.modifySendHist(event.getManifestTransmitVO(),
				// account);
				// eventResponse.setETCData("flatFile", flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00218").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0053Event")) {
				EsmBkg0053Event event = (EsmBkg0053Event) e;
				command = new AustrailiaCustomsTransmissionBCImpl();

				String key = command
						.startBackEndJob(account,
								event.getAustrailiaManifestTransmitVO(),
								"ESM_BKG_0053");
				eventResponse.setETCData("KEY", key);

				/*
				 * flatFile =
				 * command.transmitManifest(event.getAustrailiaManifestTransmitVO
				 * ()); if(flatFile.equalsIgnoreCase(""))
				 * eventResponse.setUserMessage(new
				 * ErrorHandler("BKG00220").getUserMessage()); else {
				 * eventResponse.setETCData("flatFile", flatFile);
				 * eventResponse.setETCData(etcData);
				 * eventResponse.setUserMessage(new
				 * ErrorHandler("BKG00218").getUserMessage()); }
				 */
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsCustomsTransmissionBCImpl();
				// flatFile =
				// command.transmitManifest(event.getRocsManifestTransmitVOs(),account);
				String key = command.startBackEndJob(account,
						event.getRocsManifestTransmitVOs(), "ESM_BKG_0061");
				eventResponse.setETCData("KEY", key);
				// eventResponse.setETCData("flatFile",flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00204").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0282Event")) {
				EsmBkg0282Event event = (EsmBkg0282Event) e;
				command = new HongKongCustomsTransmissionBCImpl();

				String key = command.startBackEndJob(account,
						event.getHongKongManifestTransmitVOs(), "ESM_BKG_0282");
				eventResponse.setETCData("KEY", key);

				// flatFile =
				// command.transmitManifest(event.getHongKongManifestTransmitVOs(),
				// account);
				// eventResponse.setETCData("flatFile", flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00218").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0497Event")) {
				EsmBkg0497Event event = (EsmBkg0497Event) e;
				command = new TaiwanCustomsTransmissionBCImpl();
				String key = "";

				/*
				 * 2010년 07월 12일 경종윤 전송 대상이 있는지 check한다.
				 */
				key = command.searchBLGeneralBasic(event
						.getTaiwanManifestTransmitVOs());

				if (!"EMPTY".equals(key)) { // 전송대상이 있을 경우만 flatfile을 만든다.
					key = command.startBackEndJob(account,
							event.getTaiwanManifestTransmitVOs(),
							"ESM_BKG_0497");
				}

				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0490Event")) {
				EsmBkg0490Event event = (EsmBkg0490Event) e;
				command = new SrilankaCustomsTransmissionBCImpl();
				if(event.getSriLankaManifestListCondVO().getVerFlg().equals("O")){
					flatFile = command.transmitManifest(event.getSrilankaManifestTransmitVOs(), account);
				}else{
					flatFile = command.transmitManifestCts(event.getSrilankaManifestTransmitVOs(), account);
				}
				
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1033Event")) {
				EsmBkg1033Event event = (EsmBkg1033Event) e;
				command = new BangladeshCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(
						event.getBangladeshManifestTransmitVOs(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				// BackEnd
				command = new CndCustomsTransmissionBCImpl();
				event.getManifestTransmitVO().setPgmNo("ESM_BKG_0002");
				String key = command.transmitManifest(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);
				
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0006Event")) {
				EsmBkg0006Event event = (EsmBkg0006Event) e;
				// BackEnd
				command = new CndCustomsTransmissionBCImpl();
				event.getManifestTransmitVO().setPgmNo("ESM_BKG_0006");
				String key = command.transmitManifest(event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);				
			
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
																				// EDI
																				// FLATFILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsCustomsTransmissionBCImpl();

				/*
				 * flatFile =
				 * command.transmitManifest(event.getBrManifestTransmitVOs(),
				 * account); eventResponse.setETCData("flatFile", flatFile);
				 * eventResponse.setETCData(etcData);
				 * eventResponse.setUserMessage(new
				 * ErrorHandler("BKG00218").getUserMessage());
				 */

				// BackEnd
				String key = command.startBackEndJob(account,
						event.getBrManifestTransmitVOs(), "ESM_BKG_0127");
				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) { // USA
																				// MI
																				// FLAT
																				// FILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestSearchDetailVO[] vos = event
						.getUsaManifestSearchDetailVOS();
				if (vos.length > 0) {
					vos[0].setUsrId(account.getUsr_id());
					vos[0].setOfcCd(account.getOfc_cd());
				}
				// BackEnd
				String key = command.startBackEndJob(account, vos,
						"ESM_BKG_0613");
				eventResponse.setETCData("KEY", key);				
				// EXPORT USA MI FLAT FILE 생성 및 전송	
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) { 
				EsmBkg0615Event event = (EsmBkg0615Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestSearchDetailVO[] vos = event.getUsaManifestSearchDetailVOS();
				if (vos.length > 0) {
					vos[0].setUsrId(account.getUsr_id());
					vos[0].setOfcCd(account.getOfc_cd());
				}
				// BackEnd
				String key = command.startBackEndJob(account, vos, "ESM_BKG_0615");
				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0543Event")) { // USA
																				// Departure
																				// HI
																				// FLAT
																				// FILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0543Event event = (EsmBkg0543Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestListCondForEdiVO vo = event
						.getUsaManifestListCondForEdiVO();
				vo.setUsrId(account.getUsr_id());
				vo.setOfcCd(account.getOfc_cd());
				UsaManifestListCondForEdiVO[] list = { vo };
				flatFile = command.transmitManifest(list);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0514Event")) { // USA
																				// Arrival
																				// HI
																				// FLAT
																				// FILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0514Event event = (EsmBkg0514Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestListCondForEdiVO vo = event
						.getUsaManifestListCondForEdiVO();
				vo.setUsrId(account.getUsr_id());
				vo.setOfcCd(account.getOfc_cd());
				UsaManifestListCondForEdiVO[] list = { vo };
				flatFile = command.transmitManifest(list);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 0533 Transmit처리. USA HI FLAT FILE 생성 및 전송
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				// Event 객체 선언.
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				// Event 객체로 부터 Transmit 대상 아이템을 가져옴.
				UsaMibTransmitVO[] vos = event.getUsaMibTransmitVOS();
				// 작업을 수행한 User 정보를 가져옴.
				vos[0].setUsrId(account.getUsr_id());
				vos[0].setOfcCd(account.getOfc_cd());
				// BackEnd Job Calling.
				if (vos != null) {
					// BackEnd
					String key = command2.startBackEndJob(account.getUsr_id(),
							vos, "ESM_BKG_0533");
					eventResponse.setETCData("KEY", key);
				}
				// 0408 Transmit처리. USA AI FLAT FILE 생성 및 전송
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				// Event 객체 선언.
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				// 하단 그리드의 vo.
				UsaManifestSearchDetailVO vo = null;
				// 상단 그리드로 부터 조회한 BL리스트.
				List<UsaInbondManifestDetailListVO> lvos = new ArrayList<UsaInbondManifestDetailListVO>();
				// Event 객체로 부터 Transmit 대상 아이템을 가져옴.
				// 하단 그리드 리스트.
				UsaInbondManifestDetailListVO[] detailVOs = event
						.getUsaInbondManifestDetailListVOS();
				// 상단 그리드 리스트.
				UsaInbondManifestListVO[] summaryVOs = event
						.getUsaInbondManifestListVOS();
				// BC호출을 위해 매개VO를 형변환하기 위한 사이즈 셋업.
				int len = 0;
				if (detailVOs != null) {
					len += detailVOs.length;
				}
				// 상단그리드로 부터 전송 요청이 들어온 경우, 해당 BL 리스트를 조회하여 lvos 객체에 값을 셋업한다.
				if (summaryVOs != null) {
					UsaInbondManifestListCondVO condvo = new UsaInbondManifestListCondVO();
					condvo.setPageNo("ESM_BKG_0408");
					List<UsaContainerVO> usaContainerVOs = null;
					UsaContainerVO usaContainerVO = null;
					// 상단그리드로 부터 하단그리드를 조회하는 BC 호출하 기 위한 BC초기화.
					InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
					for (int i = 0; i < summaryVOs.length; i++) {
						// setTrspAuthDt 로 해당 BC에서 Partial check 등 을 생략한 체 순수한
						// bl list 만 조회하게 됨.
						summaryVOs[i]
								.setTrspAuthDt("to query bl list for AI transmit");
						condvo.setUsaInbondManifestListVO(summaryVOs[i]);
						// BC에 작업 요청
						// 요약조회, Inbond B/L, Local B/L 조회 수행.
						usaContainerVOs = (List<UsaContainerVO>) (Object) (command2
								.searchInbondManifestList((InbondListCondVO) condvo));
						// 결과값이 있을 경우 lvos 셋업.
						if (usaContainerVOs.size() > 0) {
							usaContainerVO = usaContainerVOs.get(0);
							// getInbondBlDetailListVOs() 값이 존재하는 경우 : 0408화면의
							// Inbond Bl list.
							if (usaContainerVO.getInbondBlDetailListVOs() != null) {
								len += usaContainerVO
										.getInbondBlDetailListVOs().size();
								lvos.addAll(usaContainerVO
										.getInbondBlDetailListVOs());
							}
						}
					}
				}
				// Transmit 을 실행할 BC에 전달될 vo 변수.
				UsaManifestSearchDetailVO[] vos = new UsaManifestSearchDetailVO[len];
				int i = 0;
				if (detailVOs != null) {
					for (i = 0; i < detailVOs.length; i++) {
						vo = new UsaManifestSearchDetailVO();
						vo.setBlNo(detailVOs[i].getBlNo());
						vo.setTransmitCd("AI");
						vo.setVvd(detailVOs[i].getVvd());
						vo.setUsrId(account.getUsr_id());
						vo.setOfcCd(account.getOfc_cd());
						vo.setPod(detailVOs[i].getPodCd());
						vo.setPol(detailVOs[i].getPolCd());
						vos[i] = vo;
					}
				}
				// 상단 그리드에 의해 조회된 BL 리스트를 vos 에 담는다.
				if (lvos != null) {
					for (int j = 0; j < lvos.size(); j++) {
						// 62, 63 인 경우, L.USA코드가 없으면 오류를 발생한다.
						if (lvos.get(j).getUsaLstLocCd().equals("")
								&& (lvos.get(j).getIbdTrspTpCd().equals("62") || lvos
										.get(j).getIbdTrspTpCd().equals("63"))) {
							throw new EventException(new ErrorHandler(
									"BKG00229").getMessage()); // Missing Last
							// USA
						}
						vo = new UsaManifestSearchDetailVO();
						vo.setBlNo(lvos.get(j).getBlNo());
						vo.setTransmitCd("AI");
						vo.setVvd(lvos.get(j).getVvd());
						vo.setUsrId(account.getUsr_id());
						vo.setOfcCd(account.getOfc_cd());
						vo.setPod(lvos.get(j).getPodCd());
						vo.setPol(lvos.get(j).getPolCd());
						vos[i] = vo;
						i++;
					}
				}
				if (vos != null) {
					// BackEnd
					String key = command.startBackEndJob(account, vos,
							"ESM_BKG_0408");
					eventResponse.setETCData("KEY", key);
				}
				// USA Arrival HI FLAT FILE 생성 및 전송- 0233용으로 0514와는 약간 다르다.
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0233Event")) {
				EsmBkg0233Event event = (EsmBkg0233Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				// 이벤트로 부터 매개VO 배열을 가져온다.
				UsaEDADetailVO[] usaEDADetailVOs = event.getUsaEDADetailVOs();
				// BC호출을 위해 매개VO를 형변환 한다.
				UsaManifestListCondForEdiVO tmpVo = new UsaManifestListCondForEdiVO();
				UsaManifestListCondForEdiVO[] list = null;
				if (usaEDADetailVOs != null) {
					// 실제 매개변수로 전달할 VO를 선언한다.
					list = new UsaManifestListCondForEdiVO[usaEDADetailVOs.length];
					for (int i = 0; i < usaEDADetailVOs.length; i++) {
						// 실제 매개변수로 전달할 VO에 값을 전달하고, 이를 배열에 담는다.
						tmpVo = new UsaManifestListCondForEdiVO();
						tmpVo.setPolCd("");
						tmpVo.setVvd(usaEDADetailVOs[i].getVvd());
						tmpVo.setPodCd(usaEDADetailVOs[i].getPod());
						tmpVo.setBlCount(usaEDADetailVOs[i].getBlCount());
						tmpVo.setEta(usaEDADetailVOs[i].getEta());
						tmpVo.setEtaTime(usaEDADetailVOs[i].getEdaOnMi());
						tmpVo.setUsrId(account.getUsr_id());
						tmpVo.setOfcCd(account.getOfc_cd());
						tmpVo.setPageNo("ESM_BKG_0233");
						list[i] = tmpVo;
					}
					// BC 호출. flatFile을 리턴받는다.
					flatFile = command.transmitManifest(list);
					// 결과값을 EtcData로 리턴함.
					eventResponse.setETCData("flatFile", flatFile);
					eventResponse.setETCData(etcData);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("BKG00099")
							.getUserMessage());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0298Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=1(India Container
				// List Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0298Event event = (EsmBkg0298Event) e;
				command = new IndiaCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(event
						.getIndiaTransmitCondVO());
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0302Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=2(India IGM
				// Generation(EDI) Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0302Event event = (EsmBkg0302Event) e;
				command = new IndiaCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(event
						.getIndiaTransmitCondVO());
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0303Event")) {
				// 세관에 적하목록 신고를 EDI를 통해 전송한다. - processType=3(India TP
				// Request(EDI) Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg0303Event event = (EsmBkg0303Event) e;
				command = new IndiaCustomsTransmissionBCImpl();
				IndiaTransmitCondVO vo = event.getIndiaTransmitCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				flatFile = command.transmitManifest(vo);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
				EsmBkg0991Event event = (EsmBkg0991Event) e;
				command = new JapanCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				// USA EDI FLAT FILE 생성 및 재전송
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaManifestSearchDetailVO[] vos = event
						.getUsaManifestSearchDetailVOS();
				if (vos.length > 0) {
					vos[0].setUsrId(account.getUsr_id());
					vos[0].setOfcCd(account.getOfc_cd());
				}
				//flatFile = command.transmitManifest(vos); 
				command.startBackEndJob(account, vos, "ESM_BKG_0034");
				
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
				commit();
				begin();
				this.transmitCdlEdi(vos[0].getBlNo());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				String sFlatFile = null;
				if (event.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					/***********************************************************
					 * BKG_CSTMS_ADV_BL 테이블 수정
					 ***********************************************************/
					ManifestListDownloadBC command1 = new CndManifestListDownloadBCImpl();
					CndCstmsBlMainVO cndCstmsBlMainVO = event
							.getCndCstmsBlMainVO();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("ESM_BKG_0029");
					cndManifestListDetailVO[0].setBlNo(cndCstmsBlMainVO
							.getBlNo());
					if ("D".equals(cndCstmsBlMainVO.getMfStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("03");
					} else if ("".equals(cndCstmsBlMainVO.getCstmsTrsmStsCd())) {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("00");
					} else {
						cndManifestListDetailVO[0].setCstmsTrsmStsCd("04");
					}
					command1.manageManifest(cndManifestListDetailVO, account);
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					command = new CndCustomsTransmissionBCImpl();
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event
							.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0]
							.getEdiSndDt());
					sFlatFile = command.transmitManifest(cndCstmsManifestVO,
							account);
				} else if (event.getFormCommand().isCommand(
						FormCommand.MODIFY03)) {
					// 현재날짜를 가져오기 위해서
					ManifestListDownloadBC command1 = new CndManifestListDownloadBCImpl();
					CndManifestModificationVO[] cndManifestListDetailVO = new CndManifestModificationVO[1];
					cndManifestListDetailVO[0] = new CndManifestModificationVO();
					cndManifestListDetailVO[0].setPgmNo("Terminal_Trans");
					command1.manageManifest(cndManifestListDetailVO, account);
					/***********************************************************
					 * FlatFile 만들기, 로그테이블 저장
					 ***********************************************************/
					command = new CndCustomsTransmissionBCImpl();
					CndCstmsManifestVO cndCstmsManifestVO = (CndCstmsManifestVO) event
							.getManifestTransmitVO();
					cndCstmsManifestVO.setMiSndDt(cndManifestListDetailVO[0]
							.getEdiSndDt());
					cndCstmsManifestVO.setIbflag("Terminal");
					sFlatFile = command.transmitManifest(cndCstmsManifestVO,
							account);
				}
				/***********************************************************
				 * EDI 전송 START
				 ***********************************************************/
				if (sFlatFile != null) {
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(sFlatFile);
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory
							.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
					BookingUtil utilCommand = new BookingUtil();
					FlatFileAckVO flatFileAckVO = utilCommand
							.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205",
								new String[] {}).getMessage());
				}
				// 성공메시지 세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
				EsmBkg0344Event event = (EsmBkg0344Event) e;
				command = new KorCustomsTransmissionBCImpl();
				maniCommand = new KorManifestListDownloadBCImpl();

				if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					// Trans Discharge 하선신고
					KorDischManifestTransmitVO condVO = event
							.getKorDischManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					command.transmitDischManifest(condVO);
					// 신고후 전송시간 UPDATE
					// E Type인 경우는 전송이력을 남기지 않는다.
					if (!condVO.getNoneBlInType().equals("E")) {
						maniCommand.transmitDischManifest(condVO);
					}
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
					// Trans Manifest, Trans per B/L
					KorManifestTransmitVO condVO = event
							.getKorManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					// command.transmitManifest(condVO);
					String key = command.startBackEndJob(account, condVO,
							"ESM_BKG_0344");
					eventResponse.setETCData("KEY", key);
					log.debug("############################ key:" + key);
					// 전송후 UPDATE 처리
					// E Type인 경우는 전송이력을 남기지 않는다.
					if (!condVO.getNoneBlInType().equals("E")) {
						maniCommand.transmitManifest(condVO);
					}
					eventResponse.setUserMessage(new ErrorHandler("BKG00218")
							.getMessage());
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					// Trans Amendment To PA, Trans Cancellation To PA
					KorAmendManifestTransmitVO condVO = event
							.getKorAmendManifestTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					String subNo = command.transAmendManifest(condVO);

					// Inbound 이고 ETA가 변경된 경우 전송 UPDATE
					if (condVO.getIoBndCd().equals("I")
							&& condVO.getInChgEta().equals("AI")) {

						KorCorrInfoVO korCorrInfoVO = new KorCorrInfoVO();
						korCorrInfoVO.setSubNo(subNo);
						korCorrInfoVO.setBlNo(condVO.getBlNo());
						korCorrInfoVO.setCBlNo(condVO.getBlNo());
						korCorrInfoVO.setKrCstmsCorrId("AI");
						korCorrInfoVO.setCorrRsn("01");
						korCorrInfoVO.setUserId(condVO.getUserId());
						korCorrInfoVO.setTrnsSeq("1");
						korCorrInfoVO.setPortCd(condVO.getPodCd());
						korCorrInfoVO.setKrVslCallSgnCd(condVO
								.getVslCallSgnCd());
						korCorrInfoVO.setCallYr(condVO.getEtaDt().substring(0,
								4));
						korCorrInfoVO.setCallKnt(condVO.getCallKnt());
						korCorrInfoVO.setVslNm(condVO.getVslNm());
						korCorrInfoVO.setVslRgstCntCd(condVO.getVslCntCd());
						korCorrInfoVO.setIoTmlLocCd(condVO.getIoTmlLocCd());
						korCorrInfoVO.setDchgMzdCd(condVO.getDchgMzdCd());
						korCorrInfoVO.setVvd(condVO.getVvd());

						maniCommand.addSndDtCorrInfo(korCorrInfoVO);
					}
				}
				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0063Event")) {
				EsmBkg0063Event event = (EsmBkg0063Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				command.transmitManifest((ManifestTransmitVO[]) event
						.getAncsManifestTransmitVOs(), account);
				// eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				command.transmitManifest((ManifestTransmitVO[]) event
						.getAncsManifestTransmitVOs(), account);
				// eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) { // 유럽
																				// EDI
																				// FLAT
																				// FILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				command = new EurCustomsTransmissionBCImpl();
				// flatFile =
				// command.transmitManifest(event.getEuManifestTransmitVO());
				// eventResponse.setETCData("flatFile",flatFile);
				// eventResponse.setETCData(etcData);
				// BackEnd
				EurManifestTransmitVO[] eurManifestTransmitVOs = event
						.getEuManifestTransmitVOs();
				String key = command.startBackEndJob(account,
						eurManifestTransmitVOs, "ESM_BKG_0257");

				// String key = command.startBackEndJob(account.getUsr_id(),
				// event.getEuManifestTransmitVO(), "ESM_BKG_0257");
				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {

				// Sitpro FLATFILE 생성 및 전송
				EsmBkg0484Event event = (EsmBkg0484Event) e;
				command = new EurCustomsTransmissionBCImpl();
				EurManifestTransmitVO[] eurManifestTransmitVOs = event
						.getEuManifestTransmitVOs();
				// eurManifestTransmitVO.setOfcCd(account.getOfc_cd());
				// BackEnd
				String key = command.startBackEndJob(account.getUsr_id(),
						eurManifestTransmitVOs, "ESM_BKG_0484");
				eventResponse.setETCData("KEY", key);
				// flatFile = command.transmitManifest(eurManifestTransmitVO);
				// eventResponse.setETCData("flatFile",flatFile);
				// eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0212Event")) {
				// 한국세관 DG Cargo Manifest Transmission
				EsmBkg0212Event event = (EsmBkg0212Event) e;
				command = new KorCustomsTransmissionBCImpl();
				if (event.getTransmitMode().equals("DGN")) {
					// Transmit DGN
					KorManifestDGNTransmitVO condVO = event
							.getKorManifestDGNTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					// BC에 작업 요청
					command.transmitDGNManifest(condVO);
				} else {
					// Transmit DGL
					KorManifestDGMTransmitVO condVO = event
							.getKorManifestDGMTransmitVO();
					condVO.setUserId(account.getUsr_id());
					condVO.setOfcCd(account.getOfc_cd());
					// BC에 작업 요청
					DgmManifestVO dgmManifestVO = command
							.transmitDGMManifest(condVO);

					// 전송후 UPDATE
					ManiDGMTransVO maniDGMTransVO = new ManiDGMTransVO();
					ObjectCloner.build(dgmManifestVO, maniDGMTransVO);
					maniCommand = new KorManifestListDownloadBCImpl();
					maniCommand.transmitDGMManifest(maniDGMTransVO);

				}
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0337Event")) {
				// 한국세관 MSN CREATE -> EDI SEND
				EsmBkg0337Event event = (EsmBkg0337Event) e;
				command = new KorCustomsTransmissionBCImpl();
				KorMsnCreateVO korMsnCreateVO = event.getKorMrnInfoVO();
				KorManifestMFTTransmitVO condVO = new KorManifestMFTTransmitVO();
				condVO.setUserId(account.getUsr_id());
				condVO.setMrnNo(korMsnCreateVO.getInMrnNo());
				condVO.setMrnChkNo(korMsnCreateVO.getInMrnChkNo());
				condVO.setVslCd(korMsnCreateVO.getInVslCd());
				condVO.setSkdVoyNo(korMsnCreateVO.getInSkdVoyageNo());
				condVO.setSkdDirCd(korMsnCreateVO.getInSkdDirCd());
				condVO.setPortCd(korMsnCreateVO.getInPort());
				// BC에 작업 요청
				flatFile = command.transmitKorMFTManifest(condVO);

				// 전송 후 UPDATE 처리
				KorManiCondVO korManiCondVO = new KorManiCondVO();
				ObjectCloner.build(condVO, korManiCondVO);
				ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				command2.transmitKorMFTManifest(korManiCondVO);

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00693")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) { // 멕시코
																				// EDI
																				// FLAT
																				// FILE
																				// 생성
																				// 및
																				// 전송
				EsmBkg0370Event event = (EsmBkg0370Event) e;
				command = new MexCustomsTransmissionBCImpl();
				// event로 부터 객체 받기.
				MxManifestListByVvdDetailVO[] vos = event.getDetailVOs();
				// account정보 설정.
				for (int k = 0; k < vos.length; k++) {
					vos[k].setUsrId(account.getUsr_id());
					vos[k].setOfcCd(account.getOfc_cd());
				}
				// BackEnd
				String key = command.startBackEndJob(account, vos,
						"ESM_BKG_0370");
				eventResponse.setETCData("KEY", key);
				// BC 호출.
				// flatFile = command.transmitManifest(vos);
				// 결과값 셋팅.
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg1046Event event = (EsmBkg1046Event) e;
				command = new ChinaCustomsTransmissionBCImpl();

				// BC에 작업 요청
				// flatFile =
				// command.transmitManifest(event.getManifestTransmitVO(),
				// account);
				// eventResponse.setETCData("flatFile", flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00218").getUserMessage());
				String key = command.transmitManifest(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {
				// 러시아 EDI FLAT FILE 생성 및 전송
				EsmBkg1163Event event = (EsmBkg1163Event) e;
				command = new RussiaCustomsTransmissionBCImpl();

				// BC에 작업 요청
				// flatFile =
				// command.transmitManifest(event.getManifestTransmitVO(),
				// account);
				// eventResponse.setETCData("flatFile", flatFile);
				// eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00218").getUserMessage());
				String key = command.transmitManifest(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);
			} 
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg0217Event event = (EsmBkg0217Event) e;
				command = new ChinaCustomsTransmissionBCImpl();
				// BC에 작업 요청
				flatFile = command.transmitManifest(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg1070Event event = (EsmBkg1070Event) e;
				command = new ChinaCustomsTransmissionBCImpl();
				// BC에 작업 요청
				ChinaManifestTransmitVO transmitVO = (ChinaManifestTransmitVO) event
						.getManifestTransmitVO();
				flatFile = command.transmitTmlManifest(transmitVO, account);
				// BKG_NTC_HS 로그 저장
				BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
				command2.createBkgNtcHis(transmitVO.getBkgNtcHisVOs(),
						transmitVO.getEdiRefId());

				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			}
			// Indonesian Customs Inbound EDI Download
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0310Event")) {
				// log.info("Indonesian Customs Inbound EDI Download");
				EsmBkg0310Event event = (EsmBkg0310Event) e;
				command = new IndonesiaCustomsTransmissionBCImpl();
				List<IndonesiaFFVO> indonesiaFFVOs = command
						.transmitManifestForIndonesia(
								event.getManifestTransmitVO(), account);

				eventResponse.setRsVoList(indonesiaFFVOs);
			}
			// Indonesian Customs Outbound EDI Download
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				// log.info("Indonesian Customs Outbound EDI Download");
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				command = new IndonesiaCustomsTransmissionBCImpl();
				List<IndonesiaFFVO> indonesiaFFVOs = command
						.transmitManifestForIndonesia(
								event.getManifestTransmitVO(), account);

				eventResponse.setRsVoList(indonesiaFFVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				// 두바이 Flat File 생성 및 로컬 pc로 다운로드)
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				// update
				DubaiManifestTransmitVO[] dubaiManifestTransmitVOs = (DubaiManifestTransmitVO[]) event
						.getManifestTransmitVOs();
				DubaiVesselManifestListVO[] vos = new DubaiVesselManifestListVO[1];
				vos[0] = new DubaiVesselManifestListVO();
				vos[0].setVslCd(dubaiManifestTransmitVOs[0].getVslCd());
				vos[0].setSkdVoyNo(dubaiManifestTransmitVOs[0].getSkdVoyNo());
				vos[0].setSkdDirCd(dubaiManifestTransmitVOs[0].getSkdDirCd());
				vos[0].setPodCd(dubaiManifestTransmitVOs[0].getPodCd());
				vos[0].setClptSeq(dubaiManifestTransmitVOs[0].getClptSeq());
				ManifestListDownloadBC downCommand = new DubaiManifestListDownloadBCImpl();
				downCommand.manageCstmsVvdInfo(vos, account);
				// transmit
				command = new DubaiCustomsTransmissionBCImpl();
				flatFile = command.transmitManifest(
						event.getManifestTransmitVOs(), account);
				StringTokenizer st = new StringTokenizer(flatFile, "\n");
				List<DubaiManifestTransmitVO> list = new ArrayList<DubaiManifestTransmitVO>();
				int j = st.countTokens();
				for (int i = 0; i < j; i++) {
					DubaiManifestTransmitVO vo = new DubaiManifestTransmitVO();
					vo.setFlatFile(st.nextToken());
					list.add(vo);
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				log.debug("#################EsmBkg1106Event: sendFlatFile Start");
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account,
						event.getEu24ManifestTransmitVOs(), "ESM_BKG_1106");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				log.debug("#################EsmBkg1121Event: sendFlatFile Start");
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account,
						event.getEu24ManifestTransmitOBVOs(), "ESM_BKG_1121");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1141Event")) {
				// Malaysia Flat File 생성)
				EsmBkg1141Event event = (EsmBkg1141Event) e;

				// transmit
				command = new MalaysiaCustomsTransmissionBCImpl();
				String key = command.startBackEndJob(account,
						event.getManifestTransmitVOs(), "ESM_BKG_1141");

				eventResponse.setETCData("KEY", key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
				// Vietnam Flat File 생성)
				log.debug("#################EsmBkg1149Event: sendFlatFile Start");
				EsmBkg1149Event event = (EsmBkg1149Event) e;

				// transmit
				command = new VietnamCustomsTransmissionBCImpl();
				String key = command.startBackEndJob(account,
						event.getManifestTransmitVOs(), "ESM_BKG_1149");

				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1155Event")) {
				// Vietnam Flat File 생성)
				log.debug("#################EsmBkg1155Event: sendFlatFile Start");
				EsmBkg1155Event event = (EsmBkg1155Event) e;

				// transmit
				command = new MyanmarCustomsTransmissionBCImpl();
				String key = command.startBackEndJob(account,
						event.getManifestTransmitVOs(), "ESM_BKG_1155");

				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
				log.debug("#################EsmBkg1168Event: sendFlatFile Start");
				EsmBkg1168Event event = (EsmBkg1168Event) e;
				command = new IsraelCustomsTransmissionBCImpl();
				// BackEnd
				String key = command.startBackEndJob(account,
						event.getIsraelManifestTransmitVOs(), "ESM_BKG_1168");
				eventResponse.setETCData("KEY", key);
				log.debug("############################ key:" + key);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				command = new EurCustomsTransmissionBCImpl();
				command.transmitManifest(event.getEuManifestTransmitVOs(),
						account);

			}
			
			
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
		
	}

	/**
	 * ESM_BKG_0730 : MULTI01 <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = new JapanManifestListTransmitDetailVO();
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
				EsmBkg0730Event event = (EsmBkg0730Event) e;
				command = new JapanCustomsTransmissionBCImpl();

				// maniCommand = new JapanManifestListDownloadBCImpl();
				// japanManifestListTransmitDetailVO
				// =(JapanManifestListTransmitDetailVO)
				// command.transmitManifestList(event
				// .getManifestTransmitVO(), account);
				// maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO.getJapanBlKeyVOs());
				// flatFile = japanManifestListTransmitDetailVO.getFliatFile();
				// eventResponse.setETCData("flatFile", flatFile);

				String key = command.startBackEndJob(account,
						event.getManifestTransmitVO(), "ESM_BKG_0730");
				eventResponse.setETCData("KEY", key);

				eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00204").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
				EsmBkg0991Event event = (EsmBkg0991Event) e;
				command = new JapanCustomsTransmissionBCImpl();
				maniCommand = new JapanManifestListDownloadBCImpl();
				japanManifestListTransmitDetailVO = (JapanManifestListTransmitDetailVO) command
						.transmitManifestList(event.getManifestTransmitVO(),
								account);
				maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO
						.getJapanBlKeyVOs());
				flatFile = japanManifestListTransmitDetailVO.getFliatFile();
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0730 : MULTI02 <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다(2017 Renewal Ver.)<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestListRenewal2017(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = new JapanManifestListTransmitDetailVO();
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
				EsmBkg0730Event event = (EsmBkg0730Event) e;
				command = new JapanCustomsTransmissionBCImpl();

				// maniCommand = new JapanManifestListDownloadBCImpl();
				// japanManifestListTransmitDetailVO
				// =(JapanManifestListTransmitDetailVO)
				// command.transmitManifestList(event
				// .getManifestTransmitVO(), account);
				// maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO.getJapanBlKeyVOs());
				// flatFile = japanManifestListTransmitDetailVO.getFliatFile();
				// eventResponse.setETCData("flatFile", flatFile);

				String key = command.startBackEndJob(account,
						event.getManifestTransmitVO(), "ESM_BKG_0730_Renewal2017");
				eventResponse.setETCData("KEY", key);

				eventResponse.setETCData(etcData);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00204").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0991Event")) {
				EsmBkg0991Event event = (EsmBkg0991Event) e;
				command = new JapanCustomsTransmissionBCImpl();
				maniCommand = new JapanManifestListDownloadBCImpl();
				event.getManifestTransmitVO().setPgmNo("ESM_BKG_0991_Renewal2017");
				japanManifestListTransmitDetailVO = (JapanManifestListTransmitDetailVO) command
						.transmitManifestList(event.getManifestTransmitVO(),
								account);
				maniCommand.modifyMsgStatus(japanManifestListTransmitDetailVO
						.getJapanBlKeyVOs());
				flatFile = japanManifestListTransmitDetailVO.getFliatFile();
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0477 : MULTI <br>
	 * 세관에 적하목록 신고를 EDI를 통해 재전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestForResend(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			EsmBkg0477Event event = (EsmBkg0477Event) e;
			command = new JapanCustomsTransmissionBCImpl();
			flatFile = command.transmitManifestForResend(
					(ManifestTransmitVO) event
							.getJapanManifestTransmitForReVO(), account);
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setETCData(etcData);
			eventResponse.setUserMessage(new ErrorHandler("BKG00218")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0926 : SEARCH,SEARCH01 <br>
	 * 세관 관리 항목 setup 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// 이벤트별 Impl 생성
		try {
			EsmBkg0926Event event = (EsmBkg0926Event) e;
			command = new UsaManifestListDownloadBCImpl();
			if (event.getSetupListCondVO() != null) {
				List<SetupListDetailVO> list = command.searchSetupList(event
						.getSetupListCondVO());
				eventResponse.setRsVoList(list);
			} else {
				if ("country".equals(event.getComboName())) {
					// Country Code List
					List<MdmCountryVO> countryCode = command
							.searchCountryCodeList();
					eventResponse.setRsVoList(countryCode);
				} else {
					// Port Code List
					MdmPortVO portVo = new MdmPortVO();
					portVo.setPortCd("ALL");
					portVo.setPortNm("ALL");
					List<MdmPortVO> portCode = command.searchPortCodeList(event
							.getCntCd());
					portCode.add(0, portVo);
					eventResponse.setRsVoList(portCode);
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
	 * ESM_BKG_0926 : MULTI,MODIFY <br>
	 * 저장 이벤트 처리<br>
	 * UsaManifestListDownload의 event에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			EsmBkg0926Event event = (EsmBkg0926Event) e;
			command = new UsaManifestListDownloadBCImpl();
			begin();
			if (event.getSetupListModVO() != null) {
				command.modifySetupList(event.getSetupListModVO(), account);
				eventResponse.setETCData("mode", "U");
			} else if (event.getSetupKeyVO() != null) {
				command.modifySetupStatus(event.getSetupKeyVO(), account);
				eventResponse.setETCData("mode", "D");
			}
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0029 : SEARCH<BR>
	 * ESM_BKG_0034 : SEARCH01 <br>
	 * ESM_BKG_0045 : SEARCH <br>
	 * 세관 관리 항목 setup 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse inquiryBlData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();

				List<BlDetailVO> list = command.inquiryBlData(event
						.getBlCondVO());
				UsaBlDetailContainerVO vo = (UsaBlDetailContainerVO) list
						.get(0);

				eventResponse.setETCData("div_ind", vo.getDivInd());

				if (vo.getUsaAiBlInfoVO() != null) {
					eventResponse.setRsVo(vo.getUsaAiBlInfoVO());
					eventResponse.setETCData(vo.getUsaAiBlInfoVO()
							.getColumnValues());
				}
				if (vo.getUsaBlCustVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustVOs());
				}
				if (vo.getUsaBlCustomerSecondVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustomerSecondVOs());
				}
				if (vo.getUsaBlCustomsResultVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlCustomsResultVOs());
				}
				if (vo.getUsaBlRemarkVOs() != null
						&& vo.getUsaBlRemarkVOs().size() > 0) {
					UsaBlRemarkVO remarkVO = vo.getUsaBlRemarkVOs().get(0);
					if (!"".equals(remarkVO.getDiffRmk())) {
						eventResponse.setETCData("diff_rmk",
								remarkVO.getDiffRmk());
					}
					if (!"".equals(remarkVO.getCntrNo())
							|| !"".equals(remarkVO.getRailCrrRefNo())
							|| !"".equals(remarkVO.getIbdTrspNo())) {
						eventResponse.setRsVoList(vo.getUsaBlRemarkVOs());
					}
				}
				if (vo.getUsaBlHistoryVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlHistoryVOs());
				}
				if (vo.getUsaBlHblListVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlHblListVOs());
				}
				if (vo.getUsaBlMultiBlListVOs() != null) {
					eventResponse.setRsVoList(vo.getUsaBlMultiBlListVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<BlDetailVO> list = command.inquiryBlData(event
						.getCndCstmsBlCondVO());
				if (list.size() > 0) {
					CndBlDetailVO vo = (CndBlDetailVO) list.get(0);
					eventResponse.setRsVo(vo.getCndCstmsBlMainVO());
					eventResponse.setRsVo(vo.getCndCstmsBlCustVO());
					eventResponse.setRsVoList(vo.getCndCstmsBlCstmsRsltVOs());
					eventResponse.setRsVoList(vo.getCndCstmsBlHblListVOs());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsBlCVO ancsCstmsBlCVO = command.inquiryBlData(event
						.getAncsCstmsBlCondVO());

				eventResponse.setRsVoList(ancsCstmsBlCVO
						.getAncsCstmsBlInfoVOs());
				eventResponse.setRsVoList(ancsCstmsBlCVO.getAncsCstmsCntrVOs());
				eventResponse.setRsVoList(ancsCstmsBlCVO.getAncsCstmsCmdtVOs());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1087Event")) {
				EsmBkg1087Event event = (EsmBkg1087Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				eventResponse.setRsVo(command.searchManifestInfo(event
						.getManifestListCondVO()));

				// DUBAI TRADE CODE
				eventResponse.setRsVoList(searchCodeCombo("CD02558"));
				// DUBAI CARGO CODE
				eventResponse.setRsVoList(searchCodeCombo("CD02559"));
				// DUBAI CONTAINER SERVICE TYPE CODE
				eventResponse.setRsVoList(searchCodeCombo("CD02560"));
				// DUBAI TRANSSHIPMENT MODE CODE
				eventResponse.setRsVoList(searchCodeCombo("CD02564"));
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
	 * ESM_BKG_0018 : MULTI <br>
	 * ESM_BKG_0016 : MULTI <br>
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해
	 * 사전 VVD INFORMATION을 입력한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event")) {
				EsmBkg0018Event event = (EsmBkg0018Event) e;
				command = new PanamaManifestListDownloadBCImpl();
				command.manageVessel(event.getPanamaVesselVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
				EsmBkg0016Event event = (EsmBkg0016Event) e;
				command = new CndManifestListDownloadBCImpl();
				command.manageCstmsVesselInfo(event.getVesselInfoVOs(), account);
				eventResponse.setUserMessage((String) new ErrorHandler(
						"BKG00166", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0018 : SEARCH <br>
	 * ESM_BKG_0016 : SEARCH <br>
	 * ESM_BKG_0613 : SEARCH <br>
	 * ESM_BKG_0615 : SEARCH <br>  
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해
	 * 등록했던 Vessel 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0018Event")) {
				EsmBkg0018Event event = (EsmBkg0018Event) e;
				command = new PanamaManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event
						.getPanamaVesselCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0016Event")) {
				EsmBkg0016Event event = (EsmBkg0016Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event
						.getVesselCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event
						.getVesselCondVO());
				if (list.size() > 0) {
					UsaVesselVO vo = (UsaVesselVO) list.get(0);
					eventResponse.setETCData("ACT_VVD", vo.getVvd());
				} else {
					eventResponse.setETCData("ACT_VVD", "");
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
				EsmBkg0615Event event = (EsmBkg0615Event) e;
				command = new UsaManifestListDownloadBCImpl();
				List<VesselVO> list = command.searchVessel(event.getVesselCondVO());
				if (list.size() > 0) {
					UsaVesselVO vo = (UsaVesselVO) list.get(0);
					eventResponse.setETCData("ACT_VVD", vo.getVvd());
				} else {
					eventResponse.setETCData("ACT_VVD", "");
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
	 * ESM_BKG_0249 : SEARCH<BR>
	 * ESM_BKG_0551 : SEARCH<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 * 
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0249Event")) {
				EsmBkg0249Event event = (EsmBkg0249Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CstmsVvdVO> list = command.searchCstmsVvdList(event
						.getCstmsVvdListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
				EsmBkg0551Event event = (EsmBkg0551Event) e;
				begin();
				command = new AncsManifestListDownloadBCImpl();
				List<CstmsVvdVO> list = command.searchCstmsVvdList(event
						.getAncsCstmsVvdListCondVO());
				commit();
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0304 : MULTI <br>
	 * ESM_BKG_0470 : MULTI <br>
	 * ESM_BKG_0443 : MULTI <br>
	 * ESM_BKG_0493 : MULTI <br>
	 * ESM_BKG_0494 : MULTI <br>
	 * ESM_BKG_0015 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVesselArrival(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndManifestListDownloadBCImpl();
				command.manageVesselArrival(event.getVeseelArrivalVO(), account);
				eventResponse.setUserMessage((String) new ErrorHandler(
						"BKG00166", new String[] {}).getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0304Event")) { // India
				command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0304Event event = (EsmBkg0304Event) e;
				command.manageVesselArrival(event.getInVesselArrivalVO(),
						account);
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00101").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")) { // Rocs
				command = new RocsManifestListDownloadBCImpl();
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				// 2015.04.27 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
				String resultVal = command.manageCrnWithCallSeq((CrnVO) event.getRocscrnVO(), account);
				eventResponse.setETCData("err_msg", resultVal);
				
				/* 2015.04.27 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
				int ret = command.manageCRN(event.getRocscrnVO(), account);
				if (ret == 8)
					eventResponse.setUserMessage(new ErrorHandler("BKG00163")
							.getUserMessage());
				else if (ret == 9)
					eventResponse.setUserMessage(new ErrorHandler("BKG00547")
							.getUserMessage());
				else
					eventResponse.setUserMessage(new ErrorHandler("BKG00166")
							.getUserMessage());*/
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) { // India
				command = new AncsManifestListDownloadBCImpl();
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command.manageVesselArrival(event.getAncsVesselArrivalVO(),
						account);
				eventResponse.setUserMessage((String) new ErrorHandler(
						"BKG00166", new String[] {}).getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0470Event")) { // India
				command = new JapanManifestListDownloadBCImpl();
				EsmBkg0470Event event = (EsmBkg0470Event) e;
				command.manageVesselArrival(
						(VesselArrivalVO) event.getJapanVesselArrivalVO(),
						account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
				EsmBkg0493Event event = (EsmBkg0493Event) e;
				command = new SriLankaManifestListDownloadBCImpl();
				command.manageVesselArrival(
						(VesselArrivalVO) event.getSriLankaVesselArrivalVO(),
						account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageVesselArrival(
						(Eur24VesselArrivalNoticeDetailVO) event
								.getVesselArrivalDetailVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageVesselArrival(
						(Eur24VesselArrivalNoticeDetailVO) event
								.getVesselArrivalDetailVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1094 : MULTI <br>
	 * Vessel Arrival 정보를 생성 및 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCrnNo(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg1094Event")) {
				EsmBkg1094Event event = (EsmBkg1094Event) e;
				command = new RocsManifestListDownloadBCImpl();
				/*command.manageCrnNo(event.getVslCallRefNoOld(),
						event.getVslCallRefNoNew(), account);
				eventResponse.setUserMessage((String) new ErrorHandler(
						"BKG00166", new String[] {}).getUserMessage());*/
				
				// 2014.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
				
				//String result = command.modifyCrnNoWithCallSeq(event.getCrnVO(), account);
				
				String result = command.modifyCrnNoWithCallSeq((CrnVO) event.getRocsSearchCRNVO(), account);
				eventResponse.setETCData("err_msg", result);	
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0470 : MULTI01 <br>
	 * ESM_BKG_0493 : MULTI01 <br>
	 * ESM_BKG_0494 : MULTI01 <br>
	 * ESM_BKG_0015 : ADD <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC maniCommand = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndCustomsTransmissionBCImpl();
				CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event
						.getVesselArrivalTransmitVO();
				/***********************************************************
				 * VesselArrival에 send date 수정
				 ***********************************************************/
				ManifestListDownloadBC vslBC = new CndManifestListDownloadBCImpl();
				CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
				vslVO.setVslCd(vo.getVslCd());
				vslVO.setSkdVoyNo(vo.getSkdVoyNo());
				vslVO.setSkdDirCd(vo.getSkdDirCd());
				vslVO.setCapNm(vo.getCapNm());
				vslVO.setVpsEtaDt(vo.getVpsEtaDt());
				// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
				// manageVesselArrival안에서 함
				vslBC.manageVesselArrival(vslVO, account);
				/***********************************************************
				 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
				 ***********************************************************/
				vo.setVslArrRptSndDt(vslVO.getVslArrRptSndDt());
				String sFlatFile = command.transmitVesselArrival(vo, account);
				/***********************************************************
				 * EDI 전송 START
				 ***********************************************************/
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(sFlatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory
						.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand
						.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205",
							new String[] {}).getMessage());
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0470Event")) {
				EsmBkg0470Event event = (EsmBkg0470Event) e;
				command = new JapanCustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				command.transmitVesselArrival((VesselArrivalTransmitVO) event
						.getJapanVesselArrivalTransmitVO(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				command.transmitVesselArrival((VesselArrivalTransmitVO) event
						.getAncsVesselArrivalTransmitVO(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
				EsmBkg0493Event event = (EsmBkg0493Event) e;
				command = new SrilankaCustomsTransmissionBCImpl();
				maniCommand = new SriLankaManifestListDownloadBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				flatFile = command
						.transmitVesselArrival((VesselArrivalTransmitVO) event
								.getSriLankaVesselArrivalTransmitVO());
				maniCommand.modifySendDt((VesselArrivalTransmitVO) event
						.getSriLankaVesselArrivalTransmitVO());
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				flatFile = command.transmitVesselArrival(
						(VesselArrivalTransmitVO) event
								.getEur24VesselArrivalTransmitVO(), account);
				log.info("flatFile : " + flatFile);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				Eur24CustomsTransmissionBCImpl command2 = new Eur24CustomsTransmissionBCImpl();
				// 1.FlatFile을 만들고 2.로그테이블에 Insert
				flatFile = command2.transmitDiversionRequest(
						(VesselArrivalTransmitVO) event
								.getEur24VesselArrivalTransmitVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0015 : MULTI01 <br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitActualVesselArrival(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndCustomsTransmissionBCImpl();
				CndVesselArrivalTransmitVO vo = (CndVesselArrivalTransmitVO) event
						.getVesselArrivalTransmitVO();
				/***********************************************************
				 * VesselArrival에 send date 수정
				 ***********************************************************/
				ManifestListDownloadBC vslBC = new CndManifestListDownloadBCImpl();
				CndVesselArrivalVO vslVO = new CndVesselArrivalVO();
				vslVO.setVslCd(vo.getVslCd());
				vslVO.setSkdVoyNo(vo.getSkdVoyNo());
				vslVO.setSkdDirCd(vo.getSkdDirCd());
				vslVO.setCapNm(vo.getCapNm());
				vslVO.setActArrDt(vo.getActArrDt());
				// vslVO.setVslArrRptSndDt(); //GMT 시간 세팅은
				// manageVesselArrival안에서 함
				vslBC.manageVesselArrival(vslVO, account);
				/***********************************************************
				 * 1.FlatFile을 만들고 2.EDI 전송 3.로그테이블에 Insert
				 ***********************************************************/
				vo.setVslArrRptSndDt(vslVO.getVslArrRptSndDt());
				String sFlatFile = command.transmitActualVesselArrival(vo,
						account);
				/***********************************************************
				 * EDI 전송 START
				 ***********************************************************/
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(sFlatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory
						.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand
						.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205",
							new String[] {}).getMessage());
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0745 : SEARCH <br>
	 * ESM_BKG_0127 : SEARCH02 <br>
	 * ESM_BKG_0311 : SEARCH01 <br>
	 * ESM_BKG_0036 : SEARCH, SEARCH01, SEARCH02<BR>
	 * Container Manifest 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerManifest(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg0745Event".equalsIgnoreCase(e.getEventName())
					|| "EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // brazil
				command = new BrcsManifestDownloadBCImpl();
				List<BrHsCdDetailVO> list = null;
				BrHsCdDetailVO brHsCdDetailVO = null;
				if ("EsmBkg0127Event".equalsIgnoreCase(e.getEventName())) { // 그리드에서
																			// Cell값
																			// 변경시
					EsmBkg0127Event event = (EsmBkg0127Event) e;
					BrHsCdCondVO brHsCdCondVO = new BrHsCdCondVO();
					brHsCdCondVO.setBrzCmdtCd((event.getBrManifestListCondVO())
							.getBrzCmdtCd());
					brHsCdCondVO.setPageGubun("popup");
					list = command.searchHsCdList(brHsCdCondVO);
					if (list.size() > 0) {
						brHsCdDetailVO = list.get(0);
						eventResponse.setETCData("brz_cmdt_cd",
								brHsCdDetailVO.getBrzCmdtCd());
						eventResponse.setETCData("cmdt_desc",
								brHsCdDetailVO.getCmdtDesc());
					} else {
						eventResponse.setETCData("brz_cmdt_cd", "");
						eventResponse.setETCData("cmdt_desc", "");
					}
				} else { // NCM Code 팝업 호출시
					EsmBkg0745Event event = (EsmBkg0745Event) e;
					BrHsCdCondVO brHsCdCondVO = event.getBrHsCdCondVO();
					brHsCdCondVO.setPageGubun("main");
					list = command.searchHsCdList(brHsCdCondVO);
					eventResponse.setRsVoList(list);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) {
				EsmBkg0036Event event = (EsmBkg0036Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaContainerManifestDetailVO detailVO = (UsaContainerManifestDetailVO) command
						.searchContainerManifest(event
								.getContainerManifestCondVO());

				eventResponse.setRsVoList(detailVO.getUsaContainerListVOs());
				eventResponse.setRsVoList(detailVO.getUsaCntrManifestListVOs());
				eventResponse.setRsVoList(detailVO.getUsaCntrManifestInfoVOs());
				if (detailVO.getUsaCntrManifestInfoVOs().size() > 0) {
					eventResponse.setETCData(detailVO
							.getUsaCntrManifestInfoVOs().get(0)
							.getColumnValues());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) {
				command = new IndonesiaManifestListDownloadBCImpl();
				List<indonesiaBkgDetailVO> list = null;
				indonesiaBkgDetailVO indonesiaBkgDetailVO = null;
				if ("EsmBkg0311Event".equalsIgnoreCase(e.getEventName())) { // 그리드에서
																			// Cell값
																			// 변경시
					EsmBkg0311Event event = (EsmBkg0311Event) e;
					IndonesiaManifestListCondVO indonesiaManifestListCondVO = new IndonesiaManifestListCondVO();
					indonesiaManifestListCondVO.setBkgNo((event
							.getIndonesiaManifestListCondVO()).getBkgNo());
					list = command.searchBkgInfo(indonesiaManifestListCondVO);
					if (list.size() > 0) {
						indonesiaBkgDetailVO = list.get(0);
						eventResponse.setETCData("bl_no",
								indonesiaBkgDetailVO.getBlNo());
						eventResponse.setETCData("vvd",
								indonesiaBkgDetailVO.getVvd());
						eventResponse.setETCData("por_cd",
								indonesiaBkgDetailVO.getPorCd());
						eventResponse.setETCData("pol_cd",
								indonesiaBkgDetailVO.getPolCd());
						eventResponse.setETCData("pod_cd",
								indonesiaBkgDetailVO.getPodCd());
						eventResponse.setETCData("del_cd",
								indonesiaBkgDetailVO.getDelCd());
					} else {
						eventResponse.setETCData("bl_no", "");
						eventResponse.setETCData("vvd", "");
						eventResponse.setETCData("por_cd", "");
						eventResponse.setETCData("pol_cd", "");
						eventResponse.setETCData("pod_cd", "");
						eventResponse.setETCData("del_cd", "");
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
	 * ESM_BKG_0304 : SEARCH <br>
	 * ESM_BKG_0470 : SEARCH <br>
	 * ESM_BKG_0493 : SEARCH <br>
	 * ESM_BKG_0494 : SEARCH <br>
	 * ESM_BKG_0015 : SEARCH <br>
	 * ESM_BKG_0359 : INIT <br>
	 * ESM_BKG_1104 : SEARCH <br>
	 * ESM_BKG_1171 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		List<VesselArrivalDetailVO> list = null;
		try {
			if ("EsmBkg0304Event".equalsIgnoreCase(e.getEventName())) { // India
				command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0304Event event = (EsmBkg0304Event) e;
				list = command.searchVesselArrival(event
						.getInVesselArrivalCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0015Event")) {
				EsmBkg0015Event event = (EsmBkg0015Event) e;
				command = new CndManifestListDownloadBCImpl();
				eventResponse.setRsVoList(command.searchVesselArrival(event
						.getVesselArrivalCondVO()));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command = new AncsManifestListDownloadBCImpl();
				// eventResponse.setRsVoList(command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO()));
				VesselArrivalVO vesselArrivalVO = command
						.searchVesselArrival2(event
								.getAncsCstmsVesselArrivalCondVO());
				if (vesselArrivalVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				else
					eventResponse.setRsVo(command.searchVesselArrival2(event
							.getAncsCstmsVesselArrivalCondVO()));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0493Event")) {
				EsmBkg0493Event event = (EsmBkg0493Event) e;
				command = new SriLankaManifestListDownloadBCImpl();
				List<SriLankaVesselArrivalDetailVO> sriLankaVesselArrivalDetailVOs = null;
				SriLankaVesselArrivalDetailVO siLankaVesselArrivalDetailVO = null;
				command = new SriLankaManifestListDownloadBCImpl();
				Map<String, String> etcData = new HashMap<String, String>();
				sriLankaVesselArrivalDetailVOs = (List<SriLankaVesselArrivalDetailVO>) (Object) (command
						.searchVesselArrival(event
								.getSriLankaVesselArrivalCondVO()));
				if (sriLankaVesselArrivalDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
					eventResponse.setETCData("sr_sts_cd", "");
					eventResponse.setETCData("rgst_dt", "");
					eventResponse.setETCData("rjct_dt", "");
					eventResponse.setETCData("vsl_auth_no", "");
					eventResponse.setETCData("sr_sts_desc", "");
					eventResponse.setETCData("sr_cmt_desc", "");
					eventResponse.setETCData("decl_bl_qty", "");
					return eventResponse;
				}
				// eventResponse.setRsVoList(command.searchVesselArrival2(event.getAncsCstmsVesselArrivalCondVO()));
				eventResponse.setRsVoList(sriLankaVesselArrivalDetailVOs);
				siLankaVesselArrivalDetailVO = sriLankaVesselArrivalDetailVOs
						.get(0);
				eventResponse.setETCData("sr_sts_cd",
						siLankaVesselArrivalDetailVO.getSrStsCd());
				eventResponse.setETCData("rgst_dt",
						siLankaVesselArrivalDetailVO.getRgstDt());
				eventResponse.setETCData("rjct_dt",
						siLankaVesselArrivalDetailVO.getRjctDt());
				eventResponse.setETCData("vsl_auth_no",
						siLankaVesselArrivalDetailVO.getVslAuthNo());
				eventResponse.setETCData("sr_sts_desc",
						siLankaVesselArrivalDetailVO.getSrStsDesc());
				eventResponse.setETCData("sr_cmt_desc",
						siLankaVesselArrivalDetailVO.getSrCmtDesc());
				eventResponse.setETCData("decl_bl_qty",
						siLankaVesselArrivalDetailVO.getDeclBlQty());
				eventResponse.setETCData(etcData);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0470Event")) {
				EsmBkg0470Event event = (EsmBkg0470Event) e;
				command = new JapanManifestListDownloadBCImpl();
				list = command.searchVesselArrival((VesselArrivalCondVO) event
						.getJapanVesselArrivalCondVO());
				eventResponse.setRsVoList(list);
				if (list.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0359Event")) {
				EsmBkg0359Event event = (EsmBkg0359Event) e;
				CustomsReportBC command2 = null;
				command2 = new UsaCustomsReportBCImpl();
				// 이벤트에서 vo 추출.
				TransmissionChkListCondVO cond = event.getCondVo();
				UsaVesselArrivalCondVO condvo = new UsaVesselArrivalCondVO();
				condvo.setVvd(cond.getVvd());
				condvo.setPort(cond.getPol());
				// BC 호출.
				List<UsaVesselArrivalDetailVO> volist = command2
						.searchVesselArrival(condvo);
				// 조회결과가 있는 경우 결과값 추출.
				if (volist != null) {
					eventResponse.setETCData("eta", volist.get(0).getEta());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1104Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				voList = command2.searchVesselArrival((Eur24VesselArrivalCondVO) event
								.getVesselArrivalCondVO(), account);
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1105Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				voList = command2.searchVesselArrival((Eur24VesselArrivalCondVO) event
								.getVesselArrivalCondVO(), account);
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				voList = command2.searchVesselByBL(event
						.getEur24VesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselArrivalNoticeDetailVO> voList = null;
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				voList = command2.searchVesselByBLOB(event
						.getEur24VesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1171Event")) {
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				List<Eur24VesselFIArrivalNoticeDetailVO> voList = null;
				EsmBkg1171Event event = (EsmBkg1171Event) e;
				voList = command2
						.searchVesselFIArrival((Eur24VesselArrivalCondVO) event
								.getVesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
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
	 * ESM_BKG_0234 : MULTI01 <br>
	 * DBF 파일생성해서 로컬로 파일 경로를 반환한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			EsmBkg0234Event event = (EsmBkg0234Event) e;
			command = new ManilaManifestListDownloadBCImpl();
			String filename = command.downloadManifest(event
					.getManifestListDetailVO());
			if(filename != null) {
				StringTokenizer st = new StringTokenizer(filename, "\n");
				List<ManilaManifestListCondVO> list = new ArrayList<ManilaManifestListCondVO>();
				int j = st.countTokens();
				for (int i=0; i<j; i++) {
					ManilaManifestListCondVO vo = new ManilaManifestListCondVO();
					vo.setFlatFile(st.nextToken());
					list.add(vo);
				}				
				eventResponse.setRsVoList(list);
			}
			eventResponse.setCustomData("filekey", filename);
			eventResponse.setETCData("filename", filename);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0216 : COMMAND01 <br>
	 * ESM_BKG_1046 : MULTI01 <br>
	 * ESM_BKG_1162 : MULTI01 <br>
	 * Container Manifest정보를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
				// EsmBkg0216Event event =(EsmBkg0216Event) e;
				// ManifestListDownloadBC command = new
				// ChinaManifestListDownloadBCImpl();
				// String filename =
				// command.downloadManifestList(event.getManifestListCondVO());
				// eventResponse.setCustomData("filekey", filename);

				EsmBkg0216Event event = (EsmBkg0216Event) e;
				ManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
				String down_csv = command.downloadManifestList(event
						.getManifestListCondVO());
				eventResponse.setETCData("down_csv", down_csv);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				// EsmBkg1046Event event =(EsmBkg1046Event) e;
				// CustomsTransmissionBC command = new
				// ChinaCustomsTransmissionBCImpl();
				// String filename =
				// command.downloadManifestList(event.getBlInfoCondVO());
				// eventResponse.setCustomData("filekey", filename);

				EsmBkg1046Event event = (EsmBkg1046Event) e;
				CustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
				String down_csv = command.downloadManifestList(event
						.getBlInfoCondVO());
				eventResponse.setETCData("down_csv", down_csv);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
				EsmBkg1162Event event = (EsmBkg1162Event) e;
				ManifestListDownloadBC command = new DominicanManifestDownloadBCImpl();
				String downXml = command.downloadManifestList(event
						.getManifestListCondVO());
				eventResponse.setETCData("down_xml", downXml);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {
				EsmBkg1163Event event = (EsmBkg1163Event) e;
				RussiaCustomsTransmissionBCImpl command = new RussiaCustomsTransmissionBCImpl();
				String cargoDown = command.transmitManifestCargoDown(event.getManifestTransmitVO());
				eventResponse.setETCData("cargo_down", cargoDown);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0045 : MULTI01 <br>
	 * ESM_BKG_0127 : MODIFY <br>
	 * ESM_BKG_0296 : MULTI <br>
	 * ESM_BKG_0442 : MULTI <br>
	 * ESM_BKG_0311 : MULTI <br>
	 * ESM_BKG_0002 : MODIFY <br>
	 * ESM_BKG_0210 : ADD <br>
	 * ESM_BKG_0210 : MULTI <br>
	 * ESM_BKG_0505 : MULTI <br>
	 * ESM_BKG_0031 : MULTI <br>
	 * ESM_BKG_0329 : REMOVE <br>
	 * ESM_BKG_0540 : MULTI <br>
	 * ESM_BKG_0551 : MULTI <br>
	 * ESM_BKG_0216 : MULTI <br>
	 * ESM_BKG_1033 : MULTI <br>
	 * ESM_BKG_0533 : MULTI <br>
	 * ESM_BKG_0408 : MULTI <br>
	 * ESM_BKG_1106 : MULTI <br>
	 * ESM_BKG_1121 : MULTI <br>
	 * 세관에 적하목록을 신고하기 위해 필요한 아이템을 저장하는 오퍼레이션<br>
	 * 
	 * @param Event
	 *            event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		BLDocumentationBLBC blCommand = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
				EsmBkg0002Event event = (EsmBkg0002Event) e;
				command = new CndManifestListDownloadBCImpl();
				event.getCstmsBlVOs()[0].setPgmNo("ESM_BKG_0002");
				command.manageCstmsBl(event.getCstmsBlVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.manageManifest(event.getBrCmModiVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
				EsmBkg0210Event event = (EsmBkg0210Event) e;
				if (event.getCustoms().endsWith("CA")) {
					// BackEnd
					command = new CndManifestListDownloadBCImpl();
					if (event.getManifestListDetailVOs()[0].getPgmNo() == null) {
						event.getManifestListDetailVOs()[0]
								.setPgmNo("ESM_BKG_0210");
					}
					String key = command.manageManifest(
							event.getManifestListDetailVOs(), account);
					eventResponse.setETCData("KEY", key);
				} else {
					command = new UsaManifestListDownloadBCImpl();
					String key = command.manageManifest(
							event.getManifestListDetailVOs(), account);
					eventResponse.setETCData("KEY", key);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0551Event")) {
				EsmBkg0551Event event = (EsmBkg0551Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageManifest(event.getAncsManifestModificationVO(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0296Event")) { // 인도
				EsmBkg0296Event event = (EsmBkg0296Event) e;
				command = new IndiaManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestModificationVOs(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0442Event")) { // rocs
				EsmBkg0442Event event = (EsmBkg0442Event) e;
				command = new RocsManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestModificationVOs(),
						account);

				RocsContainerSaveVO rocsContainerSaveVO = (RocsContainerSaveVO) (event
						.getManifestModificationVOs()[0]);
				RocsBlModificationVO rocsBlModificationVO = rocsContainerSaveVO
						.getRocsBlModificationVO();
				GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
				command2.modifyIbCustNmAddr(rocsBlModificationVO.getBkgNo(),
						rocsBlModificationVO.getNtfyAddr1(),
						rocsBlModificationVO.getNtfyAddr2(), account);

				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0311Event")) { // Indonesia
				EsmBkg0311Event event = (EsmBkg0311Event) e;
				blCommand = new BLDocumentationBLBCImpl();
				blCommand.manageManifest(
						event.getIndonesiaManifestModificationVOS(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
				EsmBkg0329Event event = (EsmBkg0329Event) e;
				command = new KorManifestListDownloadBCImpl();
				KorDlContainerVO cont = new KorDlContainerVO();
				KorMrnNoVO fromClient = event.getMrnNoVO();
				KorManifestInfoVO[] list = event.getManifestInfoVOs();
				KorBkgCntrQtyInfoVO[] cntrList = event.getCntrVOs();
				cont.setKorMrnNoVO(fromClient);
				cont.setKorManifestInfoVOs(list);
				cont.setKorBkgCntrQtyInfoVOs(cntrList);
				cont.setUser_id(account.getUsr_id());
				cont.setOffice(account.getOfc_cd());
				int delCount = command.manageManifest(cont);
				eventResponse
						.setETCData("delcount", Integer.toString(delCount));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageManifest(event.getAncsManifestModificationVO(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
				EsmBkg0533Event event = (EsmBkg0533Event) e;
				// BCImpl 객체 생성.
				command = new UsaManifestListDownloadBCImpl();
				// BC 호출.
				command.modifyInbondData(event.getUsaInbondManifestDetailVOS(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
				EsmBkg0408Event event = (EsmBkg0408Event) e;
				// BCImpl 객체 생성.
				command = new UsaManifestListDownloadBCImpl();
				// Event에서 파라미터 VO 추출.
				UsaInbondManifestListVO[] listVos = event
						.getUsaInbondManifestListVOS();
				UsaInbondManifestDetailListVO[] detailVOs = event
						.getUsaInbondManifestDetailListVOS();
				// InbondVO를 상속받은 UsaInbondContainerVO에 셋업후 파라미터로 BC 실행.
				UsaInbondContainerVO[] inbondVO = new UsaInbondContainerVO[1];
				inbondVO[0] = new UsaInbondContainerVO();
				inbondVO[0].setUsaInbondManifestListVOs(listVos);
				inbondVO[0].setUsaInbondManifestDetailListVOs(detailVOs);
				// PageNo 셋업.
				inbondVO[0].setPageNo("ESM_BKG_0408");
				/*
				 * 2009/10/23 책임테이블 문제로 inbondTransmissionBC에서 manifestDownBC로
				 * 이관.
				 */
				// BC 호출.
				command.modifyInbondData(inbondVO, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				command = new KorManifestListDownloadBCImpl();
				// 파라메터 객체
				KorManifestEditModificationVO condVO = new KorManifestEditModificationVO();
				// 파라메터 매핑
				condVO.setUserId(account.getUsr_id());
				condVO.setKorBlInqInfoVO(event.getKorBlInqInfoVO());
				condVO.setKorCntrInqInfoVOs(event.getKorCntrInqInfoVOs());
				condVO.setKorCustInqInfoVO(event.getKorCustInqInfoVO());
				condVO.setKorElnoInqInfoVOs(event.getKorElnoInqInfoVOs());
				// BC에 작업 요청
				command.manageManifest(condVO);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorManifestListDownloadBCImpl();
				// 화면에서 넘어온 값 VO 로 얻어옴
				KorManifestAmdManiVO condVO = event.getKorManifestAmdManiVO();
				// 값 매핑
				condVO.setUserId(account.getUsr_id());
				// BC에 작업 요청
				command.manageAmdManifest(condVO);
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				InbondTransmissionBC command2 = new UsaInbondTransmissionBCImpl();
				command2.modifyManifestList(event.getInbondManifestDetailVOs(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
				EsmBkg0216Event event = (EsmBkg0216Event) e;
				command = new ChinaManifestListDownloadBCImpl();
				String key = command.manageManifest(
						event.getManifestListDetailVOs(), account);
				eventResponse.setETCData("KEY", key);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1033Event")) { // 방글라데시
																				// 세관
				EsmBkg1033Event event = (EsmBkg1033Event) e;
				command = new BangladeshManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestModificationVO(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {

				EsmBkg0344Event event = (EsmBkg0344Event) e;
				command = new KorManifestListDownloadBCImpl();

				if (event.getFormCommand().isCommand(FormCommand.MULTI06)) {
					// 한국세관 0344 Transmit Empty Amend 처리
					KorEmpAmdManiVO[] korEmpAmdManiVOs = event
							.getKorEmpAmdManiVOs();
					KorAmendManifestTransmitVO korAmendManifestTransmitVO = event
							.getKorAmendManifestTransmitVO();

					if (korEmpAmdManiVOs != null) {
						// USR_ID 와 RECEIVER 설정
						for (int i = 0; i < korEmpAmdManiVOs.length; i++) {
							korEmpAmdManiVOs[i].setUsrId(account.getUsr_id());
							korEmpAmdManiVOs[i].setOfcCd(account.getOfc_cd());
							korEmpAmdManiVOs[i]
									.setReceiver(korAmendManifestTransmitVO
											.getReceiver());
						}
						korEmpAmdManiVOs = (KorEmpAmdManiVO[]) command
								.manageEmpAmdManifest(korEmpAmdManiVOs);

						// Transmit
						transmitEmpAmdManifest(korEmpAmdManiVOs);

						// 전송일시 UPDATE
						command.transmitEmpAmdManifest(korEmpAmdManiVOs);

						// 성공메시지세팅
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00218").getUserMessage());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}

				} else {
					// 한국세관 0344 Transmit 조회
					KorVslInfoNManifestCondVO condVO = event
							.getKorVslInfoNManifestCondVO();
					condVO.setUserId(account.getUsr_id());

					KorVslInfoNManifestVO korVslInfoNManifestVO = (KorVslInfoNManifestVO) command
							.manageVslInfoNManifestList(condVO);
					BkgCstmsKrVvdSmryVO bkgCstmsKrVvdSmryVO = korVslInfoNManifestVO
							.getBkgCstmsKrVvdSmryVO();
					if (bkgCstmsKrVvdSmryVO != null) {
						eventResponse.setETCData(bkgCstmsKrVvdSmryVO
								.getColumnValues());
					} else {
						// 조회결과 없을 경우
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				command.manageManifest(event.getManifestListDetailVOs(),
						account);
				commit();
				begin();
				// Inbound 호출
				CargoReleaseOrderBC ibCommand = new CargoReleaseOrderBCImpl();
				DubaiManifestListVO[] dubaiManifestListVOs = (DubaiManifestListVO[]) event
						.getManifestListDetailVOs();
				List<DubaiBlManifestListVO> dubaiBlManifestListVOs = dubaiManifestListVOs[0]
						.getDubaiBlManifestListVOs();
				DubaiManifestListCondVO dubaiManifestListCondVO = dubaiManifestListVOs[0]
						.getDubaiManifestListCondVO();
				DubaiCstmsVO[] dubaiCstmsVOs = new DubaiCstmsVO[dubaiBlManifestListVOs
						.size()];
				for (int i = 0; i < dubaiBlManifestListVOs.size(); i++) {
					dubaiCstmsVOs[i] = new DubaiCstmsVO();
					dubaiCstmsVOs[i].setBlNo(dubaiBlManifestListVOs.get(i)
							.getBlNo());
					dubaiCstmsVOs[i].setCstmsRefCtnt(dubaiManifestListCondVO
							.getRotnNo());
					dubaiCstmsVOs[i].setUsrId(account.getUsr_id());
				}
				ibCommand.modifyDubaiCstmsRefNo(dubaiCstmsVOs);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command.manageManifest(event.getEu24ManifestListVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				command = new Eur24ManifestDownloadBCImpl();
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command.manageManifestOB(event.getEu24ManifestListVOs(),
						account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());

			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : MULTI <br>
	 * ROCS(ROTTERDAM) 세관에 신고할 대상 Manifest List를 전송하기 전에 데이터를 확인했다는 의미로 Confirm
	 * Indicator를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0061Event event = (EsmBkg0061Event) e;
			command = new RocsManifestListDownloadBCImpl();
			command.confirmManifestList((ManifestConfirmationVO[]) event
					.getRocsManifestConfirmationVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0127 : MODIFY01<BR>
	 * ESM_BKG_0036 : MODIFY<BR>
	 * Container Manifest정보를 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyContainerManifest(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) { // 브라질
				EsmBkg0127Event event = (EsmBkg0127Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.modifyContainerManifest(
						event.getBrCnpiNcmByCntrModiVOs(), account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0036Event")) { // 미국
				EsmBkg0036Event event = (EsmBkg0036Event) e;
				command = new UsaManifestListDownloadBCImpl();
				command.modifyContainerManifest(
						event.getContainerManifestListVOs(), account);
				// 성공메시지세팅
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0351 : MULTI <br>
	 * 데이터 확인을 위한 BL List에서 B/L Seq를 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0351Event event = (EsmBkg0351Event) e;
			command = new RocsManifestListDownloadBCImpl();
			command.modifyBlSeq((BlSeqVO[]) event.getRocsBlSeqVOs(), account);
			// 성공메시지세팅
			// eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : MULTI02 <br>
	 * ROCS(ROTTERDAM) 세관 POL CD를 변경한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlPolCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {

				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsManifestListDownloadBCImpl();
				command.modifyBlPolCd(event.getRocsManifestTransmitVOs(),
						account);

				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0462 : MULTI <br>
	 * VVD,Port 등 입력 후 조회한 세관 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForDl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0462Event event = (EsmBkg0462Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageManifestForDl(event.getManifestModificationVOs(),
					account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00261")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : MULTI <br>
	 * VVD,Port 등 입력 후 조회한 세관 MFR 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForMfs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0730Event event = (EsmBkg0730Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageManifestForMfs(event.getManifestModificationVOs(),
					account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0002 : SEARCH01<BR>
	 * ManifestList 상세정보<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestDtlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			command = new CndCustomsTransmissionBCImpl();
			EsmBkg0002Event event = (EsmBkg0002Event) e;
			eventResponse.setRsVoList(command.searchManifestDtlList(event
					.getCstmsManifestCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		List<CstmsRcvHisVO> list = null;
		try {
			command = new CndCustomsTransmissionBCImpl();
			EsmBkg0431Event event = (EsmBkg0431Event) e;
			list = command.searchCstmsRcvHisList(event
					.getCstmsRcvHisListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0431 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1112Event")) { // EUR24
																		// -
																		// 구주세관
																		// ACK
																		// 수신
				Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
				List<Eur24RcvMsgVO> voList = null;
				EsmBkg1112Event event = (EsmBkg1112Event) e;
				voList = command3
						.searchCstmsRcvMsg((Eur24VesselArrivalCondVO) event
								.getVesselArrivalCondVO());
				eventResponse.setRsVoList(voList);
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
	 * ESM_BKG_0215 : SEARCH<BR>
	 * 한국세관 BKG_CSTMS_KR_BL table에 Data가 Insert되거나 Delete 될 경우에, <Br>
	 * BKG_CSTMS_KR_DL_HIS Table에 History를 조회한다.<Br>
	 * 
	 * @param Event
	 *            event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDownLoadHist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			EsmBkg0215Event event = (EsmBkg0215Event) e;
			command = new KorCustomsReportBCImpl();
			List<BkgCstmsKrDlHisVO> list = command.searchDownLoadHist(event
					.getCstmsVvdInfoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : SEARCH<BR>
	 * User Auth List 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1008Event event = (EsmBkg1008Event) e;
			command = new UsaManifestListDownloadBCImpl();
			List<AuthSetupListVO> list = command.searchAuthSetupList(event
					.getAuthSetupListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1008 : SEARCH01<BR>
	 * ESM_BKG_0013 : INIT<BR>
	 * ESM_BKG_0029 : INIT<BR>
	 * ESM_BKG_0034 : COMMAND01<BR>
	 * User name, office 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUiSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1008Event")) {
				EsmBkg1008Event event = (EsmBkg1008Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UserAuthListCondVO cond = (UserAuthListCondVO) event
						.getAuthSetupListCondVO();
				String userId = cond.getChUsrId();
				List<UserInfoVO> list2 = command.searchUserAuthority(userId);
				int listSize = list2.size();
				if (listSize > 0) {
					UserInfoVO vo = (UserInfoVO) list2.get(0);
					eventResponse.setETCData("search_usr_nm", vo.getUsrNm());
					eventResponse.setETCData("search_ofc_cd", vo.getOfcCd());
					eventResponse.setETCData("search_auth_count",
							vo.getAuthCount());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0494Event")) {
				BookingUtil command2 = null;
				EsmBkg0494Event event = (EsmBkg0494Event) e;
				command2 = new BookingUtil();
				List<BkgHrdCdgCtntVO> list = command2.searchHardCoding(event
						.getBkgHrdCdgCtntListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0013Event")) {
				// 하드코딩 테이블 정보조회(Util이 만들어지면 교체)
				BookingUtil bkgUtil = new BookingUtil();
				BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
				hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.CND_CSTMS_CRR_CD);
				List<BkgHrdCdgCtntVO> listUtil = bkgUtil
						.searchHardCoding(hrdCdgVO);
				for (int i = 0; i < listUtil.size(); i++) {
					BkgHrdCdgCtntVO vo = (BkgHrdCdgCtntVO) listUtil.get(i);
					eventResponse.setETCData(vo.getAttrCtnt1(),
							vo.getAttrCtnt2());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				// WGT 단위콤보
				eventResponse.setRsVoList(searchComCodeCombo("CD00775"));
				// trsp_tp_id 콤보
				eventResponse
						.setRsVoList(searchHardCoding(Constants.HrdCdgId.TRSPT_TP_ID));
				// 개발자 User Id 조회(Stage 수정권한)
				BookingUtil bkgUtil = new BookingUtil();
				BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
				hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.SCR_ROLE_DEF);
				hrdCdgVO.setAttrCtnt1("CND_CSTMS_BL_INQ_STS_UPD");
				hrdCdgVO.setAttrCtnt2("USR_ID");
				hrdCdgVO.setAttrCtnt3(account.getUsr_id());
				hrdCdgVO.setAttrCtnt4("Y");
				eventResponse.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				// WGT 단위콤보
				eventResponse.setRsVoList(searchComCodeCombo("CD00775"));
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
	 * ESM_BKG_1008 : MULTI<BR>
	 * User Auth List 정보수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAuthSetupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1008Event event = (EsmBkg1008Event) e;
			command = new UsaManifestListDownloadBCImpl();
			UserAuthListModiVO[] vos = (UserAuthListModiVO[]) event
					.getAuthSetupListVOS();
			for (int i = 0; i < vos.length; i++) {
				vos[i].setUpdUsrId(account.getUsr_id());
			}
			command.manageAuthSetupList(event.getAuthSetupListVOS());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1095 : MULTI<BR>
	 * User Auth List 정보수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAncsLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1095Event event = (EsmBkg1095Event) e;
			command = new AncsManifestListDownloadBCImpl();

			command.manageAncsLane(event.getBkgHrdCdgCtntVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0028 : SEARCH<BR>
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsManifestAmendment(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = new CndCustomsTransmissionBCImpl();
		try {
			// 이벤트별 Impl생성
			EsmBkg0028Event event = (EsmBkg0028Event) e;
			// Canada와 US 동일한 화면 사용
			if (CountryCode.CA.equals(event.getCntCd())) {
				command = new CndCustomsTransmissionBCImpl();
			} else if (CountryCode.US.equals(event.getCntCd())) {
				command = new UsaCustomsTransmissionBCImpl();
			}
			List<CstmsManifestAmendmentVO> list = command
					.searchCstmsManifestAmendment(event
							.getCstmsManifestAmendmentCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0028 : MULTI01<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/ 
	private EventResponse transDeleteAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String strBlNo = "";
		
		try {		
			EsmBkg0028Event event = (EsmBkg0028Event) e;
			
			if (CountryCode.US.equals(event.getCntCd())) {			
				UsaCstmsManifestAmendmentVO[] usaVO = (UsaCstmsManifestAmendmentVO[]) event.getCstmsManifestAmendmentVOs();
				ManifestListDownloadBC command = new UsaManifestListDownloadBCImpl();
				CustomsTransmissionBC commandEdi = new UsaCustomsTransmissionBCImpl();
				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
	
				begin();
	
				/*************************************************************
				 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다. 
				 * 삭제하면 BL No.의 경우 체크를 해제하고 다음 BL No.에 대한 삭제를 한다.
				 *************************************************************/			
				if ( usaVO.length > 0 ) {
					
					strBlNo = usaVO[0].getBlNo();
	
					//BKG_CSTMS_ADV_BL 테이블 수정 : ADV_BL delete				
					blKeyVO.setBlKey(CountryCode.US + strBlNo);
					command.removeBl((BlKeyVO) blKeyVO, account);
	
				    //03:Cancel
					UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
					usaDetailVOs[0] = new UsaManifestListDetailVO();				
					usaDetailVOs[0].setBlNo(strBlNo);
					usaDetailVOs[0].setCstmsMfTpCd("AI");
					usaDetailVOs[0].setCstmsTrsmStsCd("03");
					usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
					command.manageManifest(usaDetailVOs,account);
	
					 //삭제전송				
					UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
					usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
					usaDetailVO2s[0].setBlNo(strBlNo);
					usaDetailVO2s[0].setVvd(usaVO[0].getTVvdCd());
					usaDetailVO2s[0].setPol(usaVO[0].getPolCd());
					usaDetailVO2s[0].setPod(usaVO[0].getPodCd());
					usaDetailVO2s[0].setTransmitCd("AI");
					usaDetailVO2s[0].setUsrId(account.getUsr_id());
					usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
					commandEdi.transmitManifest(usaDetailVO2s);
					
				}
				commit();			
			
			} else if (CountryCode.CA.equals(event.getCntCd())) {
				
				CndCstmsManifestAmendmentVO[] cndVO = (CndCstmsManifestAmendmentVO[]) event.getCstmsManifestAmendmentVOs();				
				ManifestListDownloadBC command = new CndManifestListDownloadBCImpl();
				CustomsTransmissionBC commandEdi = new CndCustomsTransmissionBCImpl();
				
				begin();
				
				if ( cndVO.length > 0 ) {
					
					strBlNo = cndVO[0].getBlNo();
	
					//BKG_CSTMS_ADV_BL 테이블 수정 : ADV_BL delete
					CstmsBlVO[] cstms = new CstmsBlVO[1];		
					CndCstmsBlVO cndCstms = new CndCstmsBlVO();
					cndCstms.setPgmNo("ESM_BKG_0002");
					cndCstms.setBlNo(strBlNo);
					cndCstms.setMfStsCd("D");
					cstms[0] = cndCstms;					
					command.manageCstmsBl(cstms, account);
					
				    //03:Cancel
					ManifestListDetailVO[] detailVOs = new ManifestListDetailVO[1];
					CndManifestModificationVO cndDetailVO = new CndManifestModificationVO(); 
					cndDetailVO.setBlNo(strBlNo);
					cndDetailVO.setMfStsCd("D");
					cndDetailVO.setCstmsTrsmStsCd("03");
					cndDetailVO.setPgmNo("ESM_BKG_0029");
					detailVOs[0] = cndDetailVO;				
					command.manageManifest(detailVOs,account);
					CndManifestModificationVO cndVoX = (CndManifestModificationVO) detailVOs[0];
					
					 //삭제전송
					CndCstmsManifestVO cndCstmsManifestVO = new CndCstmsManifestVO();
					cndCstmsManifestVO.setBlNo(strBlNo);
					cndCstmsManifestVO.setMiSndDt(cndVoX.getEdiSndDt());
					cndCstmsManifestVO.setIbflag("R");
					String sFlatFile = commandEdi.transmitManifest(cndCstmsManifestVO,account);
					
					/***********************************************************
					 * EDI 전송 START
					 ***********************************************************/
					if (sFlatFile != null) {
						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(sFlatFile);
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CANCUS.IBMMQ.QUEUE"));
						BookingUtil utilCommand = new BookingUtil();
						FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
						
						if (flatFileAckVO.getAckStsCd().equals("E")){
							throw new EventException(new ErrorHandler("BKG00205",new String[] {}).getMessage());
						}
					}
					// 성공메시지 세팅
					eventResponse.setUserMessage(new ErrorHandler("BKG00204")
							.getUserMessage());
				}
				commit();		
				
			}
				
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());			

		} catch (EventException ex) {
			throw new EventException((String) new ErrorHandler("BKG40110",new String[] {"(BL:"+strBlNo+")"}).getMessage());
		} catch (Exception ex) {
			throw new EventException((String) new ErrorHandler("BKG40110",new String[] {"(BL:"+strBlNo+")"}).getMessage());
		}
		return eventResponse;		
	}	

	
	/**
	 * ESM_BKG_0028 : MULTI<BR>
	 * ESM_BKG_0031 : COMMAND01<BR>
	 * ESM_BKG_0344 : COMMAND07<BR>
	 * 세관에 수정된 적하목록 내역을 EDI를 통해 전송한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transAmendManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0028Event")) {
				EsmBkg0028Event event = (EsmBkg0028Event) e;
				if (CountryCode.US.equals(event.getCntCd())) {
					command = new UsaCustomsTransmissionBCImpl();
					UsaCstmsManifestAmendmentVO usaVO = (UsaCstmsManifestAmendmentVO) event
							.getCstmsManifestAmendmentVO();
					/*************************************************************
					 * Action Code에 따라 기능 수행
					 *************************************************************/
					for (int j = 0; j < usaVO.getActionCode().length(); j = j + 2) {
						if ("DN".equals(usaVO.getActionCode().substring(j,
								j + 2))) {
							// Download의 경우 Customs Data Download 화면과 동일하기 때문에
							// ManifestListDownloadBC를 호출함.
							ManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
							UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
							usaDetailVOs[0] = new UsaManifestListDetailVO();
							usaDetailVOs[0].setBkgNo(usaVO.getBkgNo());
							usaDetailVOs[0].setVslCd(usaVO.getTVvdCd()
									.substring(0, 4));
							usaDetailVOs[0].setSkdVoyNo(usaVO.getTVvdCd()
									.substring(4, 8));
							usaDetailVOs[0].setSkdDirCd(usaVO.getTVvdCd()
									.substring(8, 9));
							usaDetailVOs[0].setPodCd(usaVO.getPodCd());
							usaDetailVOs[0].setPolCd(usaVO.getPolCd());
							usaDetailVOs[0].setVPod(usaVO.getPodCd());
							usaDetailVOs[0].setVPol(usaVO.getPolCd());
							if (usaVO.getBVvdCd() == null
									|| usaVO.getBVvdCd().equals("")) {
								usaDetailVOs[0].setIfFlg("N");
							} else {
								usaDetailVOs[0].setIfFlg("Y");
							}
							usaDetailVOs[0].setBlType(usaVO.getMh());
							usaDetailVOs[0].setBlNos(usaVO.getBlNo());
							usaDetailVOs[0].setPgmNo("ESM_BKG_0028_DN");
							manifestListDownloadBC.manageManifest(usaDetailVOs,
									account);
						} else if ("DA".equals(usaVO.getActionCode().substring(
								j, j + 2))) {
							ManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
							UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
							usaDetailVOs[0] = new UsaManifestListDetailVO();
							usaDetailVOs[0].setBlNo(usaVO.getBlNo());
							usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
							usaDetailVOs[0].setMfStsCd("D");
							manifestListDownloadBC.manageManifest(usaDetailVOs,
									account);
						} else if ("RA".equals(usaVO.getActionCode().substring(
								j, j + 2))) {
							ManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
							UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
							usaDetailVOs[0] = new UsaManifestListDetailVO();
							usaDetailVOs[0].setBlNo(usaVO.getBlNo());
							usaDetailVOs[0].setMfStsCd("A");
							usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
							manifestListDownloadBC.manageManifest(usaDetailVOs,
									account);
						} else if ("AC".equals(usaVO.getActionCode().substring(
								j, j + 2))
								|| "DC".equals(usaVO.getActionCode().substring(
										j, j + 2))) {
							// Download가 아닌 경우
							ManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
							UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
							usaDetailVOs[0] = new UsaManifestListDetailVO();
							usaDetailVOs[0].setBlNo(usaVO.getBlNo());
							/***********************************************************
							 * 00:최초전송, 04:수정전송, 03:Cancel 전송
							 **********************************************************/
							usaDetailVOs[0].setCstmsMfTpCd("AI");
							if ("DC".equals(usaVO.getActionCode().substring(j,
									j + 2))) {
								usaDetailVOs[0].setCstmsTrsmStsCd("03");
							} else {
								usaDetailVOs[0].setCstmsTrsmStsCd("04");
							}
							usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
							// 원래는 여기에 있어야 하는데 MI, BL inquiry도 수정해야하므로 일단 코멘트
							manifestListDownloadBC.manageManifest(usaDetailVOs,
									account);

							// 미 세관 AI 전송 로직 호출
							UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
							usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
							usaDetailVO2s[0].setBlNo(usaVO.getBlNo());
							usaDetailVO2s[0].setVvd(usaVO.getTVvdCd());
							usaDetailVO2s[0].setPol(usaVO.getPolCd());
							usaDetailVO2s[0].setPod(usaVO.getPodCd());
							usaDetailVO2s[0].setTransmitCd("AI");
							usaDetailVO2s[0].setUsrId(account.getUsr_id());
							usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
							command.transmitManifest(usaDetailVO2s);

						}
					}
					/*************************************************************
					 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다. AI 성공하면 BL No.를 세팅해서
					 * 화면으로 전달하고 같은 BL No.의 경우 체크를 해제하고 다음 BL No.에 대한 AI를 시작한다.
					 *************************************************************/
					UsaCstmsManifestAmendmentVO vo = new UsaCstmsManifestAmendmentVO();
					vo.setBlNo(((UsaCstmsManifestAmendmentVO) event
							.getCstmsManifestAmendmentVO()).getBlNo());
					List<UsaCstmsManifestAmendmentVO> listOkBlNo = new ArrayList<UsaCstmsManifestAmendmentVO>();
					listOkBlNo.add(vo);
					eventResponse.setRsVoList(listOkBlNo);
					commit();
					begin();
					// CDL 자동전송
					this.transmitCdlEdi(vo.getBlNo());
				} else if (CountryCode.CA.equals(event.getCntCd())) {
					// Transmit
					command = new CndCustomsTransmissionBCImpl();
					// ManifestListDownloadBC
					ManifestListDownloadBC command2 = new CndManifestListDownloadBCImpl();
					// 파라메터
					CndCstmsManifestAmendmentVO cndVO = (CndCstmsManifestAmendmentVO) event
							.getCstmsManifestAmendmentVO();
					/*************************************************************
					 * Action Code에 따라 기능 수행
					 *************************************************************/
					for (int j = 0; j < cndVO.getActionCode().length(); j = j + 2) {
						if ("DN".equals(cndVO.getActionCode().substring(j,
								j + 2))) {
							// Download의 경우 Customs Data Download 화면과 동일하기 때문에
							CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
							cndManifestModificationVOs[0] = new CndManifestModificationVO();
							cndManifestModificationVOs[0].setBkgNo(cndVO
									.getBkgNo());
							cndManifestModificationVOs[0].setVslCd(cndVO
									.getTVvdCd().substring(0, 4));
							cndManifestModificationVOs[0].setSkdVoyNo(cndVO
									.getTVvdCd().substring(4, 8));
							cndManifestModificationVOs[0].setSkdDirCd(cndVO
									.getTVvdCd().substring(8, 9));
							if (cndVO.getBVvdCd() == null
									|| cndVO.getBVvdCd().equals("")) {
								cndManifestModificationVOs[0].setIfFlg("N");
							} else {
								cndManifestModificationVOs[0].setIfFlg("Y");
							}
							cndManifestModificationVOs[0].setBlType(cndVO
									.getMh());
							cndManifestModificationVOs[0].setBlNos(cndVO
									.getBlNo());
							cndManifestModificationVOs[0]
									.setPgmNo("ESM_BKG_0028");
							cndManifestModificationVOs[0].setBkgPodCd(cndVO
									.getBkgPodCd());
							cndManifestModificationVOs[0].setBkgDelCd(cndVO
									.getBkgDelCd());
							cndManifestModificationVOs[0].setPodCd(cndVO
									.getPodCd());
							cndManifestModificationVOs[0].setPolCd(cndVO
									.getPolCd());
							command2.manageManifest(cndManifestModificationVOs,
									account);
						} else if ("DA".equals(cndVO.getActionCode().substring(
								j, j + 2))) {
							CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
							cndManifestModificationVOs[0] = new CndManifestModificationVO();
							cndManifestModificationVOs[0].setBlNo(cndVO
									.getBlNo());
							cndManifestModificationVOs[0].setMfStsCd("D");
							command2.manageManifest(cndManifestModificationVOs,
									account);
						} else if ("RA".equals(cndVO.getActionCode().substring(
								j, j + 2))) {
							CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
							cndManifestModificationVOs[0] = new CndManifestModificationVO();
							cndManifestModificationVOs[0].setBlNo(cndVO
									.getBlNo());
							cndManifestModificationVOs[0].setMfStsCd("A");
							command2.manageManifest(cndManifestModificationVOs,
									account);
						} else if ("AC".equals(cndVO.getActionCode().substring(
								j, j + 2))
								|| "DC".equals(cndVO.getActionCode().substring(
										j, j + 2))) {
							CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
							cndManifestModificationVOs[0] = new CndManifestModificationVO();
							cndManifestModificationVOs[0].setBlNo(cndVO
									.getBlNo());

							/***********************************************************
							 * A6A:Manifest, S10:HB/L Manifest, E10:Empty B/L
							 **********************************************************/
							if ("M".equals(cndVO.getMh())) {
								cndManifestModificationVOs[0]
										.setCstmsMfTpCd("A6A");
								if ("M".equals(cndVO.getFullMtyCd())) {
									cndManifestModificationVOs[0]
											.setCstmsMfTpCd("E10");
								}
							} else {
								cndManifestModificationVOs[0]
										.setCstmsMfTpCd("S10");
							}
							/***********************************************************
							 * 00:최초전송, 04:수정전송, 03:Cancel 전송
							 **********************************************************/
							if ("DC".equals(cndVO.getActionCode().substring(j,
									j + 2))) {
								cndManifestModificationVOs[0]
										.setCstmsTrsmStsCd("03");
							} else {
								if ("".equals(cndVO.getCstmsTrsmStsCd())) {
									cndManifestModificationVOs[0]
											.setCstmsTrsmStsCd("00");
								} else {
									cndManifestModificationVOs[0]
											.setCstmsTrsmStsCd("04");
								}
							}
							command2.manageManifest(cndManifestModificationVOs,
									account);
							/***********************************************************
							 * 전송 FlatFile 만들어서 로그테이블에 등록
							 **********************************************************/
							// 전송시간세팅
							cndVO.setMiSndDt(cndManifestModificationVOs[0]
									.getEdiSndDt());
							command.transAmendManifest(cndVO, account);
						}
					}
					/*************************************************************
					 * 화면에서 체크는 여러건 하지만 내부적으로 1건씩 SC를 호출한다.<br>
					 * AI 성공하면 BL No.를 세팅해서 화면으로 전달하고 같은 BL No.의 경우 체크를 해제하고<br>
					 * 다음 BL No.에 대한 AI를 시작한다.
					 *************************************************************/
					CndCstmsManifestAmendmentVO vo = new CndCstmsManifestAmendmentVO();
					vo.setBlNo(((CndCstmsManifestAmendmentVO) event
							.getCstmsManifestAmendmentVO()).getBlNo());
					List<CndCstmsManifestAmendmentVO> listOkBlNo = new ArrayList<CndCstmsManifestAmendmentVO>();
					listOkBlNo.add(vo);
					eventResponse.setRsVoList(listOkBlNo);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorCustomsTransmissionBCImpl();
				ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				KorAmdManifestTransmitVO condVO = event
						.getKorAmdManifestTransmitVO();
				KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();
				// KorAmdBlInfoVO korAmdBlInfoVO = new KorAmdBlInfoVO();
				// 파라메터 설정
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				String portCd = null;

				// BC에 작업 요청
				String transSndChk = command.transAmdManifest(condVO);
				if (transSndChk != null) {

					// PORT_CD
					if (condVO.getKorBlAmdVO().getIoBndCd().equals("O")) {
						portCd = condVO.getKorBlAmdVO().getPolCd();
					} else {
						portCd = condVO.getKorBlAmdVO().getPodCd();
					}

					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getKorBlAmdVO().getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getKorBlAmdVO()
							.getCstmsDeclTpCd());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(transSndChk);
					korBlInfoKorVO.setSmtAmdNo(condVO.getKorBlAmdVO()
							.getSmtAmdNo());
					korBlInfoKorVO.setCstmsBlNo(condVO.getKorBlAmdVO()
							.getBlNo());
					korBlInfoKorVO.setDmstPortCd(condVO.getDmstPortCd());
					korBlInfoKorVO.setCTrnsSeq(condVO.getCTrnsSeq());
					// 전송일시 UPDATE 처리
					command2.transAmdManifest(korBlInfoKorVO);
				} else {

					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getKorBlAmdVO().getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getKorBlAmdVO()
							.getCstmsDeclTpCd());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(condVO.getKorBlAmdVO()
							.getTrnsSeq());
					korBlInfoKorVO.setSmtAmdNo(condVO.getKorBlAmdVO()
							.getSmtAmdNo());
					korBlInfoKorVO.setCstmsBlNo(condVO.getKorBlAmdVO()
							.getBlNo());
					korBlInfoKorVO.setDmstPortCd(condVO.getDmstPortCd());
					korBlInfoKorVO.setCTrnsSeq(condVO.getCTrnsSeq());
				}
				command2.modifySndFlg(korBlInfoKorVO);
				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0344Event")) {
				// Cancel Per B/L 처리
				EsmBkg0344Event event = (EsmBkg0344Event) e;
				KorCancelManifestTransmitVO condVO = event
						.getKorCancelManifestTransmitVO();
				command = new KorCustomsTransmissionBCImpl();
				ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
				KorBlInfoKorVO korBlInfoKorVO = new KorBlInfoKorVO();
				// 파라메터 설정
				condVO.setUserId(account.getUsr_id());
				condVO.setOfcCd(account.getOfc_cd());
				String portCd = null;

				// BC에 작업 요청
				String transSndChk = command.transCancelManifest(condVO);

				if (transSndChk != null) {

					// PORT_CD
					if (condVO.getIoBndCd().equals("O")) {
						portCd = condVO.getPolCd();
					} else {
						portCd = condVO.getPodCd();
					}

					korBlInfoKorVO.setUserId(condVO.getUserId());
					korBlInfoKorVO.setBkgNo(condVO.getBkgNo());
					korBlInfoKorVO.setCstmsDeclTpCd(condVO.getInType());
					korBlInfoKorVO.setPortCd(portCd);
					korBlInfoKorVO.setTrnsSeq(transSndChk);
					korBlInfoKorVO.setCstmsBlNo(condVO.getBlNo());

					// 전송일시 UPDATE 처리
					command2.transAmdManifest(korBlInfoKorVO);
				}

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0574 : SEARCH<BR>
	 * Scac Report 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchScacReportByVvdPod(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0574Event event = (EsmBkg0574Event) e;
			command = new UsaCustomsReportBCImpl();
			List<ScacReportDetailVO> list = command
					.searchScacReportByVvdPod(event.getScacReportCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0574 : SEARCH01<BR>
	 * ESM_BKG_0041 : SEARCH01<BR>
	 * Ams Pod 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0574Event event = (EsmBkg0574Event) e;
			command = new UsaCustomsReportBCImpl();
			String amsCode = command.searchCodeConversion(event
					.getScacReportCondVO().getPod());
			eventResponse.setETCData("ams_pod", amsCode);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0551 : SEARCH01<BR>
	 * 세관 신고용 VVD 목록 조회<br>
	 * 
	 * @param cstmsVvdInfoCondVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsVvdDtlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			EsmBkg0551Event event = (EsmBkg0551Event) e;
			command = new AncsManifestListDownloadBCImpl();
			List<CstmsVvdDtlVO> list = command.searchCstmsVvdDtlList(event
					.getAncsCstmsVvdDtlListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0434 : SEARCH<BR>
	 * Receive History Detail<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0434Event event = (EsmBkg0434Event) e;
			command = new CndCustomsTransmissionBCImpl();
			List<CstmsRcvLogDtlVO> list = command.searchCstmsRcvLogDtl(event
					.getCstmsRcvLogDtlCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0183 : SEARCH<BR>
	 * ESM_BKG_0186 : SEARCH<BR>
	 * ESM_BKG_0500 : SEARCH<BR>
	 * SendLog History Detail<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsSndHisList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0500Event")) {
				EsmBkg0500Event event = (EsmBkg0500Event) e;
				command = new CndCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event
						.getCstmsSndHisListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0186Event")) {
				EsmBkg0186Event event = (EsmBkg0186Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event
						.getAncsCstmsSndHisListCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0183Event")) {
				EsmBkg0183Event event = (EsmBkg0183Event) e;
				command = new AncsCustomsTransmissionBCImpl();
				List<CstmsSndHisVO> list = command.searchCstmsSndHisList(event
						.getAncsCstmsSndHisListCondVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0501 : SEARCH<BR>
	 * SendLog History Detail<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsSndLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0501Event event = (EsmBkg0501Event) e;
			command = new CndCustomsTransmissionBCImpl();
			List<CstmsSndLogDtlVO> list = command.searchCstmsSndLogDtl(event
					.getCstmsSndLogDtlCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0819 : SEARCH<BR>
	 * ESM_BKG_0041 : SEARCH<BR>
	 * ESM_BKG_0428 : SEARCH <br>
	 * ESM_BKG_0429 : SEARCH <br>
	 * Mi Transmit/Receive History 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0819Event")) {
				EsmBkg0819Event event = (EsmBkg0819Event) e;
				command = new UsaCustomsReportBCImpl();
				List<AmsReportListDetailVO> list = command
						.searchAmsReportList(event.getMiTransmitHistoryCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0041Event")) {
				EsmBkg0041Event event = (EsmBkg0041Event) e;
				command = new UsaCustomsReportBCImpl();
				UsaAmsReportListCondVO vo = event.getCondVO();
				vo.setTmp2(account.getCnt_cd());
				List<AmsReportListDetailVO> list = command
						.searchAmsReportList(vo);
				if ("ISF5".equals(vo.getGeneralOrRail())) {
					int manifest = 0;
					int accepted = 0;
					int rejected = 0;
					int none = 0;
					int target = 0;
					int unmanifest = 0;
					for (int i = 0; i < list.size(); i++) {
						UsaAmsReportIsf5ListVO isf5 = (UsaAmsReportIsf5ListVO) list
								.get(i);
						// 대상BL(모든BL)
						target++;
						if ("".equals(isf5.getIsfActCd())) {
							unmanifest++;
						} else {
							manifest++;
							if ("".equals(isf5.getIsfRsltCd())) {
								none++;
							} else if ("01".equals(isf5.getIsfRsltCd())) {
								rejected++;
							} else if ("02,03".indexOf(isf5.getIsfRsltCd()) >= 0) {
								accepted++;
							}
						}
					}
					eventResponse.setETCData("manifest", manifest + "");
					eventResponse.setETCData("accepted", accepted + "");
					eventResponse.setETCData("rejected", rejected + "");
					eventResponse.setETCData("none", none + "");
					eventResponse.setETCData("target", target + "");
					eventResponse.setETCData("unmanifest", unmanifest + "");
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event")) {
				EsmBkg0428Event event = (EsmBkg0428Event) e;
				command = new UsaCustomsReportBCImpl();
				List<RcvHistDetailVO> list = command.searchReceiveHist(event
						.getRcvHistCondVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0429Event")) {
				EsmBkg0429Event event = (EsmBkg0429Event) e;
				command = new UsaCustomsReportBCImpl();
				List<ReceiveLogDetailVO> list = command.searchReceiveLog(event
						.getReceiveLogCondVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0450 : SEARCH01 <br>
	 * ESM_BKG_0507 : SEARCH <br>
	 * ESM_BKG_0508 : SEARCH <br>
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				EsmBkg0507Event event = (EsmBkg0507Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistListDetailVO> list = command
						.searchTransmitHistList(event
								.getTransmitHistListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
				EsmBkg0508Event event = (EsmBkg0508Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistFileDetailVO> list = command
						.searchTransmitHistFile(event
								.getTransmitHistFileCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					eventResponse.setRsVoList(list);
					eventResponse.setCustomData("filePath", list.get(0)
							.getFilePath());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
				EsmBkg0450Event event = (EsmBkg0450Event) e;
				RocsManifestListDownloadBCImpl command2 = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<TransmitHistVO> list = command2
						.searchTransmitHistList(event
								.getRocsTransmitHistListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0142 : SEARCH<BR>
	 * ACI Report<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsTrsmRsltList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event
					.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0142 : SEARCH01<BR>
	 * ACI Report<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsDoNotLoadAndRemoveList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event
					.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0142 : SEARCH02<BR>
	 * ACI Report<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsHoldAndRemoveList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0142Event event = (EsmBkg0142Event) e;
			command = new CndCustomsTransmissionBCImpl();
			eventResponse.setRsVoList(command.searchCstmsTrsmRsltList(event
					.getCstmsTrsmRsltListCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0440 : SEARCH <br>
	 * ESM_BKG_0443 : SEARCH, SEARCH01, SEARCH02, SEARCH03<br>
	 * ESM_BKG_0444 : SEARCH<br>
	 * 세관에 적하목록을 신고시 필요한 Vessel Details 데이타를 조회하는 오퍼레이션<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselArrivalListInRocs(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				EsmBkg0444Event event = (EsmBkg0444Event) e;
				command = new RocsManifestListDownloadBCImpl();
				Map<String, String> etcData = new HashMap<String, String>();
				List<VesselArrivalVO> list = command.searchVesselArrival(event
						.getRocsVesselArrivalCondVO());
				RocsSearchVesselArrivalVO rocsSearchVesselArrivalVO = null;
				if (list.size() == 0) {
					eventResponse.setETCData("vvd_number", "");
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
					return eventResponse;
				}
				if (list.size() > 0) {
					rocsSearchVesselArrivalVO = (RocsSearchVesselArrivalVO) list
							.get(0);
					eventResponse.setRsVoList(list);
					eventResponse.setETCData("vvd_number",
							rocsSearchVesselArrivalVO.getVvdNumber());
				}
				eventResponse.setETCData(etcData);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0440Event")) {
				EsmBkg0440Event event = (EsmBkg0440Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRN((ManifestListCondVO) event
						.getRocsManifestListCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
					return eventResponse;
				}
				eventResponse.setRsVoList(list);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				eventResponse.setETCData("frm_vsl_eng_nm", "");
				eventResponse.setETCData("frm_vps_eta_dt", "");
				eventResponse.setETCData("frm_vvd_number", "");
				eventResponse.setETCData("err_msg", "");
				// Vessel Port Schedule에 등록된 VVD가 아닌 경우
				List<CrnVO> list = command.searchCRNInfo(event.getVslCd(),
						event.getSkdVoyNo(), event.getSkdDirCd());
				RocscrnVO rocscrnVO = null;
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00163")
							.getUserMessage());
					eventResponse.setETCData("frm_vsl_eng_nm", "");
					eventResponse.setETCData("frm_vps_eta_dt", "");
					eventResponse.setETCData("frm_vvd_number", "");
					return eventResponse;
				} else {
					String crn_number = event.getFrm_crn_number();
					event.getRocsManifestListCondVO().setCrnNumber("");
					List<CrnVO> list2 = command
							.searchCRN((ManifestListCondVO) event
									.getRocsManifestListCondVO());
					rocscrnVO = (RocscrnVO) list.get(0);
					eventResponse.setETCData("frm_vsl_eng_nm",
							rocscrnVO.getVslEngNm());
					eventResponse.setETCData("frm_vps_eta_dt",
							rocscrnVO.getVpsEtaDt());
					eventResponse.setETCData("frm_vvd_number",
							rocscrnVO.getVvdNumber());
					if (list2.size() > 0) {
						RocsSearchCRNVO vo = (RocsSearchCRNVO) list2.get(0);
						String cn_number = vo.getCrnNumber().toString();
						if (crn_number.length() > 0
								&& !crn_number.equalsIgnoreCase(cn_number)) {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00547").getUserMessage());
							eventResponse.setETCData("err_msg", "BKG00547");
							return eventResponse;
						}
					}
					// eventResponse.setRsVoList(list);
				}
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command.searchCRN(event.getFrm_crn_number(),
						event.getVslCd(), event.getSkdVoyNo(),
						event.getSkdDirCd());
				eventResponse.setRsVoList(list);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				List<CrnVO> list = command
						.searchCRNInfo((ManifestListCondVO) event
								.getRocsManifestListCondVO());
				if (list.size() > 0) {
					eventResponse.setRsVoList(list);
				}

				if (!event
						.getRocsManifestListCondVO()
						.getIbflag()
						.equals(event.getRocsManifestListCondVO()
								.getCrnNumber())) {
					/*
					 * in vo 에 crn 값만 남기고 나머지 값은 null
					 */
					event.getRocsManifestListCondVO().setVslCd("");
					event.getRocsManifestListCondVO().setSkdVoyNo("");
					event.getRocsManifestListCondVO().setSkdDirCd("");
					list = command.searchCRNInfo((ManifestListCondVO) event
							.getRocsManifestListCondVO());
					if (list.size() > 0) {
						// exception 발생

						RocscrnVO crnVO = (RocscrnVO) list.get(0);
						String arr[] = new String[1];
						arr[0] = crnVO.getVslCd() + crnVO.getSkdVoyNo()
								+ crnVO.getSkdDirCd();

						eventResponse.setETCData("err_msg", "BKG06142");
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG06142", arr).getUserMessage());

					}
				}
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				/*List<CrnVO> list = command
						.searchCRNInfo((ManifestListCondVO) event
								.getRocsManifestListCondVO());*/
				
				//2015.04.20 [CHM-201534307] [ROCS] 네덜란드 세관 더블콜링 보완 관련  
				List<CrnVO> list = command.searchCRN((ManifestListCondVO) event
						.getRocsManifestListCondVO());
				
				// end.
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
					return eventResponse;
				}
				eventResponse.setRsVoList(list);
			}else if (e.getEventName().equalsIgnoreCase("EsmBkg0443Event")
					&& e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				EsmBkg0443Event event = (EsmBkg0443Event) e;
				command = new RocsManifestListDownloadBCImpl();
				
				// VVD가 RTM VSL에서 CANCEL되지 않고, NLRTM을 지나가는  Vessel인지 확인
				List<VesselVO> list = command.searchVvdInfo((ManifestListCondVO) event.getRocsManifestListCondVO());
				
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0029 : MODIFY<BR>
	 * ESM_BKG_0029 : REMOVE<BR>
	 * ESM_BKG_0045 : MULTI<BR>
	 * 세관 테이블에 Customr, Container, Commodity(CM) 등의 BL 정보를 생성, 수정, 삭제 한다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				command = new CndManifestListDownloadBCImpl();
				String msgCd = "BKG00166";
				if (e.getFormCommand().isCommand(FormCommand.REMOVE)
						|| e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
					/*************************************************
					 * ESM_BKG_0002 : MF_STS_CD 수정 ESM_BKG_0029 : MF_STS_CD,
					 * CSTMS_TRSM_STS_CD 수정
					 *************************************************/
					event.getCstmsBlVOs()[0].setPgmNo("ESM_BKG_0002");
					if ("D".equals(((CndCstmsBlVO) (event.getCstmsBlVOs()[0]))
							.getMfStsCd())) {
						msgCd = "BKG00593";
					}
				}
				// 수정
				command.manageCstmsBl(event.getCstmsBlVOs(), account);
				// 저장성공메시지
				eventResponse.setUserMessage(new ErrorHandler(msgCd)
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0045Event")) {
				EsmBkg0045Event event = (EsmBkg0045Event) e;
				command = new AncsManifestListDownloadBCImpl();
				AncsCstmsBlContainerVO ancsCstmsBlContainerVO = new AncsCstmsBlContainerVO();
				AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = new AncsCstmsBlContainerVO[1];
				AncsCstmsBlVO[] ancsCstmsBlVOs = event.getAncsCstmsBlVOs();
				AncsCstmsBlNtfyVO[] ancsCstmsBlNtfyVOs = event
						.getAncsCstmsBlNtfyVOs();
				if (ancsCstmsBlVOs != null && ancsCstmsBlVOs.length > 0)
					ancsCstmsBlContainerVO.setAncsCstmsBlVO(ancsCstmsBlVOs[0]);
				if (ancsCstmsBlNtfyVOs != null && ancsCstmsBlNtfyVOs.length > 0)
					ancsCstmsBlContainerVO
							.setAncsCstmsBlNtfyVO(ancsCstmsBlNtfyVOs[0]);
				ancsCstmsBlContainerVO.setAncsCstmsCntrVOArrys(event
						.getAncsCstmsCntrVOs());
				ancsCstmsBlContainerVO.setBkgCstmsAnrCmdtVOs(event
						.getBkgCstmsAnrCmdtVOs());
				ancsCstmsBlContainerVOs[0] = ancsCstmsBlContainerVO;
				command.manageCstmsBl(ancsCstmsBlContainerVOs, account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1087Event")) {
				EsmBkg1087Event event = (EsmBkg1087Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				command.manageCstmsBl(event.getCstmsBlVOs(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0063 : SEARCH02 <br>
	 * 세관 적하 목록 상세 정보를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsMfDtlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0063Event event = (EsmBkg0063Event) e;
			command = new AncsManifestListDownloadBCImpl();
			eventResponse.setRsVoList(command.searchCstmsMfDtlList(event
					.getAncsCstmsMfDtlCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0217 : <br>
	 * ESM_BKG_1046 : <br>
	 * ESM_BKG_0494 : <br>
	 * HardCoding Table 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(Event e, String hrdCdgId)
			throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
		hrdCdgVO.setHrdCdgId(hrdCdgId);

		String transMode = null;
		String prefix = null;
		StringBuffer sb = new StringBuffer();
		BkgHrdCdgCtntVO tempVO = null;
		List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
		try {
			if ("TRSM_MSG_TP_ID".equalsIgnoreCase(hrdCdgId)) {
				// 이벤트별 Where 조건 생성
				if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
					EsmBkg0217Event event = (EsmBkg0217Event) e;
					transMode = event.getTransMode();
				} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
					EsmBkg1046Event event = (EsmBkg1046Event) e;
					transMode = event.getTransMode();
				}

				if ("O".equals(transMode)) {
					prefix = "O1";
					hrdCdgVO.setAttrCtnt5(transMode);
				} else if ("D".equals(transMode)) {
					prefix = "O2";
					hrdCdgVO.setAttrCtnt4(transMode);
				} else if ("P".equals(transMode)) {
					prefix = "P1";
					hrdCdgVO.setAttrCtnt6(transMode);
				}
			}

			bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);

			if ("TRSM_MSG_TP_ID".equalsIgnoreCase(hrdCdgId)) {
				for (int i = 0; i < bkgHrdCdgCtntVOs.size(); i++) {
					tempVO = (BkgHrdCdgCtntVO) bkgHrdCdgCtntVOs.get(i).clone();
					if (sb.length() > 0) {
						sb.delete(0, sb.length());
					}
					sb.append(prefix).append(":");
					sb.append(tempVO.getAttrCtnt2());
					bkgHrdCdgCtntVOs.get(i).setAttrCtnt2(sb.toString());
				}
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return bkgHrdCdgCtntVOs;
	}

	/**
	 * ESM_BKG_0142 : INIT <br>
	 * ESM_BKG_0025 : INIT <br>
	 * HardCoding Table 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(String hrdCdgId)
			throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(hrdCdgId);
			return bkgUtil.searchHardCoding(hrdCdgVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_0990 : MULTI <br>
	 * ESM_BKG_0444 : MULTI <br>
	 * ESM_BKG_1017 : MULTI <br>
	 * download 후 B/L을 추가 할 수 있다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0990Event")) {
				begin();
				EsmBkg0990Event event = (EsmBkg0990Event) e;
				command = new JapanManifestListDownloadBCImpl();
				command.addBl((BlVO) event.getJapanBlVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
				commit();
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")
					|| e.getEventName().equalsIgnoreCase("EsmBkg1017Event")) {
				begin();
				if (e.getEventName().equalsIgnoreCase("EsmBkg0444Event")) {
					EsmBkg0444Event event = (EsmBkg0444Event) e;
					command = new RocsManifestListDownloadBCImpl();
					command.addBl(event.getBlVO(), account);
				} else {
					EsmBkg1017Event event = (EsmBkg1017Event) e;
					command = new RocsManifestListDownloadBCImpl();
					command.addBl(event.getBlVO(), account);
				}
				commit();
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00574")
						.getUserMessage());
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0456 : SEARCH <br>
	 * 일본세관 신고 대상 Customer 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfrCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0456Event event = (EsmBkg0456Event) e;
			JapanManifestListMfrCustInfoVO japanManifestListMfrCustInfoVO = new JapanManifestListMfrCustInfoVO();
			command = new JapanManifestListDownloadBCImpl();
			japanManifestListMfrCustInfoVO = (JapanManifestListMfrCustInfoVO) command
					.searchMfrCust((ManifestListCondVO) event
							.getJapanManifestListMfrCondVO());
			eventResponse.setRsVo(japanManifestListMfrCustInfoVO);
			if (japanManifestListMfrCustInfoVO.getBlNumber().equals("")
					|| japanManifestListMfrCustInfoVO.getBlNumber() == null)
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0456 : MULTI <br>
	 * 일본세관 신고 대상 Customer 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			begin();
			EsmBkg0456Event event = (EsmBkg0456Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageMfrCust((MfrCustModificationVO) event
					.getJapanMfrCustModificationVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0455 : SEARCH <br>
	 * 일본세관 신고 대상 Container 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchMfrCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			EsmBkg0455Event event = (EsmBkg0455Event) e;
			List<JapanManifestListMfrCntrInfoVO> japanManifestListMfrCntrInfoVOs = null;
			command = new JapanManifestListDownloadBCImpl();
			japanManifestListMfrCntrInfoVOs = (List<JapanManifestListMfrCntrInfoVO>) (Object) command
					.searchMfrCntr((ManifestListCondVO) event
							.getJapanManifestListMfrCondVO());
			eventResponse.setRsVoList(japanManifestListMfrCntrInfoVOs);
			// 성공메시지세팅
			if (japanManifestListMfrCntrInfoVOs.size() == 0)
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0455 : MULTI <br>
	 * 일본세관 신고 대상 Container 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0455Event event = (EsmBkg0455Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageMfrCntr((MfrCntrModificationVO[]) event
					.getJapanMfrCntrModificationVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0034 : SEARCH <br>
	 * searchUserAuthority 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthority(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		String usrId = account.getUsr_id();
		command = new UsaManifestListDownloadBCImpl();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				UserAuthListModiVO userAuthVO = (UserAuthListModiVO) command
						.searchUserAuthority(usrId, account.getOfc_cd());
				if (userAuthVO != null) {
					eventResponse.setETCData(userAuthVO.getColumnValues());
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
	 * ESM_BKG_0613 : INIT <br>
	 * ESM_BKG_0615 : INIT <br> 
	 * ESM_BKG_0507 : INIT <br>
	 * searchUserAuthYn 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthYn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		String usrId = account.getUsr_id();
		command = new UsaManifestListDownloadBCImpl();
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				String retVal = command.searchUserAuthYn(usrId, "ESM_BKG_0613");
				String retVal2 = command.searchUserAuthMiMultiYn(usrId);
				eventResponse.setETCData("user_auth_str", retVal);
				eventResponse.setETCData("user_auth_mi_multi_str", retVal2);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
				String retVal = command.searchUserAuthYn(usrId, "ESM_BKG_0615");
				String retVal2 = command.searchUserAuthMiMultiYn(usrId);
				eventResponse.setETCData("user_auth_str", retVal);
				eventResponse.setETCData("user_auth_mi_multi_str", retVal2);				
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				String retVal = command.searchUserAuthYn(usrId, "ESM_BKG_0507");
				eventResponse.setETCData("user_auth_str", retVal);
		        //RHQ 추가
				BookingUtil utilCommand = new BookingUtil();
		        List<BkgComboVO> list = utilCommand.searchRgnOfficeCd();
		        BkgComboVO combovo = new BkgComboVO();
		        combovo.setVal(" ");
				combovo.setDesc("");
				list.add(0,combovo);
		        eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0034 : MULTI <br>
	 * bl 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse correctBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0034Event event = (EsmBkg0034Event) e;
			command = new UsaManifestListDownloadBCImpl();
			UsaBlDetailContainerVO containerVO = new UsaBlDetailContainerVO();
			containerVO.setBlNo(event.getBlNo());
			containerVO.setBlCstms(event.getBlCstms());
			containerVO.setOldAiBlInfoVO(event.getOldAiBlInfoVOs()[0]);
			containerVO.setNewAiBlInfoVO(event.getUsaAiBlInfoVOs()[0]);
			containerVO.setOldBlCustVOs(event.getOldBlCustVOs());
			containerVO.setNewBlCustVOs(event.getUsaBlCustVOs());
			containerVO.setOldBlCustomerSecondVOs(event
					.getOldBlCustomerSecondVOs());
			containerVO.setNewBlCustomerSecondVOs(event
					.getUsaBlCustomerSecondVOs());
			command.correctBl(containerVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : REMOVE <br>
	 * ESM_BKG_0034 : SEARCH03 <br>
	 * ESM_BKG_0613 : REMOVE01 <br>
	 * ESM_BKG_0615 : REMOVE01 <br> 
	 * ROCS(ROTTERDAM) 세관 Manifest 신고용 B/L 정보를 삭제한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
				EsmBkg0061Event event = (EsmBkg0061Event) e;
				command = new RocsManifestListDownloadBCImpl();
				RocsManifestConfirmationVO[] listVO = event
						.getRocsManifestConfirmationVOs();
				List<BlKeyVO> rocsBlKeyVOs = new ArrayList<BlKeyVO>();
				if (listVO.length > 0) {
					RocsBlKeyVO tempvo = null;
					for (int i = 0; i < listVO.length; i++) {
						tempvo = new RocsBlKeyVO();
						tempvo.setBlNO(listVO[i].getBlNo());
						tempvo.setBlTpCd(listVO[i].getBlTpCd());
						tempvo.setCrnNumber(listVO[i].getFrmCrnNumber());
						rocsBlKeyVOs.add(tempvo);
					}
				}
				command.removeBl(rocsBlKeyVOs, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00593")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
				EsmBkg0613Event event = (EsmBkg0613Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaManifestSearchDetailVO[] listVO = event
						.getUsaManifestSearchDetailVOS();

				int listSize = listVO.length;
				String deleteBl = "";
				for (int i = 0; i < listSize; i++) {
					if ("D".equals(listVO[i].getIbflag())) {
						deleteBl = listVO[i].getBlNo();
						break;
					}
				}

				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey("US" + deleteBl);
				blKeyVO.setHisTpId("MIS");
				blKeyVO.setUsrId(account.getUsr_id());
				BlKeyVO b = (BlKeyVO) blKeyVO;
				command.removeBl(b, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00593")
						.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
				EsmBkg0615Event event = (EsmBkg0615Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaManifestSearchDetailVO[] listVO = event.getUsaManifestSearchDetailVOS();

				int listSize = listVO.length;
				String deleteBl = "";
				for (int i = 0; i < listSize; i++) {
					if ("D".equals(listVO[i].getIbflag())) {
						deleteBl = listVO[i].getBlNo();
						break;
					}
				}

				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey("US" + deleteBl);
				blKeyVO.setHisTpId("MIS");
				blKeyVO.setUsrId(account.getUsr_id());
				BlKeyVO b = (BlKeyVO) blKeyVO;
				command.removeBl(b, account);
				// 성공메시지세팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());	
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey(CountryCode.US + event.getBlNo());
				command.removeBl((BlKeyVO) blKeyVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI01 <br>
	 * ESM_BKG_0034 : SEARCH02 <br>
	 * 세관 신고시 필요한 Manifest B/L 정보를 Active 상태로 업데이트 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reactivateBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				command = new UsaManifestListDownloadBCImpl();
				UsaBlKeyVO blKeyVO = new UsaBlKeyVO();
				blKeyVO.setBlKey(CountryCode.US + event.getBlNo());
				command.reactivateBl((BlKeyVO) blKeyVO, account);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0457Event")) {
				EsmBkg0457Event event = (EsmBkg0457Event) e;
				command = new JapanManifestListDownloadBCImpl();
				command.reactivateBl((BlKeyVO) event.getJapanBlKeyVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : INIT <br>
	 * ESM_BKG_1033 : INIT <br>
	 * com_intg_cd_dtl Table 조회<br>
	 * 
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode)
			throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for (int j = 0; j < list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(
						list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return list;
	}

	/**
	 * ESM_BKG_0428 : INIT <br>
	 * ESM_BKG_0429 : INIT <br>
	 * ESM_BKG_0217 <br>
	 * 코드별 콤보 데이터 조회<br>
	 * 
	 * @param String
	 *            comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchCodeCombo(String comCode)
			throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
			return list;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_0456 : SEARCH <br>
	 * 일본세관 신고 대상 Marks & Description 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMfrMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			// 이벤트별 Impl생성
			EsmBkg0458Event event = (EsmBkg0458Event) e;
			JapanContainerVO japanContainerVO = new JapanContainerVO();
			command = new JapanManifestListDownloadBCImpl();
			japanContainerVO = (JapanContainerVO) (Object) command
					.searchMfrMnd((ManifestListCondVO) event
							.getJapanManifestListMfrCondVO());
			eventResponse.setRsVoList(japanContainerVO.getBkgCstmsJpBlMkVOs());
			BkgCstmsJpBlVO bkgCstmsJpBlVO = japanContainerVO
					.getBkgCstmsJpBlVO();
			if (bkgCstmsJpBlVO != null) {
				eventResponse.setETCData("pck_qty", bkgCstmsJpBlVO.getPckQty());
				eventResponse.setETCData("pck_tp_cd",
						bkgCstmsJpBlVO.getPckTpCd());
				eventResponse.setETCData("grs_wgt", bkgCstmsJpBlVO.getGrsWgt());
				eventResponse.setETCData("wgt_ut_cd",
						bkgCstmsJpBlVO.getWgtUtCd());
				eventResponse.setETCData("meas_qty",
						bkgCstmsJpBlVO.getMeasQty());
				eventResponse.setETCData("meas_ut_cd",
						bkgCstmsJpBlVO.getMeasUtCd());
				eventResponse.setETCData("locl_ts_flg",
						bkgCstmsJpBlVO.getLoclTsFlg());
				eventResponse.setETCData("jp_cstms_trns_cd",
						bkgCstmsJpBlVO.getJpCstmsTrnsCd());
				eventResponse.setETCData("lmt_no", bkgCstmsJpBlVO.getLmtNo());
				eventResponse.setETCData("cy_opr_cd",
						bkgCstmsJpBlVO.getCyOprCd());
			} else {
				eventResponse.setETCData("pck_qty", "");
				eventResponse.setETCData("pck_tp_cd", "");
				eventResponse.setETCData("grs_wgt", "");
				eventResponse.setETCData("wgt_ut_cd", "");
				eventResponse.setETCData("meas_qty", "");
				eventResponse.setETCData("meas_ut_cd", "");
				eventResponse.setETCData("locl_ts_flg", "");
				eventResponse.setETCData("jp_cstms_trns_cd", "");
				eventResponse.setETCData("lmt_no", "");
				eventResponse.setETCData("cy_opr_cd", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}
			eventResponse.setETCData(etcData);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0458 : MULTI <br>
	 * 일본세관 신고 대상 Marks & Description 정보를 세관 테이블 내에 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMfrMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			begin();
			EsmBkg0458Event event = (EsmBkg0458Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageMfrMnd(
					(MfrMndModificationVO) event.getMfrMndModificationVO(),
					account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0184 : SEARCH <br>
	 * Manifest Registration(MFR)에서 Cust 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCstmsLogDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AncsCustomsTransmissionBCImpl command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0184Event event = (EsmBkg0184Event) e;
			List<AncsCstmsLogDtlVO> ancsCstmsLogDtlVOs = null;
			command = new AncsCustomsTransmissionBCImpl();
			ancsCstmsLogDtlVOs = (List<AncsCstmsLogDtlVO>) (Object) command
					.searchCstmsLogDtl((CstmsLogDtlCondVO) event
							.getAncsCstmsLogDtlCondVO());
			eventResponse.setRsVoList(ancsCstmsLogDtlVOs);
			// 성공메시지세팅
			// eventResponse.setUserMessage("");
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0442 : SEARCH <br>
	 * 세관 신고 대상 List를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestListForRocsBl(Event e)
			throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0442Event event = (EsmBkg0442Event) e;
			List<RocsContainerVO> rocsContainerVOs = null;
			RocsContainerVO rocsContainerVO = null;
			command = new RocsManifestListDownloadBCImpl();
			rocsContainerVOs = (List<RocsContainerVO>) (Object) (command
					.searchManifestListForRocsBl((ManifestListCondVO) event
							.getRocsManifestListCondVO()));
			RocsSearchCargoDetailVO rocsSearchCargoDetailVO = null;
			Map<String, String> etcData = new HashMap<String, String>();
			double totpackage = 0;
			double totweight = 0;
			if (rocsContainerVOs.size() > 0) {
				rocsContainerVO = rocsContainerVOs.get(0);
				RocsSearchBlInfoVO rocsSearchBlInfoVO = rocsContainerVO
						.getRocsSearchBlInfoVO();
				eventResponse.setETCData("etc_bkg_no",
						rocsSearchBlInfoVO.getBkgNo());
				eventResponse.setETCData("bkg_no",
						rocsSearchBlInfoVO.getBkgNo());
				eventResponse.setETCData("fax_no",
						rocsSearchBlInfoVO.getFaxNo());
				eventResponse.setETCData("cust_eml",
						rocsSearchBlInfoVO.getCustEml());
				eventResponse.setETCData("shpr_addr1",
						rocsSearchBlInfoVO.getShprAddr1());
				eventResponse.setETCData("shpr_addr2",
						rocsSearchBlInfoVO.getShprAddr2());
				eventResponse.setETCData("cnee_addr1",
						rocsSearchBlInfoVO.getCneeAddr1());
				eventResponse.setETCData("cnee_addr2",
						rocsSearchBlInfoVO.getCneeAddr2());
				eventResponse.setETCData("ntfy_addr1",
						rocsSearchBlInfoVO.getNtfyAddr1());
				eventResponse.setETCData("ntfy_addr2",
						rocsSearchBlInfoVO.getNtfyAddr2());
				eventResponse.setETCData("shpr_cnt_cd",
						rocsSearchBlInfoVO.getShprCntCd());
				eventResponse.setETCData("shpr_cust_seq",
						rocsSearchBlInfoVO.getShprCustSeq());
				eventResponse.setETCData("cnee_cnt_cd",
						rocsSearchBlInfoVO.getCneeCntCd());
				eventResponse.setETCData("cnee_cust_seq",
						rocsSearchBlInfoVO.getCneeCustSeq());
				eventResponse.setETCData("ntfy_cnt_cd",
						rocsSearchBlInfoVO.getNtfyCntCd());
				eventResponse.setETCData("ntfy_cust_seq",
						rocsSearchBlInfoVO.getNtfyCustSeq());
				eventResponse.setETCData("vsl_cd",
						rocsSearchBlInfoVO.getVslCd());
				eventResponse.setETCData("vvd_number",
						rocsSearchBlInfoVO.getVvdNumber());
				eventResponse.setETCData("skd_voy_no",
						rocsSearchBlInfoVO.getSkdVoyNo());
				eventResponse.setETCData("skd_dir_cd",
						rocsSearchBlInfoVO.getSkdDirCd());
				eventResponse.setETCData("frt_term_cd",
						rocsSearchBlInfoVO.getFrtTermCd());
				eventResponse.setETCData("t1_doc_cd",
						rocsSearchBlInfoVO.getT1DocCd());
				eventResponse.setETCData("shpr_eori_no",
						rocsSearchBlInfoVO.getShprEoriNo());
				eventResponse.setETCData("shpr_cty_nm",
						rocsSearchBlInfoVO.getShprCtyNm());
				eventResponse.setETCData("shpr_cstms_decl_cnt_cd",
						rocsSearchBlInfoVO.getShprCstmsDeclCntCd());
				eventResponse.setETCData("shpr_zip_id",
						rocsSearchBlInfoVO.getShprZipId());
				eventResponse.setETCData("shpr_st_nm",
						rocsSearchBlInfoVO.getShprStNm());
				eventResponse.setETCData("cnee_eori_no",
						rocsSearchBlInfoVO.getCneeEoriNo());
				eventResponse.setETCData("cnee_cty_nm",
						rocsSearchBlInfoVO.getCneeCtyNm());
				eventResponse.setETCData("cnee_cstms_decl_cnt_cd",
						rocsSearchBlInfoVO.getCneeCstmsDeclCntCd());
				eventResponse.setETCData("cnee_zip_id",
						rocsSearchBlInfoVO.getCneeZipId());
				eventResponse.setETCData("cnee_st_nm",
						rocsSearchBlInfoVO.getCneeStNm());
				eventResponse.setETCData("ntfy_eori_no",
						rocsSearchBlInfoVO.getNtfyEoriNo());
				eventResponse.setETCData("ntfy_cty_nm",
						rocsSearchBlInfoVO.getNtfyCtyNm());
				eventResponse.setETCData("ntfy_cstms_decl_cnt_cd",
						rocsSearchBlInfoVO.getNtfyCstmsDeclCntCd());
				eventResponse.setETCData("ntfy_zip_id",
						rocsSearchBlInfoVO.getNtfyZipId());
				eventResponse.setETCData("ntfy_st_nm",
						rocsSearchBlInfoVO.getNtfyStNm());
				List<RocsSearchCntrListVO> rocsSearchCntrListVOs = rocsContainerVO
						.getRocsSearchCntrListVOs();
				eventResponse.setRsVoList(rocsSearchCntrListVOs);
				List<RocsSearchCargoDetailVO> rocsSearchCargoDetailVOs = rocsContainerVO
						.getRocsSearchCargoDetailVOs();
				if (rocsSearchCargoDetailVOs != null
						&& rocsSearchCargoDetailVOs.size() > 0) {
					for (int i = 0; i < rocsSearchCargoDetailVOs.size(); i++) {
						rocsSearchCargoDetailVO = rocsSearchCargoDetailVOs
								.get(i);
						totpackage = totpackage
								+ Double.parseDouble(rocsSearchCargoDetailVO
										.getPckQty());
						totweight = totweight
								+ Double.parseDouble(rocsSearchCargoDetailVO
										.getCntrMfWgt());
					}
					// eventResponse.setETCData("tot_package",String.valueOf(totpackage));
					// eventResponse.setETCData("tot_weight",String.valueOf(totweight));
				}
				eventResponse.setRsVoList(rocsSearchCargoDetailVOs);
			} else {
				eventResponse.setETCData("etc_bkg_no", "");
				eventResponse.setETCData("bkg_no_split", "");
				eventResponse.setETCData("fax_no", "");
				eventResponse.setETCData("cust_eml", "");
				eventResponse.setETCData("shpr_addr1", "");
				eventResponse.setETCData("shpr_addr2", "");
				eventResponse.setETCData("cnee_addr1", "");
				eventResponse.setETCData("cnee_addr2", "");
				eventResponse.setETCData("ntfy_addr1", "");
				eventResponse.setETCData("ntfy_addr2", "");
				eventResponse.setETCData("shpr_cnt_cd", "");
				eventResponse.setETCData("shpr_cust_seq", "");
				eventResponse.setETCData("cnee_cnt_cd", "");
				eventResponse.setETCData("cnee_cust_seq", "");
				eventResponse.setETCData("ntfy_cnt_cd", "");
				eventResponse.setETCData("ntfy_cust_seq", "");
				eventResponse.setETCData("vsl_cd", "");
				eventResponse.setETCData("skd_voy_no", "");
				eventResponse.setETCData("skd_dir_cd", "");
				eventResponse.setETCData("frt_term_cd", "");
				eventResponse.setETCData("t1_doc_cd", "");
				eventResponse.setETCData("vvd_number", "");
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}
			eventResponse.setETCData(etcData);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0300 : SEARCH<BR>
	 * ESM_BKG_0728 : SEARCH<BR>
	 * 세관 신고용 B/L별 Notify Address 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")) {
				// begin();
				EsmBkg0728Event event = (EsmBkg0728Event) e;
				List<CstmsNtfyAddrVO> cstmsNtfyAddrVOs = null;
				command = new AncsManifestListDownloadBCImpl();
				cstmsNtfyAddrVOs = (List<CstmsNtfyAddrVO>) (Object) command
						.searchCstmsNtfyAddr((CstmsNtfyAddrCondVO) event
								.getBkgCstmsNtfyAddrCondVO(), account);
				eventResponse.setRsVoList(cstmsNtfyAddrVOs);
				// commit();
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0300Event")) { // India
																				// Form
																				// Set
				command = new IndiaManifestListDownloadBCImpl();
				EsmBkg0300Event event = (EsmBkg0300Event) e;
				List<CstmsNtfyAddrVO> list = command
						.searchCstmsNtfyAddr((CstmsNtfyAddrCondVO) event
								.getInPrintFormCondVO());
				eventResponse.setRsVoList(list);
				eventResponse.setETCData("retExitOrg", "");
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
	 * ESM_BKG_0300 : SEARCH01<BR>
	 * Office Code 등록유무 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganization(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			command = new IndiaManifestListDownloadBCImpl();
			EsmBkg0300Event event = (EsmBkg0300Event) e;
			InPrintFormCondVO inPrintFormCondVO = event.getInPrintFormCondVO();
			String ofcCd = "";
			int retExitOrg = 0;
			if (inPrintFormCondVO != null) {
				ofcCd = inPrintFormCondVO.getOfcCd();
			}
			retExitOrg = command.searchExistOrganization(ofcCd);
			if (retExitOrg > 0) {
				eventResponse.setETCData("retExitOrg", "1"); // 등록된 Office
				// Code
			} else {
				eventResponse.setETCData("retExitOrg", "0"); // 미등록된 Office
				// Code
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
	 * ESM_BKG_0300 : MULTI<BR>
	 * ESM_BKG_0728 : MULTI<BR>
	 * ANCS 세관 관련 Notify Address를 관리 한다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmsNtfyAddr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0728Event")) {
				EsmBkg0728Event event = (EsmBkg0728Event) e;
				command = new AncsManifestListDownloadBCImpl();
				command.manageCstmsNtfyAddr(
						(CstmsNtfyAddrVO[]) event.getBkgCstmsNtfyAddrVOs(),
						account); // removeJpcusBlMd((MfrMndModificationVO)event.getMfrMndModificationVO(),account);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0300Event")) {
				EsmBkg0300Event event = (EsmBkg0300Event) e;
				command = new IndiaManifestListDownloadBCImpl();
				command.manageCstmsNtfyAddr(event.getInPrintFormModiVOs(),
						account);
				eventResponse.setETCData("retExitOrg", "");
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(CMF 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestListForCmf(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		JapanManifestListCmfDetailVO japanManifestListCmfDetailVO = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0457Event event = (EsmBkg0457Event) e;
			command = new JapanManifestListDownloadBCImpl();
			japanManifestListCmfDetailVO = (JapanManifestListCmfDetailVO) command
					.searchManifestListForCmf((ManifestListCondVO) event
							.getJapanManifestListCondVO());
			eventResponse.setRsVo(japanManifestListCmfDetailVO);
			if (japanManifestListCmfDetailVO == null)
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : SEARCH01,SEARCH02,SEARCH03 <br>
	 * ESM_BKG_0025 : SEARCH01<BR>
	 * ESM_BKG_0034 : MODIFY01,MODIFY02 <br>
	 * ESM_BKG_0540 : SEARCH01 <br>
	 * Mdm Customer 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		MdmCustVO mdmCustVO = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0457Event")) {
				EsmBkg0457Event event = (EsmBkg0457Event) e;
				mdmCustVO = command.searchMdmCust(event.getForm1CustCntCd(),
						event.getForm1CustSeq(), "N");
				if (event.getCustType().equals("S")) {
					eventResponse.setETCData("form1_cust_nm",
							mdmCustVO.getName());
					eventResponse.setETCData("form1_cust_addr",
							mdmCustVO.getAddress());
				} else if (event.getCustType().equals("C")) {
					eventResponse.setETCData("form1_cust_nm2",
							mdmCustVO.getName());
					eventResponse.setETCData("form1_cust_addr2",
							mdmCustVO.getAddress());
				} else if (event.getCustType().equals("N")) {
					eventResponse.setETCData("form1_cust_nm3",
							mdmCustVO.getName());
					eventResponse.setETCData("form1_cust_addr3",
							mdmCustVO.getAddress());
				}
				if (mdmCustVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				UsaBlCustVO usaBlCustVO = event.getUsaBlCustVO();
				mdmCustVO = command.searchMdmCust(usaBlCustVO.getCustCntCd(),
						usaBlCustVO.getCustSeq(), "N");
				if (mdmCustVO != null) {
					eventResponse.setETCData("cust_nm", mdmCustVO.getName());
					eventResponse.setETCData("cust_addr",
							mdmCustVO.getAddress());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				mdmCustVO = command.searchMdmCust(event.getStrCustCntCd(),
						event.getStrCustSeq(), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("result", mdmCustVO.getName());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0025Event")) {
				EsmBkg0025Event event = (EsmBkg0025Event) e;
				mdmCustVO = command.searchMdmCust(event.getCndCstmsReportVO()
						.getCustSeq().substring(0, 2), event
						.getCndCstmsReportVO().getCustSeq().substring(2), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("cust_nm", mdmCustVO.getName());
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				EsmBkg0029Event event = (EsmBkg0029Event) e;
				if ("D".equals(event.getCustTp())) {
					// Delivery의 경우 Yard 와 Location정보
					MdmYardVO mdmYardVO = new MdmYardVO();
					mdmYardVO
							.setYdCd(event.getCustCntCd() + event.getCustSeq());
					List<MdmYardVO> listYard = command
							.searchYardCode(mdmYardVO);
					if (listYard.size() > 0) {
						eventResponse.setETCData("cust_nm", listYard.get(0)
								.getYdNm());
						eventResponse.setETCData("cust_addr", listYard.get(0)
								.getYdAddr());
						SearchLocationCodeVO locVO = command
								.searchLocationCode(listYard.get(0).getLocCd());
						if (locVO != null) {
							eventResponse
									.setETCData("loc_nm", locVO.getLocNm());
							eventResponse
									.setETCData("ste_cd", locVO.getSteCd());
							eventResponse
									.setETCData("cnt_cd", locVO.getCntCd());
							eventResponse.setETCData("zip_cd", listYard.get(0)
									.getZipCd());
						}
					} else {
						throw new EventException(
								new ErrorHandler(
										"BKG00651",
										new String[] { "Location or Node code" })
										.getMessage());
					}
				} else {
					mdmCustVO = command.searchMdmCust(event.getCustCntCd(),
							event.getCustSeq(), "N");
					if (mdmCustVO != null) {
						eventResponse
								.setETCData("cust_nm", mdmCustVO.getName());
						eventResponse.setETCData("cust_addr",
								mdmCustVO.getAddress());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				mdmCustVO = command.searchMdmCust(event.getCustCntCd(),
						event.getCustSeq(), "N");
				String custType = event.getCustType().toLowerCase();
				eventResponse.setETCData(custType + "_cust_nm",
						mdmCustVO.getName());
				eventResponse.setETCData(custType + "_cust_addr",
						mdmCustVO.getAddress());
				if (mdmCustVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				mdmCustVO = command.searchMdmCust(event.getCustCntCd(),
						event.getCustSeq(), "N");
				String custType = event.getCustType().toLowerCase();
				eventResponse.setETCData(custType + "_cust_nm",
						mdmCustVO.getName());
				eventResponse.setETCData(custType + "_cust_addr",
						mdmCustVO.getAddress());
				if (mdmCustVO == null)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
				EsmBkg1144Event event = (EsmBkg1144Event) e;
				mdmCustVO = command.searchMdmCust(event.getStrCustCntCd(),
						event.getStrCustSeq(), "Y");
				if (mdmCustVO != null) {
					eventResponse.setETCData("result", mdmCustVO.getName());
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
	 * ESM_BKG_0029 : SEARCH02<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHubInfo(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0029Event event = (EsmBkg0029Event) e;
			command = new CndManifestListDownloadBCImpl();
			String[] arrHubInfo = command.searchHubInfo(event.getPodCd(),
					event.getDelCd(), event.getPodNodCd());
			eventResponse.setETCData("hub_loc_cd", arrHubInfo[0]);
			eventResponse.setETCData("ibd_loc_gds_desc", arrHubInfo[1]);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0457 : MULTI <br>
	 * VVD,Port 등 입력 후 조회한 세관 CMF 신고 대상 List를 세관 테이블 내로 다운받는다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestForCmf(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0457Event event = (EsmBkg0457Event) e;
			command = new JapanManifestListDownloadBCImpl();
			command.manageManifestForCmf(
					(ManifestModificationVO) event.getJapanCmfModificationVO(),
					account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0329 : MULTI <br>
	 * B/L List조회후 세관신고DownLoad<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadCstmsBlList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			KorDlContainerVO cont = new KorDlContainerVO();
			KorMrnNoVO fromClient = event.getMrnNoVO();
			KorManifestInfoVO[] list = event.getManifestInfoVOs();
			KorBkgCntrQtyInfoVO[] cntrList = event.getCntrVOs();
			cont.setKorMrnNoVO(fromClient);
			cont.setKorManifestInfoVOs(list);
			cont.setKorBkgCntrQtyInfoVOs(cntrList);
			// BACKEND JOB 으로 처리
			ManifestListDownloadBackEndBC backEndBC = new KorManifestListDownloadBackEndBCImpl();
			((KorManifestListDownloadBackEndBCImpl) backEndBC)
					.setAccount(account);
			((KorManifestListDownloadBackEndBCImpl) backEndBC)
					.setKorDlContainerVO(cont);
			((KorManifestListDownloadBackEndBCImpl) backEndBC)
					.setPgmNo("ESM_BKG_0329");
			String key = backEndBC.startBackEndBC(account.getUsr_id());
			eventResponse.setETCData("KEY", key);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0401 : SEARCH<BR>
	 * Canada Office Information 조회
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			// Office가 미주 대률 내 Office가 아닌 경우 Error
			MdmOrganizationVO org = bkgUtil.searchMdmOrzByOfcCd(event
					.getBkgHrdCdgCtntListCondVO().getAttrCtnt1());
			if (org == null
					|| (!org.getLocCd().startsWith("CA") && !org.getLocCd()
							.startsWith("US"))) {
				throw new EventException(new ErrorHandler("BKG01067",
						new String[] {}).getMessage());
			}
			List<BkgHrdCdgCtntVO> list = bkgUtil.searchHardCoding(event
					.getBkgHrdCdgCtntListCondVO());
			if (list.size() > 0) {
				list.get(0)
						.setAttrCtnt2(
								list.get(0).getAttrCtnt2()
										+ list.get(0).getAttrCtnt3());
			} else {
				list = new ArrayList<BkgHrdCdgCtntVO>();
				BkgHrdCdgCtntVO vo = new BkgHrdCdgCtntVO();
				vo.setHrdCdgId(Constants.HrdCdgId.CND_AVCNTC_OFC_SET);
				vo.setAttrCtnt2("");
				list.add(vo);
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0401 : MODIFY<BR>
	 * bkg_hrd_cdg 테이블을 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			bkgUtil.manageHardCoding(event.getBkgHrdCdgCtntVOs());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0025 : SEARCH<br>
	 * Arrive Notice 전송<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsReport(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0025Event event = (EsmBkg0025Event) e;
			command = new CndCustomsReportBCImpl();
			eventResponse.setRsVoList(command.searchCstmsReport(event
					.getCndCstmsReportCondVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : SEARCH <br>
	 * 일본 세관에 신고할 대상 Manifest 정보(DOR 데이터) 를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchManifestListForDor(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EsmBkg0466Event event =(EsmBkg0466Event)e;
			command = new JapanManifestListDownloadBCImpl();
			List<JapanManifestListDorListInfoVO> japanManifestListDorListInfoVOs = (List<JapanManifestListDorListInfoVO>) (Object) (command
					.searchManifestListForDor());
			if (japanManifestListDorListInfoVOs.size() == 0)
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			eventResponse.setRsVoList(japanManifestListDorListInfoVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0477 : SEARCH <br>
	 * ESM_BKG_0450 : SEARCH <br>
	 * ESM_BKG_0502 : SEARCH <br>
	 * ESM_BKG_1047 : SEARCH <br>
	 * ESM_BKG_1048 : SEARCH <br>
	 * ESM_BKG_1038 : SEARCH <br>
	 * 세관에 EDI를 통해 전송한 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchTransmitHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0477Event")) {
				EsmBkg0477Event event = (EsmBkg0477Event) e;
				command = new JapanCustomsReportBCImpl();
				List<JapanManifestListTransmitHistDetailVO> japanManifestListTransmitHistDetailVOs = (List<JapanManifestListTransmitHistDetailVO>) (Object) (command
						.searchTransmitHist((TransmitHistCondVO) event
								.getJapanTransmitHistCondVO()));
				if (japanManifestListTransmitHistDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					japanManifestListTransmitHistDetailVOs
							.get(0)
							.setMaxRows(
									Integer.parseInt(japanManifestListTransmitHistDetailVOs
											.get(0).getTotal()));
				}
				eventResponse
						.setRsVoList(japanManifestListTransmitHistDetailVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0502Event")) {
				EsmBkg0502Event event = (EsmBkg0502Event) e;
				CustomsReportBC command2 = new KorCustomsReportBCImpl();
				KorReportHistContainerVO histContainer = (KorReportHistContainerVO) command2
						.searchTransmitHist((ReportHistCondVO) event
								.getKorTransHistVO());
				List<KorTransHistVO> list = histContainer.getKorTransHistVOs();
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0450Event")) {
				EsmBkg0450Event event = (EsmBkg0450Event) e;
				RocsManifestListDownloadBCImpl command2 = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<TransmitHistVO> list = command2.searchTransmitHist(event
						.getRocsTransmitHistCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1047Event")) {
				EsmBkg1047Event event = (EsmBkg1047Event) e;
				command = new ChinaCustomsReportBCImpl();
				List<ChinaManifestListTransmitHistDetailVO> chinaManifestListTransmitHistDetailVOs = (List<ChinaManifestListTransmitHistDetailVO>) (Object) (command
						.searchTransmitHist((TransmitHistCondVO) event
								.getChinaTransmitHistCondVO()));
				if (chinaManifestListTransmitHistDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					chinaManifestListTransmitHistDetailVOs
							.get(0)
							.setMaxRows(
									Integer.parseInt(chinaManifestListTransmitHistDetailVOs
											.get(0).getTotal()));
				}
				eventResponse
						.setRsVoList(chinaManifestListTransmitHistDetailVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1048Event")) {
				EsmBkg1048Event event = (EsmBkg1048Event) e;
				command = new ChinaCustomsReportBCImpl();
				List<ChinaManifestSendDetailListVO> chinaManifestSendDetailListVOs =
				// (List<ChinaManifestSendDetailListVO>)(Object)(command.searchChinaSendDetailList((TransmitHistCondVO)event.getChinaTransmitHistCondVO()));
				(List<ChinaManifestSendDetailListVO>) (Object) (command
						.searchChinaSendDetailList(event.getEdiRefId(),
								event.getPodCd()));
				if (chinaManifestSendDetailListVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					// chinaManifestSendDetailListVOs.get(0).setMaxRows(Integer.parseInt(chinaManifestSendDetailListVOs.get(0).getTotal()));
				}
				eventResponse.setRsVoList(chinaManifestSendDetailListVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1038Event")) {
				EsmBkg1038Event event = (EsmBkg1038Event) e;
				command = new BangladeshCustomsReportBCImpl();
				List<LicenseInfoListVO> licenseInfoListVOs =
				// (List<ChinaManifestSendDetailListVO>)(Object)(command.searchChinaSendDetailList((TransmitHistCondVO)event.getChinaTransmitHistCondVO()));
				(List<LicenseInfoListVO>) (Object) (command
						.searchLicenseInfo((LicenseInfoCondVO) event
								.getLicenseInfoCondVO()));
				if (licenseInfoListVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					// chinaManifestSendDetailListVOs.get(0).setMaxRows(Integer.parseInt(chinaManifestSendDetailListVOs.get(0).getTotal()));
				}
				eventResponse.setRsVoList(licenseInfoListVOs);
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
	 * ESM_BKG_0471 : SEARCH <br>
	 * ESM_BKG_0448 : SEARCH <br>
	 * ESM_BKG_0917 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReceiveHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0471Event")) {
				EsmBkg0471Event event = (EsmBkg0471Event) e;
				command = new JapanCustomsReportBCImpl();
				List<JapanManifestListReceiveHistDetailVO> japanManifestListReceiveHistDetailVOs = (List<JapanManifestListReceiveHistDetailVO>) (Object) (command
						.searchReceiveHist((RcvHistCondVO) event
								.getJapanRcvHistCondVO()));
				if (japanManifestListReceiveHistDetailVOs.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					japanManifestListReceiveHistDetailVOs
							.get(0)
							.setMaxRows(
									Integer.parseInt(japanManifestListReceiveHistDetailVOs
											.get(0).getTotal()));
				}
				eventResponse
						.setRsVoList(japanManifestListReceiveHistDetailVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0448Event")) {
				EsmBkg0448Event event = (EsmBkg0448Event) e;
				RocsManifestListDownloadBCImpl command2 = new RocsManifestListDownloadBCImpl();
				// List<RocsSearchRocsReceiveListVO> rocsSearchRocsReceiveListVO
				// =
				// command2.searchReceiveHist(event.getRocsRcvHistCondVO());
				List<com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO> list = command2
						.searchReceiveHist(event.getRocsRcvHistCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				}
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0917Event")) {
				// 한국세관 세관 수신 내역 조회
				EsmBkg0917Event event = (EsmBkg0917Event) e;
				command = new KorCustomsReportBCImpl();
				// BC에 작업 요청
				KorRcvHistVO[] korRcvHistVOs = (KorRcvHistVO[]) command
						.searchReceiveAckHist(event.getKorRcvHistCondVO());
				// 결과 값이 있을 경우 넘김
				if (korRcvHistVOs != null && korRcvHistVOs.length > 0) {
					List<KorRcvHistVO> list = Arrays.asList(korRcvHistVOs);
					eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0448 : SEARCH01 <br>
	 * Rotterdam세관에서 받은 edi 현황정보를 가져온다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0448Event event = (EsmBkg0448Event) e;
			RocsManifestListDownloadBCImpl command2 = new RocsManifestListDownloadBCImpl();
			List<RecieveHistLogVO> rocsSearchRocsRcvHistByBlVO = command2
					.searchHistoryList(event.getRocsHistoryListCondVO());
			if (rocsSearchRocsRcvHistByBlVO.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}
			eventResponse.setRsVoList(rocsSearchRocsRcvHistByBlVO);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0471 : MODIFY <br>
	 * 일본세관 Manifest 수신 로그를 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyReceiveLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			EsmBkg0471Event event = (EsmBkg0471Event) e;
			command = new JapanCustomsTransmissionBCImpl();
			// 성공메시지세팅
			command.modifyReceiveLog(
					(ReceiveLogVO) event.getJapanReceiveLogVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0025 : MULTI<BR>
	 * ESM_BKG_0025 : MODIFY<BR>
	 * ESM_BKG_0025 : MODIFY01<BR>
	 * ESM_BKG_0025 : MODIFY02<BR>
	 * BL의 AnType 수정 및 Arrival Notice Customer의 팩스 이메일수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAvcNoteSetUpInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0025Event event = (EsmBkg0025Event) e;
			if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				command = new CndManifestListDownloadBCImpl();
				AvcNoteSetUpInfoVO[] vos = event.getAvcNoteSetUpInfoVOs();
				command.manageAvcNoteSetUpInfo(vos, account);
				// ArrivalNotice 수정
				CndCstmsReportVO[] params = event.getCndCstmsReportVOs();
				ArrivalNoticeBC ibcommand = new ArrivalNoticeBCImpl();
				ArrNtcCustListVO[] arrNtcCustListVOs = new ArrNtcCustListVO[params.length];
				for (int i = 0; i < event.getCndCstmsReportVOs().length; i++) {
					arrNtcCustListVOs[i] = new ArrNtcCustListVO();
					arrNtcCustListVOs[i].setBkgNo(params[i].getBkgNo());
					arrNtcCustListVOs[i].setBkgCustTpCd("C");
					arrNtcCustListVOs[i].setFax1(params[i].getFaxNo1());
					arrNtcCustListVOs[i].setEml1(params[i].getNtcEml1());
					arrNtcCustListVOs[i].setFax2(params[i].getFaxNo2());
					arrNtcCustListVOs[i].setEml2(params[i].getNtcEml2());
					arrNtcCustListVOs[i].setFax3(params[i].getFaxNo3());
					arrNtcCustListVOs[i].setEml3(params[i].getNtcEml3());
					arrNtcCustListVOs[i].setFax4(params[i].getFaxNo4());
					arrNtcCustListVOs[i].setEml4(params[i].getNtcEml4());
					arrNtcCustListVOs[i].setFax5(params[i].getFaxNo5());
					arrNtcCustListVOs[i].setEml5(params[i].getNtcEml5());
				}
				ibcommand.modifyArrNtcCustList(arrNtcCustListVOs, account);
				// 성공메시지
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				// Fax
				CustomsReportBC reportCom = new CndCustomsReportBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = reportCom.sendAvcNoteFax(
						event.getCndCstmsReportVOs(), account);
				// History Table 등록
				BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("BKG40053")
						.getUserMessage());
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				// Email
				CustomsReportBC reportCom = new CndCustomsReportBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = reportCom.sendAvcNoteEmail(
						event.getCndCstmsReportVOs(), account);
				// History Table 등록
				BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("BKG40054")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0472 : SEARCH <br>
	 * ESM_BKG_1027 : SEARCH <br>
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReceiveLog(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsReportBC command = null;
		ManifestListDownloadBC command2 = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0472Event")) {
				EsmBkg0472Event event = (EsmBkg0472Event) e;
				command = new JapanCustomsReportBCImpl();
				List<JapanManifestListRcvLogDetailVO> japanManifestListRcvLogDetailVOs = (List<JapanManifestListRcvLogDetailVO>) (Object) (command
						.searchReceiveLog((ReceiveLogCondVO) event
								.getJapanReceiveLogCondVO()));
				if (japanManifestListRcvLogDetailVOs.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				// japanManifestListRcvLogDetailVOs.get(0).setMaxRows(
				// Integer.parseInt(japanManifestListRcvLogDetailVOs.get(0).getTotal()));
				eventResponse.setRsVoList(japanManifestListRcvLogDetailVOs);
			}
			if (e.getEventName().equalsIgnoreCase("EsmBkg1027Event")) {
				EsmBkg1027Event event = (EsmBkg1027Event) e;
				command2 = new RocsManifestListDownloadBCImpl();
				List<com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ReceiveLogVO> list = command2
						.searchReceiveLog(event.getRocsReceiveLogCondVO());
				if (list.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0478 : SEARCH <br>
	 * ESM_BKG_1032 : SEARCH <br>
	 * 세관에 적하목록 신고시 생성한 송신 EDI 메시지 내역을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchSendLog(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0478Event")) {
				EsmBkg0478Event event = (EsmBkg0478Event) e;
				command = new JapanCustomsReportBCImpl();
				List<JapanManifestListSndLogDetailVO> japanManifestListSndLogDetailVOs = (List<JapanManifestListSndLogDetailVO>) (Object) (command
						.searchSendLog((SendLogCondVO) event
								.getJapanSendLogCondVO()));
				if (japanManifestListSndLogDetailVOs.size() == 0)
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				// japanManifestListSndLogDetailVOs.get(0).setMaxRows(
				// Integer.parseInt(japanManifestListSndLogDetailVOs.get(0).getTotal()));
				eventResponse.setRsVoList(japanManifestListSndLogDetailVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1032Event")) {
				command = new EurCustomsReportBCImpl();
				List<SendLogDetailVO> list = null;
				EsmBkg1032Event event = (EsmBkg1032Event) e;
				list = command.searchSendLog(event.getSendLogCondVO());
				eventResponse.setRsVoList(list);
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
	 * EsmBkgUbizhjsAlpsbkgNaccsEvent : SEARCH01 <br>
	 * NACCS_EDI_ALPSBKG_SEANACCS 연동<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveUbizhjsAlpsbkgNaccs(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			EsmBkgUbizhjsAlpsbkgNaccsEvent event = (EsmBkgUbizhjsAlpsbkgNaccsEvent) e;
			command = new JapanCustomsTransmissionBCImpl();
			log.info("======================================");
			log.info("xml2 : " + event.getFlatFile());
			log.info("======================================");
			command.receiveUbizhjsAlpsbkgNaccs(event.getFlatFile(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * JapanAlpsBkgNaccsReplyEvent : SEARCH01 <br>
	 * NACCS_EDI_ALPSBKG_SEANACCS 연동<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveJapanTerminalAlpsbkgNaccs(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			JapanAlpsBkgNaccsReplyEvent event = (JapanAlpsBkgNaccsReplyEvent) e;
			command = new JapanTerminalTransmissionBCImpl();
			log.info("======================================");
			log.info("xml2 : " + event.getFlatFile());
			log.info("======================================");
			command.receiveJapanTerminalAlpsbkgNaccs(event.getFlatFile(),
					account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkgAlpsbkgUdevhjsEvent : SEARCH01 <br>
	 * EsmBkgAlpsbkgUdevhjsEvent 연동<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveAlpsbkgUdevhjs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC maniCommand = null;
		try {
			begin();
			EsmBkgAlpsbkgUdevhjsEvent event = (EsmBkgAlpsbkgUdevhjsEvent) e;
			command = new RocsCustomsTransmissionBCImpl();
			maniCommand = new RocsManifestListDownloadBCImpl();
			RocsManifestTransmitVO rocsManifestTransmitVO = command
					.receiveAlpsbkgUdevhjs(event.getFlatFile(), account);
			maniCommand.modifyBlReceivedSts(rocsManifestTransmitVO);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0037 : SEARCH, SEARCH01<BR>
	 * Container 정보를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			command = new UsaManifestListDownloadBCImpl();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0037Event")) {
				EsmBkg0037Event event = (EsmBkg0037Event) e;
				List<ContainerListRsltVO> list = command
						.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(
						FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd",
								vo.getCntrTpszCd());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				List<ContainerListRsltVO> list = command
						.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(
						FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd",
								vo.getCntrTpszCd());
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				List<ContainerListRsltVO> list = command
						.searchContainerList(event.getContainerListCondVO());
				if (event.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse.setRsVoList(list);
				} else if (event.getFormCommand().isCommand(
						FormCommand.SEARCH01)) {
					if (list != null && list.size() > 0) {
						UsaCntrListRsltVO vo = (UsaCntrListRsltVO) list.get(0);
						eventResponse.setETCData("cntr_no", vo.getCntrNo());
						eventResponse.setETCData("cntr_tpsz_cd",
								vo.getCntrTpszCd());
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
	 * ESM_BKG_0037 : MULTI<BR>
	 * Container 정보를 저장한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0037Event event = (EsmBkg0037Event) e;
			command = new UsaManifestListDownloadBCImpl();
			command.manageContainerList(event.getContainerListRsltVOs(),
					account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0305 : SEARCH<BR>
	 * 세관에 등록된 보세장치장 코드를 조회하는 화면<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBondList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		List<BondDetailListVO> list = null;
		try {
			command = new IndiaManifestListDownloadBCImpl();
			EsmBkg0305Event event = (EsmBkg0305Event) e;
			list = command.searchBondList(event.getIndiaBondListCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0333 : SEARCH<BR>
	 * BL 단위 Disch CY, Bonded Warehouse, Bonded Type 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiscCYBondInfo(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			command = new KorManifestListDownloadBCImpl();
			// BC에 작업 요청
			korDiscCYBondInfoVO = (KorDiscCYBondInfoVO) command.searchDiscCYBondInfo(korDiscCYBondInfoVO);
			// 결과 처리
			if (korDiscCYBondInfoVO == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
			} else {
				// 결과를 넘김(ETC DATA 배열로)
				korDiscCYBondInfoVO.setSearchType(event.getKorDiscCYBondInfoVO().getSearchType());
				korDiscCYBondInfoVO.setIoBndCd(event.getKorDiscCYBondInfoVO().getIoBndCd());
				eventResponse.setETCData(korDiscCYBondInfoVO.getColumnValues());
				// 객체로 넘기기 추가
				eventResponse.setRsVo(korDiscCYBondInfoVO);
				if (korDiscCYBondInfoVO.getKorGrpMsnVO() != null) eventResponse.setETCData(korDiscCYBondInfoVO.getKorGrpMsnVO().getColumnValues());
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
	 * ESM_BKG_0344 : MODIFY<BR>
	 * Manifest Transmission 관련해서<br>
	 * Save,
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyManifestSummaryInfo(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0344Event event = (EsmBkg0344Event) e;
			ManifestListDownloadBC command = new KorManifestListDownloadBCImpl();
			KorManifestSmryCondVO condVO = event.getKorManifestSmryCondVO();
			// USERID
			condVO.setUserId(account.getUsr_id());
			// BC에 작업 요청
			command.modifyManifestSummaryInfo(condVO);
			commit();
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0344 : REMOVE<BR>
	 * Manifest Transmission 관련해서 Delete<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifestSummaryInfo(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0344Event event = (EsmBkg0344Event) e;
			ManifestListDownloadBC command = new KorManifestListDownloadBCImpl();
			// 파라메터
			KorManiSumCondVO condVO = event.getKorManiSumCondVO();
			// ID, OFC_CD 넣기
			condVO.setUserId(account.getUsr_id());
			condVO.setOfcCd(account.getOfc_cd());
			// BC 에 작업 요청
			command.manageManifestSummaryInfo(condVO);
			commit();
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593")
					.getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0613 : MULTI02<BR>
	 * Ofm 전송<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitOfm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		// EDIMgtBC ediCommand = new EDIMgtBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성 USA EDI FLAT FILE 생성 및 전송
			EsmBkg0613Event event = (EsmBkg0613Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			UsaManifestSearchDetailVO[] vos = event
					.getUsaManifestSearchDetailVOS();
			if (vos.length > 0) {
				vos[0].setUsrId(account.getUsr_id());
				vos[0].setOfcCd(account.getOfc_cd());
			}
			flatFile = command.transmitOfm(vos);
			eventResponse.setETCData("flatFile", flatFile);
			eventResponse.setETCData(etcData);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0334 : SEARCH<BR>
	 * Discharging CY Code List 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDiscCYCodeList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0334Event event = (EsmBkg0334Event) e;
			command = new KorCustomsReportBCImpl();
			// 파라메터 객체
			KorDischLocCondVO korDischLocCondVO = event.getKorDischLocCondVO();
			// BC에 작업 요청
			KorDischLocVO[] korDischLocVOs = (KorDischLocVO[]) command
					.searchDischCYCodeList(korDischLocCondVO);
			// 결과 처리
			if (korDischLocVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorDischLocVO>) Arrays
						.asList(korDischLocVOs));
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
	 * ESM_BKG_334 : MULTI <br>
	 * Discharging CY Code List 추가/수정/삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDiscCYCodeList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0334Event event = (EsmBkg0334Event) e;
			KorDischLocCondVO[] korDischLocCondVOs = event
					.getKorDischLocCondVOs();
			for (int i = 0; i < korDischLocCondVOs.length; i++)
				korDischLocCondVOs[i].setUsrId(account.getUsr_id());
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			command.manageDiscCYCodeList(korDischLocCondVOs);
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_335 : SEARCH <br>
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code를 Inquiry<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmEntryTpList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0335Event event = (EsmBkg0335Event) e;
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorEntryTpVO[] korEntryTpVOs = (KorEntryTpVO[]) command
					.searchCstmEntryTpList(event.getKorEntryTpCondVO());
			// 결과 처리
			if (korEntryTpVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorEntryTpVO>) Arrays
						.asList(korEntryTpVOs));
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
	 * ESM_BKG_335 : MULTI <br>
	 * 한국/인도 세관에 적하 목록 전송할 때 B/L의 통관 Type Code 추가/수정/삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCstmEntryTpList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0335Event event = (EsmBkg0335Event) e;
			KorEntryTpCondVO[] korEntryTpCondVOs = event.getKorEntryTpCondVOs();
			for (int i = 0; i < korEntryTpCondVOs.length; i++)
				korEntryTpCondVOs[i].setUsrId(account.getUsr_id());
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			command.manageCstmEntryTpList(korEntryTpCondVOs);
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_333 : MULTI <br>
	 * 한국세관 Discharging CY Bond Info UPDATE<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDiscCYBondInfo(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		KorDiscCYBondInfoVO discCYBondInfoVO = null;

		try {
			begin();

			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event
					.getKorDiscCYBondInfoVO();
			korDiscCYBondInfoVO.setUsrId(account.getUsr_id());
			command = new KorManifestListDownloadBCImpl();
			// BC에 작업 요청
			discCYBondInfoVO = (KorDiscCYBondInfoVO) command
					.manageDiscCYBondInfo(korDiscCYBondInfoVO);
			// History 저장 처리
			if (discCYBondInfoVO.getBkgHistVO() != null) {
				// Master 정보 처리
				KorBkgHistVO masterVO = discCYBondInfoVO.getBkgHistVO();
				BkgHisMstVO bkgHistMstVO = new BkgHisMstVO();
				// Parameter 복사
				bkgHistMstVO.setBkgNo(masterVO.getBkgNo());
				bkgHistMstVO.setHisSeq(masterVO.getHistSeq());
				bkgHistMstVO.setCreUsrId(account.getUsr_id());
				bkgHistMstVO.setUpdUsrId(account.getUsr_id());
				bkgHistMstVO.setBkgHisIssUiId("DO");
				// Detail 정보 처리
				KorBkgHistVO detailVO = discCYBondInfoVO.getBkgHistDtlVO();
				BkgHisDtlVO bkgHistDtlVO = new BkgHisDtlVO();
				// Parameter 복사
				ObjectCloner.build(bkgHistMstVO, bkgHistDtlVO);
				bkgHistDtlVO.setHisSeq(detailVO.getHistSeq());
				bkgHistDtlVO.setHisDtlSeq(detailVO.getHistDtlSeq());
				bkgHistDtlVO.setPreCtnt(detailVO.getOldMsnDiscloc());
				bkgHistDtlVO.setCrntCtnt(detailVO.getNewMsnDiscloc());
				// BC에 작업 요청
				BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
				command2.createBkgHisMst(bkgHistMstVO, bkgHistDtlVO);
			}
			// BLISS, BLDOC 처리
			// MSN_BLTS 가 I 혹은 E 인 경우
			if (korDiscCYBondInfoVO.getMrnBlTsCd().equals("I")
					|| korDiscCYBondInfoVO.getMrnBlTsCd().equals("E")) {
				// BLISS 처리
				BLIssuanceBC command3 = new BLIssuanceBCImpl();
				BkgBlIssVO bkgBlIssVO = new BkgBlIssVO();
				// Parameter 복사
				bkgBlIssVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				bkgBlIssVO
						.setCstmsEntrCd(korDiscCYBondInfoVO.getCstmsClrTpCd());
				bkgBlIssVO.setCstmsClrLocCd(korDiscCYBondInfoVO.getLocCd());
				bkgBlIssVO.setCstmsClrWhNm(korDiscCYBondInfoVO
						.getCstmsClrWhCd());
				// BC 에 작업 요청
				command3.modifyIbDtlBlIss(bkgBlIssVO);
				// BLDOC 처리
				BLDocumentationBLBC command4 = new BLDocumentationBLBCImpl();
				BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
				// Parameter 복사
				bkgBlDocVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				bkgBlDocVO.setIbMfCfmFlg(korDiscCYBondInfoVO.getMfCfmFlg());
				// BC에 작업 요청
				command4.modifyBlDoc(bkgBlDocVO);
			}
			// Wharfage 저장 처리
			BlRatingBC command5 = new BlRatingBCImpl();
			BkgRateVO bkgRateVO = new BkgRateVO();
			// Paramter 셋팅
			bkgRateVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
			bkgRateVO.setUpdUsrId(account.getUsr_id());
			bkgRateVO.setCreUsrId(account.getUsr_id());
			bkgRateVO
					.setBkgRtWhfExptCd(korDiscCYBondInfoVO.getBkgRtWhfExptCd());
			bkgRateVO.setWhfShprRgstNo(korDiscCYBondInfoVO.getWhfShprRgstNo());
			// BC에 작업 요청
			command5.manageWhfExptInfo(bkgRateVO);
			
			
			// Start. [CHM-201536700] 2015.07.15 // T/S 일 경우 CNTR 정보 update
			BLDocumentationCMBC blDocCMBC = new BLDocumentationCMBCImpl();
			CntrKrWhfExptVO cntrKrWhfExptVO = new CntrKrWhfExptVO();
			
			cntrKrWhfExptVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
			cntrKrWhfExptVO.setUpdUsrId(account.getUpd_usr_id());
			
			if("X".equals(korDiscCYBondInfoVO.getWhfWave())){
				// 현재 WHF Wave= T/S 이면 Container의 expt_flg ="Y"로 update
				cntrKrWhfExptVO.setCntrWfgExptFlg("Y");
				blDocCMBC.modifyBkgKrWhfExpt(cntrKrWhfExptVO);
				
			}else if("X".equals(korDiscCYBondInfoVO.getBfrWhfWave())){
				// 변경 전(save 전) WHF Wave=T/S였으면, 체크를 지우기 위해서 Container의 expt_flg= "N"으로 update
				cntrKrWhfExptVO.setCntrWfgExptFlg("N");
				blDocCMBC.modifyBkgKrWhfExpt(cntrKrWhfExptVO);
			}
			// End. [CHM-201536700] 2015.07.15
			
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0061 : SEARCH03 <br>
	 * ESM_BKG_0127 : <br>
	 * ESM_BKG_0257 : <br>
	 * ESM_BKG_0002 : SEARCH03 <br>
	 * ESM_BKG_0210 : SEARCH03 <br>
	 * ESM_BKG_0329 : SEARCH03 <br>
	 * ESM_BKG_0613 : SEARCH03 <br>
	 * ESM_BKG_0615 : SEARCH03 <br> 
	 * ESM_BKG_0216 : MULTI01 <br>
	 * ESM_BKG_0370 : SEARCH03 <br>
	 * ESM_BKG_0533 : SEARCH03 <br>
	 * ESM_BKG_0408 : SEARCH03 <br>
	 * ESM_BKG_1023 : SEARCH03 <br>
	 * ESM_BKG_1106 : SEARCH03 <br>
	 * ESM_BKG_1121 : SEARCH03 <br>
	 * ESM_BKG_1046 : MULTI03 <br>
	 * ESM_BKG_1163 : MULTI03 <br>
	 * ESM_BKG_0730 : COMMAND03 <br>
	 * ESM_BKG_1141 : SEARCH01 <br>
	 * ESM_BKG_1155 : SEARCH01 <br>
	 * ESM_BKG_1162 : SEARCH01 <br>
	 * BackEndJob 실행 후 결과코드 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0210Event")) {
			EsmBkg0210Event event = (EsmBkg0210Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0002Event")) {
			EsmBkg0002Event event = (EsmBkg0002Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0006Event")) {
			EsmBkg0006Event event = (EsmBkg0006Event) e;
			sKey = event.getKey();			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1023Event")) {
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0613Event")) {
			EsmBkg0613Event event = (EsmBkg0613Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0615Event")) {
			EsmBkg0615Event event = (EsmBkg0615Event) e;
			sKey = event.getKey();			
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0408Event")) {
			EsmBkg0408Event event = (EsmBkg0408Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0533Event")) {
			EsmBkg0533Event event = (EsmBkg0533Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
			EsmBkg0216Event event = (EsmBkg0216Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")) {
			EsmBkg0061Event event = (EsmBkg0061Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0370Event")) {
			EsmBkg0370Event event = (EsmBkg0370Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0484Event")) {
			EsmBkg0484Event event = (EsmBkg0484Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0127Event")) {
			EsmBkg0127Event event = (EsmBkg0127Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
			EsmBkg1046Event event = (EsmBkg1046Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1163Event")) {
			EsmBkg1163Event event = (EsmBkg1163Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0730Event")) {
			EsmBkg0730Event event = (EsmBkg0730Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0053Event")) {
			EsmBkg0053Event event = (EsmBkg0053Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0282Event")) {
			EsmBkg0282Event event = (EsmBkg0282Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0497Event")) {
			EsmBkg0497Event event = (EsmBkg0497Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0017Event")) {
			EsmBkg0017Event event = (EsmBkg0017Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
			EsmBkg1106Event event = (EsmBkg1106Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
			EsmBkg1121Event event = (EsmBkg1121Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1141Event")) {
			EsmBkg1141Event event = (EsmBkg1141Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
			EsmBkg1149Event event = (EsmBkg1149Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1155Event")) {
			EsmBkg1155Event event = (EsmBkg1155Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1162Event")) {
			EsmBkg1162Event event = (EsmBkg1162Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1168Event")) {
			EsmBkg1168Event event = (EsmBkg1168Event) e;
			sKey = event.getKey();
		}
		String strResult = "";
		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(
					sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();

			while (rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0329Event")) {
						// DOWN LOAD Success
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG01088").getUserMessage());
					} else if (e.getEventName().equalsIgnoreCase(
							"EsmBkg0061Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0002Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0006Event")									
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg1046Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg1163Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0730Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0053Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0282Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0497Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0017Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00204").getUserMessage());
					} else if (e.getEventName().equalsIgnoreCase(
							"EsmBkg1106Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00204").getUserMessage());
						// eventResponse.setETCData("RESULT",(String)BackEndJobResult.loadFromFile(sKey));

					} else if (e.getEventName().equalsIgnoreCase(
							"EsmBkg1162Event")) {
						List<ManifestListDetailVO> manifestListDetailVOs = (List<ManifestListDetailVO>) BackEndJobResult
								.loadFromFile(sKey);
						eventResponse.setRsVoList(manifestListDetailVOs);
					} else {
						// Data Saved Successfully!!
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00166").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg0061Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0002Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0006Event")									
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg1046Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg1163Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0730Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0053Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0282Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0497Event")
							|| e.getEventName().equalsIgnoreCase(
									"EsmBkg0017Event")) {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(
									rowSet.getString("JB_USR_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00205").getUserMessage());
						}
					} else if (e.getEventName().equalsIgnoreCase(
							"EsmBkg1162Event")) {
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG06086").getUserMessage());
					} else {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							eventResponse.setUserMessage(rowSet
									.getString("JB_USR_ERR_MSG"));
						} else {
							eventResponse.setUserMessage(new ErrorHandler(
									"BKG00167").getUserMessage());
						}
					}
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0340 : SEARCH <br>
	 * ESM_BKG_0340 : SEARCH03 <br>
	 * ESM_BKG_0341 : SEARCH <br>
	 * ESM_BKG_0341 : SEARCH03 <br>
	 * 
	 * 하선신고서(Discharging Cargo Declaration) 정보를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDischCYList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// EVENT 에 따른 분리
			if (e.getEventName().equals("EsmBkg0340Event")) {
				// 340 처리
				EsmBkg0340Event event = (EsmBkg0340Event) e;
				command = new KorCustomsReportBCImpl();
				// 작업구분에 따른 처리
				if (event.getFormCommand().isCommand((FormCommand.SEARCH))) {
					// BC에 작업 요청
					KorDischCYVO[] korDischCYVOs = (KorDischCYVO[]) command
							.searchDischCYList(event.getKorDischCYCondVO());
					// 결과 처리
					if (korDischCYVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						eventResponse.setRsVoList((List<KorDischCYVO>) Arrays
								.asList(korDischCYVOs));
						// 폼 값 처리
						eventResponse.setETCData("mrn_no",
								korDischCYVOs[0].getMrnNo());
						eventResponse.setETCData("mrn_chk_no",
								korDischCYVOs[0].getMrnChkNo());
						eventResponse.setETCData("vvd",
								korDischCYVOs[0].getVvd());
						eventResponse.setETCData("port_cd",
								korDischCYVOs[0].getPortCd());
					}
				} else if (event.getFormCommand().isCommand(
						(FormCommand.SEARCH03))) {
					// BC에 작업 요청
					KorDischPrintListVO[] korDischPrintListVOs = (KorDischPrintListVO[]) command
							.searchDischPrintList(event
									.getKorDischPrintCondVOs());
					// 결과 처리
					if (korDischPrintListVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						eventResponse
								.setRsVoList((List<KorDischPrintListVO>) Arrays
										.asList(korDischPrintListVOs));
					}
				}
			} else if (e.getEventName().equals("EsmBkg0341Event")) {
				// 341 처리
				EsmBkg0341Event event = (EsmBkg0341Event) e;
				// 작업구분에 따른 처리
				if (event.getFormCommand().isCommand((FormCommand.SEARCH))) {

					// OUT BOUND 의 경우는 MSN 정보를 만들어 준다.
					if (event.getKorDischCYCondVO().getIoBndCd().equals("O")) {
						// DownLoad BC 생성
						ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();

						// Parameter 용 객체
						ObMsnInfoCondVO obMsnInfoCondVO = new ObMsnInfoCondVO();
						ObjectCloner.build(event.getKorDischCYCondVO(),
								obMsnInfoCondVO);
						obMsnInfoCondVO.setUserId(account.getUsr_id());
						begin();
						// BC 에 작업 요청
						command2.manageObMsnInfo(obMsnInfoCondVO);
						commit();

					}

					command = new KorCustomsReportBCImpl();
					// BC에 작업 요청
					KorDischCYVO[] korDischCYVOs = (KorDischCYVO[]) command
							.searchDischCYList(event.getKorDischCYCondVO());

					// 결과 처리
					if (korDischCYVOs == null) {
						// 결과값이 없을 경우
						eventResponse.setETCData("vvd", event
								.getKorDischCYCondVO().getVslCd()
								+ event.getKorDischCYCondVO().getSkdVoyNo()
								+ event.getKorDischCYCondVO().getSkdDirCd());
						eventResponse.setETCData("port_cd", event
								.getKorDischCYCondVO().getPortCd());
					} else {
						eventResponse.setRsVoList((List<KorDischCYVO>) Arrays
								.asList(korDischCYVOs));
						// 폼 값 처리
						eventResponse.setETCData("mrn_no",
								korDischCYVOs[0].getMrnNo());
						eventResponse.setETCData("mrn_chk_no",
								korDischCYVOs[0].getMrnChkNo());
						eventResponse.setETCData("vvd",
								korDischCYVOs[0].getVvd());
						eventResponse.setETCData("port_cd",
								korDischCYVOs[0].getPortCd());
					}
				} else if (event.getFormCommand().isCommand(
						(FormCommand.SEARCH03))) {
					command = new KorCustomsReportBCImpl();
					// BC에 작업 요청
					KorImpPrintListVO[] korImpPrintListVOs = (KorImpPrintListVO[]) command
							.searchImpCgoManiPrtList(event
									.getKorImpPrintCondVOs());
					// 결과 처리
					if (korImpPrintListVOs == null) {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					} else {
						eventResponse
								.setRsVoList((List<KorImpPrintListVO>) Arrays
										.asList(korImpPrintListVOs));
					}
				}
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkgUdevhjsAlpsbkgEntry : <br>
	 * EsmBkgUdevhjsAlpsbkgKrcusEvent : <br>
	 * ANCS EDI 수신 메시징 에 대한 로깅 처리.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		log.info("SC [loadCstmsRcvMsg] Start---------------------");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		ManifestListDownloadBC command2 = null;
		try {
			// if(!e.getEventName().equalsIgnoreCase("Ubiz2hjsAlpsbkgAmsAckEvent")){
			begin();
			// }
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkgSlkcusAckEvent")) {
				// 스리랑카 수신
				EsmBkgSlkcusAckEvent event = (EsmBkgSlkcusAckEvent) e;
				command = new SrilankaCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "");
			}
			if (e.getEventName().equalsIgnoreCase(
					"EsmBkgUbizhjsAlpsbkgAnrackEvent")) {
				EsmBkgUbizhjsAlpsbkgAnrackEvent event = (EsmBkgUbizhjsAlpsbkgAnrackEvent) e;
				command = new AncsCustomsTransmissionBCImpl();
				command2 = new AncsManifestListDownloadBCImpl();
				// 1단계
				AncsRcvMsgVO ancsRcvMsgVO = (AncsRcvMsgVO) command
						.loadCstmsRcvMsg(event.getFlatFile(), account);
				// String sRcvSts = ancsRcvMsgVO.getRcvSts();
				String sMsgId = ancsRcvMsgVO.getMsgId();
				if ("CUSREP".equals(sMsgId))
					sMsgId = "R";
				else
					sMsgId = "C";
				String sAnrMsgStsCd = "N";
				if ("44".equals(ancsRcvMsgVO.getRcvSts())) {
					sAnrMsgStsCd = "A";
				} else {
					sAnrMsgStsCd = "N";
				}
				// 2단계
				if ("R".equals(sMsgId)) {
					AncsVesselInfoVO[] ancsVesselInfoVOs = new AncsVesselInfoVO[1];
					AncsVesselInfoVO ancsVesselInfoVO = new AncsVesselInfoVO();
					ancsVesselInfoVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsVesselInfoVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					ancsVesselInfoVO.setAnrMsgStsCd(sAnrMsgStsCd);
					ancsVesselInfoVOs[0] = ancsVesselInfoVO;
					command2.manageCstmsVesselInfo(ancsVesselInfoVOs, account);
				} else if ("C".equals(sMsgId)) {
					AncsCstmsAnrBlVO ancsCstmsAnrBlVO = new AncsCstmsAnrBlVO();
					AncsBkgCstmsAnrCntrVO ancsBkgCstmsAnrCntrVO = new AncsBkgCstmsAnrCntrVO();
					ancsCstmsAnrBlVO.setAnrMsgStsCd("A");
					ancsCstmsAnrBlVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsCstmsAnrBlVO.setMsgTpCd(sMsgId);
					ancsCstmsAnrBlVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					ancsBkgCstmsAnrCntrVO.setAnrMsgStsCd(sAnrMsgStsCd);
					ancsBkgCstmsAnrCntrVO
							.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					ancsBkgCstmsAnrCntrVO.setMsgTpCd(sMsgId);
					ancsBkgCstmsAnrCntrVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
					AncsCstmsBlContainerVO[] ancsCstmsBlContainerVOs = new AncsCstmsBlContainerVO[1];
					ancsCstmsBlContainerVOs[0] = new AncsCstmsBlContainerVO();
					ancsCstmsBlContainerVOs[0].setRcv("Y");
					ancsCstmsBlContainerVOs[0]
							.setAncsCstmsAnrBlVO(ancsCstmsAnrBlVO);
					ancsCstmsBlContainerVOs[0]
							.setAncsBkgCstmsAnrCntrVO(ancsBkgCstmsAnrCntrVO);
					command2.manageCstmsBl(ancsCstmsBlContainerVOs, account);
				}
				// eventResponse.setETCData( etcData );
			} else if (e.getEventName().equalsIgnoreCase(
					"UbizhjsAlpsBkgCancusAckEvent")) {
				
				BookingUtil utilCmd = new BookingUtil();
				utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE_SC","1 "+  e.getEventName()); 
				
				log.info("<<<<<<<<<< SC UbizhjsAlpsBkgCancusAckEvent Start >>>>>>>>>>>>>>>>");
				// Canada 수신
				UbizhjsAlpsBkgCancusAckEvent event = (UbizhjsAlpsBkgCancusAckEvent) e;
				command = new CndCustomsTransmissionBCImpl();
				CstmsRcvLogVO cstmsRcvLogVO = event.getCstmsRcvLogVO();
				command.loadCstmsRcvMsg(cstmsRcvLogVO);

				//BAPLIE HoldNotice 제외
				if ( !"BRC".equals(((CndCstmsRcvLogVO)cstmsRcvLogVO).getRcvMsgTpId())){				
					command2 = new CndManifestListDownloadBCImpl();
					
					//@결과 업데이트
					CndCstmsRcvLogVO cndCstmsRcvLogVO = (CndCstmsRcvLogVO) command2.loadCstmsRcvMsg(cstmsRcvLogVO);
	
					// Warning 이벤트 Send
					List<CstmsHldVO> cstmsHldSends = cndCstmsRcvLogVO
							.getCstmsHldSendVOs();
					if (cstmsHldSends != null) {
						HoldNoticeBC command3 = new HoldNoticeBCImpl();
						for (int k = 0; k < cstmsHldSends.size(); k++) {
							// try catch 중첩허용 타모듈 호출
							try {
								// 1. Warning 이벤트 Send
								command3.sendAmsNtcToObStaff(cstmsHldSends.get(k));
								command3.sendAmsNtcToBkgStaff(cstmsHldSends.get(k));
							} catch (Exception ce) {
								log.error("Warning 이벤트 Send Error");
							}
						}
					}
				}
				log.info("<<<<<<<<<< SC UbizhjsAlpsBkgCancusAckEvent End >>>>>>>>>>>>>>>>");
			} else if (e.getEventName().equalsIgnoreCase(
					"AlpsbkgUbizhjsEurcusAckEvent")) { // Eur - ETA 수신
				AlpsbkgUbizhjsEurcusAckEvent event = (AlpsbkgUbizhjsEurcusAckEvent) e;
				command = new EurCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "");
			} else if (e.getEventName().equalsIgnoreCase(
					"AlpsbkgUbizhjsEur24cusAckEvent")) { // Eur - ETA 수신
				AlpsbkgUbizhjsEur24cusAckEvent event = (AlpsbkgUbizhjsEur24cusAckEvent) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile(), "");
			} else if (e.getEventName().equalsIgnoreCase(
					"EsmBkgUdevhjsAlpsbkgEntryEvent")) { // Kor - 배정정보 수신
				EsmBkgUdevhjsAlpsbkgEntryEvent event = (EsmBkgUdevhjsAlpsbkgEntryEvent) e;
				command2 = new KorManifestListDownloadBCImpl();
				KorRcvMsgVO korRcvMsgVO = new KorRcvMsgVO();
				korRcvMsgVO.setFlatFile(event.getFlatFile());
				// try catch 중첩허용 동시처리 PK 오류 SKIP
				try {
					command2.loadCstmsRcvMsg(korRcvMsgVO);
				} catch (Exception ke) {
					log.error("EsmBkgUdevhjsAlpsbkgEntryEvent KorManifestListDownloadBCImpl error");
				}
			} else if (e.getEventName().equalsIgnoreCase(
					"UbizhjsAlpsbkgNaccsReplyEvent")) {
				// Japan 수신
				UbizhjsAlpsBkgNaccsReplyEvent event = (UbizhjsAlpsBkgNaccsReplyEvent) e;
				command = new JapanCustomsTransmissionBCImpl();
				String rcvMsg = event.getRcvMsg();
				command.loadCstmsRcvMsg(rcvMsg);
			} else if (e.getEventName().equalsIgnoreCase(
					"AlpsBkgTCncusAckEvent")) {
				// China 수신
				AlpsBkgTCncusAckEvent event = (AlpsBkgTCncusAckEvent) e;
				command = new ChinaCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile());
			} else if (e.getEventName().equalsIgnoreCase("Ubiz2hjsAlpsbkgAmsAckEvent")) {
				
				// 미세관 응답메세지 수신.
				Ubiz2hjsAlpsbkgAmsAckEvent event = (Ubiz2hjsAlpsbkgAmsAckEvent) e;
				command = new UsaCustomsTransmissionBCImpl();
				UsaRcvMsgVO usaRcvMsgVO = new UsaRcvMsgVO();
				usaRcvMsgVO.setRcvMsg(event.getFlatFile());
				UsaRcvMsgVO rcvVO = (UsaRcvMsgVO) command.loadCstmsRcvMsg(usaRcvMsgVO);
				// try catch 중첩허용 타모듈 호출
				try {
					
					// CFlag가 Y -> N으로 변경시
					List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = rcvVO.getBkgCstmsAdvIbdVOs();
					if (bkgCstmsAdvIbdVOs != null) {
						ManifestListDownloadBC manifestBC = new UsaManifestListDownloadBCImpl();
						manifestBC.modifyIbdCstmsClrCngFlg(bkgCstmsAdvIbdVOs);
					}
				} catch (Exception ce) { 
					log.error("CFlag  Y -> N으로 변경");
				}
				// Cargo Release 호출
				List<CstmsClrVO> cstmsClrs = rcvVO.getCstmsClrVOs();
				if (cstmsClrs != null) {
					log.info("Cargo Release Start");
					CargoReleaseOrderBC command3 = new CargoReleaseOrderBCImpl();
					for (int k = 0; k < cstmsClrs.size(); k++) {
						// try catch 중첩허용 타모듈 호출
						try {
							command3.setupFocByCstms(cstmsClrs.get(k));
						} catch (Exception ce) {
							log.error("Cargo Release Error");
						}
					}
				}
				// Hold Notice('PH', 'CF') 호출
				List<CstmsHldVO> cstmsHlds = rcvVO.getCstmsHldVOs();
				if (cstmsHlds != null) {
					HoldNoticeBC command3 = new HoldNoticeBCImpl();
					BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
					for (int k = 0; k < cstmsHlds.size(); k++) {
						// try catch 중첩허용 타모듈 호출
						try {
							// 1. Hold Notice
							List<BkgNtcHisVO> bkgNtcHisVOs = command3
									.createCstmsHld(cstmsHlds.get(k));
							// 2. Register Notice History
							bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs,
									"UBIZ2HJS_ALPSBKG_T_AMS_ACK");
						} catch (Exception ce) {
							log.error("Hold Notice('PH', 'CF') Error");
						}
					}
				}
				
				// Warning 이벤트 Send
				List<CstmsHldVO> cstmsHldSends = rcvVO.getCstmsHldSendVOs();
				if (cstmsHldSends != null) {
					HoldNoticeBC command3 = new HoldNoticeBCImpl();
					for (int k = 0; k < cstmsHldSends.size(); k++) {
						// try catch 중첩허용 타모듈 호출
						try {
							// 1. Warning 이벤트 Send
							String gubun = SubSystemConfigFactory
									.get("BKG.MFT.SERVICE.MODE");
							if (gubun == null)
								gubun = "N";
							// TEST 일때는 GW, Alert 전송하지 않음. (ACE M1 테스트용)
							if (!gubun.equals("TEST")) {
								command3.sendAmsNtcToObStaff(cstmsHldSends
										.get(k));
								command3.sendAmsNtcToBkgStaff(cstmsHldSends
										.get(k));
							}

						} catch (Exception ce) {
							log.error("Warning 이벤트 Send Error");
						}
					}
				}
			} else if (e.getEventName().equalsIgnoreCase(
					"EsmBkgUdevhjsAlpsbkgKrcusEvent")) { // Kor - 한국세관 ACK 수신
				EsmBkgUdevhjsAlpsbkgKrcusEvent event = (EsmBkgUdevhjsAlpsbkgKrcusEvent) e;
				command = new KorCustomsTransmissionBCImpl();
				KorRcvAckMsgVO korRcvAckMsgVO = new KorRcvAckMsgVO();
				korRcvAckMsgVO.setFlatFile(event.getFlatFile());
				command.loadCstmsRcvMsg(korRcvAckMsgVO);
			} else if (e.getEventName().equalsIgnoreCase(
					"AlpsbkgSpainCRNReceiveEvent")) { // Eur - Customs
														// Reference# I/F from
														// Local System to ALPS
				AlpsbkgSpainCRNReceiveEvent event = (AlpsbkgSpainCRNReceiveEvent) e;
				command = new EurCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile());
			} else if (e.getEventName().equalsIgnoreCase(
					"UbizhjsAlpsbkgKrcusAckEvent")) { // Kor - 한국세관 PORTAL 수신
				UbizhjsAlpsbkgKrcusAckEvent event = (UbizhjsAlpsbkgKrcusAckEvent) e;
				command = new KorCustomsTransmissionBCImpl();
				command.loadCstmsRcvMsg(event.getFlatFile());
			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0989 : SEARCH <br>
	 * KOREA에서 입/출항 선박 신고 적하목록 전송 문서의 상세 내역 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		EsmBkg0989Event event = (EsmBkg0989Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorTransmitHistDtlVO[] korTransmitHistDtlVOs = (KorTransmitHistDtlVO[]) command
					.searchTransmitHistDtl(event.getKorTransmitHistDtlCondVO());
			// 결과 처리
			if (korTransmitHistDtlVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorTransmitHistDtlVO>) Arrays
						.asList(korTransmitHistDtlVOs));
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
	 * ESM_BKG_0345 : SEARCH <br>
	 * 한국세관, 일본세관, 인도세관 Manifest 신고 등록시 Warehouse(Bonded Area) Detail을 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWareHouseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		EsmBkg0345Event event = (EsmBkg0345Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorWareHouseVO[] korWareHouseVOs = (KorWareHouseVO[]) command
					.searchWareHouseInfo(event.getKorWareHouseCondVO());
			// 결과 처리
			if (korWareHouseVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorWareHouseVO>) Arrays
						.asList(korWareHouseVOs));
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
	 * ESM_BKG_0358 : SEARCH <br>
	 * 한국 세관 신고용 화물 관리 번호 Master Reference Number를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMRNNoList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		EsmBkg0358Event event = (EsmBkg0358Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			KorMrnVO[] korMrnVOs = (KorMrnVO[]) command.searchMRNNoList(event
					.getKorMrnCondVO());
			// 결과 처리
			if (korMrnVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorMrnVO>) Arrays
						.asList(korMrnVOs));
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
	 * ESM_BKG_0371 : SEARCH <br>
	 * MRN 정보 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMrnInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		KorMrnCreateInfoVO[] korMrnCreateInfoVOs = null;
		EsmBkg0371Event event = (EsmBkg0371Event) e;
		try {
			command = new KorCustomsTransmissionBCImpl();
			// BC에 작업 요청
			// 결과 처리
			korMrnCreateInfoVOs = (KorMrnCreateInfoVO[]) command
					.searchMrnCreateInfo(event.getKorMrnCreateInfoCondVO());

			if (korMrnCreateInfoVOs != null) {
				// FORM용 ETC DATA 셋팅
				// MRN CHK NO
				eventResponse.setETCData("mrn4",
						korMrnCreateInfoVOs[0].getMrnChkNo());
				// 결과 리스트 배열 넘김
				eventResponse.setRsVoList((List<KorMrnCreateInfoVO>) Arrays
						.asList(korMrnCreateInfoVOs));
			} else {
				// MRN CHK NO
				eventResponse.setETCData("mrn4", "");
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
	 * ESM_BKG_0034 : SEARCH04 <br>
	 * ESM_BKG_0947 : INIT, SEARCH <br>
	 * ESM_BKG_0041 : SEARCH03 <br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDispositionCdList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0947Event")) {
				EsmBkg0947Event event = (EsmBkg0947Event) e;
				DispoCdListCondVO dispoCdListCondVO = event
						.getDispoCdListCondVO();
				command = new UsaManifestListDownloadBCImpl();
				List<DispoCdDetailVO> dispoCdDetailVOs = command
						.searchDispositionCdList(dispoCdListCondVO);
				// 결과 처리
				if (dispoCdDetailVOs == null) {
					// 결과값이 없을 경우 오류 리턴
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					eventResponse.setRsVoList(dispoCdDetailVOs);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				EsmBkg0034Event event = (EsmBkg0034Event) e;
				DispoCdListCondVO dispoCdListCondVO = event
						.getDispoCdListCondVO();
				command = new UsaManifestListDownloadBCImpl();
				List<DispoCdDetailVO> list = command
						.searchDispositionCdList(dispoCdListCondVO);
				eventResponse.setRsVoList(list);
			}
			// dwkim, 0041, Ams Report page, Customs Result Code list search.
			else if (e.getEventName().equals("EsmBkg0041Event")) {
				CustomsReportBC command3 = new UsaCustomsReportBCImpl();
				// 0. BC에 Disposition 코드조회 작업 요청 및 결과값 셋업.
				eventResponse.setRsVoList(command3.searchDispositionCdList());
				// Rcv Term cd, De Term Cd 등을 조회하기 위한 유틸 BC 선언.
				BookingUtil command2 = new BookingUtil();
				// ALL 옵션을 위한 기본 콤보 객체 선언.
				BkgComboVO combovo = new BkgComboVO();
				combovo.setDesc("");
				combovo.setName("");
				// 1. R- OUTBOUND RECEIVED
				List<BkgComboVO> list = command2.searchCombo("CD00764");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 2. D- INBOUND DELIVERY
				list = command2.searchCombo("CD00765");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 3. FILER
				list = command2.searchCombo("CD02268");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 4. customs_result_code_grp
				list = command2.searchCombo("CD02571");
				list.add(0, combovo);
				eventResponse.setRsVoList(list);
				// 5.EQ Control OFC
				List<MdmLocationVO> list2 = command3.searchEQCtrlOfcCdList();
				eventResponse.setRsVoList(list2);
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
	 * ESM_BKG_0947 : MULTI <br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDispositionCdList(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0947Event event = (EsmBkg0947Event) e;
			command = new UsaManifestListDownloadBCImpl();
			command.manageDispositionCdList(event.getDispoCdDetailVOs(),
					account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0518 : SEARCH <br>
	 * Hold Notice를 송부를 위하여 Customs에서 받는 특정 Code를 등록 및 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlListByCntr(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0518Event event = (EsmBkg0518Event) e;
		try {
			command = new UsaCustomsReportBCImpl();
			// BC에 작업 요청
			List<ContainerDetailVO> containerDetailVOs = command
					.searchBlListByCntr(event.getCntrNo(), event.getVvd(),
							event.getBlType());

			// 결과 처리
			if (containerDetailVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList(containerDetailVOs);
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
	 * ESM_BKG_0408 : SEARCH02 <br>
	 * PMIB NO를 구한후 BL에 할당.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse assignInBondNumber(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// PMIB NO의 MAX순차를 찾은후 1씩 증가시키므로 Transaction 관리가 필요함.
			begin();

			EsmBkg0408Event event = (EsmBkg0408Event) e;
			// BCImpl 객체 생성.
			command = new UsaManifestListDownloadBCImpl();
			// 이벤트로 부터 sheet1 SaveXml Data 추출.
			UsaInbondManifestListVO[] vos = event.getUsaInbondManifestListVOS();
			UsaInbondManifestDetailListVO[] vos2 = event
					.getUsaInbondManifestDetailListVOS();
			int i = 0;
			int len = 0;
			if (vos != null)
				len += vos.length;
			if (vos2 != null)
				len += vos2.length;
			// BCImpl의 매개변수에 맞도록 형 변환.
			InBondNumberVO[] inVos = new InBondNumberVO[len];
			if (vos != null) {
				for (i = 0; i < vos.length; i++) {
					inVos[i] = new InBondNumberVO();
					inVos[i].setVvd(vos[i].getVvd());
					inVos[i].setPod(vos[i].getPodCd());
					inVos[i].setHub(vos[i].getHubLocCd());
					inVos[i].setDel(vos[i].getDelCd());
					inVos[i].setCstms(vos[i].getCstmsLocCd());
					inVos[i].setBlNo("");
					inVos[i].setUserId(account.getUsr_id());
					inVos[i].setOfcCd(account.getOfc_cd());
				}
			}
			if (vos2 != null) {
				for (int j = 0; j < vos2.length; j++) {
					inVos[i] = new InBondNumberVO();
					inVos[i].setVvd(vos2[j].getVvd());
					inVos[i].setPod(vos2[j].getPodCd());
					inVos[i].setHub(vos2[j].getHubLocCd());
					inVos[i].setDel(vos2[j].getDelCd());
					inVos[i].setCstms(vos2[j].getCstmsLocCd());
					inVos[i].setBlNo(vos2[j].getBlNo());
					inVos[i].setUserId(account.getUsr_id());
					inVos[i].setOfcCd(account.getOfc_cd());
					i++;
				}
			}
			// BC 호출.
			List<InBondNumberDetailVO> rtnVos = command
					.assignInBondNumber(inVos);
			// 결과 처리
			if (rtnVos == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList(rtnVos);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0505 : COMMAND01 <br>
	 * 초기 BKG_NO 생성<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTempBlNoNBkgNoAssign(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			// 처리용 객체
			KorTmpBlBkgVO tmpBlBkgVO = new KorTmpBlBkgVO();
			command = new KorManifestListDownloadBCImpl();
			tmpBlBkgVO.setUserId(account.getUsr_id());
			tmpBlBkgVO.setOfcCd(account.getOfc_cd());
			tmpBlBkgVO = (KorTmpBlBkgVO) command
					.searchTempBlNoNBkgNoAssign(tmpBlBkgVO);
			eventResponse.setETCData("bkg_no", tmpBlBkgVO.getBkgNo());
			eventResponse.setETCData("bl_no", tmpBlBkgVO.getBlNo());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0257 : SEARCH05 <br>
	 * GB지역 UVI정보를 찾아온다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUvi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			command = new EurCustomsTransmissionBCImpl();
			String retUvi = command.searchUvi(event.getVvdCd(),
					event.getPolCd(), event.getPodCd());
			eventResponse.setETCData("uvi", retUvi);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0371 : MULTI, REMOVE <br>
	 * 
	 * MRN CREATE 추가<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMrnCreateInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		KorMrnCreateInfoVO[] mrnCreateInfoVOs = null;
		// KorMrnCreateInfoVO mrnCreateInfoVO = null;
		KorMrnCreateInfoVO[] condVOs = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0371Event")) {
				EsmBkg0371Event event = (EsmBkg0371Event) e;
				command = new KorCustomsTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					// ADD
					condVOs = event.getKorMrnCreateInfoVOs();

					for (int i = 0; i < condVOs.length; i++) {

						condVOs[i].setUserId(account.getUsr_id());
						mrnCreateInfoVOs = (KorMrnCreateInfoVO[]) command
								.manageMrnCreateInfo(condVOs[i]);

						// 처리결과를 ETC DATA 에 담기
						// if(mrnCreateInfoVOs != null)
						// {
						// for(int i = 0; i < mrnCreateInfoVOs.length; i++)
						// {
						// mrnCreateInfoVO = mrnCreateInfoVOs[i];
						// eventResponse.setETCData("vvd" +(i + 1) + "_stdt",
						// mrnCreateInfoVO.getVpsEtaDt());
						// eventResponse.setETCData("vvd" +(i + 1) + "_enddt",
						// mrnCreateInfoVO.getVpsEtdDt());
						// }
						// }

						// 처리후 MRN 정보 - VV1, VVD2정보 BKG_CSTMS_KR_MF_REF_NO
						// TABLE에 INSERT
						KorMrnCreateCondVO korMrnCreateCondVO = new KorMrnCreateCondVO();
						ObjectCloner.build(condVOs[i], korMrnCreateCondVO);
						ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
						command2.manageMrnCreateInfo(korMrnCreateCondVO);

					}
					// 성공메시지
					eventResponse.setUserMessage(new ErrorHandler("BKG00166")
							.getUserMessage());
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					// REMOVE
					ManifestListDownloadBC command2 = new KorManifestListDownloadBCImpl();
					KorMrnCreateInfoVO[] mrnCreateInfoVOs1 = event
							.getKorMrnCreateInfoVOs();
					command2.removeMrnMsnCreateInfo(mrnCreateInfoVOs1);
					// EDI 전송
					KorIftsaiSndCondVO[] iftsaiSndCondVOs = new KorIftsaiSndCondVO[mrnCreateInfoVOs1.length];
					for (int i = 0; i < mrnCreateInfoVOs1.length; i++) {
						iftsaiSndCondVOs[i] = new KorIftsaiSndCondVO();
						iftsaiSndCondVOs[i].setVvd1(mrnCreateInfoVOs1[i]
								.getVvd());
						iftsaiSndCondVOs[i].setPortCd(mrnCreateInfoVOs1[i]
								.getPortCd());
						iftsaiSndCondVOs[i].setMrnNo(mrnCreateInfoVOs1[i]
								.getMrnNo());
						iftsaiSndCondVOs[i].setMrnChkNo(mrnCreateInfoVOs1[i]
								.getMrnChkNo());
						iftsaiSndCondVOs[i].setIoBndCd(mrnCreateInfoVOs1[i]
								.getIoBndCd());
						iftsaiSndCondVOs[i].setUserId(account.getUsr_id());
					}
					command.searchIFTSAISnd(iftsaiSndCondVOs);

					// 성공메시지
					eventResponse.setUserMessage(new ErrorHandler("BKG00593")
							.getUserMessage());
				}
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0338 : SEARCH, SEARCH01, SEARCH02 <br>
	 * MSN Bonded Info 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMsnBondedInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					KorMsnBondInfoVO[] korMsnBondInfoVOs = (KorMsnBondInfoVO[]) command
							.searchMsnBondedInfo(event.getKorMsnBondInfoVO());
					if (korMsnBondInfoVOs != null
							&& korMsnBondInfoVOs.length > 0) {
						KorMsnBondInfoVO korMsnBondInfoVO = korMsnBondInfoVOs[0];
						// MSN 첫번째 값 셋팅
						eventResponse.setETCData("msn1",
								korMsnBondInfoVO.getMsnNo());
						// 조회 결과 리스트 셋팅
						if (event.getKorMsnBondInfoVO().getType()
								.equalsIgnoreCase("LOCAL")) {
							eventResponse
									.setRsVoList((List<KorBondLocalInfoVO>) Arrays
											.asList(korMsnBondInfoVO
													.getBondLocalInfoVOs()));
						} else {
							eventResponse
									.setRsVoList((List<KorBondTsInfoVO>) Arrays
											.asList(korMsnBondInfoVO
													.getBondTsInfoVOs()));
						}
					} else {
						// 결과값이 없을 경우 오류 리턴
						eventResponse.setUserMessage(new ErrorHandler(
								"BKG00889").getUserMessage());
					}
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					// Disch CY validation Check
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					String rv = command.searchDischCyValChk(event.getDischCy());

					eventResponse.setETCData("disc_valid", rv);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					// MSN Assign Check
					EsmBkg0338Event event = (EsmBkg0338Event) e;
					command = new KorManifestListDownloadBCImpl();
					String checkVal = command.searchMsnValChk(event
							.getBkgCstmsKrMfSeqNoVO());

					if (checkVal == null)
						checkVal = "X";
					else
						checkVal = "";

					eventResponse.setETCData("msn_valid", checkVal);
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
	 * ESM_BKG_0359 : MULTI <br>
	 * MSN Bonded Info UPDATE<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMsnBondedInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0338Event")) {
				EsmBkg0338Event event = (EsmBkg0338Event) e;
				command = new KorManifestListDownloadBCImpl();
				KorBondTsInfoVO[] korBondInfoVOs = event.getKorBondInfoVOs();
				// 파라메터 객체 생성
				KorMsnBondInfoVO korMsnBondInfoVO = new KorMsnBondInfoVO();
				korMsnBondInfoVO.setBondTsInfoVOs(korBondInfoVOs);
				BkgCstmsKrMfSeqNoVO[] bkgCstmsKrMfSeqNoVOs = command
						.modifyMsnBondedInfo(korMsnBondInfoVO);

				// BL_ISS 및 BL_DOC 처리
				if (bkgCstmsKrMfSeqNoVOs != null) {

					BkgBlIssVO bkgBlIssVO = new BkgBlIssVO();
					BLIssuanceBC command2 = new BLIssuanceBCImpl();
					BkgBlDocVO bkgBlDocVO = new BkgBlDocVO();
					BLDocumentationBLBC command3 = new BLDocumentationBLBCImpl();

					// Loop
					for (int i = 0; i < bkgCstmsKrMfSeqNoVOs.length; i++) {
						// Parameter 셋팅
						bkgBlIssVO.setCstmsEntrCd(bkgCstmsKrMfSeqNoVOs[i]
								.getCstmsClrTpCd());
						bkgBlIssVO.setCstmsClrLocCd(bkgCstmsKrMfSeqNoVOs[i]
								.getCstmsClrLocCd());
						bkgBlIssVO.setCstmsClrWhNm(bkgCstmsKrMfSeqNoVOs[i]
								.getCstmsClrWhCd());
						bkgBlIssVO.setBkgNo(bkgCstmsKrMfSeqNoVOs[i].getBkgNo());
						bkgBlIssVO.setUpdUsrId(account.getUsr_id());
						// BC에 작업 요청
						command2.modifyIbDtlBlIss(bkgBlIssVO);

						// Parameter 셋팅
						bkgBlDocVO.setIbMfCfmFlg(bkgCstmsKrMfSeqNoVOs[i]
								.getMsnCfmFlg());
						bkgBlDocVO.setBkgNo(bkgCstmsKrMfSeqNoVOs[i].getBkgNo());
						bkgBlDocVO.setUpdUsrId(account.getUsr_id());
						// BC에 작업 요청
						command3.modifyBlDoc(bkgBlDocVO);
					}

				}

				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM0740001Event : <br>
	 * 선박별 인증서 만료일(Certificate Expire Date) 업로드<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadVslCertiExpDt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			ESM0740001Event event = (ESM0740001Event) e;
			command = new CndManifestListDownloadBCImpl();
			command.loadVslCertiExpDt(event.getCndCstmsVesselInfoVO());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0359 : SEARCH <br>
	 * Manifest Status Cross-Check 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmissionCheckList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0359Event event = (EsmBkg0359Event) e;
			command = new UsaCustomsReportBCImpl();
			// BC 호출.
			List<CheckListDetailListVO> list = command
					.searchTransmissionCheckList(event.getCondVo());
			// 조회결과가 있는 경우 결과값 추출.
			if (list != null) {
				CheckListDetailListVO vo = list.get(0);
				// 처음 탭(Manifest Status) 관련 결과값 리스트 셋업.
				if (vo.getManifestStatusResultList() != null) {
					eventResponse.setRsVoList(vo.getManifestStatusResultList());
				}
				// 두번째 탭(BL to be Delete) 관련 결과값 리스트 셋업.
				if (vo.getManifestStatusResultList() != null) {
					eventResponse.setRsVoList(vo.getBlToBeDeletedResultList());
				}
			} else {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
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
	 * ESM_BKG_0393 : SEARCH <br>
	 * 세관신고전 House B/L의 Data의 정확성 유무를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHouseBlDataList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0393Event event = (EsmBkg0393Event) e;
			if (event.getCustoms().startsWith(CountryCode.US)) {
				command = new UsaManifestListDownloadBCImpl();
				List<HouseBlDetailVO> list = command.checkHouseBlDataList(event
						.getHouseBlCondVO());
				if (list.size() > 1) {
					UsaHblCheckDetailVO detailVO = (UsaHblCheckDetailVO) list
							.get(0);
					list.remove(0);
					eventResponse.setETCData(detailVO.getColumnValues());
				}
				eventResponse.setRsVoList(list);
			} else if (event.getCustoms().startsWith(CountryCode.CA)) {
				command = new CndManifestListDownloadBCImpl();
				List<HouseBlDetailVO> list = command.checkHouseBlDataList(event
						.getHouseBlCondVO());
				if (list.size() > 1) {
					HusBlInpChkVO detailVO = (HusBlInpChkVO) list.get(0);
					list.remove(0);
					eventResponse.setETCData(detailVO.getColumnValues());
				}
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0031 : COMMAND02 <br>
	 * ESM_BKG_0505 : COMMAND02 <br>
	 * ESM_BKG_0217 : SEARCH01 <br>
	 * 
	 * 컨테이너 TYPE 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0505Event")) {
				EsmBkg0505Event event = (EsmBkg0505Event) e;
				command = new KorManifestListDownloadBCImpl();
				String tpszCd = command.searchContainerType(event
						.getKorContainerCondVO());
				eventResponse.setETCData("tpsz_cd", tpszCd);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				command = new KorManifestListDownloadBCImpl();
				String tpszCd = command.searchContainerType(event
						.getKorContainerCondVO());
				eventResponse.setETCData("tpsz_cd", tpszCd);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
				EsmBkg0217Event event = (EsmBkg0217Event) e;
				CustomsTransmissionBC command2 = new ChinaCustomsTransmissionBCImpl();
				String cntrTpszCd = command2.searchContainerType(event
						.getContainerCondVO());
				if (cntrTpszCd == null) {
					eventResponse.setETCData("cntr_no", "");
				} else {
					String[] cntrData = cntrTpszCd.split("\t");
					eventResponse.setETCData("cntr_no", cntrData[0]);
					eventResponse.setETCData("cntr_tpsz_cd", cntrData[1]);
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
	 * ESM_BKG_1023 : SEARCH <br>
	 * Vessel Stowage Plan Transmit 화면을 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageManifestList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			// Canada와 US 동일한 화면 사용			
			if (event.getCustoms().endsWith("US")) {
				command = new UsaCustomsTransmissionBCImpl();
			} else {
				command = new CndCustomsTransmissionBCImpl();
			}
			// BC 호출.
			List<ManifestTransmitVO> list = command.searchStowageManifestList(event.getUsaStowageManifestCondVO());
			// 결과 셋업.
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1023 : MULTI <BR>
	 * Vessel Stowage Plan Transmit 실행.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitStowageManifest(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		String key = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1023Event event = (EsmBkg1023Event) e;
			// BackEnd
			// Canada와 US 동일한 화면 사용
			if (event.getCustoms().endsWith("US")) {
				command = new UsaCustomsTransmissionBCImpl();
				StiDetailVO[] detailVOs = event.getUsaStowageManifestDetailVOs();
				if (detailVOs != null) {
					for (int i = 0; i < detailVOs.length; i++) {
						detailVOs[i].setTmp1(account.getUsr_id());
						detailVOs[i].setTmp2(account.getOfc_cd());
					}
				}
				key = command.startBackEndJob(account, detailVOs,"ESM_BKG_1023");
			} else {
				command = new CndCustomsTransmissionBCImpl();
				StiDetailCndVO[] detailVOs = event.getCndStowageManifestDetailVOs();
				if (detailVOs != null) {
					for (int i = 0; i < detailVOs.length; i++) {
						detailVOs[i].setTmp1(account.getUsr_id());
						detailVOs[i].setTmp2(account.getOfc_cd());
					}
				}
				key = command.startBackEndJob(account, detailVOs,"ESM_BKG_1023");
			}
			eventResponse.setETCData("KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0031 : SEARCH<br>
	 * ESM_BKG_0217 : SEARCH <br>
	 * BL INFO 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;

		try {
			String eventName = e.getEventName();
			// 이벤트별 Impl생성
			if (eventName.equalsIgnoreCase("EsmBkg0031Event")) {
				EsmBkg0031Event event = (EsmBkg0031Event) e;
				KorBlInfoCondVO blInfoCondVO = event.getKorBlInfoCondVO();
				command = new KorManifestListDownloadBCImpl();
				KorBlInfoVO korBlInfoVO = (KorBlInfoVO) command
						.searchBlInfo(blInfoCondVO);
				if (korBlInfoVO.getKorAmendInfoVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorAmendInfoVO()
							.getColumnValues());
				if (korBlInfoVO.getKorCorrTransVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorCorrTransVO()
							.getColumnValues());
				if (korBlInfoVO.getKorCustCorrVO() != null)
					eventResponse.setETCData(korBlInfoVO.getKorCustCorrVO()
							.getColumnValues());
				eventResponse.setETCData("cgo_spec", korBlInfoVO.getCgoSpec());
				eventResponse.setRsVoList((List<KorCntrCorrVO>) Arrays
						.asList(korBlInfoVO.getKorCntrCorrVOs()));
				eventResponse.setRsVoList((List<KorExpCorrVO>) Arrays
						.asList(korBlInfoVO.getKorExpCorrVOs()));
				eventResponse.setRsVoList((List<KorCorrListVO>) Arrays
						.asList(korBlInfoVO.getKorCorrListVOs()));
			} else if (eventName.equalsIgnoreCase("EsmBkg0217Event")) {
				EsmBkg0217Event event = (EsmBkg0217Event) e;
				BlInfoCondVO blInfoCondVO = event.getBlInfoCondVO();
				CustomsTransmissionBC command2 = new ChinaCustomsTransmissionBCImpl();
				ChinaBlInfoVO blInfoVO = (ChinaBlInfoVO) command2
						.searchBlInfo(blInfoCondVO);
				if (blInfoVO.getChinaBlGeneralListVO() != null)
					eventResponse.setETCData(blInfoVO.getChinaBlGeneralListVO()
							.getColumnValues());
				if (blInfoVO.getChinaBlCustListVO() != null)
					eventResponse.setETCData(blInfoVO.getChinaBlCustListVO()
							.getColumnValues());
				eventResponse.setRsVoList(blInfoVO.getChinaBlCntrListVOs());
				eventResponse.setRsVoList(blInfoVO
						.getChinaBlDangerCntrListVOs());
			} else if (eventName.equalsIgnoreCase("EsmBkg1107Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg1107Event event = (EsmBkg1107Event) e;
					Eur24BlInfoCondVO eur24BlInfoCondVO = event
							.getEur24BlInfoCondVO();
					Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
					Eur24BlInfoVO eur24BlInfoVO = (Eur24BlInfoVO) command2
							.searchBlInfo(eur24BlInfoCondVO);

					if (eur24BlInfoVO.getEur24BlGeneralInfoVO() != null)
						eventResponse.setETCData(eur24BlInfoVO
								.getEur24BlGeneralInfoVO().getColumnValues());
					if (eur24BlInfoVO.getEur24BlCustVO() != null)
						eventResponse.setETCData(eur24BlInfoVO
								.getEur24BlCustVO().getColumnValues());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlDangerCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrMFListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrSealNoListVOs());
					// 2010.11.30 김영철 [] R4J - 빈 Block문자들를 점검함.
					// }else
					// if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
					// EsmBkg1107Event event =(EsmBkg1107Event) e;
					// Eur24BlInfoCondVO eur24BlInfoCondVO =
					// event.getEur24BlInfoCondVO();
					// Eur24ManifestDownloadBCImpl command2 = new
					// Eur24ManifestDownloadBCImpl();
					// Eur24BlInfoVO eur24BlInfoVO =(Eur24BlInfoVO)
					// command2.searchBlInfo(eur24BlInfoCondVO);
				}
			} else if (eventName.equalsIgnoreCase("EsmBkg1124Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					EsmBkg1124Event event = (EsmBkg1124Event) e;
					Eur24BlInfoCondVO eur24BlInfoCondVO = event
							.getEur24BlInfoCondVO();
					Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
					Eur24BlInfoVO eur24BlInfoVO = (Eur24BlInfoVO) command2
							.searchBlInfoOB(eur24BlInfoCondVO);

					if (eur24BlInfoVO.getEur24BlGeneralInfoVO() != null)
						eventResponse.setETCData(eur24BlInfoVO
								.getEur24BlGeneralInfoVO().getColumnValues());
					if (eur24BlInfoVO.getEur24BlCustVO() != null)
						eventResponse.setETCData(eur24BlInfoVO
								.getEur24BlCustVO().getColumnValues());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlDangerCntrListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrMFListVOs());
					eventResponse.setRsVoList(eur24BlInfoVO
							.getEur24BlCntrSealNoListVOs());
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
	 * ESM_BKG_0212 : SEARCH<br>
	 * DG Cargo Manifest List 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCgoManifestList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0212Event event = (EsmBkg0212Event) e;
			command = new KorManifestListDownloadBCImpl();
			// Parameter
			KorDgCgoManifestVO condVO = event.getKorDgCgoManifestVO();
			condVO.setUserId(account.getUsr_id());
			// BC 에 작업 요청
			KorDgCgoManifestVO returnVO = (KorDgCgoManifestVO) command
					.searchDgCgoManifestList(condVO);
			// 처리 결과 넘김
			if (returnVO.getKorBkgDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorBkgDgCgoVO>) Arrays
						.asList(returnVO.getKorBkgDgCgoVOs()));
			if (returnVO.getKorIbDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorIbDgCgoVO>) Arrays
						.asList(returnVO.getKorIbDgCgoVOs()));
			if (returnVO.getKorObDgCgoVOs() != null)
				eventResponse.setRsVoList((List<KorObDgCgoVO>) Arrays
						.asList(returnVO.getKorObDgCgoVOs()));
			if (returnVO.getKorBkgDgVvdVO() != null)
				eventResponse.setETCData(returnVO.getKorBkgDgVvdVO()
						.getColumnValues());
			if (returnVO.getKorDgVvdVO() != null)
				eventResponse.setETCData(returnVO.getKorDgVvdVO()
						.getColumnValues());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0212 : MULTI <br>
	 * DG Cargo Manifest 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgCgoManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0212Event event = (EsmBkg0212Event) e;
			command = new KorManifestListDownloadBCImpl();
			// Parameter
			KorDgCgoManifestCondVO condVO = event.getKorDgCgoManifestCondVO();
			condVO.setUserId(account.getUsr_id());
			// BC 에 작업 요청
			command.manageDgCgoManifest(condVO);
			// 성공 메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0217 : MULTI <br>
	 * DG Cargo Manifest 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg0217Event")) {
				ManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
				// 이벤트별 Impl생성
				EsmBkg0217Event event = (EsmBkg0217Event) e;
				// 등록, 수정, 삭제
				command.manageBlInfo((ChinaBlInfoVO) event.getBlInfoVO(),
						account);
			} else if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageBlInfo((Eur24BlInfoVO) event.getEur24BlInfoVO(),
						account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			} else if (eventName.equals("EsmBkg1124Event")) {
				EsmBkg1124Event event = (EsmBkg1124Event) e;
				Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
				command2.manageBlInfoOB(
						(Eur24BlInfoVO) event.getEur24BlInfoVO(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0540 : SEARCH02 <br>
	 * DG Cargo Manifest 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bkgUtil = new BookingUtil();
		try {
			// 이벤트별 Impl생성
			EsmBkg0540Event event = (EsmBkg0540Event) e;
			String cmdtNm = bkgUtil.searchMdmCmdtDesc(event.getStrCmdtCd());
			if (!"".equals(cmdtNm)) {
				eventResponse.setETCData("result", cmdtNm);
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
	 * ESM_BKG_1037 : SEARCH <br>
	 * US AMS: Rail AMS History 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAmsRailHistoryList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg1037Event event = (EsmBkg1037Event) e;
			command = new UsaCustomsReportBCImpl();
			List<AmsRailListVO> result = command.searchAmsRailHistoryList(event
					.getCondVO());
			if (result != null && result.size() > 0) {
				AmsRailListVO vo = result.get(0);
				eventResponse.setRsVoList(vo.getDetailList());
				if (vo.getBlList() != null) {
					eventResponse.setRsVoList(vo.getBlList());
				}
				if (vo.getHeader() != null) {
					RailHistoryDetailListVO head = vo.getHeader();
					eventResponse.setETCData("f", head.getF());
					eventResponse.setETCData("o", head.getO());
					eventResponse.setETCData("c", head.getC());
					eventResponse.setETCData("c_desc", head.getCDesc());
					eventResponse.setETCData("vvd", head.getVvd());
					eventResponse.setETCData("vsl_nm", head.getVslNm());
					eventResponse.setETCData("pol", head.getPol());
					eventResponse.setETCData("pod", head.getPod());
					eventResponse.setETCData("eta", head.getEta());
					eventResponse.setETCData("del", head.getDel());
					eventResponse.setETCData("hub", head.getHub());
					eventResponse.setETCData("r", head.getR());
					eventResponse.setETCData("d", head.getD());
					eventResponse.setETCData("qty", head.getQty());
					eventResponse.setETCData("qty_tp", head.getQtyTp());
					eventResponse.setETCData("wgt", head.getWgt());
					eventResponse.setETCData("wgt_up", head.getWgtUt());
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
	 * ESM_BKG_0152 : SEARCH <br>
	 * 중국 DEL 지역별 운송 Mode를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDelMode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		List<DelModeListVO> list = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0152Event event = (EsmBkg0152Event) e;
			command = new ChinaCustomsReportBCImpl();
			list = command.searchDelMode(event.getBkgCstmsChnDeModCondVO());
			// eventResponse.setETCData("result", result);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : MULTI <br>
	 * 중국 DEL 지역별 운송 Mode를 입력/수정/삭제한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDelMode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			this.begin();
			EsmBkg0152Event event = (EsmBkg0152Event) e;
			command = new ChinaCustomsReportBCImpl();
			command.manageDelMode(event.getBkgCstmsChnDeModDetailVOs(), account);
			// 성공 메시지 셋팅
			// eventResponse.setUserMessage(new
			// ErrorHandler("BKG00101").getUserMessage());
			this.commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0540 : SEARCH03 <br>
	 * 중국세관 POD, DEL Validation 을 체크한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if ("EsmBkg0152Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0152Event event = (EsmBkg0152Event) e;
				command = new ChinaCustomsReportBCImpl();
				String locCd = command.searchLocation(event
						.getSearchLocationVO());
				if (locCd != null) {
					eventResponse.setETCData("locCd", locCd);
				}
				// 성공 메시지 셋팅
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00101").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event = (EsmBkg0540Event) e;
				BookingUtil bkgUtil = new BookingUtil();
				String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());
				if (!"".equals(locNm)) {
					eventResponse.setETCData("result", locNm);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
				EsmBkg0257Event event = (EsmBkg0257Event) e;
				BookingUtil bkgUtil = new BookingUtil();

				String polCd = event.getPolCd();
				String podCd = event.getPodCd();
				String polLocNm = "";
				String podLocNm = "";

				if (polCd != null && !polCd.equals("")) {
					polLocNm = bkgUtil.searchMdmLocName(polCd);
				}
				eventResponse.setETCData("polResult", polLocNm);

				if (podCd != null && !podCd.equals("")) {
					podLocNm = bkgUtil.searchMdmLocName(podCd);
				}

				eventResponse.setETCData("podResult", podLocNm);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1144Event")) {
				EsmBkg1144Event event = (EsmBkg1144Event) e;
				BookingUtil bkgUtil = new BookingUtil();
				String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());

				if (!"".equals(locNm)) {
					eventResponse.setETCData("result", locNm);
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
	 * ESM_BKG_1046 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_1070 : SEARCH <br>
	 * Customer, Container 등의 BL 정보를 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsTransmissionBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				EsmBkg1046Event event = (EsmBkg1046Event) e;
				command = new ChinaCustomsTransmissionBCImpl();
				List<BlInfoVO> list = command.searchBlByVvd(event
						.getBlInfoCondVO());
				ChinaBlInfoListVO blInfoListVO = (ChinaBlInfoListVO) list
						.get(0);
				list.remove(0);
				eventResponse.setRsVoList(list);
				eventResponse.setETCData(blInfoListVO.getColumnValues());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
				EsmBkg1070Event event = (EsmBkg1070Event) e;
				command = new ChinaCustomsTransmissionBCImpl();
				List<BlInfoVO> list = command.searchTmlBlByVvd(event
						.getBlInfoCondVO());
				ChinaBlInfoListVO blInfoListVO = (ChinaBlInfoListVO) list
						.get(0);
				list.remove(0);
				eventResponse.setRsVoList(list);
				eventResponse.setETCData(blInfoListVO.getColumnValues());
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
	 * ESM_BKG_1046 : MULTI <br>
	 * Customer, Container 등의 BL 정보를 삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			this.begin();
			// 이벤트별 Impl 생성
			EsmBkg1046Event event = (EsmBkg1046Event) e;
			command = new ChinaManifestListDownloadBCImpl();
			BlInfoVO[] blInfoVOs = event.getBlInfoVOs();
			ChinaBlInfoListVO[] chinaBlInfoListVOs = new ChinaBlInfoListVO[blInfoVOs.length];
			String transMode = null;
			for (int i = 0; i < blInfoVOs.length; i++) {
				chinaBlInfoListVOs[i] = (ChinaBlInfoListVO) blInfoVOs[i];
				if (i == 0) {
					transMode = chinaBlInfoListVOs[i].getTransMode();
				}
			}
			command.manageBlByVvd(chinaBlInfoListVOs, transMode);
			// 성공 메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593")
					.getUserMessage());

			this.commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : MULTI <br>
	 * DOR 전송<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestForDor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0466Event event = (EsmBkg0466Event) e;
			// BackEnd
			command = new CargoReleaseOrderBCImpl();
			JapDorEdiTransVO[] japDorEdiTransVOs = event.getJapDorEdiTransVOs();
			for (int i = 0; i < 1; i++) {
				japDorEdiTransVOs[i].setUpdUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setCreUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setEvntUsrId(account.getUsr_id());
				japDorEdiTransVOs[i].setEvntOfcCd(account.getOfc_cd());
				japDorEdiTransVOs[i].setOfcCd(account.getOfc_cd());
				japDorEdiTransVOs[i].setDoCngEvntCd("DF");
				japDorEdiTransVOs[i].setSvcCd("C");
				japDorEdiTransVOs[i].setRlseSeq("1");
				japDorEdiTransVOs[i].setEvntCd("9");
				command.transmitEdiByJapDor(japDorEdiTransVOs[i]);
			}
			eventResponse.setUserMessage(new ErrorHandler("BKG00218")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1038 : SEARCH01 <br>
	 * CUSTOMER NAME 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1038Event event = (EsmBkg1038Event) e;
			CustomsReportBC command = new BangladeshCustomsReportBCImpl();
			String custNm = command.searchCustomerNm(event.getCustCondVO());
			if (custNm == null) {
				eventResponse.setETCData("cust_cd", "");
			} else {
				String[] custData = custNm.split("\t");
				eventResponse.setETCData("cust_cd", custData[0]);
				eventResponse.setETCData("cust_nm", custData[1]);
				eventResponse.setETCData("cust_cnt", custData[2]);
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
	 * ESM_BKG_1038 : MULTI <br>
	 * Bangladesh License정보를 입력/수정/삭제한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLicenseInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			this.begin();
			EsmBkg1038Event event = (EsmBkg1038Event) e;
			command = new BangladeshCustomsReportBCImpl();
			command.manageLicenseInfo(event.getBkgCstmsBdFrtFwrdLicDetailVOs(),
					account);
			// 성공 메시지 셋팅
			// eventResponse.setUserMessage(new
			// ErrorHandler("BKG00101").getUserMessage());
			this.commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0020 : INIT<br>
	 * Advice Notes Type 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsAvcNotesPrnTpList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BookingUtil bkgUtil = new BookingUtil();
			BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
			hrdCdgVO.setHrdCdgId(Constants.HrdCdgId.CND_AN_TP_CD);
			eventResponse.setRsVoList(bkgUtil.searchHardCoding(hrdCdgVO));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0333 : COMMAND01<br>
	 * Discharging CY Bonded Info 에서 AR Interface 처리
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse interfaceWhfToArInv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingARCreationBC command = new BookingARCreationBCImpl();

		try {
			begin();

			EsmBkg0333Event event = (EsmBkg0333Event) e;
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event
					.getKorDiscCYBondInfoVO();
			ARBkgInterfaceCreationVO bkgIfVO = new ARBkgInterfaceCreationVO();

			// Parameter 셋팅
			bkgIfVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
			bkgIfVO.setUserId(account.getUsr_id());
			bkgIfVO.setManDivInd("B");
			bkgIfVO.setBkgCorrNo(null);

			// BC에 작업 요청
			command.interfaceBKGARInvoiceToINV(bkgIfVO);

			commit();

			// 성공메시지 처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0401 : REMOVE<BR>
	 * bkg_hrd_cdg 테이블을 수정한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOfcSetInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0401Event event = (EsmBkg0401Event) e;
			BookingUtil bkgUtil = new BookingUtil();
			bkgUtil.manageHardCoding(event.getBkgHrdCdgCtntVOs());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0408 : INIT <br>
	 * hub수정권한을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserAuthInfoForHub(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = null;
		InbondTransmissionBC command = null;
		String[] hubModifyYn = new String[2];
		try {
			eventResponse = new GeneralEventResponse();
			command = new UsaInbondTransmissionBCImpl();

			hubModifyYn = command.searchUserAuthInfoForHub(account.getUsr_id());

			eventResponse.setETCData("hubModifyYn", hubModifyYn[0]);
			eventResponse.setETCData("cstmsModifyYn", hubModifyYn[1]);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0990 : SEARCH <br>
	 * ESM_BKG_0034 : INIT <br>
	 * download 후 B/L을 추가 할 수 있다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgReferenceNumberGeneration(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0990Event")) {
				BookingUtil utilBC = new BookingUtil();
				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = utilBC
						.manageBkgReferenceNumberGeneration("JPD",
								account.getOfc_cd(), account.getUsr_id());
				eventResponse.setETCData("dummy_bl_no",
						bkgReferenceNoGenerationVO.getJpdNo());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0029Event")) {
				BookingUtil utilBC = new BookingUtil();
				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = utilBC
						.manageBkgReferenceNumberGeneration("CAD",
								account.getOfc_cd(), account.getUsr_id());
				eventResponse.setETCData("dummy_bl_no",
						bkgReferenceNoGenerationVO.getCadNo());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0034Event")) {
				BookingUtil util = new BookingUtil();
				BkgReferenceNoGenerationVO bkgReferenceNoGenerationVO = util
						.manageBkgReferenceNumberGeneration("USD",
								account.getOfc_cd(), account.getUsr_id());
				eventResponse.setETCData("dummy_bl_no",
						bkgReferenceNoGenerationVO.getUsdNo());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0428 <br>
	 * 미국 현재 날짜 가져오기<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	private String searchLocalSysdate(Event e) throws EventException {
		CustomsReportBC command = new UsaCustomsReportBCImpl();
		String date = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0428Event")
					|| e.getEventName().equalsIgnoreCase("EsmBkg0507Event")) {
				date = command.searchLocalSysdate();
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return date;
	}

	/**
	 * ESM_BKG_0034 : COMMAND02 <br>
	 * ISF5 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifestIsf(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0034Event event = (EsmBkg0034Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			command.transmitManifestIsf(event.getUsaManifestSearchDetailVOS(),
					account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00204")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 한국세관 Inbound Empty BL MSN 추가
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageMsnNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			command = new KorManifestListDownloadBCImpl();
			command.manageMsnNo(event.getKorMsnNoCondVOs());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 한국세관 InBound Empty Amend 전송
	 * 
	 * @param KorEmpAmdManiVO
	 *            [] korEmpAmdManiVOs
	 * @throws EventException
	 */
	private void transmitEmpAmdManifest(KorEmpAmdManiVO[] korEmpAmdManiVOs)
			throws EventException {

		try {

			CustomsTransmissionBC command = new KorCustomsTransmissionBCImpl();

			// 파라메터 복사
			KorEmpAmdManiTransVO[] korEmpAmdManiTransVOs = new KorEmpAmdManiTransVO[korEmpAmdManiVOs.length];

			for (int i = 0; i < korEmpAmdManiVOs.length; i++) {
				korEmpAmdManiTransVOs[i] = new KorEmpAmdManiTransVO();
				ObjectCloner.build(korEmpAmdManiVOs[i],
						korEmpAmdManiTransVOs[i]);
			}

			// 전송
			command.transmitEmpAmdManifest(korEmpAmdManiTransVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_0257 : SEARCH07 <br>
	 * eur-cta : 대상 존재여부를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	// private EventResponse searchExistBkgNoList(Event e) throws
	// EventException{
	// GeneralEventResponse eventResponse = new GeneralEventResponse();
	// CustomsTransmissionBC command = null;
	// try{
	// EsmBkg0257Event event =(EsmBkg0257Event) e;
	// command = new EurCustomsTransmissionBCImpl();
	// String retVal =
	// command.searchExistBkgNoList(event.getEuManifestTransmitVOs());
	// eventResponse.setETCData("targetListYn", retVal);
	//
	// }catch(EventException ex){
	// throw ex;
	// }catch(Exception ex){
	// throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
	// }
	// return eventResponse;
	// }

	/**
	 * ESM_BKG_0484 : SEARCH04 <br>
	 * eur-sitpro : vvd와 port 존재여부를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExistVvdPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0484Event event = (EsmBkg0484Event) e;
			command = new EurCustomsTransmissionBCImpl();
			String retVal = command.searchExistVvdPort(event
					.getSitProCargoManifestCondForEdiVO());
			eventResponse.setETCData("existVvdPortYn", retVal);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1085 : SEARCH02<BR>
	 * ESM_BKG_1086 : SEARCH<BR>
	 * 국가별 Package Unit 조회<BR>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPkgUnitList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1086Event")) {
				EsmBkg1086Event event = (EsmBkg1086Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				eventResponse.setRsVoList(command.searchPkgUnitList(event
						.getBkgCstmsCdConvCtntVO()));
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1085Event")) {
				EsmBkg1085Event event = (EsmBkg1085Event) e;
				command = new DubaiManifestListDownloadBCImpl();
				List<BkgCstmsCdConvCtntVO> list = command
						.searchPkgUnitList(event.getBkgCstmsCdConvCtntVO());
				if (list.size() == 0)
					eventResponse.setETCData("du_pck_tp_cd", "");
				else
					eventResponse.setETCData("du_pck_tp_cd", "true");
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
	 * 국가별 Package Unit 관리
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse managePkgUnit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1086Event event = (EsmBkg1086Event) e;
			CLLCDLManifestBC command = new CLLCDLManifestBCImpl();
			command.manageCdConvCtnt(event.getBkgCstmsCdConvCtntVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * CDL 자동전송
	 * 
	 * @param blNo
	 */
	private void transmitCdlEdi(String blNo) throws Exception {
		try {
			CustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
			BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
			blInfoCondVO.setBlNo(blNo);
			List<BlInfoVO> blInfos = command.searchTmlBlByVvd(blInfoCondVO);
			if (blInfos.size() > 0) {
				CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos
						.size()];
				for (int i = 0; i < blInfos.size(); i++) {
					UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos
							.get(i);
					cllCdlTransmitVOs[i] = new CllCdlTransmitVO();
					cllCdlTransmitVOs[i].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
					cllCdlTransmitVOs[i].setBlNo(usaTmlBlByVvdVO.getBlNo());
					cllCdlTransmitVOs[i].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
					cllCdlTransmitVOs[i].setBkgCgoTpCd(usaTmlBlByVvdVO
							.getBkgCgoTpCd());
					cllCdlTransmitVOs[i].setInListType("D");
					cllCdlTransmitVOs[i].setInVvdCd(usaTmlBlByVvdVO.getVslCd()
							+ usaTmlBlByVvdVO.getSkdVoyNo()
							+ usaTmlBlByVvdVO.getSkdDirCd());
					cllCdlTransmitVOs[i].setInPolCd(usaTmlBlByVvdVO
							.getCstmsPolCd());
					cllCdlTransmitVOs[i].setInPodCd(usaTmlBlByVvdVO
							.getCstmsPodCd());
					cllCdlTransmitVOs[i].setInSndId(usaTmlBlByVvdVO.getSndId());
					cllCdlTransmitVOs[i].setInRcvId(usaTmlBlByVvdVO.getRcvId());
					cllCdlTransmitVOs[i].setInYdCd(usaTmlBlByVvdVO.getYdCd());
					cllCdlTransmitVOs[i].setInAreaId("USA");
					cllCdlTransmitVOs[i].setInDestSvrCd("USA");
					cllCdlTransmitVOs[i].setInWhereGubun("DL");
					if ("D".equals(usaTmlBlByVvdVO.getMfStsCd())) {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("CANCEL");
					} else {
						cllCdlTransmitVOs[i].setInEdiMsgFunc("REPLACE");
					}
				}
				CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
				cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
			}
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler("BKG40110",
					new String[] { "Terminal" }).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG40110",
					new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0745_C : MULTI <br>
	 * HS CODE(ncm code) 를 입력,수정 삭제 한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHSCode(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0745Event")) {
				EsmBkg0745Event event = (EsmBkg0745Event) e;
				command = new BrcsManifestDownloadBCImpl();
				command.manageHSCode(event.getBrHsCdDetailVOs(), account);
				eventResponse.setUserMessage((String) new ErrorHandler(
						"BKG00166", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1098 : SEARCH <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBaplieAlarmSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg1098Event event = (EsmBkg1098Event) e;
			command = new UsaCustomsTransmissionBCImpl();
			List<BaplieAlarmSetupVO> list = command
					.searchBaplieAlarmSetup(event.getBaplieAlarmSetupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1098 : SAVE <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBaplieAlarmSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = new UsaCustomsTransmissionBCImpl();
		String user_id = account.getUsr_id();
		try {
			EsmBkg1098Event event = (EsmBkg1098Event) e;
			begin();
			command.manageBaplieAlarmSetup(event.getBaplieAlarmSetupVOs(),
					user_id);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",
					new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEu1stPortByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvd(event
						.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1104Event")) {
				EsmBkg1104Event event = (EsmBkg1104Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvdForAN(event
						.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEu1stPortByVvd(event
						.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			} else if (eventName.equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEuPolByVvd(event.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search1stEUvvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = new ArrayList<ManifestListDetailVO>();
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command
						.search1stEUvvdByBL(event.getManifestListCondVO());
			} else if (eventName.equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchEuPolByVvd(event.getManifestListCondVO());
			}
			eventResponse.setETCData("bl_cnt", list.size() + "");
			if (list.size() > 0) {
				Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
				eventResponse.setETCData("vvd",
						vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
				eventResponse.setETCData("pol", vo.getPol());
				eventResponse.setETCData("pol_yd", vo.getPolYdCd());
			} else {
				eventResponse.setETCData("vvd", "");
				eventResponse.setETCData("pol", "");
				eventResponse.setETCData("pol_yd", "");
			}
			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEuOBVvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			// String eventName = e.getEventName();
			EsmBkg1121Event event = (EsmBkg1121Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			list = command.searchEuOBVvdByBL(event.getManifestListCondVO());

			eventResponse.setETCData("pol_cnt", list.size() + "");
			if (list.size() > 0) {
				Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
				eventResponse.setETCData("vvd_cnt", vo.getVvdCnt());
				eventResponse.setETCData("vvd",
						vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
				eventResponse.setETCData("pol", vo.getPol());
				eventResponse.setETCData("pol_yd", vo.getPolYdCd());
				eventResponse.setETCData("pod", vo.getPod());
				eventResponse.setETCData("pod_yd", vo.getPodYdCd());
			} else {
				eventResponse.setETCData("vvd_cnt", "0");
				eventResponse.setETCData("vvd", "");
				eventResponse.setETCData("pol", "");
				eventResponse.setETCData("pol_yd", "");
				eventResponse.setETCData("pod", "");
				eventResponse.setETCData("pod_yd", "");
			}
			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	// searchCstmsENSPofeList
	/**
	 * ESM_BKG_1106 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsENSPofeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1105Event")) {
				EsmBkg1105Event event = (EsmBkg1105Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchCstmsENSPofeList(event
						.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1108 : SEARCH<BR>
	 * Europe Advanced Manifest - ENS REPORT 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENSReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1108Event event = (EsmBkg1108Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EnsListVO> list = command.searchENSReport(event
					.getEu24EnsListVO());
			if (list.size() > 0) {
				Eu24EnsListVO ovo = (Eu24EnsListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				// eventResponse.setETCData("sent_success_cnt",ovo.getSentSuccessCnt());
				// eventResponse.setETCData("sent_fail_cnt",ovo.getSentFailCnt());
				eventResponse.setETCData("a_cnt", ovo.getACnt());
				eventResponse.setETCData("r_cnt", ovo.getRCnt());
				eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("nr_cnt", ovo.getNrCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1120 : SEARCH<BR>
	 * Europe Advanced Manifest - ENS MONITORING 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENSMonitoring(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1120Event event = (EsmBkg1120Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EnsListVO> list = command.searchENSMonitoring(event
					.getEu24EnsListVO());
			if (list.size() > 0) {
				Eu24EnsListVO ovo = (Eu24EnsListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAccBlCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejBlCnt());
				eventResponse.setETCData("nrcv_bl_cnt", ovo.getNrcvBlCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDonldBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				eventResponse.setETCData("tosend_bl_cnt", ovo.getTosendBlCnt()); // add. 2014.12.08
				eventResponse.setETCData("total_amd_cnt", ovo.getTotalAmdCnt());
				eventResponse.setETCData("total_ens_amt", ovo.getTotalEnsAmt());
				eventResponse.setETCData("total_shaas_ens",
						ovo.getTotalShaasEns());
				eventResponse.setETCData("total_nycna_ens",
						ovo.getTotalNycnaEns());
				eventResponse.setETCData("total_hamur_ens",
						ovo.getTotalHamurEns());
				eventResponse.setETCData("total_sinwa_ens",
						ovo.getTotalSinwaEns());
				eventResponse.setETCData("total_mcf_amt", ovo.getTotalMcfAmt());
				eventResponse.setETCData("total_shaas_mcf",
						ovo.getTotalShaasMcf());
				eventResponse.setETCData("total_nycna_mcf",
						ovo.getTotalNycnaMcf());
				eventResponse.setETCData("total_hamur_mcf",
						ovo.getTotalHamurMcf());
				eventResponse.setETCData("total_sinwa_mcf",
						ovo.getTotalSinwaMcf());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1120 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1120(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil command = new BookingUtil();
		// RHQ
		List<BkgComboVO> list = command.searchRgnOfficeCd();
		List<BkgComboVO> list2 = new ArrayList<BkgComboVO>();
		BkgComboVO vo = new BkgComboVO();

		// default
		vo.setVal("");
		vo.setDesc("");
		vo.setName("");
		list2.add(vo);
		for (int j = 0; j < list.size(); j++) {
			list2.add(list.get(j));
		}

		eventResponse.setRsVoList(list2);
		return eventResponse;
	}

	/**
	 * ESM_BKG_1113 : SEARCH<BR>
	 * Transmit / Receive History 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24EDIHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1113Event")) {
				EsmBkg1113Event event = (EsmBkg1113Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<EU24EDIHistoryVO> list = command
						.searchEU24EDIHistory(event.getEU24EDIHistoryVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1172Event")) {
				EsmBkg1172Event event = (EsmBkg1172Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<EU24EDIHistoryVO> list = command
						.searchEU24EDIFIHistory(event.getEU24EDIHistoryVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_1106 : SEARCH05<BR>
	 * EU Port조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24CountryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<Eu24CountryListVO> list = command
						.searchEU24CountryList(event.getEu24CountryListVO());
				eventResponse.setRsVoList(list);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				List<Eu24CountryListVO> list = command
						.searchEU24CountryList(event.getEu24CountryListVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_1115 : SEARCH<BR>
	 * Europe Advanced Manifest-Error Code Table 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24RcvErrorCodeTable(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1115Event event = (EsmBkg1115Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<EU24RcvErrorCodeTableVO> list = command
					.searchEU24RcvErrorCodeTable(event
							.getEU24RcvErrorCodeTableVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1108 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1108Event event = (EsmBkg1108Event) e;
			String result = command.searchSvcLaneByVvd(event.getEu24EnsListVO()
					.getPVvd());
			if (result != null && !result.equals("")) {
				eventResponse.setETCData("p_lane", result);
			} else {
				eventResponse.setETCData("p_lane", "");
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
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - Europe Customs 등록 코드 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomsSetupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchCustomsSetupList(event
					.getCustomsSetupVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - MDM LOCATION 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmLocationPort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchMdmLocationPort(event
					.getCustomsSetupVO().getPCntCd());
			CustomsSetupVO combovo = new CustomsSetupVO();
			combovo.setPortCd("All");
			list.add(0, combovo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SEARCH<BR>
	 * Europe Advanced Manifest - MDM YARD 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmYardTmlcode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<CustomsSetupVO> list = command.searchMdmYardTmlcode(event
					.getCustomsSetupVO().getPPort());
			CustomsSetupVO combovo = new CustomsSetupVO();
			combovo.setYdCd("All");
			list.add(0, combovo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1109 : SAVE <br>
	 * Europe Customs 코드관리
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEU24CustomsSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			command = new Eur24ManifestDownloadBCImpl();
			EsmBkg1109Event event = (EsmBkg1109Event) e;
			begin();
			command.manageEU24CustomsSetup(event.getCustomsSetupVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",
					new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0503 : Retrieve<br>
	 * Transmit Cross-Check 조회
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTransCrossChk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0503Event event = (EsmBkg0503Event) e;

			// command = new KorManifestListDownloadBCImpl();
			command = new KorCustomsTransmissionBCImpl();

			List<KorTransCrossChkDtlVO> list = command
					.searchTransCrossChk(event.getKorTransCrossChkCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0484 : ENS Download <br>
	 * ENS Download (Excel)
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchENSDownExcel(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		CustomsTransmissionBC command = null;
		EsmBkg0484Event event = null;
		List<SitProENSDownExcelVO> list = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg0484Event) e;
			command = new EurCustomsTransmissionBCImpl();
			list = command.searchENSDownExcel(
					event.getSitProCargoManifestCondForEdiVO(),
					event.getBkgNos());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0329조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0329(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil comboUtil = new BookingUtil();

			// Upload Status - bkg_upld_sts_cd
			List<BkgComboVO> sc = comboUtil.searchCombo("CD02254");

			List<BkgComboVO> list_sc = new ArrayList<BkgComboVO>();

			BkgComboVO comboVo = new BkgComboVO();
			comboVo.setVal("A");
			comboVo.setName("All");
			comboVo.setDesc("All");
			list_sc.add(comboVo);
			for (int i = 0; i < sc.size(); i++) {
				list_sc.add(sc.get(i));
			}

			eventResponse.setRsVoList(list_sc);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",
					new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1122 : Retrieve<br>
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBaplieMonitor(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		try {

			EsmBkg1122Event event = (EsmBkg1122Event) e;
			// Canada와 US 동일한 화면 사용
			if (event.getCustomsGb().endsWith("US")) {
				command = new UsaCustomsReportBCImpl();
			} else {
				command = new CndCustomsReportBCImpl();
			}
			List<BaplieMonitorCondVO> list = command.searchBaplieMonitor(event
					.getBaplieMonitorCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1122 : VVD 입력박스 Focus out 이벤트 대응<br>
	 * JSP화면 VVD입력 후에 입력 VVD에 해당하는 Last Foreign Port 를 조회한다.
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsLastForeignPort(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		UsaCustomsReportBCImpl command = null;
		String crrCd = null;
		String lPol = null;
		try {
			EsmBkg1122Event event = (EsmBkg1122Event) e;
			command = new UsaCustomsReportBCImpl();
			String vvd = event.getBaplieMonitorCondVO().getVvd();
			List<BaplieMonitorCondVO> list = command
					.searchUsLastForeignPort(vvd);
			if (list != null && list.size() > 0) {
				BaplieMonitorCondVO vo = list.get(0);
				crrCd = vo.getCrrCd();
				lPol = vo.getLPol();
			}
			eventResponse.setETCData("CRRCD", crrCd);
			eventResponse.setETCData("LPOL", lPol);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1125 : SEARCH<BR>
	 * CANADA ACI : ACI Monitoring 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchACIMonitor(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1125Event event = (EsmBkg1125Event) e;
			command = new CndCustomsReportBCImpl();
			List<ACIMonitorListVO> list = command.searchACIMonitor(event
					.getACIMonitorCondVO());
			if (list.size() > 0) {
				ACIMonitorListVO ovo = (ACIMonitorListVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAcceptedCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejectedCnt());
				eventResponse
						.setETCData("nrcv_bl_cnt", ovo.getNotReceivedCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("rlse_bl_cnt", ovo.getReleaseCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentCnt());
				eventResponse.setETCData(
						"podirr_bl_cnt",
						Integer.toString(Integer.parseInt(ovo.getPodHoldCnt())
								+ Integer.parseInt(ovo.getDoNotUnloadCnt())));

				eventResponse.setETCData("total_cms_cnt",
						ovo.getTotalCmsSmcAmt());
				eventResponse.setETCData("total_shaas_ens",
						ovo.getTotalShaasEns());
				eventResponse.setETCData("total_nycna_ens",
						ovo.getTotalNycnaEns());
				eventResponse.setETCData("total_hamur_ens",
						ovo.getTotalHamurEns());
				eventResponse.setETCData("total_sinwa_ens",
						ovo.getTotalSinwaEns());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());

				eventResponse.setETCData("total_mcf_amt", ovo.getTotalMcfAmt());
				eventResponse.setETCData("total_shaas_mcf",
						ovo.getTotalShaasMcf());
				eventResponse.setETCData("total_nycna_mcf",
						ovo.getTotalNycnaMcf());
				eventResponse.setETCData("total_hamur_mcf",
						ovo.getTotalHamurMcf());
				eventResponse.setETCData("total_sinwa_mcf",
						ovo.getTotalSinwaMcf());
				eventResponse.setETCData("total_amd_cnt", ovo.getAmendCnt2());
			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1125 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1125(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// RHQ List
		List<BkgComboVO> list = searchComCodeCombo("CD00961");
		BkgComboVO vo = new BkgComboVO();

		// default
		vo.setVal("");
		vo.setDesc("");
		vo.setName("");
		list.add(0, vo);

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_1126 : SEARCH<BR>
	 * Europe Advanced Manifest - EXS REPORT 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSReportOB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1126Event event = (EsmBkg1126Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24ExsListOBVO> list = command.searchEXSReportOB(event
					.getEu24ExsListOBVO());
			if (list.size() > 0) {
				Eu24ExsListOBVO ovo = (Eu24ExsListOBVO) list.get(0);
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("unsent_bl_cnt", ovo.getUnsentBlCnt());
				// eventResponse.setETCData("sent_success_cnt",ovo.getSentSuccessCnt());
				// eventResponse.setETCData("sent_fail_cnt",ovo.getSentFailCnt());
				eventResponse.setETCData("a_cnt", ovo.getACnt());
				eventResponse.setETCData("r_cnt", ovo.getRCnt());
				eventResponse.setETCData("dnl_cnt", ovo.getDnlCnt());
				eventResponse.setETCData("h_cnt", ovo.getHCnt());
				eventResponse.setETCData("l_cnt", ovo.getLCnt());
				eventResponse.setETCData("nr_cnt", ovo.getNrCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1126 : SEARCH01<BR>
	 * VVD FocusOut 시, 해당하는 vvd 의 EU 1st Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSSvcLaneByVvdOB(Event e)
			throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1126Event event = (EsmBkg1126Event) e;
			String result = command.searchSvcLaneByVvd(event
					.getEu24ExsListOBVO().getPVvd());
			if (result != null && !result.equals("")) {
				eventResponse.setETCData("p_lane", result);
			} else {
				eventResponse.setETCData("p_lane", "");
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
	 * ESM_BKG_1127 : SEARCH<BR>
	 * Transmit / Receive History 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEU24EDIHistoryOB(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1127Event event = (EsmBkg1127Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<EU24EDIHistoryOBVO> list = command
					.searchEU24EDIHistoryOB(event.getEU24EDIHistoryOBVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1128 : SEARCH<BR>
	 * Receive History<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCstmsRcvMsgOB(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EUR24 - 구주세관 ACK 수신
			Eur24ManifestDownloadBCImpl command3 = new Eur24ManifestDownloadBCImpl();
			List<Eur24RcvMsgVO> voList = null;
			EsmBkg1128Event event = (EsmBkg1128Event) e;
			voList = command3
					.searchCstmsRcvMsgOB((Eur24VesselArrivalCondVO) event
							.getVesselArrivalCondVO());
			eventResponse.setRsVoList(voList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_1046 : MULTI04 <br>
	 * Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitManifestCN(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg1046Event event = (EsmBkg1046Event) e;
				command = new ChinaCustomsTransmissionBCImpl();

				String key = command.transmitManifestCN(
						event.getManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}
	

	/**
	 * 
	 * ESM_BKG_1106 : MULTI03 <br>
	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitManifestENS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1106Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.transmitManifest(event.getEu24ManifestTransmitVOs(),
						account);

			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_1121 : MULTI03 <br>
	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitManifestEXS(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1121Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1121Event event = (EsmBkg1121Event) e;
				command = new Eur24CustomsTransmissionBCImpl();
				command.transmitManifestOB(
						event.getEu24ManifestTransmitOBVOs(), account);

			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0508 : SEARCH03 <br>
	 * Rotterdam세관에 보낸 edi History 현황정보를 가져온다<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransmitHistList2(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		Map<String, String> mapVO = new HashMap<String, String>();

		StringBuffer temp1 = new StringBuffer();
		
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0508Event")) {
				EsmBkg0508Event event = (EsmBkg0508Event) e;
				command = new UsaCustomsReportBCImpl();
				List<TransmitHistFileDetailVO> list = command
						.searchTransmitHistFile(event
								.getTransmitHistFileCondVO());
				if (list.size() == 0) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889")
							.getUserMessage());
				} else {
					for (int i = 0; i < list.size(); i++) {
						TransmitHistFileDetailVO transmitHistFileDetailVO = (TransmitHistFileDetailVO) list
								.get(i);
						mapVO = transmitHistFileDetailVO.getColumnValues();
						temp1.append(mapVO.get("log_ctnt") + "\r\n");
					}
					eventResponse.setETCData("log_ctnt_etc", temp1.toString());
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
	 * ESM_BKG_1107 : MULTI02 <br>
	 * 메뉴얼 MRN 삭제 <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMrnNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command = new Eur24ManifestDownloadBCImpl();
				
				Eur24BlInfoCondVO vo =  event.getEur24BlInfoCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setMrnFlg("D");
				command.manageMrnNo(vo);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1107 : MULTI03 <br>
	 * 메뉴얼 MRN 재입력<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reactivateMrnNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			String eventName = e.getEventName();
			if (eventName.equals("EsmBkg1107Event")) {
				EsmBkg1107Event event = (EsmBkg1107Event) e;
				Eur24ManifestDownloadBCImpl command = new Eur24ManifestDownloadBCImpl();
				
				Eur24BlInfoCondVO vo =  event.getEur24BlInfoCondVO();
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setMrnFlg("A");
				command.reactivateMrnNo(vo);
				//command.reactivateMrnNo((Eur24BlInfoCondVO) event.getEur24BlInfoCondVO());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1135 : SEARCH <br>
	 * ROCS 의 CRN List 화면에서 Lane 을 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRocsLane(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// EsmBkg1135Event event =(EsmBkg1135Event) e;
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
			command = new RocsManifestListDownloadBCImpl();
			bkgHrdCdgCtntVOs = command.searchRocsLane();

			if (bkgHrdCdgCtntVOs.size() == 0) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			}

			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1135 : MULTI<BR>
	 * ROCS 의 CRN List 화면에서 Lane 정보 수정<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRocsLane(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1135Event event = (EsmBkg1135Event) e;
			command = new RocsManifestListDownloadBCImpl();

			command.manageRocsLane(event.getBkgHrdCdgCtntVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0346 : INIT <br>
	 * 한국세관에 대한 Transmit Info 를 초기화 값으로 셋팅<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTransCancellInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0346Event event = (EsmBkg0346Event) e;
		try {
			eventResponse.setRsVo(event.getKorTransCancellCustVO());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_0346 : MULTI01 <br>
	 * Korea 세관에 신고 된 적하목록을 삭제하는 Manifest를 전송하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitCancellKR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;

		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0346Event")) {
				// 한국 EDI FLAT FILE 생성 및 전송
				EsmBkg0346Event event = (EsmBkg0346Event) e;
				command = new KorCustomsTransmissionBCImpl();

				KorManifestCancelTransmitVO transmitVO = (KorManifestCancelTransmitVO) event
						.getManifestTransmitVO();

				KorTransCancellCustVO custVO = transmitVO
						.getKorTransCancellCustVO();
				custVO.setOfcCd(account.getOfc_cd());
				custVO.setUserId(account.getUsr_id());

				command.transmitCancellKR(transmitVO);
				// 성공메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 2011.11.15 김보배 [CHM-201114279] [UI_BKG_0257_Europe Customs EDI] U/I변경 요청
	 * EU 세관 전송을 위한 VVD 와 POD 별 B/L 내역 조회
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEurManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			EsmBkg0257Event event = (EsmBkg0257Event) e;
			command = new EurCustomsTransmissionBCImpl();
			List<ManifestListDetailVO> list = null;
			list = command.searchEurManifestList(event.getManifestListCondVO());

			// [CHM-201325432] EU customs EDI 화면, RFS lane yard code mandatory
			// 설정요청
			EurManifestListCondVO eurManifestListCondVO = new EurManifestListCondVO();
			eurManifestListCondVO = (EurManifestListCondVO) event
					.getManifestListCondVO();

			if (list.size() > 0) {
				EurManifestListVO ovo = (EurManifestListVO) list.get(0);

				if ("RFS".equals(ovo.getSlanCd())) {
					if ("I".equals(eurManifestListCondVO.getModeType())
							&& "".equals(eurManifestListCondVO.getPodYdCd())) {
						throw new EventException(
								(String) new ErrorHandler("BKG06148",
										new String[] { "for RFS" })
										.getMessage());
					}
					if ("O".equals(eurManifestListCondVO.getModeType())
							&& "".equals(eurManifestListCondVO.getPolYdCd())) {
						throw new EventException(
								(String) new ErrorHandler("BKG06148",
										new String[] { "for RFS" })
										.getMessage());
					}
				}

				eventResponse.setETCData("vvd_nm", ovo.getVslFullname());
				eventResponse.setETCData("vvd_ld", ovo.getVslLloydcode());
				eventResponse.setETCData("vvd_call", ovo.getVslCallsign());
				eventResponse.setETCData("eta", ovo.getEta());
				eventResponse.setETCData("etd", ovo.getEtd());
			}

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 2011.12.26 이경원 [SRM-201122521] Australia Customs Manifest 기능 보완 요청
	 * ESM_BKG_0053 : (Australia Customs Manifest) VVD의 등록여부를 조사한다.
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse searchVVD(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0053Event event = (EsmBkg0053Event) e;
		BookingUtil command = new BookingUtil();

		// vvd의 3항목 선언
		String vslCd = event.getAustrailiaManifestTransmitSingleVO()
				.getFrmVslCd();
		String skdVoyNo = event.getAustrailiaManifestTransmitSingleVO()
				.getFrmSkdVoyNo();
		String skdDirCd = event.getAustrailiaManifestTransmitSingleVO()
				.getFrmSkdDirCd();

		String vvdExist = "none";
		// (String vslCd ,String voyNo ,String dirCd ) vslCd skdVoyNo skdDirCd
		if (command.validateVvd(vslCd, skdVoyNo, skdDirCd)) {
			vvdExist = "exist";
		}

		eventResponse.setETCData("vvdExist", vvdExist);
		return eventResponse;

	}

	/**
	 * ESM_BKG_1146 : MULTI02<BR>
	 * EXS B/L Inquiry 화면에서 Prev. Doc No Append <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrevDocNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1146Event event = (EsmBkg1146Event) e;
			command = new Eur24ManifestDownloadBCImpl();

			command.managePrevDocNo(event.getEurCrnRcvMsgVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 2012.03.12 조원주 [CHM-201216099] Sea-NACCS 프로젝트 ESM_BKG_0479
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;

		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				EsmBkg0479Event event = (EsmBkg0479Event) e;
				command = new JapanTerminalTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					List<VvdJapanTerminalEdiVO> list = null;
					list = command.searchVesselListForSchedule(
							event.getJapanTerminalEdiCondVO(), account);
					eventResponse.setRsVoList(list);
				}
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					List<VvdJapanTerminalEdiVO> list1 = null;
					list1 = command.searchVesselListForBKGRoute(event
							.getJapanTerminalEdiCondVO());
					eventResponse.setRsVoList(list1);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				EsmBkg0480Event event = (EsmBkg0480Event) e;
				command = new JapanTerminalTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					List<BkgJapanTerminalEdiVO> list = command
							.searchBkgInfoForSchedule(
									event.getJapanTerminalEdiCondVO(), account);
					eventResponse.setRsVoList(list);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					List<BkgJapanTerminalEdiVO> list = command
							.searchPartialBkgInfoForSchedule(event
									.getJapanTerminalEdiCondVO());
					eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0479 : SAVE <br>
	 * [CHM-201216099] Sea-NACCS 프로젝트 SAVE
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CustomsTransmissionBC command = null;
		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				command = new JapanTerminalTransmissionBCImpl();
				EsmBkg0479Event event = (EsmBkg0479Event) e;
				JapanTerminalEdiCheckRsltVO japanTerminalEdiCheckRsltVO = command
						.manageTerminalEdi(event.getVvdJapanTerminalEdiVOS(),
								account);
				eventResponse.setETCData("resultStr",
						japanTerminalEdiCheckRsltVO.getResultStr());
				eventResponse.setETCData("flg",
						japanTerminalEdiCheckRsltVO.getFlg());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				command = new JapanTerminalTransmissionBCImpl();
				EsmBkg0480Event event = (EsmBkg0480Event) e;
				command.managePartialBkgInfoForSchedule(
						event.getBkgJapanTerminalEdiVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166")
						.getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0479 : Transmit to NACCS - MULTI01 <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		String chk_flg = "";
		int logno = 0;
		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				command = new JapanTerminalTransmissionBCImpl();
				EsmBkg0479Event event = (EsmBkg0479Event) e;

				if (event.getVvdJapanTerminalEdiVOS().length > 0) {
					// 배치에서 타면 안되므로 배치파일 (JapanTerminalEdi)에서 creUsrId를 SYSTEM으로
					// 지정했음
					// 배치를타면 아래 메소드(manageTerminalEdi)는 타지 않도록
					if (!"SYSTEM".equals(event.getVvdJapanTerminalEdiVOS()[0]
							.getCreUsrId())) {

						command.manageTerminalEdi(
								event.getVvdJapanTerminalEdiVOS(), account);
					}
				}

				for (int i = 0; i < event.getVvdJapanTerminalEdiVOS().length; i++) {

					List<BkgTerminalEdiJapanBlVO> list = command
							.searchNewBkgInfo(event.getVvdJapanTerminalEdiVOS()[i]);

					for (int j = 0; j < list.size(); j++) {

						BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO = (BkgTerminalEdiJapanBlVO) list
								.get(j);
						JapanTerminalEdiGroupVO japanTerminalEdiGroupVO = command
								.searchNewBkgDetailInfo(bkgTerminalEdiJapanBlVO);
						BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVvdChkVO = (BkgTerminalEdiJapanBlVO) list
								.get(j);

						// 배치를 탈 때 account를 set 해줌
						if (event.getVvdJapanTerminalEdiVOS().length > 0
								&& event.getVvdJapanTerminalEdiVOS()[0]
										.getCreUsrId() == "SYSTEM") {
							account = new SignOnUserAccount(
									event.getVvdJapanTerminalEdiVOS()[i]
											.getEdiSndUsrId(),
									"", "", "", "", "", "JP", "", "BATCH", "",
									"BATCH", "", event
											.getVvdJapanTerminalEdiVOS()[i]
											.getEdiSndOfcCd(), "", "", "", "",
									"", "", "", "", "");
						}

						// SNACCS_TML_EDI_STS_CD 가 'D' 일때 최초에는 보내지 않음.
						if (!(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()
								.equals("D") && bkgTerminalEdiJapanBlVO
								.getRStsCnt().equals("0"))) {
							begin();
							// VVD_CD 수정된 경우 취소전송이 보내진 수에 신규 전송이 보내져야 함
							if (bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()
									.equals("V")
									&& "0".equals(list.get(j).getVvdChkStsCnt())) {
								// D로 보내야한다.
								chk_flg = command.addNewBkgInfoVvdChk(
										bkgTerminalEdiJapanBlVO,
										japanTerminalEdiGroupVO, account);

								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(
										FormCommand.MULTI02)) {
									chk_flg = "Y";
								}

								if ("Y".equals(chk_flg)) {
									commit();
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())){
									// Flatfile 생성
									bkgTerminalEdiJapanBlVvdChkVO = command
											.searchNewBkgInfoForVvdChk(bkgTerminalEdiJapanBlVO
													.getBkgNo());
									command.sendTerminalEdi(
											(BkgTerminalEdiJapanBlVO) bkgTerminalEdiJapanBlVvdChkVO,
											japanTerminalEdiGroupVO, account,
											logno);

									// }

									bkgTerminalEdiJapanBlVO
											.setSnaccsTmlEdiStsCd("R");
									chk_flg = command.addNewBkgInfo(
											bkgTerminalEdiJapanBlVO,
											japanTerminalEdiGroupVO, account);

									// Partial container 가 아닌 것만 보낸다
									// if("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())){
									// Flatfile 생성
									command.sendTerminalEdi(
											bkgTerminalEdiJapanBlVO,
											japanTerminalEdiGroupVO, account,
											logno);
									// }
								} else {
									rollback();
								}

							} else {
								chk_flg = command.addNewBkgInfo(
										bkgTerminalEdiJapanBlVO,
										japanTerminalEdiGroupVO, account);
								if ("N".equals(chk_flg)) {
									rollback();
								} else {
									commit();
									logno++;

									// Partial container 가 아닌 것만 보낸다
									if ("N".equals(bkgTerminalEdiJapanBlVO
											.getPrtFlg())) {
										command.sendTerminalEdi(
												bkgTerminalEdiJapanBlVO,
												japanTerminalEdiGroupVO,
												account, logno);// j
									}
								}
							}// else
						}
					}
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				command = new JapanTerminalTransmissionBCImpl();
				EsmBkg0480Event event = (EsmBkg0480Event) e;

				BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs = event
						.getBkgJapanTerminalEdiVOS();

				for (int i = 0; i < event.getBkgJapanTerminalEdiVOS().length; i++) {

					VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO = new VvdJapanTerminalEdiVO();

					vvdJapanTerminalEdiVO.setVvdCd(bkgJapanTerminalEdiVOs[i]
							.getVvdCd());
					vvdJapanTerminalEdiVO.setPolCd(bkgJapanTerminalEdiVOs[i]
							.getPolCd());
					vvdJapanTerminalEdiVO.setBkgNo(bkgJapanTerminalEdiVOs[i]
							.getBkgNo());
					vvdJapanTerminalEdiVO.setPolYdCd(bkgJapanTerminalEdiVOs[i]
							.getPolYdCd());
					vvdJapanTerminalEdiVO.setPorCd(bkgJapanTerminalEdiVOs[i]
							.getPorCd());
					vvdJapanTerminalEdiVO.setPorYdCd(bkgJapanTerminalEdiVOs[i]
							.getPorYdCd());
					vvdJapanTerminalEdiVO
							.setOtrNtfyYdCd(bkgJapanTerminalEdiVOs[i]
									.getOtrNtfyYdCd());
					vvdJapanTerminalEdiVO
							.setJpTmlVslNo(bkgJapanTerminalEdiVOs[i]
									.getJpTmlVslNo());

					List<BkgTerminalEdiJapanBlVO> list = command
							.searchNewBkgInfo(vvdJapanTerminalEdiVO);
					BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO = null;
					BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVvdChkVO = null;
					for (int j = 0; j < list.size(); j++) {
						bkgTerminalEdiJapanBlVO = (BkgTerminalEdiJapanBlVO) list
								.get(j);
						JapanTerminalEdiGroupVO groupVO = command
								.searchNewBkgDetailInfo(bkgTerminalEdiJapanBlVO);

						// SNACCS_TML_EDI_STS_CD 가 'D' 일때 최초에는 보내지 않음.
						if (!(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()
								.equals("D") && bkgTerminalEdiJapanBlVO
								.getRStsCnt().equals("0"))) {

							begin();
							// VVD_CD 수정된 경우 취소전송이 보내진 수에 신규 전송이 보내져야 함
							if (bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()
									.equals("V")
									&& "0".equals(bkgTerminalEdiJapanBlVO
											.getVvdChkStsCnt())) {
								// D로 보내야한다.
								chk_flg = command.addNewBkgInfoVvdChk(
										bkgTerminalEdiJapanBlVO, groupVO,
										account);

								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(
										FormCommand.MULTI02)) {
									chk_flg = "Y";
								}

								if ("Y".equals(chk_flg)) {
									commit();
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())){
									// Flatfile 생성

									bkgTerminalEdiJapanBlVvdChkVO = command
											.searchNewBkgInfoForVvdChk(vvdJapanTerminalEdiVO
													.getBkgNo());
									// bkgTerminalEdiJapanBlVvdChkVO =
									// (BkgTerminalEdiJapanBlVO)list1.get(j);

									command.sendTerminalEdi(
											(BkgTerminalEdiJapanBlVO) bkgTerminalEdiJapanBlVvdChkVO,
											groupVO, account, logno);
									// }

									bkgTerminalEdiJapanBlVO
											.setSnaccsTmlEdiStsCd("R");
									chk_flg = command.addNewBkgInfo(
											bkgTerminalEdiJapanBlVO, groupVO,
											account);

									// Partial container 가 아닌 것만 보낸다
									// if("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())){
									// Flatfile 생성
									command.sendTerminalEdi(
											bkgTerminalEdiJapanBlVO, groupVO,
											account, logno);
									// }
								} else {
									rollback();
								}

							}
							// 변경 여부 체크
							else {
								chk_flg = command.addNewBkgInfo(
										bkgTerminalEdiJapanBlVO, groupVO,
										account);

								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(
										FormCommand.MULTI02)) {
									chk_flg = "Y";
								}

								if ("Y".equals(chk_flg)) {
									commit();
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())){
									// Flatfile 생성
									command.sendTerminalEdi(
											bkgTerminalEdiJapanBlVO, groupVO,
											account, logno);
									// }
								} else {
									rollback();
								}
							}

						}
					}

					// BKG ROUTE Check
					if (list.size() == 0) {
						chk_flg = "ROUTE";
					}

				}

				eventResponse.setETCData("chk_flg", chk_flg);
			}

			// 전송 메세제 체크
			if (logno > 0) {
				// 전송 성공
				eventResponse.setUserMessage(new ErrorHandler("BKG00204")
						.getUserMessage());
			} else {
				// 전송할 데이타 없음
				eventResponse.setUserMessage(new ErrorHandler("BKG08232")
						.getUserMessage());
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
	 * ESM_BKG_1144 : retrieve <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrgPartyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ManifestListDownloadBC command = null;
		try {
			command = new UsaManifestListDownloadBCImpl();
			EsmBkg1144Event event = (EsmBkg1144Event) e;
			if (event.getOrgPartyVO() != null) {
				List<OrgPartyVO> list = command.searchOrgPartyList(event
						.getOrgPartyVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_1144 : save <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOrgPartyInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ManifestListDownloadBC command = null;
		try {
			command = new UsaManifestListDownloadBCImpl();
			EsmBkg1144Event event = (EsmBkg1144Event) e;

			command.manageOrgPartyInfo(event.getOrgPartyVOs());
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1142 : MULTI01<BR>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addSendLog(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1142Event event = (EsmBkg1142Event) e;
			command = new GhanaCustomsTransmissionBCImpl();

			command.addSendLog(event.getManifestTransmitVOs(), account);

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1146 : retrieve <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrevDocNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ManifestListDownloadBC command = null;

		try {
			EsmBkg1146Event event = (EsmBkg1146Event) e;
			command = new Eur24ManifestDownloadBCImpl();

			if (event.getEurCrnRcvMsgVO() != null) {
				List<EurCrnRcvMsgVO> list = command.searchPrevDocNo(event
						.getEurCrnRcvMsgVO());
				eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0329 : SAVE <br>
	 * cross check 관련 result remark 저장
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCrossCheck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ManifestListDownloadBC command = null;
		try {
			begin();

			command = new KorManifestListDownloadBCImpl();
			EsmBkg0329Event event = (EsmBkg0329Event) e;
			command.manageCrossCheck(event.getKorManifestCrsChkInfoVOs(),
					account);

			commit();
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1152 : SEARCH<BR>
	 * Europe Advanced Manifest - EXS MONITORING 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEXSMonitoring(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg1152Event event = (EsmBkg1152Event) e;
			command = new Eur24ManifestDownloadBCImpl();
			List<Eu24EXSListVO> list = command.searchEXSMonitoring(event
					.getEu24EXSListVO());
			if (list.size() > 0) {
				Eu24EXSListVO ovo = (Eu24EXSListVO) list.get(0);
				eventResponse.setETCData("sent_bl_cnt", ovo.getSentBlCnt());
				eventResponse.setETCData("acc_bl_cnt", ovo.getAccBlCnt());
				eventResponse.setETCData("rej_bl_cnt", ovo.getRejBlCnt());
				eventResponse.setETCData("nrcv_bl_cnt", ovo.getNrcvBlCnt());
				eventResponse.setETCData("donld_bl_cnt", ovo.getDonldBlCnt());
				eventResponse.setETCData("hold_bl_cnt", ovo.getHoldBlCnt());
				eventResponse.setETCData("rels_bl_cnt", ovo.getRelsBlCnt());
				eventResponse.setETCData("total_bl_cnt", ovo.getTotalBlCnt());
				eventResponse.setETCData("total_vvd_cnt", ovo.getTotalVvdCnt());
				eventResponse.setETCData("total_amd_cnt", ovo.getTotalAmdCnt());

			}
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0370:bkg0370_blur<br>
	 * 화면에서 POD를 drop down으로 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestPodList(Event e) throws EventException {
		try {
			EsmBkg0370Event event = (EsmBkg0370Event) e;
			// TransshipmentMgtBC command = new TransshipmentMgtBCImpl();
			// List<BkgComboVO> list =
			// command.searchManifestPodList(event.getTsVvdFor1st2ndInputVO());

			CustomsTransmissionBC command2 = new MexCustomsTransmissionBCImpl();
			// BC에 작업 요청
			List<BkgComboVO> list = command2.searchManifestPodList(event
					.getCondVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_1106 : SEARCH06<BR>
	 * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreEUportByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = null;
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command.searchPreEUportByVvd(event
						.getManifestListCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1106 : SEARCH07<BR>
	 * Finland (IE344) / VVD FocusOut 시, 해당하는 vvd 의 pre EU Port 를 조회.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreEUvvdByBL(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<ManifestListDetailVO> list = new ArrayList<ManifestListDetailVO>();
		try {
			String eventName = e.getEventName();
			if (eventName.equalsIgnoreCase("EsmBkg1106Event")) {
				EsmBkg1106Event event = (EsmBkg1106Event) e;
				command = new Eur24ManifestDownloadBCImpl();
				list = command
						.searchPreEUvvdByBL(event.getManifestListCondVO());
			}
			eventResponse.setETCData("bl_cnt", list.size() + "");
			if (list.size() > 0) {
				Eu24ManifestListVO vo = (Eu24ManifestListVO) list.get(0);
				eventResponse.setETCData("vvd",
						vo.getVslCd() + vo.getSkdVoyNo() + vo.getSkdDirCd());
				eventResponse.setETCData("pol", vo.getPol());
				eventResponse.setETCData("pol_yd", vo.getPolYdCd());
				eventResponse.setETCData("pod", vo.getPod());
				eventResponse.setETCData("pod_yd", vo.getPodYdCd());
			} else {
				eventResponse.setETCData("vvd", "");
				eventResponse.setETCData("pol", "");
				eventResponse.setETCData("pol_yd", "");
				eventResponse.setETCData("pod", "");
				eventResponse.setETCData("pod_yd", "");
			}
			eventResponse.setRsVoList(list);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1164 : Retrieve<br>
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.(ESM_BKG_1164)<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForFdrBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1164Event event = (EsmBkg1164Event) e;
		ManifestListDownloadBC command = null;

		try {

			command = new RussiaManifestListDownloadBCImpl();
			List<FdrBlVO> list = command.searchBkgListForFdrBl(event
					.getFdrBlInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1164: save<br>
	 * customer 정보를 변경한다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCustInfoBkgCstmsRuCust(Event e)
			throws EventException {
		ManifestListDownloadBC command = null;
		try {
			begin();

			EsmBkg1164Event event = (EsmBkg1164Event) e;
			command = new RussiaManifestListDownloadBCImpl();
			command.manageCustInfoBkgCstmsRuCust(event.getFdrBlVOS(), account);

			commit();

			// 저장후 결과처리
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage()); // BKG00166 : 저장성공
			return eventResponse;

		} catch (EventException ex) {
			rollback();
			log.error("err" + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err" + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(),
					ex);
		}
	}

	/**
	 * ESM_BKG_1168 : SEARCH01 <br>
	 * 입력된 VVD 가 이스라엘을 거치는지 아닌지 VVD schedule 을 조회한다. <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselSchedule(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			EsmBkg1168Event event = (EsmBkg1168Event) e;
			command = new IsraelManifestDownloadBCImpl();
			String skdFlg = command.searchVesselSchedule(event
					.getManifestListCondVO());
			eventResponse.setETCData("skd_flg", skdFlg);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1169 : SEARCH <br>
	 * 이스라엘 수신 히스토리를 조회한다. <br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRcvHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			EsmBkg1169Event event = (EsmBkg1169Event) e;
			command = new IsraelManifestDownloadBCImpl();
			List<IsraelSearchRcvHisVO> list = command.searchRcvHis(event
					.getIsraelRcvHisCondVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0219 : SEARCH <br>
	 * Inbound Domestic T/S Manifest 목록 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInboundTSManifest(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0219Event event = (EsmBkg0219Event) e;
		CustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();

		try {
			InboundTSGRPVO inboundTSGRPVO = command
					.searchInboundTSManifest(event.getInboundTSInfoBLVO());
			// 순서에 주의
			if (inboundTSGRPVO.getInboundTSCustVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSCustVO()
						.getColumnValues());
			if (inboundTSGRPVO.getInboundTSInfoSKDVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoSKDVO()
						.getColumnValues());
			if (inboundTSGRPVO.getInboundTSInfoBLVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoBLVO()
						.getColumnValues());
			eventResponse.setRsVoList(inboundTSGRPVO.getInboundTSCntrVOList());
			eventResponse.setRsVoList(inboundTSGRPVO
					.getInboundTSDownExcelVOList());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1163 SAVE 시 CNTR WGT 정보 저장
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageRussiaCntrInfo(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			begin();
			// 이벤트별 Impl생성
			EsmBkg1163Event event = (EsmBkg1163Event) e;
			command = new RussiaManifestListDownloadBCImpl();

			command.manageRussiaCntrInfo(event.getModifyCntrInfoVOs(), account);
			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1171 : SEARCH <br>
	 * 세관에 신고할 대상 VesselArrival 정보 데이터를 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBlArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// ManifestListDownloadBC command = null;
		// List<VesselArrivalDetailVO> list = null;
		try {
			log.error("SC_EUR24________________retrieve");

			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			List<Eur24VesselFIArrivalNoticeDetailVO> voList = null;
			EsmBkg1171Event event = (EsmBkg1171Event) e;
			voList = command2
					.searchBlFIArrival((Eur24VesselArrivalCondVO) event
							.getVesselArrivalCondVO());
			eventResponse.setRsVoList(voList);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * 
	 * ESM_BKG_1171 : MULTI01 <br>
	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse transmitFiBlArrival(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		String flatFile = "";
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1171Event")) {
				// ENS EDI FLAT FILE 생성 및 전송
				EsmBkg1171Event event = (EsmBkg1171Event) e;
				command = new Eur24CustomsTransmissionBCImpl();

				for (int i = 0; i < event.getVesselArrivalDetailVOS().length; i++) {

					flatFile = command
							.transmitFiBlArrival(event
									.getVesselArrivalDetailVOS()[i],
									(VesselArrivalTransmitVO) event
											.getEur24VesselArrivalTransmitVO(),
									account);
					log.debug("SC_EUR24________________transmit");
				}

				// flatFile =
				// command.transmitVesselArrival((VesselArrivalTransmitVO)event.getEur24VesselArrivalTransmitVO(),
				// account);

			}
			commit();
		} catch (EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1171 : MULTI <br>
	 * Finland 세관 신고 대상 Vessel Arrival Notice, Port net No를 저장한다.
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFIVesselArrival(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();

			EsmBkg1171Event event = (EsmBkg1171Event) e;
			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			command2.manageFIVesselArrival(
					(Eur24VesselFIArrivalNoticeDetailVO) event
							.getVesselArrivalDetailVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : IBSEARCH searching Country Code, Customs Division ID,
	 * Customs Code Description
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvDescList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event = (EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsCdConvVO> list = command.searchCstmsCdConvDescList(event
					.getCstmsCdConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : SEARCH01 searching Country Code, Customs Division ID,
	 * Attribute Content information
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsCdConvCtntList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event = (EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsCdConvVO> list = command.searchCstmsCdConvCtntList(event
					.getCstmsCdConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : MULTI01 <br>
	 * managing information of Country Code, Customs Division ID, Customs Code
	 * Description <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsCdConvDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event = (EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsCdConvDesc(event.getCstmsCdConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : MULTI02 <br>
	 * managing information of Country Code, Customs Division ID, Attribute
	 * Content<br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsCdConvCtnt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event = (EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsCdConvCtnt(event.getCstmsCdConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2001 : SEARCH02 searching duplication of Country Code, Customs
	 * Division ID
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCstmsCdConvDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2001Event event = (EsmBkg2001Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String cntCd = null;
		String cstmsDivId = null;
		String conv_cnt = null;

		try {
			cntCd = event.getCstmsCdConvVO().getChkCntCd();
			cstmsDivId = event.getCstmsCdConvVO().getChkCstmsDivId();
			conv_cnt = command.checkCstmsCdConvDesc(cntCd, cstmsDivId);
			eventResponse.setETCData("conv_cnt", conv_cnt);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : IBSEARCH searching Country Code, Package Type Code,
	 * Customs Package Type Code
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsPckTpConvList(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event = (EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsPckTpConvVO> list = command
					.searchCstmsPckTpConvList(event.getCstmsPckTpConvVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : MULTI <br>
	 * managing information of Country Code, Package Type Code, Customs Package
	 * Type Code <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsPckTpConv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event = (EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsPckTpConv(event.getCstmsPckTpConvVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : SEARCH01 searching duplication of Country Code, Package
	 * Type Code, Customs Package Type Code
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCstmsPckTpConv(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event = (EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String cntCd = null;
		String pckTpCd = null;
		String cstmsPckTpCd = null;
		String pck_tp_cnt = null;

		try {
			cntCd = event.getCstmsPckTpConvVO().getChkCntCd();
			pckTpCd = event.getCstmsPckTpConvVO().getChkPckTpCd();
			cstmsPckTpCd = event.getCstmsPckTpConvVO().getChkCstmsPckTpCd();
			pck_tp_cnt = command.checkCstmsPckTpConv(cntCd, pckTpCd,
					cstmsPckTpCd);
			eventResponse.setETCData("pck_tp_cnt", pck_tp_cnt);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2002 : SEARCH02 searching Package Type Code
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkPckTpCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2002Event event = (EsmBkg2002Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String pckTpCd = null;
		String pck_tp_cnt1 = null;

		try {
			pckTpCd = event.getCstmsPckTpConvVO().getChkPckTpCd();
			pck_tp_cnt1 = command.checkPckTpCd(pckTpCd);
			eventResponse.setETCData("pck_tp_cnt1", pck_tp_cnt1);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2003 : IBSEARCH searching Country Code, Customs Error Code
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCstmsAdvErrList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2003Event event = (EsmBkg2003Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			List<CstmsErrCdVO> list = command.searchCstmsAdvErrList(event
					.getCstmsErrCdVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2003 : MULTI <br>
	 * managing information Country Code, Customs Error Code <br>
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCstmsAdvErr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2003Event event = (EsmBkg2003Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		try {
			begin();
			command.manageCstmsAdvErr(event.getCstmsErrCdVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_2003 : SEARCH01 searching duplication of Country Code, Customs
	 * Error Code
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse checkCstmsAdvErr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2003Event event = (EsmBkg2003Event) e;
		CustomsCommonMgtBC command = new CustomsCommonMgtBCImpl();

		String cntCd = null;
		String cstmsErrCd = null;
		String err_cd_cnt = null;

		try {
			cntCd = event.getCstmsErrCdVO().getChkCntCd();
			cstmsErrCd = event.getCstmsErrCdVO().getChkCstmsErrCd();
			err_cd_cnt = command.checkCstmsAdvErr(cntCd, cstmsErrCd);
			eventResponse.setETCData("err_cd_cnt", err_cd_cnt);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
//	/**
//	 * 
//	 * ESM_BKG_1106 : MULTI03 <br>
//	 * 단건씩 전송 Manifest를 신고하기 위해 FlatFile을 생성한다.<br>
//	 * 
//	 * @param Event
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unchecked")
//	private EventResponse transmitManifest(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		CustomsTransmissionBC command = null;
//
//		try {
//			begin();
//			// 이벤트별 Impl생성
//			if (e.getEventName().equalsIgnoreCase("EsmBkg0257Event")) {
//				// ENS EDI FLAT FILE 생성 및 전송
//				EsmBkg0257Event event = (EsmBkg0257Event) e;
//				command = new EurCustomsTransmissionBCImpl();
//				command.transmitManifest(event.getEuManifestTransmitVOs(),
//						account);
//
//			}
//			commit();
//		} catch (EventException ex) {
//			log.error("EventException : " + ex.toString(), ex);
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			log.error("Exception : " + ex.toString(), ex);
//			rollback();
//			throw new EventException(new ErrorHandler("BKG06088").getMessage(),
//					ex);
//		}
//		return eventResponse;
//	}
	
	
	
	
//	
//	/**
//	 * ESM_BKG_1223 : IBSEARCH <br>
//	 * Export Vessel List를 조회한다.<br>
//	 * 
//	 * @param Event
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unchecked")
//	private EventResponse searchExpVesselList(Event e) throws EventException {
//				// PDTO(Data Transfer Object including Parameters)
//		CustomsReportBC command = null;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		try {
//			if (e.getEventName().equalsIgnoreCase("EsmBkg1223Event")) {
//				EsmBkg1223Event event = (EsmBkg1223Event) e;
//				command = new IndiaCustomsReportBCImpl();
//				List<IndExpVesselPlanListVO> indExpVesselPlanListVOs 
//					= (List<IndExpVesselPlanListVO>) (Object) (command.searchExpVesselList((IndDecCondVO) event.getIndDecCondVO()));
//				if (indExpVesselPlanListVOs.size() == 0)
//					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
//				eventResponse.setRsVoList(indExpVesselPlanListVOs);
//			} 
//
//		} catch (EventException ex) {
//			throw ex;
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
//					ex);
//		}
//		return eventResponse;
//	}
//	
//	/**
//	 * ESM_BKG_1221 : IBSEARCH <br>
//	 * (India))Reexport List를 조회한다.<br>
//	 * 
//	 * @param Event
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unchecked")
//	private EventResponse searchReexportList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		CustomsReportBC command = null;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			if (e.getEventName().equalsIgnoreCase("EsmBkg1221Event")) {
//				EsmBkg1221Event event = (EsmBkg1221Event) e;
//				command = new IndiaCustomsReportBCImpl();
//				List<IndReexportListVO> indReexportListVOs 
//				= (List<IndReexportListVO>) (Object) (command.searchReexportList((IndDecCondVO) event.getIndDecCondVO()));
//		    if (indReexportListVOs.size() == 0)
//		    	eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
//		    	eventResponse.setRsVoList(indReexportListVOs);
//			} 
//
//		} catch (EventException ex) {
//			throw ex;
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
//			ex);
//		}
//		return eventResponse;
//	}
//	
//	/**
//	 * ESM_BKG_1222 : IBSEARCH <br>
//	 * (India)Export Advanced List를 조회한다.<br>
//	 * 
//	 * @param Event
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unchecked")
//	private EventResponse searchExpAdvanceList(Event e) throws EventException {
//		// PDTO(Data Transfer Object including Parameters)
//		CustomsReportBC command = null;
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			if (e.getEventName().equalsIgnoreCase("EsmBkg1222Event")) {
//				EsmBkg1222Event event = (EsmBkg1222Event) e;
//				command = new IndiaCustomsReportBCImpl();
//				List<IndExpAdvanceListVO> indExpAavanceListVOs 
//				= (List<IndExpAdvanceListVO>) (Object) (command.searchExpAdvanceList((IndDecCondVO) event.getIndDecCondVO()));
//		    if (indExpAavanceListVOs.size() == 0)
//		    	eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
//		    	eventResponse.setRsVoList(indExpAavanceListVOs);
//			} 
//
//		} catch (EventException ex) {
//			throw ex;
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
//			ex);
//		}
//		return eventResponse;
//	}
	
	
	
	/**
	 * EU A/N (ESM_BKG_1104) 에서 구주스탭이 해당 VVD 의 모든 MRN 을 삭제
	 * 
	 * @param Event e
	 * @return eventResponse
	 * @throws EventException
	 */
	private EventResponse deleteAllMrn(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			
			EsmBkg1104Event event = (EsmBkg1104Event) e;
			Eur24ManifestDownloadBCImpl command2 = new Eur24ManifestDownloadBCImpl();
			command2.deleteAllMrn((Eur24VesselArrivalNoticeDetailVO) event.getVesselArrivalDetailVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),	ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1178 : IBSEARCH <br>
	 * CRN 조회한다.<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgCstmsCndVslCrnNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1178Event")) {
				EsmBkg1178Event event = (EsmBkg1178Event) e;
				command = new CndManifestListDownloadBCImpl();
				List<CndCstmsVslCrnNoVO> cndCstmsVslCrnNoVO 
				= (List<CndCstmsVslCrnNoVO>) (Object) (command.searchBkgCstmsCndVslCrnNo((CndCstmsVslCrnNoVO) event.getCndCstmsVslCrnNoVO()));
		    if (cndCstmsVslCrnNoVO.size() == 0)
		    	eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
		    	eventResponse.setRsVoList(cndCstmsVslCrnNoVO);
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
	 * EsmBkg1178Event management event process<br>
	 *  CRN 정보삭제<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
 	 */
    private EventResponse removeBkgCstmsCndVslCrnNo(Event e) throws EventException {
    	EsmBkg1178Event event = (EsmBkg1178Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ManifestListDownloadBC command = new CndManifestListDownloadBCImpl();
    	
        try {
            begin();
                        
            command.removeBkgCstmsCndVslCrnNo(event.getCndCstmsVslCrnNoVO());
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
  	 * ESM_BKG_1179 : IBSEARCH <br>
  	 * CRN 조회한다.<br>
	 * @param Event
	 * @return EventResponse
	 * @exception EventException
	 *  	 */
  	@SuppressWarnings("unchecked")
  	private EventResponse searchUsCustomsStatusNoticeInfo(Event e) throws EventException {

  		UsaManifestListDownloadBCImpl command = null;
  		GeneralEventResponse eventResponse = new GeneralEventResponse();

  		try {
  			if (e.getEventName().equalsIgnoreCase("EsmBkg1179Event")) {
  				command = new UsaManifestListDownloadBCImpl();
  				
  				EsmBkg1179Event event = (EsmBkg1179Event) e;
  				
  				//단건조회
  				UsCustomsStatusNoticeVO usCustomsVO = command.searchUsCustomsStatusNoticeInfo(event.getUsCustomsStatusNoticeVO().getHndlOfcCd());
  				
  				//ETC-DATA:ETC KEY 선언
  				if(usCustomsVO != null){
  					if(usCustomsVO.getHndlOfcCd() != null){
  						//eventResponse.setETCData(usCustomsVO.getColumnValues());
  						eventResponse.setRsVo(usCustomsVO);
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
  	 * ESM_BKG_1179 : SAVE <br>
  	     * UserSetupMgt의 event에 대한 멀티 이벤트 처리<br>
  	     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다.<br>
  	     * @param e Event
  	     * @return response EventResponse
  	     * @exception EventException
  	     */
  	@SuppressWarnings("unchecked")  	
  	private EventResponse manageUsCustomsStatusNoticeInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        EsmBkg1179Event event = (EsmBkg1179Event) e;
        
        UsaManifestListDownloadBCImpl command = new UsaManifestListDownloadBCImpl();
        
        event.getUsCustomsStatusNoticeVO().setCreUsrId(account.getUsr_id());
        event.getUsCustomsStatusNoticeVO().setUpdUsrId(account.getUsr_id());
       
        try {
        	
            begin();
			command.manageUsCustomsStatusNoticeInfo(event.getUsCustomsStatusNoticeVO());
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
  	 
  	
  	private EventResponse searchBkgCCAMList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1053Event")) {
				EsmBkg1053Event event = (EsmBkg1053Event) e;
				command = new ChinaCustomsReportBCImpl();
				List<BkgCstmsCCAMListVO> bkgCstmsCCAMListVOs 
				= (List<BkgCstmsCCAMListVO>) (Object) (command.searchBkgCCAMList((BkgCstmsCCAMCondVO) event.getBkgCstmsCCAMCondVO()));
		    if (bkgCstmsCCAMListVOs.size() == 0)
		    	eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
		    	eventResponse.setRsVoList(bkgCstmsCCAMListVOs);

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
	 * Europe Customs EDI Country Code 를 조회한다.<br>
	 * 
	 * @param String cmCode
	 * @return String
	 * @exception EventException
	 */
	private String searchEurCustCntCode(String cmCode) throws EventException {
		CustomsTransmissionBC command = new EurCustomsTransmissionBCImpl();		
		return command.searchEurCustCntCode(cmCode);
	}  	
	
	/**
	 * Europe Customs EDI 의 receiver 를 조회한다.<br>
	 * @param String cmCode
	 * @param String cntCd
	 * @return EventResponse
	 * @exception EventException
 	 */
	private EventResponse searchEurCustReceiver(String cmCode, String cntCd) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		CustomsTransmissionBC command = new EurCustomsTransmissionBCImpl();

		try {
			List<BkgComboVO> list = command.searchEurCustReceiver(cmCode, cntCd);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
//	/**
//	 * ESM_BKG_1149 : SEARCH01<BR>
//	 * ESM_BKG_1149 : SEARCH01<BR>
//	 * Ams Pod 조회<br>
//	 * 
//	 * @param Event
//	 *            e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchManifestExcelList(Event e) throws EventException {
//		ManifestListDownloadBC command = new VietnamManifestDownloadBCImpl();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
//			List<ManifestListDetailVO> manifestListDetailVOs = command.searchManifestExcelList((ManifestListCondVO) event.getVietnamManifestListCondVO());
//			eventResponse.setRsVoList(manifestListDetailVOs);
//			
//			if (manifestListDetailVOs.size() > 0) {
//
//				VietnamManifestListVO vietnamManifestListVO = (VietnamManifestListVO) manifestListDetailVOs
//						.get(0);
//				eventResponse.setRsVoList(vietnamManifestListVO.getVietnamManifestListSecondBlInfoVOs());
//				
//			}
//			
//			
//		} catch (EventException ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return eventResponse;
//	}
//	
	
	
	/**
	* ESM_BKG_1149 : IBSEARCH <br>
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchManifestExcelList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ManifestListDownloadBC command = new VietnamManifestDownloadBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1149Event")) {
				EsmBkg1149Event event = (EsmBkg1149Event) e;
				
				
				List<VietnamManifestListSecondBlInfoVO> list = command.searchManifestExcelList((ManifestListCondVO)event.getVietnamManifestListCondVO());
				eventResponse.setRsVoList(list);

			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		return eventResponse;	
}
	
	
	
	private EventResponse searchAusDgInfo(Event e) throws EventException {
		ManifestListDownloadBC command = new AusDgManifestListDownloadBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1511Event")) {
				EsmBkg1511Event event = (EsmBkg1511Event) e;

				List<AusVslInfoVO> vslInfo = command.searchAusVslInfo((AusDgListCondVO)event.getAusDgListCondVO());
				//List<AusDgListDetailVO> dgList = command.searchAusDgInfo((AusDgListCondVO)event.getAusDgListCondVO());
				List<AusBkgAndLocalDgListDetailVO> dgList = command.searchAusDgInfoAtBkgAndLocal((AusDgListCondVO)event.getAusDgListCondVO());
				
				
				
				eventResponse.setRsVoList(vslInfo);
				eventResponse.setRsVoList(dgList);
				
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),ex);
		}
		return eventResponse;
		

	}
	
	
	private EventResponse manageDgManifestList(Event e) throws EventException {
       // PDTO(Data Transfer Object including Parameters)
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       
       ManifestListDownloadBC command = new AusDgManifestListDownloadBCImpl();
       
      
       try {
    	    begin();
    	   if("EsmBkg1511Event".equalsIgnoreCase(e.getEventName())){
    		   
    		   EsmBkg1511Event event = (EsmBkg1511Event) e;
    		   command.manageDgManifestList(event.getAusVslInfoVO(),event.getAusDgListDetailVOs() , account);
    	   }else if("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())){
    		   
    		   EsmBkg1512Event event = (EsmBkg1512Event) e;
    		   command.modifyDgInquiry(event.getDgInqModiVO(), account);
				//command.modifyDgInquiry(event.getDgInqModiVO(), event.getDgInqModiVOs(), account);
    	   }
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
	 * ESM_BKG_1511 :
	 * 호주 위험물 Flat File 생성 및 EDI 전송<br>
	 * ManifestListDownload의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendDgManifestList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsTransmissionBC command = null;
		
		List<String> flatFileList = null;
		try {
			begin();
			if ("EsmBkg1511Event".equalsIgnoreCase(e.getEventName())) {
				command = new AustrailiaCustomsTransmissionBCImpl();
				EsmBkg1511Event event = (EsmBkg1511Event) e;
				flatFileList = command.sendDgManifestList((DgEdiVO[])event.getManifestTransmitVOs(),account);

				if (flatFileList != null) {
					eventResponse.setETCData("originalFlatFile", flatFileList
							.get(0));
					eventResponse.setETCData("updateFlatFile", flatFileList
							.get(1));
					eventResponse.setETCData("cancelFlatFile", flatFileList
							.get(2));
				} else {
					eventResponse.setETCData("originalFlatFile", "");
					eventResponse.setETCData("updateFlatFile", "");
					eventResponse.setETCData("cancelFlatFile", "");
				}

				// 성공 메시지 셋팅
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;

	}
	

    
	/**                                                                                                                                                                   
	* [0329] : CHM-201641466                                                                                                                                              
	* Manifest Generate의 B/L List에서 체크된 B/L의 수출신고 번고가 없는 경우<br>                                                                                         
	* Booking의 e-Mail Contract에 Mail을 전송한다.<br>                                                                                                                    
	* @param e                                                                                                                                                            
	* @return EventResponse                                                                                                                                               
	* @exception EventException                                                                                                                                           
	*/                                                                                                                                                                    
	private EventResponse sendSimpleElNoEmail (Event e) throws EventException{                                                                                         
		GeneralEventResponse eventResponse = new GeneralEventResponse();                                                                                                 
		//EsmBkg0381Event event = (EsmBkg0381Event)e;                                                                                                                    
		ManifestListDownloadBC command = null;                                                                                                                           
		command = new KorManifestListDownloadBCImpl();                                                                                                                   
		              
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();                                                                                                       
		//ArrNtcSendListVO[] listVOS = event.getListVOS();                                                                                                               
		              
		EsmBkg0329Event event = (EsmBkg0329Event) e;                                                                                                                     
		KorDlContainerVO cont = new KorDlContainerVO();                                                                                                                  
		KorMrnNoVO fromClient = event.getMrnNoVO();                                                                                                                      
		KorManifestInfoVO[] list = event.getManifestInfoVOs();                                                                                                           
		KorBkgCntrQtyInfoVO[] cntrList = event.getCntrVOs();                                                                                                             
		              
		cont.setKorMrnNoVO(fromClient);                                                                                                                                  
		cont.setKorManifestInfoVOs(list);                                                                                                                                
		cont.setKorBkgCntrQtyInfoVOs(cntrList);                                                                                                                          
		                
		try {                                                                                                                                                            
			String uiId = "ESM_BKG_0329";                                                                                                                                  
			              
			begin();                                                                                                                                                       
			                      
			List<BkgNtcHisVO> hisVOS = command.sendSimpleElNoEmail(cont, account);                                                                                         
			                
			hisBC.createBkgNtcHis(hisVOS, uiId);                                                                                                                           
			eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());                                                                                   
			                
			eventResponse.setETCData("sendcount", Integer.toString(hisVOS.size()));                                                                                        
			                
			commit();                                                                                                                                                      
			              
		}catch(EventException ex) {                                                                                                                                      
			throw ex;                                                                                                                                                    
		}catch(Exception ex) {                                                                                                                                           
			rollback();                                                                                                                                                   
			String[] msg = new String[]{"Arrival Notice"};                                                                                                                
			throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());                                                                                      
		}                                                                                                                                                                
		return eventResponse;                                                                                                                                            
	}                                                                                                                                                                  
	            
	          
	/**                                                                                                                                                                   
	* [0329] : CHM-201641466                                                                                                                                            
	* Manifest Generate의 B/L List에서 체크된 B/L이 Console일 경우 HOUSE BL EDI 전송을 요청<br>                                                                                       
	* Booking의 e-Mail Contract에 Mail을 전송한다.<br>                                                                                                                  
	* @param e                                                                                                                                                          
	* @return EventResponse                                                                                                                                             
	* @exception EventException                                                                                                                                         
	*/                                                                                                                                                                  
	private EventResponse sendConsoleEmail (Event e) throws EventException{                                                                                      
		GeneralEventResponse eventResponse = new GeneralEventResponse();                                                                                                 
		//EsmBkg0381Event event = (EsmBkg0381Event)e;                                                                                                                    
		ManifestListDownloadBC command = null;                                                                                                                           
		command = new KorManifestListDownloadBCImpl();                                                                                                                   
		              
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();                                                                                                       
		//ArrNtcSendListVO[] listVOS = event.getListVOS();                                                                                                               
		              
		EsmBkg0329Event event = (EsmBkg0329Event) e;                                                                                                                     
		KorDlContainerVO cont = new KorDlContainerVO();                                                                                                                  
		KorMrnNoVO fromClient = event.getMrnNoVO();                                                                                                                      
		KorManifestInfoVO[] list = event.getManifestInfoVOs();                                                                                                           
		KorBkgCntrQtyInfoVO[] cntrList = event.getCntrVOs();                                                                                                             
		              
		cont.setKorMrnNoVO(fromClient);                                                                                                                                  
		cont.setKorManifestInfoVOs(list);                                                                                                                                
		cont.setKorBkgCntrQtyInfoVOs(cntrList);                                                                                                                          
		                
		try {                                                                                                                                                            
			String uiId = "ESM_BKG_0329";                                                                                                                                  
			              
			begin();                                                                                                                                                       
			                      
			List<BkgNtcHisVO> hisVOS = command.sendConsoleEmail(cont, account);                                                                                      
			                
			hisBC.createBkgNtcHis(hisVOS, uiId);                                                                                                                           
			eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());                                                                                   
			                
			eventResponse.setETCData("sendcount", Integer.toString(hisVOS.size()));                                                                                        
			                
			commit();                                                                                                                                                      
		              
		}catch(EventException ex) {                                                                                                                                      
			throw ex;                                                                                                                                                    
		}catch(Exception ex) {                                                                                                                                           
			rollback();                                                                                                                                                   
			String[] msg = new String[]{"Arrival Notice"};                                                                                                                
			throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());                                                                                      
		}                                                                                                                                                                
		return eventResponse;                                                                                                                                            
	}                                                                                                                                                                  

	
	
	/**
	 * ESM_BKG_1512 :
	 * Forward Code로 Forward Name을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchForwarderName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				EsmBkg1512Event event = (EsmBkg1512Event) e;
				String anrFwrdName = command.searchForwarderName(event.getDgListCondVO());
				eventResponse.setETCData("anrFwrdName", anrFwrdName);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1512 :
	 * UN NO로 NAME을 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnnoName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				EsmBkg1512Event event = (EsmBkg1512Event) e;
				String imdgUnNoDesc = command.searchUnnoName(event.getDgListCondVO());
				eventResponse.setETCData("imdgUnNoDesc", imdgUnNoDesc);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1512 :
	 * Feeder Name, Lloyd No를 조회한다.<Br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgFeederNameList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		List<FeederNameVO> list = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				list = command.searchDgFeederNameList();
				eventResponse.setRsVoList(list);
			} else if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				
				StringBuffer feederName = null;
				StringBuffer feederLloydNo = null;
				StringBuffer displayTextOffeederNameLloyNo = null;
				
				command = new AusDgManifestListDownloadBCImpl();
				list = command.searchDgFeederNameList();
				
				if(list != null) {
					int listMaxSize = list.size(); 
					if(listMaxSize > 0) {
						feederName = new StringBuffer();
						feederLloydNo = new StringBuffer();
						displayTextOffeederNameLloyNo = new StringBuffer();
						feederName.append(" ");
						feederLloydNo.append(" ");
						displayTextOffeederNameLloyNo.append(" ").append("\t").append(" ");
						for(int i=0; i < listMaxSize; i++) {
							feederName.append("|").append(list.get(i).getFeederName());
							feederLloydNo.append("|").append(list.get(i).getFeederLloydNo());
							displayTextOffeederNameLloyNo.append("|")
														 .append(list.get(i).getFeederName())
														 .append("\t")
														 .append(list.get(i).getFeederLloydNo());
						} // end for(i)
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederName", feederName.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("feederLloydNo", feederLloydNo.toString());
						// Feeder Name, Lloyd No Combo List
						eventResponse.setETCData("displayTextOffeederNameLloyNo", displayTextOffeederNameLloyNo.toString());
					}
				}
				
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;

	}
	
	
	/**
	 * ESM_BKG_1512 :
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrInfoListByBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				EsmBkg1512Event event = (EsmBkg1512Event) e;
				List<DgCntrInfoListVO> list = command.searchCntrInfoListByBl(event.getDgCargoCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1512 :
	 * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCgoSeqListByCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				EsmBkg1512Event event = (EsmBkg1512Event) e;
				List<DgCntrInfoListVO> list = command.searchCgoSeqListByCntr(event.getDgCargoCondVO());
				eventResponse.setRsVoList(list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1512 :
	 * Danger cargo 정보를 컨테이너 단위로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgCargoInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ManifestListDownloadBC command = null;
		try {
			if ("EsmBkg1512Event".equalsIgnoreCase(e.getEventName())) {
				command = new AusDgManifestListDownloadBCImpl();
				EsmBkg1512Event event = (EsmBkg1512Event) e;
				List<DgInqModiVO> dgInqModiVOs = command.searchDgCargoInfo(event.getDgCargoCondVO());
				//eventResponse.setRsVo(dgInqModiVOs);
				eventResponse.setRsVoList(dgInqModiVOs);

			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0333 : COMMAND02<br>
	 * KOREA WHF - Charge Rate 삭제
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse deleteWhfChgRt(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<BkgChgRateVO> listVO =  new ArrayList<BkgChgRateVO>();
			BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
			//BlRatingBC ratingBC = new BlRatingBCImpl();
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			
			BLDocumentationBLBC     blDocBlBC  	= new BLDocumentationBLBCImpl();
    		SpecialCargoReceiptBC   spclCgoBC  	= new SpecialCargoReceiptBCImpl();
    		BlRatingBC              blRatingBC	= new BlRatingBCImpl();
	    	BDRCorrectionBC         bdrBC      	= new BDRCorrectionBCImpl();
			GeneralBookingReceiptBC receiptBC  	= new GeneralBookingReceiptBCImpl();
			BLIssuanceBC            blIssBC    	= new BLIssuanceBCImpl();
			
			BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
			HistoryTableVO historyTableVO = new HistoryTableVO() ;
			
			com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masCmd  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();
			
			String uiId ="ESM_BKG_0333";
			String whfWave = "";
			String bkgNo = "";
					
			EsmBkg0333Event event = (EsmBkg0333Event) e;
			
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			korDiscCYBondInfoVO.setUsrId(account.getUsr_id());
			
			command = new KorManifestListDownloadBCImpl();
			
			// Booking Creation > Charge tab > "BB"를 제외한 WHF 금액 list 찾기
			korDiscCYBondInfoVO.setWhfTp("NONE"); // BB를 제외한 WHF 금액을 찾기 위해서 setting
			List<KorDiscCYBondInfoVO> list= command.searchWhfRateList(korDiscCYBondInfoVO);
			
			if(list.size()>0){
				begin();
				
				// bkg no setting
    			bkgBlNoVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
    			bkgBlNoVO.setBlNo(korDiscCYBondInfoVO.getBkgNo());
    			bkgBlNoVO.setBdrFlg(korDiscCYBondInfoVO.getBdrFlg());
    			bkgBlNoVO.setCaFlg("N");
                
    			// 1. C/A 이력을 insert한다.
    			if("Y".equals(korDiscCYBondInfoVO.getBdrFlg())){
					//auto c/a를 위한 BC, 해당 될때만 load한다.
		    		
					
					// 1st C/A History
	            	String strReturn  = "N";    		
	    			String copyTypeCd = "HIST000";
	    			
	    			
	    			strReturn = bdrBC.add1stCaHist(bkgBlNoVO, account);
	    			
	    			if ("N".equals(strReturn)) {
	    				bkgBlNoVO.setCaNo("0000000001");     				
	        			receiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);
	        			blDocBlBC.createBlCA     (bkgBlNoVO, copyTypeCd);
	        			spclCgoBC.createSpclCA   (bkgBlNoVO, copyTypeCd);
	        			blRatingBC.createRateCA  (bkgBlNoVO, copyTypeCd);
	        			blIssBC.createIssCA      (bkgBlNoVO, copyTypeCd);
	    			}	    			
	    			
    			}
    			
    			// 2. Auto C/A를 위해서  현재 테이블 값을 가져온다.
				historyTableVO = historyBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
				
				/////////////////////////////////////////////
				// 3. Main Logic ::  Rate 테이블에스 BKG WHF 금액 삭제
				int listMaxSize = list.size(); 
				String caflag = "N"; // BDR Flg =Y 이더라도 AutoCA를 통해 CA작업하니 Rating 데이터 작업은 CA아닌 것으로 인식하여 수행
				
				for(int i=0; i<listMaxSize; i++){
					bkgChgRateVO.setBkgNo(list.get(i).getBkgNo());
					bkgChgRateVO.setRtSeq(list.get(i).getRtSeq());
					
					listVO.add(i,bkgChgRateVO);
				}
				
				//ratingBC.removeChgRate(listVO, caflag);
				
				blRatingBC.removeChgRate(listVO, caflag);
				//////////////////////////////////////////////
				
				
				// 4. BDR Flg = Y 일경우, 실제 변경 c/a 처리
				if("Y".equals(korDiscCYBondInfoVO.getBdrFlg())){
					
					// WHF Wave 구하기 => C/A 사유에 넣기 위해서.
					List<KorRateHeadVO> korRateHeadVOs = command.searchWhfWaveInfo(korDiscCYBondInfoVO);
					
					if(korRateHeadVOs.size() >0){
						KorRateHeadVO korRateHeadVO = korRateHeadVOs.get(0);
						whfWave = "KOREA Manifest- WHF : " + korRateHeadVO.getWhfWaveEng() + "(" + korRateHeadVO.getWhfWaveKor() + ")" ;
						
					}else{
						whfWave = "KOREA Manifest- WHF";
					}
					
	    			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
	            	bkgCorrectionVO.setBkgNo(bkgBlNoVO.getBkgNo());
	            	bkgCorrectionVO.setCaRsnCd("A");
	            	bkgCorrectionVO.setBkgCorrRmk(whfWave); // C/A remark부분 setting
	    			
	    			bdrBC.addAutoCaTemp(bkgBlNoVO, "KOREA_MANIFEST_WHF", bkgCorrectionVO, account);
					
	    			String tempHistCd = "H";
					String copyTypeCd = "HIST";
	
					// C/A createTempHist
					BkgBlNoVO corrBkgBlNoVO = bdrBC.createTempHist(bkgBlNoVO, tempHistCd, null, account);//corr no 채번됨    	
	    			
	    			receiptBC.createBookingCA	(corrBkgBlNoVO, copyTypeCd);    			
	    			blDocBlBC.createBlCA        (corrBkgBlNoVO, copyTypeCd);
	    			spclCgoBC.createSpclCA     	(corrBkgBlNoVO, copyTypeCd);    							
	    			blRatingBC.createRateCA     (corrBkgBlNoVO, copyTypeCd);    							
	    			blIssBC.createIssCA         (corrBkgBlNoVO, copyTypeCd);
	    			
					// C/A History Temp 삭제
					bdrBC.removeCATemp    		(bkgBlNoVO);				
					//blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);		

					historyTableVO.getBkgBlNoVO().setCaNo(corrBkgBlNoVO.getCaNo());
					
				}
				
				// 5. c/a일 경우 History: 맨처음 조회한 Previous 이미지와 변경된 tmp data와 비교하여 History를 만듬
				historyBC.manageBookingHistory(uiId, historyTableVO, account);   
    			
				
				// 6. MAS / Invoice interface
				bkgNo = korDiscCYBondInfoVO.getBkgNo();
				
				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(bkgNo);
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Manage Rate");
                masBkgComIfVo.setCreUsrId(account.getUsr_id());
                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);	
                  
                // Back End Job으로 호출 
                //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	            BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	            ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	            bkgIfVo.setBkgNo(bkgNo);
	            bkgIfVo.setManDivInd("B");
	            bkgIfVo.setUserId(account.getUsr_id());
	            bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
				
	            blRatingBC.distributeCntrRate(bkgNo, account);     
                // 6. End - MAS / Invoice interface
	            
				// 성공메시지 처리
				//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
				eventResponse.setETCData("err_msg", "SUCCESS");
				
				log.error("KOREA WHF-Charge Delete : BKG NO.- " + korDiscCYBondInfoVO.getBkgNo());
				
				//Start. 2015.07.15
				// Wharfage 저장 처리
				BkgRateVO rateVO = new BkgRateVO();
				// Paramter 셋팅
				rateVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				rateVO.setUpdUsrId(account.getUsr_id());
				rateVO.setCreUsrId(account.getUsr_id());
				rateVO.setBkgRtWhfExptCd(korDiscCYBondInfoVO.getBkgRtWhfExptCd());
				rateVO.setWhfShprRgstNo(korDiscCYBondInfoVO.getWhfShprRgstNo());
				// BC에 작업 요청
				blRatingBC.manageWhfExptInfo(rateVO);
				
				// T/S 일 경우 CNTR 정보 update
				BLDocumentationCMBC blDocCMBC = new BLDocumentationCMBCImpl();
				CntrKrWhfExptVO cntrKrWhfExptVO = new CntrKrWhfExptVO();
				
				cntrKrWhfExptVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				cntrKrWhfExptVO.setUpdUsrId(account.getUpd_usr_id());
				
				if("X".equals(korDiscCYBondInfoVO.getWhfWave())){
					// 현재 WHF Wave= T/S 이면 Container의 expt_flg ="Y"로 update
					cntrKrWhfExptVO.setCntrWfgExptFlg("Y");
					blDocCMBC.modifyBkgKrWhfExpt(cntrKrWhfExptVO);
					
				}else if("X".equals(korDiscCYBondInfoVO.getBfrWhfWave())){
					// 변경 전(save 전) WHF Wave=T/S였으면, 체크를 지우기 위해서 Container의 expt_flg= "N"으로 update
					cntrKrWhfExptVO.setCntrWfgExptFlg("N");
					blDocCMBC.modifyBkgKrWhfExpt(cntrKrWhfExptVO);
				}
				// End. 2015.07.15
				
				// 결과 처리
				commit();
				
			}else{
				// Rate쪽에 WHF 관련 삭제할 금액이 없다.
				//eventResponse.setUserMessage(new ErrorHandler("BKG06168").getUserMessage());
				eventResponse.setETCData("err_msg", "BKG06168");
			}
			// Rate쪽에 WHF 관련 삭제할 금액이 없다.


		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),	ex);
		}
		return eventResponse;
	}
	

	/**
	 * ESM_BKG_0332 : SEARCH<BR>
	 * BKG에 대한 WHF 금액 가져오기<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWhfChgRate(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			EsmBkg0332Event event = (EsmBkg0332Event) e;
			
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			
			command = new KorManifestListDownloadBCImpl();
			
			// BB CGO에 대하여 Charge 중 WHF 정보 가져오기
			korDiscCYBondInfoVO.setWhfTp("BB"); 
			List<KorDiscCYBondInfoVO> list= command.searchWhfRateList(korDiscCYBondInfoVO);
			
			// 결과 처리
			if (list.size()==0) {
				// Charge Rate 정보에 WHF금액이 존제하지 않는 경우. No data found.
				//eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("err_msg","BKG06170&the WHF charge of BB Cargo");
				
			}else if(list.size()>1){
				// Charge Rate 정보에 BB WHF 정보가 1개 이상일 경우, Please check the WHF charge. These exists more than one WHF charge.
				eventResponse.setETCData("err_msg","BKG06169");
				
			} else {
				// rt_seq setting 하기 
				korDiscCYBondInfoVO.setRtSeq(((KorDiscCYBondInfoVO)list.get(0)).getRtSeq());
				
				// 1. BB CGO 테이블에서 CBM과 TON값을 계산해서 데이터 가져오기
				List<KorDiscCYBondInfoVO> bbList = command.searchWhfBbCgoWgtInfo(korDiscCYBondInfoVO);
				
				if(bbList.size()>0){
					KorDiscCYBondInfoVO bbVO = bbList.get(0);
					korDiscCYBondInfoVO.setCbmAmt(bbVO.getCbmAmt());
					korDiscCYBondInfoVO.setTonAmt(bbVO.getTonAmt());
					
				}else{
					korDiscCYBondInfoVO.setCbmAmt("");
					korDiscCYBondInfoVO.setTonAmt("");
				}
				
				// 2. KOREA WHF Port Rate 데이터 가져오기
				List<KorDiscCYBondInfoVO> rtList = command.searchWhfPortRt(korDiscCYBondInfoVO);
				if(rtList.size()>0){
					KorDiscCYBondInfoVO rtVO = rtList.get(0);
					korDiscCYBondInfoVO.setChgUtAmt(rtVO.getChgUtAmt());
				}else{
					korDiscCYBondInfoVO.setChgUtAmt("");
				}
					
				eventResponse.setRsVo(korDiscCYBondInfoVO);
				eventResponse.setETCData("err_msg","SUCCESS");
			}
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),	ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0332 : MULTI<br>
	 * KOREA WHF -BB CGO- Charge Rate 수정
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageWhfChgRt(Event e) throws EventException {
		ManifestListDownloadBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			List<BkgChgRateVO> listVO =  new ArrayList<BkgChgRateVO>();
			BkgChgRateVO bkgChgRateVO = new BkgChgRateVO();
			SurchargeAutoRatingBC surRatingBC = new SurchargeAutoRatingBCImpl();
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			
			BLDocumentationBLBC     blDocBlBC  	= new BLDocumentationBLBCImpl();
    		SpecialCargoReceiptBC   spclCgoBC  	= new SpecialCargoReceiptBCImpl();
    		BlRatingBC              blRatingBC	= new BlRatingBCImpl();
	    	BDRCorrectionBC         bdrBC      	= new BDRCorrectionBCImpl();
			GeneralBookingReceiptBC receiptBC  	= new GeneralBookingReceiptBCImpl();
			BLIssuanceBC            blIssBC    	= new BLIssuanceBCImpl();
			
			BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
			HistoryTableVO historyTableVO = new HistoryTableVO() ;
			
			com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masCmd  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();
			
			String uiId ="ESM_BKG_0333";
			String whfWave ="";
			String bkgNo ="";
			
			EsmBkg0332Event event = (EsmBkg0332Event) e;
			
			KorDiscCYBondInfoVO korDiscCYBondInfoVO = event.getKorDiscCYBondInfoVO();
			korDiscCYBondInfoVO.setUsrId(account.getUsr_id());
			
			command = new KorManifestListDownloadBCImpl();
			
			// Booking Creation > Charge tab > "BB"를 제외한 WHF 금액 list 찾기
			korDiscCYBondInfoVO.setWhfTp("BB"); // BB를 제외한 WHF 금액을 찾기 위해서 setting
			List<KorDiscCYBondInfoVO> list= command.searchWhfRateList(korDiscCYBondInfoVO);
			
			if(list.size()==1){
				begin();
				
				// bkg no setting
    			bkgBlNoVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
    			bkgBlNoVO.setBlNo(korDiscCYBondInfoVO.getBkgNo());
    			bkgBlNoVO.setBdrFlg(korDiscCYBondInfoVO.getBdrFlg());
    			bkgBlNoVO.setCaFlg("N");
                
    			// 1. C/A 이력을 insert한다.
    			if("Y".equals(korDiscCYBondInfoVO.getBdrFlg())){
					//auto c/a를 위한 BC, 해당 될때만 load한다.
					
					// 1st C/A History
	            	String strReturn  = "N";    		
	    			String copyTypeCd = "HIST000";
	    			
	    			strReturn = bdrBC.add1stCaHist(bkgBlNoVO, account);
	    			
	    			if ("N".equals(strReturn)) {
	    				bkgBlNoVO.setCaNo("0000000001");     				
	        			receiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);
	        			blDocBlBC.createBlCA     (bkgBlNoVO, copyTypeCd);
	        			spclCgoBC.createSpclCA   (bkgBlNoVO, copyTypeCd);
	        			blRatingBC.createRateCA  (bkgBlNoVO, copyTypeCd);
	        			blIssBC.createIssCA      (bkgBlNoVO, copyTypeCd);
	    			}	    			
	    			
    			}
    			
    			// 2. Auto C/A를 위해서  현재 테이블 값을 가져온다.
				historyTableVO = historyBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
				
				/////////////////////////////////////////////
				//3. Main Logic :: charge 테이블에서 BB Cgo의 WHF 금액 수정
				
				bkgChgRateVO.setBkgNo(korDiscCYBondInfoVO.getBkgNo());
				bkgChgRateVO.setRtSeq(korDiscCYBondInfoVO.getRtSeq()); //korRt.getRtSeq());
				
				bkgChgRateVO.setRatUtCd(korDiscCYBondInfoVO.getRatUtCd());
				bkgChgRateVO.setRatAsQty(korDiscCYBondInfoVO.getRatAsQty());
				bkgChgRateVO.setChgUtAmt(korDiscCYBondInfoVO.getChgUtAmt());
				bkgChgRateVO.setChgAmt(korDiscCYBondInfoVO.getChgAmt());
				bkgChgRateVO.setUpdUsrId(korDiscCYBondInfoVO.getUsrId());
				
				listVO.add(0,bkgChgRateVO);
				
				surRatingBC.modifyWhfChgRate(listVO);
				//////////////////////////////////////////////
								
				// 4. BDR Flg = Y 일경우, 실제 변경 c/a 처리
				if("Y".equals(korDiscCYBondInfoVO.getBdrFlg())){
					
					// WHF Wave 구하기 => C/A 사유에 넣기 위해서.
					korDiscCYBondInfoVO.setWhfWave("B");
					
					List<KorRateHeadVO> korRateHeadVOs = command.searchWhfWaveInfo(korDiscCYBondInfoVO);
					
					if(korRateHeadVOs.size() >0){
						KorRateHeadVO korRateHeadVO = korRateHeadVOs.get(0);
						whfWave = "KOREA Manifest- WHF : " + korRateHeadVO.getWhfWaveEng() + "(" + korRateHeadVO.getWhfWaveKor() + ")" ;
						
					}else{
						whfWave = "KOREA Manifest- WHF";
					}
					
	    			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
	            	bkgCorrectionVO.setBkgNo(bkgBlNoVO.getBkgNo());
	            	bkgCorrectionVO.setCaRsnCd("A");
	            	bkgCorrectionVO.setBkgCorrRmk(whfWave); // C/A remark부분 setting
	    			
	    			bdrBC.addAutoCaTemp(bkgBlNoVO, "KOREA_MANIFEST_WHF", bkgCorrectionVO, account);
					
	    			String tempHistCd = "H";
					String copyTypeCd = "HIST";
	
					// C/A createTempHist
					BkgBlNoVO corrBkgBlNoVO = bdrBC.createTempHist(bkgBlNoVO, tempHistCd, null, account);//corr no 채번됨    	
	    			
	    			receiptBC.createBookingCA	(corrBkgBlNoVO, copyTypeCd);    			
	    			blDocBlBC.createBlCA        (corrBkgBlNoVO, copyTypeCd);
	    			spclCgoBC.createSpclCA     	(corrBkgBlNoVO, copyTypeCd);    							
	    			blRatingBC.createRateCA     (corrBkgBlNoVO, copyTypeCd);    							
	    			blIssBC.createIssCA         (corrBkgBlNoVO, copyTypeCd);
	    			
					// C/A History Temp 삭제
					bdrBC.removeCATemp    		(bkgBlNoVO);				
					//blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);		

					historyTableVO.getBkgBlNoVO().setCaNo(corrBkgBlNoVO.getCaNo());
					
				}
				
				// 5. c/a일 경우 History: 맨처음 조회한 Previous 이미지와 변경된 tmp data와 비교하여 History를 만듬
				historyBC.manageBookingHistory(uiId, historyTableVO, account);   
    			
				
				// 6. MAS / Invoice interface
				bkgNo = korDiscCYBondInfoVO.getBkgNo();
				
				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(bkgNo);
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Manage Rate");
                masBkgComIfVo.setCreUsrId(account.getUsr_id());
                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);	
                  
                // Back End Job으로 호출 
                //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	            BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	            ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	            bkgIfVo.setBkgNo(bkgNo);
	            bkgIfVo.setManDivInd("B");
	            bkgIfVo.setUserId(account.getUsr_id());
	            bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
				
	            blRatingBC.distributeCntrRate(bkgNo, account);     
                // 6. End - MAS / Invoice interface
	            
				
				// 성공메시지 처리
				//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

				eventResponse.setETCData("err_msg","SUCCESS");
				log.error("KOREA WHF-BB CGO-Charge update: BKG NO.- " + korDiscCYBondInfoVO.getBkgNo());
				
				// 결과 처리
				commit();
				
			}else{
				// Rate쪽에 WHF 관련 삭제할 금액이 없다.
				//eventResponse.setUserMessage(new ErrorHandler("BKG06168").getUserMessage());
				eventResponse.setETCData("err_msg", "BKG06170&the WHF charge of BB Cargo");
			}


		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),	ex);
		}
		return eventResponse;
	}

	
	/**
	 * ESM_BKG_0371 :
	 * KOREA CUSTOMS : 신규 생성하는 MRN 에 대해서 동일 Vessel 로 등록된 MRN # 있는지 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchMrnDuplicated(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//KorCustomsTransmissionBCImpl command = null;
		CustomsTransmissionBC command = null;
		KorMrnCreateInfoVO korMrnCreateInfoVO = null;
		EsmBkg0371Event event = (EsmBkg0371Event) e;
		try {
			korMrnCreateInfoVO = event.getKorMrnCreateInfoVO();
			command = new KorCustomsTransmissionBCImpl();
			String result =  command.searchMrnDuplicated(korMrnCreateInfoVO);
			eventResponse.setETCData("mrnCheck", result);
			
	} catch (EventException ex) {
		throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		
	} catch (Exception ex) {
		throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
	}
	return eventResponse;
	}
	

	/**
	 * ESM_BKG_0347 : SEARCH<BR>
	 * ESM_BKG_0344 : SEARCH02<BR>
	 * RETRIVE Discharge Company ID 조회<BR>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDischCoList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0347Event event = (EsmBkg0347Event) e;
			command = new KorCustomsReportBCImpl();
			// 파라메터 객체
			KorDischCoCondVO korDischCoCondVO = event.getKorDischCoCondVO();
			// BC에 작업 요청
			KorDischCoVO[] korDischCoVOs = (KorDischCoVO[]) command
					.searchDischCoList(korDischCoCondVO);
			// 결과 처리
			if (korDischCoVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList((List<KorDischCoVO>) Arrays
						.asList(korDischCoVOs));
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
	 * ESM_BKG_0347 : MULTI <br>
	 * Discharging Company 추가/수정/삭제<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDischCoList(Event e) throws EventException {
		CustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			EsmBkg0347Event event = (EsmBkg0347Event) e;
			KorDischCoCondVO[] korDischCoCondVOs = event
					.getKorDischCoCondVOs();
			for (int i = 0; i < korDischCoCondVOs.length; i++)
				korDischCoCondVOs[i].setUsrId(account.getUsr_id());
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			begin();
			command.manageDischCoList(korDischCoCondVOs);
			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(),
					ex);
		}
		return eventResponse;
	}

	/* 2018.01.18 작업 Start - Ha DS */
	/**
	 * ESM_BKG_0994 : SEARCH <br>
	 * KOREA에서 입/출항 선박 신고 적하목록 전송 문서의 Ack 메세지 상세 내역 조회<br>
	 * 
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchRcvHistDtl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CustomsReportBC command = null;
		EsmBkg0994Event event = (EsmBkg0994Event) e;
		try {
			command = new KorCustomsReportBCImpl();
			// BC에 작업 요청
			List<KorRcvHistDtlVO> korRcvHistDtlVOs = (List<KorRcvHistDtlVO>) (Object) (command
					.searchReceiveLog((ReceiveLogCondVO) event.getKorRcvHistDtlCondVO()));
			// 결과 처리
			if (korRcvHistDtlVOs == null) {
				// 결과값이 없을 경우 오류 리턴
				eventResponse.setUserMessage(new ErrorHandler("BKG00889")
						.getUserMessage());
			} else {
				eventResponse.setRsVoList(korRcvHistDtlVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(),
					ex);
		}
		return eventResponse;
	}
	/* 2018.01.18 작업 End - Ha DS */

	
}// end class