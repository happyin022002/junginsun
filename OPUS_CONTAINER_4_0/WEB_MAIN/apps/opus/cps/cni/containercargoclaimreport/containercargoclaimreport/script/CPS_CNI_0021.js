/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : CPS_CNI_0021.js
*@FileTitle  : [CPS_CNI_0021] Occurrence Analysis
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
/**
 * [CPS_CNI_0021] Occurrence Analysis
 * @extends
 * @class Occurrence Analysis  화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // initializing       
// REMOVE      = 5;       IBDOWNEXCEL    = 5;  // 엑셀 다운로드
// REMOVELIST  = 6;       IBLOADEXCEL    = 6;  // 엑셀 업로드  
// MULTI       = 7;       IBCOPYROW      = 7;  // 행복사       
// PRINT       = 8;       IBDELETE       = 8;  // 삭제         
// REPLY       = 9;       RDPRINT        = 9;  // RD 연결  
//                        IBROWSEARCH    = 10; // Row 조회     
//                        IBCREATE       = 11; // Create       
//                        IBRESET        = 12; // Reset        
//                        IBBATCH        = 13; // Batch        
// =============================================================
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var sheet2=null;
//IBMultiCombo
var comboObjects=new Array();
var combo1=null;
var combo2=null;
var comboCnt=0;
// html form
var frm=null;
var printCond=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
comboObjects[comboCnt++]=combo_obj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 * @param {string} current year
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];
    sheet2=sheetObjects[1];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	// IBMultiComboinitializing
	combo1=comboObjects[0];
	combo2=comboObjects[1];
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBoxValue();
    //registering initial event 
    initControl();
	//Period 기간 초기값 셋팅(GMT기준)
	var sXml2=document.form2.sXml.value;	
	var arrXml=sXml2.split("|$$|");
	var vCurDate=ComGetEtcData(arrXml[0], "CurrentDate");	
	if (ComIsDate(vCurDate)){
		ComSetObjValue(frm.from_period, vCurDate.substring(0,4) + "-01-01");
		ComSetObjValue(frm.to_period, vCurDate);
	}
}
/**
 * 초기 콤보 설정
 **/
function initComboBoxValue() {
	 combo1.RemoveAll();
	 combo2.RemoveAll();
	 combo1.InsertItem(0, "Area/TOC", "0");
	 combo1.InsertItem(1, "HOFC/TOC", "1");
	 combo1.InsertItem(2, "Cargo Origin/Destination", "2");
	 combo1.InsertItem(3, "Total Occurrence by Area", "3");
	 combo1.InsertItem(4, "Total Occurrence by HOFC", "4");
	 combo1.InsertItem(5, "Total Occurrence by VVD", "5");
	 combo1.InsertItem(6, "Total Occurrence by Claimant", "6");
	 ComSetObjValue(frm.combo1, "0");
		var sXml="";
		sXml +="<SHEET>";
		sXml +="<DATA COLORDER='ibflag|name|code|pagerows|' COLSEPARATOR='☜☞' TOTAL='16'>";
		sXml +="<TR><![CDATA[☜☞Date of Update☜☞DOU☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Incident☜☞DOI☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Survey☜☞DOSV☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Preliminary Notice☜☞DON☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Time Bar☜☞DOTB☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Time Bar LP☜☞DOTBLP☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Formal Claim☜☞DOF☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Summons Filed☜☞DOSF☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Summons Successed☜☞DOSS☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Settlement☜☞DOS☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Recovery LP☜☞DORLP☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Recovery INS☜☞DORINS☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Receipt☜☞DOR☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Loading☜☞DOL☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Discharge☜☞DOD☜☞]]></TR>";
		sXml +="<TR><![CDATA[☜☞Date of Delivery☜☞DEL☜☞]]></TR>";
		sXml +="</DATA>";
		sXml +="</SHEET>";
		setMultiComboBox("period" ,  sXml ); 
		ComSetObjValue(period, "DON");
		combo1.SetSelectCode("0");
}
 /**
 * IBMultiComboBox 설정<br>
 * @param {select box} 콤보 객체
 * @param {xml} code , name의 xml
 * @param {String} 초기 선택 Code 
 */
 function setMultiComboBox(pComboObjId, pXML) {
 	var vComboObj=null; // IBMultiComboBox
 	var vArrayListData=""; 
 	var vListData="";
 	var vCaptionText="";
 	vComboObj=getComboObject(pComboObjId);
 	if (vComboObj == null || pXML == null ) {
 		return;
 	}
 	var vArrayListData=SheetXml2ListMap(pXML);
 	for ( var idx=0; idx < vArrayListData.length; idx++) {
 	    vListData=vArrayListData[idx];
 		vCaptionText=vListData["code"] + "|" + vListData["name"];
 		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
 	}//end for
 	if (pComboObjId == "status") {
 		vComboObj.InsertItem(0, "All|All Status", "All");
 		vComboObj.SetSelectIndex(0);
 	} else if (pComboObjId == "area") {
 		vComboObj.InsertItem(0, "All|All Area", "All");
 		vComboObj.SetSelectIndex(0);
 	}else {
 		vComboObj.InsertItem(0, "", "");
 		vComboObj.SetSelectIndex(0);
 	}	
 } 
/**
* registering initial event 
*/
function initControl() {
   //key up
   axon_event.addListenerForm('keyup', 'obj_keyup', frm); 

}
/**
* Combobox Initialize, Header Definition 
* @param {object} comboObj Mandatory, IBMultiCombo Object
* @param {int} comboNo Mandatory, Sequence No. of IBMultiCombo Object Tag's ID
**/
function initCombo(comboObj, comboNo) {
	with (comboObj) {
		comboObj.SetMultiSelect(0);
//no support[check again]CLT 		comboObj.UseCode=true;
//no support[check again]CLT 		comboObj.LineColor="#ffffff";
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(190);
		if (comboNo == 1){
		    comboObj.SetBackColor("#FFFFFF");
		} else {
			comboObj.SetBackColor("#CCFFFD");
		}
	}

} 
/**
* combo id 로 해당 comboObject를 찾아 반환한다.
* @param comboId
**/
function getComboObject(pComboObjId){
	var vCnt=comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].options.id== pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}
/*
function combo1_OnChange(comboObj,Index_Code, Text){   
	setTemplate(Index_Code);
	//doActionIBSheet(SEARCHLIST01);		
}
*/
function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		return;
	}
	if(combo1.GetSelectCode()=="0"){
 		sheet.SetSumText(0,"area_report_by_nm","Grand Total (%)");
 		sheet.SetSumText(0,3,"100%");
 		sheet.SetSumText(0,5,"100%");
 		var val1=sheet.GetSumValue(0,2);
 		var val2=sheet.GetSumValue(0,4);
  		sheet.SetSumText(0,7,setPer(sheet.GetSumValue(0,6),val1));
  		sheet.SetSumText(0,9,setPer(sheet.GetSumValue(0,8),val2));
  		sheet.SetSumText(0,11,setPer(sheet.GetSumValue(0,10),val1));
  		sheet.SetSumText(0,13,setPer(sheet.GetSumValue(0,12),val2));
  		sheet.SetSumText(0,15,setPer(sheet.GetSumValue(0,14),val1));
  		sheet.SetSumText(0,17,setPer(sheet.GetSumValue(0,16),val2));
  		sheet.SetSumText(0,19,setPer(sheet.GetSumValue(0,18),val1));
  		sheet.SetSumText(0,21,setPer(sheet.GetSumValue(0,20),val2));
  		sheet.SetSumText(0,23,setPer(sheet.GetSumValue(0,22),val1));
  		sheet.SetSumText(0,25,setPer(sheet.GetSumValue(0,24),val2));
  		sheet.SetSumText(0,27,setPer(sheet.GetSumValue(0,26),val1));
  		sheet.SetSumText(0,29,setPer(sheet.GetSumValue(0,28),val2));
		}else if(combo1.GetSelectCode()=="1"){
 		sheet.SetSumText(0,"hofc_report_by_nm","Grand Total (%)");
		//sheet.ShowSubSum("hofc_report_by_nm", "32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50", true, false);
		sheet.ShowSubSum([{StdCol:"hofc_report_by_nm", SumCols:"32|34|36|38|40|42|44|46|48|50", Sort:false}]);
 		sheet.SetSumText(0,33,"100%");
 		sheet.SetSumText(0,35,"100%");
 		var val1=sheet.GetSumValue(0,32);
 		var val2=sheet.GetSumValue(0,34);
  		sheet.SetSumText(0,37,setPer(sheet.GetSumValue(0,36),val1));
  		sheet.SetSumText(0,39,setPer(sheet.GetSumValue(0,38),val2));
  		sheet.SetSumText(0,41,setPer(sheet.GetSumValue(0,40),val1));
  		sheet.SetSumText(0,43,setPer(sheet.GetSumValue(0,42),val2));
  		sheet.SetSumText(0,45,setPer(sheet.GetSumValue(0,44),val1));
  		sheet.SetSumText(0,47,setPer(sheet.GetSumValue(0,46),val2));
  		sheet.SetSumText(0,49,setPer(sheet.GetSumValue(0,48),val1));
  		sheet.SetSumText(0,51,setPer(sheet.GetSumValue(0,50),val2));
  		sheet.SetSumText(0,53,setPer(sheet.GetSumValue(0,52),val1));
  		sheet.SetSumText(0,55,setPer(sheet.GetSumValue(0,54),val2));
  		sheet.SetSumText(0,57,setPer(sheet.GetSumValue(0,56),val1));
  		sheet.SetSumText(0,59,setPer(sheet.GetSumValue(0,58),val2));
		}else if(combo1.GetSelectCode()=="2"){
 		sheet.SetSumText(0,"cargo_report_by_nm","Total (%)");
 		sheet.SetSumText(0,62,"100%");
 		sheet.SetSumText(0,64,"100%");
 		var val1=sheet.GetSumValue(0,61);
 		var val2=sheet.GetSumValue(0,63);
  		sheet.SetSumText(0,66,setPer(sheet.GetSumValue(0,65),val1));
  		sheet.SetSumText(0,68,setPer(sheet.GetSumValue(0,67),val2));
  		sheet.SetSumText(0,70,setPer(sheet.GetSumValue(0,69),val1));
  		sheet.SetSumText(0,72,setPer(sheet.GetSumValue(0,71),val2));
  		sheet.SetSumText(0,74,setPer(sheet.GetSumValue(0,73),val1));
  		sheet.SetSumText(0,76,setPer(sheet.GetSumValue(0,75),val2));
  		sheet.SetSumText(0,78,setPer(sheet.GetSumValue(0,77),val1));
  		sheet.SetSumText(0,80,setPer(sheet.GetSumValue(0,79),val2));
  		sheet.SetSumText(0,82,setPer(sheet.GetSumValue(0,81),val1));
  		sheet.SetSumText(0,84,setPer(sheet.GetSumValue(0,83),val2));
  		sheet.SetSumText(0,86,setPer(sheet.GetSumValue(0,85),val1));
  		sheet.SetSumText(0,88,setPer(sheet.GetSumValue(0,87),val2));
		for(var i=62; i<81; i=i+2){
			//sheet.SumText(0,i)="100%";			
		}	
	}
//	sheet.ApplyFormat() ;
}
function setPer(val1, val2) { 
 	var fval1=parseFloat(ComReplaceStr(val1,",",""));
    var fval2=parseFloat(ComReplaceStr(val2,",",""));
 	var val3=roundPrecision(fval1 / fval2,2) * 100; 	
 	//var per = ComAddComma2(val3,"#,###.00")+'%';
 	return val3+'%';	
}
function sheet2_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		return;
	}
	if(combo1.GetSelectCode()=="3"){
 		sheet.SetSumText(0,"area_report_by_nm","Total (%)");
		for(var i=3; i<30; i=i+2){
 			sheet.SetSumText(0,i,"100%");
		}	
	}else if(combo1.GetSelectCode()=="4"){
 		sheet.SetSumText(0,"hofc_report_by_nm","Total (%)");
		sheet.ShowSubSum([{StdCol:"hofc_report_by_nm", SumCols:"32|34|36|38|40|42|44|46|48|50", Sort:false}]);
		for(var i=33; i<60; i=i+2){
 			sheet.SetSumText(0,i,"100%");
		}
	}else if(combo1.GetSelectCode()=="5"){
 		sheet.SetSumText(0,"trnk_ref_vvd_no","Grand Total (%)");
		for(var i=62; i<89; i=i+2){
 			sheet.SetSumText(0,i,"100%");
		}
	}else if(combo1.GetSelectCode()=="6"){
 		sheet.SetSumText(0,"clm_pty_abbr_nm","Grand Total (%)");
		for(var i=91; i<118; i=i+2){
 			sheet.SetSumText(0,i,"100%");
		}
	}
//	sheet.ApplyFormat() ;
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
	with (sheetObj) {
		switch (sheetObj.id) {
        case "sheet1":
            
            //no support[check again]CLT 			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            var HeadTitle1="|Area|Total|Total|Total|Total|Physical Damage|Physical Damage|Physical Damage|Physical Damage|Wet Damage|Wet Damage|Wet Damage|Wet Damage|Shortage|Shortage|Shortage|Shortage|Non-Delivery|Non-Delivery|"
            + "Non-Delivery|Non-Delivery|Reefer DOL|Reefer DOL|Reefer DOL|Reefer DOL|Others|Others|Others|Others";
            var HeadTitle2="|Area|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|"
            + "Case|%|Amount|%|Case|%|Amount|%";
            HeadTitle1=HeadTitle1 +"|"+"Area|HOFC|Total|Total|Total|Total|Physical Damage|Physical Damage|Physical Damage|Physical Damage|Wet Damage|Wet Damage|Wet Damage|Wet Damage|Shortage|Shortage|Shortage|Shortage|Non-Delivery|Non-Delivery|" +
            "Non-Delivery|Non-Delivery|Wet Damage|Wet Damage|Wet Damage|Wet Damage|Others|Others|Others|Others";
            HeadTitle2=HeadTitle2 +"|"+ "Area|HOFC|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
            "Case|%|Amount|%|Case|%|Amount|%";
            HeadTitle1=HeadTitle1 +"|"+"Origin/Destination|Total|Total|Total|Total|America|America|America|America|Europe|Europe|Europe|Europe|North Asia|North Asia|North Asia|North Asia|China|China|" +
            "China|China";
            HeadTitle2=HeadTitle2 +"|"+ "Origin/Destination|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"area_report_by_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case0",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case0",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt0",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt1",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt2",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt3",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt4",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case5",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt5",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case6",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt6",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"hofc_report_by_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hofc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case0",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case0",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt0",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt1",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt2",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt3",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt4",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case5",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt5",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case6",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt6",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"cargo_report_by_nm",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_case0",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_case0",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cargo_amt0",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_amt0",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_case1",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_case1",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cargo_amt1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_amt1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_case2",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_case2",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cargo_amt2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_amt2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_case3",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_case3",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cargo_amt3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_amt3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_case4",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_case4",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"cargo_amt4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"cargo_pct_amt4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);
            SetSheetHeight(442);
            SetEditable(1);
         	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
            break;


        case "sheet2":
          
            //no support[check again]CLT 				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);
            var HeadTitle1="|Area|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
            "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
            var HeadTitle2="|Area|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
            " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
            var HeadTitle3="|Area|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
            "Case|%|Amount|%|Case|%|Amount|%";
            HeadTitle1=HeadTitle1 +"|"+ "Area|HOFC|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
            "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
            HeadTitle2=HeadTitle2 +"|"+ "Area|HOFC|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
            " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
            HeadTitle3=HeadTitle3 +"|"+ "Area|HOFC|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
            "Case|%|Amount|%|Case|%|Amount|%";
            HeadTitle1=HeadTitle1 +"|"+"VVD|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
            "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
            HeadTitle2=HeadTitle2 +"|"+ "VVD|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
            " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
            HeadTitle3=HeadTitle3 +"|"+ "VVD|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
            "Case|%|Amount|%|Case|%|Amount|%";
            HeadTitle1=HeadTitle1 +"|"+ "Claimant|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
            "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
            HeadTitle2=HeadTitle2 +"|"+ "Claimant|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
            " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
            HeadTitle3=HeadTitle3 +"|"+ "Claimant|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
            "Case|%|Amount|%|Case|%|Amount|%";
            var headCount=ComCountHeadTitle(HeadTitle1);

            SetConfig( { SearchMode:2, MergeSheet:1, Page:20, FrozenCol:0, DataRowMerge:1 } );

            var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
            var headers = [ { Text:HeadTitle1, Align:"Center"},
                        { Text:HeadTitle2, Align:"Center"},
                        { Text:HeadTitle3, Align:"Center"} ];
            InitHeaders(headers, info);

            var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"area_report_by_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case0",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case0",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt0",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt1",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt2",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt3",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt4",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case5",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt5",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_case6",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_case6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"area_amt6",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"area_pct_amt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"hofc_report_by_nm",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:1,   SaveName:"hofc",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case0",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case0",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt0",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case1",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case1",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt1",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case2",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case2",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt2",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case3",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case3",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt3",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case4",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case4",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt4",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case5",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case5",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt5",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_case6",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_case6",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"hofc_amt6",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"hofc_pct_amt6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"trnk_ref_vvd_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case0",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case0",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt0",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt0",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case1",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case1",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt1",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt1",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case2",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case2",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt2",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt2",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case3",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case3",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt3",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt3",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case4",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case4",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt4",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt4",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case5",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case5",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt5",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt5",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_case6",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_case6",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"vvd_amt6",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"vvd_pct_amt6",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:1,   SaveName:"clm_pty_abbr_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case0",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case0",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt0",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt0",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case1",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case1",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt1",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt1",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case2",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case2",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt2",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt2",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case3",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case3",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt3",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt3",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case4",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case4",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt4",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt4",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case5",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case5",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt5",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt5",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_case6",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_case6",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"AutoSum",   Hidden:0, Width:100,  Align:"Right",   ColMerge:0,   SaveName:"claimant_amt6",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
                   {Type:"Text",   Hidden:0, Width:50,   Align:"Right",   ColMerge:0,   SaveName:"claimant_pct_amt6",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
             
            InitColumns(cols);
            SetSheetHeight(442);
         	SetEditable(1);
         	SetCountFormat("[SELECTDATAROW / TOTALROWS]");
            break;


		}
	}
}
// ===================================================================================
// Private function
// ===================================================================================
function setTemplate(indexCode){
	var isSheet1=false;
	var vSheetColCount=0;
	var vStart=0;
	var vEnd=0;
	if( indexCode<3 ){
		isSheet1=true;
		document.all.tbl1.style.display="";
		document.all.tbl2.style.display="none";
	}else{
		isSheet1=false;
		document.all.tbl1.style.display="none";
		document.all.tbl2.style.display="";
	}
	if(isSheet1){
		
		vSheetColCount=sheet1.LastCol()+1;
		if(indexCode==0){
			vStart=1;
			vEnd=29;
		}else if(indexCode==1){
			vStart=30;
			vEnd=59;
		}else if(indexCode==2){
			vStart=60;
			vEnd=80;
		}
		sheet1.RenderSheet(0);
	    for(var idx=0;idx<=vSheetColCount;idx++){
	    	sheet1.SetColHidden(idx,1);
	    }
	    sheet1.RenderSheet(1);
	    
	    sheet1.RenderSheet(0);
	    for(var jdx=vStart;jdx<=vEnd;jdx++){
	    	sheet1.SetColHidden(jdx,0);
	    }
	    sheet1.RenderSheet(1);
	    
	    sheet1.SetColWidth(vStart, 120);
	    sheet1.RemoveAll();
	    
	    
	}else {
		
		vSheetColCount=sheet2.LastCol()+1;
		if(indexCode==3){
			vStart=1;
			vEnd=29;
		}else if(indexCode==4){
			vStart=30;
			vEnd=59;
		}else if(indexCode==5){
			vStart=60;
			vEnd=88;	
		}else if(indexCode==6){
			vStart=89;
			vEnd=117;
		}
		sheet2.RenderSheet(0);
	    for(var idx=0;idx<=vSheetColCount;idx++){
	    	sheet2.SetColHidden(idx,1);
	    }
	    sheet2.RenderSheet(1);
	    
	    sheet2.RenderSheet(0);
	    for(var jdx=vStart;jdx<=vEnd;jdx++){
	    	sheet2.SetColHidden(jdx,0);
	    }
	    sheet2.RenderSheet(1);
	    
	    sheet2.SetColWidth(vStart, 120);
	    sheet2.RemoveAll();
	    
	   
	}
}
 function setClassCodeList() {
		combo1.RemoveAll();
		for(var i=0 ; i < classCodeList.length ; i++ ) {			
			var clist=classCodeList[i];			
			combo1.InsertItem(i,clist["clss_clm_misc_nm"],clist["clss_clm_misc_cd"]);
		}		
	}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
		case "btn1_Retrieve":
			doActionIBSheet(SEARCHLIST01);					
			break;	
	    case "btn1_New":
//no support[check again]CLT 	    	sheet1_OnLoadFinish(sheet1);
	    	sheet1.RemoveAll();
	    	sheet2.RemoveAll();
	    	loadPage();
	        break;	
		case "btn1_Print":	
			doActionIBSheet(PRINT);
	        break; 
		case "btn1_DownExcel":
			if(sheet1.RowCount()  < 1){//no data
				ComShowCodeMessage("COM132501");
			}else{
				if( (combo1.GetSelectCode()=="0")||(combo1.GetSelectCode()=="1")||(combo1.GetSelectCode()=="2") ) {
	 				sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
				}else {
					if(sheet2.RowCount()  < 1){
						ComShowCodeMessage("COM132501");
					}else{
						sheet2.Down2Excel( {DownCols: makeHiddenSkipCol(sheet2), SheetDesign:1,Merge:1 });
					}	
				}
			}
			break;
		case "btns_from_period":
		case "btns_to_period":
			var result=srcName.replace("btns_", "");
		    calObj=eval("frm." + result );
			var vCal=new ComCalendar();
			vCal.setDisplayType('date');
			vCal.select(calObj, 'yyyy-MM-dd');
			break;	
	}
} 
/**
 * HTML Control KeyUp event
 */
function obj_keyup() {	  
	var keycode = ComGetEvent("keycode");
	 if((keycode >= 37)&&(keycode <= 40)) return;
	 switch (ComGetEvent("name")) {    
		case "from_period":  			
			if( keycode == 13 ){
				doActionIBSheet(SEARCHLIST01);
			}
			break;
		case "to_period":  			
			if( keycode == 13 ){
				doActionIBSheet(SEARCHLIST01);
			}
			break;	
	}
}  


// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
  function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {	
		frm.page_no.value=PageNo;  
		doActionIBSheet(SEARCHLIST01);
 } 
/**
 * Calling function in case of OnPopupClick event
 * calling popup window <br>
 * @param {IBSheet} sheet
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnPopupClick(sheet, row, col) {
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
		frm.report_by.value=combo1.GetSelectCode();
		var from_period=ComGetObjValue(frm.from_period);
		var to_period=ComGetObjValue(frm.to_period);
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		// Form Object Data 
		var vFormData=FormQueryString(frm);
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
 		var sXml=sheet1.GetSearchData("CPS_CNI_0021GS.do", vFormData);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			if( (combo1.GetSelectCode()=="0")||(combo1.GetSelectCode()=="1")||(combo1.GetSelectCode()=="2") ) {
				sheet1.RemoveAll();
				sheet1.LoadSearchData(arrXml[0],{Sync:1} );
			}else {
				sheet2.LoadSearchData(arrXml[0],{Sync:1} );
			}
		}else{
			ComShowCodeMessage("CNI00013");
		}
		ComAddSeparator(frm.sch_from_str,"ymd");
		ComAddSeparator(frm.sch_to_str,"ymd");
	} else if (sAction == INIT) {
		frm.f_cmd.value=INIT;
 		var sXml=sheet1.GetSearchData("CPS_CNI_0028GS.do", FormQueryString(frm));
		var arrXml=sXml.split("|$$|");
		// ------------------------------------------------------------
		// setting combo 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
			classCodeList=SheetXml2ListMap(arrXml[0]);		
			//setClassCodeList();	
		}
	} else if (sAction == PRINT) {
		frm.f_cmd.value=PRINT;
		frm.report_by.value=combo1.GetSelectCode();
		var ctype=combo1.GetSelectCode();
		var printNumber="";
		var bodyTitle="";
		var from_period=ComGetObjValue(frm.from_period);
		var to_period=ComGetObjValue(frm.to_period);
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		// Form Object Data 
		var vFormData=FormQueryString(frm);
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		if(ctype=="0"){
			printNumber="0077";
			bodyTitle="Occurrence Analysis by Area/TOC";
		}else if(ctype=="1"){
			printNumber="0078";
			bodyTitle="Occurrence Analysis by HOFC/TOC";
		}else if(ctype=="2"){
			printNumber="0079";
			bodyTitle="Occurrence Analysis by Cargo Origin/Destination";
		}else if(ctype=="3"){
			printNumber="0080";
			bodyTitle="Total Occurrence by Area";
		}else if(ctype=="4"){
			printNumber="0081";
			bodyTitle="Total Occurrence by HOFC";
		}else if(ctype=="5"){
			printNumber="0082";
			bodyTitle="Total Occurrence by VVD";
		}else if(ctype=="6"){	
			printNumber="0083";
			bodyTitle="Total Occurrence by Claimant";
		}
		var rf="/rf ["+RDServerIP + "/CPS_CNI_"+printNumber+".do]";
		var rpost="/rpost ["+vFormData+"]";
		var rv="/rv  NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]"+ getCondAllValue();
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		frm.com_mrdArguments.value=rf +" "+ rv +" "+ rpost +" "+ rpaper;
		frm.com_mrdTitle.value=bodyTitle;
		frm.com_mrdBodyTitle.value=bodyTitle;
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_"+printNumber+".mrd";
		//var feature = "resizable=yes,width=1000,height=600";
		popupRd(1000,600);
	}   
}
 function getCondAllValue(){
		var vObjects=frm.elements;
		var vCondStr="";
		for ( var kdx=0; kdx < vObjects.length; kdx++) {
			var vObj=vObjects[kdx];
			var vObjTp=vObj.type;
			var vObjNm=vObj.name;
			if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
				continue;
			}
			vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
		} //end for
		vCondStr += "rd_report_by["+frm.rd_report_by.value+"]"+"rd_title_nm["+frm.rd_title_nm.value+"]";//hidden 값중 일부를 넘겨야함.
		return vCondStr;
	}
 function combo1_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	 form.combo1_text.value = comboObj.GetText(parseInt(newIndex), 0);
	 setTemplate(newIndex);
 }
 function period_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	 form.period_text.value = comboObj.GetText(parseInt(newIndex), 0);
 }
 
 