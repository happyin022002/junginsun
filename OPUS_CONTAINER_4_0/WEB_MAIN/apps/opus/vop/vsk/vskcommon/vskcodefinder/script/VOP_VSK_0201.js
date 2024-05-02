/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :VOP_VSK_0201.js
*@FileTitle  : Simulation No. Help
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================*/
 // public variable
 var sheetObjects=new Array();
 var sheetCnt=0;
 var simData=new Object();
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
// Event handler processing by button name */
 function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	  /*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if (!ComIsBtnEnable(srcName)) return;  
	 switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_new":
			clearAllData(sheetObject1,formObject);
			break;
		case "btn_Select":
			var cnt=sheetObject1.RowCount();
			if(cnt > 0){
				var simTemp=sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "sheet1_simul_no");
				if(simTemp != ""){
					simTemp=ComReplaceStr(simTemp,"-","");
					simData.sim_dt=simTemp.substring(0,8);
					simData.sim_no=simTemp.substring(8);
					//window.returnValue=simData;
					//comPopupOK();
					ComPopUpReturnValue(simData);
				}
			}else{
				ComShowCodeMessage("VSK00043");
				return;
			}
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btns_search":
			openLandCdHelp(sheetObject1);
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
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
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
     initControl();
 	 document.form.vsl_slan_cd.focus();
 }
 /**
  * registering initial event
  */
 function initControl() {
	var formObj=document.form;
// 	axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
// 	axon_event.addListenerFormat  ('keyup', 'obj_change' , form);
// 	axon_event.addListenerFormat  ('keyup', 'obj_keyup' , form);
	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}
function obj_focus() {
	if(event.srcElement.options){
//		event.srcElement.focus();
	}else{
//		event.srcElement.select();
	}
}
 /**
  * Handling key press event
  */
 /**
  * Handling key up event
  *//*
   * setting sheet initial values and header
   * param : sheetObj, sheetNo
   * adding case as numbers of counting sheets
   */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
         case 1:      // sheet1 init
             with (sheetObj) {
             var HeadTitle="|Seq.|Lane|Lane Name|Simulation No.|Created Date|Remark(s)|";
             var prefix="sheet1_";

             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

             var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
             var headers = [ { Text:HeadTitle, Align:"Center"} ];
             InitHeaders(headers, info);

             var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Text",      Hidden:0,  Width:220,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"simul_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"pf_skd_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
              {Type:"Text",      Hidden:1, Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"uiflg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             InitColumns(cols);
             SetEditable(0);
             SetWaitImageVisible(0);
             SetColProperty(prefix+"cre_dt", {Format:"####-##-####:##"} );
             SetSheetHeight(320);
		   }
             break;
     }
 }
   // handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
//     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //Retrieve
        	if(validateForm(sheetObj,formObj,sAction)){
        		//formObj.f_cmd.value = SEARCH;
        		ComOpenWait(true);
        		formObj.f_cmd.value=COMMAND20;
        		sheetObj.DoSearch("VOP_VSK_0201GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_") );
        		ComOpenWait(false);
        	}
             break;
        case SEARCH02:
			//formObj.f_cmd.value = SEARCH02;
        	//ComOpenWait(true);
        	formObj.f_cmd.value=COMMAND12;
			var sParam=FormQueryString(formObj);
			//var sXml = sheetObj.GetSearchXml("VOP_VSK_0202GS.do?op_=0202", sParam);
			var sXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do", sParam);
			//ComOpenWait(false);
			var checkLane=ComGetEtcData(sXml, "checkLane");
			if(checkLane == undefined){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				formObj.vsl_slan_cd.value="";	
//				formObj.vsl_slan_cd.focus();
			}else{
				var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
//				formObj.vsl_slan_cd.focus();
			}
		break;
		case IBINSERT:      // input
             break;
     }
 }
 /**
  * Initializing screen
  * @param sheetObj
  * @param formObj
  * @return
  */
 function clearAllData(sheetObj1,formObj){
 	formObj.vsl_slan_cd.value=""; 	
 	sheetObj1.RemoveAll();
 }
 /**
  * Open Lane Code Help
  */
 function openLandCdHelp(sheetObj){
    var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display="0,0";
    var vsl_slan_cd=document.form.vsl_slan_cd.value;
 	//ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+vsl_slan_cd, 450, 470, targetObjList, v_display, true);
    ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+vsl_slan_cd, 500, 470, "getLaneCd", "0,0", true);
 }
 
 /**
  * 
  * @param rtnVal
  */
 function getLaneCd( rtnVal ){
	 
	 var formObj=document.form;
	 
	 if( rtnVal != ""){
		 formObj.vsl_slan_cd.value= rtnVal;
	 }
 }
 
 /**
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
 	switch(sAction) {
 		case IBSEARCH:      //Retrieve
 			if(ComIsNull(document.getElementById("vsl_slan_cd").value)){
 				ComShowCodeMessage('VSK00027', "Lane Code");
// 				formObj.vsl_slan_cd.focus();
 				return false;
 			}
 			if(formObj.vsl_slan_cd.value.length <3){
 				ComShowCodeMessage('VSK00027', "Lane Code");
// 				formObj.vsl_slan_cd.focus();
 				return false;
 			}
 			break;
 	}
     return true;
 /**
  * Handling enter key
  * @param sheetObj
  * @param formObj
  * @return
  */
 	var formObject=document.form;
 	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
 }
 /**
  * Returning to parent screen
  */
 function sheet1_OnDblClick(sheetObj, Row, Col) {
var simTemp=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_simul_no");
		if(simTemp != ""){
			simTemp=ComReplaceStr(simTemp,"-","");
			simData.sim_dt=simTemp.substring(0,8);
			simData.sim_no=simTemp.substring(8);
			//window.returnValue=simData;
			//comPopupOK();
			ComPopUpReturnValue(simData);
		}
 }
 
 