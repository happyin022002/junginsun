/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0195.jsp
*@FileTitle  : Total Loss No Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_mnr_0195 : ees_mnr_0195 - Defining a script used by screen
     */
    /* Developer's task	*/
    /* ********* General Functions ************* */
    // Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	var opener = window.dialogArguments;
	// Event handler to diverge process by button name */
	function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
         var sheetObject1=sheetObjects[0];
	     var sheetObject2=sheetObjects[1];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
				//Opening calendar
				case "rqst_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.rqst_dt_fr, formObject.rqst_dt_to, 'yyyy-MM-dd');
					break;
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR,1);
					break;
				case "btn_OK":
					if(sheetObjects[0].FindCheckedRow("checkbox") == ""){
						ComShowCodeMessage("MNR00038","SELECT ");
					} else {
						comPopupOK();
					}
					break;
				case "btn_Close":
					ComClosePopup(); 
					break;
			} // end switch
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
    	// Setting button
    	MnrWaitControl(true);
    	if (!opener) opener = parent;
    	//IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i+1);
            ComEndConfigSheet(sheetObjects[i]);
        }
		//Axon Initializing event
		initControl();

	    if(opener != undefined)
	    {
	    	var formObject=document.form;
	     	if(opener.document.form.work_type!=undefined)
	     	{
	 	    	formObject.work_type.value=opener.document.form.work_type.value;
	     	}
	    }
	    doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
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
		                
				              var HeadTitle1="|Sel|Seq|Issue Date|Total Loss No|Issue Office|Responsible Office|Status";
				              var headCount=ComCountHeadTitle(HeadTitle1);
				             // (headCount, 0, 0, true);
				
				              SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				
				              var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				              var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				              InitHeaders(headers, info);
				
				              var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
				                     {Type:"Radio",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"checkbox" },
				                     {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
				                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"rqst_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"ttl_lss_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:1,   SaveName:"rqst_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  ColMerge:0,   SaveName:"respb_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				                     {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"ttl_lss_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				               
				              InitColumns(cols);
				
				              SetEditable(1);
				              //	SetCountPosition()(0);
				                    SetSelectionMode(smSelectionRow);
				                    SetSheetHeight(222);
              }


                break;
        }
    }
    /**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
	   // axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
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
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(event.srcElement);
	}
	/**
     * OnFocus event handling <br>
     **/
    function obj_focus(){
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
			case "ymd":
				ComKeyOnlyNumber(event.srcElement);
				break;
	    }
	}
    /**
     * Event handling of OnLoadFinish of t1sheet1
     *
     * @param {Sheet}sheetObj Used sheet object
     */
//     function sheet1_OnLoadFinish(sheetObj) {
//    	doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
//    }
	/**
	 * Event handling of OnDblClick of sheet1
	 * @param	{IBSheet}	sheetObj	sheet object
	 * @param	{Int}		Row			Row
	 * @param	{String}	Col			Column
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		sheetObj.SetCellValue(Row, "checkbox","1");
		comPopupOK();
	}
  	/**
     * Sheet related process processing
     * @param	{IBSheet}	sheetObj	Used sheet object
     * @param	{Form}		formObj		Used form object
     * @param	{Number}	sAction		Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		// Initializing all sheet
	    		for (i=0; i < sheetObjects.length; i++) {
	    			sheetObjects[i].RemoveAll();
	    		}
	    		// Only Loading
	    		if (sActionIdx == 0) {
		    		//Sheet Setting combo
					var sCondition=new Array (
						new Array("MnrGenCd","CD00039", "COMMON") 	//Status
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					for(var i=0; i<comboList.length ; i++){
						if(comboList[i] != null){
							//Status
							if(i == 0) {
								var sheetComboText="";
								var sheetComboCode="";
								var sheetComboDefault="";
								for(var j=0; j < comboList[i].length;j++){
									var tempText=comboList[i][j].split("|");
									sheetComboText +=  tempText[1] + "|";
									sheetComboCode +=  tempText[0] + "|";
									if(j ==0){
										sheetComboDefault=tempText[0];
									}
									//Setting combo value
									sheetObjects[0].InitDataCombo (0, "ttl_lss_sts_cd", sheetComboText, sheetComboCode ,sheetComboDefault);
								}
							}
						}
					}
	    		}
	    		//Value setting of initialize
	    		formObj.rqst_ofc_cd.value=rqstOfcCd;
	    		formObj.rqst_dt_fr.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
	    		formObj.rqst_dt_to.value=ComGetNowInfo("ymd");
	    		formObj.rqst_dt_fr.focus();
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		break;
	    	//Retrieving
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
 					var sXml=sheetObj.GetSearchData("EES_MNR_0195GS.do",FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:0} );
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
            with(formObj){
            }
            return true;
        }
        return true;
    }
