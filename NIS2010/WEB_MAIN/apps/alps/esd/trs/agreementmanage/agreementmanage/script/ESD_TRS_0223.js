/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TRS_0223.js
*@FileTitle : Agreement USA Rail Surcharge
*Open Issues :
*Change history :
*@LastModifyDate : 2011-05-11
*@LastModifier : 민정호
*@LastVersion : 1.2
*
* 2010-03-18 cjh	   	1.0  최초 생성
* 2010-08-12 Sun, CHOI	1.1 Agreement Reference No 조회 컬럼 추가 및 조회 조건 추가
* 2011.05.11 민정호            1.2 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
* 2012.10.04 김현화[CHM-201220202-01]US Rail incentive function 추가 요청 
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
	  case 1: //sheet1 init ( Rate )
		  with (sheetObj) {
			  style.height    = 330; // 높이 설정
			  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
			  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
			  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
			  Editable = true; //전체Edit 허용 여부 [선택, Default false]
			  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			  InitColumnInfo(24, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
			  // 해더에서 처리할 수 있는 각종 기능을 설정한다
			  InitHeadMode(true, true, true, true, false,false)
			  var HeadTitle1 = "|Status|Verification Result|DB Duplication|Rail Company|Rail Company|Agreement\nNo.|Reference\nNo.|Route|Route|Route|Route|Route|Cargo\Type|Ratio(%)|Effective Date|Effective Date|Decimal|Creation\nDate|Update\nDate|Eq Size|Seq" ;
			  var HeadTitle2 = "|Status|Description|DB Duplication|Code|Name|Agreement\nNo.|Reference\nNo.|All|ORG Loc|ORG Node|DEST Loc|DEST Node|Cargo\Type|Ratio(%)|From|To|Decimal|Creation\nDate|Update\nDate|Eq Size|Seq" ;
		
			  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			  InitHeadRow(0, HeadTitle1, true);
			  InitHeadRow(1, HeadTitle2, true);
		
			  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
			  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter, true,           "ibflag",  false,    "",  dfNone,     0,      true,   true,    0,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,   true,              "rlt",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      100,  daLeft,   true,             "rlt2",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       60,  daLeft,   true,         "vndr_seq",  false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      140,  daLeft,   true,          "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtPopup,      80,  daCenter, true,          "agmt_no",  false,    "",  dfNone,     0,     false,   true,    9,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       90,  daLeft,   true,      "agmt_ref_no",  false,    "",	 dfNone,   	 0,     false,   false,   9,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtCheckBox,   50,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,     false,   true );
			  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "fm_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "fm_nod_yard",  false,    "",  dfNone, 	 0, 	false, 	 true);
			  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "to_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "to_nod_yard",  false, 	"",  dfNone, 	 0, 	false, 	 true);
			  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,     false,   true,    1,   false,   true,     "",    false);		
			  InitDataProperty(0, cnt++ , dtData,       80,   daRight, true,    "trsp_rail_rto",  false,    "",dfNullFloat,  2,      true,   true,    5,   false,   true,     "",    false);
		      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_fm_dt",  false,    "",dfDateYmd,     0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
		      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_to_dt",  false,    "",dfDateYmd,     0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
		      InitDataProperty(0, cnt++ , dtData,       80,   daRight, true,      "rail_rto_no",  false,    "",  dfNone,     0,      true,   true,    4,   false,   true,     "",    false);
		      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_cre_dt",  false,    "",dfUserFormat2,    0,     false,  false);
		      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_upd_dt",  false,    "",dfUserFormat2,    0,     false,  false);		      
		      InitDataProperty(0, cnt++ , dtData,       30,  daCenter, true,    "agmt_eq_sz_no",  false,    "",	 dfNone,     0,     false,  false);
		      InitDataProperty(0, cnt++ , dtDataSeq,    30,  daCenter, true,      	   "row_no",  false,    "",	 dfNone,     0,      true,   true);
		      InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter, true,            "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
		      InitDataProperty(0, cnt++ , dtHidden,     30,  daCenter, true,"trsp_agmt_scg_seq",  false,    "",	 dfNone,     0,     false,  false);
		      
		      InitUserFormat2(0, "locl_cre_dt", "####-##-## ##:##:##", "-|:" );
		      InitUserFormat2(0, "locl_upd_dt", "####-##-## ##:##:##", "-|:" );
		      InitDataCombo(0, 'cgo_tp_cd', " |FULL|EMPTY", " |F|M");
		      sheetObj.ColHidden("agmt_eq_sz_no") = true;
		      sheetObj.ColHidden("row_no") = true;
		      sheetObj.ColHidden("ck_vf") = true;
		  }
		  break;
  
	  case 2: //sheet2 init ( ATMT Header ) Hidden Sheet
		  with (sheetObj) {
			  style.height    = 330; // 높이 설정
			  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
			  if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
			  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
			  Editable = true; //전체Edit 허용 여부 [선택, Default false]
			  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
			  InitColumnInfo(30, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
		
			  var HeadTitle1 = "|Status|Verification Result|DB Duplication|Rail Company|Rail Company|Agreement\nNo.|Reference\nNo.|Surcharge\nKind|Route|Route|Route|Route|Route|Cargo\Type|Over Weight\n(LBS)|Total Amount|Total Amount|Total Amount|Total Amount|Total Amount|Effective Date|Effective Date|Decimal\n(FUM Only)|Creation\nDate|Update\nDate|Eq Size|Seq" ;
			  var HeadTitle2 = "|Status|Description|DB Duplication|Code|Name|Agreement\nNo.|Reference\nNo.|Surcharge\nKind|All|ORG Loc|ORG Node|DEST Loc|DEST Node|Cargo\Type|Over Weight\n(LBS)|Cur|All|20'|40'|45'|From|To|Decimal\n(FUM Only)|Creation\nDate|Update\nDate|Eq Size|Seq" ;
		
			  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			  InitHeadRow(0, HeadTitle1, true);
			  InitHeadRow(1, HeadTitle2, true);
		
			  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,     KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN,      FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
			  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter, true,           "ibflag",  false,    "",  dfNone,     0,      true,   true,    0,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,   true,              "rlt",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      100,  daLeft,   true,             "rlt2",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       60,  daLeft,   true,         "vndr_seq",  false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,      140,  daLeft,   true,          "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtPopup,      80,  daCenter, true,          "agmt_no",  false,    "",  dfNone,     0,     false,   true,    9,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       90,  daLeft,   true,      "agmt_ref_no",  false,    "",	 dfNone,   	 0,     false,   false,   9,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true, "trsp_rail_scg_cd",  false,    "",  dfNone,     0,     false,   true,    3,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtCheckBox,   50,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,     false,   true );
			  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "fm_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "fm_nod_yard",  false,    "",  dfNone, 	 0, 	false, 	 true);
			  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "to_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "to_nod_yard",  false, 	"",  dfNone, 	 0, 	false, 	 true);
			  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,     false,   true,    1,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       80,  daCenter, true,      "lbs_ovr_wgt",  false,    "",dfNullFloat,  3,      true,   true,    9,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtCombo,      50,  daCenter, true,          "curr_cd",  false,    "",  dfNone,     0,      true,   true,    3,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,   	60,  daCenter, true,    "fx_scg_all_rt",  false,    "",dfNullFloat,	 3,      true,   true,   15,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,    "fx_scg_20ft_rt", false,    "",dfNullFloat,  3,      true,   true,   15,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,    "fx_scg_40ft_rt", false,    "",dfNullFloat,  3,      true,   true,   15,   false,   true,     "",    false);
			  InitDataProperty(0, cnt++ , dtData,       60,  daCenter, true,    "fx_scg_45ft_rt", false,    "",dfNullFloat,  3,      true,   true,   15,   false,   true,     "",    false);
		      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,        "eff_fm_dt",  false,    "",dfDateYmd,    0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
		      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,        "eff_to_dt",  false,    "",dfDateYmd,    0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
		      InitDataProperty(0, cnt++ , dtData,       80,   daRight, true,      "rail_rto_no",  false,    "",  dfNone,     0,      true,   true,    4,   false,   true,     "",    false);
		      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_cre_dt",  false,    "",dfUserFormat2,    0,     false,  false);
		      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_upd_dt",  false,    "",dfUserFormat2,    0,     false,  false);
		      InitDataProperty(0, cnt++ , dtData,       30,  daCenter, true,    "agmt_eq_sz_no",  false,    "",	 dfNone,     0,     false,  false);
		      InitDataProperty(0, cnt++ , dtDataSeq,    30,  daCenter, true,      	   "row_no",  false,    "",	 dfNone,     0,     false,  false);
		      InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter, true,            "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
		      InitDataProperty(0, cnt++ , dtHidden,     30,  daCenter, true,"trsp_agmt_scg_seq",  false,    "",	 dfNone,     0,     false,  false);
		      
		      InitUserFormat2(0, "locl_cre_dt", "####-##-## ##:##:##", "-|:" );
		      InitUserFormat2(0, "locl_upd_dt", "####-##-## ##:##:##", "-|:" );
		      InitDataCombo(0, 'cgo_tp_cd', " |FULL|EMPTY", " |F|M");
		      InitDataCombo(0, 'curr_cd', " |" +default_currText, " |"+default_currCode);
		      InitDataCombo(0, 'trsp_rail_scg_cd', " |OWS|HZS|FUM|TTL",	" |OWS|HZS|FUM|TTL");
		      sheetObj.ColHidden("agmt_eq_sz_no") = true;
		      sheetObj.ColHidden("row_no") = true;
		      sheetObj.ColHidden("ck_vf") = true;
		  }
		  break;
		  
	  case 3: //sheet3 init
	  with (sheetObj) {
		  style.height    = 330; // 높이 설정
		  SheetWidth      = mainTable.clientWidth; //전체 너비 설정
		   if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path); //Host정보 설정[필수][HostIp, Port, PagePath]
		  MergeSheet = msHeaderOnly; //전체Merge 종류 [선택, Default msNone]
		  Editable = true; //전체Edit 허용 여부 [선택, Default false]
		  InitRowInfo( 2, 1, 9, 100); //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
		  InitColumnInfo(23, 4, 0, true); //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
	
		  // 해더에서 처리할 수 있는 각종 기능을 설정한다
		  InitHeadMode(true, true, true, true, false,false)
		  var HeadTitle1 = "|Status|Verification Result|DB Duplication|Rail Company|Rail Company|Agreement\nNo.|Reference\nNo.|Route|Route|Route|Route|Route|Cargo\Type|Ratio(%)|Effective Date|Effective Date|Creation\nDate|Update\nDate|Eq Size|Seq" ;
		  var HeadTitle2 = "|Status|Description|DB Duplication|Code|Name|Agreement\nNo.|Reference\nNo.|All|ORG Loc|ORG Node|DEST Loc|DEST Node|Cargo\Type|Ratio(%)|From|To|Creation\nDate|Update\nDate|Eq Size|Seq" ;
	
		  //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
		  InitHeadRow(0, HeadTitle1, true);
		  InitHeadRow(1, HeadTitle2, true);
	
		  //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		  InitDataProperty(0, cnt++ , dtCheckBox,   30,  daCenter, true,              "chk",  false,    "",  dfNone,     0,      true,   true );
		  InitDataProperty(0, cnt++ , dtStatus,     45,  daCenter, true,           "ibflag",  false,    "",  dfNone,     0,      true,   true,    0,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      170,  daLeft,   true,              "rlt",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      100,  daLeft,   true,             "rlt2",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,       60,  daLeft,   true,         "vndr_seq",  false,    "",  dfNone,     0,     false,  false,    6,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,      140,  daLeft,   true,          "vndr_nm",  false,    "",  dfNone,     0,     false,  false,  200,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtPopup,      80,  daCenter, true,          "agmt_no",  false,    "",  dfNone,     0,     false,   true,    9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData,       90,  daLeft,   true,      "agmt_ref_no",  false,    "",	 dfNone,   	 0,     false,   false,   9,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtCheckBox,   50,  daCenter, true,"agmt_rout_all_flg",  false,    "",  dfNone,     0,     false,   true );
		  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "fm_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "fm_nod_yard",  false,    "",  dfNone, 	 0, 	false, 	 true);
		  InitDataProperty(0, cnt++ , dtData,       65,  daCenter, true,        "to_nod_cd",  false,    "",dfEngUpKey,   0,     false,   true,    5,   false,   true,     "",    false);
		  InitDataProperty(0, cnt++ , dtData, 		65,  daCenter, true, 	  "to_nod_yard",  false, 	"",  dfNone, 	 0, 	false, 	 true);
		  InitDataProperty(0, cnt++ , dtCombo,      80,  daCenter, true,        "cgo_tp_cd",  false,    "",  dfNone,     0,     false,   true,    1,   false,   true,     "",    false);		
		  InitDataProperty(0, cnt++ , dtData,       80,   daRight, true,    "trsp_rail_rto",  false,    "",dfNullFloat,  4,      true,   true,    7,   false,   true,     "",    false);
	      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_fm_dt",  false,    "",dfDateYmd,     0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
	      InitDataProperty(0, cnt++ , dtData,       75,  daCenter, true,       "eff_to_dt",  false,    "",dfDateYmd,     0,      true,   true,    8,   false,   true,     "Effective period of this rate",   false);
	     // InitDataProperty(0, cnt++ , dtData,       80,   daRight, true,      "rail_rto_no",  false,    "",  dfNone,     0,      true,   true,    4,   false,   true,     "",    false);
	      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_cre_dt",  false,    "",dfUserFormat2,    0,     false,  false);
	      InitDataProperty(0, cnt++ , dtData,      110,  daCenter, true,      "locl_upd_dt",  false,    "",dfUserFormat2,    0,     false,  false);		      
	      InitDataProperty(0, cnt++ , dtData,       30,  daCenter, true,    "agmt_eq_sz_no",  false,    "",	 dfNone,     0,     false,  false);
	      InitDataProperty(0, cnt++ , dtDataSeq,    30,  daCenter, true,      	   "row_no",  false,    "",	 dfNone,     0,      true,   true);
	      InitDataProperty(0, cnt++ , dtCheckBox,   60,  daCenter, true,            "ck_vf",  false,    "",  dfNone,     0,      true,   true,    8,   false,  false,     "",    false);
	      InitDataProperty(0, cnt++ , dtHidden,     30,  daCenter, true,"trsp_agmt_scg_seq",  false,    "",	 dfNone,     0,     false,  false);
	      
	      InitUserFormat2(0, "locl_cre_dt", "####-##-## ##:##:##", "-|:" );
	      InitUserFormat2(0, "locl_upd_dt", "####-##-## ##:##:##", "-|:" );
	      InitDataCombo(0, 'cgo_tp_cd', " |FULL|EMPTY", " |F|M");
	      sheetObj.ColHidden("agmt_eq_sz_no") = true;
	      sheetObj.ColHidden("row_no") = true;
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
    getRailVendorComboList(document.rail_road_code , rail_road_codeCode , rail_road_codeText , ''); // Serveic Provider 멀티 콤보 (Rail Load) 설정
	initVendorCombo(document.rail_road_code);       // 공통스크립트

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
    var sheetObject = sheetObjects[0];
    var sheetObject1 = sheetObjects[1];
    var sheetObject2 = sheetObjects[2];

    var rate_sheetObject = sheetObjects[0]; //Fuel Surcharge
    if (currenttab == 0) {
    	rate_sheetObject = sheetObjects[0]; //Fuel Surcharge
    }else if(currenttab == 1){
    	rate_sheetObject = sheetObjects[1]; //Fixed Surcharge
    }else if(currenttab == 2){
    	rate_sheetObject = sheetObjects[2]; // Incentive Surcharge
    }
    
    /*******************************************************/
    var formObject = document.form;

   try {
       var srcName = window.event.srcElement.getAttribute("name");
       switch(srcName) {
			/* [1.1.조회로직] */
			case "btn_retrieve":
				if( tabObjects[0].SelectedIndex == "0" ) {
					if( validateFormSearch(formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSEARCH, "FUEL");						
					}											
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					if( validateFormSearch(formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSEARCH, "FIXED");						
					}											
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					if( validateFormSearch(formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSEARCH, "INCENTIVE");						
					}											
				}		
			break;

			/* [1.2.minimize버튼-화면최소화] */
			case "btn_minimize":
				Mincount = (Mincount+1)%2;
				Minimize(Mincount);
			break;
			
			/* [1.3.상단의 Agreement No.버튼] */
			case "btn_agmtno":
				openAgmtNo();
			break;

			/* [2.1.하단 Popup 버튼] */
			case "btng_history":
				if( validateFormPop(rate_sheetObject) ){
					var myWindow = null;	
					var url = null;
					
					var checkList = rate_sheetObject.FindCheckedRow('chk');
					var checkArray = checkList.split('|');
					
					if( tabObjects[0].SelectedIndex == "0" ) {						
						for( var i=0; i<checkArray.length-1; i++ ){
							url = '?gubun=save&agmt_no='+rate_sheetObject.CellValue(checkArray[i], "agmt_no");
							url += '&vndr_seq='+rate_sheetObject.CellValue(checkArray[i], "vndr_seq");
							url += '&trsp_rail_scg_cd='+'FSG';
							url += '&agmt_rout_all_flg='+rate_sheetObject.CellValue(checkArray[i], "agmt_rout_all_flg");
							url += '&fm_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "fm_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "fm_nod_yard");
							url += '&to_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "to_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "to_nod_yard");
							url += '&cgo_tp_cd='+rate_sheetObject.CellValue(checkArray[i], "cgo_tp_cd");					
							url += '&eff_fm_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_fm_dt");
							url += '&eff_to_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_to_dt");
						}
						
						myWindow = window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=430");
						myWindow.focus();
					}else if ( tabObjects[0].SelectedIndex == "1" ){
						for( var i=0; i<checkArray.length-1; i++ ){
							url = '?gubun=save&agmt_no='+rate_sheetObject.CellValue(checkArray[i], "agmt_no");
							url += '&vndr_seq='+rate_sheetObject.CellValue(checkArray[i], "vndr_seq");
							url += '&trsp_rail_scg_cd='+rate_sheetObject.CellValue(checkArray[i], "trsp_rail_scg_cd");
							url += '&agmt_rout_all_flg='+rate_sheetObject.CellValue(checkArray[i], "agmt_rout_all_flg");
							url += '&fm_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "fm_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "fm_nod_yard");
							url += '&to_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "to_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "to_nod_yard");
							url += '&cgo_tp_cd='+rate_sheetObject.CellValue(checkArray[i], "cgo_tp_cd");
							url += '&eff_fm_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_fm_dt");
							url += '&eff_to_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_to_dt");
						}
						
						myWindow = window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=430");
						myWindow.focus();					
					}else if( tabObjects[0].SelectedIndex == "2" ) {						
						for( var i=0; i<checkArray.length-1; i++ ){
							url = '?gubun=save&agmt_no='+rate_sheetObject.CellValue(checkArray[i], "agmt_no");
							url += '&vndr_seq='+rate_sheetObject.CellValue(checkArray[i], "vndr_seq");
							url += '&trsp_rail_scg_cd='+'ISG';
							url += '&agmt_rout_all_flg='+rate_sheetObject.CellValue(checkArray[i], "agmt_rout_all_flg");
							url += '&fm_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "fm_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "fm_nod_yard");
							url += '&to_nod_cd='+rate_sheetObject.CellValue(checkArray[i], "to_nod_cd")+rate_sheetObject.CellValue(checkArray[i], "to_nod_yard");
							url += '&cgo_tp_cd='+rate_sheetObject.CellValue(checkArray[i], "cgo_tp_cd");					
							url += '&eff_fm_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_fm_dt");
							url += '&eff_to_dt='+rate_sheetObject.CellValue(checkArray[i], "eff_to_dt");
						}
						
						myWindow = window.open('ESD_TRS_0234.do'+url, "scgPop", "scroll=no,status=no,help=no,width=900,height=430");
						myWindow.focus();
					}					
				}								
			break;
			
			/* [2.2.하단 로우추가버튼] */
			case "btng_rowadd":
				doActionIBSheet(rate_sheetObject,formObject,IBINSERT);
			break;
			
			/* [2.3.하단 로우삭제버튼] */
			case "btng_delete":
				if(!confirm(ComGetMsg('COM12165', 'AGMT Surcharge')) ) return false;
				if( tabObjects[0].SelectedIndex == "0" ) {
					if( validateFormDel(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "FUEL");						
					}															
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					if( validateFormDel(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "FIXED");						
					}					
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					if( validateFormDel(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBDELETE, "INCENTIVE");						
					}					
				}
			break;

			/* [2.4.하단 저장버튼] */
			case "btng_update":
				if( tabObjects[0].SelectedIndex == "0" ) {
					if( validateForm(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSAVE, "FUEL");
					}														
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					if( validateForm(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSAVE, "FIXED");						
					}					
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					if( validateForm(rate_sheetObject, formObject) ) {
						doActionIBSheet(rate_sheetObject, formObject, IBSAVE, "INCENTIVE");						
					}					
				}
			break;
			
			/* [2.5.하단 엑셀파일추가] */
			case "btng_loadexcel":
				if( tabObjects[0].SelectedIndex == "0" ) {
					doActionIBSheet(rate_sheetObject, formObject, IBLOADEXCEL, "FUEL");														
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					doActionIBSheet(rate_sheetObject, formObject, IBLOADEXCEL, "FIXED");
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					doActionIBSheet(rate_sheetObject, formObject, IBLOADEXCEL, "INCENTIVE");
				}
			break;
			
			/* [2.5.하단의 verify 단계버튼] */
			case "btng_verify":
				if( tabObjects[0].SelectedIndex == "0" ) {
					valcheck_two1(rate_sheetObject);														
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					valcheck_two2(rate_sheetObject);					
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					valcheck_two3(rate_sheetObject);					
				}
			break;
			
			/* [2.6.하단의 Sheet 초기화  버튼] */
			case "btng_reset":
				if( tabObjects[0].SelectedIndex == "0" ) {	
					rate_sheetObject.RemoveAll();
				}else if ( tabObjects[0].SelectedIndex == "1" ){	
					rate_sheetObject.RemoveAll();
				}else if ( tabObjects[0].SelectedIndex == "2" ){	
					rate_sheetObject.RemoveAll();
				}
			break;
			
			/* [2.7.엑셀다운로드 버튼] */
			case "btng_downexcel":
				if( tabObjects[0].SelectedIndex == "0" ) {
					doActionIBSheet(rate_sheetObject, formObject, IBDOWNEXCEL, "FUEL");
				}else if ( tabObjects[0].SelectedIndex == "1" ){
					doActionIBSheet(rate_sheetObject, formObject, IBDOWNEXCEL, "FIXED");					
				}else if ( tabObjects[0].SelectedIndex == "2" ){
					doActionIBSheet(rate_sheetObject, formObject, IBDOWNEXCEL, "INCENTIVE");					
				}
			break;
				
			/* [3.1. 상단 날짜버튼] */
			case "btns_calendar":
				var cal = new ComCalendar();
        		cal.select(formObject.eff_dt, 'yyyy-MM-dd');
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

function doActionIBSheet(sheetObj,formObj,sAction,srcName) {
    sheetObj.ShowDebugMsg = false;
	var formObject = document.form;
	var x1 ="";

	switch(sAction) {
		case IBSEARCH:
			switch(srcName) {
				case "FUEL":
					formObj.f_cmd.value = SEARCH01;
					sheetObj.DoSearch4Post("ESD_TRS_0223GS.do", TrsFrmQryString(formObj));
				break;
				
				case "FIXED":
					formObj.f_cmd.value = SEARCH02;
					sheetObj.DoSearch4Post("ESD_TRS_0223GS.do", TrsFrmQryString(formObj));
				break;
				case "INCENTIVE":
					formObj.f_cmd.value = SEARCH05;
					sheetObj.DoSearch4Post("ESD_TRS_0223GS.do", TrsFrmQryString(formObj));
				break;
			}
			break;
		case IBINSERT:
			var row = 0;
			row = sheetObj.DataInsert(-1);
			sheetObj.CellValue2(row,'ck_vf') = 1;
			sheetObj.CellValue2(row,'agmt_eq_sz_no') = "00";
			break;
		case IBDELETE:
			switch(srcName) {
				case "FUEL":
					formObj.f_cmd.value = REMOVE01;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
				break;
				
				case "FIXED":
					formObj.f_cmd.value = REMOVE02;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
				break;
				
				case "INCENTIVE":
					formObj.f_cmd.value = REMOVE03;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), "chk", false, true);
				break;
			}
			break;
		case IBSAVE:	
			switch(srcName) {
				case "FUEL":
					formObj.f_cmd.value = MULTI01;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), -1, false, true);
				break;
				
				case "FIXED":
					formObj.f_cmd.value = MULTI02;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), -1, false, true);
				break;
				
				case "INCENTIVE":
					formObj.f_cmd.value = MULTI03;
					sheetObj.DoSave("ESD_TRS_0223GS.do", TrsFrmQryString(formObj), -1, false, true);
				break;
			}
			break;
		case IBLOADEXCEL:
			switch(srcName) {
				case "FUEL":
					sheetObj.LoadExcel();
					for(var k=sheetObj.HeaderRows; k<sheetObj.RowCount+sheetObj.HeaderRows; k++)
					{
						sheetObj.CellValue2(k,'ck_vf') = 1;
						sheetObj.CellValue2(k,'agmt_eq_sz_no') = "00";
					}
				break;
				
				case "FIXED":
					sheetObj.LoadExcel();
					for(var k=sheetObj.HeaderRows; k<sheetObj.RowCount+sheetObj.HeaderRows; k++)
					{
						sheetObj.CellValue2(k,'ck_vf') = 1;
						
						if( sheetObj.CellValue(k,'trsp_rail_scg_cd') == "OWS" ){
							if( sheetObj.CellValue(k,'fx_scg_all_rt') != "" ){
								sheetObj.CellValue(k,'agmt_eq_sz_no') = "AL";									
							}else if( sheetObj.CellValue(k,'fx_scg_20ft_rt') != "" ){
								sheetObj.CellValue(k,'agmt_eq_sz_no') = "20";								
							}else if( sheetObj.CellValue(k,'fx_scg_40ft_rt') != "" ){
								sheetObj.CellValue(k,'agmt_eq_sz_no') = "40";
							}else if( sheetObj.CellValue(k,'fx_scg_45ft_rt') != "" ){
								sheetObj.CellValue(k,'agmt_eq_sz_no') = "45";								
							}						
						}else{
							sheetObj.CellValue(k,'agmt_eq_sz_no') = "00";							
						}						
					}
				break;
				case "INCENTIVE":
					sheetObj.LoadExcel();
					for(var k=sheetObj.HeaderRows; k<sheetObj.RowCount+sheetObj.HeaderRows; k++)
					{
						sheetObj.CellValue2(k,'ck_vf') = 1;
						sheetObj.CellValue2(k,'agmt_eq_sz_no') = "00";
					}
				break;
			}
			break;
		case IBDOWNEXCEL:	
			switch(srcName) {
				case "FUEL":
					//sheetObj.Down2Excel(-1, false, false, true);
					sheetObj.speedDown2Excel(-1,false, false, "","",false, false,"", false,"","", false,"", true);
				break;
				
				case "FIXED":
					//sheetObj.Down2Excel(-1, false, false, true);
					sheetObj.speedDown2Excel(-1,false, false, "","",false, false,"", false,"","", false,"", true);
				break;
				
				case "INCENTIVE":
					sheetObj.speedDown2Excel(-1,false, false, "","",false, false,"", false,"","", false,"", true);
				break;
			}
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
 			InsertTab( cnt++ , "Fuel Surcharge" , -1 );
 			InsertTab( cnt++ , "Fixed Surcharge" , -1 );
 			InsertTab( cnt++ , "Incentive" , -1 );
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
 }

 /**
  * Sheet 확대/축소
  */
 function Minimize(nItem) {
 	var objs = document.all.item("MiniLayer");
 	if( nItem == "1" ) {
 		objs.style.display = "none";
 		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(20);
 		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(20);
 	} else {
 		objs.style.display = "inline";
 		sheetObjects[0].style.height = sheetObjects[0].GetSheetHeight(18);
 		sheetObjects[1].style.height = sheetObjects[1].GetSheetHeight(18);
 	}
 }

  /**
  * Rail Road combo 선택시 textfield의 값 변경하는 이벤트
  **/
  function rail_road_code_OnChange(combo, Index_Code, Text) {
  	if ( document.form.fm_vndr_nm.value == Text )  return;
  	document.form.fm_vndr_nm.value = combo.GetText(Index_Code,1);
  }
  
  /**
   * Sheet1에서 컬럼값 변경 이벤트를 발생시킴.
   */
  function sheet1_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) != "chk" ){
		sheetObj.CellValue2(row,'ck_vf') = 1;
		sheetObj.CellValue2(row,'rlt') = "";
		sheetObj.CellValue2(row,'rlt2') = "";
	}	
	
  	if( sheetObj.ColSaveName(col) == "agmt_rout_all_flg" ) {
  		if( value == "1" ) {
  			sheetObj.CellValue(row, "fm_nod_cd") = "";
  			sheetObj.CellValue(row, "fm_nod_yard") = "";
  			sheetObj.CellValue(row, "to_nod_cd") = "";
  			sheetObj.CellValue(row, "to_nod_yard") = "";
  			sheetObj.CellEditable(row, "fm_nod_cd") = false;
  			sheetObj.CellEditable(row, "fm_nod_yard") = false;
  			sheetObj.CellEditable(row, "to_nod_cd") = false;
  			sheetObj.CellEditable(row, "to_nod_yard") = false;
  		} else {
  			sheetObj.CellEditable(row, "fm_nod_cd") = true;
  			sheetObj.CellEditable(row, "fm_nod_yard") = true;
  			sheetObj.CellEditable(row, "to_nod_cd") = true;
  			sheetObj.CellEditable(row, "to_nod_yard") = true;
  		}
  	}else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ){
  		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd"), " ");
  		
  		if( lvfm.length == 5 ) {
  			getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
			if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
			} else {
				sheetObj.CellValue2(row, "fm_nod_yard") = "";					
			}  			
  		}else{
  			if( lvfm.length == 0 ) {
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"fm_nod_cd") = "";
				sheetObj.SelectCell(row,"fm_nod_cd");
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			}  			
  		}
  	}else if( sheetObj.ColSaveName(col) == "to_nod_cd" ){
  		var lvto = doSepRemove(sheetObj.CellValue(row,"to_nod_cd"), " ");
  		
  		if( lvto.length == 5 ) {
  			getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Validation check
			if( sheetObj.CellValue(row, "to_nod_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
			} else {
				sheetObj.CellValue2(row, "to_nod_yard") = "";					
			}  			
  		}else{
  			if( lvto.length == 0 ) {
				sheetObj.CellValue2(row, "to_nod_yard") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"to_nod_cd") = "";
				sheetObj.SelectCell(row,"to_nod_cd");
				sheetObj.CellValue2(row, "to_nod_yard") = "";
			}  			
  		}
  	}
  }
  
  /**
   * Sheet2에서 컬럼값 변경 이벤트를 발생시킴.
   */
  function sheet2_OnChange(sheetObj, row , col , value) {
	if( sheetObj.ColSaveName(col) != "chk" ){
		sheetObj.CellValue2(row,'ck_vf') = 1;
		sheetObj.CellValue2(row,'rlt') = "";
		sheetObj.CellValue2(row,'rlt2') = "";	
	}	
	
  	if( sheetObj.ColSaveName(col) == "agmt_rout_all_flg" ) {
  		if( value == "1" ) {
  			sheetObj.CellValue(row, "fm_nod_cd") = "";
  			sheetObj.CellValue(row, "fm_nod_yard") = "";
  			sheetObj.CellValue(row, "to_nod_cd") = "";
  			sheetObj.CellValue(row, "to_nod_yard") = "";
  			sheetObj.CellEditable(row, "fm_nod_cd") = false;
  			sheetObj.CellEditable(row, "fm_nod_yard") = false;
  			sheetObj.CellEditable(row, "to_nod_cd") = false;
  			sheetObj.CellEditable(row, "to_nod_yard") = false;
  		} else {
  			sheetObj.CellEditable(row, "fm_nod_cd") = true;
  			sheetObj.CellEditable(row, "fm_nod_yard") = true;
  			sheetObj.CellEditable(row, "to_nod_cd") = true;
  			sheetObj.CellEditable(row, "to_nod_yard") = true;
  		}
  	}else if( sheetObj.ColSaveName(col) == "fx_scg_all_rt" ){
  		if( sheetObj.CellValue(row, "fx_scg_all_rt") != "" ) {
  			sheetObj.CellValue(row, "fx_scg_20ft_rt") = "";
  			sheetObj.CellValue(row, "fx_scg_40ft_rt") = "";
  			sheetObj.CellValue(row, "fx_scg_45ft_rt") = "";
  			
  			if( sheetObj.CellValue(row, "trsp_rail_scg_cd") == "OWS" ){
  				sheetObj.CellValue(row,'agmt_eq_sz_no') = "AL";  				
  			}  			
  		}
  	}else if( sheetObj.ColSaveName(col) == "fx_scg_20ft_rt" ||
  				sheetObj.ColSaveName(col) == "fx_scg_40ft_rt" ||
  				sheetObj.ColSaveName(col) == "fx_scg_45ft_rt" ){
  		if( sheetObj.CellValue(row, "fx_scg_all_rt") != "" ) {
  			sheetObj.CellValue(row, "fx_scg_20ft_rt") = "";
  			sheetObj.CellValue(row, "fx_scg_40ft_rt") = "";
  			sheetObj.CellValue(row, "fx_scg_45ft_rt") = "";  			
  		}	
  		
  		if( sheetObj.CellValue(row, "trsp_rail_scg_cd") == "OWS" ){
  			if( sheetObj.CellValue(row, "fx_scg_20ft_rt") != "" ){
  	  			sheetObj.CellValue(row,'agmt_eq_sz_no') = "20";
  	  		}else if( sheetObj.CellValue(row, "fx_scg_40ft_rt") != "" ){
  	  			sheetObj.CellValue(row,'agmt_eq_sz_no') = "40";
  	  		}else if( sheetObj.CellValue(row, "fx_scg_45ft_rt") != "" ){
  	  			sheetObj.CellValue(row,'agmt_eq_sz_no') = "45";
  	  		}  			
  		}  		
  	}else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ){
  		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd"), " ");
  		
  		if( lvfm.length == 5 ) {
  			getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
			if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
			} else {
				sheetObj.CellValue2(row, "fm_nod_yard") = "";					
			}  			
  		}else{
  			if( lvfm.length == 0 ) {
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"fm_nod_cd") = "";
				sheetObj.SelectCell(row,"fm_nod_cd");
				sheetObj.CellValue2(row, "fm_nod_yard") = "";
			}  			
  		}
  	}else if( sheetObj.ColSaveName(col) == "to_nod_cd" ){
  		var lvto = doSepRemove(sheetObj.CellValue(row,"to_nod_cd"), " ");
  		
  		if( lvto.length == 5 ) {
  			getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Varidation check
			if( sheetObj.CellValue(row, "to_nod_cd") != "" ) {
				getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
			} else {
				sheetObj.CellValue2(row, "to_nod_yard") = "";					
			}  			
  		}else{
  			if( lvto.length == 0 ) {
				sheetObj.CellValue2(row, "to_nod_yard") = "";
			} else {
				errMsg = ComGetMsg("TRS90122");
				ComShowMessage(errMsg);
				sheetObj.CellValue2(row,"to_nod_cd") = "";
				sheetObj.SelectCell(row,"to_nod_cd");
				sheetObj.CellValue2(row, "to_nod_yard") = "";
			}  			
  		}
  	}else if( sheetObj.ColSaveName(col) == "trsp_rail_scg_cd" ){
  		if( sheetObj.CellValue(row, "trsp_rail_scg_cd") == "HZS" || sheetObj.CellValue(row, "trsp_rail_scg_cd") == "TTL") {
  			sheetObj.CellEditable(row, "lbs_ovr_wgt") = false;
  		}else if( sheetObj.CellValue(row, "trsp_rail_scg_cd") == "OWS" ){
  			sheetObj.CellEditable(row, "lbs_ovr_wgt") = true;
  		}
  	}
  }
   
   /**
    * Sheet3에서 컬럼값 변경 이벤트를 발생시킴.
    */
   function sheet3_OnChange(sheetObj, row , col , value) {
	  
 	if( sheetObj.ColSaveName(col) != "chk" ){
 		sheetObj.CellValue2(row,'ck_vf') = 1;
 		sheetObj.CellValue2(row,'rlt') = "";
 		sheetObj.CellValue2(row,'rlt2') = "";
 	}	
 	
   	if( sheetObj.ColSaveName(col) == "agmt_rout_all_flg" ) {
   		if( value == "1" ) {
   			sheetObj.CellValue(row, "fm_nod_cd") = "";
   			sheetObj.CellValue(row, "fm_nod_yard") = "";
   			sheetObj.CellValue(row, "to_nod_cd") = "";
   			sheetObj.CellValue(row, "to_nod_yard") = "";
   			sheetObj.CellEditable(row, "fm_nod_cd") = false;
   			sheetObj.CellEditable(row, "fm_nod_yard") = false;
   			sheetObj.CellEditable(row, "to_nod_cd") = false;
   			sheetObj.CellEditable(row, "to_nod_yard") = false;
   		} else {
   			sheetObj.CellEditable(row, "fm_nod_cd") = true;
   			sheetObj.CellEditable(row, "fm_nod_yard") = true;
   			sheetObj.CellEditable(row, "to_nod_cd") = true;
   			sheetObj.CellEditable(row, "to_nod_yard") = true;
   		}
   	}else if( sheetObj.ColSaveName(col) == "fm_nod_cd" ){
   		var lvfm = doSepRemove(sheetObj.CellValue(row,"fm_nod_cd"), " ");
   		
   		if( lvfm.length == 5 ) {
   			getYardSheetCombo1(sheetObj, document.form, row, col, "fm_nod_yard", lvfm); //Varidation check
 			if( sheetObj.CellValue(row, "fm_nod_cd") != "" ) {
 				getYardSheetCombo(sheetObj, document.form, row, "fm_nod_yard", lvfm);
 			} else {
 				sheetObj.CellValue2(row, "fm_nod_yard") = "";					
 			}  			
   		}else{
   			if( lvfm.length == 0 ) {
 				sheetObj.CellValue2(row, "fm_nod_yard") = "";
 			} else {
 				errMsg = ComGetMsg("TRS90122");
 				ComShowMessage(errMsg);
 				sheetObj.CellValue2(row,"fm_nod_cd") = "";
 				sheetObj.SelectCell(row,"fm_nod_cd");
 				sheetObj.CellValue2(row, "fm_nod_yard") = "";
 			}  			
   		}
   	}else if( sheetObj.ColSaveName(col) == "to_nod_cd" ){
   		var lvto = doSepRemove(sheetObj.CellValue(row,"to_nod_cd"), " ");
   		
   		if( lvto.length == 5 ) {
   			getYardSheetCombo1(sheetObj, document.form, row, col, "to_nod_yard", lvto); //Validation check
 			if( sheetObj.CellValue(row, "to_nod_cd") != "" ) {
 				getYardSheetCombo(sheetObj, document.form, row, "to_nod_yard", lvto);
 			} else {
 				sheetObj.CellValue2(row, "to_nod_yard") = "";					
 			}  			
   		}else{
   			if( lvto.length == 0 ) {
 				sheetObj.CellValue2(row, "to_nod_yard") = "";
 			} else {
 				errMsg = ComGetMsg("TRS90122");
 				ComShowMessage(errMsg);
 				sheetObj.CellValue2(row,"to_nod_cd") = "";
 				sheetObj.SelectCell(row,"to_nod_cd");
 				sheetObj.CellValue2(row, "to_nod_yard") = "";
 			}  			
   		}
   	}
   } 
  
  /**
   * Sheet1에서 Popup 이벤트를 발생시킴.
   */
  function sheet1_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  
	  switch(colName){
	  	case('agmt_no'):
	  		popAgmtNo(sheetObj, row, col);	  
	  }
  }
  
  /**
   * Sheet2에서 Popup 이벤트를 발생시킴.
   */
  function sheet2_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  
	  switch(colName){
	  	case('agmt_no'):
	  		popAgmtNo(sheetObj, row, col);	  
	  }
  }
   
    /**
   * Sheet3에서 Popup 이벤트를 발생시킴.
   */
  function sheet3_OnPopupClick (sheetObj , row , col ){
	  var colName = sheetObj.ColSaveName(col);
	  
	  switch(colName){
	  	case('agmt_no'):
	  		popAgmtNo(sheetObj, row, col);	  
	  }
  }
  
  /**
   * Sheet1에서 Delete 이벤트를 발생시킴.
   */
  function sheet1_OnSaveEnd(sheetObj, errMsg) {
  	if( errMsg.length > 0 ) {
  		ComShowMessage(errMsg);
  	} else {
  		if( document.form.f_cmd.value == REMOVE01 ) {
  			errMsg = ComGetMsg("TRS90331");
  			ComShowMessage(errMsg);
  			eq_delete(sheetObj, "chk"); //삭제하는 함수
  		}else if( document.form.f_cmd.value == MULTI01 ){
  			errMsg = ComGetMsg("COM12116", "Update");
  			ComShowMessage(errMsg);
  		}
  	}
  }
  
  /**
   * Sheet2에서 Delete 이벤트를 발생시킴.
   */
  function sheet2_OnSaveEnd(sheetObj, errMsg) {
  	if( errMsg.length > 0 ) {
  		ComShowMessage(errMsg);
  	} else {
  		if( document.form.f_cmd.value == REMOVE02 ) {
  			errMsg = ComGetMsg("TRS90331");
  			ComShowMessage(errMsg);
  			eq_delete(sheetObj, "chk"); //삭제하는 함수
  		}else if( document.form.f_cmd.value == MULTI02 ){
  			errMsg = ComGetMsg("COM12116", "Update");
  			ComShowMessage(errMsg);
  		}
  	}
  }
   
   /**
    * Sheet3에서 Delete 이벤트를 발생시킴.
    */
   function sheet3_OnSaveEnd(sheetObj, errMsg) {
   	if( errMsg.length > 0 ) {
   		ComShowMessage(errMsg);
   	} else {
   		if( document.form.f_cmd.value == REMOVE03 ) {
   			errMsg = ComGetMsg("TRS90331");
   			ComShowMessage(errMsg);
   			eq_delete(sheetObj, "chk"); //삭제하는 함수
   		}else if( document.form.f_cmd.value == MULTI01 ){
   			errMsg = ComGetMsg("COM12116", "Update");
   			ComShowMessage(errMsg);
   		}
   	}
   }
  
  /*
   * 체크해서 넘긴 데이터를 그리드 상에서 삭제한다.
   */
  function eq_delete(fromSheet, sStatus) {
  	var fromRow = 0;
  	var sRow = fromSheet.FindCheckedRow(sStatus);
  	var arrRow = sRow.split("|");
  	//원본에서 역순으로 특정 상태의 행을 이동한다.
  	for (ir = arrRow.length-2; ir >=0 ; ir--) {
  		fromRow = arrRow[ir];
  		//원본에서 지움
  		fromSheet.RowDelete(fromRow, false);
  	}
  }
  
  /**
   * 조회시 필수 항목과 날짜 형식 유효성검증 프로세스 처리
   */
  function validateFormSearch(formObj){
		var lvDate = ComTrimAll(ComTrimAll(formObj.eff_dt.value, " "), "-");
		var lvRailCode = ComTrimAll(formObj.rail_road_code.Text, " ");

		if( lvDate == "" )
			formObj.eff_dt.value = "";
		
		if( lvDate != "" ) { //날짜 체크하는 부분
			if( !ComIsDate(lvDate) ) {
				errMsg = ComGetMsg("TRS90070");
				ComShowMessage(errMsg);
				formObj.eff_dt.focus();
				return false;
			}
		}
		
		if( lvRailCode == "" ) {
			errMsg = ComGetMsg("TRS90124");
			ComShowMessage(errMsg);
			return false;
		}
		
		formObj.hid_eff_dt.value = lvDate; //from Date
		return true;
	}
  
  /**
   * 저장시 CHECK가 되어있는지 유효성검증 프로세스 처리
   */
  function validateFormDel(sheetObj, formObj){
  	if( sheetObj.CheckedRows("chk") < 1 ) {
  		errMsg = ComGetMsg("TRS90036");
  		ComShowMessage(errMsg);
  		return false;
  	}
  	
  	var checkList = sheetObj.FindCheckedRow('chk');
	var checkArray = checkList.split('|');
	
	for (ir = checkArray.length-2; ir >=0 ; ir--) {
		if( sheetObj.CellValue(checkArray[ir], "locl_cre_dt") == "" ){
			sheetObj.RowDelete(checkArray[ir], false);
	  	}
  	}
	
	if( sheetObj.CheckedRows("chk") < 1 ){
		return false;
	}
  	
  	return true;
  }
  
  /**
   * 저장시 CHECK가 되어있는지 유효성검증 프로세스 처리
   */
  function validateForm(sheetObj, formObj){
	var rowCur = 2;
	var errorMsg = "";
	
	for( var i=0; i<sheetObj.Rows-2; i++ ){
		if( sheetObj.RowStatus( rowCur+i ) == "I" ){			
			if( sheetObj.CellValue(rowCur+i, "vndr_seq") == "" ||
				sheetObj.CellValue(rowCur+i, "vndr_nm") == "" ||
				sheetObj.CellValue(rowCur+i, "agmt_no") == "" ||
				sheetObj.CellValue(rowCur+i, "cgo_tp_cd") == "" ||
				( ( sheetObj.CellValue(rowCur+i, "fm_nod_cd") == "" ||
					sheetObj.CellValue(rowCur+i, "to_nod_cd") == "") &&
					sheetObj.CellValue(rowCur+i, "agmt_rout_all_flg") == ""
				) ){
					
				if( sheetObj.CellValue(rowCur+i, "vndr_seq") == "" ){
					errorMsg += "Rail Company Code";
				}
				
				if( sheetObj.CellValue(rowCur+i, "vndr_nm") == "" ){
					errorMsg += "Rail Company Name";
				}
					
				if( sheetObj.CellValue(rowCur+i, "agmt_no") == "" ){
					errorMsg += ", Agreement No";
				}
					
				if( sheetObj.CellValue(rowCur+i, "trsp_rail_scg_cd") == "" ){
					errorMsg += ", Surcharge Kind";
				}
					
				if( sheetObj.CellValue(rowCur+i, "cgo_tp_cd") == "" ){
					errorMsg += ", Cargo Type";
				}
					
				if( ( sheetObj.CellValue(rowCur+i, "fm_nod_cd") == "" ||
						sheetObj.CellValue(rowCur+i, "to_nod_cd") == "") &&
						sheetObj.CellValue(rowCur+i, "agmt_rout_all_flg") == "" ){
						errorMsg += ", Route";
				}
					
				errMsg = ComGetMsg("COM130403", errorMsg);
				ComShowMessage(errMsg);
				return false;	  		
			}
			
			if( sheetObj.CellValue(rowCur+i,'ck_vf') == 0 &&
					sheetObj.CellValue(rowCur+i,'rlt') == "OK" ){
			}else{
				ComShowCodeMessage('TRS90039');		
				return false;
			}
		}
		
		if( sheetObj.RowStatus( rowCur+i ) == "U" ){	
			if( sheetObj.CellValue(rowCur+i,'ck_vf') == 0 &&
					sheetObj.CellValue(rowCur+i,'rlt') == "OK" ){
			}else{
				ComShowCodeMessage('TRS90039');		
				return false;
			}			
		}		
	}		
	return true;
  }
  
  /**
   * Agreement No 조회 popup
   **/
  function popAgmtNo(sheetObj, row, col)
  {
	  
  	var myOption = "width=700,height=400,menubar=0,status=0,scrollbars=0,resizable=0";
  	var url = 'ESD_TRS_0233.screen';
  	url += '?main_row='+row;
  	myWin = window.open(url, "popAgmtNo", myOption);
  	myWin.focus();
  }
  
  /**
   * History Popup 작동시 CHECK가 되어있는지 유효성검증 프로세스 처리
   */
  function validateFormPop(sheetObj){
  	if( sheetObj.CheckedRows("chk") < 1 ) {
  		errMsg = ComGetMsg("TRS90036");
  		ComShowMessage(errMsg);
  		return false;
  	}
  	
  	if( sheetObj.CheckedRows("chk") > 1 ) {
  		errMsg = ComGetMsg("COM12177");
  		ComShowMessage(errMsg);
  		return false;
  	}
  	
  	return true;
  }
  
  function getAgmtNo( value, value1, value2, value3, row ){
	  if( row == "" ){
		  var formObject = document.form;
		  formObject.fm_agmtno.value = value;
	  }else{
		  if( tabObjects[0].SelectedIndex == "0" ) {
			  sheetObjects[0].CellValue(row, 'agmt_no') = value;
			  sheetObjects[0].CellValue(row, 'agmt_ref_no') = value1;
			  sheetObjects[0].CellValue(row, 'vndr_seq') = value2;
			  sheetObjects[0].CellValue(row, 'vndr_nm') = value3;
		  }else if ( tabObjects[0].SelectedIndex == "1" ){
			  sheetObjects[1].CellValue(row, 'agmt_no') = value;
			  sheetObjects[1].CellValue(row, 'agmt_ref_no') = value1;
			  sheetObjects[1].CellValue(row, 'vndr_seq') = value2;
			  sheetObjects[1].CellValue(row, 'vndr_nm') = value3;
		  }else if ( tabObjects[0].SelectedIndex == "2" ){
			  sheetObjects[2].CellValue(row, 'agmt_no') = value;
			  sheetObjects[2].CellValue(row, 'agmt_ref_no') = value1;
			  sheetObjects[2].CellValue(row, 'vndr_seq') = value2;
			  sheetObjects[2].CellValue(row, 'vndr_nm') = value3;
		  }		  
	  }	    
  }
  
  /**
   * Fuel Verify 체크
   */
  function valcheck_two1(sheetObj){
 	 var formObject = document.form;
 	 
 	 //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
 	 if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
 		 ComOpenWait(true);
 		 document.all.btng_verify.disabled = false;
 		 formObject.f_cmd.value   = SEARCH03;
 		 var queryStr = sheetObj.GetSaveString(false, true, 'ck_vf');
		 if(queryStr == '')  {
			 ComOpenWait(false);
			 ComShowCodeMessage('TRS90395');
			 return;
		 }
 		 sheetObj.DoRowSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
 		 ComOpenWait(false);//레이어형 대기 이미지 표시
 	 }else{
 		 ComShowMessage('Only 5000 rows or less could be imported at a time.');
 	 }
  }
  
  /**
   * Fix Verify 체크
   */
  function valcheck_two2(sheetObj){
 	 var formObject = document.form;
 	 
 	 //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
 	 if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
 		 ComOpenWait(true);
 		 document.all.btng_verify.disabled = false;
 		 formObject.f_cmd.value   = SEARCH04;
 		 var queryStr = sheetObj.GetSaveString(false, true, 'ck_vf');
		 if(queryStr == '')  {
			 ComOpenWait(false);
			 ComShowCodeMessage('TRS90395');
			 return;
		 }
 		 sheetObj.DoRowSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
 		 ComOpenWait(false);//레이어형 대기 이미지 표시
 	 }else{
 		 ComShowMessage('Only 5000 rows or less could be imported at a time.');
 	 }
  }
   
   /**
    * Incentive Verify 체크
    */
   function valcheck_two3(sheetObj){
  	 var formObject = document.form;
  	 
  	 //쉬트2의 총카운트가 0일시는 현재로직을 타지않아야함.
  	 if(sheetObj.RowCount > 0 && sheetObj.RowCount < 5001 ) {
  		 ComOpenWait(true);
  		 document.all.btng_verify.disabled = false;
  		 formObject.f_cmd.value   = SEARCH06;
  		 var queryStr = sheetObj.GetSaveString(false, true, 'ck_vf');
 		 if(queryStr == '')  {
 			 ComOpenWait(false);
 			 ComShowCodeMessage('TRS90395');
 			 return;
 		 }
  		 sheetObj.DoRowSearch("ESD_TRS_0223GS.do", TrsFrmQryString(formObject)+'&'+queryStr,false);
  		 ComOpenWait(false);//레이어형 대기 이미지 표시
  	 }else{
  		 ComShowMessage('Only 5000 rows or less could be imported at a time.');
  	 }
   } 
  
  function openAgmtNo() {
		var formObject = document.form;
		var Option = "width=700,height=400,menubar=0,status=0,scrollbars=0,resizable=0";
		var agmt_no = formObject.fm_agmtno.value;   
		var param ="?agmt_no="+agmt_no;
		window.open('/hanjin/ESD_TRS_0233.do' + param, "popupAgmtHdrList", Option);
  }