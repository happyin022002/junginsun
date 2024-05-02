/*=========================================================
*@FileName : EES_CIM_0065.js
*Copyright(c) 2011 CyberLogitec
*@FileTitle : UC File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.09
*@LastModifier : Do-Hyun Kim
*@LastVersion : 1.0
* 1.0 최초 생성
-------------------------------------------------------------------
* History
=========================================================*/

	/// file 관련 변수
	// var fileObjInitName = "fileObj"; 
	var ucCgoFileIdwIdx = -1; /// count
	var fileNameArr = new Array(); /// 파일명 (논리 파일명)
	var fileChkNameArr = new Array(); /// 체크명 배열
	var fileDelChkArr = new Array(); /// 삭제 체크 값 배열

	var ucCgoFileId = null; /// ucCgoFileId
	var ucCgoFileIdSeqArr = new Array(); /// ucCgoFileIdSeq 배열
	var filePathNmArr = new Array(); /// filePathNm 배열 (물리 파일명)
	var fileSavIdArr = new Array(); /// fileSavId 배열 (파일명)

	var targetFnc = ""; /// opener로 넘기는데 실행할 opener측 함수
	var downloadLink = ""; /// download Link 여부 Y / N

	var forcedClose = false;
	
	var modalWindow = "N";
	var ucCgoFileIdGb = "UCA";
	
	// 전역변수 - clooney
//	var FileUploadPopupWin = null; // File Upload PopupWindow Object
	var CIMFilePath = ""; // file download시 사용, file path
	var CIMFileCount = 0; // file download시 사용, current file count
	var CIMMaxFileCount = 50; // file download시 사용, available maximum file count 


	/// load page
	function loadPage(targetVar1, downloadLinkVal){
		targetFnc = targetVar1; 
		downloadLink = downloadLinkVal; 
		if ( downloadLink != "Y" ) {
			downloadLink = "N"; 
		}
	}

	/// Add Button OnClick - Add 버튼 이벤트
	function AddButton_onclick(){		
		if ( CIMFileCount >= CIMMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("CIM30028"));
			return;
		}
	}

	/// spanFile Layer Control - Add 버튼 이벤트
	function AddButton_onmouseover(){
		if ( CIMFileCount >= CIMMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("CIM30028"));
			return;
		}
	
		spanFile.style.dispay = "";
	}

	/// Add 버튼 이벤트
	function AddButton_onmousemove(){

		if ( CIMFileCount >= CIMMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("CIM30028"));
			return;
		}

		var x, y; 
		if (document.layers) {
			x = Event.MOUSEMOVE.pageX; 
			y = Event.MOUSEMOVE.pageY; 
		} else { 
			x = event.x; 
			y = event.y;
		}
		spanFile.style.left = x - 5; 
		spanFile.style.top = y - 4; 
	}

	/// Add 버튼 이벤트
	function disappearPoint(){
		spanFile.style.dispay = "none";
		spanFile.style.left = 0; 
		spanFile.style.top = 0; 
		document.focus();
	}

	/// Add 버튼 이벤트
	function fileObj_onchange(){
		if ( CIMFileCount >= CIMMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("CIM30028"));
			return;
		}
		AddFile(document.forms[0]);
	}


///////////////////////////////////////////
	// ?
	function GetArrayValues(arr, title){
		var str = "<br> " + title + " : <br>";
		if ( arr!=null && arr!=undefined && arr.length > 0 ) { 
			for ( var i=0; i<arr.length; i++ ) {
				str += arr[i] + " | ";
			}
		} else {
			str += ComGetMsg('CIM30029');
		}
		return str;
	}

	///===== 파일추가 버튼 클릭시 =====
	function AddFile(form){
		var tempFullName = form.fileObj.value; 

		if ( tempFullName.length > 0 ) {
			form.f_cmd.value = ADD;
			form.target = "ifrm1";
			form.action = "EES_CIM_0067.do";
			form.submit();
			
			// AddFileAfterFileupload(form); .... target page에서 
		} else {
		}
	}

	///===== 파일추가 처리 후 =====
	function AddFileAfterFileupload(form, ucCgoFileId, ucCgoFileIdSeq, fileSavId, fileLgcNm, filePathNm){
		///----- ucCgoFileId 처리 및 체크-----
		if ( ucCgoFileId.length == 0 || ucCgoFileIdSeq.length == 0 ) {
			ComShowMessage(ComGetMsg("CIM30030")); // 처리시 에러가 발생하였습니다. 
			return; 
		}

		nowUcCgoFileId = form.ucCgoFileId.value; 

		if ( nowUcCgoFileId == null || nowUcCgoFileId == undefined || nowUcCgoFileId.length == 0 ) {
			form.ucCgoFileId.value = ucCgoFileId; 
			this.ucCgoFileId = ucCgoFileId;
		} else if ( nowUcCgoFileId == ucCgoFileId ) {
			// 정상
			// ComShowMessage ( "nowUcCgoFileId == ucCgoFileId" ); 
		} else {
			// ComShowMessage (ComGetMsg("CIM30030")); // 처리시 에러가 발생하였습니다.
			return; 
		}

		///----- 신규 add 처리 -----
		var idx = GetFileIndex(form); // showErrMessage( idx ); 
		var tempFullName = form.fileObj.value; 

		ucCgoFileIdwIdx = idx; /// 

		var tempFileName = GetFileName(tempFullName); 
		fileNameArr[ucCgoFileIdwIdx] = GetFileName(tempFullName); 

		if ( downloadLink!="Y" ) { 
			fileChkNameArr[ucCgoFileIdwIdx] = "<input type=checkbox name=chkFile"+ucCgoFileIdwIdx+" class='trans' OnClick='SetFileDelCheck(this, "+ucCgoFileIdwIdx+")'>"+tempFileName+"<br>";
		} else {
			fileChkNameArr[ucCgoFileIdwIdx] = "<input type=checkbox name=chkFile"+ucCgoFileIdwIdx+" class='trans' OnClick='SetFileDelCheck(this, "+ucCgoFileIdwIdx+")'>";
			// fileChkNameArr[ucCgoFileIdwIdx] += "<a href='#' onclick=\"fileDownLoad('"+tempFileName+"', '"+filePathNm+"', TPBFilePath, '');\">"+tempFileName+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
			fileChkNameArr[ucCgoFileIdwIdx] += "<a href='#' onclick=\"fileDownLoad('"+fileSavId+"', '"+fileLgcNm+"', '"+filePathNm+"', '');\">"+fileLgcNm+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
		}

		ucCgoFileIdSeqArr[ucCgoFileIdwIdx] = ucCgoFileIdSeq;
		fileSavIdArr[ucCgoFileIdwIdx] = fileSavId;
		
		if ( downloadLink=="Y" ) { filePathNmArr[ucCgoFileIdwIdx] = filePathNm; }
		
		CIMFileCount++;
		spanFileNameList.innerHTML += fileChkNameArr[ucCgoFileIdwIdx];
		
		if(ucCgoFileIdGb == 'UCA'){
			window.dialogArguments.loadPage();
		}		
	}

	///===== 빈 index 찾기 =====
	function GetFileIndex(form){
		var idx = -1;
		if ( fileNameArr==null ) { 
			fileNameArr = new Array(); 
		}

		for ( i=0; i<fileNameArr.length; i++ ) { 
			if ( fileNameArr[i] == null && fileNameArr[i].length == 0 ) {
				idx = i; 
				break; 
			}
		}
		if ( idx == -1 ) {
			ucCgoFileIdwIdx++; 
			fileNameArr[ucCgoFileIdwIdx] = "";
			idx = ucCgoFileIdwIdx
		}
		return idx; 
	}

	///===== file name 얻기 =====
	function GetFileName(fullName){
		var fileName = "";
		if ( fullName != null && fullName != undefined ) {
			var arr = fullName.split("\\");
			fileName = arr[arr.length-1];
			arr = null;
		} 
		return fileName;
	}

	///=====  delete file check 찾기 =====
	function SetFileDelCheck(obj, no){
		if ( obj.checked ) {
			var temp = -1; 
			for( i=0; i<fileDelChkArr.length; i++ ) { 
				if ( fileDelChkArr[i] == null ) {
					fileDelChkArr[i] = no;
					temp = i;
					break; 
				}
			}
			if ( temp == -1 ) {
				fileDelChkArr[fileDelChkArr.length] = no;
			}
		} else {
			for( i=0; i<fileDelChkArr.length; i++ ) { 
				if ( fileDelChkArr[i] == no ) {
					fileDelChkArr[i] = null;
					break; 
				}
			}
		}
	}

	///===== 배열 정렬 & null data 삭제 =====
	function ArraryArrange(arr){
		var i = 0 ;
		if ( arr!=null && arr!=undefined && arr.length > 0 ) { 
			arr = arr.sort();
			i = 0;
			while( arr[arr.length-1]==null || arr[arr.length-1]=="" ) {
				arr.pop();
				if ( i++ > 20 ) { break; }
			}
		}
		return arr;
	}

	///===== 파일삭제 버튼 클릭시 =====
	function DeleteFile(form, form2){

		// 삭제 처리 
		form2.delFileNoSeqs.value = "";

		var delFileNoSeqsTemp = "";
		var delfileSavIdTemp = "";
		var temp;

		if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
			for( i=0; i<fileDelChkArr.length; i++ ) {
				temp = fileDelChkArr[i];
				if ( temp==null ) { continue; }
				delFileNoSeqsTemp += ucCgoFileIdSeqArr[temp]+"|"; 
				delfileSavIdTemp += fileSavIdArr[temp]+"|"; 
			}
		}
		
		
		if ( fileDelChkArr.length == 0 ) {
			ComShowMessage(ComGetMsg("CIM00010"));
			return;
		}
		
		//alert(' [delFileNoSeqsTemp]10 : '+delFileNoSeqsTemp);
		//alert(' [delfileSavIdTemp]20 : '+delfileSavIdTemp);
		form2.delFileNoSeqs.value = delFileNoSeqsTemp;
		form2.ucCgoFileId.value = form1.ucCgoFileId.value;
		form2.fileSavId.value = delfileSavIdTemp;
		form2.f_cmd.value = REMOVE;
		form2.target = "ifrm1";
		form2.action = "EES_CIM_0067.do";
		form2.submit();
		// DeleteFileAfterFileDelete(form) ==> target page에서 

	}

	///===== 파일삭제 처리 후 =====
	function DeleteFileAfterFileDelete(form, successFlag, fileSavId){
		//alert('파일삭제 처리 후');

		var deleteFileCount = 0; /// 삭제되는 파일 수 

		// 삭제처리 후 
		if ( successFlag == "true" ) {
			var temp; 
			if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
				for( i=0; i<fileDelChkArr.length; i++ ) {
					temp = fileDelChkArr[i];
					if ( temp==null ) { continue; }
					fileNameArr[temp] = "";
					fileChkNameArr[temp] = "";
					ucCgoFileIdSeqArr[temp] = "";
					if ( downloadLink=="Y" ) { filePathNmArr[temp] = ""; }
					deleteFileCount++;
				}

				tempStr = "";
				for ( i=0; i<fileChkNameArr.length; i++ ) { 
					tempStr += fileChkNameArr[i]; 
				}
				spanFileNameList.innerHTML = tempStr; 
			}

			fileDelChkArr = new Array(); /// 처리 후 초기화
			
			if(ucCgoFileIdGb == 'UCA'){
				window.dialogArguments.loadPage();
			}
			
		} else {
			// ComShowMessage( getMsg('CIM30030') ); // 처리시 에러가 발생하였습니다. 
		}
		CIMFileCount -= deleteFileCount; 
		if ( CIMFileCount < 0 ) { 
			CIMFileCount=0; 
		}
	}

	//===== ok button click ===========
	function btn_ok_onclick() {
		window.close();		
	}
	
