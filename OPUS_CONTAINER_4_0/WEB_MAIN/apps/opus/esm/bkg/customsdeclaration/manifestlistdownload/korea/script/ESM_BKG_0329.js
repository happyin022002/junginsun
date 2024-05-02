/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0329
*@FileTitle  : Korea Manifest Download
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/

var tabObjects = new Array();
var tabCnt = 0 ;
var beforetab = 1;
var sheetObjects = new Array();
var sheetCnt = 0;
var cur_pol_pod = "pod";
var hiddenIndex = new Array();
var IndexTop = 0;
var crossChk = false;

var IBTRANS = 1092;
var ViewOptionErrCheck = "";		//"", "E"
var ViewOptionBlType = "";			//"", "S", "C", "E"
var ViewOptionElNo = "";			//"", "Y", "N"
var ViewOptionCorrection = "";		//"", "N", "I", "X", "V", "U"
var ViewOptionCargoType = "";
var thisRow = 0;
var intervalId = "";
var comboObjects = new Array();
var comboCnt = 0;

document.onclick = processButtonClick;

	function processButtonClick() {
		var sheetObject = sheetObjects[0];
		var sheetObject1 = sheetObjects[1];
		var sheetObject2 = sheetObjects[2];
		var sheetObject3 = sheetObjects[3];
		crossChk = false;
		var formObj = document.form;
		try {
			var srcName = ComGetEvent("name");
			switch(srcName) {
				case "btn_retrieve":
					if (formObj.rad_crscheck.checked) {
						crossChk = true;
					} else {
						crossChk = false;
					}
					doActionIBSheet(sheetObject, formObj, SEARCH);
					break;
				case "btn_New":
					formObj.reset();
					funcOnFocus("pol");
					funcClearAll(sheetObjects, formObj);
					updateSummary();
					break;
				case "btn_Delete":
					doActionIBSheet(sheetObject, formObj, IBDELETE);
					break;
				case "btn_DownExcel":
					doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
					break;
				case "btn_DataDL":
					doActionIBSheet(sheetObject, formObj, IBINSERT);
					break;
				case "btn_AddBL":
					funcBlAddnEditPopup("ADD");
					break;
				case "btn_EditBL":
					funcBlAddnEditPopup("EDIT");
					break;
				case "btn_Transmission":
					ComOpenWait(true);
					if (document.transmitForm) {
						var N=document.transmitForm;
						N.parentNode.removeChild(N);
					}
					var f=document.createElement("form");
					f.name="transmitForm";
					f.method="POST";
					f.action="ESM_BKG_0344_POP.do?pgmNo=ESM_BKG_0344";
					f.target="transmitWindow";
					document.body.appendChild(f);
					addHiddenField(f, "in_vvd", 	formObj.in_vvd.value);
					addHiddenField(f, "in_pol", 	formObj.in_pol.value);
					addHiddenField(f, "in_pol_yd", 	formObj.in_pol_yd.value);
					addHiddenField(f, "in_type", 	formObj.sel_type.value);
					addHiddenField(f, "in_pod", 	formObj.in_pod.value);
					addHiddenField(f, "in_tml", 	formObj.in_hn.value);
					addHiddenField(f, "in_blno", 	formObj.in_blno.value);
					addHiddenField(f, "in_bound", 	formObj.in_bound.value);
					addHiddenField(f, "dwell", 		sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_dwell_dt"));
					addHiddenField(f, "ib_vvd", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_vvd"));
					addHiddenField(f, "ib_seq", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_trns_seq"));
					addHiddenField(f, "ib_cblno", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_c_bl_no"));
					addHiddenField(f, "ib_port", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_dmst_port_cd"));
					addHiddenField(f, "ib_bkgno", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_mty_bkg_no"));
					addHiddenField(f, "ib_type", 	sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_cstms_decl_tp_cd"));
					var inboundVVd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(), "sheet1_ib_vvd");
					if (inboundVVd.trim().length > 1) {
						for(var i=2; i < sheetObjects[0].RowCount()+2; i++) {
							if (sheetObjects[0].GetCellValue(i, "sheet1_ib_vvd")!=inboundVVd) continue;
							addHiddenField(f, "ib_ts_seq", 		sheetObjects[0].GetCellValue(i, "sheet1_ib_trns_seq"));
							addHiddenField(f, "ib_ts_cblno", 	sheetObjects[0].GetCellValue(i, "sheet1_ib_mty_bl_no"));
							addHiddenField(f, "ib_ts_port", 	sheetObjects[0].GetCellValue(i, "sheet1_ib_dmst_port_cd"));
							addHiddenField(f, "ib_ts_bkgno", 	sheetObjects[0].GetCellValue(i, "sheet1_ib_mty_bkg_no"));
							addHiddenField(f, "ib_ts_type", 	sheetObjects[0].GetCellValue(i, "sheet1_ib_cstms_decl_tp_cd"));
							addHiddenField(f, "ib_ts_vvd", 		sheetObjects[0].GetCellValue(i, "sheet1_ib_vvd"));
						}
					}
					ComOpenWait(false);
					window.open("about:blank", "transmitWindow", "width=1280, height=650, scrollbars=no");
	//				var params="";
	//				ComOpenWindowCenter("ESM_BKG_0344_POP.do"+params, "ESM_BKG_0344", 1230, 650,false);
					f.submit();
					break;
				case "rad_ib":
					funcOnFocus("pod");
					formObj.el_type.value="";
					funcElTypeOnChange(formObj.el_type);
					break;
				case "rad_ob":
					funcOnFocus("pol");
					formObj.cgo_tp.value="";
					funcCargoTypeOnChange(formObj.cgo_tp);
					break;
				case "rad_nodownlist":
					formObj.rad_nodownlist.checked=true;
					formObj.rad_downedlist.checked=false;
					formObj.rad_mftcheck.checked=false;
					formObj.rad_crscheck.checked=false;
					formObj.bl_dl.value="bl";
					formObj.bl_bkg_tp.value="BL";
					formObj.bl_bkg_tp.disabled=true;
					formObj.msn_start_num.style.display="none";
					document.all.btn_msn_save.style.display="none";
					document.all.etb_td1.style.display="none";
					document.all.etb_td2.style.display="none";
					document.all.sc_td1.style.display="none";
					document.all.sc_td2.style.display="none";
					break;
				case "rad_downedlist":
					formObj.rad_nodownlist.checked=false;
					formObj.rad_downedlist.checked=true;
					formObj.rad_mftcheck.checked=false;
					formObj.rad_crscheck.checked=false;
					formObj.bl_dl.value="dl";
					formObj.bl_bkg_tp.disabled=false;
					if (formObj.in_pod.value=="KRPUS" && formObj.rad_ib.checked) {
						formObj.msn_start_num.style.display="inline";
						document.all.btn_msn_save.style.display="inline";
					} else {
						formObj.msn_start_num.style.display="none";
						document.all.btn_msn_save.style.display="none";
					}
					if (formObj.rad_ob.checked) {
						document.all.etb_td1.style.display="inline";
						document.all.etb_td2.style.display="inline";
					}
					document.all.sc_td1.style.display="none";
					document.all.sc_td2.style.display="none";
					break;
				case "rad_mftcheck":
					formObj.rad_nodownlist.checked=false;
					formObj.rad_downedlist.checked=false;
					formObj.rad_crscheck.checked=false;
					formObj.rad_mftcheck.checked=true;
					formObj.bl_dl.value="mc";
					formObj.bl_bkg_tp.disabled=false;
					formObj.msn_start_num.style.display="none";
					document.all.btn_msn_save.style.display="none";
					document.all.etb_td1.style.display="none";
					document.all.etb_td2.style.display="none";
					document.all.sc_td1.style.display="inline";
					document.all.sc_td2.style.display="inline";
					break;
				case "rad_crscheck":
					formObj.rad_nodownlist.checked=false;
					formObj.rad_downedlist.checked=false;
					formObj.rad_mftcheck.checked=false;
					formObj.rad_crscheck.checked=true;
					formObj.bl_dl.value="cr";
					formObj.bl_bkg_tp.disabled=false;
					formObj.msn_start_num.style.display="none";
					document.all.btn_msn_save.style.display="none";
					document.all.etb_td1.style.display="none";
					document.all.etb_td2.style.display="none";
					document.all.sc_td1.style.display="none";
					document.all.sc_td2.style.display="none";
					break;
				case "rad_all":
					formObj.all_err.value="all";
					formObj.rad_all.checked=true;
					formObj.rad_err.checked=false;
					ViewOptionErrCheck="";
					funcShowValueRows();
					break;
				case "rad_err":
					formObj.all_err.value="err";
					formObj.rad_all.checked=false;
					formObj.rad_err.checked=true;
					ViewOptionErrCheck="E";
					funcShowValueRows();
					break;
				case "in_pol":
					funcOnFocus("pol");
					formObj.in_pol.focus();
					break;
				case "in_pod":
					funcOnFocus("pod");
					formObj.in_pod.focus();
					break;
				case "btn_msn_save":
					if (formObj.msn_start_num.value.length < 4) {
						ComShowCodeMessage("COM130201", "MSN No.");
						formObj.msn_start_num.focus();
					} else {
						doActionIBSheet(sheetObject, formObj, COMMAND01);
					}
					break;
			}
		} catch(e) {
			if( e == "[object Error]") {
				ComShowMessage(OBJECT_ERROR);
			} else {
				ComShowMessage(e.message);
			}
		}
	}


	function sheet1_OnClick(Obj, Row, Col) {
		var Obj1=Obj;
		var Obj2=sheetObjects[1];
		if (Obj1.ColSaveName(Col) =="sheet1_crs_chk_rmk") {
			ComShowMemoPad(sheetObjects[0], Row, Col, false, 200, 200);
		}
		if(Obj1.ColSaveName(Col) != "sheet1_sel") return;
		var colIndex1=Obj1.SaveNameCol("sheet1_a_bkg_no");
		var colIndex2=Obj2.SaveNameCol("sheet2_bkg_no");
		var updIndex1=Obj1.SaveNameCol("sheet1_ibflag");
		var updIndex2=Obj2.SaveNameCol("sheet2_ibflag");
		if (Obj1.GetCellValue(Row, Col) == 1) {
			var text=Obj1.GetCellValue(Row, colIndex1);
			for(var i=1;i<=Obj2.RowCount();i++) {
				if(Obj2.GetCellValue(i, colIndex2) == text) {
					var SelIndex=Obj2.SaveNameCol("sheet2_sel");
					Obj2.SetCellValue(i, SelIndex,0);
					Obj2.SetCellValue(i, updIndex2,"");
				}
			}
		} else {
			var text=Obj1.GetCellValue(Row, colIndex1);
			for(var i=1;i<=Obj2.RowCount();i++) {
				if(Obj2.GetCellValue(i, colIndex2) == text) {
					var SelIndex=Obj2.SaveNameCol("sheet2_sel");
					Obj2.SetCellValue(i, SelIndex,1);
					Obj2.SetCellValue(i, updIndex2,"U");
				}
			}
		}
	}


	function sheet4_OnClick(Obj, Row, Col) {
		var Obj1=Obj;
		var Obj2=sheetObjects[3];
		if( Obj1.ColSaveName(Col) =="sheet4_cstms_rmk1"){
			ComShowMemoPad(sheetObjects[3], Row, Col, false, 200, 200);
			var colIndex2=sheetObjects[3].SaveNameCol("sheet4_rmk_bkg_no");
			var updIndex1=sheetObjects[3].SaveNameCol("sheet4_ibflag");
			if(sheetObjects[3].GetCellValue(Row, colIndex2) == "") {
				sheetObjects[3].SetCellValue(Row, updIndex1,"I");
			}
		}
	}


	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	function initCombo(comboObj) {
		comboObj.SetMultiSelect(0);
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator("|");
	}


	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	}


	function loadPage() {
		var form=document.form;
		for(i=0;i<sheetObjects.length;i++) {
			ComConfigSheet(sheetObjects[i] );
			initSheet(sheetObjects[i], i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		for(var j=0; j<comboObjects.length; j++){
			initCombo(comboObjects[j]);
		}
		with(correction) {
			var i=0;
			SetMultiSelect(0);
			InsertItem(i++, "All", "01");
			InsertItem(i++, "NO", "02");
			InsertItem(i++, "YES I - B/L 추가", "I");
			InsertItem(i++, "YES X - B/L 삭제", "X");
			InsertItem(i++, "YES V - VVD 또는 Rout 변경", "V");
			InsertItem(i++, "YES U - Packages, Weight, E/L 정보변경", "U");
			Code="01";
		}
	//	axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
	//	axon_event.addListenerFormat("Keypress","obj_KeyPress", form);
		axon_event.addListener("keydown", "ComKeyEnter", "form");
		doActionIBSheet(sheetObjects[1],document.form,INIT);
		sheet1_OnLoadFinish(sheet1);
	}


	function sheet1_OnLoadFinish(sheetObj) {
		funcSetDownLoadOption(document.form, "bl");
		ComBtnDisable("btn_DataDL");
		if (document.form.strOfc_cd.value.substring(0,5) == "SELBB") {
			funcOnFocus("pol");
		} else {
			funcOnFocus("pod");
		}
	}


	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetId=sheetObj.id;
		switch(sheetId){
		case "sheet1":
			with(sheetObj){
				var HeadTitle1=" |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|SHPR|SHPR|CNEE|CNEE|NTFY|NTFY|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP||Customer Name|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|I/B Manifest(T/S Unmatch CHK)|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume|T/S Empty Volume||||||||";
				var HeadTitle2=" |||||Sel.|Seq.|B/L No.|BKG No.|D/L|R/O|OVVD|MSN|Correction|TP|FE|POL|POD|Package|Package|Weight|Weight|Measure|Measure|N|A|N|A|N|A|CNTR|BAC|W/H|DESC|T/R|CM|BZ|E/L NO.|E/L NO.|S/C|Cust TP||Customer Name|Package|Package|Weight|Weight|Match|Pre VVD|||||||VVD|Bond Area|ETA|Dwell||||||||";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet1_";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
							{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",   Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							 {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"errchk" },
							 {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidden3" },
							 {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_cnt" },
							 {Type:"Text",     Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"a_bkg_no",            Format:"",            Edit:1 },
							 {Type:"CheckBox", Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel",                 Format:"",            Edit:1,  EditLen:0 },
							 {Type:"Seq",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",                 Format:"",            Edit:1,  EditLen:0 },
							 {Type:"Text",     Hidden:0,  Width:95,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",               Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"down_yn",             Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ro_chk",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"other_vvd",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"msn",                 Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:prefix+"correction",          Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tp",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fe",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol",                 Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",                 Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Int",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",             Format:"NullInteger", UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Float",    Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wgt",             Format:"NullFloat",   UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"meas_qty",            Format:"NullFloat",   UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_ut_cd",          Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shpr_n",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"shpr_a",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cnee_n",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cnee_a",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ntfy_n",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ntfy_a",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr",                Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bac",                 Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wh",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"desc_code",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tr",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cm",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bz",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"elno_a",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"elno_b",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc",                  Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cust_type",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_tp",               Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:250,  Align:"Left",    ColMerge:1,   SaveName:prefix+"cust_name",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Int",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pkg_value",           Format:"NullInteger", UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pkg_code",            Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Float",    Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:prefix+"wgt_value",           Format:"NullFloat",   UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_code",            Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"match",               Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pre_vvd",             Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_dmst_port_cd",     Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_mty_bkg_no",       Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"c_bl_no",             Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_mty_bl_no",        Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_cstms_decl_tp_cd", Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_trns_seq",         Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_vvd",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bac_nm",              Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:prefix+"ib_eta_dt",           Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dwell_dt",            Format:"",            UpdateEdit:0,  InsertEdit:1 },

							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty_chk",         Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd_chk",       Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_ttl_wgt_chk",    Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd_chk",       Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_qty_chk",        Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_ut_cd_chk",      Format:"",            UpdateEdit:0,  InsertEdit:1 },
							 {Type:"Text",     Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dmst_port_cd",        Format:"",            UpdateEdit:0,  InsertEdit:1 } ];

				InitColumns(cols);
				SetEditable(1);
				SetCountPosition(0);
				SetMergeCell(0, 37, 2, 2);  // EL N/O
				SetMergeCell(0, 41, 2, 2);  // Customer Name
				SetSheetHeight(345);
				SetRangeBackColor(1, 2, 1, 60,"#555555");
			}
			break;

		case "sheet2":
			with(sheetObj){
				var HeadTitle1=" ||Sel.|Seq.|BkgNo|TP|cntr_no|cntr_tpsz_cd|cntr_seal_no1|cntr_seal_no2|pck_qty|pck_tp_cd|cntr_wgt|wgt_ut_cd|meas_qty|meas_ut_cd|op_cntr_qty|cntr_vol_qty|bl_no";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet2_";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"errchk" },
							 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel",           Edit:1,   EditLen:0 },
							 {Type:"Seq",       Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",           Edit:0,   EditLen:0 },
							 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tp_cd",         Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_no",       Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_tpsz_cd",  Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_seal_no1", Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_seal_no2", Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_qty",       Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",     Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_wgt",      Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",     Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_qty",      Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_ut_cd",    Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"op_cntr_qty",   Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_vol_qty",  Edit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",         Edit:1 } ];

				InitColumns(cols);
				SetEditable(1);
				SetVisible(false);
			}
			break;

		case "sheet3":
			with(sheetObj){
				var HeadTitle1="|Sel.|Seq";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet3_";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:9, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:0 } ];
				InitColumns(cols);
				SetEditable(1);
				SetVisible(false);
			}
			break;

		case "sheet4":      //sheet4 init
			with(sheetObj){
				var HeadTitle1=" |||||Sel.|Seq.|B/L No.|SC|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Booking|Download|Download|Download|Download|Download|Download|Download|Remark|bkg_no|tp|fe|rmk_bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|port_cd|BL_TP|CNTR_CNT";
				var HeadTitle2=" |||||Sel.|Seq.|B/L No.|SC|POL|POD|Package|Package|Weight|Weight|Measure|Measure|E/L NO.|Package|Package|Weight|Weight|Measure|Measure|E/L NO.|Remark|bkg_no|tp|fe|rmk_bkg_no|vsl_cd|skd_voy_no|skd_dir_cd|port_cd|BL_TP|CNTR_CNT";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheet4_";

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:8, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"},
							{ Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"errchk" },
							 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"hidden3" },
							 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cntr_cnt" },
							 {Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"a_bkg_no",      Edit:1 },
							 {Type:"CheckBox",  Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sel",           Edit:1,   EditLen:0 },
							 {Type:"Seq",       Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"Seq",           Edit:1,   EditLen:0 },
							 {Type:"Text",      Hidden:0,  Width:90,   Align:"Left",    ColMerge:1,   SaveName:prefix+"bl_no",         UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"sc",            UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pol_cd",        UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"pck_qty",       UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pck_tp_cd",     UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"act_wgt",       UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"wgt_ut_cd",     UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:prefix+"meas_qty",      UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"meas_ut_cd",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"xpt_lic_no",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dn_pck_qty",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dn_pck_tp_cd",  UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_ttl_wgt",  UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"dn_wgt_ut_cd",  UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:prefix+"dn_meas_qty",   UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_meas_ut_cd", UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dn_xpt_lic_no", UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"cstms_rmk1",    UpdateEdit:0,   InsertEdit:0 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_no",        UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"tp",            UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"fe",            UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"rmk_bkg_no",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_cd",        UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_voy_no",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"skd_dir_cd",    UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"port_cd",       UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_tp",         UpdateEdit:0,   InsertEdit:1 },
							 {Type:"Text",      Hidden:1,  Width:0,    Align:"Right",   ColMerge:1,   SaveName:prefix+"cntr_cnt",      UpdateEdit:0,   InsertEdit:1 } ];
				InitColumns(cols);

				SetEditable(1);
				SetCountPosition(0);
				SetVisible(false);
			}
			break;
		}
	}

	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var ret=ComGetPrefixParam("sheet1_");
		var aryPrefix=new Array("sheet1_", "sheet2_");
		var ret1=ComGetPrefixParam("sheet4_");
		ret=ComGetPrefixParam(aryPrefix);
		switch(sAction) {
			case INIT:
				formObj.f_cmd.value=INIT;
				sheetObj.SetWaitImageVisible(0);
				ComOpenWait(true);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0329GS.do", FormQueryString(formObj));
				var arrXml=sXml.split("|$$|");
				ComOpenWait(false);
				ComXml2ComboItem(arrXml[0], formObj.sc, "val", "val|desc");
				ComSetObjValue(formObj.sc, "A");
				break;
			case SEARCH:
				if (!crossChk) {
					formObj.f_cmd.value = SEARCH;
					formObj.mrn_nbr.value = "";
					formObj.mrn_chk_no.value = "";
					if (funcSelectValidate(formObj)) {
						formObj.eta_etd.value = "";
						formObj.etb_dt.value = "";
						if (formObj.bl_bkg_tp.value == "BKG") {
							formObj.in_bkg_no.value = formObj.bl_bkg_no.value;
							formObj.in_blno.value = "";
						} else {
							formObj.in_blno.value = formObj.bl_bkg_no.value;
							formObj.in_bkg_no.value = "";
						}
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml = sheetObj.GetSearchData("ESM_BKG_0329GS.do", FormQueryString(formObj) + "&" + ret);
						var arrXml = sXml.split("|$$|");
						if(!formObj.rad_crscheck.checked){
							sheetObjects[0].SetSheetHeight(320);
							sheetObjects[3].SetVisible(0);
						} else {
							sheetObjects[0].SetVisible(0);
							sheetObjects[3].SetSheetHeight(320);
						}
						for(var i=0; i<arrXml.length; i++) {
		//					sheetObjects[i].RenderSheet(0);
							if(i > 0) {
								sheetObjects[i].SetWaitImageVisible(0);
							}
							sheetObjects[i].LoadSearchData(arrXml[i],{Sync:1} );
							sheetObjects[i].CheckAll(aryPrefix[i]+"sel",1);
							funcShowValueRows();
						}
						sheetObjects[0].ColumnSort("sheet1_bl_no|sheet1_bkg_no", "DESC", "ASC|DESC", true);
						sheetObjects[1].ColumnSort("sheet2_cntr_no", "ASC");
						funcShowCheckError(sheetObj, formObj);
		//				sheetObj.RenderSheet(1);
		//				sheetObjects[1].RenderSheet(1);
						var mrn_no = ComGetEtcData(arrXml[0],"mrn_nbr");
						if(mrn_no.length < 10) {
							formObj.mrn_nbr.value = "";
							formObj.mrn_no.value = "";
							formObj.mrn_chk_no.value = "";
						} else {
							formObj.mrn_chk_no.value=ComGetEtcData(arrXml[0],"mrn_chk_no");
							formObj.mrn_no.value=mrn_no + ComGetEtcData(arrXml[0],"mrn_chk_no");
							formObj.mrn_nbr.value=ComGetEtcData(arrXml[0],"mrn_nbr");
						}
						var bd = ComGetEtcData(arrXml[0],"bl_dl");
						if(bd != "bl" && bd != "dl" && bd != "mc"&& bd != "cr") {
							if(formObj.rad_nodownlist.checked) bd = "bl";
							else if(formObj.rad_downedlist.checked)  bd = "dl"
							else if(formObj.rad_mftcheck.checked)  bd = "mc"
							else bd="cr";
						}
						if (formObj.rad_ib.checked) {
							document.all.span_eta_etd.innerHTML="ETA";
						}else {
							document.all.span_eta_etd.innerHTML="ETD";
						}
						if (ComGetEtcData(arrXml[0],"eta_etd")) formObj.eta_etd.value=ComGetEtcData(arrXml[0],"eta_etd");
						if (ComGetEtcData(arrXml[0],"etb_dt")) formObj.etb_dt.value=ComGetEtcData(arrXml[0],"etb_dt");
						// MSN Save 버튼 처리
						if (formObj.in_pod.value=="KRPUS" && formObj.rad_ib.checked && bd=="dl") {
							formObj.msn_start_num.style.display="inline";
							document.all.btn_msn_save.style.display="inline";
						} else {
							formObj.msn_start_num.style.display="none";
							document.all.btn_msn_save.style.display="none";
						}
						// DL, RO 컬럼 처리
						if (formObj.rad_nodownlist.checked) {
							sheetObjects[0].SetColHidden("sheet1_down_yn",0);
							if (formObj.rad_ib.checked) {
								sheetObjects[0].SetColHidden("sheet1_ro_chk",1);
							} else {
								sheetObjects[0].SetColHidden("sheet1_ro_chk",0);
							}
						} else {
							sheetObjects[0].SetColHidden("sheet1_down_yn",1);
							sheetObjects[0].SetColHidden("sheet1_ro_chk",1);
						}
						funcSetDownLoadOption(formObj, bd);
						ComOpenWait(false);
					}
					updateSummary();
				} else {
					formObj.f_cmd.value = SEARCH04;
					formObj.mrn_nbr.value = "";
					formObj.mrn_chk_no.value = "";
					if (funcSelectValidate(formObj) == true) {
						formObj.eta_etd.value = "";
						formObj.etb_dt.value = "";
						if (formObj.bl_bkg_tp.value == "BKG") {
							formObj.in_bkg_no.value = formObj.bl_bkg_no.value;
							formObj.in_blno.value = "";
						} else {
							formObj.in_blno.value = formObj.bl_bkg_no.value;
							formObj.in_bkg_no.value = "";
						}
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("ESM_BKG_0329GS.do", FormQueryString(formObj) + "&" + ret1);
						var arrXml=sXml.split("|$$|");
						if(!formObj.rad_crscheck.checked){
							sheetObjects[0].SetSheetHeight(320);
							sheetObjects[3].SetSheetHeight(0);
						} else {
							sheetObjects[0].SetSheetHeight(0);
							sheetObjects[3].SetSheetHeight(320);
						}
						for(var i=0; i < arrXml.length; i++) {
							sheetObjects[3].LoadSearchData(arrXml[i],{Sync:1} );
						}
						if (ComGetEtcData(sXml, "eta_etd")) formObj.eta_etd.value = ComGetEtcData(sXml, "eta_etd");
						if (ComGetEtcData(sXml, "etb_dt")) formObj.etb_dt.value = ComGetEtcData(sXml, "etb_dt");
						var mrn_no=ComGetEtcData(sXml, "mrn_nbr");
						if(mrn_no.length < 10) {
							formObj.mrn_nbr.value = "";
							formObj.mrn_no.value = "";
							formObj.mrn_chk_no.value = "";
						} else {
							formObj.mrn_chk_no.value=ComGetEtcData(sXml, "mrn_chk_no");
							formObj.mrn_no.value=mrn_no + ComGetEtcData(sXml, "mrn_chk_no");
							formObj.mrn_nbr.value=mrn_no;
						}
						ComOpenWait(false);
					}
					updateSummary();
					funcShowValueRows();
				}
				break;
			case IBINSERT:      // B/L List DownLoad
				if(funcSelectValidate(formObj) == true) {
					ComOpenWait(true);
					sheetObjects[0].SetWaitImageVisible(0);
					formObj.f_cmd.value = MULTI;
					var sParam = ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel") + "&" + ComGetSaveString(sheetObjects[1],true,false, "sheet2_sel");
					if (sParam == "&") {
						ComShowCodeMessage("BKG00249");
						ComOpenWait(false);
						sheetObjects[0].SetWaitImageVisible(1);
						return;
					}
					sParam += "&" + FormQueryString(formObj);
					var sXml=sheetObjects[0].GetSaveData("ESM_BKG_0329GS.do", sParam);
					var key=ComGetEtcData(sXml, "KEY");
					intervalId = setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
				}
				break;
			case IBDELETE:
				if (ComShowCodeConfirm("BKG00535")) {
					var sParam=ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel") + "&" +
					  ComGetSaveString(sheetObjects[1],true,false, "sheet2_sel");
					  if (sParam == "&") {
						ComShowCodeMessage("BKG00249");
						return;
					  }
					formObj.f_cmd.value=REMOVE;
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var sXml=sheetObj.GetSaveData("ESM_BKG_0329GS.do", sParam + "&"+FormQueryString(formObj) + "&" + ret);
					sheetObj.LoadSaveData(sXml);
					ComOpenWait(false);
					var delCount=sheetObj.GetEtcData("delcount");
					doActionIBSheet(sheetObj, formObj, SEARCH);
				}
				break;
			case IBDOWNEXCEL:
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					if (formObj.rad_crscheck.checked) {
						sheetObjects[3].Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
					}else{
						sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true,TreeLevel:false});
					}
				}
				break;
			case COMMAND01:		// MSN save
				if (ComShowCodeConfirm("BKG00824")) {
					ComOpenWait(true);
					sheetObjects[0].SetWaitImageVisible(0);
					formObj.f_cmd.value=COMMAND01;
					var sParam=ComGetSaveString(sheetObjects[0],true,false, "sheet1_sel");
					if (sParam == "") {
						ComShowCodeMessage("BKG00249");
						ComOpenWait(false);
						sheetObjects[0].SetWaitImageVisible(1);
						return;
					}
					sParam += "&in_vvd="+formObj.in_vvd.value+"&msn_start_num="+formObj.msn_start_num.value
							+ "&in_pod="+formObj.in_pod.value+"&f_cmd="+COMMAND01;
					sheetObjects[2].RemoveAll();
					sheetObjects[2].DataInsert(-1);
					sheetObjects[2].DoSave("ESM_BKG_0329GS.do", sParam, -1, false);
					var key=sheetObjects[2].GetEtcData("TRANS_RESULT_KEY");
					if (key=="S") doActionIBSheet(sheetObj, formObj, SEARCH);
					ComOpenWait(false);
				}
				break;
			case COMMAND02:		// cross check Result, Remark save
				if (ComShowCodeConfirm("BKG00824")) {
					ComOpenWait(true);
					sheetObjects[3].SetWaitImageVisible(0);
					formObj.f_cmd.value=COMMAND02;
					if (sParam == "") {
						ComShowCodeMessage("BKG00249");
						ComOpenWait(false);
						sheetObjects[3].SetWaitImageVisible(1);
						return;
					}
					var sParam="f_cmd="+COMMAND02;
					sheetObjects[3].DoSave("ESM_BKG_0329GS.do", sParam, "sheet4_ibflag", false);
					var key=sheetObjects[3].GetEtcData("TRANS_RESULT_KEY");
					if (formObj.rad_crscheck.checked) crossChk = true;
					if (key=="S") doActionIBSheet(sheetObj, formObj, SEARCH);
					ComOpenWait(false);
				}
			break;
		}
	}

	function doActionValidationResult(sheetObj, sKey) {
		var formObj=document.form;
		var sXml=sheetObj.GetSearchData("ESM_BKG_0329GS.do?f_cmd=" + SEARCH03 + "&key=" + sKey);
		var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
		if (!ComBkgErrMessage(sheetObj, sXml)) {
			clearInterval(intervalId);
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			return;
		}
		if (sJbStsFlg == "SUCCESS") {
			clearInterval(intervalId);
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			ComShowMessage(ComResultMessage(sXml));
			formObj.rad_downedlist.click();
			doActionIBSheet(sheetObj, formObj, SEARCH);
			return;
		} else if (sJbStsFlg == "FAIL") {
			clearInterval(intervalId);
			ComOpenWait(false);
			sheetObj.SetWaitImageVisible(1);
			ComShowMessage(ComResultMessage(sXml));
		}
	}


	function funcOnFocus(objName) {
		var form = document.form;
		var selType = form.sel_type;

		if (objName == "pod") {
			cur_pol_pod = "pod";    // 전역변수
			form.in_pod.disabled = false;
			form.in_pod.className = "input1";
			form.in_hn.disabled = false;
			form.in_hn.className = "input";
			form.in_pol.value = "";
			form.in_pol.disabled = true;
			form.in_pol.className = "input2";
			form.in_pol_yd.value = "";
			form.in_pol_yd.disabled = true;
			form.in_pol_yd.className = "input2";
			form.in_bound.value = "I";
			form.rad_ib.checked = true;
			form.rad_ob.checked = false;
			document.all.el_no1.style.display = "none";
			document.all.el_type.style.display = "none";
			document.all.cgo_tp1.style.display = "inline";
			document.all.cgo_tp.style.display = "inline";
			// option 항목을 삭제
			ComClearCombo(selType);
			// Inbound용 option 항목을 추가[blank, A, R, M, T]
			ComAddComboItem(selType, "1 : Local", "A");
			ComAddComboItem(selType, "2 : T/S", "R");
			ComAddComboItem(selType, "3 : eMpty Local", "M");
			//selType.value = " ";

		} else if(objName == "pol") {
			cur_pol_pod = "pol";    // 전역변수
			form.in_bound.value = "O";
			form.in_pol.disabled = false;
			form.in_pol.className = "input1";
			form.in_pol_yd.disabled = false;
			form.in_pol_yd.className = "input";
			form.in_pod.value = "";
			form.in_pod.disabled = true;
			form.in_pod.className="input2";
			form.in_hn.value = "";
			form.in_hn.disabled = true;
			form.in_hn.className = "input2";
			form.rad_ib.checked = false;
			form.rad_ob.checked = true;
			document.all.el_no1.style.display = "inline";
			document.all.el_type.style.display = "inline";
			document.all.cgo_tp1.style.display = "none";
			document.all.cgo_tp.style.display = "none";
			// option 항목을 삭제
			ComClearCombo(selType);
			// Outbound용 option 항목을 추가
			ComAddComboItem(selType, "1 : Local", "B");
			ComAddComboItem(selType, "2 : T/S", "C");
			selType.value = "B";
		}
		if (form.rad_ib.checked) {
			document.all.span_eta_etd.innerHTML = "ETA";
		} else {
			document.all.span_eta_etd.innerHTML = "ETD";
		}
		// MSN Save 버튼 처리
		if (form.in_pod.value=="KRPUS" && form.rad_ib.checked && !form.rad_nodownlist.checked && !form.rad_mftcheck.checked && !form.rad_crscheck.checked) {
			form.msn_start_num.style.display="inline";
			document.all.btn_msn_save.style.display="inline";
		} else {
			form.msn_start_num.style.display="none";
			document.all.btn_msn_save.style.display="none";
		}
		// ETB DT 처리
		if (form.rad_ob.checked && form.rad_downedlist.checked) {
			document.all.etb_td1.style.display="inline";
			document.all.etb_td2.style.display="inline";
		} else {
			document.all.etb_td1.style.display="none";
			document.all.etb_td2.style.display="none";
		}
	}


	function funcSetDownLoadOption(formObj, op) {
		if (op == "bl") {
			formObj.rad_nodownlist.checked = true;
			formObj.rad_downedlist.checked = false;
			formObj.rad_mftcheck.checked = false;
			formObj.rad_crscheck.checked = false;
			ComBtnDisable("btn_Delete");
			ComBtnDisable("btn_AddBL");
			ComBtnDisable("btn_EditBL");
			ComBtnDisable("btn_Transmission");
			ComBtnEnable("btn_DataDL");

		} else if (op == "dl") {
			formObj.rad_nodownlist.checked = false;
			formObj.rad_downedlist.checked = true;
			formObj.rad_mftcheck.checked = false;
			formObj.rad_crscheck.checked = false;
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_AddBL");
			ComBtnEnable("btn_EditBL");
			ComBtnEnable("btn_Transmission");
			ComBtnDisable("btn_DataDL");

		} else if (op == "mc") {
			formObj.rad_nodownlist.checked = false;
			formObj.rad_downedlist.checked = false;
			formObj.rad_mftcheck.checked = true;
			formObj.rad_crscheck.checked = false;
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_AddBL");
			ComBtnEnable("btn_EditBL");
			ComBtnEnable("btn_Transmission");
			ComBtnDisable("btn_DataDL");

		} else if(op == "cr") {
			formObj.rad_nodownlist.checked = false;
			formObj.rad_downedlist.checked = false;
			formObj.rad_mftcheck.checked = false;
			formObj.rad_crscheck.checked = true;
			ComBtnEnable("btn_Delete");
			ComBtnEnable("btn_AddBL");
			ComBtnEnable("btn_EditBL");
			ComBtnEnable("btn_Transmission");
			ComBtnDisable("btn_DataDL");
		}
		formObj.bl_dl.value=op;
	}


	function funcSelectValidate(formObj) {
		var in_vvd = formObj.in_vvd.value;
		if (in_vvd.length != 9) {
			ComShowCodeMessage("BKG00566");
			formObj.in_vvd.focus();
			return false;
		}

		if (formObj.in_bound.value == "I") {
			if (formObj.in_pod.value.length != 5) {
				ComShowCodeMessage("COM12114", "POD");
				formObj.in_pod.focus();
				return false;
			}
			formObj.in_pol_tmnl.value = "";
			formObj.in_pod_tmnl.value = formObj.in_pod.value + formObj.in_hn.value;

		} else if(formObj.in_bound.value == "O") {
			if (formObj.in_pol.value.length != 5) {
				ComShowCodeMessage("COM12114", "POL");
				formObj.in_pol.focus();
				return false;
			}
			var in_type = formObj.sel_type.value;
			if(in_type != "A" && in_type != "B" && in_type != "C" && in_type != "D" && in_type != "M") {
				ComShowCodeMessage("COM12114", "TYPE");
				return false;
			}
			formObj.in_pol_tmnl.value = formObj.in_pol.value + formObj.in_pol_yd.value;
			formObj.in_pod_tmnl.value = "";

		} else {
			ComShowCodeMessage("COM12114", "BND");
			return false;
		}
		return true;
	}


	function funcShowValueRows() {
		var formObj=document.form;
		if (formObj.rad_crscheck.checked ){
			var sheetObj=sheetObjects[3];
			if (ViewOptionBlType == "") {
				for(var i=2;i < sheetObj.RowCount()+ 2; i++) {
					sheetObj.SetRowHidden(i,0);
				}
			} else {
				for(var i=2; i<=sheetObj.RowCount()+2; i++) {
					if(ViewOptionBlType != "") {
						if (sheetObj.GetCellValue(i, "sheet4_bl_tp") != ViewOptionBlType) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
				}
			}
		} else {
			var sheetObj=sheetObjects[0];
			var ColEr=sheetObj.SaveNameCol("sheet1_errchk");
			var ColBl=sheetObj.SaveNameCol("sheet1_sc");
			var ColEl=sheetObj.SaveNameCol("sheet1_elno_a");
			var ColCr=sheetObj.SaveNameCol("sheet1_correction");
			var ColCntr=sheetObj.SaveNameCol("sheet1_cntr");
			var ColEl=sheetObj.SaveNameCol("sheet1_elno_a");
			var ColTp=sheetObj.SaveNameCol("sheet1_tp");
			if (ViewOptionErrCheck == "" && ViewOptionBlType == "" && ViewOptionElNo == "" && (ViewOptionCorrection == "-1" || ViewOptionCorrection == "" || ViewOptionCorrection == "01") && ViewOptionCargoType == "" ) {
				for(var i=2;i < sheetObj.RowCount()+ 2; i++) {
					sheetObj.SetRowHidden(i,0);
				}
			} else {
				for(var i=2;i <= sheetObj.RowCount()+ 2; i++) {
					if(ViewOptionErrCheck != "") {
						if(ViewOptionErrCheck != sheetObj.GetCellValue(i, ColEr)) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
					if(ViewOptionBlType != "") {
						if (sheetObj.GetCellValue(i, "sheet1_bl_tp") != ViewOptionBlType) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
					if(ViewOptionElNo != "") {
						if(ViewOptionElNo != sheetObj.GetCellValue(i, ColEl)) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
					if(ViewOptionCargoType != "") {
						if(ViewOptionCargoType != sheetObj.GetCellValue(i, ColTp)) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
					if (sheetObj.GetCellValue(i, ColCr) != null && ViewOptionCorrection != "-1" && ViewOptionCorrection != "" && ViewOptionCorrection != "01") {
						var vocArray = ViewOptionCorrection.split(",");
						var vocCheck = false;
						for(var j=0; j < vocArray.length; j++) {
							if (vocArray[j] == "01") {
								vocCheck=true;
								break;
							} else if (vocArray[j] == "02" && sheetObj.GetCellValue(i,ColCr).trim().length < 1) {
								vocCheck=true;
								break;
							}else if (vocArray[j] == sheetObj.GetCellValue(i, ColCr)) {
								vocCheck=true;
								break;
							}
						}
						if (vocCheck == false) {
							sheetObj.SetRowHidden(i,1);
							continue;
						}
					}
					sheetObj.SetRowHidden(i,0);
				}
			}
		}
		updateSummary();
	}

	function funcShowAllRows(sheetObj) {
		for(var i=0; i<=IndexTop; i++) {
			sheetObj.SetRowHidden(hiddenIndex[i],0);
		}
		IndexTop=0;
		updateSummary();
	}

	function funcShowCheckError(sheetObj, formObj) {
		var prefix="sheet1_";
		for(var i=2;i < sheetObj.RowCount()+ 2;i++) {
			if(sheetObj.GetCellValue(i, prefix+"errchk") == "E") sheetObj.SetCellFontColor(i,prefix+"bl_no","#FF0000"); //sheetObj.SetCellFont("FontColor",i,prefix+"bl_no","#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"shpr_n") == "N") sheetObj.SetCellFontColor(i, prefix + "shpr_n","#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"shpr_a") == "N") sheetObj.SetCellFontColor(i, prefix + "shpr_a","#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"cnee_n") == "N") sheetObj.SetCellFontColor(i, prefix + "cnee_n","#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"cnee_a") == "N") sheetObj.SetCellFontColor(i, prefix + "cnee_a","#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"cntr") == "0"  ) sheetObj.SetCellFontColor(i, prefix + "cntr"  ,"#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"desc_code") == "N"  ) sheetObj.SetCellFontColor(i, prefix + "desc_code"  ,"#FF0000");
			if(sheetObj.GetCellValue(i, prefix+"bz") == "N"  ) sheetObj.SetCellFontColor(i, prefix + "bz"  ,"#FF0000");
			// INBOUND 시
			if (formObj.in_bound.value=="I") {
				if(sheetObj.GetCellValue(i, prefix+"bac") == "N"  ) sheetObj.SetCellFontColor(i, prefix + "bac","#FF0000");
				if(sheetObj.GetCellValue(i, prefix+"wh") == "N"   ) sheetObj.SetCellFontColor(i, prefix + "wh" ,"#FF0000");
			} else {
				// OUT BOUND시
				if(sheetObj.GetCellValue(i, prefix+"elno_a") == "Y" && sheetObj.SetCellValue(i, prefix+"elno_b") == "U") {
					sheetObj.SetCellFontColor(i, prefix + "elno_a" ,"#FF0000");
					sheetObj.SetCellFontColor(i, prefix + "elno_b" ,"#FF0000");
				}
				if(sheetObj.GetCellValue(i, prefix+"sc") == "S" && sheetObj.GetCellValue(i, prefix+"elno_a") == "N") sheetObj.SetCellFontColor(i, prefix + "elno_a" ,"#FF0000");
				if(sheetObj.GetCellValue(i, prefix+"sc") == "S" && sheetObj.GetCellValue(i, prefix+"elno_b") == "N") sheetObj.SetCellFontColor(i, prefix + "elno_b" ,"#FF0000");
				if(sheetObj.GetCellValue(i, prefix+"match") == "N") sheetObj.SetCellFontColor(i, prefix + "match" ,"#FF0000");
			}
			if (formObj.bl_dl.value=="mc") {
				if(sheetObj.GetCellValue(i, prefix+"pck_qty_chk") == "Y" || sheetObj.GetCellValue(i, prefix+"pck_tp_cd_chk") == "Y") {
					sheetObj.SetCellFontColor(i, prefix + "pck_qty" ,"#FF0000");
					sheetObj.SetCellFontColor(i, prefix + "pck_tp_cd" ,"#FF0000");
				}
				if(sheetObj.GetCellValue(i, prefix+"cntr_ttl_wgt_chk") == "Y" || sheetObj.GetCellValue(i, prefix+"wgt_ut_cd_chk") == "Y") {
					sheetObj.SetCellFontColor(i, prefix + "act_wgt" ,"#FF0000");
					sheetObj.SetCellFontColor(i, prefix + "wgt_ut_cd" ,"#FF0000");
				}
				if(sheetObj.GetCellValue(i, prefix+"meas_qty_chk") == "Y" || sheetObj.GetCellValue(i, prefix+"meas_ut_cd_chk") == "Y") {
					sheetObj.SetCellFontColor(i, prefix + "meas_qty" ,"#FF0000");
					sheetObj.SetCellFontColor(i, prefix + "meas_ut_cd" ,"#FF0000");
				}
			}
		}
	}


	function funcBlTypeOnChange(obj) {
		ViewOptionBlType=obj.value;
		funcShowValueRows();
	}


	function funcElTypeOnChange(obj) {
		ViewOptionElNo = obj.value;
		funcShowValueRows();
	}


	function correction_OnChange(comboObj, val, text) {
		ViewOptionCorrection = val;
		funcShowValueRows();
	}


	function funcCargoTypeOnChange(obj) {
		ViewOptionCargoType=obj.value;
		funcShowValueRows();
	}


	function funcClearAll(sheetObjects, formObj) {
		var len=sheetObjects.length;
		if(isNaN(len)) {
			var sheetObj=sheetObjects;
			sheetObj.RemoveAll();
		} else {
			for(var i=0;i<len;i++) {
				sheetObj=sheetObjects[i];
				sheetObj.RemoveAll();
			}
		}
		formObj.mrn_nbr.value = "";
		formObj.in_vvd.value = "";
		formObj.in_pol.value = "";
		formObj.in_pol_yd.value = "";
		formObj.in_pod.value = "";
		formObj.in_blno.value = "";
		formObj.in_hn.value = "";
		correction.SetSelectCode("01");
		correction.SetSelectText("All");
	}


	function funcBlAddnEditPopup(mode) {
		thisRow=sheetObjects[0].GetSelectRow();
		if (thisRow < 2) thisRow=2;
		var formObj=document.form;
		var params = "?io_bnd_cd=" + formObj.in_bound.value +	 "&mrn_no=" + formObj.mrn_no.value + "&mode="+mode + "&vvd=" + formObj.in_vvd.value + "&cstms_decl_tp_cd="+sheetObjects[0].GetCellValue(thisRow, "sheet1_tp");
		if (formObj.in_pol_yd.value.trim() != "") params = params + "&pol_tml_cd=" + formObj.in_pol.value + formObj.in_pol_yd.value;
		if (formObj.in_hn.value.trim() != "") params = params + "&pod_tml_cd=" + formObj.in_pod.value + formObj.in_hn.value;
		if (mode=="EDIT") params=params + "&bl_no=" + sheetObjects[0].GetCellValue(thisRow, "sheet1_bl_no");
		if (formObj.in_bound.value=="I") {
			if (formObj.in_pod.value == sheetObjects[0].GetCellValue(thisRow, "sheet1_pod")) params=params + "&cgo_spec_clear=Y";
		}
		var port_cd = formObj.in_pol.value;
		if (port_cd =="") port_cd = formObj.in_pod.value;
		params = params + "&port_cd=" + port_cd + "&pgmNo=ESM_BKG_0505";
		ComOpenWindowCenter("ESM_BKG_0505.do" + params, "ESM_BKG_0505", 1280, 650);
	}


	function funcSelectAll(sheetObj1, ColName1, sheetObj2, ColName2, op) {
		var updIndex1=sheetObj1.SaveNameCol("sheet1_ibflag");
		var updIndex2=sheetObj2.SaveNameCol("sheet2_ibflag");
		var SelIndex1=sheetObj1.SaveNameCol(ColName1);
		var SelIndex2=sheetObj2.SaveNameCol(ColName2);
		if (op) {
			for(var i=2;i < sheetObj1.RowCount()+ 2; i++) {
				sheetObj1.SetCellValue(i, SelIndex1,1);
				sheetObj1.SetCellValue(i, updIndex1,"U");
			}
			for(var i=1;i < sheetObj2.RowCount()+ 1; i++) {
				sheetObj2.SetCellValue(i, SelIndex2,1);
				sheetObj2.SetCellValue(i, updIndex2,"U");
			}
		} else {
			for(var i=2;i < sheetObj1.RowCount()+ 2; i++) {
				sheetObj1.SetCellValue(i, SelIndex1,0);
				sheetObj1.SetCellValue(i, updIndex1,"");
			}
			for(var i=1;i < sheetObj2.RowCount()+ 1; i++) {
				sheetObj2.SetCellValue(i, SelIndex2,0);
				sheetObj2.SetCellValue(i, updIndex2,"");
			}
		}
	}


	function sheet1_OnMouseDown(Button, Shift, X, Y) {
		if (sheetObjects[0].MouseCol()==5) {
			if (sheetObjects[0].MouseRow()< 2 && sheetObjects[0].MouseRow()> -1) {
				if (sheetObjects[0].RowCount()> 2) {
					if (sheetObjects[0].GetCellValue(2,"sheet1_sel")==0) {
						sheetObjects[1].CheckAll("sheet2_sel",1);
					} else {
						sheetObjects[1].CheckAll("sheet2_sel",0);
					}
				}
			}
		}
	}


	function updateSummary() {
		var formObj=document.form;
		var bl_local=0, bl_ts=0, bl_empty=0, bl_ts_empty=0;
		var cntr_local=0, cntr_ts=0, cntr_empty=0, cntr_ts_empty=0;
		var prev_cntr_no, cntrRow;
		if ( formObj.rad_crscheck.checked ){
			var prefix="sheet4_";
			var sheetObj=sheetObjects[3];
			for(var i=2; i < sheetObj.RowCount()+2; i++) {
				if (sheetObj.GetRowHidden(i)) continue;
				if (sheetObj.GetCellValue(i, prefix+"bkg_no") != sheetObj.GetCellValue(i-1, prefix+"bkg_no")){
					if ((sheetObj.GetCellValue(i, prefix+"fe")=="P" || sheetObj.GetCellValue(i, prefix+"fe")=="R") && (sheetObj.GetCellValue(i, prefix+"tp")!="T" && sheetObj.GetCellValue(i, prefix+"tp")!="R") ) {
						bl_empty++;
						cntr_empty=cntr_empty + eval(sheetObj.GetCellValue(i, prefix+"cntr_cnt"));
						sheetObj.SetCellValue(i, prefix+"bl_tp","E");
					} else if (sheetObj.GetCellValue(i, prefix+"fe")=="P" && (sheetObj.GetCellValue(i, prefix+"tp")=="T" || sheetObj.GetCellValue(i, prefix+"tp")=="R") ) {
						bl_ts_empty++;
						cntr_ts_empty=cntr_ts_empty + eval(sheetObj.GetCellValue(i, prefix+"cntr_cnt"));
						sheetObj.SetCellValue(i, prefix+"bl_tp","M");
					} else {
						if (sheetObj.GetCellValue(i, prefix+"tp")=="I" || sheetObj.GetCellValue(i, prefix+"tp")=="E") {
							bl_local++;
							cntr_local=cntr_local + eval(sheetObj.GetCellValue(i, prefix+"cntr_cnt"));
						} else {
							bl_ts++;
							cntr_ts=cntr_ts + eval(sheetObj.GetCellValue(i, prefix+"cntr_cnt"));
						}
						sheetObj.SetCellValue(i, prefix+"bl_tp",sheetObj.GetCellValue(i, prefix+"sc"));
					}
				}
			}
		} else {
			var prefix="sheet1_";
			var sheetObj=sheetObjects[0];
			// 컨테이너 카운트를 위한 조건변수
			var cntr_find_field="bkg_no";
			if (formObj.rad_downedlist.checked) cntr_find_field="bl_no";
			// 루프돌며 계산
			for (var i=2; i < sheetObj.RowCount()+2; i++) {
				// HIDDEN 은 패스~
				if (sheetObj.GetRowHidden(i)) continue;
				// EMPTY 체크 ( KCD_TP 가 T 인경우만 EMPTY 로 )
				if ((sheetObj.GetCellValue(i, prefix+"fe")=="P" || sheetObj.GetCellValue(i, prefix+"fe")=="R") && (sheetObj.GetCellValue(i, prefix+"tp")!="T" && sheetObj.GetCellValue(i, prefix+"tp")!="R") ) {
					bl_empty++;
					sheetObj.SetCellValue(i, prefix+"bl_tp","E");
					// 컨테이너 정보 셋팅
					cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.GetCellValue(i, prefix+cntr_find_field));
					while(cntrRow > 0) {
						sheetObjects[1].SetCellValue(cntrRow, "sheet2_tp_cd","E");
						cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.GetCellValue(i, prefix+cntr_find_field), cntrRow+1 );
					}
				} else if (sheetObj.GetCellValue(i, prefix+"fe")=="P" && (sheetObj.GetCellValue(i, prefix+"tp")=="T" || sheetObj.GetCellValue(i, prefix+"tp")=="R") ) {
					// TS EMPTY 체크
					bl_ts_empty++;
					sheetObj.SetCellValue(i, prefix+"bl_tp","M");
					cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.GetCellValue(i, prefix+cntr_find_field));
					while(cntrRow > 0) {
						sheetObjects[1].SetCellValue(cntrRow, "sheet2_tp_cd","M");
						cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.GetCellValue(i, prefix+cntr_find_field), cntrRow+1 );
					}
				} else {
					// EMPTY 가 아닌 경우 LOCAL / TS 구분
					if (sheetObj.GetCellValue(i, prefix+"tp")=="I" || sheetObj.GetCellValue(i, prefix+"tp")=="E") {
						// LOCAL
						bl_local++;
						// 컨테이너 정보 셋팅
						cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field, sheetObj.GetCellValue(i, prefix+cntr_find_field));
						while(cntrRow > 0) {
							sheetObjects[1].SetCellValue(cntrRow, "sheet2_tp_cd","L");
							cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.GetCellValue(i, prefix+cntr_find_field), cntrRow+1 );
						}
					} else {
						// TS
						bl_ts++;
						// 컨테이너 정보 셋팅
						cntrRow=sheetObjects[1].FindText("sheet2_bkg_no", sheetObj.GetCellValue(i, prefix+"bkg_no"));
						while(cntrRow > 0) {
							sheetObjects[1].SetCellValue(cntrRow, "sheet2_tp_cd","T");
							cntrRow=sheetObjects[1].FindText("sheet2_"+cntr_find_field,sheetObj.GetCellValue(i, prefix+cntr_find_field), cntrRow+1 );
						}
					}
					sheetObj.SetCellValue(i, prefix+"bl_tp",sheetObj.GetCellValue(i, prefix+"sc"));
				}
			}
			// 컨테이너 갯수 계산
			for(var i=1; i <= sheetObjects[1].RowCount(); i++) {
				// BKG_NO 가 메인테이블에서 Hidden 이면 카운트하지 않음
				cntrRow=sheetObj.FindText("sheet1_bkg_no", sheetObjects[1].GetCellValue(i,"sheet2_bkg_no"));
				if (cntrRow > 0 && sheetObj.GetRowHidden(cntrRow) ) continue;
				if (prev_cntr_no != sheetObjects[1].GetCellValue(i, "sheet2_cntr_no")) {
					// 중복이 아니면 카운트
					if (sheetObjects[1].GetCellValue(i, "sheet2_tp_cd")=="E") cntr_empty++;
					if (sheetObjects[1].GetCellValue(i, "sheet2_tp_cd")=="L") cntr_local++;
					if (sheetObjects[1].GetCellValue(i, "sheet2_tp_cd")=="T") cntr_ts++;
					if (sheetObjects[1].GetCellValue(i, "sheet2_tp_cd")=="M") cntr_ts_empty++;
				}
				prev_cntr_no=sheetObjects[1].GetCellValue(i, "sheet2_cntr_no");
			}
		}
		// 계산결과 뿌려주기
		formObj.bl_local.value=bl_local;
		formObj.bl_ts.value=bl_ts;
		formObj.bl_empty.value=bl_empty;
		formObj.bl_ts_empty.value=bl_ts_empty;
		formObj.cntr_local.value=cntr_local;
		formObj.cntr_ts.value=cntr_ts;
		formObj.cntr_empty.value=cntr_empty;
		formObj.cntr_ts_empty.value=cntr_ts_empty;
		formObj.bl_total.value=bl_local + bl_ts + bl_empty + bl_ts_empty;
		formObj.cntr_total.value=cntr_local + cntr_ts + cntr_empty + cntr_ts_empty;
	}


	function addHiddenField(parentForm, fieldName, value) {
		var x=document.createElement("input");
		x.type="hidden";
		x.name=fieldName;
		x.value=value;
		parentForm.appendChild(x);
	}


	function obj_KeyUp() {
		var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		if (keyValue != 9 && keyValue !=16 &&ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
	}
