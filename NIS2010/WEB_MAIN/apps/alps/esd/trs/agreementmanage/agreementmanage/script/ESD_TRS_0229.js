/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0229.js
*@FileTitle : Agreement Surcharge Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.2
* 2010-03-18 cjh
* 1.0 최초 생성
*---------------------------------------------------------- 
* HISTORY
* 2011.01.11 민정호   1.1 [CHM-201108253] [TRS] AGMT 상 rate, ratio 입력시 표기 가능한 소수점 자리수 변경 요청 
* 2011.05.11 민정호   1.2 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 2011.06.27 황효근   1.3 [CHM-201111442] [TRS] R9 CNTR 추가관련 로직 변경요청
* 2015.06.16 9014787 [CHM-201535825] Surcharge confirm 대상 추가
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
	  InitHeadMode(true, true, false, true, false, false);

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
	  InitHeadMode(true, true, false, true, false, false);

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
	  style.height    = 380; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(67, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false, false);
	  var HeadTitle1 = "|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM|Confirm\n(Manager Level)|CK|EQ" ;
	  var HeadTitle2 = "|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|CNT\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|DAL|RAL|AAL|FAL|TAL|SAL|OAL|PAL|AL2|AL4|AL5|AL7|D2|D4|D5|D7|R2|R4|R5|R7|R8|R9|A2|A4|A5|F2|F4|F5|T2|T4|S2|S4|O2|O4|O5|O7|P2|P4|Weight\nTier|UOM|Confirm\n(Manager Level)|CK|EQ" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,                   "chk",  false,    "",  dfNone,     0,      true,   	true );
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,      	   "trsp_scg_cd",  false,    "",  dfNone,     0,      false,   	true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, 	  "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      false,   	true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,  	   "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      false,   	true,    2,   false,   true,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, 	         "cgo_tp_cd",  false,    "",  dfNone,     0,      false,   	true,    2,   false,   true,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true, "cust_nomi_trkr_ind_cd",  false, 	  "",  dfNone,    0,      false,   false,    2,   false,   false,    "",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    8,   false,   true,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    6,   false,   true,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter, true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_fm_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
      InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_to_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "fm_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "via_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "via_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "dor_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "to_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "to_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_scg_rt_div_cd",false,    "",  dfNone,     0,      false,   true,    2,   false,   false,     "",    false);
      InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  true,         "curr_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,  "trsp_one_wy_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,     "trsp_rnd_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_alal", false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_dal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_ral",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_aal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_fal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_tal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_sal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_oal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_pal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_al2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_al4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_al5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,        "eq_al7",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_d2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_d4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_d5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_d7",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r7",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r8",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_r9",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_a2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_a4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_a5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_f2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_f4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_f5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_t2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_t4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_s2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_s4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_o2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_o4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_o5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_o7",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_p2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   25,  daCenter,  true,         "eq_p4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,          "to_wgt",  false,    "",  dfNone,     0,      false,   true,    9,   false,   true,     "The final value of weight tier should be 'Max'",    false);
      InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,  "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      false,   true,    3,   false,   true,     "Unit of measure for weight",    false);
      //CHM-201535825 Surcharge confirm 대상 추가
      InitDataProperty(0, cnt++ , dtData,      100,  daCenter,  true,        "cfm_flg", false,    "",  dfNone,     0,      false,   false,   8,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter,  true,           "ck_vf",  false,    "",  dfNone,     0,      false,   true,    8,   false,   true,     "",    false);

      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  InitDataCombo(0, 'cust_nomi_trkr_ind_cd',	"HJS|CNT|CPT|HPT|MIC",	"HJS|CNT|CPT|HPT|MIC");
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
//	  InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE", "FUA|FUE");	  
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
  }
  break;
  
  case 4: //sheet3 init ( Rate )
  with (sheetObj) {
	  style.height    = 380; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = true; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(46, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM" ;
	  var HeadTitle2 = "|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|SFAL|SLAL|TAAL|GNAL|EGAL|AL2|AL4|AL5|AL8|SF2|SF4|SL2|TA2|GN4|GN5|EG5|EG8|ZT4|CB4|Weight\nTier|UOM" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,      "trsp_scg_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,  "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    8,   false,   true,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    6,   false,   true,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter, true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_fm_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
      InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_to_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "fm_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "via_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "via_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "dor_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "to_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,        40,  daCenter,  true,      "to_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_scg_rt_div_cd",false,    "",  dfNone,     0,      false,   true,    2,   false,   false,     "",    false);
      InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  true,         "curr_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,  "trsp_one_wy_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,     "trsp_rnd_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_alal", false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_sfal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_slal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_taal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_gnal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_egal",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_al2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_al4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_al5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_al8",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_sf2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_sf4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_sl2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_ta2",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_gn4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_gn5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_eg5",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_eg8",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_zt4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,        "eq_cb4",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,          "to_wgt",  false,    "",  dfNone,     0,      false,   true,    9,   false,   true,     "The final value of weight tier should be 'Max'",    false);
      InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,  "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      false,   true,    3,   false,   true,     "Unit of measure for weight",    false);
      InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter,  true,           "ck_vf",  false,    "",  dfNone,     0,      false,   true,    8,   false,   true,     "",    false);
      
      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
//	  InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE", "FUA|FUE");	  
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
  }
  break;
  case 5: //sheet4 init ( Rate )
  with (sheetObj) {
	  style.height    = 380; // 높이 설정
	  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
	  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
	  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
	  Editable = false; //전체Edit 허용 여부 [선택, Default false]
	  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
	  InitColumnInfo(29, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]

	  // 해더에서 처리할 수 있는 각종 기능을 설정한다
	  InitHeadMode(true, true, true, true, false,false)
	  var HeadTitle1 = "|Surcharge|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Rate Type|Effective Date|Effective Date|All Route|From|From|Via|Via|Door|Door|To|To|Fixed\nRatio Div|Currency|One Way|Round Trip|EQ Type/Size|EQ Type/Size|EQ Type/Size|Weight\nTier|UOM" ;
	  var HeadTitle2 = "|Surcharge|Cost\nMode|Trans\nMode|Cargo\nType|Customer\nCode|Commodity\nGroup Code|Rail Service\nType|From|To|All Route|Loc|Node|Loc|Node|Loc|Node|Loc|Node|Fixed\nRatio Div|Currency|One Way|Round Trip|ALAL|CG|UG|Weight\nTier|UOM" ;

	  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
	  InitHeadRow(0, HeadTitle1, true);
	  InitHeadRow(1, HeadTitle2, true);

	  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
	  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,      "trsp_scg_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true, "trsp_cost_mod_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cost Mode-CY, Door, Bare CHZ(Stack), Bare CHZ(Flatbed), Empty Flatrack, Matchmaking(I)",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,  "agmt_trsp_tp_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Transporation Mode-(Single Direct)TD,WD,RD  (Combine)RT,TR,WT,TW,RW,WR ",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      40,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "Cargo Type-F:Full, E:Empty",    false);
	  InitDataProperty(0, cnt++ , dtData,       70,  daCenter, true,          "cust_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    8,   false,   true,     "Customer Code for this agreement",    false);
	  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "cmdt_grp_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    6,   false,   true,     "Commodity Group that this rate is being applied",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      90,  daCenter, true,   "rail_svc_tp_cd",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_fm_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
      InitDataProperty(0, cnt++ , dtData,       75,  daCenter,  true,       "eff_to_dt",  false,    "",dfDateYmd,    0,      false,   true,    8,   false,   true,     "Effective period of this rate",   false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,      false,   true,   50,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "fm_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,       "fm_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "via_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "via_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,      "dor_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       40,  daCenter,  true,      "dor_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       50,  daCenter,  true,       "to_nod_cd",  false,    "",  dfEngUpKey, 0,      false,   true,    5,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,        40,  daCenter,  true,      "to_nod_yd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
	  InitDataProperty(0, cnt++ , dtCombo,      60,  daCenter,  true,"agmt_scg_rt_div_cd",false,    "",  dfNone,     0,      false,   true,    2,   false,   false,     "",    false);
      InitDataProperty(0, cnt++ , dtCombo,      70,  daCenter,  true,         "curr_cd",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,  "trsp_one_wy_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       70,   daRight,  true,     "trsp_rnd_rt",  false,    "",  dfNullFloat,     2,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   35,  daCenter,  true,       "eq_alal", false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,         "eq_cg",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter,  true,         "eq_ug",  false,    "",  dfNone,     0,      false,   true,    2,   false,   true,     "",    false);
      InitDataProperty(0, cnt++ , dtData,       60,   daRight,  true,          "to_wgt",  false,    "",  dfNone,     0,      false,   true,    9,   false,   true,     "The final value of weight tier should be 'Max'",    false);
      InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter,  true,  "wgt_meas_ut_cd",  false,    "",  dfNone,     0,      false,   true,    3,   false,   true,     "Unit of measure for weight",    false);
      InitDataProperty(0, cnt++ , dtHidden,     60,  daCenter,  true,           "ck_vf",  false,    "",  dfNone,     0,      false,   true,    8,   false,   true,     "",    false);
      
      InitDataCombo(0, 'trsp_cost_mod_cd', " |"		+trsp_cost_mod_cdCode,	" |"+trsp_cost_mod_cdCode);
	  InitDataCombo(0, 'agmt_trsp_tp_cd',	 " |"	+agmt_trsp_tp_cdCode,	" |"+agmt_trsp_tp_cdCode);
	  InitDataCombo(0, 'cgo_tp_cd', " |"			+cgo_tp_cdCode,			" |"+cgo_tp_cdCode);
	  InitDataCombo(0, 'rail_svc_tp_cd', " |"		+rail_svc_tp_cdCode,	" |"+rail_svc_tp_cdCode);
	  InitDataCombo(0, 'curr_cd', " |"		+curr_cdCode,	" |"+curr_cdCode);
	  InitDataCombo(0, 'agmt_rout_all_flg', " |Y|N", " |Y|N");
//	  InitDataCombo(0, 'trsp_scg_cd', trsp_scg_cdCode,	trsp_scg_cdCode);
	  InitDataCombo(0, 'trsp_scg_cd', "FUA|FUE", "FUA|FUE");	  
	  InitDataCombo(0, 'wgt_meas_ut_cd', " |KGS|LBS", " |KGS|LBS");
	  InitDataCombo(0, 'agmt_scg_rt_div_cd', " |Fixed|Ratio", " |F|R");
      document.form.header_row.value = HeaderRows-1;
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
//	if(document.form.fm_sub_title.value!=""){
//		ComSetDisplay("td_downexcel", false); 
//	}	
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
			if (currenttab == 0) {
				formObject.cur_page_cnt1.value = 1;
			}else if (currenttab == 1) {
				formObject.cur_page_cnt2.value = 1;
			}else{
				formObject.cur_page_cnt3.value = 1;
			}
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
			break;
			/* [1.2.minimize버튼-화면최소화] */
		case "reward1":
			var ipageNo = formObject.cur_page_cnt1.value;
			ipageNo--;

			if(Number(ipageNo) < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}  

			formObject.cur_page_cnt1.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
			break;

		case "forward1":
			var ipageNo = formObject.cur_page_cnt1.value;
			var totpage = formObject.tot_page_cnt1.value;
			ipageNo++;  

			if( (Number(ipageNo) > Number(formObject.tot_page_cnt1.value)) || totpage < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}               
			formObject.cur_page_cnt1.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
			break;

		case "reward2":
			var ipageNo = formObject.cur_page_cnt2.value;
			ipageNo--;

			if(Number(ipageNo) < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}  

			formObject.cur_page_cnt2.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
			break;

		case "forward2":
			var ipageNo = formObject.cur_page_cnt2.value;
			var totpage = formObject.tot_page_cnt2.value;
			ipageNo++;  

			if( (Number(ipageNo) > Number(formObject.tot_page_cnt2.value)) || totpage < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}               
			formObject.cur_page_cnt2.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
			break;
			
		case "reward3":
			var ipageNo = formObject.cur_page_cnt3.value;
			ipageNo--;

			if(Number(ipageNo) < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}  

			formObject.cur_page_cnt3.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE");
			break;

		case "forward3":
			var ipageNo = formObject.cur_page_cnt3.value;
			var totpage = formObject.tot_page_cnt3.value;
			ipageNo++;  

			if( (Number(ipageNo) > Number(formObject.tot_page_cnt3.value)) || totpage < 1){
				var errMessage = ComGetMsg('TRS90351','','','');  
				ComShowMessage(errMessage);
				break;
			}               
			formObject.cur_page_cnt3.value = ipageNo;
			doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
			break;
			
		case "btn_minimize":
			Mincount = (Mincount+1)%2;
			Minimize(Mincount);
			break;
			/* [엑셀다운로드 버튼] */
		case "btn_downexcel":
			doActionIBSheet(rate_sheetObject,formObject,"DOWNEXCEL");     // DOWN XLS 시 CSV 로.

			break;
		case "btng_downexcel":
			var sheet2_count =rate_sheetObject.RowCount;
			//쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
			if(sheet2_count > 0){
				doActionIBSheet(rate_sheetObject,formObject,IBDOWNEXCEL);
			}
			break;
		case "btng_history":
			openRateHistory(rate_sheetObject);
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
    	break;
    case "RETRIEVE":
    	formObj.f_cmd.value = SEARCH02; 
    	formObj.grid_flg.value = 'Y';
    	
    	if (currenttab == 0) {
    		formObject.cur_page_cnt.value = formObject.cur_page_cnt1.value;
    		formObject.tot_page_cnt.value = formObject.tot_page_cnt1.value;
    	}else if (currenttab == 1) {
    		formObject.cur_page_cnt.value = formObject.cur_page_cnt2.value;
    		formObject.tot_page_cnt.value = formObject.tot_page_cnt2.value;
    	}else{
    		formObject.cur_page_cnt.value = formObject.cur_page_cnt3.value;
    		formObject.tot_page_cnt.value = formObject.tot_page_cnt3.value;
    	}
    	
    	sheetObj.DoSearch4Post("ESD_TRS_0229GS.do", TrsFrmQryString(formObj));
    	break;
    case "DOWNEXCEL":
		ComOpenWait(true);
		formObj.f_cmd.value = SEARCH03;
	    formObj.grid_flg.value = 'N';
	    formObj.target = "_blank"
		formObj.action = "ESD_TRS_0229DL.do";
	    formObj.submit();
	    ComOpenWait(false);
    	break;
    case IBDOWNEXCEL:
        sheetObj.Down2Excel(-1, false, false, true);
        break;
    }
}

function doSearch() {
	  var sheetObject = sheetObjects[0];
	  var formObject  = document.form;
	  doActionIBSheet(sheetObject, formObject, IBSEARCH, "", "");
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
     * 조회후 발생하는 EVENT
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
    function sheet2_OnSearchEnd(sheetObj,errMsg){
    	//RowCount
    	var formObj = document.form;
    	var cmd = formObj.f_cmd.value;
    	var cur_page = formObj.cur_page_cnt1.value;
    	if( cmd == SEARCH02 && sheetObj.RowCount > 0 && cur_page == "1") {
    		var tot_cnt = sheetObj.EtcData('TOT_CNT');
        	formObj.tot_page_cnt1.value = tot_cnt;
    	}
    }
     
     /**
     * 조회후 발생하는 EVENT
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
    function sheet3_OnSearchEnd(sheetObj,errMsg){
    	//RowCount
    	var formObj = document.form;
    	var cmd = formObj.f_cmd.value;
    	var cur_page = formObj.cur_page_cnt2.value;
    	if( cmd == SEARCH02 && sheetObj.RowCount > 0 && cur_page == "1") {
        	var tot_cnt = sheetObj.EtcData('TOT_CNT');
        	formObj.tot_page_cnt2.value = tot_cnt;
    	}
    }

     /**
     * 조회후 발생하는 EVENT
     * IBSheetConfig.js에서 DataSheetObject.prototype.event_OnSearchEnd에서 정의
     */
     function sheet4_OnSearchEnd(sheetObj,errMsg){
    	 //RowCount
    	 var formObj = document.form;
    	 var cmd = formObj.f_cmd.value;
    	 var cur_page = formObj.cur_page_cnt3.value;
    	 if( cmd == SEARCH02 && sheetObj.RowCount > 0 && cur_page == "1") {
    		 var tot_cnt = sheetObj.EtcData('TOT_CNT');
    		 formObj.tot_page_cnt2.value = tot_cnt;
    	 }
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
    	 if( sheetObj.ColSaveName(col) == "fm_nod_cd" ) {
    		 var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd").toUpperCase(), " ");
    		 sheetObj.CellValue2(row, "fm_nod_cd") = lvfm;
    		 if( doengnumcheck(lvfm) ) {
    			 if( lvfm.length == 5 ) {
    				 getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yd", lvfm); //Varidation check
    				 if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
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
    		 if( value.length > 0 ) {
    			 getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
    		 } else {
    			 sheetObj.CellValue2(row, "fm_nod_cd") = "";
    		 }
    	 } else if( sheetObj.ColSaveName(col) == "to_nod_yd" ) {
    		 value = doSepRemove(sheetObj.CellValue(row, "to_nod_cd"), " ");
    		 if( value.length > 0 ) {
    			 getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
    		 } else {
    			 sheetObj.CellValue2(row, "to_nod_cd") = "";
    		 }
    	 } else if (sheetObj.ColSaveName(col) == "via_nod_yd" ) {
    		 value = doSepRemove(sheetObj.CellValue(row, "via_nod_cd"), " ");
    		 if( value.length > 0 ) {
    			 getYardSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
    		 } else {
    			 sheetObj.CellValue2(row, "via_nod_cd") = "";
    		 }
    	 } else if( sheetObj.ColSaveName(col) == "dor_nod_yd" ) {
    		 value = doSepRemove(sheetObj.CellValue(row, "dor_nod_cd"), " ");
    		 if( value.length > 0 ) {
    			 getZoneSheetCombo(sheetObj, document.form, row, sheetObj.ColSaveName(col), value);
    		 } else {
    			 sheetObj.CellValue2(row, "dor_nod_cd") = "";
    		 }
    	 }
     }

     /**
      * Sheet 확대/축소
      */
     function Minimize(nItem) {
    	 var objs = document.all.item("MiniLayer");
    	 if( nItem == "1" ) {
    		 objs.style.display = "none";
    		 sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(22);
    		 sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(26);
    		 sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(26);
    	 } else {
    		 objs.style.display = "inline";
    		 sheetObjects[2].style.height = sheetObjects[2].GetSheetHeight(17);
    		 sheetObjects[3].style.height = sheetObjects[3].GetSheetHeight(21);
    		 sheetObjects[4].style.height = sheetObjects[4].GetSheetHeight(21);
    	 }
     }

     function openRateHistory(sheetObject)
     {
    	 var formObj = document.form;
    	 var checkList = sheetObject.FindCheckedRow('chk');
    	 var checkArray = checkList.split('|');
    	 var resultcheck = 0;

    	 if(checkList.length < 1) {
    		 ComShowCodeMessage('TRS90215'); 
    		 return;
    	 }

    	 var agmt_no = formObj.fm_agmtno.value;
    	 var trsp_agmt_rt_tp_cd = formObj.fm_trsp_agmt_rt_tp_cd.value;
    	 var trsp_cost_mod_cd = sheetObject.CellValue(checkArray[0], 'trsp_cost_mod_cd');
    	 var agmt_trsp_tp_cd  = sheetObject.CellValue(checkArray[0], 'agmt_trsp_tp_cd'); //최초 데이타생성한 ofc
    	 var cgo_tp_cd = sheetObject.CellValue(checkArray[0], 'cgo_tp_cd');
    	 var cust_cd     = sheetObject.CellValue(checkArray[0], 'cust_cd');
    	 var cmdt_grp_cd = sheetObject.CellValue(checkArray[0], 'cmdt_grp_cd');
    	 var rail_svc_tp_cd = sheetObject.CellValue(checkArray[0], 'rail_svc_tp_cd');
    	 var fm_nod_cd = sheetObject.CellValue(checkArray[0], 'fm_nod_cd');
    	 var fm_nod_yd = sheetObject.CellValue(checkArray[0], 'fm_nod_yd');
    	 var via_nod_cd = sheetObject.CellValue(checkArray[0], 'via_nod_cd');
    	 var via_nod_yd = sheetObject.CellValue(checkArray[0], 'via_nod_yd');
    	 var dor_nod_cd = sheetObject.CellValue(checkArray[0], 'dor_nod_cd');
    	 var dor_nod_yd = sheetObject.CellValue(checkArray[0], 'dor_nod_yd');
    	 var to_nod_cd  = sheetObject.CellValue(checkArray[0], 'to_nod_cd');
    	 var to_nod_yd  = sheetObject.CellValue(checkArray[0], 'to_nod_yd');

    	 var trsp_scg_cd  = sheetObject.CellValue(checkArray[0], 'trsp_scg_cd');
    	 var agmt_route_all_flg  = sheetObject.CellValue(checkArray[0], 'agmt_route_all_flg');

    	 formObj.chk_trsp_cost_mod_cd.value = trsp_cost_mod_cd   ;
    	 formObj.chk_agmt_trsp_tp_cd.value = agmt_trsp_tp_cd    ;
    	 formObj.chk_cgo_tp_cd.value = cgo_tp_cd          ;
    	 formObj.chk_cust_cd.value = cust_cd            ;
    	 formObj.chk_cmdt_grp_cd.value = cmdt_grp_cd        ;
    	 formObj.chk_rail_svc_tp_cd.value = rail_svc_tp_cd     ;
    	 formObj.chk_fm_nod_cd.value = fm_nod_cd          ;
    	 formObj.chk_fm_nod_yd.value = fm_nod_yd          ;
    	 formObj.chk_via_nod_cd.value = via_nod_cd         ;
    	 formObj.chk_via_nod_yd.value = via_nod_yd         ;
    	 formObj.chk_dor_nod_cd.value = dor_nod_cd         ;
    	 formObj.chk_dor_nod_yd.value = dor_nod_yd         ;
    	 formObj.chk_to_nod_cd.value = to_nod_cd          ;
    	 formObj.chk_to_nod_yd.value = to_nod_yd          ;
    	 formObj.chk_trsp_scg_cd.value = trsp_scg_cd;
    	 formObj.chk_agmt_route_all_flg.value = agmt_route_all_flg;

    	 if(checkArray.length > 1){
    		 resultcheck = 1;
    		 for(var i=0; i<checkArray.length-1; i++){
    			 if(sheetObject.CellValue(checkArray[0], 'trsp_cost_mod_cd') == sheetObject.CellValue(checkArray[i], 'trsp_cost_mod_cd')){                
    			 }else{
    				 resultcheck++;
    			 }
    		 }
    	 }
    	 if(resultcheck == 1){
    		 var myOption = "width=980,height=530,menubar=0,status=0,scrollbars=0,resizable=0";
    		 var param = "?gubun=notsave&"+TrsFrmQryString(formObj);
    		 myWin = window.open('/hanjin/ESD_TRS_0230.do' + param, "Hispopup", myOption);  		
    	 }else if(resultcheck == 0){
    		 ComShowCodeMessage('TRS90215');
    	 }else if(resultcheck > 1){
    		 ComShowCodeMessage('TRS90357');
    	 }
     }
     
     /**
     * Onkeydown 이벤트 관련
     */
     function gotopage(){
     	var formObject = document.form;
     	var tot_page = "";
     	var cur_page = "";
     	var rate_sheetObject = sheetObjects[2]; //Agreement Rate정보
     	if (currenttab == 0) {
     		rate_sheetObject = sheetObjects[2]; //Agreement Rate정보
     		cur_page = formObject.cur_page_cnt1.value;
     		tot_page = formObject.tot_page_cnt1.value;
        }else if (currenttab == 1) {
        	rate_sheetObject = sheetObjects[3]; //Agreement Rate정보
        	cur_page = formObject.cur_page_cnt2.value;
        	tot_page = formObject.tot_page_cnt2.value;
        }else{
        	rate_sheetObject = sheetObjects[4]; //Agreement Rate정보
        	cur_page = formObject.cur_page_cnt3.value;
        	tot_page = formObject.tot_page_cnt3.value;
        }
     	if( (Number(cur_page) > Number(tot_page)) || tot_page < 1){
     		var errMessage = ComGetMsg('TRS90351','','','');  
     		ComShowMessage(errMessage);
     		return;
     	}
     	doActionIBSheet(rate_sheetObject,formObject,"RETRIEVE"); 
     }