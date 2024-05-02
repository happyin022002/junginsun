/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0211.js
*@FileTitle  : Tire Purchase W/O Inquiry - Popup 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
/****************************************************************************************
 Eevent classification code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
 COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_mnr_0211 : ees_mnr_0211 - Defining a script used by screen
 */
	var sheetObjects=new Array();
	var sheetCnt=0;
	var initInd='N'
	var mainMsg='W/O Inquiry Popup'
	var subMsg='XXX'
	var eqcode="";
	var eqdesc="";
	//Defining event handler of button click */
	document.onclick=processButtonClick;
	//Event handler to diverge process by button name */
	function processButtonClick() {
		/***** Adding variable of sheet object in case of more than 2 sheets per tabs *****/
		var sheetObject=sheetObjects[0];
		/** **************************************************** */
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch (srcName) {
			case "btn1_Retrieve":
				doActionIBSheet(sheetObject,formObject,IBSEARCH);
				break;
			case "btn1_New":
				doActionIBSheet(sheetObject,formObject,IBCLEAR);
				break;
			case "btn1_Close":
				ComClosePopup(); 
				break;
			case "btn_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;
			} // end switch
		} catch (e) {
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
		MnrWaitControl(true);
		initControl();
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
		var opener = window.dialogArguments;
		if (!opener) opener = parent;
		var formObject=document.form;
		if(opener.document.form.vsl_cd2!=undefined)
		{
			formObject.vsl_cd.value=(opener.document.form.vsl_cd2.value == "-1" || opener.document.form.vsl_cd2.value == "")? "" :opener.document.form.vsl_cd2.value;
			if(formObject.vsl_cd.value.length > 0)
			setVesselInfo(sheetObjects[0],1,formObject.vsl_cd.value);
			//formObject.vsl_cd.SetEnable(0);
			formObject.vsl_cd.Enable = false;
		}
		if(opener.document.form.cost_ofc_cd!=undefined)
		{
			formObject.cost_ofc_cd.value=opener.document.form.cost_ofc_cd.value;
		}
//		if(formObject.vsl_cd.value.length > 0)
		doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		MnrWaitControl(false);
	}
	/**
	 * Initializing variable for IBSheet and defining header
	 * param : sheetObj ==> sheet object, sheetNo ==> Sequence number from sheet object tag id
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
			      var HeadTitle1="|Seq.|W/O No.|VVD CD|Office|Yard|Curr.|W/O Issue\nDate|Unit Type|Part No.|Part Name|Q'ty|Unit Cost|Amount";
			      var headCount=ComCountHeadTitle(HeadTitle1);
			      var prefix="sheet1_";
			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			      InitHeaders(headers, info);
			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Status" },
			             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq" },
			             {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"mnr_ord_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ord_iss_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_spl_yd_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"curr_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Date",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cre_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_ut_tp_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_qty",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"spr_prt_uc_amt",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Float",     Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"total_amt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1 } ];
			      InitColumns(cols);
			      SetEditable(0);
			      SetSelectionMode(smSelectionRow);
			      SetSheetHeight(230);
				}
		    break;
		}
	}
	/**
	* Assigning array of IBSheet object
	* Array defined at the top of the source
	*/
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}
  	function initControl() {
  		//Axon event handling 1. Catching event
  		var formObject=document.form;
  		axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject);
//  	axon_event.addListenerFormat('focus',    'obj_activate',    formObject);
//  	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);
  		axon_event.addListenerFormat('change',	 'obj_change',	formObject);
  	}
  	//Axon event handling 2. Event handling function
  	function obj_deactivate(){
  		ComChkObjValid(ComGetEvent());
  	}
  	function obj_activate(){
  		ComClearSeparator(ComGetEvent());
  	}
  	function obj_change(){
  		var obj=ComGetEvent();
  		var formObj=document.form;
  		var sheetObj=sheetObjects[0];
  		if ( ComTrim(obj.value) != "" ) {
  			switch(ComGetEvent("name")) {
  			case "vsl_cd":
  				setVesselInfo(sheetObj,1,formObj.vsl_cd.value);
  				break;
  			}
  		}
  	}
  	
//  	function obj_keypress(){
//  		obj=ComGetEvent();
//  		keys=event.keyCode;
//  		var sheetObj=sheetObjects[0];
//  		if(obj.dataformat == null) return;
//  		window.defaultStatus=obj.dataformat;
//  		var formObj=document.form;
//  		if ( ComTrim(obj.value) != "" ) {
//  			switch(ComGetEvent("name")) {
//  			case "vsl_cd":
//  				MnrWaitControl(true);
//  				var strVslCdAll=formObj.vsl_cd.value;
//  				if(strVslCdAll.length > 3)
//  				{
//  					if(keys==13)
//  					{
//  						setVesselInfo(sheetObj,1,strVslCdAll);
//  						ComSetFocus(formObj.fromcal);
//  					}
//  				}
//  				break;
//  			}
//  		}
//  		switch(obj.dataformat) {
//  		case "ymd":
//  		case "int":
//  			ComKeyOnlyNumber(obj);
//  			break;
//  		case "float":
//  			ComKeyOnlyNumber(obj, "-.");
//  			break;
//  		case "eng":
//  			ComKeyOnlyAlphabet();
//  			break;
//  		case "engup":
//  			ComKeyOnlyAlphabet('uppernum');
//  			break;
//  		}
//  	}
  	
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
		MnrWaitControl(false);
		nowLoad=0;
	}
	//Sheet processing-related processes
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction)
		{
			case IBSEARCH:      //Retrieving
				if(!validateForm(sheetObj,formObj,sAction)) return;
				MnrWaitControl(true);
				nowLoad=1;
				sheetObjects[0].RemoveAll();
				formObj.f_cmd.value=SEARCH;
				var sParam="";
				var aryPrefix=new Array("sheet1_");
				sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSearchData("EES_MNR_0194GS.do", sParam);
				arrDataSearchDbXml=sXml.split("|$$|");
				for ( var i=0; i < arrDataSearchDbXml.length; i++) {
					sheetObjects[i].RenderSheet(0);
					sheetObjects[i].SetWaitImageVisible(0);
					sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
					sheetObjects[i].RenderSheet(1);
				}
				MnrWaitControl(false);
			break;
			case IBCLEAR:      //Initializing
				MnrWaitControl(true);
				formObj.cost_ofc_cd.value=currOfcCd;
				formObj.tocal.value=ComGetNowInfo();
				formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo("ymd"), "d", -90);
				formObj.vsl_cd.value="";
				formObj.vsl_eng_nm.value="";
				sheetObjects[0].RemoveAll();
				MnrWaitControl(false);
			break;
		}
	}
	/**
	* Validating process for input form data
	*/
	function validateForm(sheetObj, formObj, sAction) {
		with(formObj){
			//At retrieving
			if(sAction==IBSEARCH)
			{
//				if(formObj.vsl_cd.value == ""){
//					ComShowCodeMessage("MNR00172","Vessel");
//					ComSetFocus(formObj.vsl_cd);
//					return false;
//				}
				if(formObj.fromcal.value.length <8){
					ComShowCodeMessage("MNR00036","W/O Issue Date");
					ComSetFocus(formObj.fromcal);
					return false;
				}
				if(formObj.tocal.value.length <8){
					ComShowCodeMessage("MNR00036","W/O Issue Date");
					ComSetFocus(formObj.tocal);
					return false;
				}
			}
			return true;
		}
	}
	function setVesselInfo(sheetObj,Row,vsl_cd){
		MnrWaitControl(true);
		var formObj=document.form;
		var sXml=MnrComVesselInfoSearch(sheetObj,vsl_cd);
		var retArr=MnrXmlToArray(sXml);
		if(retArr != null){
			formObj.vsl_eng_nm.value=retArr[0][0];
			ComSetFocus(formObj.fromcal);
		} else {
			formObj.vsl_eng_nm.value="";
			ComSetFocus(formObj.vsl_cd);
		}
		MnrWaitControl(false);
		calReq=0;
	}