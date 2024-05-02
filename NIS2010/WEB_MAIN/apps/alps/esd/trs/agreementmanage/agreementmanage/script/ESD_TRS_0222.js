/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0222.js
*@FileTitle : Agreement Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2011-03-02
*@LastModifier : 민정호
*@LastVersion : 1.3
* 2010-03-18 cjh
* 1.0 최초 생성
*----------------------------------------------------------
* History
* 2010.09.13 최종혁   1.1 [CHM-201005934] [TRS] AGMT Verification Error 내용 table 추가 요청
* 2011.01.11 민정호   1.2 [CHM-201108253] [TRS] AGMT 상 rate, ratio 입력시 표기 가능한 소수점 자리수 변경 요청 
* 2011.03.02 민정호   1.3 [CHM-201109066] [TRS] AGMT verify rule 항목 추가요청 
* 2011.05.06 손은주   1.4 [CHM-201109770-01][TRS] MEXBB 에서 처리되는 Rail S/O 에 대한 exception logic 적용가능성 검토요청 (US Rail surcharge 기능 연계)
* 2011.06.24 황효근   1.5 [CHM-201111442] [TRS] R9 CNTR 추가관련 로직 변경요청
=========================================================*/

/**
 * 시트 초기설정값, 헤더 정의
 * param : sheetObj ==> 시트오브젝트, sheetNo ==> 시트오브젝트 태그의 아이디에 붙인 일련번호
 * 시트가 다수일 경우 시트 수만큼 case를 추가하여 시트 초기화모듈을 구성한다
 * 구주 S/O
 */
function initSheet(sheetObj, sheetNo) {
  var sheetObject   = sheetObjects[0];
  var sheetObject1  = sheetObjects[1];
  var sheetObject2  = sheetObjects[2];
  var cnt = 0;
  switch(sheetNo) {
  case 1: //sheet0 init ( ATMT Header ) Hidden Sheet
  with (sheetObj) {
	  // 높이 설정
	  style.height = 0;
	  //전체 너비 설정
	  SheetWidth = mainTable.clientWidth;

	  //Host정보 설정[필수][HostIp, Port, PagePath]
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	  //전체Merge 종류 [선택, Default msNone]
	  MergeSheet = msHeaderOnly;

	  //전체Edit 허용 여부 [선택, Default false]
	  Editable = true;

	  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitRowInfo( 1, 1, 9, 100);

	  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  InitColumnInfo(8, 0, 0, true);

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, false, true, false,false)

	  var HeadTitle1 = "AGMT CITY CODE|AGMT NO|VNDR_SEQ|VNDR_NM|CONTRACT OFFICE CODE|REFERENCE NUMBER|PIC NAME|REMARK" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "trsp_agmt_ofc_cty_cd",false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "trsp_agmt_seq",       false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "vndr_prmry_seq",      false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "vndr_prmry_nm",       false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);	  
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "ctrt_ofc_cd",         false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "agmt_ref_no",         false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "agmt_pic_nm",         false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,  100, daLeft,  true,   "inter_rmk",           false,   "",  dfNone,   0,  false, false,  10, false, true,  "", false);

	  CountPosition = 0 ;
	  HeadRowHeight = 25;
  }
  break;
  
  case 2: //sheet1 init ( Child S/P )
  with (sheetObj) {
	  // 높이 설정
	  style.height = GetSheetHeight(3);
	  //전체 너비 설정
	  SheetWidth = mainTable.clientWidth;

	  //Host정보 설정[필수][HostIp, Port, PagePath]
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

	  //전체Merge 종류 [선택, Default msNone]
	  MergeSheet = msHeaderOnly;

	  //전체Edit 허용 여부 [선택, Default false]
	  Editable = true;

	  //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitRowInfo( 1, 1, 9, 100);

	  //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	  InitColumnInfo(3, 0, 0, true);

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, false, true, false,false)

	  var HeadTitle1 = "SEQ|Child Service\nProvider|Child Service\nProvider" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtSeq,         30, daCenter,  true,   "",        false,   "",  dfNone,   0,  false, false,   0, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,        60, daCenter,  true,   "vndr_seq",false,    "",  dfNone,   0,  false, true,   10, false, true,  "", false);
	  InitDataProperty(0, cnt++ , dtData,        40, daLeft,    true,   "vndr_nm", false,   "",  dfNone,   0,  false, true,  100, false, true,  "", false);

	  CountPosition = 0 ;
	  HeadRowHeight = 25;
  }
  break;
  case 3: //sheet2 init ( Rate )
  with (sheetObj) {
	  style.height    = 390; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(70, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false, false);
	  var HeadTitle1 = "|Container Verification Result|Container Verification Result|Duplication|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM|SeqNo" ;
	  var HeadTitle2 = "|Status|Description|Duplication|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|CNT\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2|AL4|AL5|AL7|D2|D4|D5|D7|R2|R4|R5|R7|R8|R9|A2|A4|A5|F2|F4|F5|T2|T4|S2|S4|O2|O4|O5|O7|P2|P4|Weight\nTier|UOM|SeqNo" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter, true,           "ibflag",  false,    "",  dfNone,     0,      false,  false,   0,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,   true,              "rlt",  false,    "",  dfNone,     0,      false,  false, 200,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daLeft,   true,             "rlt2",  false,    "",  dfNone,     0,      false,  false, 200,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,      "trsp_scg_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,  "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true,"cust_nomi_trkr_ind_cd", false, "",  dfNone,     0,      false,  true,    2,    false,   true,    "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    8,   false,   false,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    6,   false,   false,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter, true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      true,   true,   50,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_fm_dt",  false,    "",   dfDateYmd,  0,      true,   true,    8,   false,   false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_to_dt",  false,    "",   dfDateYmd,  0,      true,   true,    8,   false,   false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      true,   true,   50,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "fm_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "via_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "via_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "dor_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "to_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "to_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_scg_rt_div_cd",false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  true,         "curr_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daRight,   true,  "trsp_one_wy_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daRight,   true,     "trsp_rnd_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,         "eq_alal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_dal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_ral",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_aal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_fal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_tal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_sal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_oal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_pal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_al2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_al4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_al5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_al7",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_d2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_d4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_d5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_d7",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r7",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r8",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_r9",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_a2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_a4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter, true,            "eq_a5",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,      "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_f2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_f4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_f5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_t2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_t4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_s2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_s4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_o2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_o4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_o5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_o7",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_p2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,           "eq_p4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,          "to_wgt",  false,    "",  dfNone,     0,      true,   true,    9,   false,   true,     "The final value of weight tier should be 'Max'",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,  "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,   true,     "Unit of measure for weight",    false);
	  InitDataProperty(0, cnt++ , dtDataSeq,    50,  daCenter,  true,        "ui_seqno",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter,  true,           "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,   true,     "",    false);

      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  //InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"HJS|CNT|CPT|HPT|MIC",	"HJS|CNT|CPT|HPT|MIC");
	  InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"SML|CNT|CPT|HPT",	"HJS|CNT|CPT|HPT");
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
	  //InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE|VAT|TOL", "FUA|FUE|VAT|TOL");
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
	  sheetObj.ColHidden("ui_seqno") = true;
	  sheetObj.ColHidden("ck_vf") = true;
  }
  break;
  
  case 4: //sheet3 init ( Rate )
  with (sheetObj) {
	  style.height    = 390; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(50, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "|Chassis Verification Result|Chassis Verification Result|Duplication|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM|SeqNo" ;
	  var HeadTitle2 = "|Status|Description|Duplication|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4|Weight\nTier|UOM|SeqNo" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter, true,           "ibflag",  false,    "",  dfNone,     0,     false,  false,    0,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,   true,              "rlt",  false,    "",  dfNone,     0,     false,  false,  200,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daLeft,   true,             "rlt2",  false,    "",  dfNone,     0,     false,  false,  200,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,      "trsp_scg_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,  "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    8,   false,   false,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    6,   false,   false,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter, true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      true,   true,   50,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,        "eff_fm_dt",  false,    "",  dfDateYmd,  0,      true,   true,    8,   false,   false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,        "eff_to_dt",  false,    "",  dfDateYmd,  0,      true,   true,    8,   false,   false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      true,   true,   50,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,        "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,        "fm_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,       "via_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,       "via_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,       "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,       "dor_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter, true,        "to_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter, true,        "to_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_scg_rt_div_cd", false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter, true,          "curr_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,   daRight, true,   "trsp_one_wy_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,   daRight, true,      "trsp_rnd_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_alal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_sfal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_slal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_taal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_gnal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,          "eq_egal",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,           "eq_al2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,           "eq_al4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,           "eq_al5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter, true,           "eq_al8",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_sf2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_sf4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_sl2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_ta2",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_gn4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_gn5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_eg5",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_eg8",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_zt4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,           "eq_cb4",  false,    "",  dfNone,     0,      true,   true,    2,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       60,   daRight, true,           "to_wgt",  false,    "",  dfNone,     0,      true,   true,    9,   false,   false,     "The final value of weight tier should be 'Max'",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,   "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,   false,     "Unit of measure for weight",    false);
	  InitDataProperty(0, cnt++ , dtDataSeq,    50,  daCenter, true,         "ui_seqno",  false,    "",  dfNone,     0,      true,   true,    8,   false,   false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter, true,            "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,   false,     "",    false);
      
      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
//	  InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE|VAT|TOL", "FUA|FUE|VAT|TOL");
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
	  sheetObj.ColHidden("ui_seqno") = true;
	  sheetObj.ColHidden("ck_vf") = true;
  }
  break;
  
  case 5: //sheet4 init ( Rate )
  with (sheetObj) {
	  style.height    = 390; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(33, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "|Genset Verification Result|Genset Verification Result|Duplication|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM|SeqNo" ;
	  var HeadTitle2 = "|Status|Description|Duplication|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|CG|UG|Weight\nTier|UOM|SeqNo" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,              "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter,  true,           "ibflag",  false,    "",  dfNone,     0,     false,  false,    0,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,    true,              "rlt",  false,    "",  dfNone,     0,     false,  false,  200,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daLeft,    true,             "rlt2",  false,    "",  dfNone,     0,     false,  false,  200,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,      "trsp_scg_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter,  true, "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter,  true,  "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter,  true,        "cgo_tp_cd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter,  true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    8,   false,  false,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter,  true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    6,   false,  false,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter,  true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      true,   true,   50,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,        "eff_fm_dt",  false,    "",  dfDateYmd,  0,      true,   true,    8,   false,  false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,        "eff_to_dt",  false,    "",  dfDateYmd,  0,      true,   true,    8,   false,  false,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      true,   true,   50,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,        "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,        "fm_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "via_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "via_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "dor_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,        "to_nod_cd",  false,    "",  dfEngUpKey, 0,      true,   true,    5,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,        "to_nod_yd",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_scg_rt_div_cd", false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  true,          "curr_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,   "trsp_one_wy_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,      "trsp_rnd_rt",  false,    "",  dfNullFloat,2,      true,   true,    18,  false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,          "eq_alal",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,            "eq_cg",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,            "eq_ug",  false,    "",  dfNone,     0,      true,   true,    2,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,           "to_wgt",  false,    "",  dfNone,     0,      true,   true,    9,   false,  false,     "The final value of weight tier should be 'Max'",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,   "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,  false,     "Unit of measure for weight",    false);
	  InitDataProperty(0, cnt++ , dtDataSeq,    50,  daCenter,  true,         "ui_seqno",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter,  true,            "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
      
      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
//	  InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE|VAT|TOL", "FUA|FUE|VAT|TOL");
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
	  sheetObj.ColHidden("ui_seqno") = true;
	  sheetObj.ColHidden("ck_vf") = true;
  }
  break;
  
  }
}

/**
* Sheet 기본 설정 및 초기화 
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
*/
function loadPage() {
	for(i=0;i<sheetObjects.length;i++) {
		ComConfigSheet(sheetObjects[i] ); //khlee-시작 환경 설정 함수 이름 변경
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]); //khlee-마지막 환경 설정 함수 추가
	}

	for(k=0;k<tabObjects.length;k++) {
		initTab(tabObjects[k],k+1);
	}
	doSearch();
}

/*------------------여기서 부터 공통자바스크립트 함수를 정의한다.     ------------------*/
/* 공통전역변수 */
var openWindownm     = 'AGMT';
var sheetObjects     = new Array();
var sheetCnt         = 0;

var tabObjects       = new Array();
var tabCnt           = 0 ;
var beforetab        = 1;
var currenttab       = 0;

document.onclick = processButtonClick;
/* 업무별전역변수는 아래 부분에 추가 선언하여 사용한다. */
var sheetCnt = 0;
var Mincount = 0;

/* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){
    var sheetObject  = sheetObjects[0]; //Agreement Header정보
    var sheetObject1 = sheetObjects[1]; //Agreement Child S/P정보
    
    var rate_sheetObject = sheetObjects[2]; //Agreement Rate정보
    
    if (currenttab == 0) {
    	rate_sheetObject = sheetObjects[2]; //Agreement Rate정보
    }else if (currenttab == 1) {
        rate_sheetObject = sheetObjects[3]; //Agreement Rate정보
    }else{
    	rate_sheetObject = sheetObjects[4]; //Agreement Rate정보
    }
    /*******************************************************/
    var formObject = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
            /* [1.1.조회로직] */
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
			break;

			/* [1.2.minimize버튼-화면최소화] */
			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			
			/* [1.3.상단의 create버튼] */
			case "btn_creation":
				openAgmtHdrPopup();
			break;
			
			/* [2.1.하단 로우추가버튼] */
			case "btng_rowadd":
				doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
			break;

			/* [2.2.하단 sheet1의 엑셀파일추가] */
			case "btng_loadexcel":
				//document.all.btng_verify2.disabled = true;
				doActionIBSheet(rate_sheetObject,formObject,IBLOADEXCEL);
			break;
			
			/* [2.3.하단 로우삭제버튼] */
			case "btng_delete":
				doActionIBSheet(rate_sheetObject,formObject,IBDELETE);
			break;
			
			/* [2.4.모든정보의 초기화버튼] */
			case "btng_reset":
			    if (currenttab == 0) {
			    	reset_all1();
			    }else if (currenttab == 1) {
			    	reset_all2();
			    }else{
			    	reset_all3();
			    }
			break;

			/* [2.5.하단의 verify두번째 단계버튼] */
			case "btng_verify":
			    if (currenttab == 0) {
			    	valcheck_two1(rate_sheetObject);
			    }else if (currenttab == 1) {
			    	valcheck_two2(rate_sheetObject);
			    }else{
			    	valcheck_two3(rate_sheetObject);
			    }
			break;

			/* [2.6.최종저장버튼 -하단의 모든정보를 저장하는 버튼] */
			case "btng_update":
			    if (currenttab == 0) {
			    	update1(rate_sheetObject);
			    }else if (currenttab == 1) {
			    	update2(rate_sheetObject);
			    }else{
			    	update3(rate_sheetObject);
			    }
			break;

			/* [2.7.엑셀다운로드 버튼] */
			case "btng_downexcel":
			  var sheet2_count =rate_sheetObject.RowCount;
			  //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
			  if(sheet2_count > 0){
			    doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
			  }
			break;
			case "btng_help":
				openHelp();
			break;
       } // end switch
   }catch(e) {
       if( e == "[object Error]") {
			ComShowCodeMessage('TRS90031');
       } else {
			ComShowMessage(e);
       }
   }
}


function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg = false;
	var formObject = document.form;
	var x1 ="";

	switch(sAction) {
	case IBSEARCH:
		formObj.f_cmd.value = SEARCH01;		
		sheetObjects[0].DoSearch4Post("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
		if(sheetObjects[0].RowCount > 0) {
			formObj.f_cmd.value = SEARCH02;
			sheetObjects[1].DoSearch4Post("ESD_TRS_0220GS.do", TrsFrmQryString(formObj));
		}
		reset_all1();
		reset_all2();
		reset_all3();
		break;
	case IBINSERT:
		var row = 0;
		if(sheetObjects[0].RowCount == 0) {
			ComShowCodeMessage('TRS90081');
			return;
		}
		row = sheetObj.DataInsert(-1);
		sheetObj.CellValue2(row,'ck_vf') = 1;
		sheetObj.CellValue2(row,'chk') = 1;
		break;
	case IBDELETE:
		var checkList = sheetObj.FindCheckedRow('chk');
		var checkArray = checkList.split('|');
		for(var k=checkArray.length-2; k>=0; k--)
		{
			sheetObj.RowDelete(checkArray[k], false);
		}
		break;
	case IBLOADEXCEL:
	    var agmtno = formObj.fm_agmtno.value;
		var ctrt_ofc_cd = formObj.fm_ctrt_ofc_cd.value;
		
		if(sheetObjects[0].RowCount == 0) {
	 		ComShowCodeMessage('TRS90081');
			return;
		}
		
		if(agmtno !="" && ctrt_ofc_cd !=""){
			sheetObj.LoadExcel();
			for(var i = sheetObj.RowCount + sheetObj.HeaderRows; i > sheetObj.HeaderRows; i--){
				if(sheetObj.CellValue(i, "trsp_cost_mod_cd") == ""){
					sheetObj.RowDelete(i, false);
				}
			}
		}else{
			ComShowCodeMessage('TRS90081');
		}
		break;
    case IBDOWNEXCEL:
        sheetObj.Down2Excel(-1, false, false, true);
        break;
	}
}


/**
 * IBSheet Object를 배열로 등록
 * comSheetObject(id)에서 호출한다
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}

 /**
  * Tab 기본 설정
  * 탭의 항목을 설정한다.
 */
 function initTab(tabObj , tabNo) {
 	switch(tabNo) {
  	case 1:
  		with (tabObj) {
  			var cnt  = 0 ;
  			InsertTab( cnt++ , "Container" , -1 );
  			InsertTab( cnt++ , "Chassis" , -1 );
  			InsertTab( cnt++ , "Genset" , -1 );
  		}
  		break;
  	}
 }

 /**
  * IBTab Object를 배열로 등록
  * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
  * 배열은 소스 상단에 정의
  */
 function setTabObject(tab_obj) {
  	tabObjects[tabCnt++] = tab_obj;
 }

  /**
  * Tab 클릭시 이벤트 관련
  * 선택한 탭의 요소가 활성화 된다.
  */
  function tab1_OnChange(tabObj , nItem) {
  	var objs = document.all.item("tabLayer");
  	objs[nItem].style.display = "Inline";
  	objs[beforetab].style.display = "none";

  	//--------------- 요기가 중요 --------------------------//
  	objs[beforetab].style.zIndex = objs[nItem].style.zIndex -1 ;
  	//------------------------------------------------------//
  	beforetab= nItem;
  	currenttab = nItem;
  	
 	var formObj = document.form;
	if (currenttab == 0) {
		formObj.fm_eq_knd_cd.value = "U";
	}else if (currenttab == 1) {
		formObj.fm_eq_knd_cd.value = "Z";
	}else{
		formObj.fm_eq_knd_cd.value = "G";
	}
  }

  /**
   * 조회후 발생하는 EVENT
   * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
   */
  function sheet0_OnSearchEnd(sheetObj,errMsg){
  	//RowCount
  	var formObj = document.form;
  	if(sheetObj.RowCount > 0) {
  	    formObj.fm_vndr_prmry_seq.value = sheetObj.CellValue(1, "vndr_prmry_seq");
  	    formObj.fm_vndr_prmry_nm.value  = sheetObj.CellValue(1, "vndr_prmry_nm");
  	    formObj.fm_agmt_ref_no.value  = sheetObj.CellValue(1, "agmt_ref_no");
  	    formObj.fm_ctrt_ofc_cd.value  = sheetObj.CellValue(1, "ctrt_ofc_cd");
  	    formObj.fm_inter_rmk.value    = sheetObj.CellValue(1, "inter_rmk");
  	}
  }
  
  /**
   * sheet2 Excel Upload시 작동하는 EVENT
   */
   function sheet2_OnLoadExcel(sheetObj){
  	 eq_OnLoadExcel(sheetObj);
   }

   /**
   * sheet3 Excel Upload시 작동하는 EVENT
   */
   function sheet3_OnLoadExcel(sheetObj){
  	 eq_OnLoadExcel(sheetObj);
   }
   
   /**
   * sheet4 Excel Upload시 작동하는 EVENT
   */
   function sheet4_OnLoadExcel(sheetObj){
  	 eq_OnLoadExcel(sheetObj);
   }
   
   /**
   * Excel Upload시 작동하는 EVENT
   */
   function eq_OnLoadExcel(sheetObj){
  	 var formObj = document.form;

  	 ComOpenWait(true);
  	 for(var k=sheetObj.HeaderRows; k<sheetObj.RowCount+sheetObj.HeaderRows; k++)
  	 {
  		 sheetObj.CellValue2(k,'ck_vf') = 1;
  		 sheetObj.CellValue2(k,'chk') = 1;
  		 
		 if( !ComIsDate(sheetObj.CellValue(k,'eff_fm_dt')))  {	    		 
			 sheetObj.CellValue2(k,'eff_fm_dt') = '';
		 }    		 
		 
		 if( !ComIsDate(sheetObj.CellValue(k,'eff_to_dt')))  {	    		 
			 sheetObj.CellValue2(k,'eff_to_dt') = '';
		 }    		 
  	 }

  	 ComOpenWait(false);
   }
   
   /**
    * SHEET의 값이 변경되었을 때 발생하는 EVENT
    * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    */
    function sheet2_OnChange(sheetObj, row , col , value) {
   	 eq_OnChange(sheetObj, row , col , value);
    }
    
    /**
    * SHEET의 값이 변경되었을 때 발생하는 EVENT
    * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    */
    function sheet3_OnChange(sheetObj, row , col , value) {
   	 eq_OnChange(sheetObj, row , col , value);
    }
    
    /**
    * SHEET의 값이 변경되었을 때 발생하는 EVENT
    * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
    */
    function sheet4_OnChange(sheetObj, row , col , value) {
   	 eq_OnChange(sheetObj, row , col , value);
    }
    
    /**
    * Sheet에서 값이 변경되었을 경우 발생하는 Event
    */
    function eq_OnChange(sheetObj, row , col , value) {
    	//Node변경 조건을 chk가 아닌 경우에 포함시킨 이유는 체크박스 전체 체크시 IF문 비교 자체를 타지 않게하여 체크속도를 높이기 위해서 입니다.
    	if( sheetObj.ColSaveName(col) != "chk" ) {
    		sheetObj.CellValue2(row,'chk') = 1;
    		sheetObj.CellValue2(row,'ck_vf') = 1;
    		sheetObj.CellValue2(row,'rlt') = "";

    		if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
    			var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd").toUpperCase(), " ");
    			sheetObj.CellValue2(row, "fm_nod_cd") = lvfm;
    			if( doengnumcheck(lvfm) ) {
    				if( lvfm.length == 5 ) {
    					getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yd", lvfm); //Varidation check
    					if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
    						document.form.TRSP_SO_EQ_KIND.value = "A";
    						getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yd", lvfm);
    					} else {
    						sheetObj.CellComboItem(row, "fm_nod_yd", "", "");
    						sheetObj.CellValue2(row, "fm_nod_yd") = "";					
    					}
    				} else {
    					if( lvfm.length == 0 ) {
    						sheetObj.CellComboItem(row, "fm_nod_yd", "", "");
    						sheetObj.CellValue2(row, "fm_nod_yd") = "";
    					} else {
    						errMsg = ComGetMsg("TRS90122");
    						ComShowMessage(errMsg);
    						sheetObj.CellValue2(row,"fm_nod_cd") = "";
    						sheetObj.SelectCell(row,"fm_nod_cd");
    						sheetObj.CellComboItem(row, "fm_nod_yd", "", "");
    						sheetObj.CellValue2(row, "fm_nod_yd") = "";
    					}
    				}
    			} else {
    				sheetObj.CellValue2(row,"fm_nod_cd") = "";
    				sheetObj.SelectCell(row,"fm_nod_cd");
    				sheetObj.CellComboItem(row, "fm_nod_yd", "", "");
    				sheetObj.CellValue2(row, "fm_nod_yd") = "";
    			}
    		} else if( sheetObj.ColSaveName(col) == "via_nod_cd" ) {
    			var lvvia = doSepRemove(sheetObj.CellValue(row,"via_nod_cd").toUpperCase(), " ");
    			sheetObj.CellValue(row,"via_nod_cd") = lvvia;
    			if( doengnumcheck(lvvia) ) {
    				if( lvvia.length == 5 ) {
    					getYardSheetCombo1(sheetObj, document.form, row, col, "via_nod_yd", lvvia); //Varidation check
    					if( sheetObj.CellValue(row, "via_nod_cd") != "" ) {
    						getYardSheetCombo(sheetObj, document.form, row, "via_nod_yd", lvvia);
    					} else {
    						sheetObj.CellComboItem(row, "via_nod_yd", "", "");
    						sheetObj.CellValue2(row, "via_nod_yd") = "";
    					}
    				} else {
    					if( lvvia.length == 0 ) {
    						sheetObj.CellComboItem(row, "via_nod_yd", "", "");
    						sheetObj.CellValue2(row, "via_nod_yd") = "";
    					} else {
    						errMsg = ComGetMsg("TRS90122");
    						ComShowMessage(errMsg);
    						sheetObj.CellValue2(row,"via_nod_cd") = "";
    						sheetObj.SelectCell(row,"via_nod_cd");
    						sheetObj.CellComboItem(row, "via_nod_yd", "", "");
    						sheetObj.CellValue2(row, "via_nod_yd") = "";
    					}
    				}
    			} else {
    				sheetObj.CellValue2(row,"via_nod_cd") = "";
    				sheetObj.SelectCell(row,"via_nod_cd");
    				sheetObj.CellComboItem(row, "via_nod_yd", "", "");
    				sheetObj.CellValue2(row, "via_nod_yd") = "";
    			}
    		} else if( sheetObj.ColSaveName(col) == "to_nod_cd" ) {
    			var lvto = doSepRemove(sheetObj.CellValue(row,"to_nod_cd").toUpperCase(), " ");
    			sheetObj.CellValue(row,"to_nod_cd") = lvto;
    			if( doengnumcheck(lvto) ) {
    				if( lvto.length == 5 ) {
    					getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yd", lvto); //Varidation check
    					if( sheetObj.CellValue(row, "to_nod_cd") != "" ) {
    						getYardSheetCombo(sheetObj, document.form, row, "to_nod_yd", lvto);
    					} else {
    						sheetObj.CellComboItem(row, "to_nod_yd", "", "");
    						sheetObj.CellValue2(row, "to_nod_yd") = "";
    					}
    				} else {
    					if( lvto.length == 0 ) {
    						sheetObj.CellComboItem(row, "to_nod_yd", "", "");
    						sheetObj.CellValue2(row, "to_nod_yd") = "";
    					} else {
    						errMsg = ComGetMsg("TRS90122");
    						ComShowMessage(errMsg);
    						sheetObj.CellValue2(row,"to_nod_cd") = "";
    						sheetObj.SelectCell(row,"to_nod_cd");
    						sheetObj.CellComboItem(row, "to_nod_yd", "", "");
    						sheetObj.CellValue2(row, "to_nod_yd") = "";
    					}
    				}
    			} else {
    				sheetObj.CellValue2(row,"to_nod_cd") = "";
    				sheetObj.SelectCell(row,"to_nod_yd");
    				sheetObj.CellComboItem(row, "to_nod_yd", "", "");
    				sheetObj.CellValue2(row, "to_nod_yd") = "";
    			}
    		} else if( sheetObj.ColSaveName(col) == "dor_nod_cd" ) {
    			var lvdor = doSepRemove(sheetObj.CellValue(row,"dor_nod_cd").toUpperCase(), " ");
    			sheetObj.CellValue(row,"dor_nod_cd") = lvdor;
    			if( doengnumcheck(lvdor) ) {
    				if( lvdor.length == 5 ) {
    					getZoneSheetCombo1(sheetObj, document.form, row, col, "dor_nod_yd", lvdor);
    					if( sheetObj.CellValue(row, "dor_nod_cd") != "" ) {
    						getZoneSheetCombo(sheetObj, document.form, row, "dor_nod_yd", lvdor);
    					} else {
    						sheetObj.CellComboItem(row, "dor_nod_yd", "", "");
    						sheetObj.CellValue2(row, "dor_nod_yd") = "";
    					}
    				} else {
    					if( lvdor.length == 0 ) {
    						sheetObj.CellComboItem(row, "dor_nod_yd", "", "");
    						sheetObj.CellValue2(row, "dor_nod_yd") = "";
    					} else {
    						errMsg = ComGetMsg("TRS90122");
    						ComShowMessage(errMsg);
    						sheetObj.CellValue2(row,"dor_nod_cd") = "";
    						sheetObj.SelectCell(row,"dor_nod_cd");
    						sheetObj.CellComboItem(row, "dor_nod_yd", "", "");
    						sheetObj.CellValue2(row, "dor_nod_yd") = "";
    					}
    				}
    			} else {
    				sheetObj.CellValue2(row,"dor_nod_cd") = "";
    				sheetObj.SelectCell(row,"dor_nod_cd");
    				sheetObj.CellComboItem(row, "dor_nod_yd", "", "");
    				sheetObj.CellValue2(row, "dor_nod_yd") = "";
    			}
    		}	
    	}
    }

   /**
    * sheet2 COLUMN click시 발생하는 EVENT
   */
    function sheet2_OnClick(sheetObj, row , col , value) {
   	 eq_OnClick(sheetObj, row , col , value);
    }
    /**
     * sheet3 COLUMN click시 발생하는 EVENT
    */
    function sheet3_OnClick(sheetObj, row , col , value) {
   	  eq_OnClick(sheetObj, row , col , value);
    }
     /**
      * sheet4 COLUMN click시 발생하는 EVENT
      */
     function sheet4_OnClick(sheetObj, row , col , value) {
    	 eq_OnClick(sheetObj, row , col , value);
     }

   //sheet1 COLUMN click시 발생하는 EVENT
   /**
    * Sheet에서 COLUMN click시 발생하는 EVENT
    */
   function eq_OnClick(sheetObj, row , col , value) {
	   if( sheetObj.ColSaveName(col) == "fm_nod_yd" ) {
		   value = doSepRemove(sheetObj.CellValue(row, "fm_nod_cd"), " ");
		   //document.form.TRSP_SO_EQ_KIND.value = "";
		   document.form.TRSP_SO_EQ_KIND.value = "A";
		   if( value.length > 0 ) {
			   getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		   } else {
			   sheetObj.CellValue2(row, "fm_nod_cd") = "";
		   }
	   } else if( sheetObj.ColSaveName(col) == "to_nod_yd" ) {
		   value = doSepRemove(sheetObj.CellValue(row, "to_nod_cd"), " ");
		   document.form.TRSP_SO_EQ_KIND.value = "A";
		   if( value.length > 0 ) {
			   getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		   } else {
			   sheetObj.CellValue2(row, "to_nod_cd") = "";
		   }
	   } else if (sheetObj.ColSaveName(col) == "via_nod_yd" ) {
		   value = doSepRemove(sheetObj.CellValue(row, "via_nod_cd"), " ");
		   document.form.TRSP_SO_EQ_KIND.value = "";
		   if( value.length > 0 ) {
			   getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		   } else {
			   sheetObj.CellValue2(row, "via_nod_cd") = "";
		   }
	   } else if( sheetObj.ColSaveName(col) == "dor_nod_yd" ) {
		   value = doSepRemove(sheetObj.CellValue(row, "dor_nod_cd"), " ");
		   document.form.TRSP_SO_EQ_KIND.value = "";
		   if( value.length > 0 ) {
			   getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
		   } else {
			   sheetObj.CellValue2(row, "dor_nod_cd") = "";
		   }
	   }
   }
  
  function doSearch() {
	  var sheetObject = sheetObjects[0];
	  var formObject  = document.form;
	  doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
  }
  
  /**
  * 화면 Container Reset
  */
  function reset_all1(){
  	var formObject = document.form;
  	formObject.verify_result_1.value="";
  	formObject.verify_result_str_1.value="";
    formObject.updated_rows_cnt_1.value = "";
    formObject.total_rows_cnt_1.value = "";
  	formObject.verify_check_yn_1.value="N";
  	formObject.sheet2.RemoveEtcData();
  	formObject.sheet2.RemoveAll();
  }

  /**
  * 화면 Chassis Reset
  */
  function reset_all2(){
  	var formObject = document.form;
  	formObject.verify_result_2.value="";
  	formObject.verify_result_str_2.value="";
    formObject.updated_rows_cnt_2.value = "";
    formObject.total_rows_cnt_2.value = "";
  	formObject.verify_check_yn_2.value="N";
  	formObject.sheet3.RemoveEtcData();
  	formObject.sheet3.RemoveAll();
  }
  
  /**
  * 화면 Genset Reset
  */
  function reset_all3(){
  	var formObject = document.form;
  	formObject.verify_result_3.value="";
  	formObject.verify_result_str_3.value="";
    formObject.updated_rows_cnt_3.value = "";
    formObject.total_rows_cnt_3.value = "";
  	formObject.verify_check_yn_3.value="N";
  	formObject.sheet4.RemoveEtcData();
  	formObject.sheet4.RemoveAll();
  }
  
  /**
   * Sheet 확대/축소
   */
  function Minimize(nItem) {
	var objs = document.all.item("MiniLayer");
  	if( nItem == "1" ) {
  		objs.style.display = "none";
  		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(23);
  		sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(23);
  		sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(23);
  	} else {
  		objs.style.display = "inline";
  		sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(18);
  		sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(18);
  		sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(18);
  	}
  }
  
  /**
   * Container Verify 체크
   */
   function valcheck_two1(sheetObj){
	   var formObject = document.form;
	   //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
	   if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
		   formObject.verify_result_str_1.value="Collect data is being precessed. Please wait.";
		   ComOpenWait(true);
		   document.all.btng_verify.disabled = false;
		   formObject.f_cmd.value   = SEARCH02;
		   //verify가 완료되면 ck_vf의 값은 '1' -> '0'로 변경된다.
		   var check_verify    = sheetObj.CheckedRows('ck_vf');
		   var check_row       = sheetObj.CheckedRows('chk');
		   if(check_verify == '' || check_row == '')  {
			   ComOpenWait(false);
			   ComShowCodeMessage('TRS90386', 'No Target Data!');
			   return;
		   }
		   var queryStr = sheetObj.GetSaveString(false, true, "chk");
		   formObject.verify_result_str_1.value="Verify is being processed. Please wait.";
		   sheetObj.DoRowSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
		   formObject.verify_result_1.value = sheetObj.EtcData('err_cnt2');
		   formObject.verify_check_yn_1.value="Y";
		   ComOpenWait(false);//레이어형 대기 이미지 표시
		   if(formObject.verify_result_1.value>0 ){
			   formObject.verify_result_str_1.value="There are 'Verify Error.'";
			   document.all.btng_verify.disabled = false;
		   }else{
			   formObject.message_1.value ="";
			   formObject.verify_result_str_1.value="Verify are done. Please click on the 'Update' button to save.";
		   }
	   }else{
		   ComShowMessage('Only 5000 rows or less could be imported at a time.');
	   }
   }

  /**
  * Chassis Verify 체크
  */
  function valcheck_two2(sheetObj){
	  var formObject = document.form;
	  //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
	  if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
		  formObject.verify_result_str_2.value="Collect data is being precessed. Please wait.";
		  ComOpenWait(true);
		  document.all.btng_verify.disabled = false;
		  formObject.f_cmd.value   = SEARCH02;
		  //verify가 완료되면 ck_vf의 값은 '1' -> '0'로 변경된다.
		  var check_verify    = sheetObj.CheckedRows('ck_vf');
		  var check_row       = sheetObj.CheckedRows('chk');
		  if(check_verify == '' || check_row == '')  {
			  ComOpenWait(false);
			  ComShowCodeMessage('TRS90386', 'No Target Data!');
			  return;
		  }
		  var queryStr = sheetObj.GetSaveString(false, true, "chk");
		  formObject.verify_result_str_2.value="Verify is being processed. Please wait.";
		  sheetObj.DoRowSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
		  formObject.verify_result_2.value = sheetObj.EtcData('err_cnt2');
		  formObject.verify_check_yn_2.value="Y";
		  ComOpenWait(false);//레이어형 대기 이미지 표시
		  if(formObject.verify_result_2.value>0 ){
			  formObject.verify_result_str_2.value="There are 'Verify Error.'";
			  document.all.btng_verify.disabled = false;
		  }else{
			  formObject.message_2.value ="";
			  formObject.verify_result_str_2.value="Verify are done. Please click on the 'Update' button to save.";
		  }
	  }else{
		  ComShowMessage('Only 5000 rows or less could be imported at a time.');
	  }
  }
  
  /**
  * Genset Verify 체크
  */
  function valcheck_two3(sheetObj){
	  var formObject = document.form;
	  //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
	  if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
		  formObject.verify_result_str_3.value="Collect data is being precessed. Please wait.";
		  ComOpenWait(true);
		  document.all.btng_verify.disabled = false;
		  formObject.f_cmd.value   = SEARCH02;
		  //verify가 완료되면 ck_vf의 값은 '1' -> '0'로 변경된다.
		  var check_verify    = sheetObj.CheckedRows('ck_vf');
		  var check_row       = sheetObj.CheckedRows('chk');
		  if(check_verify == '' || check_row == '')  {
			  ComOpenWait(false);
			  ComShowCodeMessage('TRS90386', 'No Target Data!');
			  return;
		  }
		  var queryStr = sheetObj.GetSaveString(false, true, "chk");
		  formObject.verify_result_str_3.value="Verify is being processed. Please wait.";
		  sheetObj.DoRowSearch("ESD_TRS_0221GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
		  formObject.verify_result_3.value = sheetObj.EtcData('err_cnt2');
		  formObject.verify_check_yn_3.value="Y";
		  ComOpenWait(false);//레이어형 대기 이미지 표시
		  if(formObject.verify_result_3.value>0 ){
			  formObject.verify_result_str_3.value="There are 'Verify Error.'";
			  document.all.btng_verify.disabled = false;
		  }else{
			  formObject.message_3.value ="";
			  formObject.verify_result_str_3.value="Verify are done. Please click on the 'Update' button to save.";
		  }
	  }else{
		  ComShowMessage('Only 5000 rows or less could be imported at a time.');
	  }
  }
  
  /*
   * Container Verify 통과한 rate 저장
   */
  function update1(sheetObj){
	  var formObject      = document.form;
  	  var sheet2_count    = sheetObj.RowCount;
  	  var check_verify    = sheetObj.CheckedRows('ck_vf');
  	  var check_result    = false;

  	  for(var k=sheetObj.HeaderRows; k<sheet2_count+sheetObj.HeaderRows; k++)
  	  {
  		  if(sheetObj.CellValue(k, 'rlt') !='OK' ) check_result    = true;
  		  sheetObj.RowStatus(k)  = 'I';
  	  }
  	  if(check_verify > 0 || check_result){
  		  ComShowCodeMessage('TRS90039')
  		  formObject.verify_result_str_1.value="Please click on the 'Verify' button.";
  		  return false;
  	  }
  	  var y1 = formObject.fm_agmtno.value;
  	  formObject.message_1.value = "S";
  	  var verify_f = formObject.verify_result_1.value;
  	  var verify_s = formObject.verify_check_yn_1.value;
  	  formObject.total_rows_cnt_1.value = sheetObj.RowCount;
  	  if(sheet2_count >0){
  		  if(verify_f == 0 && verify_s == "Y"){
  			  //ComOpenWait(true);
  			  formObject.f_cmd.value   = MULTI01;
  			  sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "ibflag", false, true);
  			  //ComOpenWait(false);
  			  if(formObject.message_1.value=="V"){
  			  }else if(formObject.message_1.value=="S"){
  				  formObject.updated_rows_cnt_1.value = formObject.total_rows_cnt_1.value;
  				  formObject.verify_result_str_1.value="Saving has been completed.";
  			  }
  			  formObject.message_1.value      = "";
  			  formObject.sheet2.RemoveAll();
  		  }else{
  			  ComShowCodeMessage('TRS90039');
  		  }
  	  }
  }
   
   /*
    * Chassis Verify 통과한 rate 저장
    */
   function update2(sheetObj){
   	  var formObject      = document.form;
   	  var sheet2_count    = sheetObj.RowCount;
   	  var check_verify    = sheetObj.CheckedRows('ck_vf');
   	  var check_result    = false;

   	  for(var k=sheetObj.HeaderRows; k<sheet2_count+sheetObj.HeaderRows; k++)
   	  {
   		  if(sheetObj.CellValue(k, 'rlt') !='OK' ) check_result    = true;
   		  sheetObj.RowStatus(k)  = 'I';
   	  }
   	  if(check_verify > 0 || check_result){
   		  ComShowCodeMessage('TRS90039')
   		  formObject.verify_result_str_2.value="Please click on the 'Verify' button.";
   		  return false;
   	  }
   	  var y1 = formObject.fm_agmtno.value;
   	  formObject.message_2.value = "S";
   	  var verify_f = formObject.verify_result_2.value;
   	  var verify_s = formObject.verify_check_yn_2.value;
   	  formObject.total_rows_cnt_2.value = sheetObj.RowCount;
   	  if(sheet2_count >0){
   		  if(verify_f == 0 && verify_s == "Y"){
   			  //ComOpenWait(true);
   			  formObject.f_cmd.value   = MULTI01;
   			  sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "ibflag", false, true);
   			  //ComOpenWait(false);
   			  if(formObject.message_2.value=="V"){
   			  }else if(formObject.message_2.value=="S"){
   				  formObject.updated_rows_cnt_2.value = formObject.total_rows_cnt_2.value;
   				  formObject.verify_result_str_2.value="Saving has been completed.";
   			  }
   			  formObject.message_2.value      = "";
   			  formObject.sheet3.RemoveAll();
   		  }else{
   			  ComShowCodeMessage('TRS90039');
   		  }
   	  }
   }
    
    /*
     * Genset Verify 통과한 rate 저장
     */
    function update3(sheetObj){
    	  var formObject      = document.form;
    	  var sheet2_count    = sheetObj.RowCount;
    	  var check_verify    = sheetObj.CheckedRows('ck_vf');
    	  var check_result    = false;

    	  for(var k=sheetObj.HeaderRows; k<sheet2_count+sheetObj.HeaderRows; k++)
    	  {
    		  if(sheetObj.CellValue(k, 'rlt') !='OK' ) check_result    = true;
    		  sheetObj.RowStatus(k)  = 'I';
    	  }
    	  if(check_verify > 0 || check_result){
    		  ComShowCodeMessage('TRS90039')
    		  formObject.verify_result_str_3.value="Please click on the 'Verify' button.";
    		  return false;
    	  }
    	  var y1 = formObject.fm_agmtno.value;
    	  formObject.message_3.value = "S";
    	  var verify_f = formObject.verify_result_3.value;
    	  var verify_s = formObject.verify_check_yn_3.value;
    	  formObject.total_rows_cnt_3.value = sheetObj.RowCount;
    	  if(sheet2_count >0){
    		  if(verify_f == 0 && verify_s == "Y"){
    			  //ComOpenWait(true);
    			  formObject.f_cmd.value   = MULTI01;
    			  sheetObj.DoSave("ESD_TRS_0221GS.do", TrsFrmQryString(formObject), "ibflag", false, true);
    			  //ComOpenWait(false);
    			  if(formObject.message_3.value=="V"){
    			  }else if(formObject.message_3.value=="S"){
    				  formObject.updated_rows_cnt_3.value = formObject.total_rows_cnt_3.value;
    				  formObject.verify_result_str_3.value="Saving has been completed.";
    			  }
    			  formObject.message_3.value      = "";
    			  formObject.sheet4.RemoveAll();
    		  }else{
    			  ComShowCodeMessage('TRS90039');
    		  }
    	  }
    }
     
     /*
     * Verify Rule 팝업
     */
     function openHelp() {
    	 var formObj = document.form;
    	 var Option = "width=680,height=700,menubar=0,status=0,scrollbars=3,resizable=0";
    	 window.open('apps/alps/esd/trs/agreementmanage/agreementmanage/html/surcharge_verify_rule.htm', "popupHelp2", Option);
     }