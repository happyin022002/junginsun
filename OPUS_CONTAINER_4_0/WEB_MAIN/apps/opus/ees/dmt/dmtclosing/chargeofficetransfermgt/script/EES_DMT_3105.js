/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3105.js
*@FileTitle  : Office Transfer History - CNTR
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/****************************************************************************************
     Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
                  MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class EES_DMT_3105 : business script for EES_DMT_3105
     */
 // Common Global variables
 var sheetObjects=new Array();
 var sheetCnt=0;
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
     function processButtonClick(){
          /***** case in Sheet count are more two by Tab, defining adding sheet *****/
          var sheetObject1=sheetObjects[0];
          /*******************************************************/
          var formObject=document.form;
     	try {
     		var srcName=ComGetEvent("name");
             switch(srcName) {
 				case "btn_Close":
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
             ComConfigSheet (sheetObjects[i] );
             initSheet(sheetObjects[i],i+1);
             ComEndConfigSheet(sheetObjects[i]);
         }
         doInit();
     }
     function doInit() {
    	 var formObj=document.form;
    	 doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
     }
   /**
      * setting sheet initial values and header
      * param : sheetObj, sheetNo
      * adding case as numbers of counting sheets
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:      // sheet1 init
            	 with(sheetObj){
            	 	var HeadTitle="Seq.|From|TO|Office Transfer|Office Transfer|Office Transfer|Reason";
            	 	var HeadTitle2="Seq.|From|TO|Date|Office|Name|Reason";
            	 	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	 	var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
            	 	var headers = [ { Text:HeadTitle, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
            	 	InitHeaders(headers, info);

            	 	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
            	 	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"fm_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	 	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"to_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	 	             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	 	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	 	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	 	             {Type:"Text",      Hidden:0,  Width:0,    Align:"Left",    ColMerge:1,   SaveName:"trns_rsn",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
    
            	 	InitColumns(cols);
            	 	SetSheetHeight(220);
            	 	SetEditable(0);
            	 	SetEllipsis(1);
                 }
            	 break;
         }
     }
   // Process of Sheet
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
            case IBSEARCH:     // Search
                 if(!validateForm(sheetObj,formObj,sAction)) return;
                 formObj.f_cmd.value=SEARCH;
                 sheetObj.DoSearch("EES_DMT_3105GS.do", FormQueryString(formObj) );
                 break;
         }
     }
	// Balloon handling in Grid
	function sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
 		with(sheetObj){
 			Row = MouseRow();
 			Col = MouseCol();
 			if (Row > 0) {
 				var ttText='';
 				var colSaveNm = ColSaveName(Col);
 				if (colSaveNm == 'trns_rsn') {	
 					var ttText = GetCellValue(Row, colSaveNm);
 					if (ComGetLenByByte(ttText) <= 30)
 						ttText = '';
 				}
 				SetToolTipText(Row, Col, ttText);
 			} 
 			else {
 				SetToolTipText(Row, Col, "");
 			}
 		}
 	}
     /**
      * handling process for input validation
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
//             if (!isNumber(formObj.iPage)) {
//                 return false;
//             }
         }
         return true;
     }