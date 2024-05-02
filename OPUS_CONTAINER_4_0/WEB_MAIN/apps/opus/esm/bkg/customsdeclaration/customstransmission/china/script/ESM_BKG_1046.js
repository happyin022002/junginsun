/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1046.js
*@FileTitle  : China: Manifest Transmission
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick(){
	/***** If sheets are more than 2 in one tab, use additional sheet variables *****/
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(sheetObject1,formObject,IBSEARCH);
			break;
			case "btn_new":
				doActionIBSheet(sheetObject1,formObject,IBRESET);
			break;
			case "btn_delete":
				doActionIBSheet(sheetObject1,formObject,IBDELETE);
			break;
			case "btn_excel":
				doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
			break;
			case "btn_save_csv":
				doActionIBSheet(sheetObject1,formObject,IBSAVE);
			break;
			case "btn_go_bl":
				doActionIBSheet(sheetObject1,formObject,IBROWSEARCH);
			break;
			case "btn_Transmit":
				doActionIBSheet(sheetObject2,formObject,IBSEARCH_ASYNC01);
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
* registering IBSheet Object as list
* adding process for list in case of needing batch processing with other items
* defining list on the top of source
*/
function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * set combo Object to comboObjects array
 * @param combo_obj
 * @return
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}
/**
 * Combo Object initialization
 * @param comboObj
 * @param comNo
 * @return
 */
function initCombo(comboObj, comboNo) {
	switch(comboObj.options.id) {
		case "msg_type":
			var i=0;
			with(comboObj) {
				SetColBackColor(0,"#CCFFFD");
				//SetDropHeight(200);
				SetMultiSelect(0);
				SetMaxSelect(1);
			}
			break;
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

	for(i=0; i < comboObjects.length; i++ ) {
		initCombo(comboObjects[i], i+1);
	}
	var formObj=document.form;
	//Event needed for screen
	// axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
	// axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);

	axon_event.addListenerForm("Click","obj_Click", document.form);
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');

	// combo data creation
	ComXml2ComboItem(formObj.code_list.value, msg_type, "attr_ctnt1", "attr_ctnt2");
	if(formObj.trans_mode.value == "D"){
		msg_type.SetSelectCode('0');
	}else{
		msg_type.SetSelectCode('9');
	}

	//  activate button in case of ID in china
	if(!saveCsvFlg){
		ComBtnDisable("btn_save_csv");
	}
	document.form.vvd.focus();
}
/**
 *  moving to next step if inputting up to Maxlength
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcMaxLength= ComGetEvent("maxlength");
	var srcValue= ComGetEvent("value");
	var srcName=ComGetEvent("name");
	if ( (  srcName == "vvd" || srcName == "pol_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}

function obj_Click() {
	var formObject=document.form;
	var currType=formObject.curr_type.value;
	var srcValue= ComGetEvent("value");
	var srcName=ComGetEvent("name");
	var sheetObj=sheetObjects[0];
	if ( srcName == "trans_type" && currType != srcValue){
		sheetObj.RemoveAll();
		formObject.bl_cnt.value=0;
		formObject.cntr_cnt.value=0;
		formObject.curr_type.value=srcValue;
	}
}

/**
* setting sheet initial values and header
* adding case as numbers of counting sheets
*/
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with(sheetObj) {
				var HeadTitle1 = "|Sel.|Seq.|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|TP|TR|DG Cargo|DG Cargo|DG Cargo|DG Cargo|RF|MEA|FRT|RCV|DE|CNTR|Transmission Status|Transmission Status" +
								 // Hidden column
								 "|bkg_pol_cd|bkg_pod_cd|down_csv";
				var HeadTitle2 = "|Sel.|Seq.|B/L No.|BKG No.|POL|POD|DEL|Package|Package|Weight|Weight|Seal|Seal|Seal|N|A|N|A|N|A|TP|TR|DG|NM|TEL|UN|RF|MEA|FRT|RCV|DE|CNTR|Transmission Status|Transmission Status" +
								 // Hidden column
								 "|bkg_pol_cd|bkg_pod_cd|down_csv";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

				var info = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [{Type:"Status",   Hidden:1,   Width:0,     Align:"Center",   SaveName:"ibflag" },
							{Type:"CheckBox", Hidden:0,   Width:40,    Align:"Center",   SaveName:"Chk" },
							{Type:"Seq",      Hidden:0,   Width:30,    Align:"Center",   SaveName:"Seq" },

							{Type:"Text",     Hidden:0,   Width:110,   Align:"Center",   SaveName:"bl_no",             },
							{Type:"Text",     Hidden:0,   Width:110,   Align:"Center",   SaveName:"bkg_no",            },
							{Type:"Text",     Hidden:0,   Width:60,    Align:"Center",   SaveName:"pol_cd",            },
							{Type:"Text",     Hidden:0,   Width:60,    Align:"Center",   SaveName:"pod_cd",            },
							{Type:"Text",     Hidden:0,   Width:60,    Align:"Center",   SaveName:"del_cd",            },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"pck_qty",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"pck_tp_cd",         },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"act_wgt",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"wgt_ut_cd",         },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"seal_no_flg",       },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"seal_knd_flg",      },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"sealer_cd_flg",     },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"shpr_nm",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"shpr_addr",         },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"cnee_nm",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"cnee_addr",         },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"ntfy_nm",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"ntfy_addr",         },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"bkg_cgo_tp_cd",     },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"tr",                },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"dcgo_flg",          },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"cntc_pson_nm",      },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"cntc_pson_telcm_no" },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"imdg_un_no",        },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"rc_flg",            },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"mea_qty",           },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"frt_term_cd",       },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"rcv_term_cd",       },
							{Type:"Text",     Hidden:0,   Width:30,    Align:"Center",   SaveName:"de_term_cd",        },
							{Type:"Text",     Hidden:0,   Width:45,    Align:"Center",   SaveName:"cntr_cnt",          },
							{Type:"Text",     Hidden:0,   Width:100,   Align:"Center",   SaveName:"trsm_msg_tp_id"     },
							{Type:"Text",     Hidden:0,   Width:110,   Align:"Left",     SaveName:"mf_snd_dt",    Format:"YmdHms" },

							{Type:"Text",     Hidden:1,   Width:50,    Align:"Center",   SaveName:"bkg_pol_cd",        },
							{Type:"Text",     Hidden:1,   Width:50,    Align:"Center",   SaveName:"bkg_pod_cd",        },
							{Type:"Text",     Hidden:1,   Width:100,   Align:"Left",     SaveName:"down_csv",          } ];
				InitColumns(cols);

				SetEditable(1);
				SetCountPosition(0);
				SetRangeBackColor(1, 1, 1, 40, "#555555");
				SetMergeCell(0, 35, 2, 2);
				SetSheetHeight(270);
			}
		break;

		case "sheet2":      //sheet2 init
			with(sheetObj) {
				var HeadTitle="flag||Seq.|B/L No.|BKG No.|bkg_pol_cd|bkg_pod_cd";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
				{Type:"CheckBox",  Hidden:0,   Width:30,    Align:"Center",   SaveName:"Chk" },
				{Type:"Seq",       Hidden:0,   Width:30,    Align:"Center",   SaveName:"Seq" },
				{Type:"Text",      Hidden:0,   Width:100,   Align:"Center",   SaveName:"bl_no"      },
				{Type:"Text",      Hidden:0,   Width:100,   Align:"Center",   SaveName:"bkg_no"     },
				{Type:"Text",      Hidden:0,   Width:100,   Align:"Center",   SaveName:"bkg_pol_cd" },
				{Type:"Text",      Hidden:0,   Width:100,   Align:"Center",   SaveName:"bkg_pod_cd" } ];
				InitColumns(cols);
				SetEditable(1);
				SetVisible(0);
			}
		break;

		case 3: //sheet3 init
			with(sheetObj) {
				var HeadTitle="RESULT";
				var headCount=ComCountHeadTitle(HeadTitle);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
				var info = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Text",   Hidden:0,   Width:25,   Align:"Center",   SaveName:"key" } ];
				InitColumns(cols);
				SetEditable(1);
				SetVisible(0);
			}
		break;
	}
}

/**
 *  handling after retrieve
 */
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {

	var tot_cntr=0;

	for (i=2; i<sheetObj.RowCount()+2; i++){
		for(j=8; j<20; j++){
			if(sheetObj.GetCellValue(i, j) == 'N'){
				sheetObj.SetCellFontColor(i, j, "#FF0000");
			}
		}
		tot_cntr=tot_cntr + parseInt(sheetObj.GetCellValue(i, "cntr_cnt"));
	}
	orgBlCnt=sheetObj.GetTotalRows();
	orgCntrCnt=tot_cntr;
	document.form.bl_cnt.value=ComAddComma(sheetObj.GetTotalRows());
	document.form.cntr_cnt.value=ComAddComma(tot_cntr);
}

/**
 * 시트의 체크박스 클릭 시 hidden 시트의 같은 row 체크박스 클릭
 */
function sheet1_OnChange(sheetObj, row, col, val) {
	var sheetObj2=sheetObjects[1];
	if(sheetObj.ColSaveName(col) == "Chk"){
		sheetObj2.SetCellValue(row-1, "Chk",sheetObj.GetCellValue(row, "Chk"),0);
	}
}

/**
 * To B/L Inquiry screen
 */
function sheet1_OnDblClick(sheetObj, Row, Col){
	var sParam="";
	var transMode=document.form.trans_mode.value;
	if( transMode == "P"){
		sParam += "pgmNo=ESM_BKG_0217-2&bl_no="+sheetObj.GetCellValue(Row,"bl_no")+"&trans_mode="+transMode;
	}else{
		sParam += "pgmNo=ESM_BKG_0217-1&bl_no="+sheetObj.GetCellValue(Row,"bl_no")+"&trans_mode="+transMode;
	}
	ComOpenWindowCenter("ESM_BKG_0217_POP.do?"+sParam, "ESM_BKG_0217", 1200, 600);
}

/**
 * handling sheet process
 */
function doActionIBSheet(sheetObj,formObj,sAction) {
	//sheetObj.ShowDebugMsg = false;
	sheetObj.SetWaitImageVisible(0);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			ComOpenWait(true, true);
			formObj.f_cmd.value=SEARCH;
			formObj.gubun.value="";
			if(formObj.loc_nm.value == "POL"){
				formObj.loc_cd.value=formObj.pol_cd.value;
			}
			else if(formObj.loc_nm.value == "POD"){
				formObj.loc_cd.value=formObj.pod_cd.value;
			}
			// sheetObj.RenderSheet(0);
			var sXml=sheetObj.GetSearchData("ESM_BKG_1046GS.do", FormQueryString(formObj));
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
			if(State == "S"){
				var sheetObj2=sheetObjects[1];
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj2.LoadSearchData(sXml,{Sync:1} );

				if(sheetObj.GetTotalRows()> 0){
					 sheetObj.CheckAll("Chk",1,1);
					 sheetObj2.CheckAll("Chk",1,1);
				}
				// sheetObj.RenderSheet(1);
				document.form.call_sgn_no.value=ComGetEtcData(sXml,"call_sgn_no") == "null" ? "" : ComGetEtcData(sXml,"call_sgn_no");
				document.form.pre_port.value=ComGetEtcData(sXml,"pre_port") 	 == "null" ? "" : ComGetEtcData(sXml,"pre_port");
				document.form.nxt_port.value=ComGetEtcData(sXml,"nxt_port") 	 == "null" ? "" : ComGetEtcData(sXml,"nxt_port");
				document.form.vps_eta_dt.value=ComGetEtcData(sXml,"vps_eta_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_eta_dt");
				document.form.vps_etd_dt.value=ComGetEtcData(sXml,"vps_etd_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etd_dt");
				document.form.vps_etb_dt.value=ComGetEtcData(sXml,"vps_etb_dt")  == "null" ? "" : ComGetEtcData(sXml,"vps_etb_dt");
				document.form.vsl_eng_nm.value=ComGetEtcData(sXml,"vsl_eng_nm")  == "null" ? "" : ComGetEtcData(sXml,"vsl_eng_nm");
				document.form.snd_date.value=ComGetEtcData(sXml,"snd_date")  == "null" ? "" : ComGetEtcData(sXml,"snd_date");
				document.form.eta_flg.value=ComGetEtcData(sXml,"eta_flg") == "null" ? "" : ComGetEtcData(sXml,"eta_flg");
				document.form.etd_flg.value=ComGetEtcData(sXml,"etd_flg") == "null" ? "" : ComGetEtcData(sXml,"etd_flg");
			} else {
				// error messege
				ComShowMessage(ComResultMessage(sXml));
			}
			 ComOpenWait(false);
		break;

		case IBRESET:    // New
			formObj.reset();
			sheetObjects[0].RemoveAll();
			sheetObjects[1].RemoveAll();
			sheetObjects[0].CheckAll("Chk",0,1);
			sheetObjects[1].CheckAll("Chk",0,1);
			formObj.vvd.focus();
		break;

		case IBDOWNEXCEL:    //Down Excel
			if (sheetObj.RowCount()== 0 ) {
				ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
				return;
			} else {
				ComOpenWait(true);
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					ComOpenWait(true);
					sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
					ComOpenWait(false);
				}
			}
		break;

		case IBSAVE:      // Save CSV
			if(!validateForm(sheetObj,formObj,IBSEARCH)) return false;
			formObj.f_cmd.value=SEARCH01;
			formObj.gubun.value="csv";
			ComOpenWait(true,true);
			var sXml=sheetObj.GetSearchData("ESM_BKG_1046GS.do", FormQueryString(formObj));
			var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);

			if(State == "S"){
				if ( ComGetEtcData(sXml,"total") == "0" ) {
					ComShowCodeMessage("BKG00389"); // No data to dowload as Excel
					ComOpenWait(false);
					return;
				} else {
					ComOpenWait(true);
					formObj.f_cmd.value=MULTI01;
					var sXml=sheetObj.GetSearchData("ESM_BKG_1046GS.do", FormQueryString(formObj));
					var down_csv=ComGetEtcData(sXml, "down_csv");
					sheetObj.SetCellText(2, "down_csv" ,down_csv);
					//alert(down_csv);
					var sDate=formObj.date.value;
					var sFileName="China Manifest Transmission_" + getCurrentTime() + ".csv"
					ComOpenWait(false);
					sheetObj.Down2Text({ ColDelim:"", DownCols:"37", FileName:sFileName, DownHeader:false});
				}
			}
			else{
				//sheetObj.RenderSheet(0);
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				//sheetObj.RenderSheet(1);
			}
			//ComOpenWait(false);
		break;

		case IBDELETE:      // Delete
			//if(!validateForm(sheetObj,formObj,sAction)) return false;
			if (sheetObj.CheckedRows("Chk") == 0) {
				//if there's no selected list
				ComShowCodeMessage("BKG00249"); // No Selected Row
				return;
			}
			if(sheetObj.CheckedRows("Chk") > 0){
				if(ComShowCodeConfirm("BKG00535")){
					ComOpenWait(true,true);
					formObj.f_cmd.value=MULTI;
					var sParam=FormQueryString(formObj) + "&" + sheetObjects[1].GetSaveString(false);
					var sXml=sheetObj.GetSaveData("ESM_BKG_1046GS.do", sParam);
					ComOpenWait(false);
					ComShowMessage(ComResultMessage(sXml));
					doActionIBSheet(sheetObj,formObj,IBSEARCH);
				}
			}
		break;

		case IBROWSEARCH:    // B/L Inquiry
			if(sheetObj.GetTotalRows()== 0){
				//if there's no selected list
				ComShowCodeMessage('BKG00249'); // No Selected Row
			}else{
				var sParam="";
				var transMode=document.form.trans_mode.value;
				var nowRow=sheetObj.GetSelectRow();

				if( transMode == "P"){
					sParam += "pgmNo=ESM_BKG_0217-2&bl_no="+sheetObj.GetCellValue(nowRow,"bl_no")+"&trans_mode="+transMode;
				}else{
					sParam += "pgmNo=ESM_BKG_0217-1&bl_no="+sheetObj.GetCellValue(nowRow,"bl_no")+"&trans_mode="+transMode;
				}
				ComOpenWindowCenter("ESM_BKG_0217_POP.do?"+sParam, "ESM_BKG_0217", 1200, 600);
			}
		break;

		case IBSEARCH_ASYNC01:	//Transmit Manifest
			if(!validateForm(sheetObj,formObj,sAction)) return false;
			if (sheetObj.CheckedRows("Chk") == 0) {
				//if there's no selected list
				ComShowCodeMessage("BKG00249"); // No Selected Row
				return;
			}

			formObj.f_cmd.value=MULTI02;
			if(formObj.trans_mode.value == "O" && formObj.eta_flg.value == "-1"){
				ComShowCodeMessage('BKG06006');
			}
			if(formObj.trans_mode.value == "O" && formObj.etd_flg.value == "-1"){
				ComShowCodeMessage('BKG06007');
			}
			if(formObj.trans_mode.value == "D" && formObj.eta_flg.value == "-1"){
				ComShowCodeMessage('BKG06008');
			}
			ComOpenWait(true,true);
			var sParam=FormQueryString(formObj) + "&" + sheetObjects[0].GetSaveString(false);
			var sXml=sheetObj.GetSaveData("ESM_BKG_1046GS.do", sParam);
			// BackEndJob per  3 second
			var key=ComGetEtcData(sXml, "KEY");
			intervalId=setInterval("doActionValidationResult(sheetObjects[2], '" + key + "');", 3000);
		break;
	}
}

/**
 * check competion after save button click
 * @param sheetObj
 * @param sKey BackEndJob Key
 */
function doActionValidationResult(sheetObj, sKey) {
	var sXml=sheetObj.GetSearchData("ESM_BKG_1046GS.do?f_cmd=" + MULTI03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// 에러가 발생했을 경우 대기사항을 종료한다.
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		// showing success messege
		ComShowMessage(ComResultMessage(sXml));
		// sheet1 retrieve again
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//error
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
}

/**
 * handling process for input validation
 */
function validateForm(sheetObj,formObj,sAction){
	switch (sAction) {
		case IBSEARCH: // retrieve
			if(!ComChkRequired(formObj)) return false;
			if(formObj.trans_mode.value != "D") return true;
			if(formObj.pod_cd.value.substring(0,2) == "CN"){
				if(formObj.pod_cd.value == "CNHKG"){
					ComShowCodeMessage("BKG06036");   // Invalid POD. China port only.
					return false;
				}
			}else{
				ComShowCodeMessage("BKG06036");   // Invalid POD. China port only.
				return false;
			}
			return true;
			break;

		case IBSEARCH_ASYNC01: //When Transmit button is clicked
			var sheetObject1=sheetObjects[0];
			// header lines = 2
			for( var i=2; i <= sheetObject1.RowCount()+1; i++ ) {

				if ( sheetObject1.GetCellValue(i, "Chk") == "1" &&  sheetObject1.GetCellValue(i, "bkg_cgo_tp_cd") == "F"  ) // when the row checked
				{
					//when CNTR_CNT is zero
					if(sheetObject1.GetCellValue(i, "cntr_cnt") == 0 ){
						ComShowCodeMessage("BKG06155", sheetObject1.GetCellValue(i, "bl_no"));
						return false;
					}
					// when the column value is N
					for( var j=8; j<= 20; j++){
						if(sheetObject1.GetCellValue(i,j)== "N") {
							ComShowCodeMessage("BKG06155", sheetObject1.GetCellValue(i, "bl_no"));
							return false;
						}
					}
					for( var j=24; j<= 26; j++){
						if(sheetObject1.GetCellValue(i,j)== "N") {
							ComShowCodeMessage("BKG06155", sheetObject1.GetCellValue(i, "bl_no"));
							return false;
						}
					}
					for( var j=29; j<= 31; j++){
						if(sheetObject1.GetCellValue(i,j)== "N") {
							ComShowCodeMessage("BKG06155",   sheetObject1.GetCellValue(i, "bl_no"));
							return false;
						}
					}
				}// end if
			}//end for
			return true;
			break;
	}
}

/**
 * get Today date
 * @return
 */
function getCurrentTime(){
	 var now=new Date();
	 var y=now.getFullYear();
	 var mon=now.getMonth()+1; // 월 (월은 0부터 시작므로 +1을 해야 합니다.)
	 var td=now.getDate(); // 일 (일은 1부터 시작하므로 +1을 하면 안 됩니다.)
	 var h=now.getHours();
	 var min=now.getMinutes();
	 var s=now.getSeconds();
	 var ms=now.getMilliseconds(); // (1/1000 second)
	 if(String(mon).length == 1) mon='0'+mon;
	 if(String(td).length == 1) td='0'+td;
	 if(String(h).length == 1) h='0'+h;
	 if(String(min).length == 1) min='0'+min;
	 if(String(s).length == 1) s='0'+s;
	 return y+mon+td+h+min+s;
}
