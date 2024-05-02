/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0016.jsp
*@FileTitle  : country
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/29
=========================================================*/
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
         switch(srcName) {
				case "btn_History":
					var tblNo = 'MDM_COUNTRY';
					var cntCd = formObject.cnt_cd.value;
					var mstKey = nullToBlank(cntCd);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "Country Code");
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
                	var contiCd = formObject.conti_cd.Code;
                	if(contiCd ==""){
						ComShowCodeMessage("CCD00038", "Continent Code first");
						return false;
                	}
                    openScontiCd();
                    break;
                case "btns_search2":
                    openCurrCd();
                    break;
                case "btns_search3":
                    openCntCd();
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
    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
        }
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],k+1);
    }
    initControl();
    doActionIBCombo(sheetObjects[0], formObj, SEARCH01);
    document.form.ibflag.value="I";
    
    // auth_tp_cd retrieve
//    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
//    if(G_MDAA_CHK == 'Y') {
//        ComEnableObject(formObj.delt_flg, true);
//        ComSetDisplay('btn_Save', true);
//    } else {
//        ComEnableObject(formObj.delt_flg, false);
//        ComSetDisplay('btn_Save', false);
//    }
 }
 /**
  * Define an event control
  */
 function initControl() {
    var formObj=document.form;
	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObj);
	axon_event.addListenerForm('change', 'obj_change', formObj);
    //axon_event.addListenerForm('focus', 'obj_focus', formObj);
    //axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    //axon_event.addListenerForm  ('change', 'obj_change', form);
    //ComClearSeparator (document.form.cnt_cd,"eng"); //English Only
    //ComClearSeparator (document.form.sconti_cd,"eng"); //English Only
    //ComClearSeparator (document.form.curr_cd,"eng"); //English Only
    //ComClearSeparator (document.form.cnt_iso_cd,"eng"); //English Only
 }
 /**
  * registering IBCombo Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
  function initCombo(comboObj, comboNo) {
    var formObject=document.form;
    switch(comboObj.id) {  
    }
  }
  
  
  /**
  * All the combo box query
  */
  function doActionIBCombo(sheetObj,formObj,sAction,sComboObj,sComboAction,sComboKey){
      switch (sAction) {
          case SEARCH01: // load page 
              var sXml=sheetObj.GetSearchXml("BCM_CCD_0016GS.do", "f_cmd=" + SEARCH01);
              var arrXml=sXml.split("|$$|");
  			if (arrXml.length > 0) 
  				ComXml2ComboItem(arrXml[0], formObj.conti_cd, "cd", "cd|cd_desc");
  			if (arrXml.length > 1) 
  				ComXml2ComboItem(arrXml[1], formObj.zn_div_bsel_cd, "cd", "cd|cd_desc");
              
          break;
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
        case "sheet1":      //sheet1 init
            with(sheetObj){ 
	            //Host정보 설정[필수][HostIp, Port, PagePath]
	            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		         InitRowInfo( 1, 1, 5, 100);
		         
		         InitColumnInfo(14, 0, 0, true);
		         
	             // 해더에서 처리할 수 있는 각종 기능을 설정한다
	             InitHeadMode(false, true, true, false, false, false);
	             
	             var HeadTitle="";
	             
	             InitHeadRow(0, HeadTitle, true);
	             //var prefix="sheet1_";
	             
	   			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
	 			InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "cnt_cd",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "cnt_nm",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "sconti_cd",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "curr_cd",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "cnt_iso_cd",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "eu_cnt_flg",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "eml_dsclm_ctnt",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "zn_div_bsel_cd",		false,          "",      	dfNone,      0,     true,       true);
	 			InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "delt_flg",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "cre_usr_id",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "cre_dt",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "upd_usr_id",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtHidden,      	100,   daCenter,    false,     "upd_dt",		false,          "",      	dfNone,      0,     true,       true);

        	
        	
          }
                 
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
                var sXml=sheetObj.GetSearchXml("BCM_CCD_0016GS.do", sParam);
                var arrXml = sXml.split("|$$|"); 
                ComOpenWait(false);
                //var cnt_nm=ComGetEtcData(sXml, "cnt_nm");
                sheetObjects[0].LoadSearchXml(arrXml[0]);
               
            }
        break;
        case IBSAVE:
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                if(ComShowCodeConfirm("COM130101", "Data")){
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSaveXml("BCM_CCD_0016GS.do", sParam + "&" + ComGetPrefixParam("sheet1_"));
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
        case SEARCH01: // MDM AUTH_TP_CD query
            var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
            var sXml=sheetObj.GetSearchData("BCM_CCD_2002GS.do", sParam);
            // global var setting
            G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
            G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");
        break;
        case SEARCH02:      //Sub Continent check
        if(validateForm(sheetObj,formObj,sAction)){
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH02;
            var sParam=FormQueryString(formObj);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0016GS.do", sParam);
            var result=ComGetEtcData(sXml, "result");
            if(result==""){
                ComShowCodeMessage("COM130402", "Sub Continent Code");
                formObj.sconti_cd.value="";
                formObj.sconti_cd.focus();
            }
            ComOpenWait(false);
        }
        break;
        case SEARCH03:      //curr code check
        if(validateForm(sheetObj,formObj,sAction)){
            ComOpenWait(true);
            formObj.f_cmd.value=SEARCH03;
            var sParam=FormQueryString(formObj);
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0016GS.do", sParam);
            var result=ComGetEtcData(sXml, "result");
            if(result==""){
                ComShowCodeMessage("COM130402", "Currency Code");
                formObj.curr_cd.value="";
                formObj.curr_cd.focus();
            }
            ComOpenWait(false);
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
            if(formObj.cnt_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Country Code");
                formObj.cnt_cd.focus();
                return false;
            }
            break;
        case IBSAVE:        //Save
            if(formObj.onchange_flag.value != "Y") {
                ComShowCodeMessage("COM130503");
                return;
             }
            if(formObj.cnt_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Country Code");
                formObj.cnt_cd.focus();
                return false;
            }else if(formObj.cnt_nm.value == ""){
                ComShowCodeMessage("CCD00001", "Country Name");
                formObj.cnt_nm.focus();
                return false;
            }else if(formObj.conti_cd.Code == ""){
                ComShowCodeMessage("CCD00001", "Continent Code");
                formObj.conti_cd.focus();
                return false;
            }else if(formObj.sconti_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Sub Continent Code");
                formObj.sconti_cd.focus();
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
            case "cnt_cd":
                if(formObject.cnt_cd.value.length>0){
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                }
            break;
            case "sconti_cd":
                if(formObject.sconti_cd.value.length>0){
                    doActionIBSheet(sheetObject1, formObject, SEARCH02);
                }
            break;
            case "curr_cd":
                if(formObject.curr_cd.value.length>0){
                    doActionIBSheet(sheetObject1, formObject, SEARCH03);
                }
            break;
            case "delt_flg":
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
    function clearAllData(sheetObj, formObj){
        formObj.cnt_cd.value="";
        formObj.cnt_nm.value="";
        formObj.sconti_cd.value="";
        formObj.curr_cd.value="";
        formObj.cnt_iso_cd.value="";
        formObj.delt_flg.value="N";
        formObj.ibflag.value="I";
        formObj.cnt_cd.readOnly=false;
        formObj.cre_usr_id.value="";
        formObj.cre_dt.value="";
        formObj.upd_usr_id.value="";
        formObj.upd_dt.value="";
        formObj.eml_dsclm_ctnt.value="";
        formObj.zn_div_bsel_cd.Code="";
        formObj.conti_cd.Code="";
        
        formObj.cnt_cd.className = "input1";
    	ComBtnEnable('btn_Create');
    }
     /**
      * Lane Code Help file open
      */
     function openScontiCd() {
        var formObj=document.form;
        //var sUrl="/hanjin/COM_ENS_0I1.do?sconti_cd=" + formObj.sconti_cd.value +"&main_page=false";
        var sUrl="/hanjin/COM_ENS_0I1.do?conti_cd=" + formObj.conti_cd.Code +"&main_page=false";
        var rVal=ComOpenPopup(sUrl, 700, 410, "scontiCodeHelp", "0,0", true);
     }
     function openCurrCd() {
        var formObj=document.form;
        var sUrl="/hanjin/COM_ENS_N13.do?curr_cd=" + formObj.curr_cd.value +"&main_page=false";
        var rVal=ComOpenPopup(sUrl, 700, 500, "currCodeHelp", "0,0", true);
     }
     function openCntCd() {
        var formObj=document.form;
        var sUrl="/hanjin/COM_ENS_0M1.do?cnt_cd=" + formObj.cnt_cd.value +"&main_page=false&mdm_yn=" + formObj.mdm_yn.value;
        var rVal=ComOpenPopup(sUrl, 850, 530, "cntCodeHelp", "0,0", true);
      }
     /**
     * sconti code Inquiry of selected values ??from the pop-up Setting.
     */
    function scontiCodeHelp(rowArray) {
        var formObj=document.form;
        var colArray=rowArray[0];               
        formObj.sconti_cd.value=colArray[1];
    }
     /**
     * curr code Inquiry of selected values ??from the pop-up Setting.
     */
    function currCodeHelp(rowArray) {
        var formObj=document.form;
        var colArray=rowArray[0];           
        formObj.curr_cd.value=colArray[1];
    }
    /**
     * cnt code Inquiry of selected values ??from the pop-up Setting.
     */
    function cntCodeHelp(rowArray) {
        var formObj=document.form;
        var colArray=rowArray[0];           
        formObj.cnt_cd.value=colArray[1];
        doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
    }
    function getValueForCombo(obj) {
      if (Object.prototype.toString.call(obj) == '[object Array]') {
          var str = obj[0];
          if(str ==null || str == "") return "";
          return str.split('|')[0];
      }
      return obj;
  }   

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
	 var formObj=document.form;
	 if(sheetObj.RowCount> 0){
 		 formObj.cnt_cd.readOnly=true;
 		 formObj.cnt_cd.className = "input2";
 		 formObj.onchange_flag.value = "N";
         formObj.cnt_nm.value=sheetObj.CellValue(1, "cnt_nm");   
         formObj.sconti_cd.value = sheetObj.CellValue(1, "sconti_cd");
         formObj.curr_cd.value = sheetObj.CellValue(1, "curr_cd");
         formObj.cnt_iso_cd.value = sheetObj.CellValue(1, "cnt_iso_cd");
         formObj.eu_cnt_flg.value = sheetObj.CellValue(1, "eu_cnt_flg");
         formObj.delt_flg.value = sheetObj.CellValue(1, "delt_flg");
         formObj.eml_dsclm_ctnt.value = sheetObj.CellValue(1, "eml_dsclm_ctnt");
         formObj.zn_div_bsel_cd.Code = sheetObj.CellValue(1, "zn_div_bsel_cd");
         formObj.conti_cd.Code = sheetObj.CellValue(1, "sconti_cd").substring(0, 1);
         
         formObj.cre_usr_id.value = sheetObj.CellValue(1, "cre_usr_id");
         formObj.cre_dt.value = sheetObj.CellValue(1, "cre_dt").substring(0, 19);
         formObj.upd_usr_id.value = sheetObj.CellValue(1, "upd_usr_id");
         formObj.upd_dt.value = sheetObj.CellValue(1, "upd_dt").substring(0, 19);
         formObj.ibflag.value="U";
         
         ComBtnEnable('btn_Create');

     }else{
         formObj.cnt_nm.value="";
         formObj.sconti_cd.value="";
         formObj.curr_cd.value="";
         formObj.cnt_iso_cd.value="";
         formObj.delt_flg.value="N";
         formObj.ibflag.value="I";
         
          if(!ComShowConfirm(ComGetMsg("CCD00034", "Country Code"))){
          	clearAllData(sheetObj, formObj);
          }else{
          	ComBtnDisable('btn_Create');
          }
     }
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    ComBtnEnable('btn_Create');
}
