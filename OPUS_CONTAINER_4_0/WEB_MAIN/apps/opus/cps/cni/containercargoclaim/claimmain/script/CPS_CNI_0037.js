/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0037.js
*@FileTitle  : [CPS_CNI_0037] Claim Reopen
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/25
=========================================================*/
/**
 * [CPS_CNI_0037] Claim Reopen
 * 
 * @extends
 * @class Claim Reopen 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
 */
// common global variables
var tabObjects=new Array();
var tabCnt=0 ;
var beforetab1=1;
var beforetab2=1;
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
// HTML Form
var frm=null;
// Claim Area Code
var clmAreaCd="";
var MainCode="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj IBSheet Object  
 **/
function setSheetObject(sheetObj){
    sheetObjects[sheetCnt++]=sheetObj;
}
/**
  * registering IBTab Object as list 
  * @param tabObj
  **/
 function setTabObject(tabObj) {
 	tabObjects[tabCnt++]=tabObj;
 }
 /**
  * registering IBCombo Object as list
  * @param comboObj
  **/
function setComboObject(comboObj){
 	comboObjects[comboCnt++]=comboObj;
}
/**
 * initializing sheet body 태그의 onLoad 이벤트핸들러 
 * 구현 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을
 * 추가한다
 */
function loadPage() {
	frm=document.form;
	// IBSheet initializing
	sheet1=sheetObjects[0];
	sheetCnt=sheetObjects.length;
	for ( var i=0; i < sheetCnt; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// IBTab initializing
	comboCnt=tabObjects.length;
	for (var k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	// registering initial event 
	initControl();
	//Role 처리
	setRoleButton();
	//Cargo Claim Number가  넘어오면(존재하면) 해당 상세정보 조회
	var claim_no=frm.cgo_clm_no.value;
	if (claim_no != "") {
		doActionIBSheet(SEARCH);
	}
	
	var sXml2=document.form2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
	
	var dataCount=ComGetTotalRows(arrXml[10]);
	if (dataCount > 0) {
		var list=SheetXml2ListMap(arrXml[10]);	
	 	var listVO=list[0];
	 	clmAreaCd=listVO["clm_area_cd"];
	 	ComSetObjValue(frm.clm_area_cd,clmAreaCd );
	} else {
		var popwin=popupClientDefault(); //calling setup display not existing Area Code
		popwin.focus();
	}
}
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	// Cargo Claim No.
	var claim_no=frm.cgo_clm_no.value
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn1_Retrieve": 
			var cgo_clm_no=ComGetObjValue(frm.cgo_clm_no);
			if (cgo_clm_no =="") {
				ComShowCodeMessage("CNI00003", "Claim No.");
				frm.cgo_clm_no.focus();
				return ;	
			}
			doActionIBSheet(SEARCH);
			break;
		case "btn1_New":
			//CNI00015 Do you want to initialize?
			//if (ComShowCodeConfirm("CNI00015") ) {
			ComResetAll();
			resetHiddenField(frm);
			ComSetObjValue(frm.cgo_clm_no,"");
			tabObjects[0].SetSelectedIndex(0);
			tabObjects[1].SetSelectedIndex(0);
			frm.cgo_clm_no.focus();
			//}
			break;
		case "btn1_Reopen": 
			doActionIBSheet(MULTI01);
			break;
		case "btn1_Payment": 
			popupPayment(claim_no);
			break;	
		case "btn1_Handling_Costs": 
			popupHandlingCost(claim_no);
			break;
		case "btns_hanlder_history":
			var param="cgo_clm_no=" + claim_no;
			var url="CPS_CNI_0004.do?" + param;
			var display="0,0,1,1,1,0,1,0,1,1,0,0,1,1";	
			var win3=openWinCenter(url,"HandlerHistoryWin", 600, 340);	
			win3.focus();
			break;
		//---------------------[Style 버튼 Start]-----------//	
		case "btn1_Style":
			var clmt_clm_pty_no=ComGetObjValue(frm.clmt_clm_pty_no);
			if (clmt_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant");
				return ;	
			}
			popupMainCodeView(clmt_clm_pty_no);
			break;
		case "btn3_Style":
			var deft_atty_clm_pty_no=ComGetObjValue(frm.deft_atty_clm_pty_no);
			if (deft_atty_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Def. Attorney");
				return ;	
			}
			popupMainCodeView(deft_atty_clm_pty_no);
			break;
		case "btn4_Style":
			var clm_agn_clm_pty_no=ComGetObjValue(frm.clm_agn_clm_pty_no);
			if (clm_agn_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Claimant's Agent");
				return ;	
			}
			popupMainCodeView(clm_agn_clm_pty_no);
			break;
		case "btn5_Style":
			var insur_agn_clm_pty_no=ComGetObjValue(frm.insur_agn_clm_pty_no);
			if (insur_agn_clm_pty_no =="") {
				ComShowCodeMessage("CNI00003", "Insurer's Agent");
				return ;	
			}
			popupMainCodeView(insur_agn_clm_pty_no);
			break;
		//---------------------[Style 버튼 End]-----------//		
		} // end switch
	} catch (e) {
		if( e == "[object Error]") {
		    ComShowMessage(OBJECT_ERROR);
		} else {
	       ComShowMessage(e.message);
		}
	}
}
/**
 * registering initial event 
 **/
function initControl() {
	// keypress
//	axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	// key up
//	axon_event.addListenerForm('keyup', 'obj_keyup', frm);
}
// focus in
function obj_activate(){
	obj=event.srcElement;
} 
// focus out
function obj_deactivate(){
	obj=event.srcElement;
	ComChkObjValid(event.srcElement);
}
/**
 * HTML Control KeyPress event
 **/
//function obj_keypress() {
//	obj=event.srcElement;
//    if(obj.dataformat == null) return;
//    window.defaultStatus=obj.dataformat;
//    switch(obj.dataformat) {
//        case "ymd":
//        case "ym":
//        case "hms":
//        case "hm":
//        case "jumin":
//        case "saupja":
//            ComKeyOnlyNumber(obj);
//            break;
//        case "int":
//            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
//            else ComKeyOnlyNumber(obj);
//            break;
//        case "float":
//            ComKeyOnlyNumber(obj, "-.");
//            break;
//        case "eng":
//            ComKeyOnlyAlphabet(); 
//            break;
//        case "engup":
//            ComKeyOnlyAlphabet('uppernum');
//            break;
//        case "engdn":
//            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
//            else ComKeyOnlyAlphabet('lower');
//            break;
//    }
//   if (obj.name == "cgo_clm_no") {
//	   if (event.keyCode == 13) {
//		   doActionIBSheet(SEARCH);
//	   }
//   }
//   if (obj.name == "clmt_locl_xch_rt") {
//	   if (!ComIsNull(frm.clmt_locl_xch_rt.value) && event.keyCode == 13) {
//			setFeeUsdAmt();
//	   }
//   }
// }
/**
 * HTML Control KeyUp event
 **/
//function obj_keyup() {
//	if ((event.keyCode >= 37 && event.keyCode <= 40)|| (event.keyCode == 16)) return;
//	switch (event.srcElement.name) {
//	case "cgo_clm_no":
//		ComKeyOnlyAlphabet('uppernum');
//		if (frm.cgo_clm_no.value.length == 10) {
//			doActionIBSheet(SEARCH);
//		}
//		break;
//	}//end switch
//}
 /**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj Mandatory IBSheet Object
  * adding case as numbers of counting sheets
  **/
 function initSheet(sheetObj, sheetNo) {
	var cnt=0;
 	switch (sheetObj.id) {
	case "sheet1": //sheet1 init
	    with(sheetObj){
		        if (location.hostname != "") {
		      }
		      var HeadTitle1="";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		      (headCount, 0, 0, true);
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" } ];
		      InitColumns(cols);
		      SetEditable(0);
            }//end of with
		break;
	}// end of switch
 }
 /**
  * Handling Sheet's process
  **/
 function doActionIBSheet(sAction) {
	document.forms[0].f_cmd.value=sAction;
 	switch (sAction) {
 	case SEARCH: // Retrieve Claim Main
 		if (validateForm(sAction)) {
 			var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
		 	//에러 체크
			if (getErrorMsg(sheet1,sXml)) {
				return;
			}
			var dataCount=ComGetTotalRows(sXml);// 데이터 건수
			if (dataCount > 0) {
				  ComBtnDisable("btn1_Reopen");
				  sheetXml2ObjectValue(sXml);
				  //상태코드별 버튼사용여부 체크
				  var cgo_clm_sts_cd=ComGetObjValue(frm.cgo_clm_sts_cd);
				  if (cgo_clm_sts_cd == "C" || cgo_clm_sts_cd == "X" ) { // 상태 코드가 C,X 일경우 버튼 활성화
					  setRoleButton();
				  }
			} else { //데이터가 없을시 화면 reset 처리
				ComBtnDisable("btn1_Reopen");
				ComShowCodeMessage('CNI00013');
				ComResetAll();
				ComSetObjValue(frm.cgo_clm_no, "");
				tabObjects[0].SetSelectedIndex(0);
				tabObjects[1].SetSelectedIndex(0);
				ComSetFocus(frm.cgo_clm_no);
			}// end if 
		}
		break;
 	 case MULTI01: //Reopen
		if (!validateForm(sAction)) return; 
		if(!ComShowCodeConfirm('CNI09024')) return;
		 //공통함수로 처리할것 다시 호출로직
		var cgo_clm_no=frm.cgo_clm_no.value.trim();
		if (cgo_clm_no !=""){
			document.forms[0].f_cmd.value=SEARCH;
 			var sXml=sheet1.GetSearchData("CPS_CNI_0037GS.do",	FormQueryString(frm),"",true);
			// 데이터 건수
		 	var dataCount=ComGetTotalRows(sXml);
		 	if (dataCount == 0) {
		 		ComShowCodeMessage("CNI00013");
		 		return;
		 	}
		}
		document.forms[0].f_cmd.value=MULTI01;
		var param=FormQueryString(frm);
		var saveString=sheet1.GetSaveString();
		param += "&" + saveString;	
 		var sXml=sheet1.GetSaveData("CPS_CNI_0037GS.do", param);
		if (!getErrorMsg(sheet1,sXml)) {
 			sheet1.LoadSaveData(sXml);
			var cgo_clm_no=ComGetEtcData(sXml,"CGO_CLM_NO");
			frm.cgo_clm_no.value=cgo_clm_no;
			doActionIBSheet(SEARCH); //재조회
		}	
		break;
     }//end switch
  } 	
/**
 * handling process for input validation
 **/
function validateForm(sAction) {
	var cgo_clm_no=ComGetObjValue(frm.cgo_clm_no);
	if (cgo_clm_no == "") {
		ComShowCodeMessage("CNI00003", "Claim No.");
		frm.cgo_clm_no.focus();
		return false;	
	}
	var cgo_clm_no_length=frm.cgo_clm_no.value.length;
	if (cgo_clm_no_length < 10) {
//		ComShowCodeMessage("CNI00003", "Claim No.");
		alert("cgo_clm_no must be at least 10 characters long.");
		frm.cgo_clm_no.focus();
		return false;	
	}
	return true;
}
/**
 * Tab 기본 설정
 * 탭의 항목을 설정한다.
 **/
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Page1", "");
			InsertItem( "Page2", "");
			InsertItem( "Litigation", "");
		}
		break;
	case 2:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Cause of Claim", "");
			InsertItem( "Fact Finding", "");
			InsertItem( "Main Issue Review & DV", "");
			InsertItem( "Claimant's Agent", "");
			InsertItem( "Insurer's Agent", "");
			InsertItem( "Case Summary & DV", "");
		}
		break;
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 **/
function tab1_OnClick(tabObj, nItem) {
	if (nItem == 0) {
		tabObjects[1].SetSelectedIndex(0);
	}
	if (nItem == 2) {
		tabObjects[1].SetSelectedIndex(5);
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 **/
function tab2_OnClick(tabObj, nItem) {
	if (nItem == 0) {
		tabObjects[0].SetSelectedIndex(0);
	}
	if (nItem == 5) {
		tabObjects[0].SetSelectedIndex(2);
	}
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 **/
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer1");
	objs[nItem].style.display="Inline";
	objs[beforetab1].style.display="none";
	objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1;
	beforetab1=nItem;
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 **/
function tab2_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer2");
	objs[nItem].style.display="Inline";
	objs[beforetab2].style.display="none";
	objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1;
	beforetab2=nItem;
}
//Sheet 데이터를  HTML Form Object의 Value에 셋팅
function sheetXml2ObjectValue(pXml) {
	var vListData=SheetXml2ListMap(pXml);
	if (vListData.length > 0) {
		var vListVO="";
		for(var i=0; i<vListData.length;i++)
		{
			if(vListData[i]!=undefined)
			{
				vListVO=vListData[i];
				break;
			}
		}
		var vObjects=frm.elements;
		for ( var kdx=0; kdx < vObjects.length; kdx++) {
			var vObj=vObjects[kdx];
			var vObjtp=vObj.type;
			var vObjdf=vObj.dataformat;
			var vObjnm=vObj.name;
			var vObjval=vObj.value;
			if (vObjnm == undefined || vObjnm == ""){
				continue;
			}	
			var vData=vListVO[vObjnm];
			if (typeof (vData) == "undefined") {
				vData=vObjval;
			}
			
			if (typeof (vObjdf) == "undefined") {
				vObjdf = $("#" + vObjnm).attr("dataformat");
			}
			//체크 박스시 'Y'일때 값 세팅
			if (vObjtp =="checkbox" ) {
				var vUpperData=vData.toUpperCase();
			    if (vUpperData != "Y") vData="";	
			}  
			ComSetObjValue(vObj, vData)
			// 데이터 포맷 지정시 값 셋팅
			if (typeof(vObjdf) != "undefined" && vObjdf != null && vObjdf != "") {
				setFormatData(vObj, vData, vObjdf);
			}
		} //end for
	}// end if	
}
/*
 * 데이터 포맷
 */
function setFormatData(pObj, pRawData, pDataFormat){
    switch (pDataFormat) {
		case "ymd":    //yyyy-mm-dd
		case "ymdhms": //yyyy-mm-dd hh:mm:ss
		case "ymdhm":  //yyyy-mm-dd hh:mm
	   	    pObj.value=ComGetMaskedValue(pObj, pDataFormat);	
		    //ComAddSeparator(pObj, pDataFormat);
			break;
		case "int":
			pObj.value=ComAddComma2(pRawData, "#,###");
			break;
		case "float":
			if (pObj.name == "clmt_locl_xch_rt") {
				p=pRawData.split(".");
				p[0]=ComAddComma(p[0]);
				if      (p.length == 1) pObj.value=p[0]+".00000";
				else if (p.length == 2) pObj.value=p[0]+"."+p[1];
				else pObj.value="";
			} else { 
			    pObj.value=ComAddComma2(pRawData, "#,###.00");
			}
			break;
		default:
			pObj.value=pRawData;
			break;
	}
}
 /**
 * Common error-handling function
 * @class IAfter the Search IBSheet Exception message shows that when 
 * @param {IBSheet} pSheetObj it's IBSheet
 * @param {string} pXml XML on the server, the query results
 * @throws
 * @author 정행룡
 * @since 2009.11.12
 */
function getErrorMsg(pSheetObj, pXml){
	var vErrorMsg=ComGetEtcData(pXml,"Exception");
	if (vErrorMsg != undefined && vErrorMsg != null && vErrorMsg != "" ) {
		pSheetObj.LoadSearchData(pXml,{Sync:1} );
		return true;
	}
	return false;
}
function setRoleButton(){
//	if (equalsRole("CNI05")) {
		ComBtnEnable("btn1_Reopen");	
//	} else {
//		ComBtnDisable("btn1_Reopen");	
//	}
}
function cgo_clm_no_change(){
	doActionIBSheet(SEARCH);
}
