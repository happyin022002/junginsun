/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ees_mnr_0188.js
 *@FileTitle : MNR Tariff No Inquiry_Pop Up
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/21
=========================================================*/
/****************************************************************************************
  Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
    /**
     * @extends
     * @class ees_mnr_0188 : ees_mnr_0188 - Defining a script used by screen
     */
    function ees_mnr_0188() {
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
/* ********* General Functions ************* */
	// Common global variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
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
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				//Initializing
				case "btn_New":
					doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
					break;
				//Opening pop-up
				case "btn_Ok":
					if(sheetObj.FindCheckedRow("checkbox") == ""){
						ComShowCodeMessage("MNR00038","SELECT ");
					} else {
						comPopupOK();
					}
					break;
				//Closing
				case "btn_Close":
					ComClosePopup(); 
					break;
				//Opening calendar
				case "cre_dt_cal":
					var cal=new ComCalendarFromTo();
					cal.select(formObject.cre_dt_fr, formObject.cre_dt_to, 'yyyy-MM-dd');
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
		//Initializing
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
    }
  	/**
     * Initializing IBCombo
     * @param	{IBCombo}	comboObj	Object for initialized IBCombo
     * @param	{Number}	comboNo		Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
	    var cnt=0 ;
	    var formObject=document.form;
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
                with (sheetObj) {
                
		                var HeadTitle1="|Sel|Seq|Tariff No|Tariff Type|Service Provider\nCode|Service Provider\n Name|EQ Type|Status|Eff.From|Unit|Currency|Creation Date|Office|Creation User|Agreement No";
		                var headCount=ComCountHeadTitle(HeadTitle1);
		
		                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		
		                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		                InitHeaders(headers, info);
		
		                var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		                    {Type:"Radio",     Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"checkbox" },
		                    {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
		                    {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"mnr_trf_knd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vndr_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:140,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:60,   Align:"Left",    ColMerge:0,   SaveName:"eq_knd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:110,  Align:"Left",    ColMerge:0,   SaveName:"mnr_trf_sts_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eff_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Combo",     Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:"mnr_meas_ut_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"cre_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:0,   SaveName:"rqst_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"cre_usr_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		                    {Type:"Text",      Hidden:0,  Width:140,  Align:"Center",  ColMerge:1,   SaveName:"agmt_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		                 
		                InitColumns(cols); 
		
		                SetEditable(1);
		                SetCountPosition(0);
		                SetSelectionMode(smSelectionRow);
		
		                SetSheetHeight(332);
                }
	  			break;
        }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_deactivate',	document.form);
	//    axon_event.addListenerFormat('focus',  		'obj_activate',    	document.form);
	    axon_event.addListenerForm	('keypress',	'obj_keypress', 	document.form);
    }
	/**
	 * Assigning array of IBCombo object
	 * @param    {IBCombo}	combo_obj        Registered as an array IBCombo Object
	 */
    function setComboObject(combo_obj){
 		comboObjects[comboCnt++]=combo_obj;
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
    function obj_deactivate(){
        ComChkObjValid(ComGetEvent());
	}
	/**
     * Event handling activate
     **/
	function obj_activate(){
	    ComClearSeparator(ComGetEvent());
	}
	/**
	 * OnKeypress event handling <br>
	 **/
	function obj_keypress(){
	    obj=ComGetEvent();
	    if(obj.dataformat == null) return;
	    window.defaultStatus=obj.dataformat;
	    switch(obj.dataformat) {
	        case "ymd":
				ComKeyOnlyNumber(obj);
	            break;
	    }
	}
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
    function doActionIBSheet(sheetObj,formObj,sAction) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
			//Initializing
			case IBCLEAR:
				//Setting for button and progress bar
				sheetObj.SetWaitImageVisible(0);
				MnrWaitControl(true);
			    //Initializing value of condition part
				formObj.cre_dt_fr.value=ComGetDateAdd(ComGetNowInfo("ymd"), "Y", -1);
			    formObj.cre_dt_to.value=ComGetNowInfo("ymd");
				//Initializing combo data of condition part
				for(var i=0; i < comboObjects.length;i++){
					comboObjects[i].RemoveAll();
				}
				//Retrieving data of combo of sheet
				var sCondition=new Array (
					new Array("MnrGenCd","CD00002", "COMMON"),	//EQ Type
					new Array("MnrGenCd","CD00010", "COMMON"),	//UnitOfMass
					new Array("MnrGenCd","CD00007", "COMMON"),	//Tariff Status
					new Array("MnrGenCd","CD00011", "COMMON")	//Tariff Kind(STD,LCL)
				)
				var comboList=MnrComSearchCombo(sheetObj,sCondition);
				var sheetComboText="";
				var sheetComboCode="";
				var sheetComboDefault="";
				var comboSaveNames=new Array();
				comboSaveNames[0]="eq_knd_cd";
				comboSaveNames[1]="mnr_meas_ut_cd";
				comboSaveNames[2]="mnr_trf_sts_cd";
				comboSaveNames[3]="mnr_trf_knd_cd";
				for(var i=0; i < comboList.length;i++){
				 	if(comboList[i] != null){
				 		//combo of sheet
				 		for(var j=0; j < comboList[i].length;j++){
							var tempText=comboList[i][j].split("|");
							sheetComboText +=  tempText[1] + "|";
							sheetComboCode +=  tempText[0] + "|";
							if(j ==0){
								sheetComboDefault=tempText[0];
							}
						}
						sheetObj.InitDataCombo (0, comboSaveNames[i], sheetComboText, sheetComboCode,sheetComboDefault);
						//Combo of condition part
						if(i==3) {
    						for(var j=0; j < comboList[i].length;j++){
    							var tempText=comboList[i][j].split("|");
    							combo1.InsertItem(j, tempText[1] ,tempText[0]);
    						}
                        }
					}
				}
				comboObjects[0].InsertItem(0, 'All Retrieve' ,'All');
				if (sheetComboText != "") {
			        sheetComboText=sheetComboText.substr(0, sheetComboText.length -1);
				}
				if (sheetComboCode != "") {
			        sheetComboCode=sheetComboCode.substr(0, sheetComboCode.length -1);
				}
				//Initializing all sheet
			    for(i=0;i<sheetObjects.length;i++){
			    	sheetObjects[i].RemoveAll();
	            }
				//Setting initial value for combo
				comboObjects[0].SetSelectCode(formObj.mnr_trf_knd_cd.value);
                comboObjects[0].SetEnable(0);
				//Setting focus
				formObj.cre_dt_fr.focus();
				//Retrieving
				doActionIBSheet(sheetObj,formObj,IBSEARCH);
				//Setting for button and progress bar
				MnrWaitControl(false);
				sheetObj.SetWaitImageVisible(1);
				break;
			//Retrieving
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=SEARCH;
					formObj.mnr_trf_knd_cd.value=ComGetObjValue(comboObjects[0]);
					sheetObj.RemoveAll();
 					sheetObj.DoSearch("EES_MNR_0188GS.do",FormQueryString(formObj) );
				}
				break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
        with(formObj){
        }
        return true;
    }
	/* End of developer's task */
