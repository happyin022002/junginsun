﻿/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0229_08.jsp
 *@FileTitle : e-Booking & SI Process Detail(DANGER)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
// Common global variable
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var comboNmArr;
var comboVlArr;
var iterator="|$$|";
var isCopy="false";
var dgPosition=0;
var cntrTpsz_cd="";
var cntrTpsz_id="";
var prefix="t8sheet1_"
var max_dcgo_seq=0;
var add_cntr_cnt = 0; //jsy, 신규 cntr 추가시 1씩 증가					//2015.01.15. kimtagkyun.
var max_dcgo_seq_cnt = 0; //jsy , dcgo_seq의 갯수 (sheet의 갯수)		//2015.01.15. kimtagkyun.

var div1sheet1 = null;												//2015.01.15. kimtagkyun.
var div2sheet1 = null;												//2015.01.15. kimtagkyun.
var sheetObject1 = null;											//2015.01.15. kimtagkyun.

var BKG_DIV_NAME = "_Bkg_div1_";									//2015.01.15. kimtagkyun.
var BKG_FRAME_NAME = "_Bkg_iframe1_";								//2015.01.15. kimtagkyun.
var BKG_DIV_NAME2 = "_Bkg_div2_";									//2015.01.15. kimtagkyun.
var BKG_FRAME_NAME2 = "_Bkg_iframe2_";								//2015.01.15. kimtagkyun.

var iframeW = 190;													//2015.01.15. kimtagkyun.
var iframeH = 100;													//2015.01.15. kimtagkyun.

// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetIdx = 0;
	div1sheet1 			= sheetObjects[sheetIdx++];
	div2sheet1 			= sheetObjects[sheetIdx++];
	var sheetObject = sheetObjects[sheetIdx++];
	/** **************************************************** */
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
			case IBCLEAR:
				doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);		//2015.01.15. kimtagkyun.
				break;
			case "btn_cancelcopydata":
				parent.document.form.dangerTabCancel.value="Y";
				doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);		//2015.01.15. kimtagkyun.
				isCopy="false";
				top.isCopyAllRequested=false;
				break;
			case "btn_datacopytoopus":
				dataCopy();
				break;
			case "btn_upload":
				doActionIBSheet(sheetObjects[2], document.form, IBSAVE);		//2015.01.15. kimtagkyun.
				break;
			case "restrictions_btn":
					if(document.getElementById("bkg_no").value != ""){
						var imdg_un_no=document.getElementById("imdg_un_no").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no");
						var imdg_un_no_seq=document.getElementById("imdg_un_no_seq").value;//sheetObjects[1].GetCellValue(sheetObjects[1].GetSelectRow(), "imdg_un_no_seq");
						var pol_cd=document.getElementById("pol_cd").value;
						var pod_cd=document.getElementById("pod_cd").value;	 								
						ComOpenWindowCenter("VOP_SCG_0021.do?imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&slan_cd=", "VOP_SCG_0021", 1200, 660, true);
					}
				break;
			case "pre_checking_reports_btn":
				if(document.getElementById("bkg_no").value != ""){	 								
					ComOpenPopup("VOP_SCG_0069.do", 940, 950, "VOP_SCG_0069", "0,0,1,1,1,1,1", true);
				} 								 
			break;
			case "btn_dgRider":													//2015.01.15. kimtagkyun.
				doSaveCopy();
				// dg rider cgo seq 생성
				createDgRiderCntrHtml();
				showDgRider();
				break;		

			case "btn_dgRider2":												//2015.01.15. kimtagkyun.
				showDgRider2();
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
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (var i=0; i < sheetObjects.length; i++) {
		//khlee- Preferences change the name of the function to start
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		// khlee- The final configuration functions added
		ComEndConfigSheet(sheetObjects[i]);
	}
	var sheetIdx = 0;														//2015.01.15. kimtagkyun.
    div1sheet1 			= sheetObjects[sheetIdx++];							//2015.01.15. kimtagkyun.
    div2sheet1 			= sheetObjects[sheetIdx++];							//2015.01.15. kimtagkyun.
    sheetObject1 		= sheetObjects[sheetIdx++];							//2015.01.15. kimtagkyun.
    // DIV 초기화
    divLayer_Config();														//2015.01.15. kimtagkyun.
	doActionIBSheet(sheetObjects[2], document.form, IBCLEAR);				//2015.01.15. kimtagkyun.
	initControl();
}
function initControl() {
 	var formObject=document.form;
 	// Axon Event Processing 1. Events catch (developers change)
// 	axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject);
	axon_event.addListenerForm("change", "form_onChange", formObject);
	ComFormControlAxon();
	applyShortcut();
}
/**
* The initial setting combo
* 
* @param {IBMultiCombo}
*            comboObj comboObj
*/
function initCombo(comboObj) {
	comboObj.SetMultiSelect(0);
//no support[check again]CLT 	comboObj.UseCode=true;
//no support[check again]CLT 	comboObj.LineColor="#ffffff";
	comboObj.SetColAlign(0, "left");
	comboObj.SetColAlign(1, "left");
	comboObj.SetMultiSeparator("|");
}
/**
* registering IBCombo Object as list
* 
* @param {IBMultiCombo}
*            combo_obj IBMultiCombo Object
*/
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
 /**
  * registering IBSheet Object as list
  * adding process for list in case of needing batch processing with other items 
  * defining list on the top of source
  */
function setSheetObject(sheet_obj) {
 	sheetObjects[sheetCnt++]=sheet_obj;
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
	case "sheet1":
		with (sheetObj) {
			var HeadTitle1="|bkg_no|dcgo_seq|dg_cntr_seq|cntr_cgo_seq|cntr_no||max_dg_cntr_seq|max_cntr_cgo_seq|imdg_un_no|imdg_un_no_seq|imdg_segr_grp_no";
	
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);
	
			var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Left",    ColMerge:0,   SaveName:"ibflag" },
			             {Type:"Text",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"bkg_no" },
			             {Type:"Text",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"dcgo_seq" },
			             {Type:"Text",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"dg_cntr_seq" },
			             {Type:"Text",     Hidden:0,  Width:100,   Align:"Left",    ColMerge:1,   SaveName:"cntr_cgo_seq" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cntr_no" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"cntr_tpsz_cd" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"max_dg_cntr_seq" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"max_cntr_cgo_seq" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_un_no" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_un_no_seq" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_clss_cd" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_lmt_qty_flg" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"grs_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3 },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"net_wgt",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:3 },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"wgt_ut_cd" },
			             {Type:"Float",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"flsh_pnt_cdo_temp",    KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2 },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"prp_shp_nm" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"hzd_desc" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_pck_grp_cd" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"mrn_polut_flg" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"emer_cntc_phn_no_ctnt" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"emer_cntc_pnt_ctnt" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"dcgo_sts_cd" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"spcl_stwg_rqst_desc" },
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_comp_grp_cd" } ,
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_amdt_no" } ,
			             {Type:"Text",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"imdg_segr_grp_no" } 
			             
			             ];
			InitColumns(cols);
			SetSheetHeight(150);
			//SetVisible(true);
			SetEditable(1);
		}
		break;

	case "div1sheet1": //sheet1 init																							//2015.01.15. kimtagkyun.
		with (sheetObj) {
			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";
		
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",    Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox",  Hidden:1, Width:40,  Align:"Center",    ColMerge:1,   SaveName:"del_chk"},
			             {Type:"Text",      Hidden:0, Width:150, Align:"Left",      ColMerge:0,   SaveName:"file_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",      Hidden:0, Width:60,  Align:"Center",    ColMerge:0,   SaveName:"file_size",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0, Width:150, Align:"Center",    ColMerge:0,   SaveName:"cargo_contain",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",     Hidden:0, Width:5,   Align:"Center",    ColMerge:1,   SaveName:"multiPopup",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"file_path"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"ridr_tp_cd"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"file_sav_id"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"img_seq"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"cargo_cnt"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"dcgo_seq"} ];

			InitColumns(cols);
			SetVisible(false);
			SetSheetWidth(mainTable.clientWidth);
			SetSheetHeight(150);
			SetSheetWidth(450);
			SetImageList(0, "img/opus/button/btns_multisearch.gif");
			SetImageList(1, "img/opus/button/btng_minus.gif");
			SetCountPosition(0);
			SetFocusEditMode(0);
		}
		break;
	case "div2sheet1": //sheet1 init																							//2015.01.15. kimtagkyun.
		with (sheetObj) {

			var HeadTitle = "|Sel.|File Name|File Size|Container No. / CGO Seq|Container No. / CGO Seq||||||";
			
			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
			
			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);
			
			var cols = [ {Type:"Status",   Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"ibflag" },
			             {Type:"CheckBox", Hidden:1, Width:40,  Align:"Center",    ColMerge:1,   SaveName:"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:0, Width:150, Align:"Left",      ColMerge:0,   SaveName:"file_nm",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",     Hidden:0, Width:60,  Align:"Center",    ColMerge:0,   SaveName:"file_size",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",     Hidden:0, Width:150, Align:"Center",    ColMerge:0,   SaveName:"cargo_contain",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Image",    Hidden:0, Width:5,   Align:"Center",    ColMerge:1,   SaveName:"multiPopup",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"file_path"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"ridr_tp_cd"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"file_sav_id"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"img_seq"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"cargo_cnt"},
			             {Type:"Text",     Hidden:1, Width:0,   Align:"Center",    ColMerge:1,   SaveName:"dcgo_seq"} ];

			InitColumns(cols);
			SetVisible(false);
			SetSheetWidth(mainTable.clientWidth);
			SetSheetHeight(150);
			SetSheetWidth(450);
			SetImageList(0, "img/opus/button/btns_multisearch.gif");
			SetImageList(1, "img/opus/button/btng_minus.gif");
			SetCountPosition(0);
			SetFocusEditMode(0);
		

		}
		break;
	}
}

// Sheet handling process
function doActionIBSheet(sheetObj, formObj, sAction) {
//	sheetObj.ShowDebugMsg = 1;
	switch (sAction) {
	case IBCLEAR: //Retrieve
		if (formObj.bkg_no2.value != null && formObj.bkg_no2.value != '') {
			var formObj2=document.form2;
			for ( var i=0; i < formObj.elements.length; i++) {
				if (formObj.elements[i].name.indexOf("flsh_pnt_cdo_temp") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value=makeComma(formObj.elements[i].value, '2');// ComAddComma3(formObj.elements[i].value, "#,###.00");
				}
				if (formObj.elements[i].name.indexOf("grs_wgt") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value=makeComma(formObj.elements[i].value , '3');// ComAddComma3(formObj.elements[i].value, "#,###.000");
				}
				if (formObj.elements[i].name.indexOf("net_wgt") == 0) {
					if (formObj.elements[i].value != '')
						formObj.elements[i].value=makeComma(formObj.elements[i].value, '3');// ComAddComma3(formObj.elements[i].value, "#,###.000");
				}
			}
			for ( var j=0; j < formObj2.elements.length; j++) {
				if (formObj2.elements[j].name.indexOf("flsh_pnt_cdo_temp") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value=makeComma(formObj2.elements[j].value ,'2');// ComAddComma3(formObj2.elements[j].value, "#,###.00");
				}
				if (formObj2.elements[j].name.indexOf("grs_wgt") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value=makeComma(formObj2.elements[j].value, '3');// ComAddComma3(formObj2.elements[j].value, "#,###.000");
				}
				if (formObj2.elements[j].name.indexOf("net_wgt") == 0) {
					if (formObj2.elements[j].value != '')
						formObj2.elements[j].value=makeComma(formObj2.elements[j].value, '3');// ComAddComma3(formObj2.elements[j].value, "#,###.000");
				}
			}
			
			var sXml=formObj.sXml.value;
			
			var arrXml=sXml.split("|$$|");
			
			sheetObjects[2].LoadSearchData(arrXml[0],{Sync:1} );																//2015.01.15. kimtagkyun.
			opusCheckBoxString = ComGetEtcData(arrXml[0], "opusCheckBoxString");											//2015.01.15. kimtagkyun.
			xterCheckBoxString = ComGetEtcData(arrXml[0], "xterCheckBoxString");											//2015.01.15. kimtagkyun.
			ebkgDgSeqProblem = ComGetEtcData(arrXml[0], "EBKG_DG_SEQ");														//2015.01.15. kimtagkyun.
			if (sheetObjects[2].GetTotalRows()> 0) {																			//2015.01.15. kimtagkyun.
				max_dcgo_seq=sheetObjects[2].GetCellValue(sheetObjects[2].LastRow(), "dcgo_seq");								//2015.01.15. kimtagkyun.
			}
			
			/////////////////////////////// //2015.01.15. kimtagkyun.////////////////////////////////////////////////////////////////////////////////////
			sheetObjects[0].LoadSearchData(arrXml[2],{Sync:1});
			sheetObjects[1].LoadSearchData(arrXml[3],{Sync:1});
			
			/* 값이 있을 경우 버튼 색 변화 */
			getBtnObject("btn_dgRider").style.color 		= (sheetObjects[0].GetTotalRows()>0)     ?"blue":"#737373";				
			getBtnObject("btn_dgRider2").style.color 		= (sheetObjects[1].GetTotalRows()>0)     ?"blue":"#737373";				
						
			// 이미지 변경하기
			if (sheetObjects[0].RowCount() > 0) {																					
				for ( var row = 1; row <= sheetObjects[0].LastRow(); row++) {
					if (sheetObjects[0].GetCellValue(row, "cargo_cnt") > 1) {														
						sheetObjects[0].SetCellImage(row, "multiPopup", 0);														
					} else {																									
						sheetObjects[0].SetCellImage(row, "multiPopup", 1);														
					}																											
				}																												
			} 																		
			if (sheetObjects[1].RowCount() > 0) {
				var lastRow = sheetObjects[1].LastRow();
				for ( var row = 1; row <= lastRow; row++) {		
					if (sheetObjects[1].GetCellValue(row, "cargo_cnt") > 1) {			
						sheetObjects[1].SetCellImage(row, "multiPopup", 0);														
					} else {
						sheetObjects[1].SetCellImage(row, "multiPopup", 1);
					}
				}
			}
			/////////////////////////////// //2015.01.15. kimtagkyun.////////////////////////////////////////////////////////////////////////////////////
		}
		max_dcgo_seq_cnt = sheetObjects[2].RowCount();																			//2015.01.15. kimtagkyun.
		for(var i=1;i<sheetObjects[2].LastRow();i++){																			//2015.01.15. kimtagkyun.
			if(max_dcgo_seq<parseInt(sheetObjects[2].GetCellValue(i, "dcgo_seq"))){												//2015.01.15. kimtagkyun.
				max_dcgo_seq=parseInt(sheetObjects[2].GetCellValue(i, "dcgo_seq"));												//2015.01.15. kimtagkyun.
			}																													//2015.01.15. kimtagkyun.
		}																														//2015.01.15. kimtagkyun.
		if(parent.document.form.dangerTabCancel.value=="Y"){
			//ComBtnColor("btn_cancelcopydata", "blue");
			//ComBtnColor("btn_datacopytoopus", "#737373");
			
			document.getElementById("btn_cancelcopydata").style.cssText = "color:blue !important;font-weight:bold;";
			document.getElementById("btn_datacopytoopus").style.cssText = "color:#737373 !important;font-weight:normal;";
			
			parent.document.form.dangerTabCancel.value="N";
		}
		if(top.document.form.tabload8.value == "COPY"){
			dataCopy();
		} else {
			compareItem();			
		}
		if(parent.frames["t1frame"].document.form.doc_tp_cd.value == "S"){
			ComBtnDisable("btn_datacopytoopus");
		}
		top.document.form.tabload8.value="LOAD";
		
		if(parent.subPageSearchEnd != undefined) parent.subPageSearchEnd('ESM_BKG_0229_08');
		
		break;
	case IBSEARCH: //Retrieve
		formObj.f_cmd.value=SEARCH;
		formObj.method="post";
		formObj.target="_self";
		formObj.action="/opuscntr/ESM_BKG_0229_08.do";
		formObj.submit();
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(7)="#96c792";
		break;
	case IBSEARCH_ASYNC02: //Data Copy
		var formObj2=document.form2;
		// DHTML Create table
		var ins_tables=document.getElementById("INS_TABLES");
		ins_tables.innerHTML="";
		var insTableDiv="";
		var maxSeq=0;
		for ( var k=0; k < formObj.elements.length; k++) {
			if ((formObj.elements[k].name).indexOf("dcgo_seq__") == 0) {														//2015.01.15. kimtagkyun. 
				if (eval(formObj.elements[k].value) > maxSeq)
					maxSeq=formObj.elements[k].value;
			}
		}
		// Comparison of container
		var obj=null;
		var objNm=null;
		var objVal=null;
		var obj2=null;
		var objNm2=null;
		var objVal2=null;
		var isInsert="false";
		if (maxSeq > 0) {
			for ( var i=0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "hidden" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					// Container number
					if (objNm == "dcgo_seq") {
						for ( var j=0; j < formObj.elements.length; j++) {
							if (formObj.elements[j].type == "hidden" && (formObj.elements[j].name).indexOf("__") > 0) {
								obj2=(formObj.elements[j].name).split("__");
								objNm2=obj2[0];
								objVal2=formObj.elements[j].value;
								if (objNm2 == "dcgo_seq") {
									if (objVal == objVal2) {
										isInsert="false";
										break;
									} else {
										isInsert="true";
									}
								}
							}
						}
						if (isInsert == "true") {
							maxSeq++;
							var insTableDiv=createTable(maxSeq);		
							ins_tables.innerHTML=ins_tables.innerHTML + insTableDiv;
							createCntr(maxSeq, obj[1]);
						} else if (isInsert == "false") {
							//delete 된건지 확인 필요 jsy 
							if( !checkDel(objVal2) ) {																			//2015.01.15. kimtagkyun. 
								updateCntr(obj2[1], obj[1]);
							}
						}
					}
				}
			}
		} else {
			for ( var i=0; i < formObj2.elements.length; i++) {
				if (formObj2.elements[i].type == "text" && (formObj2.elements[i].name).indexOf("__") > 0) {
					obj=(formObj2.elements[i].name).split("__");
					objNm=obj[0];
					objVal=formObj2.elements[i].value;
					if (objNm == "cntr_no") {
						maxSeq++;
						var insTableDiv=createTable(maxSeq);
						ins_tables.innerHTML=ins_tables.innerHTML + insTableDiv;
						createCntr(maxSeq, obj[1]);
					}
				}
			}
		}
		
		//dg rider copy
////////////////////////////////////2015.01.15. kimtagkyun. //////////////////////////////////////////////////////////// 
		if(div2sheet1.GetTotalRows()>0){
			for(var i=1;i<div2sheet1.GetTotalRows() + 1;i++){
				var isInsert = "true";
				for(var j=1;j<div1sheet1.GetTotalRows() + 1;j++){
					if(div1sheet1.GetCellValue(j, "file_sav_id")==div2sheet1.GetCellValue(i, "file_sav_id")){						
						isInsert = "false"
						break;
					} else {
						isInsert = "true";
					}
				}

				if(isInsert=="true"){
					var newRow = div1sheet1.DataInsert(-1);
//					div1sheet1.RowStatus(newRow) 					= "U";
					div1sheet1.SetCellValue(newRow,	"ibflag",	"U");
                    div1sheet1.SetCellValue(newRow, "file_nm"      , div2sheet1.GetCellValue(i, "file_nm"      ));
                    div1sheet1.SetCellValue(newRow, "file_size"    , div2sheet1.GetCellValue(i, "file_size"    ));
                    div1sheet1.SetCellValue(newRow, "cargo_contain", div2sheet1.GetCellValue(i, "cargo_contain"));
                    div1sheet1.SetCellValue(newRow, "file_path"    , div2sheet1.GetCellValue(i, "file_path"    ));
                    div1sheet1.SetCellValue(newRow, "ridr_tp_cd"   , div2sheet1.GetCellValue(i, "ridr_tp_cd"   ));
                    div1sheet1.SetCellValue(newRow, "file_sav_id"  , div2sheet1.GetCellValue(i, "file_sav_id"  ));
                    div1sheet1.SetCellValue(newRow, "img_seq"      , div2sheet1.GetCellValue(i, "img_seq"      ));
                    div1sheet1.SetCellValue(newRow, "cargo_cnt"    , div2sheet1.GetCellValue(i, "cargo_cnt"    ));
                    div1sheet1.SetCellValue(newRow, "dcgo_seq"     , div2sheet1.GetCellValue(i, "dcgo_seq"     ));
                    div1sheet1.SetCellImage(newRow, "multiPopup"   , 1);
				}
			}
		}	
////////////////////////////////////2015.01.15. kimtagkyun. //////////////////////////////////////////////////////////// 

		
//no support[check again]CLT 		parent.tabObjects[0].TabBackColor(7)="#fff270";
		compareItem();
		initControl();
		break;
	//UPLOAD
	case IBSAVE:
		if (validateForUpload() == false) return;
		var params=getSaveStringForUpload();
 		var sXml=sheetObj.GetSaveData("ESM_BKG_0229_08GS.do", params);
		if(ComBkgErrMessage(sheetObjects[2], sXml)) {																			//2015.01.15. kimtagkyun. 
 			sheetObj.LoadSaveData(sXml);
			doActionIBSheet(sheetObjects[2], document.form, IBSEARCH);															//2015.01.15. kimtagkyun. 
		}
		break;
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
//	if (!sheetObj.IsDataModified) {
//		ComShowCodeMessage("BKG00743");
//		return false;
//	}
	
	for(i=1 ; i <= sheetObj.LastRow() ; i++){
		
		var imdg_un_no = sheetObj.GetCellValue(i, "imdg_un_no");
		var imdg_un_no_seq = sheetObj.GetCellValue(i, "imdg_un_no_seq");
		var imdg_clss_cd = sheetObj.GetCellValue(i, "imdg_clss_cd");
		var param = "f_cmd="+SEARCH +
					"&imdg_un_no=" + imdg_un_no + 
					"&imdg_un_no_seq=" + imdg_un_no_seq +
					"&imdg_clss_cd=" + imdg_clss_cd;
		
		var sXml = sheetObj.GetSearchData("ESM_BKG_0204GS.do", param);
		var length = ComGetEtcData(sXml, "length");
		if(length == '0'){
			var dcgo_seq = sheetObj.GetCellValue(i, "dcgo_seq");
			comBkgCallPop0204_position(dcgo_seq);
			return false;
		}
	}
	
	if (!ComChkValid(formObj))
		return false;
	
	if(!chkUnNoSeq() )																											//2015.01.15. kimtagkyun.  
		return false;
	return true;	
}

//////////////////// //2015.01.15. kimtagkyun. /////////////////////////////////////////
function chkUnNoSeq() {
 	var formObj=document.form;
//	var maxSeq = 0;
	for ( var k = 0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("imdg_un_no_seq__") == 0) {
			if ( (formObj.elements[k].value == null) || (formObj.elements[k].value == '') ) {
//				maxSeq = formObj.elements[k].value;
				ComShowMessage(msgs['BKG02093']);
				return false;				
			}
		}
	}
	return true;
}
//////////////////////2015.01.15. kimtagkyun. /////////////////////////////////////////

/**
 * being called in case of clicking 'Upload' button.
 * having the function of the same name regardless of tab 
 * being implemented the content that fits to the tab
 * moving to the field if needed after failed to validate before returning false
 * 
 */
function validateForUpload() {
	 return validateForm(sheetObjects[2], document.form, IBSAVE);													//2015.01.15. kimtagkyun. 
}
/**
 * being called in case of clicking 'Upload' button.
 * having the function of the same name regardless of tab 
 * being implemented the content that fits to the tab
 * QueryString return
 */
function getSaveStringForUpload() {
	doSaveCopy();
//	var params="";
//	if (sheetObjects[2].RowCount()>=1) {
//		params="f_cmd=" + MULTI + "&" + ComSetPrifix(sheetObjects[2].GetSaveString(true), prefix);					//2015.01.15. kimtagkyun. 			
//	}
//	a"lert("getSaveStringForUpload in ESM_BKG_0229_08.js params=[" + params + "]");
	
	var sParam1 = sheetObjects[2].GetSaveString(true); 
	var sParam2 = sheetObjects[0].GetSaveString(true); 
	sParam1 = ComSetPrifix(sParam1, prefix) + "&";
	sParam2 = ComSetPrifix(sParam2, "t8sheet2_") + "&";
	params="f_cmd=" + MULTI + "&" + sParam1 + sParam2;
	return params;
}
 /**
  * e-Booking Upload Copy popup ->[OK] button Click
   */
function dataCopy() {
	if (isCopy == "false") {
		doActionIBSheet(sheetObjects[2], document.form, IBSEARCH_ASYNC02);	
		document.getElementById("btn_datacopytoopus").style.cssText = "color:blue !important;font-weight:bold;";
		document.getElementById("btn_cancelcopydata").style.cssText = "color:#737373 !important;font-weight:normal;";
	}
	doSaveCopy();
}
function doSaveCopy(){
 	var formObj=document.form;
	var sheetObj=sheetObjects[2];																					//2015.01.15. kimtagkyun. 
	var maxSeq=0;
	var maxCntrSeq = "1";																							//2015.01.15. kimtagkyun.
	for ( var k=0; k < formObj.elements.length; k++) {
		if ((formObj.elements[k].name).indexOf("dcgo_seq__") == 0 && !checkDelDcgoSeq(formObj.elements[k].value)) {	//2015.01.15. kimtagkyun.
			maxSeq++;																								//2015.01.15. kimtagkyun.
			if(sheetObj.GetCellValue(i, "max_dg_cntr_seq") > Number(maxCntrSeq))									//2015.01.15. kimtagkyun.
				maxCntrSeq = sheetObj.CellValue(i, "max_dg_cntr_seq");
		}
	}
	for (var i=sheetObj.RowCount(); i<maxSeq; i++) {
		sheetObj.DataInsert(-1);
	}
 	var obj=null;
 	var objNm=null;
 	var objSeq=null;
 	var objVal=null;
 	var cntrNo=null;
 	var ibflag=null;
 	var newObjSeq=null;																								//2015.01.15. kimtagkyun. 
 	var sheetRow=0; 																								//2015.01.15. kimtagkyun. 
 	
 	for(var i=0; i<formObj.elements.length; i++) {
 		if ((formObj.elements[i].name).indexOf("__") > 0) {
 			obj=(formObj.elements[i].name).split("__");
 			objNm=obj[0];
 			objSeq=obj[1];
 			//2015.01.15. kimtagkyun. 
 			if( (i ==0 && sheetRow==0) || (objSeq != newObjSeq && objNm == "dcgo_seq" && !checkDelDcgoSeq(formObj.elements[i].value) ) || sheetObjects[2].GetCellValue(sheetRow, "ibflag")== 'D' )  {
 				newObjSeq = obj[1];
 				sheetRow++;
 			}
 			objVal=formObj.elements[i].value;
 			if (sheetObjects[2].GetCellValue(sheetRow,"bkg_no") == "") {													//2015.01.15. kimtagkyun. 
 				sheetObjects[2].SetCellValue(sheetRow,"bkg_no",formObj.bkg_no.value,0);
 			}
// 			if ( objNm == "dcgo_seq" )			sheetObjects[0].SetCellValue(objSeq,"dcgo_seq",objVal,0);
// 			if ( objNm == "cntr_no" )			sheetObjects[0].SetCellValue(objSeq,"cntr_no",ComTrimAll(objVal),0);
 			
 			if ( objNm == "dcgo_seq" 
 					&& !checkDelDcgoSeq(formObj.elements[i].value) 															//2015.01.15. kimtagkyun. 
 					&&  sheetObjects[2].GetCellValue(sheetRow, "ibflag") != 'D' )			
 												sheetObjects[2].SetCellValue(sheetRow,"dcgo_seq",objVal,0);
 			if ( objNm == "cntr_no" )			sheetObjects[2].SetCellValue(sheetRow,"cntr_no",ComTrimAll(objVal),0);		//2015.01.15. kimtagkyun. 
 			if ( objNm == "cntr_cgo_seq" )		sheetObjects[2].SetCellValue(sheetRow,"cntr_cgo_seq",objVal,0);				//2015.01.15. kimtagkyun. 
 			
 			if ( objNm == "cntr_seq" )			sheetObjects[2].SetCellValue(sheetRow,"dg_cntr_seq",objVal,0);
 			
 			if ( objNm == "cntr_tpsz_cd" )		sheetObjects[2].SetCellValue(sheetRow,"cntr_tpsz_cd",objVal,0);
 			if ( objNm == "imdg_un_no" )		sheetObjects[2].SetCellValue(sheetRow,"imdg_un_no",objVal,0);
 			if ( objNm == "imdg_un_no_seq" )	sheetObjects[2].SetCellValue(sheetRow,"imdg_un_no_seq",objVal,0);
 			if ( objNm == "imdg_clss_cd" )		sheetObjects[2].SetCellValue(sheetRow,"imdg_clss_cd",objVal,0);
 			if ( objNm == "imdg_lmt_qty_flg")	sheetObjects[2].SetCellValue(sheetRow,"imdg_lmt_qty_flg",objVal,0);
 			if ( objNm == "grs_wgt" ) 			sheetObjects[2].SetCellValue(sheetRow,"grs_wgt",objVal,0);
 			if ( objNm == "net_wgt" ) 			sheetObjects[2].SetCellValue(sheetRow,"net_wgt",objVal,0);
 			if ( objNm == "wgt_ut_cd" ) 		sheetObjects[2].SetCellValue(sheetRow,"wgt_ut_cd",objVal,0);
 			if ( objNm == "flsh_pnt_cdo_temp" ) sheetObjects[2].SetCellValue(sheetRow,"flsh_pnt_cdo_temp",objVal,0);
 			if ( objNm == "prp_shp_nm" ) 		sheetObjects[2].SetCellValue(sheetRow,"prp_shp_nm",objVal,0);
 			if ( objNm == "hzd_desc" ) 			sheetObjects[2].SetCellValue(sheetRow,"hzd_desc",objVal,0);
 			if ( objNm == "imdg_pck_grp_cd" ) 	sheetObjects[2].SetCellValue(sheetRow,"imdg_pck_grp_cd",objVal,0);
 			if ( objNm == "mrn_polut_flg" ) 	sheetObjects[2].SetCellValue(sheetRow,"mrn_polut_flg",objVal,0);
 			if ( objNm == "emer_cntc_phn_no_ctnt" ) 	sheetObjects[2].SetCellValue(sheetRow,"emer_cntc_phn_no_ctnt",objVal,0);			//2015.01.15. kimtagkyun. 
 			if ( objNm == "emer_cntc_pnt_ctnt" )	sheetObjects[2].SetCellValue(sheetRow,"emer_cntc_pnt_ctnt",objVal,0);
 			if ( objNm == "dcgo_sts_cd" )		sheetObjects[2].SetCellValue(sheetRow,"dcgo_sts_cd",objVal,0);
 			if ( objNm == "spcl_stwg_rqst_desc")sheetObjects[2].SetCellValue(sheetRow,"spcl_stwg_rqst_desc",objVal,0);
 			if ( objNm == "imdg_comp_grp_cd")   sheetObjects[2].SetCellValue(sheetRow,"imdg_comp_grp_cd",objVal,0);			//2015.01.15. kimtagkyun. 
 			if ( objNm == "imdg_amdt_no")       sheetObjects[2].SetCellValue(sheetRow,"imdg_amdt_no",objVal,0);
 			if ( objNm == "imdg_segr_grp_no")       sheetObjects[2].SetCellValue(sheetRow,"imdg_segr_grp_no",objVal,0);
 			
 		}
 	}
}
function compareItem() {
	var obj=null;
	var objNm=null;
	var objVal=null;
	var obj2=null;
	var objNm2=null;
	var objVal2=null;
	var formObj=document.form;
	var formObj2=document.form2;	
	var sameCntr="false";
	for ( var i=0; i < formObj2.elements.length; i++) {
		if (formObj2.elements[i].type == "hidden"
				&& (formObj2.elements[i].name).indexOf("__") > 0) {
			obj=(formObj2.elements[i].name).split("__");
			objNm=obj[0];
			objVal=formObj2.elements[i].value;
			if (objNm == "dcgo_seq") {
				for ( var j=0; j < formObj.elements.length; j++) {
					if (formObj.elements[j].type == "hidden"
							&& (formObj.elements[j].name).indexOf("__") > 0) {
						obj2=(formObj.elements[j].name).split("__");
						objNm2=obj2[0];
						objVal2=formObj.elements[j].value;
						if (objNm2 == "dcgo_seq") {
							if (objVal == objVal2) {
								sameCntr="true";
								break;
							} else {
								sameCntr="false";
							}
						}
					}
				}
				if (sameCntr == "true") {
					if( !checkDel(objVal2) ) {																				//2015.01.15. kimtagkyun. 
						compareCntr(obj2[1], obj[1]);
					}
				}
			}
		}
	}	
}
function createTable(seq) {
	var insTableDiv="";
	insTableDiv=insTableDiv + "<div id='table_" + seq + "'>\n";
	insTableDiv=insTableDiv + "</div>\n";
	return insTableDiv;
}
function createCntr(leftSeq, rightSeq) {
    var formObj2=document.form2;
    var tabSeq="table_" + leftSeq;
    var dyntbl1=document.getElementById(tabSeq);
    dyntbl1.innerHTML="";
    max_dcgo_seq++;
    var oCell1="";

    var colGrStr =
        '<colgroup>\n' +
        '	<col width="30" />' +
        '	<col width="80" />' +
        '	<col width="" />' +
        '	<col width="*" />' +
        '</colgroup>\n';

    oCell1  = "<input type=\"hidden\" name=\"cntr_no_cmpr__" + leftSeq + "\" value=\"" + eval("formObj2.cntr_cgo_seq__" + rightSeq).value + "\">\n";
    oCell1 += "<input type=\"hidden\" name=\"dcgo_seq__" + leftSeq + "\" value='" + max_dcgo_seq + "'>\n";
    oCell1 += "<input type=\"hidden\" name=\"imdg_segr_grp_no__" + leftSeq + "\" value=''>\n";
//    oCell1 += "<input type=\"hidden\" name=\"dcgo_seq__" + leftSeq + "\" value=\"" + parseInt(parseInt(eval("formObj2.cntr_cgo_seq__" + rightSeq).value) + parseInt(max_dcgo_seq)) + "\">\n";
    oCell1 += "<table id=\"table" + leftSeq + "\">\n";
    oCell1 += colGrStr;

    //ROW1 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td><input type=\"text\" onchange=\"cntrSeqChange(" + leftSeq + ", this)\" name=\"cntr_seq__" + leftSeq + "\" id=\"cntr_seq__" + leftSeq + "\" style=\"width:25px;text-align:center;\" class=\"input\" value=\"" + leftSeq + "\" ></td>\n";
    oCell1 += "			<th>CNTR No.</th>\n";
    oCell1 += "			<td>\n";
    oCell1 += "		  		<select name=\"cntr_no__" + leftSeq + "\" style=\"width:105px;\" class=\"input\" onChange=\"changeCntrNo(this,'" + leftSeq + "')\">\n";
    var cntrTpsz_cdArr=cntrTpsz_cd.split("|");
    var cntrTpsz_idArr=cntrTpsz_id.split("|");
    for ( var j=0; j < cntrTpsz_cdArr.length; j++) {
        if (cntrTpsz_cdArr[j] == '' && cntrTpsz_idArr[j] == '')
            continue;
        if (cntrTpsz_cdArr[j] == eval("formObj2.cntr_no__" + rightSeq).value) {
            oCell1 += "		<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\"" + cntrTpsz_idArr[j] + "\" selected>" + cntrTpsz_cdArr[j] + "</option>\n";
        } else {
            oCell1 += "		<option value=\"" + cntrTpsz_cdArr[j] + "\" id=\"" + cntrTpsz_idArr[j] + "\">" + cntrTpsz_cdArr[j]          + "</option>\n";
        }
    }
    oCell1 += "		  		</select>"
    	+ "					<input type=\"text\" dataformat='engup' required caption=\"Cntr Type Size\" name=\"cntr_tpsz_cd__" + leftSeq + "\" style=\"width:40px;\" maxlength=\"2\" class=\"input\" value=\"" + eval("formObj2.cntr_tpsz_cd__" + rightSeq).value + "\">"
    	+ "				    <strong>Status</strong>"
        + "     		    <input type=\"text\" name=\"status__" + leftSeq + "\" style=\"width:55px;color:blue;\" class=\"input2\" value=\"New\">"
    	+ "                 </td>";
    oCell1 += "				<td><button type=\"button\" class=\"btn_etc\" onclick=\"javascript:btn_Restriction('"+ leftSeq + "')\">Restriction</button>" +
        "					<button type=\"button\" class=\"btn_etc\" onclick=\"javascript:btn_PreChecking('"+ leftSeq + "');\">Pre Checking</button></td>";
    oCell1 += "		</tr>\n";
    //ROW1 (E)

    //ROW2 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Seq.</th>\n";
    oCell1 += "			<td colspan=\"2\"><input type=\"text\" onchange=\"cntrCgoSeqChange(" + leftSeq + ", this)\" max=\"3\" name=\"cntr_cgo_seq__" + leftSeq + "\" id=\"cntr_cgo_seq__" + leftSeq + "\" style=\"width:30px;text-align:center;\" dataformat='num' class=\"input\" value=\"" + eval("formObj2.cntr_cgo_seq__" + rightSeq).value + "\">\n";
    oCell1 += "				<strong>UN No.</strong>\n";
     
    var imdg_un_no = eval("formObj2.imdg_un_no__" + rightSeq).value;
    if(imdg_un_no.length > 4) imdg_un_no = imdg_un_no.substring(0, 4);
    
    oCell1 += "				<input type=\"text\" required caption=\"UN No.\" dataformat='num' name=\"imdg_un_no__" + leftSeq + "\" id=\"imdg_un_no__" + leftSeq + "\" style=\"width:40px;\" maxlength=\"4\" class=\"input\" value=\"" + imdg_un_no + "\" onblur=\"comBkgCallPop0204_position(" + leftSeq + ");\" />"
////////////////////////////////////2015.01.15. kimtagkyun. imdg_un_no_seq__//////////////////////////////////////////////////////////////
        + "					<input name=\"imdg_un_no_seq__"+leftSeq+ "\" value=\"" + eval("formObj2.imdg_un_no_seq__" + rightSeq).value+"\" type=\"text\" style=\"width:40px;\" class=\"input2\" readonly>"			
        + "					<button type=\"button\" class=\"input_seach_btn\" onclick=\"javascript:comBkgCallPop0204_position('" + leftSeq + "');\"></button>";
    oCell1 += "				<strong>IMDG Class</strong>\n";
    oCell1 += "				<input type=\"text\" dataformat='float' name=\"imdg_clss_cd__" + leftSeq + "\" style=\"width:40px;\" maxlength=\"3\" class=\"input2\" value=\"" + eval("formObj2.imdg_clss_cd__" + rightSeq).value + "\" readOnly>\n"
////////////////////////////////////2015.01.15. kimtagkyun. imdg_comp_grp_cd__//////////////////////////////////////////////////////////////
		+ "					<input name=\"imdg_comp_grp_cd__"+leftSeq+"\" type=\"text\" style=\"width:20px;\" class=\"input2\" value=\"" + eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value+"\" maxlength=\"1\" readonly>";
    oCell1 += "\n			<input name=\"imdg_amdt_no__"+leftSeq+"\" type=\"hidden\" value=\"" + eval("formObj2.imdg_amdt_no__" + rightSeq).value+"\" >";
    oCell1 += "        </td>\n";
    oCell1 += "	</tr>\n";
    //ROW2 (E)

    //ROW3 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Proper Shipping Name</th>\n";
    oCell1 += "			<td colspan='2'>"
    	+ "					<input type=\"text\" name=\"prp_shp_nm__" + leftSeq + "\" id=\"prp_shp_nm__" + leftSeq + "\" onKeyUp='allowAllCharsButEngup()' " + " style=\"width:298px;\" class=\"input\" value=\"" + eval("formObj2.prp_shp_nm__" + rightSeq).value + "\"></td>\n";
    oCell1 += "		</tr>\n";
    //ROW3 (E)

    //ROW4 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>HAZ. Contents</th>\n";
    oCell1 += "			<td colspan='2'>"
    	+ "					<textarea name=\"hzd_desc__" + leftSeq + "\" id=\"hzd_desc__" + leftSeq + "\" onKeyUp='allowAllCharsButEngup()' style=\"width:298px;height:40px;resize:none;\">" + eval("formObj2.hzd_desc__" + rightSeq).value + "</textarea></td>\n";
    oCell1 += "		</tr>\n";
    //ROW4 (E)

    //ROW5 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Flash Point</th>\n";
    oCell1 += "			<td colspan='2'>"
    	+ "					<input type=\"text\" dataformat='num' otherchar='-.' name=\"flsh_pnt_cdo_temp__" + leftSeq + "\" maxlength=\"7\" pointcount=\"2\" style=\"width:50px;text-align:right\" maxlength=\"7\" class=\"input\" value=\"" + eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value + "\">"
    	+ "					<label for='flsh_pnt_cdo_temp__" + leftSeq + "'>C</label>\n";
    oCell1 += "			<strong>Packing Group</strong><input type=\"text\" name=\"imdg_pck_grp_cd__" + leftSeq + "\" id=\"imdg_pck_grp_cd__" + leftSeq + "\" style=\"width:30px;\" maxlength=\"1\" class=\"input2\" value=\"" + eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value + "\" readOnly>\n";
    oCell1 += "			<strong>Marine Pollutant</strong>\n";
    oCell1 += "		  		<select name=\"mrn_polut_flg__" + leftSeq + "\" id=\"mrn_polut_flg__" + leftSeq + "\" style=\"width:60px;\">\n";
    var mrn1=(eval("formObj2.mrn_polut_flg__" + rightSeq).value == "Y")?"selected":"";
    var mrn2=(eval("formObj2.mrn_polut_flg__" + rightSeq).value == "N")?"selected":"";
    oCell1 += "		    	<option value=\"Y\" " + mrn1 + ">Yes</option>\n";
    oCell1 += "		    	<option value=\"N\" " + mrn2 + ">No</option>\n";
    oCell1 += "		  		</select>\n";
    oCell1 += "			</td>\n";
    oCell1 += "		</tr>\n";
    //ROW5 (E)

    //ROW6 (S)
    oCell1 += " 	<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += " 		<th>Gross Weight</th>\n";
    oCell1 += " 		<td colspan='2'>"
    	+ "					<input type=\"text\" name=\"grs_wgt__" + leftSeq + "\" id=\"grs_wgt__" + leftSeq + "\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" style=\"width:80px;text-align:right\" class=\"input\" value=\"" + eval("formObj2.grs_wgt__" + rightSeq).value + "\">"
    	+ "					<input type=\"text\" dataformat='engup' name=\"wgt_ut_cd__" + leftSeq + "\" id=\"wgt_ut_cd__" + leftSeq + "\" style=\"width:40px;\" class=\"input2\" value=\"" + eval("formObj2.wgt_ut_cd__" + rightSeq).value + "\" readOnly>\n";
    oCell1 += " 		    <strong>Net Weight</strong>\n"
    	+ "					<input type=\"text\" name=\"net_wgt__" + leftSeq + "\" id=\"net_wgt__" + leftSeq + "\" maxlength=\"12\" dataformat=\"float\" pointcount=\"3\" style=\"width:80px;text-align:right\" class=\"input\" value=\"" + eval("formObj2.net_wgt__" + rightSeq).value + "\">"
    	+ "					<input type=\"text\" dataformat='engup' style=\"width:40px;\" class=\"input2\" value=\"" + eval("formObj2.wgt_ut_cd__" + rightSeq).value + "\" readOnly></td>\n";
    oCell1 += " 	</tr>\n";
    //ROW6 (E)

    //ROW7 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Emergency Contact</th>"
        + "				<td colspan='2'>"
        + "					<input type=\"text\" name=\"emer_cntc_phn_no_ctnt__" + leftSeq + "\" id=\"emer_cntc_phn_no_ctnt__" + leftSeq + "\" style=\"width:200px;\" maxlength=\"100\" onKeyUp='allowAllCharsButEngup()' class=\"input\" value=\"" + eval("formObj2.emer_cntc_phn_no_ctnt__" + rightSeq).value + "\">"
    	+ "					<strong>Contact Person</strong>"
    	+ "					<input type=\"text\" name=\"emer_cntc_pnt_ctnt__" + leftSeq + "\" id=\"emer_cntc_pnt_ctnt__" + leftSeq + "\" style=\"width:200px;\" maxlength=\"100\" onKeyUp='allowAllCharsButEngup()' class=\"input\" value=\"" + eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq).value + "\">"
    oCell1 += "		</td>\n</tr>\n";
    //ROW7 (E)

    //ROW8 (E)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Cargo Status</th>\n";
    oCell1 += "			<td colspan='2'>\n";
    oCell1 += "		  		<select name=\"dcgo_sts_cd__" + leftSeq + "\" id=\"dcgo_sts_cd__" + leftSeq + "\" style=\"width:80px;\" class=\"input\">\n";

    var dcgo1=(eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "G")?"selected":"";
    var dcgo2=(eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "L")?"selected":"";
    var dcgo3=(eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "P")?"selected":"";
    var dcgo4=(eval("formObj2.dcgo_sts_cd__" + rightSeq).value == "S")?"selected":"";
    
    oCell1 += "		    	<option value=\"\" ></option>\n";
    oCell1 += "		    	<option value=\"G\" " + dcgo1 + ">Gas</option>\n";
	oCell1 += "		    	<option value=\"L\" " + dcgo2 + ">Liquid</option>\n";
	oCell1 += "		    	<option value=\"P\" " + dcgo3 + ">Paste</option>\n";
	oCell1 += "		    	<option value=\"S\" " + dcgo4 + ">Sold</option>\n";
    oCell1 += "		  		</select>\n";
    oCell1 += "			<strong>Limited Q'ty</strong>\n";
    oCell1 += "		  		<select name=\"imdg_lmt_qty_flg__" + leftSeq + "\" id=\"imdg_lmt_qty_flg__" + leftSeq + "\" style=\"width:73px;\" class=\"input\">\n";
    
    var imdg1=(eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value == "Y")?"selected":"";
    var imdg2=(eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value == "N")?"selected":"";
    
    oCell1 += "		    	<option value=\"Y\" " + imdg1 + ">Yes</option>\n";
    oCell1 += "		    	<option value=\"N\" " + imdg2 + ">No</option>\n";
    oCell1 += "		  		</select>\n";
    oCell1 += "			</td>\n";
    oCell1 += "		</tr>\n";
    //ROW8 (E)

    //ROW9 (S)
    oCell1 += "		<tr>\n";
    oCell1 += "			<td></td>\n";
    oCell1 += "			<th>Remark(s)</th>\n";
    oCell1 += "			<td>"
    	+ "					<textarea onKeyUp='allowAllCharsButEngup()' name=\"spcl_stwg_rqst_desc__"+ leftSeq + "\" id=\"spcl_stwg_rqst_desc__"+ leftSeq + "\" style=\"width:250px;height:40px;resize:none;\">" + eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value + "</textarea></td>\n";
    oCell1 += "			<td>";
    oCell1 += "				<button type=\"button\" class=\"btn_etc mar_top_2\" onclick=\"javascript:btn_delete('table" + leftSeq + "', '" + leftSeq + "');\">Delete</button>";
    oCell1 += "			</td>"
    oCell1 += "		</tr>\n";
    //ROW9 (E)

    oCell1 += "</table>\n";
//	ale"rt(oCell1);
    dyntbl1.innerHTML=oCell1;
}
function updateCntr(leftSeq, rightSeq) {
	var formObj=document.form;
	var formObj2=document.form2;
	if (eval("formObj.status__" + leftSeq).value == "Approved" 
		|| eval("formObj.status__" + leftSeq).value == "Rejected"
		|| eval("formObj.status__" + leftSeq).value == "Requested")
		return;
	if (eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != null && eval("formObj2.cntr_tpsz_cd__" + rightSeq).value != '')
		eval("formObj.cntr_tpsz_cd__" + leftSeq).value=eval("formObj2.cntr_tpsz_cd__" + rightSeq).value;
	if (eval("formObj2.imdg_un_no__" + rightSeq).value != null && eval("formObj2.imdg_un_no__" + rightSeq).value != ''){
		if(eval("formObj2.imdg_un_no__" + rightSeq).value != eval("formObj.imdg_un_no__" + leftSeq).value){
			eval("formObj.imdg_amdt_no__" + leftSeq).value="";
		}
		eval("formObj.imdg_un_no__" + leftSeq).value=eval("formObj2.imdg_un_no__" + rightSeq).value;
	}
	if (eval("formObj2.imdg_un_no_seq__" + rightSeq).value != null && eval("formObj2.imdg_un_no_seq__" + rightSeq).value != '')				//2015.01.15. kimtagkyun. imdg_un_no_seq__
		eval("formObj.imdg_un_no_seq__" + leftSeq).value = eval("formObj2.imdg_un_no_seq__" + rightSeq).value;
	if (eval("formObj2.imdg_clss_cd__" + rightSeq).value != null && eval("formObj2.imdg_clss_cd__" + rightSeq).value != '')
		eval("formObj.imdg_clss_cd__" + leftSeq).value=eval("formObj2.imdg_clss_cd__" + rightSeq).value;
	if (eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value != null && eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value != '')			//2015.01.15. kimtagkyun. imdg_comp_grp_cd__
		eval("formObj.imdg_comp_grp_cd__" + leftSeq).value = eval("formObj2.imdg_comp_grp_cd__" + rightSeq).value;
	if (eval("formObj2.prp_shp_nm__" + rightSeq).value != null && eval("formObj2.prp_shp_nm__" + rightSeq).value != '')
		eval("formObj.prp_shp_nm__" + leftSeq).value=eval("formObj2.prp_shp_nm__" + rightSeq).value;
	if (eval("formObj2.hzd_desc__" + rightSeq).value != null && eval("formObj2.hzd_desc__" + rightSeq).value != '')
		eval("formObj.hzd_desc__" + leftSeq).value=ComTrim(eval("formObj2.hzd_desc__" + rightSeq).value);
	if (eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value != null && eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value != '')
		eval("formObj.flsh_pnt_cdo_temp__" + leftSeq).value=eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value;
	if (eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value != null && eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value != '')
		eval("formObj.imdg_pck_grp_cd__" + leftSeq).value=eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value;
	if (eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq).value != null && eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq).value != '')
		eval("formObj.emer_cntc_pnt_ctnt__" + leftSeq).value=eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq).value;
	if (eval("formObj2.emer_cntc_phn_no_ctnt__" + rightSeq).value != null && eval("formObj2.emer_cntc_phn_no_ctnt__" + rightSeq).value != '')
		eval("formObj.emer_cntc_phn_no_ctnt__" + leftSeq).value=eval("formObj2.emer_cntc_phn_no_ctnt__" + rightSeq).value;
	if (eval("formObj2.mrn_polut_flg__" + rightSeq).value != null && eval("formObj2.mrn_polut_flg__" + rightSeq).value != '') {
		for ( var i=0; i < eval("formObj.mrn_polut_flg__" + leftSeq).length; i++) {
			if (eval("formObj.mrn_polut_flg__" + leftSeq)[i].value == eval("formObj2.mrn_polut_flg__"
					+ rightSeq).value) {
				eval("formObj.mrn_polut_flg__" + leftSeq).selectedIndex=i;
				break;
			}
		}
	}
	if (eval("formObj2.dcgo_sts_cd__" + rightSeq).value != null && eval("formObj2.dcgo_sts_cd__" + rightSeq).value != '') {
		for ( var j=0; j < eval("formObj.dcgo_sts_cd__" + leftSeq).length; j++) {
			if (eval("formObj.dcgo_sts_cd__" + leftSeq)[j].value == eval("formObj2.dcgo_sts_cd__"
					+ rightSeq).value) {
				eval("formObj.dcgo_sts_cd__" + leftSeq).selectedIndex=j;
				break;
			}
		}
	}
	if (eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value != null && eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value != '') {
		for ( var k=0; k < eval("formObj.imdg_lmt_qty_flg__" + leftSeq).length; k++) {
			if (eval("formObj.imdg_lmt_qty_flg__" + leftSeq)[k].value == eval("formObj2.imdg_lmt_qty_flg__"
					+ rightSeq).value) {
				eval("formObj.imdg_lmt_qty_flg__" + leftSeq).selectedIndex=k;
				break;
			}
		}
	}
}
function setCntrDiffCheckColor(bkgValue, eBkgValue, eBkgItemNm){
	var formObj=document.form;
	var formObj2=document.form2;
	var tmp=eval(eBkgItemNm);
	if (bkgValue != eBkgValue) {
		tmp.style.color="blue"
	} else {
		tmp.style.color="#606060";
	}	
}
function compareCntr(leftSeq, rightSeq) {
	var formObj=document.form;
	var formObj2=document.form2;
	setCntrDiffCheckColor(eval("formObj.cntr_tpsz_cd__" 			+ leftSeq).value, eval("formObj2.cntr_tpsz_cd__" 			+ rightSeq).value, ("formObj2.cntr_tpsz_cd__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_un_no__" 				+ leftSeq).value, eval("formObj2.imdg_un_no__" 				+ rightSeq).value, ("formObj2.imdg_un_no__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_clss_cd__" 			+ leftSeq).value, eval("formObj2.imdg_clss_cd__" 			+ rightSeq).value, ("formObj2.imdg_clss_cd__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.prp_shp_nm__" 				+ leftSeq).value, eval("formObj2.prp_shp_nm__" 				+ rightSeq).value, ("formObj2.prp_shp_nm__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.hzd_desc__" 				+ leftSeq).value, eval("formObj2.hzd_desc__" 				+ rightSeq).value, ("formObj2.hzd_desc__" 				+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.flsh_pnt_cdo_temp__" 		+ leftSeq).value, eval("formObj2.flsh_pnt_cdo_temp__" 		+ rightSeq).value, ("formObj2.flsh_pnt_cdo_temp__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_pck_grp_cd__" 			+ leftSeq).value, eval("formObj2.imdg_pck_grp_cd__" 		+ rightSeq).value, ("formObj2.imdg_pck_grp_cd__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.mrn_polut_flg__" 			+ leftSeq).value, eval("formObj2.mrn_polut_flg__" 			+ rightSeq).value, ("formObj2.mrn_polut_flg__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.emer_cntc_phn_no_ctnt__" 	+ leftSeq).value, eval("formObj2.emer_cntc_phn_no_ctnt__" 	+ rightSeq).value, ("formObj2.emer_cntc_phn_no_ctnt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.emer_cntc_pnt_ctnt__" 		+ leftSeq).value, eval("formObj2.emer_cntc_pnt_ctnt__" 		+ rightSeq).value, ("formObj2.emer_cntc_pnt_ctnt__" 	+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.dcgo_sts_cd__" 				+ leftSeq).value, eval("formObj2.dcgo_sts_cd__" 			+ rightSeq).value, ("formObj2.dcgo_sts_cd__" 			+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.imdg_lmt_qty_flg__" 		+ leftSeq).value, eval("formObj2.imdg_lmt_qty_flg__" 		+ rightSeq).value, ("formObj2.imdg_lmt_qty_flg__" 		+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.grs_wgt__" 					+ leftSeq).value, eval("formObj2.grs_wgt__" 				+ rightSeq).value, ("formObj2.grs_wgt__" 				+ rightSeq));
	setCntrDiffCheckColor(eval("formObj.net_wgt__" 					+ leftSeq).value, eval("formObj2.net_wgt__" 				+ rightSeq).value, ("formObj2.net_wgt__"				+ rightSeq));
	setCntrDiffCheckColor(ComTrim(eval("formObj.spcl_stwg_rqst_desc__" 	+ leftSeq).value), ComTrim(eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value), ("formObj2.spcl_stwg_rqst_desc__"+ rightSeq));
//	if (eval("formObj.cntr_tpsz_cd__" + leftSeq).value != eval("formObj2.cntr_tpsz_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.cntr_tpsz_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_un_no__" + leftSeq).value != eval("formObj2.imdg_un_no__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_un_no__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_clss_cd__" + leftSeq).value != eval("formObj2.imdg_clss_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_clss_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.prp_shp_nm__" + leftSeq).value != eval("formObj2.prp_shp_nm__" + rightSeq).value) {
//		var tmp = eval("formObj2.prp_shp_nm__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.hzd_desc__" + leftSeq).value != eval("formObj2.hzd_desc__" + rightSeq).value) {
//		var tmp = eval("formObj2.hzd_desc__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.flsh_pnt_cdo_temp__" + leftSeq).value != eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq).value) {
//		var tmp = eval("formObj2.flsh_pnt_cdo_temp__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_pck_grp_cd__" + leftSeq).value != eval("formObj2.imdg_pck_grp_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_pck_grp_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.mrn_polut_flg__" + leftSeq).value != eval("formObj2.mrn_polut_flg__" + rightSeq).value) {
//		var tmp = eval("formObj2.mrn_polut_flg__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.emer_cntc_pnt_ctnt__" + leftSeq).value != eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq).value) {
//		var tmp = eval("formObj2.emer_cntc_pnt_ctnt__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.dcgo_sts_cd__" + leftSeq).value != eval("formObj2.dcgo_sts_cd__" + rightSeq).value) {
//		var tmp = eval("formObj2.dcgo_sts_cd__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.imdg_lmt_qty_flg__" + leftSeq).value != eval("formObj2.imdg_lmt_qty_flg__" + rightSeq).value) {
//		var tmp = eval("formObj2.imdg_lmt_qty_flg__" + rightSeq);
//		tmp.style.color = "blue";
//	}
//	if (eval("formObj.spcl_stwg_rqst_desc__" + leftSeq).value != eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq).value) {
//		var tmp = eval("formObj2.spcl_stwg_rqst_desc__" + rightSeq);
//		tmp.style.color = "blue";
//	}
}
function form_onChange(){
	var obj=document.getElementById(srcName);
	var srcName=ComGetEvent("name");
	var srcValue=window.event.srcElement.getAttribute("value");
	var obj=document.getElementById(srcName);
//	if (srcName.indexOf("grs_wgt") == 0) obj.value=makeComma(srcValue.replace(/,/g, ""),'3');
//	if (srcName.indexOf("net_wgt") == 0) obj.value=makeComma(srcValue.replace(/,/g, ""),'3');
	compareItem();
}
function deleteAllTable() {
	var formObj=document.form;
	for ( var i=0; i < formObj.elements.length; i++) {
		if ((formObj.elements[i].name).indexOf("table") == 0) {
			btn_deleteTable(formObj.elements[i].value);
		}
	}
}
function btn_deleteTable(tableId) {
	var formObj=document.form;
	var seq=1;
	var tbody=document.getElementById(tableId).getElementsByTagName("TBODY")[0];
	var rowCount=tbody.rows.length;
	while (rowCount > 0) {
		tbody.deleteRow(rowCount - 1);
		rowCount--;
	}
	for ( var i=0; i < formObj.elements.length; i++) {
		var objNm=(formObj.elements[i].name).split("__");
		if (objNm[0] == "cntr_seq") {
			formObj.elements[i].value=seq++;
		}
	}
}

var delete_comp_data = ''; 																							//2015.01.15. kimtagkyun. 
var delete_dcgo_seq = ''; 																							//2015.01.15. kimtagkyun. 

function btn_delete(tableId, seq) {
	var formObj=document.form;
	delete_dcgo_seq = delete_dcgo_seq  + eval("formObj.dcgo_seq__" + seq).value+"|";								//2015.01.15. kimtagkyun. dcgo_seq__
	
//	doSaveCopy();
	for (var i=1; i<sheetObjects[0].RowCount()+1; i++) {
		if (sheetObjects[0].GetCellValue(i, "dcgo_seq") == eval("formObj.dcgo_seq__" + seq).value) {
			sheetObjects[0].SetRowStatus(i,"D");
			break;
		}
	}
	btn_deleteTable(tableId);
	doSaveCopy();
}

///////////////////////////// //2015.01.15. kimtagkyun /////////////////////////////////////////////
function checkDel(objVal2) {
	var obj = delete_comp_data.split('|');
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i] == objVal2) {
			return true;
		}
	}
	return false;
}

function checkDelDcgoSeq(objVal) {
	var obj = delete_dcgo_seq.split('|');
	for ( var i = 0; i < obj.length; i++) {
		if(obj[i] == objVal) {
			return true;
		}
	}
	return false;
}
/////////////////////////// //2015.01.15. kimtagkyun /////////////////////////////////////////////

function changeCntrNo(obj, seq) {
	if (seq != null) {
		var obj_id=obj.options[obj.selectedIndex].id;
		eval("document.form.cntr_tpsz_cd__" + seq).value=obj_id;
	}
}
function btn_Restriction(seq) {
	var formObj=document.form;
	var t1formObj=parent.frames["t1frame"].document.form;
	var bkg_no=t1formObj.bkg_no.value;
	var imdg_un_no=eval("formObj.imdg_un_no__" + seq).value;
	var imdg_un_no_seq=eval("formObj.imdg_un_no_seq__" + seq).value;
	var vsl_cd=t1formObj.bkg_trunk_vvd.value.substring(0,4);
	var skd_voy_no=t1formObj.bkg_trunk_vvd.value.substring(4,8);
	var skd_dir_cd=t1formObj.bkg_trunk_vvd.value.substring(8,9); 
	var pol_cd=t1formObj.bkg_pol_cdvalue;
	var pod_cd=t1formObj.bkg_pod_cdvalue;	
	var slan_cd="";
	ComOpenWindowCenter("VOP_SCG_0021.do?bkg_no="+bkg_no+"&imdg_un_no="+imdg_un_no+"&imdg_un_no_seq="+imdg_un_no_seq+"&pol_cd="+pol_cd+"&pod_cd="+pod_cd+"&vsl_cd="+vsl_cd+"&skd_voy_no="+skd_voy_no+"&skd_dir_cd="+skd_dir_cd+"&slan_cd="+slan_cd, "VOP_SCG_0021", 1200, 660, true);
}
function btn_PreChecking(seq) {
//	var iWidth = 1000;
//	var iHeight = 670;
//	var leftpos = (screen.width - iWidth) / 2;
//	if (leftpos < 0)
//		leftpos = 0;
//	var toppos = (screen.height - iHeight) / 2;
//	if (toppos < 0)
//		toppos = 0;
//	var formObj = document.form;
//	var param = "?bkgNo=" + formObj.bkg_no.value;
//	ComOpenWindow("/opuscntr/VOP_SCG_0069.do" + param, "PopupVopScg0069",
//			"status=no, resizable=no, scrollbars=yes, width=" + iWidth
//					+ ", height=" + iHeight + ", left=" + leftpos + ", top="
//					+ toppos, false);
	//ComOpenPopup("VOP_SCG_0069.do?pop_type=SR", 940, 700, "VOP_SCG_0069", "0,0,1,1,1,1,1", true, null, null, null, null, null, "yes");
}
/**
 * Making parameter of Pre-Checking
 */
function makePreChkParam() {     	  
	var formObj=document.form;
	var t1formObj=parent.frames["t1frame"].document.form;
	var bkg_no=t1formObj.bkg_no.value;
	var vsl_cd=t1formObj.bkg_trunk_vvd.value.substring(0,4);
	var skd_voy_no=t1formObj.bkg_trunk_vvd.value.substring(4,8);
	var skd_dir_cd=t1formObj.bkg_trunk_vvd.value.substring(8,9); 
	var pol_cd=t1formObj.bkg_pol_cdvalue;
	var pod_cd=t1formObj.bkg_pod_cdvalue;	
	var slan_cd="";
	var sParam="";   		  		
	sParam += "rgn_shp_opr_cd=";
	sParam += "cgo_opr_cd=CO";
	sParam += "&bkg_no=" + t1formObj.bkg_no.value;
	sParam += "&vsl_cd=" + t1formObj.bkg_trunk_vvd.value.substring(0,4);
	sParam += "&skd_voy_no=" + t1formObj.bkg_trunk_vvd.value.substring(4,8);
	sParam += "&skd_dir_cd=" + t1formObj.bkg_trunk_vvd.value.substring(8,9); 
//	sParam += "&crr_cd=" + document.getElementById("crr_cd").value;
	sParam += "&slan_cd=";
	sParam += "&pol_cd=" + t1formObj.bkg_pol_cdvalue;
	sParam += "&pod_cd=" + t1formObj.bkg_pod_cdvalue;   		
	return sParam;   		
}     
function loadCntrTpsz(cd, id) {
	cntrTpsz_cd=cd;
	cntrTpsz_id=id;
}
//function makeComma(obj) {
//	var arrVal = obj.value.split(".");
//	if (arrVal.length > 1) {
//		if (arrVal[1].length > 2) {
//			arrVal[1] = arrVal[1].substring(0, 2);
//		}
//		srcValue = makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], 3, "0");
//	} else {
//		srcValue = makeCommaRun(arrVal[0]) + ".000";
//	}
//	return srcValue;
//}
function makeComma(srcValue , pointcount ) {
	
	var arrVal=srcValue.split(".");
	if (arrVal.length > 1) {
		srcValue=makeCommaRun(arrVal[0]) + "." + ComRpad(arrVal[1], pointcount, "0");
	} else {
		if(pointcount==2){
			srcValue=makeCommaRun(arrVal[0]) + ".00";
		} else {
			srcValue=makeCommaRun(arrVal[0]) + ".000";
		}
	}
	return srcValue;
}
function makeCommaRun(srcValue) {
	srcValue=srcValue.replace(/-\D/g, "");
	if (srcValue.length > 9) {
		srcValue=srcValue.substring(0, 9);
	}
	l=srcValue.length - 3;
	while (l > 0) {
		srcValue=srcValue.substr(0, l) + "," + srcValue.substr(l);
		l -= 3;
	}
	return srcValue;
}
function comBkgCallPop0204_position(pos) {
	var formObj=document.form;
	dgPosition=pos;
	var param="?imdg_un_no=" + eval("formObj.imdg_un_no__" + pos).value + "&imdg_amdt_no=" + eval("formObj.imdg_amdt_no__" + pos).value;
	ComOpenPopup("ESM_BKG_0204.do"+param, 900, 410, "setCallBack0204", '1,0,1,1,1,1,1', true, false, 0, 0, 0, "ESM_BKG_0204");
}
function setCallBack0204(aryPopupData) {
	var formObj=document.form; 
	eval("formObj.imdg_un_no__" + dgPosition).value=aryPopupData[0][2];
	eval("formObj.imdg_un_no_seq__" + dgPosition).value = aryPopupData[0][3];									//2015.01.15. kimtagkyun. 
	eval("formObj.imdg_clss_cd__" + dgPosition).value=aryPopupData[0][4];
	eval("formObj.imdg_comp_grp_cd__" + dgPosition).value = aryPopupData[0][5];									//2015.01.15. kimtagkyun. 
	eval("formObj.prp_shp_nm__" + dgPosition).value=aryPopupData[0][7];
	eval("formObj.imdg_pck_grp_cd__" + dgPosition).value=aryPopupData[0][6];
	eval("formObj.imdg_amdt_no__" + dgPosition).value=aryPopupData[0][36];
	console.log(aryPopupData);
	if(aryPopupData[0][7].indexOf("N.O.S") > -1){
		eval("formObj.imdg_segr_grp_no__" + dgPosition).value='0';
	}else if(aryPopupData[0][35] == ''){
		eval("formObj.imdg_segr_grp_no__" + dgPosition).value='';
	}
	doSaveCopy();
}
function comBkgCallPop0207_position(cd, pos) {
	var bkg_no=parent.frames["t1frame"].document.form.bkg_no.value;
	ComOpenPopup("ESM_BKG_0207.do?bkg_no="+bkg_no+"&ridr_tp_cd=D&open_tp_cd=D", 625, 320, "", "0,0,1,1,1,1,1", true);
//	var formObj = document.form;
//	dgPosition = pos;
//	var param = "?bkg_no=" + formObj.bkg_no.value + "&ridr_tp_cd=" + cd;
//	ComOpenWindow("/opuscntr/ESM_BKG_0207.do" + param, "PopupEsmBkg0207",
//			"dialogWidth:525px; dialogHeight:550px", true);
}


/////////////// D/G Rider //////////// //2015.01.15. kimtagkyun /////////////////////////////////////////////
function showDgRider() {
	if (document.all.dgRider.style.visibility == 'hidden'){
		document.all.dgRider.style.visibility = 'visible';
		document.all.dgRider.style.top=(document.getElementById("btn_dgRider").offsetTop - 12)+"px";
		document.all.dgRider.style.left=(document.getElementById("btn_dgRider").offsetLeft - 410)+"px";
		sheetObjects[0].SetVisible(true);
	}
	else {
		hiddenSelectForm();
		document.all.dgRider.style.visibility = 'hidden';
		sheetObjects[0].SetVisible(false);
	}		
}

function showDgRider2() {
	if (document.all.dgRider2.style.visibility == 'hidden'){
		document.all.dgRider2.style.visibility = 'visible';
		document.all.dgRider2.style.top=(document.getElementById("btn_dgRider2").offsetTop - 12)+"px";
		document.all.dgRider2.style.left=(document.getElementById("btn_dgRider2").offsetLeft - 390)+"px";
		sheetObjects[1].SetVisible(true);
	}
	else {
		hiddenSelectForm2();
		document.all.dgRider2.style.visibility = 'hidden';
		sheetObjects[1].SetVisible(false);
	}		
}

/**
 * 마우스 다운 이벤트
 * @param Button
 * @param Shift
 * @param X
 * @param Y
 * @return
 */
var current_Row = 0;
var current_Equal = false;
function div1sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

	var m_row = sheetObjects[0].MouseRow();
	var m_col = sheetObjects[0].MouseCol();
	
	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 130;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe01.document.getElementById('ContainerList').innerHTML = opusCheckBoxString;
				//보여주기 
				showSelectForm(gtop, gleft);
			} else {
				//감추기 
				hiddenSelectForm();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm();
		}
	} catch (ex) {
//		alert("----div1sheet1_OnMouseDown exception !!");
//		alert(ex);
		bkg_error_alert('sheet1_OnMouseDown', ex);
		return false;
	}
}

function div2sheet1_OnMouseDown(Button, Shift, X, Y) {
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

	var m_row = sheetObjects[1].MouseRow;
	var m_col = sheetObjects[1].MouseCol;

	try {
		//4번째 컬럼에서만 팝업창 열림 
		if (m_row > 0 && m_col == 5) {
			if (Bkg_div.style.visibility == "hidden") {
				
				//초기 마우스 클릭 ROW 위치 
				if (m_row == current_Row) {
					current_Equal = true;
				} else {
					current_Row = m_row;
				}
				//layer 왼쪽 좌표 
				var gleft = sheetObj.ColLeft(m_col) - 200;
				//layer 위쪽 좌표 
				var gtop = 60 + sheetObj.RowTop(m_row) + sheetObj.RowHeight(m_row);
				//select box 리스트 다시 렌더링 초기화 
				iframe02.document.getElementById('ContainerList').innerHTML = xterCheckBoxString;
				//보여주기 
				showSelectForm2(gtop, gleft);

			} else {
				//감추기 
				hiddenSelectForm2();
			}
		} else if (m_row > 0 && m_col == 2) {
			// 파일 다운로드 처리 
		} else {
			//그 이외의 컬럼이 눌리면  팝업 닫기
			hiddenSelectForm2();
		}
	} catch (ex) {
//		alert("----div2sheet1_OnMouseDown exception 2 !!");
		bkg_error_alert('sheet1_OnMouseDown', ex);
//		alert(ex);
		return false;
	}
}

/**
 * opus
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck();

			if (count_checked > 1) {
				sheetObjects[0].SetCellImage(current_Row, "multiPopup",0);
			} else {
				sheetObjects[0].SetCellImage(current_Row, "multiPopup",1);
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm', ex);
		return false;
	}
}
 
/**
 * e-svc
 * 숨기기 multiSelectFrame   이벤트 발생
 * @param void
 */
function hiddenSelectForm2() {
	var formObj = document.form;
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);
//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd2))
//		return;
	try {
		if (Bkg_div.style.visibility == "visible") {
			Bkg_iframe.style.visibility = "hidden";
			Bkg_div.style.visibility = "hidden";

			// 값 셋팅하기 
			setMultiSelectCheck2();

			if (count_checked2 > 1) {
				sheetObjects[1].SetCellImage(current_Row, "multiPopup", 0);
			} else {
				sheetObjects[1].SetCellImage(current_Row, "multiPopup", 1);
			}
		}
	} catch (ex) {
		bkg_error_alert('hiddenSelectForm2', ex);
		return false;
	}
}

/**
 * opus
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked = 0;
function setMultiSelectCheck() {
	try {
		var t_ck = iframe01.document.getElementsByName('t_check');
		var t_nm = iframe01.document.getElementsByName('t_name');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked++;
			}
		}

		sheetObjects[0].SetCellValue(current_Row, "dcgo_seq",r_value);
		sheetObjects[0].SetCellValue(current_Row, "cargo_contain",r_text);
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck', ex);
		return false;
	}
}

/**
 * e-svc
 * setMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 구한다. 
 */
var count_checked2 = 0;
function setMultiSelectCheck2() {
	try {
		var t_ck = iframe02.document.getElementsByName('t_check2');
		var t_nm = iframe02.document.getElementsByName('t_name2');
		if (t_nm.length == 0)
			return;
		var r_value = '';
		var r_text = '';
		var _flag = false;
		count_checked2 = 0;// initial 
		for (i = 0; i < t_ck.length; i++) {
			if (t_ck[i].checked) {
				if (!_flag)
					r_text = t_nm[i].value;
				if (_flag)
					r_value += ',';
				r_value += t_ck[i].value;
				_flag = true;
				count_checked2++;
			}
		}

		sheetObjects[1].SetCellValue(current_Row, "dcgo_seq", r_value);
		sheetObjects[1].SetCellValue(current_Row, "cargo_contain", r_text);
	} catch (ex) {
		bkg_error_alert('setMultiSelectCheck2', ex);
		return false;
	}
}
/**
 * 멀티 SELECT 이벤트 DIV Layer창 생성 
 * 
 */
function divLayer_Config() {
	var iframeHTML 	= 'apps/opus/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargorider/jsp/ESM_BKG_0207.HTML';
	
	//opus
	var _divWait=document.createElement("div");
	_divWait.id = BKG_DIV_NAME;
	_divWait.name = "div01";
	_divWait.style.position = "absolute";
	_divWait.style.cursor = "wait";
	_divWait.style.left = "0px";
	_divWait.style.top = "0px";
	_divWait.style.width =" 100px"; //100%였는데 100%로 하면 이상함
	_divWait.style.height = "100px";//100%였는데 100%로 하면 이상함 
	_divWait.style.zIndex = "999"; 
	_divWait.style.visibility = "hidden";
	$('body').prepend(_divWait);
	
	var _frameWait=document.createElement("iframe");
	_frameWait.id = BKG_FRAME_NAME;
	_frameWait.name = "iframe01";
	_frameWait.src = iframeHTML;
	_frameWait.frameborder = "1px";
	_frameWait.marginHeight = "0px";
	_frameWait.marginWidth = "0px";
	_frameWait.width = iframeW+"px";
	_frameWait.height = iframeH+"px";
	_frameWait.style.position = "absolute";
	
	_divWait.appendChild(_frameWait);
	
	//e-svc
	var _divWait2=document.createElement("div");
	_divWait2.id = BKG_DIV_NAME2;
	_divWait2.name = "div02";
	_divWait2.style.position = "absolute";
	_divWait2.style.cursor = "wait";
	_divWait2.style.left = "0px";
	_divWait2.style.top = "0px";
	_divWait2.style.width =" 100px"; //100%였는데 100%로 하면 이상함
	_divWait2.style.height = "100px";//100%였는데 100%로 하면 이상함 
	_divWait2.style.zIndex = "999"; 
	_divWait2.style.visibility = "hidden";
	$('body').prepend(_divWait2);
	
	var _frameWait2=document.createElement("iframe");
	_frameWait2.id = BKG_FRAME_NAME2;
	_frameWait2.name = "iframe02";
	_frameWait2.src = iframeHTML;
	_frameWait2.frameborder = "1px";
	_frameWait2.marginHeight = "0px";
	_frameWait2.marginWidth = "0px";
	_frameWait2.width = iframeW+"px";
	_frameWait2.height = iframeH+"px";
	_frameWait2.style.position = "absolute";
	
	_divWait2.appendChild(_frameWait2);
	
//	var iframeHTML = 'apps/opus/esm/bkg/bookingconduct/specialcargobookingconduct/specialcargorider/jsp/ESM_BKG_0207.HTML';
//	
//	//opus
//	var _divWait = document.createElement("<div id='" + BKG_DIV_NAME + "'  name='div01'  style='position:absolute; cursor:wait; left:0px; top:0px; width:100%; height:100%; z-index:999; visibility:hidden;' />");
//	document.body.insertBefore(_divWait);
//
//	var _frameWait = document.createElement("<IFRAME id='" + BKG_FRAME_NAME + "' name='iframe01' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
//	_divWait.appendChild(_frameWait);
//	//e-svc
//	var _divWait2 = document.createElement("<div id='" + BKG_DIV_NAME2 + "'  name='div02'  style='position:absolute; cursor:wait; left:550px; top:0px; width:190px; height:100%; z-index:999; visibility:hidden;'/>");
//	document.body.insertBefore(_divWait2);
//	
//	var _frameWait2 = document.createElement("<IFRAME id='" + BKG_FRAME_NAME2 + "' name='iframe02' src='" + iframeHTML + "' frameborder=0 marginHeight=0 marginWidth=0 width=" + iframeW + " height=" + iframeH + " style='position:absolute;' />");
//	_divWait2.appendChild(_frameWait2);
}

/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm(topPos, leftPos) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var Bkg_div = document.getElementById(BKG_DIV_NAME);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {

		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}
		
		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;

		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.GetCellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}
 
/**
 * 보이기 multiSelectFrame  이벤트 발생
 * @param topPos    상단 좌표 
 * @param leftPos    왼쪽 좌표 
 */
function showSelectForm2(topPos, leftPos) {

	var formObj = document.form;
	var sheetObj = sheetObjects[1];
	var Bkg_div = document.getElementById(BKG_DIV_NAME2);
	var Bkg_iframe = document.getElementById(BKG_FRAME_NAME2);

//	if ('B' == ComGetObjValue(formObj.ridr_tp_cd))
//		return;

	try {
		if (current_Equal) {
			//포커스 강제설정 
			sheetObj.SelectCell(current_Row, "cargo_contain", false);
			current_Equal = false;
		}

		Bkg_iframe.style.left = leftPos;
		Bkg_iframe.style.top = topPos;

		if (current_Row < 0)
			current_Row = 1;
		// 눌렀을 경우  check 여부 셋팅하기 
		var _check = sheetObj.GetCellText(current_Row, "dcgo_seq");
		if (typeof _check != null || typeof _check != "undefined" || _check != "") {
			getMultiSelectCheck2(_check);
		}

		Bkg_div.style.visibility = "visible";
		Bkg_iframe.style.visibility = "visible";

		Bkg_div.focus();
	} catch (ex) {
		bkg_error_alert('showSelectForm', ex);
		return false;
	}
}

/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck(_check) {
	try {
		var t_nm = iframe01.document.getElementsByName('t_check');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck', ex);
		return false;
	}
}
 
/**
 * getMultiSelectCheck  이벤트 발생
 * 값에 따라서 value값을 체크한다. 
 */
function getMultiSelectCheck2(_check) {
	try {
		var t_nm = iframe02.document.getElementsByName('t_check2');
		var arrRow = _check.split(",");
		for (idx = 0; idx < arrRow.length; idx++) {
			for (i = 0; i < t_nm.length; i++) {
				if (arrRow[idx] == t_nm[i].value) {
					t_nm[i].checked = true;
				}
			}
		}
	} catch (ex) {
		bkg_error_alert('getMultiSelectCheck2', ex);
		return false;
	}
}

function createDgRiderCntrHtml() {
	var oCell1 = "";	
	oCell1 = oCell1 + "<table width=\'100px\' class=\'grid2\' border=\'0\' id= \'t_table\'>\n";
	var selectedRowCnt = 0;
	var cntrList ="";
	if(sheetObjects[2].RowCount >= 1) {		
		for ( var row = 1; row <= sheetObjects[2].LastRow; row++) {
				if( (sheetObjects[2].CellValue(row, "cntr_no").length > 0 &&  cntrList.indexOf(sheetObjects[2].CellValue(row, "cntr_no" )) < 0 ) ||
						sheetObjects[2].CellValue(row, "cntr_no").length == 0	) {
					
					cntrList = cntrList + sheetObjects[2].CellValue(row,"cntr_no");
					selectedRowCnt++;
					oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10px\' align=\'center\'>";
					oCell1 = oCell1 + "<input type=\'checkbox\' name=\'t_check\'  value=\'"+sheetObjects[2].CellValue(row,"dcgo_seq")+"\'></td>";
					oCell1 = oCell1 + "<td width=\'90px\' align=\'center\'>"+sheetObjects[2].CellValue(row,"cntr_no")+" / "+ sheetObjects[2].CellValue(row,"cntr_cgo_seq")+"</td>";
					oCell1 = oCell1 + "<input type=\'hidden\' name=\'t_name\' value=\'"+sheetObjects[2].CellValue(row,"cntr_no")+" / "+ sheetObjects[2].CellValue(row,"cntr_cgo_seq")+"\'></tr>";
				}
		}
		if( selectedRowCnt == 0 ){
			oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10px\' align=\'center\'>";
			oCell1 = oCell1 + "no data... </td></tr>";
		}
	} else {
		oCell1 = oCell1 + "<tr class=\'tr2_head\'><td width=\'10px\' align=\'center\'>";
		oCell1 = oCell1 + "no data... </td></tr>";
	}
	oCell1 = oCell1 + "</table>";
	opusCheckBoxString = oCell1;
}

/**
 * 파일 다운받기 <br>
 * @param {ibsheet} sheetObj    IBSheet Object
 * @param {ibsheet} Row     	sheetObj의 선택된 Row
 * @param {ibsheet} Col     	sheetObj의 선택된 Col
 * @param {String} 	Value     	파일명
 **/
function div1sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Col != 2) return;
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/opus/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

function div2sheet1_OnClick(sheetObj, Row, Col, Value) {
	if (Col != 2) return;
	
	// 파일이 존재시 다운로드 받는다.
	var key_id = sheetObj.CellValue(Row, "file_sav_id");
	var exist = fnSaveFileExist(key_id , sheetObj);
	
	// 서버에 파일존재유무확인
	if(eval(exist)){
		hiddenFrame.location.href = "/opus/FileDownload?key=" + key_id;
	}else{
		ComShowMessage(ComGetMsg("BKG08127"));
	}	
}

/**
 * 파일존재유무판단  
 * file_id 번호로 file_path_url 확인후 파일존재확인 함수 
 * param :file_id
 * return :boolean
 */
function fnSaveFileExist(file_id,sheetObj) {
	var formObj = document.form;
	var param = "&f_cmd=" + COMMAND08 + "&input_text=" + file_id;
	var sXml = sheetObj.GetSearchXml("ESM_Booking_UtilGS.do", param);
	var output_text = ComGetEtcData(sXml, "output_text");
	return output_text;
}

/////////////// D/G Rider //////////// //2015.01.15. kimtagkyun /////////////////////////////////////////////


/**
 * Allow All Char but Eng to Upper
 */
 function allowAllCharsButEngup() {
 	event.target.value = event.target.value.toUpperCase();
 }  

 function cntrCgoSeqChange(seq, el){
	 if(el.value == ''){
		 el.value = sheetObjects[2].GetCellValue(seq, 'cntr_cgo_seq');
	 }else{
		 sheetObjects[2].SetCellValue(seq, 'cntr_cgo_seq', el.value);
	 }
 }
 
 function cntrSeqChange(seq, el){
	 if(el.value == ''){
		 el.value = sheetObjects[2].GetCellValue(seq, 'dg_cntr_seq');
	 }else{
		 sheetObjects[2].SetCellValue(seq, 'dg_cntr_seq', el.value);
	 }
	 
 }
 
 
