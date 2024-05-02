/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_1066.jsp
*@FileTitle  : Loading Trend by Lane
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
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
	formObj.tpsz.value="N";
	tpszChange("N");
	hiddenCntrTpsz("");
	//Query,ViewAdapter
	formObj.cntr_tpsz_cd.value=consTpsz;
	//Set Week 
	formObj.fm_wk.value=formObj.h_fm_wk.value
	formObj.to_wk.value=formObj.h_to_wk.value
	//ETA Date 
	ComEnableObject(formObj.eta_fm_dt,false);
	ComEnableObject(formObj.eta_to_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
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
	/** **************************************************** */
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
			case "btns_calendar":
				if(formObj.dt_tp_cd[1].checked){
					var cal=new ComCalendarFromTo();
                	cal.select(formObj.eta_fm_dt, formObj.eta_to_dt, 'yyyy-MM-dd');
				}
            break;
			case "btn_loc_cd":
    			//if(formObj.loc_cd.value != "") {	
					var code_type=formObj.loc_tp_cd.value;
					if(code_type.substr(0,1) == "E") {
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "ecc_cd:loc_cd", "0,1,1,1,1,1", true);
					}else if(code_type.substr(0,1) == "L") {	
						ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "lcc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }else if(code_type.substr(0,1) == "S"){
				    	ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 457, "scc_cd:loc_cd", "0,1,1,1,1,1", true);
				    }
    			//}
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
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
       case IBSEARCH:      
       		if(validateSearch()){
				sheetObj.RemoveAll();
			    formObj.f_cmd.value=SEARCHLIST;
			    sheetObj.DoSearch("EES_EQR_1066GS.do",FormQueryString(formObj) );
			}
       break;
       case IBDOWNEXCEL:   
       		if(sheetObj.RowCount()>0){
       			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			}else{
				ComShowCodeMessage("EQR01104");
			}
       break;
    }
}
/**
 * Check validation of search condition
 */
function validateSearch() {
	var formObj=document.form;
	var rtn_val=true;
	if (formObj.dt_tp_cd[0].checked) {
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
	}else if (formObj.dt_tp_cd[1].checked){
		if (ComTrimAll(formObj.eta_fm_dt) == "") {
			ComShowCodeMessage("EQR01101","ETA From date"); //Please input ETA from date
			formObj.eta_fm_dt.focus();
			rtn_val=false;			
		}else if (ComTrimAll(formObj.eta_to_dt) == "") {
			ComShowCodeMessage("EQR01101","ETA To date"); //Please input ETA from date
			formObj.eta_to_dt.focus();
			rtn_val=false;					
		}else{
			var diffDay=ComGetDaysBetween(formObj.eta_fm_dt.value, formObj.eta_to_dt.value);
			if (diffDay < 0) {
				ComShowCodeMessage('EQR01118');
				formObj.eta_to_dt.value="";
				formObj.eta_to_dt.focus();
				rtn_val=false;	
			}else if (diffDay > 365) {
				ComShowCodeMessage('EQR01106','365 days');
				formObj.eta_to_dt.value="";
				formObj.eta_to_dt.focus();			
				rtn_val=false;		
			}
		}		
	}
	return rtn_val;
}
/**
 * Sheet default value setting
 */
function initSheet(sheetObj, sheetNo){
	var cnt=0;
	var col_nm="";
	var screen_height=window.screen.height;
	switch (sheetNo) {
		case 1: // sheet1 init
			with (sheetObj) {
		    var col_cnt=11
		    + eval(consTpszArr.length)  //MT PLAN
		    + 3							//M.Ton|Teu|Box
		    + eval(consTpszArr.length) 	//MT Booking(B)
		    + 3  						//M.Ton|Teu|Box
		    + eval(consTpszArr.length) 	//Diff(A-B)
		    + 2							//Teu|Box
		    + eval(consTpszArr.length) 	//Full BKG Load
		    + 4							//M.Ton|WT|Teu|Box
		    + eval(consTpszArr.length)	//Full BKG Disch
		    + 16
		    ;
		    var HeadTitle0="LCC|ECC|Yard|Week|R.LANE|VVD|ETA|ETD|FCBF\ndate|MT Plan(A)|MT Plan(A)";
		    for(var i=0; i<consTpszArr.length; i++){
		    	HeadTitle0=HeadTitle0+"|MT Plan(A)";//MT Plan(A)
		    }
		    HeadTitle0=HeadTitle0+"|MT Plan(A)|MT Booking(B)|MT Booking(B)"
		    for(var i=0; i<consTpszArr.length; i++){
		    	HeadTitle0=HeadTitle0+"|MT Booking(B)"; //MT Booking(B)
		    }
		    HeadTitle0=HeadTitle0+"|MT Booking(B)|Diff (A-B)|Diff (A-B)"
		    for(var i=0; i<consTpszArr.length; i++){
		    	HeadTitle0=HeadTitle0+"|Diff (A-B)"; //|Diff (A-B)
		    }
		    HeadTitle0=HeadTitle0+"|Full BKG|Full BKG"
		    for(var i=0; i<consTpszArr.length; i++){
		    	HeadTitle0=HeadTitle0+"|Full BKG"; //Full BKG Load
		    }
		    HeadTitle0=HeadTitle0+"|Full BKG|Full BKG|Full BKG|Full BKG"
		    for(var i=0; i<consTpszArr.length; i++){
		    	HeadTitle0=HeadTitle0+"|Full BKG"; //Full BKG Disch
		    }
		    HeadTitle0=HeadTitle0+"|Full BKG|Void|BSA|BSA|L/F|L/F|L/F|L/F|L/F|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg"
		    var HeadTitle1="LCC|ECC|Yard|Week|R.LANE|VVD|ETA|ETD|FCBF\ndate|MT Plan(A)|MT Plan(A)";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle1=HeadTitle1+"|MT Plan(A)"; 	//MT PLAN
		    }
		    HeadTitle1=HeadTitle1+"|MT Plan(A)|MT Booking(B)|MT Booking(B)";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle1=HeadTitle1+"|MT Booking(B)";	// MT Booking(B)
		    }
		    HeadTitle1=HeadTitle1+"|MT Booking(B)|Diff(A-B)|Diff(A-B)";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle1=HeadTitle1+"|Diff(A-B)";	// Diff(A-B)
		    }
		    HeadTitle1=HeadTitle1+"|Load|Load";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle1=HeadTitle1+"|Load";	// MT Booking Load
		    }
		    HeadTitle1=HeadTitle1+"|Load|Average\nWT|Disch|Disch";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle1=HeadTitle1+"|Disch";	// MT Booking Disch
		    }
		    HeadTitle1=HeadTitle1+"|Disch|Void|BSA|BSA|F/D|Full|Full|TTL|TTL|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg";
		    var HeadTitle2="LCC|ECC|Yard|Week|R.LANE|VVD|ETA|ETD|FCBF\ndate|Teu|Box";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle2=HeadTitle2+"|"+consTpszArr[i]; //MT Plan(A)
		    }
		    HeadTitle2=HeadTitle2+"|M/Ton|Teu|Box";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle2=HeadTitle2+"|"+consTpszArr[i]; //MT Booking(B)
		    }
		    HeadTitle2=HeadTitle2+"|M/Ton|Teu|Box";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle2=HeadTitle2+"|"+consTpszArr[i]; //Diff(A-B)
		    }
		    HeadTitle2=HeadTitle2+"|Teu|Box";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle2=HeadTitle2+"|"+consTpszArr[i]; //Full BKG Load
		    }
		    HeadTitle2=HeadTitle2+"|M/Ton|Average\nWT|Teu|Box";
		    for(var i=0; i<consTpszArr.length; i++){
		    HeadTitle2=HeadTitle2+"|"+consTpszArr[i]; //Full BKG Disch
		    }
		    HeadTitle2=HeadTitle2+"|M/Ton|Teu| Teu|M/Ton|F/D|Teu|M/Ton|Teu|M/Ton|ShortFall Reason|ShortFall Reason|Remarks|Sort_id|ibflg";
		    SetHeaderRowHeight(20);
		    SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:1 } );

		    var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
		    var headers = [ { Text:HeadTitle0, Align:"Center"},
		                  { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		    InitHeaders(headers, info);

		    var cols = [ {Type:"Text",      Hidden:0,  Width:43,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:43,   Align:"Center",  ColMerge:1,   SaveName:"ecc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:57,   Align:"Center",  ColMerge:1,   SaveName:"wk",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:43,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:93,   Align:"Center",  ColMerge:1,   SaveName:"eta_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:93,   Align:"Center",  ColMerge:1,   SaveName:"etd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"fcbf_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"mty_pln_teu",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
		              {Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"mty_pln_box",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 } ];
		    for (var i=0; i < consTpszArr.length; i++) { // MT PLAN
			    col_nm="mty_pln_"+(consTpszArr[i]).toLowerCase();
			    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    }
		    cols.push({Type:"Int",       Hidden:0,  Width:43,   Align:"Right",   ColMerge:0,   SaveName:"mty_pln_ton",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"mty_bkg_teu",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"mty_bkg_box",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    for (var i=0; i < consTpszArr.length; i++) {//MT Booking
			    col_nm="mty_bkg_"+(consTpszArr[i]).toLowerCase();
			    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    }
		    cols.push({Type:"Int",       Hidden:0,  Width:43,   Align:"Right",   ColMerge:0,   SaveName:"mty_bkg_ton",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"diff_teu",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:30,   Align:"Right",   ColMerge:0,   SaveName:"diff_box",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    for (var i=0; i < consTpszArr.length; i++) {//Diff(A-B)
			    col_nm="diff_"+(consTpszArr[i]).toLowerCase();
			    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    }
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"bkg_lodg_teu",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"bkg_lodg_box",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    for (var i=0; i < consTpszArr.length; i++) {// Full BKG Lodg
			    col_nm="bkg_lodg_"+(consTpszArr[i]).toLowerCase();
			    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    }
		    cols.push({Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"bkg_lodg_ton",    KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Float",     Hidden:0,  Width:55,   Align:"Right",   ColMerge:1,   SaveName:"bkg_avg_wt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"bkg_disch_teu",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"bkg_disch_box",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    for (var i=0; i < consTpszArr.length; i++) {// Full BKG Disch
			    col_nm="bkg_disch_"+(consTpszArr[i]).toLowerCase();
			    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:col_nm,            KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    }
		    cols.push({Type:"Int",       Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"bkg_disch_ton",   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:38,   Align:"Right",   ColMerge:1,   SaveName:"void_teu",        KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"bsa_teu",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"bsa_ton",         KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:35,   Align:"Right",   ColMerge:1,   SaveName:"lf_fd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"lf_full_teu",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"lf_full_ton",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:38,   Align:"Right",   ColMerge:0,   SaveName:"lf_ttl_teu",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:45,   Align:"Right",   ColMerge:0,   SaveName:"lf_ttl_ton",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pln_rsn_hdr_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"pln_rsn_sub_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pln_rsn_rmk",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"sort_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:1, Width:40,   Align:"Left",    ColMerge:1,   SaveName:"ibflag",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		    cols.push({Type:"Text",      Hidden:1, Width:50,   Align:"Left",    ColMerge:1,   SaveName:"",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 });
		  
		    InitColumns(cols);

		    SetEditable(1);
		    SetEditableColorDiff(0);
		    SetMergeCell(0,9,2,20);  //MT Plan(A) Header Merge
		    SetMergeCell(0,29,2,20); //MT Booking(B) Header Merge
		    SetMergeCell(0,49,2,19); //Diff(A-B) Header Merge
		    SetMergeCell(0,110,2,2); //BSA Header Merge
		    SetMergeCell(0,117,3,2); //ShortFall Reason Header Merge
		    sheetObj.SetColProperty("eta_dt", {Format:"####-##-####:##"} );
		    sheetObj.SetColProperty("etd_dt", {Format:"####-##-####:##"} );
		    sheetObj.SetColProperty("fcbf_dt", {Format:"####-##-##"} );
		    SetSheetHeight(screen_height-380);
		}
		break;
	}
}
/**
 * KeyPress 
 * @version 2013.07.15 
 */

/**
 * Form Object Event - onBlur <br>
 * @version 2013.07.15
 */
function form_focus(){
	var formObj=document.form;
	var str_val="";
	srcName=ComGetEvent("name");
	switch (srcName) {
		case "eta_fm_dt":
			formObj.eta_fm_dt.value=ComTrimAll(formObj.eta_fm_dt.value, "-");
		break;
		case "eta_to_dt":
			formObj.eta_to_dt.value=ComTrimAll(formObj.eta_to_dt.value, "-");
		break;
	}
}
/**
 * Form Object Event - onBlur <br>
 * @version 2013.07.15
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
						ComShowCodeMessage("EQR01119");
						formObj.to_wk.focus();
					}else if ((parseInt(str_val) - parseInt(formObj.fm_wk.value)) > 100) {
							formObj.to_wk.value="";
							formObj.to_wk.focus();
							ComShowCodeMessage('EQR01106', '52 weeks');
					}
				}
			}
		break;
		case "eta_fm_dt":
			if(ComTrimAll(formObj.eta_fm_dt.value, "-").length == 8){
				formObj.eta_fm_dt.value=ComTrimAll(formObj.eta_fm_dt.value, "-").substr(0,4)+"-"
										+ ComTrimAll(formObj.eta_fm_dt.value, "-").substr(4,2)+"-"
										+ ComTrimAll(formObj.eta_fm_dt.value, "-").substr(6,2)
			}
		break;		
		case "eta_to_dt":
			if (ComTrimAll(formObj.eta_fm_dt) != "" && ComTrimAll(formObj.eta_to_dt) != "") {
				diffDay=ComGetDaysBetween(formObj.eta_fm_dt, formObj.eta_to_dt);
				if (diffDay < 0) {
					ComShowCodeMessage('EQR01118');
					formObj.eta_to_dt.value="";
					formObj.eta_to_dt.focus();
				}else if (diffDay > 365) {
					ComShowCodeMessage('EQR01106','365 days');
					formObj.eta_to_dt.value="";
					formObj.eta_to_dt.focus();				
				}
			}
			if(ComTrimAll(formObj.eta_to_dt.value, "-").length == 8){
				formObj.eta_to_dt.value=ComTrimAll(formObj.eta_to_dt.value, "-").substr(0,4)+"-"
										+ ComTrimAll(formObj.eta_to_dt.value, "-").substr(4,2)+"-"
										+ ComTrimAll(formObj.eta_to_dt.value, "-").substr(6,2)
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
/**
 * Data Selection Check Event -  <br>
 * @version 2013.07.15
 */
function form_data_selection(){
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var arr_cntr_tpsz=(comboObjects[3].GetSelectCode()).split(",");
	srcName=ComGetEvent("name");
	switch (srcName) {
		case "wgt":
			// Weight : M/Ton column Hidden
			if(formObj.wgt.checked){
				if(formObj.pln.checked){
					sheetObj.SetColHidden("mty_pln_ton",0);
				}
				sheetObj.SetColHidden("mty_bkg_ton",0);
				if(formObj.bkg.checked){
					sheetObj.SetColHidden("bkg_lodg_ton",0);
					sheetObj.SetColHidden("bkg_disch_ton",0);
					sheetObj.SetColHidden("bkg_avg_wt",0);
				}
				sheetObj.SetColHidden("bsa_ton",0);
				sheetObj.SetColHidden("lf_full_ton",0);
				sheetObj.SetColHidden("lf_ttl_ton",0);
			}else{
				sheetObj.SetColHidden("mty_pln_ton",1);
				sheetObj.SetColHidden("mty_bkg_ton",1);
				sheetObj.SetColHidden("bkg_lodg_ton",1);
				sheetObj.SetColHidden("bkg_disch_ton",1);
				sheetObj.SetColHidden("bkg_avg_wt",1);
				sheetObj.SetColHidden("bsa_ton",1);
				sheetObj.SetColHidden("lf_full_ton",1);
				sheetObj.SetColHidden("lf_ttl_ton",1);
			}
		break;
		case "pln":
			// Weight : M/Ton column Hidden
			if(formObj.pln.checked){
				if(formObj.wgt.checked){
					sheetObj.SetColHidden("mty_pln_ton",0);
				}
				sheetObj.SetColHidden("mty_pln_teu",0);
				sheetObj.SetColHidden("mty_pln_box",0);
				for (var i=0; arr_cntr_tpsz.length >0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.SetColHidden("mty_pln_"	+arr_cntr_tpsz[i].toLowerCase(),0);
				}
			}else{
				sheetObj.SetColHidden("mty_pln_teu",1);
				sheetObj.SetColHidden("mty_pln_box",1);
					sheetObj.SetColHidden("mty_pln_ton",1);
				for(var i=0;i<consTpszArr.length;i++ ){
					sheetObj.SetColHidden("mty_pln_"	+consTpszArr[i].toLowerCase(),1);
				}
			}
		break;
		case "dif":
			// Weight : M/Ton column Hidden
			if(formObj.dif.checked){
				sheetObj.SetColHidden("diff_teu",0);
				sheetObj.SetColHidden("diff_box",0);
				for (var i=0; arr_cntr_tpsz.length > 0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.SetColHidden("diff_"	+arr_cntr_tpsz[i].toLowerCase(),0);
				}
			}else{
				sheetObj.SetColHidden("diff_teu",1);
				sheetObj.SetColHidden("diff_box",1);
				for(var i=0;i<consTpszArr.length;i++ ){
					sheetObj.SetColHidden("diff_"	+consTpszArr[i].toLowerCase(),1);
				}
			}
		break;
		case "bkg":
			//Full Booking Container Type Size column Hidden
			if(formObj.bkg.checked){
				if(formObj.wgt.checked){
					sheetObj.SetColHidden("bkg_lodg_ton",0);
					sheetObj.SetColHidden("bkg_avg_wt",0);
					sheetObj.SetColHidden("bkg_disch_ton",0);
				}
				sheetObj.SetColHidden("bkg_lodg_teu",0);
				sheetObj.SetColHidden("bkg_lodg_box",0);
				sheetObj.SetColHidden("bkg_disch_teu",0);
				sheetObj.SetColHidden("bkg_disch_box",0);
				for (var i=0; arr_cntr_tpsz.length >0 && i < arr_cntr_tpsz.length; i++) {
					sheetObj.SetColHidden("bkg_lodg_"	+arr_cntr_tpsz[i].toLowerCase(),0);
					sheetObj.SetColHidden("bkg_disch_"	+arr_cntr_tpsz[i].toLowerCase(),0);
				}
			}else{
				sheetObj.SetColHidden("bkg_lodg_teu",1);
				sheetObj.SetColHidden("bkg_lodg_box",1);
				sheetObj.SetColHidden("bkg_lodg_ton",1);
				sheetObj.SetColHidden("bkg_avg_wt",1);
				sheetObj.SetColHidden("bkg_disch_teu",1);
				sheetObj.SetColHidden("bkg_disch_box",1);
				sheetObj.SetColHidden("bkg_disch_ton",1);
				for (var i=0; i < consTpszArr.length; i++) {
					sheetObj.SetColHidden("bkg_lodg_"	+consTpszArr[i].toLowerCase(),1);
					sheetObj.SetColHidden("bkg_disch_"	+consTpszArr[i].toLowerCase(),1);
				}
			}
		break;
		case "avg":
			//Average Row Hidden
			if(sheetObj.RowCount()> 0){
				if(formObj.avg.checked){
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+3,"sort_flg")=="3" || sheetObj.GetCellValue(i+3,"sort_flg")=="4"){
							sheetObj.SetRowHidden(i+3,0);
						}
					}
				}else{
					for(var i=0; i<sheetObj.RowCount(); i++){
						if(sheetObj.GetCellValue(i+3,"sort_flg")=="3" || sheetObj.GetCellValue(i+3,"sort_flg")=="4"){
							sheetObj.SetRowHidden(i+3,1);
						}
					}
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
		case "N":
            comboObjects[3].SetSelectCode("");
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
		var strId=comboObj.id;
		switch (strId) {
			case "tpsztype":
				SetDropHeight(9 * 20);
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
//선택된 CONTAINER TYPE/SIZE에 따라 그리드의 헤더를 변경한다.
function tpsztype_OnChange(comboObj, value, text) {
	//조회 완료 후 선택된 Container Type/Size 이외 Hidden
	hiddenCntrTpsz(value);
}
/**
 * OnChange function <br>
 *
 * @param {ibcombo} comboObj - IBSheet Combo Object
 * @param {int} code 
 * @param {int} text 
 * @return none
 * @author
 * @version
 */
function trade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	searchOptionSubTrade("subtrade", true, true, "",  "",  newCode,   "", true);
	searchOptionLane("lane",true, true, "", newCode,"", true,"",true);
}
/**
 * OnChange function <br>
 *
 * @param {ibcombo} comboObj - IBSheet Combo Object
 * @param {int} code 
 * @param {int} text 
 * @return none
 * @author
 * @version
 */
function subtrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	searchOptionLane("lane",true,true,"",trade.GetSelectCode(),newCode,true,"",true);
}
/**
 * RCC Combo code 
 * Loc code
 */
function change_rcc(){
	var formObj=document.form;
	if(formObj.rcc_cd.value !=""){
		formObj.loc_cd.value="";
	}
}
/*
 * Container Type/Size - Hidden
 * OnloadPage,OnSearchEnd event
 * @param {String} tpsz_cd
 */
function hiddenCntrTpsz(tpsz_cd){
	var sheetObj=sheetObjects[0];
	var cntr_tpsz=tpsz_cd.toLowerCase();
	var arr_tpsz=cntr_tpsz.split(",");
	for(var i=0;i<consTpszArr.length;i++){ 
		sheetObj.SetColHidden("mty_pln_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("mty_bkg_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("diff_"		+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("bkg_lodg_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
		sheetObj.SetColHidden("bkg_disch_"	+consTpszArr[i].toLowerCase(),!isValidEQRCntrTpSz(arr_tpsz,consTpszArr[i].toLowerCase()));
	}
}
 /**
  * Check type size value
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
 * When 'new' button clicked then initializing screen.
 */
function init_form() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	formObj.dt_tp_cd[0].checked=true;
	formObj.fm_wk.value=formObj.h_fm_wk.value;
	formObj.to_wk.value=formObj.h_to_wk.value;
	formObj.eta_fm_dt.value="";
	formObj.eta_to_dt.value="";
	ComEnableObject(formObj.fm_wk,true);
	ComEnableObject(formObj.to_wk,true);
	ComEnableObject(formObj.eta_fm_dt,false);
	ComEnableObject(formObj.eta_to_dt,false);
	ComEnableObject(formObj.btns_calendar,false);
	document.getElementById("fm_wk").className="input";
	document.getElementById("to_wk").className="input";		
	trade.SetSelectIndex("");
	subtrade.SetSelectIndex("");
	lane.SetSelectIndex("");
	formObj.vvd_cd.value="";
	formObj.rcc_cd.value="";
	formObj.loc_tp_cd.value="";
	formObj.loc_cd.value="";
	//loc_cd 
	ComEnableObject(formObj.loc_cd, false);
	//CNTR TY/SZ DRY
	formObj.tpsz.value="N";
	tpszChange("N");
	formObj.wgt.checked=true;
	formObj.pln.checked=true;
	formObj.dif.checked=true;
	formObj.bkg.checked=true;
	formObj.avg.checked=true;
	sheetObj.RemoveAll();
}
/**
 * Radio Button Click Event
 */
function chg_dt_tp() {
	var formObj=document.form;
	if(formObj.dt_tp_cd[0].checked){
		if (ComTrimAll(formObj.fm_wk) == "" && ComTrimAll(formObj.to_wk) == "") {
			formObj.fm_wk.value=formObj.h_fm_wk.value;
			formObj.to_wk.value=formObj.h_to_wk.value;
		}		
		ComEnableObject(formObj.fm_wk,true);
		ComEnableObject(formObj.to_wk,true);
		ComEnableObject(formObj.eta_fm_dt,false);
		ComEnableObject(formObj.eta_to_dt,false);
		ComEnableObject(formObj.btns_calendar,false);
		document.getElementById("fm_wk").className="input";
		document.getElementById("to_wk").className="input";
	}else if(formObj.dt_tp_cd[1].checked){
		if (ComTrimAll(formObj.eta_fm_dt) == "" && ComTrimAll(formObj.eta_to_dt) == "") {
			formObj.eta_fm_dt.value=formObj.h_eta_fm_dt.value;
			formObj.eta_to_dt.value=formObj.h_eta_to_dt.value;
		}
		ComEnableObject(formObj.fm_wk,false);
		ComEnableObject(formObj.to_wk,false);
		ComEnableObject(formObj.eta_fm_dt,true);
		ComEnableObject(formObj.eta_to_dt,true);
		ComEnableObject(formObj.btns_calendar,true);
		document.getElementById("eta_fm_dt").className="input";
		document.getElementById("eta_to_dt").className="input";
	}
}