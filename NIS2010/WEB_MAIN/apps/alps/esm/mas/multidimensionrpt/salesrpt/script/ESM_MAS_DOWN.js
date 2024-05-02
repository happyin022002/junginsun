/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0060.js
*@FileTitle : Inquiry by Customized Condition(점소 Weekly 비정형 실적 분석 RPT 조회1)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.01
*@LastModifier : 김기종 
*@LastVersion : 1.1
*=========================================================
* History
* 2008.02.22 박은주 N200802220016 MAS 조회 기간 관련 수정 요청
*                  2007년 7월 이전, 2007년 27주 이전 data 조회시 조회 불가 및 Error Message 보여줌
* 2008.02.15 박은주 N200801154874 주간 대상항차 기준 변경 관련 요청
*                  Year, Month, Week관련 화면변경
* 2008.02.28 박은주 N200802250022 MAS_RD 관련 수정 요청
*                  화면에 Excluding SOC 항목 추가
* 2008.03.21 박은주 N200802280015 MAS_Report 관련 수정 요청_1,2번항목
*                  2. Inquiry by Customized Condition[060]
*                  - Cost 수식 수정 : Cost = G.RPB + DEM/DET - CMB
*                  - C.S.REP 수정 (현재 L.REP 정보를 보여주고 있음)
*                  - L.REP 추가
*                  - CN CD + CUST CD에 해당하는 SHPR NM과 B/L SHPR NM으로 이원화
* 2008.03.21 박은주 R200803125390 P/L 화면 보완 요청_1,2번항목
*                  Week선택시에 Month, Week를 입력할수 있도록 변경[060,062,070]
* 2008.04.07 박은주 N200804020018 MAS Report 수정 요청
*                  1. Inquiry by Customized Condition
*                   - Pop-up 화면에 연결된 table 변경 : data 조회 가능하도록 변경
*                      (첨부파일 참조)
*                   - 화면 하단에 아래 메세지 수정 및 추가
*                      ▶ Please reset the report form - in the event that an error occurs.
*                      ▶ If you want to check all costs related to the booking, please include
*                          the BKG number when retrieving the data and double click it.
*                  2. Office Report vs QTA
*                   - 기간 표시 (타화면 참조)
*                  3. Inquiry by BKG
*                   - Cost Detail 조회시 TP/SZ를 선택하고 조회할 경우 Error 발생  : 수정 요망
* 2008.05.07 박은주 R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.06.30 박은주 N200806127354 MAS_조회권한 관련 요청
* 2008.08.29 박상희 N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060]
* 2009.02.04 김태윤 N200901210016 - MAS_조직개편 관련 기능 수정
* 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.03.24 배진환 N200903130001 - Key Account 조회 조건 변경
* 2009.04.03 김태윤 N200903170123 - MAS_Multi-dimension report 조회권한 변경, 디자인 수정
* 2009.05.18 배진환 N200905130071 - MAS_조회 조건 입력 관련 수정
* 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
* 2009.10.23 김기대 New FrameWork 적용
* 2009.12.03 윤진영 CHM-200901273 Inquiry by Customized Condition 검색조건 추가 및 라이크 검색 가능하도록 기능 변경
* 2010.01.15 윤진영 CHM-200901919 검색조건 년도와 주차를 선택했을 때 주차에 해당하는 조직도가 combo에 setting.
* 2010.02.01 윤진영 CHM-200901765 TAA_NO 추가
* 2010.02.22 이연각 업무처리중 버튼사용 금지 처리
* 2010.04.14 이중환 FormQueryString -> masFormQueryString 변경
* 2010.07.29 김기종 InitHeadMode ColumnMove 변경
* 2010.09.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.09.01 김기종 CSR No. CHM-201005370-01 Inquiry by customized condition 기능 개선
* 2010.09.08 이석준 [CHM-201005894-01] RPB,CMB total값 오류
* 2010.09.27 장영석 CSR No. CHM-201005937    Inquiry by customized condition 기능추가
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.04.15 최성민 [CHM-201110234-01] Key Account / Strategic Account Check Mark 추가하여, Key Account와 Strategic group에 
									  해당하는  BKG들만 모아서 모두 조회할 수 있는 기능추가
* 2011.06.01 최윤성 [CHM-201111117-01] Split 04-Split 03-ALPS Error 처리 요청 - 폼입력값에 대한 체크 로직 추가(Year, Mon, Week)
* 2011.06.22 김민아 [CHM-201111640-01] Reefer Core Account 조회조건 추가
*                                     - Combobox, Checkbox 추가 및 W/M, Week Display Event 발생시 로직 수정
* 2012.01.03 김성훈 [CHM-201114896-01] PROFIT LEVEL 선택 부분을 신규 코드로 변경 (CD02979로 변경 )
* 2012.04.19 김종준 [CHM-201217338-01] 리드 항목에 BKG_NO,BL_NO 존재시 검색조건중 Trade,Lane 필수 검색조건으로 변경
* 2012.04.26 전윤주  [CHM-201217584]   header 에 BKG_NO, BL_NO 존재 시 
*                                    Office Level을 Head Office로 했을때 :  Trade만 강제 선택, Lane은 선택할 필요 X 
                                     Office Level이 Head Office가 아닐경우 Office도 선택해야만 Trade Lane 조건 해제
                                                                          검색 기간 조건은 10주로 줄임 
* 2012.08.29 이석준[CHM-201219872]   Inquiry by customized condition_MT Pick up Location 등 메뉴 추가
* 2012.10.23 최성민 [CHM-201220825] [MAS] CAM 조직 변경에 따른 MAS 반영
* 2012.11.13  원종규 [CHM-201221335]	[MAS] Inquiry by customized condition 기능 관련: SELCDA일 경우 BKG_No 헤더 선택 시 제한 조건을 적용하지 않도록 변경
* 2013.01.11 서미진 [CHM-201322375] Period 조회시, 주차만 셋팅하여 default 값에 년도와 주차 pair가 맞지 않는 부분 수정
* 2013.01.21 성미영 [CHM-201322531] [MAS] Inquiry by Customized Condition 버튼 수정: GA, RA check Box 추가 
* 2013.05.29 김수정[CHM-201324876]   [MAS] MAS Report내 "IAS Region " / "Bound2" 추가
* 2013.07.01 최성민[CHM-201325476] [MAS] Inquiry by Customized Condition 검색 기간 변경
* 2014.01.15 김수정 [CHM-201428428] [MAS] Inquiry by Customized Condition 조회조건 제한
* 2015.08.31 손진환 [CHM-201536958] Split15-[그룹사 표준 코드 시행] SML 프로그램 대응 및 데이타 마이그레이션 작업 요청 
* 2016.01.26 김성욱 [CHM-201539636] Inquiry by Customized Condition Rating date 구분자 개발 검토 요청
* 2016.03.02 김성욱 xxx Inquiry by Customized Condition 검색시 제약 조건 추가(out of memory 발생, TPS선택시 Sub Trade 선택 필수, month:1M, Week:4W, Result Title:30개)
===========================================================================================================*/

/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/
/**
 * @extends
 * @class ESM_MAS_0060 : ESM_MAS_0060 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
function ESM_MAS_DOWN() {
    this.loadPage = loadPage;
}


/**
 * =========================================================
 * History

 * =========================================================
 **/
// 공통전역변수

    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage(title, col_nm) {    	 
               
    }
