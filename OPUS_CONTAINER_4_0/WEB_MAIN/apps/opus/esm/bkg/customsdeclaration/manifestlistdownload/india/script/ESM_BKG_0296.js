/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0296.js
*@FileTitle : ESM_BKG_0296
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 1.0 Creation
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
	/**
	 * @extends
	 * @class ESM_BKG_0296 : business script for ESM_BKG_0296
	 */
	// Common global variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var comboObjects=new Array();
	var comboCnt=0;
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	 function processButtonClick(){
		  /*****  Tab ->two or more sheet : sheet  a variable assignment *****/
				 var sheetObject1=sheetObjects[0];
				 var sheetObject2=sheetObjects[1];
		  /*******************************************************/
		  var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			var vvdCd=formObject.vvd_cd.value;
			var polCd=formObject.pol_cd.value;
			var podCd=formObject.pod_cd.value;
			var vslNm=formObject.vsl_nm.value;
			var emptyCheck="";
			if(formObject.empty_check.checked == true) {
				emptyCheck="on"
			} else {
				emptyCheck=""
			}
			if(ComGetBtnDisable(srcName)){
				return false;
			}

			switch(srcName) {
				case "btns_assign":
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
					break;
				case "btn_retrieve":
					doActionIBSheet(sheetObject1,formObject,IBSEARCH);
					break;
				case "btn_save":
					doActionIBSheet(sheetObject1,formObject,MULTI);
					break;
				case "btn_downexcel":
					if(sheetObject1.RowCount() < 1){//no data
						ComShowCodeMessage("COM132501");
					}else{
						doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
					}
					break;
				case "btn_formset":
					var sParam="vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd;
					ComOpenWindowCenter("ESM_BKG_0300.do?"+sParam, "ESM_BKG_0300", 600, 400, true);
					break;
				case "btn_formprint":
					var sParam="vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&vsl_nm="+vslNm;
					ComOpenWindowCenter("ESM_BKG_0299.do?"+sParam, "ESM_BKG_0299", 400, 250, true);
					break;
				case "btn_igmedi":
					if (!downloadCheck()) return;
					var sParam="vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&empty_check="+emptyCheck;
					ComOpenWindowCenter("ESM_BKG_0302.do?"+sParam, "ESM_BKG_0302", 500, 270, true);
					break;
				case "btn_request":
					if (!downloadCheck()) return;
					var sParam="vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd+"&empty_check="+emptyCheck;
					ComOpenWindowCenter("ESM_BKG_0303.do?"+sParam, "ESM_BKG_0303", 550, 270, true);
					break;
				case "btn_cntrlist":
					if (!downloadCheck()) return;
					var sParam="vvd_cd="+vvdCd+"&pol_cd="+polCd+"&pod_cd="+podCd;
					ComOpenWindowCenter("ESM_BKG_0298.do?"+sParam, "ESM_BKG_0298", 500, 270, true);
					break;
				case "btns_assign":
					doActionIBSheet(sheetObject1,formObject,COMMAND01);
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
	function downloadCheck() {
		with (sheetObjects[0]) {
			for (var i=HeaderRows; i<=LastRow; i++) {
				if (GetCellValue(i, "down_check") == "N") {
					if (ComShowConfirm("There are unsaved data. Do you want to continue?")) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
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
	  *  registering Combo Object as list
	  * @param combo_obj
	  * @return
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
		 for(i=0;i<sheetObjects.length;i++){
		 // Preferences change the name of the function to start
			 ComConfigSheet (sheetObjects[i] );
			 initSheet(sheetObjects[i],i+1);
		 // The final configuration functions added
			 ComEndConfigSheet(sheetObjects[i]);
		 }
		 for(k=0;k<tabObjects.length;k++){
			 initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		 }
		var comboObjMaxLen=comboObjects.length;
		for(i=0; i < comboObjMaxLen; i++ ) {
			// IBCombo initialization
			initCombo(comboObjects[i], i+1);
		}
		ComSetFocus(document.form.vvd_cd);
		//The required events on the screen
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		ComBtnDisable("btn_formprint");
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
			 case "t1sheet1":      //t1sheet1 init
					with(sheetObj){
					   var HeadTitle1="|hidden_bl_no||Seq.|Save|M.B/L No.|Line|File No.|TP|H/BL|POL|POD|POD|DEL|DEL|Type|Dest Code|CFS Code|IAL|Mode|Bond Code|Trans Operator|Consignee Name|Customer Description|Item|h_down_check|h_vvd_cd";
					   var HeadTitle2="|hidden_bl_no||Seq.|Save|M.B/L No.|Line|File No.|TP|H/BL|POL|POD_CD|YARD|DEL_CD|YARD|Type|Dest Code|CFS Code|IAL|Mode|Bond Code|Trans Operator|Consignee Name|Customer Description|Item|h_down_check|h_vvd_cd";
					   var headCount=ComCountHeadTitle(HeadTitle1);
					   var prefix="";

					   SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:0 } );

					   var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					   var headers = [ { Text:HeadTitle1, Align:"Center"}     ];
					   InitHeaders(headers, info);

					   var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
							  {Type:"Text",      Hidden:1, Width:100,  Align:"Left",    ColMerge:1,   SaveName:prefix+"merge_bl_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"check",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"group_seq",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"down_check",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ida_line_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 },
							  {Type:"Text",      Hidden:0,  Width:110,  Align:"Left",    ColMerge:0,   SaveName:prefix+"hbl_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_cust_tp",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"hbl_ind",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Combo",     Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:prefix+"entry_tp",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dest_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Popup",     Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cfs_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ial",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Combo",     Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mode_trans",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bd_area_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:prefix+"trns_opr_id",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:0,  Width:210,  Align:"Left",    ColMerge:0,   SaveName:prefix+"customer_name", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:0,   SaveName:prefix+"bcd_desc",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
							  {Type:"Combo",     Hidden:0, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"item_tp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
							  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

					   InitColumns(cols);

					   SetEditable(1);
										 SetWaitImageVisible(0);
							 SetShowButtonImage(4);
							 SetSheetHeight(400);
							 SetColProperty(prefix+"entry_tp", {ComboText:"LC|TI|TC", ComboCode:"LC|TI|TC"} );
							 SetColProperty(prefix+"mode_trans", {ComboText:"T:Train|R:Road|S:Ship", ComboCode:"T|R|S"} );
							 SetColProperty(prefix+"item_tp", {ComboText:"OT|GC|UB", ComboCode:"O|G|U"} );
							 SetColProperty("ida_line_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("bl_cust_tp", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("entry_tp", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("dest_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("cfs_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("ial", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("mode_trans", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("bd_area_cd", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("trns_opr_id", {AcceptKeys : "E|N", InputCaseSensitive :1} );
							 SetColProperty("bcd_desc", {AcceptKeys : "E|N", InputCaseSensitive :1} );
					   }


				 break;
			 case "t2sheet1":      //t2sheet1 init
					with(sheetObj){
			   var HeadTitle1="|Seq.|Container No.|TP|Stowage|WGT(ton)|B/L No.|POL|POD|DEL|TS|CGO|DG|RF|AK|BB|Special Cargo Data|h_down_check|h_vvd_cd";
			   var headCount=ComCountHeadTitle(HeadTitle1);
			   var prefix="";

			   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:0} );

			   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			   InitHeaders(headers, info);

			   var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					  {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"Seq" },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ida_stwg_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"cntr_wgt",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bl_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:0,   SaveName:prefix+"del_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ts_cntr_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_cgo_tp_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"dcgo_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rc_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"awk_cgo_flg",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:0,   SaveName:prefix+"bb_cgo_flg",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"spcl_cgo_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"down_check",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
					  {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

			   InitColumns(cols);

			   SetColProperty("ida_stwg_no", {AcceptKeys : "E|N", InputCaseSensitive :1} );

			   SetEditable(1);
			   SetWaitImageVisible(0);
			   SetSheetHeight(400);

					 }


				 break;
		 }
	 }
	 /**
	  * Combo Object initialization
	  * @param comboObj
	  * @param comNo
	  * @return
	  */
	 function initCombo(comboObj, comNo) {
		//ComShowMessage("comboObj ID : " + comboObj.id);
		 var i=0;
		 switch(comboObj.options.id) {
				case "entry_type": {
					i=0;
					with(comboObj) {
						InsertItem(i++, "All",          	"0");
						InsertItem(i++, "LC : Local",       "1");
						InsertItem(i++, "TI : SMTP",        "2");
						InsertItem(i++, "TC : T/S", 		"3");
						Code="0";
						SetSelectIndex(0);
					}
					break;
				}
		 } // end switch
	 }
   // Sheet handling process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
		 sheetObj.ShowDebugMsg(false);
		 var rowCnt=sheetObjects[0].RowCount();
		 var rowCnt1=sheetObjects[1].RowCount();
		 switch(sAction) {
					case IBSEARCH:      //Retrieve
						if(!validateForm(sheetObj,formObj,sAction)) return false;
						ComOpenWait(true);
						formObj.f_cmd.value=SEARCH;
						var sXml=sheetObj.GetSearchData("ESM_BKG_0296GS.do" , FormQueryString(formObj) );
						var arrXml=sXml.split("|$$|");
						//ComShowMessage("arrXml.length => " + arrXml.length);
						//  VESSEL Information set
						var masterResult=ComGetEtcData(arrXml[0], "masterResult"); // return value('success', 'fail')
						if(masterResult == "success") {
							formObj.igm_no.value=ComGetEtcData(arrXml[0],"igmNo");
							formObj.igm_date.value=ComGetEtcData(arrXml[0],"igmDate");
							formObj.vsl_nm.value=ComGetEtcData(arrXml[0],"vslNm");
							formObj.eta_dt.value=ComGetEtcData(arrXml[0],"etaDt");
							// sheet1 setting
							sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
							// sheet2 setting
							sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
							//ComShowMessage("[" + formObj.img_date.value + "]");
							//formObj.img_date.value	= ComGetMaskedValue(formObj.img_date.value, "ymd");
							formObj.tot_bl_num.value=sheetObjects[0].RowCount();
						} else {
							formObj.igm_no.value="";
							formObj.igm_date.value="";
							formObj.vsl_nm.value="";
							formObj.eta_dt.value="";
							formObj.tot_bl_num.value="";
							sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
							sheetObjects[1].LoadSearchData(arrXml[1],{Sync:1} );
						}
						ComOpenWait(false);
						break;
					case MULTI:        //Save
						if(!validateForm(sheetObj,formObj,sAction)) return false;
						for(var i=1; i<=rowCnt; i++) {
							if(sheetObjects[0].GetCellValue(i, "down_check") == 'N') {
								//sheetObjects[0].CellValue2(i,"ibflag") = "I";
								sheetObjects[0].SetRowStatus(i,"I");
							}
						}
						for(var i=1; i<=rowCnt1; i++) {
							if(sheetObjects[1].GetCellValue(i, "down_check") == 'N') {
								//sheetObjects[1].CellValue2(i,"ibflag") = "I";
								sheetObjects[1].SetRowStatus(i,"I");
							}
						}
						formObj.f_cmd.value=MULTI;
						var sParam="";
						var sParamSheet1=sheetObjects[0].GetSaveString();
						if (sParamSheet1 != "") {
							sParam += "&" + ComSetPrifix(sParamSheet1, "sheet1_");
						}
						var sParamSheet2=sheetObjects[1].GetSaveString();
						if (sParamSheet2 != "") {
							sParam += "&" + ComSetPrifix(sParamSheet2, "sheet2_");
						}
						if (sParam == "") {
							ComShowCodeMessage('BKG00743');
							return;
						}
						sParam += "&" + FormQueryString(formObj);
						var sXml=sheetObj.GetSaveData("ESM_BKG_0296GS.do", sParam);
						sheetObjects[tab1.GetSelectedIndex()].LoadSaveData(sXml);
						if(ComBkgErrMessage(sheetObj, sXml)) {
							doActionIBSheet(sheetObj,formObj,IBSEARCH); // Re-retrieve
						}
						break;
					case COMMAND01:  // Line No. Assign
						if(!validateForm(sheetObj,formObj,sAction)) return false;
						goAssign(sheetObj,formObj);
						break;
					case IBDOWNEXCEL:      // Excel
						var objs=document.all.item("tabLayer");
						if(objs[0].style.display == "inline") {
							sheetObjects[0].Down2Excel( {DownCols: makeHiddenSkipCol( 			 	    		sheetObjects[0]), SheetDesign:1,Merge:1 });
						} else {
							sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol( 			 	    		sheetObjects[1]), SheetDesign:1,Merge:1 });
						}
						break;
		 }
		 //
		 for(var i=1; i <= sheetObjects[0].RowCount(); i++) {
			if (sheetObjects[0].GetCellValue(i,"hbl_ind") != "00") {
				sheetObjects[0].SetCellFontColor(i, "hbl_no","#0000FF");//H B/L Color Display
			}
			if (sheetObjects[0].GetCellValue(i,"ida_line_no") == "") {
				sheetObjects[0].SetCellValue(i, "ida_line_no","0",0);
			}
			if (sheetObjects[0].GetCellValue(i,"pod_cd") == "INMAA") {
				if(sheetObjects[0].GetCellValue(i,"entry_tp") == "LC") {
					sheetObj.SetCellEditable(i, "cfs_cd",1);
					sheetObj.SetCellEditable(i, "mode",0);
					sheetObj.SetCellEditable(i, "trns_opr_id",0);
					sheetObj.SetCellEditable(i, "bd_area_cd",1);
				} else if(sheetObjects[0].GetCellValue(i,"entry_tp") == "TI") {
					sheetObjects[0].SetCellValue(i, "cfs_cd",sheetObjects[0].GetCellValue(i,"pod_cd"),0);
					sheetObj.SetCellEditable(i, "cfs_cd",0);
					sheetObj.SetCellEditable(i, "mode",1);
					sheetObj.SetCellEditable(i, "trns_opr_id",0);
					sheetObj.SetCellEditable(i, "bd_area_cd",1);
				} else if(sheetObjects[0].GetCellValue(i,"entry_tp") == "TC") {
					sheetObj.SetCellEditable(i, "mode",1);
					sheetObj.SetCellEditable(i, "trns_opr_id",0);
					sheetObj.SetCellEditable(i, "bd_area_cd",1);
				}
			} else if (sheetObjects[0].GetCellValue(i,"pod_cd") == "INNAH") {
				if(sheetObjects[0].GetCellValue(i,"entry_tp") == "LC") {
					sheetObj.SetCellEditable(i, "cfs_cd",1);
					sheetObj.SetCellEditable(i, "bd_area_cd",0);
					sheetObj.SetCellEditable(i, "mode",0);
					sheetObj.SetCellEditable(i, "trns_opr_id",0);
				} else if(sheetObjects[0].GetCellValue(i,"entry_tp") == "TI") {
					sheetObjects[0].SetCellValue(i, "cfs_cd","",0);
					sheetObj.SetCellEditable(i, "cfs_cd",0);
					sheetObj.SetCellEditable(i, "bd_area_cd",1);
					sheetObj.SetCellEditable(i, "mode",1);
					sheetObj.SetCellEditable(i, "trns_opr_id",1);
				} else if(sheetObjects[0].GetCellValue(i,"entry_tp") == "TC") {
					sheetObj.SetCellEditable(i, "bd_area_cd",0);
					sheetObj.SetCellEditable(i, "mode",1);
					sheetObj.SetCellEditable(i, "trns_opr_id",1);
				}
			}
		} // end for(i)
		var fCnt=0;
		var tCnt=0;
		for(var i=1; i <= sheetObjects[1].RowCount(); i++) {
			var tp=sheetObjects[1].GetCellValue(i,"cntr_tpsz_cd");
			if(tp != "" && tp.length == 2) {
				tp=tp.substr(1.1);
				if(tp == "2") {
					tCnt++;
				} else {
					fCnt++;
				}
			}
		} // end for(i)
		document.getElementById("f_cnt").value=fCnt;
		document.getElementById("t_cnt").value=tCnt;
	 }
	 /**
	  * mult save Paste PREFIX
	  * @param sStr
	  * @param sPrefix
	  * @return
	  */
	 function ComSetPrifix(sStr, sPrefix) {
		 if (sStr == null || sStr == "" || sPrefix == null || sPrefix == "") {
			 return sStr;
		 }
		 var regexp=RegExp(/&/g);
		 sStr=sPrefix + sStr.replace(regexp, "&" + sPrefix);
		 return sStr;
	 }
	 /**
	  * 'Assign' button click - B/L Grid Line_No Assignment
	  *
	  * @param sheetObj
	  * @param formObj
	  * @return
	  */
	 function goAssign(sheetObj,formObj) {
		 var rowCnt=sheetObj.RowCount();
		 var fromLineNo=formObj.from_line_no.value - 1;
		 var toLineNo=formObj.to_line_no.value;
		 //ComShowMessage("toLineNo : [" + toLineNo + "]");
		 var check;
		 for(i=0; i<=rowCnt; i++) {
			 check=sheetObjects[0].GetCellValue(i, "check");
			 if(check == 1) {
				 sheetObjects[0].SetCellValue(i, "ida_line_no",++fromLineNo,0);
				 if(fromLineNo == toLineNo) break;
			 }
		 } // end for(i)
	 }
	 /**
	  * Register as array  to IBTab Object
	  * adding process for list in case of needing batch processing with other items
	  * defining list on the top of source
	  */
	 function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	 }
	 /**
	  * initializing Tab
	  * setting Tab items
	  */
	 function initTab(tabObj , tabNo) {
		  switch(tabNo) {
			  case 1:
				 with (tabObj) {
					 var cnt=0 ;
					InsertItem( "B/L" , "");
					InsertItem( "CNTR" , "");
				 }
			  break;
		  }
	 }
	 /**
	  * Event when clicking Tab
	  * activating selected tab items
	  */
	 function tab1_OnChange(tabObj , nItem)
	 {
		 var objs=document.all.item("tabLayer");
			objs[nItem].style.display="Inline";
			objs[beforetab].style.display="none";
			//--------------- Importance --------------------------//
			objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
			//------------------------------------------------------//
			beforetab=nItem;
	 }
	 /**
	  * handling process for input validation
	  */
	 function validateForm(sheetObj,formObj,sAction) {
		switch(sAction) {
			case IBSEARCH :
				//Check the default format
				if (!ComChkValid(formObj)) return false;
				break;
			case MULTI:
				var shee1RowCnt=sheetObjects[0].RowCount();
				var cfsCd="";
				for(var i=1; i<=shee1RowCnt; i++) {
				var cfsCd=sheetObjects[0].GetCellValue(i,"cfs_cd");
				if(sheetObjects[0].GetCellValue(i, "entry_tp") == 'LC') {
					if(sheetObjects[0].GetCellValue(i,"cfs_cd") == "") {
						ComShowCodeMessage("BKG01102", sheetObjects[0].GetCellValue(i,"seq"), "CFS Code");
							return false;
						}
					} else {
					}
				} // end for(i)
				break;
			case COMMAND01: // Assign Button
				var rowCnt=sheetObj.RowCount();
				var checkCnt=0;
				var firstCnt=0;
				if(rowCnt == 0) {
					ComShowCodeMessage('BKG00889');
					return false;
				}
				var fromLineNo=formObj.from_line_no.value;
				var toLineNo=formObj.to_line_no.value;
				if(fromLineNo == "") {
					ComShowCodeMessage('BKG01104');
					ComSetFocus(formObj.from_line_no);
					return false;
				}
				for(i=0; i < rowCnt; i++) {
					if(sheetObj.GetCellValue(i, "check") ==  "1") {
						checkCnt++;
					} else {
						var lineNo=sheetObj.GetCellValue(i, "ida_line_no");
						if(lineNo != "" || lineNo != "0") {
							firstCnt++;
						}
					}
				}
				if(checkCnt == 0) {
					ComShowCodeMessage('BKG01105');
					return false;
				}
				if(firstCnt == 0) {
					ComShowCodeMessage('BKG01106');
					return false;
				}
				break;
		}
		 return true;
	 }
	 /**
	  * IBSheet cell click  popup
	  * @param sheetObj
	  * @param Row
	  * @param Col
	  * @return
	  */
	function t1sheet1_OnPopupClick(sheetObj, Row,Col)	{
		var colName=sheetObj.ColSaveName(Col);
		var formObj=document.form;
		switch(colName) {
			case "dest_cd":
				var sUrl="ESM_BKG_0334_POP.do";
				var params="?country="+formObj.cnt_cd.value;
				//var rtnVal=ComOpenWindowCenter(sUrl + params, "ESM_BKG_0334", 1007, 520, true);

				ComOpenPopup(sUrl, 1007, 520, "findDescCd", "1,0,1,1,1,1,1", true);

				/*if (rtnVal != null){
					sheetObj.SetCellValue(Row, 'dest_cd',rtnVal.cd,0);
					//sheetObj.CellValue2(Row, 'cstms_desc') = rtnVal.nm;
				}*/
				break;
			case "cfs_cd":
//				var sUrl="ESM_BKG_0305_P.do";
//				var rtnVal=ComOpenWindowCenter(sUrl, "ESM_BKG_0305_P", 1007, 520, true);
//				alert('a')
//				if (rtnVal != null){
//					sheetObj.SetCellValue(Row, 'cfs_cd',rtnVal.cd,0);
//					sheetObj.SetCellValue(Row, 'bd_area_cd',rtnVal.nm,0);
//				}
				var sUrl="ESM_BKG_0305_P.do";
				var params="?country="+formObj.cnt_cd.value;
				//var rtnVal=ComOpenWindowCenter(sUrl + params, "ESM_BKG_0334", 1007, 520, true);

				ComOpenPopup(sUrl, 1007, 400, "cfsDescCd", "1,0,1,1,1,1,1", true);
				break;
		} // end switch()
	}

	function findDescCd(rtnVal) {
		if (rtnVal != null){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), 'dest_cd',rtnVal.cd,0);
		}

	}

	function cfsDescCd(rtnVal) {
		if (rtnVal != null){
			sheetObjects[0].SetCellValue(sheetObjects[0].GetSelectRow(), 'cfs_cd',rtnVal.cd,0);
		}

	}
	 /**
	  * handling  search condition  Input
	  */
	 function obj_KeyUp() {
		var formObject=document.form;
		var srcName=ComGetEvent("name");
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		/*
		if (srcName == "vvd_cd" && ComChkLen(srcValue, srcMaxLength) == "2") {
			ComSetNextFocus();
		}
		*/
	 }
	 /**
	  * Sheet click Event
	  */
	 function t1sheet1_OnClick(sheetObj, row, col) {
		var rowCnt=sheetObj.RowCount();
		var check=sheetObj.GetCellValue(row,"check");
		var groupSeq=sheetObj.GetCellValue(row,"group_seq");
		var colSaveName=sheetObj.ColSaveName(col);
		for(var i=1; i<=rowCnt; i++) {
			if(colSaveName == "check") {
				if(check == 1) {
					if(i == row) continue;
					if(groupSeq == sheetObj.GetCellValue(i, "group_seq")) {
						sheetObj.SetCellValue(i, "check",0,0);
					}
				} else if(check == 0) {
					if(i == row) continue;
					if(groupSeq == sheetObj.GetCellValue(i, "group_seq")) {
						sheetObj.SetCellValue(i, "check",1,0);
					}
				}
			}
		} // end for(i)
	 }
	 /**
	  * Sheet Change Event
	  *
	  * @param sheetObj
	  * @param Row
	  * @param Col
	  * @param Value
	  * @return
	  */
	 function t1sheet1_OnChange(sheetObj, Row, Col, Value) {
		var colname=sheetObj.ColSaveName(Col);
		var formObj=document.form
		switch(colname)	{
			case "entry_tp":
				if(Value == "LC") {
					if (sheetObj.GetCellValue(Row,"pod_cd") == "INMAA") {
						sheetObj.SetCellEditable(Row, "cfs_cd",1);
						sheetObj.SetCellEditable(Row, "mode",0);
						sheetObj.SetCellEditable(Row, "trns_opr_id",0);
						sheetObj.SetCellEditable(Row, "bd_area_cd",1);
					} else if (sheetObj.GetCellValue(Row,"pod_cd") == "INNAH") {
						sheetObj.SetCellEditable(Row, "cfs_cd",1);
						sheetObj.SetCellEditable(Row, "bd_area_cd",0);
						sheetObj.SetCellEditable(Row, "mode",0);
						sheetObj.SetCellEditable(Row, "trns_opr_id",0);
					}
				} else if(Value == "TI") {
					if (sheetObj.GetCellValue(Row,"pod_cd") == "INMAA") {
						sheetObjects[0].SetCellValue(Row, "cfs_cd",sheetObjects[0].GetCellValue(Row,"pod_cd"),0);
						sheetObj.SetCellEditable(Row, "cfs_cd",0);
						sheetObj.SetCellEditable(Row, "mode",1);
						sheetObj.SetCellEditable(Row, "trns_opr_id",0);
						sheetObj.SetCellEditable(Row, "bd_area_cd",1);
					} else if (sheetObj.GetCellValue(Row,"pod_cd") == "INNAH") {
						sheetObjects[0].SetCellValue(Row, "cfs_cd","",0);
						sheetObj.SetCellEditable(Row, "cfs_cd",0);
						sheetObj.SetCellEditable(Row, "bd_area_cd",1);
						sheetObj.SetCellEditable(Row, "mode",1);
						sheetObj.SetCellEditable(Row, "trns_opr_id",1);
					}
				} else if(Value == "TC") {
					if (sheetObj.GetCellValue(Row,"pod_cd") == "INMAA") {
						sheetObj.SetCellEditable(Row, "mode",1);
						sheetObj.SetCellEditable(Row, "trns_opr_id",0);
						sheetObj.SetCellEditable(Row, "bd_area_cd",1);
					} else if (sheetObj.GetCellValue(Row,"pod_cd") == "INNAH") {
						sheetObj.SetCellEditable(Row, "bd_area_cd",0);
						sheetObj.SetCellEditable(Row, "mode",1);
						sheetObj.SetCellEditable(Row, "trns_opr_id",1);
					}
				}
				break;
		} // end switch()
	 }
	 /**
	  * The event after  Retrieve
	  * @param sheetObj
	  * @param ErrMsg
	  * @return
	  */
	function t1sheet1_OnSearchEnd(sheetObj,ErrMsg){
		var rowCnt=sheetObj.RowCount();
		if(rowCnt == 0 ) {
			ComBtnDisable("btn_formprint");
		} else {
			ComBtnEnable("btn_formprint");
		}
		var exitOrg=sheetObj.GetEtcData("retExitOrg");
		 if(exitOrg == "0") {
			ComShowCodeMessage("BKG01107");
			return false;
		 } else if(exitOrg == "") {
			if (ErrMsg == "") {
				if(sheetObj.RowCount()== 0) {
					ComShowCodeMessage("BKG00889");
					return false;
				}
			}
		 } else {
		 }
	}
