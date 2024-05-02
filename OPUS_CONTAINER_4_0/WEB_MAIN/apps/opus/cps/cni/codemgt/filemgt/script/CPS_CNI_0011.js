/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName : CPS_CNI_0011.js
*@FileTitle : File Upload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/22
=========================================================*/
// ===================================================================================
// common global variables
// ===================================================================================
// IBSheet 
var sheetObjects=new Array();
var sheetCnt=0;
var sheet1=null;
var uploadObjects=new Array();
var uploadCnt=0;
var upload1=null;
// html form
var frm=null;
/**
 * registering IBSheet Object as list
 * @param {ibsheet} sheetObj    IBSheet Object  
 **/
function setSheetObject(sheet_obj){
    sheetObjects[sheetCnt++]=sheet_obj;
}
/**
 * registering IBUpload Object as list
 * @param {ibupload} uploadObj    IBUpload Object
 **/
function setUploadObject(uploadObj) {
	uploadObjects[uploadCnt++]=uploadObj;
}
// ===================================================================================
// initializing 
// ===================================================================================
/**
 * initializing sheet
 * implementing onLoad event handler in body tag
 * adding first-served functions after loading screen.
 **/
function loadPage() {
    //setting Variables
    frm=document.form;
    sheet1=sheetObjects[0];    
    sheetCnt=sheetObjects.length ;   

    //sheet initial 
    for(var i=0 ; i < sheetCnt ; i++) {
        ComConfigSheet (sheetObjects[i]);
        initSheet(sheetObjects[i],i+1);
        ComEndConfigSheet(sheetObjects[i]);              
    }

	initUpload();
		
    //retrieving in case of existing clm_file_tp_cd가
    if (!ComIsNull(frm.clm_file_tp_cd.value)) {
    	doActionIBSheet(SEARCHLIST01);
    }	
}
/**
  * setting sheet initial values and header
  * @param {ibsheet} sheetObj  sheet
  * @param {int} sheetNo sheetNo
  */
function initSheet(sheetObj, sheetNo) {
	var cnt=0;	
    with(sheetObj){
        switch (sheetObj.id) {
        	case "sheet1":
		      var HeadTitle1="|Sel.|Seq.|File Name|Contents|ID|Date|Download|clm_file_seq|file_path|file_sav_id";
		      var headCount=ComCountHeadTitle(HeadTitle1);
		
		      SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
		
		      var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
		      var headers = [ { Text:HeadTitle1, Align:"Center"} ];
		      InitHeaders(headers, info);
		
		      var cols = [ {Type:"Status",    Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
		             {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:"del_chk" },
		             {Type:"Seq",       Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"clm_file_dp_seq" },
		             {Type:"Popup",     Hidden:0, Width:160,  Align:"Left",    ColMerge:0,   SaveName:"file_nm",          KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
		             {Type:"Text",      Hidden:0,  Width:170,  Align:"Left",    ColMerge:1,   SaveName:"file_desc",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_usr_id",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:0,  Width:65,   Align:"Center",  ColMerge:1,   SaveName:"upd_dt",           KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Image",     Hidden:0, Width:40,   Align:"Center",  ColMerge:1,   SaveName:"file_download",    KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"clm_file_seq" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_path" },
		             {Type:"Text",      Hidden:1, Width:0,    Align:"Center",  ColMerge:1,   SaveName:"file_sav_id",      KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
		       
		      InitColumns(cols);
		
		      SetEditable(1);
		      SetImageList(0,"/opuscntr/img/ico_attach.gif");
              SetShowButtonImage(1);
              SetSheetHeight(240);
      break;


		}
	}
}
// Event handler processing by button click event
document.onclick=processButtonClick;
/**
 * Event handler processing by button name
 */
function processButtonClick() {
	var srcName=ComGetEvent("name");
	if(ComGetBtnDisable(srcName)) return false;
	switch (srcName) {	
        case "btn2_Row_Add":
			var row=sheet1.DataInsert(-1);
			sheet1.SelectCell(row,"clm_file_dp_seq",true);
			break;
        case "btn2_Row_Delete":
        	var row=sheet1.FindCheckedRow("del_chk");
        	if (row == "") {
        		ComShowCodeMessage("COM12189");
        		return;
        	}
        	ComRowHideDelete(sheet1, "del_chk"); 
            break; 
        case "btn2_Save":        	
        	doActionIBSheet(MULTI);        	
            break;
		case "btn1_Close":
			ComClosePopup(); 
            break; 
	}
}
var pSheetObj, pRow, pCol ;
function initUpload(){
	upload1.Initialize({
		SaveUrl:'/opuscntr/CPS_CNI_0011GS.do',
		Files:[
		]
		,BeforeSaveStatus : function(result){
			var saveString=sheet1.GetSaveString(false,true);
			var param = FormQueryString(document.form) + "&" + saveString;
			paramToForm(param);
			
			return true;
		}
		,BeforeAddFile : function(result){ // 중복 되면 기존 파일 삭제
			var getFileName = pSheetObj.GetCellValue(pRow , "file_nm");
			var files = result.files;
			for( var i=0 ; i < files.length-1 ; i++){
				if(getFileName == files[i].GetFileName()){
					 files[i].DeleteFromList();
				}
			}
			
			return true;
		}
		,AfterSaveStatus : function(result) {  
			var code = result.code;
			if( code == 0) {
				var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
		       	sheet1.LoadSaveData(sXml);
		       	var errorYn=ComGetEtcData( sXml, "ERROR_YN");			
				if (errorYn == "N") {
					doActionIBSheet(SEARCHLIST01);
				}
			} else {
				ComShowMessage(result.msg);
			}
		}
		,AfterAddFile:function(result){
			var files = upload1.GetList();
		    var fileName = files[files.length-1].GetFileName();
		    var serialNo = files[files.length-1].GetSerialNo();	
		    var row = sheetObj.GetSelectRow();
		    
// 			var files = result.files;
//			var fileName= files[files.length-1].GetFileName();
			pSheetObj.SetCellValue(pRow, "file_path",fileName,0);
			fileName=fileName.substr(fileName.lastIndexOf("\\")+1);
			pSheetObj.SetCellValue(pRow, "file_nm",fileName,0);
		}
	});
}


/**
* Calling Function in case of OnChange event
* @param {ibsheet} sheetObj Mandatory HTML Tag Object   
* @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
* @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
* @param {string} value Changed value, the value when saving, to which format is not applied
*/
function sheet1_OnClick(sheet,row,col,value){
	if (sheet.ColSaveName(col)!= "file_download" ||
			sheet.GetRowStatus(row)=="I") {
		return;
	}
	if(sheet.GetCellText(row, "file_sav_id") == "") {
		return;
	}
	var frm1=document.form1;
	frm1.action="/opuscntr/FileDownload?key="+sheet.GetCellText(row, "file_sav_id");
	frm1.submit();
	return;
}
/**
 * The function called when OnDbClick event on Sheet1 triggered 
 * @param {ibsheet} sheetObj Mandatory HTML Tag Object   
 * @param {int} Row Mandatory, Row Index of the Cell that Onclick Event Triggered
 * @param {int} Col Mandatory, Column Index of the Cell that Onclick Event Triggered
 */
function sheet1_OnDblClick(sheet, row, col) {
 	if (sheet.ColSaveName(col)!= "file_nm" ||
 			sheet.GetRowStatus(row)=="I") {
 		return;
 	}
 	if(sheet.GetCellText(row, "file_sav_id") == "") {
 		return;
 	}
 	var frm1=document.form1;
 	frm1.action="/opuscntr/FileDownload?key="+sheet.GetCellText(row, "file_sav_id");
 	frm1.submit();
 	return;
 }
/**
 * Occurs when the mouse moves on the sheet <br>
 * @param {ibsheet} sheet    IBSheet Object
 * @param {ibsheet} Button     	selected sheet Button
 * @param {ibsheet} Shift     	selected sheet Shift
 * @param {int} 	X     		X coordinates
 * @param {int} 	Y     		Y coordinates
 **/
function sheet1_OnMouseMove(sheet, Button, Shift, X, Y){
	var row=sheet.MouseRow();
	var col=sheet.MouseCol();
	if (row < sheet.HeaderRows()|| col < 0) {
		return;
	}
	var saveName=sheet.ColSaveName(col);
	if (saveName!= "file_nm" && saveName!="file_download") {
		return;
	}
	var status=sheet.GetRowStatus(row);
	if (saveName=="file_nm") {
		sheet.SetMousePointer((status=="I")?"Hand":"Default");
        info = sheet1.GetCellElement(row, col, 1);
        
  		pSheetObj = sheetObj;
			pRow = row;
			pCol = col;

          upload1.SetFileUploadElement(info);
          
	} else if (saveName=="file_download") {
		sheet.SetMousePointer((status=="I")?"Default":"Hand");
	}
}
/**
 * Operate Sheet Process
 * @param {string} sAction
 */
function doActionIBSheet(sAction) {	
	if (sAction == SEARCHLIST01) {
		frm.f_cmd.value=SEARCHLIST01;		
		var sXml=sheet1.GetSearchData("CPS_CNI_0011GS.do", FormQueryString(frm));
		sheet1.LoadSearchData(sXml,{Sync:1} );
	} else if (sAction == MULTI) {		
		frm.f_cmd.value=MULTI;		
		var saveString=sheet1.GetSaveString(false,true);
		if (sheet1.IsDataModified()&& ComIsNull(saveString))  {
			return;
		}	
		if (ComIsNull(saveString))  {			
			 //msgs["CNI00022"] = "There is no contents to save.";
			ComShowCodeMessage("CNI00022");
			return;
		}
		var sRow=sheet1.FindStatusRow("I");
		var arrRow=sRow.split(";");
/*		upload1.Files="";
		for(var i=0 ; i < arrRow.length - 1 ; i++) {
			var row=arrRow[i];			
			var sFile=sheet1.GetCellValue(row , "file_path");
			upload1.AddFile(sFile);
		}*/
		var param=FormQueryString(frm) + "&" + saveString;
		// Upload
		var fileList = upload1.GetList();
	   if(fileList.length > 0) {
		   ComOpenWait(true);
			upload1.SaveStatus();
			ComOpenWait(false);
			sheet1.SetWaitImageVisible(1);
	   } else {			
			param=FormQueryString(frm) + "&" + sheet1.GetSaveString();
			var sXml=sheet1.GetSaveData("CPS_CNI_0011GS.do",  param);
 			sheet1.LoadSaveData(sXml);
			var errorYn=ComGetEtcData( sXml, "ERROR_YN");
			if (errorYn == "N") {
				doActionIBSheet(SEARCHLIST01);
			}			
		}		
	}
}
