/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0038.js
*@FileTitle  : Tariff Simulation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================
*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var ABC="*";
var LANE="lane";
var ROWMARK="|";
var FIELDMARK=",";
var conditionXML="";
var accountList="";
var costList="";
var arrFormulaNo=new Array();	//Getting Formula_No IN (1, 2)
var gSetHeaderGetRowHeight = 30;//Head Row Height
var gSetDataRowHeight = 30;//Data Row Height
var gSetDataRowHeight = 20;//Data Row Height
var gColCountInSheet=[0,0,0,0,0,0];
var gCurrCdByUSD = "USD";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_port_cd":
				var sUrl="/opuscntr/VOP_VSK_0043.do";
				ComOpenPopup(sUrl, 422, 510, "portCallBack", "0,0", true);
			break;
				
			case "btn_vvd_search":
				var vsl_cd=formObject.vsl_cd.value;
            	var sUrl="";
            	if(vsl_cd == ""){
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 500, 480, "getVslCdData", "0,0", true);
            	}else{
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vsl_cd;
            		ComOpenPopup(sUrl, 340, 400, "getVvdData", "0,0", true);
            	}
			break;	
			
			case "btns_Calendar1" :		// Issue Date
				var cal=new ComCalendar();
				cal.setEndFunction("issueDateChange");	//Callback Function
				cal.select(formObject.issue_date, 'yyyy-MM-dd');
			break;
			
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				changeInOut();
				break;
				
			case "btn_New":
				doActionIBSheet(sheetObject1,formObject,IBCLEAR);
				break;
				
			case "btn_Calculation":
				if(sheetObject1.RowCount()== 0 && sheetObject2.RowCount()== 0){
					return;
				}
				//Setting trxn
				for(var i=sheetObject1.HeaderRows(); i<sheetObject1.RowCount()+sheetObject1.HeaderRows(); i++){
					sheetObject1.SetRowStatus(i,"U");
				}
			
				for(var i=sheetObject2.HeaderRows(); i<sheetObject2.RowCount()+sheetObject2.HeaderRows(); i++){
					sheetObject2.SetRowStatus(i,"U");
				}
				
				doActionIBSheet(sheetObject1,formObject,COMMAND02);
				//checkInOutValue();//command02 뒤로 이동
			break;
		} 
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
} 

function portCallBack(rtnVal) {
	if(rtnVal){
		document.form.port_cd.value=rtnVal;
		//formObject.port_cd.value=rVal[0][1];
		//loadTerminal();				//COMBO YARD
		//f_ClearSheets();
	}
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
 * adding process for list in case of needing batch processing with other items
 * defining list on the top of source
 */ 
function setComboObject(combo_obj) {  
	comboObjects[comboCnt++]=combo_obj;  
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	for(var k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],k+1);
	}
	initControl(sheetObjects[0]);
	document.form.port_cd.focus();
	//searchVslClass();
}

function initControl(sheetObj){
	formObj=document.form;
	setToday(formObj.issue_date);
	axon_event.addListenerForm  ('change'	, 'obj_change'	, form);
	axon_event.addListenerForm  ('blur'		, 'obj_blur'	, form);
	axon_event.addListenerForm  ('keyup'	, 'obj_keyup'	, form); 
	axon_event.addListenerForm  ('paste'	, 'obj_paste'	, form); 
	axon_event.addListenerForm  ('drop'		, 'obj_drop'	, form); 
	//axon_event.addListenerForm  ('click'	, 'obj_click'	, form); 
}
/**
 * setting combo initial values and header
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */ 
function initCombo(comboObj, comboNo) {
	var formObject=document.form;
	switch(comboObj.options.id) {  
		case "yard_cd":		//Yard 
			with (comboObj) { 
				SetMultiSelect(0);
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetColWidth(0, "40");
				SetColWidth(1, "200");
				SetMaxLength(2);
				ValidChar(2, 1);
			}
		break; 
		
		case "acct_cd":		//Account 
			with (comboObj) { 
				SetMultiSelect(true);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
				SetDropHeight(190);
				SetMaxLength(6);
				SetColWidth(0, "60");
				SetColWidth(1, "300");
			}
		break; 	
		
		case "cost_cd":		//Cost 
			with (comboObj) { 
				SetMultiSelect(1);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
				SetColWidth(0, "60");
				SetColWidth(1, "300");
				SetDropHeight(190);
				SetMaxLength(6);
			}
		break; 	
		
		case "clpt_ind_seq":		//clpt_ind_seq 
			with (comboObj) { 
				SetMultiSelect(0);
				//SetEditable(0);
				SetUseAutoComplete(1);
				SetDropHeight(60);
				SetColWidth(0, "40");
				SetMaxLength(2);
				SetColAlign(1, "center");
				ValidChar(2, 1);
			}
		break;	
		
		case "vndr_seq":		//Service Provider 
			with (comboObj) { 
				SetMultiSelect(1);
			    SetMultiSeparator(",");  // add 
				SetUseAutoComplete(1);
				SetColWidth(0, "60");
				SetColWidth(1, "300");
				SetDropHeight(190);
				SetMaxLength(10);
			}
		break; 
	}
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetid=sheetObj.id;
	switch(sheetid) {
		case "sheet1":	//Objects (Auto)
		    with(sheetObj){
		      var HeadTitle1="|Auto I/F Object|Auto I/F Object|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
		      var HeadTitle2="|Object Name|Object Value|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColCountInSheet[0]=headCount;
		      var prefix="sheet1_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
		      var info={ Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers=[ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols=[ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dflt_val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_list_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(1);
              SetShowButtonImage(1);
		      SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      SetCountPosition(0);
	      }
		break;
		
		case "sheet2":	//Objects (Manual)				
		    with(sheetObj){
		      var HeadTitle1="|Manual Object|Manual Object|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
		      var HeadTitle2="|Object Name|Object Value|no|val|pso_meas_ut_cd|pso_meas_ut_nm";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColCountInSheet[1]=headCount;
		      var prefix="sheet2_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
		      var info={ Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers=[ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols=[ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:prefix+"obj_list_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dflt_val",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"obj_list_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_obj_list_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pso_meas_ut_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		      InitColumns(cols);
		      SetEditable(1);
		      SetShowButtonImage(1);
		      SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      SetCountPosition(0);
	      }
		break;
		
		case "sheet3":	//Calculated Result
            with(sheetObj){
			  var HeadTitle1="|Calculated Result|Calculated Result|Calculated Result";
			  var HeadTitle2="|Account CD|Curr.|Tariff Cost";
			  var headCount=ComCountHeadTitle(HeadTitle1);
			  gColCountInSheet[2]=headCount;
			  var prefix="sheet3_";
			  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
			  var info={ Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
			  var headers=[ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"} ];
			  InitHeaders(headers, info);
			  var cols=[ {Type:"Status",    Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			               {Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			               {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:prefix+"tariff_cost", KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 } 
			               //{Type:"AutoSum",     Hidden:0,  Width:60,   Align:"Right",  ColMerge:1,   SaveName:prefix+"tariff_cost", KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 } 
			               ];
			  InitColumns(cols);
			  SetEditable(0);
			  SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      SetCountPosition(0);
			}
		break;
		
		case "sheet4":	//Tariff Cost Detail
		    with(sheetObj){
		      var HeadTitle1="|Account|Cost Code|Service\nProvider|Service\nProvider|Curr.|Calculated AMT|Invoice AMT|Diff.|Formula|Formula Expression|Invoice Total|Total I|Total O|USD AMT";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColCountInSheet[3]=headCount;
		      var prefix="sheet4_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
		      var info={ Sort:0, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers=[ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols=[ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"acct_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"cost_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"vndr_seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:160,  Align:"Left",  	ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  	ColMerge:1,   SaveName:prefix+"curr_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             //{Type:"AutoSum",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"tariff_amount",        KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             //{Type:"AutoSum",     Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:prefix+"locl_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Float",     Hidden:0, Width:130,  Align:"Right",   	ColMerge:1,   SaveName:prefix+"tariff_amount",        KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Float",     Hidden:0, Width:130,  Align:"Right",   	ColMerge:1,   SaveName:prefix+"locl_amt",             KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Float",     Hidden:0, Width:60,   Align:"Right",   	ColMerge:1,   SaveName:prefix+"diff",                 KeyField:0,   CalcLogic:"|sheet4_tariff_amount|-|sheet4_locl_amt|",Format:"Float",       UpdateEdit:1,   InsertEdit:1,   EditLen:14 },
		             {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    	ColMerge:1,   SaveName:prefix+"runtime_formula_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , MultiLineText:true},
		             {Type:"Text",      Hidden:0, Width:230,  Align:"Left",    	ColMerge:1,   SaveName:prefix+"display_formula_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 , MultiLineText:true},
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    	ColMerge:0,   SaveName:prefix+"inv_total",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    	ColMerge:0,   SaveName:prefix+"total_i",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:50,   Align:"Left",    	ColMerge:0,   SaveName:prefix+"total_o",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:150,  Align:"Right",   	ColMerge:1,   SaveName:prefix+"tariff_usd_amount",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:4,   UpdateEdit:1,   InsertEdit:1,   EditLen:14 } ];
		      InitColumns(cols);
		      SetEditable(0);
              SetShowButtonImage(1);
              SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      SetCountPosition(0);
	          //SetSumRowHidden(1); 
	      }
		break;
		
		case "sheet5":	//Invoice Detail
		    with(sheetObj){
		      var HeadTitle1="|Account|Cost Code|Invoice No.|Service Provider|Service Provider|CUR|I/O|Tariff Cost|Adjustment Cost|Invoice Amount|Formula|Formula|Remark|Invoice Total|Total I|Total O";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      gColCountInSheet[4]=headCount;
		      var prefix="sheet5_";
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataGetRowMerge:1 } );
		      var info={ Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers=[ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols=[ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:110,   Align:"Left",  ColMerge:1,   SaveName:prefix+"inv_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vndr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dp_io_bnd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"calc_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"adj_amt",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Float",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:prefix+"locl_amt",     KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"xpr_desc",     KeyField:0, MultiLineText:true  },
		             {Type:"Text",     Hidden:0,  Width:200,  Align:"Left",    ColMerge:0,   SaveName:prefix+"foml_desc",    KeyField:0, MultiLineText:true  },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"inv_total",    KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"total_i",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Float",      Hidden:1, Width:50,   Align:"Left",    ColMerge:0,   SaveName:prefix+"total_o",      KeyField:0,   CalcLogic:"",   Format:"Float",       UpdateEdit:0,   InsertEdit:0 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetShowButtonImage(1);
              SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      //SetMergeCell(0, 3, 1, 2);
		      //SetMergeCell(0, 10, 1, 2);
		      SetCountPosition(0);
	      }
		break;
		
		case "sheet6":	//Dummy
		    with(sheetObj){
		      var HeadTitle1="|yd_chg_no|yd_chg_ver_seq|curr_cd|acct_cd|cost_cd|vndr_seq|vndr_lgl_eng_nm|upd_usr_id|upd_dt";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var prefix="sheet6_";
		      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataGetRowMerge:1 } );
		      var info={ Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		      var headers=[ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols=[ {Type:"Status",    Hidden:1, Width:10,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_chg_ver_seq",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"acct_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cost_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"vndr_lgl_eng_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 } ];
		      InitColumns(cols);
		      SetEditable(0);
		      SetShowButtonImage(1);
              SetHeaderRowHeight(GetHeaderRowHeight());
		      SetDataRowHeight(GetDataRowHeight());
		      SetSheetHeight(2 * GetHeaderRowHeight()+ 6 * GetDataRowHeight() + 8);
		      SetCountPosition(0);
	      }
		break;				
	}
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      // Retrieving
			if(!checkVvd2()) return;	//Check VVD
			f_ClearSheets();
			searchVersion();
			
			if(sheetObjects[5].SearchRows()==0) return; //대상 tariff가 하나도 없는 경우 아래 로직 수행 중 에러남
			
			var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet5_" );        
			
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			//sheetObjects[0].RenderSheet(0);
			//sheetObjects[1].RenderSheet(0);
			//sheetObjects[4].RenderSheet(0);
			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[1].SetWaitImageVisible(0);
			sheetObjects[4].SetWaitImageVisible(0);
			
			var sXml=sheetObj.GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects[5], true, true) + "&" + ComGetPrefixParam(aryPrefix));
			var arrXml=sXml.split("|$$|");
			
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
			sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
			sheetObjects[4].LoadSearchData(arrXml[2],{Sync:1} );
			sheetObjects[4].ColumnSort("sheet5_acct_cd");
			//sheetObjects[0].RenderSheet(1);
			//sheetObjects[1].RenderSheet(1);
			//sheetObjects[4].RenderSheet(1);
			sheetObjects[0].SetWaitImageVisible(1);
			sheetObjects[1].SetWaitImageVisible(0);
			sheetObjects[4].SetWaitImageVisible(0);
			ComOpenWait(false);
		break;
		
		case IBSEARCH_ASYNC01:	//Setting initial conditions
			var prefix="sheet1_";
			var aryPrefix=new Array( "sheet1_" );
			formObj.f_cmd.value=SEARCHLIST01;
			
			var param=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
			conditionXML=sheetObjects[5].GetSearchData("VOP_PSO_0002GS.do", param );
			var arrXml=conditionXML.split("|$$|");
			
			//Initializing combo (Account)
			acct_cd.RemoveAll();
			
			//Initializing combo (Cost)
			cost_cd.RemoveAll();
			
			//Initializing combo (Service Provider)
			vndr_seq.RemoveAll();
			
			var arrFormula4Loading=ComGetEtcData(conditionXML, "formula4Loading").split("|@LF|");
			
			var k=0;
			for(var i=0; i<arrFormula4Loading.length; i++){
				arrKeyVal=arrFormula4Loading[i].split("|@DELIM|");
				for(var j=0; j<arrKeyVal.length; j++){
					arrFormulaNo[k]=arrKeyVal[j];
					k++;             
				}
				if(k == 4) break;
			}
		break;
		
		case IBCLEAR:  
			
			ComSetObjValue(formObj.port_cd, ""); //Port
			yard_cd.RemoveAll();
			acct_cd.RemoveAll();//Account
			ComSetObjValue(formObj.account_nm, ""); //Account
			cost_cd.RemoveAll();//Cost
			ComSetObjValue(formObj.lgs_cost_nm, ""); //Account
			
			vndr_seq.RemoveAll();//Service Provider
			ComSetObjValue(formObj.vndr_lgl_eng_nm, ""); //Service Provider
			
			setToday(formObj.issue_date);//Issue Date
			
			ComSetObjValue(formObj.vsl_cd, ""); //VVD
			ComSetObjValue(formObj.skd_voy_no, ""); //VVD
			ComSetObjValue(formObj.skd_dir_cd, ""); //VVD
			clpt_ind_seq.RemoveAll();//clpt_ind_seq
			clpt_ind_seq.SetEnable(1);
			
			formObj.cpls_flg.checked=false;
			ComSetObjValue(formObj.cpls_flg, "N"); //VVD
			//CLASS
			f_ClearSheets();
			
			/*
			formObj.port_cd.value="";
			//Yard
			yard_cd.RemoveAll();
			//Account
			acct_cd.RemoveAll();
			formObj.account_nm.value="";
			//Cost
			cost_cd.RemoveAll();
			formObj.lgs_cost_nm.value="";
			//Service Provider
			vndr_seq.RemoveAll();
			formObj.vndr_lgl_eng_nm.value="";
			//Issue Date
			setToday(formObj.issue_date);
			//VVD
			formObj.vsl_cd.value="";
			formObj.skd_voy_no.value="";
			formObj.skd_dir_cd.value="";
			
			formObj.cpls_flg.checked=false;
			formObj.cpls_flg.value="N";
			//CLASS
			f_ClearSheets();*/
		break;        
		
		case COMMAND05:	//Port Code [keyup:5 length]  
		    formObj.f_cmd.value=COMMAND05;	//
			//port change
		    acct_cd.RemoveAll();
			formObj.account_nm.value="";
			cost_cd.RemoveAll();
			formObj.lgs_cost_nm.value="";
			vndr_seq.RemoveAll();
			formObj.vndr_lgl_eng_nm.value="";
			var param=FormQueryString(formObj);
			var isPort=ComSearchEtcData(sheetObj, "VOP_PSO_0002GS.do", param, "isPort");
			
			if(isPort == "O"){
				rVal=formObj.port_cd.value;
				loadTerminal();
				yard_cd.Focus();
			} else if(isPort == "X"){
				ComShowCodeMessage("PSO00014", "[Port]");
				formObj.port_cd.value="";
				formObj.port_cd.focus();
			}
		break;
		
		case COMMAND02:      // Calculation Button Click
			if(!checkVvd2()) return;	//Check VVD
			var aryPrefix=new Array( "sheet4_");
			
			if( !validateForm(sheetObj,formObj,sAction)) return;
			formObj.f_cmd.value=COMMAND02;
			ComOpenWait(true);
			sheetObjects[0].SetWaitImageVisible(0);
			
			var saveObjs=new Array(2);
			saveObjs[0]=sheetObjects[0];
			saveObjs[1]=sheetObjects[1];
			var SaveStr=f_ComGetSaveString(saveObjs);
			var sXml=sheetObj.GetSearchData("VOP_PSO_0038GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetSaveString(sheetObjects[5], true, true) + "&" + ComGetPrefixParam(aryPrefix));
			
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY") == "F"){//error
				ComOpenWait(false);
				sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
				sheetObjects[2].RemoveAll();
				sheetObjects[3].RemoveAll();
				return;
			}
			sheetObjects[3].LoadSearchData(sXml,{Sync:1} );
			ComOpenWait(false);
		break;      
		
		case SEARCH04:	//vvd의 CLPT_IND_SEQ
		    formObj.f_cmd.value=SEARCH04;
		    
			//vvd의 기존 clpt_ind_seq를 지운다. 
		    clpt_ind_seq.RemoveAll();
			
		    var param=FormQueryString(formObj);
			var clptIndSeqs = ComSearchEtcData(sheetObj, "VOP_PSO_0038GS.do", param, "clptIndSeqs");
			
			if(typeof clptIndSeqs =="undefined" || clptIndSeqs == undefined || clptIndSeqs == ""){
				clpt_ind_seq.RemoveAll();
				return;
			}	
			var comboItems=clptIndSeqs.split(ROWMARK);
			
			for (var i=0 ; i < comboItems.length ; i++) {
				clpt_ind_seq.InsertItem(-1, comboItems[i] , comboItems[i]);
			}
			var iItemCount = clpt_ind_seq.GetItemCount();
			if(iItemCount > 0){
				clpt_ind_seq.SetSelectIndex(0);
				if(iItemCount == 1){
					clpt_ind_seq.SetEnable(0);
				}else{
					clpt_ind_seq.SetEnable(1);
				}
			}
			
		break;
	}
}
/**
* handling process for input validation
*/
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:
			//Port
			if(formObj.port_cd.value.length < 5){
				ComShowCodeMessage('PSO00007');
				return false;
			}	
			//Yard
			if( yard_cd.GetSelectCode()== ''){
				ComShowCodeMessage('PSO00008');
				return false;
			}	
			//Account
			if( acct_cd.GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Account]");	//mandatory
				return false;
			}					
			//Cost
			if( cost_cd.GetSelectCode()== ''){
				ComShowCodeMessage('PSO00003', "[Cost CD]");	//mandatory
				return false;
			}	
			//Service Provider
			if(vndr_seq.GetSelectCode()== ''){
				ComShowCodeMessage('PSO00011');
				return false;
			}	
			//Issue Date
			if(formObj.issue_date.value == ''){
				ComShowCodeMessage('PSO00009');
				return false;
			}
			
			var varVslCd 	= ComGetObjValue(formObj.vsl_cd);
			var varSkdVoyNo = ComGetObjValue(formObj.skd_voy_no);
			var varSkdDirCd = ComGetObjValue(formObj.skd_dir_cd);
			
			var varVvd = varVslCd + varSkdVoyNo + varSkdDirCd;
			if(!ComIsEmpty(varVvd) && varVvd.length == 9){
				//clpt_ind_seq
				if( clpt_ind_seq.GetSelectCode()== ''){
					ComShowCodeMessage('PSO00003', "[Port Seq]");	//mandatory
					return false;
				}
			}
			
			
		break;
	}
	return true;
}

/**
 * 2016.02.17 paste VVD 처리.
 * @param e
 */
function clipboardDataEvent (e) {
	var pastedText = undefined;
	if (window.clipboardData && window.clipboardData.getData) {
		//ie
		pastedText = window.clipboardData.getData('Text');
	} else if (event.clipboardData && event.clipboardData.getData) {
		//chrome
		pastedText = event.clipboardData.getData('text/plain');
	}
	
	var formObj=document.form;
	
	var tmpVslCd = "";
	var tmpSkdVoyNo = "";
	var tmpSkdDirCd = "";
	
	var iLen = 0;
	if(!ComIsEmpty(pastedText)){
		iLen = pastedText.length;
	}
	
	if(iLen >= 9){
		tmpVslCd 	= pastedText.substr(0,4);
		tmpSkdVoyNo = pastedText.substr(4,4);
		tmpSkdDirCd = pastedText.substr(8,1);
	}else if(iLen < 9 && iLen > 4){
		tmpVslCd 	= pastedText.substr(0,4);
		tmpSkdVoyNo = pastedText.substr(4);
	}else{
		tmpVslCd 	= pastedText.substr(0,4);
	}
	//obj, sValue, bArgTrim
	ComSetObjValue(formObj.vsl_cd		, tmpVslCd		, false);
	ComSetObjValue(formObj.skd_voy_no	, tmpSkdVoyNo	, false);
	ComSetObjValue(formObj.skd_dir_cd	, tmpSkdDirCd	, false);
	
}

function obj_change(){
	var formObj=document.form;
	var tmpYardCd = comboObjects[0].GetSelectCode();
	obj=ComGetEvent();   
	with(formObj){
		switch(ComGetEvent("name")) {
			case "port_cd":	// Port
				break;
			case "issue_date":	// Issue Date
				issueDateChange();
				break;
			case "vsl_cd":
			case "skd_voy_no":	//				
			case "skd_dir_cd":	//
				initComboClptIndSeq();				
				break;
			case "cpls_flg":
				if(formObj.port_cd.value.length < 5){
					ComShowCodeMessage('PSO00007');
					initCplsFlg(obj);
					return;
				}	
				//Yard
				if( tmpYardCd == ""){
					ComShowCodeMessage('PSO00008');
					initCplsFlg(obj);
					return;
				}
				
				//Compulsory Checked 일때는 Account/Cost/Vendor를 Compulsory Y 인 레코드로 재 조회 한다.
				if(obj.checked){
					obj.value = "Y";
				}else{
					obj.value = "N";
				}
				
				f_ClearSheets(); 
				addComboItemAccount();
				break;
		}
	}		
}
function initComboClptIndSeq(){
	var formObj 	= document.form;
	var varPortCd 	= ComGetObjValue(formObj.port_cd);
	var varYardCd 	= yard_cd.GetSelectCode();
	
	var varVslCd 	= ComGetObjValue(formObj.vsl_cd);
	var varSkdVoyNo = ComGetObjValue(formObj.skd_voy_no);
	var varSkdDirCd = ComGetObjValue(formObj.skd_dir_cd);
	
	if(ComIsEmpty(varVslCd) || varVslCd.length < 4){
		ComSetObjValue(formObj.vsl_cd, "");
		ComSetObjValue(formObj.skd_voy_no, "");
		ComSetObjValue(formObj.skd_dir_cd, "");
		
		clpt_ind_seq.RemoveAll();
		clpt_ind_seq.SetEnable(1);
		return;
	}
	
	if(ComIsEmpty(varSkdVoyNo) || varSkdVoyNo.length < 4){
		ComSetObjValue(formObj.skd_voy_no, "");
		ComSetObjValue(formObj.skd_dir_cd, "");
		
		clpt_ind_seq.RemoveAll();
		clpt_ind_seq.SetEnable(1);
		return;
	}
	
	if(ComIsEmpty(varSkdDirCd) || varSkdDirCd.length < 1){
		ComSetObjValue(formObj.skd_dir_cd, "");
		
		clpt_ind_seq.RemoveAll();
		clpt_ind_seq.SetEnable(1);
		return;
	}
	
	var varVvd = varVslCd + varSkdVoyNo + varSkdDirCd;
	if(!ComIsEmpty(varPortCd) && !ComIsEmpty(varYardCd) && varVvd.length == 9){
		//alert("vvd chage ["+varPortCd+"]["+varYardCd+"]["+varVvd+"]");
		doActionIBSheet(sheetObjects[0], formObj, SEARCH04);
	}else{
		clpt_ind_seq.RemoveAll();
		clpt_ind_seq.SetEnable(1);
	}
	
}
function initCplsFlg(obj){
	if(obj.checked){
		obj.checked = false;
		obj.value = "N";
	}else{
		obj.checked = true;
		obj.value = "Y";
	}
}
function obj_blur(){
	var formObj=document.form;
	obj=ComGetEvent();
	with(formObj){
		switch(ComGetEvent("name")) {
			case "port_cd":
				var val=obj.value; 
				for(var i=0; i<val.length; i++) {
					if(val.charCodeAt(i) > 90 || val.charCodeAt(i) < 65){
						formObj.port_cd.value="";
						formObj.port_cd.focus();
						break;
					}
				}
				break;
			case "issue_date":	//Issue Date
				ComChkObjValid(ComGetEvent());
				break;
		}	
	}
}
function obj_keyup(){
	var eleObj=event.srcElement;
	var formObj=document.form;
	switch (eleObj.name) {
		case "port_cd":
			if(eleObj.value.length == 5){
				doActionIBSheet(sheetObjects[0], formObj, COMMAND05);
			} else{
				yard_cd.RemoveAll();
			}
			break;
		case "vsl_cd":
			if (eleObj.value.length == 4) {
				//formObj.skd_voy_no.focus();
			}	
			break;
		case "skd_voy_no":
			if (eleObj.value.length == 4) {
				//formObj.skd_dir_cd.focus();
			}
			break;
	}
}
function obj_paste(){
	var eleObj=ComGetEvent();
	var formObj=document.form;
	switch (eleObj.name) {
		case "port_cd":
			gf_SetControlPastePattern(event, "A");
		break;
		case "vsl_cd":
			//gf_SetControlPastePattern(event, "A");
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;
		case "skd_voy_no":
			//gf_SetControlPastePattern(event, "0");
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;
		case "skd_dir_cd":
			//gf_SetControlPastePattern(event, "A");
			gf_PasteVVD(event, formObj.vsl_cd, formObj.skd_voy_no, formObj.skd_dir_cd);	//Copy&Paste
		break;
		case "issue_date":
			gf_SetControlPastePattern(event, "0");
		break;
	}
}
function obj_drop(){
	event.returnValue=false;
}
 
/**
 * Retrieving Combo
 */
function sheet1_OnLoadFinish(sheetObj){
	var formObj=document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH_ASYNC01);
	f_InitSheets();
}
/**
 * in case 'IN', 'OUT' select, Handling locl_amt
 */
function sheet2_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var prefix="sheet2_";
	var sheetObj4=sheetObjects[3];
	var iprefix=sheetObj4.id + "_";
	var inValue="";
	var outValue="";
	sheetObj.ShowDebugMsg(false);
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "dflt_val" :
			var obj_list_no=sheetObj.GetCellValue(Row, prefix + "obj_list_no");	//IN=77, OUT=89
			var obj_list_value=sheetObj.GetCellValue(Row, prefix + "dflt_val");
			for(var j=sheetObj.HeaderRows(); j<sheetObj.HeaderRows()+ sheetObj.RowCount(); j++){
				if (sheetObj.GetCellValue(j, prefix+"obj_list_no")=="77"){
					inValue=sheetObj.GetCellValue(j, prefix+"dflt_val");
				} if(sheetObj.GetCellValue(j, prefix+"obj_list_no")=="89"){
					outValue=sheetObj.GetCellValue(j, prefix+"dflt_val");
				}
			}
			if(obj_list_no == "77" || obj_list_no == "89"){
				for(var i=sheetObj4.HeaderRows(); i<sheetObj4.HeaderRows()+ sheetObj4.RowCount(); i++){
					if(sheetObj4.GetCellValue(i,iprefix+"total_i")>0 && sheetObj4.GetCellValue(i,iprefix+"total_o")>0){
						if(obj_list_no == "77" && obj_list_value == "Y"){
							if(outValue == "Y"){
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
							}else{
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_i"));
							}
						} else if(obj_list_no == "77" && obj_list_value == "N"){
							if(outValue == "Y"){
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_o"));
							}else{
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
							}
						} else if(obj_list_no == "89" && obj_list_value == "Y"){
							if(inValue == "Y"){
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
							}else{
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_o"));
							}
						} else if(obj_list_no == "89" && obj_list_value == "N"){
							if(inValue == "Y"){
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_i"));
							}else{
								sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
							}
						}
					} else{
						sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
					}
				}	
			}		
 		break;
	}
}
/*
 * Handling after Retrieving
 */
function sheet5_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	//Changing Column Type
	f_SetCellProperty(sheetObjects[0], "sheet1_");
	f_SetCellProperty(sheetObjects[1], "sheet2_");
}

function sheet4_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var Row=sheetObj.MouseRow();
	var Col=sheetObj.MouseCol();
	var prefix="sheet4_";

	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "vndr_lgl_eng_nm" :
		case prefix + "runtime_formula_desc" :
		case prefix + "display_formula_desc" :
			sheetObj.SetMousePointer("Hand");
			sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
			break;
		default :
			sheetObj.SetMousePointer("Default");
			break;
	}
	/*if (Row >= sheetObj.HeaderRows()&& Col == "8") {
		sheetObj.SetMousePointer("Hand");
		sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
	}else if (Row >= sheetObj.HeaderRows()&& Col == "9") {
		sheetObj.SetMousePointer("Hand");
		sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
	}else{
		sheetObj.SetMousePointer("Default");
	}*/
}

function sheet4_OnClick(sheetObj, Row, Col, Value) {
	var prefix="sheet4_";
	var colname=sheetObj.ColSaveName(Col);
	switch (colname) {
		case prefix+ "runtime_formula_desc":
		case prefix+ "display_formula_desc":
			var tmpValue = sheetObj.GetCellValue(Row, Col);
			if(!ComIsEmpty(tmpValue)){
				ComShowMemoPad(sheetObj, Row, Col, true, 800, null, null,1);
			}
			break;
	}	
}

function sheet5_OnMouseMove(sheetObj, Button, Shift, X, Y){
	var Row=sheetObj.MouseRow();
	var Col=sheetObj.MouseCol();
	var prefix="sheet5_";
 
	switch (sheetObj.ColSaveName(Col)) {
		case prefix + "vndr_nm" :
		case prefix + "xpr_desc" :
		case prefix + "foml_desc" :
		case prefix + "rmk" :
			sheetObj.SetMousePointer("Hand");
			sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
			break;
		default :
			sheetObj.SetMousePointer("Default");
			break;
	}
	/*
	if (Row >= sheetObj.HeaderRows()&& Col == "10") {
		sheetObj.SetMousePointer("Hand");
		sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
	} else if (Row >= sheetObj.HeaderRows()&& Col == "11") {
		sheetObj.SetMousePointer("Hand");
		sheetObj.SetToolTipText(Row, Col, sheetObj.GetCellValue(Row, Col));
	}else{
		sheetObj.SetMousePointer("Default");
	}*/
}

function sheet5_OnClick(sheetObj, Row, Col, Value) {
	var prefix="sheet5_";
	var colname=sheetObj.ColSaveName(Col);
	switch (colname) {
		case prefix+ "foml_desc":
		case prefix+ "xpr_desc":
			var tmpValue = sheetObj.GetCellValue(Row, Col);
			if(!ComIsEmpty(tmpValue)){
				ComShowMemoPad(sheetObj, Row, Col, true, 800, null, null,1);
			}
			break;
	}	
}

//	function port_cd_OnChange(){
//		var formObj=document.form;
//		f_ClearSheets(); 
//		var portCd=formObj.port_cd.value;
//		addComboItemAccount();
//	}
function clpt_ind_seq_OnChange(comboObj,OldIndex, OldText, OldCode, NewIndex, NewText, NewCode){
	//이벤트 발생시 선택된 데이타를 유지 하기 위해 선언한다.
}
/**
 * Yard
 */
function yard_cd_OnChange(){
	var formObj=document.form;
	f_ClearSheets(); 
	//var portCd=formObj.port_cd.value;
	addComboItemAccount();
	
	initComboClptIndSeq();
}
function yard_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A|0");
} 
function acct_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
}
function vndr_seq_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "0");
}
function cost_cd_OnKeyDown(comboObj, KeyCode, Shift){
	gf_SetComboPastePattern(comboObj, KeyCode, Shift, "A");
}  
/*
 * Retrieving Yard
 */
function loadTerminal() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	sheetObj.ShowDebugMsg(false);
	yard_cd.RemoveAll();
	formObj.f_cmd.value=SEARCH01;
	//var sXml=sheetObj.GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj));
	//var comboItems=ComGetEtcData(sXml, "lane").split(ROWMARK);
	var etcData = ComSearchEtcData(sheetObj, "VOP_PSO_0038GS.do", FormQueryString(formObj), "lane");
	var comboItems=etcData.split(ROWMARK);
	addComboItem(yard_cd, comboItems);
}
/**
 * Adding data to combo (Currency, Yard)
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split(FIELDMARK);
		comboObj.InsertItem(i, comboItem[0]+ "|" +comboItem[1] , comboItem[0]);
	}   		
}
/**
 * Adding data to combo (Account)
 */	 
function addComboItemAccount() {
	var formObj=document.form;  
	acct_cd.RemoveAll();
	searchAccount();
	var strAccount=ComGetEtcData(accountList, "account");
	if(typeof strAccount =="undefined" || strAccount == undefined || strAccount == ""){
		acct_cd.RemoveAll();
		return;
	}	
	var comboItems=strAccount.split(ROWMARK);
	var comboItem="";
		acct_cd.InsertItem(-1, "ALL|", "ALL");	//ALL
	for (var i=0 ; i < comboItems.length ; i++) {
		comboItem=comboItems[i].split(FIELDMARK);
		acct_cd.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
	}
	acct_cd.SetSelectIndex(0);
	//formObj.account_nm.value = "ALL";
}
/**
 * Adding data to combo (Cost)
 */	
function addComboItemCost() {
	var formObj=document.form;  
	cost_cd.RemoveAll();
	searchCost();
	var strCost=ComGetEtcData(costList, "cost");
	if(typeof strCost =="undefined" || strCost == undefined || strCost == ""){
		cost_cd.RemoveAll();
		vndr_seq.RemoveAll();
		return;
	}	
	var comboItems=strCost.split(ROWMARK);
	var comboItem="";
	cost_cd.InsertItem(-1, "ALL|", "ALL");	//ALL
	for (var i=0 ; i < comboItems.length ; i++) {
		comboItem=comboItems[i].split(FIELDMARK);
		cost_cd.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
	}
	cost_cd.SetSelectIndex(0);
	//formObj.lgs_cost_nm.value = "ALL";
}
 /**
  * Adding data to combo (Provider)
  */	
 function addComboItemProvider() {
 	var formObj=document.form;  
 	vndr_seq.RemoveAll();
 	searchProvider();
 	var strVndr=ComGetEtcData(vndrList, "vndr");
 	
 	if(typeof strVndr =="undefined" || strVndr == undefined || strVndr == "" ){
 		vndr_seq.RemoveAll();
 		return;
 	}	
 	var comboItems=strVndr.split(ROWMARK);
 	var comboItem="";
 	vndr_seq.InsertItem(-1, "ALL|", "ALL");	//ALL
 	for (var i=0 ; i < comboItems.length ; i++) {
 		comboItem=comboItems[i].split(ABC);
 		vndr_seq.InsertItem(-1, comboItem[1] + "|" + comboItem[0], comboItem[1]);
 	}
 	vndr_seq.SetSelectIndex(0);
 	//formObj.vndr_lgl_eng_nm.value = "ALL";
 }
/**
 * Retrieving YD_CHG_NO
 */
function searchVersion(){
	var formObj=document.form;
	formObj.f_cmd.value=COMMAND01;
	var port_cd=formObj.port_cd.value;
	var yard=yard_cd.GetSelectCode();
	var acct=acct_cd.GetSelectCode();
	var cost=cost_cd.GetSelectCode();
	var vndr=vndr_seq.GetSelectCode();
	var issue_date=formObj.issue_date.value;
	if(port_cd == "" || yard == "" || acct == "" || cost == "" || vndr == "" || issue_date == ""){
		return;
	}
	var searchVersionXML=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet6_"));
	sheetObjects[5].LoadSearchData(searchVersionXML,{Sync:1} );
}
/*
 * Retrieving Searvice Provider used in Tariff
 */ 
function searchProvider(){
	var formObj=document.form;
	formObj.f_cmd.value=COMMAND03;
	formObj.vndr_lgl_eng_nm.value="";
	vndrList=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj));
	
}
/*
 * Retrieving Account used in Tariff
 */ 
function searchAccount(){
	var formObj=document.form;
	formObj.f_cmd.value=COMMAND05;
	formObj.account_nm.value="";
	accountList=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj));
	
} 
 /*
  * Retrieving Cost used in Tariff
  */ 
 function searchCost(){
 	var formObj=document.form;
 	formObj.f_cmd.value=SEARCH02;
 	formObj.lgs_cost_nm.value="";
 	costList=sheetObjects[sheetObjects.length-1].GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj));
 }
 function issueDateChange(){
	 addComboItemAccount();
	 //searchProvider();
 }
/*
 * Changing Range Type as UOM
 */ 
function f_SetCellProperty(sheetObj, prefix){
	for(var i=sheetObj.HeaderRows(); i<sheetObj.HeaderRows()+ sheetObj.RowCount(); i++){
		var uom=sheetObj.GetCellValue(i, prefix + "pso_meas_ut_cd");
		var objNo=Number(sheetObj.GetCellValue(i, prefix + "obj_list_no"));
		if(uom == "12"){		//FLAG		
			var orgValue = sheetObj.GetCellValue(i,prefix+"dflt_val");
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Combo",Align:"Center"} );
			sheetObj.CellComboItem(i,prefix+"dflt_val", {ComboText:"|Y|N", ComboCode:"|Y|N"} );
			sheetObj.SetCellValue(i,prefix+"dflt_val",orgValue);
		} else if(uom == "15"){	//TIME
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Center",Format:"Hm"} );
		} else if(uom == "14"){	//CODE
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Right",AcceptKeys:"N|E",InputCaseSensitive:1} );
		} else if(uom == "11"){	//N/A
			//sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Float",Align:"Right",Format:"Float",AcceptKeys:"N"} );
			//sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Right",AcceptKeys:"E",InputCaseSensitive:1} );
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Right",AcceptKeys:"N|E|[/]",InputCaseSensitive:1} );
		} else if(uom == "16"){	//DATE
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Center",Format:"Ymd"} );
		} else if(uom == "17"){	//DAY
			//sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Int",Align:"Center"} );
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Text",Align:"Center",AcceptKeys:"N|E",InputCaseSensitive:1} );
		} else{					//Others (Number)
			sheetObj.InitCellProperty(i, prefix + "dflt_val",{ Type:"Float",Align:"Right",Format:"Float",AcceptKeys:"N"} );
		}
		if(objNo >= 18 && objNo <= 22){	//Constant..
			sheetObj.SetCellEditable(i, prefix + "dflt_val",0);
		} else{
			sheetObj.SetCellEditable(i, prefix + "dflt_val",1);
		}
	}	
}
/*
 * Deleting all Sheets
 */
function f_InitSheets(){
 	var formObj=document.form;
 	//Sheets	
 	for(var i=0; i<sheetObjects.length; i++){
 		sheetObjects[i].RemoveAll();
 	}
}

function f_ClearSheets(){
	var formObj=document.form;
	f_InitSheets();
	var sheetObjs=[sheetObjects[3]];
	var colCount=[gColCountInSheet[3]];
	for(var i=0; i < sheetObjs.length; i++){
		for(var col=0; col < colCount[i]; col++){
			sheetObjs[i].SetCellValue(sheetObjs[i].HeaderRows(), col,"",0);
		}
	}
}
/**
 * Setting about VVD
 * @param obj
 * @return
 */
function getVslCdData(obj){
	if(obj){
		var rtnDatas=obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.vsl_cd.value=rtnDatas[1];
			}
		}
	}
}

function getVvdData(obj){
	if(obj){
		var rtnDatas=obj[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				document.form.skd_voy_no.value=rtnDatas[2];
				document.form.skd_dir_cd.value=rtnDatas[3];
				
				initComboClptIndSeq();
			}
		}
	}
} 
function checkVvd2(){
	var formObj=document.form;
	formObj.f_cmd.value=COMMAND04;
	var port_cd= formObj.port_cd.value;
	var yard= yard_cd.GetSelectCode();
	var vsl_cd=formObj.vsl_cd.value;
	var skd_voy_no=formObj.skd_voy_no.value;
	var skd_dir_cd=formObj.skd_dir_cd.value;
	
	if(port_cd != "" && yard != "" && vsl_cd != "" && skd_voy_no != "" && skd_dir_cd != ""){
		var sXml=sheetObjects[0].GetSearchData("VOP_PSO_0038GS.do", FormQueryString(formObj));
		var isValidVVD=ComGetEtcData(sXml, "isValidVVD");
		if(isValidVVD != "TRUE"){
			ComShowCodeMessage("PSO00001", "[VVD]");
			return false;
		}
	}	
	return true;
}
/*
 * Adding ' in accordance with UOM Type, then Transmitting
 */
function f_ComGetSaveString(sheetObjs){
	try{   	
		var colArr=new Array();
		var rowArr=new Array();
		var sheetArr=new Array();
		var colName="";
		var colValue="";
		var name_ibflag="";	
		var name_obj_list_nm="";
		var name_dflt_val="";
		var name_obj_list_no="";
		var name_pso_obj_list_tp_cd="";
		var name_pso_meas_ut_cd="";	//11:N/A (BLANK), 12:FLAG, 13:CBM, 14:CODE, 15:TIME	 
		var name_pso_meas_ut_nm="";
		var val_ibflag="";
		var val_obj_list_nm="";
		var val_dflt_val="";
		var val_obj_list_no="";
		var val_pso_obj_list_tp_cd="";
		var val_pso_meas_ut_cd="";
		var val_pso_meas_ut_nm="";
		if(sheetObjs.constructor != Array) sheetObjs=new Array(sheetObjs);
		for(var i=0; i < sheetObjs.length ; i++){
			var sheetObj=sheetObjs[i];
			rowArr=new Array();
			for(var row=sheetObj.HeaderRows(); row < sheetObj.RowCount()+ sheetObj.HeaderRows()&& sheetObj.RowCount()> 0; row++){
				var colCnt=0;
				colArr=new Array();
				for(var col=0; col < gColCountInSheet[i]; col++){
					colName=sheetObj.ColSaveName(col);
					colValue=sheetObj.GetCellValue(row, col);
					if(colName == "sheet" + (i+1) + "_ibflag"){
						name_ibflag=colName;
						val_ibflag=colValue;
					} else if(colName == "sheet" + (i+1) + "_obj_list_nm"){
						name_obj_list_nm=colName;	
						val_obj_list_nm=colValue;						
					} else if(colName == "sheet" + (i+1) + "_dflt_val"){
						name_dflt_val=colName;
						colValue=ComReplaceStr(colValue, "'", "");
						val_dflt_val=colValue;						
					} else if(colName == "sheet" + (i+1) + "_obj_list_no"){
						name_obj_list_no=colName;
						val_obj_list_no=colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_obj_list_tp_cd"){
						name_pso_obj_list_tp_cd=colName; 
						val_pso_obj_list_tp_cd=colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_meas_ut_cd"){
						name_pso_meas_ut_cd=colName;
						val_pso_meas_ut_cd=colValue;						
					} else if(colName == "sheet" + (i+1) + "_pso_meas_ut_nm"){
						name_pso_meas_ut_nm=colName;
						val_pso_meas_ut_nm=colValue;						
					}
				}
	    		//if(val_dflt_val != ""){
	    		if(val_pso_meas_ut_cd == 14){			//CODE
	    			val_dflt_val="'" + val_dflt_val + "'";
	    		} else if(val_pso_meas_ut_cd == 12){	//FLAG	('Y')
	    			val_dflt_val="'" + val_dflt_val + "'";
	    		} else if(val_pso_meas_ut_cd == 11){	//N/A
	    			//val_dflt_val = "'" + val_dflt_val + "'";
	    		} else if(val_pso_meas_ut_cd == 15){	//TIME	('0915')
	    			//val_dflt_val = "'" + val_dflt_val + "'";
	    		} else if(val_pso_meas_ut_cd == 16){	//DATE	('20100128')
	    			val_dflt_val="TO_DATE(" + "'" + val_dflt_val + "'" + ", 'YYYYMMDD')";
	    		} else if(val_pso_meas_ut_cd == 17){	//DAY	('SAT')
	    			val_dflt_val="'" + val_dflt_val + "'";
	    		}

				colArr[colCnt++] = name_ibflag 				+ "=" + val_ibflag;
				colArr[colCnt++] = name_obj_list_nm 		+ "=" + val_obj_list_nm;
				colArr[colCnt++] = name_dflt_val 			+ "=" + val_dflt_val;
				colArr[colCnt++] = name_obj_list_no 		+ "=" + val_obj_list_no;
				colArr[colCnt++] = name_pso_obj_list_tp_cd 	+ "=" + val_pso_obj_list_tp_cd;
				colArr[colCnt++] = name_pso_meas_ut_cd 		+ "=" + val_pso_meas_ut_cd;
				colArr[colCnt++] = name_pso_meas_ut_nm 		+ "=" + val_pso_meas_ut_nm;
					
				rowArr[row-sheetObj.HeaderRows()]=colArr.join("&");
			}
			sheetArr[i]=rowArr.join("&");
		}
		var xxx=sheetArr.join("&");
		return xxx;s
	} catch(err) { ComFuncErrMsg(err.message); }
}

function f_setMultiCombo(comboObj, index) {
	ComSetMultiCombo(comboObj, index, comboObj.GetSelectCode());
}
 
var selAcctComboIndex, selAcctComboCode;
function acct_cd_OnSelect(comboObj ,index, text , code) {
	selAcctComboIndex = index;
	selAcctComboCode = code;
}

function acct_cd_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selAcctComboIndex, selAcctComboCode);
	addComboItemCost();
	
	var cnt=0;
	var count = parseInt(comboObj.GetItemCount());
	var name = "";
	var isAllText = false;
	for(var i = 1 ; i <  count; i++) {
	   if(comboObj.GetItemCheck(i)) {
	       cnt++;
	       if(comboObj.GetSelectCode().indexOf("ALL") > -1){
	    	   isAllText = true;
	    	   break;
	       }else{
	    	   name = comboObj.GetText(comboObj.GetSelectCode(), 1);
	       }
	   }
	}
	if(isAllText){
		formObj.account_nm.value = "ALL";
	}else{
		if(cnt==1){
			formObj.account_nm.value = name;
		}else{
			formObj.account_nm.value = "";
		}
	}
}

var selCostComboIndex, selCostComboCode;
function cost_cd_OnSelect(comboObj ,index, text , code) {
	selCostComboIndex = index;
	selCostComboCode = code;
}
function cost_cd_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selCostComboIndex, selCostComboCode);
	addComboItemProvider();
	
	var cnt=0;
	var count = parseInt(comboObj.GetItemCount());
	var name = "";
	var isAllText = false;
	for(var i = 1 ; i <  count; i++) {
	   if(comboObj.GetItemCheck(i)) {
	       cnt++;
	       if(comboObj.GetSelectCode().indexOf("ALL") > -1){
	    	   isAllText = true;
	    	   break;
	       }else{
	    	   name = comboObj.GetText(comboObj.GetSelectCode(), 1);
	       }
	   }
	}
	if(isAllText){
		formObj.lgs_cost_nm.value = "ALL";
	}else{
		if(cnt==1){
			formObj.lgs_cost_nm.value = name;
		}else{
			formObj.lgs_cost_nm.value = "";
		}
	}
}

var selVndrComboIndex, selVndrComboCode;
function vndr_seq_OnSelect(comboObj ,index, text , code) {
	selVndrComboIndex = index;
	selVndrComboCode = code;
}

function vndr_seq_OnChange(comboObj , oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	ComSetMultiCombo(comboObj, selVndrComboIndex, selVndrComboCode);
	
	var cnt=0;
	var count = parseInt(comboObj.GetItemCount());
	var name = "";
	var isAllText = false;
	for(var i = 1 ; i <  count; i++) {
	   if(comboObj.GetItemCheck(i)) {
	       cnt++;
	       if(comboObj.GetSelectCode().indexOf("ALL") > -1){
	    	   isAllText = true;
	    	   break;
	       }else{
	    	   name = comboObj.GetText(comboObj.GetSelectCode(), 1);
	       }
	   }
	}
	if(isAllText){
		formObj.vndr_lgl_eng_nm.value = "ALL";
	}else{
		if(cnt==1){
			formObj.vndr_lgl_eng_nm.value = name;
		}else{
			formObj.vndr_lgl_eng_nm.value = "";
		}
	}
}

function searchVslClass(){
	var sheetObj=sheetObjects[5];
	formObj.f_cmd.value=SEARCH03;
	var sParam=FormQueryString(formObj);
	var sXml=sheetObj.GetSearchData("VOP_PSO_0038GS.do", sParam);
	var comboItems1=ComGetEtcData(sXml, "vsl" ).split(ROWMARK); //Account
}

function sheet4_OnSearchEnd(sheetObj, ErrMsg){
	var sheetObj3=sheetObjects[2];
	var sheetObj5=sheetObjects[4];
	
	var acctCd="";
	var vndrSeq="";
	var currCd = "";
	var oPrefix=sheetObj.id + "_";
	var iPrefix=sheetObj5.id + "_";
	var acctCdArr=new Array();
	var currCdArr=new Array();
	var oldAmt=0;
	
	//Line up sheet4 order by acct_cd -> sheet3 : auto Lined up
	sheetObj.ColumnSort(oPrefix + "acct_cd");
	//Getting total value of Invoice Detail(sheet5) per account, Setting that value to Invoice AMT of Tariff Cost Detail(sheet4)
	for(var oRow=sheetObj.HeaderRows(); oRow<sheetObj.HeaderRows()+sheetObj.RowCount(); oRow++){
		acctCd=sheetObj.GetCellValue(oRow, oPrefix + "acct_cd");
		vndrSeq=sheetObj.GetCellValue(oRow, oPrefix + "vndr_seq");
	
		for(var iRow=sheetObj5.HeaderRows(); iRow<sheetObj5.HeaderRows()+sheetObj5.RowCount(); iRow++){
			if(acctCd==sheetObj5.GetCellValue(iRow, iPrefix+"acct_cd") &&
				vndrSeq==sheetObj5.GetCellValue(iRow, iPrefix+"vndr_seq")){
				sheetObj.SetCellValue(oRow, oPrefix+"locl_amt",sheetObj5.GetCellValue(iRow, iPrefix+"inv_total"),0);
				sheetObj.SetCellValue(oRow, oPrefix+"inv_total",sheetObj5.GetCellValue(iRow, iPrefix+"inv_total"),0);
				sheetObj.SetCellValue(oRow, oPrefix+"total_i",sheetObj5.GetCellValue(iRow, iPrefix+"total_i"),0);
				sheetObj.SetCellValue(oRow, oPrefix+"total_o",sheetObj5.GetCellValue(iRow, iPrefix+"total_o"),0);
				break;
			}
		}
	}
	
	//Summarizing Calculated AMT Tariff Cost Detail(sheet4) per account, Getting that value to Tariff Cost of sheet3
	var prefix=sheetObj.id + "_";
	for(var Row=sheetObj.HeaderRows(); Row<=sheetObj.LastRow(); Row++){
		acctCd=sheetObj.GetCellValue(Row, oPrefix + "acct_cd");
		vndrSeq=sheetObj.GetCellValue(Row, oPrefix + "vndr_seq");
		currCd=sheetObj.GetCellValue(Row, oPrefix + "curr_cd");
		var tmpIdxKey = acctCd;
		
		if(document.form.radioflag[0].checked){
			tmpIdxKey = acctCd +","+ currCd;
		}else{
			tmpIdxKey = acctCd +","+ gCurrCdByUSD;
		}		
		
		if(acctCdArr[tmpIdxKey]){
			oldAmt=ComRound(Number(acctCdArr[tmpIdxKey]),2);
		}else{
			oldAmt=0;
		}
		if(document.form.radioflag[0].checked){
			acctCdArr[tmpIdxKey]=ComRound(oldAmt + Number(sheetObj.GetCellValue(Row, prefix+"tariff_amount")),2);
			currCdArr[tmpIdxKey]=sheetObj.GetCellValue(Row, prefix+"curr_cd");
		}else{
			acctCdArr[tmpIdxKey]=ComRound(oldAmt + Number(sheetObj.GetCellValue(Row, prefix+"tariff_usd_amount")),2);
			currCdArr[tmpIdxKey]=gCurrCdByUSD;
		}
	}
	
	prefix=sheetObj3.id + "_";
	sheetObj3.RemoveAll();
	//var tmpCurrCnt = 0;
	//var tmpCurrCd = "";
	for(var Row in acctCdArr){
		var inRow = sheetObj3.DataInsert(-1);
		Row = Row.split(",");
		sheetObj3.SetCellValue(inRow, prefix+"acct_cd"		,Row[0],0);
		sheetObj3.SetCellValue(inRow, prefix+"curr_cd"		,currCdArr[Row],0);
		sheetObj3.SetCellValue(inRow, prefix+"tariff_cost"	,acctCdArr[Row],0);
		
		/*if(tmpCurrCd != currCdArr[Row]){
			tmpCurrCnt++;
		}
		tmpCurrCd = currCdArr[Row];*/
	}
	sheetObj3.ColumnSort("1|2");
	/*if(tmpCurrCnt == 1){
		for(var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++){
			sheetObj3.InitCellProperty(j, prefix + "tariff_cost",{ Type:"AutoSum",Align:"Right",Format:"Float"} );
		}
		sheetObj3.SetSumText(0,prefix+"acct_cd","TOTAL");
	}*/
	checkInOutValue();
}

//in case IN,OUT Select, Changing Invoice AMT of sheet4
function checkInOutValue(){
	var sheetObj=sheetObjects[1];
	var sheetObj4=sheetObjects[3];
	
	var prefix=sheetObj.id + "_";
	var iprefix=sheetObj4.id + "_";
	
	var inValue="";
	var outValue="";
	
	sheetObj.ShowDebugMsg(false);
	for(var j=sheetObj.HeaderRows(); j<sheetObj.HeaderRows()+ sheetObj.RowCount(); j++){
		if(sheetObj.GetCellValue(j, prefix+"obj_list_no")=="77"){
			inValue=sheetObj.GetCellValue(j, prefix+"dflt_val");
		} if(sheetObj.GetCellValue(j, prefix+"obj_list_no")=="89"){
			outValue=sheetObj.GetCellValue(j, prefix+"dflt_val");
		}
	}
	
	if(inValue == "Y" && outValue == "Y"){
		for(var i=sheetObj4.HeaderRows(); i<sheetObj4.HeaderRows()+ sheetObj4.RowCount(); i++){
			sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
		}
	} else if(inValue == "Y" && outValue == "N"){
		for(var i=sheetObj4.HeaderRows(); i<sheetObj4.HeaderRows()+ sheetObj4.RowCount(); i++){
			if(sheetObj4.GetCellValue(i,iprefix+"total_i")>0 && sheetObj4.GetCellValue(i,iprefix+"total_o")>0){
				sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_i"));
			}else{
				sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
			}
		}
	} else if(inValue == "N" && outValue == "Y"){
		for(var i=sheetObj4.HeaderRows(); i<sheetObj4.HeaderRows()+ sheetObj4.RowCount(); i++){
			if(sheetObj4.GetCellValue(i,iprefix+"total_i")>0 && sheetObj4.GetCellValue(i,iprefix+"total_o")>0){
				sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"total_o"));
			} else{
				sheetObj4.SetCellValue(i,iprefix+"locl_amt",sheetObj4.GetCellValue(i,iprefix+"inv_total"));
			}			
		}
	}
}
//in case acct_cd is all, Setting IN & OUT to "Y"
function changeInOut(){
	var formObj=document.form;
	var sheetObj2=sheetObjects[1];
	var prefix="sheet2_";
	sheetObj2.ShowDebugMsg(false);
	//2015.10.16 All 일때 Y 마킹을 무조건 Y로 마킹하도록 수정.
	//if(acct_cd.GetItemCheck(0)){
		for(var i=sheetObj2.HeaderRows(); i<sheetObj2.HeaderRows()+ sheetObj2.RowCount(); i++){
			if(sheetObj2.GetCellValue(i, prefix+"obj_list_no")=="77" || sheetObj2.GetCellValue(i, prefix+"obj_list_no")=="89"){
				sheetObj2.SetCellValue(i, prefix+"dflt_val","Y");
			}
		}
	//}else return false;
}