/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : EES_DMT_5001.js
 *@FileTitle  : A/R Interface Status Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/16
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_5001 :  business script for EES_DMT_5001.
     */
	// Common Global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var COMMON_TARIFF_CD="common_tariff_cd";
	var USER_TARIFF_TYPE="user_tariff_type"; 
	var ROWMARK="|";
	var FIELDMARK="=";
	var PERIOD_GAP=15;
	var USR_TRF_TP;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
         /***** case in Sheet count are more two by Tab, defining adding sheet *****/
         var sheetObject1=sheetObjects[0];
		 var sheetObject2=sheetObjects[1];
         /*******************************************************/
         var formObj=document.form;
         if (tabObjects[0].GetSelectedIndex() == 0)  {
     		sheetObj=sheetObjects[0];
         } else if (tabObjects[0].GetSelectedIndex() == 1)  {
         	sheetObj=sheetObjects[1];
         }
    	try {
    		var srcName=ComGetEvent("name");
    		var srcObj=ComGetEvent();//window.event.srcElement;
            switch(srcName) {
	            case "btns_calendar": //Calendar button
		            var cal=new ComCalendarFromTo();
		            if(formObj.tab_order.value == 0){
		            	cal.select(formObj.fm_dt,  formObj.to_dt,  'yyyy-MM-dd');
		            } else {
		            	cal.select(formObj.fm_dt_t2,  formObj.to_dt_t2,  'yyyy-MM-dd');
		            }
		            break;
	 			case "btn_downexcel":
	 				if(formObj.tab_order.value == 0){
//	 					sheetObject1.SpeedDown2Excel();
	 					if(sheetObject1.RowCount() < 1){//no data
	 						ComShowCodeMessage("COM132501");
	 					}else{
	 						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
	 					}
	 					
		            } else {
//		            	sheetObject2.SpeedDown2Excel();
		            	if(sheetObject2.RowCount() < 1){//no data
	 						ComShowCodeMessage("COM132501");
	 					}else{
	 						sheetObject2.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject2), SheetDesign:1,Merge:1 });
	 					}		            	
		            }
	 				break;
	 			case "btn_retrieve":
	 				var tabOrder=formObj.tab_order.value;
					if(tabOrder == 0){
						doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					} else if(tabOrder == 1 ){
						doActionIBSheet(sheetObjects[1],document.form,IBSEARCH);
					} 	
	 				break;
	 			case "btn_new":
	 				initSearchControls();
					break; 
	 			case "btn_detail":
	 				if(ComIsBtnEnable(srcName)) {
						openPopupWindow(sheetObject1, formObj, srcName);
					}
	 				break;
	 			case "btn_print":
	 				alert(srcName);
	 				break;
            } // end switch
    	}catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
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
  	//comboObjects array generated in the registration page to IB Combo Object
  	function setComboObject(combo_obj){
  		comboObjects[comboCnt++]=combo_obj;
  	}	     
	/**
     * IBTab Object is defined as an array.
     * adding process for list in case of needing batch processing with other items
     * defining list on the top of source
     */
    function setTabObject(tab_obj){
        tabObjects[tabCnt++]=tab_obj;
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
		// IBMultiCombo initializing 
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}
		for(var k=0;k<tabObjects.length;k++){
            initTab(tabObjects[k],k+1);
            tabObjects[k].SetSelectedIndex(0);
        }
		//initializing html control event
		initControl();
		var formObj=document.form
		sheetObjects[0].SetWaitImageVisible(0);
//      initSearchControls();
      	doInit()
      	sheetObjects[0].SetWaitImageVisible(1);
      	
    }
 	function initControl() {
        axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      	, document.form ); //- out of focus
        axon_event.addListenerFormat( 'focus'    , 'obj_focus'     	, document.form ); // Get focus
		axon_event.addListenerFormat('keypress'	 ,'obj_keypress'	, document.form); //- on press keyboard
		axon_event.addListener(		 'keydown'	 ,	  'ComKeyEnter'	, 'form');  
		axon_event.addListenerForm  ( 'change'   , 'obj_change' 	, document.form );
	}
	//business javascript OnKeyPress event handling
	function obj_keypress() {
    	 switch(ComGetEvent("dataformat")){
         	case "engup":
		    	// upper case + numbers 
         		ComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "engup2":
		    	//  upper case + numbers + exceptional letters
         		DmtComKeyOnlyAlphabet('uppernum', ',');
		        break;
         	case "int":
    	        //only numbers
    	        ComKeyOnlyNumber(ComGetEvent());
    	        break;
         	default:
	         	// only numbers(integer, date, time)
	            ComKeyOnlyNumber(ComGetEvent());
    	 }
	}
	function obj_blur(){
         //check inputing Validation + Inserting separator 
         var obj=ComGetEvent();
         if ( ( obj.name == 'fm_dt' || obj.name == 'to_dt' || obj.name == 'fm_dt_t2' || obj.name == 'to_dt_t2' ) 
        		 && document.form.fm_dt.value != "" && document.form.to_dt.value != ""  && document.form.fm_dt_t2.value != "" && document.form.to_dt_t2.value != "") {
             ComChkObjValid(obj);
         } else if(obj.name == 'cust_cd') {
        	 doActionText(sheetObjects[0], document.form, obj, SEARCH20);
         } else if(obj.name == 'act_cust_cd') {
        	 doActionTextT2(sheetObjects[0], document.form, obj, SEARCH20);
         }
	}
	function obj_focus() {
		ComClearSeparator(ComGetEvent());
		ComSetFocus(ComGetEvent());
	}
    function obj_change(){
        obj=ComGetEvent();
        var formObj=document.form;
        if(ComGetEvent("name") == "r_office"){
        	// a/r office
            if ( obj.value == "1") {
    			//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
    			formObj.chk_sub_ofc.checked=false;
            } 
            // issue
            else if ( obj.value == "2") {
    			//tab1 issue office 	
    			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
    			formObj.chk_sub_ofc.checked=false;
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
	    switch(sheetObj.id) {
	        case "t1sheet1":      // sheet1 init
				with(sheetObj){
					var HeadTitle="|Sel.|Seq.|Office|SUBTOT|I/F DT|Tariff|INV No.|BKG No.|B/L No.|I/F No.|VVD CD|Port|I/F OFC|I/F Name|ISS DT|ISS OFC|ISS Name|Cur.|Billing AMT|Tax AMT|Payable AMT|Payer Flg|Payer CD|Payer Name|Shipper|Shipper|Consignee|Consignee|Notify|Notify";
					var headCount=ComCountHeadTitle(HeadTitle);
					SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
					 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
					 {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"subtot",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_trf_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"dmdt_inv_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ar_if_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:1,   SaveName:"ar_if_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cre_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cre_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"inv_curr_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",  	Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"inv_chg_amt",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",  	Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"tax_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"AutoSum",  	Hidden:0,  Width:150,  Align:"Right",   ColMerge:1,   SaveName:"inv_amt",       KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"payer_flg",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"shipper_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"consignee_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"consignee_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"notify_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"notify_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(460);
					SetEditable(1);
					
					ShowSubSum([
					            {StdCol:"ofc_cd",   SumCols:"inv_chg_amt|tax_amt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:0, OtherColText:"chk=;ofc_cd=%s;seq=S.TTL"},
					            {StdCol:"ar_if_dt", SumCols:"inv_chg_amt|tax_amt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:0, OtherColText:"chk=;ofc_cd=%s;ar_if_dt=%s;seq=S.TTL"}
					           ]);
					//ShowSubSum([{StdCol:"ar_if_dt", SumCols:"inv_chg_amt|tax_amt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ofc_cd=%s;ar_if_dt=%s;seq=S.TTL"}]);
					SetSumValue(0, "seq","TTL");					
				}
 		break;
 				
 		case "t2sheet1":      // sheet2 init
			with(sheetObj){
				var HeadTitle="|Seq.|A/R OFC|I/F DT|CHRG|Bound|Type|B/L No.|I/F No.|VVD CD|Port|INV No.|ISS DT|Cur.|AMT|payer_flg|A/R Actual Payer|A/R Actual Payer";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, FrozenCol:8, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				 {Type:"Seq",       Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ar_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"if_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"chg_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"io_bnd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"type",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"if_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"inv_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"iss_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"AutoSum",  	Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"chg_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:1,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"payer_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"payer_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:1,   SaveName:"payer_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
				   
				InitColumns(cols);
				SetSheetHeight(460);
				SetEditable(1);
				
				ShowSubSum([
				            {StdCol:"ar_ofc_cd", SumCols:"chg_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ar_ofc_cd=%s;seq=S.TTL"},
				            {StdCol:"if_dt",     SumCols:"chg_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ar_ofc_cd=%s;if_dt=%s;seq=S.TTL"}
				          ]);
				//SetSumText(0, "seq","TTL");
				SetSumValue(0, "seq","TTL");	
			}
 		break;
	    }
	}
	 /**
  	 * Initializing Combo 
  	 * param : comboObj , comboNo
  	 *  adding case as numbers of counting Combos
  	 */ 
	function initCombo(comboObj, comboNo) {
  	    var formObj=document.form
  	    switch(comboObj.options.id) {
  	    	case "office": 
	        	with (comboObj) { 
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "65");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2, 2);
		    	}  	        	  
				break;   	    
  	    	case "tariff_type": 
  	        	with (comboObj) { 
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "50");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2, 2);
  		    	}
  	        	break;
  	    	case "office_t2": 
	        	with (comboObj) { 
					SetMultiSelect(1);
					SetUseAutoComplete(1);
					SetColAlign(0, "left");
					SetColAlign(1, "left");
					SetColWidth(0, "60");
					SetColWidth(1, "300");
					SetDropHeight(160);
					SetColBackColor(0,"#CCFFFD");
  					SetColBackColor(1,"#CCFFFD");
  					ValidChar(2, 2);
		    	}  	        	  
				break;     	        	
  	     	}
  	  comboObj.SetMultiSelect(1);
	}		 
  	/**
 	 * Combo 
 	 */	
	function doActionIBCombo(sheetObj,formObj,sAction,sComboObj) {
		sheetObj.ShowDebugMsg(false);
 		sheetObj.SetWaitImageVisible(0);
 		switch(sAction) {
	 		//tab1: A/R Office comboList	
	 		case IBSEARCH_ASYNC06:    
				formObj.f_cmd.value=COMMAND10;
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    sComboObj.RemoveAll();
	    	    if (sXml != undefined && sXml != '') {
		    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
		    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
		    	    var comboCodeArr=ofc_cds.split("|");			    	    
		    	    var comboTextArr=ofc_nms.split("|");
		    	    sComboObj.InsertItem(0, "All|All", "All");
			  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
			  		var startIdx=1;
			  		if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd.toString(), usr_ofc_cd.toString());
			  			startIdx=2;
			  		}
			  		for (var i=0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i].toString() + "|" + comboTextArr[i].toString(), comboCodeArr[i].toString());		
		         	}
			  		sComboObj.SetSelectCode(usr_ofc_cd);
			  		/*
			  		sComboObj.SetSelectCode(usr_ofc_cd);
			  		if(sComboObj.GetSelectCode()!= usr_ofc_cd) {
			  			sComboObj.InsertItem(1, usr_ofc_cd, usr_ofc_cd);
			  			sComboObj.SetSelectCode(usr_ofc_cd);
			  		}*/
	    	    }
	    	    break;
     		//tab1:Office comboList	
     		case IBSEARCH_ASYNC01:    
 				formObj.f_cmd.value=SEARCHLIST02;
 				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
 		    	    var comboCodeArr=ofc_cds.split("|");			    	    
 		    	    var comboTextArr=ofc_nms.split("|");
		    	    sComboObj.InsertItem(0, "All|All", "All");
			  		var usr_ofc_cd=formObj.usr_ofc_cd.value;
			  		var startIdx=1;
			  		if(ofc_cds.indexOf(usr_ofc_cd) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd.toString(), usr_ofc_cd.toString());
			  			startIdx=2;
			  		}
			  		for (var i=0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i].toString() + "|" + comboTextArr[i].toString(), comboCodeArr[i].toString());		
		         	}
			  		sComboObj.SetSelectCode(usr_ofc_cd);
 	    	    }
 	    	    break;
 	    	//tab1:Tariff type comboList
     		case IBSEARCH_ASYNC02:     
 				formObj.f_cmd.value=SEARCHLIST;
 				var xmlStr=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 				sComboObj.RemoveAll();
 				var data=ComGetEtcData(xmlStr, COMMON_TARIFF_CD);
 				if (data != undefined && data != '') {
 					var comboItems=data.split(ROWMARK);
 					addComboItem(sComboObj,comboItems);
 					comboItem=comboItems[0].split(FIELDMARK);
 				}	
 				var data2=ComGetEtcData(xmlStr, USER_TARIFF_TYPE);
 				if(data2 == '') data2='CTIC,DMIF';
 				sComboObj.SetSelectCode(data2,false);
 				USR_TRF_TP=data2;
 				formObj.usr_trf_tp.value=data2;
 				break;
 			//tab1:From Yard Code comboList
     		case IBSEARCH_ASYNC03:  
				//3. Sub Office comboList
				var comboObj=comboObjects[0]; //office Combo Object 
				formObj.f_cmd.value=COMMAND01;
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    if (sXml != undefined && sXml != '') {
	    	    	var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
	    	    	if (subOfcCds != undefined && subOfcCds != '') {
	    	    		var arrOfcCd=subOfcCds.split(',');
	    	    		var str='';
	    	    		for(var i=0; i<arrOfcCd.length; i++) {
	    	    			var idx=comboObj.FindItem(arrOfcCd[i], 0);
	    	    			if(idx != -1)
	    	    				str=str + ',' + arrOfcCd[i];
	    	    		}
	    	    		str=str.substring(1);
	    	    		var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
	    	    		if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
	    	    			str=usrOfcCd + ',' + str;
	    	    		}
	    	    		comboObj.SetSelectCode(str, false);	//이벤트가 발생되지 않도록 수정함. 2014.08.19
	    	    	 }
	    	    }
     			break;
         	//tab2:Office comboList	
     		case IBSEARCH_ASYNC04:    
 				formObj.f_cmd.value=COMMAND10;
 				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
 	    	    sComboObj.RemoveAll();
 	    	    if (sXml != undefined && sXml != '') {
 		    	    var ofc_cds=ComGetEtcData(sXml, "OFC_CD");
 		    	    var ofc_nms=ComGetEtcData(sXml, "OFC_NM");
 		    	    var comboCodeArr=ofc_cds.split("|");			    	    
 		    	    var comboTextArr=ofc_nms.split("|");
		    	    sComboObj.InsertItem(0, "All|All", "All");
			  		var usr_ofc_cd_t2=formObj.usr_ofc_cd_t2.value;
			  		var startIdx=1;
			  		if(ofc_cds.indexOf(usr_ofc_cd_t2) == -1) {
			  			sComboObj.InsertItem(1, usr_ofc_cd_t2, usr_ofc_cd_t2);
			  			startIdx=2;
			  		}
			  		for (var i=0 ; i < comboTextArr.length ; i++) {
		    	    	sComboObj.InsertItem(startIdx + i, comboCodeArr[i].toString() + "|" + comboTextArr[i].toString(), comboCodeArr[i].toString());		
		         	}
			  		sComboObj.SetSelectCode(usr_ofc_cd_t2);
 	    	    }
 	    	    break;     	
 	 		//tab2:From Yard Code comboList
     		case IBSEARCH_ASYNC05:  
				//3. Sub Office comboList
				var comboObj=comboObjects[2]; //office_t2 Combo Object
				formObj.f_cmd.value=COMMAND01;
				var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
	    	    if (sXml != undefined && sXml != '') {
	    	    	var subOfcCds=ComGetEtcData(sXml, "OFC_CD");
	    	    	if (subOfcCds != undefined && subOfcCds != '') {
	    	    		var arrOfcCd=subOfcCds.split(',');
	    	    		var str='';
	    	    		for(var i=0; i<arrOfcCd.length; i++) {
	    	    			var idx=comboObj.FindItem(arrOfcCd[i], 0);
	    	    			if(idx != -1)
	    	    				str=str + ',' + arrOfcCd[i];
	    	    		}
	    	    		str=str.substring(1);
	    	    		var usrOfcCd=ComGetObjValue(formObj.usr_ofc_cd);
	    	    		if(comboObj.GetSelectCode().indexOf(usrOfcCd) != -1 && str.indexOf(usrOfcCd)==-1) {
	    	    			str=usrOfcCd + ',' + str;
	    	    		}
	    	    		comboObj.SetSelectCode(str, false);	//이벤트가 발생되지 않도록 수정함. 2014.08.19
	    	    	 }
	    	    }
     			break; 	    	    
         }
 		sheetObj.SetWaitImageVisible(1);
     }	
 	/*
 	 * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
 	 */
 	function doInclSubOfc() {
 		var formObj=document.form;
 		if (formObj.chk_sub_ofc.checked) { 
 			if (ComIsEmpty(comboObjects[0].GetSelectCode())) {
 				ComShowCodeMessage('COM12113', "DEM/DET Office");
 				formObj.chk_sub_ofc.checked=false;
 				return;
 			}
 			formObj.ofc_cd_t1.value=ComGetObjValue(comboObjects[0]);
 			formObj.ofc_cd.value=formObj.ofc_cd_t1.value;
 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC03);
 		} else {
 			ComSetObjValue(comboObjects[0], formObj.ofc_cd_t1.value);
 		}
 	}	
 	/*
 	 * Multi-select the DEM / DET Office of the Sub-mucin (Sub Office) lookup
 	 */
 	function doInclSubOfcT2() {
 		var formObj=document.form;
 		if (formObj.chk_sub_ofc_t2.checked) {
 			if (ComIsEmpty(comboObjects[2].GetSelectCode())) {
 				ComShowCodeMessage('COM12113', "DEM/DET Office");
 				formObj.chk_sub_ofc_t2.checked=false;
 				return;
 			}
 			formObj.ofc_cd_t2.value=ComGetObjValue(comboObjects[2]);
 			formObj.ofc_cd.value=formObj.ofc_cd_t2.value;

 			doActionIBCombo(sheetObjects[0], formObj, IBSEARCH_ASYNC05);
 		} else {
 			ComSetObjValue(comboObjects[2], formObj.ofc_cd_t2.value);
 		}
 	}	
    /**
     * Data in the field adds a combo.
     */	
 	function addComboItem(comboObj,comboItems) {
 		var comboID=comboObj.options.id;
 		switch(comboID) {		
 			case "tariff_type":
 				comboObj.InsertItem(0, "All|All", "All");
		  		for (var i=0 ; i < comboItems.length ; i++) {
		  	   		var comboItem=comboItems[i].split(FIELDMARK);
		  				comboObj.InsertItem(i+1, comboItem[0].toString() + "|" + comboItem[1].toString(), comboItem[0].toString());
		  	   	}
 			   	break;
 		}			   	
 	}
	// Process of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
	 		case IBSEARCH:     // Search
				if (!validateForm(sheetObj, formObj, sAction)) {
					return false;
				}
	 			if(sheetObj.id == "t1sheet1"){
	 				//ComOpenWait Start
					sheetObj.SetWaitImageVisible(0);
			        ComOpenWait(true);
			        formObj.f_cmd.value=SEARCH01;
			        sheetObj.DoSearch("EES_DMT_5001-1GS.do",	FormQueryString(formObj) );
	 				//ComOpenWait End
					ComOpenWait(false);
				} else if(sheetObj.id == "t2sheet1"){
					//ComOpenWait Start
					sheetObj.SetWaitImageVisible(0);
			        ComOpenWait(true);
					formObj.f_cmd.value=SEARCH02;
					sheetObj.DoSearch("EES_DMT_5001-1GS.do",	FormQueryString(formObj) );
					//ComOpenWait End
					ComOpenWait(false);
				}
	 			break;
		}
	}	 
	/**
	*  SETTING
	*/
	function doInit() {
		var formObj=document.form;
		var tabOrder=formObj.tab_order.value;
		with (formObj) {
			//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
			//tab1 tarrif type
			doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
			//tab1
			//Retrieves the current date of User Office
			var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj); 
			ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); 
			ComSetObjValue(formObj.to_dt,   ofcCurrDate);  
			//formObj.fm_dt.value = ComGetDateAdd(null, "M", -1);
    		//formObj.to_dt.value = ComGetNowInfo("ymd"); 
    		//sheetObjects[0].RemoveAll();
    		//tab2 a/r office
			doActionIBCombo(sheetObjects[1],formObj,IBSEARCH_ASYNC04,comboObjects[2]);
			//tab2
			var ofcCurrDateT2=DmtComOfficeCurrDate(sheetObjects[1], formObj); 
			ComSetObjValue(formObj.fm_dt_t2, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); 
			ComSetObjValue(formObj.to_dt_t2,   	ofcCurrDateT2); 
    		//formObj.fm_dt_t2.value = ComGetDateAdd(null, "M", -1); 
    		//formObj.to_dt_t2.value = ComGetNowInfo("ymd"); 
    		//sheetObjects[1].RemoveAll();
		}
	}  
	function initSearchControls() {
		var formObj=document.form;
		var tabOrder=formObj.tab_order.value;
		with (formObj) {
//			ComResetAll();
			if(tabOrder == 0){
				ComClearManyObjects(cust_cd, cust_nm, ofc_cd_t1, s_cust_gubun, s_cust_cd);		
			 	DmtComSetClassManyObjects('input', cust_cd); 
			 	ComSetObjValue(r_office, "1");
			 	chk_sub_ofc.checked=false;
			 	ComSetObjValue(cust_type, "P");
			 	//tab1 office 	
				//doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC06,comboObjects[0]);
				doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC01,comboObjects[0]);
				//tab1 tarrif type
				doActionIBCombo(sheetObjects[0],formObj,IBSEARCH_ASYNC02,comboObjects[1]);
				//tab1
				//Retrieves the current date of User Office
				var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObj); 
				ComSetObjValue(formObj.fm_dt, 	ComGetDateAdd(ofcCurrDate, "M", -1)); 
				ComSetObjValue(formObj.to_dt,   ofcCurrDate); 
				//formObj.fm_dt.value = ComGetDateAdd(null, "M", -1);
	    		//formObj.to_dt.value = ComGetNowInfo("ymd"); 
	    		sheetObjects[0].RemoveAll();
			} else {
				ComClearManyObjects(act_cust_cd, act_cust_nm, ofc_cd_t2, s_cust_gubun_t2, s_cust_cd_t2);		
			 	DmtComSetClassManyObjects('input', act_cust_cd); 
			 	chk_sub_ofc_t2.checked=false;
			 	ComSetObjValue(chg_cd, "");
			 	ComSetObjValue(io_bnd_cd, "");
			 	ComSetObjValue(type, "");
				//tab2 a/r office
				doActionIBCombo(sheetObjects[1],formObj,IBSEARCH_ASYNC04,comboObjects[2]);
				//tab2
				//Retrieves the current date of User Office
				var ofcCurrDateT2=DmtComOfficeCurrDate(sheetObjects[1], formObj); 
				ComSetObjValue(formObj.fm_dt_t2, 	ComGetDateAdd(ofcCurrDateT2, "M", -1)); 
				ComSetObjValue(formObj.to_dt_t2,   	ofcCurrDateT2); 
	    		//formObj.fm_dt_t2.value = ComGetDateAdd(null, "M", -1); 
	    		//formObj.to_dt_t2.value = ComGetNowInfo("ymd"); 
	    		sheetObjects[1].RemoveAll();
			}
		}
	}    
    /**
     * Initialization Tab
     * Setting Tab's entry.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
            case 1:
                with (tabObj) {
                    var cnt=0 ;
					InsertItem( "From DEM/DET" , "");
					InsertItem( "From Other" , "");
                }
                break;
        }
    }
    /**
 	 * handling process for input validation
 	 */
 	function validateForm(sheetObj,formObj,sAction)
 	{
 		 with(formObj){
 		 	//1.  From DEM/DET : 0, From Other : 1
 			var tabOrder=tab_order.value;
 			//[TAB1]From DEM/DET 
 			if(tabOrder == 0){
 				ComSetObjValue(ofc_cd, 			comboObjects[0].GetSelectText());
 				ComSetObjValue(dmdt_trf_cd, 	comboObjects[1].GetSelectText());
 	 			if (ComGetObjValue(r_office) == '1') {
 	 				formObj.ofc_tp.value="ar_if_ofc";
 	 			} else if (ComGetObjValue(r_office) == '2') {
 	 				formObj.ofc_tp.value="issue_ofc";
 	 			}
 	 			var ofcCd=ComGetObjValue(ofc_cd);
 	 			var dmdtTrfCd=ComGetObjValue(dmdt_trf_cd);
 	 			if(ofcCd == ''){
 	 				ComShowCodeMessage('DMT02002', 'Office');
 	 				return;
 	 			}
 				if(dmdtTrfCd == ''){
 					ComShowCodeMessage('DMT02002', 'Tariff Type');
 					return;
 				}
     			if(!ComIsDate(fm_dt)) {
     				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
     				return false;
     			}
     			if(!ComIsDate(to_dt)) {
     				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
     				return false;
     			}
                if (ComChkPeriod(fm_dt.value, to_dt.value) <= 0){
        			ComShowCodeMessage('DMT01020');
        			return false;
        		} else if(ComChkPeriod(formObj.fm_dt.value, formObj.to_dt.value) > 0){
     				if(ComGetDaysBetween(formObj.fm_dt.value, formObj.to_dt.value) > 365){
     					ComShowCodeMessage('DMT00162','1 Year');
     					return false;
     				}
     			}
 			} 
 			//[TAB2]From Other 
 			else if(tabOrder == 1){
 				ComSetObjValue(ofc_cd, 			comboObjects[2].GetSelectText());
 	 			var ofcCd=ComGetObjValue(ofc_cd);
 	 			if(ofcCd == ''){
 	 				ComShowCodeMessage('DMT02002', 'Office');
 	 				return;
 	 			}
 	 			if(!ComIsDate(fm_dt_t2)) {
     				ComAlertFocus(fm_dt, ComGetMsg('COM12134', 'Period From Date'));
     				return false;
     			}
     			if(!ComIsDate(to_dt_t2)) {
     				ComAlertFocus(to_dt, ComGetMsg('COM12134', 'Period To Date'));
     				return false;
     			}
                if (ComChkPeriod(fm_dt_t2.value, to_dt_t2.value) <= 0){
        			ComShowCodeMessage('DMT01020');
        			return false;
        		} else if(ComChkPeriod(formObj.fm_dt_t2.value, formObj.fm_dt_t2.value) > 0){
     				if(ComGetDaysBetween(formObj.fm_dt_t2.value, formObj.fm_dt_t2.value) > 365){
     					ComShowCodeMessage('DMT00162','1 Year');
     					return false;
     				}
     			}
 			}
 		}
 		return true;
 	}
 	/**
      * Click on Tab event-related
      * Elements selected tab is active.
      */
 	function tab1_OnChange(tabObj , nItem){
     	 var objs=document.all.item("tabLayer");
     	 var formObj=document.form;
     	 objs[nItem].style.display="Inline";
     	 objs[beforetab].style.display="none";
     	 objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
 	 	 //------------------------------------------------------//
     	 beforetab=nItem;
     	 formObj.tab_order.value=beforetab;
//     	 var schCondDiv=document.getElementById("sch_cond_div");
     	 var schCondDiv=document.getElementById("btn_detail");
//     	 alert(ComGetObjValue(formObj.tab_order));
     	 if(ComGetObjValue(formObj.tab_order) == 0){
     		schCondDiv.style.display='inline';
	 	 } else {
	 		schCondDiv.style.display='none';
	 	 }
//     	 alert("[tab order]:"+formObj.tab_order.value);
 	}		  
	function t1sheet1_OnSearchEnd(sheetObj, code, msg, stCode, stMsg){
    	with(sheetObj){
			if ( RowCount()<= 0 ) { return; }
            for ( var i=1 ; i < LastRow(); i++ ) {
            	if ( GetCellValue( i , "payer_flg" ) == "Y" ) {
                    SetToolTipText( i , "payer_cd" ,"Customer Code not available any more");
                    SetCellFontColor( i , "payer_cd" ,"#DC0000");
                }
            }  
//			sheetObj.ShowSubSum([{StdCol:"ofc_cd", SumCols:"inv_chg_amt|tax_amt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ofc_cd=%s;seq=S.TTL"}]);
//			sheetObj.ShowSubSum([{StdCol:"ar_if_dt", SumCols:"inv_chg_amt|tax_amt|inv_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ofc_cd=%s;ar_if_dt=%s;seq=S.TTL"}]);
////			sheetObj.ShowSubSum("inv_curr_cd", 	"inv_chg_amt|tax_amt|inv_amt", -1, false, false, 0, "chk=;ofc_cd=%s;ar_if_dt=%s;inv_curr_cd=%s;seq=S.TTL");
//			SetSumText(0, "seq","TTL");
            SetSumValue(0, "seq","TTL");
		}
    }
	function t2sheet1_OnSearchEnd(sheetObj, code, msg, stCode, stMsg){
		with(sheetObj){
			if ( RowCount()<= 0 ) { return; }
            for ( var i=1 ; i < LastRow(); i++ ) {
            	if ( GetCellValue( i , "payer_flg" ) == "Y" ) {
                    SetToolTipText( i , "payer_cd" ,"Customer Code not available any more");
                    SetCellFontColor( i , "payer_cd" ,"#DC0000");
                }
            }   
//			sheetObj.ShowSubSum([{StdCol:"ar_ofc_cd", SumCols:"chg_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ar_ofc_cd=%s;seq=S.TTL"}]);
//			sheetObj.ShowSubSum([{StdCol:"if_dt", SumCols:"chg_amt", Sort:false, ShowCumulate:false, CaptionCol:0, CaptionText:"chk=;ar_ofc_cd=%s;if_dt=%s;seq=S.TTL"}]);
//			SetSumText(0, "seq","TTL");
            SetSumValue(0, "seq","TTL");
		}
	}
	/*
	 * Each common pop-up function calls 
	 */
	function openPopup(flag, arg) {
		var sheetObj=sheetObjects[0];
		var formObj=document.form;
		var sUrl='';
		var sWidth='';
		var sHeight='';
		with(sheetObj) {
	  		switch(flag) {
	  			case 'cust_cd':		// Customer Inquiry Popup
					ComOpenPopup('COM_ENS_041.do', 770, 470, "getCustCd", "1,0,1,1,1,1,1", true);
					break;
	  			case 'act_cust_cd':		// Customer Inquiry Popup
				ComOpenPopup('COM_ENS_041.do', 770, 470, "getActCustCd", "1,0,1,1,1,1,1", true);
				break;					
	  		} // switch-end
		} // with-end
		if(sUrl.indexOf('.do') != -1) {
			//var sWinName = ComReplaceStr(sUrl, '.do', '');
  			var sWinName=sUrl.substring(0, sUrl.indexOf('.do'));
			ComOpenWindowCenter(sUrl, sWinName, sWidth, sHeight, true);
		} 
		else if(sUrl != '') {
			ComOpenWindow(sUrl, "", "scrollbars=no,toolbar=no,location=no,resizable=yes,menubar=no, width=" + sWidth + ",height=" + sHeight + ",left=0,top=0");
		}
	}
    /*
  	 *Set in a field is selected in the Customer Code  as Cstomer pop-up 
  	 */
    function getCustCd(aryPopupData) {
    	document.form.cust_cd.value=aryPopupData[0][3];
        document.form.cust_nm.value=aryPopupData[0][4];
    }
     function getActCustCd(aryPopupData) {
     	document.form.act_cust_cd.value=aryPopupData[0][3];
        document.form.act_cust_nm.value=aryPopupData[0][4];
     }
	function doActionText(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.cust_cd)));
        if(cust_len == 0){
        	ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
        	return;
        }
        if(cust_len > 2) {
			var char_chk=ComGetObjValue(formObj.cust_cd).substring(0,2);
			//If the two-digit alphanumeric code, then Retrieving CUSTOMER
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			// else Retrieving VENDOR
			}else{
				ComSetObjValue(formObj.s_cust_gubun, "1");
				ComSetObjValue(formObj.s_cust_cd, formObj.cust_cd.value);
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.cust_cd, "");
            ComSetObjValue(formObj.cust_nm, "");
            ComSetFocus(formObj.cust_cd);
			return;
		}
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd=ComGetEtcData(sXml, "PAYER_CODE");
        var custNm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.cust_cd);
            document.form.s_cust_gubun.value="";
            document.form.cust_cd.value="";
            document.form.cust_nm.value="";   
            ComShowCodeMessage("DMT00165", "Payer");
        } else {
        	document.form.cust_nm.value=custNm;
            document.form.cust_cd.value=custCd;
        }
        sheetObj.SetWaitImageVisible(1);
    } 
	function doActionTextT2(sheetObj, formObj, object, formCmd) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        var cust_len=parseInt(ComGetLenByByte(ComGetObjValue(formObj.act_cust_cd)));
        if(cust_len == 0){
        	ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.act_cust_cd, "");
            ComSetObjValue(formObj.act_cust_nm, "");
        	return;
        }
        if(cust_len > 2) {
			var char_chk=ComGetObjValue(formObj.act_cust_cd).substring(0,2);
			//If the two-digit alphanumeric code, then Retrieving CUSTOMER
			if(ComIsAlphabet(char_chk)) {
				ComSetObjValue(formObj.s_cust_gubun, "2");
	            ComSetObjValue(formObj.s_cust_cd, formObj.act_cust_cd.value);
			// else Retrieving VENDOR
			}else{
				ComShowCodeMessage("DMT00165", "Payer");
				ComSetObjValue(formObj.s_cust_gubun, "");
	            ComSetObjValue(formObj.act_cust_cd, "");
	            ComSetObjValue(formObj.act_cust_nm, "");
	            ComSetFocus(formObj.act_cust_cd);
				return;
			}
		}else{
			ComShowCodeMessage("DMT00165", "Payer");
			ComSetObjValue(formObj.s_cust_gubun, "");
            ComSetObjValue(formObj.act_cust_cd, "");
            ComSetObjValue(formObj.act_cust_nm, "");
            ComSetFocus(formObj.act_cust_cd);
			return;
		}
        ComSetObjValue(formObj.f_cmd, formCmd);
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var custCd=ComGetEtcData(sXml, "PAYER_CODE");
        var custNm=ComGetEtcData(sXml, "PAYER_NM");
        var delt_flg=ComGetEtcData(sXml, "DELT_FLG");
        if(custNm == null || custNm == "" || custNm == undefined) {
            ComSetFocus(formObj.act_cust_cd);
            document.form.s_cust_gubun.value="";
            document.form.act_cust_cd.value="";
            document.form.act_cust_nm.value="";     
            ComShowCodeMessage("DMT00165", "Payer");
        } else {
        	document.form.act_cust_nm.value=custNm;
            document.form.act_cust_cd.value=custCd;
        }
        sheetObj.SetWaitImageVisible(1);
    } 
	
//	function office_OnCheckClick(comboObj, index, code) {
//		var formObj=document.form;
//		if(index==0) {
//	    	var bChk=comboObj.GetItemCheck(index);
//    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//    			comboObj.SetItemCheck(i,bChk);
//	    	}
//	    } else {
//    		comboObj.SetItemCheck(0,0);
//	    }
//		if(formObj.chk_sub_ofc.checked) {
//			if(comboObj.GetItemCheck(index))
//				comboObj.SetItemCheck(index,0);
//			else
//				comboObj.SetItemCheck(index,1);
//			ComShowCodeMessage('DMT00107');
//		}
//	}
	function office_OnSelect(comboObj, index, text, code) {
		selComboIndex = index;
		selComboCode  = code;
	}
    function office_OnChange(comboObj) {
        DmtComMultiCombo_OnChange(comboObj, selComboIndex, selComboCode, document.form.chk_sub_ofc);
    }
	
//	function office_t2_OnCheckClick(comboObj, index, code) {
//		var formObj=document.form;
//		if(index==0) {
//	    	var bChk=comboObj.GetItemCheck(index);
//    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//    			comboObj.SetItemCheck(i,bChk);
//	    	}
//	    } else {
//    		comboObj.SetItemCheck(0,0);
//	    }
//		if(formObj.chk_sub_ofc_t2.checked) {
//			if(comboObj.GetItemCheck(index))
//				comboObj.SetItemCheck(index,0);
//			else
//				comboObj.SetItemCheck(index,1);
//			ComShowCodeMessage('DMT00107');
//		}
//	}	
	function office_t2_OnSelect(comboObj, index, text, code) {
		selComboIndex = index;
		selComboCode  = code;
	}
    function office_t2_OnChange(comboObj) {
        DmtComMultiCombo_OnChange(comboObj, selComboIndex, selComboCode, document.form.chk_sub_ofc_t2);
    }
    
	function office_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
		if(formObj.chk_sub_ofc.checked) {
			ComShowCodeMessage('DMT00107');
		}
	}
	function office_t2_OnKeyDown(comboObj, keycode, shift) {
		var formObj=document.form;
		if(formObj.chk_sub_ofc_t2.checked) {
			ComShowCodeMessage('DMT00107');
		}
	}
 	//====================================================================================================================
 	// 수정일시 : 2014.08.19
 	// comboObj_OnCheckClick 함수는 2개의 함수로 변환됨 : comboObj_OnSelect, comboObj_OnChang
 	//====================================================================================================================	
	//Multi Combo click event
//	function tariff_type_OnCheckClick(comboObj, index, code) {
//	    if(index==0) {
//	    	var bChk=comboObj.GetItemCheck(index);
//    		for(var i=1 ; i < comboObj.GetItemCount() ; i++) {
//    			comboObj.SetItemCheck(i,bChk);
//	    	}
//	    } else {
//    		comboObj.SetItemCheck(0,0);
//	    }
//	}
	 var selComboIndex, selComboCode;
	 function tariff_type_OnSelect(comboObj ,index, text , code) {
	  selComboIndex = index;
	  selComboCode = code;
	 }
	 
	 function tariff_type_OnChange(comboObj) {
	     ComSetMultiCombo(comboObj, selComboIndex, selComboCode);
	 }	
	
	/**
	 * pop up
	 * @param sheetObj
	 * @param formObj
	 * @param srcName
	 * @return
	 */
	function openPopupWindow(sheetObj, formObj, srcName) {
		
		 if (srcName == "btn_detail") {
			 
			 openInvoiceCreationIssueBooking(sheetObj, formObj);
		 }// End of the "btn_detail" action
	}
	/*
	 * Double-click pop-up(4002/4004)
	 */
 	function t1sheet1_OnDblClick(sheetObj, Row, Col, CellX, CellY, CellW, CellH) {
 		
 		openInvoiceCreationIssueBooking(sheetObj, document.form);
 	}  	 
 	function findCommodity(rtnVal) {
//  		var formObj = document.form;
//  		var sheetObj=sheetObjects[0];
//        if(rtnVal == "Y") {
//        	doActionIBSheet(sheetObj, formObj, IBSEARCH);
//		}
    }
 	
 	function openInvoiceCreationIssueBooking(sheetObj, formObj) {
 		
 		var subInvType = sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_inv_no").substring(2, 3);
 		
 		if (subInvType == 'R' || subInvType == 'T') {
 			//4002
 			var url="EES_DMT_4002.do"
 				+"?group_by=1"
 				+"&chg_type="
 				+"&ofc_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "ofc_cd") 
 				+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "bkg_no")
 				//+"&ofc_cd="+ComGetObjValue(formObj.ofc_cd)
 				//+"&bkg_no="+ComGetObjValue(formObj.bkg_no)
 				+"&dmdt_trf_cd="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_trf_cd")
 				+"&invoice_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_inv_no")
 				+"&cntr_no="
 				+"&invoice_issue=2"	
 				;
 			ComOpenPopup(url, "1050", "700", "findCommodity", "0,1", true);
 		} 
 		else if (subInvType == 'M') {

 			//4004
 			var url="EES_DMT_4004P.do"
 				+"?dmdt_inv_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),  "dmdt_inv_no")
 				+"&caller=5003"
 				;
 			ComOpenPopup(url, "1100", "700", "findCommodity", "0,1", true);				
 		}
 	}
 	