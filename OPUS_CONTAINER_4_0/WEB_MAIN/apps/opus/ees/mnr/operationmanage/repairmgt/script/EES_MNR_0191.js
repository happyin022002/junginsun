/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0191.js
*@FileTitle  : Repair History_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0191 : EES_MNR_0191 - Defining a script used by screen
     */
    function EES_MNR_0191() {
    	this.processButtonClick=tprocessButtonClick;
    	this.setSheetObject=setSheetObject;
    	this.loadPage=loadPage;
    	this.initSheet=initSheet;
    	this.initControl=initControl;
    	this.doActionIBSheet=doActionIBSheet;
    	this.setTabObject=setTabObject;
    	this.validateForm=validateForm;
    }
	/* Developer's task	*/
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
         /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject=sheetObjects[0];
         /*******************************************************/
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
				switch(srcName) {
						case "btn_Retrieve":
								doActionIBSheet(sheetObject,formObject,IBSEARCH);
								break;
						case "btn_new":
								doActionIBSheet(sheetObject,formObject,IBCLEAR);
								break;
						case "btn_DownExcel":
 								sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(								sheetObject), SheetDesign:1,Merge:1 });
								break;
						case "btns_calendar":
								var cal=new ComCalendarFromTo();
 								cal.select(form.fm_mnr_inp_dt,  form.to_mnr_inp_dt,  'yyyy-MM-dd');
								break;
						case "btn_close":
								ComClosePopup(); 
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
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
		MnrWaitControl(true);
		initControl();
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		var formObj=document.form;
		doActionIBSheet(sheetObjects[0],formObj,IBCLEAR);
		if(formObj.eq_no.value != ""){
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		}
    }
    /**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
				var sheetID=sheetObj.id;
        switch(sheetID) {
            case "sheet1":
                with (sheetObj) {
                   // Setting height
	            	
	            	var HeadTitle1="|Seq|Input Date|C.OFC|Type|Service Provider|Est No|W/O No|Repair Yard|Repair Date|CURR|Amount|Status";
	            	var headCount=ComCountHeadTitle(HeadTitle1);
	            	(headCount, 0, 0, true);
	
	            	SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );
	
	            	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	            	InitHeaders(headers, info);
	
	            	var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"cost_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"rpr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"vndr_lgl_eng_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"est_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"wo_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"yd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"rpr_rslt_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Float",     Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"cost_amt",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	            	             {Type:"Combo",     Hidden:0, Width:90,   Align:"Left",    ColMerge:0,   SaveName:"rpr_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	            	 
	            	InitColumns(cols);
	            	SetEditable(1);
	            	SetSelectionMode(smSelectionRow);
	            	SetSheetHeight(300);
					SetCountPosition(0);
					if(workApp == "SPP"){
						SetColHidden("vndr_lgl_eng_nm",1);
					}
				}
	         		break;
        }
    }
  //Sheet processing-related processes
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			case IBSEARCH:      //Retrieving
					if(validateForm(sheetObj,formObj,sAction)){
						formObj.f_cmd.value=SEARCH;
 	     				sheetObj.DoSearch("EES_MNR_0191GS.do",FormQueryString(formObj) );
					}
			break;
			case IBCLEAR:      //Initializing
				MnrWaitControl(true);
                sheetObj.SetWaitImageVisible(0);
				sheetObj.RemoveAll();
				formObj.fm_mnr_inp_dt.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -2);
				formObj.to_mnr_inp_dt.value=ComGetNowInfo("ymd");
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","CD00008", "COMMON")
				)
				//Setting for combo data
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				for(var i=0; i < comboList.length;i++){
				 	if(comboList[i] != null){
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j ==0){
								sheetComboDefault=tempText[0];
							}
						}
					}
				}
				if (sheetComboText != "")
			        sheetComboText=sheetComboText.substr(0, sheetComboText.length - 1);
				if (sheetComboCode != "")
			        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length - 1);
				sheetObj.InitDataCombo (0, "rpr_sts_cd", sheetComboText, sheetComboCode,sheetComboDefault);
				sheetObj.SetWaitImageVisible(1);
                MnrWaitControl(false);
			break;
        }
    }
  	/**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
			}
        }
        return true;
    }
	function initControl() {
	    //Axon event handling 1. Catching event
	    axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
//	    axon_event.addListenerFormat('focus',   'obj_activate',    form);
//	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
	    ComChkObjValid(event.srcElement);
	}
	function obj_activate(){
	    ComClearSeparator(event.srcElement);
	}
	function obj_keypress(){
	    obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
	        case "int":
				ComKeyOnlyNumber(obj);
	            break;
	        case "float":
	            ComKeyOnlyNumber(obj, "-.");
	            break;
	        case "eng":
	            ComKeyOnlyAlphabet();
				break;
	        case "engup":
				ComKeyOnlyAlphabet('uppernum');
	            break;
	    }
	}
	/* End of developer's task */
