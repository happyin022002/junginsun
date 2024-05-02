/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : EES_EQR_0069.js
 *@FileTitle : Execution Plan
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2017/01/02
=========================================================*/
/**
 * @fileoverview
 * @author
 */
// common static variable

var sheetObjects = new Array();
var sheetCnt = 0; 
var comboObjects = new Array();
var comboCnt = 0;
var frmObj = new Array();
var oldValue = null; // original value in the cell
var linkPageNum = null; // selected tab from EES_EQR_0051
var allTpszCnt = null; // amount if TP/SZ=ALL
var ComboData = "N";
var strLoading = false;
var sendToRefNo    = "";
var strMinimizeYN = true;
var IBSEARCH02=30;
var IBSEARCH03=31;
var click_vvd="";
var arrSoAlert = "";
var schAllTysz = "";

// Event handler processing by button click event */
document.onclick = processButtonClick;
// Event handler processing by button name */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	// initailizing so send
	formObject.so_action.value = "";
	try {
		var srcName = ComGetEvent("name");
		if (ComGetBtnDisable(srcName))
			return false;
		switch (srcName) {
		case "btn_new":			
			if(strMinimizeYN == false) {				
				var minHeight1 = sheetObjects[0].GetSheetHeight()-200;
				
				document.getElementById("searchLayer").style.display = "Inline";
		    	sheetObjects[0].SetSheetHeight(minHeight1);
		    	
		    	strMinimizeYN= true;
		    	document.getElementById("btn_minimize").innerText = "Maximize";    		
			}
			
			// FM/TO LOC
			document.all.fmToLayer.style.display = "inline";
			ComBtnDisable("btn_create");
            ComBtnDisable("btn_delete");
           
			formObject.reset();
			for (p = 0; p < comboObjects.length; p++) {
			//	initCombo(comboObjects[p], p + 1);
			}
			
			tpszChange(''); // ALL 선택
			// Retieving Repo.PlanID
			// goSearchRepoid();
			formObject.yyyyww.value = "";
			formObject.seq.value = "";
			formObject.repo_rmk.value = "";
			// tpsz initializing
			//comboObjects[2].SetSelectCode(-1);
			//comboObjects[2].SetSelectCode(consTpsz);
			comboObjects[2].SetSelectCode(consTpsz);
			comboObjects[3].SetSelectCode("ALL");
			
			schAllTysz = "";
			sheet1.RemoveAll();
			break;
		case "btn_retrieve":
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);			
			break;
		case "btn_downexcel":			
			if (sheetObject.RowCount() > 0) {
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			}else{
				ComShowCodeMessage("EQR90039");
			}
			break;
		case "btn_print":
			if (sheetObjects[0].RowCount('') > 0) {
				sheetObjects[0].DoPrint();
			}
			
			if (sheetObjects[0].RowCount('') == 0) {
				ComShowCodeMessage("EQR90095");
			}
			break;
		case "btn_eqorg":
			ComOpenWindowCenter('EES_EQR_0139.do', "ESM_BKG_0139", 500, 550,
					false);
			break;
		case "btn_eqr_week":
			ComOpenWindow('EES_EQR_0008_POP.do?pop_mode=Y', window,
					"scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:600px",
					true);
			break;
		case "btn_minimize":
			 sheet_HgtChange();
			 break;   
			 
		case "btng_middlepoint":
			var xx1 = "";
			var Row = sheetObjects[0].GetSelectRow(); // selected ROW
			xx1 = sheetObjects[0].GetCellValue(Row, "middle_point");
			form.middle_point_val.value = xx1;
			if(xx1 == -1) xx1="";
			var param="?returnval=" + xx1 + "&sel_row="+Row;
			ComOpenPopup('EES_EQR_0069_POP.do'+param, 805, 470, 'setPopData_Point', '1,0');
			break;
		case "btn_create":
	        	doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC03);
 	    	break;
 	    case "btn_delete":
	        	doActionIBSheet(sheetObjects[0], formObject, IBDELETE);
 	    	break;
 	    	
 	    	
 	    	
 	   case "frloc_btn":
			var display = "0,1,1,1,1,1";
			var targetObjList = "loc_dpth_cd:fromStatus|loc_cd:fromLocation";
			var param = "?depth=4&classId=COM_ENS_0O1";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500,
					440, targetObjList, display);
			break;
		case "toloc_btn":
			var display = "0,1,1,1,1,1";
			var targetObjList = "loc_dpth_cd:toStatus|loc_cd:toLocation";
			var param = "?depth=4&classId=COM_ENS_0O1";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0O1.do' + param, 500,
					450, targetObjList, display);
			
			break;
		case "btn_vvd":
			var v_scnr_id = formObject.repo_pln_id.value;
			var v_display = "0,1";
			if (v_scnr_id == "") {
				ComShowCodeMessage("EQR90001", "Repo Pln ID");
				return false;
			}
			var targetObjList = "vvd:vvd";
			var param = "?classId=COM_ENS_0P1&scnr_id=" + v_scnr_id
					+ "&depth=4&chkDepth=3";
			ComOpenPopupWithTarget('/opuscntr/COM_ENS_0P1.do' + param, 500,
					450, targetObjList, v_display, true);
			break;
			
			
			
		case "btng_rowadd":
			doActionIBSheet(sheetObject, formObject, IBINSERT);
			break;
		
		case "btng_repobkgcre":
			doActionIBSheet2(sheetObject, formObject, IBSAVE);
			break;
		case "btng_sendtoso":
			doActionIBSheet3(sheetObject, formObject, IBSAVE);
			break;
		case "btng_cancelsoreq":
			doActionIBSheet4(sheetObject, formObject, IBSAVE);
			break;
		case "btng_contassign":
			var view = false; // false(normal cntr popup) true (only view cntr popup)
			var Row = sheetObject.GetSelectRow(); // selected ROW
			if (sheetObject.GetCellValue(Row, "mt_bkg_no") == "") {
				view = false;
			} else {
				view = true;
			}
			if (!userAreaCheck(sheetObject, "CNTR", "from", "1", Row)) {
				view = true;
			}
			
			document.form.cntrno.value = sheetObject.GetCellValue(Row,"cntrno");
			
			var sRow = sheetObject.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			var cntr_all = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObject.GetCellValue(arRow[i], "cntrno") != "" && arRow[i] != Row 
							&& sheetObject.GetCellValue(Row, "pln_yrwk") == sheetObject.GetCellValue(arRow[i], "pln_yrwk")
							&& sheetObject.GetCellValue(Row, "trsp_mod_cd") == sheetObject.GetCellValue(arRow[i],"trsp_mod_cd")
							&& sheetObject.GetCellValue(Row, "to_ecc") == sheetObject.GetCellValue(arRow[i], "to_ecc")
							&& sheetObject.GetCellValue(Row, "fm_ecc") == sheetObject.GetCellValue(arRow[i], "fm_ecc")) {
						cntr_all = cntr_all+ sheetObject.GetCellValue(arRow[i],"cntrno") + ",";
					}
				}
			}
			document.form.cntrno_all.value = cntr_all;
			oldValue = 0; // oldvalue initializing
			
			var url = "EES_EQR_0094.do" + "?f_cmd=-1" // DEFAULT
					+ "&repoplan_id="
					+ sheetObject.GetCellValue(Row, "repo_pln_id")
					+ "&ref_id=" + sheetObject.GetCellValue(Row, "ref_id")
					+ "&bkgno="
					+ sheetObject.GetCellValue(Row, "mt_bkg_no")
					+ "&targetSheet=1" + "&targetRow=" + Row
					+ "&view=" + view + "&fm_ecc="
					+ sheetObject.GetCellValue(Row, "fm_ecc") + "&to_ecc="
					+ sheetObject.GetCellValue(Row, "to_ecc")
					+ "&pln_yrwk="
					+ sheetObject.GetCellValue(Row, "pln_yrwk")
					+ "&trsp_mode="
					+ sheetObject.GetCellValue(Row, "trsp_mod_cd");
			
			ComOpenWindowCenter(url, "EES_EQR_0094", 800, 570, true);
			break;
			
		/*case "btng_rowcopy":
			doActionIBSheet(sheetObject, formObject, IBCOPYROW);
			break;
		case "btng_sort":
			ComShowMessage("btng_sort");
			break;
		case "btng_sendtoso":
			doActionIBSheet_1(sheetObject, formObject, IBSAVE);
			break;
		case "btng_cancelsoreq":
			doActionIBSheet_2(sheetObject, formObject, IBSAVE);
			break;
		case "btng_forecast":
			// Fcst Inventory popup
			openFcstInvWindow();
			break;
		case "btng_irg":
			// IRG (PRD open)
			openIrgWindow();
			break;
		case "btn_repolist":
			var week = formObject.yyyyww.value;
			if (week != "") {
				var toWeek = week.substr(4, 2);
				var fmWeek = toWeek - 3;
				if (fmWeek <= 0) {
					fmWeek = "";
				}

				fmWeek = "" + fmWeek;
				if (fmWeek.length == 1) {
					fmWeek = "0" + fmWeek;
				}
				var repo_SWeek = "repo_SWeek=" + fmWeek;
				var repo_EWeek = "repo_EWeek=" + toWeek;
			} else {
				var repo_SWeek = "repo_SWeek=";
				var repo_EWeek = "repo_EWeek=";
			}
			ComOpenWindow('/opuscntr/EES_EQR_0107.do?' + repo_SWeek + "&" + repo_EWeek, window,
					"scroll:no;status:no;help:no;dialogWidth:1000px;dialogHeight:600px",
					true);

			break;*/
		
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			// ComShowMessage(OBJECT_ERROR);
			ComShowCodeMessage("EQR90004");
		} else {
			ComShowMessage(e.message);
		}
	}
}


function setPopData_Point(rowArray,ret_val) {
	var formObj=document.form;
	var tempText="";
	//initializing
	for(var i=0; i<rowArray.length; i++) {
		var colArray=rowArray[i];
		tempText +=  rowArray[i] + ',';
	}
	//clearing comma(,)
	tempText=LseDelLastDelim(tempText);
	tempText=tempText.toUpperCase();
	document.form.middle_point_val.value= tempText ;
	
	var Row = sheetObjects[0].GetSelectRow(); // selected ROW
	if(Row != -1) {
		sheetObjects[0].SetCellValue(Row, "middle_point",tempText);
	}
	
}

/**
 * 반복문으로 생성된 라스트 Delim을 제거 ex) '1,2,3,4,5,' => '1,2,3,4,5'
 * 
 * @param {String}
 *            str 제거 대상 String
 * @return {String} str 제거된 String
 * @author 박영진
 * @version 2009.06.04
 */
function LseDelLastDelim(str) {
	// 마지막에 &를 없애기 위함
	if (str != "") {
		str=str.substr(0, str.length - 1);
	}
	return str;
	
}
/**
 * registering IBSheet Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}




/**
 * registering IBCombo Object as list adding process for list in case of needing
 * batch processing with other items defining list on the top of source
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}



/**
 * initializing sheet adding first-served functions after loading screen. flag :
 * tab info from EES_EQR_0051
 */
function loadPage(flag) {
	allTpszCnt = consTpsz.split(',').length; // amount TP/SZ=ALL
	for (i = 0; i < sheetObjects.length; i++) {
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1, comboObjects[2].GetSelectText());
		ComEndConfigSheet(sheetObjects[i]);
	}

	resizeSheet();

	if (flag == "" || flag == undefined) {
		flag = 0;
	}

	ComBtnDisable("btn_create");
    ComBtnDisable("btn_delete");
    
	if (flag != "search") {
		document.form.fromLocation.disabled = true;
		document.form.toLocation.disabled = true;
		document.form.tpsztype.disabled = true;		
		document.form.fromStatus.value = document.form.link_fromStatus.value;
		
		goSearchRepoid("Loading");
		// multi combo box setting
		for (p = 0; p < comboObjects.length; p++) {
			initCombo(comboObjects[p], p + 1);
		}
		tpszChange(''); // ALL 선택
		sheet1_OnLoadFinish(sheetObjects[0]);
	}
	// } , 100);
}


/**
 * setting sheet initial values and header param : sheetObj, sheetNo adding case
 * as numbers of counting sheets
 */
function initSheet(sheetObj, sheetNo, tpszValue) {
	var cnt = 0;
	// sheetObj.onlyTextTriggerForOnEdit = true; // for windows english ver.
	switch (sheetNo) {
	case 1: // sheet1 init
		with (sheetObj) {
			var strVolsec = "";
			var arrVolsec = "";
			strVolsec = form.volsec.value;
			if(strVolsec == "ALL") strVolsec = "";
			if(strVolsec == "") {
				strVolsec ="P,A,W,M"
			}
			arrVolsec = strVolsec.split(",");
			arrVolsecLen = arrVolsec.length;
			
			var HeadTitle0 = "Del|STS|Item|VVD|Lane|From Yard|ETD|To Yard|ETA|Purpose|S/O|BKG|DIV|MT BKG NO|Ref No.|Middle Point";
			var HeadTitle1 = "Del|STS|Item|VVD|Lane|From Yard|ETD|To Yard|ETA|Purpose|S/O|BKG|DIV|MT BKG NO|Ref No.|Middle Point";
			if ((tpszValue != '' && tpszValue != null))
				consTpszArr = tpszValue.split(',');
				//HeadTitle0 = HeadTitle0 + "|Total TEU";
				for(var k=0;k<arrVolsecLen;k++) {
					HeadTitle0 = HeadTitle0 + "|Total TEU";
				}
				
				//HeadTitle0 = HeadTitle0 + "|Total";
				for(var k=0;k<arrVolsecLen;k++) {
					HeadTitle0 = HeadTitle0 + "|Total";
				}
				//HeadTitle0 = HeadTitle0 + "|";
				
				
				
			//HeadTitle1 = HeadTitle1 + "Plan.";
				if(strVolsec.indexOf("P") > -1)   HeadTitle1 = HeadTitle1 + "|Plan.";
				if(strVolsec.indexOf("A") > -1)   HeadTitle1 = HeadTitle1 + "|Attach";
				if(strVolsec.indexOf("W") > -1)   HeadTitle1 = HeadTitle1 + "|W/O";
				if(strVolsec.indexOf("M") > -1)   HeadTitle1 = HeadTitle1 + "|MVMT";
			
			//HeadTitle1 = HeadTitle1 + "|Plan.";
				if(strVolsec.indexOf("P") > -1)   HeadTitle1 = HeadTitle1 + "|Plan.";
				if(strVolsec.indexOf("A") > -1)   HeadTitle1 = HeadTitle1 + "|Attach";
				if(strVolsec.indexOf("W") > -1)   HeadTitle1 = HeadTitle1 + "|W/O";
				if(strVolsec.indexOf("M") > -1)   HeadTitle1 = HeadTitle1 + "|MVMT";
			//HeadTitle1 = HeadTitle1 + "|";
			
			
			for (i = 0; i < consTpszArr.length; i++) {
				//HeadTitle0 = HeadTitle0 + ""+ consTpszArr[i];
				if(strVolsec.indexOf("P") > -1)   HeadTitle0 = HeadTitle0 + "|"+ consTpszArr[i];
				if(strVolsec.indexOf("A") > -1)   HeadTitle0 = HeadTitle0 + "|"+ consTpszArr[i];
				if(strVolsec.indexOf("W") > -1)   HeadTitle0 = HeadTitle0 + "|"+ consTpszArr[i];
				if(strVolsec.indexOf("M") > -1)   HeadTitle0 = HeadTitle0 + "|"+ consTpszArr[i];
				//HeadTitle0 = HeadTitle0 + "|";
				
				//HeadTitle1 = HeadTitle1 + "Plan.";			
				if(strVolsec.indexOf("P") > -1)   HeadTitle1 = HeadTitle1 + "|Plan.";
				if(strVolsec.indexOf("A") > -1)   HeadTitle1 = HeadTitle1 + "|Attach";
				if(strVolsec.indexOf("W") > -1)   HeadTitle1 = HeadTitle1 + "|W/O";
				if(strVolsec.indexOf("M") > -1)   HeadTitle1 = HeadTitle1 + "|MVMT";
				//HeadTitle1 = HeadTitle1 + "|";
			}

			HeadTitle0 = HeadTitle0 + "|Update OFC|Update User|Update Date|";
			HeadTitle1 = HeadTitle1 + "|Update OFC|Update User|Update Date|";

			SetConfig({
				SearchMode : 2,
				MergeSheet : 5,
				Page : 20,
				FrozenCol : 2,
				DataRowMerge : 1
			});

			var info = {
				Sort : 0,
				ColMove : 1,
				HeaderCheck : 0,
				ColResize : 1
			};
			var headers = [ {
				Text : HeadTitle0,
				Align : "Center"
			}, {
				Text : HeadTitle1,
				Align : "Center"
			} ];
			InitHeaders(headers, info);

			var cols = [ {
				Type : "DelCheck",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "check"
			}, {
				Type : "Status",
				Hidden : 0,
				Width : 30,
				Align : "Center",
				ColMerge : 1,
				SaveName : "ibflag"
			}, {
				Type : "Combo",
				Hidden : 0,
				Width : 80,
				Align : "Left",
				ColMerge : 1,
				SaveName : "trsp_mod_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			}, {
				Type : "PopupEdit",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 1,
				SaveName : "vvd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 1,
				EditLen : 9
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 60,
				Align : "Center",
				ColMerge : 1,
				SaveName : "vsl_lane_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 3
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "fm_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 7,
				ShowCol : 0
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "fm_etd_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 90,
				Align : "Center",
				ColMerge : 0,
				SaveName : "to_yd_cd",
				KeyField : 1,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 7 
			}, {
				Type : "Date",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 0,
				SaveName : "to_eta_dt",
				KeyField : 1,
				CalcLogic : "",
				Format : "Ymd",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			}, {
				Type : "Combo",
				Hidden : 1,
				Width : 90,
				Align : "Left",
				ColMerge : 1,
				SaveName : "eq_repo_purp_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "so_iss_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 40,
				Align : "Center",
				ColMerge : 1,
				SaveName : "repo_mty_bkg_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 0,
				EditLen : 1
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 1,
				SaveName : "div",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Left",
				ColMerge : 1,
				SaveName : "mt_bkg_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "ref_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 15
			}, {
				Type : "Text",
				Hidden : 0,
				Width : 110,
				Align : "Left",
				ColMerge : 1,
				SaveName : "middle_point",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0,
				EditLen : 200
			}];
			if(strVolsec.indexOf("P") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 60,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_teu_vol",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
			
			if(strVolsec.indexOf("A") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 50,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_teu_attach",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
			
			if(strVolsec.indexOf("W") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 40,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_teu_workorder",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
			
			if(strVolsec.indexOf("M") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 50,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_teu_mvmt",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
			
			if(strVolsec.indexOf("P") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 40,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_vol",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
		
		
			if(strVolsec.indexOf("A") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 50,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_attach",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
		
			if(strVolsec.indexOf("W") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 40,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_workorder",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				});
			}
			
			if(strVolsec.indexOf("M") > -1) {
				cols.push({
					Type : "Int",
					Hidden : 0,
					Width : 50,
					Align : "Right",
					ColMerge : 1,
					SaveName : "total_mvmt",
					KeyField : 0,
					CalcLogic : "",
					Format : "Integer",
					PointCount : 0,
					UpdateEdit : 0,
					InsertEdit : 0,
					EditLen : 11
				} );
			}
		
		
			for ( var i = 0; i < consTpszArr.length; i++) {
				if(strVolsec.indexOf("P") > -1) {
					cols.push({
						Type : "Int",
						Hidden : 0,
						Width : 40,
						Align : "Right",
						ColMerge : 0,
						SaveName : "vol" + consTpszArr[i],
						KeyField : 0,
						CalcLogic : "",
						Format : "Integer",
						PointCount : 0,
						UpdateEdit : 1,
						InsertEdit : 1,
						EditLen : 6
					});
				}
				
				if(strVolsec.indexOf("A") > -1) {
					cols.push({
						Type : "Int",
						Hidden : 0,
						Width : 50,
						Align : "Right",
						ColMerge : 0,
						SaveName : "attach" + consTpszArr[i],
						KeyField : 0,
						CalcLogic : "",
						Format : "Integer",
						PointCount : 0,
						UpdateEdit : 0,
						InsertEdit : 0,
						EditLen : 6
					});
				}
				
				if(strVolsec.indexOf("W") > -1) {
					cols.push({
						Type : "Int",
						Hidden : 0,
						Width : 40,
						Align : "Right",
						ColMerge : 0,
						SaveName : "workorder" + consTpszArr[i],
						KeyField : 0,
						CalcLogic : "",
						Format : "Integer",
						PointCount : 0,
						UpdateEdit : 0,
						InsertEdit : 0,
						EditLen : 6
					});
				}
				
				if(strVolsec.indexOf("M") > -1) {
					cols.push({
						Type : "Int",
						Hidden : 0,
						Width : 50,
						Align : "Right",
						ColMerge : 0,
						SaveName : "mvmt" + consTpszArr[i],
						KeyField : 0,
						CalcLogic : "",
						Format : "Integer",
						PointCount : 0,
						UpdateEdit : 0,
						InsertEdit : 0,
						EditLen : 6
					});
				}
			}
			
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "ofc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 100,
				Align : "Center",
				ColMerge : 0,
				SaveName : "upd_usr_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 0,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "upd_dt",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "pln_yrwk",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "repo_pln_id",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 120,
				Align : "Center",
				ColMerge : 0,
				SaveName : "sortnum",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			
			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "week_fromdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "week_todate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 10
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "week_maxdate",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			
			
			
			
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "vsl_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "skd_dir_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "skd_voy_no",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "co_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "all_loc_cd",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "past_repo_pln_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "split_repo_pln_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 0,
				InsertEdit : 0
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "fm_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "to_rcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "fm_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "to_lcc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "fm_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "to_ecc",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "tpszno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "pln_seq",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "fm_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "to_chk_flg",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "repobkg_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "trspno_p",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "trspno_d",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "trspno_a",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "so_cancel_flag",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1,
				EditLen : 4
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "cntrno",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			cols.push({
				Type : "Text",
				Hidden : 1,
				Width : 40,
				Align : "Left",
				ColMerge : 0,
				SaveName : "cntrdel",
				KeyField : 0,
				CalcLogic : "",
				Format : "",
				PointCount : 0,
				UpdateEdit : 1,
				InsertEdit : 1
			});
			
			for ( var i = 5; i < 47; i++) {
				//GetCellBackColor(1, i, "#555555");// = GetCellBackColor(1,4);
			}

			InitColumns(cols);

			SetEditable(1);
			SetCellBackColor(1, 4, "#555555");
			SetCellBackColor(1, i, GetCellBackColor(1, 4));
			SetHeaderRowHeight(10);
			SetShowButtonImage(3);// in case of editable, showin combo &
									// pop-up image
			// SetSheetHeight(ComGetSheetHeight(sheetObj, 14));
			// ComResizeSheet(sheetObj);
			SetColProperty("co_cd", {
				ComboText : companyText,
				ComboCode : companyCode
			});
			
			/*SetColProperty("exec_type", {
				ComboText : exectypeText,
				ComboCode : exectypeCode
			});*/
			
			SetColProperty("eq_repo_purp_cd", {
				ComboText : purposeText,
				ComboCode : purposeCode
			});
			
			SetColProperty("trsp_mod_cd", {
				ComboText : item_shuttleText,
				ComboCode : item_shuttleCode
			});
			
			SetColProperty("fm_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			
			SetColProperty("to_yd_cd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			
			SetColProperty("vvd", {
				AcceptKeys : "E|N",
				InputCaseSensitive : 1
			});
			//SetRangeBackColor(1, 2, 1, 36, "#777777");
		}
		break;
	}
}



function resizeSheet() {
	for ( var x = 0; x < sheetObjects.length; x++)
		ComResizeSheet(sheetObjects[x]);
}


/**
 * initializing Tab setting Tab items
 */
function initCombo(comboObj, comboNo) {
	var cnt = 0;
	switch (comboNo) {
	case 1:
		with (comboObj) {
			SetDropHeight(150);
			SetMultiSelect(0);
		}
		break;
	case 2:
		with (comboObj) {
			SetDropHeight(150);
			SetMultiSelect(0);
		}
		break;
	// Type Size
	case 3:
		with (comboObj) {
			SetDropHeight(12 * 20);
			var menuname = tpszallText.split('|');
			var menucode = tpszallCode.split('|');
			SetMultiSelect(1);
			SetUseAutoComplete(1);
			SetMaxSelect(menuname.length);
			Multiseparator = ",";
			for (i = 0; i < menuname.length; i++) {
				InsertItem(cnt++, menuname[i], menucode[i]);
			}
		}
		break;
		
	case 4:
		with (comboObj) {
			SetDropHeight(150);
			SetMultiSelect(1);
			SetMaxSelect(4);
		}
		break;
	}
}



/**
 * 
 * @param sheetObj
 * @param formObj
 * @param sAction
 * @returns {Boolean}
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSEARCH: // retrieve
		if (validateForm(sheetObj, formObj, sAction)) {
			document.form.dataselect3.value = "";
			ComOpenWait(true);
			sheetObj.SetWaitImageVisible(1);
			setTimeout(function() {
				sheet1.SetWaitTimeOut(300);// retrieve
				sheet1.SetVisible(0);
				sheet1.RemoveAll();
				sheet1 = sheet1.Reset();// keyfied
				sheetObjects[0] = sheet1;
				ComConfigSheet(sheet1);
				initSheet(sheet1, 1, comboObjects[2].GetSelectText());
				ComEndConfigSheet(sheet1);
				//sheet1.SetWaitImageVisible(1);
				formObj.f_cmd.value = SEARCHLIST04;				
				var sXml = sheet1.GetSearchData("EES_EQR_0080GS2.do",eqrFormQryStr(formObj));
				sheet1.LoadSearchData(sXml, {
					Sync : 1
				});
			}, 100);
			sheetObj.SetWaitImageVisible(0);
			ComOpenWait(false);
		}
		break;
	case IBSEARCH02:
		formObj.f_cmd.value=SEARCH01;
		var intgCdId='CD30128';
		var param="&intgCdId="+intgCdId;
		var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
		var chk=xml.indexOf("ERROR");
		if (xml.indexOf("ERROR") != -1 || xml.indexOf("Error") != -1){
		   sheetObj.LoadSearchData(xml,{Sync:1} );
		   return;
	    } 
		if (xml != "") {
			var sCntrMtrlCdNm=ComGetEtcData(xml, "code_nm");
			var arrStr=sCntrMtrlCdNm.split("@");
			comboObjects[3].RemoveAll();
			
			comboObjects[3].InsertItem(0, "ALL" , "ALL");
			for (var i=0; i<arrStr.length; i++) {
				var arrCode=arrStr[i].split("|");
				comboObjects[3].InsertItem(i+1, arrCode[1] , arrCode[0]);
				
			}
			comboObjects[3].SetSelectIndex("1" ,true);
		}
		break;
	case IBSEARCH03:   		
		formObj.f_cmd.value=SEARCH21;
        var sXml=sheetObjects[0].GetSearchData("EES_REPO_COMMONGS.do" , FormQueryString(formObj)); 
        
		var comboItem;
		var comboItems;
		comboDatas=ComGetEtcData(sXml, "all_conti_cd");
        if (comboDatas != undefined) {
            comboItems=comboDatas.split("|");
            comboObjects[0].SetSelectCode("-1");
            comboObjects[0].RemoveAll();
            addComboItem(comboObjects[0],comboItems); //
            
            
            comboObjects[1].SetSelectCode("-1");
            comboObjects[1].RemoveAll();
            addComboItem(comboObjects[1],comboItems); //
        }
		break;
	case IBSAVE: // saving
		if (validateForm(sheetObj, formObj, sAction)) {
			var sRow = sheetObj.FindStatusRow("I|U|D");
			var arRow = sRow.split(";");
			var flag = true;

			var sIURow = sheetObj.FindStatusRow("I|U");
			if (sIURow != "" && sIURow != null) {
				//중복체크 VVD, Yard
				var lastNum = 0;
				for ( var i = 2; i < sheetObj.RowCount(); i++) {
					if(sheetObj.GetCellValue(i, "fm_yd_cd") == "" && sheetObj.GetRowStatus(i) !="D") {
						lastNum = lastNum+1;
					}
				}
				
				var chkDup = sheetObj.ColValueDupRows("vvd|fm_yd_cd|to_yd_cd",1,0,1,sheetObj.RowCount()-lastNum);
				var strRepoPlnId = formObj.yyyyww.value + "_" +
									formObj.exectype.value  + "_" +
									comboObjects[0].GetSelectText()+"_" +
									comboObjects[1].GetSelectText()+"_" + formObj.seq.value;
				
				if(chkDup > 0) {
					ComShowCodeMessage("EQR01153", strRepoPlnId);
					return false;
				}
			}
			
			
			if (flag) {
				var formObj = document.form; 
				
	        	var f_cmd = SEARCHLIST03;
	        	var saveStr = sheetObj.GetSaveString();
				if (saveStr == "")
					return;
				
	        	var sXml= sheetObj.GetSearchData("EES_EQR_0080GS.do",saveStr+"&f_cmd=" + f_cmd);
	        	var strDataYN=ComGetEtcData(sXml, "dataYN");
	        	if(strDataYN != "") {
	        		ComShowCodeMessage("EQR01153", strDataYN);
	        		return false;
	        	}
	        	
	        	
				formObj.f_cmd.value = MULTI04;
				var saveStr = sheetObj.GetSaveString();
				if (saveStr == "")
					return;
				var sXml = sheetObj.GetSaveData("EES_EQR_0080GS1.do",saveStr, eqrFormQryStr(formObj));
				sheetObj.LoadSaveData(sXml, {Sync : 1});
				//save end ==> sheet1_ChangeXml
				//sheet1_ChangeXml(sXml);
			}

			/*if (formObj.pre_repo_rmk.value != formObj.repo_rmk.value) {
				ComShowConfirm(ComGetMsg("EQR90236"));
				formObj.f_cmd.value = MULTI03;
				ComOpenWait(true);
				var sXml = sheetObj.GetSaveData("EES_EQR_0012GS.do",eqrFormQryStr(formObj));
				ComOpenWait(false);
				sheetObj.LoadSaveData(sXml, {
					Sync : 1
				});
				formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
				ComEtcDataToForm(document.form, sheetObj);
			}*/
		}
		break;
	case IBINSERT:
		//Execution Add
		var yyyyww = formObj.yyyyww.value;
		var seq = formObj.seq.value;
		if (formObj.dtrb_flg.value == 'Y' && yyyyww.length == 6 && seq.length == 2) {
			var selRow = sheetObj.GetSelectRow(); // selected ROW
			
			if (consTpszArr.length < allTpszCnt) {
				ComShowCodeMessage("EQR90045", "Row Add", "ALL");
				//schAllTysz = "Y";
				//comboObjects[2].SetSelectCode(-1);
				//comboObjects[2].SetSelectCode(consTpsz);
				//checkSearch();
				//doActionIBSheet(sheetObj, formObj, IBSEARCH);
				return false;
			}
			
			var strVolsec = formObj.volsec.value;
			/*if(strVolsec != "ALL") {
				ComShowCodeMessage("EQR01155");
				return false;
			}*/
			
			var Row = sheetObj.DataInsert();
			
			sheetObj.SetCellValue(Row, 'pln_yrwk', yyyyww, 0);
			sheetObj.SetCellEditable(Row, "pln_yrwk", 0);
			
			sheetObj.SetCellValue(Row, 'div', "EXECUTION", 0);// REPO
			
			var strRepoPlnId = formObj.yyyyww.value + "_" +
								formObj.exectype.value  + "_" +
								comboObjects[0].GetSelectText()+"_" +
								comboObjects[1].GetSelectText()+"_" + formObj.seq.value;
			
			sheetObj.SetCellValue(Row, 'repo_pln_id', strRepoPlnId, 0);
			
			sheetObj.SetCellValue(Row, "split_repo_pln_flg", "", 0);// Execution Rowsetting
			sheetObj.SetCellValue(Row, "sortnum", "1", 0);// Execution Rowsetting
			sheetObj.SetCellValue(Row, "num", "1", 0);// normal  rowsetting
			
			sheetObj.SetColProperty(Row, "vvd", {KeyField : 0});
			
			sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Combo"});
	      
	    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Combo"});
	    	
	    	
			var strExectype = formObj.exectype.value;
			if(strExectype == "TV") {
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"W", ComboText: "Water"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","W",0);
			}else if(strExectype == "FS"){
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"W|T|R", ComboText: "Water|Truck|Rail"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","W",0);
			}else if(strExectype == "FW"){
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"W|T|R", ComboText: "Water|Truck|Rail"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","W",0);
			}else if(strExectype == "ON"){
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"W|T|R", ComboText: "Water|Truck|Rail"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","W",0);
			}else if(strExectype == "OF"){
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"W|T|R", ComboText: "Water|Truck|Rail"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","W",0);
			}else if(strExectype == "TR"){
				sheetObj.InitCellProperty(Row, "trsp_mod_cd", {Type : "Combo", ComboCode:"T|R", ComboText: "Truck|Rail"});
				sheetObj.SetCellValue(Row, "trsp_mod_cd","T",0);
				
				sheetObj.SetColProperty(Row, "vvd", {KeyField : 0});
				
				sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
		      
		    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
			}
			sheetObj.SetCellEditable(Row,"vvd",1);
			
			// insert row
			document.form.position_row4.value = Row;
			var f_cmd = SEARCHLIST17;
			sheetObj.DoRowSearch2("EES_WEEKDATEPERIOD.do", "row="
																+ Row
																+ "&searchword="
																+ yyyyww
																+ "&colname1=week_fromdate&colname2=week_todate&f_cmd="
																+ f_cmd);
			sheetObj.DoRowSearch2("EES_WEEKDATEPERIOD.do","row="
																+ Row
																+ "&searchword="
																+ yyyyww
																+ "&colname1=week_fromdate&colname2=week_maxdate&division=WIDE&f_cmd="
																+ f_cmd);	
			sheetObj.SetCellValue(Row, "fm_etd_dt", sheetObj.GetCellValue(Row, "week_fromdate"), 0);
			sheetObj.SetCellValue(Row, "to_eta_dt", sheetObj.GetCellValue(Row, "week_todate"), 0);
			
			sheetObj.InitCellProperty(Row, "so_iss_flg",{Type : "Text"});
			sheetObj.InitCellProperty(Row, "repo_mty_bkg_flg",{Type : "Text"});
			sheetObj.SetCellValue(Row, "so_iss_flg", "", 0);
			sheetObj.SetCellValue(Row, "repo_mty_bkg_flg", "", 0);
			sheetObj.SetCellEditable(Row,"trsp_mod_cd",1);
			
			sheetObj.SetCellValue(Row, "ibflag", "I", 0);

		} else {
			//ComShowCodeMessage("EQR90124");
		}
		break;
	case IBDOWNEXCEL:
		sheetObj.Down2Excel({
			DownCols : makeHiddenSkipCol(sheetObj),
			SheetDesign : 1,
			Merge : 1
		});
		break;
		
	case IBSEARCH_ASYNC03: 
		//상단 Create 버튼 클릭시
		sheetObj.SetWaitImageVisible(0);
		formObj.f_cmd.value = MULTI05;
		formObj.pre_repo_rmk.value = formObj.repo_rmk.value;
		var param = "";
		param = "fm_conti_cd=" + comboObjects[0].GetSelectText()+"&to_conti_cd=" + comboObjects[1].GetSelectText();
		
		sheetObj.DoSearch("EES_EQR_0012GS6.do", param +"&"+ eqrFormQryStr(formObj));
		goSearchRepoid();
		break;
		
	case IBDELETE:
		//상단 Delete 버튼 클릭시
 	   	if(ComShowConfirm(ComGetMsg("EQR90193"))) {
 		   if(!validateForm(sheetObj,formObj,sAction)){
              return false;
           }
 		   
     	   formObj.f_cmd.value=MULTI08;
     	   var sXml= sheetObj.GetSaveData("EES_EQR_0080GS1.do", FormQueryString(formObj));
     	   var strDelYn=ComGetEtcData(sXml, "delYN");
            if (strDelYn == "Y" || strDelYn == "E") {
         	   if(strDelYn == "E") {
        		   ComShowCodeMessage("EQR01150");
        	   }
         	   formObj.yyyyww.value = "";
         	   formObj.seq.value = "";
         	   formObj.repo_rmk.value = "";
         	  	              
			// FM/TO LOC
				//document.all.fmToLayer.style.display = "inline";
				//document.all.atLayer.style.display = "none";

				ComBtnDisable("btn_create");
	            ComBtnDisable("btn_delete");
	            
	            formObj.reset();
	            for (p = 0; p < comboObjects.length; p++) {
					//initCombo(comboObjects[p], p + 1);
				}
	            
				tpszChange(''); // ALL 선택
				// Retieving Repo.PlanID
				// goSearchRepoid();
				formObj.yyyyww.value = "";
				formObj.seq.value = "";
				formObj.repo_rmk.value = "";
				// tpsz initializing
				
				//comboObjects[1].SetSelectCode(consTpsz);
				comboObjects[2].SetSelectCode(consTpsz);
				comboObjects[3].SetSelectCode("ALL");
				// Item initializing
				//comboObjects[0].RemoveAll();
				//initCombo(comboObjects[2], 3);
				sheet1.RemoveAll();
				
				ComShowCodeMessage("EQR01151");
       	   }else{
        	   ComShowCodeMessage("EQR01150");
          	   doActionIBSheet(sheetObj,formObj,IBSEARCH);
          	   ComBtnDisable("btn_create");
			   ComBtnDisable("btn_delete");
           }
 	   }
 	   break;
	case IBSEARCH_ASYNC04:
		sheetObjects[0].SetWaitImageVisible(2);
        ComOpenWait(true);
        
    	formObj.f_cmd.value=SEARCH22;
        var sXml=sheetObjects[0].GetSearchData("EES_REPO_COMMONGS.do" , FormQueryString(formObj)); 
        var strDataYN		=	ComGetEtcData(sXml, "DataYN");
        //Search01
        var strScnrId01		=	"";
        var strRepoRmk01	=	"";
        var strType01			=	"";
        var strRepoPlnId01	=	"";
        var strDtrbFlg01		=	"";
        var strReplPlnYn01	=	"";     
        //Search02
        var strStYear02		=	"";
        var strStWeekly02	=	"";
        var strStMonth02		=	"";
        var strEndYear02		=	"";
        var strEndWeekly02	=	"";
        var strEndMonth02		=	"";      
        //Search03
        var strPerFixMonth03	=	"";
        var strTitleMonth03		=	"";    
        //Search04
        var strPerFixWeekly04	=	"";
        var strTitleWeekly04		=	"";
        var strPerFixMonthly04	=	"";    
        //Search05
        var strMonthlyCount05	=	"";  
        //Search06
        var strMaxPlyYr06	=	"";
        var strMaxWeekly06	=	"";
        var strMaxPlnMon06	=	"";     
        //Search07
        var strFromToPlnId07	=	"";                        
        //Search08
        var strScnrIdList08		=	"";
        var strReplPlnIdList08	=	"";    
        //Search09
        var strTodayWeekly09	=	"";  
        //Searhc10
        var strExePlnEditFlg10	=	"";                    
        //Search11
        var strMaxWkStr11		= "";                    
        //Search12
        var strRepoPlnNextWeek12	=	"";                    
        //Search13
        var strExePlnEditFlgSplit13	=	"";	                    
        var max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
        
        if(strDataYN == "Y") {
            //Search01
            strScnrId01		=	ComGetEtcData(sXml, "scnr_id");
            strRepoRmk01	=	ComGetEtcData(sXml, "repo_rmk");
            strType01			=	ComGetEtcData(sXml, "type");
            strRepoPlnId01	=	ComGetEtcData(sXml, "repo_pln_id");
            strDtrbFlg01		=	ComGetEtcData(sXml, "dtrb_flg");
            strReplPlnYn01	=	ComGetEtcData(sXml, "replPlnYn");     
            //Search02
            strStYear02		=	ComGetEtcData(sXml, "st_year");
            strStWeekly02	=	ComGetEtcData(sXml, "st_weekly");
            strStMonth02		=	ComGetEtcData(sXml, "st_month");
            strEndYear02		=	ComGetEtcData(sXml, "end_year");
            strEndWeekly02	=	ComGetEtcData(sXml, "end_weekly");
            strEndMonth02		=	ComGetEtcData(sXml, "end_month");      
            //Search03
            strPerFixMonth03	=	ComGetEtcData(sXml, "perfix_month");
            strTitleMonth03		=	ComGetEtcData(sXml, "title_month");    
            //Search04
            strPerFixWeekly04	=	ComGetEtcData(sXml, "perfix_weekly");
            strTitleWeekly04		=	ComGetEtcData(sXml, "title_weekly");
            strPerFixMonthly04	=	ComGetEtcData(sXml, "perfix_monthly");    
            //Search05
            strMonthlyCount05	=	ComGetEtcData(sXml, "monthly_count");  
            //Search06
            strMaxPlyYr06	=	ComGetEtcData(sXml, "max_plnYr");
            strMaxWeekly06	=	ComGetEtcData(sXml, "max_weekly");
            strMaxPlnMon06	=	ComGetEtcData(sXml, "max_plnMon");     
            //Search07
            strFromToPlnId07	=	ComGetEtcData(sXml, "fromToPlnId");                        
            //Search08
            strScnrIdList08		=	ComGetEtcData(sXml, "scnrIdList");
            strReplPlnIdList08	=	ComGetEtcData(sXml, "repoPlnIdList");    
            //Search09
            strTodayWeekly09	=	ComGetEtcData(sXml, "todayWeekly");  
            //Searhc10
            strExePlnEditFlg10	=	ComGetEtcData(sXml, "exePlnEditFlg");                    
            //Search11
            strMaxWkStr11		=ComGetEtcData(sXml, "maxWkStr");                    
            //Search12
            strRepoPlnNextWeek12	=	ComGetEtcData(sXml, "repoPlnNextWeek");                    
            //Search13
            strExePlnEditFlgSplit13	=	ComGetEtcData(sXml, "exePlnEditFlg_split");	                    
            max_plnYrWk = strMaxPlyYr06 + strMaxWeekly06; 
        }
        
    	formObj.scnr_id.value = strScnrId01;
		formObj.repo_rmk.value = strRepoRmk01;				//Repo Plan Rmk
		//formObj.repo_rmk.title = strRepoRmk01;
		formObj.st_year.value = strStYear02;				//hidden
		formObj.st_month.value = strStMonth02;				//hidden
		formObj.st_weekly.value = strStWeekly02;			//hidden
		formObj.end_year.value =	strEndYear02;			//hidden
		formObj.end_month.value = strEndMonth02;			//hidden
		formObj.end_weekly.value = strEndWeekly02;			//hidden
		formObj.perfix_month.value = strPerFixMonth03;		//hidden
		formObj.title_month.value = strTitleMonth03;		//hidden
		formObj.perfix_weekly.value =strPerFixWeekly04;		//hidden
		formObj.title_weekly.value = strTitleWeekly04;		//hidden
		formObj.monthly_count.value = strMonthlyCount05;	//hidden
		formObj.status_type.value = strType01;				//hidden
		formObj.dtrb_flg.value = strDtrbFlg01;				//hidden
		formObj.max_weekly.value = strMaxWeekly06;			//hidden
		formObj.fromToPlnId.value = strFromToPlnId07;		//hidden
		formObj.max_plnYrWk.value = max_plnYrWk;			//hidden
		if(formObj.scnrIdList != null )  	formObj.scnrIdList.value 	= strScnrIdList08;
		if(formObj.repoPlnIdList != null ) formObj.repoPlnIdList.value= strReplPlnIdList08;
		if(formObj.max_plnYr != null )  	formObj.max_plnYr.value 	= strMaxPlyYr06;
		if(formObj.max_plnMon != null )  	formObj.max_plnMon.value 	= strMaxPlnMon06;
		if(formObj.todayWeekly != null )  	formObj.todayWeekly.value 	= strTodayWeekly09;
		if(formObj.exePlnEditFlg != null ) formObj.exePlnEditFlg.value= strExePlnEditFlg10;
		if(formObj.exePlnEditFlg_split != null ) formObj.exePlnEditFlg_split.value= strExePlnEditFlgSplit13;
		if(formObj.repoPlnNextWeek != null ) formObj.repoPlnNextWeek.value = strRepoPlnNextWeek12;
		if(strReplPlnYn01 == "Y") {
			ComBtnDisable("btn_create");
			ComBtnDisable("btn_delete");
		}else{				
			ComBtnDisable("btn_create");
			ComBtnEnable("btn_delete");
		}
		formObj.maxWkStr.value = strMaxWkStr11;  
		ibSearchAsync03();
		sheetObjects[0].RemoveAll();
		setEccCommon();
		ComOpenWait(false);
    	break;
	case IBSEARCH_ASYNC05:   		
		formObj.f_cmd.value=SEARCHLIST05;
        var sXml=sheetObjects[0].GetSearchData("EES_EQR_0080GS2.do" , FormQueryString(formObj)); 
        
		var comboItem;
		var comboItems;
		comboDatas=ComGetEtcData(sXml, "repo_type_size");
		var selconsTpsz =  ComReplaceStr(comboDatas,"|",",");
		
        if (comboDatas != undefined && comboDatas != "") {
            comboObjects[2].SetSelectCode(-1);            
    		comboObjects[2].SetSelectCode(selconsTpsz);
        }
		break;
	}
}



function sheet1_OnDblClick(sheetObj, Row, Col) {
	var colName = sheetObj.ColSaveName(Col);
	var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
	if ((colName == "fm_yd_cd" || colName == "to_yd_cd")
			&& sheetObj.GetCellEditable(Row, colName) && idx != -1) {
		sheetObj.GetCellValue = "";
	}
}



function sheet1_OnChange(sheetObj, Row, Col, Val) {
	var colName = sheetObj.ColSaveName(Col);
	var formObj = document.form;
	if(colName == "trsp_mod_cd") {
		var strTrspModCd = sheetObj.GetCellValue(Row, "trsp_mod_cd");
		var strExecType = sheetObj.GetCellValue(Row, "exec_type");
		
		if(strTrspModCd == "W") {
			sheetObj.SetCellValue(Row, "vvd", "", 0);
			sheetObj.SetCellEditable(Row, "vvd", 1);
			sheetObj.SetColProperty(Row, "vvd", {KeyField : 1});
				
			sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Combo"});
	      
	    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Combo"});
		}else{
			sheetObj.SetCellValue(Row, "vvd", "", 0);
			sheetObj.SetCellEditable(Row, "vvd", 0);
			sheetObj.SetColProperty(Row, "vvd", {KeyField : 0});
			
			sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
	      
	    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
	    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
		}
	}
	
	//W인경우 Multi Combo 
	//VVD 입력시
    if (sheetObj.ColSaveName(Col) == "vvd"){
    	if(sheetObj.GetCellValue(Row,"trsp_mod_cd") == "") {
    		sheetObj.SetCellValue(Row,"vvd","",0);
    		return false;
    	}
    	
    	if(sheetObj.GetCellValue(Row,"trsp_mod_cd") != "W") {
    		
    	}else{
	    	var seachword=sheetObj.GetCellValue(Row,"vvd");
	    	var repo_id = formObj.yyyyww.value + "_" +
						formObj.exectype.value  + "_" +
						comboObjects[0].GetSelectText()+"_" +
						comboObjects[1].GetSelectText()+"_" + formObj.seq.value;
	    	
	    	var vsl_cd=seachword.substring(0,4);
	    	var skd_voy_no=seachword.substring(4,seachword.length -1);
	    	var skd_dir_cd=seachword.substring(seachword.length -1, seachword.length);

	    	sheetObj.SetCellEditable(Row,"vsl_lane_cd",0);
	    	sheetObj.SetCellValue(Row,"vsl_lane_cd","",0);    
	    	
	    	// hidden Column에 데이터를 셋팅 한다.     
	    	sheetObj.SetCellValue(Row,"vsl_cd",vsl_cd,0);
	    	sheetObj.SetCellValue(Row,"skd_dir_cd",skd_dir_cd,0);
	    	sheetObj.SetCellValue(Row,"skd_voy_no",skd_voy_no,0);
	    	sheetObj.SetCellValue(Row,"repo_pln_id",repo_id,0);
	    	
	    	click_vvd=seachword;
	
	    	var vsl_lane_cd=sheetObj.GetCellValue(Row,"vsl_lane_cd",0);
	    	var colname   = "vsl_lane_cd";
	    	var pln_yrwk=sheetObj.GetCellValue(Row,"pln_yrwk");
	    	
	    	
	    	// VVD입력 시 해당 Lane 데이터를 입력해준다.
	    	var f_cmd = SEARCHLIST07;
	    	var sXml = sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname + "&f_cmd=" + f_cmd);
	    	changeViewText(sheetObj, sXml, colname);
	    	if(sheetObj.GetCellValue(Row, "vsl_lane_cd") == "") {
	    		sheetObj.SetCellValue(Row,"vvd","",0); 
	    	}
	    	
	    	
	    	var f_cmd = SEARCHLIST08;
	        var sXml=sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname + "&f_cmd=" + f_cmd);
	        var all_loc_cd = ComGetEtcData(sXml, "all_loc_cd");
	        
	        sheetObj.SetCellValue(Row, "all_loc_cd", all_loc_cd , 0);
	        
	    	// ------ FM LOC YARD retreive [START] -----------
			var f_cmd = SEARCH01;
			var vsl = vsl_cd;
			var from_ecc = sheetObj.GetCellValue(Row, "all_loc_cd");
			sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
					"row=" + Row + "&colname=fm_yd_cd&vsl=" + vsl
							+ "&ecc=" + from_ecc + "&item=V&f_cmd="
							+ f_cmd);

			// ------ FM LOC YARD retreive [END] -----------
			
			
			// ------ TO LOC YARD retreive [START] -----------
			// SEARCH01 ==> SEARCH17 Change
			var f_cmd = SEARCH17;
			var vsl = vsl_cd;
			var to_ecc = sheetObj.GetCellValue(Row, "all_loc_cd");
			
			sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
					"row=" + Row + "&colname=to_yd_cd&vsl=" + vsl
							+ "&ecc=" + to_ecc + "&item=V&f_cmd="
							+ f_cmd);
			
    	}
    }
    
    //Water가 아닌경우 Yard는 input 으로 입력되어진다.
    if(sheetObj.GetCellValue(Row,"trsp_mod_cd") != "W") {
		if (colName == "fm_yd_cd" || colName == "to_yd_cd") {
			var strexectype = sheetObj.GetCellValue(Row, "exec_type");
			var strtrspmodcd = sheetObj.GetCellValue(Row, "trsp_mod_cd");
			
			var searchfmword = sheetObj.GetCellValue(Row, "fm_yd_cd");
			var searchtoword = sheetObj.GetCellValue(Row, "to_yd_cd");
			
			var searchword = sheetObj.GetCellValue(Row, colName);
			searchword = searchword.toUpperCase();
			var idx = sheetObj.GetComboInfo(Row, Col, "SelectedIndex");
			
			
			var basic_ecc = "";
			if (colName == "fm_yd_cd") {
				//basic_ecc = sheetObj.GetCellValue(Row, "fm_ecc");
			}else if(colName == "to_yd_cd"){
				//basic_ecc = sheetObj.GetCellValue(Row, "to_ecc");
			}
			
			if (searchword.length == 7) {
				//var f_cmd = SEARCH20;
				var f_cmd = SEARCH16;
				sheetObj.InitCellProperty(Row, colName, {Type : "Text",AcceptKeys : "E|N",InputCaseSensitive : 1});				
				var sXml = sheetObj.GetSearchData("EES_LOCYARDLCC_COMMON.do",
						"row=" + Row + "&locfmyard=" + searchfmword
								+ "&loctoyard=" + searchtoword + "&locyard="
								+ searchword + "&colname=" + colName + "&f_cmd=" + f_cmd);
				var strYardYn = ComGetEtcData(sXml, "strYardYn");
				if (strYardYn == "") {
					ComShowCodeMessage("EQR70014", searchword);
					sheetObj.SetCellValue(Row, colName, "", 0);
				} else if (strYardYn == "Y") {
				} else if (strYardYn == "N") {
					ComShowCodeMessage("EQR70015", searchword);
					sheetObj.SetCellValue(Row, colName, "", 0);
				}
			} else{
				ComShowCodeMessage("EQR70014", searchword);
				sheetObj.SetCellValue(Row, colName, "", 0);
			}
		}
    }
	
	
	if (sheetObj.ColSaveName(Col) == "fm_etd_dt" && sheetObj.GetCellValue(Row, "fm_etd_dt") != "") { // ETD modifying
		var etd = sheetObj.GetCellValue(Row, "fm_etd_dt");
		var frdate = sheetObj.GetCellValue(Row, "week_fromdate");
		var todate = sheetObj.GetCellValue(Row, "week_todate");
		if (sheetObj.GetCellValue(Row, "pln_yrwk").length == 6) {
			if (etd < frdate || etd > todate) {
				ComShowCodeMessage("EQR90141", "ETD", frdate, todate);
				sheetObj.SetCellValue(Row, "fm_etd_dt", "", 0);
				return false;
			}
		} else {
			ComShowCodeMessage("EQR90001", "Week "); // please input week information
			sheetObj.SetCellValue(Row, "fm_etd_dt", "", 0);
			sheetObj.SelectCell(Row, "pln_yrwk");
			return false;
		}
	}
	
	// ---------- ETA modifying (EXECUTE ROW)
	if (sheetObj.ColSaveName(Col) == "to_eta_dt" && sheetObj.GetCellValue(Row, "to_eta_dt") != "") { // ETD
		var eta = sheetObj.GetCellValue(Row, "to_eta_dt");
		var frdate = sheetObj.GetCellValue(Row, "week_fromdate");
		var maxdate = sheetObj.GetCellValue(Row, "week_maxdate"); // week fromdate + 7주
		if (sheetObj.GetCellValue(Row, "pln_yrwk").length == 6) {
			if (eta < frdate || eta > maxdate) {
				ComShowCodeMessage("EQR90141", "ETA", frdate, maxdate);
				sheetObj.SetCellValue(Row, "to_eta_dt", "");
				sheetObj.SetCellEditable(Row, "to_eta_dt", 1);
				return false;
			}
		} else {
			ComShowCodeMessage("EQR90001", "Week "); // please input week
														// information
			sheetObj.SetCellValue(Row, "to_eta_dt", "", 0);
			sheetObj.SelectCell(Row, "pln_yrwk");
			return false;
		}
	}
	
	
	// ------- in case of vol modified
	if (sheetObj.ColSaveName(Col).substring(0, 3) == "vol") {
		var limitFlag = false;
		var cntrVol = 0;
		var tpszName = sheetObj.ColSaveName(Col).substring(3, 5);
		
		if (limitFlag) {
			ComShowCodeMessage("EQR90048", tpszName, cntrVol);
			sheetObj.SetCellValue(Row, Col, oldValue, 0);// rollback
		} else {
			oldValue = 0;
			Val = 0
			for ( var i = 0; i < consTpszArr.length; i++) {
				oldValue = sheetObj.GetCellValue(Row, "vol" + consTpszArr[i]);
				Val = Val + oldValue
			}
			sheetObj.SetCellValue(Row, "total_vol", Val, 0);				
			oldValue = Val;
		}
	}
}



function sheet1_OnSelectCell(sheetObj, OldRow, OldCol, NewRow, NewCol) {
	if (sheetObj.ColSaveName(NewCol).substring(0, 6) == "vol") {
		oldValue = sheetObj.GetCellValue(NewRow, NewCol);
		// alert("oldValue : " +oldValue);
	}
}



function sheet1_OnClick(sheetObj, Row, Col, Val) {
	// if(sheetObj.ColSaveName(Col).substring(0,6) == "vol") oldValue = Val;
	if (sheetObj.GetRowStatus(Row) == "I" && sheetObj.ColSaveName(Col) == "check") {
		sheetObj.SetCellValue(Row, "cntrno", "");// CNTR initializing
		for ( var i = 0; i < consTpszArr.length; i++) {
			oldValue = sheetObj.GetCellValue(Row, "vol" + consTpszArr[i]); // old
																				// value
																				// setting
			sheetObj.SetCellValue(Row, "vol" + consTpszArr[i], "0");// '0'
		}
	}

	
	if (sheetObj.ColSaveName(Col) == "to_yd_cd") {
		var CellPro = sheetObj.GetCellProperty(Row, "to_yd_cd", "Type");
		var strToYdCd = sheetObj.GetCellValue(Row, "to_yd_cd");
		var strFmYdCd = sheetObj.GetCellValue(Row, "fm_yd_cd");
		if ((sheetObj.GetCellValue(Row,"repo_mty_bkg_flg") == "" || sheetObj.GetCellEditable(Row, "to_yd_cd") == true) 
				&& sheetObj.GetCellValue(Row,"vvd") != "" && CellPro == "Text") {
			
			var strTrspModCd = sheetObj.GetCellValue(Row, "trsp_mod_cd");
			var strExecType = sheetObj.GetCellValue(Row, "exec_type");
			if(strTrspModCd == "W") {
				sheetObj.SetCellEditable(Row, "vvd", 1);
				sheetObj.SetColProperty(Row, "vvd", {KeyField : 1});
					
				sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Combo"});
		      
		    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Combo"});
		    	
		    	var pln_yrwk = sheetObj.GetCellValue(Row,"pln_yrwk");
				var vsl_cd = sheetObj.GetCellValue(Row,"vsl_cd");
				var skd_dir_cd = sheetObj.GetCellValue(Row,"skd_dir_cd");
				var skd_voy_no = sheetObj.GetCellValue(Row,"skd_voy_no");
				var colname   = "vsl_lane_cd";
		    	
		    	var f_cmd = SEARCHLIST08;
		        var sXml=sheetObj.GetSearchData("EES_EQR_0012GS4.do" , "&fmFmPlnYrWk_2=" + pln_yrwk +"&row=" + Row +"&vsl_cd=" + vsl_cd+"&skd_voy_no=" + skd_voy_no+"&skd_dir_cd=" + skd_dir_cd + "&col=" + colname + "&f_cmd=" + f_cmd);
		        var all_loc_cd = ComGetEtcData(sXml, "all_loc_cd");	        
		        sheetObj.SetCellValue(Row, "all_loc_cd", all_loc_cd , 0);
		        
		        
		    	// ------ FM LOC YARD retreive [START] -----------
				var f_cmd = SEARCH01;
				var vsl = vsl_cd;
				var from_ecc = sheetObj.GetCellValue(Row, "all_loc_cd");
				sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
						"row=" + Row + "&colname=fm_yd_cd&vsl=" + vsl
								+ "&ecc=" + from_ecc + "&item=V&f_cmd="
								+ f_cmd);
				sheetObj.SetCellValue(Row, "fm_yd_cd", strFmYdCd ,0);
				// ------ FM LOC YARD retreive [END] -----------
				
				
				// ------ TO LOC YARD retreive [START] -----------
				// SEARCH01 ==> SEARCH17 Change
				var f_cmd = SEARCH17;
				var vsl = vsl_cd;
				var to_ecc = sheetObj.GetCellValue(Row, "all_loc_cd");
				
				sheetObj.DoRowSearch2("EES_LOCYARDINITIAL_COMMON.do",
						"row=" + Row + "&colname=to_yd_cd&vsl=" + vsl
								+ "&ecc=" + to_ecc + "&item=V&f_cmd="
								+ f_cmd);
				sheetObj.SetCellValue(Row, "to_yd_cd", strToYdCd ,0);
			}else{
				sheetObj.SetCellEditable(Row, "vvd", 0);
				sheetObj.SetColProperty(Row, "vvd", {KeyField : 0});
				
				sheetObj.SetCellEditable(Row,"fm_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"fm_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
		      
		    	sheetObj.SetCellEditable(Row,"to_yd_cd",1);
		    	sheetObj.InitCellProperty(Row,"to_yd_cd",{ Type:"Text",AcceptKeys : "E|N",InputCaseSensitive : 1});
			}
		}
	}
}




// calcuating sub total after retrieve
function sheet1_OnSearchEnd(sheetObj, ErrMsg) {
	var totalRow = sheetObj.RowCount();	
	for (i = 2; i <= totalRow+1; i++) {
		sheetObj.SetCellValue(i, 'repobkg_flag', "T");// repobkg
		sheetObj.SetCellEditable(i, 'trsp_mod_cd', "false");// repobkg
		
		
		
		var tdValue = sheetObj.GetCellValue(i, "so_iss_flg");
		var tdBkgValue = sheetObj.GetCellValue(i, "repo_mty_bkg_flg");
		sheetObj.InitCellProperty(i, "so_iss_flg",{Type : "CheckBox"});
		
		if (tdValue == "Y") { 
			sheetObj.SetCellValue(i, "so_iss_flg", "1", 0);
			sheetObj.SetCellEditable(i, "so_iss_flg", "false");
			sheetObj.SetCellValue(i, "ibflag", "R", 0);
		}
		
		var strTrspModCd = sheetObj.GetCellValue(i, "trsp_mod_cd");
		
		if(strTrspModCd == "W") {
			if (tdBkgValue == "Y") { 
				sheetObj.InitCellProperty(i, "repo_mty_bkg_flg",{Type : "CheckBox"});
				sheetObj.SetCellValue(i, "repo_mty_bkg_flg", "1", 0);
				sheetObj.SetCellEditable(i, "repo_mty_bkg_flg", "false");
				sheetObj.SetCellValue(i, "ibflag", "R", 0);
			}else{
				sheetObj.InitCellProperty(i, "repo_mty_bkg_flg",{Type : "CheckBox"});
			}
		}else{
			sheetObj.SetCellEditable(i, "repo_mty_bkg_flg", "false");
		}
		
		if(sheetObj.GetCellValue(i, "ibflag") != "I") {
			sheetObj.SetCellValue(i, "ibflag", "R", 0);
		}
	}
	
	var formObject = document.form;
	if(formObject.exectype.value == "TV" || formObject.exectype.value == "FS" || formObject.exectype.value == "FW") {
		sheetObjects[0].SetColHidden("vvd",0);
		sheetObjects[0].SetColHidden("vsl_lane_cd",0);
	}else{
		sheetObjects[0].SetColHidden("vvd",1);
		sheetObjects[0].SetColHidden("vsl_lane_cd",1);
	}
	
	if(totalRow > 0) {
		ComBtnDisable("btn_delete");
	}else{
		ComBtnEnable("btn_delete");
	}
	
	
	sheetObj.SetWaitImageVisible(0);
	ComOpenWait(false);
}



/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	var formObj = document.form;
	with (formObj) {
		// btn_retrieve
		if (sAction == 0) {
			// repo plan id inserting
			if (!chkRepoplanId01(formObj, 'yyyyww', 'seq')) {
				return false;
			}
			
			if (!checkLocItem(formObj, 'fromStatus', 'fromLocation')) {
				return false;
			}
			if (!checkLocItem(formObj, 'toStatus', 'toLocation')) {
				return false;
			}
			
			if (!checkTpszCombo(2)) {
				return false;
			}
			if(strLoading != false) {
				if (!chkFromToWeek(formObj, 'fmPlnYr', 'fmPlnWk', 'FROM')) {
					return false;
				}
				if (!chkFromToWeek(formObj, 'toPlnYr', 'toPlnWk', 'TO')) {
					return false;
				}
			}
			
			if (formObj.status_type.value == "" || formObj.status_type.value == "null") {		
				ComShowCodeMessage("EQR01149");		
				return false;
			}
		} else if (sAction == 2) { // save
			var sRow = sheetObj.FindStatusRow("I|U");
			var arRow = sRow.split(";");
			var cntr_all = "";

			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "total_vol") == "0") {
						ComShowCodeMessage("EQR90128", eval(arRow[i]) - 1);
						return false;
					} else {
						if (sheetObj.GetCellValue(arRow[i], "total_vol") == "0" && sheetObj.GetCellValue(arRow[i], "sortnum") != "1") {
							ComShowCodeMessage("EQR90128", eval(arRow[i]) - 1);
							return false;
						}
					}
					
					if (sheetObj.GetCellValue(arRow[i], "trsp_mod_cd") == "w" && sheetObj.GetCellValue(arRow[i], "vvd") == "") {
						ComShowCodeMessage("EQR01154", eval(arRow[i]) - 1 );
						return false;
					}
				}
			}
		}
	}
	return true;
}




// Reason Reason Remark
function otherCombo(sheet, Row, Col) {
	var sText = sheet.GetCellText(Row, Col); // text
	var sValue = sheet.GetCellValue(Row, Col); // code
	if (sValue == 99) { // Others
		sheet.SetCellValue(Row, Col + 1, '', 0);
		sheet.SetCellEditable(Row, Col + 1, 1);
		sheet.SelectCell(Row, Col + 1, true);
	} else {
		sheet.SetCellValue(Row, Col + 1, "", 0);
		sheet.SetCellEditable(Row, Col + 1, 0);
	}
}




function goSearchRepoid(Type) {
	var formObject = document.form;
	var result = "";
	if (formObject.yyyyww.value.length != '6') {

		if (Type != "Loading") {
			ComShowCodeMessage("EQR70011");
		}
		ComSetFocus(formObject.yyyyww);
		sheetObjects[0].SetWaitImageVisible(0);
		ComOpenWait(false);
		result = false;
		return false;
	}

	if (formObject.seq.value.length == 2 && formObject.yyyyww.value != "" && formObject.exectype.value != "" &&
			comboObjects[0].GetSelectText() != "" && comboObjects[1].GetSelectText() != "") {
		var yyyymmdd = new Date();
		// var year=yyyymmdd.getYear();
		var year = yyyymmdd.getFullYear();
		var month = yyyymmdd.getMonth() + 1;
		var date = yyyymmdd.getDate();
		year = "" + year;
		month = "" + month;
		date = "" + date;
		if (month.length == 1) {
			month = "0" + month;
		}
		if (date.length == 1) {
			date = "0" + date;
		}
		ComOpenWait(true);
		var localDate = year + month + date;
		formObject.localDate.value = localDate;

		sheetObjects[0].RemoveAll();
		if (formObject.yyyyww.value.length == 6 && formObject.seq.value.length == 2) {
			
			formObject.repo_pln_id.value = formObject.yyyyww.value + "_" +
											formObject.exectype.value  + "_" +
											comboObjects[0].GetSelectText()+"_" +
											comboObjects[1].GetSelectText()+"_" + formObject.seq.value;
			
			param = "fm_conti_cd=" + comboObjects[0].GetSelectText()+"&to_conti_cd=" + comboObjects[2].GetSelectText();
			
			formObject.repo_pln_id.value =  formObject.yyyyww.value + "_" +
											formObject.exectype.value  + "_" +
											comboObjects[0].GetSelectText()+"_" +
											comboObjects[1].GetSelectText()+"_" + formObject.seq.value;
		} 
		ComOpenWait(true);
		if(schAllTysz == "") {
			//doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC05); //저장된 Type/Size
		}
        doActionIBSheet(sheetObjects[0], formObject, IBSEARCH_ASYNC04);
	} else {
		if (formObject.seq.value.length > 0 && formObject.seq.value.length < 2) {
			ComShowCodeMessage("EQR70011");
			formObject.seq.value = "";
			formObject.repo_rmk.value = "";
			ComSetFocus(formObject.seq);
		} else if (formObject.seq.value.length == 0) {
			formObject.repo_rmk.value = "";
		}
	}
	return result;
}


function ibSearchAsync03() {
	var formObject = document.form;
	if (formObject.status_type.value == "" || formObject.status_type.value == "null") {		
		ComBtnEnable("btn_create");
		ComBtnDisable("btn_delete");
		ComShowCodeMessage("EQR01149");		
		ComOpenWait(false);
	}
}



function setEccCommon() {
	linkPageNum = 0;
	if (document.form.dtrb_flg.value == "N") {
	} else {
		if (document.form.dtrb_flg.value != "") {
			document.form.fmPlnYr.value = document.form.st_year.value;
			document.form.fmPlnWk.value = document.form.st_weekly.value;
			document.form.toPlnYr.value = document.form.end_year.value;
			document.form.toPlnWk.value = document.form.end_weekly.value;
		} else {
			linkPageNum = null;
		}
	}

	//var sel_tab = tab1.GetSelectedIndex();
	setTimeout(function() {
		if (linkPageNum != null) {
			doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		}
	}, 500);
	// initializing
	checkTapButton();
}




/**
 * 
 * @param key
 */
function tpszChange(key) {
	switch (key) {
	case "":
		comboObjects[2].SetSelectCode(-1);
		comboObjects[2].SetSelectCode(consTpsz);
		break;
	case "D":
		comboObjects[2].SetSelectCode(-1);
		comboObjects[2].SetSelectCode(consTpszDry);
		break;
	case "S":
    	comboObjects[2].SetSelectCode(-1);
        comboObjects[2].SetSelectCode(consTpszSpc);
    	break;
    case "R":
    	comboObjects[2].SetSelectCode(-1);
        comboObjects[2].SetSelectCode(consTpszZrb);
    	break;
	
	}
}




/*
 * Fcst Inventory popup ( 112 )
 */
function openFcstInvWindow() {
	window.showModelessDialog('EES_EQR_0112.do?type=2', window, "scroll:no;status:no;help:no;dialogWidth:800px;dialogHeight:640px");
}



/*
 * IRG popup ( PRD )
 */
function openIrgWindow() {
	var from_loc = document.form.fromLocation.value;
	var to_loc = document.form.toLocation.value;
	var url = "ESD_PRD_0055_POP.do?mainPage=false&f_cmd=-1&i_org_cd=" + from_loc + "&i_dest_cd=&pop_mode=Y"
			+ to_loc;
	var styleInfo = "dialogLeft:0px; dialogTop:0px; dialogWidth:1020px; dialogHeight:765x; scroll:no;";
	ComOpenWindowCenter(url, "ESD_PRD_0055", 1350, 650, false, "yes");
}



/*
 * Vsl Residual Capa popup ( 113 )
 */
function openVslResWindow() {
	ComOpenWindowCenter('EES_EQR_0113.do', 'EesEqr0113', '800', '600', true);
}




// messageing after saving
function sheet1_OnSaveEnd(sheetObj, errMsg) {
	if (errMsg == '')
		ComShowCodeMessage("EQR90106");
		if (document.form.so_action.value.toUpperCase() == "SEND") {
			if (arrSoAlert.indexOf("N") > 0) {
			} else {
				if (ComShowConfirm(ComGetMsg("EQR90172"))) {
					//location.href = "ESD_TRS_0012.do?pgmNo=ESD_TRS_0012";
					ComOpenWindowCenter("ESD_TRS_0012.do?pgmNo=ESD_TRS_0012&refNo="+sendToRefNo
							,"ESD_TRS_0012", 1380, 650, false, 'yes');
				}
			}
			document.form.so_action.value = "";
		}
		
		var formObject = document.form;
		doActionIBSheet(sheetObj, formObject, IBSEARCH);
		ComOpenWait(false);
}



function checkTapButton() {
	var user_access = document.form.user_access.value;
	var exePlnEditFlg = document.form.exePlnEditFlg.value.toUpperCase();
	var exePlnEditFlg_split = document.form.exePlnEditFlg_split.value.toUpperCase();
	var saveFlag = document.form.saveFlag.value.toUpperCase();
	//var tabObj = tabObjects[0].selectedIndex;
	var button_flag = "X";
	if (saveFlag == "TRUE") {
		if (user_access == "TRUE") {
			button_flag = "F";
		} else {
			if (exePlnEditFlg == "TRUE") {
				button_flag = "F";
			} else if (exePlnEditFlg_split == "TRUE") {
				button_flag = "S";
			} else {
				button_flag = "X";
			}
		}
	} else { // LEVEL 3,4, 기타
		button_flag = "X";
	}

	if (button_flag == "F") {
		sheetObjects[0].SetEditable(1);
		ComBtnEnable("btn_save");		
		ComBtnEnable("btng_rowadd");
		ComBtnEnable("btng_sendtoso");
		ComBtnEnable("btng_cancelsoreq");
	} else if (button_flag == "S") {
		sheetObjects[0].SetEditable(0);
		
		ComBtnEnable("btn_save");
		ComBtnEnable("btng_rowadd");
		ComBtnEnable("btng_sendtoso");
		ComBtnEnable("btng_cancelsoreq");
	} else if (button_flag == "X") {
		sheetObjects[0].SetEditable(0);
		
		ComBtnEnable("btn_save");
		
		ComBtnEnable("btng_rowadd");
		ComBtnEnable("btng_sendtoso");
		ComBtnEnable("btng_cancelsoreq");
	}
}

function userAreaCheck(sheetObj, action, direction, tab_div, selRow) {
		// 권한 때문에 변경
	return true;
}



function sheet1_OnLoadFinish(sheetObj) {
	// var contents = "";
	// progressPop.innerHTML = contents;
	// document.all.progressPop.style.display = "none";
	
	var formObject = document.form;
	if(formObject.exectype.value == "TV" || formObject.exectype.value == "FS" || formObject.exectype.value == "FW") {
		sheetObjects[0].SetColHidden("vvd",0);
		sheetObjects[0].SetColHidden("vsl_lane_cd",0);
	}
	
	sheetObjects[0].SetWaitImageVisible(1);
	var newDate = new Date();
	var stryy = newDate.getFullYear();
	var strmm = newDate.getMonth() + 1;
	var strdd = newDate.getDate();
	if (strmm < 10)
		strmm = "0" + strmm;
	if (strdd < 10)
		strdd = "0" + strdd;

	var strNowDay = "" + stryy + strmm + strdd;
	
	formObject.f_cmd.value = SEARCH04;
	var sheetObj = sheetObjects[0];
	var sXml = sheetObj.GetSearchData("EES_EQR_0059GS4.do", FormQueryString(formObject) + "&nowdate=" + strNowDay);
	var strNowWeek = ComGetEtcData(sXml, "strNowWeek");
	formObject.nowWeek.value = strNowWeek; // 로딩시 현재 주 조회
	formObject.nowDay.value = strNowDay; // 로딩시 현재 주 조회
	
	doActionIBSheet(sheetObj,document.form,IBSEARCH02); //Vol Section 데이타 가져오기
	doActionIBSheet(sheetObj,document.form,IBSEARCH03); //Sub Continent 데이타 가져오기
	
	sheet1 = sheet1.Reset();// keyfied
	sheetObjects[0] = sheet1;
	ComConfigSheet(sheet1);
	initSheet(sheet1, 1, comboObjects[2].GetSelectText());
	ComEndConfigSheet(sheet1);
}



function changeViewComboChange(sheetObj, sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);

	if (dataNode == null) {
		return;
	}

	var trDataChildNodes = dataNode.childNodes;

	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			if (trDataChildNodes[i].nodeName == "TR") {
				var tdDataChildNodes = trDataChildNodes[i].childNodes;
				var targetRow = trDataChildNodes[i].getAttribute("ROW");

				for ( var j = 0; i < tdDataChildNodes.length; j++) {
					if (tdDataChildNodes[j] == null) {
						return;
					} else {
						if (tdDataChildNodes[j].nodeName == "TD") {
							var targetCol = tdDataChildNodes[j]
									.getAttribute("COL");
							var dataType = tdDataChildNodes[j]
									.getAttribute("DATA-TYPE");

							if (targetCol == null || dataType == null) {
								return;
							} else {
								if (dataType == "dtComboEdit") {
									var comboCode = tdDataChildNodes[j]
											.getAttribute("COMBO-CODE");
									var comboText = tdDataChildNodes[j]
											.getAttribute("COMBO-TEXT");

									if (comboText != "") {
										ComboData = "Y";
									} else {
										ComboData = "N";
										sheetObj.InitCellProperty(targetRow,
												"fm_yd_cd", {
													Type : "Text",
													AcceptKeys : "E|N",
													InputCaseSensitive : 1
												});
										sheetObj.InitCellProperty(targetRow,
												"to_yd_cd", {
													Type : "Text",
													AcceptKeys : "E|N",
													InputCaseSensitive : 1
												});
										sheetObj.SetCellValue(targetRow,
												"fm_yd_cd", "");
										sheetObj.SetCellValue(targetRow,
												"to_yd_cd", "");
									}
								}
							}
						}
					}
				}
			}
		}
	}

}



function sheet_HgtChange() {
	var minHeight1 = 0;
	var maxHeight1 = 0;	
	
	if(strMinimizeYN == true) {
		maxHeight1 = sheetObjects[0].GetSheetHeight()+200;		
		document.getElementById("searchLayer").style.display = "none";
    	sheetObjects[0].SetSheetHeight(maxHeight1);
    	
		strMinimizeYN= false;
		document.getElementById("btn_minimize").innerText = "Minimize";
	} else {
		
		minHeight1 = sheetObjects[0].GetSheetHeight()-200;		
		
		document.getElementById("searchLayer").style.display = "Inline";
    	sheetObjects[0].SetSheetHeight(minHeight1);    	
    	strMinimizeYN= true;
    	document.getElementById("btn_minimize").innerText = "Maximize";    		
	}
}



/**
 * Vol. Selection  registering click event
 */
function volsec_OnCheckClick(comboObj, index, code) {
	if (index == 0) {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			for ( var i=1; i < comboObj.GetItemCount(); i++) {
				comboObj.SetItemCheck(i,0);
			}
		}
	} else {
		var bChk=comboObj.GetItemCheck(index);
		if (bChk) {
			comboObj.SetItemCheck(0,0);
		}
		
	}
} 


function exectypeChange(key) {
	var formObject = document.form;
	if(formObject.exectype.value == "TV" || formObject.exectype.value == "FS" || formObject.exectype.value == "FW") {
		sheetObjects[0].SetColHidden("vvd",0);
		sheetObjects[0].SetColHidden("vsl_lane_cd",0);
	}else{
		sheetObjects[0].SetColHidden("vvd",1);
		sheetObjects[0].SetColHidden("vsl_lane_cd",1);
	}
	
	checkSearch();
}



function fm_conti_cd_OnChange(comboObj, value, text) {
	checkSearch();
}


function to_conti_cd_OnChange(comboObj, value, text) {
	checkSearch();
}



/*function tpsztype_OnCheckClick(comboObj,index, code) {
	var formObject = document.form;
	var sheetObject = sheetObjects[0];
	
	
	if(code != "") {
		doActionIBSheet(sheetObject, formObject, IBSEARCH);
	}
}*/


function checkSearch() {
	var formObject = document.form;
	var stryyyyww = formObject.yyyyww.value;
	var strexectype = formObject.exectype.value;
	var strfromconti = comboObjects[0].GetSelectText();
	var strtoconti = comboObjects[1].GetSelectText();
	var strseq = formObject.seq.value;
	
	if(stryyyyww.length != 6 && stryyyyww != "") {
		ComShowCodeMessage("EQR01103","Repo.Plan Date");
		formObject.yyyyww.foucs();
		return false;
	}
	
	if(stryyyyww != "" && strexectype != "" && strfromconti != "" && strtoconti != "" && strseq != "") {
		goSearchRepoid();
	}
}


/**
 * handling in case of clicking image button on sheet1
 * @param sheetObj
 * @param Row
 * @param Col
 * @return
 */
function sheet1_OnPopupClick(sheetObj, Row,Col){
var formObject = document.form;
	with(sheetObj) {
		var sName = ColSaveName(Col);
		switch (sName) {
			case "vvd":
				//alert(sheetObj.CellValue(Row, "ofc_cd"));
				ComOpenPopup("ESM_BKG_0019POP.do", 870, 580, 'setPopupParam', '0,0', true, false, Row, Col, 0);
				break;
		}
	}
}


/**
 * function get parameter from popup
 * @param aryPopupData
 * @param Row
 * @param Col
 * @param SheetIdx
 * @return
 */
function setPopupParam(aryPopupData, Row, Col, SheetIdx) {
	//alert( aryPopupData + "::"+ Row + "::"+ Col+ "::"+SheetIdx);
	var str = aryPopupData +"";
	var arr = str.split(',');
	var sheetObj =  sheetObjects[SheetIdx];
	sheetObj.SetCellValue( Row, Col, arr[3], 0);

	sheet1_OnChange(sheetObj , Row, Col, arr[3]);
}




/**
 * add data  combo field 
 */	
function addComboItem(comboObj,comboItems) {
	for (var i=0 ; i < comboItems.length ; i++) {
		var comboItem=comboItems[i].split("=");
		comboObj.InsertItem(i, comboItem[0] , comboItem[0]);		
	}   		
}


function chkRepoplanId01(formObj, obj1, obj2) {
    if(eval("formObj."+obj1).value.length != 6) {
    	ComShowCodeMessage("EQR90001","Repoplan ID");
        eval("formObj."+obj1).focus();
        return false;
    }
    if(eval("formObj."+obj2).value.length != 2) {
    	ComShowCodeMessage("EQR90001","Repoplan ID");
        eval("formObj."+obj2).focus();
        return false;
    }
    return true;
}    


function changeViewNewCombo(sheetObj, sXml) {
    var xmlDoc = ComGetXmlDoc(sXml);
    var xmlRoot = xmlDoc.documentElement;
    var dataNode=xmlRoot.getElementsByTagName("DATA").item(0);
    
    if (dataNode == null) {
        return;
    }
    
    var trDataChildNodes = dataNode.childNodes;
    
    for (var i=0; i<trDataChildNodes.length; i++) {
    	if (trDataChildNodes[i] == null) {
    		return;
    	} else {
    		if (trDataChildNodes[i].nodeName == "TR") {
    			var tdDataChildNodes = trDataChildNodes[i].childNodes;
    			var targetRow = trDataChildNodes[i].getAttribute("ROW");
    			
    			for (var j=0; i<tdDataChildNodes.length; j++) {
    				if (tdDataChildNodes[j] == null) {
    					return;
    				} else {
    					if (tdDataChildNodes[j].nodeName == "TD") {
        					var targetCol = tdDataChildNodes[j].getAttribute("COL");
        					var dataType = tdDataChildNodes[j].getAttribute("DATA-TYPE");
        					
        					if (targetCol == null || dataType == null) {
        						return;
        					} else {
        						if (dataType == "dtComboEdit") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
                					sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:comboCode, ComboText:comboText});
                					
                					if(targetCol == "fm_yd_cd") {
                						var arrCombo = comboCode.split("|");
                						var arrComboSize = arrCombo.length;
                						sheetObj.SetCellValue(targetRow, targetCol, arrCombo[0], 0);
                					}
        						} else if (dataType == "dtCombo") {
                					var comboCode = tdDataChildNodes[j].getAttribute("COMBO-CODE");
                					var comboText = tdDataChildNodes[j].getAttribute("COMBO-TEXT");
        							sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:comboCode, ComboText:comboText});
        						} else if (dataType == "dtData") {
        							
        							var tdValNode = tdDataChildNodes[j].childNodes;
        							var tdVal = tdValNode[0].nodeValue;
        							sheetObj.SetCellValue(targetRow, targetCol, tdVal, 0);
        							
        							if(targetCol == "fm_yd_cd") {
        								sheetObj.InitCellProperty(targetRow , targetCol , {Type:"Combo", ComboCode:tdVal, ComboText:tdVal});
        							}
        						} else {
        							return;
        						}
        					}
    					}
    				}
    			}
    		}
    	}
    }
    
}


function sheet1_ChangeXml(sXml) {
	var xmlDoc = ComGetXmlDoc(sXml);
	var xmlRoot = xmlDoc.documentElement;
	var dataNode = xmlRoot.getElementsByTagName("DATA").item(0);
	if (dataNode == null) {
		return;
	}
	var trDataChildNodes = dataNode.childNodes;
	var rowIndex = 2;
	for ( var i = 0; i < trDataChildNodes.length; i++) {
		if (trDataChildNodes[i] == null) {
			return;
		} else {
			var tdDataChildNodes = trDataChildNodes[i].childNodes;
			if (tdDataChildNodes[2] != null) {
				var dataType = tdDataChildNodes[2].getAttribute("DATA-TYPE");
				if (dataType == "dtCheckBox") {
					sheet1.InitCellProperty(rowIndex, "mailfax", {
						Type : "CheckBox"
					});
				}
			}

			if (tdDataChildNodes[16] != null) {
				var dataType = tdDataChildNodes[16].getAttribute("DATA-TYPE");
				var tdValue = sheet1.GetCellValue(rowIndex,"repo_mty_bkg_flg");
				if (dataType == "dtCheckBox") {
					sheet1.InitCellProperty(rowIndex, "repo_mty_bkg_flg",{Type : "CheckBox"});

					if (tdValue == "Y") {
						sheet1.SetCellValue(rowIndex, "repo_mty_bkg_flg","1", 0);
						sheet1.SetCellValue(rowIndex, "ibflag", "", 0);
					}
				}
			}
		}

		if (trDataChildNodes[i].nodeType == 1) {
			rowIndex++;
		}
	}
}


function doActionIBSheet2(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		if (consTpszArr.length >= allTpszCnt) {
			var strBkgChk = "";
			var strBkgNo = "";
			var repobkg_count = 0;
			var delRow = 0;
			var selRow = 0;
			for ( var i = 2; i <= sheetObj.RowCount()+1; i++) {
				strBkgChk = sheetObj.GetCellValue(i,"repo_mty_bkg_flg");
				strBkgNo = sheetObj.GetCellValue(i,"mt_bkg_no");
				//sheetObj.GetCellValue(i, "t2_repobkg_flag")>> Mty Repo BKG Check하면 T로 Set이 되어진다.
				//document.form.position_row2.value >> 체크된 row 위치표시
				if(strBkgNo == "" && strBkgChk == "1") {
					//document.form.position_row2.value = i;
					selRow = i;
					repobkg_count++;
				}
				
			}
			
			// BKG CRE 로직 start
			if (repobkg_count == 1) {				
				//var selRow = sheetObj.GetSelectRow(); // selected ROW				
				var fmYdLoc = sheetObj.GetCellValue(selRow, 'fm_yd_cd');
				var toYdLoc = sheetObj.GetCellValue(selRow, 'to_yd_cd');
				var volTotal = sheetObj.GetCellValue(selRow, 'total_vol');
				var vCode = "";
				var vCodeNm = "";
				
				formObj.f_cmd.value=SEARCH01;
				var intgCdId='CD30101';
				var param="&intgCdId="+intgCdId;
				var xml=sheetObj.GetSearchData("EES_CIM_COMGS.do", FormQueryString(formObj)+param);
				
				if (xml != "") {
					var arrStrCode=ComGetEtcData(xml, "code_nm");
					var arrCode = arrStrCode.split("@");
					var strAllCode="";
					var arrAllCode="";
					for(var i=0;i<arrCode.length;i++) {						
						strAllCode = arrCode[i].split("@");
						for(var j=0;j<strAllCode.length;j++) {
							arrAllCode = strAllCode[j].split("|");
							strCode = arrAllCode[0];
							strCodeNm = arrAllCode[1];
							
							if(i == 0) {
								vCode =  strCode;
								vCodeNm =  strCodeNm; 
							}else{
								vCode = vCode + "|" + strCode; 
								vCodeNm = vCodeNm + "|" + strCodeNm; 
							}
						}
					}
				}
				var chkVolRtn = chkLocationVol(vCode,vCodeNm,fmYdLoc,toYdLoc,volTotal);
				if(chkVolRtn == false) {
					return false;
				}				
				
				if (ComShowConfirm(ComGetMsg("EQR90053"))) {
					if ((sheetObj.GetCellValue(selRow, 'fm_chk_flg') != "Y")) {
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						for ( var i = 2; i < sheetObj.RowCount()+1; i++) {
							if(selRow != i) {
								sheetObj.SetCellValue(i,"ibflag","R");
							}
							
						}
						
						ComOpenWait(true);
						formObj.f_cmd.value = MULTI05;
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData(
								"EES_EQR_0080GS1.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						
						sheetObj.LoadSaveData(sXml, {Sync : 1});
						//save end ==> sheet1_ChangeXml
						//sheet1_ChangeXml(sXml);
					}
				}
			} else if (repobkg_count > 1) {
				ComShowCodeMessage("EQR90152", "Repo BKG Cre.");
				return false;
			} else {
				ComShowCodeMessage("EQR90123");
			}
		} else {
			ComShowCodeMessage("EQR90045", "Repo BKG", "ALL");
		}
		break;
	}
}



function doActionIBSheet3(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		// if(validateForm(sheetObj,formObj,sAction))
		if (consTpszArr.length >= allTpszCnt) {
			var sRow = sheetObj.FindStatusRow("U");
			var arRow = sRow.split(";");
			var so_count = 0; // so send checked row
			var so_row = 0; // so send checked vol total
			var soAlert = "";
			arrSoAlert = "";
			sendToRefNo = "";
			if (sRow != "" && sRow != null) {
				// for(var i=0; i<arRow.length-1; i++) {
				for ( var i = 0; i < arRow.length; i++) {
					if (sheetObj.GetCellValue(arRow[i], "so_iss_flg") == "1") {
						// item Rail
						if (sheetObj.GetCellValue(arRow[i], "trsp_mod_cd") == "R") {
							if (sheetObj.GetCellValue(arRow[i], "fm_yd_cd").substr(0, 2) == "US" || sheetObj.GetCellValue(arRow[i],"fm_yd_cd").substr(0, 2) == "CA") {
								soAlert = "N";
								arrSoAlert = arrSoAlert + "|" + soAlert;
							}
						}
						sendToRefNo = sendToRefNo + ","+ sheetObj.GetCellValue(arRow[i], "ref_id");
						
						// so send row
						document.form.position_row2.value = arRow[i];
						so_count++;
						if (sheetObj.GetCellValue(arRow[i], "co_cd") == "S") {
							so_row = eval(so_row)+ eval(sheetObj.GetCellValue(arRow[i],"totalvol"));
						}
					}
				}
			}
			
			// if(sRow!="" && sRow!=null) {
			if (so_count > 0) {
				if (ComShowConfirm(ComGetMsg("EQR90054"))) {
					var selRow = sheetObj.GetSelectRow(); // selected ROW

					if ((sheetObj.GetCellValue(selRow, 'fm_chk_flg') != "Y")) {
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						formObj.so_action.value = "SEND"; // so send action 샐행을 의미함.
						formObj.f_cmd.value = MULTI06;
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData("EES_EQR_0080GS1.do?soFlag=Y", saveStr,
								eqrFormQryStr(formObj));
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
					}
				}
			} else {
				ComShowCodeMessage("EQR90044");
			}
		} else {
			ComShowCodeMessage("EQR90045", "S/O Send", "ALL");
		}
		break;
	}
}



function doActionIBSheet4(sheetObj, formObj, sAction) {
	sheetObj.ShowDebugMsg(false);
	switch (sAction) {
	case IBSAVE: // saving
		var selRow = sheetObj.GetSelectRow(); // selected ROW
		var cancelOK = false;
		var totalvol = sheetObj.CellSearchValue(selRow, 'total_vol'); // total volume
		var co_cd = sheetObj.CellSearchValue(selRow, 'co_cd'); // company
		var fm_rcc = sheetObj.CellSearchValue(selRow, 'fm_rcc'); // from rcc
																	// -
		var trspno_p = sheetObj.CellSearchValue(selRow, 'trspno_p');
		var trspno_d = sheetObj.CellSearchValue(selRow, 'trspno_d');
		var trspno_a = sheetObj.CellSearchValue(selRow, 'trspno_a');
		var trsp_sum = eval(trspno_p) + eval(trspno_d);
		if (sheetObj.GetCellValue(selRow, 'trsp_mod_cd') == 'W') { // WATER
			if (co_cd == 'H') { //
				if (trspno_p == trspno_a)
					cancelOK = true;
			} else { //
				if (fm_rcc == 'DEHAM') { // 구주 지역만 D까지 포함
					if (trsp_sum == totalvol)
						cancelOK = true;
				} else {
					if (trspno_p == totalvol)
						cancelOK = true;
				}
			}
		} else { // TRUCK, RAIL
			if (co_cd == 'H') { //
				if (trspno_p == totalvol)
					cancelOK = true;
			} else { //
				if (fm_rcc == 'DEHAM') {
					if (trsp_sum == totalvol)
						cancelOK = true;
				} else {
					if (trspno_p == totalvol)
						cancelOK = true;
				}
			}
		}
		
		//cancelOK = true;
		if (sheetObj.GetCellValue(selRow, 'so_iss_flg') == "1") {
			if (cancelOK) {
				// checking user athority
				if (!userAreaCheck(sheetObj, "Cancel S/O Req.", "from", 2,selRow)) {
					// return false;
				}
				
				if (ComShowConfirm(ComGetMsg("EQR90055"))) {

					if ((sheetObj.GetCellValue(selRow, 'fm_chk_flg') != "Y")) {
					}

					if (validateForm(sheetObj, formObj, sAction, 2)) {
						sheetObj.SetCellValue(selRow, 'so_cancel_flag', "T");// so cancel so cancel row
						formObj.f_cmd.value = MULTI07;
						var saveStr = sheetObj.GetSaveString();
						if (saveStr == "")
							return;
						var sXml = sheetObj.GetSaveData("EES_EQR_0080GS1.do",saveStr, eqrFormQryStr(formObj));
												
						sheetObj.LoadSaveData(sXml, {
							Sync : 1
						});
					}
				}
			} else { // cancelOk=false
				ComShowCodeMessage("EQR90142");
				// rollback
				sheetObj.SetCellValue(selRow, 'so_iss_flg', sheetObj.GetCellValue(selRow, 'so_iss_flg'), 0);
				sheetObj.SetCellValue(selRow, 'so_cancel_flag', sheetObj.GetCellValue(selRow, 'so_cancel_flag'), 0);
			}
		} else {
			ComShowCodeMessage("EQR90047");
			// rollback
			sheetObj.SetCellValue(selRow, 'so_iss_flg', sheetObj.GetCellValue(selRow, 'so_iss_flg'), 0);
			sheetObj.SetCellValue(selRow, 'so_cancel_flag', sheetObj.GetCellValue(selRow, 'so_cancel_flag'), 0);
		}
		break;
	}
}



function settingCntrDelValue(targetSheet, targetRow) {
	var CheckYN = "N";
	CheckYN = sheetObjects[0].GetCellValue(targetRow, "cntrdel");	 
	return CheckYN;
}



function settingValue(cntrno, tpszno, targetSheet, targetRow) {
	if (cntrno == "" && tpszno == "") {
		sheetObjects[0].SetCellValue(targetRow, "cntrdel", "Y", 0);
		cntrno = "xxx";
		tpszno = "xxx";
	} else {
		sheetObjects[0].SetCellValue(targetRow, "cntrdel", "", 0);
	}
	sheetObjects[0].SetCellValue(targetRow, "cntrno", cntrno);
	sheetObjects[0].SetCellValue(targetRow, "tpszno", tpszno);
}


function settingValue_split(cntr_no, cntr_type, cntr_status, targetRow) {
	sheetObjects[0].SetCellValue(targetRow, "cntrno", cntr_no);
	sheetObjects[0].SetCellValue(targetRow, "tpszno", cntr_type);
	sheetObjects[0].SetCellValue(targetRow, "cntrstatus", cntr_status);
	// ComShowMessage("here 1" );
	doActionIBSheet_3(sheetObjects[0], document.form, IBSAVE);
}
