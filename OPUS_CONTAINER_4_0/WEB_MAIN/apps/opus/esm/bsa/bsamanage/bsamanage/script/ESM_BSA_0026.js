/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0026.js
*@FileTitle  : Inquire/Edit Step-up/Down by Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================
*/

var sheetObjects=new Array();
var sheetCnt=0;
var sheet_selno=""; //selected current SHEET
var JOINT_OPERATING="";
var SPACE_CHARTERING="";
var selRow=0;
var selValue="";
var sheet_height=20; // sheet height
var comboObjects=new Array();
var comboCnt=0;
var loadingMode=false;
/* Event handler processing by button click event */
document.onclick=processButtonClick;
/* Event handler processing by button name */
function processButtonClick() {
	var formObject=document.form;
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	var m_SheetObj=sheetObjects[0]; // Master Sheet
	var d_SheetObj=sheetObjects[1]; // Detail Sheet
	if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
		m_SheetObj=sheetObjects[0];
		d_SheetObj=sheetObjects[1];
	} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
		m_SheetObj=sheetObjects[2];
		d_SheetObj=sheetObjects[3];
	}
	try {
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn_retrieve":
				doActionIBSheet(m_SheetObj,formObject,IBSEARCH);
				d_SheetObj.RemoveAll();
				setHeaderTitle(); // Header Setting
				break;
			case "btn_downexcel":				
	            doActionIBSheet(m_SheetObj,formObject,IBDOWNEXCEL);	            
				break;		
			case "btn_downexcel2":				
	            doActionIBSheet(d_SheetObj,formObject,IBDOWNEXCEL);	            
				break;	
			case "btns_calendar1":
				var cal=new ComCalendar();
				cal.select(formObject.txtSDate, 'yyyy-MM-dd');
				break;
			case "btns_calendar2":
				var cal=new ComCalendar();
				cal.select(formObject.txtEDate, 'yyyy-MM-dd');
				break;
			case "rdoOp_cd":
				if (formObject.rdoOp_cd[0].checked) { //in case of selecting JO
					document.getElementById("tabLayer1").style.display="inline";
					document.getElementById("tabLayer2").style.display="none";
//					document.getElementById("div_carrier").style.display = "inline";
					document.getElementById("div_zoom_in").style.display="inline";
					document.getElementById("div_zoom_out").style.display="none";
					sheet_selno=formObject.rdoOp_cd[0].value; //'J'
				} else if (formObject.rdoOp_cd[1].checked) {  //in case of selecting SC
					document.getElementById("tabLayer1").style.display="none";
					document.getElementById("tabLayer2").style.display="inline";
//					document.getElementById("div_carrier").style.display = "none";
					document.getElementById("div_zoom_in").style.display="inline";
					document.getElementById("div_zoom_out").style.display="none";
					sheet_selno=formObject.rdoOp_cd[1].value; //'S'
				}
				chgCarrier();
				setHeaderTitle(); // Header Setting
				resizeSheet();
				break;
			case "rdoType":
				setHeaderTitle();
				break;
			case "btng_save1":
			case "btng_save3":
				doActionIBSheet(m_SheetObj,formObject,IBSAVE);
				d_SheetObj.RemoveAll();
				break;
			case "btng_save2":
   				doActionIBSheet2(d_SheetObj,formObject,IBSAVE);
				break;
			case "btng_reset":
				doActionIBSheet(m_SheetObj,formObject,IBRESET);
				d_SheetObj.RemoveAll();
				break;
			case "btng_portadd":
				doActionIBSheet2(d_SheetObj,formObject,IBINSERT);
				break;
			case "btng_creation":
				doActionIBSheet2(d_SheetObj,formObject,IBCREATE);
				d_SheetObj.RemoveAll();
				break;
			case "bu_zoom_in":
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	            document.getElementById("div_zoom_in").style.display="none";
	            document.getElementById("div_zoom_out").style.display="inline";
//				div_zoom_in.style.display="none";
//				div_zoom_out.style.display="inline";
//				parent.syncHeight();
				
//				2014.10.21 김용습 - zoom 기능 수정(펼쳤을 때 시트의 높이가 모든 열의 높이의 합 + 150px이 되도록)
				if (formObject.rdoOp_cd[0].checked) { //in case of selecting JO
					var rowcount = sheet1.RowCount(); // 시트의 열 개수
					var totalrowheight = 0; // 총 열 높이의 합 초기화												
					for(y=0; y<=rowcount; y++){
						totalrowheight = totalrowheight + sheet1.GetRowHeight(y); // 모든 열의 높이의 합 구하기
					}			
					if(totalrowheight+150 > 425){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
						sheet1.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						sheet2.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
					}					
				} else if (formObject.rdoOp_cd[1].checked) {  //in case of selecting SC
					var rowcount = sheet3.RowCount(); // 시트의 열 개수
					var totalrowheight = 0; // 총 열 높이의 합 초기화												
					for(y=0; y<=rowcount; y++){
						totalrowheight = totalrowheight + sheet3.GetRowHeight(y); // 모든 열의 높이의 합 구하기
					}			
					if(totalrowheight+150 > 425){ // 모든 열의 높이의 합이 작아서 화면을 늘일 필요가 없는 경우가 아닐때만
						sheet3.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
						sheet4.SetSheetHeight(totalrowheight+150); // 모든 열의 높이의 합 + 150px을 시트 높이로 설정	
					}						
				}
				
				break;
			case "bu_zoom_out":
//	          2014.11.19 김용습 - 'tr_opt.style.display="none"'와 같은 형태의 코딩은 IE11에서 적용되지 않아 'document.getElementById("tr_opt").style.display="none"'와 같은 형태로 모두 변경합니다
	            document.getElementById("div_zoom_in").style.display="inline";
	            document.getElementById("div_zoom_out").style.display="none";
//				div_zoom_in.style.display="inline";
//				div_zoom_out.style.display="none";
//				parent.syncHeight();
				resizeSheet();
				break;
		} // end switch
	} catch(e) {
		if( e == "[object Error]") {
			ComShowMessage(OBJECT_ERROR);
		} else {
			ComShowMessage(e.message);
		}
	}
}
function loadPage() {
	for(i=0;i<sheetObjects.length;i++){
		ComConfigSheet(sheetObjects[i]);
		initSheet(sheetObjects[i],i+1);
		ComEndConfigSheet(sheetObjects[i]);
	}
	// Handling multi combo
	loadingMode=true;
	loadCombo();
	for(k=0;k<comboObjects.length;k++){
		initCombo(comboObjects[k],comboObjects[k].id);
		comboObjects[k].SetSelectIndex(0);
	}
	loadingMode=false;
	JOINT_OPERATING=document.form.rdoOp_cd[0].value;
	SPACE_CHARTERING=document.form.rdoOp_cd[1].value;
	document.getElementById("tabLayer2").style.display="none";
	//tabLayer2.style.display = "none";
	document.getElementById("div_carrier").style.display="inline";
	setHeaderTitle(); // Header Setting
	sheet_selno=JOINT_OPERATING; //selected current sheet (1st sheet)
    comboObjects[3].SetSelectCode(ConstantMgr.getCompanyCode());
    resizeSheet();
}
function loadCombo() {
	var formObj=document.form;
	var sXml=formObj.sXml.value;
	var arrXml=sXml.split("|$$|");
	var rtnArr=null;
	var divStr="";
	var codeArr=null;
	var nameArr=null;
	var checked="";
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], cobTrade, "code", "code");
	if (arrXml.length > 1)
		ComXml2ComboItem(arrXml[1], cobLane, "code", "code");
	if (arrXml.length > 2)
		ComXml2ComboItem(arrXml[2], cobDir, "code", "code");
	if (arrXml.length > 3){
		ComXml2ComboItem(arrXml[3], cobCarrier, "code", "code");
	}
	// JO/SC CheckBox Setting
	if (arrXml.length > 4){
		rtnArr=ComXml2ComboString(arrXml[4], "code", "name");
		codeArr=rtnArr[0].split("|");
		nameArr=rtnArr[1].split("|");
		for(var i=0; i<codeArr.length; i++){
			if (i == 0)
				checked="checked";
			else
				checked="";
			divStr += "\n";
			divStr += "<input type=\"radio\" name=\"rdoOp_cd\" id=\"rdoOp_cd"+[i]+"\" value=\""+codeArr[i]+"\" class=\"trans\""+checked+">"+nameArr[i]+"</input>";
			if(i < codeArr.length)
				divStr += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		document.getElementById("div_bsaKind").innerHTML="<div id=\"div_bsaKind\">"+ divStr +"</div>";
	}
	if (arrXml.length > 5){
		rtnArr=ComXml2ComboString(arrXml[5], "code", "name");
		codeArr=null;
		nameArr=null;
		codeArr=rtnArr[0].split("|");
		nameArr=rtnArr[1].split("|");
		divStr="";
		for(var i=0; i<codeArr.length; i++){
			if (i == 0)
				checked="checked";
			else
				checked="";
			divStr += "\n";
			divStr += "<input type=\"radio\" name=\"rdoType\" value=\""+codeArr[i]+"\" text=\""+nameArr[i]+"\" class=\"trans\""+checked+">"+nameArr[i]+"</input>";
			if(i < codeArr.length)
				divStr += "&nbsp;&nbsp;&nbsp;";
		}
//		2014.12.26 김용습- 화면의 BSA, Slot Price, Weight Limit 라디오 버튼을 보여주는 부분이나 주석처리하고, 같은 기능을 jsp에 구현함
//		document.getElementById("div_ui_port").innerHTML="<div id=\"div_ui_port\">"+ divStr +"</div>";
	}
	document.form.sXml.value="";
 }
function setSheetObject(sheet_obj) {
	sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* registering IBCombo Object as list
* adding process for list in case of needing batch processing with other items
* defining list on the top of source
*/
function setComboObject(combo_obj){
   comboObjects[comboCnt++]=combo_obj;
}
/**
* Setting data in combo column of IBSheet. <br>
*/
function setIBMultiCombo(sheetObj, sXml ,objName){
	if (sXml == undefined || sXml == ""){
		return;
	}
	var arrData=ComCoaXml2SheetMultiComboString(sXml, "code", "code");
	sheetObj.SetColProperty(objName, {ComboText:arrData[1], ComboCode:arrData[0]} );
}
/**
* Setting combo item
*/
function initCombo (comboObj, comboNo) {
	 with (comboObj) {
	  	 SetDropHeight(300);
	  	 if( comboObj.options.id == "cobCarrier"){
	  		comboObj.SetBackColor("#CCFFFD");
	  	 } else {
	  		 comboObj.InsertItem(0, 'All' ,'All'); 
	  	 }
	  	 Index=0;  	 
	  	 
	  	 ValidChar(2,1);
	 }
}
/**
* setting sheet initial values and header
* param : sheetObj, sheetNo
* adding case as numbers of counting sheets
 */
function initSheet(sheetObj,sheetNo) {
	var formObject=document.form;
	var cnt=0;
	switch(sheetNo) {
		case 1:      //sheet1 init
			with (sheetObj) {
			var HeadTitle="STS|SEQ|From|To|Trade|R.Lane|Dir.|OPR|BSA Capa.|Opr|Opr Job|Carrier|Flg|Company";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"M_ibflag" },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:1,   SaveName:"M_vop_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Int",       Hidden:0,  Width:65,   Align:"Right",   ColMerge:1,   SaveName:"M_vsl_capa",      KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_op_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_op_jb_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_crr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_stup_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"M_crr_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			 
			InitColumns(cols);
			SetSheetHeight(420);
			SetEditable(1);
			
			SetEditArrowBehavior(3); 
			
			}
			break;
		case 2:      //sheet2 init
			with (sheetObj) {
			var HeadTitle="DEL|STS|BSA SEQ|Trade|R.Lane|Dir.|OPR|BSA capa.|Opr|Opr Job|Carrier|SEQ|Port|BSA(TEU)";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"", HeaderCheck:0 },
			             {Type:"Status",    Hidden:0, Width:45,   Align:"Center",  ColMerge:0,   SaveName:"D_ibflag" },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"D_bsa_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_vop_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"D_vsl_capa",       KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_bsa_op_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_bsa_op_jb_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_crr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,  Align:"Center",  ColMerge:0,   SaveName:"D_port_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			             //20151209.MOD : AcceptKeys E->N,E
			             {Type:"Text",      Hidden:0,  Width:65,  Align:"Center",  ColMerge:0,   SaveName:"D_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },
			             {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"D_port_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:25 } ];
			 
			InitColumns(cols);
			SetSheetHeight(420);
			SetEditable(1);
//			SetGetCountPosition()(0);

			SetEditArrowBehavior(3); 

			}
			break;
		case 3:      //sheet3 init
			with (sheetObj) {
			var HeadTitle="STS|SEQ|From|To|Trade|R.Lane|Dir.|Seq|VSL Code|Opr|Opr Job|Carrier|Flg|Final Company BSA";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"M_ibflag" },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_fm_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Date",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"M_bsa_to_dt",     KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:1,   SaveName:"M_trd_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_rlane_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_dir_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_vsl_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"M_vsl_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_op_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_bsa_op_jb_cd",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"M_crr_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"M_stup_flg",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"AutoSum",   Hidden:0, Width:80,   Align:"Right",   ColMerge:1,   SaveName:"M_crr_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];	//20150721.MOD
			  
			InitColumns(cols);
			SetSheetHeight(420);
			SetEditable(1);
			
			SetEditArrowBehavior(3); 
			
			}
			break;
		case 4:      //sheet4 init
			with (sheetObj) {
			var HeadTitle="DEL|STS|BSA Seq|From|Trade|R.Lane|Dir.|VSL SEQ|VSL Code|Opr|Opr Job|Carrier|SEQ|Port|BSA(TEU)";

			SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:0 } );

			var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			var headers = [ { Text:HeadTitle, Align:"Center"} ];
			InitHeaders(headers, info);

			var cols = [ {Type:"DelCheck",  Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"" },
			             {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"D_ibflag" },
			             {Type:"Text",      Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"D_bsa_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_bsa_fm_dt",      KeyField:0,   CalcLogic:"",   Format:"Ymd",         PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_trd_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_rlane_cd",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_dir_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:30,   Align:"Center",  ColMerge:1,   SaveName:"D_vsl_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:70,   Align:"Center",  ColMerge:1,   SaveName:"D_vsl_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_bsa_op_cd",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_bsa_op_jb_cd",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"D_crr_cd",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			             {Type:"Text",      Hidden:0,  Width:40,   Align:"Center",  ColMerge:0,   SaveName:"D_port_seq",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0,   EditLen:3 },
			             //20151209.MOD : AcceptKeys E->N,E
			             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:0,   SaveName:"D_port_cd",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1,   EditLen:5, AcceptKeys:"N|E", InputCaseSensitive:1 },	
			             {Type:"AutoSum",   Hidden:0, Width:75,   Align:"Right",   ColMerge:0,   SaveName:"D_port_bsa_capa",  KeyField:0,   CalcLogic:"",   Format:"Integer",     PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
			 
			InitColumns(cols);
			SetSheetHeight(420);
			SetEditable(1);
			
			SetEditArrowBehavior(3); 
			
			}
			break;
	}
}

//function sheet1_OnDownFinish(sheetObj , downloadType, result) {
//
//	sheet2.SetWaitImageVisible(0);
//
//	if(sheet2.GetCellValue(1,1)!=""){
//		selectDownExcelMethod(sheet2,1);
//	}	
//	
////	2014.11.11 김용습 - 시트 2개 띄워져 있을 때 Down Excel시 2가지 시트 동시에 다운로드 되도록 수정
////	switch (excelTypeGubun) {
////    case "AY":
////		    	if (sheet2.RowCount()> 0) {
////		    		sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
////           }
////        break;
////    case "DY":  		    	
////			if (sheet2.RowCount()> 0) {
////				sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
////			}
////        break;
////    case "AN":  		    	
////			if (sheet2.RowCount()> 0) {
////				sheet2.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
////			}
////        break;
////    case "DN":  		    	
////			if (sheet2.RowCount()> 0) {
////				sheet2.Down2Excel( { HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' } );
////			}
////        break;
////	 }  
//	
//    sheet2.SetWaitImageVisible(1);	
//}

//function sheet3_OnDownFinish(sheetObj , downloadType, result) {
//
//	sheet4.SetWaitImageVisible(0);	
//	
//	if(sheet4.GetCellValue(4,1)!=""){
//		selectDownExcelMethod(sheet4,3);
//	}
////	2014.11.11 김용습 - 시트 2개 띄워져 있을 때 Down Excel시 2가지 시트 동시에 다운로드 되도록 수정
////	switch (excelTypeGubun) {
////    case "AY":
////		    	if (sheet4.RowCount()> 0) {
////		    		sheet4.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
////           }
////        break;
////    case "DY":  		    	
////			if (sheet4.RowCount()> 0) {
////				sheet4.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N'});
////			}
////        break;
////    case "AN":  		    	
////			if (sheet4.RowCount()> 0) {
////				sheet4.Down2Excel({ HiddenColumn:1, SheetDesign:1, Merge:1, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' });
////			}
////        break;
////    case "DN":  		    	
////			if (sheet4.RowCount()> 0) {
////				sheet4.Down2Excel( { HiddenColumn:1, SheetDesign:0, Merge:0, CheckBoxOnValue:'Y', CheckBoxOffValue:'N' } );
////			}
////        break;
////	 } 
//	
//	sheet4.SetWaitImageVisible(1);
//}

//2014.12.30 김용습 - 첫번째 시트 엑셀다운 용
function callBackExcelMethod(excelType){
	excelTypeGubun = excelType[0];
	var sheetObj = sheetObjects[excelType[1]];
	var formObject=document.form;
	if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
        switch (excelType[0]) {
        case "AY":
        	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
        	break;
        case "AN":
        	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
        	break;
        case "DY":
        	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
        	break;
        case "DN":
        	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
        	break;
        }               
	} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet        
        switch (excelType[0]) {
        case "AY":
        	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
        	break;
        case "AN":
        	sheetObj.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
        	break;
        case "DY":
        	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:1, Merge:1 });
        	break;
        case "DN":
        	sheetObj.Down2Excel({DownCols: makeHiddenSkipCol(sheetObj), SheetDesign:0, Merge:0 });
        	break;
        }
	}
}

//2014.12.30 김용습 - 두번째 시트 엑셀다운 용
function callBackExcelMethod2(excelType){
	excelTypeGubun = excelType[0];
	var sheetObj = sheetObjects[excelType[1]];
	var formObject=document.form;
	if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
        switch (excelType[0]) {
        case "AY":
        	sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
        	break;
        case "AN":
        	sheet2.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
        	break;
        case "DY":
        	sheet2.Down2Excel({DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1, Merge:1 });
        	break;
        case "DN":
        	sheet2.Down2Excel({DownCols: makeHiddenSkipCol(sheet2), SheetDesign:0, Merge:0 });
        	break;
        }               
	} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet        
        switch (excelType[0]) {
        case "AY":
        	sheet4.Down2Excel({ HiddenColumn:0, SheetDesign:1, Merge:1});
        	break;
        case "AN":
        	sheet4.Down2Excel({ HiddenColumn:0, SheetDesign:0, Merge:0});
        	break;
        case "DY":
        	sheet4.Down2Excel({DownCols: makeHiddenSkipCol(sheet4), SheetDesign:1, Merge:1 });
        	break;
        case "DN":
        	sheet4.Down2Excel({DownCols: makeHiddenSkipCol(sheet4), SheetDesign:0, Merge:0 });
        	break;
        }
	}
}

// handling the process realated with sheet
function doActionIBSheet(sheetObj,formObj,sAction) {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	sheetObj.ShowDebugMsg(false);
    formObj.target="";
	switch(sAction) {
		case IBSEARCH:
			if (!validateCond(formObj,sAction)) {
				return false;
			}
			ComOpenWait(true);
			setTimeout( function(){
				if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
	    			formObj.f_cmd.value=SEARCHLIST01;
	     			sheetObj.DoSearch("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)) ,{Sync:2} );
				} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
	    			formObj.f_cmd.value=SEARCHLIST03;
	     			sheetObj.DoSearch("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo))  ,{Sync:2});
				}
				ComOpenWait(false);
			}, 100);
			break;
		case IBDOWNEXCEL:   //excel download
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
//				var excelType=selectDownExcelMethod(sheetObj,0);
				if(sheetObj == sheetObjects[0]){
    				var excelType=selectDownExcelMethod(sheetObj,0);  
    			}else if(sheetObj == sheetObjects[1]){
    				var excelType=selectDownExcelMethod2(sheetObj,1);    
    			} 
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
//				var excelType=selectDownExcelMethod(sheetObj,2);
				if(sheetObj == sheetObjects[2]){
    				var excelType=selectDownExcelMethod(sheetObj,2);  
    			}else if(sheetObj == sheetObjects[3]){
    				var excelType=selectDownExcelMethod2(sheetObj,3);    
    			} 
			}
			break;
		case IBSAVE:        // Master save
			if (!validateForm(sheetObj)) {
				return false;
			}
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    			if (sheetObj.RowCount()> 0) {
    				formObj.f_cmd.value=MULTI01;
    				sheetObj.DoSave("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    			if (sheetObj.RowCount()> 0) {
    				formObj.f_cmd.value=MULTI03;
    				sheetObj.DoSave("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
    			}
			}
			
//			2015.06.06 김용습 - 저장 완료 메시지 추가
//			ComShowCodeMessage("BSA10047");
			
			break;
		case IBRESET:      //RESET
			if (!validateCond(formObj,sAction)) {
				return false;
			}
			if (ComShowConfirm(ComGetMsg('BSA10021')) == true) { //Do you want to reset data?
    			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    				formObj.f_cmd.value=MODIFY01;
    				var sXml=sheetObj.GetSaveData("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)) );
    				sheetObj.LoadSaveData(sXml);
//    				if (ComBsaErrMessage(sheetObj, sXml)) {
        			    formObj.f_cmd.value=SEARCHLIST01;
         			    sheetObj.DoSearch("ESM_BSA_0026GS.do", bsaFormString(formObj,getParam(curPgmNo)) );
//    				}

    			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    				formObj.f_cmd.value=MODIFY02;
    				var sXml=sheetObj.GetSaveData("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo)) );
    				sheetObj.LoadSaveData(sXml);
//    				if (ComBsaErrMessage(sheetObj, sXml)) {
        			    formObj.f_cmd.value=SEARCHLIST03;
         			    sheetObj.DoSearch("ESM_BSA_0026GS3.do", bsaFormString(formObj,getParam(curPgmNo)) );
//    				}  

    			}
			}
			break;
	}
}
// handling the process realated with sheet
function doActionIBSheet2(sheetObj,formObj,sAction) {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	sheetObj.ShowDebugMsg(false);
	switch(sAction) {
		case IBSEARCH:      //Retrieve
		    var param="";
			//-----------------------------------------------------------------------------------------
			// Converting selected Info to Query String form with using RowSaveStr
			//-----------------------------------------------------------------------------------------
		    ComOpenWait(true);
			setTimeout( function(){
			    if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
	    			formObj.f_cmd.value=SEARCHLIST02;
	    			param=sheetObj.RowSaveStr(sheetObj.GetSelectRow());
	     			sheetObject2.DoSearch("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo)) +'&'+ param );
	     			sheetObject2.SetSumText("D_ibflag","TOTAL" );
				} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
	    			formObj.f_cmd.value=SEARCHLIST04;
	    			param=sheetObj.RowSaveStr(sheetObj.GetSelectRow());
	     			sheetObject4.DoSearch("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo)) +'&'+ param );
	     			sheetObject4.SetSumText("D_ibflag","TOTAL" );
				}
			    ComOpenWait(false);
			}, 100);			
			break;
		case IBINSERT:      // Add row
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    			if (sheetObject1.RowCount()> 0 && sheetObject1.GetSelectRow()> 0) {
        			var Row=sheetObj.DataInsert(-1);
        			sheetObj.SetCellValue(Row, "D_bsa_seq",ComTrimAll(sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_bsa_seq"), "-"),0);
        			//sheetObj.CellValue2(Row, "D_bsa_fm_dt")    = ComTrimAll(sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_fm_dt"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_to_dt")    = ComTrimAll(sheetObject1.CellValue(sheetObject1.SelectRow, "M_bsa_to_dt"), "-");
					sheetObj.SetCellValue(Row, "D_trd_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_trd_cd"),0);
					sheetObj.SetCellValue(Row, "D_rlane_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_rlane_cd"),0);
					sheetObj.SetCellValue(Row, "D_dir_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_dir_cd"),0);
					sheetObj.SetCellValue(Row, "D_vop_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_vop_cd"),0);
					sheetObj.SetCellValue(Row, "D_vsl_capa",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_vsl_capa"),0);
					sheetObj.SetCellValue(Row, "D_bsa_op_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_bsa_op_cd"),0);
					sheetObj.SetCellValue(Row, "D_bsa_op_jb_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_bsa_op_jb_cd"),0);
					sheetObj.SetCellValue(Row, "D_crr_cd",sheetObject1.GetCellValue(sheetObject1.GetSelectRow(), "M_crr_cd"),0);
        			sheetObj.SetCellValue(Row, "D_port_seq",Row,0);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    			if (sheetObject3.RowCount()> 0 && sheetObject3.GetSelectRow()> 0) {
        			var Row=sheetObj.DataInsert(-1);
        			sheetObj.SetCellValue(Row, "D_bsa_seq",ComTrimAll(sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_bsa_seq"), "-"),0);
        			//sheetObj.CellValue2(Row, "D_bsa_fm_dt")    = ComTrimAll(sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_fm_dt"), "-");
        			//sheetObj.CellValue2(Row, "D_bsa_to_dt")    = ComTrimAll(sheetObject3.CellValue(sheetObject3.SelectRow, "M_bsa_to_dt"), "-");
					sheetObj.SetCellValue(Row, "D_trd_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_trd_cd"),0);
					sheetObj.SetCellValue(Row, "D_rlane_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_rlane_cd"),0);
					sheetObj.SetCellValue(Row, "D_dir_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_dir_cd"),0);
					sheetObj.SetCellValue(Row, "D_vsl_seq",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_vsl_seq"),0);
					sheetObj.SetCellValue(Row, "D_bsa_op_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_bsa_op_cd"),0);
					sheetObj.SetCellValue(Row, "D_bsa_op_jb_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_bsa_op_jb_cd"),0);
					sheetObj.SetCellValue(Row, "D_crr_cd",sheetObject3.GetCellValue(sheetObject3.GetSelectRow(), "M_crr_cd"),0);
        			sheetObj.SetCellValue(Row, "D_port_seq",Row,0);
    			}
			}
			break;
		case IBSAVE:        //Detail 저장
			if (!validateDForm(sheetObj)) {				//20150826.ADD
				return false;
			}			
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    			if (sheetObj.RowCount()> 0) {
    				formObj.f_cmd.value=MULTI02;
    				sheetObj.DoSave("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    			if (sheetObj.RowCount()> 0) {
    				formObj.f_cmd.value=MULTI04;
    				sheetObj.DoSave("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo,'S')), -1, true);
    			}
			}
			
//			2015.06.06 김용습 - 저장 완료 메시지 추가
//			ComShowCodeMessage("BSA10047");
			
			break;
		case IBCREATE:      //생성
			if (!validateCond(formObj,sAction)) {
				return false;
			}
		    var param="";
			//-----------------------------------------------------------------------------------------
			//  Converting selected Info in master grid to Query String form with using RowSaveStr
			//-----------------------------------------------------------------------------------------
			if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    			if (sheetObject1.RowCount()> 0 && sheetObject1.GetSelectRow()> 0) {
        			formObj.f_cmd.value=MULTI05;
        			param=sheetObject1.RowSaveStr(sheetObject1.GetSelectRow());
         			sheetObj.DoSearch("ESM_BSA_0026GS2.do", bsaFormString(formObj,getParam(curPgmNo))+'&' + param ,{Sync:2} );
    			}
			} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    			if (sheetObject3.RowCount()> 0 && sheetObject3.GetSelectRow()> 0) {
        			formObj.f_cmd.value=MULTI06;
        			param=sheetObject3.RowSaveStr(sheetObject3.GetSelectRow());
         			sheetObj.DoSearch("ESM_BSA_0026GS4.do", bsaFormString(formObj,getParam(curPgmNo))+'&' + param ,{Sync:2} );
    			}
			}
			var err_cd=sheetObj.GetEtcData("err_cd");
			var err_msg=sheetObj.GetEtcData("err_msg");
			if(err_cd == "00000"){
				ComShowCodeMessage("BSA10018","Creation");
			}
			break;
	}
}
// Search-End Setting
function setSearchEnd(sheetObj) {
	var formObject=document.form;
    var i=1;
	if (formObject.rdoType[0].checked) {
//		 if (formObject.rdoOp_cd[0].checked){
//			document.getElementById("btng_save1").style.display="none"					//SJH.20150212.MOD
//		} else {
//			document.getElementById("btng_save3").style.display="none"
//		}
			
//		btng_save1.style.display="none";
		sheetObj.SetColHidden("M_ibflag",1);
//		for (i=1; i<sheetObj.LastRow()+1; i++) {										//20150721.DEL
//			sheetObj.SetCellEditable(i,"M_crr_bsa_capa",0);
//		}
	} else if (formObject.rdoType[1].checked || formObject.rdoType[2].checked) {
//		if (formObject.rdoOp_cd[0].checked){
//			document.getElementById("btng_save1").style.display="Inline"				//SJH.20150212.MOD
//		} else{
//			document.getElementById("btng_save3").style.display="Inline"
//		}
		
//		btng_save1.style.display="inline";
		sheetObj.SetColHidden("M_ibflag",0);
//		for (i=1; i<sheetObj.LastRow()+1; i++) {										//20150721.DEL
//			sheetObj.SetCellEditable(i,"M_crr_bsa_capa",1);
//		}
	}
 	sheetObj.SetSumText(0,0,"" );
 	sheetObj.SetSumText(0,"M_bsa_seq","TOTAL" );
}
function sheet1_OnSearchEnd(sheetObj,ErrMsg) {
	//ComOpenWait(false);
	var formObject=document.form;
    setSearchEnd(sheetObj);
}
//2014.12.29 김용습 - 2번시트 세로 스크롤에 의해 데이터 가려지는 현상 방지하기 위해 하기 기능 추가
function sheet2_OnSearchEnd(sheetObj,ErrMsg) {
	sheetObj.SetColWidth("D_port_bsa_capa",sheetObj.GetColWidth("D_port_bsa_capa"));
}
function sheet3_OnSearchEnd(sheetObj,ErrMsg) {
	//ComOpenWait(false);
	var formObject=document.form;
    setSearchEnd(sheetObj);
}
//2014.12.29 김용습 - 4번시트 세로 스크롤에 의해 데이터 가려지는 현상 방지하기 위해 하기 기능 추가
function sheet4_OnSearchEnd(sheetObj,ErrMsg) {
	sheetObj.SetColWidth("D_port_bsa_capa",sheetObj.GetColWidth("D_port_bsa_capa"));
}
// Retrieve detail data of sheet2 by double-clicking sheet1
function sheet1_OnDblClick(sheetObj, row, col) {
	var formObject=document.form;
	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
}
// Retrieve detail data of sheet4 by double-clicking sheet3
function sheet3_OnDblClick(sheetObj, row, col) {
	var formObject=document.form;
	doActionIBSheet2(sheetObj,formObject,IBSEARCH);
}
var selRow=0;
var selValue="";
function isValidLocation(result) {
	var sheetObject2=sheetObjects[1];
	var sheetObject4=sheetObjects[3];
	if(result != "Y"){
		ComShowMessage(ComGetMsg('BSA10004',selValue));  //msg1 + ' is invalid PORT.'
    	if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    		sheetObject2.SelectCell(selRow,"D_port_cd",true);
    	} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    		sheetObject4.SelectCell(selRow,"D_port_cd",true);
    	}
	}
}
function sheet2_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var param;
	if (sheetObj.ColSaveName(Col) == "D_port_cd") {
		selRow=Row;
		selValue=Value;
		param="f_cmd="+SEARCHLIST02;
		param=param+"&port_cd="+sheetObj.GetCellValue(Row,Col);
		param=param+"&code=locCd";
 		var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
		var locCd=GetEtcDataForExceptional(sXml, "locCd", "0");
		isValidLocation(locCd);
	}
}
function sheet4_OnChange(sheetObj,Row,Col,Value) {
	var formObj=document.form;
	var param;
	if (sheetObj.ColSaveName(Col) == "D_port_cd") {
		selRow=Row;
		selValue=Value;
		param="f_cmd="+SEARCHLIST02;
		param=param+"&port_cd="+sheetObj.GetCellValue(Row,Col);
		param=param+"&code=locCd";
 		var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
		var locCd=GetEtcDataForExceptional(sXml, "locCd", "0");
		isValidLocation(locCd);
	}
}
/**
 * handling process for input validation
 */
function validateForm(sheetObj) {
	with(sheetObj){
	}
	return true;
}
/**
 * handling process for input validation
 * 20150826.ADD
 */
function validateDForm(sheetObj) {
	with(sheetObj){
		var dup=ColValueDup("D_port_cd")
		if(dup != -1){
			ComShowCodeMessage('COM12115', 'Port');
			return false;
		}		
	}
	return true;
}
/**
 * handling process for retrieve validation
 */
function validateCond(formObj,sAction) {
	with(formObj){
		if (ComTrim(txtSDate.value) == "") {
			//ComShowMessage(ComGetMsg('COM12130','Period','First Element'));
			//formObj.txtSDate.focus();
			ComAlertFocus(txtSDate, ComGetMsg('COM12130','Period','First Element'));
			return false;
		}
		if (ComTrim(txtSDate.value) != "" && ComTrim(txtEDate.value) != "") {
			if(parseInt(txtSDate.value) > parseInt(txtEDate.value)){
				//ComShowMessage(ComGetMsg('BSA10011','Period','First Element','Second Element'));
				//txtEDate.focus();
				ComAlertFocus(txtEDate, ComGetMsg('BSA10011','Period','First Element','Second Element'));
				return false;
			}
		}
//		if(formObj..value == ""){ 
//	            ComAlertFocus(cobTrade, ComGetMsg('COM12113','Trade'));
//	            return false;
//	    }
//	        
//		if(formObj.cobLane.value == ""){
//         ComAlertFocus(cobLane, ComGetMsg('COM12113','Lane'));
//         return false;
//		}
	}
	return true;
}
 /**
  * refreshing rLane list in case of modifying trade code.
  */
 function cobTrade_OnChange(obj) {
 	if (loadingMode == true) return; 
 	var formObj=document.form;
    var sheetObj=sheetObjects[0];
    var param="";
    var trd_cd="";
	sheetObj.SetWaitImageVisible(0);
    if(obj.GetSelectText()!= ""){
     	formObj.f_cmd.value=SEARCHLIST01;
		trd_cd=obj.GetSelectCode();
        param="f_cmd="+SEARCHLIST01;
		param=param+"&trd_cd="+trd_cd;
		param=param+"&code=rLane";
 		var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0)
			ComXml2ComboItem(arrXml[0], cobLane, "code", "code");
		cobLane.SetSelectIndex(0);
     }
	sheetObj.SetWaitImageVisible(1);
 }
/**
 *  modifying Carrier combo in case of modifying JO/SC
 */
function chgCarrier(){
    var sheetObj=sheetObjects[0];
    var formObj=document.form;
    var param="";    
    var bsa_op_cd="";
    sheetObj.RemoveAll();
	sheetObj.SetWaitImageVisible(0);
    if (formObj.rdoOp_cd[0].checked) { //in case of selecting JO
    	bsa_op_cd=formObj.rdoOp_cd[0].value;
    } else if (formObj.rdoOp_cd[1].checked) {  //in case of selecting SC
    	bsa_op_cd=formObj.rdoOp_cd[1].value;
    }
	param="f_cmd="+SEARCHLIST01;
	param=param+"&bsa_op_cd="+bsa_op_cd;
	param=param+"&code=carrier";
 	var sXml=sheetObj.GetSearchData("ESM_BSA_CODE.do", param);
	var arrXml=sXml.split("|$$|");
	if (arrXml.length > 0)
		ComXml2ComboItem(arrXml[0], cobCarrier, "code", "code");
	cobCarrier.SetSelectIndex(0);
    comboObjects[3].SetSelectCode(ConstantMgr.getCompanyCode());
	sheetObj.SetWaitImageVisible(1);
}
//Carrier Combo Change
function cobCarrier_OnChange(obj) {
    var sheetObject1=sheetObjects[0];
    var sheetObject2=sheetObjects[2];
    var formObj=document.form;
    if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
    	sheetObject1.SetCellValue(0,"M_crr_bsa_capa",obj.GetSelectCode(),0);
    } else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
    	sheetObject2.SetCellValue(0,"M_crr_bsa_capa",obj.GetSelectCode(),0);
    }
}
// Header Setting
function setHeaderTitle() {
	var sheetObject1=sheetObjects[0];
	var sheetObject2=sheetObjects[1];
	var sheetObject3=sheetObjects[2];
	var sheetObject4=sheetObjects[3];
	var formObject=document.form;
	var strTypeText="";
	var obj=formObject.rdoType;
	for(var i=0; i<obj.length; i++) {
		if (obj[i].checked) {
    		strTypeText=obj[i].getAttribute("text");
			break;
		}
	}
	var carrierObj=comboObjects[3];
	if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
		sheetObject1.SetCellValue(0,"M_crr_bsa_capa",carrierObj.GetSelectCode(),0);
		sheetObject2.SetCellValue(0,"D_port_bsa_capa",strTypeText,0);
		sheetObject1.RemoveAll();
		sheetObject2.RemoveAll();
	} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
		sheetObject3.SetCellValue(0,"M_crr_bsa_capa",carrierObj.GetSelectCode(),0);
		sheetObject4.SetCellValue(0,"D_port_bsa_capa",strTypeText,0);
		sheetObject3.RemoveAll();
		sheetObject4.RemoveAll();
	}
}
//handling Enter-Key on the screen
function keyEnter_loc(){
	var sheetObject1=sheetObjects[0];
	var sheetObject3=sheetObjects[2];
	var formObject=document.form;
	if (event.keyCode == 13) {
		if (sheet_selno == JOINT_OPERATING) { //in case of 1st sheet
			doActionIBSheet(sheetObject1,formObject,IBSEARCH);
		} else if (sheet_selno == SPACE_CHARTERING) { //in case of 2nd sheet
			doActionIBSheet(sheetObject3,formObject,IBSEARCH);
		}
	}
}

function resizeSheet(){
    for (i=0; i<sheetObjects.length; i++){
        ComResizeSheet(sheetObjects[i]);
    }
}

