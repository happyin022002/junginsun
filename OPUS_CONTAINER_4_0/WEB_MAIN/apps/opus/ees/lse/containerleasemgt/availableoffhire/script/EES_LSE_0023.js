/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0023.js
*@FileTitle  : Target Off-Hire Location Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2016/05/11
=========================================================*/
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var tcnt=0;
var comboCnt=0 ;
var blurflg=false;
var nowLoad=0;
var EXCEL_LOAD_FLG=false;	//check excell loading
var iPageNo = 1;
var appendPageNo = 1;
var appendCondParam = "";
var rtv_total = 0;
var saveType = 0;
var seqValue = 0;
var sTgtLocCdNm = "";

document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick() {
	 /***** Adding additional sheet variables to use more than one sheet per a tab *****/
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcObj=ComGetEvent();
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				sheetObject.RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_new":
				sheetObject.RemoveAll();
				form.reset();
				formObject.agmt_cty_cd.value="HHO";
				
				comboObjects[0].RemoveAll();
				comboObjects[0].InsertItem('ALL','ALL');
				comboObjects[0].InsertItem('LP', 'LP');
				comboObjects[0].InsertItem('LT', 'LT');
				comboObjects[0].InsertItem('ST', 'ST');
				comboObjects[0].InsertItem('OF', 'OF');
				comboObjects[0].InsertItem('SI', 'SI');
				comboObjects[0].InsertItem('MI', 'MI');
				for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
					comboObjects[0].SetItemCheck(i,0);
				}
				
				for(var i=1 ; i < comboObjects[1].GetItemCount(); i++ ){
					comboObjects[1].SetItemCheck(i,0);
				}					
				
				for(var i=1 ; i < comboObjects[2].GetItemCount(); i++ ){
					comboObjects[2].SetItemCheck(i,0);
				}
				comboObjects[2].SetItemCheck(0,1);
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject, formObject, IBSAVE);
				break;
				
			case "btn_rowadd":
				doActionIBSheet(sheetObject, formObject, IBINSERT);
				break;
				
			case 'btn_rowdelete':
				ComRowHideDelete(sheetObject,"ibcheck");
				break;
				
			case "btn_downexcel" :
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}
				break;

			case "btns_search1": //agmt no
				openPopupPage("1");
			break;
			
			case "btn_tgtarea" : // Target Location
				// 선택한 Code값을 가져와서 인자로 전달
               	rep_Multiful_inquiry("loc_cd"); 
			break;
			case "btns_search": 	// Form Lessor Search
				openPopupPage("2");
				break;
			} 
		}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		}else {
			ComShowMessage(e.message);
		}
	}	
}


/**
 * Pop-up Open <br>
 * @param type 1:Agreement(include Ver.) for FORM, 2:Target Location Form
 * @param object Object
 * @param Row Row index
 */
function openPopupPage(type, Row, Col, SheetIdx) {
	var formObj=document.form;
	if ( type == "1" ) {
		if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
			ComOpenPopup('/opuscntr/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 800, 470, 'setPopData_AgreementVer', '1,0', true);
		} else {
			ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 470, 'setPopData_Agreement', '1,0', true);
		}
	} else if ( type == "2" ) {
		ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Lessor', '1,0,1,1,1,1,1,1', true);
	} 
}


/**
* handling process for Currency Pop-up Return Value<br>
* @param Return value array
* @param Row index
* @param Col index
* @param Sheet Array index
*/
function setPopData_Agreement(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( aryPopupData.length > 0 ) {
    	formObj.agmt_seq.value = aryPopupData[0][5]; 
    	formObj.ref_no.value = aryPopupData[0][6];
	}
}


/**
 * Agreement Pop-up Return Value handling<br>
 * @param {arry} returnedValues Pop-up page Return value array
 * @param Row Row index
 * @param Col Col index
 * @param IBSheet Sheet Array index
 */
function setPopData_AgreementVer(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( aryPopupData.length > 0 ) {
		if ( !OfficeCodeMgr.checkContainOfficeCode("000001", "LSE", ComGetObjValue(formObj.usr_ofc_cd))  ) {
			if ( aryPopupData[0][5] == "OW" || aryPopupData[0][5] == "LP" || aryPopupData[0][5] == "OL"
			  || aryPopupData[0][5] == "LT" || aryPopupData[0][5] == "ST" || aryPopupData[0][5] == "OF" ) {
				ComShowCodeMessage("LSE01040");
				ComSetFocus(formObj.agmt_seq);
				return;
			}
		}
		ComSetObjValue(formObj.agmt_seq,     aryPopupData[0][4]);
		ComSetObjValue(formObj.agmt_ver_seq, aryPopupData[0][8]);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
  	}
}


/**
 * Calling rep_commodity pop-up
 * 자식페이지(EES_LSE_0023_POP)에서 넘어온 값을 화면에 뿌려주는 함수
 */
function rep_Multiful_inquiry(input_obj) {
	var formObj=document.form;
   	var xx1=input_obj;
//   	var xx2="";
   	var eq_loc_tp_cd = formObj.eq_loc_tp_cd.value;
   	var param = "?returnval=" + xx1 + "&eq_loc_tp_cd="+eq_loc_tp_cd;
	ComOpenPopup('/opuscntr/EES_LSE_0023_01_POP.do' + param, 700, 500, 'getLse_Multi', '1,0');
}


/**
 * Calling rep_commodity pop-up
 * 자식페이지(EES_LSE_0023_POP)에서 넘어온 값을 화면에 뿌려주는 함수
 */
function rep_Multiful_inquiry01(sheetObj,Row,input_obj) {
	var formObj      = document.form;
   	var xx1          = input_obj; // full_loc_tp_cd
   	var Cnt          = sheetObj.RowCount();
   	var eq_loc_tp_cd = sheetObj.GetCellValue(Row,"eq_loc_tp_cd");
   	var loc_cd       = sheetObj.GetCellValue(Row,"loc_cd");
   	var eq_loc_tp_nm = sheetObj.GetCellValue(Row,"eq_loc_tp_nm");
   	
   	var param = "?returnval=" + xx1 + "&eq_loc_tp_cd="+eq_loc_tp_cd+ "&loc_cd="+loc_cd +"&returnrow="+Row+"&eq_loc_tp_nm="+eq_loc_tp_nm;
	ComOpenPopup('/opuscntr/EES_LSE_0023_POP.do' + param, 700, 500, 'getLse_Multi01', '1,0');
}

function getLse_Multi(rowArray,ret_val) {
	var formObj=document.form;
	var tempText="";
	//initializing
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		tempText +=  rowArray[i] + ',';
	}
	//clearing comma(,)
	tempText=LseDelLastDelim(tempText);
	tempText=tempText.toUpperCase();
	eval("document.form.loc_cd.value='" + tempText + "';");
}


function eq_loc_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	with(comboObj) {
		if(newIndex == 1) {
		   	formObj.loc_cd.value = "ALL";
		}else{
			formObj.loc_cd.value = "";
		}
	}
}


function getLse_Multi01(rowArray01,rowArray, rowArray02, ret_row) {
	var formObj=document.form;
	//initializing
	rowArray01 = rowArray01.substr(1, rowArray01.length );
	rowArray = rowArray.substr(1, rowArray.length );
	rowArray02 = rowArray02.substr(1, rowArray02.length );
	
	sheetObjects[0].SetCellValue(ret_row,"eq_loc_tp_cd",rowArray01,0);
	sheetObjects[0].SetCellValue(ret_row,"loc_cd",rowArray,0);
	sheetObjects[0].SetCellValue(ret_row,"eq_loc_tp_nm",rowArray02,0);
	
	var strLocLevel = sheetObjects[0].GetCellValue(ret_row,"eq_loc_tp_cd");
	var strLocCd = sheetObjects[0].GetCellValue(ret_row,"loc_cd");
	
	var arrLocLevel = "";
	var arrLocCd = "";
	var fullLocCd = "";
	if(strLocLevel != "") {
		arrLocLevel = strLocLevel.split(",");
		arrLocCd = strLocCd.split(",");
		for(var k=0; k<arrLocLevel.length; k++) {
			if(arrLocLevel[k] !=  arrLocLevel[k-1]) {
				fullLocCd = fullLocCd+"),"+arrLocLevel[k] +"("+ arrLocCd[k];
			}else{
				fullLocCd = fullLocCd +"," + arrLocCd[k];
			}
			if(arrLocLevel[k+1] == undefined) {
				fullLocCd = fullLocCd +")";
			}
		}
		sheetObjects[0].SetCellValue(ret_row,"full_loc_tp_cd",fullLocCd.substr(2,fullLocCd.length),0 );
	}
	
}

/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}


function sheet1_OnLoadFinish(sheetObj) {
 	/* IBMulti Combo Item Setting */
	doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
}      


/**
* Setting sheets and initialization
* Implementing the onLoad event handler of body tag
* Adding the preceding function after loading page
 */
function loadPage() {
	nowLoad=1;
	for(i=0;i<sheetObjects.length;i++){	
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	
	var formObj=document.form;    
	comboObjects[0].SetEnable(1);
	comboObjects[1].SetEnable(1);
	comboObjects[2].SetEnable(1);
	initControl();	
	nowLoad=0;
	/* IBMultiCombo initailizing */
 	for ( var k=0 ; k < comboObjects.length ; k++ ) {
 		initCombo(comboObjects[k], k+1);
 	}
 	sheet1_OnLoadFinish(sheetObjects[0]);
}



/**
 * MultiCombo object initial property 
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo (comboObj, comboNo) {
	 switch(comboObj.options.id) {
	// Combo for retrieving Lease Term
	 case "lstm_cd":
     	with(comboObj) {
         	SetDropHeight(200);
         	SetMultiSelect(1);
         	SetMultiSeparator(",");
         	Style=0;
      		SetUseAutoComplete(1);
         }
     	break;
	 // Combo for retrieving Container TP/SZ
	 case "cntr_tpsz_cd":
     	with(comboObj) {
         	SetDropHeight(200);
         	SetMultiSelect(1);
         	SetMultiSeparator(",");
         	Style=0;
      		SetUseAutoComplete(1);
         }
     	break;	
	 case "eq_loc_tp_cd":
	     	with(comboObj) {
	         	SetDropHeight(200);
	         	SetMultiSelect(0);
	         	SetMultiSeparator(",");
	         	Style=0;
	      		SetUseAutoComplete(1);
	         }
	     break;	
	}      	
}


/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
	axon_event.addListenerFormat('change','obj_change',formObj);       
	axon_event.addListenerFormat('blur','obj_blur',formObj);  
}


/**
* handling event in case of Change
*/
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	switch(obj.name) {
	case "agmt_seq":
		if ( formObj.agmt_seq.value != null && formObj.agmt_seq.value != "" ) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
		} else {
			formObj.ref_no.value="";
		}
		break;
		
	case "vndr_seq":	//Lessor Code
		if ( ComTrim(formObj.vndr_seq.value) != "" ) {
			doActionIBSheet(sheetObjects[0], formObj , IBSEARCH_ASYNC05);
		}
		break;
	}	
}


/**
* handling Location blur event
*/
function obj_blur(){
	var obj = event.srcElement;
	switch(obj.name){	
		case "agmt_seq":
		if ( document.form.agmt_seq.value == null || document.form.agmt_seq.value == "" ) {
			document.form.ref_no.value = "";
		}
		break;
	default:
		//checking Validation
	break;
	}
}


/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
   ComKeyOnlyAlphabet('uppernum');
}


/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(ComGetEvent());
}
/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
   ComKeyOnlyNumber(ComGetEvent());
}
/**
 * Define the initial values and headers of sheets
 * 
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
		    with(sheetObj){
				var HeadTitle="Sel||Lease Term|Contract No.|AGMT No.|Old AGMT No.|Lessor|TP/SZ|Remain QTY|Off hire Flag|Place|From Date|To Date|Remark|Update By|Update Date|||" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				             {Type:"DummyCheck",Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
				             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"lstm_cd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"PopupEdit", Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_no",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"old_agmt_no",    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:0,   SaveName:"lessor_cd",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"rem_qty",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"CheckBox",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"use_flg",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, TrueValue:"Y", FalseValue:"N" },
				             {Type:"Popup",     Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"full_loc_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"offh_to_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    ColMerge:0,   SaveName:"gen_rmk",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",         KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"eq_loc_tp_nm",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
				             {Type:"Text",      Hidden:1,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"loc_cd",         KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1 }];
	       
				InitColumns(cols);
				resizeSheet();
				SetEditable(1);	      
	            InitComboNoMatchText(1,"",1);
	      	}
			break; 
	}
}

function doActionIBSheet(sheetObj, formObj, sAction, Row) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCREATE:
			// Lease Term Combo Item Setting Start
			comboObjects[0].InsertItem('ALL','ALL');
			comboObjects[0].InsertItem('LP', 'LP');
			comboObjects[0].InsertItem('LT', 'LT');
			comboObjects[0].InsertItem('ST', 'ST');
			comboObjects[0].InsertItem('OF', 'OF');
			comboObjects[0].InsertItem('SI', 'SI');
			comboObjects[0].InsertItem('MI', 'MI');
			
			//Container Type/Size Combo Item Setting Start
			formObj.f_cmd.value = SEARCH02;
			var sXml = sheetObj.GetSearchData("EES_LSE_COMGS.do", FormQueryString(formObj));
	        
            if ( sXml != "" ) {            	
            	comboObjects[1].InsertItem(0, 'ALL',''); 
            	LseComXml2ComboItem(sXml, comboObjects[1], "cntr_tpsz_nm", "cntr_tpsz_cd", "|");
            	vOrcCntrTpszCd = ComGetEtcData(sXml, "cntr_tpsz_cd");
            }
            //Target Location Combo Item Setting Start
            formObj.f_cmd.value=SEARCH01;
			var intgCdId='CD30026';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				sTgtLocCdNm=ComGetEtcData(xml, "code_nm");
				var arrStr=sTgtLocCdNm.split("@");
				comboObjects[2].RemoveAll();
				comboObjects[2].InsertItem(0, "" , "");
				for (var i=0; i<arrStr.length; i++) {
					var arrCode=arrStr[i].split("|");
					comboObjects[2].InsertItem(i+1, arrCode[1] , arrCode[0]);
				}
				comboObjects[2].SetSelectIndex("0" ,false);
			}
        break;	        
			
		case IBSEARCH:      //Retrieve
				formObj.f_cmd.value=SEARCH;
				rowTotal = 0;
				rtv_total=rowTotal;	
				formObj.pagerows.value = 30000;
				appendPageNo=1;
				sheetObj.SetWaitImageVisible(1);
				appendCondParam = FormQueryString(formObj);
				sheetObj.DoSearch("EES_LSE_0023GS.do",FormQueryString(formObj));
				
			break;
			
		case IBSEARCH_ASYNC04:   // Retrieve for contract no. in agreement
			if(validateForm(sheetObj,formObj,sAction)) {
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value=SEARCH03;
					var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do",FormQueryString(formObj));
					if ( ComGetEtcData(sXml, "ref_no") != undefined ) {
						formObj.ref_no.value=ComGetEtcData(sXml, "ref_no");
					} else {
						ComShowCodeMessage("LSE01007");
						formObj.agmt_seq.value="";
						formObj.ref_no.value="";
						ComSetFocus(formObj.agmt_seq);
					}
				}
			}
		break;
		
		case IBSEARCH_ASYNC05:	//retrieving when input Form Lessor No.
			if ( validateForm(sheetObj, formObj, sAction) ) {
				var param="f_cmd="+SEARCH06+"&vndr_seq="+ComGetObjValue(formObj.vndr_seq);
				var sXml=sheetObj.GetSearchData("EES_LSE_COMGS.do", param);
				if ( sXml != "" ) {
					if ( ComGetEtcData(sXml, "vndr_lgl_eng_nm") != undefined ) {
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
						//ComSetObjValue(formObj.vndr_abbr_nm, ComGetEtcData(sXml, "vndr_abbr_nm"));
						ComSetFocus(formObj.vndr_nm);
						} else {
							ComShowCodeMessage("LSE01019");
							formObj.vndr_seq.value="";
							formObj.vndr_nm.value="";
						}
				} else {
					var errMsg=LseComGetErrMsg(sXml);
					if ( errMsg != "" ) {
						ComShowMessage(errMsg);
					}
					formObj.vndr_seq.value="";
					formObj.vndr_nm.value="";
				}
			}
			break;
		
		case IBSAVE:
			if (validateForm(sheetObj, formObj, sAction)) {
				ComOpenWait(true);
				if(sheetObj.id == "sheet1") {
					formObj.f_cmd.value = MULTI;
					var xml = sheetObj.DoSave("EES_LSE_0023GS.do", FormQueryString(formObj));
				}
				ComOpenWait(false);
			}
			break;
			
		case IBINSERT:      // Row Add
			sheetObjects[0].SetColProperty(0,"agmt_no", {KeyField:1});
			sheetObj.DataInsert(-1);
			var arrStr=sTgtLocCdNm.split("@");
			var arrCode = "";
			var arrName = "";
			var strCode = "";
			var strName = "";
			for (var i=0; i<arrStr.length; i++) {
				arrCode=arrStr[i].split("|");
				arrName=arrStr[i].split("|");
				if(i == 0) {
					strCode = arrCode[0];
					strName = arrCode[1];
				}else{
					strCode = strCode +"|"+arrCode[0];
					strName = strName +"|"+arrCode[1];
				}
			}
			sheetObjects[0].SetColProperty(0, "eq_loc_tp_cd", {ComboText:strName, ComboCode:strCode} );		
		break;
		case IBDOWNEXCEL:        //Excel Download
			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	}
}

function getCurrentTimeToDateFormat() {
/////////////////////////////////////////////////////
// returning current Time that is maked by 'YYYY-MM-DD HH24:MI:SS'format.
	var date  = new Date();
	var year  = date.getFullYear();
	var month = date.getMonth() + 1; // jan=0,dec=11
	var day   = date.getDate();
	var hour  = date.getHours();
	var min   = date.getMinutes();
	var sec   = date.getSeconds();

	if (("" + month).length == 1) { month = "0" + month; }
	if (("" + day).length   == 1) { day   = "0" + day;   }
	if (("" + hour).length  == 1) { hour  = "0" + hour;  }
	if (("" + min).length   == 1) { min   = "0" + min;   }
	if (("" + sec).length   == 1) { sec   = "0" + sec;   }

	return (year + "-" + month + "-" + day + " " + hour + ":" + min + ":" + sec);
}

/**
 * Function to initialize global variable <br>
 * <br><b>Example :</b>
 * <pre>
 * 		initVariable();
 * </pre>
 * @return nothing
 */
function initVariable() {
	EXCEL_LOAD_FLG=false;
}
/**
    * Validating inputted values of form
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSAVE:
			var Cnt = sheetObj.RowCount();
	    	for(var i = 1; i <= Cnt; i++){
				if (sheetObj.GetCellValue(i, "full_loc_tp_cd") != "") {
					if(sheetObj.GetCellValue(i, "use_flg") == 0) {
						ComShowCodeMessage("LSE10030");
						return false;
					}
				}
	    	}
			break;
		}
	return true;
}

/**
 * handling event when changing Sheet.<br>
 * @param sheetObj
 * @param row
 * @param col
 * @param value
 */
function sheet1_OnChange(sheetObj, Row, Col, Value){
	var formObj=document.form;
	with(sheetObj) {
		var sName=ColSaveName(Col);
		var prefix=sheetObj.id +"_";
		switch(sName) {
			case "agmt_no":
				if(GetCellValue(Row,Col) != "") {
					var param = "f_cmd="+ SEARCH02 + "&agmt_seq="+ GetCellValue(Row,Col);
					var CondParam = param;
					var appendPageNo = 1;
					var row1 = sheetObj.GetSelectRow();
					sheetObj.RowDelete(row1); 
					var sXml = sheetObj.DoSearch("EES_LSE_0023GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true});
//					doActionIBSheet(sheetObjects[0], document.form, IBCREATE);
				} else {
					SetCellValue(Row, prefix +"lstm_cd",      "",0);
					SetCellValue(Row, prefix +"ctrt_no",      "",0);
					SetCellValue(Row, prefix +"agmt_no",      "",0);
 					SetCellValue(Row, prefix +"old_agmt_no",  "",0);
 					SetCellValue(Row, prefix +"lessor",       "",0);
 					SetCellValue(Row, prefix +"cntr_tpsz_cd", "",0);
 					SetCellValue(Row, prefix +"eq_loc_tp_cd", "",0);
 					SetCellValue(Row, prefix +"loc_cd",       "",0);
 					SetCellValue(Row, prefix +"offh_fm_dt",   "",0);
 					SetCellValue(Row, prefix +"offh_to_dt",   "",0);
 					SetCellValue(Row, prefix +"gen_rmk",      "",0);
				}
				break;
			
			case "offh_to_dt":
				var fmDt = sheetObj.GetCellValue(Row, "offh_fm_dt");
				var toDt = sheetObj.GetCellValue(Row, "offh_to_dt");
				if (fmDt > toDt) {
					ComShowCodeMessage("LSE01080");
					sheetObj.SetCellValue(Row, Col, "", 0);
					sheetObj.SelectCell(Row, Col);
				}
				
				break;
			default :
			break;
		}
	}
}

/**
 * handling in case of clicking image button on sheet1
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	var formObj = document.form;
	with(sheetObj) {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
		case "agmt_no":
			var strCellType = sheetObj.GetCellValue(Row,"ibflag");
			var strTypeModifyYN = "N";
			strTypeModifyYN = "Y";
			if ( ComGetObjValue(formObj.agmt_ver_seq) != "" ) {
				ComOpenPopup('/opuscntr/EES_LSE_0002.do?agmt_seq='+ComGetObjValue(formObj.agmt_seq), 800, 470, 'setPopupParam', '0,0', true, false, Row, Col, 0);
			} else {
				ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 470, 'setPopupParam', '0,0', true, false, Row, Col, 0);
			}
		break;
		case "full_loc_tp_cd" :
			rep_Multiful_inquiry01(sheetObj,Row,"full_loc_tp_cd"); 
		}
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var totalRow = sheetObj.RowCount();	
	var strLocLevel = "";
	var strLocCd = "";
	
	var arrLocLevel = "";
	var arrLocCd = "";
	
	var fullLocLevel = "";
	var fullLocCd = "";
	for (i = 1; i <= totalRow; i++) {
		if (sheetObj.GetCellValue(i,"use_flg") == "1") {
			sheetObj.SetCellValue(i,"use_flg", "1" ,0);
		} else {
			sheetObj.SetCellValue(i,"use_flg", "0",0);
		}
		
		strLocLevel = sheetObj.GetCellValue(i,"eq_loc_tp_nm");
		strLocCd = sheetObj.GetCellValue(i,"loc_cd");
		
		if(strLocLevel != "") {
			arrLocLevel = strLocLevel.split(",");
			arrLocCd = strLocCd.split(",");
			fullLocCd = "";
			for(var k=0; k<arrLocLevel.length; k++) {
				if(arrLocLevel[k] !=  arrLocLevel[k-1]) {
					fullLocCd = fullLocCd+"),"+arrLocLevel[k] +"("+ arrLocCd[k];
				}else{
					fullLocCd = fullLocCd +"," + arrLocCd[k];
				}
				
				if(arrLocLevel[k+1] == undefined) {
					fullLocCd = fullLocCd +")";
				}
			}
			sheetObj.SetCellValue(i,"full_loc_tp_cd",fullLocCd.substr(2,fullLocCd.length),0 );
		}
		sheetObj.SetCellValue(i,"ibflag","R");
		
	}
	sheetObj.SetWaitImageVisible(0);
}

function sheet1_OnSaveEnd(sheetObj , ErrMsg) { 
	var formObject=document.form; 
	ComShowCodeMessage("COM130102", 'Target Off-hire Location');
	doActionIBSheet(sheetObj,formObject,IBSEARCH);
	ComOpenWait(false);
}

/*
 * Sheet1 OnClick Event
 * Show already saved values when clicking Pop-up screen in Place column.
 */
function sheet1_OnClick(sheetObj, Row, Col, Val) {
	if (sheetObj.ColSaveName(Col) == "eq_loc_tp_cd") {
		
	}
}

/**
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
*/
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}


/**
 * function get parameter from popup
 * @param aryPopupData
 * @param Row
 * @param Col
 * @param SheetIdx
 * @return
 */
function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
	var str = aryPopupData +"";
	var arr = str.split(',');
	var sheetObj =  sheetObjects[SheetIdx];
	if ( aryPopupData.length > 0 ) {
    	sheetObj.SetCellValue(Row, Col,arr[5]);
	}
}


/**
 * handling in case of onChange combo event 
 * @param comboObj
 * @param Index_Code
 * @param Text
 * @return
 */   
function comboOnChange(comboObj,Index_Code, Text){ 	
	var formObj=document.form;
	comboObjects[0].RemoveAll();
	comboObjects[1].RemoveAll();
	comboObjects[2].RemoveAll();
	comboObjects[2].InsertItem(0, 'ALL',''); 
    comboObjects[0].SetItemCheck(0,1);
    comboObjects[1].SetItemCheck(0,1);
    comboObjects[2].SetItemCheck(0,1);
} 


/**
 * TP/SZ  
 */
function cntr_tpsz_cd_OnCheckClick(comboObj, index, code) {
	if(index==0) { 	    	
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
		}
	} else {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			comboObj.SetItemCheck(0,0);
		}
	}
}

/**
 * Term 
 */
function lstm_cd_OnCheckClick(comboObj, index, code) {
	if(index==0) { 	    	
		var bChk=comboObj.GetItemCheck(index);
		if(bChk){
			for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
				comboObj.SetItemCheck(i,0);
			}
		}
	} else {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			comboObj.SetItemCheck(0,0);
		}
	}
}

/**
 * 
 * 
 * @param {String}
 * @return {String} 
 * @author 
 * @version 2009.06.04
 */
function LseDelLastDelim(str) {
	// 
	if (str != "") {
		str=str.substr(0, str.length - 1);
	}
	return str;
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
	}


/**
 * handling process for Lessor(Service Provider) Pop-up Return Value<br>
 * @param Return value array
 * @param Row index
 * @param Col index
 * @param Sheet Array index
 */
function setPopData_Lessor(aryPopupData, Row, Col, SheetIdx) {
	var sheetObj=sheetObjects[SheetIdx];
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		ComSetObjValue(formObj.vndr_seq, ComLtrim(aryPopupData[0][2],"0"));
		//ComSetObjValue(formObj.vndr_abbr_nm,  aryPopupData[0][5]);
		ComSetObjValue(formObj.vndr_nm,  aryPopupData[0][4]);
	}
}
