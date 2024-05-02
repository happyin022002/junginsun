/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0497.js
*@FileTitle : ESM_BKG-0497
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
					[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
					character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

// global variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
	function processButtonClick(){
		 /***** using extra sheet valuable if there are more 2 sheets *****/
				 var sheetObject1=sheetObjects[0];
		 /*******************************************************/
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
			case "btn_edi":
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			break;
			case "btn_close":
				ComClosePopup();
			break;
			} // end switch
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
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
		initSheetData(sheetObjects[0], formObj);
		//event
		axon_event.addListenerForm("change", "frmObj_OnChange", formObj);
		axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
		axon_event.addListenerFormat("keypress","obj_KeyPress", formObj);
		axon_event.addListener("keydown", "obj_ComKeyEnter", formObj);

		formObj.frm_vvd_number.focus();
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
					var HeadTitle1="|vvd_number|VSL_CD|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|io_bnd_cd";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status", Hidden:1,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"ibflag"      },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"vvd_number"  },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"vsl_cd"      },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"skd_voy_no"  },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"skd_dir_cd"  },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"pol_cd"      },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"pod_cd"      },
								   {Type:"Text",   Hidden:0,  Width:0,  Align:"Center",  ColMerge:0,  SaveName:"io_bnd_cd"   } ];

					InitColumns(cols);

					SetEditable(1);
					SetSheetHeight(100);
					SetVisible(0);
				}
				break;
		}
	}

	// handling of Sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSAVE:
				if (!ComChkValid(formObj)) return;
				formObj.frm_vsl_cd.value = formObj.frm_vvd_number.value.substring(0,4);
				formObj.frm_skd_voy_no.value = formObj.frm_vvd_number.value.substring(4,8);
				formObj.frm_skd_dir_cd.value = formObj.frm_vvd_number.value.substring(8);
				IBS_CopyFormToRow(formObj, sheetObj, 1, "frm_");
				sheetObj.SetCellValue(1, "ibflag","I",0);
				formObj.f_cmd.value=MULTI;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sParam="";
				var sParamSheet2=sheetObjects[0].GetSaveString();
				if (sParamSheet2 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1_");
				}
				sParam += "&" + FormQueryString(formObj);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0497GS.do", sParam);
				//sheetObj.DoAllSave("ESM_BKG_0723GS.do", FormQueryString(formObj));
				var key=ComGetEtcData(sXml, "KEY");

				if(key != "EMPTY") { //  in case of existing data to transmit
					ComOpenWait(true);
					//intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);

					intervalId = setInterval(function () {
						doActionValidationResult(sheetObjects[0], key);
					},3000);

				} else {
					ComOpenWait(false);
					ComShowCodeMessage('BKG00889');
				}
				break;
		}
	}

	/**
	* searhing BackEndJob result.
	*/
	function doActionValidationResult(sheetObj, sKey) {
		//sheetObjects[0].SetWaitImageVisble(0);
		 var sXml=sheetObj.GetSearchData("ESM_BKG_0497GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");

		// finishing in case of error
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			// showing message to success
			ComShowCodeMessage('BKG00204');
			//ComShowMessage(ComResultMessage(sXml));
			return;
		} else if (sJbStsFlg == "FAIL") {
			//error
			clearInterval(intervalId);
			ComOpenWait(false);
			// showing error message
			ComShowMessage(ComResultMessage(sXml));
		}
	}

	function initSheetData(sheetObj, formObj) {
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
	}

	/**
	 * contolling keyboard on event, onkeyUp
	 **/
	 function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2" && srcName != "frm_pod_cd") {
			ComSetNextFocus();
		}
	}

	/**
	 * Form Element의 OnChange 이벤트
	 */
	function frmObj_OnChange() {
		var elementName = ComGetEvent("name");
		switch (elementName) {
			case "frm_io_bnd_cd":
				var formObj = document.form;
				if (formObj.frm_io_bnd_cd.value == "O") {
					formObj.frm_pol_cd.className = "input1";
					formObj.frm_pol_cd.setAttribute("required", "");
					formObj.frm_pod_cd.removeAttribute("required");
					formObj.frm_pod_cd.className = "input";
				} else {
					formObj.frm_pod_cd.className = "input1";
					formObj.frm_pod_cd.setAttribute("required", "");
					formObj.frm_pol_cd.removeAttribute("required");
					formObj.frm_pol_cd.className = "input";
				}
				break;
		}
	}
