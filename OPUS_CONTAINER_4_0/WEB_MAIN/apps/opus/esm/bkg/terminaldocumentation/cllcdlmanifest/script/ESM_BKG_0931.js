/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0931.js
*@FileTitle  : Container Loading List(KOREA)_Print Preview 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/    

var sheetObjects=new Array();
var sheetCnt=0;
var state="";
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Summary":
			doActionIBSheet(sheetObject, formObject, COMMAND01);
			break;
		case "btn_Special_CGO":
			doActionIBSheet(sheetObject, formObject, COMMAND02);
			break;
		case "btn_Print":
			doActionIBSheet(sheetObject, formObject, COMMAND03);
			break;
		case "btn_Close":
			ComClosePopup();
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e);
		}
	}
}
/**
 * IBSheet Object瑜�諛곗뿴濡��깅줉
 * �ν썑 �ㅻⅨ ��ぉ�ㅼ쓣 �쇨큵泥섎━���꾩슂媛��덉쓣 ��諛곗뿴濡��대뒗 �꾨줈�몄뒪瑜�異붽������덈떎
 * 諛곗뿴���뚯뒪 �곷떒���뺤쓽
 * @param sheet_obj IBSheet Object
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
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
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
}

/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetId=sheetObj.id;
	switch (sheetId) {
	case "sheet1":
	    with(sheetObj){
       
      if (location.hostname != "")
      var HeadTitle1="Seq.|Container No.|TP|BKG No.|F/M|Seal No.|Weight|VGM|VGM\nTP|R/D|TS|Special Cargo|Special Cargo|Stow|PC|E.POD|A.POD|T/S VVD|T/S VSL NM|SIGNATORY";
      var headCount=ComCountHeadTitle(HeadTitle1);
      (headCount, 0, 0, true);

      SetConfig( { SearchMode:2, MergeSheet:2, Page:20, DataRowMerge:1 } );

      var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ 
             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"cntr_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"cntr_tpsz_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:"bkg_no",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:11 },
             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"mty_bkg_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"seal_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:15 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"bl_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Right",   ColMerge:0,   SaveName:"vgm_wgt",          KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"vgm_doc_tp_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1, EditLen:3 },
             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"rcv_term_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
             {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ts_flg",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:2 },
             {Type:"Text",      Hidden:0, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"cll_rmk1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"cll_rmk2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:100 },
             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"stwg_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"kr_tml_prct_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:1 },
//             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
//             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"blck_stwg_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:3 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"edi_pod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 },
             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ts_vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:9 } ,
             {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"ts_vsl_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:9 } ,
             {Type:"Text",      Hidden:0, Width:100,   Align:"Center",  ColMerge:0,   SaveName:"esig_co_nm",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 }];
       
      InitColumns(cols);
      SetSheetHeight(305);
      SetEditable(1);
      SetMergeSheet(eval('msHeaderOnly'));
      SetCountPosition(0);
      }
      break;


	}
}
/**
 * handling sheet process
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // search
		formObj.f_cmd.value=SEARCH;
		sheetObj.SetWaitImageVisible(0);
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData("ESM_BKG_0931GS.do",
				FormQueryString(formObj));
		//sheetObj.DoSearch("ESM_BKG_0931GS.do", FormQueryString(formObj) );
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
		}
		ComEtcDataToForm(formObj, sheetObjects[0]);
		state=sheetObj.GetEtcData("TRANS_RESULT_KEY");
		if (state == "S") {
			var d2=0;
			var d4=0;
			var d5=0;
			var d7=0;
			var d8=0;
			var d9=0;
			var dw=0;
			var dx=0;
			var r2=0;
			var r4=0;
			var r5=0;
			var f2=0;
			var f4=0;
			var f5=0;
			var o2=0;
			var o4=0;
			var o5=0;
			var s2=0;
			var s4=0;
			var t2=0;
			var t4=0;
			var a2=0;
			var a4=0;
			var p2=0;
			var p4=0;
			var z2=0;
			var z4=0;
			var d3=0;
			var r9=0;
			var etc=0;
			var totalTpSize=0;
			var local=0;
			var localFull=0;
			var localEmpty=0;
			var ts=0;
			var tsFull=0;
			var tsEmpty=0;
			var wgt=0;
			var vgm=0;
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "seq") == "") {
									sheetObj.SetRowEditable(i,0);
								}
				if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D2") {
									d2=d2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D4") {
									d4=d4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D5") {
									d5=d5 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D7") {
									d7=d7 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D8") {
									d8=d8 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D9") {
									d9=d9 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "DW") {
									dw=dw + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "DX") {
									dx=dx + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R2") {
									r2=r2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R4") {
									r4=r4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R5") {
									r5=r5 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F2") {
									f2=f2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F4") {
									f4=f4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "F5") {
									f5=f5 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O2") {
									o2=o2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O4") {
									o4=o4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "O5") {
									o5=o5 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "S2") {
									s2=s2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "S4") {
									s4=s4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "T2") {
									t2=t2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "T4") {
									t4=t4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "A2") {
									a2=a2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "A4") {
									a4=a4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "P2") {
									p2=p2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "P4") {
									p4=p4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "Z2") {
									z2=z2 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "Z4") {
									z4=z4 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "D3"){
									d3=d3 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
				else if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "R9"){
									r9=r9 + 1;
									totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
								}
								else{ 
				if(sheetObj.GetCellValue(i, "cntr_tpsz_cd") != ""){
										etc=etc + 1;
										totalTpSize=totalTpSize + 1;
				wgt=wgt + sheetObj.GetCellValue(i, "bl_wgt") * 1;
				vgm=vgm + sheetObj.GetCellValue(i, "vgm_wgt") * 1;
									}
								}
								if (formObj.in_cll_type.value == "TS") {
				if (sheetObj.GetCellValue(i, "seq") != "") {
										ts=ts + 1;
				if (sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
											tsFull=tsFull + 1;
										else
											tsEmpty=tsEmpty + 1;
									}
								} else {
				if (sheetObj.GetCellValue(i, "ts_flg") == "TS"
				|| sheetObj.GetCellValue(i, "ts_flg") == "TT") {
										ts=ts + 1;
				if (sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
											tsFull=tsFull + 1;
										else
											tsEmpty=tsEmpty + 1;
									}
				if (sheetObj.GetCellValue(i, "ts_flg") == ""
				&& sheetObj.GetCellValue(i, "seq") != "") {
										local=local + 1;
				if (sheetObj.GetCellValue(i, "mty_bkg_cd") == "F")
											localFull=localFull + 1;
										else
											localEmpty=localEmpty + 1;
									}
				}
			}
			formObj.d2.value=d2;
			formObj.d4.value=d4;
			formObj.d5.value=d5;
			formObj.d7.value=d7;
			formObj.d8.value=d8;
			formObj.d9.value=d9;
			formObj.dw.value=dw;
			formObj.dx.value=dx;
			formObj.r2.value=r2;
			formObj.r4.value=r4;
			formObj.r5.value=r5;
			formObj.f2.value=f2;
			formObj.f4.value=f4;
			formObj.f5.value=f5;
			formObj.o2.value=o2;
			formObj.o4.value=o4;
			formObj.o5.value=o5;
			formObj.s2.value=s2;
			formObj.s4.value=s4;
			formObj.t2.value=t2;
			formObj.t4.value=t4;
			formObj.a2.value=a2;
			formObj.a4.value=a4;
			formObj.p2.value=p2;
			formObj.p4.value=p4;
			formObj.z2.value=z2;
			formObj.z4.value=z4;
			formObj.d3.value=d3;
			formObj.r9.value=r9;
			formObj.etc.value=etc;
			formObj.totalTpSize.value=totalTpSize;
			formObj.local.value=local;
			formObj.localFull.value=localFull;
			formObj.localEmpty.value=localEmpty;
			formObj.ts.value=ts;
			formObj.tsFull.value=tsFull;
			formObj.tsEmpty.value=tsEmpty;
			formObj.wgt.value=wgt;
			formObj.wgt.value=ComGetMaskedValue(formObj.wgt.value, 'int');
			formObj.vgm.value=vgm;
			formObj.vgm.value=ComGetMaskedValue(formObj.vgm.value, 'int');
			for ( var i=1; i <= sheetObj.RowCount(); i++) {
				if (sheetObj.GetCellValue(i, "cntr_tpsz_cd") == "") {
					sheetObj.SetRowBackColor(i,"#C0C0C0");
				}
			}
		}
		ComOpenWait(false);
		break;
	case COMMAND01: 
		var sUrl="/opuscntr/ESM_BKG_0932.do?pgmNo=ESM_BKG_0932&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
//		location.href=sUrl;
		ComOpenWindowCenter(sUrl, "ESM_BKG_0932", 780, 730, false);
		break;
	case COMMAND02: 
		var sUrl="/opuscntr/ESM_BKG_0933.do?pgmNo=ESM_BKG_0933&inVvdCd="
				+ formObj.in_vvd_cd.value + "&inPolCcd="
				+ formObj.in_pol_cd.value + "&inPolYdCd="
				+ formObj.in_pol_yd_cd.value + "&inCllType="
				+ formObj.in_cll_type.value + "&inBkgStsCd="
				+ formObj.in_bkg_sts_cd.value + "&inCntrCfmFlg="
				+ formObj.in_cntr_cfm_flg.value + "&inSortType="
				+ formObj.in_sort_type.value
		location.href=sUrl;
		break;
	case COMMAND03: 
		ComOpenWindowCenter("/opuscntr/ESM_BKG_5006.do?pgmNo=ESM_BKG_5006",
				"5006", 950, 700, false);
		break;
	case IBINSERT: 
		sheetObj.DataInsert();
		break;
	case IBDOWNEXCEL:		
		sheetObj.Down2Excel();
		break;
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: 
		return true;
		break;
	case IBSAVE:
		return true;
		break;
	case COMMAND01:
		return true;
		break;
	case IBDELETE:
		return true;
		break;
	}
}