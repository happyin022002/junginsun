/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_VSK_0241.js
*@FileTitle : P/F SKD Type Help (Pop-Up) 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
   Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
               Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends 
     * @class VOP_VSK_0241 : business script for VOP_VSK_0241
     */
    function VOP_VSK_0241() {
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
 // Event handler processing by button click event */
 document.onclick=processButtonClick;
 // Event handler processing by button name */
 function processButtonClick(){
      var sheetObject1=sheetObjects[0];
      /*******************************************************/
      var formObject=document.form;
 	try {
 		var srcName=ComGetEvent("name");
        if (!ComIsBtnEnable(srcName)) return;  
         switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
			case "btn_new":
				ClearData(sheetObject1,formObject);
				break;
			case "btn_close":
  ComClosePopup(); 
				break;
			case "btn_search":
				openLandCdHelp(sheetObject1);
				break;	
			case "btn_Select":
				var cnt=sheetObject1.RowCount();
				if(cnt > 0){
					comPopupOK();
				}
				break;		
         } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
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
    
     var sheetObject1 	= sheetObjects[0];
	 var formObject 	= document.form;
	 
     for(i=0;i<sheetObjects.length;i++){
         ComConfigSheet (sheetObjects[i] );
         initSheet(sheetObjects[i],i+1);
         ComEndConfigSheet(sheetObjects[i]);
     }
     
     initControl();
     document.form.vsl_slan_cd.focus();
     
     //resizeTo( 1000, document.body.scrollHeight );
     window.scrollTo(0,0);
     
     doActionIBSheet(sheetObject1,formObject,IBSEARCH);
 }
 /**
  * registering initial event
  **/
 function initControl() {
	 var formObj=document.form;
	 //axon_event.addListenerForm		('focus'	, 'obj_focus'		, formObj);
	 //axon_event.addListenerFormat	('keypress'	, 'obj_keypress'	, form);
  	 //axon_event.addListenerFormat	('keyup'	, 'obj_change' 		, form);
 }
 
 function obj_focus() {
	if(event.srcElement.options){
		event.srcElement.focus();
	}else{
		event.srcElement.select();
	}
}
 /**
  * Handling key press event
  **/
 function obj_keypress() {
	 switch(event.srcElement.dataformat){
         case "float":
             ComKeyOnlyNumber(event.srcElement, ".");
             break;
         case "eng":
             ComKeyOnlyAlphabet();
             break;
         case "engdn":
             ComKeyOnlyAlphabet('lower');
             break;
         case "engup":
             ComKeyOnlyAlphabet('upper');
             break;
         case "uppernum":
     		ComKeyOnlyAlphabet('uppernum');
             break;    
         default:
            ComKeyOnlyNumber(event.srcElement);
     }
 }
 /**
  * Handling change event
  */
 function obj_change(){
	var formObject=document.form;
	var sheetObject1=sheetObjects[0];
 	try {
 		var srcName=ComGetEvent("name");
 		switch(srcName) {
 			case "vsl_slan_cd":
 				var cnt=formObject.vsl_slan_cd.value;
 				if(ComChkLen(formObject.vsl_slan_cd,3) == 2){
					doActionIBSheet(sheetObject1,formObject,SEARCH02);
				}
		     	break;
		 } // end switch
 	}catch(e) {
 		if( e == "[object Error]") {
 			ComShowCodeMessage('VSK00011');
 		} else {
 			ComShowMessage(e.message);
 		}
 	}
 }
  /*
   * setting sheet initial values and header
   * param : sheetObj, sheetNo
   * adding case as numbers of counting sheets
   */
 function initSheet(sheetObj,sheetNo) {
     var cnt=0;
     switch(sheetNo) {
         case 1:      // sheet1 init
        	    with(sheetObj){
             		
             		var HeadTitle1="|Lane|Lane Name|P/F SKD \nType|Jointed \nVSL Class|Created Date|Live";
             		var headCount=ComCountHeadTitle(HeadTitle1);
             		var prefix="sheet1_";

             		SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

             		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
             		var headers = [ { Text:HeadTitle1, Align:"Center"}];
             		InitHeaders(headers, info);

             		var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:190,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_slan_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pf_svc_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:prefix+"vsl_class",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"slan_stnd_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
            
		           InitColumns(cols);
		
		           SetEditable(1);
		           SetColProperty(prefix+"cre_dt", {Format:"####-##-## ##:##"} );
		           SetSheetHeight(300);
                 }


             break;
         }
     }
 /*
  * handling sheet process
  */
 function doActionIBSheet(sheetObj,formObj,sAction) {
     sheetObj.ShowDebugMsg(false);
     switch(sAction) {
        case IBSEARCH:      //Retrieve
        	if(formObj.vsl_slan_cd.value == ""){
        		formObj.vsl_slan_cd.focus();
        		ComShowCodeMessage("VSK00067");
        		return;
        	}
        	sheetObj.SetWaitImageVisible(0);
  		    ComOpenWait(true);
        	formObj.f_cmd.value=SEARCH;
        	var sParam="f_cmd=" + formObj.f_cmd.value +
        				"&vsl_slan_cd=" + formObj.vsl_slan_cd.value;
        	sheetObj.DoSearch("VOP_VSK_0241GS.do", sParam + "&" + ComGetPrefixParam("sheet1_") );
        	showSheetData(sheetObj,formObj);
        	ComOpenWait(false);
        	break;
        case SEARCH02:
        	sheetObj.SetWaitImageVisible(0);
  		    ComOpenWait(true);
			 formObj.f_cmd.value=SEARCH02;
			 //var sXml = sheetObj.GetSearchXml("VOP_VSK_0241GS.do?op_=0241" , FormQueryString(formObj));
			 var sXml=sheetObj.GetSearchData("VOP_VSK_0241GS.do" , FormQueryString(formObj));
   		  	 var checkLane=ComGetEtcData(sXml, "checkLane");
   		  	 if(checkLane == undefined){
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				formObj.vsl_slan_cd.value="";	
				formObj.vsl_slan_cd.focus();
   		  	 }
   		  	 ComOpenWait(false);
   		  	 break;    
     }
 }
function showSheetData(sheetObj,formObj){
	var prefix="sheet1_";
	var cnt=sheetObj.RowCount();
	for(var i=0; i<=cnt; i++){
if(sheetObj.GetCellValue(i,prefix+"slan_stnd_flg") == "Y"){
			var pinkColor="#NANNANNAN";
			sheetObj.SetCellBackColor(i,prefix+"vsl_slan_cd",pinkColor);
			sheetObj.SetCellBackColor(i,prefix+"vsl_slan_nm",pinkColor);
			sheetObj.SetCellBackColor(i,prefix+"pf_svc_tp_cd",pinkColor);
			sheetObj.SetCellBackColor(i,prefix+"vsl_class",pinkColor);
			sheetObj.SetCellBackColor(i,prefix+"cre_dt",pinkColor);
			sheetObj.SetCellBackColor(i,prefix+"slan_stnd_flg",pinkColor);
			break;
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
 /**
  * Open Lane Code Help
  */
 function openLandCdHelp(sheetObj){
    var targetObjList="sheet1_vsl_slan_cd:vsl_slan_cd";
    var v_display="0,0";
    ComOpenPopup('/opuscntr/VOP_VSK_0202.do', 500, 470, "returnSvcLaneCdHelp", "0,0", true);
 }
 
 function returnSvcLaneCdHelp(rtnObjs){
	var formObj=document.form;
	var rtnDatas=rtnObjs[0];
	if(rtnDatas.length > 0){
		formObj.vsl_slan_cd.value=rtnDatas[1]; //vessel code
	}
}
 
 function ClearData(sheetObj,formObj){
	 formObj.vsl_slan_cd.value="";
	 formObj.vsl_slan_cd.focus();
	 sheetObj.RemoveAll();
}
 /**
  * Returning Data to Parent Screen
  */
 function sheet1_OnDblClick(sheetObj, Row, Col) {
	 comPopupOK();
 }
 function Search(){
	 var formObj=document.form;
	 doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
 }
