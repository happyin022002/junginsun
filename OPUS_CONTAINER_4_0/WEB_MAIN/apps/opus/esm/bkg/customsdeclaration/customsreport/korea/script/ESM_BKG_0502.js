/**=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0502.js
*@FileTitle  : Korea Transmit History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================**/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	//common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;

	// Event handler processing by button click event
	document.onclick=processButtonClick;

	// Event handler processing by button name
	function processButtonClick()
	{
		var sheetObject1=sheetObjects[0];
		var sheetObject2=sheetObjects[1];
		var comboObject1=comboObjects[0];
		var comboObject2=comboObjects[1];
		/*******************************************************/
		var formObject=document.form;
		try
		{
			var srcName=ComGetEvent("name");
			switch(srcName)
			{
				case "btn_retrieve":
					//sheetObject1.RenderSheet(0); // ***##
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					toggleSendUnsend();
					//sheetObject1.RenderSheet(1); // ***##
					break;

				case "btn_new":
					sheetObject1.RemoveAll();
					funcChangSearchOption(formObject, "VVD");
					comboObject1.SetSelectCode('5CD');
					comboObject2.SetSelectCode('D');
					formObject.in_sub_cd.value='';
					formObject.in_bl_no.value='';
					formObject.in_vsl_cd.value='';
					formObject.in_pol_cd.value='';
					formObject.in_pod_cd.value='';
					formObject.in_ofc_cd.value='';
					formObject.in_usr_id.value='';
					formObject.in_date_op.value='SEND_DATE';
					formObject.in_snd_dt_s.value=ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
					formObject.in_snd_dt_e.value=ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
					break;

				case "btn_view":
					var Row=sheetObject1.GetSelectRow();
					if (Row > 0) {
						var param ="msg_loc_tp_id="+sheetObject1.GetCellValue(Row, "a_msg_log_tp_id") +
									"&snd_dt="+sheetObject1.GetCellValue(Row, "a_snd_dt_dd") + " " + ComGetMaskedValue(sheetObject1.GetCellValue(Row, "a_snd_dt_tt"),"hms") +
									"&ofc_cd="+sheetObject1.GetCellValue(Row, "a_ofc_cd") +
									"&mf_snd_seq="+sheetObject1.GetCellValue(Row, "mf_snd_seq") +
									"&pgmNo=ESM_BKG_0989";

//						ComOpenWindow("ESM_BKG_0989.do?"+param, "ESM_BKG_0989", "toolbar=no,location=no,status=no,menubar=no,scrollbars=no,resizable=no,width=660,height=500");
						// ComOpenPopup(sUrl, iWidth, iHeight, sFunc, sDisplay, bModal, b2ndSheet, iRow, iCol, iSheetIdx, sWinName, sScroll);
						ComOpenPopup("ESM_BKG_0989.do?"+param, 660, 450, "", "1,0", true);
					}
					break;

				case "rad_vvd_op":
					if (formObject.combo1.Code != "5VD") funcChangSearchOption(formObject, "VVD");
					break;

				case "rad_bl_op":
					if (formObject.combo1.Code != "5VD") funcChangSearchOption(formObject, "BL");
					break;

				case "rad_sub_op":
					if (formObject.combo1.Code != "5VD") funcChangSearchOption(formObject, "SUB");
					break;

				case "rad_date_op":
					funcChangSearchOption(formObject, "DATE");
					break;

				case "btn_calendar1":
					var cal=new ComCalendarFromTo();
					funcChangSearchOption(formObject, "DATE");
					cal.select(formObject.in_snd_dt_s,formObject.in_snd_dt_e, 'yyyy-MM-dd');
					break;

				case "view_send_unsend":
					sheetObject1.RenderSheet(0);
					sheetObject1.ShowWait
					toggleSendUnsend();
					sheetObject1.RenderSheet(1);
					break;
			}

		} catch(e) {
			if (e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e);
			}
		}
	}

	/**
	 * 검색조건을 설정한다.
	 * @param op
	 * @return
	 */
	function funcChangSearchOption(formObj, op) {

		if(op == "VVD") {
			formObj.rad_vvd_op.checked=true;
			formObj.rad_bl_op.checked=false;
			formObj.rad_sub_op.checked=false;
			formObj.rad_date_op.checked=false;
			formObj.in_vsl_cd.className="input1";
			formObj.in_bl_no.className="input2";
			formObj.in_sub_cd.className="input2";
			formObj.in_snd_dt_s.className="input2";
			formObj.in_snd_dt_e.className="input2";
			formObj.in_vsl_cd.disabled=false;
			formObj.in_bl_no.disabled=true;
			formObj.in_sub_cd.disabled=true;
			formObj.in_snd_dt_s.disabled=true;
			formObj.in_snd_dt_e.disabled=true;
			formObj.in_date_op.disabled=true;
			formObj.in_vsl_cd.value="";
			formObj.in_vsl_cd.focus();

		} else if(op == "BL") {
			formObj.rad_vvd_op.checked=false;
			formObj.rad_bl_op.checked=true;
			formObj.rad_sub_op.checked=false;
			formObj.rad_date_op.checked=false;
			formObj.in_vsl_cd.className="input2";
			formObj.in_bl_no.className="input1";
			formObj.in_sub_cd.className="input2";
			formObj.in_snd_dt_s.className="input2";
			formObj.in_snd_dt_e.className="input2";
			formObj.in_vsl_cd.disabled=true;
			formObj.in_bl_no.disabled=false;
			formObj.in_sub_cd.disabled=true;
			formObj.in_snd_dt_s.disabled=true;
			formObj.in_snd_dt_e.disabled=true;
			formObj.in_date_op.disabled=true;
			formObj.in_bl_no.value="";
			formObj.in_bl_no.focus();

		} else if(op == "SUB") {
			formObj.rad_vvd_op.checked=false;
			formObj.rad_bl_op.checked=false;
			formObj.rad_sub_op.checked=true;
			formObj.rad_date_op.checked=false;
			formObj.in_vsl_cd.className="input2";
			formObj.in_bl_no.className="input2";
			formObj.in_sub_cd.className="input1";
			formObj.in_snd_dt_s.className="input2";
			formObj.in_snd_dt_e.className="input2";
			formObj.in_vsl_cd.disabled=true;
			formObj.in_bl_no.disabled=true;
			formObj.in_sub_cd.disabled=false;
			formObj.in_snd_dt_s.disabled=true;
			formObj.in_snd_dt_e.disabled=true;
			formObj.in_date_op.disabled=true;
			formObj.in_sub_cd.value="";
			formObj.in_sub_cd.focus();

		} else if(op == "DATE") {
			formObj.rad_vvd_op.checked=false;
			formObj.rad_bl_op.checked=false;
			formObj.rad_sub_op.checked=false;
			formObj.rad_date_op.checked=true;
			formObj.in_vsl_cd.className="input2";
			formObj.in_bl_no.className="input2";
			formObj.in_sub_cd.className="input2";
			formObj.in_snd_dt_s.className="input1";
			formObj.in_snd_dt_e.className="input1";
			formObj.in_vsl_cd.disabled=true;
			formObj.in_bl_no.disabled=true;
			formObj.in_sub_cd.disabled=true;
			formObj.in_snd_dt_s.disabled=false;
			formObj.in_snd_dt_e.disabled=false;
			formObj.in_date_op.disabled=false;
			if (comboObjects[0].Code != '5VD' ){
				formObj.in_date_op.disabled 	= false;
			}
			formObj.in_snd_dt_s.focus();
		}
		formObj.p_search_option.value=op;
	}
	 /**
	  * registering IBSheet Object as list
	  * adding process for list in case of needing batch processing with other items
	  * defining list on the top of source
	  */
	function setSheetObject(sheet_obj)
	{
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage()
	{
		var form=document.form;
		for(i=0;i<sheetObjects.length;i++)
		{
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var k=0;k<comboObjects.length;k++){
			initCombo(comboObjects[k],k+1);
		}

		funcChangSearchOption(document.form, "VVD");

		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');

		comboObjects[0].SetSelectCode('5CD');
		comboObjects[1].SetSelectCode('D');

		form.in_snd_dt_s.value=ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
		form.in_snd_dt_e.value=ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo)
	{
		var cnt=0;
		switch(sheetNo)
		{
		case 1:      //sheet1 init
			with(sheetObj){
				  //no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
				  var HeadTitle="Seq.|MSG|Receiver ID|Receiver|Corr.GetSelectCode()|Send Date|Send Date|VVD|POL|POD|Office|B/L No.|Submit No.|B/L Count|40FT|20FT|User ID|Type|Cancel type|Cancel Reson|Cancel Desc.||";

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:0 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"a_msg_log_tp_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:85,   Align:"Left",    ColMerge:0,   SaveName:"a_mf_rcvr_usr_id",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"a_receiver",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"a_corr_cd1",        KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"a_snd_dt_dd",       KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"a_snd_dt_tt",       KeyField:0,   CalcLogic:"",   Format:"Hms",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:95,   Align:"Center",  ColMerge:0,   SaveName:"a_vvd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"a_pol_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"a_pod_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_ofc_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"a_bl_no",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:140,  Align:"Center",  ColMerge:0,   SaveName:"a_submit_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"a_bl_knt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"a_fld_40ft",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:"a_fld_20ft",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"a_trsm_usr_id",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"a_ks_type",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsm_cxl_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsm_cxl_rsn_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"trsm_cxl_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"if_sended",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"Text",      Hidden:1, Width:75,   Align:"Center",  ColMerge:0,   SaveName:"mf_snd_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];

				  InitColumns(cols);

				  SetEditable(0);
				  SetCountPosition(0);
				  SetSheetHeight(410);
				}
			break;
		}
	}
	/**
	 * init combo
	 * @param comboObj
	 * @param comboNo
	 * @return
	 */
	function initCombo(comboObj, comboNo) {
		var cnt=0;

		switch(comboObj.options.id) {
		case "combo1":
			with (comboObj) {
				SetMultiSeparator("|");
				Init(1);
				SetColAlign(0, "center");
				SetColAlign(1, "center");
				SetColAlign(2, "left");
				SetColWidth(0, "40");
				SetColWidth(1, "40");
				SetColWidth(2, "300");
				SetDropHeight(400);
				//no support[check again]CLT ShowCol=1;
				SetTitle("SEQ|MSG|Message Description");
				SetMultiSelect(0);
				SetMaxSelect(1 );
				InsertItem(cnt ++, cnt+"|5CD|수출 적하목록 상세사항 (CUSMAN)", "5CD");
				InsertItem(cnt ++, cnt+"|5IB|수입 적하목록 상세사항 (CUSMAN)", "5IB");
				InsertItem(cnt ++, cnt+"|5ID|하선신고서 (CUSAGD)",			"5ID");
				InsertItem(cnt ++, cnt+"|5LK|하선신고 정정 (CUSDMR)", 	"5LK");
				InsertItem(cnt ++, cnt+"|5CG|수출 적하목록 정정 (CUSMOD)", 	"5CG");
				InsertItem(cnt ++, cnt+"|5LI|수입 적하목록 정정 (IFTMOD)", 	"5LI");
				InsertItem(cnt ++, cnt+"|6TC|외항 위험물알람표 (DGMNFT)", 		"6TC");
				InsertItem(cnt ++, cnt+"|6TA|외항 위험물반입신고서 (CARDGN)",	"6TA");
				InsertItem(cnt ++, cnt+"|6SJ|화물반출정정신고 (MACAMD)", 		"6SJ");
				InsertItem(cnt ++, cnt+"|6SK|화물반입정정신고 (MACAMD)", 		"6SK");
				InsertItem(cnt ++, cnt+"|5VD|적하목록 취하신청서 송신 (PORTAL)","5VD");
				Code="5CD";
			}
			break;
		case "combo2":
			with (comboObj) {
				SetMultiSeparator("|");
				SetColAlign(0, "center");
				SetColAlign(1, "left");
				SetColWidth(0, "50");
				SetColWidth(1, "100");
				SetDropHeight(400);
				//no support[check again]CLT 				ShowCol=0;
				SetTitle("Type|Description");
				SetMultiSelect(0);
				SetMaxSelect(1 );
				InsertItem(cnt ++, "A|미주 LOCAL", "A");
				InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
				InsertItem(cnt ++, "C|T/S", "C");
				InsertItem(cnt ++, "D|A+B+C+M", "D");
				InsertItem(cnt ++, "E|운항정보 Only", "E");
				InsertItem(cnt ++, "M|eMpty Local", "M");
			}
			break;
		}
	}
	/**
	 * handling comboBox change
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */
	var ac = "";
	function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var form = document.form;
		 form.in_msg_type.value = newCode;
		 var value = newCode;
		 ac = newCode;
		 var cnt=0;
		if (value == "5CD") {
			objEnable();
			comboObjects[1].RemoveAll();
			comboObjects[1].InsertItem(cnt ++, "A|미주 LOCAL", "A");
			comboObjects[1].InsertItem(cnt ++, "B|아/구주 LOCAL", "B");
			comboObjects[1].InsertItem(cnt ++, "C|T/S", "C");
			comboObjects[1].InsertItem(cnt ++, "D|A+B+C+M", "D");
			comboObjects[1].InsertItem(cnt ++, "E|운항정보 Only", "E");
			comboObjects[1].InsertItem(cnt ++, "M|eMpty Local", "M");

//			if (comboObjects[1].GetItemCount() == 3){
//				comboObjects[1].DeleteItem("E");
//				comboObjects[1].DeleteItem(" ");
//				comboObjects[1].DeleteItem("M");
//				initCombo(comboObjects[1], 2);
//			}
			comboObjects[1].SetEnable(1);
			comboObjects[1].SetSelectCode('D');

		} else if (value == "5IB"||value == "5ID"||value == "6SJ"||value == "6SK") {
			objEnable();
			comboObjects[1].RemoveAll();
			comboObjects[1].InsertItem(cnt ++, "E|운항정보 Only", "E");
			comboObjects[1].InsertItem(cnt ++, "M|eMpty Local", "M");
			comboObjects[1].InsertItem(-1, " | ", " ");

//			comboObjects[1].DeleteItem("A");
//			comboObjects[1].DeleteItem("B");
//			comboObjects[1].DeleteItem("C");
//			comboObjects[1].DeleteItem("D");
//			alert(comboObjects[1].length)
//			if(comboObjects[1].GetCount() == 2){
//				comboObjects[1].InsertItem(-1, " | ", " ");
//			}
			comboObjects[1].SetEnable(1);
			comboObjects[1].SetSelectCode('E');

		} else if( value == "5VD") {
			sheetObjects[0].RemoveAll();
			document.form.reset();
			form.in_msg_type.value = value;

			funcChangSearchOption(document.form, "DATE");
			document.form.in_date_op.value = 'SEND_DATE';
			document.form.in_snd_dt_s.value = ComGetMaskedValue(ComGetDateAdd(ComGetNowInfo("ymd"),"D", -1),"ymd");
			document.form.in_snd_dt_e.value = ComGetMaskedValue(ComGetNowInfo("ymd"),"ymd");

			document.form.rad_vvd_op.disabled = true;
			document.form.rad_bl_op.disabled = true;
			document.form.rad_sub_op.disabled = true;
			document.form.in_date_op.disabled = true;

			comboObjects[1].SetSelectCode('D');;
			document.form.combo2.SetEnable(0);
			document.form.in_pol_cd.disabled = true;
			document.form.in_pol_cd.className = "input2";
			document.form.in_pod_cd.disabled = true;
			document.form.in_pod_cd.className = "input2";
			document.form.in_ofc_cd.disabled = true;
			document.form.in_ofc_cd.className = "input2";
			document.form.in_usr_id.disabled = true;
			document.form.in_usr_id.className = "input2";

			for( var idx = 0;idx<document.form.view_send_unsend.length;idx++ ){
				document.form.view_send_unsend[idx].disabled = true;
			}

			sheetObjects[0].ColHidden("trsm_cxl_tp_cd") = false;
			sheetObjects[0].ColHidden("trsm_cxl_rsn_cd") = false;
			sheetObjects[0].ColHidden("trsm_cxl_desc") = false;

		} else {
			objEnable();
			comboObjects[1].SetSelectCode('');
			form.in_ks_type.value = '';
			comboObjects[1].SetEnable(0);
		}
	}
	function combo1_OnBlur() {
		document.form.in_msg_type.value = ac;
	}
	/**
	 * handling comboBox change
	 * @param comboObj
	 * @param value
	 * @param text
	 * @return
	 */
	function combo2_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
		var form=document.form;
		var value;
		value = form.in_ks_type.value;
		form.in_ks_type.value = comboObj.GetText(parseInt(newIndex), 0);
	}

	// handling of Sheet process
	function doActionIBSheet(sheetObj,formObj,sAction)
	{
		switch(sAction)
		{
		case IBSEARCH:      //retrieveing
		if (validateForm(sheetObj, formObj, sAction)) {
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_BKG_0502GS.do", FormQueryString(formObj),{Sync:2} ); // *****
			formObj.in_snd_dt_s.value=ComGetMaskedValue(formObj.in_snd_dt_s.value, "ymd");
			formObj.in_snd_dt_e.value=ComGetMaskedValue(formObj.in_snd_dt_e.value, "ymd");
			ComOpenWait(false);
		}
		break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
			formObj.in_snd_dt_s.value=ComGetUnMaskedValue(formObj.in_snd_dt_s.value, "ymd");
			formObj.in_snd_dt_e.value=ComGetUnMaskedValue(formObj.in_snd_dt_e.value, "ymd");
			switch(formObj.p_search_option.value) {
			case "VVD":
				if (formObj.in_vsl_cd.value.length < 9) {
					ComShowCodeMessage('BKG00115');
					formObj.in_vsl_cd.focus();
					return false;
				}
				break;
			case "BL":
				if (formObj.in_bl_no.value.length < 1) {
					ComShowCodeMessage('BKG00266');
					formObj.in_bl_no.focus();
					return false;
				}
				break;
			case "SUB":
				if (formObj.in_sub_cd.value.length < 19) {
					ComShowCodeMessage("COM130201", "Sub.No");
					formObj.in_sub_cd.focus();
					return false;
				}
				break;
			case "SEND_DATE":
			case "ETA":
			case "ETD":
			case "DATE":
				if (formObj.in_snd_dt_s.value.length < 8) {
					ComShowCodeMessage('BKG00341');
					formObj.in_snd_dt_s.focus();
					return false;
				}
				if (formObj.in_snd_dt_e.value.length < 8) {
					ComShowCodeMessage('BKG00341');
					formObj.in_snd_dt_e.focus();
					return false;
				}
				formObj.p_search_option.value=formObj.in_date_op.value;
				break;
			}
		}
		return true;
	}
	/**
	 * register combo Object to comboObjects array
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
	/**
	 * SEND, UNSEND
	 * @return
	 */
	function toggleSendUnsend()
	{
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		for(var i=1; i <= sheetObj.RowCount(); i++) {
			// SEND checked
			if (formObj.view_send_unsend[1].checked) {
				if (sheetObj.GetCellValue(i, "if_sended")=="Send") // ***
					sheetObj.SetRowHidden(i,0);
				else
					sheetObj.SetRowHidden(i,1);
			}else if (formObj.view_send_unsend[2].checked) {
				// UNSEND checked
				if (sheetObj.GetCellValue(i, "if_sended")!="Send") // ***
					sheetObj.SetRowHidden(i,0);
				else
					sheetObj.SetRowHidden(i,1);
			}else {
				// All Check
				sheetObj.SetRowHidden(i,0);
			}
		}
	}

	function objEnable(){
		document.form.rad_vvd_op.disabled = false;
		document.form.rad_bl_op.disabled = false;
		document.form.rad_sub_op.disabled = false;
		document.form.in_date_op.disabled = false;
		document.form.combo2.enable = true;
		document.form.in_pol_cd.disabled = false;
		document.form.in_pol_cd.className = "input";
		document.form.in_pod_cd.disabled = false;
		document.form.in_pod_cd.className = "input";
		document.form.in_ofc_cd.disabled = false;
		document.form.in_ofc_cd.className = "input";
		document.form.in_usr_id.disabled = false;
		document.form.in_usr_id.className = "input";

		for( var idx=0;idx<document.form.view_send_unsend.length;idx++ ){
			document.form.view_send_unsend[idx].disabled = false;
		}

		sheetObjects[0].SetColHidden("trsm_cxl_tp_cd", 1);
		sheetObjects[0].SetColHidden("trsm_cxl_rsn_cd", 1);
		sheetObjects[0].SetColHidden("trsm_cxl_desc", 1);
	}
