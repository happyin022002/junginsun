/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0119.js
*@FileTitle : VSL SKD e-mailing Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/

var sheetObjects=new Array();
var sheetCnt=0;
document.onclick=processButtonClick;

function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				break;
			case "btn_delete":
				if( validateFormDel(sheetObj, formObj) ) {
					if(!confirm('Are you sure to delete?')) return false;
					doActionIBSheet(sheetObj,formObj,IBDELETE);					
				}				
				break;
			case "btn_save":
				if( validateForm(sheetObj, formObj) ) {
					doActionIBSheet(sheetObj,formObj,IBSAVE);
				}			
				break;
	  		case "btn_rowadd":
				doActionIBSheet(sheetObj,formObj,IBINSERT);
				break;
	  		case "btn_copy":
	  			rowCopy();
				break;
		}
	}catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(getMsg('COM12111')) ;
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
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	var formObj=document.form;
	var sheetObject=sheetObjects[0];
	doActionIBSheet(sheetObject,formObj,IBSEARCH);
}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:      //IBSheet1 init
            with(sheetObj){
        		
        	    var HeadTitle0="Chk|Customer\nCode|Lane\nCode|Port|Trans\nDur|Trans\nDur|Day|Day|Day|Day|Day|Day|Day|Time|e-mail Address" ;
        	    var HeadTitle1="Chk|Customer\nCode|Lane\nCode|Port|Trans\nDur|Trans\nDur|Sun|Mon|Tue|Wed|Thu|Fri|Sat|Time|e-mail Address" ;

        	    SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

        	    var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
        	    var headers = [ { Text:HeadTitle0, Align:"Center"},
        	                  { Text:HeadTitle1, Align:"Center"} ];
        	    InitHeaders(headers, info);

        	    var cols = [ {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk",                       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
        	                 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"eml_grp_id",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
        	                 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"to_port_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
        	                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vskd_dur_id",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
        	                 {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"unit",                      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_sun",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_mon",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_tue",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_web",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_thr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_fri",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"CheckBox",  Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_sat",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Combo",     Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"eml_snd_hr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
        	                 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"subsc_eml",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
        	                 {Type:"Status",    Hidden:0, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_jb_id",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:20 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svc_st_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"svc_end_dt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:8 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_grp_id_his",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:20 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_hr_his",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:2 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_sun_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_mon_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_tue_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_web_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_thr_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_fri_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_snd_dys_ctnt_sat_his",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:50 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vsl_slan_cd_his",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"to_port_cd_his",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"fm_port_cd_his",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eml_grp_cd_desc_his",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"vskd_dur_id_his",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"subsc_seq_his",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:100 },
        	                 {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"subsc_eml_his",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4000 } ];
        	       
        	    InitColumns(cols);
        	    SetEditable(1);
        	    SetColProperty('eml_snd_hr', {ComboText:"|00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23", ComboCode:"|00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15|16|17|18|19|20|21|22|23"} );
        	    sheetObj.SetColHidden("ibflag",1);
//        	    SetSheetHeight(350);
        	    resizeSheet();
        	}
        	break;
    }
}

function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:	  //retrieving
			formObj.f_cmd.value=SEARCH01;
			sheetObj.DoSearch("ESD_SCE_0119GS.do", FormQueryString(formObj) );
			break;
		case IBINSERT:
			var row=0;
			row=sheetObj.DataInsert(-1);
			sheetObj.SetCellValue(row, "unit","days",0);
			break;
		case IBDELETE:
			formObj.f_cmd.value=REMOVE01;
			var sParam = ComGetSaveString(sheetObj);
			if (sParam == "") {
				alert("No Save Data");
				return;
			}
			sParam += "&" + FormQueryString(formObj); // hidden param value string
			var sXml=sheetObj.GetSaveData("ESD_SCE_0119GS.do", sParam);
			doActionIBSheet(sheetObj, formObj, IBSEARCH);
			break;
		case IBSAVE:
			formObj.f_cmd.value=MULTI01;
			var sParam = ComGetSaveString(sheetObj);
			if (sParam == "") {
				alert("No Save Data");
				return;
			}
			sParam += "&" + FormQueryString(formObj); // hidden param value string
			var sXml = sheetObj.GetSaveData("ESD_SCE_0119GS.do", sParam);
			sheetObj.LoadSaveData(sXml, {Sync:1});
			if(ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ){
				ComShowMessage("SAVED SUCCESSFULLY");
			}
			break;
	}
}

function sheet_OnChange (sheetObj , row , col,val ){
	var colName=sheetObj.ColSaveName(col);
	var formObj=document.form;
	switch(colName){
		case('eml_grp_id'):
			for(var i=2; i < sheetObj.RowCount()+2; i++){
				if( sheetObjects[0].GetCellValue(i, "eml_grp_id") == sheetObjects[0].GetCellValue(row, "eml_grp_id") && row != i){
					sheetObjects[0].SetCellValue(row, "svc_st_dt",sheetObjects[0].GetCellValue(i, "svc_st_dt"),0);
					sheetObjects[0].SetCellValue(row, "eml_grp_id_his",sheetObjects[0].GetCellValue(i, "eml_grp_id"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_hr_his",sheetObjects[0].GetCellValue(i, "eml_snd_hr"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_sun_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_sun"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_mon_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_mon"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_tue_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_tue"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_web_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_web"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_thr_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_thr"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_fri_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_fri"),0);
					sheetObjects[0].SetCellValue(row, "eml_snd_dys_ctnt_sat_his",sheetObjects[0].GetCellValue(i, "eml_snd_dys_ctnt_sat"),0);
					if( sheetObj.GetCellValue(i, "subsc_eml_his") != "" ){
						sheetObj.SetCellValue(row, "svc_end_dt","COPY",0);
					}
					break;
				}else{
					sheetObj.SetCellValue(row, "svc_end_dt","",0);
				}
			}
			break;
		case('vsl_slan_cd'):
			if(sheetObj.GetCellValue(row, "vsl_slan_cd") != null && sheetObj.GetCellValue(row, "vsl_slan_cd") != "") {
				formObj.laneCdVerify.value=sheetObj.GetCellValue(row, "vsl_slan_cd").toUpperCase();
//				sheetObj.SetCellValue(row, "vsl_slan_cd",formObj.laneCdVerify.value);
				formObj.f_cmd.value=SEARCH02;
				var sXml = sheetObj.GetSearchData("ESD_SCE_0119GS.do", FormQueryString(formObj));
				
				if(sXml==-5){
				}else if(sXml.substring(1, 6) == "ERROR"){
					alert('Lane Code is not valid');
					sheetObj.SetCellValue(row, "vsl_slan_cd","",0);
				} else {
					sheetObj.SetCellValue(row, "vsl_slan_cd",sheetObj.GetCellValue(row, "vsl_slan_cd").toUpperCase(),0);
				}
			}
		break;
		case('to_port_cd'):
			formObj.portCdVerify.value=sheetObj.GetCellValue(row, "to_port_cd").toUpperCase();
			sheetObj.SetCellValue(row, "to_port_cd",formObj.portCdVerify.value,0);
			formObj.f_cmd.value=SEARCH03;
			var sXml = sheetObj.GetSearchData("ESD_SCE_0119GS.do", FormQueryString(formObj) );
			
			if(sXml==-5){
			}else if(sXml.substring(1, 6) == "ERROR"){
				alert('Lane Code is not valid');
				sheetObj.SetCellValue(row, "to_port_cd","",0);
			} else {
				//sheetObj.SetCellValue(row, "to_port_cd",sheetObj.GetCellValue(row, "to_port_cd").toUpperCase(),0);
			}			
			break;
		case('eml_snd_hr'):
			if( sheetObj.GetCellValue(row, "eml_snd_hr") == "" ){
				for(var i=2; i < sheetObj.RowCount()+2; i++){
					if( sheetObj.GetCellValue(row, "eml_grp_id") != "" &&
							sheetObj.GetCellValue(row, "eml_grp_id") == sheetObj.GetCellValue(i, "eml_grp_id") ){
						sheetObj.SetCellValue(i, "eml_snd_hr","");
					}
				}
			}else{
				for(var i=2; i < sheetObj.RowCount()+2; i++){
					if( sheetObj.GetCellValue(row, "eml_grp_id") != "" &&
							sheetObj.GetCellValue(row, "eml_grp_id") == sheetObj.GetCellValue(i, "eml_grp_id") ){
						sheetObj.SetCellValue(i, "eml_snd_hr",sheetObj.GetCellValue(row, "eml_snd_hr"));
					}
				}
			}	
			break;
		case('eml_snd_dys_ctnt_sun'):
		case('eml_snd_dys_ctnt_mon'):
		case('eml_snd_dys_ctnt_tue'):
		case('eml_snd_dys_ctnt_web'):
		case('eml_snd_dys_ctnt_thr'):
		case('eml_snd_dys_ctnt_fri'):
		case('eml_snd_dys_ctnt_sat'):
			if( sheetObj.GetCellValue(row, col) == "" ){
				for(var i=2; i < sheetObj.RowCount()+2; i++){
					if( sheetObj.GetCellValue(row, "eml_grp_id") != "" &&
							sheetObj.GetCellValue(row, "eml_grp_id") == sheetObj.GetCellValue(i, "eml_grp_id") ){
						sheetObj.SetCellValue(i, col,"");
					}
				}
			}else{
				for(var i=2; i < sheetObj.RowCount()+2; i++){
					if( sheetObj.GetCellValue(row, "eml_grp_id") != "" &&
							sheetObj.GetCellValue(row, "eml_grp_id") == sheetObj.GetCellValue(i, "eml_grp_id") ){
						sheetObj.SetCellValue(i, col,"1");
					}
				}
			}			
			break;
	}
}

var popupRow = 0;
function sheet_OnDblClick(sheetObj, Row, Col ){
	var colName=sheetObj.ColSaveName(Col);
	popupRow = Row;
	switch(colName){
		case('eml_grp_id'):
//			var newWin =  ComOpenWindow("ESD_SCE_0062.do",  window,  "scroll:no;status:no;resizable:yes;help:no;dialogWidth:500px;dialogHeight:500px" , true);
			ComOpenPopup("ESD_SCE_0062.do", 650, 480, "setCustomer", "1,0,1,1,1,1,1", true);	
		break;
		case('vsl_slan_cd'):
			sUrl="VOP_VSK_0202.do?vsl_slan_cd=" + sheetObj.GetCellValue(Row, "vsl_slan_cd");
			ComOpenPopup(sUrl, 600, 480, "returnLaneCdHelp", "0,0", true);
			break;
		case('to_port_cd'):
			openLocPopSheet(sheetObj, Row, false, "to_port_cd");
			break;
		case('subsc_eml'):
//			var newWin =  ComOpenWindow("ESD_SCE_0064.do?dist="+sheetObj.CellValue(Row,  "subsc_eml"),  window , true);
			ComOpenPopup("ESD_SCE_0064.do?dist="+sheetObj.GetCellValue(Row,"subsc_eml"), 400, 400, "", "1,0,1,1,1,1,1", true);	
			break;
	}
}

function setCustomer(rtnVal) {
	if (rtnVal != null){
		var sheetObj=sheetObjects[0];
		if( sheetObj.GetCellValue(popupRow, "eml_grp_id_his") == "" ){
			sheetObj.SetCellValue(popupRow, "eml_grp_id", rtnVal.grp_nm.substring(0, 50));
		}
	}
}


function openESD009Screen(cs_grp_id, tp_id, grp_nm){
	var sRow="";
	var sheetObj=sheetObjects[0];
	sRow=sheetObj.GetSelectRow();
	if( sheetObj.GetCellValue(sRow, "eml_grp_id_his") == "" ){
		sheetObj.SetCellValue(sRow, "eml_grp_id",grp_nm.substring(0, 50));
	}	
}

function openfunction(){
	var formObject=document.form;
	formObject.action="ESD_SCE_0119.do";
	formObject.f_cmd.value="" ;
    formObject.submit();
}

/**
 * [Lane Code] calling popup of return lane code
 * @param rtnObjs
 * @return
 */
function returnLaneCdHelp(rtnObjs){
	var sRow="";
	var sheetObj=sheetObjects[0];
	sRow=sheetObj.GetSelectRow();
	if(rtnObjs){
		var rtnDatas=rtnObjs[0];
		if(rtnDatas){
			if(rtnDatas.length > 0){
				sheetObj.SetCellValue(sRow, "vsl_slan_cd", rtnDatas[1],0);
			}
		}
	}
//	if(rtnObjs != null && rtnObjs != ""){
//		sheetObj.SetCellValue(popupRow, "vsl_slan_cd", rtnObjs);
//	}
}



function addValueNo(dist, multi_value){
	var sRow="";
	var sheetObj=sheetObjects[0];
	sRow=sheetObj.GetSelectRow();
	var multis=multi_value.split('\n');
	multi_value='';
	for(var i=0 ; i < multis.length ; i++){
		if(multis[i] != ''){
			if(i == 0){
				multi_value=multis[i];
			}else{
				multi_value=multi_value + ';' + multis[i];
			}
   		}
	}
	if(multi_value != ''){
		sheetObj.SetCellValue(sRow, "subsc_eml",multi_value.replace(/\r/gi, ''));
	}
}

/**
 * checking duplication
 */
function validateForm(sheetObj, formObj){
	var firstVal="";
	var SecondVal="";
	var rowCur=2;
//no support[check again]CLT
	for(var i=0; i < sheetObj.LastRow()-2; i++){
		firstVal=sheetObj.GetCellValue(Number(rowCur+i),'eml_grp_id') + sheetObj.GetCellValue(Number(rowCur+i),'vsl_slan_cd')
			+ sheetObj.GetCellValue(Number(rowCur+i),'to_port_cd') + sheetObj.GetCellValue(Number(rowCur+i),'vskd_dur_id')
			+ sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_hr') + sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sun')
			+ sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_mon') + sheetObj.GetCellValue(Number(rowCur+i),'vskd_dur_id')
			+ sheetObj.GetCellValue(Number(rowCur+i),'to_port_cd') + sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_tue')
			+ sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_web') + sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_thr')
			+ sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_fri') + sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sat');
		if( sheetObj.GetCellValue(Number(rowCur+i),'eml_grp_id') == "" ) {
			errMsg=sheetObj.GetCellValue(0,'eml_grp_id') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;				
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'vsl_slan_cd') == "" ){
			errMsg=sheetObj.GetCellValue(0,'vsl_slan_cd') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'to_port_cd') == "" ){
			errMsg=sheetObj.GetCellValue(0,'to_port_cd') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'vskd_dur_id') == "" ){
			errMsg=sheetObj.GetCellValue(0,'vskd_dur_id') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_hr') == "" ){
			errMsg=sheetObj.GetCellValue(0,'eml_snd_hr') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sun') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_mon') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_tue') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_web') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_thr') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_fri') == "" &&
				sheetObj.GetCellValue(Number(rowCur+i),'eml_snd_dys_ctnt_sat') == "" ){
			errMsg=sheetObj.GetCellValue(0,'eml_snd_dys_ctnt_sun') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}else if( sheetObj.GetCellValue(Number(rowCur+i),'subsc_eml') == "" ){
			errMsg=sheetObj.GetCellValue(0,'subsc_eml') + " of " + Number(i+1) + " row has no contents. Please fill in the column.";
			ComShowMessage(errMsg.replace(/\n/gi, ' '));
			return false;
		}
//no support[check again]CLT
		for(var j=i+1; j < sheetObj.LastRow()-2; j++){
			SecondVal=sheetObj.GetCellValue(Number(rowCur+j),'eml_grp_id') + sheetObj.GetCellValue(Number(rowCur+j),'vsl_slan_cd')
				+ sheetObj.GetCellValue(Number(rowCur+j),'to_port_cd') + sheetObj.GetCellValue(Number(rowCur+j),'vskd_dur_id')
				+ sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_hr') + sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sun')
				+ sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_mon') + sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_tue')
				+ sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_web') + sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_thr')
				+ sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_fri') + sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sat');
			if( sheetObj.GetCellValue(Number(rowCur+j),'eml_grp_id') == "" ) {
				errMsg=sheetObj.GetCellValue(0,'eml_grp_id') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;				
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'vsl_slan_cd') == "" ){
				errMsg=sheetObj.GetCellValue(0,'vsl_slan_cd') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'to_port_cd') == "" ){
				errMsg=sheetObj.GetCellValue(0,'to_port_cd') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'vskd_dur_id') == "" ){
				errMsg=sheetObj.GetCellValue(0,'vskd_dur_id') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_hr') == "" ){
				errMsg=sheetObj.GetCellValue(0,'eml_snd_hr') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sun') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_mon') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_tue') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_web') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_thr') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_fri') == "" &&
					sheetObj.GetCellValue(Number(rowCur+j),'eml_snd_dys_ctnt_sat') == "" ){
				errMsg=sheetObj.GetCellValue(0,'eml_snd_dys_ctnt_sun') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}else if( sheetObj.GetCellValue(Number(rowCur+j),'subsc_eml') == "" ){
				errMsg=sheetObj.GetCellValue(0,'subsc_eml') + " of " + Number(j+1) + " row has no contents. Please fill in the column.";
				ComShowMessage(errMsg.replace(/\n/gi, ' '));
				return false;
			}
			
			if( firstVal != "" || SecondVal != "" ){
				if( firstVal == SecondVal ){				
					errMsg=sheetObj.GetCellValue(i,'eml_grp_id') + " duplicated. Please remain one of them.";
					ComShowMessage(errMsg.replace(/\n/gi, ' '));
					return false;	
				}				
			}			
		}
	}
	return true;
}

 /**
  * handling process for input validation
  */
function validateFormDel(sheetObj, formObj){
	if( sheetObj.CheckedRows("chk") < 1 ) {
		errMsg="Please Retrieve First";
		ComShowMessage(errMsg);
		return false;
	}
	var checkList=sheetObj.FindCheckedRow('chk');
	var checkArray=checkList.split('|');
	for (ir=checkArray.length-1; ir >=0 ; ir--) {
		if( sheetObj.GetCellEditable(checkArray[ir], "eml_grp_id") ){
			sheetObj.RowDelete(checkArray[ir], false);
	  	}
  	}
	if( sheetObj.CheckedRows("chk") < 1 ){
		return false;
	}
	return true;
}

function sheet_OnSaveEnd(sheetObj,errMsg) {
//	if( errMsg.length > 0 ) {
//	} else {
//		var formObj=document.form;
//		doActionIBSheet(sheetObj,formObj,IBSEARCH);
//	}
}

function sheet_OnSearchEnd(sheetObj,errMsg) {
	var formObj=document.form;
	if( errMsg.length > 0 ) {
		if( formObj.f_cmd.value == SEARCH02 ){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "vsl_slan_cd","",0);
		}else if( formObj.f_cmd.value == SEARCH03 ){
			sheetObj.SetCellValue(sheetObj.GetSelectRow(), "to_port_cd","",0);
		}
	}
}

/**
 * Row Copy
 */
function rowCopy(){
	sheetObjects[0].DataCopy();
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "eml_grp_id",sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "eml_grp_id"));
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "svc_end_dt","COPY",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "vsl_slan_cd_his","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "to_port_cd_his","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "vskd_dur_id_his","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "subsc_seq_his","",0);
	sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "subsc_eml_his","",0);
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
} 