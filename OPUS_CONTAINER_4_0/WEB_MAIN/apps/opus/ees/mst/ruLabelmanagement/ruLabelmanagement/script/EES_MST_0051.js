/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MST_0051.js
*@FileTitle  : RU Label Attatchment / Detachment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
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

document.onclick=processButtonClick;
/* Branch processing event handler with the name of button */
function processButtonClick(){
	 /***** Adding additional sheet variables to use more than one sheet per a tab *****/
	 var sheetObject=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				sheetObject.RemoveAll();
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn_rowadd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				break;
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
			case 'btn_rowdelete':
				ComRowHideDelete(sheetObject,"ibcheck");
//				if(sheetObject.FindCheckedRow("ibcheck")=="")
//				{
//					ComShowCodeMessage("MST00010");
//				}
//				else if(ComShowCodeConfirm("MST00005")) 
//				{ 
//					doActionIBSheet(sheetObject,formObject,IBDELETE);
//				}
				break;
			case "btn_downexcel" :
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
				}
				break;
			case "btn_loadexcel" :
				doActionIBSheet(sheetObject,formObject,IBLOADEXCEL);
				break;
			case "btn_new":
				sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:1});
				sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:1});
				
				sheetObject.RemoveAll();
				form.reset();
				formObject.s_agmt_cty_cd.value="HHO";
				/*for(var i=1 ; i < comboObjects[0].GetItemCount(); i++ ){
					comboObjects[0].SetItemCheck(i,0);
				}
				comboObjects[0].SetItemCheck(0,1);*/
				comboObjects[0].SetSelectIndex("0")
				
				for(var i=1 ; i < comboObjects[1].GetItemCount(); i++ ){
					comboObjects[1].SetItemCheck(i,0);
				}
				comboObjects[1].SetItemCheck(0,1);
				
				
				for(var i=1 ; i < comboObjects[2].GetItemCount(); i++ ){
					comboObjects[2].SetItemCheck(i,0);
				}
				comboObjects[2].SetItemCheck(0,1);

				for(var i=1 ; i < comboObjects[3].GetItemCount(); i++ ){
					comboObjects[3].SetItemCheck(i,0);
				}
				comboObjects[3].SetItemCheck(0,1);				
				
				var formObj=document.form;    
				comboObjects[0].SetEnable(1);
				comboObjects[1].SetEnable(1);
				formObj.s_cntr_no.className="input2";
				formObj.s_cntr_no.value="";
				formObj.s_cntr_no.readOnly=true;
				comboObjects[0].SetBackColor("#CCFFFA");
				comboObjects[1].SetBackColor("#CCFFFA");
				
				rtv_total="0";
	        	ComBtnDisable("btn_more");
	        	ComBtnEnable("btn_rowadd");
				//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
				break;
			case "btn_history" : //RU Label History
				if (sheetObject.RowCount()!= 0 ) {
					if(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no") != "") {
		                ComOpenWindowCenter("/opuscntr/EES_MST_0052.do?" +
		                		"p_cntr_no=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"cntr_no") +
		                		"&p_ru_type=" + sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),"ru_label_type"), "EES_MST_0052", 840, 570);				
					}
				} else {
	                ComOpenWindowCenter("/opuscntr/EES_MST_0052.do?p_cntr_no=INPUT&p_ru_type=ALL", "EES_MST_0052", 840, 570);									
				}
				break;             	 
			case "btn_popup1": //agmt no
                if (formObject.s_cntr_no.readOnly == false)
                	rep_Multiful_inquiry("s_cntr_no"); 
                break;
			case "btn_Popup":
				openPopup();
				break;
			case "btn_ru_label":
				var strRuLabelTypeValue = comboObjects[0].GetSelectCode(comboObjects[0].GetSelectCode());
				var strRuLabelTypeText = comboObjects[0].GetSelectText(comboObjects[0].GetSelectCode());
				var strTypeModifyYN = "";
				var strTypeSearchYN = "N";
				if(strRuLabelTypeValue == "" || strRuLabelTypeValue == "ALL") {
					//ComShowMessage(ComGetMsg("MST00001", "RU Label Type"));
					//return false;
				}
				strTypeSearchYN = "Y";
				ComOpenPopup('EES_MST_0051_POP.do?rubel_type_value='+strRuLabelTypeValue+'&rubel_type_text='+strRuLabelTypeText+'&type_modify_yn='+strTypeModifyYN+'&type_search_yn='+strTypeSearchYN, 840, 570, 'setPopupChkParam', '1,0', true);		       
				break;
			case "ComOpenPopupWithTarget1":
				ComOpenPopupWithTarget('/opuscntr/EES_MST_0038.do', 600, 580, "lot_no:lot_no|lot_pln_yr:lot_pln_yr|lot_loc_cd:lot_loc_cd|lot_seq:lot_seq|cntr_tpsz_cd:cntr_lot_tpsz_cd", "0,0", true);
				break;
			case "btns_search3": //agmt no
                //if (formObject.f_agmt_no_end.readOnly == false)
					ComOpenPopup('/opuscntr/EES_LSE_0091.do', 805, 470, 'setPopData_Agreement', '1,0', true);		                	
                break;   
			case "btns_agmt_search": //agmt no
                //if (formObject.f_agmt_no_end.readOnly == false)
					ComOpenPopup('/opuscntr/EES_LSE_0091.do?multi_chk=Y', 805, 470, 'setPopData_MultiAgreement', '1,0', true);		
					
                break;   
			case "btn_more":
                doActionIBSheet1(sheetObjects[0], formObject, IBSEARCHAPPEND, appendCondParam, appendPageNo);
                break;
		} // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('COM12111');
		} else {
			ComShowMessage(e.message);
		}
	}
}

/**
 * Pop-up Open<br>
 */
function openPopup() {
	var formObj=document.form;
	var sUrl='/opuscntr/EES_MST_0022_POP.do';
	var iWidth=1250;
	var iHeight=630;
	var sTargetObjList="cntr_spec_no:cntr_spec_no|cntr_tpsz_cd:cntr_tpsz_cd";
	var sDisplay="0,0";
	var ownCntrFlg="";
	ownCntrFlg="Y";	
	/*
	if (formObj.own_cntr_flg[0].checked == true){
		ownCntrFlg="Y";		
		div_dcond1.style.display="inline";
		div_dcond2.style.display="none";		
	}else if (formObj.own_cntr_flg[1].checked == true){
		ownCntrFlg="N";
		div_dcond1.style.display="none";
		div_dcond2.style.display="inline";		
	}*/
	// in case of Term, Tp/Sz, From, To, AGMT, Flag == 1, using on EES_MST_0016.do
	// in case of Flag == 2, using on EES_MST_0021.do
	var param="?own_cntr_flg=" + ownCntrFlg
			+ "&cntr_tpsz_cd=&from_spec_yr=&to_spec_yr=&agmt_no=&active_flag=2";
	ComOpenPopupWithTarget(sUrl + param, iWidth, iHeight, sTargetObjList, sDisplay,true);
	
	
	
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
    	formObj.s_agmt_seq.value = aryPopupData[0][5]; 
    	formObj.s_contract_no.value = aryPopupData[0][9]; 
	}
}
/**
 * Calling rep_commodity pop-up
 */
function rep_Multiful_inquiry(input_obj) {
   	var formObject=document.form;
   	var cmdt_cd_val=""; // 향후 사용가능 예정변수
   	var rep_cmdt_cd_val=""; // 향후 사용가능 예정변수
   	var cmdt_desc_val=""; // 향후 사용가능 예정변수
   	var classId="getLse_Multi";
   	var xx1=input_obj; // CONTI
   	var xx2=""; // SUB CONTI
   	var xx3=""; // COUNTRY
   	var xx4=""; // STATE
   	var xx5=""; // CONTROL OFFIC
   	var xx6=""; // LOC CODE
   	var xx7=""; // LOC NAME
   	var xx8="";
   	var xx9="";
   	var param="?returnval=" + xx1 + "&sconti_cd=" + xx2 + "&cnt_cd=" + xx3
   			+ "&loc_state=" + xx4 + "&loc_eq_ofc=" + xx5 + "&loc_cd=" + xx6
   			+ "&loc_desc=" + xx7 + "&loc_port_ind=" + xx8 + "&iPage=" + xx9;
   	ComOpenPopup('EES_LSE_1002.do' + param, 400, 330, 'getLse_Multi',
   			'1,0');
}
function getLse_Multi(rowArray,ret_val) {
	var formObj=document.form;
	var tempText="";
	//initializing
	formObj.s_cntr_no.value='';
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		tempText +=  rowArray[i] + ',';
	}
	//clearing comma(,)
	tempText=LseDelLastDelim(tempText);
	tempText=tempText.toUpperCase();
	eval("document.form." + ret_val + ".value='" + tempText + "';");
}
/**
    * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
    * 
    * @param {String}
    *            str 제거 대상 String
    * @return {String} str 제거된 String
    * @author 박영진
    * @version 2009.06.04
    */
   function LseDelLastDelim(str) {
   	// 마지막에 &를 없애기 위함
   	if (str != "") {
   		str=str.substr(0, str.length - 1);
   	}
   	return str;
}
/**
 * Register IBSheet Object with array
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
function sheet1_OnLoadFinish(sheetObj) {
	var formObject=document.form; 
	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC01); // Searching RuLabelValueList 
	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC02); // Searching RuLabelValueList 
	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC03); // Searching CNTR TP/SZ
	doActionIBSheet(sheetObj,formObject,IBSEARCH_ASYNC05); // Searching Container Type Size
	comboObjects[0].SetItemCheck(0,1);
	comboObjects[1].SetItemCheck(0,1);
	comboObjects[2].SetItemCheck(0,1);
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
	formObj.s_cntr_no.className="input2";
	formObj.s_cntr_no.value="";
	formObj.s_cntr_no.readOnly=true;
	initControl();	
	nowLoad=0;
	/* IBMultiCombo initailizing */
 	for ( var k=0 ; k < comboObjects.length ; k++ ) {
 		initCombo(comboObjects[k], k+1);
 	}
 	
 	sheet1_OnLoadFinish(sheetObjects[0]);
 	
 	ComBtnDisable("btn_more");
}
/**
 * MultiCombo object initial property //LHS
 * @param comboObj
 * @param comboNo
 * @return
 */
function initCombo (comboObj, comboNo) {
	 switch(comboObj.options.id) {
   	 case "s_ru_label_type":
		with(comboObj) {
   		 	SetBackColor("#CCFFFA");
			SetDropHeight(150);
			SetMultiSelect(0);
			SetUseAutoComplete(1);
			Style=0;
		}
		break;
	case "s_ru_label_value":
		with(comboObj) {
			SetBackColor("#CCFFFA");
			SetDropHeight(150);
			SetMultiSelect(1);
			SetUseAutoComplete(1);
			//MultiSeparator = "";
			Style=0;
		}
		break;
	case "s_tp_cd":
		with(comboObj) {
			SetDropHeight(150);
			SetMultiSelect(1);
			SetUseAutoComplete(1);
			SetMultiSeparator(",");
			Style=0;
		}
		break;
	case "s_cntr_sts_cd":
		with(comboObj) {
			SetDropHeight(150);
			SetMultiSelect(1);
			SetUseAutoComplete(1);
			SetMultiSeparator(",");
			Style=0;
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
	//axon_event.addListenerFormat('blur','obj_blur',formObj);  
}
/**
* handling event in case of Change
*/
function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	switch(obj.name) {
	case "s_agmt_seq":
		if ( formObj.s_agmt_seq.value != null && formObj.s_agmt_seq.value != "" ) {
			doActionIBSheet(sheetObjects[0], formObj, IBSEARCH_ASYNC04);
		} else {
			formObj.s_contract_no.value="";
		}
		break;
	}
}
/**
* handling Location blur event
*/
//function obj_blur(){
//	var obj = event.srcElement;
//	switch(obj.name){
//	
//	case "s_agmt_seq":
//		if ( document.form.s_agmt_seq.value == null || document.form.s_agmt_seq.value == "" ) {
//			document.form.s_contract_no.value = "";
//		}
//		break;
//
//	default:
//		//checking Validation
//	break;
//	}
//}
/**
    * Using English character and number when onkeypress event occurs <br>
 **/
function engnum_keypress() {
   ComKeyOnlyAlphabet('uppernum');
}
/**
 * Validating the data when onblur event occurred <br>
 **/
function obj_blur(){
   return ComChkObjValid(ComGetEvent());
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
				var HeadTitle="STS||Container No.|TPSZ|RU Label Type|RU Label Value|Remark|Create by|Create Date|Update by|Update Date|AGMT No.|Term|Lessor|Lessor Name|Contract No.|Auth No.|Yard|MVMT|MVMT Date|F/M|STS|MFTR|MFTR Name|MFTR Date|RF Maker|RF Maker Name|Reefer Model No.|Cnmv YR|Cnmv Id No|Cnmv Seq|Cnmv Split No|his_ru_label_value" ;
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	             {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",             KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Combo",     Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ru_label_type",       KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
	             {Type:"Popup",     Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ru_label_value",      KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"remark",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cre_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"upd_usr_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"upd_dt",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",   ColMerge:0,   SaveName:"lstm_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"lessor",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    ColMerge:0,   SaveName:"lessor_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",  ColMerge:0,   SaveName:"lse_ctrt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:0,   SaveName:"cntr_auth_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            
	             {Type:"Text",      Hidden:0,  Width:70,  Align:"Center",  ColMerge:0,   SaveName:"crnt_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"full_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,  Align:"Center",  ColMerge:0,   SaveName:"cntr_sts_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,  Align:"Right",  ColMerge:0,   SaveName:"mftr_vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",  ColMerge:0,   SaveName:"mftr_vndr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:80,  Align:"Center",  ColMerge:0,   SaveName:"mft_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,  Align:"Right",  ColMerge:0,   SaveName:"rf_mkr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",  ColMerge:0,   SaveName:"rf_mkr_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",  ColMerge:0,   SaveName:"rf_mdl_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_id_no" },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_seq" },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cnmv_split_no" },
	             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:"his_ru_label_value" } ];
	       
				InitColumns(cols);
				//SetSheetHeight(400);
				resizeSheet();
				SetEditable(1);
				SetColHidden('ibflag',1);
	            SetColHidden('cnmv_yr',1);
	            SetColHidden('cnmv_id_no',1);
	            SetColHidden('cnmv_seq',1);
	            SetColHidden('cnmv_split_no',1);
	            SetColHidden('his_ru_label_value',1);
	            //InitDataValid(0, "cntr_no", {AcceptKeys:"E|N"});
	            SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|N" , InputCaseSensitive:1});
	            SetColProperty('ru_label_type', {ComboText:"|"+s_ru_lable_typeText, ComboCode:"|"+s_ru_lable_typeCode} );
	            InitComboNoMatchText(1,"",1);
	      	}
			break; 
	}
}
function doActionIBSheet(sheetObj,formObj,sAction,value,row) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:1});
			sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:1});
			
			if(validateForm(sheetObj,formObj,sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			/*for (var i=1; i <= sheetObj.RowCount(); i++){
				var strRuLabelValue=sheetObj.GetCellValue(i, "ru_label_value");
		    	sheetObj.SetCellValue(i,"his_ru_label_value",strRuLabelValue);
				alert(sheetObj.GetCellValue(i,"his_ru_label_value"));
		    }*/
			//sheetObj.DoSearch("EES_MST_0051GS.do", FormQueryString(formObj) );
			
			
				//setTimeout( function () {
					rowTotal = 0;
					rtv_total=rowTotal;			
					formObj.pagerows.value = 30000;
					if(Number(rowTotal) > formObj.pagerows.value) {
						ComBtnEnable("btn_more");
					}else{
						ComBtnDisable("btn_more");
					}
					appendPageNo=1;
					appendCondParam = FormQueryString(formObj);	
					sheetObj.DoSearch("EES_MST_0051GS.do",FormQueryString(formObj) );
	 			//} , 100);
			
			}
			break;
			
		case SEARCH04:      //Retrieve
			saveType = "2";
			formObj.f_cmd.value=SEARCH06;
			sheetObj.DoSearch("EES_MST_0051GS.do",FormQueryString(formObj) + "&tmp_seq="+seqValue);
			break;
		case IBSEARCH_ASYNC01:
			/* Lease Term Form Combo Item Setting */
			//sheetObj.WaitImageVisible = false;
			ComSetObjValue(formObj.f_cmd, SEARCH01);
			form.f_cmd.value=SEARCH09;
			var intgCdId='CD20097';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
				var arrStr=sCntrMtrlCdNm.split("@");
				comboObjects[0].RemoveAll();
				comboObjects[0].InsertItem(0, "ALL", "");
				for (var i=0; i<arrStr.length; i++) {
					var arrCode=arrStr[i].split("|");
					comboObjects[0].InsertItem(i+1, arrCode[1] , arrCode[0]);
				}
				comboObjects[0].SetSelectIndex("0" ,false);
			}
			break;
			
	     case IBSEARCH_ASYNC02:
	    	 sheetObj.SetWaitImageVisible(0);
	         form.f_cmd.value=SEARCH02;
	         var sXml=sheetObj.GetSearchData("EES_MST_0051GS.do" , FormQueryString(formObj));
			 var chk=sXml.indexOf("ERROR");
			 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				 sheetObj.LoadSearchData(sXml,{Sync:1} );
				 return;
			 }	             
	         
	         var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
	         var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
	         with (s_ru_label_value) {		        
	        	 InsertItem(0 , 'ALL',''); 
	        	 var t=1;
	        	 for ( var i=1; i<=strRstrUsgTblNm.length; i++) {
        			 InsertItem(t, strRstrUsgTblNm[i-1], strRstrUsgTblNm[i-1]);
        			 t++;
	        	 }		        	 
	         }
	         comboObjects[1].SetItemCheck(0,1);
	         break;
	         
	     case IBSEARCH_ASYNC03:
	    	 sheetObj.SetWaitImageVisible(0);
	         form.f_cmd.value=SEARCH02;
	         var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do" , FormQueryString(formObj));
			 var chk=sXml.indexOf("ERROR");
			 if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				 sheetObj.LoadSearchData(sXml,{Sync:1} );
				 return;
			 }	             
	         //TP/SZ retrieve
	         var cntr_tpsz_cd=ComGetEtcData(sXml,"cntr_tpsz_cd");
	         tot_cntr_tpsz_cd=cntr_tpsz_cd;
	         var strCntrTpszCd=cntr_tpsz_cd.split("|");
	         with (s_tp_cd) {		        
	        	 InsertItem(0 , 'ALL','ALL'); 
	        	 var t=1;
	        	 for ( var i=1; i<=cntr_tpsz_cd.split("|").length; i++) {
	        		 //if (strCntrTpszCd[i-1].substring(0,1)=="R"){ 
	        			 InsertItem(t, strCntrTpszCd[i-1], strCntrTpszCd[i-1]);
	        			 t++;
	        		 //}
	        	 }		        	 
	         }
	         break;
	         
		case IBSEARCH_ASYNC04:
			formObj.f_cmd.value=SEARCH05;
			var param="&agmt_seq=" + formObj.s_agmt_seq.value;
			var sXml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=sXml.indexOf("ERROR");
			if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
				 sheetObj.LoadSearchData(sXml,{Sync:1} );
				 return;
			 }            	
        	formObj.s_contract_no.value=ComXmlString(sXml, "vndr_lgl_eng_nm");
        	break;
		case IBSEARCH_ASYNC05:
			/* Lease Term Form Combo Item Setting */
			//sheetObj.WaitImageVisible = false;
			ComSetObjValue(formObj.f_cmd, SEARCH01);
			form.f_cmd.value=SEARCH09;
			var intgCdId='CD30097';
			var param="&intgCdId="+intgCdId;
			var xml=sheetObj.GetSearchData("EES_MST_COMGS.do", FormQueryString(formObj)+param);
			var chk=xml.indexOf("ERROR");
			if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
			   sheetObj.LoadSearchData(xml,{Sync:1} );
			   return;
		    } 
			if (xml != "") {
				var sCntrStsCd=ComGetEtcData(xml, "code_nm");
				var arrStr=sCntrStsCd.split("@");
				comboObjects[3].RemoveAll();
				comboObjects[3].InsertItem(0, "ALL", "ALL");
				for (var i=0; i<arrStr.length; i++) {
					var arrCode=arrStr[i].split("|");
					comboObjects[3].InsertItem(i+1, arrCode[1] , arrCode[0]);
				}
				comboObjects[3].SetSelectIndex("0" ,false);
			}
			break;      	
	     case SEARCH01:
	    	 if (validateForm(sheetObj, formObj, sAction)){
	    		 sheetObj.SetCellValue(row, "cntr_tpsz_cd","");
				 sheetObj.SetCellValue(row, "agmt_no","");
				 sheetObj.SetCellValue(row, "lstm_cd", "");
				 sheetObj.SetCellValue(row, "lessor","");
		 		 sheetObj.SetCellValue(row, "lessor_nm","");
		 		 sheetObj.SetCellValue(row, "cntr_auth_no","");
		 		
		 		 sheetObj.SetCellValue(row, "lse_ctrt_no","");
		 		 sheetObj.SetCellValue(row, "crnt_yd_cd","");
		 		 sheetObj.SetCellValue(row, "cnmv_sts_cd","");
		 		 sheetObj.SetCellValue(row, "cnmv_dt","");
		 		 sheetObj.SetCellValue(row, "full_flg","");
		 		 sheetObj.SetCellValue(row, "cntr_sts_cd","");
		 		 sheetObj.SetCellValue(row, "mftr_vndr_seq","");
		 	     sheetObj.SetCellValue(row, "mftr_vndr_nm","");
		 	 	 sheetObj.SetCellValue(row, "mft_dt","");
		 		 sheetObj.SetCellValue(row, "rf_mkr_seq","");
		 		 sheetObj.SetCellValue(row, "rf_mkr_nm","");
		 		 sheetObj.SetCellValue(row, "rf_mdl_nm","");
			 		
	    		ComOpenWait(true);
	 			formObj.f_cmd.value=SEARCH01;
	 			var sXml=sheetObj.GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+"&cntr_no=" + value);
	 			ComOpenWait(false);
				sheetObj.SetCellValue(row, "cntr_tpsz_cd",ComGetEtcData(sXml, "cntr_tpsz_cd"));
				sheetObj.SetCellValue(row, "agmt_no",ComGetEtcData(sXml, "agmt_no"));
				sheetObj.SetCellValue(row, "lstm_cd",ComGetEtcData(sXml, "lstm_cd"));
				sheetObj.SetCellValue(row, "lessor",ComGetEtcData(sXml, "lessor"));
		 		sheetObj.SetCellValue(row, "lessor_nm",ComGetEtcData(sXml, "lessor_nm"));
		 		sheetObj.SetCellValue(row, "cntr_auth_no",ComGetEtcData(sXml, "cntr_auth_no"));
		 		
		 		sheetObj.SetCellValue(row, "lse_ctrt_no",ComGetEtcData(sXml, "lse_ctrt_no"));
		 		sheetObj.SetCellValue(row, "crnt_yd_cd",ComGetEtcData(sXml, "crnt_yd_cd"));
		 		sheetObj.SetCellValue(row, "cnmv_sts_cd",ComGetEtcData(sXml, "cnmv_sts_cd"));
		 		sheetObj.SetCellValue(row, "cnmv_dt",ComGetEtcData(sXml, "cnmv_dt"));
		 		sheetObj.SetCellValue(row, "full_flg",ComGetEtcData(sXml, "full_flg"));
		 		sheetObj.SetCellValue(row, "cntr_sts_cd",ComGetEtcData(sXml, "cntr_sts_cd"));
		 		sheetObj.SetCellValue(row, "mftr_vndr_seq",ComGetEtcData(sXml, "mftr_vndr_seq"));
		 		sheetObj.SetCellValue(row, "mftr_vndr_nm",ComGetEtcData(sXml, "mftr_vndr_nm"));
		 		sheetObj.SetCellValue(row, "mft_dt",ComGetEtcData(sXml, "mft_dt"));
		 		sheetObj.SetCellValue(row, "rf_mkr_seq",ComGetEtcData(sXml, "rf_mkr_seq"));
		 		sheetObj.SetCellValue(row, "rf_mkr_nm",ComGetEtcData(sXml, "rf_mkr_nm"));
		 		sheetObj.SetCellValue(row, "rf_mdl_nm",ComGetEtcData(sXml, "rf_mdl_nm"));	 		
	    	 }
	    	 break;
	    	 
	 	case SEARCH03: //Cntr RuLabel Check
	 		/* 최신화 시키는 것으로 처리하기 위하여 Validation 체크 제외
			formObj.f_cmd.value=SEARCH03;
				//parameter changed[check again]CLT var sXml=sheetObj.GetSaveData("EES_MST_0051GS.do", FormQueryString(formObj) + "&cntr_no=" + sheetObj.GetCellValue(row, "cntr_no") + "&ru_label_type=" + value);
				var chkRuLabel=ComGetEtcData(sXml, "check_rulabel_type"); //X-사용가능
				if(chkRuLabel == "X"){
				ComShowCodeMessage("MST02035", sheetObj.GetCellValue(row, "cntr_no"));
				sheetObj.SetCellValue(row, "ru_label_type","",0);
				sheetObj.SetCellValue(row, "ru_label_value","",0);
				//return false;
			}
			*/
			break;
			
		case IBSAVE:
			//sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:1});
			//sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:1});
			
			if(document.getElementById("btn_rowadd").disabled == false) {
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				
				for (var i=0; i < sheetObj.RowCount(); i++){
					if (sheetObj.GetRowStatus(i+1) != "R"){
						if(sheetObj.GetCellValue(i+1,"cntr_tpsz_cd") == "") {
							sheetObj.SelectCell(i+1, "cntr_no");
							ComShowCodeMessage('MST02026');
							return false;
						}
					}
			    }	
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			saveType = "1";
			var xml = sheetObj.DoSave("EES_MST_0051GS.do", FormQueryString(formObj));			
			if(xml == false) {
				ComOpenWait(false);
			}
			break;
			
		case IBINSERT:      // Insert
			sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:1});
			sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:1});
			sheetObj.DataInsert(-1);
			var row=sheetObj.GetSelectRow();
			sheetObj.SetCellValue(row, 'cre_usr_id'     ,formObj.f_cre_usr_id.value,0);
			sheetObj.SetCellValue(row, 'upd_usr_id'     ,formObj.f_cre_usr_id.value,0);
			var toDay=getCurrentTimeToDateFormat();
			sheetObj.SetCellValue(row, 'cre_dt'     ,toDay,0);
			sheetObj.SetCellValue(row, 'upd_dt'     ,toDay,0);
			sheetObj.SelectCell(row, "cntr_no");
			sheetObj.SetCellValue(row, "ru_label_type","",0);
			//sheetObj.SetCellValue(row, "ru_label_value","",0);
			sheetObj.CellComboItem(row,"ru_label_value", {ComboText:" ", ComboCode:" "} );
			break;
			
//		case IBDELETE:
//			var checkList = sheetObj.FindCheckedRow('ibcheck');
//			if(checkList == ''){
//				ComShowCodeMessage('COM12176');
//				return false;
//			}
//			
//			var checkArray = checkList.split('|');
//			for(var k=checkArray.length-2; k>=0; k--) {
//				if(sheetObj.RowStatus(checkArray[k]) == 'I')
//					sheetObj.RowDelete(checkArray[k], false);
//			}
//			checkList = sheetObj.FindCheckedRow('ibcheck');
//			var checkArray = checkList.split('|');
//			if(checkList== '') return false;
//			if(checkArray.length > 0) {
//				for(var d=0; d<checkArray.length-1; d++){
//					var delIdx = checkArray[d];
//					sheetObj.CellValue(delIdx, 'ibflag')= "D";
//				}
//			}
//			//var queryStr = sheetObj.GetSaveString(false, false, "ibcheck");
//			formObj.f_cmd.value = MULTI;
//			sheetObj.DoSave("EES_MST_0051GS.do",FormQueryString(formObj),'ibcheck',false);
//
//			for(var k=checkArray.length-2; k>=0; k--)
//			{
//				sheetObj.RowDelete(checkArray[k], false);
//			}
//			break;
		case IBDOWNEXCEL:        //Excel Download
			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			break;
		case IBLOADEXCEL:
			sheetObjects[0].SetWaitImageVisible(1);
			
			sheetObjects[0].RemoveAll(); 
        	if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
        	}
        	//EXCEL_LOAD_FLG = sheetObj.LoadExcel();
        	EXCEL_LOAD_FLG = sheetObj.LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",StartRow:"1",EndRow:"0",WorkSheetName:"",Append:false});
        	
        	sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:0});
			sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:0});
    		//doActionIBSheet(sheetObj, document.form, SEARCH01, value, row);
        	
        	// Button Control
     		//toggleButtons("LOAD");		
			break;
	}
}


/**
 * registering IBsheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */


function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	  var formObj = document.form;
	  if(isExceedMaxRow(msg)) return; 
	  if(result) {
		  var arrCntrNo = "";
        	sheetObj.CheckAll("ibcheck",0);
        	//  because n1st_cmnc_amdt_seq data is not exists at excel file to upload
    		//changeSelectBackColor(sheetObj, document.form.amdt_seq.value, document.form.amdt_seq.value);
    		// When ComboBox checked 
    		//sheetObj.RenderSheet(0);
        	//ComOpenWait(false);
        	for ( var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
        		//after LoadExel, it is searched by Cntr`s info automatically 
        		
        		if (sheetObj.GetCellValue(i, "cntr_no") == ""
     					&& ComTrim(sheetObj.GetCellText(i, "cntr_no")) != "") {
     				sheetObj.SetCellValue(i, "cntr_no",sheetObj.GetCellText(i, "cntr_no"));
     			}
        		if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == ""
     					&& ComTrim(sheetObj.GetCellText(i, "cntr_tpsz_cd")) != "") {
     				sheetObj.SetCellValue(i, "cntr_tpsz_cd",sheetObj.GetCellText(i, "cntr_tpsz_cd"));
     			}
        		if (sheetObj.GetCellValue(i, "agmt_no") == ""
     					&& ComTrim(sheetObj.GetCellText(i, "agmt_no")) != "") {
     				sheetObj.SetCellValue(i, "agmt_no",sheetObj.GetCellText(i, "agmt_no"));
     			}
        		if (sheetObj.GetCellValue(i, "lstm_cd") == ""
 					&& ComTrim(sheetObj.GetCellText(i, "lstm_cd")) != "") {
 			     	sheetObj.SetCellValue(i, "lstm_cd",sheetObj.GetCellText(i, "lstm_cd"));
 			    }        		
        		if (sheetObj.GetCellValue(i, "lessor") == ""
     					&& ComTrim(sheetObj.GetCellText(i, "lessor")) != "") {
     				sheetObj.SetCellValue(i, "lessor",sheetObj.GetCellText(i, "lessor"));
     			}
        		
        		/*if(sheetObj.GetCellValue(i, "ru_label_type") != ""){
     				var strRuLabelValue=sheetObj.GetCellText(i, "ru_label_value");
     				cellSetItems(sheetObj, i, sheetObj.SaveNameCol("ru_label_value"), sheetObj.GetCellValue(i, "ru_label_type"));
     				sheetObj.SetCellValue(i, "ru_label_value",strRuLabelValue);
     			}*/
        		
        		/*if(sheetObj.GetCellValue(i,"cntr_no").trim().length != 11){
        			ComShowCodeMessage('MST01019','CNTR NO.');
        			return false;
        		}*/
        	}
        	//ComOpenWait(true);
			sheetObjects[0].SetRowStatus(i,"I");
 			formObj.f_cmd.value=MULTI01;
 			var SaveStr=ComGetSaveString(sheetObjects[0], true, true); 
 			saveType = "2";
 			sXml=sheetObjects[0].GetSaveData("EES_MST_0051GS.do", SaveStr + "&" + FormQueryString(formObj));
 			seqValue=ComGetEtcData(sXml, "seqValue");
 			sheetObjects[0].LoadSaveData(sXml);
 			sheetObjects[0].RemoveAll(); 
      	}else{
      		initVariable();
      	}
	  sheetObjects[0].SetWaitImageVisible(0);
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
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSAVE:
			var Cnt = sheetObj.RowCount();
	    	for(var i=1; i<=Cnt; i++){
	    		if (sheetObj.GetRowStatus(i) != "R"){
					if(sheetObj.GetCellValue(i,"cntr_no").trim().length != 11){
						ComShowCodeMessage("MST00001", "cntr_no");
						sheetObj.SelectCell(i,"cntr_no", false)
						return false;
					}	
					
					if(sheetObj.GetCellValue(i,"ru_label_type").trim() == ""){
						ComShowCodeMessage("MST00001", "RU Label Type");
						sheetObj.SelectCell(i,"ru_label_type", false)
						return false;
					}	
					
					if(sheetObj.GetCellValue(i,"ru_label_value").trim() == ""){
						ComShowCodeMessage("MST00001", "RU Label Value");
						sheetObj.SelectCell(i,"ru_label_value", false)
						return false;
					}	
					
					var Row = sheetObj.ColValueDup("cntr_no|ru_label_type|ru_label_value", false);
					if( Row != -1){
					 ComShowCodeMessage("MST02035", sheetObj.GetCellValue(Row, "cntr_no"));
					 sheetObj.SetCellValue(Row, "ru_label_value")
					 return false;
					}
	    		}
			}
			
			break;
		
		case IBSEARCH:
			if($("input:radio[id='f_r_check2']").is(":checked") == true) {
				if(form.s_cntr_no.value == "") {
					ComShowCodeMessage("MST02036");
					form.s_cntr_no.focus();
					return false;
				}
			}
			break;
	}	
	return true;
}


function sheet1_OnChange(sheetObj, row, col, value){
	var sName=sheetObj.ColSaveName(col);
	if(sName == "cntr_no"){	
		if(value.length == 11){		
			doActionIBSheet(sheetObj, document.form, SEARCH01, value, row);
		}
	} else if(sName == "ru_label_type"){
		if(sheetObj.GetCellValue(row, "ru_label_type") != ""){
			//cellSetItems(sheetObj, row, sheetObj.SaveNameCol("ru_label_value"), value);
			sheetObj.SetCellValue(row, "ru_label_value","");
		}
		if(sheetObj.GetCellValue(row, "cntr_no") != "" && sheetObj.GetCellValue(row, "ru_label_type") != "" ){
			doActionIBSheet(sheetObj, document.form, SEARCH03, value, row);
		}
	} else if(sName == "ru_label_value"){
		if(sheetObj.GetCellValue(row, "cntr_no") != "" && sheetObj.GetCellValue(row, "ru_label_type") != "" && sheetObj.GetCellValue(row, "ru_label_value") == ""){
			doActionIBSheet(sheetObj, document.form, SEARCH03, value, row);
		}
		
		if(sheetObj.GetCellValue(row, "ru_label_value") != "") {
			var formObj = document.form;
			var strRLvalue = sheetObj.GetCellValue(row, "ru_label_value");
			var strRLtype = sheetObj.GetCellValue(row, "ru_label_type");
			formObj.f_cmd.value=SEARCH;
			var xml="";					
 			xml=sheetObj.GetSearchData("EES_MST_0050GS.do", "ru_label_type="+strRLtype+"&ru_label_value="+strRLvalue+"&"+FormQueryString(formObj));
 			var intTotal = parseInt(ComGetTotalRows(xml)); 			
 			if(intTotal == 0) {
 				sheetObj.SetCellValue(row, "ru_label_value","");
 			}
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
	var formObject = document.form;
	with(sheetObj) {
		var sName = sheetObj.ColSaveName(Col);
		switch(sName) {
		case "ru_label_value":
			var strRuLabelTypeValue = sheetObj.GetCellValue(Row,"ru_label_type");
			var strRuLabelTypeText = sheetObj.GetCellText(Row,"ru_label_type");
			//var strCellType = sheetObj.GetCellProperty(Row, "ru_label_type", "Type");
			var strCellType = sheetObj.GetCellValue(Row,"ibflag");
			var strTypeModifyYN = "N";
			if(strCellType == "I") {
				if(strRuLabelTypeValue == "") {
					ComShowMessage(ComGetMsg("MST00001", "RU Label Type"));
					return false;
				}
				strTypeModifyYN = "Y";
			}
			ComOpenPopup('EES_MST_0051_POP.do?rubel_type_value='+strRuLabelTypeValue+'&rubel_type_text='+strRuLabelTypeText+'&type_modify_yn='+strTypeModifyYN, 840, 570, 'setPopupParam', '0,0', true, false, Row, Col, 0);
			break;
		}
	}
}


function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj=document.form; 
	var lstTotal = sheetObj.GetEtcData("rtv_total");
	ComBtnEnable("btn_rowadd");
	if (sheetObj.RowCount()< lstTotal) {
        // setting page number for APPEND retrieving
        appendPageNo=Math.ceil(sheetObj.RowCount()/ formObj.pagerows.value) + 1;
        ComBtnEnable("btn_more");
    } else {
    	appendPageNo = 1;
        ComBtnDisable("btn_more");
    }
	if(saveType == "2") {
		if(sheetObj.RowCount()> 0) {
			ComBtnDisable("btn_rowadd");
			for ( var i=sheetObj.HeaderRows(); sheetObj.RowCount()> 0 && i <= sheetObj.LastRow(); i++) {
				sheetObjects[0].SetRowStatus(i,"I");
			}
		}else{
			ComBtnEnable("btn_rowadd");
		}
	}
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);  
	
 }


function sheet1_OnSaveEnd(sheetObj , ErrMsg) { 
	var formObject=document.form; 
	if(saveType == "1") {
		ComShowCodeMessage("COM130102", 'RU Label Attachment / Detachment');
		//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
	}else{
		sheetObjects[0].SetColProperty(0 ,"ru_label_type" , {KeyField:1});
		sheetObjects[0].SetColProperty(0 ,"ru_label_value" , {KeyField:1});
		
		doActionIBSheet(sheetObjects[0], formObject, SEARCH04);
	}
	ComOpenWait(false);
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
 * handling process for Sheet
 */    
function doActionIBSheet1(sheetObj, formObj, sAction, CondParam, PageNo) {
	switch(sAction) {
	case IBSEARCHAPPEND:
		if(!validateForm(sheetObj,formObj,sAction)) return;
        sheetObj.SetWaitImageVisible(0);
        ComOpenWait(true);
        //setTimeout( function () {	        	
			sheetObj.SetWaitImageVisible(0);	
			sheetObj.DoSearch("EES_MST_0051GS.do", CondParam+"&"+ "iPage="+ appendPageNo,{Append:true} );  	   
		//	} , 100);
        
		break;
	}
}


/**
 * in case of onChange combo event
 * @param comboObj
 * @param Index_Code
 * @param Text
 * @return
 */
function s_ru_label_type_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod){
	if(nowLoad == 0){
		comboOnChange(comboObj, comboObjects[0].GetSelectCode(), comboObjects[0].GetSelectText(comboObjects[0].GetSelectCode()));
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
	comboObjects[1].RemoveAll();
	sheetObjects[0].SetWaitImageVisible(0);
    form.f_cmd.value=SEARCH02;
    var ruLabelType=Index_Code;
	var param="&ru_label_type="+ruLabelType;
	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
	var chk=sXml.indexOf("ERROR");
	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
		sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
		return;
	}	             
	formObj.s_ru_label_text.value = "";
    var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
    s_ru_label_value.InsertItem(0, "ALL" , "ALL");
    if(rstr_usg_tblnm != "") {
    	var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
    	with (s_ru_label_value) {
   	 		var t=1;
   	 		for ( var i=1; i<=strRstrUsgTblNm.length; i++) {
   	 			InsertItem(t, strRstrUsgTblNm[i-1], strRstrUsgTblNm[i-1]);
			 t++;
   	 		}		        	 
    	}
    	//sheetObjects[0].RemoveAll(); 
    }
    comboObjects[1].SetItemCheck(0,1);
} 


/**
 * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
 * @return
 */
function s_ru_label_value_OnCheckClick(comboObj, index, code) {
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
 * MultiSelect속성을 이용하는 경우, checking박스를 클릭하는 순간 발생한다.
 * @return
 */
function s_tp_cd_OnCheckClick(comboObj, index, code) {
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
 * handling click event on sheet1.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet1_OnClick(sheetObj, Row, Col, Value){
	if(sheetObj.ColSaveName(Col) == "ru_label_value"){
		if(sheetObj.GetCellValue(Row, "ru_label_type") == "") {
			sheetObj.SetCellValue(Row, "ru_label_value"," ",0);
		}
		if(sheetObj.GetCellValue(Row, "ru_label_type") != ""){
			//doActionIBSheet(sheetObj, document.form, SEARCH03, Value, Row);
			//cellSetItems(sheetObj, Row, sheetObjects[0].SaveNameCol("ru_label_value"), sheetObj.GetCellValue(Row, sheetObjects[0].SaveNameCol("ru_label_type")));
		}
	}
	
	if(sheetObj.ColSaveName(Col) == "ru_label_type"){
		sheetObjects[0].CellComboItem(Row,"ru_label_type", {ComboText:"|"+s_ru_lable_typeText, ComboCode:"|"+s_ru_lable_typeCode} );
	}
}
/**
 * setting combo of operation office.
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function cellSetItems(sheetObj, Row, Col, Value){
	//alert(sheetObj + " :: "+ Row + " :: "+ Col + " :: "+ Value);
	var formObj=document.form;
	sheetObjects[0].SetWaitImageVisible(0);
    form.f_cmd.value=SEARCH02;
    var ruLabelType=Value;
	var param="&ru_label_type="+ruLabelType;
	var sXml=sheetObjects[0].GetSearchData("EES_MST_0051GS.do", FormQueryString(formObj)+param);
	var chk=sXml.indexOf("ERROR");
	if (sXml.indexOf("ERROR") != -1 || sXml.indexOf("Error") != -1){
		 sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
		 return;
	}	             
	sheetObjects[0].SetWaitImageVisible(1);
    var rstr_usg_tblnm=ComGetEtcData(sXml,"rstr_usg_tblnm");
    if(rstr_usg_tblnm != ""){
		var TblNmList="";
		var strRstrUsgTblNm=rstr_usg_tblnm.split("@");
		var strFCode = "";
		for(var i=0; i < strRstrUsgTblNm.length;i++){
			if(i==0) {
				strFCode=strRstrUsgTblNm[i];
			}
			var code=strRstrUsgTblNm[i];
			TblNmList=TblNmList + code + "|";
		}
		TblNmList=TblNmList.substring(0, TblNmList.length - 1);
		sheetObjects[0].CellComboItem(Row,Col, {ComboText:TblNmList, ComboCode:TblNmList} );
		sheetObjects[0].SetCellValue(Row,Col,strFCode);
	}else{
		sheetObjects[0].SetCellValue(Row,Col,"");
		sheetObjects[0].CellComboItem(Row,Col, {ComboText:" ", ComboCode:" "} );
	}
}
function chk_SearchType(TypeNum) {
	var formObj=document.form;
	if(TypeNum == "1") {
		comboObjects[0].SetEnable(1);
		comboObjects[1].SetEnable(1);
		formObj.s_cntr_no.className="input2";
		formObj.s_cntr_no.value="";
		formObj.s_cntr_no.readOnly=true;
		formObj.s_agmt_seq.value="";
		formObj.s_contract_no.value="";
	}else{
		comboObjects[0].SetEnable(0);
		comboObjects[1].SetEnable(0);
		formObj.s_cntr_no.className="input1";
		formObj.s_cntr_no.value="";
		formObj.s_cntr_no.readOnly=false;
		
		comboObjects[0].SetSelectIndex("0")
		
		comboObjects[1].SetItemCheck(0,1);
		comboObjects[2].SetItemCheck(0,1);
		for(var i=1 ; i < comboObjects[1].GetItemCount() ; i++) {
			comboObjects[1].SetItemCheck(i,0);
		}
		
		for(var i=1 ; i < comboObjects[2].GetItemCount() ; i++) {
			comboObjects[2].SetItemCheck(i,0);
		}
		
		
	}
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
	sheetObj.SetCellValue( Row, "ru_label_type", arr[1], 0);
	sheetObj.SetCellValue( Row, Col, arr[2], 0);
}


function setPopupChkParam(rowArray) {
	form.s_ru_label_text.value = "";
	form.s_ru_label_text.value = rowArray;
	
	var comboCnt = comboObjects[1].GetItemCount();
	comboObjects[1].SetItemCheck(0,1);
	for(var i=1;i<comboCnt;i++) {
		if(rowArray.indexOf(comboObjects[1].GetText(i,0)) >= 0) {
			comboObjects[1].SetItemCheck(i,1);
		}
	}
}


function setPopData_MultiAgreement(rowArray) {
	form.s_multi_agmt_seq.value = "";
	form.s_multi_agmt_seq.value = rowArray;
	
	
}

function resizeSheet() {
	ComResizeSheet(sheetObjects[0]);
}
