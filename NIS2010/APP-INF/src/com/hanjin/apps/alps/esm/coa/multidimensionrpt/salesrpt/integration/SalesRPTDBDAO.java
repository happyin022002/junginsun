/*=========================================================
*Copyright(c) 2006 CyberLogitec
 *@FileName : SalesRPTDBDAO.java
 *@FileTitle : SalesRPTDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 2006-11-09 Sangwook_nam
 * 1.0 최초 생성
 * =========================================================
 * History
 * 2008.01.03 박은주 N200712280005 COA Report Error 수정 요청
 *                  1. Inquiry by Lane : TP/SZ 선택 후 SP2, SP4 조회 시 오류[060]
 *                  2. Inquiry by BKG : SP2, SP4의 GRPB, CMPB 계산 오류[061]
 *                  4. 각 Report를 새창에서 열 경우, 위에 보이는 Title을 Menu명과 동일하게 변경 요청
 * 2008.01.09 박은주 N200801070002 COA 2007년 Contract QTA 관련
 *                   COA내 2007년 Contract QTA가 0으로 나오도록 조치 바랍니다.[070]
 * 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청 
 *                   Month로 조회시 Cost_yrmon, Week 조회시 Sls_yrmon 으로 조회되도록 쿼리문 수정[060,062,070,071,078,147,148]
 *                   080,081,082 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
 * 2008.02.28 전윤주 N200801154876
 *                   063, 0632, 065, 067, 0672 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
 * 2008.02.28 박은주 N200802250022 COA_RD 관련 수정 요청 
 *                   화면에서 Excluding SOC Flag 체크시 SOC가 Y가 아닌것만 조회하도록 쿼리문 수정[060,062] 
 * 2008.03.07 박은주 N200802260011 STP Income 화면 수정 요청 
 *                   화면에 Income/Cost 각각을 선택적으로 볼수 있는 옵션 추가 및 VVD 항차별로 조회할수 있도록 검색조건추가[135] 
 * 2008.03.21 박은주 N200802280015 COA_Report 관련 수정 요청_1,2번항목  
 *                1. Monthly Average U/C[057] 
 *                - RA 기준 추가, Term 조건 추가
 *                - Sheet 각각에 Total 값추가
 *                - Profit Level을 OP를 선택했을때 OP항목에 해당하는 컬럼을 보여줌(동적으로)
 *                2. Inquiry by Customized Condition[060] 
 *                - Cost 수식 수정 : Cost = G.RPB + DEM/DET - CMB
 *                - C.S.REP 수정 (현재 L.REP 정보를 보여주고 있음)
 *                - L.REP 추가
 *                - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화
 * 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목  
 *                   Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
 * 2008.03.28 전성진 N200803240003 물류레포트에 Sale Vol.,Inland Vol. 추가 [081]
 * 					 Week 조회시 월 조건 추가[080, 081, 082]              
 * 2008.04.03 전성진 N200803310003 물류레포트 파일 분리      
 * 2008.04.04 박은주 N200803240008 COA Report 관련 수정(Daily BKG Creation 화면)[078]
 *                1. Sales Office 선택시, 최대 7일 검색 가능하나
 *                   월이 변경될 경우 7일 이상으로 인식
 *                   ex) 2008-1-30~20088-2-1 으로 조회시,
 *                        7일 이상 불가 메세지가 보임
 *                2. BKG CNFM Only -> Firm BKG Only로 표기 변경
 *                3. Branch View 오류 수정
 *                 - 조회 해당 Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
 *                   ex) A Office 조회시, 해당 기간 동안 생성된 BKG 중
 *                       Contract Office<>A & Conduct Office = A BKG에 대하여 발생한
 *                       A Office의 STP Revenue 및 Oth Activity Cost, Net STP Income
 *                4. S.Rep Option 추가 (첨부파일 참조 바람)　
 *                 - S.Rep 입력란 삽입  
 *                 - Office View가 Contract 일 경우, S.Rep을 Contract S.Rep 정보와 연결하여 해당 Data 보여줌
 *                   Office View가 Loading 일 경우, S.Rep을 Loading S.Rep 정보와 연결하여 해당 Data 보여줌
 *                5. Data Grid 에 아래항목 추가
 *                 - Trade/Lane/BD/VVD/ Office / S.REP code/ Customer(shipper)....
 *                 : Trade/Lane/BD/VVD, S.REP Code, Shipper를 각 check option으로
 *                  (첨부파일 참조 바람)
 *                6. Branch View 위치 변경 (아래쪽) 및 버튼 누를 경우 data 볼 수 있도록 수정
 *                7. 기타 : File Download 시 Item 명 중 CM 아래 공란 삭제, BKG No를 한 칸으로해서 Split 까지 함께 기재
 *               = 추가 요청사항 =
 *               1. CM Cost가 맞지 않는다.
 *               2. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 Open시에 자동 조회 되도록 요청
 *               3. BKG가 있을경우 Double Click 시 Inquiry by BKG 화면 조회시 검색 조건 Profit View, Level도 넣어 줌
 *               4. Inquiry by Customized Condition의 Remark처럼 하단에 Remark 처리 요청
 *                  "If you want to check all costs related to the BKG, 
 *                   please mark on the "BKG Display" when retrieving the data and double click the BKG No."
 *               5. Branch View의 그리드의 타이틀 중  "Oth Vol Activity" 를 "Oth Vol Activity Cost" 로 변경 요청
 *               6. Branch View에 나오는 Office랑  S.Rep은 항상 Contract Office랑 Contract S.Rep이죠?
 *                  그럼 Contract Office랑 C.S.Rep으로 바꿔 주실수 있으세요?
 * 2008.04.07 박은주 N200804020018 COA Report 수정 요청  
 *                1. Inquiry by Customized Condition
 *                 - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
 *                    (첨부파일 참조)　
 *                 - 화면 하단에 아래 메세지 수정 및 추가
 *                    ▶ Please reset the report form - in the event that an error occurs.
 *                    ▶ If you want to check all costs related to the booking, please include 
 *                        the BKG number when retrieving the data and double click it.
 *                2. Office Report vs QTA
 *                 - 기간 표시 (타화면 참조)
 *                3. Inquiry by BKG
 *                 - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망    
 * 2008.04.18 박은주 N200804160003_QTA 검색 관련 보완 요청[070]
 *                SAQ의 정보를 가져올때 년도는 SLS_YRMON을 사용하고 분기 정보는 SAQ 중 최근 분기 정보를 가져오도록 수정
 * 2008.05.13 박은주 N200805070003 COA_조회권한 관련 & Customized Condition 오류 수정 요청
 *                B/L No 뒷 자리가 잘려서 나오는 오류 수정
 *                loop안에서 RS 관련 closing 처리               
 * 2008.05.30 박은주 N200805260011 COA Report REV 산출 수정 요청
 *                1) Rev에 해당하는 Data 확인 : Ocean Freight 계정 + 기타 Rev 계정 (현재 Misc OPR Rev로 산출되는 수입계정 제외)
 *                2) RPB 산출시 Misc OPR Rev 계정 제외
 *                3) CM 산출식 확인 : Rev(OFT + 기타Rev) + Misc OPR Rev + Dem/Det - Cost1(각 Profit View별)
 *                4) 대상 Report : P/L by Lane을 제외한 모든 화면 (COA live source와 연결되어 있는 모든 화면이 대상입니다.)
 *                   - Inquiry by customized condition[060]
 *                     - popup : Inquiry by BKG[131] 
 *                   - Inquiry by lane[062]
 *                     - popup : Inquiry by BKG[079]
 *                     - popup : Route Detail Inquiry[147]
 *                     - popup : BKG Detail Inquiry[148]
 *                   - Inquiry by BKG[061]
 *                   - Office report by QTA[070]
 *                   - Office report by graph[071]
 *                   - Office report by daily BKG creation[078]
 * 2008.06.03 박은주 N200805300001 COA_화면 개발 및 수정[Inquiry by BKG(ABC/STP) 화면개발] 
 * 2008.06.10 박은주 N200805307020 Split 01-COA_화면 개발 및 수정[070] 
 * 2008.06.16 박은주 N200805307021 Split 02-COA_화면 개발 및 수정[156] 
 * 2008.06.24 박은주 N200806120005 COA_Report 조회 오류[061] 
 * 2008.06.30 박은주 N200806127354 COA_조회권한 관련 요청[060,070,071,078]
 *            박칠서 N200806120004 COA_조회권한 관련 요청[072]
 *            박상희 N200806127354 COA_조회권한 관련 요청[062]
 *                                 coa_bkg_svc_trns_smry 테이블의 컬럼 변경으로 인해 소스 수정(oth_prc_amt->otr_prc_amt) 
 * 2008.07.01 박은주 N200807077840 Office 조직 변경으로 인해 소스 변경  
 * 2008.07.15 박상희 N200806277654 Office-Report by Daily BKG Creation Report 관련 수정
 *                1) S/C No, RFA No 조회조건 추가
 *                2) Check Box 사용하여 Field 추가
 *                   - Route : BKG POR, BKG POL, BKG POD, BKG DEL
 *                   - CMDT : CMDT, CMDT NM
 *                   - SC/RFA : S/C No, RFA No
 *                3) Office View에 따라 Field 이름이 다르게 보이도록 수정
 *                   - Contract View : C.Office, C.S.Rep
 *                   - Loading View : L.Office, L.Rep
 * 2008.08.29 박은주 N200807290002 Expense Detail로 테이블 변경하면서 화면단 모두 변경[035,070]                          
 * 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060,062,070,071]  
 * 2008.09.08 박상희 N200808210017 Trade, Sub-Trade, Lane 옵션추가함[071]    
 * 2008.09.11 전윤주 R200809109312 office, VVD 선택했을 때 VVD 모두 보여줘서 null office 보이던 현상 쿼리 수정 [070]  
 * 2008.09.16 박상희 R200809109313 저장된 RPT form 사용 가능하도록 수정 [060]  
 * 2008.09.16 박상희 N200809029096 Inquiry by BKG (ABC/STP) : split bkg에 ratio 적용[156]
 * 2008.09.16 박은주 N200809020007 Inquiry by BKG (ABC/STP) : split bkg에 ratio 적용[156]
 * 2008.09.24 전윤주 N200808260005 Inquiry by BKG : Route 두줄씩 나오는 현상 수정 [060] searchBkgInfo,searchBKG061List
 * 2008.09.24 김태윤 N200808278919 Inquiry by BKG : Route 두줄씩 나오는 현상 수정 [060] searchBkgInfo,searchBKG061List
 * 2008.09.26 전윤주 N200808260005 Inquiry by BKG : 같은 항목 반복 오류 수정 [061]
 *                                 Inquiry by BKG (ABC/STP) : 년/월 항목추가 [156]
 * 2008.10.10 박칠서 N200808190003 Special CNTR 분리운영 [057,060,062,061,156,035,147,148]
 * 2008.10.10 전윤주 N200808228858 Special CNTR 분리운영 [057,060,062,061,156,035,147,148]
 * 2008.10.10 박은주 N200808228860 Special CNTR 분리운영 [057,060,062,061,156,035,147,148]
 * 2008.10.10 김태윤 N200808228857 Special CNTR 분리운영 [057,060,062,061,156,035,147,148]
 * 2008.10.10 박상희 N200808228859 Special CNTR 분리운영 [057,060,062,061,156,035,147,148]
				 					 - F(Flat Rack)  : F2 (A2, F2),  F4 (A4, F4, F5)
				 					 - O(Open Top)   : O2 (O2, S2), O4 (O4,S4)
				 					 - T(Tank)       : T2, T4
 *                                 Shipper 검색조건으로 조회가 가능하도록 수정		
 * 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]	
 * 2008.10.21 전윤주 N200810200014 REV MT	, DG, BB, AK 항목 추가 [035,060] 	
 * 2008.10.21 박상희 N200810200009 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [078]		
 * 2008.11.11 박상희 N200810310016 ABC/STP 배부기준 월별 관리 [157]	 
 * 2008.11.14 박상희 N200811140011 COA_Office Report vs QTA 내 STP 및 Branch CM/OP 관련컬럼 Null 처리 [070]
 * 2008.11.19 전윤주 N200811060003 COA_Report 기능 개선(2) Customized Condition Weght 추가 [060]
 *                                                       vs QTA Week display 추가 [070]
 * 2008.11.24 박상희 N200811060006 week display : Lane(062), Weight 추가 : Source Data(035), Inq by BKG(061) 
 * 2008.11.28 박상희 R200811270006 Inquiry by Lane 쿼리 튜닝 : coa_bkg_expn_dtl,coa_mon_vvd 테이블을 hash조인 처리 [062]
 * 2008.12.04 박상희 N200811270017 Inq by BKG 에서 All일경우, Cost Detail 조인조건 수정 [searchBKG061List3]
 * 2008.12.05 박상희 N200811270017 Inq by Source Data - TP/SZ 파일 다운로드 수정 [searchInqSrcDtTpsz035List]
 * 2008.12.15 박상희 N200811270017 COA_Office Report vs QTA 내 STP 관련 소스 수정[070]
 * 2008.12.15 전윤주 N200811270016 COA_Office Report vs QTA 내 STP 관련 소스 수정[070]
 * 2008.12.15 박은주 N200811270013 COA_Office Report vs QTA 내 STP 관련 소스 수정[070]
 * 2008.12.15 박상희/전윤주  N200811270018, N200811270019 COA_BKG CM 기준 변경
 * 2008.12.16 박상희 N200811270017 Inquiry by SourceData : STP Cost 를 Other-vol activity cost로 변경[035]
 * 2008.12.17 박상희 N200812100006 COA_Inquiry by BKG 화면 수정 : R.Mon/S.Mon 모두 보여줌[BKG정보], Misc OP Rev 항목 추가[sheet2]
 * 2008.12.17 전윤주 N200812090017 COA_Inquiry by BKG 화면 수정 : R.Mon/S.Mon 모두 보여줌[BKG정보], Misc OP Rev 항목 추가[sheet2]
 * 2008.12.22 전윤주 N200812230008 조직체계 변경 관련 조회 기능 개선 : COA Office 월별관리 후 table 수정 (COA_OFC_LVL), coa_mon_vvd 와 조건 추가
 *                                 Office Report vs QTA 화면 월/주 조회에 따라 cost_yrmon/sls_yrmon 사용하도록 변경.[070] 
 * 2009.01.07 전윤주 N200901070017 Office Report vs QTA 화면 속도개선[070]
 * 2009.01.07 박상희 N200901070020 Office Report vs QTA 화면 속도개선[070]
 * 2009.02.03 박상희 N200901210013 Office구조 변경 관련 적용 [070]
 * 2009.02.04 김태윤 N200901190016 COA_조직개편 관련 기능 수정 [060], [062], [078], [071], [147]
 * 2009.02.06 전윤주 N200901210015 COA_조직개편 관련 기능 수정 (ofc_lvl 테이블에 걸리는 join 조건 cost_yrmon, sls_yrmon 관련 수정)
 * 2009.02.09 임옥영 N200901190016 조직개편 적용후 쿼리 튜닝
 * 2009.02.12 임옥영 N200902110080 SINWA 실적 조회 권한 관련
 * 2009.02.12 박상희 N200902050040 Reefer PFMC & QTA만 조회하는 Option 추가[070]
 * 2009.03.10 임옥영 N200903040140 COA Cost Detail 화면 수정 및 추가 요청 [170]
 * 2009.03.10 김태윤 N200903040144 COA Cost Detail 화면 수정 및 추가 요청 [170]
 * 2009.03.20 김태윤 N200903190090 COA Cost Detail 화면 해당 route의 비용만 표시 [170]
 * 2009.03.30 박은주 N200903200150,N200903230001: COA_Q2, Q4 : CGO Flag 관련_searchInqByCondition060List[060]
 * 2009.03.24 배진환 N200903130001 Key Accont Group 추가 
 * 2009.04.02 임옥영 N200903120100 COA_Multi-dimension report 조회권한 변경 searchInqByLane062List[062]
 * 2009.04.03 김태윤 N200903170123 COA_Multi-dimension report 조회권한 변경, 디자인 수정 [060] [147] 
 * 2009.04.03 배진환 N200903170122 COA_Multi-dimension report 조회권한 변경, 디자인 수정 [148]
 * 2009.04.22 배진환 N200904070095 Split 04-COA_CM 계산 수식 변경 searchBKG061List2 [061]
 * 2009.04.24 박상희 N200904070094 CM 계산수식 변경 
 * 2009.04.28 박상희 N200904160100 CM 계산수식 변경(060,062)
 * 2009.04.30 박상희 N200904160100 Report Item 변경 및 추가(035) 
 * 2009.05.06 박상희 N200904160100 Report Item 변경 및 추가 보완(035) 
 * 2009.05.08 박상희 N200904170011 Report Item 추가(2) (060,062,147,148) 및 CM 수식변경 보완(expn_dtl_prc 수정후)
 * 2009.05.14 박상희 N200904160100 OP COST, OP 추가 [035], Lane 화면의 bound disp. 또는 wk disp. 체크시 팝업에도 적용[147][148] 
 *                                 searchInqByCondition060List[060] 쿼리수정
 * 2009.05.19 박수훈 N200905060131 Ctrt/Avg가 L일 경우 'Actual'로 표시하는 쿼리 수정 [170]
 *                                 A/G 이 'NOBC', 'NIBC' 이고 TMFDFL 인 경우 화면에서 보여줄 때 'TMFDMT' 계정으로 보여주게 수정 [170]                   
 * 2009.05.28 임옥영 N200905270030 COA_BL Type 관련 예외 처리
                                   BL No가 KOSA로 시작하는 BKG에coa_rgst_BKGBKG_INFO테이블에 BL_NO_TP = 'M'으로 처리해서 넣어주고
                                   Inquiry by Source Data, Inquiry by Customised Condition의 BL NO를 bl_no+bl_no_tp+bl_no_chk-->K+BKG_NO로 변경
 * 2009.09.08 송호진 Inquiry By BKG ALPS F/W 적용
 * 2009.09.15 송호진 Inquiry By LANE ALPS F/W 적용 - Route, BKG, Cost Detail ( 0147,0148,0149 포함 )
 * 2009.09.07 김기대 0060, 0059 ALPS F/W 적용
 * 2009.09.29 김기식   New FrameWork 적용 [0070, 0035, 0071, 0156]
 * 2009.      윤진영 CHM-200900390 Profit View가 Office Profit[R]이거나 Trade Profit에 Office Level 1 일경우만  QTA정보를 조회한다.
 * 2009.      윤진영 CHM-200901273 Inquiry by Customized Condition 검색조건 추가 및 라이크 검색 가능하도록 기능 변경
 * 2010.01.11 이행지 CHM-200901045 Trade profit - OP 선택 시 OP 계정이 CM에 계산 되어 반영 되는 부분  쿼리수정 [061]- SalesRPTDBDAOsearchBkg0061List2RSQL.Query
 * 2010.01.11 이행지 CHM-200901296 소수점 아래 제한이 없을 경우 IBsheet에서 calculogic 계산 시 작은 소수는 10의 제곱형태로 바꾸어서 처리하다가
 *                                error 남. SQL 에 ROUND 처리하여 소수점 5자리로 제한[070] - SalesRPTDBDAOSearchRPTbyOfc070List11RSQL.Query
 * 2010.02.04 임옥영 :품질검토결과 반영
 * 2012.12.18 최윤성 [CHM-201222075-01] [COA] Account별 QTA 조회 기능 추가 
 * 2014.05.13 최성민 [CHM-201429994] [COA] Office Report vs QTA 화면 항목 추가 (IAS Sector Sales)
=========================================================*/
package com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.coa.common.vo.CommonCoaRsVO;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.basic.SalesRPTBCImpl;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BKGDetail0148VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.BkgRpt0061VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.InqByLane0062VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.MultiSetForm059SeqVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.RouteDetail0147VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesOffiRepoConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchBkgRmk0170ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchDailyBKGView0078ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchDailyBranchView0078ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgConditionVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchMonthlyAvgUC0057ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchRptItemVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059List2VO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchSetForm059ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.SearchStpInOut0135ListVO;
import com.hanjin.apps.alps.esm.coa.multidimensionrpt.salesrpt.vo.ShipperVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;



/**
 * ALPS SalesRPTDBDAO <br>
 * - ALPS-MultiDimensionRPT system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author NAMKOONG Jin Ho
 * @see SalesRPTBCImpl 참조
 * @since J2EE 1.6
 */
public class SalesRPTDBDAO extends DBDAOSupport {
	
	
	/**
	 * 데이타 모델에 해당되는 값을 불러온다.<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCntrTpSzList(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		try{			
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchCntrTpSzListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * 데이타 모델에 해당되는 값을 불러온다.(Account 조회)<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param SalesOffiRepoConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInqSrcDtAcct0035List(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);					
				
				velParam.put("allcols", cols); // 가변컬럼				
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqSrcDtAcct0035ListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 데이타 모델에 해당되는 값을 불러온다.(Type Size 조회)<br>
	 * - 사용 프로그램 : ESM_COA_0035
	 *
	 * @param SalesOffiRepoConditionVO vo
	 * @param List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInqSrcDtTpsz0035List(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);		
				
				//header 변수 세팅				
				velParam.put("allcols", cols);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqSrcDtTpsz0035ListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_COA_0057화면에 대한 조회 이벤트 처리<br>
	 * sheet1<br>
	 * 
	 * @param  SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057ListVO>
	 * @throws DAOException
	 */
	public List<SearchMonthlyAvgUC0057ListVO> searchMonthlyAvgUC0057List(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAvgUC0057ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMonthlyAvgConditionVO != null){
				Map<String, String> mapVO = searchMonthlyAvgConditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchMonthlyAvgUC0057ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAvgUC0057ListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	 /**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param  SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO
	 * @return List<SearchMonthlyAvgUC0057List2VO>
	 * @throws DAOException
	 */
	public List<SearchMonthlyAvgUC0057List2VO> searchMonthlyAvgUC0057List2(SearchMonthlyAvgConditionVO searchMonthlyAvgConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchMonthlyAvgUC0057List2VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchMonthlyAvgConditionVO != null){
				Map<String, String> mapVO = searchMonthlyAvgConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchMonthlyAvgUC0057List2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyAvgUC0057List2VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	 
		/**
		 * searchBkgRemarkList 조회<br>
		 * 
		 * @param SearchConditionVO vo
		 * @return List<SearchBkgRmk0170ListVO>
		 * @throws DAOException
		 */
		public List<SearchBkgRmk0170ListVO> searchBkgRemarkList(SearchConditionVO vo) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchBkgRmk0170ListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(vo != null){
					Map<String, String> mapVO = vo.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDDAOSearchBkgRmk0170ListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgRmk0170ListVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}		 
	 
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BkgRpt0061VO>
	 * @throws DAOException
	 */
	public List<BkgRpt0061VO> searchBKG0061List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRpt0061VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRpt0061VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * Inquiry By BKG 레포트의 두번째  SHEET 내용 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param String pHeader
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBKG0061List2(SearchConditionVO searchConditionVO, String pHeader ) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String tmpStr = pHeader;
		        if(tmpStr.equals("")) tmpStr = " | ";
		        String[] header = tmpStr.split("[|]");

		        List<String> tpsz = new ArrayList(); 
				for(int i = 0; i < header.length; i++){   
					tpsz.add(header[i]);   
				}   
				velParam.put("f_tpsz", tpsz);				
 			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061List2RSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
			commonCoaRsVO.setHeader(pHeader);
			commonCoaRsVO.setEventName("GS2");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	/**
	 * Inquiry By BKG Report의 Sheet3 조회<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchBKG0061List3(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchBkg0061List3RSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
			commonCoaRsVO.setEventName("GS3");

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	/**
	 *coa_rpt_itm_info_dtl 목록을 가져온다.<br>
	 * 
	 * @param  SearchConditionVO searchConditionVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRptItem3(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchRptItem3RSQL(), param, velParam);

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
    /**
     * COA_BSA_CRR_RGST 목록을 가져온다.<br>
     *  
     *
     * @param SalesRPTCommonVO vo
     * @see SalesRPTBCImpl
     * @return List<SearchSetForm059ListVO>
     * @throws DAOException
     */		
    public List<SearchSetForm059ListVO> searchSetForm059List(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSetForm059ListVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchSetForm059ListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSetForm059ListVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	

	/**
	 * COA_BSA_CRR_RGST 목록을 가져온다.<br>
	 * 
	 * @사용프로그램 ESM_COA_059
	 * 
     * @param SalesRPTCommonVO vo
     * @see SalesRPTBCImpl
     * @return List<SearchSetForm059List2VO>
	 * @throws DAOException
	 */
    public List<SearchSetForm059List2VO> searchSetForm059List2(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchSetForm059List2VO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchSetForm059List2RSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSetForm059List2VO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	
	

	/**
	 * COA_RPT_ITM_INFO_MST, COA_RPT_ITM_INFO_DTL의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return List<MultiSetForm059SeqVO>
	 * @throws DAOException
	 */
    public List<MultiSetForm059SeqVO> multiSetForm059Seq(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<MultiSetForm059SeqVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059SeqRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiSetForm059SeqVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }
    
    /**
	 * Set Customerized RPT Form에서 Multi처리한다. <BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RegistMaster(SalesRPTCommonVO vo) throws DAOException {
        int insCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RegistMasterCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
    
    /**
	 * Set Customerized RPT Form에서 Multi 수정처리한다. <BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059ModifyMaster(SalesRPTCommonVO vo) throws DAOException {
        int updCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");

            if(vo.getMultiUpdateList() != null && vo.getMultiUpdateList().size() > 0){
            	updCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059ModifyMasterUSQL(), vo.getMultiUpdateList(), null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	    
    
    /**
	 * Set Customerized RPT Form에서 detail화면이다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RegistDetail(SalesRPTCommonVO vo) throws DAOException {
        int insCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiCreateList() != null && vo.getMultiCreateList().size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RegistDetailCSQL(), vo.getMultiCreateList(), null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }             
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
    
    /**
	 * Set Customerized RPT Form에서 MASTER 삭제처리한다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RemoveMaster(SalesRPTCommonVO vo) throws DAOException {
        int delCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RemoveMasterDSQL(), vo.getMultiDeleteList(), null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
    
    /**
	 * Set Customerized RPT Form에서 DETAIL 삭제처리한다.<BR>
	 * 
	 * @param  SalesRPTCommonVO vo
	 * @throws DAOException
	 */
    public void multiSetForm059RemoveDetail(SalesRPTCommonVO vo) throws DAOException {
        int delCnt[] = null;

        try{
            SQLExecuter sqlExe = new SQLExecuter("");   
            
            if(vo.getMultiDeleteList() != null && vo.getMultiDeleteList().size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new SalesRPTDBDAOMultiSetForm059RemoveDetailDSQL(), vo.getMultiDeleteList(), vo.getIndirectVelocityParameter());
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to delete No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
        	log.error("err "+se.toString(),se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
        	log.error("err "+ex.toString(),ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }	
    
	
	/**
	 * COA_SPCL_REPO_CNTR_RGST의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 입력, 수정,삭제 작업은 COA_SPCL_REPO_CNTR_RGST테이블에서 일어난다. <BR>
	 * 
	 * @param SalesRPTCommonVO vo
	 * @return SalesRPTCommonVO
	 * @throws DAOException
	 */
    public SalesRPTCommonVO searchInqByCondition060List(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        SalesRPTCommonVO retVo = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchInqByCondition060ListRSQL(), vo.getIndirectQueryParameter(), vo.getIndirectVelocityParameter());
            retVo = new SalesRPTCommonVO();
            retVo.setRowSet(dbRowset);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return retVo;
    }	
    
    /**
     * coa_rpt_itm_info_dtl 목록을 가져온다.<br>
     *  - List 타입의 View Adapter용 조회
     *
     * @param SalesRPTCommonVO vo
     * @see SearchRptBCImpl
     * @return List<SearchRptItemVO>
     * @throws DAOException
     */
    public List<SearchRptItemVO> searchRptItem(SalesRPTCommonVO vo) throws DAOException {
        DBRowSet dbRowset = null;
        List<SearchRptItemVO> list = null;
        try{
            if(vo == null) return null;
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRptItemRSQL(), vo.getIndirectQueryParameter(), null);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRptItemVO.class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
        	log.error("err "+se.toString(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
        	log.error("err "+ex.toString(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }	    

	/**
	 * Inquiry By Lane 화면의 첫번째  Sheet 조회.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<InqByLane0062VO>
	 * @throws DAOException
	 */
	public List<InqByLane0062VO> searchInqByLane0062List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InqByLane0062VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchInqByLane0062ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InqByLane0062VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 *MDM COSTOMER 테이블에서 Customer 정보 조회<br>
	 * 
	 * @param  SearchConditionVO searchConditionVO
	 * @return List<ShipperVO>
	 * @throws DAOException
	 */
	public List<ShipperVO> searchShipperList(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ShipperVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOsearchShipperListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ShipperVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 62번에서 콜됨 Route Detail Inquiry
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<RouteDetail0147VO>
	 * @throws DAOException
	 */
	public List<RouteDetail0147VO> searchRouteDetail0147List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RouteDetail0147VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRouteDetail0147ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RouteDetail0147VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<BKGDetail0148VO>
	 * @throws DAOException
	 */
	public List<BKGDetail0148VO> searchBKGDetail0148List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGDetail0148VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBKGDetail0148ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGDetail0148VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * MultiDimension의 모든 목록을 가져온다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return CommonCoaRsVO
	 * @throws DAOException
	 */
	public CommonCoaRsVO searchCostDetail0149List(SearchConditionVO searchConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonCoaRsVO commonCoaRsVO = new CommonCoaRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchConditionVO != null){
				Map<String, String> mapVO = searchConditionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchCostDetail0149ListRSQL(), param, velParam);
			commonCoaRsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonCoaRsVO;
	}
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */	
	public DBRowSet searchRPTbyOfc0070List11(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List11RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRPTbyOfc070List11VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRPTbyOfc0070List12(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List12RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRPTbyOfc070List12VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	

	/**
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRPTbyOfc0070IASSectorList(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List12_2014RSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRPTbyOfc0070List13(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc070List13RSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRPTbyOfc070List12VO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * EMS_COA_0135 팝업의 모든 목록을 가져온다.<br>
	 * sheet1<br>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return List<SearchStpInOut0135ListVO>
	 * @throws DAOException
	 */
	public List<SearchStpInOut0135ListVO> searchStpInOut0135List(SalesOffiRepoConditionVO vo) throws DAOException {
		List<SearchStpInOut0135ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchStpInOut0135ListRSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchStpInOut0135ListVO .class);
			list = new ArrayList<SearchStpInOut0135ListVO>();
		/*} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());*/
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * COA_SPCL_REPO_CNTR_RGST의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 입력, 수정,삭제 작업은 COA_SPCL_REPO_CNTR_RGST테이블에서 일어난다. <BR>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @throws DAOException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBKGView0078List(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyBKGView0078ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchDailyBKGView0078ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyBKGView0078ListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * COA_SPCL_REPO_CNTR_RGST의 여러 데이타 모델을 <BR>
	 * 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<BR>
	 * 입력, 수정,삭제 작업은 COA_SPCL_REPO_CNTR_RGST테이블에서 일어난다. <BR>
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return List<SearchDailyBKGView0078ListVO>
	 * @see ESM_COA_001Event
	 * @throws DAOException
	 */
	public List<SearchDailyBKGView0078ListVO> searchDailyBranchView0078List(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchDailyBKGView0078ListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchDailyBranchView0078ListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchDailyBranchView0078ListVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 목록을 조회한다.
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRPTbyOfc0071List(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("COA_HJSBAT").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchRPTbyOfc0071ListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * BKG에 대한 ABCSTP 정보를 조회한다.Sheet3<br> - 사용 프로그램 : ESM_COA_0156
	 * 
	 * @param SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgAbcstp0156List(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBkgAbcstp0156ListRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	
	/**
	 * BKG에 대한 정보를 조회한다.Sheet1<br> - 사용 프로그램 : ESM_COA_156
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgInfo(SalesOffiRepoConditionVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBkgInfoRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * BKG에 대한 Type Size별  Load, Revenue를 조회한다.Sheet2<br> - 사용 프로그램 : ESM_COA_156
	 * 
	 * @param  SalesOffiRepoConditionVO vo
	 * @param  List<String> cols
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchBkgLoadRev(SalesOffiRepoConditionVO vo, List<String> cols) throws DAOException {
		DBRowSet dbRowset = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{			
			Map<String, String> mapVO = vo.getColumnValues();				
			param.putAll(mapVO);
			velParam.putAll(mapVO);	
						
			// 가변컬럼세팅			
			velParam.put("allcols", cols);			
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOSearchBkgLoadRevRSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	/**
	 * 삭제된 BKG정보인지 확인<br> - 사용 프로그램 : ESM_COA_0061
	 * -- COA_RGST_BKG, BKG_BOOKING	테이블을 조인걸어 없거나 삭제된 부킹일 경우 TRUE로 RETURN한다.
	 * 
	 * @param  String bkg_no
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isDeletedBooking(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		boolean isDeleted = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("bkg_no",bkg_no);		
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SalesRPTDBDAOIsDeleteBookingRSQL(), param, null);
			
			if(dbRowset.getRowCount() == 0){
				isDeleted = true;
			}
			while (dbRowset.next()) {
				if ("X".equals(dbRowset.getString("bkg_sts_cd")))
					isDeleted = true;
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isDeleted;
	}	
}

