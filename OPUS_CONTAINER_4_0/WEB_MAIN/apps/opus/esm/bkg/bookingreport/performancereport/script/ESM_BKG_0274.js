/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : esm_bkg_0274.js
*@FileTitle : O/B & T/S Loading Report by Location
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
	MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
	 OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/

	 /**
	  * registering IBSheet Object as list
	  * adding process for list in case of needing batch processing with other items
	  * defining list on the top of source
	  */
 function setSheetObject(sheet_obj){
	sheetObjects[sheetCnt++]=sheet_obj;
 }

 var sheetObjects=new Array();
 var sheetCnt=0;
 var rowsPerPage=50;
 var prefix="";//IBSheet separator
 var grp_cd="";//for Current Queue retrieving
 var queueMap=new Array();
  /*********************** EDTITABLE MULIT COMBO START ********************/
	var comboCnt=0;
	var comboObjects=new Array();
	/**
	 * registering IBCombo Object as list
	 * adding process for list in case of needing batch processing with other items
	 * defining list on the top of source
	 */
	function setComboObject(combo_obj){
		comboObjects[comboCnt++]=combo_obj;
	}
/*********************** EDTITABLE MULIT COMBO END********************/

	/**
	 * initializing sheet
	 * implementing onLoad event handler in body tag
	 * adding first-served functions after loading screen
	 */
	function loadPage() {
		for(i=0;i<sheetObjects.length;i++){
					ComConfigSheet (sheetObjects[i] );
					initSheet(sheetObjects[i],i+1);
					ComEndConfigSheet(sheetObjects[i]);
			}
			  //initialize MultiCombo
			for(var k=0;k<comboObjects.length;k++){
				initCombo(comboObjects[k],comboObjects[k].options.id);
			}
			initControl();
	}

	/**
	 * setting combo initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting combos
	 */
	function initCombo(comboObj, comboId) {
		var formObject=document.form
			initComboEditable(comboObj, comboId)
	}

	//setting multi select in combo and editable or not
	function initComboEditable(combo, comboId){
		with (combo) {
			if(comboId == "order_by" ){
				//alert(comboId);
				SetMultiSelect(1);
				SetUseAutoComplete(1);
				SetUseEdit(0);
				SetDropHeight(150);
			} else{
				SetDropHeight(150);
				SetMultiSelect(0);
				SetUseEdit(0);
			}
		}
	}
	function initControl() {
		var formObject=document.form;
		axon_event.addListenerFormat('keypress','bkg_keypress',formObject);
		axon_event.addListenerFormat  ('beforedeactivate', 'bkg_deactivate',  formObject); //- focus in
		axon_event.addListenerFormat('beforeactivate', 'bkg_activate',    formObject); //- focus out
		axon_event.addListener ('keydown', 'ComKeyEnter', 'form');
	}
 /*********************** KEY EVENT START ********************/
	function bkg_keypress(){
		switch(event.srcElement.dataformat){
			case "ymd":
			//number
			ComKeyOnlyNumber(event.srcElement, "-");
			break;
			case "engup":
				ComKeyOnlyAlphabet('upper');
			break;
		  case "engupnum":
			ComKeyOnlyAlphabet('uppernum');
			break;
		  case "num":
			ComKeyOnlyNumber(event.srcElement);
			break;
		  case "custname":
			ComKeyOnlyAlphabet('uppernum','40|41|46|44|32|42|38|35|45');
			break;
		  default:
		}
	}
	/**
	 * handler onBlur of HTML Control
	 **/
	function bkg_deactivate() {
		var formObj=document.form;
		switch (ComGetEvent("name")) {
			case "dura_from_dt":
				ComAddSeparator(event.srcElement);
					break;
			case "dura_to_dt":
				ComAddSeparator(event.srcElement);
					break;
				default:
					break;
		}
	}
	/**
	 * checking validation at onFocus of HTML Control
	 **/
	function bkg_activate(){
		switch(event.srcElement.name){
			case "dura_from_dt":
				ComClearSeparator(event.srcElement);
				break;
			case "dura_to_dt":
				ComClearSeparator(event.srcElement);
				break;
			default:
				break;
		}
	}
/*********************** KEY EVENT END ********************/
// Event handler processing by button click event  */
		document.onclick=processButtonClick;
 // Event handler processing by button name */
	 function processButtonClick(){
		  var sheetObject1=sheetObjects[0];
		  var comboObject1=comboObjects[0];
		  var formObject=document.form;
			try {
				var srcName=ComGetEvent("name");
					switch(srcName) {
						case "btn_Retrieve":
							//sheetObject1.DoSearch("apps/opus/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html");
							doActionIBSheet(sheetObject1,formObject,IBSEARCH);
							break;

						case "btn_New":
							initAll(formObject);
							break;

						case "btn_DownExcel":
							doActionIBSheet(sheetObject1,formObject,IBDOWNEXCEL);
							break;

						case "btn_Print":
							if(getCheckedRowByName(sheetObject1,"check","bkg_no") == null){
								ComShowCodeMessage("COM12189");
								return;
							}
							//ComOpenPopup("/opuscntr/ESM_BKG_0064.do", 300, 200, "", "1,0,1,1,1,1,1,1,1,1", false,false, 0, 0, 0,"print_option");
							var form3 = document.form3;
							form3.mode_type.value = getRadioValue2(formObject.mode_type);
							form3.vvd_cd.value = formObject.vvd_cd.value;
							form3.pol_cd.value = formObject.pol_cd.value;
							form3.pod_cd.value = formObject.pod_cd.value;
							form3.cargo_type.value = getRadioValue2(formObject.cargo_type);
							ComOpenWindowCenter2("ESM_BKG_0064.do?" + FormQueryString(form3), "EsmBkg0064", 750, 200, false, "scrollbars=no,resizable=no,status=yes");
							break;

						case "btn_Sort":
							ComOpenWindowCenter2("/opuscntr/ESM_BKG_0161.do?codeGubun=CD02377&isPop=Y", "OrderBy", 400, 230, false, "scrollbars=no,resizable=yes");
							break;

						case "btn_check_all":
							sheetObject1.CheckAll("check", 1);
							break;

						case "btn_uncheck_all":
							sheetObject1.CheckAll("check", 0);
							break;

						case "mode_type":
							if(form.mode_type[0].checked){
								form.pol_cd.className="input1";
								form.pod_cd.className="input";
								for(var i=0;i < div_pre_post.length;i++) {
									div_pre_post[i].innerHTML="Pre";
								}
							} else if(form.mode_type[1].checked) {
								form.pol_cd.className="input";
								form.pod_cd.className="input1";
								for(var i=0;i < div_pre_post.length;i++){
									div_pre_post[i].innerHTML="Post";
								}
							}
							break;

						case "cargo_route":
							if(form.cargo_route[1].checked){
								form.fdr_vvd_cd.value="";
								form.fdr_pol_cd.value="";
								form.fdr_pol_yd_cd.value="";
								form.fdr_pod_cd.value="";
								form.fdr_pod_yd_cd.value="";
								form.fdr_vvd_cd.disabled=true;
								form.fdr_pol_cd.disabled=true;
								form.fdr_pol_yd_cd.disabled=true;
								form.fdr_pod_cd.disabled=true;
								form.fdr_pod_yd_cd.disabled=true;
								form.fdr_vvd_cd.className="input2";
								form.fdr_pol_cd.className="input2";
								form.fdr_pol_yd_cd.className="input2";
								form.fdr_pod_cd.className="input2";
								form.fdr_pod_yd_cd.className="input2";
							} else {
								form.fdr_vvd_cd.disabled=false;
								form.fdr_pol_cd.disabled=false;
								form.fdr_pol_yd_cd.disabled=false;
								form.fdr_pod_cd.disabled=false;
								form.fdr_pod_yd_cd.disabled=false;
								form.fdr_vvd_cd.className="input";
								form.fdr_pol_cd.className="input";
								form.fdr_pol_yd_cd.className="input";
								form.fdr_pod_cd.className="input";
								form.fdr_pod_yd_cd.className="input";
							}
							break;
				} // end switch
			} catch(e) {
					if( e == "[object Error]") {
						ComShowMessage(OBJECT_ERROR);
					} else {
						ComShowMessage(e);
					}
			}
	}

	function initAll(formObj){
			formObj.reset();
	}
	/*
	* callback function of Shipper retrieving
	* */
	function setShipper(val){
		var c_cd=val[0][3];
		form.shipper_cd.value=c_cd;
//		var c_name = val[0][4];
//		form.cust_cnt_cd.value=c_cd.substring(0,2);
//		form.cust_seq.value=ComLpad(c_cd.substring(2),6,"0");
//		form.cust_nm.value=c_name;
	}

	/*
	 * setting sort from POP-UP
	 * */
	function setOrderBy(val){
		form.order_by.value=val.split(",");
		//debug.innerHTML = form.order_by.value;
	}


	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction,Row,Col,PageNo) {
		 sheetObj.ShowDebugMsg(false);
		 switch(sAction) {
			case IBSEARCH:
				if(form.order_by.value == "") form.order_by.value="POD_CD";
				//sheetObj.DoSearch("apps/opus/esm/bkg/bookingreport/performancereport/jsp/UI_BKG_0274_DATA.html");
				if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH;
				sheetObj.RemoveAll();
				sheetObj.SetWaitImageVisible(1);
				var sXml = sheetObj.GetSearchData("ESM_BKG_0274_1GS.do", FormQueryString(formObj));
				sheetObj.LoadSearchData(sXml,{Sync:1} );
				sheetObj.SetWaitImageVisible(0);
				changeHeader();
				//alert(ComGetEtcData(sXml, "total_40t"));
				if(ComGetEtcData(sXml, "hd_vvd_cd") == undefined){
					if(form.mode_type[0].checked){
						form.hd_vvd_cd.value=form.vvd_cd.value;
						hd_pol_pod.innerHTML="POL";
						form.hd_pol_pod_cd.value=form.pol_cd.value;
						hd_eta_etd.innerHTML="ETD";
						form.hd_eta_etd_cd.value="";
						form.hd_mode_type.value="Outbound";
					}else{
						form.hd_vvd_cd.value=form.vvd_cd.value;
						hd_pol_pod.innerHTML="POD";
						form.hd_pol_pod_cd.value=form.pod_cd.value;
						hd_eta_etd.innerHTML="ETA";
						form.hd_eta_etd_cd.value="";
						form.hd_mode_type.value="Inbound";
					}
					break;
				}
				form.hd_vvd_cd.value=ComGetEtcData(sXml, "hd_vvd_cd");
				hd_pol_pod.innerHTML=ComGetEtcData(sXml, "hd_pol_pod");
				form.hd_pol_pod_cd.value=ComGetEtcData(sXml, "hd_pol_pod_cd");
				hd_eta_etd.innerHTML=ComGetEtcData(sXml, "hd_eta_etd");
				form.hd_eta_etd_cd.value=ComGetEtcData(sXml, "hd_eta_etd_cd");
				form.hd_mode_type.value=ComGetEtcData(sXml, "hd_mode_type");
				sheetObj.InitCellProperty(1, "check", {Type: "Text"});
				sheetObj.SetCellValue(1,"check","");
				sheetObj.InitCellProperty(sheetObj.LastRow(), "check", {Type: "Text"});
				sheetObj.SetCellValue(sheetObj.LastRow(),"check","");
				break;

			case SEARCH01:      // List by Queue retrieve
				//if(!validateForm(sheetObj,formObj,sAction)) return;
				formObj.f_cmd.value=SEARCH01;
				sheetObj.SetWaitImageVisible(0);
				var sXml=sheetObj.GetSearchData("ESM_BKG_0274GS.do", FormQueryString(formObj));
				ComXml2ComboItem(sXml, formObj.order_by, "val", "desc");
//				list_by_Queue_xml = sXml;
				break;

			case IBDOWNEXCEL:   // excel download
				if(sheetObj.RowCount() < 1){
					ComShowCodeMessage("COM132501");
				} else {
					sheetObj.Down2Excel( {SheetDesign:1, Merge:1});
				}
				break;
			}
	}

	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				if ( ComIsNull(formObj.vvd_cd)) {
					ComShowCodeMessage('BKG00626','VVD');
					formObj.vvd_cd.focus();
					return false;
				} else if ( formObj.mode_type[0].checked && ComIsNull(formObj.pol_cd)) {
					ComShowCodeMessage('BKG00626','POL');
					formObj.pol_cd.focus();
					return false;
				} else if ( formObj.mode_type[1].checked && ComIsNull(formObj.pod_cd)) {
					ComShowCodeMessage('BKG00626','POD');
					formObj.pod_cd.focus();
					return false;
				}
				break;
		}
		return true;
	}

	function isNullEtcData(xmlStr) {
		var rtn=false;
		var xmlDoc=new ActiveXObject("Microsoft.XMLDOM" );
		xmlDoc.loadXML(xmlStr);
		var xmlRoot=xmlDoc.documentElement;
		if(xmlRoot == null) return true;
		var etcDataNode=xmlRoot.getElementsByTagName("ETC-DATA").item(0);
		if(etcDataNode == null) return true;
		var etcNodes=etcDataNode.childNodes;
		if(etcNodes == null) return true;
		if(etcNodes.length == 0) rtn=true;
		return rtn;
	}
		var cHeadTitle1="||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Pre VVD|Pre POL|Pre POL|Pre POD|Pre POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA";
		var cHeadTitle2="||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Post VVD|Post POL|Post POL|Post POD|Post POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA";
		/**
	 * setting sheet initial values and header according to Mode value
	 */
	function changeHeader(){
		 var titlearr = "";
		if(form.mode_type[0].checked){
			titlearr = cHeadTitle1.split("|");
		}else{
			titlearr = cHeadTitle2.split("|");
		}
		for(var i=0;i<titlearr.length;i++){
			sheet1.SetCellValue(0,i,titlearr[i]);
		}
	 }

	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		 var cnt=0;
		 switch(sheetObj.id) {
			case "sheet1":
				with (sheetObj) {
					var HeadTitle1="||BKG No.|B/L No.|POR|POL|POL|POD|POD|DEL|DEL|R/D|R/D|Pre VVD|Pre POL|Pre POL|Pre POD|Pre POD|L/T|E/F|PKG|PKG|WGT|WGT|S/O No. |REP |A/S |DG |RF |AW |BB |BDR |CA| GROUP_POL_POD";
					var headCount=ComCountHeadTitle(HeadTitle1);

					SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:2, DataRowMerge:0 } );

					var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					//var cols = [ {Type:"Text",     Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check" },
					var cols = [ {Type:"CheckBox",  Hidden:0,  Width:20,   Align:"Center",  ColMerge:0,   SaveName:"check",         Edit:1 },
								 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"seq",           Edit:0 },
								 {Type:"Text",      Hidden:1,  Width:90,   Align:"left",    ColMerge:1,   SaveName:"bkg_no",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"bl_no",         Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"por_cd",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pol_yd_cd",     Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pod_yd_cd",     Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"del_cd",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"del_yd_cd",     Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rd_cd1",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"rd_cd2",        Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"pre_vvd",       Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_pol_cd",    Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_pol_yd_cd", Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pre_pod_cd",    Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pre_pod_yd_cd", Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"lt",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"ef",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"pkg1",          Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"pkg2",          Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"wgt1",          Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"wgt2",          Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:"so_no",         Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rep",           Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"as_cd",         Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"dg",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"rf",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"aw",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"bb",            Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"bdr",           Edit:0 },
								 {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ca",            Edit:0 },
								 {Type:"Text",      Hidden:1,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"group_pol_pod", Edit:0 } ];
					InitColumns(cols);

					SetEditable(1);
					SetSheetHeight(450);
				}
				break;
		}
	}
