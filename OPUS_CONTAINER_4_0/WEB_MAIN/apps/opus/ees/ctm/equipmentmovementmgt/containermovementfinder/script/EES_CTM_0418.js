/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_CTM_0418.js
*@FileTitle : MVMT Timely Update Ratio
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/26
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// common global variables
var comboObjects=new Array();
var comboCnt=0;
var sheetObjects=new Array();
var sheetCnt=0;
var sRows=-1;
// Event handler processing by button click event  */
document.onclick=processButtonClick;
     // Event handler processing by button name */
     function processButtonClick() {
        var sheetObject=sheetObjects[0];
        /*******************************************************/
        var frmObj=document.form;
        try {
            var srcName=ComGetEvent("name");
            switch(srcName) {
                case "btn_Retrieve":
                if (checkFormField())
                doActionIBSheet(sheetObject, frmObj, IBSEARCH);
                break;
                case "btn_New":
                DomSetFormObjDisable(frmObj, false);
                rcc_cd.SetEnable(1);
                lcc_cd.SetEnable(1);
                p_yard2.SetEnable(1);
                ComResetAll();
                p_yard2.RemoveAll();
                // RCC_CD 기본셋팅
                doActionIBSheet(sheetObject, frmObj, SEARCH01);
                break;
                case "btn_Calendar":
            		var evtObj = ComGetEvent();
	                if (!evtObj.disabled) {
	                    var cal=new ComCalendarFromTo();
	                    cal.select(frmObj.p_date1, frmObj.p_date2, 'yyyy-MM-dd');
	                }
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
            ComConfigSheet(sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        // initializing IBMultiCombo
        for(var k=0;k<comboObjects.length;k++){
            initCombo(comboObjects[k], comboObjects[k].options.id);
        }
        setEventProcess("rcc_cd", "lcc_cd", "gap", "p_yard1");
        //axon_event.addListener("click", "gap_Change", "gap");
        //axon_event.addListener("keypress", "obj_keypress", "p_yard1");
        doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
        axon_event.addListener("keyup", "yard_Change", "p_yard1");
    }
    function yard_Change (event) {
        eventElement=event.srcElement;
        //alert (obj_keyup(event))
        ctl_radio();
        //document.form.p_yard2.RemoveAll();
        p_yard2.RemoveAll();
        if (eventElement.value.length < 5) return;
        if (srcValue == eventElement.value) return;
        //document.form.p_yard2.RemoveAll();
        p_yard2.RemoveAll();
        onShowErrMsg=false;
        rtn=yard_search();
        /*
        if (rtn == true && svrChk != 'S') {
            ComShowCodeMessage("CTM20072");
            //alert ("사용자와 야드의 Server 정보 불 일치");
            eventElement.value='';
            eventElement.select();
            return;
        }
        */
        //alert (srcValue + ":" +  eventElement.value + "::::" + rtn)
        document.form.data_by[3].checked=true;
        if (rtn == true) {
            // moving cursor
            if (curKeyCode == '9') {
                // clicked Tab. initializing and stopping
                curKeyCode="";
                srcValue=event.srcElement.value;
            } else {
                objTmp=setFocusIndex (eventElement, 1)
                try {
                    objTmp.focus();
                } catch (e) {}
                curKeyCode="";
                srcValue=event.srcElement.value;
                return;
            }
        } else if (rtn == false) {
            eventElement.focus();
            eventElement.select();
        }
    }
    /**
     * cleaning screen by modifying GAP
     * param : combo_obj
     */
    function gap_Change() {    	
        gap=document.form.gap;
        obj=sheetObjects[0];
        if (gap[1].checked == true) {
            obj.SetColHidden("off_12",0);
            obj.SetColHidden("per_12",0);
            obj.SetColHidden("moff_12",0);
            obj.SetColHidden("mper_12",0);
            obj.SetColHidden("soff_12",0);
            obj.SetColHidden("sper_12",0);
            obj.SetColHidden("eoff_12",0);
            obj.SetColHidden("eper_12",0);
            obj.SetColHidden("off_24",1);
            obj.SetColHidden("per_24",1);
            obj.SetColHidden("moff_24",1);
            obj.SetColHidden("mper_24",1);
            obj.SetColHidden("soff_24",1);
            obj.SetColHidden("sper_24",1);
            obj.SetColHidden("eoff_24",1);
            obj.SetColHidden("eper_24",1);
            obj.SetColHidden("off_48",1);
            obj.SetColHidden("per_48",1);
            obj.SetColHidden("moff_48",1);
            obj.SetColHidden("mper_48",1);
            obj.SetColHidden("soff_48",1);
            obj.SetColHidden("sper_48",1);
            obj.SetColHidden("eoff_48",1);
            obj.SetColHidden("eper_48",1);
        } else if (gap[2].checked == true) {
            obj.SetColHidden("off_12",1);
            obj.SetColHidden("per_12",1);
            obj.SetColHidden("moff_12",1);
            obj.SetColHidden("mper_12",1);
            obj.SetColHidden("soff_12",1);
            obj.SetColHidden("sper_12",1);
            obj.SetColHidden("eoff_12",1);
            obj.SetColHidden("eper_12",1);
            obj.SetColHidden("off_24",0);
            obj.SetColHidden("per_24",0);
            obj.SetColHidden("moff_24",0);
            obj.SetColHidden("mper_24",0);
            obj.SetColHidden("soff_24",0);
            obj.SetColHidden("sper_24",0);
            obj.SetColHidden("eoff_24",0);
            obj.SetColHidden("eper_24",0);
            obj.SetColHidden("off_48",1);
            obj.SetColHidden("per_48",1);
            obj.SetColHidden("moff_48",1);
            obj.SetColHidden("mper_48",1);
            obj.SetColHidden("soff_48",1);
            obj.SetColHidden("sper_48",1);
            obj.SetColHidden("eoff_48",1);
            obj.SetColHidden("eper_48",1);
        } else if (gap[3].checked == true) {
            obj.SetColHidden("off_12",1);
            obj.SetColHidden("per_12",1);
            obj.SetColHidden("moff_12",1);
            obj.SetColHidden("mper_12",1);
            obj.SetColHidden("soff_12",1);
            obj.SetColHidden("sper_12",1);
            obj.SetColHidden("eoff_12",1);
            obj.SetColHidden("eper_12",1);
            obj.SetColHidden("off_24",1);
            obj.SetColHidden("per_24",1);
            obj.SetColHidden("moff_24",1);
            obj.SetColHidden("mper_24",1);
            obj.SetColHidden("soff_24",1);
            obj.SetColHidden("sper_24",1);
            obj.SetColHidden("eoff_24",1);
            obj.SetColHidden("eper_24",1);
            obj.SetColHidden("off_48",0);
            obj.SetColHidden("per_48",0);
            obj.SetColHidden("moff_48",0);
            obj.SetColHidden("mper_48",0);
            obj.SetColHidden("soff_48",0);
            obj.SetColHidden("sper_48",0);
            obj.SetColHidden("eoff_48",0);
            obj.SetColHidden("eper_48",0);
        } else {
            obj.SetColHidden("off_12",0);
            obj.SetColHidden("per_12",0);
            obj.SetColHidden("moff_12",0);
            obj.SetColHidden("mper_12",0);
            obj.SetColHidden("soff_12",0);
            obj.SetColHidden("sper_12",0);
            obj.SetColHidden("eoff_12",0);
            obj.SetColHidden("eper_12",0);
            obj.SetColHidden("off_24",0);
            obj.SetColHidden("per_24",0);
            obj.SetColHidden("moff_24",0);
            obj.SetColHidden("mper_24",0);
            obj.SetColHidden("soff_24",0);
            obj.SetColHidden("sper_24",0);
            obj.SetColHidden("eoff_24",0);
            obj.SetColHidden("eper_24",0);
            obj.SetColHidden("off_48",0);
            obj.SetColHidden("per_48",0);
            obj.SetColHidden("moff_48",0);
            obj.SetColHidden("mper_48",0);
            obj.SetColHidden("soff_48",0);
            obj.SetColHidden("sper_48",0);
            obj.SetColHidden("eoff_48",0);
            obj.SetColHidden("eper_48",0);
        }
        formObj=document.form;
        formObj.c12.value='';
        formObj.c24.value='';
        formObj.c48.value='';
        formObj.c72.value='';
        formObj.c_a.value='';
        formObj.p12.value='';
        formObj.p24.value='';
        formObj.p48.value='';
        formObj.p72.value='';
        obj.RemoveAll();
    }
    /**
     * handling OnKeyDown event of rcc_cd[combo0] Object
     */
    function rcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * Container No Object의 값 변경 처리
     * param : Row
     * param : Col
     * param : Value
     */
    function rcc_cd_OnChange(Row, Col, Value) {
        var rcc=rcc_cd.GetSelectText();
        doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
    }
    /**
     * Container No Object의 값 변경 처리
     * param : Row
     * param : Col
     * param : Value
     */
    function lcc_cd_OnChange(Row, Col, Value) {
        obj=document.form.data_by;
        //           obj[3].checked = true;
        ctl_radio();
    }
    /**
     * handling OnKeyDown event of lcc_cd[combo1] Object
     */
    function lcc_cd_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * Container No Object의 값 변경 처리
     * param : Row
     * param : Col
     * param : Value
     */
    function p_yard2_OnChange(Row, Col, Value) {
        ctl_radio();
    }
    /**
     * handling OnKeyDown event of p_yard2[combo2] Object
     */
    function p_yard2_OnKeyDown(comboObj, KeyCode, Shift) {
        if (KeyCode == 13) {
            doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
        }
    }
    /**
     * controlling radio button
     */
    function ctl_radio() {
        var obj=document.form;
        var pobj=document.form.data_by;
        var yd1=obj.p_yard1.value;
        var yd2=p_yard2.GetSelectText();
        var lcc=lcc_cd.GetSelectText();
        if (yd2 != '') {
            if (pobj[3].checked != true) {
                pobj[4].checked=true;
            }
            pobj[0].disabled=true;
            pobj[1].disabled=true;
            pobj[2].disabled=true;
            pobj[3].disabled=true;
        } else if (yd1 != '') {
            if (yd1.length == 5) {
                if (pobj[4].checked != true) {
                    pobj[3].checked=true;
                }
                pobj[2].disabled=true;
                pobj[3].disabled=false;
            } else {
                if (pobj[4].checked != true) {
                    pobj[3].checked=false;
                }
                pobj[2].disabled=false;
                pobj[3].disabled=false;
            }
            pobj[0].disabled=true;
            pobj[1].disabled=true;
        } else if (lcc != '') {
            pobj[0].disabled=true;
            pobj[1].disabled=true;
        } else if (lcc == '') {
            pobj[0].disabled=false;
            pobj[1].disabled=false;
        }
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
                
              var HeadTitle1="|Seq.|RCC|CN|LCC|LOC|Yard|ALL|ALL|ALL|ALL|ALL|ALL|ALL|ALL|ALL|";
              HeadTitle1 += "EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|EDI( Excluded Error )|";
              HeadTitle1 += "SPP|SPP|SPP|SPP|SPP|SPP|SPP|SPP|SPP|";
              HeadTitle1 += "Manual|Manual|Manual|Manual|Manual|Manual|Manual|Manual|Manual|Cond|Cond|Cond|Cond|";
              var HeadTitle2="|Seq.|RCC|CN|LCC|LOC|Yard|12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
              HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
              HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|";
              HeadTitle2 += "12 Hour|%|24 Hour|%|48 Hour|%|Over|%|Total|gap|p_date1|p_date2|data_by|";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, true);

              SetConfig( { SearchMode:2, FrozenCol:7, MergeSheet:5, Page:20, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"},
                          { Text:HeadTitle2, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"HidSta" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cnt_cd" },
                     {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"lcc_cd" },
                     {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd" },
                     {Type:"Text",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"org_yd_cd" },
                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"off_12",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"per_12",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"off_24",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"per_24",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"off_48",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"per_48",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"ovr_48",     KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"oper_48",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"AutoSum",   Hidden:0, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"tot",        KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eoff_12",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"eper_12",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eoff_24",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"eper_24",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eoff_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"eper_48",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"eovr_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"eoper_48",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"etot",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"soff_12",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"sper_12",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"soff_24",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"sper_24",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"soff_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"sper_48",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"sovr_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"soper_48",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"stot",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"moff_12",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"mper_12",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"moff_24",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"mper_24",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"moff_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"mper_48",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"movr_48",    KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Float",     Hidden:0,  Width:35,   Align:"Right",   ColMerge:0,   SaveName:"moper_48",   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1 },
                     {Type:"Int",       Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mtot",       KeyField:0,   CalcLogic:"",   Format:"NullInteger" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"gap" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"p_date1" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"p_date2" },
                     {Type:"Text",      Hidden:1, Width:70,   Align:"Right",   ColMerge:0,   SaveName:"data_by" } ];
               
              InitColumns(cols);

              SetEditable(0);
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetWaitTimeOut(6000);
              FrozenCols=7;
              SetColFontColor(7,"#0000FF");
              SetColFontColor(9,"#0000FF");
              SetColFontColor(11,"#0000FF");
              SetColFontColor(13,"#0000FF");
              SetColFontColor(15,"#0000FF");//all
              SetColFontColor(16,"#0000FF");
              SetColFontColor(18,"#0000FF");
              SetColFontColor(20,"#0000FF");
              SetColFontColor(22,"#0000FF");
              SetColFontColor(24,"#0000FF");//edi
              SetColFontColor(25,"#0000FF");
              SetColFontColor(27,"#0000FF");
              SetColFontColor(29,"#0000FF");
              SetColFontColor(31,"#0000FF");
              SetColFontColor(33,"#0000FF");//spp
              SetColFontColor(34,"#0000FF");
              SetColFontColor(36,"#0000FF");
              SetColFontColor(38,"#0000FF");
              SetColFontColor(40,"#0000FF");
              SetColFontColor(42,"#0000FF");//manual
//              SetSheetHeight(382);
              resizeSheet();
              }


                break;
            case "sheet2":
                with(sheetObj){
                
              var HeadTitle1="|Seq.|Container No.| Type/size| Status| I/O status| Method| Event Yard| Event date| receiving/creation date| GAP|";
              var headCount=ComCountHeadTitle(HeadTitle1);

              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);

              var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"HidSta" },
                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"SEQ" },
                     {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_sts_cd" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ob_cntr_flg" },
                     {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"mvmt_inp_tp_cd" },
                     {Type:"Text",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"org_yd_cd" },
                     {Type:"Text",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cnmv_evnt_dt" },
                     {Type:"Text",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"cre_locl_dt" },
                     {Type:"Text",     Hidden:0,  Width:100,  Align:"Right",   ColMerge:0,   SaveName:"offset_dt" } ];
               
              InitColumns(cols);

              SetEditable(1);
              SetCountPosition(0);
              SetWaitImageVisible(0);
              SetWaitTimeOut(6000);
              SetSheetHeight(80);
              }
                break;
        }
    }
    //handling process for Sheet
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
            case IBSEARCH:     
                if (validateForm(sheetObj,formObj,sAction)) {
                    var rcc=rcc_cd.GetSelectText();
                    if (rcc != 'ALL' && ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 3),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                        ComShowCodeMessage("CTM30012", "3 months");
                        return;
                    } else if (rcc == 'ALL' && ComGetUnMaskedValue(ComGetDateAdd(formObj.p_date1.value, "M", 1),'ymd') < ComGetUnMaskedValue(formObj.p_date2.value, 'ymd')) {
                        ComShowCodeMessage("CTM30012", "1 month");
                        return;
                    }
                    sheetObj.RemoveAll();
                    ComBtnDisable("btn_Retrieve");
                    ComBtnDisable("btn_New");
                    DomSetFormObjDisable(form, true);
                    ComOpenWait(true);
                    sheetObj.SetWaitImageVisible(0);
                    formObj.f_cmd.value=COMMAND01;
                    var sXml=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(formObj));
                    var backendJobKey=ComGetEtcData(sXml, "BackEndJobKey")
                    
                    if (backendJobKey.length > 0) {
                        formObj.backendjob_key.value=backendJobKey;
                        sheetObj.SetWaitImageVisible(0);
                        sheetObj.SetWaitTimeOut(10000);
                        timer=setInterval(getBackEndJobStatus, 3000); // calling getBackEndJobStatus in 3 seconds 
                    }
                }
                break;
            case SEARCH01:        //
                formObj.f_cmd.value=SEARCH01;
                comboObj=rcc_cd;
                rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(formObj));
                if (rtn == '') return;
                rtn=ComGetEtcData(rtn, "rtn");
                rtn=rtn + "ALL|0";
                var rtnList=rtn.split("^");
                sheetObj.RemoveAll();
                idxSelect="";
                for (i=0; i <= rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue=rtnList[i].split("|");
                        comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);
                        if (rtnValue[1] == '1') idxSelect=rtnValue[0];
                    }
                }
                comboObj.SetSelectText(idxSelect,true);
                //idxSelect.GetSelectText();
                doActionIBSheet(sheetObjects[0],document.form,SEARCH02);
                break;
            case SEARCH02:        //
                formObj.f_cmd.value=SEARCH02;
                comboObj=lcc_cd;
                rtn=sheetObj.GetSearchData("EES_CTM_0418GS.do", FormQueryString(formObj));
                if (rtn == '') return;
                rtn=ComGetEtcData(rtn, "rtn");
                var rtnList=rtn.split("^");
                comboObj.RemoveAll();
                idxSelect="";
                for (i=0; i <= rtnList.length; i++) {
                    if (rtnList[i]) {
                        rtnValue=rtnList[i].split("|");
                        comboObj.InsertItem(i, rtnValue[0], rtnValue[0]);
                    }
                }
                break;
            case COMMAND01:
                ComOpenWait(true);
                var queryStr="f_cmd=" + SEARCH03;
                queryStr += "&p_yard=" + sheetObjects[0].GetCellValue(sRows, "org_yd_cd");
                queryStr += "&time_off=" + formObj.time_off.value;
                queryStr += "&edi_type=" + formObj.edi_type.value;
                queryStr += "&sts_cd=" + formObj.sts_cd.value;
                queryStr += "&fcntr_flg=" + formObj.fcntr_flg.value;
                queryStr += "&" + sheetObjects[0].RowSaveStr(sRows);
                sheetObj.DoSearch  ("EES_CTM_0418GS.do", queryStr, { Sync : 1 } );
                break;
        }
    }

    function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
        if(sheetObj.RowCount() < 1){
    		ComShowCodeMessage("COM132501");
    	}else{
    		sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
    	}
        ComOpenWait(false);
    }
    /**
     * handling OnSearchEnd event in sheet1 object
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
        DomSetFormObjDisable(form, false);
        ctl_radio();
        var frmObj=document.form;
        if (ErrMsg == "" && sheetObj.RowCount()> 0) {
            lstRow=sheetObj.LastRow();
            sheetObj.SetRowHidden(lstRow,1);
            total=sheetObj.GetCellValue(lstRow, "tot");
            if (total == '0') total=1;
            if (sheetObj.GetCellValue(lstRow, "tot") == '') {
                formObj.c12.value='';
                formObj.c24.value='';
                formObj.c48.value='';
                formObj.c72.value='';
                formObj.c_a.value='';
                formObj.p12.value='';
                formObj.p24.value='';
                formObj.p48.value='';
                formObj.p72.value='';
            } else {
                formObj.c12.value=sheetObj.GetCellText(lstRow, "off_12");
                formObj.c24.value=sheetObj.GetCellText(lstRow, "off_24");
                formObj.c48.value=sheetObj.GetCellText(lstRow, "off_48");
                formObj.c72.value=sheetObj.GetCellText(lstRow, "ovr_48");
                formObj.c_a.value=sheetObj.GetCellText(lstRow, "tot");
                formObj.p12.value=Math.round(sheetObj.GetCellValue(lstRow, "off_12") / total * 1000)/10 + " %";
                formObj.p24.value=Math.round(sheetObj.GetCellValue(lstRow, "off_24") / total * 1000)/10 + " %";
                formObj.p48.value=Math.round(sheetObj.GetCellValue(lstRow, "off_48") / total * 1000)/10 + " %";
                formObj.p72.value=Math.round(sheetObj.GetCellValue(lstRow, "ovr_48") / total * 1000)/10 + " %";
            }
            with(sheetObj) {
                if (frmObj.data_by[4].checked) {
                    SetCellFont("FontBold", 2, "tot", LastRow(), "tot",1);
                    SetColFontColor("tot","#0000FF");
                    SetDataLinkMouse("tot",1);
                    SetCellFont("FontBold", 2, "mtot", LastRow(), "mtot",1);
                    SetColFontColor("mtot","#0000FF");
                    SetDataLinkMouse("mtot",1);
                    SetCellFont("FontBold", 2, "stot", LastRow(), "stot",1);
                    SetColFontColor("stot","#0000FF");
                    SetDataLinkMouse("stot",1);
                    SetCellFont("FontBold", 2, "etot", LastRow(), "etot",1);
                    SetColFontColor("etot","#0000FF");
                    SetDataLinkMouse("etot",1);
                    SetCellFont("FontBold", 2, "off_12", LastRow(), "off_12",1);
                    SetColFontColor("off_12","#0000FF");
                    SetDataLinkMouse("off_12",1);
                    SetCellFont("FontBold", 2, "moff_12", LastRow(), "moff_12",1);
                    SetColFontColor("moff_12","#0000FF");
                    SetDataLinkMouse("moff_12",1);
                    SetCellFont("FontBold", 2, "soff_12", LastRow(), "soff_12",1);
                    SetColFontColor("soff_12","#0000FF");
                    SetDataLinkMouse("soff_12",1);
                    SetCellFont("FontBold", 2, "eoff_12", LastRow(), "eoff_12",1);
                    SetColFontColor("eoff_12","#0000FF");
                    SetDataLinkMouse("eoff_12",1);
                    SetCellFont("FontBold", 2, "off_24", LastRow(), "off_24",1);
                    SetColFontColor("off_24","#0000FF");
                    SetDataLinkMouse("off_24",1);
                    SetCellFont("FontBold", 2, "moff_24", LastRow(), "moff_24",1);
                    SetColFontColor("moff_24","#0000FF");
                    SetDataLinkMouse("moff_24",1);
                    SetCellFont("FontBold", 2, "soff_24", LastRow(), "soff_24",1);
                    SetColFontColor("soff_24","#0000FF");
                    SetDataLinkMouse("soff_24",1);
                    SetCellFont("FontBold", 2, "eoff_24", LastRow(), "eoff_24",1);
                    SetColFontColor("eoff_24","#0000FF");
                    SetDataLinkMouse("eoff_24",1);
                    SetCellFont("FontBold", 2, "off_48", LastRow(), "off_48",1);
                    SetColFontColor("off_48","#0000FF");
                    SetDataLinkMouse("off_48",1);
                    SetCellFont("FontBold", 2, "moff_48", LastRow(), "moff_48",1);
                    SetColFontColor("moff_48","#0000FF");
                    SetDataLinkMouse("moff_48",1);
                    SetCellFont("FontBold", 2, "soff_48", LastRow(), "soff_48",1);
                    SetColFontColor("soff_48","#0000FF");
                    SetDataLinkMouse("soff_48",1);
                    SetCellFont("FontBold", 2, "eoff_48", LastRow(), "eoff_48",1);
                    SetColFontColor("eoff_48","#0000FF");
                    SetDataLinkMouse("eoff_48",1);
                    SetCellFont("FontBold", 2, "ovr_48", LastRow(), "ovr_48",1);
                    SetColFontColor("ovr_48","#0000FF");
                    SetDataLinkMouse("ovr_48",1);
                    SetCellFont("FontBold", 2, "movr_48", LastRow(), "movr_48",1);
                    SetColFontColor("movr_48","#0000FF");
                    SetDataLinkMouse("movr_48",1);
                    SetCellFont("FontBold", 2, "sovr_48", LastRow(), "sovr_48",1);
                    SetColFontColor("sovr_48","#0000FF");
                    SetDataLinkMouse("sovr_48",1);
                    SetCellFont("FontBold", 2, "eovr_48", LastRow(), "eovr_48",1);
                    SetColFontColor("eovr_48","#0000FF");
                    SetDataLinkMouse("eovr_48",1);
                } else {
                    SetDataLinkMouse("tot",0);
                    SetDataLinkMouse("mtot",0);
                    SetDataLinkMouse("stot",0);
                    SetDataLinkMouse("etot",0);
                    SetDataLinkMouse("off_12",0);
                    SetDataLinkMouse("moff_12",0);
                    SetDataLinkMouse("soff_12",0);
                    SetDataLinkMouse("eoff_12",0);
                    SetDataLinkMouse("off_24",0);
                    SetDataLinkMouse("moff_24",0);
                    SetDataLinkMouse("soff_24",0);
                    SetDataLinkMouse("eoff_24",0);
                    SetDataLinkMouse("off_48",0);
                    SetDataLinkMouse("moff_48",0);
                    SetDataLinkMouse("soff_48",0);
                    SetDataLinkMouse("eoff_48",0);
                    SetDataLinkMouse("ovr_48",0);
                    SetDataLinkMouse("movr_48",0);
                    SetDataLinkMouse("sovr_48",0);
                    SetDataLinkMouse("eovr_48",0);
                }
            }
        }
        ComOpenWait(false);
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * handling process for input validation
     */
    function validateForm(sheetObj,formObj,sAction) {
        with (formObj) {
        //             if (!isNumber(formObj.iPage)) {
        //                 return false;
        //             }
        }
        return true;
    }
    /**
     * down loading data as Excel when double clicking
     * stopping after alert in case of data over 10000 lines
     */
    function sheet1_OnDblClick(sheetObj, Row, Col) {
    	if (sheetObj.SetDataLinkMouse(Col) && sheetObj.GetCellValue(Row, "org_yd_cd") != "") {
            var frmObj=document.form;
            var val=sheetObj.ColSaveName(Col);
            cellVal=sheetObj.GetCellValue(Row, Col);
            if (cellVal > 10000) {
                ComShowCodeMessage("CTM20112");
                return;
            } else if (cellVal < 1) {
                return;
            } else if (ComShowCodeConfirm("CTM30006")) {
                sRows=Row;
                if (Col >= 7 && Col <= 15) {
                    val=val.substring (0, val.length);
                    frmObj.edi_type.value='A';
                } else if (Col >= 16 && Col <= 24) {
                    val=val.substring (1, val.length);
                    frmObj.edi_type.value='E';
                } else if (Col >= 25 && Col <= 33) {
                    val=val.substring (1, val.length);
                    frmObj.edi_type.value='S';
                } else if (Col >= 34 && Col <= 42) {
                    val=val.substring (1, val.length);
                    frmObj.edi_type.value='M';
                } else return;
                if (val == 'off_12') frmObj.time_off.value='1';
                else if (val == 'off_24') frmObj.time_off.value='2';
                else if (val == 'off_48') frmObj.time_off.value='3';
                else if (val == 'ovr_48') frmObj.time_off.value='4';
                else if (val == 'tot') frmObj.time_off.value='5';
                doActionIBSheet(sheetObjects[1], frmObj, COMMAND01);
            }
        }
    }
    /**
     * handling MultiSelection OnCheckClick event of statusCombo
     */
    function statusCombo_OnCheckClick(comboObj, index, code) {
        // calling multiComboOnCheckClick of coCtm
        multiComboOnCheckClick(comboObj, index, document.form.sts_cd);
    }
    /**
     * setting Combo initial values
     * param : sheetObj, sheetNo
     * adding case as numbers of counting Combo
     */
    function initCombo(comboObj, comboId) {
        with (comboObj) {
            switch (comboId) {
                case "statusCombo":
                    SetMultiSelect(true); //1
                    SetDropHeight(160);
                    InsertItem(0, "ALL", "");
                    InsertItem(1, "OP", "OP");
                    InsertItem(2, "EN", "EN");
                    InsertItem(3, "TN", "TN");
                    InsertItem(4, "OC", "OC");
                    InsertItem(5, "VL", "VL");
                    InsertItem(6, "VD", "VD");
                    InsertItem(7, "IC", "IC");
                    InsertItem(8, "ID", "ID");
                    InsertItem(9, "TS", "TS");
                    InsertItem(10, "MT", "MT");
                    InsertItem(11, "ER", "ER");
                    InsertItem(12, "CP", "CP");
                    InsertItem(13, "CT", "CT");
                    InsertItem(14, "CE", "CE");
                    InsertItem(15, "CO", "CO");
                    InsertItem(16, "CI", "CI");
                    InsertItem(17, "CD", "CD");
                    InsertItem(18, "CM", "CM");
                    InsertItem(19, "ZZ", "ZZ");
                    //Text="ALL";
                    SetSelectText("ALL", true);
                    break;
                case "fcntr_flg":
	                SetMultiSelect(false); //0
	                SetDropHeight(80);
	                InsertItem(0, "ALL", "");
	                InsertItem(1, "F", "Y");
	                InsertItem(2, "M", "N");
	                SetSelectText("ALL", true);
                    break;
            }
            
            SetUseAutoComplete(true); //1
            //no support[check again]CLT ValidChar(2, 1);
        }
    }
    /**
     * registering IBCombo Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
     */
    function setComboObject(combo_obj) {
        comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * checking BackEndJob until Status='3' 
     */
    function getBackEndJobStatus() {
        formObj=document.form;
        var sheetObject1=sheetObjects[0];
        formObj.f_cmd.value=SEARCH;
        sheetObject1.SetWaitImageVisible(0);
         var sXml=sheetObject1.GetSearchData("EES_CTM_0418GS.do", FormQueryString(formObj));
        var jobState=ComGetEtcData(sXml, "jb_sts_flg")
        // alert("sheet1 :::>> jobState : "+jobState);
        if (jobState == "3") {
            getBackEndJobLoadFile();
            clearInterval(timer);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        } else if (jobState == "4") {
            // BackEndJob failed
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        } else if (jobState == "5") {
            ComShowCodeMessage('CTM10024');
            ComOpenWait(false);
            ComBtnEnable("btn_Retrieve");
            ComBtnEnable("btn_New");
        }
    }
    /**
     * handling OnDownFinish event in sheet2 object
     */
    function sheet2_OnDownFinish(DownloadType, SaveAsName) {
        ComShowCodeMessage("CTM10115", "Data");
    }
    /**
     * down loading data as Excel after end of BackEndJob
     */
    function getBackEndJobLoadFile() {
        formObj=document.form;
        formObj.f_cmd.value=SEARCHLIST;
        ComOpenWait(false);
        //sheetObjects[0].DoSearch4Sax("EES_CTM_0418GS.do", FormQueryString(formObj));
        sheetObjects[0].DoSearch("EES_CTM_0418GS.do", FormQueryString(formObj));
    }
    function resizeSheet(){
    	ComResizeSheet(sheetObjects[0], 75);
	}
