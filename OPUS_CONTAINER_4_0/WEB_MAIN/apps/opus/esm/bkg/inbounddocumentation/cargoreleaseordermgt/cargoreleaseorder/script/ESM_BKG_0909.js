/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0909.jsp
*@FileTitle  : US Cargo Release
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/06
=========================================================*/

	//Common global variable
	var backEndJobKey="";
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetNames=new Array("master","container","bkg_do_ref","bkg_cgo_rlse","otsRcvInfo","test_foc","sheet_bl_status");
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
  
	var btnMode="";
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	/* */
	var sheetObject1=sheetObjects[sheetNames[0]];
	var sheetObject2=sheetObjects[sheetNames[1]];
	var sheetObject3=sheetObjects[sheetNames[2]];
	var sheetObject4=sheetObjects[sheetNames[3]];
	/*******************************************************/

	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var obj = event.target || ComGetEvent();
	if ($(obj).prop('disabled')) {
	 return;
	}
	switch(srcName) {
		case "btn_retrieve":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH);
			break;
		case "btn_start_date":
			var cal=new ComCalendar();
			cal.select(formObject.start_date, 'yyyy-MM-dd');
			break;
		case "btn_end_date":
			var cal=new ComCalendarFromTo();
			cal.select(formObject.start_date, formObject.end_date, 'yyyy-MM-dd');
			break;

		case "btn_Save":
			btnMode="SAVE";
		  //Multi BL check후 누르면 You cannot manage multiple BLs using this function 나오고 빠져나감
			if(!fncCtrlButton()){
			   break;
		   }
		   //Grid의 BL과 아래 Form의 BL이 다르면 잘못된 정보가 저장될 수있으므로 check 한다.
		   if(!fncChkBl()){
			   break;
		   }
		   fncBtnSave();
			break;
		case "btn_Hold":
			btnMode="HOLD";
		  //Multi BL check후 누르면 You cannot manage multiple BLs using this function 나오고 빠져나감
			if(!fncCtrlButton()){
			   break;
			}
		  //Grid의 BL과 아래 Form의 BL이 다르면 잘못된 정보가 저장될 수있으므로 check 한다.
			if(!fncChkBl()){
			   break;
			}

			fncBtnHold();
			break;
		case "btn_History":
			//Multi BL check후 누르면 You cannot manage multiple BLs using this function 나오고 빠져나감
			if(!fncCtrlButton()){
			   break;
			}
			fncBtnHistory();
			break;
		case "btn_Hold_History":
			//Multi BL check후 누르면 You cannot manage multiple BLs using this function 나오고 빠져나감
			if(!fncCtrlButton()){
			   break;
			}
			fncBtnHoldHistory();
			break;
		case "btn_DownExcel":
			if(sheetObject1.RowCount() < 1){//no data
				ComShowCodeMessage("BKG00109");
			}else{
				sheetObject1.Down2Excel({ HiddenColumn:1});
			}
			break;
		case "btn_CFlag":
			//Multi BL check후 누르면 You cannot manage multiple BLs using this function 나오고 빠져나감
			if(!fncCtrlButton()){
			   break;
			}
			doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC02);
			break;
		case "btn_tpb":
			var sheetObjMaster=sheetObjects["master"];
			var formObj=document.form;
			var selRow=sheetObjMaster.GetSelectRow();
			var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
			var frDate=ComGetDateAdd(null, "D", -60);
			var toDate=ComGetNowInfo("ymd", "");
			var otsStsCd="";
			if (document.form.tpb_status.value == "1") {
				otsStsCd="P";
			} else {
				otsStsCd="T";
			}
			var condition="?";
			condition += "s_state=BKG";
			condition += "&s_ots_sts_cd=" + otsStsCd;
			condition += "&s_bkg_no_all="+bkgNo;
			condition += "&s_bl_no_all="+sheetObjMaster.GetCellValue(selRow, "master_" + "bl_no");
			condition += "&pgmNo=ESD_TPB_0134";
			ComOpenWindowCenter('/opuscntr/ESD_TPB_0134.do'+condition, 'win4', 1024, 650, false);
			break;
		case "btn_dmdt":
			var sheetObjMaster=sheetObjects["master"];
			var formObj=document.form;
			var selRow=sheetObjMaster.GetSelectRow();
			var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
			var blNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bl_no");
			var trfCd=formObj.demur_type.value;
			var paramVal="?call_flag=P&bkg_no=" + bkgNo + "&bl_no=" + blNo + "&dmdt_trf_cd=" + trfCd;
			ComOpenWindowCenter('/opuscntr/EES_DMT_3002P.do' + paramVal, 'dmdt', 1010, 670, false);
			break;
		case "btn_srnd":
			var sheetObjMaster=sheetObjects["master"];
			var formObj=document.form;
			var selRow=sheetObjMaster.GetSelectRow();
			var bkgNo=sheetObjMaster.GetCellValue(selRow, "master_" + "bkg_no");
			if(bkgNo == "" || bkgNo == "-1"){
				ComOpenWait(false);
				return;
			}
			var condition="?";
			condition += "bkg_no="+bkgNo;
			condition += "&inquery_only=Y";
			condition += "&pgmNo=ESM_BKG_0400";
			ComOpenWindow("/opuscntr/ESM_BKG_0400_POP.do"+condition, "bl_surr_rmk", "scroll:yes;status:no;help:no;dialogWidth:900px;dialogHeight:300px;dialogLeft:0;dialogTop:0", false);

			break;
		case "btn_test_frt":
			fncTestFrt();
			break;
		case "btn_test_obl":
			fncTestObl();
			break;
		case "btn_test_cstms":
			fncTestCstms();
			break;
		case "btn_remark":
			doActionIBSheet(sheetObject1, formObject, IBSEARCH_ASYNC01);
			break;
		case "btn_close":
			ComClosePopup();
			break;
		case "btn_Ivc": //Multi TDC 315 sending

			if(sheetObject1.CheckedRows("chk") < 1){
				ComShowCodeMessage("BKG43046");
				return;
			}
			//User Holding이 있을 경우 Multi sending 못하게 막음
			if(!fncHldChkButton()){
			   break;
			 }

			//DEL 이 CA인 경우 CA cargo release 사용 alert
			if(!fncDestChk()){
			   break;
			 }

			doActionIBSheet(sheetObject1,formObject,MULTI04);

			break;

	} // end switch
}
/**
	 * registering IBTab Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
function setTabObject(tab_obj){
	tabObjects[tabCnt++]=tab_obj;
}
/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
function setSheetObject(sheet_obj){
	sheetObjects[sheet_obj.id]=sheet_obj;
}

/**
 * IBCombo Object를 배열로 등록
 * param : combo_obj ==> 콤보오브젝트
 * 향후 다른 항목들을 일괄처리할 필요가 있을 때 배열로 담는 프로세스를 추가할 수 있다
 * 배열은 소스 상단에 정의
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}

/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
function loadPage() {
	var formObj=document.form;
	fnInSetComboBox(formObj.bl_otr_doc_rcv_cd, evtCode, evtValue, "|", "", "", true, "");
	fnInSetComboBox(formObj.cstms_clr_cd, evtCustomsCode, evtCustomsValue, "|", "", "All", true, "");

	var strCustomsValue = "";

	var codeArr=evtClearanceCode.split("|");
	var valueArr=evtClearanceValue.split("|");
	for(var m=0; m<codeArr.length -1; m++) {
		var temp = codeArr[m] + "," + valueArr[m];

		if (strCustomsValue != "") {
			strCustomsValue = strCustomsValue + "|" + temp;
		} else {
			strCustomsValue = strCustomsValue + temp;
		}
	}

	for(i=0;i<sheetNames.length;i++){
		if(sheetNames[i] == "master" || sheetNames[i] == "container"){
			ComConfigSheet (sheetObjects[sheetNames[i]]);
		}
		initSheet(sheetObjects[sheetNames[i]] ,i+1);
		if(sheetNames[i] == "master" || sheetNames[i] == "container"){
			ComEndConfigSheet(sheetObjects[sheetNames[i]] );
		}
	}

	initCombo(comboObjects[0], strCustomsValue);

	initControl();
	//initializing
//    document.getElementById("date_hide").style.visibility="hidden";

	formObj.start_date.value=ComGetNowInfo('ymd','-');
	formObj.start_time.value="00:00";
	formObj.end_date.value=ComGetNowInfo('ymd','-');
	formObj.end_time.value="23:59";
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_Ivc");
	ComBtnDisable("btn_Hold");
	ComBtnDisable("btn_History");
	ComBtnDisable("btn_Hold_History");

	changeObjectColor("Y", "Y", "btn_CFlag", "red", "btn1");

}

/**
 * The initial setting combo
 * @param {IBMultiCombo} comboObj  comboObj
 */
function initCombo(comboObj, comboValue) {

	comboObj.SetMultiSelect(0);
	comboObj.UseCode=true;
	// comboObj.LineColor = "#ffffff";
	// comboObj.SetColAlign("left|left");
	comboObj.SetMultiSeparator(",");
	comboObj.SetDropHeight(150);

	var comboItems=comboValue.split("|");
	addComboItem(comboObj, comboItems);

	info_cstms_clr_cd.SetSelectIndex(0);
}

/**
 * adding data to combo field
 * Web IBMultiCombo객체.InsertItem(Index, Text, Code);
 */
function addComboItem(comboObj, comboValue) {
	for (var i=0 ; i < comboValue.length ; i++) {
		var comboItem=comboValue[i].split(",");
		if(comboItem.length == 1){
			comboObj.InsertItem(i, comboItem[0], comboItem[0]);
		}else{
			comboObj.InsertItem(i, comboItem[0] + "|" + comboItem[1], comboItem[0]);
		}
	}
}

function info_cstms_clr_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {

	var sCode = info_cstms_clr_cd.GetSelectCode();
	var sText = info_cstms_clr_cd.GetSelectText();

	if (newIndex < 0) {
		if (oldIndex >= 0) {
			info_cstms_clr_cd.SetSelectIndex(oldIndex);
			sCode = info_cstms_clr_cd.GetSelectCode();
			sText = info_cstms_clr_cd.GetSelectText();
		} else {
			return;
		}
	}

	if (sCode != "" && sText!= "") {
		// 여러 아이템이 선택된 경우에는 "x건 선택됨"으로 표시하기
		info_cstms_clr_cd.SetViewText(sCode + "  " + sText);
	} else {
		// 1건인 경우에는 선택된 아이템으로 표시하기
		info_cstms_clr_cd.SetViewText("");
	}
}


/**
	 * setting event
	 */
function initControl() {
	axon_event.addListenerForm('click', 'obj_click', form );
	axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
  //  axon_event.addListenerForm('keyup', 'obj_keyup', form );
	axon_event.addListenerForm ('blur', 'obj_deactivate', form);
	axon_event.addListenerForm ('activate', 'obj_activate', form);
}
/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch(sheetObj.id) {
		case "master":      //master init
			with(sheetObj){

		  var HeadTitle=" ||No.|B/L|PCS|VVD|POD|DEL|HUB|Last Update|Freight|Freight|O. B/L|O. B/L|Customs Clearance|Customs Clearance|Cargo Release|Cargo Release|Partial|Consignee Name|Remark(s)|do_hld_flg|obl_ttl_knt|bkg_no";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="master_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chk",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:-1 },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pcs_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"last_up_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"f_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"o_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }, //Edit:1 이었다가 Multi전송 수정이후 0으로 수정
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"c_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }, //Edit:1 이었다가 Multi전송 수정이후 0으로 수정
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_snd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }, //Edit:1 이었다가 Multi전송 수정이후 0으로 수정
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_last_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }, //Edit:1 이었다가 Multi전송 수정이후 0으로 수정
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"prt_ind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:180,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 }, //Edit:1 이었다가 Multi전송 수정이후 0으로 수정
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_ttl_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];

		  InitColumns(cols);
		  SetSheetHeight(182);
		  SetEditable(1);
		  SetWaitImageVisible(0);
		  SetAutoRowHeight(0);
		  }


			break;
		case "container":      //sheet1 init
			with(sheetObj){

		  var HeadTitle=" |Seq.|Container No.";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="container_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no", KeyField:0,   CalcLogic:"",   Format:"",  PointCount:0,   UpdateEdit:0 } ];

		  InitColumns(cols);
		  SetSheetHeight(100);
		  SetEditable(0);
		  SetWaitImageVisible(0);
		  SetCountPosition(0);
				}

			break;
		case "bkg_do_ref":      //sheet1 init
			with(sheetObj){

		  var HeadTitle=" |Seq.|bkg_no|inter_rmk|do_hld_flg|bl_no";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="bkg_do_ref_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

		  InitColumns(cols);
		  SetSheetHeight(150);
		  SetEditable(0);
				}
			break;
			case "bkg_cgo_rlse":      //sheet1 init
			with(sheetObj){

		  var HeadTitle=" |Seq.|bl_no|frt_clt_flg|obl_rdem_flg|cstms_clr_cd|bl_rcv_knt|pod_cd|del_cd";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="bkg_cgo_rlse_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rcv_knt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 } ];

		  InitColumns(cols);
		  SetSheetHeight(150);
		  SetEditable(0);
				}


			break;
		case "otsRcvInfo":
			/****************************************************************
				//checking whether the freight charged is payed. retrieving Outstanding Amounts Information
				*****************************************************************/
			with(sheetObj){

		  var HeadTitle=" |TOT_OTS_STS_CD|TOT_OTS_CURR_CD1|TOT_OTS_CURR_CD2|TOT_OTS_CURR_CD3|TOT_OTS_CURR_CD4|TOT_OTS_CURR_CD5|TOT_OTS_AMT1|TOT_OTS_AMT2|TOT_OTS_AMT3|TOT_OTS_AMT4|TOT_OTS_AMT5|PPT_STS_CD|PPT_RCV_OFC_CD|PPT_RCV_USR_ID|PPT_RCV_DT|CCT_STS_CD|CCT_RCV_OFC_CD|CCT_RCV_USR_ID|CCT_RCV_DT|CCT_OTS_CURR_CD1|CCT_OTS_CURR_CD2|CCT_OTS_CURR_CD3|CCT_OTS_CURR_CD4|CCT_OTS_CURR_CD5|CCT_OTS_AMT1|CCT_OTS_AMT2|CCT_OTS_AMT3|CCT_OTS_AMT4|CCT_OTS_AMT5|N3PTY_PPT_STS_CD|N3PTY_PPT_RCV_OFC_CD|N3PTY_PPT_RCV_USR_ID|N3PTY_PPT_RCV_DT|N3PTY_CCT_STS_CD|N3PTY_CCT_RCV_OFC_CD|N3PTY_CCT_RCV_USR_ID|N3PTY_CCT_RCV_DT|N3PTY_CCT_OTS_CURR_CD1|N3PTY_CCT_OTS_CURR_CD2|N3PTY_CCT_OTS_CURR_CD3|N3PTY_CCT_OTS_CURR_CD4|N3PTY_CCT_OTS_CURR_CD5|N3PTY_CCT_OTS_AMT1|N3PTY_CCT_OTS_AMT2|N3PTY_CCT_OTS_AMT3|N3PTY_CCT_OTS_AMT4|N3PTY_CCT_OTS_AMT5";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="otsRcvInfo_";

		  SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_sts_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tot_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ppt_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_sts_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_ofc_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_rcv_dt",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_curr_cd5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt3",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt4",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cct_ots_amt5",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_ppt_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_sts_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_ofc_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_usr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_rcv_dt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd1", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd2", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd3", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd4", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_curr_cd5", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
				 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"n3pty_cct_ots_amt5",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 } ];

		  InitColumns(cols);
		  sheetObj.SetVisible(false);
		  SetEditable(0);
				}


			break;
		case "test_foc":      //master init
			with(sheetObj){

		  var HeadTitle=" |No|B/L|PCS|VVD|POD|DEL|HUB|Last Update|Freight|Freight|O. B/L|O. B/L|Customs Clearance|Customs Clearance|Cargo Release|Cargo Release|Partial|Consignee Name|Remark(s)|do_hld_flg|obl_ttl_knt|bkg_no";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (headCount, 0, 0, true);
		  var prefix="test_foc_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pcs_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hub_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"last_up_dt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"frt_clt_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"f_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_flg", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"o_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cstms_clr_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"c_last_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_snd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_last_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"prt_ind",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:120,  Align:"Left",    ColMerge:0,   SaveName:prefix+"cust_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"inter_rmk",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"do_hld_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_ttl_knt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:1, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];

		  InitColumns(cols);
		  SetSheetHeight(182);
		  SetEditable(0);
		  SetAutoRowHeight(0);
		  }


			break;
		case "sheet_bl_status":      //bl_status
			with(sheetObj){

		  var HeadTitle=" |No|bl_status|bl_cpy_knt";
		  HeadTitle +="|bl_rlse|bl_rlse_ofc_cd|bl_rlse_usr_id|bl_rlse_dt";
		  HeadTitle +="|obl_rdem_knt|obl_rdem_ofc_cd|obl_rdem_usr_id|obl_rdem_dt";
		  HeadTitle +="|bl_ibd|bl_ibd_ofc_cd|bl_ibd_usr_id|bl_ibd_dt";
		  HeadTitle +="|bl_otr_doc_rcv_cd|otr_doc_rcv_ofc_cd|otr_doc_rcv_usr_id|otr_doc_rcv_dt";
		  HeadTitle +="|cnt_cd|del_cd|obl_iss_rmk";
		  var headCount=ComCountHeadTitle(HeadTitle);
		  (24, 0, 0, true);
		  var prefix="sheet_bl_status_";

		  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

		  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		  var headers = [ { Text:HeadTitle, Align:"Center"} ];
		  InitHeaders(headers, info);

		  var cols = [ {Type:"Status",    Hidden:1, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"seq" },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_status",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_cpy_knt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_ofc_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_rlse_dt",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_knt",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_usr_id",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_rdem_dt",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_ofc_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:20,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_ibd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_otr_doc_rcv_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_ofc_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:30,   Align:"Left",    ColMerge:0,   SaveName:prefix+"otr_doc_rcv_usr_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"otr_doc_rcv_dt",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cnt_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 },
				 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"obl_iss_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1 } ];

		  InitColumns(cols);
		  SetSheetHeight(150);
		  SetEditable(0);
		  SetAutoRowHeight(0);
		  }
			break;
	}
}
// handling process for Sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	var formObj=document.form;
	switch(sAction) {
		case IBSEARCH:      //retrieve
			if(!validateForm(sheetObj,formObj,sAction)) return;
			var tmpBlNo=formObj.bl_no.value;
			if(!formObj.sch_tp[0].checked){
				formObj.bl_no.value="";
			}
			ComBtnDisable("btn_Save");
			ComBtnDisable("btn_Hold");
			ComBtnDisable("btn_History");
			ComBtnDisable("btn_Hold_History");
			formObj.bkg_no.value="";
			formObj.req_pod_cd.value="";
			//clearing
			formObj.inter_rmk.value="";
			sheetObjects["container"].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			ComOpenWait(true);
			if (sheetObj.id=="master"){
				//parameter changed[check again]CLT
				sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("master_") , {Sync:2} );
			}
			formObj.bl_no.value=tmpBlNo;
			break;

		case IBSEARCH_ASYNC01:
			var sheetObjMaster=sheetObjects["master"];
			var sheetObjRef=sheetObjects["bkg_do_ref"];
			var selRow=sheetObjMaster.GetSelectRow();
			sheetObjRef.RemoveAll();
			if (sheetObjMaster.GetCellValue(selRow,"master_" + "inter_rmk") != formObj.inter_rmk.value){
				Row=sheetObjRef.DataInsert();
				prefix="bkg_do_ref_";
				sheetObjRef.SetCellValue(Row,prefix + "bkg_no",formObj.bkg_no.value);
				sheetObjRef.SetCellValue(Row,prefix + "inter_rmk",formObj.inter_rmk.value);
				sheetObjRef.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
			} else {
				ComShowCodeMessage("BKG00917");
				break;
			}
			ComOpenWait(true);
			var sParam="&f_cmd=" + MULTI20;
			var sParamSheet=sheetObjRef.GetSaveString();
			if (sParamSheet != "") {
				sParam += "&" + sParamSheet;
			}
			//parameter changed[check again]CLT
			var sXml=sheetObj.GetSaveData("ESM_BKG_0909GS.do", sParam);
			//parameter changed[check again]CLT
			sheetObj.LoadSaveData(sXml);
			ComOpenWait(false);
			break;
			// C flag/CNTR

		case IBSEARCH_ASYNC02:
			var sheetObjMaster=sheetObjects["master"];
			var selRow=sheetObjMaster.GetSelectRow();
			if (sheetObjMaster.RowCount()== 0) {
				ComShowCodeMessage("BKG00395");
				break;
			}
			var bl_no=sheetObjMaster.GetCellValue(selRow, "master_" + "bl_no");
			param="?bl_no="+bl_no+ "&pgmNo=ESM_BKG_0041&mainPage=false";
			ComOpenWindowCenter("/opuscntr/ESM_BKG_0041_POP.do"+param, "ESM_BKG_0041", 1200, 650, true);
			break;

		case MULTI04:
			ComOpenWait(true);
			ComSetObjValue(formObj.f_cmd,MULTI04);
			var params=FormQueryString(formObj);
			params=params + "&" + sheetObjects["master"].GetSaveString(false, true, 1);
			var xmlStr=sheetObjects["master"].GetSaveData("ESM_BKG_0909GS.do", params);
			backEndJobKey = ComGetEtcData(xmlStr, "backEndJob_Key")    // 전역변수 setting
			if (backEndJobKey != "") {
				sheetObjects["master"].SetWaitTimeOut(20000);
				timer = setInterval(getBackEndJobStatus, 3000);   // 3초마다 getBackEndJobStatus함수 실행
			}
			break;
	}
}
/**
 * Call - Back End Job
 */
function getBackEndJobStatus() {
	var sheetObj = sheetObjects["master"];
	var xmlStr = sheetObj.GetSearchData("ESM_BKG_0909GS.do", "f_cmd=" + COMMAND02 + "&backEndJob_Key=" + backEndJobKey);
	var jbStsFlg = ComGetEtcData(xmlStr, "jb_sts_flg");

	if (jbStsFlg == "3") {
		ComOpenWait(false);
		sheetObj.LoadSaveData(sheetObj.GetSaveData("ESM_BKG_0909GS.do", "f_cmd=" + COMMAND03 + "&backEndJob_Key=" + backEndJobKey), {Sync:1});
		clearInterval(timer);
		backEndJobKey = "";
		doActionIBSheet(sheetObj, document.form, IBSEARCH);

	} else if (jbStsFlg == "4") {
		clearInterval(timer);
		backEndJobKey = "";
		ComOpenWait(false);
		ComShowCodeMessage("COM130406", "using Back End Job");    // Failed to retrieve {?msg1}. Please try again.
	}
}
/**
	 * handling process for input validation
	 */
function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		if(formObj.sch_tp[0].checked && formObj.bl_no.value == ""){
			ComShowCodeMessage("COM130404","B/L No.","B/L No");
			return false;
		}

		if(formObj.sch_tp[1].checked)
		{
			if(formObj.vvd.value == "") {
				ComShowCodeMessage("COM130404","VVD","VVD");
				return false;
			}

			if(formObj.pod_cd.value == "") {
				ComShowCodeMessage("COM130404","POD","POD");
				return false;
			}
		}


	}
	return true;
}
/**
 * Double Click event
 */
function master_OnDblClick(sheetObj,Row, Col){
	var formObj=document.form;
	var prefix="master_";
	formObj.bkg_no.value=sheetObj.GetCellValue(Row,prefix + "bkg_no");
	formObj.req_pod_cd.value=sheetObj.GetCellValue(Row,prefix + "pod_cd");
	formObj.curr_bl_no.value=sheetObj.GetCellValue(Row,prefix + "bl_no");
	fncSearchSheet2();
}
function fncSearchSheet2(){
	var formObj=document.form;
	var sheetObj=sheetObjects["container"];
	ComOpenWait(true);
	formObj.f_cmd.value=SEARCH02;
	//parameter changed[check again]CLT
	sheetObj.DoSearch("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("container_") );
	return;
}
/**
 * event after retrieving
 */
function container_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var Row=sheetObjects["master"].GetSelectRow();
	var prefix="master_";

	if(sheetObjects["master"].RowCount() > 0){
		formObj.inter_rmk.value= sheetObjects["master"].GetCellValue(Row, prefix + "inter_rmk");
		formObj.obl_ttl_knt.value=sheetObjects["master"].GetCellValue(Row, prefix + "obl_ttl_knt");
	}else{
		formObj.inter_rmk.value= "";
		formObj.obl_ttl_knt.value="";
	}
	var doHldFlg=sheetObjects["master"].GetCellValue(Row, prefix + "do_hld_flg");
	if(doHldFlg == "Y"){
		formObj.do_hld_flg.value="HOLD";
		document.getElementById("btn_Hold").innerText="Hold Removal";
	}else{
		formObj.do_hld_flg.value="";
		document.getElementById("btn_Hold").innerText="Hold";
	}
	for(var i=0;i<formObj.info_frt_clt_flg.options.length;i++){
		if(sheetObjects["master"].GetCellValue(Row, prefix + "frt_clt_flg")
			== formObj.info_frt_clt_flg.options[i].value){
			formObj.info_frt_clt_flg.selectedIndex=i;
			break;
		}
	}
	for(var i=0;i<formObj.info_obl_rdem_flg.options.length;i++){
		if(sheetObjects["master"].GetCellValue(Row, prefix + "obl_rdem_flg")
			== formObj.info_obl_rdem_flg.options[i].value){
			formObj.info_obl_rdem_flg.selectedIndex=i;
			break;
		}else{
			formObj.info_obl_rdem_flg.selectedIndex=1;
		}
	}

	var sheetValue=sheetObjects["master"].GetCellValue(Row, prefix + "cstms_clr_cd");
	if(sheetValue != "Y"
		&& sheetValue != "J"
		&& sheetValue != "D"
		&& sheetValue != "E"
		&& sheetValue != "H"
		&& sheetValue != "I"
		&& sheetValue != "P"
		&& sheetValue != "T"
		&& sheetValue != "W"
		&& sheetValue != "H"
		&& sheetValue != "V"
		){
		sheetValue="N";
	}

	var nIdx = info_cstms_clr_cd.FindItem(sheetValue, 0, true);

	if( nIdx != -1) {
		info_cstms_clr_cd.SetSelectIndex(nIdx);

		var sCode = info_cstms_clr_cd.GetSelectCode();
		var sText = info_cstms_clr_cd.GetSelectText();
		info_cstms_clr_cd.SetViewText(sCode + "  " + sText);
	}


//    for(var i=0;i<formObj.info_cstms_clr_cd.options.length;i++){
//    for(var i=0;i<info_cstms_clr_cd.GetItemCount();i++){
//    	var sheetValue=sheetObjects["master"].GetCellValue(Row, prefix + "cstms_clr_cd");
//        //setting with "N" in case of not existing retrieved data
//
//        if(sheetValue != "Y"
//        	&& sheetValue != "J"
//        	&& sheetValue != "D"
//        	&& sheetValue != "E"
//        	&& sheetValue != "H"
//        	&& sheetValue != "I"
//        	&& sheetValue != "P"
//        	&& sheetValue != "T"
//        	&& sheetValue != "W"
//        	&& sheetValue != "H"
//        	&& sheetValue != "V"
//            ){
//        	sheetValue="N";
//        }
////        var objValue=formObj.info_cstms_clr_cd.options[i].value;
//        info_cstms_clr_cd.SetSelectIndex(i)
//        var objValue=info_cstms_clr_cd.GetSelectCode();
//
//    	alert(sheetValue + "   " + objValue);
//
//        if( sheetValue == objValue){
//            info_cstms_clr_cd.SetSelectIndex(i);
//            break;
//        }
//    }
	//getting Erp Info.
	fncGetErpDem(sheetObj, formObj);
}
/**
	* getting ERP, DEM DET Info.
	*/
function fncGetErpDem(sheetObj,formObj){
	var sheetObjMaster=sheetObjects["master"];
	var selRow=sheetObjects["master"].GetSelectRow();
	var prefix="master_";
	var param="&f_cmd=" + SEARCH03 +
	"&bkg_no=" + sheetObjMaster.GetCellValue(selRow, prefix + "bkg_no") +
	"&bl_no=" + sheetObjMaster.GetCellValue(selRow, prefix + "bl_no") +
	"&req_pod_cd=" + sheetObj.GetCellValue(selRow, prefix + "pod_cd");
	//parameter changed[check again]CLT
	var sXml=sheetObj.GetSearchData("ESM_BKG_0909GS.do", param);
	var arrXml=sXml.split("|$$|");
	//setting data of ETC DATA
	//demur Type
	if(undefined != ComGetEtcData(arrXml[0], "demurType")){
		formObj.demur_type.value=ComGetEtcData(arrXml[0], "demurType");
	}
	//TPB
	if(undefined != ComGetEtcData(arrXml[0], "tpbStatus") && ComGetEtcData(arrXml[0], "tpbStatus") != 'null'){
		formObj.tpb_status.value=ComGetEtcData(arrXml[0], "tpbStatus");
		tpbImgSet(formObj.tpb_status.value);
	}
	//ots ERP Count
	for(var k=formObj.tot_ots_amt.options.length;k > -1; k--){
		formObj.tot_ots_amt.remove(k);
	}
	//setting ERP data
	for(var x=0;x < ComGetEtcData(arrXml[0], "otsCnt");x++){
		var oOption=document.createElement("OPTION");
		formObj.tot_ots_amt.options.add(oOption);
		oOption.innerText=ComGetEtcData(arrXml[0], "ots"+x);
		//black in case of tot_ots_amt = 0. the other case : red
		var _otsValue=parseFloat(ComGetEtcData(arrXml[0], "ots"+x));
		if(_otsValue == 0 ){//black
			document.getElementById("tot_ots_amt").className="input2";
		}else{
			document.getElementById("tot_ots_amt").className="input2_1";
		}
	}
	//demAMT Clear
	for(var k=formObj.tot_bil_amt.options.length;k > -1; k--){
		formObj.tot_bil_amt.remove(k);
	}
	var oTotBilAmt=document.createElement("OPTION");
	formObj.tot_bil_amt.options.add(oTotBilAmt);
	if(undefined != ComGetEtcData(arrXml[0], "demAMT") && ComGetEtcData(arrXml[0], "demAMT") != 'null'){
		oTotBilAmt.innerText=ComGetEtcData(arrXml[0], "demAMT");
		//black in case of demAMT = 0. the other case : red
		var _demAmtValue=ComGetEtcData(arrXml[0], "demAMT");
		if( _demAmtValue == "USD 0.0"){//black
			document.getElementById("tot_bil_amt").className="input2";
			document.getElementById("dem_status").style.color='blue';
			document.getElementById("dem_status").className="input2";
		}else{
			document.getElementById("tot_bil_amt").className="input2_1";
			document.getElementById("dem_status").style.color='red';
			document.getElementById("dem_status").className="input2_1";
		}
	}
	//dem status
	if(undefined != ComGetEtcData(arrXml[0], "demStatus") && ComGetEtcData(arrXml[0], "demStatus") != 'null'){
		formObj.dem_status.value=ComGetEtcData(arrXml[0], "demStatus");
	}
	//getting Original Bill of Lading Status
	fncGetBLStatus();
}
/**
	* getting Original Bill of Lading Status
	*/
function fncGetBLStatus(){
	var formObj=document.form;
	var sheetObj=sheetObjects["sheet_bl_status"];
	formObj.f_cmd.value=SEARCH04;
	//parameter changed[check again]CLT
	var sXml=sheetObj.GetSearchData("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet_bl_status_"));
	formObj.prt_ind.value=ComGetEtcData(sXml, "prt_ind");
	sheetObj.LoadSearchData(sXml,{Sync:0} );
}
/**
	* setting value of Original Bill of Lading Status Form
	*/
function sheet_bl_status_OnSearchEnd(sheetObj, ErrMsg){
	var formObj=document.form;
	var sheetObj=sheetObjects["sheet_bl_status"];
	//getting prt_ind value from ETC data
	var colName=new Array("bl_cpy_knt"
		,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
		,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
		,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
		,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
		,"obl_iss_rmk"
		);
	for(var i=0;i<colName.length;i++){
		if(colName[i] == "bl_otr_doc_rcv_cd"){
			for(var j=0;j<formObj.bl_otr_doc_rcv_cd.options.length;j++){
				if(sheetObj.GetCellValue(1, "sheet_bl_status_" + colName[i])
					== formObj.bl_otr_doc_rcv_cd.options[j].value){
					formObj.bl_otr_doc_rcv_cd.selectedIndex=j;
					break;
				}
			}
		}else{
			if(sheetObj.RowCount() > 0) {
				document.getElementsByName(colName[i])[0].value=sheetObj.GetCellValue(1,"sheet_bl_status_" + colName[i]);
			}else{
				document.getElementsByName(colName[i])[0].value="";
			}
		}
	}
	if (sheetObj.GetCellValue(1, "sheet_bl_status_" + "bl_status") == "S")
	{
		document.getElementById("btn_srnd").style.visibility="visible";
	}
	else{
		document.getElementById("btn_srnd").style.visibility="hidden";
	}
	ComOpenWait(false);
	//deactivating in case of not existing cstms_clr_cd value
	var Row=sheetObjects["master"].GetSelectRow();
	var prefix="master_";
	if(sheetObjects["master"].GetCellValue(Row, prefix + "cstms_clr_cd") == "X"){
		info_cstms_clr_cd.SetEnable(false);
	}else{
		info_cstms_clr_cd.SetEnable(true);
	}
	ComBtnEnable("btn_Save");
	ComBtnEnable("btn_Ivc");
	ComBtnEnable("btn_Hold");
	ComBtnEnable("btn_History");
	ComBtnEnable("btn_Hold_History");
}
/****************************************************
* save button click
* //test bl_no ; TAOA14018502
***************************************************/
function fncBtnSave(){
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	var sheetObjCgoRlse=sheetObjects["bkg_cgo_rlse"];
	var sheetObjOblByCgo=sheetObjects["sheet_bl_status"];
   // selRow=sheetObjMaster.GetSelectRow();
	var Row;
	var selRow;
	var prefix;
	selRow=sheetObjMaster.GetSelectRow();

	var del_cd = sheetObjMaster.GetCellValue(selRow,"master_" + "del_cd");
	var pod_cd = sheetObjMaster.GetCellValue(selRow,"master_" + "pod_cd");
	
	if(del_cd.indexOf("CA") == 0 && pod_cd.indexOf("CA") == 0 ){
		ComShowCodeMessage("BKG08326","Canada","CA");//O/BL receipt update is not allowed for canada destination cargo. please use CA cargo release to update it.
		return;
	}
	//stopping in case of HOLD
	var holdValue=sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg");
	if(holdValue == "Y"){
		ComShowCodeMessage("BKG00649");
		ComOpenWait(false);
		return;
	}
	if (formObj.info_obl_rdem_flg.value == "Y"
		&& formObj.bl_status.value == "B" ) {
		if((formObj.obl_rdem_knt.value == "" || formObj.obl_rdem_knt.value == "0") &&
			(formObj.bl_ibd.value       == "" || formObj.bl_ibd.value       == "0") &&
			formObj.bl_otr_doc_rcv_cd.value == "" ){
			ComShowCodeMessage("BKG40118");
			ComOpenWait(false);
			return;
		}
	}
	var t_obl_rdem_knt=formObj.obl_rdem_knt.value;
	var t_bl_ibd=formObj.bl_ibd.value;
	var t_bl_cpy_knt=formObj.bl_cpy_knt.value;
	if(t_obl_rdem_knt == ""){
		t_obl_rdem_knt=0;
	}
	if(t_bl_ibd == ""){
		t_bl_ibd=0;
	}
	if(t_bl_cpy_knt == ""){
		t_bl_cpy_knt=0;
	}
	t_obl_rdem_knt=parseInt(t_obl_rdem_knt);
	t_bl_ibd=parseInt(t_bl_ibd);
	t_bl_cpy_knt=parseInt(t_bl_cpy_knt);
	if(
		(parseInt(t_obl_rdem_knt) + parseInt(t_bl_ibd)) > parseInt(t_bl_cpy_knt)){
		//The number of B/L Received you inputted is bigger than B/Ls released in B/L Issue Screen.
		ComShowCodeMessage('BKG40065');
		ComOpenWait(false);
		return;
	}
	/**************************
		* 2. BKG_CGO_RLSE UPDATE.
		***************************/
	sheetObjCgoRlse.RemoveAll();
	if(    (sheetObjMaster.GetCellValue(selRow,"master_" + "frt_clt_flg") != formObj.info_frt_clt_flg.value)
			|| (sheetObjMaster.GetCellValue(selRow,"master_" + "obl_rdem_flg") != formObj.info_obl_rdem_flg.value)
			|| (
					(sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") != info_cstms_clr_cd.GetSelectCode())
					&&(sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") != "X")
				)
				|| (sheetObjOblByCgo.GetCellValue(1,"sheet_bl_status_" + "bl_ibd") != formObj.bl_ibd.value)
		){
		Row=sheetObjCgoRlse.DataInsert();
		prefix="bkg_cgo_rlse_";
		sheetObjCgoRlse.SetCellValue(Row,prefix + "bl_no",sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
		// when not existing changed Freight
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "frt_clt_flg") == formObj.info_frt_clt_flg.value){
			sheetObjCgoRlse.SetCellValue(Row,prefix + "frt_clt_flg","");
		}else{
			sheetObjCgoRlse.SetCellValue(Row,prefix + "frt_clt_flg",formObj.info_frt_clt_flg.value);
		}
		// when not existing changed O/BL
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "obl_rdem_flg") == formObj.info_obl_rdem_flg.value){
			sheetObjCgoRlse.SetCellValue(Row,prefix + "obl_rdem_flg","");
		}else{
			sheetObjCgoRlse.SetCellValue(Row,prefix + "obl_rdem_flg",formObj.info_obl_rdem_flg.value);
		}
		if(sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") == "X"){
			sheetObjCgoRlse.SetCellValue(Row,prefix + "cstms_clr_cd","X");
		}else{
			// when not existing changed Customs
			if(sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") == info_cstms_clr_cd.GetSelectCode()){
				sheetObjCgoRlse.SetCellValue(Row,prefix + "cstms_clr_cd","");
			}else{
				sheetObjCgoRlse.SetCellValue(Row,prefix + "cstms_clr_cd",info_cstms_clr_cd.GetSelectCode());
			}
		}
		sheetObjCgoRlse.SetCellValue(1,prefix + "bl_rcv_knt",formObj.bl_ibd.value);
		sheetObjCgoRlse.SetCellValue(1,prefix + "pod_cd",sheetObjMaster.GetCellValue(selRow,"master_" + "pod_Cd"));
		sheetObjCgoRlse.SetCellValue(1,prefix + "del_cd",sheetObjMaster.GetCellValue(selRow,"master_" + "del_cd"));
	}
	/**************************
		* 3. BL_STATUS UPDATE.
		***************************/
	if(sheetObjOblByCgo.GetCellValue(1,"sheet_bl_status_" + "obl_rdem_knt") != formObj.obl_rdem_knt.value) {
		sheetObjOblByCgo.SetCellValue(1,"sheet_bl_status_" + "obl_rdem_knt",formObj.obl_rdem_knt.value);
	}
	if(sheetObjOblByCgo.GetCellValue(1,"sheet_bl_status_" + "bl_otr_doc_rcv_cd") != formObj.bl_otr_doc_rcv_cd.value) {
		sheetObjOblByCgo.SetCellValue(1,"sheet_bl_status_" + "bl_otr_doc_rcv_cd",formObj.bl_otr_doc_rcv_cd.value);
	}
	//showing message when not existing changed data
	if(sheetObjCgoRlse.RowCount() < 2 && !sheetObjOblByCgo.IsDataModified){
		ComShowCodeMessage("BKG40083");
		ComOpenWait(false);
		return;
	}
	//test bl_no ; TAOA14018502
	formObj.f_cmd.value=MULTI01;
	var aryPrefix=null;
	aryPrefix=new Array("bkg_cgo_rlse_", "sheet_bl_status_");    //prefix array
	var sParam1=sheetObjects["bkg_cgo_rlse"].GetSaveString(true);
	var sParam2=sheetObjects["sheet_bl_status"].GetSaveString(true);
	if(!sheetObjects["sheet_bl_status"].IsDataModified()){
		sheetObjects["sheet_bl_status"].RemoveAll();
		sParam3="";
	}
	sParam=sParam1 + "&" + sParam2 ;
	sheetObjMaster.SetCellValue(selRow,"master_" + "frt_clt_flg",formObj.info_frt_clt_flg.value);
	sheetObjMaster.SetCellValue(selRow,"master_" + "obl_rdem_flg",formObj.info_obl_rdem_flg.value);
	//Submitting sheet data if data is exist
	if(sheetObjCgoRlse.RowCount() > 0){

		//GAP Display Credit Risk (2014.10.14 An Jin Eung)
		if(!fnExistBlackListedCustomer(sheetObjCgoRlse, formObj.bl_no.value)){
			return false;
		}

		sheetObjCgoRlse.DoSave("ESM_BKG_0909GS.do"
			,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
			,-1
			,false);
	}else if(sheetObjOblByCgo.IsDataModified()){

		//GAP Display Credit Risk (2014.10.14 An Jin Eung)
		if(!fnExistBlackListedCustomer(sheetObjOblByCgo, formObj.bl_no.value)){
			return false;
		}

		sheetObjOblByCgo.DoSave("ESM_BKG_0909GS.do"
			,FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix)
			,-1
			,false);
	}
}

/**************************************************
* Hold
***************************************************/
function fncBtnHold(){
	var formObj=document.form;
	var sheetObj=sheetObjects["bkg_do_ref"];
	var sheetObjMaster=sheetObjects["master"];
	selRow=sheetObjMaster.GetSelectRow();

	var del_cd = sheetObjMaster.GetCellValue(selRow,"master_" + "del_cd");
	var pod_cd = sheetObjMaster.GetCellValue(selRow,"master_" + "pod_cd");
	
	if(del_cd.indexOf("CA") == 0 && pod_cd.indexOf("CA") == 0){
		ComShowCodeMessage("BKG08326","Canada","CA");//O/BL receipt update is not allowed for Canada destination cargo. please use CA cargo release to update it.
		return;
	}

	sheetObj.RemoveAll();
	var Row=sheetObj.DataInsert();
	var selRow=sheetObjects["master"].GetSelectRow();
	var prefix="bkg_do_ref_";
	sheetObj.SetCellValue(Row,prefix + "bkg_no", formObj.bkg_no.value);
	sheetObj.SetCellValue(Row,prefix + "bl_no", sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no"));
	if(sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg") == "Y"){
		sheetObj.SetCellValue(Row,prefix + "do_hld_flg","N");
	}else if(sheetObjMaster.GetCellValue(selRow,"master_" + "do_hld_flg") == "N"){
		sheetObj.SetCellValue(Row,prefix + "do_hld_flg","Y");
	}else{
		sheetObj.SetCellValue(Row,prefix + "do_hld_flg","N");
	}
	formObj.f_cmd.value=MULTI03;
	var aryPrefix=null;
	aryPrefix=new Array("bkg_do_ref_");    //prefix array
	var sParam1=sheetObjects["bkg_do_ref"].GetSaveString(true);
	sParam=sParam1;
	sheetObj.DoSave("ESM_BKG_0909GS.do",FormQueryString(formObj) + "&" + sParam + "&" + ComGetPrefixParam(aryPrefix),-1,false);
}
/**
  * event in case of deactivating Form Object
  * @return
  */
function obj_deactivate(){
	var objName=event.srcElement.name;
	var formObj=document.form;
	switch(objName) {
		case "start_date":
			ComChkObjValid(event.srcElement);
			break;
		case "end_date":
			ComChkObjValid(event.srcElement);
			break;
		case "start_time":
			ComChkObjValid(event.srcElement);
			break;
		case "end_time":
			ComChkObjValid(event.srcElement);
			break;
	}
}
/**
 * event in case of activating Form Object
 * @return
 */
function obj_activate(){
	var objName = ComGetEvent("name");
	var formObj=document.form;
	switch(objName) {
		case "start_date":
			formObj.start_date.value=formObj.start_date.value.replace(eval("/-/gi"), "");
			break;
		case "end_date":
			formObj.end_date.value=formObj.end_date.value.replace(eval("/-/gi"), "");
			break;
		case "start_time":
			formObj.start_time.value=formObj.start_time.value.replace(eval("/:/gi"), "");
			break;
		case "end_time":
			formObj.end_time.value=formObj.end_time.value.replace(eval("/:/gi"), "");
			break;
	}
}
function fncBtnHistory(){
	var goUrl="";
	var param="";
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	selRow=sheetObjMaster.GetSelectRow();
	goUrl="/opuscntr/ESM_BKG_0923.do?";
	param += "1=1";
	param += "&bl_no="+sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no");
	;
	param += "&pgmNo=ESM_BKG_0923";
	//location.href=goUrl + param;
	ComOpenWindowCenter(goUrl + param,"ESM_BKG_0923",800,420,false);
}
function fncBtnHoldHistory(){
	var goUrl="";
	var param="";
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	selRow=sheetObjMaster.GetSelectRow();
	goUrl="/opuscntr/ESM_BKG_0711.do?";
	param += "1=1";
	param += "&bl_no="+sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no");
	param += "&bkg_no="+sheetObjMaster.GetCellValue(selRow,"master_" + "bkg_no");
	param += "&pgmNo=ESM_BKG_0711";
	//location.href=goUrl + param;
	ComOpenWindowCenter(goUrl + param,"ESM_BKG_0711",800,440,false);
}
//setting images and code value with data from TPB
function tpbImgSet(tpbStatus) {
	if(tpbStatus) null ? document.getElementById("tpb_status").value : tpbStatus;
	if(	document.getElementById("tpb_status").value == "1"){
		document.getElementById("tpb_icon").src="img/btng_icon_green.gif";
		document.getElementById("tpb_cd").value='C';
		document.getElementById("btn_tpb").style.visibility="visible";
	}else if(document.getElementById("tpb_status").value == "0"){
		document.getElementById("tpb_icon").src="img/btng_icon_r.gif";
		document.getElementById("tpb_cd").value='P';
		document.getElementById("btn_tpb").style.visibility="visible";
	}else{
		document.getElementById("tpb_icon").src="img/btng_icon_g.gif";
		document.getElementById("tpb_cd").value='';
		document.getElementById("btn_tpb").style.visibility="hidden";
	}
}
function bkg_cgo_rlse_OnSaveEnd(sheetObj, Code, ErrMsg){
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
	ComOpenWait(false);

//    var selRow=sheetObjMaster.GetSelectRow();
//    if (ErrMsg == "Data Saved Successfully!!") {
//        //setting value of Master sheet with data from saving process
//        sheetObjMaster.SetCellValue(selRow,"master_" + "inter_rmk",formObj.inter_rmk.value);
//        sheetObjMaster.SetCellValue(selRow,"master_" + "frt_clt_flg",formObj.info_frt_clt_flg.value);
//        sheetObjMaster.SetCellValue(selRow,"master_" + "obl_rdem_flg",formObj.info_obl_rdem_flg.value);
//        if(sheetObjMaster.GetCellValue(selRow,"master_" + "cstms_clr_cd") == "X"){
//        	sheetObj.SetCellValue(1,"bkg_cgo_rlse_" + "cstms_clr_cd","X");
//        }else{
//        	sheetObj.SetCellValue(1,"bkg_cgo_rlse_" + "cstms_clr_cd",formObj.info_cstms_clr_cd.value);
//        }
//        master_OnDblClick(sheetObjMaster,selRow, 1);//double click event
//        doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
//    }
//	ComOpenWait(false);
//    //activating buttons
//    ComBtnEnable("btn_Save");
//    ComBtnEnable("btn_Hold");
//    ComBtnEnable("btn_History");
//	ComBtnEnable("btn_Hold_History");
}
function bkg_do_ref_OnSaveEnd(sheetObj, Code, ErrMsg){
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
	ComOpenWait(false);
//    var selRow=sheetObjMaster.GetSelectRow();
//    if (ErrMsg == "Data Saved Successfully!!") {
//    	sheetObjMaster.SetCellValue(selRow,"master_" + "do_hld_flg",sheetObj.GetCellValue(1,"bkg_do_ref_" + "do_hld_flg"));
////        master_OnDblClick(sheetObjMaster,selRow, 1);//double click event
//    	doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
//		ComOpenWait(false);
//    }
}
/************************************************
after retrieving Obl Grid data
************************************************/
function sheet_bl_status_OnSaveEnd(sheetObj, Code, ErrMsg){
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
	ComOpenWait(false);

//    var selRow=sheetObjMaster.GetSelectRow();
//    if (ErrMsg == "Data Saved Successfully!!") {
////        master_OnDblClick(sheetObjMaster,selRow, 1);//double click event
//    	doActionIBSheet(sheetObjMaster, formObj, IBSEARCH); //20150317 안진응 수정
//		ComOpenWait(false);
//    }
}
/*****************************************************************
* dbl click event of retrieved bl
******************************************************************/
function master_OnSearchEnd(sheetObj, ErrMsg){
	if (sheetObj.RowCount()== 0) {
		ComOpenWait(false);
		ComBtnEnable("btn_Retrieve");
		return;
	}
	var formObj=document.form;
	if(sheetObj.GetCellText(1,"master_"+"bl_no") != ""){
		master_OnDblClick(sheetObj,1, 5);
	}
	else{
		ComOpenWait(false);
		//combo
		formObj.info_frt_clt_flg.selectedIndex=0;
		formObj.info_obl_rdem_flg.selectedIndex=0;
//        formObj.info_cstms_clr_cd.selectedIndex=0;
		info_cstms_clr_cd.SetSelectIndex(0);

		//input
		formObj.demur_type.value="";
		formObj.dem_status.value="";
		formObj.curr_bl_no.value="";
		//initializing combo
		for(var k=formObj.tot_ots_amt.options.length;k > -1; k--){
			formObj.tot_ots_amt.remove(k);
		}
		for(var k=formObj.tot_bil_amt.options.length;k > -1; k--){
			formObj.tot_bil_amt.remove(k);
		}
		//initializing OBL
		var colName=new Array("bl_cpy_knt"
			,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
			,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
			,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
			,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
			,"obl_iss_rmk"
			);
		for(var i=0;i<colName.length;i++){
			if(colName[i] == "bl_otr_doc_rcv_cd"){
				formObj.bl_otr_doc_rcv_cd.selectedIndex=0;
			}else{
				document.getElementsByName(colName[i])[0].value="";
			}
		}
	}

	sheetObj.CheckAll("chk",0);
}
/*****************************************************************
* initializing values in case of changing B/L Receive[ComboBox] to 'N'
******************************************************************/
function blStatusInitByObl(){
	var formObj=document.form;
	var sheetObj=sheetObjects["sheet_bl_status"];
	var colName=new Array("bl_cpy_knt"
		,"bl_status","bl_rlse_ofc_cd","bl_rlse_usr_id","bl_rlse_dt"
		,"obl_rdem_knt","obl_rdem_ofc_cd","obl_rdem_usr_id","obl_rdem_dt"
		,"bl_otr_doc_rcv_cd","otr_doc_rcv_ofc_cd","otr_doc_rcv_usr_id","otr_doc_rcv_dt"
		,"bl_ibd","bl_ibd_ofc_cd","bl_ibd_usr_id","bl_ibd_dt"
		,"obl_iss_rmk"
		);
	if (formObj.info_obl_rdem_flg.selectedIndex == 1) {
		formObj.obl_rdem_knt.value="";
		formObj.obl_rdem_ofc_cd.value="";
		formObj.obl_rdem_usr_id.value="";
		formObj.obl_rdem_dt.value="";
		formObj.bl_ibd.value="";
		formObj.bl_ibd_ofc_cd.value="";
		formObj.bl_ibd_usr_id.value="";
		formObj.bl_ibd_dt.value="";
		formObj.bl_otr_doc_rcv_cd.selectedIndex=0;
		formObj.otr_doc_rcv_ofc_cd.value="";
		formObj.otr_doc_rcv_usr_id.value="";
		formObj.otr_doc_rcv_dt.value="";
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "obl_rdem_knt","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "obl_rdem_ofc_cd","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "obl_rdem_usr_id","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "obl_rdem_dt","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "bl_ibd","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "bl_ibd_ofc_cd","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "bl_ibd_usr_id","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "bl_ibd_dt","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "bl_otr_doc_rcv_cd","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "otr_doc_rcv_ofc_cd","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "otr_doc_rcv_usr_id","");
		sheetObj.SetCellValue(1, "sheet_bl_status_" + "otr_doc_rcv_dt","");
	}
}
/*****************************************************************
*
*****************************************************************/
function fncTestFrt(){
	var formObj=document.form;
	var sheetObj=sheetObjects["test_foc"];
	sheetObj.DataInsert();
	formObj.f_cmd.value=MULTI16;
	sheetObj.DoAllSave("ESM_BKG_0909GS.do"
		,FormQueryString(formObj)
		,false);
}
/*****************************************************************
*
*****************************************************************/
function fncTestObl(){
	var formObj=document.form;
	var sheetObj=sheetObjects["test_foc"];
	sheetObj.DataInsert();
	formObj.f_cmd.value=MULTI17;
	sheetObj.DoAllSave("ESM_BKG_0909GS.do",FormQueryString(formObj),false);
}
/*****************************************************************
*
*****************************************************************/
function fncTestCstms(){
	var formObj=document.form;
	var sheetObj=sheetObjects["test_foc"];
	sheetObj.DataInsert();
	formObj.f_cmd.value=MULTI18;
	sheetObj.DoAllSave("ESM_BKG_0909GS.do",FormQueryString(formObj),false);
}
/*****************************************************************
*Multiple 체크하고 제어할 수 없는 버튼들 validation
*****************************************************************/
function fncCtrlButton(){
	var rCnt=sheetObjects["master"].RowCount()+1;
	var chkCnt = 0;
	for(i= 1; i < rCnt;i++){
		if(sheetObjects["master"].GetCellValue(i, "chk") == 1){
			chkCnt++;
		}
	}
	if(chkCnt >= 2)
	{ComShowCodeMessage("BKG43045"); //You cannot manage multiple BLs using this function
	  return false;}
	else{
	  return true;
	}
}

/*************************************************************************
*Save(단건 TDC315 전송)버튼과 Hold 버튼 누를 때 Form의 BL과 Sheet의 BL 맞춤
*Grid의 BL과 Form의 BL이 같을 때만 Save와 hold 할수있도록 Validtion
*(grid 의 row를 더블클릭 안한채로 (grid의 아무 BL을 클릭한 채로) save나 hold를 하면
*form에 있는 값이 그리드의 BL과 상관없는 BL인데도 저장이 될 가능성이 있음)
*****************************************************************/
function fncChkBl(){
	var formObj=document.form;
	var sheetObjMaster=sheetObjects["master"];
	var Row;
	var selRow;

	selRow=sheetObjMaster.GetSelectRow();
	var gridBl =sheetObjMaster.GetCellValue(selRow,"master_" + "bl_no");

	if(formObj.curr_bl_no.value != gridBl)
	{ComShowCodeMessage("BKG43047"); //B/L on the grid and below form is not the same. Please double click the grid.
	  return false;}
	else{
	  return true;
	}
}
/**********************************************************************************
*Multiple 체크 체크한 BL 중 User가 매뉴얼로 Hold한 BL이 있다면 TDC315 Multi 전송 막음
***************************************************************************8*******/
function fncHldChkButton(){
	var rCnt=sheetObjects["master"].RowCount()+1;
	var chkCnt = 0;
	var hldBls="";
	for(i= 1; i < rCnt;i++){

	  if(sheetObjects["master"].GetCellValue(i, "chk") == 1){

		 if(sheetObjects["master"].GetCellValue(i, "master_" + "do_hld_flg") == "Y"){
			chkCnt++;
			hldBls += sheetObjects["master"].GetCellValue(i, "master_" + "bl_no")+" ";
		}
	  }
	}

	if(chkCnt >= 1)
	{ComShowCodeMessage("BKG43048", hldBls); //B/L [{?msg1}] is 'Hold' status. (User made the BL Hold) Please un-check the B/L ,and send.
	  return false;}
	else{
	  return true;
	}
}


/**********************************************************************************
*Destination check.
***************************************************************************8*******/
function fncDestChk(){
	var rCnt=sheetObjects["master"].RowCount()+1;
	var chkCnt = 0;
	var caBls="";
	for(i= 1; i < rCnt;i++){

	  if(sheetObjects["master"].GetCellValue(i, "chk") == 1){

		  var delCd = sheetObjects["master"].GetCellValue(i, "master_" + "del_cd").substring(0,2);
		  var podCd = sheetObjects["master"].GetCellValue(i, "master_" + "pod_cd").substring(0,2);
 
		  if(delCd == "CA" && podCd == "CA"){
			chkCnt++;
			caBls += sheetObjects["master"].GetCellValue(i, "master_" + "bl_no")+" ";

		  }
	  }
	}

	if(chkCnt >= 1)
	{	ComShowCodeMessage("BKG08326", "Canada","CA", caBls); //O/BL receipt update is not allowed for {?msg1} destination cargo.\nplease use {?msg2} cargo release to update it. ({?msg3}).
	  return false;}
	else{
	  return true;
	}
}

//GAP Display Credit Risk (2014.10.14 An Jin Eung)
/**
 * fnExistBlackListedCustomer
 * param :_val
 */
function fnExistBlackListedCustomer(sheetObj, bkgNo) {

	var formObj = document.form;

	var param = "&f_cmd=" + COMMAND02 + "&input_text=" + bkgNo;

	var sXml = sheetObj.GetSearchData("ESM_Booking_UtilGS.do", param);
	var output_text=ComGetEtcData(sXml, "output_text");

	if (output_text != '') {
//		ComShowMessage(ComGetMsg("BKG43055", output_text ));
		if(!ComShowCodeConfirm("BKG43055", output_text)){
			return false;
		} else {
			return true;// Y-> error
		}

	}
	return true;
}

