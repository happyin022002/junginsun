/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BSA_0104.js
 *@FileTitle  : Inquire/Edit Daily-consumption & FO/DO By Lane
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/18
=========================================================*/

var sheetObjects = new Array();
var sheetCnt = 0;
var vHeader = "";
var subColNo = 0;
var sheet_height = 20; // height of sheet
var comboObjects = new Array();
var comboCnt = 0;
var loadingMode = false;
var sls = "";
var pur = "";
var slt = "";
/* Event handler processing by button click event */
document.onclick = processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var sheetObject = sheetObjects[0];
	var formObject = document.form;
	try {
		var srcName = ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch (srcName) {
		case "btn_retrieve":
			// sheetObjects[0].RemoveAll();
			doActionIBSheet(sheetObject, formObject, IBSEARCH);
			break;
		case "btn_save":
			doActionIBSheet(sheetObject, formObject, IBSAVE);
			break;
		case "btn_downexcel":
				doActionIBSheet(sheetObject, formObject, IBDOWNEXCEL);
			break;
		case "btn_skdinquiry":
			var vsl_cd = "";
			var classId = "COM_ENS_0B1";
			var param = "";
			if (sheetObject.GetSelectRow() > 1) {
				vsl_cd = ComTrim(sheetObject.GetCellValue(sheetObject
						.GetSelectRow(), "vsl_cd"))
						+ ComTrim(sheetObject.GetCellValue(sheetObject
								.GetSelectRow(), "skd_voy_no"))
						+ ComTrim(sheetObject.GetCellValue(sheetObject
								.GetSelectRow(), "skd_dir_cd"));
			} else {
				ComShowMessage(ComGetMsg("COM12113", "VVD"));
				return false;
			}
			param = '?vvd_cd=' + vsl_cd + '&classId=' + classId;
			ComOpenPopup("/opuscntr/COM_ENS_0B1.do" + param, 610, 460, "",
					"0,0,1,1,1,1,1,1,1,1", false);
			break;
		case "btng_reset":
			doActionIBSheet(sheetObject, formObject, IBRESET);
			break;
			
		case "bu_zoom_in":
			sheet_height = getSheetHeightCnt(sheetObject, "MAX", 1);
			// no support[check again]CLT
			// sheetObject.style.height=sheetObject.GetSheetHeight(sheet_height);
			sheetObject.SetSheetHeight(ComGetSheetHeight(sheetObject, sheet_height));
			
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="none";
	        document.getElementById("div_zoom_out").style.display="inline";
//			div_zoom_in.style.display = "none";
//			div_zoom_out.style.display = "inline";
//			parent.syncHeight();
			resizeSheet();
			break;			
			
		case "bu_zoom_out":
//	        2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	        document.getElementById("div_zoom_in").style.display="inline";
	        document.getElementById("div_zoom_out").style.display="none";
//			div_zoom_in.style.display = "inline";
//			div_zoom_out.style.display = "none";
//			parent.syncHeight();
			
//			2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
			var rowcount = sheetObject.RowCount(); // 시트의 열 개수
			var totalrowheight = 0; // 총 열 높이의 합 초기화												
			for(y=0; y<=rowcount; y++){
				totalrowheight = totalrowheight + sheetObject.GetRowHeight(y); // 모든 열의 높이의 합 구하기
			}			
			if(totalrowheight+150 > 448){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
				sheetObject.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
			}
			
			break;			
			
		} // end switch
	} catch (e) {
		if (e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
/**
 * Description : registering IBSheet Object as list <br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <b>Example : </b>
 * 
 * <pre>
 * setComboObject(sheet_obj)
 * </pre>
 * 
 * @param {object}
 *            sheet_obj - Sheet Object
 * @see
 * @author
 * @version 2009.01.01
 */
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++] = sheet_obj;
}
/**
 * Description : registering IBCombo Object as list <br>
 * adding process for list in case of needing batch processing with other items<br>
 * defining list on the top of source<br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * setComboObject(combo_obj)
 * </pre>
 * 
 * @param {object}
 *            combo_obj - Combo Object
 * @see
 * @author
 * @version 2009.01.01
 */
function setComboObject(combo_obj) {
	comboObjects[comboCnt++] = combo_obj;
}
/**
 * Description : initializing sheet <br>
 * implementing onLoad event handler in body tag<br>
 * adding first-served functions after loading screen.<br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * loadPage()
 * </pre>
 * 
 * @see
 * @author
 * @version 2009.01.01
 */
function loadPage(header) {
	for (i = 0; i < sheetObjects.length; i++) {
//		sheetObjects[i].RemoveAll();
//		sheetObjects[i].Reset();
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i], i + 1, header);
		ComEndConfigSheet(sheetObjects[i]);
		//ComEndConfigSheet(sheetObjects[i]);
	}
	
	// retrieving automatically in case of loading after calling from SPC
	// -----------------------------------------------------
	if (document.form.hSearchYN.value == "Y") {
		doActionIBSheet(sheetObjects[0], document.form, IBSEARCH);
		document.form.hSearchYN.value = "";
	}
	// -----------------------------------------------------
	// Handling multi combo
	loadingMode = true;
	loadCombo();
	for (k = 0; k < comboObjects.length; k++) {
		initCombo(comboObjects[k], comboObjects[k].id);
	}
	loadingMode = false;
	resizeSheet();
}
/**
 * Description : Combo basic setting and initialization <br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * loadCombo()
 * </pre>
 * 
 * @see
 * @author
 * @version 2009.01.01
 */
function loadCombo() {
	var formObj = document.form;
	var sXml = formObj.sXml.value;
	var arrXml = sXml.split("|$$|");
	comboXml = arrXml;
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
	if (arrXml.length > 1)
		ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
	if (arrXml.length > 2)
		ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
	if (arrXml.length > 3)
		ComXml2ComboItem(arrXml[3], cobIOC, "code", "code");
	document.form.sXml.value = "";
	
}
/**
 * Description : setting sheet initial values and header <br>
 * adding case as numbers of counting sheets<br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * initSheet(sheetObj, sheetNo, header)
 * </pre>
 * 
 * @param {object}
 *            sheetObj - Sheet Object
 * @param {Number}
 *            sheetNo - Sheet Number
 * @param {String}
 *            header - header
 * @see
 * @author
 * @version 2009.01.01
 */
function initSheet(sheetObj, sheetNo, header) {
	var cnt = 0;
	var aryCD = "";
	var colNo = 0;
	var formObj = document.form;
	var sls = "";
	var pur = "";
	var slt = "";
	var chkValue = "";
	for (k = 0; k < formObj.rdoOpJob.length; k++) {
		if (formObj.rdoOpJob[k].checked)
			chkValue = formObj.rdoOpJob[k].value;
	}
	aryCD = header.split("|");
	if (header != "")
		subColNo = aryCD.length;
	if (chkValue != "008" && chkValue != "009") {
		colNo = parseInt(subColNo * 5) + 22;
	} else {
		colNo = parseInt(subColNo) + 18;
	}
	var arrCluLogic = new Array(subColNo);
	switch (sheetNo) {
	case 1: // sheet1 init
	    with(sheetObj){
		      var HeadTitle0="STS|BSA\nFlag|YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA\nCAPA." ;
		      var HeadTitle1="STS|BSA\nFlag|YYYY-WW|Trade|Sub\nTrade|S.Lane|Lane|Type|Vessel|Voy.|BD|OPR|Carrier|BSA\nCAPA." ;
		      if(chkValue == "007"){
			      HeadTitle0=HeadTitle0 +"|Company\n1st BSA";
			      HeadTitle1=HeadTitle1 +"|Company\n1st BSA";
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Other Carrier's 1st BSA" ;
			      HeadTitle0 +="|Free Addition|Free Addition|Company 2nd BSA\n(SPC control)" ;
			      for(j=0; j<subColNo; j++)
			    	  HeadTitle0 += "|Other Carrier's 2nd BSA Control (by VVD)" ;
			      HeadTitle0 += "|Swap\nNotice";
			      HeadTitle1 += "|" + header + "|SPC(TEU)|WGT|";
			      HeadTitle1 += "Company 2nd BSA\n(SPC control)|";
			      HeadTitle1 +=  header + "|Swap\nNotice|" + header + "|" + header + "|" + header;
			      for(j=0; j<subColNo; j++)
			    	  HeadTitle0 += "|Sale to(by VVD)";
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Purchase from(by VVD)";
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Slot Swap(by VVD)";
			      HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
			      HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
			      for(j=0; j<subColNo; j++){
				      arrCluLogic[j]="|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|";
				      sls += "|sls"+aryCD[j]+"|";
				      pur += "|pur"+aryCD[j]+"|";
				      slt += "|slt"+aryCD[j]+"|";
				      if(j != subColNo-1){
					      sls += "+";
					      pur += "+";
					      slt += "+";
				      }
			      }
		      }
		      else if(chkValue == "008" && chkValue == "009"){
			      HeadTitle0=HeadTitle0 +"|"+vHeader;
			      HeadTitle1=HeadTitle1 +"|"+ConstantMgr.getCompanyCode();
			      for(j=0; j<subColNo; j++)
			    	  HeadTitle0=HeadTitle0 +  "|"+vHeader ;
			      HeadTitle1 += "|" + header ;
			      HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
			      HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
		      } else {
			      HeadTitle0=HeadTitle0 +"|"+vHeader;
			      HeadTitle1=HeadTitle1 +"|"+ConstantMgr.getCompanyCode();
			      for(j=0; j<subColNo; j++)
			    	  HeadTitle0 += "|"+vHeader ;
			      HeadTitle0 +="|Free Addition|Free Addition|Company 2nd BSA\n(SPC control)" ;
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Other Carrier's 2nd BSA Control (by VVD)" ;
			      HeadTitle0 += "|Swap\nNotice";
			      HeadTitle1 += "|" + header + "|SPC(BOX)|WGT|Company 2nd BSA\n(SPC control)|" + header + "|Swap\nNotice|" + header + "|" + header + "|" + header;
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Sale to(by VVD)";
			      for(j=0; j<subColNo; j++)
			    	  HeadTitle0 += "|Purchase from(by VVD)";
			      for(j=0; j<subColNo; j++) 
			    	  HeadTitle0 += "|Slot Swap(by VVD)";
			      HeadTitle0 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
			      HeadTitle1 += "|ioc_cd|bsa_op_cd|n1st_port_etd_dt";
			      for(j=0; j<subColNo; j++){
				      arrCluLogic[j]="|c"+aryCD[j]+"|+|sls"+aryCD[j]+"|-|pur"+aryCD[j]+"|";
				      sls += "|sls"+aryCD[j]+"|";
				      pur += "|pur"+aryCD[j]+"|";
				      slt += "|slt"+aryCD[j]+"|";
				      if(j != subColNo-1){
					      sls += "+";
					      pur += "+";
					      slt += "+";
				      }
				      }
			     }
		      SetConfig( { SearchMode:2, FrozenCol:14, MergeSheet:5, Page:20, DataRowMerge:0 } );		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		      var headers = [ { Text:HeadTitle0, Align:"Center"},  { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);		
		      var cols = [ {Type:"Status",    Hidden:0, Width:25,   Align:"Center",  ColMerge:1,   SaveName:"ibflag",                KeyField:0 },
				             {Type:"Text",      Hidden:0,  Width:25,   Align:"Center",  ColMerge:1,   SaveName:"bsa_zr_flg",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"cost_yrwk",             KeyField:0,   CalcLogic:"",   Format:"",          PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"trd_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"sub_trd_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"slan_cd",               KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:50,   Align:"Center",  ColMerge:1,   SaveName:"rlane_cd",              KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vsl_lane_tp_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:45,   Align:"Center",  ColMerge:1,   SaveName:"vsl_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"skd_voy_no",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:20,   Align:"Center",  ColMerge:1,   SaveName:"skd_dir_cd",            KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:35,   Align:"Center",  ColMerge:1,   SaveName:"vop_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"crr_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
				             {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:1,   SaveName:"bsa_capa",              KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		      
		      if(chkValue == "007"){
		    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"c"+aryCD[j], KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 });
			      
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"free_add_teu_capa",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"free_add_wgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			      cols.push({Type:"AutoSum",   Hidden:0, Width:110,  Align:"Right",   ColMerge:1,   SaveName:"n2nd_fnl_co_bsa_capa",  KeyField:0,   CalcLogic:"cluSecondFinal(|fnl_co_bsa_capa|, "+sls+", "+pur+", "+slt+", |free_add_teu_capa|)" , Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     
			      for(j=0; j<subColNo; j++) 
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"s"+aryCD[j],            KeyField:0,   CalcLogic:arrCluLogic[j],Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"spc_otr_swap_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			    
			      for(j=0; j<subColNo; j++)
			      	  cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sls"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pur"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slt"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     
			      InitColumns(cols);
			      SetEditable(1);
//			      SetRangeBackColor(0, 15, 0, 13+subColNo,"#BBBCE6");
			      //GetCellBackColor(0,17+subColNo,"#BBBCE6");
//			      SetRangeBackColor(1, 15, 1, 15+subColNo+2, "#000000");
//			      SetRangeBackColor(1, 16+subColNo, 1, 17+subColNo*2, "#000000");
			      //FrozenCols =15;
		      }
		      else if(chkValue != "008" && chkValue != "009"){
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"fnl_co_bsa_capa",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"c"+aryCD[j],            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			      
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"free_add_teu_capa",     KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"free_add_wgt",          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 });
			      //20150810.MOD
			      cols.push({Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:1,   SaveName:"n2nd_fnl_co_bsa_capa",  KeyField:0,   CalcLogic:"cluSecondFinal(|fnl_co_bsa_capa|, "+sls+", "+pur+", "+slt+", |free_add_teu_capa|)" ,Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"s"+aryCD[j],            KeyField:0,   CalcLogic:arrCluLogic[j],Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:1,   SaveName:"spc_otr_swap_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++)
			      	cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"sls"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++) 
			     	 cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"pur"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      for(j=0; j<subColNo; j++) 
			    	  cols.push({Type:"AutoSum",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"slt"+aryCD[j],          KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     
			      InitColumns(cols);
			      SetEditable(1);
//			      SetRangeBackColor(0, 14, 0, 14+subColNo,"#000000");
//			      GetCellBackColor(0,17+subColNo,"#BBBCE6");
//			      SetRangeBackColor(1, 14, 1, 13+subColNo+2,"#000000");
//			      SetRangeBackColor(1, 16+subColNo, 1, 17+subColNo*2, "#000000");
//			      FrozenCols =14;
		      }else{
			      cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"c"+ConstantMgr.getCompanyCode(),       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			      for(j=0; j<subColNo; j++)
			    	  cols.push({Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"c"+aryCD[j],            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:1,   InsertEdit:1 });
			      
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"ioc_cd",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"bsa_op_cd",             KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			      cols.push({Type:"Text",      Hidden:1, Width:60,   Align:"Center",  ColMerge:1,   SaveName:"n1st_port_etd_dt",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 });
			     
			      InitColumns(cols);
			      SetEditable(1);
//			      SetRangeBackColor(1, 14, 1, 14+subColNo, "#000000");
			      //FrozenCols =14;
			      
		      }
			  if(chkValue == "007"){
			      SetColHidden("free_add_wgt",0);
			      }
			  else if (chkValue != "008" && chkValue != "009"){
			      SetColHidden("free_add_wgt",1);			      
			      }
			  //SetCellBackColor(0,17+subColNo,"#BBBCE6");
			  //SetCellBackColor(0,17+subColNo,"#BBBCE6");
			  SetHeaderRowHeight(10);
			  SetSheetHeight(400);
			  
//				2014.10.23 김용습 - 헤더 색갈 및 툴팁 적용
				for(z=0; z<=cols.length; z++){
					
					if(GetCellValue(0,z) == "Other Carrier's 1st BSA"){
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "Other Carrier's 1st BSA");
					}else if(GetCellValue(0,z) == "Other Carrier's 2nd BSA Control (by VVD)"){
						SetCellBackColor(0, z, "#22741C");
						SetToolTipText(0, z, "Other Carrier's 2nd BSA Control (by VVD)");
					}else if(GetCellValue(0,z) == "RF"){ 
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "RF"); 
					}else if(GetCellValue(0,z) == "D2"){
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "D2");
					}else if(GetCellValue(0,z) == "D3"){
						SetCellBackColor(0, z, "99004C");
						SetToolTipText(0, z, "D3");
					}else if(GetCellValue(0,z) == "D4"){
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "D4");
					}else if(GetCellValue(0,z) == "D5"){
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "D5");
					}else if(GetCellValue(0,z) == "D7"){
						SetCellBackColor(0, z, "#99004C");
						SetToolTipText(0, z, "D7");
					}
				}
				
				SetEditArrowBehavior(3); 
				
      }
		break;
	}
}
/**
 * Description : Combo basic setting <br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * initCombo(comboObj, comboNo)
 * </pre>
 * 
 * @param {object}
 *            comboObj - Combo Object
 * @param {Number}
 *            comboNo - Combo Number
 * @see
 * @author
 * @version 2009.01.01
 */
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		SetDropHeight(300);
		comboObj.InsertItem(0, 'All', '');
//		Index = 0;
		SetSelectIndex(0);
		ValidChar(2,1);
	}
}
/**
 * Description : handling the process realated with sheet <br>
 * <br>
 * <b>Example : </b>
 * 
 * <pre>
 * doActionIBSheet(sheetObj, formObj, sAction)
 * </pre>
 * 
 * @param {object}
 *            sheetObj - Sheet Object
 * @param {form}
 *            formObj - From Object
 * @param {String}
 *            sAction - action kind
 * @see
 * @author
 * @version 2009.01.01
 */
function doActionIBSheet(sheetObj, formObj, sAction) {
	switch (sAction) {
	case IBSEARCH: // Retrieve
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
//		ComOpenWait(true);
		if (formObj.txtFmMonth.value != "" && formObj.txtFmMonth.value.length != 2)
			formObj.txtFmMonth.value = fillZero(formObj.txtFmMonth.value, 2,'0', 'left');
		if (formObj.txtToMonth.value != "" && formObj.txtToMonth.value.length != 2)
			formObj.txtToMonth.value = fillZero(formObj.txtToMonth.value, 2,'0', 'left');
		if (formObj.txtFmWeek.value != "" && formObj.txtFmWeek.value.length != 2)
			formObj.txtFmWeek.value = fillZero(formObj.txtFmWeek.value, 2, '0','left');
		if (formObj.txtToWeek.value != "" && formObj.txtToWeek.value.length != 2)
			formObj.txtToWeek.value = fillZero(formObj.txtToWeek.value, 2, '0', 'left');
		formObj.f_cmd.value = SEARCHLIST01;
		curPgmNo = "ESM_BSA_0104";
		//var sXml = sheetObj.GetSearchData("ESM_BSA_0104GS.do",bsaFormString(formObj, getParam2(curPgmNo)) );
		sheetObj.DoSearch("ESM_BSA_0104GS.do", bsaFormString(formObj, getParam2(curPgmNo)));
		break;
	case IBSAVE: // save
		if (!validateForm(sheetObj, formObj, sAction))
			return false;
		formObj.f_cmd.value = MULTI01;
		sheetObj.DoSave("ESM_BSA_0104GS.do", bsaFormString(formObj, getParam2(curPgmNo, 'S')), -1, true);		//SJH.20150210.MOD
		break;
	case IBDOWNEXCEL: // excel download		
		var excelType=selectDownExcelMethod(sheetObj);
		break;
	case IBRESET: // initializing creation data
		if (validateForm(sheetObj, formObj, sAction)) {
			if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { // Do you
																	// want to
																	// reset
																	// data?
				formObj.f_cmd.value = COMMAND01;
				sheetObj.DoSearch("ESM_BSA_0104GS.do", bsaFormString(formObj, getParam2(curPgmNo)));
				var err_cd = sheetObj.GetEtcData("err_cd");
				var err_msg = sheetObj.GetEtcData("err_msg");
				sheetObj.RemoveEtcData();
				if (err_cd == "00000") {
					ComShowMessage(ComGetMsg('BSA10018', 'RESET')); // msg1 + '
																	// process
																	// has been
																	// completed
																	// normally.'
				}
			}
		}
		break;
	}
}

//function callBackExcelMethod(excelType) {
//	 var sheetObj = sheet1;
//	 if(sheetObj.RowCount() < 1){//no data
//	  ComShowCodeMessage("COM132501");
//	  return;
//	 }
//	 switch (excelType) {
//	  case "AY":
//	   sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
//	   break;
//	  case "DY":
//	   sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
//	   break;
//	  case "AN":
//	   sheetObj.Down2Excel({ HiddenColumn:0});
//	   break;
//	  case "DN":
//	   sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 }); 
//	   break;
//	 }
//	}

function callBackExcelMethod(excelType){
	 var sheetObj = sheet1;
	 if(sheetObj.RowCount() < 1){//no data
	  ComShowCodeMessage("COM132501");
	  return;
	 }
      switch (excelType) {
      case "AY":
      	if(sheetObj.RowCount() < 1){//no data
      		ComShowCodeMessage("COM132501");
      		}else{
//      			sheetObj.Down2Excel({ HiddenColumn:0,Merge:true});
      			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
      		}      	
          break;
      case "DY":
      	if(sheetObj.RowCount() < 1){//no data
      		ComShowCodeMessage("COM132501");
      		}else{
//      			sheetObj.Down2Excel({ HiddenColumn:-1,Merge:true});
      			sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
      		}      	
          break;
      case "AN":
      	if(sheetObj.RowCount() < 1){//no data
      		ComShowCodeMessage("COM132501");
      		}else{
//      			sheetObj.Down2Excel({ HiddenColumn:0});
      			sheetObj.Down2Excel({ DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1});
      		}      	
          break;
      case "DN":
      	if(sheetObj.RowCount() < 1){//no data
      		ComShowCodeMessage("COM132501");
      		}else{
//      			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1,Merge:1 });
      			sheetObj.Down2Excel( {DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0} );
      		}      	
          break;
  }           
}
/**
 * Opening the popup window in case rdoOpJob is BSA(007)
 */
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObj = document.form;
	var selColName = sheetObj.ColSaveName(col);
	if (sheetObj.GetCellValue(row, "bsa_zr_flg") == "N") {
		if (selColName == 'spc_otr_swap_flg') {// swap popup open
			// 2008.01.15 modifying for free addtion in other type size except
			// Weight Per TEU(008),TTL Weight(009)
			if (!formObj.rdoOpJob[1].checked && !formObj.rdoOpJob[2].checked) {
				var pPort_etd_dt = sheetObj.GetCellValue(row, "n1st_port_etd_dt");
				var pTrd_cd = sheetObj.GetCellValue(row, "trd_cd");
				var pRlane_cd = sheetObj.GetCellValue(row, "rlane_cd");
				var pVsl_cd = sheetObj.GetCellValue(row, "vsl_cd");
				var pSkd_voy_no = sheetObj.GetCellValue(row, "skd_voy_no");
				var pDir_cd = sheetObj.GetCellValue(row, "skd_dir_cd");
				var pBsa_op_jb_cd = "";
				var selRow = row;
				for (k = 0; k < formObj.rdoOpJob.length; k++) {
					if (formObj.rdoOpJob[k].checked)
						pBsa_op_jb_cd = formObj.rdoOpJob[k].value;
				}
				var param = "?pPort_etd_dt=" + pPort_etd_dt + "&pTrd_cd="
						+ pTrd_cd + "&pRlane_cd=" + pRlane_cd + "&pVsl_cd="
						+ pVsl_cd + "&pSkd_voy_no=" + pSkd_voy_no + "&pDir_cd="
						+ pDir_cd + "&f_cmd=&sRow=" + selRow
						+ "&pBsa_op_jb_cd=" + pBsa_op_jb_cd;
				ComOpenWindow("ESM_BSA_0121.do" + param, '', 'width=800,height=420,menubar=0,status=0,scrollbars=0,resizable=0', false);
			}
		} else if (selColName == 'vsl_cd' || selColName == 'skd_voy_no' || selColName == 'skd_dir_cd') { // BSA popup screen by
			// vessle
			var param = "";
			param += "?s_cost_yrwk=" + sheetObj.GetCellValue(row, "cost_yrwk");
			param += "&s_trd_cd=" + sheetObj.GetCellValue(row, "trd_cd");
			param += "&s_rlane_cd=" + sheetObj.GetCellValue(row, "rlane_cd");
			param += "&s_ioc_cd=" + sheetObj.GetCellValue(row, "ioc_cd");
			param += "&s_vsl_cd=" + sheetObj.GetCellValue(row, "vsl_cd");
			param += "&s_skd_voy_no="
					+ sheetObj.GetCellValue(row, "skd_voy_no");
			param += "&s_skd_dir_cd="
					+ sheetObj.GetCellValue(row, "skd_dir_cd");
			param += "&" + bsaFormString(formObj, getParam2(curPgmNo));
			myOption="dialogWidth:1200px;dialogHeight:670px;help:no;status:no;resizable:no;scroll=no;";
			ComOpenWindow("ESM_BSA_0143.do" + param, window,  myOption , true);

		}
		// Changing the color by double-clicking ( changing to blue)
		makeLink(sheetObj);
	}
}
/**
 * not inputing in case of Info only in master(if status = "Ins")
 */
function sheet1_OnSearchEnd(sheetObj, code, errMsg) {
	ComOpenWait(false);
	var insStatus = sheetObj.FindStatusRow("I");
	var arrRows = insStatus.split(";");
	var formObj = document.form;
	var chkValue = "";
	for (k = 0; k < formObj.rdoOpJob.length; k++) {
		if (formObj.rdoOpJob[k].checked)
			chkValue = formObj.rdoOpJob[k].value;
	}
	if (formObj.rdoOpJob[1].checked) {// 008 Weight Per TEU
		sheetObj.SetEditable(0);
	} else {
		sheetObj.SetEditable(1);
		// not permit inputting it in case it doesn't exist in
		// coa_bsa_vvd_otr_crr
		// --------------------------------------------
		for (k = 0; k < arrRows.length - 1; k++) {
			sheetObj.SetRowEditable(arrRows[k], 0);
		}
	}
	// ---------------------------------------------------------------------------------------------------
	sheetObj.SetSumText(0, "");
	sheetObj.SetSumText(2, "TOTAL");
	// Making the column hidden in case isExcludZero is checked and total value
	// is zero.

	if (document.form.isExcludZero.checked) {
//		sheetObj.SetFrozenCol(1);
		sheetObj.RenderSheet(0);
		var count = 0;
		for ( var k = 0; k <= sheetObj.LastCol()-3; k++) {
			/*if(sheetObj.ColSaveName(k)=="ioc_cd" || sheetObj.ColSaveName(k)== "bsa_op_cd" || sheetObj.ColSaveName(k)== "n1st_port_etd_dt" || sheetObj.ColSaveName(k)== "spc_otr_swap_flg"){
				sheetObj.SetColWidth("spc_otr_swap_flg",70);
				break;
			}*/  // 무조건 3개의 컬럼은 속성 변화 없음
			
			
			if(sheetObj.ColSaveName(k)== "spc_otr_swap_flg"){
				//sheetObj.SetColWidth("spc_otr_swap_flg",70);
				break;
			}
			
			if(parseFloat(sheetObj.GetSumValue(0, k)) == 0.00 ) {
				sheetObj.SetColHidden(k, 1);
				
				sheetObj.SetColWidth(k,0);
			} else if (parseFloat(sheetObj.GetSumValue(0, k)) != 0.00) {
				sheetObj.SetColHidden(k, 0);
				//sheetObj.SetColWidth(k,60);
				count = k ;
			}
		}
		sheetObj.RenderSheet(1);
		if(count > 14){
			sheetObj.SetFrozenCol(14);
		}

	} else {
		sheetObj.SetFrozenCol(14);
		sheetObj.RenderSheet(0);
		for ( var k = 0; k <= sheetObj.LastCol()-3; k++) {
/*			if(sheetObj.ColSaveName(k)=="ioc_cd" || sheetObj.ColSaveName(k)== "bsa_op_cd" || sheetObj.ColSaveName(k)== "n1st_port_etd_dt"|| sheetObj.ColSaveName(k)== "spc_otr_swap_flg"){
				sheetObj.SetColWidth("spc_otr_swap_flg",70);
				break;
			} // 무조건 3개의 컬럼은 속성 변화 없음
			else*/
			
//			2014.11.10 김용습 - 조회 후에도 'Company 2nd BSA (SPC control)' 헤더의 넓이가 강제로 60으로 설정되지 않도록 함
			if(k>13){
				if(sheet1.GetCellValue(0,k) != "Company 2nd BSA\n(SPC control)"){
					sheetObj.SetColWidth(k,60);
				}
			}				
			
			if(sheetObj.ColSaveName(k)== "spc_otr_swap_flg"){
				//sheetObj.SetColWidth("spc_otr_swap_flg",70);
				break;
			}
			
			if(parseFloat(sheetObj.GetSumValue(0, k)) == 0.00  ) {
				sheetObj.SetColHidden(k, 0);
				//sheetObj.SetColWidth(k,60);
				if (chkValue == "007") {
					sheetObj.SetColHidden("free_add_wgt", 0);
				} else if (chkValue != "008" && chkValue != "009") {
					sheetObj.SetColHidden("free_add_wgt", 1);
				}
			}
		}
		sheetObj.RenderSheet(1);
	}
	
	// Changing the color and font of vvd column and swap_notice
	makeLink(sheetObj);
}
/**
 * Changing curser shape
 */
function sheet1_OnMouseMove(sheetObj, button, shift, x, y) {
	// var row = sheetObj.MouseRow ;
	var mouseColName = sheetObj.ColSaveName(sheetObj.MouseCol());
	if (mouseColName == 'vsl_cd' || mouseColName == 'skd_voy_no'
			|| mouseColName == 'skd_dir_cd'
			|| mouseColName == 'spc_otr_swap_flg') {
		sheetObj.SetMousePointer("Hand");
	} else {
		sheetObj.SetMousePointer("Default");
	}
}
/**
 * Changing the color and font of vvd column and swap_notice
 */
function makeLink(sheetObj) {
	sheetObj.SetColFontColor("vsl_cd", "#0000FF");
	sheetObj.SetColFontColor("skd_voy_no", sheetObj.GetColFontColor("vsl_cd"));
	sheetObj.SetColFontColor("skd_dir_cd", sheetObj.GetColFontColor("vsl_cd"));
	sheetObj.SetColFontUnderline("vsl_cd", 1);
	sheetObj.SetColFontUnderline("skd_voy_no", 1);
	sheetObj.SetColFontUnderline("skd_dir_cd", 1);
	if (!document.form.rdoOpJob[1].checked && !document.form.rdoOpJob[2].checked) {
		sheetObj.SetColFontColor("spc_otr_swap_flg", "#0000FF");
		sheetObj.SetColFontUnderline("spc_otr_swap_flg", 1);
	}
}
/**
 * setting modified Info in grid on 121 screen
 */
function changeRow(row, crr_cd, sls_teu, pur_teu, slt_swa_teu) {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	sheetObj.SetCellValue(row, "sls" + crr_cd, parseInt(sls_teu));
	sheetObj.SetCellValue(row, "pur" + crr_cd, parseInt(pur_teu));
	sheetObj.SetCellValue(row, "slt" + crr_cd, parseInt(slt_swa_teu));
}
/**
 * saving modified Info on 121 screen and Info on parent screen at once
 */
function parentExecute() {
	var sheetObj = sheetObjects[0];
	var formObj = document.form;
	if (!validateForm(sheetObj, formObj, IBSAVE))
		return false;
	formObj.f_cmd.value = MULTI01;
	sheetObj.DoSave("ESM_BSA_0104GS.do", bsaFormString(formObj, getParam(curPgmNo)), "", true);		//SJH.20150210.MOD
}
/**
 * Initializing Sheet and changing header
 */
function chgOptionJob(value) {
	var formObj = document.form;
	// var sStatus = sheetObj.FindStatusRow("U");
	// ComShowMessage(sStatus);
	// return false;
	// if(sStatus != ""){
	// ComShowMessage(ComGetMsg());
	// }
	vHeader = value;
	// ----------------------------------------------
	sheetObjects[0] = sheetObjects[0].Reset();
	ComConfigSheet(sheetObjects[0]);
	initSheet(sheetObjects[0], 1, formObj.header.value);
	ComEndConfigSheet(sheetObjects[0]);
	// ----------------------------------------------
	if (formObj.txtYear.value != "")
		doActionIBSheet(sheetObjects[0], formObj, IBSEARCH);
	
//    2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
    document.getElementById("div_zoom_in").style.display="none";
    document.getElementById("div_zoom_out").style.display="inline";
//	div_zoom_in.style.display = "none";
//	div_zoom_out.style.display = "inline";

    resizeSheet();
}
/**
 * showing R.Lane with iframe
 */
function cobTrade_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	if (loadingMode == true)
		return;
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var param = "";
	var trd_cd = "";
	if (comboObj.GetSelectText() != "") {
		trd_cd = comboObj.GetSelectCode();
		param = "f_cmd=" + SEARCHLIST01;
		param = param + "&trd_cd=" + trd_cd;
		param = param + "&code=rLane";
		var sXml = sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
		var arrXml = sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobLane, "code", "code");
		cobLane.SetSelectIndex(0);
	}
}
/**
 * Changing period in case of changing month and week
 * 
 */
function setPeriod(obj) {
	var formObj = document.form;
	var sheetObj = sheetObjects[0];
	var param = "";
	var gubun = "";
	var fm_mon = "";
	var to_mon = "";
	var fm_wk = "";
	var to_wk = "";
	if (obj.value == "") {// Clearing from-data in case to-data is empty.
		if (obj.name == "txtToMonth") {
			formObj.txtFmMonth.value = "";
		} else if (obj.name == "txtToWeek") {
			formObj.txtFmWeek.value = "";
		}
		return false;
	} 
//	2014.11.26 김용습 - from 정보를 수정했을 때에도 화면에 날짜로 계산되어 보여지도록 하는 것이 더 옳다고 생각되어, 아래 부분 주석처리 합니다
//	else { // Skipping it in case data exist when focusing out from
//				// from_column.
//		if (obj.name == "txtFmMonth")
//			return false;
//		if (obj.name == "txtFmWeek")
//			return false;
//	}
	if (chkValidSearch()) {
		if (formObj.txtFmMonth.value != "" && formObj.txtFmWeek.value != "") {
			gubun = "5";
		} else if (formObj.txtFmMonth.value == ""
				&& formObj.txtFmWeek.value != "") {
			gubun = "4";
		} else if (formObj.txtFmMonth.value != ""
				&& formObj.txtFmWeek.value == "") {
			gubun = "3";
		}
		formObj.param2.value = formObj.txtYear.value;
		if (formObj.chkPrd[0].checked) {
			formObj.param5.value = "";
			formObj.param6.value = "";
			formObj.param7.value = formObj.txtFmWeek.value;
			formObj.param8.value = formObj.txtToWeek.value;
			fm_wk = formObj.txtFmWeek.value;
			to_wk = formObj.txtToWeek.value;
		} else {
			formObj.param5.value = formObj.txtFmMonth.value;
			formObj.param6.value = formObj.txtToMonth.value;
			formObj.param7.value = "";
			formObj.param8.value = "";
			fm_mon = formObj.txtFmMonth.value;
			to_mon = formObj.txtToMonth.value;
		}
		param = param + "f_cmd=" + SEARCHLIST02;
		param = param + "&gubun=" + gubun;
		param = param + "&fm_mon=" + fm_mon;
		param = param + "&to_mon=" + to_mon;
		param = param + "&fm_wk=" + fm_wk;
		param = param + "&to_wk=" + to_wk;
		param = param + "&year=" + eval(formObj.txtYear.value);
		param = param + "&code=period";
		var sXml = sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
		var period = GetEtcDataForExceptional(sXml, "period", "0");
		document.getElementById("div_period").innerHTML = "<div id=\"div_period\">(" + period + ")</div>";
	}
}
/**
 * Checking mandatory input in case of searching
 */
function chkValidSearch() {
	var formObj = document.form;
	with (formObj) {
		if (txtYear.value == "") {
			ComShowMessage(ComGetMsg("COM12114", "Year", ""));
			//txtYear.focus();
			return false;
		}
		if (txtFmMonth.value != "" && txtToMonth.value == "") {
			ComShowMessage(ComGetMsg("COM12114", "month", ""))
			//txtToMonth.focus();
			return false;
		}
		if (txtFmMonth.value == "" && txtToMonth.value != "") {
			ComShowMessage(ComGetMsg("COM12114", "month", ""));
			//txtFmMonth.focus();
			return false;
		}
		// if (txtFmMonth.value != "" && txtToMonth.value != "") {
		// if(txtFmMonth.value > txtToMonth.value){
		// ComShowMessage(ComGetMsg("COM12133","from Month"," to
		// Month","smaller"));
		// txtFmMonth.value = "";
		// txtToMonth.value = "";
		// txtFmMonth.focus();
		// return false;
		// }
		// }
		if (txtFmWeek.value != "" && txtToWeek.value == "") {
			ComShowMessage(ComGetMsg("COM12114", "week", ""));
			//txtToWeek.focus();
			return false;
		}
		if (txtFmWeek.value == "" && txtToWeek.value != "") {
			ComShowMessage(ComGetMsg("COM12114", "week", ""));
			//txtFmWeek.focus();
			return false;
		}
		if (txtFmMonth.value == "" && txtFmWeek.value == "") {
			// ComShowMessage(ComGetMsg("COM12138", "month", "week"));
			return false;
		}
		if (!isValidYear(txtYear, false, true))
			return false;
		if (!isValidMonth(txtFmMonth, false, true))
			return false;
		if (!isValidMonth(txtToMonth, false, true))
			return false;
		if (!isValidWeek(txtFmWeek, false, true))
			return false;
		if (!isValidWeek(txtToWeek, false, true))
			return false;
	}
	return true;
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj, formObj, sAction) {
	with (formObj) {
		// if(!chkValidSearch()) return false;
		if (txtYear.value == "") {
			ComShowMessage(ComGetMsg("COM12114", "Year", ""));
			//txtYear.focus();
			return false;
		}
		if (txtFmMonth.value == "" && txtFmWeek.value == "") {
			ComShowMessage(ComGetMsg("COM12138", "month", "week"));
			return false;
		}
		if ((chkPrd[1].checked && txtFmMonth.value == "" && txtToMonth.value == "")
				&& txtVsl_cd.value == ""
				&& txtSkd_voy_no.value == ""
				&& txtDir_cd.value == "") {
			ComShowMessage(ComGetMsg("COM12138", "Month", "VVD"));
			return false;
		}
		if ((chkPrd[0].checked && txtFmWeek.value == "" && txtToWeek.value == "")
				&& txtVsl_cd.value == ""
				&& txtSkd_voy_no.value == ""
				&& txtDir_cd.value == "") {
			ComShowMessage(ComGetMsg("COM12138", "Week", "VVD"));
			return false;
		}
		// if(formObj.cobTrade.value == "" && formObj.txtVsl_cd.value == ""){
		// ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
		//    	            return false;
		//    	        }
		//    	        
		//	            if(formObj.cobLane.value == "" && formObj.txtVsl_cd.value == ""){
		//	                ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
		//	                return false;
		//	            }
		if (chkPrd[1].checked && txtFmMonth.value != ""
				&& txtToMonth.value != "") {
			if (ComParseInt(txtFmMonth.value) > ComParseInt(txtToMonth.value)) {
				ComAlertFocus(txtToMonth, ComGetMsg('BSA10011', 'Month',
						'First Element', 'Second Element'));
				return false;
			}
		}
		if (chkPrd[0].checked && txtFmWeek.value != "" && txtToWeek.value != "") {
			if (ComParseInt(txtFmWeek.value) > ComParseInt(txtToWeek.value)) {
				ComAlertFocus(txtToWeek, ComGetMsg('BSA10011', 'Week',
						'First Element', 'Second Element'));
				return false;
			}
		}
	}
	return true;
}
//CalcLogic:"cluSecondFinal(|fnl_co_bsa_capa|, "+sls+", "+pur+", "+slt+", |free_add_teu_capa|)"
//clu2ndFinal="|fnl_co_bsa_capa|-("+sls+")+("+pur+")+("+slt+")+|free_add_teu_capa|";
function cluSecondFinal(fnl_co_bsa_capa, sls, pur, slt, free_add_teu_capa){
	return fnl_co_bsa_capa - sls + pur + slt + free_add_teu_capa;
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}
