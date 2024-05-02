/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0032.js
*@FileTitle  : Repair Result creatioln by W/O
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/
/****************************************************************************************
	  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
						MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
						OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ees_mnr_0032 : business script for ees_mnr_0032.
 */
function EES_MNR_0032() {
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
//common global variables
	var tabObjects=new Array();
	var tabCnt=0 ;
	var beforetab=1;
	var sheetObjects=new Array();
	var sheetCnt=0;
	var costDtlCode="";
	var costDtlDesc="";
	var OrgCostType="";
	var nowLoad=0;
	// file upload
	var uploadObjects=new Array();
	var uploadCnt=0;
	//calling Calculate 
	var calReq=0;
	//deleting calculate
	var calDel="";
	//synchronization variable sheet Combo when retrieving
	var arrDataSearchDbXml;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
	var sheetObject=sheetObjects[0];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_WONo":
				ComOpenPopup("EES_MNR_0211.do", 720, 380, 'setPopUpParam_EES_MNR_0211', '0,0', true);
				break;
			case "btn_retrive":
				doActionIBSheet(sheetObjects[0],formObject,IBSEARCH);
				break;
			case "btn_clear":
				doActionIBSheet(sheetObjects[0],formObject,IBCLEAR);
				break;
			case "btn_save":
				doActionIBSheet(sheetObjects[0], formObject, IBSAVE);
				break;
			case "btn_vndr":
				ComOpenPopup('/opuscntr/COM_ENS_0C1.do', 700, 540, 'setPopData_Sp', '1,0,1,1,1,1,1,1', true);
				break;
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1){//no data
	        		ComShowCodeMessage("COM132501");
	        	}else{
	        		sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObject), SheetDesign:1,Merge:1 });
	        	}
				//sheetObject.Down2Excel( {DownCols: makeHiddenSkipCol(				sheetObject), SheetDesign:1,Merge:1 });
				break;
			case "btn_calendar":
				var cal=new ComCalendarFromTo();
				cal.select(formObject.fromcal, formObject.tocal, 'yyyy-MM-dd');
				break;
			case "btn_Print":
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("MNR00310");
				} else {
					// calling RD
					var prefix="sheet1_";
					var mnr_ord_ofc_cty_cd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix +"mnr_ord_ofc_cty_cd");
					var mnrOrdSeq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "mnr_ord_seq");
					mnrOrdSeq=mnrOrdSeq.substr(3,mnrOrdSeq.length);
					var rdParam='/rv mnr_ord_ofc_cty_cd['+ mnr_ord_ofc_cty_cd +'] mnr_ord_seq[' + mnrOrdSeq + '] user_nm[' + self_usr_nm + ']';
					formObject.com_mrdPath.value='apps/opus/ees/mnr/operationmanage/repairmgt/report/EES_MNR_0182.mrd';
					//2013-08-27 Recovery PQC test defects by J.H. Han
					formObject.com_mrdTitle.value="Work Order"
					formObject.com_mrdBodyTitle.value="Work Order";
					formObject.com_mrdArguments.value=rdParam;
					ComOpenRDPopup();
				}
				break;
			case "btn_Detail":
				if(sheetObjects[0].RowCount()== 0){
					ComShowCodeMessage("MNR00309");
				} else {
					// calling estimate pop up
					var prefix="sheet1_";
					if(MnrNullToBlank(sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "eq_no")) != ''){
						var rqstEqNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "eq_no");
						var rprRqstSeq=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "rpr_rqst_seq");
						var rprRqstVerNo=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "rpr_rqst_ver_no");
						var eqKndCd=sheetObjects[0].GetCellValue(sheetObjects[0].GetSelectRow(),prefix + "eq_knd_cd");
						ComOpenPopup('/opuscntr/EES_MNR_0192.do?rqst_eq_no='+rqstEqNo+"&rpr_rqst_seq="+rprRqstSeq+"&rpr_rqst_ver_no="+rprRqstVerNo+"&eq_knd_cd="+eqKndCd+"&spp_type=N", 1024, 768, '', '0,0', false);
					}
				}
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
	function setPopUpParam_EES_MNR_0211(array) {
	if(array == null)	return;
	var formObj=document.form;
	var str=array + "";
	var arr=str.split(',');
	formObj.mnr_ord_seq.value=arr[4];
}
/**
 * (Service Provider) handling Pop-up Return Value<br>
 * @param {arry} Return value array of returnedValues Pop-up
 * @param Row IBSheet Row index
 * @param Col IBSheet Col index
 * @param Sheet Array index
 */
	function setPopData_Sp(aryPopupData, Row, Col, SheetIdx) {
	var formObj=document.form;
	if ( aryPopupData.length > 0 ) {
		formObj.vndr_seq.value=ComLpad(aryPopupData[0][2],6,"0");
		formObj.vndr_nm.value=aryPopupData[0][4];
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
	initControl();
	for(i=0;i<sheetObjects.length;i++){
		//
		ComConfigSheet (sheetObjects[i] );
		initSheet(sheetObjects[i],i + 1);
		//
		ComEndConfigSheet(sheetObjects[i]);
		//doActionIBSheet(sheetObjects[i],document.form,IBSEARCH);
	}
	for(k=0;k<tabObjects.length;k++){
		initTab(tabObjects[k],k + 1);
	}
	initCombo();
	doActionIBSheet(sheetObjects[0],document.form,IBCLEAR);
	MnrWaitControl(false);
//	ComBtnDisable("btn_W/O_Send");
}
/**
 * initializing multi Combo
 * @return
 */
	function initCombo() {
	var formObject=document.form
	with (rpr_rslt_sts) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "100");
		SetDropHeight(160);
		SetEnable(1);
	}
	with (eq_knd_cd) {
		SetMultiSeparator("|");
		SetColAlign(0, "left");
		SetColWidth(0, "80");
		SetDropHeight(160);
		SetEnable(1);
	}
}
	function resizeSheet( sheetObj ){
	    ComResizeSheet( sheetObj );
	}
/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
	function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
	case 1:      //t1sheet1 init
	    with(sheetObj){
      var HeadTitle="|Seq|S/P|EQ No.|TP/SZ|W/O No|Estimate No|W/O Amount|Repair Yard|Input Date|W/O Date|Estimate Status|Repair Creation\n User|Repair Creation\n Date|Days fm W/O\n to Repair|Remark(s) ";
      var prefix="sheet1_";
      SetConfig( { SearchMode:2, MergeSheet:0, Page:20, DataRowMerge:1 } );
      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
      var headers = [ { Text:HeadTitle, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
         {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"Seq",                       KeyField:0,   CalcLogic:"",   Format:"" },
         {Type:"Text",      Hidden:0,  Width:200,  Align:"Left",    ColMerge:1,   SaveName:prefix+"pig_eng_nm",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_no",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_tpsz_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"mnr_ord_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rqst_ref_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"mnr_wrk_amt",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:73,   Align:"Center",  ColMerge:0,   SaveName:prefix+"yd_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Date",      Hidden:0,  Width:67,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rqst_dt",            KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Date",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:prefix+"cre_dt",             KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:98,   Align:"Center",  ColMerge:0,   SaveName:prefix+"rpr_sts_cd_nm",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"upd_usr_id",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"PopupEdit", Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"rpr_rslt_dt",        KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
         {Type:"Text",      Hidden:0,  Width:80,   Align:"Right",   ColMerge:0,   SaveName:prefix+"rpr_rslt_days",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ord_dtl_rmk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ord_dtl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mnr_dmg_flg",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eq_knd_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rpr_rqst_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rpr_rqst_ver_no",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
         {Type:"Text",      Hidden:1, Width:100,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mnr_ord_ofc_cty_cd", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
      InitColumns(cols);
//      SetSheetHeight(390);
      SetEditable(1);
      SetShowButtonImage(2);
      resizeSheet( sheetObj );
      }


		break;
	}
}
	// handling process for sheet
	function doActionIBSheet(sheetObj,formObj,sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR:  //NEW
			MnrWaitControl(true);
			formObj.f_gubuns.value="";
			formObj.mnr_ord_seq.value="";
			formObj.cost_ofc_cd.value=currOfcCd;
			formObj.vndr_seq.value="";
			formObj.vndr_nm.value="";
			formObj.rqst_ref_no.value="";
			formObj.eq_no.value="";
			formObj.fromcal.value=ComGetDateAdd(ComGetNowInfo(), "D", -7);
			formObj.tocal.value=ComGetNowInfo();
			//setting combo
			eq_knd_cd.RemoveAll();
			rpr_rslt_sts.RemoveAll();
			eq_knd_cd.SetSelectCode("-1",false);
			rpr_rslt_sts.SetSelectCode("-1",false);
			var sCondition=new Array (
					new Array("MnrGenCd","CD00002", "COMMON") //EQ Type
				   ,new Array("MnrGenCd","CD00030", "COMMON") //Repair Completion Status
				);
			var comboList=MnrComSearchCombo(sheetObj,sCondition);
			var code,Texts="";
			for(var i=0; i<comboList.length; i++)
			{
				if(comboList[i] != null)
				{
                    if(i==1){
            			rpr_rslt_sts.InsertItem(0, "All" ,"");
					}
					for(var j=0; j < comboList[i].length;j++)
					{
						var xmlVal=comboList[i][j].split("|");
						if(i==0){
							eq_knd_cd.InsertItem(j, xmlVal[1] ,xmlVal[0]);
						}else if(i==1){
							rpr_rslt_sts.InsertItem(j + 1, xmlVal[1] ,xmlVal[0]);
						}
					}
				}
				else
				{
					if(i==0){
						ComShowCodeMessage("MNR00005", "EQ Type  ");
					}else if(i==1){
						ComShowCodeMessage("MNR00005", "Repair Completion Status  ");
					}
				}
			}
			eq_knd_cd.SetSelectCode("U");
			rpr_rslt_sts.SetSelectIndex(0);
			sheetObjects[0].RemoveAll();
			MnrWaitControl(false);
			break;
		case IBSEARCH:      //Retrieve
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			nowLoad=1;
			formObj.f_gubuns.value="";
			sheetObjects[0].RemoveAll();
			formObj.f_cmd.value=SEARCH;
			var sParam="";
			var aryPrefix=new Array("sheet1_", "sheet2_", "sheet3_");
			sParam += ComGetPrefixParam(aryPrefix)+ "&" + FormQueryString(formObj);
			//alert("IBSEARCH : " + "\n"+ sParam);
			var sXml=sheetObj.GetSearchData("EES_MNR_0032GS.do", sParam);
			arrDataSearchDbXml=sXml.split("|$$|");
			for ( var i=0; i < arrDataSearchDbXml.length; i++) {
				sheetObjects[i].RenderSheet(0);
				if (i > 0) {
					sheetObjects[i].SetWaitImageVisible(0);
				}
				sheetObjects[i].LoadSearchData(arrDataSearchDbXml[i],{Sync:0} );
				sheetObjects[i].RenderSheet(1);
				if (i>0) break;
			}
			break;
		case IBSAVE:        //saving
			if(nowLoad != 0) return;
			if(!validateForm(sheetObj,formObj,sAction))return;
			MnrWaitControl(true);
			formObj.f_cmd.value=MULTI;
			var aryPrefix=new Array("sheet1_", "sheet2_");
			var sParam=ComGetSaveString(sheetObjects, true, true);
			if (sParam == "")
			{
				MnrWaitControl(false);
				return false;
			}
			sParam += "&" + FormQueryString(formObj) + "&"
			+ ComGetPrefixParam(aryPrefix);
			//ComDebug(sParam);
			var sXml=sheetObj.GetSaveData("EES_MNR_0032GS.do", sParam);
			sheetObjects[0].LoadSaveData(sXml);
			formObj.f_gubuns.value="";
			break;
		case IBINSERT:      // saving
			break;
		case IBSEARCH_ASYNC01:
			if( ComGetObjText(formObj.vndr_seq) == "" ) {
				ComShowCodeMessage("MNR00172","Service Provider Seq ");
				ComSetFocus(formObj.vndr_seq);
				return false;
			}else{
				var sXml=MnrGetPartner(sheetObj,formObj.vndr_seq.value,"RPR");
				if(ComGetEtcData(sXml, "vndr_seq") != null){
					//setting Vender nm
					formObj.vndr_seq.value=ComLpad(formObj.vndr_seq,6,"0");
					ComSetObjValue(formObj.vndr_nm, ComGetEtcData(sXml, "vndr_lgl_eng_nm"));
				}else{
					ComShowCodeMessage("MNR00005", "Service Provider");
					ComSetObjValue(formObj.vndr_nm, "");
					ComSetObjValue(formObj.vndr_seq, "");
					ComSetFocus(formObj.vndr_seq);
				}
			}
			break;
	}
}
	function sheet1_OnSearchEnd(sheetObj, errMsg) {
	var formObj=document.form;
	var prefix="sheet1_";
	MnrWaitControl(false);
	nowLoad=0;
}
	function sheet1_OnSaveEnd(sheetObj, errMsg) {
	var formObj=document.form;
	if(formObj.f_cmd.value == MULTI)
	{
		if (errMsg == "") {
			ComShowCodeMessage("MNR00078");
			doActionIBSheet(sheetObjects[0],formObj,IBSEARCH);
		} else {
			ComShowCodeMessage("MNR00008",ErrMsg);
		}
	}
	nowLoad=0;
	MnrWaitControl(false);
}
	function sheet1_OnPopupClick(sheetObj, Row,Col){
	if (sheetObj.ColSaveName(Col) != "sheet1_rpr_rslt_dt") return;
	var cal=new ComCalendarGrid();
	cal.select(sheetObj, Row, Col, 'yyyy-MM-dd');
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
 * initializing Tab
 * setting Tab items.
 */
	function initTab(tabObj , tabNo) {
	switch(tabNo) {
	case 1:
		with (tabObj) {
		}
		break;
	}
}
/**
 * Event when clicking Tab
 * activating selected tab items.
 */
	function tab1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
{
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	objs[beforetab].style.display="none";
	//--------------- important --------------------------//
	objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	//------------------------------------------------------//
	beforetab=nItem;
}
	function eq_knd_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
	{
		form.eq_knd_cd_text.value = comboObj.GetText(parseInt(newIndex), 0);
	}
	function rpr_rslt_sts_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode)
	{
		form.rpr_rslt_sts_text.value = comboObj.GetText(parseInt(newIndex), 0);
	}
/**
 * handling process for input validation
 */
	function validateForm(sheetObj,formObj,sAction){
	with(formObj){
		//retrieving
		if(sAction==IBSEARCH)
		{
			if(eq_knd_cd.GetSelectIndex== "-1"){
				ComShowCodeMessage("MNR00036","EQ Type");
				ComSetFocus(formObj.combo_eq_knd_cd);
				return false;
			}
			if(fromcal.value.length <10){
				ComShowCodeMessage("MNR00036","W/O Issue Date");
				ComSetFocus(formObj.fromcal);
				return false;
			}
			if(tocal.value.length <10){
				ComShowCodeMessage("MNR00036","W/O Issue Date");
				ComSetFocus(formObj.tocal);
				return false;
			}
			// 2013-08-28 Recovery PQC test defects by J.H Han
			if(ComGetDaysBetween(fromcal.value, formObj.tocal.value) < 0){
					ComShowCodeMessage("MNR00366");
					ComClearSeparator(formObj.fromcal);
					ComSetFocus(formObj.fromcal);
					return;
			}
			var arrWoNo=formObj.mnr_ord_seq.value.split(",");
			if(arrWoNo!=""){
				for(i=0;i<arrWoNo.length;i++){
					if(isNaN(arrWoNo[i].substr(3)) || arrWoNo[i].substr(3)==""){
						ComShowCodeMessage("MNR00010","W/O No");
						return false;
					}
				}
			}
		}
		else if(sAction==IBSAVE)
		{
			var strClinetDate=ComGetNowInfo("ymd","").replace(/-/g,"");
			var rCnt=sheetObj.RowCount();
			// 2013-08-27 Recovery PQC test defects by J.H Han
			if(rCnt < 1){
				ComShowCodeMessage("MNR00030", "The data which to save");
				return false;
			}
			// 2013-08-27 Recovery PQC test defects by J.H Han	
			//checking whether saving or not saving
			if(!ComShowCodeConfirm("MNR00160",""))	{
				return false;
			}
			for(var i=1;i <= rCnt;i++)
			{
				//2. in case of Cost Detail Type == ''
				var strRprRsltDt=ComTrimAll(sheetObj.GetCellValue(i, "sheet1_rpr_rslt_dt")," ");
				if(strRprRsltDt == ""){
					strRprRsltDt=0;
				}
				if(!(strRprRsltDt <= strClinetDate))
				{
					ComShowCodeMessage("MNR00237");
					sheetObj.SelectCell(i, "sheet1_rpr_rslt_dt",true);
					return false;
				}
			}
		}
		return true;
	}
}
	function initControl() {
	//Axon handling event1. event catch
	var formObject=document.form;
//	axon_event.addListenerForm  ('blur',     'obj_deactivate',  formObject); 			  	
	//axon_event.addListenerFormat('focus',    'obj_activate',    formObject,	'agmt_no');     
	axon_event.addListenerFormat('keypress', 'obj_keypress', 	formObject);            	
	axon_event.addListenerFormat('change',	 'obj_change',	formObject); 					
}
	//Axon handling event2. handling event
	function obj_deactivate(){
	// 2013-08-28 Recovery PQC test defects by J.H Han
	// obj = event.srcElement;       
	// ComChkObjValid(event.srcElement); 
	var obj=ComGetEvent();
	var formObj=document.form;
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
			case "fromcal":
				ComAddSeparator(obj, "ymd");
				break;
			case "tocal":
				ComAddSeparator(obj, "ymd");
				break;
		}
	}
}
	function obj_activate(){
	var obj=ComGetEvent();
	if(obj.name != "agmt_no"){
		ComClearSeparator(ComGetEvent());
	} else {
		obj.style.imeMode="disabled" ;
	}
}
	function obj_change(){
	var obj=ComGetEvent();
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if ( ComTrim(obj.value) != "" ) {
		switch(ComGetEvent("name")) {
		case "vndr_seq":
			doActionIBSheet(sheetObj, formObj , IBSEARCH_ASYNC01);
			break;
		// 2013-08-28 Recovery PQC test defects by J.H Han	
		case "fromcal":
			if(ComGetDaysBetween(formObj.fromcal.value, formObj.tocal.value) < 0){
				ComShowCodeMessage("MNR00366");
				ComClearSeparator(formObj.fromcal);
				ComSetFocus(formObj.fromcal);
			}
			break;
		case "tocal":
			if(ComGetDaysBetween(formObj.fromcal.value, formObj.tocal.value) < 0){
				ComShowCodeMessage("MNR00366");
				ComClearSeparator(formObj.tocal);
				ComSetFocus(formObj.tocal);
			}
			break;
		}
	} else {
		switch(ComGetEvent("name")) {
			case "vndr_seq":
				formObj.vndr_nm.value="";
				break;
		}
	}
}
	
function obj_keypress(){
	obj=event.srcElement;
	if(obj.dataformat == null) return;
	window.defaultStatus=obj.dataformat;
	switch(obj.dataformat) {
	case "ymd":
	case "ym":
	case "hms":
	case "hm":
	case "jumin":
	case "saupja":
		ComKeyOnlyNumber(obj);
		break;
	case "int":
		ComKeyOnlyNumber(obj);
		break;
	case "float":
		ComKeyOnlyNumber(obj, "-.");
		break;
	case "eng":
		ComKeyOnlyAlphabet();
		break;
	case "engup":
		if(obj.name=="vndr_seq"){
			ComKeyOnlyNumber(obj);
		} else {
			ComKeyOnlyAlphabet('uppernum', '45');
		}
		break;
	case "engdn":
		ComKeyOnlyAlphabet('lower');
		break;
	}
}
