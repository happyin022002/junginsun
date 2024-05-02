/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0009.js
*@FileTitle  : Group Commodity 
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
					var tblNo = 'MDM_GRP_CMDT';
					var grpCmdtCd = formObj.grp_cmdt_cd.value;
					var mstKey = nullToBlank(grpCmdtCd);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Group Commodity Code");
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
	            case "btn_New":
	                newPage();
	                break;
				case "btn_Create":
					doActionIBSheet(sheetObj, formObj, IBCREATE);
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
/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
    function setSheetObject(sheet_obj) {
        sheetObjects[sheetCnt++]=sheet_obj;
    }
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
    function loadPage() {
        var formObj=document.form;
        for (i=0; i < sheetObjects.length; i++) {
            ComConfigSheet(sheetObjects[i]);
            initSheet(sheetObjects[i], i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        initControl();
        //1. AUTH Search  
        //doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
        //2. AUTH에 따른 버튼  Enable / Disable 처리        
/*        if (G_MDAA_CHK == "Y") {
            //ComSetDisplay('btn_Retrieve', true);   
            //ComSetDisplay('btn_New', true);   
            ComSetDisplay('btn_Save', true);   
        }   
        else {
            //ComSetDisplay('btn_Retrieve', true);   
            //ComSetDisplay('btn_New', true);   
            ComSetDisplay('btn_Save', false);   
        } 
        //3. AUTH에 따른 버튼 delt_flg Enable / Disable 처리 
        if(G_MDAA_CHK == "Y")
            ComEnableObject(formObj.delt_flg, true); 
        else
            ComEnableObject(formObj.delt_flg, false); */
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
        formObj.grp_cmdt_cd.disabled=false;
        formObj.grp_cmdt_cd.readOnly=false;
        formObj.ibflag.value="I";
        formObj.delt_flg.value="N";
    	formObj.grp_cmdt_cd.className = "input1";
    	ComBtnEnable('btn_Create');
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
 * The initial setting sheet, Header definition
 * param : sheetObj ==> sheet object, sheetNo ==> Sheet object ID of the tag attached to the serial number
 * If the number of seats a case by adding the number of sheets sheets should initialize the module configuration
 */
function initSheet(sheetObj, sheetNo) {
    var cnt=0;
    switch (sheetNo) {
    case 1: // sheet1 init
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
			 InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    prefix+"ibflag");
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"min_rep_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"max_rep_cmdt_cd",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_eng_nm",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_krn_nm",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_jpn_nm",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"grp_cmdt_chn_nm",		false,          "",      	dfNone,      0,     true,       true);
			 InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     prefix+"delt_flg",		false,          "",      	dfNone,      0,     true,       true);

          }
        break;
    }
}
// Sheet processing-related processes
function doActionIBSheet(sheetObj, formObj, sAction) {
    //sheetObj.ShowDebugMsg(false);
    switch (sAction) {
    case IBCREATE: // New retrieve
    	newPage();
     	ComBtnDisable('btn_Create');
    	break;
    	
    case IBSEARCH: // retrieve
        if (validateForm(sheetObj, formObj, sAction)){
            formObj.f_cmd.value=SEARCH;
            //sheetObj.RenderSheet(0);
            ComOpenWait(true);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0009GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"));
            var arrXml = sXml.split("|$$|"); 
            //var grp_cmdt_cd=ComGetEtcData(sXml, "grp_cmdt_cd");
            sheetObjects[0].LoadSearchXml(arrXml[0]);
            ComOpenWait(false);
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
            sheetObj.CellValue(1,'sheet1_grp_cmdt_cd') = formObj.grp_cmdt_cd.value;
            sheetObj.CellValue(1,'sheet1_min_rep_cmdt_cd') = formObj.min_rep_cmdt_cd.value;
            sheetObj.CellValue(1,'sheet1_max_rep_cmdt_cd') = formObj.max_rep_cmdt_cd.value;
            sheetObj.CellValue(1,'sheet1_grp_cmdt_eng_nm' ) = formObj.grp_cmdt_eng_nm.value;
            sheetObj.CellValue(1,'sheet1_grp_cmdt_krn_nm' ) = formObj.grp_cmdt_krn_nm.value;
            sheetObj.CellValue(1,'sheet1_grp_cmdt_jpn_nm' ) = formObj.grp_cmdt_jpn_nm.value;
            sheetObj.CellValue(1,'sheet1_grp_cmdt_chn_nm') = formObj.grp_cmdt_chn_nm.value;
            sheetObj.CellValue(1,'sheet1_delt_flg' ) = formObj.delt_flg.value;
            formObj.f_cmd.value=MULTI;
            if(ComShowConfirm(ComGetMsg("COM130101", "data"))){
                ComOpenWait(true);
                var sXml=sheetObj.GetSaveXml("BCM_CCD_0009GS.do", FormQueryString(formObj));
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
    }
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
     with(formObj){
         switch ( sAction ) {
             case IBSEARCH:
                 if (formObj.grp_cmdt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Code");
                     formObj.grp_cmdt_cd.focus();
                     return false;
                 }
                 break;
             case IBSAVE:  
                 if(formObj.onchange_flag.value != "Y") {
                     ComShowCodeMessage("COM130503");
                     return;
                  }
                 if (formObj.grp_cmdt_cd.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Code");
                     formObj.grp_cmdt_cd.focus();
                     return false;
                 } else if (formObj.grp_cmdt_eng_nm.value.length == 0){
                     ComShowCodeMessage("CCD00001", "Group English Name");
                     formObj.grp_cmdt_eng_nm.focus();
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
*If the data field to be the CHANGE Event
*/
function obj_change(){
	document.form.onchange_flag.value = "Y";
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    try {
        var srcName=ComGetEvent("name");
        switch(srcName) {
        case "grp_cmdt_cd":
            if(formObj.grp_cmdt_cd.value.length>0){
                doActionIBSheet(sheetObj, formObj, IBSEARCH);
/*                if(sheetObj.RowCount("R") == 0) {
                    if (G_MDAA_CHK == "Y") { 
                        if (ComShowCodeConfirm("COM130407", "Group Commodity Code")) {
                            formObj.min_rep_cmdt_cd.focus();
                        } else {
                            newPage();  
                        }
                    }   
                    else {
                        ComShowCodeConfirm("COM130402", "Group Commodity Code");
                        newPage();
                    }
                }   */
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
    ComBtnEnable('btn_Create');
    if (sheet1.RowCount> 0){
        formObj.grp_cmdt_cd.value=sheet1.CellValue(1,'sheet1_grp_cmdt_cd');
        formObj.min_rep_cmdt_cd.value=sheet1.CellValue(1,'sheet1_min_rep_cmdt_cd');
        formObj.max_rep_cmdt_cd.value=sheet1.CellValue(1,'sheet1_max_rep_cmdt_cd');
        formObj.grp_cmdt_eng_nm.value=sheet1.CellValue(1,'sheet1_grp_cmdt_eng_nm');
        formObj.grp_cmdt_krn_nm.value=sheet1.CellValue(1,'sheet1_grp_cmdt_krn_nm');
        formObj.grp_cmdt_jpn_nm.value=sheet1.CellValue(1,'sheet1_grp_cmdt_jpn_nm');
        formObj.grp_cmdt_chn_nm.value=sheet1.CellValue(1,'sheet1_grp_cmdt_chn_nm');
        formObj.delt_flg.value=sheet1.CellValue(1,'sheet1_delt_flg');
        
 		formObj.grp_cmdt_cd.readOnly=true;
 		formObj.grp_cmdt_cd.className = "input2";
 		formObj.onchange_flag.value = "N";
 		formObj.ibflag.value="U";
    }else{
        formObj.delt_flg.value="N";
        formObj.ibflag.value="I";
        
        if(!ComShowConfirm(ComGetMsg("CCD00034", "Group Commodity Code"))){
        	newPage();
        }else{
        	ComBtnDisable('btn_Create');
        }
    }
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    ComBtnEnable('btn_Create');
}
