/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : esm_bkg_0216.js
 *@FileTitle  : China: Cross-Check & Download
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/09/08
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------Added code to make a good JSDoc ------------------*/
/**
 * @fileoverview JavaScript File is commonly using. calendar functions have is defined.
 * @author
 */

//Common global variable
var sheetObjects=new Array();
var sheetCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;


//Event handler processing by button name */
function processButtonClick(){
	/*****  Tab ->two or more sheet : sheet  a variable assignment *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				formObject.check_data_download.value="1";
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			case "btn_new":
				doActionIBSheet(sheetObject1,formObject,IBRESET);
			break;
			case "btn_save_as":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
			case "btn_save_csv":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			case "btn_down":
				doActionIBSheet(sheetObject1,formObject,IBINSERT);
			break;
			case "btn_bkg_main":
				doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
			break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
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
	//The required events on the screen
	axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
	axon_event.addListenerForm("Click","obj_Click", document.form);
	//axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	// China ID only when a button the enabled // But, now it's not used(JSP-> saveCsvFlg=true)
	if(!saveCsvFlg){
		ComBtnDisable("btn_save_csv");
	}
	document.form.vvd.focus();
}


/**
 * Focus Event
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
	var srcValue=window.event.srcElement.getAttribute("value");
	var srcName=ComGetEvent("name");
	if ( (  srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}


function obj_Click() {
	var formObject = document.form;
	var currType = formObject.curr_type.value;
	var srcValue = window.event.srcElement.getAttribute("value");
	var srcName = ComGetEvent("name");
	var sheetObj = sheetObjects[0];
	if (srcName == "trans_type" && currType != srcValue){
		sheetObj.RemoveAll();
		formObject.bl_cnt.value = 0;
		formObject.cntr_cnt.value = 0;
		formObject.bl_cnt_vvd2.value = 0;
		formObject.cntr_cnt_vvd2.value = 0;
		formObject.curr_type.value = srcValue;
	}
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
			with (sheetObj) {

				var HeadTitle1= "|Sel.|Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|TP|TR|DG|RF|CNTR|Download\nStatus|Download\nStatus|Transmission Status|Transmission Status|Orginal\nVVD" +
								// Hidden column
								"|dl_chk_flg|down_csv";
				var HeadTitle2= "|Sel.|Seq.|B/L No.|BKG No.|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|Seal|N|A|N|A|N|A|TP|TR|DG|RF|CNTR|Download\nStatus|Download\nStatus|Transmission Status|Transmission Status|Orginal\nVVD" +
								// Hidden column
								"|dl_chk_flg|down_csv";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",   Hidden:1, Width:0,   Align:"Center", SaveName:"ibflag" },
							{Type:"CheckBox", Hidden:0, Width:45,  Align:"Center", SaveName:"Chk" },
							{Type:"Seq",      Hidden:0, Width:30,  Align:"Center", SaveName:"Seq",            Edit:0 },
							{Type:"Text",     Hidden:0, Width:100, Align:"Center", SaveName:"bl_no",          Edit:0 },
							{Type:"Text",     Hidden:0, Width:100, Align:"Center", SaveName:"bkg_no",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:60,  Align:"Center", SaveName:"pol_cd",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:60,  Align:"Center", SaveName:"pod_cd",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:60,  Align:"Center", SaveName:"del_cd",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"pck_qty",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"pck_tp_cd",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"act_wgt",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"wgt_ut_cd",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"seal_no_flg",    Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"seal_knd_flg",   Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"sealer_cd_flg",  Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"shpr_nm",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"shpr_addr",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"cnee_nm",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"cnee_addr",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"ntfy_nm",        Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"ntfy_addr",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"bkg_cgo_tp_cd",  Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"tr",             Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"dcgo_flg",       Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"rc_flg",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:40,  Align:"Center", SaveName:"cntr_cnt",       Edit:0 },
							{Type:"Text",     Hidden:0, Width:30,  Align:"Center", SaveName:"dl_flg",         Edit:0 },
							{Type:"Text",     Hidden:0, Width:130, Align:"Center", SaveName:"mf_dl_dt",       Edit:0 },
							{Type:"Text",     Hidden:0, Width:70,  Align:"Center", SaveName:"trsm_msg_tp_id", Edit:0 },
							{Type:"Text",     Hidden:0, Width:130, Align:"Center", SaveName:"mf_snd_dt",      Edit:0 },
							{Type:"Text",     Hidden:0, Width:80,  Align:"Center", SaveName:"o_vvd",          Edit:0 },

							{Type:"Text",     Hidden:1, Width:10,  Align:"Left",   SaveName:"dl_chk_flg" },
							{Type:"Text",     Hidden:1, Width:100, Align:"Left",   SaveName:"down_csv" } ];
				InitColumns(cols);

				SetEditable(1);
				SetSheetHeight(340);
				SetCountPosition(0);
				SetRangeBackColor(1,3,1,20,"#555555");

			}
			sheetObj.SetMergeCell(0, 26, 2, 2);
			sheetObj.SetMergeCell(0, 28, 2, 2);
			break;

		case "sheet2":      //sheet1 init
			with (sheetObj) {

				var HeadTitle="flag||Seq|B/L No.|BKG No.";
				var headCount=ComCountHeadTitle(HeadTitle);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",    Hidden:0, Width:50,   Align:"Center",  SaveName:"ibflag" },
							{Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  SaveName:"Chk" },
							{Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  SaveName:"Seq" },
							{Type:"Text",      Hidden:0, Width:90,   Align:"Center",  SaveName:"bl_no" },
							{Type:"Text",      Hidden:0, Width:100,  Align:"Center",  SaveName:"bkg_no" } ];

				InitColumns(cols);

				SetEditable(1);
				SetVisible(0);

			}
			break;
	}
}


/**
 * Post-processing
 * @param sheetObj
 * @param ErrMsg
 * @return
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var formObj = document.form;
	var vvd1 = formObj.vvd.value;
	var vvd2 = formObj.vvd2.value;
	var blCnt = 0;
	var cntrCnt = 0;
	var blCntVvd2 = 0;
	var cntrCntVvd2 = 0;
	for (var i=sheetObj.HeaderRows(); i<=sheetObj.LastRow(); i++) {
		for (var j=8; j<20; j++){
			if (sheetObj.GetCellValue(i, j) == 'N') {
				sheetObj.SetCellFontColor(i, j, "#FF0000");
			}
		}
		var oVvd = sheetObj.GetCellValue(i, "o_vvd");
		if (oVvd == vvd1) {
			blCnt++;
			cntrCnt += parseInt(ComNullToZero(sheetObj.GetCellValue(i, "cntr_cnt")));

		} else if (oVvd == vvd2) {
			blCntVvd2++;
			cntrCntVvd2 += parseInt(ComNullToZero(sheetObj.GetCellValue(i, "cntr_cnt")));
		}
	}

	formObj.bl_cnt.value = ComAddComma(blCnt);
	formObj.cntr_cnt.value = ComAddComma(cntrCnt);
	formObj.bl_cnt_vvd2.value = ComAddComma(blCntVvd2);
	formObj.cntr_cnt_vvd2.value = ComAddComma(cntrCntVvd2);
}


function sheet1_OnChange(sheetObj, row, col, val) {
	var sheetObj2 = sheetObjects[1];
	if(sheetObj.ColSaveName(col) == "Chk"){
		sheetObj2.SetCellValue(row-1, "Chk",sheetObj.GetCellValue(row, "Chk"),0);
	}
}


/**
 * Booking Creation Screen move
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
	var sParam="&bl_no="+sheetObj.GetCellValue(Row,"bl_no")+"&bkg_no="+sheetObj.GetCellValue(Row,"bkg_no");
	ComOpenWindowCenter("ESM_BKG_0079_POP.do?pgmNo=ESM_BKG_0079"+sParam, "ESM_BKG_0079", 1200, 660);
}


/**
 * Sheet handling process
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if (!validateForm(sheetObj,formObj,sAction)) return false;

			ComOpenWait(true);

			formObj.f_cmd.value = SEARCH;
			formObj.gubun.value = "";
			if (formObj.loc_nm.value == "POL") {
				formObj.loc_cd.value = formObj.pol_cd.value;
			} else if(formObj.loc_nm.value == "POD"){
				formObj.loc_cd.value = formObj.pod_cd.value;
			}

			formObj.call_sgn_no.value = "";
			formObj.pre_port.value = "";
			formObj.nxt_port.value = "";
			formObj.vps_eta_dt.value = "";
			formObj.vps_etd_dt.value = "";
			formObj.vps_etb_dt.value = "";
			formObj.vsl_eng_nm.value = "";
			sheetObj.RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObj.CheckAll("Chk", 0, 1);
			sheetObjects[1].CheckAll("Chk", 0, 1);

			var sXml = sheetObj.GetSearchData("ESM_BKG_0216GS.do", FormQueryString(formObj));
			if (ComGetEtcData(sXml, ComWebKey.Trans_Result_Key) != "S") {
				// 에러메세지 출력
				ComShowMessage(ComResultMessage(sXml));
				ComOpenWait(false);

			} else {
				var wMsg = (ComGetEtcData(sXml, "dl_chk_flg") == "null" ? "" : ComGetEtcData(sXml, "dl_chk_flg").trim());
				var vpsEtaDt = ComGetEtcData(sXml, "vps_eta_dt") == "null" ? "" : ComGetEtcData(sXml, "vps_eta_dt")
				if (formObj.vvd2.value.length > 0 && wMsg.length > 0 && wMsg.substr(0, 1) != "Y" &&
					!ComShowConfirm ("POD[CNSHA] ETA is different each other :\n" +
									 "[VVD1 : " + formObj.vvd.value + "] - " + vpsEtaDt + " and\n" +
									 "[VVD2 : " + formObj.vvd2.value + "] - " + wMsg.substr(1) + ".\n" +
									 "Would you continue?")) {
					ComSetFocus(formObj.vvd2);
				} else {
					var sheetObj2 = sheetObjects[1];
					sheetObj.LoadSearchData(sXml, {Sync:1});
					sheetObj2.LoadSearchData(sXml, {Sync:1});
					if (sheetObj.GetTotalRows() > 0) {
						if (formObj.check_data_download.value == '1') {
							sheetObj.CheckAll("Chk", 1, 1);
							sheetObj2.CheckAll("Chk", 1, 1);
						}
					}

					formObj.call_sgn_no.value = ComGetEtcData(sXml, "call_sgn_no") == null ? "" : ComGetEtcData(sXml, "call_sgn_no");
					formObj.pre_port.value = ComGetEtcData(sXml, "pre_port") == null ? "" : ComGetEtcData(sXml, "pre_port");
					formObj.nxt_port.value = ComGetEtcData(sXml, "nxt_port") == null ? "" : ComGetEtcData(sXml, "nxt_port");
					formObj.vps_eta_dt.value = ComGetEtcData(sXml, "vps_eta_dt") == null ? "" : ComGetEtcData(sXml, "vps_eta_dt");
					formObj.vps_etd_dt.value = ComGetEtcData(sXml, "vps_etd_dt") == null ? "" : ComGetEtcData(sXml, "vps_etd_dt");
					formObj.vps_etb_dt.value = ComGetEtcData(sXml, "vps_etb_dt") == null ? "" : ComGetEtcData(sXml, "vps_etb_dt");
					formObj.vsl_eng_nm.value = ComGetEtcData(sXml, "vsl_eng_nm") == null ? "" : ComGetEtcData(sXml, "vsl_eng_nm");
					if (formObj.check_data_download.value == '2') this.chkDataDownload(sheetObj, formObj,'2');
				}
			}

			ComOpenWait(false);
		break;

		case IBRESET:        //New
			formObj.reset();
			sheetObjects[0].RemoveAll();
			//sheetObjects[0].Render(1);
			sheetObjects[1].RemoveAll();
			//sheetObjects[0].Render(0);
			sheetObjects[0].CheckAll("Chk",0,1);
			sheetObjects[1].CheckAll("Chk",0,1);
			formObj.vvd.focus();
		break;

		case IBDOWNEXCEL:    //Save As
			if (sheetObj.RowCount()== 0 ) {
				ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
				return;
			} else {
				sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 } );
			}
		break;

		case IBSAVE:    //Save CSV
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
			formObj.f_cmd.value=SEARCH01;
			formObj.gubun.value="csv";
			ComOpenWait(true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_0216GS.do", FormQueryString(formObj));
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if (State == "S") {
				if (ComGetEtcData(sXml,"total") == "0") {
					//ComOpenWait(false);
					ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
					ComOpenWait(false);
					return;
				} else {
					ComOpenWait(true);
					formObj.f_cmd.value=COMMAND01;
					var sXml=sheetObj.GetSearchData("ESM_BKG_0216GS.do", FormQueryString(formObj));
					var down_csv=ComGetEtcData(sXml, "down_csv");
					sheetObj.SetCellText(2, "down_csv" ,down_csv);
					var sDate=formObj.date.value;
					var sFileName="China Cross Check and Download_" + getCurrentTime() + ".csv"
					ComOpenWait(false);
					sheetObj.Down2Text({ ColDelim:"",DownCols:"32",FileName:sFileName,DownHeader:false} );
				}
			} else {
				//sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//sheetObj.RenderSheet(1);
			}
		break;

		case IBINSERT:      //Download
			//if(!validateForm(sheetObj,formObj,sAction)) return false;
			var chkNm = Number(sheetObj.CheckedRows(1));
			this.chkDataDownload(sheetObj, formObj, "1");
			var reChkNm = Number(sheetObj.CheckedRows(1));
			var gapChkNm = Number(chkNm)-Number(reChkNm);
			var unChk = Number(sheetObj.RowCount())-Number(sheetObj.CheckedRows(1)); //unchecked count

			if (sheetObj.CheckedRows(1) == 0) {
				ComShowCodeMessage("BKG08192"); // "Seal Information is mandatory. \nPlease insert seal number / kind / code."
				return;
			}

			if(sheetObj.CheckedRows(1) > 0){
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sParam=FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
				var sXml=sheetObj.GetSaveData("ESM_BKG_0216GS.do", sParam);
				if(ComBkgErrMessage(sheetObjects[0], sXml)) {
					//If the download takes than 30 seconds -> 3 seconds BackEndJob
					var key=ComGetEtcData(sXml, "KEY");
					intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "','" + unChk + "','" + gapChkNm + "','" + chkNm + "');", 6000);
				}
			}
		break;

		case IBROWSEARCH:
			if (sheetObj.GetTotalRows()== 0) {
				//선택된 내역이 없을경우
				ComShowCodeMessage("BKG00249"); // No Selected Row
			} else {
				var sParam="&bl_no="+sheetObj.GetCellValue(sheetObj.SetSelectRow,"bl_no")+"&bkg_no="+sheetObj.GetCellValue(sheetObj.GetSelectRow(),"bkg_no");
				ComOpenWindowCenter("ESM_BKG_0079_POP.do?pgmNo=ESM_BKG_0079"+sParam, "ESM_BKG_0079", 1200, 660);
			}
		break;
	}
}


/**
 * BackEndJob 상태 코드를 3초마다 읽어와서 성공,실패에 따라 처리
 * @param sheetObj
 * @param sKey
 * @return
 */
function doActionValidationResult(sheetObj, sKey, unChk, gapChkNm, chkNm) {
	var sXml=sheetObjects[0].GetSearchData("ESM_BKG_0216GS.do?f_cmd="+MULTI01+"&key="+sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	//에러가 발생했을 경우 대기사항을 종료한다.
	if(!ComBkgErrMessage(sheetObjects[0], sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		//성공메시지 보여주고
		//ComShowMessage(ComResultMessage(sXml));
		if(gapChkNm<1){
			ComShowCodeMessage("BKG08194");// Customs Data Created
		} else {
			ComShowCodeMessage("BKG00261", gapChkNm);
		}
		var aryDl=new Array(sheetObjects[0].RowCount());
		for(var i=2; i < sheetObjects[0].RowCount()+2; i++){
			if(sheetObjects[0].GetCellValue(i,"Chk") == 1){
				aryDl[i-2]='d';
			}else{
				aryDl[i-2]='';
			}
		}
		sheetObjects[0].CheckAll("Chk",0);
		//sheet1 다시 조회
		doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
		for(var i=0; i < aryDl.length; i++){
			if(aryDl[i] == 'd'){
				sheetObjects[0].SetCellValue(i+2, "Chk", "1");
				sheetObjects[1].SetCellValue(i+1, "Chk", "1");
			}else{
				sheetObjects[0].SetCellValue(i+2, "Chk", "0");
				sheetObjects[1].SetCellValue(i+1, "Chk", "0");
			}
		}
		return;
	} else if (sJbStsFlg == "FAIL") {
		//에러
		clearInterval(intervalId);
		ComOpenWait(false);
		//에러메시지 보여주고
		ComShowCodeMessage("BKG08195",chkNm);
		ComShowMessage(ComResultMessage(sXml));
	}
}


/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: // 조회
			if (!ComChkRequired(formObj)) return false;
			if (formObj.trans_mode.value != "D") return true;
			if (formObj.pod_cd.value.substring(0,2) == "CN") {
				if (formObj.pod_cd.value == "CNHKG") {
					ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
					return false;
				}
			} else {
				ComShowCodeMessage('BKG06036');   // Invalid POD. China port only.
				return false;
			}
			return true;
			break;
	}
}


/**
 * Data Download Handling Constration
 * when the value of Seal = Y,Y,Y
 */
function chkDataDownload(sheetObj,formObj, sw){
	formObj.check_data_download.value="2";
	var chkData="";
	var iChkCount=0;

	for (var i=2; i < sheetObj.RowCount()+2; i++) {
		if (sw == "1") {
			if(sheetObj.GetCellValue(i,"Chk") == "1"){
				if(sheetObj.GetCellValue(i,"bkg_cgo_tp_cd") == "P"){
					iChkCount++;
					sheetObj.SetCellValue(i,"Chk","1");

				}else{
					if(sheetObj.GetCellValue(i,"dl_chk_flg") == "Y"){
						iChkCount++;
						sheetObj.SetCellValue(i,"Chk","1");
					}else{
						chkData=sheetObj.GetCellValue(i,"bkg_cgo_tp_cd");
						if(formObj.trans_mode.value == "P" && (chkData == "T" || chkData == "F" || chkData == "A" )){
//							chkData = formObj.trans_mode.value + sheetObj.GetCellValue(i,'pck_qty')
//							+ sheetObj.GetCellValue(i,'pck_tp_cd') + sheetObj.GetCellValue(i,'act_wgt') + sheetObj.GetCellValue(i,'wgt_ut_cd');
//							if(chkData == 'PYYYY'){
							iChkCount++;
							sheetObj.SetCellValue(i,"Chk","1");
						}else{
							sheetObj.SetCellValue(i,"Chk","0");
						}
					}
				}
			}
		} else {
			if(sheetObj.GetCellValue(i,"bkg_cgo_tp_cd") == "P"){
				iChkCount++;
				sheetObj.SetCellValue(i,"Chk","1");
			}else{
				if(sheetObj.GetCellValue(i,"dl_chk_flg") == "Y"){
					iChkCount++;
					sheetObj.SetCellValue(i,"Chk","1");
				}else{
					sheetObj.SetCellValue(i,"Chk","0");
				}
			}
		}
	}

	if(iChkCount == 0){
		sheetObj.CheckAll("Chk", 0, 1);
	}
}


/**
 * 현재날짜 구한다.
 * @return
 */
function getCurrentTime() {
	 var now = new Date();
	 var y = now.getFullYear(); // 년도.
	 var mon = now.getMonth()+1; // 월 (월은 0부터 시작므로 +1을 해야 합니다.)
	 var td = now.getDate(); // 일 (일은 1부터 시작하므로 +1을 하면 안 됩니다.)
	 var h = now.getHours(); // 시
	 var min = now.getMinutes(); // 분
	 var s = now.getSeconds(); // 초
	 var ms = now.getMilliseconds(); //밀리세컨드 (1/1000초)
	 if (String(mon).length == 1) mon = '0' + mon;
	 if (String(td).length == 1) td = '0' + td;
	 if (String(h).length == 1) h = '0' + h;
	 if (String(min).length == 1) min = '0' + min;
	 if (String(s).length == 1) s = '0' + s;
	 return y+mon+td+h+min+s;
}
/* 개발자 작업  끝 */
