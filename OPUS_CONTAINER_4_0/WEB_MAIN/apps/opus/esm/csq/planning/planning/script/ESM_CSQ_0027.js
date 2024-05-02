/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0027.js
*@FileTitle  : QTA Set-up by RHQ (I/B Contract)
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
 * @class ESM_CSQ_0027 : ESM_CSQ_0027 �앹꽦���꾪븳 �붾㈃�먯꽌 �ъ슜�섎뒗 �낅Т �ㅽ겕由쏀듃瑜��뺤쓽�쒕떎.
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
	var sheetObject=sheetObjects[0];
	var formObj=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch(srcName) {
		case "f_bse_tp_cd":
			f_bse_tp_cd_OnChange();
			break;
		case "btn_Retrieve":
			doActionIBSheet(sheetObject, formObj, IBSEARCH);
			break;
		case "btn_Save":
			doActionIBSheet(sheetObject, formObj, IBSAVE);
			break;
		case "btn_Confirm":
			doActionIBSheet(sheetObject, formObj, MULTI01); 
			break;
		case "btn_Downexcel":
			if(sheetObject.RowCount() < 1){
				ComShowCodeMessage("COM132501");
	        } else{
	        	doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
	        }
			break;
		case "btn_Loadexcel":
			doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
			break;
		case "btn_DisResult":
			doActionIBSheet(sheetObject, formObj, "DisResult");
			break;
		case "btn_QtaSimul":
			doActionIBSheet(sheetObject, formObj, "QtaSimul");
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
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
	}
	toggleButtons("INIT");
	loadingMode=false;
	resizeSheet();
}
/**
 * f_bse_tp_cd 諛붾��덉쓣��qtr_cd, week 蹂�꼍
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
 	if (bse_tp_cd == "Y") {
 		f_bse_qtr_cd.SetEnable(0);
 	} else {
 		f_bse_qtr_cd.SetEnable(1);
 	}
	period_change();
	setTradeCombo();
}
/**
* f_bse_yr媛�諛붾��덉쓣��period ��year 蹂�꼍
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
 * f_bse_tp_cd,f_bse_qtr_cd,f_bse_yr媛�諛붾��덉쓣��trade肄ㅻ낫 settting
 */
function setTradeCombo() {
	 	var formObj=document.form;
	 	var trd_cd=ComGetObjValue(f_trd_cd);
	    var bse_qtr_cd=ComGetObjValue(f_bse_qtr_cd);
	    var bse_yr=ComGetObjValue(f_bse_yr);
	 	if(bse_qtr_cd !="" && bse_yr !=""){
		 	var param="f_cmd=" + SEARCH02
		     + "&code_name=tradeControl"
		     + "&code_param=" 
		     + "&all_flag="
		     + "&" + FormQueryString(formObj);	// Trade
		 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
		 	ComXml2ComboItem(xmlStr, f_trd_cd, "code", "name");		
			// 변경된 Combo box에서 이전선택된 코드의 Index를 구해서 세팅한다.
			var index=SearchIndex(f_trd_cd, trd_cd);
	 		f_trd_cd.SetSelectIndex(index);
	 	}
}
/**
 *   f_bse_yr, f_bse_qtr_cd, f_trd_cd 諛붾��덉쓣�� f_lane_cd, f_dir_cd 肄ㅻ낫議고쉶
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
			// 蹂�꼍��Combo box�먯꽌 �댁쟾�좏깮��肄붾뱶��Index瑜�援ы빐���명똿�쒕떎.
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
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
			with(sheetObj){
				var HeadTitle1="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub Trade|Lane|Lane Bound|Trade Bound|RHQ|Office|Load (TEU) Portion Setting|Load (TEU) Portion Setting|G.REV Portion Setting|G.REV Portion Setting";
				var HeadTitle2="STS|SEQ|Year|Quarter|N.OB/OB|Office View|Trade|Sub Trade|Lane|Lane Bound|Trade Bound|RHQ|Office|PFMC %|Target %|PFMC %|Target %";
				var headCount=ComCountHeadTitle(HeadTitle1);
				SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

				var info    = { Sort:0, ColMove:0, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"}, { Text:HeadTitle2, Align:"Center"} ];
				InitHeaders(headers, info);

				var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Seq",       Hidden:0, Width:35,   Align:"Center",  ColMerge:1,   SaveName:"seq",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
				if(loadExcelVal=="Y"){
					cols.push({Type:"Text",      Hidden:1, Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				}else{
					cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				}
				cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"ob_div_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:85,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:85,  Align:"Center",  ColMerge:1,   SaveName:"dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:85,  Align:"Center",  ColMerge:1,   SaveName:"conv_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"gid_lod_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"lod_potn_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 });
				cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"gid_rev_potn_rto",  KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
				cols.push({Type:"AutoSum",   Hidden:0, Width:100,   Align:"Right",   ColMerge:1,   SaveName:"rev_potn_rto",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, MinimumValue:0, MaximumValue:100 });
				
				InitColumns(cols);
			    SetEditable(1);
			    SetRangeBackColor(1,13,1,17,"#555555");
			    SetSheetHeight(400);
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
		var sXml=sheetObj.GetSearchData("ESM_CSQ_0027GS.do", FormQueryString(formObj));
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
		if (arrXml.length > 1)
			ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
		if (arrXml.length > 2)
			ComSetYearQta(arrXml[2]);
		if (arrXml.length > 3)
			ComXml2ComboItem(arrXml[3], f_rgn_ofc_cd, "code", "name");
		setTradeCombo();
		ComOpenWait(false);
		break;
	case IBSEARCH:          // �붾㈃ 議고쉶 ��
		if(ComGetObjValue(f_trd_cd) == ""){
			ComShowCodeMessage("CSQ00013",'Trade');
	        return false;
		}
		formObj.f_cmd.value=SEARCH;
		searchParams=FormQueryString(formObj);
		ComOpenWait(true);
		var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0027GS.do",searchParams);
		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
		if (ComGetObjValue(document.form.f_bse_tp_cd[0]) == "Y") {
			sheetObj.SetColHidden("bse_qtr_cd",1);
		} else {
			sheetObj.SetColHidden("bse_qtr_cd",0);
		}
		var etcData=getEtcData(rtnXml);
		if(etcData["dataCnt"] == 1 ){
			toggleButtons("AllConfirm");
		}else {
			toggleButtons("SEARCH");
		}
		if (sheetObj.SearchRows()== 0) {
			toggleButtons("INIT");
		}
		ComOpenWait(false);
		sheetObj.SetSumText(0, "ibflag","");
		sheetObj.SetSumText(0, "bse_yr","TOTAL");
		break;
	case IBLOADEXCEL:		// �묒� �낅줈��
		loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
		loadExcelTotFlg=true;		// �붾㈃��Total Row 議댁옱 �щ�
		if(ComGetObjValue(formObj.f_bse_tp_cd[0])=="Y")
			loadExcelExField="|bse_qtr_cd|lod_potn_rto|rev_potn_rto|";		// 鍮꾧탳 �쒖쇅 �꾨뱶
		else
			loadExcelExField="|lod_potn_rto|rev_potn_rto|";		// 鍮꾧탳 �쒖쇅 �꾨뱶
		loadExcelAplyField="|lod_potn_rto|rev_potn_rto|";				// 諛섏쁺 �꾨뱶
    	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
		break;
	case IBDOWNEXCEL:		// �묒� �ㅼ슫濡쒕뱶
		ComOpenWait(true);
		sheetObj.MergeSheet=msNone;
		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		sheetObj.MergeSheet=msHeaderOnly;
		ComOpenWait(false);
		break;
	case IBSAVE:          // �붾㈃ ��옣��
		//ratio媛�100%�몄� check
		if (!checkRatioForRHQ(sheetObj)) return;
		if (sheetObj.IsDataModified()== false) {
			ComShowCodeMessage("CSQ00006");
	        return false;
	    } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
			return false;
	    }
		ComOpenWait(true);
		ComSetSearchParams("f_cmd", MULTI);
		var saveStr=sheetObj.GetSaveString(false, true, "ibflag");
		var sXml = sheetObj.GetSaveData("ESM_CSQ_0027GS.do", searchParams + "&" + saveStr);
		var State= ComGetEtcData(sXml, ComWebKey.Trans_Result_Key);
		ComOpenWait(false);
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			return false;
		}else if(State == "S"){
			ComShowCodeMessage('CSQ00001','Data');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
	case MULTI01:          // �붾㈃ confirm��
		if (sheetObj.IsDataModified()== true) {
			ComShowCodeMessage("CSQ00030",'confirm');
	        return false;
		}
		if (ComShowConfirm (ComGetMsg('CSQ00012','Confirm')) != 1) {
			return false;
	    }
		ComOpenWait(true);
		ComSetSearchParams("f_cmd", MULTI01);
		var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0027GS.do",searchParams);
		var State=ComGetEtcData(rtnXml, ComWebKey.Trans_Result_Key);
		ComOpenWait(false);
		if(State != "S"){
			ComShowMessage(ComResultMessage(sXml));
			return false;
		}else if(State == "S"){
			ComShowCodeMessage('CSQ00016','Data');
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
		break;
		
	case "DisResult":		// RHQ Distribute Result 챠흸占시р���
		if (sheetObj.IsDataModified()== true) {
			ComShowCodeMessage("CSQ00030", "Office Distribute Result");
	        return false;
	    }
		searchParams=FormQueryString(formObj);
		ComSetSearchParams("f_cmd", "");
		ComOpenWindow("ESM_CSQ_0028.do?" + searchParams+ "&div_period=" + document.getElementById("div_period").innerHTML,  window,  "dialogHeight:520px;dialogWidth:1100px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
		break;
		
	case "QtaSimul":		// QTA simulation 챠흸占시р���
		if (sheetObj.IsDataModified()== true) {
			ComShowCodeMessage("CSQ00030", "Office QTA Simulation");
	        return false;
	    }
		ComSetSearchParams("f_cmd", "");
		ComOpenWindow("ESM_CSQ_0029.do?" + searchParams+ "&div_period=" + document.getElementById("div_period").innerHTML,  window,  "dialogHeight:560px;dialogWidth:1000px;center:yes;resizable:yes;scroll:yes;status:no;unadorned:yes;" , true);
		break;	
	}
}
 /**
 * onChange event
 * f_trd_cd 諛붾��덉쓣�� f_lane_cd 肄ㅻ낫議고쉶
 */	
 function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	 setLaneCombo();
}
 /**
  * �붾㈃��紐⑤뱺 踰꾪듉�ㅼ쓽 Enable/Disable ��泥섎━
  */
 function toggleButtons(step) {
 	switch (step) {
 		case "INIT":
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_Confirm");
 			ComBtnDisable("btn_Downexcel");
 			ComBtnDisable("btn_Loadexcel");
 			ComBtnDisable("btn_DisResult");
 			ComBtnDisable("btn_QtaSimul");
 			break;
 		case "SEARCH":
 			ComBtnEnable("btn_Save");
 			ComBtnEnable("btn_Downexcel");
 			ComBtnEnable("btn_Loadexcel");
 			ComBtnEnable("btn_Confirm");
 			ComBtnEnable("btn_DisResult");
 			ComBtnEnable("btn_QtaSimul");
 			break;
 		case "AllConfirm":
 			ComBtnDisable("btn_Save");
 			ComBtnDisable("btn_Confirm");
 			ComBtnEnable("btn_Downexcel");
 			ComBtnDisable("btn_Loadexcel");
  			ComBtnEnable("btn_DisResult");
  			ComBtnEnable("btn_QtaSimul");
 			break;
 	}
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
/* 媛쒕컻���묒뾽  ��*/
