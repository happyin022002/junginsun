/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0028.js
 *@FileTitle : [CPS_CNI_0028] Miscellaneous Code Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.14
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.10.14 박제성
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2010.10.11 이준범[CHM-201006346-01] CNI UI 변경 요청
 * 1. UI_CNI_0028 : Miscellaneous Code -Creation
 *    Class 가 CCC-Type of Cargo 일시 Code 의 입력자릿수를 4자리에서 3자리로 변경 함
=========================================================*/

/**
 * [CPS_CNI_0028] Miscellaneous Code Creation
 * @extends
 * @class Miscellaneous Code Creation 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */

function cps_cni_0028() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
    
    this.sheet1_OnClick = sheet1_OnClick;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================

// ===================================================================================
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var comboCnt = 0;

var classCodeList = null;

// html form
var frm = null;


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

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage() {
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
	 //IBMultiCombo초기화
	 combo1 = comboObjects[0];
	 comboCnt = comboObjects.length;
	 for(var k=0;k<comboObjects.length;k++){
	 	initCombo(comboObjects[k]);
	 }
    
    //Form 이벤트 등록
    initControl();
    initPage();
    
}

function initPage() {
	sheet1.WaitImageVisible = false;	
	doActionIBSheet(INIT); 	
	combo1.Code = "09";        
	sheet1.WaitImageVisible = true;    	
}

/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   // focus in
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   // focus out
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}



/**
* 콤보 초기설정값
* @param {IBMultiCombo} comboObj  comboObj
*/
function initCombo(comboObj) {
	//comboObj.MultiSelect = false;
	comboObj.UseCode = true;
	comboObj.LineColor = "#ffffff";
	comboObj.SetColAlign("left|left");
	comboObj.MultiSeparator = ","; 
	comboObj.DropHeight = 240;

}

function combo1_OnChange(comboObj,Index_Code, Text){  	
	
	doActionIBSheet(SEARCHLIST01);
	// Type of Cargo 일때만, Code 입력 가능한 글자수를 3으로 제한한다.
	var classCd = Index_Code ;
	
	if (classCd == "15") {
		sheetObjects[0].InitDataProperty(0, 2 , dtData,			80,		daCenter,	true,		"clm_misc_cd",	true,       "",			dfNone,		0, 		false, 		true, 		3, 		false, true, "", true);
	}else{
		sheetObjects[0].InitDataProperty(0, 2 , dtData,			80,		daCenter,	true,		"clm_misc_cd",	true,       "",			dfNone,		0, 		false, 		true, 		4, 		false, true, "", true);		
	}
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
			style.height = 420;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			MergeSheet = msHeaderOnly;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=500]
			InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

			var HeadTitle1 = "|Seq.|Code|Order|Name|Register|RGOFC|Update|Remark|ClassCd";
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);

			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false, false);

			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
           
            //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
            InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
            
			InitDataProperty(0, cnt++ , dtSeq,			60,		daCenter,	true,		"seq",			false,		"",			dfNone,		0,		true,		true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"clm_misc_cd",	true,       "",			dfNone,		0, 		false, 		true, 		4, 		false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"dp_seq",		true,       "",			dfNone,		0, 		true, 		true, 		3, 		false, true, "", true);
			InitDataProperty(0, cnt++ , dtData,			140,	daLeft,		true,		"clm_misc_nm",	false,      "",			dfNone,		0,		true,		true,  		200 );
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cre_usr_id",	false,		"",			dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"cre_ofc_cd",	false,      "",			dfNone,		0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			100,	daCenter,	true,		"upd_dt",		false,      "",			dfDateYmd,	0,		false,		false);
			InitDataProperty(0, cnt++ , dtData,			120,	daLeft,		true,		"clm_misc_rmk",	false,		"",			dfNone,		0,		false,		false, 		400 );
			
			InitDataProperty(0, cnt++ , dtHidden,	0,		daCenter,	true,		"clss_clm_misc_cd");
						
			InitDataValid(0,    "clm_misc_cd",    vtEngUpOther, "1234567890");
			InitDataValid(0,    "dp_seq",    vtNumericOnly);
			
			PopupImage  =  "img/btns_note.gif";
			ShowButtonImage = 1;
			
			break;		
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================

/**
 * Location 설정
 */
 function setLocation(rowArray) { 
    frm.loc_cd.value = rowArray[0][3];
 }

 function setClassCodeList() {

		combo1.RemoveAll();			
			
		for(var i=0 ; i < classCodeList.length ; i++ ) {			
			var clist = classCodeList[i];			
			combo1.InsertItem(i,clist["clss_clm_misc_nm"],clist["clss_clm_misc_cd"]);
		}		
	}

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	
	
		case "btn2_Row_Add":
			var row = sheet1.DataInsert(-1);		
			sheet1.SelectCell(row,"clm_misc_cd",true);			
			break;
	    case "btn2_Row_Copy":	    	
	    	var row = sheet1.DataCopy();
	    	sheet1.RowStatus(row) = "I";	    	  
			break;
		case "btn2_Row_Delete":			
			SheetRowDelete(sheet1,sheet1.SelectRow);
	        break; 	     
		case "btn1_Retrieve":
			
			doActionIBSheet(SEARCHLIST01);			
			break;	
	    case "btn1_New":
	    	if (ComShowCodeConfirm("CNI00015")) {
	    		initPage();
	    	}
	        break;	
		case "btn1_Save":
			frm.f_cmd.value = MULTI;		
			if(ComChkValid(frm)) {
				//CNI00012(Do you want to save changes?)
				if (ComShowCodeConfirm("CNI00012")) {
					doActionIBSheet(MULTI);
				}
			}			
	        break;         
	}

}


/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
    case "acct_xch_rt_yrmon":    	
    case "usd_krw_xch_rt":
		break;
	}
}

 
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm = document.form;
	switch (event.srcElement.name) {
	case "acct_xch_rt_yrmon":
		break;
	case "usd_krw_xch_rt":		
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}


/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * 이미지 팝업 클릭
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */
function sheet1_OnPopupClick(sheet, row, col) {
    //
    if (sheet.ColSaveName(col) == "clm_misc_rmk") {
		ComShowMemoPad(sheet);
	}
}


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {
		
		frm.clss_clm_misc_cd.value = combo1.Code;
		frm.f_cmd.value = SEARCHLIST01;		
		var sXml = sheet1.GetSearchXml("CPS_CNI_0028GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// sheet  설정 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0]);			
		}else{
			ComShowCodeMessage("CNI00013");
		}
		 	
		
	} else if (sAction == MULTI) {		
		
		if (validateForm(sAction)) {
			frm.f_cmd.value = MULTI;
			setSheetClassCd();
			
			var sXml = sheet1.DoSave("CPS_CNI_0028GS.do", FormQueryString(frm),-1,false);
			if(sXml) {
				doActionIBSheet(SEARCHLIST01);
			}
		}
		
	} else if (sAction == INIT) {
		
		frm.f_cmd.value = INIT;
		var sXml = sheet1.GetSearchXml("CPS_CNI_0028GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// combo  설정 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
						
			classCodeList = SheetXml2ListMap(arrXml[0]);		
			setClassCodeList();	
		}
		
	}  
 
}
 
function sheet1_OnClick(sheetObj, row, col, value) {

       //desc 셀을 클릭했을때 MemoPad를 표시한다.(MemoPad 편집가능)
        if (sheetObj.ColSaveName(col) == "clm_misc_rmk") {	 

//        	ComShowMemoPad(sheetObj, row, col, bReadOnly, iWidth, iHeight, iMax)
        	ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
		}
 		
}

/**
* Miscellaneous Code Creation from sheet1 편집처리후 이벤트
* @param {long} row 해당 셀의 Row Index
* @param {long} col 해당 셀의 Column Index
* @param {string} col 해당 셀의 value
*/
function sheet1_OnChange(sheetObj , row , col , value) {

/*
	// 시트의 code 을 입력/수정 하였을 경우
	if(col == "2") {
		// Type of Cargo(15)
		var clssCd = combo1.Code;
        var cdLen  = value.length;
        
		if (clssCd == "15") {
			if (cdLen == "4") {
				ComAlertFocus(sheetObj, ComGetMsg("CNI09009", "Code", "3"));
				sheetObj.CellValue2(row, col) = "";
				sheetObj.SelectCell(row, col, true);
			}
		}
	}
*/
}
 
 
//===================================================================================
//Private function
//===================================================================================

function setSheetClassCd() {
	
	for(var row=0; row<=sheet1.LastRow; row++) {
			
		if (sheet1.RowStatus(row) == "I")  {	
			var clss_cd = combo1.Code;
			sheet1.CellValue2(row , "clss_clm_misc_cd") = clss_cd;				
		}
	}
}


/**
* 화면 폼입력값에 대한 유효성검증 프로세스 처리
*/
function validateForm(sAction){
	
	for(var row=0; row<=sheet1.LastRow; row++) {
		
		if (sheet1.RowStatus(row) == "I")  {			
			var misc_cd = sheet1.CellValue(row , "clm_misc_cd");
			for(var row2=0; row2<=sheet1.LastRow; row2++) {
				var misc_cd2 = sheet1.CellValue(row2 , "clm_misc_cd");
				if( (misc_cd==misc_cd2)&&(row!=row2) ){
					ComShowCodeMessage("CNI00002" , "Code"); //CNI00002
					return false;
				}
			}			
		}
	}
	return true;
}



