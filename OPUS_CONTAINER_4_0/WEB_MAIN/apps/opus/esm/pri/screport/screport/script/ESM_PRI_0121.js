/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_0121.js
*@FileTitle : MOT Filing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

//global variables 
 var tabObjects=new Array();
 var tabCnt=0 ;
 var beforetab=1;
 var sheetObjects=new Array();
 var sheetCnt=0;
//Event handler processing by button click event */
 document.onclick=processButtonClick;
	/**
  * Event handler processing by button name 
  */
 function processButtonClick(){
	 var sheetObject1=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	 try {
		 var srcName=ComGetEvent("name");
		 if(ComGetBtnDisable(srcName)) return false;
		 
		 switch(srcName) {
		 case "btns_calendar": 
			 var cal=new ComCalendarFromTo();
             cal.select(formObject.from_file_dt, formObject.to_file_dt, 'yyyy-MM-dd');
			 break;
		 case "btn_Retrieve":
             doActionIBSheet(sheetObject1, form, IBSEARCH);
			 break;
		 case "btn_Downexcel":
			 doActionIBSheet(sheetObject1, form, IBDOWNEXCEL);
			 break;
		 } // end switch
	 }catch(e) {
 		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	 } finally {
 		ComOpenWait(false);
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
  * Initializing and setting Sheet basics<br> 
  * Setting body tag's onLoad event handler<br>
  * Adding pre-handling function after loading screen on the browser <br>
  */
 function loadPage() {
	 for(i=0;i<sheetObjects.length;i++){
		 ComConfigSheet (sheetObjects[i] );
		 initSheet(sheetObjects[i],i+1);
		 ComEndConfigSheet(sheetObjects[i]);
	 }
	 //axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', document.form);
	 axon_event.addListenerFormat('keydown', 'obj_keydown', document.form);
	 gCurrDate=ComGetDateAdd(null, "D", -1)
     form.from_file_dt.value=gCurrDate;
     form.to_file_dt.value=gCurrDate;
	 doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
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
	 case "sheet1":
		    with(sheetObj){
	        
	      
	      var HeadTitle="|Seq.|Carrier|Contract\nNo.|Contract Holder|Lane|Origin\n(POL)|Dest\n(POD)| |CNTR\nType|CMDT\nType|Size|MQC1|MQC2|Rate|Commission|SUR|Effective\nDate|Expiry\nDate|Remark(s)";
	      var headCount=ComCountHeadTitle(HeadTitle);

	      SetConfig( { SearchMode:2, Page:20, FrozenCol:0, DataRowMerge:1 } );

	      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	      var headers = [ { Text:HeadTitle, Align:"Center"} ];
	      InitHeaders(headers, info);

	      var cols = [ {Type:"Status",    Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"Status" },
	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Right",   ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"carrier",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:0,   SaveName:"sc_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:"ctrt_pty_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Right",   ColMerge:0,   SaveName:"lane",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cmdt_tp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"cntr_sz",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mqc_1",        KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"mqc_2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"oft_rt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:20,   Align:"Right",   ColMerge:0,   SaveName:"commission",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Int",       Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"sur_rt",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"exp_dt",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	             {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"remark",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	      InitColumns(cols);
	      resizeSheet();//SetSheetHeight(450);
	      SetAutoRowHeight(0);
	            }

		 break;
	 }
 }
 function resizeSheet(){
 	ComResizeSheet(sheetObjects[0]);
 }
 
 
  /**
   * Handling sheet process<br>
   */
function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:     
			if (!validateForm(sheetObj,formObj,sAction)) {
				return;
			}
			
			if (sheetObj.id == "sheet1") {
				formObj.f_cmd.value=SEARCH;
				var queryStr="f_cmd=" + formObj.f_cmd.value;
				queryStr += "&from_file_dt=" + formObj.from_file_dt.value;
				queryStr += "&to_file_dt=" + formObj.to_file_dt.value;
				sheetObj.DoSearch("ESM_PRI_0121GS.do", queryStr );
//				sheetObj.DoSearch4Fx("ESM_PRI_0121GS.do", queryStr);
//				sheetObj.ApplyFormat();
			}
			break;
		case IBDOWNEXCEL:      //download excel
//			sheetObjects[0].SpeedDown2Excel(-1); //, "chk|seq"
			if (sheetObj.RowCount()== 0 ) {
		   		ComShowCodeMessage("COM132501"); // No data to dowload as Excel
		   	    return;
		   	} else {
		   		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(			sheetObj), SheetDesign:1,Merge:1 });
		   	}
			
			
	        break;
	}
}
/**
 * handling OnKeyDown event
 */       
function obj_keydown(){
   //enter key retrieving
   var eleName=event.srcElement.name;
   if (eleName == "from_file_dt" || eleName == "to_file_dt"){
       var keyValue=null;
       if(event == undefined || event == null) {
    	   keyValue=13;
       }else{
    	   keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
       }
       if (keyValue == 13){
    	   doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
       }
   }
}
/** 
 * Object's Onbeforedeactivate event handler <br>
 * checking validation inputting data by object's dataformat <br>
 */ 
//function obj_deactivate() {
 //   var form=document.form;
 //   var formObj=event.srcElement;
 //   ComChkObjValid(formObj);
//}
 /**
  * checking validation of Period date  <br>
  */
 function chkEffDate(formObj) {
     var form=document.form;
     var fromDt=form.from_file_dt;
     var toDt=form.to_file_dt;
     var fromVal=fromDt.value.replace(/-/g,'');
     var toVal=toDt.value.replace(/-/g,'');
     var fromAddD=ComGetDateAdd(toVal, "D", -2, "", true);
     if( parseInt(fromVal,10) < parseInt(fromAddD,10) ) {
         ComShowCodeMessage("PRI00308", "check the date range!.", " Maximum date range is 3 days");
         event.returnValue=false;
         ComSetFocus(formObj);
         return false;
     }
     return true;
 }
 /**
 * checking validation process of inputed form data <br>
 */
 function validateForm(sheetObj,formObj,sAction){
	  var fromFileDt=form.from_file_dt;
	  var toFileDt=form.to_file_dt
	  switch (sAction) {
	      case IBSEARCH: 
		      if(formObj.from_file_dt.value == "") {
		    	  ComShowCodeMessage("PRI00335", fromFileDt.caption);
		    	  ComSetFocus(fromFileDt);
		    	  return false;
		      }
		      if(formObj.to_file_dt.value == "") {
		    	  ComShowCodeMessage("PRI00335", toFileDt.caption);
		    	  ComSetFocus(toFileDt);
		    	  return false;
		      }
		      
		      
		      // checking from date > to date 
		      if(!ComChkObjValid(fromFileDt)) { return false; }
		      if(!ComChkObjValid(toFileDt)) { return false; }
		      // checking to date - from date > 3 days
		      if(!chkEffDate(fromFileDt)) {return false;}
              if(!chkEffDate(toFileDt)) {return false;}
		      break;
	  }
	 return true;
 }


	function sheet1_OnSort(sheetObj, Col, SortArrow  ) {
		sheetObj.ReNumberSeq();    
	}

