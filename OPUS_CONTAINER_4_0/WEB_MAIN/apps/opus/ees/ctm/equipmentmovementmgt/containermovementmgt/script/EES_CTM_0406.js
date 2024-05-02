/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_CTM_0406.js
 *@FileTitle : International MVMT
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/* developer job    */
// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var sheetRow=0;
var sheetCol=0;
var crntContainer="";
var sheetContainer="";
var sheetContainerFlg=null;
var sheetBkgValue="";
var crntBkgValue=false;
var sheetBkgValueFlg=null;
var crntMtyPln="";
var sheetMtyPln="";
var sheetMtyPlnFlg=null;
var selectedRow=null;
var etaEtdPass=true;
var focusCheck=true;
var errorRow=-1;
var errorBack=-1;
var errCount=0;
var saveXml=new Array();
// Event handler processing by button click event */
var preChk=false; // Pre Check Button 처리여부
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
    var sheetObject=sheetObjects[0];
    /** **************************************************** */
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        switch (srcName) {
        case "btn_add":
            formObj.p_cntrno.value="";
            addRow();
            break;
        case "btn_delete":
            var sRowStr=sheetObject.FindCheckedRow("del_chk");
            // making as javascript array
            var arr=sRowStr.split("|");
            var stsCond=formObj.p_status.value;
            var delTarget=new Array();
            for (i=0; i < arr.length; i++) {
                delTarget[i]=arr[i]; // changing selected row's status to 'D' for deleting
            }
            for (i=delTarget.length; i >= 0; i--) {
                if (delTarget[i])
                    sheetObject.RowDelete(delTarget[i], false);
            }
            break;
        case "btn_select":
            // calling pop up to container information after inputing booking number
            selectedRow=sheetObject.GetSelectRow();
            bkg_no=sheetObject.GetCellValue(selectedRow, "bkg_no")
            sUrl="EES_CTM_0433.do?bkg_no=" + bkg_no;
            iWidth="550";
            iHeight="320";
            bModal=true;
            ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
            break;
        case "btn_qty":
            // calling Qty Check Popup 
            selectedRow=sheetObject.GetSelectRow();
            bkg_no=sheetObject.GetCellValue(selectedRow, "bkg_no")
            sUrl="EES_CTM_0458.do?bkg_no=" + bkg_no;
            iWidth="360";
            iHeight="290";
            bModal=true;
            ComOpenPopup(sUrl, iWidth, iHeight, "", "0,1", bModal);
            break;
        case "btn_pre":
            preCheck();
            break;
        case "btn_downExcel":
             if(sheetObject.RowCount() < 1){
                    ComShowCodeMessage("COM132501");
                }else{
                    sheetObject.Down2Excel();
                }           
            break;
        case "btn_loadExcel":
        	if (document.form.p_yard2.value== "") {
                ComShowCodeMessage("CTM10049", "yard cd", "", "")
                return 0;
            } 
            setElementDisable(true);
            if (sheetObject.LastRow()>= 1) {
                if (ComShowCodeConfirm("CTM20110") != true)
                    return;
                else
                    sheetObject.RemoveAll();
            }

            sheetObject.LoadExcel();

            break;
        case "btn_retrieve":
            if (checkFormField()) {
                if (formObj.p_yard2.value== '') {
                    ComShowCodeMessage("CTM00000", "Yard");
                    return;
                }
                var stsCond=formObj.p_status.value;
                if (stsCond == 'VL' || stsCond == 'VD')
                    doActionIBSheet(sheetObject, formObj, IBSEARCH);
            }
            break;
        case "btn_new":
            // handling new button event
            // making Save button disabled in case of VL, VD. initializing in the other cases
            sheetObject.RemoveAll();
            p_yard2.RemoveAll();
            document.getElementsByName("p_yard1")[0].value="";
            document.getElementsByName("p_pol")[0].value="";
            document.getElementsByName("p_pod")[0].value="";
            document.getElementById("p_vvd").value="";
            document.getElementById("p_type1").options.selectedIndex=0;
            formObj.p_cntrno.value="";
            ComBtnEnable("btn_add");
            ComBtnEnable("p_vvd");
            ComBtnEnable("oscar_bkg_flg");
            
            srcValue="";
            sheetContainer="";
            setElementDisable(false);
            preChk=false;
            etaEtdPass=true;
            // making Save button disabled in case of VL, VD (making enable after pre check)
            status=document.form.p_status.value;
            if (status == "VL" || status == "VD") {
                ComBtnDisable("btn_save");
            } else {
                ComBtnEnable("btn_save");
            }
            // initializing date 
            strTime=new Date();
            y=strTime.getFullYear();
            m=strTime.getMonth() + 1;
            d=strTime.getDate();
            if (m < 10) m="0" + m;
            if (d < 10) d="0" + d;
            //formObj.p_date.value=y + "-" + m + "-" + d;
            formObj.p_date.value=ComGetNowInfo();    
            digital=new Date();
            hours=digital.getHours();
            minutes=digital.getMinutes();
            if (minutes < 10) minutes="0" + minutes;
            if (hours < 10)   hours="0" + hours;
            document.form.p_time.value=hours + ":" + minutes;
            document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
            if (status != 'VL' && status != 'VD') ComBtnEnable("btn_loadExcel");
            
            conditionEnable();
            break;
        case "btn_save":
            // preChkFrm is function for checking mandatory items.
            // calling save event
            if (preChkFrm())
                doActionIBSheet(sheetObject, formObj, IBSAVE);
            break;
        case "btn_Calendar1":
            // calling calendar
            // event date is yyyymmddhh24mi 
            if (!ComGetEvent().disabled) {
                var cal=new ComCalendar();
                cal.select(formObj.p_date, 'yyyy-MM-dd');
                if (!document.layers && !document.all)
                    return;
                digital=new Date();
                hours=digital.getHours();
                minutes=digital.getMinutes();
                if (minutes < 10) minutes="0" + minutes;
                if (hours < 10)   hours="0" + hours;
                formObj.p_time.value=hours + ":" + minutes;
                //formObj.p_date0.value=formObj.p_date.value + " " + formObj.p_time.value;
                formObj.p_date.focus();
                // cal.ComCalendar_select(formObject.p_date0, 'yyyyMMdd');
            }
            break;
        }
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
	//alert("event name : sheet1_OnLoadExcel");
	if(isExceedMaxRow(msg))return; 
    if(result) {
        checkValidation(sheetObj);	// sheetObj 2015/06/15
    }
}

/**
 * initializing screen when clicking New or Add button
 */
function setElementDisable(disableType) {
    var docForm=document.form;
    DomSetFormObjDisable(docForm, disableType);
    if (disableType)
        disableType=false;
    else
        disableType=true;
    p_yard2.SetEnable(disableType);
}
/**
 *  checking form before saving
 */
function preChkFrm() {
    var sheetObject=sheetObjects[0];
    var formObj=document.form;
    var stsCond=formObj.p_status.value;
    // prohibiting to enter data after today
    switch (stsCond) {
        case "OP":
        case "OC":
            for (i=1; i <= sheetObject.LastRow(); i++) {
                bkgValue=sheetObject.GetCellValue(i, "bkg_no");
                if (bkgValue == '') {
                    ComShowCodeMessage("CTM10049", "booking no");
                    return false;
                }
            }
        case "IC":
        case "ID":
            // not to input  event date after OP, OC input date
            for (i=1; i <= sheetObject.LastRow(); i++) {
                evtValue=sheetObject.GetCellValue(i, "cnmv_evnt_dt").substring(0, 8);
                if (evtValue == '') {
                    ComShowCodeMessage("CTM10049", "event date");
                    return false;
                }
            }
            break;
        case "MT":
        case "EN":
        case "TN":
          for (Row=1; Row <= sheetObj.LastRow(); Row++) {
		      if (sheetObj.GetCellEditable(Row, "mty_pln_no") == 1 && sheetObj.GetCellValue(Row, "mty_pln_no") == "") {
		        ComShowCodeMessage("CTM10049", "EQR Ref. No");
		        return false;
		      }
          }
          // not to input  event date after OP, OC input date
          for (i=1; i <= sheetObject.LastRow(); i++) {
              evtValue=sheetObject.GetCellValue(i, "cnmv_evnt_dt").substring(0, 8);
              if (evtValue == '') {
                  ComShowCodeMessage("CTM10049", "event date");
                  return false;
              }
          }
          break;
        case "TS":
            // not to input  event date after OP, OC input date
//            for (i=1; i <= sheetObject.LastRow(); i++) {
//                evtValue=sheetObject.GetCellValue(i, "cnmv_evnt_dt").substring(0, 8);
//                if (evtValue == '') {
//                    ComShowCodeMessage("CTM10049", "event date");
//                    return false;
//                }
//            }
//            break;
        case "VL":
        case "VD":
//            idx=document.form.p_date0.value;
//            status=document.form.p_status.value
//
//            strTime=new Date();
//            y=strTime.getFullYear();
//            m=strTime.getMonth() + 1;
//            d=strTime.getDate();
//            h=strTime.getHours();
//            n=strTime.getMinutes();
//            if (m < 10) m="0" + m;
//            if (d < 10) d="0" + d;
//            if (h < 10) h="0" + h;
//            if (n < 10) n="0" + n;
//            strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
//            offSet=Number(dateTimeDiff(strDt, document.form.p_date0.value));
//            if (offSet > 3) {
////                    ComShowCodeMessage("CTM10002");
////                     alert ("Since event date/time is 3 hour later than now,
////                     movement status will not be reflected right now. Status will
////                     be updated around inputted event date/time.");
//            	ComShowCodeMessage("CTM10053");
//            } else {
//            	return true;
//            }
//        break;
            for (i=1; i <= sheetObject.LastRow(); i++) {
                evtValue=sheetObject.GetCellValue(i, "cnmv_evnt_dt").substring(0, 8);
                if (evtValue == '') {
                    ComShowCodeMessage("CTM10049", "event date");
                    return false;
                }
            }
            break;
    }
	for (idx=1; idx <= sheetObject.LastRow(); idx++) {
		sheetObject.SetCellValue(idx, "org_yd_cd",formObj.p_yard1.value + document.form.p_yard2.value);
	}
    return true;
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj) {
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for (i=0; i < comboObjects.length; i++) {
        initCombo(comboObjects[i], comboObjects[i].options.id);
    }
    for (k=0; k < tabObjects.length; k++) {
        initTab(tabObjects[k], k + 1);
    }
    // initializing date. setting current time as event time
    strTime=new Date(); 
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    document.form.p_date.value=ComGetNowInfo();  
    //document.form.p_date.value=y + "-" + m + "-" + d;
    //document.form.p_time.value=ComGetNowInfo("hm");
    digital=new Date();
    hours=digital.getHours();
    minutes=digital.getMinutes();
    if (minutes < 10)
        minutes="0" + minutes;
    if (hours < 10)
        hours="0" + hours;
    document.form.p_time.value=hours + ":" + minutes;
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
    ComBtnDisable("btn_select", "btn_qty", "btn_pre", "btn_downExcel");
    // setEventProcess : auto creating event
    //setEventProcess("p_status", "p_yard1", "p_date0", "p_date", "p_time", "p_vvd", "p_cntrno");
    //axon_event.addListener('focus', 'date_focus', 'p_date');
    axon_event.addListener('change', 'status_Change', 'p_status');
    axon_event.addListener('blur', 'date_Change', 'p_date');
    axon_event.addListener('blur', 'time_Change', 'p_time');
    axon_event.addListener('blur', 'yard_Change', 'p_yard1');
//  $('input[name="p_yard1"]').on('change, blur', function() {
//      yard_Change(ComGetEvent());
//  });
    axon_event.addListener('keyup', 'vvd_keyUp', 'p_vvd');
    axon_event.addListener('blur', 'vvd_blur', 'p_vvd');
//    axon_event.addListener('change', 'osca_vvd_check', 'oscar_bkg_flg');
    axon_event.addListener('keyup', 'cntrno_keyUp', 'p_cntrno');
    //axon_event.addListener('blur', 'date_Change', 'p_date');
    //axon_event.addListener('blur', 'vvd_change', 'p_vvd');
    //axon_event.addListener('keypress', 'obj_FormatString', "p_status", "p_yard1", "p_date0", "p_date", "p_time", "p_vvd", "p_cntrno");
    sheetObj=sheetObjects[0];
    document.form.p_status.focus();
    
    setComboData(sheetObj);
}
/**
 * setting Combo text and value
 * param : comboObj, comboNo
 * adding case as numbers of counting combos
 */
function initCombo(comboObj, comboId) {
    var formObj=document.form;
    with (comboObj) {
//no support[check again]CLT        UseCode=true;
        switch (comboId) {
        default:
            with (comboObj) {
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                SetColAlign(1, "left");
                SetColWidth(0, "30");
                SetColWidth(1, "200");
                SetBackColor("#CCFFFD");
                SetFontColor("#373737");
                SetColBackColor(0,"#7F9DB9");
                SetColFontColor(0,"#373737");
                SetColBackColor(1,"#EFEFEF");
                SetColFontColor(1,"#373737");
                SetDropHeight(160);
            }
            break;
        }
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

function setComboData(sheetObj) {
	with (sheetObj) {
		var cntrDmgFlg ="|Y|N";
		
		for(i=1; i<=RowCount(); i++) {
			var cntrDmgFlg=GetCellValue(i,"cntr_dmg_flg");
		}
		SetColProperty("cntr_dmg_flg", {ComboText:cntrDmgFlg, ComboCode:cntrDmgFlg});
	}
}

/**
 * calling in case date changed
 * not to be over 7 days in VL, VD. OP and OC should be today
 */
function date_Change() {
    obj=document.form.p_date;
    objValue=obj.value;
    objValue=ComGetMaskedValue(objValue, "ymd");
    
    strTime=new Date(); 
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    h=strTime.getHours();
    n=strTime.getMinutes();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    if (h < 10) h="0" + h;
    if (n < 10) n="0" + n;
    
    if (objValue != false) {
        obj.value=objValue;
        if (obj.name == "p_date") {
        //document.form.p_date0.select();
        }
    } else {
        ComShowCodeMessage("CTM00001");
        document.form.p_date.value=ComGetNowInfo(); //chrome54 infinite alert bug - initialize
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value; //chrome54 infinite alert bug - initialize
        // obj.value = objValue;
        obj.select();
        obj.focus();
        return;
    }
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
    var idx=document.form.p_date0.value;
    var status=document.form.p_status.value

    strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
    p_date=document.form.p_date0.value;
    rValue=Number(dateTimeDiff(strDt, p_date));
    if (rValue > 3) {
        ComShowCodeMessage("CTM10053");
        document.form.p_date.value=ComGetNowInfo(); //chrome54 infinite alert bug - initialize
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value; //chrome54 infinite alert bug - initialize
        // alert ("Event date can't exceed+0 Days from today.");
        obj.select();
        obj.focus();
        return;
    }
    
    if (status == 'VL' || status == 'VD') {
        vvd=document.form.p_vvd.value;
        if (vvd.length == 9) {
            vvd_check(event);
        }
    }
}
/**
 * calling in case date changed
 * not to be over 7 days in VL, VD. OP and OC should be today
 * same as date_Change. 3 hours part can be changed as necessary in case of not VL & VD
 */
function time_Change() {
    obj=document.form.p_time;
    objValue=obj.value;
    objValue=ComGetMaskedValue(objValue, "hm");  
    
    strTime=new Date();
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    h=strTime.getHours();
    n=strTime.getMinutes();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    if (h < 10) h="0" + h;
    if (n < 10) n="0" + n;
    digital=new Date();
    hours=digital.getHours();
    minutes=digital.getMinutes();
    if (minutes < 10)
        minutes="0" + minutes;
    if (hours < 10)
        hours="0" + hours;
    
    if (objValue == '') {
        ComShowCodeMessage("CTM00001");
        obj.value="";
        document.form.p_time.value=hours + ":" + minutes; //chrome54 infinite alert bug - initialize
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value; //chrome54 infinite alert bug - initialize
        obj.focus();
        return;
    }
    if (objValue != false) {
        obj.value=objValue;
        if (obj.name == "p_time") {
        //document.form.p_date0.select();
        }
    } else {
        ComShowCodeMessage("CTM00001");
        // obj.value = objValue;
        obj.value="";
        document.form.p_time.value=hours + ":" + minutes; //chrome54 infinite alert bug - initialize
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value; //chrome54 infinite alert bug - initialize
        obj.focus();
        return;
    }
    document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value;
    var idx=document.form.p_date0.value;
    var status=document.form.p_status.value

    strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
    p_date=document.form.p_date0.value;
    rValue=Number(dateTimeDiff(strDt, p_date));
    if (rValue > 3) {
        ComShowCodeMessage("CTM10053");
        // alert ("Event date can't exceed+0 Days from today.");
        obj.select();
        document.form.p_time.value=hours + ":" + minutes; //chrome54 infinite alert bug - initialize
        document.form.p_date0.value=document.form.p_date.value + " " + document.form.p_time.value; //chrome54 infinite alert bug - initialize
        obj.focus();
        return;
    }
    
    if (status == 'VL' || status == 'VD') {
        vvd=document.form.p_vvd.value;
        if (vvd.length == 9) {
            vvd_check(event);
        }
    }
}
/**
 * checking time gap comparing with today
 */
function getDateDiff(idx) {
    endDt=idx.substring(0, 4) + idx.substring(5, 7) + idx.substring(8, 10);
    strTime=new Date();
    y=strTime.getFullYear();
    m=strTime.getMonth() + 1;
    d=strTime.getDate();
    h=strTime.getHours();
    n=strTime.getMinutes();
    if (m < 10) m="0" + m;
    if (d < 10) d="0" + d;
    if (h < 10) h="0" + h;
    if (n < 10) n="0" + n;
    strDt=y + m + d;
    if (endDt > strDt) return 999;
}
/**
 * checking time gap comparing with today
 */
function getDateDiffTim(idx) {
    var startDt=new Date();
    var endDt=new Date(Number(idx.substring(0, 4)), Number(idx.substring(5, 7)) - 1, Number(idx.substring(8, 10)));
    resultDt=Math.floor(endDt.valueOf() / (24 * 60 * 60 * 1000) - startDt.valueOf() / (24 * 60 * 60 * 1000));
    return resultDt;
}
/**
 * checking time gap comparing with today
 */
function getTimeDiff(idx) {
    var startDt=new Date();
    var endDt=new Date(Number(idx.substring(0, 4)), Number(idx.substring(5, 7)) - 1, Number(idx.substring(8, 10)), Number(idx.substring(11, 13)), Number(idx.substring(14, 16)));
    var resultDt=Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
    return resultDt;
}
/**
 * checking time gap comparing with today
 */
function dateTimeDiff(idx1, idx2) {
    var startDt=new Date(Number(idx1.substring(0, 4)), Number(idx1.substring(5, 7)) - 1, Number(idx1.substring(8, 10)), Number(idx1.substring(11, 13)), Number(idx1.substring(14, 16)));
    var endDt=new Date(Number(idx2.substring(0, 4)), Number(idx2.substring(5, 7)) - 1, Number(idx2.substring(8, 10)), Number(idx2.substring(11, 13)), Number(idx2.substring(14, 16)));
    var resultDt=Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
    return resultDt;
}
/**
 * checking time gap comparing start date and end date
 */
function dateDiff(idx1, idx2) {
    var startDt=new Date(Number(idx1.substring(0, 4)), Number(idx1.substring(5, 7)) - 1, Number(idx1.substring(8, 10)));
    var endDt=new Date(Number(idx2.substring(0, 4)), Number(idx2.substring(5, 7)) - 1, Number(idx2.substring(8, 10)));
    var resultDt=Math.floor(endDt.valueOf() / (60 * 60 * 1000) - startDt.valueOf() / (60 * 60 * 1000));
    return resultDt;
}
/**
 * checking yard in case of changing yard
 */
function yard_Change(event) {
    eventElement=ComGetEvent();
    var status=document.form.p_status.value;
    if (eventElement.value.length < 5){
    	eventElement.focus();
        return;
    }
/*    if (srcValue == eventElement.value)
        return;*/
	    p_yard2.RemoveAll();
	    onShowErrMsg=false;
    // checking yard function. returning S/F
	rtn=yard_search();

    // clearing and focusing yard in case of invalid yard return
    if (rtn && ofcChk != "S") {
        p_yard2.RemoveAll();
        ComShowCodeMessage("CTM20072");
        eventElement.value = "";
        eventElement.focus();
        return;
    }
    // validating VVD code in case Status is VL or VD(when VVD entered)
    if (status == "VL") {
        document.form.p_pol.value=eventElement.value;
        if (document.form.p_vvd.value != '')
            vvd_check();
    } else if (status == "VD") {
        document.form.p_pod.value=eventElement.value;
        if (document.form.p_vvd.value != '')
            vvd_check();
    }
    if (rtn) {
        if (curKeyCode == "9") {
            curKeyCode="";
            srcValue=ComGetEvent("value");
        } else {
            objTmp=setFocusIndex(eventElement, 1)
            try {
                ComSetFocus(document.form.p_yard2);
            } catch (e) {
            }
            curKeyCode="";
            srcValue=ComGetEvent("value");
            return;
        }
    } else {
        eventElement.value = "";
        eventElement.focus();

        if (status == "VL") {
            document.form.p_pol.value = "";
        } else if (status == "VD") {
            document.form.p_pod.value = "";
        }
    }
}
/**
 * validating VVD code in case VVD changed
 * @param event
 * @return
 */
function vvd_keyUp(event) {
    eventElement=ComGetEvent();
    var vvdCode=eventElement.value;

//    if (document.form.oscar_bkg_flg.checked==true && document.form.p_vvd.readOnly==false) {
//    	if(vvdCode.length == 7){
//    		osca_vvd_check(event);
///**    		
//    	}else if(vvdCode!="" && vvdCode.length > 7){
//    		eventElement.focus();
//    		alert("Please Input 7 characters.");
//    		return;
//**/    		
//    	}
//    }
//    
    if (vvdCode.length == 9) {
        vvd_check(event);
    }
}


function vvd_blur(event) {
    eventElement=ComGetEvent();
    var vvdCode=eventElement.value;

    if (document.form.oscar_bkg_flg.checked==true && document.form.p_vvd.readOnly==false) {
    	if(vvdCode.length == 7){
    		osca_vvd_check(event);
    	/**}else{
    		alert("Please Input 7 characters.");
    		eventElement.focus();
    		return;
    	**/	
    	}
    }
    
    if (vvdCode.length == 9) { 
        vvd_check(event);
    }
}

//function setOBFValue(){
//	formObj=document.form;
//	
//	if(document.form.oscar_bkg_flg.checkd==true){
//		formObj.osca_bkg_flg.value="Y";
//	}else{
//		formObj.osca_bkg_flg.value="";
//	}
//		
//}

function osca_vvd_check() {
    formObj=document.form;
    formObj.org_vvd.value = formObj.p_vvd.value;
    
//	if(document.form.oscar_bkg_flg.checked==true){
//		formObj.osca_bkg_flg.value="Y";
//	}else{
//		formObj.osca_bkg_flg.value="";
//	}
		
    if (formObj.p_yard1.value == '') {
        ComShowCodeMessage("CTM00000", "Origin Yard");
//        formObj.p_yard1.select(); //chrome54 infinite alert bug
//        formObj.p_yard1.focus(); //chrome54 infinite alert bug
        return;
    }
    
    if (formObj.p_vvd.value.length != 7 && document.form.oscar_bkg_flg.checked==true) {
        return;
    }
    
    strQuery="f_cmd=" + SEARCH06 + "&p_vvd=" + formObj.p_vvd.value
    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
    rtnValue=ComGetEtcData(rtnXml, "rtnStr");
    
    if(rtnValue!=null && rtnValue!="" && rtnValue.length==9){
   	 	ComBtnDisable("p_vvd");
   	 	ComBtnDisable("oscar_bkg_flg");
    	 formObj.p_vvd.value = rtnValue.trim(); 
    	 alert( formObj.org_vvd.value+" ==> " + formObj.p_vvd.value  + "  VVD is changed.");

    	 return;
    }else{
    	ComShowCodeMessage("CTM20073"); // VVD Code is Not Exists
    }
   
}
/**
 * validating VVD code
 */
function vvd_check() {
    formObj=document.form;
    if (formObj.p_yard1.value == '') {
        ComShowCodeMessage("CTM00000", "Origin Yard");
//        formObj.p_yard1.select(); //chrome54 infinite alert bug
//        formObj.p_yard1.focus(); //chrome54 infinite alert bug
        return;
    }
    
    if(document.form.oscar_bkg_flg.checked==true){
    	return;
    }

    strQuery="f_cmd=" + SEARCH02 + "&p_vvd=" + formObj.p_vvd.value
    strQuery=strQuery + "&p_pol=" + formObj.p_pol.value
    strQuery=strQuery + "&p_pod=" + formObj.p_pod.value
    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
    rtnValue=ComGetEtcData(rtnXml, "rtnStr");
    rtnStr=rtnValue.split("|");
    p_date=document.form.p_date0.value;
    status=document.form.p_status.value;
    if (rtnStr.length == 2) {
        if (status == 'VL' || status == 'VD') {
            str=rtnStr[0];
            rValue=Number(dateDiff(str, p_date));
            formObj.p_pod.focus();
            if (rValue < -1 || rValue > 1) {
                if (!ComShowCodeConfirm("CTM99999", "Vessel’s ETA/ETD is " + str + ". Do you want to keep inputted event date/time ?")) {
                    formObj.p_date.select();
                    formObj.p_date.focus();
                    etaEtdPass=false;
                    return false;
                }
            }
            formObj.p_pod.focus();
        }
        etaEtdPass=true;
    } else {
        etaEtdPass=false;

        strQuery="f_cmd=" + SEARCH05 + "&p_vvd=" + formObj.p_vvd.value
        rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
        rtnValue=ComGetEtcData(rtnXml, "rtnStr");
        if(rtnValue=="Y") {
            ComShowCodeMessage("CTM30013"); // VVD does not call POD/POL.
        } else {
            ComShowCodeMessage("CTM20073"); // VVD Code is Not Exists
        }
        
//        formObj.p_vvd.select(); //chrome54 infinite alert bug
//        formObj.p_vvd.focus(); //chrome54 infinite alert bug
        formObj.p_vvd.value="";
        return false;
    }
    return true;
}
/**
 * validating VVD code in case VVD changed
 * @param event
 * @return
 */
function vvd_change(event) {
    eventElement=ComGetEvent();
    var vvdCode=eventElement.value;
    if (vvdCode == '')
        return;
    if (vvdCode.length != 9) {
        eventElement.select();
        eventElement.focus();
    }
}
/**
 * checking container no [Dup. Check Digit] // hidden
 * @param event
 * @return
 */
function cntrno_keyUp() {
    var formObj=document.form;
//  var cntr_no = formObj.p_cntrno.toUpperCase();
    formObj.p_cntrno.value=formObj.p_cntrno.value.toUpperCase();
    var cntr_no=formObj.p_cntrno;
    if (!checkFormField()) {
        cntr_no.value="";
        return;
    }
    // calling cntr_search CTM common function in case P_cntrno is inputed 11 characters
    if (cntr_no.value.length > 10) {
        var xml=sheetObj.GetSearchData("CTMCommonGS.do", "f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no.value + "&p_yard1=" + formObj.p_yard1.value);
        var rtnValue=ComGetEtcData(xml, "rtnValue");
        if (rtnValue == null) {
            ComShowCodeMessage("CTM10004");
            cntr_no.value="";
            ComSetFocus(cntr_no);
            return;
        } else {
            var addRowNum=addRow();
            // copying container no in case of adding row successfully
            with (sheetObjects[0]) {
                if (Number(addRowNum) > 0) {
                    ComBtnDisable("btn_add");
                    SetCellValue(addRowNum, "cntr_no",cntr_no.value);
                    SetCellEditable(addRowNum, "cntr_no",0);
                    SelectCell(addRowNum, SaveNameCol("cntr_no")+1);
                }
            }
        }
    }
}
/**
 * changing output in screen in case of changing MVMT STS
 * @param event
 * @return
 */
function status_Change(event) {
    formObj=document.form;
    sheetObj=sheetObjects[0];
    eventValue=ComGetEvent("value");
    switch (eventValue) {
    case "OP":
    case "OC":
        sheetObj.SetColHidden("bkg_no",0);
        sheetObj.SetColHidden("rcv_term_cd",0);
        sheetObj.SetColHidden("mty_pln_no",1);	// 2015/06/12
        sheetObj.SetColHidden("cnmv_evnt_dt",0);
        
        document.getElementById( 'btn_pre' ).style.display = 'none';
        document.getElementById( 'btn_retrieve' ).style.display ="none";
        buttonEnable("btn_select,btn_qty,btn_loadExcel,btn_save,btn_downExcel");

        clearYard();
        setDisplay("none", "input");
        setStyle(eventValue, "input");
        
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(422);
        break;
    case "IC":
    case "ID":
        sheetObj.SetColHidden("bkg_no",1);
        sheetObj.SetColHidden("rcv_term_cd",1);
        sheetObj.SetColHidden("mty_pln_no",1);	// 2015/06/12
        clearYard();
        
        document.getElementById( 'btn_pre' ).style.display ="none";
        document.getElementById( 'btn_retrieve' ).style.display ="none";
        buttonEnable("btn_select,btn_loadExcel,btn_save,btn_downExcel");
        
        setStyle(eventValue, "input");
        setDisplay("none", "input");
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(422);
        break;
    case "MT":
    case "EN":
    case "TN":
        sheetObj.SetColHidden("bkg_no",1);
        sheetObj.SetColHidden("rcv_term_cd",1);
        sheetObj.SetColHidden("mty_pln_no",0);	// 2015/06/12
        clearYard();
        
        document.getElementById( 'btn_pre' ).style.display ="none";
        document.getElementById( 'btn_retrieve' ).style.display ="none";
        buttonEnable("btn_select,btn_loadExcel,btn_save,btn_downExcel");
        
        setStyle(eventValue, "input");
        setDisplay("none", "input");
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(422);
        break;
    case "TS":
        sheetObj.SetColHidden("bkg_no",1);
        sheetObj.SetColHidden("rcv_term_cd",1);
        sheetObj.SetColHidden("mty_pln_no",1);	// 2015/06/12
        clearYard();
        
        document.getElementById( 'btn_pre' ).style.display ="none";
        document.getElementById( 'btn_retrieve' ).style.display ="none";
        buttonEnable("btn_select,btn_loadExcel,btn_save,btn_downExcel");
        
        setStyle(eventValue, "input");
        setDisplay("none", "input");
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(422);
        break;
    case "VL":
        sheetObj.SetColHidden("bkg_no",1);
        sheetObj.SetColHidden("rcv_term_cd",1);
        sheetObj.SetColHidden("mty_pln_no",1);	// 2015/06/12
        clearYard();
        setStyle("VL", "input1");
        setDisplay("", "input1");
        
        document.getElementById( 'btn_pre' ).style.display ="inline";
        document.getElementById( 'btn_retrieve' ).style.display ="inline";
        buttonEnable("btn_pre,btn_retrieve,btn_downExcel");
        
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(402);
        break;
    case "VD":
        sheetObj.SetColHidden("bkg_no",1);
        sheetObj.SetColHidden("rcv_term_cd",1);
        sheetObj.SetColHidden("mty_pln_no",1);	// 2015/06/12
        clearYard();
        setStyle("VD", "input1")
        setDisplay("", "input1");

        document.getElementById( 'btn_pre' ).style.display ="inline";
        document.getElementById( 'btn_retrieve' ).style.display ="inline";
        buttonEnable("btn_pre,btn_retrieve,btn_downExcel");
        
//      oobj=document.getElementById("sheetFr");
//      oobj.SetSheetHeight(442);
        sheetObj.SetSheetHeight(402);
        break;
    }
    document.getElementsByName("p_pol")[0].value="";
    document.getElementsByName("p_pod")[0].value="";
    document.getElementById("p_vvd").value="";
    document.getElementById("p_type1").options.selectedIndex=0;
    srcValue="";
    document.form.p_yard1.focus();
}
/**
 * initializing yard and Yard2 Combo
 * @return
 */
function clearYard() {
    formObj=document.form;
    formObj.p_yard1.value="";
    p_yard2.RemoveAll();
    sheetObjects[0].RemoveAll();
    sheetObjects[1].RemoveAll();
}
/**
 * changing show items by status.
 * showing VVD in case of VL, VD 
 * setting colors by classtype
 * @param val
 * @param classtype
 * @return
 */
function setDisplay(val, classtype) {
    var disabled;
    if(val==""){
        disabled = false;
    }else{
        disabled = true;
    }
    formObj=document.form;
    document.getElementById("condHidden").style.display=val;
    document.getElementsByName("p_vvd")[0].className=classtype;
}
/**
 * setting mandatory items by VD, VL
 * mandatory items in case class = input1
 * checking mandatory items in common method
 * @param val
 * @param cName
 * @return
 */
function setStyle(val, cName) {
    if (val == "VL") {
        document.getElementsByName("p_pol")[0].className="input1";
        document.getElementsByName("p_pol")[0].readOnly=true;
        document.getElementsByName("p_pod")[0].readOnly=false;
        document.getElementsByName("p_pod")[0].className="input";
    } else if (val == "VD") {
        document.getElementsByName("p_pod")[0].className="input1";
        document.getElementsByName("p_pod")[0].readOnly=true
        document.getElementsByName("p_pol")[0].readOnly=false;
        document.getElementsByName("p_pol")[0].className="input";
    } else {
        document.getElementsByName("p_pod")[0].className="input";
        document.getElementsByName("p_pol")[0].className="input";
    }
}
    /**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
     */
    function initSheet(sheetObj, sheetNo) {
        var cnt=0;
        with(sheetObj){
           
          
          (28, 0, 0, true);
          var HeadTitle="|Seq.||Container No.|T/S|STS|DM Flg|Booking No.|RCV|EQR Ref. No.|Event Date|Seal No.|Chassis No.|M.G Set|S/P|S/P|Mode|Return YD|SP|Remark(s)|Error Message|OrgYd|StsCd|crnt_vsl_cd|trnk_voy_cd|trnk_dir_cd|pol|pod|usa_edi_cd|cnmv_yr";

          SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:1 } );

          var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
          var headers = [ { Text:HeadTitle, Align:"Center"} ];
          InitHeaders(headers, info);

          var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Right",   ColMerge:0,   SaveName:"SEQ" },
                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
                 {Type:"Text",      Hidden:0,  Width:100,   Align:"Left",    ColMerge:0,   SaveName:"cntr_no",           KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11, InputCaseSensitive:1 },
//                 {Type:"Text",      Hidden:1,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check_digit",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Text",      Hidden:0,  Width:28,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10, InputCaseSensitive:1, ToolTipText:"type/size" },
                 {Type:"Text",      Hidden:0,  Width:28,   Align:"Center",  ColMerge:0,   SaveName:"prev_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   InputCaseSensitive:1 },
                 {Type:"Combo",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"cntr_dmg_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:97,   Align:"Left",    ColMerge:0,   SaveName:"bkg_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12, InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:10, TooltipText:"Receiving term" },
                 // PDL:41082 mty_pln_no(ref_no) 추가 start by 2015/06/08 황미연
                 {Type:"Text",      Hidden:1,  Width:134,   Align:"Left",    ColMerge:0,   SaveName:"mty_pln_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:12, InputCaseSensitive:1 },
                 // PDL:41082 mty_pln_no 추가 end
                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_evnt_dt",      KeyField:1,   CalcLogic:"",   Format:"YmdHm",       PointCount:0,   UpdateEdit:1,   InsertEdit:1, EditLen:16 },
                 {Type:"Text",      Hidden:0,  Width:84,   Align:"Center",  ColMerge:0,   SaveName:"cntr_seal_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:0,  Width:93,   Align:"Center",  ColMerge:0,   SaveName:"chss_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11, InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:0,   SaveName:"mgst_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:11, InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:0,  Width:56,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                 {Type:"Popup",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq_btn",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                 {Type:"Text",      Hidden:0,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"mvmt_trsp_mod_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:1,  InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"dest_yd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:7,  InputCaseSensitive:1 },
                 {Type:"Text",      Hidden:1,  Width:37,   Align:"Center",  ColMerge:0,   SaveName:"spcl_cgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:10, InputCaseSensitive:1, ToolTipText:"Special" },
                 {Type:"Text",      Hidden:0,  Width:130,  Align:"Left",    ColMerge:0,   SaveName:"cnmv_rmk",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:30 },
                 {Type:"Text",      Hidden:0,  Width:230,  Align:"Left",    ColMerge:0,   SaveName:"err_msg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"org_yd_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"mvmt_sts_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"crnt_vsl_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_voy_no" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"crnt_skd_dir_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"pol_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"pod_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"usa_edi_cd" },
                 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cnmv_yr" } ];
           
          InitColumns(cols);

          SetEditable(1);
          //SetColProperty("cnmv_evnt_dt", {Format:"####-##-## ##:##"} );
          SetCountPosition(0);
          SetColProperty(0 ,"cntr_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
//          SetColProperty(0 ,"check_digit" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"cntr_tpsz_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"prev_sts_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"bkg_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"rcv_term_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          // PDL:41082 mty_pln_no 추가 start by 2015/06/08 황미연
          SetColProperty(0 ,"mty_pln_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          // PDL:41082 mty_pln_no 추가 end
          SetColProperty(0 ,"cntr_seal_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"chss_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"mgst_no" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"mvmt_trsp_mod_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"dest_yd_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          SetColProperty(0 ,"spcl_cgo_flg" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
          FrozenCols=5;
//          SetSheetHeight(422);
          resizeSheet();
          }

    }
function doActionIBSheet(sheetObj, formObj, sAction) {
    sheetObj.ShowDebugMsg(false);
    var status=formObj.p_status.value;
    switch (sAction) {
    // activating SEARCH in case of VL, VD only 
    case IBSEARCH:
        if (validateForm(sheetObj, formObj, sAction)) {
            sheetObj.RemoveAll();
            if (etaEtdPass == false) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH;
        	
            if(document.form.oscar_bkg_flg.checked==true){
        		document.form.osca_bkg_flg.value="Y";
        	}else{
        		document.form.osca_bkg_flg.value="";
        	}
            
            sheetObj.DoSearch("EES_CTM_0406GS.do", FormQueryString(formObj) );
        }
        break;
    case IBSAVE: 
        if (!preChk && (status == "VL" || status == "VD")) {
            ComShowCodeMessage("CTM20074");
            return;
        }
        if (!sheetObj.GetSaveString(true)) {
             return;
        }
        
        if(document.form.oscar_bkg_flg.checked==true){
    		document.form.osca_bkg_flg.value="Y";
    	}else{
    		document.form.osca_bkg_flg.value="";
    	}
        
        strTime=new Date();
        y=strTime.getFullYear(); // getYear() => ie:2014, firefox:114
        m=strTime.getMonth() + 1;
        d=strTime.getDate();
        h=strTime.getHours();
        n=strTime.getMinutes();
        if (m < 10)   m="0" + m;
        if (d < 10)   d="0" + d;
        if (h < 10)   h="0" + h;
        if (n < 10)   n="0" + n;
        strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
        p_date=formObj.p_date0.value;
        rValue=Number(dateTimeDiff(strDt, p_date));
        var succCnt=1;
//        if (((status == "VL" || status == "VD") && rValue < 3)
//                || (status != "VL" && status != "VD")) {
        if (rValue < 3) {
            if (validateForm(sheetObj, formObj, sAction)) {
                var idx=1;
                var startId=1;
                if (sheetObj.LastRow()< 100) {
                    sendRows=sheetObj.LastRow();
                } else {
                    sendRows=Math.round(sheetObj.LastRow()/ maxThreadCount);
                }
                saveXml=new Array();
                var endId=startId + sendRows;
                var icnt=0;
                sheetObj.SelectCell(0, 0);
                formObj.f_cmd.value=MULTI;
                sheetObj.SetWaitImageVisible(0);
                ComOpenWait(true);
                while (startId <= sheetObj.LastRow()) {
                    if (sheetObj.LastRow()< endId)
                        endId=sheetObj.LastRow();
                    queryString=getFastString(sheetObj, startId, endId, false);
                    xmlHttpPost("EES_CTM_0406GS.do", queryString + "&AJAX=Y&" + FormQueryString(formObj), "rtnValueParses", startId);
                    sendCount++;
                    startId=Number(startId) + Number(sendRows) + 1;
                    endId=Number(endId) + Number(sendRows) + 1;
                }
                sheetObj.RemoveAll();
            }
        } else {
        	ComShowCodeMessage("CTM10053");
        	return;
        }
//        } else { //MODIFY01
//            if (!sheetObj.GetSaveString(true)) {
//                return;
//            }
//            ComShowCodeMessage("CTM10002");
//            formObj.f_cmd.value=MODIFY01;
//            sheetObj.SetWaitImageVisible(0);
//            ComOpenWait(true);
//            var rtnXml=sheetObj.GetSaveData("EES_CTM_0406GS.do", sheetObj.GetSaveString(true) + "&" + FormQueryString(formObj));
//            var resKey=ComGetEtcData(rtnXml, "TRANS_RESULT_KEY");
//            ComOpenWait(false);
//            if (resKey == 'F') {
//                sheetObj.LoadSearchData(rtnXml,{Sync:1} );
//            } else {
//                sheetObj.RemoveAll();
//            }
//        }
        break;
    }
}
/**
 * handling result after registering MOVEMENT 
 * @param rtnXml
 * @param startId
 * @return
 */
function rtnValueParses(rtnXml, startId) {
    var sheetObj=sheetObjects[0];
    sendCount--;
    saveXml[sendCount]=rtnXml;
    if (sendCount < 1) {
        for (var i=0; i<=saveXml.length-1; i++) {
            sheetObj.LoadSearchData(saveXml[i],{Append:1 , Sync:1} );
        }
        if (sheetObj.LastRow()> 0) {
            for (var i=1; i<=sheetObj.LastRow(); i++) {
                if (sheetObj.GetCellValue(i, "cntr_no").length >= 10) {
//                    sheetObj.SetCellValue(i, "check_digit",sheetObj.GetCellValue(i, "cntr_no").substring(10, 11),0);
//                    sheetObj.SetCellValue(i, "cntr_no",sheetObj.GetCellValue(i, "cntr_no").substring(0, 10),0);
                    sheetObj.SetCellValue(i, "prev_sts_cd",sheetObj.GetCellValue(i, "mvmt_sts_cd"),0);
                    
	              	var queryString="f_cmd=" + SEARCH31 + "&p_cntrno=" + sheetObj.GetCellValue(i, "cntr_no") ;
	                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
	                rtnValue=ComGetEtcData(xml, "rtnValue");
	                
	                if (rtnValue == "SH") {
                    	sheetObj.SetCellEditable(i, "mty_pln_no", 0);
	                }
                }
            }
            ComOpenWait(false);
            ComShowCodeMessage("CTM20113");
        } else {
            ComOpenWait(false);
            ComBtnDisable("btn_save");
        }
    }
}
/**
 * handling process for input validation
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return
 */
function validateForm(sheetObj, formObj, sAction) {
    with (formObj) {
        if (document.form.p_yard2.value== '') {
            ComShowCodeMessage("CTM10049", "yard cd");
            document.form.p_yard2.focus();
            return false;
        }
    }
    return true;
}
/**
 * calling POPUP.Vender Popup
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row, Col) {
	//alert("event name : sheet1_OnPopupClick(" + row + "," + sheetObj.ColSaveName(Col) + ")");
    switch (sheetObj.ColSaveName(Col)) {
        case "vndr_seq_btn":
            sUrl="/opuscntr/UI_CTM_0435.do";
            iWidth="700";
            iHeight="420";
            ComOpenPopup(sUrl, iWidth, iHeight, "getVndr", "1,0,1,1,1", true);
            break;
    }
}

/**
 * mapping result in grid after ending vender pop up successfully
 * @param aryPopupData
 * @param row
 * @param col
 * @param sheetIdx
 * @return
 */
function getVndr(aryPopupData, row, col, sheetIdx) {
    var formObj=document.form;
    var vndrSeq="";
    var vndrNm="";
    var usaEdiCd="";
    var i=0;
    for (i=0; i < aryPopupData.length; i++) {
        vndrSeq=vndrSeq + aryPopupData[i][2];
        if (aryPopupData.length == 1) {
            vndrNm=vndrNm + aryPopupData[i][4];
            usaEdiCd=usaEdiCd + aryPopupData[i][6];
        }
        if (i < aryPopupData.length - 1) {
            vndrSeq=vndrSeq + ",";
        }
    }
    sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "vndr_seq",vndrSeq,0);
    sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), "usa_edi_cd",usaEdiCd,0);
}

    /**
     * handling OnSearchEnd event of Sheet
     */
    function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
    	//alert("event name : sheet1_OnSearchEnd(" + ErrMsg + ")");
        ComOpenWait(false);
        if (ErrMsg == "") {
            ComBtnEnable("btn_downExcel");
            setElementDisable(true);
            preChk=false;
            if (document.form.p_status.value == "VL" || document.form.p_status.value == "VD") {
                with (sheetObj) {
                    if (RowCount()> 0) {
                        //RenderSheet(0);
                        for (var i=1; i<RowCount()+1; i++) {
                            SetCellEditable(i, "bkg_no",0);
                            SetCellEditable(i, "cnmv_evnt_dt",1);
                        }
                        //RenderSheet(1);
                    }
                }
            }
        }
        sheetObj.SetWaitImageVisible(1);
    }
    /**
     * getting focus position and saving it before grid data changed
     * checking change data existence
     * @param sheetObj
     * @param Row
     * @param Col
     * @return
     */
    function sheet1_OnBeforeEdit(sheetObj, Row, Col) {
    	//alert("event name : sheet1_OnBeforeEdit(" + row + "," + sheetObj.ColSaveName(Col) + ")");
        selectedRow=Row;
        var SaveName=sheetObj.ColSaveName(Col);
        if (Row < 1) return;
        if (SaveName == "cntr_no") {
            sheetContainer=sheetObj.GetCellValue(Row, Col);
        } else if (SaveName == "bkg_no") {
            // crntBkgValue is global variable for saving Booking number
            if (crntBkgValue != '') {
                sheetBkgValue=crntBkgValue;
                crntBkgValue=sheetObj.GetCellValue(Row, Col);
            } else {
                crntBkgValue=sheetObj.GetCellValue(Row, Col);
                sheetBkgValue=crntBkgValue;
            }
            crntBkgValue=sheetObj.GetCellValue(Row, Col);
        } else if (SaveName == "mty_pln_no") {	// mty_pln_no 추가 start by 2015/06/12 황미연
            // crntMtyPlnValue is global variable for saving Reference number
        	sheetMtyPln=sheetObj.GetCellValue(Row, Col);	// mty_pln_no 추가 end by 2015/06/12 황미연
        } else if (SaveName == "cnmv_evnt_dt") {
            // sheetEventDt is global variable for saving container number
            sheetEventDt=sheetObj.GetCellValue(Row, Col);
        } else {
            // initializing in case focused column is not container number and booking number.
            sheetContainer="";
            sheetBkgValue="";
            sheetMtyPln="";
            sheetContainerFlg=true;
            sheetBkgValueFlg=true;
            sheetMtyPlnFlg=true;
        }
    }
/**
 * comparing values for validation in case grid value changed
 * @param sheetObj
 * @param Row
 * @param Col
 * @param KeyCode
 * @param Shift
 * @return
 */
function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
	//alert("event name : sheet1_OnKeyUp(" + row + "," + sheetObj.ColSaveName(Col) + "," + KeyCode + "," + Shift + ")");
    newValue=sheetObj.GetEditText();
    var SaveName=sheetObj.ColSaveName(Col);
    errorRow=-1;
    errorBack=-1;
    if (Row < 1) return;
    if (SaveName == "cntr_no") {
        sheetContainerFlg=false;
        if (Row >= sheetObj.HeaderRows()) {
            if (newValue.length < 11) {
                return;
            } else if (KeyCode == 86) {
            //  return;
            } else if (Shift != 0) {
                return;
            } else if (KeyCode < 48 || (KeyCode > 57 && KeyCode < 65) || (KeyCode > 90 && KeyCode < 96) || KeyCode > 105) {
                return;
            }
            if (sheetContainer == newValue && sheetContainerFlg == true) {
                return;
            }
            sheetCheckValue(sheetObj, Row, Col, false);
            return;
        }
    } else if (SaveName == "bkg_no") {
        sheetBkgValueFlg=false;
        if(sheetObj.GetCellValue(Row,Col).length >= 12) {
        	sheetCheckValue(sheetObj, Row, Col, true);
        }
    }
}

function sheet1_OnChange(sheetObj, Row, Col, Value, OldValue, RaiseFlag) {
	//alert("event name : sheet1_OnChange(" + Row + "," + sheetObj.ColSaveName(Col) + "," + Value + "," + OldValue + "," + RaiseFlag + ")");
    var SaveName=sheetObj.ColSaveName(Col);
    switch (SaveName) {
	    case "cntr_no":
	    	if(sheetObj.GetCellValue(Row,Col).length == 0) {
//	            sheetObj.SetCellValue(Row, "check_digit","");
	            sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
	            sheetObj.SetCellValue(Row, "prev_sts_cd","");
	            sheetObj.SetRowBackColor(Row,"#FFFFFF");
            } else if (sheetObj.GetCellValue(Row,Col).length >= 10) {
            	if(document.form.oscar_bkg_flg.checked==true){
            		document.form.osca_bkg_flg.value="Y";
            	}else{
            		document.form.osca_bkg_flg.value="";
            	}
            		
	        	sheetCheckValue(sheetObj, Row, Col, true);
	        }
	    	break;
	    case "bkg_no":
	    	if(sheetObj.GetCellValue(Row,Col).length == 0) {
	            sheetObj.SetCellValue(Row, "bkg_no_split","");
	            sheetObj.SetCellValue(Row, "rcv_term_cd","");
            } else if(sheetObj.GetCellValue(Row,Col).length >= 12) {
	        	sheetCheckValue(sheetObj, Row, Col, true);
	        } else if(sheetObj.GetCellValue(Row,Col).length == 10) {
	        	sheetCheckValue(sheetObj, Row, Col, true);	        	
	        }
	    	break;
	    case "mty_pln_no":	// mty_pln_no 추가 start by 2015/06/12 황미연
	    	if(sheetObj.GetCellValue(Row,Col).length == 0) {
	            sheetObj.SetCellValue(Row, "mty_pln_no","");
            } else {
	        	sheetCheckValue(sheetObj, Row, Col, true);
	        }
	    	break;	// mty_pln_no 추가 end
	    case "cnmv_evnt_dt":
	    	if(sheetObj.GetCellValue(Row,Col).length == 0) {
	            sheetObj.SetCellValue(Row, "cnmv_evnt_dt","");
            } else if(sheetObj.GetCellValue(Row,Col).length >= 12) {
	        	sheetCheckValue(sheetObj, Row, Col, true);
	        }
	    	break;
    }
	
}

    /**
     * checking contaienr and booking when clicking cell of grid
     * @param sheetObj
     * @param OldRow
     * @param OldCol
     * @param NewRow
     * @param NewCol
     * @return
     */
    function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
    	//alert("event name : sheet1_OnSelectCell(" + OldRow + "," + sheetObj.ColSaveName(OldCol) + "," + NewRow + "," + sheetObj.ColSaveName(NewCol) + ")");
        if (NewRow == OldRow && OldCol == NewCol) {
            return;
        } else if (errorRow > 0 && (NewRow != errorRow || OldCol != NewCol)) {
            errorRow=-1;
            errorBack=-1;
            return;
        } else if (errorBack == 1 && (OldRow != NewRow || OldCol != NewCol)) {
            errorBack=-1;
            errorRow=-1;
        } else {
            var Row=OldRow;
            var Col=OldCol;
            var SaveName=sheetObj.ColSaveName(Col);
            if (SaveName == 'bkg_no' && sheetObj.GetCellValue(OldRow, "rcv_term_cd") == '') {
                errorRow=OldRow;
                errorBack=1;
                sheetCheckValue(sheetObj, OldRow, OldCol, true);
                return;
            }
            newValue=sheetObj.GetCellValue(Row, Col);
            if (Row < 1) return;
            if (SaveName == "cntr_no" && sheetObj.GetCellValue(Row, "cntr_no") != '' && sheetObj.GetCellValue(Row, "cntr_tpsz_cd") == '') {
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "cntr_no") {
                if ((sheetContainerFlg == false && Row >= sheetObj.HeaderRows()) || (sheetContainerFlg == false && sheetContainer != newValue)) {
                    sheetCheckValue(sheetObj, Row, Col, true);
                }
            } else if (SaveName == "bkg_no") {
                if (crntBkgValue != true) {
                    if ((sheetBkgValueFlg == false && NewRow >= sheetObj.HeaderRows()&& crntBkgValue != newValue)) sheetCheckValue(sheetObj, Row, Col, true);
                } else {
                    crntBkgValue=false;
                }
            } else if (SaveName == "mty_pln_no" && sheetObj.GetCellValue(Row, "mty_pln_no") != '') {	// mty_pln_no 추가 start by 2015/06/12 황미연
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "mty_pln_no") {
                if ((sheetMtyPlnFlg == false && Row >= sheetObj.HeaderRows()) || (sheetMtyPlnFlg == false && sheetMtyPln != newValue)) {
                    sheetCheckValue(sheetObj, Row, Col, true);
                }	// mty_pln_no 추가 end
            } else if (SaveName == "dest_yd_cd") {
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "mvmt_trsp_mod_cd") {
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "cnmv_evnt_dt") {
//                if (sheetObj.GetCellEditable(Row, Col) && sheetObj.GetRowStatus(Row) != "I") return;
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "chss_no") {
                if (sheetObj.GetCellValue(Row, Col) == '') return;
                sheetCheckValue(sheetObj, Row, Col, true);
            } else if (SaveName == "mgst_no") {
                if (sheetObj.GetCellValue(Row, Col) == '') return;
                sheetCheckValue(sheetObj, Row, Col, true);
            }
        }
    }
/**
 * validating real value
 * @param sheetObj
 * @param Row
 * @param Col
 * @param isOut
 * @return
 */
function sheetCheckValue(sheetObj, Row, Col, isOut) {
    var SaveName=sheetObj.ColSaveName(Col);
    var formObj=document.form;
    formObj=formObj;
    var status=formObj.p_status.value;
    // initializing error variables and BG color in Grid before checking
    GridForErr(sheetObj, Row, "S");
    switch (SaveName) {
    case "cntr_no":
        if (isOut)
            cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
        else
            cntr_no=sheetObj.GetEditText();
        
        if (cntr_no.length < 1) {
            sheetContainerFlg=true;
            return;
        }

        if (cntr_no.length < 10 && isOut == false) return;
        
        var p_yard2SelCode="";
        p_yard2SelCode = document.form.p_yard2.value;
        
        var queryString="f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + formObj.p_yard1.value;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        //alert("CNTRNO rtnValue : " + rtnValue);
        if (rtnValue == null) {
            clearGridForErr(sheetObj, Row, "E", "C");
            ComShowCodeMessage("CTM10004");
            if (sheetObj.GetCellEditable(Row, Col)) {
                sheetObj.SelectCell(Row, Col, true, "");
            } else {
                sheetObj.RemoveAll();
                formObj.p_cntrno.disabled=false;
                formObj.p_cntrno.value="";
                ComSetFocus(formObj.p_cntrno);
            }
            return;
        } else {
            sheetObj.SetRowBackColor(Row,"#FFFFFF"); //initialize row backcolor
            rtnStr=rtnValue.split("|");
            vr=rtnStr[0].substring(10, 11);
            if (sheetObj.GetCellValue(Row, "cntr_tpsz_cd") == '' && sheetObj.GetCellValue(Row, "cntr_no").substring(10, 11) != '' && vr != sheetObj.GetCellValue(Row, "cntr_no").substring(10, 11)) {
                msg=ComGetMsg("CTM20111") + sheetObj.GetCellValue(Row, "cntr_no").substring(10, 11) + ":" + vr;
                sheetObj.SetCellValue(Row, "cntr_tpsz_cd",'');
//                sheetObj.SetCellValue(Row, "check_digit",'');
                alert("CNTRNO msg : " + msg);
                if (sheetObj.GetCellEditable(Row, Col)) {
                    sheetObj.SelectCell(Row, Col, true, "");
                } else {
                    sheetObj.RemoveAll();
                    formObj.p_cntrno.disabled=false;
                    formObj.p_cntrno.value="";
                    ComSetFocus(formObj.p_cntrno);
                }
                return;
            }
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd",rtnStr[2]);
            sheetObj.SetCellValue(Row, "prev_sts_cd",rtnStr[1]);
            sheetObj.SetCellValue(Row, "cntr_no",rtnStr[0]);
            if (rtnStr[7] == 'Y' && rtnStr[4] == 'I' && (status != 'MT' && status != 'OP')) {
                ComShowCodeMessage("CTM10005");
                sheetObj.SetCellValue(Row, "cntr_tpsz_cd",'');
//                sheetObj.SetCellValue(Row, "check_digit",'');
                if (sheetObj.GetCellEditable(Row, Col)) {
                    sheetObj.SelectCell(Row, Col, true, "");
                } else {
                    sheetObj.RemoveAll();
                    formObj.p_cntrno.disabled=false;
                    formObj.p_cntrno.value="";
                    ComSetFocus(formObj.p_cntrno);
                }
                return;
            }
            if (rtnStr[8] == "0" && status != "MT") {
                ComShowCodeMessage("CTM20119");
                sheetObj.SetCellValue(Row, "cntr_tpsz_cd",'');
//                sheetObj.SetCellValue(Row, "check_digit",'');
                if (sheetObj.GetCellEditable(Row, Col)) {
                    sheetObj.SelectCell(Row, Col, true, "");
                } else {
                    sheetObj.RemoveAll();
                    formObj.p_cntrno.disabled=false;
                    formObj.p_cntrno.value="";
                    ComSetFocus(formObj.p_cntrno);
                }
                return;
            }
            if (status == "VL" || status == "VD") {
                sheetObj.SetCellEditable(i, "cnmv_evnt_dt",0);
            } else {
                sheetObj.SetCellEditable(i, "cnmv_evnt_dt",1);
            }
//            if (vr != null)
//                sheetObj.SetCellValue(Row, "check_digit",vr);
            /*******************************************************************
             * checking container status
             ******************************************************************/
            switch (status) {
            /**
             *  rtnStr[0] : container no
             *  rtnStr[1] : container current status
             *  rtnStr[2] : container type/size
             *  rtnStr[3] : container current yard
             *  rtnStr[4] : container ACTIVE Y/N
             *  rtnStr[5] : user server & container region
             *  rtnStr[6] : container out Y/N
             *  rtnStr[7] : new container Y/N
             *  rtnStr[8] : MVMT count
             *  rtnStr[9] : Full container flag		// by 2015/06/08
             *  rtnStr[10] : Lease Term Code		// by 2016/06/24
             *  rtnStr[11] : Damage Flag		// by 2016/07/28
             */
            case "OP":
                /*********************************************************************************
                 * permitting to create OP in case user's region and container server are same
                 * permitting to create in case container is Active
                 * permitting to create in case of status is not 'Return'
                 **********************************************************************************/
                if (rtnStr[5] == 'Y') {
                    if ((rtnStr[1] == 'MT' || rtnStr[1] == 'CM')
                            && rtnStr[3] == formObj.p_yard1.value + p_yard2SelCode) {
                        if (rtnStr[4] == 'I' && rtnStr[4] != 'A') {
                            ComShowCodeMessage("CTM10005");
                            // alert ("InActive Container No!");
                            clearGridForErr(sheetObj, Row, "E", "C");
                            if (sheetObj.GetCellEditable(Row, Col)) {
                                sheetObj.SelectCell(Row, Col, true, "");
                            } else {
                                sheetObj.RemoveAll();
                                formObj.p_cntrno.disabled=false;
                                formObj.p_cntrno.value="";
                                ComSetFocus(formObj.p_cntrno);
                            }
                            return;
                        } else if (rtnStr[6] != 'N') {
                            ComShowCodeMessage("CTM10006");
                            // alert ("Immediately Exit Container");
                            clearGridForErr(sheetObj, Row, "E", "C");
                            if (sheetObj.GetCellEditable(Row, Col)) {
                                sheetObj.SelectCell(Row, Col, true, "");
                            } else {
                                sheetObj.RemoveAll();
                                formObj.p_cntrno.disabled=false;
                                formObj.p_cntrno.value="";
                                ComSetFocus(formObj.p_cntrno);
                            }
                            return;
                        } else if (rtnStr[11] == 'Y') {
                        	if (!ComShowCodeConfirm("CTM99999", "This Container is Damaged. Do you want to continue ?")) {
                                formObj.p_cntrno.value="";
                                sheetObj.SetCellValue(Row, Col, "");
                                ComSetFocus(formObj.p_cntrno);
                            }
                        }
                    } else {
                        //alert ("This Is Not A Empty Container In This Yard!")
                        ComShowCodeMessage("CTM20075");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                        return;
                    }
                } else {
                    //alert ("Container Is Not Located In This Country!");
                    ComShowCodeMessage("CTM10007");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                }
                break;
            case "OC":
                /*********************************************************************************
                 * permitting to create OP in case user's region and container server are same
                 * permitting to create in case container is Active
                 * permitting to create in case of status is not 'Return'
                 **********************************************************************************/
                if (rtnStr[5] == 'Y') {
                    if (rtnStr[6] != 'N') {
                        //alert ("Immediately Exit Container");
                        ComShowCodeMessage("CTM10006");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                        return;
                    } else if (rtnStr[1].substring(0, 1) != 'C') {
                        if (rtnStr[5] != 'Y') {
                            //alert ("Container Is Not Located In This Country!");
                            ComShowCodeMessage("CTM10007");
                            clearGridForErr(sheetObj, Row, "E", "C");
                            if (sheetObj.GetCellEditable(Row, Col)) {
                                sheetObj.SelectCell(Row, Col, true, "");
                            } else {
                                sheetObj.RemoveAll();
                                formObj.p_cntrno.disabled=false;
                                formObj.p_cntrno.value="";
                                ComSetFocus(formObj.p_cntrno);
                            }
                            return;
                        } else {
                            // auto matching bkg_no to cntr_no 추가 start by 2015/06/08 황미연
                            if (rtnStr[1] == "OP" || rtnStr[1] == "OC") {
                            	var queryString="f_cmd=" + SEARCH27 + "&p_cntrno=" + cntr_no;
                                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                                rtnValue=ComGetEtcData(xml, "rtnValue");
                            	var bookingno = rtnValue;
                            	sheetObj.SetCellValue(Row, "bkg_no", bookingno);
                            } else if (rtnStr[1] == "TN" || rtnStr[1] == "EN") {
                            	strQuery="f_cmd=" + SEARCH07 + "&cntr_no=" + cntr_no;
                            	rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
                                rtnValue=ComGetEtcData(rtnXml, "rtnStr");
                                if (rtnValue == "OC"){
                                	var queryString="f_cmd=" + SEARCH27 + "&p_cntrno=" + cntr_no;
                                    xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                                    rtnValue=ComGetEtcData(xml, "rtnValue");
                                	var bookingno = rtnValue;
                                	sheetObj.SetCellValue(Row, "bkg_no", bookingno);
                                }
                            } else if (rtnStr[1] == "MT" || rtnStr[1] == "CM") {
                            	 if (rtnStr[11] == 'Y') {
                                 	if (!ComShowCodeConfirm("CTM99999", "This Container is Damaged. Do you want to continue ?")) {
                                        sheetObj.SetCellValue(Row, Col, "");
                                        formObj.p_cntrno.value="";
                                        ComSetFocus(formObj.p_cntrno);
                                     }
                                 }
                            }
                            // auto matching bkg_no to cntr_no 추가 end
                        }
                    } else {
                        //alert ("This Is Not A Adequate Container!");
                        ComShowCodeMessage("CTM10008");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                        return;
                    }
                } else {
                    //alert ("Container Is Not Located In This Country!");
                    ComShowCodeMessage("CTM10007");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                }
                break;
            case "VL":
                /*********************************************************************************
                 * permitting to create OP in case user's region and container server are same
                 * permitting to create in case container is Active
                 * permitting to create in case of status is not 'Return'
                 * Can't create container after VL
                 **********************************************************************************/
                if (rtnStr[6] != 'N') {
                    //alert ("Immediately Exit Container");
                    ComShowCodeMessage("CTM10006");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                } else if (rtnStr[1] == 'VL') {
                    //alert ("Aleady 'VL' Container!");
                    ComShowCodeMessage("CTM20076", "VL");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                } else {
                    /****************************************
                     *   in case of VL, FULL/EMPTY
                     *****************************************/
                    strQuery="f_cmd=" + SEARCH04 + "&cntr_no=" + sheetObj.GetCellValue(Row, "cntr_no");
                    strQuery=strQuery + "&crnt_vsl_cd=" + sheetObj.GetCellValue(Row, "crnt_vsl_cd");
                    strQuery=strQuery + "&crnt_skd_voy_no=" + sheetObj.GetCellValue(Row, "crnt_skd_voy_no");
                    strQuery=strQuery + "&crnt_skd_dir_cd=" + sheetObj.GetCellValue(Row, "crnt_skd_dir_cd");
                    strQuery=strQuery + "&pol_cd=" + sheetObj.GetCellValue(Row, "pol_cd");
                    strQuery=strQuery + "&mvmt_sts_cd=" + sheetObj.GetCellValue(Row, "mvmt_sts_cd");
                    strQuery=strQuery + "&p_type1=" + formObj.p_type1.value;
                    strQuery=strQuery + "&osca_bkg_flg=" + formObj.osca_bkg_flg.value;
                    // strQuery = strQuery + "&p_type2=" +
                    // formObj.p_type2.value;
                    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
                    rtnStr=ComGetEtcData(rtnXml, "rtnStr");
                    if (rtnStr == -1) {
                        //alert ("Invalid loading Container No!");
                        ComShowCodeMessage("CTM20099");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                        return;
                    }
                }
                break;
            case "VD":
                /*********************************************************************************
                 * permitting to create OP in case user's region and container server are same
                 * permitting to create in case container is Active
                 * permitting to create in case container is not out
                 * unable to create container in case of VD or VL
                 **********************************************************************************/
                if (rtnStr[1] == 'VD') {
                    //alert ("Aleady 'VD' Container!");
                    ComShowCodeMessage("CTM20076", "VD");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                } else {
                    strQuery="f_cmd=" + SEARCH04 + "&cntr_no="
                    + sheetObj.GetCellValue(Row, "cntr_no");
                    strQuery=strQuery + "&crnt_vsl_cd="
                    + sheetObj.GetCellValue(Row, "crnt_vsl_cd");
                    strQuery=strQuery + "&crnt_skd_voy_no="
                    + sheetObj.GetCellValue(Row, "crnt_skd_voy_no");
                    strQuery=strQuery + "&crnt_skd_dir_cd="
                    + sheetObj.GetCellValue(Row, "crnt_skd_dir_cd");
                    strQuery=strQuery + "&pod_cd="
                    + sheetObj.GetCellValue(Row, "pod_cd");
                    strQuery=strQuery + "&pol_cd="
                    + sheetObj.GetCellValue(Row, "pol_cd");
                    strQuery=strQuery + "&mvmt_sts_cd="
                    + sheetObj.GetCellValue(Row, "mvmt_sts_cd");
                    strQuery=strQuery + "&p_type1=" + formObj.p_type1.value;
                    strQuery=strQuery + "&osca_bkg_flg=" + formObj.osca_bkg_flg.value;
                    // strQuery = strQuery + "&p_type2=" +
                    // formObj.p_type2.value;
                    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do",
                            strQuery);
                    rtnStr=ComGetEtcData(rtnXml, "rtnStr");
                    if (rtnStr == "-1") {
                        //alert ("Invalid Discharge Container No");
                        ComShowCodeMessage("CTM20077");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                        return;
                    }
                }
                break;
            case "TS":
                /*********************************************************************************
                 * permitting to create OP in case user's region and container server are same
                 * permitting to create in case last status is EN or TN
                 * permitting to create in case container is not out
                 **********************************************************************************/
                if (rtnStr[5] == 'Y') {
                    if (rtnStr[1] != 'TS') {
                        if ((rtnStr[1] == 'EN') || (rtnStr[1] == 'TN')) {
                        } else {
                            //alert ("Not TS Container Error!");
                            ComShowCodeMessage("CTM20078");
                            clearGridForErr(sheetObj, Row, "E", "C");
                            if (sheetObj.GetCellEditable(Row, Col)) {
                                sheetObj.SelectCell(Row, Col, true, "");
                            } else {
                                sheetObj.RemoveAll();
                                formObj.p_cntrno.disabled=false;
                                formObj.p_cntrno.value="";
                                ComSetFocus(formObj.p_cntrno);
                            }
                            return;
                        }
                    } else {
                        //alert ("UnAceeptable Container!");
                        ComShowCodeMessage("CTM20078");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                    }
                        return;
                    }
                } else {
                    //alert ("Container Is Not Located In This Country!");
                    ComShowCodeMessage("CTM10007");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                }
                break;
            case "MT":
                /*********************************************************************************
                 * in case of last status is CM or not DOM MVMT
                 **********************************************************************************/
                if ((rtnStr[1] == 'CM') || (rtnStr[1] == 'CP') || (rtnStr[1] == 'CE') || (rtnStr[1] == 'CT')
                        || (rtnStr[1].substring(0, 1) != 'C')) {
                    if (rtnStr[7] == 'Y') {
                    } else if (rtnStr[5] != 'Y') {
                        //alert ("Container Is Not Located In This Country");
                        ComShowCodeMessage("CTM10007");
                        clearGridForErr(sheetObj, Row, "E", "C");
                        if (sheetObj.GetCellEditable(Row, Col)) {
                            sheetObj.SelectCell(Row, Col, true, "");
                        } else {
                            sheetObj.RemoveAll();
                            formObj.p_cntrno.disabled=false;
                            formObj.p_cntrno.value="";
                            ComSetFocus(formObj.p_cntrno);
                        }
                    }
                    // 2015/06/08
                    if (rtnStr[9] == "N" && (rtnStr[1] == "MT" || rtnStr[1] == "EN" || rtnStr[1] == "TN" || rtnStr[1] == "CM")) {
                    	if (rtnStr[10] == "SH") {
                    		// Inactivate EQR Ref. No.
                        	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
	                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
                    	} else {
                    		// Activate EQR Ref. No.
                        	sheetObj.SetCellEditable(Row, "mty_pln_no", 1);
                        	
                        	if (rtnStr[9] == "N" && ( rtnStr[1] == "EN" || rtnStr[1] == "TN" )) {
                            	var queryString="f_cmd=" + SEARCH28 + "&p_cntrno=" + cntr_no;
                                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                                rtnValue=ComGetEtcData(xml, "rtnValue");
                            	var mtyPlnNo = rtnValue; 
                            	sheetObj.SetCellValue(Row, "mty_pln_no", mtyPlnNo);
                        	}
                    	}
                    } else {
                    	// Inactivate EQR Ref. No.
                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
                    }
                    return;
                } else {
                    //alert ("This Is Not A Adequate Container");
                    ComShowCodeMessage("CTM10008");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                }
                break;
            case "CM":
                if (rtnStr[1] == 'MT' || rtnStr[1].substring(0, 1) == 'C') {
                } else {
                    //alert ("This Is Not A Adequate Container");
                    ComShowCodeMessage("CTM10008");
                    clearGridForErr(sheetObj, Row, "E", "C");
                    if (sheetObj.GetCellEditable(Row, Col)) {
                        sheetObj.SelectCell(Row, Col, true, "");
                    } else {
                        sheetObj.RemoveAll();
                        formObj.p_cntrno.disabled=false;
                        formObj.p_cntrno.value="";
                        ComSetFocus(formObj.p_cntrno);
                    }
                    return;
                }
                break;
                // 2015/06/08
            case "EN":
            case "TN":
                if (rtnStr[9] == "N" && (rtnStr[1] == "MT" || rtnStr[1] == "EN" || rtnStr[1] == "TN" || rtnStr[1] == "CM")) {
                	if (rtnStr[10] == "SH") {
                		// Inactivate EQR Ref. No.
                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
                	} else {
                    	// Activate EQR Ref. No.
                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 1);
                	}
                } else {
                	// Inactivate EQR Ref. No.
                	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
                	sheetObj.SetCellValue(Row, "mty_pln_no", "");
                }
                break;
            }
        }
        /**********************************************************
         *  checking conatiner booked for multiple bookings
         **********************************************************/
        if (status == 'OP' || status == 'OC') {
            if (sheetObj.GetCellValue(Number(Row) + 1, "cntr_no") == cntr_no) {
                sheetContainerFlg=true;
                return;
            }
            queryString="f_cmd=" + SEARCH01 + "&cntr_no=" + rtnStr[0];
            sheetObj0=sheetObjects[1];
            sheetObj0.RemoveAll();
            xml = sheetObj0.DoSearch("EES_CTM_0406GS.do", queryString );
            if (sheetObj0.LastRow()>= 1) {
                if (sheetObj0.GetCellValue(1, "bkg_no") != '') {
                    sheetObj.SetCellValue(Row, "bkg_no") =sheetObj0.GetCellValue(1,"bkg_no");
                    sheetObj.SetCellValue(Row, "rcv_term_cd") = sheetObj0.GetCellValue(1, "rcv_term_cd");
                }
                sheetObj.SetCellEditable(Row, "bkg_no",1);
                vvdCd=formObj.p_vvd.value;
                for (i=2; i <= sheetObj0.LastRow(); i++) {
                    sheetObj.DataInsert();
                    iRow=Number(Row) + (i - 1);
                    for (j=3; j <= 9; j++) {
                        sheetObj.SetCellValue(iRow, j ) = sheetObj0.GetCellValue(i, j);
                        sheetObj.SetCellEditable(iRow, "bkg_no",1);
                    }
                    sheetObj.SetCellValue(iRow, "cnmv_evnt_dt",formObj.p_date0.value,0);
                    sheetObj.SetCellValue(iRow, "org_yd_cd",formObj.p_yard1.value + formObj.p_yard2.value);
                    sheetObj.SetCellValue(iRow, "cnmv_sts_cd",formObj.p_status.value,0);
                    sheetObj.SetCellValue(iRow, "crnt_vsl_cd",vvdCd.substring( 0, 4));
                    sheetObj.SetCellValue(iRow, "crnt_skd_voy_no",vvdCd.substring(4, 8));
                    sheetObj.SetCellValue(iRow, "crnt_skd_dir_cd",vvdCd.substring(8, 9));
                    sheetObj.SetCellValue(iRow, "pol_cd",formObj.p_pol.value,0);
                    sheetObj.SetCellValue(iRow, "pod_cd",formObj.p_pod.value,0);
                    sheetObj.SetCellValue(iRow, "mvmt_sts_cd",formObj.p_status.value,0);
                    sheetObj.SetCellValue(iRow, "cnmv_yr",form.p_date0.value.substring(0, 4),0);
                }
            }
            rcv_term_cd=sheetObj.GetCellValue(Row, "rcv_term_cd");
            bkg_no=sheetObj.GetCellValue(Row, "bkg_no");
            if (bkg_no != '' && rcv_term_cd == '') {
                sheetCheckValue(sheetObj, Row, "bkg_no", true)
            }
        }
        sheetContainerFlg=true;
        break;
        
    case "bkg_no":
        if (isOut) {
            bkg_no=sheetObj.GetCellValue(Row, "bkg_no");
        } else {
            bkg_no=sheetObj.GetEditText();
        }
        if (bkg_no.length < 1) {
            return;
        }
        if ( !(bkg_no.length == 12 || bkg_no.length == 10) && isOut == false)
            return;
        
        cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
        if(bkg_no.length==10){
        	if (status == 'OP' || status == 'OC') {
        		strQuery="f_cmd=" + SEARCH22 + "&p_cntrno=" + cntr_no + "&p_bkg_no=" + bkg_no;
        		rtnXml=sheetObj.GetSearchData("CTMCommonGS.do", strQuery);
                rtnValue=ComGetEtcData(rtnXml, "rtnValue");
                //alert("BOOKING rtnValue : " + rtnValue);
                if (rtnValue == 0) {
                    sheetObj.SetCellValue(Row, "bkg_no","");
                    sheetObj.SetCellValue(Row, "bkg_no_split","");
                    sheetObj.SetCellValue(Row, "rcv_term_cd","");
//                    clearGridForErr(sheetObj, Row, "E", "B");
                    ComShowCodeMessage("CTM30016", "["+bkg_no+"]");
                    sheetBkgValueFlg=false;
                    crntBkgValue=true;
                    // crntBkgValue = sheetBkgValue ;
                    sheetObj.SelectCell(Row, Col, true);
                }
        	}
        	formObj.f_cmd.value=SEARCH21;
        }else{
        	formObj.f_cmd.value=SEARCH17;	
        }
        
        sheetObj.SetCellValue(Row, "bkg_no_split","");
        sheetObj.SetCellValue(Row, "rcv_term_cd","");
        if (bkg_no.length < 1) {
            return;
        }
        queryString="f_cmd=" + formObj.f_cmd.value + "&p_bkg_no=" + bkg_no + "&p_bkg_no_split=";
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        //alert("BOOKING rtnValue : " + rtnValue);
        if (rtnValue == "") {
            sheetObj.SetCellValue(Row, "bkg_no_split","");
            sheetObj.SetCellValue(Row, "rcv_term_cd","");
            clearGridForErr(sheetObj, Row, "E", "B");
            ComShowCodeMessage("CTM20999");
            sheetBkgValueFlg=false;
            crntBkgValue=true;
            // crntBkgValue = sheetBkgValue ;
            sheetObj.SelectCell(Row, Col, true);
        } else {
            clearGridForErr(sheetObj, Row, "", "B");
            rtnStr=rtnValue.split("||");
            if (rtnStr.length < 2) {
                sheetObj.SetCellValue(Row, "bkg_no_split","");
                sheetObj.SetCellValue(Row, "rcv_term_cd","");
                sheetBkgValueFlg=true;
                crntBkgValue=true;
                // crntBkgValue = sheetBkgValue ;
                sheetObj.SelectCell(Row, Col, true);
            } else {
                sheetObj.SetCellValue(Row, "bkg_no_split",rtnStr[0]);
                sheetObj.SetCellValue(Row, "rcv_term_cd",rtnStr[1]);
                sheetBkgValueFlg=true;
                crntBkgValue=false;
            }
            if (cntr_no.length < 1)
                ComBtnEnable("btn_select");
            else
                ComBtnDisable("btn_select");
            tpsz_cd=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
            if (cntr_no != '' && tpsz_cd == '') {
                sheetCheckValue(sheetObj, Row, "cntr_no", true)
                sheetObj.SetCellValue(Row, "err_msg","",0);
            }
        }
        break;
    case "mty_pln_no":	// mty_pln_no validation 추가 start by 2015/06/12 황미연
        if (isOut)
            mty_pln_no=sheetObj.GetCellValue(Row, "mty_pln_no");
        else
            mty_pln_no=sheetObj.GetEditText();
        
        if (mty_pln_no.length < 1) {
            sheetMtyPlnFlg=true;
            return;
        }

        cntr_no=sheetObj.GetCellValue(Row, "cntr_no");
         
        //Activate after 1st August
//        var queryString="f_cmd=" + SEARCH29 + "&mty_pln_no=" + mty_pln_no;
//        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
//        rtnValue=ComGetEtcData(xml, "rtnValue");
//        if (rtnValue == "N") {
//            ComShowCodeMessage("CTM20998");
//        	sheetObj.SetCellValue(Row, "mty_pln_no", "");
//            sheetObj.SelectCell(Row, Col, true);
//            return;
//        } else {
            ComBtnDisable("btn_select");    
            tpsz_cd=sheetObj.GetCellValue(Row, "cntr_tpsz_cd");
            if (cntr_no != '' && tpsz_cd == '') {
                sheetCheckValue(sheetObj, Row, "cntr_no", true)
                sheetObj.SetCellValue(Row, "err_msg","",0);
            }
//        }
        break;	// mty_pln_no validation 추가 end by 2015/06/12 황미연
    case "vndr_seq":
        break;
    case "dest_yd_cd":
        ydCd=sheetObj.GetCellValue(Row, "dest_yd_cd");
        if (ydCd.length < 1)
            return;
        queryString="f_cmd=" + SEARCH14 + "&p_yard1=" + ydCd;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        if (rtnValue == null) {
            ComShowCodeMessage("CTM10001");
            sheetObj.SelectCell(Row, Col, true);
        }
        break;
    case "cnmv_evnt_dt":
        var p_date=sheetObj.GetCellText(Row, "cnmv_evnt_dt");
        if (p_date == '') {
            ComShowCodeMessage("CTM10049", "event date");
            sheetObj.SelectCell(Row, Col, true, document.form.p_date0.value);
            return;
        }
        var status=document.form.p_status.value
        var strTime=new Date();
        var y=strTime.getFullYear();
        var m=strTime.getMonth() + 1;
        var d=strTime.getDate();
        var h=strTime.getHours();
        var n=strTime.getMinutes();
        if (m < 10) m="0" + m;
        if (d < 10) d="0" + d;
        if (h < 10) h="0" + h;
        if (n < 10) n="0" + n;
        var strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
        var rValue=Number(dateTimeDiff(strDt, p_date));
        if (rValue > 3) {
            ComShowCodeMessage("CTM10053");
            // alert ("Event date can't exceed+0 Days from today.");
            sheetObj.SelectCell(Row, Col, true, document.form.p_date0.value);
            return;
        }
        break;
    case "mvmt_trsp_mod_cd":
        val=sheetObj.GetCellValue(Row, "mvmt_trsp_mod_cd");
        if (val == '')
            return;
        if (val != 'T' && val != 'R' && val != 'B') {
            ComShowCodeMessage("CTM10016");
            sheetObj.SelectCell(Row, Col, true);
        }
        break;
    case "mgst_no":
        queryString=""; // chss_no
        mgset=sheetObj.GetCellValue(Row, "mgst_no");
        queryString="f_cmd=" + SEARCH07 + "&p_mgset=" + mgset;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        rtnName=ComGetEtcData(xml, "rtnName");
        if (rtnValue != 'OK') {
            ComShowCodeMessage("CTM20115");
            sheetObj.SetCellValue(Row, Col,"",0);
            sheetObj.SelectCell(Row, Col);
        }
        break;
    case "chss_no":
        queryString=""; // chss_no
        p_chassis_no=sheetObj.GetCellValue(Row, "chss_no");
        queryString="f_cmd=" + SEARCH08 + "&p_chassis_no=" + p_chassis_no;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        rtnName=ComGetEtcData(xml, "rtnName");
        if (rtnValue != 'OK') {
            if (!ComShowCodeConfirm("CTM20116")) {
                sheetObj.SetCellValue(Row, Col,"",0);
                sheetObj.SelectCell(Row, Col);
                return;
            }
        }
        break;
    }
}
    
 /**
  * @param sheetObj
  * @param Row       : Grid Row Number
  * @param Tp         : Error Type. E : Error. S : Success
  * @param Col       : Cell. C : Container. B : Booking
  * @return
  */
function clearGridForErr(sheetObj, Row, Tp, Col) {
    if (Tp == "E") {
        sheetContainerFlg=false;
        if (Col == "C") {
            sheetObj.SetCellValue(Row, "cntr_no","");
//            sheetObj.SetCellValue(Row, "check_digit","");
            sheetObj.SetCellValue(Row, "cntr_tpsz_cd","");
            sheetObj.SetCellValue(Row, "prev_sts_cd","");
        } else {
            sheetObj.SetCellValue(Row, "rcv_term_cd","");
        }
        focusCheck=false;
        setErr(Row);
        errorRow=Row;
        errorBack=1;
    } else {
        //sheetObj.RowBackColor(Row) = "#F1F1F1";
        //sheetObj.RenderSheet(0);
        sheetObj.SetRowBackColor(Row,0);
        for (xx=1; xx <= sheetObj.LastCol(); xx++) {
            if (!sheetObj.GetCellEditable(Row, xx))
                sheetObj.SetCellBackColor(Row, xx,"#F1F1F1");
        }
        //sheetObj.RenderSheet(1);
        errorRow=-1;
        errorBack=-1;
    }
}
function preCheck() {
    if (!sheetObjects[0].GetSaveString(true)) {
        return;
    }
    
    if(document.form.oscar_bkg_flg.checked==true){
		document.form.osca_bkg_flg.value="Y";
	}else{
		document.form.osca_bkg_flg.value="";
	}
    
    var sheetObj=sheetObjects[0];
    if (sheetObj.LastRow()< 1)
        return;
    var formObj=document.form;
    var status=formObj.p_status.value;
    sheetObj.SetWaitImageVisible(0);
    errCount=0;
    formObj.f_cmd.value=SEARCH03;
    ComOpenWait(true);
    if (status == 'VL' || status == 'VD') {
        formObj.f_cmd.value=SEARCH03;
        var startId=1;
        if (sheetObj.LastRow()< 100)
            sendRows=sheetObj.LastRow();
        else {
            sendRows=Math.round(sheetObj.LastRow()/ maxThreadCount);
        }
        var endId=startId + sendRows;
        while (startId <= sheetObj.LastRow()) {
            if (sheetObj.LastRow()< endId)
                endId=sheetObj.LastRow();
            queryString=getFastString(sheetObj, startId, endId, false);
            xmlHttpPost("EES_CTM_0406GS.do", queryString + "&AJAX=Y&"
                    + FormQueryString(formObj), 'rtnpreCheckParses', startId);
            sendCount++;
            sleep(2000);
            startId=Number(startId) + Number(sendRows) + 1;
            endId=Number(endId) + Number(sendRows) + 1;
        }
    }
}
function rtnpreCheckParses(rtnXml, startId) {
    rtnStr=ComGetEtcData(rtnXml, "rtnStr");
    errCnt=ComGetEtcData(rtnXml, "errCount");
    rtnStrV=rtnStr.split("||")
    for (i=0; i < rtnStrV.length - 1; i++) {
        if (rtnStrV[i] != 'null' && rtnStrV[i] != '') {
            sheetObj.SetCellValue(Number(startId) + Number(i), "err_msg",rtnStrV[i]);
            errCount=Number(errCount) + Number(1);
        }
    }
    sendCount--;
    if (sendCount < 1) {
        ComOpenWait(false);
        if (errCount == 0) {
            //alert ("There is no Problem to update");
            ComShowCodeMessage("CTM10018");
            preChk=true;
            ComBtnEnable("btn_save");
        } else {
            preChk=true;
            ComShowCodeMessage("CTM20080", errCnt);
            ComBtnEnable("btn_save");
        }
    }
}
function checkValidation(sheetObj) {
    var formObj=document.form;
    var status=formObj.p_status.value;
    var vvdCd=formObj.p_vvd.value;
    var checkDigit="";
    p_yardValue=document.form.p_yard2.value;
    
    for (idx=1; idx <= sheetObj.LastRow(); idx++) {
        cntr_no=sheetObj.GetCellValue(idx, "cntr_no").replace(" ", "");
        checkDigit="";
        if (cntr_no.length >= 10) {
            checkDigit=cntr_no.substring(10, 11);
//            cntr_no=cntr_no.substring(0, 10);
            sheetObj.SetCellValue(idx, "cntr_no",cntr_no);
//            sheetObj.SetCellValue(idx, "check_digit",checkDigit);
        } else if (cntr_no.length == 0) {
            sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10004"),0);
            continue;
        }
        var p_yard1=formObj.p_yard1.value;
        var p_yard2=document.form.p_yard2.value;
        sheetObj.SetCellValue(idx, "org_yd_cd",formObj.p_yard1.value + document.form.p_yard2.value);
        sheetObj.SetCellValue(idx, "mvmt_sts_cd",formObj.p_status.value,0);
        sheetObj.SetCellValue(idx, "crnt_vsl_cd",vvdCd.substring(0, 4));
        sheetObj.SetCellValue(idx, "crnt_skd_voy_no",vvdCd.substring(4, 8));
        sheetObj.SetCellValue(idx, "crnt_skd_dir_cd",vvdCd.substring(8, 9));
        
        cnmvEvntDt=sheetObj.GetCellValue(idx, "cnmv_evnt_dt");
        if (cnmvEvntDt == '') {
            sheetObj.SetCellValue(idx, "cnmv_evnt_dt",document.form.p_date0.value,0);
        }
        queryString="f_cmd=" + SEARCH20 + "&p_cntrno=" + cntr_no + "&p_yard1=" + formObj.p_yard1.value;
        xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
        rtnValue=ComGetEtcData(xml, "rtnValue");
        if (rtnValue == null) {
            sheetObj.SetCellValue(idx, "err_msg","Not Exist Container",0);
            setErr(idx);
        } else {
            rtnStr=rtnValue.split("|");
            sheetObj.SetCellValue(idx, "cntr_tpsz_cd",rtnStr[2]);
            sheetObj.SetCellValue(idx, "prev_sts_cd",rtnStr[1]);
            sheetObj.SetCellValue(idx, "cnmv_yr",document.form.p_date0.value.substring(0, 4));
            vr=rtnStr[0].substring(10, 11);
            if (rtnStr[8] == '0' && status != 'MT') {
                sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20119"),0);
                GridForErr(sheetObj, idx, "E");
            }
            if (rtnStr[7] == 'Y' && rtnStr[4] == 'I'
                    && (status != 'MT' && status != 'OP')) {
                sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10005"),0);
                GridForErr(sheetObj, idx, "E");
                continue;
            }
//            if (vr != null)
//                sheetObj.SetCellValue(idx, "check_digit",vr);
            if (vr != checkDigit && checkDigit != "") {
                sheetObj.SetCellValue(idx, "err_msg","Container check digit error"+ checkDigit + ":" + vr,0);
                sheetObj.SetCellValue(idx, "cntr_tpsz_cd","");
                sheetObj.SetCellValue(idx, "prev_sts_cd","");
//                sheetObj.SetCellValue(idx, "check_digit","");
                GridForErr(sheetObj, idx, "E");
                continue;
            }
            /*******************************************************
             *  checking container status
             ******************************************************/
            switch (status) {
            case "OP":
                if (rtnStr[5] == 'Y') {
                    if ((rtnStr[1] == 'MT' || rtnStr[1] == 'CM')
                            && rtnStr[3] == p_yard1 + p_yard2) {
                        if (rtnStr[4] == 'I' && rtnStr[4] != 'A'
                                && rtnStr[5] != 'Y') {
                            sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10005"),0);
                            GridForErr(sheetObj, idx, "E");
                        } else if (rtnStr[6] != 'N') {
                            sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10006"),0);
                            GridForErr(sheetObj, idx, "E");
                        } else if (rtnStr[11] == 'Y') {
                            sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM99999", "This Container is Damaged. Do you want to continue ?"),0);
                            GridForErr(sheetObj, idx, "E");
                        }
                    } else {
                        sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20075"),0);
                        GridForErr(sheetObj, idx, "E");
                    }
                } else {
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10007"),0);
                    GridForErr(sheetObj, idx, "E");
                }
                break;
            case "OC":
                if (rtnStr[6] != 'N') {
                    //alert ("Immediately Exit Container");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10006"),0);
                    GridForErr(sheetObj, idx, "E");
                } else if (rtnStr[1].substring(0, 1) != 'C') {
                    if (rtnStr[5] != 'Y') {
                        //alert ("Container Is Not Located In This Country!");
                        sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10007"),0);
                        GridForErr(sheetObj, idx, "E");
                    } else {
                        // auto matching bkg_no to cntr_no 추가 start by 2015/06/08 황미연
                        if (rtnStr[1] == "OP" || rtnStr[1] == "OC") {
                        	var queryString="f_cmd=" + SEARCH27 + "&p_cntrno=" + cntr_no;
                            xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                            rtnValue=ComGetEtcData(xml, "rtnValue");
                        	var bookingno = rtnValue;
                        	sheetObj.SetCellValue(idx, "bkg_no", bookingno);
                        } else if (rtnStr[1] == "TN" || rtnStr[1] == "EN") {
                        	strQuery="f_cmd=" + SEARCH07 + "&cntr_no=" + cntr_no;
                        	rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
                            rtnValue=ComGetEtcData(rtnXml, "rtnStr");
                            if (rtnValue == "OC"){
                            	var queryString="f_cmd=" + SEARCH27 + "&p_cntrno=" + cntr_no;
                                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
                                rtnValue=ComGetEtcData(xml, "rtnValue");
                            	var bookingno = rtnValue;
                            	sheetObj.SetCellValue(idx, "bkg_no", bookingno);
                            }
                        } else if (rtnStr[1] == "MT" || rtnStr[1] == "CM") {
                        	if (rtnStr[11] == 'Y') {
                                sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM99999", "This Container is Damaged. Do you want to continue ?"),0);
                                GridForErr(sheetObj, idx, "E");
                            }
                        }
                        // auto matching bkg_no to cntr_no 추가 end
                    }
                } else {
                    //alert ("This Is Not A Adequate Container!");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10008"),0);
                    GridForErr(sheetObj, idx, "E");
                }
                break;
            case "VL":
                if (rtnStr[6] != 'N') {
                    //alert ("Immediately Exit Container");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10006"),0);
                    GridForErr(sheetObj, idx, "E");
                } else if (rtnStr[1] == 'VL') {
                    //alert ("Aleady 'VL' Container!");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20076","VL"),0);
                    GridForErr(sheetObj, idx, "E");
                } else {
                    /****************************************
                     *   VL인경우 FULL/EMPTY구분.
                     *****************************************/
                    strQuery="f_cmd=" + SEARCH04 + "&cntr_no="
                    + sheetObj.GetCellValue(idx, "cntr_no");
                    strQuery=strQuery + "&crnt_vsl_cd="
                    + sheetObj.GetCellValue(idx, "crnt_vsl_cd");
                    strQuery=strQuery + "&crnt_skd_voy_no="
                    + sheetObj.GetCellValue(idx, "crnt_skd_voy_no");
                    strQuery=strQuery + "&crnt_skd_dir_cd="
                    + sheetObj.GetCellValue(idx, "crnt_skd_dir_cd");
                    strQuery=strQuery + "&pol_cd="
                    + sheetObj.GetCellValue(idx, "pol_cd");
                    strQuery=strQuery + "&mvmt_sts_cd="
                    + sheetObj.GetCellValue(idx, "mvmt_sts_cd");
                    strQuery=strQuery + "&p_type1=" + formObj.p_type1.value;
                    // strQuery = strQuery + "&p_type2=" +
                    // formObj.p_type2.value;
                    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do",strQuery);
                    rtnStr=ComGetEtcData(rtnXml, "rtnStr");
                    if (rtnStr == -1) {
                        sheetObj.SetCellValue(idx, "err_msg",("Invalid loading Container No!"),0);
                        GridForErr(sheetObj, idx, "E");
                    }
                }
                break;
            case "VD":
                if (rtnStr[1] == 'VD') {
                    //alert ("Aleady 'VD' Container!");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20076","VD"),0);
                    GridForErr(sheetObj, idx, "E");
                } else {
                    strQuery="f_cmd=" + SEARCH04 + "&cntr_no="
                    + sheetObj.GetCellValue(idx, "cntr_no");
                    strQuery=strQuery + "&crnt_vsl_cd="
                    + sheetObj.GetCellValue(idx, "crnt_vsl_cd");
                    strQuery=strQuery + "&crnt_skd_voy_no="
                    + sheetObj.GetCellValue(idx, "crnt_skd_voy_no");
                    strQuery=strQuery + "&crnt_skd_dir_cd="
                    + sheetObj.GetCellValue(idx, "crnt_skd_dir_cd");
                    strQuery=strQuery + "&pod_cd="
                    + sheetObj.GetCellValue(idx, "pod_cd");
                    strQuery=strQuery + "&mvmt_sts_cd="
                    + sheetObj.GetCellValue(idx, "mvmt_sts_cd");
                    strQuery=strQuery + "&p_type1=" + formObj.p_type1.value;
                    // strQuery = strQuery + "&p_type2=" +
                    // formObj.p_type2.value;
                    rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do",strQuery);
                    rtnStr=ComGetEtcData(rtnXml, "rtnStr");
                    if (rtnStr == "-1") {
                        sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20077"),0);
                        GridForErr(sheetObj, idx, "E");
                    }
                }
                break;
            case "TS":
                if (rtnStr[1] != 'TS') {
                    if ((rtnStr[1] == 'EN') || (rtnStr[1] == 'TN')) {
                    } else {
                        sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20078"),0);
                        GridForErr(sheetObj, idx, "E");
                    }
                } else {
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20078"),0);
                    GridForErr(sheetObj, idx, "E");
                }
                break;
            case "MT":
                if ((rtnStr[1] == 'CM') || (rtnStr[1] == 'CP') || (rtnStr[1] == 'CE') || (rtnStr[1] == 'CT') || (rtnStr[1].substring(0, 1) != 'C')) {
                    if (rtnStr[7] == 'Y') {
                    } else if (rtnStr[5] != 'Y') {
                        sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10007"),0);
                        GridForErr(sheetObj, idx, "E");
                    }
                    // 2015/06/08
                    for (Row=1; Row <= sheetObj.LastRow(); Row++) {
	                    if (rtnStr[9] == "N" && (rtnStr[1] == "MT" || rtnStr[1] == "EN" || rtnStr[1] == "TN" || rtnStr[1] == "CM")) {
	                    	if (rtnStr[10] == "SH") {
	                    		// Inactivate EQR Ref. No.
	                        	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
		                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
	                    	} else {
	                    		// Activate EQR Ref. No.
	                        	sheetObj.SetCellEditable(Row, "mty_pln_no", 1);
	                        	
	                        	if (rtnStr[9] == "N" && ( rtnStr[1] == "EN" || rtnStr[1] == "TN" )) {
	                            	var queryString="f_cmd=" + SEARCH28 + "&p_cntrno=" + cntr_no;
	                                xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
	                                rtnValue=ComGetEtcData(xml, "rtnValue");
	                            	var mtyPlnNo = rtnValue; 
	                            	sheetObj.SetCellValue(Row, "mty_pln_no", mtyPlnNo);
	                        	}
	                    	}
	                    } else {
	                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
	                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
	                    }
                    }
                    // mty_pln_no validation 추가 end
                } else {
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10008"),0);
                    GridForErr(sheetObj, idx, "E");
                }
                break;
            case "CM":
                if (rtnStr[1] == 'MT' || rtnStr[1].substring(0, 1) == 'C') {
                } else {
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM10008"),0);
                    GridForErr(sheetObj, idx, "E");
                }
                break;
                // mty_pln_no validation 추가 start by 2015/06/08 황미연
            case "TN":
            case "EN":
            	for (Row=1; Row <= sheetObj.LastRow(); Row++) {
	                if (rtnStr[9] == "N" && (rtnStr[1] == "MT" || rtnStr[1] == "EN" || rtnStr[1] == "TN" || rtnStr[1] == "CM")) {
	                	if (rtnStr[10] == "SH") {
	                		// Inactivate EQR Ref. No.
	                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
	                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
	                	} else {
	                    	// Activate EQR Ref. No.
	                    	sheetObj.SetCellEditable(Row, "mty_pln_no", 1);
	                	}
	                } else {
	                	sheetObj.SetCellEditable(Row, "mty_pln_no", 0);
                    	sheetObj.SetCellValue(Row, "mty_pln_no", "");
	                }
            	}
                break;
                // mty_pln_no validation 추가 end
            }
            sheetObj.SetCellEditable(idx, "cntr_no",1);
            sheetObj.SetCellEditable(idx, "bkg_no",1);
            sheetObj.SetCellEditable(idx, "cnmv_evnt_dt",1);

            var p_date=sheetObj.GetCellText(idx, "cnmv_evnt_dt");
            var strTime=new Date();
            var y=strTime.getFullYear();
            var m=strTime.getMonth() + 1;
            var d=strTime.getDate();
            var h=strTime.getHours();
            var n=strTime.getMinutes();
            if (m < 10) m="0" + m;
            if (d < 10) d="0" + d;
            if (h < 10) h="0" + h;
            if (n < 10) n="0" + n;
            var strDt=y + "-" + m + "-" + d + " " + h + ":" + n;
            var rValue=Number(dateTimeDiff(strDt, p_date));
            if (rValue > 3) {
                ComShowCodeMessage("CTM10053");
                // alert ("Event date can't exceed+0 Days from today.");
                sheetObj.SetCellValue(idx, "cnmv_evnt_dt", document.form.p_date0.value);
            }
        }

        bkg_no=sheetObj.GetCellValue(idx, "bkg_no");
        formObj.f_cmd.value=SEARCH17;
        if (bkg_no.length < 1) {
        } else if (bkg_no.length == 10) {
        	formObj.f_cmd.value=SEARCH21;
        } else {
        	formObj.f_cmd.value=SEARCH17;
        }
        if (status == 'OP' || status == 'OC') {
            var queryString="f_cmd=" + formObj.f_cmd.value + "&p_bkg_no=" + bkg_no
                    + "&p_bkg_no_split=";
            var xml=sheetObj.GetSearchData("CTMCommonGS.do", queryString);
            var rtnValue=ComGetEtcData(xml, "rtnValue");
            
            if (rtnValue == "") {
                sheetObj.SetCellValue(idx, "bkg_no_split","");
                sheetObj.SetCellValue(idx, "rcv_term_cd","");
                sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM20999"),0);
                setErr(idx);
                continue;
            } else {
                rtnStr=rtnValue.split("||");
                // for (i = 0; i < rtnStr.length; i++)
                // alert (rtnStr[i]);
                if (rtnStr.length < 2) {
                    sheetObj.SetCellValue(idx, "bkg_no_split","");
                    sheetObj.SetCellValue(idx, "rcv_term_cd","");
                } else {
                    sheetObj.SetCellValue(idx, "bkg_no_split",rtnStr[0]);
                    sheetObj.SetCellValue(idx, "rcv_term_cd",rtnStr[1]);
                    sheetBkgValueFlg=true;
                }
            }
        } else {
            rtnValue="";
            sheetObj.SetCellValue(idx, "bkg_no","");
        }
        
        if (bkg_no.length == 10) {
        	if (status == 'OP' || status == 'OC') {
        		var strQuery="f_cmd=" + SEARCH22 + "&p_cntrno=" + cntr_no + "&p_bkg_no=" + bkg_no;
        		var rtnXml=sheetObj.GetSearchData("CTMCommonGS.do", strQuery);
                var rtnValue=ComGetEtcData(rtnXml, "rtnValue");
                //alert("BOOKING rtnValue : " + rtnValue);
                if (rtnValue == 0) {
                    sheetObj.SetCellValue(idx, "bkg_no","");
                    sheetObj.SetCellValue(idx, "bkg_no_split","");
                    sheetObj.SetCellValue(idx, "rcv_term_cd","");
                    sheetObj.SetCellValue(idx, "err_msg",ComGetMsg("CTM30016", "["+bkg_no+"]"),0);
                    setErr(idx);
                    continue;
                } else {
                }
        	}        	
        }
        
    }
}
function GridForErr(sheetObj, Row, Tp) {
    if (Tp == "E") {
        sheetContainerFlg=false;
        setErr(Row);
    } else {
        //sheetObj.RenderSheet(0);
        sheetObj.SetRowBackColor(Row,0);
        for (xx=1; xx <= sheetObj.LastCol(); xx++) {
            if (!sheetObj.GetCellEditable(Row, xx))
                sheetObj.SetCellBackColor(Row, xx,"#F1F1F1");
        }
        //sheetObj.RenderSheet(1);
        sheetObj.SetCellValue(Row, "err_msg","",0);
    }
}
function setErr(Row) {
    sheetObj.SetRowBackColor(Row,"#F0C8C8");
}
 /**
 * event when clicking cell in IBSheet data part
 * @param {sheetObj} String :  IBSheet cell name
 * @param {Row} Long : cell Row Index
 * @param {Col} Long : cell Column Index
 * @param {Value} String : changed value
 * @param {CellX} Long : cell x-coordinate
 * @param {CellY} Long : cell y-coordinate
 * @param {CellW} Long : cell width
 * @param {CellH} Long : cell length
 */
function sheet1_OnClick(sheetObj, Row, Col, Value, CellX, CellY, CellW, CellH) {
	//alert("event name : sheet1_OnClick(" + row + "," + sheetObj.ColSaveName(Col) + "," + Value + ")");
    if (sheetObj.ColSaveName(Col) != "del_chk") {
        with (sheetObj) {
            var sRowStr=GetSelectionRows("/");
            var arr=sRowStr.split("/");
            if (arr.length > 1) {
                for (i=0; i < arr.length; i++) {
                    if (GetCellEditable(Row, "del_chk")) {
                        SetCellValue(arr[i], "del_chk","1");
                    }
                }
            }
        }
    }
}
function sleep(milliseconds) {
    var start=new Date().getTime();
    // for (var i = 0; i < 1e7; i++) {
    // if ((new Date().getTime() - start) > milliseconds){
    // break;
    // }
}
/**
 * Use in [btn_add] or [function cntrno_keyUp]
 * @param Row
 * @return
 */
function addRow() {
    var sheetObject=sheetObjects[0];
    var formObj=document.form;
    var stsCond=formObj.p_status.value;
    var vvdCond=formObj.p_vvd.value;
    var Row=0;
    if (checkFormField()) {
        if (document.form.p_yard2.value== "") {
            ComShowCodeMessage("CTM10049", "yard cd", "", "")
            return 0;
        }           

        if (stsCond == "VL" || stsCond == "VD") {
            if (vvdCond.length != 9) {
                etaEtdPass=false;
                ComShowCodeMessage("CTM20073");
                // alert ("VVD Code is Not Exists")
                formObj.p_vvd.select();
                formObj.p_vvd.focus();
                formObj.p_vvd.value="";
                return 0;
            }else{
                if (document.form.oscar_bkg_flg.checked==true && document.form.p_vvd.readOnly==true) {
	                var strQuery="f_cmd=" + SEARCH09 + "&p_vvd=" + formObj.p_vvd.value
	                var rtnXml=sheetObj.GetSearchData("EES_CTM_0406GS.do", strQuery);
	                rtnValue=ComGetEtcData(rtnXml, "rtnStr");
	                if(rtnValue!="Y") {
	                	ComShowCodeMessage("CTM30017"); // VVD doesn’t exist
	                	return 0;
	                }
                }
            }
        }

        Row=sheetObject.DataInsert(-1);
        sheetObject.SetCellValue(Row, "cnmv_evnt_dt",formObj.p_date0.value);
        sheetObject.SetCellValue(Row, "org_yd_cd",formObj.p_yard1.value + document.form.p_yard2.value);
        sheetObject.SetCellValue(Row, "mvmt_sts_cd",formObj.p_status.value);
        vvdCd=formObj.p_vvd.value;
        sheetObject.SetCellValue(Row, "crnt_vsl_cd",vvdCd.substring(0, 4));
        sheetObject.SetCellValue(Row, "crnt_skd_voy_no",vvdCd.substring(4, 8));
        sheetObject.SetCellValue(Row, "crnt_skd_dir_cd",vvdCd.substring(8, 9));
        sheetObject.SetCellValue(Row, "pol_cd",formObj.p_pol.value);
        sheetObject.SetCellValue(Row, "pod_cd",formObj.p_pod.value);
        sheetObject.SetCellValue(Row, "cnmv_yr",formObj.p_date0.value.substring(0, 4));
        if (stsCond == "VL" || stsCond == "VD") {
            sheetObj.SetCellEditable(Row, "bkg_no",0);
            sheetObj.SetCellEditable(Row, "cnmv_evnt_dt",1);
        } else {
            sheetObj.SetCellEditable(Row, "bkg_no",1);
            sheetObj.SetCellEditable(Row, "cnmv_evnt_dt",1);
        }
        setElementDisable(true);
        sheetObj.SelectCell(Row, "cntr_no");
    }
    ComBtnDisable("btn_loadExcel");
    //conditionDisable();
    return Row;
}

//function sheet1_OnAfterEdit(sheetObj, row, col) {
//	//alert("event name : sheet1_OnAfterEdit(" + row + "," + sheetObj.ColSaveName(Col) + ")");
//    var formObj = document.form;
//    
//    //if(col == 3 && sheetObj.GetCellValue(row, "cntr_no").length < 10) // CNTR NO를 찾아와야한다.
//    if(col == 3) // CNTR NO를 찾아와야한다.
//    {
//        sheetCheckValue(sheetObj, row, col, true);
//    }
//}
 
function buttonEnable(enableBtns) {
    var disableBtns = "btn_select,btn_qty,btn_pre,btn_loadExcel,btn_downExcel,btn_save,btn_retrieve";
    var disableBtnArr=disableBtns.split(",");
    for (i=0; i < disableBtnArr.length; i++) {
        ComBtnDisable(disableBtnArr[i]);
    }
    
    var enableBtnArr=enableBtns.split(",");
    for (i=0; i < enableBtnArr.length; i++) {
        ComBtnEnable(enableBtnArr[i]);
    }
}

function conditionDisable() {
    //var disableObjs = "p_status,p_yard1,p_yard2,p_date,btn_Calendar1,p_time";
    var disableObjs = "p_status,p_yard1,p_date,p_time";
    var disableObjArr=disableObjs.split(",");
    for (i=0; i < disableObjArr.length; i++) {
        document.getElementById(disableObjArr[i]).disabled=true;
    }
    p_yard2.SetEnable(false);
    ComBtnDisable("btn_Calendar1");
}

function conditionEnable() {
    //var disableObjs = "p_status,p_yard1,p_yard2,p_date,btn_Calendar1,p_time";
    var enableObjs = "p_status,p_yard1,p_date,p_time";
    var enableObjArr=enableObjs.split(",");
    for (i=0; i < enableObjArr.length; i++) {
        document.getElementById(enableObjArr[i]).disabled=false;
    }
    p_yard2.SetEnable(true);
    ComBtnEnable("btn_Calendar1");
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
