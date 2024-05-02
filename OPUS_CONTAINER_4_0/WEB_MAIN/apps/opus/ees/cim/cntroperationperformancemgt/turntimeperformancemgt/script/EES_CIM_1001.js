/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_CIM_1001.js
*@FileTitle  : Turn Time by PORT
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
/****************************************************************************************
  Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
/**
 * @extends 
 * @class ees_cim_1001 : business script for ees_cim_1001 
 */

// common global variables
var tabObjects=new Array();
var tabCnt=0;
var beforetab=1;
var sheetObjects=new Array();
var sheetCnt=0;
var oldCntrTypeSize="";
var sCntrTypeSize="";
var oldCntrTypeSize2="";
var tabIndex=0;
var isOpen=false;
var enterSwitch=false;
// Event handler processing by button click event */
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var shtCnt=0;
	/*******************************************************/
	var formObject=document.form;
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_Retrieve":
			if (tabIndex == 0) {
				doActionIBSheet(sheetObjects[0] , formObject, IBSEARCH);
			} else {
				doActionIBSheet2(sheetObjects[1], formObject, IBSEARCH);
			}
			break;
		case "btn_downExcel":
			if (tabIndex == 0) {
				if(t1sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					t1sheet1.Down2Excel({ HiddenColumn:1 , SheetDesign:1 , Merge:1});
				}
				
			} else {
				if(t2sheet1.RowCount() < 1){//no data
					ComShowCodeMessage("COM132501");
				}else{
					t2sheet1.Down2Excel({ HiddenColumn:1 , SheetDesign:1, Merge:1});
				}
				
			}
			break;
		case "btn_new":
			t1sheet1.RemoveAll();
			t2sheet1.RemoveAll();
			formObject.rdtype.disabled=true;
			formObject.rdtype.value="I";
			document.getElementById("location").className="input";
			document.getElementById("location").value="";
			document.getElementById("location").disabled=true;
			formObject.reset();
			ComSetFocus(formObject.froms);
			
			tabObjects[0].SetSelectedIndex(0);
			break;
		case "btns_calendarfm":
			var cal=new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.froms, 'yyyy-MM');
			break;
		case "btns_calendarto":
			var cal=new ComCalendar();
			cal.setDisplayType('month');
			cal.select(formObject.tos, 'yyyy-MM');
			break;
		case "btn_loc_cd": //retrieving Location popup
			var cnt_cd="";
			var loc_cd="";
			cnt_cd=formObject.inquiryLevel.value;
			loc_cd=formObject.location.value;
			if (formObject.inquiryLevel.value != 'A') {
				if (formObject.inquiryLevel.value == 'C') { //Country
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopup("/opuscntr/COM_ENS_0M1.do", 565, 650, "popupFinish", "1,0,1,1,1,1,1,1", true);
				} else {
					var loc_code="";
					if (formObject.inquiryLevel.value == "R") {
						loc_code="rcc_cd";
					} else if (formObject.inquiryLevel.value == "P") {
						loc_code="loc_cd";
					}
					var param="?cnt_cd=" + cnt_cd + "&loc_cd=" + loc_cd;
					ComOpenPopupWithTarget('/opuscntr/COM_ENS_051.do', 1000, 460, loc_code + ":location", "1,0,1,1,1,1,1,1", true);
				}
			}
			break;
		case "btn_print":
			alert("btn_print");
			break;
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowCodeMessage("CIM30032");
		} else {
			alert(e);
		}
	}
}
/**
 * setting selected value from Location by loc_cd popup
 */
function popupFinish(aryPopupData, row, col, sheetIdx) {
	var sheetObject=sheetObjects[0];
	var formObject=document.form;
	formObject.location.value=aryPopupData[0][3]
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
 * adding first-served functions after loading screen.
 */
function loadPage() {
	
	
	for (i=0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	resizeSheet();
	t1sheet1_OnLoadFinish(sheetObjects[0]);	
	axon_event.addListenerForm('click', 'obj_tpsz_click', form);
	axon_event.addListener('blur', 'obj_blur', 'location');
	axon_event.addListenerForm('change', 'obj_change', form);
	axon_event.addListenerForm('focus', 'obj_activate', document.form); 
	axon_event.addListenerForm('blur', 'obj_deactivate', document.form); 
	//axon_event.addListenerFormat('keyup', 'form_keyup', form);
	//axon_event.addListener('keydown', 'ComKeyEnter', 'form');
	document.getElementById("location").className="input";
	for (k=0; k < tabObjects.length; k++) {
		initTab(tabObjects[k], k + 1);
		tabObjects[k].SetSelectedIndex(0);
	}
	
	isOpen=true;
	
	document.form.froms.focus();
}

function t1sheet1_OnLoadFinish(sheetObj) {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC01);
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
//handling Axon event
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
						//ComShowCodeMessage("CIM29004");
						enterSwitch=false;
						t.value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1 + "01";
					document.getElementById("to").value=sVal2 + day;
				}
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						ComShowCodeMessage("CIM29003");
						enterSwitch=false;
						t.value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							t.value="";
							t.focus();
							t.select();
							return false;
						}
					}
					document.getElementById("from").value=sVal1;
					document.getElementById("to").value=sVal2;
				}
			}
		} else {
			if (f.getAttribute("dataformat") == "ym") {
				if (sVal1.length > 0 && !ComIsMonth(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					enterSwitch=false;
					ComGetEvent().focus();
					ComGetEvent().select();
					return false;
				}
			} else { // retrieving by week
				if (sVal1.length > 0 && !ComIsWeek(sVal1.substring(4, 6)) && ComGetEvent("name") == 'froms') {
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					ComGetEvent().focus();
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
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1 + "01";
				document.getElementById("to").value=sVal2 + day;
			} else { // retrieving by week
				if (sVal1 != "" && sVal2 != "") {
					if (ComParseInt(sVal1) > ComParseInt(sVal2)) {
						if (ComGetEvent("name") == "tos") {
							ComShowCodeMessage("CIM29003");
						}
						enterSwitch=false;
						ComGetEvent().value="";
						t.focus();
						t.select();
						return false;
					} else {
						if (chkToDateWeekBlur() == false) {
							enterSwitch=false;
							ComGetEvent().value="";
							t.focus();
							t.select();
							return false;
						}
					}
				}
				document.getElementById("from").value=sVal1;
				document.getElementById("to").value=sVal2;
			}
			enterSwitch=true;
		} else {
			if (t.getAttribute("dataformat") == "ym") {
				if (sVal2.length > 0 && !ComIsMonth(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYMM");
					t.focus();
					t.select();
					return false;
				}
			} else { // retrieving by week
				if (sVal2.length > 0 && !ComIsWeek(sVal2.substring(4, 6))) {
					enterSwitch=false;
					ComGetEvent().value="";
					ComShowCodeMessage("CIM21004", "YYYYWW");
					t.focus();
					t.select();
					return false;
				}
			}
		}
		break;
	}
	return true;
}
function lastDay(y, m) {
	var d, d2, s="";
	d=new Date();
	d2=new Date(y, m, "");
	s=d2.getDate();
	return (s);
}
function obj_activate() {
	ComClearSeparator(ComGetEvent());
	ComSetFocus(ComGetEvent());
}
function obj_tpsz_click() {
	obj=ComGetEvent();
	if (obj.name == "tpsz") { // by TP/SZ kind
		if (obj.value != "R") {
			document.form.rdtype.disabled=true;
			document.form.rdtype.value="I";
		} else {
			document.form.rdtype.disabled=false;
		}
	}
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
	document.form.from.value=y + m + "01";
	document.form.to.value=y + m + day;
}
function obj_blur() {
	doActionIBSheet(sheetObjects[0], document.form, IBSEARCH_ASYNC02);
}

function obj_change() {
	obj=ComGetEvent();
	if (obj.name == "inquiryLevel") {
		if (obj.value == "A") {
			document.getElementById("location").disabled=true;
			document.getElementById("location").value="";
			document.getElementById("location").className="input";
		} else {
			document.getElementById("location").disabled=false;
			document.getElementById("location").className="input";
		//	document.getElementById("location").value = "";
			if (obj.value == "C") {
				document.getElementById("location").setAttribute("maxLength", 2);
			} else {
				document.getElementById("location").setAttribute("maxLength", 5);
			}
			document.getElementById("location").focus();
		}
	} else if (obj.name == "period") {
		if (obj.value == "M") {
			document.getElementById("froms").setAttribute("dataformat", "ym");
			document.getElementById("tos").setAttribute("dataformat", "ym");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
		} else {
			document.getElementById("froms").setAttribute("dataformat", "yw");
			document.getElementById("tos").setAttribute("dataformat", "yw");
			document.form.froms.value="";
			document.form.tos.value="";
			document.form.from.value="";
			document.form.to.value="";
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
	case "t1sheet1": //t1sheet1 init
	    with(sheetObj){
		        var sCount="";
		        var x=1;
		        var HeadTitle1="POL|Total";
		        oldCntrTypeSize=sCntrTypeSize;
		        var arrCntrTypeSize=oldCntrTypeSize.split(",");
		        var arrHead=new Array();
		      	for ( var i=0; i < arrCntrTypeSize.length; i++) {
		      		if (sCntrTypeSize != "") {
		      			HeadTitle1 += "|" + arrCntrTypeSize[i];
		     	 }}
		      	for ( var i=arrCntrTypeSize.length + 2; i < 42; i++) {
			    	  sheetObj.SetColHidden(i,1);
			      }
		      	SetConfig( { SearchMode:2, FrozenCol:2, MergeSheet:0, Page:20,PrevColumnMergeMode:0} );
		      	var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      	var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      	InitHeaders(headers, info);
		      	var cols = [ {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"pol",     KeyField:0,   CalcLogic:"",   Format:"" },
		      	             {Type:"AutoAvg",   Hidden:0, Width:40,   Align:"Right",   ColMerge:1,   SaveName:"total",   KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:1 } ];
		      	for ( var i = 0; i < arrCntrTypeSize.length; i++) {
      				if (arrCntrTypeSize.length > 1) {
      					if (x < 10) {
      						sCount = "count0" + x;
      					} else {
      						sCount = "count" + x;
      					}
      				cols.push({Type:"AutoAvg",   Hidden:0, Width:45,   Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:1 });
      				}
		      	}
      			x = arrCntrTypeSize.length + 1;
      			for ( var i = 0; i < 40 - arrCntrTypeSize.length; i++) {
      				if (arrCntrTypeSize.length > 1) {
		      			if (x < 10) {
		      				sCount = "count0" + x;
		      			} else {
		      				sCount = "count" + x;
		      			}
		      			cols.push({Type:"AutoAvg",      Hidden:1, Width:45,   Align:"Right",   ColMerge:1,   SaveName:sCount,    KeyField:0,   CalcLogic:"",   Format:"Float",   PointCount:1 });
		      			x++;
      				}
      			}
      		 InitColumns(cols);
      		 SetEditable(0); 
      		 SetWaitImageVisible(0);
      		 SetCountPosition(0);
      		ComResizeSheet(sheetObj);
      	     //SetSheetHeight(435);
      		 //resizeSheet();
	}
	    break;
	case "t2sheet1": //t2sheet1 init
	    with(sheetObj){
				var HeadTitle1="POL|Division|Total";
				oldCntrTypeSize2=sCntrTypeSize;
				var arrCntrTypeSize=oldCntrTypeSize2.split(",");
				var arrHead=new Array(5);
				for ( var i=0; i < arrCntrTypeSize.length; i++) {
					if (sCntrTypeSize != "") {
						HeadTitle1 += "|" + arrCntrTypeSize[i];
					}
				}
				for ( var i=arrCntrTypeSize.length + 3; i < 43; i++) {
					sheetObj.SetColHidden(i,1);
				}
				  var rowCnt=0;
				  var POL=60;
				  var Division=60;
				  var Total=80;
				  cnt=0;
				  SetConfig( { SearchMode:2, FrozenCol:3, MergeSheet:7, Page:20,PrevColumnMergeMode:0} );
				  var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
				  var headers = [ { Text:HeadTitle1, Align:"Center"} ];
				  InitHeaders(headers, info);
				  
				  var colList = new Array();
			      
			      var cols = [ {Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"pol",         KeyField:0,   CalcLogic:"",   Format:"" },
			                   {Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"etc",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 },
			                   {Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 } ];
			      var sCount = "";
			      var x = 1;     			      
			      
			      for ( var i=0; i < arrCntrTypeSize.length; i++) {
			    	  if (arrCntrTypeSize.length > 1) {
			    		  if (x < 10) {
			    			  sCount="count0" + x;
			    		  } else {
            				sCount="count" + x;
			    		  }
			    		  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
			    		  x++;
			    	  }
			      }
			      
			      
            	  for ( var i=0; i < 40 - arrCntrTypeSize.length; i++) {
            			if (arrCntrTypeSize.length > 1) {
            				if (x < 10) {
            					sCount="count0" + x;
            				} else {
            					sCount="count" + x;
            				}
            				cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
            				x++;
            			}
            		}
            		
            		
            	  
            			rowCnt++;
            			cnt = 0;
            			colList.push(cols);
            			cols = [];
            			cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d2POL",       KeyField:0,   CalcLogic:"",   Format:"" });
            			cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"d2Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
            			cols.push({Type:"AutoSum",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
            			x=1;
            			for ( var i=0; i < arrCntrTypeSize.length; i++) {
				    	  if (arrCntrTypeSize.length > 1) {
				    		  if (x < 10) {
				    			  sCount="count0" + x;
				    		  } else {
				    			  sCount="count" + x;
				    		  }
				    		  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    		  x++;
				    	  }  
				    	  }
            			  x = arrCntrTypeSize.length + 1;
				    	  for ( var i=0; i < 40 - arrCntrTypeSize.length; i++) {
				    			  if (arrCntrTypeSize.length > 1) {
				    				  if (x < 10) {
				    					  sCount="count0" + x;
				    				  } else {
				    					  sCount="count" + x;
				    				  }
				    				  cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    				  x++; 
				    			  }}
				    	 rowCnt++;
            			colList.push(cols);
            			cols = [];
	            		 cnt = 0;	
	            		 
	            		 
	            		 
	            		 cols.push({Type:"Text",      Hidden:0,  Width:POL,  Align:"Center",  ColMerge:1,   SaveName:"d3POL",       KeyField:0,   CalcLogic:"",   Format:"" });
				    	 cols.push({Type:"Text",      Hidden:0,  Width:Division,Align:"Center",  ColMerge:1,   SaveName:"d3Division",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    	 cols.push({Type:"Text",   Hidden:0, Width:Total,Align:"Right",   ColMerge:0,   SaveName:"total",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    	 x = 1;			  
				    	 for ( var i=0; i < arrCntrTypeSize.length; i++) {
				    			 if (arrCntrTypeSize.length > 1) {
				    				 if (x < 10) {
				    					 sCount="count0" + x;
				    				} else {
				    					 sCount="count" + x;
				    				 }
				    				  cols.push({Type:"Text",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    				  x++;
				    	 }}
				    	 x = arrCntrTypeSize.length + 1;					  
				    	 for ( var i=0; i < 40 - arrCntrTypeSize.length; i++) {
				    		 if (arrCntrTypeSize.length > 1) {
				    			if (x < 10) {
				    					sCount="count0" + x;
				    				} else {
				    					 sCount="count" + x; }
				    		cols.push({Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:sCount,        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:1 });
				    			x++;
				    	}}
	        colList.push(cols);				 
            InitColumns(colList , 3);
			SetEditable(0);
			SetWaitImageVisible(0);
			SetCountPosition(0);
			SetSheetHeight(435);
			//resizeSheet();
      }
		break;
	}
}
//Sheet의 높이 자동으로 변경
function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
//handling process for Sheet
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH:
		isOpen=true;
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH03;
			sheetObj.DoSearch("EES_CIM_1001GS.do", FormQueryString(formObj) );
		} else {
			return;
		}
		break;
	case IBSEARCH_ASYNC01:
		formObj.f_cmd.value=SEARCH01;
		if (sheetObj.id == "t1sheet1") {
			var sXml=formObj.sXml.value;
			sCntrTypeSize=ComGetEtcData(sXml, "cntrTypeSize");
		}
		oldCntrTypeSize=sCntrTypeSize;
		sheetObjects[0] = t1sheet1.Reset();
		initSheet(sheetObjects[0]);
		//sheetObjects[0] = t1sheet1;
		
		oldCntrTypeSize2=sCntrTypeSize;
		sheetObjects[1] = t2sheet1.Reset();
		initSheet(sheetObjects[1]);
		//sheetObjects[1] = t2sheet1;
		ComSetFocus(formObj.froms);
		break;
	case IBSEARCH_ASYNC02: //location focusOut
		if (validateForm(sheetObj, formObj, sAction)) {
			formObj.f_cmd.value=SEARCH02;
			if (formObj.location.value == "") {
				return true;
			}
			var sXml=sheetObj.GetSearchData("EES_CIM_1001GS.do", FormQueryString(formObj));
			var sCheck=ComGetEtcData(sXml, "check");
			if (sCheck != "OK") {
				var inquiryLevel=document.getElementById("inquiryLevel").value;
				if (document.form.location.value != "") {
					if (inquiryLevel == "R") {
						ComShowCodeMessage("CIM29008");
						document.form.location.value="";
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "C") {
						ComShowCodeMessage("CIM29009");
						document.form.location.value="";
						ComSetFocus(document.form.location);
						return false;
					} else if (inquiryLevel == "P") {
						ComShowCodeMessage("CIM29010");
						document.form.location.value="";
						ComSetFocus(document.form.location);
						return false;
					}
				} else {
					return true;
				}
			}
			ComSetFocus(document.form.portcom);
		} else {
			return;
		}
		break;
	}
}
function doActionIBSheet2(sheetObj, formObj, sAction) {
	isOpen=true;
	switch (sAction) {
	case IBSEARCH:
		if (validateForm(sheetObj, formObj, sAction)) {
			ComOpenWait(true);
			formObj.f_cmd.value=SEARCH;
			sheetObj.DoSearch("EES_CIM_10012GS.do", FormQueryString(formObj) );
		} else {
			return;
		}
		break;
	}
}
/**
 * registering IBTab Object as list
 * adding process for list in case of needing batch processing with other items 
 * defining list on the top of source
 */
function setTabObject(tab_obj) {
	tabObjects[tabCnt++]=tab_obj;
}
/**
 * initializing Tab
 * setting Tab items
 */
function initTab(tabObj, tabNo) {
	switch (tabNo) {
	case 1:
		with (tabObj) {
			var cnt=0;
			InsertItem( "Summary", "");
			InsertItem( "  Detail  ", "");
		}
		break;
	}
}
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnChange(tabObj, nItem) {
	var objs=document.all.item("tabLayer");
	objs[nItem].style.display="Inline";
	for(var i = 0; i<objs.length; i++){
	   if(i != nItem){
	        objs[i].style.display="none";
	    objs[beforetab].style.zIndex=objs[nItem].style.zIndex - 1 ;
	   }
	  }
	resizeSheet();
	beforetab=nItem;
	tabIndex=nItem;
}
/**
 * event when clicking Tab
 * activating selected tab items
 */
function tab1_OnClick(tabObj, nItem) {
	beforetab=nItem;
	tabIndex=nItem;
	if (isOpen) {
		if (nItem == 0) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		} else if (nItem == 1) {
			doActionIBSheet2(sheetObjects[1], document.form, IBSEARCH);
		}
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		if (sAction == IBSEARCH) {
			if (period.value == "M") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(tos);
					return false;
				}
			} else if (period.value == "W") {
				if (froms.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
					ComSetFocus(froms);
					return false;
				} else if (tos.value == "") {
					ComShowCodeMessage("CIM21001", "Period");
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
			if (inquiryLevel.value != "A") {
				if (location.value == "") {
					ComShowCodeMessage("CIM21001", "Location");
					ComSetFocus(location);
					return false;
				}
			}
		}
	}
	return true;
}
function t1sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
	ComOpenWait(false);
	with (sheetObj) {
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=1; i < arrTime.length + 2; i++) {
			if (ComIsNull(GetCellValue(RowCount(), i))) {
				SetSumText(0, i,"");
			} else {
				SetSumText(0, i,GetCellText(RowCount(), i));
			}
		}
		if (RowCount()> 0) {
			SetRowHidden(RowCount(),1);
		}
		SetSumText(0,"TOTAL")
	}
}
function t2sheet1_OnChangeSum(sheetObj, Row) {
	with (sheetObj) {
		SetSumText(0, 0,"Total");
		SetSumText(1, 0,"Total");
		SetSumText(2, 0,"Total");
		SetSumText(0, "etc","CNTR");
		SetSumText(1, "etc","Days");
		SetSumText(2, "etc","T/Time");
		SetCellAlign(LastRow()- 2, "pol","CenterTop");
		SetCellAlign(LastRow()- 1, "pol","CenterTop");
		SetCellAlign(LastRow(), "pol","CenterTop");
		SetMergeCell((LastRow()- 2), 0, 3, 1);
	}
}
function t2sheet1_OnSearchEnd(sheetObj, code, ErrMsg) {
	ComOpenWait(false);
	//with (sheetObj) {
		var strDays = parseFloat(t2sheet1.GetSumValue(1, 2));
		var strCntr = parseFloat(t2sheet1.GetSumValue(0, 2));
		t2sheet1.SetSumText(2, 2,Math.round(t2sheet1.GetSumValue(1, 2) / t2sheet1.GetSumValue(0, 2) * 100) / 100);
		
		var arrTime=sCntrTypeSize.split(",");
		for ( var i=3; i < arrTime.length + 3; i++) {
		if (t2sheet1.GetSumValue(0, i) > 0) {
				t2sheet1.SetSumText(2, i,Math.round(t2sheet1.GetSumValue(1, i) / t2sheet1.GetSumValue(0, i) * 100) / 100);
			}else{
				t2sheet1.SetSumText(2, i,"0.0");
			}
		}	
		
		/*var arrTime=sCntrTypeSize.split(",");
		for ( var i=2; i < arrTime.length + 3; i++) {
			if (ComIsNull(t2sheet1.GetCellValue(t2sheet1.RowCount(), i))) {
				SetSumText(0, i,"");
				SetSumText(1, i,"");
				SetSumText(2, i,"");
			}
		}*/
		
		t2sheet1.SetCellAlign(t2sheet1.LastRow()- 2, "etc","Center");
		t2sheet1.SetCellAlign(t2sheet1.LastRow()- 1, "etc","Center");
		t2sheet1.SetCellAlign(t2sheet1.LastRow(), "etc","Center");
		t2sheet1.SetSumText(0,0,"Average")
		t2sheet1.SetSumText(0,1,"CNTR")
		t2sheet1.SetSumText(1,1,"Days")
		t2sheet1.SetSumText(2,1,"T/Time")
		t2sheet1.SetMergeCell(t2sheet1.LastRow()-2,0,3,1)
	//}
}
