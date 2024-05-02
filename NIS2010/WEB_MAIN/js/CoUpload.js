/**
===============================================================================
프로그램  명  : 파일업로드 처리 관련 공통 함수 정의 Script
프로그램개요  : 파일 업로드 전송 함수 정의
작   성   자  : 김정훈
작   성   일  : 2009-04
===============================================================================
수정자/수정일 : 
수정사유/내역 : 
===============================================================================
*/
	/**
     * @fileoverview fileupload 관련 함수가 정의되어 있다.
     * @author 한진해운
	 */
	function openUpload(subSysCd, flag, fileCnt){
		if(flag == undefined){
			return window.showModalDialog("/hanjin/FileUploadPopup.do?subSysCd="+subSysCd+"&usrFileCnt="+fileCnt,"uploadPopup","dialogWidth:520px;dialogHeight:290px;status:no");
		} else{
			return window.showModalDialog("/hanjin/FileUploadPopup.do?subSysCd="+subSysCd+"&flag="+flag+"&usrFileCnt="+fileCnt,"uploadPopup","dialogWidth:520px;dialogHeight:290px;status:no");
		}
	}
