/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_gem_0002.js
 *@FileTitle : [CPS_GEM_0002] Processing Status
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.04.17 진윤오
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011-02-17 이준범 [CHM-201108627-01]
 * 제목: Request 권한 없는 office user의 접근 시 all data open 오류 해소 요청
 * 보완: Request 권한 없는 Office 에 대한 화면 Block
=========================================================*/


/**
 * [CPS_GEM_0002] Processing Status
 * @extends
 * @class Processing Status생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_gem_0002() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
}
//=============================================================
//#Form Command          #IBSheet Action                
//INIT        = 0;       IBSEARCH       = 0;  // 조회         
//ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
//SEARCH      = 2;       IBSAVE         = 2;  // 저장         
//SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
//MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
//REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
//REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
//MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
//PRINT       = 8;       IBDELETE       = 8;  // 삭제         
//REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                     IBROWSEARCH    = 10; // Row 조회     
//                     IBCREATE       = 11; // Create       
//                     IBRESET        = 12; // Reset        
//                     IBBATCH        = 13; // Batch        
//=============================================================



//===================================================================================
//전역변수 추상함수
//===================================================================================

//IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;

var curYear = "";
var curMon = "";

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null
var comboCnt = 0;

//search form
var frm = null;
//Initial 마감정보
var initDateVO = null;
//additional 마감정보 
var closingDateVO = null;


//note팝업창 
var noteWin = null;
//Note ID
var noteId = "";

//uthorized Expense Code  팝업창
var authWin = null;
//assigend 팝업창
var assWin = null;

//Assigned Expense 구분 (FM , TO)
var assWinDiv = null;

//Authorized Expense Code 구분 (FM , TO)
var authWinDiv = null;

//request no  pop up win
var reqWin = null;

//Adjustment Win
var adWin = null;


//To currInfo 통화정보
var toCurrInfo = null;

//Fm currInfo 통화정보
var fmCurrInfo = null;

/**
* IBSheet Object를 배열로 등록
* @param {ibsheet} sheetObj    IBSheet Object  
**/
function setSheetObject(sheet_obj){
 sheetObjects[sheetCnt++] = sheet_obj;
}

/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
comboObjects[comboCnt++] = combo_obj;
}
//===================================================================================
//초기화 
//===================================================================================
/**
* Sheet 기본 설정 및 초기화
* body 태그의 onLoad 이벤트핸들러 구현
* 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
* @param {string} year 현재 년도
**/
function loadPage(year) {
	    
	 //현재 년도 설정
	 curYear = year;
		
	 //전역 변수 설정 
	 frm = document.form;
		
	 sheet1 = sheetObjects[0];
	 sheet2 = sheetObjects[1];    

	 sheetCnt = sheetObjects.length ;
	
	 //시트 초기화 
	 for(var i=0 ; i < sheetCnt ; i++) {
	     ComConfigSheet (sheetObjects[i]);
	     initSheet(sheetObjects[i],i+1);
	     ComEndConfigSheet(sheetObjects[i]);              
	 }
	 
	 //IBMultiCombo초기화
	 combo1 = comboObjects[0]
	 comboCnt = comboObjects.length;
	 for(var k=0;k<comboObjects.length;k++){
	 	initCombo(comboObjects[k]);
	 }
	 
	 //Form 이벤트 등록
	 initControl();    
	 

	 
}


/**
* 화면 깜박임 방지 (페이지 로딩후 실행) 
* @param {ibsheet} sheet  sheet
*/
function sheet1_OnLoadFinish(sheet) {
	 sheet.WaitImageVisible = false;	    
	
	 //오피스 콤보 호출
	 doActionIBSheet(SEARCHLIST20);
	 
	 //OPEN화면 호출
	 doActionIBSheet(INIT); 	
	
	 sheet.WaitImageVisible = true;
}


/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	comboObj.MultiSelect = true;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ","; 
	comboObj.DropHeight = 240;
}

/**
* 시트 초기설정값, 헤더 정의
* @param {ibsheet} sheetObj  sheet
* @param {int} sheetNo 시트번호
*/
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	
	with (sheetObj) {
		switch (sheetObj.id) {

		case "sheet1":
         // 높이 설정
         style.height = 300;

         //전체 너비 설정
         SheetWidth = mainTable.clientWidth;

         //Host정보 설정[필수][HostIp, Port, PagePath]
         if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

         //전체Merge 종류 [선택, Default msNone]
         MergeSheet = msHeaderOnly;

        //전체Edit 허용 여부 [선택, Default false]
         Editable = true;

         MultiSelection = false;
         
         //행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
         InitRowInfo(2, 1, 18, 100);
         var HeadHidden = "|to_gen_expn_itm_no|to_gen_expn_itm_desc|cre_usr_id|fm_ut_val|to_ut_val|fm_usd_locl_xch_rt|fm_locl_krw_xch_rt|fm_ut_val|fm_usd_krw_xch_rt|to_usd_locl_xch_rt|to_locl_krw_xch_rt|to_usd_krw_xch_rt|gen_expn_rqst_tp_cd|gen_expn_apro_auth_ofc_cd|crnt_gen_expn_apro_step_cd|crnt_gen_expn_apsts_cd|gen_expn_rqst_seq|fm_eng_abbr_nm|to_eng_abbr_nm|fm_krn_abbr_nm|to_krn_abbr_nm|rqst_opin_rmk";
			var HeadTitle1 = "|OFC|OFC|Expense|Expense|Item\nDescription|CUR|CUR|Request Amount|Request Amount|Adjustment Amount|Adjustment Amount|ISSUED\nOFFICE|Approval Status|Approval Status|Approval Status|Approval Status|Request No. (Item)|Request No. (Item)";
			HeadTitle1 += HeadHidden;
			var HeadTitle2 = "|FM|TO|FM|TO|Item\nDescription|FM|TO|FM|TO|FM|TO|ISSUED\nOFFICE|1st|2nd|3rd|FNL|Request No.|Item";
			HeadTitle2 += HeadHidden;
			var headCount = ComCountHeadTitle(HeadTitle1);

         //컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
         InitColumnInfo(headCount, 5, 0, true);

         // 해더에서 처리할 수 있는 각종 기능을 설정한다
         InitHeadMode(true, false, true, true, false,false)

         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         InitHeadRow(0, HeadTitle1, true);
		 InitHeadRow(1, HeadTitle2, true);

         //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,		KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,	daCenter,	true,		"ibflag");
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,       "fm_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"to_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"fm_gen_expn_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"to_gen_expn_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		300,	daLeft,	true,		"fm_gen_expn_itm_desc",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,		"fm_locl_curr_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		40,	daCenter,	true,		"to_locl_curr_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"fm_rq_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"to_rq_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"fm_ad_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtAutoSum,		100,	daRight,	true,		"to_ad_amt",			false,		"",			dfInteger,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		60,	daCenter,	true,		"rqst_ofc_cd",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap1",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap2",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap3",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		30,	daCenter,	true,		"ap4",			false,		"",			dfNone,		0,			false,		false);
			InitDataProperty(0, cnt++ , dtData,		150,	daCenter,	true,		"gen_expn_rqst_no",			false,		"",			dfNone,		0,			false,		true);
			InitDataProperty(0, cnt++ , dtData,	    50,	daCenter,	true,		"fm_gen_expn_itm_no",			false,		"",			dfNone,		0,			false,		false);

			// -------------------------------------------------------------------------------------
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_no");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_gen_expn_itm_desc");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"cre_usr_id");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_usd_locl_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_locl_krw_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_ut_val", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_usd_krw_xch_rt", false , "",dfInteger);			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_usd_locl_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_locl_krw_xch_rt", false , "",dfFloat,4);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_usd_krw_xch_rt", false , "",dfInteger);
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_rqst_tp_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_apro_auth_ofc_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apro_step_cd");			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"crnt_gen_expn_apsts_cd");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"gen_expn_rqst_seq");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_eng_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"fm_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"to_krn_abbr_nm");
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"rqst_opin_rmk");	
			
			
			CountPosition = 2;			
			break;
		case "sheet2":
			if (location.hostname != "") {
			 	WaitImageVisible = false; 
			 	InitHostInfo(location.hostname, location.port, page_path);
			}
			break;
		}
	}
}


//===================================================================================
//Private function
//===================================================================================

/**
* 팝업에서 genExpnRqstNo 받음
*/
function setGenExpnRqstNo(genExpnRqstNo) {
	frm.gen_expn_rqst_no.value = genExpnRqstNo;	
	doActionIBSheet(SEARCHLIST);
}



/**
* 팝업에서 expenseCode를 받음
*/
function setExpenseCode(expenseInfoList) {
	 	
	if (authWinDiv == "FM") {
		if (expenseInfoList.length > 0 ) {
			var expenseInfo = expenseInfoList[0];
			ComSetObjValue(frm.fm_gen_expn_cd ,expenseInfo.gen_expn_cd);
			ComSetObjValue(frm.fm_tic_cd , expenseInfo.tic_cd);
			ComSetObjValue(frm.fm_krn_abbr_nm , expenseInfo.krn_abbr_nm);
		    ComSetObjValue(frm.fm_eng_abbr_nm , expenseInfo.eng_abbr_nm);
		}
		
		//From Assigned Expense 호출
		setTimeout("openPopup1()",500);
		
		
	} else if (authWinDiv == "TO") {	
		if (expenseInfoList.length > 0 ) {
			var expenseInfo = expenseInfoList[0];				
			//ComSetObjValue(frm.fm_ofc_cd , expenseInfo.ofc_cd);
			ComSetObjValue(frm.to_gen_expn_cd ,expenseInfo.gen_expn_cd);
			ComSetObjValue(frm.to_tic_cd , expenseInfo.tic_cd);
			ComSetObjValue(frm.to_krn_abbr_nm , expenseInfo.krn_abbr_nm);
		    ComSetObjValue(frm.to_eng_abbr_nm , expenseInfo.eng_abbr_nm);
			var plnYrmon =  frm.pln_yr.value;		
			//expense MAX ITEM 취득 
			//MaxItem 취득 
			var plnYrmon =  frm.pln_yr.value
			var itemNo = searchMaxItem(plnYrmon ,
					                   expenseInfo.ofc_cd ,
					                   expenseInfo.gen_expn_cd);	
			
			
			itemNo = getGenExpnItmNo(expenseInfo.ofc_cd  , 
					                 expenseInfo.gen_expn_cd , 
					                 itemNo);		

			frm.to_gen_expn_itm_no.value = itemNo;	
			
			frm.pre_to_gen_expn_itm_no.value = itemNo;
			
		}
		
		
	}
		

}


/**
* 그룹메일
*/
function showGroupMail() {
	var contents = "";
	contents += "TO : PLP / Eun-young Lee <br>";
	contents += "RE : Request for Approval <br>";
	contents += "----------------------------------------------------------------<br>";
	contents += "You can see the prcessing status for request on Processing Status<br><br>";
	contents += "○ RQST OFC:<br>";
	contents += "○ APPL OFC:<br>";
	contents += "○ RQST No.:<br>";
	contents += "○ Expense Code:<br>";
	contents += "○ Amount:<br>";
	contents += "○ Remark:<br><br>";
	contents += "B.RGDS/<br>";
	
	frm.gw_contents.value = contents;
	frm.gw_subject.value = "Request for Approval";
	ComOpenGroupwareMail(sheet1,frm);
}

/**
 * 오피스 권한 활성화 , 비활성화  
 */
function setExpnGroupList() {
	// ---------------------------------
	// Expense Code group code 
	// ---------------------------------
	combo1.RemoveAll();		
	combo1.InsertItem(0,"Select All","");
	for(var i=0 ; i < expnGroupList.length ; i++ ) {
		var expense = expnGroupList[i];
		var langDiv = ComGetObjValue(frm.lang_div);
		if (langDiv == "KOR") {
			combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["krn_abbr_nm"],expense["gen_expn_cd"]);
		} else if(langDiv == "ENG") {
			combo1.InsertItem(i+1,expense["gen_expn_cd"]+"|"+expense["eng_abbr_nm"],expense["gen_expn_cd"]);
		}				
	}
	combo1.Code = "";	
}






/**                                                                                                                                                                                                                                                                                                  
* 시트 sheet1에데이타를 form,sheet2에 설정                                                                                                                                                                                                                                                          
* @param {long} srow 시트 행번호                                                                                                                                                                                                                                                                     
*/                                                                                                                                                                                                                                                                                                  
function setSheet1ToForm( srow ) {   
	
	var pln_yrmon = frm.pln_yrmon.value;
	
	var pln_yr = pln_yrmon.substring(0,4);
	var pln_mon = pln_yrmon.substring(4,6);
	
	
	var queryString = getSheetRowQueryString(sheet1,srow);
	
	var param = "f_cmd=" + SEARCHLIST01;
	
	param +=  "&" + queryString;
	
	var sXml = sheet1.GetSearchXml("CPS_GEM_0001_03GS.do", param);		
	
	var arrXml = sXml.split("|$$|");
	
	var gen_expn_rqst_tp_cd = sheet1.CellValue(srow ,"gen_expn_rqst_tp_cd");
	
	
	if ("ET" == gen_expn_rqst_tp_cd) {
		frm1.gen_expn_rqst_tp_cd[1].checked = true;
	} else {		
		frm1.gen_expn_rqst_tp_cd[0].checked = true;
	}
	
	//초기화 
	sheet2.RemoveAll();	
	sheet3.RemoveAll();	
	sheet4.RemoveAll();
	
	//1. request
	if (arrXml.length > 0) {		
		var list = ComXml2ListMap(arrXml[0]);
		var request  = list[0];			
		
		frm1.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
		var pln_yrmon = request["pln_yrmon"];
		frm1.pln_yr.value = pln_yrmon.substring(0,4);
		
		
		if (gen_expn_rqst_tp_cd != "EI") {
			frm1.pln_mon.value = pln_yrmon.substring(4,6);
		}
		
		frm1.gen_expn_rqst_no.value = request["gen_expn_rqst_no"];
		frm1.cre_usr_id.value = request["cre_usr_id"];
		
	}	
	
	//2. fm_item
	if (arrXml.length > 1) {		
		var list = ComXml2ListMap(arrXml[1]);
		var item  = list[0];
		var row = sheet2.DataInsert(-1);
		sheet2.CellValue2(row, "title") = "Assigned";
	 	sheet2.CellValue2(row ,"jan_amt") = item["jan_amt"];
	 	sheet2.CellValue2(row ,"feb_amt") = item["feb_amt"];
	 	sheet2.CellValue2(row ,"mar_amt") = item["mar_amt"];
	 	sheet2.CellValue2(row ,"apr_amt") = item["apr_amt"];
	 	sheet2.CellValue2(row ,"may_amt") = item["may_amt"];
	 	sheet2.CellValue2(row ,"jun_amt") = item["jun_amt"];
	 	sheet2.CellValue2(row ,"jul_amt") = item["jul_amt"];
	 	sheet2.CellValue2(row ,"aug_amt") = item["aug_amt"];
	 	sheet2.CellValue2(row ,"sep_amt") = item["sep_amt"];
	 	sheet2.CellValue2(row ,"oct_amt") = item["oct_amt"];
	 	sheet2.CellValue2(row ,"nov_amt") = item["nov_amt"];
	 	sheet2.CellValue2(row ,"dec_amt") = item["dec_amt"];	
	 	frm1.fm_gen_expn_itm_desc.value = item["gen_expn_itm_desc"];
	 	frm1.fm_gen_expn_itm_no.value = item["gen_expn_itm_no"];
	 	
	}
	
	//3. to_item
	if (arrXml.length > 2) {		
		var list = ComXml2ListMap(arrXml[2]);
		var item  = list[0];
		var row = sheet3.DataInsert(-1);
		sheet3.CellValue2(row, "title") = "Assigned";
	 	sheet3.CellValue2(row ,"jan_amt") = item["jan_amt"];
	 	sheet3.CellValue2(row ,"feb_amt") = item["feb_amt"];
	 	sheet3.CellValue2(row ,"mar_amt") = item["mar_amt"];
	 	sheet3.CellValue2(row ,"apr_amt") = item["apr_amt"];
	 	sheet3.CellValue2(row ,"may_amt") = item["may_amt"];
	 	sheet3.CellValue2(row ,"jun_amt") = item["jun_amt"];
	 	sheet3.CellValue2(row ,"jul_amt") = item["jul_amt"];
	 	sheet3.CellValue2(row ,"aug_amt") = item["aug_amt"];
	 	sheet3.CellValue2(row ,"sep_amt") = item["sep_amt"];
	 	sheet3.CellValue2(row ,"oct_amt") = item["oct_amt"];
	 	sheet3.CellValue2(row ,"nov_amt") = item["nov_amt"];
	 	sheet3.CellValue2(row ,"dec_amt") = item["dec_amt"];	 
	 	frm1.to_gen_expn_calc_bss_desc.value = item["gen_expn_calc_bss_desc"];
	 	frm1.to_rqst_opin_rmk.value = item["rqst_opin_rmk"];
	 	frm1.to_gen_expn_itm_desc.value = item["gen_expn_itm_desc"];
	 	frm1.to_gen_expn_itm_no.value = item["gen_expn_itm_no"];
	}
	
	//4. fm_aproStep
	if (arrXml.length > 3) {		
		var list = ComXml2ListMap(arrXml[3]);


		for ( var i = 0; i < list.length; i++) {
			sheet2.DataInsert(-1);
			sheet4.DataInsert(-1);
		}

		//Editable Cell ===========================
		var janCol = sheet2.SaveNameCol("jan_amt");
		var decCol = sheet2.SaveNameCol("dec_amt");
		
		if (gen_expn_rqst_tp_cd == "EI") {
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet2.CellEditable(list.length + 1,i) = true;
			}
		} else {
			var start = janCol + parseInt(pln_mon) - 1;
			for ( var i = start ; i <= decCol; i++) {		
				sheet2.CellEditable(list.length + 1,i) = true;
			}			
		}
		
		var rjCol = sheet4.SaveNameCol("crnt_gen_expn_apsts_cd_rj");
		var aproCol = sheet4.SaveNameCol("apro_opin_rmk");
		for ( var i = rjCol ; i <= aproCol; i++) {		
			sheet4.CellEditable(list.length + 1,i) = true;
		}
		
		for ( var i = 0; i < list.length; i++) {
			var aproStep  = list[i];
			var row = i + 2;
			var step = aproStep["gen_expn_apro_step_cd"];
			
			
			sheet2.CellValue2(row, "title") = getStepOffice(step);			
		 	sheet2.CellValue2(row ,"jan_amt") = aproStep["jan_amt"];
		 	sheet2.CellValue2(row ,"feb_amt") = aproStep["feb_amt"];
		 	sheet2.CellValue2(row ,"mar_amt") = aproStep["mar_amt"];
		 	sheet2.CellValue2(row ,"apr_amt") = aproStep["apr_amt"];
		 	sheet2.CellValue2(row ,"may_amt") = aproStep["may_amt"];
		 	sheet2.CellValue2(row ,"jun_amt") = aproStep["jun_amt"];
		 	sheet2.CellValue2(row ,"jul_amt") = aproStep["jul_amt"];
		 	sheet2.CellValue2(row ,"aug_amt") = aproStep["aug_amt"];
		 	sheet2.CellValue2(row ,"sep_amt") = aproStep["sep_amt"];
		 	sheet2.CellValue2(row ,"oct_amt") = aproStep["oct_amt"];
		 	sheet2.CellValue2(row ,"nov_amt") = aproStep["nov_amt"];
		 	sheet2.CellValue2(row ,"dec_amt") = aproStep["dec_amt"];	
		 	
		 	// --------------------------------------------
		 	//  Approval 
   		    // --------------------------------------------
		 	
		 	var gen_expn_apsts_cd = aproStep["gen_expn_apsts_cd"];
		 	
		 	if (gen_expn_apsts_cd == "AP") {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 1;	
		 	} else if (gen_expn_apsts_cd == "RJ") {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 1;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 0;
		 	} else {
		 		sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_rj") = 0;
			 	sheet4.CellValue(row ,"crnt_gen_expn_apsts_cd_ap") = 0;			 		
		 	}
		 	
			sheet4.CellValue(row, "title") = getStepOffice(step);
		 	sheet4.CellValue(row ,"upd_usr_id") = aproStep["upd_usr_id"];
		 	sheet4.CellValue(row ,"upd_dt") = aproStep["upd_dt"];
		 	sheet4.CellValue(row ,"apro_opin_rmk") = aproStep["apro_opin_rmk"];
		 	
		}
		
	}
	
	//5. to_aproStep		
	if (arrXml.length > 4) {		
		var list = ComXml2ListMap(arrXml[4]);
		
		for ( var i = 0; i < list.length; i++) {
			sheet3.DataInsert(-1);
		}
		
		//Edit ===========================
		var janCol = sheet3.SaveNameCol("jan_amt");
		var decCol = sheet3.SaveNameCol("dec_amt");
		
		if (gen_expn_rqst_tp_cd == "EI") {
			for ( var i = janCol ; i <= decCol; i++) {		
				sheet3.CellEditable(list.length+1,i) = true;
			}
		} else {
			var start = janCol + parseInt(pln_mon , 10) - 1;
			for ( var i = start ; i <= decCol; i++) {		
				sheet3.CellEditable(list.length+1,i) = true;
			}			
		}		
		
		for ( var i = 0; i < list.length; i++) {
			var aproStep  = list[i];
			
			var row = i + 2;
			var step = aproStep["gen_expn_apro_step_cd"];
			
			sheet3.CellValue2(row, "title") = getStepOffice(step);			
		 	sheet3.CellValue2(row ,"jan_amt") = aproStep["jan_amt"];
		 	sheet3.CellValue2(row ,"feb_amt") = aproStep["feb_amt"];
		 	sheet3.CellValue2(row ,"mar_amt") = aproStep["mar_amt"];
		 	sheet3.CellValue2(row ,"apr_amt") = aproStep["apr_amt"];
		 	sheet3.CellValue2(row ,"may_amt") = aproStep["may_amt"];
		 	sheet3.CellValue2(row ,"jun_amt") = aproStep["jun_amt"];
		 	sheet3.CellValue2(row ,"jul_amt") = aproStep["jul_amt"];
		 	sheet3.CellValue2(row ,"aug_amt") = aproStep["aug_amt"];
		 	sheet3.CellValue2(row ,"sep_amt") = aproStep["sep_amt"];
		 	sheet3.CellValue2(row ,"oct_amt") = aproStep["oct_amt"];
		 	sheet3.CellValue2(row ,"nov_amt") = aproStep["nov_amt"];
		 	sheet3.CellValue2(row ,"dec_amt") = aproStep["dec_amt"];			
		}
				
		
		
	}
	
	//6.fm_ofc level
	if (arrXml.length > 5) {		
		var list = ComXml2ListMap(arrXml[5]);
		if (list.length > 0) {
			var officeHierarchyVO  = list[0];
			var level1   = officeHierarchyVO["level1"];
			var level2   = officeHierarchyVO["level2"];
			var level3   = officeHierarchyVO["level3"];
			var level4   = officeHierarchyVO["level4"];
			var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
			
			if ("N" == rgnOfcFlg) {
				frm1.fm_sls_ofc_div_cd[0].checked = true;
			} else {
				frm1.fm_sls_ofc_div_cd[1].checked = true;
			}
			
			ComSetObjValue(frm1.fm_ofc_lvl1,level2);
			
			//LV2			
			frm1.fm_ofc_lvl2.length = 0;
			ComAddComboItem(frm1.fm_ofc_lvl2, level3, level3);
			
			//LV3					
			frm1.fm_ofc_lvl3.length = 0;
			ComAddComboItem(frm1.fm_ofc_lvl3, level4, level4);
		}
		
		
	}

	//7.to_ofc level
	if (arrXml.length > 6) {		
		var list = ComXml2ListMap(arrXml[6]);
		if (list.length > 0) {
			var officeHierarchyVO  = list[0];
			var level1   = officeHierarchyVO["level1"];
			var level2   = officeHierarchyVO["level2"];
			var level3   = officeHierarchyVO["level3"];
			var level4   = officeHierarchyVO["level4"];
			var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
			
			if ("N" == rgnOfcFlg) {
				frm1.to_sls_ofc_div_cd[0].checked = true;
			} else {
				frm1.to_sls_ofc_div_cd[1].checked = true;
			}
			
			ComSetObjValue(frm1.to_ofc_lvl1,level2);
			
			//LV2			
			frm1.to_ofc_lvl2.length = 0;
			ComAddComboItem(frm1.to_ofc_lvl2, level3, level3);
			
			//LV3					
			frm1.to_ofc_lvl3.length = 0;
			ComAddComboItem(frm1.to_ofc_lvl3, level4, level4);
		}
		
		
	}
	
	//8.fm_expense info
	if (arrXml.length > 7) {		
		var list = ComXml2ListMap(arrXml[7]);
		if (list.length > 0) {
			var expnInfo  = list[0];
			frm1.fm_tic_cd.value = expnInfo["tic_cd"];
			frm1.fm_gen_expn_cd.value = expnInfo["gen_expn_cd"];
			frm1.fm_eng_abbr_nm.value = expnInfo["eng_abbr_nm"];
			frm1.fm_krn_abbr_nm.value = expnInfo["krn_abbr_nm"];
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm1.fm_gen_expn_cd_abbr_name.value = frm1.fm_krn_abbr_nm.value;
		    } else {
		    	frm1.fm_gen_expn_cd_abbr_name.value = frm1.fm_eng_abbr_nm.value;
		    }			
		
		}
	}

	//9.to_expense info
	if (arrXml.length > 8) {
		
		var list = ComXml2ListMap(arrXml[8]);
		if (list.length > 0) {
			var expnInfo  = list[0];
			frm1.to_tic_cd.value = expnInfo["tic_cd"];
			frm1.to_gen_expn_cd.value = expnInfo["gen_expn_cd"];
			frm1.to_eng_abbr_nm.value = expnInfo["eng_abbr_nm"];		
			frm1.to_krn_abbr_nm.value = expnInfo["krn_abbr_nm"];
		    if (ComGetObjValue(frm.lang_div) == "KOR") {
		    	frm1.to_gen_expn_cd_abbr_name.value = frm1.to_krn_abbr_nm.value;
		    } else {
		    	frm1.to_gen_expn_cd_abbr_name.value = frm1.to_eng_abbr_nm.value;
		    }	
		}
	}
	        
	if (frm1.fm_ofc_lvl3.value == frm1.to_ofc_lvl3.value) {		
		frm1.same_ofc_cd.checked = true;		
	} else {
		frm1.same_ofc_cd.checked = false;
	}
	
	if (frm1.fm_gen_expn_cd.value == frm1.to_gen_expn_cd.value) {		
		frm1.same_expn_cd.checked = true;		
	} else {
		frm1.same_expn_cd.checked = false;
	}
	
	
	if (sheet2.CellValue(1,"ttl") > 0 ) {
		frm1.fm_chk_assigned.checked = true;
	} else {
		frm1.fm_chk_assigned.checked = false;
	}
	
	if (sheet3.CellValue(1,"ttl") > 0 ) {
		frm1.to_chk_assigned.checked = true;
	} else {
		frm1.to_chk_assigned.checked = false;
	}
	
	document.getElementById("fm_locl_curr_cd").innerText = 
		sheet1.CellValue(srow, "fm_locl_curr_cd");

	document.getElementById("to_locl_curr_cd").innerText = 
		sheet1.CellValue(srow, "to_locl_curr_cd");
	
	frm1.fm_ut_val.value = sheet1.CellText(srow, "fm_ut_val");	
	frm1.fm_rq_amt.value = sheet1.CellText(srow, "fm_rq_amt");	
	frm1.fm_usd_locl_xch_rt.value = ComAddComma(sheet1.CellValue(srow, "fm_usd_locl_xch_rt"));
	frm1.fm_usd_amt.value = 
		ComAddComma(getUsdAmt(frm1.fm_rq_amt.value,frm1.fm_ut_val.value,frm1.fm_usd_locl_xch_rt.value));
	
	frm1.to_ut_val.value = sheet1.CellText(srow, "to_ut_val");
	frm1.to_rq_amt.value = sheet1.CellText(srow, "to_rq_amt");
	frm1.to_usd_locl_xch_rt.value = ComAddComma(sheet1.CellValue(srow, "to_usd_locl_xch_rt"));
	frm1.to_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.to_rq_amt.value,frm1.to_ut_val.value,frm1.to_usd_locl_xch_rt.value));
	
	
	frm1.fm_ad_ut_val.value = sheet1.CellText(srow, "fm_ut_val");	
	frm1.fm_ad_amt.value = sheet1.CellText(srow ,"fm_ad_amt");
	frm1.fm_ad_usd_locl_xch_rt.value = ComAddComma(sheet1.CellValue(srow, "fm_usd_locl_xch_rt"));
	frm1.fm_ad_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.fm_ad_amt.value,frm1.fm_ad_ut_val.value,frm1.fm_ad_usd_locl_xch_rt.value));
	
	
	frm1.to_ad_ut_val.value = sheet1.CellText(srow, "to_ut_val");
	frm1.to_ad_amt.value = sheet1.CellText(srow, "to_ad_amt");
	frm1.to_ad_usd_locl_xch_rt.value = ComAddComma(sheet1.CellValue(srow, "to_usd_locl_xch_rt"));	
	frm1.to_ad_usd_amt.value  = 
		ComAddComma(getUsdAmt(frm1.to_ad_amt.value,frm1.to_ad_ut_val.value,frm1.to_ad_usd_locl_xch_rt.value));
	
	frm1.fm_assign_rule.checked = false;
	frm1.to_assign_rule.checked = false;
	frm1.fm_monthFrom.disabled = true;
	frm1.fm_monthTo.disabled = true;
	frm1.to_monthFrom.disabled = true;
	frm1.to_monthTo.disabled = true;
	
}



//===================================================================================
//Form 이벤트 처리
//===================================================================================

//버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
* 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
*/
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {
	case "btn1_Retrieve":
		doActionIBSheet(SEARCHLIST);
		break;	
	case "btn1_New":
		//Do you want to initialize?
		if (ComShowCodeConfirm("GEM00015")) {			
			location.href = document.location;
			top.document.body.scrollTop = 0;
		}
		break;
	case "btn1_Adjustment":
		
		var row = sheet1.SelectRow;			
		if(row == -1){			
			break;
		}
		
		//로그인 ofc_cd 와 같은경우만 실행
		var genExpnAproAuthOfcCd =
			sheet1.CellValue(row,"gen_expn_apro_auth_ofc_cd");		
		var usrOfcCd = frm.usr_ofc_cd.value;
		
		if (usrOfcCd != genExpnAproAuthOfcCd) {
			break;
		}
		
		//Step CO , AP이면 break;
		if (sheet1.CellValue(row,"crnt_gen_expn_apro_step_cd") == "CO"
		      && sheet1.CellValue(row,"crnt_gen_expn_apsts_cd") == "AP"){
			break;
		}		
		
		var url = "CPS_GEM_0001_03.do";
		var winName = "CPS_GEM_0001_03";
		if (adWin != null) {
			adWin.close();
		}
		
		
		var param = getSheetRowQueryString(sheet1 , row);
		
		var ofc_lvl1 = frm.ofc_lvl1.value;
		var ofc_lvl2 = frm.ofc_lvl2.value;
		var ofc_lvl3 = frm.ofc_lvl3.value;
		var sls_ofc_div_cd = "";
		if ( frm.sls_ofc_div_cd[0].checked ) {
			sls_ofc_div_cd = "N";
		} else if ( frm.sls_ofc_div_cd[1].checked ) {
			sls_ofc_div_cd = "Y";
		}
		
		param += "&ofc_lvl1=" + ofc_lvl1;
		param += "&ofc_lvl2=" + ofc_lvl2;
		param += "&ofc_lvl3=" + ofc_lvl3;
		param += "&sls_ofc_div_cd=" + sls_ofc_div_cd;		
		url = url + "?popup_yn=Y&" + param ;
		
		adWin = openWinCenter(url ,winName,1024,700, "Y");
		
		adWin.focus();
	    
		break;	
	case "btn1_Approval":
	
		var row = sheet1.SelectRow;			
		if(row == -1){			
			break;
		}
		
		//로그인 ofc_cd 와 같은경우만 실행
		var genExpnAproAuthOfcCd =
			sheet1.CellValue(row,"gen_expn_apro_auth_ofc_cd");		
		var usrOfcCd = frm.usr_ofc_cd.value;
		
		if ( sheet1.CellValue(row,"crnt_gen_expn_apro_step_cd") == "CO"
		        && sheet1.CellValue(row,"crnt_gen_expn_apsts_cd") == "AP" ) {
			break;
		}
		    	
		var authFlg = frm.auth_flg.value;
		
		if (authFlg != "YNYY" && 
				sheet1.CellValue(row,"crnt_gen_expn_apro_step_cd") == "CO") {
			break;
		}
		
		// approval권한이 없는 경우 break GEM01,GEM02 requester
		var usrRole = frm.usr_role.value;;	
		if ( !(usrRole.indexOf("GEM03") != -1  || usrRole.indexOf("GEM04") != -1  
				|| usrRole.indexOf("GEM05") != -1)) {
			break;
		}		
		
		var url = "CPS_GEM_0003.do";
		var winName = "CPS_GEM_0003";
		
		if (assWinDiv != null) {			
			assWinDiv.close();
		}
				
		
		
		var ofc_lvl1 = frm.ofc_lvl1.value;
		var ofc_lvl2 = frm.ofc_lvl2.value;
		var ofc_lvl3 = frm.ofc_lvl3.value;
		var sls_ofc_div_cd = "";
		if ( frm.sls_ofc_div_cd[0].checked ) {
			sls_ofc_div_cd = "N";
		} else if ( frm.sls_ofc_div_cd[1].checked ) {
			sls_ofc_div_cd = "Y";
		}
		
		var param = "";
		param += "?ofc_lvl1=" + ofc_lvl1;
		param += "&ofc_lvl2=" + ofc_lvl2;
		param += "&ofc_lvl3=" + ofc_lvl3;
		param += "&sls_ofc_div_cd=" + sls_ofc_div_cd;		
		param += "&popup_yn=Y&";
		param += getSheetRowQueryString(sheet1 , row);		
		url = url + param;
		
		assWinDiv = openWinCenter(url ,winName,1024,700, "Y");
		
		assWinDiv.focus();
	    
	    break;
	    
	//Request Information
	case "btn1_History":		
		var row = sheet1.SelectRow;			
		if(row == -1){			
			break;
		}
		
		var plnYrmon 		= frm.pln_yrmon.value;
		plnYrmon = plnYrmon.substring(0,4);
		
		var genExpnRqstTpCd	= sheet1.CellValue(row,"gen_expn_rqst_tp_cd");
		
		var gen_expn_trns_div_cd = "";
		
		if(genExpnRqstTpCd == "EA" || genExpnRqstTpCd == "EI"){
			gen_expn_trns_div_cd = "F";
		}
			
	    var gen_expn_rqst_seq = sheet1.CellValue(row,"gen_expn_rqst_seq");	    
	    var gen_expn_rqst_no = sheet1.CellValue(row,"gen_expn_rqst_no");
		var param2 = "pln_yrmon=" + plnYrmon + "&gen_expn_rqst_tp_cd=" + genExpnRqstTpCd;
		param2 += "&gen_expn_rqst_seq=" + gen_expn_rqst_seq + "&gen_expn_trns_div_cd=" + gen_expn_trns_div_cd + "&gen_expn_rqst_no=" + gen_expn_rqst_no;
		var url = "CPS_GEM_0014_02.do?"+param2;
		var winName = "CPS_GEM_0014_02";
		
		var win = ComOpenWindowCenter(url,winName,800,510, false);
		win.focus();   		
	    break;			
	// Down Excel
	case "btn1_Down_Excel":		
		if (sheet1.RowCount > 0 ) {
			var columnSkipList = "ibflag|to_gen_expn_itm_no|to_gen_expn_itm_desc|cre_usr_id|fm_ut_val|to_ut_val|fm_usd_locl_xch_rt|fm_locl_krw_xch_rt|fm_ut_val|fm_usd_krw_xch_rt|to_usd_locl_xch_rt|to_locl_krw_xch_rt|to_usd_krw_xch_rt|gen_expn_rqst_tp_cd|gen_expn_apro_auth_ofc_cd|crnt_gen_expn_apro_step_cd|crnt_gen_expn_apsts_cd|gen_expn_rqst_seq|fm_eng_abbr_nm|to_eng_abbr_nm|fm_krn_abbr_nm|to_krn_abbr_nm|rqst_opin_rmk";
			//sheet1.Down2Excel(1,false,false,true,"","",false,false,"Processing Status",false,columnSkipList);
			sheet1.SpeedDown2Excel(1,false,false,"","",false,false,"Processing Status",true,columnSkipList);
		}
		break;	
	// Request for Approve
	case "btn2_Request":		
		showGroupMail();
		break;		
	//Approval Opinion  
	case "btns_approval_opinion":
		var row = sheet1.SelectRow;			
		if(row == -1){			
			break;
		}
		
		var genExpnRqstNo 		= sheet1.CellValue(row,"gen_expn_rqst_no");
		var genExpnCd 			= sheet1.CellValue(row,"fm_gen_expn_cd");
		var genExpnItmNo		= sheet1.CellValue(row,"fm_gen_expn_itm_no");
			
		var param2 = "gen_expn_rqst_no=" + genExpnRqstNo + "&gen_expn_cd=" + genExpnCd + "&gen_expn_itm_no=" + genExpnItmNo;
		
		var url = "CPS_GEM_0106.do?"+param2;
		var winName = "CPS_GEM_0106";
		
		var win = ComOpenWindowCenter(url,winName,700,350, false);
		win.focus();
		
		break;
	//Request popup
	case "btns_popup":
		var url = "CPS_GEM_0105.do";
		var winName = "CPS_GEM_0105";
		if (reqWin != null) {
			reqWin.close();
		}
		reqWin = ComOpenWindowCenter("about:blank",winName,700,430, false);
	    var form1 = document.form1;
	    form1.pln_yrmon.value = frm.pln_yrmon.value.substring(0,4);
	    form1.prg_id.value = "0002";
	    form1.rqst_ofc_cd.value = frm.ofc_lvl3.value;
	    var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);
	    if (gen_expn_rqst_tp_cd == "EA") {
	    	gen_expn_rqst_tp_cd = "EA,ET";
	    }
	    form1.gen_expn_rqst_tp_cd.value = gen_expn_rqst_tp_cd ;
	    form1.action = url;        
	    form1.target = winName;
	    form1.submit();
	    form1.target = "";	    
	    break;

		
	case "sum_up":		
		if (frm.sum_up[2].checked && frm.curr_cd[0].checked) {			
			//msgs["GEM01079"] = "You should change CUR (USD or KRW)";
			ComShowCodeMessage("GEM01079");
			frm.curr_cd[1].checked = true;
		}
		
		break;	
	case "curr_cd":		
		if (frm.sum_up[2].checked && frm.curr_cd[0].checked) {			
			//msgs["GEM01079"] = "You should change CUR (USD or KRW)";
			ComShowCodeMessage("GEM01079");
			frm.curr_cd[1].checked = true;
		}
		break;
	case "ofc_expn_div":				
		frm.ofc_expn_cd.value = "";
		break;		
	case "lang_div":				
		setExpnGroupList();
		break;
		
	} 
		
}


/**     
* EI, EA onchange시  
*/
function onChagneRqstTpCd() {
	
	var gen_expn_rqst_tp_cd = ComGetObjValue(frm.gen_expn_rqst_tp_cd);	
	
	if ( gen_expn_rqst_tp_cd == "EI" ) {
		//예산년월
		var clzYrmon = 	initDateVO["clz_yrmon"];		
		frm.pln_yrmon.value = clzYrmon;
	} else {
		//예산년월
		var clzYrmon = 	closingDateVO["clz_yrmon"];		
		frm.pln_yrmon.value = clzYrmon;

	}
	
	initStatusImg();
	
	sheet1.RemoveAll();
	
	frm.gen_expn_rqst_no.value = "";
}

function initStatusImg() {
	
	document.getElementById("imgRq1").src = "img/btng_icon_g.gif";
	document.getElementById("imgRq2").src = "img/btng_icon_g.gif";
	document.getElementById("imgRq3").src = "img/btng_icon_g.gif";
	document.getElementById("imgHq1").src = "img/btng_icon_g.gif";
	document.getElementById("imgHq2").src = "img/btng_icon_g.gif";
	document.getElementById("imgHq3").src = "img/btng_icon_g.gif";
	document.getElementById("imgTc1").src = "img/btng_icon_g.gif";
	document.getElementById("imgTc2").src = "img/btng_icon_g.gif";
	document.getElementById("imgTc3").src = "img/btng_icon_g.gif";
	document.getElementById("imgCo1").src = "img/btng_icon_g.gif";
	document.getElementById("imgCo2").src = "img/btng_icon_g.gif";
	document.getElementById("imgCo3").src = "img/btng_icon_g.gif";
	

}





/**
* Form 이벤트 등록
*/
function initControl() {
 //keypress
 axon_event.addListenerForm('keypress','frm_keypress',frm);
 //keyup
 axon_event.addListenerForm('keyup','frm_keyup',frm);
 // focus out
 axon_event.addListenerFormat('blur','frm_deactivate',frm);    
 // focus in
 axon_event.addListenerFormat('focus','frm_activate',frm);
 
}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function frm_keypress() {

    switch (event.srcElement.name) {
    case "gen_expn_rqst_no":
		if (frm.gen_expn_rqst_no.value.length > 0 && event.keyCode == 13) {
			doActionIBSheet(SEARCHLIST);
		}   

		break;
    case "ofc_expn_cd":
  		if (frm.ofc_expn_div[0].checked) {
  			
  		} else if (frm.ofc_expn_div[1].checked) {
  			ComKeyOnlyNumber(event.srcElement);
  		} else {
  			event.returnValue = false;
  			break;
  		}
  		
 		if ( ( (frm.ofc_expn_div[0].checked && frm.ofc_expn_cd.value.length > 3) || 
 				( frm.ofc_expn_div[1].checked && frm.ofc_expn_cd.value.length == 6) )
 				&& event.keyCode == 13) {
 			doActionIBSheet(SEARCHLIST);
 		} 
 		
  		break; 				
	}    
    
} 

/**
* HTML Control KeyPress 이벤트 호출
*/
function frm_keyup() { 	
}

/**
* HTML Control Focus out
**/
function frm_deactivate() {
	ComChkObjValid(event.srcElement);	
}

/**
* HTML Control Foucs in
*/
function frm_activate(){	
    ComClearSeparator(event.srcElement);
} 


//===================================================================================
//IBCombo 이벤트 처리
//===================================================================================
/**
* MultiSelect속성을 이용하는 경우, 체크박스를 클릭하는 순간 발생한다.
* @return
*/
function combo1_OnCheckClick(comboObj, index, code) {
	if(index==0) {
	   	//checked
	   	var bChk = comboObj.CheckIndex(index);
		for(var i = 1 ; i < comboObj.GetCount() ; i++) {
			comboObj.CheckIndex(i) = bChk;
		}
	} else {
			comboObj.CheckIndex(0) = false;
	}
}




//===================================================================================
//Sheet 이벤트 처리
//===================================================================================
/**
* sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value 
* 
*/
function sheet1_OnChange(sheet, row, col ,value) {
	
	
}






/**
* sheet1 OnClick후 이벤트
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} value 변경된 값, Format이 적용되지 않은 저장 시 사용되는 값
*/
function sheet1_OnClick(sheet , row, col, value) {	
	changeStatusImg(row);
	sheet.SelectCell(row, col); 
}
/**
* Status image 변경   
* @param {long} row 해당 셀의 Row Index
*/
function changeStatusImg(row) {
	
	 if (sheet1.CellValue(row,"fm_gen_expn_itm_desc") == "SUB TOTAL") {
		 return;
	 }
	 
	 /*
	 # Adjustment/Approval 버튼 비활성화

	 1. 사용자 오피스와 승인 오피스가 틀린경우
	 2. CO에서 AP가 된 Request
	 3. 로그인 사용자가 사무국이 아니면서 진행상태가 CO인경우
	 4. 로그인 사용자가 Approval권한이 없는경우		
	*/
	 
	//로그인 ofc_cd 와 같은경우만 실행
	var genExpnAproAuthOfcCd =
		sheet1.CellValue(row,"gen_expn_apro_auth_ofc_cd");		
	var usrOfcCd = frm.usr_ofc_cd.value;
	var authFlg = frm.auth_flg.value;
	
	var diableBtn = false;
	
	if (usrOfcCd != genExpnAproAuthOfcCd ) {
		diableBtn = true;		
	}
	
	if ( sheet1.CellValue(row,"crnt_gen_expn_apro_step_cd") == "CO"
	        && sheet1.CellValue(row,"crnt_gen_expn_apsts_cd") == "AP") {
		diableBtn = true;
	}
	    	
	if (authFlg != "YNYY" && 
			sheet1.CellValue(row,"crnt_gen_expn_apro_step_cd") == "CO") {
		diableBtn = true;
	}
	
	// approval권한이 없는 경우 break GEM01,GEM02 requester
	var usrRole = frm.usr_role.value;
	
	if ( !(usrRole.indexOf("GEM03") != -1  || usrRole.indexOf("GEM04") != -1  
			|| usrRole.indexOf("GEM05") != -1)) {
		diableBtn = true;
	}
	
	
	if (diableBtn) {
		document.getElementById("btn1_Approval").style.color = "#CDCDCD"; 
		document.getElementById("btn1_Adjustment").style.color = "#CDCDCD";
	} else {
		document.getElementById("btn1_Approval").style.color = "#000000"; 
		document.getElementById("btn1_Adjustment").style.color = "#000000";
	}
	
	 
	 
     var queryString = getSheetRowQueryString(sheet1, row);
	
	 var param = "f_cmd=" + SEARCHLIST01;
	
	 param +=  "&" + queryString;
	
	 var sXml = sheet2.GetSearchXml("CPS_GEM_0002GS.do", param);		
	 	 
	 var ap1 = ComGetEtcData(sXml,"RQ");
	 var ap2 = ComGetEtcData(sXml,"HQ");;
	 var ap3 = ComGetEtcData(sXml,"TC");;
	 var ap4 = ComGetEtcData(sXml,"CO");;
	 
	 initStatusImg();	 

	 if(ap1 == "RQ" || ap1 == "AD") {
		 document.getElementById("imgRq1").src = "img/btng_icon_y.gif";
	 } else if(ap1 == "RJ") {
		 document.getElementById("imgRq2").src = "img/btng_icon_r.gif";
	 } else if(ap1 == "AP") {
		 document.getElementById("imgRq3").src = "img/btng_icon_green.gif";
	 }
	 
	 if(ap2 == "RQ" || ap2 == "AD") {
		 document.getElementById("imgHq1").src = "img/btng_icon_y.gif";
	 } else if(ap2 == "RJ") {
		 document.getElementById("imgHq2").src = "img/btng_icon_r.gif";
	 } else if(ap2 == "AP") {
		 document.getElementById("imgHq3").src = "img/btng_icon_green.gif";
	 }
	 
	 if(ap3 == "RQ" || ap3 == "AD") {
		 document.getElementById("imgTc1").src = "img/btng_icon_y.gif";
	 } else if(ap3 == "RJ") {
		 document.getElementById("imgTc2").src = "img/btng_icon_r.gif";
	 } else if(ap3 == "AP") {
		 document.getElementById("imgTc3").src = "img/btng_icon_green.gif";
	 }
	 
	 if(ap4 == "RQ" || ap4 == "AD") {
		 document.getElementById("imgCo1").src = "img/btng_icon_y.gif";
	 } else if(ap4 == "RJ") {
		 document.getElementById("imgCo2").src = "img/btng_icon_r.gif";
	 } else if(ap4 == "AP") {
		 document.getElementById("imgCo3").src = "img/btng_icon_green.gif";
	 }
}

/**
* sheet1 doubleClick후 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
*/
function sheet1_OnDblClick(sheet, row, col) {
	
	
}

/**
* sheet1 MouseMove 이벤트 
* @param {ibsheet} sheet 해당 시트   
* @param {int} button 마우스버튼 방향, 1:왼쪽, 2:오른쪽
* @param {lnt} shift Shift키가 눌린 경우 1, Ctrl키가 눌린 경우 2, 그외0
* @param {long} X X 좌표
* @param {long} Y Y 좌표
*/
function sheet1_OnMouseMove(sheet , button, shift, X, Y) {
   var sName = sheet1.ColSaveName(sheet1.MouseCol);   
   if (sheet1.MouseRow > 0 && "fm_gen_expn_cd" == sName) {	   
	   if (ComGetObjValue(frm.lang_div) == "KOR") {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_krn_abbr_nm");   
	   } else {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_eng_abbr_nm");
	   }	   		   
   } else if (sheet1.MouseRow > 0 && "to_gen_expn_cd" == sName) {
	   if (ComGetObjValue(frm.lang_div) == "KOR") {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_krn_abbr_nm");   
	   } else {
		   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_eng_abbr_nm");
	   }		   
   } else if (sheet1.MouseRow > 0 && "fm_locl_curr_cd" == sName) {
	   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"fm_ut_val");		   
   } else if (sheet1.MouseRow > 0 && "to_locl_curr_cd" == sName) {
	   sheet1.MouseToolTipText = sheet1.CellText(sheet1.MouseRow,"to_ut_val");		   
   } else {
	   sheet1.MouseToolTipText = "";
   }
 
}


function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		return;
	}
	
	if(frm.sum_up[1].checked){		
		sheet.Redraw = false;
		sheet.ShowSubSum("fm_ofc_cd", "8|9|10|11", -1, false,false, -1,"1=;5=SUB TOTAL");
		sheet.Redraw = true;
	}
	
	if(frm.sum_up[2].checked){
		sheet.Redraw = false;
		sheet.ShowSubSum("fm_gen_expn_cd", "8|9|10|11", -1, false,false, -1,"1=;5=SUB TOTAL");
		sheet.Redraw = true;
	}
	
	sheet.SumText(0,1)="";
	sheet.SumText(0,"fm_gen_expn_itm_desc")="Grand Total";
	
	sheet.ApplyFormat() ;
	
}



/**
* 업무 처리 이벤트
* @param {string} sAction 액션타입 
*/
function doActionIBSheet(sAction) {

	//[Retrive]
	if (sAction == SEARCHLIST) {
		
		//폼숨김
		frm.fm_gen_expn_cd_grp.value = combo1.Code;
		frm.f_cmd.value = SEARCHLIST;		
		sheet1.RemoveAll();
		sheet1.DoSearch4Fx("CPS_GEM_0002GS.do", FormQueryString(frm));
		if (sheet1.RowCount == 0) {
			//msgs["GEM00013"] = "There is no related data!";
			ComShowCodeMessage("GEM00013");
			return;
		} else {
			changeStatusImg(sheet1.SelectRow);
		}
		
    //[open]	 	
	} else if (sAction == INIT) {
		
		frm.f_cmd.value = INIT;		
		var sXml = sheet2.GetSearchXml("CPS_GEM_0001_03GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");
		var authFlg  = "";
		
		// 로그인 오피스 정보 
		if (arrXml.length > 0) {			
			
			//사용자 오피스 설정
			frm.usr_ofc_cd.value = ComGetEtcData(arrXml[0], "usr_ofc_cd");
			
			var list = ComXml2ListMap(arrXml[0]);
			var officeLevelVo  = list[0];			
			authFlg  = officeLevelVo["auth_flg"];
			
			// BU	
			if ( authFlg == "YYYN" ) {				
				//비용주관팀  TIC 설정 Authorized Expense Code
				frm.usr_tic_cd.value = frm.usr_ofc_cd.value;				
			// 사무국
			} else if ( authFlg == "YNYN" || authFlg == "YNYY") {				
				//사무국인경우 수퍼유저가 아니경우 비용팀으로 권한 설정
				if (authFlg == "YNYY") {
					if ( frm.usr_auth_tp_cd.value != USR_AUTH_TP_CD ) {
						authFlg = "YNYN";
					}
				}
				
				//비용주관팀  TIC 설정 Authorized Expense Code 
				if (authFlg == "YNYN") {
					frm.usr_tic_cd.value = frm.usr_ofc_cd.value;
				}
				
			} else if ( authFlg == null || authFlg == "" || authFlg == "NNNN") {
				goNoAuthority();
		    }
			
			//권한 설정
			frm.auth_flg.value = authFlg;
			
			// ---------------------------------
			// TIC 콤보박스  설정
			// ---------------------------------	
			var ticList = ComGetEtcData(arrXml[0], "ticCd").split("|");
			
			var tic_cd = frm.fm_tic_cd;
			tic_cd.length = 0;
			
			ComAddComboItem(tic_cd,"","");
			
			for(var i=0 ; i < ticList.length ; i++ ) {			
				ComAddComboItem(tic_cd,ticList[i],ticList[i]);
			}		
			
			// ---------------------------------
			//사용자 role설정 
			// ---------------------------------			
			frm.usr_role.value = ComGetEtcData(arrXml[0], "usrRole");
			
			
		}
		
		// 로그인 사용자 오피스 정보
		if (arrXml.length > 1) {
			var list = ComXml2ListMap(arrXml[1]);
			if (list.length > 0) {
				var officeHierarchyVO  = list[0];
				var level1   = officeHierarchyVO["level1"];
				var level2   = officeHierarchyVO["level2"];
				var level3   = officeHierarchyVO["level3"];
				var level4   = officeHierarchyVO["level4"];
				var rgnOfcFlg  = officeHierarchyVO["rgn_ofc_flg"];
				
				if ("N" == rgnOfcFlg) {
					frm.sls_ofc_div_cd[0].checked = true;
				} else {
					frm.sls_ofc_div_cd[1].checked = true;
				}
				
			    //권한 설정
				var authFlg = frm.auth_flg.value;	  

				//집행단위.지역그룹
				if ( authFlg == "YNNN" || authFlg == "YYNN" ) {
					ComEnableObject(frm.ofc_lvl1, false);
					ComEnableObject(frm.ofc_lvl2, false);
					ComEnableObject(frm.ofc_lvl3, false);
					if ( authFlg == "YYNN" ) {
						ComEnableObject(frm.ofc_lvl3, true);
					}
					frm.sls_ofc_div_cd[0].disabled=true;
					frm.sls_ofc_div_cd[1].disabled=true;
					//LV1
					ComSetObjValue(frm.ofc_lvl1,level2);					
					//LV2
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST01','sheet2','sls_ofc_div_cd','1','document.form.ofc_lvl');			
					ComSetObjValue(frm.ofc_lvl2,level3);					
					//LV3
					selLevelChange('GEM_COMMONGS.do','SEARCHLIST02','sheet2','sls_ofc_div_cd','2','document.form.ofc_lvl');			
					ComSetObjValue(frm.ofc_lvl3,level4);					
									
				//사무국 , BU ,TIC
				} else if ( authFlg == "YNYN" || authFlg == "YNYY" || authFlg == "YYYN") {
					ComEnableObject(frm.ofc_lvl1, true);
					ComEnableObject(frm.ofc_lvl2, true);
					ComEnableObject(frm.ofc_lvl3, true);				
					frm.sls_ofc_div_cd[0].checked = false;
					frm.sls_ofc_div_cd[1].checked = false;
				} else {
					ComEnableObject(frm.ofc_lvl1, false);
					ComEnableObject(frm.ofc_lvl2, false);
					ComEnableObject(frm.ofc_lvl3, false);		
					frm.sls_ofc_div_cd[0].disabled=true;
					frm.sls_ofc_div_cd[1].disabled=true;
				}
								
				frm.ofc_lvl3.blur();
			}
			
		}		
		
		// additional 마감 정보
		if (arrXml.length > 2) {
			var list = ComXml2ListMap(arrXml[2]);
			if (list.length > 0) {
				closingDateVO  = list[0];
				var clzYrmon = 	closingDateVO["clz_yrmon"];
				//마감정보 설정
				frm.pln_yrmon.value = clzYrmon;
			}
		}
		
		
		// ---------------------------------
		// Expense Code group code 
		// ---------------------------------
		if (arrXml.length > 3) {
			expnGroupList = ComXml2ListMap(arrXml[3]);		
			setExpnGroupList();		
		}
		
		// initial 마감 정보
		if (arrXml.length > 4) {
			var list = ComXml2ListMap(arrXml[4]);
			if (list.length > 0) {
				initDateVO  = list[0];
			}
					
		}	

		
	// Page Onload 시 Lvl 1 콤보 취득  
	}  else if (sAction == SEARCHLIST20) {		
		
		frm.f_cmd.value = SEARCH;

		var sXml = sheet2.GetSearchXml("GEM_COMMONGS.do", FormQueryString(frm));
		
		// LEVEL2 조회
		var comboListData = ComGetEtcData(sXml, "searchBUOfficeList").split("|");
		
		if (typeof comboListData != "undefined" && comboListData != "") {
			// Search
			var ofc_lvl1 = frm.ofc_lvl1;
			ofc_lvl1.length = 0;
			ComAddComboItem(ofc_lvl1, "", "");
			
			for ( var i = 0; i < comboListData.length; i++) {
				ComAddComboItem(ofc_lvl1, comboListData[i], comboListData[i]);
			}
			
		}

	} 	

}
