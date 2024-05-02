/*=========================================================
*Copyright(c) 2006~2008 CyberLogitec
*@FileName : TPBFileUpload.js
*@FileTitle : 3자구상 파일업로드 팝업 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, Choi
*@LastVersion : 1.2
* 2006-11-15 Kim Jin-seung  1.0 최초 생성
* 2008-05-02 Kim Jin-seung  1.1 : * Adjustment Request/Approval Recovery Activity시 modal팝업 사용할 수 있도록 처리 ;
* 2009-12-02 Sun, Choi 		1.2 ALPS Migration
=========================================================*/

	/// file 관련 변수
	// var fileObjInitName = "fileObj"; 
    var tabObjects=new Array();
    var tabCnt=0;
    var beforetab=1;
    var sheetObjects=new Array();
    var sheetCnt=0;
    var comboObjects=new Array();
    var comboCnt=0;
    var sheetObjectsMap=new Array();

    var dftDateYmd = "Ymd";
    var dftUserFormatYmdhhmi = "####-##-## ##:##";
    
    // Event handler processing by button click event*/
    document.onclick=processButtonClick;
    // Event handler processing by button name */
    function processButtonClick(){
    	 var sheetObject1=sheetObjects[0];
         var formObject=document.form;
    	try {
    		var srcName=ComGetEvent("name");
            switch(srcName) {

				case "btn_t1Add":					
					sheet_DataInsert(sheetObject1,'');
                    break;
				case "btn_t1Ins":
					sheet_DataInsert(sheetObject1,'','Ins');
                    break;
				case "btn_t1Delete":
					if(checkBoxCheckYn(sheetObject1, "checkbox")) {
						rowRemove(sheetObject1, "");
					}
					break;
					
				case "btn_save":					
//					sheetObject1.SetRowStatus(1,"U");
					doActionIBSheet(sheetObject1,formObject,IBSAVE);
					break;
				case "btn_close":					
					ComClosePopup();
					break;					

            } // end switch
    	}catch(e) {
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
    function setSheetObject(sheetObj){
    	sheetObjects[sheetCnt++]=sheetObj;
    	sheetObjectsMap[sheetObj.id]=sheetObj;
    }
    
	
	/// load page
    /**
     * initializing sheet 
     * implementing onLoad event handler in body tag 
     * adding first-served functions after loading screen.
     */
    function loadPage() {
        for(i=0;i<sheetObjects.length;i++){
            ComConfigSheet (sheetObjects[i]);
            initSheet(sheetObjects[i],i);
            ComEndConfigSheet(sheetObjects[i]);
        }
        
        initUpload();
        
        doActionIBSheet(sheetObjects[0],document.form, IBSEARCH);
    }
    

	/// Add Button OnClick
	function AddButton_onclick(){		
		if ( TPBFileCount >= TPBMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("TPB90029"));
			return;
		}
	}

	
    var pSheetObj, pRow, pCol ;
    function initUpload(){
 		upload1.Initialize({
 			SaveUrl:'/opuscntr/TPBFileUploadGS.do'
 			,Files:[]
	 		,BeforeAddFile : function(result){
			 	return true;
			}
			,BeforeSaveStatus : function(result){ 
			 	return true;
			}
			,AfterSaveStatus : function(result) {
	      		var code = result.code;
	      		if( code == 0) {
	      			ComUploadRemoveFile(upload1, "", true);
	      			
	      			var sXml = (new XMLSerializer()).serializeToString(result.xmlData);
	      			sheetObjects[0].LoadSaveData(convert2ibsheet7(sXml));
	      			
	      			var formObj = document.form;
	      			ComOpenWait(false);
				   
	      			if(insertFlag){
					   if(typeof pSheetObj.GetEtcData("fileNo") != "undefined") {
						   //Handling after saving (Setting other information into TextBox by XML)
						   formObj.fileNo.value=pSheetObj.GetEtcData("fileNo");
						   
						   parent.getFileNoSheet(pSheetObj.GetEtcData("fileNo"));
						   parent.loadPage();
		               }
	      			}
	      		}else {
					ComShowMessage(result.msg);
				}
			}
	 		,AfterAddFile:function(result){	 				 			
				var files = result.files;
	 			var fileName= files[files.length-1].GetFileName();
			    var serialNo = files[files.length-1].GetSerialNo();
 				var prefix="";
 				
 				if(pSheetObj.id == "t1sheet1") {
 					prefix="";
 						
 					var sheet_serial = pSheetObj.GetCellValue(pRow, prefix+"file_phys_nm");
 				    ComUploadRemoveFile(upload1, sheet_serial, false); 								
 				    pSheetObj.SetCellValue(pRow, prefix+"file_phys_nm",serialNo,0); //현재 full local url 은 지원되지않음.
 					
 					sheetObjects[0].SetCellValue(pRow, prefix+"file_path",fileName,0);
 					sheetObjects[0].SetCellValue(pRow, prefix+"file_lgc_nm",fileName,0);
 						
 				}
			}
 		});
 	}	
    
     
    
    /** initSheet
     * 
     * @param sheetObj
     * @param sheetNo
     */
    function initSheet(sheetObj,sheetNo) {
        var cnt=0;
        switch(sheetObj.id) {
			case "t1sheet1":      //t5sheet1 init
                with (sheetObj) {
					var prefix="";
					var HeadTitle="|Sel|File Upload|Contents|File Path|File Seq|File Download|File Phys Nm|File No";
					
					SetConfig( { SearchMode:2, MergeSheet:5, Page:20, DataRowMerge:1 } );
					
					var info    = { Sort:1, ColMove:1, HeaderCheck:1, ColResize:1 };
					var headers = [ { Text:HeadTitle, Align:"Center"} ];
					InitHeaders(headers, info);
					var cols = [ {Type:"Status",    Hidden:0, Width:30,   Align:"Center",  ColMerge:0,   SaveName:prefix+"ibflag" },
					  {Type:"DummyCheck", Hidden:0, Width:40,   Align:"Center",  ColMerge:0,   SaveName:prefix+"checkbox", KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Popup",     Hidden:0, Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_lgc_nm",         KeyField:1,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1,   EditLen:50 },
					  {Type:"Text",      Hidden:1,  Width:320,  Align:"Left",    ColMerge:0,   SaveName:prefix+"file_desc",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_path",       KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_no_seq",        KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Image",     Hidden:0, Width:120,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_download",   KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:0,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_phys_nm",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 },
					  {Type:"Text",      Hidden:1, Width:108,  Align:"Center",  ColMerge:0,   SaveName:prefix+"file_no",     KeyField:0,   CalcLogic:"",   Format:"",            PointCount:0,   UpdateEdit:1,   InsertEdit:1 } ];
					 
					InitColumns(cols);
					SetSheetHeight(220);
					SetEditable(1);
					SetImageList(0,"/opuscntr/img/ico_attach.gif");
//					SetColHidden(prefix + "flet_file_tp_cd",1);
//					SetColProperty(prefix+"flet_file_tp_cd", {ComboText:"CP", ComboCode:"CP"} );
					SetShowButtonImage(1);
			    }
                break;
        }
    }    
    
	/**
     * Event occurred when mouse pointer is moving <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Button     	Selected Button of sheetObj
     * @param {ibsheet} Shift     	Selected Shift of sheetObj
     * @param {int} 	X     		X Coordinate Value
     * @param {int} 	Y     		Y Coordinate Value
     **/
	function t1sheet1_OnMouseMove(sheetObj, Button, Shift, X, Y){
		var row     = sheetObj.MouseRow(),
        col     = sheetObj.MouseCol(),
        info    = null;
        if (row > 0 &&sheetObj.ColSaveName(col) == "file_lgc_nm") {
            info = sheetObj.GetCellElement(row, col, 1);
    		pSheetObj = sheetObj;
			pRow = row;
			pCol = col;
            upload1.SetFileUploadElement(info);
        } 
		changeGetMousePointer(sheetObj,"");
	}
	
	/**
     * Changing shape of mouse pointer <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix    	Variable Separator
     **/
	function changeGetMousePointer(sheetObj, prefix){
		var Row=sheetObj.MouseRow();
		var Col=sheetObj.MouseCol();
		if (Row<sheetObj.HeaderRows()|| Col<0) return;
		var saveName=sheetObj.ColSaveName(Col);
		
		if (saveName!=prefix+"file_lgc_nm" && saveName!=prefix+"file_download") return;
		var status=sheetObj.GetRowStatus(Row);
		if (saveName==prefix+"file_lgc_nm") {
			sheetObj.SetMousePointer((status=="I")?"Hand":"Default");
		} else if (saveName==prefix+"file_download") {
			sheetObj.SetMousePointer((status=="I")?"Default":"Hand");
		}
	}	
	
	/**
     * Download File <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} Row     	Selected Row of sheetObj
     * @param {ibsheet} Col     	Selected Col of sheetObj
     * @param {String} 	Value     	File Name
     **/
	function t1sheet1_OnClick(sheetObj,Row,Col,Value){
		var prefix="";
		if (sheetObj.ColSaveName(Col)!=prefix+"file_download" || sheetObj.GetRowStatus(Row)=="I")return;
		if(sheetObj.GetCellText(Row, prefix+"file_phys_nm") == "") return;
		location.href="/opuscntr/FileDownload?key="+sheetObj.GetCellText(Row, prefix+"file_phys_nm");
		return;
	}
	
	
//    function t1sheet1_OnSaveEnd(sheetObj){
//    	parent.getFileNoSheet(sheetObj.GetEtcData("fileNO"));
//     }	
	/**
     * Row Del 버튼 클릭 시 선택여부 <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {string}  saveName    IBSheet SaveName
     * @return {boolean} true:선택, false:미선택
     **/
 	function checkBoxCheckYn(sheetObj, saveName) {
 		var sRow=sheetObj.FindCheckedRow(saveName);
		if(sRow == "") {
			ComShowCodeMessage('COM12189');
			return false;
		} else {
			ComShowCodeMessage('COM12188');
			return true;
		}
 	}
 	
	/**
     * Adding Row for each Tab of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @param {String} 	flag   		Row Add/Row Ins's Separator
     * @return none
     **/
	function sheet_DataInsert(sheetObj,prefix,flag){
		//var prefix = "hir_";
		var row=sheetObj.GetSelectRow();
		var col=sheetObj.GetSelectCol();
		
		if (sheetObj.RowCount()> 0){
			if (sheetObj.GetCellValue(row,prefix + "file_lgc_nm")==""){
				if(prefix == "") {
					ComShowMessage(ComGetMsg('TPB90107'));
				} 
				sheetObj.SelectCell(row,prefix + "file_lgc_nm");
				return;
			}
		}
		
		//Checking Row Ins Button
		if(typeof flag != "undefined" && flag != "") {
				row=sheetObj.DataInsert();
		} else {
			// Add Row
	    	row=sheetObj.DataInsert(-1);
				
			if(row>=2){
				sheetObj.SetCellValue(row,"file_no", sheetObj.GetCellValue(row-1,"file_no"));
			}else if(row>=3){
				ComShowMessage(ComGetMsg('TPB90029'));
			}
						    	
	    	
	    	/*
			if(prefix == "cpf_" || prefix == "cef_") {
				sheetObj.SetCellImage(row,prefix + "file_download",0);
			}*/
			if (row<=sheetObj.HeaderRows()) return;
		}	
		
	}    


	/**
     * Getting FileSaveId of attached File supposed to be sent by Email <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {String} 	prefix   	Variable Separator
     * @return {String} fileKey     Attached File FileSaveId 
     **/
	function checkAttachFile(sheetObj, prefix) {
		var fileKey="";
		var sRow=sheetObj.FindCheckedRow(prefix + "checkbox");
		if (sRow == "") {
			ComShowMessage(ComGetMsg('COM12189'));
			//ComShowMessage(ComGetMsg('FMS01153'));
			return fileKey;
		} else {
			var arrRow=sRow.split("|");
			//UI개선(201408 민정호)
//			for (var idx=arrRow.length-2; idx>=0; idx--) {
			for (var idx=arrRow.length-1; idx>=0; idx--) {			
				var row=arrRow[idx];
				if(sheetObj.GetCellValue(row,prefix + "file_phys_nm") == "") {
					ComShowMessage(ComGetMsg('FMS01148', row));
					//ComShowMessage("파일이 저장되지 않았습니다\n\n[저장되지않은 ROW : "+row+"]");
					return "";
					break;
				}
				fileKey += sheetObj.GetCellValue(row,prefix + "file_phys_nm")+ "<" + sheetObj.GetCellValue(row,prefix + "file_lgc_nm") + ";";
			}
		}
		fileKey=fileKey.substring(0,fileKey.length-1);
		return fileKey;
	}	
	
	
	/**
     * Handling Date Effectiveness Verification Process about input Value of IBSheet <br>
     * @param {ibsheet} sheetObj    IBSheet Object
     * @param {ibsheet} row     	Selected Row of sheetObj
     * @param {ibsheet} col     	Selected Col of sheetObj
     * @param {String} 	value    	Inserted value of sheetObj
     * @param {String} 	prefix   	Variable Separator
     * @see #ComRowHideDelete
     **/
	function rowRemove(sheetObj, prefix) {
		ComRowHideDelete(sheetObj, prefix + "checkbox");
		/*
    	var sRow=sheetObj.FindCheckedRow(prefix + "checkbox");
		if (sRow == "") return;
		//Row to Array
		var arrRow=sRow.split("|"); //result : "1|3|5|"
		for (var idx=arrRow.length-2; idx>=0; idx--){
			var row=arrRow[idx];
			sheetObj.SetRowHidden(row,1);
			sheetObj.SetRowStatus(row,"D");
		}
		*/
	}	
	
	
    var insertFlag = false;
    function doActionIBSheet(sheetObj,formObj,sAction,gubun,row) {
    	insertFlag =false;
        sheetObj.ShowDebugMsg(false);
        var formObj = document.form;
        
        switch(sAction) {
			case IBSEARCH:      
				 formObj.f_cmd.value=SEARCH;
				 var sParam=FormQueryString(formObj);
				 ComOpenWait(true);
				 var sXml=sheetObj.GetSaveData("TPBFileUploadGS.do", sParam);
				 ComOpenWait(false);
				 sheetObj.LoadSaveData(sXml);
//				 clearAll();
	            break;
			case IBSAVE:    
				insertFlag =true;
				formObj.f_cmd.value=ADD;

				var paramFile1 = setFileUpload(sheetObjects[0], "");
								
				var fileList = upload1.GetList();
				if(fileList.length > 0) {
				    //2.Binding IBSheet Data in QueryString
					var arrSheets2 = new Array(sheetObjects[0]);
					var aryPrefix2 = new Array("file_phys_nm");
					var sParam1 = ComGetFileSaveString(arrSheets2, upload1, aryPrefix2);
					if (sParam1 == "") return;
					var sParam = sParam1;
	
					//3.Binding Form Data in QueryString				
					var aryPrefix = new Array("");				
					//sParam += "&" + FormQueryStringOrg(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&f_cmd="+ADD+"&" + ComGetPrefixParam(aryPrefix);
					sParam += "&" + paramFile1+"&" + FormQueryString(formObj) ;

					console.log("save ......... sParam = "+sParam);					
			 		paramToForm(sParam);			 		
					upload1.SaveStatus();

				} else {
					var arrSheets=new Array(sheetObjects[0]);
					var sParam=ComGetSaveString(arrSheets);
					if (sParam == "") return;
					//3.Binding Form Data in QueryString
					var aryPrefix=new Array("");
					sParam += "&" + FormQueryString(formObj)+"&" + ComGetPrefixParam(aryPrefix);
					
					ComOpenWait(true);
					//4. Sending request to server, and get response
					var sXml=sheetObj.GetSaveData("TPBFileUploadGS.do", sParam);
					
					sheetObjects[0].LoadSaveData(sXml);

					ComEtcDataToForm2(formObj,sheetObjects[0],"",true);
					parent.loadPage();
					ComOpenWait(false);
									
				}
			    break;
        }
    }	
	
	/**
     * Delete date confirm<br>
     * @return {boolean} okYn 
     **/
	function delConfirm() {
		var okYn=ComShowConfirm("Do you want to delete file all?");
		return okYn;
	}    
    
	function setFileUpload(sheetObj, prefix){		
		//Finding Row in "Insert" Transaction State
		var sRow = sheetObj.FindStatusRow("I");			
		var arrRow = sRow.split(";");
		var cnt = 0;
			
		for (var idx=0; idx<=arrRow.length; idx++){ 
			var row = arrRow[idx];
			
			if(row > 0){
				var sFile = sheetObj.GetCellValue(row, prefix + "file_path");	
				if (sFile=="" || sFile==-1){
					ComShowMessage(ComGetMsg('FMS01075'));				
				}else{								
					cnt++;
				}
			}				
		}	
		var param = prefix + "file_cnt=" + cnt;
		return param;
	}    
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
//	
//	///===== 파일추가 버튼 클릭시 =====
//	function AddFile(form){
//		var tempFullName = form.fileObj.value; 
//
//		if ( tempFullName.length > 0 ) {
//			form.f_cmd.value = ADD;
//			form.target = "ifrm1";
//			form.action = "TPBFileUploadProc.do";
//			form.submit();
//			
//			// AddFileAfterFileupload(form); .... target page에서 
//		} else {
//		}
//	}
//
//	///===== 파일추가 처리 후 =====
//	function AddFileAfterFileupload(form, fileNo, fileNoSeq, filePhysNm, fileLgcNm, filePathNm){
//		// ComShowMessage(" form : "+form+"\n fileNo : "+fileNo+"\n fileNoSeq  : "+fileNoSeq+"\n filePhysNm : "+filePhysNm+"\n fileLgcNm : "+fileLgcNm);
//		///----- fileNo 처리 및 체크-----
//		if ( fileNo.length == 0 || fileNoSeq.length == 0 ) {
//			ComShowMessage(ComGetMsg("TPB90008")); // 처리시 에러가 발생하였습니다. 
//			return; 
//		}
//
//		nowFileNo = form.fileNo.value; 
//
//		// ComShowMessage( " nowFileNo : " + nowFileNo + "\n fileNo : " + fileNo + " \n fileNoSeq " + fileNoSeq );
//		if ( nowFileNo == null || nowFileNo == undefined || nowFileNo.length == 0 ) {
//			form.fileNo.value = fileNo; 
//			this.fileNo = fileNo;
//		} else if ( nowFileNo == fileNo ) {
//			// 정상
//			// ComShowMessage ( "nowFileNo == fileNo" ); 
//		} else {
//			// ComShowMessage (ComGetMsg("TPB90008")); // 처리시 에러가 발생하였습니다.
//			return; 
//		}
//
//		///----- 신규 add 처리 -----
//		var idx = GetFileIndex(form); // showErrMessage( idx ); 
//		var tempFullName = form.fileObj.value; 
//
//		fileNowIdx = idx; /// 
//
//		var tempFileName = GetFileName(tempFullName); 
//		fileNameArr[fileNowIdx] = GetFileName(tempFullName); 
//
//		if ( downloadLink!="Y" ) { 
//			fileChkNameArr[fileNowIdx] = "<input type=checkbox name=chkFile"+fileNowIdx+" class='trans' OnClick='SetFileDelCheck(this, "+fileNowIdx+")'>"+tempFileName+"<br>";
//		} else {
//			fileChkNameArr[fileNowIdx] = "<input type=checkbox name=chkFile"+fileNowIdx+" class='trans' OnClick='SetFileDelCheck(this, "+fileNowIdx+")'>";
//			// fileChkNameArr[fileNowIdx] += "<a href='#' onclick=\"fileDownLoad('"+tempFileName+"', '"+filePathNm+"', TPBFilePath, '');\">"+tempFileName+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
//			fileChkNameArr[fileNowIdx] += "<a href='#' onclick=\"fileDownLoad('"+filePhysNm+"', '"+fileLgcNm+"', '"+filePathNm+"', '');\">"+fileLgcNm+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
//		}
//
//		fileNoSeqArr[fileNowIdx] = fileNoSeq;
//		if ( downloadLink=="Y" ) { filePathNmArr[fileNowIdx] = filePathNm; }
//		
//		TPBFileCount++;
//		spanFileNameList.innerHTML += fileChkNameArr[fileNowIdx];
//	}
//
//	///===== 빈 index 찾기 =====
//	function GetFileIndex(form){
//		var idx = -1;
//		if ( fileNameArr==null ) { 
//			fileNameArr = new Array(); 
//		}
//
//		for ( i=0; i<fileNameArr.length; i++ ) { 
//			if ( fileNameArr[i] == null && fileNameArr[i].length == 0 ) {
//				idx = i; 
//				break; 
//			}
//		}
//		if ( idx == -1 ) {
//			fileNowIdx++; 
//			fileNameArr[fileNowIdx] = "";
//			idx = fileNowIdx
//		}
//		return idx; 
//	}
//
//	///===== file name 얻기 =====
//	function GetFileName(fullName){
//		var fileName = "";
//		if ( fullName != null && fullName != undefined ) {
//			var arr = fullName.split("\\");
//			fileName = arr[arr.length-1];
//			arr = null;
//		} 
//		return fileName;
//	}
//
//	///=====  delete file check 찾기 =====
//	function SetFileDelCheck(obj, no){
//		if ( obj.checked ) {
//			var temp = -1; 
//			for( i=0; i<fileDelChkArr.length; i++ ) { 
//				if ( fileDelChkArr[i] == null ) {
//					fileDelChkArr[i] = no;
//					temp = i;
//					break; 
//				}
//			}
//			if ( temp == -1 ) {
//				fileDelChkArr[fileDelChkArr.length] = no;
//			}
//		} else {
//			for( i=0; i<fileDelChkArr.length; i++ ) { 
//				if ( fileDelChkArr[i] == no ) {
//					fileDelChkArr[i] = null;
//					break; 
//				}
//			}
//		}
//		//fileDelChkArr = ArraryArrange(fileDelChkArr);
//	}
//
//	///===== 배열 정렬 & null data 삭제 =====
//	function ArraryArrange(arr){
//		var i = 0 ;
//		if ( arr!=null && arr!=undefined && arr.length > 0 ) { 
//			arr = arr.sort();
//			i = 0;
//			while( arr[arr.length-1]==null || arr[arr.length-1]=="" ) {
//				arr.pop();
//				if ( i++ > 20 ) { break; }
//			}
//		}
//		return arr;
//	}
//
//	///===== 파일삭제 버튼 클릭시 =====
//	function DeleteFile(form, form2){
//		// 삭제 처리 
//		form2.delFileNoSeqs.value = "";
//
//		var delFileNoSeqsTemp = "";
//		var temp;
//
//		if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
//			for( i=0; i<fileDelChkArr.length; i++ ) {
//				temp = fileDelChkArr[i];
//				if ( temp==null ) { continue; }
//				delFileNoSeqsTemp += fileNoSeqArr[temp]+"|"; 
//			}
//		}
//		//ComShowMessage(" delFileNoSeqsTemp : "+delFileNoSeqsTemp+"\n form1.fileNo.value : "+form1.fileNo.value+"\n form1.filePhysNm.value : "+form1.filePhysNm.value);
//		
//		form2.delFileNoSeqs.value = delFileNoSeqsTemp;
//		form2.fileNo.value = form1.fileNo.value;
//		form2.filePhysNm.value = form1.filePhysNm.value;
//		form2.f_cmd.value = REMOVE;
//		form2.target = "ifrm1";
//		form2.action = "TPBFileUploadProc.do";
//		form2.submit();
//
//		// DeleteFileAfterFileDelete(form) ==> target page에서 
//
//	}
//
//	///===== 파일삭제 처리 후 =====
//	function DeleteFileAfterFileDelete(form, successFlag, filePhysNm){ 
//
//		var deleteFileCount = 0; /// 삭제되는 파일 수 
//
//		// 삭제처리 후 
//		if ( successFlag == "true" ) {
//			var temp; 
//			if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
//				for( i=0; i<fileDelChkArr.length; i++ ) {
//					temp = fileDelChkArr[i];
//					if ( temp==null ) { continue; }
//					//eval( "spanFile"+temp+".innerHTML = '"+temp+" <input type=file name="+"fileObj"+""+temp+"><br>';" ); 
//					fileNameArr[temp] = "";
//					fileChkNameArr[temp] = "";
//					fileNoSeqArr[temp] = "";
//					if ( downloadLink=="Y" ) { filePathNmArr[temp] = ""; }
//					deleteFileCount++;
//				}
//
//				tempStr = "";
//				for ( i=0; i<fileChkNameArr.length; i++ ) { 
//					tempStr += fileChkNameArr[i]; 
//				}
//				spanFileNameList.innerHTML = tempStr; 
//			}
//
//			fileDelChkArr = new Array(); /// 처리 후 초기화
//		} else {
//			// ComShowMessage( getMsg('TPB90008') ); // 처리시 에러가 발생하였습니다. 
//		}
//		TPBFileCount -= deleteFileCount; 
//		if ( TPBFileCount < 0 ) { 
//			TPBFileCount=0; 
//		}
//	}

	//===== ok button click ===========
	function btn_ok_onclick() {
	    
	    if ( modalWindow!="Y"){
    		//ComShowMessage( "opener." + targetFnc + "('"+fileNo+"');" );
    		if ( targetFnc.length > 0 && forcedClose==false ) {
    			eval( "parent." + targetFnc + "('"+fileNo+"');" ); /// opener 측에 fileNo 전달을 위한 opener 함수 실행
    		}
    		ComClosePopup()
	    } else {
	        window.returnValue = fileNo.toString();
	        ComClosePopup()
	    }
	}
	
