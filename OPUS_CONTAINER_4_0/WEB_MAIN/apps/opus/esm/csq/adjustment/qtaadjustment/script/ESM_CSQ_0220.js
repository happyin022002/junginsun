/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0220.js
*@FileTitle  : QTA Edit for IAS Sector
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/10
=========================================================*/
/****************************************************************************************
  �대깽��援щ텇 肄붾뱶: [珥덇린��INIT=0; [�낅젰]ADD=1; [議고쉶]SEARCH=2; [由ъ뒪�몄“��SEARCHLIST=3;
                    [�섏젙]MODIFY=4; [��젣]REMOVE=5; [由ъ뒪�몄궘��REMOVELIST=6 [�ㅼ쨷泥섎━]MULTI=7
                    湲고� �щ텇��臾몄옄�곸닔  COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/*------------------�ㅼ쓬 肄붾뱶��JSDoc����留뚮뱾湲��꾪빐��異붽���肄붾뱶��------------------*/
/**
 * @extends
 * @class ESM_CSQ_0220 : ESM_CSQ_0220 �앹꽦���꾪븳 �붾㈃�먯꽌 �ъ슜�섎뒗 �낅Т �ㅽ겕由쏀듃瑜��뺤쓽�쒕떎.
 */
/* 媛쒕컻���묒뾽  */
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
            case "btn_Save":
                doActionIBSheet(sheetObject, formObj, IBSAVE);
                break;
            case "btn_CmcbCreation":
                doActionIBSheet(sheetObject, formObj, MULTI01);
                break;
            case "btn_Downexcel":
            	if(sheetObject.RowCount() < 1){//no data
            		ComShowCodeMessage("COM132501");
            	}else{
            		doActionIBSheet(sheetObject,formObj,IBDOWNEXCEL);
            	}
                break;
            case "btn_Loadexcel":
                doActionIBSheet(sheetObject,formObj,IBLOADEXCEL);
                break;
            case "btn_laneOfc":
				var sUrl="ESM_CSQ_0006.do?";
                	sUrl += "pop_mode=Y&"+searchParams;
                window.open(sUrl,"", "scroll:no;status:no;help:no;" );
            	break;
            case "btn_sctrOfc":
            	var sUrl="ESM_CSQ_0204.do?";
                sUrl += "pop_mode=Y&"+searchParams;
                window.open(sUrl,"", "scroll:no;status:no;help:no;" );
            	break;
            case "btn_pairAdd":
            	ComOpenPopup("ESM_CSQ_0221.do?"+searchParams, 800, 550, "callbackPopup", "0,0", true);
            	break;	
            case "btn_ofcAdd":
            	ComOpenPopup("ESM_CSQ_0222.do?"+searchParams, 800, 550, "callbackPopup", "0,0", true);
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

function callbackPopup(value){
	// ESM_CSQ_0221,0222에서 받은 리턴값이 S일때 그리드를 다시 조회한다.
    if(value == "S"){
    	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
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
    initControl();
    toggleButtons("INIT");
    loadingMode=false;
    resizeSheet();
}
 /**
 * HTML Control��onkeypress�대깽�몄뿉���ㅻ낫���낅젰���쒖뼱�쒕떎.
 **/
 function obj_keypress(){
    switch(ComGetEvent("dataformat")){
        case "engup":
            //�곷Ц ��Ц�먮쭔 �낅젰�섍린, �곷Ц���レ옄 -> ComKeyOnlyAlphabet('uppernum');
            ComKeyOnlyAlphabet('upper');
            break;
        default:
            //�レ옄留뚯엯�ν븯湲��뺤닔,�좎쭨,�쒓컙)
            ComKeyOnlyNumber(ComGetEvent());
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
      if (ComChkLen(srcValue, srcMaxLength) == "2") {
        ComSetNextFocus();
      }
 }
 function initControl(){
        axon_event.addListenerForm("KeyUp","obj_KeyUp", document.form);
        axon_event.addListenerFormat('keypress', 'obj_keypress', document.form); //- �ㅻ낫���낅젰�좊븣
 }
function initSheet(sheetObj,sheetNo) {
    var cnt=0;
    switch(sheetNo) {
        case 1:     //sheet1 init
            with(sheetObj){
            	var HeadTitle1="STS|SEQ|Year|Quarter|Office View|QTA Type|Trade|Sub Trade|R.Lane|Lane\nBound|Month|Week|VVD|vsl_cd|skd_voy_no|skd_dir_cd|Supply|RHQ|Office|POL|POD|Main/Sector|Load|G.RPB|G.REV|CM Cost(PA)|CM Cost(RA)|CMCB(PA)|CMCB(RA)|CM(PA)|CM(RA)|CMPB(PA)|CMPB(RA)";
            	SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );

            	var info    = { Sort:1, ColMove:0, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);

            	var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"seq",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_yr",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bse_qtr_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"ofc_vw_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"csq_cng_tp_cd",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },

            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"dir_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_mon",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"bse_wk",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:100,   Align:"Center",  ColMerge:1,   SaveName:"vvd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:55,   Align:"Center",  ColMerge:1,   SaveName:"fnl_bsa_capa",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rhq_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"rgn_ofc_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pod_cd",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:90,   Align:"Center",  ColMerge:1,   SaveName:"csq_mn_sctr_flg",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"lod_qty",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Int",       Hidden:0,  Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rpb_rev",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:13,  UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"grs_rev",          KeyField:0,   CalcLogic:"|grs_rpb_rev|*|lod_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_cost",       KeyField:0,   CalcLogic:"|pa_cm_uc_amt|*|lod_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_cost",       KeyField:0,   CalcLogic:"|ra_cm_uc_amt|*|lod_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm_uc_amt",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cm",            KeyField:0,   CalcLogic:"|grs_rev|-|pa_cm_cost|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cm",            KeyField:0,   CalcLogic:"|grs_rev|-|ra_cm_cost|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"pa_cmpb",          KeyField:0,   CalcLogic:"(|grs_rev|-|pa_cm_cost|)/|lod_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Int",       Hidden:0,  Width:100,  Align:"Right",   ColMerge:1,   SaveName:"ra_cmpb",          KeyField:0,   CalcLogic:"(|grs_rev|-|ra_cm_cost|)/|lod_qty|",Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 }];
           
            	InitColumns(cols);
            	SetSheetHeight(400);
            	SetEditable(1);
	        	SetRangeBackColor(0, 22,0, 24,"#555555");
	        	SetRangeBackColor(0, 29,0, 32,"#555555");
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
        case "f_rlane_cd":
			with (comboObj) {
				SetDropHeight(300);
				InsertItem(0, '', '');
				SetSelectIndex(0);
			}    
        default:
            with (comboObj) {
                SetDropHeight(300);
                SetSelectIndex(0);
            }
            break;
    }
}
/**
 * f_bse_yr媛�諛붾��덉쓣��period ��year 蹂�꼍
 */
function f_bse_yr_OnChange(obj, value, text) {
    period_change();
	setSubTradeCombo();
	setLaneCombo();
}
/**
 * f_bse_qtr_cd 諛붾��덉쓣��period ��week 湲곌컙蹂�꼍
 */
function f_bse_qtr_cd_OnChange(obj, value, text) {
    var formObj=document.form;
    period_change();
    doActionIBSheet(sheetObjects[0], formObj, SEARCH01);
	setSubTradeCombo();
	setLaneCombo();
}
/**
 * onChange event
 * f_rhq_cd 諛붾��덉쓣�� f_rgn_ofc_cd 肄ㅻ낫議고쉶
 */
function f_rhq_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
    var formObj=document.form;
    var rhqCd=NewCd; // rhq code
    if(NewCd!="All"){
        var param="f_cmd=" + SEARCH01
        + "&code_name=officeForPlan"
        + "&code_param=" + rhqCd
        + "&all_flag=All";  // Trade
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
        ComXml2ComboItem(xmlStr, f_rgn_ofc_cd, "code", "name");
        f_rgn_ofc_cd.SetSelectIndex(0);
    }else{
        f_rgn_ofc_cd.RemoveAll();
        f_rgn_ofc_cd.InsertItem(0, "All", "All");
        f_rgn_ofc_cd.SetSelectIndex(0);
    }
}
/**
* onChange event
* f_sub_trd_cd 諛붾��덉쓣�� f_lane_cd 肄ㅻ낫議고쉶
*/	
function f_sub_trd_cd_OnChange(obj, value, text) {
	setLaneCombo();
 }

/**
 *  f_bse_yr, f_bse_qtr_cd, f_trd_cd  변경시 f_sub_trd_cd를 변경한다.
 */
function setSubTradeCombo(){
 	var formObj=document.form;
    var f_bse_tp_cd  = "Q";
    var f_bse_yr     = ComGetObjValue(formObj.f_bse_yr);
    var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
	
 	if ( trd_cd != ""  && trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=subTradeSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd
	     + "&all_flag=";
        var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_sub_trd_cd, "code", "name");
	 	f_sub_trd_cd.SetSelectIndex(0);
 	} else {
 		f_sub_trd_cd.RemoveAll();
 	}
}

/**
 *  f_sub_trd_cd 蹂�꼍��f_rlane_cd瑜�蹂�꼍�쒕떎.
 */
function setLaneCombo(){
 	var formObj=document.form;
 	var sub_trd_cd	 = ComGetObjValue(f_sub_trd_cd);
    var f_bse_tp_cd  = "Q";
    var f_bse_yr     = ComGetObjValue(formObj.f_bse_yr);
    var f_bse_qtr_cd = ComGetObjValue(formObj.f_bse_qtr_cd);
    var trd_cd 		 = ComGetObjValue(formObj.f_trd_cd);
 	if (sub_trd_cd != ""  && sub_trd_cd != "All" ) {
	 	var param="f_cmd=" + SEARCH01
	     + "&code_name=rLaneSector"
	     + "&code_param="+trd_cd+"|"
	     				+f_bse_tp_cd+"|"
	     				+f_bse_yr+"|"
	     				+f_bse_qtr_cd+"|"
	     			    +f_sub_trd_cd.GetSelectCode()
	     + "&all_flag=";
	 	var xmlStr=sheetObjects[0].GetSearchData("CommonGS.do", param);
	 	ComXml2ComboItem(xmlStr, f_rlane_cd, "code", "name");
 	} else {
		f_rlane_cd.RemoveAll();
 	}
}
/**
 * f_rlane_cd 諛붾��덉쓣��POL, POD 蹂�꼍
 */
function f_rlane_cd_OnChange(obj, OldIdx, OldTxt, OldCd, NewIdx, NewTxt, NewCd) {
	var formObj=document.form;
	var sheetObj=sheetObjects[0];
	if(NewCd != "" && NewCd != "All") {
		var code_name=new Array("polCdSector", "podCdSector");
		var code_param=new Array(NewCd, NewCd);
		var all_flag=new Array("All", "All");
		var param="f_cmd="		+ SEARCH02
		          + "&code_name="	+ code_name
		          + "&code_param="	+ code_param
		          + "&all_flag="	+ all_flag
		          + "&" + FormQueryString(formObj);	
		var sXml=sheetObj.GetSearchData("CommonGS.do", param);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			ComXml2ComboItem(arrXml[0], f_pol_cd, "code", "name");
			f_pol_cd.SetSelectIndex(0);
		}
		if (arrXml.length > 1) {
			ComXml2ComboItem(arrXml[1], f_pod_cd, "code", "name");
			f_pod_cd.SetSelectIndex(0);
		}
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
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0220GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_bse_yr, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_bse_qtr_cd, "code", "name");
            if (arrXml.length > 2)
                ComSetYearQta(arrXml[2]);
            if (arrXml.length > 3)
                ComXml2ComboItem(arrXml[3], f_ofc_vw_cd, "code", "name");
            if (arrXml.length > 4)
            	ComXml2ComboItem(arrXml[4], f_rhq_cd, "code", "name");
            if (arrXml.length > 5)
            	ComXml2ComboItem(arrXml[5], f_dir_cd, "code", "name");
            ComOpenWait(false);
            break;
        case SEARCH01:          // Month,Week 肄ㅻ낫�뗮똿
            formObj.f_cmd.value=SEARCH01;
        	var sXml=sheetObj.GetSearchData("ESM_CSQ_0220GS.do", FormQueryString(formObj));
            var arrXml=sXml.split("|$$|");
            if (arrXml.length > 0)
                ComXml2ComboItem(arrXml[0], f_to_mon, "code", "name");
            if (arrXml.length > 1)
                ComXml2ComboItem(arrXml[1], f_to_wk, "code", "name");
            f_to_mon.SetSelectIndex(0);
            f_to_wk.SetSelectIndex(0);
            break;
        case MULTI01:          //CMCB Adjust Creationt�쒖뿉
            if (ComShowConfirm (ComGetMsg("CSQ00009")) != 1) {
                return false;
            }
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
            ComSetSearchParams("f_cmd", MULTI01);
            var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0220GS.do", searchParams);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            ComOpenWait(false);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else {
                ComShowCodeMessage('CSQ00011','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;
        case IBSEARCH:          //�붾㈃ 議고쉶��
			if (!validateForm(sheetObj, formObj, sAction)) return;
            sheetObj.SetWaitImageVisible(0);
            ComOpenWait(true);
        	formObj.f_cmd.value=SEARCH;
            searchParams=FormQueryString(formObj);
            var sXml=sheetObj.GetSearchData("ESM_CSQ_0220GS.do", searchParams);
            sheetObj.LoadSearchData(sXml,{Sync:1} );
            if (sheetObj.SearchRows()== 0) {
                toggleButtons("INIT");
            }else{
                toggleButtons("SEARCH");
            }
            ComOpenWait(false);
            break;
        case IBSAVE:          // �붾㈃ ��옣��
            if (!validateForm(sheetObj, formObj, sAction)) return false;
            if (sheetObj.IsDataModified()== false) {
                ComShowCodeMessage("CSQ00006");
                return false;
            } else if (ComShowConfirm (ComGetMsg("CSQ00004")) != 1) {
                return false;
            }
            ComSetSearchParams("f_cmd", MULTI);
            var sParam=sheetObj.GetSaveString(false, true, "ibflag");
            var sXml=sheetObjects[0].GetSaveData("ESM_CSQ_0220GS.do", searchParams + "&" +sParam);
            var State=ComGetEtcData(sXml,ComWebKey.Trans_Result_Key);
            if(State != "S"){
                ComShowMessage(ComResultMessage(sXml));
                return false;
            }else if(State == "S"){
                ComShowCodeMessage('CSQ00001','Data');
                doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
            }
            break;
        case IBDOWNEXCEL:       // �묒� �ㅼ슫濡쒕뱶
            ComOpenWait(true);
            sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
            ComOpenWait(false);
            break;
        case IBLOADEXCEL:       // �묒� �낅줈��
			loadExcelRowCnt=sheetObj.HeaderRows()+ sheetObj.GetTotalRows();
            loadExcelTotFlg=true;     // �붾㈃��Total Row 議댁옱 �щ�
            loadExcelExField="|vsl_cd|skd_voy_no|skd_dir_cd|fnl_bsa_capa|lod_qty|grs_rpb_rev|grs_rev|pa_cm_uc_amt|ra_cm_uc_amt|pa_cm_cost|ra_cm_cost|pa_cm|ra_cm|pa_cmpb|ra_cmpb|";     // 鍮꾧탳 �쒖쇅 �꾨뱶
            loadExcelAplyField="|lod_qty|grs_rpb_rev|";               // 諛섏쁺 �꾨뱶
        	ComOpenPopup("ESM_CSQ_1001.do?", 1050, 620, "", "0,0", true);
            break;
    }
}
 /**
  *議고쉶 �⑥닔瑜��댁슜�섏뿬 議고쉶媛��꾨즺�섍퀬 諛쒖깮�섎뒗 Event
  * @param sheetObj
  */
  function sheet1_OnSearchEnd(sheetObj){
    var row=0;
    // Allocation = QTA Setting ��寃쎌슦 �대떦 Row瑜�Disable �쒗궓��
    while((row=sheetObj.FindText("csq_cng_tp_cd", "A", row + 1)) > 0){
        sheetObj.SetRowEditable(row,0);
    }
    setSumText(sheetObj);
 }
  
 function setSumText(sheetObj){
	sheetObj.SetSumText(0, "ibflag","");
	sheetObj.SetSumText(0, "bse_yr","TOTAL");
	if(sheetObj.RowCount() > 0){
		sheetObj.SetSumText(0, "grs_rpb_rev",ComAddComma((sheetObj.GetSumValue(0, "grs_rev")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
		sheetObj.SetSumText(0, "pa_cm_uc_amt",ComAddComma((sheetObj.GetSumValue(0, "pa_cm_cost") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
		sheetObj.SetSumText(0, "ra_cm_uc_amt",ComAddComma((sheetObj.GetSumValue(0, "ra_cm_cost") / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
		sheetObj.SetSumText(0, "pa_cmpb",ComAddComma((sheetObj.GetSumValue(0, "pa_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
		sheetObj.SetSumText(0, "ra_cmpb",ComAddComma((sheetObj.GetSumValue(0, "ra_cm")   / sheetObj.GetSumValue(0, "lod_qty")).toFixed(0)));
	}
}
  
  /**
  * �붾㈃��紐⑤뱺 踰꾪듉�ㅼ쓽 Enable/Disable ��泥섎━
  */
 function toggleButtons(step) {
    switch (step) {
        case "INIT":
            ComBtnDisable("btn_Save");
            ComBtnDisable("btn_CmcbCreation");
            ComBtnDisable("btn_Downexcel");
            ComBtnDisable("btn_Loadexcel");
            ComBtnDisable("btn_laneOfc");
            ComBtnDisable("btn_sctrOfc");
            ComBtnDisable("btn_pairAdd");
            ComBtnDisable("btn_ofcAdd");
            break;
        case "SEARCH":
            ComBtnEnable("btn_Save");
            ComBtnEnable("btn_CmcbCreation");
            ComBtnEnable("btn_Downexcel");
            ComBtnEnable("btn_Loadexcel");
            ComBtnEnable("btn_laneOfc");
            ComBtnEnable("btn_sctrOfc");
            ComBtnEnable("btn_pairAdd");
            ComBtnEnable("btn_ofcAdd");
            break;
    }
 }
  /**
  * ESM_CSQ_1001�먯꽌 �몄텧 : row��csq_cng_tp_cd媛�'A'�쇰븣 load,G.RPB 諛섏쁺�쒖쇅
  */
  function rowExceptionFn(sheetObj,row) {
	  if(sheetObj.GetCellValue(row,"csq_cng_tp_cd") == "A"){
          return false;
      }else{
          return true;
      }
  }
 /**
  * �붾㈃ �쇱엯�κ컪����븳 �좏슚�깃�利��꾨줈�몄뒪 泥섎━
  */
 function validateForm(sheetObj, formObj, sAction){
    switch(sAction) {
    	case IBSEARCH: 
			if(f_rlane_cd.GetSelectCode()== ""){
				ComShowCodeMessage('CSQ00013','R/Lane');
				return false;
			}
			break;
        case IBSAVE:  // save��
            var upRow=sheetObj.FindStatusRow("U");
            var uRow=upRow.split(";");
            var sMsg="";
            for(var i=0;i<uRow.length;i++){
                // RPB 값을 제대로 인식하지 못하는 경우가 존재 eval로 실수로 변환하고 이것을 parseInt로 정수로 변환하여 비교하도록 변경
            	if(sheetObj.GetCellValue(uRow[i],"lod_qty")!=0 && sheetObj.GetCellValue(uRow[i],"grs_rpb_rev")==0){
            		sMsg=sMsg + "\n" + sheetObj.GetCellValue(uRow[i],"trd_cd")
            		+ "-" + sheetObj.GetCellValue(uRow[i],"rlane_cd")
            		+ "-" + sheetObj.GetCellValue(uRow[i],"dir_cd")
            		+ "-" + sheetObj.GetCellValue(uRow[i],"bse_wk")
            		+ "-" + sheetObj.GetCellValue(uRow[i],"rhq_cd")
            		+ "-" + sheetObj.GetCellValue(uRow[i],"rgn_ofc_cd");
                }
            }
            if(sMsg!=""){
                ComShowCodeMessage("CSQ00037","Trade-Rlane-Bound-Week-RHQ-Office",sMsg);
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
