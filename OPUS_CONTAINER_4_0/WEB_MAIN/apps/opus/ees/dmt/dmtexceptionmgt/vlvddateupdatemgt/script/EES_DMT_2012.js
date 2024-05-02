/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_DMT_2012.js
*@FileTitle  : VL/VD Date Update by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
/****************************************************************************************
   Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
                  OTHER CASE : COMMAND01=11; ~ COMMAND20=30;	
 ***************************************************************************************/

// Common Global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var set_day=30;
var DEF_SHEET_HEIGHT = 467;

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
                case "btn_retrieve":
                    doActionIBSheet(sheetObject1,formObject,IBSEARCH);
                break;
                case "btn_new":
                    var formObject=document.form;
                    formObject.reset();
                    formObject.mvmt.focus();
                    document.getElementById("vvdc").className="input2";
                    document.getElementById("frdt").className="input1";
                    document.getElementById("todt").className="input1";                    
//                    var data = getDefaultDate(set_day).split("|");
//                    formObject.frdt.value = data[1];
//                    formObject.todt.value = data[0];
					//Period Date initializing
					//Retrieves the current date of User Office
					var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject);
					var fmMvmtDt=ComGetDateAdd(formObject.ofcCurrDate, "D", -30);
					var toMvmtDt=ofcCurrDate;
					ComSetObjValue(formObject.frdt, fmMvmtDt);
					ComSetObjValue(formObject.todt, toMvmtDt); 
                    sheetObject1.RemoveAll();
                    //initSheet(sheetObject1,0);
                break;
                case "btn_save":
                    doActionIBSheet(sheetObjects[0],formObject,IBSAVE);
//                    doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
                break;
                case "btns_calendarfm":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
                break;
                case "btns_calendarto":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.frdt, formObject.todt, 'yyyy-MM-dd');
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
        initControl();
        var formObject=document.form; 
//        var data = getDefaultDate(set_day).split("|");
//        formObject.frdt.value = data[1];
//        formObject.todt.value = data[0];        
		//Period Date initializing
		//Retrieves the current date of User Office
		var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], formObject);
//		var fmMvmtDt=ComGetDateAdd(formObject.ofcCurrDate, "D", -30);
//		var toMvmtDt=ofcCurrDate;

		var fmMvmtDt=ofcCurrDate;
		var toMvmtDt=ComGetDateAdd(formObject.ofcCurrDate, "D", +6);
		
		ComSetObjValue(formObject.frdt, fmMvmtDt);
		ComSetObjValue(formObject.todt, toMvmtDt); 	     
     }
    function initControl() {
        //axon_event.addListenerForm  ( 'blur'     , 'obj_blur'      , document.form ); //- out of focus
        axon_event.addListenerForm  ( 'change'   , 'obj_change'    , document.form );
        //axon_event.addListenerFormat( 'focus'    , 'obj_focus'     , document.form ); // Get focus
        //axon_event.addListenerFormat( 'keypress' , 'obj_keypress'  , document.form ); //- on press keyboard
        //axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'   , 'form'        );
        //axon_event.addListener      ( 'click'    , 'dayVvdR_click' , 'dayVvdR'     );
        //axon_event.addListenerFormat( 'keyup'    , 'form_keyup'    , form          );
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
	              //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	              var xVal=document.form.mvmt.value;
	              var HeadTitle1="";
	              var HeadTitle2="";
	              if ( "VL" == xVal) {
		              HeadTitle1="||Seq.|Lane|VVD CD|ETA|ETD|First VL MVMT|Last VL MVMT|VL Date in Charge|VL Date in Charge|Update|Update|Update|";
		              HeadTitle2="||Seq.|Lane|VVD CD|ETA|ETD|First VL MVMT|Last VL MVMT|Now|To Be|Date|Office|Name|";
	              } else {
		              HeadTitle1="||Seq.|Lane|VVD CD|ETA|ETD|First VD MVMT|Last VD MVMT|F/Time Commence Date|F/Time Commence Date|Update|Update|Update|";
		              HeadTitle2="||Seq.|Lane|VVD CD|ETA|ETD|First VD MVMT|Last VD MVMT|Now|To Be|Date|Office|Name|";
	              }
	              var headCount=ComCountHeadTitle(HeadTitle1);
	
	              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	              var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
	              
	              InitHeaders(headers, info);
	
	              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	                     {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"status" },
	                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lane",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"eta",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"etd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"firstvl",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:105,  Align:"Center",  ColMerge:1,   SaveName:"lastvl",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vldaten",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Date",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"vldateb",  KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:-1,  UpdateEdit:1,   InsertEdit:1 },
	                     {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"updated",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"updateo",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"updaten",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"updatei",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 } ];
	               
	              InitColumns(cols);
	
	              SetEditable(1);
	              SetCountPosition(0);
                  SetWaitTimeOut(600);
                  SetSheetHeight(DEF_SHEET_HEIGHT);
              }
            break;
        }
    }
    // Process of Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     // Search
                if ( validateForm(sheetObj,formObj,sAction) ) {
                    formObj.f_cmd.value=SEARCH;
                    //sheetObj.RemoveAll();
//                    initSheet(sheetObj, 0);
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    sheetObj.DoSearch("EES_DMT_2012GS.do", FormQueryString(formObj));
                    ComOpenWait(false);
                    DmtComEnableManyBtns( true , "btn_retrieve" );
                }
            break;
            case IBSAVE:        // save
                //if(validateForm(sheetObj,formObj,sAction))
                // check over 10 days
                for( var i=1 ; i < sheetObjects[0].RowCount()+2 ; i++ ){
                	if ( sheetObjects[0].GetCellValue(i,"vldateb") != "" ) {
                		var xDayTerm=ComGetDaysBetween( sheetObjects[0].GetCellValue(i,"eta") , sheetObjects[0].GetCellValue(i,"vldateb") );
                        if ( xDayTerm < -10 || xDayTerm > 10 ) {
                        	ComShowCodeMessage('DMT01079', sheetObjects[0].GetCellValue(i,"vvd"));
                            sheetObjects[0].SelectCell( i , "vldateb" , true , "" );
                            return false;
                        }
                    }
                }            
                formObj.f_cmd.value=MULTI;                
                var sParam1=sheetObjects[0].GetSaveString(true);
                sParam=sParam1 + "&" + FormQueryString(formObj);
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                var sXml=sheetObj.GetSaveData("EES_DMT_2012GS.do", sParam);
                ComOpenWait(false);
                sheetObjects[0].LoadSaveData(sXml);
                ComOpenWait(true);
                sheetObj.SetWaitImageVisible(0);
                doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
                ComOpenWait(false);
            break;
        }
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
            if (port.value == "") {
                ComShowCodeMessage('DMT00102', "Port code");
                port.focus();
                return false;
            }
            if(port.value.length < 5) {
	 			ComShowCodeMessage('DMT00110', 'Location');
	 			port.value="";
	            loc_cd.value="";
	            port.focus();
	            return false;
        	}
            if ( formObj.dayVvdR[0].checked ) {
                if ( formObj.frdt.value == "" ) {
                    ComShowCodeMessage('DMT00102', "From date");
                    formObj.frdt.focus();
                    return false;
                }
                if ( formObj.todt.value == "" ) {
                    ComShowCodeMessage('DMT00102', "To date");
                    formObj.todt.focus();
                    return false;
                }
                if( document.form.todt.value.length==10 ){
                    var xDayTerm=ComGetDaysBetween ( document.form.frdt.value , document.form.todt.value );
                    if( xDayTerm < 0 || xDayTerm > 30 ){
                        ComShowCodeMessage("DMT00162","1 month ");
                        ComSetFocus(document.form.frdt);
                        return false;
                    }
                }
                ComChkObjValid(obj);
            }
            if ( formObj.dayVvdR[1].checked ) {
                if ( formObj.vvdc.value == "" ) {
                    ComShowCodeMessage('DMT00102', "VVD code");
                    formObj.vvdc.focus();
                    return false;
                }
            }
        }
        return true;
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
                ComKeyOnlyNumber(event.srcElement);
                break;
            default:
                // only numbers(integer, date, time)
                ComKeyOnlyNumber(event.srcElement);
         }
     }
    // VL, VD change:  GRID HEADER TEXT change
    function obj_change() {
        obj=ComGetEvent();
        if (obj.name == "mvmt") {
            if (obj.value == "VL") {
                document.form.type.value="DMOF, CTOC";
            } else {
                document.form.type.value="DMIF, CTIC";
            }
            sheetObjects[0] = sheetObjects[0].Reset();
            initSheet( sheetObjects[0] , 0 );
        }
    }
    function sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
    }    
    function obj_keyup() {
        var srcObj=ComGetEvent();
        var tRHQ=document.form.h_rhq_off.value;
//        if ( tRHQ == "SELHO" ) {
//            checkLocYdCd(srcObj);
//        } else {
//            checkLocYdCd2(srcObj,tRHQ);
//        }
        checkLocYdCd(srcObj);
    }
    function checkLocYdCd(srcObj) {
        var formObj=document.form;
        var cd=ComTrim(ComGetObjValue(srcObj));
        if (cd.length == 5) {
            doActionIBCombo(sheetObjects[0], formObj, COMMAND07, srcObj);
            /*
            if ( document.form.dayVvdR[0].checked ) {
                ComSetFocus(formObj.frdt);
            } else {
                ComSetFocus(formObj.vvdc);
            }*/  
        }
    }
    function checkLocYdCd2(srcObj,tRHQ) {
        var formObj=document.form;
        var cd=ComTrim(ComGetObjValue(srcObj));
        if (cd.length == 5) {
            //doActionIBCombo2(sheetObjects[0], formObj, COMMAND16, srcObj,tRHQ);
            doActionIBCombo2(sheetObjects[0], formObj, COMMAND07, srcObj,tRHQ);
            if ( document.form.dayVvdR[0].checked ) {
                ComSetFocus(formObj.frdt);
            } else {
                ComSetFocus(formObj.vvdc);
            }
        }
    }
    function doActionIBCombo(sheetObj, formObj, formCmd, srcObj) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        formObj.f_cmd.value=formCmd;
        formObj.loc_cd.value=formObj.port.value;
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var comboDatas;
        comboDatas=ComGetEtcData(sXml, "LOC_CD");
        if (comboDatas != undefined && comboDatas != '') {
        	var usrRhqOfcCd=ComGetObjValue(form.h_rhq_off);
        } else {	
            ComShowCodeMessage('DMT00110', "Location");
            formObj.port.value="";
            formObj.loc_cd.value="";
            srcObj.focus();
        }
        sheetObj.SetWaitImageVisible(1);
    }
    function doActionIBCombo2(sheetObj, formObj, formCmd, srcObj,tRHQ) {
        sheetObj.ShowDebugMsg(false);
        sheetObj.SetWaitImageVisible(0);
        formObj.f_cmd.value=formCmd;
        formObj.loc_cd.value=formObj.port.value;
        var sXml=sheetObj.GetSearchData("DMTCommonFinderGS.do", FormQueryString(formObj));
        var comboDatas;
        comboDatas=ComGetEtcData(sXml, "LOC_CD");
        if ( tRHQ != comboDatas ) {
            ComShowCodeMessage('DMT01129');
            formObj.port.value="";
            formObj.loc_cd.value="";
            formObj.port.focus();
        } else {
            checkLocYdCd(srcObj);
        }
        sheetObj.SetWaitImageVisible(1);
    }
    function obj_blur(){
        //check inputing Validation + Inserting separator 
        var obj=ComGetEvent();
        var formObj=document.form;
        if ( ( obj.name == 'frdt' || obj.name == 'todt' ) && formObj.frdt.value != "" && formObj.todt.value != "" ) {
            ComChkObjValid(obj);
        }
    }
    
    function dayVvdR_click(){   
        if (document.form.dayVvdR[0].checked) { 
            document.getElementById("vvdc").className="input2";
            document.getElementById("frdt").className="input1";
            document.getElementById("todt").className="input1";
            document.form.vvdc.value="";
            document.form.vvdc.readOnly=true;
            document.form.frdt.readOnly=false;
            document.form.todt.readOnly=false;
//            var data = getDefaultDate(set_day).split("|");
//            document.form.frdt.value = data[1];
//            document.form.todt.value = data[0];
            //Period Date initializing
			//Retrieves the current date of User Office
			var ofcCurrDate=DmtComOfficeCurrDate(sheetObjects[0], document.form);
			var fmMvmtDt=ComGetDateAdd(document.form.ofcCurrDate, "D", -30);
			var toMvmtDt=ofcCurrDate;
			ComSetObjValue(document.form.frdt, fmMvmtDt);
			ComSetObjValue(document.form.todt, toMvmtDt); 	
        } else {
            document.getElementById("vvdc").className="input1";
            document.getElementById("frdt").className="input2";
            document.getElementById("todt").className="input2";
            document.form.vvdc.readOnly=false;
            document.form.frdt.readOnly=true;
            document.form.todt.readOnly=true;
            document.form.frdt.value="";
            document.form.todt.value="";
        }
    }
    function obj_focus() {
        ComClearSeparator(ComGetEvent());
        ComSetFocus(event.srcElement);
    }
    function chkToDateWeekBlur(){
        var period="M";
        var toDate=document.form.todt.value;
        var frDate=document.form.frdt.value;
        var toYearDate=toDate.substring(0,4);
        var frYearDate=frDate.substring(0,4);
        var toMonthDate=toDate.substring(5,7);
        var frMonthDate=frDate.substring(5,7);
        var frDayDate="";
        var toDayDate="";
        if(frDate.length > 7){
            frDayDate=frDate.substring(8,10);
            toDayDate=toDate.substring(8,10);
        }
        else{
            frDayDate="01";
            toDayDate=lastDay(toYearDate, toMonthDate);
        }
        var frDateFull=new Date(frYearDate, frMonthDate-1, frDayDate);
        var toDateFull=new Date(toYearDate, toMonthDate-1, toDayDate);
        var getDiffTime=toDateFull.getTime() - frDateFull.getTime();
        var retDate=Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
        var retMonth=((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate,10) - parseInt(frMonthDate,10));
        var retWeek=Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
        var week="";
        var fromTo=52;
        if(period == "M"){
            if(retMonth>=6 ){
                if(event.srcElement.name == "todt"){
                    return false;
                }
            }
        }else if(period == "W"){
            if ( frYearDate == toYearDate ) {
                week=eval(toMonthDate) - eval(frMonthDate) + 1;
            } else {
                betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
                if ( (eval(toYearDate) - eval(frYearDate) ) == 1 ) {     //1year
                    week=betwMonth;
                } else {
                    week=(eval(toYearDate) - eval(frYearDate) -1 ) * fromTo + betwMonth;
                }
            }
            if(week>12){
                ComShowCodeMessage("DMT01100");
                document.getElementById("frdt").value="";
                document.getElementById("todt").value="";
                ComSetFocus(document.getElementById("frdt"));
                return;
            }
        }
        return true;
    }
    function lastDay(y, m) {
        var d, d2, s="";
        d=new Date();
        d2=new Date(y, m, "");
        s=d2.getDate();
        return (s);
    }
function form_keyup() {
    var obj=null;
    var keyValue=event.keyCode ? event.keyCode : event.which ? event.which
            : event.charCode;
    if (keyValue != 13) {
        //ComKeyEnter('lengthnextfocus');
    } else {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
    }
}
/*
    function keyPress() {
        var eventKey=window.event.keyCode ;
            if( eventKey == 13 ) {
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    document.onkeypress=keyPress ;
    */
    function sheet1_OnKeyUp(SheetObj, Row, Col, KeyCode, Shift){
        if(KeyCode == 13){
            var formObject=document.form;                 
            if (SheetObj.RowCount()> 0){
                doActionIBSheet(SheetObj,formObject,IBSEARCH);
            }               
        }
    }    
