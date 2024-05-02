/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_OPF_0036.js
*@FileTitle  : TDR Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/02
=========================================================*/
/****************************************************************************************
 Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
					MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
					OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
var selFrameId;
var iframeMap = new HashMap();
var iframeAddHeight = 0; 
/*------------------For JSDoc ------------------*/
/**
 * @fileoverview 업무에서 공통으로 사용하는 자바스크립트파일로 달력 관련 함수가 정의되어 있다.
 * @author 
 */
/**
 * @extends 
 * @class vop_opf_0036 : vop_opf_0036 business script for
 */


var tabObjects=new Array(); 
var tabCnt=0 ;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var comboObjects=new Array();
var comboCnt=0;
var gSubTabNo=0;
var marrTabTitle=new Array("SKD & COND", "Port Log", "Disch. Vol.", "Load Vol.", "COD", "R/H", "Mishandle", "Slot", "Temp. STWG", "Remark(s)");
var enableButton=new Array(	"btn_first_pilot_on","btn_unberth",	"btn_anchorage_dep","btn_berth","btn_last_pilot_off","btn_eta_next_date","btn_ExcludefromTPR",	"btn_Save",	"btn_Delete","btn_t1ActualInfo","btn_Print","btn_t2AutoCalcu");
var enableButton2=new Array("btn_Save",	"btn_t1ActualInfo");

//VVD CD 관련 항목들
var strVVDOptions="vsl_cd|skd_voy_no|skd_dir_cd";
var bRetrive=false;
var bFirst=true;
var bFirstTdrSearch=true;
var sheetCheckEdit=null;

//크래인 정보.
var beforeCraneCnt=0;
var arrPreCond=new Array("", "", "", "");
var sheetSplit="|$$|";
var totColor="#CCFFFD";		//기타 색상...
var titColor="#E5EAFF";		//타이틀 색상
var oldLoseTime="";
var autoCalcuCheck=false;
var popupSheet=null;		//팝업 클릭한 시트.
var popupPrefix="";
var popupColNm="";
var checkyDcDFlg=false;	//Pod 체크 
var multiSearchCheck=false;	//Multi Search여부 조회.

// Import BKG data for ref. Button YN
var importDischTotal=false;
var importDischSC=false;
var importDischBB=false;
var importLoadTotalOc=false;
var importLoadTotalIn=false;
var importLoadSC=false;
var importLoadBB=false;

//PopUpEdit Check 
var mCheckValue=false;
var mPopUpEditSheet=null;
var mPopUpEditRow=-1;
var mPopUpEditCol=-1;

//InitCombo Val
var mPodCode="";
var mPodName="";
var mLoadPodCode="";
var mLoadPodName="";
var mSztpCode="";
var mSztpName="";
var mReasonCode="";
var mReasonName="";
var mSlotDepRetrive=false;
var arrClptIndSeq=new Array();

// Event handler processing by button click event */
document.onclick=processButtonClick;
function processButtonClick(){
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var formObject=document.form;
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch(srcName) {
		case "btns_searchVvd":
			var vslcd=getObjValue("vsl_cd");
			var sUrl="";
			if(vslcd == ""){
				sUrl="/opuscntr/VOP_VSK_0219.do?op=0219";
				ComOpenPopup(sUrl, 463, 500, "setCallBackVSL", "0,0", true);
			}else{
				sUrl="/opuscntr/VOP_VSK_0230.do?op=0230&ctrl_cd=NORL&vsl_cd=" + vslcd;
				ComOpenPopup(sUrl, 335, 420, "setCallBackVVD", "0,0", true);
			}
			break;
		case "btn_first_pilot_on" :
			calenderCall(srcName);
			break;
		case "btn_unberth": 
			calenderCall(srcName);
			break;
		case "btn_anchorage_arr":
			calenderCall(srcName);
			break;
		case "btn_anchorage_dep":
			calenderCall(srcName);
			break;
		case "btn_berth":
			calenderCall(srcName);
			break;
		case "btn_last_pilot_off":
			calenderCall(srcName);
			break;
		case "btn_eta_next_date":
			calenderCall(srcName);
			break;
		case "btn_ExcludefromTPR":
			formObject.clpt_ind_seq.value=sheetTdrH.GetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_call_ind");
			ComOpenPopup("/opuscntr/VOP_OPF_0037.do?" + FormQueryString(document.form), 610, 540, "setCallBackPort", "0,0,1,1,1,1,1", true, false);
			break;
		case "btns_searchPort":
			ComOpenPopup("/opuscntr/COM_ENS_051.do", 650, 500, "setCallBackPort", "0,0,1,1,1,1,1", true);
			break;
		case "btn_Retrieve":
			doActionIBSheet(beforetab, formObject, IBSEARCH);
			break;
		case "btn_New":
			tdrScreenNew(formObject, true);
			break;
		case "btn_Delete":
			doActionIBSheet(beforetab, formObject, IBDELETE);
			break;
		case "btn_Save":
			if(marrTabTitle[beforetab] == "Slot"){
				if(t8frame.t8sheet4.Rowcount > 0){
					mSlotDepRetrive=true;
				}
			}
			doActionIBSheet(beforetab, formObject, IBSAVE);
			break;
		case "btn_t1ActualInfo":
			formObject.f_cmd.value=SEARCH01;
			var prefix="t1sheet1_";
			var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObject) + "&" + ComGetPrefixParam(prefix));
			sheetObjects[0].RenderSheet(0);
			sheetObjects[0].SetWaitImageVisible(0);
			sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
			sheetObjects[0].RenderSheet(1);
			//칼럼에 값을 입력...
			if(sheetObjects[0].RowCount()> 0){
				for(var idxCol=1; idxCol <= sheetObjects[0].LastCol(); idxCol++){
					var objName=ComReplaceStr(sheetObjects[0].ColSaveName(idxCol), prefix, "");
					
					var objVal = sheetObjects[0].GetCellText(1, idxCol);
					if((objName == "first_pilot_on" || objName == "unberth" || objName == "anchorage_arr" || objName == "anchorage_dep" || 
					   objName == "berth" || objName == "last_pilot_off" || objName == "eta_next_date" || objName == "eta_canal") && objVal.length >= 12){	//@@데이트포맷 대상 객체(html버젼)
						objVal = jsDateBetween(sheetObjects[0].GetCellText(1, idxCol));
					}
					
					setObjValue(objName, objVal);
				}
			}else{
				ComShowMessage("Does not exist.");
			}
			
			break;
		case "btn_Print":
			var rdParam="/rp ["+(formObject.vsl_cd.value)+"]"					// 1.Vessel Code
			+ " ["+(formObject.voy_no.value)+"]"					// 2.Voyage Nu
			+ " ["+(formObject.dir_cd.value)+"]"					// 3.Direction            
			+ " ["+(formObject.port_cd.value)+"]"				// 4.Port Code
//			+ " ["+(yd_cd.GetSelectCode())+"]"					// 5.Yard Code
			+ " ["+(formObject.yd_cd.value)+"]"					// 5.Yard Code
			+ " ["+(formObject.clpt_ind_seq.value)+"]";
			formObject.com_mrdArguments.value=rdParam; 
			ComOpenRDPopupModal();    
			break;
		/** (Tab) [ Port Log ] (S) **/
		case "btn_t2AutoCalcu":
			calcuPortLog(formObject, sheetObject2);
			break;
		/** (Tab) [ Port Log ] (E) **/
		/** (Tab) [ Remark ] (S) **/
		case "btn_t10RowAdd":
			document.form.tdr_info.value=sheetTdrH.GetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_info");
			break;
		/** (Tab) [ Remark ] (E) **/
	} 
}

function jsDateBetween(sdate){
	return sdate.substring(0, 4)+"-"+sdate.substring(4, 6)+"-"+sdate.substring(6, 8)+" "+sdate.substring(8, 10)+":"+sdate.substring(10, 12);
}


/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	//Disable Button;
	// initializing IBMultiCombo
	for ( var k=0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], k + 1);
	}

    for(i=0;i<sheetObjects.length;i++){
        ComConfigSheet (sheetObjects[i] );
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);
    }
    
	for(k=0;k<tabObjects.length;k++){
        initTab(tabObjects[k],k+1);
        tabObjects[k].SetSelectedIndex(0);
//        tabTdr.SetSelectedIndex(0);
    }
	
    resizeSheet();
    
	initSheetTrans();
	initControl();
	initComboSzTp();
	formReadonly(true);
	resetFormNsheet(document.form.vsl_cd);
	document.form.vsl_cd.focus();
	
}

/**
 * registering IBSheet Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setSheetObject(sheet_obj){
	if(sheet_obj.id != "sheetTransc"){
		sheetObjects[sheetCnt++]=sheet_obj;
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
function setComboObject(combo_obj) {
	comboObjects[comboCnt++]=combo_obj;
}

// 업무 자바스크립트 OnKeyUp 이벤트 처리
function obj_keyup() {
	switch(ComGetEvent("name")){ 
		case "skd_dir_cd":
			if(getObjValue("skd_dir_cd") != ""){
				searchVVDInfo();	
			}
			break;
		default:
			//obj_nextfocus(event.srcElement);
			ComKeyEnter('LengthNextFocus');
			break;     
	}
}  

// change focus to next HTML Tag(object) of HTML Tag(object) received as factor
function obj_nextfocus(obj) {
	var objMaxLength=obj.getAttribute("maxlength");
//	var objValue=obj.getAttribute("value");
//	if (ComChkLen(objValue, objMaxLength) == 2) {
	if (ComChkLen(obj, objMaxLength) == 2) {
		ComSetNextFocus(obj);
	}
}

function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id){
		case "t1sheet1":
			with(sheetObj){
                var HeadTitle1="";
                for(var idxCol=0; idxCol < 38; idxCol++){
                	HeadTitle1 += "|";
                }
                var headCount=ComCountHeadTitle(HeadTitle1);
                var prefix="t1sheet1_";
                SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
                var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
                var headers = [ { Text:HeadTitle1, Align:"Center"} ];
                InitHeaders(headers, info);

                var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
                             {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"first_pilot_on",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anchorage_arr",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"berth",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_next_port",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"eta_next_date",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"unberth",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"anchorage_dep",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"last_pilot_off",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_draft_fwd",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_draft_aft",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_draft_fwd",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_draft_aft",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_ballast",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_ballast",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_rob_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_rob_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_low_sul_fo",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_low_sul_do",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_fo",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_do",     KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_fo",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_do",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_slp_fw",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_fo_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_low_sul_do_wgt", KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_dwt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_displt",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_dwt",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_displ",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_gm",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_gm",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"arr_tugboat",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Float",     Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"dep_tugboat",        KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
						     {Type:"Text",      Hidden:0,  Width:100,  Align:"Center",  ColMerge:1,   SaveName:prefix+"clpt_ind_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
                for(var rowIdx = 1; rowIdx <= SaveNameCol(prefix + "last_pilot_off"); rowIdx++){
                	if(ColSaveName(rowIdx) != prefix + "eta_next_port"){
                		SetColProperty(rowIdx, {Format:"####-##-## ##:##"} );
                	}
                }
                InitColumns(cols);
            	SetEditable(1);            	
            	SetSheetHeight(100);
          }
		break;
		
		case "t2sheet1":
			with(sheetObj){
            	var HeadTitle1="||Work Commenced|Work Completed|Break Down|Meal|Weather|Other|Total|work|crane_no";
            	var headCount=ComCountHeadTitle(HeadTitle1);
            	var prefix="t2sheet1_";
            	SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
            	var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
            	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
            	InitHeaders(headers, info);
            	var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
            	             {Type:"Text",      Hidden:0,  Width:150,  Align:"Center",  ColMerge:0,   SaveName:prefix+"crane_desc", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"work_comm",  KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"work_comp",  KeyField:1,   CalcLogic:"",   Format:"YmdHm",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:prefix+"break_down", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:prefix+"meal",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:prefix+"weather",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
            	             {Type:"Text",      Hidden:0,  Width:115,  Align:"Right",   ColMerge:0,   SaveName:prefix+"other",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1, AcceptKeys:"N" },
            	             {Type:"Text",      Hidden:0,  Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"total",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
            	             {Type:"Text",      Hidden:1, Width:110,  Align:"Right",   ColMerge:0,   SaveName:prefix+"work",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
            	             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:0,   SaveName:prefix+"crane_no",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
             
            	InitColumns(cols);
            	SetEditable(1);
            	SetColProperty(prefix+"work_comm", {Format:"####-##-## ##:##"} );
            	SetColProperty(prefix+"work_comp", {Format:"####-##-## ##:##"} );
            	SetColProperty(prefix+"break_down", {Format:"###:##"} );
            	SetColProperty(prefix+"meal", {Format:"###:##"} );
            	SetColProperty(prefix+"weather", {Format:"###:##"} );
            	SetColProperty(prefix+"other", {Format:"###:##"} );
            	SetColProperty(prefix+"total", {Format:"###:##"} );
            	SetColProperty(prefix+"work", {Format:"###:##"} );
                totColor="#CCFFFD";		//기타 색상...
                titColor="#E5EAFF";		//타이틀 색상
                //SetSheetHeight(190);
                resizeSheet();
			}
		break;
		
		case "sheetTdrH":
			with(sheetObj){
				var HeadTitle1="|VSL_CD|VOY_NO|DIR_CD|PORT_CD|CALL_IND|TML_CD|TDR_DATE|TDR_USER|COMMENCE|COMPLETE|GROSS_WORK|NET_WORK|LOSE_HR|GROSS_GANG|NET_GANG|MVS|NET_TML|GROSS_TML|NET_GC|GROSS_GC|REMARK|HATCH|CON|PILOT_ARR|PILOT_DEP|ANCHOR_ARR|ANCHOR_DEP|BERTH|UNBERTH|DRAFT_FWD_ARR|DRAFT_FWD_DEP|DRAFT_AFT_ARR|DRAFT_AFT_DEP|BALLAST_ARR|BALLAST_DEP|ROB_FO_ARR|ROB_FO_DEP|ROB_DO_ARR|ROB_DO_DEP|ROB_FW_ARR|ROB_FW_DEP|BUNKER_FO_ARR|BUNKER_FO_DEP|BUNKER_DO_ARR|BUNKER_DO_DEP|BUNKER_FW_ARR|BUNKER_FW_DEP|DWT_ARR|DWT_DEP|DISPL_ARR|DISPL_DEP|GM_ARR|GM_DEP|TUG_ARR|TUG_DEP|ETA|ETA_CANAL|INFO|UPDATE_USER|UPDATE_TIME|SULPHUR_FO_ARR|SULPHUR_FO_DEP|SULPHUR_DO_ARR|SULPHUR_DO_DEP|SUPPLY_SULPHUR_FO|SUPPLY_SULPHUR_DO|NEXT_PORT|NEXT_PORT_DT|NEXT_CANAL|NEXT_CANAL_DT|EXISTS_TML_DEP_RPT_DTL";
				var headCount=ComCountHeadTitle(HeadTitle1);
				var prefix="sheetTdrH_";
				SetConfig( { SearchMode:2, MergeSheet:0, Page:20, FrozenCol:0, DataRowMerge:1 } );
				var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				InitHeaders(headers, info);
				var cols = [ {Type:"Status",    Hidden:1, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"vsl_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"voy_no",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dir_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"port_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"call_ind",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tml_cd",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tdr_date",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tdr_user",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"commence",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"complete",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_work",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_work",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"lose_hr",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_gang",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_gang",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"mvs",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_tml",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_tml",              KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"net_gc",                 KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gross_gc",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:1,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"remark",                 KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"hatch",                  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Int",       Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"con",                    KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pilot_arr",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"pilot_dep",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"anchor_arr",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"anchor_dep",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"berth",                  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"unberth",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_fwd_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_fwd_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_aft_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"draft_aft_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ballast_arr",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"ballast_dep",            KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fo_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fo_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_do_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_do_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fw_arr",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"rob_fw_dep",             KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fo_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fo_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_do_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_do_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fw_arr",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"bunker_fw_dep",          KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dwt_arr",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"dwt_dep",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"displ_arr",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"displ_dep",              KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gm_arr",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"gm_dep",                 KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tug_arr",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"tug_dep",                KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eta",                    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"eta_canal",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"info",                   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_fo_arr",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_fo_dep",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_do_arr",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"sulphur_do_dep",         KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"supply_sulphur_fo",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Float",     Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"supply_sulphur_do",      KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_port",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_port_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_canal",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"next_canal_dt",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"used_crane",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"avg_crane",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:115,  Align:"Center",  ColMerge:0,   SaveName:prefix+"exists_tml_dep_rpt_dtl", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
//				for(var rowIdx = SaveNameCol(prefix + "pilot_arr"); rowIdx <= SaveNameCol(prefix + "unberth"); rowIdx++){
//					SetColProperty(rowIdx, {Format:"####-##-####:##"} );
//				}
				InitColumns(cols);
				SetEditable(1);
				SetColProperty(prefix + "pilot_arr", {Format:"####-##-## ##:##"} );
				SetColProperty(prefix + "pilot_dep", {Format:"####-##-## ##:##"} );
				SetColProperty(prefix + "anchor_arr", {Format:"####-##-## ##:##"} );
				SetColProperty(prefix + "anchor_dep", {Format:"####-##-## ##:##"} );
				SetColProperty(prefix + "berth", {Format:"####-##-## ##:##"} );
				SetColProperty(prefix + "unberth", {Format:"####-##-## ##:##"} );

	            SetColProperty(prefix+"next_port_dt", {Format:"####-##-## ##:##"} );
	            SetColProperty(prefix+"eta", {Format:"####-##-## ##:##"} );
	            SetColProperty(prefix+"eta_canal", {Format:"####-##-## ##:##"} );

	            SetSheetHeight(102);
			}
		break;
	}
}

/**
* initializing IBSheet. <br>
**/
function sheetInitTotal(sheetObj){
	var cnt=0;
	with(sheetObj){
//		var cellCol="";
//		var prefix="";
//		var HeadTitle1="";
//		var HeadTitle2="";
//		var HeadTitle3="";
//		var subTitle1=(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");
//		if(sheetObj.id == "t3sheet1"){
//			cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
//		}else{
//			cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
//		}
//		prefix=sheetObj.id + "_";
//		if(sheetObj.id == "t3sheet1"){
//			HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
//			HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | |";
//			HeadTitle3="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
//		}else{
//			HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
//			HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
//		}
//		var headCount=ComCountHeadTitle(HeadTitle1);
////		(headCount, 0, 0, true);
//		SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:5, Page:20, Page:20, DataRowMerge:1 } );
//		var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
////		var headers = [ { Text:HeadTitle1, Align:"Center"},
////		                { Text:HeadTitle2, Align:"Center"},
////		                { Text:HeadTitle3, Align:"Center"},
////		                { Text:HeadTitle1, Align:"Center"},
////		                { Text:HeadTitle2, Align:"Center"},];
//		if(sheetObj.id == "t3sheet1"){
//			  var headers = [ { Text:HeadTitle1, Align:"Center"},
//			                  { Text:HeadTitle2, Align:"Center"},
//			                  { Text:HeadTitle3, Align:"Center"}];
//		}else{
//			 var headers = [ { Text:HeadTitle1, Align:"Center"},
//			                  { Text:HeadTitle2, Align:"Center"}];
//		}
//		InitHeaders(headers, info);
//		var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
//		             {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
//		             {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
//		if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
//			cols.push({Type:"ComboEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 });
//		}else{
//			cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
//		}
//		cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//		cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_valid",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
//		var arrCol = cellCol.split("|");
//		if(sheetObj.id == "t3sheet1"){
//			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
//				if(arrCol[idxCol].length == 5)
//					cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
//				else
//					cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
//			}
//		}else{
//			for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
//				if(arrCol[idxCol].length == 5)
//					cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:1,   UpdateEdit:1,   InsertEdit:1,   EditLen:7 });
//				else
//					cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullInteger", PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:4 });
//			}
//			if(sheetObj.id == "t3sheet1"){
//				FrozenCols = 3;
//			}			
//		}
//		InitColumns(cols);
//		SetEditable(1);
//		SetSheetHeight(360);
//		
//		//conversion of function[check again]CLT 			InitDataValid(0, prefix + "opr_cd", vtEngUpOnly);
//		//conversion of function[check again]CLT 			InitDataValid(0, prefix + "pod_cd", vtEngUpOnly);
              
        var cellCol="";
        var prefix="";
        var HeadTitle1="";
        var HeadTitle2="";
        var HeadTitle3="";
        var subTitle1=(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2" ? "Outbound" : "Inbound");
        if(sheetObj.id == "t3sheet1"){
        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|full_ts_20|full_ts_2h|full_ts_40|full_ts_4h|full_ts_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|et_ts_20|et_ts_2h|et_ts_40|et_ts_4h|et_ts_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
        }else{
        	cellCol="full_bo_20|full_bo_2h|full_bo_40|full_bo_4h|full_bo_45|et_bo_20|et_bo_2h|et_bo_40|et_bo_4h|et_bo_45|wt_20|wt_2h|wt_40|wt_4h|wt_45";
        }
        prefix=sheetObj.id + "_";
        if(sheetObj.id == "t3sheet1"){
	        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
	        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|" + subTitle1 + " Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo|T/S Cargo| | | | |";
	        HeadTitle3="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
        }else{
	        HeadTitle1="|Sel.|Operator|POD|idx_Sheet|chk_valid|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Full Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Empty Container Volume|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)|Weight(Ton)";
	        HeadTitle2="|Sel.|Operator|POD|idx_Sheet|chk_valid|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'|20'|20HC|40'|40HC|45'";
        }
        var headCount=ComCountHeadTitle(HeadTitle1);
//        (headCount, 0, 0, true);
       
        var info={ Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
        if(sheetObj.id == "t3sheet1"){
        	 var headers = [ { Text:HeadTitle1, Align:"Center"},
        	                  { Text:HeadTitle2, Align:"Center"},
        	                  { Text:HeadTitle3, Align:"Center"}];
		}else{
			 var headers = [ { Text:HeadTitle1, Align:"Center"},
			                  { Text:HeadTitle2, Align:"Center"}];
		}
        InitHeaders(headers, info);
        var cols=[ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
			        {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
			        {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
        if(sheetObj.id == "t4sheet1" || sheetObj.id == "t4sheet2"){
        	cols.push({Type:"ComboEdit", Hidden:0, Width:65,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:5 });
        }else{
        	cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"pod_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 });
        }
	        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	        cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"chk_valid",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	        var arrCol=cellCol.split("|");
	       
	        if(sheetObj.id == "t3sheet1"){
		        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
			        if(arrCol[idxCol].length == 5)
			        	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			        else
			        	cols.push({Type:"AutoSum",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
		        }
	        }else{
		        for(var idxCol=0; idxCol < arrCol.length; idxCol++){
			        if(arrCol[idxCol].length == 5)
			        	cols.push({Type:"AutoSum",   Hidden:0, Width:60,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
			        else
			        	cols.push({Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
		        }
		        if(sheetObj.id == "t3sheet1"){
		        	FrozenCols=3;
	        }
	        InitColumns(cols);
	       
        }

       // var cols = [  ];
         
        InitColumns(cols);
        SetEditable(1);
        SetSheetHeight(450);
	}
}

	function sheetInitSC(sheetObj){
		var cnt=0;
		with (sheetObj) {
	            
	            var HeadTitle1="|Sel.|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
	            var HeadTitle2="|Sel.|Operator|POD|idx_sheet|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)";
	            var HeadTitle3="|Sel.|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
	            var headCount=ComCountHeadTitle(HeadTitle1);
//	            (headCount, 0, 0, true);
	            var cellCol="dg_20_qty|dg_40_qty|dg_20_wgt|dg_40_wgt|rf_20_qty|rf_40_qty|rf_20_wgt|rf_40_wgt|ak_20_qty|ak_40_qty|ak_20_wgt|ak_40_wgt";
	            var prefix=sheetObj.id + "_";
	
	            SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
	
	            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
	            var headers = [ { Text:HeadTitle1, Align:"Center"},
				                { Text:HeadTitle2, Align:"Center"},
				                { Text:HeadTitle3, Align:"Center"} ];
	            InitHeaders(headers, info);
	
	            var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
					       {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					       {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
	                              if(id == "t3sheet2")
	            cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
	            else
	            cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
	            cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
	            var arrCol=cellCol.split("|");
	            for(var idxCol=0; idxCol < arrCol.length; idxCol++){
	            if(idxCol % 4 == 0 || idxCol % 4 == 1)
	            	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	            else
	            	cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
	            InitColumns(cols);	
	            SetEditable(1);
	            SetSheetHeight(360);
			}
		}
	}
	
	function sheetInitBreakBulk(sheetObj){
		var cnt=0;
        with(sheetObj){
            
		      var HeadTitle1="|Sel.|Operator|POD|idx_sheet|DG Cargo|DG Cargo|DG Cargo|DG Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Reefer Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo|Awkward Cargo";
		      var HeadTitle2="|Sel.|Operator|POD|idx_sheet|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)|Quantity|Quantity|Weight(Ton)|Weight(Ton)";
		      var HeadTitle3="|Sel.|Operator|POD|idx_sheet|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'|20'|40'";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      var cellCol="dg_20_qty|dg_40_qty|dg_20_wgt|dg_40_wgt|rf_20_qty|rf_40_qty|rf_20_wgt|rf_40_wgt|ak_20_qty|ak_40_qty|ak_20_wgt|ak_40_wgt";
		      var prefix=sheetObj.id + "_";
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"},
		          { Text:HeadTitle2, Align:"Center"},
		          { Text:HeadTitle3, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:40,   Align:"Center",  ColMerge:1,   SaveName:prefix+"ibflag" },
						 {Type:"CheckBox",  Hidden:0, Width:30,   Align:"Center",  ColMerge:1,   SaveName:prefix+"del_chk",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
						 {Type:"PopupEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"opr_cd",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:4 } ];
		      if(id == "t3sheet2")
		      cols.push({Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:5 });
		      else
		      cols.push({Type:"ComboEdit", Hidden:0, Width:80,   Align:"Center",  ColMerge:1,   SaveName:prefix+"pod",            KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5 });
		      cols.push({Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:prefix+"idx_sheet",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
		      var arrCol = cellCol.split("|");
		      for(var idxCol = 0; idxCol < arrCol.length; idxCol++){
		      if(idxCol % 4 == 0 || idxCol % 4 == 1)
		    	  cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat", PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
		      else
		    	  cols.push({Type:"AutoSum",   Hidden:0, Width:65,   Align:"Right",   ColMerge:1,   SaveName:prefix+arrCol[idxCol],   KeyField:0,   CalcLogic:"",   Format:"NullFloat",   PointCount:2,   UpdateEdit:1,   InsertEdit:1,   EditLen:8 });
		      }
		
		      InitColumns(cols);	
		      SetEditable(1);
		      SetSheetHeight(360);
        }
	}
	
	function initSheetTrans(){
		var cnt=0;
		with (sheetTransc) {
			//setting Host information [mandatory][HostIp, Port, PagePath]
//no support[check again]CLT 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
		}
	}
	
	/**
	* IBCOMBO 초기화. <br>
	**/
	function initCombo(comboObj, comboNo) {
		switch(comboObj.options.id) {
			case "yd_cd":
				var i=0;
				with(comboObj) {
					SetBackColor("#CCFFFF");
					SetDropHeight(200);
					SetMultiSelect(0);
					SetMaxSelect(1);
                    SetUseAutoComplete(1);
                    ValidChar(2,0);
				}
				break;
		}
	} 
	/**
     * Tab 기본 설정
     * 탭의 항목을 설정한다.
     */
    function initTab(tabObj , tabNo) {
        switch(tabNo) {
			case 1:
                with (tabObj) {
                    var cnt=0 ;
					for(; cnt < marrTabTitle.length; cnt++){
						InsertItem( marrTabTitle[cnt], "");
					}
			}
            break;
        }
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
     */
    function tabTdr_OnChange(tabObj , nItem){
		if(bFirst){
			var objs=document.all.item("tabLayer");
			objs[nItem].style.display="Inline";
			//--------------- 요기가 중요 --------------------------//
			for(var i = 0; i<objs.length; i++){
				  if(i != nItem){
				   objs[i].style.display="none";
				   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
				  }
				}

			//------------------------------------------------------//
			beforetab=nItem;
		}
		bFirst=false;
    }
    /**
     * Tab 클릭시 이벤트 관련
     * 선택한 탭의 요소가 활성화 된다.
	 */
    function tabTdr_OnClick(tabObj , nItem){
		var formObject=document.form;
		if(nItem == beforetab){
			return;
		}
		multiSearchCheck=false;
		var changeSheet=false;
//		var changeSheet=true;
		var oldIdxTab=beforetab;
		if(bRetrive){
			//Tab클릭시 Skd_Condi가 새로 생성되는 TDR이면 자동저장.
			if(beforetab != 0){
				if(beforetab == 1){
					if(sheetTdrH.RowCount()> 0){
						setTdrHeaderVal2(document.form, sheetCheckEdit[0]);
					}
				}
				
				for(var cnt=0; cnt < sheetCheckEdit.length; cnt++){
					if(
						(
							parseInt(sheetCheckEdit[cnt].RowCount("I")) + 
							parseInt(sheetCheckEdit[cnt].RowCount("U")) + 
							parseInt(sheetCheckEdit[cnt].RowCount("D"))
						) 
						> 0
					){
							changeSheet=true;
							break;
					}
				}
				//Sheet에 변경된 내용이 있을시에...
				if(changeSheet){
					//Sheet에 체크되는 사항이 있을때...
					if(ComShowCodeConfirm("COM130504", marrTabTitle[beforetab])){
						//tabObjects[0].SetSelectedIndex(beforetab);//변경화면을 보여준다.
						
						if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
							if(!multiInputCheck()){
								return;
							}
							if(!dupcheckSave(marrTabTitle[beforetab], true)){
								return;
							}
						}else if(beforetab != 0){
							var sParam=ComGetSaveString(sheetCheckEdit);
							if(sParam == ""){
								//Mishandle 일때...
								if(marrTabTitle[beforetab] == "Mishandle"){
									var shtObj=sheetCheckEdit[1];
									var prefix=sheetCheckEdit[1].id + "_";
									//Sheet를 돌면서. 필수조건이 아님놈을 검색한다.
									for(var idxRow=shtObj.HeaderRows(); idxRow <= shtObj.LastRow(); idxRow++){
										//만약 조회나 삭제가 아니면.
										if(shtObj.GetRowStatus(idxRow) != "R" && shtObj.GetRowStatus(idxRow) != "D"){
											var objFrm7=t7frame.form;
											//필수 체크
											if( shtObj.GetCellValue(idxRow, prefix + "cntr_no") == "" || shtObj.GetCellValue(idxRow, prefix + "opr_cd") == "" ){
												for(var cnt=0; cnt < objFrm7.misDischLoad.length; cnt++){
													if(objFrm7.misDischLoad[cnt].value == shtObj.GetCellValue(idxRow, prefix + "mishandle_chk") ){
														objFrm7.misDischLoad[cnt].checked=true;
														filterMishandle(shtObj, objFrm7.misDischLoad[cnt].value);
														break;
													}
												}
											}
										}
									}
								}
								return;
							}
							//MisHandle일때. 
							if(marrTabTitle[beforetab] == "R/H"){
								if(!checkExcelValidate()){
									tabObjects[0].SetSelectedIndex(beforetab);
									return;
								}
							}
							if(!dupcheckSave(marrTabTitle[beforetab], true)){
								return;
							}
						}
						doActionIBSheet(beforetab, formObject, IBSAVE);
					}else{
						sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"R");
						//취소를 선택시에.
						if(beforetab == 0){
							clearSkdCondi(formObject);
						}else{
							for(var cnt=1; cnt < sheetCheckEdit.length; cnt++){
								sheetCheckEdit[cnt].RemoveAll();
							}
						}
						if(beforetab == 1){
							var sheetObj=sheetTdrH;
							document.form.f_cmd.value=SEARCHLIST04;
 							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam("sheetTdrH_"));
//							sheetObj.RenderSheet(0);
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:1} );
//							sheetObj.RenderSheet(1);
						}
						changeSheet=false;
					}
				}
			}
		}

		if(bFirst){
			sheetRemoveAll();
		}

		var objs=document.all.item("tabLayer");
		objs[nItem].style.display="inline";
		for(var i = 0; i<objs.length; i++){
			  if(i != nItem){
			   objs[i].style.display="none";
			   objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
			  }
			}
		//------------------------------------------------------//
		beforetab=nItem;
		//2010.12.20 P.H.D 기본적으로 Internally일 때만 Editable하고 특정 Tab인 경우는 Externally여도 Editable하다. 
		var bReadOnly=false;
		formReadonly(!bRetrive); //2010.12.20 P.H.D. 추가
		switch(marrTabTitle[nItem]) {
			case "Disch. Vol.":
				var frame=document.getElementById("t3frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_3.do?btnDis=Y";
					return;
				}				
				break;
			case "Load Vol.":
				var frame=document.getElementById("t4frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_4.do?btnDis=Y";
					return;
				}				
				break;
			case "COD":
				var frame=document.getElementById("t5frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_5.do?btnDis=Y";
					return;
				}				
				break;
			case "R/H":
				var frame=document.getElementById("t6frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_6.do?btnDis=Y";
					return;
				}				
				break;
			case "Mishandle":
				var frame=document.getElementById("t7frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_7.do?btnDis=Y";
					return;
				}				
				break;
			case "Slot":
				var frame=document.getElementById("t8frame");
				selFrameId = frame.id;
				if(frame.src != ""){					
					frameButtonSheetSub(document.t8frame, gSubTabNo);
				}else{
					formReadonly( true ); //2010.12.20 P.H.D. 추가	
				}
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_8.do?btnDis=Y";
					return;
				}				
				break;
			case "Temp. STWG":
				var frame=document.getElementById("t9frame");
				selFrameId = frame.id;
				if(frame.src == ""){
					frame.src="VOP_OPF_0036_9.do?btnDis=Y";
					return;
				}				
				break;
			case "Remark(s)":
				break;
		}
		setTabEditSheet();
		if(bRetrive){
			if(marrTabTitle[beforetab] == "Disch. Vol." || marrTabTitle[beforetab] == "Load Vol." || marrTabTitle[beforetab] == "Slot"){
				if(marrTabTitle[beforetab] == "Disch. Vol."){
					t3frame.form.chk_DischVol.checked=true;
					t3frame.disChargTabChange(changeSheet);
				}else if(marrTabTitle[beforetab] == "Load Vol."){
					t4frame.form.chk_LoadVol.checked=true;
					t4frame.disLoadTabChange(changeSheet);
				}else if(marrTabTitle[beforetab] == "Slot"){
					t8frame.form.chk_Slot.checked=true;
					t8frame.disSlotTabChange(changeSheet);
				}
				doActionIBSheetMulti(beforetab, document.form);
			}else{
				if(changeSheet){
					setTimeout("tabTdr_OnClickExec(" + oldIdxTab + ", "+ nItem + ")", 100 );
					doActionIBSheet(beforetab, document.form, IBSEARCH);
				}else{
					doActionIBSheet(beforetab, document.form, IBSEARCH);
				}
			}
		}else{
			document.form.vsl_cd.focus();
		}
		topSync();
		iframeResize(false);
    }
	function tabTdr_OnClickExec(beforetab, idx){
		var objs=document.all.item("tabLayer");
		objs[idx].style.display="none";
		objs[idx].style.display="inline";
		objs[idx].style.zIndex=objs[beforetab].style.zIndex -1 ;
	}
	function topSync(){
		if(!bRetrive){
			document.form.vsl_cd.focus();
		}
		//top.syncHeight();
	}
    /**
    * 초기 이벤트 등록 
    */
	function initControl() {
		axon_event.addListenerForm	("keyup",			'obj_keyup',		form);	
    	axon_event.addListener('blur', 'used_crane_onblur', 'used_crane', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('blur', 'tdr_info_onchange', 'tdr_info', '');			//Port Cd변경시에 처리되는 로직...
    	axon_event.addListener('change', 'vsl_cd_onchange', 'vsl_cd', '');				//Vsl_cd변경시.
    	axon_event.addListener('change', 'skd_voy_no_onchange', 'skd_voy_no', '');				//Vsl_cd변경시.
		axon_event.addListener('keypress', 'gross_work_keypress', 'gross_work', '');	
		axon_event.addListener('keypress', 'net_work_keypress', 'net_work', '');		
		axon_event.addListener('blur', 'net_work_onblur', 'net_work', '');				
		axon_event.addListener('keypress', 'lost_time_keypress', 'lost_time', '');		
		axon_event.addListener('blur', 'lost_time_onblur', 'lost_time', '');			
		axon_event.addListener('keypress', 'gross_gang_keypress', 'gross_gang', '');	
		axon_event.addListener('blur', 'lost_time_onblur', 'gross_gang', '');			
		axon_event.addListener('keypress', 'net_gang_keypress', 'net_gang', '');	
		axon_event.addListener('blur', 'net_gang_onblur', 'net_gang', '');			
		axon_event.addListener('change', 'move_handl_onchange', 'move_handl', '');			
	}

	/**
	 * VVD 정보 조회 <br>
	 **/
	function searchVVDInfo() {
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH06;
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		//VVD 정보 관련 항목 셋팅
		setVVDInfo(formObj, sXml);
	}
	/**
	 * VVD 정보 관련 항목 셋팅 : VVD, Lane, Vessel Operator
	 */
	function setVVDInfo(formObj, sXml) { 	 
		var vvdData=ComOpfXml2Array(sXml, strVVDOptions);
		if(vvdData == null) {
			ComShowCodeMessage("COM132201", "VVD CD");
			initObjs("form", formObj, strVVDOptions, 0, "");
		}else{
			if(vvdData.length > 1) {
				ComShowCodeMessage("COM132201", "VVD CD");
				initObjs("form", formObj, strVVDOptions, 0, "");
			} else {
				formObj.f_cmd.value=SEARCH05;
 				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
				var sClptIndSeq=ComGetEtcData(sXml, "strClptIndSeq");
				arrClptIndSeq=sClptIndSeq.split("|");	
				//alert(arrClptIndSeq[0]);
				ComOPFXml2ComboItem(sXml, comboObjects[0], "val", "name");
				//sheetObjects[0].SetSelectIndex(1);
				//change focus 
				ComSetFocus(document.all.item("yd_cd"));
			}
		}
	}
	/**
	 * Get Object Value
	 */
	function getObjValue(name) {
		return ComGetObjValue(eval("document.form."+name));
	}
	/**
	 * Set Object Value
	 */
	function setObjValue(name, value) {
		ComSetObjValue(eval("document.form."+name), value);
	}
    function setObjValueFmt(name, value) {
        var eObj=eval("document.form."+name);
        if( eObj.getAttribute("dataformat") == "float" ){
            value=ComAddComma(tdrRoundNull( value,3));
            eObj.value=value;
        }else{
            ComSetObjValue(eval("document.form."+name), value);
        }
    }
	/**
	 * 선택된 Object의 초기화와 change focus 
	 */
	function initObjs(type, sheetObj, nameVars, focusIdx, etcVal) {
		var nameArrs=nameVars.split("|");
		for(var objIdx=0; objIdx<nameArrs.length; objIdx++) {
			if(type == 'sheet') 
				sheetObj.SetCellValue(etcVal, prefixs[0]+nameArrs[objIdx],"",0);
			else 
				ComClearObject(eval("document.form." + nameArrs[objIdx]));
			if(focusIdx == objIdx) {
				if(type == 'sheet') 
					sheetObj.SelectCell(etcVal, focusIdx);
				else 
					ComSetFocus(document.all.item(nameArrs[objIdx]));
			}
		}
	}
    function doActionIBSheet(tabIdx, formObj, sAction) {
        switch(sAction) {
			case IBSEARCH:		//조회
				
				isRetrieve = true;
				
				if(validateForm(formObj,sAction)){
					var sheetObjSkd=t1sheet1;
					/*
						Tdr헤더 여부 없을시에 TDR헤더.
					*/
//					if(document.sheetTdrH.RowCount()< 1){
					if(sheetTdrH.RowCount()< 1){
						tdrHeaderSearch(formObj);
					}

					if(sheetTdrH.RowCount()>0){
						//버튼 Enable/Disable
						for( var k=0; k < enableButton.length; k++){
							ComBtnEnable(enableButton[k]);
						}
					}else{
						//버튼 Enable/Disable
						for( var k=0; k < enableButton2.length; k++){
								ComBtnEnable(enableButton2[k]);
						}
					}
					
					switch(marrTabTitle[tabIdx]){
						case "SKD & COND":
							if(sheetTdrH.RowCount()> 0){
								getTdrHeaderVal(formObj, sheetTdrH);
							}else{
								return;
							}
							
							break;
							
						case "Port Log":
							var sheetObj	= t2sheet1;
							var prefix		= "t2sheet1_";
							
							with(sheetObj){
								
								formObj.f_cmd.value	= SEARCH02;
 								var sXml			= GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam("t2sheet1_"));
 								//sheetObj.RenderSheet(0);
								SetWaitImageVisible(0);
								LoadSearchData(sXml,{Sync:1} );
								//sheetObj.RenderSheet(1);
								DataInsert(0);
								
								for(var idxRow=HeaderRows(); idxRow <= LastRow(); idxRow++){
									if(idxRow == HeaderRows()){
										SetCellValue	(idxRow, prefix + "crane_desc","Terminal Working Time",0);
										SetCellValue	(idxRow, prefix + "work_comm", ComGetEtcData(sXml, "commence")!=undefined?ComGetEtcData(sXml, "commence").substring(0, 16):"",0);
										SetCellValue	(idxRow, prefix + "work_comp", ComGetEtcData(sXml, "complete")!=undefined?ComGetEtcData(sXml, "complete").substring(0, 16):"",0);
										SetCellEditable	(idxRow, prefix + "work_comm",0);
										SetCellEditable	(idxRow, prefix + "work_comp",0);
										SetCellEditable	(idxRow, prefix + "break_down",0);
										SetCellEditable	(idxRow, prefix + "meal",0);
										SetCellEditable	(idxRow, prefix + "weather",0);
										SetCellEditable	(idxRow, prefix + "other",0);
										SetCellEditable	(idxRow, prefix + "total",0);
									}else{
						                SetCellValue	(idxRow, prefix + "crane_desc",(idxRow - 1) + " G/Crane",0);
										SetCellBackColor(idxRow, prefix + "work",titColor);
										
										////SetCellValue	(idxRow, prefix + "work_comm",ComGetEtcData(sXml, "commence")!=undefined?ComGetEtcData(sXml, "commence").substring(0, 16):"",0);
										////SetCellValue	(idxRow, prefix + "work_comp",ComGetEtcData(sXml, "complete")!=undefined?ComGetEtcData(sXml, "complete").substring(0, 16):"",0);
									}
									SetCellBackColor	(idxRow, prefix + "crane_desc",totColor);
									SetRowStatus		(idxRow,"R");
								}
								beforeCraneCnt			= RowCount()- 1;
								getTdrHeaderVal2		(formObj, sheetTdrH, sXml);
							}
							break;
							
						case "Disch. Vol.":
							log("multiSearchCheck : "  + multiSearchCheck);
							if(t3frame.beforeDistchVolTab == 0){
								formObj.f_cmd.value=SEARCH03;
								formObj.status1.value="LM";
								formObj.status2.value="";
							}else if(t3frame.beforeDistchVolTab == 1){
								formObj.f_cmd.value=SEARCH04;
								formObj.sc_status1.value="DS";
								formObj.sc_status2.value="DG";
								formObj.sc_status3.value="";
							}else if(t3frame.beforeDistchVolTab == 2){
								formObj.f_cmd.value=SEARCH05;
								formObj.sc_status1.value="DS";
								formObj.sc_status2.value="DG";
								formObj.sc_status3.value="";
							}
							if(multiSearchCheck){ 
								var sheetObj=t3frame.sheetObjCur(); //t3frame.document.all.item("t3sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix="t3sheet" + (t3frame.beforeDistchVolTab + 1) + "_"
 								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//								sheetObj.RenderSheet(0);
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:0} );
//								sheetObj.RenderSheet(1);
								//정상적으로 호출이후에 상태를 변경시켜 준다.
								if(t3frame.beforeDistchVolTab == 0){
									importDischTotal=false;
								}else if(t3frame.beforeDistchVolTab == 1){
									importDischSC=false;
								}else if(t3frame.beforeDistchVolTab == 2){
									importDischBB=false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
							
						case "Load Vol.":
							if(t4frame.beforeLoadVolTab == 0){
								formObj.f_cmd.value=SEARCH06;
								formObj.status1.value="LM";
								formObj.status2.value="OT";
							}else if(t4frame.beforeLoadVolTab == 1){
								formObj.f_cmd.value=SEARCH06;
								formObj.status1.value="LI";
								formObj.status2.value="LT";
							}else if(t4frame.beforeLoadVolTab == 2){
								//:2016-09-23://formObj.f_cmd.value=SEARCH04;
								formObj.f_cmd.value=SEARCH15;
								formObj.sc_status1.value="LS";
								formObj.sc_status2.value="ST";
								formObj.sc_status3.value="";
							}else if(t4frame.beforeLoadVolTab == 3){
								formObj.f_cmd.value=SEARCH05;
								formObj.sc_status1.value="LS";
								formObj.sc_status2.value="";
								formObj.sc_status3.value="";
							}
							if(multiSearchCheck){
								var sheetObj=t4frame.sheetObjCur();  //t4frame.document.all.item("t4sheet" + (t3frame.beforeDistchVolTab + 1));
								var prefix="t4sheet" + (t4frame.beforeLoadVolTab + 1) + "_"
 								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
								//sheetObj.RenderSheet(0);
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:0} );
								//sheetObj.RenderSheet(1);
								//조회이후에는 정상적인 포멧으로.
								if(t4frame.beforeLoadVolTab == 0){
									importLoadTotalOc=false;
								}else if(t4frame.beforeLoadVolTab == 1){
									importLoadTotalIn=false;
								}else if(t4frame.beforeLoadVolTab == 2){
									importLoadSC=false;
								}else if(t4frame.beforeLoadVolTab == 3){
									importLoadBB=false;
								}
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
						case "COD":
							formObj.f_cmd.value=SEARCH07;
//							var sheetObj=t5frame.document.all.item("t5sheet1"); //document.t5sheet1;
//							var sheetObj=t5frame.sheetObjects[0];
							var sheetObj=t5frame.t5sheet1;
							var prefix="t5sheet1_";
 							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//							sheetObj.RenderSheet(0);
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
//							sheetObj.RenderSheet(1);
							break;
							
						case "R/H":
							formObj.f_cmd.value	= SEARCH08;
							var sheetObj		= t6frame.sheetObjects[0]; //document.t5sheet1;
							var prefix			= "t6sheet1_";
 							var sXml			= sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
 							
//							sheetObj.RenderSheet(0);
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
//							sheetObj.RenderSheet(1);
							
 							/** 2016-09-20 ****************************************************************/
 	                        //for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
 	                        //	sheetObj.SetCellValue(idxRow, prefix+"ibflag", "I", 0);
 	                        //}
 							/******************************************************************************/
							
							break;
							
						case "Mishandle":
							formObj.f_cmd.value=SEARCH09;
							//var sheetObj = t7frame.document.all.item("t7sheet1"); //document.t5sheet1;
							var sheetObj=t7frame.sheetObjects[0];
							var prefix="t7sheet1_";
                            var formObject=document.form;
                            var mishandlechk=formObject.misHandleChk.value;
                            var param=FormQueryString(formObject)+"&mishandlechk="+mishandlechk + "&" + ComGetPrefixParam(prefix);
 							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", param );
							//sheetObj.Redraw = false;    
							//sheetObj.WaitImageVisible = false;	
							sheetObj.LoadSearchData(sXml,{Sync:0} );
							//sheetObj.Redraw = true; 
							filterMishandle(sheetObj, formObj.misHandleChk.value);
		                    for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
		                        if( !sheetObj.GetRowHidden(idxRow)  ){
		                            sheetObj.SetSelectRow(idxRow);
		                            break;
		                        }                   
		                    }
							break;
						case "Slot":
							if(t8frame.beforeSlotTab == 0){
								formObj.f_cmd.value=SEARCH10;
							}else if(t8frame.beforeSlotTab == 1){
								formObj.f_cmd.value=SEARCH11;
							}else if(t8frame.beforeSlotTab == 2){
								formObj.f_cmd.value=SEARCH12;
								formObj.sl_status1.value="OM";
								formObj.sl_status2.value="OI";
							}else if(t8frame.beforeSlotTab == 3){
								formObj.f_cmd.value=SEARCH14;
								formObj.sl_status1.value="SM";
								formObj.sl_status2.value="SI";
							}
							if(multiSearchCheck){
								var sheetObj=t8frame.sheetObjCur(); //document.all.item("t8sheet" + (t4frame.beforeSlotTab + 1));
								var prefix="t8sheet" + (t8frame.beforeSlotTab + 1) + "_";
 								var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//								sheetObj.RenderSheet(0);
								sheetObj.SetWaitImageVisible(0);
								sheetObj.LoadSearchData(sXml,{Sync:0} );
//								sheetObj.RenderSheet(1);
							}else{
								doActionIBSheetMulti(tabIdx, formObj);
							}
							break;
						case "Temp. STWG":
							formObj.f_cmd.value=SEARCH13;
//							var sheetObj=t9frame.all.item("t9sheet1"); //document.t5sheet1;
							var sheetObj=t9frame.sheetObjects[0];
							var prefix="t9sheet1_";
 							var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//							sheetObj.RenderSheet(0);
							sheetObj.SetWaitImageVisible(0);
							sheetObj.LoadSearchData(sXml,{Sync:0} );
//							sheetObj.RenderSheet(1);
							break;
						case "Remark(s)":
							if(sheetTdrH.RowCount()> 0){
								document.form.tdr_info.value=sheetTdrH.GetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_info");
							}
							break;
					}
					arrPreCond[0]=document.form.vsl_cd.value;
					arrPreCond[1]=document.form.skd_voy_no.value;
					arrPreCond[2]=document.form.skd_dir_cd.value;
//					arrPreCond[3]= yd_cd.GetSelectCode();
					arrPreCond[3]= document.form.yd_cd.value;
					mCheckValue=false;
					
					
				}
				break;
				
			case IBSAVE:		//저장.
				if(validateForm(formObj,sAction)){
					var dupSheet=null;
					var dupCol=null;
					
					switch(marrTabTitle[tabIdx]){
						case "SKD & COND":
							formObj.f_cmd.value=MULTI01;
							if(sheetTdrH.RowCount()> 0){
                                setTdrHeaderVal(formObj, sheetTdrH);
							}
							break;
							
						case "Port Log":
							formObj.f_cmd.value=MULTI02;
                            calcuPortLog(formObj, sheetCheckEdit[1]);
							//만약 TDR헤더가 존재할경우...
							if(sheetTdrH.RowCount()> 0){
                                setTdrHeaderVal2(formObj, sheetTdrH);
							}
//			                var sParam = ComGetSaveString(sheetCheckEdit[1]);
							var sheetTransc=this.sheetTransc;
						    var sPrefix=sheetTransc.id+"_";
                            for(var i=sheetTransc.HeaderRows(); i <= sheetTransc.LastRow();i++ ){
                            	if( sheetTransc.GetCellValue(i, sPrefix + "work_comm"  ) == "" ){
                                    ComShowCodeMessage("COM130404", i, "Work Commenced" );
                                    //Work Commenced|Work Completed
                                    break;
                                }
                            	if(  sheetTransc.GetCellValue(i, sPrefix + "work_comp"  ) == "") {
                                    ComShowCodeMessage("OPF50025", i, "Work Completed" );
                                    break;
                                }
                            }
							setCraneSheet();
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.RowCount()> 0 && sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							break;
							
						case "Disch. Vol.":
							if(!checkMax(marrTabTitle[tabIdx])) {
								return false;
							}
							t3frame.t3sheet1.SetEndEdit(1);
							t3frame.t3sheet2.SetEndEdit(1);
							t3frame.t3sheet3.SetEndEdit(1);
							
							formObj.f_cmd.value=MULTI03;
							if(!multiInputCheck()){
								return;
							}
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								if(mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							//IdxSheet Import시에 해당 이전시트를 삭제하기 위해서.
							if(importDischTotal){
								setSheetIdx(sheetCheckEdit[1], "3", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[1], "0", "idx_sheet");
							}
							if(importDischSC){
								setSheetIdx(sheetCheckEdit[2], "2", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[2], "0", "idx_sheet");
							}
							if(importDischBB){
								setSheetIdx(sheetCheckEdit[3], "2", "cod_chk");
							}else{
								setSheetIdx(sheetCheckEdit[3], "0", "cod_chk");
							}
							break;
							
						case "Load Vol.":
							if(!checkMax(marrTabTitle[tabIdx])) {
								return false;
							}
							t4frame.t4sheet1.SetEndEdit(1);
							t4frame.t4sheet2.SetEndEdit(1);
							t4frame.t4sheet3.SetEndEdit(1);
							t4frame.t4sheet4.SetEndEdit(1);
							
							formObj.f_cmd.value=MULTI04;
							if(!multiInputCheck()){
								return;
							}
							//체크여부.....
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								if(mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							//importLoadTotalOc, importLoadTotalIn, importLoadSC, importLoadBB
							if(importLoadTotalOc){
								setSheetIdx(sheetCheckEdit[1], "4", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[1], "1", "idx_sheet");
							}
							if(importLoadTotalIn){
								setSheetIdx(sheetCheckEdit[2], "5", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[2], "2", "idx_sheet");
							}
							if(importLoadSC){
								setSheetIdx(sheetCheckEdit[3], "3", "idx_sheet");
							}else{
								setSheetIdx(sheetCheckEdit[3], "1", "idx_sheet");
							}
							if(importLoadBB){
								setSheetIdx(sheetCheckEdit[4], "3", "cod_chk");
							}else{
								setSheetIdx(sheetCheckEdit[4], "1", "cod_chk");
							}
							break;
							
						case "COD":
							formObj.f_cmd.value=MULTI05;
							//체크여부.....
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								if(mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							break;
							
						case "R/H":
							formObj.f_cmd.value	= MULTI06;
							//엑셀 Upload시에 체크...
							var prefix			= "t6sheet1_";
							if(!checkExcelValidate()){
								return;
							}
							//체크여부.....
							if(mCheckValue){
								if(mPopUpEditSheet == null){
									return;
								}
								if(mPopUpEditSheet.ColSaveName(mPopUpEditCol) == "t6sheet1_shift_rsn"){
									checkShiftReasonNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol, mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol));
								}else{
									checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								}
								if(mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							
							//cntr_no dup check
							if(!dupcheckSave(marrTabTitle[tabIdx], false)){
								return;
							}
							break;
							
						case "Mishandle":
							formObj.f_cmd.value=MULTI07;
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							break;
							
						case "Slot":
							if(!checkMax(marrTabTitle[tabIdx])) {
								return false;
							}
							formObj.f_cmd.value=MULTI08;
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							
							//Slot의 경우 변경된 내용이 있으면 해당내용을 지우고 삭제하기 때문에. 다 저장으로 변경.
							if(parseInt(sheetCheckEdit[2].RowCount("I")) + parseInt(sheetCheckEdit[2].RowCount("U")) + parseInt(sheetCheckEdit[2].RowCount("D")) > 0){
								for(var idxRow=sheetCheckEdit[2].HeaderRows(); idxRow <= sheetCheckEdit[2].LastRow(); idxRow++){
									if(sheetCheckEdit[2].GetRowStatus(idxRow) == "R"){
										sheetCheckEdit[2].SetRowStatus(idxRow,"U");
									}
								}
							}
/*
							setSheetIdx(sheetCheckEdit[3], "S", "status");
							setSheetIdx(sheetCheckEdit[4], "O", "status");
*/
							setSheetIdx(sheetCheckEdit[3], "O", "status");
							setSheetIdx(sheetCheckEdit[4], "S", "status");
							break;
							
						case "Temp. STWG":
							formObj.f_cmd.value=MULTI09;
							if(mCheckValue){
								checkOprCdNoMsg(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
								if(mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol) == ""){
									return;
								}
							}
							//TDR헤더에 변동사항이 없으므로.
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							break;
							
						case "Remark(s)":
							formObj.f_cmd.value=MULTI10;
							if(sheetTdrH.GetRowStatus(sheetTdrH.GetSelectRow()) == "R"){
								sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"U");
							}
							break;
					}
/*					
					//중복체크...
					if(!dupcheckSave(marrTabTitle[tabIdx], false)){
						return;
					}
*/
					//TDR헤더가 없으면. 저장 TDR헤더 자동 저장.............
					if(sheetTdrH.RowCount()< 1){
						var tdrSht		= sheetTdrH;
						var Row			= tdrSht.DataInsert();
						var hdrPrefix	= "sheetTdrH_";
						tdrSht.SetCellValue(Row, hdrPrefix + "vsl_cd"  ,getObjValue("vsl_cd"));
						tdrSht.SetCellValue(Row, hdrPrefix + "voy_no"  ,getObjValue("skd_voy_no"));
						tdrSht.SetCellValue(Row, hdrPrefix + "dir_cd"  ,getObjValue("skd_dir_cd"));
						tdrSht.SetCellValue(Row, hdrPrefix + "port_cd" ,getObjValue("yd_cd").substring(0, 5));
						tdrSht.SetCellValue(Row, hdrPrefix + "call_ind",getObjValue("clpt_ind_seq"));
						tdrSht.SetCellValue(Row, hdrPrefix + "tml_cd"  ,getObjValue("yd_cd"));
						setTdrHeaderVal(formObj, sheetTdrH);
						if(sheetCheckEdit == null){
							sheetCheckEdit = tdrSht;
						}
						//만약 Port Log가 
						if(marrTabTitle[tabIdx] == "Port Log"){
							setTdrHeaderVal2(formObj, sheetTdrH);
						}
					} 
					
					var sParam	= ComGetSaveString(sheetCheckEdit);
					if (sParam == "") return;
					sParam 		+= "&" + FormQueryString(formObj);
					if(marrTabTitle[beforetab] == "Slot" && mSlotDepRetrive){
						if( sParam.indexOf("t8sheet1") > 0 || sParam.indexOf("t8sheet2") > 0 ){
							mSlotDepRetrive=true;
						}else{
							mSlotDepRetrive=false;
						}
					}
					
					this.sheetTransc.SetWaitImageVisible(0);
                    ComOpenWait(true);
                    
                    if(marrTabTitle[tabIdx] == "R/H" && marrTabTitle[tabIdx] != undefined){
                    	
                    	var sheetObj	= t6frame.t6sheet1;
                    	var prefix		= "t6sheet1_";
                    	
                        /** 2016-09-20 ****************************************************************/
                        for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
                          //alert(' idxRow ['+idxRow+']   ['+sheetObj.GetRowStatus(idxRow)+']');
                          
                        	if(sheetObj.GetRowStatus(idxRow) != "D"){
                        		//sheetObj.SetRowStatus(idxRow, "U");
                        	  
                        		sheetObj.SetCellValue(idxRow, prefix+"ibflag", "I", 0);
                        		//sheetObj.SetRowStatus(idxRow, "I");
                        	}
                        }
                        /******************************************************************************/
                        
    					//////////////////////////////////////////////////////////////////////////
    					if(sheetTdrH.RowCount()< 1){
    						var tdrSht		= sheetTdrH;
    						var Row			= tdrSht.DataInsert();
    						var hdrPrefix	= "sheetTdrH_";
    						tdrSht.SetCellValue(Row, hdrPrefix + "vsl_cd"  ,getObjValue("vsl_cd"));
    						tdrSht.SetCellValue(Row, hdrPrefix + "voy_no"  ,getObjValue("skd_voy_no"));
    						tdrSht.SetCellValue(Row, hdrPrefix + "dir_cd"  ,getObjValue("skd_dir_cd"));
    						tdrSht.SetCellValue(Row, hdrPrefix + "port_cd" ,getObjValue("yd_cd").substring(0, 5));
    						tdrSht.SetCellValue(Row, hdrPrefix + "call_ind",getObjValue("clpt_ind_seq"));
    						tdrSht.SetCellValue(Row, hdrPrefix + "tml_cd"  ,getObjValue("yd_cd"));
    						setTdrHeaderVal(formObj, sheetTdrH);
    						if(sheetCheckEdit == null){
    							sheetCheckEdit = tdrSht;
    						}else{
    							sheetCheckEdit = sheetObj;	/* <== Key Point */
    						}
    						//만약 Port Log가 
    						if(marrTabTitle[tabIdx] == "Port Log"){
    							setTdrHeaderVal2(formObj, sheetTdrH);
    						}
    					} 
    					
    					var sParam	= ComGetSaveString(sheetCheckEdit);//
    					//var sParam2	= ComGetSaveString(sheetObj);//
    					if (sParam == "") return;
    					sParam 		+= "&" + FormQueryString(formObj);
    					if(marrTabTitle[beforetab] == "Slot" && mSlotDepRetrive){
    						if( sParam.indexOf("t8sheet1") > 0 || sParam.indexOf("t8sheet2") > 0 ){
    							mSlotDepRetrive	= true;
    						}else{
    							mSlotDepRetrive	= false;
    						}
    					}
    				
    				//////////////////////////////////////////////////////////////////////////
                        
                    	var sXml	= this.sheetTransc.GetSaveData("VOP_OPF_0036GS.do", sParam);	
                    }else{
                    	var sXml	= this.sheetTransc.GetSaveData("VOP_OPF_0036GS.do", sParam);
                    }
 					
                    ComOpenWait(false);
                    
					for(var cnt=0; cnt < sheetCheckEdit.length; cnt++){
 						sheetCheckEdit[cnt].LoadSaveData(sXml);
	                    if( ComGetEtcData(sXml, "TRANS_RESULT_KEY" ) == "S" ) {                 
	                        if(importLoadTotalOc){
	                            importLoadTotalOc=false;
	                        }
                            if(importLoadTotalIn){
                                importLoadTotalIn=false;
                            }
                            if(importLoadSC){
                                importLoadSC=false;
                            }
                            if(importLoadBB){
                                importLoadBB=false;
                            }
                            formReadonly(false);
	                    }
						//처음 이후에 메세지 삭제.
						if(cnt == 0)
							sXml=ComDeleteMsg(sXml);
					}
					//Slot Departure의 파트에 Retreive할 내용이 있을시엔..
					if(mSlotDepRetrive){
						formObj.f_cmd.value=SEARCH14;
						formObj.sl_status1.value="SM";
						formObj.sl_status2.value="SI";
						var sheetObj=t8frame.t8sheet4;
						var prefix="t8sheet4_";
 						var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//						sheetObj.RenderSheet(0);
						sheetObj.SetWaitImageVisible(0);
						sheetObj.LoadSearchData(sXml,{Sync:1} );
//						sheetObj.RenderSheet(1);
						mSlotDepRetrive=false;
					}
				}
				break;
				
			case IBDELETE:
				if(!ComShowCodeConfirm("COM12165", "TDR Data")){
					return;
				}
				formObj.f_cmd.value=MULTI01;
				sheetTdrH.SetRowStatus(sheetTdrH.GetSelectRow(),"D");
				var sParam=ComGetSaveString(sheetTdrH);
				if (sParam == "") return;
				sParam +=  "&" + FormQueryString(formObj)+"&BTN_DELETE=Y";
 				var sXml=sheetCheckEdit[0].GetSaveData("VOP_OPF_0036GS.do", sParam);
				for(var cnt=0; cnt < sheetCheckEdit.length; cnt++){
 					sheetCheckEdit[cnt].LoadSaveData(sXml);
					if(cnt == 0)
						sXml=ComDeleteMsg(sXml);
				}
				formObj.vsl_cd.value="";
				resetFormNsheet(formObj.vsl_cd);
				formObj.vsl_cd.focus();
				break;
		}
	}
    
    function doActionImportDisch(formObj) {
		var sheetObj=document.all.item("t3sheet" + (beforeDistchVolTab + 1));
		var arrPre=new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
		var chkWrite=false;
		for(var idx=1; idx < sheetCheckEdit.length; idx++){
			//작성여부 체크....
			if( parseInt(sheetCheckEdit[idx].RowCount("I")) + 
				parseInt(sheetCheckEdit[idx].RowCount("U")) + 
				parseInt(sheetCheckEdit[idx].RowCount("D"))  > 0 ){
					chkWrite=true;
					break;
			}
		}
		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}
		formObj.f_cmd.value=SEARCHLIST17;
 		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPre));
		var arrXml=sXml.split(sheetSplit);
		for(var cnt=0; cnt < arrXml.length; cnt++){
			sheetCheckEdit[cnt + 1].RenderSheet(0);
			sheetCheckEdit[cnt + 1].LoadSearchData(arrXml[cnt],{Sync:1} );
			sheetCheckEdit[cnt + 1].RenderSheet(1);
		}
		//삽입 모드로 RowStat변경..........
		for(var idxObj=1; idxObj < sheetCheckEdit.length; idxObj++){
			sheetObj=sheetCheckEdit[idxObj];
			for(var idxRow=sheetObj.HeaderRows(); idxRow < sheetObj.LastRow(); idxRow++){
				sheetObj.SetRowStatus(idxRow,"I");
			}
		}
	}
    function doActionIBSheetImport1(tabIdx, formObj) {
		var sheetObj=t3frame.sheetObjCur();
//    	var sheetObj = t3frame.document.all.item("t3sheet" + (t3frame.beforeDistchVolTab + 1));
		var prefix="t3sheet" + (t3frame.beforeDistchVolTab + 1) + "_"
		var chkWrite=false;
		//작성여부 체크....
		if( parseInt(sheetObj.RowCount()) > 0 ){
			chkWrite=true;
		}
		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}
        if(tabIdx == 0){
			formObj.f_cmd.value=SEARCHLIST06;
			formObj.status1.value="";
        }else if(tabIdx == 1){
			formObj.f_cmd.value=SEARCHLIST07;
			formObj.sc_status1.value="DS";
			formObj.sc_status2.value="DG";
			formObj.sc_status3.value="";
		}else if(tabIdx == 2){
			formObj.f_cmd.value=SEARCHLIST08;
			formObj.sc_status1.value="DS";
			formObj.sc_status2.value="DG";
			formObj.sc_status3.value="";
		}
 		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//		sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(0);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
//		sheetObj.RenderSheet(1);
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			sheetObj.SetRowStatus(idxRow,"I");
		}
		//정상적으로 호출이후에 상태를 변경시켜 준다.
        if(tabIdx == 0 && chkWrite){
			importDischTotal=true;
        }else if(tabIdx == 1 && chkWrite){
			importDischSC=true;
		}else if(tabIdx == 2 && chkWrite){
			importDischBB=true;
		}
	}
    function doActionIBSheetImport2(tabIdx, formObj) {
		var sheetObj=t4frame.sheetObjCur(); //document.all.item("t4sheet" + (tabIdx + 1));
		var prefix="t4sheet" + (t4frame.beforeLoadVolTab + 1) + "_";
		var chkWrite=false;
		//작성여부 체크....
		if( parseInt(sheetObj.RowCount()) > 0 ){
			chkWrite=true;
		}
		if(chkWrite && !ComShowCodeConfirm("OPF50016")){
			return;
		}
		if(tabIdx == 0){
			formObj.f_cmd.value=SEARCHLIST14;
			formObj.status1.value="LM";
        }else if(tabIdx == 1){
			formObj.f_cmd.value=SEARCHLIST14;
			formObj.status1.value="LI";
		}else if (tabIdx == 2){					
			formObj.f_cmd.value=SEARCHLIST15;
			formObj.sc_status1.value="LM";
			formObj.sc_status2.value="LI";
			formObj.sc_status3.value="LT";
		}else if (tabIdx == 3){
			formObj.f_cmd.value=SEARCHLIST16;
			formObj.sc_status1.value="LM";
			formObj.sc_status2.value="LI";
			formObj.sc_status3.value="LT";
		}
 		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
		//sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(0);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		//sheetObj.RenderSheet(1);
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			sheetObj.SetRowStatus(idxRow,"I");
		}
		if(tabIdx == 0){
			importLoadTotalOc=true;
        }else if(tabIdx == 1){
			importLoadTotalIn=true;
		}else if (tabIdx == 2){
			importLoadSC=true;
		}else if (tabIdx == 3){
			importLoadBB=true;
		}
	}
	function doActionIBSheetImport3(tabIdx, formObj) {
		if(t8frame.beforeSlotTab == 0){
			formObj.f_cmd.value=SEARCHLIST09;
		}else if(t8frame.beforeSlotTab == 1){
			formObj.f_cmd.value=SEARCHLIST10;
		}else if(t8frame.beforeSlotTab == 2){
			formObj.f_cmd.value=SEARCHLIST11;
		}else if(t8frame.beforeSlotTab == 3){
			formObj.f_cmd.value=SEARCHLIST12;
		}
		var sheetObj=t8frame.sheetObjCur(); //document.all.item("t8sheet" + (beforeSlotTab + 1));
		var prefix="t8sheet" + (t8frame.beforeSlotTab + 1) + "_";
 		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
//		sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(0);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
//		sheetObj.RenderSheet(1);
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			sheetObj.SetRowStatus(idxRow,"I");
		}
	}
	function doActionIBSheetMulti(tabIdx, formObj){
		var multiSheet=new Array();
		var sXml="";
		if(marrTabTitle[tabIdx] == "Disch. Vol."){
			formObj.f_cmd.value=SEARCHLIST01;
			multiSheet[0]=t3frame.t3sheet1;
			multiSheet[1]=t3frame.t3sheet2;
			multiSheet[2]=t3frame.t3sheet3;
			var arrPrefix=new Array("t3sheet1_", "t3sheet2_", "t3sheet3_");
 			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}else if(marrTabTitle[tabIdx] == "Load Vol."){
			formObj.f_cmd.value=SEARCHLIST02;
			multiSheet[0]=t4frame.t4sheet1;
			multiSheet[1]=t4frame.t4sheet2;
			multiSheet[2]=t4frame.t4sheet3;
			multiSheet[3]=t4frame.t4sheet4;
			var arrPrefix=new Array("t4sheet1_", "t4sheet2_", "t4sheet3_", "t4sheet4_");
 			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}else if(marrTabTitle[tabIdx] == "Slot"){
			formObj.f_cmd.value=SEARCHLIST03;
			multiSheet[0]=t8frame.t8sheet1;
			multiSheet[1]=t8frame.t8sheet2;
			multiSheet[2]=t8frame.t8sheet3;
			multiSheet[3]=t8frame.t8sheet4;
			var arrPrefix=new Array("t8sheet1_", "t8sheet2_", "t8sheet3_", "t8sheet4_");
 			sXml=multiSheet[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPrefix));
		}
		var arrXml=sXml.split(sheetSplit);
		for(var cnt=0; cnt < multiSheet.length; cnt++){
			multiSheet[cnt].RenderSheet(0);
			multiSheet[cnt].LoadSearchData(arrXml[cnt],{Sync:0} );
			multiSheet[cnt].RenderSheet(1);
		}
		//상태값 변경.
		if(marrTabTitle[tabIdx] == "Disch. Vol."){
			importDischTotal=false;
			importDischSC=false;
			importDischBB=false;
		}else{
			importLoadTotalOc=false;
			importLoadTotalIn=false;
			importLoadSC=false;
			importLoadBB=false;
		}
		multiSearchCheck=true;
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(formObj,sAction){
		switch(sAction) {
			case IBSEARCH:
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(formObj.vsl_cd.value == ""){
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("vsl_cd"));
					return false;
				}
				if(formObj.skd_voy_no.value == ""){
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("skd_voy_no"));
					return false;
				}
				if(formObj.skd_dir_cd.value == ""){ 	
					ComShowCodeMessage("COM130201", "VVD CD");
					ComSetFocus(document.all.item("skd_dir_cd"));
					return false;
				}
//				if(yd_cd.GetSelectCode()== ""){
				if(formObj.yd_cd.value == ""){
					ComShowCodeMessage("COM130201", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				return true;
				break;
			case IBSAVE:
				//VVD 정보는 Key 이므로 기본 적으로 확인한다.
				if(formObj.vsl_cd.value == ""){
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("vsl_cd"));
					return false;
				}
				if(formObj.skd_voy_no.value == ""){
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("skd_voy_no"));
					return false;
				}
				if(formObj.skd_dir_cd.value == ""){ 	
					ComShowCodeMessage("COM130201", "VVD");
					ComSetFocus(document.all.item("skd_dir_cd"));
					return false;
				}
//					if(yd_cd.GetSelectCode()== ""){
				if(formObj.yd_cd.value == ""){
					ComShowCodeMessage("COM130201", "YARD");
					ComSetFocus(document.all.item("yd_cd"));
					return false;
				}
				return true;
				break;
		}
	}
	function checkCondiChange(){
		if(arrPreCond[0] != document.form.vsl_cd.value)
			return true;
		if(arrPreCond[1] != document.form.skd_voy_no.value)
			return true;
		if(arrPreCond[2] != document.form.skd_dir_cd.value)
			return true;
//		if(arrPreCond[3] != yd_cd.GetSelectCode())
		if(arrPreCond[3] != document.form.yd_cd.value)
			return true;
		return false;
	}
	/**
	 * 화면 컨트롤 Start
	 */
	function vsl_cd_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.vsl_cd);
		}
	}
	function skd_voy_no_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.skd_voy_no);
		}
	}
	function skd_dir_cd_onchange(){
		if(bRetrive){
			resetFormNsheet(document.form.skd_dir_cd);
		}
	}
	function gross_work_keypress(){
		ComKeyOnlyNumber(document.form.gross_work, ":");
	}
	function net_work_keypress(){
		autoCalcuCheck=true;
	}
	function net_work_onblur(){
		hhMMCheck(document.form.net_work);
	}
	function lost_time_keypress(){
		autoCalcuCheck=true;
	}
	function lost_time_onblur(){
		hhMMCheck(document.form.lost_time);
	}
	function gross_gang_keypress(){
		autoCalcuCheck=true;
	}
	function gross_gang_onblur(){
		hhMMCheck(document.form.gross_gang);
	}
	function net_gang_keypress(){
		autoCalcuCheck=true;
	}
	function net_gang_onblur(){
		hhMMCheck(document.form.net_gang);
	}
	function move_handl_onchange(){
		if(document.form.move_handl.value != ""){
			//calcuPortLog(document.form, sheetObjects[1]);
			calcuPortLogHeader();
		}
	}
	
 	var newCode;
	function yd_cd_OnSelect(comboObj, index, text, code) {
		newCode = code;
	}	
	
	function yd_cd_OnChange(comboObj, oldindex, oldtext, oldcode, newindex , text , code){

		if(comboObj.GetText(newindex, "2") != ""){
			ComShowCodeMessage('OPF50030', newCode + " [" + comboObj.GetText(newindex, "2") + "]");
			comboObj.SetSelectIndex("",false);
			document.form.yd_nm.value="";
			return;
		}
        var formObj=document.form;
        formObj.yd_nm.value="";
		if(comboObjects[0].GetSelectCode()!= ""){
			document.form.yd_nm.value=comboObj.GetText(newindex, "1");
			if(bRetrive){
				resetFormNsheet(document.form.port_cd);
			}
		}else{
			return;
		}
		//[2010-04-06]추가
		
		document.form.clpt_ind_seq.value=arrClptIndSeq[newindex];
		//해당 POD와 POL가져오기..
		formObj.f_cmd.value=SEARCH08;
//		formObj.port_cd.value= yd_cd.GetSelectCode().substring(0, 5);
//		formObj.port_cd.value = newCode;
		//comboObj.SetSelectText(comboObj.GetText(newindex, "1"),false);
		comboObj.SetSelectIndex(newindex,false);
		//comboObj.SetSelectText("www",false);
		
		//comboObj.SetText(newindex, 1, comboObj.GetText(newindex, "1"))

		$("#yd_cd").val(code)
		var unKnownPortName="|XXXXX\tUnknown";
		var unKnownPortCode="|XXXXX";
		//"", "", 
		var arrPre=new Array("", "");
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(arrPre));
		var arrXml=sXml.split(sheetSplit);
		var arrCombo=ComXml2ComboString(arrXml[0], "val", "name");
//		mPodCode=" |" + arrCombo[0] + unKnownPortCode;
//		mPodName=" |" + arrCombo[1] + unKnownPortName;
		mPodCode=arrCombo[0] + unKnownPortCode;
		mPodName=arrCombo[1] + unKnownPortName;
		arrCombo=ComXml2ComboString(arrXml[1], "val", "name");
		if(arrCombo != null){
			mLoadPodCode=" |" + arrCombo[0] + unKnownPortCode;
			mLoadPodName=" |" + arrCombo[1] + unKnownPortName;
		}
		var frame=document.getElementById("t4frame");
		if(frame.src != ""){
			t4frame.podComboInit();
		}
		var frame=document.getElementById("t5frame");
		if(frame.src != ""){
			t5frame.podComboInit();
		}
		var frame=document.getElementById("t6frame");
		if(frame.src != ""){
			t6frame.podComboInit();
		}
		var frame=document.getElementById("t7frame");
		if(frame.src != ""){
			t7frame.podComboInit();
		}
		var frame=document.getElementById("t9frame");
		if(frame.src != ""){
			t9frame.podComboInit();
		}
	}
	function initComboSzTp(){
		var formObj=document.form;
		formObj.f_cmd.value=SEARCH09;
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		var arrCombo=ComXml2ComboString(sXml, "val", "name");
		mSztpCode=" |" + arrCombo[0];
		mSztpName=" |" + arrCombo[1];
		formObj.f_cmd.value=SEARCH10;
		formObj.comboCd.value="CD02153";
 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", FormQueryString(formObj));
		arrCombo=ComXml2ComboString(sXml, "val", "name");
		mReasonCode=" |" + arrCombo[0];
		mReasonName=" |" + arrCombo[1];
	}
	function hhMMCheck(objText){
		if(objText.value != ""){
			if(objText.value.indexOf(":") > -1){
				var arrTxt=objText.value.split(":");
				if(parseInt(arrTxt[1]) > 59){
					objText.value=( parseInt(arrTxt[1] / 60) + 
									  parseInt(arrTxt[0] == "" ? "0" : arrTxt[0]) 
						            ) + ":" + fillZero(arrTxt[1] % 60);
				}else if(arrTxt[0] == ""){
					objText.value="0" + objText.value;
				}
			}else{
				if(parseInt(objText.value) > 59){
					objText.value=parseInt(objText.value / 60) + ":" + fillZero(objText.value % 60);
				}else{
					objText.value="0:" + objText.value;
				}
			}
		}
	}
	function used_crane_onblur(){
		var sheetObj=t2sheet1;
		var prefix="t2sheet1_";
		var formObj=document.form;
		if(beforeCraneCnt == parseInt(document.form.used_crane.value)){
			return;
		}
		if(parseInt(beforeCraneCnt) < parseInt(document.form.used_crane.value)){		//이전 크래인수보다 클 경우.
			for(var crtRow=1; crtRow <= parseInt(document.form.used_crane.value) - parseInt(beforeCraneCnt); crtRow++){
				var Row=sheetObj.DataInsert(-1);
				 sheetObj.SetCellValue(Row, prefix + "crane_desc",(parseInt(beforeCraneCnt) + parseInt(crtRow)) + " G/Crane", 0);
				 //일단 초기 날짜 세팅.
				//00:00으로 세팅...
				sheetObj.SetCellValue(Row, prefix + "break_down","000:00", 0);
				sheetObj.SetCellValue(Row, prefix + "meal","000:00", 0);
				sheetObj.SetCellValue(Row, prefix + "weather","000:00", 0);
				sheetObj.SetCellValue(Row, prefix + "other","000:00", 0);
				sheetObj.SetCellValue(Row, prefix + "total","000:00", 0);
				sheetObj.SetCellBackColor(Row, prefix + "work",titColor);
				sheetObj.SetCellBackColor(Row, prefix + "crane_desc",totColor);
			}
		}else{
			for(var crtRow=1; crtRow <= parseInt(beforeCraneCnt) - parseInt(document.form.used_crane.value); crtRow++){
				sheetObj.RowDelete(sheetObj.LastRow(), false);
			}
		}
		for(var crtRow=1; crtRow <= sheetObj.LastRow(); crtRow++){
			sheetObj.SetCellValue(crtRow, prefix + "work_comm","",0);
			sheetObj.SetCellValue(crtRow, prefix + "work_comp","",0);
			//처음 빼고....
			if(crtRow != 1){
				sheetObj.SetCellValue(crtRow, prefix + "break_down","000:00",0);
				sheetObj.SetCellValue(crtRow, prefix + "meal","000:00",0);
				sheetObj.SetCellValue(crtRow, prefix + "weather","000:00",0);
				sheetObj.SetCellValue(crtRow, prefix + "other","000:00",0);
				sheetObj.SetCellValue(crtRow, prefix + "total","000:00",0);
			}
		}
		document.form.avg_crane.value="";
		document.form.gross_work.value="";
		document.form.net_work.value="";
		document.form.lost_time.value="";
		document.form.gross_gang.value="";
		document.form.net_gang.value="";
		document.form.tmnl_gross.value="";
		document.form.tmnl_net.value="";
		document.form.per_gang_gross.value="";
		document.form.per_gan_net.value="";
		if(parseInt(document.form.used_crane.value) > 0){
			sheetObj.SelectCell(2, prefix + "work_comm", true);
		}
		beforeCraneCnt=parseInt(document.form.used_crane.value);
	}
	function tdr_info_onchange(){
		sheetTdrH.SetCellValue(sheetTdrH.GetSelectRow(), "sheetTdrH_info",document.form.tdr_info.value);
	}
	/**
	 * 화면 컨트롤 End
	 */
	/**
	 * Sheet 컨트롤 Start
	 */
	function t2sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol){
		var prefix="t2sheet1_";
		if(NewCol > sheetObj.SaveNameCol(prefix + "work_comp") && NewCol < sheetObj.SaveNameCol(prefix + "total")){
			oldLoseTime=sheetObj.GetCellValue(NewRow, NewCol);
		}
	}
	function t2sheet1_OnChange(sheetObj, Row, Col){
		log( Row+ "   "+ Col );
		var prefix="t2sheet1_";
        var formObj=document.form;
		if(Col > sheetObj.SaveNameCol(prefix + "crane_desc") && Col < sheetObj.SaveNameCol(prefix + "total")){
			//Work_comm Validation
			if( (	Col == sheetObj.SaveNameCol(prefix + "work_comm") ||
					Col == sheetObj.SaveNameCol(prefix + "work_comp")) && sheetObj.GetCellValue(Row, Col) != ""){
				var dateTmp=sheetObj.GetCellValue(Row, Col);
				if(!ComIsDate(dateTmp.substring(0, 8), "ymd") || !ComIsTime(dateTmp.substring(8), "hm")){
					ComShowCodeMessage('COM12187', 'yyyy-mm-dd hh:mm');
					sheetObj.SetCellValue(Row, Col, "");
					sheetObj.SelectCell(Row, Col, true);
					return;
				}
				if(Row > sheetObj.HeaderRows()){
					if(sheetObj.GetCellValue(Row, prefix + "work_comm") != "" && sheetObj.GetCellValue(Row, prefix + "work_comp") != "" ){
 						var days=sheet_dateDiff(sheetObj.GetCellText(Row, prefix + "work_comm").replace(" ","T")  ,
															   sheetObj.GetCellText(Row, prefix + "work_comp").replace(" ","T"), 'D');
						if(days < 0){		
							ComShowCodeMessage("OPF50013",  "Completed Date", "Commeced Date");
							sheetObj.SelectCell(Row, Col, true);
							return;
						}else{
				                if(  days  > 40   ){ //40일 초과 에러 
				                    ComShowCodeMessage("OPF50024", "Gross Work Hours");
				                    sheetObj.SetCellValue(Row, Col,"",0);
		                            sheetObj.SelectCell(Row, Col, true);
				                    return;
				                }
						}
					}
				}
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comm") && Row > sheetObj.HeaderRows()){
					var minDateTime="";
					for(var idxRow=sheetObj.HeaderRows()+ 1; idxRow <= sheetObj.RowCount(); idxRow++){
						if(sheetObj.GetCellValue(idxRow, Col) != ""){
							if(minDateTime == ""){
								minDateTime=sheetObj.GetCellValue(idxRow, Col);
							}else if(parseInt(minDateTime) > parseInt(sheetObj.GetCellValue(idxRow, Col))){
								minDateTime=sheetObj.GetCellValue(idxRow, Col);
							}
						}
					}
					if(minDateTime != ""){
						sheetObj.SetCellValue(sheetObj.HeaderRows(), Col,minDateTime,0);
					}
				}
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comp") && Row > sheetObj.HeaderRows()){
					var maxDateTime="";
					for(var idxRow=sheetObj.HeaderRows()+ 1; idxRow <= sheetObj.RowCount(); idxRow++){
						if(sheetObj.GetCellValue(idxRow, Col) != ""){
							if(maxDateTime == ""){
								maxDateTime=sheetObj.GetCellValue(idxRow, Col);
							}else if(parseInt(maxDateTime) < parseInt(sheetObj.GetCellValue(idxRow, Col))){
								maxDateTime=sheetObj.GetCellValue(idxRow, Col);
							}
						}
					}
					if(maxDateTime != ""){
						sheetObj.SetCellValue(sheetObj.HeaderRows(), Col,maxDateTime,0);
					}
				}
			}else{
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comm") && Row > sheetObj.HeaderRows()){
					var minDateTime="";
					for(var idxRow=sheetObj.HeaderRows()+ 1; idxRow <= sheetObj.RowCount(); idxRow++){
						if(sheetObj.GetCellValue(idxRow, Col) != ""){
							if(minDateTime == ""){
								minDateTime=sheetObj.GetCellValue(idxRow, Col);
							}else if(parseInt(minDateTime) > parseInt(sheetObj.GetCellValue(idxRow, Col))){
								minDateTime=sheetObj.GetCellValue(idxRow, Col);
							}
						}
					}
					if(minDateTime != ""){
						sheetObj.SetCellValue(sheetObj.HeaderRows(), Col,minDateTime,0);
					}
				}
				//헤더 Terminal Working Time값이 변경되는 것을 제외하고, CellValue가 Null일때 비고하는 로직제외...
				if(Col == sheetObj.SaveNameCol(prefix + "work_comp") && Row > sheetObj.HeaderRows()){
					var maxDateTime="";
					for(var idxRow=sheetObj.HeaderRows()+ 1; idxRow <= sheetObj.RowCount(); idxRow++){
						if(sheetObj.GetCellValue(idxRow, Col) != ""){
							if(maxDateTime == ""){
								maxDateTime=sheetObj.GetCellValue(Row, Col);
							}else if(parseInt(maxDateTime) < parseInt(sheetObj.GetCellValue(idxRow, Col))){
								maxDateTime=sheetObj.GetCellValue(idxRow, Col);
							}
						}
					}
					if(maxDateTime != ""){
						sheetObj.SetCellValue(sheetObj.HeaderRows(), Col,maxDateTime,0);
					}
				}
			}
			//80분으로 입력시 1:20으로 변환..........
			if(Col > sheetObj.SaveNameCol(prefix + "work_comp") && Col < sheetObj.SaveNameCol(prefix + "total")){
				var arrTime    = sheetObj.GetCellText(Row, Col).split(":");
				    arrTime[1] = ComRpad(arrTime[1], 2, "0");
				    
				if(parseInt(arrTime[1]) > 60){
						var tmpVal=( parseInt(arrTime[1] / 60) + 
										  parseInt(arrTime[0] == "" ? "0" : arrTime[0]) 
										) + ":" + (arrTime[1] % 60);
						if(tmpVal.length == 4) sheetObj.SetCellValue(Row, Col,"00" + tmpVal,0);
						else if(tmpVal.length == 5) sheetObj.SetCellValue(Row, Col,"0" + tmpVal,0);
						else sheetObj.SetCellValue(Row, Col,tmpVal,0);
				}
				if(arrTime[1] == "") {
					sheetObj.SetCellText(Row, Col, arrTime[0]+":00");
				}
			}
			//Crane타임 계산.
			if(Row >= sheetObj.HeaderRows()+ 1){
				var totMM=0;
// 				var waitMM=sheetObj.EvalDateDiff("N", sheetObj.GetCellText(Row, prefix + "work_comm") + ":00",
//														sheetObj.GetCellText(Row, prefix + "work_comp") + ":00");
 				var waitMM=sheet_dateDiff(sheetObj.GetCellText(Row, prefix + "work_comm").replace(" ","T"),
 						sheetObj.GetCellText(Row, prefix + "work_comp").replace(" ","T"), 'N');
				for(var idxCol=sheetObj.SaveNameCol(prefix + "work_comp") + 1; idxCol < sheetObj.LastCol()- 2; idxCol++){
					if(sheetObj.GetCellValue(Row, idxCol) != ""){
/*
						var arrTime=sheetObj.GetCellText(Row, idxCol).split(":");
						totMM += parseInt(arrTime[0]) * 60;
						totMM += parseInt(arrTime[1]);
*/
						if(sheetObj.GetCellText(Row, idxCol).length != 6){
							var dateTmp = sheetObj.GetCellText(Row, idxCol).split(":");
							
							dateTmp[0] = ComLpad(dateTmp[0], 3, "0");
							dateTmp[1] = ComRpad(dateTmp[1], 2, "0");
						    
				        	sheetObj.SetCellValue( Row, sheetObj.ColSaveName(idxCol) ,dateTmp[0] + ":" + dateTmp[1], 0);
						}
						totMM += parseHHMM(sheetObj.GetCellText(Row, idxCol));
					}
				}
				// LoseTime
				if(totMM >= 0){
					var tmpVal=parseInt(totMM / 60) + ":" + fillZero(totMM % 60);
					if(tmpVal.length == 4) sheetObj.SetCellValue(Row, prefix + "total","00" + tmpVal,0);
					else if(tmpVal.length == 5) sheetObj.SetCellValue(Row, prefix + "total","0" + tmpVal,0);
					else sheetObj.SetCellValue(Row, prefix + "total",tmpVal,0);
				}
				//WorkTime
                if(  parseInt(waitMM / 60)  > 999   ){ //999시간 초과 에러 
                    ComShowCodeMessage("OPF50024", "Gross Work Hours");
                    sheetObj.SetCellValue(Row, Col,"",0);
                    sheetObj.SelectCell(Row, Col, true);
                    return;
                }
				sheetObj.SetCellValue(Row, prefix + "work",parseInt(waitMM / 60) + ":" + fillZero(waitMM % 60),0);
			}
		}
		if(sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix + "work_comm") != "" && sheetObj.GetCellValue(sheetObj.HeaderRows(), prefix + "work_comp") != "" ){
			var days=sheet_dateDiff(sheetObj.GetCellText(sheetObj.HeaderRows(), prefix + "work_comm").replace(" ","T"),
						sheetObj.GetCellText(sheetObj.HeaderRows(), prefix + "work_comp").replace(" ","T"), 'D');
            if(  days  > 40   ){ //40일 초과 에러 
                ComShowCodeMessage("OPF50024", "Gross Work Hours");
                sheetObj.SetCellValue(sheetObj.HeaderRows(), prefix + "work_comp","",0);
                sheetObj.SetCellValue(Row, Col,"",0);
                formObj.gross_work.value="";
                formObj.net_work.value="";
                formObj.gross_gang.value="";
                formObj.net_gang.value="";
                return;
            }
        }
        //t2sheet1_break_down
        var colDateName=prefix+"break_down,"+prefix+"meal,"+prefix+"weather,"+prefix+"other";
        if( colDateName.indexOf( sheetObj.ColSaveName(Col) )  > -1 ){
            fnCheckDate2(sheetObj, Row, Col);
            return;
        }
        
        resizeSheet();
	}
	
	function resizeSheet(){		
		ComResizeSheet(sheetObjects[0]);
		ComResizeSheet(sheetObjects[1]);
	    /*for (i=0; i<sheetObjects.length; i++){
	        ComResizeSheet(sheetObjects[i]);
	    }*/
	}

    function fnCheckDate2(sheetObj, Row, Col){
        var dateTmp=sheetObj.GetCellText(Row, Col);
        if( dateTmp.indexOf(":") >-1 ){
            var  aDateTmp=dateTmp.split(":");
            var  sMm="00";
            if( aDateTmp[1].trim() != "" ) { //ex) 123:=> 123:00
                sMm=aDateTmp[1];
            } 
            if( aDateTmp[0].trim() == ""){ aDateTmp[0]="000"; }
            sheetObj.SetCellValue( Row, sheetObj.ColSaveName(Col) ,aDateTmp[0]+":"+sMm,0);
        }else{
//            if(dateTmp.trim() == "" ){ dateTmp="000";}
//            sheetObj.SetCellValue( Row, sheetObj.ColSaveName(Col) ,dateTmp+":00",0);
	       	if(dateTmp.length == 1){
	    		dateTmp = "00"+dateTmp;
	    	}else{
	    		dateTmp = "0"+dateTmp;
	    	} 
	        sheetObj.SetCellValue( Row, sheetObj.ColSaveName(Col) ,dateTmp, 0);
        }
        return;
    }
	/**
	 * Sheet 컨트롤 End
	 */
	/**
	 * Sheet내의 Common Control
	 */
	function t3sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t3sheet2_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t3sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t4sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t4sheet2_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t4sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t4sheet4_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t5sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t6sheet1_onblur(){
		if(mCheckValue){
			if(mPopUpEditSheet.ColSaveName(mPopUpEditCol) == "t6sheet1_shift_rsn"){
				checkShiftReason(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol, mPopUpEditSheet.GetCellValue(mPopUpEditRow, mPopUpEditCol));
			}else{
				checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
			}
		}
	}
	function t8sheet3_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t8sheet4_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function t9sheet1_onblur(){
		if(mCheckValue){
			checkOprCd(mPopUpEditSheet, mPopUpEditRow, mPopUpEditCol);
		}
	}
	function checkOprCd(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.GetCellValue(Row, Col) == ""){
			mCheckValue=false;
			return;
		}
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}
		//===================== 
		if(sheetObj.GetCellValue(Row, Col).length < 3){
			ComShowCodeMessage("COM12175", "Operator", "3", "4");
			sheetObj.SelectCell(Row, Col, true);
		}else{
			if(Row < sheetObj.HeaderRows()){
				return;
			}
 			var sXml=sheetTdrH.GetSearchData("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH04 + "&crr_cd=" + sheetObj.GetCellValue(Row, Col));
			var oprData=ComOpfXml2Array(sXml, "val|name");
			if(oprData == null){
				ComShowCodeMessage("COM132201", "Data");
				sheetObj.SetCellValue(Row, Col,"");
				sheetObj.SelectCell(Row, Col);
				sheetObj.SetCellValue(Row, sheetObj.id + "","");
			}
			mCheckValue=false;
		}
	}
	function checkOprCdNoMsg(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.GetCellValue(Row, Col) == ""){
			mCheckValue=false;
			return;
		}
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}
		//===================== 
		if(sheetObj.GetCellValue(Row, Col).length < 3){
			sheetObj.SelectCell(Row, Col, true);
		}else{
			if(Row < sheetObj.HeaderRows()){
				return;
			}
 			var sXml=sheetTdrH.GetSearchData("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH04 + "&crr_cd=" + sheetObj.GetCellValue(Row, Col));
			var oprData=ComOpfXml2Array(sXml, "val|name");
			if(oprData == null){
				sheetObj.SetCellValue(Row, Col,"");
				sheetObj.SelectCell(Row, Col);
				sheetObj.SetCellValue(Row, sheetObj.id + "","");
			}
			mCheckValue=false;
		}
	}
	function checkOprCd2(sheetObj, Row, Col){
		//빈값입력시 반환...
		if(sheetObj.GetCellValue(Row, Col) == "" || Row < sheetObj.HeaderRows()){
			return;
		}
		//===================== 
		if(sheetObj.GetCellValue(Row, Col).length < 3){
			ComShowCodeMessage("COM12175", "Operator", "3", "4");
			sheetObj.SelectCell(Row, Col, true);
		}else{
 			var sXml=sheetTdrH.GetSearchData("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH04 + "&crr_cd=" + sheetObj.GetCellValue(Row, Col));
			var oprData=ComOpfXml2Array(sXml, "val|name");
			if(oprData == null){
				ComShowCodeMessage("COM132201", "Data");
				sheetObj.SetCellValue(Row, Col,"");
				sheetObj.SelectCell(Row, Col);
				sheetObj.SetCellValue(Row, sheetObj.id + "_chk_valid","N");
			}else{
				if(sheetObj.SaveNameCol(sheetObj.id + "_chk_valid") > 0){
					sheetObj.SetCellValue(Row, sheetObj.id + "_chk_valid","Y");
				}
			}
		}
	}
	/**
	 * Container No Validation Check
	 * 주석처리한 이유는???
	 * @param sheetObj
	 * @param Row
	 * @param Col
	 */
	function checkCntrNo(sheetObj, Row, Col){
		sheetObj.SetCellValue(Row, Col,sheetObj.GetCellValue(Row, Col).toUpperCase(),0);
//2011.01.06 P.H.D Container No. Validation Check 제거 		
//		document.form.f_cmd.value = SEARCH13;
//		document.form.cntr_no.value = sheetObj.CellValue(Row, Col);
//
//		var sXml = document.all.item("sheetTdrH").GetSearchXml("VOP_OPF_UTILGS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(""));
//		//var strCntrOptions = "bkg_no|cntr_tpsz_cd|pck_tp_cd|pck_qty|org_yd_cd";
//		var strCntrOptions = "val";
//		var cntrData = ComOpfXml2Array(sXml, strCntrOptions);
//		
//		if (cntrData == null){
//			ComShowCodeMessage("COM132201", "'"+sheetObj.CellValue(Row, Col)+"'");
//			sheetObj.CellValue2(Row, Col) = "";
//			sheetObj.SelectCell(Row, Col);
//		}
//		if(cntrData == null)
//			sheetObj.CellFont("FontItalic", Row, Col) = true;
//		else
//			sheetObj.CellFont("FontItalic", Row, Col) = false;
	}
	function checkShiftReason(sheetObj, Row, Col, Value){
		//빈값입력시 반환...
		if(sheetObj.GetCellValue(Row, Col) == ""){
			mCheckValue=false;
			return;
		}
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}
		if(Row < sheetObj.HeaderRows()){
			return;
		}
		//첫자리가. S,D인지 확인.
		if(Value.substring(0, 1) != "S" && Value.substring(0, 1) != "D"){
			ComShowCodeMessage("COM132201", "Data");
			sheetObj.SetCellValue(Row, Col,"",0);
			sheetObj.SelectCell(Row, Col, true);
		}else{
			//두번째자리이후는 DB에 등록되어 있는 Reson코드인지.
			//var sXml = document.all.item("sheetTdrH").GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + COMMAND11 + "&rstwg_rsn_cd=" + Value.substring(1));
 			var sXml=sheetTdrH.GetSearchData("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value.substring(1,2));	//[1]수정
			var strCntrOptions="rstwg_rsn_cd|delt_flg";
			var reasonData=ComOpfXml2Array(sXml, strCntrOptions);
			if(reasonData == null){
				ComShowCodeMessage("COM132201", "Data");
				sheetObj.SetCellValue(Row, Col,"",0);
				sheetObj.SelectCell(Row, Col, true);
			}

			var party = sheetObj.GetCellValue(Row, "t6sheet1_party")
			if(party != "T" && party != "U"){
				if(Value.substring(2,3) == ""){
					sheetObj.SetCellValue(Row, Col, Value + party, 0);
				}else if(party != Value.substring(2,3) ){
					ComShowCodeMessage("COM132201", "Data");
					sheetObj.SetCellValue(Row, Col,"",0);
					sheetObj.SelectCell(Row, Col, true);
				}
			}else{
				sheetObj.SetCellValue(Row, Col, Value.substring(0,2), 0);
			}
		}
		mCheckValue=false;
	}
	function checkShiftReasonNoMsg(sheetObj, Row, Col, Value){
		//빈값입력시 반환...
		if(sheetObj.GetCellValue(Row, Col) == ""){
			mCheckValue=false;
			return;
		}
		//체크를 했을때만...........
		if(!mCheckValue){
			return;
		}
		if(Row < sheetObj.HeaderRows()){
			return;
		}
		
		//첫자리가. S,D인지 확인.
		if(Value.substring(0, 1) != "S" && Value.substring(0, 1) != "D"){
			sheetObj.SetCellValue	(Row, Col, "", 0);
			sheetObj.SelectCell		(Row, Col, true);
		}else{
			//두번째자리이후는 DB에 등록되어 있는 Reson코드인지.
			//var sXml = document.all.item("sheetTdrH").GetSearchXml("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value.substring(1));
 			var sXml			= sheetTdrH.GetSearchData("VOP_OPF_0036GS.do", "f_cmd=" + SEARCHLIST13 + "&rstwg_rsn_cd=" + Value.substring(1,2));
			var strCntrOptions	= "rstwg_rsn_cd|delt_flg";
			var reasonData		= ComOpfXml2Array(sXml, strCntrOptions);
			if(reasonData == null){
				sheetObj.SetCellValue	(Row, Col, "", 0);
				sheetObj.SelectCell		(Row, Col, true);
			}
			
			var party = sheetObj.GetCellValue(Row, "t6sheet1_party")
			if(party != "T" && party != "U"){
				if(Value.substring(2,3) == ""){
					sheetObj.SetCellValue	(Row, Col, Value + party, 0);
				}else if(party != Value.substring(2,3)){
					sheetObj.SetCellValue	(Row, Col, "", 0);
					sheetObj.SelectCell		(Row, Col, true);
				}
			}else{
				sheetObj.SetCellValue		(Row, Col, Value.substring(0,2), 0);
			}
		}
		mCheckValue	= false;
	}
	
	function chkPortCombo(sheetObj, Row, Col, Value){
		if(Row < sheetObj.HeaderRows()){
			return;
		}
		if(sheetObj.GetCellValue(Row, Col) == ""){
			return;
		}
		checkyDcDFlg=false;
		//유효 Pod 체크
		var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
		var arrCode=sCode.split("|");
		for(var i=0 ; i< arrCode.length ; i++){
			if(arrCode[i] == Value ){
				checkyDcDFlg=true;
			}
		}
		//유효 TMNL Code 없을 경우 TMNL Code 이동
		if(!checkyDcDFlg){
			//7자리 체크 및 유효 TMNL Code 체크 
			if(sheetObj.GetCellValue(Row, Col) != "" ){
				/*
if(sheetObj.GetCellValue(Row, Col).length < 5){
					//ComShowCodeMessage("OPF00014");
				}else{
					//ComShowCodeMessage("OPF00015");
				}
				*/
			}
			sheetObj.SetCellValue(Row, Col,"",0);
			sheetObj.SelectCell(Row, Col, true);
		}
	}
	function chkSzTpCombo(sheetObj, Row, Col, Value){
		checkyDcDFlg=false;
		//유효 Pod 체크
		var sCode=sheetObj.GetComboInfo(Row, Col, "Code");
		var arrCode=sCode.split("|");
		for(var i=0 ; i< arrCode.length ; i++){
			if(arrCode[i] == Value ){
				checkyDcDFlg=true;
				break;
			}
		}
		//유효 TMNL Code 없을 경우 TMNL Code 이동
		if(!checkyDcDFlg){
			//7자리 체크 및 유효 TMNL Code 체크 
			if(sheetObj.GetCellValue(Row, Col) != "" ){
/*
if(sheetObj.GetCellValue(Row, Col).length < 2){
					ComShowCodeMessage("COM12174", "Type/Size", "2");
				}else{
					ComShowCodeMessage("COM132201", "Data");
				}
*/
			}
			sheetObj.SetCellValue(Row, Col,"",0);
			sheetObj.SelectCell(Row, Col, true);
		}
	}
	/**
	 *	TDR정보 조회시...
	 */
	function tdrHeaderSearch(formObj){
//		var sheetObj=document.sheetTdrH;
		var sheetObj=sheetTdrH;
		var prefix="sheetTdrH_";
		document.form.f_cmd.value=SEARCHLIST04;
//		document.form.port_cd.value= yd_cd.GetSelectCode().substring(0, 5);
		document.form.port_cd.value= document.form.yd_cd.value.substring(0, 5);
		document.form.voy_no.value=document.form.skd_voy_no.value;
		document.form.dir_cd.value=document.form.skd_dir_cd.value;

 		var sXml=sheetObj.GetSearchData("VOP_OPF_0036GS.do", FormQueryString(document.form) + "&" + ComGetPrefixParam(prefix));

		//sheetObj.RenderSheet(0);
		sheetObj.SetWaitImageVisible(0);
		sheetObj.LoadSearchData(sXml,{Sync:1} );
		//sheetObj.RenderSheet(1);
		if(sheetObj.RowCount()> 0){
			formReadonly(false);
			getTdrHeaderVal(formObj, sheetTdrH); // Sheet 내용을 input Text에 옮기는 내용
			opentScreen(); //1. t1Sheet1을 제외한 모든 sheet 초기화 2. sheetCheckEdit 배열에 해당 sheet를 넣는다.
			// Exclude TPR에 저장시에 글짜색만 바꾸어 준다.
			if(sheetObj.GetCellValue(sheetObj.GetSelectRow(), prefix + "exists_tml_dep_rpt_dtl") == "Y"){
				document.all("btn_ExcludefromTPR").style.color="#e41010";
			}else{
				document.all("btn_ExcludefromTPR").style.color="#514747";
			}
		}else{
			if(sheetObjects[0].RowCount()== 0){
				var prefix="t1sheet1_";
				formObj.f_cmd.value=SEARCH01;
 				var sXml=sheetObjects[0].GetSearchData("VOP_OPF_0036GS.do", FormQueryString(formObj) + "&" + ComGetPrefixParam(prefix));
				//sheetObjects[0].RenderSheet(0);
				sheetObjects[0].SetWaitImageVisible(0);
				sheetObjects[0].LoadSearchData(sXml,{Sync:1} );
				//sheetObjects[0].RenderSheet(1);
				//메세지 표시.......
				if(marrTabTitle[beforetab] == "SKD & COND"){
				      if( sheetObjects[0].RowCount()> 0  ){
					      ComShowCodeMessage("OPF50015");
				      }else{
	                      ComShowCodeMessage("COM130401");
	                      return;
				      }
				} 
//				script error
//                if( sheetObjects[0].RowCount()> 0 ){
//    				for(var idxCol=1; idxCol <= sheetObjects[0].LastCol(); idxCol++){
//    					var objName=ComReplaceStr(sheetObjects[0].ColSaveName(idxCol), prefix, "");
//    					if( formObj.item(objName) != null && (formObj.item(objName).dataformat == "ymdhm" || formObj.item(objName).dataformat == "float")){
//    						setObjValue(objName, sheetObjects[0].GetCellText(1, idxCol));
//    					}else{
//    						setObjValue(objName, sheetObjects[0].GetCellValue(1, idxCol));
//    					}
//    				}
//                }
			}
			document.all("btn_ExcludefromTPR").style.color="#514747";
			opentScreen();
			formReadonly(true);
			
		}
	}
	function opentScreen(){
		bRetrive=true;
		//TDR을 들고 온넘을 지울순 없짠아요. ^^
		for(var cnt=0; cnt < sheetObjects.length - 1; cnt++){
			if(sheetObjects[cnt].id != "t1sheet1"){
				sheetObjects[cnt].RemoveAll();
			}
		}
		setTabEditSheet();
	}
	function closeScreen(){
		bRetrive=false;
		for(var cnt=0; cnt < sheetObjects.length; cnt++){
			sheetObjects[cnt].RemoveAll();
		}
		document.all("btn_ExcludefromTPR").style.color="#514747";
		frameSheetRemove();
		formReadonly(true);
		bFirstTdrSearch=true;
		multiSearchCheck=false;
	}
	function frameSheetRemove(){
		var frame=document.getElementById("t3frame");
		if(frame.src != ""){
			for(var idx=0; t3frame.sheetObjects!=undefined &&  idx <  t3frame.sheetObjects.length; idx++){
				t3frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t4frame");
		if(frame.src != ""){
			for(var idx=0;  t4frame.sheetObjects!=undefined && idx < t4frame.sheetObjects.length; idx++){
				t4frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t5frame");
		if(frame.src != ""){
			for(var idx=0; t5frame.sheetObjects!=undefined && idx < t5frame.sheetObjects.length; idx++){
				t5frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t6frame");
		if(frame.src != ""){
			for(var idx=0;  t6frame.sheetObjects!=undefined && idx < t6frame.sheetObjects.length; idx++){
				t6frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t7frame");
		if(frame.src != ""){
			for(var idx=0; t7frame.sheetObjects!=undefined && idx < t7frame.sheetObjects.length; idx++){
				t7frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t8frame");
		if(frame.src != ""){
			for(var idx=0; t8frame.sheetObjects!=undefined && idx <  t8frame.sheetObjects.length; idx++){
				t8frame.sheetObjects[idx].RemoveAll();
			}
		}
		var frame=document.getElementById("t9frame");
		if(frame.src != ""){
			for(var idx=0; t9frame.sheetObjects!=undefined && idx < t9frame.sheetObjects.length; idx++){
				t9frame.sheetObjects[idx].RemoveAll();
			}
		}
	}
	function resetFormNsheet(objText){
		var tmpMenu=new Array();
		var shearchCon=strVVDOptions.split("|");
		var tmpYdNm="";
		if(objText.name == "vsl_cd"){
		    setObjValue("skd_voy_no", "");
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else if(objText.name == "skd_voy_no"){
			setObjValue("skd_dir_cd", "");
			setObjValue("yd_cd", "");
		}else{
			tmpYdNm=getObjValue("yd_nm");
		}
		for(var cnt=0; cnt < shearchCon.length; cnt++){
			tmpMenu[cnt]=getObjValue(shearchCon[cnt]);
		}
		document.form.reset();
		
		for(var cnt=0; cnt < shearchCon.length; cnt++){
			setObjValue(shearchCon[cnt], tmpMenu[cnt]);
		}
		if(tmpYdNm != "")
			setObjValue("yd_nm", tmpYdNm);
		closeScreen();
		//해당 그리드로 이동.
		if(marrTabTitle[beforetab] == "Disch. Vol."){
			if(t3frame.beforeDistchVolTab != 0)
				t3frame.disChargTabChange();
		}else if(marrTabTitle[beforetab] == "Load Vol."){
			if(t4frame.beforeLoadVolTab != 0)
				t4frame.disLoadTabChange();
		}else if(marrTabTitle[beforetab] == "Slot"){
			if(t8frame.beforeSlotTab != 0){
				t8frame.disSlotTabChange();
			}
		}
		//change focus .
		if(objText.name == "vsl_cd"){
			ComSetFocus(document.form.skd_voy_no);
		}else if(objText.name == "skd_voy_no"){
			ComSetFocus(document.form.skd_dir_cd);
		}else if(objText.name == "skd_dir_cd"){
			ComSetFocus(yd_cd);
		}
	}
	function clearSkdCondi(formObj, sheetObj){
		var prefix="sheetTdrH_";
		formObj.first_pilot_on.value="";		//	First Pilot On                        	//	PILOT_ARR    
		formObj.anchorage_arr.value="";		//	Anchorage                               //	ANCHOR_ARR   
		formObj.berth.value="";		//	Berth                                   //	BERTH        
		formObj.eta_next_port.value="";		//	ETA Next Port                           //	REMARK       
		formObj.eta_next_date.value="";		//	ETA Next Port                           //	REMARK       
		formObj.unberth.value="";		//	Unberth                                 //	UNBERTH      
		formObj.anchorage_dep.value="";		//	Anchorage                               //	ANCHOR_DEP   
		formObj.last_pilot_off.value="";		//	Last Pilot Off                          //	PILOT_DEP    
		formObj.eta_next_port.value="";		//	ETA Next Port                           //	REMARK       
		formObj.eta_next_date.value="";		//	ETA Next Port                           //	REMARK       
		formObj.arr_draft_fwd.value="";		//	Arrival Draft (CM) FWD                  //	DRAFT_FWD_ARR
		formObj.arr_draft_aft.value="";		//	Arrival Draft (CM) AFT                  //	DRAFT_AFT_ARR
		formObj.dep_draft_fwd.value="";		//	Departure Draft (CM) FWD                //	DRAFT_FWD_DEP
		formObj.dep_draft_aft.value="";		//	Departure Draft (CM) AFT                //	DRAFT_AFT_DEP
		formObj.arr_ballast.value="";		//	Arrival Ballast (MT)                    //	BALLAST_ARR  
		formObj.dep_ballast.value="";		//	Departure Ballast (MT)                  //	BALLAST_DEP  
		formObj.arr_rob_fo.value="";		//	Arrival ROB (MT) F.O                    //	ROB_FO_ARR   
		formObj.arr_rob_do.value="";		//	Arrival ROB (MT) D.O                    //	ROB_DO_ARR   
		formObj.arr_rob_fw.value="";		//	Arrival ROB (MT) F.W                    //	ROB_FW_ARR   
		formObj.dep_rob_fo.value="";		//	Departure ROB (MT) F.O                  //	ROB_FO_DEP   
		formObj.dep_rob_do.value="";		//	Departure ROB (MT) D.O                  //	ROB_DO_DEP   
		formObj.dep_rob_fw.value="";		//	Departure ROB (MT) F.W                  //	ROB_FW_DEP   
		formObj.arr_low_sul_fo.value="";		//	Arrival Low Sulphur (MT) F.O            //	             
		formObj.arr_low_sul_do.value="";		//	Arrival Low Sulphur (MT) D.O            //	             
		formObj.dep_low_sul_fo.value="";		//	Departure Low Sulphur (MT) F.O          //	             
		formObj.dep_low_sul_do.value="";		//	Departure Low Sulphur (MT) D.O          //	             
		formObj.dep_slp_fo.value="";		//	Departure Supply (MT) F.O               //	BUNKER_FO_ARR
		formObj.dep_slp_do.value="";		//	Departure Supply (MT) D.O               //	BUNKER_FO_DEP
		formObj.dep_slp_fw.value="";		//	Departure Supply (MT) F.W               //	BUNKER_FW_ARR
		formObj.dep_low_sul_fo_wgt.value="";		//	Departure Supply Low Sulphur (MT) F.O   //	BUNKER_FW_DEP
		formObj.dep_low_sul_do_wgt.value="";		//	Departure Supply Low Sulphur (MT)  D.O  //	BUNKER_DO_DEP
		formObj.arr_dwt.value="";		//	Arrival DWT/Displ. (MT)                 //	DWT_ARR      
		formObj.arr_displt.value="";		//	Departure DWT/Displ. (MT)               //	DWT_DEP      
		formObj.dep_dwt.value="";		//	 DWT/Displ. (MT)                        //	DWT_ARR      
		formObj.dep_displ.value="";		//	Departure DWT/Displ. (MT)               //	DWT_DEP      
		formObj.arr_gm.value="";		//	Arrival GM (CM)                         //	GM_ARR       
		formObj.dep_gm.value="";		//	Departure GM (CM)                       //	GM_DEP       
		formObj.arr_tugboat.value="";		//	Arrival Tugboat                         //	TUG_ARR      
		formObj.dep_tugboat.value="";		//	Departure Tugboat                       //	TUG_DEP      
		//sheetCheckEdit[0].RemoveAll();
	}
	function getTdrHeaderVal(formObj, sheetObj){
		var prefix="sheetTdrH_";
		formObj.first_pilot_on.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "pilot_arr");					//	First Pilot On                        	//	PILOT_ARR
		formObj.anchorage_arr.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "anchor_arr");					//	Anchorage                               //	ANCHOR_ARR
		formObj.berth.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "berth");						//	Berth                                   //	BERTH
		formObj.eta_next_date.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "eta");							//	ETA Next Port                           //	REMARK
		formObj.eta_next_port.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_port");					//	ETA Next Port                           //	REMARK
		formObj.eta_canal.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "eta_canal");					//	ETA Next Canal                          //	REMARK
		formObj.next_canal.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "next_canal");					//	Next Canal								//	REMARK
		formObj.unberth.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "unberth");						//	Unberth                                 //	UNBERTH
		formObj.anchorage_dep.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "anchor_dep");					//	Anchorage                               //	ANCHOR_DEP
		formObj.last_pilot_off.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "pilot_dep");					//	Last Pilot Off                          //	PILOT_DEP
        formObj.arr_draft_fwd.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_fwd_arr" )) );  //  Arrival Draft (CM) FWD                  //  DRAFT_FWD_ARR
        formObj.arr_draft_aft.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_aft_arr" )) );  //  Arrival Draft (CM) AFT                  //  DRAFT_AFT_ARR
        formObj.dep_draft_fwd.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_fwd_dep" )) );  //  Departure Draft (CM) FWD                //  DRAFT_FWD_DEP
        formObj.dep_draft_aft.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "draft_aft_dep" )) );  //  Departure Draft (CM) AFT                //  DRAFT_AFT_DEP
        formObj.arr_ballast.value=ComAddComma(tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "ballast_arr"   )) );  //  Arrival Ballast (MT)                    //  BALLAST_ARR
        formObj.dep_ballast.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "ballast_dep"   )) );    //    Departure Ballast (MT)                  //  BALLAST_DEP
        formObj.arr_rob_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fo_arr"    )) );      //  Arrival ROB (MT) F.O                    //  ROB_FO_ARR
        formObj.arr_rob_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_do_arr"    )) );      //  Arrival ROB (MT) D.O                    //  ROB_DO_ARR
        formObj.arr_rob_fw.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fw_arr"    )) );      //  Arrival ROB (MT) F.W                    //  ROB_FW_ARR
        formObj.dep_rob_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fo_dep"    )) );      //  Departure ROB (MT) F.O                  //  ROB_FO_DEP
        formObj.dep_rob_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_do_dep"    )) );      //  Departure ROB (MT) D.O                  //  ROB_DO_DEP
        formObj.dep_rob_fw.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "rob_fw_dep"    )) );      //  Departure ROB (MT) F.W                  //  ROB_FW_DEP
        formObj.arr_low_sul_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_fo_arr")) ); //   Arrival Low Sulphur (MT) F.O            //
        formObj.arr_low_sul_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_do_arr")) ); //   Arrival Low Sulphur (MT) D.O            //
        formObj.dep_low_sul_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_fo_dep")) ); //   Departure Low Sulphur (MT) F.O          //
        formObj.dep_low_sul_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "sulphur_do_dep")) );  //  Departure Low Sulphur (MT) D.O          //
        //formObj.dep_slp_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fo_arr" )) );  //  Departure Supply (MT) F.O               //  BUNKER_FO_ARR
        //formObj.dep_slp_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fo_dep" )) );  //  Departure Supply (MT) D.O               //  BUNKER_FO_DEP
        //formObj.dep_slp_fw.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fw_arr" )) );  //  Departure Supply (MT) F.W               //  BUNKER_FW_ARR
        formObj.dep_slp_fo.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fo_dep" )) );   //  Departure Supply (MT) F.O               //  BUNKER_FO_ARR
        formObj.dep_slp_do.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_do_dep" )) );   //  Departure Supply (MT) D.O               //  BUNKER_FO_DEP
        formObj.dep_slp_fw.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "bunker_fw_dep" )) );   //  Departure Supply (MT) F.W               //  BUNKER_FW_ARR
        formObj.dep_low_sul_fo_wgt.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "supply_sulphur_fo" )) );  //  Departure Supply Low Sulphur (MT) F.O   //  BUNKER_FW_DEP
        formObj.dep_low_sul_do_wgt.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "supply_sulphur_do" )) );  //  Departure Supply Low Sulphur (MT)  D.O  //  BUNKER_DO_DEP
        formObj.arr_dwt.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_arr"       )) );      //  Arrival DWT/Displ. (MT)                 //  DWT_ARR
        formObj.arr_displt.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "displ_arr"     )) );      //  Departure DWT/Displ. (MT)               //  DWT_DEP
        formObj.dep_dwt.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "dwt_dep"       )) );      //   DWT/Displ. (MT)                        //  DWT_ARR
        formObj.dep_displ.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "displ_dep"     )) );      //  Departure DWT/Displ. (MT)               //  DWT_DEP
        formObj.arr_gm.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gm_arr"        )) );          //  Arrival GM (CM)                         //  GM_ARR
        formObj.dep_gm.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gm_dep"        )) );          //  Departure GM (CM)                       //  GM_DEP
        formObj.arr_tugboat.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "tug_arr"       )) );      //  Arrival Tugboat                         //  TUG_ARR
        formObj.dep_tugboat.value=ComAddComma( tdr0Null(sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "tug_dep"       )) );      //  Departure Tugboat                       //  TUG_DEP
	}
	function setTdrHeaderVal(formObj, sheetObj){
		var prefix="sheetTdrH_";
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "pilot_arr",formObj.first_pilot_on.value);//	First Pilot On                        	//	PILOT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "anchor_arr",formObj.anchorage_arr.value);//	Anchorage                               //	ANCHOR_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "berth",formObj.berth.value);//	Berth                                   //	BERTH
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "unberth",formObj.unberth.value);//	Unberth                                 //	UNBERTH
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "anchor_dep",formObj.anchorage_dep.value);//	Anchorage                               //	ANCHOR_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "pilot_dep",formObj.last_pilot_off.value);//	Last Pilot Off                          //	PILOT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_fwd_arr",formObj.arr_draft_fwd.value);//	Arrival Draft (CM) FWD                  //	DRAFT_FWD_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_aft_arr",formObj.arr_draft_aft.value);//	Arrival Draft (CM) AFT                  //	DRAFT_AFT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_fwd_dep",formObj.dep_draft_fwd.value);//	Departure Draft (CM) FWD                //	DRAFT_FWD_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "draft_aft_dep",formObj.dep_draft_aft.value);//	Departure Draft (CM) AFT                //	DRAFT_AFT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "ballast_arr",formObj.arr_ballast.value);//	Arrival Ballast (MT)                    //	BALLAST_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "ballast_dep",formObj.dep_ballast.value);//	Departure Ballast (MT)                  //	BALLAST_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fo_arr",formObj.arr_rob_fo.value);//	Arrival ROB (MT) F.O                    //	ROB_FO_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_do_arr",formObj.arr_rob_do.value);//	Arrival ROB (MT) D.O                    //	ROB_DO_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fw_arr",formObj.arr_rob_fw.value);//	Arrival ROB (MT) F.W                    //	ROB_FW_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fo_dep",formObj.dep_rob_fo.value);//	Departure ROB (MT) F.O                  //	ROB_FO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_do_dep",formObj.dep_rob_do.value);//	Departure ROB (MT) D.O                  //	ROB_DO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "rob_fw_dep",formObj.dep_rob_fw.value);//	Departure ROB (MT) F.W                  //	ROB_FW_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_fo_arr",formObj.arr_low_sul_fo.value);//	Arrival Low Sulphur (MT) F.O            //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_do_arr",formObj.arr_low_sul_do.value);//	Arrival Low Sulphur (MT) D.O            //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_fo_dep",formObj.dep_low_sul_fo.value);//	Departure Low Sulphur (MT) F.O          //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "sulphur_do_dep",formObj.dep_low_sul_do.value);//	Departure Low Sulphur (MT) D.O          //
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fo_arr",formObj.dep_slp_fo.value);//	Departure Supply (MT) F.O               //	BUNKER_FO_ARR
        sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fo_dep",formObj.dep_slp_fo.value);//  Departure Supply (MT) F.O
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_do_dep",formObj.dep_slp_do.value);//	Departure Supply (MT) D.O               //	BUNKER_FO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "bunker_fw_dep",formObj.dep_slp_fw.value);//	Departure Supply (MT) F.W               //	BUNKER_FW_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "supply_sulphur_fo",formObj.dep_low_sul_fo_wgt.value);//	Departure Supply Low Sulphur (MT) F.O   //	BUNKER_FW_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "supply_sulphur_do",formObj.dep_low_sul_do_wgt.value);//	Departure Supply Low Sulphur (MT)  D.O  //	BUNKER_DO_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_arr",formObj.arr_dwt.value);//	Arrival DWT/Displ. (MT)                 //	DWT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "displ_arr",formObj.arr_displt.value);//	Departure DWT/Displ. (MT)               //	DWT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "dwt_dep",formObj.dep_dwt.value);//	 DWT/Displ. (MT)                        //	DWT_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "displ_dep",formObj.dep_displ.value);//	Departure DWT/Displ. (MT)               //	DWT_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gm_arr",formObj.arr_gm.value);//	Arrival GM (CM)                         //	GM_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gm_dep",formObj.dep_gm.value);//	Departure GM (CM)                       //	GM_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "tug_arr",formObj.arr_tugboat.value);//	Arrival Tugboat                         //	TUG_ARR
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "tug_dep",formObj.dep_tugboat.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "eta",formObj.eta_next_date.value);//	eta_next_date							//	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "next_port",formObj.eta_next_port.value);//	eta_next_port							//	TUG_DEP
	}
	function setTdrHeaderVal2(formObj, sheetObj){
		var prefix="sheetTdrH_";
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_work",formObj.gross_work.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_work",formObj.net_work.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "lose_hr",formObj.lost_time.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_gang",formObj.gross_gang.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_gang",formObj.net_gang.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "hatch",formObj.hatch_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "con",formObj.gear_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "mvs",formObj.move_handl.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_tml",formObj.tmnl_gross.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_tml",formObj.tmnl_net.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "gross_gc",formObj.per_gang_gross.value);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "net_gc",formObj.per_gan_net.value);//	Departure Tugboat                       //	TUG_DEP
		// 시트에 해당되는 값...
//		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "commence",t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comm"));//	Departure Tugboat                       //	TUG_DEP
//		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "complete",t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comp"));//	Departure Tugboat                       //	TUG_DEP

		var str_work_comm = t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comm");
		var str_work_comp = t2sheet1.GetCellValue(t2sheet1.HeaderRows(), "t2sheet1_work_comp");
		if( str_work_comm < 0){
			str_work_comm = "";
		}
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "commence",str_work_comm);//	Departure Tugboat                       //	TUG_DEP
		sheetObj.SetCellValue(sheetObj.GetSelectRow(), prefix + "complete",str_work_comp);//	Departure Tugboat                       //	TUG_DEP
		
	}
	function getTdrHeaderVal2(formObj, sheetObj, sXml){
		var prefix="sheetTdrH_";
		if(sheetObj.RowCount()> 0){
			formObj.gross_work.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gross_work");
			formObj.net_work.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "net_work");
			formObj.lost_time.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "lose_hr");
			formObj.gross_gang.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "gross_gang");
			formObj.net_gang.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "net_gang");
			formObj.hatch_handl.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "hatch");
			formObj.gear_handl.value=sheetObj.GetCellText(sheetObj.GetSelectRow(), prefix + "con");
/*          2010-04-13 Mvs 수정  jkc  Start */
//          formObj.move_handl.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "mvs");			
//			formObj.tmnl_gross.value			=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_tml");
//			formObj.tmnl_net.value				=	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_tml");		
//			formObj.per_gang_gross.value       	=	sheetObj.CellText(sheetObj.SelectRow, prefix + "gross_gc");		
//			formObj.per_gan_net.value           =	sheetObj.CellText(sheetObj.SelectRow, prefix + "net_gc");		
			formObj.move_handl.value=ComAddComma( ComGetEtcData(sXml, "move_handl") );  
            formObj.tmnl_gross.value=ComAddComma( ComGetEtcData(sXml, "tmnl_gross"    ) );  
            formObj.tmnl_net.value=ComAddComma( ComGetEtcData(sXml, "tmnl_net"      ) );      
            formObj.per_gang_gross.value=ComAddComma( ComGetEtcData(sXml, "per_gang_gross") );   
            formObj.per_gan_net.value=ComAddComma( ComGetEtcData(sXml, "per_gan_net"   ) );  
            /*          2010-04-13 Mvs 수정  jkc  End */
			if(ComGetEtcData(sXml, "used_crane") != null || ComGetEtcData(sXml, "used_crane") != undefined){
				formObj.used_crane.value=ComGetEtcData(sXml, "used_crane");	
				beforeCraneCnt=ComGetEtcData(sXml, "used_crane");	
				formObj.avg_crane.value=tdrRound( ComGetEtcData(sXml, "avg_crane"), 2);
			}else{//
				formObj.used_crane.value="0";	
				beforeCraneCnt  ="0";
				formObj.avg_crane.value="0";
			}
		}else{
			formObj.gross_work.value="";	
			formObj.net_work.value="";		
			formObj.lost_time.value="";		
			formObj.gross_gang.value="";	
			formObj.net_gang.value="";		
			formObj.hatch_handl.value="";		
			formObj.gear_handl.value="";			
			formObj.move_handl.value="";			
			formObj.tmnl_gross.value="";
			formObj.tmnl_net.value="";		
			formObj.per_gang_gross.value="";		
			formObj.per_gan_net.value="";		
			formObj.used_crane.value="0";	
			formObj.avg_crane.value="0";
			beforeCraneCnt  ="0";
		}
	}
	function setCraneSheet(){
		var sheetObj=t2sheet1;
		//첫번째 Row는 조회모드.
		sheetObj.SetRowStatus(sheetObj.HeaderRows(),"R");
		//어차피 생성된 놈인지 알수가 없음... 모두 Insert 모드...
		for(var idxRow=sheetObj.HeaderRows()+1; idxRow <= sheetObj.LastRow(); idxRow++){
			sheetObj.SetRowStatus(idxRow,"I");
		}
	}
	
	function formReadonly(readonly){
		var frmObj=document.getElementsByTagName("form"); 
		var fObj=frmObj.item(0); 
		
			//버튼 Enable/Disable
			for( var k=0; k < enableButton.length; k++){
				if(readonly){
					//프린트 버트과 Exclude from TPR이외에는 Disable			
					ComBtnDisable(enableButton[k]);
				}else{
					if(sheetObjects[2].RowCount()>0){
						ComBtnEnable(enableButton[k]);
					}else{
						ComBtnEnable(enableButton2[k]);
					}
					
				}
			}
			
		//TextBox  readonly/writable
		for(var idxObj=0; idxObj < fObj.length; idxObj++){
//			var objText=fObj.item(idxObj);
			var objText=fObj[idxObj];
			/*
				요건 변경 2010-02-18 
				조회조건은 활성화. 나머지 Hatch Cover Handling, Gear Box Handling, Total Container Handling Moves, Remark 는 활성화 비 활성화.
			*/
			if(	objText.name == "vsl_cd" ||
				objText.name == "skd_voy_no" || 
				objText.name == "skd_dir_cd" ){
				objText.readOnly=false;
			}else if(	objText.name == "hatch_handl" || 
						objText.name == "gear_handl" || 
					//	objText.name == "move_handl" || 
						objText.name == "used_crane" ){
				//2010.12.27 P.H.D 추가
				objText.readOnly=readonly;
				objText.className=(readonly ? "input2" : "input");
			}else if(objText.name == "tdr_info"){
				objText.readOnly=readonly;
				objText.className=(readonly ? "input2" : "textarea");
			}else if(objText.type == "text"){
				objText.readOnly=true;
				objText.className="input2";
			}
		}
		//Sheet의 Write설정
		for(var idx=0; idx < sheetObjects.length - 1; idx++){
			sheetObjects[idx].SetEditable((readonly ? 0 : 1));
		}
		var frame=document.getElementById("t3frame");
		if(frame.src != ""){
			frameButtonSheet(document.t3frame, readonly);
		}
		var frame=document.getElementById("t4frame");
		if(frame.src != ""){
			frameButtonSheet(document.t4frame, readonly);
		}
		var frame=document.getElementById("t5frame");
		if(frame.src != ""){
			frameButtonSheet(document.t5frame, readonly);
		}
		var frame=document.getElementById("t6frame");
		if(frame.src != ""){
			frameButtonSheet(document.t6frame, readonly);
		}
		var frame=document.getElementById("t7frame");
		if(frame.src != ""){
			frameButtonSheet(document.t7frame, readonly);
		}
		var frame=document.getElementById("t8frame");
		if(frame.src != ""){
			frameButtonSheet(document.t8frame, readonly);
		}
		var frame=document.getElementById("t9frame");
		if(frame.src != ""){
			frameButtonSheet(document.t9frame, readonly);
		}
	}
	function frameButtonSheet(objFrame, readonly){
		//Button Enable
		for( var k=0; objFrame.enableButton!=undefined && k < objFrame.enableButton.length; k++){
			if(readonly){
				objFrame.ComBtnDisable(objFrame.enableButton[k]);
			}else{
				objFrame.ComBtnEnable(objFrame.enableButton[k]);
			}
		}
		for(var idx=0; objFrame.sheetObjects!=undefined && idx < objFrame.sheetObjects.length; idx++){
			objFrame.sheetObjects[idx].SetEditable((readonly ? 0 : 1));
		}
	}
	/**
	 * 2010.12.21 P.H.D. 추가 Slot 탭을 위해 별도로 만듬...
	 * Externally일 경우 BSA는 수정불가, HC 4/5내 loaded, add slot은 수정불가, 그외는 모두 수정가능
	 * @param objFrame
	 * @param subTabNo
	 */
	function frameButtonSheetSub(objFrame, subTabNo){
		gSubTabNo=subTabNo;
		var readOnly=true;
		readOnly=false;
		//Main Button Handing
		for( var k=0; k < enableButton.length; k++){
			if(readOnly){
				ComBtnDisable(enableButton[k]);
			}else{
				ComBtnEnable(enableButton[k]);
			}
		}
		//Button Enable
		for( var k=0; k < objFrame.enableButton.length; k++){
			if(readOnly){
				objFrame.ComBtnDisable(objFrame.enableButton[k]);
			}else{
				//readOnly false여도 EX이면 row버튼을 disable시킨다.
				objFrame.ComBtnEnable(objFrame.enableButton[k]);
			}
		}
		for(var idx=0; idx < objFrame.sheetObjects.length; idx++){
			objFrame.sheetObjects[idx].SetEditable((readOnly ? 0 : 1));
		}
	}
	function calenderCall(srcName){
		var objName=srcName.substring(4);
		var cal=new ComCalendar();
		cal.select(document.form.item(objName), 'yyyy-MM-dd');
		document.form.item(objName).value=document.form.item(objName).value;
	}
	function setTabEditSheet(){ 
		sheetCheckEdit=new Array();
		switch(marrTabTitle[beforetab]){
			case "SKD & COND":
				sheetCheckEdit[0]=sheetTdrH;
				break;
			case "Port Log":
				sheetCheckEdit[0]=sheetTdrH;
				sheetCheckEdit[1]=t2sheet1;
				break;
			case "Disch. Vol.":
				sheetCheckEdit[0]=sheetTdrH;
				if(t3frame.t3sheet1 != null && t3frame.t3sheet1 != undefined){
					sheetCheckEdit[1]=t3frame.t3sheet1;
					sheetCheckEdit[2]=t3frame.t3sheet2;
					sheetCheckEdit[3]=t3frame.t3sheet3;
				}
				break;
			case "Load Vol.":
				sheetCheckEdit[0]=sheetTdrH;
				if(t4frame.t4sheet1 != null && t4frame.t4sheet1 != undefined){
					sheetCheckEdit[1]=t4frame.t4sheet1;
					sheetCheckEdit[2]=t4frame.t4sheet2;
					sheetCheckEdit[3]=t4frame.t4sheet3;
					sheetCheckEdit[4]=t4frame.t4sheet4;
				}
				break;
			case "COD":
				sheetCheckEdit[0]=sheetTdrH;
				if(t5frame.t5sheet1 != null && t5frame.t5sheet1 != undefined){
					sheetCheckEdit[1]=t5frame.t5sheet1;
				}
				break;
			case "R/H":
				sheetCheckEdit[0]=sheetTdrH;
				if(t6frame.t6sheet1 != null && t6frame.t6sheet1 != undefined){
					sheetCheckEdit[1]=t6frame.t6sheet1;
				}
				break;
			case "Mishandle":
				sheetCheckEdit[0]=sheetTdrH;
				if(t7frame.t7sheet1 != null && t7frame.t7sheet1 != undefined){
					sheetCheckEdit[1]=t7frame.t7sheet1;
				}
				break;
			case "Slot":
				sheetCheckEdit[0]=sheetTdrH;
				if(t8frame.t8sheet1 != null && t8frame.t8sheet1 != undefined){
					sheetCheckEdit[1]=t8frame.t8sheet1;
					sheetCheckEdit[2]=t8frame.t8sheet2;
					sheetCheckEdit[3]=t8frame.t8sheet3;
					sheetCheckEdit[4]=t8frame.t8sheet4;
				}
				break;
			case "Temp. STWG":
				sheetCheckEdit[0]=sheetTdrH;
				if(t9frame.t9sheet1 != null && t9frame.t9sheet1 != undefined){
					sheetCheckEdit[1]=t9frame.t9sheet1;
				}
				break;
			case "Remark(s)":
				sheetCheckEdit[0]=sheetTdrH;
				break;
		}
	}
	function sheetRemoveAll(){
		sheetCheckEdit[0].SetRowStatus(sheetCheckEdit[0].GetSelectRow(),"R");
		for(var cnt=1; cnt < sheetCheckEdit.length; cnt++){
			sheetCheckEdit[cnt].RemoveAll();
		}
	}
	function calcuPortLog(formObject, sheetObj){
		var prefix="t2sheet1_";
		/*
			=================================Port Log 계산방법	=================================
			0. Average Number of Used Crane=Gross Gang Hours / Gross Work Hours
			1. Gross Working Hours=각 Crane중 Max Work Completed ? 각 Crane중 Min Work Commenced
			2. Net Working Hours=각 Crane Work Time (Completed-Commence) 중 Max 값
			3. Lost Time by G/Crane=Gross Work Hours ? Net Work Hours
			4. Gross Gang Hours=각 Crane Work Time (Completed-Commence)을 합한 값
			5. Net Gang Hours=Gross Gang Hours에서 각 Crane의 Lost Time을 뺀 값
			6. Terminal Gross=Total Container Handling Moves / Gross Work Hours
			7. Terminal Net=Total Container Handling Moves / Net Work Hours
			8. Per Gang Gross=Total Container Handling Moves / Gross Gang Hours
			9. Per Gang Gross=Total Container Handling Moves / Net Gang Hours
			-- 2009-10-15 수정
			2. Net Working Hours=각 Crane Work Time (Completed-Commence) 중 Max 값 
								   같은값이 2개이상이면 그중 Total Loas Time중 Max값
			3. Lost Time by G/Crane=Max Row 의 Completed - Commence - Total Lose Time
			-- 2009-10-27 수정
			Number of Used Crane을 0인 상태에서 Tdr헤더만의 정보만 수정시에. Productivity 수정가능.
			==========================================================================================
		*/
		with(sheetObj){
			if(RowCount()< 2){
				calcuPortLogHeader();
				return;
			}
			var maxNetWork=0;
			var sumGang=0;
			var sumLose=0;
			var idxMaxTime="";
			for(var idxRow=HeaderRows()+ 1; idxRow <= LastRow(); idxRow++){
//no support[check again]CLT 				var tmpMM=EvalDateDiff("N", GetCellText(idxRow, prefix + "work_comm") + ":00", GetCellText(idxRow, prefix + "work_comp") + ":00");
  		        var tmpMM=sheet_dateDiff(GetCellText(idxRow, prefix + "work_comm").replace(" ", "T"), GetCellText(idxRow, prefix + "work_comp").replace(" ", "T"), 'N');
				if(maxNetWork < tmpMM){
					maxNetWork=tmpMM;
					idxMaxTime=idxRow + ",";
				}else if(maxNetWork == tmpMM){
					idxMaxTime=idxMaxTime + idxRow +  ",";
				}
/*
				var arrHHMM=GetCellText(idxRow, prefix + "total").split(":");
				var loseMM=parseInt(arrHHMM[0]) * 60 + parseInt(arrHHMM[1]);
*/
				var loseMM=parseHHMM(GetCellText(idxRow, prefix + "total"));
				sumLose += loseMM;
				sumGang += tmpMM;
			}
// 			var glossTemp=EvalDateDiff("N", GetCellText(HeaderRows(), prefix + "work_comm") + ":00",
//								              GetCellText(HeaderRows(), prefix + "work_comp") + ":00");
 			var glossTemp=sheet_dateDiff(GetCellText(HeaderRows(), prefix + "work_comm").replace(" ","T"),
								              GetCellText(HeaderRows(), prefix + "work_comp").replace(" ","T"), "N");
			formObject.gross_work.value=parseInt(glossTemp / 60) + ":" + fillZero(glossTemp % 60);
			//Completed-Commence의 Max지만 같은 값이 있으면. Lose의 최고값을 찾아낸다...
			var arrSearchLose=idxMaxTime.split(",");
			var idxMaxLose=0;
			var valMaxLose=0;
			
			if(arrSearchLose.length > 2){
				for(var idxFind = 0; idxFind < arrSearchLose.length - 1; idxFind++){
					var arrHHMM = GetCellText(parseInt(arrSearchLose[idxFind]), prefix + "total").split(":");
					var tempLose = parseInt(arrHHMM[0], 10) * 60 + parseInt(arrHHMM[1], 10);

					if(valMaxLose < tempLose){
						idxMaxLose = parseInt(arrSearchLose[idxFind]);
						valMaxLose = tempLose;
					//lose time 이 없을 경우 idxMaxLose 셋팅
					} else if(valMaxLose == 0 && tempLose == 0){
						idxMaxLose = parseInt(arrSearchLose[idxFind]);
					}
				}
				//아무것두 선택이 되지 않았을때.........
				if(valMaxLose < 0){
					idxMaxLose = parseInt(arrSearchLose[0]);
					valMaxLose = 0;
				}
			}else{
				idxMaxLose = parseInt(arrSearchLose[0]);

				var arrHHMM = GetCellText(parseInt(arrSearchLose[0]), prefix + "total").split(":");
				valMaxLose = parseInt(arrHHMM[0], 10) * 60 + parseInt(arrHHMM[1], 10);
			}			
			
/*
//no support[check again]CLT 			maxNetWork=EvalDateDiff("N", GetCellText(idxMaxLose, prefix + "work_comm") + ":00", GetCellText(idxMaxLose, prefix + "work_comp") + ":00");
			losework=maxNetWork - valMaxLose;
*/			
//no support[check again]CLT 			maxNetWork=EvalDateDiff("N", GetCellText(idxMaxLose, prefix + "work_comm") + ":00", GetCellText(idxMaxLose, prefix + "work_comp") + ":00");
			
			maxNetWork= sheet_dateDiff(GetCellText(idxMaxLose, prefix + "work_comm").replace(" ","T"), GetCellText(idxMaxLose, prefix + "work_comp").replace(" ","T"), "N");	// + ":00"
			    
			losework=valMaxLose;
			maxNetWork -= losework;
			formObject.net_work.value=parseInt(maxNetWork / 60) + ":" + fillZero(maxNetWork % 60);
			formObject.lost_time.value=parseInt(losework / 60) + ":" + fillZero(losework % 60);
			formObject.gross_gang.value=parseInt(sumGang / 60) + ":" + fillZero(sumGang % 60);
			//var netGang = sumGang - (glossTemp - maxNetWork);
			var netGang=sumGang - sumLose;
			formObject.net_gang.value=parseInt(netGang / 60) + ":" + fillZero(netGang % 60);
			//Gross Gang Hours / Gross Work Hours
			formObject.avg_crane.value=tdrRound(sumGang / glossTemp);
/*
			if(formObject.move_handl.value != ""){
				formObject.tmnl_gross.value=ComRound(parseInt(formObject.move_handl.value) / parseFloat(glossTemp / 60), 1);
				formObject.tmnl_net.value=ComRound(parseInt(formObject.move_handl.value) / parseFloat(maxNetWork / 60), 1);
				formObject.per_gang_gross.value=ComRound(parseInt(formObject.move_handl.value) / parseFloat(sumGang / 60), 1);
				formObject.per_gan_net.value=ComRound(parseInt(formObject.move_handl.value) / parseFloat(netGang / 60), 1);
			}
*/
			if(formObject.move_handl.value != ""){
				calcuPortLogHeader();
			}
		}
	}
	
	function dateDiff22(fm_dt, to_dt , gubun){
		if(gubun == null || gubun== "" || gubun == undefined || gubun == "undefined" || gubun=="null"){
			gubun = "D";
		}
		
		if(typeof(fm_dt) == "string"){
			fm_dt = new Date(fm_dt);
		}
		if(typeof(to_dt) == "string"){
			to_dt = new Date(to_dt);
		}
		
		if(gubun == "YYYY"){
			return parseInt(to_dt.getFullYear() - fm_dt.getFullYear() , 10);
		} else if ( gubun == "M"){
			return parseInt( (to_dt.getFullYear() - fm_dt.getFullYear())* 12 + ( (to_dt.getMonth()+1) - (fm_dt.getMonth()+1) ) ,10 );
		} else if ( gubun == "D"){
			return parseInt((to_dt - fm_dt)/(1000*60*60*24) , 10);
		} else if ( gubun == "H"){
			return parseInt((to_dt - fm_dt)/(1000*60*60) , 10);
		} else if ( gubun == "N"){
			return parseInt((to_dt - fm_dt)/(1000*60) , 10);
		} else if ( gubun == "S"){
			return parseInt((to_dt - fm_dt)/1000 , 10);
		}
	}
	
	function calcuPortLogHeader(){
		var formObject=document.form; 
		//Total Container Handling Moves가 없을시에 Pass...
		if(formObject.move_handl.value == "")
			return;
		var moveHandle=parseInt(ComReplaceStr(formObject.move_handl.value, ",", ""));
      log(   formObject.gross_work.value.replace(":","")   );
		if(formObject.gross_work.value != "" && parseInt(  formObject.gross_work.value.replace(":","") )  != 0   ){
			formObject.tmnl_gross.value=tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_work.value) / 60), 1);
		}
		if(formObject.net_work.value != "" && parseInt(  formObject.net_work.value.replace(":","") )  != 0  ){
			formObject.tmnl_net.value=tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_work.value) / 60), 1);
		}
		if(formObject.gross_gang.value != "" && parseInt(  formObject.gross_gang.value.replace(":","") )  != 0  ){
			formObject.per_gang_gross.value=tdrRound(moveHandle / parseFloat(parseHHMM(formObject.gross_gang.value) / 60), 1);
		}
		if(formObject.net_gang.value != "" && parseInt(  formObject.net_gang.value.replace(":","") )  != 0  ){
			formObject.per_gan_net.value=tdrRound(moveHandle / parseFloat(parseHHMM(formObject.net_gang.value) / 60), 1);
		}
		if( formObject.gross_work.value != "" && formObject.gross_gang.value != ""
		){
		    if ( parseInt(  formObject.gross_work.value.replace(":","") )  != 0 
		      && parseInt(  formObject.gross_gang.value.replace(":","") )  != 0 ){ 
		        formObject.avg_crane.value=tdrRound(parseHHMM( formObject.gross_gang.value ) / parseHHMM( formObject.gross_work.value ));
		    }else if ( parseInt(  formObject.gross_work.value.replace(":","") )  != 0 ){
		        formObject.avg_crane.value=formObject.gross_work.value  ;
		    }else if ( parseInt(  formObject.gross_gang.value.replace(":","") )  != 0 ){
                formObject.avg_crane.value=formObject.gross_gang.value  ;
            }
		} 
	}
	function fillZero(str){
		if(parseInt(str) < 10){
			str="0" + str;
		}
		return str;
	}
	function parseHHMM(hhmm){
		var arrHHMM=hhmm.split(":");
		var strHH=arrHHMM[0];
		var strMM=arrHHMM[1];
		var sumMM=0;
		if(strHH.substring(0, 2) == "00"){
			sumMM=parseInt(strHH.substring(2)) * 60;
		}else if(strHH.substring(0, 1) == "0"){
			sumMM=parseInt(strHH.substring(1)) * 60;
		}else{
			sumMM=parseInt(strHH) * 60;
		}
		if(strMM.substring(0, 1) == "0"){
			sumMM += parseInt(strMM.substring(1));
		}else{
			sumMM += parseInt(strMM);
		}
		return sumMM;
	}

	function setSheetIdx(sheetObj, idx, colNm){
		for(var cnt=sheetObj.HeaderRows(); cnt <= sheetObj.LastRow(); cnt++){
			if(sheetObj.GetRowStatus(cnt) == "I" || sheetObj.GetRowStatus(cnt) == "U" || sheetObj.GetRowStatus(cnt) == "D"){
				sheetObj.SetCellValue(cnt, sheetObj.id + "_" + colNm,idx);
			}
		}
	}
	
	function filterMishandle(sheetObj, misHandleChk){
		for(var idxRow=sheetObj.HeaderRows(); idxRow <= sheetObj.LastRow(); idxRow++){
			if(sheetObj.GetCellValue(idxRow, "t7sheet1_mishandle_chk") == misHandleChk){
				sheetObj.SetRowHidden(idxRow,0);
			}else{
			    if( sheetObj.RowCount()!= 0 ){
			        sheetObj.SetRowHidden(idxRow,1);
			    }
			}
		}
	}
	function jshUseVal(formObj){
		formObj.vsl_cd.value="HJCQ";
		formObj.skd_voy_no.value="0005";
		formObj.skd_dir_cd.value="W";
		searchVVDInfo();
		yd_cd.SetSelectCode("KRPUSYG");
		//doActionIBSheet(beforetab, formObj, IBSEARCH);
	}
	
	function dupcheckSave(tabNm, tabChange){
		var idxRow=0;
		var dupRow=0;
		var	dupSheet=null;
		var	dupCol=null;
		switch(tabNm){
			case "Disch. Vol.":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t3frame.t3sheet1;
				dupSheet[1]=t3frame.t3sheet2;
				dupSheet[2]=t3frame.t3sheet3;
				dupCol[0]="t3sheet1_opr_cd";
				dupCol[1]="t3sheet2_opr_cd";
				dupCol[2]="t3sheet3_opr_cd|t3sheet3_cntr_no";
				break;
			case "Load Vol.":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t4frame.t4sheet1;
				dupSheet[1]=t4frame.t4sheet2;
				dupSheet[2]=t4frame.t4sheet3;
				dupSheet[3]=t4frame.t4sheet4;
				dupCol[0]="t4sheet1_opr_cd|t4sheet1_pod_cd";
				dupCol[1]="t4sheet2_opr_cd|t4sheet2_pod_cd";
				dupCol[2]="t4sheet3_opr_cd|t4sheet3_pod";
				dupCol[3]="t4sheet4_pod|t4sheet4_opr_cd|t4sheet4_cntr_no";
				break;
			case "COD":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t5frame.t5sheet1;
				dupCol[0]="t5sheet1_cntr_no|t5sheet1_opr_cd";
				break;
				
			case "R/H":
				dupSheet	= new Array();
				dupCol		= new Array();
				dupSheet[0]	= t6frame.t6sheet1;
				dupCol[0]	= "t6sheet1_cntr_no";
				break;
				
			case "Mishandle":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t7frame.t7sheet1;
				dupCol[0]="t7sheet1_cntr_no|t7sheet1_opr_cd";
				break;
			case "Slot":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t8frame.t8sheet1;
				dupSheet[1]=t8frame.t8sheet2;
				dupSheet[2]=t8frame.t8sheet3;
				dupSheet[3]=t8frame.t8sheet4;
				dupCol[0]="t8sheet1_opr_cd";
				dupCol[1]="t8sheet2_opr_cd";
				dupCol[2]="t8sheet3_opr_cd";
				dupCol[3]="t8sheet4_opr_cd";
				break;
			case "Temp. STWG":
				dupSheet=new Array();
				dupCol=new Array();
				dupSheet[0]=t9frame.t9sheet1;
				dupCol[0]="t9sheet1_cntr_no|t9sheet1_opr_cd";
				break;
		}
		
		if(dupSheet != "undefined" && dupSheet != null){
			for( ; idxRow < dupSheet.length; idxRow++){
				dupRow=dupSheet[idxRow].ColValueDup(dupCol[idxRow], true);
				if(dupRow != -1){
					break;
				}
			}
			if(dupRow != -1){
				var arrColName=dupCol[idxRow].split("|");
				if(dupSheet.length > 1){
					if(tabNm == "Disch. Vol." && t3frame.beforeDistchVolTab != idxRow){
						t3frame.form.chk_DischVol[idxRow].checked=true;
						t3frame.disChargTabChange();
					}
					if(tabNm == "Load Vol." && t4frame.beforeDistchVolTab != idxRow){
						t4frame.form.chk_LoadVol[idxRow].checked=true;
						t4frame.disLoadTabChange();
					}
				}
				ComShowCodeMessage("COM131302", "Data"); 
				for(idxCol=0; idxCol < arrColName.length; idxCol++){
					dupSheet[idxRow].SetCellValue(dupRow, arrColName[idxCol],"");
				}
				dupSheet[idxRow].SelectCell(dupRow, arrColName[0], true);
				if(tabChange){
					tabObjects[0].SetSelectedIndex(beforetab);
				}
				return false;
			}
		}
		return true;
	}
	
	function multiInputCheck(){
		for (var idxArr=1; idxArr < sheetCheckEdit.length; idxArr++){
			if( parseInt(sheetCheckEdit[idxArr].RowCount("I")) + 
				parseInt(sheetCheckEdit[idxArr].RowCount("U")) + 
				parseInt(sheetCheckEdit[idxArr].RowCount("D"))		> 0 ){
				var sParam=ComGetSaveString(sheetCheckEdit[idxArr]);
				if(sParam == ""){
					if(marrTabTitle[beforetab] == "Disch. Vol." && t3frame.beforeDistchVolTab != (idxArr - 1)){
						t3frame.form.chk_DischVol[idxArr - 1].checked=true;
						t3frame.disChargTabChange();
					}
					if(marrTabTitle[beforetab] == "Load Vol." && t4frame.beforeLoadVolTab != (idxArr - 1)){
						t4frame.form.chk_LoadVol[idxArr - 1].checked=true;
						t4frame.disLoadTabChange();
					}
					if(marrTabTitle[beforetab] == "Slot" && t8frame.beforeSlotTab != (idxArr - 1)){
						t8frame.form.chk_Slot[idxArr - 1].checked=true;
						t8frame.disSlotTabChange();
					}
					return false;
				}
			}
		}
		return true;
	}
	function duplCheck(sheetObj,Row, Col, Value, chkCol){
		var dupRow=sheetObj.ColValueDup(chkCol, true);
		var arrCheckCol=chkCol.split("|");
		if(arrCheckCol == null || arrCheckCol.length < 2){
			if(dupRow != -1 && sheetObj.GetCellValue(dupRow, chkCol) != '') {
				ComShowCodeMessage('COM131302', "Data"); 
				sheetObj.SetCellValue(dupRow, Col,"");
				//해당 Row포커스.. ....
				sheetObj.SelectCell(dupRow, chkCol, true);
				return;
			}
		}else{
			if(dupRow != -1){
				for(var cnt=0; cnt < arrCheckCol.length; cnt++){
					if(sheetObj.GetCellValue(dupRow, arrCheckCol[cnt]) == ''){
						return;
					}
				}
				ComShowCodeMessage('COM131302', "Data"); 
				for(var cnt=0; cnt < arrCheckCol.length; cnt++){
					sheetObj.SetCellValue(dupRow, arrCheckCol[cnt],"");
				}
				//해당 Row포커스.. ....
				sheetObj.SelectCell(dupRow, arrCheckCol[0], true);
				return;
			}
		}
	}
	/**
	 * 화면 컨트롤 End
	 */
	 /**
	  * Popup 클릭시 Call Back Start ...
	  */
	function setCallBackVSL(rtnObjs) {
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("vsl_cd", rtnDatas[1]);
					obj_nextfocus(document.form.vsl_cd);
				}
			}
		}
	} 
	function setCallBackVVD(obj) {
		if(obj){
			var rtnDatas=obj[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
				setObjValue("skd_voy_no", rtnDatas[2]);
				setObjValue("skd_dir_cd", rtnDatas[3]);
				}
			}
		}
		//[#1-2]VVD 관련 항목 채우기
		searchVVDInfo();
	} 
	function setCallBackPort(rtnObjs){
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					setObjValue("eta_next_port", rtnDatas[3]);
				}
			}
		}
	}
	function getCallBackOprCd(sheetObj, prefix, colNm, Row, Col){
		popupSheet=sheetObj;
		popupPrefix=prefix;
		popupColNm=colNm;
		ComOpenPopup("COM_ENS_0N1.do", 530, 530, "setCallBackOprCd", "0,0,1,1,1,1", true, false, Row, Col, 0);
	}
	
	function setCallBackOprCd(rtnObjs){
		if(rtnObjs){
			var rtnDatas=rtnObjs[0];
			if(rtnDatas){
				if(rtnDatas.length > 0){
					popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + popupColNm,rtnDatas[3]);
					if(popupPrefix == "t6sheet1_" && popupColNm == "account"){
						var param = "";
						param += "f_cmd=" + SEARCH15;
						param += "&crr_cd=" + rtnDatas[3];
				 		var sXml=sheetObjects[0].GetSearchData("VOP_OPF_UTILGS.do", param);
				 		var value=ComGetEtcData(sXml, "value");
				 		popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + "party", value, 0);
				 		
				 		var shift_rsn = popupSheet.GetCellValue(popupSheet.GetSelectRow(), popupPrefix + "shift_rsn");
				 		if(shift_rsn.substring(0, 2) != ""){
				 			popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupPrefix + "shift_rsn", shift_rsn.substring(0, 2) + value, 0);	
				 		}
				 		
				 		
					}
					if(popupSheet.SaveNameCol(popupSheet.id + "_chk_valid") > 0){
						popupSheet.SetCellValue(popupSheet.GetSelectRow(), popupSheet.id + "_chk_valid","Y");
					}
				}
			}
		}
		mCheckValue=false;
	} 
	function getCallBackRsn(sheetObj, colNm, Row, Col){
		ComOpenPopup("VOP_OPF_0040POP.do", 700, 500, "", "0,0,1,1,1,1", true, false, Row, Col, 0);
	}
	function exTPR(classNm){
		document.all("btn_ExcludefromTPR").style.color=classNm;
	}
	 /**
	  * Popup 클릭시 Call Back End ...
	  */
	/**
     * Screen New
	 */
	function tdrScreenNew(formObject, checkFlag){
		var changeSheet2=false;
//      Req : 2010-04-06 요구사항. : New 버튼 사용시, 무조건 바로 클리어 		
//		if(checkFlag){
//			if(sheetCheckEdit != null){
//				if(sheetCheckEdit.length != null){
//					for(var cnt = 0; cnt < sheetCheckEdit.length; cnt++){
//						if(
//							(
//								parseInt(sheetCheckEdit[cnt].RowCount("I")) + 
//								parseInt(sheetCheckEdit[cnt].RowCount("U")) + 
//								parseInt(sheetCheckEdit[cnt].RowCount("D"))
//							) 
//							> 0
//						){
//								changeSheet2 = true;
//								break;
//						}
//					}
//				}
//			}
//		}
//
//		if(changeSheet2 && !ComShowCodeConfirm("COM130504")){
//			return;
//		}
		formObject.vsl_cd.value="";
		resetFormNsheet(formObject.vsl_cd);
		formObject.vsl_cd.focus();
		if(marrTabTitle[beforetab] == "Disch. Vol."){
		     t3frame.form.chk_DischVol[0].checked=true;
			//document.form.chk_DischVol[0].checked = true;   2010.03.31 Bug 수정 - Jkc
			if(t3frame.beforeDistchVolTab != 0)
			    t3frame.disChargTabChange();
		}else if(marrTabTitle[beforetab] == "Load Vol."){
		    t4frame.form.chk_LoadVol[0].checked=true;  //2010.03.31 Bug 수정 - Jkc
			if(t4frame.beforeLoadVolTab != 0)
			    t4frame.disLoadTabChange(); //2010.03.31 Bug 수정 - Jkc
		}else if(marrTabTitle[beforetab] == "Slot"){
		    t8frame.form.chk_Slot[0].checked=true;
			if(t8frame.beforeSlotTab != 0){
			    t8frame.disSlotTabChange();
			}
		}
		multiSearchCheck=false;
		mCheckValue=false;
	}
	function readonlStatus(){
		var parentReaonly=true;
		if(sheetTdrH.RowCount()> 0){
				parentReaonly=false;
		}else {
			parentReaonly=true;			
		}
		return parentReaonly; 
	}
	function tdrRound(obj, posN){
        if (posN==undefined || posN==null ) posN=2;
		var rstFloat=ComRound(obj, posN);
		var strFloat=rstFloat + "";
		var flt="";
		if(strFloat.indexOf(".") == -1){
			for(var cnt=0; cnt < posN; cnt++){
				flt=flt + "0";
			}
			strFloat=strFloat + "." +  flt;
		}else{
			var arrFloat=strFloat.split(".");
			if(arrFloat[1].length < posN){
				for(var cnt=arrFloat[1].length; cnt < posN; cnt++){
					flt=flt + "0";
				}
				strFloat=strFloat + flt;
			}
		}
		return strFloat;
	}
    function tdr0Null(obj){
        obj=ComReplaceStr(obj, ",","");
        if( eval( obj ) ==  0 )return "";
        return obj;
    }
    function tdrRoundNull(obj, posN){
        if (posN==undefined || posN==null ) posN=2;
        if ( obj == ""  ){
            return "";
        }else {
            obj=obj.replaceStr(",","");
            if( eval( obj ) ==  0 )return "";
        }
        var rstFloat=ComRound(obj, posN);
        var strFloat=rstFloat + "";
        var flt="";
        if(strFloat.indexOf(".") == -1){
            for(var cnt=0; cnt < posN; cnt++){
                flt=flt + "0";
            }
            strFloat=strFloat + "." +  flt;
        }else{
            var arrFloat=strFloat.split(".");
            if(arrFloat[1].length < posN){
                for(var cnt=arrFloat[1].length; cnt < posN; cnt++){
                    flt=flt + "0";
                }
                strFloat=strFloat + flt;
            }
        }
        return strFloat;
    }
    
	function checkExcelValidate(){
		var prefix="t6sheet1_";
		
		var sXml=sheetTdrH.GetSearchData("COM_ENS_0N1GS.do", "f_cmd=" + SEARCH );
		var oprData=ComScgXml2Array(sXml, "crr_cd");
		
		var sXml=sheetTdrH.GetSearchData("VOP_OPF_0075GS.do", "f_cmd=" + SEARCH );
		var reasonData=ComOpfXml2Array(sXml, "rstwg_rsn_cd");

		var sXml=sheetTdrH.GetSearchData("VOP_OPF_UTILGS.do", "f_cmd=" + SEARCH15 );
		var partyData=ComOpfXml2Array(sXml, "xter_cd_ctnt|inter_cd_ctnt");
		
		for(var idxRow=sheetCheckEdit[1].HeaderRows(); idxRow <= sheetCheckEdit[1].LastRow(); idxRow++){
			if(sheetCheckEdit[1].GetCellValue(idxRow, prefix + "check_row") == "N"){
				//Cntr Check...........
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "cntr_no") != ""){
					if(!ComIsAlphabet(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "cntr_no"), "n")) {
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "cntr_no"));
						sheetCheckEdit[1].SetCellValue(idxRow,  prefix + "cntr_no","");
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "cntr_no", false);
						return false;
					}
				}
				//Type/Size Check...........
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "sztp") != ""){
					var arrSztpCode = mSztpCode.split("|");
					if(checkExistArrayIndex(arrSztpCode, sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "sztp")) == -1){
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "sztp"));
						sheetCheckEdit[1].SetCellValue(idxRow, prefix + "sztp","", 0);
						sheetCheckEdit[1].SelectCell(idxRow, prefix + "sztp", false);
						return false;
					}
				}
				//POL Check...........
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "pol") != ""){
					var arrPodCode = mPodCode.split("|");
					if(checkExistArrayIndex(arrPodCode, sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "pol")) == -1){
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "pol"));
						sheetCheckEdit[1].SetCellValue(idxRow, prefix + "pol","", 0);
						sheetCheckEdit[1].SelectCell(idxRow, prefix + "pol", false);
						return false;
					}
				}
				//Operator체크.
				var opr_cd = sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "opr_cd");
				if(opr_cd != ""){
					
					if(checkExistArrayIndex(oprData, opr_cd) == -1){
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "opr_cd"));
						sheetCheckEdit[1].SetCellValue(idxRow, prefix + "opr_cd","",0);
						sheetCheckEdit[1].SelectCell(idxRow, prefix + "opr_cd", false);
						return false;
					}
				}
				//From Position체크.
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "precell") != ""){
					if(!ComIsNumber(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "precell"))) {
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "precell"));
						sheetCheckEdit[1].SetCellValue(idxRow,  prefix + "precell","",0);
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "precell", false);
						return false;
					}
				}
				//To Position체크.
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "position") != ""){
					if(!ComIsNumber(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "position"))) {
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "position"));
						sheetCheckEdit[1].SetCellValue(idxRow,  prefix + "position","",0);
						sheetCheckEdit[1].SelectCell(idxRow,  prefix + "position", false);
						return false;
					}
				}
				//Reason Code체크.
				var shiftRsn = sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "shift_rsn");
				if(shiftRsn != ""){
					if(shiftRsn.substring(0, 1) != "S" && shiftRsn.substring(0, 1) != "D"){
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "shift_rsn"));
						sheetCheckEdit[1].SetCellValue(idxRow, prefix + "shift_rsn","",0);
						sheetCheckEdit[1].SelectCell(idxRow, prefix + "shift_rsn", true);
						return false;
					}else{
						if(checkExistArrayIndex(reasonData, shiftRsn.substring(1,2)) == -1){
							ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "shift_rsn"));
							sheetCheckEdit[1].SetCellValue(idxRow, prefix + "shift_rsn","",0);
							sheetCheckEdit[1].SelectCell(idxRow, prefix + "shift_rsn", true);
							return false;
						}
						
						var party = sheetCheckEdit[1].GetCellValue(idxRow, prefix + "party")
						if(party != "T" && party != "U"){
							if(party != shiftRsn.substring(2,3)){
								ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "shift_rsn"));
								sheetCheckEdit[1].SetCellValue(idxRow, prefix + "shift_rsn","",0);
								sheetCheckEdit[1].SelectCell(idxRow, prefix + "shift_rsn", true);
								return false;
							}
						}
					}
				}
				//Account체크.
				var account = sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "account");
				if(account != ""){
					
					if(checkExistArrayIndex(oprData, account) == -1){
						ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "account"));
						sheetCheckEdit[1].SetCellValue(idxRow, prefix + "account","",0);
						sheetCheckEdit[1].SelectCell(idxRow, prefix + "account", false);
						return false;
					}

				}
				//Resposible Party체크.
				var party = sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "party")
				if(sheetCheckEdit[1].GetCellValue(idxRow,  prefix + "party") != ""){
					if(account == ""){
						if(party != "T" && party != "U"){
							ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "party"));
							sheetCheckEdit[1].SetCellValue(idxRow, prefix + "party","",0);
							sheetCheckEdit[1].SelectCell(idxRow, prefix + "party", false);
							return false;
						}
					}else{
						var idx = -1;
						for(var i in partyData){
							if(checkExistArrayIndex(partyData[i], account) != -1){
								idx = i;
								break;
							}
						}
						if(idx == -1){
							if(party != "Z"){
								ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "party"));
								return false;
							}
						}else{
							if(partyData[idx][1] != party){
								ComShowCodeMessage("COM132201", sheetCheckEdit[1].GetCellText(0, prefix + "party"));
								return false;
							}							
						}

					}
				}
			}
		}
		return true;
	}
	
    function checkExistArrayIndex(arr, val) {
    	for(var i in arr){
    		if(arr[i] == val){
    			return i
    		}
    	}
    	return -1;
    }
    
	function checkFormEdit(){
		var prefix="t1sheet1_";
		var shtObj=t1sheet1;
		for(var idxCol=1; idxCol <= shtObj.LastCol(); idxCol++){
			var colTxtName=ComReplaceStr(shtObj.ColSaveName(idxCol), prefix, "");
			if(getObjValue(colTxtName) != ""){
				return true;
			}
		}
		return false;
	}
	function log(msg){
	    var form=document.form;
	    if (form.s_parameter != undefined){
	        form.s_parameter.value += "\n"+msg;
	    }
	}	
	
	$(window).resize(function() {
 		if(this.resizeTO) {
 			clearTimeout(this.resizeTO);
 		}
 		this.resizeTO = setTimeout(function() {
 			$(this).trigger('resizeEnd');
 		}, 300);
    });
     
    $(window).on('resizeEnd', function() {
   	  iframeResize(true);
    });

    function iframeResize(onloadYn){     
    	/*if(beforetab == 1){
     		//  resizeSheet();
    		ComResizeSheet(sheetObjects[1]);
        }*/
   	  // 선택된 tab의 index를 통해서 iframe 이름을 구합니다.
   	  // beforetab은 tabIndex(현재 선택된 tab)이며 전역변수로 설정되어 있어서 booking의 경우 beforetab를 사용
   	  // 다른 화면도 유사한 코딩으로 되어있을 것으로 판단되며 그렇지 않은 경우는 지원요망.
   	  var ifrId = $('#'+selFrameId);      	  
   	  var height = $(window).height();
   	  var ifrOffset = $(ifrId).offset();
   	  var onloadYnIframe = false;
   	  if(onloadYn) {
   	   iframeMap.put(selFrameId, "Y");
   	  }
   	   
   	  onloadYnIframe = iframeMap.get(selFrameId);   	  
   	  //alert(beforetab);
   	  // 탭에서 Sheet Resizing을 원하는 것만 골라서 변경(ex. Tab 1,2,5,6)
   	  // 단, 해당 탭(Iframe에 해당하는 파일)에 updateSheetSize 라는 함수(공통)가 정의되어 있어야 합니다.
   	  if(beforetab == 2 || beforetab == 3 || beforetab == 4 || beforetab == 5 || beforetab == 6 || beforetab == 7 || beforetab == 8) {  	   
   		  if(ifrOffset != null && ifrOffset!=undefined)   $(ifrId).height(height - ifrOffset.top - iframeAddHeight);    
   		   	   
	   	   if(onloadYnIframe == "Y" && $(ifrId)[0]!=undefined) {	   		   
	   		   $(ifrId)[0].contentWindow.updateSheetSize();	   		  	   		   
	   	   }	   	   
   	  }
    }
	/* Developer performance  end */
    function checkMax(tab) {
    	if(tab == 'Disch. Vol.') {
        	var tvSheet = t3frame.t3sheet1;
        	var scgSheet = t3frame.t3sheet2;
			// Total Volume
			for(var i=3;i<tvSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t3sheet1_";
				if(tvSheet.GetCellValue(i, prefix+'wt_20') > 99999.99) {
					checkItem = prefix+"wt_20";
				}
				if(checkItem =="" && tvSheet.GetCellValue(i, prefix+'wt_2h') > 99999.99) {
					checkItem = prefix+"wt_2h";
				}
				if(checkItem =="" && tvSheet.GetCellValue(i, prefix+'wt_40') > 99999.99) {
					checkItem = prefix+"wt_40";
				}
				if(checkItem =="" && tvSheet.GetCellValue(i, prefix+'wt_4h') > 99999.99) {
					checkItem = prefix+"wt_4h";
				}
				if(checkItem =="" && tvSheet.GetCellValue(i, prefix+'wt_45') > 99999.99) {
					checkItem = prefix+"wt_45";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '99,999.99' );
					tvSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
			// Special Cargo
			for(var i=3;i<scgSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t3sheet2_";
				if(scgSheet.GetCellValue(i, prefix+'dg_20_wgt') > 99999.99) {
					checkItem = prefix+"dg_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'dg_40_wgt') > 99999.99) {
					checkItem = prefix+"dg_40_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'rf_20_wgt') > 99999.99) {
					checkItem = prefix+"rf_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'rf_40_wgt') > 99999.99) {
					checkItem = prefix+"rf_40_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'ak_20_wgt') > 99999.99) {
					checkItem = prefix+"ak_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'ak_40_wgt') > 99999.99) {
					checkItem = prefix+"ak_40_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '99,999.99' );
					scgSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
    	}
    	if(tab == 'Load Vol.') {
        	var ocnSheet = t4frame.t4sheet1;
        	var ipSheet  = t4frame.t4sheet2;
        	var scgSheet = t4frame.t4sheet3;
			// Ocean
			for(var i=3;i<ocnSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t4sheet1_";
				if(ocnSheet.GetCellValue(i, prefix+'wt_20') > 99999.99) {
					checkItem = prefix+"wt_20";
				}
				if(checkItem =="" && ocnSheet.GetCellValue(i, prefix+'wt_2h') > 99999.99) {
					checkItem = prefix+"wt_2h";
				}
				if(checkItem =="" && ocnSheet.GetCellValue(i, prefix+'wt_40') > 99999.99) {
					checkItem = prefix+"wt_40";
				}
				if(checkItem =="" && ocnSheet.GetCellValue(i, prefix+'wt_4h') > 99999.99) {
					checkItem = prefix+"wt_4h";
				}
				if(checkItem =="" && ocnSheet.GetCellValue(i, prefix+'wt_45') > 99999.99) {
					checkItem = prefix+"wt_45";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '99,999.99' );
					ocnSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
			// Inter Port
			for(var i=3;i<ipSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t4sheet2_";
				if(ipSheet.GetCellValue(i, prefix+'wt_20') > 99999.99) {
					checkItem = prefix+"wt_20";
				}
				if(checkItem =="" && ipSheet.GetCellValue(i, prefix+'wt_2h') > 99999.99) {
					checkItem = prefix+"wt_2h";
				}
				if(checkItem =="" && ipSheet.GetCellValue(i, prefix+'wt_40') > 99999.99) {
					checkItem = prefix+"wt_40";
				}
				if(checkItem =="" && ipSheet.GetCellValue(i, prefix+'wt_4h') > 99999.99) {
					checkItem = prefix+"wt_4h";
				}
				if(checkItem =="" && ipSheet.GetCellValue(i, prefix+'wt_45') > 99999.99) {
					checkItem = prefix+"wt_45";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '99,999.99' );
					ipSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
			// Special Cargo
			for(var i=3;i<scgSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t4sheet3_";
				if(scgSheet.GetCellValue(i, prefix+'dg_20_wgt') > 99999.99) {
					checkItem = prefix+"dg_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'dg_40_wgt') > 99999.99) {
					checkItem = prefix+"dg_40_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'rf_20_wgt') > 99999.99) {
					checkItem = prefix+"rf_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'rf_40_wgt') > 99999.99) {
					checkItem = prefix+"rf_40_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'ak_20_wgt') > 99999.99) {
					checkItem = prefix+"ak_20_wgt";
				}
				if(checkItem =="" && scgSheet.GetCellValue(i, prefix+'ak_40_wgt') > 99999.99) {
					checkItem = prefix+"ak_40_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight[Ton]' , '99,999.99' );
					scgSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
    	}
    	if(tab == 'Slot') {
        	var bsaSheet = t8frame.t8sheet1;
        	var hc45Sheet = t8frame.t8sheet2;
        	var portSheet = t8frame.t8sheet3;
        	var depSheet = t8frame.t8sheet4;
			// BSA
			for(var i=3;i<bsaSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t8sheet1_";
				if(bsaSheet.GetCellValue(i, prefix+'bsa_wgt') > 99999.9) {
					checkItem = prefix+"bsa_wgt";
				}
				if(checkItem =="" && bsaSheet.GetCellValue(i, prefix+'swap_wgt') > 99999.9) {
					checkItem = prefix+"swap_wgt";
				}
				if(checkItem =="" && bsaSheet.GetCellValue(i, prefix+'release_wgt') > 99999.9) {
					checkItem = prefix+"release_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Weight' , '99,999.9' );
					bsaSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
			// HC/45
			for(var i=3;i<hc45Sheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t8sheet2_";
				var isAdd = false;
				var title = "";
				if(hc45Sheet.GetCellValue(i, prefix+'hc_or_20') > 99.999) {
					checkItem = prefix+"hc_or_20";
				}
				if(hc45Sheet.GetCellValue(i, prefix+'hc_add_20') > 9999) {
					checkItem = prefix+"hc_or_20";
					title = "[20 High Cubic]";
					isAdd = true;
				}
				if(checkItem =="" && hc45Sheet.GetCellValue(i, prefix+'hc_or_40') > 99.999) {
					checkItem = prefix+"hc_or_40";
				}
				if(checkItem =="" && hc45Sheet.GetCellValue(i, prefix+'hc_add_40') > 9999) {
					checkItem = prefix+"hc_or_40";
					title = "[40 High Cubic]";
					isAdd = true;
				}
				if(checkItem =="" && hc45Sheet.GetCellValue(i, prefix+'hc_ur_45') > 99.999) {
					checkItem = prefix+"hc_ur_45";
				}
				if(checkItem =="" && hc45Sheet.GetCellValue(i, prefix+'hc_or_45') > 99.999) {
					checkItem = prefix+"hc_or_45";
				}
				if(checkItem =="" && hc45Sheet.GetCellValue(i, prefix+'hc_add_45') > 9999) {
					if(hc45Sheet.GetCellValue(i,  prefix + "hc_ld_45") <= hc45Sheet.GetCellValue(i,  prefix + "hc_bsa_45")) {
						checkItem = prefix+"hc_ld_45";
					} else {
						checkItem = prefix+"hc_bsa_45";
					}
					title = "[45']";
					isAdd = true;
				}
				if(checkItem != "") {
					if(!isAdd) {
						ComShowCodeMessage('OPF50022', "Ratio", "99.999");
						hc45Sheet.SelectCell(i, checkItem, true);
					} else {
						ComShowCodeMessage('OPF50022', "Add Slot " + title, "9,999");
//						hc45Sheet.SelectCell(i, checkItem, true);
					}
					return false;
				}
			}
			// Slot(Port)
			for(var i=3;i<portSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t8sheet3_";
				if(portSheet.GetCellValue(i, prefix+'trade_sub_wgt') > 99999.99) {
					checkItem = prefix+"trade_sub_wgt";
				}
				if(checkItem =="" && portSheet.GetCellValue(i, prefix+'inter_sub_wgt') > 99999.99) {
					checkItem = prefix+"inter_sub_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Slot(Ton)' , '99,999.99' );
					portSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
			// Slot(DEP)
			for(var i=3;i<depSheet.RowCount() + 3;i++){
				var checkItem = "";
				var prefix = "t8sheet4_";
				if(depSheet.GetCellValue(i, prefix+'trade_sub_wgt') > 99999.99) {
					checkItem = prefix+"trade_sub_wgt";
				}
				if(checkItem =="" && depSheet.GetCellValue(i, prefix+'inter_sub_wgt') > 99999.99) {
					checkItem = prefix+"inter_sub_wgt";
				}
				if(checkItem != "") {
					ComShowCodeMessage('OPF50022', 'Slot(Ton)' , '99,999.99' );
					depSheet.SelectCell(i, checkItem, true);
					return false;
				}
			}
    	}
    	return true;
    }
    
