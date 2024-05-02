/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : VOP_VSK_0232.js
 *@FileTitle : Target VVD & Remark(s)
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/13
=========================================================*/
/****************************************************************************************
  Event Code: INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6; MULTI=7;
					Other Case: COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/**
	 * @extends 
	 * @class VOP_VSK_0232 : business script for VOP_VSK_0232
	 */
	//public variable
	var sheetObjects=new Array();
	var sheetCnt=0;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		var sheetObject=sheetObjects[0];
		/*******************************************************/
		var formObject=document.form;
		try {
			var srcName=ComGetEvent("name");
	        if (!ComIsBtnEnable(srcName)) return;  
			switch(srcName) {
				case "btn_close":
					ComClosePopup(); 
					break;
				case "btn_ok":
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
		initLoadAction(sheetObjects[0], document.form);
	}
	function initControl() {
		var formObj=document.form;
		axon_event.addListenerForm('focus', 'obj_focus', formObj);
	}
	function obj_focus() {
		if(event.srcElement.options){
			event.srcElement.focus();
		}else{
			event.srcElement.select();
		}
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
			case 1:      // sheet1 init
			    with(sheetObj){
		        
		      var HeadTitle="|VVD|Port|RSN Port|Arr/Dep|RSN|HR|Remark";

		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle, Align:"Center"} ];
		      InitHeaders(headers, info);

		      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
		             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vvd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:0,   SaveName:prefix+"vps_port_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"reason_port", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:prefix+"arr_dep",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rsn_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"delay_tm",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:115,  Align:"Left",    ColMerge:0,   SaveName:prefix+"rmk",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
		       
		      InitColumns(cols);

		      SetEditable(0);
		      SetWaitImageVisible(0);
		      SetSheetHeight(210);
		            }
				break;
		}
	}
	// handling sheet process
	function doActionIBSheet(sheetObj,formObj,sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSEARCH:      //Retrieve
				if(validateForm(sheetObj,formObj,sAction)){
					ComOpenWait(true);
					formObj.f_cmd.value=SEARCH;
					var sParam=FormQueryString(formObj) + "&" + ComGetPrefixParam("sheet1_");					
 					var sXml=sheetObj.GetSearchData("VOP_VSK_0232GS.do", sParam);
					showSheetData(sheetObj, formObj, sXml);
					ComOpenWait(false);
				}
				break;
			case IBSAVE:        //save
				if(validateForm(sheetObj,formObj,sAction))
				break;
			case IBINSERT:      // input
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		with(formObj){
		}
		return true;
	}
	/**
	 * process after retrieve.
	 * 
	 * @param sheetObj
	 * @param formObj
	 * @param sXml
	 * @returnR
	 */
	function showSheetData(sheetObj, formObj, sXml){
		var prefix=sheetObj.id + "_";
		if(sXml != null){
//			var xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
			var xmlDoc = ComGetXmlDoc(sXml);
//			xmlDoc.loadXML(sXml);
//			var dataNode=xmlDoc.selectSingleNode("//DATA/@TOTAL");
			var totValue =  ComGetSelectSingleNode(sXml, "TOTAL");
			if(totValue.length > 0){
//				var totValue=dataNode.value;
//				if(totValue > 0){
					sheetObj.RenderSheet(0);
					sheetObj.LoadSearchData(sXml,{Sync:0} );
					sheetObj.RenderSheet(1);
//				}
			}else{
				sheetObj.LoadSearchData(sXml,{Sync:0} );
//				clearAllFormData(formObj);
//				formObj.vps_port_cd.focus();
//				return;
			}
		}
	}
	/**
	 * Retrieving Data when screen open
	 * @param sheetObj
	 * @param formObj
	 * @return
	 */
	function initLoadAction(sheetObj, formObj){
//		var opner=window.dialogArguments;
		if (!opener) opner=window.dialogArguments;
	     if(!opener) opner=parent;
		var prefix=sheetObj.id + "_";
		var pSheetObj=null;
		if(opner.sheetObjects){
			if(opner.sheetObjects.length > 0){
				pSheetObj=opner.sheetObjects[opner.beforetab];
				var pPrefix=getParentSheetPrefix(pSheetObj);
				var tabIdx=opner.beforetab;
				var selRows=pSheetObj.GetSelectionRows("|");
				if(selRows == null || selRows == undefined && selRows == ""){
					ComShowCodeMessage("VSK00020");
					return false;
				}
				var selRowArr=selRows.split("|");
				var conObjs=pSheetObj.GetCellValue(selRowArr[0], pPrefix+"lane");
				for(var i=1; i<selRowArr.length; i++){
					conObjs=conObjs + "," + pSheetObj.GetCellValue(selRowArr[i], pPrefix+"lane");
				}
				formObj.fm_dt.value=opner.form.act_inp_fm_dt.value;
				formObj.to_dt.value=opner.form.act_inp_to_dt.value;
				formObj.ig_flg.value=getRadioCheckValue(opner.form.lane_grp);
				formObj.vsl_slan_cd.value=opner.form.vsl_slan_cd.value;
				formObj.lane_grp_nm.value=opner.lane_grp_nm.GetSelectText();
				formObj.vsl_cd.value=opner.form.vsl_cd.value;
				formObj.vps_port_cd.value=opner.form.vps_port_cd.value;
				formObj.crr_cd.value=opner.form.crr_cd.value;
				formObj.tab_flg.value=Number(tabIdx) + 1;
				formObj.grp_flg.value=opner.form.grp_flg[tabIdx].value;
				formObj.condition.value=conObjs;
				formObj.port_skp_tp_cd.value=getRadioCheckValue(opner.form.port_skp_tp_cd);
//				formObj.ie_flg.value = opner.form.ie_flg[].value;
				if(tabIdx == "0"){
					sheetObj.SetColHidden(prefix + "reason_port",1);
				}else{
					sheetObj.SetColHidden(prefix + "arr_dep",1);
					sheetObj.SetColHidden(prefix + "rsn_cd",1);
					sheetObj.SetColHidden(prefix + "delay_tm",1);
				}
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
			}
		}
	}
	/**
	 * Finding prefix of sheet of parent screen
	 * @param pSheetObj
	 * @return
	 */
	function getParentSheetPrefix(pSheetObj){
		var prefix="";
		if(pSheetObj.id == "t1sheet1"){
			prefix="sheet1_";
		}else if(pSheetObj.id == "t2sheet1"){
			prefix="sheet2_";
		}
		return prefix;
	}
	/**
	 * Finding checked value of radio
	 * @param radioObj
	 * @return
	 */
	function getRadioCheckValue(radioObj){
		var rdoCnt=radioObj.length;
		for(var i=0; i<rdoCnt; i++){
			if(radioObj[i].checked){
				return radioObj[i].value;
			}
		}
		return "";
	}
