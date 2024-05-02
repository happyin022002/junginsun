/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5021
*@FileTitle  : Port Limits Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/17
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
   /**
     * @fileoverview 
     * @author 
     */
    /**
     * @extends 
     * @class VOP_SCG_5021 : business script for VOP_SCG_5021
     */
/*------------------ Defining general java script function   ------------------*/
// General global variable
var sheetObjects=new Array();
var comboObjects=new Array();
var sheetCnt=0;
var gRow=0;
var isCNSHA = false;
document.onclick=processButtonClick;

/* Branch processing event handler with the name of button */
function processButtonClick(){
	 /***** Adding additional sheet variables to use more than one sheet per a tab *****/
	var sheetObject=sheetObjects[0];
	if(isCNSHA) {
		sheetObject=sheetObjects[1];
	}
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
				
			case "btn_rowadd":
				doActionIBSheet(sheetObject,formObject,IBINSERT);
				if(isCNSHA) {
					setTmnlCombo(sheetObject,true);
				}
				break;
			
			case "btn_rowins":
				doActionIBSheet(sheetObject,formObject,COMMAND01);
				if(isCNSHA) {
					setTmnlCombo(sheetObject,true);
				}
				break;
				
			case "btn_save":
				doActionIBSheet(sheetObject,formObject,IBSAVE);
				break;
				
			case 'btn_delete':
//				if(sheetObject.FindCheckedRow("ibcheck")==""){
//					ComShowCodeMessage("SCG50035");
//				} else { 
					doActionIBSheet(sheetObject,formObject,IBDELETE);
//				}
				break;
				
			case "btn_new":
				sheetObject.RemoveAll();
//				form.reset();
				break;
            case "btns_up":
                var sRowStr=sheetObject.GetSelectionRows("/");  //"/" row separator, results: "3/4/5"
                var arr=sRowStr.split("/");
                sheetObject.DataMove(Number(arr)-1);
                //순번을 다시매긴다
                sheetObject.ReNumberSeq();
                
            	// For renumbering 
            	for(var i=3; i <= sheetObject.LastRow(); i++){
            		if(sheetObject.GetCellValue(i , "ibflag") == "R"){
            			sheetObject.SetCellValue(i , "ibflag", "U");
            		}
            	}
                
                break;
            case "btns_down":
                var sRowStr=sheetObject.GetSelectionRows("/");  //"/" row separator, results: "3/4/5"
                var arr=sRowStr.split("/");
                sheetObject.DataMove(Number(arr)+2);
                //순번을 다시매긴다
                sheetObject.ReNumberSeq();
                
            	// For renumbering 
            	for(var i=3; i <= sheetObject.LastRow(); i++){
            		if(sheetObject.GetCellValue(i , "ibflag") == "R"){
            			sheetObject.SetCellValue(i , "ibflag", "U");
            		}
            	}
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
 * Register IBSheet Object with array
 * @param sheet_obj
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}

/**
 * Setting sheets and initialization
 * Implementing the onLoad event handler of body tag
 * Adding the preceding function after loading page
 */
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC05);
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
	initControl();
}

/**
 * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
	axon_event.addListener('change', 	'un_loc_cd_flg_OnChange', 'un_loc_cd_flg');
}

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
   return ComChkObjValid(event.srcElement);
}

/**
 * Removing the separator when onfocus event occurred <br>
 **/
function obj_focus(){
   ComClearSeparator(event.srcElement);
}

/**
 * Processing to be input only number when onkeypress event occurred <br>
 **/
function obj_keypress(){
    obj=event.srcElement;
    if(obj.dataformat == null) return;
    window.defaultStatus=obj.dataformat;
    var vKeyCode=event.keyCode;
    switch(obj.dataformat) {
        case "engup":
//            if(obj.name=="slan_cd") {
//            	ComKeyOnlyAlphabet('uppernum');
//            }
            break;
    }
}

/**
 * Processing to be retrieved when onChange event occurred <br>
 **/
function un_loc_cd_flg_OnChange(){
	var formObj=document.form;
	var sheet;
	if(ComGetObjValue(formObj.un_loc_cd_flg) == 'C') {
		sheet = sheetObjects[1];
		document.all.item("SHEET1").style.display="none";
		document.all.item("SHEET2").style.display="inline";
		isCNSHA = true;
	} else {
		sheet = sheetObjects[0];
		document.all.item("SHEET1").style.display="inline";
		document.all.item("SHEET2").style.display="none";
		isCNSHA = false;
	}
	doActionIBSheet(sheet, document.form, IBSEARCH);
}

/**
 * Define the initial values and headers of sheets
 * @param sheetObj,sheetNo
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
//            var HeadTitle  = "|Chk||Port||Entry\nType|Representative Description|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR\nType|Arrival & Depature\nWeight (KGS)|Arrival & Depature\nWeight (KGS)|Arrival & Depature\nWeight (KGS)|Loading & Discharge\nWeight (KGS)|Loading & Discharge\nWeight (KGS)|Loading & Discharge\nWeight (KGS)|Sub\nProperty|FP\n(°C)|Property|Property" ;
//            var HeadTitle2 = "|Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Prohibition|Limit||Target|Limit||Sub\nProperty|FP\n(°C)|Explosive|Judgement" ;
//            var HeadTitle3 = "|Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Prohibition|Limit||Target|Limit||Sub\nProperty|FP\n(°C)|Explosive|Judgement" ;

            var HeadTitle  = "No.||Chk||Port||Entry\nType|Representative Description|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR\nType|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Limit Weight(KGS)|Sub\nProperty|FP(°C)\n* Under inputted value|Property|Property" ;
            var HeadTitle2 = "No.||Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Arrival & Departure|Arrival & Departure|Arrival & Departure|Loading & Discharge|Loading & Discharge|Loading & Discharge|Sub\nProperty|FP(°C)\n* Under inputted value|Property|Property" ;	
            var HeadTitle3 = "No.||Chk||Port||Entry\nType|Representative Description|Class|Class|Sub.\nRisk(s)||PG|CNTR\nType|Prohi|Limit||Target|Limit||Sub\nProperty|FP(°C)\n* Under inputted value|Explosive|Judgement" ;
            
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:6, ComboMaxHeight:200 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = 
              [ {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                {Type:"DummyCheck", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                {Type:"Int",        Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"port_lmt_seq",		KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",        	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pier_tp_cd",     	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lmt_wgt_tp_cd",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},                 
                
                {Type:"Text",       Hidden:0, Width:490,  Align:"Left",    ColMerge:0,    SaveName:"port_lmt_rep_desc",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
                {Type:"Text",  		Hidden:0, Width:170,  Align:"Left",    ColMerge:0,    SaveName:"v_clss_info",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:true},
                {Type:"PopupEdit",  Hidden:1, Width:20,   Align:"Left",    ColMerge:0,    SaveName:"clss_info",          KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                
//                {Type:"Combo",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:1},
//                {Type:"Combo",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
//                {Type:"Text",       Hidden:0, Width:560,  Align:"Left",    ColMerge:0,   SaveName:"imdg_clss_cd_desc", 		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",  		Hidden:0, Width:48,  Align:"Left",    ColMerge:0,    SaveName:"v_imdg_subs_rsk_lbl_cd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                //{Type:"Combo",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                //{Type:"Combo",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",		  		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd", 				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                
                {Type:"Combo",      Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",	 KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Combo",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",      	 KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
//                {Type:"CheckBox",   Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"port_hdl_prohi_flg", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"CheckBox",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"arr_dep_prohi_flg",   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"Int",        Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"arr_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"dep_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                
                {Type:"CheckBox",   Hidden:0, Width:45,   Align:"Center",  ColMerge:1,   SaveName:"ldis_aply_tgt_flg",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"Int",        Hidden:0, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"lod_max_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:95,   Align:"Right",   ColMerge:0,   SaveName:"dchg_max_qty",         KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                
                {Type:"Combo",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"port_lmt_sub_ppt_cd", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Int",        Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_temp",       KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3},
//                {Type:"Int",        Hidden:1, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_lowr_temp",  KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:3},
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ppt_explo_flg",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"ppt_prohi_flg",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1}
               ];
            
            InitColumns(cols);
            SetSheetHeight(400);
            SetEditable(1);
            SetHeaderRowHeight(10);
            
            var str = "GR	GROSS|NT	NET|NP	NET POWDER";
            var cod = "GR|NT|NP";
            SetColProperty("lmt_wgt_tp_cd", {ComboText:"|"+str, ComboCode:"|"+cod} );
            SetColProperty("imdg_pck_grp_cd", {ComboText:"|I|II|III", ComboCode:"|1|2|3"} );
//            SetColProperty("port_lmt_sub_ppt_cd", {ComboText:"|Below|Except", ComboCode:"|B|E"} );
//            SetColProperty("port_lmt_sub_ppt_cd", {ComboText:"Below|Except", ComboCode:"B|E"} );
            SetColProperty("ppt_explo_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
            SetColProperty("ppt_prohi_flg", {ComboText:"N|P", ComboCode:"N|P"} );
            
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
			
			resizeSheet();
		   }
			break;
			
		case 2:      //sheet2 init
			with (sheetObj) {
            var HeadTitle  = "No.||Chk||Port||Entry\nType|Terminal|Representative Description|IMDG\nClass||||Limit Quantity|Limit Quantity|Limit Quantity" ;
            var HeadTitle2 = "No.||Chk||Port||Entry\nType|Terminal|Representative Description|IMDG\nClass||||Loading & Discharge|Loading & Discharge|Loading & Discharge" ;	
            var HeadTitle3 = "No.||Chk||Port||Entry\nType|Terminal|Representative Description|IMDG\nClass||||Target|Limit||" ;
            
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0, FrozenCol:6, ComboMaxHeight:200 } );
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"}, { Text:HeadTitle3, Align:"Center"} ];
            InitHeaders(headers, info);
      
            var cols = 
              [ {Type:"Seq",        Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"dp_seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
                {Type:"Status",     Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
                {Type:"DummyCheck", Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibcheck" },
                {Type:"Int",        Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"port_lmt_seq",		KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",        	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pier_tp_cd",     	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lmt_wgt_tp_cd",  	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},                 
                
                {Type:"Combo",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"yd_cd",  	        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},  
                {Type:"Text",       Hidden:0, Width:490,  Align:"Left",    ColMerge:0,   SaveName:"port_lmt_rep_desc",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, MultiLineText:true },
                {Type:"Text",  		Hidden:0, Width:170,  Align:"Left",    ColMerge:0,   SaveName:"v_clss_info",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0, MultiLineText:true},
                {Type:"PopupEdit",  Hidden:1, Width:20,   Align:"Left",    ColMerge:0,   SaveName:"clss_info",          KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                
                {Type:"Text",  		Hidden:1, Width:48,   Align:"Left",    ColMerge:0,   SaveName:"v_imdg_subs_rsk_lbl_cd", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_cd", 				KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1},
                
                {Type:"CheckBox",   Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ldis_aply_tgt_flg",  KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:1,   InsertEdit:1,	TrueValue:"Y",	FalseValue:"N"},
                {Type:"Int",        Hidden:0, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"lod_max_teu_qty",        KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9},
                {Type:"Int",        Hidden:1, Width:90,   Align:"Right",   ColMerge:0,   SaveName:"dchg_max_teu_qty",       KeyField:0,   CalcLogic:"",   Format:"NullInteger",   PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:9}
                ];
            
            InitColumns(cols);
            SetSheetHeight(400);
            SetEditable(1);
            SetHeaderRowHeight(10);
            
			for(z=0; z<=cols.length; z++) {
				if(GetCellValue(1,z) == "Loading & Discharge") {
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

function resizeSheet(){
	
	ComResizeSheet(sheetObjects[0]);
	
    //for (i=0; i<sheetObjects.length; i++){
    //    ComResizeSheet(sheetObjects[i]);
    //}
}

/**
 * doActionIBSheet
 * @param sheetObj,formObj,sAction
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:	//Retrieve
			if(validateForm(sheetObj,formObj,sAction))	
			ComOpenWait(true);					
			formObj.f_cmd.value=SEARCH;
			var xml = sheetObj.GetSearchData("VOP_SCG_5021GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(xml,{Sync:1} );
			ComOpenWait(false);
			break;
			
		case IBSEARCH_ASYNC01:	//Serching IMDG Code Combo 
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var class_cd=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
//			var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
			//Class
//			sheetObjects[0].SetColProperty("imdg_clss_cd", {ComboText:"|"+tStr1, ComboCode:"|"+class_cd[0]} );
			//Subsidiary Risk(s)
			sheetObj.SetColProperty("imdg_subs_rsk_lbl_cd", {ComboText:"|"+class_cd[0], ComboCode:"|"+class_cd[0]} );
			break;
		
		case IBSEARCH_ASYNC02:	//Serching CNTR TP Code Combo 
			formObj.f_cmd.value=SEARCH21;
			var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
			var cntr_cd=ComXml2ComboString(sXml, "cntr_tp_cd", "cntr_tp_desc");
			/* Q: Dead Space 제외*/
			if(cntr_cd[0]!="" && cntr_cd[1]!="") {
				var aCode = cntr_cd[0].split("|");
				var aText = cntr_cd[1].split("|");
				cntr_cd[0] = "";
				cntr_cd[1] = "";
				if(aCode.length == aText.length) {
					for(var i=0;i<aCode.length;i++) {
						if(aCode[i] != "Q") {
							cntr_cd[0] += aCode[i];
							cntr_cd[1] += aText[i];
							if( i < aCode.length-1 ) {
								cntr_cd[0] += "|";
								cntr_cd[1] += "|";
							}
						}
					}
				}
			}
			var tStr=ComScgClossAppend(cntr_cd[0], cntr_cd[1]);
			var tStr1 = tStr.substr(0, tStr.length-1);//ComScgClossAppend안에 조건오류로 인해 마지막 | 제거 필요
			sheetObj.SetColProperty("cntr_tp_cd", {ComboText:"All"+"|"+tStr1, ComboCode:"|"+cntr_cd[0]} );
			break;
		
		case IBSEARCH_ASYNC03:	//Serching Un No. Code Combo 
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var un_no=ComXml2ComboString(sXml, "imdg_un_no", "prp_shp_nm");
//			var tStr=ComScgClossAppend(un_no[0], un_no[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObj.SetColProperty("imdg_un_no", {ComboText:"|"+un_no[0], ComboCode:"|"+un_no[0]} );
			break;
			
//		case IBSEARCH_ASYNC04:   //Division of Class retrieve
//			formObj.f_cmd.value=SEARCH;
//			var sXml=sheetObj.GetSearchData("VOP_SCG_0047GS.do", FormQueryString(formObj));
//			var imdg_comp_grp_cd=ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
//			var tStr=ComScgClossAppend(imdg_comp_grp_cd[0], imdg_comp_grp_cd[1] );
//			var tStr1 = tStr.substr(0, tStr.length-1);
//			sheetObjects[0].SetColProperty("imdg_comp_grp_cd", {ComboText:"|"+imdg_comp_grp_cd[0], ComboCode:"|"+imdg_comp_grp_cd[0]} );
//			break;
			
		case IBSAVE:	//Save
			if(!validateForm(sheetObj,formObj,sAction)) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value = MULTI;
			sheetObj.DoSave("VOP_SCG_5021GS.do", {Param:FormQueryString(formObj), Col:'-1', Quest:true, Sync:1 });
			ComOpenWait(false);
			
			break;
		case IBINSERT:	// Row Add 
			var icnt = 0;
	        for(var i=3; i <= sheetObj.RowCount()+3; i++){
	    		if(sheetObj.GetCellValue(i , "ibflag") == "I"){
		        	ComShowCodeMessage("SCG50047");
		        	return false;
	    		}
	    	}
			
			sheetObj.DataInsert(-1);
			var	sRow = sheetObj.GetSelectRow() == -1 ? sheetObj.RowCount()+2:sheetObj.GetSelectRow();
	        
			if(ComGetObjValue(formObj.un_loc_cd_flg) == "S"){
				sheetObj.SetCellValue(sRow , "port_cd", "SGSIN", 0);
				sheetObj.SetCellValue(sRow , "pier_tp_cd", "S1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "J"){
				sheetObj.SetCellValue(sRow , "port_cd", "SAJED", 0);
				sheetObj.SetCellValue(sRow , "pier_tp_cd", "J1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "L"){
				sheetObj.SetCellValue(sRow , "port_cd", "FRLEH", 0);
				sheetObj.SetCellValue(sRow , "pier_tp_cd", "L1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "C"){
				sheetObj.SetCellValue(sRow , "port_cd", "CNSHA", 0);
				sheetObj.SetCellValue(sRow , "pier_tp_cd", "", 0);
			}

			break;
		
		case COMMAND01:	// Row Insert
			sheetObj.DataInsert();
			var row = sheetObj.GetSelectRow();
			
			if(ComGetObjValue(formObj.un_loc_cd_flg) == "S"){
				sheetObj.SetCellValue(row , "port_cd", "SGSIN", 0);
				sheetObj.SetCellValue(row , "pier_tp_cd", "S1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "J"){
				sheetObj.SetCellValue(row , "port_cd", "SAJED", 0);
				sheetObj.SetCellValue(row , "pier_tp_cd", "J1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "L"){
				sheetObj.SetCellValue(row , "port_cd", "FRLEH", 0);
				sheetObj.SetCellValue(row , "pier_tp_cd", "L1", 0);
			} else if(ComGetObjValue(formObj.un_loc_cd_flg) == "C"){
				sheetObj.SetCellValue(sRow , "port_cd", "CNSHA", 0);
				sheetObj.SetCellValue(sRow , "pier_tp_cd", "", 0);
			}
			
            //순번을 다시매긴다
			sheetObj.ReNumberSeq();
            
        	// For renumbering 
        	for(var i=3; i <= sheetObj.LastRow(); i++){
        		if(sheetObj.GetCellValue(i , "ibflag") == "R"){
        			sheetObj.SetCellValue(i , "ibflag", "U");
        		}
        	}

			break;

		case IBDELETE:	// DELETE
			//ComRowHideDelete(sheetObj, "ibcheck");
			var row = sheetObj.GetSelectRow();
			sheetObj.SetRowHidden(row, 1); 	 //행 숨기기
			sheetObj.SetRowStatus(row, "D");
			break;
			
		case IBSEARCH_ASYNC05:	//Yard Code
			setTmnlCombo(sheetObjects[1],false);
			break;

	}
}

/**
 * Validating inputted values of form
 * @param
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        switch (sAction) {
            case IBSAVE : 
            	//필수체크 Entry Type, Representative Description, class 필수체크
            	for(var i=3; i <= sheetObj.RowCount()+2; i++){
	            	if(!isCNSHA && sheetObj.GetCellValue(i, "lmt_wgt_tp_cd") == ""){
	            		ComShowCodeMessage("SCG50046", "Entry Type");
	            		sheetObj.SelectCell(i, "lmt_wgt_tp_cd", 1);
	            		return false;
	            	}
	            	if(sheetObj.GetCellValue(i, "port_lmt_rep_desc") == ""){
	            		ComShowCodeMessage("SCG50046", "Representative Description");
	            		sheetObj.SelectCell(i, "port_lmt_rep_desc", 1);
	            		return false;
	            	}
	            	if(sheetObj.GetCellValue(i, "v_clss_info") == ""){
	            		ComShowCodeMessage("SCG50046", "class");
	            		sheetObj.SelectCell(i, "v_clss_info", 1);
	            		return false;
	            		//팝업열기
	            		var Row = sheetObj.GetSelectRow();
	        			if(!sheetObj.GetCellEditable(Row, "clss_info")){
	        				//ComShowCodeMessage("SCG50041");
	        				var port_cd = sheetObj.GetCellText(Row, "port_cd");
	        				var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
	        				var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
	        				var port_lmt_seq = 0;
	        				
	        				if(lmt_wgt_tp_cd.length == 0){
	        					ComShowCodeMessage("SCG50045");
	        					return;
	        				}
	        				var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
	        			}else{
	        				var port_cd = sheetObj.GetCellText(Row, "port_cd");
	        				var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
	        				var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
	        				var port_lmt_seq = sheetObj.GetCellText(Row, "port_lmt_seq");
	        				
	        				var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
	        			}
	        			//ComOpenPopup(sUrl, 490, 490, "", "0,0", true);
	        			ComOpenPopup(sUrl, 1190, 1190, "", "0,0", true);
	            		return false;
	            	}
            	}
            	
            	//Prohibition이 체크가 안되 있는데 0이거나 값이 없다면 '값을 넣으시오' 메시지
            	for(var i=3; i <= sheetObj.RowCount()+2; i++){
	            	if(sheetObj.GetCellValue(i, "arr_dep_prohi_flg") == "0" && 
	            		(sheetObj.GetCellValue(i,"arr_max_qty") == "" || sheetObj.GetCellValue(i , "arr_max_qty") == 0)){
	            		ComShowCodeMessage("SCG50044", "Arrival & Depature Weight");
	            		sheetObj.SelectCell(i, "arr_max_qty", 1);
	            		return false;
	            	}
	            	// 입항 가능 하고, discharge 금지인 경우 등록 허가
	            	if(sheetObj.GetCellValue(i, "ldis_aply_tgt_flg") == "1" && 
//	            		(sheetObj.GetCellValue(i,"lod_max_qty") == "" || sheetObj.GetCellValue(i , "lod_max_qty") == 0)){
	            	    ("" + sheetObj.GetCellValue(i,"lod_max_qty") == "")){ // lod_max_qty가 int type이므로 ""과 0을 동일하게 취급
	            		ComShowCodeMessage("SCG50044", "Loading & Discharge Weight");
	            		sheetObj.SelectCell(i, "lod_max_qty", 1);
	            		return false;
	            	}
            	}            	

            	
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

	    case 'un_loc_cd' : // Setting Pier Type
	    	if(sheetObj.GetCellValue(row , "un_loc_cd") == "SGSIN"){
		    	sheetObj.SetCellValue(row , "pier_tp_cd","S1",0);
		    	sheetObj.SetCellValue(row , "port_cd","SGSIN",0);
	    	} else if (sheetObj.GetCellValue(row , "un_loc_cd") == "SAJED"){
		    	sheetObj.SetCellValue(row , "pier_tp_cd","J1",0);
		    	sheetObj.SetCellValue(row , "port_cd","SAJED",0);
	    	} else if (sheetObj.GetCellValue(row , "un_loc_cd") == "FRLEH") {
		    	sheetObj.SetCellValue(row , "pier_tp_cd","L1",0);
		    	sheetObj.SetCellValue(row , "port_cd","FRLEH",0);
	    	} else {
		    	sheetObj.SetCellValue(row , "pier_tp_cd","",0);
		    	sheetObj.SetCellValue(row , "port_cd","",0);
	    	}
	    break;
	
//	    case 'imdg_clss_cd' : // Setting IMDG Definition
//	         var sText = sheetObj.GetComboInfo(row, col, "Text");
//	         var arrText = sText.split("|");
//	         var idx = sheetObj.GetComboInfo(row, col, "SelectedIndex");
//	         if(idx != -1){
//	             sheetObj.SetCellValue(row, 'imdg_clss_cd_desc', arrText[idx]);
//	         }
//	         
//	         var sCode = sheetObj.GetComboInfo(row,col, "Code"); 
//	         var arrCode = sCode.split("|");
//	         for(i=0; i<arrCode.length; i++) {
//	             if(sheetObj.GetCellValue(row,col) == arrCode[i]) {
//	                 if(arrCode[i].indexOf("1.") != -1){
//	                	 sheetObjects[0].SetCellEditable(row, "imdg_comp_grp_cd", 1); 	
//	                	 sheetObjects[0].SetCellEditable(row, "imdg_subs_rsk_lbl_cd", 1); 	
//	                 }else {
//	                	 sheetObjects[0].SetCellValue(row, "imdg_comp_grp_cd", "");
//	                	 sheetObjects[0].SetCellValue(row, "imdg_subs_rsk_lbl_cd", "");
//	                	 sheetObjects[0].SetCellEditable(row, "imdg_comp_grp_cd", 0); 	
//	                	 sheetObjects[0].SetCellEditable(row, "imdg_subs_rsk_lbl_cd", 0); 	
//		             }
//	             } 
//	         }
//	    break;
	    
	    case 'arr_max_qty' : // Checking the arriveal max_qty
	    	sheetObj.SetCellValue(row , "dep_max_qty", sheetObj.GetCellValue(row , "arr_max_qty"), 0);
	    break;
	    
	    case 'lod_max_qty' : // Checking the load max_qty
	    	sheetObj.SetCellValue(row , "dchg_max_qty", sheetObj.GetCellValue(row , "lod_max_qty"), 0);
	    break;
	    
	    case 'port_lmt_sub_ppt_cd' : // Checking the flash ponit temperatur flg 
	    	var ppt_Code = sheetObj.GetComboInfo(row, col, "Code"); 
	    	var ppt_arrCode = ppt_Code.split("|");
	         for(i=0; i<ppt_arrCode.length; i++) {
	             if(sheetObj.GetCellValue(row,col) == ppt_arrCode[i]) {
	                 if(ppt_arrCode[i].indexOf("B") != -1){
	                	 sheetObj.SetCellEditable(row, "flsh_pnt_temp", 1); 	
	                 }else {
	                	 sheetObj.SetCellValue(row, "flsh_pnt_temp", "");
	                	 sheetObj.SetCellValue(row, "flsh_pnt_lowr_temp", "");
	                	 sheetObj.SetCellEditable(row, "flsh_pnt_temp", 0); 	
		             }
	             } 
	         }

	    break;
	    
	    case 'arr_dep_prohi_flg' : // Checking the Port Handling Prohibit Flag
	    	if(sheetObj.GetCellValue(row , "arr_dep_prohi_flg") == "1"){
	    		sheetObj.SetCellValue(row , "arr_max_qty", 0, 0);
	    		sheetObj.SetCellEditable(row, "arr_max_qty", 0);
	    		//Target Control - 비활성
	    		sheetObj.SetCellValue(row ,   "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(row ,"ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellValue(row ,   "lod_max_qty", "", 0);
	    		sheetObj.SetCellEditable(row, "lod_max_qty", 0);
	    	} else {
	    		sheetObj.SetCellValue(row , "arr_max_qty", "", 0);
	    		sheetObj.SetCellEditable(row, "arr_max_qty", 1); 
	    		//Target Control - 활성
	    		sheetObj.SetCellValue(row ,   "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(row ,"ldis_aply_tgt_flg", 1);
	    		sheetObj.SetCellEditable(row, "lod_max_qty", 1);
	    	}
	    	sheetObj.SetCellValue(row , "dep_max_qty", sheetObj.GetCellValue(row , "arr_max_qty"), 0);
	    break;
	    
	    case 'ldis_aply_tgt_flg' : // Checking the Port Handling Prohibit Flag
	    	if(sheetObj.GetCellValue(row , "ldis_aply_tgt_flg") == "0"){
	    		sheetObj.SetCellValue(row , "lod_max_qty", "", 0);
	    		sheetObj.SetCellEditable(row, "lod_max_qty", 0); 	
	    	} else {
	    		sheetObj.SetCellValue(row , "lod_max_qty", 0, 0);
	    		sheetObj.SetCellEditable(row, "lod_max_qty", 1); 
	    	}
	    	sheetObj.SetCellValue(row , "dchg_max_qty", sheetObj.GetCellValue(row , "lod_max_qty"), 0);
	    break;
	    
	    case 'flsh_pnt_temp' : // Checking the flash ponit temperatur
	    	sheetObj.SetCellValue(row , "flsh_pnt_lowr_temp", sheetObj.GetCellValue(row , "flsh_pnt_temp"), 0);
	    break;
	    

	}
}

/**
 * sheet2_OnChange
 * @param sheetObj, row, col, value
*/
function sheet2_OnChange(sheetObj, row, col, value){	
	switch( sheetObj.ColSaveName(col)  ){
	    case 'un_loc_cd' : // Setting Pier Type
	    	sheetObj.SetCellValue(row , "pier_tp_cd","C1",0);
	    	sheetObj.SetCellValue(row , "port_cd","CNSHA",0);
	    break;
	    case 'lod_max_teu_qty' : // Checking the load max_teu_qty
	    	sheetObj.SetCellValue(row , "dchg_max_teu_qty", sheetObj.GetCellValue(row , "lod_max_teu_qty"), 0);
	    break;
	    case 'ldis_aply_tgt_flg' : // Checking the Port Handling Prohibit Flag
	    	if(sheetObj.GetCellValue(row , "ldis_aply_tgt_flg") == "0"){
	    		sheetObj.SetCellValue(row , "lod_max_teu_qty", "", 0);
	    		sheetObj.SetCellEditable(row, "lod_max_teu_qty", 0); 	
	    	} else {
	    		sheetObj.SetCellValue(row , "lod_max_teu_qty", 0, 0);
	    		sheetObj.SetCellEditable(row, "lod_max_teu_qty", 1); 
	    	}
	    	sheetObj.SetCellValue(row , "dchg_max_teu_qty", sheetObj.GetCellValue(row , "lod_max_teu_qty"), 0);
	    break;
	}
}

/** 
 * VslSlanCd result handling  <br>
 * @param sheetObj, Row, Col
 * @return 
 * @author
 * @version
 */
//function sheet1_OnPopupClick(sheetObj, Row, Col) {
//	with(sheetObj){
////		var sUrl="/opuscntr/VOP_VSK_0202.do?intg_cd_id=CD00717";
////		gRow=Row;
////		ComOpenPopup(sUrl, 458, 470, "getSlanCdData", "0,0", true);
//		
//		var port_cd = sheetObj.GetCellText(Row, "port_cd");
//		var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
//		var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
//		var port_lmt_seq = sheetObj.GetCellText(Row, "port_lmt_seq");
//		
//		var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
////		gRow=Row;
//		ComOpenPopup(sUrl, 490, 490, "", "0,0", true); 
//	}
//}

function sheet1_OnDblClick(sheetObj, Row, Col, Val)
{
	with(sheetObj){
		if(sheetObj.ColSaveName(Col) == "v_clss_info"){
			if(!sheetObj.GetCellEditable(Row, "clss_info")){
				//ComShowCodeMessage("SCG50041");
				var port_cd = sheetObj.GetCellText(Row, "port_cd");
				var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
				var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
				var port_lmt_seq = 0;
				
				if(lmt_wgt_tp_cd.length == 0){
					ComShowCodeMessage("SCG50045");
					return;
				}
				var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
			}else{
				var port_cd = sheetObj.GetCellText(Row, "port_cd");
				var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
				var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
				var port_lmt_seq = sheetObj.GetCellText(Row, "port_lmt_seq");
				
				var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
			}
			ComOpenPopup(sUrl, 490, 490, "", "0,0", true);
//			ComOpenPopup(sUrl, 1190, 990, "", "0,0", true);
		}else if(sheetObj.ColSaveName(Col) == "v_imdg_subs_rsk_lbl_cd"){
			if(sheetObj.GetCellValue(Row, "ibflag") == "R"){//생성된 데이타 즉 조회된 데이타만 팝업
				var port_cd = sheetObj.GetCellText(Row, "port_cd");
				var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
				var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
				var port_lmt_seq = sheetObj.GetCellText(Row, "port_lmt_seq");
				
				var sUrl="/opuscntr/VOP_SCG_5923.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
				ComOpenPopup(sUrl, 336, 514, "", "0,0", true);
			}
		}
	}
}

function sheet2_OnDblClick(sheetObj, Row, Col, Val)
{
	with(sheetObj){
		if(sheetObj.ColSaveName(Col) == "v_clss_info"){
			var port_lmt_seq = 0;
			var port_cd = sheetObj.GetCellText(Row, "port_cd");
			var lmt_wgt_tp_cd = sheetObj.GetCellText(Row, "lmt_wgt_tp_cd");
			var port_lmt_rep_desc = sheetObj.GetCellText(Row, "port_lmt_rep_desc");
			if(sheetObj.GetCellEditable(Row, "clss_info")){
				port_lmt_seq = sheetObj.GetCellText(Row, "port_lmt_seq");
			}
			var sUrl="/opuscntr/VOP_SCG_5921.do?port_cd="+port_cd+"&lmt_wgt_tp_cd="+lmt_wgt_tp_cd+"&port_lmt_seq="+port_lmt_seq+"&port_lmt_rep_desc="+port_lmt_rep_desc;
			ComOpenPopup(sUrl, 490, 490, "", "0,0", true);
		}
	}
}

function getCurrentSheet() {
	if(isCNSHA) {
		return sheetObjects[1];
	} else {
		return sheetObjects[0];
	}
}

/** 
 * sheet1_OnSaveEnd  <br>
 * @param sheetObj, Code, ErrMsg
 * @return 
 * @author
 * @version
 */  
function sheet1_OnSearchEnd(sheetObj, Code, ErrMsg){
	if (sheetObjects[0].RowCount() > 0) {
		for(var i=3; i < sheetObj.RowCount()+3; i++){
			// Checking the IMDG CD
//			var imdg_cd = sheetObjects[0].GetCellValue(i, "imdg_clss_cd");
//            if(imdg_cd.indexOf("1.") != -1){
//	            sheetObjects[0].SetCellEditable(i, "imdg_comp_grp_cd", 1); 	
	            sheetObjects[0].SetCellEditable(i, "imdg_subs_rsk_lbl_cd", 1); 	
//            }else {
//	            sheetObjects[0].SetCellEditable(i, "imdg_comp_grp_cd", 0); 	
//	            sheetObjects[0].SetCellEditable(i, "imdg_subs_rsk_lbl_cd", 0); 	
//	        }
            
            // Checking the Port Limit Sub PPT Cd
//			var ppt_cd = sheetObjects[0].GetCellValue(i, "port_lmt_sub_ppt_cd");
//            if(ppt_cd.indexOf("B") != -1){
//	            sheetObjects[0].SetCellEditable(i, "flsh_pnt_temp", 1); 	
//            }else {
//	            sheetObjects[0].SetCellEditable(i, "flsh_pnt_temp", 0); 	
//	        }

            // Checking the Port Handling Prohibit Flag
	    	if(sheetObj.GetCellValue(i , "arr_dep_prohi_flg") == "1"){
	    		sheetObj.SetCellValue(i , "arr_max_qty", 0, 0);
	    		sheetObjects[0].SetCellEditable(i, "arr_max_qty", 0); 	
	    		//Target Control - 비활성
	    		sheetObj.SetCellValue(i ,   "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(i ,"ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellValue(i ,   "lod_max_qty", "", 0);
	    		sheetObj.SetCellEditable(i, "lod_max_qty", 0);
	    	}else{
	    		//Target Control - 활성
	    		//sheetObj.SetCellValue(i, "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(i, "ldis_aply_tgt_flg", 1);
	    		sheetObj.SetCellEditable(i, "lod_max_qty", 1);
	    	}
	    	
	    	if(sheetObj.GetCellValue(i , "ldis_aply_tgt_flg") == "0"){
	    		sheetObj.SetCellValue(i, "lod_max_qty", "", 0);
	    		sheetObjects[0].SetCellEditable(i, "lod_max_qty", 0);
	    	}
	    	
	    	sheetObjects[0].SetCellEditable(i, "clss_info", 1);
	    	
	    	//Drag
	    	sheetObjects[0].SetRowDraggable(i, 0);
		}
	}
}

function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg){
	if (sheetObj.RowCount() > 0) {
		for(var i=3; i < sheetObj.RowCount()+3; i++){
            // Checking the Port Handling Prohibit Flag
	    	if(sheetObj.GetCellValue(i , "arr_dep_prohi_flg") == "1"){
	    		sheetObj.SetCellValue(i , "arr_max_qty", 0, 0);
	    		sheetObj.SetCellEditable(i, "arr_max_qty", 0); 	
	    		//Target Control - 비활성
	    		sheetObj.SetCellValue(i ,   "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(i ,"ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellValue(i ,   "lod_max_qty", "", 0);
	    		sheetObj.SetCellEditable(i, "lod_max_qty", 0);
	    	}else{
	    		//Target Control - 활성
	    		//sheetObj.SetCellValue(i, "ldis_aply_tgt_flg", 0);
	    		sheetObj.SetCellEditable(i, "ldis_aply_tgt_flg", 1);
	    		sheetObj.SetCellEditable(i, "lod_max_qty", 1);
	    	}
	    	if(sheetObj.GetCellValue(i , "ldis_aply_tgt_flg") == "0"){
	    		sheetObj.SetCellValue(i, "lod_max_qty", "", 0);
	    		sheetObj.SetCellEditable(i, "lod_max_qty", 0);
	    	}
	    	sheetObj.SetCellEditable(i, "clss_info", 1);
		}
	}
}

function sheet1_OnDragStart(Row, Col) {
	// Drag 시작위치의 CellValue를 저장
	dragValue = sheet1.GetCellValue(Row, Col) ;
}

/** 
 * sheet1_OnSaveEnd  <br>
 * @param sheetObj, Code, ErrMsg
 * @return 
 * @author
 * @version
 */  
function sheet1_OnSaveEnd(sheetObj, Code, ErrMsg){
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	doActionIBSheet(sheetObject, formObject, IBSEARCH);
}

/** 
 * sheet2_OnSaveEnd  <br>
 * @param sheetObj, Code, ErrMsg
 * @return 
 * @author
 * @version
 */  
function sheet2_OnSaveEnd(sheetObj, Code, ErrMsg){
	doActionIBSheet(sheetObject, document.form, IBSEARCH);
}

function setTmnlCombo(sheetObj, add) {
	var sParam=Array();
	sParam[0]="loc_cd=CNSHA";
	sParam[1]="f_cmd="+SEARCH01;
	var xmlStr=sheetObj.GetSearchData("VOP_VSK_0014GS.do", sParam.join("&"));
	if(xmlStr != null && xmlStr != undefined && xmlStr != "") {
		var ydKind=" |" + ComGetEtcData(xmlStr, "yd_kind");
		var ydCd=" |" + ComGetEtcData(xmlStr, "yd_cd");
		var ydNm=" |" + ComGetEtcData(xmlStr, "yd_nm");
		var ydTxt="";
		var ydCdTxt="";
		if(ydCd != null && ydCd != undefined && ydCd != ""){
			var ydCdArr=ydCd.split("|");
			var ydNmArr=ydNm.split("|");
			var ydKindArr=ydKind.split("|");
			var ydCnt=ydCdArr.length;
			for(var i=0; i<ydCnt; i++){
				if(ydKindArr[i]=='06'||ydKindArr[i]=='07'||ydKindArr[i]=='08'
				 ||ydKindArr[i]=='09'||ydKindArr[i]=='10'||ydKindArr[i]=='12') {
					if(ydTxt!='') {
						ydTxt = ydTxt + "|";
						ydCdTxt = ydCdTxt + "|";
					}
					ydTxt = ydTxt + ydCdArr[i] + "\t" + ydNmArr[i];
					ydCdTxt = ydCdTxt + ydCdArr[i];
				}
			}
			if(add) {
				sheetObj.CellComboItem(sheetObj.GetSelectRow(),"yd_cd", {ComboText:ydTxt, ComboCode:ydCdTxt} );
			} else {
				sheetObj.SetColProperty("yd_cd", {ComboText:ydTxt, ComboCode:ydCdTxt} );
			}
		}
	}
}