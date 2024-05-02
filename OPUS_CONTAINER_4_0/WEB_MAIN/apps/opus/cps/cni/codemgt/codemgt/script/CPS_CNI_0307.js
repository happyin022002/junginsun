/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0307.js
*@FileTitle  : R.O.E. (Rate of Exchange) Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
    function processButtonClick(){
     var sheetObject=sheetObjects[0];
     /*******************************************************/
     var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
    		switch(srcName) {
                case "cal_fm_dt":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.fm_dt, 'yyyy-MM');
                    break; 
                case "cal_to_dt":
					var cal=new ComCalendar();
					cal.setDisplayType('month');
					cal.select(form.to_dt, 'yyyy-MM');
                    break; 
				case "btn_retrieve":
	             	doActionIBSheet(sheetObject,formObject,IBSEARCH);
	            break;
                case "btn1_New":
					ComResetAll();
                    break; 
				case "btn1_Select":
					sheet1_OnDblClick(sheetObject, sheetObject.GetSelectRow(), 0)
	            break;
				case "btn1_Close":
					ComClosePopup(); 
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
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
    	initControl();
    }
		/**
		* registering initial event 
		*/
    function initControl() {
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form);
        //axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form);
    //	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
        //axon_event.addListener ('keypress', 'obj_keypress' , form);
        //axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
 	//focus in
 	function obj_activate(){
 		obj=ComGetEvent();
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    /**
     * checking validation
     **/
    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
    }
    /**
     * only numbers
     **/
    function obj_keypress(){
    	switch(ComGetEvent("name")){
	        case "search_curr_cd":
	            ComKeyOnlyAlphabet('uppernum');
	            break;
			default:
		        //only numbers
		        ComKeyOnlyNumber(ComGetEvent());
    	}
    }
    /**
     * setting sheet initial values and header
     * @param {ibsheet} sheetObj Mandatory IBSheet Object
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
					var HeadTitle1="Seq|Year-Month|Local Currency|Description|Rate of Exchange (R.O.E.)|Rate of Exchange (R.O.E.)|Rate of Exchange (R.O.E.)|Created Date|Updated Date";
					var HeadTitle2="Seq|Year-Month|Local Currency|Description|USD/Local|Local/KRW|USD/KRW|Created Date|Updated Date";
					var headCount=ComCountHeadTitle(HeadTitle1);
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"},{ Text:HeadTitle2, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
					 {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"acct_xch_rt_yrmon",  KeyField:0,   CalcLogic:"",   Format:"Ym",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:"curr_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"curr_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"usd_locl_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"locl_cny_xch_rt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0,  Width:85,   Align:"Right",   ColMerge:1,   SaveName:"usd_cny_xch_rt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Date",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
					   
					InitColumns(cols);
					SetSheetHeight(240);
					SetEditable(0);
                    }
                break;
        }
    }
    /**
     * Handling sheet's processes
     * @param {ibsheet} sheetObj mandatory IBSheet Object
     * @param {form} formObj mandatory html form object
     * @param {int} sAction mandatory,Constant Variable
     * @return void
     **/
    function doActionIBSheet(sheetObj,formObj,sAction) {
        switch(sAction) {
        	case IBSEARCH:      //조회
        		if(validateForm(sheetObj,formObj,sAction)){
        			formObj.f_cmd.value=SEARCH;
        			sheetObj.DoSearch("CPS_CNI_0307GS.do", FormQueryString(formObj) );
        		}
        		break;
        }
    }
	/**
	* The function called when OnDbClick event on Sheet1 triggered 
	* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
	* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
	* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
	*/
	function sheet1_OnDblClick(sheetObj, row, col) {	
		if (row < 1) {
			return;
		}
		var xchRtVo={
			curr_cd:sheetObj.GetCellValue(row , "curr_cd"),
			usd_locl_xch_rt:sheetObj.GetCellValue(row , "usd_locl_xch_rt"),
			locl_cny_xch_rt:sheetObj.GetCellValue(row , "locl_cny_xch_rt"),
			usd_cny_xch_rt:sheetObj.GetCellValue(row , "usd_cny_xch_rt")
		};
		opener.setCurrencyROE(xchRtVo);
		ComClosePopup(); 
	}
    /**
     * handling process for input validation <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {form} formObj     	 form Object
     * @param {ibsheet} sAction     IBSheet Object
     * @param {String}  value    	input values sheetObj
     * @return {boolean} true or false
     * @see #ComChkValid
     **/
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if (!ComChkValid(formObj)) return false;
        }
        return true;
    }
