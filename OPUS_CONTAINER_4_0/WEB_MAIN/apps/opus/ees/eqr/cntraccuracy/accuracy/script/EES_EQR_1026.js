/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1026.js
*@FileTitle  : Discharging Result
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0 ;
var comObjects=new Array();
document.onclick=processButtonClick;
/**
 * IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBCombo Object
 */
function setComboObject(combo_obj){
    comboObjects[comboCnt++]=combo_obj;
}
/**
 * Sheet 
 */
function loadPage() {
	var formObj=document.form;
	//Trade, Sub Trade, Lane Multi Select ComboBox
	searchOptionTrade("trade", true, true,"","","",true);
	searchOptionSubTrade("subtrade", true, true,"","","","",true);
	searchOptionLane("lane",true, true,"","","","","",true);
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
	// multi combo box setting
	for(var p=0; p< comboObjects.length; p++) {
    	initCombo(comboObjects[p], p+1);
	}
	//CNTR TY/SZ DRY
	formObj.tpsz.value="D";
	tpszChange("D");
	// Query,ViewAdapter
	formObj.cntr_tpsz_cd.value=consTpsz;
	//Set Week 
	formObj.fm_wk.value=formObj.h_fm_wk.value
	formObj.to_wk.value=formObj.h_to_wk.value
	//RCC Combo 
	var h_ofc_tp_cd=formObj.h_ofc_tp_cd.value;
	//HQ : Regional Head Quarter
	//HT : Head Office Team
	//loc_cd 
	ComEnableObject(formObj.loc_cd, false);
	/*
	- HQ : Regional Head Quarter
	- QT : Reg.HQ Team
	- HT : Head Office Team
	- AF : Affiliate of HJS
	- HO : Head Office
	*/
	if(h_ofc_tp_cd != "HQ" && h_ofc_tp_cd != "QT" && h_ofc_tp_cd != "HT" && h_ofc_tp_cd != "AF" && h_ofc_tp_cd != "HO"){
		formObj.rcc_cd.value=formObj.h_rcc_cd.value;
		ComEnableObject(formObj.rcc_cd,false);
	}
}
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObj,IBSEARCH);
			break;
			case "btn_new":
				init_form();
			break;
			case "btn_downexcel":
				doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
			break;
			case "btn_loc_cd":	//Location 
					var code_type=formObj.loc_tp_cd.value;
					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "L") {	
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "S"){
				    	ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }
			break; 
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("EQR01109");//The service is not available now
		} else {
			alert(e);
		}
	}
}
// Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
       case IBSEARCH:      
       		if(validateSearch()){
       			ComOpenWait(true);
				sheetObj.RemoveAll();
				sheetObj.SetExtendLastCol(0);
			    formObj.f_cmd.value=SEARCHLIST;
				sheetObj.DoSearch("EES_EQR_1026GS.do",FormQueryString(formObj) );
			}
       break;
       case IBDOWNEXCEL:   
       		if(sheetObj.RowCount()>0){
 	       		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			}else{
				ComShowCodeMessage("EQR01104");
			}
       break;
    }
}
/**
 * Check validation
 */
function validateSearch() {
	var formObj=document.form;
	var rtn_val=true;
	if (ComTrimAll(formObj.fm_wk) == "") {
		formObj.fm_wk.focus();
		ComShowCodeMessage("EQR01101","From Week"); //Please input From Week
		rtn_val=false;
	}else if (ComTrimAll(formObj.to_wk) == "") {
		formObj.to_wk.focus();
		ComShowCodeMessage("EQR01101","To Week"); //Please input To Week
		rtn_val=false;				
	}else{
		if (parseInt(formObj.fm_wk.value) > parseInt(formObj.to_wk.value)) {
			formObj.to_wk.value="";
			ComShowCodeMessage("EQR01119");
			formObj.to_wk.focus();
			rtn_val=false;	
		}else if ((parseInt(formObj.to_wk.value) - parseInt(formObj.fm_wk.value)) > 100) {
				formObj.to_wk.value="";
				formObj.to_wk.focus();
				ComShowCodeMessage('EQR01106', '52 weeks');
				rtn_val=false;	
		}
	}
	return rtn_val;
}
/**
 * sheet default value
 */
function initSheet(sheetObj, sheetNo){
	var cnt=0;
	var col_nm="";
	var screen_height=window.screen.height;
	switch (sheetNo) {
		case 1: // sheet1 init
		    with(sheetObj){
			      var col_cnt=6
			      + eval(consTpszArr.length)  //Discharging result
			      + 1
			      + eval(consTpszArr.length) 	//Loading result
			      + 1
			      + eval(consTpszArr.length) 	//Difference
			      + 1
			      + eval(consTpszArr.length) 	//MT Repo guideline
			      + 1
			      + eval(consTpszArr.length)	//Difference
			      + 4
			      ;
			      var HeadTitle0="Trade|Sub\nTrade|R.LANE|Week|VVD|POD";
			      for(var i=0; i<consTpszArr.length; i++){
			      HeadTitle0=HeadTitle0+"|Discharging Result(A)";//Discharging result
			      }
			      HeadTitle0=HeadTitle0+"|Discharging Result(A)";//TTL
			      for(var i=0; i<consTpszArr.length; i++){
			      HeadTitle0=HeadTitle0+"|Loading Result(B)"; //Loading result
			      }
			      HeadTitle0=HeadTitle0+"|Loading Result(B)"; //TTL
			      for(var i=0; i<consTpszArr.length; i++){
			      HeadTitle0=HeadTitle0+"|Diff(A-B)"; //Difference
			      }
			      HeadTitle0=HeadTitle0+"|Diff(A-B)"; //TTL
			      for(var i=0; i<consTpszArr.length; i++){
			      HeadTitle0=HeadTitle0+"|MT Plan(C)"; //MT Repo guideline
			      }
			      HeadTitle0=HeadTitle0+"|MT Plan(C)"; //TTL
			      for(var i=0; i<consTpszArr.length; i++){
			      HeadTitle0=HeadTitle0+"|Diff(A-C)"; //Difference
			      }
			      HeadTitle0=HeadTitle0+"|Diff(A-C)| |Sort_id|ibflg"
			      var HeadTitle1="Trade|Sub\nTrade|R.LANE|Week|VVD|POD";
			      HeadTitle1=HeadTitle1+"|TTL"; //Discharging result TTL
			      for(var i=0; i<consTpszArr.length; i++){
			    	  HeadTitle1=HeadTitle1+"|"+consTpszArr[i]; //Discharging result
			      }
			      HeadTitle1=HeadTitle1+"|TTL"; //Loading result TTL
			      for(var i=0; i<consTpszArr.length; i++){
			    	  HeadTitle1=HeadTitle1+"|"+consTpszArr[i];	//Loading result
			      }
			      HeadTitle1=HeadTitle1+"|TTL"; //Difference TTL
			      for(var i=0; i<consTpszArr.length; i++){
			    	  HeadTitle1=HeadTitle1+"|"+consTpszArr[i];	//Difference
			      }
			      HeadTitle1=HeadTitle1+"|TTL"; //Difference TTL
			      for(var i=0; i<consTpszArr.length; i++){
			    	  HeadTitle1=HeadTitle1+"|"+consTpszArr[i];	//MT Repo guideline
			      }
			      HeadTitle1=HeadTitle1+"|TTL"; //Difference TTL
			      for(var i=0; i<consTpszArr.length; i++){
			    	  HeadTitle1=HeadTitle1+"|"+consTpszArr[i];	//Difference
			      }
			      HeadTitle1=HeadTitle1+"| |Sort_id|ibflg";
		
			      SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:6, DataRowMerge:0 } );
		
			      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
			      var headers = [ { Text:HeadTitle0, Align:"Center"},
			                  { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
		
			      var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
				             {Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"disch_ttl",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
			      for (var i = 0; i < consTpszArr.length; i++) { // Discharge Result
				      col_nm = "disch_"+(consTpszArr[i]).toLowerCase();
				      cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      }
			      cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"lodg_ttl",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      for (var i = 0; i < consTpszArr.length; i++) {// Loading Result
				      col_nm = "lodg_"+(consTpszArr[i]).toLowerCase();
				      cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      }
			      cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ab_ttl",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      for (var i = 0; i < consTpszArr.length; i++) {//Difference(A-C) : Discharge Result(A) - Loading Result(B)
				      col_nm = "ab_"+(consTpszArr[i]).toLowerCase();
				      cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      }
			      cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"gline_ttl",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      for (var i = 0; i < consTpszArr.length; i++) {// MT Repo Guideline(C)
				      col_nm = "gline_"+(consTpszArr[i]).toLowerCase();
				      cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      }
			      cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"ac_ttl",       KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      for (var i = 0; i < consTpszArr.length; i++) {//Difference(A-C) : Discharge Result(A) - MT Repo Guideline(C)
				      col_nm = "ac_"+(consTpszArr[i]).toLowerCase();
				      cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      }
			      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"blk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"sort_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"ibflag",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
			 
			      InitColumns(cols);
			      SetWaitImageVisible(0);
			      SetEditable(1);
			      SetEditableColorDiff(1);
			      SetSheetHeight(500);
	            }


		break;
	}
}
/**
 * KeyPress 
 * @author 
 * @version 
 */
function form_keypress() {
	var formObj=document.form;
	switch (ComGetEvent("name")) {
		case "fm_wk":
			ComKeyOnlyNumber(formObj.fm_wk,"");
		break;
		case "to_wk":
			ComKeyOnlyNumber(formObj.to_wk,"");
		break;
		case "vvd_cd":
			ComKeyOnlyAlphabet('uppernum');
		break;
		case "loc_cd":
			ComKeyOnlyAlphabet('upper');
		break;
	}
}
/**
 * Form Object Event - onBlur <br>
 */
function form_focus(){
	var formObj=document.form;
	var str_val="";
	srcName=ComGetEvent("name");
	switch (srcName) {
		case "eta_fm_dt":
		break;
	}
}
/**
 * Form Object Event - onBlur <br>
 */
function form_blur(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var diffDay=0;
	srcName=ComGetEvent("name");
	switch(srcName){
		case "fm_wk":
			if (ComTrimAll(formObj.fm_wk) != "") {
				str_val=formObj.fm_wk.value;
				if (str_val.length < 6) {
					formObj.fm_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}else if (str_val.length > 0 && !ComIsWeek(str_val.substring(4, 6))) {
					formObj.fm_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}else if (parseInt(str_val.substring(0, 4)) < 1900) {
					formObj.fm_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.fm_wk.focus();
				}
			}
		break;
		case "to_wk":
			if (ComTrimAll(formObj.to_wk) != "") {
				str_val=formObj.to_wk.value;
				if (str_val.length < 6) {
					formObj.to_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (str_val.length > 0 && !ComIsWeek(str_val.substring(4, 6))) {
					formObj.to_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (parseInt(str_val.substring(0, 4)) < 1900) {
					formObj.to_wk.value="";
					ComShowCodeMessage("EQR01111", "YYYYWW");
					formObj.to_wk.focus();
				}else if (ComTrimAll(formObj.fm_wk) != "" && ComTrimAll(formObj.to_wk) != ""){
					if(parseInt(formObj.fm_wk.value) > parseInt(str_val)){
						formObj.to_wk.value="";
						ComShowCodeMessage("EQR01119", "YYYYWW");
						formObj.to_wk.focus();
					}else if ((parseInt(str_val) - parseInt(formObj.fm_wk.value)) > 100) {
							formObj.to_wk.value="";
							formObj.to_wk.focus();
							ComShowCodeMessage('EQR01106', '52 weeks');
					}
				}
			}
		break;
		case "loc_cd":
			if (ComTrimAll(formObj.loc_cd) != "" && formObj.loc_tp_cd.value !="") {
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObj.GetSearchData("EES_EQR_1025GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "T") {
					if (formObj.loc_tp_cd.value == "L") {
						ComShowCodeMessage("EQR01005");
					}else if (formObj.loc_tp_cd.value == "E") {
						ComShowCodeMessage("EQR01006");
					}else if (formObj.loc_tp_cd.value == "S") {
						ComShowCodeMessage("EQR01007");
					}
					formObj.loc_cd.value="";
				}
			}
		break;
		case "vvd_cd":
			// VVD 
			if (ComTrimAll(formObj.vvd_cd) != "") {
				formObj.f_cmd.value=SEARCH02;
 				var sXml=sheetObj.GetSearchData("EES_EQR_1025GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck == "F") {
					formObj.vvd_cd.value="";
					ComShowCodeMessage("EQR01121", "VVD code");
				}
			}
		break;		
	}
}
/*
 * Container Type Combo OnChange Event
 *
 * */
function tpszChange(key){
	if(key!="N")
	comboObjects[3].SetSelectCode(-1);
    switch (key){
        case "":
            comboObjects[3].SetSelectCode(consTpsz);
        break;
        case "D":
            comboObjects[3].SetSelectCode(consTpszDry);
        break;
        case "R":
            comboObjects[3].SetSelectCode(consTpszRfr);
        break;
        case "O":
            comboObjects[3].SetSelectCode(consTpszOt);
        break;
        case "F":
            comboObjects[3].SetSelectCode(consTpszFr);
        break;
    }
}
/**
 * Location Type Code
 * @param {Object} key
 */
function locTpcdChange(key){
	var formObj=document.form;
	if (key == "") {
		formObj.loc_cd.value="";
		ComEnableObject(formObj.loc_cd, false);
	}else {
		ComEnableObject(formObj.loc_cd, true);
		document.getElementById("loc_cd").className="input";
	}
}
/**
 * MultiSelectCombo 
 */
function initCombo (comboObj, comboNo) {
    var cnt=0 ;
	var formObj=document.form;
	with (comboObj) {
		var strId=comboObj.options.id;
		switch (strId) {
			case "tpsztype":
				SetDropHeight(200);
				var menuname=tpszallText.split('|');
				var menucode=tpszallCode.split('|')
				SetMultiSelect(1);
				SetMaxSelect(menuname.length);
				SetMultiSeparator(",");
				for (i=0; i < menuname.length; i++) {
					InsertItem(cnt++, menuname[i], menucode[i]);
				}
			break;
		}
	}
}
// CONTAINER TYPE/SIZE
function tpsztype_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
	hiddenCntrTpsz(code);
}
/**
 * OnChange function <br>
 *
 * @param {ibcombo} comboObj  IBSheet Combo Object
 * @param {int} code  Onclick  code
 * @param {int} text  
 * @return 
 * @author
 * @version
 */
function trade_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
	searchOptionSubTrade("subtrade", true, true, "",  "",  code,   "", true);
	searchOptionLane("lane",true, true, "", code,"", true,"",true);
}
/**
 * OnChange function <br>
 *
 * @param {ibcombo} comboObj  IBSheet Combo Object
 * @param {int} code  Onclick  code
 * @param {int} text 
 * @return 
 * @author
 * @version
 */
function subtrade_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code) {
	searchOptionLane("lane", true, true, "", trade.GetSelectCode(), code, true, "", true);
}
/*
 * Container Type/Size
 * OnloadPage,OnSearchEnd event
 * @param {String} tpsz_cd
 */
function hiddenCntrTpsz(tpsz_cd){
	var sheetObj=sheetObjects[0];
	var cntr_tpsz=tpsz_cd.toLowerCase();
	var arr_tpsz=cntr_tpsz.split(",");
	sheetObj.RenderSheet(0);
	for(var i=0;i<consTpszArr.length;i++){ 
		sheetObj.SetColHidden("disch_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("lodg_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("ab_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("gline_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("ac_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
	}
	sheetObj.RenderSheet(1);
}
/**
 * RCC Combo code 
 */
function change_rcc(){
	var formObj=document.form;
	if(formObj.rcc_cd.value !=""){
		formObj.loc_cd.value="";
	}
}
 /**
  * CNTR TP SZ
  **/
function isValidEQRCntrTpSz(arr_tpsz, tpsz) {
	for (var i=0; tpsz!=undefined && tpsz!=null && tpsz!='' && arr_tpsz!=null && i<arr_tpsz.length; i++){
  		if (arr_tpsz[i]!=undefined && arr_tpsz[i]!='' && arr_tpsz[i].toLowerCase()==tpsz.toLowerCase()){
    		return true;
   		}
	  }
	return false;
 }
/**
 * New 
 */
function init_form() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.fm_wk.value=formObj.h_fm_wk.value;
	formObj.to_wk.value=formObj.h_to_wk.value;
	trade.SetSelectCode(-1);
	subtrade.SetSelectCode(-1);
	lane.SetSelectCode(-1);
	formObj.vvd_cd.value="";
	formObj.rcc_cd.value="";
	formObj.loc_tp_cd.value="";
	formObj.loc_cd.value="";
	ComEnableObject(formObj.loc_cd, false);
	formObj.tpsz.value="D";
	tpszChange("D");
	sheetObj.RemoveAll();
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	ComOpenWait(false);
}