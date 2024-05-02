/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1147.js
*@FileTitle  : Thailand Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/12
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
 MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;

	var sheetObjects=new Array();
	var sheetCnt=0;

	var intervalId="";
	var comboObjects=new Array();
	var comboCnt=0;

	// Event handler processing by button click event */
	document.onclick=processButtonClick;

	/**
	 * Event handler processing by button name
	 */
	function processButtonClick(){
		 var sheetObject=sheetObjects[0];
		 var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_Retrieve":
					doActionIBSheet(sheetObjects[0],document.form,IBSEARCH);
					break;
				case "btn_down_excel":
					if( beforetab == 0 ){
						doActionIBSheet(sheetObjects[1],document.form,IBDOWNEXCEL);
					} else{
						doActionIBSheet(sheetObjects[2],document.form,IBDOWNEXCEL);
					}
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

	/**
	 * registering IBSheet Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 * @param sheet_obj IBSheet Object
	 */
	function setSheetObject(sheet_obj){
	   sheetObjects[sheetCnt++]=sheet_obj;
	}
	 /**
	  * 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
	  *
	  * @param {IBMultiCombo}
	  *            combo_obj IBMultiCombo Object
	  */
	 function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj;
	 }
	 /**
	  * registering IBTab Object as list
	  * adding process for list in case of needing batch processing with other items
	  * defining list on the top of source
	  * @param tab_obj
	  */
	 function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	 }
	 /**
	  * Tab option
	  * setting tab list
	  * @param tabObj
	  * @param tabNo
	  */
	 function initTab(tabObj , tabNo) {
		  switch(tabNo) {
			  case 1:
				 with (tabObj) {
					 var cnt=0 ;
					 InsertItem( "B/L Info" , "");
					 InsertItem( "CNTR Info" , "");
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
			ComConfigSheet(sheetObjects[i]);
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}

		for(k=0;k<tabObjects.length;k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}

		initControl();
	}
	 /**
	  * 조회조건 입력할 때 처리
	  */
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
	 /**
	  * HTML Control on the page  loaded dynamically  the event. <br>
	  * {@ link # loadPage} function this function  call initializes the IBSheet Object. <br>
	  *
	  * @param {ibsheet}
	  *            sheetObj IBSheet Object
	  * @param {int}
	  *            sheetNo sheetObjects array  sequence number
	  */
	function initControl() {
		DATE_SEPARATOR="-";
		var formObject=document.form;
		axon_event.addListenerFormat('keypress', 'obj_KeyPress', formObject); //- 키보드 입력할때
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
		axon_event.addListenerForm("KeyUp", "obj_KeyUp", document.form);
		axon_event.addListenerForm("click", "obj_Clicked", document.form);
		axon_event.addListenerForm("change", "obj_OnChange", document.form);
	}
	 /**
	  * setting sheet initial values and header
	  * @param sheetObj
	  * @param sheetNo
	  * @return
	  */
	function initSheet(sheetObj,sheetNo) {
		var sheetID=sheetObj.id;
		switch(sheetID) {
			case "sheet1":      //sheet1 init
				with(sheetObj){
				  var cnt=0;
				  var HeadTitle1="|Seq.|Trunk|Feeder|POL|POD|ETA|Sub B/L Total";
				  var headCount=ComCountHeadTitle(HeadTitle1);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
						 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"trnk_vvd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:0,   SaveName:"feeder",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"eta_dt",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"subtotal",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);
				  SetEditable(0);
				  SetSheetHeight(250);
				}
				break;
			case "sheet2":      //sheet3 init
				with(sheetObj){
				  var cnt=0;
				  var HeadTitle1="|Seq.|Sel.|BOOKING|CNTR|CNTR|POR|POL|POD|Final Dest.|Shipper|Shipper|F/Forwarder|CNEE|CNEE|Notify|Notify|Mark & Nos.|C/M|C/M|C/M|C/M|C/M|C/M|Desc. of Goods";
				  var HeadTitle2="|Seq.|Sel.|BKG NO|Number|T/S|POR|POL|POD|Final Dest.|Name|Address|F/Forwarder|Name|Address|Name|Address|Mark & Nos.|PKG|PKG|WGT|WGT|MEA|MEA|Desc. of Goods";
				  var headCount=ComCountHeadTitle(HeadTitle1);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"},
							  { Text:HeadTitle2, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"chk" },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"del_nod_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"sh_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"sh_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"fw_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cn_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"cn_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"no_cust_nm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"no_cust_addr",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:120,  Align:"Left",    ColMerge:1,   SaveName:"mk_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"pck_qty",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pck_tp_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_mf_wgt",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"meas_qty",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"meas_ut_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"cmdt_desc",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);
				  SetEditable(0);
				  SetSheetHeight(250);
				}
				break;
			case "sheet3":
				with(sheetObj){
				  var cnt=0;
				  var HeadTitle1="|Seq.||CNTR No.|Type|Size|T/S|Status|POL|CONSIGNEE|GW(KGS)|GW(KGS)|RF|DG|Temperature|IMDG Class|UN No.|Position";
				  var headCount=ComCountHeadTitle(HeadTitle1);

				  SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:3, DataRowMerge:1 } );

				  var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);

				  var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
						 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq" },
						 {Type:"Text",      Hidden:1, Width:130,  Align:"Center",  ColMerge:1,   SaveName:"bkg_no",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"tp_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_rmk",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"cntr_tpsz_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"status",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:130,  Align:"Center",  ColMerge:1,   SaveName:"consignee",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Float",     Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"cntr_wgt",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"wgt_ut_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rc_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dcgo_flg",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"cdo_temp",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"imdg_clss_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"imdg_un_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"Positon",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];

				  InitColumns(cols);
				  SetEditable(0);
				  SetSheetHeight(250);
				}
				break;
		}
	}
	/**
	 * handling sheet process
	 * @param sheetObj
	 * @param formObj
	 * @param sAction
	 */
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObjects[0].RemoveAll();
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value=SEARCH;

				var sXml=sheetObj.GetSearchData("ESM_BKG_1147GS.do", FormQueryString(formObj));//*****
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[0].LoadSearchData(arrXml[0],{Sync:1} );
				}
				break;

			case SEARCH01:      //Retrieve
				if(!validateForm(sheetObj,formObj,sAction)) return;
				sheetObjects[1].RemoveAll();
				sheetObjects[2].RemoveAll();
				formObj.f_cmd.value=SEARCH01;

				var sXml=sheetObj.GetSearchData("ESM_BKG_1147GS.do", FormQueryString(formObj));//*****
				var arrXml=sXml.split("|$$|");
				if (arrXml.length > 0) {
					sheetObjects[1].LoadSearchData(arrXml[0],{Sync:1} );
					sheetObjects[2].LoadSearchData(arrXml[1],{Sync:1} );
				}
				break;

			case IBDOWNEXCEL:
				if(!validateForm(sheetObj,formObj,sAction)) return;

				sheetObj.Down2Excel({DownCols:makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
				break;
		}
	}
	/**
	 * 화면 폼입력값에 대한 유효성검증 프로세스 처리
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if(!ComChkRequired(formObj)) return false;
				break;
			case IBDOWNEXCEL:
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("BKG00889"); //No data found
					return false;
				}
				break;
		}
		return true;
	}
	/**
	 * 조회완료후 이벤트
	 */
	function sheet2_OnSearchEnd(sheetObj, ErrMsg) {
		document.form.tot_bl_cnt.value=sheetObj.RowCount();
//    	for( var idx=0; idx<document.form.s_mode.length; idx++)	{
//    		if( document.form.s_mode[idx].checked == true ){
//    			for( var jdx = 0+parseInt(sheetObj.HeaderRows); jdx < sheetObj.RowCount+parseInt(sheetObj.HeaderRows); jdx++ ){
//    	    		sheetObj.CellValue2(jdx,"e_i_ind") = document.form.s_mode[idx].value;
//    	    		sheetObj.CellValue2(jdx,"input_pol_cd") = document.form.s_pol_cd.value;
//    	    		sheetObj.CellValue2(jdx,"input_pod_cd") = document.form.s_pod_cd.value;
//    	    		sheetObj.CellValue2(jdx,"bl_knt") = document.form.bl_tot_cnt.value;
//    	    		sheetObj.CellValue2(jdx,"ts_tp_cd")= document.form.ts_tp_cd.value;
//    	    	}
//    		}
//		}
	}
	/**
	 * 조회완료후 이벤트
	 */
	function sheet3_OnSearchEnd(sheetObj, ErrMsg) {
		document.form.tot_cntr_cnt.value=sheetObj.RowCount();

	}
	/**
	 * Booking Creation 화면 이동
	 * @param sheetObj Sheet
	 * @param Row Row Index
	 * @param Col Col Index
	 */
	function sheet1_OnDblClick(sheetObj, Row, Col) {
		document.form.pol_cd.value=sheetObjects[0].GetCellValue(Row,"pol_cd")
		document.form.pod_cd.value=sheetObjects[0].GetCellValue(Row,"pod_cd")
		document.form.trnk_vvd.value=sheetObjects[0].GetCellValue(Row,"trnk_vvd")
		doActionIBSheet(sheetObjects[1],document.form,SEARCH01);
	}

	/**
	 * event in case of clicking tab
	 * activating selected tab
	 * @param tabObj
	 * @param nItem
	 */
	function tab1_OnChange(tabObj, nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1;
		beforetab=nItem;
	}
