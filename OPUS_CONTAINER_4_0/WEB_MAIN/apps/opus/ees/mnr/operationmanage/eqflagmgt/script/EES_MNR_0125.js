/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0125.js
*@FileTitle : Damage History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/14
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class EES_MNR_0125 : EES_MNR_0125 - Defining a script used by screen
     */
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
							if(sheetObject.RowCount() < 1){//no data
								ComShowCodeMessage("COM132501");
							}else{
								sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
							}
								break;
						case "btns_calendar":
								var cal=new ComCalendarFromTo();
 								cal.select(form.from_date,  form.to_date,  'yyyy-MM-dd');
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
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
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
                    with(sheetObj){
						
					  
					  var HeadTitle1="|Seq.|Date|Office|Yard|Flag Type|Method|Created Date|Remark(s)";
					  var headCount=ComCountHeadTitle(HeadTitle1);

					  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					  InitHeaders(headers, info);

					  var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Left",    ColMerge:0,   SaveName:"NONE" },
							 {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"NONE" },
							 {Type:"Date",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"mnr_flg_inp_dt",     KeyField:0,   CalcLogic:"",   Format:"YmdHm",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_flg_yd_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:"mnr_sts_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Combo",     Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"mnr_flg_inp_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Date",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",        KeyField:0,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"mnr_flg_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
							if(workApp == "SPP"){
								SetColHidden("ofc_cd", 1);
							}
				 
							InitColumns(cols);

							SetEditable(1);
							SetCountPosition(0);
//							MultiSelection=false;
							SetSelectionMode(smSelectionRow);
//							SelectHighLight=true;
//							SelectFontBold=false;
//							SelectBackColor="#NANNANNAN";
//							SetSheetHeight(402);
							resizeSheet( sheetObj );
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
						formObj.f_cmd.value=SEARCH01;
						sheetObj.DoSearch("EES_MNR_0125GS.do",FormQueryString(formObj) );
					}
			break;
			case IBCLEAR:      //Initializing
				MnrWaitControl(true);
                sheetObj.SetWaitImageVisible(0);
				formObj.reset();
				formObj.from_date.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
				formObj.to_date.value=ComGetNowInfo("ymd");
				sheetObj.RemoveAll();
				//Retrieving combo data
				var sCondition=new Array (
				 	new Array("MnrGenCd","CD00005", "COMMON")
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
					sheetObj.InitDataCombo (0, "mnr_flg_inp_tp_cd", sheetComboText, sheetComboCode,sheetComboDefault);
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
        	// 2013-08-27 Recovery PQC test defects by J.H Han
        	if(formObj.from_date.value == "") {
				ComAlertFocus(formObj.from_date, ComGetMsg('MNR00003'));
				return;
			} else if(formObj.to_date.value == "") {
				ComAlertFocus(formObj.to_date, ComGetMsg('MNR00003'));
				return;
			}else if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) < 0){
				ComShowCodeMessage("MNR00366");
				ComClearSeparator(formObj.from_date);
				ComSetFocus(formObj.from_date);
				return;
			}
			if(sAction==IBSEARCH) {
				if (!ComChkValid(formObj)) return false;
			}
        }
        return true;
    }
	function initControl() {
	    //Axon event handling 1. Catching event
	 //   axon_event.addListenerForm  ('blur', 'obj_deactivate',  form);
	 //   axon_event.addListenerFormat('focus',   'obj_activate',    form);
	    axon_event.addListenerFormat('keypress', 'obj_keypress', 	form);
	    // 2013-08-27 Recovery PQC test defects by J.H Han
	    axon_event.addListenerFormat('change', 'obj_change', 	form);
	}
	//Axon event handling 2. Event handling function
	function obj_deactivate(){
		// 2013-08-27 Recovery PQC test defects by J.H Han
		// obj = event.srcElement;       
		// ComChkObjValid(event.srcElement); 
		var obj=event.srcElement;
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
				case "from_date":
					ComAddSeparator(obj, "ymd");
    				break;
				case "to_date":
					ComAddSeparator(obj, "ymd");
    				break;
			}
		}
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
	// 2013-08-27 Recovery PQC test defects by J.H Han
	function obj_change(){     
		var obj=event.srcElement; 
		var formObj=document.form; 
//		var sheetObj = sheetObjects[0]; 
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {       				   			 
	    		case "from_date":
	    			if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) < 0){
	    				ComShowCodeMessage("MNR00366");
	    				ComClearSeparator(formObj.from_date);
	    				ComSetFocus(formObj.from_date);
	    			}
	    			break;
	    		case "to_date":
	    			if(ComGetDaysBetween(formObj.from_date.value, formObj.to_date.value) < 0){
	    				ComShowCodeMessage("MNR00366");
	    				ComClearSeparator(formObj.to_date);
	    				ComSetFocus(formObj.to_date);
	    			}
	    			break;
			}		
	    } 
	}
	/* End of developer's task */
