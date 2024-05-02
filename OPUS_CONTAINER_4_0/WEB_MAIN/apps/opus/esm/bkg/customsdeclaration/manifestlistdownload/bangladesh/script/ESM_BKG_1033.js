/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1033.js
*@FileTitle  : Bangladesh Cargo Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
				[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
				character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class Delivery Mode : business script for Delivery Mode
 */
function ESM_BKG_1033() {
	this.processButtonClick=tprocessButtonClick;
	this.setSheetObject=setSheetObject;
	this.loadPage=loadPage;
	this.initSheet=initSheet;
	this.doActionIBSheet=doActionIBSheet;
	this.validateForm=validateForm;
}
var sheetObjects=new Array();
var sheetCnt=0;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
	function processButtonClick() {
		/***** using extra sheet valuable if there are more 2 sheets *****/
		var sheetObject1 = sheetObjects[0];
		var sheetObject2 = sheetObjects[1];
		/*******************************************************/
		var formObject  =document.form;
		try {
			var srcName=ComGetEvent("name");
			if (pgmno == "01") {
				if (formObject.data_type[0].checked) {									// Outbound B/L List retrieve
					switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC01);
						break;
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
						break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBRESET);
						break;
						case "btn_Sailed":
							var cal=new ComCalendar();
							cal.select(formObject.sail_dt, 'yyyy-MM-dd');
						break;
						case "btn_PopUp":
							var params=FormQueryString(formObject);
							ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 1000, 500);
						break;
					}// end switch

				} else {																		// Outbound D/L List retrieve
					switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC02);
						break;
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
						break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBRESET);
						break;
						case "btn_Sailed":
							var cal=new ComCalendar();
							cal.select(formObject.sail_dt, 'yyyy-MM-dd');
						break;
						case "btn_PopUp":
							var params=FormQueryString(formObject);
							ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 1000, 500);
						break;
					}// end switch
				}
			} else {
				if (formObject.data_type[0].checked) {									// Inbound B/L List retrieve
					switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC03);
						break;
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
						break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBRESET);
						break;
						case "btn_Sailed":
							var cal=new ComCalendar();
							cal.select(formObject.sail_dt, 'yyyy-MM-dd');
						break;
						case "btn_Assign":
							doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
						case "btn_PopUp":
							var params=FormQueryString(formObject);
							ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 1000, 500);
						break;
						case "btn_Transmit":
							doActionIBSheet(sheetObject1,formObject,MULTI01);
						break;
					}// end switch
				} else {																		// Inbound D/L List retrieve
					switch(srcName) {
						case "btn_Retrieve":
							doActionIBSheet(sheetObject1,formObject,IBSEARCH_ASYNC04);
						break;
						case "btn_Save":
							doActionIBSheet(sheetObject1,formObject,IBSAVE);
						break;
						case "btn_DownExcel":
							doActionIBSheet(sheetObject2,formObject,IBDOWNEXCEL);
						break;
						case "btn_New":
							doActionIBSheet(sheetObject1,formObject,IBRESET);
						break;
						case "btn_Sailed":
							var cal=new ComCalendar();
							cal.select(formObject.sail_dt, 'yyyy-MM-dd');
						break;
						case "btn_Assign":
							doActionIBSheet(sheetObject1,formObject,IBINSERT);
						break;
						case "btn_PopUp":
							var params=FormQueryString(formObject);
							ComOpenWindowCenter("ESM_BKG_1038.do?"+params, "ESM_BKG_1038", 1000, 500);
						break;
						case "btn_Transmit":
							doActionIBSheet(sheetObject1,formObject,MULTI01);
						break;
					}// end switch
				}
			}
		} catch(e) {
			if ( e == "[object Error]") {
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
	function setSheetObject(sheet_obj) {
		sheetObjects[sheetCnt++]=sheet_obj;
	}


	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
		if (pgmno == "01") ComBtnDisable("btn_Transmit");
		//necessary event on the screen
		axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
		axon_event.addListenerFormat("KeyPress","obj_KeyPress", document.form);
		axon_event.addListener("keydown", "ComKeyEnter", "form");
		axon_event.addListenerForm("click", "obj_Click", document.form);
		//combo data retrieve
		doActionIBSheet(sheetObjects[0],document.form,IBCREATE);

	}


	/**
	 * move next tab in case of typing MaxLength
	 */
	function obj_KeyUp() {
		var formObject=document.form;
		var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
		var srcValue=window.event.srcElement.getAttribute("value");
		var srcName=ComGetEvent("name");
		if ( (  srcName == "vvd" || srcName == "pol_cd" || srcName == "pol_yd" || srcName == "pod_cd" || srcName == "pod_yd" || srcName == "bl_no" || srcName == "sail_dt" || srcName == "rot_no") && ComChkLen(srcValue, srcMaxLength) == "2" ) {
			ComSetNextFocus();
		}
	}


	/**
	 * setting sheet initial values and header
	 * @param sheetObj
	 * @param sheetNo
	 * @return
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt = 0;
		switch(sheetObj.id) {
		case "sheet1":      //sheet1 init - Inbound B/L or D/L List screen Grid
		with(sheetObj) {

			var HeadTitle1="|Line No./\nNo. Serial|B/L Number|Type of BoL|Number/\nQuantity|Description|Marks & Number|Descriptions of Goods|Date of Entry\nof Goods|Cons.\nLicense No|Cons. Name|Notify\nLicense No|Notify P. Name|Gross Weight\nPer B/L|Net Weight\nPer B/L|Container No|Seal|Size|Type|Height|Cont. Gross\nWeight|Cont. Tare\nWeight|Status|IMCO|UN|VAT|Commodity\nCode|Container\nLocation|Off Dock Id|Perishable Info|Remarks|||||||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status", Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Text",   Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"line_no",          Edit:0 },
						{Type:"Text",   Hidden:0,  Width:135,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            Edit:0 },
						{Type:"CheckBox",   Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hbl_ind",      Edit:1 },
						{Type:"Text",   Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty",              Edit:1 },
						{Type:"Text",   Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"description",      Edit:1 },
						{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"marks",            Edit:1 },
						{Type:"Text",   Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"goods_desc",       Edit:1 },
						{Type:"Date",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"goods_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cons_lice",        Edit:1 },
						{Type:"Text",   Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cons_nm",          Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noty_lice",        Edit:1 },
						{Type:"Text",   Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"noty_nm",          Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bl_gross_wgt",     Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bl_net_wgt",       Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"seal",             Edit:1 },
						{Type:"Text",   Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cntr_size",        Edit:1 },
						{Type:"Text",   Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_type",        Edit:1 },
						{Type:"Text",   Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"height",           Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_gross_wgt",   Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_tare_wgt",    Edit:1 },
						{Type:"Combo",  Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"status",           Edit:1 },
						{Type:"Text",   Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"imco",             Edit:1 },
						{Type:"Text",   Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"un",               Edit:1 },
						{Type:"Text",   Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vat",              Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cd",          Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_loc_cd",      Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"off_dock",         Edit:1 },
						{Type:"Combo",  Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"perish_cd",        Edit:1 },
						{Type:"Text",   Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"remarks",          Edit:1 },

						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_iso_cd", Edit:0 },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_bl_no",   },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tz",     },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd",      },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",      },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",    },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ut_cd",  },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd"},
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_nm",      },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"voy_no",      },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"temp",        },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",         },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",  },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",  },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",      },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",  },
						{Type:"Text",   Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",  } ];

			InitColumns(cols);

			SetEditable(1);
			SetSheetHeight(400);//148
			}
			break;

		case "sheet3":      //sheet3 init - Inbound B/L or D/L List DownExcel Grid
		with(sheetObj) {

			var HeadTitle1="|Line No./\nNo. Serial|B/L Number|Type of BoL|Number/\nQuantity|Description|Marks & Number|Descriptions of Goods|Date of Entry\nof Goods|Cons.\nLicense No|Cons. Name|Notify\nLicense No|Notify P. Name|Gross Weight\nPer B/L|Net Weight\nPer B/L|Container No|Seal|Size|Type|Height|Cont. Gross\nWeight|Cont. Tare\nWeight|Status|IMCO|UN|VAT|Commodity\nCode|Container\nLocation|Off Dock Id|Perishable Info|Remarks|Sailed Year|Ship's Name|Voy No|Import Rot Number|MLO Code|||||||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [{Type:"Status",    Hidden:1,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"line_no",          Edit:0 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bl_no",            Edit:0 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"hbl_code",      Edit:1 },
						{Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty",              Edit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"description",      Edit:1 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"marks",            Edit:1 },
						{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"goods_desc",       Edit:1 },
						{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"goods_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cons_lice",        Edit:1 },
						{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cons_nm",          Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"noty_lice",        Edit:1 },
						{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"noty_nm",          Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bl_gross_wgt",     Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"bl_net_wgt",       Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",          Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"seal",             Edit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cntr_size",        Edit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_type",        Edit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"height",           Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_gross_wgt",   Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"cntr_tare_wgt",    Edit:1 },
						{Type:"Combo",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"status",           Edit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"imco",             Edit:1 },
						{Type:"Text",      Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"un",               Edit:1 },
						{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vat",              Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cd",          Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_loc_cd",      Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"off_dock",         Edit:1 },
						{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"perish_cd",        Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"remarks",          Edit:1 },

						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_sail_dt",    Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_vsl_nm",     Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_voy_no",     Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_rot_no",     Edit:1 },
						{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_mlo_cd",     Edit:1 },

						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_iso_cd", Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_bl_no",        Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tz",          Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",         Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ut_cd",       Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd",    Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_nm",           Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"voy_no",           Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"temp",             Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",              Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",       Edit:0 },
						{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       Edit:0 } ];

			InitColumns(cols);

			SetEditable(1);
			InitViewFormat(0, "goods_date", "yyyy-mm-dd");
			SetVisible(0);
			}
			break;

		case "sheet2":      //sheet2 init - Outbound B/L or D/L List screen Grid
		with(sheetObj) {

			var HeadTitle1="|SL No.|TR No.|Type of BoL|TR Date|S/BILL\nNo.|S/B Date|EXP No.|EXP Date|POD|Marks &\nNumber|No. of\nPackages|Nat of\nPackage|Descriptions of Goods|Gross Weight|Container No|Seal|Size|Type|Height|Weight|Status|IMCO|UN|VAT|Commodity\nCode|Container\nLocation|Off Dock Id|Perishable Info|By Whom\nShipped|To  Whom\nShipped||||||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"sl_no",         Edit:0 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"tr_no",         Edit:1 },
			{Type:"CheckBox",  Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hbl_ind",       Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tr_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"sbill_no",      Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sb_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"exp_no",        Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_date",      Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pod_nm",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mark_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pack_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pack_nat",      Edit:1 },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"goods_desc",    Edit:1 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"gross_wgt",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"seal",          Edit:1 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cntr_size",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_type",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"height",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"weight",        Edit:1 },
			{Type:"Combo",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"status",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"imco",          Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"un",            Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vat",           Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cd",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_loc_cd",   Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"off_dock",      Edit:1 },
			{Type:"Combo",     Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"perish_cd",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",    Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",       Edit:1 },

			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_bl_no",     Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tz",       Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",      Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ut_cd",    Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd", Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_nm",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"voy_no",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",           Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",    Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",    Edit:0 } ];

			InitColumns(cols);

			SetEditable(1);
			InitViewFormat(0, "tr_date", "yyyy-mm-dd");
			InitViewFormat(0, "sb_date", "yyyy-mm-dd");
			InitViewFormat(0, "exp_date", "yyyy-mm-dd");
			SetSheetHeight(400);//358
			}
			break;

		case "sheet4":      //sheet2 init - Outbound B/L or D/L List DownExcel Grid
		with(sheetObj) {

			var HeadTitle1="|SL No.|TR No.|Type of BoL|TR Date|S/BILL\nNo.|S/B Date|EXP No.|EXP Date|POD|Marks &\nNumber|No. of\nPackages|Nat of\nPackage|Descriptions of Goods|Gross Weight|Container No|Seal|Size|Type|Height|Weight|Status|IMCO|UN|VAT|Commodity\nCode|Container\nLocation|Off Dock Id|Perishable Info|By Whom\nShipped|To  Whom\nShipped|Sailed Year|Ship's Name|Voy No|Export Rot Number|MLO Code||||||||||||";
			var headCount=ComCountHeadTitle(HeadTitle1);

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			{Type:"Text",      Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:"sl_no",         Edit:0 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"tr_no",         Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"hbl_code",      Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tr_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"sbill_no",      Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"sb_date",       Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"exp_no",        Edit:1 },
			{Type:"Date",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"exp_date",      Edit:1,   EditLen:8,   Format:"Ymd" },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"pod_nm",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mark_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pack_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"pack_nat",      Edit:1 },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"goods_desc",    Edit:1 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Right",   ColMerge:1,   SaveName:"gross_wgt",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"seal",          Edit:1 },
			{Type:"Text",      Hidden:0,  Width:50,   Align:"Right",   ColMerge:1,   SaveName:"cntr_size",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"cntr_type",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Right",   ColMerge:1,   SaveName:"height",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"weight",        Edit:1 },
			{Type:"Combo",     Hidden:0,  Width:50,   Align:"Left",    ColMerge:1,   SaveName:"status",        Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"imco",          Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"un",            Edit:1 },
			{Type:"Text",      Hidden:0,  Width:70,   Align:"Left",    ColMerge:1,   SaveName:"vat",           Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_cd",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cntr_loc_cd",   Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"off_dock",      Edit:1 },
			{Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"perish_cd",     Edit:1 },
			{Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"shipper_nm",    Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"cnee_nm",       Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_sail_dt", Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_vsl_nm",  Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_voy_no",  Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_rot_no",  Edit:1 },
			{Type:"Text",      Hidden:0,  Width:100,  Align:"Left",    ColMerge:1,   SaveName:"excel_mlo_cd",  Edit:1 },

			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"org_bl_no",     Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_tz",       Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_wgt",      Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_ut_cd",    Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"bkg_cgo_tp_cd", Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vsl_nm",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"voy_no",        Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vvd",           Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cre_usr_id",    Edit:0 },
			{Type:"Text",      Hidden:1,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",    Edit:0 } ];

			InitColumns(cols);

			SetEditable(1);
			InitViewFormat(0, "tr_date", "yyyy-mm-dd");
			InitViewFormat(0, "sb_date", "yyyy-mm-dd");
			InitViewFormat(0, "exp_date", "yyyy-mm-dd");
			SetVisible(0);
			}
			break;
		}
	}


	/**
	 * handling sheet process
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return void
	 */
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.SetWaitImageVisible(0);
		switch(sAction) {
			case IBCREATE:      //combo data retrieve
				formObj.f_cmd.value=INIT;
				var sXml = sheetObj.GetSearchData("ESM_BKG_1033GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				var arrCombo = null;
				arrCombo = ComXml2ComboString(arrXml[0], "name", "val");
				sheetObj.SetColProperty("perish_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
				sheetObjects[1].SetColProperty("perish_cd", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
/*
				arrCombo = ComXml2ComboString(arrXml[1], "val", "val");
				sheetObj.SetColProperty("status", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
				sheetObjects[1].SetColProperty("status", {ComboText:arrCombo[0], ComboCode:arrCombo[1]} );
*/
				sheetObj.SetColProperty("status", {ComboText:"|LCL|PRT|FCL", ComboCode:"|LCL|PRT|FCL"} );
				sheetObjects[1].SetColProperty("status", {ComboText:"|LCL|PRT|FCL", ComboCode:"|LCL|PRT|FCL"} );
			break;

			case IBSEARCH_ASYNC01:      //Outbound B/L List retrieve
				if (!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.io_flag.value = "O";
				formObj.data_flag.value = "B";
				formObj.f_cmd.value = SEARCH01;
				var sXml = sheetObj.GetSearchData("ESM_BKG_1033GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1} );
				if (sheetObj.RowCount() > 0) {
					formObj.vsl_nm.value = ComGetEtcData(sXml, "vsl_nm");
					formObj.voy_no.value = ComGetEtcData(sXml, "voy_no");
				} else {
					formObj.vsl_nm.value = "";
					formObj.voy_no.value = "";
				}
				sheetObjects[1].LoadSearchData(sXml, {Sync:1} );
				ComOpenWait(false);
			break;

			case IBSEARCH_ASYNC02:      //Outbound D/L List retrieve
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				ComOpenWait(true);
				formObj.io_flag.value = "O";
				formObj.data_flag.value = "D";
				formObj.f_cmd.value = SEARCH02;
				var sXml=sheetObj.GetSearchData("ESM_BKG_1033GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml, {Sync:1} );
				if (sheetObj.RowCount() > 0) {
					formObj.vsl_nm.value = ComGetEtcData(sXml, "vsl_nm");
					formObj.voy_no.value = ComGetEtcData(sXml, "voy_no");
				} else {
					formObj.vsl_nm.value = "";
					formObj.voy_no.value = "";
				}
				sheetObjects[1].LoadSearchData(sXml, {Sync:1} );
				ComOpenWait(false);
			break;

			case IBSEARCH_ASYNC03:      //Inbound B/L List retrieve
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				ComOpenWait(true);
				formObj.io_flag.value = "I";
				formObj.data_flag.value = "B";
				formObj.f_cmd.value = SEARCH03;
				var sXml = sheetObj.GetSearchData("ESM_BKG_1033GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObj.LoadSearchData(arrXml[0], {Sync:1} );
				if (sheetObj.RowCount() > 0) {
					formObj.vsl_nm.value = ComGetEtcData(arrXml[0], "vsl_nm");
					formObj.voy_no.value = ComGetEtcData(arrXml[0], "voy_no");
				} else {
					formObj.vsl_nm.value = "";
					formObj.voy_no.value = "";
				}
				sheetObjects[1].LoadSearchData(arrXml[0], {Sync:1} );
				ComOpenWait(false);
			break;

			case IBSEARCH_ASYNC04:      //Inbound D/L List retrieve
				if (!validateForm(sheetObj,formObj,sAction)) return false;
				ComOpenWait(true);
				formObj.io_flag.value = "I";
				formObj.data_flag.value = "D";
				formObj.f_cmd.value = SEARCH04;
				var sXml = sheetObj.GetSearchData("ESM_BKG_1033GS.do", FormQueryString(formObj));
				var arrXml = sXml.split("|$$|");
				sheetObj.LoadSearchData(arrXml[0], {Sync:1} );
				if (sheetObj.RowCount() > 0) {
					formObj.vsl_nm.value = ComGetEtcData(arrXml[0], "vsl_nm");
					formObj.voy_no.value = ComGetEtcData(arrXml[0], "voy_no");
				} else {
					formObj.vsl_nm.value = "";
					formObj.voy_no.value = "";
				}
				sheetObjects[1].LoadSearchData(arrXml[0], {Sync:1} );
				ComOpenWait(false);
			break;

			case IBRESET:        //initializing
				formObj.reset();
				sheetObj.RemoveAll();
			break;

			case IBSAVE:
				if(!ComShowConfirm(ComGetMsg("BKG95003", "save data"))) return; // "Do you want to {?msg1}?"
				if (!validateForm(sheetObj, formObj, sAction)) return false;
				ComOpenWait(true);
				formObj.f_cmd.value=MULTI;
				var sXml=sheetObj.GetSaveData("ESM_BKG_1033GS.do", FormQueryString(formObj)+"&"+ComGetSaveString(sheetObj, true, true));
				sheetObj.LoadSaveData(sXml);
				ComOpenWait(false);
				//다운로드 후 D/L List로 재조회한다.
				ComSetObjValue(formObj.data_type,"D");
				if (pgmno == "01") {
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC02); //Outbound D/L List 조회
				}else{
					doActionIBSheet(sheetObj,formObj,IBSEARCH_ASYNC04); //Inbound D/L List 조회
				}
			break;

			case MULTI01:      //EDI Transmit
				if(!ComShowConfirm(ComGetMsg("BKG95003", "transmit manifest"))) return; // "Do you want to {?msg1}?"
				ComOpenWait(true);
				formObj.f_cmd.value = MULTI01;
				for (var i=sheetObjects[0].HeaderRows(); i<=sheetObjects[0].LastRow(); i++) {
					sheetObjects[0].SetCellValue(i, "vsl_cd", formObj.vvd.value.substring(0,4));
					sheetObjects[0].SetCellValue(i, "skd_voy_no", formObj.vvd.value.substring(4,8));
					sheetObjects[0].SetCellValue(i, "skd_dir_cd", formObj.vvd.value.substring(8));
					sheetObjects[0].SetCellValue(i, "ibflag", "I");
				}
				var sParam ="";
				var sParamSheet2 = sheetObjects[0].GetSaveString();
				if (sParamSheet2 != "") {
					sParam += "&" + ComSetPrifix(sParamSheet2, "sheet1");
				}
				sParam += "&" + FormQueryString(formObj);
				var sXml = sheetObj.GetSaveData("ESM_BKG_1033GS.do", sParam);
				ComOpenWait(false);
				sheetObjects[0].LoadSaveData(sXml);
			break;

			case IBDOWNEXCEL:   //Down Excel
				ComOpenWait(true);
				sheetObjects[1].Down2Excel( {DownCols: makeHiddenSkipCol(sheetObjects[1]), SheetDesign:1, Merge:1} );
				ComOpenWait(false);
			break;

			case IBINSERT:		// setting Date of Entry of Goods to Sailed Year using Assign button
				for(var i=1; i<sheetObj.RowCount()+1; i++) {
					sheetObj.SetCellValue(i, "goods_date",formObj.sail_dt.value,0);
					if (sheetObjects[1].GetCellValue(i,"bl_no") != "") {
						sheetObjects[1].SetCellValue(i,"goods_date",formObj.sail_dt.value,0);
					}
				}
			break;
		}
	}


	/**
	 * handling after retrieve
	 * @param sheetObj : IBSheet Object
	 * @param ErrMsg
	 * @return
	 */
	function sheet3_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || sheetObj.RowCount() < 1)  return;
		var formObj = document.form;
		with (sheetObj) {
			ReDraw = false;
			for (var i=HeaderRows(); i<=LastRow(); i++) {
				SetCellValue(i, "excel_sail_dt", formObj.sail_dt.value, 0);
				SetCellValue(i, "excel_vsl_nm", formObj.vsl_nm.value, 0);
				SetCellValue(i, "excel_voy_no", formObj.voy_no.value, 0);
				SetCellValue(i, "excel_rot_no", formObj.rot_no.value, 0);
				SetCellValue(i, "excel_mlo_cd", formObj.mlo_cd.value, 0);
			}
			ReDraw = true;
		}
	}


	/**
	 * handling after retrieve
	 * @param sheetObj : IBSheet Object
	 * @param ErrMsg
	 * @return
	 */
	function sheet4_OnSearchEnd(sheetObj, Code, Msg, StCode, StMsg) {
		if (Code < 0 || sheetObj.RowCount() < 1)  return;
		var formObj = document.form;
		with (sheetObj) {
			ReDraw = false;
			for (var i=HeaderRows(); i<=LastRow(); i++) {
				SetCellValue(i, "excel_sail_dt", formObj.sail_dt.value, 0);
				SetCellValue(i, "excel_vsl_nm", formObj.vsl_nm.value, 0);
				SetCellValue(i, "excel_voy_no", formObj.voy_no.value, 0);
				SetCellValue(i, "excel_rot_no", formObj.rot_no.value, 0);
				SetCellValue(i, "excel_mlo_cd", formObj.mlo_cd.value, 0);
			}
			ReDraw = true;
		}
	}


	/**
	 * handling process for input validation <br>
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 * @return boolean
	 */
	function validateForm(sheetObj,formObj,sAction) {
		switch (sAction) {
			case IBSEARCH_ASYNC01: // retrieve
				if (!ComChkRequired(formObj)) return false;
				break;
			case IBSEARCH_ASYNC02: // retrieve
			if (!ComChkRequired(formObj)) return false;
			break;
			case IBSEARCH_ASYNC03: // retrieve
			if (!ComChkRequired(formObj)) return false;
			break;
			case IBSEARCH_ASYNC04: // retrieve
			if (!ComChkRequired(formObj)) return false;
			break;
		}
		return true;
	}
