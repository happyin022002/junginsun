/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : cps_cni_0032.js
 *@FileTitle: [CPS_CNI_0020] Report-Settlement Analysis
 *@author   : CLT
 *@version  : 1.0
 *@since    : 2014/06/23
 =========================================================*/
/**
 * [cps_cni_0020] Report-Settlement Analysis
 * @extends
 * @class Find 생성을 위한 화면에서 사용하는 업무 스크립트를
 *        정의한다.
 */
//function cps_cni_0020() {
//    this.processButtonClick=processButtonClick;
//    this.setSheetObject=setSheetObject;
//    this.loadPage=loadPage;
//    this.initSheet=initSheet;
//    this.initControl=initControl;
//    this.doActionIBSheet=doActionIBSheet;
//    this.validateForm=validateForm;
//}
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
// IBmultiCombo
var comboObjects=new Array();
var comboCnt=0;
var comboText1="ALL";//RD를 위한변수 초기값을 ALL로 출력하기위함(AREA)
var comboText2="ALL";//
var comboText3="ALL";//
var param="";
// html form
var frm=null;
var frm2=null;
// Period 디폴트 세팅날짜.
var strFromDate="";
var strToDate="";
//디폴트 area cd
var clmAreaCd="";
var area_cd="";//area cd
var mainCode="";
var locationCode="";
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
 /**
  * registering IBCombo Object as list
  * @param comboObj
  **/
 function setComboObject(comboObj){
 	comboObjects[comboCnt++]=comboObj;
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
	frm2=document.form2;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;
    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }
	// IBMultiComboinitializing
	comboCnt=comboObjects.length;
	for(var j=0; j<comboCnt; j++){
		initCombo(comboObjects[j],j+1);
	}
	initComboBox();
    // Period디폴트 세팅날짜.
	strFromDate=frm.schFromStrGmt.value;
	strToDate=frm.schToStrGmt.value;
	frm.from_period.value=strFromDate;
	frm.to_period.value=strToDate;
	frm.rd_title.value=ComGetObjText(report_by);
    //registering initial event 
    initControl();
//    sheet1_OnSearchEnd(sheet1);  
}
/**
* registering initial event 
*/
function initControl() {
//   axon_event.addListenerForm('keypress', 'obj_keypress', frm);
//   axon_event.addListenerForm ('keydown', 'obj_keydown', frm);
   axon_event.addListenerForm ('change', 'obj_change', frm);
   axon_event.addListenerForm('beforedeactivate', 'obj_deactivate',  frm);
 //  axon_event.addListenerFormat('beforeactivate',   'obj_activate',    frm);
}
 /**
  * 초기 콤보 설정
  **/
 function initComboBox() {
 	var sXml2=frm2.sXml.value;	
 	var arrXml=sXml2.split("|$$|");
	var idx=0;
    setMultiComboBox("report_by" ,  arrXml[idx] ); //40 report_by [1]
	idx++;
    setMultiComboBox("period" ,  arrXml[idx] ); //25 period [2]
	idx++;
 	setMultiComboBox("area" ,  arrXml[idx] ); //09 Area [3]
	idx++;
	setMultiComboBox("combo_status" ,  arrXml[idx] ); //08 status [4]
	idx++;
	setMultiComboBox("vt" ,  arrXml[idx] ); //39 Claim class [5]
	idx++;
	setMultiComboBox("inci_plc_tp_cd" ,  arrXml[idx] ); //14 poi [6]
	idx++;
	setMultiComboBox("cgo_clm_stl_tp_cd" ,  arrXml[idx] ); //07 tos [7]
	idx++;
	setMultiComboBox("crr_term_cd" ,  arrXml[idx] ); //06 CT (terms of carriage ) [8]
	idx++;
	setMultiComboBox("cgo_clm_tp_cd" ,  arrXml[idx] ); //11 TOC (Type of Cargo Claim ) [9]
	idx++;
  	//Area Cd Setting
 	var dataCount=ComGetTotalRows(arrXml[idx]);// [6]
 	if (dataCount > 0) {
 		var list=SheetXml2ListMap(arrXml[idx]);	// [6]
 		var listVO=list[0];
 		clmAreaCd=listVO["clm_area_cd"];
		ComSetObjValue(area,clmAreaCd);//초기값세팅
	}
	ComSetObjValue(period,"DON");
	ComSetObjValue(vt, "G");
//	ComSetObjValue(report_by, ComGetObjText(report_by));
	report_by.SetSelectIndex(0);
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo 시트번호
  */
function initSheet(sheetObj,sheetNo) {
	var cnt=0;
	switch(sheetObj.id) {
		case "sheet1":      //sheet1 init
			with (sheetObj) {
	      
		        var HeadTitle1="|Seq.|Area|Area|Claimed|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Detail of Settlement by Type|Outstanding|Outstanding|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment|" +
		        "Detail of Payment|Detail of Payment|Detail of Payment|Detail of Payment";
		        var HeadTitle2="|Seq.|Area|Area|Claimed|Paid|Time Barred|Withdrawn|Repudiated|Tender of Defense|Dismissed|Total| | |Paid|Paid|LP Recovered|LP Recovered|INS Recovered|INS Recovered|" +
		        "Total Recovered|Total Recovered|Net Paid|Net Paid";
		        var headCount=ComCountHeadTitle(HeadTitle1);
		        //(headCount, 0, 0, true);
	
		        SetConfig( { SearchMode:2, MergeSheet:8, Page:20, DataRowMerge:0 } );
	
		        var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
		        var headers = [ { Text:HeadTitle1, Align:"Center"},
		                    { Text:HeadTitle2, Align:"Center"} ];
		        InitHeaders(headers, info);
	
		        var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		               {Type:"Text",      Hidden:0,  Width:30,   Align:"Center",  ColMerge:1,   SaveName:"data_seq",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:150,  Align:"Left",    ColMerge:1,   SaveName:"report_by",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:70,   Align:"Center",  ColMerge:0,   SaveName:"div",                KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"claimed",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"paid",               KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"time_barred",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"withdrawn",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"repudiated",         KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tender_defence",     KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"dismissed",          KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"tot",                KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"outstanding",        KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"outstanding_p",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"paid_dp",            KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"paid_dp_p",          KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"lp_recovered",       KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"lp_recovered_p",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"ins_recovered",      KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"ins_recovered_p",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"total_recovered",    KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"total_recovered_p",  KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Float",     Hidden:0,  Width:120,  Align:"Right",   ColMerge:0,   SaveName:"net_paid",           KeyField:0,   CalcLogic:"",   Format:"Float",       PointCount:2,   UpdateEdit:0,   InsertEdit:0 },
		               {Type:"Text",      Hidden:0,  Width:60,   Align:"Right",   ColMerge:0,   SaveName:"net_paid_p",         KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		         
		        InitColumns(cols);
		        SetEditable(0);
		        SetSheetHeight(320);
		        SetMergeCell(0, 2, 2, 2);//Report by
		        SetMergeCell(0, 4, 2, 1);//Claimed
		        SetCountFormat("[SELECTDATAROW / TOTALROWS]");
		   }
			break;
	}
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
		if(comboNo >= 4){
			comboObj.SetBackColor("#ffffff");
		}else{
			comboObj.SetBackColor("#CCFFFD");
		}
		comboObj.SetColAlign(0, "left");
		comboObj.SetColAlign(1, "left");
		comboObj.SetMultiSeparator(",");
		comboObj.SetDropHeight(175);
	}
} 
// ===================================================================================
// Private function
// ===================================================================================
/**
 * setting Location
 */
 function setLocation(rowArray) { 
 	  if (locationCode == "POR"){
        frm.por_cd.value=rowArray[0][3];
    } else if ( locationCode == "DEL") {
       frm.del_cd.value=rowArray[0][3]; 
    }	    
 }
// 달력 화면 표시 공통  함수
function calendarDisplay (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('date');
	vCal.select(pInputObj, 'yyyy-MM-dd');
}
function setOfficeCode(ofcCd){
	frm.hndl_ofc_cd.value=ofcCd;
}
function setMainCodeInquiry(partyVo) {
	switch(mainCode){
	case "claimant":
		frm.clmt_clm_pty_no.value=partyVo.clm_pty_no;
		frm.clmt_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		break;
	case "claimant_agent":
		frm.clmt_clm_agn_pty_no.value=partyVo.clm_pty_no;
		frm.clmt_clm_agn_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		break;	
	case "insurer":
		frm.insur_clm_pty_no.value=partyVo.clm_pty_no;
		frm.insur_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		break;
	case "liable_party":
		frm.labl_clm_pty_no.value=partyVo.clm_pty_no;
		frm.clm_liable_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		break;
	case "salvager":
		frm.slv_clm_pty_no.value=partyVo.clm_pty_no;
		frm.slv_clm_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
	 	break;
	case "surveyor":
		frm.svey_clm_pty_no.value=partyVo.clm_pty_no;
		frm.clm_surveyor_pty_abbr_nm.value=partyVo.clm_pty_abbr_nm;
		break
	}
} 
//Miscellaneous 팝업창에서 호출한 함수
function setMiscCode(miscCdVO){
	var clss_clm_misc_cd=miscCdVO.clss_clm_misc_cd;
	switch(clss_clm_misc_cd){
		case "02":
			frm.mjr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "05":
			frm.minr_clm_dmg_lss_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "11":
			cgo_clm_tp_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "14":
			inci_plc_tp_cd.value=miscCdVO.clm_misc_cd;
			break;
		case "15":
			frm.clm_cgo_tp_cd.value=miscCdVO.clm_misc_cd;
			frm.clm_cgo_tp_nm.value=miscCdVO.clm_misc_nm;
			break;	
	}
}
// ===================================================================================
// Form 이벤트 처리
// ===================================================================================
// Event handler processing by button click event
document.onclick=processButtonClick;
// Event handler processing by button name */
function processButtonClick(){
		var srcName=ComGetEvent("name");
		if(ComGetBtnDisable(srcName)) return false;
		switch(srcName) {
			case "btn1_Retrieve":
				sheet1.RemoveAll();//append mode로 paging 처리하므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
				break;	
			case "btn1_New":
				ComResetAll();
				var report_by_val = ComGetObjText(report_by);
				if(report_by_val == "") {
					report_by_val = "01";
				}
				ComSetObjValue(report_by, report_by_val);
				var report_by_val_text = ComGetObjText(report_by_text);
				sheet1.SetCellValue(0, 2,report_by_val_text);
				sheet1.SetCellValue(0, 3,report_by_val_text);
				ComSetObjValue(frm.from_period,ComGetNowInfo("yy") + "-01-01");
				ComSetObjValue(frm.to_period,ComGetNowInfo());
				ComSetObjValue(period,"DON");
				ComSetObjValue(vt, "G");
				ComSetObjValue(combo_status, "All");
				ComSetObjValue(area, clmAreaCd);//초기값세팅
//				ComSetObjValue(report_by_text, "Area");
				break;
			case "btn1_Down_Excel":
				 if(sheet1.RowCount() < 1){//no data
             		  ComShowCodeMessage("COM132501");
     	       	}else{
     	       		sheet1.Down2Excel( {DownCols: makeHiddenSkipCol(sheet1), SheetDesign:1,Merge:1 });
     	       		
     	       	}
                break;
			case "btn1_Print":
				if (sheet1.RowCount()<= 0 ) {
					//msgs["CNI00024"] = "There is no data to print.";
					ComShowCodeMessage("CNI00024");
					return;
				}
				doActionIBSheet(PRINT);
				break; 
			case "btns_date_cal1":
				calendarDisplay(frm.sch_from_str);
				break;
			case "btns_date_cal2":
				calendarDisplay(frm.sch_to_str);
				break;
			case "btn1_Cargo":
				popupMainMiscView("15");
				break;
			case "btn1_TOC":
				popupMainMiscView("11");
				break;
			case "btn1_CODL1":
				popupMainMiscView("02");
				break;
			case "btn1_CODL2":
				popupMainMiscView("05");
				break;
		    case "btn1_POI":
				popupMainMiscView("14");
				break;
		    case "btn1_POR":
				//공통팝업 Location호출
				var locCd=frm.por_cd.value;
				locationCode="POR";
				popupLocation(locCd);
				break;
			case "btn1_DEL":
				//공통팝업 Location호출
				var locCd=frm.del_cd.value;
				locationCode="DEL";
				popupLocation(locCd);
				break ;
			case "btn1_Liable_Party":
			case "btn1_Surveyor":
			case "btn1_Claimant":
			case "btn1_Claimant_Agent":
			case "btn1_Salvager":
			case "btn1_Insurer":
				mainCode=srcName.replace("btn1_", "").toLowerCase();
				popupMainCodeInquiry();
				break;
			case "btns_from_period":
			case "btns_to_period":
				var result=srcName.replace("btns_", "");
			    calObj=eval("frm." + result );
				var vCal=new ComCalendar();
				vCal.setDisplayType('date');
				vCal.select(calObj, 'yyyy-MM-dd');
				break;
			case "btns_hndl_ofc_cd":
				popupOfficeCode();
				break;
		} // end switch
}
/**
 * HTML Control KeyPress event
 */
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
        case "yyyy":
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
        case "userYmd":
            ComKeyOnlyNumber(obj, "-");
            break;
    }
}
///**
// * HTML Control Click event
// */
//function obj_change() {
//    switch (ComGetEvent("name")) {  
//
//		case "report_by":
//			alert(ComGetObjText(report_by));
//			//1.Grid Title Setting
//				sheet1.CellValue(0, 2)  = ComGetObjText(report_by);
//				sheet1.CellValue(0, 3)  = ComGetObjText(report_by); 
//				sheet1.CellValue(1, 2)  = ComGetObjText(report_by);
//				sheet1.CellValue(1, 3)  = ComGetObjText(report_by); 
//			//2. RD Title Setting
//			    frm.rd_title.value = ComGetObjText(report_by);
//			   
//			//Month 선택시 고려사항.    
//			frm.to_period.readOnly = false;
//			if(frm.from_period.value.length < 8){//계속 initializing됨을 막기위함.
//				frm.from_period.value = strFromDate;
//			}
//			if(frm.to_period.value.length < 8){
//				frm.to_period.value = strToDate;
//			}
//			
//			if(report_by.Code == 'MONTH'){
//				frm.to_period.value="";
//				frm.to_period.readOnly = true;
//				ComSetObjValue(frm.from_period,strToDate.substring(0,4));
//			}
//			if(report_by.Code == 'YEAR'){
//				var fromYear = getDateObj(strFromDate).getYear()-1;//getDateObj <- CoCommon.js
//				ComSetObjValue(frm.from_period,fromYear);
//				ComSetObjValue(frm.to_period,strToDate.substring(0,4));
//			}
//		break;
//	}
//}
/**
 * HTML Control KeyDowm event
 */
function obj_keydown() {
	 if (event.keyCode != 13) {
  		 return;
  	 }
    switch (ComGetEvent("name")) {    
		default:
			if (!ComIsNull(frm.from_period.value) && !ComIsNull(frm.to_period.value)) {
				sheet1.RemoveAll();//append mode이므로 remove 해야함.
				frm.page_no.value="1";
				doActionIBSheet(SEARCHLIST01);
			}
		break;
	}
}
/**
 * HTML Control Focus out
 **/
function obj_deactivate() {	 
	var frm=document.form;
	switch (ComGetEvent("name")) {
	case "from_period":
	case "to_period":
		    if(report_by.GetSelectCode()== "33" || report_by.GetSelectCode()== "32"){
		    	//obj.dataformat="yyyy";
		    	obj.dataformat="ymd";
		    }else{
		    	obj.dataformat="ymd";
		    }
		    ComChkObjValid(ComGetEvent());
		break;
	default:
		ComChkObjValid(ComGetEvent());
	}
}
/**
 * HTML Control Foucs in
 */
function obj_activate(){
	obj=ComGetEvent();
	if (obj.getAttribute("readOnly")) return;
	switch (ComGetEvent("name")) {  
		//조회날짜 입력항목이 YEAR, MONTH 의 경우 년도 만 입력하므로 Common Script 를 사용하지 않고 별도로 작성함.
		case "from_period":
		case "to_period":
		    if(report_by.GetSelectCode()== "33" || report_by.GetSelectCode()== "32"){
		    //	obj.dataformat="yyyy";
		    	obj.dataformat="ymd";
		    }else{
		    	obj.dataformat="ymd";
		    }
		    ComClearSeparator(obj);
			break;
		default:
			ComClearSeparator(obj);
	}
}
function report_by_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	//1.Grid Title Setting
//	sheet1.SetCellValue(0, 2,ComGetObjText(report_by));
//	sheet1.SetCellValue(0, 3,ComGetObjText(report_by));
//	sheet1.SetCellValue(1, 2,ComGetObjText(report_by));
//	sheet1.SetCellValue(1, 3,ComGetObjText(report_by));
	sheet1.SetCellValue(0, 2,report_by.GetSelectText());
	sheet1.SetCellValue(0, 3,report_by.GetSelectText());
	sheet1.SetCellValue(1, 2,report_by.GetSelectText());
	sheet1.SetCellValue(1, 3,report_by.GetSelectText());
	//2. RD Title Setting
	formObj.rd_title.value=ComGetObjText(report_by);
	//Month 선택시 고려사항.    
	formObj.to_period.readOnly=false;
	if(formObj.from_period.value.length < 8){//계속 initializing됨을 막기위함.
		formObj.from_period.value=strFromDate;
	}
	if(formObj.to_period.value.length < 8){
		formObj.to_period.value=strToDate;
	}
	

/*	if(report_by.GetSelectCode()== '32'){ // MONTH == 32
		calendarDisplay2(formObj.from_period);
		calendarDisplay2(formObj.to_period);
		formObj.to_period.value="";
		formObj.from_period.setAttribute("dataformat", "yyyy");
		formObj.to_period.setAttribute("dataformat", "yyyy");
		formObj.to_period.readOnly=true;
		ComSetObjValue(formObj.from_period,strToDate.substring(0,4));
	}
	else if(report_by.GetSelectCode()== '33'){ // YEAR == 33
		calendarDisplay2(formObj.from_period);
		calendarDisplay2(formObj.to_period);
		var fromYear=getDateObj(strFromDate).getFullYear();//getDateObj <- CoCommon.js
		formObj.from_period.setAttribute("dataformat", "yyyy");
		formObj.to_period.setAttribute("dataformat", "yyyy");		
		ComSetObjValue(formObj.from_period,fromYear);
		ComSetObjValue(formObj.to_period,strToDate.substring(0,4));
	}
	else{
		calendarDisplay(formObj.from_period);
		calendarDisplay(formObj.to_period);
		formObj.from_period.setAttribute("dataformat", "ymd");
		formObj.to_period.setAttribute("dataformat", "ymd");	
	}*/
	
}

function calendarDisplay2 (pInputObj){
	var vCal=new ComCalendar();
	vCal.setDisplayType('year');
	vCal.select(pInputObj, 'yyyy');
}
function period_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var arrVal=newText.split("|");
	if(arrVal.length >1){
		comboText1=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText1="ALL";
		}
	}else{
		comboText1=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText1="ALL";
		}
	}
}
function area_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var arrVal=newText.split("|");
	if(arrVal.length >1){
		comboText2=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText2="ALL";
		}
	}else{
		comboText2=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText2="ALL";
		}
	}
	formObj.clm_area_cd.value=ComGetObjValue(comboObj);
}
function combo_status_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var arrVal=newText.split("|");
	if(arrVal.length >1){
		comboText3=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText3="ALL";
		}
	}else{
		comboText3=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText3="ALL";
		}
	}
	formObj.cgo_clm_sts_cd.value=ComGetObjValue(comboObj);
}
function cgo_clm_stl_tp_cd_OnChange(comboObj, oldIndex, oldText, oldCode, newIndex, newText, newCode) {
	var formObj=document.form;
	var arrVal=newText.split("|");
	if(arrVal.length >1){
		comboText5=arrVal[1];//Print 시 코드|코드값 대신 코드값만 출력하기 위함
		if(arrVal[1].trim() == ""){
			comboText5="ALL";
		}
	}else{
		comboText5=arrVal[0];
		if(arrVal[0].trim() == ""){
			comboText5="ALL";
		}
	}
}
// ===================================================================================
// Sheet 이벤트 처리
// ===================================================================================
 function sheet1_OnSearchEnd(sheet, ErrMsg) {
	if(sheet.RowCount()<= 0 )  {
		//msgs["CNI00013"] = "There is no data to search.";
		ComShowCodeMessage("CNI00013");
	}
	else {
		sheet.SetRangeBackColor(sheet.LastRow() - 1,0,sheet.LastRow(), sheet.LastCol(),"#F2D7C9");
	}
 }
  function sheet1_OnDblClick(sheetObj, Row, Col) {
	//alert(Row +" : "+Col)
 }
  function sheet1_OnScrollNext(sheetObj, CondParam, PageNo, OnePageRows) {	
	//스크롤시에 Total 을 숨기기 위함.
	for(var row=1; row <= sheet1.RowCount()+1 ; row++){
		findRow=sheet1.FindText("report_by", "Total", row, -1, false);
		if(findRow != -1){
			sheet1.SetRowHidden(findRow,1);
		}
	}
	//frm.page_no.value = PageNo;  
	frm.page_no.value=Math.ceil(PageNo/2); //amount, case 로 나오므로 page no 를 변형해야한다. : 페이징할경우 그래도 Total 은 해결할 수 없다.
	doActionIBSheet(SEARCHLIST01);
 } 
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {
	//sheetObj.ShowDebugMsg = false;
	if (sAction == SEARCHLIST01) {
		//validateForm 보다 먼저 설정.
		if(report_by.GetSelectCode()== '32'){
	//		ComSetObjValue(frm.to_period,ComGetObjValue(frm.from_period));
		}
		if(!validateForm(sAction)){
			return;
		}
		frm.f_cmd.value=SEARCHLIST01;	
		var from_period=ComGetObjValue(frm.from_period);
		var to_period=ComGetObjValue(frm.to_period);
		var from_clmt_usd_amt=ComGetObjValue(frm.from_clmt_usd_amt);
		var to_clmt_usd_amt=ComGetObjValue(frm.to_clmt_usd_amt);
		var from_cgo_clm_stl_usd_amt=ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
		var to_cgo_clm_stl_usd_amt=ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Mask Clear
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		ComClearSeparator(frm.from_clmt_usd_amt);
		ComClearSeparator(frm.to_clmt_usd_amt);
		ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
		ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Data 
		var vFormData=FormQueryString(frm);
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
		ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
		ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
		ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
		var sXml=sheet1.GetSearchData("CPS_CNI_0020GS.do", vFormData);
		var arrXml=sXml.split("|$$|");
		if (arrXml.length > 0) {
			sheet1.LoadSearchData(arrXml[0],{Append:1 , Sync:0} );
		}
		//Data 가 있을 경우만 아래를 적용함
		if(sheet1.RowCount()==0) return;
		for(var row=1; row <= sheet1.RowCount()+1 ; row++){
			// Total ROW의 컬러적용
			findRow=sheet1.FindText("report_by", "Total", row, -1, false);
			if(findRow != -1){
				sheet1.SetRowBackColor(findRow,"#FFE6E6");
			}
			//아래처럼 설정하면 데이타가 많을 경우 화면세팅시간이 걸림.
			//Total Recovered/Net Paid Case 데이타 컬러적용.
			var caseRow=sheet1.FindText("div", "Case", row, -1, false);
			sheet1.RenderSheet(0);
			sheet1.SetCellBackColor(caseRow, "total_recovered","#555555");
			sheet1.SetCellBackColor(caseRow, "total_recovered_p","#555555");
			sheet1.SetCellBackColor(caseRow, "net_paid","#555555");
			sheet1.SetCellBackColor(caseRow, "net_paid_p","#555555");
			//포멧 변경
 			sheet1.InitCellProperty(caseRow,"total_recovered",{ Type:"Data",Align:"Right",Format:"dfNone"} );
 			sheet1.InitCellProperty(caseRow,"total_recovered_p",{ Type:"Data",Align:"Right",Format:"dfNone"} );
 			sheet1.InitCellProperty(caseRow,"net_paid",{ Type:"Data",Align:"Right",Format:"dfNone"} );
 			sheet1.InitCellProperty(caseRow,"net_paid_p",{ Type:"Data",Align:"Right",Format:"dfNone"} );
			sheet1.SetCellValue(caseRow, "total_recovered","");
			sheet1.SetCellValue(caseRow, "total_recovered_p","");
			sheet1.SetCellValue(caseRow, "net_paid","");
			sheet1.SetCellValue(caseRow, "net_paid_p","");
			sheet1.RenderSheet(1);
		}
	} else if (sAction == PRINT) {	
		frm.f_cmd.value=PRINT;
		if(!validateForm(sAction)){
			return;
		}
		//RD Header , Title.
		frm.rd_report_by.value = frm.rd_title.value;
		frm.rd_title_nm.value="Settlement Analysis by "+frm.rd_title.value;
		var from_period=ComGetObjValue(frm.from_period);
		var to_period=ComGetObjValue(frm.to_period);
		var from_clmt_usd_amt=ComGetObjValue(frm.from_clmt_usd_amt);
		var to_clmt_usd_amt=ComGetObjValue(frm.to_clmt_usd_amt);
		var from_cgo_clm_stl_usd_amt=ComGetObjValue(frm.from_cgo_clm_stl_usd_amt);
		var to_cgo_clm_stl_usd_amt=ComGetObjValue(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Mask Clear
		ComClearSeparator(frm.from_period);
		ComClearSeparator(frm.to_period);
		ComClearSeparator(frm.from_clmt_usd_amt);
		ComClearSeparator(frm.to_clmt_usd_amt);
		ComClearSeparator(frm.from_cgo_clm_stl_usd_amt);
		ComClearSeparator(frm.to_cgo_clm_stl_usd_amt);
		// Form Object Data 
		var vFormData=FormQueryString(frm);
		ComSetObjValue(frm.from_period,from_period);
		ComSetObjValue(frm.to_period,to_period);
		ComSetObjValue(frm.from_clmt_usd_amt,from_clmt_usd_amt);
		ComSetObjValue(frm.to_clmt_usd_amt,to_clmt_usd_amt);
		ComSetObjValue(frm.from_cgo_clm_stl_usd_amt,from_cgo_clm_stl_usd_amt);
		ComSetObjValue(frm.to_cgo_clm_stl_usd_amt,to_cgo_clm_stl_usd_amt);
		//RD Parameter Initialize
		frm.com_mrdArguments.value="";
		frm.com_mrdBodyTitle.value="";
		frm.com_mrdPath.value="";
		frm.page_no.value="";//전건조회를 위해 실처리는 DAO 에서 함.
		var rf="/rf ["+RDServerIP + "/CPS_CNI_0076.do]";
		var rpost="/rpost ["+vFormData+"]"
		var rpaper="/rpaper [A4]";
		if (frm.usr_area.value == "A") {
			rpaper="/rpaper [LETTER]";
		}
		var rv="/rv NgmSsoName [JSESSIONID] NgmSsoData ["+document.form.jsession.value+"]" + getCondAllValue();
		frm.com_mrdArguments.value=rf + " " + rv + " " + rpost + " " + rpaper;	
		frm.com_mrdBodyTitle.value="Settlement Analysis by "+frm.rd_title.value+"-Print";
		frm.com_mrdPath.value="apps/opus/cps/cni/containercargoclaimreport/containercargoclaimreport/report/CPS_CNI_0076.mrd";
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
/**
* setting IBMultiComboBox
* @param {select box} combo object
* @param {xml} code , name xml
* @param {String} selected initial Code 
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
	if ( pComboObjId == "report_by" ) {
		for (var idx=0; idx < vArrayListData.length; idx++) {
			 if(vArrayListData[idx]== undefined)
				   continue;
		    vListData=vArrayListData[idx];
			vCaptionText=vListData["name"] + " |" + vListData["code"];
			vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
		} //end for
	} else {
		for (var idx=0; idx < vArrayListData.length; idx++) {
			if(vArrayListData[idx]== undefined)
				   continue;
		    vListData=vArrayListData[idx];
			vCaptionText=vListData["code"] + " |" + vListData["name"];
			vComboObj.InsertItem(idx, vCaptionText, vListData["code"]);
		} //end for
	}
	if (pComboObjId == "combo_status") {
		vComboObj.InsertItem(0, "ALL|All Status", "All");
		vComboObj.SetSelectIndex(0);
	} else if (pComboObjId == "area") {
		vComboObj.InsertItem(0, "ALL|All Area", "All");
		vComboObj.SetSelectIndex(0);
	} else if (pComboObjId != "report_by"){
		vComboObj.InsertItem(0, "", "");
		vComboObj.SetSelectIndex(0);
	}	
}
/**
 * combo id 로 해당 comboObject를 찾아 반환한다.
 * @param comboId
 * @return
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
/**
 * handling process for input validation
 */
function validateForm(sAction){
	 if (ComGetObjValue(period) == "") {
		 ComShowCodeMessage("CNI00003", "period");
//		 period.focus();
		 return false; 
	 }
	 if (ComGetObjValue(period)!= "" && ComGetObjValue(frm.from_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
//		 frm.from_period.focus();C
		 return false;
	 }
	 if (ComGetObjValue(period) != "" && ComGetObjValue(frm.to_period) == "") {
		 ComShowCodeMessage("CNI00003", "period date");
//		 frm.to_period.focus();
		 return false;
	 }
	 var from_clmt_usd_amt=frm.from_clmt_usd_amt.value.trim(); 
	 var to_clmt_usd_amt=frm.to_clmt_usd_amt.value.trim();
	 from_clmt_usd_amt=ComReplaceStr(from_clmt_usd_amt,",","");
	 to_clmt_usd_amt=ComReplaceStr(to_clmt_usd_amt,",","");
	 if (!ComIsNull(from_clmt_usd_amt) && !ComIsNull(to_clmt_usd_amt) && 
	      parseFloat(from_clmt_usd_amt) >= parseFloat(to_clmt_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_clmt_usd_amt.focus();
		 return false;
	 }
	 var from_cgo_clm_stl_usd_amt=frm.from_cgo_clm_stl_usd_amt.value.trim(); 
	 var to_cgo_clm_stl_usd_amt=frm.to_cgo_clm_stl_usd_amt.value.trim();
	 from_cgo_clm_stl_usd_amt=ComReplaceStr(from_cgo_clm_stl_usd_amt,",","");
	 to_cgo_clm_stl_usd_amt=ComReplaceStr(to_cgo_clm_stl_usd_amt,",","");
	 if (!ComIsNull(from_cgo_clm_stl_usd_amt) && !ComIsNull(to_cgo_clm_stl_usd_amt) && 
	      parseFloat(from_cgo_clm_stl_usd_amt) >= parseFloat(to_cgo_clm_stl_usd_amt)){
		 ComShowCodeMessage("CNI00036");
		 frm.to_cgo_clm_stl_usd_amt.focus();
		 return false;
	 }	 
	 if (ComGetObjValue(frm.clmt_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.clmt_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clmt_clm_agn_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.clmt_clm_agn_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.insur_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.insur_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_liable_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.labl_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.slv_clm_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.slv_clm_pty_no, ""); 
	 }
	 if (ComGetObjValue(frm.clm_surveyor_pty_abbr_nm).trim() == "") {
	 	   ComSetObjValue(frm.svey_clm_pty_no, ""); 
	 }
	 //추가해야함 다른 컬럼	
	return true;
}
