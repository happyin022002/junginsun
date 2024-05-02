/*=========================================================
*Copyright(c) 2016 CyberLogitec. All Rights Reserved.
*@FileName   : ees_cgm_2105.js
*@FileTitle  : Movement Inquiry by Mgset
*@author     : CLT
*@version    : 1.0
*@since      : 2016/11/22
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_CGM_1100 : EES_CGM_1100 business script for
     */

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class ees_cgm_1105 : ees_cgm_1105 business script for
    */

   	/* developer job	*/
 // common global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 var prefix1="sheet1_";
 var prefix2="sheet2_";
 var IBSEARCH02=30;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** use additional sheet var in case of more than 2 tap each sheet *****/
          var sheetObject1=sheetObjects[0];
          var sheetObject2=sheetObjects[1];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
     		if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
 				case "btn_retrieve":
 					doActionIBSheet(sheetObject1, formObject, IBSEARCH);
 					break;
 				case "btn_new":
 					objectClear();
               	    sheetObject1.RemoveAll();
               	    sheetObject2.RemoveAll();
               	    formObject.eq_no.focus();
 					break;
 				case "btn_downexcel":
 					if(sheetObject1.RowCount() < 1){//no data
 	         			ComShowCodeMessage("COM132501");
 	         		}else{
 	         			sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1 });
 	         		}
 					break;
 				case "btn_print":
 					if( sheetObjects[0].RowCount()==0 && sheetObjects[1].RowCount()==0) {
 						errMsg='No data found.';
 						ComShowMessage(msgs["CGM10012"]);
 						return;
 					}
 					formObject.f_cmd.value=IBSEARCH02;
 					ComOpenPopupWithTarget('/opuscntr/EES_CGM_2106.do?pgmNo=EES_CGM_2106', 775, 800, "", "0,1,1,1,1,1,1", true);
					break;
 				 case "btns_Calendar1" :		// Agreement Date (From Date)
	 				var vcal=new ComCalendar();
	 				vcal.setDisplayType("date");
	 				vcal.select(formObject.str_mvmt_dt, "yyyy-MM-dd");
	 				break;
	 			case "btns_Calendar2" :		// Agreement Date (To Date)
//	 				var cal = new ComCalendar();
//	 	    		cal.select(formObject.end_mvmt_dt, "yyyy-MM-dd");
	 	    		var vcal=new ComCalendarFromTo();
	 	    		vcal.setDisplayType("date");
		            vcal.select(formObject.str_mvmt_dt, formObject.end_mvmt_dt,  'yyyy-MM-dd');
	 	    		break;
				case "btn_close":
					ComClosePopup(); 
					break
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
    	 var sheetObject1=sheetObjects[0];
         for(i=0;i<sheetObjects.length;i++){
         //
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
         //
             ComEndConfigSheet(sheetObjects[i]);
         }
         sheet1_OnLoadFinish(sheetObjects[0]);
     }
      /**
      * 
      * @param sheetObj
      * @return
      */
  function sheet1_OnLoadFinish(sheetObj) {
         sheetObj.SetWaitImageVisible(0);
         var formObj=document.form;
      //   axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate', formObj);
      //   axon_event.addListenerFormat('beforeactivate',	  'obj_activate',	formObj);
 			//doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
         // reset
         initControl(sheetObjects[0]); 
         sheetObj.SetWaitImageVisible(1);
    }
      /**
		 * init control of form <br>
		 * 
		 * @param {object}
		 *            sheetObj
		 * @return
		 * @author
		 * @version
		 */
function initControl(sheetObj) {
	// Form object
	var formObj = document.form;
	// axon event regist
	if (formObj.eq_no.value != "") {
		var fr_dt = new String(document.form.calend1.value).substring(0, 8);
		var to_dt = new String(document.form.calend2.value).substring(0, 8);
		formObj.str_mvmt_dt.value = to_dt.substring(0, 4) + '-'+ to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
		formObj.end_mvmt_dt.value = fr_dt.substring(0, 4) + '-'+ fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
		doActionIBSheet(sheetObj, formObj, IBSEARCH);
	} else {
		objectClear();
		formObj.eq_no.focus();
	}
	axon_event.addListenerForm('change', 'obj_change', form); // - when object is changed.

}

	function resizeSheet(){
		ComResizeSheet( sheetObjects[1] );
	}
   /**
	 * setting sheet initial values and header param : sheetObj, sheetNo adding
	 * case as numbers of counting sheets
	 */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
 		 var sheetID=sheetObj.id;
         switch(sheetID) {
             case "sheet1":
                 with (sheetObj) {
                 var HeadTitle2="|Seq.|Status|Movement Date|Org. Yard|Dest. Yard|CNTR No.|Chassis No.|User company|Remark(s)|Creation Date|User ID|Office|Creation User Name|Update Date|User ID|Office|Update User Name|Trucker|Trucker Description";
                 var headCount=ComCountHeadTitle(HeadTitle2);
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle2, Align:"Center"} ];
                 InitHeaders(headers, info);
                 var cols = [ {Type:"Status",    Hidden:1, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"hdnStatus" },
                        {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"Seq" },
                        {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"mvmt_sts_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"mvmt_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"yd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"dest_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"chss_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cntr_ownr_co_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"diff_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cre_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"cre_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"cre_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix1+"upd_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix1+"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix1+"vndr_abbr_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                  
                 InitColumns(cols);
                 SetSheetHeight(220);
                 SetEditable(1);
 			  				 }
                 break;
             case "sheet2":
                 with (sheetObj) {
                 var HeadTitle2="Seq.|CNTR No.|Chasssis No.|Attach Date|Attach Yard|Detach Date|Detach Yard";
                 SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
                 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
                 var headers = [ { Text:HeadTitle2, Align:"Center"} ];
                 InitHeaders(headers, info);

                 var cols = [ {Type:"Seq",       Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:prefix2+"Seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"cntr_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:180,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"chss_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"atch_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"atch_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"dtch_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
                        {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:0,   SaveName:prefix2+"dtch_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];
                 InitColumns(cols);
//                 SetSheetHeight(150);
                 SetEditable(1);
                 resizeSheet();
 			  	}
                 break;                 
         }
     }
   // handling process for Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:      //retrieve
            formObj.f_cmd.value=SEARCH;
            if(validateForm(sheetObj,formObj,sAction)){
            	var prefix0="";
            	var aryPrefix=new Array(prefix0,prefix1,prefix2);
            	var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(aryPrefix);
            	sheetObj.SetWaitImageVisible(0);
 			 	ComOpenWait(true);
                 var sXml=sheetObj.GetSearchData("EES_CGM_2105GS.do" , sParam);
           		var arrXml=sXml.split("|$$|");
           		if(DomXml2String(arrXml[0], "eq_no") == null || DomXml2String(arrXml[0], "eq_no") == "") {
           			formObj.eq_tpsz_cd.value="";
                	formObj.agmt_lstm_cd.value="";
                	formObj.onh_dt.value="";
                	formObj.aciac_div_cd.value="";
                	// tab1 Sheet Object
             		sheetObjects[0].RemoveAll();
             	// tab1 Sheet Object
             		sheetObjects[1].RemoveAll();
        			// check message out
        			ComShowCodeMessage("CGM10012");
        			ComSetFocus(formObj.eq_no);
        		}
                else
                {
                	formObj.eq_tpsz_cd.value=DomXml2String(arrXml[0], "eq_tpsz_cd");
                	formObj.agmt_lstm_cd.value=DomXml2String(arrXml[0], "agmt_lstm_cd");
                	formObj.onh_dt.value=DomXml2String(arrXml[0], "onh_dt");
                	formObj.aciac_div_cd.value=DomXml2String(arrXml[0], "aciac_div_cd");
                	// tab1 Sheet Object
             		sheetObjects[0].LoadSearchData(arrXml[1],{Sync:0} );
             	// tab1 Sheet Object
             		sheetObjects[1].LoadSearchData(arrXml[2],{Sync:0} );
                }
           		ComOpenWait(false);
            }
            break;
         }
     }
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
    	  with(formObj){
     		 switch(sAction) {
     		 	case IBSEARCH:
     		 		if(formObj.eq_no.value == ''){
        				ComShowCodeMessage('CGM10004','M.G Set No. ');
        				formObj.eq_no.focus();
        				return false;
        			}
     		 		 var dt_str=ComReplaceStr(document.form.str_mvmt_dt.value,"-","");
         			 var dt_end=ComReplaceStr(document.form.end_mvmt_dt.value,"-","");
     	    		if(dt_str != '' && dt_end != ''){
     	    			if(dt_end < dt_str){
     	    				ComShowCodeMessage('COM12133','To date','From date','greater');
     	    				str_mvmt_dt.value='';
     	    				str_mvmt_dt.focus();
     	    				return false;
     	    			}
     	    		}
            			break;
     		 }      
     	 }
         return true;
     }

function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetCellAlign(0, "Seq", "Left");
	}
}

function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		SetCellAlign(0, "Seq", "Left");
	}
}

function objectClear() {
	var formObj = document.form;
	var fr_dt = new String(document.form.calend1.value).substring(0, 8);
	var to_dt = new String(document.form.calend2.value).substring(0, 8);
	formObj.eq_no.value = "";
	formObj.eq_tpsz_cd.value = "";
	formObj.agmt_lstm_cd.value = "";
	formObj.onh_dt.value = "";
	formObj.str_mvmt_dt.value = to_dt.substring(0, 4) + '-'+ to_dt.substring(4, 6) + '-' + to_dt.substring(6, 8);
	formObj.end_mvmt_dt.value = fr_dt.substring(0, 4) + '-'+ fr_dt.substring(4, 6) + '-' + fr_dt.substring(6, 8);
}

/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function domFunFocusDel(a) {
	var formObj = document.form;
	obj = ComGetEvent();
	if (obj.name == "str_mvmt_dt") {
		document.form.str_mvmt_dt.value = ComReplaceStr(document.form.str_mvmt_dt.value, "-", "");
	}
	if (obj.name == "end_mvmt_dt") {
		document.form.end_mvmt_dt.value = ComReplaceStr(document.form.end_mvmt_dt.value, "-", "");
	}
	//ComShowMessage("domFunFocusDel");
}
/** 
 * Object deactivate event handling  <br>
 * @param  
 * @return 
 * @author 
 * @version
 */
function obj_deactivate() {
	var formObj = document.form;
	obj = ComGetEvent();
	if (obj.name == "str_mvmt_dt") {
		with (formObj) {
			var creDtFr = ComReplaceStr(str_mvmt_dt.value, "-", "");
		}
		ComChkObjValid(ComGetEvent());
	}
	if (obj.name == "end_mvmt_dt") {
		with (formObj) {
			var creDtFr = ComReplaceStr(end_mvmt_dt.value, "-", "");
		}
		ComChkObjValid(ComGetEvent());
	}
}
/**
 * AXON event handling
 */
function obj_activate() {
	ComClearSeparator(ComGetEvent());
}

/**
 * handling event on change
 */
function obj_change() {
	var obj = ComGetEvent();
	var formObj = document.form;
	if (ComTrim(ComGetObjValue(obj)) != "") {
		switch (ComGetEvent("name")) {
		case "eq_no":
			formObj.eq_no.value = formObj.eq_no.value.toUpperCase();
			doActionIBSheet(sheetObjects[1], formObj, IBSEARCH);
			break;
		}
	}
}
	/* developer job end */
