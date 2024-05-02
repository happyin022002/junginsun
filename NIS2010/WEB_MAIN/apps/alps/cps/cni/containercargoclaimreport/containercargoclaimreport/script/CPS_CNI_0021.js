/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : cps_cni_0021.js
 *@FileTitle : [CPS_CNI_0021] Occurrence Analysis
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.12.09
 *@LastModifier : 박제성
 *@LastVersion : 1.0
 * 2009.12.09 박제성
 * 1.0 Creation
=========================================================*/

/**
 * [CPS_CNI_0021] Occurrence Analysis
 * @extends
 * @class Occurrence Analysis  화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */

function cps_cni_0021() {
    this.processButtonClick = processButtonClick;
    this.setSheetObject = setSheetObject;
    this.loadPage = loadPage;
    this.initSheet = initSheet;
    this.initControl = initControl;
    this.doActionIBSheet = doActionIBSheet;
    this.setTabObject = setTabObject;
        
    this.sheet1_OnClick = sheet1_OnClick;
}

// =============================================================
// #Form Command          #IBSheet Action                
// INIT        = 0;       IBSEARCH       = 0;  // 조회         
// ADD         = 1;       IBSEARCHAPPEND = 1;  // 페이징 조회  
// SEARCH      = 2;       IBSAVE         = 2;  // 저장         
// SEARCHLIST  = 3;       IBINSERT       = 3;  // 삽입         
// MODIFY      = 4;       IBCLEAR        = 4;  // 초기화       
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
// 전역변수 추상함수
// ===================================================================================

// IBSheet 
var sheetObjects = new Array();
var sheetCnt = 0;
var sheet1 = null;
var sheet2 = null;

//IBMultiCombo
var comboObjects = new Array();
var combo1 = null;
var combo2 = null;
var comboCnt = 0;


// html form
var frm = null;
var printCond = null;

/**
 * IBSheet Object를 배열로 등록
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++] = sheet_obj;
}
/**
* 페이지에 생성된 IBCombo Object를 comboObjects 배열에 등록
* @param {IBMultiCombo} combo_obj    IBMultiCombo Object  
**/
function setComboObject(combo_obj){
comboObjects[comboCnt++] = combo_obj;
}

// ===================================================================================
// 초기화 
// ===================================================================================
/**
 * Sheet 기본 설정 및 초기화
 * body 태그의 onLoad 이벤트핸들러 구현
 * 화면을 브라우저에서 로딩한 후에 선처리해야 하는 기능을 추가한다
 * @param {string} year 현재년도
 **/
function loadPage() {
		
    //전역 변수 설정 
    frm = document.form;
    sheet1 = sheetObjects[0];
    sheet2 = sheetObjects[1];    
    sheetCnt = sheetObjects.length ;
    
   
    //시트 초기화 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
    
	// IBMultiCombo초기화
	combo1 = comboObjects[0];
	combo2 = comboObjects[1];
	comboCnt = comboObjects.length;
	
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	
	initComboBoxValue();
    
    //Form 이벤트 등록
    initControl();
    
	//Period 기간 초기값 셋팅(GMT기준)
	var sXml2 = document.form2.sXml.value;	
	var arrXml = sXml2.split("|$$|");
			
	var vCurDate = ComGetEtcData(arrXml[0], "CurrentDate");	
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
	 
		var sXml = "";
		
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
		ComSetObjValue(frm.period, "DON");
	 	
}
 
 /**
 * IBMultiComboBox 설정<br>
 * @param {select box} 콤보 객체
 * @param {xml} code , name의 xml
 * @param {String} 초기 선택 Code 
 */
 function setMultiComboBox(pComboObjId, pXML) {
 	var vComboObj      = null; // IBMultiComboBox
 	var vArrayListData = ""; 
 	var vListData      = "";
 	var vCaptionText   = "";
 	vComboObj = getComboObject(pComboObjId);
 	if (vComboObj == null || pXML == null ) {
 		return;
 	}
    
 	var vArrayListData = SheetXml2ListMap(pXML);
 	
 	for ( var idx = 0; idx < vArrayListData.length; idx++) {
 	    vListData = vArrayListData[idx];
 		vCaptionText = vListData["code"] + "|" + vListData["name"];
 		vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
 	}//end for
 	if (pComboObjId == "status") {
 		vComboObj.InsertItem(0, "All|All Status", "All");
 		vComboObj.Index = 0;
 	} else if (pComboObjId == "area") {
 		vComboObj.InsertItem(0, "All|All Area", "All");
 		vComboObj.Index = 0;
 	}else {
 		vComboObj.InsertItem(0, "", "");
 		vComboObj.Index = 0;
 	}	
 } 

/**
* Form 이벤트 등록
*/
function initControl() {
   //keypress
   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
   //key up
   axon_event.addListenerForm('keyup', 'obj_keyup', frm); 
   // focus in
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
   // focus out
   axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}


/**
* Combo 기본 설정 
* param : comboObj ==> 콤보오브젝트, comboNo ==> 콤보오브젝트 태그의 아이디에 붙인 일련번호
* 콤보가 다수일 경우 콤보 수만큼 case를 추가하여 시트 초기화모듈을 구성한다 
**/
function initCombo(comboObj, comboNo) {

	with (comboObj) {
		comboObj.MultiSelect = false;
		comboObj.UseCode = true;
		comboObj.LineColor = "#ffffff";
		comboObj.SetColAlign("left|left");
		comboObj.MultiSeparator = ",";
		comboObj.DropHeight = 190;
		if (comboNo == 1){
		    comboObj.BackColor = "#FFFFFF";
		} else {
			comboObj.BackColor = "#CCFFFD";
		}
	}
} 

/**
* combo id 로 해당 comboObject를 찾아 반환한다.
* @param comboId
**/
function getComboObject(pComboObjId){
	var vCnt = comboObjects.length;
	if (vCnt > 0) {
		for(var i=0; i<vCnt; i++){
			if(comboObjects[i].id == pComboObjId){
				return comboObjects[i];
			} //end if 
		} // end for
	}// end if
	return null;
}

function combo1_OnChange(comboObj,Index_Code, Text){   
	
	setTemplate(Index_Code);
	//doActionIBSheet(SEARCHLIST01);		
}

function sheet1_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		return;
	}
	
	if(combo1.Code=="0"){
		
		sheet.SumText(0,"area_report_by_nm")="Grand Total (%)";
		
		sheet.SumText(0,3)="100%";	
		sheet.SumText(0,5)="100%";
		var val1 = sheet.SumValue(0,2);
		var val2 = sheet.SumValue(0,4);
		
		sheet.SumText(0,7)= setPer(sheet.SumValue(0,6),val1);
		sheet.SumText(0,9)= setPer(sheet.SumValue(0,8),val2);				
		sheet.SumText(0,11)= setPer(sheet.SumValue(0,10),val1);
		sheet.SumText(0,13)= setPer(sheet.SumValue(0,12),val2);			
		sheet.SumText(0,15)= setPer(sheet.SumValue(0,14),val1);
		sheet.SumText(0,17)= setPer(sheet.SumValue(0,16),val2);			
		sheet.SumText(0,19)= setPer(sheet.SumValue(0,18),val1);
		sheet.SumText(0,21)= setPer(sheet.SumValue(0,20),val2);			
		sheet.SumText(0,23)= setPer(sheet.SumValue(0,22),val1);
		sheet.SumText(0,25)= setPer(sheet.SumValue(0,24),val2);				
		sheet.SumText(0,27)= setPer(sheet.SumValue(0,26),val1);
		sheet.SumText(0,29)= setPer(sheet.SumValue(0,28),val2);		
		sheet.SumText(0,31)= setPer(sheet.SumValue(0,30),val1);
		sheet.SumText(0,33)= setPer(sheet.SumValue(0,32),val2);	
			
		
	}else if(combo1.Code=="1"){
		sheet.SumText(0,"hofc_report_by_nm")="Grand Total (%)";
		//sheet.ShowSubSum("hofc_report_by_nm", "32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50", true, false);
		sheet.ShowSubSum("hofc_report_by_nm", "36|38|40|42|44|46|48|50|52|54|56|58|60|62|64|66", true, false);
		
		sheet.SumText(0,37)="100%";	
		sheet.SumText(0,39)="100%";	
		var val1 = sheet.SumValue(0,36);
		var val2 = sheet.SumValue(0,38);
		
		sheet.SumText(0,41)= setPer(sheet.SumValue(0,40),val1);
		sheet.SumText(0,43)= setPer(sheet.SumValue(0,42),val2);		
		sheet.SumText(0,45)= setPer(sheet.SumValue(0,44),val1);
		sheet.SumText(0,47)= setPer(sheet.SumValue(0,46),val2);			
		sheet.SumText(0,49)= setPer(sheet.SumValue(0,48),val1);
		sheet.SumText(0,51)= setPer(sheet.SumValue(0,50),val2);			
		sheet.SumText(0,53)= setPer(sheet.SumValue(0,52),val1);
		sheet.SumText(0,55)= setPer(sheet.SumValue(0,54),val2);			
		sheet.SumText(0,57)= setPer(sheet.SumValue(0,56),val1);
		sheet.SumText(0,59)= setPer(sheet.SumValue(0,58),val2);			
		sheet.SumText(0,61)= setPer(sheet.SumValue(0,60),val1);
		sheet.SumText(0,63)= setPer(sheet.SumValue(0,62),val2);			
		sheet.SumText(0,65)= setPer(sheet.SumValue(0,64),val1);
		sheet.SumText(0,67)= setPer(sheet.SumValue(0,66),val2);
		
	}else if(combo1.Code=="2"){
		sheet.SumText(0,"cargo_report_by_nm")="Total (%)";
		sheet.SumText(0,70)="100%";	
		sheet.SumText(0,72)="100%";	
		var val1 = sheet.SumValue(0,69);
		var val2 = sheet.SumValue(0,71);
		
		sheet.SumText(0,74)= setPer(sheet.SumValue(0,73),val1);
		sheet.SumText(0,76)= setPer(sheet.SumValue(0,75),val2);			
		sheet.SumText(0,78)= setPer(sheet.SumValue(0,77),val1);
		sheet.SumText(0,80)= setPer(sheet.SumValue(0,79),val2);			
		sheet.SumText(0,82)= setPer(sheet.SumValue(0,81),val1);
		sheet.SumText(0,84)= setPer(sheet.SumValue(0,83),val2);			
		sheet.SumText(0,86)= setPer(sheet.SumValue(0,85),val1);
		sheet.SumText(0,88)= setPer(sheet.SumValue(0,87),val2);		
		sheet.SumText(0,90)= setPer(sheet.SumValue(0,89),val1);
		sheet.SumText(0,92)= setPer(sheet.SumValue(0,91),val2);	
		sheet.SumText(0,94)= setPer(sheet.SumValue(0,93),val1);
		sheet.SumText(0,96)= setPer(sheet.SumValue(0,95),val2);	
		for(var i=70; i<89; i= i+2){
			//sheet.SumText(0,i)="100%";			
		}	
	}
	
	sheet.ApplyFormat() ;
}

function setPer(val1, val2) {
 
 	var fval1 = parseFloat(ComReplaceStr(val1,",",""));
    var fval2 = parseFloat(ComReplaceStr(val2,",",""));
 	
 	var val3 = roundPrecision(fval1 / fval2,2) * 100; 	
 	
 	//var per = ComAddComma2(val3,"#,###.00")+'%';
 	
 	return val3+'%';	
}

function sheet2_OnSearchEnd(sheet, ErrMsg) {
	
	if(sheet.RowCount <= 0 )  {
		return;
	}
	
	if(combo1.Code=="3"){
		
		sheet.SumText(0,"area_report_by_nm")="Total (%)";
		for(var i=3; i<30; i= i+2){
			sheet.SumText(0,i)="100%";			
		}	
	}else if(combo1.Code=="4"){
		sheet.SumText(0,"hofc_report_by_nm")="Total (%)";
		sheet.ShowSubSum("hofc_report_by_nm", "36|38|40|42|44|46|48|50|52|54", true, false);
		for(var i=33; i<60; i= i+2){
			sheet.SumText(0,i)="100%";			
		}
	}else if(combo1.Code=="5"){
		sheet.SumText(0,"trnk_ref_vvd_no")="Grand Total (%)";
		for(var i=62; i<89; i= i+2){
			sheet.SumText(0,i)="100%";			
		}
	}else if(combo1.Code=="6"){
		sheet.SumText(0,"clm_pty_abbr_nm")="Grand Total (%)";
		for(var i=91; i<118; i= i+2){
			sheet.SumText(0,i)="100%";			
		}
	
	}
	
	sheet.ApplyFormat() ;
}


/**
  * 시트 초기설정값, 헤더 정의
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj, sheetNo) {
	var cnt = 0;
	with (sheetObj) {
		switch (sheetObj.id) {
		case "sheet1": 
			 // 높이 설정
			style.height = 442;
								
			//전체 너비 설정
			SheetWidth = mainTable.clientWidth;

			//Host정보 설정[필수][HostIp, Port, PagePath]
			if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

			//전체Merge 종류 [선택, Default msNone]
			//MergeSheet = msHeaderOnly;
			MergeSheet = msAll;

			//전체Edit 허용 여부 [선택, Default false]
			Editable = true;

			//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=500]
			InitRowInfo(2, 1, 15, CNI_PAGE_SIZE);

			//  Area/TOC    29
			var HeadTitle1 = "|Area|Total|Total|Total|Total|Contamination|Contamination|Contamination|Contamination|Physical Damage|Physical Damage|Physical Damage|Physical Damage|Wet Damage|Wet Damage|Wet Damage|Wet Damage|Shortage|Shortage|Shortage|Shortage|Non-Delivery|Non-Delivery|" 
							+ "Non-Delivery|Non-Delivery|Reefer DOL|Reefer DOL|Reefer DOL|Reefer DOL|Others|Others|Others|Others";
			var HeadTitle2 = "|Area|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" 
							+ "Case|%|Amount|%|Case|%|Amount|%";
			
			//  HOFC/TOC 30
			HeadTitle1 = HeadTitle1 +"|"+"Area|HOFC|Total|Total|Total|Total|Contamination|Contamination|Contamination|Contamination|Physical Damage|Physical Damage|Physical Damage|Physical Damage|Wet Damage|Wet Damage|Wet Damage|Wet Damage|Shortage|Shortage|Shortage|Shortage|Non-Delivery|Non-Delivery|" +
			 "Non-Delivery|Non-Delivery|Reefer DOL|Reefer DOL|Reefer DOL|Reefer DOL|Others|Others|Others|Others";
			HeadTitle2 = HeadTitle2 +"|"+ "Area|HOFC|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
			 "Case|%|Amount|%|Case|%|Amount|%";
						
			//  Cargo Origin/Destination   21
			HeadTitle1 = HeadTitle1 +"|"+"Origin/Destination|Total|Total|Total|Total|America|America|America|America|Europe|Europe|Europe|Europe|North Asia|North Asia|North Asia|North Asia|China|China|" +
			 "China|China";
			HeadTitle2 = HeadTitle2 +"|"+ "Origin/Destination|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|";
			
			var headCount = ComCountHeadTitle(HeadTitle1);
								
			//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
			InitColumnInfo(headCount, 0, 0, true);
		
			// 해더에서 처리할 수 있는 각종 기능을 설정한다
			InitHeadMode(true, true, false, true, false,false);
		
			//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
			InitHeadRow(0, HeadTitle1, true);
			InitHeadRow(1, HeadTitle2, true);
		  
		   //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
		 
			InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
			//  Area/TOC
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"area_report_by_nm",	false,	"",	dfNone,	0,	false,	false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case0",	false,	"",	dfNumber,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case0",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt0",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case1",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case1",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt1",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case2",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case2",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt2",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case3",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case3",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt3",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case4",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case4",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt4",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case5",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case5",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt5",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case6",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case6",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt6",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case7",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case7",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt7",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt7",	false,	"",	dfNone,	0,	false,  false);
			
			//  HOFC/TOC
			InitDataProperty(0, cnt++ , dtData,				120,	daCenter,	true,		"hofc_report_by_nm",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtData,				80,		daCenter,	true,		"hofc",			false,	"",	dfNone,	0,	false,	false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case0",	false,	"",	dfNumber,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case0",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt0",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case1",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case1",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt1",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case2",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case2",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt2",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case3",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case3",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt3",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case4",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case4",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt4",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case5",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case5",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt5",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case6",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case6",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt6",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case7",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case7",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt7",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt7",	false,	"",	dfNone,	0,	false,  false);
				
			//  Cargo Origin/Destination
			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"cargo_report_by_nm",	false,	"",	dfNone,	0,	false,	false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_case0",	false,	"",	dfNumber,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_case0",	false,	"",	dfNone,	0,	false,	false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"cargo_amt0",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_case1",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_case1",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"cargo_amt1",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_case2",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_case2",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"cargo_amt2",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_case3",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_case3",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"cargo_amt3",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
			
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_case4",	false,	"",	dfNumber,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_case4",	false,	"",	dfNone,	0,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"cargo_amt4",	false,	"",	dfFloat,	2,	false,  false);
			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"cargo_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
			
					
			CountFormat = "[SELECTDATAROW / TOTALROWS]";
			
			break;	
			
			case "sheet2": 
                // 높이 설정
				style.height = 442;
									
				//전체 너비 설정
				SheetWidth = mainTable.clientWidth;

				//Host정보 설정[필수][HostIp, Port, PagePath]
				if (location.hostname != "") InitHostInfo(location.hostname, location.port, page_path);

				//전체Merge 종류 [선택, Default msNone]
				//MergeSheet = msHeaderOnly;
				MergeSheet = msAll;

				//전체Edit 허용 여부 [선택, Default false]
				Editable = true;

				//행정보설정[필수][HEADROWS,DATAROWS,VIEWROWS,ONEPAGEROWS=100]
				InitRowInfo(3, 1, 15, 100);

				//  Total Occurrence by Area  29
				var HeadTitle1 = "|Area|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
						 "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
				
				var HeadTitle2 = "|Area|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
						 " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
				
				var HeadTitle3 = "|Area|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
						 "Case|%|Amount|%|Case|%|Amount|%";
							
				//  Total Occurrence by HOFC  30
				HeadTitle1 = HeadTitle1 +"|"+ "Area|HOFC|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
				 "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
		
				HeadTitle2 = HeadTitle2 +"|"+ "Area|HOFC|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
				 " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
		
				HeadTitle3 = HeadTitle3 +"|"+ "Area|HOFC|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
				 "Case|%|Amount|%|Case|%|Amount|%";
						
				//  Total Occurrence by VVD   29
				HeadTitle1 = HeadTitle1 +"|"+"VVD|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
				 "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
		
				HeadTitle2 = HeadTitle2 +"|"+ "VVD|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
				 " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
		
				HeadTitle3 = HeadTitle3 +"|"+ "VVD|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
				 "Case|%|Amount|%|Case|%|Amount|%";
				
				//  Total Occurrence by Claimant  29
				HeadTitle1 = HeadTitle1 +"|"+ "Claimant|Carried Over|Carried Over|Carried Over|Carried Over|New Received|New Received|New Received|New Received|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Settled|Total Settled|Total Settled|" +
				 "Total Settled|Total Settled|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding|Outstanding";
		
				HeadTitle2 = HeadTitle2 +"|"+ "Claimant|  |  |  |  | | | | |New Received Claims|New Received Claims|New Received Claims|New Received Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims|Carried Over Claims| | |" +
				 " | |For Carry Over|For Carry Over|For Carry Over|For Carry Over|+ / -|+ / -|+ / -|+ / -";
		
				HeadTitle3 = HeadTitle3 +"|"+ "Claimant|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|Case|%|Amount|%|" +
				 "Case|%|Amount|%|Case|%|Amount|%";
		
				
				var headCount = ComCountHeadTitle(HeadTitle1);
									
				//컬럼정보설정[필수][COLS,FROZENCOL,LEFTHEADCOLS=0,FROZENMOVE=false]
				InitColumnInfo(headCount, 0, 0, true);

				// 해더에서 처리할 수 있는 각종 기능을 설정한다
				InitHeadMode(true, true, false, true, false,false);

				//해더행정보[필수][ROW,HEADTEXT,ROWMERGE=false, HIDDEN=false]
				InitHeadRow(0, HeadTitle1, true);
				InitHeadRow(1, HeadTitle2, true);
               	InitHeadRow(2, HeadTitle3, true);
               			
                //데이터속성    [ROW, COL,  DATATYPE,		WIDTH, DATAALIGN,	COLMERGE,	SAVENAME,  KEYFIELD, CALCULOGIC, DATAFORMAT, POINTCOUNT, UPDATEEDIT, INSERTEDIT, EDITLEN, FULLINPUT, SORTENABLE, TOOLTIP, ALLCHECK, SAVESTATUS, FORMATFIX]
              
               	InitDataProperty(0, cnt++ , dtHiddenStatus,	0,		daCenter,	true,		"ibflag");
               	//  Total Occurrence by Area
    			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"area_report_by_nm",	false,	"",	dfNone,	0,	false,	false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case0",	false,	"",	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case0",	false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt0",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case1",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case1",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt1",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case2",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case2",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt2",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case3",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case3",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt3",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case4",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case4",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt4",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case5",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case5",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt5",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_case6",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_case6",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"area_amt6",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"area_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
    			
    			//  Total Occurrence by HOFC
    			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"hofc_report_by_nm",	false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtData,			80,	daCenter,	true,		"hofc",	false,	"",	dfNone,	0,	false,	false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case0",	false,	"",	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case0",	false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt0",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case1",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case1",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt1",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case2",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case2",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt2",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case3",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case3",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt3",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case4",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case4",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt4",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case5",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case5",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt5",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_case6",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_case6",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"hofc_amt6",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"hofc_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
    		
				//  Total Occurrence by VVD
    			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"trnk_ref_vvd_no",	false,	"",	dfNone,	0,	false,	false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case0",	false,	"",	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case0",	false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt0",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case1",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case1",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt1",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case2",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case2",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt2",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case3",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case3",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt3",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case4",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case4",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt4",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case5",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case5",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt5",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_case6",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_case6",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"vvd_amt6",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"vvd_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
    			
				//  Total Occurrence by Claimant
    			InitDataProperty(0, cnt++ , dtData,			120,	daCenter,	true,		"clm_pty_abbr_nm",	false,	"",	dfNone,	0,	false,	false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case0",	false,	"",	dfNumber,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case0",	false,	"",	dfNone,	0,	false,	false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt0",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt0",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case1",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case1",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt1",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt1",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case2",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case2",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt2",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt2",	false,	"",	dfNone,	0,	false,  false);
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case3",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case3",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt3",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt3",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case4",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case4",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt4",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt4",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case5",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case5",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt5",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt5",	false,	"",	dfNone,	0,	false,  false);	
    			
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_case6",	false,	"",	dfNumber,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_case6",	false,	"",	dfNone,	0,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			100,	daRight,	false,		"claimant_amt6",	false,	"",	dfFloat,	2,	false,  false);
    			InitDataProperty(0, cnt++ , dtAutoSum,			50,		daRight,	false,		"claimant_pct_amt6",	false,	"",	dfNone,	0,	false,  false);
    			
				CountFormat = "[SELECTDATAROW / TOTALROWS]";
				
				break;	
			
		}
	}
}


// ===================================================================================
// Private function
// ===================================================================================
function setTemplate(indexCode){
	
	var isSheet1 = false;
	var vSheetColCount = 0;
	var vStart = 0;
	var vEnd = 0;

	
	if( indexCode<3 ){
		isSheet1 = true;
		document.all.tbl1.style.display="";
		document.all.tbl2.style.display="none";
	}else{
		isSheet1 = false;
		document.all.tbl1.style.display="none";
		document.all.tbl2.style.display="";
	}

	if(isSheet1){
		
		vSheetColCount = sheet1.LastCol+1;
		if(indexCode==0){
			vStart = 1;
			vEnd = 	33;
		}else if(indexCode==1){
			vStart = 34;
			vEnd = 	67;
		}else if(indexCode==2){
			vStart = 68;
			vEnd = 	88;
		}
	    
	    for(var idx=0;idx<=vSheetColCount;idx++){
	    	sheet1.ColHidden(idx) = true;
	    }
	    
	    	    
	    for(var jdx=vStart;jdx<=vEnd;jdx++){
	    	sheet1.ColHidden(jdx) = false;
	    }
	    
	    sheet1.RemoveAll();
	
	}else {
		
		vSheetColCount = sheet2.LastCol+1;
		if(indexCode==3){
			vStart = 1;
			vEnd = 	29;
		}else if(indexCode==4){
			vStart = 30;
			vEnd = 	59;
		}else if(indexCode==5){
			vStart = 60;
			vEnd = 	88;	
		}else if(indexCode==6){
			vStart = 89;
			vEnd = 	117;
		}
	    
	    for(var idx=0;idx<=vSheetColCount;idx++){
	    	sheet2.ColHidden(idx) = true;
	    }
	    
	    	    
	    for(var jdx=vStart;jdx<=vEnd;jdx++){
	    	sheet2.ColHidden(jdx) = false;
	    }
	    
	    sheet2.RemoveAll();
		
	}
	
	

   
}
    
 function setClassCodeList() {

		combo1.RemoveAll();			
			
		for(var i=0 ; i < classCodeList.length ; i++ ) {			
			var clist = classCodeList[i];			
			combo1.InsertItem(i,clist["clss_clm_misc_nm"],clist["clss_clm_misc_cd"]);
		}		
	}

// ===================================================================================
// Form 이벤트 처리
// ===================================================================================

// 버튼클릭이벤트를 받아 처리하는 이벤트핸들러 정의
document.onclick = processButtonClick;


/**
 * 버튼 네임으로 구분하여 프로세스를 분기처리하는 이벤트핸들러
 */
function processButtonClick() {

	var srcName = window.event.srcElement.getAttribute("name");
	
	switch (srcName) {	
	
		case "btn1_Retrieve":
			
			doActionIBSheet(SEARCHLIST01);					
			
			break;	
	    case "btn1_New":
	    	sheet1_OnLoadFinish(sheet1);
	    	sheet1.RemoveAll();
	    	sheet2.RemoveAll();
	    	loadPage();
	        break;	

		case "btn1_Print":	
			doActionIBSheet(PRINT);
	        break; 
		case "btn1_DownExcel":
			if( (combo1.Code=="0")||(combo1.Code=="1")||(combo1.Code=="2") ) {
				sheet1.SpeedDown2Excel(-1);	
			}else {
				sheet2.SpeedDown2Excel(-1);
			}
			break;
		case "btns_from_period":
		case "btns_to_period":
			var result = srcName.replace("btns_", "");
		    calObj = eval("frm." + result );
			var vCal = new ComCalendar();
			vCal.setDisplayType('date');
			vCal.select(calObj, 'yyyy-MM-dd');
			break;	
	}

} 

/**
 * HTML Control KeyUp 이벤트 호출
 */
function obj_keyup() {	  
	 if((event.keyCode >= 37)&&(event.keyCode <= 40)) return;
	 switch (event.srcElement.name) {    
		case "from_period":  			
			if( event.keyCode == 13 ){
				doActionIBSheet(SEARCHLIST01);
			}
			break;
		case "to_period":  			
			if( event.keyCode == 13 ){
				doActionIBSheet(SEARCHLIST01);
			}
			break;	
	}
}  

/**
 * HTML Control KeyPress 이벤트 호출
 */
function obj_keypress() {
    switch (event.srcElement.name) {    
    case "acct_xch_rt_yrmon":    	
    case "usd_krw_xch_rt":
		break;
	}
}
 
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm = document.form;
	switch (event.srcElement.name) {
	case "acct_xch_rt_yrmon":
		break;
	case "usd_krw_xch_rt":		
		break;
	default:
		ComChkObjValid(event.srcElement);
	}
}

/**
 * HTML Control Foucs in
 */
function obj_activate(){
    ComClearSeparator(event.srcElement);
}

// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 
 function sheet2_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {	
		frm.page_no.value = PageNo;  
		doActionIBSheet(SEARCHLIST01);
 } 


/**
 * 이미지 팝업 클릭
 * @param {IBSheet} sheet
 * @param {long} row 해당 셀의 Row Index
 * @param {long} col 해당 셀의 Column Index
 */
function sheet1_OnPopupClick(sheet, row, col) {
   

}


/**
 * 업무 처리 이벤트
 * @param {string} sAction 액션타입 
 */
function doActionIBSheet(sAction) {
	
	if (sAction == SEARCHLIST01) {
				
		frm.f_cmd.value = SEARCHLIST01;		
		frm.report_by.value = combo1.Code;		
		
		var from_period = ComGetObjValue(frm.from_period);
		var to_period = ComGetObjValue(frm.to_period);
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		
		// Form Object Data 
		var vFormData = FormQueryString(frm);
		
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
	
		var sXml = sheet1.GetSearchXml("CPS_CNI_0021GS.do", vFormData);		
		var arrXml = sXml.split("|$$|");
		
		
		if (arrXml.length > 0) {
			if( (combo1.Code=="0")||(combo1.Code=="1")||(combo1.Code=="2") ) {
				sheet1.LoadSearchXml(arrXml[0]);		
			}else {
				sheet2.LoadSearchXml(arrXml[0]);	
			}
			
		}else{
			ComShowCodeMessage("CNI00013");
		}
		
		ComAddSeparator(frm.sch_from_str,"ymd");
		ComAddSeparator(frm.sch_to_str,"ymd");
	
		
	} else if (sAction == INIT) {
		
		frm.f_cmd.value = INIT;
		var sXml = sheet1.GetSearchXml("CPS_CNI_0028GS.do", FormQueryString(frm));
		var arrXml = sXml.split("|$$|");

		// ------------------------------------------------------------
		// combo  설정 
		// ------------------------------------------------------------
		if (arrXml.length > 0) {
						
			classCodeList = SheetXml2ListMap(arrXml[0]);		
			//setClassCodeList();	
		}
	
	} else if (sAction == PRINT) {
		
		frm.f_cmd.value = PRINT;
		frm.report_by.value = combo1.Code;		
		var ctype = combo1.Code;
		var printNumber = "";
		var bodyTitle = "";
		
		var from_period = ComGetObjValue(frm.from_period);
		var to_period = ComGetObjValue(frm.to_period);
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		
		// Form Object Data 
		var vFormData = FormQueryString(frm);
		
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		
		if(ctype=="0"){
			printNumber = "0077";
			bodyTitle = "Occurrence Analysis by Area/TOC";
		}else if(ctype=="1"){
			printNumber = "0078";
			bodyTitle = "Occurrence Analysis by HOFC/TOC";
		}else if(ctype=="2"){
			printNumber = "0079";
			bodyTitle = "Occurrence Analysis by Cargo Origin/Destination";
		}else if(ctype=="3"){
			printNumber = "0080";
			bodyTitle = "Total Occurrence by Area";
		}else if(ctype=="4"){
			printNumber = "0081";
			bodyTitle = "Total Occurrence by HOFC";
		}else if(ctype=="5"){
			printNumber = "0082";
			bodyTitle = "Total Occurrence by VVD";
		}else if(ctype=="6"){
			printNumber = "0083";
			bodyTitle = "Total Occurrence by Claimant";
		}

		var rf = "/rf ["+RDServerIP + "/CPS_CNI_"+printNumber+".do]";
		var rpost =  "/rpost ["+vFormData+"]";
		var rv = "/rv " + getCondAllValue();
		var rpaper = "/rpaper [A4]";

		if (frm.usr_area.value == "A") {
			rpaper = "/rpaper [LETTER]";
		}
		
		frm.com_mrdArguments.value = rf +" "+ rv +" "+ rpost +" "+ rpaper;
		frm.com_mrdTitle.value = bodyTitle;
		frm.com_mrdBodyTitle.value = bodyTitle;
		frm.com_mrdPath.value = "apps/alps/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_"+printNumber+".mrd";
		//var feature = "resizable=yes,width=1000,height=600";
		popupRd(1000,600);
		
	}   
}
 
 function getCondAllValue(){
		
		var vObjects = frm.elements;
		var vCondStr = "";
		for ( var kdx = 0; kdx < vObjects.length; kdx++) {
			var vObj   = vObjects[kdx];
			var vObjTp = vObj.type;
			var vObjNm = vObj.name;
	    	
			if (typeof(vObjNm) == "undefined" || vObjNm == "" || vObjTp == "hidden"){
				continue;
			}

			vCondStr += "p_" + vObjNm + "[" +  ComGetObjValue(vObj) + "]";
		} //end for
		
		vCondStr += "rd_report_by["+frm.rd_report_by.value+"]"+"rd_title_nm["+frm.rd_title_nm.value+"]";//hidden 값중 일부를 넘겨야함.
		return vCondStr;
	}
 

