/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EES_MNR_0236.js
*@FileTitle : MNR PFMC by Agreement/Tariff 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class EES_MNR_0236 : EES_MNR_0236 - Defining a script used by screen
 */

/* ********* General Functions ************* */
	// Common global variable
	
var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Defining event handler of button click */
	document.onclick=processButtonClick;
	// Event handler to diverge process by button name */
    function processButtonClick(){
        /***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject1=sheetObjects[0];
        /*******************************************************/
        var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
    		if(ComGetBtnDisable(srcName)) return false;
            switch(srcName) {
            	//New
				case "btn_New":
	                doActionIBSheet(sheetObject1,document.form,IBCLEAR,1);
	                break;
				//Retrieving
				case "btn_Retrieve":
					doActionIBSheet(sheetObject1,document.form,IBSEARCH);
					break;
				//S/Provider Code PopUp
				case "provider_popup":
					ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 705, 550, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
					break;
				//Downloading excel
				case "btn_DownExcel":
					if(sheetObjects[0].RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject1), SheetDesign:1,Merge:1, AutoSizeColumn:1 });
					}
					break;
            } // end switch
    	}catch(e) {
    		if (e == "[object Error]") {
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
    	//Initializing IBMultiCombo
    	for ( var k=0; k < comboObjects.length; k++) {
    		initCombo(comboObjects[k], k + 1);
    	}
    	//IBInitializing sheet
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i] );
            initSheet(sheetObjects[i],i + 1);
            ComEndConfigSheet(sheetObjects[i]);
        }
        //Axon Initializing event
		initControl();
		//Initializing screen
		doActionIBSheet(sheetObjects[0], document.form, IBCLEAR, 0);
		//focus
		document.form.cost_grp_cd.focus();
    }
    /**
     * Initializing IBCombo
     * @param {IBCombo} comboObj Object for initialized IBCombo
     * @param {Number} comboNo Sequence number from combo object tag id
     */
    function initCombo(comboObj, comboNo) {
    	var cnt=0;
    	var formObject=document.form
    	switch (comboNo) {
    	case 1:
    		with (comboObj) {
    		SetColAlign(0, "left");
    		SetColWidth(0, "120");
				SetUseAutoComplete(1);
    		}
    		break;
    	case 2:
           	with (comboObj) {
				SetTitle("Office Code|Office Name");
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "70");
				SetColWidth(1, "225");
			   	SetDropHeight(160);
				SetUseAutoComplete(1);
				ValidChar(2);
				SetTitleVisible(1);
	    	}
    		break;
    	case 3:
    		with (comboObj) {
    			SetTitle("Office Code|Office Name");
				SetColAlign(0, "left");
				SetColAlign(1, "left");
				SetColWidth(0, "70");
				SetColWidth(1, "225");
    			SetDropHeight(160);
				SetUseAutoComplete(1);
				SetTitleVisible(1);
    		}
    		break;
    	case 4:
    	case 5:
    	case 6:
    		with (comboObj) {
				SetTitle("Code|Desc");
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "45");
				SetColWidth(1, "260");
    			SetDropHeight(160);
				SetUseAutoComplete(1);
				ValidChar(2);
				SetTitleVisible(1);
    		}
    		break;
		case 7:
    		with (comboObj) {
				SetColAlign(0, "left");
				SetColWidth(0, "110");
				SetUseAutoComplete(1);
				ValidChar(2);
    		}
    		break;
		case 8:
    		with (comboObj) {
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "35");
				SetColWidth(1, "265");
    			SetDropHeight(160);
				SetUseAutoComplete(1);
				ValidChar(2);
    		}
    		break;
    	}
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
        switch(sheetNo) {
            case 1:      //sheet1 init
                with(sheetObj){
             
           
	             var HeadTitle="|Seq.|Tariff Type|Component\nCode|Repair\nCode|Division\nCode|RHQ|Office|S/P Code|S/P Name|Man-hour|Tariff\nCurr|Material|AGMT\nCurr|Labor\nRate|Tariff No|Tariff\nStatus|Agreement No";
	             var headCount=ComCountHeadTitle(HeadTitle);
	
	             SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
	             var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	             var headers = [ { Text:HeadTitle, Align:"Center"} ];
	             InitHeaders(headers, info);
	
	             var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Seq",       Hidden:0, Width:40,   Align:"Rigth",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:0,   SaveName:"cost_grp_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"eq_cmpo_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"eq_rpr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"trf_div_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"ar_hd_qtr_ofc_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:"rqst_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"vndr_seq",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:"vndr_nm",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:65,   Align:"Right",   ColMerge:0,   SaveName:"rpr_lbr_hrs",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:0,   SaveName:"mtrl_cost_amt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_curr_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:0,   SaveName:"agmt_rt_amt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:0,   SaveName:"trf_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:85,   Align:"Left",    ColMerge:0,   SaveName:"mnr_trf_sts_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	              
	             InitColumns(cols);
	             SetEditable(1);
	             SetSelectionMode(smSelectionRow);  
//	             SetSheetHeight(410);
	             resizeSheet( sheetObj );
             	}
                break;
        }
    }
	/**
	 * Defining event. <br>
	 **/
	function initControl() {
	    axon_event.addListenerForm  ('blur', 		'obj_blur',		document.form);
//	    axon_event.addListenerFormat('focus',  		'obj_focus',    document.form);
//	    axon_event.addListenerForm	('keypress',	'obj_keypress', document.form);
	    axon_event.addListenerFormat('change',	 	'obj_change',	document.form);
    }
    /**
     * Assigning array of IBCombo object
     * @param {IBCombo} combo_obj IBCombo Object
     */
    function setComboObject(combo_obj) {
    	comboObjects[comboCnt++]=combo_obj;
    }
    /**
     * Assigning array of IBSheet object
     * Array defined at the top of the source
     */
    function setSheetObject(sheet_obj){
       sheetObjects[sheetCnt++]=sheet_obj;
    }
	/**
     * Onblur event handling <br>
     **/
    function obj_blur(){
		ComChkObjValid(ComGetEvent());
	}
	/**
     * OnFocus event handling <br>
     **/
    /*function obj_focus(){
		ComClearSeparator(ComGetEvent());
    }*/
	/**
	 * OnKeypress event handling <br>
	 **/
	
	/**
	 * OnChange event handling <br>
	 **/
	function obj_change(){
		var obj=ComGetEvent();
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if ( ComTrim(obj.value) != "" ) {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
				   	break;
			}
	    } else {
			switch(ComGetEvent("name")) {
	    		case "vndr_seq":
	        		formObj.vndr_nm.value="";
				   	break;
			}
		}
	}
	/**
	 * Event handling of Onchange of combo
	 * Setting format of loc_cd when changing ACEP type
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function ar_hd_qtr_ofc_cd_OnChange(comboObj, Index_Code, Text){
		getAgmtOffice(Index_Code);
	}
	/**
	 * Event handling of Onchange of combo
	 * Setting format of loc_cd when changing ACEP type
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function eq_cmpo_cd_OnChange(comboObj, Index_Code, Text){
		setDivCombo();
	}
	/**
	 * Event handling of Onchange of combo
	 * Setting format of loc_cd when changing ACEP type
	 * @param	{IBMultiCombo}	comboObj	Changed combo object
	 * @param	{Number}		Index_Code	Changed combo code
	 * @param	{String}		Text		Changed combo value
	 */
	function eq_rpr_cd_OnChange(comboObj, Index_Code, Text){
		setDivCombo();
	}
    /**
     * Sheet related process processing
     *
     * @param {IBSheet}sheetObj Used sheet object
     * @param {Form}formObj Used form object
     * @param {Number}sAction Variable for diverge (Define from CoObject.js)
     */
    function doActionIBSheet(sheetObj,formObj,sAction,sActionIdx) {
        sheetObj.ShowDebugMsg(false);
        switch(sAction) {
	    	// Initializing
	    	case IBCLEAR:
	    		sheetObj.SetWaitImageVisible(0);
	    		MnrWaitControl(true);
	    		//Initializing sheet
	    		sheetObjects[0].RemoveAll();
				//Loading
				if(sActionIdx==0) {
					//Initializing combo data of condition part
					for(var i=0; i < comboObjects.length;i++){
						comboObjects[i].RemoveAll();
					}
					//Retrieving combo data
					var sCondition=new Array (
						new Array("MnrGenCd","CC", "COMMON") 		//Tariff Type
					  , new Array("MdmOrganization","RHQ","FALSE") 	//RegionalHQ
					  , new Array("MnrEqCmpoCd","3","COMMON")		//Component
					  , new Array("MnrCedexOthCd","RPR","COMMON")	//Repair
					  , new Array("MnrGenCd","CD00007", "COMMON")	//Status
					)
					var comboList=MnrComSearchCombo(sheetObj,sCondition);
					//Setting combo data
					for(var i=0; i < comboList.length;i++){
						if(comboList[i] != null){
							var cnt=0;
							for(var j=0; j < comboList[i].length;j++){
								var tempText=comboList[i][j].split("|");
								if(i==0) {//Tariff Type
									cost_grp_cd.InsertItem(j, tempText[1] ,tempText[0]);
								} else if(i==1) {//RegionalHQ
									ar_hd_qtr_ofc_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==2) {//Component
									eq_cmpo_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==3) {//Repair
									eq_rpr_cd.InsertItem(j, comboList[i][j] ,tempText[0]);
								} else if(i==4) {//Status
									if(tempText[0]=="HE"||tempText[0]=="HA") {
										mnr_trf_sts_cd.InsertItem(cnt++, tempText[1] ,tempText[0]);
									}
								}
							}
						}
					}
					eq_cmpo_cd.InsertItem(0, "ALL" ,"A" ); 		//Component
					eq_rpr_cd.InsertItem(0, "ALL" ,"A" ); 		//Repair
					trf_div_cd.InsertItem(0, "ALL" ,"A" ); 		//Division
					mnr_trf_sts_cd.InsertItem(0, "ALL" ,"A" );	//Status
				}
				//Value setting of initialize
				cost_grp_cd.SetSelectCode("MRDR");//Tariff Type
				rqst_ofc_cd.SetSelectCode("");//Office
				ar_hd_qtr_ofc_cd.SetSelectCode(defRhqOfc);//Regional HQ
				formObj.vndr_seq.value="";		//S/P Code
				formObj.vndr_nm.value="";		//S/P Name
				eq_cmpo_cd.SetSelectCode("A",false);//Component
				eq_rpr_cd.SetSelectCode("A",false);//Repair
				trf_div_cd.SetSelectCode("A");//Division
				mnr_trf_sts_cd.SetSelectCode("A");//Status
	    		MnrWaitControl(false);
	    		sheetObj.SetWaitImageVisible(1);
	    		break;
	    	//Retrieving(sevice provider No. at inserting)
			case IBSEARCH_ASYNC01:
				if ( validateForm(sheetObj, formObj, sAction) ) {
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq.value, 6, "0");
					//Service Provider Detail Information
					var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
					var vndrSeq=ComGetEtcData(sXml, "vndr_seq");
					if(vndrSeq != "" && vndrSeq != undefined){
						//Setting vendor name
						ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
					} else {
						ComShowCodeMessage("MNR00005", "Service Provider");
						ComSetObjValue(formObj.vndr_nm, "");
						ComSetObjValue(formObj.vndr_seq, "");
						ComSetFocus(formObj.vndr_seq);
					}
				}
				break;
	    	//Retrieving
			case IBSEARCH:
				if(validateForm(sheetObj,formObj,sAction)) {
					sheetObj.SetWaitImageVisible(1);
					formObj.f_cmd.value=SEARCH;
					if(formObj.check_usd_only.checked){
						formObj.curr_cd.value="Y";
					} else {
						formObj.curr_cd.value="N";
					}
					var sXml=sheetObj.GetSearchData("EES_MNR_0236GS.do", FormQueryString(formObj));
					sheetObj.LoadSearchData(sXml,{Sync:1} );
				}
				break;
        }
    }
    /**
     * Validating process for input form data
     */
    function validateForm(sheetObj,formObj,sAction){
		//At retrieving
		if(sAction==IBSEARCH){
			//IBMultiCombo Checking mandatory
			var costGrpCd=ComGetObjValue(formObj.cost_grp_cd);		//Tariff Type
			var arHdQtrOfcCd=ComGetObjValue(formObj.ar_hd_qtr_ofc_cd);	//Regional HQ
			var rqstOfcCd=ComGetObjValue(formObj.rqst_ofc_cd);		//Office
			if(costGrpCd=='') {
				ComShowCodeMessage("MNR00036","Tariff Type");
				//formObj.cost_grp_cd.focus();
			    return false;
			}
			if(arHdQtrOfcCd=='') {
				ComShowCodeMessage("MNR00036","Regional HQ");
				//formObj.ar_hd_qtr_ofc_cd.focus();
				return false;
			}
			if(rqstOfcCd=='') {
				ComShowCodeMessage("MNR00036","AGMT Office");
				//formObj.rqst_ofc_cd.focus();
			    return false;
			}
		}
    	return true;
    }
/* ********* User Functions ************* */
    /**
 	 * Retrieving office when regional HQ changing
 	 * @param comboObj
 	 * @param Index_Code
 	 * @param Text
 	 * @return
 	 */
 	function getAgmtOffice(Index_Code){
 		var formObj=document.form;
 		rqst_ofc_cd.RemoveAll();
 		var arHdQtrOfcCd=ComGetObjValue(formObj.ar_hd_qtr_ofc_cd);
		var sCondition=new Array (
			new Array("MdmOrganization","SEARCH",arHdQtrOfcCd)
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
		rqst_ofc_cd.InsertItem(0,"ALL","A");
		if(comboList[0] != null){
			for(var j=0; j < comboList[0].length;j++){
				var tempText=comboList[0][j].split("|");
				rqst_ofc_cd.InsertItem(j + 1, comboList[0][j] ,tempText[0]);
			}
		}
		rqst_ofc_cd.SetSelectCode("A");
 	}
 	/**
 	 * Component, Repair When changing combo event
 	 * Setting division combo when component, repair value was presence
 	 * @return
 	 */
	function setDivCombo() {
		var formObj=document.form;
		var eqCmpoCd=ComGetObjValue(formObj.eq_cmpo_cd);	//Component
		var eqRprCd=ComGetObjValue(formObj.eq_rpr_cd);	//Repair
		var costGrpCd=ComGetObjValue(formObj.cost_grp_cd);	//Tariff Type
		var prefixCostGrpCd=costGrpCd.substring(0,3);
		if((eqCmpoCd==""||eqCmpoCd==null||eqCmpoCd=="A") || (eqRprCd==""||eqRprCd==null||eqRprCd=="A")) {
			return;
		}
		trf_div_cd.RemoveAll();
		var compRprJoinStr=ComTrimAll(eqCmpoCd) + ComTrimAll(eqRprCd);
		var sCondition=new Array (
		 	new Array("MnrDivCd",compRprJoinStr +','+ prefixCostGrpCd, "COMMON1")
		)
		var comboList=MnrComSearchCombo(sheetObjects[0],sCondition);
        var cnt=0;
		if(comboList[0] != null){
			for(var j=0; j < comboList[0].length;j++){
				var tempText=comboList[0][j].split("|");
				if(ComTrimAll(tempText[0])!="" && ComTrimAll(tempText[0])!=null && ComTrimAll(tempText[0])!=undefined) {
					trf_div_cd.InsertItem(cnt++, comboList[0][j] ,tempText[0]);
				}
			}
			trf_div_cd.InsertItem(0, "ALL" ,"A" );
		}
		trf_div_cd.SetSelectCode("A");
	}
	/**
	 * (Service Provider) Function of processing for pop-up screen return value<br>
	 * @param {arry} returnedValues Returned value array of pop-up screen
	 * @param Row The object is row index in case of IBSheet
	 * @param Col The object is column index in case of IBSheet
	 * @param The object is sheet index in case of IBSheet
	 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
		var formObj=document.form;
		if ( aryPopupData.length > 0 ) {
			formObj.vndr_seq.value=aryPopupData[0][2];
			formObj.vndr_nm.value=aryPopupData[0][4];
			var sXml=MnrGetPartner(sheetObjects[0],formObj.vndr_seq.value,"RPR");
			if(ComGetEtcData(sXml, "vndr_seq") != null){
				//Setting vendor name
				ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
			} else {
				ComShowCodeMessage("MNR00005", "Service Provider");
				ComSetObjValue(formObj.vndr_nm, "");
				ComSetObjValue(formObj.vndr_seq, "");
				ComSetFocus(formObj.vndr_seq);
			}
		}
	}
	function mnr_trf_sts_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
	{
	 form.mnr_trf_sts_cd_text.value = mnr_trf_sts_cd.GetText(parseInt(newIndex), 0);
	 }
