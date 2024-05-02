/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : EES_MNR_0138.js
*@FileTitle : Depreciated Value Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ess_mnr_0138 : ess_mnr_0138 - Defining a script used by screen
     */
/* Developer's task	*/
/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	var comboValue="U";
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	/**
	 * Event handler to diverge process by button name
	 */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
        var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				//Retrieving
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
                //Clearing screen
				case "btn_New":
					doActionIBSheet(sheetObject1,formObject,IBCLEAR);
					break;
                //Opening calendar
				case "total_loss_date_cal":
					var cal=new ComCalendar();
					cal.setDisplayType('date');
					cal.select(formObject.total_loss_date, 'yyyy-MM-dd');
	                break;
				//Multi inserting
				case "eq_no_multi":
				    rep_Multiful_inquiry("eq_no");
					break;
				//Printing
				case "btn_Print":
					doActionIBSheet(sheetObject1,formObject,"PRINT");
					break;
			}
    	}catch(e) {
    		if( e == "[object Error]") {
				ComFuncErrMsg(e);
    		} else {
				ComFuncErrMsg(e);
    		}
    	}
    }
    /**
     * Sheet default setting and initializing
     * To implement for onload event of body tag
     * After loading in your browser should display the ability to add pre-processing
     */
    function loadPage() {
    	//Setting button
    	MnrWaitControl(true);
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Initializing IBMultiCombo
 	    for(var k=0; k < comboObjects.length; k++){
 	        initCombo(comboObjects[k], k + 1);
 	    }
 	    //Initializing event handler
		initControl();
		//Clearing screen
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
  	/**
     * Initializing variable for IBSheet and defining header
     * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
     * @param	{IBSheet}	sheetObj	IBSheet object for initial setting
     * @param	{String}	sheetNo		Sequence number from sheet object tag id
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
            case "sheet1":
                    with(sheetObj){
					  var HeadTitle1=" |EQ No.|Currency|Depreciated Value|Manufactured Date|TP/SZ|Owner/Lessor";
					  var headCount=ComCountHeadTitle(HeadTitle1);

					  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					  InitHeaders(headers, info);

					  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"eq_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"dv_cur",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Float",     Hidden:0,  Width:220,  Align:"Right",   ColMerge:1,   SaveName:"dv_value",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Date",      Hidden:0,  Width:250,  Align:"Center",  ColMerge:1,   SaveName:"manu_dt",          KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:170,  Align:"Center",  ColMerge:1,   SaveName:"eq_tpsz_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:0,   SaveName:"lessor_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"eq_type" },
							 {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:0,   SaveName:"total_loss_date" } ];
					   
						InitColumns(cols);

						SetEditable(1);
						SetCountPosition(0);
						SetSelectionMode(smSelectionRow);
						SelectHighLight=true;
						SelectFontBold=false;
//						SetSheetHeight(442);
						resizeSheet( sheetObj );
					  }


			    break;
		}
    }
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form
	    switch(comboNo) {
	    	case 1:
	            with (comboObj) {
	    			SetColAlign(0, "left");
	    			SetDropHeight(160);
		        }
	            break;
	     }
	}
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
		//** Separator of date **/
    	//DATE_SEPARATOR="-";
	    //axon_event.addListenerForm  ('blur', 		'obj_deactivate',	form);
	    //axon_event.addListenerFormat('focus',  		'obj_activate',    	form);
	    //axon_event.addListenerForm	('keypress',	'obj_keypress', 	form);
    }
	/**
	 * Assigning array of IBSheet object
     * Array defined at the top of the source
	 * @param    {IBSheet}	sheet_obj        Registered as an array IBSheet Object
	 */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
 	}
	/**
     * Onblur event handling <br>
     **/
    function obj_deactivate(){
		ComChkObjValid(event.srcElement);
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_activate(){
		ComClearSeparator(event.srcElement);
    }
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
		obj=event.srcElement;
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
		switch(obj.dataformat) {
	        case "engup":
	          	ComKeyOnlyAlphabet('uppernum');
	            break;
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    }
	}
	/**
	 * Event handling of Onchange of combo
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function combo1_OnChange(comboObj,Index_Code, Text){
		comboValue=comboObj.GetSelectCode();
	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction) {
    	sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			//Initializing
			case IBCLEAR:
				//Setting for button and progress bar
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
	        	//Initializing combo data
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
				}
				//Retrieving combo data
				var sCondition=new Array (
					new Array("MnrGenCd","","CUSTOM9") //EQ Type
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				//Setting for combo data
				for(var i=0; i < comboList.length;i++){
					if(comboList[i] != null){
						for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							comboObjects[0].InsertItem(j, tempText[1] ,tempText[0]);
						}
					}
				}
				comboObjects[0].SetSelectCode("U");
				formObj.eq_no.value="";
				formObj.total_loss_date.value=ComGetNowInfo("ymd");
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
	            }
				//Focusing combo
				//comboObjects[0].focus();   
				//Setting for button and progress bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			//Retrieving
        	case IBSEARCH:
				sheetObj.SetWaitImageVisible(1);
				if(validateForm(sheetObj,formObj,sAction)) {
					var eqType=comboValue;
					var eqNo=formObj.eq_no.value; 
					var totalLossDate=formObj.total_loss_date.value;
					var arrXml=MnrComEqGenInfoSearch(sheetObj,eqType,eqNo,totalLossDate);
					sheetObjects[0].LoadSearchData(arrXml,{Sync:1} );
				}
                break;
            //Printing
        	case "PRINT":
        		if(validateForm(sheetObj,formObj,sAction)) {
					var eqType=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eq_type");
					var eqNo=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "eq_no");
					var totalLossDate=sheetObj.GetCellValue(sheetObj.GetSelectRow(), "total_loss_date");
        			var rdParam='/rv usr_id['+ usrId +'] eq_type['+ eqType +'] eq_no['+ eqNo +'] total_loss_date['+ totalLossDate +']';
        			formObj.com_mrdPath.value='apps/opus/ees/mnr/mnrcommon/generalcodesearchmgt/report/EES_MNR_0233.mrd';
        			formObj.com_mrdArguments.value=rdParam;
        			ComOpenRDPopup();
        		}
        		break;
        }
    }
  	/**
     * Validating process for input form data
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
			if(sAction==IBSEARCH){
				 if (!ComChkValid(formObj)) return false;
			} else if(sAction=="PRINT") {
				if(sheetObj.RowCount()< 1) {
					ComShowCodeMessage("MNR00310");
					return false;
				}
			}
        }
        return true;
    }
	/* ********* User Functions ************* */
	/**
	 * Processing the returned data of rep_Multiful_inquiry
	 * @param	{Array}		rowArray	Retruned array
	 * @param	{String}	return_val	Retruned form element name
	 */
	function getMnr_Multi(rowArray,return_val) {
 		var formObj=document.form;
 		var tempText="";
 		//Initializing
		eval("document.form." + return_val + ".value='';");
 		for(var i=0; i<rowArray.length; i++) {
 			tempText +=  rowArray[i] + ',';
 		}
 		//Removing last comma
 		tempText=MnrDelLastDelim(tempText);
 		eval("document.form." + return_val + ".value='" + tempText + "';");
 	}
