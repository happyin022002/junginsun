/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0001.js
*@FileTitle  : Arrival Notice Notice Sent History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/

var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;

var sheetObjects=new Array();
var sheetCnt=0;
var sheetNames=new Array("sheet1", "sheet2");
var sheetInits=new Array(   false,    false);

// Event handler processing by button click event */
document.onclick=processButtonClick;

/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * @param sheet_obj
 * @return void
 * @author
 * @version 2009.10.01
 */
function processButtonClick(){
    /***** using extra sheet valuable if there are more 2 sheets *****/

    var sheetObject1=sheetObjects[0];

    /*******************************************************/
    var formObject=document.form;

    //try {

    var srcName=ComGetEvent("name");
    if(ComGetBtnDisable(srcName)) return false;

    switch(srcName) {
        case "btn_snd_dt":
            var cal=new ComCalendarFromTo();
            formObject.sch_tp[1].checked=true;
            fnToggleSchTp("D", formObject);
            cal.select(formObject.snd_dt_fm, formObject.snd_dt_to, 'yyyy-MM-dd');
            break;
        case "btn_retrieve":
            if (!validateForm(sheetObject1, formObject, IBSEARCH)) {return; }

            doActionIBSheet(sheetObject1,formObject,IBSEARCH);
            break;

        case "btn_DownExcel":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("COM132501");
				return;
			}
			
            if (!validateForm(sheetObject1, formObject, IBDOWNEXCEL)) {return; }

            doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL,"","");
            break;
            
        case "btn_ANSend":
            fnMoveToANSend(sheetObjects[0], formObject);
            break;

        case "btn_PrePickup":
            fnMoveToPrePickup(sheetObjects[0], formObject);
            break;
        case "btn_PreHold":
            fnMoveToPreHold(sheetObjects[0], formObject);
            break;

        case "btn_InboundCS":
            fnMoveToInboundCS(sheetObjects[0], formObject);
            break;

    } // end switch
}


/**
 * registering IBSheet Object as list<br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * @param sheet_obj
 * @return void
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}


/**
 * initializing sheet<br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * @param {void}
 * @return void
 * @author
 * @version 2009.10.01
 */
function loadPage() {

    for(i=0;i<sheetNames.length;i++){
        if(sheetNames[i] == "sheet1") {
            sheetInit(i);
        }
    }
    if(parNtcKndCd == "AN"){
    	document.form.ntc_knd_cd.options[1].selected=true;
    }
    initControl();

    if (parAutoSearchFlg == "Y" ) {

        doActionIBSheet(sheetObjects[0],document.form,IBSEARCH, "", "");
    }

}

/**
 * initializing Sheet
 * @param idx
 * @return 
 */
function sheetInit(idx) {
    if (sheetInits[idx] == false) {
        ComConfigSheet (sheetObjects[idx] );
        initSheet(sheetObjects[idx],idx+1);
        ComEndConfigSheet(sheetObjects[idx]);
        sheetInits[idx]=true;
    }
}

/**
 * initializing : register event<br><br>
 * @param 
 * @return 
 */
function initControl() {
    axon_event.addListenerForm('click', 'objClick', form );
    axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
    axon_event.addListenerForm('keypress', 'objKeyPress', form);

   var formObj=document.form;

   /* DEFAULT VALUE process */
   formObj.ofc_cd.value=strOfc_cd;  // default office - login office

   // calendar process
   formObj.snd_dt_to.value=ComGetNowInfo('ymd','-');
   formObj.snd_dt_fm.value=ComGetDateAdd(null, 'd', -21, '-');

   // button process
   if (strCnt_cd== null || strCnt_cd != "US") {
       ComBtnDisable("btn_PrePickup");
       ComBtnDisable("btn_PreHold");
   }

   var schTp="";
   formObj.bl_no.value=parBlNo;
   formObj.vvd.value=parVvd;
   formObj.pod_cd.value=parPodCd;
   if (parSchTp == "") {
       formObj.sch_tp[1].checked=true;
       schTp=formObj.sch_tp[1].value;
   } else {
       for (var idx=0; idx < formObj.sch_tp.length; idx++) {
           if (formObj.sch_tp[idx].value == parSchTp) {
               formObj.sch_tp[idx].checked=true;
               formObj.sch_tp.value=parSchTp;
               schTp=parSchTp;
               break;
           }
       }
   }

   fnToggleSchTp(schTp, formObj);
}

function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}


/**
 * setting sheet initial values and header<br>
 * @param sheetObj
 * @param sheetNo
 * @return void
 */
function initSheet(sheetObj, sheetNo) {

    var cnt=0;
    var sheetID=sheetObj.id;
    switch (sheetID) {

    case "sheet1"://Detail Grid
     with(sheetObj){
	     var HeadTitle="|#|Notice type|BL No.|Consigne|Notify|Sent Result|Sent Result|FAX/EMAIL Address|Sent RQST|Final Sent|Sent Office|Sent ID|User Name|";
	
	     SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	     var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
	     var headers = [ { Text:HeadTitle, Align:"Center"} ];
	     InitHeaders(headers, info);
	
	     var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
	         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                    KeyField:0 },
	         {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:1,   SaveName:"ntc_knd_cd_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cn_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"nf_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntc_fax_no_eml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:110,  Align:"Center",  ColMerge:1,   SaveName:"snd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"snd_gdt",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	         {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	      
	     InitColumns(cols);
//	     SetSheetHeight(420);
	     SetEditable(1);
	     SetEllipsis(1);
	     SetWaitImageVisible(0);
	     SetCountFormat("[ SELECTDATAROW / TOTALROWS ]");
	     MultiSelection=false;
	     ToolTipOption="balloon:true;width:320;title:Final Sent (GMT)";
	     resizeSheet();
	    }
        break;

    case "sheet2"://Detail Grid
    with(sheetObj){
		 var HeadTitle="Notice type|BL No.|Consigne|Notify|Sent Result|Sent Result|FAX/EMAIL Address|Sent RQST|Final Sent|Sent Office|Sent ID|User Name";
		
		 SetConfig( { SearchMode:2, Page:200, FrozenCol:0, DataRowMerge:1 } );
		
		 var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		 var headers = [ { Text:HeadTitle, Align:"Center"} ];
		 InitHeaders(headers, info);
		
		 var cols = [ {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ntc_knd_cd_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"cn_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:130,  Align:"Left",    ColMerge:1,   SaveName:"nf_nm",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_ntc_snd_rslt_ctnt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:150,  Align:"Left",    ColMerge:1,   SaveName:"ntc_fax_no_eml",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"snd_rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"snd_dt",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"snd_ofc_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:120,  Align:"Center",  ColMerge:1,   SaveName:"snd_usr_id",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"usr_nm",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		  
		 InitColumns(cols);
		 SetEditable(0);
		}
        break;

    }
}


/**
 * handling sheet process<br><br>
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @param CondParam
 * @param PageNo
 * @return void
 */
function doActionIBSheet(sheetObj,formObj,sAction,CondParam,PageNo) {

    //sheetObj.ShowDebugMsg = false;
    switch(sAction) {

        case IBSEARCH:      //retrieve
            formObj.f_cmd.value=SEARCH;
        	ComOpenWait(true);
            sheetObj.DoSearch("ESM_BKG_0001GS.do" ,FormQueryString(formObj)+"&page_no=1", {Append:false, Sync:1} );
        	iPageNo = 1;
            break;

        case IBSEARCHAPPEND:
        	ComOpenWait(true);
//            sheetObj.DoSearch("ESM_BKG_0001GS.do", CondParam + "&mtch_chk_flg=N", "&iPage="+PageNo,  {Append:true});
        	if (PageNo >= 1) {
				sheetObj.DoSearch("ESM_BKG_0001GS.do", FormQueryString(formObj) + "&mtch_chk_flg=N"+ "&page_no=" + PageNo, {Append:true, Sync:1} );
			} else {
				sheetObj.DoSearch("ESM_BKG_0001GS.do", FormQueryString(formObj) + "&mtch_chk_flg=N"+ "&page_no=1", {Append:false, Sync:1} );
			}
            break;

        case IBDOWNEXCEL:   // EXCEL Download
            formObj.f_cmd.value=SEARCH;
            ComOpenWait(true);
            sheetInit(1);
            sheetObj.DoSearch("ESM_BKG_0001GS.do", FormQueryString(formObj)  + "&excel_flg=Y" );
            break;
    }

}

/**
 * handling process for input validation<br>
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @return boolean
 */
function validateForm(sheetObj,formObj,sAction){
    var formObj=document.form;    
    with(formObj){
        switch (sAction){
        case IBSEARCH:        	
            if(!ComChkValid(formObj)) return false;            
            // maximum retrieve time is three months
            if(formObj.sch_tp[1].checked
                    && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
            {
                ComShowCodeMessage("BKG40013", "3");
                ComSetFocus(formObj.snd_dt_to);
                return false;
            }
            break;

        case IBDOWNEXCEL:
            if(!ComChkValid(formObj)) return false;

            // maximum retrieve time is three months
            if(formObj.sch_tp[1].checked && !ComBkgMonthsBetweenCheck(formObj.snd_dt_fm.value,formObj.snd_dt_to.value,  3))
            {
                ComShowCodeMessage("BKG40013", "3");
                ComSetFocus(formObj.snd_dt_to);
                return false;
            }

            break;
        }
    }

    return true;
}


/**
 * process after retrieve - setting color at row and add tool-tip Info<br>
 * @param sheetObj
 * @param errXml
 * @returns void
 */
function sheet1_OnSearchEnd(sheetObj, Code, errXml) {
    var startRow=1;
    var maxRow=sheetObj.LastRow();
    ComOpenWait(false);
    
    //sheetObj.RowHeight(0) = 10;
//    if (maxRow < 100) {
//        startRow=1;
//    } else if ((maxRow%100.0) == 0 ) {
//        startRow=maxRow - 200 ;
//        if (startRow < 1) {
//            startRow=1;
//        }
//    } else {
//        startRow=maxRow - ((maxRow - 1.0)%200.0);
//    }

    var vColorRed="#FF0000";
    var vColorBlue="#0000FF";
    var vColorPink="#FF00C0";
    for (var idx=startRow; idx <= maxRow; idx ++) {
        with (sheetObj) {
        	rsltCd=GetCellValue(idx, "bkg_ntc_snd_rslt_cd");

            if (rsltCd == "F") { // Red
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd", vColorRed);
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt", vColorRed);
            	SetCellFontColor(idx,"ntc_fax_no_eml", vColorRed);
            } else if (rsltCd == "S" ) { // blue
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd", vColorBlue);
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt", vColorBlue);
            	SetCellFontColor(idx,"ntc_fax_no_eml", vColorBlue);
            } else { // pink
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_cd", vColorPink);
            	SetCellFontColor(idx,"bkg_ntc_snd_rslt_ctnt", vColorPink);
            	SetCellFontColor(idx,"ntc_fax_no_eml", vColorPink);
            }
            sheetObj.SetToolTipText(idx, "snd_dt",sheetObj.GetCellValue(idx, "snd_gdt"));
        }
        sheetObj.SetToolTipText(idx, "snd_dt",sheetObj.GetCellValue(idx, "snd_gdt"));
    }
}

/**
 * event handling when ending search about Excel<br>
 * @param sheetObj
 * @param errXml
 * @returns void
 */
function sheet2_OnSearchEnd(sheetObj, Code, errXml) {
	ComOpenWait(false);
    sheetObj.Down2Excel();
}


/**
 * defining page attribute when changing sch_tp<br>
 * @param vSchTp
 * @param formObj
 * @return void
 */
function fnToggleSchTp (vSchTp, formObj) {
    if (vSchTp=="V") {
         document.getElementsByName("vvd")[0].setAttribute("required", true);
         document.getElementsByName("vvd")[0].setAttribute("fullfill", true);
         document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
         document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
         document.getElementsByName("bl_no")[0].removeAttribute("required");

         document.getElementsByName("pod_cd")[0].setAttribute("required", true);
         document.getElementsByName("ofc_cd")[0].setAttribute("required", true);
     } else if (vSchTp=="D") {
         document.getElementsByName("vvd")[0].removeAttribute("required");
         document.getElementsByName("vvd")[0].removeAttribute("fullfill");
         document.getElementsByName("snd_dt_fm")[0].setAttribute("required", true);
         document.getElementsByName("snd_dt_to")[0].setAttribute("required", true);
         document.getElementsByName("bl_no")[0].removeAttribute("required");

         document.getElementsByName("pod_cd")[0].setAttribute("required", true);
         document.getElementsByName("ofc_cd")[0].setAttribute("required", true);
     } else if (vSchTp=="B") {
         document.getElementsByName("vvd")[0].removeAttribute("required");
         document.getElementsByName("vvd")[0].removeAttribute("fullfill");
         document.getElementsByName("snd_dt_fm")[0].removeAttribute("required");
         document.getElementsByName("snd_dt_to")[0].removeAttribute("required");
         document.getElementsByName("bl_no")[0].setAttribute("required", true);
         document.getElementsByName("pod_cd")[0].removeAttribute("required");
         document.getElementsByName("ofc_cd")[0].removeAttribute("required");
     }
}

/**
 * event handling when click on the page entity<br>
 * @param {void}
 * @return void
 */
function objClick() {
   var objName=ComGetEvent("name");
   var formObj=document.form;
   switch(objName) {
       case "sch_tp":

           var vSchTp="";
           for (var i=0; i<formObj.sch_tp.length; i++) {
               if (formObj.sch_tp[i].checked) {
                   vSchTp=formObj.sch_tp[i].value;
               }
           }
           formObj.sch_tp.value=vSchTp;
           fnToggleSchTp(vSchTp, formObj);
           break;
       case "vvd":
           formObj.sch_tp[0].checked=true;
           fnToggleSchTp("V", formObj);
           break;
       case "snd_dt_fm":
           formObj.sch_tp[1].checked=true;
           fnToggleSchTp("D", formObj);
           break;
       case "snd_dt_to":
           formObj.sch_tp[1].checked=true;
           fnToggleSchTp("D", formObj);
           break;
       case "bl_no":
           formObj.sch_tp[2].checked=true;
           fnToggleSchTp("B", formObj);
           break;
   }
}

/**
 * event handling when typing the keyboard<br>
 * @param {void}
 * @return void
 */
function objKeyPress() {
    var objName=ComGetEvent("name");
    var formObj=document.form;
    switch(objName) {
//    case "vvd":
//        ComKeyOnlyAlphabet('uppernum');
//        break;
//    case "pod_cd":
//        ComKeyOnlyAlphabet('upper');
//        break;
//    case "bl_no":
//        ComKeyOnlyAlphabet('uppernum');
//        break;
//    case "ofc_cd":
//        ComKeyOnlyAlphabet('upper');
//        break;
//    case "snd_dt_fm":
//        obj_KeyPress(ComGetEvent());
//        break;
//    case "snd_dt_to":
//        obj_KeyPress(ComGetEvent());
//        break;

    }
}

/**
 * going to Cargo Release page<br>
 * @param sheetObj
 * @param formObj
 * @return void
 */
function fnMoveToANSend(sheetObj, formObj) {
    var sRowStr=sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return ;
    }

    var sRowArr=sRowStr.split("|");
    if(sRowArr.length > 1){
        ComShowCodeMessage("BKG00362");
        return;
    }

var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");

    if(blNo=="") {
    	// Please retrieve data first.
     	ComShowCodeMessage("BKG00012");
    	return;
    }

    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_0381_POP.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_0381";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;
    param += "&autoSearchFlg=Y";


    //location.href=goUrl + param;
    //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_0381", 1024, 640, false);
}

/**
 * going to Pre Pick-up page<br>
 * @param sheetObj
 * @param formObj
 * @return void
 */
function fnMoveToPrePickup(sheetObj, formObj) {
    var sRowStr=sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { return ; }

    var sRowArr=sRowStr.split("|");
    if(sRowArr.length > 1){
        ComShowCodeMessage("BKG00362");
        return;
    }

var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");

    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_1066_POP.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_1066";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;


   //location.href=goUrl + param;
   //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_0413", 1024, 700, false);
}

/**
 * going to Pre-Hold page
 * @param sheetObj
 * @param formObj
 * @return void
 */
function fnMoveToPreHold(sheetObj, formObj) {
    var sRowStr=sheetObj.GetSelectionRows("|");
    if (sRowStr == "0" ) { return ; }

    var sRowArr=sRowStr.split("|");
    if(sRowArr.length > 1){
        ComShowCodeMessage("BKG00362");
        return;
    }

var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");

    var goUrl="";
    var param="";
    goUrl="/opuscntr/ESM_BKG_0510_POP.do?";
    param += "1=1";
    param += "&pgmNo=ESM_BKG_0510";
    param += "&sch_tp=B";
    param += "&bl_no=" + blNo;


    //location.href=goUrl + param;
    //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
    ComOpenWindowCenter(goUrl + param, "ESM_BKG_0510", 1024, 700, false);
}


/**
 * going to Inbound CS page<br>
 * @param sheetObj
 * @param formObj
 * @return void
 */
function fnMoveToInboundCS(sheetObj, formObj) {
    var sRowStr=sheetObj.GetSelectionRows("|");

    if (sRowStr == "0" ) {
    	ComShowCodeMessage("BKG00012");
    	return ;
    }

    var sRowArr=sRowStr.split("|");
    if(sRowArr.length > 1){
        ComShowCodeMessage("BKG00362");
        return;
    }

var blNo=sheetObj.GetCellValue(sRowArr[0], "bl_no");
var bkgNo=sheetObj.GetCellValue(sRowArr[0], "bkg_no");

    if (bkgNo == "") {
    	ComShowCodeMessage("BKG00012");
    	return;
    }

    var goUrl="";
    var param="";
    var actDoName="";
    var actDoPageName="";
    if (strCnt_cd == "US") {
        actDoName="ESM_BKG_0668_01";
        actDoPageName="06";
    } else {
        actDoName="ESM_BKG_0292";
        actDoPageName="04";
    }

    goUrl="/opuscntr/" + actDoName + "_POP.do?";
    param += "1=1";
    param += "&pgmNo=" + actDoName ;
    param += "&bkg_no=" + bkgNo;


   //location.href=goUrl + param;
   //ComOpenWindowCenter(goUrl + param, "ESM_BKG_0128", 1000, 600, true);
  // ComOpenWindowCenter(goUrl + param, actDoName, 1024, 650, false);
   ComOpenWindowCenter(goUrl + param, actDoName, 1250, 700, false,"yes");
}

/**
 * event handling when horizon scrollbar touch the bottom<br>
 * @param sheetObj
 * @param CondParam
 * @param PageNo
 * @param OnePageRows
 * @return void
 */
var iPageNo = 1;
function sheet1_OnVScroll(sheetObj, vpos, oldvpos, isTop, isBottom) {
    if (!isBottom || sheetObj.RowCount() >= sheetObj.GetTotalRows()) return;
    doActionIBSheet(sheetObj, document.form, IBSEARCHAPPEND, true, ++iPageNo);
}

/**
 * ibSheet Double Click event handling<br>
 * @param sheetObj
 * @param row
 * @param col
 * @return void
 */
function sheet1_OnDblClick(sheetObj, row, col) {
   var eventCol=sheetObj.ColSaveName(col);
   var eventValue=sheetObj.GetCellValue(row, col);
   switch (eventCol) {
       case "cn_nm":
           ComShowMemoPad(sheetObj, row, "cn_nm", true, 200, 100, 200 );
           break;
       case "nf_nm":
           ComShowMemoPad(sheetObj, row, "nf_nm", true, 200, 100, 200 );
           break;
   }
}
 