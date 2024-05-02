/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0046.js
*@FileTitle  : Estimated I/F To ERP(RV)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23
=========================================================*/
/****************************************************************************************
  event classification code : [initializing]INIT=0; [inputting]ADD=1; [retrieving]SEARCH=2; [list retrieving]SEARCHLIST=3;
					[modifying]MODIFY=4; [deleting]REMOVE=5; [list deleting]REMOVELIST=6 [multiple handling]MULTI=7
					etc extra codes  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class esm_fms_0046 : esm_fms_0046 definition of biz script for creation screen
 */
// common global variables 
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var queryStr="";
// Event handler processing by button click event*/
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;             //버튼 상태를 확인을 합니다.
        switch(srcName) {
        	case "btn_retrieve":
             	if (!duration_change()) return;
             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
            break;
			case "btn_new":
				ComResetAll();
				inputReadOnly("New");				
				initMonth("NEW");

				re_divr_cd.SetSelectCode("E");
				acct_cd.SetSelectCode(true);
            break;
			case "btn_excel":
				if(sheetObject.RowCount() < 1){//no data	
					ComShowCodeMessage("COM132501");
				}else{	
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}	
            break;
			case "btn_save":
				if (ComIsBtnEnable("btn_save")) {
					doActionIBSheet(sheetObject,formObject,IBSAVE);
				}	
            break;
			case "btn_del":
				if(checkBoxCheckYn(sheetObject, "del_chk")) { 
					FmsRowHideDelete2(sheetObject, "del_chk");
					ComBtnEnable("btn_save");
				}
            break;
 			case "btn_fr_duration":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.fr_duration, 'yyyy-MM');
				break;					
 			case "btn_to_duration":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.to_duration, 'yyyy-MM');
				break;
        	case "btn_create":
             	if (!duration_change()) return;
             	doActionIBSheet(sheetObject,formObject,IBCREATE);
            break;
 			case "btn_exe_yrmon":
 				var cal=new ComCalendar();
				cal.setDisplayType('month');
				cal.select(form.exe_yrmon, 'yyyy-MM');
				
				break;
      } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Handling by Event <br>
 * @param {String} flag     	Event Separator
 **/
function inputReadOnly(flag) {
	var readOnly=true;
	var cursor="default";
	var img="no_";
	if(flag == "New") {
		readOnly=false;
		cursor="hand";
		img="";
	}
	form.fr_duration.readOnly=readOnly;
	form.to_duration.readOnly=readOnly;
	//form.flet_ctrt_tp_cd.disabled=readOnly;
	form.btn_fr_duration.name=img+"btn_fr_duration";
	form.btn_to_duration.name=img+"btn_to_duration";
	form.btn_fr_duration.style.cursor=cursor;
	form.btn_to_duration.style.cursor=cursor;
	ComBtnEnable("btn_save");
}

/**
* registering IBSheet Object as list 
* adding process for list in case of needing batch processing with other items
* defining list on the top of source
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/** 
 * registering IBCombo Object as list
 * param : combo_obj
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet 
 * implementing onLoad event handler in body tag 
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}
    sheet1_OnLoadFinish(sheet1)
    initControl();
}

/**
 * setting Combo basic info
 * @param comboObj 
 * @param comboIndex Number
 */
function initCombo(comboObj, comboNo) {
	var formObject=document.form
	switch (comboNo) {
		case 1: 
			with (comboObj) { 
				SetMultiSelect(false);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
				SetColAlign(0, "left");
				SetColWidth(0, "120");
				SetDropHeight(160);
				ValidChar(2,1);//only upper case
				//SetMaxLength(7);
			}
			re_divr_cd.InsertItem(-1, "ALL"	, "");	//ALL
			re_divr_cd.InsertItem(-1, "Revenue", "R");	//ALL
			re_divr_cd.InsertItem(-1, "Expense", "E");	//ALL
			
			re_divr_cd.SetSelectCode("E");

		break;
		case 2: 
			with (comboObj) { 
				SetMultiSelect(true);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
 				SetColAlign(0, "left");
				SetColWidth(0, "180");
				SetDropHeight(160);
 				ValidChar(2,1);//only upper case
 				//SetMaxLength(7);
			}
			acct_cd.InsertItem(-1, "ALL"			, "ALL");	//ALL
			acct_cd.InsertItem(-1, "TIME CHARTERAGE", "C");	//ALL
			acct_cd.InsertItem(-1, "OTHER"			, "O");	//ALL
			
			acct_cd.SetSelectCode(true);

			break;
	}
}
/**
 * Prevent blinking of Sheet when calling DB after implementing onLoad Event Handler of body tag
 * adding first-served functions after loading screen.
 */
function sheet1_OnLoadFinish(sheetObj) {  
	//sheetObj.SetWaitImageVisible(0);
	//doActionIBSheet(sheetObj, document.form, IBROWSEARCH, "ComCd");
    //removeContractTP();
	//sheetObj.SetWaitImageVisible(1);
}
/**
 * Loading Event of HTML_Control existing on page dynamically <br>
 * Calling the function from {@link #loadPage} to initialize IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     sequence of sheetObjects array
 **/
function initControl() {
    axon_event.addListener  ('change'  , 'duration_change', 'fr_duration');			//- Comparing From and To after inserting Duration 
    axon_event.addListener  ('change'  , 'duration_change', 'to_duration');			//- Comparing From and To after inserting Duration 
    axon_event.addListener  ('change'  , 'obj_change', form);			//- Comparing From and To after inserting Duration 

    $(document.form.exe_yrmon).on('blur', function(){
		obj_change();
	});
    initMonth("NEW");
}
function obj_change(){
	var formObj=document.form;
    var sheetObj=sheetObjects[0];
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
            case "exe_yrmon":
            	initMonth("WORK");
            	break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e.message);
		}
	}
}

function initMonth(flag){
	if(flag=="NEW"){
		var nowYrMon = ComGetNowInfo("ym","-")+"-01";
	    
		var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -6);
		var tmpToYm = ComGetDateAdd(nowYrMon,"M", 0);
		var tmpExeYm = ComGetDateAdd(nowYrMon,"M", -1);
		document.form.exe_yrmon.value=gf_GetDateFormat(tmpExeYm,"ym");
		document.form.fr_duration.value=gf_GetDateFormat(tmpFrYm,"ym");
		document.form.to_duration.value=gf_GetDateFormat(tmpToYm,"ym");
		
	}else{
		var nowYrMon = document.form.exe_yrmon.value+"-01";
		
		var tmpFrYm = ComGetDateAdd(nowYrMon,"M", -6);
		var tmpToYm = ComGetDateAdd(nowYrMon,"M", 1);
		
		document.form.fr_duration.value=gf_GetDateFormat(tmpFrYm,"ym");
		document.form.to_duration.value=gf_GetDateFormat(tmpToYm,"ym");
		
		sheetObjects[0].RemoveAll();
	}
}

/**
 * Comparing From and To after inserting Duration 
 **/
function duration_change() {
	var formObj=document.form;
	var fr_duration=ComReplaceStr(formObj.fr_duration.value,'-');
	var to_duration=ComReplaceStr(formObj.to_duration.value,'-');
	if (fr_duration != '' && to_duration != '') {
		if (parseFloat(fr_duration) > parseFloat(to_duration)) {
			ComAlertFocus(formObj.to_duration, ComGetMsg('FMS01715'));
			return false;
		}
	}
	return true;
}	
/**
 * Deleting TO of Contract Type
 **/
/*function removeContractTP() {
	for (i=0;i<document.form.flet_ctrt_tp_cd.length;i++) {
		if (document.form.flet_ctrt_tp_cd.options[i].value == "OW") {
			document.form.flet_ctrt_tp_cd.remove(i);
			break;
		}
	}
}*/	
/**
 * setting sheet initial values and header <br>
 * adding case as numbers of counting sheets <br>
 * <br><b>Example :</b>
 * <pre>
 *     initSheet(sheetObj,1);
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
 * @return N/A
 * @author 
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //sheet1 init
            with(sheetObj){
	              var HeadTitle="|Sel|Seq|Rev. Month|Activity Date|Rev./Exp.|VVD|Daily Hire|FMS VVD Duration|FMS VVD Duration|Total\nVoy Days|Working\nDays|Account Name|Estimated|Actual|Accrual|vsl_cd|skd_voy_no|skd_dir_cd|rev_dir_cd|exe_yrmon|rlane_cd|acct_cd|ori_hire_eff_dt|ori_hire_exp_dt|estm_seq_no|estm_vvd_tp_cd|slp_eff_dt|slp_exp_dt";
	              var headCount=ComCountHeadTitle(HeadTitle);
	              //var headCount=ComCountHeadTitle(HeadTitle)+6;
	              //(headCount, 0, 0, true);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle, Align:"Center"} ];
	              InitHeaders(headers, info);
	
	              var cols = [ 
	                         {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
		                     {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		                     {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                     {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"rev_yrmon",        KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"act_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"re_divr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"vvd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Float",     Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"hire_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vst_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ved_dt",           KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sail_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"estm_dys",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"acct_itm_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"est_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   	InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"act_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   	InsertEdit:0 },
		                     {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"acc_amt",          KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_cd", 	      KeyField:0, 	CalcLogic:"", 	Format:"", 		  	  PointCount:0,   	UpdateEdit:0, 	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no", 	  KeyField:0, 	CalcLogic:"", 	Format:"", 		  	  PointCount:0, 	UpdateEdit:0, 	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd", 	  KeyField:0, 	CalcLogic:"", 	Format:"", 		  	  PointCount:0, 	UpdateEdit:0, 	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"rev_dir_cd", 	  KeyField:0, 	CalcLogic:"", 	Format:"", 		  	  PointCount:0, 	UpdateEdit:0, 	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"exe_yrmon", 	      KeyField:0, 	CalcLogic:"", 	Format:"", 		  	  PointCount:0, 	UpdateEdit:0, 	InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"acct_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ori_hire_eff_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ori_hire_exp_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"estm_seq_no",  	  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"estm_vvd_tp_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"slp_eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   	UpdateEdit:0,   InsertEdit:0 },
		                     {Type:"Date",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"slp_exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   	UpdateEdit:0,   InsertEdit:0 }
		                     ];
	              
	              InitColumns(cols);
	              SetEditable(1);
	              //ShowSubSum([{StdCol:"subsumcol", SumCols:"est_amt|act_amt|acc_amt", Sort:false, ShowCumulate:false, CaptionCol:9, CaptionText:"Total Amount"}]);
	              SetColProperty("re_divr_cd", {ComboText:"Expense|Revenue", ComboCode:"E|R"} );
	              resizeSheet();
                }
            break;
    }
}
// Handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction, Col, Row) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
     	case IBSEARCH:      
   	   	  	if(validateForm(sheetObj,formObj,sAction)){
        		formObj.f_cmd.value=SEARCH01;
        		sheetObj.DoSearch("ESM_FMS_0046GS.do", FormQueryString(formObj));
  	   	  	}	
            break;
       	case IBSAVE:        
 			if(!validateForm(sheetObj,formObj,sAction))return;
 			var SaveStr=ComGetSaveString(sheetObj, true, true, -1);

 			formObj.f_cmd.value=MULTI;
 			var param=SaveStr + "&" + FormQueryString(formObj);
			var sXml=sheetObj.GetSaveData("ESM_FMS_0046GS.do", param);
			
			if (ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "S"){
				//성공 메세지 출력.
				sheetObj.LoadSaveData(sXml);
				
				if (!duration_change()) return;
             	doActionIBSheet(sheetObj,formObj,IBSEARCH);
			}else{
				//실패
				sheetObj.LoadSaveData(sXml);
			}
			
			
 			//sheetObj.DoSave("ESM_FMS_0046GS.do", FormQueryString(formObj));
            break;
            /*
            case IBROWSEARCH:   
			if (Col == "ComCd") {//Status, Dry Dock Type
				CoFmsGetCombo("FORM", formObj, sheetObj, "CD01513","flet_ctrt_tp_cd", "flet_ctrt_tp_cdText");
				//Type
				getTypeCombo(sheetObj);
			}	
            break;*/
     	case IBCREATE:      
   	   	  	if(validateForm(sheetObj,formObj,sAction)){
        		formObj.f_cmd.value=SEARCH;
        		var rXml=sheetObj.GetSearchData("ESM_FMS_0046GS.do", FormQueryString(formObj));
        		sheetObj.LoadSearchData(rXml,{Sync:2} );
        		ComBtnEnable("btn_save");
  	   	  	}	
            break;
    }
}
var selComboIndex, selComboCode;
function acct_cd_OnSelect(comboObj ,index, text , code) {
	selComboIndex = index;
	selComboCode = code;
}
function acct_cd_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	var cnt=0;
	var count = parseInt(comboObj.GetItemCount());
	var name = "";
	//var isAllText = false;
	for(var i = 1 ; i <  count; i++) {
	   if(comboObj.GetItemCheck(i)) {
	       cnt++;
	       if(comboObj.GetSelectCode().indexOf("ALL") > -1){
	    	   //isAllText = true;
	    	   break;
	       }else{
	    	   name = comboObj.GetText(comboObj.GetSelectCode(), 1);
	       }
	   }
	}
}
/**
 * Handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    if (!ComChkValid(formObj)) return false;
    return true;
}

 /**
  * Event occurring after searching IBSheet
  */
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
	sheetObj.SetSumText(0,"ved_dt","TOTAL"); 
}


function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
    var Row=sheetObj.MouseRow();
    var Col=sheetObj.MouseCol();
    var prefix="";
    var sText = "";
    var selColName = sheetObj.CellSaveName (Row, Col);
    sText = sheetObj.GetCellText(Row,selColName)
	if(sText != ""){
    	sheetObj.SetToolTipText(Row,Col,sText);
    }        
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}    