/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_SCG_5022
*@FileTitle  : Port Limits DG Total Weight Check
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

var gImgAry=new Array();//이미지
var gFontAry=new Array();//컬럼폰트색상대상 컬럼
var gColAry=new Array();//컬럼폰트색상

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
		
	        case "btn_SlanCd":
				onPopupClick(srcName, "Lane");
				break;
				
	        case "btn_VVDpop":
				onPopupClick(srcName, "VVD");
				break;
			
            case "btn_Calendar":
            	var cal = new ComCalendarFromTo();                	
            	cal.select(formObject.from_eta_dt, formObject.to_eta_dt, 'yyyy-MM-dd');
 				break;
		
			case "btn_retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;

			case "btn_new":
				sheetObject.RemoveAll();
				form.reset();
				searchVVDCheck();
				break;
				
			case "btn_DownExcel":
				doActionIBSheet(sheetObject,formObject,IBDOWNEXCEL);
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
	initControl();	

    $("#from_eta_dt").attr("value", ComGetDateAdd(null, "d", 0));
    $("#to_eta_dt").attr("value"  , ComGetDateAdd(null, "d", 30));	//15->30 으로 조정
	//vvdClassChange();
	
	//@@차후 삭제!!!!
    //document.querySelector("#from_eta_dt").removeAttribute('required');
    //document.querySelector("#to_eta_dt").removeAttribute('required');
	//document.querySelector("#vsl_cd").removeAttribute('required');
	//document.querySelector("#skd_voy_no").removeAttribute('required');
	//document.querySelector("#skd_dir_cd").removeAttribute('required');
	
    doActionIBCombo(comboObjects[0],1);
    
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
//	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
	
    //doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
    //sheet1_OnLoadFinish(sheet1);
}

/**
      * Loading the event of HTML Control <br>
 * {@link #loadPage} Initializing IBSheet Object <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {int}     sheetNo     The order number of sheetObjects array
 **/
function initControl() {
	var formObj=document.form;
	axon_event.addListenerFormat ('blur', 'obj_focusout', form);
	axon_event.addListener('change', 'plmt_pord_cd_OnChange', 'plmt_port_cd');
}

//Handling business javascript OnFocusOut event
function obj_focusout() {
	pastEventNum=0;
	var formObj=document.form;
	with(ComGetEvent()) {
    	switch(name) { 
	    	case "slan_cd1":	//Lane Check
	    		searchLaneCheck();	
	        	break;
	    	case "vsl_cd":	//VVD Check
	    		searchVVDCheck();
//	    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '' && ComGetObjValue(formObj.skd_dir_cd) != '') {
//	    			searchVVDCheck();						
//	    		}
	        	break;
	    	case "skd_voy_no":	//VVD Check
	    		searchVVDCheck();
//	    		if(value != '' && ComGetObjValue(formObj.skd_voy_no) != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_dir_cd) != '') {
//	    			searchVVDCheck();						
//	    		}
	        	break;
	    	case "skd_dir_cd":	//VVD Check
	    		searchVVDCheck();
//	    		if(value != '' && ComGetObjValue(formObj.vsl_cd) != '' && ComGetObjValue(formObj.skd_voy_no) != '') {
//	    			searchVVDCheck();						
//	    		}
	        	break;
	    	case "from_eta_dt":	
	    		ComAddSeparator(ComGetEvent());
	    		//vvdClassChange();
	    		break;
	    	case "to_eta_dt":
	    		
	    		ComAddSeparator(ComGetEvent());
	    		//vvdClassChange();
	    		if (ComGetObjValue(formObj.from_eta_dt) != '' && ComGetObjValue(formObj.to_eta_dt) != '') {
		        	if(ComGetDaysBetween(ComGetObjValue(formObj.from_eta_dt), ComGetObjValue(formObj.to_eta_dt)) > 31) {//31) {
	        			ComShowCodeMessage('SCG50032', 'month');
	        			value="";
	        			ComSetFocus(ComGetEvent());
	        			return false;
		        	}
		        	
		    		var fmDt=ComReplaceStr(ComGetObjValue(formObj.from_eta_dt), "-", "");
		    		var toDt=ComReplaceStr(ComGetObjValue(formObj.to_eta_dt), "-", "");
		    		if(ComChkPeriod(fmDt, toDt) < 1){
		    			ComShowCodeMessage('SCG50036');
		    			return false;
		    		}else{
		    			return true;
		    		}
	    		}
	        	break;
    	}
    }
} 

/**
 * initializing Combo
 * Setting Combo items
 * @param comboObj, comboNo
 */
function initCombo(comboObj, comboNo) {
   switch(comboObj.options.id) {
		case "imdg_clss_cd":  
  			with(comboObj) {	
				SetEnable(1);
//				SetMultiSelect(0);
//	            SetUseAutoComplete(1);
//	        	SetTitle("Class|Definition");
//	        	SetColWidth(0, "50");
//	        	SetColWidth(1, "700");
//	        	SetDropHeight(100000);
//	            //no support[check again]CLT ValidChar(2,3);
//	            SetMaxLength(3);
  			}
  			break;  
   }
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
 * Define the initial values and headers of sheets
 * @param sheetObj,sheetNo
 * 
 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
//            var HeadTitle  = "|Lane|VVD CD|VVD CD|VVD CD|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Entry Type|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR Type|FP\n(°C)" +
//            				 "|Arrival Port Limit|Arrival Port Limit|Arrival Port Limit|Discharge Port Limit|Discharge Port Limit|Discharge Port Limit|Load Port Limit|Load Port Limit|Load Port Limit|Departure Port Limit|Departure Port Limit|Departure Port Limit|Property Remark|BKG Info" ;
//            var HeadTitle2 = "|Lane|VSL|VOY|DIR|Arr|L|D|Dep|Entry Type|Class|Comp|Sub.Risk(s)|UN No.|PG|CNTR Type|FP\n(°C)" +
//            		         "|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Property Remark|BKG Info" ;

            var HeadTitle  = "|Lane|VVD CD|VVD CD|VVD CD|VVD CD|VVD CD|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Representative Description|Entry Type|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR Type|FP\n(°C)" +
			 				 "|Arrival Port Limit(KGS)|Arrival Port Limit(KGS)|Arrival Port Limit(KGS)|Discharge Port Limit(KGS)|Discharge Port Limit(KGS)|Discharge Port Limit(KGS)|Load Port Limit(KGS)|Load Port Limit(KGS)|Load Port Limit(KGS)|Departure Port Limit(KGS)|Departure Port Limit(KGS)|Departure Port Limit(KGS)|Property Remark|BKG Info|||||||" ;
            var HeadTitle2 = "|Lane|VVD CD|VVD CD|VVD CD|VVD CD|VVD CD|Arr|D|L|Dep|Arr|D|L|Dep|Representative Description|Entry Type|Class|Comp|Sub.Risk(s)|UN No.|PG|CNTR Type|FP\n(°C)" +
	         				 "|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Cargo|Ratio(%)|Limit|Property Remark|BKG Info||||||||" ;
			
            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = 
              [ {Type:"Text",  		Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rn",                KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",  		Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:24,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
               

	            {Type:"Text",       Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"plmt_vvd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                
	            {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"plmt_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"pier_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                {Type:"Text",       Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"port_cd",           KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"arr_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dis_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lod_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dep_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                //Excel용
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"arr_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"dis_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"lod_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"dep_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                
                {Type:"Text",       Hidden:0, Width:350,  Align:"Left",  ColMerge:0,   	 SaveName:"port_lmt_rep_desc", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 , MultiLineText:true },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lmt_wgt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
//              {Type:"Text",       Hidden:1, Width:480,  Align:"Left",    ColMerge:0,   SaveName:"imdg_clss_cd_desc", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",		  		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",      	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Int",        Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_temp",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},	//NullInteger
                //arr
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"arr_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"arr_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"arr_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //dchg
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dchg_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"dchg_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dchg_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //lod
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lod_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"lod_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lod_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //dep
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dep_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"dep_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dep_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //Hidden
                {Type:"Text",       Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ppt_flg_rmk",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"arr_dep_prohi_flg", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
//                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ldis_prohi_flg",    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ldis_aply_tgt_flg",    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                //{Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"fp_chk",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                //{Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_temp",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                //{Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"flsh_pnt_cdo_temp",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"arrival_bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"discharge_bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"load_bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"departure_bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"port_lmt_seq",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                ];
            
            InitColumns(cols);
            //SetSheetHeight(400);
            SetHeaderRowHeight(10);
            SetEditable(1);
            SetImageList(0,"img/btng_icon_green.gif");
            SetImageList(1,"img/btng_icon_y.gif");
            SetImageList(2,"img/btng_icon_r.gif");
//            SetImageList(1,"img/btns_plus.gif");
//            SetImageList(2,"img/btns_plus.gif");
//            SetImageList(3,"img/btns_plus.gif");
            
            SetColProperty("lmt_wgt_tp_cd", {ComboText:"|GROSS|NET|NET POWDER", ComboCode:"|GR|NT|NP"} );
            SetColProperty("imdg_pck_grp_cd", {ComboText:"|I|II|III", ComboCode:"|1|2|3"} );
            SetColProperty("port_lmt_sub_ppt_cd", {ComboText:"|Below|Except", ComboCode:"|B|E"} );
            SetColProperty("ppt_explo_flg", {ComboText:"N|Y", ComboCode:"N|Y"} );
            SetColProperty("ppt_prohi_flg", {ComboText:"N|P", ComboCode:"N|P"} );
            
            SetShowButtonImage(1);
            
//			헤더 색갈 및 툴팁 적용
			for(z=0; z<=cols.length; z++){
				
				if(GetCellValue(0,z) == "Arrival Port Limit(KGS)"){
					SetCellBackColor(0, z, "#99004C");
					SetCellBackColor(1, z, "#99004C");
					SetToolTipText(0, z, "Arrival Port Limit(KGS)");
				}else if(GetCellValue(0,z) == "Discharge Port Limit(KGS)" || GetCellValue(0,z) == "Load Port Limit(KGS)"){
					SetCellBackColor(1, z, "#8080FF");
					SetCellBackColor(0, z, "#8080FF");
					SetToolTipText(1, z, "Load Port Limit");
				}else if(GetCellValue(0,z) == "Departure Port Limit(KGS)"){
					SetCellBackColor(1, z, "#0000FF");
					SetCellBackColor(0, z, "#0000FF");
					SetToolTipText(1, z, "Departure Port Limit(KGS)");
				}/*else if(GetCellValue(1,z) == "Additional Leased(Income)"){
					SetCellBackColor(1, z, "#99004C");
					SetToolTipText(1, z, "Additional Leased(Income)");
				}else if(GetCellValue(1,z) == "Additional Chartered(Expense)"){
					SetCellBackColor(1, z, "#22741C");
					SetToolTipText(1, z, "Additional Chartered(Expense)");
				}	*/	
			} 
			
			resizeSheet(); 
		   	}
			
			break;

		case 2:      //sheet2 init(shanghai)
			with (sheetObj) {
            var HeadTitle  = "|Lane|VVD CD|VVD CD|VVD CD|VVD CD|Limit Signal|Limit Signal|Limit Signal|Limit Signal|Representative Description|Entry Type|IMDG|IMDG|IMDG|IMDG|IMDG|CNTR Type|FP\n(°C)" +
			 				 "|Discharge Port Limit(Qty)|Discharge Port Limit(Qty)|Discharge Port Limit(Qty)|Load Port Limit(Qty)|Load Port Limit(Qty)|Load Port Limit(Qty)|Property Remark|BKG Info|||" ;
            var HeadTitle2 = "|Lane|VVD CD|VVD CD|VVD CD|VVD CD|D|L|D|L|Representative Description|Entry Type|Class|Comp|Sub.Risk(s)|UN No.|PG|CNTR Type|FP\n(°C)" +
	         				 "|Container|Ratio(%)|Limit|Container|Ratio(%)|Limit|Property Remark|BKG Info|||" ;
			
            SetConfig( { SearchMode:2, MergeSheet:7, Page:20, DataRowMerge:0 } );
			
            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);
            var cols = 
              [ {Type:"Text",  		Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rn",                KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",  		Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",           KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0, Width:55,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",            KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:0, Width:24,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                
                {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:0,   SaveName:"plmt_clpt_ind_seq",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"dis_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"lod_img", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                //Excel용
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"dis_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                {Type:"Text",     Hidden:1, Width:40,   Align:"Center",   ColMerge:0,   SaveName:"lod_img_txt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                
                {Type:"Text",       Hidden:0, Width:490,  Align:"Left",  ColMerge:0,   	 SaveName:"port_lmt_rep_desc", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 , MultiLineText:true },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lmt_wgt_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },                
                {Type:"Text",       Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_clss_cd",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_comp_grp_cd",		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"imdg_subs_rsk_lbl_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Text",       Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"imdg_un_no",		  		KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"imdg_pck_grp_cd",	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Combo",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp_cd",      	KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},
                {Type:"Int",        Hidden:1, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"flsh_pnt_temp",      KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0},	//NullInteger
                //dchg
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dchg_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"dchg_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"dchg_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //lod
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lod_cgo_wgt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"Float",    Hidden:0, Width:65,   Align:"Right",   ColMerge:0,   SaveName:"lod_lmt_rto",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },	//Float
                {Type:"AutoSum",    Hidden:0, Width:80,   Align:"Right",   ColMerge:0,   SaveName:"lod_max_lmt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },	//Float
                //Hidden
                {Type:"Text",       Hidden:1, Width:120,  Align:"Center",  ColMerge:0,   SaveName:"ppt_flg_rmk",       KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bkg_no",     	   KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"arr_dep_prohi_flg", KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                {Type:"Text",       Hidden:1, Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ldis_aply_tgt_flg",    KeyField:0,   CalcLogic:"",   Format:"",   PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                ];
            InitColumns(cols);
            SetSheetHeight(400);
            SetHeaderRowHeight(10);
            SetEditable(1);
            SetImageList(0,"img/btng_icon_green.gif");
            SetImageList(1,"img/btng_icon_y.gif");
            SetImageList(2,"img/btng_icon_r.gif");
            
            SetShowButtonImage(1);
            
//			헤더 색갈 및 툴팁 적용
			for(z=0; z<=cols.length; z++){
				
				if(GetCellValue(0,z) == "Discharge Port Limit(Qty)" || GetCellValue(0,z) == "Load Port Limit(Qty)"){
					SetCellBackColor(1, z, "#8080FF");
					SetCellBackColor(0, z, "#8080FF");
					SetToolTipText(1, z, "Load Port Limit");
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

function loadDischarge(){
	var sheet1 = sheetObjects[0];
	if(document.getElementById("load_discharge").checked) {
		sheet1.SetColHidden("dchg_cgo_wgt", 0);
		sheet1.SetColHidden("dchg_lmt_rto", 0);
		sheet1.SetColHidden("dchg_max_lmt", 0);
		sheet1.SetColHidden("lod_cgo_wgt",  0);
		sheet1.SetColHidden("lod_lmt_rto",  0);
		sheet1.SetColHidden("lod_max_lmt",  0);
	}else{
		sheet1.SetColHidden("dchg_cgo_wgt", 1);
		sheet1.SetColHidden("dchg_lmt_rto", 1);
		sheet1.SetColHidden("dchg_max_lmt", 1);
		sheet1.SetColHidden("lod_cgo_wgt",  1);
		sheet1.SetColHidden("lod_lmt_rto",  1);
		sheet1.SetColHidden("lod_max_lmt",  1);
	}
}

function getImg(img){
	var imgRtn = "";
	if(img == "img/btng_icon_green.gif"){
		imgRtn = "G";
	}else if(img == "img/btng_icon_y.gif"){
		imgRtn = "Y";
	}else if(img == "img/btng_icon_r.gif"){
		imgRtn = "R";
	}else{
		imgRtn = "B";
	}
	return imgRtn;  
}

function bkgDetPop(){
    
	var sheetObj	= sheetObjects[0];
	if(isCNSHA) {
		sheetObj	= sheetObjects[1];
	}
	var Row = sheetObj.GetSelectRow();
	
	var vslCd  		= sheetObj.GetCellValue(Row, "vsl_cd");
	var skdVoyNo  	= sheetObj.GetCellValue(Row, "skd_voy_no");
	var skdDirCd  	= sheetObj.GetCellValue(Row, "skd_dir_cd");
	var plmtVvd      = sheetObj.GetCellValue(Row, "plmt_vvd");
	
	var authFlg		= "";	/* Y, R, P, T */
	if(document.form.auth_flg[0].checked == true){
		authFlg	= "Y";
	}else if(document.form.auth_flg[1].checked == true){
		authFlg	= "R";
	}else if(document.form.auth_flg[2].checked == true){
		authFlg	= "P";
	}else if(document.form.auth_flg[3].checked == true){
		authFlg	= "A";
	}
	
	
	var plmtPortCd	= "";	/* SGSIN, SAJED, FRLEH, CNSHA */
	if(document.form.plmt_port_cd[0].checked == true){
		plmtPortCd	= "SGSIN";
	}else if(document.form.plmt_port_cd[1].checked == true){
		plmtPortCd	= "SAJED";
	}else if(document.form.plmt_port_cd[2].checked == true){
		plmtPortCd	= "FRLEH";
	//}else if(document.form.plmt_port_cd[3].checked == true){
	//	plmtPortCd	= "CNSHA";
	}		
		
	var imgAry  = new Array();
		
	//2016-04-19 START
	var arrBkgStr  = sheetObj.GetCellValue(Row, "arrival_bkg_no");
	var disBkgStr  = sheetObj.GetCellValue(Row, "discharge_bkg_no");
	var lodBkgStr  = sheetObj.GetCellValue(Row, "load_bkg_no");
	var depBkgStr  = sheetObj.GetCellValue(Row, "departure_bkg_no");
	
	var sPortLmtSeq	= sheetObj.GetCellValue(Row, "port_lmt_seq");
	//var sVvd		= sheetObj.GetCellValue(Row, "vsl_cd")+sheetObj.GetCellValue(Row, "skd_voy_no")+sheetObj.GetCellValue(Row, "skd_dir_cd");
	
	var arrBkg  = arrBkgStr.split(",");	//팝업 전체 데이타조회용
	var disBkg  = disBkgStr.split(",");	//팝업 전체 데이타조회용		
	var lodBkg  = lodBkgStr.split(",");	//팝업 전체 데이타조회용		
	var depBkg  = depBkgStr.split(",");	//팝업 전체 데이타조회용		

	var arrBkgAry = new Array();
	var disBkgAry = new Array();
	var lodBkgAry = new Array();
	var depBkgAry = new Array();
			
	var arrBkgCnt = arrBkg.length;
	var disBkgCnt = disBkg.length;	
	var lodBkgCnt = lodBkg.length;	
	var depBkgCnt = depBkg.length;	
	
	for(var i=0; i < arrBkgCnt; i++){
		var bkgNo = arrBkg[i];
		arrBkgAry.push(bkgNo);
	}			
	for(var j=0; j < disBkgCnt; j++){
		var bkgNo = disBkg[j];
		disBkgAry.push(bkgNo);
	}	
	for(var k=0; k < lodBkgCnt; k++){
		var bkgNo = lodBkg[k];
		lodBkgAry.push(bkgNo);
	}
	for(var l=0; l < depBkgCnt; l++){
		var bkgNo = depBkg[l];
		depBkgAry.push(bkgNo);
	}

	
	var arr_img = sheetObj.GetCellValue(Row, "arr_img");
	var dis_img = sheetObj.GetCellValue(Row, "dis_img");
	var lod_img = sheetObj.GetCellValue(Row, "lod_img");
	var dep_img = sheetObj.GetCellValue(Row, "dep_img");
	
	imgAry.push(getImg(arr_img));
	imgAry.push(getImg(dis_img));
	imgAry.push(getImg(lod_img));
	imgAry.push(getImg(dep_img));

	var sUrl	= "/opuscntr/VOP_SCG_5922.do?port_lmt_seq="+sPortLmtSeq;
		//sUrl   += "&bkg_nos1="+arrBkgAry;
		//sUrl   += "&bkg_nos2="+disBkgAry;
		//sUrl   += "&bkg_nos3="+lodBkgAry;
		//sUrl   += "&bkg_nos4="+depBkgAry;
		sUrl   += "&rdo_img="+imgAry;
		sUrl   += "&vslCd="+vslCd;
		//sUrl   += "&skdVoyNo="+skdVoyNo;
		//sUrl   += "&skdDirCd="+skdDirCd;
		sUrl   += "&auth_flg="+authFlg;
		sUrl   += "&plmtVvd="+plmtVvd;
		sUrl   += "&plmt_port_cd="+plmtPortCd
		sUrl   += "&from_eta_dt="+document.form.from_eta_dt.value;
		sUrl   += "&to_eta_dt="+document.form.to_eta_dt.value;
		//sUrl   += "&plmt_clpt_ind_seq="+document.form.plmt_clpt_ind_seq.value;
		sUrl   += "&plmt_clpt_ind_seq="+sheetObj.GetCellValue(Row, "plmt_clpt_ind_seq");
		
	ComOpenPopup(sUrl, 1110, 600, "", "0,0", true);

}

/**
 * Downloading file <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj's selected Row
 * @param {ibsheet} Col     	sheetObj's selected Col
 * @param {String} 	Value     	file name
 **/
/*function sheet1_OnDblClick(sheetObj, Row, Col, Value){
	if(sheetObj.GetCellValue(Row, "bkg_no") != "") {
		
		var bkgStr = sheetObj.GetCellValue(Row, "bkg_no");
		var bkgAry = bkgStr.split(",");
		bkgAry.sort(); //정렬

		// 정렬 후 앞과 뒤가 같으면 앞의 것을 지워버림.
		var i=-1, j = bkgAry.length;
		while(++i < j-1)
		{
		  if(bkgAry[i] == bkgAry[i+1]){
			  bkgAry[i]='';
		  }
		}

		var bkgStrRtn = bkgAry.toString(); // 다시 문자열로...
		var bkgAryRtn = bkgStrRtn.match(/\w+/g); // 빈 것이 아니면 배열로 넣음.
		
		var sUrl="/opuscntr/VOP_SCG_5922.do?bkg_nos="+bkgAryRtn;
		ComOpenPopup(sUrl, 510, 450, "", "0,0", true);
	}
	return;
}*/

/**
 * doActionIBSheet
 * @param sheetObj,formObj,sAction
 * 
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	
	switch(sAction) {
		case IBSEARCH:	//Retrieve
			if(!validateForm(sheetObj,formObj,sAction)){return;}	
			ComOpenWait(true);					
			formObj.f_cmd.value=SEARCH;
			
			var xml = sheetObj.GetSearchData("VOP_SCG_5022GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(xml,{Sync:1} );
			ComOpenWait(false);
			break;
			
		case IBSEARCH_ASYNC01:	//Serching IMDG Code Combo 
			formObj.f_cmd.value=SEARCH02;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var class_cd=ComXml2ComboString(sXml, "imdg_clss_cd", "imdg_clss_cd_desc");
			var tStr=ComScgClossAppend(class_cd[0], class_cd[1] );
			var tStr1 = tStr.substr(0, tStr.length-1);
			//Class
			sheetObjects[0].SetColProperty("imdg_clss_cd", {ComboText:"|"+tStr1, ComboCode:"|"+class_cd[0]} );
			//Subsidiary Risk(s)
			sheetObjects[0].SetColProperty("imdg_subs_rsk_lbl_cd", {ComboText:"|"+class_cd[0], ComboCode:"|"+class_cd[0]} );
			break;
		
		case IBSEARCH_ASYNC02:	//Serching CNTR TP Code Combo 
			formObj.f_cmd.value=SEARCH21;
			var sXml=sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", FormQueryString(formObj));
			var cntr_cd=ComXml2ComboString(sXml, "cntr_tp_cd", "cntr_tp_desc");
			var tStr=ComScgClossAppend(cntr_cd[0], cntr_cd[1] );
			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObjects[0].SetColProperty("cntr_tp_cd", {ComboText:"ALL"+"|"+tStr1, ComboCode:"|"+cntr_cd[0]} );
			break;
		
		case IBSEARCH_ASYNC03:	//Serching Un No. Code Combo 
			formObj.f_cmd.value=SEARCH06;
			var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
			var un_no=ComXml2ComboString(sXml, "imdg_un_no", "prp_shp_nm");
			var tStr=ComScgClossAppend(un_no[0], un_no[1] );
			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObjects[0].SetColProperty("imdg_un_no", {ComboText:"|"+un_no[0], ComboCode:"|"+un_no[0]} );
			break;
			
		case IBSEARCH_ASYNC04:   //Division of Class retrieve
			formObj.f_cmd.value=SEARCH;
			var sXml=sheetObj.GetSearchData("VOP_SCG_0047GS.do", FormQueryString(formObj));
			var imdg_comp_grp_cd=ComXml2ComboString(sXml, "imdg_comp_grp_cd", "imdg_comp_grp_cd");
			var tStr=ComScgClossAppend(imdg_comp_grp_cd[0], imdg_comp_grp_cd[1] );
			var tStr1 = tStr.substr(0, tStr.length-1);
			sheetObjects[0].SetColProperty("imdg_comp_grp_cd", {ComboText:"|"+imdg_comp_grp_cd[0], ComboCode:"|"+imdg_comp_grp_cd[0]} );
			break;

      	case IBDOWNEXCEL:
      		if(sheetObj.RowCount() < 1){//no data
          	  ComShowCodeMessage("COM132501");
          	  return;
          	}
      		
      		sheetObj.SetColHidden("arr_img", 1);
      		sheetObj.SetColHidden("dis_img", 1);
      		sheetObj.SetColHidden("lod_img", 1);
      		sheetObj.SetColHidden("dep_img", 1);
      		sheetObj.SetColHidden("arr_img_txt", 0);
      		sheetObj.SetColHidden("dis_img_txt", 0);
      		sheetObj.SetColHidden("lod_img_txt", 0);
      		sheetObj.SetColHidden("dep_img_txt", 0);
      		
            var paramObj=new Object();
            paramObj.title="Port Limits DG Total Weight Check";
//            paramObj.cols="12";
//            paramObj.columnwidth="1:5|2:5|3:5|4:5|5:70|6:10|7:10|8:10|9:10|10:10|11:40|12:10";
            paramObj.columnwidth=ComScgGetExcelDown(sheetObj);
            paramObj.cols=ComScgGetExcelDownCols(sheetObj);
            paramObj.datarowheight="0:25";
            var url=ComScgGetPgmTitle(sheetObj, paramObj); 

            //sheetObj.Down2Excel({ HiddenColumn:-1,TreeLevel:false});
            if(sheetObj.RowCount() < 1){//no data
      		  ComShowCodeMessage("COM132501");
  	       	}else{
  	       		//var pathArr = url.split("?");
     	       	var str = sheetObjects[0].GetSearchData(url);
     	       	str = str.replace(/(^\s*)|(\s*$)/gi, "");
     	       sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1,ReportXML:str});
  	       	}
            
      		sheetObj.SetColHidden("arr_img", 0);
      		sheetObj.SetColHidden("dis_img", 0);
      		sheetObj.SetColHidden("lod_img", 0);
      		sheetObj.SetColHidden("dep_img", 0);
      		sheetObj.SetColHidden("arr_img_txt", 1);
      		sheetObj.SetColHidden("dis_img_txt", 1);
      		sheetObj.SetColHidden("lod_img_txt", 1);
      		sheetObj.SetColHidden("dep_img_txt", 1);            
//            sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
      		break;
	}
}

/**
 * Validating inputted values of form
 * @param sheetObj,formObj,sAction
 */
function validateForm(sheetObj,formObj,sAction){
    with(formObj){
        switch (sAction) {
	        case IBSEARCH:
	        	//vvdClassChange();
	        	
	        	if(!ComChkValid(formObj, true, false, false)) {
	                return false;
	            }
	            
	        break;
        
//            case IBSAVE : 
//					var Row = sheetObj.ColValueDup("slan_cd|un_loc_cd|imdg_clss_cd",false);
//					if( Row != -1){
//     	    		 ComShowCodeMessage("SCG50005", "Data");
//         	    	 sheetObj.SelectCell(Row, "slan_cd");
//					 return false;
//					}
//					
//	                if( !ComShowCodeConfirm("SCG50001", "data" ) ){
//	                      return false;   
//                    }
//			   break;
	            
        }            	    	 
  }
  return true;
}

/**
 * Handling sheet1 OnLoadFinish Event
 * param : sheetObj ==> sheet object, ErrMsg ==> result Message
 * 
 */
function sheet1_OnLoadFinish(sheetObj) {	
	 
}

/**
 * sheet1_OnChange
*/
function sheet1_OnChange(sheetObj, row, col, value){	
	switch( sheetObj.ColSaveName(col)  ){
//	    case 'slan_cd' : // Lane Validation Check
//			if( sheetObj.GetCellValue(row, col).length != 3 ){
//	    	     ComShowCodeMessage("SCG50006", "Lane Code", "3");	
//	    	     sheetObj.SetCellValue(row , "slan_cd","",0);
//	    	     sheetObj.SelectCell(row, "slan_cd");
//	    	     return false;
//			}    		 
//			getVslSlanCd(sheetObj, row, col);
//	    break;
	}
}

/**
 * Lane Check
 */
function searchLaneCheck() {
 	var formObj  = document.form;
 	var sheetObj = sheetObjects[0];
 	var slan_cd1 = ComGetObjValue(formObj.slan_cd1);
 	if(slan_cd1 != '') {
     	var sParam = Array();
 	  	sParam[0] = "vsl_slan_cd="+slan_cd1;
 	  	sParam[3] = "f_cmd="+SEARCH02;
 	  	sheetObj.SetWaitImageVisible(0);
	    var sXml = sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
     	sheetObj.SetWaitImageVisible(1);
     	var vsl_slan_cd = ComScgXml2Array(sXml, "vsl_slan_cd");
  	   	if(vsl_slan_cd == null) {
  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
  	   		formObj.slan_cd1.value = "";
  	   		formObj.slan_cd1.focus();
  	   		
  	   		//ComSetFocus(document.form.slan_cd1);
  	   	}
 	}
}

/**
 * Vessel Name retrieve
 */
function searchVVDCheck() {
	//vvdClassChange();
	
	var formObj  = document.form;
	var sheetObj = sheetObjects[0];
	var sParam   = Array();
	
	var vslCd    = document.getElementById("vsl_cd").value;
	var skdVoyNo = document.getElementById("skd_voy_no").value;
	var skdDirCd = document.getElementById("skd_dir_cd").value;
	
  	var paramLen = Number(vslCd.length) + Number(skdVoyNo.length) + Number(skdDirCd.length);
  	
//  	if(sParam.join("").length > 38) {
  	if(paramLen >= 9) {

  	  	sParam[0] = "vsl_cd="+vslCd;
  	  	sParam[1] = "skd_voy_no="+skdVoyNo;
  	  	sParam[2] = "skd_dir_cd="+skdDirCd;
  	  	sParam[3] = "f_cmd="+SEARCH05;
  	  	
  	    // 유효성체크
  		sheetObj.SetWaitImageVisible(0);
	    var sXml = sheetObj.GetSearchData("SCG_COM_EXTERNALGS.do", sParam.join("&"));
    	sheetObj.SetWaitImageVisible(1);
    	
    	var vsl_cd = ComScgXml2Array(sXml, "vsl_cd");
  	   	if(vsl_cd == null) {
  	   		ComShowCodeMessage("SCG50010", 'Data');	//'{?msg1} is invalid.'
  	   		formObj.vsl_cd.value = "";
  	   		formObj.skd_voy_no.value = "";
  	   		formObj.skd_dir_cd.value = "";
  	   		formObj.vsl_cd.focus();
  	   	} else {
	    	//from_eta_dt, to_eta_dt > 선택항목변환
	    	document.querySelector("#from_eta_dt").setAttribute('class', 'input');
	    	document.querySelector("#to_eta_dt").setAttribute('class', 'input');
	    	document.querySelector("#from_eta_dt").removeAttribute('required');
	    	document.querySelector("#to_eta_dt").removeAttribute('required');
  	   	}
  	}else{
  	  	var etaChkLen = Number(vslCd.length) + Number(skdVoyNo.length);
  	  	
  	  	if(paramLen == 8) {
  	  		//from_eta_dt, to_eta_dt > 선택항목변환
  	  		// VV입력시, ETA클리어, 선택항목으로 변환
  	    	document.querySelector("#from_eta_dt").setAttribute('class', 'input');
  	    	document.querySelector("#to_eta_dt").setAttribute('class', 'input');
  	    	document.querySelector("#from_eta_dt").removeAttribute('required');
  	    	document.querySelector("#to_eta_dt").removeAttribute('required');
  	    	//document.querySelector("#from_eta_dt").setAttribute('disabled', 'true');
  	    	//document.querySelector("#to_eta_dt").setAttribute('disabled', 'true');
  	    	document.querySelector("#from_eta_dt").value = '';
  	    	document.querySelector("#to_eta_dt").value = '';
  	  	}else{
  	  		//from_eta_dt, to_eta_dt > 필수항목변환
  	  	    // VV미입력시, ETA초기설정, 필수항목으로 변환
  	  		document.querySelector("#from_eta_dt").setAttribute('class', 'input1');
  	  		document.querySelector("#to_eta_dt").setAttribute('class', 'input1');
  	  		document.querySelector("#from_eta_dt").setAttribute('required', 'true');
  	  		document.querySelector("#to_eta_dt").setAttribute('required', 'true');
  	    	//document.querySelector("#from_eta_dt").removeAttribute('disabled');
  	    	//document.querySelector("#to_eta_dt").removeAttribute('disabled');
  	    	
  	    	document.querySelector("#from_eta_dt").value = ComGetDateAdd(null, "d", 0);
  	    	document.querySelector("#to_eta_dt").value = ComGetDateAdd(null, "d", 30);	//15->30 으로 조정
	  		//vvdClassChange();
  	  	}
  	}
  	
  	//@@차후 삭제!!!!!!!!!!!!!!!!!!!!!!
	//document.querySelector("#vsl_cd").removeAttribute('required');
	//document.querySelector("#skd_voy_no").removeAttribute('required');
	//document.querySelector("#skd_dir_cd").removeAttribute('required');
	//document.querySelector("#from_eta_dt").removeAttribute('required');
	//document.querySelector("#to_eta_dt").removeAttribute('required');
}

///**
// * Vessel 필수/선택 항목여부 체크
// */
//function vvdClassChange(){
//	var fromEtaDt = document.getElementById("from_eta_dt").value;
//	var toEtaDt = document.getElementById("to_eta_dt").value;
//
//	if(sheet_dateDiff(fromEtaDt, toEtaDt, "D") <= 123){ //2주이내인경우 VVD정보 선택 -> 4개월로 조정
//		//vsl_cd, skd_voy_no, skd_dir_cd > 선택항목변환
//		document.querySelector("#vsl_cd").setAttribute('class', 'input');
//		document.querySelector("#skd_voy_no").setAttribute('class', 'input');
//		document.querySelector("#skd_dir_cd").setAttribute('class', 'input');
//		document.querySelector("#vsl_cd").removeAttribute('required');
//		document.querySelector("#skd_voy_no").removeAttribute('required');
//		document.querySelector("#skd_dir_cd").removeAttribute('required');
//	}else{
//		//vsl_cd, skd_voy_no, skd_dir_cd > 필수항목변환
//		document.querySelector("#vsl_cd").setAttribute('class', 'input1');
//		document.querySelector("#skd_voy_no").setAttribute('class', 'input1');
//		document.querySelector("#skd_dir_cd").setAttribute('class', 'input1');
//		document.querySelector("#vsl_cd").setAttribute('required', 'true');
//		document.querySelector("#skd_voy_no").setAttribute('required', 'true');
//		document.querySelector("#skd_dir_cd").setAttribute('required', 'true');
//	}
//}

/**
 * When clicking popup in retriving condition
 */
function onPopupClick(srcName, srcType){
	var sUrl = "";
	var formObj = document.form;
	
	if (srcType == "Lane") {
		ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 470, 470, "returnSvcLaneCdHelp", "0,0", true);
	} else if (srcType == "VVD") {
		var vsl_cd = ComGetObjValue(formObj.vsl_cd);
		
		if(vsl_cd == ""){
			sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
			ComOpenPopupWithTarget(sUrl, 480, 480, "vsl_cd:vsl_cd", "0,0", true);
		}else{
			sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd="+vsl_cd;
			//ComOpenPopupWithTarget(sUrl, 480, 480, "test", "0,0", true);
			ComOpenPopup(sUrl, 470, 470, "VVDCheck", "0,0", true);
		}
 	}
}

function VVDCheck(rtnObjs){
	var formObj=document.form;
	var rtnDatas=rtnObjs;
	if(rtnDatas.length > 0){
		formObj.skd_voy_no.value=rtnDatas[0][2];
		formObj.skd_dir_cd.value=rtnDatas[0][3];
		searchVVDCheck();
	}
}

function returnSvcLaneCdHelp(rtnObjs){
	var formObj=document.form;
	var rtnDatas=rtnObjs;
	if(rtnDatas.length > 0){
		formObj.slan_cd1.value=rtnDatas[0][1]; //vessel code
	}
}

// Combo related process handling
function doActionIBCombo(comboObj, comboNo) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
    sheetObj.ShowDebugMsg(false);
    switch(comboNo) {
  		case 1:    
//  			formObj.f_cmd.value=SEARCH02;
//  			sheetObj.SetWaitImageVisible(0);
//     		var sXml=sheetObj.GetSearchData("SCG_COM_INTERNALGS.do", FormQueryString(formObj));
//    		sheetObj.SetWaitImageVisible(1);
//    		ComXml2ComboItem(sXml, imdg_clss_cd, "imdg_clss_cd", "imdg_clss_cd|imdg_clss_cd_desc");
//        	//SetTitle("Class|Definition");
//    		imdg_clss_cd.SetDropHeight(300);
//        	imdg_clss_cd.SetColWidth(0, "50");
//        	imdg_clss_cd.SetColWidth(1, "700");
//    		ComSetFocus(imdg_clss_cd);
  			break;  
    }
}

/**
 * 비율 콤마제거
 * @param obj
 */
function subNumberComma(obj){
	var rsltObj = '';
	
	if(obj == null || $.trim(obj).length == 0){
		return '';
	}else{
		rsltObj = obj.replace(/,/g, '');
	}
	
	return rsltObj;
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
		 sheetObjects[0].ReDraw=false;
         sheetObjects[0].SetCellText(sheetObjects[0].LastRow(), "slan_cd", "GRAND Total");
         sheetObjects[0].SetCellText(sheetObjects[0].LastRow(), "vsl_cd", "GRAND Total");
         sheetObjects[0].SetCellText(sheetObjects[0].LastRow(), "skd_voy_no", "GRAND Total");
         sheetObjects[0].SetCellText(sheetObjects[0].LastRow(), "skd_dir_cd", "GRAND Total");
         sheetObjects[0].SetCellText(sheetObjects[0].LastRow(), "lmt_wgt_tp_cd", "GRAND Total");
         
         sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow(),1,1,5);
//         sheetObjects[0].SetMergeCell(sheetObjects[0].LastRow(), 0, 1, 5); // Grand Totl 
         sheetObjects[0].ReDraw=true;
     }
	
//    var colAry = new Array();
//	colAry = makeBoxCol(sheetObj).split("|");
	for(var i=2; i <= sheetObj.RowCount()+1; i++){
		
//		var arr_lmt_rto  = subNumberComma(sheetObj.GetCellValue(i, "arr_lmt_rto"));
//		var dchg_lmt_rto = subNumberComma(sheetObj.GetCellValue(i, "dchg_lmt_rto"));
//		var lod_lmt_rto  = subNumberComma(sheetObj.GetCellValue(i, "lod_lmt_rto"));
//		var dep_lmt_rto  = subNumberComma(sheetObj.GetCellValue(i, "dep_lmt_rto")); 
		
		var arr_lmt_rto  = sheetObj.GetCellValue(i, "arr_lmt_rto");
		var dchg_lmt_rto = sheetObj.GetCellValue(i, "dchg_lmt_rto");
		var lod_lmt_rto  = sheetObj.GetCellValue(i, "lod_lmt_rto");
		var dep_lmt_rto  = sheetObj.GetCellValue(i, "dep_lmt_rto"); 
		
//		if($.trim(arr_lmt_rto) == ".00"){
//			sheetObj.SetCellValue(i, "arr_lmt_rto", 0);
//		}
//		if($.trim(dchg_lmt_rto) == ".00"){
//			sheetObj.SetCellValue(i, "dchg_lmt_rto", 0);
//		}
//		if($.trim(lod_lmt_rto) == ".00"){
//			sheetObj.SetCellValue(i, "lod_lmt_rto", 0);
//		}
//		if($.trim(dep_lmt_rto) == ".00"){
//			sheetObj.SetCellValue(i, "dep_lmt_rto", 0);
//		}
		
		var arr_dep_prohi_flg = sheetObj.GetCellValue(i, "arr_dep_prohi_flg");
		var ldis_aply_tgt_flg = sheetObj.GetCellValue(i, "ldis_aply_tgt_flg");
		
		var arr_cgo_wgt = sheetObj.GetCellValue(i, "arr_cgo_wgt");
		var dchg_cgo_wgt= sheetObj.GetCellValue(i, "dchg_cgo_wgt");
		var lod_cgo_wgt = sheetObj.GetCellValue(i, "lod_cgo_wgt");
		var dep_cgo_wgt = sheetObj.GetCellValue(i, "dep_cgo_wgt");
		
		var arr_max_lmt = sheetObj.GetCellValue(i, "arr_max_lmt");
		var dchg_max_lmt= sheetObj.GetCellValue(i, "dchg_max_lmt");
		var lod_max_lmt = sheetObj.GetCellValue(i, "lod_max_lmt");
		var dep_max_lmt = sheetObj.GetCellValue(i, "dep_max_lmt");
		
		var arrBool0 = false;
		var arrBool1 = false;
		var arrBool2 = false;
		var disBool  = false;
		var disBool0 = false;
		var disBool1 = false;
		var disBool2 = false;
		var lodBool  = false;
		var lodBool0 = false;
		var lodBool1 = false;
		var lodBool2 = false;
		var depBool0 = false;
		var depBool1 = false;
		var depBool2 = false;
		
		if(arr_dep_prohi_flg == "Y" & arr_cgo_wgt > 0) {
			arrBool2 = true;
		} else {
			if(arr_lmt_rto > 100){
				arrBool2 = true;
			}else if(75 <= arr_lmt_rto  && 100 >= arr_lmt_rto){
				if(arr_max_lmt < arr_cgo_wgt) {
					arrBool2 = true;
				} else {
					arrBool1 = true;
				}
			}else {
				arrBool0 = true;
			}
		}
		if(ldis_aply_tgt_flg == "N") {
			disBool = true;
		} else {
			if(dchg_max_lmt == 0 && dchg_cgo_wgt > 0) {
				disBool2 = true;
			} else {
				if(dchg_lmt_rto > 100){
					disBool2 = true;
				}else if(75 <= dchg_lmt_rto  && 100 >= dchg_lmt_rto){
					if(dchg_max_lmt < dchg_cgo_wgt) {
						disBool2 = true;
					} else {
						disBool1 = true;
					}
				}else{
					disBool0 = true;
				}
			}
		}
		if(ldis_aply_tgt_flg == "N") {
			lodBool = true;
		} else {
			if(lod_max_lmt == 0 && lod_cgo_wgt > 0) {
				disBool2 = true;
			} else {
				if(lod_lmt_rto > 100){
					lodBool2 = true;
				}else if(75 <= lod_lmt_rto  && 100 >= lod_lmt_rto){
					if(lod_max_lmt < lod_cgo_wgt) {
						lodBool2 = true;
					} else {
						lodBool1 = true;
					}
				}else{
					lodBool0 = true;
				}
			}
		}
		if(arr_dep_prohi_flg == "Y" & dep_cgo_wgt > 0) {
			depBool2 = true;
		} else {
			if(dep_lmt_rto > 100){
				depBool2 = true;
			}else if(75 <= dep_lmt_rto  && 100 >= dep_lmt_rto){
				if(dep_max_lmt < dep_cgo_wgt) {
					depBool2 = true;
				} else {
					depBool1 = true;
				}
			}else{
				depBool0 = true;
			}
		}
//		if(arr_dep_prohi_flg == "Y"){// && arr_cgo_wgt > 0
//			arrBool2 = true;
//		}
		
//		if(ldis_prohi_flg == "N"){// && dchg_cgo_wgt > 0
//			disBool2 = true;
//		}
//		
//		if(ldis_prohi_flg == "N"){// && lod_cgo_wgt > 0
//			lodBool2 = true;
//		}
		
//		if(arr_dep_prohi_flg == "Y"){// && dep_cgo_wgt > 0
//			depBool2 = true;
//		}
		
		setData();
		if(arrBool0){
			fn_color(sheetObj, i, 0, 0, 1, 2, 0);
		}
		if(arrBool1){
			fn_color(sheetObj, i, 0, 0, 1, 2, 1);
		}
		if(arrBool2){
			fn_color(sheetObj, i, 0, 0, 1, 2, 2);
		}
		if(disBool){
			fn_color(sheetObj, i, 1, 3, 4, 5, -1);
		}
		if(disBool0){
			fn_color(sheetObj, i, 1, 3, 4, 5, 0);
		}
		if(disBool1){
			fn_color(sheetObj, i, 1, 3, 4, 5, 1);
		}
		if(disBool2){
			fn_color(sheetObj, i, 1, 3, 4, 5, 2);
		}
		if(lodBool){
			fn_color(sheetObj, i, 2, 6, 7, 8, -1);
		}
		if(lodBool0){
			fn_color(sheetObj, i, 2, 6, 7, 8, 0);
		}
		if(lodBool1){
			fn_color(sheetObj, i, 2, 6, 7, 8, 1);
		}
		if(lodBool2){
			fn_color(sheetObj, i, 2, 6, 7, 8, 2);
		}
		if(depBool0){
			fn_color(sheetObj, i, 3, 9, 10, 11, 0);
		}
		if(depBool1){
			fn_color(sheetObj, i, 3, 9, 10, 11, 1);
		}
		if(depBool2){
			fn_color(sheetObj, i, 3, 9, 10, 11, 2);
		}
		
		for(var j=0; j < gColAry.length; j++){
			var col = gColAry[j];
			if(sheetObj.GetCellFontColor(i, col) == ""){
				sheetObj.SetCellValue(i, col, ""); 
			}
		}
		
//		for(var j=0; j<colAry.length; j++){
//			var colnum = colAry[j];
//			if(colnum > 12){
//				Weight 체크
//				if(sheetObjects[0].GetCellValue(i, "cgo_lmt_rto") >= 100){
//					sheetObjects[0].SetCellBackColor(i, colnum, "#F15F5F");
//					sheetObjects[0].SetRowBackColor(i, "#F15F5F");	// Red
//				}else if (75 <= sheetObjects[0].GetCellValue(i, "cgo_lmt_rto") && 100 > sheetObjects[0].GetCellValue(i, "cgo_lmt_rto")  ){
//					sheetObjects[0].SetCellBackColor(i, colnum, "#FFBB00");
//					sheetObjects[0].SetRowBackColor(i, "#FFBB00"); // Amber
//				}
//			}
//		}
		//FP 체크
//		var fpChk = sheetObjects[0].GetCellValue( i, "fp_chk" );
//		if(fpChk == "RED" || fpChk == "YELLOW"){
//			sheetObjects[0].SetRowBackColor(i, fpChk);
//		}
	}
}

/** 
 * sheet2_OnSaveEnd  <br>
 * @param sheetObj, Code, ErrMsg
 * @return 
 * @author
 * @version
 */  
function sheet2_OnSearchEnd(sheetObj, Code, ErrMsg){
	
	 if (sheetObj.RowCount() > 0) {
		 sheetObj.ReDraw=false;
         sheetObj.SetCellText(sheetObj.LastRow(), "slan_cd", "GRAND Total");
         sheetObj.SetCellText(sheetObj.LastRow(), "vsl_cd", "GRAND Total");
         sheetObj.SetCellText(sheetObj.LastRow(), "skd_voy_no", "GRAND Total");
         sheetObj.SetCellText(sheetObj.LastRow(), "skd_dir_cd", "GRAND Total");
         sheetObj.SetCellText(sheetObj.LastRow(), "lmt_wgt_tp_cd", "GRAND Total");
         
         sheetObj.SetMergeCell(sheetObj.LastRow(),1,1,5);
         sheetObj.ReDraw=true;
     }
	
	for(var i=2; i <= sheetObj.RowCount()+1; i++){
		var dchg_lmt_rto = sheetObj.GetCellValue(i, "dchg_lmt_rto");
		var lod_lmt_rto  = sheetObj.GetCellValue(i, "lod_lmt_rto");
		
		var ldis_aply_tgt_flg = sheetObj.GetCellValue(i, "ldis_aply_tgt_flg");
		
		var dchg_cgo_wgt= sheetObj.GetCellValue(i, "dchg_cgo_wgt");
		var lod_cgo_wgt = sheetObj.GetCellValue(i, "lod_cgo_wgt");
		
		var dchg_max_lmt= sheetObj.GetCellValue(i, "dchg_max_lmt");
		var lod_max_lmt = sheetObj.GetCellValue(i, "lod_max_lmt");
		
		var disBool  = false;
		var disBool0 = false;
		var disBool1 = false;
		var disBool2 = false;
		var lodBool  = false;
		var lodBool0 = false;
		var lodBool1 = false;
		var lodBool2 = false;
		
		
		if(ldis_aply_tgt_flg == "N") {
			disBool = true;
		} else {
			if(dchg_max_lmt == 0 && dchg_cgo_wgt > 0) {
				disBool2 = true;
			} else {
				if(dchg_lmt_rto > 100){
					disBool2 = true;
				}else if(75 <= dchg_lmt_rto  && 100 >= dchg_lmt_rto){
					if(dchg_max_lmt < dchg_cgo_wgt) {
						disBool2 = true;
					} else {
						disBool1 = true;
					}
				}else{
					disBool0 = true;
				}
			}
		}
		if(ldis_aply_tgt_flg == "N") {
			lodBool = true;
		} else {
			if(lod_max_lmt == 0 && lod_cgo_wgt > 0) {
				disBool2 = true;
			} else {
				if(lod_lmt_rto > 100){
					lodBool2 = true;
				}else if(75 <= lod_lmt_rto  && 100 >= lod_lmt_rto){
					if(lod_max_lmt < lod_cgo_wgt) {
						lodBool2 = true;
					} else {
						lodBool1 = true;
					}
				}else{
					lodBool0 = true;
				}
			}
		}
		
		setData();
		
		if(disBool){
			fn_color(sheetObj, i, 1, 3, 4, 5, -1);
		}
		if(disBool0){
			fn_color(sheetObj, i, 1, 3, 4, 5, 0);
		}
		if(disBool1){
			fn_color(sheetObj, i, 1, 3, 4, 5, 1);
		}
		if(disBool2){
			fn_color(sheetObj, i, 1, 3, 4, 5, 2);
		}
		if(lodBool){
			fn_color(sheetObj, i, 2, 6, 7, 8, -1);
		}
		if(lodBool0){
			fn_color(sheetObj, i, 2, 6, 7, 8, 0);
		}
		if(lodBool1){
			fn_color(sheetObj, i, 2, 6, 7, 8, 1);
		}
		if(lodBool2){
			fn_color(sheetObj, i, 2, 6, 7, 8, 2);
		}
		
		for(var j=0; j < gColAry.length; j++){
			var col = gColAry[j];
			if(sheetObj.GetCellFontColor(i, col) == ""){
				sheetObj.SetCellValue(i, col, ""); 
			}
		}
	}
}
    /*
     * 공통변수설정
     * */
    function setData() {
		gImgAry[0] = "arr_img";		gImgAry[1] = "dis_img";		gImgAry[2] = "lod_img";		gImgAry[3] = "dep_img";
		gColAry[0] = "arr_cgo_wgt";	gColAry[1] = "arr_lmt_rto";	gColAry[2] = "arr_max_lmt";
		gColAry[3] = "dchg_cgo_wgt";gColAry[4] = "dchg_lmt_rto";gColAry[5] = "dchg_max_lmt";
		gColAry[6] = "lod_cgo_wgt";	gColAry[7] = "lod_lmt_rto";	gColAry[8] = "lod_max_lmt";
		gColAry[9] = "dep_cgo_wgt";	gColAry[10]= "dep_lmt_rto";	gColAry[11]= "dep_max_lmt";
		//LimeGreen					//Goldenrod					//Red
		gFontAry[0] = "#32CD32";	gFontAry[1] = "#DAA520";	gFontAry[2] = "#FF0000";
    }
    
	function fn_color(sheetObj, row, image, column1, column2, column3, imgNfontColor){
		if(imgNfontColor >= 0) {
			//image setting
			sheetObj.SetCellImage(row, gImgAry[image], imgNfontColor);
			
			//font setting
			sheetObj.SetCellFontColor(row, gColAry[column1], gFontAry[imgNfontColor]);
			sheetObj.SetCellFontColor(row, gColAry[column2], gFontAry[imgNfontColor]);
			sheetObj.SetCellFontColor(row, gColAry[column3], gFontAry[imgNfontColor]);
			
			//image text setting
			if(imgNfontColor == "0"){ //green
				sheetObj.SetCellValue(row, gImgAry[image]+"_txt", "green");
			}else if(imgNfontColor == "1"){ //yellow
				sheetObj.SetCellValue(row, gImgAry[image]+"_txt", "yellow");
			}else if(imgNfontColor == "2"){ //red
				sheetObj.SetCellValue(row, gImgAry[image]+"_txt", "red");
			}
			
			//sheetObj.SetCellFontColor(row, imgAry[image]+"_txt", fontAry[imgNfontColor]);
			sheetObj.SetCellBackColor(row, gImgAry[image]+"_txt", gFontAry[imgNfontColor]);
		}
	}
	
	function plmt_pord_cd_OnChange(){
		var formObj=document.form;
		var sheet;
		if(ComGetObjValue(formObj.plmt_port_cd) == 'CNSHA') {
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
	
//    function makeBoxCol(sobj){
//	    var lc = sobj.LastCol();
//	    var rtnStr = "";
//	    for(var i=0;i<=lc;i++){
////	    	if(sobj.GetCellProperty(0,i,"Type") == "CheckBox"){
//	    		rtnStr += "|"+ i;
////	    	}
//	    }
//	    return rtnStr.substring(1);
//	}	
//	
//	var hgt = 400;
//	if(sheetObj.RowCount() > 10){
//		var hgt = 60+sheetObj.RowCount()*30;
//	}
//	sheetObj.SetSheetHeight(hgt);
//
//}
