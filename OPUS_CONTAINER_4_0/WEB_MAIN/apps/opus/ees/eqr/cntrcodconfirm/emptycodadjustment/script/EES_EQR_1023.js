/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_EQR_1023.js
*@FileTitle : Match-back by Vessel
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/****************************************************************************************
  이벤트 구분 코드: [초기화]INIT=0; [입력]ADD=1; [조회]SEARCH=2; [리스트조회]SEARCHLIST=3;
                    [수정]MODIFY=4; [삭제]REMOVE=5; [리스트삭제]REMOVELIST=6 [다중처리]MULTI=7
                    기타 여분의 문자상수  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------다음 코드는 JSDoc을 잘 만들기 위해서 추가된 코드임 ------------------*/

// 공통전역변수
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var enterSwitch=false;
// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의 */
document.onclick=processButtonClick;
// 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러 */
    function processButtonClick(){
        /***** 탭당 시트가 2개 이상인 경우엔 추가 시트변수 지정하여 사용한 *****/
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                	obj_click();
                    doActionIBSheet(sheetObject, formObject, IBSEARCH);
                    sheetObjects[0].SetSelectRow(0);
                break;
                case "btn_new":
                    sheetObjects[0].RemoveAll();
                    formObject.reset();
                    document.getElementById("fromdate").focus();
                break;
                case "btn_downExcel":
                	if(sheetObject.RowCount() < 1){
            			ComShowCodeMessage("COM132501");
            		}else{
            			sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
            		}                     
                break;
                case "btn_print":
                    if( sheetObject.rowcount==0 ) {
                       // errMsg = 'No data found.';
                        ComShowCodeMessage("EQR90224");
                        return;
                    }
                    formObject.f_cmd.value=IBSEARCH_ASYNC02;
                    ComOpenPopupWithTarget('/opuscntr/EES_EQR_1064.do', 775, 750, "", "0,1,1,1,1,1,1", true);
                break;
                case "btns_calendarfm":
                    var cal=new ComCalendarFromTo();
                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
                break;
                case "btns_calendarto":
                    var cal=new ComCalendarFromTo();
                    cal.setEndFunction("nextFocusOut");
                    cal.select(formObject.fromdate, formObject.enddate, 'yyyy-MM-dd');
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
    function nextFocusOut(){
        document.form.location.focus();
    }     
    /**
     * IBSheet Object를 배열로 등록
     * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
     * 배열은 소스 상단에 정의
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    function initControl(){
        //axon_event.addListener      ( 'blur'     , 'obj_blur'       , 'location'    );
      //  axon_event.addListener      ( 'click'    , 'obj_click'      , 'div'    		);
        //axon_event.addListenerFormat( 'keypress' , 'obj_keypress'   , document.form );
        axon_event.addListenerForm  ( 'change'   , 'obj_change'     , document.form );
        //axon_event.addListenerFormat( 'focus'    , 'obj_activate'   , document.form ); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
        axon_event.addListenerForm  ( 'blur'     , 'obj_deactivate' , document.form ); //- form OnBeforeDeactivate이벤트에 코드 처리
        //axon_event.addListenerFormat( 'keyup'    , 'form_keyup'     , document.form );
        axon_event.addListener      ( 'keydown'  , 'ComKeyEnter'    , 'form'        );
        document.form.fromdate.focus();
    }    
    function obj_click(){
        var check="";        
        for(var i=0 ; i < document.form.div.length; i++){
            if(document.form.div[i].checked){
            	check=document.form.div[i].value;
            }
        }        
        //sheetObjects[0].Reset();
    	initSheet(sheetObjects[0],1,check);  
    }
    /**
     * Sheet 기본 설정 및 초기화
     * body 태그의 onLoad 이벤트핸들러 구현
     * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1,"D");
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
    }
    /**
     * Setting sheet default value 
    */
    function initSheet(sheetObj,sheetNo,option) {
        var cnt=0;
        var sheetID=sheetObj.id;
        switch(sheetID) {        
            case "sheet1":
                with(sheetObj){
                
              //if(option == "A"){            	  
              //}
              //else{
              //}
              var HeadTitle="Port|VVD|ETB|DIV|Total|D2|D4|D5|D7|R2|R5|R9|O2|S2|O4|S4|O5|F2|A2|F4|A4|F5";
              var headCount=ComCountHeadTitle(HeadTitle);
              var rowCnt=0;
              var sumLine="|d2| + |d4| + |d5| + |d7| + |r2| + |r5| + |r9| + |o2| + |s2| + |o4| + |s4| + |o5| + |f2| + |a2| + |f4| + |a4| + |f5|";
              cnt=0;
              rowCnt=0;

              SetConfig( { SearchMode:2, MergeSheet:1, Page:20, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
              var headers = [ { Text:HeadTitle, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",   KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",    KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etb",    KeyField:0,   CalcLogic:"",   Format:"Ymd" },
                     {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"div",    KeyField:0,   CalcLogic:"",   Format:"" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",  KeyField:0,   CalcLogic:sumLine,Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d7",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r9",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" } ];
                    if(option == "A"){
		              cnt = 0;
		              rowCnt++;
		              cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"port",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		              cols.push({Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
		              cols.push({Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"etb",    KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:1 });
		              cols.push({Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"div",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total",  KeyField:0,   CalcLogic:sumLine,Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"d7",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"r9",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"s4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"o5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a2",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"a4",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		              cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"f5",     KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:-1,  UpdateEdit:0,   InsertEdit:0 });
		           }
         
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
              SetSheetHeight(410);
                    }
            break;
        }
    }
    // Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:              	
                if(validateForm(sheetObj,formObj,sAction)){
                    if (sheetObj.id == "sheet1")
                		sheetObj.SetWaitImageVisible(0);
            			ComOpenWait(true);
                        formObj.f_cmd.value=SEARCH;
                        sheetObj.DoSearch("EES_EQR_1023GS.do",FormQueryString(formObj) );
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
                    var sXml=sheetObj.GetSearchData( "EES_EQR_1023GS.do" , FormQueryString(formObj) );
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
    function form_keyup() {
        var obj=null;
        var keyValue=event.keyCode ? event.keyCode : event.which ? event.which
                : event.charCode;
        if (keyValue != 13) {
            ComKeyEnter('lengthnextfocus');
        } else {
            if (obj_deactivate()) {
              //  doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
        }
    }
    function obj_keypress(){
        switch(event.srcElement.name){
            case "location":
                ComKeyOnlyAlphabet('upper');
            break;
            case "fromdate":
                ComKeyOnlyNumber(event.srcElement);
            break;
            case "enddate":
                ComKeyOnlyNumber(event.srcElement);
            break;
        }   
    }
    //Axon 
    function obj_deactivate() {
        var f=document.getElementById("fromdate");
        var t=document.getElementById("enddate");
        sVal1=f.value.replace(/\/|\-|\./g, "");
        sVal2=t.value.replace(/\/|\-|\./g, "");
        switch (event.srcElement.name) {
            case "fromdate":    
                if (ComChkObjValid(event.srcElement, false)) {
                    if (f.getAttribute("dataformat") == "ymd") {
                        if (sVal1 != "" && sVal2 != "") {
                            var flag=ComChkPeriod(sVal1, sVal2);
                            if (flag < 1) {
                                if(event.srcElement.name == "enddate"){
                                    event.srcElement.value="";
                                    ComShowCodeMessage("EQR90223");
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                                else{
                                    t.value="";
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            else{
                                if(chkToDateWeekBlur() == false){
                                    event.srcElement.value="";
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            enterSwitch=true;
                        }
                    }
                } else {
                    if (f.getAttribute("dataformat") == "ymd") {
                        if (sVal1.length > 0 && !ComIsDate(sVal1)  && event.srcElement.name == 'fromdate') {
                            enterSwitch=false;
                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
                            event.srcElement.value="";
                            event.srcElement.focus();
                            event.srcElement.select();
                            return false;
                        }
                    }
                }
                break;
            case "enddate":  
                if (ComChkObjValid(event.srcElement, false)) {
                    if (t.getAttribute("dataformat") == "ymd") {
                        if (sVal1 != "" && sVal2 != "") {
                            var flag=ComChkPeriod(sVal1, sVal2);
                            if (flag < 1) {
                                if(event.srcElement.name == "enddate"){
                                    event.srcElement.value="";
                                    ComShowCodeMessage("EQR90223");
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                                else{
                                    t.value="";
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            else{
                                if(chkToDateWeekBlur() == false){
                                    event.srcElement.value="";
                                    ComShowCodeMessage("EQR90221");
                                    enterSwitch=false;
                                    t.focus();
                                    t.select();
                                    return false;
                                }
                            }
                            enterSwitch=true;
                        }
                    }
                } else {
                    if (t.getAttribute("dataformat") == "ymd") {
                        if (sVal2.length > 0 && !ComIsDate(sVal2)  && event.srcElement.name == 'enddate') {
                            enterSwitch=false;
                            document.getElementById("enddate").value="";
                            ComShowCodeMessage("EQR90222", "YYYYMMDD");
                            t.focus();
                            t.select();
                            return false;
                        }
                    }
                }
                break;
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
    function chkToDateWeekBlur(){
        var period=document.form.period.value;
        var toDate=document.form.enddate.value;
        var frDate=document.form.fromdate.value;
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
            if(retMonth>=12 ){
                if(event.srcElement.name == "enddate"){
                	//ComShowCodeMessage("EQR90221");
                    return false;
                }
            }
        }else if(period == "W"){
            if ( frYearDate == toYearDate ) {
                week=eval(toMonthDate) - eval(frMonthDate) + 1;
            } else {
                betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
                if ( (eval(toYearDate) - eval(frYearDate) ) == 1 ) {     //1년 차이일때
                    week=betwMonth;
                } else {
                    week=(eval(toYearDate) - eval(frYearDate) -1 ) * fromTo + betwMonth;
                }
            }
            if(week>12){
                ComShowCodeMessage("EQR90221");
                document.getElementById("fromdate").value="";
                document.getElementById("enddate").value="";
                ComSetFocus(document.getElementById("fromdate"));
                return;
            }
        }
        return true;
    }
    function obj_activate() {
        ComClearSeparator(event.srcElement);
        ComSetFocus(event.srcElement);
    }    
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
                if (fromdate.value.length < 8) {
                    return false;
                } else if (enddate.value.length < 8) {
                    return false;
                }
                if(!enterSwitch){
                    return false;
                }
             }
         } // end of with
         return true;
    }
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        with(sheetObj) {
            var check2="";
            for(var i=0 ; i < document.form.div.length ; i++){
                if(document.form.div[i].checked){
                    check2=document.form.div[i].value;
                }
            }
            for ( var i=4; i < 22 ; i++) {
                if( RowCount()> 0 ){
                	if ( ComIsNull( GetCellValue(RowCount()-1, i) ) || ComIsNull( GetCellValue(RowCount(), i) ) ) {
                    	if(check2 == "L" || check2 == "D"){
                     		SetSumText(0,i,"");
                    	}
                    	else{
                     		SetSumText(1,i,"");
                     		SetSumText(0,i,"");
                    	}
                    }else{
                    	if(check2 == "L"){
                    		SetSumValue(0,i,GetCellValue(RowCount()-1,i));
                    	}
                    	else if(check2 == "D"){
                    		SetSumValue(0,i,GetCellValue(RowCount(),i));
                    	}
                    	else{
                    		SetSumValue(0,i,GetCellValue(RowCount()-1,i));
                    		SetSumValue(1,i,GetCellValue(RowCount(),i));
                    	}
                    }
                }
            }            
            if (RowCount()> 0) {
            	SetRowHidden(RowCount()-1,1);
            	SetRowHidden(RowCount(),1);
            }
            if(check2 == "L"){
                 SetSumText(0, 0,"Grand Total");
                 SetSumText(0, 1,"Grand Total");
                 SetSumText(0, 2,"Grand Total");
             	 SetSumText(0, "div","Load");
                 SetCellAlign(0, 0,"Center");
                 SetCellAlign( LastRow(), "div" ,"Center   ");
                 SetMergeCell( LastRow(), 0 , 1, 3 );
            }
            else if(check2 == "D"){
                 SetSumText(0, 0,"Grand Total");
                 SetSumText(0, 1,"Grand Total");
                 SetSumText(0, 2,"Grand Total");
             	 SetSumText(0, "div","Disc");
                 SetCellAlign(0, 0,"Center");
                 SetCellAlign( LastRow(), "div" ,"Center   ");
                 SetMergeCell( LastRow(), 0 , 1, 3 );
            }
            else{
                if(LastRow()> 1){
                 	SetSumText(0, 0,"");
                 	SetSumText(0, 1,"Grand Total");
                    SetSumText(0, "div","Load");
                    SetSumText(1, "div","Disc");
                    SetCellAlign( LastRow()- 1 , "div" ,"Center   ");
                    SetCellAlign( LastRow(), "div" ,"Center   ");
	       			SetCellAlign( LastRow()- 1 , "port"  ,"Center");
	       			SetCellAlign( LastRow()- 1 , "vvd"  ,"Center");
	       			SetCellAlign( LastRow(), "vvd"  ,"Center");
	            //    SetMergeCell(  LastRow-1 , 0 , 2, 3 );
                }
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
            document.form.rpt_tpsz.value=document.getElementById('tpsz').options[document.getElementById('tpsz').options.selectedIndex].text;
            document.form.rpt_tpszlist.value=document.form.tpszlist.value;
        }
    }
    function obj_change(){
        obj=event.srcElement;
        if(obj.name == "tpsz"){
            if (obj.value == "A") {
                document.form.tpszlist.value="";
            } else if (obj.value == "D") {
                document.form.tpszlist.value="D2, D4, D5, D7";
            } else if (obj.value == "S") {
                document.form.tpszlist.value="O2, S2, O4, S4, O5, F2, A2, F4, A4, F5";
            } else if (obj.value == "R") {
                document.form.tpszlist.value="R2, R5, R9";
            }
        }
    }
    function obj_blur() {
        doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
    }
