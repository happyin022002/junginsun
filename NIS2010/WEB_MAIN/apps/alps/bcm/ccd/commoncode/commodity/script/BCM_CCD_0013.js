/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0013.js
*@FileTitle  :  Package Type Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var saveRows=new Array();
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
function processButtonClick() {
    /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
    var sheetObj=sheetObjects[0];
    /** **************************************************** */
    var formObj=document.form;
    try {
        var srcName=ComGetEvent("name");
        //if(ComGetBtnDisable(srcName)) return false;
        switch (srcName) {
        case "btn_History":
			var tblNo = 'MDM_CSTMS_PCK_TP';
			
			var pckCd = formObj.pck_cd.value;
			var mstKey = nullToBlank(pckCd);
			if (mstKey == "") {
				ComShowCodeMessage("CCD00038", "Package Type Code");
			return false;
			}
			comMdmCallPop(tblNo, mstKey);
        case "btn_Retrieve":
            doActionIBSheet(sheetObj, formObj, IBSEARCH);
            break;
        case "btn_Save":
            doActionIBSheet(sheetObj, formObj, IBSAVE);
            break;
        case "btn_Create":
			doActionIBSheet(sheetObj, formObj, IBCREATE);
			break;
        case "btn_New":
        	doActionIBSheet(sheetObj, formObj, IBCLEAR);
            break;
        case "btns_search": // Package Type Code 팝업
            var v1=formObj.mdm_yn.value;
            var classId="UI_BKG_0696";
            var param='?mdm_yn='+v1+'&classId='+classId;
            ComOpenPopup('/hanjin/UI_BKG_0696.do'+param, 660, 415, 'getPck_cd', "1,0,1", true);
            break;
        } // end switch
    } catch (e) {
        if (e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}
function getPck_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.pck_cd.value=colArray[2];
    doActionIBSheet(sheetObj, formObj, IBSEARCH);
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
 * registering IBCombo Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setComboObject(combo_obj) {  
    comboObjects[comboCnt++]=combo_obj;  
}
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function loadPage() {
    var formObj=document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
    /*if (G_MDAA_CHK == "Y") {
        ComSetDisplay('btn_Retrieve', true);   
        ComSetDisplay('btn_New', true);   
        ComSetDisplay('btn_Save', true);   
    }   
    else {
        ComSetDisplay('btn_Save', false);   
        ComSetDisplay('btn_Retrieve', true);   
        ComSetDisplay('btn_New', true);   
    } 
    if(G_MDAA_CHK == "Y")
        ComEnableObject(formObj.delt_flg, true); 
    else
        ComEnableObject(formObj.delt_flg, false);*/ 
}
/**
 * new page is default Page 
 * newpage() is called by New Button  
 */
function newPage() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    sheetObj.RemoveAll();
    formObj.reset();
    formObj.pck_cd.disabled=false;
}
function initPage() {
    var formObj=document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
/*function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
    case 1: // sheet1 init
        with(sheetObj){
              var HeadTitle1="|PCK_CD|PCK_NM|DELT_FLG";
              var headCount=ComCountHeadTitle(HeadTitle1);
              (headCount, 0, 0, false);
              var prefix="sheet1_";
              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
              var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:0 };
              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
              InitHeaders(headers, info);
              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"delt_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 }
                     ];
               
              InitColumns(cols);
              SetVisible(false);
              SetEditable(1);
              SetSelectionMode(smSelectionList);
            }
        break;
    }
}*/


function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetObj.id) {
    case "sheet1" : // sheet1 init
    	with(sheetObj){
        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        InitRowInfo( 1, 1, 5, 100);
        InitColumnInfo(8, 0, 0, true);

        // 해더에서 처리할 수 있는 각종 기능을 설정한다
        InitHeadMode(false, true, true, false, false, false);

		
        // var HeadTitle="ibflag|pck_cd|cstms_cnt_cd|pck_cstms_cd|delt_flg"; 
         var HeadTitle="";
         
         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         InitHeadRow(0, HeadTitle, true);
         
			     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
         		InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "pck_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "pck_nm" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "delt_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "cre_usr_id" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "cre_dt" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "upd_usr_id" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,    false,     "upd_dt" ,     		false,          "",      	dfNone,   0,     true,       true);
    	}
    	
 
        break;
    }
}


// /handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg(false); <<이거 뭘까 물어보자
    switch (sAction) {
    
    case IBCREATE: // New retrieve
    	formObj.reset();    	
    	sheetObj.RemoveAll();
    	formObj.ibflag.value="I";
    	ComBtnDisable('btn_Create');
    	formObj.pck_cd.className = "input1";
    	formObj.pck_cd.readOnly = false;
	    //ComEnableObject(document.form.btns_search, true);
   	break;
    
    case IBSEARCH: // retrieve
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH;
            ComOpenWait(true); 
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0013GS.do", FormQueryString(formObj));
            var arrXml = sXml.split("|$$|"); 
            var pckCd=ComGetEtcData(sXml, "pck_cd");
            ComOpenWait(false);
            if (pckCd != undefined) {
            	sheetObj.LoadSearchXml(arrXml[0]);
            	formObj.pck_cd.value=sheetObj.CellValue(1,'pck_cd');
                formObj.pck_nm.value=sheetObj.CellValue(1,'pck_nm');
                formObj.delt_flg.value=sheetObj.CellValue(1,'delt_flg');
                formObj.cre_usr_id.value=sheetObj.CellValue(1,'cre_usr_id');
                formObj.cre_dt.value=sheetObj.CellValue(1,'cre_dt').substring(0, 19);
                formObj.upd_usr_id.value=sheetObj.CellValue(1,'upd_usr_id');
                formObj.upd_dt.value=sheetObj.CellValue(1,'upd_dt').substring(0, 19);
                formObj.pck_cd.className = "input2";
            	formObj.pck_cd.readOnly = true;
            	ComBtnEnable('btn_Create');
                
                formObj.ibflag.value = "U";
            }else{
            	formObj.ibflag.value="I";
            	if(!ComShowConfirm(ComGetMsg("CCD00034", "Package Type Code"))){
                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
                }else{
                	ComBtnDisable('btn_Create');
                }
            }
            formObj.onchange_flag.value = "N";
        }
        break;
    
    case SEARCH01: // MDM AUTH_TP_CD query
        var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
        var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
        // global var sestting
        G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
        G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
        break;
        
    case IBSAVE: // Save
        if(validateForm(sheetObj, formObj, sAction)){
            sheetObj.CellValue(1,'pck_cd') = formObj.pck_cd.value;
            sheetObj.CellValue(1,'pck_nm') = formObj.pck_nm.value;
            sheetObj.CellValue(1,'delt_flg') = formObj.delt_flg.value;
            formObj.f_cmd.value=MULTI;
            if(ComGetSaveString(sheetObj)==""){
            	sheetObj.CellValue(1,'ibflag') = "U";
            }
            if(ComShowConfirm(ComGetMsg("COM130101", "data"))){
                ComOpenWait(true);
                //var sXml=sheetObj.GetSaveXml("BCM_CCD_0013GS.do", FormQueryString(formObj) + "&" + ComGetSaveString(sheetObj));
                var sXml=sheetObj.GetSaveXml("BCM_CCD_0013GS.do", FormQueryString(formObj));
                sheetObj.LoadSaveXml(sXml);
                var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                if(result != "F"){
                    ComShowCodeMessage("COM130102", "Data");
                    doActionIBSheet(sheetObj, formObj, IBSEARCH);
                }else{
                    ComShowCodeMessage("COM130103", "data");
                }
            }
        }
        break;
    case IBCLEAR:
    	formObj.reset();
    	sheetObj.RemoveAll();
        ComBtnEnable('btn_Create');
        formObj.pck_cd.className = "input1";
    	formObj.pck_cd.readOnly = false;
        formObj.pck_nm.text = "";
	    //document.form.pck_cstms_cd.className = "input1";
	    //document.form.pck_cstms_cd.readOnly = false;
	    //ComEnableObject(document.form.btns_search1, true);
	    ComOpenWait(false);
        break;
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
     with(formObj){
         switch ( sAction ) {
             case IBSEARCH:
                 if (formObj.pck_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Code");
                     formObj.pck_cd.focus();
                     return false;
                 }
                 break;
             case IBSAVE:
                 if (formObj.pck_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Code");
                     formObj.pck_cd.focus();
                     return false;
                 } else if (formObj.pck_nm.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Name");
                     formObj.pck_nm.focus();
                     return false;
                 }else if(formObj.onchange_flag.value != "Y") {
                     ComShowCodeMessage("COM130503");
                     return;
                  }
                 break;
         }
     }
     return true;    
 }



function initControl() {
    var formObj=document.form;
    //axon_event.addListenerForm('deactivate', 'obj_deactivate', form);
    //axon_event.addListenerForm('focus', 'obj_activate', form);
    //axon_event.addListenerForm('change', 'obj_change', form);
    axon_event.addListenerForm('keypress', 'obj_KeyPress', form);
    axon_event.addListenerForm('change', 'obj_change', form);
}
/**
* If the data field to be the CHANGE Event
*/


function obj_change(){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "pck_cd":
            if(formObj.pck_cd.value.length>0){
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
            }
        break;
        case "delt_flg":
            if (formObj.delt_flg.value == 'Y'){
                var checkFirm=ComShowConfirm(ComGetMsg("CCD00012"));
                if (checkFirm == 1){
                    formObj.delt_flg.value='Y';
                }else{
                    formObj.delt_flg.value='N';
                }
            }
            formObj.onchange_flag.value = "Y";
        break;
        case "pck_nm":
        	if(formObj.pck_cd.value.length>0){
        		formObj.onchange_flag.value = "Y";
        	}
       } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        } else {
            ComShowMessage(e.message);
        }
    }
}

function sheet1_OnSearchEnd(sheet1, ErrMsg){
     ComOpenWait(false);
 }

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}
