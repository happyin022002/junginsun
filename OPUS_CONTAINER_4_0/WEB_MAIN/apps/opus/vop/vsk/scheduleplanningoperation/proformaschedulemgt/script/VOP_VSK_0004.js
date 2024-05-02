/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : VOP_VSK_0004.js
*@FileTitle : P/F SKD Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0004 : business script for VOP_VSK_0004
     */
    function VOP_VSK_0004() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	// public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	//yd_cd Handling Array
	var ydCdsArr=new Array();
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[1];
     /*******************************************************/
    var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
			//if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
					break;
				case "btn_New":
					clearAllData(sheetObject1,sheetObject2,formObject, true);
					break;
				case "btn_DownExcel":
					//sheetObject2.Down2Excel({ HiddenColumn:true});
					if(sheetObject2.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject2.Down2Excel({HiddenColumn:1,Merge:1,TreeLevel:false,SheetDesign:1 });
					}
					break;
				case "btns_search":
					openLandCdHelp(sheetObject2);
					break;	
				case "btns_search02":
					openPfLandTypeCdHelp(sheetObject2);
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
//	document.form.vsl_slan_cd.focus();
}
/**
 * registering initial event
 */
function initControl() {
	var formObj=document.form;
//	axon_event.addListenerForm('focus', 'obj_focus', formObj);
}

/**
 * Handling key press event
 */

/**
 * Handling change event
 */
function obj_change(){
	var formObject=document.form;
    var sheetObject1=sheetObjects[0];
    /*******************************************************/
	try {
		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        	case "vsl_slan_cd":
	        	var cnt=formObject.vsl_slan_cd.value;
				cnt=cnt.length;
				if(cnt == 3){
					doActionIBSheet(sheetObjects[0], formObject, SEARCH02);
				}
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
	        var prefix="sheet1_";
	
	        SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	        var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle, Align:"Center"} ];
	        InitHeaders(headers, info);
	
	        var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_slan_cd",       KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"pf_svc_tp_cd",      KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"slan_stnd_flg",     KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"svc_dur_dys",       KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"stnd_svc_spd",      KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"brth_itval_dys",    KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"mml_usd_flg",       KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"sim_no",            KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n1st_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n2nd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_cd",  KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"n3rd_vsl_clss_knt", KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"clpt_knt",          KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Left",    ColMerge:0,   SaveName:prefix+"ttl_dist",          KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"max_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_spd",           KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delt_flg",          KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pf_skd_rmk",        KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"" },
	         {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_dt",            KeyField:0,   CalcLogic:"",   Format:"" } ];
	         
	        InitColumns(cols);
	        SetEditable(0);
	        SetWaitImageVisible(0);
	        SetColProperty(prefix+"cre_dt", {Format:"####-##-######"} );
	        
	        SetVisible(false);
	        }
	      
	        break;
        case "sheet2":      //sheet1 init
            with(sheetObj){        	
           
	            var HeadTitle1="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|ETB|ETB|ETB|ETD|ETD|ETD|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|Manv.|Manv.|Port\nTime|Port\nBUF|Cargo Volume|Cargo Volume|Cargo Volume|Cargo Volume|TMNL PRD|TMNL PRD|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	            var HeadTitle2="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|IPC|IPC|Ocean|Ocean|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	            var HeadTitle3="|Sel.|No.|DIR|Port\nCode|TMNL\nCode|ZD|No.|Day|Time|No.|Day|Time|Dist|Sea\nSPD|Sea\nTime|Sea\nBUF|Avg\nSea\nBUF\nSPD|Sea\nBUF\nSPD|In|Out|Port\nTime|Port\nBUF|In|Out|In|Out|EA|VOL|T/Port\nIND(Y/N)|Turn_Port_Ind_Cd|VSL_SLAN_CD|PF_SVC_TP_CD";
	            var headCount=ComCountHeadTitle(HeadTitle1);
	            var prefix="sheet2_";	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );	
	            var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"},{ Text:HeadTitle3, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
	             {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Sel" },
	             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"No" },
	             {Type:"Combo",     Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5,InputCaseSensitive:1 },
	             {Type:"Text",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:prefix+"zd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etb_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etb_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"etd_dy_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"etd_dy_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",   ColMerge:1,   SaveName:prefix+"etd_tm_hrmnt",     KeyField:0,   CalcLogic:"",   Format:"Hm",          PointCount:0 },
	             {Type:"Int",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_dist",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:6 },
	             {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"lnk_spd",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	             {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tztm_hrs",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",      Hidden:1, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"avg_sea_buf_spd",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	             {Type:"Float",      Hidden:0, Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"sea_buf_spd",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:3 },
	             {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_in_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"mnvr_out_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wrk_hrs",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Float",      Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+"port_buf_hrs",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
	             {Type:"Int",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Int",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ipcgo_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Int",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ib_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Int",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"ob_ocn_cgo_qty",   KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Int",      Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+"crn_knt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:1 },
	             {Type:"Int",      Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+"tml_prod_qty",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0 },
	             {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"turn_port_ind_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 },
	             {Type:"Text",      Hidden:1, Width:00,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0 } ];
	                      
	            InitColumns(cols);	
	            SetEditable(0);
	            SetWaitImageVisible(0);	           
	            SetRowHeight(0,10);
	            SetRowHeight(1,10);
	            SetRowHeight(2,10);
	            SetColProperty(prefix+"skd_dir_cd", {ComboText:"W|E|N|S", ComboCode:"W|E|N|S"} );
	        	SetColProperty(prefix+"yd_cd", {ComboText:"", ComboCode:""} );
	        	SetColProperty(prefix+"etb_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	        	SetColProperty(prefix+"etd_dy_cd", {ComboText:"MON|TUE|WED|THU|FRI|SAT|SUN", ComboCode:"MON|TUE|WED|THU|FRI|SAT|SUN"} );
	        	SetColProperty(prefix+"turn_port_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
	        	resizeSheet();
            	}
                break;
    }
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    sheetObj.ShowDebugMsg(false);
    var prefix="sheet2_";
    switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(validateForm(sheetObj,formObj,sAction)){
				
				clearAllData(sheetObjects[0], sheetObjects[1], formObj, false);
				ComOpenWait(true);
				formObj.f_cmd.value=SEARCH;
				var sParam="f_cmd="+ formObj.f_cmd.value +
							"&vsl_slan_cd=" +formObj.vsl_slan_cd.value+
							"&pf_svc_tp_cd=" +formObj.pf_svc_tp_cd.value;
		        var aryPrefix=new Array("sheet1_", "sheet2_");	//prefix string array
		        var sXml=sheetObj.GetSearchData("VOP_VSK_0004GS.do", sParam + "&" + ComGetPrefixParam(aryPrefix));
				
				var arrXml=sXml.split("|$$|");
				
				if (arrXml.length > 1) {
					for(var inx=0; inx<arrXml.length; inx++){
						showSheetData(sheetObjects[inx],formObj,arrXml[inx]);
					}
				}else{
		    		var tmpXml="<SHEET><DATA  TOTAL='0'></DATA></SHEET>";
		    		showSheetData(sheetObjects[1],formObj,tmpXml);
				}
				ComOpenWait(false);
			}
		break;
		case SEARCH02:
			ComOpenWait(true);
			formObj.f_cmd.value=COMMAND12;
			var sParam="f_cmd="+ formObj.f_cmd.value +
						"&vsl_slan_cd=" +formObj.vsl_slan_cd.value;
			var sXml=sheetObj.GetSearchData("VOP_VSK_0202GS.do", sParam);
			var checkLane=ComGetEtcData(sXml, "checkLane");
			if(checkLane == undefined){
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				formObj.vsl_slan_cd.value="";	
//				formObj.vsl_slan_cd.focus();
			}else{
				var vslSlanNm=ComGetEtcData(sXml, "checkLane").split("|");
				if(vslSlanNm == ""){
					ComShowCodeMessage('VSK00021', formObj.vsl_slan_cd.value);
					formObj.vsl_slan_cd.value="";	
				}else{
//					formObj.pf_svc_tp_cd.focus();
				}
			}
			ComOpenWait(false);
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
	var prefix= "sheet1_";
	switch(sheetObj.id){
		case "sheet1":
			var xmlDoc = ComGetXmlDoc(sXml);
			if (xmlDoc == null) return;
			//var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			var totValue =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(totValue){
				sheetObj.LoadSearchData(sXml,{Sync:0} );
				if(totValue > 0){
//					formObj.vsl_slan_cd.value=sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
//					formObj.slan_stnd_flg.value=sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
//					formObj.pf_svc_tp_cd.value=sheetObj.GetCellValue(1,prefix+"pf_svc_tp_cd");
//					formObj.n1st_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
//					formObj.n1st_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt");
//					formObj.n2nd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
//					formObj.n2nd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
//					formObj.n3rd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
//					formObj.n3rd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
//					formObj.svc_dur_dys.value=sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
//					formObj.brth_itval_dys.value=sheetObj.GetCellValue(1,prefix+"brth_itval_dys");
//					formObj.mml_usd_flg.value=sheetObj.GetCellValue(1,prefix+"mml_usd_flg");
//					var tempCreDt=sheetObj.GetCellValue(1,prefix+"cre_dt");
//					var tempUpdDt=sheetObj.GetCellValue(1,prefix+"upd_dt");
//					formObj.cre_dt.value=tempCreDt.substring(0,13)+":"+tempCreDt.substring(13,15);
//					formObj.upd_dt.value=tempUpdDt.substring(0,13)+":"+tempUpdDt.substring(13,15);
					var ydCds="";
					var ydCd=ComGetEtcData(sXml, "ydCd");
					if(ydCd && ydCd!=""){
						ydCds=ydCd.split("|");
					}
					if(ydCds != null && ydCds != undefined && ydCds != ""){
						for(var i=0 ; i < ydCds.length ; i++ ){
							ydCdsArr[i]=ydCds[i];
						}
					}
					
					//[CDATA[23.4|21.0|17.7|19.27|20.31|0.00|118.64|1.43|1]
					var etcdts="";
					var etcdt=ComGetEtcData(sXml, "etcdt");
					if(etcdt && etcdt!=""){
						etcdts=etcdt.split("|");
					}
					if(etcdts && etcdts != ""){
						formObj.min_max_spd.value=etcdts[8];
						formObj.cre_usr_id.value=etcdts[10];
						formObj.upd_usr_id.value=etcdts[11];
					}
				}else{
					clearAllData(sheetObjects[0], sheetObjects[1], formObj, true);
				}
			}
		break;
		
		case "sheet2":
			sheetObj.RenderSheet(0);
			sheetObj.LoadSearchData(sXml,{Sync:0} );
			sheetObj.RenderSheet(1);
		break;
	}
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) 
{
	formObj = document.form;
	prefix = sheetObj.id+"_";
	formObj.vsl_slan_cd.value=sheetObj.GetCellValue(1,prefix+"vsl_slan_cd");
	formObj.slan_stnd_flg.value=sheetObj.GetCellValue(1,prefix+"slan_stnd_flg");
	formObj.pf_svc_tp_cd.value=sheetObj.GetCellValue(1,prefix+"pf_svc_tp_cd");
	formObj.n1st_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_cd");
	formObj.n1st_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n1st_vsl_clss_knt");
	formObj.n2nd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_cd");
	formObj.n2nd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n2nd_vsl_clss_knt");
	formObj.n3rd_vsl_clss_cd.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_cd");
	formObj.n3rd_vsl_clss_knt.value=sheetObj.GetCellValue(1,prefix+"n3rd_vsl_clss_knt");
	formObj.svc_dur_dys.value=sheetObj.GetCellValue(1,prefix+"svc_dur_dys");
	formObj.brth_itval_dys.value=sheetObj.GetCellValue(1,prefix+"brth_itval_dys");
	formObj.mml_usd_flg.value=sheetObj.GetCellValue(1,prefix+"mml_usd_flg");
	var tempCreDt=sheetObj.GetCellValue(1,prefix+"cre_dt");
	var tempUpdDt=sheetObj.GetCellValue(1,prefix+"upd_dt");
	formObj.cre_dt.value=tempCreDt.substring(0,16);
	formObj.upd_dt.value=tempUpdDt.substring(0,16);

}

function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) 
{
	formObj = document.form;
	prefix = sheetObj.id+"_";
	
	setlastLowView(sheetObj);
}

/**
 * Showing Calling Port ,Distance (P/S ~ P/S) data
 */
function viewDetailData(sheetObj,formObj){
	var cnt=sheetObj.RowCount();
	var prefix="sheet2_";
	//Calling Port
	var callingPortCnt=cnt -1;
	formObj.clpt_knt.value=callingPortCnt+" ports";
	//Distance
	var disSum=0;
	//var spdArr = new Array();
	for(var i=3; i<=cnt+2; i++){
		disSum += parseInt(sheetObj.GetCellValue(i,prefix+"lnk_dist"));
	}
	disSum=ComGetMaskedValue(disSum+"","int","");
	formObj.ttl_dist.value=disSum+" Miles";	
}
/**
 * Handling Terminal Code of SHEET2 Event
 */
function setSheetComboSinc(xmlStr, sheetObject, Row, Col){
	var xmlEtcData=ComGetEtcData(xmlStr, "yd_kind");
	if(xmlEtcData != null && xmlEtcData != undefined && xmlEtcData != ""){
		sheetObject.CellComboItem(Row,sheetObject.id+"_yd_cd", {ComboText:xmlEtcData, ComboCode:xmlEtcData} );
	}
	
//	for(var i=0; i<sheetObj.RowCount(); i++){
//		sheetObj.CellComboItem(sheetObj.HeaderRows+i,prefix+"yd_cd", {ComboText:ydCdsArr[i], ComboCode:ydCdsArr[i]} );
//		sheetObj.SetCellValue(sheetObj.HeaderRows()+i, prefix+"yd_cd",ydCdsArr[i],0);
//		//sheetObj.CellValue(sheetObj.HeaderRows+i, prefix+"ibflag") = "R";
//		sheetObj.SetRowStatus(sheetObj.HeaderRows()+i,"R");
//	}
}
/**
 * Initializing screen
 * @param sheetObj
 * @param formObj
 * @return
 */
function clearAllData(sheetObj1, sheetObj2, formObj, status) {
	if (status) {
		formObj.vsl_slan_cd.value="";
		formObj.pf_svc_tp_cd.value="";
	}	
	formObj.brth_itval_dys.value="";
	formObj.slan_stnd_flg.value="";
	formObj.cre_dt.value="";
	formObj.n1st_vsl_clss_cd.value="";
	formObj.n1st_vsl_clss_knt.value="";
	formObj.n2nd_vsl_clss_cd.value="";
	formObj.n2nd_vsl_clss_knt.value="";
	formObj.n3rd_vsl_clss_cd.value="";
	formObj.n3rd_vsl_clss_knt.value="";
	formObj.svc_dur_dys.value="";
	formObj.mml_usd_flg.value="";
	formObj.upd_dt.value="";
	formObj.cre_usr_id.value="";
	formObj.upd_usr_id.value="";
	sheetObj1.RemoveAll();
	sheetObj2.RemoveAll();
//	document.form.vsl_slan_cd.focus();
}
/**
 * Open Lane Code Help
 */
function openLandCdHelp(sheetObj){
   var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd";
   var v_display="0,0";
   var laneCd=document.form.vsl_slan_cd.value;
//ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 420, 470, targetObjList, v_display, true);
   ComOpenPopup('/opuscntr/VOP_VSK_0202.do?vsl_slan_cd='+laneCd, 500, 470, "getReturn0202", v_display, true);
}

function getReturn0202(rtnVal){

	var formObj=document.form;
	var rVal = rtnVal[0];
	if( rVal.length >0 ){
		
		formObj.vsl_slan_cd.value =rVal[1];
	}
	
}

/**
 * Open P/F Lane Type Code Help  
 */
function openPfLandTypeCdHelp(sheetObj){
	 var targetObjList="sheet1_pf_svc_tp_cd:pf_svc_tp_cd";
	 var v_display="0,0";
	 var laneCd=document.form.vsl_slan_cd.value;
	 //ComOpenPopupWithTarget('/opuscntr/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 490, targetObjList, v_display, true);
	 ComOpenPopup('/opuscntr/VOP_VSK_0241.do?vsl_slan_cd='+laneCd, 640, 510, "getReturn0241", v_display, true);
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
	}
    return true;
}
/**
 * Handling enter key
 */
function doSearch(){
	var formObject=document.form;
	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
}
/**
 * after showing grid, setting color of last row
 */
function setlastLowView(sheetObj){
	var firstRow=sheetObj.HeaderRows();
	var lastRow=sheetObj.LastRow();
	var prefix="sheet2_";
	if(sheetObj.RowCount()> 0){
		//gray
		var grayColor="#EFEBEF";
		//white
		var whiteColor="#FFFFFF";
		// first Row
		sheetObj.SetCellBackColor(firstRow, prefix+"mnvr_in_hrs",grayColor);
		sheetObj.SetCellFontColor(firstRow, prefix+"mnvr_in_hrs",grayColor);
		// Last Row
		for(var Col=sheetObj.SaveNameCol(prefix+"etd_dy_no"); Col<sheetObj.LastCol(); Col++){
			if(Col!=sheetObj.SaveNameCol(prefix+"mnvr_in_hrs")){
				sheetObj.SetCellBackColor(lastRow, Col,grayColor);
				sheetObj.SetCellFontColor(lastRow, Col,grayColor);
			}
		}
	}
}
function resizeSheet(){
    ComResizeSheet(sheetObjects[1]);
}
	