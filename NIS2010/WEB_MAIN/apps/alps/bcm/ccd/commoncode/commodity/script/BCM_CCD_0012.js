/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0012.js
*@FileTitle  : Customs Package Type Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/** Common global variable */
function bcm_ccd_0012(){
	this.processButtonClick		= processButtonClick;
	this.getCnt_cd				= getCnt_cd;
	this.setSheetObject			= setSheetObject;
	this.setComboObject			= setComboObject;
	this.loadPage				= loadPage;
	this.initPage				= initPage;
	this.newPage				= newPage;
	this.doActionIBCombo		= doActionIBCombo;
	this.initSheet				= initSheet;
	this.doActionIBSheet		= doActionIBSheet;
	this.validateForm			= validateForm;
	this.initControl			= initControl;
	this.obj_change				= obj_change;
	this.pck_cd_OnChange		= pck_cd_OnChange;
	this.cstms_cnt_cd_OnChange	= cstms_cnt_cd_OnChange;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
} 

 
var sheetObjects=new Array();
var sheetCnt=0;
var saveRows=new Array();
var comboObjects=new Array();
var comboCnt=0; 
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button click event */
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
			
			var pckCd = formObj.pck_cd.Code;
			var mstKey = nullToBlank(pckCd);
			if (mstKey == "") {
				ComShowCodeMessage("CCD00038", "Package Type");
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
        	//newPage();
            break;
        case "btns_search": // Customs Country 팝업
            ComOpenPopup('/hanjin/COM_ENS_0M1.do', 780, 510, 'getCnt_cd', "1,0,1", true);
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
function getCnt_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.cstms_cnt_cd.value=colArray[3];
    if(formObj.pck_cd.Text.length>0 && formObj.cstms_cnt_cd.value.length>0){
           doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	
    var formObj=document.form;
    for (i=0; i < sheetObjects.length; i++) {
    	initSheet(sheetObjects[i], i + 1);
        ComConfigSheet(sheetObjects[i]);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
    //doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
   
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
 * new page is default Page 
 * newpage() is called by New Button  
 */
function newPage() {

    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    sheetObj.RemoveAll();
    formObj.reset();
    //pck_cd.SetEnable(1);
    pck_cd.text="";
    formObj.cstms_cnt_cd.disabled=false;
}
/**
* All the combo box query
*/
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    switch (sAction) {
        case SEARCH01: // load page 시
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0012GS.do", "f_cmd=" + SEARCH01);
            var rtnValue=sXml.split("|$$|");
            if (rtnValue.length > 0) 
				ComXml2ComboItem(rtnValue[0], formObj.pck_cd, "cd", "cd|cd_desc");
                        
            /*for(va.lengthValue.length; i++){
                var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
                var cdName=comboXml[0].split("|");
                var cdValue=comboXml[1].split("|");
                for (var j=0; j < cdName.length; j++) {
                    comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
                }
            }*/
        break;
    }
}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetObj.id) {
    case "sheet1" : // sheet1 init
    	with(sheetObj){
        //Host정보 설정[필수][HostIp, Port, PagePath]
        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
        InitRowInfo( 1, 1, 5, 100);
        InitColumnInfo(5, 0, 0, true);

        // 해더에서 처리할 수 있는 각종 기능을 설정한다
        InitHeadMode(false, true, true, false, false, false);

		
        // var HeadTitle="ibflag|pck_cd|cstms_cnt_cd|pck_cstms_cd|delt_flg"; 
         var HeadTitle="";
         
         //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
         InitHeadRow(0, HeadTitle, true);
         
			     //데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			    InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
			    InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "pck_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "cstms_cnt_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "pck_cstms_cd" ,     		false,          "",      	dfNone,   0,     true,       true);
         		InitDataProperty(0, cnt++ , dtData,      	134,   daCenter,    false,     "delt_flg" ,     		false,          "",      	dfNone,   0,     true,       true);
    	}
    	
 
        break;
    }
}
// Sheet processing-related processes
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBCREATE: // New retrieve
    	formObj.reset();    	
    	sheetObj.RemoveAll();
    	formObj.ibflag.value="I";
    	ComBtnDisable('btn_Create');
    	formObj.pck_cd.text = "";
    	formObj.pck_cd.Enable = true;
    	formObj.cstms_cnt_cd.className = "input1";
    	formObj.cstms_cnt_cd.readOnly = false;
	    document.form.pck_cstms_cd.className = "input1";
	    document.form.pck_cstms_cd.readOnly = false;
	    //ComEnableObject(document.form.btns_search, true);
   	break;
   	
    case IBSEARCH: // query
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH;
            //sheetObj.RenderSheet(0);
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0012GS.do", FormQueryString(formObj));;
            var arrXml = sXml.split("|$$|"); 
            var cstmsCntCd=ComGetEtcData(sXml, "cstms_cnt_cd");
            ComOpenWait(false);
            if (cstmsCntCd != undefined) {
            	sheetObjects[0].LoadSearchXml(arrXml[0]);
            	formObj.pck_cd.value = sheetObj.CellText(1, "pck_cd");
            	formObj.pck_cd.Enable = false;
                formObj.pck_cstms_cd.value = sheetObj.CellValue(1, "pck_cstms_cd");
                formObj.delt_flg.value = sheetObj.CellValue(1, "delt_flg");
            	formObj.cstms_cnt_cd.className = "input2";
            	formObj.cstms_cnt_cd.readOnly = true;
            	
                formObj.ibflag.value = "U";
                ComBtnEnable('btn_Create');
            }else{
                formObj.ibflag.value="I";
                if(!ComShowConfirm(ComGetMsg("CCD00034", "Customs Country"))){
                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
                }else{
                	ComBtnDisable('btn_Create');
                }
            }
            formObj.onchange_flag.value = "N";
            //sheetObj.RenderSheet(1);
        }
        break;
    case SEARCH02: // Country Code checking
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH02;
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0012GS.do", FormQueryString(formObj));
            var result=ComGetEtcData(sXml, "result");
                if(result==""){
                    ComShowCodeMessage("COM130402", "Customs Country");
                    formObj.cstms_cnt_cd.value="";
                    formObj.cstms_cnt_cd.focus();
                }
                ComOpenWait(false);
        }
        break;
    case SEARCH03: // MDM AUTH_TP_CD query
        var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
        var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
        // global var sestting
        G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
        G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
        break;
        
    case IBSAVE: // Save
        if(validateForm(sheetObj, formObj, sAction)){
        	sheetObj.CellValue(1,'pck_cd') = formObj.pck_cd.Code();
        	sheetObj.CellValue(1,'cstms_cnt_cd') = formObj.cstms_cnt_cd.value;
        	sheetObj.CellValue(1,'pck_cstms_cd') = formObj.pck_cstms_cd.value;
        	sheetObj.CellValue(1,'delt_flg') = formObj.delt_flg.value;
        	formObj.f_cmd.value=MULTI;
        	
            if(ComGetSaveString(sheetObj)==""){
                sheetObj.CellValue(1,'ibflag') = "U";
            }
            if(ComShowConfirm(ComGetMsg("COM130101", "data"))){
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveXml("BCM_CCD_0012GS.do", FormQueryString(formObj) + "&" + ComGetSaveString(sheetObj));
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
        formObj.pck_cd.text = "";
        formObj.pck_cd.Enable = true;
    	formObj.cstms_cnt_cd.className = "input1";
    	formObj.cstms_cnt_cd.readOnly = false;
	    document.form.pck_cstms_cd.className = "input1";
	    document.form.pck_cstms_cd.readOnly = false;
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
                 if (pck_cd.Text.length == 0){
                     ComShowCodeMessage("CCD00001", "Package Type");
                     pck_cd.focus();
                     return false;
                 } else if (formObj.cstms_cnt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Customs Country");
                     formObj.cstms_cnt_cd.focus();
                     return false;
                 }
                 break;
             case IBSAVE:  
                 if (pck_cd.Text.length == 0){
                     ComShowCodeMessage("CCD00001", "Package Type");
                     pck_cd.focus();
                     return false;
                 } else if (formObj.cstms_cnt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Customs Country");
                     formObj.cstms_cnt_cd.focus();
                     return false;
                 } else if (formObj.pck_cstms_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Package Customs");
                     formObj.pck_cstms_cd.focus();
                     return false;
                 }else if(formObj.onchange_flag.value != "Y") {
                     ComShowCodeMessage("COM130503");
                     return;
                  }
                 break;
             case SEARCH02:  
                 if(formObj.cstms_cnt_cd.value.length==0){
                     return false; 
                 }
                break; 
         }
     }
     return true;    
 }
function initControl() {
    var formObj=document.form;
    axon_event.addListenerForm('keypress', 'obj_KeyPress', form);
    axon_event.addListenerForm('change', 'obj_change', form);
    //axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
    //axon_event.addListenerForm('focus', 'obj_activate', formObj);
    //axon_event.addListenerForm('change', 'obj_change', formObj);
    //axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
}

function obj_change(){
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        //if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        case "delt_flg":
            if(formObj.delt_flg.value=='Y'){
                if(!ComShowConfirm(ComGetMsg("COM12165", "data"))){
                    formObj.delt_flg.value='N';
                }
            }
            formObj.onchange_flag.value = "Y";
        break;
        case "cstms_cnt_cd":
            if(formObj.pck_cd.Text.length>0 && formObj.cstms_cnt_cd.value.length>0){
            	doActionIBSheet(sheetObj, formObj, IBSEARCH);
            }
        break;
    	case "pck_cstms_cd":
	    	if(formObj.pck_cd.Text.length>0 && formObj.cstms_cnt_cd.value.length>0){
	        	formObj.onchange_flag.value = "Y";
        }
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

function pck_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    if(formObj.pck_cd.Text.length>0 && formObj.cstms_cnt_cd.value.length>0){
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
    }
}
/**
* If the data field to be the CHANGE Event
*/
/*function cstms_cnt_cd_OnChange() {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    doActionIBSheet(sheetObj, formObj, SEARCH02);
    alert("CC");
    //if(pck_cd.GetSelectText().length>0 && formObj.cstms_cnt_cd.length>0){
       doActionIBSheet(sheetObj, formObj, IBSEARCH);
    //}
}*/
function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	formObj.onchange_flag.value = "N";
    ComOpenWait(false);

}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	formObj.onchange_flag.value = "N";
    ComOpenWait(false);
}	
