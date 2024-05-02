/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CPS_CNI_0009.js
 *@FileTitle : [CPS_CNI_0009] Handling Costs
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.07
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.04.17 양정란
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0009] Handling Costs
 * @extends
 * @class Handling Costs 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
function CPS_CNI_0009() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
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

// html form
var frm = null;
var frm2 = null;

// grid combo
var comboText = "";
var comboCode = "";

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
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
	frm2 = document.form2;//멀티콤보용
    sheet1 = sheetObjects[0];    
    sheetCnt = sheetObjects.length ;

	//initSheet 보다 먼저해준다.
	initComboBox();
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }

	//초기값세팅
	ComSetFocus(frm.cgo_clm_no);
   
    //Form 이벤트 등록
    initControl();
    
    if(frm.cgo_clm_no.value == ""){
    	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn2_Row_Add,btn2_Row_Delete,btn2_Row_Copy,btn2_Down_Excel,btn2_Load_Excel","Y");
    }else{
    	setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn2_Row_Add,btn2_Row_Delete,btn2_Row_Copy,btn2_Down_Excel,btn2_Load_Excel","N");
    }
    
	if(frm.cgo_clm_no.value.length == 10){
		doActionIBSheet(SEARCHLIST01);
	}
}

/**
* Form 이벤트 등록
*/
function initControl() {
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
   axon_event.addListenerForm('keyup', 'obj_keyup',frm);
}

 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {

 	var sXml2 = frm2.sXml.value;	

 	var arrXml = sXml2.split("|$$|");

 	setMultiComboBox(arrXml[0] ); //30
 	
}

function setMultiComboBox(pXML) {
	var vArrayListData = ""; 
	var vListData      = "";
	
	var vArrayListData = SheetXml2ListMap(pXML);
	
	for ( var idx = 0; idx < vArrayListData.length; idx++) {
	    vListData = vArrayListData[idx];
		comboText += vListData["name"] + "|" ;
		comboCode += vListData["code"] + "|" ;
	}

	comboText = comboText.substring(0, comboText.length -1);
	comboCode = comboCode.substring(0, comboCode.length -1);
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
				style.height = 342;
									
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

				var HeadTitle1 = "|SEQ|Type|Payee|ClmPtyNo|Description|Invoice No.|Inv. Date|Invoiced Amount|Currency|R.O.E|USD Amount|Rcvd Date|AP Date|Remark|CGO_CLM_NO|INV_RGST_NO|CGO_CLM_PAY_NO";

				var headCount = ComCountHeadTitle(HeadTitle1);
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 6, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
			   
				//데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN, COLMERGE,		SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
				InitDataProperty(0, cnt++ , dtHiddenStatus,	30,		daCenter,	true,		"ibflag");				
				InitDataProperty(0, cnt++ , dtSeq,			40,		daCenter,	true,		"seq",				false,		"",				dfNone,		0,			true,		true);//화면상 순서출력
				InitDataProperty(0, cnt++ , dtCombo,		140,	daCenter,	true,		"clm_cost_tp_cd",	true,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtPopup,		80,		daCenter,	true,		"clm_pty_abbr_nm",	true,		"",				dfNone,		0,			true,		true);//화면 display
				InitDataProperty(0, cnt++ , dtHidden,		100,	daLeft,		true,		"clm_pty_no",		true,		"",				dfNone,		0,			false,		false);//DB저장
				InitDataProperty(0, cnt++ , dtData,			200,	daLeft,		true,		"cost_desc",		true,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			100,	daLeft,		true,		"inv_no",			true,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"inv_dt",			true,		"",				dfDateYmd,	0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			130,	daRight,	true,		"inv_amt",			true,		"",				dfFloat,	2,			true,		true);
				InitDataProperty(0, cnt++ , dtPopupEdit,	80,		daCenter,	true,		"locl_curr_cd",		true,		"",				dfNone,		0,			true,		true, 3);
				InitDataProperty(0, cnt++ , dtPopupEdit,	70,		daRight,	true,		"inv_xch_rt",		true,		"",				dfFloat,	5,			true,		true);
				InitDataProperty(0, cnt++ , dtAutoSum,		110,	daRight,	true,		"inv_usd_amt",		true,		"",				dfFloat,	2,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			80,		daCenter,	true,		"pay_dt",			true,		"",				dfDateYmd,	0,			true,		true);
				InitDataProperty(0, cnt++ , dtData,			70,		daCenter,	true,		"ap_pay_dt",		false,		"",				dfDateYmd,	0,			false,		false);
				InitDataProperty(0, cnt++ , dtPopup,		180,	daLeft,		true,		"inv_rmk",			false,		"",				dfNone,		0,			false,		false);
				InitDataProperty(0, cnt++ , dtHidden,		80,		daCenter,	true,		"cgo_clm_no",		false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		"inv_rgst_no",		false,		"",				dfNone,		0,			true,		true);
				InitDataProperty(0, cnt++ , dtHidden,		40,		daCenter,	true,		"cgo_clm_pay_no",	false,		"",				dfNone,		0,			true,		true);

				InitDataCombo(0, "clm_cost_tp_cd", comboText, comboCode);
				ImageList(0) = "img/btns_search.gif";
				ImageList(1) = "img/btns_note.gif";

				InitDataValid(0, "locl_curr_cd",    vtEngUpOnly);
//				InitDataValid(0, "inv_no",    vtEngUpOther, "0123456789");
				
				PopupButtonImage(0, 7) = 0;
				PopupButtonImage(0, 11) = 1;	

				CountPosition = 0;
		   }
		   break;
	}
}

// ===================================================================================
// Private function
// ===================================================================================
function addComma2(obj,sFormat)
{
	try {
		//첫번째 인자가 문자열 또는 HTML태그(Object)인 경우 처리
		var sVal = getArgValue(obj);

		if(sVal == "") return "";//값이 없을때 .00000으로 세팅되는것 방지.

		switch(sFormat)
		{
			case "#,###" :
					return ComAddComma(sVal);
			case "#,###.0" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".0";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00000" :
					p = sVal.split(".");
					p[0] = ComAddComma(p[0]);

					if      (p.length == 1) return p[0]+".00000";
					else if (p.length == 2) {
						if(p[1].length == 1)return p[0]+"."+p[1]+"0000";
						if(p[1].length == 2)return p[0]+"."+p[1]+"000";
						if(p[1].length == 3)return p[0]+"."+p[1]+"00";  
						if(p[1].length == 4)return p[0]+"."+p[1]+"0";   
						if(p[1].length == 5)return p[0]+"."+p[1];
					}
					else return "";
		}
	} catch(err) { ComFuncErrMsg(err.message); }
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;

// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
function processButtonClick(){

		var srcName = window.event.srcElement.getAttribute("name");
		switch(srcName) {

			case "btn2_Row_Add":
				var row = sheet1.DataInsert(-1);		
			    sheet1.SelectCell(row,"clm_cost_tp_cd",true);
				sheet1.CellValue2(row , "cgo_clm_no") = frm.cgo_clm_no_old.value;
				break;

			case "btn2_Row_Delete":
				SheetRowDelete(sheet1,sheet1.SelectRow);
				break; 
			
			case "btn2_Row_Copy":
				var row = sheet1.DataCopy();
	    		sheet1.RowStatus(row) = "I";
	    		//CNI_CGO_CLM_PAY 에서 가져오는 항목들은 Copy 되지 않도록 함
	    		sheet1.CellValue2(row , "inv_rgst_no") = "";
	    		sheet1.CellValue2(row , "ap_pay_dt") = "";
				break;

			case "btn2_Down_Excel":
				sheet1.SpeedDown2Excel(-1)
				break; 

			case "btn2_Load_Excel":
				if(ComIsNull(frm.cgo_clm_no_old.value)){
					ComShowCodeMessage("CNI00009", "Claim No.");
					ComSetFocus(frm.cgo_clm_no);
					return;
				}
				sheet1.LoadExcel();
				//cgo_clm_no 세팅
				for(var row = 0; row <= sheet1.LastRow ; row++){
					  if(sheet1.RowStatus(row) == "I"){
						  sheet1.CellValue2(row , "cgo_clm_no") = frm.cgo_clm_no_old.value;;
					  }
				}
				
				break;

			case "btn1_close":
	    		self.close();
	    		break;	

			case "btn1_Retrieve":
				if(ComChkValid(frm)) {
					
					doActionIBSheet(SEARCHLIST01);	
				}
				break;	

			case "btn1_New":
				//CNI00015 Do you want to initialize?
				if (ComShowCodeConfirm("CNI00015") ) {
					ComResetAll();
					frm.cgo_clm_no.value = "";
					ComSetFocus(frm.cgo_clm_no);
					setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn2_Row_Add,btn2_Row_Delete,btn2_Row_Copy,btn2_Down_Excel,btn2_Load_Excel","Y");
				}
				break;

			case "btn1_Save":
				
				if(!validateForm(sheet1,frm,MULTI)){
			    	return;
			    }
				
				if(!ComChkValid(frm)) {
					return;
				}
				
				doActionIBSheet(MULTI);

				break; 

		} // end switch

}

 /**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
		case "cgo_clm_no":  
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}


/**
 * HTML Control KeyDowm 이벤트 호출
 */
function obj_keydown() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 	 
    switch (event.srcElement.name) {    
		case "cgo_clm_no":
			if (!ComIsNull(frm.cgo_clm_no.value) && event.keyCode == 13) {

				//sheet1.RemoveAll();//append mode이므로 remove 해야함.
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}

/**
 * HTML Control KeyUp 이벤트 호출
 */
function obj_keyup() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 
    switch (event.srcElement.name) {    
		case "cgo_clm_no":
			if(frm.cgo_clm_no.value.length == 10){
				//sheet1.RemoveAll();//append mode이므로 remove 해야함.
				doActionIBSheet(SEARCHLIST01);
			}
			break;
	}
}

/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm = document.form;
	switch (event.srcElement.name) {

	default:
		ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control Foucs in
 */

function obj_activate(){
    //ComClearSeparator(event.srcElement);
}


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================

 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount <= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	} else {
		for(var i = 1; i < sheet.RowCount+1; i++) {
			if( sheet.CellValue(i, "inv_no") != "" || sheet.CellValue(i, "inv_no").length > 0 ) {
				sheet.CellEditable(i, "clm_cost_tp_cd") = false;
			}
		}
	}
 }

function sheet1_OnPopupClick(sheet, row, col) {
    if (sheet.ColSaveName(col) == "inv_rmk") {
		ComShowMemoPad(sheet);
	}
	if (sheet.ColSaveName(col) == "locl_curr_cd") {
		//공통팝업 Currency 호출
		var display = "1,0,1,1,1";
		ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 500, 400, "setCurrency", display);
	}

	if (sheet.ColSaveName(col) == "inv_xch_rt") {

		if (sheet.CellValue(row , "inv_dt") == "" ) {
			//msgs["CNI00009"] = "Please input {?msg1}";
			ComShowCodeMessage("CNI00009" , "Inv Date");
			sheet.SelectCell(row,"inv_dt");
			return;
		}

		//공통팝업 ROE 호출
		var yrMon = sheet.CellValue(row , "inv_dt");
		var loclCurrCd = sheet.CellValue(row , "locl_curr_cd");
		popupRateOfExchange(loclCurrCd, yrMon);
	}
	if (sheet.ColSaveName(col) == "clm_pty_abbr_nm") {
		popupMainCodeInquiry();//CPS_CNI_0041.do 호출
	}
}

/*
 * popupMainCodeInquiry --> CPS_CNI_0041.do 에서 호출하는 함수( opener 에서 구현해야하는  함수)
 */
function setMainCodeInquiry(partyVo) {
		sheet1.CellValue(sheet1.SelectRow , "clm_pty_no") = partyVo.clm_pty_no;
		sheet1.CellValue(sheet1.SelectRow , "clm_pty_abbr_nm") = partyVo.clm_pty_abbr_nm;
}

/**
 * ROE 팝업에서 호출하는 함수
 */
 function setCurrencyROE(xchRtVo) {
	sheet1.CellValue(sheet1.SelectRow , "locl_curr_cd") = xchRtVo.curr_cd;
	sheet1.CellValue(sheet1.SelectRow , "inv_xch_rt") = xchRtVo.usd_locl_xch_rt;
 } 
 
 function setFeeUsdAmt(popRt) { 

	var amt = cniParseFloat2(sheet1.CellValue(sheet1.SelectRow , "inv_amt"));
	var rt = cniParseFloat2(sheet1.CellValue(sheet1.SelectRow , "inv_xch_rt"));
	var locl_curr_cd = sheet1.CellValue(sheet1.SelectRow , "locl_curr_cd");
	var tmpUsdAmt = "";
	
	if(rt != 0 && amt != 0  && locl_curr_cd != "" ){
		//locl_amt / xch_rt
		tmpUsdAmt = roundPrecision(amt/rt,2);
		
		sheet1.CellValue(sheet1.SelectRow, "inv_usd_amt") = tmpUsdAmt;
	}else{
		sheet1.CellValue(sheet1.SelectRow, "inv_usd_amt") = "";
	}
 }

 function setCurrency(rowArray) { 

	 sheet1.CellValue(sheet1.SelectRow , "locl_curr_cd") = rowArray[0][3];
 }

function sheet1_OnChange(sheetObj,Row, Col, Value) {

	//Currency 직접입력시 USD 일경우 ROE 1.00000를 자동 입력.
	if (sheetObj.ColSaveName(Col) == "locl_curr_cd"){
		if(Value == "USD"){
			sheetObj.CellValue2(Row, "inv_xch_rt") = "1.00000" ;
		}
	}

	 // ROE 입력후 usd_amt 설정
	 // usd_amt 항목에 계산값 Setup = ( inv_amt / R.O.E ), 소수점 세자리에서 반올림
	if (sheetObj.ColSaveName(Col) == "inv_amt" || sheetObj.ColSaveName(Col) == "locl_curr_cd" || sheetObj.ColSaveName(Col) == "inv_xch_rt"){
		setFeeUsdAmt("");
	}
	 
	 //Settlement Type 선택시 체크사항 
	 if (sheetObj.ColSaveName(Col) == "clm_cost_tp_cd"){
	 	 
		 // Settlement Type 인 경우  INT_AMT , INV_NO 는 값  세팅. 수정은 가능.
		if(sheetObj.CellValue(Row,"clm_cost_tp_cd") == "TS" || sheetObj.CellValue(Row,"clm_cost_tp_cd") == "TP" || sheetObj.CellValue(Row,"clm_cost_tp_cd") == "TC"){
			sheetObj.CellValue2(Row, "inv_no") = frm.clm_stl_auth_no.value;
			sheetObj.CellValue2(Row, "inv_amt") = frm.cgo_clm_stl_locl_amt.value;
			sheetObj.SumText(Row,"inv_no") = ""; //합계행에 Onchange Event 가 발생하는 것을 방지.
		}
	}
}

function sheet1_OnClick(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "inv_rmk") {	 
		ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
	}
}

/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */

function doActionIBSheet(sAction, flag) {

	if (sAction == SEARCHLIST01) {

		frm.f_cmd.value = SEARCHLIST01;	

		if(flag == "MULTI"){//저장후 재조회시 이미지 안보이게함.
			sheet1.WaitImageVisible = false;
		}

		var sXml = sheet1.GetSearchXml("CPS_CNI_0009GS.do", FormQueryString(frm));		
		var arrXml = sXml.split("|$$|");

		if (arrXml.length > 0) {
			sheet1.LoadSearchXml(arrXml[1]);//COST 데이타

			var list = SheetXml2ListMap(arrXml[0]);	//Main 데이타

			if (list.length > 0) {//Main 데이타가 있는 경우 ADD, DELETE, SAVE 가능
				var VO = list[0];
				frm.cgo_clm_no.value = VO["cgo_clm_no"];
				frm.cgo_clm_no_old.value = VO["cgo_clm_no"];
				frm.clm_area_cd.value = VO["clm_area_cd"];
				frm.clm_misc_nm.value = VO["clm_misc_nm"];
				frm.cgo_clm_sts_cd.value = VO["cgo_clm_sts_cd"];
				frm.cs_clz_dt.value = VO["cs_clz_dt"];
				frm.cgo_clm_stl_tp_cd.value = VO["cgo_clm_stl_tp_cd"];

				frm.pty_nm.value = VO["pty_nm"];
				frm.prlm_clm_ntc_dt.value = VO["prlm_clm_ntc_dt"];
				frm.fmal_clm_rcv_dt.value = VO["fmal_clm_rcv_dt"];//DOF
				frm.smns_sve_dt.value = VO["smns_sve_dt"];	
				
				frm.clmt_locl_amt.value = addComma2(VO["clmt_locl_amt"],"#,###.00");
				frm.clmt_locl_curr_cd.value = VO["clmt_locl_curr_cd"];
				frm.clmt_locl_xch_rt.value = addComma2(VO["clmt_locl_xch_rt"],"#,###.00000");
				frm.clmt_usd_amt.value = addComma2(VO["clmt_usd_amt"],"#,###.00");
				frm.cgo_clm_stl_locl_amt.value = addComma2(VO["cgo_clm_stl_locl_amt"],"#,###.00");
				frm.cgo_clm_stl_locl_curr_cd.value = VO["cgo_clm_stl_locl_curr_cd"];
				frm.cgo_clm_stl_xch_rt.value = addComma2(VO["cgo_clm_stl_xch_rt"],"#,###.00000");
				frm.cgo_clm_stl_usd_amt.value = addComma2(VO["cgo_clm_stl_usd_amt"],"#,###.00");//Settlement Type 선택시 INV_USD_AMT
				frm.cgo_clm_stl_dt.value = VO["cgo_clm_stl_dt"];//DOS
				frm.clm_stl_auth_no.value = VO["clm_stl_auth_no"];//Settlement Type 선택시 INV_NO
				frm.hdlr_usr_id.value = VO["hdlr_usr_id"];
				frm.hdlr_ofc_cd.value = VO["hdlr_ofc_cd"];
				
				//권한
				setRollBtnCtl(frm.hdlr_usr_id.value, frm.clm_area_cd.value, frm.hdlr_ofc_cd.value, "btn1_Save,btn2_Row_Add,btn2_Row_Delete,btn2_Row_Copy,btn2_Down_Excel,btn2_Load_Excel");

				// close case , cancel 인경우 save 버튼 비활성화
				if(frm.cgo_clm_sts_cd.value == "C" || frm.cgo_clm_sts_cd.value == "X"){
					ComBtnDisable("btn2_Row_Add");
					ComBtnDisable("btn2_Row_Delete");
					ComBtnDisable("btn2_Row_Copy");
					ComBtnDisable("btn2_Down_Excel");
					ComBtnDisable("btn2_Load_Excel");
					ComBtnDisable("btn1_Save");
				}
				
			}else{//Main 데이타가 없는 경우 

				var tepCgoClmNo = frm.cgo_clm_no.value;
				for(var i=0; i<document.forms.length; i++){
					document.forms[i].reset();
				}
				frm.cgo_clm_no.value = tepCgoClmNo;

				ComBtnDisable("btn2_Row_Add");
				ComBtnDisable("btn2_Row_Delete");
				ComBtnDisable("btn2_Row_Copy");
				ComBtnDisable("btn2_Down_Excel");
				ComBtnDisable("btn2_Load_Excel");
				ComBtnDisable("btn1_Save");
				
			}

		}

	} 
	else if (sAction == MULTI) {
		
			frm.f_cmd.value = MULTI;
			
			var param = FormQueryString(frm);
			var saveString = sheet1.GetSaveString(); 
			if (sheet1.IsDataModified  && ComIsNull(saveString) )  {//row추가하고 필수입력사항 입력안한경우	
				return;
			}
			if (!sheet1.IsDataModified  && ComIsNull(saveString) )  {//변경없이 save 버튼 누를 경우	
				ComShowMessage("There is no contents to save");
				return;
			}
			else{
			
				if (ComShowCodeConfirm("CNI00012")) {//CNI00012(Do you want to save changes?)
					param += "&" + saveString;
					var sXml = sheet1.GetSaveXml("CPS_CNI_0009GS.do", param);
					
					if(sXml) {
						var errMsg = ComGetEtcData(sXml, "errMsg");
						
			   			if(errMsg == "Y" ) {
							ComShowCodeMessage("CNI00020" , "Survey Data");
							return;
						}else{
							ComShowCodeMessage("CNI00008");
							sheet1.LoadSaveXml(sXml);
							doActionIBSheet(SEARCHLIST01, "MULTI");
						}
					}
			    }
			}
	} 
}
 
 /**
 * 금액, 통화, 날짜, 환율이 하나라도 입력시 다른 세개의 필드도 모두 입력되었는지 체크
 */
function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2, row) {
		var loclAmt = cniParseFloat2(objLoclAmt);
	 	var xchRt = cniParseFloat2(objXchRt);
		var currCd = objCurrCd.trim();
		var inputDt = objInputDt.trim();
		
		if (loclAmt == 0 && ComIsNull(currCd) && ComIsNull(inputDt) && xchRt == 0) {
			return true;
		} else if (loclAmt != 0 && !ComIsNull(currCd) && !ComIsNull(inputDt) && xchRt != 0) {
			return true;
		} else {
    	
	    	if (loclAmt == 0) {
			    	ComShowCodeMessage("CNI09028" , msg1);
			    	sheet1.SelectCell(row,"inv_amt",true);
					return false;
		    } 
	    	if (ComIsNull(currCd)) {
			    	ComShowCodeMessage("CNI09028" , "Currency");
			    	sheet1.SelectCell(row,"locl_curr_cd",true);
					return false;
		    } 
	    	if (ComIsNull(inputDt)) {
			    	ComShowCodeMessage("CNI09028" , msg2);
			    	sheet1.SelectCell(row,"inv_dt",true);
					return false;
		    } 
	    	if (xchRt == 0) {
			    	ComShowCodeMessage("CNI09028" , "R.O.E");
			    	sheet1.SelectCell(row,"inv_xch_rt",true);
					return false;
	    	} 
		
		}
		return true;
} 

    /**
     * 화면 폼입력값에 대한 유효성검증 프로세스 처리
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    		 
    	}
        with(sheetObj){

			 //AMT, Currency, ROE , Inv DT 모두 입력하거나 모두 빈값이도록 체크.
			 for(var r = 1; r <= sheetObj.RowCount ; r++){
				 if (!chkAmount(sheetObj.CellValue(r,"inv_amt"), sheetObj.CellValue(r,"locl_curr_cd"), sheetObj.CellValue(r,"inv_dt"), sheetObj.CellValue(r,"inv_xch_rt"), "Invoiced Amount", "Inv Date", r)) return;
			 }
        }

        return true;
    }

