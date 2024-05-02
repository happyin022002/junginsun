/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0308.js
*@FileTitle  : Vessel Code & Name Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
=========================================================*/
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
//     rm;
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
				case "btn1_Retrieve":
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
        sheetObjects[0].SetExtendLastCol(0);
    	initControl();
    	form.vsl_cd.focus();
    }
    /**
		 * registering initial event 
     **/
    function initControl() {
    	axon_event.addListenerForm  ('blur'	, 'obj_deactivate', form);
//        axon_event.addListenerFormat('keypress'        	, 'obj_keypress'  , form);
//    	axon_event.addListenerFormat('beforeactivate'	, 'obj_activate'  , form);
//        axon_event.addListener ('keypress', 'obj_keypress' , form);							
//        axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
    }
 	//focus in
 	function obj_activate(){
 		obj=event.srcElement;
 		if (obj.getAttribute("readOnly")) return;
 		ComClearSeparator(obj);
 	} 
    /**
     * checking validation
     **/
    function obj_deactivate(){
        ComChkObjValid(event.srcElement);
    }
    /**
     * only numbers
     **/
    function obj_keypress(){
    	switch(event.srcElement.name){
	        case "vsl_cd":
	            ComKeyOnlyAlphabet('upper');
	            break;
			default:
		        //only numbers
		        ComKeyOnlyNumber(event.srcElement);
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
                with (sheetObj) {
	                
	                var HeadTitle1="Seq|Code|Name of Vessel|TOV|TOO|Built|Flag|GRT|Carrier";
	                var headCount=ComCountHeadTitle(HeadTitle1);
	//                (headCount, 0, 0, true);
	
	                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	                InitHeaders(headers, info);
	
	                var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	                       {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:1,   SaveName:"vsl_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"tov",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_own_ind_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"lnch_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:1,   SaveName:"cnt_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"grs_rgst_tong_wgt",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:3,   UpdateEdit:0,   InsertEdit:0 },
	                       {Type:"Text",      Hidden:0,  Width:183,  Align:"Left",    ColMerge:1,   SaveName:"crr_nm",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	                 
	                InitColumns(cols);
	                SetEditable(0);
	                SetSheetHeight(240);

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
         			sheetObj.DoSearch("CPS_CNI_0308GS.do", FormQueryString(formObj) );
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
		var vslVo={
				vsl_cd:sheetObj.GetCellValue(row , "vsl_cd"),
				vsl_eng_nm:sheetObj.GetCellValue(row , "vsl_eng_nm")
		};
		opener.setVslCd(vslVo);
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
			var vslCd=formObj.vsl_cd.value.trim();
			var vslEngNm=formObj.vsl_eng_nm.value.trim();
			if (vslCd == '' && vslEngNm == '') {
				ComAlertFocus(formObj.vsl_cd, ComGetMsg("CNI09034"));
				return;
			}
        }
        return true;
    }
