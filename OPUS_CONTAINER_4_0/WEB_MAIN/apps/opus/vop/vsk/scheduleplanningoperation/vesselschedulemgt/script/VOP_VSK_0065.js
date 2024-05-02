/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : VOP_VSK_0065.js
 *@FileTitle  : VSL SKD history Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class vop_vsk_0065 : business script for VOP_VSK_0065
	 */
	
	var focusObj=null;
	// public variable
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var tabLoad=new Array();
	tabLoad[0]=0;
	tabLoad[1]=0;
	//Setting Condition each Tab
	var glbFormDataTab1=null;
	var glbFormDataTab2=null;
	
	// Event handler processing by button click event */
	document.onclick=processButtonClick;
	// Event handler processing by button name */
	function processButtonClick(){
	//	var sheetObject  = sheetObjects[0];   //t1sheet1
		var sheetObj=getCurrentSheet();
		/*******************************************************/
		var formObj=document.form;
		try {
			var srcName=ComGetEvent("name");
			if (!ComIsBtnEnable(srcName)) return;             
			switch(srcName) {
				case "btn_retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_t1Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_t1New":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
 				case "btn_t1DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
				case "btn_t2Retrieve":
					doActionIBSheet(sheetObj, formObj, IBSEARCH);
					break;
				case "btn_t2New":
					doActionIBSheet(sheetObj, formObj, IBCLEAR);
					break;
 				case "btn_t2DownExcel":
 					doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
 					break;
				case "btn_vvd_search":
					doActionIBSheet(sheetObj, formObj, COMMAND01);
					break;
				case "btn_slan_cd":
					doActionIBSheet(sheetObj, formObj, COMMAND02);
					break;
				case "btn_port_cd":
					doActionIBSheet(sheetObj, formObj, COMMAND03);
//					if(window.event.srcElement.style.cursor == "hand"){
//						doActionIBSheet(sheetObj, formObj, COMMAND03);
//					}
					break;
				case "btn_period":
					doActionIBSheet(sheetObj, formObj, COMMAND10);
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
		for(var k=0; k<tabObjects.length; k++){
			initTab(tabObjects[k],k+1);
			tabObjects[k].SetSelectedIndex(0);
		}
		glbFormDataTab1=new Usr_Condi_FormData();
		glbFormDataTab2=new Usr_Condi_FormData();
		initControl();
		
		resizeSheet();
		//Setting first day of current month and current date
		document.form.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
		document.form.to_dt.value=ComGetNowInfo();
		document.form.vsl_cd.focus();
	}
	/**
	 * setting sheet initial values and header
	 * param : sheetObj, sheetNo
	 * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj,sheetNo) {
		var cnt=0;
		var sheetID=sheetObj.id;
		var prefix=sheetID + "_";
		switch(sheetNo) {
			case 1:      //t1sheet1 init
				with(sheetObj){				
					var HeadTitle="BKG|Old|Old|Old|Old|Old|Old|Old|New|New|New|New|New|New|New|Status|Updated Info.|Updated Info.|Remark(s)";
					var HeadTitle1="BKG|VVD|Lane|Port|TMNL|ETA|ETB|ETD|VVD|Lane|Port|TMNL|ETA|ETB|ETD|Status|Date(S)|ID|Remark(s)";
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol(prefix+"bfr_vps_port_cd"), MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"CheckBox",  Hidden:0, Width:37,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bkg_atch_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:-1 , TrueValue:"Y", FalseValue:"N"},
					             //{Type:"Combo",     Hidden:0, Width:30,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bkg_atch_flg",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vps_port_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vps_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vps_etb_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"bfr_vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vsl_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vps_port_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_yd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vps_eta_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vps_etb_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"aft_vps_etd_dt",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Combo",     Hidden:0,  Width:200,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vskd_cng_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 //{Type:"Text",     Hidden:0,  Width:60,   Align:"Left",    ColMerge:1,   SaveName:prefix+"vskd_cng_tp_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 
					 {Type:"Text",      Hidden:0,  Width:125,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,   Align:"Center",  ColMerge:1,   SaveName:prefix+"upd_usr_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:200,  Align:"Center",  ColMerge:1,   SaveName:prefix+"diff_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetSheetHeight(424);
					SetEditable(0);
					SetColProperty(prefix+"bfr_vps_eta_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"bfr_vps_etb_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"bfr_vps_etd_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"aft_vps_eta_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"aft_vps_etb_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"aft_vps_etd_dt", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"upd_dt", {Format:"####-##-## ##:##"} );
					
					/*
					D	Deleted Virtual Port by Turning Port
					E	Date (ETA, ETB, ETD) Change
					L	Lane Change
					O	Phase Out
					P	Calling Indicator Change
					Q	CLPT_IND_SEQ 변경
					S	Port Skip
					T	Port Delete
					V	VVD Delete
					X	Port Skip Cancel
					Y	Yard Change
					N   LRS CREATION 
					R	Turning Port Change
					*/
//					SetColProperty(prefix+"vskd_cng_tp_cd", {ComboText:"Deleted Virtual Port by Turning Port|Date (ETA, ETB, ETD) Change|Lane Change|Phase Out|Calling Indicator Change|Calling Indicator Change|Port Skip|Port Delete|VVD Delete|Port Skip Cancel|Yard Change|Add Call|Add Call Cancel|SKD Creation", ComboCode:"D|E|L|O|P|Q|S|T|V|X|Y|A|B|N"} );
					SetColProperty(prefix+"vskd_cng_tp_cd", {ComboText:"VVD Schedule Creation|VVD Delete|Normal Update|Activate|Holding(or Closing)|Proforma Type Change|Lane Chang|VVD Change|Port Skip|Phase Out|Date (ETA, ETB, ETD) Change|Yard Change|Port's Calling Sequence Change|Phase In|Add Calling|Add Calling Cancelation|Skip Call Cancelation|Auto Update|VVD Deletion|Virtual Port Deletion|Actual Port Deletion|New Virtual Port|Phase Out Cancelation|Turning Port Change (Y->N)|Turning Port Change (N->Y)", ComboCode: "MN|MD|MU|MF|MG|MH|ML|MV|PS|PO|PE|PY|PP|PI|PA|PB|PX|PU|PV|PD|PT|PM|PQ|PR|PC" });
					//SetColProperty(prefix+"bkg_atch_flg", {ComboText:"Y|N", ComboCode:"Y|N"} );
					FrozenCols=SaveNameCol(prefix+"bfr_vps_port_cd");
					SetRangeBackColor(1, 0, 1, 14, "#555555");
				}
				break;
			case 2:      //t2sheet1 init
				with(sheetObj){
					var HeadTitle="VVD|Lane|Old|Old|Old|Old|Old|New|New|New|New|New";
					var HeadTitle1="VVD|Lane|ATA|ATB|ATD|Updated Date(S)|Updated ID|ATA|ATB|ATD|Updated Date(S)|Updated ID";
					SetConfig( { SearchMode:2, FrozenCol:SaveNameCol(prefix+"old_ata"), MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"},{ Text:HeadTitle1, Align:"Center"} ];
					InitHeaders(headers, info);
					
					var cols = [ {Type:"Text",      Hidden:0,  Width:130,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"vsl_slan_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_ata",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_atb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_atd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"old_cre",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:120,   Align:"Center",  ColMerge:1,   SaveName:prefix+"old_user_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_ata",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_atb",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_atd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:125,  Align:"Center",  ColMerge:1,   SaveName:prefix+"new_cre",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					 {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:prefix+"new_user_id", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					   
					InitColumns(cols);
					SetEditable(0);
					SetColProperty(prefix+"old_ata", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"old_atb", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"old_atd", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"old_cre", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"new_ata", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"new_atb", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"new_atd", {Format:"####-##-## ##:##"} );
					SetColProperty(prefix+"new_cre", {Format:"####-##-## ##:##"} );
					FrozenCols=SaveNameCol(prefix+"old_ata");
					SetSheetHeight(424);					
					SetRangeBackColor(1, 2, 1, 12, "#555555");
					
				}
				break;
		}
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
					InsertItem( "Coastal SKD" , "");
					InsertItem( "Actual SKD" , "");
				}
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		var sheetID=sheetObj.id;
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					if ( sheetObj.id == "t1sheet1"){
						formObj.f_cmd.value=SEARCHLIST01;
						var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam(sheetID+"_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0065GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj,formObj,sXml);
					}else if ( sheetObj.id == "t2sheet1"){
						formObj.f_cmd.value=SEARCHLIST02;
						var fParam="f_cmd=" + SEARCHLIST02 + "&pagerows=";
						if(checkVVDLen()){
							fParam=fParam + "&loc_cd=" + formObj.loc_cd.value
									+ "&vsl_cd=" + formObj.vsl_cd.value
									+ "&skd_voy_no=" + formObj.skd_voy_no.value
									+ "&skd_dir_cd=" + formObj.skd_dir_cd.value
									+ "&vsl_slan_cd=" + formObj.vsl_slan_cd.value
									+ "&vps_port_cd=" + formObj.vps_port_cd.value;
						}else{
							fParam=FormQueryString(formObj);
						}
						var sParam=fParam + "&" + ComGetPrefixParam(sheetID+"_");
						sheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var sXml=sheetObj.GetSearchData("VOP_VSK_0065GS.do", sParam);
						ComOpenWait(false);
						showSheetData(sheetObj,formObj,sXml);
					}
				}
				break;
			case SEARCH01:		//VSL_CD Check
				if(validateForm(sheetObj,formObj,sAction)){
					formObj.f_cmd.value=SEARCH01;
					var sParam=FormQueryString(formObj);
					var sXml=sheetObj.GetSearchData("VOP_VSK_0065GS.do", sParam);
					return sXml;
				}
			case COMMAND01:        	// VVD Search
				var vslCd=formObj.vsl_cd.value;
            	if(vslCd == ""){
            		//sUrl = "/opuscntr/VOP_VSK_0219.do?op_=0219";
            		sUrl="/opuscntr/VOP_VSK_0219.do";
            		ComOpenPopup(sUrl, 460, 500, "returnVslCdHelp", "0,0", true);
            	}else{
            		//sUrl = "/opuscntr/VOP_VSK_0230.do?op_=0230&ctrl_cd=NORL&vsl_cd="+vslCd;
            		sUrl="/opuscntr/VOP_VSK_0230.do?ctrl_cd=NORL&vsl_cd="+vslCd;
            		ComOpenPopup(sUrl, 340, 420, "returnVvdHelp", "0,0", true);
            	}
				break;
			case COMMAND02:      // Lane Pop-up
				//sUrl = "/opuscntr/VOP_VSK_0202.do?op_=0202";
				sUrl="/opuscntr/VOP_VSK_0202.do?vsl_slan_cd=" + formObj.vsl_slan_cd.value;
				ComOpenPopup(sUrl, 500, 470, "returnLaneCdHelp", "0,0", true);
				break;
			case COMMAND03:      // Port Pop-up
				//sUrl = "/opuscntr/VOP_VSK_0043.do?op_=0043";
				sUrl="/opuscntr/VOP_VSK_0043.do?port_cd=" + formObj.vps_port_cd.value;
				ComOpenPopup(sUrl, 422, 520, "returnPortHelp", "0,0", true);
				break;
			case COMMAND10:        //btn_period
				var cal=new ComCalendarFromTo();
				cal.setEndFunction("returnPeriodHelp");	//Setting calling function when Calendar Close
				cal.select(formObj.fm_dt, formObj.to_dt, 'yyyy-MM-dd');
				break;
			case IBDOWNEXCEL:        	//excel download
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{ 
					sheetObj.Down2Excel({CheckBoxOnValue:'Y', CheckBoxOffValue:'N', HiddenColumn:-1,Merge:1, AutoSizeColumn:1});
				}				
				break;
			case IBCLEAR:      // New
				clearAllData(sheetObj, formObj);
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		var sheetId=sheetObj.id;
    	switch(sAction) {
			case IBSEARCH:      //Retrieve
				if (sheetId == "t1sheet1"){
					if(ComIsNull(formObj.vsl_cd.value)){
						ComShowCodeMessage('VSK00027', "Vessel Code");
						formObj.vsl_cd.focus();
						return false;
//					} else if(ComIsNull(formObj.skd_voy_no.value)){
//						ComShowCodeMessage('VSK00027', "VVD");
//						formObj.skd_voy_no.focus();
//						return false;
//					} else if(ComIsNull(formObj.skd_dir_cd.value)){
//						ComShowCodeMessage('VSK00027', "VVD");
//						formObj.skd_dir_cd.focus();
//						return false;
//					} else if(ComIsNull(formObj.vps_port_cd.value)){
//						ComShowCodeMessage('VSK00027', "Port Code");
//						formObj.vps_port_cd.focus();
//						return false;
					}
				}else if(sheetId == "t2sheet1"){
//						if(ComIsNull(formObj.vsl_cd.value)){
//						ComShowCodeMessage('VSK00027', "VVD");
//						formObj.vsl_cd.focus();
//						return false;
//					} else if(ComIsNull(formObj.skd_voy_no.value)){
//						ComShowCodeMessage('VSK00027', "VVD");
//						formObj.skd_voy_no.focus();
//						return false;
//					} else if(ComIsNull(formObj.skd_dir_cd.value)){
//						ComShowCodeMessage('VSK00027', "VVD");
//						formObj.skd_dir_cd.focus();
//						return false;
//					} else 
					if(ComIsNull(formObj.vps_port_cd.value)){
						ComShowCodeMessage('VSK00027', "Port Code");
						formObj.vps_port_cd.focus();
						return false;
					}
				}
				// Period Check(in 1 month).
				if(!(sheetId=="t2sheet1" && checkVVDLen())){
					if (ComIsNull(formObj.fm_dt.value)) {
						ComShowCodeMessage('VSK00027', "Period(From)");
						formObj.fm_dt.focus();
						return false;
					} else if (ComIsNull(formObj.to_dt.value)) {
						ComShowCodeMessage('VSK00027', "Period(To)");
						formObj.to_dt.focus();
						return false;
					}
				}
				if (sheetId == "t1sheet1"){
					if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
						ComShowCodeMessage("VSK00105", "1 month");
						return false;
					}
				}else if(sheetId == "t2sheet1"){
					var vvd=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
					if(!checkVVDLen()){
						if(!VskCheckPeriod(formObj.fm_dt, formObj.to_dt, "M")){
							ComShowCodeMessage("VSK00105", "1 month");
							return false;
						}
					}else{
						formObj.fm_dt.value="";
						formObj.to_dt.value="";
					}
				}
			break;
    	}
		return true;
	}
	function checkVVDLen(){
		var formObj=document.form;
		var vvd=formObj.vsl_cd.value + formObj.skd_voy_no.value + formObj.skd_dir_cd.value;
		if(ComChkLen(ComTrim(vvd), 9)==2){
			return true;
		}else{
			return false;
		}
	}
	/**
     * process after retrieve.
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix=sheetObj.id + "_";
				
		if(sXml != null){
			//var rootNode=VskGetXmlRootNode(sXml);
			//var dataNode=rootNode.selectSingleNode("//DATA/@TOTAL");
			var dataNode =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(dataNode){
				var totValue=dataNode.value;
				if(totValue > 0){
					if (sheetObj.id == "t1sheet1"){						
						//::2015-03-01:by TOP:://var xmlChgStsCd=ComGetEtcData(sXml, "chg_sts_cd");		//Change Status Code
						//::2015-03-01:by TOP:://var xmlChgStsNm=ComGetEtcData(sXml, "chg_sts_nm");
						//::2015-03-01:by TOP:://xmlChgStsNm=ComReplaceStr(xmlChgStsNm, " calling", ""); //Change Status CodeName.
						//::2015-03-01:by TOP:://sheetObj.SetColProperty(prefix+"vskd_cng_tp_cd", {ComboText:xmlChgStsNm, ComboCode:xmlChgStsCd} );
						//::2015-03-01:by TOP:://sheetObj.LoadSearchData(sXml,{Sync:1} );		
						
					} else if (sheetObj.id == "t2sheet1") {
						sheetObj.LoadSearchData(sXml,{Sync:0} );
					}
				}else{					
					sheetObj.LoadSearchData(sXml,{Sync:0} );
				}
			}
		}
	}
	/*
	 * =====================================================================
	 * Tab Event
	 * =====================================================================
	 */
	/**
	 * Event when clicking Tab
	 * activating selected tab items
	 */
	function tab1_OnChange(tabObj , nItem) {
		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="Inline";
		objs[beforetab].style.display="none";
		//--------------- important --------------------------//
		objs[beforetab].style.zIndex=objs[nItem].style.zIndex -1 ;
		//------------------------------------------------------//
		beforetab=nItem;
		resizeSheet();
		//Setting Condition Status of current tab and data
		setConditionControl(nItem);
	}
	/*
	 * =====================================================================
	 * Sheet Event
	 * =====================================================================
	 */
	/*
	 * =====================================================================
	 * Object Event
	 * =====================================================================
	 */
	function initControl() {
    	axon_event.addListenerForm('focus', 'obj_focus', form);
    	axon_event.addListenerForm('change', 'obj_change', form); 		
    	//axon_event.addListenerForm('keypress', 'obj_keypress', form); 	
    	//axon_event.addListenerForm('keyup', 'obj_keyup', form); 		
    	//axon_event.addListenerForm('keydown', 'obj_keydown', form);
    	//axon_event.addListenerForm('keydown', 'ComKeyEnter', form);
	}

    function obj_focus(){
    	var eleObj=event.srcElement;
    	if(eleObj.name){
			focusObj=eleObj.name;
		}else{
			focusObj="";
		}
    	if(eleObj.options){
    		eleObj.focus();
    	}else{
    		eleObj.focus();
    	}
    }
	function obj_change(){
		var formObj=document.form;
	    var sheetObj=sheetObjects[0];
	    /*******************************************************/
		try {
			var srcName=ComGetEvent("name");
	        switch(srcName) {
	            case "vsl_cd":
	            	if(isCheckVslCd(sheetObj, formObj)){
		            	var vslCd=formObj.vsl_cd.value;
		            	if(!ComIsNull(vslCd)){
		            		if(vslCd.length < 4){
		            			ComShowCodeMessage('VSK01018', vslCd);
		            			formObj.vsl_cd.value="";
		        				formObj.vsl_cd.focus();
		        				return false;
		            		}
		            	}
		            	if(beforetab == 0){
		        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
		        		}
		        		else if(beforetab == 1){
		        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
		        		}
		            	if(formObj.vsl_cd.value.length == 4){
				    		formObj.skd_voy_no.focus();
				    	}
	            	}else{
	            		formObj.vsl_cd.focus();
	            	}
	            	break;
	            case "skd_voy_no":
	            	var skdVoyNo=formObj.skd_voy_no.value;
	            	if(!ComIsNull(skdVoyNo)){
	            		if(skdVoyNo.length < 4){
	            			ComShowCodeMessage('VSK01018', skdVoyNo);
	            			formObj.skd_voy_no.value="";
	        				formObj.skd_voy_no.focus();
	        				return false;
	            		}
	            	}
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        		}
	            	if(formObj.skd_voy_no.value.length == 4){
			    		formObj.skd_dir_cd.focus();
			    	}
	            	break;
	            case "skd_dir_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	            	if(formObj.skd_dir_cd.value.length == 1){
			    		formObj.vsl_slan_cd.focus();
			    	}
	            	break;
	            case "vsl_slan_cd":
	            	var vslSlanCd=formObj.vsl_slan_cd.value;
	            	if(!ComIsNull(vslSlanCd)){
	            		if(vslSlanCd.length < 3){
	            			ComShowCodeMessage('VSK01018', vslSlanCd);
	            			formObj.vsl_slan_cd.value="";
	        				formObj.vsl_slan_cd.focus();
	        				return false;
	            		}
	            	}
	            	if(beforetab == 0){
	        			glbFormDataTab1.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslSlanCd(formObj.vsl_slan_cd.value);
	        		}
	            	break;
	            case "vps_port_cd":
	            	if(beforetab == 0){
	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
	        		}
	            	break;
                case "fm_dt":
                	formObj.fm_dt.value=ComGetMaskedValue(formObj.fm_dt.value, "ymd");
	            	if(beforetab == 0){
	        			glbFormDataTab1.setFmDt(formObj.fm_dt.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setFmDt(formObj.fm_dt.value);
	        		}
                	break;
                case "to_dt":
                	formObj.to_dt.value=ComGetMaskedValue(formObj.to_dt.value, "ymd");
	            	if(beforetab == 0){
	        			glbFormDataTab1.setToDt(formObj.to_dt.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setToDt(formObj.to_dt.value);
	        		}
                	break;
	        } // end switch
		}catch(e) {
			if( e == "[object Error]") {
				ComShowCodeMessage('VSK00011');
			} else {
				ComShowMessage(e.message);
			}
		}
	}
	function obj_keypress(){
		var formObj=document.form;
		switch (ComGetEvent("name")) {
		    case "vsl_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
		    case "skd_voy_no":
		    	ComKeyOnlyNumber(document.form.skd_voy_no);
				break;
		    case "skd_dir_cd":
		    	ComKeyOnlyAlphabet('upper');
				break;
		    case "vsl_slan_cd":
		    	ComKeyOnlyAlphabet('uppernum');
				break;
	    	case "vps_port_cd":
	    		ComKeyOnlyAlphabet('upper');
				break;
		    case "fm_dt":
		    	ComKeyOnlyNumber(formObj.fm_dt);
				break;
		    case "to_dt":
		    	ComKeyOnlyNumber(formObj.to_dt);
				break;
		}
	}
	function obj_keyup(){
		var eleObj=ComGetEvent();
		var formObj=document.form;
		switch (eleObj.name) {
		    case "vsl_cd":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_voy_no.focus();
		    	}
				break; 
		    case "skd_voy_no":
		    	if(eleObj.value.length == 4){
		    		formObj.skd_dir_cd.focus();
		    	}
				break;
		    case "skd_dir_cd":
		    	if(eleObj.value.length == 1){
		    		formObj.vsl_slan_cd.focus();
		    	}
				break;
		    case "vsl_slan_cd":
		    	if(eleObj.value.length == 3){
		    		formObj.vps_port_cd.focus();
		    	}
				break;
		    case "vps_port_cd":
		    	if(eleObj.value.length == 5){
		    		formObj.fm_dt.focus();
		    	}
				break;
		}
	}
	function obj_keydown(){
		var formObj=document.form;
		var sheetObj=sheetObjects[0];
		if(focusObj=="vsl_cd"){
			var ctrl=event.ctrlKey;
			var code=event.keyCode;
			if(ctrl && code == 86){ 
				var clipData=window.clipboardData.getData('Text');
				if(clipData!=null && clipData.length==9){
					clipData=clipData.toUpperCase();
					formObj.vsl_cd.value=clipData.substring(0, 4);
					if(isCheckVslCd(sheetObj, formObj)){
						formObj.skd_voy_no.value=clipData.substring(4, 8);
						formObj.skd_dir_cd.value=clipData.substring(8, 9);
					}
				}
				event.returnValue=false;
			}
		}
	}
	/*
	 * =====================================================================
	 * Pop Up Data 처리
	 * =====================================================================
	 */
	/**
	 * Handling data from VSL Code Help (Pop-Up)
	 * @param rtnObjs
	 * @return
	 */
    function returnVslCdHelp(rtnObjs){
    	var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.vsl_cd.value=rtnDatas[1];
					if(beforetab == 0){
	        			glbFormDataTab1.setVslCd(formObj.vsl_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setVslCd(formObj.vsl_cd.value);
	        		}
				}
			}
    	}
    }
    /**
     * Handling data from VVD Code Help (Pop-Up)
     * @param rtnObjs
     * @return
     */
	function returnVvdHelp(rtnObjs){
		var formObj=document.form;
    	if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.skd_voy_no.value=rtnDatas[2];
					formObj.skd_dir_cd.value=rtnDatas[3];
					if(beforetab == 0){
	        			glbFormDataTab1.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab1.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
	        		else if(beforetab == 1){
	        			glbFormDataTab2.setSkdVoyNo(formObj.skd_voy_no.value);
	        			glbFormDataTab2.setSkdDirCd(formObj.skd_dir_cd.value);
	        		}
				}
			}
    	}
    }
	/**
	 * Calling after Land Code Click from Pop up
	 * @param rtnObjs
	 * @return
	 */
	function returnLaneCdHelp(rVal){
		var formObj=document.form;
		
		var rtnObjs  = rVal[0]
		if(rtnObjs){
				if(rtnObjs.length > 0){
					formObj.vsl_slan_cd.value=rtnObjs[1];
				}
		}
	}
	
	/**
	 * Calling after Port Code Click from Pop up
	 * @param rtnObjs
	 * @return
	 */
	function returnPortHelp(rtnObjs){
		var formObj=document.form;
		var sheetObj=getCurrentSheet();
		if(rtnObjs){
			var rtnDatas=rtnObjs;
			if(rtnDatas){
				if(rtnDatas.length > 0){
					formObj.loc_cd.value=rtnDatas;
					formObj.vps_port_cd.value=rtnDatas;
//					if(beforetab == 0){
//	        			glbFormDataTab1.setVpsPortCd(formObj.vps_port_cd.value);
//	        		}
//	        		else if(beforetab == 1){
//	        			glbFormDataTab2.setVpsPortCd(formObj.vps_port_cd.value);
//	        		}
//					sXml = doActionIBSheet(sheetObj, formObj, SEARCH01);
//					if(!isCheckPortForm(sheetObj, formObj, sXml)){
//						formObj.vps_port_cd.value = "";
//						formObj.vps_port_cd.focus();
//					}else{
//						formObj.fm_dt.focus();
//					}
				}
			}
		}
	}
	/**
	 * Calling when date inputted through calender
	 * @param rtnObjs
	 * @return
	 */
	function returnPeriodHelp(rtnObjs){
		var formObj=document.form;
		if(beforetab == 0){
        	glbFormDataTab1.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab1.setToDt(formObj.to_dt.value);
		}
		else if(beforetab == 1){
        	glbFormDataTab2.setFmDt(formObj.fm_dt.value);
        	glbFormDataTab2.setToDt(formObj.to_dt.value);
		}
	}
	/*
	 * =====================================================================
	 * Form Control
	 * =====================================================================
	 */
	/**
 	 * Setting condition
 	 * using Tab change
 	 * 
 	 * @param nItem
 	 * @return
 	 */
 	function setConditionControl(nItem){
 		var formObj=document.form;
 		switch(nItem) {
			case 0:      //tab1
				VskEnableObjectControl(formObj.vps_port_cd,  false, false);
				VskEnableObjectControl(formObj.vsl_cd, true, true);
//				VskEnableObjectControl(formObj.skd_voy_no, false);
//				VskEnableObjectControl(formObj.skd_dir_cd, false);
//				
				VskEnableObjectControl(formObj.btn_port_cd, false);
//				VskEnableObjectControl(formObj.btn_period, true);
//				VskEnableObjectControl(formObj.btn_vvd, false);
//
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				formObj.vsl_cd.focus();
				VskEnableObjectControl(formObj.bkg_atch_flg, true);
				VskEnableObjectControl(formObj.bkg_atch_flg1, true); // Attached
				VskEnableObjectControl(formObj.bkg_atch_flg2, true); //Not Attached
				VskEnableObjectControl(formObj.bkg_atch_flg3, true); //All
				break;
			case 1:      //tab2
				VskEnableObjectControl(formObj.vps_port_cd, true, true);
				VskEnableObjectControl(formObj.vsl_cd, true, false);
//				VskEnableObjectControl(formObj.skd_voy_no, false);
//				VskEnableObjectControl(formObj.skd_dir_cd, false);
//				
				VskEnableObjectControl(formObj.btn_port_cd, true);
//				VskEnableObjectControl(formObj.btn_period, true);
//				VskEnableObjectControl(formObj.btn_vvd, false);
//				
//				VskEnableObjectControl(formObj.fm_dt, false, true);
//				VskEnableObjectControl(formObj.to_dt, false, true);
				formObj.vps_port_cd.focus();
				//2015-06-18 ActualSKD 조회 시 Radio Disable 처리 
				VskEnableObjectControl(formObj.bkg_atch_flg, false);
				VskEnableObjectControl(formObj.bkg_atch_flg1, false); //Attached
				VskEnableObjectControl(formObj.bkg_atch_flg2, false); //Not Attached
				VskEnableObjectControl(formObj.bkg_atch_flg3, false); //All
				break;
		}
		setConditionData(formObj, nItem);
 	}

	/**
	 * Setting Retrieve condition when Tab change
	 * 
	 * @param formObj
	 * @param nItem
	 * @return
	 */
	function setConditionData(formObj, nItem){
		switch(nItem) {
			case 0:      //tab1
				if(glbFormDataTab1 != null){
					glbFormDataTab1.setAllFormData();
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}else{
					formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value=ComGetNowInfo();
				}
				break;
			case 1:      //tab2
				if(glbFormDataTab2 != null){
					glbFormDataTab2.setAllFormData();
					if(ComIsNull(formObj.fm_dt)){
						formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					}
					if(ComIsNull(formObj.to_dt)){
						formObj.to_dt.value=ComGetNowInfo();
					}
				}else{
					formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
					formObj.to_dt.value=ComGetNowInfo();
				}
				break;
		}
	}
 	/**
 	 * Returning activated sheet
 	 * @return sheetObj
 	 */
 	function getCurrentSheet(){
 		var sheetObj=null;
 		sheetObj=sheetObjects[beforetab];
 		return sheetObj;
 	}
	/**
     * Handling as Port Code 
     * 
     * @param sheetObj
     * @param formObj
     * @param sXml
     * @return
     */
    function isCheckPortForm(sheetObj, formObj, sXml){
    	if(sXml == null || sXml == undefined || sXml == "") return false;
    	var prefix=sheetObj.id + "_";
    	var chkPort=ComGetEtcData(sXml, "check_port");
		if(chkPort == "X"){
			return true;
		}else{
			ComShowCodeMessage("VSK00029", formObj.loc_cd.value);
			formObj.loc_cd.value="";
		}
		return false;
    }
    /**
     * Checking Vessel Code in MDM_VSL_CNTR
     * 
     * @param sheetObj
     * @param formObj
     * @return
     */
    function isCheckVslCd(sheetObj, formObj){
    	if(formObj.vsl_cd.value == null || formObj.vsl_cd.value == undefined || formObj.vsl_cd.value == "") return false;
		var sXml=doActionIBSheet(sheetObj, formObj, SEARCH01);
		var chkVslCd=ComGetEtcData(sXml, "vsl_chk");
		if(chkVslCd == "Y"){
    		//exist
    		return true;
    	}else{
    		sheetObj.LoadSearchData(sXml,{Sync:1} );
    		formObj.vsl_cd.value="";
    		return false;
    	}
	}
    /**
     * [New] Button Event : Initializing screen
     * @param sheetObj
     * @param formObj
     * @return
     */
    function clearAllData(sheetObj, formObj){
    	if(sheetObj.id == "t1sheet1"){
    		glbFormDataTab1=new Usr_Condi_FormData();
    		glbFormDataTab1.setAllFormData();
		} else {
			glbFormDataTab2=new Usr_Condi_FormData();
			glbFormDataTab2.setAllFormData();
		}
    	sheetObj.RemoveAll();
    	formObj.fm_dt.value=ComGetDateAdd(ComGetDateAdd(null, "M", -1), "D", 1);
    	formObj.to_dt.value=ComGetNowInfo();
    	if(sheetObj.id == "t1sheet1"){
    		formObj.vsl_cd.focus();
		} else {
			formObj.vps_port_cd.focus();
		}
    }
	/*
	 * =====================================================================
	 * Form Condition Elements Getter/Setter
	 * =====================================================================
	 */
 	function Usr_Condi_FormData(){
		this.vslCd="";
		this.skdVoyNo="";
		this.skdDirCd="";
 		this.vslSlanCd="";
		this.vpsPortCd="";
		this.fmDt="";
		this.toDt="";
	}
	//Usr_Condi_FormData.Getter()
	Usr_Condi_FormData.prototype.getVslCd=function(){
		return this.vslCd;
	}
	Usr_Condi_FormData.prototype.getSkdVoyNo=function(){
		return this.skdVoyNo;
	}
	Usr_Condi_FormData.prototype.getSkdDirCd=function(){
		return this.skdDirCd;
	}
	Usr_Condi_FormData.prototype.getVslSlanCd=function(){
		return this.vslSlanCd;
	}
	Usr_Condi_FormData.prototype.getVpsPortCd=function(){
		return this.vpsPortCd;
	}
	Usr_Condi_FormData.prototype.getFmDt=function(){
		return this.fmDt;
	}
	Usr_Condi_FormData.prototype.getToDt=function(){
		return this.toDt;
	}
	//Usr_Condi_FormData.Setter()
	Usr_Condi_FormData.prototype.setVslCd=function(sVslCd){
		this.vslCd=sVslCd;
	}
	Usr_Condi_FormData.prototype.setSkdVoyNo=function(sSkdVoyNo){
		this.skdVoyNo=sSkdVoyNo;
	}
	Usr_Condi_FormData.prototype.setSkdDirCd=function(sSkdDirCd){
		this.skdDirCd=sSkdDirCd;
	}
	Usr_Condi_FormData.prototype.setVslSlanCd=function(sVslSlanCd){
		this.vslSlanCd=sVslSlanCd;
	}
	Usr_Condi_FormData.prototype.setVpsPortCd=function(sVpsPortCd){
		this.vpsPortCd=sVpsPortCd;
	}
	Usr_Condi_FormData.prototype.setFmDt=function(sFmDt){
		this.fmDt=sFmDt;
	}
	Usr_Condi_FormData.prototype.setToDt=function(sToDt){
		this.toDt=sToDt;
	}
	Usr_Condi_FormData.prototype.setAllFormData=function(){
		var formObj=document.form;
		formObj.vsl_cd.value=this.getVslCd();
		formObj.skd_voy_no.value=this.getSkdVoyNo();
		formObj.skd_dir_cd.value=this.getSkdDirCd();
		formObj.vsl_slan_cd.value=this.getVslSlanCd();
		formObj.vps_port_cd.value=this.getVpsPortCd();
		formObj.fm_dt.value=this.getFmDt();
		formObj.to_dt.value=this.getToDt();
	}
	
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}