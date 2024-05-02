/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0009.js
*@FileTitle  : Handling Costs
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/16
=========================================================*/
/**
 * [CPS_CNI_0009] Handling Costs
 * @extends
 * @class Handling Costs 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
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
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// html form
var frm=null;
var frm2=null;
// grid combo
var comboText="";
var comboCode="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
	frm2=document.form2;//멀티콤보용
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
	//initSheet 보다 먼저해준다.
	initComboBox();
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	//초기값세팅
	ComSetFocus(frm.cgo_clm_no);
    //registering initial event 
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
* registering initial event 
*/
function initControl() {
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//   axon_event.addListenerForm('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   axon_event.addListenerFormat('beforeactivate', 'obj_activate',    frm);
   axon_event.addListenerForm('keyup', 'obj_keyup',frm);
}
 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {
 	var sXml2=frm2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
 	setMultiComboBox(arrXml[0] ); //30
 	
 	var dataCount=ComGetTotalRows(arrXml[1]);
	if (dataCount > 0) {
		var list=SheetXml2ListMap(arrXml[1]);	
	 	var listVO=list[0];
	 	clmAreaCd=listVO["clm_area_cd"];
	 	ComSetObjValue(frm.clm_area_cd,clmAreaCd );
	} else {
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
}
function setMultiComboBox(pXML) {
	var vArrayListData=""; 
	var vListData="";
	var vArrayListData=SheetXml2ListMap(pXML);
	for ( var idx=0; idx < vArrayListData.length; idx++) {
	    if (vArrayListData[idx] != undefined) {
	    	vListData=vArrayListData[idx];
			comboText += vListData["name"] + "|" ;
			comboCode += vListData["code"] + "|" ;
	    }
	}
	comboText=comboText.substring(0, comboText.length -1);
	comboCode=comboCode.substring(0, comboCode.length -1);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {
	        var HeadTitle1="|SEQ|Type|Payee|ClmPtyNo|Description|Invoice No.|Inv. Date|Invoiced Amount|Currency|R.O.E|USD Amount|Payment Due Date|AP Date|Remark|CGO_CLM_NO|INV_RGST_NO|CGO_CLM_PAY_NO|VNDR_SEQ";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	               {Type:"Seq",       Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Combo",     Hidden:0, Width:140,  Align:"Center",  ColMerge:1,   SaveName:"clm_cost_tp_cd",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Popup",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:"clm_pty_no",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:"cost_desc",        KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"inv_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Float",     Hidden:0,  Width:130,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",          KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"locl_curr_cd",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	               {Type:"PopupEdit", Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:"inv_xch_rt",       KeyField:1,   CalcLogic:"",   Format:"",       PointCount:5,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"inv_usd_amt",      KeyField:1,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Date",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"pay_dt",           KeyField:1,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ap_pay_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Popup",     Hidden:0, Width:180,  Align:"Left",    ColMerge:1,   SaveName:"inv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	               {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"inv_rgst_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	               {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cgo_clm_pay_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	   {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",   	    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
	        
            InitColumns(cols);
	        SetSheetHeight(342);
	        SetEditable(1);

	        SetImageList(0,"img/btns_search.gif");
	        SetImageList(1,"img/btns_note.gif");
	        SetColProperty(0 ,"locl_curr_cd" , {AcceptKeys:"E" , InputCaseSensitive:1});
	        SetColProperty(0 ,"clm_cost_tp_cd", {ComboText:comboText, ComboCode:comboCode} );
	        SetColProperty(0 ,"inv_no" , {AcceptKeys:"E|N|[_-,]", InputCaseSensitive:1});


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
		var sVal=getArgValue(obj);
		if(sVal == "") return "";//값이 없을때 .00000으로 세팅되는것 방지.
		switch(sFormat)
		{
			case "#,###" :
					return ComAddComma(sVal);
			case "#,###.0" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".0";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
					if      (p.length == 1) return p[0]+".00";
					else if (p.length == 2) return p[0]+"."+p[1];
					else return "";
			case "#,###.00000" :
					p=sVal.split(".");
					p[0]=ComAddComma(p[0]);
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
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn2_Row_Add":
				var row=sheet1.DataInsert(-1);
			    sheet1.SelectCell(row,"clm_cost_tp_cd",true);
				sheet1.SetCellValue(row , "cgo_clm_no",frm.cgo_clm_no_old.value,0);
				sheet1.SetTotalRows(row);
				break;
			case "btn2_Row_Delete":
				SheetRowDelete(sheet1,sheet1.GetSelectRow());
				break; 
			case "btn2_Row_Copy":
				var row=sheet1.DataCopy();
	    		sheet1.SetRowStatus(row,"I");
	    		//CNI_CGO_CLM_PAY 에서 가져오는 항목들은 Copy 되지 않도록 함
	    		sheet1.SetCellValue(row , "inv_rgst_no","",0);
	    		sheet1.SetCellValue(row , "ap_pay_dt","",0);
				break;
			case "btn2_Down_Excel":
				if(sheet1.RowCount() < 1){//no data
        			ComShowCodeMessage("COM132501");
        		}else{
        			sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(				sheet1), SheetDesign:1,Merge:1 });
        		}
				break; 
			case "btn2_Load_Excel":
				if(ComIsNull(frm.cgo_clm_no_old.value)){
					ComShowCodeMessage("CNI00009", "Claim No.");
					ComSetFocus(frm.cgo_clm_no);
					return;
				}
 				sheet1.LoadExcel();
				//cgo_clm_no 세팅
				for(var row=0; row <= sheet1.LastRow(); row++){
					if(sheet1.GetRowStatus(row) == "I"){
						  sheet1.SetCellValue(row , "cgo_clm_no",frm.cgo_clm_no_old.value,0);;
					  }
				}
				break;
			case "btn1_close":
				ComClosePopup(); 
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
					resetHiddenField(frm);
					frm.cgo_clm_no.value="";
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
 * HTML Control KeyPress event
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
		case "cgo_clm_no":  
			ComKeyOnlyAlphabet('uppernum');
			break;
	}
}
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
	if((event.keyCode >= 37)&&(event.keyCode <= 40)) return; 	 
    switch (ComGetEvent("name")) {    
		case "cgo_clm_no":
			if (!ComIsNull(frm.cgo_clm_no.value) && event.keyCode == 13) {
				//sheet1.RemoveAll();//append mode이므로 remove 해야함.
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}
/**
 * HTML Control KeyUp event
 */
function obj_keyup() {
	if((ComGetEvent("keycode") >= 37)&&(ComGetEvent("keycode") <= 40)) return; 
    switch (ComGetEvent("name")) {    
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
	var frm=document.form;
	switch (ComGetEvent("name")) {
	default:
		ComChkObjValid(ComGetEvent());
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
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	} else {
		for(var i=1; i<=sheet.RowCount(); i++) {
			if( sheet.GetCellValue(i, "inv_no") != "" || sheet.GetCellValue(i, "inv_no").length > 0 ) {
				sheet.SetCellEditable(i, "clm_cost_tp_cd",0);
			}
		}
	}
	//sheet.SetSumText(0, "TOTAL");
 }
function sheet1_OnPopupClick(sheet, row, col) {
    if (sheet.ColSaveName(col) == "inv_rmk") {
		ComShowMemoPad(sheet);
	}
	if (sheet.ColSaveName(col) == "locl_curr_cd") {
		//공통팝업 Currency 호출
		var display="1,0,1,1,1";
		ComOpenPopup("COM_ENS_N13.do?curr_cd=&cnt_cd=&curr_desc=", 700, 450, "setCurrency", display);
	}
	if (sheet.ColSaveName(col) == "inv_xch_rt") {
		if (sheet.GetCellValue(row , "inv_dt") == "" ) {
			//msgs["CNI00009"] = "Please input {?msg1}";
			ComShowCodeMessage("CNI00009" , "Inv Date");
			sheet.SelectCell(row,"inv_dt");
			return;
		}
		//공통팝업 ROE 호출
		var yrMon=sheet.GetCellValue(row , "inv_dt");
		var loclCurrCd=sheet.GetCellValue(row , "locl_curr_cd");
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
		sheet1.SetCellValue(sheet1.GetSelectRow(), "clm_pty_no",partyVo.clm_pty_no);
		sheet1.SetCellValue(sheet1.GetSelectRow(), "clm_pty_abbr_nm",partyVo.clm_pty_abbr_nm);
		sheet1.SetCellValue(sheet1.GetSelectRow(), "vndr_seq",partyVo.vndr_seq);
}
/**
 * ROE 팝업에서 호출하는 함수
 */
 function setCurrencyROE(xchRtVo) {
	sheet1.SetCellValue(sheet1.GetSelectRow(), "locl_curr_cd",xchRtVo.curr_cd);
	sheet1.SetCellValue(sheet1.GetSelectRow(), "inv_xch_rt",xchRtVo.usd_locl_xch_rt);
	
 }
 
function setFeeUsdAmt(popRt) { 
	var amt=cniParseFloat2(sheet1.GetCellValue(sheet1.GetSelectRow(), "inv_amt"));
	var rt=cniParseFloat2(sheet1.GetCellValue(sheet1.GetSelectRow(), "inv_xch_rt"));
	var locl_curr_cd=sheet1.GetCellValue(sheet1.GetSelectRow(), "locl_curr_cd");
	
	var tmpUsdAmt="";
	if(rt != 0 && amt != 0  && locl_curr_cd != "" ){
		//locl_amt / xch_rt
		tmpUsdAmt=roundPrecision(amt/rt,2);
		sheet1.SetCellValue(sheet1.GetSelectRow(), "inv_usd_amt",tmpUsdAmt);
	}else{
		sheet1.SetCellValue(sheet1.GetSelectRow(), "inv_usd_amt","");
	}
}
 
function setCurrency(rowArray) { 
	sheet1.SetCellValue(sheet1.GetSelectRow(), "locl_curr_cd",rowArray[0][2]);
	setFeeUsdAmt("");
}
 
function sheet1_OnChange(sheetObj,Row, Col, Value) {
	with(sheetObj) {
		var colname=ColSaveName(Col);
		//Currency 직접입력시 USD 일경우 ROE 1.00000를 자동 입력.
		if (colname == "locl_curr_cd"){
			if(Value == "USD"){
				sheetObj.SetCellValue(Row, "inv_xch_rt","1.00000" ,0);
			}
			setFeeUsdAmt("");
		}
		 // ROE 입력후 usd_amt 설정
		 // usd_amt 항목에 계산값 Setup = ( inv_amt / R.O.E ), 소수점 세자리에서 반올림
		else if (colname == "inv_amt" || colname == "locl_curr_cd" || colname == "inv_xch_rt"){
			setFeeUsdAmt("");
		}
		 //Settlement Type 선택시 체크사항 
		else if (colname == "clm_cost_tp_cd"){
			 // Settlement Type 인 경우  INT_AMT , INV_NO 는 값  세팅. 수정은 가능.
			 if(sheetObj.GetCellValue(Row,"clm_cost_tp_cd") == "TS" || sheetObj.GetCellValue(Row,"clm_cost_tp_cd") == "TP" || sheetObj.GetCellValue(Row,"clm_cost_tp_cd") == "TC"){
				sheetObj.SetCellValue(Row, "inv_no",frm.clm_stl_auth_no.value,0);
				sheetObj.SetCellValue(Row, "inv_amt",frm.cgo_clm_stl_locl_amt.value,0);
	 			sheetObj.SetSumText(Row,"inv_no","");//합계행에 Onchange Event 가 발생하는 것을 방지.
			}
		}
		else if(colname == "inv_no") {	 
			
			if((sheetObj.GetCellValue(Row,"clm_pty_abbr_nm") == "" || sheetObj.GetCellValue(Row,"clm_pty_abbr_nm") == null)  &&
			(sheetObj.GetCellValue(Row,"vndr_seq") == "" || sheetObj.GetCellValue(Row,"vndr_seq") == null)	){
				ComShowCodeMessage("CNI09068");
				sheetObj.SetCellValue(Row,Col,"",0);
				sheetObj.SelectCell(Row, "clm_pty_abbr_nm");
	
			}
			else if(sheetObj.GetCellValue(Row,"vndr_seq") == "" || sheetObj.GetCellValue(Row,"vndr_seq") == null){
				
				if(sheetObj.GetCellValue(Row,"inv_no") != "" && sheetObj.GetCellValue(Row,"inv_no") != null){
					
					ComShowCodeMessage("CNI09070");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row,"inv_no");
					
				}
				
			}else{
				var checkInvNo =  CNIcheckInvoiceNo(sheetObj,sheetObj.GetCellValue(Row,"inv_no"),sheetObj.GetCellValue(Row,"vndr_seq"),sheetObj.GetCellValue(Row,"cgo_clm_pay_no"));
				if(checkInvNo != null && checkInvNo != ""){
//					ComShowCodeMessage("CNI09069");
					sheetObj.SetCellValue(Row,Col,"",0);
					sheetObj.SelectCell(Row, "inv_no");
				}
			}
			
		}
	}
}
function sheet1_OnClick(sheetObj, row, col, value) {
	if (sheetObj.ColSaveName(col) == "inv_rmk") {
		ComShowMemoPad(sheetObj, null, null, null, null, null, 1300);
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction, flag) {
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;	
		if(flag == "MULTI"){//저장후 재조회시 이미지 안보이게함.
			sheet1.SetWaitImageVisible(0);
		}
		
		//sheet1.ShowSubSum([{StdCol:0, SumCols:"11", Sort:0, ShowCumulate:false, CaptionText:"TOTAL"}]);
		
 		var sXml=sheet1.GetSearchData("CPS_CNI_0009GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[1],{Sync:1} );
			var list=SheetXml2ListMap(arrXml[0]);	//Main 데이타
			if (list.length > 0) {//Main 데이타가 있는 경우 ADD, DELETE, SAVE 가능
				for(var j=0;j<list.length;j++)
				{
					if(list[j] != undefined){
						var VO=list[j];
						break;
					}
				}
				frm.cgo_clm_no.value=VO["cgo_clm_no"];
				frm.cgo_clm_no_old.value=VO["cgo_clm_no"];
				frm.clm_area_cd.value=VO["clm_area_cd"];
				frm.clm_misc_nm.value=VO["clm_misc_nm"];
				frm.cgo_clm_sts_cd.value=VO["cgo_clm_sts_cd"];
				frm.cs_clz_dt.value=VO["cs_clz_dt"];
				frm.cgo_clm_stl_tp_cd.value=VO["cgo_clm_stl_tp_cd"];
				frm.pty_nm.value=VO["pty_nm"];
				frm.prlm_clm_ntc_dt.value=VO["prlm_clm_ntc_dt"];
				frm.fmal_clm_rcv_dt.value=VO["fmal_clm_rcv_dt"];//DOF
				frm.smns_sve_dt.value=VO["smns_sve_dt"];	
				frm.clmt_locl_amt.value=addComma2(VO["clmt_locl_amt"],"#,###.00");
				frm.clmt_locl_curr_cd.value=VO["clmt_locl_curr_cd"];
				frm.clmt_locl_xch_rt.value=addComma2(VO["clmt_locl_xch_rt"],"#,###.00000");
				frm.clmt_usd_amt.value=addComma2(VO["clmt_usd_amt"],"#,###.00");
				frm.cgo_clm_stl_locl_amt.value=addComma2(VO["cgo_clm_stl_locl_amt"],"#,###.00");
				frm.cgo_clm_stl_locl_curr_cd.value=VO["cgo_clm_stl_locl_curr_cd"];
				frm.cgo_clm_stl_xch_rt.value=addComma2(VO["cgo_clm_stl_xch_rt"],"#,###.00000");
				frm.cgo_clm_stl_usd_amt.value=addComma2(VO["cgo_clm_stl_usd_amt"],"#,###.00");//Settlement Type 선택시 INV_USD_AMT
				frm.cgo_clm_stl_dt.value=VO["cgo_clm_stl_dt"];//DOS
				frm.clm_stl_auth_no.value=VO["clm_stl_auth_no"];//Settlement Type 선택시 INV_NO
				frm.hdlr_usr_id.value=VO["hdlr_usr_id"];
				frm.hdlr_ofc_cd.value=VO["hdlr_ofc_cd"];
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
				var tepCgoClmNo=frm.cgo_clm_no.value;
				for(var i=0; i<document.forms.length; i++){
					document.forms[i].reset();
				}
				frm.cgo_clm_no.value=tepCgoClmNo;
				ComBtnDisable("btn2_Row_Add");
				ComBtnDisable("btn2_Row_Delete");
				ComBtnDisable("btn2_Row_Copy");
				ComBtnDisable("btn2_Down_Excel");
				ComBtnDisable("btn2_Load_Excel");
				ComBtnDisable("btn1_Save");
			}
		}
		sheet1.SetSumText(1, "TOTAL");
	} 
	else if (sAction == MULTI) {
			frm.f_cmd.value=MULTI;
			var param=FormQueryString(frm);
			var saveString=sheet1.GetSaveString();
			if (sheet1.IsDataModified()&& ComIsNull(saveString) )  {//row추가하고 필수입력사항 입력안한경우
				return;
			}
			if (!sheet1.IsDataModified()&& ComIsNull(saveString) )  {//변경없이 save 버튼 누를 경우
				ComShowMessage("There is no contents to save");
				return;
			}
			else{
				if (ComShowCodeConfirm("CNI00012")) {//CNI00012(Do you want to save changes?)
					param += "&" + saveString;
 					var sXml=sheet1.GetSaveData("CPS_CNI_0009GS.do", param);
					if(sXml) {
						var errMsg=ComGetEtcData(sXml, "errMsg");
			   			if(errMsg == "Y" ) {
							ComShowCodeMessage("CNI00020" , "Survey Data");
							return;
						}else{
							ComShowCodeMessage("CNI00008");
 							sheet1.LoadSaveData(sXml);
							doActionIBSheet(SEARCHLIST01, "MULTI");
						}
					}
			    }
			}
	} 
}
 /**
 * Amount, currency, date, and the exchange rate at the input of the other three input fields, checking whether all
 */
function chkAmount(objLoclAmt, objCurrCd, objInputDt, objXchRt, msg1, msg2, row) {
		var loclAmt=(objLoclAmt);
	 	var xchRt=cniParseFloat2(objXchRt);
		var currCd=objCurrCd.trim();
		var inputDt=objInputDt.trim();
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
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
    	with(formObj){
    	}
        with(sheetObj){
			 //AMT, Currency, ROE , Inv DT 모두 입력하거나 모두 빈값이도록 체크.
			 for(var r=1; r <= sheetObj.RowCount(); r++){
				 if (!chkAmount(sheetObj.GetCellValue(r,"inv_amt"), sheetObj.GetCellValue(r,"locl_curr_cd"), sheetObj.GetCellValue(r,"inv_dt"), sheetObj.GetCellValue(r,"inv_xch_rt"), "Invoiced Amount", "Inv Date", r)) return;
			 }
        }
        return true;
    }
    
    function sheet1_OnLoadExcel(sheetObj, code, msg){
        if(isExceedMaxRow(msg))return;
    }

