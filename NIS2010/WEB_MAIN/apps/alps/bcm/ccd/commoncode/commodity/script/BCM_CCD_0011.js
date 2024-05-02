/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0010.js
*@FileTitle  : Commodity
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
var saveRows=new Array();
var comboObjects=new Array();
var comboCnt=0; 
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
			var tblNo = 'MDM_COMMODITY';
			var cmdtCd = formObj.cmdt_cd.value;
			var mstKey = nullToBlank(cmdtCd);
			if (mstKey == "") {
				ComShowCodeMessage("CCD00038", "Commodity Code");
			return false;
			}
			comMdmCallPop(tblNo, mstKey); 
    	break;
    	
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
        case "btn_Close":
            ComClosePopup(); 
            break;
        case "btn_Request":
            doActionIBSheet(sheetObjects[0], document.form, MULTI03); 
            break;
        case "btns_search": // Commodity Code pop-up
            var v1=formObj.mdm_yn.value;
            var classId="COM_ENS_011";
            var param='?mdm_yn='+v1+'&classId='+classId;

            ComOpenPopup('/hanjin/COM_ENS_011.do' + param, 850, 450, 'getCmdt_cd', "1,0,1", true);
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
function getCmdt_cd(rowArray) {
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var colArray=rowArray[0];
    formObj.cmdt_cd.value=colArray[3];
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
    var formObj=document.form;
    for (i=0; i < sheetObjects.length; i++) {
        ComConfigSheet(sheetObjects[i]);
        initSheet(sheetObjects[i], i + 1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    initControl();
    doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
    // auth_tp_cd retrieve
    //doActionIBSheet(sheetObjects[0], formObj, SEARCH10);
    var authTpCd=G_AHTU_TP_CD;
    var rqstNo=formObj.rqst_no.value;
/*    if(G_MDAA_CHK == 'Y')
        ComEnableObject(formObj.delt_flg, true); 
    else
        ComEnableObject(formObj.delt_flg, false); */
    // If the Process Status screen call, in the Detail PopUp
/*    if(rqstNo != '') {
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        ComSetDisplay('btn_Close', true);
        var procTpCd=formObj.proc_tp_cd.value;
        var rqstUsrChk=formObj.rqst_usr_chk.value;
        ComEnableObject(formObj.btns_search, false);
        // Process Type is 'Reject' and AuthType is not 'Approval'(possible modifications and ReOpen)
        if(procTpCd == 'R' &&  ( ((authTpCd == 'R' || authTpCd == 'S') && rqstUsrChk == 'Y') || G_MDAA_CHK == 'Y') ) {
            ComSetDisplay('btn_Request', true);
            ComGetObject("btn_Request").style.setProperty("color", "#FF0000", "important");
            ComSetDisplay('btn_Retrieve', true);
            ComSetDisplay('btn_Save', true);
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        } else if(procTpCd == 'A') {
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
            ComEnableObject(formObj.btns_search, false);
        } else {
            doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
        }
    } else {
        ComSetDisplay('btn_Retrieve', true);
        // MDM Authority is not Approval('A') or MDDA
        if( authTpCd == 'R' || authTpCd == 'S' || G_MDAA_CHK == 'Y') {
            ComSetDisplay('btn_New', true);
            ComSetDisplay('btn_Save', true);
        } else {
            //General User if you do not have MDM Authority
            ComSetDisplay('btn_New', true);
        }
    }*/
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
* All the combo box query
*/
function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
    switch (sAction) {
        case SEARCH01: // load page 
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0011GS.do", "f_cmd=" + SEARCH01);
            var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0) 
				ComXml2ComboItem(arrXml[0], formObj.rep_cmdt_cd, "cd", "cd|cd_desc");
			if (arrXml.length > 1) 
				ComXml2ComboItem(arrXml[1], formObj.rep_imdg_lvl_cd, "cd", "cd|cd_desc");
			if (arrXml.length > 2) 
				ComXml2ComboItem(arrXml[2], formObj.grp_cmdt_cd, "cd", "cd|cd_desc");
            /*
            if(rtnValue!=null && rtnValue.length>0){
                for(var i=0;i<rtnValue.length;i++){
                    var frm;
                    switch(i){
                        case 0:frm=rep_cmdt_cd; break;
                        case 1:frm=rep_imdg_lvl_cd; break;
                    }
                    ComXml2ComboItem(rtnValue[i], frm, "cd", "cd|cd_desc");
                    rep_cmdt_cd.SetColWidth(0, "50");
                    rep_cmdt_cd.SetColWidth(1, "555");
                }
                
                for(var i=0; i<rtnValue.length; i++){
                    var comboXml=ComXml2ComboString(rtnValue[i], "cd_desc", "cd");
                    if(comboXml!=null && comboXml!=undefined && comboXml!='undefined'){
                        var cdName=comboXml[0].split("|");
                        var cdValue=comboXml[1].split("|");
                        for (var j=0; j < cdName.length; j++) {
                            comboObjects[i].InsertItem(j, cdName[j], cdValue[j]);
                        }
                    }
                }
               
            } */
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
    switch (sheetNo) {
    case 1: // sheet1 init
        with(sheetObj){	
	        //Host정보 설정[필수][HostIp, Port, PagePath]
	        if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	         InitRowInfo( 1, 1, 5, 100);
	         
	         InitColumnInfo(14, 0, 0, true);
	         
	         // 해더에서 처리할 수 있는 각종 기능을 설정한다
	         InitHeadMode(false, true, true, false, false, false);
	         
              var HeadTitle="|CMDT_CD|CMDT_NM|REP_IMDG_LVL_CD|REP_CMDT_CD|FMC_EXP_FLG|DELT_FLG|MODI_CMDT_CD";
              
              InitHeadRow(0, HeadTitle, true);
              var prefix="sheet1_";
              
    			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
  			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    prefix+"ibflag");
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cmdt_nm",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"rep_imdg_lvl_cd",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"rep_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"fmc_exp_flg",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"chem_flg",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"delt_flg",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"modi_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cre_usr_id",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"cre_dt",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"upd_usr_id",		false,          "",      	dfNone,      0,     true,       true);
  			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"upd_dt",		false,          "",      	dfNone,      0,     true,       true);
  			//InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"eu_xpt_flg",		false,          "",      	dfNone,      0,     true,       true);

            }
        break;
    }
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBCREATE: // New retrieve
    	doActionIBSheet(sheetObj, formObj, IBCLEAR);
     	ComBtnDisable('btn_Create');
    	break;
    
    case IBSEARCH: // Retrieve
        if (validateForm(sheetObj, formObj, sAction)){
            if( formObj.rqst_no.value == ''){
                formObj.f_cmd.value=SEARCH;
            }else{
                formObj.f_cmd.value=SEARCH02;
//                ComBtnDisable("btn_Save");  
            }
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0011GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
            var arrXml = sXml.split("|$$|");
            var rqstNo=ComGetEtcData(sXml, "RQST_NO");
            ComSetObjValue(formObj.rqst_no, rqstNo);
            sheetObjects[0].LoadSearchXml(arrXml[0]);
/*            formObj.cmdt_cd.disabled=true;
            if(sheetObj.RowCount== 0){ // Insert mode when no data is
                formObj.creflag.value="Y";
                if(G_AHTU_TP_CD=="A"){
                    ComShowCodeMessage("CCD00033", "Commodity Code");
                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
                }else{
                    if(!ComShowConfirm(ComGetMsg("CCD00034", "Commodity Code"))){
                        doActionIBSheet(sheetObj, formObj, IBCLEAR);
                    }
                }
                sheetObj.DataInsert(-1);
            } else {
                formObj.creflag.value="N";
            }*/
        }
        break;
    case IBSAVE: // Save
        if(validateForm(sheetObj, formObj, sAction)){
/*            sheetObj.CellValue(1,'sheet1_cmdt_cd') = formObj.cmdt_cd.value;
            sheetObj.CellValue(1,'sheet1_cmdt_nm') = formObj.cmdt_nm.value;
            sheetObj.CellValue(1,'sheet1_rep_imdg_lvl_cd') = rep_imdg_lvl_cd.GetSelectCode();
            sheetObj.CellValue(1,'sheet1_rep_cmdt_cd') = rep_cmdt_cd.GetSelectCode();*/
//          sheetObj.CellValue(1,'sheet1_grp_cmdt_cd')     = formObj.grp_cmdt_cd.Code;
/*            sheetObj.CellValue(1,'sheet1_fmc_exp_flg') = formObj.fmc_exp_flg.value;
            sheetObj.CellValue(1,'sheet1_delt_flg') = formObj.delt_flg.value;
            sheetObj.CellValue(1,'sheet1_modi_cmdt_cd') = formObj.modi_cmdt_cd.value;*/
            //sheetObj.CellValue(1,'sheet1_eu_xpt_flg') = formObj.eu_xpt_flg.value;
            //if( formObj.creflag.value == "N" && formObj.rqst_no.value == ''){
                formObj.f_cmd.value=MULTI;
 /*           }else{
                formObj.f_cmd.value=MULTI01;
                ComEnableObject(form.btns_search, false);
            }*/
/*            if(ComGetSaveString(sheetObj)==""){
                sheetObj.SetCellValue(1,'sheet1_ibflag',"U");
            }
            var tmpMsg="";
            if(formObj.creflag.value != "N" && formObj.rqst_no.value == ''){
                tmpMsg="CCD00035";
            }else{
                tmpMsg="COM130101";
            }*/
            if(ComShowConfirm(ComGetMsg("COM130101", "data"))){
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveXml("BCM_CCD_0011GS.do", FormQueryString(formObj) );
                sheetObj.LoadSaveXml(sXml);
                var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                if(result != "F"){
                    ComShowCodeMessage("COM130102", "Data");
                    doActionIBSheet(sheetObj, formObj, IBSEARCH);
                }else{
                    ComShowCodeMessage("COM130103", "Data");
                }
            }
        }
        break;
    case SEARCH10: // MDM AUTH_TP_CD query
        var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=CMDT';
        var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
        // global var sestting
        G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
        G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
        break;
    case MULTI03:   // Request
        if (!ComShowCodeConfirm("CCD00030")) {
            return;
        }
        var sParam='f_cmd=' + MULTI03 + '&rqst_no=' + ComGetObjValue(formObj.rqst_no) + '&rqst_ofc_cd=' + ComGetObjValue(formObj.rqst_ofc_cd) + '&proc_tp_cd=O';
        var sXml=sheetObj.GetSaveData("BCM_CCD_2002GS.do", sParam);
        var sav=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
        if(sav == "S"  ){
            ComShowCodeMessage("CCD00031");
            ComPopUpReturnValue("Y");
        ComClosePopup(); 
        } else {
            ComShowCodeMessage("COM130103", "Data");
        }
        break;
    case IBCLEAR:
        sheetObj.RemoveAll();
        formObj.reset();
        formObj.cmdt_cd.value="";
        formObj.rep_cmdt_cd.text="";
        formObj.grp_cmdt_cd.text = "";
        formObj.rep_imdg_lvl_cd.text="";
        formObj.rqst_no.value="";
        formObj.chem_flg.Code="N";
        ComEnableObject(form.btns_search, true);
        ComBtnEnable("btn_Create"); 
        formObj.cmdt_cd.className = "input1";
        formObj.cmdt_cd.readOnly = false;
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
                 if( formObj.rqst_no.value == ''){
                     if (formObj.cmdt_cd.value.length == 0){
                         ComShowCodeMessage("CCD00001", "Code");
                         formObj.cmdt_cd.focus();
                         return false;
                     }
                 }
                 break;
             case IBSAVE:  
                 if(formObj.onchange_flag.value != "Y") {
                     ComShowCodeMessage("COM130503");
                     return;
                  }
                 if (formObj.cmdt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Code");
                     formObj.cmdt_cd.focus();
                     return false;
                 } else if (ComTrimAll(formObj.cmdt_nm.value).length == 0){
                     ComShowCodeMessage("CCD00001", "Name");
                     formObj.cmdt_nm.focus();
                     return false;
                 } else if (formObj.rep_cmdt_cd.Code.length == 0){
                     ComShowCodeMessage("CCD00001", "Rep Code");
                     formObj.rep_cmdt_cd.focus();
                     return false;
                 }else if (formObj.grp_cmdt_cd.Code.length == 0){
                   ComShowCodeMessage("CCD00001", "Group Code");
                   formObj.grp_cmdt_cd.focus();
                   return false;
                 }
                 break;
         }
     }
     return true;    
 }
function initControl() {
    var formObj=document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
    //axon_event.addListenerForm('deactivate', 'obj_deactivate', formObj);
    //axon_event.addListenerForm('focus', 'obj_activate', formObj);
    //axon_event.addListenerForm('change', 'obj_change', formObj);
    //axon_event.addListenerFormat('keypress', 'obj_keypress', formObj);
}
/**
* If the data field to be the change event
*/
function obj_change(){
	document.form.onchange_flag.value = "Y";
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        //if(ComGetBtnDisable(srcName)) return false;
        switch(srcName) {
        case "cmdt_cd":
            if(formObj.cmdt_cd.value.length>0){
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
            }
        break;
        case "delt_flg":
            if(formObj.delt_flg.value=='Y'){
                if(!ComShowConfirm(ComGetMsg("COM12165", "data"))){
                    formObj.delt_flg.value='N';
                }
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

function sheet1_OnSearchEnd(sheet1, ErrMsg){
    ComOpenWait(false);
    var formObj=document.form;
    if (sheet1.RowCount> 0){
    	formObj.ibflag.value="U";
    	formObj.cmdt_cd.readOnly=true;
 		formObj.cmdt_cd.className = "input2";
 		formObj.onchange_flag.value = "N";
 		ComBtnEnable('btn_Create');
    	
        formObj.cmdt_cd.value=sheet1.CellValue(1,'sheet1_cmdt_cd');
        formObj.cmdt_nm.value=sheet1.CellValue(1,'sheet1_cmdt_nm');
        
        formObj.rep_imdg_lvl_cd.Code = sheet1.CellValue(1,'sheet1_rep_imdg_lvl_cd');
        formObj.rep_cmdt_cd.Code = sheet1.CellValue(1,'sheet1_rep_cmdt_cd');
        formObj.chem_flg.value = sheet1.CellValue(1,'sheet1_chem_flg');
        
        formObj.grp_cmdt_cd.Code = sheet1.CellValue(1,'sheet1_grp_cmdt_cd');
        formObj.fmc_exp_flg.value=sheet1.CellValue(1,'sheet1_fmc_exp_flg');
        formObj.delt_flg.value=sheet1.CellValue(1,'sheet1_delt_flg');
        //formObj.modi_cmdt_cd.value=sheet1.CellValue(1,'sheet1_modi_cmdt_cd');
        formObj.cre_usr_id.value=sheet1.CellValue(1,'sheet1_cre_usr_id');
        formObj.cre_dt.value=sheet1.CellValue(1,'sheet1_cre_dt').substring(0, 19);
        formObj.upd_usr_id.value=sheet1.CellValue(1,'sheet1_upd_usr_id');
        formObj.upd_dt.value=sheet1.CellValue(1,'sheet1_upd_dt').substring(0, 19);
        //formObj.eu_xpt_flg.value=sheet1.CellValue(1,'sheet1_eu_xpt_flg');
    }else{
        formObj.delt_flg.value="N";
        formObj.ibflag.value="I";
        
         if(!ComShowConfirm(ComGetMsg("CCD00034", "Commodity Code"))){
        	 doActionIBSheet(sheetObj, formObj, IBCLEAR);
         }else{
         	ComBtnDisable('btn_Create');
         }
    	
    }
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}
