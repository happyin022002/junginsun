/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0310.js
*@FileTitle  : Customs EDI (I/B)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/

/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event  */
document.onclick=processButtonClick;

	// Event handler processing by button name */
	function processButtonClick() {
		var sheetObject1=sheetObjects[0];
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch (srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_downexcel":
				if(sheetObject1.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				}else{
					sheetObject1.Down2Excel({ DownCols: makeHiddenSkipCol( sheetObject1), SheetDesign:1,Merge:1 });
				}
				break;
			case "btn_edi":
				doActionIBSheet(sheetObjects[1], formObject, IBSAVE);
				break;
			}
		} catch (e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}


	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj, formObj, sAction) {
		if (formObj.vvd.value.length != 9) {
			ComShowCodeMessage('BKG00007');
			formObj.vvd.focus();
			return false;
		}
		return true;
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
		for (i=0; i < sheetObjects.length; i++) {
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i], i + 1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		axon_event.addListenerForm("focus", "obj_Focus", document.form);
		axon_event.addListenerFormat("keypress", "obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		axon_event.addListenerForm("click", "obj_Click", document.form);
		setFormatByMfTpCd("01I");
		ComSetFocus(document.form.vvd);
	}


	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch (sheetID) {
			case "sheet1":      //sheet1 init
				with(sheetObj){
				//no support[check again]CLT if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				var HeadTitle = "|Seq.|BKG No.|B/L No.|C/T|T/S|T/VVD|POR|POL|POD|DEL" +
								// Hidden Columne
								"|vsl_cd|skd_voy_no|skd_dir_cd";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
					 {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"Seq",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 },
					 {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:145,  Align:"Center",  ColMerge:0,   SaveName:"bl_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"bkg_cgo_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"ts_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:125,  Align:"Center",  ColMerge:0,   SaveName:"vvd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"por_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"del_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					 {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_cd"        },
					 {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"skd_voy_no"    },
					 {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"skd_dir_cd"    } ];

				InitColumns(cols);
				SetEditable(1);
				SetSheetHeight(360);
			}
			break;
			case "sheet2": //sheet2 init
				with(sheetObj){
				   //if (location.hostname != "")
				   //no support[check again]CLT
					//InitHostInfo(location.hostname, location.port, page_path);
				   var HeadTitle1="|Flat File";
				   var headCount=ComCountHeadTitle(HeadTitle1);

				   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

				   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				   InitHeaders(headers, info);

				   var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						{Type:"Text",      Hidden:0, Width:300,  Align:"Left",    ColMerge:0,   SaveName:"flat_file" } ];

				   InitColumns(cols);
				   SetEditable(0);
				   SetRowHidden(0, 1);

				   SetCountPosition(0);

				   SetVisible(0);
			}
			break;
		}
	}


	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	//handling sheet process
	function doActionIBSheet(sheetObj, formObj, sAction) {
		var sheetObject1=sheetObjects[0];
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:
				if(!validateForm(sheetObj,formObj,sAction)) {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				initSheet(sheetObjects[0],0);
				formObj.f_cmd.value=SEARCH;
				formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
				formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
				formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
				formObj.pol_cd.value=formObj.pol_code.value;
				formObj.pod_cd.value=formObj.pod_code.value;
				sheetObjects[0].RemoveAll();
				sXml=sheetObjects[0].GetSearchData("ESM_BKG_0310GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				}
				ComEtcDataToForm(formObj, sheetObj);
			break;

			case IBSAVE:
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet2") {
						sheetObj.SetWaitImageVisible(0);
						/*
						 * pagerows  TRUE : BKG String not exist BL_ISSUE DATE, FALSE : Real EDI File Download
						 */
						ComOpenWait(true);
						formObj.f_cmd.value=MULTI;
						formObj.pagerows.value="TRUE";
						var xmlStr=sheetObj.GetSaveData("ESM_BKG_0310GS.do", FormQueryString(formObj));
						sheetObj.LoadSaveData(xmlStr);
						ComOpenWait(false);
						var msgParam=sheetObj.GetCellValue(1, "flat_file");
						var msgParamBkgNo=Array();
						//alert(msgParam); // -1 값이 들어옴
						/*if(msgParam != "") {
							//alert(msgParam);
							msgParamBkgNo=msgParam.split(",");
							//alert(6666);
						} // 이 밑으로 못내려가고 undefined가 나옴*/
						//alert(7);
						if(msgParamBkgNo.length > 0 && sheetObjects[0].RowCount()== msgParamBkgNo.length) {
							alert(8);
							if(msgParam != "" ) {
								alert(9);
								ComShowMessage(ComGetMsg("BKG06128", msgParam));
								return false;
							}
						} else {
							//alert(10);
							/*if(msgParam != "" && !ComShowConfirm(ComGetMsg("BKG06127", msgParam))) {
								return false; // "There are B/L without issue date ({?msg1}). Are you sure to download B/Ls with issue date only?"
							}*/
						}
						//ComOpenWait(true);
						formObj.f_cmd.value=MULTI;
						formObj.pagerows.value="FALSE";
						var xmlStr=sheetObj.GetSaveData("ESM_BKG_0310GS.do", FormQueryString(formObj));
						//alert(xmlStr); // 텍스트파일(flatFileNm)에 이 값(xmlStr)이 담기면 됨.
						var sResult=ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
						//alert(sResult);// S 값이 들어옴
						if (sResult == "F") {
							sheetObj.LoadSaveData(xmlStr,{Sync:1});
						}
						else {
							sheetObj.LoadSaveData(xmlStr,{Sync:1});
							//var sValue = ComGetEtcData(xmlStr, "flatFile");
							//alert(xmlStr);
							//sheetObj.RemoveAll();
							//var row = sheetObj.DataInsert(-1);
							if (sheetObject1.RowCount() > 0) {
								//sheetObj.CellValue(row, "flat_file") = sValue;
								var flatFileNm=formObj.vvd.value + "_"
												+ formObj.pol_cd.value + "_" + formObj.pod_cd.value
												+ "_" + ComGetObjValue(formObj.mf_tp_cd) + "_"
												+ ComReplaceStr(ComGetNowInfo("ymd"), "-", "")
												+ "_"
												+ ComReplaceStr(ComGetNowInfo("hms"), ":", "")
												+ "_IB";
								//alert(flatFileNm); // 파일명이 변수에 의해 기입됨
								sheetObj.Down2Text({ ColDelim:"",DownCols:"1",FileName:flatFileNm,DownHeader:false});
								//sheetObj.Down2Text({ ColDelim:"",DownCols:"1",FileName:"flatFileNm",DownHeader:false});
							}
						}
						//ComOpenWait(false);
					}
				}
				break;
		}
	}


	/**
	 * move focus to next field in case of inputed MaxLength
	 * TAB and BACK TAB is block
	 */
	function obj_Click() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (srcName == "mf_tp_cd") {
			setFormatByMfTpCd(srcValue);
		}
	}


	/**
	 * retrieving when enter key press
	 * @return
	 */
	function obj_ComKeyEnter() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if(srcName != "") {
			ComKeyEnter();
		}
	}


	function setFormatByMfTpCd(mfTpCd) {
		ComEnableObject(document.form.pol_code, true);
		ComEnableObject(document.form.pod_code, true);
		switch (mfTpCd) {
		case "01I":
			if (document.form.usr_ofc_cd.value == "SRGBA") {
				document.form.pod_code.value="IDSRG";
			}
			else if (document.form.usr_ofc_cd.value == "SUBBA") {
				document.form.pod_code.value="IDSUB";
			}
			else if (document.form.usr_ofc_cd.value == "JKTBA") {
				document.form.pod_code.value="IDJKT";
			}
			else if (document.form.usr_ofc_cd.value == "BLWBA") {
				document.form.pod_code.value="IDBLW";
			}
			ComSetFocus(document.form.pol_code);
			break;
		case "02I":
			ComSetFocus(document.form.pod_code);
			break;
		case "03I":
			ComSetFocus(document.form.pod_code);
			break;
		case "08X":
			if (document.form.usr_ofc_cd.value == "SRGBA") {
				document.form.pod_code.value="IDSRG";
			}
			else if (document.form.usr_ofc_cd.value == "SUBBA") {
				document.form.pod_code.value="IDSUB";
			}
			else if (document.form.usr_ofc_cd.value == "JKTBA") {
				document.form.pod_code.value="IDJKT";
			}
			else if (document.form.usr_ofc_cd.value == "BLWBA") {
				document.form.pod_code.value="IDBLW";
			}
			break;
		}
	}


	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
	}


	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
	}
