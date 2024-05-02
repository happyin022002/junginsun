/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0053.js
*@FileTitle  : P/F SKD Creation (CCA)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

 // public variable
    var sheetObjects=new Array();
    var sheetCnt=0;
    var ydCdsArr=new Array();
    var beforeValue=null; //before change information
    // Event handler processing by button click event */
    document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        //if (!ComIsBtnEnable(srcName)) return;  
        if(ComGetBtnDisable(srcName)) return false; 
        switch(srcName) {
			case "btn_RowAdd":
				rowAdd(sheetObject1, sheetObject2, "", "btn_RowAdd");
				break;
			case "btn_RowInsert":
				rowAdd(sheetObject1, sheetObject2, "", "btn_RowInsert");
				break;
			case "btn_RowDelete":
				rowAdd(sheetObject1, sheetObject2, "", "btn_RowDelete");
				break;
			case "btn_Retrieve":
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
				break;
			case "btn_New":
				rowAdd(sheetObject1, sheetObject2, formObject, "btn_New");
				break;
			case "btn_Save":
				doActionIBSheet(sheetObject2, formObject, IBSAVE);
				break;
			case "btns_search":
				openLaneCdHelp(sheetObject2);
				break;		
			case "btns_search02":
				openPfLaneTypeCdHelp(sheetObject2);
				break;
			case "btn_Delete":
					doActionIBSheet(sheetObject1,formObject,REMOVE);
				break;	
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
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
	initControl();
	document.form.vsl_slan_cd.focus();
	document.form.svc_dur_dys.value="0";
	if(sheetObjects[0].RowCount()== 0){
		sheetObjects[0].DataInsert(-1);
	}
}
/****************************************************************************************************************************************
 * registering initial event
 ****************************************************************************************************************************************/
function initControl() {
	var formObj=document.form;
//	axon_event.addListenerForm	('focus', 		'obj_focus', 	formObj);
//	axon_event.addListenerFormat('keypress', 	'obj_keypress', form);
	axon_event.addListenerForm	('keyup', 		'obj_keyup', 	form);
	axon_event.addListenerForm	('change', 		'obj_change', 	form);
}

/**
 * Handling key up event
 */
function obj_keyup(){
	var formObject=document.form;
    var sheetObject1=sheetObjects[0];
    if(sheetObjects[0].RowCount()== 0){
		sheetObjects[0].DataInsert(-1);
	}
    /*******************************************************/
	try {
		var eleObj=window.event.srcElement;
		var srcName=eleObj.getAttribute("name");
        switch(srcName) {
        	case "vsl_slan_cd":
				if(eleObj.value.length == 3){
					formObject.pf_svc_tp_cd.focus();
				}
				break;
        	case "pf_svc_tp_cd":
				if(eleObj.value.length == 4){
					sheetObject1.SetCellValue(1,"sheet1_pf_svc_tp_cd",formObject.pf_svc_tp_cd.value);
					formObject.slan_stnd_flg.focus();
				}
				break;
        	case "slan_stnd_flg":
        		sheetObject1.SetCellValue(1,"sheet1_slan_stnd_flg",formObject.slan_stnd_flg.value);
        		break;
        	case "svc_dur_dys":
        		sheetObject1.SetCellValue(1,"sheet1_svc_dur_dys",formObject.svc_dur_dys.value);
        		break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * Handling change event
 */
function obj_change(){
	var formObject=document.form;
    var sheetObject1=sheetObjects[0];
    if(sheetObject1.RowCount()== 0){
    	sheetObject1.DataInsert(-1);
	}
    /*******************************************************/
	try {
		var srcName=ComGetEvent("name");
        switch(srcName) {
        	case "vsl_slan_cd":
        		var	vslSlanCd=formObject.vsl_slan_cd.value;
        		
        		sheetObject1.RemoveAll();
        		sheetObjects[1].RemoveAll();
        		formObject.pf_svc_tp_cd.value="";
        		formObject.slan_stnd_flg.value="N";
        		formObject.svc_dur_dys.value="0";
        		formObject.cre_dt.value="";
        		formObject.upd_dt.value="";
        		
        		if(VskIsNull(vslSlanCd)) {return;}
	        	var sXml=doActionIBSheet(sheetObjects[0], formObject, SEARCH03);
	        	var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
	  		  	var vslSvcTpCd=ComGetEtcData(sXml, "checkLaneTpCd");
	  		  	var fdrDivCd=ComGetEtcData(sXml, "checkFdrDivCd");
	  		  	var dirCds=ComGetEtcData(sXml, "checkDirCd");
	  		  	sheetObjects[1].SetColProperty("sheet2_skd_dir_cd", {ComboText:dirCds, ComboCode:dirCds} );
				if(vslSlanNm == ""){
					formObject.vsl_slan_cd.value="";
					formObject.pf_svc_tp_cd.value="";
					formObject.vsl_slan_cd.focus();
					ComShowCodeMessage('VSK00021', vslSlanCd);
				}else{
					// available Lane
					// 1. in case VSL_SVC_TP_CD is 'O'
					// 2. in case VSL_SVC_TP_CD is not 'O', FDR_DIV_CD is 'O' -- BY HWANG COMMENT 
					// if(vslSvcTpCd == "O" || 
					//		(vslSvcTpCd != "O" && fdrDivCd == "O")){
					//	formObject.pf_svc_tp_cd.focus();
					if(vslSvcTpCd == "O" ){
						formObject.pf_svc_tp_cd.focus();
					}else{
						formObject.vsl_slan_cd.value="";
						formObject.pf_svc_tp_cd.value="";
						formObject.vsl_slan_cd.focus();
						ComShowCodeMessage('VSK00039');
					}
				}
				sheetObject1.SetCellValue(1,"sheet1_vsl_slan_cd",vslSlanCd);
				break;
        } // end switch
	}catch(e) {
		if( e == "[object Error]") {
			ComShowCodeMessage('VSK00011');
		} else {
			ComShowMessage(e);
		}
	}
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
    	case "sheet1":      //sheet1 init
    	    with(sheetObj){
	          var HeadTitle="STATUS|VSL_SLAN_CD|PF_SVC_TP_CD|SLAN_STND_FLG|SVC_DUR_DYS|STND_SVC_SPD|BRTH_ITVAL_DYS|MML_USD_FLG|SIM_DT|SIM_NO|N1ST_VSL_CLSS_CD|N1ST_VSL_CLSS_KNT|N2ND_VSL_CLSS_CD|N2ND_VSL_CLSS_KNT|N3RD_VSL_CLSS_CD|N3RD_VSL_CLSS_KNT|CLPT_KNT|TTL_DIST|MAX_SPD|AVG_SPD|DELT_FLG|PF_SKD_RMK|CRE_DT|UPD_DT";
	          var headCount=ComCountHeadTitle(HeadTitle);
	          //(headCount, 0, 0, true);
	          var prefix="sheet1_";
	
	          SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
	
	          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	          var headers = [ { Text:HeadTitle, Align:"Center"} ];
	          InitHeaders(headers, info);
	
	          var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"stnd_svc_spd",      KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_itval_dys",    KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mml_usd_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_no",            KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_knt",          KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dist",          KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"max_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_skd_rmk",        KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"" } ];
	           
	          InitColumns(cols);
	
	          SetEditable(0);
	          SetWaitImageVisible(0);
	          SetVisible(0);
    	   }
		   break;
    case "sheet2":      //sheet1 init
        with(sheetObj){
        
	      var HeadTitle1="|Sel.|No.|DIR|Port Code|TMNL Code|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|Maneuvering|Maneuvering|Port\nTime|Port\nBuffer|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|In/Out Bound Cargo|TML Prod.|TML Prod.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	      var HeadTitle2="|Sel.|No.|DIR|Port Code|TMNL Code|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|In|Out|Port\nTime|Port\nBuffer|IPC|IPC|Ocean|Ocean|.|.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	      var HeadTitle3="||No.|DIR|Port Code|TMNL Code|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSpeed|Sea\nTime|Sea\nBuffer|Sea\nBuffer\nSpeed|In|Out|Port\nTime|Port\nBuffer|In|Out|In|Out|.|.|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	      var headCount=ComCountHeadTitle(HeadTitle1);
	      (headCount, 0, 0, true);
	      var prefix="sheet2_";
	
	      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	      var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	      var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"},
	                  { Text:HeadTitle3, Align:"Center"} ];
	      InitHeaders(headers, info);
	
	      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"row_seq",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:6 },
	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   InputCaseSensitive:1, EditLen:5 },
	             {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,  EditLen:5 },
	             {Type:"Int",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"zd",               KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etb_dy_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_dy_no",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Int",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:55,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_spd",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Int",      Hidden:1, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int",      Hidden:1, Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int",      Hidden:1, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int",      Hidden:1, Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
	             {Type:"Int",      Hidden:1, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Int",      Hidden:1, Width:35,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1 },
	             {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	       
	      InitColumns(cols);
	
	      SetEditable(1);
	      SetCountPosition(0);
	      SetWaitImageVisible(0);
	      SetColProperty(prefix+"skd_dir_cd", {ComboText:"S|N", ComboCode:"S|N"} );
	      SetColProperty(prefix+"yd_cd", {ComboText:"", ComboCode:""} );
	      SetColProperty(prefix+"etb_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	      SetColProperty(prefix+"etd_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	      SetColProperty(prefix+"turn_port_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
	      SetRowHeight(0,10);
	      SetRowHeight(1,10);
	      SetRowHeight(2,10);
	      resizeSheet();
	      }
          break;
    }
}
  // handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
//    alert(sAction);
    switch(sAction) { 
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction)){			
				ComOpenWait(true); 
				formObj.f_cmd.value=SEARCH;
		        var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix string array 
		        var	sParm = "f_cmd="         + formObj.f_cmd.value
						  + "&vsl_slan_cd="  + formObj.vsl_slan_cd.value
						  + "&pf_svc_tp_cd=" + formObj.pf_svc_tp_cd.value;				
		        var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParm + "&" + ComGetPrefixParam(aryPrefix));
		        
		        var arrXml=sXml.split("|$$|");
		    	submitFlg="Y";
		    	for(var inx=0; inx<arrXml.length; inx++){
		    		showSheetData(sheetObjects[inx],formObj,arrXml[inx], "N");
		    	}
		    	ComOpenWait(false);
		    	//sheetObjects[1].RenderSheet(0);
				modifyPropertyByRow (sheetObjects[1]);
				//sheetObjects[1].RenderSheet(1);
			}
			break;
		case SEARCH02:
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH02;
//			var loc_cd = formObj.port_cd.value;
			var sParam="f_cmd=" + formObj.f_cmd.value + 
						"&loc_cd=" + formObj.port_cd.value;
//			var sParam = FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet2_");
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?loc_cd="+loc_cd, sParam);
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParam);
//			alert(sParam);
//			alert(sXml);
			ComOpenWait(false);
			return sXml;
			break;
		case SEARCH03:		// Lane Code change시
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH03;
//			var sParam = FormQueryString(formObj);
//			var vslSlanCd  = formObj.vsl_slan_cd.value;
			var sParam="f_cmd="+ formObj.f_cmd.value + 
						"&vsl_slan_cd="+ formObj.vsl_slan_cd.value;
//			var sXml = sheetObj.GetSearchXml("VOP_VSK_0053GS.do?vslSlanCd="+vslSlanCd, sParam);
//parameter changed[check again]CLT 			
			var sXml=sheetObj.GetSearchData("VOP_VSK_0053GS.do", sParam);
//			alert(sParam);
//			alert(sXml);
			ComOpenWait(false);
			return sXml;
			break;
		case SEARCH04:
			ComOpenWait(true);
			formObj.f_cmd.value = COMMAND13;
			var sParam = "f_cmd="   + formObj.f_cmd.value + 
					     "&loc_cd=" + formObj.port_cd.value;
			var sXml = sheetObj.GetSearchData("VSK_GLOGS.do", sParam);
			ComOpenWait(false);
			return sXml;
			break;
		case REMOVE:
			if((VskIsNull(formObj.vsl_slan_cd.value)) || (formObj.vsl_slan_cd.value.length < 3 )){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.value="";
				formObj.vsl_slan_cd.focus();
				return ;
			}
			if(VskIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return ;
			}
			if(!ComShowConfirm(ComGetMsg("VSK00005"))){
				return
			}
			if(validateForm(sheetObj,formObj, sAction)){
				//sheetObj : first sheetObject
			   sheetObj.SetRowStatus(1,"D");
			   ComOpenWait(true);
			   formObj.f_cmd.value=REMOVE;
			   var SaveStr=ComGetSaveString(sheetObjects);
			   var aryPrefix=new Array("sheet1_");
			   var sXml=sheetObj.GetSaveData("VOP_VSK_0053GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
			   if(sXml.length>0) sheetObj.LoadSearchData(sXml,{Sync:1} );
			   if(!VskGetErrorXml(sXml)){
				  rowAdd( sheetObjects[0], sheetObjects[1], formObj, "btn_New");
			   }
			   ComOpenWait(false);
			}
			break;
		case IBSAVE:        //Save
			if(validateForm(sheetObj,formObj,sAction)){
				sheetObjects[0].SetRowStatus(1,"I");
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
	     	   	var SaveStr=ComGetSaveString(sheetObjects);
	     	   	var aryPrefix=new Array("sheet1_", "sheet2_");
	     	   	var sXml=sheetObj.GetSaveData("VOP_VSK_0053GS.do", SaveStr + "&" + FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix));
	     	   	sheetObjects[1].CheckAll("sheet2_Sel",0);
	     	    ComOpenWait(false);
				sheetObj.LoadSaveData(sXml);
				var nodeText =  ComGetSelectSingleNode(sXml, "TR-ALL")
				//if(nodeText == "OK"){
				//	doActionIBSheet(sheetObj, formObj, IBSEARCH);
				//}
			}
			break;
    }
}
/**
 * process after retrieve.
 * @param sheetObj
 * @param formObj
 * @param sXml
 * @return
 */
function showSheetData(sheetObj, formObj, sXml){
	var prefix=sheetObj.id + "_";
	switch(sheetObj.id){
		case "sheet1":
			
//			var xmlDoc = ComGetXmlDoc(sXml);
//			if (xmlDoc == null) return;
//			var xmlRoot = xmlDoc.documentElement;
//			
			//var dataNode=xmlRoot.selectSingleNode("//DATA/'TOTAL");
			var totValue =  ComGetSelectSingleNode(sXml, "TOTAL")
			
			if(totValue){
				//var totValue=dataNode.value;
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				if (sheetObj.RowCount() == 0 ) return;
				
				if(totValue > 0){
					formObj.vsl_slan_cd.value   = sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
					formObj.slan_stnd_flg.value = sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
					formObj.pf_svc_tp_cd.value  = sheetObj.GetCellValue(1,prefix+"pf_svc_tp_cd");
					formObj.svc_dur_dys.value   = sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
					formObj.cre_dt.value        = sheetObj.GetCellValue(1,prefix+"cre_dt");
					formObj.upd_dt.value        = sheetObj.GetCellValue(1,prefix+"upd_dt");
					
					var ydCds=ComGetEtcData(sXml, "ydCd").split("|");
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i]=ydCds[i];
						}
					}
					var etcdts=ComGetEtcData(sXml, "etcdt");
					formObj.min_max_spd.value=etcdts;
					
				
					var chkVslSkd = ComGetEtcData(sXml, "chkVslSkd");
					formObj.check_vsl_skd.value=chkVslSkd;
					
				}
				/*else{
					rowAdd(sheetObjects[0], sheetObjects[1], "", "btn_RowInsert");
				}*/
			}
			
		break;
		case "sheet2":
			
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			if (sheetObj.RowCount() > 0) {
				sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"etb_dy_no","0");
				sheetObj.SetCellEditable(sheetObj.GetSelectRow(), prefix+"etb_dy_no",0);
			
				setTportIndEditable(sheetObj);
			}
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
		break;
	}
}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) 
{
	formObj = document.form;
	prefix = sheetObj.id+"_";

	if(sheetObj.RowCount()> 0){
		sheetObjects[1].CheckAll("sheet2_Sel",0);
		for(var i=0; i<sheetObj.RowCount(); i++){
			sheetObj.CellComboItem(sheetObj.HeaderRows()+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
			sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//    		sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
			sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
		}
		
		if(formObj.check_vsl_skd.value == "Y") {
			ComBtnDisable("btn_RowAdd");
			ComBtnDisable("btn_RowInsert");
			ComBtnDisable("btn_RowDelete");
			ComBtnDisable("btn_Delete");
			ComShowCodeMessage("VSK00083");
			sheetObj.SetEditable(0);
			//formObj.brth_itval_dys.disabled=true;
		}else{
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowInsert");
			ComBtnEnable("btn_RowDelete");
			ComBtnEnable("btn_Delete");
			
			sheetObj.SetEditable(1);
		}
	}
	//sheetObj.RenderSheet(1);
	
	
}


/***
 * Handling key up event in sheet2
 * 
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet2_OnKeyUp(sheetObject, Row, Col, KeyCode) {
	var prefix=sheetObject.id + "_";
	var colSaveName=sheetObject.ColSaveName(Col);
	if (KeyCode == 46) { // Del Key. (Initializing)
		switch (colSaveName){
		case prefix+"etb_tm_hrmnt" :	//etb_tm_hrmnt
			sheetObject.SetCellValue(Row, Col,"00:00",0);
			break;
		case prefix+"etd_tm_hrmnt" :	//etd_tm_hrmnt
			sheetObject.SetCellValue(Row, Col,"00:00",0);
			break;	
		}
	}	
}
/**
 * Handling click event in sheet2
 * 
 * @param sheetObject
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnClick(sheetObject, Row, Col) {
	var formObj=document.form;
	var sXml=null;
	var prefix=sheetObject.id + "_";
	var colSaveName=sheetObject.ColSaveName(Col);
	if(Row == 0 || Col == 0){return;}
	switch(colSaveName){
	case prefix+"yd_cd":
		var portCd=sheetObject.GetCellValue(Row, prefix+"port_cd");
		var idx=sheetObject.GetComboInfo(Row, Col, "SelectedIndex");
		var	sCode=sheetObject.GetComboInfo(Row, Col, "Code");
		if (VskIsNull(portCd))		 {return;}
		if (sCode.indexOf("|") > -1) {return;}
		formObj.port_cd.value=portCd;
		sXml=doActionIBSheet(sheetObject, formObj, SEARCH02);
		setSheetComboSinc(sXml, sheetObject, Row, Col);
		break;
	}
}
/**
 * Handling before edit event in sheet2
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnBeforeEdit(sheetObj, Row, Col){	
	beforeValue=sheetObj.GetCellValue(Row, Col);
}
/**
 * Handling after edit event in sheet2
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet2_OnAfterEdit(sheetObj, Row, Col){
	var colSaveName=sheetObj.ColSaveName(Col);
	var prefix=sheetObj.id + "_";
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var ttlCnt=headCnt+rowCnt;	
	var oldValue;
	var newValue;
	switch(colSaveName){
		case prefix+"etb_tm_hrmnt":
			if (VskIsNull(sheetObj.GetCellValue(Row, Col))){
				sheetObj.SetCellValue(Row, Col,beforeValue,0);
			}
			break;
		case prefix+"etd_tm_hrmnt":
			if (VskIsNull(sheetObj.GetCellValue(Row, Col))){
				sheetObj.SetCellValue(Row, Col,beforeValue,0);
			}
			break;
		case prefix+"etb_dy_no":
			if(headCnt!=Row){return;}	// Setting ETB No only in first row
			var tempEtbDyNo=parseInt(sheetObj.GetCellValue(Row, Col));
			if(beforeValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(beforeValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(Row, Col));
			if(tempEtbDyNo != 0 && tempEtbDyNo != 1){
				sheetObj.SetCellValue(Row, Col,oldValue,0);
				ComShowCodeMessage("VSK00041");
				return;
			}
			break;
		case  prefix+"etb_dy_no":	
			if(headCnt==Row){return;}
			if(beforeValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(beforeValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(Row, Col));
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(Row, Col,oldValue,0);
				calDayByNo(sheetObj, Row, Col);
				return;
			}
			break;
		case  prefix+"etd_dy_no":
			if(beforeValue==""){
				oldValue=0;
			}else{
				oldValue=parseInt(beforeValue);
			}
			newValue=parseInt(sheetObj.GetCellValue(Row, Col));
			if(newValue<0){
				ComShowCodeMessage("VSK00102");
				sheetObj.SetCellValue(Row, Col,oldValue,0);
				calDayByNo(sheetObj, Row, Col);
				return;
			}
			break;
	}
}
/**
 * Handling change event in sheet2
 * 
 * @param sheetObj
 * @param Row
 * @param Col
 * @param Value
 * @return
 */
function sheet2_OnChange(sheetObj, Row, Col, Value) {
	var colSaveName = sheetObj.ColSaveName(Col);
	var prefix      = sheetObj.id + "_";
	var formObj     = document.form;
	var headCnt     = sheetObj.HeaderRows();
	var rowCnt      = sheetObj.RowCount();
	var ttlCnt		= sheetObj.LastRow();
	
	var firEtbDay	= sheetObj.GetCellValue(headCnt, prefix+"etb_dy_cd");
	var firEtdNo	= sheetObj.GetCellValue(headCnt, prefix+"etd_dy_no");
	var firEtdDay	= sheetObj.GetCellValue(headCnt, prefix+"etd_dy_cd");
	var firEtbTime	= sheetObj.GetCellValue(headCnt, prefix+"etb_tm_hrmnt");
	var firEtdTime	= sheetObj.GetCellValue(headCnt, prefix+"etd_tm_hrmnt");
	
	if(Row <= 2){ return;}
	switch(colSaveName) {
	case prefix+"skd_dir_cd":	//skd_dir_cd
			for(var i=Row; i<=ttlCnt; i++){
				sheetObj.SetCellValue(i, prefix+"skd_dir_cd",Value,0);
			}
			modifyPropertyByRow(sheetObjects[1]);
			break;
	case prefix+"port_cd":	//port_cd
			var tempVal = Value;
			if (tempVal.length == 0) {
				return;
			}
			if (tempVal.length == 5) {
				formObj.port_cd.value=tempVal;		
				sXml=doActionIBSheet(sheetObj, formObj, SEARCH02);
				var chkPort=ComGetEtcData(sXml, "check_port");
				//(Yard) exist
				if(chkPort == "X"){
					if(VskIsNotNull(sXml)){
						//var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
						//xmlDoc.loadXML(sXml);
						//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
						
						var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL")
						if(dataNode){
							var totValue=dataNode;
							if(totValue > 0){
								sheetObj.SetCellValue(Row, prefix+"yd_cd","",0);
								setSheetComboSinc(sXml, sheetObj, Row, Col);
							}else{
								sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
							}
						}
					}
				}else{
					sheetObj.SetCellValue(Row, Col,"");
					sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
					ComShowCodeMessage('VSK00029', Value);
					sheetObj.SelectCell(Row, Col-1, true);
				}
			}else{
				sheetObj.SetCellValue(Row, Col,"");
				sheetObj.CellComboItem(Row,prefix+"yd_cd", {ComboText:"", ComboCode:""} );
				ComShowCodeMessage('VSK00029', tempVal);
				sheetObj.SelectCell(Row, Col-1, true);
			}
			break;
		case prefix+"yd_cd" :	//yd_cd		
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			setTportIndEditable(sheetObj);
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
			break;
		case prefix+"etb_dy_no" :	//etb_dy_no
			if((headCnt==Row) && !(Value == 0 || Value == 1)){return;}
			calDayByNo(sheetObj, Row, Col);
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			setDuration(sheetObj,formObj);
			setEtdCellValue(sheetObj, Row);
			calDayByNo(sheetObj, Row, 10);
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
			break;
		case prefix+"etb_dy_cd" :	//etb_dy_cd
			if(headCnt!=Row){return;}
			calDayByNo(sheetObj, Row, Col);			
			break;
		case prefix+"etb_tm_hrmnt" :	//etb_tm_hrmnt
			var etbTime=sheetObj.GetEditText();
			if(ComChkLen(etbTime,4) == 2){
				sheetObj.SelectCell(Row, 10, true);
			}
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			setDuration(sheetObj,formObj);
			
			setEtdCellValue(sheetObj, Row);
			calDayByNo(sheetObj, Row, 10);
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
			break;
		case prefix+"etd_dy_no" :	//etd_dy_no
			calDayByNo(sheetObj, Row, Col);
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			setDuration(sheetObj,formObj);
			setEtdCellValue(sheetObj, Row);
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
			break;
		case prefix+"etd_tm_hrmnt" :	//etd_dy_no
			var etdTime=sheetObj.GetEditText();
			if(ComChkLen(etdTime,4) == 2){
				sheetObj.SelectCell(Row, 28, true);
			}
			//::FOR.NYK.START::by dongsoo:2014-10-01:://
			setDuration(sheetObj,formObj);
			setEtdCellValue(sheetObj, Row);
			//::FOR.NYK.FINISH::by dongso:2014-10-01:://
			break;
	} //end switch문
}

function setEtdCellValue(sheetObj, Row) {
	
	var prefix      = sheetObj.id + "_";
	var formObj     = document.form;
	var headCnt     = sheetObj.HeaderRows();
	var rowCnt      = sheetObj.RowCount();
	var ttlCnt		= sheetObj.LastRow();
	
	var firEtbNo	= sheetObj.GetCellValue(headCnt, prefix+"etb_dy_no");
	var firEtdNo	= sheetObj.GetCellValue(headCnt, prefix+"etd_dy_no");
	var firEtbTime	= sheetObj.GetCellValue(headCnt, prefix+"etb_tm_hrmnt");
	var firEtdTime	= sheetObj.GetCellValue(headCnt, prefix+"etd_tm_hrmnt"); 
	
	var modFlag = (checkDirMode(sheetObj) == "TWO") ? true : false;
	if (modFlag && ((ttlCnt == Row) || (headCnt == Row))) {
		var calEtbTime 	   = calcETBETD(firEtbNo,firEtbTime);
		var calEtdTime 	   = calcETBETD(firEtdNo,firEtdTime);				
		var calBetween     = (Number(calEtdTime) - Number(calEtbTime)) * 60;
		var curEtbTime     = sheetObj.GetCellValue(ttlCnt, prefix+"etb_tm_hrmnt");
		var curEtbDyNo     = sheetObj.GetCellValue(ttlCnt, prefix+"etb_dy_no");
		var calAddEtdTime  = VskGetAddedTimeByMin(ComGetDateAdd(null, "D", sheetObj.GetCellValue(ttlCnt, prefix+"etb_dy_no")).replace(/-/g,"") + curEtbTime, calBetween, true) ;
		
	
		//var firEtbBetween  = ComGetDateAdd(null, "D", firEtbNo).replace(/-/g,"") + firEtbTime;
		//var firEtdBetween  = ComGetDateAdd(null, "D", firEtdNo).replace(/-/g,"") + firEtdTime;
		//var calEtdDay      = ComGetDaysBetween(firEtbBetween, firEtdBetween);
		var lstEtbDate     = ComGetDateAdd(null, "D", curEtbDyNo).replace(/-/g,"") + curEtbTime;
		var calEtdDay      = ComGetDaysBetween(lstEtbDate.substring(0,8), calAddEtdTime.substring(0,8));
		
		sheetObj.SetCellValue(ttlCnt, prefix+"etd_dy_no"     , Number(sheetObj.GetCellValue(ttlCnt, prefix+"etb_dy_no")) + Number(calEtdDay));
		sheetObj.SetCellValue(ttlCnt, prefix+"etd_dy_cd",sheetObj.GetCellValue(headCnt, prefix+"etd_dy_cd"));
		sheetObj.SetCellValue(ttlCnt, prefix+"etd_tm_hrmnt"  , calAddEtdTime.substring(8).replace("2400","0000")); 
		
		
	}
}

function setTportIndEditable(sheetObj) {
	
	var prefix  = sheetObj.id + "_";
	var headCnt = sheetObj.HeaderRows();
	var rowCnt  = sheetObj.RowCount();
	var ttlCnt  = headCnt + rowCnt;
	var modFlag = (checkDirMode(sheetObj) == "TWO") ? true : false;
	
	var portFlg = "";
//	for (var nRow = headCnt; nRow < ttlCnt; nRow++) {
//		portFlg = sheetObj.GetCellValue(nRow, prefix+"turn_port_flg");
//		sheetObj.SetCellEditable(nRow, prefix+"turn_port_flg", modFlag);
//		sheetObj.SetCellValue   (nRow, prefix+"turn_port_flg", (modFlag) ? portFlg : "N");
//	}
	
	if (!modFlag) return;
	
	var firDir  = sheetObj.GetCellValue(headCnt , prefix+"skd_dir_cd");
	var firYdCd = sheetObj.GetCellValue(headCnt , prefix+"yd_cd");
	var firPort = sheetObj.GetCellValue(headCnt , prefix+"port_cd");
	var lstDir  = sheetObj.GetCellValue(ttlCnt-1, prefix+"skd_dir_cd");
	var lstYdCd = sheetObj.GetCellValue(ttlCnt-1, prefix+"yd_cd");
	var lstPort = sheetObj.GetCellValue(ttlCnt-1, prefix+"port_cd");
	if (ttlCnt > headCnt) {
		if (firDir != lstDir && firPort == lstPort && firYdCd == lstYdCd) {
			sheetObj.SetCellEditable(ttlCnt-1, prefix+"turn_port_flg",0);
		}
	}
}

/**
 * Handling Terminal Code of SHEET2 Event
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var ydKindCode=ComGetEtcData(xmlStr, "yd_kind");
	var ydNm=ComGetEtcData(xmlStr, "yd_nm");
	var ydTxt="";
	if(VskIsNotNull(ydKindCode)){
		var ydKindCodeArr=ydKindCode.split("|");
		var ydNmArr=ydNm.split("|");
		var ydCnt=ydKindCodeArr.length;
		ydTxt=ydKindCodeArr[0] + "\t" + ydNmArr[0];
		for(var i=1; i<ydCnt; i++){
			ydTxt=ydTxt + "|" + ydKindCodeArr[i] + "\t" + ydNmArr[i];
		}
		sheetObject.CellComboItem(Row,sheetObject.id+"_yd_cd", {ComboText:ydTxt, ComboCode:ydKindCode} );
	}
}
/**
 * Changing Row Color, Back Color, etc.
 * @param sheetObj
 * @return
 */
function modifyPropertyByRow(sheetObj) {
	var headCnt    = sheetObj.HeaderRows();
	var rowCnt     = sheetObj.RowCount();
	var totalCnt   = sheetObj.LastRow();
	var prefix     = "sheet2_";
	var grayColor  = "#F5F5F5";
	var withrColor = "#FFFFFF";
	var blackColor = "#000000";	
	//::FOR.NYK.START::by dongsoo:2014-10-01:://
	var	modFlag    = (checkDirMode(sheetObj) == "TWO") ? true : false;
	
	for(var nRow = headCnt; nRow <= totalCnt; nRow++) {
		
		if (nRow == headCnt) {
			sheetObj.SetCellEditable(nRow, prefix+"etb_dy_cd",1);
		} else if (nRow == totalCnt) {
			if (checkDirMode(sheetObj)=="TWO") {		// two direction
				
				sheetObj.SetCellEditable(nRow, prefix+"etd_dy_no"       , 0);
				sheetObj.SetCellEditable(nRow, prefix+"etd_tm_hrmnt" 	, 0);
				sheetObj.SetCellEditable(nRow, prefix+"turn_port_flg" 	, 0);
								
				//sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_no" 		, sheetObj.GetCellBackColor(nRow, prefix+"etd_dy_no"));
				//sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_cd" 		, sheetObj.GetCellBackColor(nRow, prefix+"etd_dy_cd"));
				//sheetObj.SetCellFontColor(nRow, prefix+"etd_tm_hrmnt"  	, sheetObj.GetCellBackColor(nRow, prefix+"etd_tm_hrmnt"));
				//sheetObj.SetCellFontColor(nRow, prefix+"turn_port_flg" 	, sheetObj.GetCellBackColor(nRow, prefix+"turn_port_flg"));
				sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_no" 		, grayColor);      
				sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_cd" 		, grayColor);
				//sheetObj.SetCellFontColor(nRow, prefix+"etb_dy_cd" 		, grayColor);
				sheetObj.SetCellFontColor(nRow, prefix+"etd_tm_hrmnt"  	, grayColor);   
				sheetObj.SetCellFontColor(nRow, prefix+"turn_port_flg" 	, grayColor);  
			} else {	// one direction
				sheetObj.SetCellEditable(nRow, prefix+"etd_dy_no"       , 1);
				sheetObj.SetCellEditable(nRow, prefix+"etd_tm_hrmnt" 	, 1);
				sheetObj.SetCellEditable(nRow, prefix+"turn_port_flg" 	, 1);
				
				sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_no" 		, blackColor);
				sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_cd" 		, blackColor);
				sheetObj.SetCellFontColor(nRow, prefix+"etd_tm_hrmnt"  	, blackColor);
				sheetObj.SetCellFontColor(nRow, prefix+"turn_port_flg" 	, blackColor);
			}
		} else {
			sheetObj.SetCellEditable(nRow, prefix+"etd_dy_no"	 		, 1);
			sheetObj.SetCellEditable(nRow, prefix+"etd_dy_cd" 			, 0);
			sheetObj.SetCellEditable(nRow, prefix+"etd_tm_hrmnt"		, 1);
			sheetObj.SetCellEditable(nRow, prefix+"turn_port_flg"	 	, 1);
			
			sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_no"		 	, blackColor);
			sheetObj.SetCellFontColor(nRow, prefix+"etd_dy_cd"		 	, blackColor);
			sheetObj.SetCellFontColor(nRow, prefix+"etd_tm_hrmnt"		, blackColor);
			sheetObj.SetCellFontColor(nRow, prefix+"turn_port_flg"		, blackColor);
		}
	}
	//::FOR.NYK.FINISH::by dongso:2014-10-01:://
}
/**
 * Initializing screen, Row Add, Delete
 * @param sheetObj
 * @param formObj
 * @return
 */
function rowAdd(sheetObj1, sheetObj2, formObj, sAction){
	var sheetObj;
	var	i=0;
	switch (sAction) {
		case "btn_New" 		:
			formObj.vsl_slan_cd.value="";
			formObj.pf_svc_tp_cd.value="";
			formObj.slan_stnd_flg.value="N";
			formObj.svc_dur_dys.value="0";
			formObj.cre_dt.value="";
			formObj.upd_dt.value="";
			sheetObj1.RemoveAll();
			sheetObj2.RemoveAll();
			sheetObj=sheetObj2;
			ComBtnEnable("btn_RowAdd");
			ComBtnEnable("btn_RowInsert");
			ComBtnEnable("btn_RowDelete");
			ComBtnEnable("btn_Delete");
			formObj.vsl_slan_cd.focus();
			sheetObj.SetEditable(1);
			break;
			
			
		case "btn_RowInsert":
			sheetObj=sheetObj2;
			var rowIdx=sheetObj.GetSelectRow()+ sheetObj.HeaderRows()- 1;
			if(rowIdx){
				if(rowIdx > sheetObj.HeaderRows()){
					var selRow = sheetObj.DataInsert();
					sheetObj.SetCellValue(selRow, "etb_dy_no",0);
					sheetObj.SetCellValue(selRow, "etb_dy_cd","MON");
					sheetObj.SetCellValue(selRow, "etb_tm_hrmnt","00:00");
					sheetObj.SetCellValue(selRow, "etd_dy_no",0);
					sheetObj.SetCellValue(selRow, "etd_dy_cd","MON");
					sheetObj.SetCellValue(selRow, "etd_tm_hrmnt","00:00");
	
					if (insRow==headRows){
						var sText=sheetObj.GetComboInfo(3,3, "Text");
						var arrText=sText.substring(0,1);
						sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"skd_dir_cd",arrText);
						sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"etb_dy_no","0");
						sheetObj.SetCellEditable(sheetObj.GetSelectRow(), prefix+"etb_dy_no",0);
					}else{
						sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd",sheetObj.GetCellValue(insRow - 1, prefix+"skd_dir_cd"));
						}
					}
				}
			break;
		case "btn_RowAdd"	:
			sheetObj=sheetObj2;
			var rowIdx=sheetObj.GetSelectRow()- 1;
			var insRow=0;

			if (sAction == "btn_RowAdd"){
				insRow=sheetObj.DataInsert(-1);
			}
			else{
				insRow=sheetObj.DataInsert(-1);
			}
			var lastRow=searchLastRow(sheetObj);
			sheetObj.SetCellValue(insRow, prefix+"etb_dy_no",0);
			sheetObj.SetCellValue(insRow, prefix+"etb_dy_cd","MON");
			sheetObj.SetCellValue(insRow, prefix+"etb_tm_hrmnt","00:00");
			sheetObj.SetCellValue(insRow, prefix+"etd_dy_no",0);
			sheetObj.SetCellValue(insRow, prefix+"etd_dy_cd","MON");
			sheetObj.SetCellValue(insRow, prefix+"etd_tm_hrmnt","00:00");
			if (insRow==headRows){
				var sText=sheetObj.GetComboInfo(3,3, "Text");
				var arrText=sText.substring(0,1);
				sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"skd_dir_cd",arrText);
				sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"etb_dy_no","0");
				sheetObj.SetCellEditable(sheetObj.GetSelectRow(), prefix+"etb_dy_no",0);
			}else{
				sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd",sheetObj.GetCellValue(insRow - 1, prefix+"skd_dir_cd"));
				
				sheetObj.SetCellEditable(lastRow-1,prefix+"etd_dy_no",0);
				sheetObj.SetCellEditable(lastRow-1,prefix+"etd_dy_cd",0);
				sheetObj.SetCellEditable(lastRow-1,prefix+"etd_tm_hrmnt",0);
				
				sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_dy_no","#F5F5F5");
				sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_dy_cd","#F5F5F5");
				sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_tm_hrmnt","#F5F5F5");
			}
			break;
		case "btn_RowDelete":
			sheetObj=sheetObj2;
			break;
	}
	var headRows=sheetObj.HeaderRows();
	var dataRows=sheetObj.RowCount();
	var	ttlRows=headRows + dataRows;
	var prefix=sheetObj.id+"_";
	switch (sAction) {
	case "btn_RowDelete"	:
		var	selValue=false;
		for (i=headRows;i<ttlRows;i++ ){
			if (sheetObj.GetCellValue(i, prefix+"Sel")) {
				selValue=true;
				break;
			}
		}
		if (!selValue) {return;}
		if (ComShowConfirm(ComGetMsg("VSK00005"))) {
			for(i=sheetObj.LastRow(); i>=sheetObj.HeaderRows(); i-- ) {
				if(sheetObj.GetCellValue(i, prefix+"Sel")){
					sheetObj.RowDelete( i, false );
				}
			}
			sheetObj.CheckAll(prefix+"Sel",0);
		}
		if(sheetObj.GetSelectRow() == sheetObj.LastRow()){
            var formObject = document.form;
			calDayByNo(sheetObj, sheetObj.GetSelectRow(), 7);
			setDuration(sheetObj,formObject);
			setEtdCellValue(sheetObj, sheetObj.GetSelectRow());
			calDayByNo(sheetObj, sheetObj.GetSelectRow(), 10);
		} 
	break;
	//default:
//		var rowIdx=sheetObj.GetSelectRow()- 1;
//		var insRow=0;
//
//		if (sAction == "btn_RowAdd"){
//			insRow=sheetObj.DataInsert(ttlRows);
//		}
//		else{
//			insRow=sheetObj.DataInsert();
//		}
//		var lastRow=searchLastRow(sheetObj);
//		sheetObj.SetCellValue(insRow, prefix+"etb_dy_no",0);
//		sheetObj.SetCellValue(insRow, prefix+"etb_dy_cd","MON");
//		sheetObj.SetCellValue(insRow, prefix+"etb_tm_hrmnt","00:00");
//		sheetObj.SetCellValue(insRow, prefix+"etd_dy_no",0);
//		sheetObj.SetCellValue(insRow, prefix+"etd_dy_cd","MON");
//		sheetObj.SetCellValue(insRow, prefix+"etd_tm_hrmnt","00:00");
//		if (insRow==headRows){
//			var sText=sheetObj.GetComboInfo(3,3, "Text");
//			var arrText=sText.substring(0,1);
//			sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"skd_dir_cd",arrText);
//			sheetObj.SetCellValue(sheetObj.GetSelectRow()   , prefix+"etb_dy_no","0");
//			sheetObj.SetCellEditable(sheetObj.GetSelectRow(), prefix+"etb_dy_no",0);
//		}else{
//			sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix+"skd_dir_cd",sheetObj.GetCellValue(insRow - 1, prefix+"skd_dir_cd"));
//			/*
//			sheetObj.SetCellEditable(lastRow-1,prefix+"etd_dy_no",0);
//			sheetObj.SetCellEditable(lastRow-1,prefix+"etd_dy_cd",0);
//			sheetObj.SetCellEditable(lastRow-1,prefix+"etd_tm_hrmnt",0);
//			
//			sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_dy_no","#F5F5F5");
//			sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_dy_cd","#F5F5F5");
//			sheetObj.SetCellFontColor(lastRow-1,prefix+"etd_tm_hrmnt","#F5F5F5");*/
//		}
		sheetObj.SelectCell(insRow, prefix+"port_cd", true);
	}
	setClptSeq(sheetObj);
}

/**
 * Finding Last Row except Deleted Row
 * @param sheetObj
 * @return
 */
function searchLastRow(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var totalCnt=headCnt+rowCnt;
	var idx=0;
	var rtnIdx=0;
	var delCnt=0
	for(var i=totalCnt-1; i>headCnt-1; i--){
		if(sheetObj.GetCellValue(i, "sheet2_ibflag") != "D"){
			idx=i;
			rtnIdx=idx+1;
			break;
		}
	}
	return rtnIdx;
}
/**
 * Open Lane Code Help
 */
function openLaneCdHelp(sheetObj){
	var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd|sheet1_vsl_svc_tp_cd:vsl_svc_tp_cd";
	var v_display="0,0";
	var formObj=document.form;
	var laneCd=formObj.vsl_slan_cd.value;
	
	ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "returnSvcLaneCdHelp", v_display, true);
}

function returnSvcLaneCdHelp(rtnObjs){
	var formObj=document.form;
	var rtnDatas=rtnObjs[0];
	//alert( rtnDatas);
	if(rtnDatas.length > 0){
		formObj.vsl_slan_cd.value=rtnDatas[1]; //lane code
		formObj.vsl_svc_tp_cd.value= rtnDatas[3];
	}
		
    	var sXml=doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
    	var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
    	var vslSvcTpCd=ComGetEtcData(sXml, "checkLaneTpCd");
    	var fdrDivCd=ComGetEtcData(sXml, "checkFdrDivCd");
    	var dirCds=ComGetEtcData(sXml, "checkDirCd");
    	sheet2.SetColProperty("sheet2_skd_dir_cd", {ComboText:dirCds, ComboCode:dirCds} );
    	if(vslSlanNm == ""){
    		formObj.vsl_slan_cd.value="";
    		formObj.pf_svc_tp_cd.value="";
    		formObj.vsl_slan_cd.focus();
    		ComShowCodeMessage('VSK00021', rtnDatas[1]);
    	}else{
    		// available Lane
    		// 1. in case VSL_SVC_TP_CD is 'O'
    		// 2. in case VSL_SVC_TP_CD is not 'O', FDR_DIV_CD is 'O' -- BY HWANG COMMENT 
    		// if(vslSvcTpCd == "O" || 
    		//		(vslSvcTpCd != "O" && fdrDivCd == "O")){
    		//	formObject.pf_svc_tp_cd.focus();
    		if(vslSvcTpCd == "O" ){
    			formObj.pf_svc_tp_cd.focus();
    		}else{
    			formObj.vsl_slan_cd.value="";
    			formObj.pf_svc_tp_cd.value="";
    			formObj.vsl_slan_cd.focus();
    			ComShowCodeMessage('VSK00039');
    		}
    	}
    	sheet1.SetCellValue(1,"sheet1_vsl_slan_cd",rtnDatas[1]);
	  	/*var vslSvcTpCd=ComGetEtcData(sXml, "checkLaneTpCd");

		// available Lane
		// 1. in case VSL_SVC_TP_CD is 'O'
		// 2. in case VSL_SVC_TP_CD is not 'O', FDR_DIV_CD is 'O' -- BY HWANG COMMENT 
		// if(vslSvcTpCd == "O" || 
		//		(vslSvcTpCd != "O" && fdrDivCd == "O")){
		//	formObject.pf_svc_tp_cd.focus();
		if(vslSvcTpCd == "O" ){
			formObj.pf_svc_tp_cd.focus();
		}else{
			formObj.vsl_slan_cd.value="";
			formObj.pf_svc_tp_cd.value="";
			formObj.vsl_slan_cd.focus();
			ComShowCodeMessage('VSK00039');
		}
	}
	
	sheetObjects[0]=sheetObjects[0].RemoveAll();*/
	
}

/**
 * Open P/F Lane Type Code Help  
 */
function openPfLaneTypeCdHelp(sheetObj){
	 var targetObjList="sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display="0,0";
	 var laneCd=document.form.vsl_slan_cd.value;
	 ComOpenPopup('/opuscntr/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 620, 490, "getReturn0241", v_display, true);
}

function getReturn0241( rVal ){
	var formObj=document.form;
	var tmp = rVal[0];
	if( rVal != ""  || rVal != null ){
		
		formObj.pf_svc_tp_cd.value =tmp[3];
	}
	
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(ComIsNull(formObj.vsl_slan_cd.value)){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus();
				return false;
			}
			if(ComIsNull(formObj.pf_svc_tp_cd.value)){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus();
				return false;
			}
			break;
		case REMOVE:      //delete
//			if(sheetObj.CellValue(1,"sheet1_ibflag") == "I"){
			if(sheetObj.GetRowStatus(1) == "I"){
				ComShowCodeMessage("VSK00043");
				rowAdd(sheetObject1, sheetObject2, formObject, "btn_New");
				return false;
			}
			break;
		case IBSAVE:      //save
			var headRows	= sheetObj.HeaderRows();
			var dataRows	= sheetObj.RowCount();
			var lastRow		= sheetObj.LastRow();
			var prefix		= sheetObj.id + "_";
			var	i=0;
			
			if (dataRows == 0){
				ComShowCodeMessage('VSK00012');
				formObj.vsl_slan_cd.focus()
				return false;
			}
			if((VskIsNull(formObj.vsl_slan_cd.value)) || (formObj.vsl_slan_cd.value.length < 3 )){
				ComShowCodeMessage('VSK00027', "Lane Code");
				formObj.vsl_slan_cd.focus()
				return false;
			}
			if((VskIsNull(formObj.pf_svc_tp_cd.value)) || (formObj.pf_svc_tp_cd.value.length < 4 )){
				ComShowCodeMessage('VSK00027', "P/F SKD Type");
				formObj.pf_svc_tp_cd.focus()
				return false;
			}
			for(i=headRows;i<=lastRow; i++){
				if(sheetObj.GetCellValue(i, prefix+"skd_dir_cd").length < 1){
					ComShowCodeMessage("VSK01018", "Direction Code");
					sheetObj.SelectCell(i, prefix+"skd_dir_cd");
					return false;
				}
				if(sheetObj.GetCellValue(i, prefix+"port_cd").length < 5){
					ComShowCodeMessage("VSK01018", "Port Code");
					sheetObj.SelectCell(i, prefix+"port_cd");
					return false;
				}
				if(sheetObj.GetCellValue(i, prefix+"yd_cd").length < 2){
					ComShowCodeMessage("VSK01018", "Terminal Code");
					sheetObj.SelectCell(i, prefix+"yd_cd");
					return false;
				}					
			}
			
			setDuration(sheetObj,formObj);
			
			if(!checkDuration(sheetObj, formObj)){
				return false;
			}
			if(!checkEtbEtd(sheetObj)){
				return false;
			}
			if(!checkSave(sheetObj)){
				return false;
			}
			// Master 정보 Setting.
			var prefix="sheet1_"
				
			if (sheetObjects[0].RowCount() == 0) {
				sheetObjects[0].DataInsert(0);
			}
			sheetObjects[0].SetCellValue(1,prefix+"vsl_slan_cd",formObj.vsl_slan_cd.value,0);
			sheetObjects[0].SetCellValue(1,prefix+"slan_stnd_flg",formObj.slan_stnd_flg.value,0);
			sheetObjects[0].SetCellValue(1,prefix+"pf_svc_tp_cd",formObj.pf_svc_tp_cd.value,0);
			sheetObjects[0].SetCellValue(1,prefix+"svc_dur_dys",formObj.svc_dur_dys.value,0);
			break;
	}
    return true;
}
/**
 * Handling enter key
 */
//parameter changed[check again]CLT DoSearch("" );
//	var formObject=document.form;
//	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
//}
function checkEtbEtd(sheetObj){
	var	headRows=sheetObj.HeaderRows();
	var dataRows=sheetObj.RowCount();
	var lastRow=sheetObj.LastRow();
	var prefix=sheetObj.id + "_";
	var retrnFlg=true;
	var firEtbNo=sheetObj.GetCellValue(headRows, prefix+"etb_dy_no");
	var firEtbDay=sheetObj.GetCellValue(headRows, prefix+"etb_dy_cd");
	if(dataRows >= 2){
		for(var i=headRows;i<=lastRow; i++){
			if(i==headRows){ //first Row...
				var etbNo=sheetObj.GetCellValue(i, prefix+"etb_dy_no");
				var etbDay=sheetObj.GetCellValue(i, prefix+"etb_dy_cd");
				var etbTime=sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt");
				var etdNo=sheetObj.GetCellValue(i, prefix+"etd_dy_no");
				var etdDay=sheetObj.GetCellValue(i, prefix+"etd_dy_cd");
				var etdTime=sheetObj.GetCellValue(i, prefix+"etd_tm_hrmnt");
				var calEtbTime=calcETBETD(etbNo,etbTime);
				var calEtdTime=calcETBETD(etdNo,etdTime);
				if((calEtdTime-calEtbTime) < 0.001){
					ComShowCodeMessage("VSK00048", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
					retrnFlg=false;
					return;
				}
				if(!getCalWeek(firEtbNo,firEtbDay,etdNo,etdDay)){
					ComShowCodeMessage("VSK00049", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_cd",true);
					retrnFlg=false;
					return;
				}
			}else if(i == lastRow){
				var pastEtdNo=sheetObj.GetCellValue(i-1, prefix+"etd_dy_no");
				var pastEtdDay=sheetObj.GetCellValue(i-1, prefix+"etd_dy_cd");
				var pastEtdTime=sheetObj.GetCellValue(i-1, prefix+"etd_tm_hrmnt");
				var etbNo=sheetObj.GetCellValue(i, prefix+"etb_dy_no");
				var etbDay=sheetObj.GetCellValue(i, prefix+"etb_dy_cd");
				var etbTime=sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt");
				var etdNo=sheetObj.GetCellValue(i, prefix+"etd_dy_no");
				var etdDay=sheetObj.GetCellValue(i, prefix+"etd_dy_cd");
				var etdTime=sheetObj.GetCellValue(i, prefix+"etd_tm_hrmnt");
				var calEtdTime=calcETBETD(etdNo,etdTime);
				var calPastEtdTime=calcETBETD(pastEtdNo,pastEtdTime);
				var calEtbTime=calcETBETD(etbNo,etbTime);				
				//::FOR.NYK.START::by dongsoo:2014-09-30:://
				if (sheetObj.GetCellValue(i-1, prefix+"port_cd") == "WSAPW" ||
						sheetObj.GetCellValue(i, prefix+"port_cd") == "ASPPG") {
					
					var preZd = sheetObj.GetCellValue(i-1, prefix+"zd");
					var curZd = sheetObj.GetCellValue(i, prefix+"zd");
					
					if (preZd == 0 || curZd == 0) {
						formObj  = document.form;
						formObj.port_cd.value = sheetObj.GetCellValue(i-1, prefix+"port_cd");						
						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
						
						preZd = ComGetEtcData(sXml, "zd");
						formObj.port_cd.value = sheetObj.GetCellValue(i, prefix+"port_cd");
						 sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
						curZd = ComGetEtcData(sXml, "zd");
					}
					var calEtbZdTime  = calcETBETD(etbNo,etbTime) + (preZd - curZd) ;
					
					if(calEtbZdTime < (calPastEtdTime + 1)) {
						ComShowCodeMessage("VSK00050", sheetObj.GetCellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
						retrnFlg =  false;
						return;
					}
					//::FOR.NYK.FINISH::by dongso:2014-09-30:://
				} else {
					// Previous Port ETD + 1(hour) < Current ETB
					if(calEtbTime <= (calPastEtdTime + 1)){
						ComShowCodeMessage("VSK00050", sheetObj.GetCellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
						retrnFlg=false;
						return;
					}
				}
				if(!getCalWeek(firEtbNo,firEtbDay,etbNo,etbDay)){
					ComShowCodeMessage("VSK00049", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_cd",true);
					retrnFlg=false;
					return;
				}
				// Checking ETB/ETD of Last Row when direction is one
				if("ONE" ===checkDirMode(sheetObj)){
					if((calEtdTime - calEtbTime) < 0.001){
						ComShowCodeMessage("VSK00048", sheetObj.GetCellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
						retrnFlg=false;
						return;
					}
				}
			}else{
				var pastEtdNo   = sheetObj.GetCellValue(i-1, prefix+"etd_dy_no");
				var pastEtdDay  = sheetObj.GetCellValue(i-1, prefix+"etd_dy_cd");
				var pastEtdTime = sheetObj.GetCellValue(i-1, prefix+"etd_tm_hrmnt");
				var etbNo       = sheetObj.GetCellValue(i, prefix+"etb_dy_no");
				var etbDay      = sheetObj.GetCellValue(i, prefix+"etb_dy_cd");
				var etbTime     = sheetObj.GetCellValue(i, prefix+"etb_tm_hrmnt");
				var etdNo       = sheetObj.GetCellValue(i, prefix+"etd_dy_no");
				var etdDay      = sheetObj.GetCellValue(i, prefix+"etd_dy_cd");
				var etdTime     = sheetObj.GetCellValue(i, prefix+"etd_tm_hrmnt");
				
				var calEtbTime  = calcETBETD(etbNo,etbTime);
				var calEtdTime  = calcETBETD(etdNo,etdTime);
				var calPastEtdTime = calcETBETD(pastEtdNo,pastEtdTime);
				
				var calEtbTime  = calcETBETD(etbNo,etbTime);				
				//::FOR.NYK.START::by dongsoo:2014-09-30:://
				if (sheetObj.GetCellValue(i-1, prefix+"port_cd") == "WSAPW" ||
						sheetObj.GetCellValue(i, prefix+"port_cd") == "ASPPG") {
					
					var preZd = sheetObj.GetCellValue(i-1, prefix+"zd");
					var curZd = sheetObj.GetCellValue(i, prefix+"zd");
					
					if (preZd == 0 || curZd == 0) {
						formObj  = document.form;
						formObj.port_cd.value = sheetObj.GetCellValue(i-1, prefix+"port_cd");						
						var sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
						
						preZd = ComGetEtcData(sXml, "zd");
						formObj.port_cd.value = sheetObj.GetCellValue(i, prefix+"port_cd");
						 sXml = doActionIBSheet(sheetObj, formObj, SEARCH04);
						curZd = ComGetEtcData(sXml, "zd");
					}
					var calEtbZdTime  = calcETBETD(etbNo,etbTime) + (preZd - curZd) ;
					
					if(calEtbZdTime < (calPastEtdTime + 1)) {
						ComShowCodeMessage("VSK00050", sheetObj.GetCellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
						retrnFlg =  false;
						return;
					}
					//::FOR.NYK.FINISH::by dongso:2014-09-30:://
				} else {				
					// Previous Port ETD + 1(hour) < Current ETB
					if(calEtbTime <= (calPastEtdTime + 1)){
						ComShowCodeMessage("VSK00050", sheetObj.GetCellValue(i, prefix+"port_cd"));
						sheetObj.SelectCell(i,prefix+"etb_dy_no",true);
						retrnFlg=false;
						return;
					}
				}
				if((calEtdTime - calEtbTime) < 0.001){
					ComShowCodeMessage("VSK00048", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_no",true);
					retrnFlg=false;
					return;
				}
				if(!getCalWeek(firEtbNo,firEtbDay,etbNo,etbDay)){
					ComShowCodeMessage("VSK00049", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etb_dy_cd",true);
					retrnFlg=false;
					return;
				}
				if(!getCalWeek(firEtbNo,firEtbDay,etdNo,etdDay)){
					ComShowCodeMessage("VSK00049", sheetObj.GetCellValue(i, prefix+"port_cd"));
					sheetObj.SelectCell(i,prefix+"etd_dy_cd",true);
					retrnFlg=false;
					return;
				}
			}
		}
	}else{
		ComShowCodeMessage("VSK50011");
		retrnFlg=false;
	}
	return retrnFlg;
}
/**
 * Checking ETB,ETD
 * @param sheetObj
 * @param formObj
 * @return
 */
function calcETBETD(valNo,valTime){
	var tempValNo=parseInt(valNo);
	var tempValTime=valTime;
	var tempvalHrmnt=tempValTime.length;
	var tempvalTimeVal=0;
	var tempvalHrmntVal=0; 
	tempvalTimeVal=tempValTime.substring(0,2);
	tempvalHrmntVal=tempValTime.substring(2,4);
	tempvalHrmntVal=tempvalHrmntVal/100;
	var totNo=tempValNo * 24;
	var tot=Number(totNo) + Number(tempvalTimeVal);
	tot=tot + Number(tempvalHrmntVal);
	return tot;
}
function getCalWeek(firEtbNo,etbDay,valNo,valDay){
	var dayCd=new Array("SUN","MON","TUE","WED","THU","FRI","SAT");
	var returnFlg=false;
	var reVal;
	var currPos;
	var nextPos;
	var gabNo=parseInt(valNo - firEtbNo);
	for(var i=0; i<dayCd.length; i++){
		if(etbDay == dayCd[i]){
			currPos=i;
		}
	}
	nextPos=parseInt(currPos + gabNo);
	reVal=nextPos % 7;
	if(valDay == dayCd[reVal]){
		returnFlg=true; 
	}
	return returnFlg;
}
/**
 * in case ETB No. Day of first row change, Changing automatically Day with Port No 
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function calDayByNo(sheetObj, Row, Col){
	var headCnt=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var ttlCnt=sheetObj.LastRow();
	var prefix=sheetObj.id + "_";
	var dayCd=new Array("SUN","MON","TUE","WED","THU","FRI","SAT");
	var firEtbNo=sheetObj.GetCellValue(headCnt, prefix+"etb_dy_no");
	var firEtbDay=sheetObj.GetCellValue(headCnt, prefix+"etb_dy_cd");
	var currPos=0;
	var nextPos=0;
	var valNo=0;
	var	reVal=0;
	var gabNo=0;
	for(var i=0; i<dayCd.length; i++){
		if(firEtbDay == dayCd[i]){
			currPos=i;
		}
	}	
	if (headCnt == Row) {
		for(var i=Row; i<=ttlCnt; i++){
			if (i != headCnt){
				valNo=sheetObj.GetCellValue(i, prefix+"etb_dy_no");
				gabNo=parseInt(valNo - firEtbNo);		
				nextPos=parseInt(currPos + gabNo);
				reVal=nextPos % 7;
				sheetObj.SetCellValue(i, prefix+"etb_dy_cd",dayCd[reVal],0);
			}
			valNo=sheetObj.GetCellValue(i, prefix+"etd_dy_no");
			gabNo=parseInt(valNo - firEtbNo);		
			nextPos=parseInt(currPos + gabNo);
			reVal=nextPos % 7;
			sheetObj.SetCellValue(i, prefix+"etd_dy_cd",dayCd[reVal],0);
		}
	} else{
		switch (Col){
		case 7 :	//etb_dy_no
			valNo=sheetObj.GetCellValue(Row, prefix+"etb_dy_no");
			gabNo=parseInt(valNo - firEtbNo);		
			nextPos=parseInt(currPos + gabNo);
			reVal=nextPos % 7;
			sheetObj.SetCellValue(Row, prefix+"etb_dy_cd",dayCd[reVal],0);
		break;9
		case 10 :	//etd_dy_no
			valNo=sheetObj.GetCellValue(Row, prefix+"etd_dy_no");
			gabNo=parseInt(valNo - firEtbNo);		
			nextPos=parseInt(currPos + gabNo);
			reVal=nextPos % 7;
			sheetObj.SetCellValue(Row, prefix+"etd_dy_cd",dayCd[reVal],0);
		break;
		}
	}
}
/**
 * Creating CLPT_SEQ in order
 * @param sheetObj
 * @return
 */
function setClptSeq(sheetObj){
	var headCnt=sheetObj.HeaderRows();
	var lastRow=sheetObj.LastRow();
	var prefix=sheetObj.id + "_";
	var idx=0;
	for(var i=headCnt; i<= lastRow; i++){
		sheetObj.SetCellValue(i, prefix+"row_seq",++idx,0);
	}
	modifyPropertyByRow(sheetObj); // Doing because fisrt ETB Day Setting
}
/** Checking Direction whether ONE or TWO
 *  
 * @param sheetObj
 * @return rtnValue
 */
function checkDirMode(sheetObj){
	var headRows=sheetObj.HeaderRows();
	var rowCnt=sheetObj.RowCount();
	var lastCnt=sheetObj.LastRow();
	var prefix="sheet2_";
	var firstDirCd="";
	var	rtnValue="ONE";
	if(rowCnt != 0){
		firstDirCd=sheetObj.GetCellValue(headRows, prefix+"skd_dir_cd");
		for(var k=headRows; k<=lastCnt; k++){
			if(sheetObj.GetCellValue(k, prefix+"skd_dir_cd") != firstDirCd){
				rtnValue="TWO";
				break;
			}
		}
	}
	return rtnValue;
}
/**
 * Checking befor save
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function checkSave(sheetObj){
	var headRows=sheetObj.HeaderRows();
	var dataRows=sheetObj.RowCount();
	var lastRows=sheetObj.LastRow();
	var prefix="sheet2_";
	var dirConfig=checkDirMode(sheetObj);
	if(dirConfig == "TWO"){ //two direction
		var firstPortDirCd=sheetObj.GetCellValue(headRows, prefix+"skd_dir_cd"); // direction of first row
		var otherDirTurnCnt=0;
		var otherDirPortCnt=0;
		var otherDirPos=0;
		var	chkFlag=true;
		
		/*
		if(	sheetObj.GetCellValue(headRows, prefix+"port_cd") 	   == sheetObj.GetCellValue(lastRows, prefix+"port_cd"		) &&
			sheetObj.GetCellValue(headRows, prefix+"yd_cd") 	   == sheetObj.GetCellValue(lastRows, prefix+"yd_cd"		) &&
			sheetObj.GetCellValue(headRows, prefix+"etb_dy_cd")    == sheetObj.GetCellValue(lastRows, prefix+"etb_dy_cd"	) &&
			sheetObj.GetCellValue(headRows, prefix+"etb_tm_hrmnt") == sheetObj.GetCellValue(lastRows, prefix+"etb_tm_hrmnt")
		  ) {
			var lastEtdNo=(parseInt(sheetObj.GetCellValue(headRows, prefix+"etd_dy_no")) - parseInt(sheetObj.GetCellValue(headRows, prefix+"etb_dy_no"))) +
			parseInt(sheetObj.GetCellValue(lastRows, prefix+"etb_dy_no"))	// Last Port ETD No 계산.
				sheetObj.SetCellValue(lastRows, prefix+"etd_dy_no",lastEtdNo);
				sheetObj.SetCellValue(lastRows, prefix+"etd_dy_cd",sheetObj.GetCellValue(headRows, prefix+"etd_dy_cd"));
				sheetObj.SetCellValue(lastRows, prefix+"etd_tm_hrmnt",sheetObj.GetCellValue(headRows, prefix+"etd_tm_hrmnt"));
		}else{
			//First port/terminal code should be same last port/terminal code.
			ComShowCodeMessage("VSK00084");
			// Comparing first port and last port
			if(sheetObj.GetCellValue(headRows,prefix+"port_cd") 	!= sheetObj.GetCellValue(lastRows,prefix+"port_cd")){
				sheetObj.SelectCell(headRows, prefix+"port_cd", true);
			}else if(sheetObj.GetCellValue(headRows,prefix+"yd_cd") != sheetObj.GetCellValue(lastRows,prefix+"yd_cd")){
				sheetObj.SelectCell(headRows, prefix+"yd_cd", true);
			}else if(sheetObj.GetCellValue(headRows,prefix+"etb_dy_cd") != sheetObj.GetCellValue(lastRows,prefix+"etb_dy_cd")){
				sheetObj.SelectCell(headRows, prefix+"etb_dy_cd", true);
			}else if(sheetObj.GetCellValue(headRows,prefix+"etb_tm_hrmnt") != sheetObj.GetCellValue(lastRows,prefix+"etb_tm_hrmnt")){
				sheetObj.SelectCell(headRows, prefix+"etb_tm_hrmnt", true);
			}
			return false;
		}
		*/
		for(var i=headRows; i<=lastRows; i++){
//			sheetObj.CellValue(i,prefix+"ibflag") = "I";
			sheetObj.SetRowStatus(i,"I");
			if(sheetObj.GetCellValue(i,prefix+"skd_dir_cd") != firstPortDirCd){
				if(sheetObj.GetCellValue(i,prefix+"turn_port_flg") == "Y"){
					otherDirTurnCnt++;
				}
				if (chkFlag){
					otherDirPos=i;
					chkFlag=false;
				}
				otherDirPortCnt++;
			}
			//Remove Turning Port Indicator('F')
			if(sheetObj.GetCellValue(i,prefix+"turn_port_ind_cd") == "F"){
				sheetObj.SetCellValue(i,prefix+"turn_port_ind_cd",sheetObj.GetCellValue(i, prefix+"turn_port_flg"));
			}
			if (i==headRows){
				//first Port ,Turning Port Indicator = N , Turning Port Flag = Y
				sheetObj.SetCellValue(i, prefix+"turn_port_ind_cd","N");
				sheetObj.SetCellValue(i, prefix+"turn_port_flg","Y");
			}
			if (i==lastRows) {
				//Last Port, Turning Port Indicator = N , Turning Port Flag = Y
				sheetObj.SetCellValue(i, prefix+"turn_port_ind_cd","F");
				sheetObj.SetCellValue(i, prefix+"turn_port_flg","N");
			}
			// Turn Ind Setting
			if(VskIsNull(sheetObj.GetCellValue(i,prefix+"turn_port_ind_cd"))){
				sheetObj.SetCellValue(i, prefix+"turn_port_ind_cd",sheetObj.GetCellValue(i,prefix+"turn_port_flg"));
			}
			// Manuvering In Time : 1
			sheetObj.SetCellValue(i, prefix+"mnvr_in_hrs","1");
			// Manuvering Out Time : 1
			sheetObj.SetCellValue(i, prefix+"mnvr_out_hrs","1");
		}
		if(otherDirPortCnt < 2){
			//If direction is two types, port count should be over two.
			ComShowCodeMessage('VSK00104'); 
			return false;
		}
		if(otherDirTurnCnt == 0){
			//If direction is two types, turn port total should be over one.
			ComShowCodeMessage('VSK00009');
			sheetObj.SelectCell(otherDirPos, prefix+"turn_port_flg");
			return false;
		}
	}else{	// one direction
		for(var i=headRows; i<=lastRows; i++){
//			sheetObj.CellValue(i,prefix+"ibflag") 				= "I";
			sheetObj.SetRowStatus(i,"I");
			sheetObj.SetCellValue(i, prefix+"turn_port_ind_cd","N");
			sheetObj.SetCellValue(i, prefix+"turn_port_flg","N");
			// Manuvering In Time : 1
			sheetObj.SetCellValue(i, prefix+"mnvr_in_hrs","1");
			// Manuvering Out Time : 1
			sheetObj.SetCellValue(i, prefix+"mnvr_out_hrs","1");
		}
	}
   if(dataRows < 2){
	   //"If direction changes, port total should be over two."
	   ComShowCodeMessage('VSK00008');
	   return false;
   }
   return true;
}
/**
 * Checking duration with direction
 * @param sheetObj
 * @param formObj
 * @return
 */
function checkDuration(sheetObj,formObj){
	if(VskIsNull(formObj.pf_svc_tp_cd.value)){
		ComShowCodeMessage('VSK00027', "P/F SKD Type");
		formObj.pf_svc_tp_cd.focus()
		return false;
	}
	if(VskIsNull(formObj.svc_dur_dys.value) || (parseInt(formObj.svc_dur_dys.value) <= 0)){
		ComShowCodeMessage('VSK00027', "Duration");
		formObj.svc_dur_dys.focus()
		return false;
	}
	//one direction : (Duration > Last Port ETB - First Port ETD)
	//two direction : (Duration = Last Port ETB - First Port ETB)
	var	dirCount=checkDirMode(sheetObj);
	var durationVal=formObj.svc_dur_dys.value;
	var firstRow=sheetObj.HeaderRows();
	var lastRow=sheetObj.LastRow();
	var prefix="sheet2_";
	var lastEtbDyNo=parseInt(sheetObj.GetCellValue(lastRow,prefix+"etb_dy_no"));
	var lastEtbTmHrmnt=sheetObj.GetCellValue(lastRow,prefix+"etb_tm_hrmnt");
	var lastEtdDyNo=parseInt(sheetObj.GetCellValue(lastRow,prefix+"etd_dy_no"));
	if(dirCount == "ONE"){
		var firstEtdDyNo=parseInt(sheetObj.GetCellValue(firstRow,prefix+"etd_dy_no"));
		var firstEtdTmHrmnt=sheetObj.GetCellValue(firstRow,prefix+"etd_tm_hrmnt");
		var tempLastEtbTmHrmnt=lastEtbTmHrmnt.length;
		var tempFirstEtdTmHrmnt=firstEtdTmHrmnt.length;
		var lastEtbTmHrmntVal=0;
		var firstEtdTmHrmntVal=0;
		if(tempLastEtbTmHrmnt == 4){
			lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
		}else{
			lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
		}
		if(tempFirstEtdTmHrmnt == 4){
			firstEtdTmHrmntVal=firstEtdTmHrmnt.substring(0,2);
		}else{
			firstEtdTmHrmntVal=firstEtdTmHrmnt.substring(0,1);
		}
		var lastTot=parseInt(lastEtbDyNo * 24) + parseInt(lastEtbTmHrmntVal);
		var firstTot=parseInt(firstEtdDyNo * 24) + parseInt(firstEtdTmHrmntVal);
		var tempDur=parseInt(lastTot - firstTot);
		var durVal1=parseInt(tempDur/24);
		if(durationVal < durVal1){
			//Total duration should be always bigger than difference of (Last port ETB - First port ETB).
			ComShowCodeMessage("VSK00094");
			formObj.svc_dur_dys.focus();
			return false;
		}
		if(lastEtbDyNo > lastEtdDyNo){
			//({?msg1}) ETB cannot be larger than ETD.
			ComShowCodeMessage("VSK00048", sheetObj.GetCellValue(lastRow, prefix+"port_cd"));
			sheetObj.SelectCell(lastRow,prefix+"etd_dy_no",true);
			return false;
		}
	}else{
		var firstEtbDyNo=parseInt(sheetObj.GetCellValue(firstRow,prefix+"etb_dy_no"));
		var firstEtbTmHrmnt=sheetObj.GetCellValue(firstRow,prefix+"etb_tm_hrmnt");
		var tempLastEtbTmHrmnt=lastEtbTmHrmnt.length;
		var tempFirstEtbTmHrmnt=firstEtbTmHrmnt.length;
		var lastEtbTmHrmntVal=0;
		var firstEtbTmHrmntVal=0;
		if(tempLastEtbTmHrmnt == 4){
			lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
		}else{
			lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
		}
		if(tempFirstEtbTmHrmnt == 4){
			firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,2);
		}else{
			firstEtbTmHrmntVal=firstEtbTmHrmnt.substring(0,1);
		}
		var lastTot=parseInt(lastEtbDyNo  * 24) + parseInt(lastEtbTmHrmntVal);
		var firstTot=parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
		var tempDur=parseInt(lastTot - firstTot);
		var durVal1=parseInt(tempDur/24);
		if(durationVal != durVal1){
			//Total duration and difference(Last port ETB - First port ETB) should be same.
			//ComShowCodeMessage("VSK00095");
			//formObj.svc_dur_dys.focus();
			//return false;
		}
	}
	return true;
}

function setDuration(sheetObj,formObj) {
	
	var	headRows 	= sheetObj.HeaderRows();
	var dataRows 	= sheetObj.RowCount();
	var lastRow  	= sheetObj.LastRow();
	var prefix   	= sheetObj.id + "_";
	var	dirCount	= checkDirMode(sheetObj);
	
	var lastEtbDyNo         = "";
	var lastEtbTmHrmnt      = "";
	if(dirCount == "ONE"){
		lastEtbDyNo         = sheetObj.GetCellValue(lastRow , prefix + "etd_dy_no");
		lastEtbTmHrmnt      = sheetObj.GetCellValue(lastRow , prefix + "etd_tm_hrmnt");
	}else{
		lastEtbDyNo         = sheetObj.GetCellValue(lastRow , prefix + "etb_dy_no");
		lastEtbTmHrmnt      = sheetObj.GetCellValue(lastRow , prefix + "etb_tm_hrmnt");
	}
	var firstEtbDyNo        = sheetObj.GetCellValue(headRows, prefix + "etb_dy_no");
	var firstEtbTmHrmnt     = sheetObj.GetCellValue(headRows, prefix + "etb_tm_hrmnt");
	var tempLastEtbTmHrmnt  = lastEtbTmHrmnt.length;
	var tempFirstEtbTmHrmnt = firstEtbTmHrmnt.length;
	var lastEtbTmHrmntVal   = 0;
	var firstEtbTmHrmntVal  = 0;
	if (tempLastEtbTmHrmnt == 4) {
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,2);
	} else {
		lastEtbTmHrmntVal = lastEtbTmHrmnt.substring(0,1);
	}
	if (tempFirstEtbTmHrmnt == 4 ){
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
	} else {
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
	}
	if (tempLastEtbTmHrmnt == 4) {
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,2);
	} else {
		lastEtbTmHrmntVal=lastEtbTmHrmnt.substring(0,1);
	}
	if (tempFirstEtbTmHrmnt == 4) {
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,2);
	} else {
		firstEtbTmHrmntVal = firstEtbTmHrmnt.substring(0,1);
	}
	var lastTot  = parseInt(lastEtbDyNo * 24)  + parseInt(lastEtbTmHrmntVal);
	var firstTot = parseInt(firstEtbDyNo * 24) + parseInt(firstEtbTmHrmntVal);
	var tempDur  = parseInt(lastTot - firstTot);
	var durVal1  = tempDur/24;
	durVal1      = parseInt(durVal1 * 10);
	durVal1      = parseFloat(durVal1/10);
	
	//:2015-11-26:by TOP://
	if(durVal1 < 1)	durVal1	= "1";
	
	var resultDurVal = isNaN(durVal1);
	if (resultDurVal == true) {
		durVal1 = 0;
	}
	formObj.svc_dur_dys.value=durVal1;
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[1]);
}
