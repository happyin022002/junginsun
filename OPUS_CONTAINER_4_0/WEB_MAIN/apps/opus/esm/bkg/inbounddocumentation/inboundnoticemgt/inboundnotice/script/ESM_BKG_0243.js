/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0243
*@FileTitle  : Arrival Info. Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
                    [modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
                    character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @fileoverview business script for
 * @author
 */
/**
 * @extends
 * @class esm_bkg_0243 : esm_bkg_0243 
 */
   /* Start of developer's work*/
//global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
 function processButtonClick(){
      /***** using extra sheet valuable if there are more 2 sheets *****/
      /*******************************************************/
      var formObj=document.form;
 	//try {
 		var srcName=ComGetEvent("name");
         switch(srcName) {
				case "btn_set":
					alert("btn_set");
				break;
				case "btn_close":
					//aa.innerText = "asdfasdfasdfasdfasdfasdfasdf";
					ComClosePopup(); 
				break;
				case "btn_setup_arrival_info"://saving Setup Arrival Info
					// inserting data to One window of opener
					fncSetup();
				break;
//				case "btn_mnr_rtn_yard_setup"://MNR RTN Yard Setup pop up
//					fncT2CustomerInfoClick(formObj.vvd.value);
//				break;
         } // end switch
 }
 function loadPage(){
	 var formObj=document.form;
	 for(i=0;i<sheetObjects.length;i++){
	            ComConfigSheet (sheetObjects[i] );
	            initSheet(sheetObjects[i],i+1);
	            ComEndConfigSheet(sheetObjects[i]);
	  }
	 initControl();

//	 if(OfficeCodeMgr.checkContainOfficeCode("000004", "BKG", strOfc_cd)
//		 || OfficeCodeMgr.checkContainOfficeCode("000005", "BKG", strOfc_cd)
//	    ) {
//		ComBtnEnable("btn_mnr_rtn_yard_setup");
//		//<8.10>in case Log-In ID is ANRBS(TES_ANRBS), deactivating [Empty Return CY]
//		formObj.rtn_yd_cd.readOnly = true;
//		formObj.rtn_yd_cd.className="input2";
//
//	 }else{
//		ComBtnDisable("btn_mnr_rtn_yard_setup");
//		formObj.rtn_yd_cd.readOnly = false;
//		formObj.rtn_yd_cd.className="input";
//	 }
	//creating combo by VVD from parent window
	if (!opener) opener=window.dialogArguments;
	if(!opener) opener=parent;
	fncSplit2Combo(form.vvd, opener.form.vvd0243list.value, arrColValues[1]);
	fnInSetComboBox(form.an_fom_cd, evtCode,evtValue, "|", null, null, true, "");
	//setting data of param
	fncInitData();
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 }
function initControl(){
//	axon_event.addListener("beforedeactivate", 'obj_deactivate', form);
}
function obj_deactivate(){
    ComChkObjValid(ComGetEvent());
}
 /**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
     //searching 
         case 1:      // sheet1 init
             with(sheetObj){
			       var HeadTitle="||an_seq|an_fom_cd|addr_ctnt|impt_ntc_rmk";
			       var sheetName="sheet1_";
			
			       SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
			
			       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			       var headers = [ { Text:HeadTitle, Align:"Center"} ];
			       InitHeaders(headers, info);
			
			       var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"ibflag" },
							  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"an_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"an_fom_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"addr_ctnt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:290,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"impt_ntc_rmk", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			       InitColumns(cols);
			       SetEditable(1);
			       SetSheetHeight(117);
                 }
             break;
         //saving 
         case 2:      // sheet2 init
             with(sheetObj){
		          var HeadTitle="||vvd|pod_arr_dt|del_arr_dt|pkup_aval_dt|pkup_free_dt|pkup_yd_cd|rtn_yd_cd|bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|an_fom_cd|chn_agn_cd";
		          var sheetName="sheet2_";
		
		          SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		          var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		          var headers = [ { Text:HeadTitle, Align:"Center"} ];
		          InitHeaders(headers, info);
		
		          var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"ibflag" },
		              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"Seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"vvd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"pod_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:125,  Align:"Left",    ColMerge:0,   SaveName:sheetName+"del_arr_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"pkup_aval_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"pkup_free_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:sheetName+"pkup_yd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:sheetName+"rtn_yd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:70,   Align:"Left",    ColMerge:0,   SaveName:sheetName+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"an_fom_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		              {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:sheetName+"chn_agn_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		          InitColumns(cols);
		          SetEditable(1);
		          SetSheetHeight(117);
               }
         break;
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
  * handling process for input validation
  */
 function validateForm(sheetObj,formObj,sAction){
     with(formObj){
     }
     return true;
 }
	// handling of Sheet 
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
				case IBSEARCH:     
					if(sheetObj.id == "sheet1"){
						formObj.f_cmd.value=SEARCH01;
						ComOpenWait(true);
						sheetObj.DoSearch("ESM_BKG_0243GS.do",FormQueryString(formObj) + "&"+ ComGetPrefixParam("sheet1_"));
					}
				break;
				case IBSAVE:        
				break;
				case IBINSERT:      
				break;
	    }
	}
/**
 *  setting data of param
 * @return
 */
function fncInitData(){
	var arrColNames=new Array("vsl_nm","vvd","pod_arr_dt","del_arr_dt","pkup_aval_dt","pkup_free_dt","pkup_yd_cd","rtn_yd_cd","an_fom_cd","chn_agn_cd","diff_rmk","ntc_rvis_flg","bkg_no","vsl_cd","skd_voy_no","skd_dir_cd");
	var formObj=document.form;
	for(var i=0;i<arrColNames.length;i++){
		var valObj=document.getElementById(arrColNames[i]);
		if(arrColNames[i] == "diff_rmk"){
			valObj.value = decodeURIComponent(arrColValues[i]);//Setting value to text box 
		}else{
			valObj.value = arrColValues[i];
		}	
		if(valObj.value == "Y"){
			valObj.checked=true;
		}else{
			valObj.checked=false;
		}
		if(arrColNames[i] == "ntc_rvis_flg"){
			break;
		}
	}
	sheetObjects[1].DataInsert(-1);
	for(var k=0;k<arrColNames.length;k++){
		sheetObjects[1].SetCellText(1,"sheet2_"+arrColNames[k] ,arrColValues[k]);
	}
}
/**
 * moving MNR RTN Yard Setup (0052)
 * @return
 */
function fncT2CustomerInfoClick(vvd){
	var goUrl="";
	goUrl="/opuscntr/ESM_BKG_0052.do?";
	ComOpenWindowCenter(goUrl+"vvd="+encodeURI(vvd),"ESM_BKG_0052",700,420,true);
}
/**
 *
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
	ComOpenWait(false);
	var formObj=document.form;
	//initializing value
	formObj.addr_cnt.value="";
	formObj.impt_ntc_rmk.value="";
	if(sheetObj.RowCount()> 0){
		formObj.addr_cnt.value=sheetObj.GetCellValue(1,"sheet1_"+"addr_ctnt");
		formObj.impt_ntc_rmk.value=sheetObj.GetCellValue(1,"sheet1_"+"impt_ntc_rmk");
	}
}
/**
 * as changing of an_fom_cd 
 * @param obj
 * @return
 */
function fncAnFomCdChange(obj){
	var formObj=document.form;
	doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
}
function fncBlur(obj){
	var formObj=document.form;
	var colName=obj.id;
	var chkObj=document.getElementById(colName+ "_chk");
	var nulObj=document.getElementById(colName+ "_null");
	var valObj=document.getElementById(colName);
	if(sheetObjects[1].GetCellValue(1,"sheet2_"+colName) != valObj.value){	
		    chkObj.checked=true;
			chkObj.value = valObj.value;
			valObj.style.color="blue";
		if(nulObj.checked){
			sheetObjects[1].SetCellValue(1,"sheet2_"+colName,valObj.value);
		}
			
	}else{
			//valObj.style.color="";
			chkObj.checked=false;
	}
	if(document.getElementById(obj.id+ "_null") != undefined){
		checkNull(obj);
	}
}
function sheet2_OnSaveEnd(sheetObj, errMsg){
	if (errMsg == "") {
		ComBkgSaveCompleted();
  ComClosePopup(); 
  	}
}
/**
* initializing data when check box is clicked 
*<7.31>
* after inserting value to field, left check box is checked automatically when cursor is focused out
* if check box is unchecked, initializing that field
*/
function fncCheckboxOnClick(colName){
	//<7.31>4. after inserting value to field, left check box is checked automatically when cursor is focused out
	//if check box is unchecked, initializing that field
	var formObj=document.form;
	var chkObj=document.getElementById(colName+ "_chk");
	var valObj=document.getElementById(colName);
	if(!chkObj.checked){
		chkObj.checked=false;//check box uncheck시에 부모창으로 수정된 데이터 안보내기위한 처리
		valObj.style.color="black";

		chkObj.value = sheetObjects[1].GetCellValue(1,"sheet2_"+colName);
		sheetObjects[1].SetCellValue(1,"sheet2_"+colName,sheetObjects[1].GetCellValue(1,"sheet2_"+colName));
	}
}
/**
* setting modified value at pop up to parent window 
*
*/
function fncSetup(){
	var formObj=document.form;
	var selectVVD=formObj.vvd.value;
	//<8.10> 6-1)[ETA POD] must be late [ETA DEL],[Available Date],[Free Date] . showing the message [BKG04009] 
	//pod_arr_dt, (del_arr_dt, pkup_aval_dt,pkup_free_dt)
	if(formObj.del_arr_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.del_arr_dt.value) < 0){
		ComShowCodeMessage("BKG04009","ETA DEL");
		return;
	}
	if(formObj.pkup_aval_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.pkup_aval_dt.value) < 0){
		ComShowCodeMessage("BKG04009","Available Date");
		return;
	}
	if(formObj.pkup_free_dt.value != ""
		&& ComGetDaysBetween(formObj.pod_arr_dt.value,formObj.pkup_free_dt.value) < 0){
		ComShowCodeMessage("BKG04009","Free Date");
		return;
	}
	//<8.7>6. checking validation in case of clicking button, Set Up Arrival Info 
	//  => Full CNTR P/Up CY , Empty Return CY : checking digit (7 digit )  = > [ BKG01078 ] after showing the message, focusing out 
	if(formObj.pkup_yd_cd.value.length > 0 && formObj.pkup_yd_cd.value.length != 7){
		ComShowCodeMessage("BKG01078","Full CNTR P/Up CY");
		formObj.pkup_yd_cd.focus();
		return;
	}
	//<8.10>Empty Return CY]is not mandatory item to setup. 
	if(formObj.rtn_yd_cd.value.length > 0 && formObj.rtn_yd_cd.value.length != 7){
		ComShowCodeMessage("BKG01078","Empty Return CY");
		formObj.rtn_yd_cd.focus();
		return;
	}
	//inserting value of opener
	//dialogArguments.fncSetupFrom243(document,selectVVD);
	if (!opener) opener=window.dialogArguments;
    if(!opener) opener=parent;
    opener.fncSetupFrom243(document,selectVVD);
    
	if(formObj.vvd.options.length > 1){
		//alert("finish");
		ComShowCodeMessage("BKG40067",selectVVD);
	}
	//<09.03>combo = 1 : closing the window automatically after setting value to parent window
	if(formObj.vvd.options.length == 1){
		ComClosePopup(); 
	}
	//alert(formObj.vvd.options.length);
}
/**
* checking time format , and inserting 00:00 automatically
*/
function fncAutoSettingTime(obj){
	var val=obj.value;
	if(ComIsDate(val)){
		//alert("format is right");
		obj.value=val + " " + "00:00";
	}
}
//inputting to combo by splitting string
function fncSplit2Combo(obj, pStr, vvd){
	var arr=fncSplit2Arr(pStr);
	var dbg="";
	for(var i=0;i<arr.length-1;i++){
		var oOption=document.createElement("OPTION");
		obj.options.add(oOption);
		oOption.innerText=arr[i];
		oOption.value=arr[i];
		if(vvd == arr[i]){
			oOption.selected=true;
		}
	}
	//alert("\n result " + dbg);
}
// returning list by splitting string
function fncSplit2Arr(pStr){
	var arr=pStr.split("/");
	return arr;
}
function fncChangeVVD(obj){
	//alert(obj.value);
	
	if (!opener) opener=window.dialogArguments;
    if(!opener) opener=parent;
	var parentSheetObj=opener.sheetObjects["t2sheet1"];
	var tmpVvd=obj.value;
	for(var i=0;i<parentSheetObj.RowCount();i++){
		if(parentSheetObj.GetCellValue(i,"t2sheet1_vvd") == tmpVvd){
			opener.t2sheet1_OnClick(parentSheetObj, i+1, 2, "");
			opener.fncT2SetDataClick();
			break;
		}
	}
}
function checkNull(obj){
	var objNull=document.getElementById(obj.id+ "_null");
	if(obj.value == '') {
		objNull.checked=true;
	}else{
		objNull.checked=false;
	}
}
    /* the end of developer's work */
