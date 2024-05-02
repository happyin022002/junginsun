/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : cps_cni_0033.js
*@FileTitle  : [CPS_CNI_0033] View-Claim Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
/**
 * [CPS_CNI_0033] View-Claim Main
 * 
 * @extends
 * @class Claim Main 생성을 위한 화면에서 사용하는 업무 스크립트를 정의한다.
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
	//Cargo Claim Number가  넘어오면(존재하면) 해당 상세정보 조회
	var claim_no=frm.cgo_clm_no.value;
	if (claim_no != "") {
		doActionIBSheet(SEARCH);
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
			ComSetObjValue(frm.cgo_clm_no,"");
			tabObjects[0].SetSelectedIndex(0);
			tabObjects[1].SetSelectedIndex(0);
			ComSetObjValue(frm.clm_area_cd, clmAreaCd);
			frm.cgo_clm_no.focus();
			//}
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
		case "btn1_Close":
			ComClosePopup(); 
	        break;	  
		case "btns_BL_Preview":
			var blNo=frm.cgo_clm_ref_bl_no.value;
			if (blNo == "") {
				ComShowMessage("Please use after retrieve ");		
				return false;
			}
			doActionIBSheet(SEARCH18);
			var bkgNo=frm.bkg_no.value;
			if (bkgNo == "") {
				ComShowCodeMessage("CNI00013");
				return false;
			}
			rdOpen(bkgNo);			
        	break;	    
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			alert("An unknown error occurred(in JavaScript source). Please verify your entry and try again. " +
				  "If the problem persists, please contact your system administrator.");
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
	//axon_event.addListenerForm('keypress', 'obj_keypress', frm);
	// focus in
	axon_event.addListenerForm('beforedeactivate', 'obj_deactivate', frm);
	// focus out
	axon_event.addListenerFormat('beforeactivate', 'obj_activate', frm);
	// key up
	//axon_event.addListenerForm('keyup', 'obj_keyup', frm);
}
// focus in
function obj_activate(){
	obj=ComGetEvent();
} 
// focus out
function obj_deactivate(){
	obj=ComGetEvent();
	ComChkObjValid(obj);
}
/**
 * HTML Control KeyPress event
 **/
function obj_keypress() {
	obj=ComGetEvent();
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
            if(obj.name=="txtInt") ComKeyOnlyNumber(obj, "-")
            else ComKeyOnlyNumber(obj);
            break;
        case "float":
            ComKeyOnlyNumber(obj, "-.");
            break;
        case "eng":
            ComKeyOnlyAlphabet(); 
            break;
        case "engup":
            ComKeyOnlyAlphabet('uppernum');
            break;
        case "engdn":
            if(obj.name=="txtEngDn2") ComKeyOnlyAlphabet('lowernum')
            else ComKeyOnlyAlphabet('lower');
            break;
    }
   if (obj.name == "cgo_clm_no") {
	   if (event.keyCode == 13) {
		   doActionIBSheet(SEARCH);
	   }
   }
   if (obj.name == "clmt_locl_xch_rt") {
	   if (!ComIsNull(frm.clmt_locl_xch_rt.value) && event.keyCode == 13) {
			setFeeUsdAmt();
	   }
   }
 }
/**
 * HTML Control KeyUp event
 **/
function obj_keyup() {
	if ((event.keyCode >= 37 && event.keyCode <= 40)|| (event.keyCode == 16)) return;
	switch (ComGetEvent("name")) {
	case "cgo_clm_no":
		ComKeyOnlyAlphabet('uppernum');
		if (frm.cgo_clm_no.value.length == 10) {
			doActionIBSheet(SEARCH);
		}
		break;
	}//end switch
}
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
			var HeadTitle1="";
			var headCount=ComCountHeadTitle(HeadTitle1);
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
	frm.f_cmd.value=sAction;
 	switch (sAction) {
 	case SEARCH: // Retrieve Claim Main
 		if (validateForm(sAction)) {
 			var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do",	FormQueryString(frm),"",true);
		 	var dataCount=ComGetTotalRows(sXml);// 데이터 건수
		 	var ErrorMsg=ComGetEtcData(sXml,"Exception");
			if (ErrorMsg == ""  ) {
				if (dataCount > 0) {
			 		  sheetXml2ObjectValue(sXml);
			 		  setFormatData(sXml);
			 		  var cgo_clm_sts_cd=ComGetObjValue(frm.cgo_clm_sts_cd);
			 	}
			} else {
				sheet1.LoadSearchData(sXml,{Sync:1} );
				return;
			}	  
		}
		break;
 	case SEARCH18: // Retrieve BookingNo
 		var sXml=sheet1.GetSearchData("CPS_CNI_0003GS.do", FormQueryString(frm),"",true);
 		var arrXml=sXml.split("|$$|");
	 	// ------------------------------------------------------------
	 	// Booking No 설정
	 	// ------------------------------------------------------------
	 	if (arrXml.length > 0) {
	 		var list=SheetXml2ListMap(arrXml[0]);	
	 		if (list.length > 0) {
	 			var dataVO=list[0];					
	 			frm.bkg_no.value=dataVO["bkg_no"];
	 		}
	 	 } else {
	 		frm.bkg_no.value='';
	 	 }
	     break;
     }//end switch
  } 	
/**
 * handling process for input validation
 **/
function validateForm(sAction) {
	var cgo_clm_no=frm.cgo_clm_no.value;
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
//	var objs=document.all.item("tabLayer1");
//	objs[nItem].style.display="Inline";
//	objs[beforetab1].style.display="none";
//	objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1;
//	beforetab1=nItem;
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab1].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab1=nItem;
}
/**
 * Tab 클릭시 이벤트 관련
 * 선택한 탭의 요소가 활성화 된다.
 **/
function tab2_OnChange(tabObj, nItem) {
//	var objs=document.all.item("tabLayer2");
//	objs[nItem].style.display="Inline";
//	objs[beforetab2].style.display="none";
//	objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1;
//	beforetab2=nItem;
	var objs=document.all.item("tabLayer2");
	objs[nItem].style.display="Inline";
	for(var i = 0; i<objs.length; i++){
		if(i != nItem){
			objs[i].style.display="none";
			objs[beforetab2].style.zIndex=objs[nItem].style.zIndex - 1 ;
		}
	}
	beforetab2=nItem;
}
//Sheet 데이터를  HTML Form Object의 Value에 셋팅
function sheetXml2ObjectValue(pXml) {
	var vListData=SheetXml2ListMap(pXml);
	if (vListData.length > 0) {
		var vListVO=vListData[0];
		var vObjects=frm.elements;
		for ( var kdx=0; kdx < vObjects.length; kdx++) {
			var vObj=vObjects[kdx];
			var vObjtp=vObj.type;
			var vObjnm=vObj.name;
			var vObjval=vObj.value;
			var vObjdf=vObj.dataformat;
            if(typeof vObjdf == "undefined" || vObjdf == "") {
			    vObjdf = $("#"+vObjnm).attr("dataformat");
            }

			if (vObjnm == undefined || vObjnm == ""){
				continue;
			}	
			var vData=vListVO[vObjnm];
			if (typeof (vData) == "undefined") {
				vData=vObjval;
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
 function rdOpen(strBkgNo){    
		rdUrl="apps/opus/esm/bkg/outbounddocumentation/outboundblmgt/blissuance/report/"; 
		rdFile="ESM_BKG_0109_DBL.mrd";	
		rdParam="/rv form_bkgNo[( '" + strBkgNo + "') ]"
			  + "  form_type[2]"
		      + " form_dataOnly[N]"
		      + " form_manifest[N]"
		      + " form_usrId[" +frm.usr_id.value+"] "
		      + " form_hiddeData[N]"
		      + " form_level[(3)]"
			  + " form_remark[]"
			  + " form_Cntr[1]"
			  + " form_mainOnly[N]"
			  + " form_CorrNo[]"
			  + " form_his_cntr[BKG_CONTAINER]"
			  + " form_his_bkg[BKG_BOOKING]"
			  + " form_his_mkd[BKG_BL_MK_DESC]"
			  + " form_his_xpt[BKG_XPT_IMP_LIC]"
			  + " form_his_bl[BKG_BL_DOC]"
			  + " isEncode[Y]"
			  + " /rp []"
			  + " /riprnmargin";
		frm.com_mrdTitle.value="OPUS Container Draft B/L Copies";
		frm.com_mrdPath.value=rdUrl+rdFile;
		frm.com_mrdArguments.value=rdParam + " /rwait";
		frm.com_mrdBodyTitle.value="OPUS Container Draft B/L Copies";
		ComOpenRDPopup('resizable=yes, width=900, height=620');
}