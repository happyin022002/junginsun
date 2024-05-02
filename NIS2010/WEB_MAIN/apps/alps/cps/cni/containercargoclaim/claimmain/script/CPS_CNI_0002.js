/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0002.js
 *@FileTitle : [CPS_CNI_0002] Find
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [cps_cni_0002] Find
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function cps_cni_0002() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
    this.validateForm = validateForm;
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

// IBmultiCombo
var comboObjects = new Array();
var comboCnt = 0;
var combo1 = null;

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
  * IBCombo Object를 배열에 등록
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++] = comboObj;
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

	// IBMultiCombo초기화
	combo1 = comboObjects[0];
	comboCnt = comboObjects.length;

	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}

	initComboBox();
    
    //Form 이벤트 등록
    initControl();

	ComSetFocus(frm.sch_str);
    
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
   axon_event.addListenerForm('change', 'obj_change', frm);
}

 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {

 	var sXml2 = frm.sXml.value;	

 	var arrXml = sXml2.split("|$$|");

 	setMultiComboBox("combo1" ,  arrXml[0] ); //09 Area
 	
}



/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
        var cnt = 0;
        switch(sheetObj.id) {
            case "sheet1":      //sheet1 init
                with (sheetObj) {

                    // 높이 설정
					style.height = 450;
										
					//전체 너비 설정
					SheetWidth = mainTable.clientWidth;

					//Host정보 설정[필수][HostIp, Port, PagePath]
					if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

					//전체Merge 종류 [선택, Default msNone]
					MergeSheet = msHeaderOnly;

					//전체Edit 허용 여부 [선택, Default false]
					Editable = true;

					//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
					InitRowInfo(1, 1, 15, CNI_PAGE_SIZE);

					var HeadTitle1 = "Seq.|CL|Claim No.|B/L No.|CNTR No.|VVD|A|HOFC|Handler|STS|DOF|INC No.|VOC No.|DOU|Claimant|Claimant|Claim Amount(LCL)|Curr|Claim Amount(USD)|TOS|Settled Amount(LCL)|Curr|Settled Amount(USD)|Liable Party|Insurer|Insurer Ref No.|IMS No.";
					var headCount = ComCountHeadTitle(HeadTitle1);
										
					//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
					InitColumnInfo(headCount, 3, 0, true);

					// 해더에서 처리할 수 있는 각종 기능을 설정한다
					InitHeadMode(true, true, false, true, false,false);

					//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
					InitHeadRow(0, HeadTitle1, true);
                   
                    //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	               
					InitDataProperty(0, cnt++ , dtSeq,		50,		daCenter,	true,		"",							false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"cgo_clm_div_cd",			false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"cgo_clm_no",				false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"cgo_clm_ref_bl_no",		false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"cgo_clm_ref_cntr_no",		false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"trnk_ref_vvd_no",			false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"clm_area_cd",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"hdlr_ofc_cd",				false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		60,		daCenter,	true,		"hdlr_usr_id",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"sts_cd",					false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"fmal_clm_rcv_dt",			false,  "",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		90,		daCenter,	true,		"cgo_clm_inci_no",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"crm_voc_no",				false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		80,		daCenter,	true,		"upd_dt",					false,	"",		dfDateYmd,		0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		20,		daCenter,	true,		"clmt_clm_tp_cd",			false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daLeft,		true,		"claimant",					false,  "",		dfNone,			0,	false,		false);
						
					InitDataProperty(0, cnt++ , dtAutoSum,	140,	daRight,	true,		"clmt_locl_amt",			false,  "",		dfFloat,		2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"clmt_locl_curr_cd",		false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	140,	daRight,	true,		"clmt_usd_amt",				false,  "",		dfFloat,		2,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		30,		daCenter,	true,		"cgo_clm_stl_tp_cd",		false,	"",		dfNone,			0,	false,		false);
					
					InitDataProperty(0, cnt++ , dtAutoSum,	140,	daRight,	true,		"cgo_clm_stl_locl_amt",		false,  "",		dfFloat,		2,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		40,		daCenter,	true,		"cgo_clm_stl_locl_curr_cd",	false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtAutoSum,	140,	daRight,	true,		"cgo_clm_stl_usd_amt",		false,  "",		dfFloat,		2,	false,		false);
					
					InitDataProperty(0, cnt++ , dtData,		80,		daLeft,		true,		"liable_party",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		50,		daCenter,	true,		"clm_pty_abbr_nm",			false,  "",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"insur_ref_no",				false,	"",		dfNone,			0,	false,		false);
					InitDataProperty(0, cnt++ , dtData,		100,	daCenter,	true,		"past_cgo_clm_no",			false,  "",		dfNone,			0,	false,		false);
										
					//CountPosition = 0;
					CountFormat = "[SELECTDATAROW / TOTALROWS]";
               }
                break;

        }
}

/**
 * Combo 기본 설정 
 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
 **/
function initCombo(comboObj, comboNo) {

	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.BackColor = "#ffffff";
		comboObj.SetColAlign("center|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
	}
} 

// ===================================================================================
// Private function
// ===================================================================================

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn1_Retrieve":
				var schStr = frm.sch_str.value;
				if (ComIsNull(schStr)) {
					//msgs["CNI00018"] = "Please select {?msg1}";
					ComShowCodeMessage("CNI00009" , "the Data");
					ComSetFocus(frm.schStr);
					return;
				}
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";
				
				doActionIBSheet(SEARCHLIST01);			
				break;	

			case "btn1_New":
				ComResetAll();
				ComSetFocus(frm.sch_str);
				break;

			case "btn1_Main":
				var cgoClmNo = sheet1.CellValue(sheet1.SelectRow , "cgo_clm_no");
				location.href = "CPS_CNI_0003.do?pgmNo=CPS_CNI_0003&cgo_clm_no="+cgoClmNo;
				break;

			case "btn1_Print":
				if (sheet1.RowCount <= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
		} // end switch

}

function obj_change() {
    switch (event.srcElement.name) {    
    case "vt":
		//값변경시 자동조회
		sheet1.RemoveAll();//append mode이므로 remove 해야함.
		frm.page_no.value="1";
		doActionIBSheet(SEARCHLIST01);
		break;
	}
}

/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
    switch (event.srcElement.name) {    
		case "sch_str":
			if (!ComIsNull(frm.sch_str.value) && event.keyCode == 13) {

				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}
 
function combo1_OnChange(comboObj, Index_Code, Text) {
	var formObj = document.form;
	comboText1 = Text;
	formObj.misc_cd.value = ComGetObjValue(comboObj);

    //값변경시 자동조회
	sheet1.RemoveAll();//append mode이므로 remove 해야함.
	frm.page_no.value="1";
	doActionIBSheet(SEARCHLIST01);

}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
/**
 * row double click 시 CPS_CNI_0003 화면전환
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */

function sheet1_OnDblClick(sheet, row, col) {
	var cgoClmNo = sheet1.CellValue(row , "cgo_clm_no");
	location.href = "CPS_CNI_0003.do?pgmNo=CPS_CNI_0003&cgo_clm_no="+cgoClmNo;	
}


 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
 }

 function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {		
	frm.page_no.value = PageNo;  
	doActionIBSheet(SEARCHLIST01);
 }   

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;	

		var sXml = sheet1.GetSearchXml("CPS_CNI_0002GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[0], true);
		}

	} else if (sAction == PRINT) {		
		frm.f_cmd.value = PRINT;
		frm.page_no.value = "";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf = "/rf ["+RDServerIP + "/CPS_CNI_0061.do]";
		var rpost =  "/rpost ["+FormQueryString(frm)+"]"
		var rpaper = "/rpaper [A4]";
		
		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		var rv = "";
		frm.com_mrdArguments.value = rf + " "  + rpost +  " "  + rpaper;	
		frm.com_mrdBodyTitle.value = "Find-Print";		
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaim/claimmain/report/CPS_CNI_0061.mrd";
		popupRd(1000,600);
	} 
}

/**
* IBMultiComboBox 설정<br>
* @param {select box} 콤보 객체
* @param {xml} code , name의 xml
* @param {String} 초기 선택 Code 
*/
function setMultiComboBox(pComboObjId, pXML) {
	var vComboObj      = null; // IBMultiComboBox
	var vArrayListData = ""; 
	var vListData      = "";
	var vCaptionText   = "";
	
	vComboObj = getComboObject(pComboObjId);
	
	if (vComboObj == null || pXML == null ) {
		return;
	}

	var vArrayListData = SheetXml2ListMap(pXML);

	vComboObj.InsertItem(0, "|", "");
	for ( var idx = 1; idx < vArrayListData.length+1; idx++) {
		vListData = vArrayListData[idx-1];
		vCaptionText = vListData["code"] + "|" + vListData["name"];
		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
	}//end for

}


/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
 **/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}


/**
 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
//            if (!isNumber(formObj.iPage)) {
//                return false;
//            }
	}

	return true;
}