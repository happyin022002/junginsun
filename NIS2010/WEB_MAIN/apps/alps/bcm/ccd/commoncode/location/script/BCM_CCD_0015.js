/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0015.js
*@FileTitle  : Subcontinent
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

/** Common global variable */
var sheetObjects=new Array(); 
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/** Event handler processing by button click event */
document.onclick=processButtonClick;
/** Event handler processing by button name */
function processButtonClick(){
    /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
    var sheetObject1=sheetObjects[0];
     /*******************************************************/
    var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        //if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
				case "btn_History":
					var tblNo = 'MDM_SUBCONTINENT';
					var scontiCd = formObject.sconti_cd.value;
					var mstKey = nullToBlank(scontiCd);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Sub Continent Code");
					return false;
					}
					comMdmCallPop(tblNo, mstKey); 
		    	break;	
        
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_New":
                    clearAllData(sheetObject1, formObject);
                    break;
                case "btn_Save":
                    doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;
				case "btn_Create":
					doActionIBSheet(sheetObject1,	formObject, IBCREATE);
					break;         
                case "btns_search1":
                    openScontiCd();
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
 * registering IBSheet Object as list
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
/*    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }*/
    
    initControl();
    document.form.ibflag.value="I";
    doActionIBCombo(sheetObjects[0], document.form, SEARCH01);
    //1. AUTH Search  
    //doActionIBSheet(sheetObjects[0], document.form, SEARCH02);
    //2. AUTH에 따른 버튼  Enable / Disable 처리 
   /* if (G_MDAA_CHK == "Y") {
        ComSetDisplay('btn_Retrieve', true);   
        ComSetDisplay('btn_New', true);   
        ComSetDisplay('btn_Save', true);   
    }   
    else {
        ComSetDisplay('btn_Retrieve', true);   
        ComSetDisplay('btn_New', true);   
        ComSetDisplay('btn_Save', false);   
    } */
    //3. AUTH에 따른 버튼 delt_flg Enable / Disable 처리 
/*    if(G_MDAA_CHK == "Y")
        ComEnableObject(document.form.delt_flg, true); 
    else
        ComEnableObject(document.form.delt_flg, false);    */     
}
/**
 * Define an event control
 */
function initControl() {
    var formObj=document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
    //axon_event.addListenerForm('focus', 'obj_focus', formObj);
    //axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
    //axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    //axon_event.addListenerForm  ('change', 'obj_change', form);
    //ComClearSeparator (document.form.sconti_cd,"eng"); //English Only
}
/**
 * setting Combo initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting Combos
 */
 function initCombo(comboObj, comboNo) {
    var formObject=document.form;
    switch(comboObj.options.id) {  
        case "conti_cd":        //Yard 
            with (comboObj) { 
                SetMultiSelect(0);
                SetUseAutoComplete(1);
                SetColAlign(0, "left");
                SetColWidth(0, "100");
                SetDropHeight(100);
                SetMaxLength(2);
                ValidChar(2,0);
            }
        break;
    }
 }
 /**
  * param : sheetObj, sheetNo
  * setting sheet initial values and header
  * adding case as numbers of counting sheets
  */
 function initSheet(sheetObj,sheetNo) {
    var cnt=0;
     switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
            with(sheetObj){
        	//Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	         InitRowInfo( 1, 1, 5, 100);
	         
	         InitColumnInfo(9, 0, 0, true);
	         
             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, true, true, false, false, false);
	        	
             var HeadTitle="";
             
             InitHeadRow(0, HeadTitle, true);
             var prefix="sheet1_";
             
   			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    prefix+"ibflag");
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"sconti_cd",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"sconti_nm",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"conti_cd",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"delt_flg",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cre_usr_id",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cre_dt",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"upd_usr_id",		false,          "",      	dfNone,      0,     true,       true);
 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"upd_dt",		false,          "",      	dfNone,      0,     true,       true);
             
            }
            break;
     }
 }
  /**
   * All the combo box query
   */
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    switch (sAction) {
        case SEARCH01: // load page
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0015GS.do", "f_cmd=" + SEARCH01);
            var rtnValue=sXml.split("|$$|");
			if (rtnValue.length > 0) 
				ComXml2ComboItem(rtnValue[0], formObj.conti_cd, "cd", "cd|cd_desc");
            
/*            for(var i=0; i<rtnValue.length; i++){
                var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
                if(comboXml!=null){
                    var cdName=comboXml[0].split("|");
                    var cdValue=comboXml[1].split("|");
                    for (var j=0; j < cdName.length; j++) {
                        comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
                    }
                }
            }*/
        break;
    }
}
//handling sheet process
 function doActionIBSheet(sheetObj,formObj,sAction) {
     var prefix="sheet1_";
     switch(sAction) {
	    case IBCREATE: // New retrieve
	     	clearAllData(sheetObj, formObj);
	     	ComBtnDisable('btn_Create');
	    	break;
        case IBSEARCH:      //Retrieve
            if(validateForm(sheetObj,formObj,sAction)){
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var sParam=FormQueryString(formObj);
                var sXml=sheetObj.GetSearchXml("BCM_CCD_0015GS.do", sParam + "&" + ComGetPrefixParam("sheet1_"));
                var arrXml = sXml.split("|$$|"); 
                var sconti_nm=ComGetEtcData(sXml, "sconti_nm");
                ComOpenWait(false);
                if(sconti_nm == undefined){
                    formObj.sconti_nm.value="";
                    formObj.delt_flg.value="N";
                    formObj.ibflag.value="I";
                    //conti_cd.SetSelectText("");
 	                if(!ComShowConfirm(ComGetMsg("CCD00034", "Sub Continent Code"))){
 	                	clearAllData(sheetObj, formObj);
 	                }else{
 	                	ComBtnDisable('btn_Create');
 	                }
                }else{
        	 		formObj.sconti_cd.readOnly=true;
        	 		formObj.sconti_cd.className = "input2";
        	 		formObj.onchange_flag.value = "N";
                	
                	sheetObj.LoadSearchXml(arrXml[0]);
                    formObj.sconti_nm.value=sconti_nm;
                    //conti_cd.SetEnable(0);
                    ComSetObjValue(formObj.conti_cd, ComGetEtcData(arrXml,"conti_cd"));
                    //conti_cd.SetSelectCode(ComGetEtcData(sXml, "conti_cd"));
                    formObj.delt_flg.value=ComGetEtcData(arrXml, "delt_flg");
                    formObj.ibflag.value="U";
                    //formObj.sconti_cd.readOnly=true;
                    //formObj.sconti_cd.disabled=true;
                    formObj.cre_usr_id.value = sheetObj.CellValue(1, "sheet1_cre_usr_id");
                    formObj.cre_dt.value = sheetObj.CellValue(1, "sheet1_cre_dt").substring(0, 19);
                    formObj.upd_usr_id.value = sheetObj.CellValue(1, "sheet1_upd_usr_id");
                    formObj.upd_dt.value = sheetObj.CellValue(1, "sheet1_upd_dt").substring(0, 19);
                }
            }
        break;
        case SEARCH02: // MDM AUTH_TP_CD query
            var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
            var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
            // global var sestting
            G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
            G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
            break;
        case IBSAVE:
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                if(ComShowCodeConfirm("COM130101", "Data")){
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSaveXml("BCM_CCD_0015GS.do", sParam);
                    sheetObj.LoadSaveXml(sXml);
                    var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                    if(result != "F"){
                        doActionIBSheet(sheetObj, formObj, IBSEARCH);
                    }else{
                        ComShowCodeMessage("COM130103", "Data");
                    }
                }
            }
        break;
     }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
    switch(sAction) {
        case IBSEARCH:      //Retrieve
            if(formObj.sconti_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Sub Continent Code");
                formObj.sconti_cd.focus();
                return false;
            }
            break;
        case IBSAVE:        //Save
            if(formObj.onchange_flag.value != "Y") {
                ComShowCodeMessage("COM130503");
                return;
             }
            if(formObj.sconti_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Sub Continent Code");
                formObj.sconti_cd.focus();
                return false;
            }else if(formObj.sconti_nm.value == ""){
                ComShowCodeMessage("CCD00001", "Sub Continent Name");
                formObj.sconti_nm.focus();
                return false;
            }else if(formObj.conti_cd.Code == ""){
                ComShowCodeMessage("CCD00001", "Continent Code");
                formObj.conti_cd.Focus();
                return false;
            }
            break;
    }
     return true;
}

/**
 * If the data field to be the change event
 */
function obj_change(){
	document.form.onchange_flag.value = "Y";
    var formObject=document.form;
    /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
      var sheetObject1=sheetObjects[0];
      /*******************************************************/
    try {
        var srcName=ComGetEvent("name");
          switch(srcName) {
            case "sconti_cd":
                if(formObject.sconti_cd.value.length>0){
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
/*                    if((formObject.sconti_nm.value == null) || (formObject.sconti_nm.value == "")) {
                        if (G_MDAA_CHK == "Y") { 
                            if (ComShowCodeConfirm("COM130407", "Sub Continent Code")) {
                                formObject.sconti_nm.focus();
                            } else {
                                clearAllData(sheetObject1, formObject);
                            }
                        }   
                        else {
                            ComShowCodeMessage("COM130402", "Sub Continent");
                            clearAllData(sheetObject1, formObject);
                        }   
                    }   */
                }
            break;
            case "delt_flg" :
                if(formObject.delt_flg.value == "Y") {
                    if(!ComShowCodeConfirm("COM130301", "data")) formObject.delt_flg.value="N";
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
/*
 * 
 */
function clearAllData(sheetObj, formObj){
	formObj.conti_cd.text = "";
    formObj.sconti_cd.value="";
    formObj.sconti_nm.value="";
    formObj.delt_flg.value="N";
    formObj.ibflag.value="I";           
    formObj.sconti_cd.disabled=false;
    formObj.sconti_cd.readOnly=false;
    formObj.reset();
    sheetObj.RemoveAll();
    
	formObj.sconti_cd.className = "input1";
	ComBtnEnable('btn_Create');
    
    //conti_cd.SetEnable(1);
    //conti_cd.SetSelectText("");
    
}
/**
 * Lane Code Help file open
 */
function openScontiCd() {
    var formObj=document.form;
    var sUrl="/hanjin/COM_ENS_0I1.do?sconti_cd=" + formObj.sconti_cd.value +"&main_page=false"+ "&mdm_yn=Y";
    var rVal=ComOpenPopup(sUrl, 750, 380, "scontiCodeHelp", "0,0", true);
}
/**
 * Set selected value in the  sconti  code Inquiry pop-up.
 */
function scontiCodeHelp(rowArray) {
    var formObj=document.form;
    var colArray=rowArray[0];   
    formObj.sconti_cd.value=colArray[1];
    doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    ComBtnEnable('btn_Create');
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    ComBtnEnable('btn_Create');
}
