/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0029.js
*@FileTitle  : Cargo Flow Map
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/24 
=========================================================*/
/**
 * event when clicking Tab
 * activating selected tab items
 */

/* developer job  */
// common glolbal variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var isOpen=false;
var tabIndex=0;
var tabFlag=0;
var comboObjects=new Array();
var comboCnt=0;
var isSearch=0;
// controlling XTC date input event
var enterSwitch=false;
//Event handler processing by button click event */
document.onclick=processButtonClick;
//Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	var t1sheet1=sheetObjects[shtCnt++];
	var t1sheet2=sheetObjects[shtCnt++];
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		switch (srcName) {
		case "btn_Retrieve":
			isSearch=1;
			if (tabIndex == 0) {
				doActionIBSheet(sheetObjects[0], formObject, IBSEARCH);
				sheetObjects[0].SetSelectRow(2);
			}else{ //retrieving Loc_Loc
				doActionIBSheet(sheetObjects[1], formObject, IBSEARCH);
				sheetObjects[1].SetSelectRow(2);
			}
			break;
		case "btn_new":
			var xVar=document.getElementById("directionWise").value;
			t1sheet1.RemoveAll();
			t1sheet2.RemoveAll();
			formObject.reset();
			document.form.rdtype.disabled=true;
			ComClearCombo(document.form.endloc);			
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POD", "P");
			document.getElementById("directionWise").value=xVar;
			
			sheetObjects[0].SetCellText(1, "loc_cd", "RCC");
			
            	
			sheetObjects[0].SetCellText(1, "vvd", "RCC");
			sheetObjects[0].SetCellText(1, "division", "RCC");
			sheetObjects[0].SetCellText(1, "ibflag", "RCC");
			break;
		case "btn_downexcel":
			var tVal01=document.getElementById("directionWise").value;
			if (tVal01 =="L"){
				if(t1sheet2.RowCount() < 1){//no data
	      			ComShowCodeMessage("COM132501");
	      		}else{
 					t1sheet2.Down2Excel( {DownCols: makeHiddenSkipCol(				t1sheet2), SheetDesign:1,Merge:1 });
	      		}
			}else{
				if(t1sheet1.RowCount() < 1){//no data
	      			ComShowCodeMessage("COM132501");
	      		}else{
 					t1sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(				t1sheet1), SheetDesign:1,Merge:1 });
	      		}
			}
			break;
		case "btn_floc_cd":
        	var display="0,1,1,1,1,1";
        	var targetObjList="loc_cd:locationf2|loc_dpth_cd:startloc|chkDepth:startloc";
			var param="?depth=4&classId=COM_ENS_0O1";
			ComOpenPopup('/opuscntr/COM_ENS_0O1.do' + param, 400, 470,  'getStartLoc', display,true,false);
//			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
			break;
      	case "btn_tloc_cd":
    		var display="0,1,1,1,1,1";
    		var targetObjList="loc_cd:locationt2|loc_dpth_cd:endloc";
		    var param="?depth=4&classId=COM_ENS_0O1";
		    ComOpenPopup('/opuscntr/COM_ENS_0O1.do' + param, 400, 470,  'getEndLoc', display,true,false);
//		    ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 400, 470, targetObjList, display);
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		} // end if
	} // end try
}
//setting startloc PopUp
function getStartLoc(rArray){
	var locLvl="";
	var locVal="";
	for ( i=0; i < rArray.length; i++) {
		var aArray=rArray[i];
		locLvl=aArray[3];
		if (i+1 == rArray.length){
			locVal=locVal+aArray[4];
		}else{
			locVal=locVal+aArray[4]+",";
		}
	}
	 if (locLvl!=""){ //logic for getting from popup
	    	document.form.startloc.value=locLvl;
	    	document.form.locationf2.value=locVal;	    	
	    	setSubCombo();
	  }else{
//		  document.form.startloc.value = "R";
		   document.form.locationf2.value="";
	  }
}
//setting endloc PopUp
function getEndLoc(rArray){
	var locLvl="";
	var locVal="";
	for ( i=0; i < rArray.length; i++) {
		var aArray=rArray[i];
		locLvl=aArray[3];
		if (i+1 == rArray.length){
			locVal=locVal+aArray[4];
		}else{
			locVal=locVal+aArray[4]+",";
		}
	}
	 if (locLvl!=""){ //logic for getting from popup
		 var xVal=document.form.startloc.value;
		  if (xVal =="R" ){
	    	document.form.endloc.value=locLvl;
		  }else if(xVal =="L"){
			if (locLvl!="R")document.form.endloc.value=locLvl;  
		  }else if(xVal =="E"){
				if (locLvl=="E" || locLvl=="S")document.form.endloc.value=locLvl;  
		  }else if(xVal =="S"){
				if (locLvl=="S")document.form.endloc.value=locLvl; 
		  }
	    document.form.locationt2.value=locVal;
	  }else{
		document.form.locationt2.value="";
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
 * setting value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.locationf1.value=aryPopupData[0][3]
}
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 */
function loadPage() {
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	axon_event.addListenerForm('click', 'obj_tpsz_click', document.form);
	axon_event.addListenerForm('change', 'obj_change', document.form);
	axon_event.addListenerFormat('focus', 'obj_activate', document.form); //- form 전체 컨트롤 중 dataformat 속성이 있는 모든 컨트롤의 OnBeforeActivate이벤트에 코드 처리
	axon_event.addListenerForm('blur', 'obj_deactivate', form); 
	axon_event.addListener('keydown', 'ComKeyEnter', 'form'); 
	
	t1sheet1_OnLoadFinish(t1sheet1);
	t1sheet2_OnLoadFinish(t1sheet2);
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
	case "t1sheet1": //sheet1 init
		with (sheetObj) {
	    
	    if (location.hostname != "")
	    oldCntrTypeSize=ComGetEtcData(document.form.sXml.value, "cntrTypeSize");//sCntrTypeSize;
	    var arrTpSz=oldCntrTypeSize.split(",");
	    var HeadTitle1="From|To|To|To|Total";
	    var HeadTitle2="RCC |RCC|RCC|RCC|Total";
	    var xVal01=document.form.startloc.value;
	    var xVal02=document.form.directionWise.value;
	    var xVal04=document.form.endloc.value;
	    var xHeadTitle01="";
	    var xHeadTitle02="";
	    for ( var i=0; i < arrTpSz.length; i++) {
	    HeadTitle1 += "|" + arrTpSz[i];
	    HeadTitle2 += "|" + arrTpSz[i];
	    }
	    var headCount=ComCountHeadTitle(HeadTitle1);
	    var headCnt=HeadTitle1.split("|").length;
	    FrozenCols=5;
	    var FM=80;
	    var TO=60;
	    var Total=60;
	    var rowCnt=0;
	    cnt=0;

	    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:7, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );

	    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
	    var headers = [ { Text:HeadTitle1, Align:"Center"},
	                  { Text:HeadTitle2, Align:"Center"} ];
	    InitHeaders(headers, info);
	    var cols=[];
	    var cols2 =[];
	    var cols1 = [{Type:"Text",   Hidden:0, Width:FM,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:1,  Width:TO,   Align:"Center",  ColMerge:0,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:0,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"" },
	              {Type:"Text",      Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" }];
	       
	    for ( var i=0; i < arrTpSz.length; i++) {
		    arEtcData="_" + i;
		    cols1.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols1.push({Type:"AutoSum",      Hidden:1,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"hiddenSum",         KeyField:0,   CalcLogic:"",   Format:"" });
	    
	    cols2.push({Type:"Text",      Hidden:0,  Width:FM,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd2",       KeyField:0,   CalcLogic:"",   Format:"" });
	    cols2.push({Type:"Text",      Hidden:1,  Width:TO,   Align:"Center",  ColMerge:0,   SaveName:"vvd2",          KeyField:0,   CalcLogic:"",   Format:"" });
	    cols2.push({Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"division2",     KeyField:0,   CalcLogic:"",   Format:"" });
	    cols2.push({Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:0,   SaveName:"ibflag2",       KeyField:0,   CalcLogic:"",   Format:"" });
	    cols2.push({Type:"Text",      Hidden:0,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total2",        KeyField:0,   CalcLogic:"",   Format:"" });
	   
	    for ( var i=0; i < arrTpSz.length; i++) {
		    arEtcData="_" + i;
		    cols2.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
	    }
	    cols2.push({Type:"AutoSum",      Hidden:1,  Width:Total,Align:"Right",   ColMerge:0,   SaveName:"hiddenSum2",         KeyField:0,   CalcLogic:"",   Format:"" });
	   
	    cols.push(cols1);
	    cols.push(cols2);
	    if (xVal02 == "F" && xVal01 == "R" && xVal04 == "R") {
	    	SetColHidden(1,1);
	    } else if (xVal02 == "T" && xVal01 == "R" && xVal05 == "R") {
	    	SetColHidden(1,1);
	    } else {
	    	SetColHidden(1,0);
	    }
	  
	    InitColumns(cols,2);
	    //SetSheetHeight(385);
	    resizeSheet();
	    SetEditable(0);
		}
		break;
	case "t1sheet2": //sheet2 init
		with (sheetObj) {
		    if (location.hostname != "")
		    oldCntrTypeSize=ComGetEtcData(document.form.sXml.value, "cntrTypeSize");
		    var arrTpSz=oldCntrTypeSize.split(",");
		    var HeadTitle1="|From|To|To|Total";
		    var HeadTitle2="|RCC |RCC|RCC|Total";
		    var xVal01=document.form.startloc.value;
		    var xVal02=document.form.directionWise.value;
		    var xVal04=document.form.endloc.value;
		    var xHeadTitle01="";
		    var xHeadTitle02="";
		    for ( var i=0; i < arrTpSz.length; i++) {
		    HeadTitle1 += "|" + arrTpSz[i];
		    HeadTitle2 += "|" + arrTpSz[i];
		    }
		    var headCount=ComCountHeadTitle(HeadTitle1);
		    var headCnt=HeadTitle1.split("|").length;
		    FrozenCols=5;
		    var FM=80;
		    var TO=60;
		    var Total=60;
		    var rowCnt=0;
		    cnt=0;
	
		    SetConfig( { SearchMode:2, FrozenCol:5, MergeSheet:5, Page:20, DataRowMerge:0, PrevColumnMergeMode:0 } );
	
		    var info    = { Sort:0, ColMove:1, HeaderCheck:0, ColResize:1 };
		    var headers = [ { Text:HeadTitle1, Align:"Center"},
		                  { Text:HeadTitle2, Align:"Center"} ];
		    InitHeaders(headers, info);
	
		    var cols = [ {Type:"Status",    Hidden:1, Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",        KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:FM,   Align:"Center",  ColMerge:1,   SaveName:"loc_cd",        KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"vvd",           KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:TO,   Align:"Center",  ColMerge:1,   SaveName:"division",      KeyField:0,   CalcLogic:"",   Format:"" },
		              {Type:"Text",      Hidden:0,  Width:Total,Align:"Right",   ColMerge:1,   SaveName:"total",         KeyField:0,   CalcLogic:"",   Format:"" } ];
		       for ( var i=0; i < arrTpSz.length; i++) {
		    arEtcData="_" + i;
		    cols.push({Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:1,   SaveName:"qty"+arEtcData, KeyField:0,   CalcLogic:"",   Format:"" });
		    }
		  
		    InitColumns(cols);
		    SetSheetHeight(425);
		    //resizeSheet();
		    SetEditable(0);
		}
	break;
  }
}
//Sheet의 높이 자동으로 변경
function resizeSheet(){
    ComResizeSheet(sheetObjects[0]);
}
// handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	var xVal01=document.getElementById("startloc").value;
	var xVal02=document.getElementById("endloc").value;
	document.form.inquiryWise1.value=xVal01;
	document.form.inquiryWise2.value=xVal02;
	switch (sAction) {
	case IBSEARCH: 
		if (validateForm(sheetObj, formObj, sAction)) {
			var tVal01=document.getElementById("directionWise").value;
			var tVal02=document.getElementById("startloc").value;
			var tVal03=document.getElementById("locationf1").value;
			var tVal04=document.getElementById("locationf2").value;
			var tVal05=document.getElementById("locationt2").value;
			var tVal06=document.getElementById("country").value;
			var tVal07=document.getElementById("country2").value;
			if (tVal01=="L"){        
				if (tVal02 == "C") {
					document.getElementById("location").value=ComTrimAll(tVal06," ",".");
					document.getElementById("location2").value=ComTrimAll(tVal07," ",".");
				} else {
					document.getElementById("location").value=ComTrimAll(tVal04," ",".");
					document.getElementById("location2").value=ComTrimAll(tVal05," ",".");
				}
			}else{
				if (tVal02 == "C") {
					document.getElementById("location").value=ComTrimAll(tVal06," ",".");
				} else {
					document.getElementById("location").value=ComTrimAll(tVal03," ",".");
				}
			}
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
 			var sXml=sheetObj.GetSearchData("EES_CIM_1029GS.do", FormQueryString(formObj));
			sheetObj.LoadSearchData(sXml,{Sync:1} );
			sheetObj.SetWaitImageVisible(1);
			ComOpenWait(false);
			setText2(sheetObj);
			if (tabIndex ==0){
				tr_from_to.style.display="";
				tr_loc_loc.style.display="none";
			}else{
				tr_from_to.style.display="none";
				tr_loc_loc.style.display="";
			}
		}
		break;
	case IBSEARCH_ASYNC01: 
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH01;
			var sXml="";
			if (sheetObj.id == "t1sheet1" || sheetObj.id=="t1sheet2" ) {
				sXml=formObj.sXml.value;
			}
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
			//getting changing column information from server
			if ((oldCntrTypeSize != sCntrTypeSize) && (sheetObj.id == "t1sheet1" || sheetObj.id=="t1sheet2")) {
				oldCntrTypeSize=sCntrTypeSize;
				sheetObj = sheetObj.Reset();
				if(sheetObj.id == "t1sheet1") {
					sheetObjects[0] = sheetObj;
					initSheet(sheetObjects[0]);
				}
				if(sheetObj.id == "t1sheet2") {
					sheetObjects[1] = sheetObj;
					initSheet(sheetObjects[1]);
				}
				
			}
		} // end if
		break;
	case IBSEARCH_ASYNC02: //location focusOut
		if (document.getElementById("locationf1").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH02;
				document.form.inquiryLevel.value=document.getElementById("startloc").value;
				document.form.location.value=document.getElementById("locationf1").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					var xLocationBy=document.getElementById("startloc").value;
					if (document.form.locationf1.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						}
					} else {
//						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {
				} else {
//					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.SetWaitImageVisible(1);
		break;
	case IBSEARCH_ASYNC03: //country focusOut
		if (document.getElementById("country").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH02;
				document.form.inquiryLevel.value=document.getElementById("startloc").value;
				document.form.location.value=document.getElementById("country").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					var xLocationBy=document.getElementById("startloc").value;
					if (document.form.country.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "C") {
							ComShowCodeMessage("CIM29037");
							document.form.country.value="";
							ComSetFocus(document.form.country);
							return false;
						}
					} else {
//						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {
				} else {
//					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.SetWaitImageVisible(1);
		break;
	case IBSEARCH_ASYNC04: //country2 focusOut
		if (document.getElementById("country2").value != "")
			if (validateForm(sheetObj, formObj, sAction)) {
				formObj.f_cmd.value=SEARCH02;
				document.form.inquiryLevel.value=document.getElementById("startloc").value;
				document.form.location.value=document.getElementById("country2").value;
				if (formObj.location.value == "") {
					return true;
				}
				if (formObj.inquiryLevel.value == "") {
					return false;
				}
				sheetObj.SetWaitImageVisible(0);
 				var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
				var sCheck=ComGetEtcData(sXml, "check");
				if (sCheck != "OK") {
					var xLocationBy=document.getElementById("startloc").value;
					if (document.form.country.value != "") {
						if (xLocationBy == "R") {
							ComShowCodeMessage("CIM29031");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "L") {
							ComShowCodeMessage("CIM29032");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "E") {
							ComShowCodeMessage("CIM29033");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "Y") {
							ComShowCodeMessage("CIM29036");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "P") {
							ComShowCodeMessage("CIM29035");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "S") {
							ComShowCodeMessage("CIM29034");
							document.form.locationf1.value="";
							ComSetFocus(document.form.locationf1);
							return false;
						} else if (xLocationBy == "C") {
							ComShowCodeMessage("CIM29037");
							document.form.country.value="";
							ComSetFocus(document.form.country);
							return false;
						}
					} else {
//						document.form.soc.focus();
						return true;
					} // end if (document.form.location.value != "") {
				} else {
//					document.form.soc.focus();
					return true;
				} // end if (sCheck != "OK") {
			} else {
				//document.form.soc.focus();
				return;
			} // end if (validateForm(sheetObj, formObj, sAction)) {
		sheetObj.SetWaitImageVisible(1);
		break;	
	case IBDOWNEXCEL: //downloading excel
		sheetObj.SetWaitImageVisible(1);
 		sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
		break;
	} // end switch
}
function obj_activate() {
	ComClearSeparator(ComGetEvent());
	ComSetFocus(ComGetEvent());
}
function lastDay(y, m) {
	var d, d2, s="";
	d=new Date();
	d2=new Date(y, m, "");
	s=d2.getDate();
	return (s);
}
function obj_keypress() {
	switch (ComGetEvent("name")) {
	case "locationf1":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');//upper case, numbers only
		} else {
			ComKeyOnlyAlphabet('uppernum');// upper case only
		}
		break;	
	case "country":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');//upper case, numbers only
		} else {
			ComKeyOnlyAlphabet('upper');// upper case only
		}
		break;
	case "country2":
		if (document.form.inquiryLevel.value == "Y") {
			ComKeyOnlyAlphabet('uppernum');//upper case, numbers only
		} else {
			ComKeyOnlyAlphabet('upper');// upper case only
		}
		break;
	case "froms":
		//permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(ComGetEvent());
		break;
	case "tos":
		//permitting to input "-" in case of numbers only
		ComKeyOnlyNumber(ComGetEvent());
		break;
	}
}
function form_keyup() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	//alert("keyValue [" + keyValue + "]");
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}
function form_keyup2() {
	var obj=null;
	var keyValue=event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
	if (keyValue != 13) {
		ComKeyEnter('lengthnextfocus');
	} else {
		obj_deactivate();
	}
}
function chkToDateWeekBlur() {
	var period=document.form.period.value;
	var toDate=document.form.tos.value;
	var frDate=document.form.froms.value;
	var toYearDate=toDate.substring(0, 4);
	var frYearDate=frDate.substring(0, 4);
	var toMonthDate=toDate.substring(5, 7);
	var frMonthDate=frDate.substring(5, 7);
	var frDayDate="";
	var toDayDate="";
	if (frDate.length > 7) {
		frDayDate=frDate.substring(8, 10);
		toDayDate=toDate.substring(8, 10);
	} else {
		frDayDate="01";
		toDayDate=lastDay(toYearDate, toMonthDate);
	}
	var frDateFull=new Date(frYearDate, frMonthDate - 1, frDayDate);
	var toDateFull=new Date(toYearDate, toMonthDate - 1, toDayDate);
	var getDiffTime=toDateFull.getTime() - frDateFull.getTime();
	var retDate=Math.floor(getDiffTime / (1000 * 60 * 60 * 24));
	var retMonth=((parseInt(toYearDate) - parseInt(frYearDate)) * 12 + parseInt(toMonthDate, 10) - parseInt(frMonthDate, 10));
	var retWeek=Math.floor((toDateFull - frDateFull) / (1000 * 60 * 60 * 24 * 7));
	var week="";
	var fromTo=52;
	if (period == "M") {
		if (retMonth >= 12) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "W") {
		if (frYearDate == toYearDate) {
			week=eval(toMonthDate) - eval(frMonthDate) + 1;
		} else {
			betwMonth=fromTo - eval(frMonthDate) + eval(toMonthDate) + 1;
			if ((eval(toYearDate) - eval(frYearDate)) == 1) { //in case of 1 year gap
				week=betwMonth;
			} else {
				week=(eval(toYearDate) - eval(frYearDate) - 1) * fromTo + betwMonth;
			}
		}
		if (week > 26) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM21031");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	} else if (period == "D") {
		if (retDate >= 31) {
			if (ComGetEvent("name") == "tos") {
				ComShowCodeMessage("CIM29029");
				ComSetFocus(document.getElementById("tos"));
			}
			return false;
		}
	}
}
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}
function obj_blur2() {
	var tVal01=document.getElementById("directionWise").value;
	if (tVal01!="L")
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC03);
}
function obj_blur4() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC04);
}
function setDate() {
	var today=new Date();
	var y=today.getFullYear().toString();
	var m=(today.getMonth() + 1).toString();
	if (m.length == 1) {
		m=0 + m;
	}
	var ym=y + '-' + m;
	document.form.froms.value=ym;
	document.form.tos.value=ym;
	var day=lastDay(y, m);
	document.form.fromz.value=y + m + "01";
	document.form.toz.value=y + m + day;
}
//function for handling Axon event
function obj_deactivate() {
	var f=document.getElementById("froms");
	var t=document.getElementById("tos");
	sVal1=f.value.replace(/\/|\-|\./g, "");
	sVal2=t.value.replace(/\/|\-|\./g, "");
	switch (ComGetEvent("name")) {
	case "froms":
		if (ComChkObjValid(ComGetEvent(), false)) {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1 != "" && sVal2 != "") {
					var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						enterSwitch=false;
						t.value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("fromz").value=sVal1 + "01";
					document.getElementById("toz").value=sVal2 + day;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
//							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("fromz").value=sVal1;
					document.getElementById("toz").value=sVal2;
				}
			}
		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
//					ComGetEvent().focus();
					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
//					ComGetEvent().focus();
					ComGetEvent().select();
					enterSwitch=false;
					return false;
				}
			}
		}
		break;
	case "tos":
		if (ComChkObjValid(ComGetEvent(), false)) {
			if (t.getAttribute("dataformat") == "ym") {
				var day=lastDay(sVal2.substring(0, 4), sVal2.substring(4, 6));
				if (sVal1 != "" && sVal2 != "") {
					var flag=ComChkPeriod(sVal1 + "01", sVal2 + day);
					if (flag < 1) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29004");
						}
						enterSwitch=false;
						ComGetEvent().value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
//							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("fromz").value=sVal1 + "01";
				document.getElementById("toz").value=sVal2 + day;
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch=false;
						ComGetEvent().value="";
//						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
//							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("fromz").value=sVal1;
				document.getElementById("toz").value=sVal2;
			}
			enterSwitch=true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
//					t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
//					t.focus();
					t.select();
					return false;
				}
			}
		}
		break;
	}
	return true;
}
function obj_change() {
	obj=ComGetEvent();
	if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.fromz.value="";
			document.form.toz.value="";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.fromz.value="";
			document.form.toz.value="";
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction != IBSEARCH_ASYNC01) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period ");
					ComSetFocus(tos);
					return false;
				}
			}
			if (froms.value.length < 6) {
				return false;
			} else if (tos.value.length < 6) {
				return false;
			}
			if (!enterSwitch) {
				return false;
			}
		}
	} // end of with
	return true;
}
function setDataGridText(caseVal, val01, val02) {
	if (caseVal == "S") {
		if (val01 == "R") {
			return "RCC ";
		} else if (val01 == "L") {
			return "LCC ";
		} else if (val01 == "E") {
			return "ECC ";
		} else if (val01 == "S") {
			return "SCC ";
		} else if (val01 == "C") {
			return "Country ";
		} else if (val01 == "P") {
			return "Port ";
		}
	} else if (caseVal == "M") {
		if (val01 == "R") {
			return " ";
		} else if (val01 == "L") {
			return " RCC";
		} else if (val01 == "E") {
			return " LCC";
		} else if (val01 == "S") {
			return " ECC";
		} else if (val01 == "C") {
			return " RCC";
		} else if (val01 == "P") {
			return " RCC";
		}
	} else {
		if (val01 == "R") {
			return "RCC";
		} else if (val01 == "L") {
			return "LCC";
		} else if (val01 == "E") {
			return "ECC";
		} else if (val01 == "S") {
			return "SCC";
		} else if (val01 == "C") {
			return "Country";
		} else if (val01 == "P") {
			return "Port";
		}
	}
}
function setDataGridText2(caseVal, val) {
	if (caseVal == "S") {
		if (val == "F" || val == "L") {
			return "From";
		} else{
			return "To";
		}
	} else {
		if (val == "F" || val == "L") {
			return "To";
		} else {
			return "From";
		}
	}
}
function t1sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	with (sheetObj) {
		var arrTime=sCntrTypeSize.split(",");
		for ( var ii=4; ii < arrTime.length + 5; ii++) {
			if (sheetObj.RowCount()> 0) {
				if (sheetObj.GetCellValue(sheetObj.LastRow()- 3, ii) != "" && sheetObj.GetCellValue(sheetObj.LastRow()- 2, ii) != "") {
					SetSumValue(0, ii,sheetObj.GetCellValue(sheetObj.LastRow()- 3, ii));
					SetSumText(1, ii,sheetObj.GetCellValue(sheetObj.LastRow()- 2, ii));
				}
			}
		}
		for ( var i=4; i < arrTime.length + 5; i++) {
			if (GetCellValue(LastRow()- 3, i) == "") {
 				SetSumText(0, i,"");
 				SetSumText(1, i,"");
			}
		}
		if (RowCount()> 0) {
			//	RowHidden(RowCount) = true;
			//	RowHidden(RowCount+1) = true;
//2014.11.28 민정호			
//				RowDelete(LastRow()- 3,false);
				RowDelete(LastRow()- 2,false);
			}
 		SetSumText(0, "loc_cd","G.Total");
 		SetSumText(0, "vvd","G.Total");
 		SetSumText(0, "division","G.Total");
 		SetSumText(0, "ibflag","Vol");
 		SetSumText(1, "loc_cd2","G.Total");
 		SetSumText(1, "vvd2","G.Total");
 		SetSumText(1, "division2","G.Total");
 		SetSumText(1, "ibflag2","Ratio");
 		sheetObj.SetRowBackColor(sheetObj.LastRow(),"#F7E1EC");
 		sheetObj.SetRowBackColor(sheetObj.LastRow()-1,"#F7E1EC");
		SetCellAlign(LastRow()- 1, "loc_cd","CenterTop");
		SetCellAlign(LastRow()- 1, "vvd","CenterTop");
		SetCellAlign(LastRow()- 1, "division","CenterTop");
		SetCellAlign(LastRow()- 1, "ibflag","Center");
		SetCellAlign(LastRow(), "loc_cd","CenterTop");
		SetCellAlign(LastRow(), "vvd","CenterTop");
		SetCellAlign(LastRow(), "division","CenterTop");
		SetCellAlign(LastRow(), "ibflag","Center");
		if (RowCount()> 0) {
			SetMergeCell((sheetObj.LastRow()- 1), 0, 2, 3);
			//2014.11.28 민정호			
			SetMergeCell(2, 0, sheetObj.LastRow()-4, 1);						
		}
	}
	setMultiDataGridVerticalMerge(sheetObj, 0);
}

function setMultiDataGridVerticalMerge(sheetObj,colIndex) {
	 var preValue = '';
	 var nowValue = '';
	 var begPos = 2;
	 for ( var i=2; i < sheetObj.LastRow() - 1; i++) {
		 nowValue = sheetObj.GetCellValue(i,colIndex);
		 if (i!=2 && preValue != nowValue) {
			 sheetObj.SetMergeCell(begPos,colIndex,i-begPos,1);
			 begPos = i;
		 }
		 // 마지막 로우인 경우
		 if (i==sheetObj.LastRow()-2) {
			 sheetObj.SetMergeCell(begPos,colIndex,i-begPos+1,1);
		 }
		 preValue = nowValue;
	 }
} 

	 



function setText(rcvVal) {
	var xVal01=document.form.startloc.value;
	var xVal02=document.form.directionWise.value;
	var ft=document.getElementById("ff");
	var ld=document.getElementById("tt");
	if (xVal02 == "F") {
		ft.innerText="From";
		ld.innerText="To";
		if (rcvVal == "R") {
			ComClearCombo(document.form.endloc);
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POD", "P");
			div_loc.style.display="";
			div_loc2.style.display="none";
			div_loc3.style.display="none";
			div_cnty.style.display="none";
			div_cnty2.style.display="none";
//			document.form.locationf1.focus();
		}
		ComClearCombo(document.form.startloc);
		ComAddComboItem(document.form.startloc, "RCC", "R");
		ComAddComboItem(document.form.startloc, "LCC", "L");
		ComAddComboItem(document.form.startloc, "ECC", "E");
		ComAddComboItem(document.form.startloc, "SCC", "S");
		ComAddComboItem(document.form.startloc, "Country", "C");
		ComAddComboItem(document.form.startloc, "POL", "P");
		tabIndex=0;
		document.form.startloc.value=rcvVal;
	} else if(xVal02 == "T") {
		ft.innerText="To";
		ld.innerText="From";
		if (rcvVal == "R") {
			ComClearCombo(document.form.endloc);
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POL", "P");
			div_loc.style.display="";
			div_loc2.style.display="none";
			div_loc3.style.display="none";
			div_cnty.style.display="none";
			div_cnty2.style.display="none";
//			document.form.locationf1.focus();
		}
		ComClearCombo(document.form.startloc);
		ComAddComboItem(document.form.startloc, "RCC", "R");
		ComAddComboItem(document.form.startloc, "LCC", "L");
		ComAddComboItem(document.form.startloc, "ECC", "E");
		ComAddComboItem(document.form.startloc, "SCC", "S");
		ComAddComboItem(document.form.startloc, "Country", "C");
		ComAddComboItem(document.form.startloc, "POD", "P");
		tabIndex=0;
		document.form.startloc.value=rcvVal;
	}else{
		ft.innerText="From";
		ld.innerText="To";
		if (rcvVal == "R") {
			ComClearCombo(document.form.endloc);
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POD", "P");
			div_loc.style.display="none";
			div_loc2.style.display="";
			div_loc3.style.display="";
			div_cnty.style.display="none";
			div_cnty2.style.display="none";
//			document.form.locationf2.focus();
		}
		ComClearCombo(document.form.startloc);
		ComAddComboItem(document.form.startloc, "RCC", "R");
		ComAddComboItem(document.form.startloc, "LCC", "L");
		ComAddComboItem(document.form.startloc, "ECC", "E");
		ComAddComboItem(document.form.startloc, "SCC", "S");
		ComAddComboItem(document.form.startloc, "Country", "C");
		ComAddComboItem(document.form.startloc, "POL", "P");
		tabIndex=1;
		document.form.startloc.value=rcvVal;
	}
}
function setText2(sheetObj) {
	var xVal01=document.form.startloc.value;
	var xVal02=document.form.directionWise.value;
	var xVal03=document.form.endloc.value;
	var ft=document.getElementById("ff");
	var ld=document.getElementById("tt");
	if (xVal02 == "L"){ //Loc_Loc 일때 
		if (xVal01 == "R") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "L") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "E") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "S") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "C") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "P") {
			sheetObj.SetCellValue(0, 1,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		}
	}else{
		if (xVal02 == "F"  && xVal01 == "R") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal02 == "T" && xVal01 == "R") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "L") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "E") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "S") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "C") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		} else if (xVal01 == "P") {
			sheetObj.SetCellValue(0, 0,setDataGridText2("S", xVal02),0);
			sheetObj.SetCellValue(0, 1,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 2,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(0, 3,setDataGridText2("E", xVal02),0);
			sheetObj.SetCellValue(1, 0,setDataGridText("S", xVal01, xVal02),0);
			sheetObj.SetCellValue(1, 1,setDataGridText("M", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 2,setDataGridText("E", xVal03, xVal02),0);
			sheetObj.SetCellValue(1, 3,setDataGridText("E", xVal03, xVal02),0);
		}
	}
}
function setSubCombo() {
	var xVal01=document.form.startloc.value;
	var xVal02=document.form.directionWise.value;
	if (xVal01 == "R" && xVal02 == "F") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "RCC", "R");
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		ComAddComboItem(document.form.endloc, "Country", "C");
		ComAddComboItem(document.form.endloc, "POD", "P");
		setTextBox("L");
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "R" && xVal02 == "T") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "RCC", "R");
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		ComAddComboItem(document.form.endloc, "Country", "C");
		ComAddComboItem(document.form.endloc, "POL", "P");
		setTextBox("L");
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "L") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "LCC", "L");
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "E") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "ECC", "E");
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "S") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "SCC", "S");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "C") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "Country", "C");
		if (xVal02=="L"){
			setTextBox("C2");
		}else{
			setTextBox("C");
		}
		document.form.locationf1.value="";
		document.form.locationf2.value="";
		document.form.locationt2.value="";
	} else if (xVal01 == "P" && xVal02 == "F") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "POD", "P");
		if (xVal02=="L"){
			setTextBox("L2");
		}else{
			setTextBox("L");
		}
		document.form.country.value="";
		document.form.country2.value="";
	} else if (xVal01 == "P" && xVal02 == "T") {
		ComClearCombo(document.form.endloc);
		ComAddComboItem(document.form.endloc, "POL", "P");
		setTextBox("L");
		document.form.country.value="";
		document.form.country2.value="";
	}else if (xVal02 == "L") {
		if(xVal01 == "P"){
			ComClearCombo(document.form.endloc);
			ComAddComboItem(document.form.endloc, "POD", "P");
		}else{
			ComClearCombo(document.form.endloc);
			ComAddComboItem(document.form.endloc, "RCC", "R");
			ComAddComboItem(document.form.endloc, "LCC", "L");
			ComAddComboItem(document.form.endloc, "ECC", "E");
			ComAddComboItem(document.form.endloc, "SCC", "S");
			ComAddComboItem(document.form.endloc, "Country", "C");
			ComAddComboItem(document.form.endloc, "POD", "P");
		}
		setTextBox("L2");
		if(xVal01 == "C"){
			document.form.locationf2.value="";
			document.form.locationt2.value="";
		}else{
			document.form.country.value="";
			document.form.country2.value="";
		}
	}
}
function setTextBox(xVal01) {
	if (xVal01 == "L") {
		div_loc.style.display="";
		div_loc2.style.display="none";
		div_loc3.style.display="none";
		div_cnty.style.display="none";
		div_cnty2.style.display="none";
//		document.form.locationf1.focus();
	}  else if (xVal01 == "L2") {
		div_loc.style.display="none";
		div_loc2.style.display="";
		div_loc3.style.display="";
		div_cnty.style.display="none";
		div_cnty2.style.display="none";
//		document.form.locationf2.focus();
	}  else if (xVal01 == "C") {
		div_loc.style.display="none";
		div_loc2.style.display="none";
		div_loc3.style.display="none";
		div_cnty.style.display="";
//		document.form.country.focus();
	}else if (xVal01 == "C2") {
		div_loc.style.display="none";
		div_loc2.style.display="none";
		div_loc3.style.display="none";
		div_cnty.style.display="";
		div_cnty2.style.display="";
//		document.form.country.focus();
	}
}
function rdTypeSel(type) {
	if (type == "R") {
		document.form.rdtype.disabled=false;
	} else {
		document.form.rdtype.disabled=true;
		document.form.rdtype.value="I";
	}
}
function t1sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
}
function t1sheet2_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[1], document.form, IBSEARCH_ASYNC01);
}
