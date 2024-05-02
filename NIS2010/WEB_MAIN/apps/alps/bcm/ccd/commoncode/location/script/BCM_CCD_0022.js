/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0022.js
*@FileTitle  : equipment ORG chart
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/03
=========================================================*/
function BCM_CCD_0022() { 
	this.processButtonClick		= tprocessButtonClick;
	this.setSheetObject		    = setSheetObject;
	this.setComboObject		    = setComboObject;
	this.loadPage		        = loadPage;
	this.initControl			= initControl;
	this.initSheet				= initSheet;
	this.resizeSheet			= resizeSheet;
	this.doActionIBCombo		= doActionIBCombo;
	this.doActionIBSheet		= doActionIBSheet;
	this.obj_change				= obj_change;
	this.sheet1_OnMouseDown		= sheet1_OnMouseDown;
	this.sheet1_OnComboChange	= sheet1_OnComboChange;
	this.sheet1_OnChange		= sheet1_OnChange;
	this.sheet1_OnPopupClick	= sheet1_OnPopupClick;
	this.locCodeHelp			= locCodeHelp;
	this.clearAllData			= clearAllData;
	this.validateForm			= validateForm;
	this.checkDelValidation		= checkDelValidation;
	this.sheet1_OnSearchEnd		= sheet1_OnSearchEnd;
	this.sheet1_OnSaveEnd		= sheet1_OnSaveEnd;
	this.sheet1_OnDownFinish	= sheet1_OnDownFinish;
	
}
/** Common global variable */
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var prefix1="sheet1_";
var clickVal="";
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
        switch(srcName) {
			case "btn_History":
				var tblNo = 'MDM_EQ_ORZ_CHT';
				var mstKey = sheetObject1.CellValue(sheetObject1.SelectRow, prefix1+"scc_cd");
				//var mstKey = nullToBlank(vslCd);
				if (mstKey == ""||mstKey == "SCC") {
					ComShowCodeMessage("CCD00063");
				return false;
				}
				comMdmCallPop(tblNo, mstKey); 
	    	break;
            case "btn_Retrieve":
                doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                break;
            case "btn_Down_Excel":
                if(sheetObject1.RowCount < 1){//no data
                    ComShowCodeMessage("COM132501");
                }else{
                	sheetObject1.SpeedDown2Excel(1);
                    //sheetObject1.Down2Excel({ HiddenColumn:1,DownCols:"sheet1_seq|sheet1_rcc_cd|sheet1_lcc_cd|sheet1_ecc_cd|sheet1_scc_cd|sheet1_delt_flg|sheet1_upd_dt|sheet1_upd_usr_id",Merge:true,TreeLevel:false});
                }
                break;
            case "btn_New":
                clearAllData(sheetObject1, formObject);
                break;
            case "btn_Save": 
                doActionIBSheet(sheetObject1, formObject, IBSAVE);
                break;
            case "btn_Row_Add":
            	doActionIBSheet(sheetObject1,formObject,IBINSERT);
                break;
            case "btn_Row_Copy":
            	var copyRow = sheetObject1.DataCopy();

            	  //타입 변경
            	sheetObject1.CellEditable(copyRow,2) = true;
/*                var copyRow=sheetObject1.DataCopy();
                sheetObject1.SetCellValue(copyRow, prefix1+"delt_chk",0,0);
                sheetObject1.SetCellValue(copyRow, prefix1+"seq","",0);
                sheetObject1.SetCellValue(copyRow, prefix1+"delt_flg","N",0);
                sheetObject1.SetCellValue(copyRow, prefix1+"upd_dt","",0);
                sheetObject1.SetCellValue(copyRow, prefix1+"upd_usr_id","",0);*/
                break;
            case "btn_Row_Delete":
                
                if(sheetObject1.FindCheckedRow(prefix1+"delt_chk") == "") {
                    ComShowCodeMessage("COM12114", "Del.");
                }
                //ComRowHideDelete(sheetObject1, prefix1+"delt_chk");
                else {
                    var chkIdxArr=chkIdxStr.split("|");
                    
                    //for(var i=chkIdxArr.length-2 ; i>=0 ; i--) {
                    for(var i=chkIdxArr.length-1 ; i>=0 ; i--) {
                        var chkIdx=chkIdxArr[i];
                        if(sheetObject1.GetRowStatus(chkIdx) == "I") {
                            sheetObject1.RowDelete(chkIdx, false);
                        }else {
                            //sheetObject1.RowStatus(chkIdx) = "U";
                            if(ComShowCodeConfirm("COM130301", "data")) {
                                //Delete Validation
                                var result=checkDelValidation(formObject, sheetObject1, chkIdx);
                                if(result == "") {
                                    sheetObject1.CellValue(chkIdx, prefix1+"delt_flg") = "Y";
                                }else {
                                    ComShowCodeMessage(result);
                                }
                                sheetObject1.CellValue(chkIdx, prefix1+"delt_chk") =0;
                            }else {
                                sheetObject1.CellValue(chkIdx, prefix1+"delt_chk") =0;
                                sheetObject1.SelectRow(chkIdx);
                            }
                        }
                    }
                }
                break;
            case "loc_btn":
                var display="0,1,1,1,1,1";
                var targetObjList="loc_dpth_cd:loc_type|loc_cd:location";
                var param="?depth=3&classId=COM_ENS_0O1&scc_flag=Y";
                ComOpenPopupWithTarget('/hanjin/COM_ENS_0O1.do' + param, 500, 450, targetObjList, display, true);
                break;
        } // end switch
    }catch(e) {
        if( e == "[object Error]") {
            ComShowMessage(OBJECT_ERROR);
        }else {
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    initControl();
    document.form.location.disabled=true;
    doActionIBCombo(sheetObjects[0], document.form, SEARCH01);
    var formObj=document.form;
    // auth_tp_cd retrieve
    //doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
/*    if(G_MDAA_CHK == 'Y') {
        //ComEnableObject(formObj.delt_flg, true);
        ComSetDisplay('btn_Row_Add', true);
        ComSetDisplay('btn_Row_Copy', true);
        ComSetDisplay('btn_Row_Delete', true);
        ComSetDisplay('btn_Save', true);
    } else {
        //ComEnableObject(formObj.delt_flg, false);
        ComSetDisplay('btn_Row_Add', false);
        ComSetDisplay('btn_Row_Copy', false);
        ComSetDisplay('btn_Row_Delete', false);
        ComSetDisplay('btn_Save', false);
    }*/
}

/**
 * Define an event control
 */
function initControl() {
	var formObj = document.form;
	axon_event.addListenerForm('keypress', 'obj_KeyPress', form);
	axon_event.addListener("change", "obj_change", "loc_type");
/*
	axon_event.addListenerForm("focus", "obj_focus", formObj);
	axon_event.addListenerForm("change", "obj_change", formObj);
	axon_event.addListener("keyup", "obj_keyup", "location");
	ComClearSeparator (document.form.scc_cd, "eng");
*/
}
/**
  * setting sheet initial values and header
  * param : sheetObj, sheetNo
  * adding case as numbers of counting sheets
  */
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetObj.id) {
        case "sheet1":      //sheet1 init
            with(sheetObj){
        	// 높이 설정
            style.height = 380;
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            
            //전체Edit 허용 여부 [선택, Default false]
            Editable = true;

        	InitRowInfo( 1, 1, 5, 100);
	        InitColumnInfo(13, 0, 0, true);
	        FocusEditMode = -1;

            // 해더에서 처리할 수 있는 각종 기능을 설정한다
            InitHeadMode(false, true, true, false, false, false);

            var HeadTitle="|Del.|Seq|RCC|LCC|ECC|SCC|Status|Create Date|Create by|Update Date|Update by|etc_flg";

          //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
            InitHeadRow(0, HeadTitle, true);
			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
			 InitDataProperty(0, cnt++ , dtHiddenStatus, 23,    daCenter,  false, prefix1 +"ibflag");
             InitDataProperty2(0, cnt++ , dtDelCheckEx,  "width=28; save-name = sheet1_delt_chk; all-check=false;update-edit=false;data-align=daCenter");
	         InitDataProperty(0, cnt++ , dtSeq,    		50,    daCenter,  true,   prefix1 +"seq", 					false,         "",          dfNone,     0,     true,       true);
	         InitDataProperty(0, cnt++ , dtComboEdit,      	100,   daCenter,   true,    prefix1 +"rcc_cd",          true,          "",      	dfEngUpKey, 0,     true,       true, 5);
	         InitDataProperty(0, cnt++ , dtPopupEdit,      	100,   daCenter,   true,  prefix1 +"lcc_cd",            true,          "",      	dfEngUpKey, 0,     true,       true, 5);
	         InitDataProperty(0, cnt++ , dtPopupEdit,      	100,   daCenter,   true,  prefix1 +"ecc_cd",            true,          "",      	dfEngUpKey, 0,     true,       true, 5);
	         InitDataProperty(0, cnt++ , dtPopupEdit,      	100,   daCenter,   true,  prefix1 +"scc_cd",            true,          "",      	dfEngUpKey, 0,     false,       true, 5);
	         InitDataProperty(0, cnt++ , dtCombo,      	60,   daCenter,   true,  prefix1 +"delt_flg",              false,          "",      	dfNone, 0,     true,       true);
	         InitDataProperty(0, cnt++ , dtData,      	120,   daCenter,   true,     prefix1 +"cre_dt",     		false,          "",      	dfDateYmd, 0,  false,       false);
	         InitDataProperty(0, cnt++ , dtData,      	90,   daCenter,   true,     prefix1 +"cre_usr_id", 		false,          "",      	dfNone, 0,     false,       false);
	         InitDataProperty(0, cnt++ , dtData,      	120,   daCenter,   true,     prefix1 +"upd_dt",     		false,          "",      	dfDateYmd, 0,  false,       false);
	         InitDataProperty(0, cnt++ , dtData,      	90,   daCenter,   true,     prefix1 +"upd_usr_id", 		false,          "",      	dfNone, 0,     false,       false);
	         InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,   true,     prefix1 +"etc_flg",        false,          "",      	dfNone, 0,     false,       false);
	         //InitDataCombo (0, prefix1 +"delt_flg", evtValue, evtCode,"");
	         
	         
	         PopupImage  =  "img/btns_search.gif";
             //팝업과 콤보의 버튼 이미지를 표시하는 종류를 확인하거나 설정한다.
             ShowButtonImage = 3; //Edit 가능할때 팝업 이미지 표시
             
             
          }

          break;
        }
}
function resizeSheet(){
	ComResizeSheet(sheetObjects[0]);
}
/**
 * All the combo box query
 */
function doActionIBCombo(sheetObj,formObj,sAction){
	sheetObj.ShowDebugMsg = false;
    switch (sAction) {
        case SEARCH01: // load page
        	var sComboObj = comboObjects[1];
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0022GS.do", "f_cmd=" + SEARCH01);
            //var rtnValue=sXml.split("|$$|");
            //var comboItems = ComGetEtcData(sXml, "rcc_cd");
            var comboXml=ComXml2ComboString(sXml, "cd_desc", "cd");
            if(comboXml!=null){
            	//RCC Combo Setting
            	sheetObj.InitDataCombo(0, prefix1+"rcc_cd", " |"+comboXml[0], " |"+comboXml[0],"", "", 0); 
            } 
            //Status Combo Setting
            var comboArr=["Active|Delete", "N|Y"];
            sheetObj.InitDataCombo(0, prefix1+"delt_flg", "|"+comboArr[0], "|"+comboArr[1],"", "", 0);
        break;
    }
}
//handling sheet process
function doActionIBSheet(sheetObj,formObj,sAction) {
    switch(sAction) {
        case SEARCH01: // MDM AUTH_TP_CD query
            var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
            var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
	
            // global var setting
            G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
            G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
            break;
        case IBSEARCH:      //Retrieve
            if(validateForm(sheetObj,formObj,sAction)){
                //ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var sParam=FormQueryString(formObj);
                var sXml=sheetObj.GetSearchXml("BCM_CCD_0022GS.do", sParam+ "&" + ComGetPrefixParam("sheet1_"));
    			var arrXml = sXml.split("|$$|"); 
    			if (arrXml.length > 0) {
    				sheetObjects[0].LoadSearchXml(arrXml[0]);
    			}
    			ComOpenWait(false);
    			
            }
            break;
        case IBSAVE:
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                //if(ComShowCodeConfirm("COM130101", "Data")){
                ComOpenWait(true);
                    sParam = sParam + "&" + ComGetSaveString(sheetObj, true, true);
                    var sXml=sheetObj.GetSaveXml("BCM_CCD_0022GS.do", sParam+ "&" + ComGetPrefixParam("sheet1_"));
                    sheetObj.LoadSaveXml(sXml);
                    //var sXml = sheetObj.DoSave("BCM_CCD_0022GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_"),'', true);  		
                    for(var i=1 ; i<=sheetObj.LastRow; i++) {
                        if(sheetObj.CellValue(i, prefix1+"etc_flg") == "F") {
                            sheetObj.CellFontColor(i, prefix1+"upd_dt") =sheetObj.RgbColor(255,0,0);
                            //sheetObj.CellFontColor(i, prefix1+"upd_dt") ="#FF0000";
                        }
                    }
                    var result=ComGetEtcData(sXml, "TRANS_RESULT_KEY");
                    ComOpenWait(false);
                    if(result != "F"){
                        var msgKey=ComGetEtcData(sXml, "msgKey");
                        if(msgKey == "P") {         //As SCC code is aleady exist, data was saved partially. Please check this again
                            ComShowCodeMessage("CCD00020");
                        }else if(msgKey == "F") {   //SCC code is aleady exist. Please check this again.
                            ComShowCodeMessage("CCD00021");
                        }else {                     //{?msg1} was saved successfully.
                            ComShowCodeMessage("COM130102", "Data");
                            doActionIBSheet(sheetObj, formObj, IBSEARCH);
                        }
                    }else{
                        ComShowCodeMessage("COM130103", "Data");
                    }
                }

            break;
        case IBINSERT:
        	var idx = sheetObj.DataInsert(-1);
            sheetObj.SelectCell(sheetObj.SelectRow, prefix1+"rcc_cd", true);
            sheetObj.CellValue(idx, prefix1+"delt_flg") = "N";
            //sheetObj.CellValue(idx, prefix1+"cre_usr_id") = document.form.user_id.value;
            //sheetObj.CellValue(idx, prefix1+"upd_usr_id") = document.form.user_id.value;
    }
}

/**
 * CHANGE EVENT
 */
function obj_change() {
	var formObject = document.form;
	/*****Case more than two additional sheets tab sheet is used to specify a variable *****/
//	var sheetObject1 = sheetObjects[0];
	/*******************************************************/

	try {
//		var srcName = ComGetEvent("name");
//		switch (srcName) {
//		case "loc_type" :
			if (formObject.loc_type.value == "") {
				document.form.location.value = "";
				document.form.location.disabled = true;
				document.form.location.setAttribute("className", "input2");
			} else {
				document.form.location.value = "";
				document.form.location.disabled = false;
				document.form.location.setAttribute("className", "input1");
			}
//			break;
//		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}

/*function sheet1_OnMouseDown(sheetObj, button, shift, x, y) {
    with(sheetObj) {
        if(MouseRow()> 0 && MouseCol()== SaveNameCol(prefix1+"rcc_cd")) {
            clickVal=GetCellValue(MouseRow(), MouseCol());
        }
    }
}*/
function sheet1_OnComboChange(sheetObj, row, col, code, text) {
    with(sheetObj) {
        var colNm=ColSaveName(col);
        if(colNm == prefix1+"rcc_cd" && text == " ") {
            CellValue(row, col) = 0;
        }
    }
}
/**
 * Sheet1 CHANGE EVENT
 * @param sheetObj
 * @param row
 * @param col
 * @param val
 */
function sheet1_OnChange(sheetObj, row, col, val) {
    with(sheetObj) {
        var formObj=document.form;
        var colNm=ColSaveName(col);
        switch (colNm) {
            // Code Validation
            case prefix1+"rcc_cd":
            case prefix1+"lcc_cd":
            case prefix1+"ecc_cd":
            case prefix1+"scc_cd":
                if(val != "") {
                    if(colNm == prefix1+"scc_cd") {
                        formObj.f_cmd.value=SEARCH03;       // Search SCC CD In Loc Code 
                    }else {
                        formObj.f_cmd.value=SEARCH02;       // Search RCC CD or LCC CD or ECC CD in Scc Code
                    }
                    var sParam=FormQueryString(formObj);
                    var sXml=GetSearchXml("BCM_CCD_0022GS.do", sParam + "&loc_cd=" + val);
                    var result=ComGetEtcData(sXml, "result");
                    if(result == "") {
                        if(colNm == prefix1+"scc_cd") {
                            ComShowCodeMessage("CCD00013", val);
                        }else {
                            ComShowCodeMessage("CCD00041");
                        }
                        sheetObj.CellValue(row, col) = "";
                        //SetCellValue(row, col,"",0);
                        SelectCell(row, col);
                    }
                    if(colNm == prefix1+"rcc_cd") {
                        clickVal=val;
                    }
                }
                break;
            // Only One Del Check
            case prefix1+"delt_chk":
                var chkIdxStr=FindCheckedRow(prefix1+"delt_chk");
                var ckhIdxArr=chkIdxStr.split("|"); 
                if(ckhIdxArr.length > 2) {
                    CellValue(row, col) =0;
                }
                break;
            case prefix1+"delt_flg":
               if(val == "Y") {
            	   
                    if(ComShowCodeConfirm("COM130301", "data")) {
                        var result=checkDelValidation(formObj, sheetObj, row);
                        if(result != "") {
                           ComShowCodeMessage(result);
                            sheetObj.CellValue(row, prefix1+"delt_flg") = "N";
                        }
                    }else{
                    	sheetObj.CellValue(row, prefix1+"delt_flg") = "N";
                    }
                    
                }
                break;
        }
    }
}
function sheet1_OnPopupClick(sheetObj, row, col) {
    with(sheetObj) {
        var formObj=document.form;
        var colNm=ColSaveName(col);
        switch (colNm) {
            case prefix1+"lcc_cd":
            case prefix1+"ecc_cd":
            case prefix1+"scc_cd":
                var dispaly="0,0";
                var classId="COM_ENS_051";
                var sheet="1";
                var param="";
                var rtnFnc="";
                if(colNm == prefix1+"scc_cd") {
                    param='?sheet='+sheet+'&classId='+classId+'&main_page=false';
                }else {
                    param='?sheet='+sheet+'&classId='+classId+'&main_page=false&scc_flg=Y';
                }
                ComOpenPopup('COM_ENS_051.do' + param, 800, 460, "locCodeHelp", dispaly, true, false, row, col); 
                break;
        }
    }
}
function locCodeHelp(rowArray, row, col) {
    var colArray=rowArray[0];
    var sheetObj=sheetObjects[0];
    sheetObj.CellValue(row, col) = colArray[1];
}
/**
 * All Data Clear
 * @param sheetObj
 * @param formObj
 */
function clearAllData(sheetObj, formObj){
    formObj.reset();
    sheetObj.RemoveAll();
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction) {
    switch(sAction) {
        case IBSEARCH:      //Retrieve
            if(formObj.loc_type.value != "" && ComTrimAll(formObj.location.value) == ""){
                ComShowCodeMessage("CCD00001", "Location Code if RCC, LCC, ECC or SCC is selected in Location");
                formObj.location.focus();
                return false;
            }
            break;
        case IBSAVE:        //Save
            if(!sheetObj.IsDataModified) {
                ComShowCodeMessage("CCD00019");
                return false;
            }
            if(sheetObj.IsDataModified == "") {
                return false;
            }
            break;
    }
    return true;
}
/**
 * Validation For Delete
 * @param formObj
 * @param sheetObj
 * @param chkIdx
 */
function checkDelValidation(formObj, sheetObj, chkIdx) {
    formObj.f_cmd.value=SEARCH04;
    var sParam=FormQueryString(formObj);
    //var chkStr = sheetObj.GetSaveString(false, true, prefix1+"delt_chk");
    //var sXml = sheetObj.GetSaveXml("BCM_CCD_0022GS.do", sParam + "&" + chkStr);
    var sXml=sheetObj.GetSearchXml("BCM_CCD_0022GS.do", sParam + "&scc_cd=" + sheetObj.CellValue(chkIdx, prefix1+"scc_cd"));
    var result=ComGetEtcData(sXml, "result");
    return result;
}

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
}
function sheet1_OnDownFinish(sheetObj, downloadType, result) {
    ComOpenWait(false);
}
