/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ees_eqr_1050.js
*@FileTitle  : Match-back by Vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/14
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
     * @class ees_eqr_8002 : business script for ees_eqr_8002
     */
// common static variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var enterSwitch=false;

var strHidTpSz = "";
var hidD2YN = 0;
var hidD4YN = 0;
var hidD5YN = 0;
var hidD7YN = 0;
var hidR2YN = 0;
var hidR5YN = 0;
var hidO2YN = 0;
var hidS2YN = 0;
var hidO4YN = 0;
var hidS4YN = 0;
var hidF2YN = 0;
var hidA2YN = 0;
var hidF4YN = 0;
var hidA4YN = 0;
var hidF5YN = 0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
    function processButtonClick(){
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
//                	obj_click();
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                    sheetObjects[0].SetSelectRow(0);
                break;
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    formObject.reset();
                    var titleTpSz=document.form.tpszlist.value;
                    var titleLine="D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
                    titleLineArray = titleLine.split("|");
                    var k = 0;
                    sheetObjects[0] = sheet1;
                    sheetObjects[0] = sheetObjects[0].Reset();
                    initSheet(sheetObjects[0],1);
                    
                	for(var j=0;j<titleLineArray.length;j++) {
                		k = j + 5;
                		sheetObjects[0].SetColWidth(k, "60");
     	    			sheetObjects[0].SetColHidden(k,0);
                	}
         	    	
                    document.getElementById("fromdate").focus();
                break;
                case "btn_downExcel":
                	if(sheetObject.RowCount() < 1){//no data
                		ComShowCodeMessage("COM132501");
            		}else{
            			sheetObject.Down2Excel({ HiddenColumn:-1,Merge:true});
            		}
                break;
                case "btn_print":
//                    if( sheetObject.RowCount() == 0 ) {
//                        ComShowCodeMessage("EQR90224");
//                        return;
//                    }
                    formObject.f_cmd.value=IBSEARCH_ASYNC02;
                    ComOpenPopupWithTarget('/opuscntr/EES_EQR_8902.do', 775, 650, "", "0,1,1,1,1,1,1", true);
                break;
                case "btns_calendarfm":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
                break;
//                case "btns_calendarto":
//                    var cal=new ComCalendarFromTo();
//                    cal.setEndFunction("nextFocusOut");
//                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
//                break;
            } // end switch
        }catch(e) {
            if( e == "[object Error]") {
                ComShowMessage(OBJECT_ERROR);
            } else {
                ComShowMessage(e.message);
            }
        }
    }
    function nextFocusOut(){
        document.form.location.focus();
    }     
    /**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function initControl(){
        axon_event.addListener      ( 'blur'     , 'obj_blur'       , 'location'    );
      //  axon_event.addListener      ( 'click'    , 'obj_click'      , 'div'    		);
//        axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
//        axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- handling activate event
//        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- handling deactivate event
//        axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
//        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        document.form.fromdate.focus();
    }    
    function obj_click(){
        var check="";
        for(var i=0 ; i < document.form.div.length ; i++){
            if(document.form.div[i].checked){
            	check=document.form.div[i].value;
            }
        }
        sheetObjects[0] = sheetObjects[0].Reset();
        ComConfigSheet (sheetObjects[0] );
        initSheet(sheetObjects[0],1,check);
        ComEndConfigSheet(sheetObjects[0]);
//    	initSheet(sheetObjects[0],1,check);  
    }
    /**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
     */
    function loadPage() {
    	strHidTpSz = hidtpszallCode;
    	
   	    if(strHidTpSz.indexOf("D2") > -1) { hidD2YN = 1; }
	    if(strHidTpSz.indexOf("D4") > -1) { hidD4YN = 1; }
	    if(strHidTpSz.indexOf("D5") > -1) { hidD5YN = 1; }
	    if(strHidTpSz.indexOf("D7") > -1) { hidD7YN = 1; }
	    if(strHidTpSz.indexOf("R2") > -1) { hidR2YN = 1; }
	    if(strHidTpSz.indexOf("R5") > -1) { hidR5YN = 1; }
	    if(strHidTpSz.indexOf("O2") > -1) { hidO2YN = 1; }
	    if(strHidTpSz.indexOf("S2") > -1) { hidS2YN = 1; }
	    if(strHidTpSz.indexOf("O4") > -1) { hidO4YN = 1; }
	    if(strHidTpSz.indexOf("S4") > -1) { hidS4YN = 1; }
	    if(strHidTpSz.indexOf("F2") > -1) { hidF2YN = 1; }
	    if(strHidTpSz.indexOf("A2") > -1) { hidA2YN = 1; }
	    if(strHidTpSz.indexOf("F4") > -1) { hidF4YN = 1; }
	    if(strHidTpSz.indexOf("A4") > -1) { hidA4YN = 1; }
	    if(strHidTpSz.indexOf("F5") > -1) { hidF5YN = 1; }
	    
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,"D"); 
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
    * setting sheet initial values and header
    * param : sheetObj, sheetNo
    * adding case as numbers of counting sheets
    */
    function initSheet(sheetObj,sheetNo,option) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
	                var HeadTitle="Port|VVD|ETB|DIV|Total|D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
	                var headCount=ComCountHeadTitle(HeadTitle);
	                var rowCnt=0;
	                var sumLine="|d2| + |d4| + |d5| + |d7| + |r2| + |r5| + |o2| + |s2| + |o4| + |s4| + |f2| + |a2| + |f4| + |a4| + |f5|";
	                cnt=0;
	                rowCnt=0;
	                SetConfig( { SearchMode:2, MergeSheet:7, Page:200, DataRowMerge:0, PrevColumnMergeMode:0} );
	                var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	                var headers = [ { Text:HeadTitle, Align:"Center"} ];
	                InitHeaders(headers, info);
	                var cols = [ {Type:"Text",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",   	KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Text",    Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",    	KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Date",    Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etb",    	KeyField:0,   CalcLogic:"",   Format:"Ymd" },
		                       {Type:"Text",    Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"div",    	KeyField:0,   CalcLogic:"",   Format:"" },
		                       {Type:"Int",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",  	KeyField:0,   CalcLogic:sumLine ,  Format:"NullInteger" }, 
		                       {Type:"Int",     Hidden:hidD2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidD4YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d4",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidD5YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d5",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidD7YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d7",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidR2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidR5YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r5",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidO2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidS2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidO4YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o4",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidS4YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s4",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidF2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidA2YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a2",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidF4YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f4",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidA4YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a4",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
		                       {Type:"Int",     Hidden:hidF5YN,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f5",     	KeyField:0,   CalcLogic:"",   Format:"NullInteger" }]; //,
                    		   //{Type:"AutoSum", Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calcTotal", KeyField:0,   CalcLogic:sumLine,   Format:"NullInteger" } ];
//	                if(option == "A"){
//	                	cnt=0;
//	                	rowCnt++;
//		                cols.push({Type:"Text",  Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
//		                cols.push({Type:"Text",  Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
//		                cols.push({Type:"Date",  Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etb",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:1 });
//		                cols.push({Type:"Text",  Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"div",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",  KeyField:0,   CalcLogic:sumLine,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d7",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"Int",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
//		                cols.push({Type:"AutoSum", Hidden:1,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"calcTotal", KeyField:0,   CalcLogic:sumLine,   Format:"NullInteger" });
//	                }
                	InitColumns(cols);
	                SetEditable(0);
	                //SetSheetHeight(410);
	                resizeSheet();	                
                }
            break;
        }
    }
    // handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:  // retrieve
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == "sheet1")
                		sheetObj.SetWaitImageVisible(0);
             			ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;

                        sheetObj.DoSearch("EES_EQR_8002GS.do",FormQueryString(formObj) );
//                        sheetObj.LoadSearchData("EES_EQR_8002GS.do",FormQueryString(formObj) );

                		sheetObj.SetWaitImageVisible(1);
            			ComOpenWait(false);
                } else {
                    return;
                }
            break;
            case IBSEARCH_ASYNC01:  // Location

                if ( validateForm(sheetObj, formObj, sAction) ) {
                    var xLocationBy="";
                    for(var i=0 ; i < document.form.inquirylevel.length ; i++){
                        if(document.form.inquirylevel[i].checked){
                            xLocationBy=document.form.inquirylevel[i].value;
                        }
                    }                    
                    formObj.f_cmd.value=SEARCH01;
                    if ( formObj.location.value == "" ) {
                        return false;
                    }
                    if ( formObj.inquirylevel.value == "" ) {
                        return false;
                    }
                    formObj.inquiryLevel.value=xLocationBy;
                    if ( formObj.prelocation.value == formObj.location.value ) {
                        return false;
                    }
                    sheetObj.SetWaitImageVisible(0);
                    var sXml=sheetObj.GetSearchData( "EES_EQR_8002GS.do" , FormQueryString(formObj) );
                    var sCheck=ComGetEtcData( sXml, "check" );
                    if (sCheck != "OK") {
                        if (document.form.location.value != "") {
                            if (xLocationBy == "R") {
                                ComShowCodeMessage("EQR90201");
                                document.form.location.value="";
                                sheetObj.SetWaitImageVisible(1);
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "L") {
                                ComShowCodeMessage("EQR90202");
                                document.form.location.value="";
                                sheetObj.SetWaitImageVisible(1);
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "E") {
                                ComShowCodeMessage("EQR90203");
                                document.form.location.value="";
                                sheetObj.SetWaitImageVisible(1);
                                ComSetFocus(document.form.location);
                                return false;
                            } else if (xLocationBy == "S") {
                                ComShowCodeMessage("EQR90204");
                                document.form.location.value="";
                                sheetObj.SetWaitImageVisible(1);
                                ComSetFocus(document.form.location);
                                return false;
                            }
                        } else {
                            return true;
                        }
                    }
                    else{
                    	formObj.prelocation.value=formObj.location.value;
                    }
                    sheetObj.SetWaitImageVisible(1);
                    var f=document.getElementById("tpszlist");
                    ComSetFocus(f);
                } else {
                    return;
                }
            break;
        }
    }
//    function form_keyup() {
//        var obj=null;
//        var keyValue=event.keyCode ? event.keyCode : event.which ? event.which
//                : event.charCode;
//        if (keyValue != 13) {
//            ComKeyEnter('lengthnextfocus');
//        } else {
//            if (obj_deactivate()) {
//              //  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
//            }
//        }
//    }
//    function obj_keypress(){
//        switch(event.srcElement.name){
//            case "location":
//                ComKeyOnlyAlphabet('upper');// upper case
//            break;
//            case "fromdate":
//                // number + "-"
//                ComKeyOnlyNumber(event.srcElement);
//            break;
//            case "enddate":
//                // number + "-"
//                ComKeyOnlyNumber(event.srcElement);
//            break;
//        }   
//    }
    //handling deactivate event
//    function obj_deactivate() {
//    	alert(1);
//        var f=document.getElementById("fromdate");
//        var t=document.getElementById("enddate");
//        
//        alert("fromdate : " +f);
//        alert("enddate  : " +t);
//        
//        sVal1=f.value.replace(/\/|\-|\./g, "");
//        sVal2=t.value.replace(/\/|\-|\./g, "");
//        
//        alert("sVal1 : " +sVal1);
//        alert("sVal2 : " +sVal2);        
//        
//        switch (ComGetEvent("name")) {
//            case "fromdate":    
//            	
//            	alert("fromdate in ");
//                if (ComChkObjValid(ComGetEvent(), false)) {
//                    if (f.getAttribute("dataformat") == "ymd") {
//                        if (sVal1 != "" && sVal2 != "") {
//                            var flag=ComChkPeriod(sVal1, sVal2);
//                            if (flag < 1) {
//                                if(ComGetEvent("name") == "enddate"){
//                                    event.srcElement.value="";
//                                    ComShowCodeMessage("EQR90223");
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                                else{
//                                    t.value="";
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                            }
//                            else{
//                                if(chkToDateWeekBlur() == false){
//                                    event.srcElement.value="";
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                            }
//                            enterSwitch=true;
//                        }
//                    }
//                } else {
//                    if (f.getAttribute("dataformat") == "ymd") {
//                        if (sVal1.length > 0 && !ComIsDate(sVal1)  && event.srcElement.name == 'fromdate') {
//                            enterSwitch=false;
//                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
//                            event.srcElement.value="";
//                            event.srcElement.focus();
//                            event.srcElement.select();
//                            return false;
//                        }
//                    }
//                }
//                break;
//            case "enddate":  
//            	alert("enddate in ");
//                if (ComChkObjValid(ComGetEvent(), false)) {
//                    if (t.getAttribute("dataformat") == "ymd") {
//                        if (sVal1 != "" && sVal2 != "") {
//                            var flag=ComChkPeriod(sVal1, sVal2);
//                            if (flag < 1) {
//                                if(ComGetEvent("name") == "enddate"){
//                                    event.srcElement.value="";
//                                    ComShowCodeMessage("EQR90223");
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                                else{
//                                    t.value="";
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                            }
//                            else{
//                                if(chkToDateWeekBlur() == false){
//                                    event.srcElement.value="";
//                                    ComShowCodeMessage("EQR90221");
//                                    enterSwitch=false;
//                                    t.focus();
//                                    t.select();
//                                    return false;
//                                }
//                            }
//                            enterSwitch=true;
//                        }
//                    }
//                } else {
//                    if (t.getAttribute("dataformat") == "ymd") {
//                        if (sVal2.length > 0 && !ComIsDate(sVal2)  && ComGetEvent("name") == 'enddate') {
//                            enterSwitch=false;
//                            document.getElementById("enddate").value="";
//                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
//                            t.focus();
//                            t.select();
//                            return false;
//                        }
//                    }
//                }
//                break;
//            }   
//        return true;
//    }
    function lastDay(y, m) {
        var d, d2, s="";
        d=new Date();
        d2=new Date(y, m, "");
        s=d2.getDate();
        return (s);
    }
    
//    function chkToDateWeekBlur(){
//        var period=document.form.period.value;
//        var toDate=document.form.enddate.value;
//        var frDate=document.form.fromdate.value;
//        var toYearDate=toDate.substring(0,4);
//        var frYearDate=frDate.substring(0,4);
//        var toMonthDate=toDate.substring(5,7);
//        var frMonthDate=frDate.substring(5,7);
//        var frDayDate="";
//        var toDayDate="";
//        if(frDate.length > 7){
//            frDayDate=frDate.substring(8,10);
//            toDayDate=toDate.substring(8,10);
//        }
//        else{
//            frDayDate="01";
//            toDayDate=lastDay(toYearDate, toMonthDate);
//        }
//        var frDateFull=new Date(frYearDate, frMonthDate-1, frDayDate);
//        var toDateFull=new Date(toYearDate, toMonthDate-1, toDayDate);
//        var getDiffTime=toDateFull.getTime() - frDateFull.getTime();
//        var retDate=Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
//        var retMonth=((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate,10) - parseInt(frMonthDate,10));
//        var retWeek=Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
//        var week="";
//        var fromTo=52;
//        if(period == "M"){
//            if(retMonth>=12 ){
//                if(ComGetEvent("name") == "enddate"){
//                	//ComShowCodeMessage("EQR90221");
//                    return false;
//                }
//            }
//        }else if(period == "W"){
//            if ( frYearDate == toYearDate ) {
//                week=eval(toMonthDate) - eval(frMonthDate) + 1;
//            } else {
//                betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
//                if ( (eval(toYearDate) - eval(frYearDate) ) == 1 ) {    
//                    week=betwMonth;
//                } else {
//                    week=(eval(toYearDate) - eval(frYearDate) -1 ) * fromTo + betwMonth;
//                }
//            }
//            if(week>12){
//                ComShowCodeMessage("EQR90221");
//                document.getElementById("fromdate").value="";
//                document.getElementById("enddate").value="";
//                ComSetFocus(document.getElementById("fromdate"));
//                return;
//            }
//        }
//        return true;
//    }
//    function obj_activate() {
////        ComClearSeparator(ComGetEvent());
//        ComSetFocus(ComGetEvent());
//    }    
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
         with(formObj){
             if(sAction != IBSEARCH_ASYNC01){
                if(period.value == "M"){
                    if(fromdate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(fromdate);
                        return false;
                    }
                    else if(enddate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(enddate);
                        return false;
                    }
                }else if(period.value == "W"){
                    if(fromdate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(fromdate);
                        return false;
                    }
                    else if(enddate.value == ""){
                        ComShowCodeMessage("EQR90213","Period ");
                        ComSetFocus(enddate);
                        return false;
                    }
                }
                if( location.value == "" ){
                    ComShowCodeMessage("EQR90213","Location ");
                    ComSetFocus(location);
                    return false;
                }

                if (fromdate.value.length < 10) {
                    return false;
                } else if (enddate.value.length < 10) {
                    return false;
                }
//                alert("enterSwitch  : "+enterSwitch);
//                if(!enterSwitch){
//                    return false;
//                }
             }
         } // end of with
         return true;
    }
    // handling search end event on sheet
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
            var check2="";
            for(var i=0 ; i < document.form.div.length ; i++){
                if(document.form.div[i].checked){
                    check2=document.form.div[i].value;
                }
            }
/*
            for ( var x=0; x < RowCount(); x++) {
if (sheetObj.GetCellValue(x, 1) == "Total") {
                	if(check2 == "L"){
if(GetCellValue(x,"div") == "Load"){
	                		SetRowBackColor(x,"#C9D5EB");
                		}
                		else{
                			//RowHidden(x) = true;
                			RowDelete(x,false);
                		}
                	}
                	else if(check2 == "D"){
if(GetCellValue(x,"div") == "Disc"){
                		}
                		else{
                			//RowHidden(x) = true;
                			RowDelete(x,false);
                			SetRowBackColor(x,"#C9D5EB");
                		}
                	}
                	else{
                		SetRowBackColor(x,"#C9D5EB");
                	}
                }
            }
*/
            var loadTotal = 0;
            var discTotal = 0;
            for ( var i=5; i < 20 ; i++) {
                if( RowCount()> 0 ){
                	if ( ComIsNull( GetCellValue(RowCount()-1, i) ) || ComIsNull( GetCellValue(RowCount(), i) ) ) {
                 //org   	if(check2 == "L" || check2 == "D"){
                		//org   		SetSumText(0,i,""); //text to value
                		//org}
                		//orgelse{
                		//org	SetSumText(1,i,"");
                		//org	SetSumText(0,i,"");
                		//org}
                		//org}else{
                		loadTotal = loadTotal + parseInt(GetCellValue(RowCount()-1,i));
                		discTotal = discTotal + parseInt(GetCellValue(RowCount(),i));
                    	if(check2 == "L"){
                    		SetSumValue(0,i,ComAddComma(GetCellValue(RowCount()-1,i)));
                    	}
                    	else if(check2 == "D"){
                    		SetSumValue(0,i,ComAddComma(GetCellValue(RowCount(),i))); 
                    	}
                    	else{
                    		SetSumValue(0,i,ComAddComma(GetCellValue(RowCount()-1,i))); 
                    		SetSumValue(1,i,ComAddComma(GetCellValue(RowCount(),i))); 
                    	}
                    }
                }
            }
            for (var i=1; i < RowCount()-1; i++) {
            	SetCellValue(i,4,GetCellValue(i,"calcTotal"))
            }
            if( RowCount()> 0 ){
            	if(check2 == "L"){
                    SetSumText(0,4,ComAddComma(loadTotal));
            	}
            	else if(check2 == "D"){
            		SetSumText(0,4,ComAddComma(discTotal));
            	}
            	else{
            		SetSumText(0,4,ComAddComma(loadTotal));
            		SetSumText(1,4,ComAddComma(discTotal));
            	}
            }
            if (RowCount()> 0) {
            	//SetFrozenRows(5);
            	//SetRowHidden(RowCount()-1,1);
            	//SetRowHidden(RowCount(),1);
            	SetRowFontColor(RowCount()-1,"#FF0000");
            	SetRowFontColor(RowCount(),"#FF0000");
            	SetCellValue(RowCount()-1,0,"Grand Total");
            	SetCellValue(RowCount(),0,"Grand Total");
            	SetMergeCell(RowCount()-1, 0, 1, 3);
            	SetMergeCell(RowCount(), 0, 1, 3);
            }
            if(check2 == "L"){
            	if (RowCount()> 0) {
            		SetRowHidden(RowCount(),1);
            	}

            	SetSumText(0, 0,"Grand Total");
            	SetSumText(0, 1,"Grand Total");
            	SetSumText(0, 2,"Grand Total");
            	SetSumText(0, "div","Load");
                SetCellAlign(0, 0,"Center");
                SetCellAlign( LastRow(), "div" ,"Center   ");
                SetMergeCell( LastRow(), 0 , 1, 3 );
            }
            else if(check2 == "D"){
            	if (RowCount()> 0) {
            		SetRowHidden(RowCount()-1,1);
            	}	
            	SetSumText(0, 0,"Grand Total");
            	SetSumText(0, 1,"Grand Total");
            	SetSumText(0, 2,"Grand Total");
            	SetSumText(0, "div","Disc");
                SetCellAlign(0, 0,"Center");
                SetCellAlign( LastRow(), "div" ,"Center   ");
                SetMergeCell( LastRow(), 0 , 1, 3 );
            }
            else{
            	SetMergeCell(RowCount()-1, 0, 2, 3);
                //if(LastRow()> 1){
                	SetSumText(0, 0,"Grand Total");
                	SetSumText(0, 1,"Grand Total");
                	SetSumText(0, 2,"Grand Total");
                    SetSumText(1, 0,"Grand Total");
                    SetSumText(1, 1,"Grand Total");
                    SetSumText(1, 2,"Grand Total");
                	SetSumText(0, "div","Load");
                	SetSumText(1, "div","Disc");
                    SetCellAlign( LastRow()- 1 , "div" ,"Center   ");
                    SetCellAlign( LastRow(), "div" ,"Center   ");
	       			SetCellAlign( LastRow()- 1 , "port"  ,"Center");
	       			SetCellAlign( LastRow()- 1 , "vvd"  ,"Center");
	       			SetCellAlign( LastRow(), "vvd"  ,"Center");
	            //    SetMergeCell(  LastRow-1 , 0 , 2, 3 );
                //}
            }
            document.form.rpt_fromdate.value=document.form.fromdate.value;
            document.form.rpt_enddate .value=document.form.enddate .value;
            document.form.rpt_location.value=document.form.location.value;
            var check="";
            for(var i=0 ; i < document.form.inquirylevel.length ; i++){
                if(document.form.inquirylevel[i].checked){
                    check=document.form.inquirylevel[i].value;
                }
            }
            if ( check == "R" ) {
                document.form.rpt_inpuirylevel.value="RCC";
            } else if ( check == "L" ) {
                document.form.rpt_inpuirylevel.value="LCC";
            } else if ( check == "E" ) {
                document.form.rpt_inpuirylevel.value="ECC";
            } else if ( check == "S" ) {
                document.form.rpt_inpuirylevel.value="SCC";
            }
            if ( check2 == "A" ) {
                document.form.rpt_div.value="ALL";
            } else if ( check2 == "L" ) {
                document.form.rpt_div.value="Loading";
            } else if ( check2 == "D" ) {
                document.form.rpt_div.value="Discharging";
            }
            document.form.rpt_tpsz    .value=document.getElementById('tpsz').options[document.getElementById('tpsz').options.selectedIndex].text;
            document.form.rpt_tpszlist.value=document.form.tpszlist.value;
        }
    }
    function obj_change(){
        obj=ComGetEvent();
        if(obj.name == "tpsz"){
            if (obj.value == "A") {
                document.form.tpszlist.value="";
            } else if (obj.value == "D") {
                document.form.tpszlist.value="D2, D4, D5, D7";
            } else if (obj.value == "S") {
                document.form.tpszlist.value="O2, S2, O4, S4, F2, A2, F4, A4, F5";
            } else if (obj.value == "R") {
                document.form.tpszlist.value="R2, R5";
            }
            
            
            var titleTpSz=document.form.tpszlist.value;
            var titleLine="D2|D4|D5|D7|R2|R5|O2|S2|O4|S4|F2|A2|F4|A4|F5";
            titleLineArray = titleLine.split("|");
            var k = 0;
            sheetObjects[0] = sheet1;
            sheetObjects[0] = sheetObjects[0].Reset();
            initSheet(sheetObjects[0],1);
            
            if(titleTpSz != "") {
            	for(var j=0;j<titleLineArray.length;j++) {
            		k = j + 5;
            		sheetObjects[0].SetColWidth(k, "60");
	     		    if(titleTpSz.indexOf(titleLineArray[j]) > -1) {
	     			   sheetObjects[0].SetColHidden(k,0);
	     		    }else{
	     			   sheetObjects[0].SetColHidden(k,1);
	     		    }
            	}
            }else{
            	for(var j=0;j<titleLineArray.length;j++) {
            		k = j + 5;
            		sheetObjects[0].SetColWidth(k, "60");
 	    			sheetObjects[0].SetColHidden(k,0);
            	}
 	    	}
        }
        
    }
    function obj_blur() {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }
    
    function resizeSheet(){
	    ComResizeSheet(sheetObjects[0]);
	}
