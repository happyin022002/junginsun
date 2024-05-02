/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : BCM_CCD_0024.js
*@FileTitle  : daylight saving time
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
    function bcm_ccd_0024() {  
    	this.processButtonClick     = processButtonClick;
    	this.processButtonClick1    = processButtonClick1;
    	this.setSheetObject         = setSheetObject;
    	this.loadPage               = loadPage;
    	this.initControl            = initControl;
    	this.initSheet              = initSheet;
    	this.doActionIBSheet        = doActionIBSheet;
    	this.validateForm           = validateForm;
    	this.obj_change             = obj_change;
    	this.clearAllData           = clearAllData;
    	this.dstIdHelp              = dstIdHelp;
    	this.cntCodeHelp            = cntCodeHelp;
    	this.steCodeHelp            = steCodeHelp;
    	this.sheet1_OnSearchEnd     = sheet1_OnSearchEnd;
    	this.sheet1_OnSaveEnd       = sheet1_OnSaveEnd;
    }


var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var srcName0 = "";

/** Event handler processing by button click event */
document.onclick=processButtonClick;

function processButtonClick1(){ // onblur보다 new이벤트 먼저타게 처리 
	 srcName0=ComGetEvent("name");
 
}
/** Event handler processing by button name */
 function processButtonClick(){
     /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
    var sheetObject1=sheetObjects[0];
       /*******************************************************/
     var formObject=document.form;
    try {
        var srcName=ComGetEvent("name");
        if(ComGetEvent().style.cursor == "default") return;
      
          switch(srcName) {
				case "btn_History":
					var tblNo = 'MDM_DYLGT_SAV_TM';
					var dstId = formObject.dst_id.value;
					var mstKey = nullToBlank(dstId);
					if (mstKey == "") {
						ComShowCodeMessage("CCD00038", "DST Code");
					return false;
					}
					comMdmCallPop(tblNo, mstKey); 
                case "btn_Retrieve":
                    doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    break;
                case "btn_New":
                	doActionIBSheet(sheetObject1, formObject, IBCLEAR);
                    break;
                case "btn_Save":
                	doActionIBSheet(sheetObject1, formObject, IBSAVE);
                    break;
				case "btn_Create":
					doActionIBSheet(sheetObject1,	formObject, IBCREATE);
					break;      
                case "btns_search":
                    var sUrl="/hanjin/COM_COM_0005.do?dst_id=" + formObject.dst_id.value +"&main_page=false"+"&mdm_yn="+ formObject.mdm_yn.value + "&delt_flg=" + formObject.delt_flg.value;
                    var rVal=ComOpenPopup(sUrl, 620, 420, "dstIdHelp", "0,0", true);
                    break;                      
                case "btns_search1":
                    var formObj=document.form;
                    var sUrl="/hanjin/COM_ENS_0M1.do?cnt_cd=" + formObj.dst_cnt_cd.value +"&main_page=false";
                    var rVal=ComOpenPopup(sUrl, 620, 460, "cntCodeHelp", "0,0", true);
                    break;
                case "btns_search2":
                    var formObj=document.form;
                	if(formObj.dst_mnts.value.length == 0){
                		ComShowCodeMessage("CCD00038", "DST Diff first");
                		return;
                	}
                    var sUrl="/hanjin/COM_ENS_0X1.do?cnt_cd=" + formObj.dst_cnt_cd.value +"&main_page=false";
                    var rVal=ComOpenPopup(sUrl, 300, 400, "steCodeHelp", "0,0", true);
                    break;
                case "btns_Calendar1" :     // Start Date
                    var cal=new ComCalendar();
                    cal.setDisplayType('date');
                    cal.select(formObject.st_dst_dt, "yyyy-MM-dd");
                    break;
                case "btns_Calendar2" :     // End Date
                    var cal=new ComCalendar();
                    cal.setDisplayType('date');
                    cal.select(formObject.end_dst_dt, "yyyy-MM-dd");
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
    document.form.ibflag.value="I";
    var formObj=document.form;
    // auth_tp_cd retrieve

/*    doActionIBSheet(sheetObjects[0], formObj, SEARCH03);
    if(G_MDAA_CHK == 'Y') {
        ComEnableObject(formObj.delt_flg, true);
        ComSetDisplay('btn_Save', true);
    } else {
        ComEnableObject(formObj.delt_flg, false);
        ComSetDisplay('btn_Save', false);
    }*/
  }
  /**
   * Define an event control
   */
  function initControl() {
    axon_event.addListenerForm('keypress', 'obj_KeyPress', form);
    //axon_event.addListenerForm('change', 'formObj_OnChange', form);
    axon_event.addListenerForm('change', 'objChange', form);
    //axon_event.addListenerForm('focus', 'obj_focus', formObj);
    //axon_event.addListenerFormat ('keypress', 'obj_keypress', form);
    axon_event.addListenerForm  ('change', 'obj_change', form);
    //axon_event.addListenerForm  ('beforedeactivate', 'obj_deactivate',  form);     //focus out
    //ComClearSeparator (document.form.dst_id,"eng"); //Only English 
    //ComClearSeparator (document.form.dst_cnt_cd,"eng"); //Only English
    //ComClearSeparator (document.form.dst_not_aply_ste_cd,"eng"); //Only English
    //ComClearSeparator (document.form.dst_yr,"eng"); //Only English
    //ComClearSeparator (document.form.dst_yr,"eng"); //Only English
    //ComClearSeparator (document.form.dst_mnts,"eng"); //Only English
    //ComClearSeparator (document.form.end_dst_rule_desc,"eng"); //Only English
    //ComClearSeparator (document.form.st_dst_dt,"eng"); //Only English
    //ComClearSeparator (document.form.end_dst_dt,"eng"); //Only English
    //ComClearSeparator (document.form.st_dst_hrmnt,"eng"); //Only English
    //ComClearSeparator (document.form.end_dst_hrmnt,"eng"); //Only English
    //ComClearSeparator (document.form.delt_flg,"eng"); //Only English
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
            //Host정보 설정[필수][HostIp, Port, PagePath]
            if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
	         InitRowInfo( 1, 1, 5, 100);
	         
	         InitColumnInfo(13, 0, 0, true);
	
             // 해더에서 처리할 수 있는 각종 기능을 설정한다
             InitHeadMode(false, true, true, false, false, false);

             var HeadTitle = "";
             //var HeadTitle1 = " |";
             //해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
             InitHeadRow(0, HeadTitle, true);

 			//데이터속성    [ROW, COL,  DATATYPE,   WIDTH, DATAALIGN, COLMERGE, SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
 				InitDataProperty(0, cnt++ , dtHiddenStatus, 30,    daCenter,  true,    "ibflag");
				InitDataProperty(0, cnt++ , dtData,      	134,   daLeft,    false,     "dst_cnt_cd",		false,          "",      	dfNone,      0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "dst_not_aply_ste_cd",    		false,          "",      	dfNone,   0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "ste_nm",    		false,          "",      	dfNone,   0,     false,      true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "dst_yr",     		false,          "",      	dfNone,   0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	100,   daCenter,  false,     "dst_mnts",     	false,          "",      	dfNone,  0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "st_dst_rule_desc",	false,          "",      	dfNone, 2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "end_dst_rule_desc",	false,          "",      	dfNone, 2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "st_dst_dt",	false,          "",      	dfDateYmd, 0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "end_dst_dt",	false,          "",      	dfDateYmd, 0,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "st_dst_hrmnt",	false,          "",      	dfTimeHm, 2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "end_dst_hrmnt",	false,          "",      	dfTimeHm, 2,     true,       true);
				InitDataProperty(0, cnt++ , dtData,      	240,   daRight,   false,     "delt_flg",	false,          "",      	dfNone, 2,     true,       true);		
	         
	        }
           break;
       }
   }
  //Sheet processing-related processes 
   function doActionIBSheet(sheetObj,formObj,sAction) {
	   document.body.focus();
       var prefix="sheet1_"; 
       switch(sAction) {
        case IBCREATE: // New retrieve
        	clearAllData(sheetObj, formObj);
        	ComBtnDisable('btn_Create');
        	formObj.dst_id.className = "input2";
        	formObj.dst_id.readOnly = true;
    	    document.form.dst_cnt_cd.className = "input1";
    	    document.form.dst_cnt_cd.readOnly = false;
    	    ComEnableObject(document.form.btns_search1, true);
    		ComEnableObject(document.form.btns_search2, true);
    		document.form.dst_not_aply_ste_nm.className = "input1";
       	break;
       	
        case IBSEARCH:      //retrieve
            if(validateForm(sheetObj,formObj,sAction)){
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH;
                var dst_id_org = formObj.dst_id.value;
                var sParam = FormQueryString(formObj);
                var sXml = sheetObj.GetSearchXml("BCM_CCD_0024GS.do", sParam);
				var arrXml = sXml.split("|$$|"); 
				var dstCd=ComGetEtcData(sXml, "DST_CD");
				ComOpenWait(false);
				if (dstCd != undefined) {
					sheetObjects[0].LoadSearchXml(arrXml[0]);
                    formObj.dst_cnt_cd.value = sheetObj.CellValue(1, "dst_cnt_cd");
                    formObj.dst_not_aply_ste_cd.value = sheetObj.CellValue(1, "dst_not_aply_ste_cd");
                    formObj.dst_not_aply_ste_nm.value = sheetObj.CellValue(1, "ste_nm");
                    formObj.dst_yr.value = sheetObj.CellValue(1, "dst_yr");
                    formObj.dst_mnts.value = sheetObj.CellValue(1, "dst_mnts");
                    formObj.st_dst_rule_desc.value = sheetObj.CellValue(1, "st_dst_rule_desc");
                    formObj.end_dst_rule_desc.value = sheetObj.CellValue(1, "end_dst_rule_desc");
                    formObj.st_dst_dt.value = sheetObj.CellText(1, "st_dst_dt");
                    formObj.end_dst_dt.value = sheetObj.CellText(1, "end_dst_dt");
                    formObj.st_dst_hrmnt.value = sheetObj.CellText(1, "st_dst_hrmnt");
                    formObj.end_dst_hrmnt.value = sheetObj.CellText(1, "end_dst_hrmnt");
                    formObj.delt_flg.value = sheetObj.CellValue(1, "delt_flg");
                    formObj.ibflag.value = "U";
                    formObj.dst_id.readOnly = true;
				}else{
	                //formObj.creflag.value="Y";
	                formObj.ibflag.value="I";
	                if(!ComShowConfirm(ComGetMsg("CCD00034", "DST Code"))){
	                    doActionIBSheet(sheetObj, formObj, IBCLEAR);
	                }else{
	                	doActionIBSheet(sheetObj,	formObj, IBCREATE);

	                }
					
				}
                //document.getElementById("dst_cnt_cd").blur();
            }
        break;
        case IBSAVE:
            if(validateForm(sheetObj,formObj,sAction)){
                formObj.f_cmd.value=MULTI;
                var sParam=FormQueryString(formObj);
                var sData = "DST Code("+formObj.dst_id.value+")";
                if(ComShowCodeConfirm("COM130101", sData)){
                    ComOpenWait(true);
                    var sXml=sheetObj.GetSaveXml("BCM_CCD_0024GS.do", sParam + "&" + ComGetPrefixParam("sheet1_"));
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
        case SEARCH03: // MDM AUTH_TP_CD query
/*            var sParam='f_cmd=' + SEARCH02 + '&mst_dat_subj_cd=MDAA';
            var sXml=sheetObj.GetSearchXml("BCM_CCD_2002GS.do", sParam);
            // global var setting
            G_MDAA_CHK=ComGetEtcData(sXml, "MDAA_CHK");
            G_AHTU_TP_CD=ComGetEtcData(sXml, "AUTH_TP_CD");*/
/*        	
        	var formObj = document.form;
        	var fnDstId =dstYr.substring(2) + dstCntCd ;
        	formObj.dst_id.value = fnDstId;
            formObj.f_cmd.value=SEARCH03;*/
        	var dstCntCd = formObj.dst_cnt_cd.value;
        	var dstYr = formObj.dst_yr.value;
        	
        	var fnDstId =dstYr.substring(2) + dstCntCd ;
        	var dstNotAplySteCd =formObj.dst_not_aply_ste_cd.value;
        	var dstMnts =formObj.dst_mnts.value;
        	if(dstMnts == 0){
        		var sParam='f_cmd='+SEARCH03+'&dst_id='+fnDstId;
        		var sXml=sheetObj.GetSearchXml("BCM_CCD_0024GS.do", sParam);
        		var dstCode = ComGetEtcData(sXml, "dstCode");
        		if(dstCode != "exist"){
        			ComShowCodeMessage("CCD00070");
        			return false
        		}
        		
        	}
            
            var sParam='f_cmd='+SEARCH03+'&dst_id='+fnDstId+'&dst_not_aply_ste_cd='+dstNotAplySteCd;
            var sXml=sheetObj.GetSearchXml("BCM_CCD_0024GS.do", sParam);
            var dstCode = ComGetEtcData(sXml, "dstCode");
            if(dstCode == "exist"||dstCode == undefined){
            	ComShowCodeMessage("CCD00004", "DST");
            	return false;
            }else{
            	formObj.dst_id.value = dstCode;
            	return true;
            }
        break;
        case SEARCH01:      //Country check
            if(validateForm(sheetObj,formObj,sAction)){
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH01;
                var sParam=FormQueryString(formObj);
                var sXml=sheetObj.GetSearchXml("BCM_CCD_0024GS.do", sParam);
                var result=ComGetEtcData(sXml, "result");
                if(result==""){
                    ComShowCodeMessage("COM130402", "Country");
                    formObj.dst_cnt_cd.value="";
                    //formObj.dst_cnt_cd.focus();
                }
                ComOpenWait(false);
                
            }
        break;
        case SEARCH02:      //State check
            if(validateForm(sheetObj,formObj,sAction)){
                ComOpenWait(true);
                formObj.f_cmd.value=SEARCH02;
                var sParam=FormQueryString(formObj);
                var sXml=sheetObj.GetSearchXml("BCM_CCD_0024GS.do", sParam);
                var result=ComGetEtcData(sXml, "result");
                if(result==""){
                    ComShowCodeMessage("COM130402", "State");
                    formObj.dst_not_aply_ste_cd.value="";
                    //formObj.dst_not_aply_ste_cd.focus();
                }
                ComOpenWait(false);
                
            }
            break;
        case IBCLEAR:    
            clearAllData(sheetObj, formObj);
            ComBtnEnable('btn_Create');
        	formObj.dst_id.className = "input1";
        	formObj.dst_id.readOnly = false;
    	    document.form.dst_cnt_cd.className = "input1";
    	    document.form.dst_cnt_cd.readOnly = false;
    	    ComEnableObject(document.form.btns_search1, true);
    		ComEnableObject(document.form.btns_search2, true);
    		document.form.dst_not_aply_ste_nm.className = "input1";
            break;
       }
   }
   /**
    * On-screen form validation process for the value of the input processing   */
   function validateForm(sheetObj,formObj,sAction){
    switch(sAction) {
	    
        case IBSEARCH:      //retrieve
            if(formObj.dst_id.value == ""){
                ComShowCodeMessage("CCD00001", "DST Code");
                formObj.dst_id.focus();
                return false;
            }
            break;
        case IBSAVE:        //save
            if(formObj.onchange_flag.value != "Y") {
                ComShowCodeMessage("COM130503");
                return;
             }

            if(formObj.dst_cnt_cd.value == ""){
                ComShowCodeMessage("CCD00001", "Country");
                formObj.dst_cnt_cd.focus();
                return false;
            }
            
            if(formObj.dst_yr.value == ""){
                ComShowCodeMessage("CCD00001", "DST Year");
                formObj.dst_yr.focus();
                return false;
            }
            
            if(formObj.dst_mnts.value == ""){
                ComShowCodeMessage("CCD00001", "DST Diff");
                formObj.dst_mnts.focus();
                return false;
            }else{
                if(formObj.dst_mnts.value == "0"&&formObj.dst_not_aply_ste_nm.value == ""){
                    ComShowCodeMessage("CCD00001", "Not Applying State");
                    formObj.dst_not_aply_ste_nm.focus();
                    return false;
                }
            }
            
            if(formObj.st_dst_dt.value == ""){
                ComShowCodeMessage("CCD00001", "Start Date");
                formObj.st_dst_dt.focus();
                return false;
            }
            
            if(formObj.end_dst_dt.value == ""){
                ComShowCodeMessage("CCD00001", "END Date");
                formObj.end_dst_dt.focus();
                return false;
            }
            
            if(formObj.st_dst_hrmnt.value == ""){
                ComShowCodeMessage("CCD00001", "Start Time");
                formObj.st_dst_hrmnt.focus();
                return false;
            }
            if(formObj.end_dst_hrmnt.value == ""){
                ComShowCodeMessage("CCD00001", "End Time");
                formObj.end_dst_hrmnt.focus();
                return false;
            }
            if(formObj.st_dst_dt.value != "" && formObj.end_dst_dt.value != ""){
                if(formObj.st_dst_dt.value>formObj.end_dst_dt.value){
                    ComShowCodeMessage("COM132002");
                    formObj.end_dst_dt.focus();
                    return false;
                }
            }
            if(formObj.st_dst_dt.value != "" && (formObj.st_dst_dt.value == formObj.end_dst_dt.value)){
                if(formObj.st_dst_hrmnt.value>formObj.end_dst_hrmnt.value){
                    ComShowCodeMessage("CCD00005", "The End time", "the start time");
                    formObj.end_dst_hrmnt.focus();
                    return false;
                }
            }
            //DST Code 생성
            if(formObj.ibflag.value=="I"){
                if(!doActionIBSheet(sheetObj, formObj, SEARCH03)){
                	return false;
                }
                	
            }

            if(formObj.dst_id.value == ""){
                ComShowCodeMessage("CCD00001", "DST Code");
                formObj.dst_id.focus();
                return false;
            }
            break;
    }
       return true;
   }
    /**
     * If the data field to be the CHANGE Event
     */
    function obj_change(){
    	//document.body.focus();
        var formObject=document.form;
        /*****Case more than two additional sheets tab sheet is used to specify a variable *****/
        var sheetObject1=sheetObjects[0];
        processButtonClick(); 
        /*******************************************************/
        try {
        	if(srcName0 == "btn_New"){
        		return true;
        	}
            var srcName=ComGetEvent("name");
            
            switch(srcName) {
                case "dst_id":
                    if(formObject.dst_id.value.length>0){
                        doActionIBSheet(sheetObject1, formObject, IBSEARCH);
                    }
                break;
                case "dst_cnt_cd":
                    if(formObject.dst_cnt_cd.value.length>0){

                        doActionIBSheet(sheetObject1, formObject, SEARCH01);
                    }
                break;
                case "dst_mnts":
                	if(formObject.dst_mnts.value == 0){
                		ComEnableObject(document.form.btns_search2, true);
                		document.form.dst_not_aply_ste_nm.className = "input1";
                	}else{
                		ComEnableObject(document.form.btns_search2, false);
                		document.form.dst_not_aply_ste_nm.className = "input2";
                		document.form.dst_not_aply_ste_nm.value = "";
                		document.form.dst_not_aply_ste_cd.value = "";
                	}
                break;
                case "dst_not_aply_ste_cd":
                	if(formObject.dst_mnts.value.length == 0){
                		ComShowCodeMessage("CCD00038", "DST Diff first");
                		formObject.dst_not_aply_ste_cd.value ="";
                		return;
                	}
                	
                    if(formObject.dst_not_aply_ste_cd.value.length>0){
                    	 
                        doActionIBSheet(sheetObject1, formObject, SEARCH02);
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
     function clearAllData(sheetObj, formObj){
        formObj.reset();
        formObj.ibflag.value="I";
        formObj.dst_id.readOnly=false;
        formObj.dst_id.className = "input1";
        srcName0 = "";
     }
     function dstIdHelp(rowArray) {
        var formObj=document.form;
        var sheetObj=sheetObjects[0];
        var colArray=rowArray[0];   
        formObj.dst_id.value=colArray[3];
        doActionIBSheet(sheetObj, formObj, IBSEARCH);
     }
     function cntCodeHelp(rowArray) {
        var formObj=document.form;
        var colArray=rowArray[0];   
        formObj.dst_cnt_cd.value=colArray[1];
        document.form.onchange_flag.value = "Y";
     }
     function steCodeHelp(rowArray) {
        var formObj=document.form;
        var colArray=rowArray[0];   
        formObj.dst_not_aply_ste_cd.value=colArray[3];
        formObj.dst_not_aply_ste_nm.value=colArray[4];
        document.form.onchange_flag.value = "Y";
     }

function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
    ComOpenWait(false);
    var formObj=document.form;
	if (sheetObj.RowCount> 0){
		formObj.dst_id.className = "input2";
		formObj.onchange_flag.value = "N";
	    ComBtnEnable('btn_Create');
	    formObj.dst_cnt_cd.className = "input2";
	    formObj.dst_cnt_cd.readOnly = true;
	    ComEnableObject(formObj.btns_search1, false);
	    
    	if(formObj.dst_mnts.value == 0){
    		ComEnableObject(formObj.btns_search2, true);
    		formObj.dst_not_aply_ste_nm.className = "input1";
    	}else{
    		ComEnableObject(formObj.btns_search2, false);
    		formObj.dst_not_aply_ste_nm.className = "input2";
    	}
	}
}

function sheet1_OnSaveEnd(sheetObj, Code, Msg, StCode, StMsg) {
	document.getElementById("dstTable").style.display = 'block';
	document.getElementById("dstTable2").style.display = 'block';
	document.form.onchange_flag.value = "N";
    ComOpenWait(false);
    ComBtnEnable('btn_Create');
}


/**
 * 개체에서 키보드를 눌렀을때 발생하는 이벤트를 처리<br>
 * <br><b>Example : </b>
 * <pre>
 * </pre>
 * @param {void}
 * @return void
 * @author Park Mangeon
 * @version 2009.10.01
 */
function objKeyPress() {
    var objName = event.srcElement.name;
    var formObj = document.form;
    switch(objName) {
    case "st_dst_dt":
        obj_KeyPress(event.srcElement);
        break;
    case "end_dst_dt":
        obj_KeyPress(event.srcElement);
        break;

    }
}
    
    /**
     * 화면에있는 개체를 Change할 때 발생하는 이벤트 처리<br>
     * <br><b>Example : </b>
     * <pre>
     * </pre>
     * @param {void}
     * @return {void}
    * @author Park Mangeon
     * @version 2009.10.01
     */
    function objChange() {
    	document.form.onchange_flag.value = "Y";
        var objName = event.srcElement.name;
        var formObj = document.form;
        switch(objName) {
	        case "st_dst_dt":
	            obj_KeyPress(event.srcElement);
	            break;
	        case "end_dst_dt":
	            obj_KeyPress(event.srcElement);
	            break;
        }
    }
    
