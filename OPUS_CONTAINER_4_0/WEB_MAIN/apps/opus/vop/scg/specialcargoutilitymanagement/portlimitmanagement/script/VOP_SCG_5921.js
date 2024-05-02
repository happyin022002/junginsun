/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0744.js
*@FileTitle  : Direct NVO AMS File No
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // Common global variable

 var sheetObjects = new Array();
 var sheetCnt = 0;
	
 // Event handler processing by button click event */
 document.onclick = processButtonClick;
 
 // Event handler processing by button name */
 function processButtonClick(){
     /* */
     var sheetObject1=sheetObjects[0];
     var sheetObject2=sheetObjects[1];
     /*******************************************************/
     var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
	    if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_RowAdd":
				if(ComIsBtnEnable("btn_RowAdd")){
					sheetObject1.DataInsert(-1);
					
					var row = sheetObject1.GetSelectRow();
					var lastSeqNo=sheetObject1.GetCellValue(sheetObject1.LastRow()-1, "sheet1_seq_no");
		        	if(isNaN(parseInt(lastSeqNo))) {
		        		lastSeqNo=1;
		        	} else {
		        		lastSeqNo=parseInt(lastSeqNo) + 1;
		        	}
		        	sheetObject1.SetCellValue(row, "sheet1_seq_no",lastSeqNo,0);
				}
				break;
			case "btn_copy":
				doActionIBSheet(sheetObject1,document.form,IBCOPYROW);
			break;				
			case "btn_Delete":
				if(ComIsBtnEnable("btn_Delete")){
					//ComRowHideDelete(sheetObject1,"ibcheck");
					var iRow = sheetObject1.GetSelectRow();
					sheetObject1.SetRowHidden(iRow, 1);
					sheetObject1.SetRowStatus(iRow,"D");
				}
				break;
			case "btn_RowAdd2":
				if(ComIsBtnEnable("btn_RowAdd2")){
					sheetObject2.DataInsert(-1);
					
					var row = sheetObject2.GetSelectRow();
					var lastSeqNo=sheetObject2.GetCellValue(sheetObject2.LastRow()-1, "sheet2_seq_no");
		        	if(isNaN(parseInt(lastSeqNo))) {
		        		lastSeqNo=1;
		        	} else {
		        		lastSeqNo=parseInt(lastSeqNo) + 1;
		        	}
		        	sheetObject2.SetCellValue(row, "sheet2_seq_no",lastSeqNo,0);
				}
				break;
			case "btn_copy2":
				doActionIBSheet(sheetObject2,document.form,IBCOPYROW);
			break;
			case "btn_Delete2":
				if(ComIsBtnEnable("btn_Delete2")){
					//ComRowHideDelete(sheetObject1,"ibcheck");
					var iRow = sheetObject2.GetSelectRow();
					sheetObject2.SetRowHidden(iRow, 1);
					sheetObject2.SetRowStatus(iRow,"D");
				}
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_Save":
				if(ComIsBtnEnable("btn_Save")){
					doActionIBSheet(sheetObject1, formObject, IBSAVE);
				} 					 					
				break;
			case "btn_Close":
				ComClosePopup(); 
				break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage("COM12111");     
		} else {
			ComShowMessage(e);
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
	var formObj=document.form;
	
	initControl();

	var sheetObj = sheetObjects[0];
	
	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC03);
	doActionIBSheet(sheetObj, document.form, IBSEARCH_ASYNC04);
	doActionIBSheet(sheetObj, formObj, IBSEARCH);
	doActionIBSheet(sheetObj, formObj, SEARCHLIST);
	
	openSheetSetting();
}

function openSheetSetting(){
	var openerObj=window.dialogArguments;
    if(!openerObj) var openerObj= parent;
	
	var oSheetObj = openerObj.getCurrentSheet();
	var sheetObj  = sheetObjects[2];
	
	sheetObj.DataInsert(-1);
	var row = sheetObj.GetSelectRow();
	var cnt = 0;
	if(document.form.port_cd.value == 'CNSHA') {
		cnt = 16;
	} else {
		cnt = 24;
	}
	var prefix = "sheet3_";
	//마스터값 셋팅
	for(var i = 0; i < cnt; i++){
		var name = oSheetObj.GetCellProperty(oSheetObj.GetSelectRow(), i, "SaveName");
		sheetObj.SetCellValue(row, prefix+name, oSheetObj.GetCellValue(oSheetObj.GetSelectRow(), name));
	}
}

 /**
  *  setting event
  */
 function initControl() {
 	var formObject=document.form;
 }
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetID) {
		case "sheet1":
			with(sheetObj){
				var HeadTitle1="|Chk|No.|Class|Comp|Definition";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet1_";
//				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:0, ComboMaxHeight:160 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,  SaveName:prefix+"ibflag" },
				             {Type:"DummyCheck", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,  SaveName:prefix+"ibcheck" },
				             {Type:"Text",       Hidden:1, Width:30,   Align:"Center",  ColMerge:1,  SaveName:prefix+"seq_no",				UpdateEdit:0,    InsertEdit:0},
			                 {Type:"Combo",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,  SaveName:prefix+"imdg_clss_cd",      	KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1},
			                 {Type:"Combo",      Hidden:0, Width:55,   Align:"Center",  ColMerge:0,  SaveName:prefix+"imdg_comp_grp_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                 {Type:"Text",       Hidden:1, Width:460,  Align:"Left",    ColMerge:0,  SaveName:prefix+"imdg_clss_cd_desc", 	KeyField:0,   CalcLogic:"sheet_dataJoin(|sheet1_imdg_clss_cd|,|sheet1_imdg_comp_grp_cd|)",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
			                 {Type:"Text",       Hidden:1, Width:90,   Align:"Left",    ColMerge:0,  SaveName:prefix+"clssNcomp", 		    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0}
			               ];
				
				InitColumns(cols);
	
				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetSheetHeight(230);
			}
			break;

		case "sheet2":
			with(sheetObj){
				var HeadTitle1="|Chk|No.|UN No.";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet2_";
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1, ComboMaxHeight:160  } );
	
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
	
				var cols = [ {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"DummyCheck", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
				             {Type:"Text",       Hidden:1, Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"seq_no" ,																    UpdateEdit:0,   InsertEdit:0},
				             {Type:"Combo",      Hidden:0, Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_un_no", KeyField:1,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1}
			               ];
				 
				InitColumns(cols);
	
				SetCountPosition(0);
				SetWaitImageVisible(0);
				SetSheetHeight(230);
			}
			break;
			
		case "sheet3":      //sheet1 init
			with (sheetObj) {
            var HeadTitle  = "No.||Chk||Port||Entry\nType|Representative Description|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR\nType|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Sub\nProperty|FP\n(°C)|Property|Property|||" ;
            var HeadTitle2 = "No.||Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Arrival & Departure|Arrival & Departure|Arrival & Departure|Loading & Discharge|Loading & Discharge|Loading & Discharge|Sub\nProperty|FP\n(°C)|Property|Property|||" ;
            var HeadTitle3 = "No.||Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Prohi|Limit||Target|Limit||Sub\nProperty|FP\n(°C)|Explosive|Judgement|||" ;			
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:6, ComboMaxHeight:200 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
            InitHeaders(headers, info);
            
            var prefix="sheet3_";
            
            var cols = 
              [ {Type:"Text",        Hidden:0, Width:30,   Align:"Center",  ColMerge:0,  SaveName:prefix+"dp_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                {Type:"DummyCheck", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibcheck" },
                {Type:"Int",        Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port_lmt_seq",		KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port_cd",        	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pier_tp_cd",     	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"lmt_wgt_tp_cd",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1},                 
                
                {Type:"Text",       Hidden:0, Width:490,  Align:"Left",  ColMerge:0,   	 SaveName:prefix+"port_lmt_rep_desc",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
                {Type:"Text",  		Hidden:0, Width:170,  Align:"Left",  ColMerge:0,     SaveName:prefix+"v_clss_info",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:true},
                {Type:"PopupEdit",  Hidden:1, Width:20,   Align:"Left",  ColMerge:0,     SaveName:prefix+"clss_info",          KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                
//                {Type:"Combo",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1},
//                {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
//                {Type:"Text",       Hidden:0, Width:560,  Align:"Left",    ColMerge:0,   SaveName:"imdg_clss_cd_desc", 		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_subs_rsk_lbl_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                //{Type:"Combo",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",		  		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cmdt_cd", 				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                
                {Type:"Combo",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix+"imdg_pck_grp_cd",	 KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Combo",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tp_cd",      	 KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
//                {Type:"CheckBox",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"port_hdl_prohi_flg", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"CheckBox",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_dep_prohi_flg",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"Int",        Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:prefix+"arr_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dep_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                
                {Type:"CheckBox",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ldis_aply_tgt_flg",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"Int",        Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lod_max_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dchg_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                
                {Type:"Combo",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"port_lmt_sub_ppt_cd", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Int",        Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:prefix+"flsh_pnt_temp",       KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3},
//                {Type:"Int",        Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_lowr_temp",  KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3},
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_explo_flg",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_prohi_flg",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                
                {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",  	            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1},  
                {Type:"Int",        Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"lod_max_teu_qty",     KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:prefix+"dchg_max_teu_qty",    KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9}
               ];
            
            InitColumns(cols);
            SetSheetHeight(400);
            SetEditable(1);
            SetHeaderRowHeight(10);
            
            var str = "GR	GROSS|NT	NET|NP	NET POWDER";
            var cod = "GR|NT|NP";
            SetColProperty(prefix+"lmt_wgt_tp_cd", {ComboText:"|"+str, ComboCode:"|"+cod} );
            SetColProperty(prefix+"imdg_pck_grp_cd", {ComboText:"|I|II|III", ComboCode:"|1|2|3"} );
//            SetColProperty("port_lmt_sub_ppt_cd", {ComboText:"|Below|Except", ComboCode:"|B|E"} );
//            SetColProperty("port_lmt_sub_ppt_cd", {ComboText:"Below|Except", ComboCode:"B|E"} );
            SetColProperty(prefix+"ppt_explo_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
            SetColProperty(prefix+"ppt_prohi_flg", {ComboText:"N|P", ComboCode:"N|P"} );
            
//			헤더 색상 및 툴팁 적용
			for(z=0; z<=cols.length; z++){
				if(GetCellValue(1,z) == "Arrival & Departure"){
					SetCellBackColor(0, z, "#99004C");
					SetCellBackColor(1, z, "#99004C");
					SetCellBackColor(2, z, "#99004C");
					SetToolTipText(0, z, "Arrival & Departure");
				}else if(GetCellValue(1,z) == "Loading & Discharge"){
					SetCellBackColor(0, z, "#99004C");
					SetCellBackColor(1, z, "#99004C");
					SetCellBackColor(2, z, "#99004C");
					SetToolTipText(0, z, "Loading & Discharge");
				}
			}
		   }
			break;			
	}
}

function sheet_dataJoin(){
	var prefix = "sheet1_";
	var sheetObj = sheetObjects[0];
	for(var i=1; i <= sheetObj.RowCount(); i++){
		var imdg_clss_cd     = sheetObj.GetCellValue(i, prefix+"imdg_clss_cd");
		var imdg_comp_grp_cd = sheetObj.GetCellValue(i, prefix+"imdg_comp_grp_cd");
		
		sheetObj.SetCellValue(i , prefix+"clssNcomp", imdg_clss_cd+""+imdg_comp_grp_cd);
	}
}

// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    switch(sAction) {
		case IBSEARCH:	//Retrieve - Class
			if(validateForm(sheetObj,formObj,sAction))
			ComOpenWait(true);
			var aryPrefix = new Array("sheet1_");
			formObj.f_cmd.value=SEARCH;
			var xml = sheetObj.GetSearchData("VOP_SCG_5921GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			sheetObjects[0].LoadSearchData(xml,{Sync:1} );
			
			ComOpenWait(false);
		break;
		
		case SEARCHLIST:	//Retrieve - UN No.
			if(validateForm(sheetObj,formObj,sAction))
			ComOpenWait(true);
			var aryPrefix = new Array("sheet2_");
			formObj.f_cmd.value=SEARCHLIST;
			
			var xml = sheetObj.GetSearchData("VOP_SCG_5921GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			sheetObjects[1].LoadSearchData(xml,{Sync:1} );
			
			ComOpenWait(false);
		break;
		
	   case IBSEARCH_ASYNC01:	//Serching IMDG Code Combo 
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var class_cd=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
//			var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
			//Class
			//sheetObjects[0].SetColProperty("sheet1_imdg_clss_cd", {ComboText:"|"+tStr1, ComboCode:"|"+class_cd[0]} );
			sheetObjects[0].SetColProperty("sheet1_imdg_clss_cd", {ComboText:"|"+class_cd[0], ComboCode:"|"+class_cd[0]} );
		break;
		
		case IBSEARCH_ASYNC03:	//Serching Un No. Code Combo 
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var un_no=ComXml2ComboString(sXml, "imdg_un_no", "prp_shp_nm");
//			var tStr=ComScgClossAppend(un_no[0], un_no[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObjects[1].SetColProperty("sheet2_imdg_un_no", {ComboText:"|"+un_no[0], ComboCode:"|"+un_no[0]} );
		break;
		
		case IBSEARCH_ASYNC04:   //Division of Class retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0047GS.do", FormQueryString(formObj));
			var imdg_comp_grp_cd=ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
//			var tStr=ComScgClossAppend(imdg_comp_grp_cd[0], imdg_comp_grp_cd[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObjects[0].SetColProperty("sheet1_imdg_comp_grp_cd", {ComboText:"|"+imdg_comp_grp_cd[0], ComboCode:"|"+imdg_comp_grp_cd[0]} );
		break;
		
	  	case IBSAVE:        //
//			if(!validateForm(sheetObj,formObj,sAction)) {
//				return false;
//			}
//			ComOpenWait(true);
//			formObj.f_cmd.value = MULTI;
//			sheetObjects[0].DoSave("VOP_SCG_5921GS.do", {Param:FormQueryString(formObj), Col:'-1', Quest:true, Sync:1 });
//			sheetObjects[1].DoSave("VOP_SCG_5921GS.do", {Param:FormQueryString(formObj), Col:'-1', Quest:true, Sync:1 });
//			ComOpenWait(false);
	  		
	  		if(dupChk()){
				var aryPrefix=new Array( "sheet1_", "sheet2_", "sheet3_"); 
				formObj.f_cmd.value=MULTI;
				if( !validateForm(sheetObj,formObj,sAction)) return;
				var sParam=ComGetSaveString(sheetObjects, true, true);	//Transmitting all rows
				if (sParam == "") return;
				//ComDebug("[Debug] \n" + sParam + "\n");	//alert
				ComOpenWait(true);
				sheetObjects[0].SetWaitImageVisible(0);
				sParam += "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
				var sXml=sheetObjects[0].GetSaveData("VOP_SCG_5921GS.do", sParam);
				sheetObjects[0].LoadSaveData(sXml);
				sheetObjects[0].RenderSheet(1);
				sheetObjects[1].RenderSheet(1);
				
				var portLmtSeqStr = ComGetEtcData(sXml, "portLmtSeq");
				if(portLmtSeqStr == 'undefined') portLmtSeqStr = "";
				//console.log("portLmtSeqStr>>>>>>>>>>>>>>>"+portLmtSeqStr);
      			if(portLmtSeqStr != "") {
      				document.getElementById("port_lmt_seq").value = portLmtSeqStr;
      			}
      			var portLmtSeqVal = document.getElementById("port_lmt_seq").value;
      			//console.log("portLmtSeqVal>>>>>>>>>>>>>>>"+portLmtSeqVal);
      			if(portLmtSeqVal != "0" && portLmtSeqVal != ""){
          			doActionIBSheet(sheetObj, document.form, IBSEARCH);
          			doActionIBSheet(sheetObj, document.form, SEARCHLIST);      				
      			}
	  		}

			ComOpenWait(false);
		break;
		
		case IBCOPYROW:
			var prefix = "";
		    if (sheetObj.id == "sheet1") {
		    	prefix = "sheet1_";
		    }else if (sheetObj.id == "sheet2") {
		    	prefix = "sheet2_";
		    }
		    
		    var row=sheetObj.DataCopy();
		    sheetObj.SetRowStatus(row,"I");
			
//			var row = sheetObj.GetSelectRow();
//			var lastSeqNo=sheetObj.GetCellValue(sheetObj.LastRow()-1, prefix+"seq_no");
//        	if(isNaN(parseInt(lastSeqNo))) {
//        		lastSeqNo=1;
//        	} else {
//        		lastSeqNo=parseInt(lastSeqNo) + 1;
//        	}
//        	sheetObj.SetCellValue(row, prefix+"seq_no",lastSeqNo,0);		    
		break;
    }
}

/**
 * 화면단에서 컬럼별로 소팅하거나 중복컨테이너로우가 변경될때마다 해당 로우의 배열을 전역변수(배열)인 colorAry 로 담아온다  
 */
function dupChk(){
	var boolChk = true;
	var sheetObj1 = sheetObjects[0];
	var sheetObj2 = sheetObjects[1];
	var prefix1 = "sheet1_";
	var prefix2 = "sheet2_";
	var arrRowAry01 = new Array();
	var arrRowAry02 = new Array();
	sheetObj1.SpaceDupCheck = false;	//기본적으로는 공백을 포함해서 중복체크를 하는데 공백을 제외하고 중복체크
	sheetObj2.SpaceDupCheck = false;
    
	///////////sheetObj1 중복체크//////////
	
	var dupRow1 = sheetObj1.ColValueDupRows(prefix1+"clssNcomp", false, true);
	var arrRowsAry1 = dupRow1.split("|");
	
	if(dupRow1 != "") {
		arrRowAry01 = arrRowsAry1[0].split(",");
		boolChk = false;
	}
	
	////////////sheetObj2 중복체크//////////
	
	var dupRow2 = sheetObj2.ColValueDupRows(prefix2+"imdg_un_no", false, true);
	var arrRowsAry2 = dupRow2.split("|");
	
	if(dupRow2 != "") {
		arrRowAry02 = arrRowsAry2[0].split(",");
		boolChk = false;
	}
	
	if(!boolChk){
		ComShowCodeMessage("SCG50042");
		sheetObj1.SelectCell(arrRowAry01[0],prefix1+"clssNcomp");
		sheetObj2.SelectCell(arrRowAry02[0],prefix2+"imdg_un_no");
	}
	
	return boolChk;
}

/**
 * Validating inputted values of form
 * @param
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        switch (sAction) {
            case IBSAVE : 
            	// For renumbering "port_lmt_seq"
//            	for(var i=2; i <= sheetObj.RowCount()+1; i++){
//            		if(sheetObj.GetCellValue(i , "ibflag") == "R"){
//            			sheetObj.SetCellValue(i , "ibflag", "U");
//            		}
//            		//sheetObj.SetCellValue(i, "port_lmt_seq_tmp", i-1);
//            	}
            	
//					var Row = sheetObj.ColValueDup("un_loc_cd|imdg_clss_cd",false);
//					if( Row != -1){
//     	    		 ComShowCodeMessage("SCG50005", "Data");
//         	    	 //sheetObj.SelectCell(Row, "slan_cd");
//					 return false;
//					}
				break;
        }
  }
  return true;
}

/**
 * sheet1_OnChange
 * @param sheetObj, row, col, value
*/
function sheet1_OnChange(sheetObj, row, col, value){	
	switch( sheetObj.ColSaveName(col)  ){

	    case 'sheet1_imdg_clss_cd' : // Setting IMDG Definition
	         var sText = sheetObj.GetComboInfo(row, col, "Text");
	         var arrText = sText.split("|");
	         var idx = sheetObj.GetComboInfo(row, col, "SelectedIndex");
	         if(idx != -1){
	             sheetObj.SetCellValue(row, 'sheet1_imdg_clss_cd_desc', arrText[idx]);
	         }
	         
	         var sCode = sheetObj.GetComboInfo(row,col, "Code"); 
	         var arrCode = sCode.split("|");
	         for(i=0; i<arrCode.length; i++) {
	             if(sheetObj.GetCellValue(row,col) == arrCode[i]) {
	                 if(arrCode[i].indexOf("1.") != -1){
	                	 sheetObjects[0].SetCellEditable(row, "sheet1_imdg_comp_grp_cd", 1); 	
	                 }else {
	                	 sheetObjects[0].SetCellValue(row, "sheet1_imdg_comp_grp_cd", "");
	                	 sheetObjects[0].SetCellEditable(row, "sheet1_imdg_comp_grp_cd", 0); 	
		             }
	             } 
	         }
	    break;
	    
	}
}

/**
 * event after saving
 */ 
function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	ComShowCodeMessage("SCG50043");	
	
	var oSObj = "";
	var oFObj = "";
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;
	oSObj = opener.getCurrentSheet();
	oFObj = opener.document.form;
	
	opener.doActionIBSheet(oSObj, oFObj, IBSEARCH);
}

/**
* event after retrieving
*/ 	
var oSheetObj="";
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	var opener = window.dialogArguments;
	if (!opener) opener=window.opener;
	if (!opener) opener = parent;
	oSheetObj=opener.getCurrentSheet();
	
	document.form.portLmtRepDesc.value = oSheetObj.GetCellText(oSheetObj.GetSelectRow(), "port_lmt_rep_desc");
	
	if (sheetObjects[0].RowCount() > 0) {
		for(var i=1; i <= sheetObj.RowCount(); i++){
			// Checking the IMDG CD
			var imdg_cd = sheetObjects[0].GetCellValue(i, "sheet1_imdg_clss_cd");
            if(imdg_cd.indexOf("1.") != -1){
	            sheetObjects[0].SetCellEditable(i, "sheet1_imdg_comp_grp_cd", 1); 	
            }else {
	            sheetObjects[0].SetCellEditable(i, "sheet1_imdg_comp_grp_cd", 0); 	
	        }
		}
	}
}
