/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0008.js
*@FileTitle  : Invoice File Import
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
/****************************************************************************************
    Event code : INIT=0; ADD=1; SEARCH=2; SEARCHLIST=3;
    MODIFY=4; REMOVE=5; REMOVELIST=6 MULTI=7
     OTHER CASE : COMMAND01=11; ~ COMMAND20=30;
 ***************************************************************************************/
	/* developer job */
	// common global variables
	var sheetObjects=new Array();
	var sheetCnt=0;
	//file up load Object Array
	var uploadFileSeq="";
	var fileUploadFlag=false;
	var fileSaveFlag=false;
	//Event handler processing by button click event */
	document.onclick=processButtonClick;
	//Event handler processing by button name */
	function processButtonClick(){
		/**********/ 
		var sheetObject1=sheetObjects[0];
		/*******************************************************/
		var formObj=document.form; 
		try {
			var srcName=ComGetEvent("name");
			switch(srcName) {
				case "btn_New":
					ComResetAll();
					break;
				case "btn_Close":
					//parent.setPopData_InvoiceFileImport();
					if ( fileSaveFlag ) {
						//var opener=window.dialogArguments;
						//alert(opener);
						var func="parent."+ComGetObjValue(formObj.func)+"();";
						eval(func);
					}
					ComClosePopup();
					break;
				case "btn_Save":
					doActionIBSheet(sheetObject1, formObj, IBSAVE);
					break;
				case "btn_FileAdd":
					doActionIBSheet(sheetObject1, formObj, IBINSERT);
					break;
				case "btn_FileDel":
					doActionIBSheet(sheetObject1, formObj, IBDELETE);
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
	/**
     * registering IBSheet Object as list
     * adding process for list in case of needing batch processing with other items 
     * defining list on the top of source
	 */
	function setSheetObject(sheet_obj){
		sheetObjects[sheetCnt++]=sheet_obj;
	}

	/**
     * initializing sheet
     * implementing onLoad event handler in body tag
     * adding first-served functions after loading screen.
	 */
	function loadPage() {
		for ( var i=0 ; i < sheetObjects.length ; i++ ) {
			ComConfigSheet (sheetObjects[i] );
			initSheet(sheetObjects[i],i+1);
			ComEndConfigSheet(sheetObjects[i]);
		}
        initUpload();
        doActionIBSheet(sheetObjects[0], document.form, IBINSERT);
	}
	
	var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/LSE_INTGS.do'
 			,Files:[
 			]
			,BeforeAddFile : function(result){ 
	 			var files = result.files;

     			// dup file delete
				var getFileName = pSheetObj.GetCellValue(pRow , "file_nm");
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
	      			var formObj = document.form;
					uploadFileName=ComGetEtcData(sXml,"filename");
	 				pSheetObj.SetCellValue(pRow, "upload_file_nm",uploadFileName,0);
					fileUploadFlag=false;

					if ( pSheetObj.GetCellValue(pRow, "upload_file_nm") != "" ) {
						pSheetObj.SetWaitImageVisible(0);
						ComOpenWait(true);
						var vCoCostYrmon=ComGetObjValue(formObj.co_cost_yrmon);
						var sParam="f_cmd="+COMMAND01;
						sParam=sParam + "&co_cost_yrmon=" + vCoCostYrmon;
						sParam=sParam + "&upload_file_nm=" + sheetObj.GetCellValue(pRow, "upload_file_nm");
						sParam=sParam + "&vndr_seq=" + formObj.vndr_seq.value;
						var sXml=pSheetObj.GetSaveData("EES_LSE_0008GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							pSheetObj.SetCellValue(pRow, "save_result",ComGetEtcData(sXml,"result"),0);
							pSheetObj.SetCellValue(pRow, "agmt_cty_cd",ComGetEtcData(sXml,"agmt_no").substr(0, 3),0);
							pSheetObj.SetCellValue(pRow, "agmt_seq",ComGetEtcData(sXml,"agmt_no").substr(3),0);
							pSheetObj.SetCellValue(pRow, "lse_ctrt_no",ComGetEtcData(sXml,"ctrt_no"),0);
							pSheetObj.SetCellValue(pRow, "chkbox","N",0);
							fileSaveFlag=true;
						} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F" ) {
							pSheetObj.SetCellValue(pRow, "save_result","File format for upload is incorrect.  Please check file format again and if the same error continues, please contact system help desk.",0);
							pSheetObj.SetCellValue(pRow, "chkbox","N",0);
						}

					} else {
				 		pSheetObj.SetCellValue(pRow, "save_result","Fail to upload File.",0);
				 	}
	      		}else {
					ComShowMessage(result.msg);
				}
				ComOpenWait(false);
				pSheetObj.SetWaitImageVisible(1);
 			}
	 		,AfterAddFile:function(result){
	 			var files = result.files;
     		 	var fileType="";
     			var badFile=false;
				
     			var fileName= files[files.length-1].GetFileName();
     			fileType=fileName.substr(fileName.lastIndexOf(".") + 1);  // File Type
 				//TXT, XLS
     			if ( fileType.toUpperCase() != "TXT" && fileType.toUpperCase() != "CSV" ) {
 					badFile=true;
 				}
 				
     			if ( !badFile ) {
     				ComOpenWait(true);
			 		fileUploadFlag=true;
			 		pSheetObj.SetCellValue(pRow, "org_file_nm",fileName,0);
			 		pSheetObj.SetCellValue(pRow, "org_file_path",fileName,0);
		 			upload1.SaveStatus();
			 	} else {
			 		if ( fileName != "<USER_CANCEL>" ) {
//			 			files[files.length-1].DeleteFromList();
			 			ComShowCodeMessage("LSE01097");
		     			return false;
			 		}
				}
			}
 		});
 	}
    function sheet1_OnMouseMove(sheetObj, e) {
	  	  var row     = sheet1.MouseRow(),
	        col     = sheet1.MouseCol(),
	        info    = null;
	  	  var saveName = sheet1.ColSaveName(col);

	  	  var linkFlag=sheetObj.GetCellValue(row, col) != "";
	  	  sheetObj.SetDataLinkMouse("rqst_file_sav_nm",linkFlag);
			
	      if (row > 0 && saveName=="org_file_nm") {
				if ( fileUploadFlag ) {
		    		return;
		    	}

	            info = sheet1.GetCellElement(row, col, 1);
	            
	    		pSheetObj = sheetObj;
				pRow = row;
				pCol = col;

	            upload1.SetFileUploadElement(info);
	  	  }
	  }
    
	/**
     * setting sheet initial values and header
     * param : sheetObj, sheetNo
     * adding case as numbers of counting sheets
	 */
	function initSheet(sheetObj, sheetNo) {
		var cnt=0;
		switch(sheetObj.id) {
			//파일 업로드
		    case "sheet1" :
		    	  with(sheetObj){
			       var HeadTitle1="|Sel.|Seq.|Lessor File Name|Local File Path|Upload File Name|AGMT NO.|AGMT NO.|Contract No.|Save Result";
			       var headCount=ComCountHeadTitle(HeadTitle1);
	
			       SetConfig( { SearchMode:2, MergeSheet:5, Page:20, FrozenCol:0, DataRowMerge:1 } );
	
			       var info    = { Sort:1, ColMove:1, HeaderCheck:0, ColResize:1 };
			       var headers = [ { Text:HeadTitle1, Align:"Center"} ];
			       InitHeaders(headers, info);
	
			       var cols = [ {Type:"Status",    Hidden:1, Width:50,   Align:"Center",  ColMerge:1,   SaveName:"ibflag" },
			                 {Type:"DummyCheck", Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"chkbox" },
			                 {Type:"Seq",       Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:"Seq" },
			                 {Type:"Popup",     Hidden:0, Width:150,  Align:"Left",    ColMerge:0,   SaveName:"org_file_nm",     KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:200,  Align:"Center",  ColMerge:0,   SaveName:"org_file_path",   KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
			                 {Type:"Text",      Hidden:1, Width:150,  Align:"Center",  ColMerge:0,   SaveName:"upload_file_nm",  KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:60,   Align:"Center",  ColMerge:0,   SaveName:"agmt_cty_cd",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:80,   Align:"Center",  ColMerge:0,   SaveName:"agmt_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:120,  Align:"Center",  ColMerge:0,   SaveName:"lse_ctrt_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 },
			                 {Type:"Text",      Hidden:0,  Width:700,  Align:"Left",    ColMerge:0,   SaveName:"save_result",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:0 } ];
			        
			       InitColumns(cols);
	 
			       SetEditable(1);
			       SetCountPosition(0);
			       SetShowButtonImage(4);
		           DataInsert();
		           SetSheetHeight(242);
		       }
				break;
		}
	}
	// handling process for Sheet
	function doActionIBSheet(sheetObj, formObj, sAction) {
		sheetObj.ShowDebugMsg(false);
		switch(sAction) {
			case IBSAVE:
				if(validateForm(sheetObj,formObj,sAction)) {
					var sRow=sheetObj.FindCheckedRow("chkbox");
					var arrRow=sRow.split("|");
					sheetObj.SetWaitImageVisible(0);
					ComOpenWait(true);
					var vCoCostYrmon=ComGetObjValue(formObj.co_cost_yrmon);
					for ( var i=0 ; i < arrRow.length-1 ; i++ ) {
						var sParam="f_cmd="+COMMAND01;
						sParam=sParam + "&co_cost_yrmon=" + vCoCostYrmon;
						sParam=sParam + "&upload_file_nm=" + sheetObj.GetCellValue(arrRow[i], "upload_file_nm");
 						var sXml=sheetObj.GetSaveData("EES_LSE_0008GS.do" , sParam);
						if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "S" ) {
							sheetObj.SetCellValue(arrRow[i], "save_result",ComGetEtcData(sXml,"result"),0);
							sheetObj.SetCellValue(arrRow[i], "agmt_cty_cd",ComGetEtcData(sXml,"agmt_no").substr(0, 3),0);
							sheetObj.SetCellValue(arrRow[i], "agmt_seq",ComGetEtcData(sXml,"agmt_no").substr(3),0);
							sheetObj.SetCellValue(arrRow[i], "lse_ctrt_no",ComGetEtcData(sXml,"ctrt_no"),0);
							sheetObj.SetCellValue(arrRow[i], "chkbox","N",0);
							fileSaveFlag=true;
						} else if ( ComGetEtcData(sXml,"TRANS_RESULT_KEY") == "F" ) {
							sheetObj.SetCellValue(arrRow[i], "save_result","File format for upload is incorrect.  Please check file format again and if the same error continues, please contact system help desk.",0);
							sheetObj.SetCellValue(arrRow[i], "chkbox","N",0);
						}
					} 
					ComOpenWait(false);
					sheetObj.SetWaitImageVisible(1);
				}
				break;
			case IBDELETE:
					var sRow=sheetObj.FindCheckedRow("chkbox");
					if (sRow == "") {
						ComShowCodeMessage("COM12189");
						return 0;
					}
					//creation array
					var arrRow=sRow.split("|"); //결과 : "1|3|5|"
					for ( var i=arrRow.length-1 ; i >= 0 ; i-- ) {
						sheetObj.RowDelete(arrRow[i], false);
					}
				break;
			case IBINSERT:
					var row=sheetObj.DataInsert(-1);
				break;
		}
	}
	/**
	 * handling process for input validation
	 */
	function validateForm(sheetObj,formObj,sAction){
		switch (sAction) {
			case IBSAVE:
				var sRow=sheetObj.FindCheckedRow("chkbox");
				//ComDebug(sRow);
				if (sRow == "") {
					ComShowCodeMessage("COM12189");
					return false;
				}
				//creation array
				var arrRow=sRow.split("|");
				for ( var i=0 ; i < arrRow.length-1 ; i++ ) {
					if ( sheetObj.GetCellValue(arrRow[i], "upload_file_nm") == "" ) {
						ComShowCodeMessage("LSE01133");
						sheetObj.SelectCell(arrRow[i], "upload_file_nm");
						return false;
					}
				}
				break;
		}
		return true;
	}

	function sheet1_OnDblClick(sheetObj, Row, Col) {
		var formObj=document.form;
		var colName=sheetObj.ColSaveName(Col);
		switch (colName) {
			case "agmt_cty_cd":
			case "agmt_seq":
			case "lse_ctrt_no":
				if ( sheetObj.GetCellValue(Row, "agmt_cty_cd") != ""
					&& sheetObj.GetCellValue(Row, "agmt_seq")    != ""
						&& sheetObj.GetCellValue(Row, "lse_ctrt_no") != "" ) {
					var url="/opuscntr/EES_LSE_0098.do";
					url=url + "?agmt_cty_cd="   + sheetObj.GetCellValue(Row, "agmt_cty_cd");
					url=url + "&agmt_seq="      + sheetObj.GetCellValue(Row, "agmt_seq");
					url=url + "&lse_ctrt_no="   + sheetObj.GetCellValue(Row, "lse_ctrt_no");
					url=url + "&co_cost_yrmon=" + ComGetObjValue(formObj.co_cost_yrmon);
					ComOpenPopup(url, 855, 400, '', '1,0', false);
				}
				break;
		}
	}
 	function sheet1_OnLoadFinish(sheetObj) {
		var formObj=document.form;
		//doActionIBSheet(sheetObj, formObj, IBINSERT);
	}
	/* end of developer job */
