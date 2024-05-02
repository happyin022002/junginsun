/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0053.js
*@FileTitle : ESM_BKG-0053
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
/****************************************************************************************
Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
	 * @extends
	 * @class business script for  Customer Code Entry
	 */
	// common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_transmit":
					doActionIBSheet(sheetObject1,document.form,IBSAVE);
					break;
				case "btn_close":
					ComClosePopup();
					break;
			} // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}
	// handling of Sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		 switch(sAction) {
			case IBSAVE:        // save
			if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
			}
			formObj.frm_vsl_cd.value=formObj.frm_vvd_number.value.substring(0,4);
			formObj.frm_skd_voy_no.value=formObj.frm_vvd_number.value.substring(4,8);
			formObj.frm_skd_dir_cd.value=formObj.frm_vvd_number.value.substring(8);

			if(formObj.edi_gubun.checked)
				formObj.frm_trans_gubun.value="M";
			if(formObj.edi_gubun2.checked)
				formObj.frm_trans_gubun.value="P";
			if(formObj.edi_gubun.checked && formObj.edi_gubun2.checked)
				formObj.frm_trans_gubun.value="A";
			if (document.form.pol_gubun[0].checked)
			{
				document.form.frm_pol_cd.value=document.form.frm_port_cd.value;
				document.form.frm_pod_cd.value="";
			} else {
				document.form.frm_pol_cd.value="";
				document.form.frm_pod_cd.value=document.form.frm_port_cd.value;
			}
			//Manifest Type 값을 구한다.
			for(var i=0; i < document.form.type_gubun.length; i++) {
				if(document.form.type_gubun[i].checked)
					document.form.frm_edi_ind.value=document.form.type_gubun[i].value;
			}
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
			ComOpenWait(true);
			var sXml=sheetObj.GetSaveData("ESM_BKG_0053GS.do", sParam);
			//sheetObj.DoAllSave("ESM_BKG_0723GS.do", FormQueryString(formObj));
			var key=ComGetEtcData(sXml, "KEY");
			ComOpenWait(true);
			intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
//				sheetObj.SetVisible(1);
			break;
		}
	}
	/**
	 * BackEndJob.
	 */
	 function doActionValidationResult(sheetObj, sKey) {
		//sheetObjects[0].SetWaitImageVisble(0);
		var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0053GS.do?f_cmd=" + SEARCH03	+ "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowCodeMessage('BKG00204');
			//ComShowMessage(ComResultMessage(sXml));
			return;
		} else if (sJbStsFlg == "FAIL") {
			clearInterval(intervalId);
			ComOpenWait(false);
			ComShowMessage(ComResultMessage(sXml));
		}
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
		initSheetData(sheetObjects[0], document.form);
//           axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
//           axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
//           axon_event.addListener('keydown', 'obj_ComKeyEnter', document.form);
		 axon_event.addListenerForm("click","obj_click", document.form);
	}
	 function initSheetData(sheetObj, formObj) {
		sheetObj.RemoveAll();
		sheetObj.DataInsert(-1);
		IBS_CopyRowToForm(sheetObj, formObj, 1, "frm_");
	}
	/**
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
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

					var HeadTitle1="|vvd_number|VSL_CD|skd_voy_no|skd_dir_cd|pol_cd|pod_cd|edi_ind|trans_gubun|port_cd";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vvd_number",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"vsl_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pol_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"edi_ind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"trans_gubun",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
								 {Type:"Text",      Hidden:0,  Width:0,    Align:"Center",  ColMerge:0,   SaveName:"port_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

					InitColumns(cols);
					SetVisible(0);
					SetEditable(1);
					SetSheetHeight(100);
				}
				 break;
			 }
		 }
		/**
		 * HTML Control onkeyUp event
		 **/
		function obj_KeyUp() {
			var formObject=document.form;
			var srcName=ComGetEvent("name");
			var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
			var srcValue=window.event.srcElement.getAttribute("value");
			if (ComChkLen(srcValue, srcMaxLength) == "2") {
				ComSetNextFocus();
			}
		}
		/**
		 * handling process for input validation
		 */
		function validateForm(sheetObj,formObj,sAction){
			 switch (sAction) {
			 case IBSAVE:
				 if (formObj.frm_vvd_number.value == "" )
				 {
					ComShowCodeMessage('BKG00227');
					formObj.frm_vvd_number.focus();
					return false;
				 }
				 if (formObj.frm_vvd_number.value.length > 0 && formObj.frm_vvd_number.value.length < 9) {
					ComShowCodeMessage('BKG00227');
					formObj.frm_vvd_number.focus();
					return false;
				 }
				 for(var i=0; i < document.form.pol_gubun.length; i++) {
					if(document.form.pol_gubun[i].checked) {
						if(document.form.pol_gubun[i].value == 1)
						{
							if ( formObj.frm_port_cd.value == "" )
							{
								ComShowCodeMessage('BKG00209');
								formObj.frm_port_cd.focus();
								return false;
							}
							if (formObj.frm_port_cd.value.length > 0 && formObj.frm_port_cd.value.length < 5) {
								ComShowCodeMessage('BKG00209');
								formObj.frm_port_cd.focus();
								return false;
							}
						}
						if(document.form.pol_gubun[i].value == 2)
						{
							if ( formObj.frm_port_cd.value == "" )
							{
								ComShowCodeMessage('BKG00210');
								formObj.frm_port_cd.focus();
								return false;
							}
							if (formObj.frm_port_cd.value.length > 0 && formObj.frm_port_cd.value.length < 5) {
								ComShowCodeMessage('BKG00210');
								formObj.frm_port_cd.focus();
								return false;
							}
						}
					}
				 }
				 var isCheck=0;
				 if(formObj.edi_gubun.checked || formObj.edi_gubun2.checked)
					 isCheck++;
				 if(isCheck == 0)
				 {
					 ComShowCodeMessage('BKG00212');
					 return false;
				 }
			 return true;
			 break;
			}
		}
