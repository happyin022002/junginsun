/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : ESM_BKG_1023.js
 *@FileTitle : Vessel Stowage Plan Transmit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends
 * @class ESM_BKG-1023 : business script for ESM_BKG-1023.
 */

var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var intervalId="";
var comboObjects=new Array();
var comboCnt=0;
var valCnt = "";
// Event handler processing by button click event  */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, document.form, IBSEARCH);
			break;
		case "btn_New":
			sheetObject.RemoveAll();
			formObject.reset();
			break;
		case "btn_DownExcel":
			doActionIBSheet(sheetObject, document.form, IBDOWNEXCEL);
			break;
		case "btn_Transmit":
			if (!sheetObjects[0].IsDataModified()) {
				ComShowCodeMessage("BKG00249"); // No Selected Row
				return false;
			}
			if(sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(),"clpt_ind_seq") > 1 && document.form.clpt_ind_seq.value==1){ // 동일한 캐나다 포트 더블 콜링하는경우 그 중에서도 첫 번째 포트를 선택한 경우에만 팝업창이 열리게 수정
					ComOpenPopup("ESM_BKG_1023_02.do?vvd="+document.form.vvd.value+"&vps_port_cd="+ sheetObjects[1].GetCellValue(sheetObjects[1].LastRow(),"vps_port_cd")+"&clpt_ind_seq="+document.form.clpt_ind_seq.value, 500, 200, "", "none", true); // 동일한 캐나다 포트를 2번이상 콜링할 경우 CRN을 선택하는 팝업창 open
			}else{
				doActionIBSheet(sheetObjects[0], document.form, MULTI);
			}
			break;
		case "btn_AmsReport":
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
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
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
    //MultiCombo초기화 
    for(var k=0;k<comboObjects.length;k++){
        initCombo(comboObjects[k],comboObjects[k].id);
    }
	initControl();
}
/**
 * registering initial event 
 */
function initControl() {
	DATE_SEPARATOR="-";
	var formObject=document.form;
	axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	
	//CA 인경우
	
	var customs = formObject.customs.value;
	if ( customs == "CA") {
		ComSetDisplay("btn_AmsReport",false);
		ComSetDisplay("excludeca",false);
		ComSetDisplay("excludeca_text",false);
		formObject.gscd.value = "ESM_BKG_1023_01GS.do"; // 캐나다인 경우 ESM_BKG_1023_01GS세팅
		axon_event.addListenerForm ('change', 'bkg_change', formObject);
	}else{
		formObject.gscd.value = "ESM_BKG_1023GS.do"; // // 미국인 경우 ESM_BKG_1023GS세팅
	}
	
}

	/**
	 * 콤보 Object를 comboObjects 배열에 등록
	 * @param combo_obj
	 * @returnn 
	 */
	function setComboObject(combo_obj) {
		comboObjects[comboCnt++]=combo_obj; 
	}

	/**
	 * Combo 기본 설정 
	 * param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
	 * 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
	* @param {object} combo 필수, 초기화하는 IBMultiCombo Object.
	* @param {String} comboId 필수,combo ID
	* @return 없음. 
	 */ 
	function initCombo(comboObj, comboNo) {
		with (comboObj) {
	 		if(comboObj.options.id == "disp_lastpol" ){ // Last Foreign POL 콤보박스
	 			SetMultiSelect(0);
	 			SetUseEdit(0);
 			}
		}
	}

/**
 * setting sheet initial values and header
 * param : sheetObj, sheetNo
 * adding case as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	var sheetID=sheetObj.id;
	switch (sheetID) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
        
      var HeadTitle1="|Sel.|Seq.|Container No.|Container\nOperator|L.POL|POL|POD|TP/SZ|Cargo Type|Stow\nPosition|IMO Class"
      + "|UN No.|Sent Time|VVD in Baplie|Customs Result|Original\nPOD|vsl_eng_nm|vsl_voy|crr_cd|tmp1|tmp2|search_vvd_cd|excludeca";
      var headCount=ComCountHeadTitle(HeadTitle1);

      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );

      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
      InitHeaders(headers, info);

      var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"ibflag" },
             {Type:"CheckBox",  Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"chk",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"seq" },
             {Type:"Text",      Hidden:0, Width:100,  Align:"Center",  ColMerge:1,   SaveName:"cntr_no",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"opr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"l_pol",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pol",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"sztp",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"fe",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:0,   SaveName:"sti_pos",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:80,   Align:"Center",  ColMerge:0,   SaveName:"imdg",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"unno",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"sent_time",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:90,   Align:"Center",  ColMerge:0,   SaveName:"vvd_baplie",	    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:130,  Align:"Center",  ColMerge:0,   SaveName:"cust_result",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:0, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"o_pod",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_eng_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"vsl_voy",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"crr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tmp1",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"tmp2",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"search_vvd_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
             {Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:0,   SaveName:"excludeca",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
       
		     InitColumns(cols);
		
		     SetEditable(1);
		     SetWaitImageVisible(0);
		     SetSheetHeight(420);
            }
		break;
	case "sheet2": // Last Foreign POL 콤보박스를 위한 시트
		with (sheetObj) {
	        var HeadTitle1="|tmp1|vps_port_cd|clpt_ind_seq|lastpol|lpol_clpt_ind_seq|";
	        var headCount=ComCountHeadTitle(HeadTitle1);
	        headCount=ComCountHeadTitle(HeadTitle1);
	        SetConfig( { SearchMode:2, MergeSheet:7, Page:20, FrozenCol:0, DataRowMerge:1 } );
	        var info    = { Sort:0, ColMove:0, HeaderCheck:1, ColResize:1 };
	        var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        InitHeaders(headers, info);

	        var cols = [ {Type:"Status",    Hidden:0,  Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"tmp1", 	   KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"vps_port_cd",  KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lastpol", KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	                     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:"lpol_clpt_ind_seq", KeyField:0,   CalcLogic:"",   Format:"",    PointCount:0,   UpdateEdit:0,   InsertEdit:0 }]
	         
	        InitColumns(cols);
			SetEditable(0);
			SetCountPosition(0);
			SetSheetHeight(280);
			SetVisible(0);
		}
		break;
	}
}
// handling sheet process
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj=sheetObjects[0];
	var gsCd = formObj.gscd.value;
	switch (sAction) {
	case IBSEARCH: 
		formObj.hidden_vvd.value = "";
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		if(disp_lastpol.GetItemCount() == 1){
			disp_lastpol.SetSelectIndex(0);
		}else if(disp_lastpol.GetItemCount() > 1 && valCnt == 0){
//			lastpol.SetSelectIndex(0);
			formObj.disp_lastpol.focus();
    		ComShowCodeMessage('BKG95001','check Last Foreign POL. There are more than the two ports.'); // "Please {?msg1} {?msg2}."
    		valCnt++;
		}
		formObj.f_cmd.value=SEARCH;
		ComOpenWait(true);
		var sXml=sheetObj.GetSearchData(gsCd, FormQueryString(formObj));
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		ComOpenWait(false);
		break;
	case SEARCH01:
		formObj.f_cmd.value=SEARCH01;
		var sXml=sheetObj.GetSearchData(gsCd, FormQueryString(formObj));
		ComXml2ComboItem(sXml, disp_lastpol,"tmp1", "tmp1");
		sheetObjects[1].LoadSearchData(sXml,{Sync:1});
		break;
	case MULTI: //Transmit
		if (!validateForm(sheetObj, formObj, sAction))
			return;
		formObj.f_cmd.value=MULTI;
		ComOpenWait(true, true);
		var sParam=ComGetSaveString(sheetObj) + "&" + FormQueryString(formObj)+"&vps_port_cd="+formObj.vps_port_cd.value+"&clpt_ind_seq="+formObj.clpt_ind_seq.value;
		var sXml=sheetObj.GetSaveData(gsCd, sParam);
		var key=ComGetEtcData(sXml, "KEY");
		intervalId=setInterval("doActionValidationResult(sheetObjects[0], '" + key + "');", 3000);
		break;
	case IBDOWNEXCEL:
		if (!validateForm(sheetObj, formObj, sAction))
			return;
//		sheetObjects[0].Down2Excel({HiddenColumn:1});
		
		sheetObjects[0].Down2Excel({DownCols: makeHiddenSkipCol(sheetObjects[0]), SheetDesign:1,Merge:1 });
		break;
	case IBSEARCH_ASYNC01: //Go to AMS Report
		if (!validateForm(sheetObj, formObj, sAction)) {
			return;
		}	
		var param = "?pgmNo=ESM_BKG_0041&eventFrom=fromBapLieScreen&vvd=" + formObj.vvd.value + "&lastPol=" + formObj.lastpol.value;
		ComOpenWindowCenter("ESM_BKG_0041_POP.do" + param, "ESM_BKG_0041", 1210, 660, false);
		break;
	}
}




/**
 * retrieving  BackEndJob result
 */
function doActionValidationResult(sheetObj, sKey) {
	var gsCd = document.form.gscd.value;
	var sXml=sheetObj.GetSearchData(gsCd+"?f_cmd=" + SEARCH03 + "&key=" + sKey);
	var sJbStsFlg=ComGetEtcData(sXml, "jb_sts_flg");
	// close waiting job in case error 
	if (!ComBkgErrMessage(sheetObj, sXml)) {
		clearInterval(intervalId);
		ComOpenWait(false);
		return;
	}
	if (sJbStsFlg == "SUCCESS") {
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowCodeMessage('BKG00101');
		// retrieving sheet1, sheet2 
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		return;
	} else if (sJbStsFlg == "FAIL") {
		//error
		clearInterval(intervalId);
		ComOpenWait(false);
		ComShowMessage(ComResultMessage(sXml));
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		if(formObj.vvd.value==""){
			ComShowCodeMessage("BKG00445","VVD") //"Please input {?msg1}."
			return false;
		} 
		if(formObj.disp_lastpol.value==""){
			ComShowCodeMessage("BKG00445","Last Foreign POL") //"Please input {?msg1}."
			return false;
		}
		break;
	case MULTI:
		if (sheetObjects[0].RowCount()== 0) {
			ComShowCodeMessage("BKG00889"); // No data found
			return false;
		}
		if (!sheetObj.IsDataModified()) {
			ComShowCodeMessage("BKG00249"); // No Selected Row
			return false;
		}
		if (!ComShowCodeConfirm("BKG06200", "Canada Baplie")){
			return false;
		}
		break;
	case IBDOWNEXCEL:
		if (sheetObjects[0].RowCount()== 0) {
			ComShowCodeMessage("COM132501"); // No data found
			return false;
		}
		break;
		
	}
	return true;
}
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var sheetMaxRow=0;
	var form=document.form;
	with (sheetObj) {
		sheetMaxRow=RowCount();
		if (sheetMaxRow > 0) {
			document.form.vsl_eng_nm.value=GetCellValue(1, "vsl_eng_nm");
			document.form.vsl_voy.value=GetCellValue(1, "vsl_voy");
			document.form.crr_cd.value=GetCellValue(1, "crr_cd");
		} else {
			form.vsl_eng_nm.value="";
			form.vsl_voy.value="";
			form.crr_cd.value="";
			ComShowCodeMessage("BKG08364"); // "The Bay Plan of the Last Foregin POL you selected does not exist. Please contact the PIC of Bay Plan".
		}
	}
}

/**
 * 폼 필드 변경시 이벤트
 * 
 * @return
 */
function bkg_change(){
    switch (ComGetEvent("name")) {
    	case "vvd":
    		valCnt = 0;
    		doActionIBSheet(sheetObjects[0],document.form,SEARCH01);
    		if(disp_lastpol.GetItemCount() >= 1 ){
    			disp_lastpol.SetSelectIndex(0);
    		}
			break;
    }
}   
/**
 * 콤보1 변경시 처리
 * @param comboObj
 * @param value
 * @param text
 * @return
 */ 
function disp_lastpol_OnChange(comboObj, OldIdx, OldTxt, OldCod, NewIdx, NewTxt, NewCod) {
	var findRow = sheetObjects[1].FindText("tmp1", NewCod);
	document.form.vps_port_cd.value = sheetObjects[1].GetCellValue(findRow,"vps_port_cd"); //캐나다 포트
	document.form.clpt_ind_seq.value = sheetObjects[1].GetCellValue(findRow,"clpt_ind_seq"); //캐나다 clpt_ind_seq
	document.form.lastpol.value = sheetObjects[1].GetCellValue(findRow,"lastpol"); // last foreign port
	document.form.lpol_clpt_ind_seq.value = sheetObjects[1].GetCellValue(findRow,"lpol_clpt_ind_seq"); // last foreign port's clpt_ind_seq
}


