/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2052.js
*@FileTitle  : RFA Guideline Creation - Location Group [Load Excel]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
               MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
               OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
//Common Global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var errFlg=false;
//Event handler processing by button click event */
document.onclick=processButtonClick;
/**
* Event handler processing by button name <br>
* <br>
* <b>Example :</b>
* 
* <pre>
* processButtonClick();
* </pre>
* 
* @return N/A
* @author 
* @version 2009.07.30
*/
function processButtonClick() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		
		switch (srcName) {
		case "btn_save":
			if (validateForm(sheetObject1, formObject, IBSAVE)) {
				doActionIBSheet(sheetObject1, formObject, IBSAVE);
			}
			break;
		case "btn_check":
			if (validateForm(sheetObject1, formObject, IBSEARCH)) {
				doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			}
			break;
		case "btn_close":
			ComClosePopup(); 
			break;
		case "btn_file":
			sheetObjects[0].LoadExcel({ Mode:"HeaderMatch",WorkSheetNo:"1",WorkSheetName:"",Append:false});
			//sheetObjects[0].RenderSheet(1);
			//sheetObjects[0].LoadExcel(-1);
			break;
		case "btn_Template":
		    downform.submit();
		    break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
* registering IBSheet Object as list <br>
* adding process for list in case of needing batch processing with other items  <br>
* defining list on the top of source <br>
* <br><b>Example :</b>
* <pre>
*     setSheetObject(sheetObj);
* </pre>
* @param {ibsheet} sheet_obj Mandatory IBSheet Object
* @return N/A
* @author 
* @version 2009.05.20
*/
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* initializing sheet <br>
* implementing onLoad event handler in body tag <br>
* adding first-served functions after loading screen. <br>
* <br><b>Example :</b>
* <pre>
*     loadPage();
* </pre>
* @return N/A
* @author 
* @version 2009.05.17
*/
function loadPage() {
	
	if (!opener) opener = window.dialogArguments;
	if (!opener) opener = window.opener;
	if (!opener) opener = parent;
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	buttonControl("INIT");
}
/**
* setting sheet initial values and header <br>
* adding case as numbers of counting sheets <br>
* <br><b>Example :</b>
* <pre>
*     initSheet(sheetObj,1);
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {int} sheetNo Mandatory IBSheet Object Tag's ID Serial No
* @return N/A
* @author 
* @version 2009.05.17
*/
function initSheet(sheetObj, sheetNo) {
	var formOrg=document.form;
	var cnt=0;
	switch (sheetNo) {
		case 1:      // sheet1 init
		    with(sheetObj){
			
			      var HeadTitle="|Seq.|Ori/Dst|Group Code|Description|Location Code|Description|Subcontinent";
			      HeadTitle += "|1|2|3|4";
			      var headCount=ComCountHeadTitle(HeadTitle);

			      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			      var headers = [ { Text:HeadTitle, Align:"Center"} ];
			      InitHeaders(headers, info);

			      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Combo",     Hidden:0, Width:70,   Align:"Left",    ColMerge:0,   SaveName:"org_dest_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
			             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:200 },
			             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 },
			             {Type:"Text",      Hidden:0,  Width:160,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:30 },
			             {Type:"Text",      Hidden:0,  Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sconti_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_loc_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_loc_dtl_seq" } ];
			       
			      InitColumns(cols);
			      SetSheetHeight(320);
			      SetEditable(1);
			      SetWaitImageVisible(0);
			      SetColProperty(0 ,"prc_grp_loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});
			      SetColProperty(0 ,"loc_cd" , {AcceptKeys:"E|[0123456789]" , InputCaseSensitive:1});		
			      SetColProperty("org_dest_tp_cd", {ComboText:orgDestTpCdComboText, ComboCode:orgDestTpCdComboValue} );
			      SetShowButtonImage(2);
			      }
	    break;
		case 2: //column validation - for retrieving DB
			with(sheetObj){
			var HeadTitle="|Seq.|Ori/Dst|Group Code|Description|Location Code|Description|Subcontinent";
			HeadTitle += "|1|2|3|4";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd" },
			             {Type:"Text",      Hidden:1, Width:155,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc" },
			             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"loc_cd" },
			             {Type:"Text",      Hidden:1, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"loc_nm" },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Left",    ColMerge:0,   SaveName:"sconti_nm" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_loc_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_loc_dtl_seq" } ];
       
			InitColumns(cols);
			SetSheetHeight(320);
			SetEditable(0);
			SetWaitImageVisible(0);
            }


	    break;
	case 3: //column validation- for EXCEL DOWNLOAD
	    with(sheetObj){
    
			var HeadTitle="|Seq.|Ori/Dst|Group Code|Description";
			HeadTitle += "|1|2|3";
			var headCount=ComCountHeadTitle(HeadTitle);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
			             {Type:"Text",      Hidden:1, Width:35,   Align:"Center",  ColMerge:0,   SaveName:"org_dest_tp_cd" },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"prc_grp_loc_cd" },
			             {Type:"Text",      Hidden:1, Width:155,  Align:"Left",    ColMerge:0,   SaveName:"prc_grp_loc_desc" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"svc_scp_cd" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"gline_seq" },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"grp_loc_seq" } ];
       
			InitColumns(cols);
			SetSheetHeight(320);
			SetEditable(0);
			SetWaitImageVisible(0);
            }


    	break;
	}
}
function sheet2_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) { 
	//Red color in case of error data
	checkValidationAllData(sheetObj);
}

/**
* Handling Sheet's process <br>
* <br><b>Example :</b>
* <pre>
*     doActionIBSheet(sheetObj, document.form, IBSEARCH)
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {form} formObj Mandatory html form object
* @param {int} sAction Mandatory ,process constant variable
* @return N/A
* @author 
* @version 2009.05.17
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	try {
		sheetObj.ShowDebugMsg(false);
		switch (sAction) {
			case IBSEARCH:
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI02;
				var sParam=FormQueryString(formObj);
				var sParamSheet1=sheetObj.GetSaveString();
				sParam += "&" + sParamSheet1;
				var sXml=sheetObj.GetSearchData("ESM_PRI_2052GS.do", sParam);
				sheetObjects[1].LoadSearchData(sXml,{Sync:1} );				
				break;
			case IBSAVE:
				if(errFlg) {
					buttonControl("FAIL");
					return false;
				}
				if (!validateForm(sheetObj,document.form,sAction)) {
					return false;
				}
				if((ComShowCodeConfirm("PRI00001")) ) {
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI01;
					var sParam=FormQueryString(formObj);
					//////////////////////////////////////
					//Setting MASTER SEQ
					setGroupCodeSeq(sheetObj, formObj, sAction);
					//////////////////////////////////////
					//1)DETAIL - Setting param
					//2)afterward remove master's dupliation and then setting param
					var sParamSheet2=sheetObj.GetSaveString();
					if (sParamSheet2 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet2, "sheet2_");
					}			
					//////////////////////////////////////
					//MASTER :deleting duplicated data and saving
					var dupRows = sheetObj.ColValueDupRows("prc_grp_loc_cd|svc_scp_cd|gline_seq", false);			
					var arrRow=dupRows.split(",");
					for(var i=0; arrRow != "" && i<arrRow.length; i++) {
						sheetObj.SetRowStatus(arrRow[i],"R");
					}	
					//////////////////////////////////////
					//MASTER - deleting duplicated data and saving
					for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
						if(sheetObj.GetRowStatus(i) != "R") {
							for(var j = sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount() > 0 && j <= sheetObjects[2].LastRow(); j++) {
								if(sheetObj.GetCellValue(i, "prc_grp_loc_cd") == sheetObjects[2].GetCellValue(j, "prc_grp_loc_cd")) {
									sheetObj.SetRowStatus(i,"R");
								}
							}
						}
					}
					var sParamSheet1=sheetObj.GetSaveString();
					if (sParamSheet1 != "") {
						sParam += "&" + ComPriSetPrifix(sParamSheet1, "sheet1_");
					}
 					var sXml=sheetObj.GetSaveData("ESM_PRI_2052GS.do", sParam);
 					sheetObj.LoadSaveData(sXml);
				}
				break;
		}
	}catch(e){
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}finally {
		 ComOpenWait(false);
	}
}
/**
* handling process for input validation <br>
* <br><b>Example :</b>
* <pre>
*     if (validateForm(sheetObj,document.form,IBSAVE)) {
*     }
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {form} formObj Mandatory html form object
* @param {int} sAction Mandatory ,process constant variable
* @returns bool <br>
*          true  : Valid<br>
*          false : Invalid
* @author 
* @version 2009.04.17
*/
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if (!sheetObjects[0].IsDataModified()) {
			ComShowCodeMessage("PRI00312");
			return false;
		}
		break;
	case IBSAVE:
		if(ComGetBtnDisable("btn_save")) return false;
		if (sheetObjects[0].IsDataModified()) {
			sheetObjects[1].RemoveAll();
			//Loading sheet's information to hidden sheet
			var sXml=ComPriSheet2Xml(sheetObjects[0])
			sheetObjects[1].LoadSearchData(sXml,{Sync:1} );
			//Loading sheet's information to hidden sheet
			formObj.f_cmd.value=SEARCH03;
 			sXml=sheetObj.GetSearchData("ESM_PRI_2001_01GS.do", FormQueryString(formObj));
			sheetObjects[1].LoadSearchData(sXml,{Append:1 , Sync:1} );
			////////////////////////////////////////////////////
			//Loading existing data of master  , for excluding duplicated data
			formObj.f_cmd.value=SEARCH01;
 			sXml=sheetObj.GetSearchData("ESM_PRI_2001_01GS.do", FormQueryString(formObj));
			sheetObjects[2].LoadSearchData(sXml,{Sync:1} );
			var rowM = sheetObjects[1].ColValueDupRows("prc_grp_loc_cd|loc_cd", false, true);			
			if (rowM != "") {
				var rowDup=rowM.split("|");
				ComShowCodeMessage("PRI00303", "Sheet", rowDup[0]);
				sheetObj.SetEditable(1);
				buttonControl("FAIL");
				return false;
			}
		}
		break;
	}
	return true;
}
/**
* Calling function in case of Onchange Event <br>
* Showing description when selecting Multi ComboBox <br>
* <br><b>Example :</b>
* <pre>
*
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {int} Row Mandatory Onclick ,Cell's Row Index
* @param {int} Col Mandatory Onclick ,Cell's Column Index
* @param {string} Value Mandatory ,Cell's Value
* @return N/A
* @author 
* @version 2009.04.17
*/
function sheet1_OnChange(sheetObj, Row, Col, Value) {
	var colname=sheetObj.ColSaveName(Col);
	var formObj=document.form
	switch (colname) {
	case "prc_grp_loc_cd":
		if (Value.length != 4) {
			sheetObj.SetCellValue(Row, "prc_grp_loc_cd","",0);
			sheetObj.SelectCell(Row, "prc_grp_loc_cd");
		}
		break;
	case "loc_cd":		
		if (Value.length == 5) {
			formObj.f_cmd.value=COMMAND31;
			formObj.cd.value=Value;
			var sParam=FormQueryString(formObj);
			sParam += "&etc1="+sheetObj.GetCellValue(sheetObj.GetSelectRow(), "org_dest_tp_cd");
 			var sXml=sheetObj.GetSearchData("PRICommonGS.do", sParam);
			var arrData=ComPriXml2Array(sXml, "cd|nm|etc1|etc2");
			if (arrData != null && arrData.length > 0) {
				sheetObj.SetCellValue(Row, "loc_nm",arrData[0][1],0);
				sheetObj.SetCellValue(Row, "sconti_cd",arrData[0][2],0);
				sheetObj.SetCellValue(Row, "sconti_nm",arrData[0][3],0);
			} else {
				sheetObj.SetCellValue(Row, "loc_nm","",0);
				sheetObj.SetCellValue(Row, "loc_cd","",0);
				sheetObj.SetCellValue(Row, "sconti_cd","",0);
				sheetObj.SetCellValue(Row, "sconti_nm","",0);
				sheetObj.SelectCell(Row, "loc_cd");
			}
		} else {
			sheetObj.SetCellValue(Row, "loc_nm","",0);
			sheetObj.SetCellValue(Row, "loc_cd","",0);
			sheetObj.SetCellValue(Row, "sconti_cd","",0);
			sheetObj.SetCellValue(Row, "sconti_nm","",0);
			sheetObj.SelectCell(Row, "loc_cd");
		}
		break;
	}
}
/**
* Calling function in case of OnSaveEnd Event <br>
* Displaying Save confirmation message in case of sucessful saving <br>
* <br><b>Example :</b>
* <pre>
* 
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {string} ErrMsg Mandatory from server
* @return N/A
* @author 
* @version 2009.05.17
*/
function sheet1_OnSaveEnd(sheetObj, ErrMsg) {
	var psheetObj=opener.sheetObjects[0];
	var pformObj=opener.document.form;
	opener.parent.setTabStyle();
	opener.doActionIBSheet(psheetObj, pformObj, IBSEARCH);
	ComClosePopup(); 
}
/**
* Calling event in case of LoadExcel event <br>
* <br><b>Example :</b>
* <pre>
* 
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @return N/A
* @author 
* @version 2009.06.25
*/
function sheet1_OnLoadExcel(sheetObj, result, code, msg) {
    if(isExceedMaxRow(msg))return;
	var formObj=document.form;
	if (sheetObj.RowCount() > 0) {
		for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
			sheetObj.SetCellValue(i, "svc_scp_cd",formObj.svc_scp_cd.value,0);
			sheetObj.SetCellValue(i, "gline_seq",formObj.gline_seq.value,0);
		}
	}
	buttonControl("LOAD");
}
/**
* Setting sheet BG color to red in case of error data<br>
* <br><b>Example :</b>
* <pre>
* 
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @return N/A
* @author 
* @version 2009.05.20
*/
function checkValidationAllData(sheetObj) {
		var check=0;
		// setting error row
		var color="#FF0000"; // red
		//default color : gray
		for ( var i=sheetObjects[0].HeaderRows(); i <= sheetObjects[0].LastRow(); i++) {
			sheetObjects[0].SetRowBackColor(i,0);
		}
		//validation on screen
		check += validateSheetData(sheetObjects[0], color);
		// validation in DB
		check += checkDBCodeExist(sheetObj, color);
		if (check > 0) {
			errFlg=true;
			buttonControl("FAIL");
		} else {
			errFlg=false;
			//setting all cells to readonly
			sheetObjects[0].SetEditable(0);
			buttonControl("SUCCEED");
		}
}
/**
 * OnKeyUp  Event function of sheet1 <br>
 * <br><b>Example :</b>
 * <pre>
 * 
 * </pre>
 * @param {ibsheet} sheetObj Mandatory IBSheet Object
 * @param {Long} Row Mandatory
 * @param {Long} Col Mandatory 
 * @param {Integer} KeyCode Mandatory 
 * @param {Integer} Shift Mandatory Shift: 1, Ctrl: 2, other : 0
 * @return N/A
 * @author 
 * @version 2009.05.20
 */ 
 function sheet1_OnKeyUp(sheetObj, Row, Col, KeyCode, Shift) {
     if (errFlg && KeyCode == 9) {
         while (true) {
             if (Col > sheetObj.LastCol()) {
                 Row++;
                 Col=1;
             }
             if (Row > sheetObj.LastRow()) {
                 Row=sheetObj.HeaderRows();
             }
             if (sheetObj.GetCellBackColor(Row, Col) == "#FF0000") {
                 sheetObj.SelectCell(Row, Col, false);
                 break;
             }
             Col++;
         }
     }
 }
/**
* function to validate screen<br>
* in case of validated case, return check value<br>
* <br><b>Example :</b>
* <pre>
* 
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {object} color Mandatory IBSheet RgbColor
* @return check
* @author 
* @version 2009.06.25
*/
function validateSheetData(sheetObj, color) {
	var check=0;
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		if (sheetObj.GetCellValue(i, "org_dest_tp_cd") == "") {
			sheetObj.SetCellBackColor(i, "org_dest_tp_cd", color);
			check++;
		}
		if (sheetObj.GetCellValue(i, "prc_grp_loc_cd").length != 4) {
			sheetObj.SetCellBackColor(i, "prc_grp_loc_cd", color);
			check++;
		}
		if (sheetObj.GetCellValue(i, "prc_grp_loc_desc") == "") {
			sheetObj.SetCellBackColor(i, "prc_grp_loc_desc", color);
			check++;
		}
		if (sheetObj.GetCellValue(i, "loc_cd").length != 5) {
			sheetObj.SetCellBackColor(i, "loc_cd", color);
			check++;
		}
	}
	return check;
}
/**
* Checking validation of excel data by DB retrieving<br>
* Coloring in case of wrong data<br>
* <br><b>Example :</b>
* <pre>
* 		checkDBCodeExist(sheetObj, formObj);
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {object} color Mandatory IBSheet RgbColor
* @return check
* @author 
* @version 2009.05.17
*/
function checkDBCodeExist(sheetObj, color) {
	var check=0;
	var seq=0;
	for ( var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		seq=sheetObjects[0].GetCellValue(i, "seq");
		if (sheetObj.GetCellValue(i, "loc_cd") == "0") {
			sheetObjects[0].SetCellBackColor(seq, "loc_cd", color);
			check++;
		}
	}
	return check;
}
/**
* Setting GROUP LOCATION SEQ <br>
* <br><b>Example :</b>
* <pre>
*     
* </pre>
* @param {ibsheet} sheetObj Mandatory IBSheet Object
* @param {form} formObj Mandatory html form object
* @param {int} sAction Mandatory ,process constant variable
* @returns bool <br>
*          true  : Valid<br>
*          false : Invalid
* @author 
* @version 2009.04.17
*/
function setGroupCodeSeq(sheetObj, formObj, sAction) {
	//Getting MAX SEQ
	var maxSeq=parseInt(ComPriGetMax(sheetObjects[1], "grp_loc_seq"));
	for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow(); i++) {
		//////////////////////////////////////
		//1.Setting existing SEQ in case group code exists in group code
		for(var k = sheetObjects[2].HeaderRows(); sheetObjects[2].RowCount() > 0 && k <= sheetObjects[2].LastRow(); k++) {
			if(sheetObj.GetCellValue(i, "prc_grp_loc_cd") == sheetObjects[2].GetCellValue(k, "prc_grp_loc_cd")) {
				sheetObj.SetCellValue(i, "grp_loc_seq",sheetObjects[2].GetCellValue(k, "grp_loc_seq"),0);
			}
		}
		///////////////////////////////////////
		//2.Setting MAX SEQ adding 1 into empty cell for current sequence
		if(sheetObj.GetCellValue(i, "grp_loc_seq") == ""){
			sheetObj.SetCellValue(i, "grp_loc_seq",maxSeq++,0);
			////////////////////////////////////////////
			//3.Setting same max seq in case of duplicated group code
			for(var j=sheetObj.HeaderRows(); j <= sheetObj.LastRow(); j++) {
				if(sheetObj.GetCellValue(i, "prc_grp_loc_cd") == sheetObj.GetCellValue(j, "prc_grp_loc_cd")) {
					sheetObj.SetCellValue(j, "grp_loc_seq",maxSeq,0);
				}
			}
		}
	}
}
/**
* Controlling authority of button<br>
* <br><b>Example :</b>
* <pre>
* buttonControl()
* </pre>
* @param N/A
* @return N/A
* @author 
* @version 2009.07.31
*/
function buttonControl(valChck){
	var formObj=document.form;
	var rowCount = sheetObjects[0].RowCount();
	try{
		ComBtnDisable("btn_file");
		ComBtnDisable("btn_check");
		ComBtnDisable("btn_save");
		ComBtnEnable("btn_close");
		switch(valChck) {
			case "SUCCEED":
				ComBtnEnable("btn_save");
				break;
			case "FAIL":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "LOAD":
				ComBtnEnable("btn_file");
				ComBtnEnable("btn_check");
				ComBtnDisable("btn_save");
				break;
			case "INIT":
				ComBtnEnable("btn_file");
				ComBtnDisable("btn_check");
				ComBtnDisable("btn_save");
				break;
		}	
	} catch (e) {}
}