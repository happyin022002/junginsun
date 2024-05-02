/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0038.js
*@FileTitle  : 
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
 * @class ESM_CSQ_0038 : ESM_CSQ_0038 �앹꽦���꾪븳 �붾㈃�먯꽌 �ъ슜�섎뒗 �낅Т �ㅽ겕由쏀듃瑜��뺤쓽�쒕떎.
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
			case "btn_Retrieve":
				doActionIBSheet(sheetObject, formObj, IBSEARCH);
				break;
			case "btn_DownExcel":
				if(sheetObject.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					doActionIBSheet(sheetObject, formObj, IBDOWNEXCEL);
				}
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
	initcontrol();
	loadingMode=false;
	resizeSheet();
}
function initcontrol(){
		var formObj=document.form;
		axon_event.addListenerForm  ("KeyUp",    "obj_KeyUp", 	formObj);
		axon_event.addListenerForm  ('change', 	 'obj_change',  formObj); 
	    axon_event.addListenerFormat('keypress', 'obj_keypress',formObj); //- �ㅻ낫���낅젰�좊븣
}
/**
* 議고쉶議곌굔 �낅젰����泥섎━
*/
function obj_KeyUp() {
    var formObject=document.form;
    var srcName=ComGetEvent("name");
    var srcMaxLength=ComGetEvent("maxlength");
    var srcValue=ComGetEvent("value");
    if (ComChkLen(srcValue, srcMaxLength) == "2") {
    	ComSetNextFocus();
    }
} 
     /**
	 * HTML Control��onkeypress�대깽�몄뿉���ㅻ낫���낅젰���쒖뼱�쒕떎.
	 **/
     function obj_keypress(){
		switch(ComGetEvent("dataformat")){
    	case "num":
		        //�レ옄留뚯엯�ν븯湲�
		        ComKeyOnlyNumber(ComGetEvent());
		        break;
	    }
	}
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetNo) {
		case 1:		//sheet1 init
		    with(sheetObj){
	        	var HeadTitle1="SEQ|Year|Office View|RHQ|Office|Trade|Sub Trade|Lane|Lane Bound|Month|Supply|Load|L/F|G.REV|G.RPB|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";
	        	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

	        	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
	        	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
	        	InitHeaders(headers, info);

	        	var cols = [ {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Text",      Hidden:0,  Width:75,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             // Set hidden for column Trade Direction.
	        	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_mon",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:"fnl_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"lod_qty",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Float",     Hidden:0,  Width:80,   Align:"Right",   ColMerge:1,   SaveName:"ldf_rto",       KeyField:0,   CalcLogic:"|lod_qty|/|fnl_bsa_capa|*100",Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"g_rev",         KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
	        	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"grpb",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
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
	        	SetRangeBackColor(0, 11,0, 14,"#555555");
	        	SetRangeBackColor(0, 19,0, 22,"#555555");
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
* f_bse_qtr_cd 諛붾��덉쓣��period ��week 湲곌컙蹂�꼍
*/
function f_bse_qtr_cd_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
* f_bse_yr媛�諛붾��덉쓣��office肄ㅻ낫 �뗮똿
*/
function f_bse_yr_OnChange(obj, value, text) {
	period_change();
	setTradeCombo();
}
/**
 * onChange event
 * f_rhq_cd 諛붾��덉쓣�� f_rgn_ofc_cd 肄ㅻ낫議고쉶
 */	
function f_rhq_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	if (NewCd != "All") {	
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=officeForPlan"
	     + "&code_param=" + NewCd
	     + "&all_flag=All";	// Trade
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rgn_ofc_cd, "code", "name");
	} else {
		f_rgn_ofc_cd.RemoveAll();
		f_rgn_ofc_cd.InsertItem(0, "All", "All");
	}
 	comboObjects[5].SetSelectIndex(0);
}
/**
 * onChange event
 * f_trd_cd 諛붾��덉쓣�� f_lane_cd 肄ㅻ낫議고쉶
 */	
function f_trd_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var f_bse_tp_cd  = "Q";
	var f_bse_yr 	 = ComGetObjValue(formObj.f_bse_yr);
	var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
	if (NewCd != "All") {	
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLane"
	     + "&code_param="+NewCd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=All";
 	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
	} else {
		f_rlane_cd.RemoveAll();
		f_rlane_cd.InsertItem(0, "All", "All");
	}
 	comboObjects[7].SetSelectIndex(0);
}

/**
 * f_bse_yr, f_bse_qtr_cd  바뀌었을때 f_trd_cd 콤보조회
 */
function setTradeCombo() {
    var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
	var f_bse_tp_cd  = "Q";
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
* Sheet 愿�젴 �꾨줈�몄뒪 泥섎━
*/
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBCLEAR:          // �붾㈃ �묒냽 ��
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=INIT;
			var sXml=sheetObj.GetSearchData("ESM_CSQ_0038GS.do", FormQueryString(formObj));
			//var State=ComGetEtcData(sXml, ComWebKey.Trans_Result_Key); 
			var arrXml=sXml.split("|$$|");
			if (arrXml.length > 0)
				ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
			if (arrXml.length > 1)
				ComXml2ComboItem(arrXml[1], f_ofc_lvl, "code", "name");
			if (arrXml.length > 2)
				ComXml2ComboItem(arrXml[2], f_rhq_cd, "code", "name");
			if (arrXml.length > 3)
				ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
			if (arrXml.length > 4)
				ComXml2ComboItem(arrXml[4], f_dir_cd, "code", "name");
			if (arrXml.length > 5)
				ComXml2ComboItem(arrXml[5], f_bse_qtr_cd, "code", "name");
			if (arrXml.length > 6)
				ComSetYearQta(arrXml[6]);
			ComOpenWait(false);
			break;
		case IBSEARCH:          //�붾㈃ 議고쉶��
			sheetObj.SetWaitImageVisible(0);
			if (!validateForm(sheetObj, formObj, sAction)) return;
			ComOpenWait(true);	
			formObj.f_cmd.value=SEARCH;
			var rtnXml=sheetObj.GetSearchData("ESM_CSQ_0038GS.do",FormQueryString(formObj));
    		sheetObj.LoadSearchData(rtnXml,{Sync:1} );
			if (ComGetObjValue(f_ofc_lvl) == "01") {
				  sheetObjects[0].SetColHidden("rhq_cd",1);
				  sheetObjects[0].SetColHidden("rgn_ofc_cd",1);
				  sheetObjects[0].SetColHidden("ldf_rto",0);
			} else if (ComGetObjValue(f_ofc_lvl) == "02"){
				  sheetObjects[0].SetColHidden("rhq_cd",0);
				  sheetObjects[0].SetColHidden("rgn_ofc_cd",1);
				  sheetObjects[0].SetColHidden("ldf_rto",1);
			}else{
				  sheetObjects[0].SetColHidden("rhq_cd",0);
				  sheetObjects[0].SetColHidden("rgn_ofc_cd",0);
				  sheetObjects[0].SetColHidden("ldf_rto",1);
			}
			ComOpenWait(false);
			break;
		case IBDOWNEXCEL:		// �묒� �ㅼ슫濡쒕뱶
			ComOpenWait(true);
			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
			ComOpenWait(false);
			break;
  }
}
/**
 *議고쉶 �⑥닔瑜��댁슜�섏뿬 議고쉶媛��꾨즺�섍퀬 諛쒖깮�섎뒗 Event
 * @param sheetObj
 * @param ErrMsg
 */
 function sheet1_OnSearchEnd(sheetObj, ErrMsg){
 	sheetObj.SetSumText(0, "seq","");
 	sheetObj.SetSumText(0, "bse_yr","TOTAL");
	if(comboObjects[3].GetSelectCode()== "01"){
		if(sheetObj.GetSumValue(0, "fnl_bsa_capa")!=0)
			var num=(sheetObj.GetSumValue(0, "lod_qty")/sheetObj.GetSumValue(0, "fnl_bsa_capa")*100).toFixed(2);
		else
			var num=0.00;
		sheetObj.SetSumText(0, "ldf_rto",num);
	}else{
		sheetObj.SetSumText(0, "fnl_bsa_capa","");
	}
	//�④� total媛�set
	if(sheetObj.GetSumValue(0, "lod_qty")!=0){
		sheetObj.SetSumText(0, "grpb",AddComma(Math.round(sheetObj.GetSumValue(0, "g_rev")/sheetObj.GetSumValue(0, "lod_qty"))));
		sheetObj.SetSumText(0, "pa_cmcb",AddComma(Math.round(sheetObj.GetSumValue(0, "pa_cm_c")/sheetObj.GetSumValue(0, "lod_qty"))));
		sheetObj.SetSumText(0, "ra_cmcb",AddComma(Math.round(sheetObj.GetSumValue(0, "ra_cm_c")/sheetObj.GetSumValue(0, "lod_qty"))));
		sheetObj.SetSumText(0, "pa_cmpb",AddComma(Math.round(sheetObj.GetSumValue(0, "pa_cm")/sheetObj.GetSumValue(0, "lod_qty"))));
 		sheetObj.SetSumText(0, "ra_cmpb",AddComma(Math.round(sheetObj.GetSumValue(0, "ra_cm")/sheetObj.GetSumValue(0, "lod_qty"))));
	}else{
		sheetObj.SetSumText(0, "grpb",0);
 		sheetObj.SetSumText(0, "pa_cmcb",0);
		sheetObj.SetSumText(0, "ra_cmcb",0);
		sheetObj.SetSumText(0, "pa_cmpb",0);
		sheetObj.SetSumText(0, "ra_cmpb",0);
	}
	ComOpenWait(false);
}
/**
 * f_ofc_lvl 諛붾��덉쓣��sheet change
 */
 function f_ofc_lvl_OnChange(obj, value, text) {
 	  var formObj=document.form;
 	  var div_rhq=document.getElementById("div_rhq");//rhq肄ㅻ낫
 	  var div_ofc=document.getElementById("div_ofc");//ofc肄ㅻ낫
 	  
 	  value = formObj.f_ofc_lvl.value;
 	  
 	  if(value == "01"){//Head Office�쇰븣
 		  div_rhq.style.display="none";
 		  div_ofc.style.display="none";
 		  f_rhq_cd.SetVisible(0);
 		  f_rgn_ofc_cd.SetVisible(0);
 	  }else{
 		if(value == "02"){//RHQ�쇰븣
			div_rhq.style.display="inline";
			div_ofc.style.display="none";
			f_rhq_cd.SetVisible(1);
			f_rgn_ofc_cd.SetVisible(0);
 		}else{//Office�쇰븣
 			div_rhq.style.display="inline";
 			div_ofc.style.display="inline";
 			f_rhq_cd.SetVisible(1);
 			f_rgn_ofc_cd.SetVisible(1);
 		}
 	  }
 }  
/**
 * �붾㈃ �쇱엯�κ컪����븳 �좏슚�깃�利��꾨줈�몄뒪 泥섎━
 */
function validateForm(sheetObj, formObj, sAction){
	switch(sAction) {
		case IBSEARCH:  // �붾㈃ 議고쉶�쒖뿉
			var qta=ComGetObjValue(f_bse_qtr_cd); //Quarter
			if(formObj.f_fm_mon.value!=""&&formObj.f_to_mon.value!=""){
				if(formObj.f_fm_mon.value<qtaMonArr[qta][0]
				        ||formObj.f_to_mon.value>qtaMonArr[qta][1]){
						ComShowCodeMessage('CSQ00025',qta); 
						//Duration doesn't include {?msg1}
						return false;
				}
			}else{
				if(formObj.f_fm_mon.value==""&&formObj.f_to_mon.value==""){
					return true;
				}else{
					ComShowCodeMessage('CSQ00024','Month'); 
					return false;
				}
			}
    		break;
	}
	return true;
} 
/**
 * f_fm_mon,f_to_mon 媛��먯옄由ъ닔濡��쒖떆�섎룄濡�onchange
 */ 
function obj_change(){
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	var srcVal=ComGetEvent("value");
	if(srcName == "f_fm_mon" || srcName == "f_to_mon"){
		if(srcVal.length<2 && srcVal.length != 0){
			formObject.elements[srcName].value="0" + srcVal;
		}
		//Month 형식체크
		if(!ComIsMonth(srcVal)){
			ComShowCodeMessage('CSQ00008', 'Month', 'MM');
			formObject.elements[srcName].value="";
		}
		// To month 가 From month 보다 큰지 체크
		if(formObject.f_fm_mon.value!="" && formObject.f_to_mon.value!=""){
			if ( formObject.f_fm_mon.value > formObject.f_to_mon.value ) {
				ComShowCodeMessage("COM12133", "To month", "from month", "later");
				formObject.f_to_mon.value="";
				formObject.f_to_mon.focus();
			}
		}
	}
}
 /**
  * 泥쒕떒�꾨쭏��肄ㅻ쭏瑜�李띿뼱二쇰뒗 �⑥닔
  */
 function AddComma(number){
	 var str=new Array(); 
	 number=String(number);
	 for(var i=1;i<=number.length;i++){
	  if(i%3) 
		  str[number.length-i]=number.charAt(number.length-i); //�먮━�섍� �꾨땲硫��レ옄留뚯궫��
	  else  
		  str[number.length-i]=','+number.charAt(number.length-i); //�먮━���대㈃ 肄ㅻ쭏源뚯� �쎌엯
	 }
	 return str.join('').replace(/^,/,'');
}
 
	function resizeSheet(){
	    for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }
	}
/* 媛쒕컻���묒뾽  ��*/
