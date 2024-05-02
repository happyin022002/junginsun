/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0993.js
*@FileTitle  : Pick up No Notice Manual Setup Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
/****************************************************************************************
   Event distinction code: [Initialization]INIT=0; [Input]ADD=1; [Retrieve]SEARCH=2; [Retrieving List]SEARCHLIST=3;
					[Modification]MODIFY=4; [Delete]REMOVE=5; [Deleting list]REMOVELIST=6 [Multi-Processing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------The following code is added to make a good JSDoc ------------------*/
   /**
	 * @fileoverview As a java script file that uses common on business, it has been defined about calendar-related functions.
	 * @author
	 */
	/**
	 * @extends
	 * @class esm_bkg_0993 : It defines business script that using screen for esm_bkg_0993 creation.
	 */
	//Common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var isLoaded=false;
	var isRetrieved=false;
	var isSetup=false;
	var jobId="";
	var timeId="";
	var monCnt=0; // Limiting 10 minutes(600sec/3sec=200 times)
	//Event Handler definition for Button Click event */
	document.onclick=processButtonClick;
	/**
	 * Event Handler for branch processing by judging button name. <br>
	 *
	 * @return none
	 */
	function processButtonClick(){
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			if(ComGetBtnDisable(srcName)) return false;
			switch(srcName) {
			case "btn2_Retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
				break;
			case "btn2_Setup":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
				break;
			case "btn2_UploadExcel":
				doActionIBSheet(sheetObject1,formObject,IBLOADEXCEL);
				break;
			case "btn2_ExcelTemplate":
				sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1,Merge:1 });
				break;
			case "btn1_Close":
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
	  * Registering IBSheet Object in to Array
	  * Afterwards, when other items need to be batch processed,it can add to the process that stores in to array
	  * The array is defined at upper part of source
	  *
	  * @param {IBSheet} sheet_obj mandatory, IBSheet control
	  * @return none
	  */
	function setSheetObject(sheet_obj) {
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	  * Sheet basic setting & initializing
	  * onLoad Event HandlerImplementation of body tag
	  * After loading screen in the browser, add function in pre-processing
	  * @return none
	  */
	function loadPage() {
		for(var i=0; i<sheetObjects.length; i++){
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		setButtonEnableDisable();
	}
	 /**
	  * Definition for sheet initial setting value, header
	  * param : sheetObj ==> sheet object,
	  * sheetNo ==> If the serial number ID tag attached to the sheet are many,
	  * adding 'Case' clause as a number of sheets, configures initial module.<br>
	  *
	  * @param {ibsheet} sheetObj mandatory, IBSheet object
	  * @param {number}  sheetNo  mandatory, IBSheet object serial number
	  * @return none
	  */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
		case 'sheet1':      //sheet1 init
			with(sheetObj){
		  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		  var HeadTitle1="|Error|B/L No.|Booking No.|CNTR No.|Ofc cd|Available Date|Last Free Date|Pick up No|PICK YD|RTN YD||||VVD|Rail Load Date|NT|F|O|C|POD|DEL|Delivery\nTerm";
		  var headCount=ComCountHeadTitle(HeadTitle1);
		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
		  var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers=[ { Text:HeadTitle1, Align:"Center"} ];
		  InitHeaders(headers, info);
		  var cols=[{Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag",          KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"err_flag",        KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",           KeyField:1,   Format:"",   UpdateEdit:0,   InsertEdit:1 },
					{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"bkg_no",          KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",         KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"eq_ctrl_ofc_cd",  KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"pkup_aval_dt",    KeyField:0,   Format:"Ymd",UpdateEdit:0,   InsertEdit:0 },
					{Type:"Date",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"lst_free_dt",     KeyField:0,   Format:"Ymd",UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"pkup_no",         KeyField:0,   Format:"",   UpdateEdit:1,   InsertEdit:0,   EditLen:20,   AcceptKeys:"N" },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pkup_yd_cd",      KeyField:0,   Format:"",   UpdateEdit:1,   InsertEdit:0,   EditLen:7,    AcceptKeys:"N|E",   InputCaseSensitive:1  },
					{Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"rtn_yd_cd",       KeyField:0,   Format:"",   UpdateEdit:1,   InsertEdit:0,   EditLen:7,    AcceptKeys:"N|E",   InputCaseSensitive:1  },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",          KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",      KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",      KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",             KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Date",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rail_lod_dt",     KeyField:0,   Format:"Ymd",UpdateEdit:0,   InsertEdit:0 },
					{Type:"Date",      Hidden:1, Width:75,   Align:"Center",  ColMerge:1,   SaveName:"ntfc_dt",         KeyField:0,   Format:"Ymd",UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"frt_clt_flg",     KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"obl_clt_flg",     KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"cstms_clr_flg",   KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",          KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",          KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 },
					{Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"de_term_cd",      KeyField:0,   Format:"",   UpdateEdit:0,   InsertEdit:0 } ];
		  InitColumns(cols);
		  SetEditable(1);
//          SetColProperty("pkup_aval_dt", {Format:"####-##-##"} );
//          SetColProperty("lst_free_dt", {Format:"####-##-##"} );
		  SetSheetHeight(250);
				}
			break;
		case "template":
			with(sheetObj){
		  //no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				  var HeadTitle1="B/L No";
				  var headCount=ComCountHeadTitle(HeadTitle1);
				  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataGetRowMerge:1 } );
				  var info={ Sort:0, ColMove:0, HeaderCheck:0, ColResize:0 };
				  var headers=[ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);
				  var cols=[ {Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				  InitColumns(cols);
				  SetEditable(0);
						DataInsert();
						SetCellValue(1, "bl_no","SHAXXXXXXXXX",0);
				  SetVisible(false);
				  }
			break;
		}
	}
	/**
	 * Handling process about Sheet <br>
	 *
	 * @param {ibsheet} sheetObj mandatory,IBSheet object
	 * @param {object}  formObj  mandatory,HTML Form object
	 * @param {string}  sAction  mandatory,Action name
	 * @return none
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		//sheetObj.ShowDebugMsg = false;
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
		case IBLOADEXCEL:
			//sheetObj.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"-1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"1=>bl_no"});
//        	sheetObj.LoadExcel({ Mode:"NoHeader",WorkSheetNo:"1", FileExt:"xls|xlsx",ColumnMapping:"1=>bl_no"});
			//sheetObj.LoadExcel({ Mode:"HeaderMatch", StartRow: "1",Append:1,ColumnMapping:"1=>bl_no"});
//        	sheetObj.LoadExcel();
			//var columnMappings="1=>bl_no";
			//sheetObj.LoadExcel({ Mode:"HeaderSkip"});
			//sheetObj.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"1",EndRow:"-1",WorkSheetName:"",Append:false,ColumnMapping:"columnMappings"});
			//sheetObj.LoadExcel();
			//sheetObj.LoadExcel();
			var params = { StartRow: "1", ColumnMapping:"||1"};
			sheetObj.LoadExcel(params);

			//sheetObj.LoadExcel({ Mode:"HeaderSkip",WorkSheetNo:"1",StartRow:"1",ColumnMapping:"4"});
			break;
		case IBSEARCH:
			if (!isLoaded || (sheetObj.RowCount()== 0)) {
				ComShowCodeMessage("BKG01079", "Upload Excel");
				break;
			}
			if (!validateForm(sheetObj, formObj, sAction)) break;
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			var sParam=FormQueryString(formObj);
			var sParamSheet1=sheetObj.GetSaveString();
			if (sParamSheet1 != "") sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
			sheetObj.DoSearch("ESM_BKG_0993GS.do", sParam );
			ComOpenWait(false);
			break;
		case IBSAVE:
			if (!isRetrieved) {
				ComShowCodeMessage("BKG01079", "Retrieve");
				break;
			}
			if(!validateForm(sheetObj,formObj,sAction)) break;
			var sParamSheet1=sheetObj.GetSaveString();
			if (sParamSheet1 == "") {
				ComShowCodeMessage("BKG00743");
				break;
			}
			if (!ComShowCodeConfirm("BKG00824")) break;
			ComOpenWait(true);
			formObj.f_cmd.value=MULTI;
			var sParam=FormQueryString(formObj);
			sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
			var sXml=sheetObj.GetSaveData("ESM_BKG_0993GS.do", sParam);
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			//doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC06);
			break;
			// Execute Batch
		case IBSEARCH_ASYNC06:
			ComOpenWait(true);
			// 1. Checking ESM_BKG_B019
			var sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B019";
				var sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml,"BATCH_STATUS");
				if (isRunning == "true") {
					ComOpenWait(false);
					break;
				}
			} else {
				ComOpenWait(false);
				break;
			}
			// 2. Checking ESM_BKG_B012
			sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B012";
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml,"BATCH_STATUS");
				if (isRunning == "true") {
					ComOpenWait(false);
					break;
				}
			} else {
				ComOpenWait(false);
				break;
			}
			// 3. Checking ESM_BKG_B015
			sParam="&f_cmd=" + SEARCH05 + "&batch_cd=ESM_BKG_B015";
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var isRunning=ComGetEtcData(sXml,"BATCH_STATUS");
				if (isRunning == "true") {
					ComOpenWait(false);
					break;
				}
			} else {
				ComOpenWait(false);
				break;
			}
			formObj.f_cmd.value=SEARCH03;
			sParam=FormQueryString(formObj);
			sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				monCnt=1;
				jobId=ComGetEtcData(sXml,"JOB_ID");
				timeId=setTimeout("monitoringBatchJob()", 1000*3);
			} else {
				ComOpenWait(false);
			}
			break;
			// Monitor Batch Status
		case IBSEARCH_ASYNC07:
			var sParam="&f_cmd=" + SEARCH04 + "&job_id=" + jobId;
			var sXml=sheetObj.GetSearchData("ESM_BKG_1063GS.do", sParam);
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) == "S") {
				var jobStatus=ComGetEtcData(sXml,"BATCH_STATUS");
				if (jobStatus == "0" || jobStatus == "1" || jobStatus == "3" || jobStatus == "10") { // None. Running or Starting or Restart
					if (monCnt < 200) { // limiting 10 minutes(3sec*200=10min)
						monCnt++;
						timeId=setTimeout("monitoringBatchJob()", 1000*3);
					} else {
						ComOpenWait(false);
					}
				} else {
					ComOpenWait(false);
				}
			} else {
				ComOpenWait(false);
			}
			break;
		}
	}
	/**
	 * Handling validity verification process about screen form input value.<br>
	 *
	 * @param {ibsheet} sheetObj mandatory,IBSheet object
	 * @param {object}  formObj  mandatory,HTML Form object
	 * @param {string}  sAction  mandatory,Action name
	 * @return boolean Returning whether Form object validate. if valid, true, if not false
	 */
	function validateForm(sheetObj, formObj, sAction) {
		switch(sAction) {
		case IBSEARCH:
			var dupStr="bl_no";
			var dupRow=sheetObj.ColValueDup(dupStr, false);
			if (dupRow > 0) {
				ComShowCodeMessage("BKG00488");
				return false;
			}
			break;
		case IBSAVE:
			with (sheetObj) {
				// 수정된 행만 수집하여 Loop
				var findRowArray = FindStatusRow("U").split("|");
				for (var k in findRowArray) {
					if (GetCellValue(findRowArray[k],"pkup_no") == "") {
						ComShowCodeMessage("BKG01101", "Pick up No");
						SelectCell(findRowArray[k],"pkup_no")
						return false;
					}
					if (GetCellValue(findRowArray[k],"pkup_yd_cd") == "") {
						ComShowCodeMessage("BKG01101", "PICK YD");
						SelectCell(findRowArray[k],"pkup_yd_cd")
						return false;
					}
				}
			}
			break;
		}
		return true;
	}
	/**
	 * Changing status button Enable <br>
	 *
	 * @return none
	 */
	function setButtonEnableDisable() {
		ComBtnDisable("btn2_Retrieve");
		ComBtnDisable("btn2_Setup");
		if (isLoaded & !isRetrieved) {
			ComBtnEnable("btn2_Retrieve");
		}
		if (isRetrieved & !isSetup) {
			ComBtnEnable("btn2_Setup");
		}
	}
	/**
	 * Handling event excel upload <br>
	 *
	 * @param {ibsheet} sheetObj mandatory,IBSheet object
	 * @return none
	 */
	function sheet1_OnLoadExcel(sheetObj) {
		isLoaded=true;
		isRetrieved=false;
		isSetup=false;
		setButtonEnableDisable();
	}
	/**
	 * After inquiry completing using search function, handles occuring event <br>
	 *
	 * @param {ibsheet} sheetObj mandatory,IBSheet object
	 * @param {string}  ErrMsg   optional,error message
	 * @return none
	 */
	function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
		if (ErrMsg == "") {
			with(sheetObj) {
				for (var j=HeaderRows(); j<=LastRow(); j++) {
					if(GetCellValue(j, "err_flag") == "Y") {
						SetRowFontColor(j,"#FF0000");
						SetRowEditable(j, false);
					}
				}
			}
			isRetrieved=true;
		}
		setButtonEnableDisable();
	}
	/**
	 * Handling event Save completion <br>
	 *
	 * @param {ibsheet} sheetObj mandatory,IBSheet object
	 * @param {string}  ErrMsg   optional,error message
	 * @return none
	 */
	function sheet1_OnSaveEnd(sheetObj,ErrMsg) {
		if (ErrMsg == "") {
			ComShowCodeMessage("BKG00102");
			isSetup=true;
			setButtonEnableDisable();
		}
	}
	 /**
	  * Monitoring batch status
	  * @return none
	  */
	 function monitoringBatchJob() {
		var sheetObj=sheetObjects[0];
		doActionIBSheet(sheetObj,document.form,IBSEARCH_ASYNC07);
	 }
	 /**
	  * Getting batch status description
	  * @param {string} status mandatory batch status code
	  * @return {string} batch status description
	  */
	 function getBatchStatusDesc(status) {
		/*
			status code
		status	1	RUNNING
		status	3	STARTING
		status	4	SUCCESS
		status	5	FAILURE
		status	6	TERMINATED
		status	7	ON_ICE
		status	8	INACTIVE
		status	9	ACTIVATED
		status	10	RESTART
		status	11	ON_HOLD
		status	12	QUE_WAIT
		*/
		var desc="";
		if (status == "1") {
			desc="Running";
		} else if (status == "3") {
			desc="Starting";
		} else if (status == "4") {
			desc="Success";
		} else if (status == "5") {
			desc="Fail";
		} else if (status == "6") {
			desc="Terminated";
		} else if (status == "7") {
			desc="On Ice";
		} else if (status == "8") {
			desc="Inactive";
		} else if (status == "9") {
			desc="Activated";
		} else if (status == "10") {
			desc="Restart";
		} else if (status == "11") {
			desc="On Hold";
		} else if (status == "12") {
			desc="Que Wait";
		} else {
			desc="Undefined status:" + status + "";
		}
		return desc;
	 }
