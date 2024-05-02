/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0311.js
*@FileTitle  : Indonesia Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================**/
/****************************************************************************************
*Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						  MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
						  Other Case: COMMAND01=11; ~ COMMAND20=30;
***************************************************************************************/
/*------------------These code are for making JSDoc well ------------------*/
/**
 * @fileoverview
 * @author
 */
// public variable
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
	 /***** If sheets are more than 2 in one tab, use additional sheet variables *****/
			 var sheetObject1=sheetObjects[0];
	 /*******************************************************/
	 var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(srcName != "btn_splitPop"){
			if(layList.style.display != "none"){
				layList.style.display="none";
			}
		}
		switch(srcName) {
				case "btn_splitPop":
					doActionIBSheet(sheetObjects[0],formObject,COMMAND04);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_add":
					doActionIBSheet(sheetObjects[0],document.form,IBINSERT);
					break;
				case "btn_delete":
					doActionIBSheet(sheetObjects[0],document.form,IBDELETE);
					break;
				case "btn_save":
					doActionIBSheet(sheetObjects[0],document.form,IBSAVE);
					break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						sheetObject1.Down2Excel( {DownCols: makeHiddenSkipCol( sheetObject1), SheetDesign:1,Merge:1 });
					}
					break;
				case "btn_edi":
					doActionIBSheet(sheetObjects[1],document.form,IBSEARCH_ASYNC01);
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
	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
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
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListener('keydown', 'obj_ComKeyEnter', 'form');
		axon_event.addListenerForm("click", "obj_Click", document.form);
		setFormatByMfTpCd("09E");
		if (document.form.usr_ofc_cd.value == "SRGBA") {
			document.form.pol_code.value="IDSRG";
			document.form.pod_code.value="";
			document.form.mf_tp_cd[0].disabled=true;
		}
		else if (document.form.usr_ofc_cd.value == "SUBBA") {
			document.form.pol_code.value="IDSUB";
			document.form.pod_code.value="";
			document.form.mf_tp_cd[0].disabled=true;
		}
		else if (document.form.usr_ofc_cd.value == "JKTBA") {
			document.form.pol_code.value="IDJKT";
			document.form.pod_code.value="";
			document.form.mf_tp_cd[1].disabled=true;
		}
		else if (document.form.usr_ofc_cd.value == "BLWBA") {
			document.form.pol_code.value="IDBLW";
			document.form.pod_code.value="";
			document.form.mf_tp_cd[0].disabled=true;
		}
		ComSetFocus(document.form.vvd);
	}
	function obj_Click() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (srcName == "mf_tp_cd") {
			setFormatByMfTpCd(srcValue);
		}
	}
	/**
	 * setting sheet initial values and header
	 *
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":      //sheet1 init
				with(sheetObj){
					var HeadTitle = "|Sel.|Seq.|BKG No.|B/L No.|T/VVD|POR|POL|POD|DEL|PEB Number|PEB Date Issued|Customs Office|Qualifier|Usrl16" +
									// Hidden Columne
									"|vsl_cd|skd_voy_no|skd_dir_cd|temp_id_xpt_no|xpt_imp_seq";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

					var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",   Hidden:1, Width:0,    Align:"Center",  SaveName:"ibflag" },
								{Type:"CheckBox", Hidden:0, Width:40,   Align:"Center",  SaveName:"Chk" },
								{Type:"Seq",      Hidden:0, Width:35,   Align:"Center",  SaveName:"Seq",              Edit:0 },
								{Type:"Text",     Hidden:0, Width:100,  Align:"Center",  SaveName:"bkg_no",           Edit:1, AcceptKeys:"E|N", InputCaseSensitive:1 },
								{Type:"Text",     Hidden:0, Width:100,  Align:"Center",  SaveName:"bl_no",            Edit:0 },
								{Type:"Text",     Hidden:0, Width:70,   Align:"Center",  SaveName:"vvd",              Edit:0 },
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  SaveName:"por_cd",           Edit:0, AcceptKeys:"E|N", InputCaseSensitive:1},
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  SaveName:"pol_cd",           Edit:0, AcceptKeys:"E|N", InputCaseSensitive:1},
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  SaveName:"pod_cd",           Edit:0, AcceptKeys:"E|N", InputCaseSensitive:1},
								{Type:"Text",     Hidden:0, Width:55,   Align:"Center",  SaveName:"del_cd",           Edit:0, AcceptKeys:"E|N", InputCaseSensitive:1},
								{Type:"Text",     Hidden:0, Width:80,   Align:"Center",  SaveName:"id_xpt_no",        Edit:1, EditLen:6, AcceptKeys:"N"},
								{Type:"Text",     Hidden:0, Width:110,  Align:"Center",  SaveName:"id_xpt_no_iss_dt", Edit:1, Format:"####-##-##" },
								{Type:"Combo",    Hidden:0, Width:100,  Align:"Center",  SaveName:"id_ofc_cd",        Edit:1, ComboText:"|BANBA|JKTBA|SRGBA|SUBBA|", ComboCode:"|010700|040300|060100|070100", DefaultValue:"010700" },
								{Type:"Combo",    Hidden:0, Width:65,   Align:"Center",  SaveName:"id_decl_cd",       Edit:1, ComboText:"|PEB|PKB|", ComboCode:"|E|K", DefaultValue:"E" },
								{Type:"Text",     Hidden:0, Width:10,   Align:"Center",  SaveName:"id_xpt_imp_seq",   Edit:0 },

								{Type:"Text",     Hidden:1, Width:60,   Align:"Center",  SaveName:"vsl_cd"         },
								{Type:"Text",     Hidden:1, Width:35,   Align:"Center",  SaveName:"skd_voy_no"     },
								{Type:"Text",     Hidden:1, Width:80,   Align:"Center",  SaveName:"skd_dir_cd"     },
								{Type:"Text",     Hidden:1, Width:80,   Align:"Center",  SaveName:"temp_id_xpt_no" },
								{Type:"Text",     Hidden:1, Width:10,   Align:"Center",  SaveName:"xpt_imp_seq"    } ];

					InitColumns(cols);
					SetEditable(1);
					SetWaitImageVisible(0);
					SetSheetHeight(300);
				}
			break;

			case "sheet2": //sheet2 init
				with(sheetObj) {
					var HeadTitle1="|flat_file";

					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:0 } );

					var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);

					var cols = [{Type:"Status",   Hidden:1,   Width:0,     Align:"Center",   ColMerge:0,   SaveName:"ibflag" },
								{Type:"Text",     Hidden:0,   Width:300,   Align:"Left",     ColMerge:0,   SaveName:"flat_file" } ];
					InitColumns(cols);

					SetWaitImageVisible(0)
					SetEditable(0);
					SetSheetHeight(400);
					SetVisible(0);
				}
			break;
		}
	}

	/**
	 * keyfield Validation check and description retrieve
	 */
	function sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObj=document.form;
		if(sheetObjects[0].ColSaveName(Col) == "bkg_no"){
			formObj.f_cmd.value=SEARCH01;
			formObj.strBkgNo.value=sheetObjects[0].GetCellValue(Row, "bkg_no");
			if(formObj.strBkgNo.value != ""){
				doActionIBSheet(sheetObj, formObj, IBROWSEARCH);
			}else{
				sheetObjects[0].SetCellValue(Row, "bl_no","",0);
				sheetObjects[0].SetCellValue(Row, "vvd","",0);
				sheetObjects[0].SetCellValue(Row, "por_cd","",0);
				sheetObjects[0].SetCellValue(Row, "pol_cd","",0);
				sheetObjects[0].SetCellValue(Row, "pod_cd","",0);
				sheetObjects[0].SetCellValue(Row, "del_cd","",0);
			}
		}
	}

	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH:      //retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				initSheet(sheetObjects[0],0);
				formObj.f_cmd.value=SEARCH;
				formObj.vsl_cd.value=formObj.vvd.value.substring(0,4);
				formObj.skd_voy_no.value=formObj.vvd.value.substring(4,8);
				formObj.skd_dir_cd.value=formObj.vvd.value.substring(8);
				formObj.pol_cd.value=formObj.pol_code.value;
				formObj.pod_cd.value=formObj.pod_code.value;
				sheetObjects[0].RemoveAll();
				sXml=sheetObjects[0].GetSearchData("ESM_BKG_0311GS.do", FormQueryString(formObj)); // *****
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				}
				ComEtcDataToForm(formObj, sheetObj);
				var sheet1RowSize=sheetObjects[0].RowCount();
				for ( var i=1; i <= sheet1RowSize; i++) {
					if (formObj.usr_ofc_cd.value == "SRGBA") {
						sheetObjects[0].SetCellValue(i, "id_ofc_cd","060100",0);
						sheetObjects[0].SetCellValue(i, "id_decl_cd","K",0);
					}
					if (formObj.usr_ofc_cd.value == "SUBBA") {
						sheetObjects[0].SetCellValue(i, "id_ofc_cd","070100",0);
						sheetObjects[0].SetCellValue(i, "id_decl_cd","K",0);
					}
					if (formObj.usr_ofc_cd.value == "JKTBA") {
						sheetObjects[0].SetCellValue(i, "id_ofc_cd","040300",0);
						sheetObjects[0].SetCellValue(i, "id_decl_cd","E",0);
					}
					if (formObj.usr_ofc_cd.value == "BANBA") {
						sheetObjects[0].SetCellValue(i, "id_ofc_cd","010700",0);
						sheetObjects[0].SetCellValue(i, "id_decl_cd","K",0);
					}
					if (sheetObjects[0].GetCellValue(i, "id_xpt_no") == "") { // *****
						sheetObjects[0].SetCellValue(i, "temp_id_xpt_no","",0);
						sheetObjects[0].SetCellValue(i, "id_xpt_no","000000"); // *****
					}
					else {
						sheetObjects[0].SetCellValue(i, "temp_id_xpt_no",sheetObjects[0].GetCellValue(i, "id_xpt_no"),0); // *****
					}
					var idSeq=sheetObjects[0].GetCellValue(i-1, "id_xpt_imp_seq"); // *****
					if (sheetObjects[0].GetCellValue(i, "bl_no") == sheetObjects[0].GetCellValue(i-1, "bl_no")) { // *****
						idSeq++;
						sheetObjects[0].SetCellValue(i, "id_xpt_imp_seq",idSeq,0);
					}
					else {
						idSeq=0;
						sheetObjects[0].SetCellValue(i, "id_xpt_imp_seq","1",0);
					}
				}
			break;
			case IBROWSEARCH:   // B/L No, VVD, POL, POD, DEL retrieve
				sheetObj.SetWaitImageVisible(0);
				formObj.bkg_no.value=formObj.strBkgNo.value
				var sXml=sheetObj.GetSaveData("ESM_BKG_0311GS.do", FormQueryString(formObj)); // *****
				var state=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
				var row=sheetObj.GetSelectRow();
				if(state == "S"){
					if(formObj.f_cmd.value == SEARCH01){
						sheetObjects[0].SetCellValue(row, "bl_no",ComGetEtcData(sXml,"bl_no"),0);
						sheetObjects[0].SetCellValue(row, "vvd",ComGetEtcData(sXml,"vvd"),0);
						sheetObjects[0].SetCellValue(row, "por_cd",ComGetEtcData(sXml,"por_cd"),0);
						sheetObjects[0].SetCellValue(row, "pol_cd",ComGetEtcData(sXml,"pol_cd"),0);
						sheetObjects[0].SetCellValue(row, "pod_cd",ComGetEtcData(sXml,"pod_cd"),0);
						sheetObjects[0].SetCellValue(row, "del_cd",ComGetEtcData(sXml,"del_cd"),0);
						formObj.bkg_no.value="";
						if (formObj.usr_ofc_cd.value == "SRGBA") {
							sheetObjects[0].SetCellValue(row, "id_ofc_cd","060100",0);
							sheetObjects[0].SetCellValue(row, "id_decl_cd","K",0);
						}
						if (formObj.usr_ofc_cd.value == "SUBBA") {
							sheetObjects[0].SetCellValue(row, "id_ofc_cd","070100",0);
							sheetObjects[0].SetCellValue(row, "id_decl_cd","K",0);
						}
						if (formObj.usr_ofc_cd.value == "JKTBA") {
							sheetObjects[0].SetCellValue(row, "id_ofc_cd","040300",0);
							sheetObjects[0].SetCellValue(row, "id_decl_cd","E",0);
						}
						if (formObj.usr_ofc_cd.value == "BANBA") {
							sheetObjects[0].SetCellValue(row, "id_ofc_cd","010700",0);
							sheetObjects[0].SetCellValue(row, "id_decl_cd","K",0);
						}
						if (sheetObjects[0].GetCellValue(row, "id_xpt_no") == "") { // *****
							sheetObjects[0].SetCellValue(row, "temp_id_xpt_no","",0);
							sheetObjects[0].SetCellValue(row, "id_xpt_no","000000"); // *****
						}
						else {
							sheetObjects[0].SetCellValue(row, "temp_id_xpt_no",sheetObjects[0].GetCellValue(row, "id_xpt_no"),0); // *****
						}
					}
				}
				else{
					ComBkgErrMessage(sheetObj, sXml);
					sheetObjects[0].SetCellValue(row, "bkg_no","",0);
					sheetObjects[0].SetCellValue(row, "bl_no","",0);
					sheetObjects[0].SetCellValue(row, "vvd","",0);
					sheetObjects[0].SetCellValue(row, "por_cd","",0);
					sheetObjects[0].SetCellValue(row, "pol_cd","",0);
					sheetObjects[0].SetCellValue(row, "pod_cd","",0);
					sheetObjects[0].SetCellValue(row, "del_cd","",0);
					sheetObjects[0].SelectCell(row, "bkg_no");
					formObj.bkg_no.value="";
				}
				sheetObj.SetWaitImageVisible(1);
			break;
			case IBINSERT:      // input
				sheetObj.DataInsert(-1);
			break;
			case IBDELETE:
				ComRowHideDelete(sheetObj,"Chk");
			break;
			case IBSAVE: //save
				if (sheetObjects[0].IsDataModified()) {
					if(validateForm(sheetObj,formObj,sAction)) {
						formObj.f_cmd.value=MULTI;
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sheet1RowSize=sheetObjects[0].RowCount();
						for ( var i=1; i <= sheet1RowSize; i++) {
							if (sheetObjects[0].GetCellValue(i, "temp_id_xpt_no") == "") { // *****
								sheetObjects[0].SetCellValue(i, "ibflag","I",0);
							}
						}
						sheetObj.DoSave("ESM_BKG_0311GS.do", FormQueryString(formObj),-1,false);
						//  retrieve again

					}
				} else {
					ComShowCodeMessage("BKG00115");
					return false;
				}
			break;
			case IBSEARCH_ASYNC01: //save
				if (validateForm(sheetObj, formObj, sAction)) {
					if (sheetObj.id == "sheet2") {
						formObj.f_cmd.value=MULTI02;
						formObj.pagerows.value="TRUE";
						var xmlStr=sheetObj.GetSaveData("ESM_BKG_0311GS.do", FormQueryString(formObj)); // *****
						sheetObj.LoadSaveData(xmlStr); // *****
						//if ( sheetObj.RowCount() == 0 ) alert(" EDI is no data! "); return;
						var msgParam=sheetObj.GetCellValue(1, "flat_file"); // *****
						var msgParamBkgNo=Array();
						if(msgParam != "") {
							msgParamBkgNo=msgParam.split(",");
						}
						if(msgParamBkgNo.length > 0 && sheetObjects[0].RowCount()== msgParamBkgNo.length) {
							if(msgParam != "" ) {
								ComShowMessage(ComGetMsg("BKG06128", msgParam));
								return false;
							}
						} else {
							if(msgParam != "" && !ComShowConfirm(ComGetMsg("BKG06127", msgParam))) {
								return false;
							}
						}
						formObj.f_cmd.value=MULTI02;
						formObj.pagerows.value="FALSE";
						var xmlStr=sheetObj.GetSaveData("ESM_BKG_0311GS.do", FormQueryString(formObj)); // *****
						//xmlStr="<RESULT><TR-ALL>OK</TR-ALL><ETC-DATA><ETC KEY='TRANS_RESULT_KEY'><![CDATA[S]]></ETC><ETC KEY='Exception'><![CDATA[]]></ETC></ETC-DATA><DATA COLORDER='ibflag|flat_file|pagerows|' COLSEPARATOR='☜☞' TOTAL='26'><TR><TD><![CDATA[☜☞CNT010002OJHU1000472              20F  HC395017       ☜☞]]></TD></TR></DATA></RESULT>";
						var sResult=ComGetEtcData(xmlStr, "TRANS_RESULT_KEY");
						if (sResult == "F") {
							sheetObj.LoadSearchData(xmlStr); // *****
						}
						else {
							sheetObj.LoadSearchData(xmlStr, {Sync:1}); // *****
							//sheetObj.RemoveAll();
							//var row = sheetObj.DataInsert(-1);
							if (sheetObj.RowCount()> 0) {
								//sheetObj.CellValue2(row, "flat_file") = sValue;
								var flatFileNm=formObj.vvd.value + "_"
									+ formObj.pol_cd.value + "_" + formObj.pod_cd.value
									+ "_" + ComGetObjValue(formObj.mf_tp_cd) + "_"
									+ ComReplaceStr(ComGetNowInfo("ymd"), "-", "")
									+ "_"
									+ ComReplaceStr(ComGetNowInfo("hms"), ":", "")
									+ "_OB";
//									var flatFileNm = formObj.vvd.value + ComGetObjValue(formObj.mf_tp_cd);

								sheet2.Down2Text({ DownCols:1, FileName:flatFileNm, DownHeader:false});
							}else{
								ComShowCodeMessage("COM130401");
								return;
							}
						}
					}
				}
			break;
			case COMMAND04:      //booking split noretrieve
				if(validateForm(sheetObj,formObj,sAction)) {
					formObj.f_cmd.value=COMMAND03;
					var rXml=sheetObj.GetSearchData("ESM_BKG_0079_01GS.do", FormQueryString(formObj));
					var bkg_split_no_list=ComGetEtcData(rXml, "bkg_split_no_list");
					if(bkg_split_no_list.indexOf("<option") < 0){return false;}
					layList.innerHTML=bkg_split_no_list;
					if(layList.style.display == "none"){
						var obj=formObj.bkg_no;
						var top=document.body.clientTop+obj.offsetParent.offsetTop+obj.offsetTop+obj.offsetParent.offsetHeight + 37;
						var left=document.body.clientLeft+obj.offsetParent.offsetLeft+obj.offsetLeft + 10;
						layList.style.top=top;
						layList.style.left=left;
						layList.style.display="inline";
					}
					var obj=document.getElementsByName("bkg_split_no_list");
					obj[0].style.height = "35";
				}else{
					return false;
				}
			break;
		}
	}

	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction) {
		switch (sAction) {
			case IBSEARCH: // retrieve
				if (formObj.vvd.value == "" ) {
					ComShowCodeMessage('BKG00213');
					formObj.vvd.focus();
					return false;
				}
				if (formObj.vvd.value.length > 0 && formObj.vvd.value.length < 9) {
					ComShowCodeMessage('BKG00213');
					formObj.vvd.focus();
					return false;
				}
				return true;
			break;
			case IBSAVE: // save
				return true;
			break;
			case IBSEARCH_ASYNC01:
				return true;
			break;
			case COMMAND04:
				return true;
			break;
		}
	}

	/**
	 * If MaxLength is filled in field,
	 * nex field Focus on
	 **/
	function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (ComChkLen(srcValue, srcMaxLength) == "2") ComSetNextFocus();
	}

	/**
	 * In case of enter, retrieve
	 * @return
	 */
	function obj_ComKeyEnter() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		if(srcName != "") ComKeyEnter();
	}

	function bkgSplitNoList(split_list){
		document.form.bkg_no.value=split_list.options[split_list.selectedIndex].value;
		layList.style.display="none";
	}

	function setFormatByMfTpCd(mfTpCd) {
		ComEnableObject(document.form.pol_code, true);
		ComEnableObject(document.form.pod_code, true);
		switch (mfTpCd) {
			case "09E":
				if (document.form.usr_ofc_cd.value == "SRGBA") {
					document.form.pol_code.value="";
					document.form.pod_code.value="IDSRG";
				}
				else if (document.form.usr_ofc_cd.value == "SUBBA") {
					document.form.pol_code.value="";
					document.form.pod_code.value="IDSUB";
				}
				else if (document.form.usr_ofc_cd.value == "JKTBA") {
					document.form.pol_code.value="";
					document.form.pod_code.value="IDJKT";
				}
				else if (document.form.usr_ofc_cd.value == "BLWBA") {
					document.form.pol_code.value="";
					document.form.pod_code.value="IDBLW";
				}
			break;
			case "10E":
				document.form.pod_code.value="";
				ComSetFocus(document.form.pod_code);
			break;
			case "04E":
				document.form.pol_code.value="";
				document.form.pod_code.value="";
				ComSetFocus(document.form.pod_code);
			break;
			case "05E":
				document.form.pod_code.value="";
				ComSetFocus(document.form.pod_code);
			break;
			case "08X":
				if (document.form.usr_ofc_cd.value == "SRGBA") {
					document.form.pod_code.value="IDSRG";
					document.form.pol_code.value="";
				}
				else if (document.form.usr_ofc_cd.value == "SUBBA") {
					document.form.pod_code.value="IDSUB";
					document.form.pol_code.value="";
				}
				else if (document.form.usr_ofc_cd.value == "JKTBA") {
					document.form.pod_code.value="IDJKT";
					document.form.pol_code.value="";
				}
				else if (document.form.usr_ofc_cd.value == "BLWBA") {
					document.form.pod_code.value="IDBLW";
					document.form.pol_code.value="";
				}
			break;
		}
	}

	function sheet1_OnSaveEnd() {
		doActionIBSheet(sheet1, document.form, IBSEARCH);
		ComOpenWait(false);
	}

	function sheet2_OnSaveEnd() {
		ComOpenWait(false);
	}

	function sheet1_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
	}

	function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		ComOpenWait(false);
	}
