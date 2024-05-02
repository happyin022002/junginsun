/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0234.js
*@FileTitle  : Philippines
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================
*/

/****************************************************************************************
  Event classify code: [initialization]INIT=0; [input]ADD=1; [Retrieve]SEARCH=2; [List Retrieve]SEARCHLIST=3;
[modify]MODIFY=4; [remove]REMOVE=5; [list remove]REMOVELIST=6 [multiprocessing]MULTI=7
character constant  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-0234 : business script for ESM_BKG-0234
 */
	function esm_bkg_0234() {
		this.processButtonClick=tprocessButtonClick;
		this.setSheetObject=setSheetObject;
		this.loadPage=loadPage;
		this.initSheet=initSheet;
		this.initControl=initControl;
		this.doActionIBSheet=doActionIBSheet;
		this.setTabObject=setTabObject;
		this.validateForm=validateForm;
	}
	/* developer job	*/
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	// Event handler processing by button click event
	document.onclick=processButtonClick;
	// Event handler processing by button name
	function processButtonClick(){
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;

		try {
			var srcName=ComGetEvent("name");
			 switch(srcName) {
				case "btn_retrieve":
					if ( beforetab == 0 ) {	  // tab1
						doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
					} else if ( beforetab == 1 ) {	//tab2
						doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
					} else if ( beforetab == 2 ) {	//tab3
						doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
					} else if ( beforetab == 3 ) {	//tab4
						doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
					} else if ( beforetab == 4 ) {	//tab5
						doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
					}
				break;

				case "btn_new":
					ComResetAll();
				break;

				case "btn_downexcel":
					if ( beforetab == 0 ) {	  //tab1
						if(sheetObjects[0].RowCount() < 1){//no data
							 ComShowCodeMessage("COM132501");
							} else{
								doActionIBSheet(sheetObjects[0],formObject,IBDOWNEXCEL);
							}
					} else if ( beforetab == 1 ) {	//tab2
						if(sheetObjects[1].RowCount() < 1){//no data
							 ComShowCodeMessage("COM132501");
							} else{
								doActionIBSheet(sheetObjects[1],formObject,IBDOWNEXCEL);
							}
					} else if ( beforetab == 2 ) {	// tab3
						if(sheetObjects[2].RowCount() < 1){//no data
							 ComShowCodeMessage("COM132501");
							} else{
								doActionIBSheet(sheetObjects[2],formObject,IBDOWNEXCEL);
							}
					} else if ( beforetab == 3 ) {	// tab4
						if(sheetObjects[3].RowCount() < 1){//no data
							 ComShowCodeMessage("COM132501");
							} else{
								doActionIBSheet(sheetObjects[3],formObject,IBDOWNEXCEL);
							}
					} else if ( beforetab == 4 ) {	// tab5
						if(sheetObjects[4].RowCount() < 1){//no data
							 ComShowCodeMessage("COM132501");
							} else{
								doActionIBSheet(sheetObjects[4],formObject,IBDOWNEXCEL);
							}
					}
				break;

				case "btn_calendar":
					if (window.event.srcElement.disabled) return;
					var cal = new ComCalendarFromTo();
					cal.select(formObject.date_fm, formObject.date_to, "yyyy-MM-dd");
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
	 * registering IBSheet Object as list adding process for list in case of needing batch processing with other items
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
		 for(k=0;k<tabObjects.length;k++){
			 initTab(tabObjects[k],k+1);
		 }
		 //initControl();
		var formObj=document.form;
		// axon_event.addListenerForm("KeyUp","obj_KeyUp", formObj);
		// axon_event.addListenerFormat("KeyPress","obj_KeyPress", formObj);
		axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	 }
	 /**
	  * input event
	  */
//	 function obj_KeyUp() {
//	 	var formObject=document.form;
//	 	var srcMaxLength=window.event.srcElement.getAttribute("maxlength");
//	 	var srcValue=window.event.srcElement.getAttribute("value");
//	 	var srcName=ComGetEvent("name");
//	 	if ( (  srcName == "vvd_cd" || srcName == "pol_cd" || srcName == "pod_cd" ) && ComChkLen(srcValue, srcMaxLength) == "2" ) {
//	 		ComSetNextFocus();
//	 	}
//	 }
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
						var HeadTitle1 ="|Seq.|Registry Number|Date of Arrival|Vessel Name & Voyage Number|Last Port of Origin|Port of Discharge|Gross Tonnage|Net Tonnage|Marker" +
										// Hidden Columne
										"|etl_desc";
						var headCount=ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						var cols = [{Type:"Status", Hidden:1,  Width:40,   Align:"Center",  SaveName:"ibflag",     Edit:1 },
									{Type:"Text",   Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq",        Edit:1 },
									{Type:"Text",   Hidden:0,  Width:170,  Align:"Center",  SaveName:"reg_number", Edit:0 },
									{Type:"Date",   Hidden:0,  Width:165,  Align:"Center",  SaveName:"etadt",      Edit:0,    Format:"Ymd" },
									{Type:"Text",   Hidden:0,  Width:215,  Align:"Center",  SaveName:"vname",      Edit:0,    EditLen:30 },
									{Type:"Text",   Hidden:0,  Width:165,  Align:"Center",  SaveName:"polcd",      Edit:0 },
									{Type:"Combo",  Hidden:0,  Width:170,  Align:"Center",  SaveName:"discharge",  Edit:1 },
									{Type:"Text",   Hidden:0,  Width:150,  Align:"Center",  SaveName:"g_tong_wgt", Edit:0 },
									{Type:"Text",   Hidden:0,  Width:150,  Align:"Center",  SaveName:"n_tong_wgt", Edit:0 },
									{Type:"Text",   Hidden:0,  Width:60,   Align:"Center",  SaveName:"Marker",     Edit:0,    CalcLogic:"0" },
									{Type:"Text",   Hidden:1,  Width:30,   Align:"Center",  SaveName:"etl_desc",   Edit:0 } ];
						InitColumns(cols);
						SetEditable(1);
						SetColProperty("discharge", {ComboText:"|North Harbour|South Harbour|Harbour Centre Port Terminal Inc|Port of Batangas|Sub-Port of Bauan|Port of Cebu|Port of Cagayan de Oro|Port of Davao|Port of Subic", ComboCode:"0|1|2|3|4|5|6|7|8|9"} );
						SetShowButtonImage(4);
						SetSheetHeight(450);
					}
				 break;

			 case "t2sheet1":      //t2sheet1 init
					with(sheetObj){
						var HeadTitle1 ="|Seq.|Year|Registry No.|B/L Number|Cargo Type|Cargo Type|Shipper Name 1|Shipper Name 2|Shipper Address 1|Shipper Address 2|Shipper Address 3|Shipper Address 4" +
										"|Consignee Name 1|Consignee Name 2|Consignee Address 1|Consignee Address 2|Consignee Address 3|Consignee Address 4" +
										"|Notify Name 1|Notify Name 2|Notify Address 1|Notify Address 2|Notify Address 3|Notify Address 4|Total No. of CNTR|Weight|Volume|Country Origin|POD|Marker";
						var headCount=ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						var cols = [{Type:"Status", Hidden:1,  Width:40,   Align:"Center",  SaveName:"ibflag",              Edit:1 },
									{Type:"Text",   Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq",                 Edit:1 },
									{Type:"Text",   Hidden:0,  Width:40,   Align:"Center",  SaveName:"year",                Edit:0,   EditLen:1 },
									{Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  SaveName:"reg_number2",         Edit:0 },
									{Type:"Text",   Hidden:0,  Width:115,  Align:"Center",  SaveName:"bl_no",               Edit:0 },
									{Type:"Combo",  Hidden:0,  Width:80,   Align:"Center",  SaveName:"cargo_type",          Edit:1 },
									{Type:"Text",   Hidden:1,  Width:30,   Align:"Center",  SaveName:"etl_cargo_type",      Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_name1",       Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_name2",       Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_address1",    Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_address2",    Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_address3",    Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"shipper_address4",    Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"consignee_name1",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"consignee_name2",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:130,  Align:"Left",    SaveName:"consignee_address1",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:130,  Align:"Left",    SaveName:"consignee_address2",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:130,  Align:"Left",    SaveName:"consignee_address3",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:130,  Align:"Left",    SaveName:"consignee_address4",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_name1",        Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_name2",        Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_address1",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_address2",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_address3",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Left",    SaveName:"notify_address4",     Edit:0 },
									{Type:"Text",   Hidden:0,  Width:120,  Align:"Center",  SaveName:"total_cntr",          Edit:0 },
									{Type:"Float",  Hidden:0,  Width:80,   Align:"Right",   SaveName:"weight",              Edit:0,   Format:"###,###,##0.00" },
									{Type:"Float",  Hidden:0,  Width:80,   Align:"Right",   SaveName:"volume",              Edit:0,   Format:"###,###,##0.000" },
									{Type:"Text",   Hidden:0,  Width:100,  Align:"Center",  SaveName:"country_origin",      Edit:0 },
									{Type:"Text",   Hidden:0,  Width:70,   Align:"Center",  SaveName:"pod",                 Edit:0 },
									{Type:"Text",   Hidden:0,  Width:70,   Align:"Center",  SaveName:"Marker2",             Edit:0,   CalcLogic:"0" } ];
						InitColumns(cols);

						SetEditable(1);
						SetColProperty("cargo_type", {ComboText:"FCL|LCL|BULK|EMT", ComboCode:"FCL|LCL|BULK|EMT"} );
						SetShowButtonImage(4);
						SetSheetHeight(450);
					}
				 break;

			 case "t3sheet1":      //t3sheet1 init
					with(sheetObj){
						var HeadTitle1 = "|Seq.|Registry No.|B/L Number|Container Number|Type / Size|Container Seal Number|Container Seal Number|Container Seal Number|Delivery Type|Marker";
						var headCount = ComCountHeadTitle(HeadTitle1);
						SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
						var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
						var headers = [ { Text:HeadTitle1, Align:"Center"} ];
						InitHeaders(headers, info);
						var cols = [{Type:"Status", Hidden:1,  Width:40,   Align:"Center",  SaveName:"ibflag",         Edit:1 },
									{Type:"Text",   Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq",            Edit:1 },
									{Type:"Text",   Hidden:0,  Width:110,  Align:"Center",  SaveName:"reg_number3",    Edit:0 },
									{Type:"Text",   Hidden:0,  Width:150,  Align:"Center",  SaveName:"bl_no2",         Edit:0 },
									{Type:"Text",   Hidden:0,  Width:165,  Align:"Center",  SaveName:"container_no",   Edit:0,   EditLen:30 },
									{Type:"Text",   Hidden:0,  Width:100,  Align:"Center",  SaveName:"type_size",      Edit:0 },
									{Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  SaveName:"cntr_seal_no1",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  SaveName:"cntr_seal_no2",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:80,   Align:"Center",  SaveName:"cntr_seal_no3",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:130,  Align:"Center",  SaveName:"delivery_type",  Edit:0 },
									{Type:"Text",   Hidden:0,  Width:60,   Align:"Center",  SaveName:"Marker",         Edit:0,   CalcLogic:"0" } ];
						InitColumns(cols);
						SetSheetHeight(450);
						SetEditable(1);
					}
				 break;

			 case "t4sheet1":      //t4sheet1 init
					with(sheetObj){
					   var HeadTitle1="|Seq.|Seq.2|Registry No.|B/L Number|Package Type|No. of Package|Description & Goods|Marker";
					   var headCount=ComCountHeadTitle(HeadTitle1);
					   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					   InitHeaders(headers, info);
					   var cols = [ {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  SaveName:"ibflag",        Edit:1 },
									{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq",           Edit:1 },
									{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq2",          Edit:1 },
									{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  SaveName:"reg_number4",   Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  SaveName:"bl_no3",        Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:110,  Align:"Center",  SaveName:"package_type",  Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  SaveName:"pck_qty",       Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:250,  Align:"Left",    SaveName:"desc_good",     Edit:1 },
									{Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  SaveName:"mark",          Edit:0,   EditLen:false } ];
					   InitColumns(cols);
					   SetEditable(1);
					   SetSheetHeight(450);
					 }
				 break;

			 case "t5sheet1":      //t5sheet1 init
					with(sheetObj){
					   var HeadTitle1="|Seq.|Registry No.|B/L Number|Marks & Numbers|Marker";
					   var headCount=ComCountHeadTitle(HeadTitle1);
					   (headCount, 0, 0, true);
					   SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
					   var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
					   var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					   InitHeaders(headers, info);
					   var cols = [ {Type:"Status",    Hidden:1,  Width:40,   Align:"Center",  SaveName:"ibflag",       Edit:1 },
									{Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  SaveName:"seq",          Edit:1 },
									{Type:"Text",      Hidden:0,  Width:220,  Align:"Center",  SaveName:"reg_number5",  Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:250,  Align:"Center",  SaveName:"bl_no4",       Edit:0,   EditLen:false },
									{Type:"Text",      Hidden:0,  Width:300,  Align:"Left",    SaveName:"desc_good2",   Edit:1 },
									{Type:"Text",      Hidden:0,  Width:160,  Align:"Center",  SaveName:"mark2",        Edit:0,   EditLen:false } ];
					   InitColumns(cols);
					   SetEditable(1);
					   SetSheetHeight(450);
					 }
				 break;
		 }
	 }
	//handling of Sheet process
	 function doActionIBSheet(sheetObj,formObj,sAction) {
		 sheetObj.ShowDebugMsg(false);
		 switch(sAction) {
			case IBSEARCH:      // retrieve
				if(validateForm(sheetObj,formObj,sAction))
				{
						formObj.f_cmd.value=SEARCH;
						status=sheetObj.GetEtcData('status');
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						formObj.sheetgubun.value=sheetObj.id;
						formObj.vsl_cd.value=formObj.vvd_cd.value.substring(0,4);
						formObj.skd_voy_no.value=formObj.vvd_cd.value.substring(4,8);
						formObj.skd_dir_cd.value=formObj.vvd_cd.value.substring(8);
						var sXml=sheetObj.GetSearchData("ESM_BKG_0234GS.do", FormQueryString(formObj));
						sheetObj.LoadSearchData(sXml,{Sync:1} );
						ComEtcDataToForm(formObj, sheetObj);
						sheetObj.SetEtcData("vvd",formObj.vvd_cd.value);
						ComOpenWait(false);
				}
				break;

			case IBDOWNEXCEL:      // excel download
				ComOpenWait(true);
				var sHeetName="";
			   if(beforetab == 0)
				   sHeetName="sheet1_";
			   if(beforetab == 1)
				   sHeetName="sheet2_";
			   if(beforetab == 2)
				   sHeetName="sheet3_";
			   if(beforetab == 3) {
				   sHeetName="sheet4_";
			   }
			   if(beforetab == 4)
				   sHeetName="sheet5_";
			   formObj.sheetgubun.value=sHeetName;
			   formObj.f_cmd.value=MULTI01;
			   var sParam="";
			   for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow();i++){
				   if(sheetObj.GetRowStatus(i) != "U") continue;
					if(sHeetName == "sheet1_"){
						sParam=sParam + "ibflag=" + sheetObj.GetCellValue(i,"ibflag");
						sParam=sParam + "&seq=" + sheetObj.GetCellValue(i,"seq");
						sParam=sParam + "&discharge=" + sheetObj.GetCellValue(i,"discharge");
					}
					else if(sHeetName == "sheet2_"){
						sParam=sParam + "ibflag=" + sheetObj.GetCellValue(i,"ibflag");
						sParam=sParam + "&seq=" + sheetObj.GetCellValue(i,"seq");
						sParam=sParam + "&pod=" + sheetObj.GetCellValue(i,"pod");
						sParam=sParam + "&cargo_type=" + sheetObj.GetCellValue(i,"cargo_type");
					}
					else if(sHeetName == "sheet4_"){
						sParam=sParam + "ibflag=" + sheetObj.GetCellValue(i,"ibflag");
						sParam=sParam + "&seq=" + sheetObj.GetCellValue(i,"seq");
						sParam=sParam + "&seq2=" + sheetObj.GetCellValue(i,"seq2");
						sParam=sParam + "&desc_good=" + sheetObj.GetCellValue(i,"desc_good");
					}
					else if(sHeetName == "sheet5_"){
						sParam=sParam + "ibflag=" + sheetObj.GetCellValue(i,"ibflag");
						sParam=sParam + "&seq=" + sheetObj.GetCellValue(i,"seq");
						sParam=sParam + "&desc_good2=" + sheetObj.GetCellValue(i,"desc_good2");
					}
					sParam=sParam + ";"
				}
				formObj.sheetdata.value=sParam;
				formObj.target="download";
				formObj.action="ESM_BKG_0234GS_1.do";
				formObj.submit();

				ComOpenWait(false);
			 break;
		 }
	 }
	 /**
	  * after file create
	  */
	 function CloseWait(){
		 ComOpenWait(false);
	 }
	  /**
	   * register Tab Object to tabObjects array
	   */
	 function setTabObject(tab_obj){
		 tabObjects[tabCnt++]=tab_obj;
	 }
	  /**
	   * setting hidden value
	   */
	 function setFormSheet4(sheetObj) {
		 var reg_number4="";
		 var bl_no3="";
		 var package_type="";
		 var pck_qty="";
		 var desc_good="";
		 var mark="";
		 for(var i=sheetObj.HeaderRows(); i <= sheetObj.LastRow();i++){
			 reg_number4=reg_number4 + sheetObj.GetCellValue(i, "reg_number4") + "|";
			 bl_no3=sheetObj.GetCellValue(i, "bl_no3") + "|";
			 package_type=sheetObj.GetCellValue(i, "package_type") + "|";
			 pck_qty=sheetObj.GetCellValue(i, "pck_qty") + "|";
			 desc_good=sheetObj.GetCellValue(i, "desc_good") + "|";
			 mark=sheetObj.GetCellValue(i, "mark") + "|";
			}
		 document.form.reg_number4.value=reg_number4;
		 document.form.bl_no3.value=bl_no3;
		 document.form.package_type.value=package_type;
		 document.form.pck_qty.value=pck_qty;
		 document.form.desc_good.value=desc_good;
		 document.form.mark.value=mark;
	 }
	 /**
	  * setting Tab value
	  */
	 function initTab(tabObj , tabNo) {
		  switch(tabNo) {
			  case 1:
				 with (tabObj) {
					 var cnt=0 ;
					 InsertItem( "File 1" , "");
					 InsertItem( "File 2" , "");
					 InsertItem( "File 3" , "");
					 InsertItem( "File 4" , "");
					 InsertItem( "File 5" , "");
				 }
			  break;
		  }
		  tabObj.SetSelectedIndex(0);
	 }
	 /**
	  * Tab 클릭시 이벤트 관련
	  * 선택한 탭의 요소가 활성화 된다.
	  */
	 function tab1_OnChange(tabObj , nItem)
	 {
		 formObject = document.form;
		 var objs=document.all.item("tabLayer");
		 objs[nItem].style.display="Inline";
		 for(var i = 0; i< objs.length; i++){
			  if(i != nItem){
				   objs[i].style.display="none";
				   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
		}
		beforetab=nItem;
	 }
	 /**
	  * Tab click event
	  */
	 function tab1_OnClick(tabObj)
	 {
		var formObject=document.form;
		if(formObject.vvd_cd.value == "" || formObject.reg_no.value == "") return;
		if ( beforetab == 0 ) {	  //tab1
			if(sheetObjects[0].GetEtcData("vvd") != formObject.vvd_cd.value || sheetObjects[0].RowCount()== 0)
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
		} else if ( beforetab == 1 ) {	//tab2
			if(sheetObjects[1].GetEtcData("vvd") != formObject.vvd_cd.value || sheetObjects[1].RowCount()== 0)
				doActionIBSheet(sheetObjects[1],formObject,IBSEARCH);
		} else if ( beforetab == 2 ) {	//tab3
			if(sheetObjects[2].GetEtcData("vvd") != formObject.vvd_cd.value || sheetObjects[2].RowCount()== 0)
				doActionIBSheet(sheetObjects[2],formObject,IBSEARCH);
		} else if ( beforetab == 3 ) {	//tab4
			if(sheetObjects[3].GetEtcData("vvd") != formObject.vvd_cd.value || sheetObjects[3].RowCount()== 0)
				doActionIBSheet(sheetObjects[3],formObject,IBSEARCH);
		} else if ( beforetab == 4 ) {	//tab5
			if(sheetObjects[4].GetEtcData("vvd") != formObject.vvd_cd.value || sheetObjects[4].RowCount()== 0)
				doActionIBSheet(sheetObjects[4],formObject,IBSEARCH);
		}
	 }
	 /**
	  * t1sheet1 change event
	  */
	  function t1sheet1_OnChange(sheetObj, Row, Col, Value){
		var formObject=document.form;
		if (sheetObj.ColSaveName(Col) == "Discharge"){
			sheetObj.SetCellValue(Row, Col+1,Value,0);
		}
	  }
	  /**
	   * t2sheet1 sheet data change event
	   */
	  function t2sheet1_OnChange(sheetObj, Row, Col, Value){
			var formObject=document.form;
			if (sheetObj.ColSaveName(Col) == "cargo_type"){
				sheetObj.SetCellValue(Row, Col+1,Value,0);
			}
	  }
	/**
	* handling process for input validation
	*/
	 function validateForm(sheetObj,formObj,sAction){
		  switch (sAction) {
			case IBSEARCH: // retrieve
			if (formObj.vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00161');
				formObj.vvd_cd.focus();
				return false;
			}
			if (formObj.reg_no.value.length =="") {
				ComShowCodeMessage('BKG00162');
				formObj.reg_no.focus();
				return false;
			}
			if (formObj.reg_no.value.length < 5) {
				ComShowCodeMessage('BKG00162');
				formObj.reg_no.focus();
				return false;
			}
			if (formObj.vvd_cd.value.length != 9) {
				ComShowCodeMessage('BKG00161');
				formObj.vvd_cd.focus();
				return false;
			}
			if (formObj.pol_cd.value.length < 5) {
				formObj.pol_cd.value="";
			}
			if (formObj.pod_cd.value.length < 5) {
				formObj.pod_cd.value="";
			}
			return true;
			break;
		  }
	 }
