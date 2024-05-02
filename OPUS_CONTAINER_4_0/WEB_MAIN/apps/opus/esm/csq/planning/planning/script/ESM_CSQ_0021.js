/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0021.js
*@FileTitle  : QTA Set up by Head Office
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  챙占승늘ヂ꼲ㅓ�졖�챗쨉짭챘쨋��챙쩍�씳モ�흹: [챙쨈�챗쨍째챠�™�]INIT=0; [챙탑�┚ヂ졖�ADD=1; [챙징째챠큄흸]SEARCH=2; [챘짝짭챙힋짚챠힋쨍챙징째챠큄흸]SEARCHLIST=3;
					[챙��챙혻��MODIFY=4; [챙�슿��졙�REMOVE=5; [챘짝짭챙힋짚챠힋쨍챙�슿��졙�REMOVELIST=6 [챘�뮤ㅓ�ㅲ�챙짼�챘짝짭]MULTI=7
					챗쨍째챠���챙�붋�ヂ뜯�챙占싯�챘짭쨍챙탑占시�믭옙챙��  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------챘�뮤ㅓэ옙흸 챙쩍�씳モ�흹챘힋��JSDoc챙占썩� 챙탑� 챘짠흸챘�쑣ㅓぢ맞�챙흹�왗��쨈챙�왙�챙쨋�씳ぢ겸궗챘占신�챙쩍�씳モ�흹챙탑��------------------*/
/**
 * @extends 
 * @class ESM_CSQ_0021 : ESM_CSQ_0021 챙�占시р�짹챙占썩� 챙흹�왗��흹 챠�™�챘짤쨈챙�뷂옙챙�왙�챙�슿��≤㈒���챘힋��챙�붴�챘짭쨈 챙힋짚챠占승�ヂ┑시�졖맡ヂΒ�챙혻�▣э옙�챠�◑벭モ�짚.
 */
/* 챗째흹챘째흹챙탑占�챙탑�샖р���*/
//챗쨀쨉챠�졖돤�졻�챙�붋�ヂ년궗챙��
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* 챘짼�왗�졖셌�옙쨈챘짝짯챙占승늘ヂ꼲ㅓ�졖맡ヂΒ�챘째�봤р���챙짼�챘짝짭챠�▦쑦ヅ졻� 챙占승늘ヂ꼲ㅓ�졖맡��쨍챘�쑣ㅓヅ맞�챙혻�▣э옙� */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "f_bse_tp_cd":
				f_bse_tp_cd_OnChange();
				setTradeCombo();
				break;
			case "btn_Retrieve": 
				doActionIBSheet(sheetObj, formObj, IBSEARCH);
				break;
			case "btn_Save":
				doActionIBSheet(sheetObj, formObj, IBSAVE);
				break;
			case "btn_Confirm":
				doActionIBSheet(sheetObj, formObj, MULTI01);
				break;
			case "btn_DownExcel":
				doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
				break;
			case "btn_LoadExcel":
				doActionIBSheet(sheetObj, formObj, IBLOADEXCEL);
				break;
			case "btn_DisResult":	// RHQ Distribute Result 챠흸占시р���
				doActionIBSheet(sheetObj, formObj, "DisResult");
				break;
			case "btn_QtaSimul":	// QTA simulation 챠흸占시р���
				doActionIBSheet(sheetObj, formObj, "QtaSimul");
				break;
		}
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(ComGetMsg("COM12111", "", ""));
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * IBSheet Object 챘짜쩌 챘째째챙�붋늘ヂ∴�챘�쑣궁ヂ∽옙
 * 챠�벬Γ����챘�뮤ㅓヂΒ�챠�◈�ヂぢ㈒モ�짚챙占썩� 챙占승셌ぢ닳�챙짼�챘짝짭챠�◈�챠�™�챙큄�씳ぢ겸궗 챙탑�챙占썩� 챘�◑�챘째째챙�붋늘ヂ∴�챘�뮤늘ヅ졻� 챠�앪�챘징흹챙�왖맡�졖ㅓヂΒ�챙쨋�씳ぢ겸궗챠�◈�챙�� 챙탑�챘�뮤�
 * 챘째째챙�붋늘э옙��챙�졙뮼�졖�챙�占시モ�짢챙�뷂옙 챙혻�▣э옙�
 */
function setSheetObject(sheet_obj){
   sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * IBSheet Object 챘짜쩌 챘째째챙�붋늘ヂ∴�챘�쑣궁ヂ∽옙
 * 챠�벬Γ����챘�뮤ㅓヂΒ�챠�◈�ヂぢ㈒モ�짚챙占썩� 챙占승셌ぢ닳�챙짼�챘짝짭챠�◈�챠�™�챙큄�씳ぢ겸궗 챙탑�챙占썩� 챘�◑�챘째째챙�붋늘ヂ∴�챘�뮤늘ヅ졻� 챠�앪�챘징흹챙�왖맡�졖ㅓヂΒ�챙쨋�씳ぢ겸궗챠�◈�챙�� 챙탑�챘�뮤�
 * 챘째째챙�붋늘э옙��챙�졙뮼�졖�챙�占시モ�짢챙�뷂옙 챙혻�▣э옙�
 */
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}

function loadPage(){
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-챙�뮴벭�얄� 챠�▦쑦ぢ꼲�챙�왖ㅓ�졻� 챠�◈㉲�녚�챙占승늘ヂ╈� 챘쨀��ぢ꼲�
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-챘짠�챙짠��ヂ㎮� 챠�▦쑦ぢ꼲�챙�왖ㅓ�졻� 챠�◈㉲�녚�챙쨋�씳ぢ겸궗
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	initControl();
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	toggleButtons();
	loadingMode=false;
	resizeSheet();
}

function initControl() {
	var formObj=document.form;
}

function initSheet(sheetObj, sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
				var HeadTitle1="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub Trade|R.Lane|Lane Bound|Trade Bound|RHQ|Load (TEU) Portion Setting|Load (TEU) Portion Setting|G.REV Portion Setting|G.REV Portion Setting";
				var HeadTitle2="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub Trade|R.Lane|Lane Bound|Trade Bound|RHQ|Past PFMC|Target|Past PFMC|Target";
				var headCount=ComCountHeadTitle(HeadTitle1);

				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text", 		Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text", 		Hidden:0, Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:105,   Align:"Right",   ColMerge:1,   SaveName:"gid_lod_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:110,   Align:"Right",   ColMerge:1,   SaveName:"lod_potn_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 },
				             {Type:"AutoSum",   Hidden:0, Width:105,   Align:"Right",   ColMerge:1,   SaveName:"gid_rev_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:110,   Align:"Right",   ColMerge:1,   SaveName:"rev_potn_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 } ];
   
				InitColumns(cols);
				SetSheetHeight(400);
				SetRangeBackColor(1,12,1,15,"#555555");
				SetEditable(1);
	      	}
			break;
	}
}
/**
 * 챘짤����째챙쩍짚챘쨀쨈 챠�◈�ヂぢ㈒э옙��챙�왖ㅓ�졻�챠�◑벭モ�짚.
 */
function initCombo(comboObj, comboId) {
	switch(comboObj.options.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				SetDropHeight(300);
			}
			break;
		case "f_ofc_vw_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(1);
			}
			break;
		default:
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(0);
			}
			break;
	}
}
/**
 * Sheet 챗쨈��ヂ졖�챠�앪�챘징흹챙�왖맡�졖�챙짼�챘짝짭
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR:          // 챠�™�챘짤쨈 챙혻�샖р�占�챙�뮴�
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0021GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3) {
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
			}
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
			if (arrXml.length > 5) {
				ComXml2ComboItem(arrXml[5], f_ob_div_cd, "code", "name");
			}
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], f_rhq_cd, "code", "name");
			setTradeCombo();
			ComOpenWait(false);
			break;
		case IBSEARCH:          // 챠�™�챘짤쨈 챙징째챠큄흸 챙�뮴�
			if (!validateForm(sheetObj, formObj, sAction)) {
				return false;
			}
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			toggleButtons();
			searchParams=FormQueryString(formObj);
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0021GS.do", searchParams);
			sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				sheetObj.SetColHidden("bse_qtr_cd",1);
			} else {
				sheetObj.SetColHidden("bse_qtr_cd",0);
			}
			var etcData=getEtcData(rtnXml);
			if ( sheetObj.SearchRows()== 0 ) {
				toggleButtons();
			} else if ( etcData["dataCnt"] != 0 ){
				toggleButtons("CONFIRM");
				setEditColor(sheetObj, "CONFIRM");
			} else {
				toggleButtons("SEARCH");
				setEditColor(sheetObj);
			}
			sheetObj.SetSumText(0, "ibflag","");
			sheetObj.SetSumText(0, "bse_yr","TOTAL");
			ComOpenWait(false);
			break;
		case IBSAVE:		// 챙혻���씸�
			//ratio챗째��100%챙占승맡�㎮궗 check
			if (!checkRatio(sheetObj)) return;
			if (sheetObj.IsDataModified()== false) {
				ComShowCodeMessage("CSQ00006");
		        return false;
		    } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI);
			var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
			var sXml = sheetObj.GetSaveData("ESM_CSQ_0021GS.do", searchParams + "&" + saveStr);
			var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			ComOpenWait(false);
			if (State == "S") {
				ComShowCodeMessage("CSQ00001", "Data");
			}
			break;
		case MULTI01:          // 챠�™�챘짤쨈 confirm챙�뮴�
			if (sheetObj.IsDataModified()== true) {
				ComShowCodeMessage("CSQ00030", "Confirm");
		        return false;
		    }
			if (ComShowConfirm (ComGetMsg("CSQ00012", "Confirm")) != 1) {
				return false;
		    }
			ComOpenWait(true);
			ComSetSearchParams("f_cmd", MULTI01);
			var sXml=sheetObj.GetSaveData("ESM_CSQ_0021GS.do", searchParams);
			ComOpenWait(false);
			var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
			if (State != "S") {
				ComShowMessage(ComResultMessage(sXml));
				return false;
			} else if (State == "S") {
				toggleButtons("CONFIRM");
				setEditColor(sheetObj, "CONFIRM");
				ComShowCodeMessage('CSQ00016', 'Data');
			}
			break;
		case IBDOWNEXCEL:		// 챙�붴�챙�╈궗 챘�뮤ㅓ�≤늘ヂ∴벭モ�흹
			ComOpenWait(true);
			sheetObj.MergeSheet=msNone;
			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
			sheetObj.MergeSheet=msHeaderOnly;
			ComOpenWait(false);
			break;
		case IBLOADEXCEL:		// 챙�붴�챙�╈궗 챙�붴�챘징흹챘�쑩�
			loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
			loadExcelTotFlg=true;		// 챠�™�챘짤쨈챙�뷂옙 Total Row 챙징쨈챙탑짭 챙�붋�ヂ뜯궗
			if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
				loadExcelExField="|bse_qtr_cd|lod_potn_rto|rev_potn_rto|";		// 챘쨔�왗ぢ듸옙 챙혻흹챙�◈�챠�™�챘�쑩�
			} else {
				loadExcelExField="|lod_potn_rto|rev_potn_rto|";		// 챘쨔�왗ぢ듸옙 챙혻흹챙�◈�챠�™�챘�쑩�
			}
			loadExcelAplyField="|lod_potn_rto|rev_potn_rto|";		// 챘째�챙�占�챠�™�챘�쑩�
        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
			break;
		case "DisResult":		// RHQ Distribute Result 챠흸占시р���
			if (sheetObj.IsDataModified()== true) {
				ComShowCodeMessage("CSQ00030", "RHQ Distribute Result");
		        return false;
		    }
			searchParams=FormQueryString(formObj);
			ComSetSearchParams("f_cmd", "");
			ComOpenWindow("ESM_CSQ_0022.do?" + searchParams,  window,  "dialogHeight:520px;dialogWidth:1100px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
			break;
		case "QtaSimul":		// QTA simulation 챠흸占시р���
			if (sheetObj.IsDataModified()== true) {
				ComShowCodeMessage("CSQ00030", "RHQ QTA Simulation");
		        return false;
		    }
			ComSetSearchParams("f_cmd", "");
			 ComOpenWindow("ESM_CSQ_0023.do?" + searchParams,  window,  "dialogHeight:560px;dialogWidth:1100px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
			break;
    }
}
/**
 * f_bse_yr챗째��챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸 period 챙占싯�year 챘쨀��ぢ꼲�
 */
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
 * f_bse_qtr_cd 챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸 period 챙占싯�week 챗쨍째챗째�왗ヂ년궗챗짼쩍
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
 * f_ofc_vw_cd 챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸 Trade 챙혻�▣ヂ냈늘ヂΒ�챙�╈�챠흸��
 */
function f_ofc_vw_cd_OnChange(obj, value, text) {
	setTradeCombo();
}
/**
 * 챙�왖졗�믭옙챘占신�Trade 챙�뷂옙 챠�◈늘モ�쨔챠�▦쑦ヅ졻� Trade 챙혻�▣ヂ냈�챗째���졖맡р꽓��р�흹 Combo Box 챙�╈�챠흸��
 */
function setTradeCombo() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
 	var trd_cd=ComGetObjValue(f_trd_cd);
    var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd);
    var bse_yr=ComGetObjValue(f_bse_yr);
	if(bse_yr !="" && bse_qtr_cd !="" ){
	 	var param="f_cmd=" + SEARCH02
	     + "&code_name=tradeControl"
	     + "&code_param=" 
	     + "&all_flag="
	     + "&" + FormQueryString(formObj);	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_trd_cd, "code", "name");
	 // 챘쨀��ぢ꼲시ワ옙흹 Combo box챙�뷂옙챙�왙�챙占승늘�졻�챙�왖졗�믭옙챘占신�챙쩍�씳モ�흹챙占싯�Index챘짜쩌 챗쨉짭챠�◈늘р�흹 챙�왖맡�믠�챠�◑벭モ�짚.
		var index=SearchIndex(f_trd_cd, trd_cd);
 		f_trd_cd.SetSelectIndex(index);
	}
}
/**
 * onChange event
 * f_trd_cd 챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸  f_lane_cd 챙쩍짚챘쨀쨈챙징째챠큄흸
 */	
 function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	 setLaneCombo();
}
 /**
  *   f_bse_yr, f_bse_qtr_cd, f_trd_cd 챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸  f_lane_cd, f_dir_cd 챙쩍짚챘쨀쨈챙징째챠큄흸
  */
 function setLaneCombo(){
	 	var formObj=document.form;
	 	var trd_cd=ComGetObjValue(f_trd_cd);	// trade code
	    var rlane_cd=ComGetObjValue(f_rlane_cd);
	    var dir_cd=ComGetObjValue(f_dir_cd);
		if (trd_cd != "All" && trd_cd != "") {	
		 	var param="f_cmd=" + SEARCH02
		     + "&code_name=rLaneControl,BoundControl"
		     + "&code_param=null,null" 
		     + "&all_flag=All,All"
		     + "&" + FormQueryString(formObj);	// Trade
		 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
			var arrXml=xmlStr.split("|$$|");
			if (arrXml.length > 0) ComXml2ComboItem(arrXml[0], f_rlane_cd, "code", "name");		
			if (arrXml.length > 1)ComXml2ComboItem(arrXml[1], f_dir_cd, "code", "name");
			// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
			var rlane_index=SearchIndex(f_rlane_cd, rlane_cd);
			var dir_index=SearchIndex(f_dir_cd, dir_cd);
			f_rlane_cd.SetSelectIndex(rlane_index);
			f_dir_cd.SetSelectIndex(dir_index);
		} else {
			f_rlane_cd.RemoveAll();
			f_rlane_cd.InsertItem(0, "All", "All");
			f_dir_cd.RemoveAll();
			f_dir_cd.InsertItem(0, "All", "All");
		}
 }
/**
 * 챠�™�챘짤쨈챙占싯�챘짧짢챘�쑣�챘짼�왗�졖셌モ�짚챙占싯�Enable/Disable 챙占썩� 챙짼�챘짝짭
 */
function toggleButtons(step) {
	ComBtnDisable("btn_Save");
	ComBtnDisable("btn_DownExcel");
	ComBtnDisable("btn_LoadExcel");
	ComBtnDisable("btn_Confirm");
	ComBtnDisable("btn_DisResult");
	ComBtnDisable("btn_QtaSimul");
	switch (step) {
		case "SEARCH":
			ComBtnEnable("btn_Save");
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_LoadExcel");
			ComBtnEnable("btn_Confirm");
			ComBtnEnable("btn_DisResult");
			ComBtnEnable("btn_QtaSimul");
			break;
		case "CONFIRM":
			ComBtnEnable("btn_DownExcel");
			ComBtnEnable("btn_DisResult");
			ComBtnEnable("btn_QtaSimul");
			break;
	}
}
/**
 * Sheet 챙占싯�Edit 챗째��ヅ졖Γ��흹 챗쨀쨀챙占싯�챙��걘�믭옙챙占썩� 챙짠���졻�챠�◑벭モ�짚.
 * Load Excel 챗쨀쩌 챗째�▣э옙쨈 챙�슿��≤�
 */
function setEditColor(sheetObj, step) {
	if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
		sheetObj.SetColHidden("bse_qtr_cd",1);
	} else {
		sheetObj.SetColHidden("bse_qtr_cd",0);
	}
	switch (step) {
		case "CONFIRM":
			sheetObj.SetRangeBackColor(sheetObj.HeaderRows(), 13, sheetObj.lastRow, 13,"#EFF0F3");
			sheetObj.SetRangeBackColor(sheetObj.HeaderRows(), 15, sheetObj.lastRow, 15,"#EFF0F3");
			break;
	}
}
/**
 * 챠�™�챘짤쨈 챠占승셌�얄�챘혻짜챗째�쇒р�占�챘흸����흹 챙흹혻챠큄짢챙�왖궁ぢ꿎궗챙짝占�챠�앪�챘징흹챙�왖맡�졖�챙짼�챘짝짭
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:
			var trd_cd=ComGetObjValue(f_trd_cd);
			if ( trd_cd == "All" || trd_cd == "") {
				ComShowCodeMessage("CSQ00013", "Trade");
				f_trd_cd.Focus();
				return false;
			}
    		break;
	}
	return true;
}
/**
 * f_bse_tp_cd 챘째�씳モ궗흸챙�붘녍э옙�왗モ�흸 qtr_cd, week 챘쨀��ぢ꼲�
 */
function f_bse_tp_cd_OnChange() {
	var formObj=document.form;
	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd[0]);
	var div_qtr=document.getElementById("div_qtr");
	var div_period=document.getElementById("div_period");
	if (bse_tp_cd == "Y") {
		div_qtr.style.display="none";
		div_period.style.display="none";
		f_bse_qtr_cd.SetVisible(0);
	} else {
		div_qtr.style.display="inline";
		div_period.style.display="inline";
		f_bse_qtr_cd.SetVisible(1);
	}
	period_change();
	setTradeCombo();
}

/**
 * 자식창의 ratio가 100을 초과하였을때 뺄간색표시, 에러메세지
 */ 
var validatesheetFn=function validatesheet(sheetObj,row,colName) {
		switch(colName) {
			case "lod_potn_rto":
				if(sheetObj.GetCellValue(row,colName) > 100){
					sheetObj.SetCellBackColor(row,colName,"#FF0000");
					msg="The ratio of Load Potion("+row+" row) is too high.\n"
						+" Please lower the ratio of Load Potion.\n"
						+"==================================================================================\n";
					return false;              
				}
				break;
			case "rev_potn_rto":
				if(sheetObj.GetCellValue(row,colName) > 100){
					sheetObj.SetCellBackColor(row,colName,"#FF0000");
					msg="The ratio of Rev Potion("+row+" row) is too high.\n"
						+" Please lower the ratio of Rev Potion.\n"
						+"==================================================================================\n";
					return false;              
				}
				break;
		}
		return true;
	}  

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
/* 챗째흹챘째흹챙탑占�챙탑�샖р��� 챘占쏙옙 */
