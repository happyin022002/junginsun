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
	var fileNowIdx = -1; /// count
	var fileNameArr = new Array(); /// 파일명 (논리 파일명)
	var fileChkNameArr = new Array(); /// 체크명 배열
	var fileDelChkArr = new Array(); /// 삭제 체크 값 배열

	var fileNo = null; /// fileNo
	var fileNoSeqArr = new Array(); /// fileNoSeq 배열
	var filePathNmArr = new Array(); /// filePathNm 배열 (물리 파일명)

	var targetFnc = ""; /// opener로 넘기는데 실행할 opener측 함수
	var downloadLink = ""; /// download Link 여부 Y / N

	var forcedClose = false;
	
	var modalWindow = "N";

	/// load page
	function loadPage(targetVar1, downloadLinkVal){
		targetFnc = targetVar1; 
		downloadLink = downloadLinkVal; 
		if ( downloadLink != "Y" ) {
			downloadLink = "N"; 
		}
	}

	/// Add Button OnClick
	function AddButton_onclick(){		
		if ( TPBFileCount >= TPBMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("TPB90029"));
			return;
		}
	}

	/// spanFile Layer Control
	function AddButton_onmouseover(){
		if ( TPBFileCount >= TPBMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("TPB90029"));
			return;
		}
	
		spanFile.style.dispay = "";
	}

	function AddButton_onmousemove(){
		if ( TPBFileCount >= TPBMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("TPB90029"));
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

	function disappearPoint(){
		//setTimeout("spanFile.style.left = 0;",100);
		spanFile.style.dispay = "none";
		spanFile.style.left = 0; 
		spanFile.style.top = 0; 
		document.focus();
	}

	function fileObj_onchange(){
		if ( TPBFileCount >= TPBMaxFileCount ) { // File Count Constraint
			ComShowMessage(ComGetMsg("TPB90029"));
			return;
		}
		AddFile(document.forms[0]);
	}


///////////////////////////////////////////

	function GetArrayValues(arr, title){
		var str = "<br> " + title + " : <br>";
		if ( arr!=null && arr!=undefined && arr.length > 0 ) { 
			for ( var i=0; i<arr.length; i++ ) {
				str += arr[i] + " | ";
			}
		} else {
			str += ComGetMsg('TPB90030');
		}
		return str;
	}

	///===== 파일추가 버튼 클릭시 =====
	function AddFile(form){
		var tempFullName = form.fileObj.value; 

		if ( tempFullName.length > 0 ) {
			form.f_cmd.value = ADD;
			form.target = "ifrm1";
			form.action = "TPBFileUploadProc.do";
			form.submit();
			
			// AddFileAfterFileupload(form); .... target page에서 
		} else {
		}
	}

	///===== 파일추가 처리 후 =====
	function AddFileAfterFileupload(form, fileNo, fileNoSeq, filePhysNm, fileLgcNm, filePathNm){
		// ComShowMessage(" form : "+form+"\n fileNo : "+fileNo+"\n fileNoSeq  : "+fileNoSeq+"\n filePhysNm : "+filePhysNm+"\n fileLgcNm : "+fileLgcNm);
		///----- fileNo 처리 및 체크-----
		if ( fileNo.length == 0 || fileNoSeq.length == 0 ) {
			ComShowMessage(ComGetMsg("TPB90008")); // 처리시 에러가 발생하였습니다. 
			return; 
		}

		nowFileNo = form.fileNo.value; 

		// ComShowMessage( " nowFileNo : " + nowFileNo + "\n fileNo : " + fileNo + " \n fileNoSeq " + fileNoSeq );
		if ( nowFileNo == null || nowFileNo == undefined || nowFileNo.length == 0 ) {
			form.fileNo.value = fileNo; 
			this.fileNo = fileNo;
		} else if ( nowFileNo == fileNo ) {
			// 정상
			// ComShowMessage ( "nowFileNo == fileNo" ); 
		} else {
			// ComShowMessage (ComGetMsg("TPB90008")); // 처리시 에러가 발생하였습니다.
			return; 
		}

		///----- 신규 add 처리 -----
		var idx = GetFileIndex(form); // showErrMessage( idx ); 
		var tempFullName = form.fileObj.value; 

		fileNowIdx = idx; /// 

		var tempFileName = GetFileName(tempFullName); 
		fileNameArr[fileNowIdx] = GetFileName(tempFullName); 

		if ( downloadLink!="Y" ) { 
			fileChkNameArr[fileNowIdx] = "<input type=checkbox name=chkFile"+fileNowIdx+" class='trans' OnClick='SetFileDelCheck(this, "+fileNowIdx+")'>"+tempFileName+"<br>";
		} else {
			fileChkNameArr[fileNowIdx] = "<input type=checkbox name=chkFile"+fileNowIdx+" class='trans' OnClick='SetFileDelCheck(this, "+fileNowIdx+")'>";
			// fileChkNameArr[fileNowIdx] += "<a href='#' onclick=\"fileDownLoad('"+tempFileName+"', '"+filePathNm+"', TPBFilePath, '');\">"+tempFileName+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
			fileChkNameArr[fileNowIdx] += "<a href='#' onclick=\"fileDownLoad('"+filePhysNm+"', '"+fileLgcNm+"', '"+filePathNm+"', '');\">"+fileLgcNm+"</a><br>"; // fileDownLoad(physicalFileNm, logicalFileNm, filePlace, fileRepositoryId) 
		}

		fileNoSeqArr[fileNowIdx] = fileNoSeq;
		if ( downloadLink=="Y" ) { filePathNmArr[fileNowIdx] = filePathNm; }
		
		TPBFileCount++;
		spanFileNameList.innerHTML += fileChkNameArr[fileNowIdx];
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
			fileNowIdx++; 
			fileNameArr[fileNowIdx] = "";
			idx = fileNowIdx
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
		//fileDelChkArr = ArraryArrange(fileDelChkArr);
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
		var temp;

		if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
			for( i=0; i<fileDelChkArr.length; i++ ) {
				temp = fileDelChkArr[i];
				if ( temp==null ) { continue; }
				delFileNoSeqsTemp += fileNoSeqArr[temp]+"|"; 
			}
		}
		//ComShowMessage(" delFileNoSeqsTemp : "+delFileNoSeqsTemp+"\n form1.fileNo.value : "+form1.fileNo.value+"\n form1.filePhysNm.value : "+form1.filePhysNm.value);
		
		form2.delFileNoSeqs.value = delFileNoSeqsTemp;
		form2.fileNo.value = form1.fileNo.value;
		form2.filePhysNm.value = form1.filePhysNm.value;
		form2.f_cmd.value = REMOVE;
		form2.target = "ifrm1";
		form2.action = "TPBFileUploadProc.do";
		form2.submit();

		// DeleteFileAfterFileDelete(form) ==> target page에서 

	}

	///===== 파일삭제 처리 후 =====
	function DeleteFileAfterFileDelete(form, successFlag, filePhysNm){ 

		var deleteFileCount = 0; /// 삭제되는 파일 수 

		// 삭제처리 후 
		if ( successFlag == "true" ) {
			var temp; 
			if ( fileDelChkArr != null && fileDelChkArr!=undefined ) { 
				for( i=0; i<fileDelChkArr.length; i++ ) {
					temp = fileDelChkArr[i];
					if ( temp==null ) { continue; }
					//eval( "spanFile"+temp+".innerHTML = '"+temp+" <input type=file name="+"fileObj"+""+temp+"><br>';" ); 
					fileNameArr[temp] = "";
					fileChkNameArr[temp] = "";
					fileNoSeqArr[temp] = "";
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
		} else {
			// ComShowMessage( getMsg('TPB90008') ); // 처리시 에러가 발생하였습니다. 
		}
		TPBFileCount -= deleteFileCount; 
		if ( TPBFileCount < 0 ) { 
			TPBFileCount=0; 
		}
	}

	//===== ok button click ===========
	function btn_ok_onclick() {
	    
	    if ( modalWindow!="Y"){
    		//ComShowMessage( "opener." + targetFnc + "('"+fileNo+"');" );
    		if ( targetFnc.length > 0 && forcedClose==false ) {
    			eval( "opener." + targetFnc + "('"+fileNo+"');" ); /// opener 측에 fileNo 전달을 위한 opener 함수 실행
    		}
    		window.close();
	    } else {
	        window.returnValue = fileNo.toString();
	        window.close();
	    }
	}
	
