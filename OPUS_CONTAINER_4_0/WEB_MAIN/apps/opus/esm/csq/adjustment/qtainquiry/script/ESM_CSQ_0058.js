/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0058.js
*@FileTitle  : QTA Inquiry_Quarterly Overall (Currently Updated)
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/
/****************************************************************************************
  �대깽��援щ텇 肄붾뱶: [珥덇린��INIT=0; [�낅젰]ADD=1; [議고쉶]SEARCH=2; [由ъ뒪�몄“��SEARCHLIST=3;
					[�섏젙]MODIFY=4; [��젣]REMOVE=5; [由ъ뒪�몄궘��REMOVELIST=6 [�ㅼ쨷泥섎━]MULTI=7
					湲고� �щ텇��臾몄옄�곸닔  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------�ㅼ쓬 肄붾뱶��JSDoc����留뚮뱾湲��꾪빐��異붽���肄붾뱶��------------------*/
/**
 * @extends
 * @class ESM_CSQ_0058 : ESM_CSQ_0058 �앹꽦���꾪븳 �붾㈃�먯꽌 �ъ슜�섎뒗 �낅Т �ㅽ겕由쏀듃瑜��뺤쓽�쒕떎.
 */

/* 媛쒕컻���묒뾽	*/
//怨듯넻�꾩뿭蹂�닔
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
/* 踰꾪듉�대┃�대깽�몃� 諛쏆븘 泥섎━�섎뒗 �대깽�명빖�ㅻ윭 �뺤쓽 */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObj=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
			case "btn_Retrieve":
				doActionIBSheet(sheetObj, formObj, IBSEARCH); 
				break;
			case "btn_DownExcel":
				if(sheetObj.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
		        } else{
		        	doActionIBSheet(sheetObj, formObj, IBDOWNEXCEL);
		        }
				break;
			case "btn_RawDataDownExcel":
				doActionIBSheet(sheetObj, formObj, "RawDataDownExcel");
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
* IBSheet Object 瑜�諛곗뿴濡��깅줉
* �ν썑 �ㅻⅨ ��ぉ�ㅼ쓣 �쇨큵泥섎━���꾩슂媛��덉쓣 ��諛곗뿴濡��대뒗 �꾨줈�몄뒪瑜�異붽������덈떎
* 諛곗뿴���뚯뒪 �곷떒���뺤쓽
*/
function setSheetObject(sheet_obj){
 sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* IBSheet Object 瑜�諛곗뿴濡��깅줉
* �ν썑 �ㅻⅨ ��ぉ�ㅼ쓣 �쇨큵泥섎━���꾩슂媛��덉쓣 ��諛곗뿴濡��대뒗 �꾨줈�몄뒪瑜�異붽������덈떎
* 諛곗뿴���뚯뒪 �곷떒���뺤쓽
*/
function setComboObject(combo_obj){
	comboObjects[comboCnt++]=combo_obj;
}
function loadPage(){
	var formObj=document.form;
	loadingMode=true;
	for(i=0;i<sheetObjects.length;i++){
		//khlee-�쒖옉 �섍꼍 �ㅼ젙 �⑥닔 �대쫫 蹂�꼍
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		//khlee-留덉�留��섍꼍 �ㅼ젙 �⑥닔 異붽�
		ComEndConfigSheet(sheetObjects[i]);
	}
	doActionIBSheet(sheetObjects[0], formObj, IBCLEAR);
	initControl();
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	ComBtnDisable("btn_DownExcel");
    ComBtnDisable("btn_RawDataDownExcel");
	loadingMode=false;
	resizeSheet();
}
function initControl() {
	var formObj=document.form;
	axon_event.addListenerForm("KeyUp",		"obj_KeyUp",	formObj);
	axon_event.addListenerForm("change",	"obj_change",	formObj);
	axon_event.addListenerForm("click",		"obj_click",	formObj);
}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="SEQ|Year|Quarter|Office View|RHQ|Office|Trade|Sub Trade|Lane|Lane\nBound|Month|Week|VVD|Supply|Load|L/F|G.REV|G.RPB|G.RPB|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1} );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"lod_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ldf_rto",       KeyField:0,   CalcLogic:"|lod_qty|/|fnl_bsa_capa|*100",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"g_rev",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grpb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",     Hidden:0,  Width:250,  Align:"Right",   ColMerge:1,   SaveName:"grpb_decimal",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_c",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_c",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cmcb",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cmcb",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cmpb",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cmpb",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
	       
	        	InitColumns(cols);
	        	SetEditable(1);
	        	SetRangeBackColor(0, 14, 0, 18,"#555555");
	        	SetRangeBackColor(0, 23, 0, 26,"#555555");
	        	SetSheetHeight(350);
	      }
	      break;
	}
}
/**
* 硫�떚肄ㅻ낫 ��ぉ���ㅼ젙�쒕떎.
*/
function initCombo(comboObj, comboId) {
	switch(comboObj.options.id) {
		case "f_bse_yr":
		case "f_bse_qtr_cd":
			with (comboObj) {
				SetDropHeight(300);
				SetSelectIndex(1);
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
* Sheet 愿�젴 �꾨줈�몄뒪 泥섎━
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR:          // �붾㈃ �묒냽 ��
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0058GS.do", FormQueryString(formObj));
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 2)
				ComSetYearQta(arrXml[2]);
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_ofc_lvl, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_rhq_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 6)
				ComXml2ComboItem(arrXml[6], f_dir_cd, "code", "name");
			ComOpenWait(false);
			break;
		case IBSEARCH:          // �붾㈃ 議고쉶 ��
			if (!validateForm(sheetObj, formObj, sAction)) return;
			sheetObj.SetWaitImageVisible(1);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("ESM_CSQ_0058GS.do", FormQueryString(formObj), {Sync:1});
			break;
		case IBDOWNEXCEL:		// �묒� �ㅼ슫濡쒕뱶
			ComOpenWait(true);
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
		case "RawDataDownExcel":		// Raw Data �묒� �ㅼ슫濡쒕뱶
			ComOpenWait(true);
			var param="f_cmd="         + COMMAND01
			          + "&f_bse_tp_cd="  + ComGetObjValue(formObj.f_bse_tp_cd)
			          + "&f_bse_yr="     + ComGetObjValue(f_bse_yr)
			          + "&f_bse_qtr_cd=" + ComGetObjValue(f_bse_qtr_cd)
			          + "&f_ofc_vw_cd="  + ComGetObjValue(f_ofc_vw_cd)
			          + "&f_ofc_lvl="    + ComGetObjValue(f_ofc_lvl)
			          + "&f_chk_week=W"
			          + "&f_chk_vvd=V"
			          + "&f_chk_decimal=D";
			document.location.href="ESM_CSQ_0058DL.do?" + param;
			ComOpenWait(false);
			break;
  }
}
/**
* 議고쉶 �⑥닔瑜��댁슜�섏뿬 議고쉶媛��꾨즺�섍퀬 諛쒖깮�섎뒗 Event
*
* @param sheetObj
* @param ErrMsg
*/
function sheet1_OnSearchEnd(sheetObj, ErrMsg){
	sheetObj.SetWaitImageVisible(0);
	var formObj=document.form;
	var ofc_lvl=ComGetObjValue(f_ofc_lvl);
	var chk_week=formObj.f_chk_week.checked;
	var chk_vvd=formObj.f_chk_vvd.checked;
	var chk_decimal=formObj.f_chk_decimal.checked;
	if ( ofc_lvl == "01" ) {
		sheetObj.SetColHidden("rhq_cd",1);
		sheetObj.SetColHidden("rgn_ofc_cd",1);
		sheetObj.SetColHidden("ldf_rto",0);
		var num=(sheetObj.GetSumValue(0, "lod_qty") / sheetObj.GetSumValue(0, "fnl_bsa_capa") * 100).toFixed(2);
		sheetObj.SetSumText(0, "ldf_rto",num);
	} else if ( ofc_lvl == "02" ) {
		sheetObj.SetColHidden("rhq_cd",0);
		sheetObj.SetColHidden("rgn_ofc_cd",1);
		sheetObj.SetColHidden("ldf_rto",1);
		sheetObj.SetSumText(0, "fnl_bsa_capa","");
	} else if ( ofc_lvl == "03" ) {
		sheetObj.SetColHidden("rhq_cd",0);
		sheetObj.SetColHidden("rgn_ofc_cd",0);
		sheetObj.SetColHidden("ldf_rto",1);
		sheetObj.SetSumText(0, "fnl_bsa_capa","");
	}
	sheetObj.SetSumText(0, "grpb",ComAddComma((sheetObj.GetSumValue(0, "g_rev")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "grpb_decimal",ComAddComma((sheetObj.GetSumValue(0, "g_rev")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	sheetObj.SetSumText(0, "pa_cmcb",ComAddComma((sheetObj.GetSumValue(0, "pa_cm_c") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
 	sheetObj.SetSumText(0, "ra_cmcb",ComAddComma((sheetObj.GetSumValue(0, "ra_cm_c") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
 	sheetObj.SetSumText(0, "pa_cmpb",ComAddComma((sheetObj.GetSumValue(0, "pa_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
 	sheetObj.SetSumText(0, "ra_cmpb",ComAddComma((sheetObj.GetSumValue(0, "ra_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	if ( chk_week ) {
		sheetObj.SetColHidden("bse_wk",0);
	} else {
		sheetObj.SetColHidden("bse_wk",1);
	}
	if ( chk_vvd ) {
		sheetObj.SetColHidden("vvd",0);
	} else {
		sheetObj.SetColHidden("vvd",1);
	}
	if ( chk_decimal ) {
		sheetObjects[0].SetColHidden("grpb",1);
		sheetObjects[0].SetColHidden("grpb_decimal",0);
	} else {
		sheetObjects[0].SetColHidden("grpb",0);
		sheetObjects[0].SetColHidden("grpb_decimal",1);
	}
	sheetObj.SetSumText(0, "seq","");
	sheetObj.SetSumText(0, "bse_yr","TOTAL");
	if(sheetObj.RowCount()> 0){
		ComBtnEnable("btn_DownExcel");
		ComBtnEnable("btn_RawDataDownExcel");
	}else{
		ComBtnDisable("btn_DownExcel");
		ComBtnDisable("btn_RawDataDownExcel");
	}
}
/**
* f_ofc_lvl 諛붾��덉쓣��event 泥섎━
*/
function f_ofc_lvl_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	 var formObj=document.form;
	 var div_rhq=document.getElementById("div_rhq");
	 var div_ofc=document.getElementById("div_ofc");
	 if ( NewCd == "01" ) {	//Head Office ����
		 div_rhq.style.display="none";
		 div_ofc.style.display="none";
		 f_rhq_cd.SetVisible(0);
		 f_rgn_ofc_cd.SetVisible(0);
	 } else if ( NewCd == "02" ) {	//RHQ ����
		 div_rhq.style.display="inline";
		 div_ofc.style.display="none";
		 f_rhq_cd.SetVisible(1);
		 f_rgn_ofc_cd.SetVisible(0);
	 } else {	// Office ����
		 div_rhq.style.display="inline";
		 div_ofc.style.display="inline";
		 f_rhq_cd.SetVisible(1);
		 f_rgn_ofc_cd.SetVisible(1);
	 }
}
/**
* f_bse_yr媛�諛붾��덉쓣��office 肄ㅻ낫 �뗮똿
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
 * f_bse_qtr_cd 諛붾��덉쓣��period ��week 湲곌컙蹂�꼍
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
* f_rhq_cd 諛붾��덉쓣��office 肄ㅻ낫 �뗮똿
*/
function f_rhq_cd_OnChange(obj, value, text) {
	office_change();
}
/**
* f_trd_cd 諛붾��덉쓣��rlane 肄ㅻ낫 �뗮똿
*/
function f_trd_cd_OnChange(obj, value, text) {
	rlane_change();
}
/**
 * onChange event
 * f_rhq_cd 諛붾��덉쓣�� f_rgn_ofc_cd 肄ㅻ낫議고쉶
 */
function office_change() {
	var formObj=document.form;
	var rhq_cd=ComGetObjValue(f_rhq_cd);	
	if (rhq_cd != "All") {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=officeForPlan"
	     + "&code_param=" + rhq_cd
	     + "&all_flag=All";	// 
 	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rgn_ofc_cd, "code", "name");
	} else {
		f_rgn_ofc_cd.RemoveAll();
		f_rgn_ofc_cd.InsertItem(0, "All", "All");
	}
 	f_rgn_ofc_cd.SetSelectIndex(0);
}
/**
* f_bse_yr, f_ofc_vw_cd, f_trd_cd媛�諛붾��덉쓣��rlane 肄ㅻ낫 setting
*/
function rlane_change() {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	var param="";
	var bse_tp_cd=ComGetObjValue(formObj.f_bse_tp_cd);
	var bse_yr=ComGetObjValue(f_bse_yr);
	var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd);
	var ofc_vw_cd=ComGetObjValue(f_ofc_vw_cd);
	var trd_cd=ComGetObjValue(f_trd_cd);
	var rlane_cd=ComGetObjValue(f_rlane_cd);
	if ( trd_cd != "" && trd_cd != "All" ) {
		param=trd_cd
			  + "|" + bse_tp_cd
              + "|" + bse_yr
              + "|" + bse_qtr_cd;
		var sXml=sheetObj.GetSearchData("CommonGS.do", "f_cmd="+ SEARCH01 + "&code_name=rLane&code_param=" + param + "&all_flag=All");
		ComXml2ComboItem(sXml, f_rlane_cd, "code", "name");
		// 蹂�꼍��Combo box�먯꽌 �댁쟾�좏깮��肄붾뱶��Index瑜�援ы빐���명똿�쒕떎.
		var rlane_index=SearchIndex(f_rlane_cd, rlane_cd);
		f_rlane_cd.SetSelectIndex(rlane_index);
	} else {
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
		f_rlane_cd.SetSelectIndex(0);
	}
}
/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
	var f_bse_tp_cd  = ComGetObjValue(formObj.f_bse_tp_cd);
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    param="f_cmd=" + SEARCH01
     + "&code_name=trade"
     + "&code_param="  + f_bse_tp_cd + "|" + f_bse_yr + "|" + f_bse_qtr_cd
     + "&all_flag=All";    // Trade
    var sXml=sheetObj.GetSearchData("CommonGS.do",param);
    if (sXml != "") {
        ComXml2ComboItem(sXml, f_trd_cd, "code", "name");
        f_trd_cd.SetSelectIndex(0);
    } else {
        f_trd_cd.RemoveAll();
        f_trd_cd.InsertItem(0, "All", "All");
        f_trd_cd.SetSelectIndex(0);
    }
}
/**
 * 議고쉶議곌굔 �낅젰����泥섎━
 */
function obj_KeyUp() {
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcMaxLength=ComGetEvent("maxlength");
	var srcValue=ComGetEvent("value");
	if ( ComChkLen(srcValue, srcMaxLength) == "2" ) {
		ComSetNextFocus();
	}
}
function obj_change() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	switch(srcName) {
		case "f_fm_wk":
			if ( formObj.f_fm_wk.value != "" ) {
				// Week �뺤떇 泥댄겕
				var ret=ComIsWeek(formObj.f_fm_wk.value);
				if ( !ret ) {
					ComShowCodeMessage("COM12187", "WW");
					formObj.f_fm_wk.value="";
				} else {
					formObj.f_fm_wk.value=ComLpad(formObj.f_fm_wk.value, 2, '0');
					if ( formObj.f_to_wk.value != "" ) {
						// To Week 媛�From Week 蹂대떎 �곗� 泥댄겕
						if ( formObj.f_fm_wk.value > formObj.f_to_wk.value ) {
							ComShowCodeMessage("COM12133", "To week", "from week", "later");
							formObj.f_to_wk.value="";
							formObj.f_to_wk.focus();
						}
					}
				}
			}
			break;
		case "f_to_wk":
			if ( formObj.f_to_wk.value != "" ) {
				// Week �뺤떇 泥댄겕
				var ret=ComIsWeek(formObj.f_to_wk.value);
				if ( !ret ) {
					ComShowCodeMessage("COM12187", "WW");
					formObj.f_to_wk.value="";
				} else {
					formObj.f_to_wk.value=ComLpad(formObj.f_to_wk.value, 2, '0');
					if ( formObj.f_fm_wk.value != "" ) {
						// To Week 媛�From Week 蹂대떎 �곗� 泥댄겕
						if ( formObj.f_fm_wk.value > formObj.f_to_wk.value ) {
							ComShowCodeMessage("COM12133", "To week", "from week", "later");
							formObj.f_to_wk.value="";
							formObj.f_to_wk.focus();
						}
					}
				}
			}
			break;
		case "f_fm_mon":
			if ( formObj.f_fm_mon.value != "" ) {
				// Month �뺤떇 泥댄겕
				var ret=ComIsMonth(formObj.f_fm_mon.value);
				if ( !ret ) {
					ComShowCodeMessage("COM12187", "MM");
					formObj.f_fm_mon.value="";
					formObj.f_fm_mon.focus();
				} else {
					formObj.f_fm_mon.value=ComLpad(formObj.f_fm_mon.value, 2, '0');
					if ( formObj.f_to_mon.value != "" ) {
						// To Month 媛�From Month 蹂대떎 �곗� 泥댄겕
						if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
							ComShowCodeMessage("COM12133", "To month", "from month", "later");
							formObj.f_to_mon.value="";
							formObj.f_to_mon.focus();
						}
					}
				}
			}
			break;
		case "f_to_mon":
			if ( formObj.f_to_mon.value != "" ) {
				// Month �뺤떇 泥댄겕
				var ret=ComIsMonth(formObj.f_to_mon.value);
				if ( !ret ) {
					ComShowCodeMessage("COM12187", "MM");
					formObj.f_to_mon.value="";
					formObj.f_to_mon.focus();
				} else {
					formObj.f_to_mon.value=ComLpad(formObj.f_to_mon.value, 2, '0');
					if(formObj.f_fm_mon.value != ""){
						// To Month 媛�From Month 蹂대떎 �곗� 泥댄겕
						if ( formObj.f_fm_mon.value > formObj.f_to_mon.value ) {
							ComShowCodeMessage("COM12133", "To month", "from month", "later");
							formObj.f_to_mon.value="";
							formObj.f_to_mon.focus();
						}
					}
				}
			}
			break;
	} // end switch
}
function obj_click() {
	var formObj=document.form;
	var srcName=ComGetEvent("name");
	with(formObj) {
		switch(srcName) {
			case "chk_week":
				if ( chk_week.checked ) {
					div_monwk.innerHTML="Week";
					f_fm_mon.value="";
					f_to_mon.value="";
					div_wk.style.display="inline";
					div_mon.style.display="none";
				} else {
					div_monwk.innerHTML="Month";
					f_fm_wk.value="";
					f_to_wk.value="";
					div_wk.style.display="none";
					div_mon.style.display="inline";
				}
				break;
		}
	}
}
/**
* �붾㈃ �쇱엯�κ컪����븳 �좏슚�깃�利��꾨줈�몄뒪 泥섎━
*/
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:  // �붾㈃ 議고쉶��
			var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd); //Quarter
			var period_fm="";
			var period_to="";
			if ( formObj.chk_week.checked ) {
				period_fm=ComGetObjValue(formObj.f_fm_wk);
				period_to=ComGetObjValue(formObj.f_to_wk);
				if ( period_fm != "" || period_to != "" ) {
					if (   period_fm == ""
						|| period_to == ""
						|| period_fm < qtaWeekArr[bse_qtr_cd][0].substring(3, 5)
						|| period_to > qtaWeekArr[bse_qtr_cd][1].substring(3, 5) ) {
						ComShowCodeMessage('CSQ00025', bse_qtr_cd);
						return false;
					}
				}
			} else {
				period_fm=ComGetObjValue(formObj.f_fm_mon);
				period_to=ComGetObjValue(formObj.f_to_mon);
				if ( period_fm != "" || period_to != "" ) {
					if (   period_fm == ""
						|| period_to == ""
						|| period_fm < qtaMonArr[bse_qtr_cd][0]
						|| period_to > qtaMonArr[bse_qtr_cd][1] ) {
						ComShowCodeMessage('CSQ00025', bse_qtr_cd);
						return false;
					}
				}
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
/* 媛쒕컻���묒뾽  ��*/
