/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3103.js
*@FileTitle  : Correction Save History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code added code to make a good  JSDoc ------------------*/
/**
 * @fileoverview JavaScript is commonly used in business calendar-related functions are defined as.
 * @author Hanjin Shipping
 */
/**
 * @extends 
 * @class EES_DMT_3103 : EES_DMT_3103 for generating business from the screen using a script is defined.
 */
   	/* Developer's task 	*/
	 // common global variables
	 var sheetObjects=new Array();
	 var sheetCnt=0;
	 // Event handler processing by button click event */
	 document.onclick=processButtonClick;
	 // Event handler processing by button name */
     function processButtonClick(){
    	 /***** Tab sheets per case more than two additional sheets are used to specify a variable *****/
    	 var sheetObject1=sheetObjects[0];
    	 /*******************************************************/
    	 var formObject=document.form;
    	 try {
     		var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
             switch(srcName) {
             	case "btn_Close":
             		ComClosePopup(); 
					break;
             } // end switch
    	 } catch(e) {
     		if( e == "[object Error]") {
     			ComShowMessage(OBJECT_ERROR);
     		} else {
     			ComShowMessage(e.message);
     		}
    	 }
     }
     /**
      * Register as an array IBSheet Object
      * The next batch of other items when you need treatment of fiberglass can add to an array that holds the process
      * Array defined at the top of the source
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
         sheet1_OnLoadFinish();
     }
	function initControl() {
		axon_event.addListener('mouseover', 'btn_mouseover',	'tdGB');	 
		axon_event.addListener('mouseout',	'btn_mouseout',		'tdGB');	
	}
	function btn_mouseover() {
		var bak='lightyellow';
		var msg='General/Balance Charge Type';
		var content="<TABLE BORDER=0 CELLPADDING=1 CELLSPACING=0 BGCOLOR=#000000><TR><TD><TABLE WIDTH=100% BORDER=0 CELLPADDING=2 CELLSPACING=0 BGCOLOR="+bak
						+"><TR><TD style=font-family:tahoma;font-size:9pt;>"+msg+"</TD></TR></TABLE></TD></TR></TABLE>"; 
    	var x=event.x+document.body.scrollLeft;
		var y=event.y+document.body.scrollTop;
		var skn=document.all("topdeck").style;
		skn.left=x;
		skn.top=y-20;
		document.all("topdeck").innerHTML=content;
		skn.visibility='visible';
     }
     function btn_mouseout() {
    	 var skn=document.all("topdeck").style;
    	 skn.visibility='hidden';
     }
     function sheet1_OnLoadFinish() {
         doInit();
     }
     function doInit() {
    	 var sheetObj=sheetObjects[0];
    	 var formObj=document.form;
    	 doActionIBSheet(sheetObj, formObj, IBSEARCH);
     }
   /**
      * Sheet the initial setting, the header definition
      * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
      * Many case as the number of sheets to add the sheet, a sheet should initialize the module configuration
      */
     function initSheet(sheetObj,sheetNo) {
         var cnt=0;
         switch(sheetNo) {
             case 1:
            	    with(sheetObj){
		               var HeadTitle1="Seq.|Charge\nStatus|From|From|From|To|To|To|Web Empty Notification|Web Empty Notification|Web Empty Notification|Creation|Creation|Creation|Creation";
		               var HeadTitle2="Seq.|Charge\nStatus|Date|Yard|STS|Date|Yard|STS|Web MT DT|User ID|User Name|Date|User OFC|User ID|User Name";
		               SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		               var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		               var headers = [ { Text:HeadTitle1, Align:"Center"},
		                               { Text:HeadTitle2, Align:"Center"} ];
		               InitHeaders(headers, info);
		               var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
			                      {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"chg_sts_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"fm_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"fm_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"to_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"to_mvmt_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"web_mty_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"web_mty_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"web_mty_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cre_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_id",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"cre_nm",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                      {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"corr_his_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		               InitColumns(cols);
		               SetEditable(1);
		               SetEllipsis(1);
		               SetColHidden("web_mty_dt",1);
		               SetColHidden("web_mty_id",1);
		               SetColHidden("web_mty_nm",1);
		               SetSheetHeight(300);
         			}
                 break;
         }
     }
	// Sheet processing-related processes
     function doActionIBSheet(sheetObj,formObj,sAction) {
         sheetObj.ShowDebugMsg(false);
         switch(sAction) {
         	case IBSEARCH:      
		         formObj.f_cmd.value=SEARCH;
		         sheetObj.DoSearch("EES_DMT_3103GS.do", FormQueryString(formObj) );
		         break;
         }
     }
     function sheet1_OnClick(sheetObj, Row, Col, Value) {
    	 var corrHisRmk=sheetObj.GetCellValue(Row, "corr_his_rmk");
    	 ComSetObjValue(document.form.corr_his_rmk, corrHisRmk);
     }
 	function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
 		var formObj = document.form;
 		with(sheetObj) {
	    	 var cntCd=ComGetObjValue(formObj.login_cnt_cd);
	    	 if(cntCd == 'US') {
	    		 SetColHidden("web_mty_dt",0);
	    		 SetColHidden("web_mty_id",0);
	    		 SetColHidden("web_mty_nm",0);
	    	 } else if(SearchRows() > 0) {
	    		 for(var i=GetTopRow(); i <= LastRow(); i++) {
	    			 if(GetCellValue(i, "web_mty_dt") != '' || GetCellValue(i, "web_mty_id") != '' || GetCellValue(i, "web_mty_nm") != '') {
	    				 SetColHidden("web_mty_dt", false);
	    				 SetColHidden("web_mty_id", false);
	    	    		 SetColHidden("web_mty_nm", false);
	    	    		 break;
	    			 }
	    		 }
	    		 var corrHisRmk=GetCellValue(GetTopRow(), "corr_his_rmk");
	    		 ComSetObjValue(formObj.corr_his_rmk, corrHisRmk);
	    	 }
 		}
 	}
     /**
      * Screen input form validation process for handling
      */
     function validateForm(sheetObj,formObj,sAction){
         with(formObj){
         }
         return true;
     }
	/* Developer's task end */